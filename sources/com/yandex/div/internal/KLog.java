package com.yandex.div.internal;

import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.unity3d.ads.core.domain.HandleInvocationsFromAdViewer;
import com.yandex.div.logging.Severity;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: KLog.kt */
/* JADX INFO: loaded from: classes8.dex */
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u0005J\"\u0010\u000b\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\r2\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\r0\u000fH\u0086\bø\u0001\u0000J*\u0010\u000b\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\u00112\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\r0\u000fH\u0086\bø\u0001\u0000J\"\u0010\u0012\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\r2\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\r0\u000fH\u0086\bø\u0001\u0000J.\u0010\u0012\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\r2\b\u0010\u0010\u001a\u0004\u0018\u00010\u00112\u000e\b\u0002\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\r0\u000fH\u0086\bø\u0001\u0000J\"\u0010\u0013\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\r2\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\r0\u000fH\u0086\bø\u0001\u0000J*\u0010\u0013\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\u00112\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\r0\u000fH\u0086\bø\u0001\u0000J\u0010\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0017H\u0001J \u0010\u0018\u001a\u00020\t2\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\rH\u0001J\u000e\u0010\u001b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u0005J\"\u0010\u001c\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\r2\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\r0\u000fH\u0086\bø\u0001\u0000J*\u0010\u001c\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\u00112\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\r0\u000fH\u0086\bø\u0001\u0000J\"\u0010\u001d\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\r2\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\r0\u000fH\u0086\bø\u0001\u0000J*\u0010\u001d\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\u00112\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\r0\u000fH\u0086\bø\u0001\u0000R\u0017\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006\u001e"}, d2 = {"Lcom/yandex/div/internal/KLog;", "", "()V", "listeners", "", "Lcom/yandex/div/internal/LogListener;", "getListeners", "()Ljava/util/List;", "addListener", "", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "d", "tag", "", "message", "Lkotlin/Function0;", "th", "", "e", "i", "isAtLeast", "", "minLevel", "Lcom/yandex/div/logging/Severity;", "print", HandleInvocationsFromAdViewer.KEY_DOWNLOAD_PRIORITY, "", "removeListener", "v", "w", "logging_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class KLog {
    public static final KLog INSTANCE = new KLog();
    private static final List<LogListener> listeners = new ArrayList();

    private KLog() {
    }

    public final List<LogListener> getListeners() {
        return listeners;
    }

    public final void v(String tag, Function0<String> message) {
        Intrinsics.checkNotNullParameter(tag, "tag");
        Intrinsics.checkNotNullParameter(message, "message");
        if (isAtLeast(Severity.VERBOSE)) {
            print(2, tag, message.invoke());
        }
    }

    public final void v(String tag, Throwable th, Function0<String> message) {
        Intrinsics.checkNotNullParameter(tag, "tag");
        Intrinsics.checkNotNullParameter(th, "th");
        Intrinsics.checkNotNullParameter(message, "message");
        if (isAtLeast(Severity.VERBOSE)) {
            android.util.Log.v(tag, message.invoke(), th);
        }
    }

    public final void d(String tag, Function0<String> message) {
        Intrinsics.checkNotNullParameter(tag, "tag");
        Intrinsics.checkNotNullParameter(message, "message");
        if (isAtLeast(Severity.DEBUG)) {
            print(3, tag, message.invoke());
        }
    }

    public final void d(String tag, Throwable th, Function0<String> message) {
        Intrinsics.checkNotNullParameter(tag, "tag");
        Intrinsics.checkNotNullParameter(th, "th");
        Intrinsics.checkNotNullParameter(message, "message");
        if (isAtLeast(Severity.DEBUG)) {
            android.util.Log.d(tag, message.invoke(), th);
        }
    }

    public final void w(String tag, Function0<String> message) {
        Intrinsics.checkNotNullParameter(tag, "tag");
        Intrinsics.checkNotNullParameter(message, "message");
        if (isAtLeast(Severity.WARNING)) {
            print(5, tag, message.invoke());
        }
    }

    public final void w(String tag, Throwable th, Function0<String> message) {
        Intrinsics.checkNotNullParameter(tag, "tag");
        Intrinsics.checkNotNullParameter(th, "th");
        Intrinsics.checkNotNullParameter(message, "message");
        if (isAtLeast(Severity.WARNING)) {
            android.util.Log.w(tag, message.invoke(), th);
        }
    }

    public final void i(String tag, Function0<String> message) {
        Intrinsics.checkNotNullParameter(tag, "tag");
        Intrinsics.checkNotNullParameter(message, "message");
        if (isAtLeast(Severity.INFO)) {
            print(4, tag, message.invoke());
        }
    }

    public final void i(String tag, Throwable th, Function0<String> message) {
        Intrinsics.checkNotNullParameter(tag, "tag");
        Intrinsics.checkNotNullParameter(th, "th");
        Intrinsics.checkNotNullParameter(message, "message");
        if (isAtLeast(Severity.INFO)) {
            android.util.Log.i(tag, message.invoke(), th);
        }
    }

    public final void e(String tag, Function0<String> message) {
        Intrinsics.checkNotNullParameter(tag, "tag");
        Intrinsics.checkNotNullParameter(message, "message");
        if (isAtLeast(Severity.ERROR)) {
            print(6, tag, message.invoke());
        }
    }

    public static /* synthetic */ void e$default(KLog kLog, String tag, Throwable th, Function0 message, int i, Object obj) {
        if ((i & 4) != 0) {
            message = new Function0<String>() { // from class: com.yandex.div.internal.KLog.e.1
                @Override // kotlin.jvm.functions.Function0
                public final String invoke() {
                    return "";
                }
            };
        }
        Intrinsics.checkNotNullParameter(tag, "tag");
        Intrinsics.checkNotNullParameter(message, "message");
        if (kLog.isAtLeast(Severity.ERROR)) {
            android.util.Log.e(tag, (String) message.invoke(), th);
        }
    }

    public final void e(String tag, Throwable th, Function0<String> message) {
        Intrinsics.checkNotNullParameter(tag, "tag");
        Intrinsics.checkNotNullParameter(message, "message");
        if (isAtLeast(Severity.ERROR)) {
            android.util.Log.e(tag, message.invoke(), th);
        }
    }

    public final void addListener(LogListener listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        List<LogListener> list = listeners;
        synchronized (list) {
            list.add(listener);
        }
    }

    public final void removeListener(LogListener listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        List<LogListener> list = listeners;
        synchronized (list) {
            list.remove(listener);
        }
    }

    public final boolean isAtLeast(Severity minLevel) {
        Intrinsics.checkNotNullParameter(minLevel, "minLevel");
        return Log.isAtLeast(minLevel);
    }

    public final void print(int priority, String tag, String message) {
        Intrinsics.checkNotNullParameter(tag, "tag");
        Intrinsics.checkNotNullParameter(message, "message");
        android.util.Log.println(priority, tag, message);
        List<LogListener> list = listeners;
        synchronized (list) {
            Iterator<T> it = list.iterator();
            while (it.hasNext()) {
                ((LogListener) it.next()).onNewMessage(priority, tag, message);
            }
            Unit unit = Unit.INSTANCE;
        }
    }
}
