package com.demo

import kotlinx.serialization.KSerializer
import kotlinx.serialization.Serializable

@Serializable
sealed interface DeletionResult {
    @Serializable
    data object Deleted : DeletionResult

    @Serializable
    data object NotFound : DeletionResult
}

sealed interface ResponseOutcome<out R>
data class DecodableBody<R>(val serializer: KSerializer<out R>) : ResponseOutcome<R>
data class ConstantValue<R>(val value: R) : ResponseOutcome<R>

class ResultResponseSpec<R>(
    private val statusMap: Map<Int, ResponseOutcome<R>>
)

interface Endpoint<ResultType> {
    val response: ResultResponseSpec<ResultType>
}

object endpointSuccess : Endpoint<DeletionResult> {
    // IntelliJ suggests removing <DeletionResult>, which would Wasm compilation if removed.
    // Compile the inferred module on Wasm to reproduce the error.
    override val response = ResultResponseSpec<DeletionResult>(
        statusMap = mapOf(
            204 to ConstantValue(DeletionResult.Deleted),
            404 to DecodableBody(DeletionResult.NotFound.serializer())
        )
    )
}
