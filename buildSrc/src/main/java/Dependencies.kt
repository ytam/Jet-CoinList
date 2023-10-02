import org.gradle.api.artifacts.dsl.DependencyHandler

object Dependencies {

    internal const val KOTLIN_JDK = "org.jetbrains.kotlin:kotlin-stdlib-jdk7:${Versions.Kotlin.JDK}"

    // GOOGLE
    internal const val ANDROID_CORE_KTX = "androidx.core:core-ktx:${Versions.Google.Androidx.CORE_KTX}"
    internal const val ANDROID_LIFECYCLE_EXTENSIONS = "androidx.lifecycle:lifecycle-viewmodel-ktx:${Versions.Google.Androidx.LIFECYCLE}"
    internal const val ANDROID_APP_COMPAT = "androidx.appcompat:appcompat:${Versions.Google.Androidx.APP_COMPAT}"
    internal const val ANDROID_MATERIAL = "com.google.android.material:material:${Versions.Google.Material.DESIGN}"
    internal const val ACCOMPANIST_FLOWLAYOUT = "com.google.accompanist:accompanist-flowlayout:${Versions.Google.Accompanist.FLOW_LAYOUT}"
    internal const val COMPOSE_UI = "androidx.compose.ui:ui:${Versions.Google.Compose.COMPOSE}"
    internal const val COMPOSE_MATERIAL = "androidx.compose.material:material:${Versions.Google.Compose.COMPOSE}"
    internal const val UI_TOOLING_PREVIEW = "androidx.compose.ui:ui-tooling-preview:${Versions.Google.Compose.COMPOSE}"
    internal const val LIFECYCLE_RUNTIME = "androidx.lifecycle:lifecycle-runtime-ktx:${Versions.Google.Androidx.LIFECYCLE}"
    internal const val ACTIVITY_COMPOSE = "androidx.activity:activity-compose:${Versions.Google.Activity.ACTIVITY_COMPOSE}"
    internal const val CONSTRAINTLAYOUT_COMPOSE = "androidx.constraintlayout:constraintlayout-compose:${Versions.Google.Androidx.CONSTRAINT_LAYOUT_COMPOSE}"
    internal const val LIFECYCLE_VIEWMODEL_COMPOSE = "androidx.lifecycle:lifecycle-viewmodel-compose:${Versions.Google.Androidx.LIFECYCLE}"
    internal const val NAVIGATION_COMPOSE = "androidx.navigation:navigation-compose:${Versions.Google.Androidx.NAVIGATION_COMPOSE}"

    // Coroutines
    internal const val KOTLIN_COROUTINES_CORE = "org.jetbrains.kotlinx:kotlinx-coroutines-core:${Versions.Coroutines.CORE}"
    internal const val KOTLIN_COROUTINES_ANDROID = "org.jetbrains.kotlinx:kotlinx-coroutines-android:${Versions.Coroutines.ANDROID}"

    // SQUARE
    internal const val SQUARE_OK_HTTP = "com.squareup.okhttp3:okhttp:${Versions.Square.OK_HTTP}"
    internal const val SQUARE_OK_HTTP_LOGGING_INTERCEPTOR = "com.squareup.okhttp3:logging-interceptor:${Versions.Square.OK_HTTP}"
    internal const val SQUARE_RETROFIT = "com.squareup.retrofit2:retrofit:${Versions.Square.RETROFIT}"
    internal const val SQUARE_GSON = "com.google.code.gson:gson:${Versions.Square.GSON}"
    internal const val SQUARE_CONVERTER_GSON = "com.squareup.retrofit2:converter-gson:${Versions.Square.RETROFIT}"

