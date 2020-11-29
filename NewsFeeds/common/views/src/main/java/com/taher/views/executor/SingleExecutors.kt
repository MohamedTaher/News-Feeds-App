/*
 * Created by Mohamed Taher on 2/11/19 3:19 PM
 * Copyright (c) 2019 . All rights reserved.
 * Last modified 2/11/19 3:12 PM
 */

package com.taher.views.executor

import java.util.concurrent.Executor

/**
 * Allow instant execution of tasks.
 */
class SingleExecutors : AppExecutors(instant, instant, instant) {
    companion object {
        private val instant = Executor { command -> command.run() }
    }
}