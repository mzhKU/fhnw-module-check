package webec

class AppController {

    def index() {
        // render view: 'index', model: [student: "Toni", ratings: Rating.all]

        // 'respond' can return different response formats: JSON, XML, ...
        // '[...]' is the returned model
        respond([student: "Toni", modules: Module.all,
                 totalNumberOfModules: Module.all.size()])
    }
}
