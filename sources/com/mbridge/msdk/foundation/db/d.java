package com.mbridge.msdk.foundation.db;

import android.content.ContentValues;
import android.database.Cursor;
import android.text.TextUtils;
import com.mbridge.msdk.MBridgeConstans;
import com.mbridge.msdk.click.entity.JumpLoaderResult;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.foundation.tools.o0;
import com.mbridge.msdk.foundation.tools.u0;

/* JADX INFO: compiled from: CampaignClickDao.java */
/* JADX INFO: loaded from: classes11.dex */
public class d extends a<JumpLoaderResult> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final String f4912a = "d";
    private static d b;

    private d(f fVar) {
        super(fVar);
    }

    public static synchronized d a(f fVar) {
        if (b == null) {
            b = new d(fVar);
        }
        return b;
    }

    /* JADX WARN: Code duplicated, block: B:28:0x005d A[Catch: all -> 0x006a, PHI: r11
  0x005d: PHI (r11v4 android.database.Cursor) = (r11v3 android.database.Cursor), (r11v6 android.database.Cursor) binds: [B:27:0x005b, B:18:0x0047] A[DONT_GENERATE, DONT_INLINE], TRY_ENTER, TRY_LEAVE, TryCatch #2 {all -> 0x006a, blocks: (B:13:0x0040, B:28:0x005d, B:34:0x0066, B:35:0x0069), top: B:40:0x0002 }] */
    /* JADX WARN: Code duplicated, block: B:34:0x0066 A[Catch: all -> 0x006a, TRY_ENTER, TryCatch #2 {all -> 0x006a, blocks: (B:13:0x0040, B:28:0x005d, B:34:0x0066, B:35:0x0069), top: B:40:0x0002 }] */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v0 */
    /* JADX WARN: Type inference failed for: r0v1, types: [android.database.Cursor] */
    /* JADX WARN: Type inference failed for: r0v2 */
    public synchronized JumpLoaderResult b(String str, String str2) {
        Cursor cursorQuery;
        ?? r0 = 0;
        try {
            try {
                try {
                    cursorQuery = getReadableDatabase().query("campaignclick", null, "id=? AND unitid=?", new String[]{str, str2}, null, null, null, null);
                    if (cursorQuery != null) {
                        try {
                            if (cursorQuery.getCount() > 0 && cursorQuery.moveToFirst()) {
                                String string = cursorQuery.getString(cursorQuery.getColumnIndex("result"));
                                if (!TextUtils.isEmpty(string)) {
                                    JumpLoaderResult jumpLoaderResult = (JumpLoaderResult) u0.a(string);
                                    cursorQuery.close();
                                    return jumpLoaderResult;
                                }
                            }
                        } catch (Exception e) {
                            e = e;
                            if (MBridgeConstans.DEBUG) {
                                o0.b(f4912a, e.getMessage());
                            }
                            if (cursorQuery != null) {
                                cursorQuery.close();
                            }
                        }
                    }
                    if (cursorQuery != null) {
                        cursorQuery.close();
                    }
                } catch (Exception e2) {
                    e = e2;
                    cursorQuery = null;
                } catch (Throwable th) {
                    th = th;
                    if (r0 != 0) {
                        r0.close();
                    }
                    throw th;
                }
                return null;
            } catch (Throwable th2) {
                th = th2;
                r0 = str;
                if (r0 != 0) {
                    r0.close();
                }
                throw th;
            }
        } catch (Throwable th3) {
            throw th3;
        }
    }

    public synchronized boolean c(String str, String str2) {
        try {
            Cursor cursorRawQuery = getReadableDatabase().rawQuery("SELECT id FROM campaignclick WHERE id= ? AND unitid= ? AND cti + ts > " + System.currentTimeMillis(), new String[]{str, str2});
            if (cursorRawQuery != null && cursorRawQuery.getCount() > 0) {
                cursorRawQuery.close();
                return true;
            }
            if (cursorRawQuery != null) {
                cursorRawQuery.close();
            }
            return false;
        } catch (Exception e) {
            if (MBridgeConstans.DEBUG) {
                o0.b(f4912a, e.getMessage());
            }
            return false;
        }
    }

    public synchronized void a() {
        try {
            getWritableDatabase().delete("campaignclick", " ( " + System.currentTimeMillis() + " - ts) > cti", null);
        } catch (Exception e) {
            if (MBridgeConstans.DEBUG) {
                o0.b(f4912a, e.getMessage());
            }
        }
    }

    public synchronized long a(CampaignEx campaignEx, String str) {
        if (campaignEx == null) {
            return 0L;
        }
        try {
            String strA = u0.a(campaignEx.getJumpResult());
            ContentValues contentValues = new ContentValues();
            contentValues.put("id", campaignEx.getId());
            contentValues.put("unitid", str);
            contentValues.put("result", strA);
            contentValues.put("cti", Integer.valueOf(campaignEx.getClickInterval() * 1000));
            contentValues.put("package_name", campaignEx.getPackageName());
            com.mbridge.msdk.setting.g gVarD = com.mbridge.msdk.setting.h.b().d(com.mbridge.msdk.foundation.controller.c.m().b());
            contentValues.put("ts", Long.valueOf(System.currentTimeMillis()));
            if (gVarD != null && gVarD.X() > 0) {
                contentValues.put("cpei", Integer.valueOf(gVarD.X() * 1000));
            }
            if (gVarD != null && gVarD.Y() > 0) {
                contentValues.put("cpoci", Integer.valueOf(gVarD.Y() * 1000));
            }
            if (a(campaignEx.getId(), str)) {
                if (getWritableDatabase() == null) {
                    return -1L;
                }
                return getWritableDatabase().update("campaignclick", contentValues, "id = ? AND unitid = ? ", new String[]{campaignEx.getId(), str});
            }
            return getWritableDatabase().insert("campaignclick", null, contentValues);
        } catch (Exception e) {
            if (MBridgeConstans.DEBUG) {
                o0.b(f4912a, e.getMessage());
            }
            return -1L;
        }
    }

    public synchronized boolean a(String str, String str2) {
        Cursor cursorRawQuery = getReadableDatabase().rawQuery("SELECT id FROM campaignclick WHERE id= ? AND unitid= ?", new String[]{str, str2});
        if (cursorRawQuery != null && cursorRawQuery.getCount() > 0) {
            cursorRawQuery.close();
            return true;
        }
        if (cursorRawQuery != null) {
            cursorRawQuery.close();
        }
        return false;
    }
}
