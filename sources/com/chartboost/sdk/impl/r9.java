package com.chartboost.sdk.impl;

import com.amazon.aps.shared.metrics.model.ApsMetricsDataMap;
import com.fyber.inneractive.sdk.external.InneractiveMediationDefs;
import com.mbridge.msdk.foundation.download.core.DownloadCommon;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0000\u0018\u00002\u00020\u0001B/\u0012\u0006\u0010 \u001a\u00020\u001f\u0012\u0006\u0010\"\u001a\u00020!\u0012\u0006\u0010$\u001a\u00020#\u0012\u0006\u0010&\u001a\u00020%\u0012\u0006\u0010(\u001a\u00020'¢\u0006\u0004\b)\u0010*R\u001b\u0010\u0007\u001a\u00020\u00028VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001b\u0010\n\u001a\u00020\b8VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\u0005\u0010\u0004\u001a\u0004\b\u0003\u0010\tR\u001b\u0010\u000e\u001a\u00020\u000b8VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\f\u0010\u0004\u001a\u0004\b\f\u0010\rR\u001b\u0010\u0013\u001a\u00020\u000f8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0010\u0010\u0004\u001a\u0004\b\u0011\u0010\u0012R\u001b\u0010\u0016\u001a\u00020\u00148BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0011\u0010\u0004\u001a\u0004\b\u0010\u0010\u0015R\u001b\u0010\u001a\u001a\u00020\u00178BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0018\u0010\u0004\u001a\u0004\b\u0018\u0010\u0019R\u001b\u0010\u001e\u001a\u00020\u001b8VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\u001c\u0010\u0004\u001a\u0004\b\u001c\u0010\u001d¨\u0006+"}, d2 = {"Lcom/chartboost/sdk/impl/r9;", "Lcom/chartboost/sdk/impl/n9;", "Lcom/chartboost/sdk/impl/u2;", "a", "Lkotlin/Lazy;", DownloadCommon.DOWNLOAD_REPORT_FIND_FILE_RESULT_VALUE_B, "()Lcom/chartboost/sdk/impl/u2;", "chartboostApi", "Lcom/chartboost/sdk/impl/u0;", "()Lcom/chartboost/sdk/impl/u0;", "analyticsApi", "Lcom/chartboost/sdk/impl/p9;", ApsMetricsDataMap.APSMETRICS_FIELD_CUSTOM, "()Lcom/chartboost/sdk/impl/p9;", "sdkInitializer", "Lcom/chartboost/sdk/impl/u6;", "d", "e", "()Lcom/chartboost/sdk/impl/u6;", "initInstallRequest", "Lcom/chartboost/sdk/impl/t6;", "()Lcom/chartboost/sdk/impl/t6;", "initConfigRequest", "Lcom/chartboost/sdk/impl/q8;", InneractiveMediationDefs.GENDER_FEMALE, "()Lcom/chartboost/sdk/impl/q8;", "providerInstallerHelper", "Lcom/chartboost/sdk/impl/o1;", "g", "()Lcom/chartboost/sdk/impl/o1;", "tokenGenerator", "Lcom/chartboost/sdk/impl/w0;", "androidComponent", "Lcom/chartboost/sdk/impl/q4;", "executorComponent", "Lcom/chartboost/sdk/impl/z0;", "applicationComponent", "Lcom/chartboost/sdk/impl/q7;", "openMeasurementComponent", "Lcom/chartboost/sdk/impl/ea;", "trackerComponent", "<init>", "(Lcom/chartboost/sdk/impl/w0;Lcom/chartboost/sdk/impl/q4;Lcom/chartboost/sdk/impl/z0;Lcom/chartboost/sdk/impl/q7;Lcom/chartboost/sdk/impl/ea;)V", "ChartboostMonetization-9.8.3_productionRelease"}, k = 1, mv = {1, 8, 0})
public final class r9 implements n9 {

    /* JADX INFO: renamed from: a, reason: collision with root package name and from kotlin metadata */
    public final Lazy chartboostApi;

    /* JADX INFO: renamed from: b, reason: from kotlin metadata */
    public final Lazy analyticsApi;

    /* JADX INFO: renamed from: c, reason: from kotlin metadata */
    public final Lazy sdkInitializer;

