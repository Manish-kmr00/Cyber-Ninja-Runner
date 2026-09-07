package com.bytedance.sdk.openadsdk.core.BSW.pA;

import android.content.ContentValues;
import android.text.TextUtils;
import android.util.LruCache;
import com.bytedance.sdk.component.utils.WV;
import com.bytedance.sdk.openadsdk.core.aBv;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/* JADX INFO: loaded from: classes8.dex */
public class KZx {
    private static volatile KZx Og = null;
    public static int pA = 20;
    private final Object KZx = new Object();
    private final LruCache<String, pA> ZZv = new LruCache<String, pA>(pA) { // from class: com.bytedance.sdk.openadsdk.core.BSW.pA.KZx.1
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // android.util.LruCache
        /* JADX INFO: renamed from: pA, reason: merged with bridge method [inline-methods] */
        public int sizeOf(String str, pA pAVar) {
            return 1;
        }
    };

    private KZx() {
    }

    public static KZx pA() {
        if (Og == null) {
            synchronized (KZx.class) {
                if (Og == null) {
                    Og = new KZx();
                }
            }
        }
        return Og;
    }

    pA pA(String str, String str2) {
        pA pAVar;
        pA pAVarPA;
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        synchronized (this.KZx) {
            pAVar = this.ZZv.get(str);
        }
        if (pAVar != null) {
            if (TextUtils.equals(str2, pAVar.Og())) {
                return pAVar;
            }
            Og(str2);
            return null;
        }
        com.bytedance.sdk.openadsdk.multipro.aidl.KZx kZx = new com.bytedance.sdk.openadsdk.multipro.aidl.KZx(com.bytedance.sdk.openadsdk.multipro.pA.pA.pA(aBv.pA(), "ugen_template", null, "id=? AND md5=?", new String[]{str, str2}, null, null, null));
        try {
            if (kZx.moveToFirst()) {
                do {
                    int columnIndex = kZx.getColumnIndex("id");
                    int columnIndex2 = kZx.getColumnIndex("md5");
                    int columnIndex3 = kZx.getColumnIndex("url");
                    int columnIndex4 = kZx.getColumnIndex("data");
                    int columnIndex5 = kZx.getColumnIndex("update_time");
                    if (columnIndex != -1 && columnIndex2 != -1 && columnIndex3 != -1 && columnIndex5 != -1 && columnIndex4 != -1) {
                        int columnIndex6 = kZx.getColumnIndex("rit");
                        String string = kZx.getString(columnIndex);
                        String string2 = kZx.getString(columnIndex2);
                        String string3 = kZx.getString(columnIndex3);
                        String string4 = kZx.getString(columnIndex4);
                        if (TextUtils.isEmpty(string4)) {
                            kZx.close();
                            return null;
                        }
                        pAVarPA = new pA().pA(string).Og(string2).ZZv(string4).KZx(string3).ML(columnIndex6 != -1 ? kZx.getString(columnIndex6) : null).pA(Long.valueOf(kZx.getLong(columnIndex5)));
                        synchronized (this.KZx) {
                            this.ZZv.put(string, pAVarPA);
                        }
                    }
                    kZx.close();
                    return null;
                } while (kZx.moveToNext());
                kZx.close();
                return pAVarPA;
            }
        } catch (Throwable th) {
            try {
                WV.pA("UGTmplDbHelper", "getGgenTemplate error", th);
            } finally {
                kZx.close();
            }
        }
        return null;
    }

    void pA(pA pAVar) {
        if (pAVar == null || TextUtils.isEmpty(pAVar.pA())) {
            return;
        }
        com.bytedance.sdk.openadsdk.multipro.aidl.KZx kZx = new com.bytedance.sdk.openadsdk.multipro.aidl.KZx(com.bytedance.sdk.openadsdk.multipro.pA.pA.pA(aBv.pA(), "ugen_template", null, "id=?", new String[]{pAVar.pA()}, null, null, null));
        boolean z = kZx.getCount() > 0;
        try {
            kZx.close();
        } catch (Throwable unused) {
        }
        ContentValues contentValues = new ContentValues();
        contentValues.put("id", pAVar.pA());
        contentValues.put("md5", pAVar.Og());
        contentValues.put("url", pAVar.KZx());
        contentValues.put("data", pAVar.ML());
        contentValues.put("rit", pAVar.JG());
        contentValues.put("update_time", pAVar.ZZv());
        if (z) {
            com.bytedance.sdk.openadsdk.multipro.pA.pA.pA(aBv.pA(), "ugen_template", contentValues, "id=?", new String[]{pAVar.pA()});
        } else {
            com.bytedance.sdk.openadsdk.multipro.pA.pA.pA(aBv.pA(), "ugen_template", contentValues);
        }
        synchronized (this.KZx) {
            this.ZZv.put(pAVar.pA(), pAVar);
        }
    }

