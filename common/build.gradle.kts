import org.jetbrains.compose.compose

plugins {
    kotlin("multiplatform")
    id("org.jetbrains.compose") version "1.0.0"
    id("com.android.library")
}

group = "me.krasnova"
version = "1.0"

kotlin {
    android()
    jvm("desktop") {
        compilations.all {
            kotlinOptions.jvmTarget = "11"
        }
    }
    sourceSets {
        val commonMain by getting {
            dependencies {
                api(compose.runtime)
                api(compose.foundation)
                api(compose.material)
            }
        }
        val androidMain by getting {
            dependencies {
                api("androidx.appcompat:appcompat:1.2.0")
                api("androidx.core:core-ktx:1.3.1")

                api("androidx.core:core-ktx:1.7.0")
                api("androidx.activity:activity-compose:1.4.0")
                api("androidx.lifecycle:lifecycle-viewmodel-compose:2.4.0")
                api("androidx.compose.ui:ui:1.1.0")
                api("androidx.compose.ui:ui-tooling-preview:1.1.0")
                api("androidx.compose.material:material:1.1.0")
                api("androidx.compose.runtime:runtime:1.1.0")
                api("androidx.compose.material:material-icons-extended:1.1.0")
                api("androidx.compose.runtime:runtime-livedata:1.1.0")

                api("androidx.navigation:navigation-compose:2.4.0")

                api( "androidx.constraintlayout:constraintlayout-compose:1.0.0")

                api("com.google.accompanist:accompanist-insets:0.23.0")
                api("com.google.accompanist:accompanist-systemuicontroller:0.23.0")
                api("com.google.accompanist:accompanist-flowlayout:0.23.0")

                api("io.coil-kt:coil-compose:1.4.0")
            }
        }
        val desktopMain by getting {
            dependencies {
                api(compose.preview)
            }
        }
    }
}

android {
    compileSdkVersion(31)
    sourceSets["main"].manifest.srcFile("src/androidMain/AndroidManifest.xml")
    defaultConfig {
        minSdkVersion(24)
        targetSdkVersion(31)
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
}