<html>
  <body>
    This is courses::index.gsp<br/>

    <table>
      <thead>
        <tr>
          <td>Course Name</td>
          <td>Course Code</td>
          
        </tr>
      </thead>
      <tbody>
        <g:each in="${course}" var="c">
          <tr>
            <td>${c.courseName}</td>
            <td>${c.courseCode}</td>
           </tr>
        </g:each>
      </tbody>
    </table>

  </body>
</html>
