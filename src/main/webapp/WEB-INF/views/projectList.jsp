<%@ page import="com.gmail.sdima.entity.Project" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
    <head>
        <title>PROJECT LIST</title>
        <link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
    </head>

    <body class="w3-light-grey">
        <div class="w3-container w3-blue-grey w3-opacity w3-center-align">
            <h1>PROJECT LIST PAGE</h1>
        </div>

        <div class="w3-container w3-center w3-margin-bottom w3-padding">
            <div class="w3-card-4">
                <div class="w3-container w3-light-blue">
                    <h2>Project List</h2>
                </div>
                <%
                    List<Project> names = (List<Project>) request.getAttribute("PROJECTLIST");

                    if (names != null && !names.isEmpty()) {
                         for (Project project : names)
                              { %>
                               <table class="w3-table-all w3-hoverable">
                                  <tr>
                                    <th>Project Name:   <%=project.getName()%></th>
                                    <th>Project ID:   <%=project.getId()%></th>
                                    <form method="post">
                                    <th><button type="submit" name="projectId" value="<%=project.getId()%>" class="w3-btn w3-round-large" onclick="location.href='/projectOpen'">to Open Project</button></th>
                                    </form>

                                  </tr>
                               </table>

                               <%}}%>

                </div>
        </div>

        <div class="w3-container w3-light-grey w3-opacity w3-left-align w3-padding">
            <button class="w3-btn w3-round-large" onclick="location.href='/projectCreate'">Go to ProjectCreate</button>
        </div>

        <div class="w3-container w3-light-grey w3-opacity w3-left-align w3-padding">
            <button class="w3-btn w3-round-large" onclick="location.href='/taskCreate'">Go to TaskCreate</button>
        </div>

        <div class="w3-container w3-light-grey w3-opacity w3-left-align w3-padding">
            <button class="w3-btn w3-round-large" onclick="location.href='/'">Back to Main-Menu</button>
        </div>
    </body>
</html>