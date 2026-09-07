package com.chartboost.sdk.impl;

import com.amazon.aps.shared.metrics.model.ApsMetricsDataMap;
import com.chartboost.sdk.internal.Model.CBError;
import com.fyber.inneractive.sdk.external.InneractiveMediationDefs;
import com.mbridge.msdk.foundation.download.core.DownloadCommon;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.smaato.sdk.video.vast.model.MediaFile;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.text.StringsKt;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000\u0094\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u0007\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0010\b\u0000\u0018\u00002\u00020\u00012\u00020\u0002BY\u0012\u0006\u0010(\u001a\u00020&\u0012\u0006\u0010+\u001a\u00020)\u0012\u0006\u0010.\u001a\u00020,\u0012\u0006\u00101\u001a\u00020/\u0012\u0006\u00104\u001a\u00020\u0002\u0012\u0006\u00108\u001a\u000205\u0012\u0006\u0010;\u001a\u00020\u001f\u0012\u0006\u0010?\u001a\u00020<\u0012\u0006\u0010C\u001a\u00020@\u0012\b\b\u0002\u0010G\u001a\u00020D¢\u0006\u0004\bR\u0010SJ\u0018\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0096\u0001¢\u0006\u0004\b\u0006\u0010\u0007J\u0018\u0010\b\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0096\u0001¢\u0006\u0004\b\b\u0010\u0007J+\u0010\u0006\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\u00032\b\u0010\u000b\u001a\u0004\u0018\u00010\n2\b\u0010\f\u001a\u0004\u0018\u00010\nH\u0016¢\u0006\u0004\b\u0006\u0010\rJ\u000f\u0010\u0006\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u0006\u0010\u000eJ!\u0010\b\u001a\u00020\u00052\b\u0010\u000f\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u0011\u001a\u00020\u0010H\u0016¢\u0006\u0004\b\b\u0010\u0012J\u0017\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0014\u001a\u00020\u0013H\u0016¢\u0006\u0004\b\u0006\u0010\u0015J\u0017\u0010\u0016\u001a\u00020\u00052\u0006\u0010\u0014\u001a\u00020\u0013H\u0016¢\u0006\u0004\b\u0016\u0010\u0015J\u0017\u0010\b\u001a\u00020\u00052\u0006\u0010\u0014\u001a\u00020\u0013H\u0016¢\u0006\u0004\b\b\u0010\u0015J)\u0010\b\u001a\u00020\u00182\u0006\u0010\u0017\u001a\u00020\u00032\b\u0010\u0019\u001a\u0004\u0018\u00010\u00182\u0006\u0010\u001b\u001a\u00020\u001aH\u0016¢\u0006\u0004\b\b\u0010\u001cJ#\u0010\b\u001a\u00020\u00052\b\u0010\u000f\u001a\u0004\u0018\u00010\u00032\b\u0010\u0019\u001a\u0004\u0018\u00010\u0018H\u0002¢\u0006\u0004\b\b\u0010\u001dJ\u0019\u0010\u001e\u001a\u00020\u00052\b\u0010\u000f\u001a\u0004\u0018\u00010\u0003H\u0002¢\u0006\u0004\b\u001e\u0010\u0007J\u0019\u0010\u0016\u001a\u00020\u00052\b\u0010\u000f\u001a\u0004\u0018\u00010\u0003H\u0002¢\u0006\u0004\b\u0016\u0010\u0007J\u001f\u0010\b\u001a\u00020\u0005*\u0004\u0018\u00010\u001f2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0003H\u0002¢\u0006\u0004\b\b\u0010 J'\u0010\b\u001a\u00020\u0005*\u0004\u0018\u00010\u001f2\b\u0010\u000f\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u0011\u001a\u00020\u0010H\u0002¢\u0006\u0004\b\b\u0010!J.\u0010\b\u001a\u00020\u0005*\u0004\u0018\u00010\u001f2\u0017\u0010$\u001a\u0013\u0012\u0004\u0012\u00020\u001f\u0012\u0004\u0012\u00020\u00050\"¢\u0006\u0002\b#H\u0002¢\u0006\u0004\b\b\u0010%R\u0014\u0010(\u001a\u00020&8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\b\u0010'R\u0014\u0010+\u001a\u00020)8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0006\u0010*R\u0014\u0010.\u001a\u00020,8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0016\u0010-R\u0014\u00101\u001a\u00020/8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001e\u00100R\u0014\u00104\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b2\u00103R\u0014\u00108\u001a\u0002058\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b6\u00107R\u0014\u0010;\u001a\u00020\u001f8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b9\u0010:R\u0014\u0010?\u001a\u00020<8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b=\u0010>R\u0014\u0010C\u001a\u00020@8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bA\u0010BR\u0014\u0010G\u001a\u00020D8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bE\u0010FR\"\u0010L\u001a\u00020\u00188\u0016@\u0016X\u0096\u000e¢\u0006\u0012\n\u0004\bH\u0010I\u001a\u0004\b\b\u0010J\"\u0004\b2\u0010KR\u0018\u0010O\u001a\u0004\u0018\u00010\u00188\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bM\u0010NR\u0016\u0010Q\u001a\u00020\u00188\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bP\u0010I¨\u0006T"}, d2 = {"Lcom/chartboost/sdk/impl/w5;", "Lcom/chartboost/sdk/impl/y5;", "Lcom/chartboost/sdk/impl/f3;", "", "message", "", DownloadCommon.DOWNLOAD_REPORT_FIND_FILE_RESULT_VALUE_B, "(Ljava/lang/String;)V", "a", "location", "", "videoPosition", "videoDuration", "(Ljava/lang/String;Ljava/lang/Float;Ljava/lang/Float;)V", "()V", "url", "Lcom/chartboost/sdk/internal/Model/CBError$a;", "error", "(Ljava/lang/String;Lcom/chartboost/sdk/internal/Model/CBError$a;)V", "Lcom/chartboost/sdk/impl/m2;", "cbUrl", "(Lcom/chartboost/sdk/impl/m2;)V", ApsMetricsDataMap.APSMETRICS_FIELD_CUSTOM, "urlFromCreative", "", "shouldDismiss", "Lcom/chartboost/sdk/impl/l6;", "impressionState", "(Ljava/lang/String;Ljava/lang/Boolean;Lcom/chartboost/sdk/impl/l6;)Z", "(Ljava/lang/String;Ljava/lang/Boolean;)V", "d", "Lcom/chartboost/sdk/impl/x5;", "(Lcom/chartboost/sdk/impl/x5;Ljava/lang/String;)V", "(Lcom/chartboost/sdk/impl/x5;Ljava/lang/String;Lcom/chartboost/sdk/internal/Model/CBError$a;)V", "Lkotlin/Function1;", "Lkotlin/ExtensionFunctionType;", "block", "(Lcom/chartboost/sdk/impl/x5;Lkotlin/jvm/functions/Function1;)V", "Lcom/chartboost/sdk/impl/v;", "Lcom/chartboost/sdk/impl/v;", "adUnit", "Lcom/chartboost/sdk/impl/za;", "Lcom/chartboost/sdk/impl/za;", "urlResolver", "Lcom/chartboost/sdk/impl/w6;", "Lcom/chartboost/sdk/impl/w6;", "intentResolver", "Lcom/chartboost/sdk/impl/c3;", "Lcom/chartboost/sdk/impl/c3;", "clickRequest", "e", "Lcom/chartboost/sdk/impl/f3;", "clickTracking", "Lcom/chartboost/sdk/impl/k6;", InneractiveMediationDefs.GENDER_FEMALE, "Lcom/chartboost/sdk/impl/k6;", MediaFile.MEDIA_TYPE, "g", "Lcom/chartboost/sdk/impl/x5;", "impressionCallback", "Lcom/chartboost/sdk/impl/s7;", "h", "Lcom/chartboost/sdk/impl/s7;", "openMeasurementImpressionCallback", "Lcom/chartboost/sdk/impl/j0;", "i", "Lcom/chartboost/sdk/impl/j0;", "adUnitRendererImpressionCallback", "Lcom/chartboost/sdk/impl/o9;", "j", "Lcom/chartboost/sdk/impl/o9;", "sdkConfig", CampaignEx.JSON_KEY_AD_K, "Z", "()Z", "(Z)V", "click", "l", "Ljava/lang/Boolean;", "retargetReinstall", "m", "shouldDismissAfterClick", "<init>", "(Lcom/chartboost/sdk/impl/v;Lcom/chartboost/sdk/impl/za;Lcom/chartboost/sdk/impl/w6;Lcom/chartboost/sdk/impl/c3;Lcom/chartboost/sdk/impl/f3;Lcom/chartboost/sdk/impl/k6;Lcom/chartboost/sdk/impl/x5;Lcom/chartboost/sdk/impl/s7;Lcom/chartboost/sdk/impl/j0;Lcom/chartboost/sdk/impl/o9;)V", "ChartboostMonetization-9.8.3_productionRelease"}, k = 1, mv = {1, 8, 0})
public final class w5 implements y5, f3 {

