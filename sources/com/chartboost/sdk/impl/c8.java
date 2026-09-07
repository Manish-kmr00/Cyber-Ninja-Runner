package com.chartboost.sdk.impl;

import android.os.Build;
import com.amazon.aps.shared.metrics.model.ApsMetricsDataMap;
import com.amazon.device.ads.DTBMetricsConfiguration;
import com.chartboost.sdk.internal.Model.CBError;
import com.mbridge.msdk.foundation.download.core.DownloadCommon;
import com.mbridge.msdk.mbsignalcommon.commonwebview.ToolBar;
import com.smaato.sdk.video.vast.model.Ad;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import net.pubnative.lite.sdk.analytics.Reporting;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000¤\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0006\b\u0000\u0018\u00002\u00020\u00012\u00020\u0002BM\u0012\u0006\u0010@\u001a\u00020<\u0012\u0006\u00102\u001a\u000201\u0012\u0006\u0010F\u001a\u00020D\u0012\u0014\b\u0002\u0010J\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020G0\u001c\u0012\u000e\b\u0002\u0010N\u001a\b\u0012\u0004\u0012\u00020L0K\u0012\u0006\u0010O\u001a\u00020\u0002¢\u0006\u0004\bP\u0010QJ \u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u0003H\u0096\u0001¢\u0006\u0004\b\u0007\u0010\bJ\u0018\u0010\u000b\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\tH\u0096\u0001¢\u0006\u0004\b\u000b\u0010\fJ\u0018\u0010\r\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\tH\u0096\u0001¢\u0006\u0004\b\r\u0010\fJ\u0018\u0010\u0010\u001a\u00020\u00062\u0006\u0010\u000f\u001a\u00020\u000eH\u0096\u0001¢\u0006\u0004\b\u0010\u0010\u0011J\u0018\u0010\u0014\u001a\u00020\u00062\u0006\u0010\u0013\u001a\u00020\u0012H\u0096\u0001¢\u0006\u0004\b\u0014\u0010\u0015J\u0018\u0010\u0016\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\tH\u0096\u0001¢\u0006\u0004\b\u0016\u0010\fJ\u0014\u0010\u000b\u001a\u00020\t*\u00020\tH\u0096\u0001¢\u0006\u0004\b\u000b\u0010\u0017J\u0014\u0010\r\u001a\u00020\t*\u00020\tH\u0096\u0001¢\u0006\u0004\b\r\u0010\u0017J\u0014\u0010\u0010\u001a\u00020\u000e*\u00020\u000eH\u0096\u0001¢\u0006\u0004\b\u0010\u0010\u0018J\u0014\u0010\u0014\u001a\u00020\u0012*\u00020\u0012H\u0096\u0001¢\u0006\u0004\b\u0014\u0010\u0019J\u0014\u0010\u0016\u001a\u00020\t*\u00020\tH\u0096\u0001¢\u0006\u0004\b\u0016\u0010\u0017J0\u0010 \u001a\u00020\u00062\u0006\u0010\u001b\u001a\u00020\u001a2\u0017\u0010\u001f\u001a\u0013\u0012\u0004\u0012\u00020\u001d\u0012\u0004\u0012\u00020\u00060\u001c¢\u0006\u0002\b\u001eH\u0016¢\u0006\u0004\b \u0010!J,\u0010\"\u001a\u00020\u0006*\u0013\u0012\u0004\u0012\u00020\u001d\u0012\u0004\u0012\u00020\u00060\u001c¢\u0006\u0002\b\u001e2\u0006\u0010\u001b\u001a\u00020\u001aH\u0002¢\u0006\u0004\b\"\u0010#J,\u0010$\u001a\u00020\u0006*\u0013\u0012\u0004\u0012\u00020\u001d\u0012\u0004\u0012\u00020\u00060\u001c¢\u0006\u0002\b\u001e2\u0006\u0010\u001b\u001a\u00020\u001aH\u0002¢\u0006\u0004\b$\u0010#J8\u0010 \u001a\u00020\u0006*\u0013\u0012\u0004\u0012\u00020\u001d\u0012\u0004\u0012\u00020\u00060\u001c¢\u0006\u0002\b\u001e2\u0006\u0010\u001b\u001a\u00020\u001a2\n\u0010'\u001a\u00060%j\u0002`&H\u0002¢\u0006\u0004\b \u0010(JB\u0010 \u001a\u00020\u00062\u0006\u0010)\u001a\u00020\u001a2\u0006\u0010+\u001a\u00020*2!\u0010\u001f\u001a\u001d\u0012\u0013\u0012\u00110\u001d¢\u0006\f\b,\u0012\b\b-\u0012\u0004\b\b(.\u0012\u0004\u0012\u00020\u00060\u001cH\u0002¢\u0006\u0004\b \u0010/J/\u0010 \u001a\u00020\u0006*\u000e\u0012\u0004\u0012\u00020\u001d\u0012\u0004\u0012\u00020\u00060\u001c2\u0006\u0010)\u001a\u00020\u001a2\u0006\u0010+\u001a\u00020*H\u0002¢\u0006\u0004\b \u00100J'\u0010 \u001a\u00020\u0006*\u000e\u0012\u0004\u0012\u00020\u001d\u0012\u0004\u0012\u00020\u00060\u001c2\u0006\u0010)\u001a\u00020\u001aH\u0002¢\u0006\u0004\b \u0010#J'\u0010 \u001a\u00020\u00062\u0006\u00102\u001a\u0002012\u0006\u00103\u001a\u00020*2\u0006\u0010\u001f\u001a\u000204H\u0002¢\u0006\u0004\b \u00105J/\u0010 \u001a\u00020\u00062\u0006\u0010-\u001a\u0002062\u0006\u0010\u0005\u001a\u00020\u00032\u0006\u00107\u001a\u00020\u00032\u0006\u00108\u001a\u00020\u0003H\u0002¢\u0006\u0004\b \u00109J\u0017\u0010 \u001a\u00020:2\u0006\u0010\u001b\u001a\u00020\u001aH\u0002¢\u0006\u0004\b \u0010;R\u0017\u0010@\u001a\u00020<8\u0006¢\u0006\f\n\u0004\b \u0010=\u001a\u0004\b>\u0010?R\u0017\u00102\u001a\u0002018\u0006¢\u0006\f\n\u0004\b$\u0010A\u001a\u0004\bB\u0010CR\u0014\u0010F\u001a\u00020D8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\"\u0010ER \u0010J\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020G0\u001c8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bH\u0010IR\u001a\u0010N\u001a\b\u0012\u0004\u0012\u00020L0K8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b'\u0010M¨\u0006R"}, d2 = {"Lcom/chartboost/sdk/impl/c8;", "Lcom/chartboost/sdk/impl/l;", "Lcom/chartboost/sdk/impl/m4;", "", "type", "location", "", "clear", "(Ljava/lang/String;Ljava/lang/String;)V", "Lcom/chartboost/sdk/impl/ka;", "event", "clearFromStorage", "(Lcom/chartboost/sdk/impl/ka;)V", "persist", "Lcom/chartboost/sdk/impl/ia;", DTBMetricsConfiguration.CONFIG_DIR, ToolBar.REFRESH, "(Lcom/chartboost/sdk/impl/ia;)V", "Lcom/chartboost/sdk/impl/da;", Reporting.Key.CLICK_SOURCE_TYPE_AD, com.ironsource.b9.h.U, "(Lcom/chartboost/sdk/impl/da;)V", "track", "(Lcom/chartboost/sdk/impl/ka;)Lcom/chartboost/sdk/impl/ka;", "(Lcom/chartboost/sdk/impl/ia;)Lcom/chartboost/sdk/impl/ia;", "(Lcom/chartboost/sdk/impl/da;)Lcom/chartboost/sdk/impl/da;", "Lcom/chartboost/sdk/impl/z6;", "params", "Lkotlin/Function1;", "Lcom/chartboost/sdk/impl/a7;", "Lkotlin/ExtensionFunctionType;", "callback", "a", "(Lcom/chartboost/sdk/impl/z6;Lkotlin/jvm/functions/Function1;)V", ApsMetricsDataMap.APSMETRICS_FIELD_CUSTOM, "(Lkotlin/jvm/functions/Function1;Lcom/chartboost/sdk/impl/z6;)V", DownloadCommon.DOWNLOAD_REPORT_FIND_FILE_RESULT_VALUE_B, "Ljava/lang/Exception;", "Lkotlin/Exception;", "e", "(Lkotlin/jvm/functions/Function1;Lcom/chartboost/sdk/impl/z6;Ljava/lang/Exception;)V", "loaderParams", "Lcom/chartboost/sdk/impl/v;", "openRTBAdUnit", "Lkotlin/ParameterName;", "name", "result", "(Lcom/chartboost/sdk/impl/z6;Lcom/chartboost/sdk/impl/v;Lkotlin/jvm/functions/Function1;)V", "(Lkotlin/jvm/functions/Function1;Lcom/chartboost/sdk/impl/z6;Lcom/chartboost/sdk/impl/v;)V", "Lcom/chartboost/sdk/impl/g4;", "downloader", "openRTB", "Lcom/chartboost/sdk/impl/d1;", "(Lcom/chartboost/sdk/impl/g4;Lcom/chartboost/sdk/impl/v;Lcom/chartboost/sdk/impl/d1;)V", "Lcom/chartboost/sdk/impl/ma;", "bidResponse", "error", "(Lcom/chartboost/sdk/impl/ma;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "", "(Lcom/chartboost/sdk/impl/z6;)Z", "Lcom/chartboost/sdk/impl/u;", "Lcom/chartboost/sdk/impl/u;", "getAdType", "()Lcom/chartboost/sdk/impl/u;", Ad.AD_TYPE, "Lcom/chartboost/sdk/impl/g4;", "getDownloader", "()Lcom/chartboost/sdk/impl/g4;", "Lcom/chartboost/sdk/impl/x7;", "Lcom/chartboost/sdk/impl/x7;", "openRTBAdUnitParser", "Lorg/json/JSONObject;", "d", "Lkotlin/jvm/functions/Function1;", "jsonFactory", "Lkotlin/Function0;", "", "Lkotlin/jvm/functions/Function0;", "androidVersion", "eventTracker", "<init>", "(Lcom/chartboost/sdk/impl/u;Lcom/chartboost/sdk/impl/g4;Lcom/chartboost/sdk/impl/x7;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function0;Lcom/chartboost/sdk/impl/m4;)V", "ChartboostMonetization-9.8.3_productionRelease"}, k = 1, mv = {1, 8, 0})
public final class c8 implements l, m4 {

    /* JADX INFO: renamed from: a, reason: collision with root package name and from kotlin metadata */
    public final u adType;

    /* JADX INFO: renamed from: b, reason: from kotlin metadata */
    public final g4 downloader;

    /* JADX INFO: renamed from: c, reason: from kotlin metadata */
    public final x7 openRTBAdUnitParser;

    /* JADX INFO: renamed from: d, reason: from kotlin metadata */
    public final Function1<String, JSONObject> jsonFactory;

    /* JADX INFO: renamed from: e, reason: from kotlin metadata */
    public final Function0<Integer> androidVersion;
    public final /* synthetic */ m4 f;

    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    public /* synthetic */ class a extends FunctionReferenceImpl implements Function1<String, JSONObject> {
        public static final a b = new a();

        public a() {
            super(1, JSONObject.class, "<init>", "<init>(Ljava/lang/String;)V", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final JSONObject invoke(String str) {
            return new JSONObject(str);
        }
    }

    @Metadata(d1 = {"\u0000\b\n\u0002\u0010\b\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "a", "()Ljava/lang/Integer;"}, k = 3, mv = {1, 8, 0})
    public static final class b extends Lambda implements Function0<Integer> {
        public static final b b = new b();

        public b() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Integer invoke() {
            return Integer.valueOf(Build.VERSION.SDK_INT);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public c8(u adType, g4 downloader, x7 openRTBAdUnitParser, Function1<? super String, ? extends JSONObject> jsonFactory, Function0<Integer> androidVersion, m4 eventTracker) {
        Intrinsics.checkNotNullParameter(adType, "adType");
        Intrinsics.checkNotNullParameter(downloader, "downloader");
        Intrinsics.checkNotNullParameter(openRTBAdUnitParser, "openRTBAdUnitParser");
        Intrinsics.checkNotNullParameter(jsonFactory, "jsonFactory");
        Intrinsics.checkNotNullParameter(androidVersion, "androidVersion");
        Intrinsics.checkNotNullParameter(eventTracker, "eventTracker");
        this.adType = adType;
        this.downloader = downloader;
        this.openRTBAdUnitParser = openRTBAdUnitParser;
        this.jsonFactory = jsonFactory;
        this.androidVersion = androidVersion;
        this.f = eventTracker;
    }

    @Override // com.chartboost.sdk.impl.l4
    public void clear(String type, String location) {
        Intrinsics.checkNotNullParameter(type, "type");
        Intrinsics.checkNotNullParameter(location, "location");
        this.f.clear(type, location);
    }

    @Override // com.chartboost.sdk.impl.m4
    public ka clearFromStorage(ka kaVar) {
        Intrinsics.checkNotNullParameter(kaVar, "<this>");
        return this.f.clearFromStorage(kaVar);
    }

    @Override // com.chartboost.sdk.impl.m4
    public ka persist(ka kaVar) {
        Intrinsics.checkNotNullParameter(kaVar, "<this>");
        return this.f.persist(kaVar);
    }

    @Override // com.chartboost.sdk.impl.m4
    public ia refresh(ia iaVar) {
        Intrinsics.checkNotNullParameter(iaVar, "<this>");
        return this.f.refresh(iaVar);
    }

    @Override // com.chartboost.sdk.impl.m4
    public da store(da daVar) {
        Intrinsics.checkNotNullParameter(daVar, "<this>");
        return this.f.store(daVar);
    }

    @Override // com.chartboost.sdk.impl.m4
    public ka track(ka kaVar) {
        Intrinsics.checkNotNullParameter(kaVar, "<this>");
        return this.f.track(kaVar);
    }

    @Override // com.chartboost.sdk.impl.l4
    /* JADX INFO: renamed from: clearFromStorage */
    public void mo4737clearFromStorage(ka event) {
        Intrinsics.checkNotNullParameter(event, "event");
        this.f.mo4737clearFromStorage(event);
    }

    @Override // com.chartboost.sdk.impl.l4
    /* JADX INFO: renamed from: persist */
    public void mo4738persist(ka event) {
        Intrinsics.checkNotNullParameter(event, "event");
        this.f.mo4738persist(event);
    }

    @Override // com.chartboost.sdk.impl.l4
    /* JADX INFO: renamed from: refresh */
    public void mo4739refresh(ia config) {
        Intrinsics.checkNotNullParameter(config, "config");
        this.f.mo4739refresh(config);
    }

    @Override // com.chartboost.sdk.impl.l4
    /* JADX INFO: renamed from: store */
    public void mo4740store(da ad) {
        Intrinsics.checkNotNullParameter(ad, "ad");
        this.f.mo4740store(ad);
    }

    @Override // com.chartboost.sdk.impl.l4
    /* JADX INFO: renamed from: track */
    public void mo4741track(ka event) {
        Intrinsics.checkNotNullParameter(event, "event");
        this.f.mo4741track(event);
    }

    public /* synthetic */ c8(u uVar, g4 g4Var, x7 x7Var, Function1 function1, Function0 function0, m4 m4Var, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(uVar, g4Var, x7Var, (i & 8) != 0 ? a.b : function1, (i & 16) != 0 ? b.b : function0, m4Var);
    }

    public final void c(Function1<? super a7, Unit> function1, z6 z6Var) {
        function1.invoke(new a7(z6Var.getAppRequest(), null, new CBError(CBError.c.UNSUPPORTED_OS_VERSION, "Unsupported Android version " + Build.VERSION.SDK_INT), 0L, 0L, 26, null));
    }

    public final void b(Function1<? super a7, Unit> function1, z6 z6Var) {
        ma.a aVar = ma.a.BID_RESPONSE_PARSING_ERROR;
        String location = z6Var.getAppRequest().getLocation();
        String bidResponse = z6Var.getAppRequest().getBidResponse();
        if (bidResponse == null) {
            bidResponse = "";
        }
        a(aVar, location, bidResponse, "Invalid bid response");
        function1.invoke(new a7(z6Var.getAppRequest(), null, new CBError(CBError.c.UNEXPECTED_RESPONSE, "Error parsing response"), 0L, 0L, 26, null));
    }

    public final void a(g4 downloader, v openRTB, d1 callback) {
        Map<String, c1> mapD = openRTB.d();
        AtomicInteger atomicInteger = new AtomicInteger();
        downloader.c();
        downloader.a(k8.HIGH, mapD, atomicInteger, callback, this.adType.getName());
    }

    public String a(JSONObject jSONObject, String str, String str2) {
        return l.a.a(this, jSONObject, str, str2);
    }

    public final boolean a(z6 params) {
        String bidResponse;
        return params.getAppRequest().getLocation().length() > 0 && (bidResponse = params.getAppRequest().getBidResponse()) != null && bidResponse.length() > 0;
    }

    @Override // com.chartboost.sdk.impl.l
    public void a(z6 params, Function1<? super a7, Unit> callback) {
        Intrinsics.checkNotNullParameter(params, "params");
        Intrinsics.checkNotNullParameter(callback, "callback");
        if (this.androidVersion.invoke().intValue() < 21) {
            c(callback, params);
            return;
        }
        if (!a(params)) {
            b(callback, params);
            return;
        }
        try {
            String bidResponse = params.getAppRequest().getBidResponse();
            a(params, this.openRTBAdUnitParser.a(this.adType, bidResponse != null ? this.jsonFactory.invoke(bidResponse) : null), callback);
        } catch (JSONException e) {
            a(callback, params, e);
        }
    }

    public final void a(Function1<? super a7, Unit> function1, z6 z6Var) {
        ma.a aVar = ma.a.ASSET_DOWNLOAD_ERROR;
        String location = z6Var.getAppRequest().getLocation();
        String bidResponse = z6Var.getAppRequest().getBidResponse();
        if (bidResponse == null) {
            bidResponse = "";
        }
        a(aVar, location, bidResponse, "ASSETS_DOWNLOAD_FAILURE");
        function1.invoke(new a7(z6Var.getAppRequest(), null, new CBError(CBError.c.INVALID_RESPONSE, "Error parsing response"), 0L, 0L, 26, null));
    }

    public final void a(Function1<? super a7, Unit> function1, z6 z6Var, Exception exc) {
        ma.a aVar = ma.a.BID_RESPONSE_PARSING_ERROR;
        String location = z6Var.getAppRequest().getLocation();
        String bidResponse = z6Var.getAppRequest().getBidResponse();
        if (bidResponse == null) {
            bidResponse = "";
        }
        a(aVar, location, bidResponse, exc.toString());
        function1.invoke(new a7(z6Var.getAppRequest(), null, new CBError(CBError.c.INVALID_RESPONSE, "Error parsing response"), 0L, 0L, 26, null));
    }

    public final void a(Function1<? super a7, Unit> function1, z6 z6Var, v vVar) {
        function1.invoke(new a7(z6Var.getAppRequest(), vVar, null, 0L, 0L, 24, null));
    }

    public final void a(final z6 loaderParams, final v openRTBAdUnit, final Function1<? super a7, Unit> callback) {
        a(this.downloader, openRTBAdUnit, new d1() { // from class: com.chartboost.sdk.impl.c8$$ExternalSyntheticLambda0
            @Override // com.chartboost.sdk.impl.d1
            public final void a(boolean z) {
                c8.a(this.f$0, callback, loaderParams, openRTBAdUnit, z);
            }
        });
    }

    public static final void a(c8 this$0, Function1 callback, z6 loaderParams, v openRTBAdUnit, boolean z) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(callback, "$callback");
        Intrinsics.checkNotNullParameter(loaderParams, "$loaderParams");
        Intrinsics.checkNotNullParameter(openRTBAdUnit, "$openRTBAdUnit");
        if (z) {
            this$0.a((Function1<? super a7, Unit>) callback, loaderParams, openRTBAdUnit);
        } else {
            this$0.a((Function1<? super a7, Unit>) callback, loaderParams);
        }
    }

    public final void a(ma name, String location, String bidResponse, String error) {
        track((ka) new r3(name, a(new JSONObject(), error, bidResponse), this.adType.getName(), location, null, null, 48, null));
    }
}
