package com.bytedance.sdk.openadsdk.XT.pA.pA;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.text.TextUtils;
import com.bytedance.sdk.component.omh.omh;
import com.bytedance.sdk.component.utils.WV;
import com.bytedance.sdk.openadsdk.ApmHelper;
import com.bytedance.sdk.openadsdk.core.Bzk;
import com.bytedance.sdk.openadsdk.core.aBv;
import com.bytedance.sdk.openadsdk.core.model.BF;
import com.bytedance.sdk.openadsdk.core.model.BSW;
import com.bytedance.sdk.openadsdk.core.model.yFO;
import com.bytedance.sdk.openadsdk.core.rB;
import com.bytedance.sdk.openadsdk.oem.IPMiBroadcastReceiver;
import com.bytedance.sdk.openadsdk.utils.gbA;
import com.bytedance.sdk.openadsdk.utils.xy;
import com.safedk.android.analytics.brandsafety.BrandSafetyUtils;
import com.safedk.android.utils.Logger;
import com.safedk.android.utils.h;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes11.dex */
public class ML implements JG {
    private static Boolean JG;
    public static Boolean pA;
    protected yFO KZx;
    protected int ML;
    protected com.bytedance.sdk.openadsdk.core.model.KZx Og;
    private final WeakReference<Context> SD;
    protected String ZZv;

    public static void safedk_Context_startActivity_97cb3195734cf5c9cc3418feeafa6dd6(Context p0, Intent p1) {
        Logger.d("SafeDK-Special|SafeDK: Call> Landroid/content/Context;->startActivity(Landroid/content/Intent;)V");
        if (p1 == null) {
            return;
        }
        BrandSafetyUtils.detectAdClick(p1, h.u);
        p0.startActivity(p1);
    }

    @Override // com.bytedance.sdk.openadsdk.XT.pA.pA.JG
    public void pA(boolean z) {
    }

    public ML(Context context, yFO yfo, String str) {
        this.SD = new WeakReference<>(context);
        this.KZx = yfo;
        this.Og = yfo.Wo();
        this.ZZv = str;
        new Object[]{str, "====tag===".concat(String.valueOf(str))};
        if (aBv.pA() == null) {
            aBv.Og(context);
        }
    }

