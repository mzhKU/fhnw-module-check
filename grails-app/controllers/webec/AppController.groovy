package webec

class AppController {

    def index() {

        // 'respond' can return different response formats: JSON, XML, ...
        // '[...]' is the returned model

        // Map<String, List<String>> teachings = new HashMap<>()

        System.out.println(Teaching.all)

        respond(
                [student:              "Toni",
                 modules:              Module.all,
                 totalNumberOfModules: Module.all.size(),
                 teachings:            Teaching.all
        ])
    }
}
