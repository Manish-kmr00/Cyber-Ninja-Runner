package com.chartboost.sdk.impl;

import android.app.Application;
import android.content.Context;
import com.amazon.aps.shared.metrics.model.ApsMetricsDataMap;
import com.fyber.inneractive.sdk.external.InneractiveMediationDefs;
import com.google.firebase.remoteconfig.RemoteConfigConstants;
import com.mbridge.msdk.foundation.download.core.DownloadCommon;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000v\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\n\b\u0000\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\bA\u0010BJ\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J\u001f\u0010\u0005\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\u0005\u0010\nR\u0018\u0010\f\u001a\u0004\u0018\u00010\u00078\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0005\u0010\u000bR\u0018\u0010\u000e\u001a\u0004\u0018\u00010\u00078\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\r\u0010\u000bR\u0018\u0010\u0012\u001a\u0004\u0018\u00010\u000f8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0010\u0010\u0011R\u001b\u0010\u0017\u001a\u00020\u00138VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0005\u0010\u0016R\u001b\u0010\u001b\u001a\u00020\u00188VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\u0019\u0010\u0015\u001a\u0004\b\u0019\u0010\u001aR\u001b\u0010 \u001a\u00020\u001c8VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\u001d\u0010\u0015\u001a\u0004\b\u001e\u0010\u001fR\u001b\u0010$\u001a\u00020!8VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\"\u0010\u0015\u001a\u0004\b\u001d\u0010#R\u001b\u0010)\u001a\u00020%8VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b&\u0010\u0015\u001a\u0004\b'\u0010(R\u001b\u0010,\u001a\u00020*8VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b'\u0010\u0015\u001a\u0004\b\"\u0010+R\u001b\u00100\u001a\u00020-8VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\u001e\u0010\u0015\u001a\u0004\b.\u0010/R\u001b\u00105\u001a\u0002018VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b2\u0010\u0015\u001a\u0004\b3\u00104R\u001b\u00108\u001a\u0002068VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b3\u0010\u0015\u001a\u0004\b2\u00107R\u0014\u0010;\u001a\u0002098VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b&\u0010:R\u0014\u0010=\u001a\u0002098VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b<\u0010:R\u0014\u0010\b\u001a\u00020\u00078VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\r\u0010>R\u0014\u0010\t\u001a\u00020\u00078VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0010\u0010>R\u0014\u0010@\u001a\u00020\u000f8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0014\u0010?¨\u0006C"}, d2 = {"Lcom/chartboost/sdk/impl/u3;", "", "Landroid/content/Context;", "context", "", "a", "(Landroid/content/Context;)V", "", RemoteConfigConstants.RequestFieldKey.APP_ID, "appSignature", "(Ljava/lang/String;Ljava/lang/String;)V", "Ljava/lang/String;", "_appId", DownloadCommon.DOWNLOAD_REPORT_FIND_FILE_RESULT_VALUE_B, "_appSignature", "Landroid/app/Application;", ApsMetricsDataMap.APSMETRICS_FIELD_CUSTOM, "Landroid/app/Application;", "unsafeApplication", "Lcom/chartboost/sdk/impl/w0;", "d", "Lkotlin/Lazy;", "()Lcom/chartboost/sdk/impl/w0;", "androidComponent", "Lcom/chartboost/sdk/impl/z0;", "e", "()Lcom/chartboost/sdk/impl/z0;", "applicationComponent", "Lcom/chartboost/sdk/impl/n8;", InneractiveMediationDefs.GENDER_FEMALE, "j", "()Lcom/chartboost/sdk/impl/n8;", "privacyComponent", "Lcom/chartboost/sdk/impl/q4;", "g", "()Lcom/chartboost/sdk/impl/q4;", "executorComponent", "Lcom/chartboost/sdk/impl/q7;", "h", "i", "()Lcom/chartboost/sdk/impl/q7;", "openMeasurementComponent", "Lcom/chartboost/sdk/impl/b6;", "()Lcom/chartboost/sdk/impl/b6;", "impressionComponent", "Lcom/chartboost/sdk/impl/ea;", "n", "()Lcom/chartboost/sdk/impl/ea;", "trackerComponent", "Lcom/chartboost/sdk/impl/n9;", CampaignEx.JSON_KEY_AD_K, "l", "()Lcom/chartboost/sdk/impl/n9;", "sdkComponent", "Lcom/chartboost/sdk/impl/x8;", "()Lcom/chartboost/sdk/impl/x8;", "renderComponent", "", "()Z", "initialized", "m", com.ironsource.b9.h.d0, "()Ljava/lang/String;", "()Landroid/app/Application;", "application", "<init>", "()V", "ChartboostMonetization-9.8.3_productionRelease"}, k = 1, mv = {1, 8, 0})
public final class u3 {

