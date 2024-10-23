plugins {
    alias(libs.plugins.android.library)
    alias(libs.plugins.kotlin.android)
}

android {
    namespace = "com.nubisuno.roktsdkimplemenation"
    compileSdk = 34

    defaultConfig {
        minSdk = 21

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
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
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }
    kotlinOptions {
        jvmTarget = "11"
    }
    //    kotlinOptions {
//        jvmTarget = "11"
//    }
}

configurations {
    create("copyDependencies")
}


dependencies {
    implementation(libs.roktsdk)
    "copyDependencies"(libs.roktsdk)
}

project.afterEvaluate {
    tasks.register<Copy>("copyDeps") {
        from(configurations["copyDependencies"])
        into("${buildDir}/outputs/deps")

        // Set duplicate handling strategy
        duplicatesStrategy = DuplicatesStrategy.INCLUDE
    }
    tasks.named("preBuild") { finalizedBy("copyDeps") }
}