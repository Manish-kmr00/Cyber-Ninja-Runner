package com.bytedance.adsdk.pA;

import org.json.JSONObject;

/* JADX INFO: loaded from: classes6.dex */
public class pA implements com.bytedance.adsdk.ugeno.KZx.pA {
    @Override // com.bytedance.adsdk.ugeno.KZx.pA
    public com.bytedance.adsdk.ugeno.KZx.pA.InterfaceC0173pA pA(String str) {
        return C0169pA.pA(str);
    }

    /* JADX INFO: renamed from: com.bytedance.adsdk.pA.pA$pA, reason: collision with other inner class name */
    static class C0169pA implements com.bytedance.adsdk.ugeno.KZx.pA.InterfaceC0173pA {
        private String Og;
        private com.bytedance.adsdk.pA.Og.pA pA;

        private C0169pA(String str) {
            this.Og = str;
            this.pA = com.bytedance.adsdk.pA.Og.pA.pA(str);
        }

        public static C0169pA pA(String str) {
            return new C0169pA(str);
        }

        @Override // com.bytedance.adsdk.ugeno.KZx.pA.InterfaceC0173pA
        public Object pA(JSONObject jSONObject) {
            com.bytedance.adsdk.pA.Og.pA pAVar = this.pA;
            if (pAVar == null) {
                return this.Og;
            }
            Object objPA = pAVar.pA(jSONObject);
            if (objPA instanceof String) {
                return objPA;
            }
            if (objPA instanceof com.bytedance.adsdk.pA.Og.pA.pA) {
                return String.valueOf(SD.pA((com.bytedance.adsdk.pA.Og.pA.pA) objPA));
            }
            return String.valueOf(objPA);
        }
    }
}
