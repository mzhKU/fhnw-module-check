package webec

class Rating {

    Professor professor
    Student   student
    Module    module
    // boolean   upvote
    int vote

    static belongsTo = [professor:Professor,
                        student:  Student,
                        module:   Module]

    static constraints = {
        // upvote(unique: ['professor', 'student', 'module'])
        // vote(unique: ['professor', 'student', 'module'])
    }
}
