<%@ page import="uk.ac.shu.webarch.ShuRegister.RegisterEntry" %>



<div class="fieldcontain ${hasErrors(bean: registerEntryInstance, field: 'timestamp', 'error')} required">
	<label for="timestamp">
		<g:message code="registerEntry.timestamp.label" default="Timestamp" />
		<span class="required-indicator">*</span>
	</label>
	<g:field name="timestamp" type="number" value="${registerEntryInstance.timestamp}" required=""/>
</div>

<div class="fieldcontain ${hasErrors(bean: registerEntryInstance, field: 'regSheet', 'error')} required">
	<label for="regSheet">
		<g:message code="registerEntry.regSheet.label" default="Reg Sheet" />
		<span class="required-indicator">*</span>
	</label>
	<g:select id="regSheet" name="regSheet.id" from="${uk.ac.shu.webarch.ShuRegister.RegistrationSheet.list()}" optionKey="id" required="" value="${registerEntryInstance?.regSheet?.id}" class="many-to-one"/>
</div>

<div class="fieldcontain ${hasErrors(bean: registerEntryInstance, field: 'student', 'error')} required">
	<label for="student">
		<g:message code="registerEntry.student.label" default="Student" />
		<span class="required-indicator">*</span>
	</label>
	<g:select id="student" name="student.id" from="${uk.ac.shu.webarch.ShuRegister.Student.list()}" optionKey="id" required="" value="${registerEntryInstance?.student?.id}" class="many-to-one"/>
</div>

