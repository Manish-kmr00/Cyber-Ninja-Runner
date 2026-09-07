package com.bytedance.sdk.openadsdk.component;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Looper;
import android.os.RemoteException;
import android.os.SystemClock;
import com.bytedance.sdk.component.omh.omh;
import com.bytedance.sdk.component.utils.WV;
import com.bytedance.sdk.openadsdk.AdSlot;
import com.bytedance.sdk.openadsdk.IListenerManager;
import com.bytedance.sdk.openadsdk.TTAdConstant;
import com.bytedance.sdk.openadsdk.activity.TTAppOpenAdActivity;
import com.bytedance.sdk.openadsdk.api.open.PAGAppOpenAd;
import com.bytedance.sdk.openadsdk.api.open.PAGAppOpenAdInteractionCallback;
import com.bytedance.sdk.openadsdk.api.open.PAGAppOpenAdInteractionListener;
import com.bytedance.sdk.openadsdk.core.Sn;
import com.bytedance.sdk.openadsdk.core.TV;
import com.bytedance.sdk.openadsdk.core.aBv;
import com.bytedance.sdk.openadsdk.core.model.yFO;
import com.bytedance.sdk.openadsdk.core.settings.oX;
import com.bytedance.sdk.openadsdk.oem.IPMiBroadcastReceiver;
import com.bytedance.sdk.openadsdk.utils.Mc;
import com.bytedance.sdk.openadsdk.utils.WQf;
import com.bytedance.sdk.openadsdk.utils.xy;
import com.google.firebase.analytics.FirebaseAnalytics;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes10.dex */
public class ZZv extends PAGAppOpenAd {
    private boolean Bzk;
    private final AdSlot KZx;
    private final yFO Og;
    private final boolean SD;
    private com.bytedance.sdk.openadsdk.pA.ZZv.Og ZZv;
    private boolean omh;
    private final Context pA;
    private final AtomicBoolean ML = new AtomicBoolean(false);
    private final String JG = WQf.pA();

    public ZZv(Context context, yFO yfo, boolean z, AdSlot adSlot) {
        this.pA = context;
        this.Og = yfo;
        this.SD = z;
        this.KZx = adSlot;
    }

    @Override // com.bytedance.sdk.openadsdk.api.open.PAGAppOpenAd
    public void setAdInteractionListener(PAGAppOpenAdInteractionListener pAGAppOpenAdInteractionListener) {
        this.ZZv = new ML(pAGAppOpenAdInteractionListener);
        pA();
    }

    @Override // com.bytedance.sdk.openadsdk.api.open.PAGAppOpenAd
    public void setAdInteractionCallback(PAGAppOpenAdInteractionCallback pAGAppOpenAdInteractionCallback) {
        this.ZZv = new ML(pAGAppOpenAdInteractionCallback);
        pA();
    }