    /* JADX INFO: renamed from: a, reason: collision with root package name and from kotlin metadata */
    public String _appId;

    /* JADX INFO: renamed from: b, reason: from kotlin metadata */
    public String _appSignature;

    /* JADX INFO: renamed from: c, reason: from kotlin metadata */
    public Application unsafeApplication;

    /* JADX INFO: renamed from: d, reason: from kotlin metadata */
    public final Lazy androidComponent = LazyKt.lazy(new a());

    /* JADX INFO: renamed from: e, reason: from kotlin metadata */
    public final Lazy applicationComponent = LazyKt.lazy(new b());

    /* JADX INFO: renamed from: f, reason: from kotlin metadata */
    public final Lazy privacyComponent = LazyKt.lazy(new f());

    /* JADX INFO: renamed from: g, reason: from kotlin metadata */
    public final Lazy executorComponent = LazyKt.lazy(c.b);

    /* JADX INFO: renamed from: h, reason: from kotlin metadata */
    public final Lazy openMeasurementComponent = LazyKt.lazy(new e());

    /* JADX INFO: renamed from: i, reason: from kotlin metadata */
    public final Lazy impressionComponent = LazyKt.lazy(d.b);

    /* JADX INFO: renamed from: j, reason: from kotlin metadata */
    public final Lazy trackerComponent = LazyKt.lazy(new i());

    /* JADX INFO: renamed from: k, reason: from kotlin metadata */
    public final Lazy sdkComponent = LazyKt.lazy(new h());

    /* JADX INFO: renamed from: l, reason: from kotlin metadata */
    public final Lazy renderComponent = LazyKt.lazy(new g());

