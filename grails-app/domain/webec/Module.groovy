package webec

class Module {
    String title
    static constraints  = {
        title unique:true
        title blank: false
    }
}
