package com.raana.multiplatformapp.data.source.remote

import arrow.core.Either
import com.raana.multiplatformapp.data.source.remote.model.dto.ErrorDto
import com.raana.multiplatformapp.utils.Failure

import io.ktor.client.HttpClient
import io.ktor.client.call.*
import io.ktor.client.engine.*
import io.ktor.client.plugins.*
import io.ktor.client.plugins.contentnegotiation.*
import io.ktor.client.plugins.logging.*
import io.ktor.client.request.*
import io.ktor.client.statement.*
import io.ktor.http.*
import io.ktor.serialization.kotlinx.json.*
import kotlinx.serialization.json.Json

class MissingPageException(response: HttpResponse, cachedResponseText: String) :
    ResponseException(response, cachedResponseText) {
    override val message: String = "Missing page: ${response.call.request.url}. " +
            "Status: ${response.status}."
}


class ApiClient(
    engine: HttpClientEngine,
) {
    val client = HttpClient(engine) {
        expectSuccess = true
        install(ContentNegotiation) {
            json(Json {
                encodeDefaults = true
                prettyPrint = true
                isLenient = true
                ignoreUnknownKeys = true
            })
        }
        install(HttpTimeout) {
            socketTimeoutMillis = 10000
            requestTimeoutMillis = 10000
            connectTimeoutMillis = 10000
        }
//        install(Auth) {
//            bearer {
//                loadTokens {
//                    sendWithoutRequest { true }
//                    runBlocking {
//                        print("token : ${authSettings.getAccessToken().first()}")
//                        BearerTokens(
//                            accessToken = authSettings.getAccessToken().last(),
//                            refreshToken = authSettings.getRefreshToken().last()
//                        )
//                    }
//                }
//            }
//        }
        install(Logging) {
            logger = object : Logger {
                override fun log(message: String) {
                    println(message)
                }
            }
            level = LogLevel.ALL

        }
        HttpResponseValidator {
            handleResponseExceptionWithRequest { exception, request ->
                val clientException = exception as? ClientRequestException
                    ?: return@handleResponseExceptionWithRequest
//                val exceptionResponse = clientException.response
                throw clientException
//                if (exceptionResponse.status == HttpStatusCode.NotFound) {
//                    val exceptionResponseText = exceptionResponse.bodyAsText()
//                    throw MissingPageException(exceptionResponse, exceptionResponseText)
//                }
            }
//            handleResponseExceptionWithRequest { cause, m ->
//                throw cause
//            }
        }
        install(DefaultRequest) {
            header(HttpHeaders.ContentType, ContentType.Application.Json)
        }
    }
}

suspend inline fun <reified T : Any> ApiClient.makeRequest(
    urlBuilder: URLBuilder,
    methodType: HttpMethod = HttpMethod.Get,
    toAppendHeaders: List<Pair<String, String>> = emptyList(),
    noinline body: (HttpRequestBuilder.() -> Unit)? = null
): Either<Failure.NetworkFailure, T> {
    return try {
        // please notice, Ktor Client is switching to a background thread under the hood
        // so the http call doesn't happen on the main thread, even if the coroutine has been launched on Dispatchers.Main
        Either.Right(
            this.client.request(
                url = urlBuilder.build()
            ) {
                method = methodType
//                headers.append("Authorization", "Bearer ${authSettings.getAccessToken().first()}")

                toAppendHeaders.forEach { (key, value) ->
                    headers.append(key, value)
                }
                body?.let { it() }
            }.body()
        )
    } catch (e: RedirectResponseException) { // for 3xx
        val localizedMessage = kotlin.runCatching {
            e.response.body<ErrorDto>().error
        }.getOrNull()

        Either.Left(Failure.NetworkFailure.RedirectException(e,localizedMessage))
    } catch (e: ClientRequestException) { // for 4 xx
        val localizedMessage = kotlin.runCatching {
            e.response.body<ErrorDto>().error?: e.response.body<ErrorDto>().message
        }.getOrNull()

        Either.Left(Failure.NetworkFailure.ClientException(e, localizedMessage))
    } catch (e: ServerResponseException) { // for 5xx
        Either.Left(Failure.NetworkFailure.ServerException(e))
    } catch (e: Exception) {
        Either.Left(Failure.NetworkFailure.UnknownException(e))
    }
}