package com.five_corp.ad;

import android.content.Context;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.FrameLayout;
import com.five_corp.ad.internal.C2976c;
import com.five_corp.ad.internal.x;
import com.five_corp.ad.internal.y;
import com.safedk.android.analytics.brandsafety.DetectTouchUtils;

/* JADX INFO: loaded from: classes3.dex */
public class FiveAdCustomLayout extends FrameLayout implements FiveAdInterface, com.five_corp.ad.internal.adselector.b, c {
    public static final String o = FiveAdCustomLayout.class.toString();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f1246a;
    public final Context b;
    public final j c;
    public final com.five_corp.ad.internal.context.i d;
    public final y e;
    public final com.five_corp.ad.internal.soundstate.c f;
    public final FrameLayout g;
    public final com.five_corp.ad.internal.logger.a h;
    public final Object i;
    public FiveAdState j;
    public f k;
    public x l;
    public final int m;
    public boolean n;

    public FiveAdCustomLayout(Context context) {
        super(context);
        this.f1246a = null;
        this.i = new Object();
        this.n = false;
        throw new IllegalArgumentException("please use other constructor.");
    }

    private f getAdController() {
        f fVar;
        synchronized (this.i) {
            fVar = this.k;
        }
        return fVar;
    }

    private com.five_corp.ad.internal.ad.custom_layout.d getCustomLayoutConfig() {
        com.five_corp.ad.internal.view.l lVar;
        f adController = getAdController();
        if (adController == null || (lVar = adController.c) == null) {
            return null;
        }
        return lVar.getCustomLayoutConfig();
    }

    private com.five_corp.ad.internal.context.l getLoadedContext() {
        f adController = getAdController();
        if (adController != null) {
            return adController.l;
        }
        return null;
    }

