<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<script>
    let detail = {
        init: function() {
            $('#update_btn').click(() => {
                this.check();
            });
            $('#delete_btn').click(() => {
                let id = $('#id').val();
                let c = confirm("삭제할까요?");
                if (c == true) {
                    location.href = '<c:url value="/item/deleteimpl"/>' + '?id=' + id;
                }
            });
        },
        check: function() {
            let id = $('#id').val();
            let name = $('#name').val();
            let price = $('#price').val();

            if (id == '' || id == null) {
                alert('Id는 필수입니다.');
                $('#id').focus();
                return;
            }
            if (name == '' || name == null) {
                alert('Name은 필수입니다.');
                $('#name').focus();
                return;
            }
            if (price == '' || price == null) {
                alert('Price는 필수입니다.');
                $('#price').focus();
                return;
            }
            this.send();
        },
        send: function() {
            $('#register_form').attr('method', 'post');
            $('#register_form').attr('action', '/item/updateimpl');
            $('#register_form').submit();
        }
    };

    $(function() {
        detail.init();
    });
</script>

<div class="col-sm-10">
    <h2>Detail Page</h2>
    <div class="row">
        <div class="col-sm-8">
            <form id="register_form">
                <div class="form-group">
                    <label for="id">Id:</label>
                    <input type="text" readonly value="${item.itemId}" class="form-control" placeholder="Enter id" id="id" name="itemId">
                </div>
                <div class="form-group">
                    <label for="name">Name:</label>
                    <input type="text" value="${item.itemName}" class="form-control" placeholder="Enter name" id="name" name="itemName">
                </div>
                <div class="form-group">
                    <label for="price">Price:</label>
                    <input type="number" value="${item.itemPrice}" class="form-control" placeholder="Enter price" id="price" name="itemPrice">
                </div>
                <div class="form-group">
                    <label for="imgname">Image Name:</label>
                    <input type="text" value="${item.imgName}" class="form-control" placeholder="Enter image name" id="imgname" name="imgName">
                </div>
                <button type="button" id="update_btn" class="btn btn-primary">Update</button>
                <button type="button" id="delete_btn" class="btn btn-danger">Delete</button>
            </form>
        </div>
    </div>
</div>
