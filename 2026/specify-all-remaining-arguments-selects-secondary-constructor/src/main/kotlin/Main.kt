class Foo(
    val x: String,
    val y: String,
    val z: String? = null,
) {
    constructor(base: Foo) : this(base.x, base.y, base.z)
}

fun main() {
    // IntelliJ's "specify all remaining arguments by name" does not suggest adding the primary constructor.
    val a = Foo(

    )

    // IntelliJ does not suggest adding missing parameter y.
    // IntelliJ also does not refactor these parameters if I rename them in class Foo.
    val b = Foo(
        x = "hello",
        z = "world",
    )
}