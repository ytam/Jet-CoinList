object Versions {

    object Gradle {
        const val GRADLE_VERSION = "7.0.3"
        const val KOTLIN = "1.5.31"
        const val DAGGER_HILT = "2.39.1"
        const val DETEKT = "1.19.0-RC2"
        const val KTLINT = "10.2.0"
        const val GRADLE_VERSIONS_PLUGIN = "0.38.0"
    }

    object Kotlin {
        const val JDK = Gradle.KOTLIN
    }

    object Google {

        object Androidx {
            const val APP_COMPAT = "1.4.1"
            const val CORE_KTX = "1.7.0"
            const val LIFECYCLE = "2.4.0"
            const val NAVIGATION_COMPOSE = "2.4.0-beta02"
            const val CONSTRAINT_LAYOUT_COMPOSE = "1.0.0-rc01"
        }

        object Material {
            const val DESIGN = "1.4.0"
        }

        object Accompanist {
            const val FLOW_LAYOUT = "0.20.0"
        }

        object Compose {
            const val COMPOSE = "1.0.5"
        }

        object Activity {
            const val ACTIVITY_COMPOSE = "1.4.0"
        }
    }

    object Square {
        const val OK_HTTP = "5.0.0-alpha.2"
        const val RETROFIT = "2.9.0"
        const val RETROFIT_CONVERTER_GSON = "2.8.7"
        const val GSON = "2.8.9"
    }

    object Coroutines {
        const val CORE = "1.6.0"
        const val ANDROID = "1.6.0"
    }

    object Test {
        const val JUNIT = "4.+"
        const val ANDROID_JUNIT_EXT = "1.1.3"
        const val ANDROID_ESPRESSO_CORE = "3.4.0"
        const val UI_TEST_JUNIT = "1.0.5"
        const val UI_TOOLING = "1.0.5"
        const val MOCKK = "1.12.1"
    }

    object Hilt {
        const val HILT_ANDROID = "2.40.3"
        const val HILT_ANDROID_COMPILER = "2.40.3"
        const val HILT_LIFECYCLE_VIEWMODEL = "1.0.0-alpha03"
        const val HILT_NAVIGATION_COMPOSE = "1.0.0-alpha03"
        const val HILT_COMPILER = "1.0.0"
    }

    object Lottie {
        const val COMPOSE = "4.2.2"
    }

    object Coil {
        const val COIL = "1.3.2"
    }
}