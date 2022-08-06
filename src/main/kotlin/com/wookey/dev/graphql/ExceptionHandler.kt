package com.wookey.dev.graphql

import graphql.ErrorClassification
import graphql.ErrorType
import graphql.GraphQLError
import graphql.language.SourceLocation
import graphql.schema.DataFetchingEnvironment
import org.springframework.graphql.execution.DataFetcherExceptionResolver
import org.springframework.stereotype.Component
import reactor.core.publisher.Mono

@Component
class ExceptionHandler : DataFetcherExceptionResolver {
    override fun resolveException(
        exception: Throwable,
        environment: DataFetchingEnvironment
    ): Mono<List<GraphQLError>> {
        if (exception is NullPointerException) {
            return Mono.just(listOf(CustomError("npe", ErrorType.NullValueInNonNullableField)))
        }

        if (exception is CustomException) {
            val message = exception.message ?: ""
            return Mono.just(listOf(CustomError(message, CustomErrorType.CUSTOM_ERROR)))
        }

        return Mono.empty()
    }
}

class CustomException(msg: String) : RuntimeException(msg)

class CustomError(
    private val massage: String,
    private val type: ErrorClassification
) : GraphQLError {
    override fun getMessage(): String {
        return massage
    }

    override fun getLocations(): MutableList<SourceLocation> {
        return mutableListOf()
    }

    override fun getErrorType(): ErrorClassification {
        return type
    }

}

enum class CustomErrorType : ErrorClassification {
    CUSTOM_ERROR
}