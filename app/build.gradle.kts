@Suppress("DSL_SCOPE_VIOLATION") // TODO: Remove once KTIJ-19369 is fixed
plugins {
  alias(libs.plugins.androidApplication)
  alias(libs.plugins.kotlinAndroid)
  alias(libs.plugins.ksp)
  alias(libs.plugins.parcelize)
}

android {
  namespace = "ru.expv1n.myweatherapp"
  compileSdk = 34

  defaultConfig {
    applicationId = "ru.expv1n.myweatherapp"
    minSdk = 24
    targetSdk = 34
    versionCode = 1
    versionName = "1.0"

    testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    vectorDrawables {
      useSupportLibrary = true
    }
    val key = property("apikey")?.toString() ?:
    error("You should add api key into gradle.properties")
    buildConfigField("String", "WEATHER_API_KEY", "\"$key\"")
  }

  buildTypes {
    release {
      isMinifyEnabled = false
      proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
    }
  }
  compileOptions {
    sourceCompatibility = JavaVersion.VERSION_1_8
    targetCompatibility = JavaVersion.VERSION_1_8
  }
  kotlinOptions {
    jvmTarget = "1.8"
  }
  buildFeatures {
    compose = true
    buildConfig = true
  }
  composeOptions {
    kotlinCompilerExtensionVersion = "1.5.1"
  }
  packaging {
    resources {
      excludes += "/META-INF/{AL2.0,LGPL2.1}"
    }
  }
}

dependencies {

  implementation(libs.core.ktx)
  implementation(libs.lifecycle.runtime.ktx)
  implementation(libs.activity.compose)
  implementation(platform(libs.compose.bom))
  implementation(libs.ui)
  implementation(libs.ui.graphics)
  implementation(libs.ui.tooling.preview)
  implementation(libs.material3)
  //MVIKotlin
  implementation(libs.mvikotlin.core)
  implementation(libs.mvikotlin.main)
  implementation(libs.mvikotlin.coroutines)
  //Decompose
  implementation(libs.decompose.core)
  implementation(libs.decompose.jetpack)
  //Dagger 2
  implementation(libs.dagger.core)
  ksp(libs.dagger.compiler)
  //Room
  implementation(libs.room.core)
  ksp(libs.room.compiler)
  //Retrofit
  implementation(libs.retorfit.core)
  implementation(libs.retorfit.gsonConverter)
  //Glide
  implementation(libs.glide.compose)
  //Icons material3
  implementation(libs.icons)
  testImplementation(libs.junit)
  androidTestImplementation(libs.androidx.test.ext.junit)
  androidTestImplementation(libs.espresso.core)
  androidTestImplementation(platform(libs.compose.bom))
  androidTestImplementation(libs.ui.test.junit4)
  debugImplementation(libs.ui.tooling)
  debugImplementation(libs.ui.test.manifest)
}