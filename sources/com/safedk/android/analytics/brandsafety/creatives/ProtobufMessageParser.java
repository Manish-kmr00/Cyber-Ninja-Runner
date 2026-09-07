package com.safedk.android.analytics.brandsafety.creatives;

import com.safedk.android.utils.Logger;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes10.dex */
public class ProtobufMessageParser {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final String f8057a = "ProtobufMessageParser";
    private static final String b = "array";
    private static final String c = "string";
    private static final String d = "undefined_key";
    private byte[] f = null;
    private int e = 0;

    public static class ProtobufParserException extends Exception {
    }

    private ProtobufMessageParser() {
    }

    public static JSONObject a(byte[] bArr, String str) {
        return new ProtobufMessageParser().b(bArr, str);
    }

    private JSONObject b(byte[] bArr, String str) {
        if (bArr == null || bArr.length == 0 || str == null || str.isEmpty()) {
            Logger.d(f8057a, "parse protobuf message - invalid input");
            return new JSONObject();
        }
        this.e = 0;
        this.f = bArr;
        JSONObject jSONObject = new JSONObject();
        try {
            a(new JSONObject(str), jSONObject, bArr.length);
            return jSONObject;
        } catch (ProtobufParserException | JSONException e) {
            Logger.d(f8057a, "parse protobuf message - invalid json template: " + str);
            return jSONObject;
        }
    }

    private void a(JSONObject jSONObject, JSONObject jSONObject2, int i) throws ProtobufParserException {
        while (this.e != i) {
            int iC = c();
            String strValueOf = String.valueOf(b(iC));
            int iC2 = c(iC);
            Object objOpt = jSONObject.opt(strValueOf);
            switch (iC2) {
                case 0:
                    b(jSONObject2, objOpt);
                    break;
                case 1:
                    b();
                    break;
                case 2:
                    a(jSONObject2, objOpt);
                    break;
                case 5:
                    a();
                    break;
            }
        }
    }

    private String a(JSONArray jSONArray) {
        String strOptString = jSONArray.optString(0);
        if (strOptString == null || strOptString.isEmpty()) {
            return d;
        }
        return strOptString;
    }

    private String b(JSONArray jSONArray) {
        return jSONArray.optString(1, "");
    }

    private Object c(JSONArray jSONArray) {
        return jSONArray.opt(2);
    }

    private String a(int i) {
        return this.e + i <= this.f.length ? new String(this.f, this.e, i) : "";
    }

    private JSONArray a(JSONObject jSONObject, String str) {
        JSONArray jSONArrayOptJSONArray = jSONObject.optJSONArray(str);
        if (jSONArrayOptJSONArray == null) {
            jSONArrayOptJSONArray = new JSONArray();
        }
        a(jSONObject, str, jSONArrayOptJSONArray);
        return jSONArrayOptJSONArray;
    }

    private void a(JSONObject jSONObject, String str, Object obj) {
        if (jSONObject != null) {
            try {
                jSONObject.put(str, obj);
            } catch (JSONException e) {
            }
        }
    }

    private void a(JSONObject jSONObject, Object obj) throws ProtobufParserException {
        String strA;
        JSONArray jSONArray;
        JSONObject jSONObject2;
        Object obj2;
        int iC = c();
        if (obj instanceof JSONArray) {
            JSONArray jSONArray2 = (JSONArray) obj;
            strA = a(jSONArray2);
            String strB = b(jSONArray2);
            if (strB.equals("array")) {
                JSONArray jSONArrayA = a(jSONObject, strA);
                Object objC = c(jSONArray2);
                jSONObject2 = new JSONObject();
                jSONArray = jSONArrayA;
                obj2 = objC;
            } else if (strB.equals("string")) {
                jSONArray = null;
                jSONObject2 = jSONObject;
                obj2 = "";
            } else {
                jSONArray = null;
                jSONObject2 = jSONObject;
                obj2 = obj;
            }
        } else {
            strA = null;
            jSONArray = null;
            jSONObject2 = jSONObject;
            obj2 = obj;
        }
        if (obj2 instanceof JSONObject) {
            if (jSONArray != null) {
                jSONArray.put(jSONObject2);
            }
            a((JSONObject) obj2, jSONObject2, this.e + iC);
            return;
        }
        if (obj2 instanceof String) {
            String strA2 = a(iC);
            if (jSONArray != null) {
                jSONArray.put(strA2);
            } else if (strA != null) {
                a(jSONObject, strA, strA2);
            }
        }
        this.e += iC;
    }

    private void b(JSONObject jSONObject, Object obj) throws ProtobufParserException {
        int iC = c();
        if (obj instanceof JSONArray) {
            a(jSONObject, a((JSONArray) obj), Integer.valueOf(iC));
        }
    }

    private void a() {
        this.e += 4;
    }

    private void b() {
        this.e += 8;
    }

    private int c() throws ProtobufParserException {
        byte bD;
        ArrayList arrayList = new ArrayList();
        do {
            bD = d();
            arrayList.add(Byte.valueOf(bD));
        } while (!a(bD));
        Collections.reverse(arrayList);
        int iByteValue = 0;
        Iterator it = arrayList.iterator();
        while (true) {
            int i = iByteValue;
            if (it.hasNext()) {
                iByteValue = ((byte) (((Byte) it.next()).byteValue() & 127)) | (i << 7);
            } else {
                return i;
            }
        }
    }

    private byte d() throws ProtobufParserException {
        if (this.e < 0 || this.e >= this.f.length) {
            throw new ProtobufParserException();
        }
        byte[] bArr = this.f;
        int i = this.e;
        this.e = i + 1;
        return bArr[i];
    }

    private boolean a(byte b2) {
        return (b2 & 128) == 0;
    }

    private int b(int i) {
        return i >> 3;
    }

    private int c(int i) {
        return i & 7;
    }
}
