plugins {
    kotlin("jvm") version "1.9.10"
    application
}

group = "com.example.banking"
version = "1.0"

repositories {
    mavenCentral()
}

dependencies {
    implementation(kotlin("stdlib"))
}

application {
    // Specify the main class
    mainClass.set("BankingAppMainKt")
}

tasks.jar {
    manifest {
        attributes["Main-Class"] = "BankingAppMainKt" // Kotlin's main file (add "Kt" at the end of main file)
    }
    
    // Add all necessary dependencies in the JAR
    from(configurations.runtimeClasspath.get().map { if (it.isDirectory) it else zipTree(it) })
    
    // Ensure that the compiled Kotlin classes are included
    with(tasks.getByName("jar") as CopySpec)
}

