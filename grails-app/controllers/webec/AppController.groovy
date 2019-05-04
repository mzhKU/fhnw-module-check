package webec

class AppController {

    def index() {
        render view: 'index', model: [ratings: Rating.all]
    }
}
