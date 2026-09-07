package com.fyber.inneractive.sdk.flow;

import android.text.TextUtils;
import android.webkit.WebView;
import com.fyber.inneractive.sdk.config.IAConfigManager;
import com.fyber.inneractive.sdk.external.InneractiveAdRequest;
import com.fyber.inneractive.sdk.external.InneractiveErrorCode;
import com.fyber.inneractive.sdk.external.InneractiveInfrastructureError;
import com.fyber.inneractive.sdk.external.InneractiveVideoError;
import com.fyber.inneractive.sdk.network.C3146w;
import com.fyber.inneractive.sdk.network.EnumC3143t;
import com.fyber.inneractive.sdk.util.AbstractC3251o;
import com.fyber.inneractive.sdk.util.IAlog;
import com.iab.omid.library.fyber.adsession.AdEvents;
import com.iab.omid.library.fyber.adsession.AdSession;
import com.iab.omid.library.fyber.adsession.AdSessionConfiguration;
import com.iab.omid.library.fyber.adsession.AdSessionContext;
import com.iab.omid.library.fyber.adsession.CreativeType;
import com.iab.omid.library.fyber.adsession.ImpressionType;
import com.iab.omid.library.fyber.adsession.Owner;
import com.iab.omid.library.fyber.adsession.Partner;
import com.iab.omid.library.fyber.adsession.media.MediaEvents;
import com.iab.omid.library.fyber.publisher.AdSessionStatePublisher;
import java.util.ArrayList;
import java.util.HashMap;
import org.json.JSONArray;

/* JADX INFO: renamed from: com.fyber.inneractive.sdk.flow.u, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes10.dex */
public final class C3115u extends AbstractC3106k implements com.fyber.inneractive.sdk.player.s {
    public com.fyber.inneractive.sdk.player.t m;
    public String n;
    public final C3114t o = new C3114t(this);

    @Override // com.fyber.inneractive.sdk.flow.AbstractC3106k, com.fyber.inneractive.sdk.interfaces.b
    public final void a() {
        InneractiveVideoError inneractiveVideoError;
        com.fyber.inneractive.sdk.model.vast.b bVar;
        if (this.m != null) {
            com.fyber.inneractive.sdk.response.e eVar = this.b;
            if (eVar == null || (bVar = ((com.fyber.inneractive.sdk.response.g) eVar).N) == null) {
                inneractiveVideoError = null;
            } else {
                inneractiveVideoError = bVar.d.size() == 0 ? new InneractiveVideoError(InneractiveVideoError.Error.ERROR_FAILED_PLAYING_ALL_MEDIA_FILES, null) : new InneractiveVideoError(InneractiveVideoError.Error.ERROR_FAILED_PLAYING_MEDIA_FILE, null);
            }
            this.m.a(inneractiveVideoError, null, true);
        }
        IAlog.a("%s: IAAdContentLoaderImpl : cancel load ad content retry task", IAlog.a(this));
        com.fyber.inneractive.sdk.util.r.b.removeCallbacks(this.l);
        this.k.a();
        super.a();
    }

    @Override // com.fyber.inneractive.sdk.flow.AbstractC3106k
    public final String d() {
        return "send_failed_vast_creatives";
    }

