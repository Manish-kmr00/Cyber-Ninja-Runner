package com.bytedance.sdk.openadsdk.multipro.aidl;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import android.os.RemoteException;
import com.bytedance.sdk.component.utils.SD;
import com.bytedance.sdk.openadsdk.IBinderPool;
import com.bytedance.sdk.openadsdk.core.aBv;
import com.bytedance.sdk.openadsdk.core.settings.oX;
import com.bytedance.sdk.openadsdk.multipro.aidl.pA.JG;
import com.bytedance.sdk.openadsdk.multipro.aidl.pA.ML;
import com.bytedance.sdk.openadsdk.multipro.aidl.pA.ZZv;

/* JADX INFO: loaded from: classes.dex */
public class BinderPoolService extends Service {
    private static boolean KZx;
    public static volatile boolean pA;
    private final Binder Og = new pA();

    @Override // android.app.Service
    public void onCreate() {
        super.onCreate();
        aBv.Og(getApplicationContext());
        pA = true;
        if (!KZx) {
            SD.Og().post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.multipro.aidl.BinderPoolService.1
                @Override // java.lang.Runnable
                public void run() {
                    oX.vkV().pA(BinderPoolService.this.getApplicationContext());
                }
            });
        }
        KZx = true;
    }

    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        return this.Og;
    }

    @Override // android.app.Service
    public void onDestroy() {
        super.onDestroy();
    }

    public static class pA extends IBinderPool.Stub {
        @Override // com.bytedance.sdk.openadsdk.IBinderPool
        public IBinder queryBinder(int i) throws RemoteException {
            if (i == 0) {
                return com.bytedance.sdk.openadsdk.multipro.aidl.pA.SD.pA();
            }
            if (i == 1) {
                return ML.pA();
            }
            if (i == 4) {
                return com.bytedance.sdk.openadsdk.multipro.aidl.pA.KZx.pA();
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
        }
    }
}
