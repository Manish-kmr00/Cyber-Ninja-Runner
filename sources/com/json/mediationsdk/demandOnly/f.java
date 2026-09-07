package com.json.mediationsdk.demandOnly;

import android.text.TextUtils;
import com.json.mb;
import com.json.mediationsdk.AbstractAdapter;
import com.json.mediationsdk.c;
import com.json.mediationsdk.e;
import com.json.mediationsdk.logger.IronLog;
import com.json.mediationsdk.logger.IronSourceError;
import com.json.mediationsdk.model.NetworkSettings;
import com.json.mediationsdk.utils.ErrorBuilder;
import com.json.mediationsdk.utils.IronSourceAES;
import com.json.mediationsdk.utils.IronSourceUtils;
import com.json.mg;
import com.json.mj;
import com.json.o9;
import com.json.ra;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: classes5.dex */
public class f implements i.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final ra f3956a;
    private final ConcurrentHashMap<String, g> b;
    private final mg<ISDemandOnlyInterstitialListener> c;

    public f(List<NetworkSettings> list, mj mjVar, c cVar, mg<ISDemandOnlyInterstitialListener> mgVar, String str, String str2, ra raVar) {
        String sessionId = IronSourceUtils.getSessionId();
        boolean zJ = mjVar.j();
        com.json.mediationsdk.f fVar = new com.json.mediationsdk.f(mjVar.g(), sessionId);
        this.b = new ConcurrentHashMap<>();
        this.f3956a = raVar;
        this.c = mgVar;
        for (NetworkSettings networkSettings : list) {
            if (networkSettings.isIronSource()) {
                AbstractAdapter abstractAdapterA = cVar.a(networkSettings, networkSettings.getInterstitialSettings(), true);
                if (abstractAdapterA != null) {
                    g gVar = new g(str, str2, networkSettings, this.c.a(networkSettings.getSubProviderId()), mjVar.e(), abstractAdapterA, new e(fVar));
                    gVar.a(zJ);
                    this.b.put(networkSettings.getSubProviderId(), gVar);
                }
            } else {
                IronLog.INTERNAL.error("cannot load " + networkSettings.getProviderTypeForReflection());
            }
        }
    }

    public ConcurrentHashMap<String, g> a() {
        return this.b;
    }

    @Override // com.ironsource.mediationsdk.demandOnly.i.b
    public void a(h.d dVar) {
        String instanceId = dVar.getInstanceId();
        String adMarkup = dVar.getAdMarkup();
        try {
            g gVar = this.b.get(instanceId);
            if (gVar == null) {
                this.f3956a.a(2503, instanceId);
                IronSourceError ironSourceErrorBuildNonExistentInstanceError = ErrorBuilder.buildNonExistentInstanceError("Interstitial");
                IronLog.API.error(ironSourceErrorBuildNonExistentInstanceError.getErrorMessage());
                this.c.a(instanceId).onInterstitialAdLoadFailed(instanceId, ironSourceErrorBuildNonExistentInstanceError);
                return;
            }
            if (TextUtils.isEmpty(adMarkup)) {
                gVar.c();
            } else {
                gVar.a(new o.a(IronSourceAES.decode(mb.b().c(), adMarkup)));
            }
        } catch (Exception e) {
            o9.d().a(e);
            IronSourceError ironSourceErrorBuildLoadFailedError = ErrorBuilder.buildLoadFailedError("loadInterstitial exception " + e.getMessage());
            IronLog.API.error(ironSourceErrorBuildLoadFailedError.getErrorMessage());
            this.c.a(instanceId).onInterstitialAdLoadFailed(instanceId, ironSourceErrorBuildLoadFailedError);
        }
    }

    @Override // com.ironsource.mediationsdk.demandOnly.i.b
    public void a(String str) {
        try {
            g gVar = this.b.get(str);
            if (gVar != null) {
                gVar.b();
                return;
            }
            this.f3956a.a(2507, str);
            IronSourceError ironSourceErrorBuildNonExistentInstanceError = ErrorBuilder.buildNonExistentInstanceError("Interstitial");
            IronLog.API.error(ironSourceErrorBuildNonExistentInstanceError.getErrorMessage());
            this.c.a(str).onInterstitialAdShowFailed(str, ironSourceErrorBuildNonExistentInstanceError);
        } catch (Exception e) {
            o9.d().a(e);
            IronSourceError ironSourceErrorBuildShowFailedError = ErrorBuilder.buildShowFailedError("Interstitial", "showInterstitial exception " + e.getMessage());
            IronLog.API.error(ironSourceErrorBuildShowFailedError.getErrorMessage());
            this.c.a(str).onInterstitialAdShowFailed(str, ironSourceErrorBuildShowFailedError);
        }
    }

    @Override // com.ironsource.mediationsdk.demandOnly.i.b
    public boolean b(String str) {
        g gVar = this.b.get(str);
        if (gVar != null) {
            return gVar.a();
        }
        this.f3956a.a(2500, str);
        return false;
    }
}
