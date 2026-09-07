package com.bytedance.sdk.openadsdk.component;

import android.content.Context;
import android.os.Message;
import android.text.TextUtils;
import android.util.Log;
import com.bytedance.sdk.component.utils.TV;
import com.bytedance.sdk.openadsdk.AdSlot;
import com.bytedance.sdk.openadsdk.api.open.PAGAppOpenAdLoadListener;
import com.bytedance.sdk.openadsdk.core.Sn;
import com.bytedance.sdk.openadsdk.core.aBv;
import com.bytedance.sdk.openadsdk.core.model.TX;
import com.bytedance.sdk.openadsdk.core.model.du;
import com.bytedance.sdk.openadsdk.core.omh;
import com.bytedance.sdk.openadsdk.core.settings.oX;
import com.bytedance.sdk.openadsdk.core.yFO;
import com.bytedance.sdk.openadsdk.utils.qmB;
import com.bytedance.sdk.openadsdk.utils.xy;
import com.json.mediationsdk.utils.IronSourceConstants;
import com.vungle.ads.internal.protos.Sdk;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes4.dex */
public class SD implements TV.pA {
    private boolean BSW;
    private AdSlot JG;
    private final JG KZx;
    private final yFO<com.bytedance.sdk.openadsdk.ZZv.pA> Og;
    private PAGAppOpenAdLoadListener SD;
    private int omh;
    private final Context pA;
    private final AtomicBoolean ZZv = new AtomicBoolean(false);
    private int ML = 0;
    private volatile int Bzk = 0;
    private final du SGo = new du();

    public SD(Context context) {
        if (context != null) {
            this.pA = context.getApplicationContext();
        } else {
            this.pA = aBv.pA();
        }
        this.Og = aBv.KZx();
        this.KZx = JG.pA(this.pA);
    }

    public static SD pA(Context context) {
        return new SD(context);
    }

    public void pA(AdSlot adSlot, com.bytedance.sdk.openadsdk.common.JG jg, int i) {
        if (jg == null) {
            return;
        }
        if (i <= 0) {
            i = IronSourceConstants.BN_AUCTION_REQUEST;
        }
        this.JG = adSlot;
        this.SGo.pA = !TextUtils.isEmpty(adSlot.getBidAdm());
        if (jg instanceof PAGAppOpenAdLoadListener) {
            this.SD = (PAGAppOpenAdLoadListener) jg;
        }
        this.ML = pA(this.JG);
        this.omh = i;
        this.SGo.pA(qmB.Og());
        if (this.SGo.pA || oX.vkV().TV(this.JG.getCodeId()) == 0) {
            Og(this.JG);
        }
        if (this.SGo.pA) {
            return;
        }
        new TV(Sn.Og().getLooper(), this).sendEmptyMessageDelayed(1, i);
        pA();
    }

