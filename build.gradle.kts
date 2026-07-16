plugins {
  kotlin("jvm") version libs.versions.kotlin
  kotlin("plugin.dataframe") version libs.versions.kotlin
  alias(libs.plugins.testBalloon)
}

group = "com.rafasoares"
version = "1.0-SNAPSHOT"

repositories {
  mavenCentral()
}

dependencies {
  testImplementation(kotlin("test"))
  testImplementation(libs.mockk)
  testImplementation(libs.testBalloon)
}

kotlin {
  jvmToolchain(25)
}
