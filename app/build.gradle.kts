
plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android") version "1.8.10" apply false
}

android {
    namespace 'co.uk.bbk.culinarycompanion'
    compileSdk = 33

    defaultConfig {
        applicationId = "co.uk.bbk.culinarycompanion"
        minSdk = 21
        targetSdk = 33
        versionCode = 1
        versionName = "1.0"
    }

    buildTypes {
        release {
            minifyEnabled = false
        }
    }
}

dependencies {
}