    /* JADX INFO: renamed from: a, reason: collision with root package name and from kotlin metadata */
    public final v adUnit;

    /* JADX INFO: renamed from: b, reason: from kotlin metadata */
    public final za urlResolver;

    /* JADX INFO: renamed from: c, reason: from kotlin metadata */
    public final w6 intentResolver;

    /* JADX INFO: renamed from: d, reason: from kotlin metadata */
    public final c3 clickRequest;

    /* JADX INFO: renamed from: e, reason: from kotlin metadata */
    public final f3 clickTracking;

    /* JADX INFO: renamed from: f, reason: from kotlin metadata */
    public final k6 mediaType;

    /* JADX INFO: renamed from: g, reason: from kotlin metadata */
    public final x5 impressionCallback;

    /* JADX INFO: renamed from: h, reason: from kotlin metadata */
    public final s7 openMeasurementImpressionCallback;

    /* JADX INFO: renamed from: i, reason: from kotlin metadata */
    public final j0 adUnitRendererImpressionCallback;

    /* JADX INFO: renamed from: j, reason: from kotlin metadata */
    public final o9 sdkConfig;

    /* JADX INFO: renamed from: k, reason: from kotlin metadata */
    public boolean click;

    /* JADX INFO: renamed from: l, reason: from kotlin metadata */
    public Boolean retargetReinstall;

