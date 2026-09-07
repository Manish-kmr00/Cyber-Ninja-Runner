package com.bytedance.sdk.openadsdk.core.omh;

import android.content.Context;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.Log;
import com.bytedance.sdk.openadsdk.AdSlot;
import com.bytedance.sdk.openadsdk.CacheDirFactory;
import com.bytedance.sdk.openadsdk.api.banner.PAGBannerAd;
import com.bytedance.sdk.openadsdk.api.banner.PAGBannerAdLoadListener;
import com.bytedance.sdk.openadsdk.utils.qmB;
import com.bytedance.sdk.openadsdk.utils.xy;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes6.dex */
public class SD {
    private List<com.bytedance.sdk.openadsdk.core.model.yFO> JG;
    private final Context KZx;
    private List<com.bytedance.sdk.openadsdk.core.model.yFO> SD;
    private PAGBannerAdLoadListener ZZv;
    private pA omh;
    private AdSlot pA;
    private final AtomicBoolean ML = new AtomicBoolean(false);
    private int Bzk = 5;
    private final qmB SGo = qmB.KZx();
    private final com.bytedance.sdk.openadsdk.core.yFO Og = com.bytedance.sdk.openadsdk.core.aBv.KZx();

    public interface pA {
    }

    private SD(Context context) {
        if (context != null) {
            this.KZx = context.getApplicationContext();
        } else {
            this.KZx = com.bytedance.sdk.openadsdk.core.aBv.pA();
        }
    }

    public static SD pA(Context context) {
        return new SD(context);
    }

    public void pA(AdSlot adSlot, int i, com.bytedance.sdk.openadsdk.common.JG jg, int i2) {
        pA(adSlot, i, jg, null, i2);
    }

    public void pA(AdSlot adSlot, int i, com.bytedance.sdk.openadsdk.common.JG jg, pA pAVar, int i2) {
        this.SGo.ML();
        if (this.ML.get()) {
            com.bytedance.sdk.component.utils.WV.pA("ExpressAdLoadManager", "express ad is loading...");
            return;
        }
        this.Bzk = i;
        this.ML.set(true);
        this.pA = adSlot;
        if (jg instanceof PAGBannerAdLoadListener) {
            this.ZZv = (PAGBannerAdLoadListener) jg;
        }
        this.omh = pAVar;
        pA(adSlot, jg);
    }

