<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div class="col-sm-10">
    <h1>Live Temperature Data Chart</h1>
    <div id="container" style="height: 400px; min-width: 310px"></div>
</div>
<style>
    #container {
        width: 700px;
        height: 500px;
        border: 2px solid red;
    }
</style>

<script>
    // Create the initial data
    const initialData = (function () {
        const data = [];
        const time = (new Date()).getTime();

        for (let i = 0; i < 20; i++) {
            data.push({
                x: time + i * 1000, // 1초 간격
                y: Math.floor(Math.random() * 41) + 15 // 15~55 사이의 랜덤 온도
            });
        }
        return data;
    }());
    // Highcharts 차트 설정

    const chart = Highcharts.chart('container', {
        chart: {
            type: 'spline',
            events: {
                load: function () {
                    const series = this.series[0];
                    const updateTemperatureData = setInterval(function () {
                        const x = (new Date()).getTime(); // 현재 시간
                        const y = Math.floor(Math.random() * 41) + 15; // 15~55 사이의 랜덤 온도

                        series.addPoint([x, y], true, true); // 새 데이터 포인트 추가

                        // 온도가 50도를 초과하면 경고
                        if (y > 50) {
                            alert('경고: 온도가 50도를 초과했습니다! 현재 온도: ' + y + '°C');
                        }
                    }, 1000); // 1초마다 호출
                }
            }
        },
        title: {
            text: 'Live Temperature Data'
        },
        xAxis: {
            type: 'datetime',
            tickPixelInterval: 150,
            maxPadding: 0.1
        },
        yAxis: {
            title: {
                text: '온도 (°C)'
            },
            min: 0,
            max: 60, // 최대 온도 설정
            plotLines: [{
                value: 50,
                width: 1,
                color: '#FF0000', // 빨간색 경계선
                zIndex: 5,
                label: {
                    text: '50°C 경고선',
                    align: 'right',
                    style: {
                        color: '#FF0000'
                    }
                }
            }]
        },
        tooltip: {
            headerFormat: '<b>{series.name}</b><br/>',
            pointFormat: '{point.x:%Y-%m-%d %H:%M:%S}<br/>{point.y:.2f} °C'
        },
        legend: {
            enabled: false
        },
        exporting: {
            enabled: false
        },
        series: [{
            name: '온도',
            lineWidth: 2,
            color: Highcharts.getOptions().colors[0],
            data: initialData.map(d => [d.x, d.y]) // 초기 데이터 설정
        }]
    });
</script>
