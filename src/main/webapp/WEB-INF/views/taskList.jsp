<%@ page import="com.gmail.sdima.entity.Task" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
    <head>
        <title>TASK LIST</title>
        <link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
    </head>

    <body class="w3-light-grey">
        <div class="w3-container w3-blue-grey w3-opacity w3-center-align">
            <h1>TASK LIST PAGE</h1>
        </div>

        <div class="w3-container w3-center w3-margin-bottom w3-padding">
            <div class="w3-card-4">
                <div class="w3-container w3-light-blue">
                    <h2>Task List</h2>
                </div>
                <%
                    List<Task> names = (List<Task>) request.getAttribute("TASKLIST");

                    if (names != null && !names.isEmpty()) {
                         for (Task task: names)
                              { %>
                               <table class="w3-table w3-striped w3-bordered">
                                  <tr>
                                     <th>Task Name:   <%=task.getTaskName()%></th>
                                     <th>Task ID:   <%=task.getId()%></th>
                                     <th>Task Descriptions: <%=task.getDescription()%></th>
                                     <th>Project ID for Task:   <%=task.getProjectId()%></th>
                                     <form method="post">
                                     <th><button type="submit" name="taskId" value="<%=task.getId()%>" class="w3-btn w3-round-large" >to Open Task</button></th>
                                     </form>
                                  </tr>
                               </table>

                               <%}}%>

                </div>
        </div>

        <div class="w3-container w3-light-grey w3-opacity w3-left-align w3-padding">
            <button class="w3-btn w3-round-large" onclick="location.href='/taskCreate'">Go to TaskCreate</button>
        </div>

        <div class="w3-container w3-light-grey w3-opacity w3-left-align w3-padding">
            <button class="w3-btn w3-round-large" onclick="location.href='/'">Back to Main-Menu</button>
        </div>
    </body>
</html>