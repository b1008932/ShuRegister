
<%@ page import="uk.ac.shu.webarch.ShuRegister.RegistrationSheet" %>
<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'registrationSheet.label', default: 'RegistrationSheet')}" />
		<title><g:message code="default.show.label" args="[entityName]" /></title>
	</head>
	<body>
		<a href="#show-registrationSheet" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul>
				<li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
				<li><g:link class="list" action="list"><g:message code="default.list.label" args="[entityName]" /></g:link></li>
				<li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
			</ul>
		</div>
		<div id="show-registrationSheet" class="content scaffold-show" role="main">
			<h1><g:message code="default.show.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
			<div class="message" role="status">${flash.message}</div>
			</g:if>
			<ol class="property-list registrationSheet">
			
				<g:if test="${registrationSheetInstance?.course}">
				<li class="fieldcontain">
					<span id="course-label" class="property-label"><g:message code="registrationSheet.course.label" default="Course" /></span>
					
						<span class="property-value" aria-labelledby="course-label"><g:link controller="course" action="show" id="${registrationSheetInstance?.course?.id}">${registrationSheetInstance?.course?.encodeAsHTML()}</g:link></span>
					
				</li>
				</g:if>
			
				<g:if test="${registrationSheetInstance?.note}">
				<li class="fieldcontain">
					<span id="note-label" class="property-label"><g:message code="registrationSheet.note.label" default="Note" /></span>
					
						<span class="property-value" aria-labelledby="note-label"><g:fieldValue bean="${registrationSheetInstance}" field="note"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${registrationSheetInstance?.regClass}">
				<li class="fieldcontain">
					<span id="regClass-label" class="property-label"><g:message code="registrationSheet.regClass.label" default="Reg Class" /></span>
					
						<span class="property-value" aria-labelledby="regClass-label"><g:link controller="regClass" action="show" id="${registrationSheetInstance?.regClass?.id}">${registrationSheetInstance?.regClass?.encodeAsHTML()}</g:link></span>
					
				</li>
				</g:if>
			
				<g:if test="${registrationSheetInstance?.sheetDate}">
				<li class="fieldcontain">
					<span id="sheetDate-label" class="property-label"><g:message code="registrationSheet.sheetDate.label" default="Sheet Date" /></span>
					
						<span class="property-value" aria-labelledby="sheetDate-label"><g:formatDate date="${registrationSheetInstance?.sheetDate}" /></span>
					
				</li>
				</g:if>
			
				<g:if test="${registrationSheetInstance?.shortcode}">
				<li class="fieldcontain">
					<span id="shortcode-label" class="property-label"><g:message code="registrationSheet.shortcode.label" default="Shortcode" /></span>
					
						<span class="property-value" aria-labelledby="shortcode-label"><g:fieldValue bean="${registrationSheetInstance}" field="shortcode"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${registrationSheetInstance?.signatories}">
				<li class="fieldcontain">
					<span id="signatories-label" class="property-label"><g:message code="registrationSheet.signatories.label" default="Signatories" /></span>
					
						<g:each in="${registrationSheetInstance.signatories}" var="s">
						<span class="property-value" aria-labelledby="signatories-label"><g:link controller="registerEntry" action="show" id="${s.id}">${s?.encodeAsHTML()}</g:link></span>
						</g:each>
					
				</li>
				</g:if>
			
			</ol>
			<g:form>
				<fieldset class="buttons">
					<g:hiddenField name="id" value="${registrationSheetInstance?.id}" />
					<g:link class="edit" action="edit" id="${registrationSheetInstance?.id}"><g:message code="default.button.edit.label" default="Edit" /></g:link>
					<g:actionSubmit class="delete" action="delete" value="${message(code: 'default.button.delete.label', default: 'Delete')}" onclick="return confirm('${message(code: 'default.button.delete.confirm.message', default: 'Are you sure?')}');" />
				</fieldset>
			</g:form>
		</div>
	</body>
</html>
