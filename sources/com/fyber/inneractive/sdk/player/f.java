package com.fyber.inneractive.sdk.player;

import android.content.Context;
import android.text.TextUtils;
import com.fyber.inneractive.sdk.config.IAConfigManager;
import com.fyber.inneractive.sdk.config.T;
import com.fyber.inneractive.sdk.config.U;
import com.fyber.inneractive.sdk.config.V;
import com.fyber.inneractive.sdk.config.enums.Skip;
import com.fyber.inneractive.sdk.config.enums.UnitDisplayType;
import com.fyber.inneractive.sdk.config.global.features.w;
import com.fyber.inneractive.sdk.external.InneractiveAdManager;
import com.fyber.inneractive.sdk.external.InneractiveAdRequest;
import com.fyber.inneractive.sdk.external.InneractiveVideoError;
import com.fyber.inneractive.sdk.flow.S;
import com.fyber.inneractive.sdk.model.vast.x;
import com.fyber.inneractive.sdk.network.C3146w;
import com.fyber.inneractive.sdk.network.C3147x;
import com.fyber.inneractive.sdk.network.EnumC3144u;
import com.fyber.inneractive.sdk.player.controller.C3150a;
import com.fyber.inneractive.sdk.player.controller.C3155f;
import com.fyber.inneractive.sdk.player.enums.VideoClickOrigin;
import com.fyber.inneractive.sdk.util.IAlog;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes12.dex */
public abstract class f implements com.fyber.inneractive.sdk.player.controller.p, com.fyber.inneractive.sdk.player.controller.o {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public com.fyber.inneractive.sdk.player.controller.q f2210a;
    public S b;
    public InneractiveAdRequest c;
    public com.fyber.inneractive.sdk.measurement.e d;
    public com.fyber.inneractive.sdk.measurement.g e;
    public q l;
    public int m;
    public com.fyber.inneractive.sdk.model.vast.r n;
    public p f = null;
    public boolean g = true;
    public boolean h = false;
    public volatile boolean i = false;
    public boolean j = false;
    public int k = 0;
    public final c o = new c(this);

    /* JADX WARN: Code duplicated, block: B:9:0x0032  */
    public f(Context context, com.fyber.inneractive.sdk.config.global.r rVar) {
        boolean zBooleanValue;
        com.fyber.inneractive.sdk.player.controller.q c3150a = null;
        if (rVar != null) {
            try {
                Boolean boolC = ((w) rVar.a(w.class)).c("use_fmp_cache_mechanism");
                if (boolC != null) {
                    zBooleanValue = boolC.booleanValue();
                } else {
                    zBooleanValue = false;
                }
                c3150a = new C3155f(context, zBooleanValue, rVar);
            } catch (Throwable th) {
                if (IAlog.f2345a <= 3) {
                    IAlog.a("Failed creating exo player", new Object[0]);
                    th.printStackTrace();
                }
            }
        } else {
            zBooleanValue = false;
            c3150a = new C3155f(context, zBooleanValue, rVar);
        }
        c3150a = c3150a == null ? new C3150a(context) : c3150a;
        this.f2210a = c3150a;
        if (!c3150a.b.contains(this)) {
            c3150a.b.add(this);
        }
        com.fyber.inneractive.sdk.player.controller.q qVar = this.f2210a;
        if (!qVar.c.contains(this)) {
            qVar.c.add(this);
        }
        this.f2210a.f = this.o;
    }

    public abstract void a(InneractiveVideoError inneractiveVideoError, JSONObject jSONObject);

    @Override // com.fyber.inneractive.sdk.player.controller.p
    public final void a(com.fyber.inneractive.sdk.player.mediaplayer.o oVar) {
        IAlog.a("IMediaPlayerFlowManager: onPlayerError called with: %s", oVar.getMessage());
        a(new InneractiveVideoError(InneractiveVideoError.Error.ERROR_FAILED_PLAYING_MEDIA_FILE, oVar), new JSONObject());
        if (this.h) {
            IAlog.a("IMediaPlayerFlowManager: onPlayerError video was prepared. This is a critical error. Aborting!", new Object[0]);
            a(new InneractiveVideoError(InneractiveVideoError.Error.ERROR_FAILED_PLAYING_ALL_MEDIA_FILES, oVar), new JSONObject());
        }
    }

    public abstract void a(com.fyber.inneractive.sdk.response.i iVar, VideoClickOrigin videoClickOrigin, x... xVarArr);

    @Override // com.fyber.inneractive.sdk.player.controller.p
    public final void c(boolean z) {
        try {
            S s = this.b;
            com.fyber.inneractive.sdk.response.g gVar = s != null ? (com.fyber.inneractive.sdk.response.g) s.b : null;
            EnumC3144u enumC3144u = EnumC3144u.VAST_MEDIA_LOAD_RETRY_ATTEMPTED;
            InneractiveAdRequest inneractiveAdRequest = this.c;
            S s2 = this.b;
            JSONArray jSONArrayB = s2 == null ? null : s2.c.b();
            C3146w c3146w = new C3146w(gVar);
            c3146w.c = enumC3144u;
            c3146w.f1934a = inneractiveAdRequest;
            c3146w.d = jSONArrayB;
            if (this.n != null && gVar != null) {
                c3146w.f.put(new C3147x().a(String.valueOf(z), "waudio").a(this.n.g, "url").a(this.n.e, "bitrate").a(TextUtils.isEmpty(this.n.d) ? "na" : this.n.d, "mime").a(this.n.f1886a, "delivery").a(Integer.valueOf(this.k), "media_file_index").a(this.f2210a.d(), "player").f1935a);
            }
            c3146w.a((String) null);
        } catch (Exception unused) {
        }
    }

    public static boolean a(int i, int i2, U u) {
        if (i2 == 1 || InneractiveAdManager.isCurrentUserAChild()) {
            return true;
        }
        if (i <= 15999) {
            return false;
        }
        V v = u != null ? ((T) u).f : null;
        return (v == null || v.h == Skip.DEFAULT || v.j == UnitDisplayType.REWARDED) ? false : true;
    }

    public static int a(f fVar) {
        com.fyber.inneractive.sdk.response.e eVar;
        S s = fVar.b;
        if (s == null || (eVar = s.b) == null) {
            return -1;
        }
        return ((com.fyber.inneractive.sdk.response.g) eVar).y;
    }

    public static boolean a(com.fyber.inneractive.sdk.config.global.r rVar, com.fyber.inneractive.sdk.ignite.m mVar) {
        mVar.getClass();
        if (mVar == com.fyber.inneractive.sdk.ignite.m.TRUE_SINGLE_TAP && IAConfigManager.O.E.n() && rVar != null && rVar.a(com.fyber.inneractive.sdk.config.global.features.o.class) != null) {
            Boolean boolC = ((com.fyber.inneractive.sdk.config.global.features.o) rVar.a(com.fyber.inneractive.sdk.config.global.features.o.class)).c("enable_app_info_button");
            if (boolC != null ? boolC.booleanValue() : true) {
                return true;
            }
        }
        return false;
    }
}
