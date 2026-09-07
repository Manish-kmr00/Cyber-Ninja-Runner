package com.bytedance.sdk.openadsdk.core.Bzk;

import android.text.TextUtils;
import android.view.MotionEvent;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes11.dex */
class Og {
    private static com.bytedance.sdk.openadsdk.core.Bzk.pA pA;
    private String Og;

    private Og() {
        this.Og = null;
        pA = new com.bytedance.sdk.openadsdk.core.Bzk.pA();
    }

    public void pA(String str) {
        com.bytedance.sdk.openadsdk.core.Bzk.pA pAVar;
        if (TextUtils.isEmpty(str) || (pAVar = pA) == null) {
            return;
        }
        pAVar.pA(str);
    }

    public void Og(String str) {
        com.bytedance.sdk.openadsdk.core.Bzk.pA pAVar;
        if (TextUtils.isEmpty(str) || (pAVar = pA) == null) {
            return;
        }
        pAVar.Og(str);
    }

    public void pA() {
        com.bytedance.sdk.openadsdk.core.Bzk.pA pAVar = pA;
        if (pAVar != null) {
            pAVar.KZx();
        }
    }

    public static Og Og() {
        return pA.pA;
    }

    public void pA(String str, Map<String, Object> map) {
        com.bytedance.sdk.openadsdk.core.Bzk.pA pAVar = pA;
        if (pAVar != null) {
            pAVar.pA(str, map);
        }
    }

    public boolean KZx() {
        com.bytedance.sdk.openadsdk.core.Bzk.pA pAVar = pA;
        if (pAVar == null) {
            return false;
        }
        return pAVar.Og();
    }

    public String ZZv() {
        String strZZv;
        com.bytedance.sdk.openadsdk.core.Bzk.pA pAVar = pA;
        return (pAVar == null || (strZZv = pAVar.ZZv()) == null) ? "" : strZZv;
    }

    public Map<String, String> pA(String str, byte[] bArr) {
        com.bytedance.sdk.openadsdk.core.Bzk.pA pAVar = pA;
        if (pAVar != null) {
            return pAVar.pA(str, bArr);
        }
        return new HashMap();
    }

    public String ML() {
        com.bytedance.sdk.openadsdk.core.Bzk.pA pAVar = pA;
        if (pAVar != null) {
            return pAVar.ML();
        }
        return "";
    }

    public long JG() {
        com.bytedance.sdk.openadsdk.core.Bzk.pA pAVar = pA;
        if (pAVar != null) {
            return pAVar.JG();
        }
        return 0L;
    }

    public int SD() {
        com.bytedance.sdk.openadsdk.core.Bzk.pA pAVar = pA;
        if (pAVar != null) {
            return pAVar.SD();
        }
        return 1;
    }

    public void pA(MotionEvent motionEvent) {
        com.bytedance.sdk.openadsdk.core.Bzk.pA pAVar = pA;
        if (pAVar != null) {
            pAVar.pA(motionEvent);
        }
    }

    private static class pA {
        private static final Og pA = new Og();
    }
}
