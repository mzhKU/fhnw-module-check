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
        upvote(unique: ['professor', 'student', 'module'])
    }

    String toString() { "$module.title $professor.name $student.name $upvote" }
}
