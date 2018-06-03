$(document).ready(function(){
    var globalSubmittedFormData;
    //Setup final step navigation
    $("#example-vertical").steps({
        headerTag: "h3",
        bodyTag: "section",
        transitionEffect: "slideLeft",
        stepsOrientation: "vertical",
        onFinished: function (event, currentIndex) {
            $('#example-vertical').remove();
            //Clear backgroundColor (White)
            $('body').css("background-color", "#FFFFFF");
            alertify.confirm('Process finished successfully!',
                'If you wish to overwrite the submitted form and refill press "Retry", otherwise press "Done"',
                function(){
                    $.ajax({
                            type: "DELETE",
                            url: url + "/submittedForms/deleteSubmittedFormById/" + globalSubmittedFormData.id,
                            success: function (data) {
                                window.location = window.location.href;
                                alertify.success('Redirecting to start...');
                            },
                            error: function (e) {
                                alertify.error('Fail deleting submitted form, id' + globalSubmittedFormData.id);
                            }
                        }
                    );
                } ,
                function(){}
                ).set('labels', {ok:'Retry', cancel:'Done'});;
        },
    });

    $('.button').hide();
    var url = window.location.href;
    $.ajax({
        type: "GET",
        url: url + "/forms/getForms",
        success: function (data) {
            var formsSelect =  $('.initialSelect');
            $.each(data, function(key, value) {
                formsSelect.append($("<option></option>")
                    .attr("value",value.formId)
                    .text(value.formName));
            });
        },
        error: function (e) {
            alertify.error('An Error occurred');
        }
    }
    );

    function removeSectionsAndLi() {
        $('.section').each(function( index ) {
            if (index !== 0){
                $( this ).remove();
            }
        });
        $('.form_steps li').each(function( index ) {
            if (index !== 0){
                $( this ).remove();
            }
        });
    }

    function bindButtons(sectionLength){
        $('.button').bind("click", function(e) {
            var formId = $('select[class=formsSelect]').val();
            if ($("#name").val() == "" ){
                alertify.error('Username field cant be empty!');
                return;
            }
            if($("#Client").val() == ""){
                alertify.error('Client field cant be empty!');
                return;
            }
            if (formId == "0"){
                alertify.error('Please select a form to fill!');
                return;
            }
            if ($("#rating").val() === "0"){
                alertify.error('Please select borrower rating!');
                return;
            }

            var button = $(this);
            var currentSection = button.parents(".section");

            //Check that all DropDown were picked
            var currentQuestions = currentSection.find('.question');
            for(i=0;i<currentQuestions.length;i++){
                if ($(currentQuestions[i]).find("option:selected").attr('id') == -1){
                    alertify.error('Please select the suitable option in all questions');
                    return;
                }
            }

            var currentSectionIndex = currentSection.index();
            var headerSection = $('.form_steps li').eq(currentSectionIndex);
            currentSection.removeClass("is-active").next().addClass("is-active");
            headerSection.removeClass("is-active").next().addClass("is-active");

            $(".form-wrapper").submit(function(e) {
                e.preventDefault();
            });

            topFunction();
        });
    }

    function submitForm() {
        //Check that all DropDown were picked
        var button = $(this);
        var currentSection = button.parents(".section");
        var currentQuestions = currentSection.find('.question');
        for(i=0;i<currentQuestions.length;i++){
            if ($(currentQuestions[i]).find("option:selected").attr('id') == -1){
                return;
            }
        }
        var categories = $(".section");
        var submittedFormData = { "qa" : []};
        var formScore = 0;
        var finalTableColumnsData = [];
        var counter =0;
        for (i=1;i<categories.length;i++) {
            var jQueryCategoryItem = $(categories[i]);
            var catPercent = jQueryCategoryItem.attr('id');
            var categoryQuestions = $(jQueryCategoryItem.find(".question select"));
            var categoryQuestionsTexts = $(jQueryCategoryItem.find(".question h4"));
            var categorySelectedAnswersScore = jQueryCategoryItem.find(".question option:selected");
            var catScoreSum = 0;
            for (j=0;j<categorySelectedAnswersScore.length;j++){
                counter++;
                var questionWeight = $(categoryQuestions[j]).attr('id');
                var answerScore = $(categorySelectedAnswersScore[j]).attr('id');
                var effectiveScore =   ( ( catPercent /100) * (questionWeight / 100) * answerScore );
                catScoreSum+=  (questionWeight * answerScore) / 100 ;
                submittedFormData.qa.push({"questionText":categoryQuestionsTexts[j].innerText.slice(3,-1),"answerText":categorySelectedAnswersScore[j].text});
                //Set final table data objects
                finalTableColumnsData.push([counter.toString(),categoryQuestionsTexts[j].innerText.slice(3,-1),categorySelectedAnswersScore[j].text,catPercent.toString()+'%',questionWeight.toString()+'%',answerScore.toString(),effectiveScore.toPrecision(2).toString()]);
            }
            formScore += ( catPercent * catScoreSum) / 100;
        }

        formScore = formScore.toPrecision(3);
        var accountName = $('#name').val();
        var customerName = $('#Client').val();
        var borrowerRating = $('#rating').val();

        var jsonData = JSON.stringify({
            accountOfficeName: accountName,
            customerName: customerName,
            borrowerRating: borrowerRating,
            pdScore: formScore,
            submittedFormRawData: submittedFormData
        })
        topFunction();

        $.ajax({
            type: "POST",
            url:  url + "/submittedForms/submitForm",
            contentType: 'application/json; charset=UTF-8',
            data: jsonData,
            success: function (registeredFormData) {
                //Set global submittedForm
                globalSubmittedFormData = registeredFormData;
                //get the closable setting value.
                var closable = alertify.alert().setting('closable');
                //grab the dialog instance using its parameter-less constructor then set multiple settings at once.
                alertify.alert()
                    .setting({
                        'label':'Show Results Comparison',
                        'title' : 'Form submitted successfully!',
                        'message': 'Based on your assessment the score of ' + registeredFormData.customerName +' is: ' +registeredFormData.pdScore + '!' ,
                        'onok': function(){ getChartData(registeredFormData,finalTableColumnsData);}
                    }).show();
            },
            error: function (e) {
                alertify.error('An Error occurred');
            }
        });
    }

    // When the user clicks on the button, scroll to the top of the document
    function topFunction() {
        document.body.scrollTop = 0;
        document.documentElement.scrollTop = 0;
    }

    function loadFormData(formId){
        $.ajax({
            type: "GET",
            url:  url + "/forms/" + formId,
            success: function (data) {
                //Append form htmlData
                $(".form-wrapper").append(data);

                var categories = $(".form-wrapper h3");
                //Append items to wizard list header
                var sectionLength = $(".section").length;
                var liItems = "";
                for (i = 1; i < sectionLength; i++) {
                    liItems += '<li> ' + categories[i].innerHTML + '</li>';
                }
                $(".form_steps").append(liItems);
                //Format question UI
                var questionList = $(".question h4");
                for (i = 0; i < questionList.length; i++) {
                    $(".question h4")[i].innerText =  (i+1) + ") " + $(".question h4")[i].innerText + ": ";
                }

             //   $('.formsSelect').on('change', function (event) {
             //       var catPercentage = $(this).parents(".section").attr('id');
             //       var questionPercentage = event.target.id;
             //       var answerGrade = $("option:selected", this).attr('id');
             //       if (answerGrade != -1){
             //           var accGrade = ( catPercentage / 100 ) * ( questionPercentage / 100 ) * answerGrade;
             //           $(this.parentElement).find("span").text("Effective Score: " +accGrade.toPrecision(2));
             //       }
             //       else{
             //           $(this.parentElement).find("span").text("Effective Score: 0.00");
             //       }
             //   });

                //Bind click function to all buttons
                bindButtons(sectionLength);
                //Set on click function to last button and change text to submit
                var buttonArray = $(".button");
                buttonArray[buttonArray.length - 1].innerText = "Submit";
                buttonArray[buttonArray.length - 1].onclick = submitForm;
                //Show all buttons after load
                $('.button').show();

            },
            error: function (e) {
                alertify.error('An Error occurred');
            }
        });
    }

    function getChartData(registeredFormData,finalTableColumnsData){
        //Remove data from page (div class container)
        $('.container').remove();
        //Clear backgroundColor (White)
        $('body').css("background-color", "#FFFFFF");
        $('html').css("background-color", "#FFFFFF");
        $.ajax({
            type: "GET",
            url: url + "/submittedForms/getSubmittedForms",
            success: function (submittedForms) {
                var ctx = document.getElementById('myChart').getContext('2d');
                //Setup chart
                var myChart = createChart(ctx,submittedForms,registeredFormData);
                //Setup table
                $('#tableSummary').DataTable( {
                    data: finalTableColumnsData,
                    scrollCollapse: false,
                    searching: false,
                   // lengthMenu: [[5,10, 20, -1], [5,10, 20, "All"]],
                    iDisplayLength: 5,
                    lengthChange: false,
                    paging:         true,
                    scrollY:        '50vh',
                    title : '',
                    columns: [
                        { title: "#" , "width": "10%" },
                        { title: "Question" , "width": "25%"},
                        { title: "Selected Answer" , "width": "25%" },
                        { title: "Category Weight" , "width": "10%"},
                        { title: "Question Weight" , "width": "10%"},
                        { title: "Selected Answer Score" , "width": "10%"},
                        { title: "Effective Score" , "width": "10%"}
                    ]
                } );
                //Show table and graph wizard
                $('#example-vertical').css("display", "block");
                var table = $('#tableSummary').DataTable();
                $('#container').css( 'display', 'block' );
                table.columns.adjust().draw();
            //    $('#all').on( 'click', function () {
            //        table.page.len( -1 ).draw();
            //    } );

            },
            error: function (e) {
                alertify.error('An Error occurred');
            }
        });
    }

    function createChart(ctx,submittedForms,registeredFormData){
        var xyisPoints = [{x:0,y:0},{x:1,y:0},{x:2,y:0},{x:3,y:0},{x:4,y:0},{x:5,y:0},{x:6,y:0},{x:7,y:0},{x:8,y:0},{x:9,y:0},{x:10,y:0}];
        var myRegisteredFormData = [{x:registeredFormData.borrowerRating,y:registeredFormData.pdScore}];
        var rating1=[],rating2=[],rating3=[],rating4=[],rating5=[],rating6=[],rating7=[],rating8=[],rating9=[],rating10=[];
        var point = 5;
        for (i=0;i<submittedForms.length;i++){
            switch(submittedForms[i].borrowerRating) {
                case 1:
                    rating1.push({x:submittedForms[i].borrowerRating,y:submittedForms[i].pdScore});
                    break;
                case 2:
                    rating2.push({x:submittedForms[i].borrowerRating,y:submittedForms[i].pdScore});
                    break;
                case 3:
                    rating3.push({x:submittedForms[i].borrowerRating,y:submittedForms[i].pdScore});
                    break;
                case 4:
                    rating4.push({x:submittedForms[i].borrowerRating,y:submittedForms[i].pdScore});
                    break;
                case 5:
                    rating5.push({x:submittedForms[i].borrowerRating,y:submittedForms[i].pdScore});
                    break;
                case 6:
                    rating6.push({x:submittedForms[i].borrowerRating,y:submittedForms[i].pdScore});
                    break;
                case 6:
                    rating6.push({x:submittedForms[i].borrowerRating,y:submittedForms[i].pdScore});
                    break;
                case 8:
                    rating8.push({x:submittedForms[i].borrowerRating,y:submittedForms[i].pdScore});
                    break;
                case 9:
                    rating9.push({x:submittedForms[i].borrowerRating,y:submittedForms[i].pdScore});
                    break;
                case 10:
                    rating10.push({x:submittedForms[i].borrowerRating,y:submittedForms[i].pdScore});
                    break;
            }
        }
        return new Chart(ctx, {
            type: 'scatter',
            data: {
                labels: 'Scatter DataSet',
                datasets: [
                    {
                        showLine : false,
                        label: '',
                        data: xyisPoints,
                        backgroundColor: 'rgba(255, 0, 0, 0)', //Opacity 0--> transparent
                        borderColor: 'rgba(255, 0, 0, 0)', //Opacity 0--> transparent
                    }
                    ,
                    {
                        showLine : false,
                        label: 'Current Assessment',
                        data: myRegisteredFormData,
                        backgroundColor: 'rgba(0,0,0)', //Black
                        borderColor: 'rgba(0,0,0)', //Black
                        pointRadius: point
                    }
                    ,
                    {
                        showLine : false,
                        label: 'Rating 1',
                        data: rating1,
                        backgroundColor: 'rgb(0, 204, 0)', //Dark Green
                        borderColor: 'rgb(0, 204, 0)', //Dark Green
                        pointStyle: 'cross',
                        pointRadius: point
                    }
                    ,
                    {
                        showLine : false,
                        label: 'Rating 2',
                        data: rating2,
                        backgroundColor: 'rgb(102, 204, 0)', //Light Green
                        borderColor: 'rgb(102, 204, 0)', //Light Green
                        pointStyle: 'star',
                        pointRadius: point
                    }
                    ,
                    {
                        showLine : false,
                        label: 'Rating 3',
                        data: rating3,
                        backgroundColor: 'rgb(221, 255, 51)', //Light Green with yellow tint
                        borderColor: 'rgb((221, 255, 51)', //Light Green with yellow tint
                        pointStyle:'circle',
                        pointRadius: point
                    }
                    ,
                    {
                        showLine : false,
                        label: 'Rating 4',
                        data: rating4,
                        backgroundColor: 'rgb(255, 255, 179)', //Bright Yellow
                        borderColor: 'rgb(255, 255, 179)', //Bright Yellow
                        pointRadius: point
                    }
                    ,
                    {
                        showLine : false,
                        label: 'Rating 5',
                        data: rating5,
                        backgroundColor: 'rgb(255, 225, 71)', //Yellow
                        borderColor: 'rgb(255, 225, 71)', //Yellow
                        pointStyle: 'rect',
                        pointRadius: point
                    }
                    ,
                    {
                        showLine : false,
                        label: 'Rating 6',
                        data: rating6,
                        backgroundColor: 'rgb(255, 178, 102)', //Light Orange
                        borderColor: 'rgb(255, 178, 102)', //Light Orange
                        pointStyle: 'circle',
                        pointRadius: point
                    }
                    ,
                    {
                        showLine : false,
                        label: 'Rating 7',
                        data: rating7,
                        backgroundColor: 'rgb(255, 128, 0)', //Dark Orange
                        borderColor: 'rgb(255, 128, 0)', //Dark Orange
                        pointStyle: 'triangle',
                        pointRadius: point
                    }
                    ,
                    {
                        showLine : false,
                        label: 'Rating 8',
                        data: rating8,
                        backgroundColor: 'rgb(243, 114, 88)', //Light Red
                        borderColor: 'rgb(243, 114, 88)', //Light Red
                        pointStyle: 'rectRot',
                        pointRadius: point
                    }
                    ,
                    {
                        showLine : false,
                        label: 'Rating 9',
                        data: rating9,
                        backgroundColor: 'rgb(255, 102, 102)', //Mid Red
                        borderColor: 'rgb(255, 102, 102)', //Mid Red
                        pointRadius: point
                    }
                    ,
                    {
                        showLine : false,
                        label: 'Rating 10',
                        data: rating10,
                        backgroundColor: 'rgb(204,0,0)', //Dark Red
                        borderColor: 'rgb(204,0,0)', //Dark Red
                        pointRadius: point
                    }

                ],
            },
            options: {
                responsive: true,
                legend: {
                    position: 'bottom',
                },
                hover: {
                    mode: 'index'
                },
                scales: {
                    xAxes: [{
                        display: true,
                        scaleLabel: {
                            display: true,
                            labelString: 'Borrower Rating'
                        }
                    }],
                    yAxes: [{
                        display: true,
                        scaleLabel: {
                            display: true,
                            labelString: 'Assessment Score'
                        }
                    }]
                },
                title: {
                    fontSize: 30,
                    display: true,
                    text: ['Score distribution per borrower rating','(Higher score means lower PD)']
                }
            }
        });
    }

    // On initial form list change
    $('.form-wrapper .initialSelect').change(function(){
        var formId = $('select[class=initialSelect]').val();
        if (formId == "0"){
            $('.button').hide();
            alertify.error('Please select a form to fill');
            return;
        }else{
            //Remove existing filedSet
            removeSectionsAndLi();
            //Load data
            loadFormData(formId);
        }
    });

});