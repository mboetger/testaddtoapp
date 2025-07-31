plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.kotlin.android)
}

android {
    namespace = "com.example.testaddtoapp"
    compileSdk = 36

    defaultConfig {
        applicationId = "com.example.testaddtoapp"
        minSdk = 29
        targetSdk = 36
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        ndk {
          abiFilters += listOf("armeabi-v7a", "arm64-v8a", "x86_64")
        }
    }

    buildTypes {
        debug {
          ndk {
            debugSymbolLevel = "FULL"
          }
          packaging.jniLibs.keepDebugSymbols.add("**/*.so")
          isDebuggable = true
        }
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
        create("profile") {
          initWith(getByName("debug"))
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }
    kotlinOptions {
        jvmTarget = "11"
    }
    ndkVersion = "26.1.10909125"
    configurations {
      getByName("profileImplementation") {}
    }
}

dependencies {

    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.appcompat)
    implementation(libs.material)
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
  
    // Flutter Module
    debugImplementation("com.example.flutter_module:flutter_debug:1.0")
    releaseImplementation("com.example.flutter_module:flutter_release:1.0")
    add("profileImplementation", "com.example.flutter_module:flutter_profile:1.0")
}
