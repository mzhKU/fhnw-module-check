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
