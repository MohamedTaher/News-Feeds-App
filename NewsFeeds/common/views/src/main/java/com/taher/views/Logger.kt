package com.taher.views

import android.util.Log

class Logger(private val className: String = "") {

    private val tag = "APP - ${this.className} -> "

    fun info(message: String = "") {
        log(Level.Info, message)
    }

    fun error(message: String = "") {
        log(Level.Error, message)
    }

    fun fatalError(message: String = "") {
        log(Level.FatalError, message)
    }

    private fun log(level: Level, message: String) {
        when (level) {
            Level.Info          -> Log.i(tag, message)
            Level.Debug         -> Log.d(tag, message)
            Level.Warning       -> Log.w(tag, message)
            Level.Error         -> Log.e(tag, message)
            Level.FatalError    -> Log.e(tag, "FATAL_ERROR !!! $message")
            Level.Verbose       -> Log.v(tag, message)
        }
    }
}

sealed class Level {
    object Info         : Level()
    object Debug        : Level()
    object Warning      : Level()
    object Error        : Level()
    object FatalError   : Level()
    object Verbose      : Level()
}