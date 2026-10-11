# Property type mismatch on override: generic inference

[KT-81343](https://youtrack.jetbrains.com/issue/KT-81343) — **As Designed**

Kotlin intentionally infers an overriding property's type without using
the overridden property's declaration. On Wasm/Native, serialization adds
an additional supertype that makes the inferred result incompatible.
IntelliJ analyzes this code in JVM mode, misses this incompatibility, and
incorrectly suggests removing the necessary type argument.

## Reproduction

From the repository root, navigate to this project:

```sh
cd 2025/property-type-mismatch-on-override-generic-inference
```

**Explicit — JVM (succeeds):**

```sh
./gradlew :explicit:compileKotlinJvm
```

**Explicit — Wasm (succeeds):**

```sh
./gradlew :explicit:compileKotlinWasmJs
```

**Inferred — JVM (succeeds):**

```sh
./gradlew :inferred:compileKotlinJvm
```

**Inferred — Wasm (fails):**

```sh
./gradlew :inferred:compileKotlinWasmJs
```

The last command fails with `PROPERTY_TYPE_MISMATCH_ON_OVERRIDE`.

Alternatively, execute these tasks through IntelliJ IDEA's **Gradle** tool window.

## IntelliJ IDEA

Open [the explicit variant](explicit/src/commonMain/kotlin/Reproduction.kt)
and invoke **Explicit type arguments can be inferred** on
`ResultResponseSpec<DeletionResult>`.

Applying the suggestion produces the
[inferred variant](inferred/src/commonMain/kotlin/Reproduction.kt),
which compiles on JVM but fails on Wasm.