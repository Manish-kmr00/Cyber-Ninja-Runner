package com.fyber.inneractive.sdk.dv;

import com.fyber.inneractive.sdk.config.enums.UnitDisplayType;
import com.fyber.inneractive.sdk.external.InneractiveAdRequest;
import com.fyber.inneractive.sdk.external.InneractiveErrorCode;
import com.fyber.inneractive.sdk.external.InneractiveInfrastructureError;
import com.fyber.inneractive.sdk.flow.AbstractC3106k;
import com.fyber.inneractive.sdk.flow.EnumC3104i;
import com.fyber.inneractive.sdk.flow.x;
import com.fyber.inneractive.sdk.util.IAlog;
import com.fyber.inneractive.sdk.util.r;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.ads.query.AdInfo;
import com.google.android.gms.ads.query.QueryInfo;

/* JADX INFO: loaded from: classes3.dex */
public final class c extends AbstractC3106k {
    public final boolean m;

    public c() {
        boolean z;
        try {
            Class.forName("com.google.android.gms.ads.InterstitialAd");
            z = true;
        } catch (ClassNotFoundException unused) {
            z = false;
        }
        this.m = !z;
    }

    @Override // com.fyber.inneractive.sdk.flow.AbstractC3106k, com.fyber.inneractive.sdk.interfaces.b
    public final void a() {
        x xVar = this.c;
        if (xVar != null) {
            a aVar = (a) xVar;
            aVar.g = null;
            aVar.i = null;
        }
        super.a();
    }

    @Override // com.fyber.inneractive.sdk.flow.AbstractC3106k, com.fyber.inneractive.sdk.interfaces.c
    public final void cancel() {
        x xVar = this.c;
        if (xVar != null) {
            a aVar = (a) xVar;
            aVar.g = null;
            aVar.i = null;
        }
        this.k.a();
        IAlog.a("%s: IAAdContentLoaderImpl : cancel load ad content retry task", IAlog.a(this));
        r.b.removeCallbacks(this.l);
        this.f1803a = null;
        this.b = null;
        this.c = null;
        this.d = null;
        this.e = null;
        this.f = null;
    }

    @Override // com.fyber.inneractive.sdk.flow.AbstractC3106k
    public final String d() {
        return null;
    }

    @Override // com.fyber.inneractive.sdk.flow.AbstractC3106k
    public final void g() {
        x dVar;
        com.fyber.inneractive.sdk.response.e eVar = this.b;
        if (eVar == null || ((i) eVar).u == null) {
            i();
            return;
        }
        InneractiveAdRequest inneractiveAdRequest = this.f1803a;
        if (inneractiveAdRequest != null) {
            boolean muteVideo = inneractiveAdRequest.getMuteVideo();
            try {
                MobileAds.setAppMuted(muteVideo);
                MobileAds.setAppVolume(muteVideo ? 0.0f : 1.0f);
            } catch (Throwable unused) {
            }
        }
        i iVar = (i) this.b;
        UnitDisplayType unitDisplayType = iVar.p;
        QueryInfo queryInfo = iVar.u.f1743a;
        int i = b.f1732a[unitDisplayType.ordinal()];
        if (i == 1) {
            dVar = this.m ? new com.fyber.inneractive.sdk.dv.interstitial.d(e(), this.g, (i) this.b) : new com.fyber.inneractive.sdk.dv.interstitial.g(e(), this.g, (i) this.b);
        } else if (i == 2 || i == 3) {
            dVar = new com.fyber.inneractive.sdk.dv.banner.b(e(), this.g, (i) this.b);
        } else if (i != 4) {
            dVar = null;
        } else {
            dVar = this.m ? new com.fyber.inneractive.sdk.dv.rewarded.d(e(), this.g, (i) this.b) : new com.fyber.inneractive.sdk.dv.rewarded.g(e(), this.g, (i) this.b);
        }
        this.c = dVar;
        if (queryInfo == null || dVar == null || this.b == null) {
            i();
            return;
        }
        try {
            AdRequest.Builder builder = new AdRequest.Builder();
            try {
                builder.getClass().getMethod("setAdString", String.class).invoke(builder, ((i) this.b).M);
            } catch (Exception unused2) {
                builder.setAdInfo(new AdInfo(queryInfo, ((i) this.b).M));
            }
            ((a) this.c).a(builder.build(), this);
        } catch (Throwable unused3) {
            i();
        }
    }

    public final void i() {
        a(new InneractiveInfrastructureError(InneractiveErrorCode.SDK_INTERNAL_ERROR, EnumC3104i.NETWORK_ERROR));
    }
}
