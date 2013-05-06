package uk.ac.shu.webarch.ShuRegister

import org.springframework.dao.DataIntegrityViolationException

class RegistrationSheetController {

    static allowedMethods = [save: "POST", update: "POST", delete: "POST"]

    def index() {
        redirect(action: "list", params: params)
    }

    def list(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        [registrationSheetInstanceList: RegistrationSheet.list(params), registrationSheetInstanceTotal: RegistrationSheet.count()]
    }

    def create() {
        [registrationSheetInstance: new RegistrationSheet(params)]
    }

    def save() {
        def registrationSheetInstance = new RegistrationSheet(params)
        if (!registrationSheetInstance.save(flush: true)) {
            render(view: "create", model: [registrationSheetInstance: registrationSheetInstance])
            return
        }

        flash.message = message(code: 'default.created.message', args: [message(code: 'registrationSheet.label', default: 'RegistrationSheet'), registrationSheetInstance.id])
        redirect(action: "show", id: registrationSheetInstance.id)
    }

    def show(Long id) {
        def registrationSheetInstance = RegistrationSheet.get(id)
        if (!registrationSheetInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'registrationSheet.label', default: 'RegistrationSheet'), id])
            redirect(action: "list")
            return
        }

        [registrationSheetInstance: registrationSheetInstance]
    }

    def edit(Long id) {
        def registrationSheetInstance = RegistrationSheet.get(id)
        if (!registrationSheetInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'registrationSheet.label', default: 'RegistrationSheet'), id])
            redirect(action: "list")
            return
        }

        [registrationSheetInstance: registrationSheetInstance]
    }

    def update(Long id, Long version) {
        def registrationSheetInstance = RegistrationSheet.get(id)
        if (!registrationSheetInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'registrationSheet.label', default: 'RegistrationSheet'), id])
            redirect(action: "list")
            return
        }

        if (version != null) {
            if (registrationSheetInstance.version > version) {
                registrationSheetInstance.errors.rejectValue("version", "default.optimistic.locking.failure",
                          [message(code: 'registrationSheet.label', default: 'RegistrationSheet')] as Object[],
                          "Another user has updated this RegistrationSheet while you were editing")
                render(view: "edit", model: [registrationSheetInstance: registrationSheetInstance])
                return
            }
        }

        registrationSheetInstance.properties = params

        if (!registrationSheetInstance.save(flush: true)) {
            render(view: "edit", model: [registrationSheetInstance: registrationSheetInstance])
            return
        }

        flash.message = message(code: 'default.updated.message', args: [message(code: 'registrationSheet.label', default: 'RegistrationSheet'), registrationSheetInstance.id])
        redirect(action: "show", id: registrationSheetInstance.id)
    }

    def delete(Long id) {
        def registrationSheetInstance = RegistrationSheet.get(id)
        if (!registrationSheetInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'registrationSheet.label', default: 'RegistrationSheet'), id])
            redirect(action: "list")
            return
        }

        try {
            registrationSheetInstance.delete(flush: true)
            flash.message = message(code: 'default.deleted.message', args: [message(code: 'registrationSheet.label', default: 'RegistrationSheet'), id])
            redirect(action: "list")
        }
        catch (DataIntegrityViolationException e) {
            flash.message = message(code: 'default.not.deleted.message', args: [message(code: 'registrationSheet.label', default: 'RegistrationSheet'), id])
            redirect(action: "show", id: id)
        }
    }
}
