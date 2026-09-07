package com.chartboost.sdk.impl;

import com.amazon.aps.shared.metrics.model.ApsMetricsDataMap;
import com.chartboost.sdk.Mediation;
import com.mbridge.msdk.foundation.download.core.DownloadCommon;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.atomic.AtomicReference;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function9;
import kotlin.jvm.internal.AdaptedFunctionReference;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u0019\u0010\u0003\u001a\u00020\u00022\b\u0010\u0001\u001a\u0004\u0018\u00010\u0000H\u0000¢\u0006\u0004\b\u0003\u0010\u0004\u001a\u0019\u0010\u0006\u001a\u00020\u00052\b\u0010\u0001\u001a\u0004\u0018\u00010\u0000H\u0000¢\u0006\u0004\b\u0006\u0010\u0007\u001a\u0019\u0010\t\u001a\u00020\b2\b\u0010\u0001\u001a\u0004\u0018\u00010\u0000H\u0000¢\u0006\u0004\b\t\u0010\n*¢\u0001\b\u0002\u0010\u0018\u001a\u0004\b\u0000\u0010\u000b\"J\u0012F\u0012D\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u0010\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00120\u0011\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\u0015\u0012\u0004\u0012\u00020\u0016\u0012\u0004\u0012\u00020\u0017\u0012\u0004\u0012\u00028\u00000\r0\f2J\u0012F\u0012D\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u0010\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00120\u0011\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\u0015\u0012\u0004\u0012\u00020\u0016\u0012\u0004\u0012\u00020\u0017\u0012\u0004\u0012\u00028\u00000\r0\f¨\u0006\u0019"}, d2 = {"Lcom/chartboost/sdk/Mediation;", "mediation", "Lcom/chartboost/sdk/impl/y6;", DownloadCommon.DOWNLOAD_REPORT_FIND_FILE_RESULT_VALUE_B, "(Lcom/chartboost/sdk/Mediation;)Lcom/chartboost/sdk/impl/y6;", "Lcom/chartboost/sdk/impl/h9;", ApsMetricsDataMap.APSMETRICS_FIELD_CUSTOM, "(Lcom/chartboost/sdk/Mediation;)Lcom/chartboost/sdk/impl/h9;", "Lcom/chartboost/sdk/impl/m1;", "a", "(Lcom/chartboost/sdk/Mediation;)Lcom/chartboost/sdk/impl/m1;", "T", "Lkotlin/Function0;", "Lkotlin/Function9;", "Lcom/chartboost/sdk/impl/y;", "Lcom/chartboost/sdk/impl/g0;", "Lcom/chartboost/sdk/impl/sa;", "Ljava/util/concurrent/atomic/AtomicReference;", "Lcom/chartboost/sdk/impl/o9;", "Ljava/util/concurrent/ScheduledExecutorService;", "Lcom/chartboost/sdk/impl/d;", "Lcom/chartboost/sdk/impl/s9;", "Lcom/chartboost/sdk/impl/n1;", "Lcom/chartboost/sdk/impl/m4;", "ApiFactoryGet", "ChartboostMonetization-9.8.3_productionRelease"}, k = 2, mv = {1, 8, 0})
public final class i {

    @Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\f\u001aD\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0003\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u0004\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u000b0\u0000H\n¢\u0006\u0004\b\f\u0010\r"}, d2 = {"Lkotlin/Function9;", "Lcom/chartboost/sdk/impl/y;", "Lcom/chartboost/sdk/impl/g0;", "Lcom/chartboost/sdk/impl/sa;", "Ljava/util/concurrent/atomic/AtomicReference;", "Lcom/chartboost/sdk/impl/o9;", "Ljava/util/concurrent/ScheduledExecutorService;", "Lcom/chartboost/sdk/impl/d;", "Lcom/chartboost/sdk/impl/s9;", "Lcom/chartboost/sdk/impl/n1;", "Lcom/chartboost/sdk/impl/m4;", "Lcom/chartboost/sdk/impl/m1;", "a", "()Lkotlin/jvm/functions/Function9;"}, k = 3, mv = {1, 8, 0})
    public static final class a extends Lambda implements Function0<Function9<? super y, ? super g0, ? super sa, ? super AtomicReference<o9>, ? super ScheduledExecutorService, ? super d, ? super s9, ? super n1, ? super m4, ? extends m1>> {
        public static final a b = new a();

