package com.ogury.core.internal;

import android.util.Log;
import com.unity3d.ads.core.domain.HandleInvocationsFromAdViewer;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: IntegrationLogger.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u0003\n\u0002\b\u0005\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0005H\u0007J\u0010\u0010\u0010\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0005H\u0007J\u0010\u0010\u0010\u001a\u00020\u000e2\u0006\u0010\u0011\u001a\u00020\u0012H\u0007J\u0010\u0010\u0013\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0005H\u0007J\u0010\u0010\u0014\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0005H\u0007J\u0010\u0010\u0013\u001a\u00020\u000e2\u0006\u0010\u0011\u001a\u00020\u0012H\u0007J\u0018\u0010\u0015\u001a\u00020\u000e2\u0006\u0010\u0016\u001a\u00020\u00072\u0006\u0010\u000f\u001a\u00020\u0005H\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R$\u0010\u0006\u001a\u00020\u00078\u0006@\u0006X\u0087\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b\b\u0010\u0003\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\f¨\u0006\u0017"}, d2 = {"Lcom/ogury/core/internal/IntegrationLogger;", "", "<init>", "()V", "TAG", "", "level", "", "getLevel$annotations", "getLevel", "()I", "setLevel", "(I)V", "d", "", "message", "i", "throwable", "", "e", "w", "print", HandleInvocationsFromAdViewer.KEY_DOWNLOAD_PRIORITY, "sdk-core_prodRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class IntegrationLogger {
    private static final String TAG = "OGURY";
    public static final IntegrationLogger INSTANCE = new IntegrationLogger();
    private static int level = 4;

    private IntegrationLogger() {
    }

    @JvmStatic
    public static final void d(String message) {
        Intrinsics.checkNotNullParameter(message, "message");
        INSTANCE.print(3, message);
    }

    @JvmStatic
    public static final void e(String message) {
        Intrinsics.checkNotNullParameter(message, "message");
        INSTANCE.print(6, message);
    }

    public static final int getLevel() {
        return level;
    }

    @JvmStatic
    public static /* synthetic */ void getLevel$annotations() {
    }

    @JvmStatic
    public static final void i(String message) {
        Intrinsics.checkNotNullParameter(message, "message");
        INSTANCE.print(4, message);
    }

    private final void print(int priority, String message) {
        if (priority >= level) {
            Log.println(priority, TAG, message);
        }
    }

    public static final void setLevel(int i) {
        level = i;
    }

    @JvmStatic
    public static final void w(String message) {
        Intrinsics.checkNotNullParameter(message, "message");
        INSTANCE.print(5, message);
    }

    @JvmStatic
    public static final void e(Throwable throwable) {
        Intrinsics.checkNotNullParameter(throwable, "throwable");
        INSTANCE.print(6, throwable.getMessage() + "\n" + Log.getStackTraceString(throwable));
    }

    @JvmStatic
    public static final void i(Throwable throwable) {
        Intrinsics.checkNotNullParameter(throwable, "throwable");
        INSTANCE.print(4, "error\n" + Log.getStackTraceString(throwable));
    }
}
