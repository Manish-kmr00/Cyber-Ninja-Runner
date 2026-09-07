package com.bytedance.sdk.openadsdk.pA;

import android.text.TextUtils;
import com.bytedance.sdk.component.omh.omh;
import com.bytedance.sdk.openadsdk.AdSlot;
import com.bytedance.sdk.openadsdk.BuildConfig;
import com.bytedance.sdk.openadsdk.api.PAGErrorCode;
import com.bytedance.sdk.openadsdk.api.PAGLoadListener;
import com.bytedance.sdk.openadsdk.api.PAGRequest;
import com.bytedance.sdk.openadsdk.core.Sn;
import com.bytedance.sdk.openadsdk.core.settings.WV;
import com.bytedance.sdk.openadsdk.oX.KZx;
import com.bytedance.sdk.openadsdk.oX.ZZv;
import com.bytedance.sdk.openadsdk.utils.gbA;
import com.bytedance.sdk.openadsdk.utils.xy;
import com.safedk.android.analytics.brandsafety.creatives.infos.CreativeInfo;
import java.util.Map;

/* JADX INFO: loaded from: classes10.dex */
public class pA {
    public static boolean pA(PAGLoadListener pAGLoadListener) {
        if (WV.pA()) {
            return false;
        }
        if (pAGLoadListener == null) {
            return true;
        }
        pAGLoadListener.onError(1000, "Ad request is temporarily paused, Please contact your Pangle AM");
        return true;
    }

    public static void pA(final omh omhVar, final PAGLoadListener pAGLoadListener, final AdSlot adSlot) {
        Runnable runnable = new Runnable() { // from class: com.bytedance.sdk.openadsdk.pA.pA.1
            @Override // java.lang.Runnable
            public void run() {
                if (!Sn.ML()) {
                    com.bytedance.sdk.component.utils.WV.pA("AdLoadBaseManager", "please exec TTAdSdk.init before load ad");
                    PAGLoadListener pAGLoadListener2 = pAGLoadListener;
                    if (pAGLoadListener2 != null) {
                        pAGLoadListener2.onError(10000, "Please exec TTAdSdk.init before load ad");
                        return;
                    }
                    return;
                }
                KZx.pA(new ZZv() { // from class: com.bytedance.sdk.openadsdk.pA.pA.1.1
                    @Override // com.bytedance.sdk.openadsdk.oX.ZZv
                    public com.bytedance.sdk.openadsdk.oX.Og.pA generatorModel() {
                        com.bytedance.sdk.openadsdk.oX.Og.pA pAVar = new com.bytedance.sdk.openadsdk.oX.Og.pA();
                        pAVar.Og("load_ad");
                        pAVar.KZx(adSlot.getCodeId());
                        pAVar.ZZv(gbA.KZx(adSlot.getDurationSlotType()));
                        pAVar.pA(BuildConfig.VERSION_NAME);
                        pAVar.SD(gbA.pA(adSlot).toString());
                        return pAVar;
                    }
                });
                xy.ZZv(omhVar);
            }
        };
        if (Sn.ML()) {
            runnable.run();
        } else {
            Sn.Og().post(runnable);
        }
    }

    public static void pA(AdSlot.Builder builder, PAGRequest pAGRequest) {
        Map<String, Object> extraInfo;
        if (!Sn.ML() || pAGRequest == null || builder == null || (extraInfo = pAGRequest.getExtraInfo()) == null) {
            return;
        }
        if (extraInfo.containsKey(CreativeInfo.c) && extraInfo.get(CreativeInfo.c) != null) {
            builder.setAdId(extraInfo.get(CreativeInfo.c).toString());
        }
        if (extraInfo.containsKey("creative_id") && extraInfo.get("creative_id") != null) {
            builder.setCreativeId(extraInfo.get("creative_id").toString());
        }
        if (extraInfo.containsKey("ext") && extraInfo.get("ext") != null) {
            builder.setExt(extraInfo.get("ext").toString());
        }
        if (!extraInfo.containsKey("media_extra") || extraInfo.get("media_extra") == null) {
            return;
        }
        builder.setMediaExtra(extraInfo.get("media_extra").toString());
    }

    public static boolean pA(String str, PAGRequest pAGRequest, PAGLoadListener pAGLoadListener) {
        if (TextUtils.isEmpty(str) && pAGLoadListener != null) {
            pAGLoadListener.onError(1, PAGErrorCode.PAGAdErrorCodeSlotIdNULLMsg);
            return true;
        }
        if (pAGRequest != null || pAGLoadListener == null) {
            return false;
        }
        pAGLoadListener.onError(2, PAGErrorCode.PAGAdErrorCodeRequestNULLMsg);
        return true;
    }
}
