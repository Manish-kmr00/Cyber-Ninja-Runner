package com.bytedance.sdk.openadsdk.core;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;
import com.bytedance.sdk.openadsdk.BuildConfig;
import com.bytedance.sdk.openadsdk.TTAdConstant;
import com.bytedance.sdk.openadsdk.activity.TTLandingPageActivity;
import com.bytedance.sdk.openadsdk.activity.TTPlayableLandingPageActivity;
import com.bytedance.sdk.openadsdk.activity.TTVideoLandingPageLink2Activity;
import com.bytedance.sdk.openadsdk.api.PangleAd;
import com.bytedance.sdk.openadsdk.api.nativeAd.PAGNativeAd;
import com.bytedance.sdk.openadsdk.utils.gbA;
import com.facebook.gamingservices.cloudgaming.internal.SDKConstants;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.safedk.android.analytics.brandsafety.BrandSafetyUtils;
import com.safedk.android.utils.Logger;
import com.safedk.android.utils.h;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes13.dex */
public class rB {
    private static boolean pA;

    public static void safedk_Context_startActivity_97cb3195734cf5c9cc3418feeafa6dd6(Context p0, Intent p1) {
        Logger.d("SafeDK-Special|SafeDK: Call> Landroid/content/Context;->startActivity(Landroid/content/Intent;)V");
        if (p1 == null) {
            return;
        }
        BrandSafetyUtils.detectAdClick(p1, h.u);
        p0.startActivity(p1);
    }

    public static void pA(boolean z) {
        pA = z;
    }

    private static com.bytedance.sdk.openadsdk.Sn.pA.Og pA(int i, com.bytedance.sdk.openadsdk.core.model.yFO yfo) {
        com.bytedance.sdk.openadsdk.Sn.pA.Og og = new com.bytedance.sdk.openadsdk.Sn.pA.Og();
        og.pA(com.bytedance.sdk.openadsdk.ZZv.Og.pA.pA);
        og.pA(yfo);
        og.Og(gbA.pA(yfo));
        og.pA(i);
        og.pA(false);
        og.Og(yfo.JBA());
        return og;
    }

    public static boolean pA(Context context, com.bytedance.sdk.openadsdk.core.model.yFO yfo, int i, PAGNativeAd pAGNativeAd, PangleAd pangleAd, String str, com.bytedance.sdk.openadsdk.XT.pA.pA.JG jg, boolean z, int i2) {
        String strPA;
        com.bytedance.sdk.openadsdk.ZZv.KZx.pA(pA(-1, yfo));
        if (context == null || yfo == null || i == -1) {
            com.bytedance.sdk.openadsdk.ZZv.KZx.pA(pA(1, yfo));
            return false;
        }
        com.bytedance.sdk.openadsdk.core.model.BSW bswItl = yfo.Itl();
        HashMap map = new HashMap();
        if (yfo.Lf() == 0) {
            map.put("dpl_probability_jump", Boolean.valueOf(i2 >= 11));
        }
        if (i2 != 0 && yfo.rjD()) {
            map.put("dsp_click_type", Integer.valueOf(i2));
        }
        if (bswItl != null && !TextUtils.isEmpty(bswItl.pA())) {
            if (pA(context, yfo, i, str, z, map)) {
                com.bytedance.sdk.openadsdk.ZZv.KZx.pA(pA(2, yfo));
                return true;
            }
            if (bswItl.KZx() != 2 || yfo.RS() == 5 || yfo.RS() == 15) {
                if (bswItl.KZx() == 1 && !TextUtils.isEmpty(bswItl.Og())) {
                    strPA = bswItl.Og();
                } else {
                    strPA = pA(yfo);
                }
            } else if (jg != null) {
                if (!jg.pA()) {
                    if (jg.ML()) {
                        com.bytedance.sdk.openadsdk.ZZv.KZx.pA(yfo, str, "open_fallback_url", map);
                        com.bytedance.sdk.openadsdk.ZZv.KZx.pA(pA(3, yfo));
                        return true;
                    }
                    strPA = pA(bswItl, yfo);
                    com.bytedance.sdk.openadsdk.ZZv.KZx.pA(pA(3, yfo));
                } else {
                    com.bytedance.sdk.openadsdk.ZZv.KZx.pA(yfo, str, "open_fallback_url", map);
                    com.bytedance.sdk.openadsdk.ZZv.KZx.pA(pA(3, yfo));
                    return true;
                }
            } else {
                strPA = pA(bswItl, yfo);
            }
            com.bytedance.sdk.openadsdk.ZZv.KZx.pA(yfo, str, "open_fallback_url", map);
        } else {
            strPA = pA(yfo);
        }
        String str2 = strPA;
        new Object[]{"url is：", str2};
        if (yfo.Lf() == 0 && !TextUtils.isEmpty(str2) && str2.contains("play.google.com/store")) {
            String strSubstring = str2.substring(str2.indexOf("?id=") + 4);
            com.bytedance.sdk.openadsdk.ZZv.KZx.pA(pA(4, yfo));
            return com.bytedance.sdk.openadsdk.XT.pA.pA.ZZv.pA(context, str2, strSubstring, str, yfo);
        }
        return pA(context, yfo, i, pAGNativeAd, pangleAd, str, z, str2);
    }

