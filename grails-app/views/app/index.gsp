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

        <header class="container">
            <div class="row">
                <p>User [NAME]</p>
            </div>
        </header>

        <main class="container">

            <table class="row">
                <tr>
                    <th>Module</th>
                    <th>Professor</th>
                    <th>Rating</th>
                    <th>Upvote</th>
                    <th>Downvote</th>
                </tr>
                <g:each var="t" in="${teachings}">
                    <tr>
                        <td>${t.module}</td>
                        <td>${t.professor}</td>
                        <td>${t.voteValue}</td>

                        <td>
                            <form action="/app/index" method="get" style="display: inline">
                                <input type="submit" value="+1" name="vote">
                                <input type="hidden" value="${t.module}" name="module">
                                <input type="hidden" value="${t.professor}" name="professor">
                            </form>
                        </td>
                        <td>
                            <form action="/app/index" method="get" style="display: inline">
                                <input type="submit" value="-1" name="vote">
                                <input type="hidden" value="${t.module}" name="module">
                                <input type="hidden" value="${t.professor}" name="professor">
                            </form>
                        </td>
                    </tr>
                </g:each>
            </table>
            <div class="row">
                <p>Total number of ratings: [NUMBER]</p>
            </div>
        </main>
    </body>
</html>

