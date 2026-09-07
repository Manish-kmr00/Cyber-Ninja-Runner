package com.bytedance.sdk.openadsdk.multipro.pA;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.text.TextUtils;
import com.bytedance.sdk.component.JG.pA.JG;
import com.bytedance.sdk.openadsdk.core.ML;
import com.bytedance.sdk.openadsdk.core.aBv;
import com.bytedance.sdk.openadsdk.multipro.ZZv;
import com.bytedance.sdk.openadsdk.utils.gbA;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: classes11.dex */
public class pA {
    private static final ConcurrentHashMap<String, Object> Og = new ConcurrentHashMap<>();
    public static JG pA;

    /* JADX WARN: Code duplicated, block: B:6:0x0009 A[Catch: all -> 0x0026, TryCatch #0 {all -> 0x0026, blocks: (B:3:0x0002, B:4:0x0005, B:6:0x0009, B:8:0x000f, B:9:0x001f), top: B:14:0x0002 }] */
    /* JADX WARN: Code duplicated, block: B:8:0x000f A[Catch: all -> 0x0026, TryCatch #0 {all -> 0x0026, blocks: (B:3:0x0002, B:4:0x0005, B:6:0x0009, B:8:0x000f, B:9:0x001f), top: B:14:0x0002 }] */
    /* JADX WARN: Code duplicated, block: B:9:0x001f A[Catch: all -> 0x0026, TRY_LEAVE, TryCatch #0 {all -> 0x0026, blocks: (B:3:0x0002, B:4:0x0005, B:6:0x0009, B:8:0x000f, B:9:0x001f), top: B:14:0x0002 }] */
    public static JG pA(Context context) {
        if (context == null) {
            try {
                aBv.pA();
                if (pA == null) {
                    if (com.bytedance.sdk.openadsdk.multipro.Og.KZx()) {
                        pA = com.bytedance.sdk.openadsdk.multipro.aidl.pA.JG.pA(com.bytedance.sdk.openadsdk.multipro.aidl.pA.pA().pA(5));
                    } else {
                        pA = com.bytedance.sdk.openadsdk.multipro.aidl.pA.JG.Og();
                    }
                }
            } catch (Throwable unused) {
                gbA.omh("binder error");
            }
        } else if (pA == null) {
            if (com.bytedance.sdk.openadsdk.multipro.Og.KZx()) {
                pA = com.bytedance.sdk.openadsdk.multipro.aidl.pA.JG.pA(com.bytedance.sdk.openadsdk.multipro.aidl.pA.pA().pA(5));
            } else {
                pA = com.bytedance.sdk.openadsdk.multipro.aidl.pA.JG.Og();
            }
        }
        return pA;
    }

    private static String pA() {
        return ZZv.Og + "/t_db/ttopensdk.db/";
    }

    public static void pA(Context context, String str, ContentValues contentValues) {
        if (contentValues == null || TextUtils.isEmpty(str)) {
            return;
        }
        synchronized (pA(str)) {
            try {
                try {
                    if (!com.bytedance.sdk.openadsdk.multipro.Og.KZx()) {
                        ML.pA(context).pA().pA(str, (String) null, contentValues);
                        return;
                    }
                    JG jgPA = pA(context);
                    if (jgPA != null) {
                        jgPA.pA(Uri.parse(pA() + str), contentValues);
                    }
                } catch (Throwable unused) {
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public static int pA(Context context, String str, String str2, String[] strArr) {
        if (TextUtils.isEmpty(str)) {
            return 0;
        }
        synchronized (pA(str)) {
            try {
                try {
                    if (!com.bytedance.sdk.openadsdk.multipro.Og.KZx()) {
                        return ML.pA(context).pA().pA(str, str2, strArr);
                    }
                    JG jgPA = pA(context);
                    if (jgPA != null) {
                        return jgPA.pA(Uri.parse(pA() + str), str2, strArr);
                    }
                    return 0;
                } catch (Throwable th) {
                    throw th;
                }
            } catch (Throwable unused) {
            }
        }
    }

    public static int pA(Context context, String str, ContentValues contentValues, String str2, String[] strArr) {
        if (contentValues != null && !TextUtils.isEmpty(str)) {
            synchronized (pA(str)) {
                try {
                    try {
                        if (!com.bytedance.sdk.openadsdk.multipro.Og.KZx()) {
                            return ML.pA(context).pA().pA(str, contentValues, str2, strArr);
                        }
                        JG jgPA = pA(context);
                        if (jgPA != null) {
                            return jgPA.pA(Uri.parse(pA() + str), contentValues, str2, strArr);
                        }
                    } catch (Throwable th) {
                        throw th;
                    }
                } catch (Throwable unused) {
                }
            }
        }
        return 0;
    }

    public static Map<String, List<String>> pA(Context context, String str, String[] strArr, String str2, String[] strArr2, String str3, String str4, String str5) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        synchronized (pA(str)) {
            try {
                try {
                    if (!com.bytedance.sdk.openadsdk.multipro.Og.KZx()) {
                        return pA(ML.pA(context).pA().pA(str, strArr, str2, strArr2, str3, str4, str5));
                    }
                    JG jgPA = pA(context);
                    if (jgPA != null) {
                        return jgPA.pA(Uri.parse(pA() + str), strArr, str2, strArr2, str5);
                    }
                    return null;
                } catch (Throwable th) {
                    throw th;
                }
            } catch (Throwable unused) {
            }
        }
    }

    /* JADX WARN: Code duplicated, block: B:19:0x0044  */
    public static Map<String, List<String>> pA(Cursor cursor) {
        HashMap map = new HashMap();
        if (cursor != null) {
            try {
                String[] columnNames = cursor.getColumnNames();
                while (cursor.getCount() > 0 && cursor.moveToNext()) {
                    for (String str : columnNames) {
                        if (!map.containsKey(str)) {
                            map.put(str, new LinkedList());
                        }
                        ((List) map.get(str)).add(cursor.getString(cursor.getColumnIndex(str)));
                    }
                }
                if (cursor != null) {
                    cursor.close();
                }
            } catch (Throwable unused) {
                if (cursor != null) {
                    cursor.close();
                }
            }
        }
        return map;
    }

    private static Object pA(String str) {
        Object obj;
        ConcurrentHashMap<String, Object> concurrentHashMap = Og;
        Object obj2 = concurrentHashMap.get(str);
        if (obj2 != null) {
            return obj2;
        }
        synchronized (pA.class) {
            obj = concurrentHashMap.get(str);
            if (obj == null) {
                obj = new Object();
                concurrentHashMap.put(str, obj);
            }
        }
        return obj;
    }
}
