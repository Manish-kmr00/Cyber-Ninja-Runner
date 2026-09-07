package com.bytedance.sdk.component.JG.pA.JG;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.text.TextUtils;
import com.safedk.android.analytics.brandsafety.creatives.infos.CreativeInfo;
import java.util.LinkedList;
import java.util.List;

/* JADX INFO: loaded from: classes7.dex */
public class JG implements ML {
    private Context pA;

    public JG(Context context) {
        this.pA = context;
    }

    /* JADX WARN: Code duplicated, block: B:19:0x0092 A[DONT_GENERATE, PHI: r1
  0x0092: PHI (r1v4 android.database.Cursor) = (r1v3 android.database.Cursor), (r1v1 android.database.Cursor) binds: [B:27:0x00a4, B:18:0x0090] A[DONT_GENERATE, DONT_INLINE]] */
    @Override // com.bytedance.sdk.component.JG.pA.JG.ML
    public List<ZZv> pA() {
        LinkedList linkedList = new LinkedList();
        Cursor cursorPA = com.bytedance.sdk.component.JG.pA.pA.pA.KZx.pA(this.pA, "trackurl", null, null, null, null, null, null);
        if (cursorPA != null) {
            while (cursorPA.moveToNext()) {
                try {
                    String string = cursorPA.getString(cursorPA.getColumnIndex("id"));
                    String string2 = cursorPA.getString(cursorPA.getColumnIndex("url"));
                    boolean z = cursorPA.getInt(cursorPA.getColumnIndex("replaceholder")) > 0;
                    int i = cursorPA.getInt(cursorPA.getColumnIndex("retry"));
                    int i2 = cursorPA.getInt(cursorPA.getColumnIndex("url_type"));
                    String string3 = cursorPA.getString(cursorPA.getColumnIndex(CreativeInfo.c));
                    String string4 = cursorPA.getString(cursorPA.getColumnIndex("error_code"));
                    String string5 = cursorPA.getString(cursorPA.getColumnIndex("error_msg"));
                    ZZv zZv = new ZZv(string, string2, z, i2, string3);
                    zZv.pA(i);
                    if (!TextUtils.isEmpty(string4)) {
                        zZv.pA(string4);
                    }
                    if (!TextUtils.isEmpty(string5)) {
                        zZv.Og(string5);
                    }
                    linkedList.add(zZv);
                } catch (Throwable unused) {
                    if (cursorPA != null) {
                        try {
                            cursorPA.close();
                            cursorPA = null;
                        } finally {
                            if (cursorPA != null) {
                                cursorPA.close();
                            }
                        }
                    }
                }
            }
            if (cursorPA != null) {
            }
        }
        return linkedList;
    }

    @Override // com.bytedance.sdk.component.JG.pA.JG.ML
    public ZZv pA(String str) {
        Cursor cursorPA = com.bytedance.sdk.component.JG.pA.pA.pA.KZx.pA(this.pA, "trackurl", null, "id=?", new String[]{str}, null, null, null);
        if (cursorPA != null && cursorPA.moveToFirst()) {
            try {
                String string = cursorPA.getString(cursorPA.getColumnIndex("id"));
                String string2 = cursorPA.getString(cursorPA.getColumnIndex("url"));
                boolean z = cursorPA.getInt(cursorPA.getColumnIndex("replaceholder")) > 0;
                int i = cursorPA.getInt(cursorPA.getColumnIndex("retry"));
                int i2 = cursorPA.getInt(cursorPA.getColumnIndex("url_type"));
                String string3 = cursorPA.getString(cursorPA.getColumnIndex(CreativeInfo.c));
                String string4 = cursorPA.getString(cursorPA.getColumnIndex("error_code"));
                String string5 = cursorPA.getString(cursorPA.getColumnIndex("error_msg"));
                ZZv zZv = new ZZv(string, string2, z, i2, string3);
                zZv.pA(i);
                if (!TextUtils.isEmpty(string4)) {
                    zZv.pA(string4);
                }
                if (!TextUtils.isEmpty(string5)) {
                    zZv.Og(string5);
                }
                cursorPA.close();
                return zZv;
            } catch (Throwable th) {
                try {
                    th.getMessage();
                    cursorPA.close();
                    cursorPA = null;
                } catch (Throwable th2) {
                    cursorPA.close();
                    throw th2;
                }
            }
        }
        if (cursorPA != null) {
            cursorPA.close();
        }
        return null;
    }

    @Override // com.bytedance.sdk.component.JG.pA.JG.ML
    public void pA(ZZv zZv) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("id", zZv.pA());
        contentValues.put("url", zZv.Og());
        contentValues.put("replaceholder", Integer.valueOf(zZv.KZx() ? 1 : 0));
        contentValues.put("retry", Integer.valueOf(zZv.ZZv()));
        contentValues.put("url_type", Integer.valueOf(zZv.ML()));
        contentValues.put(CreativeInfo.c, zZv.JG());
        contentValues.put("error_code", zZv.SD());
        contentValues.put("error_msg", zZv.Bzk());
        com.bytedance.sdk.component.JG.pA.pA.pA.KZx.pA(this.pA, "trackurl", contentValues);
    }

    @Override // com.bytedance.sdk.component.JG.pA.JG.ML
    public void Og(ZZv zZv) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("id", zZv.pA());
        contentValues.put("url", zZv.Og());
        contentValues.put("replaceholder", Integer.valueOf(zZv.KZx() ? 1 : 0));
        contentValues.put("retry", Integer.valueOf(zZv.ZZv()));
        contentValues.put("error_code", zZv.SD());
        contentValues.put("error_msg", zZv.Bzk());
        contentValues.put("url_type", Integer.valueOf(zZv.ML()));
        contentValues.put(CreativeInfo.c, zZv.JG());
        com.bytedance.sdk.component.JG.pA.pA.pA.KZx.pA(this.pA, "trackurl", contentValues, "id=?", new String[]{zZv.pA()});
    }

    @Override // com.bytedance.sdk.component.JG.pA.JG.ML
    public void KZx(ZZv zZv) {
        com.bytedance.sdk.component.JG.pA.pA.pA.KZx.pA(this.pA, "trackurl", "id=?", new String[]{zZv.pA()});
    }

    public static String Og() {
        return "CREATE TABLE IF NOT EXISTS trackurl (_id INTEGER PRIMARY KEY AUTOINCREMENT,id TEXT UNIQUE,url TEXT ,replaceholder INTEGER default 0, retry INTEGER default 0)";
    }
}
