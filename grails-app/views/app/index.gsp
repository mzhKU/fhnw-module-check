<%--
  Created by IntelliJ IDEA.
  User: mzh
  Date: 5/4/19
  Time: 8:12 PM
--%>


<html>
<html>
    <head>
        <meta name="layout" content="main"/>
        <title>Home Page</title>
    </head>
    <body>

        <ul>
            <g:each var="i" in="${ratings}">
                <li>${i}</li>
            </g:each>
        </ul>

    </body>
</html>

