package com.apm.insight.e.a;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import com.apm.insight.c;
import com.apm.insight.runtime.k;
import io.appmetrica.analytics.coreutils.internal.StringUtils;
import java.util.HashMap;
import net.pubnative.lite.sdk.db.DatabaseHelper;

/* JADX INFO: compiled from: AbsDAO.java */
/* JADX INFO: loaded from: classes12.dex */
public abstract class a<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    protected final String f195a;
    private String b = DatabaseHelper._ID;

    protected abstract ContentValues a(T t);

    protected abstract HashMap<String, String> a();

    protected a(String str) {
        this.f195a = str;
    }

    public final void a(SQLiteDatabase sQLiteDatabase) {
        try {
            StringBuilder sb = new StringBuilder();
            sb.append("CREATE TABLE ").append(this.f195a).append(" (_id INTEGER PRIMARY KEY AUTOINCREMENT, ");
            HashMap<String, String> mapA = a();
            for (String str : mapA.keySet()) {
                sb.append(str).append(" ").append(mapA.get(str)).append(StringUtils.COMMA);
            }
            sb.delete(sb.length() - 1, sb.length());
            sb.append(")");
            sQLiteDatabase.execSQL(sb.toString());
        } catch (Throwable th) {
            c.a();
            k.a(th, "NPTH_CATCH");
        }
    }

    public void a(SQLiteDatabase sQLiteDatabase, T t) {
        if (sQLiteDatabase == null || t == null) {
            return;
        }
        try {
            sQLiteDatabase.insert(this.f195a, null, a(t));
        } catch (Throwable th) {
            com.apm.insight.a.b(th);
        }
    }
}
