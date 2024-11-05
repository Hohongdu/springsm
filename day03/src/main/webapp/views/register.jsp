<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<script>
  let register = {
    init:function(){
      $('#register_form > button').click(()=>{
        this.check();
      });
      $('#id').keyup(()=>{
        $('#id_span').text('ID는 4자리 이상입니다.');
        let id = $('#id').val();
        if(id.length >= 4){
          $.ajax({
            url:'<c:url value="/checkid"/>',
            data:{'rid':id},
            success:function(data){
              //alert(data.result);
              if(data.result == 1){
                $('#id_span').text('사용할수 없습니다.');
              }else{
                $('#id_span').text('사용할수 있습니다.');
              }
            }
          });
        }
      });
    },
    check:function(){
      let id = $('#id').val();
      let pwd = $('#pwd').val();
      let name = $('#name').val();

      if(id == '' || id == null){
        alert('Id is Mandatory');
        $('#id').focus();
        return;
      }
      if(pwd == '' || pwd == null){
        alert('Pwd is Mandatory');
        $('#pwd').focus();
        return;
      }
      if(name == '' || name == null){
        alert('Name is Mandatory');
        $('#name').focus();
        return;
      }
      this.send();
    },
    send:function(){
      // method, action
      $('#register_form').attr('method','post');

      $('#register_form').attr('action','/registerimpl');
      $('#register_form').submit();
    }
  };

  $(function(){
    register.init();
  });
</script>

<div class="col-sm-10">
  <h2>Register Page</h2>
  <div class="row">
    <div class="col-sm-8">
      <form id="register_form">
        <div class="form-group">
          <label for="id">Id:<span id="id_span"></span></label>
          <input type="text" class="form-control" placeholder="Enter id" id="id" name="custId">
        </div>
        <div class="form-group">
          <label for="pwd">Password:</label>
          <input type="password" class="form-control" placeholder="Enter password" id="pwd" name="custPwd">
        </div>
        <div class="form-group">
          <label for="name">Name:</label>
          <input type="text" class="form-control" placeholder="Enter name" id="name" name="custName">
        </div>
        <button type="button" class="btn btn-primary">Submit</button>
      </form>
    </div>
  </div>
</div>