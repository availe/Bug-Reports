plugins {
    id("org.gradle.toolchains.foojay-resolver-convention") version "1.0.0"
}

rootProject.name = "property-type-mismatch-on-override-generic-inference"

include(":explicit")
include(":inferred")
