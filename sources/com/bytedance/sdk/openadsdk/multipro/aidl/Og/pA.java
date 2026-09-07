package com.bytedance.sdk.openadsdk.multipro.aidl.Og;

import android.os.RemoteException;
import com.bytedance.sdk.openadsdk.IAppOpenAdInteractionListener;
import com.bytedance.sdk.openadsdk.utils.xy;

/* JADX INFO: loaded from: classes5.dex */
public class pA extends IAppOpenAdInteractionListener.Stub {
    private com.bytedance.sdk.openadsdk.pA.ZZv.Og pA;

    public pA(com.bytedance.sdk.openadsdk.pA.ZZv.Og og) {
        this.pA = og;
    }

    private void pA() {
        this.pA = null;
    }

    @Override // com.bytedance.sdk.openadsdk.IAppOpenAdInteractionListener
    public void onDestroy() throws RemoteException {
        pA();
    }

    @Override // com.bytedance.sdk.openadsdk.IAppOpenAdInteractionListener
    public void onAdShow() throws RemoteException {
        if (this.pA == null) {
            return;
        }
        xy.pA(new Runnable() { // from class: com.bytedance.sdk.openadsdk.multipro.aidl.Og.pA.1
            @Override // java.lang.Runnable
            public void run() {
                if (pA.this.pA != null) {
                    pA.this.pA.pA();
                }
            }
        });
    }

    @Override // com.bytedance.sdk.openadsdk.IAppOpenAdInteractionListener
    public void onAdClicked() throws RemoteException {
        if (this.pA == null) {
            return;
        }
        xy.pA(new Runnable() { // from class: com.bytedance.sdk.openadsdk.multipro.aidl.Og.pA.2
            @Override // java.lang.Runnable
            public void run() {
                if (pA.this.pA != null) {
                    pA.this.pA.onAdClicked();
                }
            }
        });
    }

    @Override // com.bytedance.sdk.openadsdk.IAppOpenAdInteractionListener
    public void onAdSkip() throws RemoteException {
        if (this.pA == null) {
            return;
        }
        xy.pA(new Runnable() { // from class: com.bytedance.sdk.openadsdk.multipro.aidl.Og.pA.3
            @Override // java.lang.Runnable
            public void run() {
                if (pA.this.pA != null) {
                    pA.this.pA.Og();
                }
            }
        });
    }

    @Override // com.bytedance.sdk.openadsdk.IAppOpenAdInteractionListener
    public void onAdTimeOver() throws RemoteException {
        if (this.pA == null) {
            return;
        }
        xy.pA(new Runnable() { // from class: com.bytedance.sdk.openadsdk.multipro.aidl.Og.pA.4
            @Override // java.lang.Runnable
            public void run() {
                if (pA.this.pA != null) {
                    pA.this.pA.KZx();
                }
            }
        });
    }
}