        /* JADX INFO: renamed from: com.chartboost.sdk.impl.i$a$a, reason: collision with other inner class name */
        @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
        public /* synthetic */ class C0263a extends AdaptedFunctionReference implements Function9<y, g0, sa, AtomicReference<o9>, ScheduledExecutorService, d, s9, n1, m4, m1> {
            public static final C0263a b = new C0263a();

            public C0263a() {
                super(9, m1.class, "<init>", "<init>(Lcom/chartboost/sdk/internal/AdUnitManager/loaders/AdUnitLoader;Lcom/chartboost/sdk/internal/AdUnitManager/render/AdUnitRenderer;Lcom/chartboost/sdk/internal/UiPoster;Ljava/util/concurrent/atomic/AtomicReference;Ljava/util/concurrent/ScheduledExecutorService;Lcom/chartboost/sdk/internal/api/AdApiCallbackSender;Lcom/chartboost/sdk/tracking/Session;Lcom/chartboost/sdk/internal/utils/Base64Wrapper;Lcom/chartboost/sdk/tracking/EventTrackerExtensions;Lkotlin/jvm/functions/Function0;)V", 0);
            }

            @Override // kotlin.jvm.functions.Function9
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public final m1 invoke(y p0, g0 p1, sa p2, AtomicReference<o9> p3, ScheduledExecutorService p4, d p5, s9 p6, n1 p7, m4 p8) {
                Intrinsics.checkNotNullParameter(p0, "p0");
                Intrinsics.checkNotNullParameter(p1, "p1");
                Intrinsics.checkNotNullParameter(p2, "p2");
                Intrinsics.checkNotNullParameter(p3, "p3");
                Intrinsics.checkNotNullParameter(p4, "p4");
                Intrinsics.checkNotNullParameter(p5, "p5");
                Intrinsics.checkNotNullParameter(p6, "p6");
                Intrinsics.checkNotNullParameter(p7, "p7");
                Intrinsics.checkNotNullParameter(p8, "p8");
                return new m1(p0, p1, p2, p3, p4, p5, p6, p7, p8, null, 512, null);
            }
        }

        public a() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Function9<y, g0, sa, AtomicReference<o9>, ScheduledExecutorService, d, s9, n1, m4, m1> invoke() {
            return C0263a.b;
        }
    }

    @Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\f\u001aD\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0003\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u0004\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u000b0\u0000H\n¢\u0006\u0004\b\f\u0010\r"}, d2 = {"Lkotlin/Function9;", "Lcom/chartboost/sdk/impl/y;", "Lcom/chartboost/sdk/impl/g0;", "Lcom/chartboost/sdk/impl/sa;", "Ljava/util/concurrent/atomic/AtomicReference;", "Lcom/chartboost/sdk/impl/o9;", "Ljava/util/concurrent/ScheduledExecutorService;", "Lcom/chartboost/sdk/impl/d;", "Lcom/chartboost/sdk/impl/s9;", "Lcom/chartboost/sdk/impl/n1;", "Lcom/chartboost/sdk/impl/m4;", "Lcom/chartboost/sdk/impl/y6;", "a", "()Lkotlin/jvm/functions/Function9;"}, k = 3, mv = {1, 8, 0})
    public static final class b extends Lambda implements Function0<Function9<? super y, ? super g0, ? super sa, ? super AtomicReference<o9>, ? super ScheduledExecutorService, ? super d, ? super s9, ? super n1, ? super m4, ? extends y6>> {
        public static final b b = new b();

        @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
        public /* synthetic */ class a extends AdaptedFunctionReference implements Function9<y, g0, sa, AtomicReference<o9>, ScheduledExecutorService, d, s9, n1, m4, y6> {
            public static final a b = new a();

            public a() {
                super(9, y6.class, "<init>", "<init>(Lcom/chartboost/sdk/internal/AdUnitManager/loaders/AdUnitLoader;Lcom/chartboost/sdk/internal/AdUnitManager/render/AdUnitRenderer;Lcom/chartboost/sdk/internal/UiPoster;Ljava/util/concurrent/atomic/AtomicReference;Ljava/util/concurrent/ScheduledExecutorService;Lcom/chartboost/sdk/internal/api/AdApiCallbackSender;Lcom/chartboost/sdk/tracking/Session;Lcom/chartboost/sdk/internal/utils/Base64Wrapper;Lcom/chartboost/sdk/tracking/EventTrackerExtensions;Lkotlin/jvm/functions/Function0;)V", 0);
            }

            @Override // kotlin.jvm.functions.Function9
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public final y6 invoke(y p0, g0 p1, sa p2, AtomicReference<o9> p3, ScheduledExecutorService p4, d p5, s9 p6, n1 p7, m4 p8) {
                Intrinsics.checkNotNullParameter(p0, "p0");
                Intrinsics.checkNotNullParameter(p1, "p1");
                Intrinsics.checkNotNullParameter(p2, "p2");
                Intrinsics.checkNotNullParameter(p3, "p3");
                Intrinsics.checkNotNullParameter(p4, "p4");
                Intrinsics.checkNotNullParameter(p5, "p5");
                Intrinsics.checkNotNullParameter(p6, "p6");
                Intrinsics.checkNotNullParameter(p7, "p7");
                Intrinsics.checkNotNullParameter(p8, "p8");
                return new y6(p0, p1, p2, p3, p4, p5, p6, p7, p8, null, 512, null);
            }
        }

