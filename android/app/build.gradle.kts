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

    // TopOn (AnyThink) Mediation Core & Formats
    implementation("com.anythink.sdk:core:6.4.88")
    implementation("com.anythink.sdk:rewardedvideo:6.4.88")
    implementation("com.anythink.sdk:interstitial:6.4.88")

    // TopOn Mintegral Adapter
    implementation("com.anythink.sdk:adapter-tpn-mintegral:6.4.88")

    // Mintegral SDK
    implementation("com.mbridge.msdk.oversea:reward:16.8.61")
    implementation("com.mbridge.msdk.oversea:newinterstitial:16.8.61")
    implementation("com.mbridge.msdk.oversea:mbbid:16.8.61")
    implementation("com.mbridge.msdk.oversea:videocommon:16.8.61")
}

kotlin {
    compilerOptions {
        jvmTarget = org.jetbrains.kotlin.gradle.dsl.JvmTarget.JVM_17
    }
}

flutter {
    source = "../.."
}
