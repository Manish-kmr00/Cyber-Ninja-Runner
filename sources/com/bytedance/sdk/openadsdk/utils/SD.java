package com.bytedance.sdk.openadsdk.utils;

import android.app.Activity;
import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes6.dex */
public class SD implements WV, Runnable {
    private boolean JG;
    private long ML;
    private final Activity Og;
    private final pA SD;
    private long ZZv;
    private boolean omh;
    private final AtomicBoolean Bzk = new AtomicBoolean(false);
    private final Handler KZx = new Handler(Looper.getMainLooper());
    private View pA = ZZv();

    public interface pA {
        void Og();

        View pA();
    }

    public static WV pA(Activity activity, pA pAVar) {
        int iGuZ = com.bytedance.sdk.openadsdk.core.settings.oX.vkV().guZ();
        if (iGuZ < 0) {
            return new WV() { // from class: com.bytedance.sdk.openadsdk.utils.SD.1
                @Override // com.bytedance.sdk.openadsdk.utils.WV
                public void KZx() {
                }

                @Override // com.bytedance.sdk.openadsdk.utils.WV
                public void Og() {
                }

                @Override // com.bytedance.sdk.openadsdk.utils.WV
                public void pA() {
                }

                @Override // com.bytedance.sdk.openadsdk.utils.WV
                public void pA(long j) {
                }
            };
        }
        return new SD(activity, Math.min(iGuZ, 50) * 1000, pAVar);
    }

    private SD(Activity activity, int i, pA pAVar) {
        this.SD = pAVar;
        this.Og = activity;
        this.ZZv = i;
    }

    private View ZZv() {
        pA pAVar = this.SD;
        if (pAVar != null) {
            return pAVar.pA();
        }
        return null;
    }

    @Override // com.bytedance.sdk.openadsdk.utils.WV
    public void pA(long j) {
        if (this.Bzk.compareAndSet(false, true)) {
            if (j < 0) {
                j = 0;
            }
            this.ZZv += j;
            ML();
        }
    }

    @Override // com.bytedance.sdk.openadsdk.utils.WV
    public void pA() {
        if (this.ML == 0 || !this.omh) {
            return;
        }
        ML();
    }

    private void ML() {
        this.omh = false;
        this.ML = SystemClock.elapsedRealtime();
        Handler handler = this.KZx;
        if (handler != null) {
            handler.postDelayed(this, this.ZZv);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.utils.WV
    public void Og() {
        if (this.ML <= 0 || this.JG) {
            return;
        }
        if (!this.omh) {
            this.ZZv -= SystemClock.elapsedRealtime() - this.ML;
        }
        this.omh = true;
        if (this.ZZv <= 0) {
            JG();
            return;
        }
        Handler handler = this.KZx;
        if (handler != null) {
            try {
                handler.removeCallbacks(this);
            } catch (Throwable th) {
                com.bytedance.sdk.component.utils.WV.Og(th.getMessage());
            }
        }
    }

    @Override // java.lang.Runnable
    public void run() {
        JG();
    }

    private void JG() {
        Activity activity;
        View childAt;
        if (this.JG || (activity = this.Og) == null || activity.isFinishing() || this.Og.isDestroyed()) {
            return;
        }
        if (this.pA == null) {
            this.pA = ZZv();
        }
        View view = this.pA;
        if (view != null) {
            if (Og(view)) {
                pA(this.pA);
                View view2 = this.pA;
                if ((view2 instanceof ViewGroup) && ((ViewGroup) view2).getChildCount() > 0 && (childAt = ((ViewGroup) this.pA).getChildAt(0)) != null && Og(childAt)) {
                    pA(childAt);
                }
                pA pAVar = this.SD;
                if (pAVar != null) {
                    pAVar.Og();
                }
            }
            SD();
        }
        this.JG = true;
    }

    private void SD() {
        ViewParent parent = this.pA.getParent();
        if (parent instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) parent;
            if (viewGroup.indexOfChild(this.pA) != viewGroup.getChildCount() - 1) {
                this.pA.bringToFront();
            }
        }
    }

    private void pA(View view) {
        view.setVisibility(0);
        view.setAlpha(1.0f);
    }

    private boolean Og(View view) {
        if (view == null) {
            return true;
        }
        return !view.isShown() || ((double) view.getAlpha()) <= 0.9d;
    }

    @Override // com.bytedance.sdk.openadsdk.utils.WV
    public void KZx() {
        if (this.JG) {
            return;
        }
        this.JG = true;
        Handler handler = this.KZx;
        if (handler != null) {
            try {
                handler.removeCallbacks(this);
            } catch (Throwable th) {
                com.bytedance.sdk.component.utils.WV.Og(th.getMessage());
            }
        }
    }
}
