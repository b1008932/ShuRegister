<%@ page import="uk.ac.shu.webarch.ShuRegister.Student" %>



<div class="fieldcontain ${hasErrors(bean: studentInstance, field: 'fullStudentName', 'error')} required">
	<label for="fullStudentName">
		<g:message code="student.fullStudentName.label" default="Full Student Name" />
		<span class="required-indicator">*</span>
	</label>
	<g:textArea name="fullStudentName" cols="40" rows="5" maxlength="256" required="" value="${studentInstance?.fullStudentName}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: studentInstance, field: 'studentNumber', 'error')} required">
	<label for="studentNumber">
		<g:message code="student.studentNumber.label" default="Student Number" />
		<span class="required-indicator">*</span>
	</label>
	<g:textArea name="studentNumber" cols="40" rows="5" maxlength="256" required="" value="${studentInstance?.studentNumber}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: studentInstance, field: 'classAtts', 'error')} ">
	<label for="classAtts">
		<g:message code="student.classAtts.label" default="Class Atts" />
		
	</label>
	
<ul class="one-to-many">
<g:each in="${studentInstance?.classAtts?}" var="c">
    <li><g:link controller="registerEntry" action="show" id="${c.id}">${c?.encodeAsHTML()}</g:link></li>
</g:each>
<li class="add">
<g:link controller="registerEntry" action="create" params="['student.id': studentInstance?.id]">${message(code: 'default.add.label', args: [message(code: 'registerEntry.label', default: 'RegisterEntry')])}</g:link>
</li>
</ul>

</div>

<div class="fieldcontain ${hasErrors(bean: studentInstance, field: 'courses', 'error')} ">
	<label for="courses">
		<g:message code="student.courses.label" default="Courses" />
		
	</label>
	
<ul class="one-to-many">
<g:each in="${studentInstance?.courses?}" var="c">
    <li><g:link controller="enrollment" action="show" id="${c.id}">${c?.encodeAsHTML()}</g:link></li>
</g:each>
<li class="add">
<g:link controller="enrollment" action="create" params="['student.id': studentInstance?.id]">${message(code: 'default.add.label', args: [message(code: 'enrollment.label', default: 'Enrollment')])}</g:link>
</li>
</ul>

</div>

<div class="fieldcontain ${hasErrors(bean: studentInstance, field: 'notes', 'error')} ">
	<label for="notes">
		<g:message code="student.notes.label" default="Notes" />
		
	</label>
	<g:textField name="notes" value="${studentInstance?.notes}"/>
</div>

