package com.inmobi.media;

import java.lang.reflect.Field;
import java.util.Iterator;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: renamed from: com.inmobi.media.z5, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes10.dex */
public final class C3651z5 {
    /* JADX WARN: Code duplicated, block: B:62:0x0192 A[RETURN, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:63:0x0194 A[RETURN, SYNTHETIC] */
    public static boolean a(Object obj, Object obj2) {
        if (!Intrinsics.areEqual(obj.getClass(), obj2.getClass())) {
            if (Intrinsics.areEqual(obj.getClass(), Integer.class) && Intrinsics.areEqual(obj2.getClass(), Long.class)) {
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.Int");
                int iIntValue = ((Integer) obj).intValue();
                Intrinsics.checkNotNull(obj2, "null cannot be cast to non-null type kotlin.Long");
                if (iIntValue == ((int) ((Long) obj2).longValue())) {
                    return true;
                }
                return false;
            }
            if (Intrinsics.areEqual(obj.getClass(), Long.class) && Intrinsics.areEqual(obj2.getClass(), Integer.class)) {
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.Long");
                int iLongValue = (int) ((Long) obj).longValue();
                Intrinsics.checkNotNull(obj2, "null cannot be cast to non-null type kotlin.Int");
                if (iLongValue == ((Integer) obj2).intValue()) {
                    return true;
                }
                return false;
            }
            if (Intrinsics.areEqual(obj.getClass(), Integer.class) && Intrinsics.areEqual(obj2.getClass(), Byte.class)) {
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.Int");
                int iIntValue2 = ((Integer) obj).intValue();
                Intrinsics.checkNotNull(obj2, "null cannot be cast to non-null type kotlin.Byte");
                if (iIntValue2 == ((Byte) obj2).byteValue()) {
                    return true;
                }
                return false;
            }
            if (!Intrinsics.areEqual(obj.getClass(), Byte.class) || !Intrinsics.areEqual(obj2.getClass(), Integer.class)) {
                return Intrinsics.areEqual(obj, obj2);
            }
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.Byte");
            byte bByteValue = ((Byte) obj).byteValue();
            Intrinsics.checkNotNull(obj2, "null cannot be cast to non-null type kotlin.Int");
            if (bByteValue == ((Integer) obj2).intValue()) {
                return true;
            }
            return false;
        }
        Class<?> cls = obj.getClass();
        if (Intrinsics.areEqual(cls, Integer.TYPE)) {
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.Int");
            int iIntValue3 = ((Integer) obj).intValue();
            Intrinsics.checkNotNull(obj2, "null cannot be cast to non-null type kotlin.Int");
            if (iIntValue3 == ((Integer) obj2).intValue()) {
                return true;
            }
            return false;
        }
        if (Intrinsics.areEqual(cls, Long.TYPE)) {
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.Long");
            long jLongValue = ((Long) obj).longValue();
            Intrinsics.checkNotNull(obj2, "null cannot be cast to non-null type kotlin.Long");
            if (jLongValue == ((Long) obj2).longValue()) {
                return true;
            }
            return false;
        }
        if (Intrinsics.areEqual(cls, Boolean.TYPE)) {
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.Boolean");
            boolean zBooleanValue = ((Boolean) obj).booleanValue();
            Intrinsics.checkNotNull(obj2, "null cannot be cast to non-null type kotlin.Boolean");
            if (zBooleanValue == ((Boolean) obj2).booleanValue()) {
                return true;
            }
            return false;
        }
        if (Intrinsics.areEqual(cls, Double.TYPE)) {
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.Double");
            double dDoubleValue = ((Double) obj).doubleValue();
            Intrinsics.checkNotNull(obj2, "null cannot be cast to non-null type kotlin.Double");
            if (dDoubleValue == ((Double) obj2).doubleValue()) {
                return true;
            }
            return false;
        }
        if (Intrinsics.areEqual(cls, Byte.TYPE)) {
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.Byte");
            byte bByteValue2 = ((Byte) obj).byteValue();
            Intrinsics.checkNotNull(obj2, "null cannot be cast to non-null type kotlin.Byte");
            if (bByteValue2 == ((Byte) obj2).byteValue()) {
                return true;
            }
            return false;
        }
        if (!Intrinsics.areEqual(cls, Short.TYPE)) {
            return Intrinsics.areEqual(obj, obj2);
        }
        Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.Short");
        short sShortValue = ((Short) obj).shortValue();
        Intrinsics.checkNotNull(obj2, "null cannot be cast to non-null type kotlin.Short");
        if (sShortValue == ((Short) obj2).shortValue()) {
            return true;
        }
        return false;
    }

