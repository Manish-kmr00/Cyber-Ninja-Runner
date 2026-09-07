package com.chartboost.sdk.impl;

import android.view.ViewGroup;
import com.amazon.aps.shared.metrics.model.ApsMetricsDataMap;
import com.amazon.device.ads.DTBMetricsConfiguration;
import com.chartboost.sdk.ads.Banner;
import com.chartboost.sdk.ads.Interstitial;
import com.chartboost.sdk.ads.Rewarded;
import com.chartboost.sdk.callbacks.AdCallback;
import com.chartboost.sdk.events.CacheError;
import com.chartboost.sdk.events.ClickError;
import com.chartboost.sdk.events.ShowError;
import com.chartboost.sdk.internal.Model.CBError;
import com.facebook.internal.AnalyticsEvents;
import com.fyber.inneractive.sdk.external.InneractiveMediationDefs;
import com.mbridge.msdk.foundation.download.core.DownloadCommon;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.mbsignalcommon.commonwebview.ToolBar;
import com.smaato.sdk.video.vast.model.Ad;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.atomic.AtomicReference;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Result;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;
import net.pubnative.lite.sdk.analytics.Reporting;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(d1 = {"\u0000¶\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0013\b \u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003B[\u0012\u0006\u0010G\u001a\u00020E\u0012\u0006\u0010J\u001a\u00020H\u0012\f\u0010N\u001a\b\u0012\u0004\u0012\u00020L0K\u0012\u0006\u0010Q\u001a\u00020O\u0012\u0006\u0010T\u001a\u00020R\u0012\u0006\u0010W\u001a\u00020U\u0012\u0006\u0010Z\u001a\u00020X\u0012\u0006\u0010k\u001a\u00020\u0003\u0012\f\u0010^\u001a\b\u0012\u0004\u0012\u00020?0[¢\u0006\u0004\bl\u0010mJ\u001d\u0010\b\u001a\u00020\u0007*\u00020\u00042\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0002¢\u0006\u0004\b\b\u0010\tJ\u0015\u0010\u000b\u001a\u00020\n*\u0004\u0018\u00010\u0005H\u0002¢\u0006\u0004\b\u000b\u0010\fJ\u0013\u0010\b\u001a\u00020\u000e*\u00020\rH\u0002¢\u0006\u0004\b\b\u0010\u000fJ)\u0010\b\u001a\u00020\u00072\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0012\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0002¢\u0006\u0004\b\b\u0010\u0013J\u000f\u0010\u0014\u001a\u00020\u0007H\u0002¢\u0006\u0004\b\u0014\u0010\u0015J \u0010\u0018\u001a\u00020\u00072\u0006\u0010\u0016\u001a\u00020\u00052\u0006\u0010\u0017\u001a\u00020\u0005H\u0096\u0001¢\u0006\u0004\b\u0018\u0010\u0019J\u0018\u0010\u001c\u001a\u00020\u00072\u0006\u0010\u001b\u001a\u00020\u001aH\u0096\u0001¢\u0006\u0004\b\u001c\u0010\u001dJ\u0018\u0010\u001e\u001a\u00020\u00072\u0006\u0010\u001b\u001a\u00020\u001aH\u0096\u0001¢\u0006\u0004\b\u001e\u0010\u001dJ\u0018\u0010!\u001a\u00020\u00072\u0006\u0010 \u001a\u00020\u001fH\u0096\u0001¢\u0006\u0004\b!\u0010\"J\u0018\u0010$\u001a\u00020\u00072\u0006\u0010#\u001a\u00020\nH\u0096\u0001¢\u0006\u0004\b$\u0010%J\u0018\u0010&\u001a\u00020\u00072\u0006\u0010\u001b\u001a\u00020\u001aH\u0096\u0001¢\u0006\u0004\b&\u0010\u001dJ\u0014\u0010\u001c\u001a\u00020\u001a*\u00020\u001aH\u0096\u0001¢\u0006\u0004\b\u001c\u0010'J\u0014\u0010\u001e\u001a\u00020\u001a*\u00020\u001aH\u0096\u0001¢\u0006\u0004\b\u001e\u0010'J\u0014\u0010!\u001a\u00020\u001f*\u00020\u001fH\u0096\u0001¢\u0006\u0004\b!\u0010(J\u0014\u0010$\u001a\u00020\n*\u00020\nH\u0096\u0001¢\u0006\u0004\b$\u0010)J\u0014\u0010&\u001a\u00020\u001a*\u00020\u001aH\u0096\u0001¢\u0006\u0004\b&\u0010'J1\u0010\b\u001a\u00020\u00072\u0006\u0010\u0017\u001a\u00020\u00052\u0006\u0010#\u001a\u00020\r2\u0006\u0010+\u001a\u00020*2\b\u0010,\u001a\u0004\u0018\u00010\u0005H\u0004¢\u0006\u0004\b\b\u0010-J\u001f\u0010\b\u001a\u00020\u00072\u0006\u0010#\u001a\u00020\r2\u0006\u0010+\u001a\u00020*H\u0004¢\u0006\u0004\b\b\u0010.J\r\u0010\b\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\u0015J\r\u00100\u001a\u00020/¢\u0006\u0004\b0\u00101J\u0017\u00102\u001a\u00020/2\u0006\u0010\u0017\u001a\u00020\u0005H\u0004¢\u0006\u0004\b2\u00103J\u0019\u00100\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0016¢\u0006\u0004\b0\u00104J+\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u00052\b\u00105\u001a\u0004\u0018\u00010\u00052\u0006\u00107\u001a\u000206H\u0016¢\u0006\u0004\b\b\u00108J\u0019\u00109\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0016¢\u0006\u0004\b9\u00104J!\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u00052\u0006\u00107\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\b\u0010:J!\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u00052\u0006\u0010;\u001a\u00020\u0010H\u0016¢\u0006\u0004\b\b\u0010<J!\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u00052\u0006\u00107\u001a\u00020=H\u0016¢\u0006\u0004\b\b\u0010>J!\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u00052\u0006\u0010@\u001a\u00020?H\u0016¢\u0006\u0004\b\b\u0010AJ\u0019\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0016¢\u0006\u0004\b\b\u00104J\u0019\u0010B\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0016¢\u0006\u0004\bB\u00104J\u0019\u0010\u0014\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0016¢\u0006\u0004\b\u0014\u00104J/\u0010\b\u001a\u00020\u00072\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0012\u001a\u00020\u00052\u0006\u0010C\u001a\u00020\u000e2\u0006\u0010\u0017\u001a\u00020\u0005H\u0004¢\u0006\u0004\b\b\u0010DR\u0014\u0010G\u001a\u00020E8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\b\u0010FR\u0014\u0010J\u001a\u00020H8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b0\u0010IR\u001a\u0010N\u001a\b\u0012\u0004\u0012\u00020L0K8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0014\u0010MR\u0014\u0010Q\u001a\u00020O8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bB\u0010PR\u0014\u0010T\u001a\u00020R8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b9\u0010SR\u0014\u0010W\u001a\u00020U8\u0003X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000b\u0010VR\u0014\u0010Z\u001a\u00020X8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b2\u0010YR\u001a\u0010^\u001a\b\u0012\u0004\u0012\u00020?0[8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\\\u0010]R$\u0010#\u001a\u0004\u0018\u00010\r8\u0004@\u0004X\u0084\u000e¢\u0006\u0012\n\u0004\b_\u0010`\u001a\u0004\ba\u0010b\"\u0004\bc\u0010dR$\u0010+\u001a\u0004\u0018\u00010*8\u0004@\u0004X\u0084\u000e¢\u0006\u0012\n\u0004\be\u0010f\u001a\u0004\bg\u0010h\"\u0004\bi\u0010j¨\u0006n"}, d2 = {"Lcom/chartboost/sdk/impl/c;", "Lcom/chartboost/sdk/impl/i0;", "Lcom/chartboost/sdk/impl/z;", "Lcom/chartboost/sdk/impl/m4;", "Lcom/chartboost/sdk/internal/Model/CBError$b;", "", "impressionId", "", "a", "(Lcom/chartboost/sdk/internal/Model/CBError$b;Ljava/lang/String;)V", "Lcom/chartboost/sdk/impl/da;", InneractiveMediationDefs.GENDER_FEMALE, "(Ljava/lang/String;)Lcom/chartboost/sdk/impl/da;", "Lcom/chartboost/sdk/ads/Ad;", "Lcom/chartboost/sdk/impl/u;", "(Lcom/chartboost/sdk/ads/Ad;)Lcom/chartboost/sdk/impl/u;", "Lcom/chartboost/sdk/impl/ma;", com.ironsource.b9.h.j0, "message", "(Lcom/chartboost/sdk/impl/ma;Ljava/lang/String;Ljava/lang/String;)V", ApsMetricsDataMap.APSMETRICS_FIELD_CUSTOM, "()V", "type", "location", "clear", "(Ljava/lang/String;Ljava/lang/String;)V", "Lcom/chartboost/sdk/impl/ka;", "event", "clearFromStorage", "(Lcom/chartboost/sdk/impl/ka;)V", "persist", "Lcom/chartboost/sdk/impl/ia;", DTBMetricsConfiguration.CONFIG_DIR, ToolBar.REFRESH, "(Lcom/chartboost/sdk/impl/ia;)V", Reporting.Key.CLICK_SOURCE_TYPE_AD, com.ironsource.b9.h.U, "(Lcom/chartboost/sdk/impl/da;)V", "track", "(Lcom/chartboost/sdk/impl/ka;)Lcom/chartboost/sdk/impl/ka;", "(Lcom/chartboost/sdk/impl/ia;)Lcom/chartboost/sdk/impl/ia;", "(Lcom/chartboost/sdk/impl/da;)Lcom/chartboost/sdk/impl/da;", "Lcom/chartboost/sdk/callbacks/AdCallback;", "callback", "bidResponse", "(Ljava/lang/String;Lcom/chartboost/sdk/ads/Ad;Lcom/chartboost/sdk/callbacks/AdCallback;Ljava/lang/String;)V", "(Lcom/chartboost/sdk/ads/Ad;Lcom/chartboost/sdk/callbacks/AdCallback;)V", "", DownloadCommon.DOWNLOAD_REPORT_FIND_FILE_RESULT_VALUE_B, "()Z", "g", "(Ljava/lang/String;)Z", "(Ljava/lang/String;)V", "url", "Lcom/chartboost/sdk/internal/Model/CBError$a;", "error", "(Ljava/lang/String;Ljava/lang/String;Lcom/chartboost/sdk/internal/Model/CBError$a;)V", "e", "(Ljava/lang/String;Lcom/chartboost/sdk/internal/Model/CBError$b;)V", "trackingEventName", "(Ljava/lang/String;Lcom/chartboost/sdk/impl/ma;)V", "Lcom/chartboost/sdk/internal/Model/CBError$d;", "(Ljava/lang/String;Lcom/chartboost/sdk/internal/Model/CBError$d;)V", "", "reward", "(Ljava/lang/String;I)V", "d", Ad.AD_TYPE, "(Lcom/chartboost/sdk/impl/ma;Ljava/lang/String;Lcom/chartboost/sdk/impl/u;Ljava/lang/String;)V", "Lcom/chartboost/sdk/impl/y;", "Lcom/chartboost/sdk/impl/y;", "adUnitLoader", "Lcom/chartboost/sdk/impl/g0;", "Lcom/chartboost/sdk/impl/g0;", "adUnitRenderer", "Ljava/util/concurrent/atomic/AtomicReference;", "Lcom/chartboost/sdk/impl/o9;", "Ljava/util/concurrent/atomic/AtomicReference;", "sdkConfig", "Ljava/util/concurrent/ScheduledExecutorService;", "Ljava/util/concurrent/ScheduledExecutorService;", "backgroundExecutorService", "Lcom/chartboost/sdk/impl/d;", "Lcom/chartboost/sdk/impl/d;", "adApiCallbackSender", "Lcom/chartboost/sdk/impl/s9;", "Lcom/chartboost/sdk/impl/s9;", "session", "Lcom/chartboost/sdk/impl/n1;", "Lcom/chartboost/sdk/impl/n1;", "base64Wrapper", "Lkotlin/Function0;", "h", "Lkotlin/jvm/functions/Function0;", "androidVersion", "j", "Lcom/chartboost/sdk/ads/Ad;", "getAd", "()Lcom/chartboost/sdk/ads/Ad;", "setAd", "(Lcom/chartboost/sdk/ads/Ad;)V", CampaignEx.JSON_KEY_AD_K, "Lcom/chartboost/sdk/callbacks/AdCallback;", "getCallback", "()Lcom/chartboost/sdk/callbacks/AdCallback;", "setCallback", "(Lcom/chartboost/sdk/callbacks/AdCallback;)V", "eventTracker", "<init>", "(Lcom/chartboost/sdk/impl/y;Lcom/chartboost/sdk/impl/g0;Ljava/util/concurrent/atomic/AtomicReference;Ljava/util/concurrent/ScheduledExecutorService;Lcom/chartboost/sdk/impl/d;Lcom/chartboost/sdk/impl/s9;Lcom/chartboost/sdk/impl/n1;Lcom/chartboost/sdk/impl/m4;Lkotlin/jvm/functions/Function0;)V", "ChartboostMonetization-9.8.3_productionRelease"}, k = 1, mv = {1, 8, 0})
public abstract class c implements i0, z, m4 {

