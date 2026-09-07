package com.yandex.div.internal.util;

import android.os.Handler;
import android.os.Looper;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: UiThreadHandler.kt */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u001c\u0010\u0006\u001a\u00020\u00072\u000e\b\u0004\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\tH\u0086\bø\u0001\u0000J\u0010\u0010\u0006\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\u000bH\u0007J\b\u0010\f\u001a\u00020\u0004H\u0007J\b\u0010\r\u001a\u00020\u000eH\u0007J\b\u0010\u000f\u001a\u00020\u0010H\u0007J\u0014\u0010\u0011\u001a\u00020\u000e2\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00070\tR\u0010\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0004\n\u0002\b\u0005\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006\u0012"}, d2 = {"Lcom/yandex/div/internal/util/UiThreadHandler;", "", "()V", "INSTANCE", "Landroid/os/Handler;", "INSTANCE$1", "executeOnMainThread", "", "action", "Lkotlin/Function0;", "runnable", "Ljava/lang/Runnable;", "get", "isMainThread", "", "mainThread", "Ljava/lang/Thread;", "postOnMainThread", "utils_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class UiThreadHandler {
    public static final UiThreadHandler INSTANCE = new UiThreadHandler();

    /* JADX INFO: renamed from: INSTANCE$1, reason: from kotlin metadata */
    private static final Handler INSTANCE = new Handler(Looper.getMainLooper());

    private UiThreadHandler() {
    }

    @JvmStatic
    public static final Thread mainThread() {
        Thread thread = Looper.getMainLooper().getThread();
        Intrinsics.checkNotNullExpressionValue(thread, "getMainLooper().thread");
        return thread;
    }

    @JvmStatic
    public static final boolean isMainThread() {
        return Intrinsics.areEqual(Thread.currentThread(), mainThread());
    }

    @JvmStatic
    public static final Handler get() {
        return INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void postOnMainThread$lambda$0(Function0 tmp0) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke();
    }

    public final boolean postOnMainThread(final Function0<Unit> runnable) {
        Intrinsics.checkNotNullParameter(runnable, "runnable");
        return INSTANCE.post(new Runnable() { // from class: com.yandex.div.internal.util.UiThreadHandler$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                UiThreadHandler.postOnMainThread$lambda$0(runnable);
            }
        });
    }

    @JvmStatic
    public static final void executeOnMainThread(Runnable runnable) {
        Intrinsics.checkNotNullParameter(runnable, "runnable");
        if (isMainThread()) {
            runnable.run();
        } else {
            INSTANCE.post(runnable);
        }
    }

    public final void executeOnMainThread(final Function0<Unit> action) {
        Intrinsics.checkNotNullParameter(action, "action");
        if (isMainThread()) {
            action.invoke();
        } else {
            get().post(new Runnable() { // from class: com.yandex.div.internal.util.UiThreadHandler.executeOnMainThread.1
                @Override // java.lang.Runnable
                public final void run() {
                    action.invoke();
                }
            });
        }
    }
}