    private void Og(final AdSlot adSlot) {
        final qmB qmbOg = qmB.Og();
        this.Bzk = 1;
        TX tx = new TX();
        tx.SGo = this.SGo;
        tx.ZZv = 1;
        tx.omh = 2;
        this.Og.pA(adSlot, tx, 3, new yFO.pA() { // from class: com.bytedance.sdk.openadsdk.component.SD.1
            @Override // com.bytedance.sdk.openadsdk.core.yFO.pA
            public void pA(int i, String str) {
                SD.this.Bzk = 3;
                SD.this.pA(new com.bytedance.sdk.openadsdk.component.ML.Og(2, 100, i, str));
            }

            @Override // com.bytedance.sdk.openadsdk.core.yFO.pA
            public void pA(final com.bytedance.sdk.openadsdk.core.model.pA pAVar, com.bytedance.sdk.openadsdk.core.model.Og og) {
                SD.this.Bzk = 2;
                if (pAVar == null || pAVar.ZZv() == null || pAVar.ZZv().size() == 0) {
                    SD.this.Bzk = 3;
                    SD.this.pA(new com.bytedance.sdk.openadsdk.component.ML.Og(2, 100, Sdk.SDKError.Reason.AD_SERVER_ERROR_VALUE, omh.pA(Sdk.SDKError.Reason.AD_SERVER_ERROR_VALUE)));
                    og.pA(-3);
                    com.bytedance.sdk.openadsdk.core.model.Og.pA(og);
                    return;
                }
                final com.bytedance.sdk.openadsdk.core.model.yFO yfo = pAVar.ZZv().get(0);
                long jDX = yfo.DX();
                SD.this.SGo.Og = jDX;
                boolean zJG = com.bytedance.sdk.openadsdk.core.model.yFO.JG(yfo);
                if (yfo.zi()) {
                    SD.this.pA(new com.bytedance.sdk.openadsdk.component.ML.Og(1, 100, yfo, pAVar));
                    return;
                }
                if (zJG) {
                    SD.this.pA(new com.bytedance.sdk.openadsdk.component.ML.Og(1, 100, yfo, pAVar));
                    if (com.bytedance.sdk.openadsdk.core.model.yFO.ML(yfo)) {
                        SD.this.pA(yfo, adSlot, false, pAVar);
                        return;
                    } else {
                        SD.this.pA(yfo, false, pAVar);
                        return;
                    }
                }
                if (com.bytedance.sdk.openadsdk.core.model.yFO.ML(yfo)) {
                    int iWV = aBv.ZZv().WV();
                    if (iWV == 1 || iWV == 3) {
                        SD.this.SGo.Og = -1L;
                        SD.this.SGo.pA(3);
                        SD.this.pA(new com.bytedance.sdk.openadsdk.component.ML.Og(1, 100, yfo, pAVar));
                        SD.this.pA(yfo, adSlot, false, pAVar);
                        return;
                    }
                    SD sd = SD.this;
                    sd.pA(yfo, adSlot, !sd.SGo.pA, pAVar);
                } else {
                    if (aBv.ZZv().BSW() == 1) {
                        SD.this.SGo.Og = -1L;
                        SD.this.SGo.pA(3);
                        SD.this.pA(new com.bytedance.sdk.openadsdk.component.ML.Og(1, 100, yfo, pAVar));
                        SD.this.pA(yfo, false, pAVar);
                        return;
                    }
                    SD sd2 = SD.this;
                    sd2.pA(yfo, !sd2.SGo.pA, pAVar);
                }
                if (SD.this.SGo.pA) {
                    com.bytedance.sdk.openadsdk.Sn.KZx.pA(yfo, qmbOg.ZZv());
                    new Object[]{"onAdLoad: invoke callback after ", Long.valueOf(jDX), "ms for bidding"};
                    if (jDX == 0) {
                        SD.this.SGo.pA(2);
                        SD.this.pA(new com.bytedance.sdk.openadsdk.component.ML.Og(1, 100, yfo, pAVar));
                    } else {
                        Sn.Og().postDelayed(new Runnable() { // from class: com.bytedance.sdk.openadsdk.component.SD.1.1
                            @Override // java.lang.Runnable
                            public void run() {
                                SD.this.SGo.pA(2);
                                SD.this.pA(new com.bytedance.sdk.openadsdk.component.ML.Og(1, 100, yfo, pAVar));
                            }
                        }, jDX);
                    }
                }
            }
        });
    }

