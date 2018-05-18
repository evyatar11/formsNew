$(document).ready(function(){
    $('.button').hide();
    var url = window.location.href;
    $.ajax({
        type: "GET",
        url: url + "/forms/getForms",
        success: function (data) {
            var formsSelect =  $('.formsSelect');
            $.each(data, function(key, value) {
                formsSelect.append($("<option></option>")
                    .attr("value",value.formId)
                    .text(value.formName));
            });
        },
        error: function (e) {
            alertify.error('An Error occurred');
        }
    });

    function removeSectionsAndLi() {
        $('.section').each(function( index ) {
            if (index !== 0){
                $( this ).remove();
            }
        });
        $('.steps li').each(function( index ) {
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
            if ($("#rating").val() == ""){
                alertify.error('Please enter borrower rating!');
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
            var headerSection = $('.steps li').eq(currentSectionIndex);
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
        var formScore = 0;
        for (i=1;i<categories.length;i++) {
            var jQueryCategoryItem = $(categories[i]);
            var catPercent = jQueryCategoryItem.attr('id');
            var categoryQuestions = $(jQueryCategoryItem.find(".question select"));
            var categorySelectedAnswersScore = jQueryCategoryItem.find(".question option:selected");
            var catScoreSum = 0;
            for (j=0;j<categorySelectedAnswersScore.length;j++){
                catScoreSum+= $(categoryQuestions[j]).attr('id') * $(categorySelectedAnswersScore[j]).attr('id') / 100 ;
            }
            formScore += ( catPercent * catScoreSum) / 100;
        }

        formScore = formScore.toPrecision(5);
        var accountName = $('#name').val();
        var customerName = $('#Client').val();
        var borrowerRating = $('#rating').val();

        var jsonData = JSON.stringify({
            accountOfficeName: accountName,
            customerName: customerName,
            borrowerRating: borrowerRating,
            pdScore: formScore
        })
        topFunction();

        $.ajax({
            type: "POST",
            url:  url + "/forms/submitForm",
            contentType: 'application/json; charset=UTF-8',
            data: jsonData,
            success: function (registeredFormData) {
                //get the closable setting value.
                var closable = alertify.alert().setting('closable');
                //grab the dialog instance using its parameter-less constructor then set multiple settings at once.
                alertify.alert()
                    .setting({
                        'label':'Show Graph',
                        'title' : 'From submitted successfully!',
                        'message': 'Based on your assessment the score of ' + registeredFormData.customerName +' is: ' +registeredFormData.pdScore + '!' ,
                        'onok': function(){ getChartData(registeredFormData);}
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
                $(".steps").append(liItems);
                //Format question UI
                var questionList = $(".question h4");
                for (i = 0; i < questionList.length; i++) {
                    $(".question h4")[i].innerText =  (i+1) + ") " + $(".question h4")[i].innerText + ": ";
                }
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

    function getChartData(registeredFormData){
        //Remove data from page
        $('.container').remove();
        //Clear backgroundColor (White)
        $('body').css("background-color", "#FFFFFF");
        $('html').css("background-color", "#FFFFFF");
        $.ajax({
            type: "GET",
            url: url + "/forms/getSubmittedFormsByBorrowerRating/" + registeredFormData.borrowerRating,
            success: function (submittedFormsData) {
                var customerNames = [];
                var pdScores = [];
                var backgroundColors = [];
                var borderColors = [];
                for (i=0;i<submittedFormsData.length;i++){
                    customerNames.push(submittedFormsData[i].customerName);
                    pdScores.push(submittedFormsData[i].pdScore);
                    if (submittedFormsData[i].id == registeredFormData.id){
                        //Red color and border - the newly filled form
                        backgroundColors.push('rgba(255, 99, 132, 0.2)');
                        borderColors.push('rgba(255,99,132,1)');
                    }
                    else{
                        //Green color and border - the rest
                        backgroundColors.push('rgba(75, 192, 192, 0.2)');
                        borderColors.push('rgba(75, 192, 192, 1)');
                    }
                }
                var ctx = document.getElementById('myChart').getContext('2d');
                var myChart = createChart(ctx,customerNames,pdScores,backgroundColors,borderColors,registeredFormData.borrowerRating);
            },
            error: function (e) {
                alertify.error('An Error occurred');
            }
        });
    }

    function createChart(ctx,customerNames,pdScores,backgroundColors,borderColors,currentFormRating){
        return new Chart(ctx, {
            type: 'horizontalBar',
            data: {
                labels: customerNames,
                datasets: [{
                    label: 'Score',
                    data: pdScores,
                    backgroundColor: backgroundColors,
                    borderColor: borderColors,
                    borderWidth: 1
                }]
            },
            options: {
                scales: {
                    yAxes: [{
                        ticks: {
                            beginAtZero:true
                        }
                    }]
                },
                title: {
                    fontSize: 20,
                    display: true,
                    text: ['Scores results of borrowers with rating of ' +  currentFormRating + ' ' , '(Higher score means lower PD)']
                }
            }
        });
    }


    // On form list change function
    $('.form-wrapper .formsSelect').change(function(){
        var formId = $('select[class=formsSelect]').val();
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