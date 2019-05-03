package webec

class Professor {

    String name

    static constraints = {
        name blank:false
    }

    @Override
    String toString() {
        return name
    }
}
