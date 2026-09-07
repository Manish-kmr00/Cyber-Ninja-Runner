package com.bytedance.sdk.openadsdk.component.reward;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.RemoteException;
import android.os.SystemClock;
import com.bytedance.sdk.openadsdk.IListenerManager;
import com.bytedance.sdk.openadsdk.activity.TTAdActivity;
import com.bytedance.sdk.openadsdk.activity.TTFullScreenExpressVideoActivity;
import com.bytedance.sdk.openadsdk.activity.TTFullScreenVideoActivity;
import com.bytedance.sdk.openadsdk.activity.TTInterstitialActivity;
import com.bytedance.sdk.openadsdk.activity.TTInterstitialExpressActivity;
import com.bytedance.sdk.openadsdk.api.interstitial.PAGInterstitialAd;
import com.bytedance.sdk.openadsdk.api.interstitial.PAGInterstitialAdInteractionCallback;
import com.bytedance.sdk.openadsdk.api.interstitial.PAGInterstitialAdInteractionListener;
import com.bytedance.sdk.openadsdk.core.TV;
import com.bytedance.sdk.openadsdk.core.aBv;
import com.bytedance.sdk.openadsdk.core.model.yFO;
import com.bytedance.sdk.openadsdk.core.settings.oX;
import com.bytedance.sdk.openadsdk.oem.IPMiBroadcastReceiver;
import com.bytedance.sdk.openadsdk.utils.Mc;
import com.bytedance.sdk.openadsdk.utils.WQf;
import com.bytedance.sdk.openadsdk.utils.xy;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes5.dex */
class JG extends PAGInterstitialAd {
    private boolean Bzk;
    private com.bytedance.sdk.openadsdk.pA.KZx.Og KZx;
    private final com.bytedance.sdk.openadsdk.core.model.pA Og;
    private boolean omh;
    private final Context pA;
    private final AtomicBoolean ML = new AtomicBoolean(false);
    private boolean JG = false;
    private boolean ZZv = false;
    private final String SD = WQf.pA();

    JG(Context context, com.bytedance.sdk.openadsdk.core.model.pA pAVar) {
        this.pA = context;
        this.Og = pAVar;
    }

    public void pA(boolean z) {
        this.JG = z;
    }

    public void pA() {
        if (this.ML.get()) {
            return;
        }
        this.ZZv = true;
    }

    @Override // com.bytedance.sdk.openadsdk.api.interstitial.PAGInterstitialAd
    public void setAdInteractionListener(PAGInterstitialAdInteractionListener pAGInterstitialAdInteractionListener) {
        this.KZx = new com.bytedance.sdk.openadsdk.component.KZx.pA(pAGInterstitialAdInteractionListener);
        pA(1);
    }

    @Override // com.bytedance.sdk.openadsdk.api.interstitial.PAGInterstitialAd
    public void setAdInteractionCallback(PAGInterstitialAdInteractionCallback pAGInterstitialAdInteractionCallback) {
        this.KZx = new com.bytedance.sdk.openadsdk.component.KZx.pA(pAGInterstitialAdInteractionCallback);
        pA(1);
    }

    private static boolean pA(yFO yfo) {
        if (yfo == null) {
            return false;
        }
        int iABv = yfo.aBv();
        return (yfo.BF() != 2 || iABv == 5 || iABv == 33 || iABv == 6 || iABv == 19 || iABv == 12) ? false : true;
    }

