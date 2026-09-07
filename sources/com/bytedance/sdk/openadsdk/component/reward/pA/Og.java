package com.bytedance.sdk.openadsdk.component.reward.pA;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.SparseArray;
import com.bytedance.sdk.openadsdk.TTAdConstant;
import com.bytedance.sdk.openadsdk.core.TV;
import com.bytedance.sdk.openadsdk.core.model.vZF;
import com.safedk.android.internal.partials.PangleNetworkBridge;
import java.lang.ref.WeakReference;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes12.dex */
public class Og {
    private static final SparseArray<WeakReference<com.bytedance.sdk.openadsdk.core.model.yFO>> pA = new SparseArray<>();

    public static void pA(pA pAVar, Intent intent, Bundle bundle) {
        pA(intent, pAVar);
        pA(bundle, pAVar);
    }

    public static com.bytedance.sdk.openadsdk.core.model.yFO pA(Intent intent, Bundle bundle, com.bytedance.sdk.openadsdk.core.Wx.ZZv.Og og) {
        com.bytedance.sdk.openadsdk.core.model.yFO vzf = null;
        if (!com.bytedance.sdk.openadsdk.multipro.Og.KZx()) {
            com.bytedance.sdk.openadsdk.core.model.pA pAVarSD = TV.pA().SD();
            vzf = pAVarSD != null ? new vZF(pAVarSD) : null;
            if (og != null) {
                og.pA(bundle);
            }
            TV.pA().JG();
        } else if (intent != null) {
            try {
                String stringExtra = intent.getStringExtra(TTAdConstant.MULTI_PROCESS_AD_INFO);
                if (stringExtra != null) {
                    vzf = new vZF(com.bytedance.sdk.openadsdk.core.model.pA.KZx(PangleNetworkBridge.jsonObjectInit(stringExtra)));
                }
            } catch (Exception e) {
                com.bytedance.sdk.component.utils.WV.pA("TTAD.RFDM", "", e);
            }
        }
        if (bundle != null) {
            try {
                WeakReference<com.bytedance.sdk.openadsdk.core.model.yFO> weakReference = pA.get(bundle.getInt("meta_tmp"));
                if (weakReference != null) {
                    vzf = weakReference.get();
                }
            } catch (Throwable th) {
                com.bytedance.sdk.component.utils.WV.pA("TTAD.RFDM", "", th);
            }
        }
        if (vzf != null) {
            vzf.pA(vzf.XT(), 7);
        }
        return vzf;
    }

    public static void pA(Intent intent, pA pAVar) {
        if (intent == null) {
            return;
        }
        pAVar.BF.KZx(intent.getBooleanExtra("video_is_cached", false));
        pAVar.JBA = intent.getStringExtra("multi_process_listener_key");
        pAVar.PV = intent.getIntExtra("orientation_angle", 0) == 3;
    }

    public static void pA(Bundle bundle, pA pAVar) {
        if (bundle == null) {
            return;
        }
        pAVar.JBA = bundle.getString("multi_process_listener_key");
        pAVar.BF.KZx(bundle.getBoolean("video_is_cached", false));
        pAVar.agB = bundle.getBoolean("is_mute");
        if (bundle.getLong("video_current") > 0) {
            pAVar.BF.pA(bundle.getLong("video_current", 0L));
        }
        pAVar.pA(bundle.getBoolean("has_show_skip_btn"));
    }

    public static void pA(pA pAVar, Bundle bundle) {
        if (bundle == null) {
            return;
        }
        try {
            com.bytedance.sdk.openadsdk.core.model.yFO yfo = pAVar.Og;
            pA.append(yfo.hashCode(), new WeakReference<>(yfo));
            bundle.putInt("meta_tmp", yfo.hashCode());
            bundle.putString("multi_process_listener_key", pAVar.JBA);
            bundle.putBoolean("video_is_cached", pAVar.BF.WQf());
            bundle.putLong("video_current", pAVar.BF.SD());
            bundle.putBoolean("is_mute", pAVar.agB);
            bundle.putBoolean("has_show_skip_btn", pAVar.cFQ);
        } catch (Throwable th) {
            com.bytedance.sdk.component.utils.WV.pA("TTAD.RFDM", "onSaveInstanceState: ", th);
        }
    }

    /* JADX WARN: Code duplicated, block: B:11:0x002e  */
    /* JADX WARN: Code duplicated, block: B:13:0x0034  */
    /* JADX WARN: Code duplicated, block: B:15:0x003a  */
    /* JADX WARN: Code duplicated, block: B:17:0x0049  */
    public static void pA(Intent intent, Activity activity, boolean z, com.bytedance.sdk.openadsdk.core.model.pA pAVar, String str) {
        int rotation;
        JSONObject jSONObjectWx;
        if (activity == null) {
            intent.addFlags(268435456);
        } else {
            try {
                rotation = activity.getWindowManager().getDefaultDisplay().getRotation();
            } catch (Exception e) {
                com.bytedance.sdk.component.utils.WV.pA("TTAD.RFDM", "", e);
                rotation = 0;
            }
            intent.putExtra("orientation_angle", rotation);
            intent.putExtra("video_is_cached", z);
            if (com.bytedance.sdk.openadsdk.multipro.Og.KZx()) {
                jSONObjectWx = pAVar.Wx();
                if (jSONObjectWx == null) {
                    com.bytedance.sdk.component.utils.WV.Og("toJsonObj return null");
                    return;
                } else {
                    intent.putExtra(TTAdConstant.MULTI_PROCESS_AD_INFO, jSONObjectWx.toString());
                    intent.putExtra("multi_process_listener_key", str);
                    return;
                }
            }
            TV.pA().JG();
            TV.pA().pA(pAVar);
        }
        rotation = 0;
        intent.putExtra("orientation_angle", rotation);
        intent.putExtra("video_is_cached", z);
        if (com.bytedance.sdk.openadsdk.multipro.Og.KZx()) {
            jSONObjectWx = pAVar.Wx();
            if (jSONObjectWx == null) {
                com.bytedance.sdk.component.utils.WV.Og("toJsonObj return null");
                return;
            } else {
                intent.putExtra(TTAdConstant.MULTI_PROCESS_AD_INFO, jSONObjectWx.toString());
                intent.putExtra("multi_process_listener_key", str);
                return;
            }
        }
        TV.pA().JG();
        TV.pA().pA(pAVar);
    }
}
