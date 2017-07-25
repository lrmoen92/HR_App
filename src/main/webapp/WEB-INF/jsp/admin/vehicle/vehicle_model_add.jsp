<%@include file="../../includes/header.jsp" %>
<%@include file="../../includes/navbar.jsp" %>
<%@include file="../../includes/subnav_admin.jsp" %>

<div class="wrapper">
    <%--SIDEBAR--%>
    <%@include file="vehicle_sidebar.jsp" %>
    <div id="main-wrapper" class="col-sm-10">
        <div class="col-sm-8">

            <form:form cssClass="form-horizontal" modelAttribute="vehicleModelVO" action="/admin/vehicle/addModel" method="post">
                <fieldset>
                    <legend>Vehicle Model Management</legend>
                    <div class="form-group">
                        <label class="col-lg-2 control-label">New Vehicle Make</label>
                        <div class="col-lg-10">
                            <form:input path="newVehicleMakeName"/>
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-lg-2 control-label">New Vehicle Model</label>
                        <div class="col-lg-10">
                        <form:input path="newVehicleModelName"/>
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
                <div class="${makeExists == null ? 'hidden' : makeExists}" id="warningAlert">
                    <div class="alert alert-dismissible alert-warning">
                        <button type="button" class="close" data-dismiss="alert">&times;</button>
                        <strong>Make Already Exists!  Leave field blank please.</strong>
                    </div>
                </div>
        </div>
    </div>
</div>

<%@include file="../../includes/footer.jsp" %>