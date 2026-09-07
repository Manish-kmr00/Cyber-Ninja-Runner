package com.fyber.inneractive.sdk.config.remote;

import android.text.TextUtils;
import com.fyber.inneractive.sdk.config.enums.UnitDisplayType;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public a f1718a;
    public List b = null;
    public String c;

    /* JADX WARN: Code duplicated, block: B:28:0x00b3  */
    /* JADX WARN: Code duplicated, block: B:49:0x016a  */
    public static e a(JSONObject jSONObject) {
        a aVar;
        Object obj;
        e eVar;
        String str;
        ArrayList arrayList;
        g gVar;
        String str2 = null;
        String strOptString = jSONObject.optString("updateHash", null);
        if (TextUtils.isEmpty(strOptString)) {
            return null;
        }
        e eVar2 = new e();
        eVar2.c = strOptString;
        JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject("app");
        int iOptInt = jSONObjectOptJSONObject == null ? -1 : jSONObjectOptJSONObject.optInt("id", -1);
        String str3 = "isActive";
        if (iOptInt == -1) {
            aVar = null;
        } else {
            aVar = new a();
            aVar.f1716a = String.valueOf(iOptInt);
            aVar.b = jSONObjectOptJSONObject.optString("publisherId", null);
            aVar.c = f.a(jSONObjectOptJSONObject.optJSONObject("monitor"));
            aVar.d = j.a(jSONObjectOptJSONObject.optJSONObject("video"));
            aVar.e = b.a(jSONObjectOptJSONObject.optJSONObject("display"));
            aVar.f = k.a(jSONObjectOptJSONObject.optJSONObject("viewability"));
            aVar.g = jSONObjectOptJSONObject.optString("isActive", null);
            JSONObject jSONObjectOptJSONObject2 = jSONObjectOptJSONObject.optJSONObject("native");
            if (jSONObjectOptJSONObject2 != null) {
                UnitDisplayType.fromValue(jSONObjectOptJSONObject2.optString("unitDisplayType"));
            }
        }
        if (aVar == null) {
            return null;
        }
        eVar2.f1718a = aVar;
        ArrayList arrayList2 = new ArrayList();
        JSONArray jSONArrayOptJSONArray = jSONObject.optJSONArray("spots");
        if (jSONArrayOptJSONArray != null) {
            int i = 0;
            while (i < jSONArrayOptJSONArray.length()) {
                JSONObject jSONObjectOptJSONObject3 = jSONArrayOptJSONArray.optJSONObject(i);
                if (jSONObjectOptJSONObject3 == null) {
                    jSONArrayOptJSONArray = jSONArrayOptJSONArray;
                    obj = str2;
                    eVar = eVar2;
                    str = str3;
                } else {
                    String strOptString2 = jSONObjectOptJSONObject3.optString("id", str2);
                    if (TextUtils.isEmpty(strOptString2)) {
                        jSONArrayOptJSONArray = jSONArrayOptJSONArray;
                        obj = str2;
                        eVar = eVar2;
                        str = str3;
                    } else {
                        h hVar = new h();
                        hVar.f1721a = strOptString2;
                        hVar.b = jSONObjectOptJSONObject3.optString(str3, str2);
                        hVar.c = b.a(jSONObjectOptJSONObject3.optJSONObject("display"));
                        hVar.d = f.a(jSONObjectOptJSONObject3.optJSONObject("monitor"));
                        JSONObject jSONObjectOptJSONObject4 = jSONObjectOptJSONObject3.optJSONObject("native");
                        if (jSONObjectOptJSONObject4 != null) {
                            UnitDisplayType.fromValue(jSONObjectOptJSONObject4.optString("unitDisplayType"));
                        }
                        hVar.e = j.a(jSONObjectOptJSONObject3.optJSONObject("video"));
                        hVar.f = k.a(jSONObjectOptJSONObject3.optJSONObject("viewability"));
                        JSONArray jSONArrayOptJSONArray2 = jSONObjectOptJSONObject3.optJSONArray("units");
                        if (jSONArrayOptJSONArray2 == null || jSONArrayOptJSONArray2.length() == 0) {
                            eVar = eVar2;
                            str = str3;
                            arrayList = new ArrayList();
                        } else {
                            arrayList = new ArrayList();
                            int i2 = 0;
                            while (i2 < jSONArrayOptJSONArray2.length()) {
                                JSONObject jSONObjectOptJSONObject5 = jSONArrayOptJSONArray2.optJSONObject(i2);
                                if (jSONObjectOptJSONObject5 != null) {
                                    i iVar = new i();
                                    iVar.f1722a = jSONObjectOptJSONObject5.optString("id", null);
                                    iVar.b = jSONObjectOptJSONObject5.optString("spotId", null);
                                    iVar.c = b.a(jSONObjectOptJSONObject5.optJSONObject("display"));
                                    iVar.d = f.a(jSONObjectOptJSONObject5.optJSONObject("monitor"));
                                    JSONObject jSONObjectOptJSONObject6 = jSONObjectOptJSONObject5.optJSONObject("native");
                                    if (jSONObjectOptJSONObject6 == null) {
                                        gVar = null;
                                    } else {
                                        gVar = new g();
                                        UnitDisplayType unitDisplayTypeFromValue = UnitDisplayType.fromValue(jSONObjectOptJSONObject6.optString("unitDisplayType"));
                                        if (unitDisplayTypeFromValue != null) {
                                            gVar.f1720a = unitDisplayTypeFromValue;
                                        } else {
                                            gVar = null;
                                        }
                                    }
                                    iVar.e = gVar;
                                    iVar.f = j.a(jSONObjectOptJSONObject5.optJSONObject("video"));
                                    iVar.g = k.a(jSONObjectOptJSONObject5.optJSONObject("viewability"));
                                    arrayList.add(iVar);
                                }
                                i2++;
                                eVar2 = eVar2;
                                str3 = str3;
                                jSONArrayOptJSONArray2 = jSONArrayOptJSONArray2;
                            }
                            eVar = eVar2;
                            str = str3;
                        }
                        hVar.g = arrayList;
                        obj = hVar;
                    }
                }
                if (obj != null) {
                    arrayList2.add(obj);
                }
                i++;
                eVar2 = eVar;
                jSONArrayOptJSONArray = jSONArrayOptJSONArray;
                str3 = str;
                str2 = null;
            }
        }
        e eVar3 = eVar2;
        eVar3.b = arrayList2;
        return eVar3;
    }
}