    public static final boolean b(Class cls) {
        Class cls2 = Integer.TYPE;
        if (!Intrinsics.areEqual(cls2, cls) && !Intrinsics.areEqual(cls2, cls)) {
            Class cls3 = Boolean.TYPE;
            if (!Intrinsics.areEqual(cls3, cls) && !Intrinsics.areEqual(cls3, cls)) {
                Class cls4 = Double.TYPE;
                if (!Intrinsics.areEqual(cls4, cls) && !Intrinsics.areEqual(cls4, cls)) {
                    Class cls5 = Float.TYPE;
                    if (!Intrinsics.areEqual(cls5, cls) && !Intrinsics.areEqual(cls5, cls)) {
                        Class cls6 = Long.TYPE;
                        if (!Intrinsics.areEqual(cls6, cls) && !Intrinsics.areEqual(cls6, cls) && !Intrinsics.areEqual(String.class, cls)) {
                            Class cls7 = Byte.TYPE;
                            if (!Intrinsics.areEqual(cls7, cls) && !Intrinsics.areEqual(cls7, cls)) {
                                Class cls8 = Short.TYPE;
                                if (!Intrinsics.areEqual(cls8, cls) && !Intrinsics.areEqual(cls8, cls)) {
                                    return false;
                                }
                            }
                        }
                    }
                }
            }
        }
        return true;
    }

    public static boolean a(JSONArray jSONArray, JSONArray jSONArray2) {
        if (jSONArray.length() != jSONArray2.length()) {
            return false;
        }
        int length = jSONArray.length();
        for (int i = 0; i < length; i++) {
            try {
                Object obj = jSONArray.get(i);
                Object obj2 = jSONArray2.get(i);
                if ((obj instanceof JSONObject) && (obj2 instanceof JSONObject)) {
                    if (!a((JSONObject) obj, (JSONObject) obj2)) {
                        return false;
                    }
                } else if ((obj instanceof JSONArray) && (obj2 instanceof JSONArray)) {
                    if (!a((JSONArray) obj, (JSONArray) obj2)) {
                        return false;
                    }
                } else {
                    Intrinsics.checkNotNull(obj);
                    Intrinsics.checkNotNull(obj2);
                    if (!a(obj, obj2)) {
                        return false;
                    }
                }
            } catch (JSONException unused) {
                return false;
            }
        }
        return true;
    }

    public static boolean a(JSONObject json1, JSONObject json2) {
        Intrinsics.checkNotNullParameter(json1, "json1");
        Intrinsics.checkNotNullParameter(json2, "json2");
        if (json1.length() != json2.length()) {
            return false;
        }
        Iterator<String> itKeys = json1.keys();
        while (itKeys.hasNext()) {
            String next = itKeys.next();
            try {
                Object obj = json1.get(next);
                Object obj2 = json2.get(next);
                if ((obj instanceof JSONObject) && (obj2 instanceof JSONObject)) {
                    if (!a((JSONObject) obj, (JSONObject) obj2)) {
                        return false;
                    }
                } else if ((obj instanceof JSONArray) && (obj2 instanceof JSONArray)) {
                    if (!a((JSONArray) obj, (JSONArray) obj2)) {
                        return false;
                    }
                } else {
                    Intrinsics.checkNotNull(obj);
                    Intrinsics.checkNotNull(obj2);
                    if (!a(obj, obj2)) {
                        return false;
                    }
                }
            } catch (JSONException unused) {
            }
        }
        return true;
    }

