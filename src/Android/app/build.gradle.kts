import org.gradle.api.JavaVersion // Make sure this import is present

plugins {
    // You should use the alias from libs.versions.toml here if your project-level build script does
    // For example: alias(libs.plugins.android.application)
    // However, since you wrote id("com.android.application") directly, I'll stick to that for now
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
    alias(libs.plugins.kotlin.compose)
// You should also apply the Kotlin Compose plugin if it's not automatically applied
    // by the Android Gradle Plugin when compose is enabled.
    // Explicitly: alias(libs.plugins.kotlin.compose) // Or id("org.jetbrains.kotlin.plugin.compose")
}

android {
    namespace = "com.hoangtucode.sportnexus"
    compileSdk = 35 // Consider 34 for stability during debugging if problems persist

    defaultConfig {
        applicationId = "com.hoangtucode.sportnexus"
        minSdk = 26
        targetSdk = 35 // Consider 34
        versionCode = 1
        versionName = "1.0"
        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        vectorDrawables {
            useSupportLibrary = true
        }
    }

    buildFeatures {
        compose = true
    }



    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_21
        targetCompatibility = JavaVersion.VERSION_21
    }
    kotlinOptions {
        jvmTarget = "21"
    }
}

dependencies {
    implementation(libs.androidx.appcompat) // Keep if you need AppCompat resources/themes

    // Use the Compose BOM defined in your libs.versions.toml
    val composeBom = platform(libs.androidx.compose.bom) // Use the alias
    implementation(composeBom)
    androidTestImplementation(composeBom)

    // Core Compose dependencies (versions are handled by the BOM)
    implementation(libs.androidx.ui) // Use alias: libs.androidx.ui
    implementation(libs.androidx.ui.graphics) // Use alias
    implementation(libs.androidx.material3) // Use alias
    implementation(libs.androidx.activity.compose) // Use alias for androidx.activity.compose which is version "1.10.1" in your TOML

    // For previews
    implementation(libs.androidx.ui.tooling.preview) // Use alias
    debugImplementation(libs.androidx.ui.tooling)    // Use alias
}
