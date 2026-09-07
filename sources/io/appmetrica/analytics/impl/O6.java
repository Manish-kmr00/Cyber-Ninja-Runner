package io.appmetrica.analytics.impl;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.DatabaseUtils;
import android.database.sqlite.SQLiteDatabase;
import android.os.ResultReceiver;
import io.appmetrica.analytics.coreutils.internal.logger.LoggerStorage;
import io.appmetrica.analytics.internal.CounterConfiguration;
import io.appmetrica.analytics.internal.CounterConfigurationReporterType;
import io.appmetrica.analytics.logger.appmetrica.internal.PublicLogger;
import java.util.ArrayList;
import java.util.Map;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public final class O6 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final CounterConfigurationReporterType f11279a;
    public final C4047cj b;

    public O6(CounterConfigurationReporterType counterConfigurationReporterType) {
        this(counterConfigurationReporterType, C4486ua.j().v());
    }

    /* JADX WARN: Code duplicated, block: B:14:0x003e  */
    public final M6 a(SQLiteDatabase sQLiteDatabase, String str, int i, String str2, boolean z) {
        Cursor cursorRawQuery;
        ArrayList<ContentValues> arrayList;
        int iDelete;
        C4047cj c4047cj;
        C3997aj c3997aj;
        C4082e4 c4082e4;
        Integer num;
        try {
            cursorRawQuery = sQLiteDatabase.rawQuery(String.format("SELECT %s, %s, %s FROM %s WHERE %s", "global_number", "type", "event_description", "events", str), null);
            if (cursorRawQuery != null) {
                try {
                    if (cursorRawQuery.getCount() > 0) {
                        arrayList = new ArrayList(cursorRawQuery.getCount());
                        while (cursorRawQuery.moveToNext()) {
                            ContentValues contentValues = new ContentValues();
                            DatabaseUtils.cursorRowToContentValues(cursorRawQuery, contentValues);
                            arrayList.add(contentValues);
                        }
                    } else {
                        arrayList = null;
                    }
                } catch (Throwable th) {
                    th = th;
                    try {
                        Fj fj = AbstractC4097ej.f11536a;
                        fj.getClass();
                        fj.a(new C4122fj("select_rows_to_delete_exception", th));
                        In.a(cursorRawQuery);
                        arrayList = null;
                    } catch (Throwable th2) {
                        In.a(cursorRawQuery);
                        throw th2;
                    }
                }
            } else {
                arrayList = null;
            }
            In.a(cursorRawQuery);
        } catch (Throwable th3) {
            th = th3;
            cursorRawQuery = null;
        }
        try {
            iDelete = sQLiteDatabase.delete("events", str, null);
        } catch (Throwable unused) {
            iDelete = 0;
        }
        if (arrayList != null && arrayList.size() != 0 && iDelete == arrayList.size() && z && str2 != null && (c4047cj = this.b) != null) {
            CounterConfigurationReporterType counterConfigurationReporterType = this.f11279a;
            synchronized (c4047cj) {
                c3997aj = (C3997aj) c4047cj.c.get(str2);
                if (c3997aj == null) {
                    c3997aj = new C3997aj(str2, c4047cj.b, counterConfigurationReporterType, c4047cj.f11497a);
                    c4047cj.c.put(str2, c3997aj);
                }
            }
            try {
                JSONObject jSONObject = new JSONObject();
                JSONArray jSONArray = new JSONArray();
                JSONArray jSONArray2 = new JSONArray();
                for (ContentValues contentValues2 : arrayList) {
                    Integer asInteger = contentValues2.getAsInteger("global_number");
                    Integer asInteger2 = contentValues2.getAsInteger("type");
                    if (asInteger != null && asInteger2 != null) {
                        jSONArray.put(asInteger);
                        EnumC4164hb enumC4164hbA = EnumC4164hb.a(asInteger2.intValue());
                        if (enumC4164hbA == null) {
                            Map map = Cf.f11090a;
                            num = null;
                        } else {
                            num = (Integer) Cf.c.get(enumC4164hbA);
                        }
                        jSONArray2.put(num);
                    }
                }
                jSONObject.put("global_number", jSONArray).put("event_type", jSONArray2);
                JSONObject jSONObjectPut = new JSONObject().put("details", new JSONObject().put("reason", N6.a(i)).put("cleared", jSONObject).put("actual_deleted_number", iDelete));
                PublicLogger orCreatePublicLogger = LoggerStorage.getOrCreatePublicLogger(str2);
                String string = jSONObjectPut.toString();
                Set set = C9.f11086a;
                EnumC4164hb enumC4164hb = EnumC4164hb.EVENT_TYPE_UNDEFINED;
                c4082e4 = new C4082e4(string, "", 12290, 0, orCreatePublicLogger);
            } catch (Throwable unused2) {
                c4082e4 = null;
            }
            if (c4082e4 != null && c3997aj.c != null) {
                try {
                    CounterConfiguration counterConfiguration = new CounterConfiguration(c3997aj.f11466a);
                    counterConfiguration.setReporterType(c3997aj.c);
                    c3997aj.d.f11518a.reportData(1, c4082e4.d(new C4568xh(new C4367pf(c3997aj.b, (ResultReceiver) null), counterConfiguration, null).c()));
                } catch (Throwable unused3) {
                }
            }
        }
        return new M6(arrayList, iDelete);
    }

    public O6(CounterConfigurationReporterType counterConfigurationReporterType, C4047cj c4047cj) {
        this.f11279a = counterConfigurationReporterType;
        this.b = c4047cj;
    }
}
