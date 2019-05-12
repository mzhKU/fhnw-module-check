package webec

import java.util.stream.Stream

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

class AppController {

    def index() {

        Map<Teaching, Integer> teachingUpvotes = new HashMap<>()
        System.out.println(params)

        if(params.get("professor") != null) {
            Professor pro = new Professor(name: params.get("professor"))
            Module    mod = new Module(title: params.get("module"))
            Boolean   vot = Boolean.valueOf(params.get("vote"))

            // Default student before implementing security
            Student   s = new Student(name: "s0")

            new Rating(module: mod, professor: pro, student: s, upvote: vot).save(flush: true, failOnError: true)
        }

        for(Teaching t: Teaching.all) {
            Professor p = t.professor
            Module    m = t.module
            teachingUpvotes.put(t, Rating.findAllByModuleAndProfessor(m, p).upvote.stream().filter({v -> v==true}).count())
        }



        // 'respond' can return different response formats: JSON, XML, ...
        // '[...]' is the returned model
        respond(
                [student:              "Toni",
                 modules:              Module.all,
                 totalNumberOfModules: Module.all.size(),
                 teachings:            Teaching.all,
                 teachingUpvotes:      teachingUpvotes
        ])
    }
}
