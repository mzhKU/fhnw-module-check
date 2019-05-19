<%--
  Created by IntelliJ IDEA.
  User: mzh
  Date: 5/19/19
  Time: 7:06 PM
--%>

<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <link rel="stylesheet" href="/assets/bootstrap.css">
    <link rel="stylesheet" href="/assets/application.css">
    <meta name="layout" content="main">
    <title></title>
</head>

<body>

<main class="container">
    <table class="row">
        <tr>
            <th>Module</th>
            <th>Professor</th>
            <th>Delete</th>
        </tr>

        <g:each var="t" in="${teachings}">
            <tr>
                <td>${t.module.title}</td>
                <td>${t.professor.name}</td>
                <td>
                    <g:form controller="teaching" action="delete" id="${t.id}" method="POST">
                        <g:submitButton name="submit" value="Delete"></g:submitButton>
                    </g:form>
                </td>
            </tr>
        </g:each>
    </table>
</main>

</body>
</html>