    /* JADX INFO: renamed from: m, reason: from kotlin metadata */
    public boolean shouldDismissAfterClick;

    public w5(v adUnit, za urlResolver, w6 intentResolver, c3 clickRequest, f3 clickTracking, k6 mediaType, x5 impressionCallback, s7 openMeasurementImpressionCallback, j0 adUnitRendererImpressionCallback, o9 sdkConfig) {
        Intrinsics.checkNotNullParameter(adUnit, "adUnit");
        Intrinsics.checkNotNullParameter(urlResolver, "urlResolver");
        Intrinsics.checkNotNullParameter(intentResolver, "intentResolver");
        Intrinsics.checkNotNullParameter(clickRequest, "clickRequest");
        Intrinsics.checkNotNullParameter(clickTracking, "clickTracking");
        Intrinsics.checkNotNullParameter(mediaType, "mediaType");
        Intrinsics.checkNotNullParameter(impressionCallback, "impressionCallback");
        Intrinsics.checkNotNullParameter(openMeasurementImpressionCallback, "openMeasurementImpressionCallback");
        Intrinsics.checkNotNullParameter(adUnitRendererImpressionCallback, "adUnitRendererImpressionCallback");
        Intrinsics.checkNotNullParameter(sdkConfig, "sdkConfig");
        this.adUnit = adUnit;
        this.urlResolver = urlResolver;
        this.intentResolver = intentResolver;
        this.clickRequest = clickRequest;
        this.clickTracking = clickTracking;
        this.mediaType = mediaType;
        this.impressionCallback = impressionCallback;
        this.openMeasurementImpressionCallback = openMeasurementImpressionCallback;
        this.adUnitRendererImpressionCallback = adUnitRendererImpressionCallback;
        this.sdkConfig = sdkConfig;
    }

    @Override // com.chartboost.sdk.impl.y5
    public void a(String url, CBError.a error) {
        Intrinsics.checkNotNullParameter(error, "error");
        this.adUnitRendererImpressionCallback.a(this.adUnit.getImpressionId(), url, error);
    }

