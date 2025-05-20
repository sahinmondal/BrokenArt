plugins {
    alias(libs.plugins.android.application)
}

android {
    namespace = "com.tum.brokenart"
    compileSdk = 35

    defaultConfig {
        applicationId = "com.tum.brokenart"
        minSdk = 24
        targetSdk = 35
        versionCode = 3
        versionName = "3"

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
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }
}

dependencies {

    implementation ("com.github.bumptech.glide:glide:4.15.1")
    implementation ("com.google.android.gms:play-services-ads:24.2.0")


    annotationProcessor ("com.github.bumptech.glide:compiler:4.15.1")

    implementation(libs.appcompat)
    implementation(libs.material)
    implementation(libs.activity)
    implementation(libs.constraintlayout)
    testImplementation(libs.junit)
    androidTestImplementation(libs.ext.junit)
    androidTestImplementation(libs.espresso.core)
}