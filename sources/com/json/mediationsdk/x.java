package com.json.mediationsdk;

import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.FrameLayout;
import com.json.c3;
import com.json.h7;
import com.json.ib;
import com.json.mediationsdk.adunit.adapter.utility.AdData;
import com.json.mediationsdk.bidding.BiddingDataCallback;
import com.json.mediationsdk.config.ConfigFile;
import com.json.mediationsdk.logger.IronLog;
import com.json.mediationsdk.logger.IronSourceError;
import com.json.mediationsdk.model.NetworkSettings;
import com.json.mediationsdk.sdk.BannerSmashListener;
import com.json.mediationsdk.utils.IronSourceConstants;
import com.json.mk;
import com.json.o9;
import com.json.oj;
import com.json.qt;
import com.json.vp;
import com.json.y7;
import com.json.zb;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes13.dex */
public class x extends y implements BannerSmashListener, qt.a, y7 {
    private k h;
    private qt i;
    private a j;
    private vp k;
    private IronSourceBannerLayout l;
    private String m;
    private JSONObject n;
    private int o;
    private String p;
    private h7 q;
    private final Object r;
    private ib s;
    private boolean t;
    private boolean u;
    private JSONObject v;

    protected enum a {
        NONE,
        INIT_IN_PROGRESS,
        READY_TO_LOAD,
        LOADING,
        LOADED,
        LOAD_FAILED,
        DESTROYED
    }

    x(k kVar, vp vpVar, NetworkSettings networkSettings, AbstractAdapter abstractAdapter, int i, String str, JSONObject jSONObject, int i2, String str2, boolean z) {
        super(new c3(networkSettings, networkSettings.getBannerSettings(), IronSource.AD_UNIT.BANNER), abstractAdapter);
        this.r = new Object();
        this.j = a.NONE;
        this.h = kVar;
        this.i = new qt(kVar.e());
        this.k = vpVar;
        this.f = i;
        this.m = str;
        this.o = i2;
        this.p = str2;
        this.n = jSONObject;
        this.t = z;
        this.v = null;
        if (r()) {
            u();
        }
    }

    x(k kVar, vp vpVar, NetworkSettings networkSettings, AbstractAdapter abstractAdapter, int i, boolean z) {
        this(kVar, vpVar, networkSettings, abstractAdapter, i, "", null, 0, "", z);
    }

    private void A() {
        IronLog.INTERNAL.verbose();
        a(a.INIT_IN_PROGRESS);
        F();
        try {
            if (this.f4033a != null) {
                if (p()) {
                    this.f4033a.initBannerForBidding(this.h.a(), this.h.i(), this.d, this);
                } else {
                    this.f4033a.initBanners(this.h.a(), this.h.i(), this.d, this);
                }
            }
        } catch (Throwable th) {
            o9.d().a(th);
            IronLog.INTERNAL.error("Exception while trying to init banner from " + this.f4033a.getProviderName() + ", exception =  " + th.getLocalizedMessage());
            onBannerInitFailed(new IronSourceError(612, th.getLocalizedMessage()));
            a(IronSourceConstants.TROUBLESHOOTING_BN_SMASH_UNEXPECTED_EXCEPTION, new Object[][]{new Object[]{"errorCode", Integer.valueOf(IronSourceConstants.errorCode_initFailed)}, new Object[]{"reason", th.getLocalizedMessage()}});
        }
    }

    private boolean B() {
        boolean z;
        synchronized (this.r) {
            z = this.j == a.DESTROYED;
        }
        return z;
    }

    private boolean C() {
        boolean z;
        synchronized (this.r) {
            z = this.j == a.LOADED;
        }
        return z;
    }

    private void F() {
        if (this.f4033a == null) {
            return;
        }
        try {
            String pluginType = ConfigFile.getConfigFile().getPluginType();
            if (TextUtils.isEmpty(pluginType)) {
                return;
            }
            this.f4033a.setPluginData(pluginType);
        } catch (Throwable th) {
            o9.d().a(th);
            IronLog.INTERNAL.error("Exception while trying to set custom params from " + this.f4033a.getProviderName() + ", exception =  " + th.getLocalizedMessage());
            a(IronSourceConstants.TROUBLESHOOTING_BN_SMASH_UNEXPECTED_EXCEPTION, new Object[][]{new Object[]{"errorCode", Integer.valueOf(IronSourceConstants.errorCode_internal)}, new Object[]{"reason", th.getLocalizedMessage()}});
        }
    }