    /* JADX INFO: renamed from: a, reason: collision with root package name and from kotlin metadata */
    public final y adUnitLoader;

    /* JADX INFO: renamed from: b, reason: from kotlin metadata */
    public final g0 adUnitRenderer;

    /* JADX INFO: renamed from: c, reason: from kotlin metadata */
    public final AtomicReference<o9> sdkConfig;

    /* JADX INFO: renamed from: d, reason: from kotlin metadata */
    public final ScheduledExecutorService backgroundExecutorService;

    /* JADX INFO: renamed from: e, reason: from kotlin metadata */
    public final d adApiCallbackSender;

    /* JADX INFO: renamed from: f, reason: from kotlin metadata */
    public final s9 session;

    /* JADX INFO: renamed from: g, reason: from kotlin metadata */
    public final n1 base64Wrapper;

    /* JADX INFO: renamed from: h, reason: from kotlin metadata */
    public final Function0<Integer> androidVersion;
    public final /* synthetic */ m4 i;

    /* JADX INFO: renamed from: j, reason: from kotlin metadata */
    public com.chartboost.sdk.ads.Ad ad;

    /* JADX INFO: renamed from: k, reason: from kotlin metadata */
    public AdCallback callback;

    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    public /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f981a;

        static {
            int[] iArr = new int[CBError.b.values().length];
            try {
                iArr[CBError.b.ASSET_MISSING.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[CBError.b.ASSETS_DOWNLOAD_FAILURE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[CBError.b.ASSET_PREFETCH_IN_PROGRESS.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[CBError.b.WEB_VIEW_CLIENT_RECEIVED_ERROR.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                iArr[CBError.b.WEB_VIEW_PAGE_LOAD_TIMEOUT.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                iArr[CBError.b.ERROR_LOADING_WEB_VIEW.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            f981a = iArr;
        }
    }

    public c(y adUnitLoader, g0 adUnitRenderer, AtomicReference<o9> sdkConfig, ScheduledExecutorService backgroundExecutorService, d adApiCallbackSender, s9 session, n1 base64Wrapper, m4 eventTracker, Function0<Integer> androidVersion) {
        Intrinsics.checkNotNullParameter(adUnitLoader, "adUnitLoader");
        Intrinsics.checkNotNullParameter(adUnitRenderer, "adUnitRenderer");
        Intrinsics.checkNotNullParameter(sdkConfig, "sdkConfig");
        Intrinsics.checkNotNullParameter(backgroundExecutorService, "backgroundExecutorService");
        Intrinsics.checkNotNullParameter(adApiCallbackSender, "adApiCallbackSender");
        Intrinsics.checkNotNullParameter(session, "session");
        Intrinsics.checkNotNullParameter(base64Wrapper, "base64Wrapper");
        Intrinsics.checkNotNullParameter(eventTracker, "eventTracker");
        Intrinsics.checkNotNullParameter(androidVersion, "androidVersion");
        this.adUnitLoader = adUnitLoader;
        this.adUnitRenderer = adUnitRenderer;
        this.sdkConfig = sdkConfig;
        this.backgroundExecutorService = backgroundExecutorService;
        this.adApiCallbackSender = adApiCallbackSender;
        this.session = session;
        this.base64Wrapper = base64Wrapper;
        this.androidVersion = androidVersion;
        this.i = eventTracker;
    }

    public final void a(final String location, final com.chartboost.sdk.ads.Ad ad, AdCallback callback, String bidResponse) {
        Intrinsics.checkNotNullParameter(location, "location");
        Intrinsics.checkNotNullParameter(ad, "ad");
        Intrinsics.checkNotNullParameter(callback, "callback");
        this.ad = ad;
        this.callback = callback;
        Object objA = g.f1021a.a(bidResponse, this.base64Wrapper, new b(this));
        if (Result.m7907exceptionOrNullimpl(objA) == null) {
            final String str = (String) objA;
            this.backgroundExecutorService.execute(new Runnable() { // from class: com.chartboost.sdk.impl.c$$ExternalSyntheticLambda0
                @Override // java.lang.Runnable
                public final void run() {
                    c.a(ad, this, location, str);
                }
            });
        }
    }

    @Override // com.chartboost.sdk.impl.l4
    public void clear(String type, String location) {
        Intrinsics.checkNotNullParameter(type, "type");
        Intrinsics.checkNotNullParameter(location, "location");
        this.i.clear(type, location);
    }

    @Override // com.chartboost.sdk.impl.m4
    public ka clearFromStorage(ka kaVar) {
        Intrinsics.checkNotNullParameter(kaVar, "<this>");
        return this.i.clearFromStorage(kaVar);
    }

    public final boolean g(String location) {
        Intrinsics.checkNotNullParameter(location, "location");
        if (this.androidVersion.invoke().intValue() < 21) {
            return true;
        }
        o9 o9Var = this.sdkConfig.get();
        if (o9Var == null || !o9Var.e()) {
            return location.length() == 0;
        }
        b7.b("Chartboost Integration Warning: your account has been disabled for this session. This app has no active publishing campaigns, please create a publishing campaign in the Chartboost dashboard and wait at least 30 minutes to re-enable. If you need assistance, please visit http://chartboo.st/publishing .", null, 2, null);
        return true;
    }

    @Override // com.chartboost.sdk.impl.m4
    public ka persist(ka kaVar) {
        Intrinsics.checkNotNullParameter(kaVar, "<this>");
        return this.i.persist(kaVar);
    }

    @Override // com.chartboost.sdk.impl.m4
    public ia refresh(ia iaVar) {
        Intrinsics.checkNotNullParameter(iaVar, "<this>");
        return this.i.refresh(iaVar);
    }

    @Override // com.chartboost.sdk.impl.m4
    public da store(da daVar) {
        Intrinsics.checkNotNullParameter(daVar, "<this>");
        return this.i.store(daVar);
    }

    @Override // com.chartboost.sdk.impl.m4
    public ka track(ka kaVar) {
        Intrinsics.checkNotNullParameter(kaVar, "<this>");
        return this.i.track(kaVar);
    }

    @Override // com.chartboost.sdk.impl.l4
    /* JADX INFO: renamed from: clearFromStorage */
    public void mo4737clearFromStorage(ka event) {
        Intrinsics.checkNotNullParameter(event, "event");
        this.i.mo4737clearFromStorage(event);
    }

    @Override // com.chartboost.sdk.impl.l4
    /* JADX INFO: renamed from: persist */
    public void mo4738persist(ka event) {
        Intrinsics.checkNotNullParameter(event, "event");
        this.i.mo4738persist(event);
    }

    @Override // com.chartboost.sdk.impl.l4
    /* JADX INFO: renamed from: refresh */
    public void mo4739refresh(ia config) {
        Intrinsics.checkNotNullParameter(config, "config");
        this.i.mo4739refresh(config);
    }

    @Override // com.chartboost.sdk.impl.l4
    /* JADX INFO: renamed from: store */
    public void mo4740store(da ad) {
        Intrinsics.checkNotNullParameter(ad, "ad");
        this.i.mo4740store(ad);
    }

    @Override // com.chartboost.sdk.impl.l4
    /* JADX INFO: renamed from: track */
    public void mo4741track(ka event) {
        Intrinsics.checkNotNullParameter(event, "event");
        this.i.mo4741track(event);
    }

    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    public /* synthetic */ class b extends FunctionReferenceImpl implements Function2<String, CBError.d, Unit> {
        public b(Object obj) {
            super(2, obj, c.class, "onAdFailToLoad", "onAdFailToLoad(Ljava/lang/String;Lcom/chartboost/sdk/internal/Model/CBError$Type;)V", 0);
        }

        public final void a(String str, CBError.d p1) {
            Intrinsics.checkNotNullParameter(p1, "p1");
            ((c) this.receiver).a(str, p1);
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Unit invoke(String str, CBError.d dVar) {
            a(str, dVar);
            return Unit.INSTANCE;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final void a(com.chartboost.sdk.ads.Ad ad, c this$0, String location, String str) {
        Intrinsics.checkNotNullParameter(ad, "$ad");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(location, "$location");
        if (ad instanceof Banner) {
            ViewGroup viewGroup = (ViewGroup) ad;
            Banner banner = (Banner) ad;
            this$0.adUnitLoader.a(location, this$0, str, new w(viewGroup, banner.getBannerWidth(), banner.getBannerHeight()));
            return;
        }
        y.a(this$0.adUnitLoader, location, this$0, str, null, 8, null);
    }

    public final boolean b() {
        y0 y0VarA = this.adUnitLoader.a();
        return (y0VarA != null ? y0VarA.getAdUnit() : null) != null;
    }

    @Override // com.chartboost.sdk.impl.i0
    public void e(String impressionId) {
        a(ma.i.FINISH_SUCCESS, "", impressionId);
        c();
        this.adApiCallbackSender.a(impressionId, (ShowError) null, this.ad, this.callback);
    }

    public final da f(String str) {
        if (str == null) {
            str = "";
        }
        return new da(null, null, str, null, null, null, null, null, 251, null);
    }

    @Override // com.chartboost.sdk.impl.i0
    public void b(String impressionId) {
        this.adApiCallbackSender.a(impressionId, (ClickError) null, this.ad, this.callback);
    }

    public final void a() {
        if (b()) {
            this.adUnitLoader.b();
        }
    }

    @Override // com.chartboost.sdk.impl.i0
    public void d(String impressionId) {
        this.adApiCallbackSender.c(impressionId, this.ad, this.callback);
    }

    @Override // com.chartboost.sdk.impl.z
    public void a(String impressionId, CBError.d error) {
        Intrinsics.checkNotNullParameter(error, "error");
        a(ma.a.FINISH_FAILURE, error.getName(), impressionId);
        this.adApiCallbackSender.a(impressionId, j.a(error), this.ad, this.callback);
    }

    @Override // com.chartboost.sdk.impl.i0
    public void c(String impressionId) {
        a(ma.f.IMPRESSION_RECORDED, "", impressionId);
        this.adApiCallbackSender.b(impressionId, this.ad, this.callback);
    }

    @Override // com.chartboost.sdk.impl.z
    public void a(String impressionId, ma trackingEventName) {
        Intrinsics.checkNotNullParameter(trackingEventName, "trackingEventName");
        a(trackingEventName, "", impressionId);
        this.adApiCallbackSender.a(impressionId, (CacheError) null, this.ad, this.callback);
    }

    public final void c() {
        u uVarA;
        com.chartboost.sdk.ads.Ad ad = this.ad;
        if (ad == null || (uVarA = a(ad)) == null) {
            return;
        }
        this.session.a(uVarA);
        b7.c("Current session impression count: " + this.session.b(uVarA) + " in session: " + this.session.getSessionCounter(), null, 2, null);
    }

    @Override // com.chartboost.sdk.impl.i0
    public void a(String impressionId, String url, CBError.a error) {
        Intrinsics.checkNotNullParameter(error, "error");
        String str = "Click error: " + error.name() + " url: " + url;
        a(ma.b.INVALID_URL_ERROR, str, impressionId);
        this.adApiCallbackSender.a(impressionId, j.a(error, str), this.ad, this.callback);
    }

    @Override // com.chartboost.sdk.impl.i0
    public void a(String impressionId) {
        this.adApiCallbackSender.a(impressionId, this.ad, this.callback);
    }

    @Override // com.chartboost.sdk.impl.i0
    public void a(String impressionId, int reward) {
        this.adApiCallbackSender.a(impressionId, this.ad, this.callback, reward);
    }

    @Override // com.chartboost.sdk.impl.i0
    public void a(String impressionId, CBError.b error) {
        Intrinsics.checkNotNullParameter(error, "error");
        a(error, impressionId);
        this.adApiCallbackSender.a(impressionId, j.a(error), this.ad, this.callback);
    }

    public final void a(com.chartboost.sdk.ads.Ad ad, AdCallback callback) {
        Intrinsics.checkNotNullParameter(ad, "ad");
        Intrinsics.checkNotNullParameter(callback, "callback");
        this.ad = ad;
        this.callback = callback;
        this.backgroundExecutorService.execute(new Runnable() { // from class: com.chartboost.sdk.impl.c$$ExternalSyntheticLambda1
            @Override // java.lang.Runnable
            public final void run() {
                c.a(this.f$0);
            }
        });
    }

    public static final void a(c this$0) {
        Unit unit;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        y0 y0VarA = this$0.adUnitLoader.a();
        if (y0VarA != null) {
            this$0.adUnitRenderer.a(y0VarA, this$0);
            unit = Unit.INSTANCE;
        } else {
            unit = null;
        }
        if (unit == null) {
            b7.b("Missing app request on render", null, 2, null);
        }
    }

    public final u a(com.chartboost.sdk.ads.Ad ad) {
        if (ad instanceof Interstitial) {
            return u.b.g;
        }
        if (ad instanceof Rewarded) {
            return u.c.g;
        }
        if (ad instanceof Banner) {
            return u.a.g;
        }
        throw new NoWhenBranchMatchedException();
    }

    public final void a(ma eventName, String message, String impressionId) {
        String name;
        String location;
        ka r6Var;
        u uVarA;
        com.chartboost.sdk.ads.Ad ad = this.ad;
        if (ad == null || (uVarA = a(ad)) == null || (name = uVarA.getName()) == null) {
            name = AnalyticsEvents.PARAMETER_DIALOG_OUTCOME_VALUE_UNKNOWN;
        }
        String str = name;
        com.chartboost.sdk.ads.Ad ad2 = this.ad;
        if (ad2 == null || (location = ad2.getLocation()) == null) {
            location = "";
        }
        String str2 = location;
        if (eventName == ma.b.INVALID_URL_ERROR) {
            r6Var = new r3(eventName, message, str, str2, this.adUnitRenderer.getMediation(), f(impressionId));
        } else {
            r6Var = new r6(eventName, message, str, str2, this.adUnitRenderer.getMediation(), f(impressionId));
        }
        track(r6Var);
    }

    public final void a(ma eventName, String message, u adType, String location) {
        Intrinsics.checkNotNullParameter(eventName, "eventName");
        Intrinsics.checkNotNullParameter(message, "message");
        Intrinsics.checkNotNullParameter(adType, "adType");
        Intrinsics.checkNotNullParameter(location, "location");
        track((ka) new r6(eventName, message, adType.getName(), location, this.adUnitRenderer.getMediation(), null, 32, null));
    }

    public final void a(CBError.b bVar, String str) {
        ma.i iVar;
        switch (a.f981a[bVar.ordinal()]) {
            case 1:
            case 2:
            case 3:
                iVar = ma.i.UNAVAILABLE_ASSET_ERROR;
                break;
            case 4:
            case 5:
            case 6:
                iVar = ma.i.WEBVIEW_ERROR;
                break;
            default:
                iVar = ma.i.FINISH_FAILURE;
                break;
        }
        a(iVar, bVar.name(), str);
    }
}
