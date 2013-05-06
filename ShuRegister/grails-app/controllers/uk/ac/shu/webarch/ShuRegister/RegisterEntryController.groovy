package uk.ac.shu.webarch.ShuRegister

import org.springframework.dao.DataIntegrityViolationException

class RegisterEntryController {

    static allowedMethods = [save: "POST", update: "POST", delete: "POST"]

    def index() {
        redirect(action: "list", params: params)
    }

    def list(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        [registerEntryInstanceList: RegisterEntry.list(params), registerEntryInstanceTotal: RegisterEntry.count()]
    }

    def create() {
        [registerEntryInstance: new RegisterEntry(params)]
    }

    def save() {
        def registerEntryInstance = new RegisterEntry(params)
        if (!registerEntryInstance.save(flush: true)) {
            render(view: "create", model: [registerEntryInstance: registerEntryInstance])
            return
        }

        flash.message = message(code: 'default.created.message', args: [message(code: 'registerEntry.label', default: 'RegisterEntry'), registerEntryInstance.id])
        redirect(action: "show", id: registerEntryInstance.id)
    }

    def show(Long id) {
        def registerEntryInstance = RegisterEntry.get(id)
        if (!registerEntryInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'registerEntry.label', default: 'RegisterEntry'), id])
            redirect(action: "list")
            return
        }

        [registerEntryInstance: registerEntryInstance]
    }

    def edit(Long id) {
        def registerEntryInstance = RegisterEntry.get(id)
        if (!registerEntryInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'registerEntry.label', default: 'RegisterEntry'), id])
            redirect(action: "list")
            return
        }

        [registerEntryInstance: registerEntryInstance]
    }

    def update(Long id, Long version) {
        def registerEntryInstance = RegisterEntry.get(id)
        if (!registerEntryInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'registerEntry.label', default: 'RegisterEntry'), id])
            redirect(action: "list")
            return
        }

        if (version != null) {
            if (registerEntryInstance.version > version) {
                registerEntryInstance.errors.rejectValue("version", "default.optimistic.locking.failure",
                          [message(code: 'registerEntry.label', default: 'RegisterEntry')] as Object[],
                          "Another user has updated this RegisterEntry while you were editing")
                render(view: "edit", model: [registerEntryInstance: registerEntryInstance])
                return
            }
        }

        registerEntryInstance.properties = params

        if (!registerEntryInstance.save(flush: true)) {
            render(view: "edit", model: [registerEntryInstance: registerEntryInstance])
            return
        }

        flash.message = message(code: 'default.updated.message', args: [message(code: 'registerEntry.label', default: 'RegisterEntry'), registerEntryInstance.id])
        redirect(action: "show", id: registerEntryInstance.id)
    }

    def delete(Long id) {
        def registerEntryInstance = RegisterEntry.get(id)
        if (!registerEntryInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'registerEntry.label', default: 'RegisterEntry'), id])
            redirect(action: "list")
            return
        }

        try {
            registerEntryInstance.delete(flush: true)
            flash.message = message(code: 'default.deleted.message', args: [message(code: 'registerEntry.label', default: 'RegisterEntry'), id])
            redirect(action: "list")
        }
        catch (DataIntegrityViolationException e) {
            flash.message = message(code: 'default.not.deleted.message', args: [message(code: 'registerEntry.label', default: 'RegisterEntry'), id])
            redirect(action: "show", id: id)
        }
    }
}
