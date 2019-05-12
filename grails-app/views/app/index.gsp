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

        <style>
            ul {
                list-style: none;
            }
        </style>
    </head>
    <body>

        <header>
            <p>User: ${student}</p>
        </header>


        <main class="container">

            <ul class="row">
                <g:each var="teaching" in="${teachings}">
                    <li>
                        <table>
                            <tr>
                                <td>${teaching.module}</td>
                                <td>${teaching.professor}</td>
                                <td>${teachingUpvotes.get(teaching)}</td>
                                <td>
                                    <form action="/app/index" method="get" style="display: inline">
                                        <input type="submit" value="+1">
                                        <input type="hidden" value="+1" name="voteValue">
                                    </form>
                                </td>
                                <td>
                                    <form action="/app/index" method="get" style="display: inline">
                                    <input type="submit" value="-1">
                                    <input type="hidden" value="-1" name="voteValue">
                                </form>
                                </td>
                            </tr>
                        </table>
                    </li>
                </g:each>
            </ul>

            <div class="row">
                <p>Total number of modules: ${totalNumberOfModules}</p>
            </div>

        </main>
    </body>
</html>

