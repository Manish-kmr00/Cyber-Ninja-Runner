package com.bytedance.sdk.openadsdk.XT.pA.pA;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.text.TextUtils;
import com.bytedance.sdk.component.omh.omh;
import com.bytedance.sdk.openadsdk.ApmHelper;
import com.bytedance.sdk.openadsdk.ZZv.WV;
import com.bytedance.sdk.openadsdk.core.Bzk;
import com.bytedance.sdk.openadsdk.core.aBv;
import com.bytedance.sdk.openadsdk.core.model.BF;
import com.bytedance.sdk.openadsdk.core.model.yFO;
import com.bytedance.sdk.openadsdk.core.rB;
import com.bytedance.sdk.openadsdk.oem.IPMiBroadcastReceiver;
import com.bytedance.sdk.openadsdk.utils.gbA;
import com.bytedance.sdk.openadsdk.utils.xy;
import com.facebook.gamingservices.cloudgaming.internal.SDKConstants;
import com.safedk.android.analytics.brandsafety.BrandSafetyUtils;
import com.safedk.android.utils.Logger;
import com.safedk.android.utils.h;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public class ZZv implements JG {
    protected int JG;
    protected String KZx;
    protected yFO Og;
    private final WeakReference<Context> SD;
    protected com.bytedance.sdk.openadsdk.core.model.KZx pA;
    protected boolean ZZv = false;
    protected final AtomicBoolean ML = new AtomicBoolean(false);
    private boolean omh = false;

    public static void safedk_Context_startActivity_97cb3195734cf5c9cc3418feeafa6dd6(Context p0, Intent p1) {
        Logger.d("SafeDK-Special|SafeDK: Call> Landroid/content/Context;->startActivity(Landroid/content/Intent;)V");
        if (p1 == null) {
            return;
        }
        BrandSafetyUtils.detectAdClick(p1, h.u);
        p0.startActivity(p1);
    }

    public ZZv(Context context, yFO yfo, String str) {
        this.SD = new WeakReference<>(context);
        this.Og = yfo;
        this.pA = yfo.Wo();
        this.KZx = str;
        new Object[]{str, "====tag===".concat(String.valueOf(str))};
        if (aBv.pA() == null) {
            aBv.Og(context);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.XT.pA.pA.JG
    public void pA(boolean z) {
        this.omh = z;
    }

    @Override // com.bytedance.sdk.openadsdk.XT.pA.pA.JG
    public void pA(int i) {
        this.JG = i;
    }

    public boolean pA(Context context, String str, String str2) {
        return pA(context, str, str2, this.KZx, this.Og);
    }

    public static boolean pA(Context context, String str, String str2, String str3, yFO yfo) {
        if (KZx.pA()) {
            return ML.pA(context, str, str2, str3, yfo);
        }
        if (!TextUtils.isEmpty(str3) && str3.contains("_landingpage")) {
            str3 = str3.replace("_landingpage", "");
        }
        if (!TextUtils.isEmpty(str)) {
            try {
                Intent intent = new Intent("android.intent.action.VIEW", Uri.parse(str));
                intent.setFlags(268435456);
                safedk_Context_startActivity_97cb3195734cf5c9cc3418feeafa6dd6(context, intent);
                com.bytedance.sdk.openadsdk.ZZv.KZx.Og(yfo, str3, "store_open", (JSONObject) null);
                return true;
            } catch (Throwable unused) {
            }
        }
        if (context != null && str2 != null && !TextUtils.isEmpty(str2)) {
            try {
                Intent intent2 = new Intent("android.intent.action.VIEW");
                Uri uri = Uri.parse("market://details?id=".concat(String.valueOf(str2)));
                intent2.setData(uri);
                Iterator<ResolveInfo> it = context.getPackageManager().queryIntentActivities(intent2, 65536).iterator();
                while (it.hasNext()) {
                    if (it.next().activityInfo.packageName.equals("com.android.vending") && context.getPackageManager().getLaunchIntentForPackage("com.android.vending") != null) {
                        Intent intent3 = new Intent("android.intent.action.VIEW");
                        intent3.setData(uri);
                        intent3.setPackage("com.android.vending");
                        if (!(context instanceof Activity)) {
                            intent3.setFlags(268435456);
                        }
                        safedk_Context_startActivity_97cb3195734cf5c9cc3418feeafa6dd6(context, intent3);
                        com.bytedance.sdk.openadsdk.ZZv.KZx.Og(yfo, str3, "store_open", (JSONObject) null);
                        return true;
                    }
                }
                return false;
            } catch (Throwable th) {
                ApmHelper.reportCustomError("gotoGooglePlayByPackageNameAndUrl error", "gotoGooglePlay", th);
            }
        }
        return false;
    }

    protected Context KZx() {
        WeakReference<Context> weakReference = this.SD;
        return (weakReference == null || weakReference.get() == null) ? aBv.pA() : this.SD.get();
    }

    @Override // com.bytedance.sdk.openadsdk.XT.pA.pA.JG
    public void ZZv() {
        if (KZx() == null) {
            return;
        }
        if (Og()) {
            this.ML.set(true);
            this.Og.KZx(true);
            return;
        }
        if (pA()) {
            this.Og.KZx(true);
            return;
        }
        if (JG()) {
            return;
        }
        if (ML()) {
            this.Og.KZx(true);
        } else {
            if (this.Og.Wo() != null || this.Og.dC() == null) {
                return;
            }
            rB.pA(KZx(), this.Og.dC(), this.Og, gbA.pA(this.KZx), this.KZx, true);
            this.Og.KZx(true);
        }
    }

    public boolean Og() {
        com.bytedance.sdk.openadsdk.core.ZZv.pA(this.Og, this.KZx, 1, null);
        if (this.Og.Itl() != null) {
            String strPA = this.Og.Itl().pA();
            if (!TextUtils.isEmpty(strPA)) {
                Uri uri = Uri.parse(strPA);
                Intent intent = new Intent("android.intent.action.VIEW");
                intent.setData(uri);
                gbA.Og Og = gbA.Og(KZx(), intent);
                if (Og.Og > 0) {
                    if (!(KZx() instanceof Activity)) {
                        intent.addFlags(268435456);
                    }
                    try {
                        Map<String, Object> map = new HashMap<>();
                        pA(map);
                        map.put("matched_count", Integer.valueOf(Og.Og));
                        map.put("url", strPA);
                        if (Og.pA != null) {
                            intent.setComponent(Og.pA);
                        }
                        com.bytedance.sdk.openadsdk.ZZv.KZx.pA(this.Og, this.KZx, "open_url_app", map);
                        safedk_Context_startActivity_97cb3195734cf5c9cc3418feeafa6dd6(KZx(), intent);
                        WV.pA().pA(map).pA(this.Og, this.KZx);
                        com.bytedance.sdk.openadsdk.ZZv.KZx.pA("dp_start_act_success", this.Og, this.KZx, map);
                        return true;
                    } catch (Throwable th) {
                        JSONObject jSONObject = new JSONObject();
                        try {
                            jSONObject.put("exception", th.getMessage());
                            jSONObject.put(SDKConstants.PARAM_INTENT, intent.toString());
                            jSONObject.put("can_query_install", 1);
                        } catch (Exception unused) {
                        }
                        com.bytedance.sdk.openadsdk.core.ZZv.pA(this.Og, this.KZx, -4, jSONObject);
                    }
                } else {
                    JSONObject jSONObject2 = new JSONObject();
                    try {
                        jSONObject2.put(SDKConstants.PARAM_INTENT, intent.toString());
                        jSONObject2.put("can_query_install", 1);
                    } catch (Exception unused2) {
                    }
                    com.bytedance.sdk.openadsdk.core.ZZv.pA(this.Og, this.KZx, -3, jSONObject2);
                }
            } else {
                yFO yfo = this.Og;
                com.bytedance.sdk.openadsdk.core.ZZv.pA(yfo, this.KZx, -2, yfo.Itl().ZZv());
            }
            if (this.ZZv && !this.ML.get()) {
                return false;
            }
            this.ZZv = true;
            Map<String, Object> map2 = new HashMap<>();
            pA(map2);
            com.bytedance.sdk.openadsdk.ZZv.KZx.pA(this.Og, this.KZx, "open_fallback_url", map2);
            return false;
        }
        com.bytedance.sdk.openadsdk.core.ZZv.pA(this.Og, this.KZx, -1, null);
        return false;
    }

    private void pA(Map<String, Object> map) {
        yFO yfo = this.Og;
        if (yfo != null && yfo.Lf() == 0) {
            yFO yfo2 = this.Og;
            map.put("auto_click", Boolean.valueOf((yfo2 == null || yfo2.ZZv()) ? false : true));
        }
        yFO yfo3 = this.Og;
        if (yfo3 != null && yfo3.Lf() == 0) {
            map.put("dpl_probability_jump", Boolean.valueOf(this.JG >= 11));
        }
        map.put("can_query_install", 1);
    }

    @Override // com.bytedance.sdk.openadsdk.XT.pA.pA.JG
    public boolean ML() {
        this.ML.set(true);
        return this.pA != null && pA(KZx(), this.pA.pA(), this.pA.KZx());
    }

    @Override // com.bytedance.sdk.openadsdk.XT.pA.pA.JG
    public boolean pA() {
        Intent intentPA;
        if (this.pA == null) {
            return false;
        }
        yFO yfo = this.Og;
        if (yfo != null && yfo.Lm() == 0) {
            return false;
        }
        String strKZx = this.pA.KZx();
        if (TextUtils.isEmpty(strKZx) || !gbA.Og(KZx(), strKZx) || (intentPA = gbA.pA(KZx(), strKZx)) == null) {
            return false;
        }
        intentPA.putExtra("START_ONLY_FOR_ANDROID", true);
        try {
            safedk_Context_startActivity_97cb3195734cf5c9cc3418feeafa6dd6(KZx(), intentPA);
            HashMap map = new HashMap();
            pA(map);
            com.bytedance.sdk.openadsdk.ZZv.KZx.pA(this.Og, this.KZx, "click_open", map);
            return true;
        } catch (Throwable th) {
            com.bytedance.sdk.component.utils.WV.pA("GPDownLoader", th.getMessage());
            return false;
        }
    }

    public boolean JG() {
        BF bfDL;
        IPMiBroadcastReceiver iPMiBroadcastReceiverPA;
        try {
            yFO yfo = this.Og;
            if (yfo == null || (bfDL = yfo.dL()) == null || TextUtils.isEmpty(bfDL.Og())) {
                return false;
            }
            if (bfDL.pA() && this.Og.Wo() != null && !TextUtils.isEmpty(this.Og.Wo().KZx()) && (iPMiBroadcastReceiverPA = IPMiBroadcastReceiver.pA(KZx())) != null) {
                iPMiBroadcastReceiverPA.pA(this.Og.Wo().KZx(), this.Og);
            }
            final boolean zPA = Og.pA(KZx(), bfDL.Og(), this.Og);
            xy.Og(new omh("task_oem_store") { // from class: com.bytedance.sdk.openadsdk.XT.pA.pA.ZZv.1
                @Override // java.lang.Runnable
                public void run() {
                    if (zPA) {
                        Bzk.pA("oem_store", "1");
                    } else {
                        Bzk.pA("oem_store", "-2");
                    }
                }
            });
            return zPA;
        } catch (Throwable th) {
            com.bytedance.sdk.component.utils.WV.pA("GPDownLoader", th.getMessage());
            return false;
        }
    }
}