    // DAGGER-HILT
    internal const val HILT_ANDROID = "com.google.dagger:hilt-android:${Versions.Hilt.HILT_ANDROID}"
    internal const val HILT_ANDROID_COMPILER = "com.google.dagger:hilt-android-compiler:${Versions.Hilt.HILT_ANDROID_COMPILER}"
    internal const val HILT_COMPILER = "androidx.hilt:hilt-compiler:${Versions.Hilt.HILT_COMPILER}"
    internal const val HILT_NAVIGATION_COMPOSE = "androidx.hilt:hilt-navigation-compose:${Versions.Hilt.HILT_NAVIGATION_COMPOSE}"

    // LOTTIE
    internal const val LOTTIE_COMPOSE = "com.airbnb.android:lottie-compose:${Versions.Lottie.COMPOSE}"

    // COIL
    internal const val COIL_COMPOSE = "io.coil-kt:coil-compose:${Versions.Coil.COIL}"
    internal const val COIL_SVG = "io.coil-kt:coil-svg:${Versions.Coil.COIL}"

    internal const val SPLASH_SCREEN = "androidx.core:core-splashscreen:${Versions.SplashScreen.SPLASH_API}"

}

fun DependencyHandler.kotlin() {
    implementation(Dependencies.KOTLIN_JDK)
}

fun DependencyHandler.google() {
    implementation(Dependencies.ANDROID_APP_COMPAT)
    implementation(Dependencies.ANDROID_CORE_KTX)
    implementation(Dependencies.ANDROID_LIFECYCLE_EXTENSIONS)
    implementation(Dependencies.ANDROID_MATERIAL)
    implementation(Dependencies.ACCOMPANIST_FLOWLAYOUT)
    implementation(Dependencies.COMPOSE_UI)
    implementation(Dependencies.COMPOSE_MATERIAL)
    implementation(Dependencies.UI_TOOLING_PREVIEW)
    implementation(Dependencies.LIFECYCLE_RUNTIME)
    implementation(Dependencies.ACTIVITY_COMPOSE)
    implementation(Dependencies.CONSTRAINTLAYOUT_COMPOSE)
    implementation(Dependencies.LIFECYCLE_VIEWMODEL_COMPOSE)
    implementation(Dependencies.NAVIGATION_COMPOSE)
}

fun DependencyHandler.coroutines() {
    implementation(Dependencies.KOTLIN_COROUTINES_CORE)
    implementation(Dependencies.KOTLIN_COROUTINES_ANDROID)
}

fun DependencyHandler.square() {
    implementation(Dependencies.SQUARE_OK_HTTP)
    implementation(Dependencies.SQUARE_OK_HTTP_LOGGING_INTERCEPTOR)
    implementation(Dependencies.SQUARE_RETROFIT)
    implementation(Dependencies.SQUARE_CONVERTER_GSON)
    implementation(Dependencies.SQUARE_GSON)
}

fun DependencyHandler.hilt() {
    implementation(Dependencies.HILT_ANDROID)
    kapt(Dependencies.HILT_ANDROID_COMPILER)
    kapt(Dependencies.HILT_COMPILER)
    implementation(Dependencies.HILT_NAVIGATION_COMPOSE)
}

fun DependencyHandler.lottie() {
    implementation(Dependencies.LOTTIE_COMPOSE)
}

fun DependencyHandler.coil() {
    implementation(Dependencies.COIL_COMPOSE)
    implementation(Dependencies.COIL_SVG)
}

fun DependencyHandler.splash() {
    implementation(Dependencies.SPLASH_SCREEN)
}

private fun DependencyHandler.implementation(depName: String) {
    add("implementation", depName)
}

private fun DependencyHandler.kapt(depName: String) {
    add("kapt", depName)
}

private fun DependencyHandler.files(depName: String) {
    add("files", depName)
}

private fun DependencyHandler.id(depName: String) {
    add("id", depName)
}

private fun DependencyHandler.testImplementation(depName: String) {
    add("testImplementation", depName)
}

private fun DependencyHandler.androidTestImplementation(depName: String) {
    add("androidTestImplementation", depName)
}

private fun DependencyHandler.debugImplementation(depName: String) {
    add("debugImplementation", depName)
}