    private void pA() {
        if (com.bytedance.sdk.openadsdk.multipro.Og.KZx()) {
            xy.KZx(new omh("AppOpenAd_registerMultiProcessListener") { // from class: com.bytedance.sdk.openadsdk.component.ZZv.1
                @Override // java.lang.Runnable
                public void run() {
                    IListenerManager iListenerManagerAsInterface;
                    com.bytedance.sdk.openadsdk.multipro.aidl.pA pAVarPA = com.bytedance.sdk.openadsdk.multipro.aidl.pA.pA();
                    if (ZZv.this.ZZv == null || (iListenerManagerAsInterface = com.bytedance.sdk.openadsdk.multipro.aidl.pA.Og.asInterface(pAVarPA.pA(7))) == null) {
                        return;
                    }
                    try {
                        iListenerManagerAsInterface.registerAppOpenAdListener(ZZv.this.JG, new com.bytedance.sdk.openadsdk.multipro.aidl.Og.pA(ZZv.this.ZZv));
                        ZZv.this.ZZv = null;
                    } catch (RemoteException e) {
                        WV.pA("TTAppOpenAdImpl", e.getMessage());
                    }
                }
            }, 5);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.api.open.PAGAppOpenAd
    public void show(Activity activity) {
        int rotation;
        if (activity != null && activity.isFinishing()) {
            activity = null;
        }
        if (this.ML.getAndSet(true)) {
            com.bytedance.sdk.openadsdk.pA.ZZv.Og og = this.ZZv;
            if (og != null) {
                og.Og();
            }
            com.bytedance.sdk.openadsdk.Sn.KZx.KZx("activity_start_repeat");
            return;
        }
        if (Looper.getMainLooper() != Looper.myLooper()) {
            WV.pA("TTAppOpenAdImpl", "showTTAppOpenAd error: not main looper");
            throw new IllegalStateException("Cannot be called in a child thread ---- TTAppOpenAdImpl.showAppOpenAd");
        }
        IPMiBroadcastReceiver.pA(this.pA, this.Og);
        Context contextPA = activity != null ? activity : this.pA;
        if (contextPA == null) {
            contextPA = aBv.pA();
        }
        try {
            rotation = activity.getWindowManager().getDefaultDisplay().getRotation();
        } catch (Exception unused) {
            rotation = 0;
        }
        Intent intent = new Intent(contextPA, (Class<?>) TTAppOpenAdActivity.class);
        intent.putExtra("orientation_angle", rotation);
        intent.putExtra(FirebaseAnalytics.Param.AD_SOURCE, this.SD ? 1 : 2);
        if (com.bytedance.sdk.openadsdk.multipro.Og.KZx()) {
            intent.putExtra(TTAdConstant.MULTI_PROCESS_MATERIALMETA, this.Og.jO().toString());
            intent.putExtra(TTAdConstant.MULTI_PROCESS_META_MD5, this.JG);
        } else {
            TV.pA().JG();
            TV.pA().pA(this.Og);
            TV.pA().pA(this.ZZv);
            this.ZZv = null;
        }
        intent.putExtra("start_show_time", SystemClock.elapsedRealtime());
        com.bytedance.sdk.component.utils.Og.pA(contextPA, intent, new com.bytedance.sdk.component.utils.Og.InterfaceC0208Og() { // from class: com.bytedance.sdk.openadsdk.component.ZZv.2
            @Override // com.bytedance.sdk.component.utils.Og.InterfaceC0208Og
            public void pA() {
            }

            @Override // com.bytedance.sdk.component.utils.Og.InterfaceC0208Og
            public void pA(Throwable th) {
                com.bytedance.sdk.openadsdk.pA.ZZv.Og ogML = TV.pA().ML();
                if (ogML != null) {
                    ogML.Og();
                }
                com.bytedance.sdk.openadsdk.Sn.KZx.KZx("activity_start_fail");
            }
        });
        Sn.Og().post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.component.ZZv.3
            @Override // java.lang.Runnable
            public void run() {
                if (ZZv.this.KZx != null) {
                    try {
                        if (oX.vkV().TV(ZZv.this.KZx.getCodeId()) != 1 || yFO.JG(ZZv.this.Og)) {
                            return;
                        }
                        JG jgPA = JG.pA(ZZv.this.pA);
                        jgPA.SD(Integer.parseInt(ZZv.this.KZx.getCodeId()));
                        jgPA.pA(ZZv.this.KZx);
                    } catch (Throwable unused2) {
                    }
                }
            }
        });
    }

    @Override // com.bytedance.sdk.openadsdk.api.PAGClientBidding
    public void win(Double d) {
        if (this.omh) {
            return;
        }
        Mc.pA(this.Og, d);
        this.omh = true;
    }

    @Override // com.bytedance.sdk.openadsdk.api.PAGClientBidding
    public void loss(Double d, String str, String str2) {
        if (this.Bzk) {
            return;
        }
        Mc.pA(this.Og, d, str, str2);
        this.Bzk = true;
    }

    @Override // com.bytedance.sdk.openadsdk.api.PangleAd
    public Map<String, Object> getMediaExtraInfo() {
        yFO yfo = this.Og;
        if (yfo != null) {
            return yfo.tZW();
        }
        return null;
    }

    @Override // com.bytedance.sdk.openadsdk.api.PangleAd
    public Object getExtraInfo(String str) {
        yFO yfo = this.Og;
        if (yfo == null || yfo.tZW() == null) {
            return null;
        }
        try {
            return this.Og.tZW().get(str);
        } catch (Throwable th) {
            WV.pA("TTAppOpenAdImpl", th.getMessage());
            return null;
        }
    }
}
