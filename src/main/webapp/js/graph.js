$(document).ready(function(){
    $("#example-vertical").steps({
        headerTag: "h3",
        bodyTag: "section",
        transitionEffect: "slideLeft",
        stepsOrientation: "vertical"
    });
    var dataSet = [
        [ "Tiger Nixon", "System Architect", "Edinburgh", "5421", "2011/04/25", "$320,800" ],
        [ "Garrett Winters", "Accountant", "Tokyo", "8422", "2011/07/25", "$170,750" ],
        [ "Ashton Cox", "Junior Technical Author", "San Francisco", "1562", "2009/01/12", "$86,000" ],
        [ "Cedric Kelly", "Senior Javascript Developer", "Edinburgh", "6224", "2012/03/29", "$433,060" ],
        [ "Airi Satou", "Accountant", "Tokyo", "5407", "2008/11/28", "$162,700" ],
        [ "Brielle Williamson", "Integration Specialist", "New York", "4804", "2012/12/02", "$372,000" ],
        [ "Herrod Chandler", "Sales Assistant", "San Francisco", "9608", "2012/08/06", "$137,500" ],
        [ "Rhona Davidson", "Integration Specialist", "Tokyo", "6200", "2010/10/14", "$327,900" ],
        [ "Colleen Hurst", "Javascript Developer", "San Francisco", "2360", "2009/09/15", "$205,500" ],
        [ "Sonya Frost", "Software Engineer", "Edinburgh", "1667", "2008/12/13", "$103,600" ],
        [ "Jena Gaines", "Office Manager", "London", "3814", "2008/12/19", "$90,560" ],
        [ "Quinn Flynn", "Support Lead", "Edinburgh", "9497", "2013/03/03", "$342,000" ],
        [ "Charde Marshall", "Regional Director", "San Francisco", "6741", "2008/10/16", "$470,600" ],
        [ "Haley Kennedy", "Senior Marketing Designer", "London", "3597", "2012/12/18", "$313,500" ],
        [ "Tatyana Fitzpatrick", "Regional Director", "London", "1965", "2010/03/17", "$385,750" ],
        [ "Michael Silva", "Marketing Designer", "London", "1581", "2012/11/27", "$198,500" ],
        [ "Paul Byrd", "Chief Financial Officer (CFO)", "New York", "3059", "2010/06/09", "$725,000" ],
        [ "Gloria Little", "Systems Administrator", "New York", "1721", "2009/04/10", "$237,500" ],
        [ "Bradley Greer", "Software Engineer", "London", "2558", "2012/10/13", "$132,000" ],
        [ "Dai Rios", "Personnel Lead", "Edinburgh", "2290", "2012/09/26", "$217,500" ],
        [ "Jenette Caldwell", "Development Lead", "New York", "1937", "2011/09/03", "$345,000" ],
        [ "Yuri Berry", "Chief Marketing Officer (CMO)", "New York", "6154", "2009/06/25", "$675,000" ],
        [ "Caesar Vance", "Pre-Sales Support", "New York", "8330", "2011/12/12", "$106,450" ],
        [ "Doris Wilder", "Sales Assistant", "Sidney", "3023", "2010/09/20", "$85,600" ],
        [ "Angelica Ramos", "Chief Executive Officer (CEO)", "London", "5797", "2009/10/09", "$1,200,000" ],
        [ "Gavin Joyce", "Developer", "Edinburgh", "8822", "2010/12/22", "$92,575" ],
        [ "Jennifer Chang", "Regional Director", "Singapore", "9239", "2010/11/14", "$357,650" ],
        [ "Brenden Wagner", "Software Engineer", "San Francisco", "1314", "2011/06/07", "$206,850" ],
        [ "Fiona Green", "Chief Operating Officer (COO)", "San Francisco", "2947", "2010/03/11", "$850,000" ],
        [ "Shou Itou", "Regional Marketing", "Tokyo", "8899", "2011/08/14", "$163,000" ],
        [ "Michelle House", "Integration Specialist", "Sidney", "2769", "2011/06/02", "$95,400" ],
        [ "Suki Burks", "Developer", "London", "6832", "2009/10/22", "$114,500" ],
        [ "Prescott Bartlett", "Technical Author", "London", "3606", "2011/05/07", "$145,000" ],
        [ "Gavin Cortez", "Team Leader", "San Francisco", "2860", "2008/10/26", "$235,500" ],
        [ "Martena Mccray", "Post-Sales support", "Edinburgh", "8240", "2011/03/09", "$324,050" ],
        [ "Unity Butler", "Marketing Designer", "San Francisco", "5384", "2009/12/09", "$85,675" ]
    ];
    $('#container').DataTable( {
        data: dataSet,
        columns: [
            { title: "Number" },
            { title: "Question" },
            { title: "Answer" },
            { title: "Score Contribution" }
        ]
    } );

    window.chartColors = {
        red: 'rgb(255, 99, 132)',
        orange: 'rgb(255, 159, 64)',
        yellow: 'rgb(255, 205, 86)',
        green: 'rgb(75, 192, 192)',
        blue: 'rgb(54, 162, 235)',
        purple: 'rgb(153, 102, 255)',
        grey: 'rgb(201, 203, 207)'
    };

    var ctx = document.getElementById('myChart').getContext('2d');
    var backgroundColors = [];
    var borderColors = [];
    var data = [
        // {x:0,y:0},{x:1,y:0},{x:2,y:0},{x:3,y:0},{x:4,y:0},{x:5,y:0},{x:6,y:0},{x:7,y:0},{x:8,y:0},{x:9,y:0},{x:10,y:0},
        {x:1,y:12.33},{x:1,y:6.789},{x:3,y:8.96},{x:2,y:2.33},{x:4,y:6.789},{x:5,y:8.96},{x:6,y:2.33},{x:7,y:6.789},{x:8,y:8.96},{x:9,y:16.789},
        {x:1,y:2.33},{x:1,y:6.789},{x:3,y:8.96},{x:2,y:2.33},{x:4,y:6.789},{x:5,y:8.96},{x:6,y:12.33},{x:7,y:6.789},{x:8,y:18.96},{x:9,y:6.789},
        {x:1,y:2.33},{x:1,y:16.789},{x:3,y:8.96},{x:2,y:2.33},{x:4,y:6.789},{x:5,y:8.96},{x:6,y:2.33},{x:7,y:6.789},{x:8,y:8.96},{x:9,y:6.789}
        ];
    var xyisPoints = [
        {x:0,y:0},{x:1,y:0},{x:2,y:0},{x:3,y:0},{x:4,y:0},{x:5,y:0},{x:6,y:0},{x:7,y:0},{x:8,y:0},{x:9,y:0},{x:10,y:0}
        ];
    for (i=0;i<data.length;i++){
        if (i==3){
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
    var borrowerRating = 14;
    var scatterChart = new Chart(ctx, {
        type: 'scatter',
        data: {
            labels: 'Scatter DataSet',
            datasets: [

                {
                    pointRadius: 5,
                    showLine : false,
                    label: '',
                    data: xyisPoints,
                    backgroundColor: 'rgba(255, 0, 0, 0)',
                    borderColor: 'rgba(255, 0, 0, 0)',
                }
                ,
                {
                    pointRadius: 5,
                    showLine : false,
                    label: 'Rating 1',
                    data: data,
                    backgroundColor: 'rgb(255, 99, 132)',
                    borderColor: 'rgb(255, 99, 132)',
                }
                ,
                {
                    pointRadius: 5,
                    showLine : false,
                    label: 'Rating 2',
                    data: data,
                    backgroundColor: 'rgb(255, 99, 132)',
                    borderColor: 'rgb(255, 99, 132)',
                }
                ,
                {
                    pointRadius: 5,
                    showLine : false,
                    label: 'Rating 3',
                    data: data,
                    backgroundColor: 'rgb(255, 99, 132)',
                    borderColor: 'rgb(255, 99, 132)',
                }
                ,
                {
                    pointRadius: 5,
                    showLine : false,
                    label: 'Rating 4',
                    data: data,
                    backgroundColor: 'rgb(255, 99, 132)',
                    borderColor: 'rgb(255, 99, 132)',
                }
                ,
                {
                    pointRadius: 5,
                    showLine : false,
                    label: 'Rating 5',
                    data: data,
                    backgroundColor: 'rgb(255, 99, 132)',
                    borderColor: 'rgb(255, 99, 132)',
                }
                ,
                {
                    pointRadius: 5,
                    showLine : false,
                    label: 'Rating 6',
                    data: data,
                    backgroundColor: 'rgb(255, 99, 132)',
                    borderColor: 'rgb(255, 99, 132)',
                }
                ,
                {
                    pointRadius: 5,
                    showLine : false,
                    label: 'Rating 7',
                    data: data,
                    backgroundColor: 'rgb(255, 99, 132)',
                    borderColor: 'rgb(255, 99, 132)',
                }
                ,
                {
                    pointRadius: 5,
                    showLine : false,
                    label: 'Rating 8',
                    data: data,
                    backgroundColor: 'rgb(255, 99, 132)',
                    borderColor: 'rgb(255, 99, 132)',
                }
                ,
                {
                    pointRadius: 5,
                    showLine : false,
                    label: 'Rating 9',
                    data: data,
                    backgroundColor: 'rgb(255, 99, 132)',
                    borderColor: 'rgb(255, 99, 132)',
                }
                ,
                {
                    pointRadius: 10,
                    showLine : false,
                    label: 'Rating 10',
                    data: data,
                    backgroundColor: 'rgb(255, 99, 132)',
                    borderColor: 'rgb(255, 99, 132)',
                }

            ],
        },
        options: {
            responsive: true,
            legend: {
                position: 'top',
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
                        labelString: 'PD score'
                    }
                }]
            },
            title: {
                fontSize: 30,
                display: true,
                text: 'Distribution of scores per borrower rating'
            }
        }
    });


    });