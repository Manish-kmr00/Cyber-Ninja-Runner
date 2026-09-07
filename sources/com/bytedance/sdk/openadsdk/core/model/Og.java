package com.bytedance.sdk.openadsdk.core.model;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.bytedance.sdk.openadsdk.AdSlot;
import java.util.ArrayList;
import java.util.Collection;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes7.dex */
public class Og {
    public int KZx = 1;
    public AdSlot ML;
    public int Og;
    public ArrayList<Integer> ZZv;
    public String pA;

    public String pA() {
        return this.pA;
    }

    public void pA(String str) {
        this.pA = str;
    }

    public int Og() {
        return this.Og;
    }

    public void pA(int i) {
        this.Og = i;
    }

    public int KZx() {
        return this.KZx;
    }

    public void Og(int i) {
        this.KZx = i;
    }

    public AdSlot ZZv() {
        return this.ML;
    }

    public void pA(AdSlot adSlot) {
        this.ML = adSlot;
    }

    public ArrayList<Integer> ML() {
        return this.ZZv;
    }

    public void pA(ArrayList<Integer> arrayList) {
        this.ZZv = arrayList;
    }

    public static void pA(Og og) {
        int iOg;
        if (og == null || og.ZZv() == null || (iOg = og.Og()) >= 0 || iOg == -8) {
            return;
        }
        com.bytedance.sdk.openadsdk.Sn.KZx.pA();
        com.bytedance.sdk.openadsdk.Sn.KZx.pA("rd_client_custom_error", false, new com.bytedance.sdk.openadsdk.Sn.Og() { // from class: com.bytedance.sdk.openadsdk.core.model.Og.1
            @Override // com.bytedance.sdk.openadsdk.Sn.Og
            public com.bytedance.sdk.openadsdk.Sn.pA.KZx getLogStats() throws Exception {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put(TypedValues.TransitionType.S_FROM, Og.this.KZx());
                jSONObject.put("err_code", Og.this.Og());
                jSONObject.put("server_res_str", Og.this.pA());
                if (Og.this.ML() != null && Og.this.ML().size() > 0) {
                    jSONObject.put("mate_unavailable_code_list", new JSONArray((Collection) Og.this.ML()).toString());
                }
                new Object[]{"rd_client_custom_error = ", jSONObject};
                return com.bytedance.sdk.openadsdk.Sn.pA.ZZv.Og().pA("rd_client_custom_error").pA(Og.this.ZZv().getDurationSlotType()).Og(jSONObject.toString());
            }
        });
    }
}
