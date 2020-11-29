/*
 * Created by Mohamed Taher on 2/11/19 3:19 PM
 * Copyright (c) 2019 . All rights reserved.
 * Last modified 2/11/19 3:12 PM
 */

package com.taher.views.executor

import java.util.concurrent.Executor
import java.util.concurrent.Executors

/**
 * ExecutorType that runs a task on a new background thread.
 */
class DiskIOThreadExecutor : Executor {

    private val diskIO = Executors.newSingleThreadExecutor()

    override fun execute(command: Runnable) { diskIO.execute(command) }
}