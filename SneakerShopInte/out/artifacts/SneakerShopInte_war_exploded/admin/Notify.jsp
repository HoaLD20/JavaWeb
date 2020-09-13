<%--
  Created by IntelliJ IDEA.
  User: hoald
  Date: 28/07/2020
  Time: 02:04
  To change this template use File | Settings | File Templates.
--%>
<c:if test="${not empty AlertMessage}">
    <script>showNotification('${AlertMessage}','${AlertType}');</script>
    <c:remove var="AlertMessage" scope="session" />
</c:if>
