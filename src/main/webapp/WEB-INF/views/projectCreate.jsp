<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
    <head>
        <title>PROJECT CREATE</title>
        <link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
    </head>

    <body class="w3-light-grey">
        <div class="w3-container w3-blue-grey w3-opacity w3-left-align">
            <h1>PROJECT CREATE PAGE</h1>
        </div>

        <div class="w3-container w3-padding">

            <%
                String projectName = (String) request.getAttribute("project name");
                   if (projectName != null) {
            %>
               <div class="w3-panel w3-green w3-display-container w3-card-4 w3-round\">
                  <span onclick="this.parentElement.style.display='none'"
                  class="w3-button w3-margin-right w3-display-right w3-round-large w3-hover-green w3-border w3-border-green w3-hover-border-grey">×</span>
                  <h5>Project  <%=projectName%> added!</h5>
               </div>
            <%}%>

            <div class="w3-card-4">
               <div class="w3-container w3-center w3-light-blue">
                   <h2>Add project</h2>
               </div>
                  <form method="post" class="w3-selection w3-light-grey w3-padding">
                      <label>Project Name:
                          <input type="text" name="Project Name" class="w3-input w3-animate-input w3-border w3-round-large" style="width: 30%"><br />
                      </label>

                      <label>Project Description:
                          <input type="text" name="Description" class="w3-input w3-animate-input w3-border w3-round-large" style="width: 30%"><br />
                      </label>

                <button type="submit" class="w3-btn w3-blue w3-round-large w3-margin-bottom">Submit</button>
                  </form>
            </div>
        </div>

     <div class="w3-container w3-light-grey w3-opacity w3-left-align w3-padding">
            <button class="w3-btn w3-round-large" onclick="location.href='/projectList'">Go to Project List</button>
     </div>

     <div class="w3-container w3-light-grey w3-opacity w3-left-align w3-padding">
            <button class="w3-btn w3-round-large" onclick="location.href='/'">Back to Main-Menu</button>
     </div>
    </body>
</html>