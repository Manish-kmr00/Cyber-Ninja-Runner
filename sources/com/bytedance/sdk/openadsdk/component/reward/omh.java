package com.bytedance.sdk.openadsdk.component.reward;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.RemoteException;
import android.os.SystemClock;
import android.text.TextUtils;
import com.bytedance.sdk.openadsdk.AdSlot;
import com.bytedance.sdk.openadsdk.IListenerManager;
import com.bytedance.sdk.openadsdk.activity.TTAdActivity;
import com.bytedance.sdk.openadsdk.activity.TTRewardExpressVideoActivity;
import com.bytedance.sdk.openadsdk.activity.TTRewardVideoActivity;
import com.bytedance.sdk.openadsdk.api.reward.PAGRewardedAd;
import com.bytedance.sdk.openadsdk.api.reward.PAGRewardedAdInteractionCallback;
import com.bytedance.sdk.openadsdk.api.reward.PAGRewardedAdInteractionListener;
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
import org.json.JSONArray;

/* JADX INFO: loaded from: classes5.dex */
class omh extends PAGRewardedAd {
    private boolean Bzk;
    private final AdSlot KZx;
    private boolean ML;
    private final com.bytedance.sdk.openadsdk.core.model.pA Og;
    private com.bytedance.sdk.openadsdk.pA.ML.pA ZZv;
    private boolean omh;
    private final Context pA;
    private final AtomicBoolean JG = new AtomicBoolean(false);
    private final String SD = WQf.pA();

    omh(Context context, com.bytedance.sdk.openadsdk.core.model.pA pAVar, AdSlot adSlot) {
        this.pA = context;
        this.Og = pAVar;
        this.KZx = adSlot;
    }

    public void pA() {
        if (this.JG.get()) {
            return;
        }
        this.ML = true;
    }

    @Override // com.bytedance.sdk.openadsdk.api.reward.PAGRewardedAd
    public void setAdInteractionListener(PAGRewardedAdInteractionListener pAGRewardedAdInteractionListener) {
        this.ZZv = new Bzk(pAGRewardedAdInteractionListener);
        pA(0);
    }

    @Override // com.bytedance.sdk.openadsdk.api.reward.PAGRewardedAd
    public void setAdInteractionCallback(PAGRewardedAdInteractionCallback pAGRewardedAdInteractionCallback) {
        this.ZZv = new Bzk(pAGRewardedAdInteractionCallback);
        pA(0);
    }

    @Override // com.bytedance.sdk.openadsdk.api.reward.PAGRewardedAd
    public void show(Activity activity) {
        Intent intent;
        if (activity != null && activity.isFinishing()) {
            com.bytedance.sdk.component.utils.WV.pA("TTRewardVideoAdImpl", "showRewardVideoAd error1: activity is finishing");
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
            com.bytedance.sdk.component.utils.WV.pA("TTRewardVideoAdImpl", "showRewardVideoAd error2: not main looper");
            throw new IllegalStateException("Cannot be called in a child thread —— TTRewardVideoAd.showRewardVideoAd");
        }
        List<yFO> listZZv = this.Og.ZZv();
        if (listZZv != null) {
            Iterator<yFO> it = listZZv.iterator();
            while (it.hasNext()) {
                IPMiBroadcastReceiver.pA(this.pA, it.next());
            }
        }
        if (this.JG.compareAndSet(false, true)) {
            if (yfoJG == null || yfoJG.Bf() == null) {
                com.bytedance.sdk.openadsdk.ZZv.KZx.pA(yfoJG, "fullscreen_interstitial_ad", "materialMeta error ");
                return;
            }
            Context contextPA = activity == null ? this.pA : activity;
            if (contextPA == null) {
                contextPA = aBv.pA();
            }
            if (oX.vkV().Lm() && pA(this.Og)) {
                intent = new Intent(contextPA, (Class<?>) TTAdActivity.class);
            } else if (zSD || pA(yfoJG)) {
                intent = new Intent(contextPA, (Class<?>) TTRewardExpressVideoActivity.class);
            } else {
                intent = new Intent(contextPA, (Class<?>) TTRewardVideoActivity.class);
            }
            com.bytedance.sdk.openadsdk.component.reward.pA.Og.pA(intent, activity, this.ML, this.Og, this.SD);
            intent.putExtra("media_extra", this.KZx.getMediaExtra());
            intent.putExtra("user_id", this.KZx.getUserID());
            intent.putExtra("start_show_time", SystemClock.elapsedRealtime());
            if (!com.bytedance.sdk.openadsdk.multipro.Og.KZx()) {
                TV.pA().pA(this.ZZv);
                this.ZZv = null;
            }
            com.bytedance.sdk.component.utils.Og.pA(contextPA, intent, new com.bytedance.sdk.component.utils.Og.InterfaceC0208Og() { // from class: com.bytedance.sdk.openadsdk.component.reward.omh.1
                @Override // com.bytedance.sdk.component.utils.Og.InterfaceC0208Og
                public void pA() {
                }

                @Override // com.bytedance.sdk.component.utils.Og.InterfaceC0208Og
                public void pA(Throwable th) {
                    com.bytedance.sdk.component.utils.WV.pA("TTRewardVideoAdImpl", "show reward video error: ", th);
                    com.bytedance.sdk.openadsdk.ZZv.KZx.pA(yfoJG, "fullscreen_interstitial_ad", "activity_start_fail");
                }
            }, true);
            if (zSD) {
                return;
            }
            pA.pA(this.Og.JG(), this.ML, true);
        }
    }

