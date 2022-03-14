import org.jetbrains.compose.compose
import com.example.petshopjetpackdemo.buildsrc.Libs

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
                api(Libs.AndroidX.appcompat)
                api(Libs.AndroidX.coreKtx)

                api(Libs.AndroidX.Activity.activityCompose)
                api(Libs.AndroidX.Lifecycle.viewModelCompose)
                api(Libs.AndroidX.Compose.ui)
                api(Libs.AndroidX.Compose.toolingPreview)
                api(Libs.AndroidX.Compose.material)
                api(Libs.AndroidX.Compose.runtime)
                api(Libs.AndroidX.Compose.iconsExtended)
                api(Libs.AndroidX.Compose.liveData)

                api(Libs.AndroidX.Navigation.navigationCompose)

                api(Libs.AndroidX.ConstraintLayout.constraintLayoutCompose)

                api(Libs.Accompanist.insets)
                api(Libs.Accompanist.systemuicontroller)
                api(Libs.Accompanist.flowlayouts)

                api(Libs.Coil.coilCompose)
            }
        }
        val desktopMain by getting {
            dependencies {
                api(compose.preview)
                api(compose.desktop.common)
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