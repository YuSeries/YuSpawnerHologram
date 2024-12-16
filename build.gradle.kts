import io.izzel.taboolib.gradle.*

plugins {
    java
    id("io.izzel.taboolib") version "2.0.22"
    id("org.jetbrains.kotlin.jvm") version "1.9.22"
}

taboolib {
    env {
        install(
            Basic, I18n, Metrics, Bukkit, CommandHelper, BukkitHook, BukkitUtil
        )
    }
    description {
        name = rootProject.name
        desc("Visualize your spawner respawn time!")
        contributors {
            name("L1An")
        }
        dependencies {
            name("MythicMobs")
            name("PlaceholderAPI").optional(true)
            name("HolographicDisplays").optional(true)
            name("DecentHolograms").optional(true)
            name("Adyeshach").optional(true)
        }
    }
    version { taboolib = "6.2.1-f095116" }
    relocate("com.github.l1an.artisan", "${project.group}.artisan")
    relocate("ink.ptms.um", "${project.group}.um")
}

repositories {
    mavenCentral()
    mavenLocal()
    maven(url = "https://mvn.lumine.io/repository/maven-public/")
    maven { url = uri("https://repo.codemc.io/repository/maven-public/") } // HolographicDisplays
    maven { url = uri("https://jitpack.io") } // DecentHolograms
}

dependencies {
    compileOnly("ink.ptms:nms-all:1.0.0")
    compileOnly("ink.ptms.core:v11902:11902-minimize:mapped")
    compileOnly("ink.ptms.core:v11902:11902-minimize:universal")
    implementation("org.yaml:snakeyaml:2.0")
    compileOnly(kotlin("stdlib"))
    compileOnly(fileTree("libs"))
    compileOnly("io.lumine:Mythic-Dist:5.3.5")
    compileOnly("ink.ptms.adyeshach:all:2.0.0-snapshot-1")
    compileOnly("me.filoghost.holographicdisplays:holographicdisplays-api:3.0.0")
    compileOnly("com.github.decentsoftware-eu:decentholograms:2.8.4")
    taboo("ink.ptms:um:1.1.2")
    taboo("com.github.l1an.artisan:Artisan:1.0.2")
}

tasks.withType<JavaCompile> {
    options.encoding = "UTF-8"
}

tasks.withType<org.jetbrains.kotlin.gradle.tasks.KotlinCompile> {
    kotlinOptions {
        jvmTarget = "1.8"
        freeCompilerArgs = listOf("-Xjvm-default=all")
    }
}

configure<JavaPluginConvention> {
    sourceCompatibility = JavaVersion.VERSION_1_8
    targetCompatibility = JavaVersion.VERSION_1_8
}

kotlin {
    sourceSets.all {
        languageSettings {
            languageVersion = "2.0"
        }
    }
}

tasks.withType<Jar> {
    destinationDirectory.set(file("/Users/yuxin/minecraft/servers/1.20.4Test/plugins"))
    //destinationDirectory.set(file("$projectDir/build-jar"))
}