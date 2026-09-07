package com.fyber.inneractive.sdk.player;

import com.fyber.inneractive.sdk.external.InneractiveAdRequest;
import com.fyber.inneractive.sdk.external.InneractiveErrorCode;
import com.fyber.inneractive.sdk.external.InneractiveInfrastructureError;
import com.fyber.inneractive.sdk.external.InneractiveVideoError;
import com.fyber.inneractive.sdk.flow.C3115u;
import com.fyber.inneractive.sdk.flow.EnumC3104i;
import com.fyber.inneractive.sdk.flow.S;
import com.fyber.inneractive.sdk.model.vast.x;
import com.fyber.inneractive.sdk.network.C3146w;
import com.fyber.inneractive.sdk.network.EnumC3143t;
import com.fyber.inneractive.sdk.player.enums.VideoClickOrigin;
import com.fyber.inneractive.sdk.util.IAlog;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes12.dex */
public final class t implements q {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final b f2231a;
    public final InneractiveAdRequest b;
    public final com.fyber.inneractive.sdk.response.g c;
    public final s d;
    public com.fyber.inneractive.sdk.model.vast.r e;
    public a f;
    public boolean g = false;
    public final com.fyber.inneractive.sdk.config.global.r h;

    public t(com.fyber.inneractive.sdk.response.g gVar, InneractiveAdRequest inneractiveAdRequest, S s, s sVar) {
        this.b = inneractiveAdRequest;
        this.c = gVar;
        this.d = sVar;
        this.h = s.c;
        this.f2231a = new b(s);
    }

    public final void a() {
        a aVar = this.f;
        if (aVar == null) {
            s sVar = this.d;
            InneractiveInfrastructureError inneractiveInfrastructureError = new InneractiveInfrastructureError(InneractiveErrorCode.SDK_INTERNAL_ERROR, EnumC3104i.COULD_NOT_LOAD_USING_FLOW_MANAGER, new Exception("loadNextMediaFile flowManager is null"));
            C3115u c3115u = (C3115u) sVar;
            c3115u.b(inneractiveInfrastructureError);
            c3115u.a(inneractiveInfrastructureError);
            return;
        }
        com.fyber.inneractive.sdk.model.vast.r rVar = this.e;
        n nVar = (n) aVar;
        nVar.l = this;
        if (rVar != null) {
            String str = rVar.g;
            nVar.n = rVar;
            nVar.k++;
            nVar.h = false;
            nVar.j = false;
            IAlog.a("IAMediaPlayerFlowManager: playNextMediaFile - loading video url: %s", str);
            IAlog.a("IAMediaPlayerFlowManager: start - start fetching video frame", new Object[0]);
            if (nVar.i) {
                return;
            }
            nVar.f2210a.a(str, nVar.m);
        }
    }

    public final void b() {
        try {
            this.f = this.f2231a.a();
        } catch (Throwable th) {
            s sVar = this.d;
            InneractiveInfrastructureError inneractiveInfrastructureError = new InneractiveInfrastructureError(InneractiveErrorCode.SDK_INTERNAL_ERROR, EnumC3104i.COULD_NOT_CREATE_FLOW_MANAGER, th);
            C3115u c3115u = (C3115u) sVar;
            c3115u.b(inneractiveInfrastructureError);
            c3115u.a(inneractiveInfrastructureError);
        }
    }

