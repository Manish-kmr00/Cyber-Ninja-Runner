package com.chartboost.sdk.impl;

import android.app.Application;
import android.content.ContentResolver;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.util.DisplayMetrics;
import android.view.WindowManager;
import com.amazon.aps.shared.metrics.model.ApsMetricsDataMap;
import com.fyber.inneractive.sdk.external.InneractiveMediationDefs;
import com.mbridge.msdk.foundation.download.core.DownloadCommon;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes10.dex */
@Metadata(d1 = {"\u0000p\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0000\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0007\u001a\u00020\u0002\u0012\u0006\u0010\f\u001a\u00020\b¢\u0006\u0004\b<\u0010=R\u001a\u0010\u0007\u001a\u00020\u00028\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001a\u0010\f\u001a\u00020\b8\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\t\u0010\u000bR\u001b\u0010\u0012\u001a\u00020\r8VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011R\u001b\u0010\u0014\u001a\u00020\r8VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\u0013\u0010\u000f\u001a\u0004\b\u0013\u0010\u0011R\u001b\u0010\u0019\u001a\u00020\u00158VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\u0016\u0010\u000f\u001a\u0004\b\u0017\u0010\u0018R\u001b\u0010\u001c\u001a\u00020\u001a8VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\u0010\u0010\u000f\u001a\u0004\b\u0016\u0010\u001bR\u001b\u0010 \u001a\u00020\u001d8VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\u001e\u0010\u000f\u001a\u0004\b\u0003\u0010\u001fR\u001b\u0010%\u001a\u00020!8VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\"\u0010\u000f\u001a\u0004\b#\u0010$R\u001b\u0010(\u001a\u00020&8VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b#\u0010\u000f\u001a\u0004\b\u001e\u0010'R\u001b\u0010,\u001a\u00020)8VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\u0017\u0010\u000f\u001a\u0004\b*\u0010+R\u001b\u00101\u001a\u00020-8VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b.\u0010\u000f\u001a\u0004\b/\u00100R\u001b\u00104\u001a\u0002028VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b/\u0010\u000f\u001a\u0004\b\"\u00103R\u001b\u00107\u001a\u0002058VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b*\u0010\u000f\u001a\u0004\b.\u00106R\u001b\u0010;\u001a\u0002088VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b9\u0010\u000f\u001a\u0004\b\u000e\u0010:¨\u0006>"}, d2 = {"Lcom/chartboost/sdk/impl/x0;", "Lcom/chartboost/sdk/impl/w0;", "Landroid/content/Context;", "a", "Landroid/content/Context;", "getContext", "()Landroid/content/Context;", "context", "Landroid/app/Application;", DownloadCommon.DOWNLOAD_REPORT_FIND_FILE_RESULT_VALUE_B, "Landroid/app/Application;", "()Landroid/app/Application;", "app", "Landroid/content/SharedPreferences;", ApsMetricsDataMap.APSMETRICS_FIELD_CUSTOM, "Lkotlin/Lazy;", InneractiveMediationDefs.GENDER_FEMALE, "()Landroid/content/SharedPreferences;", "sharedPreferences", "d", "trackingSharedPreferences", "Lcom/chartboost/sdk/impl/v0;", "e", "j", "()Lcom/chartboost/sdk/impl/v0;", "android", "Lcom/chartboost/sdk/impl/sa;", "()Lcom/chartboost/sdk/impl/sa;", "uiPoster", "Lcom/chartboost/sdk/impl/n1;", "g", "()Lcom/chartboost/sdk/impl/n1;", "base64Wrapper", "Lcom/chartboost/sdk/impl/g9;", "h", "i", "()Lcom/chartboost/sdk/impl/g9;", "resourceLoader", "Lcom/chartboost/sdk/impl/u9;", "()Lcom/chartboost/sdk/impl/u9;", "sharedPrefsHelper", "Landroid/view/WindowManager;", "m", "()Landroid/view/WindowManager;", "windowManager", "Landroid/util/DisplayMetrics;", CampaignEx.JSON_KEY_AD_K, "l", "()Landroid/util/DisplayMetrics;", "displayMetrics", "Lcom/chartboost/sdk/impl/b4;", "()Lcom/chartboost/sdk/impl/b4;", "displayMeasurement", "Lcom/chartboost/sdk/impl/z3;", "()Lcom/chartboost/sdk/impl/z3;", "deviceFieldsWrapper", "Landroid/content/ContentResolver;", "n", "()Landroid/content/ContentResolver;", "contentResolver", "<init>", "(Landroid/content/Context;Landroid/app/Application;)V", "ChartboostMonetization-9.8.3_productionRelease"}, k = 1, mv = {1, 8, 0})
public final class x0 implements w0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name and from kotlin metadata */
    public final Context context;

    /* JADX INFO: renamed from: b, reason: from kotlin metadata */
    public final Application app;

    /* JADX INFO: renamed from: c, reason: from kotlin metadata */
    public final Lazy sharedPreferences;

    /* JADX INFO: renamed from: d, reason: from kotlin metadata */
    public final Lazy trackingSharedPreferences;

    /* JADX INFO: renamed from: e, reason: from kotlin metadata */
    public final Lazy android;

    /* JADX INFO: renamed from: f, reason: from kotlin metadata */
    public final Lazy uiPoster;

    /* JADX INFO: renamed from: g, reason: from kotlin metadata */
    public final Lazy base64Wrapper;

    /* JADX INFO: renamed from: h, reason: from kotlin metadata */
    public final Lazy resourceLoader;

    /* JADX INFO: renamed from: i, reason: from kotlin metadata */
    public final Lazy sharedPrefsHelper;

    /* JADX INFO: renamed from: j, reason: from kotlin metadata */
    public final Lazy windowManager;

    /* JADX INFO: renamed from: k, reason: from kotlin metadata */
    public final Lazy displayMetrics;

    /* JADX INFO: renamed from: l, reason: from kotlin metadata */
    public final Lazy displayMeasurement;

    /* JADX INFO: renamed from: m, reason: from kotlin metadata */
    public final Lazy deviceFieldsWrapper;

    /* JADX INFO: renamed from: n, reason: from kotlin metadata */
    public final Lazy contentResolver;

    @Metadata(d1 = {"\u0000\b\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lcom/chartboost/sdk/impl/v0;", "kotlin.jvm.PlatformType", "a", "()Lcom/chartboost/sdk/impl/v0;"}, k = 3, mv = {1, 8, 0})
    public static final class a extends Lambda implements Function0<v0> {
        public static final a b = new a();

        public a() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final v0 invoke() {
            return v0.b();
        }
    }

    @Metadata(d1 = {"\u0000\b\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"Lcom/chartboost/sdk/impl/n1;", "a", "()Lcom/chartboost/sdk/impl/n1;"}, k = 3, mv = {1, 8, 0})
    public static final class b extends Lambda implements Function0<n1> {
        public static final b b = new b();

        public b() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final n1 invoke() {
            return new n1();
        }
    }

    @Metadata(d1 = {"\u0000\b\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"Lcom/chartboost/sdk/impl/z3;", "a", "()Lcom/chartboost/sdk/impl/z3;"}, k = 3, mv = {1, 8, 0})
    public static final class d extends Lambda implements Function0<z3> {
        public d() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final z3 invoke() {
            return new z3(x0.this.getContext(), x0.this.h());
        }
    }

    @Metadata(d1 = {"\u0000\b\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"Lcom/chartboost/sdk/impl/b4;", "a", "()Lcom/chartboost/sdk/impl/b4;"}, k = 3, mv = {1, 8, 0})
    public static final class e extends Lambda implements Function0<b4> {
        public e() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final b4 invoke() {
            return new b4(x0.this.m(), x0.this.l(), null, null, 12, null);
        }
    }

    @Metadata(d1 = {"\u0000\b\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"Lcom/chartboost/sdk/impl/g9;", "a", "()Lcom/chartboost/sdk/impl/g9;"}, k = 3, mv = {1, 8, 0})
    public static final class g extends Lambda implements Function0<g9> {
        public g() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final g9 invoke() {
            Resources resources = x0.this.getContext().getResources();
            Intrinsics.checkNotNullExpressionValue(resources, "context.resources");
            return new g9(resources);
        }
    }

    @Metadata(d1 = {"\u0000\b\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"Lcom/chartboost/sdk/impl/u9;", "a", "()Lcom/chartboost/sdk/impl/u9;"}, k = 3, mv = {1, 8, 0})
    public static final class i extends Lambda implements Function0<u9> {
        public i() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final u9 invoke() {
            return new u9(x0.this.f());
        }
    }

    @Metadata(d1 = {"\u0000\b\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"Lcom/chartboost/sdk/impl/ta;", "a", "()Lcom/chartboost/sdk/impl/ta;"}, k = 3, mv = {1, 8, 0})
    public static final class k extends Lambda implements Function0<ta> {
        public static final k b = new k();

        public k() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final ta invoke() {
            return new ta();
        }
    }

    public x0(Context context, Application app) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(app, "app");
        this.context = context;
        this.app = app;
        this.sharedPreferences = LazyKt.lazy(new h());
        this.trackingSharedPreferences = LazyKt.lazy(new j());
        this.android = LazyKt.lazy(a.b);
        this.uiPoster = LazyKt.lazy(k.b);
        this.base64Wrapper = LazyKt.lazy(b.b);
        this.resourceLoader = LazyKt.lazy(new g());
        this.sharedPrefsHelper = LazyKt.lazy(new i());
        this.windowManager = LazyKt.lazy(new l());
        this.displayMetrics = LazyKt.lazy(new f());
        this.displayMeasurement = LazyKt.lazy(new e());
        this.deviceFieldsWrapper = LazyKt.lazy(new d());
        this.contentResolver = LazyKt.lazy(new c());
    }

    @Override // com.chartboost.sdk.impl.w0
    public Context getContext() {
        return this.context;
    }

    @Override // com.chartboost.sdk.impl.w0
    /* JADX INFO: renamed from: b, reason: from getter */
    public Application getApp() {
        return this.app;
    }

    @Metadata(d1 = {"\u0000\b\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Landroid/content/SharedPreferences;", "kotlin.jvm.PlatformType", "a", "()Landroid/content/SharedPreferences;"}, k = 3, mv = {1, 8, 0})
    public static final class h extends Lambda implements Function0<SharedPreferences> {
        public h() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final SharedPreferences invoke() {
            return x0.this.getContext().getSharedPreferences("cbPrefs", 0);
        }
    }

    @Override // com.chartboost.sdk.impl.w0
    public SharedPreferences f() {
        Object value = this.sharedPreferences.getValue();
        Intrinsics.checkNotNullExpressionValue(value, "<get-sharedPreferences>(...)");
        return (SharedPreferences) value;
    }

    @Metadata(d1 = {"\u0000\b\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Landroid/content/SharedPreferences;", "kotlin.jvm.PlatformType", "a", "()Landroid/content/SharedPreferences;"}, k = 3, mv = {1, 8, 0})
    public static final class j extends Lambda implements Function0<SharedPreferences> {
        public j() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final SharedPreferences invoke() {
            return x0.this.getContext().getSharedPreferences("cbPrefsTracking", 0);
        }
    }

    @Override // com.chartboost.sdk.impl.w0
    public SharedPreferences d() {
        Object value = this.trackingSharedPreferences.getValue();
        Intrinsics.checkNotNullExpressionValue(value, "<get-trackingSharedPreferences>(...)");
        return (SharedPreferences) value;
    }

    @Override // com.chartboost.sdk.impl.w0
    public v0 j() {
        Object value = this.android.getValue();
        Intrinsics.checkNotNullExpressionValue(value, "<get-android>(...)");
        return (v0) value;
    }

    @Override // com.chartboost.sdk.impl.w0
    public sa e() {
        return (sa) this.uiPoster.getValue();
    }

    @Override // com.chartboost.sdk.impl.w0
    public n1 a() {
        return (n1) this.base64Wrapper.getValue();
    }

    @Override // com.chartboost.sdk.impl.w0
    public g9 i() {
        return (g9) this.resourceLoader.getValue();
    }

    @Override // com.chartboost.sdk.impl.w0
    public u9 g() {
        return (u9) this.sharedPrefsHelper.getValue();
    }

    @Metadata(d1 = {"\u0000\b\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"Landroid/view/WindowManager;", "a", "()Landroid/view/WindowManager;"}, k = 3, mv = {1, 8, 0})
    public static final class l extends Lambda implements Function0<WindowManager> {
        public l() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final WindowManager invoke() {
            Object systemService = x0.this.getContext().getSystemService("window");
            Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.view.WindowManager");
            return (WindowManager) systemService;
        }
    }

    public WindowManager m() {
        return (WindowManager) this.windowManager.getValue();
    }

    @Metadata(d1 = {"\u0000\b\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Landroid/util/DisplayMetrics;", "kotlin.jvm.PlatformType", "a", "()Landroid/util/DisplayMetrics;"}, k = 3, mv = {1, 8, 0})
    public static final class f extends Lambda implements Function0<DisplayMetrics> {
        public f() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final DisplayMetrics invoke() {
            return x0.this.getContext().getResources().getDisplayMetrics();
        }
    }

    public DisplayMetrics l() {
        Object value = this.displayMetrics.getValue();
        Intrinsics.checkNotNullExpressionValue(value, "<get-displayMetrics>(...)");
        return (DisplayMetrics) value;
    }

    @Override // com.chartboost.sdk.impl.w0
    public b4 h() {
        return (b4) this.displayMeasurement.getValue();
    }

    @Override // com.chartboost.sdk.impl.w0
    public z3 k() {
        return (z3) this.deviceFieldsWrapper.getValue();
    }

    @Metadata(d1 = {"\u0000\b\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Landroid/content/ContentResolver;", "kotlin.jvm.PlatformType", "a", "()Landroid/content/ContentResolver;"}, k = 3, mv = {1, 8, 0})
    public static final class c extends Lambda implements Function0<ContentResolver> {
        public c() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final ContentResolver invoke() {
            return x0.this.getContext().getContentResolver();
        }
    }

    @Override // com.chartboost.sdk.impl.w0
    public ContentResolver c() {
        Object value = this.contentResolver.getValue();
        Intrinsics.checkNotNullExpressionValue(value, "<get-contentResolver>(...)");
        return (ContentResolver) value;
    }
}
