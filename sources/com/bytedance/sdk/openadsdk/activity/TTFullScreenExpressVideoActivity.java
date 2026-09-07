package com.bytedance.sdk.openadsdk.activity;

import android.view.MotionEvent;
import com.bytedance.sdk.component.utils.WV;
import com.bytedance.sdk.openadsdk.ZZv.SD;
import com.bytedance.sdk.openadsdk.component.reward.Og.Bzk;
import com.bytedance.sdk.openadsdk.core.model.yFO;
import com.bytedance.sdk.openadsdk.utils.Wx;
import com.safedk.android.analytics.brandsafety.DetectTouchUtils;
import com.safedk.android.utils.h;
import java.util.HashMap;
import java.util.Iterator;
import net.pubnative.lite.sdk.vpaid.enums.EventConstants;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes7.dex */
public class TTFullScreenExpressVideoActivity extends TTFullScreenVideoActivity {
    @Override // com.bytedance.sdk.openadsdk.activity.TTBaseVideoActivity
    protected void KZx() {
    }

    @Override // com.bytedance.sdk.openadsdk.activity.TTBaseVideoActivity
    public boolean XT() {
        return true;
    }

    @Override // com.bytedance.sdk.openadsdk.activity.TTFullScreenVideoActivity, com.bytedance.sdk.openadsdk.activity.TTBaseVideoActivity, com.bytedance.sdk.openadsdk.activity.TTBaseActivity, android.app.Activity, android.view.Window.Callback
    public boolean dispatchTouchEvent(MotionEvent me) {
        DetectTouchUtils.activityOnTouch(h.u, me);
        return super.dispatchTouchEvent(me);
    }

