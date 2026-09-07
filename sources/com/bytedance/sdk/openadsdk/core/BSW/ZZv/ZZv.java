package com.bytedance.sdk.openadsdk.core.BSW.ZZv;

import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;
import com.bytedance.adsdk.ugeno.core.SGo;
import com.bytedance.sdk.component.utils.DX;
import com.bytedance.sdk.component.utils.WV;
import com.bytedance.sdk.openadsdk.core.XT;
import com.bytedance.sdk.openadsdk.core.model.yFO;
import com.bytedance.sdk.openadsdk.core.widget.JG;
import com.bytedance.sdk.openadsdk.utils.gbA;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes11.dex */
public class ZZv {
    private JSONObject BSW;
    private final String Bzk;
    private boolean DX;
    private com.bytedance.adsdk.ugeno.Og.KZx KZx;
    private com.bytedance.adsdk.ugeno.Og.KZx ML;
    private final Context SD;
    private JG SGo;
    private boolean Sn;
    private final JSONObject WV;
    private boolean Wx;
    private com.bytedance.adsdk.ugeno.Og.KZx ZZv;
    private JSONArray oX;
    private final yFO omh;
    private int pA = -1;
    private int Og = -1;
    private final String JG = "UGenSwiperEvent";

    public ZZv(Context context, yFO yfo, String str, JSONObject jSONObject) {
        this.SD = context;
        this.omh = yfo;
        this.Bzk = str;
        this.WV = jSONObject;
    }

    public void pA(com.bytedance.adsdk.ugeno.Og.KZx<View> kZx) {
        com.bytedance.adsdk.ugeno.Og.KZx<T> KZx = kZx.KZx("swiperLayout");
        this.ML = KZx;
        if (KZx instanceof com.bytedance.adsdk.ugeno.Og) {
            this.oX = this.WV.optJSONArray("dpa_data");
            this.KZx = kZx.KZx("swiperLeftArrow");
            this.ZZv = kZx.KZx("swiperRightArrow");
            ((com.bytedance.adsdk.ugeno.Og) this.ML).pA(new com.bytedance.adsdk.ugeno.JG.KZx() { // from class: com.bytedance.sdk.openadsdk.core.BSW.ZZv.ZZv.1
                @Override // com.bytedance.adsdk.ugeno.JG.KZx
                public void pA(boolean z, int i, int i2, boolean z2, boolean z3) {
                    ZZv.this.Og = i;
                    ZZv.this.pA = i2;
                    ZZv.this.Wx = z;
                    ZZv.this.Sn = z2;
                    ZZv.this.DX = z3;
                    ZZv.this.pA(z, z2, z3);
                    ZZv.this.pA(i);
                }
            });
        }
    }