    private void pA() {
        xy.Og(new com.bytedance.sdk.component.omh.omh("tryGetAppOpenAdFromCache") { // from class: com.bytedance.sdk.openadsdk.component.SD.2
            @Override // java.lang.Runnable
            public void run() {
                int iWV;
                com.bytedance.sdk.openadsdk.core.model.yFO yfoML = SD.this.KZx.ML(SD.this.ML);
                if (yfoML == null) {
                    SD.this.pA(false);
                    return;
                }
                if (yfoML.rB() == null) {
                    yfoML.pA(SD.this.JG);
                }
                boolean zML = com.bytedance.sdk.openadsdk.core.model.yFO.ML(yfoML);
                if (yfoML.zi()) {
                    SD.this.pA(new com.bytedance.sdk.openadsdk.component.ML.Og(1, 101, yfoML, (com.bytedance.sdk.openadsdk.core.model.pA) null));
                    return;
                }
                if (!zML && aBv.ZZv().BSW() == 1) {
                    SD.this.pA(new com.bytedance.sdk.openadsdk.component.ML.Og(1, 101, yfoML, (com.bytedance.sdk.openadsdk.core.model.pA) null));
                    return;
                }
                if (!zML || ((iWV = aBv.ZZv().WV()) != 2 && iWV != 3)) {
                    if (SD.this.KZx.Og(SD.this.ML) || SD.this.KZx.ZZv(SD.this.ML)) {
                        if (oX.vkV().TV(SD.this.JG.getCodeId()) == 0) {
                            SD.this.KZx.SD(SD.this.ML);
                        }
                        if (!zML) {
                            if (SD.this.KZx.Og(yfoML)) {
                                SD.this.pA(new com.bytedance.sdk.openadsdk.component.ML.Og(1, 101, yfoML, (com.bytedance.sdk.openadsdk.core.model.pA) null));
                                return;
                            } else {
                                SD.this.pA(false);
                                com.bytedance.sdk.openadsdk.component.ZZv.pA.Og(yfoML);
                                return;
                            }
                        }
                        if (TextUtils.isEmpty(SD.this.KZx.pA(yfoML))) {
                            SD.this.pA(false);
                            com.bytedance.sdk.openadsdk.component.ZZv.pA.Og(yfoML);
                            return;
                        } else {
                            SD.this.pA(new com.bytedance.sdk.openadsdk.component.ML.Og(1, 101, yfoML, (com.bytedance.sdk.openadsdk.core.model.pA) null));
                            return;
                        }
                    }
                    SD.this.pA(true);
                    return;
                }
                SD.this.pA(new com.bytedance.sdk.openadsdk.component.ML.Og(1, 101, yfoML, (com.bytedance.sdk.openadsdk.core.model.pA) null));
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void pA(boolean z) {
        if (z) {
            this.KZx.SD(this.ML);
        }
        if (oX.vkV().TV(this.JG.getCodeId()) == 1) {
            Og(this.JG);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void pA(final com.bytedance.sdk.openadsdk.core.model.yFO yfo, AdSlot adSlot, final boolean z, final com.bytedance.sdk.openadsdk.core.model.pA pAVar) {
        this.KZx.pA(yfo, adSlot, this.SGo, new JG.KZx() { // from class: com.bytedance.sdk.openadsdk.component.SD.3
            @Override // com.bytedance.sdk.openadsdk.component.JG.KZx
            public void pA() {
                Log.d("TTAppOpenAdLoadManager", "preLoadSuccess: video load success");
                if (z) {
                    SD.this.Bzk = 4;
                    com.bytedance.sdk.openadsdk.component.ML.Og og = new com.bytedance.sdk.openadsdk.component.ML.Og(1, 100, yfo, pAVar);
                    og.pA(true);
                    SD.this.pA(og);
                }
            }

            @Override // com.bytedance.sdk.openadsdk.component.JG.KZx
            public void pA(int i, String str) {
                if (z) {
                    SD.this.Bzk = 5;
                    SD.this.pA(new com.bytedance.sdk.openadsdk.component.ML.Og(2, 100, 10003, omh.pA(10003)));
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void pA(final com.bytedance.sdk.openadsdk.core.model.yFO yfo, final boolean z, final com.bytedance.sdk.openadsdk.core.model.pA pAVar) {
        this.KZx.pA(yfo, this.SGo, new JG.Og() { // from class: com.bytedance.sdk.openadsdk.component.SD.4
            @Override // com.bytedance.sdk.openadsdk.component.JG.Og
            public void pA(com.bytedance.sdk.openadsdk.aBv.pA.Og og) {
                Log.d("TTAppOpenAdLoadManager", "preLoadSuccess: image load success");
                if (z) {
                    SD.this.Bzk = 4;
                    com.bytedance.sdk.openadsdk.component.ML.Og og2 = new com.bytedance.sdk.openadsdk.component.ML.Og(1, 100, yfo, pAVar);
                    og2.pA(true);
                    SD.this.pA(og2);
                }
            }

            @Override // com.bytedance.sdk.openadsdk.component.JG.Og
            public void pA() {
                Log.d("TTAppOpenAdLoadManager", "preLoadFail: image load fail");
                if (z) {
                    SD.this.Bzk = 5;
                    SD.this.pA(new com.bytedance.sdk.openadsdk.component.ML.Og(2, 100, 10003, omh.pA(10003)));
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void pA(com.bytedance.sdk.openadsdk.component.ML.Og og) {
        int iKZx = og.KZx();
        int iZZv = og.ZZv();
        if (this.ZZv.get()) {
            if (iKZx == 1 && iZZv == 100 && og.Og()) {
                JG.pA(aBv.pA()).pA(new com.bytedance.sdk.openadsdk.component.ML.pA(this.ML, og.ML(), og.pA()));
                if (this.BSW) {
                    return;
                }
                com.bytedance.sdk.openadsdk.component.ZZv.pA.pA(og.ML(), 1, this.SGo);
                return;
            }
            return;
        }
        if (iKZx != 1) {
            if (iKZx == 2 || iKZx == 3) {
                PAGAppOpenAdLoadListener pAGAppOpenAdLoadListener = this.SD;
                if (pAGAppOpenAdLoadListener != null) {
                    pAGAppOpenAdLoadListener.onError(og.JG(), og.SD());
                }
                this.ZZv.set(true);
                if (iKZx == 3) {
                    com.bytedance.sdk.openadsdk.component.ZZv.pA.pA(this.Bzk, this.omh);
                    return;
                }
                return;
            }
            return;
        }
        if (this.SD != null) {
            this.SD.onAdLoaded(new ZZv(this.pA, og.ML(), iZZv == 101, this.JG));
        }
        this.ZZv.set(true);
        if (iZZv == 101) {
            com.bytedance.sdk.openadsdk.component.ZZv.pA.pA(og.ML(), this.SGo.pA().ZZv());
            return;
        }
        if (iZZv == 100) {
            com.bytedance.sdk.openadsdk.component.ZZv.pA.pA(og.ML(), 0, this.SGo);
            this.BSW = true;
            if (this.SGo.pA || com.bytedance.sdk.openadsdk.core.model.yFO.JG(og.ML())) {
                return;
            }
            if (oX.vkV().TV(this.JG.getCodeId()) == 0) {
                this.KZx.pA(this.JG);
            } else {
                this.KZx.pA(new com.bytedance.sdk.openadsdk.component.ML.pA(this.ML, og.ML(), og.pA()));
            }
        }
    }

    public int pA(AdSlot adSlot) {
        try {
            return Integer.parseInt(adSlot.getCodeId());
        } catch (Throwable unused) {
            return 0;
        }
    }

    @Override // com.bytedance.sdk.component.utils.TV.pA
    public void pA(Message message) {
        if (message.what != 1 || this.ZZv.get()) {
            return;
        }
        pA(new com.bytedance.sdk.openadsdk.component.ML.Og(3, 102, Sdk.SDKError.Reason.AD_LOAD_TOO_FREQUENTLY_VALUE, omh.pA(Sdk.SDKError.Reason.AD_LOAD_TOO_FREQUENTLY_VALUE)));
    }
}