    private void a(IronSourceError ironSourceError) {
        boolean z = ironSourceError.getErrorCode() == 606;
        boolean z2 = this.t;
        if (z) {
            a(z2 ? IronSourceConstants.BN_INSTANCE_RELOAD_NO_FILL : 3306, new Object[][]{new Object[]{"duration", Long.valueOf(ib.a(this.s))}});
        } else {
            a(z2 ? IronSourceConstants.BN_INSTANCE_RELOAD_ERROR : 3300, new Object[][]{new Object[]{"errorCode", Integer.valueOf(ironSourceError.getErrorCode())}, new Object[]{"reason", ironSourceError.getErrorMessage()}, new Object[]{"duration", Long.valueOf(ib.a(this.s))}});
        }
        vp vpVar = this.k;
        if (vpVar != null) {
            vpVar.a(ironSourceError, this, z);
        }
    }

    private void a(a aVar) {
        IronLog.INTERNAL.verbose(y() + "state = " + aVar.name());
        synchronized (this.r) {
            this.j = aVar;
        }
    }

    private void a(String str, JSONObject jSONObject) {
        IronLog ironLog = IronLog.INTERNAL;
        ironLog.verbose(f());
        if (!a(a.READY_TO_LOAD, a.LOADING)) {
            ironLog.error("wrong state - state = " + this.j);
            return;
        }
        this.s = new ib();
        a(this.t ? IronSourceConstants.BN_INSTANCE_RELOAD : 3002);
        if (this.f4033a != null) {
            try {
                if (p()) {
                    this.f4033a.loadBannerForBidding(this.d, this.v, str, this.l, this);
                } else {
                    this.f4033a.loadBanner(this.d, this.v, this.l, this);
                }
            } catch (Throwable th) {
                o9.d().a(th);
                IronLog.INTERNAL.error("Exception while trying to load banner from " + this.f4033a.getProviderName() + ", exception =  " + th.getLocalizedMessage());
                onBannerAdLoadFailed(new IronSourceError(605, th.getLocalizedMessage()));
                a(IronSourceConstants.TROUBLESHOOTING_BN_SMASH_UNEXPECTED_EXCEPTION, new Object[][]{new Object[]{"errorCode", Integer.valueOf(IronSourceConstants.errorCode_loadException)}, new Object[]{"reason", th.getLocalizedMessage()}});
            }
        }
    }

    private boolean a(a aVar, a aVar2) {
        boolean z;
        synchronized (this.r) {
            if (this.j == aVar) {
                IronLog.INTERNAL.verbose(y() + "set state from '" + this.j + "' to '" + aVar2 + "'");
                this.j = aVar2;
                z = true;
            } else {
                z = false;
            }
        }
        return z;
    }

    private boolean b(int i) {
        return i == 3005 || i == 3002 || i == 3012 || i == 3015 || i == 3008 || i == 3305 || i == 3300 || i == 3306 || i == 3307 || i == 3302 || i == 3303 || i == 3304 || i == 3009;
    }

    private void u() {
        IronLog.INTERNAL.verbose("isBidder = " + p() + ", shouldEarlyInit = " + s());
        this.u = true;
        A();
    }

    public void D() {
        this.f4033a.onBannerViewBound(this.b.h().getBannerSettings());
    }

    public void E() {
        this.f4033a.onBannerViewWillBind(this.b.h().getBannerSettings());
    }

    @Override // com.json.y7
    public Map<String, Object> a(AdData adData) {
        AbstractAdapter abstractAdapter;
        JSONObject jSONObjectA = adData != null ? mk.a(adData.getAdUnitData()) : null;
        if (!p() || (abstractAdapter = this.f4033a) == null) {
            return null;
        }
        return abstractAdapter.getBannerBiddingData(this.d, jSONObjectA);
    }

    @Override // com.ironsource.qt.a
    public void a() {
        IronSourceError ironSourceError;
        IronLog ironLog = IronLog.INTERNAL;
        ironLog.verbose(f());
        a aVar = a.INIT_IN_PROGRESS;
        a aVar2 = a.LOAD_FAILED;
        if (a(aVar, aVar2)) {
            ironLog.verbose("init timed out");
            ironSourceError = new IronSourceError(607, "Timed out");
        } else if (!a(a.LOADING, aVar2)) {
            ironLog.error("unexpected state - " + this.j);
            return;
        } else {
            ironLog.verbose("load timed out");
            ironSourceError = new IronSourceError(608, "Timed out");
        }
        a(ironSourceError);
    }

    public void a(int i) {
        a(i, (Object[][]) null);
    }

