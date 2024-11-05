<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<script>
  function display(datas){
    let result = '';
    $(datas).each(function(index, data){
      result += '<tr>';
      result += '<td>'+ data.id +'</td>';
      result += '<td>'+ data.name +'</td>';
      result += '<td>'+ data.age +'</td>';
      result += '</tr>';
    });
    $('#cdata > tbody').html(result);
  };

  function getdata(){
    let datas = [
            {'id':'id01','name':'james1','age':10},
            {'id':'id02','name':'james2','age':20},
            {'id':'id03','name':'james3','age':30},
            {'id':'id04','name':'james4','age':40},
            {'id':'id05','name':'james5','age':50}
    ];
    display(datas);
  };

  $(document).ready(function(){
    $('#btn_get').click(function(){
      getdata();
    });
  });
</script>
<div class="col-sm-10">

  <h2>JS3 Page</h2>
  <button id="btn_get">Get Data</button>
  <h5>Title description, Sep 2, 2017</h5>
  <table class="table" id="cdata">
    <thead class="thead-dark">
      <tr>
        <th>Id</th>
        <th>Name</th>
        <th>Age</th>
      </tr>
    </thead>
    <tbody>

    </tbody>
  </table>
</div>