    public final void a(int i, int i2) {
        com.five_corp.ad.internal.ad.custom_layout.d customLayoutConfig = getCustomLayoutConfig();
        if (customLayoutConfig == null) {
            return;
        }
        if (customLayoutConfig.f1277a * i2 < customLayoutConfig.b * i) {
            this.g.setLayoutParams(new FrameLayout.LayoutParams((customLayoutConfig.f1277a * i2) / customLayoutConfig.b, i2, 17));
        } else {
            this.g.setLayoutParams(new FrameLayout.LayoutParams(i, (customLayoutConfig.b * i) / customLayoutConfig.f1277a, 17));
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent me) {
        DetectTouchUtils.viewOnTouch("com.five_corp.ad", this, me);
        return super.dispatchTouchEvent(me);
    }

    @Override // com.five_corp.ad.FiveAdInterface
    public void enableSound(boolean z) {
        this.f.a(z);
    }

    public String getAdvertiserName() {
        String str;
        com.five_corp.ad.internal.context.l loadedContext = getLoadedContext();
        return (loadedContext == null || (str = loadedContext.b.q) == null) ? "" : str;
    }

    @Override // com.five_corp.ad.FiveAdInterface
    public CreativeType getCreativeType() {
        f adController = getAdController();
        return adController != null ? adController.l.b.f1266a : CreativeType.NOT_LOADED;
    }

    @Override // com.five_corp.ad.FiveAdInterface
    public String getFiveAdTag() {
        return this.f1246a;
    }

    public int getLogicalHeight() {
        if (this.n) {
            return getHeight();
        }
        int i = this.m;
        com.five_corp.ad.internal.ad.custom_layout.d customLayoutConfig = getCustomLayoutConfig();
        if (getState() != FiveAdState.LOADED || customLayoutConfig == null) {
            return 0;
        }
        return (i * customLayoutConfig.b) / customLayoutConfig.f1277a;
    }

    public int getLogicalWidth() {
        return this.n ? getWidth() : this.m;
    }

    @Override // com.five_corp.ad.FiveAdInterface
    public String getSlotId() {
        return this.d.b;
    }

    @Override // com.five_corp.ad.FiveAdInterface
    @Deprecated
    public FiveAdState getState() {
        FiveAdState fiveAdState;
        synchronized (this.i) {
            fiveAdState = this.j;
        }
        return fiveAdState;
    }

    @Override // com.five_corp.ad.FiveAdInterface
    public boolean isSoundEnabled() {
        return this.f.a().a();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v3, types: [com.five_corp.ad.FiveAdInterface, java.lang.Object] */
    public void loadAdAsync() {
        boolean z;
        synchronized (this.i) {
            if (this.j != FiveAdState.NOT_LOADED || this.l == null) {
                z = false;
            } else {
                this.j = FiveAdState.LOADING;
                z = true;
            }
        }
        if (z) {
            this.c.l.a(this.d, com.five_corp.ad.internal.context.h.CUSTOM_LAYOUT, this.f.a(), this);
            return;
        }
        y yVar = this.e;
        FiveAdErrorCode fiveAdErrorCode = FiveAdErrorCode.INVALID_STATE;
        FiveAdLoadListener fiveAdLoadListener = (FiveAdLoadListener) yVar.b.get();
        if (fiveAdLoadListener != 0) {
            fiveAdLoadListener.onFiveAdLoadError(yVar.f1593a, fiveAdErrorCode);
        }
        Log.e(o, "Invalid state, loadAdAsync is ignored.");
    }

    @Override // com.five_corp.ad.c
    public void onAdControllerClose() {
        synchronized (this.i) {
            this.k = null;
            this.j = FiveAdState.CLOSED;
        }
    }

    @Override // com.five_corp.ad.c
    public void onAdControllerError() {
        synchronized (this.i) {
            this.j = FiveAdState.ERROR;
        }
    }

    @Override // com.five_corp.ad.internal.adselector.b
    public void onAdSuccessfullySelected(com.five_corp.ad.internal.context.l lVar) {
        x xVar;
        synchronized (this.i) {
            xVar = this.l;
            this.l = null;
        }
        f fVar = new f(this.b, this.c, this.g, this.e, this.f, lVar, this);
        synchronized (this.i) {
            this.k = fVar;
            this.j = FiveAdState.LOADED;
        }
        if (xVar != null) {
            xVar.b(lVar);
        } else {
            this.h.a("notifyLoad failed @ FiveAdInterstitial.onAdSuccessfullySelected", 4);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.n = true;
    }

    @Override // com.five_corp.ad.internal.adselector.b
    public void onFailureToSelectAd(com.five_corp.ad.internal.o oVar) {
        x xVar;
        synchronized (this.i) {
            xVar = this.l;
            this.l = null;
            this.j = FiveAdState.ERROR;
        }
        if (xVar != null) {
            xVar.b(this.d, com.five_corp.ad.internal.context.h.CUSTOM_LAYOUT, oVar);
        } else {
            this.h.a("notifyLoadError failed @ FiveAdInterstitial.onFailureToSelectAd", 4);
        }
    }

    @Override // android.widget.FrameLayout, android.view.View
    public final void onMeasure(int i, int i2) {
        try {
            int i3 = this.m;
            int i4 = 0;
            if (i3 <= 0) {
                if (View.MeasureSpec.getMode(i) == 0) {
                    int size = View.MeasureSpec.getSize(i2);
                    com.five_corp.ad.internal.ad.custom_layout.d customLayoutConfig = getCustomLayoutConfig();
                    if (getState() == FiveAdState.LOADED && customLayoutConfig != null) {
                        i4 = (size * customLayoutConfig.f1277a) / customLayoutConfig.b;
                    }
                    i = View.MeasureSpec.makeMeasureSpec(i4, 1073741824);
                } else if (View.MeasureSpec.getMode(i2) == 0) {
                    int size2 = View.MeasureSpec.getSize(i);
                    com.five_corp.ad.internal.ad.custom_layout.d customLayoutConfig2 = getCustomLayoutConfig();
                    if (getState() == FiveAdState.LOADED && customLayoutConfig2 != null) {
                        i4 = (size2 * customLayoutConfig2.b) / customLayoutConfig2.f1277a;
                    }
                }
                a(View.MeasureSpec.getSize(i), View.MeasureSpec.getSize(i2));
                super.onMeasure(i, i2);
            }
            i = View.MeasureSpec.makeMeasureSpec(i3, 1073741824);
            int i5 = this.m;
            com.five_corp.ad.internal.ad.custom_layout.d customLayoutConfig3 = getCustomLayoutConfig();
            if (getState() == FiveAdState.LOADED && customLayoutConfig3 != null) {
                i4 = (i5 * customLayoutConfig3.b) / customLayoutConfig3.f1277a;
            }
            i2 = View.MeasureSpec.makeMeasureSpec(i4, 1073741824);
            a(View.MeasureSpec.getSize(i), View.MeasureSpec.getSize(i2));
        } catch (Throwable th) {
            this.h.a(th);
        }
        super.onMeasure(i, i2);
    }

    public void registerFriendlyObstructionView(View view) {
        f adController = getAdController();
        if (adController == null) {
            Log.e(o, "You can call `registerFriendlyObstructionView` after ad is loaded.");
            return;
        }
        com.five_corp.ad.internal.context.l lVar = adController.l;
        if (lVar.f == com.five_corp.ad.internal.context.h.NATIVE || lVar.d.c.f) {
            adController.i.a(view, 4);
        } else {
            Log.e("com.five_corp.ad.f", "`registerFriendlyObstructionView` is not allowed.");
        }
    }

    public void setEventListener(FiveAdCustomLayoutEventListener fiveAdCustomLayoutEventListener) {
        y yVar = this.e;
        yVar.d.set(new C2976c(fiveAdCustomLayoutEventListener, this));
        y yVar2 = this.e;
        yVar2.f.set(com.five_corp.ad.internal.m.a(fiveAdCustomLayoutEventListener, this));
    }

    @Override // com.five_corp.ad.FiveAdInterface
    public void setFiveAdTag(String str) {
        this.f1246a = str;
    }

    @Override // com.five_corp.ad.FiveAdInterface
    public void setLoadListener(FiveAdLoadListener fiveAdLoadListener) {
        this.e.b.set(fiveAdLoadListener);
    }

    @Override // com.five_corp.ad.FiveAdInterface
    @Deprecated
    public void setViewEventListener(FiveAdViewEventListener fiveAdViewEventListener) {
        this.e.c.set(fiveAdViewEventListener);
    }

    public FiveAdCustomLayout(Context context, j jVar, com.five_corp.ad.internal.context.l lVar, int i) {
        super(context);
        this.f1246a = null;
        this.i = new Object();
        this.n = false;
        this.c = jVar;
        this.b = context;
        this.d = lVar.d.f1370a;
        y yVar = new y(this);
        this.e = yVar;
        com.five_corp.ad.internal.soundstate.c cVar = new com.five_corp.ad.internal.soundstate.c(jVar.p.a());
        this.f = cVar;
        FrameLayout frameLayout = new FrameLayout(context);
        this.g = frameLayout;
        this.h = jVar.b;
        this.j = FiveAdState.LOADED;
        this.l = null;
        this.k = new f(context, jVar, frameLayout, yVar, cVar, lVar, this);
        this.m = i;
        addView(frameLayout);
    }

    public FiveAdCustomLayout(Context context, String str) {
        this(context, str, 0);
    }

    public FiveAdCustomLayout(Context context, String str, int i) {
        super(context);
        this.f1246a = null;
        this.i = new Object();
        this.n = false;
        j jVar = k.a().f1596a;
        this.c = jVar;
        this.b = context;
        this.d = jVar.k.a(str);
        y yVar = new y(this);
        this.e = yVar;
        com.five_corp.ad.internal.soundstate.c cVar = new com.five_corp.ad.internal.soundstate.c(jVar.p.a());
        this.f = cVar;
        FrameLayout frameLayout = new FrameLayout(context);
        this.g = frameLayout;
        this.h = jVar.b;
        this.j = FiveAdState.NOT_LOADED;
        this.l = new x(yVar, jVar.q, cVar, jVar.f1595a);
        this.k = null;
        this.m = i;
        addView(frameLayout);
    }
}
