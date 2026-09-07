package com.bytedance.sdk.component.adexpress.pA.Og;

import android.content.ContentValues;
import android.database.Cursor;
import android.text.TextUtils;
import android.util.Log;
import android.util.LruCache;
import com.bytedance.sdk.component.utils.WV;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes9.dex */
public class JG {
    private static volatile JG Og = null;
    public static int pA = 20;
    private volatile ConcurrentHashMap<String, com.bytedance.sdk.component.adexpress.pA.KZx.KZx> ML;
    private final Object ZZv = new Object();
    private AtomicBoolean JG = new AtomicBoolean(false);
    private LruCache<String, com.bytedance.sdk.component.adexpress.pA.KZx.Og> SD = new LruCache<String, com.bytedance.sdk.component.adexpress.pA.KZx.Og>(pA) { // from class: com.bytedance.sdk.component.adexpress.pA.Og.JG.1
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // android.util.LruCache
        /* JADX INFO: renamed from: pA, reason: merged with bridge method [inline-methods] */
        public int sizeOf(String str, com.bytedance.sdk.component.adexpress.pA.KZx.Og og) {
            return 1;
        }
    };
    private Set<String> KZx = Collections.synchronizedSet(new HashSet());

    public static void pA(int i) {
        pA = i;
    }

    public static JG pA() {
        if (Og == null) {
            synchronized (JG.class) {
                if (Og == null) {
                    Og = new JG();
                }
            }
        }
        return Og;
    }

    private JG() {
    }

    com.bytedance.sdk.component.adexpress.pA.KZx.Og pA(String str) {
        com.bytedance.sdk.component.adexpress.pA.KZx.Og og;
        com.bytedance.sdk.component.adexpress.pA.KZx.Og ogPA;
        if (TextUtils.isEmpty(str) || com.bytedance.sdk.component.adexpress.pA.pA.pA.pA().Og() == null) {
            return null;
        }
        synchronized (this.ZZv) {
            og = this.SD.get(String.valueOf(str));
        }
        if (og != null) {
            return og;
        }
        Cursor cursorPA = com.bytedance.sdk.component.adexpress.pA.pA.pA.pA().Og().pA("template_diff_new", null, "id=?", new String[]{str}, null, null, null);
        if (cursorPA != null) {
            try {
                if (cursorPA.moveToFirst()) {
                    do {
                        String string = cursorPA.getString(cursorPA.getColumnIndex("rit"));
                        String string2 = cursorPA.getString(cursorPA.getColumnIndex("id"));
                        String string3 = cursorPA.getString(cursorPA.getColumnIndex("md5"));
                        String string4 = cursorPA.getString(cursorPA.getColumnIndex("url"));
                        String string5 = cursorPA.getString(cursorPA.getColumnIndex("data"));
                        ogPA = new com.bytedance.sdk.component.adexpress.pA.KZx.Og().pA(string).Og(string2).KZx(string3).ZZv(string4).ML(string5).JG(cursorPA.getString(cursorPA.getColumnIndex("version"))).pA(Long.valueOf(cursorPA.getLong(cursorPA.getColumnIndex("update_time"))));
                        synchronized (this.ZZv) {
                            this.SD.put(string2, ogPA);
                        }
                        this.KZx.add(string2);
                    } while (cursorPA.moveToNext());
                    cursorPA.close();
                    return ogPA;
                }
            } catch (Throwable th) {
                try {
                    WV.pA("TmplDbHelper", "getTemplate error", th);
                } finally {
                    cursorPA.close();
                }
            }
        }
        return null;
    }

    Set<String> Og(String str) {
        if (!TextUtils.isEmpty(str) && com.bytedance.sdk.component.adexpress.pA.pA.pA.pA().Og() != null) {
            HashSet hashSet = new HashSet();
            Cursor cursorPA = com.bytedance.sdk.component.adexpress.pA.pA.pA.pA().Og().pA("template_diff_new", null, "rit=?", new String[]{str}, null, null, null);
            try {
                if (cursorPA != null) {
                    try {
                        if (cursorPA.moveToFirst()) {
                            do {
                                hashSet.add(cursorPA.getString(cursorPA.getColumnIndex("id")));
                            } while (cursorPA.moveToNext());
                            return hashSet;
                        }
                    } catch (Exception e) {
                        Log.e("TmplDbHelper", "", e);
                    }
                }
            } finally {
                cursorPA.close();
            }
        }
        return null;
    }