    @Override // com.bytedance.sdk.openadsdk.activity.TTFullScreenVideoActivity, com.bytedance.sdk.openadsdk.core.Wx.ZZv.Og
    public boolean pA(long j, boolean z) {
        SD sd;
        if (this.Og.du != null && this.Og.du.pA() != null) {
            sd = this.Og.du.pA().getAdShowTime();
        } else {
            sd = new SD();
        }
        if (this.KZx != null && (this.KZx instanceof Bzk) && !this.Og.fJy) {
            this.Og.BF.pA(((Bzk) this.KZx).Mc(), sd);
        } else {
            this.Og.BF.pA(this.Og.du.Og(), sd);
        }
        HashMap map = new HashMap();
        if (this.Og.du != null) {
            map.put("dynamic_show_type", Integer.valueOf(this.Og.du.Bzk()));
            JSONObject jSONObjectPA = this.Og.du.pA((JSONObject) null);
            if (jSONObjectPA != null) {
                Iterator<String> itKeys = jSONObjectPA.keys();
                while (itKeys.hasNext()) {
                    String next = itKeys.next();
                    try {
                        map.put(next, jSONObjectPA.get(next));
                    } catch (JSONException unused) {
                    }
                }
            }
        }
        this.Og.BF.pA(new com.bykv.vk.openvk.pA.pA.pA.ZZv.KZx.pA() { // from class: com.bytedance.sdk.openadsdk.activity.TTFullScreenExpressVideoActivity.1
            boolean pA;

            @Override // com.bykv.vk.openvk.pA.pA.pA.ZZv.KZx.pA
            public void pA(long j2, int i) {
                if (this.pA) {
                    return;
                }
                this.pA = true;
                TTFullScreenExpressVideoActivity.this.ZZv.removeMessages(300);
                TTFullScreenExpressVideoActivity.this.DX();
                TTFullScreenExpressVideoActivity.this.Og.BF.pA(j2, j2);
                TTFullScreenExpressVideoActivity.this.Og.du.Og(true);
                if (TTFullScreenExpressVideoActivity.this.Og.Og.aBv() == 36 && TTFullScreenExpressVideoActivity.this.Og.KZx) {
                    TTFullScreenExpressVideoActivity.this.Og.WQf.KZx().ZZv();
                    Wx.Og();
                }
                if (TTFullScreenExpressVideoActivity.this.Og.Og.aBv() == 21 && !TTFullScreenExpressVideoActivity.this.Og.Og.ZZv()) {
                    TTFullScreenExpressVideoActivity.this.Og.Og.Og(true);
                    TTFullScreenExpressVideoActivity.this.Og.Vgu.aBv();
                }
                if (TTFullScreenExpressVideoActivity.this.Og.KZx) {
                    if (TTFullScreenExpressVideoActivity.this.Og.Og.xkc()) {
                        if (TTFullScreenExpressVideoActivity.this.Og.du.Bzk() == 1) {
                            TTFullScreenExpressVideoActivity.this.Og.qmB.KZx();
                            return;
                        }
                        return;
                    } else {
                        TTFullScreenExpressVideoActivity.this.pA(false, 5);
                        if (yFO.ML(TTFullScreenExpressVideoActivity.this.Og.Og)) {
                            return;
                        }
                        TTFullScreenExpressVideoActivity.this.Og.BF.pA(EventConstants.SKIP, true);
                        return;
                    }
                }
                if (yFO.ML(TTFullScreenExpressVideoActivity.this.Og.Og)) {
                    TTFullScreenExpressVideoActivity.this.finish();
                    return;
                }
                if (TTFullScreenExpressVideoActivity.this.Og.du == null || TTFullScreenExpressVideoActivity.this.Og.du.pA() == null) {
                    return;
                }
                TTFullScreenExpressVideoActivity.this.Og.du.pA().setTime("0", 0, 0, false);
                if (TTFullScreenExpressVideoActivity.this.Og.du.omh()) {
                    TTFullScreenExpressVideoActivity.this.Og.qmB.pA("0", "X");
                    TTFullScreenExpressVideoActivity.this.Og.qmB.ML(true);
                    TTFullScreenExpressVideoActivity.this.Og.qmB.KZx();
                }
            }

            @Override // com.bykv.vk.openvk.pA.pA.pA.ZZv.KZx.pA
            public void Og(long j2, int i) {
                TTFullScreenExpressVideoActivity.this.ZZv.removeMessages(300);
                if (TTFullScreenExpressVideoActivity.this.Og.BF.Og()) {
                    TTFullScreenExpressVideoActivity.this.Wx();
                    return;
                }
                TTFullScreenExpressVideoActivity.this.Og.BF.Wx();
                WV.pA("TTAD.FSEVA", "fullscreen_interstitial_ad", "onError、、、、、、、、");
                TTFullScreenExpressVideoActivity.this.Og.du.pA(true);
                if (TTFullScreenExpressVideoActivity.this.Og.KZx) {
                    TTFullScreenExpressVideoActivity.this.pA(false, 3);
                    TTFullScreenExpressVideoActivity.this.Og.BF.pA(1 ^ (TTFullScreenExpressVideoActivity.this.Og.BF.eG() ? 1 : 0), 2);
                } else {
                    TTFullScreenExpressVideoActivity.this.finish();
                }
            }

            @Override // com.bykv.vk.openvk.pA.pA.pA.ZZv.KZx.pA
            public void pA() {
                TTFullScreenExpressVideoActivity.this.ZZv.removeMessages(300);
                TTFullScreenExpressVideoActivity.this.DX();
                new Object[]{"fullscreen_interstitial_ad", "onTimeOut、、、、、、、、"};
                if (TTFullScreenExpressVideoActivity.this.Og.KZx) {
                    TTFullScreenExpressVideoActivity.this.pA(false, 6);
                } else {
                    TTFullScreenExpressVideoActivity.this.finish();
                }
                TTFullScreenExpressVideoActivity.this.Og.BF.pA(!TTFullScreenExpressVideoActivity.this.Og.BF.eG() ? 1 : 0, !TTFullScreenExpressVideoActivity.this.Og.BF.eG() ? 1 : 0);
                TTFullScreenExpressVideoActivity.this.Og.BF.Wx();
            }

            @Override // com.bykv.vk.openvk.pA.pA.pA.ZZv.KZx.pA
            public void pA(long j2, long j3) {
                if (!TTFullScreenExpressVideoActivity.this.Og.fN && TTFullScreenExpressVideoActivity.this.Og.BF.Og()) {
                    TTFullScreenExpressVideoActivity.this.Og.BF.DX();
                }
                if (TTFullScreenExpressVideoActivity.this.Og.SGo.get()) {
                    return;
                }
                TTFullScreenExpressVideoActivity.this.ZZv.removeMessages(300);
                if (j2 != TTFullScreenExpressVideoActivity.this.Og.BF.omh()) {
                    TTFullScreenExpressVideoActivity.this.DX();
                }
                if (TTFullScreenExpressVideoActivity.this.Og.BF.Og()) {
                    TTFullScreenExpressVideoActivity.this.Og.BF.pA(j2, j3);
                    TTFullScreenExpressVideoActivity tTFullScreenExpressVideoActivity = TTFullScreenExpressVideoActivity.this;
                    long j4 = j2 / 1000;
                    tTFullScreenExpressVideoActivity.JG = (int) (tTFullScreenExpressVideoActivity.Og.BF.roi() - j4);
                    int i = (int) j4;
                    if ((TTFullScreenExpressVideoActivity.this.Og.vZF.get() || TTFullScreenExpressVideoActivity.this.Og.BSW.get()) && TTFullScreenExpressVideoActivity.this.Og.BF.Og()) {
                        TTFullScreenExpressVideoActivity.this.Og.BF.DX();
                    }
                    if (TTFullScreenExpressVideoActivity.this.Og.du != null && TTFullScreenExpressVideoActivity.this.Og.du.pA() != null) {
                        TTFullScreenExpressVideoActivity.this.Og.du.pA().setTime(String.valueOf(TTFullScreenExpressVideoActivity.this.JG), i, 0, false);
                    }
                    if (TTFullScreenExpressVideoActivity.this.Og.du.omh() || TTFullScreenExpressVideoActivity.this.Og.Og.qH()) {
                        TTFullScreenExpressVideoActivity.this.KZx(i);
                        if (TTFullScreenExpressVideoActivity.this.JG >= 0) {
                            TTFullScreenExpressVideoActivity.this.Og.qmB.ZZv(true);
                            TTFullScreenExpressVideoActivity.this.Og.qmB.pA(String.valueOf(TTFullScreenExpressVideoActivity.this.JG), null);
                        }
                    }
                }
            }
        });
        return this.Og.BF.pA(j, z, map, this.KZx);
    }
}
