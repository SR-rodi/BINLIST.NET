object Dependencies {

    object Base {
        private const val coreVersion = "1.9.0"

        const val core = "androidx.core:core-ktx:$coreVersion"
        const val appcompat = "androidx.appcompat:appcompat:1.5.1"
        const val materialUi = "com.google.android.material:material:1.7.0"
        const val viewModel ="androidx.lifecycle:lifecycle-viewmodel-ktx:2.5.1"
    }

    object Room {
        private const val roomVersion = "2.4.3"

        const val runtime = "androidx.room:room-runtime:$roomVersion"
        const val ktx = "androidx.room:room-ktx:$roomVersion"
        const val kapt = "androidx.room:room-compiler:$roomVersion"
    }

    object Di {
        private const val coreVersion = "3.2.2"
        private const val koinVersion = "3.3.0"

        const val core = "io.insert-koin:koin-core:$coreVersion"
        const val android = "io.insert-koin:koin-android:$koinVersion"
    }

    object Network {
        private const val retrofitVersion = "2.9.0"
        private const val gsonVersion = "2.10"

        const val retrofit = "com.squareup.retrofit2:retrofit:$retrofitVersion"
        const val converter = "com.squareup.retrofit2:converter-gson:$retrofitVersion"
        const val gson = "com.google.code.gson:gson:$gsonVersion"
    }
}