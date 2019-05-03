package webec

class Rating {

    Professor professor
    Student   student
    Module    module
    boolean   upvote

    static belongsTo = [professor:Professor,
                        student:  Student,
                        module:   Module]

    static constraints = {
        module()
        student()
        professor()
    }

    String toString() { "$module $professor $student $upvote" }
}
