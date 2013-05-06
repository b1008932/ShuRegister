package uk.ac.shu.webarch.ShuRegister



import org.junit.*
import grails.test.mixin.*

@TestFor(RegisterEntryController)
@Mock(RegisterEntry)
class RegisterEntryControllerTests {

    def populateValidParams(params) {
        assert params != null
        // TODO: Populate valid properties like...
        //params["name"] = 'someValidName'
    }

    void testIndex() {
        controller.index()
        assert "/registerEntry/list" == response.redirectedUrl
    }

    void testList() {

        def model = controller.list()

        assert model.registerEntryInstanceList.size() == 0
        assert model.registerEntryInstanceTotal == 0
    }

    void testCreate() {
        def model = controller.create()

        assert model.registerEntryInstance != null
    }

    void testSave() {
        controller.save()

        assert model.registerEntryInstance != null
        assert view == '/registerEntry/create'

        response.reset()

        populateValidParams(params)
        controller.save()

        assert response.redirectedUrl == '/registerEntry/show/1'
        assert controller.flash.message != null
        assert RegisterEntry.count() == 1
    }

    void testShow() {
        controller.show()

        assert flash.message != null
        assert response.redirectedUrl == '/registerEntry/list'

        populateValidParams(params)
        def registerEntry = new RegisterEntry(params)

        assert registerEntry.save() != null

        params.id = registerEntry.id

        def model = controller.show()

        assert model.registerEntryInstance == registerEntry
    }

    void testEdit() {
        controller.edit()

        assert flash.message != null
        assert response.redirectedUrl == '/registerEntry/list'

        populateValidParams(params)
        def registerEntry = new RegisterEntry(params)

        assert registerEntry.save() != null

        params.id = registerEntry.id

        def model = controller.edit()

        assert model.registerEntryInstance == registerEntry
    }

    void testUpdate() {
        controller.update()

        assert flash.message != null
        assert response.redirectedUrl == '/registerEntry/list'

        response.reset()

        populateValidParams(params)
        def registerEntry = new RegisterEntry(params)

        assert registerEntry.save() != null

        // test invalid parameters in update
        params.id = registerEntry.id
        //TODO: add invalid values to params object

        controller.update()

        assert view == "/registerEntry/edit"
        assert model.registerEntryInstance != null

        registerEntry.clearErrors()

        populateValidParams(params)
        controller.update()

        assert response.redirectedUrl == "/registerEntry/show/$registerEntry.id"
        assert flash.message != null

        //test outdated version number
        response.reset()
        registerEntry.clearErrors()

        populateValidParams(params)
        params.id = registerEntry.id
        params.version = -1
        controller.update()

        assert view == "/registerEntry/edit"
        assert model.registerEntryInstance != null
        assert model.registerEntryInstance.errors.getFieldError('version')
        assert flash.message != null
    }

    void testDelete() {
        controller.delete()
        assert flash.message != null
        assert response.redirectedUrl == '/registerEntry/list'

        response.reset()

        populateValidParams(params)
        def registerEntry = new RegisterEntry(params)

        assert registerEntry.save() != null
        assert RegisterEntry.count() == 1

        params.id = registerEntry.id

        controller.delete()

        assert RegisterEntry.count() == 0
        assert RegisterEntry.get(registerEntry.id) == null
        assert response.redirectedUrl == '/registerEntry/list'
    }
}
