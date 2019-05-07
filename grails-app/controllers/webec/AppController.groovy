package webec

class AppController {

    def index() {


        /*
         --------------------
         Module  |   Teaching
         --------------------
         BSYS    | prof01
         BSYS    | prof02
               [...]
         --------------------

         --------------------------------------
         Module | Professor | Student | Upvote
         --------------------------------------
         BSYS   | prof01    | stud01  | true
         BSYS   | prof01    | stud02  | false
               [...]
         --------------------------------------
        */
        def teachings = Teaching.all.groupBy( { teaching -> teaching.module.title } )
        System.out.println(teachings)

        // 'respond' can return different response formats: JSON, XML, ...
        // '[...]' is the returned model
        respond(
                [student:              "Toni",
                 modules:              Module.all,
                 totalNumberOfModules: Module.all.size(),
                 teachings:            Teaching.all
        ])
    }
}