    private static String pA(com.bytedance.sdk.openadsdk.core.model.BSW bsw, com.bytedance.sdk.openadsdk.core.model.yFO yfo) {
        if (!TextUtils.isEmpty(bsw.Og())) {
            return bsw.Og();
        }
        return pA(yfo);
    }

    private static String pA(com.bytedance.sdk.openadsdk.core.model.yFO yfo) {
        if (!yfo.rjD() || yfo.dGZ() == null) {
            return yfo.dC();
        }
        return yfo.dGZ().Bzk();
    }

    public static boolean pA(Context context, com.bytedance.sdk.openadsdk.core.model.yFO yfo, int i, String str, boolean z, Map<String, Object> map) {
        if (yfo == null) {
            return false;
        }
        com.bytedance.sdk.openadsdk.core.model.BSW bswItl = yfo.Itl();
        if (bswItl == null || TextUtils.isEmpty(bswItl.pA())) {
            ZZv.pA(yfo, str, bswItl == null ? -1 : -2, bswItl != null ? bswItl.ZZv() : null);
            return false;
        }
        if (map == null) {
            map = new HashMap<>();
        }
        Map<String, Object> map2 = map;
        String strPA = bswItl.pA();
        if (com.bytedance.sdk.openadsdk.XT.pA.pA.KZx.pA()) {
            return com.bytedance.sdk.openadsdk.XT.pA.pA.KZx.pA(context, strPA, yfo, i, map2, z);
        }
        Uri uri = Uri.parse(strPA);
        Intent intent = new Intent("android.intent.action.VIEW");
        intent.setData(uri);
        if (gbA.omh(context)) {
            gbA.Og Og = gbA.Og(context, intent);
            if (Og.Og > 0) {
                if (aBv.ZZv().omh()) {
                    gbA.pA(yfo, str);
                }
                if (!(context instanceof Activity)) {
                    intent.addFlags(268435456);
                }
                map2.put("can_query_install", 1);
                map2.put("matched_count", Integer.valueOf(Og.Og));
                map2.put("url", strPA);
                if (Og.pA != null) {
                    intent.setComponent(Og.pA);
                }
                com.bytedance.sdk.openadsdk.ZZv.KZx.pA(yfo, str, "open_url_app", map2);
                try {
                    safedk_Context_startActivity_97cb3195734cf5c9cc3418feeafa6dd6(context, intent);
                    com.bytedance.sdk.openadsdk.ZZv.WV.pA().pA(map2).pA(yfo, str);
                    com.bytedance.sdk.openadsdk.ZZv.KZx.pA("dp_start_act_success", yfo, str, map2);
                    return true;
                } catch (Exception e) {
                    JSONObject jSONObject = new JSONObject();
                    try {
                        jSONObject.put("exception", e.getMessage());
                        jSONObject.put(SDKConstants.PARAM_INTENT, intent.toString());
                        jSONObject.put("can_query_install", 1);
                    } catch (Exception unused) {
                    }
                    ZZv.pA(yfo, str, -4, jSONObject);
                    if (!aBv.ZZv().omh()) {
                        pA(context, yfo.dC(), yfo, i, str, z);
                        com.bytedance.sdk.component.utils.WV.pA("WebHelper", "openDetailPage() -> context.startActivity(intent) fail :", e);
                    }
                    return false;
                }
            }
            JSONObject jSONObject2 = new JSONObject();
            try {
                jSONObject2.put(SDKConstants.PARAM_INTENT, intent.toString());
                jSONObject2.put("can_query_install", 1);
            } catch (Exception unused2) {
            }
            ZZv.pA(yfo, str, -3, jSONObject2);
        } else {
            try {
                if (aBv.ZZv().omh()) {
                    gbA.pA(yfo, str);
                }
                if (!(context instanceof Activity)) {
                    intent.addFlags(268435456);
                }
                map2.put("can_query_install", 0);
                com.bytedance.sdk.openadsdk.ZZv.KZx.pA(yfo, str, "open_url_app", map2);
                safedk_Context_startActivity_97cb3195734cf5c9cc3418feeafa6dd6(context, intent);
                com.bytedance.sdk.openadsdk.ZZv.WV.pA().pA(map2).pA(yfo, str);
                return true;
            } catch (Throwable unused3) {
            }
        }
        return false;
    }

