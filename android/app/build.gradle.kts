plugins {
    id("com.android.application")
    // The Flutter Gradle Plugin must be applied after the Android and Kotlin Gradle plugins.
    id("dev.flutter.flutter-gradle-plugin")
}

android {
    namespace = "com.moonedgestudio.cyberninjarunner"
    compileSdk = flutter.compileSdkVersion

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }

    defaultConfig {
        applicationId = "com.moonedgestudio.cyberninjarunner"
        minSdk = flutter.minSdkVersion
        targetSdk = flutter.targetSdkVersion
        versionCode = flutter.versionCode
        versionName = flutter.versionName
    }

    buildTypes {
        release {
            signingConfig = signingConfigs.getByName("debug")
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }

    sourceSets {
        getByName("main") {
            jniLibs.srcDirs("src/main/jniLibs")
        }
    }

    androidResources {
        noCompress += listOf("bank")
    }
}

dependencies {
    implementation(fileTree(mapOf("dir" to "libs", "include" to listOf("*.jar"))))

    // TopOn (AnyThink) New-Platform SDK v6.6.22 Core (Consolidated Formats: Rewarded, Interstitial, Banner, Splash)
    implementation("com.anythink.sdk:core-tpn:6.6.22")

    // TopOn New-Platform AdMob Adapter
    implementation("com.anythink.sdk:adapter-tpn-admob:25.4.0.1.0")

    // Google Mobile Ads SDK (AdMob) v25.4.0
    implementation("com.google.android.gms:play-services-ads:25.4.0")
}

kotlin {
    compilerOptions {
        jvmTarget = org.jetbrains.kotlin.gradle.dsl.JvmTarget.JVM_17
    }
}

flutter {
    source = "../.."
}