    public void pA() {
        pA(this.Wx, this.Sn, this.DX);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void pA(boolean z, boolean z2, boolean z3) {
        com.bytedance.adsdk.ugeno.Og.KZx kZx = this.KZx;
        if (kZx == null || this.ZZv == null) {
            return;
        }
        View viewBzk = kZx.Bzk();
        View viewBzk2 = this.ZZv.Bzk();
        JSONArray jSONArray = this.oX;
        if (jSONArray != null && jSONArray.length() == 1) {
            viewBzk.setVisibility(8);
            viewBzk2.setVisibility(8);
            return;
        }
        if (z) {
            return;
        }
        if (z2) {
            if (viewBzk instanceof TextView) {
                pA((TextView) viewBzk, 90);
            }
            if (viewBzk2 instanceof TextView) {
                pA((TextView) viewBzk2, 255);
                return;
            }
            return;
        }
        if (z3) {
            if (viewBzk instanceof TextView) {
                pA((TextView) viewBzk, 255);
            }
            if (viewBzk2 instanceof TextView) {
                pA((TextView) viewBzk2, 90);
                return;
            }
            return;
        }
        if (viewBzk instanceof TextView) {
            pA((TextView) viewBzk, 255);
        }
        if (viewBzk2 instanceof TextView) {
            pA((TextView) viewBzk2, 255);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void pA(int i) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("index", i);
        } catch (Throwable unused) {
        }
        com.bytedance.sdk.openadsdk.ZZv.KZx.Og(this.omh, this.Bzk, "carousel_show", jSONObject);
    }

    private void pA(TextView textView, int i) {
        int currentTextColor = textView.getCurrentTextColor();
        textView.setTextColor(Color.argb(i, Color.red(currentTextColor), Color.green(currentTextColor), Color.blue(currentTextColor)));
    }

    public void Og() {
        int i;
        com.bytedance.adsdk.ugeno.Og.KZx kZx = this.ML;
        if (!(kZx instanceof com.bytedance.adsdk.ugeno.Og) || (i = this.pA) == -1) {
            return;
        }
        ((com.bytedance.adsdk.ugeno.Og) kZx).pA(i - 1);
    }

    public void KZx() {
        int i;
        com.bytedance.adsdk.ugeno.Og.KZx kZx = this.ML;
        if (!(kZx instanceof com.bytedance.adsdk.ugeno.Og) || (i = this.pA) == -1) {
            return;
        }
        ((com.bytedance.adsdk.ugeno.Og) kZx).pA(i + 1);
    }

    public void pA(JG jg) {
        this.SGo = jg;
    }

    public boolean pA(SGo sGo) {
        JSONObject jSONObjectOptJSONObject;
        this.BSW = null;
        int i = this.Og;
        if (i != -1 && i != 0) {
            try {
                JSONObject jSONObjectKZx = sGo.KZx();
                if (jSONObjectKZx != null && (jSONObjectOptJSONObject = jSONObjectKZx.optJSONObject("related_dpa_click")) != null) {
                    boolean zOptBoolean = jSONObjectOptJSONObject.optBoolean("enableOpenExternalUrl");
                    int iOptInt = jSONObjectOptJSONObject.optInt("landingStyle");
                    if (zOptBoolean && iOptInt != -1) {
                        if (this.oX != null) {
                            String strPA = com.bytedance.adsdk.ugeno.KZx.Og.pA(jSONObjectOptJSONObject.optString("url"), this.oX.optJSONObject(this.Og));
                            String strPA2 = com.bytedance.adsdk.ugeno.KZx.Og.pA(jSONObjectOptJSONObject.optString("fallback_url"), this.oX.optJSONObject(this.Og));
                            jSONObjectOptJSONObject.put("url", strPA);
                            jSONObjectOptJSONObject.put("fallback_url", strPA2);
                            pA(jSONObjectOptJSONObject, this.oX.optJSONObject(this.Og));
                        }
                        pA(jSONObjectOptJSONObject, sGo.pA().Bzk());
                        return true;
                    }
                    return false;
                }
            } catch (Throwable th) {
                WV.pA("UGenSwiperEvent", th.getMessage());
            }
        }
        return false;
    }

    private void pA(JSONObject jSONObject, JSONObject jSONObject2) {
        if (jSONObject == null || jSONObject2 == null) {
            return;
        }
        JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject("clickInfo");
        this.BSW = jSONObjectOptJSONObject;
        if (jSONObjectOptJSONObject != null) {
            Iterator<String> itKeys = jSONObjectOptJSONObject.keys();
            while (itKeys.hasNext()) {
                String next = itKeys.next();
                try {
                    this.BSW.putOpt(next, com.bytedance.adsdk.ugeno.KZx.Og.pA((String) this.BSW.opt(next), jSONObject2));
                } catch (Throwable unused) {
                }
            }
            try {
                jSONObject.putOpt("clickInfo", this.BSW);
            } catch (Throwable unused2) {
            }
        }
    }

    public JSONObject ZZv() {
        return this.BSW;
    }

    /* JADX WARN: Code duplicated, block: B:17:0x001f  */
    /* JADX WARN: Code duplicated, block: B:24:? A[RETURN, SYNTHETIC] */
    private boolean pA(int i, String str, String str2) {
        if (i == 1) {
            if (!DX.pA(str)) {
                return false;
            }
        } else if (i != 2) {
            if (i == 3) {
                if (!DX.pA(str)) {
                    return false;
                }
            }
        } else if ((TextUtils.isEmpty(str) && TextUtils.isEmpty(str2)) || !DX.pA(str2)) {
            return false;
        }
        return true;
    }

    private void pA(JSONObject jSONObject, View view) {
        if (pA(jSONObject.optInt("landingStyle"), jSONObject.optString("url"), jSONObject.optString("fallback_url"))) {
            XT.pA(pA(view), this.SD instanceof Activity, jSONObject, this.omh, this.Bzk, gbA.pA(this.Bzk), null, this.SGo);
        }
    }

    private Context pA(View view) {
        Activity activityPA = view != null ? com.bytedance.sdk.component.utils.Og.pA(view) : null;
        return activityPA == null ? this.SD : activityPA;
    }
}
