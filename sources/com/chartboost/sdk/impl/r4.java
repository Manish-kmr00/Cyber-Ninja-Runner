package com.chartboost.sdk.impl;

import com.mbridge.msdk.foundation.download.core.DownloadCommon;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.ScheduledExecutorService;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u000b\u0010\fR\u001b\u0010\u0007\u001a\u00020\u00028VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001b\u0010\n\u001a\u00020\b8VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\u0005\u0010\u0004\u001a\u0004\b\u0003\u0010\t¨\u0006\r"}, d2 = {"Lcom/chartboost/sdk/impl/r4;", "Lcom/chartboost/sdk/impl/q4;", "Ljava/util/concurrent/ExecutorService;", "a", "Lkotlin/Lazy;", DownloadCommon.DOWNLOAD_REPORT_FIND_FILE_RESULT_VALUE_B, "()Ljava/util/concurrent/ExecutorService;", "networkExecutor", "Ljava/util/concurrent/ScheduledExecutorService;", "()Ljava/util/concurrent/ScheduledExecutorService;", "backgroundExecutor", "<init>", "()V", "ChartboostMonetization-9.8.3_productionRelease"}, k = 1, mv = {1, 8, 0})
public final class r4 implements q4 {

    /* JADX INFO: renamed from: a, reason: collision with root package name and from kotlin metadata */
    public final Lazy networkExecutor = LazyKt.lazy(b.b);

    /* JADX INFO: renamed from: b, reason: from kotlin metadata */
    public final Lazy backgroundExecutor = LazyKt.lazy(a.b);

    @Metadata(d1 = {"\u0000\b\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"Ljava/util/concurrent/ExecutorService;", "a", "()Ljava/util/concurrent/ExecutorService;"}, k = 3, mv = {1, 8, 0})
    public static final class b extends Lambda implements Function0<ExecutorService> {
        public static final b b = new b();

        public b() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final ExecutorService invoke() {
            return p1.a(4, 0L, null, 6, null);
        }
    }

    @Override // com.chartboost.sdk.impl.q4
    public ExecutorService b() {
        return (ExecutorService) this.networkExecutor.getValue();
    }

    @Metadata(d1 = {"\u0000\b\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"Ljava/util/concurrent/ScheduledExecutorService;", "a", "()Ljava/util/concurrent/ScheduledExecutorService;"}, k = 3, mv = {1, 8, 0})
    public static final class a extends Lambda implements Function0<ScheduledExecutorService> {
        public static final a b = new a();

        public a() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final ScheduledExecutorService invoke() {
            return p1.a(0, null, 3, null);
        }
    }

    @Override // com.chartboost.sdk.impl.q4
    public ScheduledExecutorService a() {
        return (ScheduledExecutorService) this.backgroundExecutor.getValue();
    }
}
