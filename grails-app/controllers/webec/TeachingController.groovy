package webec

class TeachingController {

    // static scaffold = Teaching

    static allowedMethods = [
            index: "GET",
            delete: "POST"
    ]


    def index() {
        render(view: 'index', model:[teachings: Teaching.findAll()])
    }


    def delete(Long id) {
        System.out.println("Delete teaching id: " + id)
        def teaching = Teaching.get(id)
        teaching.delete()
        redirect(action: 'index')
    }

}