    public void a(int i, Object[][] objArr) {
        Map<String, Object> mapM = m();
        if (B()) {
            mapM.put("reason", "banner is destroyed");
        } else {
            IronSourceBannerLayout ironSourceBannerLayout = this.l;
            if (ironSourceBannerLayout != null) {
                l.a(mapM, ironSourceBannerLayout.getSize());
            }
        }
        if (!TextUtils.isEmpty(this.m)) {
            mapM.put("auctionId", this.m);
        }
        JSONObject jSONObject = this.n;
        if (jSONObject != null && jSONObject.length() > 0) {
            mapM.put("genericParams", this.n);
        }
        h7 h7Var = this.q;
        if (h7Var != null) {
            mapM.put("placement", h7Var.getPlacementName());
        }
        if (b(i)) {
            oj.i().a(mapM, this.o, this.p);
        }
        mapM.put("sessionDepth", Integer.valueOf(this.f));
        if (objArr != null) {
            try {
                for (Object[] objArr2 : objArr) {
                    mapM.put(objArr2[0].toString(), objArr2[1]);
                }
            } catch (Exception e) {
                o9.d().a(e);
                IronLog.INTERNAL.error(c() + " smash: BN sendMediationEvent " + Log.getStackTraceString(e));
            }
        }
        oj.i().a(new zb(i, new JSONObject(mapM)));
    }

    public void a(IronSourceBannerLayout ironSourceBannerLayout, h7 h7Var, String str, JSONObject jSONObject) {
        vp vpVar;
        IronSourceError ironSourceError;
        IronLog ironLog = IronLog.INTERNAL;
        ironLog.verbose(f());
        this.q = h7Var;
        this.v = jSONObject;
        if (!l.c(ironSourceBannerLayout)) {
            String str2 = ironSourceBannerLayout == null ? "banner is null" : "banner is destroyed";
            ironLog.verbose(str2);
            vpVar = this.k;
            ironSourceError = new IronSourceError(610, str2);
        } else {
            if (this.f4033a != null) {
                this.l = ironSourceBannerLayout;
                this.i.a((qt.a) this);
                try {
                    if (p()) {
                        a(str, this.v);
                    } else {
                        A();
                    }
                    return;
                } catch (Throwable th) {
                    o9.d().a(th);
                    IronLog.INTERNAL.error("exception = " + th.getLocalizedMessage());
                    onBannerAdLoadFailed(new IronSourceError(605, th.getLocalizedMessage()));
                    return;
                }
            }
            ironLog.verbose("mAdapter is null");
            vpVar = this.k;
            ironSourceError = new IronSourceError(611, "mAdapter is null");
        }
        vpVar.a(ironSourceError, this, false);
    }

    @Override // com.json.y7
    public void a(AdData adData, BiddingDataCallback biddingDataCallback) {
        a(IronSourceConstants.BN_INSTANCE_COLLECT_TOKEN);
        try {
            this.f4033a.collectBannerBiddingData(this.d, adData != null ? mk.a(adData.getAdUnitData()) : null, biddingDataCallback);
        } catch (Throwable th) {
            o9.d().a(th);
            IronLog.INTERNAL.error("Exception while trying to collectBannerBiddingData from " + this.f4033a.getProviderName() + ", exception =  " + th.getLocalizedMessage());
        }
    }

    @Override // com.json.mediationsdk.y
    public IronSource.AD_UNIT d() {
        return IronSource.AD_UNIT.BANNER;
    }

    @Override // com.json.mediationsdk.y
    public String k() {
        return "ProgBannerSmash";
    }

    @Override // com.json.mediationsdk.sdk.BannerSmashListener
    public void onBannerAdClicked() {
        IronLog.INTERNAL.verbose(f());
        a(3008);
        vp vpVar = this.k;
        if (vpVar != null) {
            vpVar.b(this);
        }
    }

    @Override // com.json.mediationsdk.sdk.BannerSmashListener
    public void onBannerAdLeftApplication() {
        IronLog.INTERNAL.verbose(f());
        a(3304);
        vp vpVar = this.k;
        if (vpVar != null) {
            vpVar.c(this);
        }
    }

    @Override // com.json.mediationsdk.sdk.BannerSmashListener
    public void onBannerAdLoadFailed(IronSourceError ironSourceError) {
        IronLog.INTERNAL.verbose(y() + "error = " + ironSourceError);
        this.i.e();
        if (a(a.LOADING, a.LOAD_FAILED)) {
            a(ironSourceError);
        }
    }

