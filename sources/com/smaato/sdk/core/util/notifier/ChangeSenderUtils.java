package com.smaato.sdk.core.util.notifier;

import android.os.Handler;
import com.smaato.sdk.core.util.Threads;

/* JADX INFO: loaded from: classes8.dex */
public final class ChangeSenderUtils {
    public static <N> ChangeSender<N> createChangeSender(N n) {
        return new StandardChangeSender(n);
    }

    public static <N> ChangeSender<N> createDebounceChangeSender(N n, long j) {
        return createDebounceChangeSender(n, j, Threads.newUiHandler());
    }

    public static <N> ChangeSender<N> createDebounceChangeSender(N n, long j, Handler handler) {
        return new DebounceChangeSender(n, handler, j);
    }

    public static <N> ChangeSender<N> createUniqueValueChangeSender(N n) {
        return new UniqueValueChangeSender(n);
    }
}
