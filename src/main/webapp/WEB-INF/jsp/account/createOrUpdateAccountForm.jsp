<!DOCTYPE html> 

<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="bank" tagdir="/WEB-INF/tags" %>


<html lang="en">

<jsp:include page="../fragments/headTag.jsp"/>
<body>

<script>
    $(function () {
        $("#accCreationDate").datepicker({ dateFormat: 'yy/mm/dd'});
    });
</script>
<div class="container">
    <jsp:include page="../fragments/bodyHeader.jsp"/>
    <c:choose>
        <c:when test="${account['new']}">
            <c:set var="method" value="post"/>
        </c:when>
        <c:otherwise>
            <c:set var="method" value="put"/>
        </c:otherwise>
    </c:choose>

    <h2>
        <c:if test="${account['new']}">New </c:if>
        Account
    </h2>

    <form:form modelAttribute="account" method="${method}"
               class="form-horizontal">
        <div class="control-group" id="customer">
            <label class="control-label">Customer </label>

            <c:out value="${account.customer.firstName} ${account.customer.lastName}"/>
        </div>
        <bank:inputField label="Account Number" name="accNumber"/>
        <bank:inputField label="Account Creation Date" name="accCreationDate"/>
        <div class="control-group">
            <bank:selectField name="accType" label="Account Type " names="${types}" size="2"/>
        </div>
        <div class="form-actions">
            <c:choose>
                <c:when test="${account['new']}">
                    <button type="submit">Add Account</button>
                </c:when>
                <c:otherwise>
                    <button type="submit">Update Account</button>
                </c:otherwise>
            </c:choose>
        </div>
    </form:form>
    <c:if test="${!account['new']}">
    </c:if>
    <jsp:include page="../fragments/footer.jsp"/>
</div>
</body>

</html>