    @Override // com.fyber.inneractive.sdk.flow.AbstractC3106k
    public final void g() {
        com.fyber.inneractive.sdk.model.vast.b bVar;
        AdSessionConfiguration adSessionConfigurationCreateAdSessionConfiguration;
        String str;
        EnumC3143t enumC3143t;
        com.fyber.inneractive.sdk.model.vast.b bVar2;
        IAlog.a(IAlog.a(this) + "start called", new Object[0]);
        com.fyber.inneractive.sdk.config.U uE = e();
        com.fyber.inneractive.sdk.response.e eVar = this.b;
        AdSessionContext adSessionContextCreateNativeAdSessionContext = null;
        com.fyber.inneractive.sdk.model.vast.b bVar3 = eVar == null ? null : ((com.fyber.inneractive.sdk.response.g) eVar).N;
        if (bVar3 != null && bVar3.d.size() < bVar3.i) {
            bVar3.d.clear();
            bVar3.g.clear();
            bVar3.d.addAll(bVar3.k);
            bVar3.g.addAll(bVar3.l);
        }
        S s = new S(uE, this.g, (com.fyber.inneractive.sdk.response.g) this.b, this.f1803a);
        this.c = s;
        com.fyber.inneractive.sdk.response.g gVar = (com.fyber.inneractive.sdk.response.g) this.b;
        com.fyber.inneractive.sdk.player.t tVar = new com.fyber.inneractive.sdk.player.t(gVar, this.f1803a, s, this);
        this.m = tVar;
        S s2 = (S) this.c;
        s2.i = tVar;
        s2.f = this.h;
        this.n = bVar3 != null ? bVar3.n : null;
        tVar.e = null;
        if (gVar != null && (bVar2 = gVar.N) != null) {
            tVar.e = (com.fyber.inneractive.sdk.model.vast.r) bVar2.d.poll();
        }
        if (tVar.e == null) {
            InneractiveVideoError.Error playerError = new InneractiveVideoError(InneractiveVideoError.Error.ERROR_FAILED_PLAYING_ALL_MEDIA_FILES).getPlayerError();
            int i = com.fyber.inneractive.sdk.player.r.f2230a[playerError.ordinal()];
            if (i == 1) {
                enumC3143t = EnumC3143t.VAST_ERROR_NO_MEDIA_FILES;
            } else if (i == 2) {
                enumC3143t = EnumC3143t.VAST_ERROR_FAILED_PLAYING_MEDIA_FILE;
            } else if (i == 3) {
                enumC3143t = EnumC3143t.VAST_ERROR_FAILED_PLAYING_ALL_MEDIA_FILES;
            } else if (i == 4) {
                enumC3143t = EnumC3143t.VAST_ERROR_PRE_BUFFER_TIMEOUT;
            } else if (i != 5) {
                IAlog.a("IAReportError, Does not know player error " + playerError.getErrorString(), new Object[0]);
                enumC3143t = EnumC3143t.VAST_UNKNOWN_PLAYER_ERROR;
            } else {
                enumC3143t = EnumC3143t.VAST_ERROR_BUFFER_TIMEOUT;
            }
            InneractiveAdRequest inneractiveAdRequest = tVar.b;
            com.fyber.inneractive.sdk.response.g gVar2 = tVar.c;
            JSONArray jSONArrayB = tVar.h.b();
            C3146w c3146w = new C3146w(gVar2);
            c3146w.b = enumC3143t;
            c3146w.f1934a = inneractiveAdRequest;
            c3146w.d = jSONArrayB;
            c3146w.a((String) null);
            InneractiveInfrastructureError inneractiveInfrastructureError = new InneractiveInfrastructureError(InneractiveErrorCode.SDK_INTERNAL_ERROR, EnumC3104i.VAST_NO_MEDIA_FILES);
            b(inneractiveInfrastructureError);
            a(inneractiveInfrastructureError);
        } else {
            tVar.b();
            com.fyber.inneractive.sdk.player.a aVar = tVar.f;
            if (aVar != null) {
                com.fyber.inneractive.sdk.player.n nVar = (com.fyber.inneractive.sdk.player.n) aVar;
                if (nVar.d != null) {
                    com.fyber.inneractive.sdk.measurement.g gVar3 = new com.fyber.inneractive.sdk.measurement.g();
                    com.fyber.inneractive.sdk.measurement.e eVar2 = nVar.d;
                    ArrayList arrayList = nVar.p.e;
                    S s3 = nVar.b;
                    try {
                        try {
                            CreativeType creativeType = CreativeType.VIDEO;
                            ImpressionType impressionType = ImpressionType.UNSPECIFIED;
                            Owner owner = Owner.NATIVE;
                            adSessionConfigurationCreateAdSessionConfiguration = AdSessionConfiguration.createAdSessionConfiguration(creativeType, impressionType, owner, owner, false);
                        } catch (Throwable th) {
                            gVar3.a(th);
                            adSessionConfigurationCreateAdSessionConfiguration = null;
                        }
                        ArrayList arrayListA = gVar3.a(arrayList);
                        Partner partner = eVar2.e;
                        if (partner != null && (str = eVar2.b) != null) {
                            try {
                                adSessionContextCreateNativeAdSessionContext = AdSessionContext.createNativeAdSessionContext(partner, str, arrayListA, "", "");
                            } catch (Throwable th2) {
                                gVar3.a(th2);
                            }
                        }
                        AdSession adSessionCreateAdSession = AdSession.createAdSession(adSessionConfigurationCreateAdSessionConfiguration, adSessionContextCreateNativeAdSessionContext);
                        gVar3.f1861a = adSessionCreateAdSession;
                        AdSessionStatePublisher adSessionStatePublisher = adSessionCreateAdSession.getAdSessionStatePublisher();
                        if (adSessionStatePublisher != null) {
                            adSessionStatePublisher.getWebView();
                            WebView webView = adSessionStatePublisher.getWebView();
                            if (webView != null) {
                                webView.setWebViewClient(gVar3.g);
                            }
                        }
                        gVar3.b = AdEvents.createAdEvents(gVar3.f1861a);
                        gVar3.c = MediaEvents.createMediaEvents(gVar3.f1861a);
                        gVar3.f1861a.start();
                        gVar3.f = s3;
                    } catch (Throwable th3) {
                        gVar3.a(th3);
                    }
                    nVar.e = gVar3;
                    nVar.f = new com.fyber.inneractive.sdk.player.p(gVar3);
                }
                if (nVar.e == null && (bVar = nVar.p) != null) {
                    for (com.fyber.inneractive.sdk.measurement.i iVar : bVar.e) {
                        com.fyber.inneractive.sdk.measurement.j jVar = com.fyber.inneractive.sdk.measurement.j.ERROR_DURING_RESOURCE_LOAD;
                        com.fyber.inneractive.sdk.model.vast.x xVar = com.fyber.inneractive.sdk.model.vast.x.EVENT_VERIFICATION_NOT_EXECUTED;
                        com.fyber.inneractive.sdk.player.n.a(new com.fyber.inneractive.sdk.measurement.h(iVar.a(xVar), jVar), xVar);
                    }
                }
            }
            tVar.a();
        }
        if (TextUtils.isEmpty(this.n)) {
            return;
        }
        IAConfigManager.O.s.b(new com.fyber.inneractive.sdk.network.V(this.o, AbstractC3251o.f2370a, new com.fyber.inneractive.sdk.cache.j(this.n)));
    }

    @Override // com.fyber.inneractive.sdk.flow.AbstractC3106k, com.fyber.inneractive.sdk.interfaces.c
    public final void cancel() {
        IAlog.a("%s: IAAdContentLoaderImpl : cancel load ad content retry task", IAlog.a(this));
        com.fyber.inneractive.sdk.util.r.b.removeCallbacks(this.l);
        this.k.a();
    }

    public final void a(Exception exc, String str, boolean z) {
        HashMap map = new HashMap();
        map.put("description", str);
        if (exc != null) {
            map.put("exception", exc.getMessage());
        }
        com.fyber.inneractive.sdk.network.events.a.a(EnumC3143t.VAST_ERROR_DVC_FAILURE, com.fyber.inneractive.sdk.network.events.b.TEMPLATE_ERROR.name(), this.n, this.f1803a, this.b, map, Boolean.valueOf(z));
    }
}