    List<pA> Og() {
        ArrayList arrayList = new ArrayList();
        com.bytedance.sdk.openadsdk.multipro.aidl.KZx kZx = new com.bytedance.sdk.openadsdk.multipro.aidl.KZx(com.bytedance.sdk.openadsdk.multipro.pA.pA.pA(aBv.pA(), "ugen_template", null, null, null, null, null, null));
        try {
            if (kZx.moveToFirst()) {
                do {
                    int columnIndex = kZx.getColumnIndex("id");
                    int columnIndex2 = kZx.getColumnIndex("md5");
                    int columnIndex3 = kZx.getColumnIndex("url");
                    int columnIndex4 = kZx.getColumnIndex("data");
                    int columnIndex5 = kZx.getColumnIndex("update_time");
                    if (columnIndex != -1 && columnIndex2 != -1 && columnIndex3 != -1 && columnIndex5 != -1 && columnIndex4 != -1) {
                        int columnIndex6 = kZx.getColumnIndex("rit");
                        String string = columnIndex6 != -1 ? kZx.getString(columnIndex6) : null;
                        String string2 = kZx.getString(columnIndex);
                        String string3 = kZx.getString(columnIndex2);
                        String string4 = kZx.getString(columnIndex3);
                        pA pAVarPA = new pA().pA(string2).Og(string3).KZx(string4).ZZv(kZx.getString(columnIndex4)).ML(string).pA(Long.valueOf(kZx.getLong(columnIndex5)));
                        arrayList.add(pAVarPA);
                        synchronized (this.KZx) {
                            this.ZZv.put(string2, pAVarPA);
                        }
                    }
                } while (kZx.moveToNext());
            }
        } catch (Throwable th) {
            try {
                WV.pA("UGTmplDbHelper", "getUgenTemplate error", th);
            } finally {
                kZx.close();
            }
        }
        return arrayList;
    }

    Set<pA> pA(String str) {
        pA pAVar;
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        HashSet hashSet = new HashSet();
        com.bytedance.sdk.openadsdk.multipro.aidl.KZx kZx = new com.bytedance.sdk.openadsdk.multipro.aidl.KZx(com.bytedance.sdk.openadsdk.multipro.pA.pA.pA(aBv.pA(), "ugen_template", null, "rit=?", new String[]{str}, null, null, null));
        try {
            if (kZx.moveToFirst()) {
                do {
                    int columnIndex = kZx.getColumnIndex("id");
                    if (columnIndex != -1) {
                        String string = kZx.getString(columnIndex);
                        if (!TextUtils.isEmpty(string)) {
                            synchronized (this.KZx) {
                                pAVar = this.ZZv.get(string);
                            }
                            if (pAVar != null) {
                                hashSet.add(pAVar);
                            } else {
                                pA pAVar2 = new pA();
                                int columnIndex2 = kZx.getColumnIndex("data");
                                if (columnIndex2 != -1) {
                                    String string2 = kZx.getString(columnIndex2);
                                    if (!TextUtils.isEmpty(string2)) {
                                        pAVar2.ZZv(string2);
                                        pAVar2.pA(string);
                                        pAVar2.ML(str);
                                        int columnIndex3 = kZx.getColumnIndex("md5");
                                        int columnIndex4 = kZx.getColumnIndex("url");
                                        int columnIndex5 = kZx.getColumnIndex("update_time");
                                        if (columnIndex3 != -1) {
                                            pAVar2.Og(kZx.getString(columnIndex3));
                                        }
                                        if (columnIndex4 != -1) {
                                            pAVar2.KZx(kZx.getString(columnIndex4));
                                        }
                                        if (columnIndex5 != -1) {
                                            pAVar2.pA(Long.valueOf(kZx.getLong(columnIndex5)));
                                        }
                                        hashSet.add(pAVar2);
                                        synchronized (this.KZx) {
                                            this.ZZv.put(string, pAVar2);
                                        }
                                    }
                                }
                            }
                        }
                    }
                } while (kZx.moveToNext());
            }
        } catch (Throwable th) {
            try {
                WV.pA("UGTmplDbHelper", "getUgenTemplateFormRit error", th);
            } finally {
                kZx.close();
            }
        }
        return hashSet;
    }

    void pA(Set<String> set) {
        if (set == null || set.isEmpty()) {
            return;
        }
        String[] strArr = (String[]) set.toArray(new String[set.size()]);
        if (strArr.length > 0) {
            for (String str : strArr) {
                Og(str);
                com.bytedance.sdk.openadsdk.multipro.pA.pA.pA(aBv.pA(), "ugen_template", "id=?", new String[]{str});
            }
        }
    }

    private void Og(String str) {
        if (!TextUtils.isEmpty(str) && this.ZZv.size() > 0) {
            synchronized (this.KZx) {
                this.ZZv.remove(str);
            }
        }
    }

    public static String KZx() {
        return "CREATE TABLE IF NOT EXISTS ugen_template (_id INTEGER PRIMARY KEY AUTOINCREMENT,id TEXT UNIQUE,md5 TEXT ,url TEXT , data TEXT , rit TEXT , update_time TEXT)";
    }

    public static String ZZv() {
        return "ALTER TABLE ugen_template ADD COLUMN rit TEXT ";
    }
}