    public static final boolean a(Class cls) {
        return Intrinsics.areEqual(Integer.class, cls) || Intrinsics.areEqual(Boolean.class, cls) || Intrinsics.areEqual(Double.class, cls) || Intrinsics.areEqual(Float.class, cls) || Intrinsics.areEqual(Long.class, cls) || Intrinsics.areEqual(String.class, cls) || Intrinsics.areEqual(Byte.class, cls) || Intrinsics.areEqual(Short.class, cls);
    }

    public static final Object a(JSONArray jSONArray, int i, Class cls) throws JSONException {
        Object objValueOf;
        if (Intrinsics.areEqual(Integer.TYPE, cls)) {
            objValueOf = Integer.valueOf(jSONArray.getInt(i));
        } else if (Intrinsics.areEqual(Double.TYPE, cls)) {
            objValueOf = Double.valueOf(jSONArray.getDouble(i));
        } else if (Intrinsics.areEqual(Float.TYPE, cls)) {
            objValueOf = Float.valueOf((float) jSONArray.getDouble(i));
        } else if (Intrinsics.areEqual(Long.TYPE, cls)) {
            objValueOf = Long.valueOf(jSONArray.getLong(i));
        } else if (Intrinsics.areEqual(Byte.TYPE, cls)) {
            objValueOf = Byte.valueOf((byte) jSONArray.getInt(i));
        } else if (Intrinsics.areEqual(Short.TYPE, cls)) {
            objValueOf = Short.valueOf((short) jSONArray.getInt(i));
        } else {
            objValueOf = jSONArray.get(i);
        }
        Intrinsics.checkNotNull(objValueOf);
        return objValueOf;
    }

    public static final Object a(JSONObject jSONObject, String str, Class cls) throws JSONException {
        Object objValueOf;
        if (Intrinsics.areEqual(Integer.TYPE, cls)) {
            objValueOf = Integer.valueOf(jSONObject.getInt(str));
        } else if (Intrinsics.areEqual(Double.TYPE, cls)) {
            objValueOf = Double.valueOf(jSONObject.getDouble(str));
        } else if (Intrinsics.areEqual(Float.TYPE, cls)) {
            objValueOf = Float.valueOf((float) jSONObject.getDouble(str));
        } else if (Intrinsics.areEqual(Long.TYPE, cls)) {
            objValueOf = Long.valueOf(jSONObject.getLong(str));
        } else if (Intrinsics.areEqual(Byte.TYPE, cls)) {
            objValueOf = Byte.valueOf((byte) jSONObject.getInt(str));
        } else if (Intrinsics.areEqual(Short.TYPE, cls)) {
            objValueOf = Short.valueOf((short) jSONObject.getInt(str));
        } else {
            objValueOf = jSONObject.get(str);
        }
        Intrinsics.checkNotNull(objValueOf);
        return objValueOf;
    }

    public static void b(Object copyFrom, Object copyTo) {
        Intrinsics.checkNotNullParameter(copyFrom, "copyFrom");
        Intrinsics.checkNotNullParameter(copyTo, "copyTo");
        Class<?> cls = copyFrom.getClass();
        if (cls.isAssignableFrom(copyTo.getClass())) {
            Object objCast = cls.cast(copyTo);
            Intrinsics.checkNotNullExpressionValue(objCast, "cast(...)");
            Field[] declaredFields = cls.getDeclaredFields();
            Intrinsics.checkNotNullExpressionValue(declaredFields, "getDeclaredFields(...)");
            for (Field field : declaredFields) {
                try {
                    field.setAccessible(true);
                    field.set(objCast, field.get(copyFrom));
                } catch (IllegalAccessException unused) {
                }
            }
        }
    }
}
