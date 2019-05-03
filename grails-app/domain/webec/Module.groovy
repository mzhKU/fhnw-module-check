package webec



class Module {

    static constraints = {
    }

    String title


    // A module cannot exist without a title
    // Only modules which are tought are rated
    // A module can have zero ratings
    static contraints = {
        title unique:true
    }
}
