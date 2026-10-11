class Foo(
    val x: String,
    val y: String,
    val z: String
) {
    constructor(base: Foo) : this(base.x, base.y, base.z)
}

class Normal(
    val x: String,
    val y: String,
    val z: String
)

fun main() {
    // BUG: Renaming Foo.x or Foo.z does not update the named arguments below
    // when the constructor call is incomplete (missing required argument 'y').
    //
    // Rename refactoring works correctly if:
    // 1. The missing argument 'y' is supplied, OR
    // 2. The secondary constructor is removed.
    val b = Foo(
        x = "hello",
        z = "world",
    )

    // EXPECTED: Rename refactoring works even though this constructor call
    // is also incomplete (missing required argument 'yz').
    val c = Normal(
        x = "hello",
        z = "!"
    )
}