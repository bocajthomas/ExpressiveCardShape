plugins {
    alias(libs.plugins.android.library)
    alias(libs.plugins.kotlin.android)
    alias(libs.plugins.kotlin.compose)
    id("com.vanniktech.maven.publish")
}

android {
    namespace = "uk.co.bocajsolutions.cardshape"
    compileSdk {
        version = release(36)
    }

    defaultConfig {
        minSdk = 28
        testInstrumentationRunner = "android.support.test.runner.AndroidJUnitRunner"
        consumerProguardFiles("consumer-rules.pro")
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }
    kotlinOptions {
        jvmTarget = "17"
    }
}

dependencies {
    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.lifecycle.runtime.ktx)
    implementation(libs.androidx.activity.compose)
    implementation(platform(libs.androidx.compose.bom))
    implementation(libs.androidx.compose.ui)
    implementation(libs.androidx.compose.ui.graphics)
    implementation(libs.androidx.compose.ui.tooling.preview)
    implementation(libs.androidx.material3)
    implementation(libs.androidx.material.icons.core)
    implementation(libs.androidx.material.icons.extended)
    implementation(libs.appcompat.v7)
    testImplementation(libs.junit)
    androidTestImplementation(libs.runner)
    androidTestImplementation(libs.espresso.core)
}

mavenPublishing {
    publishToMavenCentral()
    signAllPublications()

    coordinates("uk.co.bocajsolutions", "cardshape", "1.0.0")

    pom {
        name.set("CardShape")
        description.set("M3 Expressive card grouping for jetpack compose")
        inceptionYear.set("2025")
        url.set("https://github.com/bocajthomas/ExpressiveCardShape")
        licenses {
            license {
                name.set("The Apache License, Version 2.0")
                url.set("http://www.apache.org/licenses/LICENSE-2.0.txt")
                distribution.set("repo")
            }
        }
        developers {
            developer {
                id.set("bocajthomas")
                name.set("bocajthomas")
                url.set("https://github.com/bocajthomas")
            }
        }
        scm {
            url.set("https://github.com/bocajthomas/ExpressiveCardShape")
            connection.set("scm:git:git://github.com/bocajthomas/ExpressiveCardShape.git")
            developerConnection.set("scm:git:ssh://git@github.com/bocajthomas/ExpressiveCardShape.git")
        }
    }
}