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

        // Prevent saving of a new rating on initial load when no values are submitted
        if(params.get("professor") != null) {
            Professor professor  = new Professor(name: params.get("professor"))
            Module    module     = new Module(title: params.get("module"))
            int       vote       = Integer.valueOf(params.get("vote"))

            // Default student before implementing authentication
            Student s = new Student(name: "s0")

            System.out.println("professor: " + professor)
            System.out.println("module: " + module)
            System.out.println("vote: " + vote)

            // Why is the new rating not saved?
            new Rating(module: module, professor: professor, student: s, vote: vote).save(flush: true, failOnError: true)
            System.out.println(Rating.findAllByModuleAndProfessor(module, professor).vote.stream().mapToInt({i -> i.intValue()}).sum())
        }


        for(Teaching t: Teaching.all) {
            Professor p = t.professor
            Module    m = t.module
            teachingUpvotes.put(t, Rating.findAllByModuleAndProfessor(m, p).vote.stream().mapToInt({i -> i.intValue()}).sum())
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
