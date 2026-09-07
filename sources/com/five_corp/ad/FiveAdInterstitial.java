package com.five_corp.ad;

import android.app.Activity;
import android.content.Context;
import android.util.Log;
import com.five_corp.ad.internal.C2977d;
import com.five_corp.ad.internal.s;
import com.five_corp.ad.internal.x;
import com.five_corp.ad.internal.y;

/* JADX INFO: loaded from: classes13.dex */
public class FiveAdInterstitial implements FiveAdInterface, com.five_corp.ad.internal.adselector.b, c {
    public static final String l = FiveAdInterstitial.class.toString();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f1249a;
    public final j b;
    public final com.five_corp.ad.internal.context.i c;
    public final y d;
    public final com.five_corp.ad.internal.soundstate.c e;
    public final com.five_corp.ad.internal.logger.a f;
    public final Object g;
    public FiveAdState h;
    public f i;
    public x j;
    public String k;

    public FiveAdInterstitial(Activity activity, String str) {
        this(activity.getApplicationContext(), str);
    }

    @Override // com.five_corp.ad.FiveAdInterface
    public void enableSound(boolean z) {
        this.e.a(z);
    }

    @Override // com.five_corp.ad.FiveAdInterface
    public CreativeType getCreativeType() {
        f fVar;
        synchronized (this.g) {
            fVar = this.i;
        }
        return fVar != null ? fVar.l.b.f1266a : CreativeType.NOT_LOADED;
    }

    @Override // com.five_corp.ad.FiveAdInterface
    public String getFiveAdTag() {
        return this.k;
    }

    @Override // com.five_corp.ad.FiveAdInterface
    public String getSlotId() {
        return this.c.b;
    }

    @Override // com.five_corp.ad.FiveAdInterface
    @Deprecated
    public FiveAdState getState() {
        FiveAdState fiveAdState;
        synchronized (this.g) {
            fiveAdState = this.h;
        }
        return fiveAdState;
    }

