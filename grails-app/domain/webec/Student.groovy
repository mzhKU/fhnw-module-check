package webec

class Student {

    String name

    static constraints = {
        name nullable: true
    }

    @Override
    String toString() {
        return name
    }
}
