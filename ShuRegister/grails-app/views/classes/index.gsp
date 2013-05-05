<html>
  <body>
    This is classes::index.gsp<br/>

    <table>
      <thead>
        <tr>
          <td>Course Name</td>
          <td>Course Code</td>
          <td>Class Name</td>
          <td>Instructor</td>
        </tr>
      </thead>
      <tbody>
        <g:each in="${classList}" var="c">
          <tr>
            <td><g:link mapping="courseHome"
                        params="${[courseCode:c.courseCode]}">${c.courseName}</g:link></td>
            <td><g:link mapping="courseHome"
                        params="${[courseCode:c.courseCode]}">${c.courseCode}</g:link></td>
            <td><g:link mapping="classHome"
                        params="${[courseCode:c.courseCode,classCode:c.classCode]}">${c.className}</g:link></td>
            <td>${c.instructorName}</td>
          </tr>
        </g:each>
      </tbody>
    </table>

  </body>
</html>
