package com.applovin.impl.mediation;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.Log;
import android.view.ViewGroup;
import androidx.lifecycle.Lifecycle;
import com.amazon.aps.shared.util.APSSharedUtil;
import com.applovin.impl.a5;
import com.applovin.impl.b5;
import com.applovin.impl.b6;
import com.applovin.impl.c2;
import com.applovin.impl.e2;
import com.applovin.impl.e3;
import com.applovin.impl.g5;
import com.applovin.impl.g6;
import com.applovin.impl.h3;
import com.applovin.impl.i;
import com.applovin.impl.k7;
import com.applovin.impl.l6;
import com.applovin.impl.o3;
import com.applovin.impl.p3;
import com.applovin.impl.q2;
import com.applovin.impl.q3;
import com.applovin.impl.q4;
import com.applovin.impl.r6;
import com.applovin.impl.sdk.AppLovinBroadcastManager;
import com.applovin.impl.sdk.k;
import com.applovin.impl.sdk.n;
import com.applovin.impl.sdk.o;
import com.applovin.impl.sdk.utils.CollectionUtils;
import com.applovin.impl.sdk.utils.JsonUtils;
import com.applovin.impl.sdk.utils.StringUtils;
import com.applovin.impl.t3;
import com.applovin.impl.v2;
import com.applovin.impl.v4;
import com.applovin.impl.x2;
import com.applovin.impl.x4;
import com.applovin.impl.z2;
import com.applovin.impl.z4;
import com.applovin.impl.z5;
import com.applovin.mediation.MaxAd;
import com.applovin.mediation.MaxAdFormat;
import com.applovin.mediation.MaxAdListener;
import com.applovin.mediation.MaxAdRequestListener;
import com.applovin.mediation.MaxAdRevenueListener;
import com.applovin.mediation.MaxAdViewAdListener;
import com.applovin.mediation.MaxError;
import com.applovin.mediation.MaxMediatedNetworkInfo;
import com.applovin.mediation.MaxNetworkResponseInfo;
import com.applovin.mediation.MaxReward;
import com.applovin.mediation.MaxRewardedAdListener;
import com.applovin.mediation.adapter.MaxAdapter;
import com.applovin.mediation.adapter.MaxAdapterError;
import com.applovin.sdk.AppLovinSdkUtils;
import com.safedk.android.analytics.events.BrandSafetyEvent;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicReference;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes9.dex */
public class MediationServiceImpl implements AppLovinBroadcastManager.Receiver {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final k f520a;
    private final o b;
    private final z4 c;
    private final AtomicReference d = new AtomicReference();

    static /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f521a;

