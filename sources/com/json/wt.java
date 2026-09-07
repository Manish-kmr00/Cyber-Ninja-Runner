package com.json;

import com.mbridge.msdk.foundation.download.core.DownloadCommon;
import java.util.concurrent.TimeUnit;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\r\u0010\u000eJ\u001a\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\u0005\u001a\u00020\u0004H\u0007R\u001b\u0010\f\u001a\u00020\b8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u0007\u0010\u000b¨\u0006\u000f"}, d2 = {"Lcom/ironsource/wt;", "", "Ljava/lang/Runnable;", "action", "", "delay", "", "a", "Lcom/ironsource/ir;", DownloadCommon.DOWNLOAD_REPORT_FIND_FILE_RESULT_VALUE_B, "Lkotlin/Lazy;", "()Lcom/ironsource/ir;", "longBlockingTasksExecutorService", "<init>", "()V", "mediationsdk_release"}, k = 1, mv = {1, 8, 0})
public final class wt {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final wt f4570a = new wt();

    /* JADX INFO: renamed from: b, reason: from kotlin metadata */
    private static final Lazy longBlockingTasksExecutorService = LazyKt.lazy(a.f4571a);

    @Metadata(d1 = {"\u0000\b\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"Lcom/ironsource/ir;", "a", "()Lcom/ironsource/ir;"}, k = 3, mv = {1, 8, 0})
    static final class a extends Lambda implements Function0<ir> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final a f4571a = new a();

        a() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final ir invoke() {
            return new ir(16, null, null, 6, null);
        }
    }

    private wt() {
    }

    private final ir a() {
        return (ir) longBlockingTasksExecutorService.getValue();
    }

    public static /* synthetic */ void a(wt wtVar, Runnable runnable, long j, int i, Object obj) {
        if ((i & 2) != 0) {
            j = 0;
        }
        wtVar.a(runnable, j);
    }

    public final void a(Runnable action) {
        Intrinsics.checkNotNullParameter(action, "action");
        a(this, action, 0L, 2, null);
    }

    public final void a(Runnable action, long delay) {
        Intrinsics.checkNotNullParameter(action, "action");
        a().schedule(action, delay, TimeUnit.MILLISECONDS);
    }
}
