# IntelliJ IDEA Bug Reports

A collection of self-contained bug reproductions organized by year.

Each report is an independent Gradle project with its own build configuration and toolchain. Projects can be opened individually or together using IntelliJ IDEA's [Multi-Project Workspace plugin](https://plugins.jetbrains.com/plugin/24765-multi-project-workspace).

If you encounter issues loading the workspace, try invalidating all caches and restarting IntelliJ IDEA.

## Reports

- **2025:** [Property type mismatch on override: generic inference](2025/property-type-mismatch-on-override-generic-inference/) — [KT-81343](https://youtrack.jetbrains.com/issue/KT-81343) (As Designed)
- **2025:** [KMP wizard: duplicate project](2025/kmp-wizard-static-library-bug/) — [IDEA-382841](https://youtrack.jetbrains.com/issue/IDEA-382841)
- **2026:** [Specify all remaining arguments selects secondary constructor](2026/specify-all-remaining-arguments-selects-secondary-constructor/)

## Building

Each project uses its own Gradle wrapper and automatically provisions the required JDK using [Gradle Daemon JVM criteria](https://docs.gradle.org/current/userguide/gradle_daemon.html#sec:daemon_jvm_criteria).

Some reproductions intentionally fail compilation to demonstrate the reported issue. Refer to each report's README for the expected behavior and reproduction steps.

A bootstrap JDK must be installed, and internet access is required for initial downloads.
