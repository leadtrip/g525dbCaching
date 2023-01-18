package g525dbcaching

class Engine {

    String name
    Integer bhp

    static hasMany = [sparkPlugs: SparkPlug]

    static mapping = {

    }

    @Override
    String toString() {
        "$name - bhp:$bhp - spark plugs($sparkPlugs)"
    }
}
