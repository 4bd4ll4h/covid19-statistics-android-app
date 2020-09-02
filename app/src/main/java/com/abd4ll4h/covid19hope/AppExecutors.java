/*
 * Copyright (C) 2017 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.abd4ll4h.covid19hope;

import android.os.Handler;
import android.os.Looper;

import androidx.annotation.NonNull;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;



public class AppExecutors {

    private static final int THREAD_COUNT = 3;

    private final Executor diskIO;

    private final Executor networkIO;

    private final Executor mainThread;

    private AppExecutors(Executor diskIO, Executor networkIO, Executor mainThread) {
        this.diskIO = diskIO;

        this.networkIO = networkIO;
        this.mainThread = mainThread;
    }

    public static AppExecutors getInstance() {
        return InstanceHolder.instance;
    }

    public Executor diskIO() {
        return diskIO;
    }

    public Executor networkIO() {
        return networkIO;
    }

    public Executor mainThread() {
        return mainThread;
    }

    private static final class InstanceHolder {
        private static AppExecutors instance = new AppExecutors(new DiskIOThreadExecutor(),
                Executors.newSingleThreadExecutor(), new MainThreadExecutor());
    }

    private static class MainThreadExecutor implements Executor {
        private Handler mainThreadHandler = new Handler(Looper.getMainLooper());

        @Override
        public void execute(@NonNull Runnable command) {
            mainThreadHandler.post(command);
        }
    }

    static class DiskIOThreadExecutor implements Executor {

        private final Executor mDiskIO;

        public DiskIOThreadExecutor() {
            mDiskIO = Executors.newSingleThreadExecutor();
        }

        @Override
        public void execute(@NonNull Runnable command) {
            mDiskIO.execute(command);
        }
    }

}
