<html>
  <body>
    <h1>${course.courseName}</h1>
    <p>${course.description}</p>
    <hr/>
    Classes for this course: 
    <table>
      <tr>
        <td>Class Name</td>
        <td>Short Code</td>
        <td>Instructor</td>
      </tr>

      <g:each in="${course.classes}" var="cls">
        <tr>
          <td>${cls.name}</td>
          <td><g:link mapping="classHome"
                        params="${[courseCode:cls.course.courseCode,classCode:cls.code]}">${cls.code}</g:link>
</td>
          <td>${cls.classInstructor.name}</td>
        </tr>
      </g:each>
    </table>
  </body>
</html>
