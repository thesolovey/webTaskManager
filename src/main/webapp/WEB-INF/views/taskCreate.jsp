<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
    <head>
        <title>TASK CREATE</title>
        <link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
    </head>

    <body class="w3-light-grey">
        <div class="w3-container w3-blue-grey w3-opacity w3-left-align">
            <h1>TASK CREATE PAGE</h1>
        </div>

        <div class="w3-container w3-padding">

            <%
                String taskName = (String) request.getAttribute("task name");
                   if (taskName != null) {
            %>
               <div class="w3-panel w3-green w3-display-container w3-card-4 w3-round\">
                  <span onclick="this.parentElement.style.display='none'"
                  class="w3-button w3-margin-right w3-display-right w3-round-large w3-hover-green w3-border w3-border-green w3-hover-border-grey">×</span>
                  <h5>Task  <%=taskName%> added!</h5>
               </div>
            <%}%>

            <div class="w3-card-4">
               <div class="w3-container w3-center w3-light-blue">
                   <h2>Add task</h2>
               </div>
                  <form method="post" class="w3-selection w3-light-grey w3-padding">
                      <label>Task Name:
                          <input type="text" name="Task Name" class="w3-input w3-animate-input w3-border w3-round-large" style="width: 30%"><br />
                      </label>

                      <label>Task Description:
                          <input type="text" name="Task Description" class="w3-input w3-animate-input w3-border w3-round-large" style="width: 30%"><br />
                      </label>

                      <label>Input Project ID for this Task:
                          <input type="text" name="Project ID" class="w3-input w3-animate-input w3-border w3-round-large" style="width: 30%"><br />
                      </label>
                <button type="submit" class="w3-btn w3-blue w3-round-large w3-margin-bottom">Submit</button>
                  </form>
            </div>
        </div>

     <div class="w3-container w3-light-grey w3-opacity w3-left-align w3-padding">
            <button class="w3-btn w3-round-large" onclick="location.href='/taskList'"><i class="fa fa-search"></i> Go to Task List</button>
     </div>

     <div class="w3-container w3-light-grey w3-opacity w3-left-align w3-padding">
            <button class="w3-btn w3-round-large" onclick="location.href='/projectList'"><i class="fa fa-search"></i> Go to Project List</button>
     </div>

     <div class="w3-container w3-light-grey w3-opacity w3-left-align w3-padding">
            <button class="w3-btn w3-round-large" onclick="location.href='/'"><i class="fa fa-home"></i> Back to Main-Menu</button>
     </div>
    </body>
</html>