    public static boolean pA(Context context, String str, String str2, String str3, yFO yfo) {
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

    private static boolean SD() {
        if (JG == null) {
            JG = Boolean.valueOf(gbA.omh(aBv.pA()));
        }
        return JG.booleanValue();
    }

    public static boolean pA(yFO yfo, String str, Context context, String str2, Map<String, Object> map) {
        Intent intentPA;
        if (yfo != null && yfo.Lm() == 0) {
            return false;
        }
        try {
            if (TextUtils.isEmpty(str) || (intentPA = gbA.pA(context, str)) == null) {
                return false;
            }
            intentPA.putExtra("START_ONLY_FOR_ANDROID", true);
            if (!(context instanceof Activity)) {
                intentPA.addFlags(268435456);
            }
            safedk_Context_startActivity_97cb3195734cf5c9cc3418feeafa6dd6(context, intentPA);
            if (map == null) {
                map = new HashMap<>();
            }
            if (yfo != null && yfo.Lf() == 0) {
                map.put("auto_click", Boolean.valueOf(!yfo.ZZv()));
            }
            map.put("can_query_install", Integer.valueOf(SD() ? 1 : 0));
            com.bytedance.sdk.openadsdk.ZZv.KZx.pA(yfo, str2, "click_open", map);
            return true;
        } catch (Throwable unused) {
        }
        return false;
    }

    @Override // com.bytedance.sdk.openadsdk.XT.pA.pA.JG
    public void pA(int i) {
        this.ML = i;
    }

    public boolean pA(Context context, String str, String str2) {
        return pA(context, str, str2, this.ZZv, this.KZx);
    }

    protected Context Og() {
        WeakReference<Context> weakReference = this.SD;
        return (weakReference == null || weakReference.get() == null) ? aBv.pA() : this.SD.get();
    }

    @Override // com.bytedance.sdk.openadsdk.XT.pA.pA.JG
    public void ZZv() {
        if (Og() == null) {
            return;
        }
        if (KZx()) {
            this.KZx.KZx(true);
            return;
        }
        if (pA()) {
            this.KZx.KZx(true);
            return;
        }
        if (JG()) {
            return;
        }
        if (ML()) {
            this.KZx.KZx(true);
        } else {
            if (this.KZx.Wo() != null || this.KZx.dC() == null) {
                return;
            }
            rB.pA(Og(), this.KZx.dC(), this.KZx, gbA.pA(this.ZZv), this.ZZv, true);
            this.KZx.KZx(true);
        }
    }

    public boolean KZx() {
        com.bytedance.sdk.openadsdk.core.ZZv.pA(this.KZx, this.ZZv, 1, null);
        BSW bswItl = this.KZx.Itl();
        if (bswItl == null) {
            com.bytedance.sdk.openadsdk.core.ZZv.pA(this.KZx, this.ZZv, -1, null);
            return false;
        }
        HashMap map = new HashMap();
        pA(map);
        String strPA = bswItl.pA();
        Context contextOg = Og();
        yFO yfo = this.KZx;
        if (KZx.pA(contextOg, strPA, yfo, gbA.Og(yfo), map, true)) {
            return true;
        }
        com.bytedance.sdk.openadsdk.ZZv.KZx.pA(this.KZx, this.ZZv, "open_fallback_url", map);
        return false;
    }

    private void pA(Map<String, Object> map) {
        yFO yfo = this.KZx;
        if (yfo != null && yfo.Lf() == 0) {
            yFO yfo2 = this.KZx;
            map.put("auto_click", Boolean.valueOf((yfo2 == null || yfo2.ZZv()) ? false : true));
        }
        yFO yfo3 = this.KZx;
        if (yfo3 != null && yfo3.Lf() == 0) {
            map.put("dpl_probability_jump", Boolean.valueOf(this.ML >= 11));
        }
        map.put("can_query_install", Integer.valueOf(SD() ? 1 : 0));
    }

    @Override // com.bytedance.sdk.openadsdk.XT.pA.pA.JG
    public boolean ML() {
        return this.Og != null && pA(Og(), this.Og.pA(), this.Og.KZx());
    }

    @Override // com.bytedance.sdk.openadsdk.XT.pA.pA.JG
    public boolean pA() {
        if (this.Og == null) {
            return false;
        }
        yFO yfo = this.KZx;
        if (yfo != null && yfo.Lm() == 0) {
            return false;
        }
        String strKZx = this.Og.KZx();
        if (TextUtils.isEmpty(strKZx)) {
            return false;
        }
        Context contextOg = Og();
        if (SD() && !gbA.Og(contextOg, strKZx)) {
            return false;
        }
        return pA(this.KZx, strKZx, contextOg, this.ZZv, new HashMap());
    }

    public boolean JG() {
        BF bfDL;
        IPMiBroadcastReceiver iPMiBroadcastReceiverPA;
        try {
            yFO yfo = this.KZx;
            if (yfo == null || (bfDL = yfo.dL()) == null || TextUtils.isEmpty(bfDL.Og())) {
                return false;
            }
            if (bfDL.pA() && this.KZx.Wo() != null && !TextUtils.isEmpty(this.KZx.Wo().KZx()) && (iPMiBroadcastReceiverPA = IPMiBroadcastReceiver.pA(Og())) != null) {
                iPMiBroadcastReceiverPA.pA(this.KZx.Wo().KZx(), this.KZx);
            }
            Context contextOg = Og();
            String strOg = bfDL.Og();
            yFO yfo2 = this.KZx;
            final boolean zPA = KZx.pA(contextOg, strOg, yfo2, gbA.Og(yfo2), null, true);
            xy.Og(new omh("task_oem_store") { // from class: com.bytedance.sdk.openadsdk.XT.pA.pA.ML.1
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
            WV.pA("GPDownLoader", th.getMessage());
            return false;
        }
    }
}
