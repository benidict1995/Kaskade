package dev.gumil.kaskade.coroutines

import dev.gumil.kaskade.Action
import dev.gumil.kaskade.Kaskade
import dev.gumil.kaskade.State
import kotlinx.coroutines.CoroutineScope

/**
 * Extension function for building the coroutines DSL with independent scopes.
 *
 * @param builder function to build the DSL.
 */
fun <A : Action, S : State> Kaskade.Builder<A, S>.coroutines(builder: CoroutinesKaskadeBuilder<A, S>.() -> Unit) {
    builder(CoroutinesKaskadeBuilder(this))
}

/**
 * Extension function for building the coroutines DSL with a shared scope.
 *
 * @param scope coroutine scope to run suspending functions.
 * @param builder function to build the DSL.
 */
fun <A : Action, S : State> Kaskade.Builder<A, S>.coroutines(
    scope: CoroutineScope,
    builder: CoroutinesScopedKaskadeBuilder<A, S>.() -> Unit
) {
    builder(CoroutinesScopedKaskadeBuilder(scope, this))
}