        public b() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Function9<y, g0, sa, AtomicReference<o9>, ScheduledExecutorService, d, s9, n1, m4, y6> invoke() {
            return a.b;
        }
    }

    @Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\f\u001aD\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0003\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u0004\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u000b0\u0000H\n¢\u0006\u0004\b\f\u0010\r"}, d2 = {"Lkotlin/Function9;", "Lcom/chartboost/sdk/impl/y;", "Lcom/chartboost/sdk/impl/g0;", "Lcom/chartboost/sdk/impl/sa;", "Ljava/util/concurrent/atomic/AtomicReference;", "Lcom/chartboost/sdk/impl/o9;", "Ljava/util/concurrent/ScheduledExecutorService;", "Lcom/chartboost/sdk/impl/d;", "Lcom/chartboost/sdk/impl/s9;", "Lcom/chartboost/sdk/impl/n1;", "Lcom/chartboost/sdk/impl/m4;", "Lcom/chartboost/sdk/impl/h9;", "a", "()Lkotlin/jvm/functions/Function9;"}, k = 3, mv = {1, 8, 0})
    public static final class c extends Lambda implements Function0<Function9<? super y, ? super g0, ? super sa, ? super AtomicReference<o9>, ? super ScheduledExecutorService, ? super d, ? super s9, ? super n1, ? super m4, ? extends h9>> {
        public static final c b = new c();

        @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
        public /* synthetic */ class a extends AdaptedFunctionReference implements Function9<y, g0, sa, AtomicReference<o9>, ScheduledExecutorService, d, s9, n1, m4, h9> {
            public static final a b = new a();

            public a() {
                super(9, h9.class, "<init>", "<init>(Lcom/chartboost/sdk/internal/AdUnitManager/loaders/AdUnitLoader;Lcom/chartboost/sdk/internal/AdUnitManager/render/AdUnitRenderer;Lcom/chartboost/sdk/internal/UiPoster;Ljava/util/concurrent/atomic/AtomicReference;Ljava/util/concurrent/ScheduledExecutorService;Lcom/chartboost/sdk/internal/api/AdApiCallbackSender;Lcom/chartboost/sdk/tracking/Session;Lcom/chartboost/sdk/internal/utils/Base64Wrapper;Lcom/chartboost/sdk/tracking/EventTrackerExtensions;Lkotlin/jvm/functions/Function0;)V", 0);
            }

            @Override // kotlin.jvm.functions.Function9
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public final h9 invoke(y p0, g0 p1, sa p2, AtomicReference<o9> p3, ScheduledExecutorService p4, d p5, s9 p6, n1 p7, m4 p8) {
                Intrinsics.checkNotNullParameter(p0, "p0");
                Intrinsics.checkNotNullParameter(p1, "p1");
                Intrinsics.checkNotNullParameter(p2, "p2");
                Intrinsics.checkNotNullParameter(p3, "p3");
                Intrinsics.checkNotNullParameter(p4, "p4");
                Intrinsics.checkNotNullParameter(p5, "p5");
                Intrinsics.checkNotNullParameter(p6, "p6");
                Intrinsics.checkNotNullParameter(p7, "p7");
                Intrinsics.checkNotNullParameter(p8, "p8");
                return new h9(p0, p1, p2, p3, p4, p5, p6, p7, p8, null, 512, null);
            }
        }

        public c() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Function9<y, g0, sa, AtomicReference<o9>, ScheduledExecutorService, d, s9, n1, m4, h9> invoke() {
            return a.b;
        }
    }

    public static final m1 a(Mediation mediation) {
        return (m1) new h(u.a.g, a.b, mediation, null, 8, null).a();
    }

    public static final y6 b(Mediation mediation) {
        return (y6) new h(u.b.g, b.b, mediation, null, 8, null).a();
    }

    public static final h9 c(Mediation mediation) {
        return (h9) new h(u.c.g, c.b, mediation, null, 8, null).a();
    }
}
