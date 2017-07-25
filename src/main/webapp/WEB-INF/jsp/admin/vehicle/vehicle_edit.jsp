<%@include file="../../includes/header.jsp" %>
<%@include file="../../includes/navbar.jsp" %>
<%@include file="../../includes/subnav_admin.jsp" %>

<div class="wrapper">
    <%--SIDEBAR--%>
    <%@include file="vehicle_sidebar.jsp" %>
    <div id="main-wrapper" class="col-sm-10">
        <div class="col-sm-8">

            <form:form cssClass="form-horizontal" modelAttribute="vehicle" action="/admin/vehicle/update" method="post">
                <form:hidden path="id" />
                <form:hidden path="version" />
                <fieldset>
                    <legend>Vehicle Management</legend>
                    <div class="form-group">
                        <label for="year" class="col-lg-2 control-label">Year</label>
                        <div class="col-lg-10">
                            <form:input path="year" type="text" cssClass="form-control" id="inputNewYear"/>
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="makeId" class="col-lg-2 control-label">Make</label>
                        <div class="col-lg-10">
                            <form:select path="vehicleModel.vehicleMake.id" modelAttribute="makeId" cssClass="form-control" id="makeId">
                                <c:forEach var="vehicleMake" items="${vehicleMakeList}">
                                    <form:option value="${vehicleMake.id}" label="${vehicleMake.vehicleMakeName}"/>
                                </c:forEach>
                            </form:select>
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="modelId" class="col-lg-2 control-label">Model</label>
                        <div class="col-lg-10">
                            <form:select path="vehicleModel.id" modelAttribute="modelId" cssClass="form-control" id="modelId">
                                <c:forEach var="vehicleModel" items="${vehicleModelList}">
                                    <form:option value="${vehicleModel.id}" label="${vehicleModel.vehicleModelName}"/>
                                </c:forEach>
                            </form:select>
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="vin" class="col-lg-2 control-label">VIN</label>
                        <div class="col-lg-10">
                            <form:input path="vin" type="text" cssClass="form-control" id="inputNewVin"/>
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="licensePlate" class="col-lg-2 control-label">License Plate</label>
                        <div class="col-lg-10">
                            <form:input path="licensePlate" type="text" cssClass="form-control" id="inputNewLicensePlate"/>
                        </div>
                    </div>
                    <div class="form-group">
                        <div class="col-lg-10 col-lg-offset-2">
                            <form:button type="submit" value="save" class="btn btn-primary">Update</form:button>
                        </div>
                    </div>
                </fieldset>
            </form:form>

        </div>

        <div class="col-sm-4">
            <%--ALERTS--%>

        </div>
    </div>
</div>

<%@include file="../../includes/footer.jsp" %>