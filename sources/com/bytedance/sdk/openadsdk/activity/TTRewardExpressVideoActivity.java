package com.bytedance.sdk.openadsdk.activity;

import android.view.MotionEvent;
import com.bytedance.sdk.openadsdk.ZZv.SD;
import com.bytedance.sdk.openadsdk.common.TTAdDislikeToast;
import com.bytedance.sdk.openadsdk.core.aBv;
import com.bytedance.sdk.openadsdk.core.model.yFO;
import com.bytedance.sdk.openadsdk.utils.Wx;
import com.safedk.android.analytics.brandsafety.DetectTouchUtils;
import com.safedk.android.utils.h;
import java.util.HashMap;
import java.util.Iterator;
import net.pubnative.lite.sdk.vpaid.enums.EventConstants;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes12.dex */
public class TTRewardExpressVideoActivity extends TTRewardVideoActivity {
    @Override // com.bytedance.sdk.openadsdk.activity.TTBaseVideoActivity
    protected void KZx() {
    }

    @Override // com.bytedance.sdk.openadsdk.activity.TTBaseVideoActivity
    public boolean XT() {
        return true;
    }

    @Override // com.bytedance.sdk.openadsdk.activity.TTRewardVideoActivity, com.bytedance.sdk.openadsdk.activity.TTBaseVideoActivity, com.bytedance.sdk.openadsdk.activity.TTBaseActivity, android.app.Activity, android.view.Window.Callback
    public boolean dispatchTouchEvent(MotionEvent me) {
        DetectTouchUtils.activityOnTouch(h.u, me);
        return super.dispatchTouchEvent(me);
    }

