plugins {
    id("com.android.application")
    id("kotlin-android")
    id("kotlin-kapt")
    id("dagger.hilt.android.plugin")
    id("io.gitlab.arturbosch.detekt")
    id("org.jlleitschuh.gradle.ktlint")
}

android {
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
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
        useIR = true
    }
    buildFeatures {
        compose = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = "1.0.5"
        kotlinCompilerVersion = "1.5.31"
    }
    packagingOptions {
        exclude("META-INF/AL2.0")
        exclude("META-INF/LGPL2.1")
    }
}

detekt {
    buildUponDefaultConfig = true
    ignoreFailures = false
    baseline = file("$rootDir/app/detekt-baseline.xml")
    config.setFrom(rootProject.file("config/detekt.yml"))
    reports {
        xml {
            enabled = true
            destination = file("build/reports/detekt/detekt.xml")
        }
        html {
            enabled = true
            destination = file("build/reports/detekt/detekt.html")
        }
    }
}

ktlint {
    version.set("0.43.0")
    debug.set(true)
    verbose.set(true)
    outputToConsole.set(true)
    ignoreFailures.set(true)
    enableExperimentalRules.set(false)
    additionalEditorconfigFile.set(file("/some/additional/.editorconfig"))
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
    test()
    coroutines()
    hilt()
    square()
    lottie()
}
