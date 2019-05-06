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

        <header>
            <p>User: ${student}</p>
        </header>


        <main class="container">

            <ul class="row">
                <g:each var="teaching" in="${teachings}">
                    <li>
                        ${teaching.module} ${teaching.professor}
                    </li>
                </g:each>
            </ul>

            <div class="row">
                <p>Total number of modules: ${totalNumberOfModules}</p>
            </div>

        </main>
    </body>
</html>

