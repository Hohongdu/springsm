<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<style>
    #container {
        width: 700px;
        height: 500px;
        border: 2px solid red;
    }
</style>
<script>
    let chart2 = {
        init: function () {
            this.loadData(); // 페이지 로드 시 초기 데이터 로드
        },
        loadData: function () {
            const selectedYear = document.getElementById('yearSelect').value;

            $.ajax({
                url: `/charts/chart2?year=${selectedYear}`, // 선택한 연도를 포함하여 요청
                success: (datas) => {
                    this.display(datas);
                }
            });
        },
        display: function (datas) {
            Highcharts.chart('container', {
                chart: {
                    type: 'area'
                },
                accessibility: {
                    description: 'GO Home'
                },
                title: {
                    text: '20-24년도 월별 남자, 여자 매출 현황표'
                },
                subtitle: {
                    text: 'Source: <a href="https://fas.org/issues/nuclear-weapons/status-world-nuclear-forces/" target="_blank">FAS</a>'
                },
                xAxis: {
                    categories: ['Jan', 'Feb', 'Mar', 'Apr', 'May', 'Jun', 'Jul', 'Aug', 'Sep', 'Oct', 'Nov', 'Dec']
                },
                yAxis: {
                    title: {
                        text: 'Sales (in thousands)'
                    }
                },
                tooltip: {
                    pointFormat: '{series.name} had stockpiled <b>{point.y:,.0f}</b><br/>' +
                        'warheads in {point.x}'
                },
                plotOptions: {
                    area: {
                        marker: {
                            enabled: false,
                            symbol: 'circle',
                            radius: 2,
                            states: {
                                hover: {
                                    enabled: true
                                }
                            }
                        }
                    }
                },
                series: [
                    {
                        name: 'Male Sales',
                        data: datas.male // 남자 매출 데이터
                    },
                    {
                        name: 'Female Sales',
                        data: datas.female // 여자 매출 데이터
                    }
                ]
            });
        }
    };

    $(function () {
        $('#yearSelect').change(function () {
            chart2.loadData(); // 연도 선택 시 데이터 로드
        });

        chart2.init(); // 페이지 로드 시 데이터 로드
    });
</script>

<div class="col-sm-10">
    <h2>Chart2 Page</h2>
    <select id="yearSelect">
        <option value="2020">2020</option>
        <option value="2021">2021</option>
        <option value="2022">2022</option>
        <option value="2023">2023</option>
        <option value="2024">2024</option>
    </select>
    <button onclick="chart2.loadData()">Show Data</button>
    <div id="container"></div>
</div>
