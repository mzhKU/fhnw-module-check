package webec

class AppController {

    def index() {
        // render view: 'index', model: [student: "Toni", ratings: Rating.all]

        // 'respond' can return different response formats: JSON, XML, ...
        respond([student: "Toni", ratings: Rating.all])
    }
}
