<%@include file="../../includes/header.jsp" %>
<%@include file="../../includes/navbar.jsp" %>
<%@include file="../../includes/subnav_admin.jsp" %>

<div class="wrapper">
    <%--SIDEBAR--%>
    <%@include file="vehicle_sidebar.jsp" %>
    <div id="main-wrapper" class="col-sm-10">
        <div class="col-sm-8">

            <form:form cssClass="form-horizontal" modelAttribute="vehicleVO" action="/admin/vehicle/" method="post">
                <fieldset>
                    <legend>Vehicle Management</legend>
                    <div class="form-group">
                        <label for="newYear" class="col-lg-2 control-label">Year</label>
                        <div class="col-lg-10">
                            <form:input path="newYear" type="text" cssClass="form-control" id="inputNewYear" placeholder="Year"/>
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="newYear" class="col-sm-2 control-label">Make</label>
                        <div class="col-sm-6">
                            <form:select path="newMakeId" cssClass="form-control" id="inputNewMake">
                                <c:forEach var="vehicleMake" items="${vehicleMakeList}">
                                    <form:option value="${vehicleMake.id}" label="${vehicleMake.vehicleMakeName}"/>
                                </c:forEach>
                            </form:select>
                        </div>
                        <div class="col-sm-4">
                            <a href="/admin/vehicle/addModel/" class="btn btn-primary" style="width:100%">Add A Make</a>
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="newModelId" class="col-sm-2 control-label">Model</label>
                        <div class="col-sm-6">
                            <form:select path="newModelId" cssClass="form-control" id="inputNewModel">
                                <c:forEach var="vehicleModel" items="${vehicleModelList}">
                                    <form:option value="${vehicleModel.id}" label="${vehicleModel.vehicleModelName}"/>
                                </c:forEach>
                            </form:select>
                        </div>
                        <div class="col-sm-4">
                            <a href="/admin/vehicle/addModel/" class="btn btn-primary" style="width:100%">Add A Model</a>
                        </div>
                    </div>

                    <div class="form-group">
                        <label for="newVin" class="col-lg-2 control-label">VIN</label>
                        <div class="col-lg-10">
                            <form:input path="newVin" type="text" cssClass="form-control" id="inputNewVin" placeholder="VIN"/>
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="newLicensePlate" class="col-lg-2 control-label">License Plate</label>
                        <div class="col-lg-10">
                            <form:input path="newLicensePlate" type="text" cssClass="form-control" id="inputNewLicensePlate" placeholder="License Plate"/>
                        </div>
                    </div>
                    <div class="form-group">
                        <div class="col-lg-10 col-lg-offset-2">
                            <form:button type="reset" value="cancel" class="btn btn-default">Cancel</form:button>
                            <form:button type="submit" value="save" class="btn btn-primary">Save</form:button>
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