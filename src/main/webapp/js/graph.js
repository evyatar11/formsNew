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
    var data = [ 11.76,9.56,16.54,8.65,18.95,11.11,7.65];
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
        type: 'line',
        data: {
            labels: ['Google', 'Sap', 'Amazon', 'Microsoft', 'Wix', 'Nice', 'Apple'],
            datasets: [{
                showLine : false,
                label: 'PD score',
                data: data,
                backgroundColor: 'rgba(255, 99, 132, 0.2)',
                borderColor: 'rgba(255, 99, 132, 0.2)',
                fill: false,
                borderDash: [5, 5],
                pointRadius: 15,
                pointHoverRadius: 10,
            }],
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
                        labelString: 'Client Names'
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
                text: 'PD scores of borrowers with rating of ' +  borrowerRating
            },
            subtitles:[
                {
                    text: "This is a Subtitle"
                    //Uncomment properties below to see how they behave
                    //fontColor: "red",
                    //fontSize: 30
                }
            ]
        }
    });
    });