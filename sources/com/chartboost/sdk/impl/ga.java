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

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0000\u0018\u00002\u00020\u0001B1\u0012\f\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u001c0\u001b\u0012\f\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u001e0\u001b\u0012\f\u0010!\u001a\b\u0012\u0004\u0012\u00020 0\u001b¢\u0006\u0004\b\"\u0010#R\u001b\u0010\u0006\u001a\u00020\u00028VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0003\u0010\u0005R\u001b\u0010\u000b\u001a\u00020\u00078VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\b\u0010\u0004\u001a\u0004\b\t\u0010\nR\u001b\u0010\u000f\u001a\u00020\f8VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\t\u0010\u0004\u001a\u0004\b\r\u0010\u000eR\u001b\u0010\u0013\u001a\u00020\u00108VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\u0011\u0010\u0004\u001a\u0004\b\u0011\u0010\u0012R\u001b\u0010\u0016\u001a\u00020\u00148VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\r\u0010\u0004\u001a\u0004\b\b\u0010\u0015R\u001b\u0010\u001a\u001a\u00020\u00178VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\u0018\u0010\u0004\u001a\u0004\b\u0018\u0010\u0019¨\u0006$"}, d2 = {"Lcom/chartboost/sdk/impl/ga;", "Lcom/chartboost/sdk/impl/ea;", "Lcom/chartboost/sdk/impl/m4;", "a", "Lkotlin/Lazy;", "()Lcom/chartboost/sdk/impl/m4;", "eventTracker", "Lcom/chartboost/sdk/impl/k4;", DownloadCommon.DOWNLOAD_REPORT_FIND_FILE_RESULT_VALUE_B, ApsMetricsDataMap.APSMETRICS_FIELD_CUSTOM, "()Lcom/chartboost/sdk/impl/k4;", "eventThrottler", "Lcom/chartboost/sdk/impl/la;", "e", "()Lcom/chartboost/sdk/impl/la;", "trackingEventCache", "Lcom/chartboost/sdk/impl/ha;", "d", "()Lcom/chartboost/sdk/impl/ha;", "trackingBodyBuilder", "Lcom/chartboost/sdk/impl/h4;", "()Lcom/chartboost/sdk/impl/h4;", "environment", "Lcom/chartboost/sdk/impl/oa;", InneractiveMediationDefs.GENDER_FEMALE, "()Lcom/chartboost/sdk/impl/oa;", "trackingRequest", "Lkotlin/Lazy;", "Lcom/chartboost/sdk/impl/w0;", "androidComponent", "Lcom/chartboost/sdk/impl/z0;", "applicationComponent", "Lcom/chartboost/sdk/impl/l8;", "privacyApi", "<init>", "(Lkotlin/Lazy;Lkotlin/Lazy;Lkotlin/Lazy;)V", "ChartboostMonetization-9.8.3_productionRelease"}, k = 1, mv = {1, 8, 0})
public final class ga implements ea {

    /* JADX INFO: renamed from: a, reason: collision with root package name and from kotlin metadata */
    public final Lazy eventTracker;

    /* JADX INFO: renamed from: b, reason: from kotlin metadata */
    public final Lazy eventThrottler;

    /* JADX INFO: renamed from: c, reason: from kotlin metadata */
    public final Lazy trackingEventCache;

    /* JADX INFO: renamed from: d, reason: from kotlin metadata */
    public final Lazy trackingBodyBuilder;

    /* JADX INFO: renamed from: e, reason: from kotlin metadata */
    public final Lazy environment;

    /* JADX INFO: renamed from: f, reason: from kotlin metadata */
    public final Lazy trackingRequest;