        static {
            int[] iArr = new int[MaxAdapter.InitializationStatus.values().length];
            f521a = iArr;
            try {
                iArr[MaxAdapter.InitializationStatus.DOES_NOT_APPLY.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f521a[MaxAdapter.InitializationStatus.INITIALIZED_SUCCESS.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f521a[MaxAdapter.InitializationStatus.INITIALIZED_UNKNOWN.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f521a[MaxAdapter.InitializationStatus.INITIALIZED_FAILURE.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f521a[MaxAdapter.InitializationStatus.NOT_INITIALIZED.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f521a[MaxAdapter.InitializationStatus.INITIALIZING.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
        }
    }

    public class b implements MaxAdListener, MaxRewardedAdListener, MaxAdViewAdListener, MaxAdRevenueListener, com.applovin.impl.mediation.ads.a.InterfaceC0135a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final v2 f522a;
        private com.applovin.impl.mediation.ads.a.InterfaceC0135a b;

        public b(v2 v2Var, com.applovin.impl.mediation.ads.a.InterfaceC0135a interfaceC0135a) {
            this.f522a = v2Var;
            this.b = interfaceC0135a;
        }

        public void a(com.applovin.impl.mediation.ads.a.InterfaceC0135a interfaceC0135a) {
            this.b = interfaceC0135a;
        }

        public void b(MaxAd maxAd, Bundle bundle) {
            this.f522a.a(bundle);
            q2.b(this.b, maxAd);
        }

        public void c(MaxAd maxAd, Bundle bundle) {
            this.f522a.a(bundle);
            o unused = MediationServiceImpl.this.b;
            if (o.a()) {
                MediationServiceImpl.this.b.a("MediationService", "Scheduling impression for ad via callback...");
            }
            MediationServiceImpl.this.processCallbackAdImpressionPostback(this.f522a, this.b);
            if (!((Boolean) MediationServiceImpl.this.f520a.a(o3.m8)).booleanValue() || this.f522a.u().compareAndSet(false, true)) {
                MediationServiceImpl.this.f520a.l().a(this.f522a, com.applovin.impl.sdk.g.c.SHOW);
                MediationServiceImpl.this.f520a.u().b(this.f522a, "DID_DISPLAY");
                MediationServiceImpl.this.f520a.p().maybeSendAdEvent(this.f522a, "DID_DISPLAY");
                if (maxAd.getFormat().isFullscreenAd()) {
                    MediationServiceImpl.this.f520a.I().a(this.f522a);
                }
                q2.c(this.b, maxAd);
            }
        }

        public void d(MaxAd maxAd, Bundle bundle) {
            this.f522a.a(bundle);
            q2.d(this.b, maxAd);
        }

        public void e(final MaxAd maxAd, Bundle bundle) {
            this.f522a.a(bundle);
            MediationServiceImpl.this.f520a.l().a(this.f522a, com.applovin.impl.sdk.g.c.HIDE);
            MediationServiceImpl.this.a(this.f522a);
            AppLovinSdkUtils.runOnUiThreadDelayed(new Runnable() { // from class: com.applovin.impl.mediation.MediationServiceImpl$b$$ExternalSyntheticLambda0
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.a(maxAd);
                }
            }, maxAd instanceof z2 ? ((z2) maxAd).f0() : 0L);
        }

        public void f(MaxAd maxAd, Bundle bundle) {
            this.f522a.a(bundle);
            this.f522a.Y();
            MediationServiceImpl.this.f520a.l().a(this.f522a, com.applovin.impl.sdk.g.c.LOAD);
            MediationServiceImpl.this.b(this.f522a);
            q2.f(this.b, maxAd);
        }

        @Override // com.applovin.mediation.MaxAdListener
        public void onAdClicked(MaxAd maxAd) {
            a(maxAd, null);
        }

        @Override // com.applovin.mediation.MaxAdViewAdListener
        public void onAdCollapsed(MaxAd maxAd) {
            b(maxAd, null);
        }

        @Override // com.applovin.mediation.MaxAdListener
        public void onAdDisplayFailed(MaxAd maxAd, MaxError maxError) {
            a(maxAd, maxError, (Bundle) null);
        }

        @Override // com.applovin.mediation.MaxAdListener
        public void onAdDisplayed(MaxAd maxAd) {
            c(maxAd, null);
        }

        @Override // com.applovin.mediation.MaxAdViewAdListener
        public void onAdExpanded(MaxAd maxAd) {
            d(maxAd, null);
        }

        @Override // com.applovin.mediation.MaxAdListener
        public void onAdHidden(MaxAd maxAd) {
            e(maxAd, null);
        }

        @Override // com.applovin.mediation.MaxAdListener
        public void onAdLoadFailed(String str, MaxError maxError) {
            this.f522a.Y();
            MediationServiceImpl.this.b(this.f522a, maxError, this.b);
        }

        @Override // com.applovin.mediation.MaxAdListener
        public void onAdLoaded(MaxAd maxAd) {
            f(maxAd, null);
        }

        @Override // com.applovin.mediation.MaxAdRequestListener
        public void onAdRequestStarted(String str) {
        }

        @Override // com.applovin.mediation.MaxAdRevenueListener
        public void onAdRevenuePaid(MaxAd maxAd) {
        }

        @Override // com.applovin.mediation.MaxRewardedAdListener
        public void onUserRewarded(MaxAd maxAd, MaxReward maxReward) {
            a(maxAd, maxReward, (Bundle) null);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void a(MaxAd maxAd) {
            if (maxAd.getFormat().isFullscreenAd()) {
                MediationServiceImpl.this.f520a.I().b(maxAd);
            }
            q2.e(this.b, maxAd);
        }

        public void a(MaxAd maxAd, Bundle bundle) {
            this.f522a.a(bundle);
            MediationServiceImpl.this.f520a.l().a(this.f522a, com.applovin.impl.sdk.g.c.CLICK);
            MediationServiceImpl.this.a(this.f522a, this.b);
            q2.a((MaxAdListener) this.b, maxAd);
        }

        public void a(MaxAd maxAd, MaxError maxError, Bundle bundle) {
            this.f522a.a(bundle);
            MediationServiceImpl.this.a(this.f522a, maxError, this.b);
            if (maxAd.getFormat() == MaxAdFormat.REWARDED && (maxAd instanceof z2)) {
                ((z2) maxAd).d0();
            }
        }

        public void a(MaxAd maxAd, MaxReward maxReward, Bundle bundle) {
            this.f522a.a(bundle);
            q2.a(this.b, maxAd, maxReward);
            MediationServiceImpl.this.f520a.r0().a((g5) new l6((z2) maxAd, MediationServiceImpl.this.f520a), b6.b.OTHER);
        }
    }

    public MediationServiceImpl(k kVar) {
        this.f520a = kVar;
        this.b = kVar.O();
        this.c = new z4(kVar);
        AppLovinBroadcastManager.registerReceiver(this, new IntentFilter("com.applovin.render_process_gone"));
    }

    public void collectSignal(final b5 b5Var, Context context, final a5.a aVar) {
        if (b5Var == null) {
            throw new IllegalArgumentException("No spec specified");
        }
        if (context == null) {
            throw new IllegalArgumentException("No context specified");
        }
        if (aVar == null) {
            throw new IllegalArgumentException("No callback specified");
        }
        x2 x2VarU = b5Var.u();
        final String strB = x2VarU.b();
        final MaxAdFormat maxAdFormatA = x2VarU.a();
        a5 a5VarB = this.c.b(b5Var, strB, maxAdFormatA);
        if (a5VarB != null) {
            aVar.a(a5.a(a5VarB));
            return;
        }
        final h hVarA = this.f520a.T().a(b5Var, b5Var.A());
        if (hVarA == null) {
            aVar.a(a5.a(b5Var, new MaxErrorImpl("Could not load adapter")));
            return;
        }
        final q4 q4Var = new q4("SignalCollection:" + b5Var.c());
        final long jElapsedRealtime = SystemClock.elapsedRealtime();
        Executor executor = q4.i;
        q4Var.a(executor, new q4.b() { // from class: com.applovin.impl.mediation.MediationServiceImpl$$ExternalSyntheticLambda1
            @Override // com.applovin.impl.q4.b
            public final void a(boolean z, Object obj, Object obj2) {
                this.f$0.a(jElapsedRealtime, hVarA, strB, b5Var, maxAdFormatA, aVar, z, (String) obj, (MaxError) obj2);
            }
        });
        g6.a(b5Var.m(), q4Var, new MaxErrorImpl(MaxAdapterError.ERROR_CODE_SIGNAL_COLLECTION_TIMEOUT, "The adapter (" + b5Var.c() + ") timed out collecting signal"), "MediationService", this.f520a);
        final Activity activityV0 = context instanceof Activity ? (Activity) context : this.f520a.v0();
        final MaxAdapterParametersImpl maxAdapterParametersImplA = MaxAdapterParametersImpl.a(b5Var, strB, maxAdFormatA);
        if (b5Var.w()) {
            q4 q4VarA = this.f520a.S().a(b5Var, activityV0);
            q4VarA.a(executor, new Runnable() { // from class: com.applovin.impl.mediation.MediationServiceImpl$$ExternalSyntheticLambda2
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.a(q4Var, hVarA, maxAdapterParametersImplA, b5Var, activityV0);
                }
            });
            q4VarA.a(executor, new q4.a() { // from class: com.applovin.impl.mediation.MediationServiceImpl$$ExternalSyntheticLambda3
                @Override // com.applovin.impl.q4.a
                public final void a(Object obj) {
                    this.f$0.a(hVarA, q4Var, (String) obj);
                }
            });
            return;
        }
        if (b5Var.x()) {
            q4 q4VarA2 = this.f520a.S().a(b5Var, activityV0);
            if (q4VarA2.d() && !b5Var.z()) {
                if (o.a()) {
                    this.b.b("MediationService", "Skip collecting signal for failed-initialized adapter: " + hVarA.g());
                }
                q4Var.a(new MaxErrorImpl("Could not initialize adapter: " + ((String) q4VarA2.a())));
                return;
            }
        }
        if (o.a()) {
            this.b.a("MediationService", "Collecting signal for adapter: " + hVarA.g());
        }
        hVarA.a(maxAdapterParametersImplA, b5Var, activityV0, q4Var);
    }

    public void destroyAd(MaxAd maxAd) {
        if (maxAd instanceof v2) {
            if (o.a()) {
                this.b.d("MediationService", "Destroying " + maxAd);
            }
            v2 v2Var = (v2) maxAd;
            h hVarA = v2Var.A();
            if (hVarA != null) {
                hVarA.a();
                v2Var.t();
            }
            this.f520a.j().c(v2Var.P());
            this.f520a.l().a(v2Var, com.applovin.impl.sdk.g.c.DESTROY);
        }
    }

    public JSONObject getAndResetCustomPostBodyData() {
        return (JSONObject) this.d.getAndSet(null);
    }

    public void loadAd(String str, String str2, MaxAdFormat maxAdFormat, i iVar, Map<String, Object> map, Map<String, Object> map2, Context context, com.applovin.impl.mediation.ads.a.InterfaceC0135a interfaceC0135a) {
        if (TextUtils.isEmpty(str)) {
            throw new IllegalArgumentException("No Ad Unit ID specified");
        }
        if (context == null) {
            throw new IllegalArgumentException("No context specified");
        }
        if (interfaceC0135a == null) {
            throw new IllegalArgumentException("No listener specified");
        }
        if (TextUtils.isEmpty(this.f520a.V())) {
            o.h("AppLovinSdk", "Mediation provider is null. Please set the mediation provider in the AppLovinSdkInitializationConfiguration.Builder when initializing the AppLovinSDK.");
        }
        if (!this.f520a.C0()) {
            o.j("AppLovinSdk", "Attempted to load ad before SDK initialization. Please wait until after the SDK has initialized, e.g. AppLovinSdk.initializeSdk(Context, SdkInitializationListener).");
        }
        List<String> adUnitIds = this.f520a.K() != null ? this.f520a.K().getAdUnitIds() : null;
        boolean zStartsWith = str.startsWith("test_mode");
        if (adUnitIds != null && adUnitIds.size() > 0 && !adUnitIds.contains(str) && !zStartsWith) {
            if (k7.c(this.f520a)) {
                String str3 = "Ad Unit ID " + str + " has not been initialized. When you use selective init, any ad units that you do not explicitly specify are excluded from serving ads for the current session. For more information visit our docs: https://developers.applovin.com/en/max/android/overview/advanced-settings#selective-init";
                if (((Boolean) this.f520a.a(v4.p6)).booleanValue()) {
                    throw new RuntimeException(str3);
                }
                if (o.a()) {
                    this.b.b("MediationService", str3);
                }
            }
            this.f520a.E().a(c2.E0, "uninitialized_ad_unit_id", CollectionUtils.hashMap("ad_unit_id", str), "uninitialized_ad_unit_id" + str);
        }
        this.f520a.c();
        if (str.length() != 16 && !zStartsWith && !this.f520a.j0().startsWith("05TMD")) {
            o.h("MediationService", "Ad unit ID provided for " + maxAdFormat.getLabel() + " is invalid (" + str + "). Expected length: 16 characters.\n\nStack trace:\n" + Log.getStackTraceString(new Throwable()));
        }
        if (this.f520a.a(maxAdFormat)) {
            o.h("MediationService", "Ad load failed due to disabled ad format " + maxAdFormat.getLabel());
            q2.a(interfaceC0135a, str, new MaxErrorImpl(-1, "Disabled ad format " + maxAdFormat.getLabel()));
            return;
        }
        this.f520a.W0();
        q2.a((MaxAdRequestListener) interfaceC0135a, str, true);
        if (this.f520a.R() != null) {
            this.f520a.R().a(str, str2, maxAdFormat, iVar, map, map2, context, interfaceC0135a);
        } else {
            this.f520a.Q().a(str, str2, maxAdFormat, iVar, map, map2, context, interfaceC0135a);
        }
    }

    public void loadThirdPartyMediatedAd(final String str, final v2 v2Var, final Activity activity, final com.applovin.impl.mediation.ads.a.InterfaceC0135a interfaceC0135a) {
        q4 q4VarA;
        if (v2Var == null) {
            throw new IllegalArgumentException("No mediated ad specified");
        }
        if (o.a()) {
            this.b.a("MediationService", "Loading " + v2Var + APSSharedUtil.TRUNCATE_SEPARATOR);
        }
        this.f520a.P().a(c2.W, v2Var);
        this.f520a.l().a(v2Var, com.applovin.impl.sdk.g.c.LOADING);
        this.f520a.u().b(v2Var, "WILL_LOAD");
        this.f520a.p().maybeSendAdEvent(v2Var, "WILL_LOAD");
        final h hVarA = this.f520a.T().a(v2Var);
        if (hVarA == null) {
            String str2 = "Failed to load " + v2Var + ": adapter not loaded";
            o.h("MediationService", str2);
            b(v2Var, new MaxErrorImpl(-5001, str2), interfaceC0135a);
            return;
        }
        final MaxAdapterParametersImpl maxAdapterParametersImplA = MaxAdapterParametersImpl.a(v2Var);
        if (v2Var.W()) {
            q4VarA = this.f520a.S().a(v2Var, activity);
        } else {
            if (v2Var.X()) {
                this.f520a.S().a(v2Var, activity);
            }
            q4VarA = null;
        }
        q4 q4Var = q4VarA;
        final v2 v2VarA = v2Var.a(hVarA);
        hVarA.a(str, v2VarA);
        v2VarA.Z();
        if (q4Var == null) {
            hVarA.a(str, maxAdapterParametersImplA, v2VarA, activity, new b(v2VarA, interfaceC0135a));
            return;
        }
        Executor executor = q4.i;
        q4Var.a(executor, new q4.a() { // from class: com.applovin.impl.mediation.MediationServiceImpl$$ExternalSyntheticLambda4
            @Override // com.applovin.impl.q4.a
            public final void a(Object obj) {
                this.f$0.a(v2Var, interfaceC0135a, (String) obj);
            }
        });
        q4Var.a(executor, new Runnable() { // from class: com.applovin.impl.mediation.MediationServiceImpl$$ExternalSyntheticLambda5
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.a(hVarA, str, maxAdapterParametersImplA, v2VarA, activity, interfaceC0135a);
            }
        });
    }

    public void maybeFireAppKilledWhilePlayingMediatedAdPostback() {
        String str = (String) this.f520a.b(x4.Q);
        if (TextUtils.isEmpty(str)) {
            return;
        }
        JSONObject jSONObjectJsonObjectFromJsonString = JsonUtils.jsonObjectFromJsonString(str, new JSONObject());
        if (a(JsonUtils.getLong(jSONObjectJsonObjectFromJsonString, "timestamp_ms", 0L))) {
            Long l = (Long) this.f520a.b(x4.R);
            String string = l != null ? l.toString() : "";
            JSONObject jSONObject = JsonUtils.getJSONObject(jSONObjectJsonObjectFromJsonString, "ad_info");
            Map mapTryToStringMap = jSONObject != null ? JsonUtils.tryToStringMap(jSONObject) : new HashMap(1);
            CollectionUtils.putStringIfValid("duration_ms", string, mapTryToStringMap);
            this.f520a.E().d(c2.u0, mapTryToStringMap);
            List list = JsonUtils.getList(jSONObjectJsonObjectFromJsonString, "app_killed_urls", Collections.emptyList());
            if (CollectionUtils.isEmpty(list)) {
                if (o.a()) {
                    this.b.k("MediationService", "Unable to track app killed during mediated ad from previous run. Missing app killed tracking URLs.");
                }
            } else {
                JSONObject jSONObject2 = JsonUtils.getJSONObject(jSONObjectJsonObjectFromJsonString, "user_info");
                Map<String, String> mapTryToStringMap2 = jSONObject2 != null ? JsonUtils.tryToStringMap(jSONObject2) : t3.c(this.f520a);
                mapTryToStringMap2.put("{IMP_DURATION_MS}", string);
                a("mappk", list, mapTryToStringMap2, null, null, null, true);
            }
        }
    }

    @Override // com.applovin.impl.sdk.AppLovinBroadcastManager.Receiver
    public void onReceive(Intent intent, Map<String, Object> map) {
        if ("com.applovin.render_process_gone".equals(intent.getAction())) {
            Object objA = this.f520a.I().a();
            if (objA instanceof v2) {
                a((MaxError) MaxAdapterError.WEBVIEW_ERROR, (v2) objA, true);
            }
        }
    }

    public void processAdDisplayErrorPostbackForUserError(MaxError maxError, v2 v2Var) {
        a(maxError, v2Var, false);
    }

    public void processAdapterInitializationPostback(h3 h3Var, long j, MaxAdapter.InitializationStatus initializationStatus, String str) {
        HashMap map = new HashMap(2);
        map.put("{INIT_STATUS}", String.valueOf(initializationStatus.getCode()));
        map.put("{INIT_TIME_MS}", String.valueOf(j));
        a("minit", map, new MaxErrorImpl(str), h3Var);
        Map mapA = e2.a(h3Var);
        CollectionUtils.putStringIfValid("adapter_init_status", String.valueOf(initializationStatus.getCode()), mapA);
        CollectionUtils.putStringIfValid("error_message", str, mapA);
        CollectionUtils.putStringIfValid("duration_ms", String.valueOf(j), mapA);
        switch (a.f521a[initializationStatus.ordinal()]) {
            case 1:
            case 2:
            case 3:
                this.f520a.P().d(c2.P, mapA);
                break;
            case 4:
                this.f520a.P().d(c2.Q, mapA);
                break;
            case 5:
            case 6:
                this.f520a.O();
                if (o.a()) {
                    this.f520a.O().k("MediationService", "Adapter init postback called while the adapter is not fully initialized.");
                }
                this.f520a.E().a(c2.d, "adapterNotInitializedForPostback", mapA);
                break;
        }
    }

    public void processCallbackAdImpressionPostback(v2 v2Var, com.applovin.impl.mediation.ads.a.InterfaceC0135a interfaceC0135a) {
        if (v2Var.N().endsWith("cimp")) {
            this.f520a.u().b(v2Var);
            q2.a((MaxAdRevenueListener) interfaceC0135a, (MaxAd) v2Var);
        }
        HashMap map = new HashMap(2);
        if (v2Var instanceof z2) {
            map.put("{PREVIOUS_FAILED_NETWORK_NAME}", StringUtils.emptyIfNull(((z2) v2Var).o0()));
        }
        String strEmptyIfNull = StringUtils.emptyIfNull(this.f520a.x0().e());
        if (!((Boolean) this.f520a.a(v4.E3)).booleanValue()) {
            strEmptyIfNull = "";
        }
        map.put("{CUID}", strEmptyIfNull);
        a("mcimp", map, v2Var);
        this.f520a.P().a(c2.b0, v2Var);
    }

    public void processRawAdImpression(v2 v2Var, com.applovin.impl.mediation.ads.a.InterfaceC0135a interfaceC0135a) {
        this.f520a.u().b(v2Var, "WILL_DISPLAY");
        this.f520a.p().maybeSendAdEvent(v2Var, "WILL_DISPLAY");
        if (v2Var.N().endsWith("mimp")) {
            this.f520a.u().b(v2Var);
            q2.a((MaxAdRevenueListener) interfaceC0135a, (MaxAd) v2Var);
        }
        if (((Boolean) this.f520a.a(v4.C4)).booleanValue()) {
            this.f520a.Y().a(p3.g, q3.a(v2Var), Long.valueOf(System.currentTimeMillis() - this.f520a.L()));
        }
        HashMap map = new HashMap(3);
        if (v2Var instanceof z2) {
            z2 z2Var = (z2) v2Var;
            map.put("{TIME_TO_SHOW_MS}", String.valueOf(z2Var.j0()));
            map.put("{PREVIOUS_FAILED_NETWORK_NAME}", StringUtils.emptyIfNull(z2Var.o0()));
        }
        String strEmptyIfNull = StringUtils.emptyIfNull(this.f520a.x0().e());
        if (!((Boolean) this.f520a.a(v4.E3)).booleanValue()) {
            strEmptyIfNull = "";
        }
        map.put("{CUID}", strEmptyIfNull);
        a("mimp", map, v2Var);
        this.f520a.P().a(c2.a0, v2Var);
    }

    public void processViewabilityAdImpressionPostback(e3 e3Var, long j, com.applovin.impl.mediation.ads.a.InterfaceC0135a interfaceC0135a) {
        if (e3Var.N().endsWith("vimp")) {
            this.f520a.u().b(e3Var);
            q2.a((MaxAdRevenueListener) interfaceC0135a, (MaxAd) e3Var);
        }
        HashMap map = new HashMap(3);
        map.put("{VIEWABILITY_FLAGS}", String.valueOf(j));
        map.put("{USED_VIEWABILITY_TIMER}", String.valueOf(e3Var.k0()));
        String strEmptyIfNull = StringUtils.emptyIfNull(this.f520a.x0().e());
        if (!((Boolean) this.f520a.a(v4.E3)).booleanValue()) {
            strEmptyIfNull = "";
        }
        map.put("{CUID}", strEmptyIfNull);
        a("mvimp", map, e3Var);
        this.f520a.P().a(c2.c0, e3Var);
    }

    public void processWaterfallInfoPostback(MaxAdWaterfallInfoImpl maxAdWaterfallInfoImpl, MaxError maxError, long j, long j2) {
        x2 requestParameters = maxAdWaterfallInfoImpl.getRequestParameters();
        String strB = requestParameters.b();
        MaxAdFormat maxAdFormatA = requestParameters.a();
        HashMap map = new HashMap();
        CollectionUtils.putStringIfValid("ad_format", maxAdFormatA.getLabel(), map);
        CollectionUtils.putStringIfValid("ad_unit_id", strB, map);
        CollectionUtils.putStringIfValid("duration_ms", String.valueOf(j2), map);
        CollectionUtils.putStringIfValid("ad_event_id", maxAdWaterfallInfoImpl.getEventId(), map);
        if (maxError != null) {
            map.putAll(e2.a(maxError));
        }
        this.f520a.P().d(c2.Z, map);
        if (CollectionUtils.isEmpty(maxAdWaterfallInfoImpl.getPostbackUrls())) {
            return;
        }
        HashMap map2 = new HashMap(8);
        CollectionUtils.putStringIfValid("mcode", maxAdWaterfallInfoImpl.getMCode(), map2);
        CollectionUtils.putStringIfValid("ad_unit_id", strB, map2);
        CollectionUtils.putStringIfValid("ad_format", maxAdFormatA.getLabel(), map2);
        CollectionUtils.putStringIfValid("name", maxAdWaterfallInfoImpl.getName(), map2);
        CollectionUtils.putLongIfValid("request_latency_ms", Long.valueOf(j2), map2);
        CollectionUtils.putLongIfValid("request_start_timestamp_ms", Long.valueOf(j), map2);
        CollectionUtils.putLongIfValid("wf_latency_ms", Long.valueOf(maxAdWaterfallInfoImpl.getLatencyMillis()), map2);
        map2.put("arn_info", requestParameters.f().e());
        List<MaxNetworkResponseInfo> networkResponses = maxAdWaterfallInfoImpl.getNetworkResponses();
        ArrayList arrayList = new ArrayList(networkResponses.size());
        for (MaxNetworkResponseInfo maxNetworkResponseInfo : networkResponses) {
            MaxMediatedNetworkInfo mediatedNetwork = maxNetworkResponseInfo.getMediatedNetwork();
            HashMap map3 = new HashMap(5);
            CollectionUtils.putStringIfValid("bcode", ((MaxNetworkResponseInfoImpl) maxNetworkResponseInfo).getBCode(), map3);
            map3.put("name", mediatedNetwork.getName());
            CollectionUtils.putLongIfValid("latency_ms", Long.valueOf(maxNetworkResponseInfo.getLatencyMillis()), map3);
            map3.put("load_state", Integer.valueOf(maxNetworkResponseInfo.getAdLoadState().ordinal()));
            MaxErrorImpl maxErrorImpl = (MaxErrorImpl) maxNetworkResponseInfo.getError();
            if (maxErrorImpl != null) {
                HashMap map4 = new HashMap(4);
                map4.put("error_code", Integer.valueOf(maxErrorImpl.getCode()));
                map4.put("error_message", maxErrorImpl.getMessage());
                map4.put("third_party_sdk_error_code", Integer.valueOf(maxErrorImpl.getMediatedNetworkErrorCode()));
                map4.put("third_party_sdk_error_message", maxErrorImpl.getMediatedNetworkErrorMessage());
                map3.put("error_info", map4);
            }
            arrayList.add(map3);
        }
        map2.put("ads_info", arrayList);
        a("mwf_info", maxAdWaterfallInfoImpl.getPostbackUrls(), Collections.EMPTY_MAP, map2, null, null, false);
    }

    public void setCustomPostBodyData(JSONObject jSONObject) {
        this.d.set(jSONObject);
    }

    public void showFullscreenAd(final z2 z2Var, final Activity activity, final com.applovin.impl.mediation.ads.a.InterfaceC0135a interfaceC0135a) {
        if (z2Var == null) {
            throw new IllegalArgumentException("No ad specified");
        }
        if (activity == null && MaxAdFormat.APP_OPEN != z2Var.getFormat()) {
            throw new IllegalArgumentException("No activity specified");
        }
        this.f520a.I().a(true);
        final h hVarB = b(z2Var);
        long jL0 = z2Var.l0();
        if (o.a()) {
            this.b.d("MediationService", "Showing ad " + z2Var.getAdUnitId() + " with delay of " + jL0 + "ms...");
        }
        AppLovinSdkUtils.runOnUiThreadDelayed(new Runnable() { // from class: com.applovin.impl.mediation.MediationServiceImpl$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.a(z2Var, hVarB, activity, interfaceC0135a);
            }
        }, jL0);
    }

    private h b(z2 z2Var) {
        h hVarA = z2Var.A();
        if (hVarA != null) {
            return hVarA;
        }
        this.f520a.I().a(false);
        if (o.a()) {
            this.b.k("MediationService", "Failed to show " + z2Var + ": adapter not found");
        }
        o.h("MediationService", "There may be an integration problem with the adapter for Ad Unit ID '" + z2Var.getAdUnitId() + "'. Please check if you have a supported version of that SDK integrated into your project.");
        throw new IllegalStateException("Could not find adapter for provided ad");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a(z2 z2Var, h hVar, Activity activity, com.applovin.impl.mediation.ads.a.InterfaceC0135a interfaceC0135a) {
        a(z2Var);
        hVar.b(z2Var, activity);
        a(z2Var, interfaceC0135a);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a(z2 z2Var, h hVar, ViewGroup viewGroup, Lifecycle lifecycle, Activity activity, com.applovin.impl.mediation.ads.a.InterfaceC0135a interfaceC0135a) {
        a(z2Var);
        hVar.a(z2Var, viewGroup, lifecycle, activity);
        a(z2Var, interfaceC0135a);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(v2 v2Var, MaxError maxError, MaxAdListener maxAdListener) {
        a(maxError, v2Var);
        destroyAd(v2Var);
        q2.a(maxAdListener, v2Var.getAdUnitId(), maxError);
    }

    public void showFullscreenAd(final z2 z2Var, final ViewGroup viewGroup, final Lifecycle lifecycle, final Activity activity, final com.applovin.impl.mediation.ads.a.InterfaceC0135a interfaceC0135a) {
        if (z2Var == null) {
            throw new IllegalArgumentException("No ad specified");
        }
        if (activity != null) {
            this.f520a.I().a(true);
            final h hVarB = b(z2Var);
            long jL0 = z2Var.l0();
            if (o.a()) {
                this.b.d("MediationService", "Showing ad " + z2Var.getAdUnitId() + " with delay of " + jL0 + "ms...");
            }
            AppLovinSdkUtils.runOnUiThreadDelayed(new Runnable() { // from class: com.applovin.impl.mediation.MediationServiceImpl$$ExternalSyntheticLambda6
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.a(z2Var, hVarB, viewGroup, lifecycle, activity, interfaceC0135a);
                }
            }, jL0);
            return;
        }
        throw new IllegalArgumentException("No activity specified");
    }

    private void a(z2 z2Var) {
        if (z2Var.getFormat() == MaxAdFormat.REWARDED) {
            this.f520a.r0().a((g5) new r6(z2Var, this.f520a), b6.b.OTHER);
        }
    }

    private void a(z2 z2Var, com.applovin.impl.mediation.ads.a.InterfaceC0135a interfaceC0135a) {
        this.f520a.I().a(false);
        a(z2Var, (MaxAdListener) interfaceC0135a);
        if (o.a()) {
            this.b.a("MediationService", "Scheduling impression for ad manually...");
        }
        processRawAdImpression(z2Var, interfaceC0135a);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(v2 v2Var) {
        this.f520a.u().b(v2Var, "DID_LOAD");
        this.f520a.p().maybeSendAdEvent(v2Var, "DID_LOAD");
        if (v2Var.N().endsWith("load")) {
            this.f520a.u().b(v2Var);
        }
        HashMap map = new HashMap(3);
        long jG = v2Var.G();
        map.put("{LOAD_TIME_MS}", String.valueOf(jG));
        if (v2Var.getFormat().isFullscreenAd()) {
            n.a aVarB = this.f520a.I().b(v2Var.getAdUnitId());
            map.put("{SHOW_ATTEMPT_COUNT}", String.valueOf(aVarB.a()));
            map.put("{SHOW_ATTEMPT_TIMESTAMP_MS}", String.valueOf(aVarB.b()));
        }
        a("load", map, v2Var);
        Map mapA = e2.a(v2Var);
        mapA.put("duration_ms", String.valueOf(jG));
        this.f520a.P().d(c2.X, mapA);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a(v2 v2Var, com.applovin.impl.mediation.ads.a.InterfaceC0135a interfaceC0135a, String str) {
        String str2 = "Failed to load " + v2Var + ": adapter init failed with error: " + str;
        if (o.a()) {
            this.b.k("MediationService", str2);
        }
        b(v2Var, new MaxErrorImpl(MaxAdapterError.NOT_INITIALIZED.getErrorCode(), "Adapter initialization failed"), interfaceC0135a);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a(h hVar, String str, MaxAdapterParametersImpl maxAdapterParametersImpl, v2 v2Var, Activity activity, com.applovin.impl.mediation.ads.a.InterfaceC0135a interfaceC0135a) {
        hVar.a(str, maxAdapterParametersImpl, v2Var, activity, new b(v2Var, interfaceC0135a));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a(long j, h hVar, String str, b5 b5Var, MaxAdFormat maxAdFormat, a5.a aVar, boolean z, String str2, MaxError maxError) {
        a5 a5VarA;
        long jElapsedRealtime = SystemClock.elapsedRealtime() - j;
        if (z) {
            if (o.a()) {
                this.b.a("MediationService", "Signal collection successful from: " + hVar.g() + " for Ad Unit ID: " + str + " with signal: \"" + str2 + "\"");
            }
            a5VarA = a5.a(b5Var, hVar, str2, j, jElapsedRealtime);
            this.c.a(a5VarA, b5Var, str, maxAdFormat);
            HashMap map = new HashMap();
            CollectionUtils.putStringIfValid(BrandSafetyEvent.ad, b5Var.c(), map);
            CollectionUtils.putStringIfValid("adapter_class", b5Var.b(), map);
            CollectionUtils.putStringIfValid("adapter_version", hVar.b(), map);
            CollectionUtils.putStringIfValid("duration_ms", String.valueOf(jElapsedRealtime), map);
            CollectionUtils.putStringIfValid("ad_format", String.valueOf(maxAdFormat.getLabel()), map);
            CollectionUtils.putStringIfValid("ad_unit_id", str, map);
            this.f520a.P().d(c2.R, map);
        } else {
            if (o.a()) {
                this.b.b("MediationService", "Signal collection failed from: " + hVar.g() + " for Ad Unit ID: " + str + " with error message: \"" + maxError.getMessage() + "\"");
            }
            a5VarA = a5.a(b5Var, hVar, maxError, j, jElapsedRealtime);
            a(a5VarA, b5Var, hVar);
        }
        aVar.a(a5VarA);
        hVar.a();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a(q4 q4Var, h hVar, MaxAdapterParametersImpl maxAdapterParametersImpl, b5 b5Var, Activity activity) {
        if (q4Var.c()) {
            return;
        }
        if (o.a()) {
            this.b.a("MediationService", "Collecting signal for now-initialized adapter: " + hVar.g());
        }
        hVar.a(maxAdapterParametersImpl, b5Var, activity, q4Var);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a(h hVar, q4 q4Var, String str) {
        if (o.a()) {
            this.b.b("MediationService", "Skip collecting signal for failed-initialized adapter: " + hVar.g());
        }
        q4Var.a(new MaxErrorImpl(MaxAdapterError.ERROR_CODE_NOT_INITIALIZED, "Could not initialize adapter: " + str));
    }

    private void a(final z2 z2Var, final MaxAdListener maxAdListener) {
        final Long l = (Long) this.f520a.a(o3.L7);
        if (l.longValue() <= 0) {
            return;
        }
        AppLovinSdkUtils.runOnUiThreadDelayed(new Runnable() { // from class: com.applovin.impl.mediation.MediationServiceImpl$$ExternalSyntheticLambda7
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.a(z2Var, l, maxAdListener);
            }
        }, l.longValue());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a(z2 z2Var, Long l, MaxAdListener maxAdListener) {
        if (z2Var.u().get()) {
            return;
        }
        String str = "Ad (" + z2Var.k() + ") has not been displayed after " + l + "ms. Failing ad display...";
        o.h("MediationService", str);
        a(z2Var, new MaxErrorImpl(-1, str), maxAdListener);
        this.f520a.I().b(z2Var);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(v2 v2Var, MaxError maxError, MaxAdListener maxAdListener) {
        this.f520a.l().a(v2Var, com.applovin.impl.sdk.g.c.SHOW_ERROR);
        this.f520a.u().b(v2Var, "DID_FAIL_DISPLAY");
        this.f520a.p().maybeSendAdEvent(v2Var, "DID_FAIL_DISPLAY");
        a(maxError, v2Var, true);
        if (v2Var.u().compareAndSet(false, true)) {
            q2.a(maxAdListener, v2Var, maxError);
        }
    }

    private void a(MaxError maxError, v2 v2Var) {
        HashMap map = new HashMap(3);
        long jG = v2Var.G();
        map.put("{LOAD_TIME_MS}", String.valueOf(jG));
        if (v2Var.getFormat().isFullscreenAd()) {
            n.a aVarB = this.f520a.I().b(v2Var.getAdUnitId());
            map.put("{SHOW_ATTEMPT_COUNT}", String.valueOf(aVarB.a()));
            map.put("{SHOW_ATTEMPT_TIMESTAMP_MS}", String.valueOf(aVarB.b()));
        }
        a("mlerr", map, maxError, v2Var);
        Map mapA = e2.a(v2Var);
        mapA.putAll(e2.a(maxError));
        mapA.put("duration_ms", String.valueOf(jG));
        this.f520a.P().d(c2.Y, mapA);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(v2 v2Var) {
        this.f520a.u().b(v2Var, "DID_HIDE");
        this.f520a.p().maybeSendAdEvent(v2Var, "DID_HIDE");
        HashMap map = new HashMap(1);
        String strEmptyIfNull = StringUtils.emptyIfNull(this.f520a.x0().e());
        if (!((Boolean) this.f520a.a(v4.E3)).booleanValue()) {
            strEmptyIfNull = "";
        }
        map.put("{CUID}", strEmptyIfNull);
        a("mclose", map, v2Var);
        this.f520a.P().a(c2.e0, v2Var);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(v2 v2Var, com.applovin.impl.mediation.ads.a.InterfaceC0135a interfaceC0135a) {
        this.f520a.u().b(v2Var, "DID_CLICKED");
        this.f520a.u().b(v2Var, "DID_CLICK");
        this.f520a.p().maybeSendAdEvent(v2Var, "DID_CLICK");
        if (v2Var.N().endsWith("click")) {
            this.f520a.u().b(v2Var);
            q2.a((MaxAdRevenueListener) interfaceC0135a, (MaxAd) v2Var);
        }
        HashMap map = new HashMap(1);
        String strEmptyIfNull = StringUtils.emptyIfNull(this.f520a.x0().e());
        if (!((Boolean) this.f520a.a(v4.E3)).booleanValue()) {
            strEmptyIfNull = "";
        }
        map.put("{CUID}", strEmptyIfNull);
        a("mclick", map, v2Var);
    }

    private void a(MaxError maxError, v2 v2Var, boolean z) {
        HashMap map = new HashMap(1);
        if (v2Var instanceof z2) {
            map.put("{PREVIOUS_FAILED_NETWORK_NAME}", StringUtils.emptyIfNull(((z2) v2Var).o0()));
        }
        a("mierr", map, maxError, v2Var, z);
        if (!z || v2Var == null) {
            return;
        }
        this.f520a.P().a(c2.d0, v2Var, maxError);
    }

    private void a(a5 a5Var, b5 b5Var, h hVar) {
        long jB = a5Var.b();
        HashMap map = new HashMap(3);
        map.put("{LOAD_TIME_MS}", String.valueOf(jB));
        CollectionUtils.putStringIfValid("{ADAPTER_VERSION}", hVar.b(), map);
        CollectionUtils.putStringIfValid("{SDK_VERSION}", hVar.i(), map);
        a("serr", map, a5Var.c(), b5Var);
        Map mapA = e2.a(a5Var.c());
        CollectionUtils.putStringIfValid(BrandSafetyEvent.ad, b5Var.c(), mapA);
        CollectionUtils.putStringIfValid("adapter_class", b5Var.b(), mapA);
        CollectionUtils.putStringIfValid("adapter_version", hVar.b(), mapA);
        CollectionUtils.putStringIfValid("duration_ms", String.valueOf(jB), mapA);
        this.f520a.P().d(c2.S, mapA);
    }

    private void a(String str, Map map, h3 h3Var) {
        a(str, map, (MaxError) null, h3Var);
    }

    private void a(String str, Map map, MaxError maxError, h3 h3Var) {
        a(str, map, maxError, h3Var, true);
    }

    private void a(String str, Map map, MaxError maxError, h3 h3Var, boolean z) {
        String strEmptyIfNull;
        Map map2 = CollectionUtils.map(map);
        String strEmptyIfNull2 = "";
        map2.put("{PLACEMENT}", z ? StringUtils.emptyIfNull(h3Var.getPlacement()) : "");
        if (!z) {
            strEmptyIfNull = "";
        } else {
            strEmptyIfNull = StringUtils.emptyIfNull(h3Var.e());
        }
        map2.put("{CUSTOM_DATA}", strEmptyIfNull);
        if (h3Var instanceof v2) {
            v2 v2Var = (v2) h3Var;
            if (z) {
                strEmptyIfNull2 = StringUtils.emptyIfNull(v2Var.getCreativeId());
            }
            map2.put("{CREATIVE_ID}", strEmptyIfNull2);
        }
        a(str, null, map2, null, maxError, h3Var, z);
    }

    private void a(String str, List list, Map map, Map map2, MaxError maxError, h3 h3Var, boolean z) {
        this.f520a.r0().a((g5) new z5(str, list, map, map2, maxError, h3Var, this.f520a, z), b6.b.OTHER);
    }

    private boolean a(long j) {
        return System.currentTimeMillis() - j <= ((Long) this.f520a.a(v4.C2)).longValue();
    }
}
