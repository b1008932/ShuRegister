<html>
 <body>
This is classes::index.gsp

<table>
 <thead>
   <tr>
<td>Course Name</td>
<td>Class Name</td>
<td>Instructor Name</td>
   </tr>
 </thead>
     <tbody>
      <g:each in="${classes}" var="c">
    <tr>
<td>${c.courseName}</td>
<td>${c.className}</td>
<td>${c.instructorName}</td>
   </tr>
     </g:each>
     </tbody>
</table>
 </body>
</html>
 
