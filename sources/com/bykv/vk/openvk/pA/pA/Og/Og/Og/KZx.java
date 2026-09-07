package com.bykv.vk.openvk.pA.pA.Og.Og.Og;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteStatement;
import android.text.TextUtils;
import android.util.SparseArray;
import com.bytedance.sdk.component.omh.Bzk;
import java.util.Collection;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Executor;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes13.dex */
public class KZx {
    private static volatile KZx Og;
    private final ZZv KZx;
    private volatile SQLiteStatement ML;
    private final Executor ZZv;
    private final SparseArray<Map<String, pA>> pA;

    private KZx(Context context) {
        SparseArray<Map<String, pA>> sparseArray = new SparseArray<>(2);
        this.pA = sparseArray;
        this.ZZv = new ThreadPoolExecutor(0, 1, 60L, TimeUnit.SECONDS, new LinkedBlockingDeque(), new Bzk(5, "video_proxy_db"));
        this.KZx = new ZZv(context.getApplicationContext());
        sparseArray.put(0, new ConcurrentHashMap());
        sparseArray.put(1, new ConcurrentHashMap());
    }

    public static KZx pA(Context context) {
        if (Og == null) {
            synchronized (KZx.class) {
                if (Og == null) {
                    Og = new KZx(context);
                }
            }
        }
        return Og;
    }

    public pA pA(String str, int i) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        Map<String, pA> map = this.pA.get(i);
        pA pAVar = map == null ? null : map.get(str);
        if (pAVar != null) {
            return pAVar;
        }
        try {
            Cursor cursorQuery = this.KZx.getReadableDatabase().query("video_http_header_t", null, "key=? AND flag=?", new String[]{str, String.valueOf(i)}, null, null, null, "1");
            if (cursorQuery != null) {
                if (cursorQuery.getCount() > 0 && cursorQuery.moveToNext()) {
                    pAVar = new pA(cursorQuery.getString(cursorQuery.getColumnIndex("key")), cursorQuery.getString(cursorQuery.getColumnIndex("mime")), cursorQuery.getInt(cursorQuery.getColumnIndex("contentLength")), i, cursorQuery.getString(cursorQuery.getColumnIndex("extra")));
                }
                cursorQuery.close();
            }
            if (pAVar != null && map != null) {
                map.put(str, pAVar);
            }
            return pAVar;
        } catch (Throwable unused) {
            return null;
        }
    }

    public void pA(final pA pAVar) {
        if (pAVar != null) {
            Map<String, pA> map = this.pA.get(pAVar.ZZv);
            if (map != null) {
                map.put(pAVar.pA, pAVar);
            }
            this.ZZv.execute(new Runnable() { // from class: com.bykv.vk.openvk.pA.pA.Og.Og.Og.KZx.1
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        if (KZx.this.ML != null) {
                            KZx.this.ML.clearBindings();
                        } else {
                            KZx kZx = KZx.this;
                            kZx.ML = kZx.KZx.getWritableDatabase().compileStatement("INSERT INTO video_http_header_t (key,mime,contentLength,flag,extra) VALUES(?,?,?,?,?)");
                        }
                        KZx.this.ML.bindString(1, pAVar.pA);
                        KZx.this.ML.bindString(2, pAVar.Og);
                        KZx.this.ML.bindLong(3, pAVar.KZx);
                        KZx.this.ML.bindLong(4, pAVar.ZZv);
                        KZx.this.ML.bindString(5, pAVar.ML);
                        KZx.this.ML.executeInsert();
                    } catch (Throwable unused) {
                    }
                }
            });
        }
    }

    public void pA(Collection<String> collection, int i) {
        if (collection == null || collection.isEmpty()) {
            return;
        }
        int size = collection.size() + 1;
        String[] strArr = new String[size];
        Map<String, pA> map = this.pA.get(i);
        int i2 = -1;
        for (String str : collection) {
            if (map != null) {
                map.remove(str);
            }
            i2++;
            strArr[i2] = str;
        }
        strArr[i2 + 1] = String.valueOf(i);
        try {
            this.KZx.getWritableDatabase().delete("video_http_header_t", "key IN(" + Og(size) + ") AND flag=?", strArr);
        } catch (Throwable unused) {
        }
    }

    private String Og(int i) {
        if (i <= 0) {
            return "";
        }
        StringBuilder sb = new StringBuilder(i << 1);
        sb.append("?");
        for (int i2 = 1; i2 < i; i2++) {
            sb.append(",?");
        }
        return sb.toString();
    }

    public void pA(final int i) {
        Map<String, pA> map = this.pA.get(i);
        if (map != null) {
            map.clear();
        }
        this.ZZv.execute(new Runnable() { // from class: com.bykv.vk.openvk.pA.pA.Og.Og.Og.KZx.2
            @Override // java.lang.Runnable
            public void run() {
                try {
                    KZx.this.KZx.getWritableDatabase().delete("video_http_header_t", "flag=?", new String[]{String.valueOf(i)});
                } catch (Throwable unused) {
                }
            }
        });
    }
}