    @Override // com.bytedance.sdk.openadsdk.api.interstitial.PAGInterstitialAd
    public void show(Activity activity) {
        Intent intent;
        if (activity != null && activity.isFinishing()) {
            com.bytedance.sdk.component.utils.WV.pA("TTFullScreenVideoAdImpl", "showFullScreenVideoAd error1: activity is finishing");
            activity = null;
        }
        com.bytedance.sdk.openadsdk.core.model.pA pAVar = this.Og;
        if (pAVar == null || !pAVar.ML()) {
            return;
        }
        boolean zSD = this.Og.SD();
        final yFO yfoJG = this.Og.JG();
        if (!com.bykv.vk.openvk.pA.pA.Og.KZx.pA.Og()) {
            com.bytedance.sdk.openadsdk.ZZv.KZx.pA(yfoJG, "fullscreen_interstitial_ad", "showFullScreenVideoAd error2: not main looper");
            com.bytedance.sdk.component.utils.WV.pA("TTFullScreenVideoAdImpl", "showFullScreenVideoAd error2: not main looper");
            throw new IllegalStateException("Cannot be called in a child thread —— TTFullScreenVideoAd.showFullScreenVideoAd");
        }
        List<yFO> listZZv = this.Og.ZZv();
        if (listZZv != null) {
            Iterator<yFO> it = listZZv.iterator();
            while (it.hasNext()) {
                IPMiBroadcastReceiver.pA(this.pA, it.next());
            }
        }
        if (this.ML.get()) {
            return;
        }
        this.ML.set(true);
        if (yfoJG == null || (yfoJG.Bf() == null && yfoJG.IIF() == null)) {
            com.bytedance.sdk.openadsdk.ZZv.KZx.pA(yfoJG, "fullscreen_interstitial_ad", "materialMeta error ");
            return;
        }
        Context contextPA = activity == null ? this.pA : activity;
        if (contextPA == null) {
            contextPA = aBv.pA();
        }
        if (oX.vkV().Lm() && omh.pA(this.Og)) {
            intent = new Intent(contextPA, (Class<?>) TTAdActivity.class);
        } else if (zSD) {
            intent = new Intent(contextPA, (Class<?>) TTFullScreenExpressVideoActivity.class);
        } else if (pA(yfoJG)) {
            if (com.bytedance.sdk.openadsdk.component.reward.Og.Bzk.pA(yfoJG)) {
                intent = new Intent(contextPA, (Class<?>) TTInterstitialExpressActivity.class);
            } else {
                intent = new Intent(contextPA, (Class<?>) TTFullScreenExpressVideoActivity.class);
            }
        } else if (com.bytedance.sdk.openadsdk.component.reward.Og.Bzk.pA(yfoJG)) {
            intent = new Intent(contextPA, (Class<?>) TTInterstitialActivity.class);
        } else {
            intent = new Intent(contextPA, (Class<?>) TTFullScreenVideoActivity.class);
        }
        intent.putExtra("start_show_time", SystemClock.elapsedRealtime());
        com.bytedance.sdk.openadsdk.component.reward.pA.Og.pA(intent, activity, this.ZZv, this.Og, this.SD);
        intent.putExtra("is_verity_playable", this.JG);
        if (!com.bytedance.sdk.openadsdk.multipro.Og.KZx()) {
            TV.pA().pA(this.KZx);
            this.KZx = null;
        }
        com.bytedance.sdk.component.utils.Og.pA(contextPA, intent, new com.bytedance.sdk.component.utils.Og.InterfaceC0208Og() { // from class: com.bytedance.sdk.openadsdk.component.reward.JG.1
            @Override // com.bytedance.sdk.component.utils.Og.InterfaceC0208Og
            public void pA() {
                if (JG.this.JG) {
                    try {
                        com.bytedance.sdk.openadsdk.Sn.KZx.pA().pA(yfoJG.Bf().WV());
                    } catch (Throwable unused) {
                    }
                }
            }

            @Override // com.bytedance.sdk.component.utils.Og.InterfaceC0208Og
            public void pA(Throwable th) {
                com.bytedance.sdk.component.utils.WV.pA("TTFullScreenVideoAdImpl", "show full screen video error: ", th);
                if (JG.this.JG) {
                    try {
                        com.bytedance.sdk.openadsdk.Sn.KZx.pA().pA(yfoJG.Bf().WV(), -1, th != null ? th.getMessage() : "playable tool error open");
                    } catch (Throwable unused) {
                    }
                }
                com.bytedance.sdk.openadsdk.ZZv.KZx.pA(yfoJG, "fullscreen_interstitial_ad", "activity_start_fail");
            }
        }, true);
        if (zSD) {
            return;
        }
        pA.pA(this.Og.JG(), this.ZZv, false);
    }

    @Override // com.bytedance.sdk.openadsdk.api.PangleAd
    public Map<String, Object> getMediaExtraInfo() {
        com.bytedance.sdk.openadsdk.core.model.pA pAVar = this.Og;
        if (pAVar == null || pAVar.JG() == null) {
            return null;
        }
        return this.Og.JG().tZW();
    }

    @Override // com.bytedance.sdk.openadsdk.api.PangleAd
    public Object getExtraInfo(String str) {
        com.bytedance.sdk.openadsdk.core.model.pA pAVar = this.Og;
        if (pAVar == null || pAVar.JG() == null || this.Og.JG().tZW() == null) {
            return null;
        }
        try {
            return this.Og.JG().tZW().get(str);
        } catch (Throwable th) {
            com.bytedance.sdk.component.utils.WV.pA("TTFullScreenVideoAdImpl", th.getMessage());
            return null;
        }
    }

    private void pA(final int i) {
        if (com.bytedance.sdk.openadsdk.multipro.Og.KZx()) {
            xy.KZx(new com.bytedance.sdk.component.omh.omh("FullScreen_registerMultiProcessListener") { // from class: com.bytedance.sdk.openadsdk.component.reward.JG.2
                @Override // java.lang.Runnable
                public void run() {
                    com.bytedance.sdk.openadsdk.multipro.aidl.pA pAVarPA = com.bytedance.sdk.openadsdk.multipro.aidl.pA.pA();
                    if (i != 1 || JG.this.KZx == null) {
                        return;
                    }
                    com.bytedance.sdk.openadsdk.multipro.aidl.Og.KZx kZx = new com.bytedance.sdk.openadsdk.multipro.aidl.Og.KZx(JG.this.KZx);
                    IListenerManager iListenerManagerAsInterface = com.bytedance.sdk.openadsdk.multipro.aidl.pA.ML.asInterface(pAVarPA.pA(1));
                    if (iListenerManagerAsInterface != null) {
                        try {
                            iListenerManagerAsInterface.registerFullVideoListener(JG.this.SD, kZx);
                        } catch (RemoteException e) {
                            com.bytedance.sdk.component.utils.WV.pA("TTFullScreenVideoAdImpl", e.getMessage());
                        }
                    }
                }
            }, 5);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.api.PAGClientBidding
    public void win(Double d) {
        if (this.omh) {
            return;
        }
        Mc.pA(this.Og.JG(), d);
        this.omh = true;
    }

    @Override // com.bytedance.sdk.openadsdk.api.PAGClientBidding
    public void loss(Double d, String str, String str2) {
        if (this.Bzk) {
            return;
        }
        Mc.pA(this.Og.JG(), d, str, str2);
        this.Bzk = true;
    }
}