    @Override // com.five_corp.ad.FiveAdInterface
    public boolean isSoundEnabled() {
        return this.e.a().a();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v3, types: [com.five_corp.ad.FiveAdInterface, java.lang.Object] */
    public void loadAdAsync() {
        boolean z;
        synchronized (this.g) {
            if (this.h != FiveAdState.NOT_LOADED || this.j == null) {
                z = false;
            } else {
                this.h = FiveAdState.LOADING;
                z = true;
            }
        }
        if (z) {
            this.b.l.a(this.c, com.five_corp.ad.internal.context.h.INTERSTITIAL, this.e.a(), this);
            return;
        }
        y yVar = this.d;
        FiveAdErrorCode fiveAdErrorCode = FiveAdErrorCode.INVALID_STATE;
        FiveAdLoadListener fiveAdLoadListener = (FiveAdLoadListener) yVar.b.get();
        if (fiveAdLoadListener != 0) {
            fiveAdLoadListener.onFiveAdLoadError(yVar.f1593a, fiveAdErrorCode);
        }
        Log.e(l, "Invalid state, loadAdAsync is ignored.");
    }

    @Override // com.five_corp.ad.c
    public void onAdControllerClose() {
        synchronized (this.g) {
            this.i = null;
            this.h = FiveAdState.CLOSED;
        }
    }

    @Override // com.five_corp.ad.c
    public void onAdControllerError() {
        synchronized (this.g) {
            this.i = null;
            this.h = FiveAdState.ERROR;
        }
    }

    @Override // com.five_corp.ad.internal.adselector.b
    public void onAdSuccessfullySelected(com.five_corp.ad.internal.context.l lVar) {
        x xVar;
        synchronized (this.g) {
            xVar = this.j;
            this.j = null;
        }
        f fVar = new f(this.f1249a, this.b, null, this.d, this.e, lVar, this);
        synchronized (this.g) {
            this.i = fVar;
            this.h = FiveAdState.LOADED;
        }
        if (xVar != null) {
            xVar.b(lVar);
        } else {
            this.f.a("notifyLoad failed @ FiveAdInterstitial.onAdSuccessfullySelected", 4);
        }
    }

    @Override // com.five_corp.ad.internal.adselector.b
    public void onFailureToSelectAd(com.five_corp.ad.internal.o oVar) {
        x xVar;
        synchronized (this.g) {
            xVar = this.j;
            this.j = null;
            this.h = FiveAdState.ERROR;
        }
        if (xVar != null) {
            xVar.b(this.c, com.five_corp.ad.internal.context.h.INTERSTITIAL, oVar);
        } else {
            this.f.a("notifyLoadError failed @ FiveAdInterstitial.onFailureToSelectAd", 4);
        }
    }

    public void setEventListener(FiveAdInterstitialEventListener fiveAdInterstitialEventListener) {
        y yVar = this.d;
        yVar.d.set(new C2977d(fiveAdInterstitialEventListener, this));
        y yVar2 = this.d;
        yVar2.e.set(new s(fiveAdInterstitialEventListener, this));
    }

    @Override // com.five_corp.ad.FiveAdInterface
    public void setFiveAdTag(String str) {
        this.k = str;
    }

    @Override // com.five_corp.ad.FiveAdInterface
    public void setLoadListener(FiveAdLoadListener fiveAdLoadListener) {
        this.d.b.set(fiveAdLoadListener);
    }

    @Override // com.five_corp.ad.FiveAdInterface
    @Deprecated
    public void setViewEventListener(FiveAdViewEventListener fiveAdViewEventListener) {
        this.d.c.set(fiveAdViewEventListener);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r3v0, types: [com.five_corp.ad.FiveAdInterface, java.lang.Object] */
    @Deprecated
    public boolean show() {
        f fVar;
        synchronized (this.g) {
            fVar = this.i;
        }
        if (fVar != null) {
            return fVar.q();
        }
        y yVar = this.d;
        FiveAdErrorCode fiveAdErrorCode = FiveAdErrorCode.INVALID_STATE;
        FiveAdViewEventListener fiveAdViewEventListener = (FiveAdViewEventListener) yVar.c.get();
        if (fiveAdViewEventListener != 0) {
            fiveAdViewEventListener.onFiveAdViewError(yVar.f1593a, fiveAdErrorCode);
        }
        com.five_corp.ad.internal.g gVar = (com.five_corp.ad.internal.g) yVar.d.get();
        if (gVar != null) {
            gVar.a(fiveAdErrorCode);
        }
        Log.e(l, "Invalid state, showAd is ignored.");
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r3v0, types: [com.five_corp.ad.FiveAdInterface, java.lang.Object] */
    public void showAd() {
        f fVar;
        synchronized (this.g) {
            fVar = this.i;
        }
        if (fVar != null) {
            fVar.q();
            return;
        }
        y yVar = this.d;
        FiveAdErrorCode fiveAdErrorCode = FiveAdErrorCode.INVALID_STATE;
        FiveAdViewEventListener fiveAdViewEventListener = (FiveAdViewEventListener) yVar.c.get();
        if (fiveAdViewEventListener != 0) {
            fiveAdViewEventListener.onFiveAdViewError(yVar.f1593a, fiveAdErrorCode);
        }
        com.five_corp.ad.internal.g gVar = (com.five_corp.ad.internal.g) yVar.d.get();
        if (gVar != null) {
            gVar.a(fiveAdErrorCode);
        }
        Log.e(l, "Invalid state, showAd is ignored.");
    }

    public FiveAdInterstitial(Context context, j jVar, com.five_corp.ad.internal.context.l lVar) {
        this.g = new Object();
        this.k = null;
        this.b = jVar;
        this.f1249a = context;
        this.c = lVar.d.f1370a;
        y yVar = new y(this);
        this.d = yVar;
        com.five_corp.ad.internal.soundstate.c cVar = new com.five_corp.ad.internal.soundstate.c(jVar.p.a());
        this.e = cVar;
        this.f = jVar.b;
        this.h = FiveAdState.LOADED;
        this.j = null;
        this.i = new f(context, jVar, null, yVar, cVar, lVar, this);
    }

    public FiveAdInterstitial(Context context, String str) {
        this.g = new Object();
        this.k = null;
        j jVar = k.a().f1596a;
        this.b = jVar;
        this.f1249a = context;
        this.c = jVar.k.a(str);
        y yVar = new y(this);
        this.d = yVar;
        com.five_corp.ad.internal.soundstate.c cVar = new com.five_corp.ad.internal.soundstate.c(jVar.p.a());
        this.e = cVar;
        this.f = jVar.b;
        this.h = FiveAdState.NOT_LOADED;
        this.j = new x(yVar, jVar.q, cVar, jVar.f1595a);
        this.i = null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v0, types: [com.five_corp.ad.FiveAdInterface, java.lang.Object] */
    @Deprecated
    public boolean show(Activity activity) {
        f fVar;
        synchronized (this.g) {
            fVar = this.i;
        }
        if (fVar != null) {
            return fVar.q();
        }
        y yVar = this.d;
        FiveAdErrorCode fiveAdErrorCode = FiveAdErrorCode.INVALID_STATE;
        FiveAdViewEventListener fiveAdViewEventListener = (FiveAdViewEventListener) yVar.c.get();
        if (fiveAdViewEventListener != 0) {
            fiveAdViewEventListener.onFiveAdViewError(yVar.f1593a, fiveAdErrorCode);
        }
        com.five_corp.ad.internal.g gVar = (com.five_corp.ad.internal.g) yVar.d.get();
        if (gVar != null) {
            gVar.a(fiveAdErrorCode);
        }
        Log.e(l, "Invalid state, showAd is ignored.");
        return false;
    }
}
