package io.bidmachine.analytics.internal;

import android.content.Context;
import android.os.Bundle;
import android.util.Base64;
import java.io.Closeable;
import java.io.Flushable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.IntIterator;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntRange;
import kotlin.ranges.RangesKt;
import kotlin.sequences.SequencesKt;
import kotlin.text.Charsets;
import kotlin.text.StringsKt;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes14.dex */
public abstract class s0 {
    public static final Object a(Closeable closeable) {
        try {
            Result.Companion companion = Result.INSTANCE;
            closeable.close();
            return Result.m7904constructorimpl(Unit.INSTANCE);
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            return Result.m7904constructorimpl(ResultKt.createFailure(th));
        }
    }

    public static final String b(String str) {
        return a(d(str));
    }

    public static final String c(String str) {
        return Base64.encodeToString(str.getBytes(Charsets.UTF_8), 2);
    }

    public static final String d(String str) {
        if (str.length() == 0) {
            return str;
        }
        int iIndexOf$default = StringsKt.indexOf$default((CharSequence) str, "=", 0, false, 6, (Object) null);
        return iIndexOf$default == -1 ? StringsKt.reversed((CharSequence) str).toString() : StringsKt.reversed((CharSequence) str.substring(0, iIndexOf$default)).toString() + str.substring(iIndexOf$default);
    }

    public static final String a(String str) {
        return new String(Base64.decode(str, 2), Charsets.UTF_8);
    }

    public static final byte[] b(byte[] bArr, String str) {
        return a(bArr, str.getBytes(Charsets.UTF_8));
    }

    public static final Object a(Flushable flushable) {
        try {
            Result.Companion companion = Result.INSTANCE;
            flushable.flush();
            return Result.m7904constructorimpl(Unit.INSTANCE);
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            return Result.m7904constructorimpl(ResultKt.createFailure(th));
        }
    }

    public static final boolean a(Context context) {
        return (context.getApplicationInfo().flags & 2) != 0;
    }

    public static final JSONArray a(List list) {
        JSONArray jSONArray = new JSONArray();
        for (Object objA : list) {
            if (objA instanceof List) {
                objA = a((List) objA);
            } else if (objA instanceof Map) {
                objA = a((Map) objA);
            }
            jSONArray.put(objA);
        }
        return jSONArray;
    }

    public static final JSONObject a(Map map) {
        JSONObject jSONObject = new JSONObject();
        for (Map.Entry entry : map.entrySet()) {
            Object key = entry.getKey();
            Object value = entry.getValue();
            try {
                Result.Companion companion = Result.INSTANCE;
                String strValueOf = String.valueOf(key);
                if (strValueOf.length() != 0 && value != null) {
                    if (value instanceof List) {
                        value = a((List) value);
                    } else if (value instanceof Map) {
                        value = a((Map) value);
                    }
                    jSONObject.put(strValueOf, value);
                }
                Result.m7904constructorimpl(Unit.INSTANCE);
            } catch (Throwable th) {
                Result.Companion companion2 = Result.INSTANCE;
                Result.m7904constructorimpl(ResultKt.createFailure(th));
            }
        }
        return jSONObject;
    }

    private static final Object a(Object obj) {
        if (Intrinsics.areEqual(obj, JSONObject.NULL)) {
            return null;
        }
        if (obj instanceof JSONObject) {
            return a((JSONObject) obj);
        }
        return obj instanceof JSONArray ? a((JSONArray) obj) : obj;
    }

    public static final List a(JSONArray jSONArray) {
        IntRange intRangeUntil = RangesKt.until(0, jSONArray.length());
        ArrayList arrayList = new ArrayList();
        Iterator<Integer> it = intRangeUntil.iterator();
        while (it.hasNext()) {
            Object objA = a(jSONArray.get(((IntIterator) it).nextInt()));
            if (objA != null) {
                arrayList.add(objA);
            }
        }
        return arrayList;
    }

    public static final Map a(Bundle bundle) {
        short sShortValue;
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (String str : bundle.keySet()) {
            Object objA = bundle.get(str);
            if (!(objA instanceof Boolean)) {
                if (objA instanceof Byte) {
                    sShortValue = ((Number) objA).byteValue();
                } else if (!(objA instanceof Character) && !(objA instanceof Double) && !(objA instanceof Float) && !(objA instanceof Integer) && !(objA instanceof Long)) {
                    if (objA instanceof Short) {
                        sShortValue = ((Number) objA).shortValue();
                    } else if (!(objA instanceof String)) {
                        objA = objA instanceof Bundle ? a((Bundle) objA) : (!(objA instanceof CharSequence) && objA == null) ? null : objA.toString();
                    }
                }
                objA = Integer.valueOf(sShortValue);
            }
            if (objA != null) {
                linkedHashMap.put(str, objA);
            }
        }
        return linkedHashMap;
    }

    public static final Map a(JSONObject jSONObject) {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (String str : SequencesKt.asSequence(jSONObject.keys())) {
            Object objA = a(jSONObject.get(str));
            if (objA != null) {
                linkedHashMap.put(str, objA);
            }
        }
        return linkedHashMap;
    }

    public static final String a(Throwable th) {
        String string;
        String message = th.getMessage();
        return (message == null || (string = new StringBuilder().append(th.getClass().getName()).append(": ").append(message).toString()) == null) ? th.getClass().getName() : string;
    }

    public static final byte[] a(byte[] bArr, String str) {
        return a(bArr, str.getBytes(Charsets.UTF_8));
    }

    private static final byte[] a(byte[] bArr, byte[] bArr2) {
        byte[] bArr3 = new byte[bArr.length];
        int length = bArr.length;
        for (int i = 0; i < length; i++) {
            bArr3[i] = (byte) (bArr[i] ^ bArr2[i % bArr2.length]);
        }
        return bArr3;
    }
}
