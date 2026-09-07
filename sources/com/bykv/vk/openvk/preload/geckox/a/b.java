package com.bykv.vk.openvk.preload.geckox.a;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import com.bykv.vk.openvk.preload.geckox.logger.GeckoLogger;
import com.bykv.vk.openvk.preload.geckox.statistic.model.StatisticModel;
import com.bykv.vk.openvk.preload.geckox.utils.CloseableUtils;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: AbandonChannelSQLiteHelper.java */
/* JADX INFO: loaded from: classes12.dex */
class b extends SQLiteOpenHelper {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static volatile b f916a;

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
    }

    private b(Context context, String str) {
        super(context, str, (SQLiteDatabase.CursorFactory) null, 1);
    }

    public static b a(Context context) {
        if (f916a == null) {
            synchronized (b.class) {
                if (f916a == null) {
                    f916a = new b(context.getApplicationContext(), "geckox_clean_statistic" + com.bykv.vk.openvk.preload.geckox.utils.a.c(context) + ".db");
                }
            }
        }
        return f916a;
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onCreate(SQLiteDatabase sQLiteDatabase) {
        sQLiteDatabase.execSQL("create table if not exists geckox_clean_statistic (id integer primary key autoincrement,access_key text,channel text,clean_type integer,status integer,pkg_id integer,err_code integer,clean_strategy integer,clean_duration integer,err_msg text)");
    }

    final void a(int i, int i2, String str, long j) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("access_key", (String) null);
        contentValues.put("channel", (String) null);
        contentValues.put("clean_type", (Integer) 0);
        contentValues.put("status", Integer.valueOf(i));
        contentValues.put("pkg_id", (Long) 0L);
        contentValues.put("err_code", Integer.valueOf(i2));
        contentValues.put("err_msg", str);
        contentValues.put("clean_duration", Long.valueOf(j));
        contentValues.put("clean_strategy", (Integer) 1);
        try {
            getWritableDatabase().insert("geckox_clean_statistic", null, contentValues);
        } catch (Exception e) {
            GeckoLogger.w("clean-channel", "insert failed", e);
        }
    }

    final List<StatisticModel.PackageStatisticModel> a() {
        ArrayList arrayList = new ArrayList();
        Cursor cursor = null;
        try {
            Cursor cursorQuery = getWritableDatabase().query("geckox_clean_statistic", null, null, null, null, null, null);
            if (cursorQuery == null) {
                return arrayList;
            }
            while (cursorQuery.moveToNext()) {
                try {
                    String string = cursorQuery.getString(cursorQuery.getColumnIndex("access_key"));
                    String string2 = cursorQuery.getString(cursorQuery.getColumnIndex("channel"));
                    int i = cursorQuery.getInt(cursorQuery.getColumnIndex("clean_type"));
                    int i2 = cursorQuery.getInt(cursorQuery.getColumnIndex("status"));
                    long j = cursorQuery.getInt(cursorQuery.getColumnIndex("pkg_id"));
                    int i3 = cursorQuery.getInt(cursorQuery.getColumnIndex("err_code"));
                    String string3 = cursorQuery.getString(cursorQuery.getColumnIndex("err_msg"));
                    int i4 = cursorQuery.getInt(cursorQuery.getColumnIndex("clean_strategy"));
                    long j2 = cursorQuery.getLong(cursorQuery.getColumnIndex("clean_duration"));
                    StatisticModel.PackageStatisticModel packageStatisticModel = new StatisticModel.PackageStatisticModel();
                    packageStatisticModel.accessKey = string;
                    packageStatisticModel.channel = string2;
                    packageStatisticModel.statsType = Integer.valueOf(i2);
                    packageStatisticModel.id = Long.valueOf(j);
                    packageStatisticModel.errCode = i3 == 0 ? null : String.valueOf(i3);
                    packageStatisticModel.errMsg = string3;
                    packageStatisticModel.cleanType = Integer.valueOf(i);
                    packageStatisticModel.cleanDuration = Long.valueOf(j2);
                    packageStatisticModel.cleanStrategy = Integer.valueOf(i4);
                    arrayList.add(packageStatisticModel);
                } catch (Exception e) {
                    e = e;
                    cursor = cursorQuery;
                    GeckoLogger.w("clean-channel", "get all statistic failed!", e);
                    cursorQuery = cursor;
                }
            }
            getWritableDatabase().delete("geckox_clean_statistic", null, null);
            CloseableUtils.close(cursorQuery);
            return arrayList;
        } catch (Exception e2) {
            e = e2;
        }
    }
}
