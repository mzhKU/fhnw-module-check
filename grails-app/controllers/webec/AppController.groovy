package webec

class AppController {

    def index() {

        for(Module m: Module.all) {
            System.out.println(m.title)
        }

        // 'respond' can return different response formats: JSON, XML, ...
        // '[...]' is the returned model
        respond([student:              "Toni",
                 modules:              Module.all,
                 totalNumberOfModules: Module.all.size()])
    }
}
