$(document).ready(function(){
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
                    showLine : false,
                    label: '',
                    data: xyisPoints,
                    backgroundColor: 'rgba(255, 0, 0, 0)',
                    borderColor: 'rgba(255, 0, 0, 0)',
                }
                ,
                {
                    showLine : false,
                    label: 'Rating 1',
                    data: data,
                    backgroundColor: 'rgb(255, 99, 132)',
                    borderColor: 'rgb(255, 99, 132)',
                }
                ,
                {
                    showLine : false,
                    label: 'Rating 2',
                    data: data,
                    backgroundColor: 'rgb(255, 99, 132)',
                    borderColor: 'rgb(255, 99, 132)',
                }
                ,
                {
                    showLine : false,
                    label: 'Rating 3',
                    data: data,
                    backgroundColor: 'rgb(255, 99, 132)',
                    borderColor: 'rgb(255, 99, 132)',
                }
                ,
                {
                    showLine : false,
                    label: 'Rating 4',
                    data: data,
                    backgroundColor: 'rgb(255, 99, 132)',
                    borderColor: 'rgb(255, 99, 132)',
                }
                ,
                {
                    showLine : false,
                    label: 'Rating 5',
                    data: data,
                    backgroundColor: 'rgb(255, 99, 132)',
                    borderColor: 'rgb(255, 99, 132)',
                }
                ,
                {
                    showLine : false,
                    label: 'Rating 6',
                    data: data,
                    backgroundColor: 'rgb(255, 99, 132)',
                    borderColor: 'rgb(255, 99, 132)',
                }
                ,
                {
                    showLine : false,
                    label: 'Rating 7',
                    data: data,
                    backgroundColor: 'rgb(255, 99, 132)',
                    borderColor: 'rgb(255, 99, 132)',
                }
                ,
                {
                    showLine : false,
                    label: 'Rating 8',
                    data: data,
                    backgroundColor: 'rgb(255, 99, 132)',
                    borderColor: 'rgb(255, 99, 132)',
                }
                ,
                {
                    showLine : false,
                    label: 'Rating 9',
                    data: data,
                    backgroundColor: 'rgb(255, 99, 132)',
                    borderColor: 'rgb(255, 99, 132)',
                }
                ,
                {
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