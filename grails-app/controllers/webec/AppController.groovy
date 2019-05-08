package webec

import java.util.stream.Stream

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

        for(Module m : Module.all) {
            List<Professor> professorsOfModule = Teaching.findAllByModule(m).professor
            for(Professor p : professorsOfModule) {
                def votesMP = Rating.findAllByModuleAndProfessor(m, p).upvote
                System.out.println(m.title + " - " + p.name + ": " + votesMP.stream().filter({v -> v==true}).count())
                // long trueVotesMP = votesMP.stream().filter({v -> v==true}).count()
            }
        }

        Module bsys = Module.findByTitle("BSYS")
        Module vana = Module.findByTitle("VANA")
        // Professor p1 = Professor.findByName("Tom")

        // def voteBsysP1 = Rating.findByModuleAndProfessor(bsys, p1).upvote
        // System.out.println(voteBsysP1)

        // def votesBsys = Rating.findAllByModule(bsys).upvote
        def votesVana= Rating.findAllByModule(vana).upvote

        long trueVotesVana = votesVana.stream().filter({ v -> v == true }).count()
        System.out.println(trueVotesVana)

        /*
         */



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
