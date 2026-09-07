package com.bytedance.sdk.openadsdk.multipro.aidl;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.RemoteException;
import com.bytedance.sdk.component.omh.omh;
import com.bytedance.sdk.component.utils.WV;
import com.bytedance.sdk.openadsdk.IBinderPool;
import com.bytedance.sdk.openadsdk.core.aBv;
import com.bytedance.sdk.openadsdk.multipro.aidl.pA.JG;
import com.bytedance.sdk.openadsdk.multipro.aidl.pA.ML;
import com.bytedance.sdk.openadsdk.multipro.aidl.pA.SD;
import com.bytedance.sdk.openadsdk.multipro.aidl.pA.ZZv;
import com.bytedance.sdk.openadsdk.utils.gbA;
import com.bytedance.sdk.openadsdk.utils.xy;

/* JADX INFO: loaded from: classes10.dex */
public class pA {
    private static final pA Og = new pA();
    private Og KZx;
    private IBinderPool pA;
    private long ZZv = 0;
    private final ServiceConnection ML = new ServiceConnection() { // from class: com.bytedance.sdk.openadsdk.multipro.aidl.pA.2
        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName componentName) {
        }

        @Override // android.content.ServiceConnection
        public void onServiceConnected(ComponentName componentName, final IBinder iBinder) {
            xy.pA(new omh("onServiceConnected") { // from class: com.bytedance.sdk.openadsdk.multipro.aidl.pA.2.1
                @Override // java.lang.Runnable
                public void run() {
                    pA.this.pA = IBinderPool.Stub.asInterface(iBinder);
                    try {
                        pA.this.pA.asBinder().linkToDeath(pA.this.JG, 0);
                    } catch (RemoteException e) {
                        WV.pA("TTAD.BinderPool", "onServiceConnected throws :", e);
                    }
                    System.currentTimeMillis();
                    long unused = pA.this.ZZv;
                    if (pA.this.KZx != null) {
                        pA.this.KZx.onServiceConnected();
                    }
                }
            }, 5);
        }
    };
    private final IBinder.DeathRecipient JG = new IBinder.DeathRecipient() { // from class: com.bytedance.sdk.openadsdk.multipro.aidl.pA.3
        @Override // android.os.IBinder.DeathRecipient
        public void binderDied() {
            xy.pA(new omh("binderDied") { // from class: com.bytedance.sdk.openadsdk.multipro.aidl.pA.3.1
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        if (pA.this.pA.asBinder().isBinderAlive()) {
                            pA.this.pA.asBinder().unlinkToDeath(pA.this.JG, 0);
                        }
                    } catch (Exception e) {
                        WV.pA("TTAD.BinderPool", e.getMessage());
                    }
                    pA.this.pA = null;
                    pA.this.ZZv();
                }
            }, 5);
        }
    };

    private pA() {
        ZZv();
    }

    public static pA pA() {
        return Og;
    }

    public void Og() {
        try {
            Context contextPA = aBv.pA();
            contextPA.startService(new Intent(contextPA, (Class<?>) BinderPoolService.class));
        } catch (Exception unused) {
        }
    }

    public void KZx() {
        try {
            Context contextPA = aBv.pA();
            contextPA.bindService(new Intent(contextPA, (Class<?>) BinderPoolService.class), this.ML, 1);
            this.ZZv = System.currentTimeMillis();
        } catch (Throwable unused) {
        }
    }

    public void pA(Og og) {
        this.KZx = og;
        if (this.pA != null) {
            xy.pA(new omh("onServiceConnected2") { // from class: com.bytedance.sdk.openadsdk.multipro.aidl.pA.1
                @Override // java.lang.Runnable
                public void run() {
                    if (pA.this.KZx != null) {
                        pA.this.KZx.onServiceConnected();
                    }
                }
            }, 5);
        }
    }

    public IBinder pA(int i) {
        try {
            if (com.bytedance.sdk.openadsdk.multipro.Og.KZx()) {
                try {
                    IBinderPool iBinderPool = this.pA;
                    if (iBinderPool != null) {
                        return iBinderPool.queryBinder(i);
                    }
                    return null;
                } catch (RemoteException e) {
                    WV.pA("TTAD.BinderPool", e.getMessage());
                    gbA.omh("queryBinder error");
                    return null;
                }
            }
            if (i == 0) {
                return SD.pA();
            }
            if (i == 1) {
                return ML.pA();
            }
            if (i == 5) {
                return JG.Og();
            }
            if (i == 6) {
                return ZZv.pA();
            }
            if (i != 7) {
                return null;
            }
            return com.bytedance.sdk.openadsdk.multipro.aidl.pA.Og.pA();
        } catch (Throwable unused) {
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ZZv() {
        if (com.bytedance.sdk.openadsdk.multipro.Og.KZx()) {
            KZx();
        }
    }
}