    private void pA(final AdSlot adSlot, com.bytedance.sdk.openadsdk.common.JG jg) {
        if (adSlot == null) {
            return;
        }
        com.bytedance.sdk.openadsdk.core.model.TX tx = new com.bytedance.sdk.openadsdk.core.model.TX();
        tx.omh = 2;
        this.Og.pA(adSlot, tx, this.Bzk, new com.bytedance.sdk.openadsdk.core.yFO.pA() { // from class: com.bytedance.sdk.openadsdk.core.omh.SD.1
            @Override // com.bytedance.sdk.openadsdk.core.yFO.pA
            public void pA(int i, String str) {
                SD.this.pA(i, str);
            }

            @Override // com.bytedance.sdk.openadsdk.core.yFO.pA
            public void pA(final com.bytedance.sdk.openadsdk.core.model.pA pAVar, com.bytedance.sdk.openadsdk.core.model.Og og) {
                if (pAVar.ZZv() == null || pAVar.ZZv().isEmpty()) {
                    SD.this.pA(-3, com.bytedance.sdk.openadsdk.core.omh.pA(-3));
                    og.pA(-3);
                    com.bytedance.sdk.openadsdk.core.model.Og.pA(og);
                    return;
                }
                SD.this.JG = pAVar.ZZv();
                SD.this.SD = pAVar.ZZv();
                SD.this.pA(adSlot);
                if (com.bytedance.sdk.component.utils.WV.ZZv()) {
                    Log.e("ExpressAdLoadManager", "onAdLoad: net work response duration = " + SD.this.SGo.ZZv() + "run in  " + Thread.currentThread().getName());
                }
                if (SD.this.ML.getAndSet(false)) {
                    xy.pA(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.omh.SD.1.1
                        @Override // java.lang.Runnable
                        public void run() {
                            long jElapsedRealtime = SystemClock.elapsedRealtime();
                            if (SD.this.SD == null || SD.this.SD.size() <= 0) {
                                if (SD.this.omh != null) {
                                    pA unused = SD.this.omh;
                                }
                            } else {
                                SD.this.pA(pAVar, SD.this.SGo, jElapsedRealtime);
                                if (SD.this.omh != null) {
                                    pA unused2 = SD.this.omh;
                                    List unused3 = SD.this.SD;
                                }
                            }
                            SD.this.pA();
                        }
                    });
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void pA(AdSlot adSlot) {
        List<com.bytedance.sdk.openadsdk.core.model.yFO> list = this.JG;
        if (list == null) {
            return;
        }
        for (com.bytedance.sdk.openadsdk.core.model.yFO yfo : list) {
            if (com.bytedance.sdk.openadsdk.core.model.yFO.ML(yfo) && yfo.Bf() != null && yfo.Bf().BSW() != null) {
                if (com.bytedance.sdk.openadsdk.core.aBv.ZZv().ML(String.valueOf(yfo.Wf())) && com.bytedance.sdk.openadsdk.core.aBv.ZZv().YkC()) {
                    com.bytedance.sdk.openadsdk.core.Wx.pA.Og ogPA = com.bytedance.sdk.openadsdk.core.model.yFO.pA(CacheDirFactory.getICacheDir(yfo.FK()).KZx(), yfo);
                    ogPA.pA("material_meta", yfo);
                    ogPA.pA("ad_slot", adSlot);
                    com.bytedance.sdk.openadsdk.core.Wx.ML.pA.pA(ogPA, null);
                }
            }
        }
    }

    private PAGBannerAd pA(qmB qmb) {
        Iterator<com.bytedance.sdk.openadsdk.core.model.yFO> it = this.SD.iterator();
        PAGBannerAd pAGBannerAdPA = null;
        while (it.hasNext() && (pAGBannerAdPA = pA(it.next())) == null) {
        }
        return pAGBannerAdPA;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void pA(com.bytedance.sdk.openadsdk.core.model.pA pAVar, qmB qmb, long j) {
        if (this.ZZv != null) {
            PAGBannerAd pAGBannerAdPA = pA(qmb);
            if (pAGBannerAdPA != null) {
                long jElapsedRealtime = SystemClock.elapsedRealtime();
                long jZZv = this.SGo.ZZv();
                if (!TextUtils.isEmpty(this.pA.getBidAdm())) {
                    com.bytedance.sdk.openadsdk.Sn.KZx.pA(this.SD.get(0), jZZv);
                }
                this.ZZv.onAdLoaded(pAGBannerAdPA);
                pA(pAVar, jZZv, j, jElapsedRealtime);
                return;
            }
            this.ZZv.onError(103, com.bytedance.sdk.openadsdk.core.omh.pA(103));
            pA(103);
        }
    }

    private void pA(com.bytedance.sdk.openadsdk.core.model.pA pAVar, final long j, final long j2, final long j3) {
        com.bytedance.sdk.openadsdk.core.model.yFO yfo;
        try {
            if (com.bytedance.sdk.openadsdk.core.aBv.ZZv().fJy() && com.bytedance.sdk.openadsdk.vZF.pA.ZZv()) {
                try {
                    if (this.Bzk != 1 || pAVar == null || pAVar.ZZv() == null || pAVar.ZZv().isEmpty() || pAVar.pA() == null || (yfo = pAVar.ZZv().get(0)) == null) {
                        return;
                    }
                    final JSONObject jSONObjectPA = pAVar.pA();
                    com.bytedance.sdk.openadsdk.ZZv.KZx.pA(System.currentTimeMillis(), yfo, jSONObjectPA.optString("tag", ""), "load_ad_time", new com.bytedance.sdk.openadsdk.Sn.KZx.pA() { // from class: com.bytedance.sdk.openadsdk.core.omh.SD.2
                        @Override // com.bytedance.sdk.openadsdk.Sn.KZx.pA
                        public JSONObject pA() {
                            JSONObject jSONObject = new JSONObject();
                            try {
                                long jOptLong = jSONObjectPA.optLong("callback_start", 0L);
                                long j4 = j2;
                                long j5 = j4 - jOptLong;
                                long j6 = j3 - j4;
                                long jOptLong2 = jSONObjectPA.optLong("duration", 0L);
                                JSONObject jSONObjectOptJSONObject = jSONObjectPA.optJSONObject("extra_data");
                                if (jSONObjectOptJSONObject == null) {
                                    jSONObjectOptJSONObject = new JSONObject();
                                }
                                jSONObjectOptJSONObject.put("thread_dispatch_duration", j5);
                                jSONObjectOptJSONObject.put("build_banner_ad_duration", j6);
                                jSONObjectOptJSONObject.put("ad_load_duration_full", j);
                                jSONObject.put("duration", jOptLong2);
                                jSONObject.put("ad_extra_data", jSONObjectOptJSONObject.toString());
                                if (com.bytedance.sdk.component.utils.WV.ZZv()) {
                                    com.bytedance.sdk.component.utils.WV.pA("ExpressAdLoadManager", "reportAdLoadTime: result = ".concat(String.valueOf(jSONObject)));
                                }
                            } catch (Throwable unused) {
                            }
                            return jSONObject;
                        }
                    });
                } catch (Throwable unused) {
                }
            }
        } catch (Throwable unused2) {
        }
    }

    private void pA(int i) {
        String strIj;
        List<com.bytedance.sdk.openadsdk.core.model.yFO> list = this.JG;
        if (list != null && list.size() > 0) {
            strIj = this.JG.get(0).Ij();
        } else {
            strIj = "";
        }
        com.bytedance.sdk.openadsdk.Sn.KZx.pA().pA(com.bytedance.sdk.openadsdk.Sn.pA.ZZv.Og().pA(this.Bzk).KZx(this.pA.getCodeId()).ML(strIj).Og(i).JG(com.bytedance.sdk.openadsdk.core.omh.pA(i)));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void pA(int i, String str) {
        if (this.ML.getAndSet(false)) {
            PAGBannerAdLoadListener pAGBannerAdLoadListener = this.ZZv;
            if (pAGBannerAdLoadListener != null) {
                pAGBannerAdLoadListener.onError(i, str);
            }
            pA();
        }
    }

    private PAGBannerAd pA(com.bytedance.sdk.openadsdk.core.model.yFO yfo) {
        if (this.Bzk != 1) {
            return null;
        }
        if (yfo.Bf() != null) {
            return new com.bytedance.sdk.openadsdk.core.KZx.JG(this.KZx, yfo, this.pA);
        }
        return new com.bytedance.sdk.openadsdk.core.KZx.ZZv(this.KZx, yfo, this.pA);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void pA() {
        List<com.bytedance.sdk.openadsdk.core.model.yFO> list = this.JG;
        if (list != null) {
            list.clear();
        }
        List<com.bytedance.sdk.openadsdk.core.model.yFO> list2 = this.SD;
        if (list2 != null) {
            list2.clear();
        }
    }
}
