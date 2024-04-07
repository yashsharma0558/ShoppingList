plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.jetbrains.kotlin.android)
    id("org.jetbrains.kotlin.kapt")
}
buildscript {
    repositories {
        maven {
            url = uri("https://plugins.gradle.org/m2/")
        }
    }
    dependencies {
        classpath("org.jetbrains.kotlin:kotlin-gradle-plugin:2.0.0-Beta5")
    }
}

android {
    namespace = "com.example.shoppinglist"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.example.shoppinglist"
        minSdk = 16
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        release {
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
    }
}
apply(plugin = "org.jetbrains.kotlin.kapt")
dependencies {

    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.appcompat)
    implementation(libs.material)
    implementation(libs.androidx.activity)
    implementation(libs.androidx.constraintlayout)
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)

    //Room
    val room_version = "2.6.1"
    implementation("androidx.room:room-runtime:$room_version")
    kapt("androidx.room:room-compiler:$room_version")
    // optional - Kotlin Extensions and Coroutines support for Room
    implementation("androidx.room:room-ktx:$room_version")
    implementation(libs.kotlinx.coroutines.core)  // Updated version
    implementation(libs.kotlinx.coroutines.android)  // Updated version
    implementation(libs.material.v161)  // Updated version
    // Include lifecycle-viewmodel-ktx for ViewModel (recommended for Kotlin)
    implementation(libs.androidx.lifecycle.viewmodel.ktx)

    // Optional: Include Kodein for dependency injection
//     implementation(libs.kodein.di.generic.jvm)
//     implementation(libs.kodein.di.framework.android.x)
}