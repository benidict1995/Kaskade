plugins {
    id("com.android.library")
    kotlin("android")
}

apply { from(rootProject.file("gradle/kotlin-sources.gradle")) }

android {
    compileSdkVersion(deps.android.build.compileSdkVersion)

    defaultConfig {
        minSdkVersion(deps.android.build.minSdkVersion)
        targetSdkVersion(deps.android.build.targetSdkVersion)
    }

    buildTypes {
        getByName("debug") {
            isTestCoverageEnabled = true
        }
    }

    lintOptions {
        isAbortOnError = true
    }
}

dependencies {
    implementation(project(":kaskade"))

    implementation(deps.kotlin.stdlib.core)
    implementation(deps.android.lifecycle.livedata)

    testImplementation(deps.test.lifecycle)
    testImplementation(deps.test.kotlinjUnit)
    testImplementation(deps.test.mockK)
}

apply { from(rootProject.file("gradle/maven.gradle")) }
