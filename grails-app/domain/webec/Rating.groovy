package webec

class Rating {

    Professor professor
    Student   student
    Module    module
    boolean   upvoted

    static belongsTo = [professor:Professor,
                        student:  Student,
                        module:   Module]

    static constraints = {
    }
}