    @Override // com.chartboost.sdk.impl.y5
    public void c(m2 cbUrl) {
        Intrinsics.checkNotNullParameter(cbUrl, "cbUrl");
        c(cbUrl.getUrl());
    }

    @Override // com.chartboost.sdk.impl.y5
    public void e(boolean z) {
        this.click = z;
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public /* synthetic */ w5(v vVar, za zaVar, w6 w6Var, c3 c3Var, f3 f3Var, k6 k6Var, x5 x5Var, s7 s7Var, j0 j0Var, o9 o9Var, int i, DefaultConstructorMarker defaultConstructorMarker) {
        o9 o9Var2;
        if ((i & 512) != 0) {
            o9 o9Var3 = y2.b.d().b().get();
            Intrinsics.checkNotNullExpressionValue(o9Var3, "ChartboostDependencyCont…Component.sdkConfig.get()");
            o9Var2 = o9Var3;
        } else {
            o9Var2 = o9Var;
        }
        this(vVar, zaVar, w6Var, c3Var, f3Var, k6Var, x5Var, s7Var, j0Var, o9Var2);
    }

    @Metadata(d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0019\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J\u0019\u0010\u0005\u001a\u00020\u00042\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0016¢\u0006\u0004\b\u0005\u0010\t¨\u0006\n"}, d2 = {"com/chartboost/sdk/impl/w5$b", "Lcom/chartboost/sdk/impl/d3;", "Lorg/json/JSONObject;", "clickJson", "", "a", "(Lorg/json/JSONObject;)V", "", "errorMsg", "(Ljava/lang/String;)V", "ChartboostMonetization-9.8.3_productionRelease"}, k = 1, mv = {1, 8, 0})
    public static final class b implements d3 {
        @Override // com.chartboost.sdk.impl.d3
        public void a(JSONObject clickJson) {
            String string;
            StringBuilder sb = new StringBuilder("onClickRequestSuccess ");
            if (clickJson == null || (string = clickJson.toString()) == null) {
                string = "";
            }
            b7.b(sb.append(string).toString(), null, 2, null);
        }

        @Override // com.chartboost.sdk.impl.d3
        public void a(String errorMsg) {
            b7.b("onClickRequestFailure " + errorMsg, null, 2, null);
        }
    }

    @Override // com.chartboost.sdk.impl.y5
    public void b() {
        this.adUnitRendererImpressionCallback.b(this.adUnit.getImpressionId());
        if (this.shouldDismissAfterClick) {
            this.impressionCallback.B();
        }
    }

    @Override // com.chartboost.sdk.impl.y5
    public void b(m2 cbUrl) {
        Intrinsics.checkNotNullParameter(cbUrl, "cbUrl");
        a(cbUrl.getUrl(), cbUrl.getShouldDismiss());
    }

    public final void d(String url) {
        this.urlResolver.a(url, this.adUnit.getClkp(), this.clickTracking);
    }

    @Override // com.chartboost.sdk.impl.y5
    public void b(String location, Float videoPosition, Float videoDuration) {
        Intrinsics.checkNotNullParameter(location, "location");
        this.clickRequest.a(new b(), new a3(location, this.adUnit.getAdId(), this.adUnit.getTo(), this.adUnit.getCgn(), this.adUnit.getNet.pubnative.lite.sdk.analytics.Reporting.Key.CREATIVE java.lang.String(), videoPosition, videoDuration, this.mediaType, this.retargetReinstall));
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lcom/chartboost/sdk/impl/x5;", "", "a", "(Lcom/chartboost/sdk/impl/x5;)V"}, k = 3, mv = {1, 8, 0})
    public static final class c extends Lambda implements Function1<x5, Unit> {
        public final /* synthetic */ String c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(String str) {
            super(1);
            this.c = str;
        }

        public final void a(x5 notify) {
            Intrinsics.checkNotNullParameter(notify, "$this$notify");
            notify.b();
            w5.this.a("Url impression callback success: " + this.c);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(x5 x5Var) {
            a(x5Var);
            return Unit.INSTANCE;
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lcom/chartboost/sdk/impl/x5;", "", "a", "(Lcom/chartboost/sdk/impl/x5;)V"}, k = 3, mv = {1, 8, 0})
    public static final class a extends Lambda implements Function1<x5, Unit> {
        public final /* synthetic */ String b;
        public final /* synthetic */ CBError.a c;
        public final /* synthetic */ w5 d;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(String str, CBError.a aVar, w5 w5Var) {
            super(1);
            this.b = str;
            this.c = aVar;
            this.d = w5Var;
        }

        public final void a(x5 notify) {
            Intrinsics.checkNotNullParameter(notify, "$this$notify");
            notify.a(this.b, this.c);
            this.d.b("Impression click callback for: " + this.b + " failed with error: " + this.c);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(x5 x5Var) {
            a(x5Var);
            return Unit.INSTANCE;
        }
    }

    @Override // com.chartboost.sdk.impl.f3
    public void b(String message) {
        Intrinsics.checkNotNullParameter(message, "message");
        this.clickTracking.b(message);
    }

    public final void c(String url) {
        a(this.impressionCallback, url, CBError.a.LOAD_NOT_FINISHED);
    }

    public final void a(x5 x5Var, String str, CBError.a aVar) {
        a(x5Var, new a(str, aVar, this));
    }

    /* JADX INFO: renamed from: a, reason: from getter */
    public boolean getClick() {
        return this.click;
    }

    public final void a(String url, Boolean shouldDismiss) {
        Unit unit;
        this.openMeasurementImpressionCallback.d();
        if (shouldDismiss != null) {
            this.shouldDismissAfterClick = shouldDismiss.booleanValue();
        }
        CBError.a aVarA = this.urlResolver.a(url, this.adUnit.getClkp(), this.clickTracking);
        if (aVarA != null) {
            a(this.impressionCallback, url, aVarA);
            unit = Unit.INSTANCE;
        } else {
            unit = null;
        }
        if (unit == null) {
            a(this.impressionCallback, url);
        }
    }

    public final void a(x5 x5Var, Function1<? super x5, Unit> function1) {
        Unit unit;
        if (x5Var != null) {
            x5Var.a(false);
            function1.invoke(x5Var);
            unit = Unit.INSTANCE;
        } else {
            unit = null;
        }
        if (unit == null) {
            b7.b("Impression callback is null", null, 2, null);
        }
    }

    @Override // com.chartboost.sdk.impl.y5
    public boolean a(String urlFromCreative, Boolean shouldDismiss, l6 impressionState) {
        Intrinsics.checkNotNullParameter(urlFromCreative, "urlFromCreative");
        Intrinsics.checkNotNullParameter(impressionState, "impressionState");
        if (shouldDismiss != null) {
            this.shouldDismissAfterClick = shouldDismiss.booleanValue();
        }
        if (impressionState != l6.DISPLAYED) {
            return false;
        }
        if (!this.sdkConfig.z || StringsKt.isBlank(urlFromCreative)) {
            urlFromCreative = this.adUnit.getLink();
        }
        String str = this.adUnit.getCom.facebook.gamingservices.cloudgaming.internal.SDKConstants.PARAM_DEEP_LINK java.lang.String();
        if (this.intentResolver.b(str)) {
            this.retargetReinstall = Boolean.TRUE;
            urlFromCreative = str;
        } else {
            this.retargetReinstall = Boolean.FALSE;
        }
        if (getClick()) {
            return false;
        }
        e(true);
        this.impressionCallback.b(false);
        a(urlFromCreative, Boolean.valueOf(this.shouldDismissAfterClick));
        return true;
    }

    @Override // com.chartboost.sdk.impl.y5
    public void a(m2 cbUrl) {
        Intrinsics.checkNotNullParameter(cbUrl, "cbUrl");
        d(cbUrl.getUrl());
    }

    public final void a(x5 x5Var, String str) {
        a(x5Var, new c(str));
    }

    @Override // com.chartboost.sdk.impl.f3
    public void a(String message) {
        Intrinsics.checkNotNullParameter(message, "message");
        this.clickTracking.a(message);
    }
}