    @Metadata(d1 = {"\u0000\b\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"Lcom/chartboost/sdk/impl/h4;", "a", "()Lcom/chartboost/sdk/impl/h4;"}, k = 3, mv = {1, 8, 0})
    public static final class a extends Lambda implements Function0<h4> {
        public final /* synthetic */ Lazy<w0> b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        public a(Lazy<? extends w0> lazy) {
            super(0);
            this.b = lazy;
        }

        @Override // kotlin.jvm.functions.Function0
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final h4 invoke() {
            return new h4(this.b.getValue().getApp(), this.b.getValue().h());
        }
    }

    @Metadata(d1 = {"\u0000\b\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"Lcom/chartboost/sdk/impl/ha;", "a", "()Lcom/chartboost/sdk/impl/ha;"}, k = 3, mv = {1, 8, 0})
    public static final class d extends Lambda implements Function0<ha> {
        public static final d b = new d();

        public d() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final ha invoke() {
            return new ha(null, 1, null);
        }
    }

    @Metadata(d1 = {"\u0000\b\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"Lcom/chartboost/sdk/impl/la;", "a", "()Lcom/chartboost/sdk/impl/la;"}, k = 3, mv = {1, 8, 0})
    public static final class e extends Lambda implements Function0<la> {
        public final /* synthetic */ Lazy<w0> b;
        public final /* synthetic */ ga c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        public e(Lazy<? extends w0> lazy, ga gaVar) {
            super(0);
            this.b = lazy;
            this.c = gaVar;
        }

        @Override // kotlin.jvm.functions.Function0
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final la invoke() {
            return new la(this.b.getValue().d(), this.c.d(), null, 4, null);
        }
    }

    @Metadata(d1 = {"\u0000\b\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"Lcom/chartboost/sdk/impl/oa;", "a", "()Lcom/chartboost/sdk/impl/oa;"}, k = 3, mv = {1, 8, 0})
    public static final class f extends Lambda implements Function0<oa> {
        public final /* synthetic */ Lazy<z0> b;
        public final /* synthetic */ ga c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        public f(Lazy<? extends z0> lazy, ga gaVar) {
            super(0);
            this.b = lazy;
            this.c = gaVar;
        }

        @Override // kotlin.jvm.functions.Function0
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final oa invoke() {
            return new oa(this.b.getValue().i(), this.c.e(), null, this.c.a(), 4, null);
        }
    }

    public ga(Lazy<? extends w0> androidComponent, Lazy<? extends z0> applicationComponent, Lazy<? extends l8> privacyApi) {
        Intrinsics.checkNotNullParameter(androidComponent, "androidComponent");
        Intrinsics.checkNotNullParameter(applicationComponent, "applicationComponent");
        Intrinsics.checkNotNullParameter(privacyApi, "privacyApi");
        this.eventTracker = LazyKt.lazy(new c(privacyApi, this, applicationComponent));
        this.eventThrottler = LazyKt.lazy(new b(applicationComponent));
        this.trackingEventCache = LazyKt.lazy(new e(androidComponent, this));
        this.trackingBodyBuilder = LazyKt.lazy(d.b);
        this.environment = LazyKt.lazy(new a(androidComponent));
        this.trackingRequest = LazyKt.lazy(new f(applicationComponent, this));
    }

    @Metadata(d1 = {"\u0000\b\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"Lcom/chartboost/sdk/impl/n4;", "a", "()Lcom/chartboost/sdk/impl/n4;"}, k = 3, mv = {1, 8, 0})
    public static final class c extends Lambda implements Function0<n4> {
        public final /* synthetic */ Lazy<l8> b;
        public final /* synthetic */ ga c;
        public final /* synthetic */ Lazy<z0> d;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        public c(Lazy<? extends l8> lazy, ga gaVar, Lazy<? extends z0> lazy2) {
            super(0);
            this.b = lazy;
            this.c = gaVar;
            this.d = lazy2;
        }

        @Override // kotlin.jvm.functions.Function0
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final n4 invoke() {
            Lazy lazy = LazyKt.lazy(new a(this.c));
            Lazy lazy2 = LazyKt.lazy(new b(this.d));
            return new n4(LazyKt.lazy(new C0262c(this.d)), lazy, lazy2, this.b, LazyKt.lazy(new d(this.c)), LazyKt.lazy(new e(this.c)), LazyKt.lazy(new f(this.c)));
        }

        @Metadata(d1 = {"\u0000\b\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"Lcom/chartboost/sdk/impl/k4;", "a", "()Lcom/chartboost/sdk/impl/k4;"}, k = 3, mv = {1, 8, 0})
        public static final class a extends Lambda implements Function0<k4> {
            public final /* synthetic */ ga b;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public a(ga gaVar) {
                super(0);
                this.b = gaVar;
            }

            @Override // kotlin.jvm.functions.Function0
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public final k4 invoke() {
                return this.b.c();
            }
        }

        @Metadata(d1 = {"\u0000\b\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"Lcom/chartboost/sdk/impl/d9;", "a", "()Lcom/chartboost/sdk/impl/d9;"}, k = 3, mv = {1, 8, 0})
        public static final class b extends Lambda implements Function0<d9> {
            public final /* synthetic */ Lazy<z0> b;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            public b(Lazy<? extends z0> lazy) {
                super(0);
                this.b = lazy;
            }

            @Override // kotlin.jvm.functions.Function0
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public final d9 invoke() {
                return this.b.getValue().o();
            }
        }

        /* JADX INFO: renamed from: com.chartboost.sdk.impl.ga$c$c, reason: collision with other inner class name */
        @Metadata(d1 = {"\u0000\b\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lcom/chartboost/sdk/impl/ia;", "kotlin.jvm.PlatformType", "a", "()Lcom/chartboost/sdk/impl/ia;"}, k = 3, mv = {1, 8, 0})
        public static final class C0262c extends Lambda implements Function0<ia> {
            public final /* synthetic */ Lazy<z0> b;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            public C0262c(Lazy<? extends z0> lazy) {
                super(0);
                this.b = lazy;
            }

            @Override // kotlin.jvm.functions.Function0
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public final ia invoke() {
                return this.b.getValue().b().get().g();
            }
        }

        @Metadata(d1 = {"\u0000\b\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"Lcom/chartboost/sdk/impl/h4;", "a", "()Lcom/chartboost/sdk/impl/h4;"}, k = 3, mv = {1, 8, 0})
        public static final class d extends Lambda implements Function0<h4> {
            public final /* synthetic */ ga b;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public d(ga gaVar) {
                super(0);
                this.b = gaVar;
            }

            @Override // kotlin.jvm.functions.Function0
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public final h4 invoke() {
                return this.b.b();
            }
        }

        @Metadata(d1 = {"\u0000\b\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"Lcom/chartboost/sdk/impl/oa;", "a", "()Lcom/chartboost/sdk/impl/oa;"}, k = 3, mv = {1, 8, 0})
        public static final class e extends Lambda implements Function0<oa> {
            public final /* synthetic */ ga b;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public e(ga gaVar) {
                super(0);
                this.b = gaVar;
            }

            @Override // kotlin.jvm.functions.Function0
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public final oa invoke() {
                return this.b.f();
            }
        }

        @Metadata(d1 = {"\u0000\b\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"Lcom/chartboost/sdk/impl/la;", "a", "()Lcom/chartboost/sdk/impl/la;"}, k = 3, mv = {1, 8, 0})
        public static final class f extends Lambda implements Function0<la> {
            public final /* synthetic */ ga b;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public f(ga gaVar) {
                super(0);
                this.b = gaVar;
            }

            @Override // kotlin.jvm.functions.Function0
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public final la invoke() {
                return this.b.e();
            }
        }
    }

    @Override // com.chartboost.sdk.impl.ea
    public m4 a() {
        return (m4) this.eventTracker.getValue();
    }

    @Metadata(d1 = {"\u0000\b\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"Lcom/chartboost/sdk/impl/k4;", "a", "()Lcom/chartboost/sdk/impl/k4;"}, k = 3, mv = {1, 8, 0})
    public static final class b extends Lambda implements Function0<k4> {
        public final /* synthetic */ Lazy<z0> b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        public b(Lazy<? extends z0> lazy) {
            super(0);
            this.b = lazy;
        }

        @Override // kotlin.jvm.functions.Function0
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final k4 invoke() {
            ia iaVarG = this.b.getValue().b().get().g();
            return new k4(iaVarG.getEventLimit(), iaVarG.getWindowDuration());
        }
    }

    public k4 c() {
        return (k4) this.eventThrottler.getValue();
    }

    public la e() {
        return (la) this.trackingEventCache.getValue();
    }

    public ha d() {
        return (ha) this.trackingBodyBuilder.getValue();
    }

    public h4 b() {
        return (h4) this.environment.getValue();
    }

    public oa f() {
        return (oa) this.trackingRequest.getValue();
    }
}
