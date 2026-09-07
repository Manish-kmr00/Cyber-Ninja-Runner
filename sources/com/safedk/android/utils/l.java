package com.safedk.android.utils;

import java.util.concurrent.ExecutorService;

/* JADX INFO: loaded from: classes10.dex */
public class l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final String f8164a = "ThreadingUtils";

    public static void a(ExecutorService executorService, Runnable runnable) {
        if (n.c()) {
            Logger.d(f8164a, "currently in main thread. launching runnable in a new BG thread");
            executorService.execute(runnable);
        } else {
            runnable.run();
        }
    }
}
