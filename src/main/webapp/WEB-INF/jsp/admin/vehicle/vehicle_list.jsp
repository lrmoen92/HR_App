<%@include file="../../includes/header.jsp" %>
<%@include file="../../includes/navbar.jsp" %>
<%@include file="../../includes/subnav_admin.jsp" %>

<div class="wrapper">
    <%--SIDEBAR--%>
    <%@include file="vehicle_sidebar.jsp" %>
    <div id="main-wrapper" class="col-sm-10">
        <div class="col-sm-8">
            <table class="table table-hover">
                <thead>
                <tr>
                    <th>ID</th>
                    <th>Year</th>
                    <th>Make</th>
                    <th>Model</th>
                    <th>VIN</th>
                    <th>License Plate</th>
                    <th>Edit</th>
                    <th>Delete</th>
                </tr>
                </thead>
                <tbody>
                    <c:forEach var="vehicle" items="${vehicleList}">
                        <tr>
                            <td>${vehicle.id}</td>
                            <td>${vehicle.year}</td>
                            <c:forEach var="vehicleMake" items="${vehicleMakeList}">
                                <c:choose>
                                    <c:when test="${vehicle.vehicleModel.vehicleMake == vehicleMake}">
                                        <td>${vehicleMake.vehicleMakeName}</td>
                                    </c:when>
                                </c:choose>
                            </c:forEach>
                            <c:forEach var="vehicleModel" items="${vehicleModelList}">
                                <c:choose>
                                    <c:when test="${vehicle.vehicleModel == vehicleModel}">
                                        <td>${vehicleModel.vehicleModelName}</td>
                                    </c:when>
                                </c:choose>
                            </c:forEach>
                            <td>${vehicle.vin}</td>
                            <td>${vehicle.licensePlate}</td>
                            <td><a href="/admin/vehicle/edit/${vehicle.id}">Edit</a></td>
                            <td><a href="/admin/vehicle/delete/${vehicle.id}">Delete</a></td>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>
        </div>

        <div class="col-sm-4">
            <%--ALERTS--%>

        </div>
    </div>
</div>

<%@include file="../../includes/footer.jsp" %>