    public static boolean pA(Context context, com.bytedance.sdk.openadsdk.core.model.yFO yfo, int i, PAGNativeAd pAGNativeAd, PangleAd pangleAd, String str, boolean z, String str2) {
        if (!TextUtils.isEmpty(str2) || com.bytedance.sdk.openadsdk.core.model.WQf.Og(yfo)) {
            int iJBA = yfo.JBA();
            if (iJBA == 2 || iJBA == 8) {
                return com.bytedance.sdk.openadsdk.utils.vZF.pA(context, str2, yfo, com.bytedance.sdk.openadsdk.ZZv.Og.pA.pA);
            }
            com.bytedance.sdk.component.utils.Og.pA(context, pA(context, str2, yfo, i, pAGNativeAd, pangleAd, str, z), null);
            pA = false;
            return true;
        }
        com.bytedance.sdk.openadsdk.ZZv.KZx.pA(pA(5, yfo));
        return false;
    }

    public static boolean pA(Context context, String str, com.bytedance.sdk.openadsdk.core.model.yFO yfo, int i, String str2, boolean z) {
        try {
            safedk_Context_startActivity_97cb3195734cf5c9cc3418feeafa6dd6(context, pA(context, str, yfo, i, (PAGNativeAd) null, (PangleAd) null, str2, z));
            return true;
        } catch (Throwable unused) {
            return false;
        }
    }

    public static boolean Og(Context context, String str, com.bytedance.sdk.openadsdk.core.model.yFO yfo, int i, String str2, boolean z) {
        try {
            Intent intentPA = pA(context, str, yfo, i, (PAGNativeAd) null, (PangleAd) null, str2, z, true);
            if (!(context instanceof Activity)) {
                intentPA.addFlags(268435456);
            }
            safedk_Context_startActivity_97cb3195734cf5c9cc3418feeafa6dd6(context, intentPA);
            return true;
        } catch (Throwable unused) {
            return false;
        }
    }

