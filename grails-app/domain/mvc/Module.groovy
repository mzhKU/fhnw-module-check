package mvc



class Module {

    static constraints = {
    }

    Professor professor
    String title
    int votes

    def upvote() {
        votes += 1
    }

    // A module cannot exist without a title
    // Only modules which are tought are rated
    // A module can have zero ratings
    static contraints = {
        title unique:true
        title blank:false
        professor blank:false
    }
}