    @Override // com.bytedance.sdk.openadsdk.activity.TTRewardVideoActivity, com.bytedance.sdk.openadsdk.core.Wx.ZZv.Og
    public boolean pA(long j, boolean z) {
        SD sd;
        if (this.Og.du != null && this.Og.du.pA() != null) {
            sd = this.Og.du.pA().getAdShowTime();
        } else {
            sd = new SD();
        }
        this.Og.BF.pA(this.Og.du.Og(), sd);
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
        this.Og.BF.pA(new com.bykv.vk.openvk.pA.pA.pA.ZZv.KZx.pA() { // from class: com.bytedance.sdk.openadsdk.activity.TTRewardExpressVideoActivity.1
            boolean pA;

            @Override // com.bykv.vk.openvk.pA.pA.pA.ZZv.KZx.pA
            public void pA(long j2, int i) {
                if (this.pA) {
                    return;
                }
                this.pA = true;
                TTRewardExpressVideoActivity.this.ZZv.removeMessages(300);
                TTRewardExpressVideoActivity.this.DX();
                TTRewardExpressVideoActivity.this.Og.BF.pA(j2, j2);
                TTRewardExpressVideoActivity.this.Og.du.Og(true);
                if (TTRewardExpressVideoActivity.this.Og.Og.aBv() == 36 && TTRewardExpressVideoActivity.this.Og.KZx) {
                    TTRewardExpressVideoActivity.this.Og.WQf.KZx().ZZv();
                    Wx.Og();
                }
                if (TTRewardExpressVideoActivity.this.Og.Og.aBv() == 21 && !TTRewardExpressVideoActivity.this.Og.Og.ZZv()) {
                    TTRewardExpressVideoActivity.this.Og.Og.Og(true);
                    TTRewardExpressVideoActivity.this.Og.Vgu.aBv();
                }
                if (TTRewardExpressVideoActivity.this.Og.KZx) {
                    if (TTRewardExpressVideoActivity.this.Og.Og.xkc()) {
                        if (TTRewardExpressVideoActivity.this.Og.du.Bzk() == 1) {
                            TTRewardExpressVideoActivity.this.Og.qmB.KZx();
                        }
                    } else {
                        TTRewardExpressVideoActivity.this.pA(false, 5);
                        if (!yFO.ML(TTRewardExpressVideoActivity.this.Og.Og)) {
                            TTRewardExpressVideoActivity.this.Og.BF.pA(EventConstants.SKIP, true);
                        }
                    }
                } else if (TTRewardExpressVideoActivity.this.Og.Og.xkc()) {
                    if (TTRewardExpressVideoActivity.this.Og.du.Bzk() == 1) {
                        TTRewardExpressVideoActivity.this.Og.qmB.KZx();
                    }
                } else {
                    if (!yFO.ML(TTRewardExpressVideoActivity.this.Og.Og)) {
                        TTRewardExpressVideoActivity.this.Og.BF.pA(EventConstants.SKIP, true);
                    }
                    TTRewardExpressVideoActivity.this.finish();
                }
                TTRewardExpressVideoActivity.this.WV = (int) (System.currentTimeMillis() / 1000);
                TTRewardExpressVideoActivity.this.yFO();
            }

            @Override // com.bykv.vk.openvk.pA.pA.pA.ZZv.KZx.pA
            public void Og(long j2, int i) {
                TTRewardExpressVideoActivity.this.ZZv.removeMessages(300);
                if (TTRewardExpressVideoActivity.this.Og.BF.Og()) {
                    TTRewardExpressVideoActivity.this.Wx();
                    return;
                }
                TTRewardExpressVideoActivity.this.yFO();
                TTRewardExpressVideoActivity.this.Og.BF.Wx();
                if (TTRewardExpressVideoActivity.this.Og.KZx) {
                    TTRewardExpressVideoActivity.this.pA(false, 3);
                } else {
                    TTRewardExpressVideoActivity.this.finish();
                }
                TTRewardExpressVideoActivity.this.Og.du.pA(true);
                TTRewardExpressVideoActivity.this.Og.BF.pA(1 ^ (TTRewardExpressVideoActivity.this.Og.BF.eG() ? 1 : 0), 2);
            }

            @Override // com.bykv.vk.openvk.pA.pA.pA.ZZv.KZx.pA
            public void pA() {
                TTRewardExpressVideoActivity.this.ZZv.removeMessages(300);
                TTRewardExpressVideoActivity.this.DX();
                TTRewardExpressVideoActivity.this.yFO();
                if (TTRewardExpressVideoActivity.this.Og.KZx) {
                    TTRewardExpressVideoActivity.this.pA(false, 6);
                } else {
                    TTRewardExpressVideoActivity.this.finish();
                }
                TTRewardExpressVideoActivity.this.Og.BF.pA(!TTRewardExpressVideoActivity.this.Og.BF.eG() ? 1 : 0, !TTRewardExpressVideoActivity.this.Og.BF.eG() ? 1 : 0);
                TTRewardExpressVideoActivity.this.Og.BF.Wx();
            }

            @Override // com.bykv.vk.openvk.pA.pA.pA.ZZv.KZx.pA
            public void pA(long j2, long j3) {
                if (!TTRewardExpressVideoActivity.this.Og.fN && TTRewardExpressVideoActivity.this.Og.BF.Og()) {
                    TTRewardExpressVideoActivity.this.Og.BF.DX();
                }
                if (TTRewardExpressVideoActivity.this.Og.SGo.get()) {
                    return;
                }
                TTRewardExpressVideoActivity.this.ZZv.removeMessages(300);
                if (j2 != TTRewardExpressVideoActivity.this.Og.BF.omh()) {
                    TTRewardExpressVideoActivity.this.DX();
                }
                if (TTRewardExpressVideoActivity.this.Og.BF.Og()) {
                    TTRewardExpressVideoActivity.this.Og.BF.pA(j2, j3);
                    int iSGo = aBv.ZZv().SGo(String.valueOf(TTRewardExpressVideoActivity.this.Og.JG));
                    boolean z2 = TTRewardExpressVideoActivity.this.Og.du.omh() && iSGo >= 0;
                    TTRewardExpressVideoActivity tTRewardExpressVideoActivity = TTRewardExpressVideoActivity.this;
                    long j4 = j2 / 1000;
                    tTRewardExpressVideoActivity.JG = (int) (tTRewardExpressVideoActivity.Og.BF.roi() - j4);
                    int i = (int) j4;
                    if ((TTRewardExpressVideoActivity.this.Og.vZF.get() || TTRewardExpressVideoActivity.this.Og.BSW.get()) && TTRewardExpressVideoActivity.this.Og.BF.Og()) {
                        TTRewardExpressVideoActivity.this.Og.BF.DX();
                    }
                    if (TTRewardExpressVideoActivity.this.JG >= 0) {
                        TTRewardExpressVideoActivity.this.Og.qmB.pA(String.valueOf(TTRewardExpressVideoActivity.this.JG), null);
                    }
                    TTRewardExpressVideoActivity.this.Og.Vgu.ZZv(i);
                    TTRewardExpressVideoActivity.this.pA(j2, j3);
                    if (TTRewardExpressVideoActivity.this.Og.du != null && TTRewardExpressVideoActivity.this.Og.du.pA() != null) {
                        TTRewardExpressVideoActivity.this.Og.du.pA().setTime(String.valueOf(TTRewardExpressVideoActivity.this.JG), i, 0, false);
                    }
                    if (TTRewardExpressVideoActivity.this.JG > 0) {
                        if (z2 && i >= iSGo && TTRewardExpressVideoActivity.this.Og.Og.aBv() != 5 && TTRewardExpressVideoActivity.this.Og.Og.aBv() != 33) {
                            TTRewardExpressVideoActivity.this.Og.pA(true);
                            TTRewardExpressVideoActivity.this.Og.qmB.pA(String.valueOf(TTRewardExpressVideoActivity.this.JG), TTAdDislikeToast.getSkipText());
                            TTRewardExpressVideoActivity.this.Og.qmB.ML(true);
                            return;
                        }
                        TTRewardExpressVideoActivity.this.Og.qmB.pA(String.valueOf(TTRewardExpressVideoActivity.this.JG), null);
                    }
                }
            }
        });
        boolean zPA = this.Og.BF.pA(j, z, map, this.KZx);
        if (zPA && !z) {
            this.BSW = (int) (System.currentTimeMillis() / 1000);
        }
        return zPA;
    }
}
