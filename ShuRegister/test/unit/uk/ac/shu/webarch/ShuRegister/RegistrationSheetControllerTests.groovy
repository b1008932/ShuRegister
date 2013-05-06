package uk.ac.shu.webarch.ShuRegister



import org.junit.*
import grails.test.mixin.*

@TestFor(RegistrationSheetController)
@Mock(RegistrationSheet)
class RegistrationSheetControllerTests {

    def populateValidParams(params) {
        assert params != null
        // TODO: Populate valid properties like...
        //params["name"] = 'someValidName'
    }

    void testIndex() {
        controller.index()
        assert "/registrationSheet/list" == response.redirectedUrl
    }

    void testList() {

        def model = controller.list()

        assert model.registrationSheetInstanceList.size() == 0
        assert model.registrationSheetInstanceTotal == 0
    }

    void testCreate() {
        def model = controller.create()

        assert model.registrationSheetInstance != null
    }

    void testSave() {
        controller.save()

        assert model.registrationSheetInstance != null
        assert view == '/registrationSheet/create'

        response.reset()

        populateValidParams(params)
        controller.save()

        assert response.redirectedUrl == '/registrationSheet/show/1'
        assert controller.flash.message != null
        assert RegistrationSheet.count() == 1
    }

    void testShow() {
        controller.show()

        assert flash.message != null
        assert response.redirectedUrl == '/registrationSheet/list'

        populateValidParams(params)
        def registrationSheet = new RegistrationSheet(params)

        assert registrationSheet.save() != null

        params.id = registrationSheet.id

        def model = controller.show()

        assert model.registrationSheetInstance == registrationSheet
    }

    void testEdit() {
        controller.edit()

        assert flash.message != null
        assert response.redirectedUrl == '/registrationSheet/list'

        populateValidParams(params)
        def registrationSheet = new RegistrationSheet(params)

        assert registrationSheet.save() != null

        params.id = registrationSheet.id

        def model = controller.edit()

        assert model.registrationSheetInstance == registrationSheet
    }

    void testUpdate() {
        controller.update()

        assert flash.message != null
        assert response.redirectedUrl == '/registrationSheet/list'

        response.reset()

        populateValidParams(params)
        def registrationSheet = new RegistrationSheet(params)

        assert registrationSheet.save() != null

        // test invalid parameters in update
        params.id = registrationSheet.id
        //TODO: add invalid values to params object

        controller.update()

        assert view == "/registrationSheet/edit"
        assert model.registrationSheetInstance != null

        registrationSheet.clearErrors()

        populateValidParams(params)
        controller.update()

        assert response.redirectedUrl == "/registrationSheet/show/$registrationSheet.id"
        assert flash.message != null

        //test outdated version number
        response.reset()
        registrationSheet.clearErrors()

        populateValidParams(params)
        params.id = registrationSheet.id
        params.version = -1
        controller.update()

        assert view == "/registrationSheet/edit"
        assert model.registrationSheetInstance != null
        assert model.registrationSheetInstance.errors.getFieldError('version')
        assert flash.message != null
    }

    void testDelete() {
        controller.delete()
        assert flash.message != null
        assert response.redirectedUrl == '/registrationSheet/list'

        response.reset()

        populateValidParams(params)
        def registrationSheet = new RegistrationSheet(params)

        assert registrationSheet.save() != null
        assert RegistrationSheet.count() == 1

        params.id = registrationSheet.id

        controller.delete()

        assert RegistrationSheet.count() == 0
        assert RegistrationSheet.get(registrationSheet.id) == null
        assert response.redirectedUrl == '/registrationSheet/list'
    }
}
