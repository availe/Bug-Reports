# KMP wizard: duplicate project

[IDEA-382841](https://youtrack.jetbrains.com/issue/IDEA-382841)

Reported with **IntelliJ IDEA 2025.2.5** on **macOS 26.1**.

The Gradle daemon uses Java 17, selected by `gradle/gradle-daemon-jvm.properties`. Gradle automatically downloads a matching JDK if needed. See the repository's [Java setup](../../README.md#java-setup) for IntelliJ IDEA and command-line setup.
