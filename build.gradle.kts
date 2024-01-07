plugins {
    id("java")
    id("com.github.weave-mc.weave-gradle") version "649dba7468"
}

group = "org.cubewhy"
version = "1.0-SNAPSHOT"

minecraft.version("1.8.9")

repositories {
    maven("https://jitpack.io")
    maven("https://repo.spongepowered.org/maven/")
    mavenCentral()
}

dependencies {
    compileOnly("com.github.weave-mc:weave-loader:v0.2.4")

    compileOnly("org.spongepowered:mixin:0.8.5")
}