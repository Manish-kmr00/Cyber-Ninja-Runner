package com.inmobi.media;

import com.inmobi.unifiedId.InMobiUserDataModel;
import com.inmobi.unifiedId.InMobiUserDataTypes;
import com.unity3d.ads.metadata.InAppPurchaseMetaData;
import java.util.HashMap;
import java.util.Objects;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: renamed from: com.inmobi.media.yc, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes10.dex */
public final class C3644yc extends Wa {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C3644yc(String url, C3545rc c3545rc, String str, int i, int i2, int i3) {
        super(url, c3545rc, str, i, i2);
        Intrinsics.checkNotNullParameter("POST", "requestType");
        Intrinsics.checkNotNullParameter(url, "url");
        this.p = i3;
    }

    @Override // com.inmobi.media.S8
    public final void f() {
        InMobiUserDataTypes emailId;
        InMobiUserDataTypes phoneNumber;
        HashMap map;
        HashMap map2;
        HashMap map3;
        HashMap map4;
        String string;
        HashMap map5;
        super.f();
        InMobiUserDataModel inMobiUserDataModel = C3324c4.f3281a;
        String.valueOf(C3324c4.f3281a);
        HashMap mapA = I9.a();
        HashMap map6 = this.k;
        if (map6 != null) {
            map6.put("mk-version", C3531qb.a());
            String str = O0.f3153a;
            if (str != null) {
            }
            map6.put("ua", C3517pb.k());
            map6.put("ts", String.valueOf(System.currentTimeMillis()));
        }
        String str2 = this.m;
        if (str2 != null && (map5 = this.k) != null) {
        }
        Boolean boolC = C3532qc.f3412a.c();
        HashMap map7 = this.k;
        if (map7 != null) {
            if (boolC == null || (string = boolC.toString()) == null) {
                string = "true";
            }
        }
        String str3 = (String) mapA.get("u-age");
        if (str3 != null && (map4 = this.k) != null) {
        }
        InMobiUserDataModel inMobiUserDataModel2 = C3324c4.f3281a;
        if (inMobiUserDataModel2 == null || (emailId = inMobiUserDataModel2.getEmailId()) == null || (emailId.getMd5() == null && emailId.getSha1() == null && emailId.getSha256() == null)) {
            emailId = null;
        }
        if (emailId != null && (map3 = this.k) != null) {
        }
        InMobiUserDataModel inMobiUserDataModel3 = C3324c4.f3281a;
        if (inMobiUserDataModel3 == null || (phoneNumber = inMobiUserDataModel3.getPhoneNumber()) == null || (phoneNumber.getMd5() == null && phoneNumber.getSha1() == null && phoneNumber.getSha256() == null)) {
            phoneNumber = null;
        }
        if (phoneNumber != null && (map2 = this.k) != null) {
        }
        JSONArray jSONArray = new JSONArray();
        JSONObject jSONObjectB = AbstractC3296a5.b();
        if (jSONObjectB != null) {
            try {
                if (jSONObjectB.has("ufids")) {
                    JSONArray jSONArray2 = jSONObjectB.getJSONArray("ufids");
                    int length = jSONArray2.length();
                    for (int i = 0; i < length; i++) {
                        String string2 = jSONArray2.getJSONObject(i).has("src") ? jSONArray2.getJSONObject(i).getString("src") : null;
                        String string3 = jSONArray2.getJSONObject(i).has(InAppPurchaseMetaData.KEY_SIGNATURE) ? jSONArray2.getJSONObject(i).getString(InAppPurchaseMetaData.KEY_SIGNATURE) : null;
                        boolean z = System.currentTimeMillis() > jSONArray2.getJSONObject(i).getLong("expiry");
                        if (string2 != null && string3 != null) {
                            JSONObject jSONObject = new JSONObject();
                            jSONObject.put("src", string2);
                            jSONObject.put(InAppPurchaseMetaData.KEY_SIGNATURE, string3);
                            jSONObject.put("expired", z);
                            jSONArray.put(jSONObject);
                        }
                    }
                }
            } catch (JSONException unused) {
                Objects.toString(jSONObjectB);
            }
        }
        HashMap map8 = this.k;
        if (map8 != null) {
            String string4 = jSONArray.toString();
            Intrinsics.checkNotNullExpressionValue(string4, "toString(...)");
        }
        InMobiUserDataModel inMobiUserDataModel4 = C3324c4.f3281a;
        HashMap<String, String> extras = inMobiUserDataModel4 != null ? inMobiUserDataModel4.getExtras() : null;
        if (extras == null || (map = this.k) == null) {
            return;
        }
        map.putAll(extras);
    }
}
