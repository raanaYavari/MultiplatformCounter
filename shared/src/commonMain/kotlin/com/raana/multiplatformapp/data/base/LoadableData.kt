package com.raana.multiplatformapp.data.base

import com.raana.multiplatformapp.utils.Failure

/**
 * A wrapper for data that is loadable and can have multiple states: Not loaded, Loaded, In loading and error
 */
sealed class LoadableData<out T> {

    abstract val data: T?

    /**
     * Use this function to map a LoadableData value to the corresponding mapper function result.
     */
    fun <O> map(mapper: (T) -> O): LoadableData<O> {
        return when (this) {
            is Loaded -> Loaded(mapper(data))
            is Failed -> Failed(failure, title)
            is Loading -> Loading
            is NotLoaded -> NotLoaded
        }
    }

    fun <O> flatMap(mapper: (LoadableData<T>) -> LoadableData<O>): LoadableData<O> {
        return mapper(this)
    }

    fun fold(
        onLoading: () -> Unit,
        onSuccess: (data: T) -> Unit,
        onError: (failure: Failure, title: String?) -> Unit,
        onNotLoaded: () -> Unit = {}
    ): LoadableData<T> {
        val action = when (this) {
            Loading -> onLoading()
            is Loaded -> onSuccess(data)
            is Failed -> onError(failure, title)
            NotLoaded -> { /* no action needed */
            }
        }
        return this
    }

    fun onLoad(function: (data: T) -> Unit): LoadableData<T> {
        if (this is Loaded) function(data)
        return this
    }

    fun onLoading(function: () -> Unit): LoadableData<T> {
        if (this is Loading) function()
        return this
    }

    fun onFailed(function: (failure: Failure, title: String?) -> Unit): LoadableData<T> {
        if (this is Failed) function(failure, title)
        return this
    }
}

data class Loaded<T>(override val data: T) : LoadableData<T>()

data class Failed<T>(
    val failure: Failure,
    val title: String? = null,
) : LoadableData<T>() {
    override val data: T?
        get() = null
}

object Loading : LoadableData<Nothing>() {
    override val data: Nothing?
        get() = null
}

object NotLoaded : LoadableData<Nothing>() {
    override val data: Nothing?
        get() = null
}