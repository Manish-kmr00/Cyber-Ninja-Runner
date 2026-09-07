package com.mbridge.msdk.foundation.tools;

import android.content.Context;
import com.mbridge.msdk.MBridgeConstans;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: DomainDeviceInfo.java */
/* JADX INFO: loaded from: classes13.dex */
public class s extends d {
    public int w;
    public int x;

    public s(Context context) {
        super(context);
        this.x = k0.v();
        this.w = k0.h();
    }

    @Override // com.mbridge.msdk.foundation.tools.d
    public JSONObject a() {
        JSONObject jSONObjectA = super.a();
        try {
            if (com.mbridge.msdk.foundation.controller.authoritycontroller.c.m().c(MBridgeConstans.AUTHORITY_GENERAL_DATA)) {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("dmt", this.x + "");
                jSONObject.put("dmf", this.w);
            }
        } catch (JSONException e) {
            if (MBridgeConstans.DEBUG) {
                o0.b("DomainDeviceInfo", e.getMessage());
            }
        }
        return jSONObjectA;
    }
}