    /* JADX WARN: Code duplicated, block: B:29:0x00f0 A[DONT_GENERATE] */
    List<com.bytedance.sdk.component.adexpress.pA.KZx.Og> Og() {
        if (com.bytedance.sdk.component.adexpress.pA.pA.pA.pA().Og() == null) {
            return null;
        }
        boolean z = this.JG.get();
        this.JG.set(true);
        ArrayList arrayList = new ArrayList();
        Cursor cursorPA = com.bytedance.sdk.component.adexpress.pA.pA.pA.pA().Og().pA("template_diff_new", null, null, null, null, null, null);
        if (cursorPA != null) {
            while (cursorPA.moveToNext()) {
                try {
                    String string = cursorPA.getString(cursorPA.getColumnIndex("rit"));
                    String string2 = cursorPA.getString(cursorPA.getColumnIndex("id"));
                    String string3 = cursorPA.getString(cursorPA.getColumnIndex("md5"));
                    String string4 = cursorPA.getString(cursorPA.getColumnIndex("url"));
                    String string5 = cursorPA.getString(cursorPA.getColumnIndex("data"));
                    String string6 = cursorPA.getString(cursorPA.getColumnIndex("version"));
                    arrayList.add(new com.bytedance.sdk.component.adexpress.pA.KZx.Og().pA(string).Og(string2).KZx(string3).ZZv(string4).ML(string5).JG(string6).pA(Long.valueOf(cursorPA.getLong(cursorPA.getColumnIndex("update_time")))));
                    synchronized (this.ZZv) {
                        this.SD.put(string2, (com.bytedance.sdk.component.adexpress.pA.KZx.Og) arrayList.get(arrayList.size() - 1));
                    }
                    this.KZx.add(string2);
                    if (!z && com.bytedance.sdk.component.adexpress.pA.pA.pA.pA().JG() != null) {
                        if (this.ML == null) {
                            this.ML = new ConcurrentHashMap<>();
                        }
                        if (string2 != null && !this.ML.contains(string2)) {
                            this.ML.put(string2, new com.bytedance.sdk.component.adexpress.pA.KZx.KZx(string, string2, string3));
                        }
                    }
                } catch (Throwable th) {
                    try {
                        WV.pA("TmplDbHelper", "getTemplate error", th);
                    } finally {
                        if (cursorPA != null) {
                            cursorPA.close();
                        }
                    }
                }
            }
            if (cursorPA != null) {
            }
        }
        return arrayList;
    }

    void pA(com.bytedance.sdk.component.adexpress.pA.KZx.Og og, boolean z) {
        if (og == null || com.bytedance.sdk.component.adexpress.pA.pA.pA.pA().Og() == null || TextUtils.isEmpty(og.Og())) {
            return;
        }
        Cursor cursorPA = com.bytedance.sdk.component.adexpress.pA.pA.pA.pA().Og().pA("template_diff_new", null, "id=?", new String[]{og.Og()}, null, null, null);
        boolean z2 = cursorPA != null && cursorPA.getCount() > 0;
        String string = null;
        if (cursorPA != null) {
            try {
                string = cursorPA.moveToFirst() ? cursorPA.getString(cursorPA.getColumnIndex("rit")) : null;
                cursorPA.close();
            } catch (Throwable unused) {
            }
        }
        ContentValues contentValues = new ContentValues();
        contentValues.put("rit", og.pA());
        contentValues.put("id", og.Og());
        contentValues.put("md5", og.KZx());
        contentValues.put("url", og.ZZv());
        contentValues.put("data", og.ML());
        contentValues.put("version", og.JG());
        contentValues.put("update_time", og.SD());
        if (z2) {
            com.bytedance.sdk.component.adexpress.pA.pA.pA.pA().Og().pA("template_diff_new", contentValues, "id=?", new String[]{og.Og()});
        } else {
            com.bytedance.sdk.component.adexpress.pA.pA.pA.pA().Og().pA("template_diff_new", contentValues);
        }
        synchronized (this.ZZv) {
            this.SD.put(og.Og(), og);
        }
        this.KZx.add(og.Og());
        if (z) {
            return;
        }
        try {
            if (com.bytedance.sdk.component.adexpress.pA.pA.pA.pA().JG() == null) {
                return;
            }
            if (this.ML == null) {
                this.ML = new ConcurrentHashMap<>();
            }
            com.bytedance.sdk.component.adexpress.pA.KZx.KZx kZx = new com.bytedance.sdk.component.adexpress.pA.KZx.KZx(og.pA(), og.Og(), og.KZx());
            this.ML.put(og.Og(), kZx);
            if (string != null) {
                com.bytedance.sdk.component.adexpress.pA.pA.pA.pA().JG();
                kZx.Og();
            }
            com.bytedance.sdk.component.adexpress.pA.pA.pA.pA().JG();
            og.pA();
        } catch (Throwable unused2) {
        }
    }

    void pA(Set<String> set) {
        if (set == null || set.isEmpty() || com.bytedance.sdk.component.adexpress.pA.pA.pA.pA().Og() == null) {
            return;
        }
        String[] strArr = (String[]) set.toArray(new String[set.size()]);
        if (strArr.length > 0) {
            for (int i = 0; i < strArr.length; i++) {
                ZZv(strArr[i]);
                com.bytedance.sdk.component.adexpress.pA.pA.pA.pA().Og().pA("template_diff_new", "id=?", new String[]{strArr[i]});
                KZx(strArr[i]);
            }
        }
    }

    void KZx(String str) {
        com.bytedance.sdk.component.adexpress.pA.KZx.KZx kZx;
        try {
            if (this.ML == null || this.ML.isEmpty() || (kZx = this.ML.get(str)) == null) {
                return;
            }
            if (!TextUtils.isEmpty(kZx.pA()) && com.bytedance.sdk.component.adexpress.pA.pA.pA.pA().JG() != null) {
                com.bytedance.sdk.component.adexpress.pA.pA.pA.pA().JG();
            }
            this.ML.remove(str);
        } catch (Throwable unused) {
        }
    }

    private void ZZv(String str) {
        LruCache<String, com.bytedance.sdk.component.adexpress.pA.KZx.Og> lruCache;
        if (TextUtils.isEmpty(str) || (lruCache = this.SD) == null || lruCache.size() <= 0) {
            return;
        }
        synchronized (this.ZZv) {
            this.SD.remove(str);
        }
    }

    public static String KZx() {
        return "CREATE TABLE IF NOT EXISTS template_diff_new (_id INTEGER PRIMARY KEY AUTOINCREMENT,rit TEXT ,id TEXT UNIQUE,md5 TEXT ,url TEXT , data TEXT , version TEXT , update_time TEXT)";
    }
}
