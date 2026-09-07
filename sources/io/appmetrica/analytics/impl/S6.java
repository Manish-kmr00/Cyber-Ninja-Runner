package io.appmetrica.analytics.impl;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.DatabaseUtils;
import android.database.sqlite.SQLiteDatabase;
import android.text.TextUtils;
import com.facebook.gamingservices.cloudgaming.internal.SDKAnalyticsEvents;
import com.google.firebase.remoteconfig.RemoteConfigConstants;
import io.appmetrica.analytics.coreutils.internal.db.DBUtils;
import io.appmetrica.analytics.logger.appmetrica.internal.PublicLogger;
import io.appmetrica.analytics.networktasks.internal.CommonUrlParts;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes4.dex */
public final class S6 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ReentrantReadWriteLock.ReadLock f11344a;
    public final ReentrantReadWriteLock.WriteLock b;
    public final C4110f7 c;
    public final R6 d;
    public final Object e;
    public final ArrayList f;
    public final Context g;
    public final C4282m5 h;
    public final AtomicLong i;
    public final ArrayList j;
    public final O6 k;
    public final C4309n7 l;

    static {
        HashSet hashSet = new HashSet();
        EnumC4164hb enumC4164hb = EnumC4164hb.EVENT_TYPE_UNDEFINED;
        hashSet.add(0);
        hashSet.add(6400);
    }

    public S6(C4282m5 c4282m5, C4110f7 c4110f7, O6 o6, C4309n7 c4309n7) {
        ReentrantReadWriteLock reentrantReadWriteLock = new ReentrantReadWriteLock();
        this.f11344a = reentrantReadWriteLock.readLock();
        this.b = reentrantReadWriteLock.writeLock();
        this.e = new Object();
        this.f = new ArrayList(3);
        AtomicLong atomicLong = new AtomicLong();
        this.i = atomicLong;
        this.j = new ArrayList();
        this.c = c4110f7;
        this.g = c4282m5.getContext();
        this.h = c4282m5;
        this.k = o6;
        this.l = c4309n7;
        atomicLong.set(b());
        R6 r6 = new R6(this, c4282m5);
        this.d = r6;
        r6.setName(a(c4282m5));
    }

    public final long a() {
        this.f11344a.lock();
        try {
            return this.i.get();
        } finally {
            this.f11344a.unlock();
        }
    }

    public final long b() {
        long jQueryRowsCount;
        this.f11344a.lock();
        try {
            SQLiteDatabase readableDatabase = this.c.getReadableDatabase();
            jQueryRowsCount = readableDatabase != null ? DBUtils.queryRowsCount(readableDatabase, "events") : 0L;
        } catch (Throwable unused) {
        }
        this.f11344a.unlock();
        return jQueryRowsCount;
    }

    public final void c() {
        Cursor cursor;
        Cursor cursorRawQuery;
        this.f11344a.lock();
        Cursor cursorRawQuery2 = null;
        try {
            SQLiteDatabase readableDatabase = this.c.getReadableDatabase();
            if (readableDatabase != null) {
                cursorRawQuery = readableDatabase.rawQuery(" SELECT DISTINCT id From sessions order by id asc ", new String[0]);
                try {
                    StringBuffer stringBuffer = new StringBuffer();
                    stringBuffer.append("All sessions in db: ");
                    while (cursorRawQuery.moveToNext()) {
                        stringBuffer.append(cursorRawQuery.getString(0)).append(", ");
                    }
                    cursorRawQuery2 = readableDatabase.rawQuery(" SELECT DISTINCT session_id From events order by session_id asc ", new String[0]);
                    StringBuffer stringBuffer2 = new StringBuffer();
                    stringBuffer2.append("All sessions in reports db: ");
                    while (cursorRawQuery2.moveToNext()) {
                        stringBuffer2.append(cursorRawQuery2.getString(0)).append(", ");
                    }
                } catch (Throwable unused) {
                    cursor = cursorRawQuery2;
                    cursorRawQuery2 = cursorRawQuery;
                    cursorRawQuery = cursorRawQuery2;
                    cursorRawQuery2 = cursor;
                }
            } else {
                cursorRawQuery = null;
            }
        } catch (Throwable unused2) {
            cursor = null;
        }
        this.f11344a.unlock();
        In.a(cursorRawQuery);
        In.a(cursorRawQuery2);
    }

    public final void d() {
        this.d.start();
    }

    public final long a(Set set) {
        this.f11344a.lock();
        Cursor cursorRawQuery = null;
        long j = 0;
        try {
            SQLiteDatabase readableDatabase = this.c.getReadableDatabase();
            if (readableDatabase != null) {
                StringBuilder sb = new StringBuilder("SELECT count() FROM events");
                if (!set.isEmpty()) {
                    sb.append(" WHERE ");
                }
                Iterator it = set.iterator();
                int i = 0;
                while (it.hasNext()) {
                    Integer num = (Integer) it.next();
                    if (i > 0) {
                        sb.append(" OR ");
                    }
                    sb.append("type == " + num);
                    i++;
                }
                cursorRawQuery = readableDatabase.rawQuery(sb.toString(), null);
                if (cursorRawQuery.moveToFirst()) {
                    j = cursorRawQuery.getLong(0);
                }
            }
        } catch (Throwable unused) {
        }
        In.a(cursorRawQuery);
        this.f11344a.unlock();
        return j;
    }

    public final void a(W8 w8) {
        this.j.add(w8);
    }

    public static String a(La la) {
        return "DatabaseWorker [" + la.b().e() + com.ironsource.b9.i.e;
    }

    public final void a(long j, EnumC4621zk enumC4621zk, long j2) {
        JSONObject jSONObject;
        boolean zB;
        B7 b7 = new B7(null, 1, null);
        C4045ch c4045ch = (C4045ch) this.h.k.a();
        Long lValueOf = Long.valueOf(j);
        Long lValueOf2 = Long.valueOf(j2);
        try {
            jSONObject = new JSONObject().put("dId", c4045ch.getDeviceId()).put("uId", c4045ch.getUuid()).put("appVer", c4045ch.getAppVersion()).put(RemoteConfigConstants.RequestFieldKey.APP_BUILD, c4045ch.getAppBuildNumber()).put("kitBuildType", c4045ch.getAnalyticsSdkBuildType()).put("osVer", c4045ch.getOsVersion()).put("osApiLev", c4045ch.getOsApiLevel()).put(com.json.fe.q, c4045ch.getLocale()).put("root", c4045ch.getDeviceRootStatus()).put("app_debuggable", ((Y5) c4045ch).f11431a).put(CommonUrlParts.APP_FRAMEWORK, c4045ch.getAppFramework()).put("attribution_id", c4045ch.r).put("analyticsSdkVersionName", c4045ch.getAnalyticsSdkVersionName()).put("kitBuildNumber", c4045ch.getAnalyticsSdkBuildNumber());
        } catch (Throwable unused) {
            jSONObject = new JSONObject();
        }
        String string = jSONObject.toString();
        Long lValueOf3 = Long.valueOf(AbstractC4126fn.a());
        Kj kj = Jj.f11212a;
        synchronized (kj) {
            zB = kj.b.b(true);
        }
        ContentValues contentValuesFromModel = b7.fromModel(new A7(lValueOf, enumC4621zk, string, new C4608z7(lValueOf2, lValueOf3, Boolean.valueOf(zB))));
        if (contentValuesFromModel == null) {
            return;
        }
        this.b.lock();
        try {
            SQLiteDatabase writableDatabase = this.c.getWritableDatabase();
            if (writableDatabase != null) {
                writableDatabase.insertOrThrow("sessions", null, contentValuesFromModel);
            }
        } catch (Throwable unused2) {
        }
        this.b.unlock();
    }

    public final void a(ContentValues contentValues) {
        synchronized (this.e) {
            this.f.add(contentValues);
        }
        synchronized (this.d) {
            this.d.notifyAll();
        }
    }

    public final int a(SQLiteDatabase sQLiteDatabase) {
        try {
            return this.k.a(sQLiteDatabase, String.format("id IN (SELECT id FROM events ORDER BY CASE WHEN type IN (%1$s) THEN 2 WHEN type IN (%2$s) THEN 1 ELSE 0 END, id LIMIT (SELECT count() FROM events) / %3$s)", TextUtils.join(", ", C9.i), TextUtils.join(", ", C9.j), 10), 2, this.h.b.b, true).b;
        } catch (Throwable th) {
            Fj fj = AbstractC4097ej.f11536a;
            fj.getClass();
            fj.a(new C4122fj("deleteExcessiveReports exception", th));
            return 0;
        }
    }

    public final void a(long j, int i, int i2, boolean z) {
        if (i2 <= 0) {
            return;
        }
        this.b.lock();
        try {
            String str = String.format(Locale.US, "%1$s = %2$s AND %3$s = %4$s AND %5$s <= (SELECT %5$s FROM %6$s WHERE %1$s = %2$s AND %3$s = %4$s ORDER BY %5$s ASC LIMIT %7$s, 1)", SDKAnalyticsEvents.PARAMETER_SESSION_ID, Long.toString(j), "session_type", Integer.toString(i), "id", "events", Integer.toString(i2 - 1));
            SQLiteDatabase writableDatabase = this.c.getWritableDatabase();
            if (writableDatabase != null) {
                M6 m6A = this.k.a(writableDatabase, str, 1, this.h.b.b, z);
                if (m6A.f11254a != null) {
                    ArrayList arrayList = new ArrayList();
                    Iterator it = m6A.f11254a.iterator();
                    while (it.hasNext()) {
                        arrayList.add(Integer.valueOf(((ContentValues) it.next()).getAsInteger("type").intValue()));
                    }
                    Iterator it2 = this.j.iterator();
                    while (it2.hasNext()) {
                        ((W8) it2.next()).b(arrayList);
                    }
                }
                List list = m6A.f11254a;
                if (list != null) {
                    for (int i3 = 0; i3 < list.size(); i3++) {
                        a((ContentValues) list.get(i3), "Event removed from db");
                    }
                }
                this.i.addAndGet(-m6A.b);
            }
        } catch (Throwable unused) {
        }
        this.b.unlock();
    }

    public final ContentValues a(long j, EnumC4621zk enumC4621zk) {
        ContentValues contentValues = new ContentValues();
        this.f11344a.lock();
        Cursor cursorRawQuery = null;
        try {
            SQLiteDatabase readableDatabase = this.c.getReadableDatabase();
            if (readableDatabase != null) {
                cursorRawQuery = readableDatabase.rawQuery(String.format(Locale.US, "SELECT report_request_parameters FROM sessions WHERE id = %s AND type = %s ORDER BY id DESC LIMIT 1", Long.valueOf(j), Integer.valueOf(enumC4621zk.f11882a)), null);
                if (cursorRawQuery.moveToNext()) {
                    ContentValues contentValues2 = new ContentValues();
                    DatabaseUtils.cursorRowToContentValues(cursorRawQuery, contentValues2);
                    contentValues = contentValues2;
                }
            }
        } catch (Throwable unused) {
        }
        In.a(cursorRawQuery);
        this.f11344a.unlock();
        return contentValues;
    }

    public static String a(LinkedHashMap linkedHashMap) {
        StringBuilder sb = new StringBuilder("id >= ?");
        for (String str : linkedHashMap.keySet()) {
            sb.append(sb.length() > 0 ? " AND " : "");
            sb.append(str + " = ? ");
        }
        if (TextUtils.isEmpty(sb.toString())) {
            return null;
        }
        return sb.toString();
    }

    public static String[] a(String[] strArr, LinkedHashMap linkedHashMap) {
        ArrayList arrayList = new ArrayList();
        arrayList.addAll(Arrays.asList(strArr));
        Iterator it = linkedHashMap.entrySet().iterator();
        while (it.hasNext()) {
            arrayList.add((String) ((Map.Entry) it.next()).getValue());
        }
        return (String[]) arrayList.toArray(new String[arrayList.size()]);
    }

    public final void a(ContentValues contentValues, String str) {
        Integer asInteger = contentValues.getAsInteger("type");
        if (C9.d.contains(EnumC4164hb.a(asInteger != null ? asInteger.intValue() : -1))) {
            C4284m7 model = new C4309n7(null, 1, null).toModel(contentValues);
            PublicLogger publicLogger = this.h.m;
            EnumC4164hb enumC4164hb = model.d;
            C4259l7 c4259l7 = model.g;
            publicLogger.info(Df.a(str, enumC4164hb, c4259l7.b, c4259l7.c), new Object[0]);
        }
    }

    public static boolean a(S6 s6) {
        boolean zIsEmpty;
        synchronized (s6.e) {
            zIsEmpty = s6.f.isEmpty();
        }
        return zIsEmpty;
    }
}