    @Override // com.json.mediationsdk.sdk.BannerSmashListener
    public void onBannerAdLoaded(View view, FrameLayout.LayoutParams layoutParams) {
        IronLog.INTERNAL.verbose(f());
        this.i.e();
        if (!a(a.LOADING, a.LOADED)) {
            a(this.t ? IronSourceConstants.BN_INSTANCE_UNEXPECTED_RELOAD_SUCCESS : IronSourceConstants.BN_INSTANCE_UNEXPECTED_LOAD_SUCCESS);
            return;
        }
        a(this.t ? IronSourceConstants.BN_INSTANCE_RELOAD_SUCCESS : 3005, new Object[][]{new Object[]{"duration", Long.valueOf(ib.a(this.s))}});
        vp vpVar = this.k;
        if (vpVar != null) {
            vpVar.a(this, view, layoutParams);
        }
    }

    @Override // com.json.mediationsdk.sdk.BannerSmashListener
    public void onBannerAdScreenDismissed() {
        IronLog.INTERNAL.verbose(f());
        a(IronSourceConstants.BN_INSTANCE_DISMISS_SCREEN);
        vp vpVar = this.k;
        if (vpVar != null) {
            vpVar.e(this);
        }
    }

    @Override // com.json.mediationsdk.sdk.BannerSmashListener
    public void onBannerAdScreenPresented() {
        IronLog.INTERNAL.verbose(f());
        a(IronSourceConstants.BN_INSTANCE_PRESENT_SCREEN);
        vp vpVar = this.k;
        if (vpVar != null) {
            vpVar.d(this);
        }
    }

    @Override // com.json.mediationsdk.sdk.BannerSmashListener
    public void onBannerAdShown() {
        IronLog ironLog = IronLog.INTERNAL;
        ironLog.verbose(f());
        if (!C()) {
            ironLog.warning("wrong state - mState = " + this.j);
            a(IronSourceConstants.TROUBLESHOOTING_BN_SMASH_UNEXPECTED_STATE, new Object[][]{new Object[]{"errorCode", 1}, new Object[]{"reason", "Wrong State - " + this.j}, new Object[]{IronSourceConstants.EVENTS_EXT1, c()}});
            return;
        }
        a(3009);
        vp vpVar = this.k;
        if (vpVar != null) {
            vpVar.a(this);
        }
    }

    @Override // com.json.mediationsdk.sdk.BannerSmashListener
    public void onBannerInitFailed(IronSourceError ironSourceError) {
        IronLog ironLog = IronLog.INTERNAL;
        ironLog.verbose(y() + "error = " + ironSourceError);
        this.i.e();
        if (!a(a.INIT_IN_PROGRESS, a.NONE)) {
            ironLog.warning("wrong state - mState = " + this.j);
            return;
        }
        vp vpVar = this.k;
        if (vpVar != null) {
            vpVar.a(ironSourceError, this, false);
        }
    }

    @Override // com.json.mediationsdk.sdk.BannerSmashListener
    public void onBannerInitSuccess() {
        IronLog.INTERNAL.verbose(f());
        if (a(a.INIT_IN_PROGRESS, a.READY_TO_LOAD)) {
            if (this.u) {
                this.u = false;
            } else {
                if (p()) {
                    return;
                }
                if (l.c(this.l)) {
                    a((String) null, this.v);
                } else {
                    this.k.a(new IronSourceError(605, this.l == null ? "banner is null" : "banner is destroyed"), this, false);
                }
            }
        }
    }

    @Override // com.json.mediationsdk.y
    public void q() {
        this.i.d();
        super.q();
    }

    public void t() {
        IronLog ironLog = IronLog.INTERNAL;
        ironLog.verbose(f());
        a(3305);
        a(a.DESTROYED);
        AbstractAdapter abstractAdapter = this.f4033a;
        if (abstractAdapter == null) {
            ironLog.warning("mAdapter == null");
            return;
        }
        try {
            abstractAdapter.destroyBanner(this.b.h().getBannerSettings());
        } catch (Throwable th) {
            o9.d().a(th);
            IronLog.INTERNAL.error("Exception while trying to destroy banner from " + this.f4033a.getProviderName() + ", exception =  " + th.getLocalizedMessage());
            a(IronSourceConstants.TROUBLESHOOTING_BN_SMASH_UNEXPECTED_EXCEPTION, new Object[][]{new Object[]{"errorCode", Integer.valueOf(IronSourceConstants.errorCode_destroy)}, new Object[]{"reason", th.getLocalizedMessage()}});
        }
    }

    public String v() {
        return !TextUtils.isEmpty(this.b.h().getAdSourceNameForEvents()) ? this.b.h().getAdSourceNameForEvents() : i();
    }

    public AbstractAdapter w() {
        return this.f4033a;
    }

    public String x() {
        return this.m;
    }

    public String y() {
        return String.format("%s - ", f());
    }

    public String z() {
        return this.b.i();
    }
}