    private static boolean pA(yFO yfo) {
        if (yfo == null) {
            return false;
        }
        int iABv = yfo.aBv();
        return (yfo.BF() != 2 || iABv == 5 || iABv == 33 || iABv == 6 || iABv == 19 || iABv == 12) ? false : true;
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
            com.bytedance.sdk.component.utils.WV.pA("TTRewardVideoAdImpl", th.getMessage());
            return null;
        }
    }

    private void pA(final int i) {
        if (com.bytedance.sdk.openadsdk.multipro.Og.KZx()) {
            xy.KZx(new com.bytedance.sdk.component.omh.omh("Reward_registerMultiProcessListener") { // from class: com.bytedance.sdk.openadsdk.component.reward.omh.2
                @Override // java.lang.Runnable
                public void run() {
                    com.bytedance.sdk.openadsdk.multipro.aidl.pA pAVarPA = com.bytedance.sdk.openadsdk.multipro.aidl.pA.pA();
                    if (i != 0 || omh.this.ZZv == null) {
                        return;
                    }
                    com.bytedance.sdk.openadsdk.multipro.aidl.Og.ZZv zZv = new com.bytedance.sdk.openadsdk.multipro.aidl.Og.ZZv(omh.this.ZZv);
                    IListenerManager iListenerManagerAsInterface = com.bytedance.sdk.openadsdk.multipro.aidl.pA.SD.asInterface(pAVarPA.pA(0));
                    if (iListenerManagerAsInterface != null) {
                        try {
                            iListenerManagerAsInterface.registerRewardVideoListener(omh.this.SD, zZv);
                        } catch (RemoteException e) {
                            com.bytedance.sdk.component.utils.WV.pA("TTRewardVideoAdImpl", e.getMessage());
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

    public static boolean pA(com.bytedance.sdk.openadsdk.core.model.pA pAVar) {
        yFO yfoJG;
        com.bykv.vk.openvk.pA.pA.pA.KZx.Og ogBf;
        String strWV;
        if (pAVar == null || (yfoJG = pAVar.JG()) == null || com.bytedance.sdk.openadsdk.core.model.aBv.KZx(yfoJG)) {
            return false;
        }
        String strPA = com.bytedance.sdk.openadsdk.vZF.pA.pA("rviv_new_arch_not_support_style", (String) null);
        if (TextUtils.isEmpty(strPA)) {
            return true;
        }
        try {
            JSONArray jSONArray = new JSONArray(strPA);
            for (int i = 0; i < jSONArray.length(); i++) {
                int i2 = jSONArray.getInt(i);
                if (i2 != 0) {
                    if (yfoJG.aBv() == i2) {
                        return false;
                    }
                    if (i2 == 8 && (ogBf = yfoJG.Bf()) != null && (strWV = ogBf.WV()) != null && Uri.parse(strWV).getQueryParameterNames().contains("show_landingpage")) {
                        return false;
                    }
                }
            }
            return true;
        } catch (Exception unused) {
            return true;
        }
    }
}
