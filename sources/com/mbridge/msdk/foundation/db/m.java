package com.mbridge.msdk.foundation.db;

import android.content.ContentValues;
import android.database.Cursor;
import android.text.TextUtils;
import com.facebook.internal.NativeProtocol;
import com.mbridge.msdk.MBridgeConstans;
import com.mbridge.msdk.foundation.download.database.DownloadModel;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.foundation.tools.o0;
import com.mbridge.msdk.out.Campaign;

/* JADX INFO: compiled from: VideoDao.java */
/* JADX INFO: loaded from: classes11.dex */
public class m extends a<Campaign> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static m f4922a;

    private m(f fVar) {
        super(fVar);
    }

    public static synchronized m a(f fVar) {
        if (f4922a == null) {
            f4922a = new m(fVar);
        }
        return f4922a;
    }

    /* JADX WARN: Code duplicated, block: B:37:0x00a6 A[Catch: all -> 0x00c6, TRY_LEAVE, TryCatch #3 {all -> 0x00c6, blocks: (B:10:0x001c, B:12:0x0022, B:13:0x0027, B:15:0x002d, B:35:0x00a2, B:37:0x00a6), top: B:65:0x0006 }] */
    /* JADX WARN: Code duplicated, block: B:66:0x00b1 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v0 */
    /* JADX WARN: Type inference failed for: r1v1 */
    /* JADX WARN: Type inference failed for: r1v2, types: [android.database.Cursor] */
    public synchronized com.mbridge.msdk.foundation.entity.l b(String str) {
        Exception e;
        Cursor cursorRawQuery;
        Exception e2;
        com.mbridge.msdk.foundation.entity.l lVar;
        ?? r1 = 0;
        lVar = null;
        com.mbridge.msdk.foundation.entity.l lVar2 = null;
        try {
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            try {
                cursorRawQuery = getReadableDatabase().rawQuery("SELECT * FROM video WHERE video_url = ? ", new String[]{str});
                if (cursorRawQuery != null) {
                    try {
                        if (cursorRawQuery.getCount() > 0) {
                            lVar = new com.mbridge.msdk.foundation.entity.l();
                            while (cursorRawQuery.moveToNext()) {
                                try {
                                    lVar.b(cursorRawQuery.getString(cursorRawQuery.getColumnIndex("video_url")));
                                    lVar.a(cursorRawQuery.getInt(cursorRawQuery.getColumnIndex("video_state")));
                                    lVar.b(cursorRawQuery.getLong(cursorRawQuery.getColumnIndex("pregeress_size")));
                                    lVar.b(cursorRawQuery.getInt(cursorRawQuery.getColumnIndex("total_size")));
                                    lVar.a(cursorRawQuery.getString(cursorRawQuery.getColumnIndex("video_path")));
                                    lVar.a(cursorRawQuery.getLong(cursorRawQuery.getColumnIndex("video_download_start")) * 1000);
                                } catch (Exception e3) {
                                    e2 = e3;
                                    if (MBridgeConstans.DEBUG) {
                                        o0.b("VideoDao", e2.getLocalizedMessage());
                                    }
                                    if (cursorRawQuery != null) {
                                        try {
                                            cursorRawQuery.close();
                                        } catch (Exception e4) {
                                            if (MBridgeConstans.DEBUG) {
                                                o0.b("VideoDao", e4.getLocalizedMessage());
                                            }
                                        }
                                    }
                                    lVar2 = lVar;
                                }
                            }
                            lVar2 = lVar;
                        }
                    } catch (Exception e5) {
                        e = e5;
                        e2 = e;
                        lVar = null;
                        if (MBridgeConstans.DEBUG) {
                            o0.b("VideoDao", e2.getLocalizedMessage());
                        }
                        if (cursorRawQuery != null) {
                            cursorRawQuery.close();
                        }
                        lVar2 = lVar;
                        return lVar2;
                    }
                }
                if (cursorRawQuery != null) {
                    try {
                        cursorRawQuery.close();
                    } catch (Exception e6) {
                        if (MBridgeConstans.DEBUG) {
                            o0.b("VideoDao", e6.getLocalizedMessage());
                        }
                    }
                }
            } catch (Exception e7) {
                e = e7;
                cursorRawQuery = null;
            } catch (Throwable th) {
                th = th;
                if (r1 != 0) {
                    try {
                        r1.close();
                    } catch (Exception e8) {
                        if (MBridgeConstans.DEBUG) {
                            o0.b("VideoDao", e8.getLocalizedMessage());
                        }
                    }
                }
                throw th;
            }
            return lVar2;
        } catch (Throwable th2) {
            th = th2;
            r1 = str;
        }
    }

    public synchronized void a(String str) {
        try {
            String[] strArr = {str};
            if (getWritableDatabase() == null) {
            } else {
                getWritableDatabase().delete("video", "video_url = ? ", strArr);
            }
        } catch (Exception e) {
            if (MBridgeConstans.DEBUG) {
                o0.b("VideoDao", e.getLocalizedMessage());
            }
        }
    }

    public synchronized void a(String str, long j) {
        if (j == 0) {
            return;
        }
        try {
            ContentValues contentValues = new ContentValues();
            contentValues.put("video_download_start", Long.valueOf(j / 1000));
            if (a(str, "")) {
                getWritableDatabase().update("video", contentValues, "video_url = ? ", new String[]{str});
            }
        } catch (Exception e) {
            if (MBridgeConstans.DEBUG) {
                o0.b("VideoDao", e.getLocalizedMessage());
            }
        }
    }

    public synchronized long a(CampaignEx campaignEx, long j, String str, int i) {
        if (campaignEx == null) {
            return 0L;
        }
        try {
            if (getWritableDatabase() == null) {
                return -1L;
            }
            ContentValues contentValues = new ContentValues();
            contentValues.put("unitid", campaignEx.getCampaignUnitId());
            contentValues.put("id", campaignEx.getId());
            contentValues.put("package_name", campaignEx.getPackageName());
            contentValues.put(NativeProtocol.BRIDGE_ARG_APP_NAME_STRING, campaignEx.getAppName());
            contentValues.put("app_desc", campaignEx.getAppDesc());
            contentValues.put(CampaignEx.JSON_KEY_APP_SIZE, campaignEx.getSize());
            contentValues.put(CampaignEx.JSON_KEY_IMAGE_SIZE, campaignEx.getImageSize());
            contentValues.put(CampaignEx.JSON_KEY_ICON_URL, campaignEx.getIconUrl());
            contentValues.put("image_url", campaignEx.getImageUrl());
            contentValues.put(CampaignEx.JSON_KEY_IMPRESSION_URL, campaignEx.getImpressionURL());
            contentValues.put(CampaignEx.JSON_KEY_NOTICE_URL, campaignEx.getNoticeUrl());
            contentValues.put(DownloadModel.DOWNLOAD_URL, campaignEx.getClickURL());
            contentValues.put("only_impression", campaignEx.getOnlyImpressionURL());
            contentValues.put("ts", Long.valueOf(campaignEx.getTimestamp()));
            contentValues.put("template", Integer.valueOf(campaignEx.getTemplate()));
            contentValues.put(CampaignEx.JSON_KEY_CLICK_MODE, campaignEx.getClick_mode());
            contentValues.put(CampaignEx.JSON_KEY_LANDING_TYPE, campaignEx.getLandingType());
            contentValues.put(CampaignEx.JSON_KEY_LINK_TYPE, Integer.valueOf(campaignEx.getLinkType()));
            contentValues.put("star", Double.valueOf(campaignEx.getRating()));
            contentValues.put("cti", Integer.valueOf(campaignEx.getClickInterval()));
            contentValues.put("level", Integer.valueOf(campaignEx.getCacheLevel()));
            contentValues.put("adSource", Integer.valueOf(campaignEx.getType()));
            contentValues.put("ad_call", campaignEx.getAdCall());
            contentValues.put("fc_a", Integer.valueOf(campaignEx.getFca()));
            contentValues.put(CampaignEx.JSON_KEY_AD_URL_LIST, campaignEx.getAd_url_list());
            contentValues.put("video_url", campaignEx.getVideoUrlEncode());
            contentValues.put("total_size", Long.valueOf(j));
            contentValues.put("video_state", Integer.valueOf(i));
            contentValues.put("video_download_start", Long.valueOf(System.currentTimeMillis() / 1000));
            contentValues.put("ad_bid_token", campaignEx.getBidToken());
            if (!TextUtils.isEmpty(str)) {
                contentValues.put("video_path", str);
            }
            if (a(campaignEx.getVideoUrlEncode(), campaignEx.getId())) {
                return 0L;
            }
            return getWritableDatabase().insert("video", null, contentValues);
        } catch (Exception e) {
            if (MBridgeConstans.DEBUG) {
                o0.b("VideoDao", e.getLocalizedMessage());
            }
            return -1L;
        }
    }

    /* JADX WARN: Code duplicated, block: B:40:0x0094 A[EXC_TOP_SPLITTER, PHI: r0
  0x0094: PHI (r0v3 android.database.Cursor) = (r0v1 android.database.Cursor), (r0v4 android.database.Cursor) binds: [B:25:0x0092, B:17:0x007f] A[DONT_GENERATE, DONT_INLINE], SYNTHETIC] */
    public synchronized com.mbridge.msdk.foundation.entity.l b(String str, String str2) {
        Cursor cursorRawQuery = null;
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        com.mbridge.msdk.foundation.entity.l lVar = new com.mbridge.msdk.foundation.entity.l();
        try {
            try {
                cursorRawQuery = getReadableDatabase().rawQuery("SELECT * FROM video WHERE video_url = ? ", new String[]{str});
                if (cursorRawQuery != null && cursorRawQuery.getCount() > 0) {
                    while (cursorRawQuery.moveToNext()) {
                        lVar.b(cursorRawQuery.getString(cursorRawQuery.getColumnIndex("video_url")));
                        lVar.a(cursorRawQuery.getInt(cursorRawQuery.getColumnIndex("video_state")));
                        lVar.b(cursorRawQuery.getLong(cursorRawQuery.getColumnIndex("pregeress_size")));
                        lVar.b(cursorRawQuery.getInt(cursorRawQuery.getColumnIndex("total_size")));
                        lVar.a(cursorRawQuery.getString(cursorRawQuery.getColumnIndex("video_path")));
                        lVar.a(cursorRawQuery.getLong(cursorRawQuery.getColumnIndex("video_download_start")) * 1000);
                    }
                }
                if (cursorRawQuery != null) {
                    try {
                        cursorRawQuery.close();
                    } catch (Exception unused) {
                    }
                }
            } catch (Exception e) {
                if (MBridgeConstans.DEBUG) {
                    o0.b("VideoDao", e.getLocalizedMessage());
                }
                if (cursorRawQuery != null) {
                    cursorRawQuery.close();
                }
            }
            return lVar;
        } catch (Throwable th) {
            if (cursorRawQuery != null) {
                try {
                    cursorRawQuery.close();
                } catch (Exception unused2) {
                }
            }
            throw th;
        }
    }

    public synchronized boolean a(String str, String str2) {
        String str3;
        String[] strArr;
        try {
            if (TextUtils.isEmpty(str2)) {
                str3 = "SELECT id FROM video WHERE video_url = ? ";
                strArr = new String[]{str};
            } else {
                String[] strArr2 = {str, str2};
                str3 = "SELECT id FROM video WHERE video_url = ? AND id = ? ";
                strArr = strArr2;
            }
            Cursor cursorRawQuery = getReadableDatabase().rawQuery(str3, strArr);
            if (cursorRawQuery != null && cursorRawQuery.getCount() > 0) {
                try {
                    cursorRawQuery.close();
                } catch (Exception e) {
                    if (MBridgeConstans.DEBUG) {
                        o0.b("VideoDao", e.getLocalizedMessage());
                    }
                }
                return true;
            }
            if (cursorRawQuery != null) {
                try {
                    cursorRawQuery.close();
                } catch (Exception e2) {
                    if (MBridgeConstans.DEBUG) {
                        o0.b("VideoDao", e2.getLocalizedMessage());
                    }
                }
            }
            return false;
        } catch (Throwable th) {
            throw th;
        }
        throw th;
    }

    public synchronized long b(String str, long j) {
        int iUpdate = -1;
        try {
            if (getWritableDatabase() == null) {
                return -1;
            }
            ContentValues contentValues = new ContentValues();
            contentValues.put("total_size", Long.valueOf(j));
            if (a(str, "")) {
                String[] strArr = {str};
                synchronized (new Object()) {
                    iUpdate = getWritableDatabase().update("video", contentValues, "video_url = ? ", strArr);
                }
            }
        } catch (Exception e) {
            if (MBridgeConstans.DEBUG) {
                o0.b("VideoDao", e.getLocalizedMessage());
            }
        }
        return iUpdate;
    }

    public synchronized long a(String str, long j, int i) {
        int iUpdate = -1;
        try {
            if (getWritableDatabase() == null) {
                return -1;
            }
            ContentValues contentValues = new ContentValues();
            contentValues.put("pregeress_size", Long.valueOf(j));
            contentValues.put("video_state", Integer.valueOf(i));
            if (a(str, "")) {
                String[] strArr = {str};
                synchronized (new Object()) {
                    iUpdate = getWritableDatabase().update("video", contentValues, "video_url = ? ", strArr);
                }
            }
        } catch (Exception e) {
            if (MBridgeConstans.DEBUG) {
                o0.b("VideoDao", e.getLocalizedMessage());
            }
        }
        return iUpdate;
    }
}
