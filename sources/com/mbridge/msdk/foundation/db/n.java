package com.mbridge.msdk.foundation.db;

import android.content.ContentValues;
import android.database.Cursor;
import android.text.TextUtils;
import com.json.cc;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.foundation.same.report.o;
import com.mbridge.msdk.foundation.tools.o0;
import com.mbridge.msdk.foundation.tools.y0;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;
import net.pubnative.lite.sdk.analytics.Reporting;

/* JADX INFO: compiled from: VideoReportDataDao.java */
/* JADX INFO: loaded from: classes11.dex */
public class n extends a<com.mbridge.msdk.foundation.entity.m> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final String f4927a = "com.mbridge.msdk.foundation.db.n";
    private static n b;

    private n(f fVar) {
        super(fVar);
    }

    public static n a(f fVar) {
        if (b == null) {
            synchronized (n.class) {
                if (b == null) {
                    b = new n(fVar);
                }
            }
        }
        return b;
    }

    /* JADX WARN: Code duplicated, block: B:31:0x0024 A[EXC_TOP_SPLITTER, PHI: r0 r1
  0x0024: PHI (r0v4 int) = (r0v0 int), (r0v6 int) binds: [B:15:0x0022, B:9:0x0019] A[DONT_GENERATE, DONT_INLINE]
  0x0024: PHI (r1v3 android.database.Cursor) = (r1v2 android.database.Cursor), (r1v4 android.database.Cursor) binds: [B:15:0x0022, B:9:0x0019] A[DONT_GENERATE, DONT_INLINE], SYNTHETIC] */
    public synchronized int a() {
        int i;
        i = 0;
        Cursor cursorRawQuery = null;
        try {
            try {
                cursorRawQuery = getReadableDatabase().rawQuery("select count(*) from reward_report", null);
                if (cursorRawQuery != null && cursorRawQuery.moveToFirst()) {
                    i = cursorRawQuery.getInt(0);
                }
                if (cursorRawQuery != null) {
                    try {
                        cursorRawQuery.close();
                    } catch (Exception unused) {
                    }
                }
            } catch (Throwable th) {
                if (cursorRawQuery != null) {
                    try {
                        cursorRawQuery.close();
                    } catch (Exception unused2) {
                    }
                }
                throw th;
            }
        } catch (Exception e) {
            e.printStackTrace();
            if (cursorRawQuery != null) {
                cursorRawQuery.close();
            }
        }
        return i;
    }

    /* JADX WARN: Code duplicated, block: B:115:0x0344 A[EXC_TOP_SPLITTER, PHI: r13
  0x0344: PHI (r13v3 android.database.Cursor) = (r13v2 android.database.Cursor), (r13v15 android.database.Cursor) binds: [B:98:0x0342, B:92:0x032f] A[DONT_GENERATE, DONT_INLINE], SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:117:0x034c A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:131:0x02d5 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:70:0x02db  */
    public synchronized List<com.mbridge.msdk.foundation.entity.m> a(String str) {
        Cursor cursor;
        Cursor cursorQuery;
        Cursor cursor2;
        com.mbridge.msdk.foundation.entity.m mVar;
        ArrayList arrayList;
        ArrayList arrayList2;
        Cursor cursor3;
        com.mbridge.msdk.foundation.entity.m mVar2;
        String str2 = str;
        synchronized (this) {
            if (!TextUtils.isEmpty(str)) {
                try {
                    cursorQuery = getReadableDatabase().query("reward_report", null, "key=?", new String[]{str2}, null, null, null);
                    if (cursorQuery != null) {
                        try {
                            if (cursorQuery.getCount() > 0) {
                                ArrayList arrayList3 = new ArrayList();
                                while (cursorQuery.moveToNext()) {
                                    String string = cursorQuery.getString(cursorQuery.getColumnIndex("key"));
                                    int i = cursorQuery.getInt(cursorQuery.getColumnIndex("networkType"));
                                    String string2 = cursorQuery.getString(cursorQuery.getColumnIndex("network_str"));
                                    cursorQuery.getInt(cursorQuery.getColumnIndex("isCompleteView"));
                                    cursorQuery.getInt(cursorQuery.getColumnIndex("watchedMillis"));
                                    int i2 = cursorQuery.getInt(cursorQuery.getColumnIndex("videoLength"));
                                    String string3 = cursorQuery.getString(cursorQuery.getColumnIndex("offerUrl"));
                                    String string4 = cursorQuery.getString(cursorQuery.getColumnIndex("reason"));
                                    int i3 = cursorQuery.getInt(cursorQuery.getColumnIndex("result"));
                                    String string5 = cursorQuery.getString(cursorQuery.getColumnIndex("duration"));
                                    int i4 = cursorQuery.getInt(cursorQuery.getColumnIndex("videoSize"));
                                    String string6 = cursorQuery.getString(cursorQuery.getColumnIndex("campaignId"));
                                    String string7 = cursorQuery.getString(cursorQuery.getColumnIndex("video_url"));
                                    String string8 = cursorQuery.getString(cursorQuery.getColumnIndex("unitId"));
                                    String string9 = cursorQuery.getString(cursorQuery.getColumnIndex(com.safedk.android.analytics.brandsafety.l.x));
                                    String string10 = cursorQuery.getString(cursorQuery.getColumnIndex("rid_n"));
                                    String string11 = cursorQuery.getString(cursorQuery.getColumnIndex("ad_type"));
                                    String string12 = cursorQuery.getString(cursorQuery.getColumnIndex("resource_type"));
                                    String string13 = cursorQuery.getString(cursorQuery.getColumnIndex("device_id"));
                                    String string14 = cursorQuery.getString(cursorQuery.getColumnIndex(Reporting.Key.CREATIVE));
                                    int i5 = cursorQuery.getInt(cursorQuery.getColumnIndex(CampaignEx.JSON_KEY_NEW_INTERSTITIAL_AD_SPACE_T));
                                    if (str2.equals("2000021")) {
                                        try {
                                            try {
                                                mVar = new com.mbridge.msdk.foundation.entity.m(string, i, string3, string4, string2);
                                                mVar.b(string6);
                                                mVar.v(string7);
                                                mVar.n(string9);
                                                mVar.o(string10);
                                                mVar.u(string8);
                                                cursor2 = cursorQuery;
                                                arrayList = arrayList3;
                                                if (mVar != null) {
                                                    try {
                                                        arrayList2 = arrayList;
                                                        arrayList2.add(mVar);
                                                    } catch (Exception e) {
                                                        e = e;
                                                        cursorQuery = cursor2;
                                                        e.printStackTrace();
                                                        o0.b(f4927a, e.getMessage());
                                                        if (cursorQuery != null) {
                                                            try {
                                                                cursorQuery.close();
                                                            } catch (Exception unused) {
                                                            }
                                                        }
                                                        return null;
                                                    } catch (Throwable th) {
                                                        th = th;
                                                        cursor = cursor2;
                                                        if (cursor != null) {
                                                            try {
                                                                cursor.close();
                                                            } catch (Exception unused2) {
                                                            }
                                                        }
                                                        throw th;
                                                    }
                                                } else {
                                                    arrayList2 = arrayList;
                                                }
                                                getWritableDatabase().delete("reward_report", "id = ?", new String[]{cursor2.getInt(cursor2.getColumnIndex("id")) + ""});
                                                arrayList3 = arrayList2;
                                                cursorQuery = cursor2;
                                            } catch (Throwable th2) {
                                                th = th2;
                                                cursor = cursorQuery;
                                                if (cursor != null) {
                                                    cursor.close();
                                                }
                                                throw th;
                                            }
                                        } catch (Exception e2) {
                                            e = e2;
                                            e.printStackTrace();
                                            o0.b(f4927a, e.getMessage());
                                            if (cursorQuery != null) {
                                                cursorQuery.close();
                                            }
                                            return null;
                                        }
                                    } else {
                                        if (str2.equals("2000022")) {
                                            arrayList = arrayList3;
                                            mVar = new com.mbridge.msdk.foundation.entity.m(string, i, i2, string3, i3, string5, i4, string2);
                                            mVar.b(string6);
                                            mVar.v(string7);
                                            mVar.n(string9);
                                            mVar.u(string8);
                                            mVar.m(string4);
                                            mVar.o(string10);
                                            mVar.a(string11);
                                        } else {
                                            arrayList = arrayList3;
                                            if (str2.equals("2000025")) {
                                                mVar = new com.mbridge.msdk.foundation.entity.m(string, i, i2, string3, i3, string5, i4, string2);
                                            } else if (str2.equals("2000024")) {
                                                mVar = new com.mbridge.msdk.foundation.entity.m(string, i, string3, string4, string2);
                                            } else {
                                                if ("2000039".equals(str2)) {
                                                    mVar = new com.mbridge.msdk.foundation.entity.m(cursorQuery.getString(cursorQuery.getColumnIndex("h5_click_data")));
                                                } else {
                                                    if ("2000043".equals(str2)) {
                                                        try {
                                                            cursor3 = cursorQuery;
                                                            mVar = mVar2;
                                                            try {
                                                                mVar2 = new com.mbridge.msdk.foundation.entity.m(str, i3, string5, cursorQuery.getString(cursorQuery.getColumnIndex(CampaignEx.ENDCARD_URL)), string6, string8, string4, cursorQuery.getString(cursorQuery.getColumnIndex("type")));
                                                                mVar.n(string9);
                                                                mVar.o(string10);
                                                                if (!TextUtils.isEmpty(string6)) {
                                                                    mVar.b(string6);
                                                                }
                                                                mVar.a(i5);
                                                                mVar.a(string11);
                                                                mVar.p(string12);
                                                                mVar.d(string13);
                                                                mVar.c(string14);
                                                                str2 = str;
                                                                cursor2 = cursor3;
                                                            } catch (Exception e3) {
                                                                e = e3;
                                                                cursorQuery = cursor3;
                                                            } catch (Throwable th3) {
                                                                th = th3;
                                                                cursor = cursor3;
                                                                if (cursor != null) {
                                                                    cursor.close();
                                                                }
                                                                throw th;
                                                            }
                                                        } catch (Exception e4) {
                                                            e = e4;
                                                        } catch (Throwable th4) {
                                                            th = th4;
                                                            cursor3 = cursorQuery;
                                                        }
                                                    } else {
                                                        Cursor cursor4 = cursorQuery;
                                                        try {
                                                            str2 = str;
                                                            if ("2000045".equals(str2)) {
                                                                mVar = new com.mbridge.msdk.foundation.entity.m();
                                                                mVar.j(str2);
                                                                mVar.c(i);
                                                                mVar.d(i3);
                                                                mVar.b(string6);
                                                                cursor2 = cursor4;
                                                                mVar.t(cursor2.getString(cursor2.getColumnIndex("template_url")));
                                                                mVar.m(string4);
                                                                mVar.n(string9);
                                                                mVar.o(string10);
                                                                mVar.u(string8);
                                                            } else {
                                                                cursor2 = cursor4;
                                                                if ("2000044".equals(str2)) {
                                                                    mVar = new com.mbridge.msdk.foundation.entity.m();
                                                                    mVar.j(str2);
                                                                    mVar.c(i);
                                                                    mVar.b(string6);
                                                                    mVar.i(cursor2.getString(cursor2.getColumnIndex("image_url")));
                                                                    mVar.m(string4);
                                                                    mVar.n(string9);
                                                                    mVar.o(string10);
                                                                    mVar.u(string8);
                                                                } else if ("2000054".equals(str2)) {
                                                                    mVar = new com.mbridge.msdk.foundation.entity.m();
                                                                    mVar.j(str2);
                                                                    mVar.p(string12);
                                                                    mVar.u(string8);
                                                                    mVar.d(string13);
                                                                    mVar.a(string11);
                                                                    mVar.b(string6);
                                                                    mVar.n(string9);
                                                                    mVar.o(string10);
                                                                    mVar.d(i3);
                                                                    mVar.m(string4);
                                                                    mVar.c(i);
                                                                    mVar.c(string14);
                                                                    mVar.a(i5);
                                                                } else {
                                                                    mVar = null;
                                                                }
                                                            }
                                                        } catch (Exception e5) {
                                                            e = e5;
                                                            cursor2 = cursor4;
                                                            cursorQuery = cursor2;
                                                            e.printStackTrace();
                                                            o0.b(f4927a, e.getMessage());
                                                            if (cursorQuery != null) {
                                                                cursorQuery.close();
                                                            }
                                                            return null;
                                                        } catch (Throwable th5) {
                                                            th = th5;
                                                            cursor2 = cursor4;
                                                            cursor = cursor2;
                                                            if (cursor != null) {
                                                                cursor.close();
                                                            }
                                                            throw th;
                                                        }
                                                    }
                                                    if (mVar != null) {
                                                        arrayList2 = arrayList;
                                                        arrayList2.add(mVar);
                                                    } else {
                                                        arrayList2 = arrayList;
                                                    }
                                                    getWritableDatabase().delete("reward_report", "id = ?", new String[]{cursor2.getInt(cursor2.getColumnIndex("id")) + ""});
                                                    arrayList3 = arrayList2;
                                                    cursorQuery = cursor2;
                                                }
                                                e.printStackTrace();
                                                o0.b(f4927a, e.getMessage());
                                                if (cursorQuery != null) {
                                                    cursorQuery.close();
                                                }
                                            }
                                        }
                                        cursor2 = cursorQuery;
                                        if (mVar != null) {
                                            arrayList2 = arrayList;
                                            arrayList2.add(mVar);
                                        } else {
                                            arrayList2 = arrayList;
                                        }
                                        getWritableDatabase().delete("reward_report", "id = ?", new String[]{cursor2.getInt(cursor2.getColumnIndex("id")) + ""});
                                        arrayList3 = arrayList2;
                                        cursorQuery = cursor2;
                                    }
                                }
                                ArrayList arrayList4 = arrayList3;
                                try {
                                    cursorQuery.close();
                                } catch (Exception unused3) {
                                }
                                return arrayList4;
                            }
                        } catch (Exception e6) {
                            e = e6;
                        } catch (Throwable th6) {
                            th = th6;
                            cursor2 = cursorQuery;
                        }
                    }
                    if (cursorQuery != null) {
                        cursorQuery = cursorQuery;
                        cursorQuery.close();
                    }
                } catch (Exception e7) {
                    e = e7;
                    cursorQuery = null;
                } catch (Throwable th7) {
                    th = th7;
                    cursor = null;
                }
            }
            return null;
        }
    }

    public synchronized long a(com.mbridge.msdk.foundation.entity.m mVar) {
        if (mVar != null) {
            try {
                ContentValues contentValues = new ContentValues();
                contentValues.put("key", mVar.n());
                contentValues.put("networkType", Integer.valueOf(mVar.q()));
                contentValues.put("network_str", mVar.r());
                contentValues.put("isCompleteView", Integer.valueOf(mVar.m()));
                contentValues.put("watchedMillis", Integer.valueOf(mVar.F()));
                contentValues.put("videoLength", Integer.valueOf(mVar.C()));
                if (!TextUtils.isEmpty(mVar.s())) {
                    contentValues.put("offerUrl", mVar.s());
                }
                if (!TextUtils.isEmpty(mVar.t())) {
                    contentValues.put("reason", URLEncoder.encode(mVar.t(), cc.N));
                }
                contentValues.put("result", Integer.valueOf(mVar.x()));
                contentValues.put("duration", mVar.g());
                contentValues.put("videoSize", Long.valueOf(mVar.D()));
                contentValues.put("type", mVar.h());
                String strI = mVar.i();
                if (!TextUtils.isEmpty(strI)) {
                    contentValues.put(CampaignEx.ENDCARD_URL, strI);
                }
                String strE = mVar.E();
                if (!TextUtils.isEmpty(strE)) {
                    contentValues.put("video_url", strE);
                }
                String strU = mVar.u();
                if (!TextUtils.isEmpty(strU)) {
                    contentValues.put(com.safedk.android.analytics.brandsafety.l.x, strU);
                }
                String strV = mVar.v();
                if (!TextUtils.isEmpty(strV)) {
                    contentValues.put("rid_n", strV);
                }
                String strZ = mVar.z();
                if (!TextUtils.isEmpty(strZ)) {
                    contentValues.put("template_url", strZ);
                }
                String strL = mVar.l();
                if (!TextUtils.isEmpty(strL)) {
                    contentValues.put("image_url", strL);
                }
                String strA = mVar.a();
                if (!TextUtils.isEmpty(strA)) {
                    contentValues.put("ad_type", URLEncoder.encode(strA, cc.N));
                }
                contentValues.put("unitId", mVar.B());
                contentValues.put("campaignId", mVar.d());
                if ("2000039".equals(mVar.n())) {
                    String strB = o.b(mVar);
                    if (y0.b(strB)) {
                        contentValues.put("h5_click_data", strB);
                    }
                }
                String strW = mVar.w();
                if (!TextUtils.isEmpty(strW)) {
                    contentValues.put("resource_type", URLEncoder.encode(strW, cc.N));
                }
                String strF = mVar.f();
                if (!TextUtils.isEmpty(strF)) {
                    contentValues.put("device_id", URLEncoder.encode(strF, cc.N));
                }
                String strE2 = mVar.e();
                if (!TextUtils.isEmpty(strE2)) {
                    contentValues.put(Reporting.Key.CREATIVE, URLEncoder.encode(strE2, cc.N));
                }
                contentValues.put(CampaignEx.JSON_KEY_NEW_INTERSTITIAL_AD_SPACE_T, Integer.valueOf(mVar.b()));
                return getWritableDatabase().insert("reward_report", null, contentValues);
            } catch (Exception e) {
                o0.b(f4927a, e.getMessage());
                return -1L;
            }
        }
        return -1L;
    }
}
