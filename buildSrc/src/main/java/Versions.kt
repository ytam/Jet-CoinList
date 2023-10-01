object Versions {

    object Gradle {
        const val GRADLE_VERSION = "8.1.1"
        const val KOTLIN = "1.8.10"
        const val DAGGER_HILT = "2.48"
        const val DETEKT = "1.23.1"
        const val KTLINT = "11.0.0"
        const val GRADLE_VERSIONS_PLUGIN = "0.38.0"
    }

    object Kotlin {
        const val JDK = Gradle.KOTLIN
    }

    object Google {

        object Androidx {
            const val APP_COMPAT = "1.6.1"
            const val CORE_KTX = "1.12.0"
            const val LIFECYCLE = "2.4.0"
            const val NAVIGATION_COMPOSE = "2.7.3"
            const val CONSTRAINT_LAYOUT_COMPOSE = "1.0.0-rc01"
        }

        object Material {
            const val DESIGN = "1.4.0"
        }

        object Accompanist {
            const val FLOW_LAYOUT = "0.20.0"
        }

        object Compose {
            const val COMPOSE = "1.5.2"
        }

        object Activity {
            const val ACTIVITY_COMPOSE = "1.7.2"
        }
    }

    object Square {
        const val OK_HTTP = "5.0.0-alpha.2"
        const val RETROFIT = "2.9.0"
        const val RETROFIT_CONVERTER_GSON = "2.8.7"
        const val GSON = "2.10.1"
    }

    object Coroutines {
        const val CORE = "1.7.3"
        const val ANDROID = "1.7.3"
    }

    object Hilt {
        const val HILT_ANDROID = "2.48"
        const val HILT_ANDROID_COMPILER = "2.48"
        const val HILT_NAVIGATION_COMPOSE = "1.0.0-alpha03"
        const val HILT_COMPILER = "1.0.0"
    }

    object Lottie {
        const val COMPOSE = "6.1.0"
    }

    object Coil {
        const val COIL = "2.4.0"
    }

    object SplashScreen {
        const val SPLASH_API = "1.0.1"
    }
}