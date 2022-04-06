<h1 align="center">RSA4K</h1>

<p align="center">A RSA Cipher implementation for Kotlin/Java.</p>

<div align="center">
    <a href="https://discord.gg/5UmsQP4MFH"><img src="https://img.shields.io/discord/610120595765723137?logo=discord" alt="Discord"/></a>
    <br><br>
    <img src="https://img.shields.io/github/last-commit/Lyzev/RSA4K" alt="GitHub last commit"/>
    <img src="https://img.shields.io/github/commit-activity/w/Lyzev/RSA4K" alt="GitHub commit activity"/>
    <br>
    <img src="https://img.shields.io/github/languages/code-size/Lyzev/RSA4K" alt="GitHub code size in bytes"/>
    <img src="https://img.shields.io/github/contributors/Lyzev/RSA4K" alt="GitHub contributors"/>
</div>

## Usage

[![](https://jitpack.io/v/Lyzev/RSA4K.svg?label=Release)](https://jitpack.io/#Lyzev/RSA4K)

### Import

Replace `${version}` with the current version!

<details>
        <summary>Gradle KTS</summary>

```kotlin
repositories {
    maven("https://jitpack.io")
}

dependencies {
    implementation("com.github.Lyzev:RSA4K:${version}")
}
```

</details>

<details>
        <summary>Gradle Groovy</summary>

```
repositories {
	maven { url 'https://jitpack.io' }
}

dependencies {
    implementation 'com.github.Lyzev:RSA4K:${version}'
}
```

</details>

<details>
        <summary>Maven</summary>

```
<repositories>
    <repository>
        <id>jitpack.io</id>
        <url>https://jitpack.io</url>
    </repository>
</repositories>

<dependencies>
    <dependency>
        <groupId>com.github.Lyzev</groupId>
        <artifactId>RSA4K</artifactId>
        <version>${version}</version>
    </dependency>
</dependencies>
```

</details>

<details>
        <summary>Raw Jar</summary>

1. Go to the [release page](https://github.com/Lyzev/RSA4K/releases).
2. Download RSA4K-${version}-all.jar.
3. Add the jar to your classpath.

</details>

### Example

```kotlin
fun main() {
    val keys = RSAKeyFactory.genKeyPair()
    val cipher = RSA(keys.first, keys.second)
    val msg = "Test"

    val encrypted = cipher.encrypt(msg.encodeToByteArray())
    val decrypted = String(cipher.decrypt(encrypted!!))

    println("public exponent -> ${keys.first.exp}")
    println("public modulus -> ${keys.first.mod}")
    println("private exponent -> ${keys.second.exp}")
    println("private modulus -> ${keys.second.mod}")
    println("encrypted -> $encrypted")
    println("decrypted -> $decrypted")
}
```

## Documentation

You can find the documentation [here](https://lyzev.github.io/RSA4K/dokka).

## Code Quality Monitoring

You can find the qodana report [here](https://lyzev.github.io/RSA4K/qodana).

## Bugs and Suggestions

Bug reports and suggestions should be made in this repo's [issue tracker](https://github.com/Lyzev/RSA4K/issues)
using the templates provided. Please provide as much information as you can to best help us understand your issue and
give a better chance of it being resolved.

## Important
Please note that this repository is for educational purposes only. There may be some security issues, because the author isn't a professional cryptologist. It#s recommend to use the rsa implementation of java.
