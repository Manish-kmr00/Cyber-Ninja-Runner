package com.bytedance.sdk.openadsdk.core.BSW.KZx;

import android.content.Context;
import android.os.Looper;
import android.view.MotionEvent;
import android.view.View;
import com.bytedance.adsdk.ugeno.Og.KZx;
import com.bytedance.adsdk.ugeno.core.Bzk;
import com.bytedance.adsdk.ugeno.core.SGo;
import com.bytedance.adsdk.ugeno.core.WV;
import com.bytedance.adsdk.ugeno.core.Wx;
import com.bytedance.sdk.openadsdk.core.BSW.ML.ZZv;
import com.bytedance.sdk.openadsdk.utils.xy;
import com.pubmatic.sdk.openwrap.core.POBConstants;
import com.safedk.android.analytics.brandsafety.creatives.CreativeInfoManager;
import com.safedk.android.utils.Logger;
import com.safedk.android.utils.h;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes10.dex */
public class pA implements WV, Wx {
    private InterfaceC0226pA KZx;
    private KZx<View> Og;
    private Wx ZZv;
    private final Context pA;

    /* JADX INFO: renamed from: com.bytedance.sdk.openadsdk.core.BSW.KZx.pA$pA, reason: collision with other inner class name */
    interface InterfaceC0226pA {
        void pA(SGo sGo);
    }

    @Override // com.bytedance.adsdk.ugeno.core.WV
    public void pA(KZx kZx, String str, com.bytedance.adsdk.ugeno.ZZv.Og.pA pAVar) {
    }

    public pA(Context context) {
        this.pA = context;
    }

    public void pA(final JSONObject jSONObject, final JSONObject jSONObject2, final ZZv zZv) {
        if (Looper.myLooper() == Looper.getMainLooper()) {
            Og(jSONObject, jSONObject2, zZv);
        } else {
            xy.pA(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.BSW.KZx.pA.1
                @Override // java.lang.Runnable
                public void run() {
                    pA.this.Og(jSONObject, jSONObject2, zZv);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Og(JSONObject jSONObject, JSONObject jSONObject2, ZZv zZv) {
        try {
            Bzk bzk = new Bzk(this.pA);
            KZx<View> kZxPA = bzk.pA(jSONObject);
            this.Og = kZxPA;
            if (kZxPA == null) {
                if (zZv != null) {
                    zZv.pA(3000, "ugen render fail");
                    return;
                }
                return;
            }
            View viewBzk = kZxPA.Bzk();
            if (viewBzk != null) {
                viewBzk.setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.sdk.openadsdk.core.BSW.KZx.pA.2
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        Logger.d("Pangle|SafeDK: Execution> Lcom/bytedance/sdk/openadsdk/core/BSW/KZx/pA$2;->onClick(Landroid/view/View;)V");
                        CreativeInfoManager.onViewClicked(h.u, view);
                        safedk_pA$2_onClick_963d6c2b2d7d9d4962e0494cecf28f2f(view);
                    }

                    public void safedk_pA$2_onClick_963d6c2b2d7d9d4962e0494cecf28f2f(View p0) {
                    }
                });
            }
            bzk.pA((WV) this);
            bzk.pA((Wx) this);
            if (jSONObject2 != null) {
                try {
                    jSONObject2.put(POBConstants.KEY_LANGUAGE, com.bytedance.sdk.openadsdk.core.WV.Og());
                    jSONObject2.put("os", "Android");
                } catch (JSONException unused) {
                }
            }
            bzk.Og(jSONObject2);
            if (zZv != null) {
                zZv.pA(this.Og);
            }
        } catch (Exception e) {
            if (zZv != null) {
                zZv.pA(3000, "ugen render fail exception is" + e.getMessage());
            }
        }
    }

    public void pA(InterfaceC0226pA interfaceC0226pA) {
        this.KZx = interfaceC0226pA;
    }

    public void pA(Wx wx) {
        this.ZZv = wx;
    }

    @Override // com.bytedance.adsdk.ugeno.core.WV
    public void pA(SGo sGo, WV.Og og, WV.pA pAVar) {
        InterfaceC0226pA interfaceC0226pA;
        if (sGo == null) {
            return;
        }
        if ((sGo.Og() == 1 || sGo.Og() == 4) && (interfaceC0226pA = this.KZx) != null) {
            interfaceC0226pA.pA(sGo);
        }
        if (og == null || sGo.ZZv() == null) {
            return;
        }
        og.pA(sGo.ZZv());
    }

    @Override // com.bytedance.adsdk.ugeno.core.Wx
    public void pA(KZx kZx, MotionEvent motionEvent) {
        Wx wx = this.ZZv;
        if (wx != null) {
            wx.pA(kZx, motionEvent);
        }
    }
}
