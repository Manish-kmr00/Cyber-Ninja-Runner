package com.fyber.inneractive.sdk.web;

import android.content.Context;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import com.fyber.inneractive.sdk.config.IAConfigManager;
import com.fyber.inneractive.sdk.util.IAlog;
import com.safedk.android.analytics.brandsafety.creatives.CreativeInfoManager;
import com.safedk.android.utils.Logger;

/* JADX INFO: loaded from: classes13.dex */
public final class Z implements View.OnTouchListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Y f2399a;
    public float b;
    public float c;
    public final float d;

    public Z(Y y, Context context) {
        this.f2399a = y;
        this.d = ViewConfiguration.get(context).getScaledTouchSlop();
    }

    @Override // android.view.View.OnTouchListener
    public final boolean onTouch(View view, MotionEvent motionEvent) {
        Logger.d("DTExchange|SafeDK: Execution> Lcom/fyber/inneractive/sdk/web/Z;->onTouch(Landroid/view/View;Landroid/view/MotionEvent;)Z");
        CreativeInfoManager.onViewTouched(com.safedk.android.utils.h.p, view, motionEvent);
        return safedk_Z_onTouch_de0598ffeedb2d3e5e2babfbbffc5548(view, motionEvent);
    }

    public boolean safedk_Z_onTouch_de0598ffeedb2d3e5e2babfbbffc5548(View p0, MotionEvent p1) {
        if (this.f2399a != null) {
            if (p1.getActionMasked() == 0) {
                ((AbstractC3270i) this.f2399a).i();
                this.b = p1.getX();
                this.c = p1.getY();
            } else if (p1.getActionMasked() == 3) {
                ((AbstractC3270i) this.f2399a).i();
                this.c = -1.0f;
                this.b = -1.0f;
            } else if (p1.getActionMasked() == 1) {
                float f = this.b;
                if (f >= 0.0f && this.c >= 0.0f) {
                    float fRound = Math.round(Math.abs(f - p1.getX()));
                    float fRound2 = Math.round(Math.abs(this.c - p1.getY()));
                    float f2 = this.d;
                    if (fRound < f2 && fRound2 < f2) {
                        AbstractC3270i abstractC3270i = (AbstractC3270i) this.f2399a;
                        abstractC3270i.getClass();
                        IAlog.a("IAWebViewController onClicked()", new Object[0]);
                        if (abstractC3270i.l != null) {
                            IAlog.e("Native click detected in time. Processing pending click", new Object[0]);
                            abstractC3270i.l.d();
                            RunnableC3265d runnableC3265d = abstractC3270i.m;
                            if (runnableC3265d != null) {
                                com.fyber.inneractive.sdk.util.r.b.removeCallbacks(runnableC3265d);
                            }
                            abstractC3270i.l = null;
                            abstractC3270i.i();
                        } else {
                            if (abstractC3270i.n != null) {
                                com.fyber.inneractive.sdk.util.r.b.postDelayed(abstractC3270i.n, IAConfigManager.O.u.b.a("click_timeout", 1000, 1000));
                            }
                            abstractC3270i.j = true;
                        }
                    }
                    this.b = -1.0f;
                    this.c = -1.0f;
                }
            }
        }
        return false;
    }
}
