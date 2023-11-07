object Dependencies {

    //Basic dependencies for Kotlin and compose
    val coreKtx by lazy { "androidx.core:core-ktx:${Versions.coreKtx}" }
    val compose by lazy { "androidx.activity:activity-compose:${Versions.compose}" }
    val composeBom by lazy { "androidx.compose:compose-bom:${Versions.composeBom}" }
    val composeUI by lazy { "androidx.compose.ui:ui:${Versions.composeUIVersion}" }
    val composeUIAndroid by lazy{"androidx.compose.ui:ui-android:${Versions.composeUIVersion}"}
    val composeUIGraphics by lazy { "androidx.compose.ui:ui-graphics:${Versions.composeUIVersion}" }
    val composeUITooling by lazy { "androidx.compose.ui:ui-tooling:${Versions.composeUIVersion}" }
    val composeUIToolingPreview by lazy { "androidx.compose.ui:ui-tooling-preview:${Versions.composeUIVersion}" }
    val material3 by lazy { "androidx.compose.material3:material3:${Versions.material3}" }
    val lifecycleRuntimeKtx by lazy { "androidx.lifecycle:lifecycle-runtime-ktx:${Versions.lifecycleRuntime}" }
    val appCompact by lazy { "androidx.appcompat:appcompat:${Versions.appCompact}" }
    val material by lazy {"com.google.android.material:material:${Versions.material}"}
    val navigationCompose by lazy {"androidx.navigation:navigation-compose:${Versions.navigationCompose}"}

    //Dependencies for DI
    val hiltAndroid by lazy {"com.google.dagger:hilt-android:${Versions.hilt}"}
    val hiltAndroidCompiler by lazy { "com.google.dagger:hilt-android-compiler:${Versions.hilt}"}
    val hiltCompiler by lazy {"androidx.hilt:hilt-compiler:${Versions.hiltCompiler}"}
    val hiltNavigationCompose by lazy {"androidx.hilt:hilt-navigation-compose:${Versions.hiltNavigationCompose}"}

    //Dependencies for Network API's
    val retrofit by lazy {"com.squareup.retrofit2:retrofit:${Versions.retrofit}"}
    val okhttp by lazy {"com.squareup.okhttp3:okhttp:${Versions.okhttp}"}
    val gsonConverter by lazy{"com.squareup.retrofit2:converter-gson:${Versions.gsonConverter}"}
    val moshi by lazy  {"com.squareup.moshi:moshi-kotlin:${Versions.moshi}"}
    val moshiConverter by lazy {"com.squareup.retrofit2:converter-moshi:${Versions.moshiConverter}"}
    val loggingInterceptor by lazy {"com.squareup.okhttp3:logging-interceptor:${Versions.logginginterceptor}"}

    val coroutinesCore by lazy {"org.jetbrains.kotlinx:kotlinx-coroutines-core:${Versions.coroutines}"}
    val coroutinesAndroid by lazy {"org.jetbrains.kotlinx:kotlinx-coroutines-android:${Versions.coroutines}"}

    //Dependencies for UI beutification
    val coilImageLoader by lazy { "io.coil-kt:coil-compose:${Versions.coilImageLoader}"}
    val materialIcon by lazy {"androidx.compose.material:material-icons-extended:${Versions.composeUIVersion}"}

    //Dependencies for testing
    val junit by lazy {"junit:junit:${Versions.junit}"}
    val junitExt by lazy {"androidx.test.ext:junit:${Versions.junitExt}"}
    val junitJupiter by lazy {"org.junit.jupiter:junit-jupiter:${Versions.junitJupiter}"}

    val mockitoCore by lazy {"org.mockito:mockito-core:${Versions.mockitoCore}"}
    val mockitoInline by lazy {"org.mockito:mockito-inline:${Versions.mockitoInline}"}

    val junitKtx by lazy {"androidx.test.ext:junit-ktx:${Versions.junitKtx}"}
    val archTesting by lazy {"androidx.arch.core:core-testing:${Versions.archTesting}"}

    val coroutinesTesting by lazy {"org.jetbrains.kotlinx:kotlinx-coroutines-test:${Versions.coroutineTesting}"}
    val mockitoKotlin by lazy {"com.nhaarman.mockitokotlin2:mockito-kotlin:${Versions.mockitoKotlin}"}

    val espressoCore by lazy {"androidx.test.espresso:espresso-core:${Versions.espressoCore}"}
}

object Modules{
    const val utilities = ":utilities"
}