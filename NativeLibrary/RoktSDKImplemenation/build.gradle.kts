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
}

configurations {
    create("copyDependencies")
}


dependencies {
    implementation(libs.roktsdk)
    "copyDependencies"(libs.roktsdk)
}

/*
project.afterEvaluate {
    tasks.register<Copy>("copyDeps") {
        configurations["copyDependencies"].resolvedConfiguration.resolvedArtifacts.forEach { artifact ->
            val file = artifact.file
            from(file)
            into("${buildDir}/outputs/deps")
            rename { fileName ->
                "${artifact.moduleVersion.id.group}.$fileName"
            }
        }

        // Set duplicate handling strategy
        duplicatesStrategy = DuplicatesStrategy.INCLUDE
    }
    tasks.named("preBuild") { finalizedBy("copyDeps") }
}*/
project.afterEvaluate {
    tasks.register("copyDeps") {
        doLast {
            configurations["copyDependencies"].resolvedConfiguration.resolvedArtifacts.forEach { artifact ->
                project.copy {
                    from(artifact.file)
                    into("${buildDir}/outputs/deps")
                    rename { fileName ->
                        "${artifact.moduleVersion.id.group}.$fileName"
                    }
                }
            }
        }
    }
    tasks.named("preBuild") {
        finalizedBy("copyDeps")
    }
}
