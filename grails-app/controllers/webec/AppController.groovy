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

    static List<Integer> tss = new ArrayList<>()

    def index() {

        // Prevent saving of a new rating on initial load when no values are submitted
        if(null != params.get("professor")) {
            Professor p = Professor.findByName(params.get("professor"))
            Module    m = Module.findByTitle(params.get("module"))
            int    vote = Integer.valueOf(params.get("vote"))

            // Default student before implementing authentication and authorization
            Student s = new Student(name: "s0").save(flush: true, failOnError: true)

            new Rating(module: m,
                    professor: p,
                      student: s,
                         vote: vote
            ).save(flush: true, failOnError: true)

        }
        render(view:'index', model:[student: "Toni", teachings: Teaching.all, ratings: Rating.all])
    }
}

// System.out.println("Professor: " + p.name)
// System.out.println("Module: " + m.title)
// System.out.println("Vote: " + vote)

// Map<Teaching, Integer> teachingUpvotes = new HashMap<>()

// for(Teaching t: Teaching.all) {
//     teachingUpvotes.put(t, Rating.findAllByModuleAndProfessor(m, p).vote.stream().mapToInt({i -> i.intValue()}).sum())
// }