    /* JADX INFO: renamed from: d, reason: from kotlin metadata */
    public final Lazy initInstallRequest;

    /* JADX INFO: renamed from: e, reason: from kotlin metadata */
    public final Lazy initConfigRequest;

    /* JADX INFO: renamed from: f, reason: from kotlin metadata */
    public final Lazy providerInstallerHelper;

    /* JADX INFO: renamed from: g, reason: from kotlin metadata */
    public final Lazy tokenGenerator;

    @Metadata(d1 = {"\u0000\b\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"Lcom/chartboost/sdk/impl/u0;", "a", "()Lcom/chartboost/sdk/impl/u0;"}, k = 3, mv = {1, 8, 0})
    public static final class a extends Lambda implements Function0<u0> {
        public final /* synthetic */ z0 c;
        public final /* synthetic */ ea d;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(z0 z0Var, ea eaVar) {
            super(0);
            this.c = z0Var;
            this.d = eaVar;
        }

        @Override // kotlin.jvm.functions.Function0
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final u0 invoke() {
            return new u0(r9.this.c(), this.c.i(), this.c.o(), this.d.a());
        }
    }

    @Metadata(d1 = {"\u0000\b\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"Lcom/chartboost/sdk/impl/u2;", "a", "()Lcom/chartboost/sdk/impl/u2;"}, k = 3, mv = {1, 8, 0})
    public static final class b extends Lambda implements Function0<u2> {
        public final /* synthetic */ w0 b;
        public final /* synthetic */ q4 c;
        public final /* synthetic */ r9 d;
        public final /* synthetic */ z0 e;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(w0 w0Var, q4 q4Var, r9 r9Var, z0 z0Var) {
            super(0);
            this.b = w0Var;
            this.c = q4Var;
            this.d = r9Var;
            this.e = z0Var;
        }

        @Override // kotlin.jvm.functions.Function0
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final u2 invoke() {
            return new u2(this.b.getContext(), this.c.a(), this.d.c(), this.d.g(), this.e.j());
        }
    }

    @Metadata(d1 = {"\u0000\b\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"Lcom/chartboost/sdk/impl/t6;", "a", "()Lcom/chartboost/sdk/impl/t6;"}, k = 3, mv = {1, 8, 0})
    public static final class c extends Lambda implements Function0<t6> {
        public final /* synthetic */ z0 b;
        public final /* synthetic */ ea c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(z0 z0Var, ea eaVar) {
            super(0);
            this.b = z0Var;
            this.c = eaVar;
        }

        @Override // kotlin.jvm.functions.Function0
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final t6 invoke() {
            return new t6(this.b.i(), this.b.o(), this.c.a(), this.b.d());
        }
    }

    @Metadata(d1 = {"\u0000\b\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"Lcom/chartboost/sdk/impl/u6;", "a", "()Lcom/chartboost/sdk/impl/u6;"}, k = 3, mv = {1, 8, 0})
    public static final class d extends Lambda implements Function0<u6> {
        public final /* synthetic */ z0 b;
        public final /* synthetic */ ea c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public d(z0 z0Var, ea eaVar) {
            super(0);
            this.b = z0Var;
            this.c = eaVar;
        }

        @Override // kotlin.jvm.functions.Function0
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final u6 invoke() {
            return new u6(this.b.i(), this.b.o(), this.c.a(), this.b.d());
        }
    }

    @Metadata(d1 = {"\u0000\b\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"Lcom/chartboost/sdk/impl/q8;", "a", "()Lcom/chartboost/sdk/impl/q8;"}, k = 3, mv = {1, 8, 0})
    public static final class e extends Lambda implements Function0<q8> {
        public final /* synthetic */ w0 b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public e(w0 w0Var) {
            super(0);
            this.b = w0Var;
        }

        @Override // kotlin.jvm.functions.Function0
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final q8 invoke() {
            return new q8(this.b.getContext(), this.b.e());
        }
    }

    @Metadata(d1 = {"\u0000\b\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"Lcom/chartboost/sdk/impl/o1;", "a", "()Lcom/chartboost/sdk/impl/o1;"}, k = 3, mv = {1, 8, 0})
    public static final class g extends Lambda implements Function0<o1> {
        public final /* synthetic */ w0 b;
        public final /* synthetic */ z0 c;
        public final /* synthetic */ q7 d;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public g(w0 w0Var, z0 z0Var, q7 q7Var) {
            super(0);
            this.b = w0Var;
            this.c = z0Var;
            this.d = q7Var;
        }

        @Override // kotlin.jvm.functions.Function0
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final o1 invoke() {
            return new o1(this.b.getContext(), this.b.a(), this.c.j(), this.c.b(), this.d.a());
        }
    }

    public r9(w0 androidComponent, q4 executorComponent, z0 applicationComponent, q7 openMeasurementComponent, ea trackerComponent) {
        Intrinsics.checkNotNullParameter(androidComponent, "androidComponent");
        Intrinsics.checkNotNullParameter(executorComponent, "executorComponent");
        Intrinsics.checkNotNullParameter(applicationComponent, "applicationComponent");
        Intrinsics.checkNotNullParameter(openMeasurementComponent, "openMeasurementComponent");
        Intrinsics.checkNotNullParameter(trackerComponent, "trackerComponent");
        this.chartboostApi = LazyKt.lazy(new b(androidComponent, executorComponent, this, applicationComponent));
        this.analyticsApi = LazyKt.lazy(new a(applicationComponent, trackerComponent));
        this.sdkInitializer = LazyKt.lazy(new f(androidComponent, applicationComponent, this, openMeasurementComponent));
        this.initInstallRequest = LazyKt.lazy(new d(applicationComponent, trackerComponent));
        this.initConfigRequest = LazyKt.lazy(new c(applicationComponent, trackerComponent));
        this.providerInstallerHelper = LazyKt.lazy(new e(androidComponent));
        this.tokenGenerator = LazyKt.lazy(new g(androidComponent, applicationComponent, openMeasurementComponent));
    }

    @Override // com.chartboost.sdk.impl.n9
    public u2 b() {
        return (u2) this.chartboostApi.getValue();
    }

    @Metadata(d1 = {"\u0000\b\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"Lcom/chartboost/sdk/impl/p9;", "a", "()Lcom/chartboost/sdk/impl/p9;"}, k = 3, mv = {1, 8, 0})
    public static final class f extends Lambda implements Function0<p9> {
        public final /* synthetic */ w0 b;
        public final /* synthetic */ z0 c;
        public final /* synthetic */ r9 d;
        public final /* synthetic */ q7 e;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public f(w0 w0Var, z0 z0Var, r9 r9Var, q7 q7Var) {
            super(0);
            this.b = w0Var;
            this.c = z0Var;
            this.d = r9Var;
            this.e = q7Var;
        }

        @Override // kotlin.jvm.functions.Function0
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final p9 invoke() {
            return new p9(this.b.getContext(), this.b.f(), this.b.e(), this.c.a(), this.c.b(), this.c.h(), this.c.g(), this.c.s(), this.c.l(), LazyKt.lazy(new a(this.c)), this.d.e(), this.d.d(), this.c.r(), this.d.f(), this.c.j(), this.e.a());
        }

        @Metadata(d1 = {"\u0000\b\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"Lcom/chartboost/sdk/impl/qb;", "a", "()Lcom/chartboost/sdk/impl/qb;"}, k = 3, mv = {1, 8, 0})
        public static final class a extends Lambda implements Function0<qb> {
            public final /* synthetic */ z0 b;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public a(z0 z0Var) {
                super(0);
                this.b = z0Var;
            }

            @Override // kotlin.jvm.functions.Function0
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public final qb invoke() {
                return this.b.q();
            }
        }
    }

    @Override // com.chartboost.sdk.impl.n9
    public u0 a() {
        return (u0) this.analyticsApi.getValue();
    }

    @Override // com.chartboost.sdk.impl.n9
    public p9 c() {
        return (p9) this.sdkInitializer.getValue();
    }

    public final u6 e() {
        return (u6) this.initInstallRequest.getValue();
    }

    public final t6 d() {
        return (t6) this.initConfigRequest.getValue();
    }

    public final q8 f() {
        return (q8) this.providerInstallerHelper.getValue();
    }

    public o1 g() {
        return (o1) this.tokenGenerator.getValue();
    }
}
