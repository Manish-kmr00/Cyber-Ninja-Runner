import java.util.Properties
import java.io.FileInputStream
import java.io.File

plugins {
    id("com.android.application")
    // The Flutter Gradle Plugin must be applied after the Android and Kotlin Gradle plugins.
    id("dev.flutter.flutter-gradle-plugin")
}

val keystorePropertiesFile = rootProject.file("key.properties")
val keystoreProperties = Properties()
if (keystorePropertiesFile.exists()) {
    keystoreProperties.load(FileInputStream(keystorePropertiesFile))
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
        // Default to Google AdMob Test App ID
        manifestPlaceholders["admobAppId"] = "ca-app-pub-3940256099942544~3347511713"
    }

    signingConfigs {
        create("release") {
            val storeFileProp = keystoreProperties.getProperty("storeFile")
            if (!storeFileProp.isNullOrBlank()) {
                val resolvedFile = if (File(storeFileProp).isAbsolute) File(storeFileProp) else rootProject.file(storeFileProp)
                if (resolvedFile.exists()) {
                    storeFile = resolvedFile
                    storePassword = keystoreProperties.getProperty("storePassword")
                    keyAlias = keystoreProperties.getProperty("keyAlias")
                    keyPassword = keystoreProperties.getProperty("keyPassword")
                }
            }
        }
    }

    buildTypes {
        debug {
            manifestPlaceholders["admobAppId"] = "ca-app-pub-3940256099942544~3347511713"
        }
        release {
            val releaseSigning = signingConfigs.getByName("release")
            if (releaseSigning.storeFile != null && releaseSigning.storeFile!!.exists()) {
                signingConfig = releaseSigning
            } else {
                throw GradleException("Release build cannot proceed: Missing or invalid production signing configuration in android/key.properties")
            }
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
            manifestPlaceholders["admobAppId"] = "ca-app-pub-5727644626056713~7098346023"
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

    // Google User Messaging Platform (UMP) SDK v3.1.0
    implementation("com.google.android.ump:user-messaging-platform:3.1.0")
}

kotlin {
    compilerOptions {
        jvmTarget = org.jetbrains.kotlin.gradle.dsl.JvmTarget.JVM_17
    }
}

flutter {
    source = "../.."
}
