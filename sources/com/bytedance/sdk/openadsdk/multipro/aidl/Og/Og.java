package com.bytedance.sdk.openadsdk.multipro.aidl.Og;

import android.os.RemoteException;
import com.bytedance.sdk.openadsdk.IDislikeClosedListener;
import com.bytedance.sdk.openadsdk.KZx.SGo;
import com.bytedance.sdk.openadsdk.utils.xy;

/* JADX INFO: loaded from: classes12.dex */
public class Og extends IDislikeClosedListener.Stub {
    private final String Og;
    private final com.bytedance.sdk.openadsdk.core.KZx.ZZv.pA pA;

    public Og(String str, com.bytedance.sdk.openadsdk.core.KZx.ZZv.pA pAVar) {
        this.Og = str;
        this.pA = pAVar;
    }

    @Override // com.bytedance.sdk.openadsdk.IDislikeClosedListener
    public void onItemClickClosed() throws RemoteException {
        xy.pA(new Runnable() { // from class: com.bytedance.sdk.openadsdk.multipro.aidl.Og.Og.1
            @Override // java.lang.Runnable
            public void run() {
                if (Og.this.pA != null) {
                    Og.this.pA.pA();
                    SGo.pA(6, Og.this.Og);
                }
            }
        });
    }
}
