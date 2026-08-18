package com.athena.navigation.routes

/**
 * Returns the route pattern string that Jetpack Navigation Compose 2.8+
 * uses internally for a given [AppRoute] type.
 *
 * This matches the output of `kotlinx.serialization.serializer<T>().descriptor.serialName`,
 * which is also the route set by `composable<T>()` / `NavController.navigate(T)`.
 *
 * Provides a compile-time safe alternative to raw route strings and avoids
 * null assertions. If [T] is a local or anonymous class the call will fail
 * at runtime with a clear error message.
 */
inline fun <reified T : AppRoute> requireRoutePattern(): String =
    requireNotNull(T::class.qualifiedName) {
        "No qualified name found for ${T::class.simpleName}. " +
                "Ensure the class is not local or anonymous."
    }
