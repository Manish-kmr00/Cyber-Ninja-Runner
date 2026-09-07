package com.bytedance.sdk.openadsdk.core.WV;

import android.text.TextUtils;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.pubmatic.sdk.nativead.POBNativeConstants;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes10.dex */
public class SGo {
    private final String KZx;
    private final URL Og;
    private final String ZZv;
    private final String pA;

    private SGo(String str, String str2, String str3, String str4) throws MalformedURLException {
        this.pA = str2;
        this.Og = new URL(str);
        this.KZx = str3;
        this.ZZv = str4;
    }

    public String pA() {
        return this.pA;
    }

    public String Og() {
        return this.KZx;
    }

    public URL KZx() {
        return this.Og;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof SGo)) {
            return false;
        }
        SGo sGo = (SGo) obj;
        if (pA(this.pA, sGo.pA) && pA(this.Og, sGo.Og) && pA(this.KZx, sGo.KZx)) {
            return pA(this.ZZv, sGo.ZZv);
        }
        return false;
    }

    public int hashCode() {
        String str = this.pA;
        int iHashCode = (((str != null ? str.hashCode() : 0) * 31) + this.Og.hashCode()) * 31;
        String str2 = this.KZx;
        int iHashCode2 = (iHashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        String str3 = this.ZZv;
        return iHashCode2 + (str3 != null ? str3.hashCode() : 0);
    }

    private boolean pA(Object obj, Object obj2) {
        return Objects.equals(obj, obj2);
    }

    public JSONObject ZZv() {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("apiFramework", CampaignEx.KEY_OMID);
            jSONObject.put("javascriptResourceUrl", this.Og.toString());
            if (!TextUtils.isEmpty(this.pA)) {
                jSONObject.put(POBNativeConstants.NATIVE_VENDOR_KEY, this.pA);
            }
            if (!TextUtils.isEmpty(this.KZx)) {
                jSONObject.put("verificationParameters", this.KZx);
            }
            if (!TextUtils.isEmpty(this.ZZv)) {
                jSONObject.put("verificationNotExecuted", this.ZZv);
            }
            return jSONObject;
        } catch (Throwable unused) {
            return null;
        }
    }

    public static SGo pA(String str, String str2, String str3, String str4, String str5) {
        if (CampaignEx.KEY_OMID.equalsIgnoreCase(str) && !TextUtils.isEmpty(str2)) {
            try {
                return new SGo(str2, str3, str4, str5);
            } catch (Throwable unused) {
            }
        }
        return null;
    }

    public static SGo pA(JSONObject jSONObject) {
        try {
            String strOptString = jSONObject.optString("apiFramework");
            String strOptString2 = jSONObject.optString("javascriptResourceUrl");
            if (CampaignEx.KEY_OMID.equalsIgnoreCase(strOptString) && !TextUtils.isEmpty(strOptString2)) {
                return new SGo(strOptString2, jSONObject.optString(POBNativeConstants.NATIVE_VENDOR_KEY), jSONObject.optString("verificationParameters"), jSONObject.optString("verificationNotExecuted"));
            }
        } catch (Throwable unused) {
        }
        return null;
    }

    public static Set<SGo> pA(JSONArray jSONArray) {
        HashSet hashSet = new HashSet();
        if (jSONArray == null) {
            return hashSet;
        }
        for (int i = 0; i < jSONArray.length(); i++) {
            try {
                hashSet.add(pA(jSONArray.getJSONObject(i)));
            } catch (Throwable unused) {
            }
        }
        return hashSet;
    }
}
