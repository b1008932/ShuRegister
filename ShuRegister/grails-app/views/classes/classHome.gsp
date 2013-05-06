<html>
  <body>
    This is classes::classHome.gsp<br/>

    Class Name : ${cls.name}<br/>
    Course : ${cls.course.courseName}<br/>
    Class code : ${cls.code}<br/>
    Taught By : ${cls.classInstructor?.name}<br/>
    Sheet Count To Date : ${sheetsSoFar}<br/>
    <hr/>
    Current Sheets
    <g:form mapping="classHome" params="${[courseCode:cls.course.courseCode,classCode:cls.code]}" method="POST">
      New Sheet Shortcode: <input type="text" name="shortcode"/> 
      <input type="submit"/>
    </g:form>
    <br/>
    <table>
      <tr><th>Code</th><th>Date</th><th>Attendance</th></tr>
      <g:each in="${cls.registrationSheets}" var="sheet">
        <tr>
          <td><g:link mapping="sheetHome" params="${[courseCode:cls.course.courseCode,classCode:cls.code,sheetCode:sheet.shortcode]}">${sheet.shortcode}</g:link></td>
          <td><g:link mapping="sheetHome" params="${[courseCode:cls.course.courseCode,classCode:cls.code,sheetCode:sheet.shortcode]}">${sheet.sheetDate}</g:link></td>
          <td>${sheet.signatories?.size()}</td>
        </tr>
      </g:each>    
    </table>
    
    <hr/>
    Students...
    <table>
      <tr> 
        <td>Student Number</td>
        <td>Name</td>
        <td>Classes Present</td>
        <td>Possible</td>
        <td>%</td>
      </tr>
      <g:each in="${studentStats}" var="student">
        <tr>
          <td>${student.student.studentNumber}</td>
          <td>${student.student.fullStudentName}</td>
          <td>${student.classesAttended}</td>
          <td>${sheetsSoFar}</td>
          <td>${student.attendance}</td>
        </tr>
      </g:each>    
    </table>

    
  </body>
</html>
