package com.json;

import android.os.Handler;
import com.amazon.aps.shared.metrics.model.ApsMetricsDataMap;
import com.json.environment.thread.IronSourceThreadManager;
import com.mbridge.msdk.foundation.download.core.DownloadCommon;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes7.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0011\u0012\b\b\u0002\u0010\u0010\u001a\u00020\r¢\u0006\u0004\b\u0011\u0010\u0012J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0018\u0010\n\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\b\b\u0002\u0010\t\u001a\u00020\bJ\u000e\u0010\n\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006J\u000e\u0010\u000b\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010\n\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\u0002R\u0017\u0010\u0010\u001a\u00020\r8\u0006¢\u0006\f\n\u0004\b\n\u0010\u000e\u001a\u0004\b\n\u0010\u000f¨\u0006\u0013"}, d2 = {"Lcom/ironsource/xi;", "", "Ljava/lang/Runnable;", "runnable", "", ApsMetricsDataMap.APSMETRICS_FIELD_CUSTOM, "Lcom/ironsource/hr;", "task", "", "delay", "a", DownloadCommon.DOWNLOAD_REPORT_FIND_FILE_RESULT_VALUE_B, "callback", "Landroid/os/Handler;", "Landroid/os/Handler;", "()Landroid/os/Handler;", "handler", "<init>", "(Landroid/os/Handler;)V", "mediationsdk_release"}, k = 1, mv = {1, 8, 0})
public final class xi {

    /* JADX INFO: renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final Handler handler;

    @Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016¨\u0006\u0004"}, d2 = {"com/ironsource/xi$a", "Lcom/ironsource/hr;", "", "a", "mediationsdk_release"}, k = 1, mv = {1, 8, 0})
    public static final class a extends hr {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ Runnable f4590a;

        a(Runnable runnable) {
            this.f4590a = runnable;
        }

        @Override // com.json.hr
        public void a() {
            this.f4590a.run();
        }
    }

    public xi() {
        this(null, 1, 0 == true ? 1 : 0);
    }

    public xi(Handler handler) {
        Intrinsics.checkNotNullParameter(handler, "handler");
        this.handler = handler;
    }

    public /* synthetic */ xi(Handler handler, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? new Handler(IronSourceThreadManager.INSTANCE.getSharedManagersThread().getLooper()) : handler);
    }

    public static /* synthetic */ void a(xi xiVar, hr hrVar, long j, int i, Object obj) {
        if ((i & 2) != 0) {
            j = 0;
        }
        xiVar.a(hrVar, j);
    }

    private final void c(Runnable runnable) {
        hr aVar = runnable instanceof hr ? (hr) runnable : new a(runnable);
        if (Thread.currentThread().getId() == this.handler.getLooper().getThread().getId()) {
            aVar.run();
        } else {
            a(this, aVar, 0L, 2, null);
        }
    }

    /* JADX INFO: renamed from: a, reason: from getter */
    public final Handler getHandler() {
        return this.handler;
    }

    public final void a(hr task) {
        Intrinsics.checkNotNullParameter(task, "task");
        this.handler.removeCallbacks(task);
    }

    public final void a(hr task, long delay) {
        Intrinsics.checkNotNullParameter(task, "task");
        this.handler.postDelayed(task, delay);
    }

    public final void a(Runnable callback) {
        Intrinsics.checkNotNullParameter(callback, "callback");
        c(callback);
    }

    public final void b(Runnable runnable) {
        Intrinsics.checkNotNullParameter(runnable, "runnable");
        c(runnable);
    }
}