    private static Intent pA(Context context, String str, com.bytedance.sdk.openadsdk.core.model.yFO yfo, int i, PAGNativeAd pAGNativeAd, PangleAd pangleAd, String str2, boolean z) {
        return pA(context, str, yfo, i, pAGNativeAd, pangleAd, str2, z, false);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private static Intent pA(Context context, String str, com.bytedance.sdk.openadsdk.core.model.yFO yfo, int i, PAGNativeAd pAGNativeAd, PangleAd pangleAd, String str2, boolean z, boolean z2) {
        Intent intent;
        if (!z2 && com.bytedance.sdk.openadsdk.core.model.WQf.Og(yfo) && (pAGNativeAd != 0 || pangleAd != null)) {
            intent = new Intent(context, (Class<?>) TTPlayableLandingPageActivity.class);
            intent.putExtra("ad_pending_download", pA(yfo, z));
            String strWV = com.bytedance.sdk.openadsdk.core.model.WQf.WV(yfo);
            if (!TextUtils.isEmpty(strWV)) {
                if (strWV.contains("?")) {
                    str = strWV + "&orientation=portrait";
                } else {
                    str = strWV + "?orientation=portrait";
                }
            }
        } else {
            intent = (z2 || yfo.JBA() != 3 || !(yfo.aBv() == 2 || (yfo.aBv() == 1 && pA)) || yfo.gl()) ? new Intent(context, (Class<?>) TTLandingPageActivity.class) : new Intent(context, (Class<?>) TTVideoLandingPageLink2Activity.class);
        }
        intent.putExtra("url", str);
        intent.putExtra("gecko_id", yfo.Gag());
        intent.putExtra("web_title", yfo.SXO());
        intent.putExtra("sdk_version", BuildConfig.VERSION_CODE);
        intent.putExtra("adid", yfo.nCO());
        intent.putExtra("log_extra", yfo.tM());
        com.bytedance.sdk.openadsdk.multipro.Og.pA pAVarKZx = null;
        intent.putExtra(CampaignEx.JSON_KEY_ICON_URL, yfo.fJy() == null ? null : yfo.fJy().pA());
        intent.putExtra("event_tag", str2);
        intent.putExtra("source", i);
        if (!(context instanceof Activity)) {
            intent.addFlags(268435456);
        }
        if (com.bytedance.sdk.openadsdk.multipro.Og.KZx()) {
            intent.putExtra(TTAdConstant.MULTI_PROCESS_MATERIALMETA, yfo.jO().toString());
        } else {
            TV.pA().JG();
            TV.pA().pA(yfo);
        }
        if (yfo.RS() == 5 || yfo.RS() == 15 || yfo.RS() == 50) {
            if (pAGNativeAd != 0) {
                if (pAGNativeAd instanceof com.bytedance.sdk.openadsdk.multipro.Og.pA.InterfaceC0252pA) {
                    pAVarKZx = ((com.bytedance.sdk.openadsdk.multipro.Og.pA.InterfaceC0252pA) pAGNativeAd).JG();
                } else if (pAGNativeAd instanceof com.bytedance.sdk.openadsdk.pA.Og.pA.Og) {
                    pAVarKZx = ((com.bytedance.sdk.openadsdk.pA.Og.pA.Og) pAGNativeAd).Og();
                }
                if (pAVarKZx != null) {
                    intent.putExtra(TTAdConstant.MULTI_PROCESS_DATA, pAVarKZx.pA().toString());
                }
            }
            if ((pangleAd instanceof com.bytedance.sdk.openadsdk.core.KZx.JG) && (pAVarKZx = ((com.bytedance.sdk.openadsdk.core.KZx.JG) pangleAd).KZx()) != null) {
                intent.putExtra(TTAdConstant.MULTI_PROCESS_DATA, pAVarKZx.pA().toString());
            }
            if (pAVarKZx != null) {
                intent.putExtra("video_is_auto_play", pAVarKZx.ZZv);
                if (com.bytedance.sdk.component.utils.WV.ZZv()) {
                    pAVarKZx.pA().toString();
                }
            }
        }
        return intent;
    }

    private static boolean pA(com.bytedance.sdk.openadsdk.core.model.yFO yfo, boolean z) {
        if (z && yfo != null && yfo.JBA() == 4) {
            return com.bytedance.sdk.openadsdk.core.model.WQf.Og(yfo);
        }
        return false;
    }
}
