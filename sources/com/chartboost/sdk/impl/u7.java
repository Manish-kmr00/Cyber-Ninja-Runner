package com.chartboost.sdk.impl;

import com.amazon.aps.shared.metrics.model.ApsMetricsDataMap;
import com.mbridge.msdk.foundation.download.core.DownloadCommon;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes13.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0000\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0010\u001a\u00020\u000f\u0012\u0006\u0010\u0012\u001a\u00020\u0011¢\u0006\u0004\b\u0013\u0010\u0014R\u001b\u0010\u0006\u001a\u00020\u00028VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0003\u0010\u0005R\u001b\u0010\u000b\u001a\u00020\u00078VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\b\u0010\u0004\u001a\u0004\b\t\u0010\nR\u001b\u0010\u000e\u001a\u00020\f8VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\t\u0010\u0004\u001a\u0004\b\b\u0010\r¨\u0006\u0015"}, d2 = {"Lcom/chartboost/sdk/impl/u7;", "Lcom/chartboost/sdk/impl/q7;", "Lcom/chartboost/sdk/impl/t7;", "a", "Lkotlin/Lazy;", "()Lcom/chartboost/sdk/impl/t7;", "openMeasurementManager", "Lcom/chartboost/sdk/impl/v7;", DownloadCommon.DOWNLOAD_REPORT_FIND_FILE_RESULT_VALUE_B, ApsMetricsDataMap.APSMETRICS_FIELD_CUSTOM, "()Lcom/chartboost/sdk/impl/v7;", "openMeasurementSessionBuilder", "Lcom/chartboost/sdk/impl/r7;", "()Lcom/chartboost/sdk/impl/r7;", "openMeasurementController", "Lcom/chartboost/sdk/impl/w0;", "androidComponent", "Lcom/chartboost/sdk/impl/z0;", "applicationComponent", "<init>", "(Lcom/chartboost/sdk/impl/w0;Lcom/chartboost/sdk/impl/z0;)V", "ChartboostMonetization-9.8.3_productionRelease"}, k = 1, mv = {1, 8, 0})
public final class u7 implements q7 {

    /* JADX INFO: renamed from: a, reason: collision with root package name and from kotlin metadata */
    public final Lazy openMeasurementManager;

    /* JADX INFO: renamed from: b, reason: from kotlin metadata */
    public final Lazy openMeasurementSessionBuilder;

    /* JADX INFO: renamed from: c, reason: from kotlin metadata */
    public final Lazy openMeasurementController;

    @Metadata(d1 = {"\u0000\b\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"Lcom/chartboost/sdk/impl/r7;", "a", "()Lcom/chartboost/sdk/impl/r7;"}, k = 3, mv = {1, 8, 0})
    public static final class a extends Lambda implements Function0<r7> {
        public a() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final r7 invoke() {
            return new r7(u7.this.a(), u7.this.c());
        }
    }

    @Metadata(d1 = {"\u0000\b\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"Lcom/chartboost/sdk/impl/t7;", "a", "()Lcom/chartboost/sdk/impl/t7;"}, k = 3, mv = {1, 8, 0})
    public static final class b extends Lambda implements Function0<t7> {
        public final /* synthetic */ w0 b;
        public final /* synthetic */ z0 c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(w0 w0Var, z0 z0Var) {
            super(0);
            this.b = w0Var;
            this.c = z0Var;
        }

        @Override // kotlin.jvm.functions.Function0
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final t7 invoke() {
            return new t7(this.b.getContext(), this.b.g(), this.b.i(), this.c.b(), null, 16, null);
        }
    }

    @Metadata(d1 = {"\u0000\b\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"Lcom/chartboost/sdk/impl/v7;", "a", "()Lcom/chartboost/sdk/impl/v7;"}, k = 3, mv = {1, 8, 0})
    public static final class c extends Lambda implements Function0<v7> {
        public static final c b = new c();

        public c() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final v7 invoke() {
            return new v7();
        }
    }

    public u7(w0 androidComponent, z0 applicationComponent) {
        Intrinsics.checkNotNullParameter(androidComponent, "androidComponent");
        Intrinsics.checkNotNullParameter(applicationComponent, "applicationComponent");
        this.openMeasurementManager = LazyKt.lazy(new b(androidComponent, applicationComponent));
        this.openMeasurementSessionBuilder = LazyKt.lazy(c.b);
        this.openMeasurementController = LazyKt.lazy(new a());
    }

    @Override // com.chartboost.sdk.impl.q7
    public t7 a() {
        return (t7) this.openMeasurementManager.getValue();
    }

    public v7 c() {
        return (v7) this.openMeasurementSessionBuilder.getValue();
    }

    @Override // com.chartboost.sdk.impl.q7
    public r7 b() {
        return (r7) this.openMeasurementController.getValue();
    }
}
