package com.bytedance.sdk.openadsdk.multipro.aidl.Og;

import android.os.RemoteException;
import com.bytedance.sdk.openadsdk.IFullScreenVideoAdInteractionListener;
import com.bytedance.sdk.openadsdk.utils.xy;

/* JADX INFO: loaded from: classes9.dex */
public class KZx extends IFullScreenVideoAdInteractionListener.Stub {
    private com.bytedance.sdk.openadsdk.pA.KZx.Og pA;

    @Override // com.bytedance.sdk.openadsdk.IFullScreenVideoAdInteractionListener
    public void onDestroy() throws RemoteException {
    }

    public KZx(com.bytedance.sdk.openadsdk.pA.KZx.Og og) {
        this.pA = og;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void pA() {
        this.pA = null;
    }

    @Override // com.bytedance.sdk.openadsdk.IFullScreenVideoAdInteractionListener
    public void onAdShow() throws RemoteException {
        if (this.pA == null) {
            return;
        }
        xy.pA(new Runnable() { // from class: com.bytedance.sdk.openadsdk.multipro.aidl.Og.KZx.1
            @Override // java.lang.Runnable
            public void run() {
                if (KZx.this.pA != null) {
                    KZx.this.pA.pA();
                }
            }
        });
    }

    @Override // com.bytedance.sdk.openadsdk.IFullScreenVideoAdInteractionListener
    public void onAdVideoBarClick() throws RemoteException {
        if (this.pA == null) {
            return;
        }
        xy.pA(new Runnable() { // from class: com.bytedance.sdk.openadsdk.multipro.aidl.Og.KZx.2
            @Override // java.lang.Runnable
            public void run() {
                if (KZx.this.pA != null) {
                    KZx.this.pA.onAdClicked();
                }
            }
        });
    }

    @Override // com.bytedance.sdk.openadsdk.IFullScreenVideoAdInteractionListener
    public void onAdClose() throws RemoteException {
        if (this.pA == null) {
            return;
        }
        xy.pA(new Runnable() { // from class: com.bytedance.sdk.openadsdk.multipro.aidl.Og.KZx.3
            @Override // java.lang.Runnable
            public void run() {
                if (KZx.this.pA != null) {
                    KZx.this.pA.Og();
                }
                KZx.this.pA();
            }
        });
    }
}
