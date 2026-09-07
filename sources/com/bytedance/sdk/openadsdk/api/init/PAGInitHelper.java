package com.bytedance.sdk.openadsdk.api.init;

import android.content.Context;
import android.provider.Settings;
import android.text.TextUtils;
import com.bytedance.sdk.component.adexpress.pA.Og.Og;
import com.bytedance.sdk.openadsdk.ApmHelper;
import com.bytedance.sdk.openadsdk.ZZv.pA.ZZv;
import com.bytedance.sdk.openadsdk.common.ML;
import com.bytedance.sdk.openadsdk.core.Bzk;
import com.bytedance.sdk.openadsdk.core.Bzk.KZx;
import com.bytedance.sdk.openadsdk.core.Sn;
import com.bytedance.sdk.openadsdk.core.WV;
import com.bytedance.sdk.openadsdk.core.aBv;
import com.bytedance.sdk.openadsdk.core.act.pA;
import com.bytedance.sdk.openadsdk.utils.IG;
import com.bytedance.sdk.openadsdk.utils.Vgu;
import com.bytedance.sdk.openadsdk.utils.WQf;
import com.json.fe;
import io.appmetrica.analytics.networktasks.internal.CommonUrlParts;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes8.dex */
public class PAGInitHelper {
    public static final List<PAGSdk.PAGInitCallback> CALLBACK_LIST = new ArrayList();
    public static float animationScale = 1.0f;

    public static void maybeAsyncInitTask(final Context context) {
        pA.pA(context);
        IG.pA();
        Vgu.pA(context);
        pA(context);
        aBv.ML();
        String strPA = WV.pA(context);
        KZx.Og(strPA);
        ZZv.pA(strPA, true);
        Og.pA();
        com.bytedance.sdk.openadsdk.core.Wx.KZx.pA.pA().Og();
        initAnimationScale(context);
        Sn.Og().postDelayed(new Runnable() { // from class: com.bytedance.sdk.openadsdk.api.init.PAGInitHelper.1
            @Override // java.lang.Runnable
            public void run() {
                com.bytedance.sdk.openadsdk.Sn.KZx.pA();
                com.bytedance.sdk.openadsdk.Sn.KZx.pA("android_act", false, new com.bytedance.sdk.openadsdk.Sn.Og() { // from class: com.bytedance.sdk.openadsdk.api.init.PAGInitHelper.1.1
                    @Override // com.bytedance.sdk.openadsdk.Sn.Og
                    public com.bytedance.sdk.openadsdk.Sn.pA.KZx getLogStats() throws Exception {
                        JSONObject jSONObject = new JSONObject();
                        try {
                            jSONObject.put("act", pA.Og(context));
                            jSONObject.put("api_available", pA.Og());
                            jSONObject.put("act_signals_callback_available", pA.KZx());
                            jSONObject.put("act_event", pA.pA());
                        } catch (Throwable th) {
                            com.bytedance.sdk.component.utils.WV.pA("AsyncInitTask", "run: ", th);
                        }
                        return com.bytedance.sdk.openadsdk.Sn.pA.ZZv.Og().pA("android_act").Og(jSONObject.toString());
                    }
                });
            }
        }, 10000L);
    }

    public static void initAnimationScale(Context context) {
        try {
            float f = Settings.System.getFloat(context.getContentResolver(), "animator_duration_scale", 1.0f);
            animationScale = f;
            if (f <= 0.0f) {
                animationScale = 1.0f;
            }
        } catch (Throwable unused) {
            animationScale = 1.0f;
        }
    }

    private static void pA(Context context) {
        com.bytedance.sdk.openadsdk.core.KZx.pA(context).pA(CommonUrlParts.UUID, WQf.pA());
    }

    public static void initMemoryData() {
        aBv.ZZv();
        com.bytedance.sdk.openadsdk.multipro.ZZv.ZZv.pA("ttopenadsdk", "a", 0);
        com.bytedance.sdk.openadsdk.multipro.ZZv.ZZv.pA("sp_global_file", "a", 0);
        com.bytedance.sdk.openadsdk.multipro.ZZv.ZZv.pA("sp_global_privacy", "a", 0);
        com.bytedance.sdk.openadsdk.multipro.ZZv.ZZv.pA("sp_global_app_id", "a", 0);
        com.bytedance.sdk.openadsdk.multipro.ZZv.ZZv.pA("sp_global_icon_id", "a", 0);
        com.bytedance.sdk.openadsdk.multipro.ZZv.ZZv.pA(com.bytedance.sdk.openadsdk.aBv.Og.pA, "a", 0);
        com.bytedance.sdk.openadsdk.multipro.ZZv.ZZv.pA("tpl_fetch_model", "a", 0);
        com.bytedance.sdk.openadsdk.multipro.ZZv.ZZv.pA("tt_sp", "a", 0);
        com.bytedance.sdk.openadsdk.multipro.ZZv.ZZv.pA("tt_sdk_event_net_ad", "a", 0);
        com.bytedance.sdk.openadsdk.multipro.ZZv.ZZv.pA("tt_sdk_event_net_state", "a", 0);
        com.bytedance.sdk.openadsdk.multipro.ZZv.ZZv.pA("tt_sdk_event_net_trail", "a", 0);
        com.bytedance.sdk.openadsdk.multipro.ZZv.ZZv.pA("tt_sdk_event_db_ad", "a", 0);
        com.bytedance.sdk.openadsdk.multipro.ZZv.ZZv.pA("tt_sdk_event_db_state", "a", 0);
        com.bytedance.sdk.openadsdk.multipro.ZZv.ZZv.pA("tt_sdk_event_db_trail", "a", 0);
        com.bytedance.sdk.openadsdk.multipro.ZZv.ZZv.pA("pag_sp_bad_par", "did");
        com.bytedance.sdk.openadsdk.multipro.ZZv.ZZv.pA("pag_sp_bad_par", fe.Q0);
    }

    public static void initAPM() {
        if (ML.pA()) {
            return;
        }
        try {
            String strZZv = Bzk.Og().ZZv();
            if (TextUtils.isEmpty(strZZv)) {
                return;
            }
            ApmHelper.initApm(aBv.pA(), new PAGConfig.Builder().appId(strZZv).build());
        } catch (Exception unused) {
        }
    }
}
