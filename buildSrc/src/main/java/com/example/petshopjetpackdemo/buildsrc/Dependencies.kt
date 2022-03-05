package com.example.petshopjetpackdemo.buildsrc

object Libs {

    object Accompanist {
        const val version = "0.23.0"
        const val insets = "com.google.accompanist:accompanist-insets:$version"
        const val systemuicontroller = "com.google.accompanist:accompanist-systemuicontroller:$version"
        const val flowlayouts = "com.google.accompanist:accompanist-flowlayout:$version"
    }

    object Coroutines {
        private const val version = "1.6.0"
        const val android = "org.jetbrains.kotlinx:kotlinx-coroutines-android:$version"
    }

    object AndroidX {
        const val coreKtx = "androidx.core:core-ktx:1.7.0"

        object Compose {
            const val version = "1.1.0"

            const val ui = "androidx.compose.ui:ui:${version}"
            const val runtime = "androidx.compose.runtime:runtime:${version}"
            const val liveData = "androidx.compose.runtime:runtime-livedata:$version"
            const val material = "androidx.compose.material:material:${version}"
            const val tooling = "androidx.compose.ui:ui-tooling:${version}"
            const val toolingPreview = "androidx.compose.ui:ui-tooling-preview:${version}"
            const val iconsExtended = "androidx.compose.material:material-icons-extended:$version"
        }

        object Activity {
            const val activityCompose = "androidx.activity:activity-compose:1.4.0"
        }

        object Lifecycle {
            const val viewModelCompose = "androidx.lifecycle:lifecycle-viewmodel-compose:2.4.0"
        }

        object Navigation {
            const val navigationCompose = "androidx.navigation:navigation-compose:2.4.0"
        }

        object ConstraintLayout {
            const val constraintLayoutCompose =
                "androidx.constraintlayout:constraintlayout-compose:1.0.0"
        }
    }

    object Coil {
        const val coilCompose = "io.coil-kt:coil-compose:1.4.0"
    }
}
