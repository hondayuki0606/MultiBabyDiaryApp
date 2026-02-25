plugins {
    alias(libs.plugins.androidApplication)
    alias(libs.plugins.kotlinAndroid)
    id("com.google.devtools.ksp")
}

android {
    namespace = "com.example.multibabydiaryapp.android"
    compileSdk = 34
    defaultConfig {
        applicationId = "com.example.multibabydiaryapp.android"
        minSdk = 30
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"
    }
    buildFeatures {
        compose = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = libs.versions.compose.compiler.get()
    }
    packaging {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }
    buildTypes {
        getByName("release") {
            isMinifyEnabled = false
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

dependencies {
    implementation(projects.shared)
    implementation(libs.compose.ui)
    implementation(libs.compose.ui.tooling.preview)
    implementation(libs.compose.material3)
    implementation(libs.androidx.activity.compose)
    debugImplementation(libs.compose.ui.tooling)

    // Hilt Navigation
    implementation("androidx.hilt:hilt-navigation-compose:1.2.0")
    // Use Dagger Hilt
    implementation("com.google.dagger:hilt-android:2.49")
    // ksp("com.google.dagger:hilt-android-compiler:2.48")
    annotationProcessor("androidx.hilt:hilt-compiler:1.2.0")

    // compose
    implementation(platform("androidx.compose:compose-bom:2023.03.00"))
    // bomを使用しているのでcomposeのバージョンは指定しない
    implementation("androidx.compose.ui:ui")
    implementation("androidx.compose.ui:ui-graphics")
    implementation("androidx.compose.ui:ui-tooling-preview")
    implementation("androidx.compose.material3:material3")

}