    public final void a(InneractiveVideoError inneractiveVideoError, JSONObject jSONObject, boolean z) {
        JSONObject jSONObject2;
        InneractiveErrorCode inneractiveErrorCode;
        EnumC3143t enumC3143t;
        com.fyber.inneractive.sdk.model.vast.b bVar;
        EnumC3143t enumC3143t2;
        if (jSONObject != null || inneractiveVideoError == null) {
            jSONObject2 = jSONObject;
        } else {
            jSONObject2 = new JSONObject();
            ((n) this.f).b(inneractiveVideoError, jSONObject2);
        }
        EnumC3104i enumC3104i = EnumC3104i.UNSPECIFIED;
        if (inneractiveVideoError != null) {
            InneractiveVideoError.Error playerError = inneractiveVideoError.getPlayerError();
            int i = r.f2230a[playerError.ordinal()];
            if (i == 1) {
                enumC3143t2 = EnumC3143t.VAST_ERROR_NO_MEDIA_FILES;
            } else if (i == 2) {
                enumC3143t2 = EnumC3143t.VAST_ERROR_FAILED_PLAYING_MEDIA_FILE;
            } else if (i == 3) {
                enumC3143t2 = EnumC3143t.VAST_ERROR_FAILED_PLAYING_ALL_MEDIA_FILES;
            } else if (i == 4) {
                enumC3143t2 = EnumC3143t.VAST_ERROR_PRE_BUFFER_TIMEOUT;
            } else if (i != 5) {
                IAlog.a("IAReportError, Does not know player error " + playerError.getErrorString(), new Object[0]);
                enumC3143t2 = EnumC3143t.VAST_UNKNOWN_PLAYER_ERROR;
            } else {
                enumC3143t2 = EnumC3143t.VAST_ERROR_BUFFER_TIMEOUT;
            }
            InneractiveAdRequest inneractiveAdRequest = this.b;
            com.fyber.inneractive.sdk.response.g gVar = this.c;
            JSONArray jSONArrayB = this.h.b();
            C3146w c3146w = new C3146w(gVar);
            c3146w.b = enumC3143t2;
            c3146w.f1934a = inneractiveAdRequest;
            c3146w.d = jSONArrayB;
            if (jSONObject2 != null) {
                try {
                    c3146w.f.put(new JSONObject(jSONObject2.toString()));
                } catch (Exception unused) {
                }
            }
            c3146w.a((String) null);
        }
        if (InneractiveErrorCode.NON_SECURE_CONTENT_DETECTED == null) {
            EnumC3143t enumC3143t3 = EnumC3143t.VPAID_ERROR_UNSECURE_CONTENT;
            InneractiveAdRequest inneractiveAdRequest2 = this.b;
            com.fyber.inneractive.sdk.response.g gVar2 = this.c;
            JSONArray jSONArrayB2 = this.h.b();
            C3146w c3146w2 = new C3146w(gVar2);
            c3146w2.b = enumC3143t3;
            c3146w2.f1934a = inneractiveAdRequest2;
            c3146w2.d = jSONArrayB2;
            c3146w2.a((String) null);
        }
        if (inneractiveVideoError != null) {
            IAlog.a("got onMediaPlayerLoadError with: " + inneractiveVideoError.getPlayerError(), new Object[0]);
            if (z) {
                inneractiveErrorCode = InneractiveErrorCode.LOAD_TIMEOUT;
                enumC3104i = EnumC3104i.VIDEO_AD_LOAD_TIMEOUT;
            } else {
                inneractiveErrorCode = null;
            }
            IAlog.a("got onMediaPlayerLoadError with: " + inneractiveVideoError.description(), new Object[0]);
            if (inneractiveVideoError.getPlayerError().isFatal()) {
                inneractiveErrorCode = InneractiveErrorCode.SERVER_INVALID_RESPONSE;
                enumC3104i = EnumC3104i.VIDEO_FATAL_ERROR;
            }
            if (inneractiveErrorCode == null) {
                inneractiveErrorCode = InneractiveErrorCode.SERVER_INVALID_RESPONSE;
                enumC3104i = EnumC3104i.VIDEO_ERROR_UNSPECIFIED;
            }
        } else {
            inneractiveErrorCode = null;
        }
        if (z) {
            return;
        }
        this.e = null;
        com.fyber.inneractive.sdk.response.g gVar3 = this.c;
        if (gVar3 != null && (bVar = gVar3.N) != null) {
            this.e = (com.fyber.inneractive.sdk.model.vast.r) bVar.d.poll();
        }
        if (this.e == null) {
            InneractiveVideoError.Error playerError2 = new InneractiveVideoError(InneractiveVideoError.Error.ERROR_FAILED_PLAYING_ALL_MEDIA_FILES).getPlayerError();
            int i2 = r.f2230a[playerError2.ordinal()];
            if (i2 == 1) {
                enumC3143t = EnumC3143t.VAST_ERROR_NO_MEDIA_FILES;
            } else if (i2 == 2) {
                enumC3143t = EnumC3143t.VAST_ERROR_FAILED_PLAYING_MEDIA_FILE;
            } else if (i2 == 3) {
                enumC3143t = EnumC3143t.VAST_ERROR_FAILED_PLAYING_ALL_MEDIA_FILES;
            } else if (i2 == 4) {
                enumC3143t = EnumC3143t.VAST_ERROR_PRE_BUFFER_TIMEOUT;
            } else if (i2 != 5) {
                IAlog.a("IAReportError, Does not know player error " + playerError2.getErrorString(), new Object[0]);
                enumC3143t = EnumC3143t.VAST_UNKNOWN_PLAYER_ERROR;
            } else {
                enumC3143t = EnumC3143t.VAST_ERROR_BUFFER_TIMEOUT;
            }
            InneractiveAdRequest inneractiveAdRequest3 = this.b;
            com.fyber.inneractive.sdk.response.g gVar4 = this.c;
            JSONArray jSONArrayB3 = this.h.b();
            C3146w c3146w3 = new C3146w(gVar4);
            c3146w3.b = enumC3143t;
            c3146w3.f1934a = inneractiveAdRequest3;
            c3146w3.d = jSONArrayB3;
            c3146w3.a((String) null);
            s sVar = this.d;
            if (sVar != null) {
                if (inneractiveVideoError != null) {
                    InneractiveInfrastructureError inneractiveInfrastructureError = new InneractiveInfrastructureError(inneractiveErrorCode, enumC3104i, inneractiveVideoError.getCause());
                    C3115u c3115u = (C3115u) sVar;
                    c3115u.b(inneractiveInfrastructureError);
                    c3115u.a(inneractiveInfrastructureError);
                    return;
                }
                InneractiveInfrastructureError inneractiveInfrastructureError2 = new InneractiveInfrastructureError(inneractiveErrorCode, EnumC3104i.VIDEO_ERROR_NULL);
                C3115u c3115u2 = (C3115u) sVar;
                c3115u2.b(inneractiveInfrastructureError2);
                c3115u2.a(inneractiveInfrastructureError2);
                return;
            }
            return;
        }
        if (this.g) {
            return;
        }
        b();
        a();
    }

    public final void a(String str, String... strArr) {
        a aVar = this.f;
        if (aVar != null) {
            n nVar = (n) aVar;
            if ("TRACKING_COMPLETED".equalsIgnoreCase(str)) {
                nVar.r = true;
                return;
            }
            if ("EVENT_TRACKING".equalsIgnoreCase(str)) {
                for (String str2 : strArr) {
                    nVar.a(nVar.p, VideoClickOrigin.InvalidOrigin, x.a(str2));
                }
            }
        }
    }
}
