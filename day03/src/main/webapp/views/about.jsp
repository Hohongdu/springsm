<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<style>
    #map1{
        width:600px;
        height:500px;
        border:1px solid indianred;
    }
    #map2{
        width:400px;
        height:300px;
        border:1px solid blueviolet;
    }
</style>
<script>
    let about = {
        marker:null,
        init:function(){
            this.map1();
            this.map2();
        },
        map1:function(){
            let mapContainer = document.getElementById('map1');
            let mapOption = {
                center: new kakao.maps.LatLng(36.799165, 127.074981),
                level: 7
            };
            let map = new kakao.maps.Map(mapContainer, mapOption);
            var mapTypeControl = new kakao.maps.MapTypeControl();
            map.addControl(mapTypeControl, kakao.maps.ControlPosition.TOPRIGHT);
            var zoomControl = new kakao.maps.ZoomControl();
            map.addControl(zoomControl, kakao.maps.ControlPosition.RIGHT);

            var markerPosition  = new kakao.maps.LatLng(36.799165, 127.074981);
            var marker = new kakao.maps.Marker({
                position: markerPosition
            });
            marker.setMap(map);
            // let lat = 36.789165;
            // let lng = 127.064981;
            setInterval(()=>{
                $.ajax({
                    url:'/getbike',
                    success:(result)=>{
                        this.makeMarker(map,result.lat, result.lng);
                    }
                });
            }, 5000);
        },
        makeMarker:function(map, lat, lng){

            if(this.marker != null){
                this.marker.setMap(null);
            }
            let imgsrc = '<c:url value="/img/bike.jpg"/> ';
            let imgsize = new kakao.maps.Size(30,30);
            let markerimg = new kakao.maps.MarkerImage(imgsrc, imgsize);
            let markerposition = new kakao.maps.LatLng(lat, lng);
            this.marker = new kakao.maps.Marker({
                map: map,
                position:markerposition,
                image:markerimg
            });

        },
        map2:function(){
            let mapContainer = document.getElementById('map2');
            let mapOption = {
                center: new kakao.maps.LatLng(36.799165, 127.074981),
                level: 5
            };
            let map = new kakao.maps.Map(mapContainer, mapOption);
            var mapTypeControl = new kakao.maps.MapTypeControl();
            map.addControl(mapTypeControl, kakao.maps.ControlPosition.TOPRIGHT);
            var zoomControl = new kakao.maps.ZoomControl();
            map.addControl(zoomControl, kakao.maps.ControlPosition.RIGHT);

            var markerPosition  = new kakao.maps.LatLng(36.799165, 127.074981);
            var marker = new kakao.maps.Marker({
                position: markerPosition
            });
            marker.setMap(map);
        }
    };

    $(function(){
        about.init();
    });
</script>
<div class="col-sm-10">

    <h2>About Page</h2>
    <div class="row">
        <div class="col-sm-12">
            <div id="map1"></div>
        </div>
        <%--    <div class="col-sm-6">--%>
        <%--      <div id="map2"></div>--%>
        <%--    </div>--%>
    </div>
</div>