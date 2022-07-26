val ktor_version: String by project
val kotlin_version: String by project
val logback_version: String by project

plugins {
    application
    kotlin("jvm") version "1.7.10"
    id("org.jetbrains.kotlin.plugin.serialization") version "1.7.10"
}

group = "com.example"
version = "0.0.1"
application {
    mainClass.set("com.example.ApplicationKt")

    val isDevelopment: Boolean = project.ext.has("development")
    applicationDefaultJvmArgs = listOf("-Dio.ktor.development=$isDevelopment")
}

repositories {
    mavenCentral()
}

dependencies {
    // Ktor의 핵심 구성 요소를 추가합니다.
    implementation("io.ktor:ktor-server-core-jvm:$ktor_version")
    // Kotlin 객체를 JSON과 같은 직렬화된 형식 으로 또는 그 반대로 ktor-serialization-kotlinx-json변환하는 편리한 메커니즘을 제공합니다 .
    // 이를 사용하여 API 출력 형식을 지정하고 JSON으로 구성된 사용자 입력을 사용합니다.
    // 를 사용 하려면 플러그인 도 적용해야 합니다 .ktor-serialization-kotlinx-jsonplugin.serialization
    implementation("io.ktor:ktor-server-content-negotiation-jvm:$ktor_version")
    implementation("io.ktor:ktor-serialization-kotlinx-json-jvm:$ktor_version")
    // Netty 엔진 을 추가하여 외부 애플리케이션 컨테이너에 의존하지 않고도 서버 기능을 사용할 수 있습니다.
    implementation("io.ktor:ktor-server-netty-jvm:$ktor_version")
    // SLF4J 구현을 제공하여 콘솔에서 멋지게 형식화된 로그 를 볼 수 있습니다.
    implementation("ch.qos.logback:logback-classic:$logback_version")
    testImplementation("io.ktor:ktor-server-tests-jvm:$ktor_version")
    testImplementation("org.jetbrains.kotlin:kotlin-test-junit:$kotlin_version")
}