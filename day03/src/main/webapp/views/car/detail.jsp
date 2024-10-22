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
                let c = confirm("삭제할꺼 ??");
                if (c == true) {
                    location.href = '<c:url value="/car/car/delete_impl"/>' + '?id=' + id;
                }
            });
        },
        check: function() {
            let id = $('#id').val();
            let name = $('#name').val();
            let color = $('#Color').val();
            let fuel = $('#Fuel').val();
            let price = $('#Price').val(); // carPrice
            let date = $('#carDate').val(); // carDate

            if (id == '' || id == null) {
                alert('Id is Mandatory');
                $('#id').focus();
                return;
            }
            if (name == '' || name == null) {
                alert('Name is Mandatory');
                $('#name').focus();
                return;
            }
            if (color == '' || color == null) {
                alert('Color is Mandatory');
                $('#Color').focus();
                return;
            }
            if (fuel == '' || fuel == null) {
                alert('Fuel is Mandatory');
                $('#Fuel').focus();
                return;
            }
            if (price == '' || price == null) {
                alert('Price is Mandatory');
                $('#Price').focus();
                return;
            }
            if (date == '' || date == null) {
                alert('Date is Mandatory');
                $('#carDate').focus();
                return;
            }

            this.send();
        },
        send: function() {
            $('#register_form').attr('method', 'post');
            $('#register_form').attr('action', '/car/update_impl');
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
                    <label for="id">Id:<span id="id_span"></span></label>
                    <input type="text" readonly value="${car.carId}" class="form-control" id="id" name="carId">
                </div>
                <div class="form-group">
                    <label for="name">Name:</label>
                    <input type="text" value="${car.carName}" class="form-control" id="name" name="carName">
                </div>
                <div class="form-group">
                    <label for="Color">Color:</label>
                    <input type="text" value="${car.carColor}" class="form-control" id="Color" name="carColor">
                </div>
                <div class="form-group">
                    <label for="Fuel">Fuel:</label>
                    <input type="text" value="${car.carFuel}" class="form-control" id="Fuel" name="carFuel">
                </div>
                <div class="form-group">
                    <label for="Price">Price:</label>
                    <input type="text" value="${car.carPrice}" class="form-control" id="Price" name="carPrice">
                </div>
                <div class="form-group">
                    <label for="carDate">Date:</label>
                    <input type="date" value="${car.carDate}" class="form-control" id="carDate" name="carDate">
                </div>
                <button type="button" id="update_btn" class="btn btn-primary">Update</button>
                <button type="button" id="delete_btn" class="btn btn-primary">Delete</button>
            </form>
        </div>
    </div>
</div>
