package com.pubmatic.sdk.common.taskhandler;

import android.os.Looper;
import com.json.m5;
import com.mbridge.msdk.foundation.download.core.DownloadCommon;
import java.util.concurrent.Executor;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 \u00102\u00020\u0001:\u0001\u0010B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0015\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0007\u0010\bJ\u0015\u0010\t\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\t\u0010\bR\u0014\u0010\r\u001a\u00020\n8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000b\u0010\fR\u0014\u0010\u000f\u001a\u00020\n8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000e\u0010\f¨\u0006\u0011"}, d2 = {"Lcom/pubmatic/sdk/common/taskhandler/POBTaskHandler;", "", "<init>", "()V", "Ljava/lang/Runnable;", "runnable", "", "runOnMainThread", "(Ljava/lang/Runnable;)V", "runOnBackgroundThread", "Ljava/util/concurrent/Executor;", "a", "Ljava/util/concurrent/Executor;", "backgroundThreadExecutor", DownloadCommon.DOWNLOAD_REPORT_FIND_FILE_RESULT_VALUE_B, "mainThreadExecutor", "Companion", "common_release"}, k = 1, mv = {1, 7, 1})
public final class POBTaskHandler {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static volatile POBTaskHandler c;

    /* JADX INFO: renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final Executor backgroundThreadExecutor;

    /* JADX INFO: renamed from: b, reason: from kotlin metadata */
    private final Executor mainThreadExecutor;

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010\u0005\u001a\u00020\u0004H\u0007R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Lcom/pubmatic/sdk/common/taskhandler/POBTaskHandler$Companion;", "", "()V", m5.p, "Lcom/pubmatic/sdk/common/taskhandler/POBTaskHandler;", "getInstance", "common_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @JvmStatic
        public final POBTaskHandler getInstance() {
            POBTaskHandler pOBTaskHandler = POBTaskHandler.c;
            if (pOBTaskHandler == null) {
                synchronized (this) {
                    pOBTaskHandler = POBTaskHandler.c;
                    if (pOBTaskHandler == null) {
                        pOBTaskHandler = new POBTaskHandler(null);
                        POBTaskHandler.c = pOBTaskHandler;
                    }
                }
            }
            return pOBTaskHandler;
        }

        private Companion() {
        }
    }

    public /* synthetic */ POBTaskHandler(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    @JvmStatic
    public static final POBTaskHandler getInstance() {
        return INSTANCE.getInstance();
    }

    public final void runOnBackgroundThread(Runnable runnable) {
        Intrinsics.checkNotNullParameter(runnable, "runnable");
        if (Intrinsics.areEqual(Looper.getMainLooper(), Looper.myLooper())) {
            this.backgroundThreadExecutor.execute(runnable);
        } else {
            runnable.run();
        }
    }

    public final void runOnMainThread(Runnable runnable) {
        Intrinsics.checkNotNullParameter(runnable, "runnable");
        if (Intrinsics.areEqual(Looper.getMainLooper(), Looper.myLooper())) {
            runnable.run();
        } else {
            this.mainThreadExecutor.execute(runnable);
        }
    }

    private POBTaskHandler() {
        this.backgroundThreadExecutor = new POBBackgroundThreadExecutor();
        this.mainThreadExecutor = new POBMainThreadExecutor();
    }
}