    @Metadata(d1 = {"\u0000\b\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"Lcom/chartboost/sdk/impl/x0;", "a", "()Lcom/chartboost/sdk/impl/x0;"}, k = 3, mv = {1, 8, 0})
    public static final class a extends Lambda implements Function0<x0> {
        public a() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final x0 invoke() {
            Context applicationContext = u3.this.d().getApplicationContext();
            Intrinsics.checkNotNullExpressionValue(applicationContext, "application.applicationContext");
            return new x0(applicationContext, u3.this.d());
        }
    }

    @Metadata(d1 = {"\u0000\b\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"Lcom/chartboost/sdk/impl/b1;", "a", "()Lcom/chartboost/sdk/impl/b1;"}, k = 3, mv = {1, 8, 0})
    public static final class b extends Lambda implements Function0<b1> {
        public b() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final b1 invoke() {
            return new b1(u3.this.a(), u3.this.f(), u3.this.j(), null, u3.this.n(), 8, null);
        }
    }

    @Metadata(d1 = {"\u0000\b\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"Lcom/chartboost/sdk/impl/r4;", "a", "()Lcom/chartboost/sdk/impl/r4;"}, k = 3, mv = {1, 8, 0})
    public static final class c extends Lambda implements Function0<r4> {
        public static final c b = new c();

        public c() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final r4 invoke() {
            return new r4();
        }
    }

    @Metadata(d1 = {"\u0000\b\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"Lcom/chartboost/sdk/impl/c6;", "a", "()Lcom/chartboost/sdk/impl/c6;"}, k = 3, mv = {1, 8, 0})
    public static final class d extends Lambda implements Function0<c6> {
        public static final d b = new d();

        public d() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final c6 invoke() {
            return new c6();
        }
    }

    @Metadata(d1 = {"\u0000\b\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"Lcom/chartboost/sdk/impl/u7;", "a", "()Lcom/chartboost/sdk/impl/u7;"}, k = 3, mv = {1, 8, 0})
    public static final class e extends Lambda implements Function0<u7> {
        public e() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final u7 invoke() {
            return new u7(u3.this.a(), u3.this.e());
        }
    }

    @Metadata(d1 = {"\u0000\b\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"Lcom/chartboost/sdk/impl/o8;", "a", "()Lcom/chartboost/sdk/impl/o8;"}, k = 3, mv = {1, 8, 0})
    public static final class f extends Lambda implements Function0<o8> {
        public f() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final o8 invoke() {
            return new o8(u3.this.a(), u3.this.n());
        }
    }

    @Metadata(d1 = {"\u0000\b\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"Lcom/chartboost/sdk/impl/y8;", "a", "()Lcom/chartboost/sdk/impl/y8;"}, k = 3, mv = {1, 8, 0})
    public static final class g extends Lambda implements Function0<y8> {
        public g() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final y8 invoke() {
            return new y8(u3.this.a(), u3.this.n());
        }
    }

    @Metadata(d1 = {"\u0000\b\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"Lcom/chartboost/sdk/impl/r9;", "a", "()Lcom/chartboost/sdk/impl/r9;"}, k = 3, mv = {1, 8, 0})
    public static final class h extends Lambda implements Function0<r9> {
        public h() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final r9 invoke() {
            return new r9(u3.this.a(), u3.this.f(), u3.this.e(), u3.this.i(), u3.this.n());
        }
    }

    public final Application d() {
        Application application = this.unsafeApplication;
        if (application != null) {
            return application;
        }
        b7.b("Missing application. Cannot start Chartboost SDK.", null, 2, null);
        throw new z2();
    }

    public boolean h() {
        return this.unsafeApplication != null;
    }

    public boolean m() {
        String str;
        String str2 = this._appId;
        return (str2 == null || str2.length() == 0 || (str = this._appSignature) == null || str.length() == 0) ? false : true;
    }

    public String b() {
        String str = this._appId;
        return str == null ? "" : str;
    }

    public String c() {
        String str = this._appSignature;
        return str == null ? "" : str;
    }

    public z0 e() {
        return (z0) this.applicationComponent.getValue();
    }

    public n8 j() {
        return (n8) this.privacyComponent.getValue();
    }

    public q4 f() {
        return (q4) this.executorComponent.getValue();
    }

    public q7 i() {
        return (q7) this.openMeasurementComponent.getValue();
    }

    public b6 g() {
        return (b6) this.impressionComponent.getValue();
    }

    @Metadata(d1 = {"\u0000\b\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"Lcom/chartboost/sdk/impl/ga;", "a", "()Lcom/chartboost/sdk/impl/ga;"}, k = 3, mv = {1, 8, 0})
    public static final class i extends Lambda implements Function0<ga> {
        public i() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final ga invoke() {
            return new ga(LazyKt.lazy(new a(u3.this)), LazyKt.lazy(new b(u3.this)), LazyKt.lazy(new c(u3.this)));
        }

        @Metadata(d1 = {"\u0000\b\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"Lcom/chartboost/sdk/impl/w0;", "a", "()Lcom/chartboost/sdk/impl/w0;"}, k = 3, mv = {1, 8, 0})
        public static final class a extends Lambda implements Function0<w0> {
            public final /* synthetic */ u3 b;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public a(u3 u3Var) {
                super(0);
                this.b = u3Var;
            }

            @Override // kotlin.jvm.functions.Function0
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public final w0 invoke() {
                return this.b.a();
            }
        }

        @Metadata(d1 = {"\u0000\b\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"Lcom/chartboost/sdk/impl/z0;", "a", "()Lcom/chartboost/sdk/impl/z0;"}, k = 3, mv = {1, 8, 0})
        public static final class b extends Lambda implements Function0<z0> {
            public final /* synthetic */ u3 b;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public b(u3 u3Var) {
                super(0);
                this.b = u3Var;
            }

            @Override // kotlin.jvm.functions.Function0
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public final z0 invoke() {
                return this.b.e();
            }
        }

        @Metadata(d1 = {"\u0000\b\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"Lcom/chartboost/sdk/impl/l8;", "a", "()Lcom/chartboost/sdk/impl/l8;"}, k = 3, mv = {1, 8, 0})
        public static final class c extends Lambda implements Function0<l8> {
            public final /* synthetic */ u3 b;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public c(u3 u3Var) {
                super(0);
                this.b = u3Var;
            }

            @Override // kotlin.jvm.functions.Function0
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public final l8 invoke() {
                return this.b.j().a();
            }
        }
    }

    public ea n() {
        return (ea) this.trackerComponent.getValue();
    }

    public w0 a() {
        return (w0) this.androidComponent.getValue();
    }

    public void a(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        Context applicationContext = context.getApplicationContext();
        Application application = applicationContext instanceof Application ? (Application) applicationContext : null;
        if (application == null) {
            b7.b("Failed to initialize Chartboost SDK. Application is null.", null, 2, null);
        } else {
            this.unsafeApplication = application;
        }
    }

    public n9 l() {
        return (n9) this.sdkComponent.getValue();
    }

    public x8 k() {
        return (x8) this.renderComponent.getValue();
    }

    public void a(String appId, String appSignature) {
        Intrinsics.checkNotNullParameter(appId, "appId");
        Intrinsics.checkNotNullParameter(appSignature, "appSignature");
        this._appId = appId;
        this._appSignature = appSignature;
    }
}
