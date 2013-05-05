<html>
 <body>
Classes<br/>

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
<td><g:link controller="Course">${c.courseName}</g:link></td> 
<td><g:link controller="RegClass">${c.className}</g:link></td>
<td><g:link controller="Instructor">${c.instructorName}</g:link></td>
   </tr>
     </g:each>
     </tbody>
</table>

 </body>
</html>
 
