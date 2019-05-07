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
        // Professor p1 = new Professor("p1").save(flush: true)
        // Module bsys  = new Module("bsys").save(flush: true)

        Module bsys = Module.findByTitle("BSYS")
        Professor p1 = Professor.findByName("Tom")
        def voteBsysP1 = Rating.findByModuleAndProfessor(bsys, p1).upvote

        System.out.println(voteBsysP1)


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
