package com.five_corp.ad;

import android.content.Context;
import android.graphics.Bitmap;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import android.view.View;
import android.widget.FrameLayout;
import com.five_corp.ad.internal.ad.s;
import com.five_corp.ad.internal.x;
import com.five_corp.ad.internal.y;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes6.dex */
public class FiveAdNative implements FiveAdInterface, com.five_corp.ad.internal.adselector.b, c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f1250a;
    public final j b;
    public final com.five_corp.ad.internal.context.i c;
    public final y d;
    public final com.five_corp.ad.internal.soundstate.c e;
    public final FrameLayout f;
    public final com.five_corp.ad.internal.logger.a g;
    public final Object h;
    public FiveAdState i;
    public f j;
    public x k;
    public final NativeMainView l;
    public final Handler m;
    public String n;

    public interface LoadImageCallback {
        void onImageLoad(Bitmap bitmap);
    }

    public FiveAdNative(Context context, j jVar, com.five_corp.ad.internal.context.l lVar, int i) {
        int i2;
        int i3;
        this.h = new Object();
        this.f1250a = context;
        this.b = jVar;
        this.c = lVar.d.f1370a;
        y yVar = new y(this);
        this.d = yVar;
        com.five_corp.ad.internal.soundstate.c cVar = new com.five_corp.ad.internal.soundstate.c(jVar.p.a());
        this.e = cVar;
        this.g = jVar.b;
        FrameLayout frameLayout = new FrameLayout(context);
        this.f = frameLayout;
        this.i = FiveAdState.LOADED;
        this.k = null;
        this.j = new f(context, jVar, frameLayout, yVar, cVar, lVar, this);
        NativeMainView nativeMainView = new NativeMainView(context, frameLayout, jVar.b, i);
        this.l = nativeMainView;
        com.five_corp.ad.internal.ad.custom_layout.d dVar = lVar.e.b;
        if (dVar != null && (i2 = dVar.f1277a) > 0 && (i3 = dVar.b) > 0) {
            nativeMainView.setConfigHeightToWidthRatio(((double) i3) / ((double) i2));
        }
        this.m = new Handler(Looper.getMainLooper());
    }

    public static /* synthetic */ void c(LoadImageCallback loadImageCallback) {
        Log.e("com.five_corp.ad.FiveAdNative", "You can use `loadInformationIconImageAsync` after ad is loaded.");
        loadImageCallback.onImageLoad(null);
    }

    public final f a() {
        f fVar;
        synchronized (this.h) {
            fVar = this.j;
        }
        return fVar;
    }

    public final com.five_corp.ad.internal.context.l b() {
        f fVarA = a();
        if (fVarA != null) {
            return fVarA.l;
        }
        return null;
    }

    @Override // com.five_corp.ad.FiveAdInterface
    public void enableSound(boolean z) {
        this.e.a(z);
    }

    public View getAdMainView() {
        return this.l;
    }

    public String getAdTitle() {
        String str;
        com.five_corp.ad.internal.context.l lVarB = b();
        return (lVarB == null || (str = lVarB.b.r) == null) ? "" : str;
    }

    public String getAdvertiserName() {
        String str;
        com.five_corp.ad.internal.context.l lVarB = b();
        return (lVarB == null || (str = lVarB.b.q) == null) ? "" : str;
    }

    public String getButtonText() {
        String str;
        com.five_corp.ad.internal.context.l lVarB = b();
        return (lVarB == null || (str = lVarB.b.s) == null) ? "" : str;
    }

    public int getContentViewLogicalHeight() {
        return this.l.getLogicalHeight();
    }

    public int getContentViewLogicalWidth() {
        return this.l.getLogicalWidth();
    }

    @Override // com.five_corp.ad.FiveAdInterface
    public CreativeType getCreativeType() {
        f fVarA = a();
        return fVarA != null ? fVarA.l.b.f1266a : CreativeType.NOT_LOADED;
    }

    public String getDescriptionText() {
        String str;
        com.five_corp.ad.internal.context.l lVarB = b();
        return (lVarB == null || (str = lVarB.b.t) == null) ? "" : str;
    }

    @Override // com.five_corp.ad.FiveAdInterface
    public String getFiveAdTag() {
        return this.n;
    }

    public String getLongDescriptionText() {
        String str;
        com.five_corp.ad.internal.context.l lVarB = b();
        return (lVarB == null || (str = lVarB.b.u) == null) ? "" : str;
    }

    @Override // com.five_corp.ad.FiveAdInterface
    public String getSlotId() {
        return this.c.b;
    }

    @Override // com.five_corp.ad.FiveAdInterface
    @Deprecated
    public FiveAdState getState() {
        FiveAdState fiveAdState;
        synchronized (this.h) {
            fiveAdState = this.i;
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
        synchronized (this.h) {
            if (this.i != FiveAdState.NOT_LOADED || this.k == null) {
                z = false;
            } else {
                this.i = FiveAdState.LOADING;
                z = true;
            }
        }
        if (z) {
            this.b.l.a(this.c, com.five_corp.ad.internal.context.h.NATIVE, this.e.a(), this);
            return;
        }
        y yVar = this.d;
        FiveAdErrorCode fiveAdErrorCode = FiveAdErrorCode.INVALID_STATE;
        FiveAdLoadListener fiveAdLoadListener = (FiveAdLoadListener) yVar.b.get();
        if (fiveAdLoadListener != 0) {
            fiveAdLoadListener.onFiveAdLoadError(yVar.f1593a, fiveAdErrorCode);
        }
        Log.e("com.five_corp.ad.FiveAdNative", "Invalid state, loadAdAsync is ignored.");
    }

    public void loadIconImageAsync(final LoadImageCallback loadImageCallback) {
        com.five_corp.ad.internal.context.l lVarB = b();
        if (lVarB == null) {
            this.m.post(new Runnable() { // from class: com.five_corp.ad.FiveAdNative$$ExternalSyntheticLambda0
                @Override // java.lang.Runnable
                public final void run() {
                    FiveAdNative.a(loadImageCallback);
                }
            });
            return;
        }
        s sVar = lVarB.b.n;
        if (sVar == null) {
            this.m.post(new Runnable() { // from class: com.five_corp.ad.FiveAdNative$$ExternalSyntheticLambda1
                @Override // java.lang.Runnable
                public final void run() {
                    loadImageCallback.onImageLoad(null);
                }
            });
        } else {
            lVarB.h.a(sVar, new l(loadImageCallback));
        }
    }

    public void loadInformationIconImageAsync(final LoadImageCallback loadImageCallback) {
        com.five_corp.ad.internal.context.l lVarB = b();
        if (lVarB == null) {
            this.m.post(new Runnable() { // from class: com.five_corp.ad.FiveAdNative$$ExternalSyntheticLambda2
                @Override // java.lang.Runnable
                public final void run() {
                    FiveAdNative.c(loadImageCallback);
                }
            });
            return;
        }
        s sVar = lVarB.b.o;
        if (sVar == null) {
            this.m.post(new Runnable() { // from class: com.five_corp.ad.FiveAdNative$$ExternalSyntheticLambda3
                @Override // java.lang.Runnable
                public final void run() {
                    loadImageCallback.onImageLoad(null);
                }
            });
        } else {
            lVarB.h.a(sVar, new m(loadImageCallback));
        }
    }

    @Override // com.five_corp.ad.c
    public void onAdControllerClose() {
        synchronized (this.h) {
            this.j = null;
            this.i = FiveAdState.CLOSED;
        }
    }

    @Override // com.five_corp.ad.c
    public void onAdControllerError() {
        synchronized (this.h) {
            this.i = FiveAdState.ERROR;
        }
    }

    @Override // com.five_corp.ad.internal.adselector.b
    public void onAdSuccessfullySelected(com.five_corp.ad.internal.context.l lVar) {
        x xVar;
        synchronized (this.h) {
            xVar = this.k;
            this.k = null;
        }
        com.five_corp.ad.internal.ad.custom_layout.d dVar = lVar.e.b;
        if (dVar == null || dVar.f1277a == 0 || dVar.b == 0) {
            synchronized (this.h) {
                this.i = FiveAdState.ERROR;
            }
            if (xVar != null) {
                xVar.b(this.c, com.five_corp.ad.internal.context.h.NATIVE, new com.five_corp.ad.internal.o(com.five_corp.ad.internal.p.I4, null, null, null));
                return;
            } else {
                this.g.a("notifyLoadError failed @ FiveAdInterstitial.onAdSuccessfullySelected", 4);
                return;
            }
        }
        f fVar = new f(this.f1250a, this.b, this.f, this.d, this.e, lVar, this);
        synchronized (this.h) {
            this.j = fVar;
            this.i = FiveAdState.LOADED;
        }
        this.l.setConfigHeightToWidthRatio(((double) dVar.b) / ((double) dVar.f1277a));
        if (xVar != null) {
            xVar.b(lVar);
        } else {
            this.g.a("notifyLoad failed @ FiveAdInterstitial.onAdSuccessfullySelected", 4);
        }
    }

    @Override // com.five_corp.ad.internal.adselector.b
    public void onFailureToSelectAd(com.five_corp.ad.internal.o oVar) {
        x xVar;
        synchronized (this.h) {
            xVar = this.k;
            this.k = null;
            this.i = FiveAdState.ERROR;
        }
        if (xVar != null) {
            xVar.b(this.c, com.five_corp.ad.internal.context.h.NATIVE, oVar);
        } else {
            this.g.a("notifyLoadError failed @ FiveAdInterstitial.onFailureToSelectAd", 4);
        }
    }

    public void registerFriendlyObstructionView(View view) {
        f fVarA = a();
        if (fVarA == null) {
            Log.e("com.five_corp.ad.FiveAdNative", "You can call `registerFriendlyObstructionView` after ad is loaded.");
            return;
        }
        com.five_corp.ad.internal.context.l lVar = fVarA.l;
        if (lVar.f == com.five_corp.ad.internal.context.h.NATIVE || lVar.d.c.f) {
            fVarA.i.a(view, 4);
        } else {
            Log.e("com.five_corp.ad.f", "`registerFriendlyObstructionView` is not allowed.");
        }
    }

    public void registerViews(View view, View view2, List<View> list) {
        f fVarA = a();
        if (fVarA == null) {
            Log.e("com.five_corp.ad.FiveAdNative", "You can call `registerViews` after ad is loaded.");
            return;
        }
        fVarA.i.f = view;
        if (view2 != null) {
            view2.setOnClickListener(new n(fVarA));
        }
        Iterator<View> it = list.iterator();
        while (it.hasNext()) {
            it.next().setOnClickListener(new o(fVarA));
        }
    }

    public void setEventListener(FiveAdNativeEventListener fiveAdNativeEventListener) {
        y yVar = this.d;
        yVar.d.set(new com.five_corp.ad.internal.f(fiveAdNativeEventListener, this));
        y yVar2 = this.d;
        yVar2.f.set(com.five_corp.ad.internal.m.a(fiveAdNativeEventListener, this));
    }

    @Override // com.five_corp.ad.FiveAdInterface
    public void setFiveAdTag(String str) {
        this.n = str;
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

    public static /* synthetic */ void a(LoadImageCallback loadImageCallback) {
        Log.e("com.five_corp.ad.FiveAdNative", "You can use `loadIconImageAsync` after ad is loaded.");
        loadImageCallback.onImageLoad(null);
    }

    public FiveAdNative(Context context, String str) {
        this(context, str, 0);
    }

    public FiveAdNative(Context context, String str, int i) {
        this.h = new Object();
        this.f1250a = context;
        j jVar = k.a().f1596a;
        this.b = jVar;
        this.c = jVar.k.a(str);
        y yVar = new y(this);
        this.d = yVar;
        com.five_corp.ad.internal.soundstate.c cVar = new com.five_corp.ad.internal.soundstate.c(jVar.p.a());
        this.e = cVar;
        this.g = jVar.b;
        FrameLayout frameLayout = new FrameLayout(context);
        this.f = frameLayout;
        this.i = FiveAdState.NOT_LOADED;
        this.k = new x(yVar, jVar.q, cVar, jVar.f1595a);
        this.j = null;
        this.l = new NativeMainView(context, frameLayout, jVar.b, i);
        this.m = new Handler(Looper.getMainLooper());
    }
}
