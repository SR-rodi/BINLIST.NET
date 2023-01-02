plugins {
    id(Plugins.application)
    id(Plugins.jetbrains)
    id(Plugins.kapt)
}

android {
    namespace = Config.namespace
    compileSdk = Config.compileSdk

    defaultConfig {
        applicationId = Config.applicationId
        minSdk = Config.minSdk
        targetSdk = Config.minSdk
        versionCode = Config.versionCode
        versionName = Config.versionName

    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro")
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }

    packagingOptions {
        resources {
            excludes.add(Config.excludes)
        }
    }

    buildFeatures {
        viewBinding = true
    }
}

dependencies {

    implementation(Dependencies.Room.runtime)
    implementation(Dependencies.Room.ktx)
    kapt(Dependencies.Room.kapt)

    implementation(Dependencies.Di.core)
    implementation(Dependencies.Di.android)

    implementation(Dependencies.Network.retrofit)
    implementation(Dependencies.Network.converter)
    implementation(Dependencies.Network.gson)

    implementation(Dependencies.Base.core)
    implementation(Dependencies.Base.appcompat)
    implementation(Dependencies.Base.materialUi)
    implementation(Dependencies.Base.viewModel)

}