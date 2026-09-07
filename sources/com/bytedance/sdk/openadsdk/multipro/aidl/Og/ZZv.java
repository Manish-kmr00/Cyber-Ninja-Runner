package com.bytedance.sdk.openadsdk.multipro.aidl.Og;

import android.os.RemoteException;
import com.bytedance.sdk.openadsdk.IRewardAdInteractionListener;
import com.bytedance.sdk.openadsdk.utils.xy;

/* JADX INFO: loaded from: classes13.dex */
public class ZZv extends IRewardAdInteractionListener.Stub {
    private com.bytedance.sdk.openadsdk.pA.ML.pA pA;

    @Override // com.bytedance.sdk.openadsdk.IRewardAdInteractionListener
    public void onDestroy() throws RemoteException {
    }

    public ZZv(com.bytedance.sdk.openadsdk.pA.ML.pA pAVar) {
        this.pA = pAVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void pA() {
        this.pA = null;
    }

    @Override // com.bytedance.sdk.openadsdk.IRewardAdInteractionListener
    public void onAdShow() throws RemoteException {
        if (this.pA == null) {
            return;
        }
        xy.pA(new Runnable() { // from class: com.bytedance.sdk.openadsdk.multipro.aidl.Og.ZZv.1
            @Override // java.lang.Runnable
            public void run() {
                if (ZZv.this.pA != null) {
                    ZZv.this.pA.pA();
                }
            }
        });
    }

    @Override // com.bytedance.sdk.openadsdk.IRewardAdInteractionListener
    public void onAdVideoBarClick() throws RemoteException {
        if (this.pA == null) {
            return;
        }
        xy.pA(new Runnable() { // from class: com.bytedance.sdk.openadsdk.multipro.aidl.Og.ZZv.2
            @Override // java.lang.Runnable
            public void run() {
                if (ZZv.this.pA != null) {
                    ZZv.this.pA.onAdClicked();
                }
            }
        });
    }

    @Override // com.bytedance.sdk.openadsdk.IRewardAdInteractionListener
    public void onAdClose() throws RemoteException {
        if (this.pA == null) {
            return;
        }
        xy.pA(new Runnable() { // from class: com.bytedance.sdk.openadsdk.multipro.aidl.Og.ZZv.3
            @Override // java.lang.Runnable
            public void run() {
                if (ZZv.this.pA != null) {
                    ZZv.this.pA.Og();
                }
                ZZv.this.pA();
            }
        });
    }

    @Override // com.bytedance.sdk.openadsdk.IRewardAdInteractionListener
    public void onRewardVerify(final boolean z, final int i, final String str, final int i2, final String str2) throws RemoteException {
        if (this.pA == null) {
            return;
        }
        xy.pA(new Runnable() { // from class: com.bytedance.sdk.openadsdk.multipro.aidl.Og.ZZv.4
            @Override // java.lang.Runnable
            public void run() {
                if (ZZv.this.pA != null) {
                    ZZv.this.pA.pA(z, i, str, i2, str2);
                }
            }
        });
    }
}
