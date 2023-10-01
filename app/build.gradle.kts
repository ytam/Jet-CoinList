plugins {
    id("com.android.application")
    id("kotlin-android")
    id("kotlin-kapt")
    id("dagger.hilt.android.plugin")
    id("io.gitlab.arturbosch.detekt")
    id("org.jlleitschuh.gradle.ktlint")
    id("com.github.ben-manes.versions")
}

android {
    namespace = Configs.APPLICATION_ID
    compileSdk = Configs.COMPILE_SDK

    defaultConfig {
        applicationId = Configs.APPLICATION_ID
        minSdk = Configs.MIN_ANDROID_SDK
        targetSdk = Configs.TARGET_ANDROID_SDK
        versionCode = Configs.VERSION_CODE
        versionName = Configs.VERSION_NAME

        testInstrumentationRunner = Configs.TEST_INSTRUMENTATION_RUNNER
        vectorDrawables {
            useSupportLibrary = true
        }
    }

    buildTypes {
        getByName("release") {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }
    kotlinOptions {
        jvmTarget = "17"
    }
    buildFeatures {
        compose = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = "1.4.3"
    }
}

detekt {
    buildUponDefaultConfig = true
    ignoreFailures = false
    baseline = file("$rootDir/app/detekt-baseline.xml")
    config.setFrom(rootProject.file("config/detekt.yml"))
}

tasks.withType<io.gitlab.arturbosch.detekt.Detekt>().configureEach {
    reports {
        html.required.set(true)
        xml.required.set(true)
        txt.required.set(true)
        sarif.required.set(true)
    }
}

ktlint {
    version.set("0.43.0")
    debug.set(true)
    verbose.set(true)
    outputToConsole.set(true)
    ignoreFailures.set(true)
    enableExperimentalRules.set(false)
    kotlinScriptAdditionalPaths {
        include(fileTree("scripts/"))
    }
    filter {
        exclude("**/generated/**")
        include("**/kotlin/**")
    }
}

dependencies {
    google()
    coroutines()
    hilt()
    square()
    lottie()
    coil()
    splash()
}
