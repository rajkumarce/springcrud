<!DOCTYPE html> 

<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="bank" tagdir="/WEB-INF/tags" %>


<html lang="en">

<jsp:include page="../fragments/headTag.jsp"/>

<body>
<div class="container">
    <jsp:include page="../fragments/bodyHeader.jsp"/>
    <c:choose>
        <c:when test="${customer['new']}"><c:set var="method" value="post"/></c:when>
        <c:otherwise><c:set var="method" value="put"/></c:otherwise>
    </c:choose>

    <h2>
        <c:if test="${customer['new']}">New </c:if> Customer
    </h2>
    <form:form modelAttribute="customer" method="${method}" class="form-horizontal" id="add-customer-form">
        <bank:inputField label="First Name" name="firstName"/>
        <bank:inputField label="Last Name" name="lastName"/>
        <bank:inputField label="Address" name="address"/>
        <bank:inputField label="City" name="city"/>
        <bank:inputField label="Telephone" name="telephone"/>

        <div class="form-actions">
            <c:choose>
                <c:when test="${customer['new']}">
                    <button type="submit">Add Customer</button>
                </c:when>
                <c:otherwise>
                    <button type="submit">Update Customer</button>
                </c:otherwise>
            </c:choose>
        </div>
    </form:form>
</div>
<jsp:include page="../fragments/footer.jsp"/>
</body>

</html>
