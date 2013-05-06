<%@ page import="uk.ac.shu.webarch.ShuRegister.RegistrationSheet" %>



<div class="fieldcontain ${hasErrors(bean: registrationSheetInstance, field: 'course', 'error')} required">
	<label for="course">
		<g:message code="registrationSheet.course.label" default="Course" />
		<span class="required-indicator">*</span>
	</label>
	<g:select id="course" name="course.id" from="${uk.ac.shu.webarch.ShuRegister.Course.list()}" optionKey="id" required="" value="${registrationSheetInstance?.course?.id}" class="many-to-one"/>
</div>

<div class="fieldcontain ${hasErrors(bean: registrationSheetInstance, field: 'note', 'error')} ">
	<label for="note">
		<g:message code="registrationSheet.note.label" default="Note" />
		
	</label>
	<g:textField name="note" value="${registrationSheetInstance?.note}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: registrationSheetInstance, field: 'regClass', 'error')} required">
	<label for="regClass">
		<g:message code="registrationSheet.regClass.label" default="Reg Class" />
		<span class="required-indicator">*</span>
	</label>
	<g:select id="regClass" name="regClass.id" from="${uk.ac.shu.webarch.ShuRegister.RegClass.list()}" optionKey="id" required="" value="${registrationSheetInstance?.regClass?.id}" class="many-to-one"/>
</div>

<div class="fieldcontain ${hasErrors(bean: registrationSheetInstance, field: 'sheetDate', 'error')} required">
	<label for="sheetDate">
		<g:message code="registrationSheet.sheetDate.label" default="Sheet Date" />
		<span class="required-indicator">*</span>
	</label>
	<g:datePicker name="sheetDate" precision="day"  value="${registrationSheetInstance?.sheetDate}"  />
</div>

<div class="fieldcontain ${hasErrors(bean: registrationSheetInstance, field: 'shortcode', 'error')} ">
	<label for="shortcode">
		<g:message code="registrationSheet.shortcode.label" default="Shortcode" />
		
	</label>
	<g:textField name="shortcode" value="${registrationSheetInstance?.shortcode}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: registrationSheetInstance, field: 'signatories', 'error')} ">
	<label for="signatories">
		<g:message code="registrationSheet.signatories.label" default="Signatories" />
		
	</label>
	
<ul class="one-to-many">
<g:each in="${registrationSheetInstance?.signatories?}" var="s">
    <li><g:link controller="registerEntry" action="show" id="${s.id}">${s?.encodeAsHTML()}</g:link></li>
</g:each>
<li class="add">
<g:link controller="registerEntry" action="create" params="['registrationSheet.id': registrationSheetInstance?.id]">${message(code: 'default.add.label', args: [message(code: 'registerEntry.label', default: 'RegisterEntry')])}</g:link>
</li>
</ul>

</div>

