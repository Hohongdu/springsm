<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<script>
  let center = {
    init:function(){
      $.ajax({
        url:'<c:url value="/wh"/>',
        success:(result)=>{
          let wtext = result.response.body.items.item[0].wfSv;
          $('#wh').text(wtext);
        }
      });
      $.ajax({
        url:'<c:url value="/wh2"/>',
        success:(result)=>{
          let icon = result.weather[0].icon;
          let temp = result.main.temp;

          let url = 'https://openweathermap.org/img/wn/'+icon+'@2x.png';
          let resultHtml = '<img src="'+url+'">';
          resultHtml += '<h3>'+temp+'<h3>';
          $('#wh2').html(resultHtml);

        }
      });
    }
  };
  $(function(){
    center.init();
  });
</script>

<div class="col-sm-10">

  <h2>TITLE HEADING</h2>
  <h5>Title description, Sep 2, 2017</h5>
  <p id="wh"></p>
  <div id="wh2"></div>
</div>