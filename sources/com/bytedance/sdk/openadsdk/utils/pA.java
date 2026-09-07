package com.bytedance.sdk.openadsdk.utils;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import android.view.View;
import android.view.Window;
import com.bytedance.sdk.openadsdk.ApmHelper;
import java.lang.ref.WeakReference;
import java.util.LinkedList;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes6.dex */
public class pA implements Application.ActivityLifecycleCallbacks {
    public static long KZx;
    public static long Og;
    public static boolean pA;
    private volatile WeakReference<Activity> Wx;
    private final AtomicBoolean ZZv = new AtomicBoolean(false);
    private final RunnableC0257pA ML = new RunnableC0257pA();
    private final ZZv JG = new ZZv();
    private final KZx SD = new KZx();
    private final Og omh = new Og();
    private int Bzk = 0;
    private volatile CopyOnWriteArrayList<WeakReference<com.bytedance.sdk.component.adexpress.pA>> SGo = new CopyOnWriteArrayList<>();
    private HandlerThread BSW = null;
    private Handler WV = null;
    private final LinkedList<Activity> Sn = new LinkedList<>();

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
    }

    public pA() {
        KZx();
    }

    private void KZx() {
        HandlerThread handlerThread = new HandlerThread("lifecycle", 10);
        this.BSW = handlerThread;
        handlerThread.start();
        this.WV = new Handler(this.BSW.getLooper());
    }

    private void pA(Runnable runnable) {
        if (!this.BSW.isAlive()) {
            KZx();
        }
        this.WV.postDelayed(runnable, 1000L);
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityCreated(Activity activity, Bundle bundle) {
        this.Sn.addFirst(activity);
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityStarted(final Activity activity) {
        Window window;
        if (Vgu.Og() && (window = activity.getWindow()) != null) {
            final View decorView = window.getDecorView();
            decorView.addOnAttachStateChangeListener(new View.OnAttachStateChangeListener() { // from class: com.bytedance.sdk.openadsdk.utils.pA.1
                @Override // android.view.View.OnAttachStateChangeListener
                public void onViewAttachedToWindow(View view) {
                    decorView.removeOnAttachStateChangeListener(this);
                    if (Vgu.ZZv(activity)) {
                        Vgu.pA(true);
                    }
                }

                @Override // android.view.View.OnAttachStateChangeListener
                public void onViewDetachedFromWindow(View view) {
                    decorView.removeOnAttachStateChangeListener(this);
                }
            });
        }
        this.Bzk++;
        this.WV.removeCallbacks(this.omh);
        if (this.ZZv.get()) {
            pA(this.omh);
        }
        this.ZZv.set(false);
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityResumed(Activity activity) {
        pA(this.JG);
        if (!pA) {
            Og = System.currentTimeMillis();
            pA = true;
        }
        this.Wx = new WeakReference<>(activity);
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityPaused(Activity activity) {
        int i = this.Bzk - 1;
        this.Bzk = i;
        if (i < 0) {
            this.Bzk = 0;
        }
        if (ApmHelper.isIsInit()) {
            pA(this.SD);
        }
    }

    /* JADX INFO: renamed from: com.bytedance.sdk.openadsdk.utils.pA$pA, reason: collision with other inner class name */
    static class RunnableC0257pA implements Runnable {
        RunnableC0257pA() {
        }

        @Override // java.lang.Runnable
        public void run() {
            xy.KZx(new com.bytedance.sdk.component.omh.omh("reportPvFromBackGround") { // from class: com.bytedance.sdk.openadsdk.utils.pA.pA.1
                @Override // java.lang.Runnable
                public void run() {
                    ApmHelper.reportPvFromBackGround();
                }
            });
        }
    }

    class ZZv implements Runnable {
        ZZv() {
        }

        @Override // java.lang.Runnable
        public void run() {
            com.bytedance.sdk.openadsdk.core.Sn.Og().removeMessages(1001);
            if (com.bytedance.sdk.openadsdk.core.aBv.pA() == null) {
                return;
            }
            com.bytedance.sdk.openadsdk.core.SGo.pA.Og();
        }
    }

    class KZx implements Runnable {
        KZx() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (ApmHelper.isIsInit()) {
                Handler handlerOg = com.bytedance.sdk.openadsdk.core.Sn.Og();
                Message messageObtain = Message.obtain(handlerOg, pA.this.ML);
                messageObtain.what = 1001;
                handlerOg.sendMessageDelayed(messageObtain, 30000L);
            }
        }
    }

    private static class Og implements Runnable {
        private Og() {
        }

        @Override // java.lang.Runnable
        public void run() {
            com.bytedance.sdk.openadsdk.JG.Og.pA().Og();
            com.bytedance.sdk.openadsdk.ZZv.pA.Sn snRtW = com.bytedance.sdk.openadsdk.core.settings.oX.vkV().rtW();
            if (snRtW == null || snRtW.pA() || !com.bytedance.sdk.component.utils.DX.omh(com.bytedance.sdk.openadsdk.core.aBv.pA())) {
                return;
            }
            com.bytedance.sdk.openadsdk.ZZv.pA.ZZv.pA(com.bytedance.sdk.openadsdk.core.WV.pA(com.bytedance.sdk.openadsdk.core.aBv.pA()));
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityStopped(Activity activity) {
        if (this.Bzk <= 0) {
            this.ZZv.set(true);
        }
        if (pA()) {
            pA = false;
            com.bytedance.sdk.openadsdk.core.Sn.Og.set(false);
            KZx = System.currentTimeMillis();
            pA(this.omh);
        }
        pA(new ML(Og, KZx, pA()));
    }

    public class ML implements Runnable {
        private long KZx;
        private long Og;
        private boolean ZZv;

        public ML(long j, long j2, boolean z) {
            this.Og = j;
            this.KZx = j2;
            this.ZZv = z;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.ZZv) {
                com.bytedance.sdk.openadsdk.Sn.KZx.pA().pA(this.Og / 1000, this.KZx / 1000);
            }
            pA.this.ZZv();
        }
    }

    public void pA(com.bytedance.sdk.component.adexpress.pA pAVar) {
        this.SGo.add(new WeakReference<>(pAVar));
    }

    public boolean Og(com.bytedance.sdk.component.adexpress.pA pAVar) {
        return this.SGo.remove(new WeakReference(pAVar));
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityDestroyed(Activity activity) {
        if (this.SGo != null && this.SGo.size() > 0) {
            for (WeakReference<com.bytedance.sdk.component.adexpress.pA> weakReference : this.SGo) {
                if (weakReference != null && weakReference.get() != null) {
                    try {
                        weakReference.get().pA(activity);
                    } catch (Throwable unused) {
                    }
                }
            }
        }
        if (this.Wx != null && this.Wx.get() == activity) {
            this.Wx = null;
        }
        this.Sn.remove(activity);
    }

    public boolean pA() {
        return this.ZZv.get();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ZZv() {
        com.bytedance.sdk.openadsdk.ZZv.pA.pA.pA();
    }

    public boolean pA(boolean z) {
        Activity activity;
        Window window;
        return (this.Wx == null || (activity = this.Wx.get()) == null || (window = activity.getWindow()) == null) ? z : window.getDecorView().hasWindowFocus();
    }

    public Activity Og() {
        if (this.Sn.isEmpty()) {
            return null;
        }
        return this.Sn.getFirst();
    }
}
