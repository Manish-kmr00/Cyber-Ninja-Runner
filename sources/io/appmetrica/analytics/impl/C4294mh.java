package io.appmetrica.analytics.impl;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.DatabaseUtils;
import android.database.sqlite.SQLiteDatabase;
import android.text.TextUtils;
import io.appmetrica.analytics.coreutils.internal.ApiKeyUtils;
import io.appmetrica.analytics.coreutils.internal.WrapUtils;
import io.appmetrica.analytics.coreutils.internal.db.DBUtils;
import io.appmetrica.analytics.coreutils.internal.io.GZIPCompressor;
import io.appmetrica.analytics.logger.appmetrica.internal.PublicLogger;
import io.appmetrica.analytics.networktasks.internal.DefaultNetworkResponseHandler;
import io.appmetrica.analytics.networktasks.internal.FullUrlFormer;
import io.appmetrica.analytics.networktasks.internal.RequestBodyEncrypter;
import io.appmetrica.analytics.networktasks.internal.RequestDataHolder;
import io.appmetrica.analytics.networktasks.internal.ResponseDataHolder;
import io.appmetrica.analytics.networktasks.internal.RetryPolicyConfig;
import io.appmetrica.analytics.networktasks.internal.SendingDataTaskHelper;
import io.appmetrica.analytics.networktasks.internal.UnderlyingNetworkTask;
import io.appmetrica.analytics.protobuf.nano.CodedOutputByteBufferNano;
import io.appmetrica.analytics.protobuf.nano.MessageNano;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import javax.net.ssl.SSLSocketFactory;
import org.json.JSONObject;

/* JADX INFO: renamed from: io.appmetrica.analytics.impl.mh, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes9.dex */
public final class C4294mh implements UnderlyingNetworkTask {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final C4282m5 f11674a;
    public final LinkedHashMap b;
    public C4458t7 c;
    public C4361p9 d;
    public final S6 e;
    public List f;
    public int g;
    public int h;
    public int i;
    public C4269lh j;
    public final C4454t3 k;
    public final PublicLogger l;
    public final Un m;
    public final Ya n;
    public final Rg o;
    public final FullUrlFormer p;
    public final Db q;
    public final RequestDataHolder r;
    public final ResponseDataHolder s;
    public final SendingDataTaskHelper t;
    public boolean u;
    public int v;

    public C4294mh(C4282m5 c4282m5, Rg rg, Db db, FullUrlFormer<C4045ch> fullUrlFormer, RequestDataHolder requestDataHolder, ResponseDataHolder responseDataHolder, RequestBodyEncrypter requestBodyEncrypter) {
        this(c4282m5, rg, db, fullUrlFormer, requestDataHolder, responseDataHolder, c4282m5.h(), c4282m5.o(), c4282m5.t(), requestBodyEncrypter);
    }

    public final C4361p9 a(C4269lh c4269lh, List list, C4045ch c4045ch) {
        C4361p9 c4361p9 = new C4361p9();
        C4162h9 c4162h9 = new C4162h9();
        c4162h9.f11582a = WrapUtils.getOrDefaultIfEmpty(this.c.b, c4045ch.getUuid());
        c4162h9.b = WrapUtils.getOrDefaultIfEmpty(this.c.f11776a, c4045ch.getDeviceId());
        this.g = CodedOutputByteBufferNano.computeMessageSize(4, c4162h9) + this.g;
        c4361p9.b = c4162h9;
        Lm lmA = C4486ua.E.A();
        C4219jh c4219jh = new C4219jh(this, c4361p9);
        synchronized (lmA) {
            lmA.f11249a.a(c4219jh);
        }
        List list2 = c4269lh.f11654a;
        c4361p9.f11717a = (C4286m9[]) list2.toArray(new C4286m9[list2.size()]);
        c4361p9.c = a(c4269lh.c);
        c4361p9.e = (String[]) list.toArray(new String[list.size()]);
        this.g = CodedOutputByteBufferNano.computeTagSize(8) + this.g;
        return c4361p9;
    }

    @Override // io.appmetrica.analytics.networktasks.internal.UnderlyingNetworkTask
    public final String description() {
        return "ReportTask_" + ApiKeyUtils.createPartialApiKey(this.f11674a.b.b);
    }

    @Override // io.appmetrica.analytics.networktasks.internal.UnderlyingNetworkTask
    public final FullUrlFormer<?> getFullUrlFormer() {
        return this.p;
    }

    @Override // io.appmetrica.analytics.networktasks.internal.UnderlyingNetworkTask
    public final RequestDataHolder getRequestDataHolder() {
        return this.r;
    }

    @Override // io.appmetrica.analytics.networktasks.internal.UnderlyingNetworkTask
    public final ResponseDataHolder getResponseDataHolder() {
        return this.s;
    }

    @Override // io.appmetrica.analytics.networktasks.internal.UnderlyingNetworkTask
    public final RetryPolicyConfig getRetryPolicyConfig() {
        return ((C4045ch) this.f11674a.k.a()).getRetryPolicyConfig();
    }

    @Override // io.appmetrica.analytics.networktasks.internal.UnderlyingNetworkTask
    public final SSLSocketFactory getSslSocketFactory() {
        ((C4049cl) C4486ua.E.y()).getClass();
        return null;
    }

    @Override // io.appmetrica.analytics.networktasks.internal.UnderlyingNetworkTask
    public final boolean onCreateTask() {
        Cursor cursorRawQuery;
        int iOptInt;
        S6 s6 = this.f11674a.e;
        s6.getClass();
        ArrayList arrayList = new ArrayList();
        s6.f11344a.lock();
        try {
            SQLiteDatabase readableDatabase = s6.c.getReadableDatabase();
            if (readableDatabase != null) {
                cursorRawQuery = readableDatabase.rawQuery(H5.b, null);
                while (cursorRawQuery.moveToNext()) {
                    try {
                        ContentValues contentValues = new ContentValues();
                        DatabaseUtils.cursorRowToContentValues(cursorRawQuery, contentValues);
                        arrayList.add(contentValues);
                    } catch (Throwable unused) {
                        try {
                            arrayList = new ArrayList();
                            In.a(cursorRawQuery);
                            s6.f11344a.unlock();
                        } catch (Throwable th) {
                            In.a(cursorRawQuery);
                            s6.f11344a.unlock();
                            throw th;
                        }
                    }
                }
            } else {
                cursorRawQuery = null;
            }
            In.a(cursorRawQuery);
            s6.f11344a.unlock();
        } catch (Throwable unused2) {
            cursorRawQuery = null;
        }
        if (arrayList.isEmpty()) {
            return false;
        }
        ContentValues contentValues2 = (ContentValues) arrayList.get(0);
        this.b.clear();
        for (Map.Entry<String, Object> entry : contentValues2.valueSet()) {
            this.b.put(entry.getKey(), entry.getValue().toString());
        }
        String asString = contentValues2.getAsString("report_request_parameters");
        if (TextUtils.isEmpty(asString)) {
            C4458t7 c4458t7 = new C4458t7();
            this.c = c4458t7;
            this.o.c = c4458t7;
        } else {
            try {
                C4458t7 c4458t8 = new C4458t7(new C4263lb(asString));
                this.c = c4458t8;
                this.o.c = c4458t8;
            } catch (Throwable unused3) {
                C4458t7 c4458t9 = new C4458t7();
                this.c = c4458t9;
                this.o.c = c4458t9;
            }
        }
        C4045ch config = this.q.getConfig();
        List list = config.w;
        if (In.a((Collection) list)) {
            return false;
        }
        this.p.setHosts(config.q);
        if (!config.t() || In.a((Collection) this.p.getAllHosts())) {
            return false;
        }
        this.f = null;
        C4269lh c4269lhA = a(config);
        this.j = c4269lhA;
        if (c4269lhA.f11654a.isEmpty()) {
            return false;
        }
        Un un = this.m;
        synchronized (un) {
            iOptInt = un.f11384a.a().optInt("report_request_id", -1);
        }
        int i = iOptInt + 1;
        this.v = i;
        this.o.e = i;
        C4361p9 c4361p9A = a(this.j, list, config);
        this.d = c4361p9A;
        this.f = this.j.b;
        this.t.prepareAndSetPostData(MessageNano.toByteArray(c4361p9A));
        return true;
    }

    @Override // io.appmetrica.analytics.networktasks.internal.UnderlyingNetworkTask
    public final void onPerformRequest() {
        this.t.onPerformRequest();
    }

    @Override // io.appmetrica.analytics.networktasks.internal.UnderlyingNetworkTask
    public final void onPostRequestComplete(boolean z) {
        String strA;
        if (z) {
            a(false);
        } else if (this.s.getResponseCode() == 400) {
            a(true);
        }
        if (z) {
            for (int i = 0; i < this.j.f11654a.size(); i++) {
                for (C4236k9 c4236k9 : ((C4286m9) this.j.f11654a.get(i)).c) {
                    if (c4236k9 != null && (strA = Df.a(c4236k9)) != null) {
                        this.l.info(strA, new Object[0]);
                    }
                }
            }
        }
    }

    @Override // io.appmetrica.analytics.networktasks.internal.UnderlyingNetworkTask
    public final boolean onRequestComplete() {
        return this.t.isResponseValid();
    }

    @Override // io.appmetrica.analytics.networktasks.internal.UnderlyingNetworkTask
    public final void onRequestError(Throwable th) {
    }

    @Override // io.appmetrica.analytics.networktasks.internal.UnderlyingNetworkTask
    public final void onShouldNotExecute() {
        this.u = false;
    }

    @Override // io.appmetrica.analytics.networktasks.internal.UnderlyingNetworkTask
    public final void onSuccessfulTaskFinished() {
    }

    @Override // io.appmetrica.analytics.networktasks.internal.UnderlyingNetworkTask
    public final void onTaskAdded() {
        ((C4556x5) this.f11674a.p).d.set(false);
    }

    @Override // io.appmetrica.analytics.networktasks.internal.UnderlyingNetworkTask
    public final void onTaskFinished() {
        SQLiteDatabase writableDatabase;
        S6 s6 = this.f11674a.e;
        s6.getClass();
        try {
            s6.b.lock();
            if (s6.i.get() > ((C4045ch) s6.h.k.a()).v && (writableDatabase = s6.c.getWritableDatabase()) != null) {
                int iA = s6.a(writableDatabase);
                s6.i.addAndGet(-iA);
                if (iA != 0) {
                    Iterator it = s6.j.iterator();
                    while (it.hasNext()) {
                        ((W8) it.next()).a();
                    }
                }
            }
        } catch (Throwable unused) {
        }
        s6.b.unlock();
        ((C4556x5) this.f11674a.p).d.set(true);
    }

    @Override // io.appmetrica.analytics.networktasks.internal.UnderlyingNetworkTask
    public final void onTaskRemoved() {
        ((C4556x5) this.f11674a.p).d.set(true);
        if (this.u) {
            ((C4556x5) this.f11674a.p).d();
        }
    }

    @Override // io.appmetrica.analytics.networktasks.internal.UnderlyingNetworkTask
    public final void onUnsuccessfulTaskFinished() {
    }

    public C4294mh(C4282m5 c4282m5, Rg rg, Db db, FullUrlFormer fullUrlFormer, RequestDataHolder requestDataHolder, ResponseDataHolder responseDataHolder, S6 s6, PublicLogger publicLogger, Un un, RequestBodyEncrypter requestBodyEncrypter) {
        this(c4282m5, publicLogger, s6, rg, un, db, new C4454t3(1024000, "event value in ReportTask", publicLogger), AbstractC4378q1.a(), fullUrlFormer, requestDataHolder, responseDataHolder, requestBodyEncrypter);
    }

    public C4294mh(C4282m5 c4282m5, PublicLogger publicLogger, S6 s6, Rg rg, Un un, Db db, C4454t3 c4454t3, Fj fj, FullUrlFormer fullUrlFormer, RequestDataHolder requestDataHolder, ResponseDataHolder responseDataHolder, RequestBodyEncrypter requestBodyEncrypter) {
        this.b = new LinkedHashMap();
        this.g = 0;
        this.h = 0;
        this.i = -1;
        this.u = true;
        this.t = new SendingDataTaskHelper(requestBodyEncrypter, new GZIPCompressor(), requestDataHolder, responseDataHolder, new DefaultNetworkResponseHandler());
        this.o = rg;
        this.f11674a = c4282m5;
        this.e = s6;
        this.l = publicLogger;
        this.k = c4454t3;
        this.m = un;
        this.q = db;
        this.n = fj;
        this.r = requestDataHolder;
        this.s = responseDataHolder;
        this.p = fullUrlFormer;
    }

    public static C4087e9[] a(JSONObject jSONObject) {
        int length = jSONObject.length();
        if (length <= 0) {
            return null;
        }
        C4087e9[] c4087e9Arr = new C4087e9[length];
        Iterator<String> itKeys = jSONObject.keys();
        int i = 0;
        while (itKeys.hasNext()) {
            String next = itKeys.next();
            try {
                C4087e9 c4087e9 = new C4087e9();
                c4087e9.f11529a = next;
                c4087e9.b = jSONObject.getString(next);
                c4087e9Arr[i] = c4087e9;
            } catch (Throwable unused) {
            }
            i++;
        }
        return c4087e9Arr;
    }

    public final void a(boolean z) {
        Un un = this.m;
        int i = this.v;
        synchronized (un) {
            Vn vn = un.f11384a;
            vn.a(vn.a().put("report_request_id", i));
        }
        C4286m9[] c4286m9Arr = this.d.f11717a;
        for (int i2 = 0; i2 < c4286m9Arr.length; i2++) {
            try {
                C4286m9 c4286m9 = c4286m9Arr[i2];
                long jLongValue = ((Long) this.f.get(i2)).longValue();
                EnumC4621zk enumC4621zk = (EnumC4621zk) Cf.b.get(c4286m9.b.c);
                if (enumC4621zk == null) {
                    enumC4621zk = EnumC4621zk.FOREGROUND;
                }
                this.e.a(jLongValue, enumC4621zk.f11882a, c4286m9.c.length, z);
                Cf.a(c4286m9);
            } catch (Throwable unused) {
            }
        }
        S6 s6 = this.e;
        long jA = this.f11674a.j.a();
        s6.b.lock();
        try {
            if (J5.f11204a.booleanValue()) {
                s6.c();
            }
            SQLiteDatabase writableDatabase = s6.c.getWritableDatabase();
            if (writableDatabase != null) {
                writableDatabase.delete("sessions", H5.c, new String[]{String.valueOf(jA)});
            }
        } catch (Throwable unused2) {
        }
        s6.b.unlock();
    }

    public final C4269lh a(C4045ch c4045ch) {
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        JSONObject jSONObject = new JSONObject();
        ArrayList arrayList3 = new ArrayList();
        Cursor cursor = null;
        try {
            Cursor cursorA = a();
            if (cursorA != null) {
                JSONObject jSONObject2 = jSONObject;
                C4028c0 c4028c0 = null;
                while (cursorA.moveToNext() && this.h < 100) {
                    try {
                        ContentValues contentValues = new ContentValues();
                        DBUtils.cursorRowToContentValues(cursorA, contentValues);
                        A7 model = new B7(null, 1, null).toModel(contentValues);
                        Long l = model.f11055a;
                        if (l != null) {
                            C4608z7 c4608z7 = model.d;
                            C4336o9 c4336o9A = Cf.a(c4608z7.f11871a, c4608z7.b, c4608z7.c);
                            String locale = c4045ch.getLocale();
                            EnumC4621zk enumC4621zk = model.b;
                            C4261l9 c4261l9 = new C4261l9();
                            c4261l9.f11648a = c4336o9A;
                            c4261l9.b = locale;
                            if (enumC4621zk != null) {
                                Integer num = (Integer) Cf.f11090a.get(enumC4621zk);
                                c4261l9.c = num != null ? num.intValue() : 0;
                            }
                            int iComputeUInt64Size = this.g + CodedOutputByteBufferNano.computeUInt64Size(1, Long.MAX_VALUE);
                            this.g = iComputeUInt64Size;
                            int iComputeMessageSize = iComputeUInt64Size + CodedOutputByteBufferNano.computeMessageSize(2, c4261l9);
                            this.g = iComputeMessageSize;
                            if (iComputeMessageSize >= 250880) {
                                break;
                            }
                            C4244kh c4244khA = a(l.longValue(), c4261l9, c4045ch, arrayList3, arrayList.size());
                            if (c4244khA == null) {
                                continue;
                            } else {
                                if (c4028c0 == null) {
                                    c4028c0 = c4244khA.b;
                                } else {
                                    if (!c4028c0.equals(c4244khA.b)) {
                                        break;
                                    }
                                    break;
                                }
                                arrayList2.add(l);
                                arrayList.add(c4244khA.f11637a);
                                if (!TextUtils.isEmpty(c4244khA.b.f11486a)) {
                                    try {
                                        jSONObject2 = new JSONObject(c4244khA.b.f11486a);
                                    } catch (Throwable unused) {
                                    }
                                }
                                if (c4244khA.c) {
                                    break;
                                }
                            }
                        }
                    } catch (Throwable th) {
                        th = th;
                        cursor = cursorA;
                        jSONObject = jSONObject2;
                        try {
                            arrayList3.add(th);
                            In.a(cursor);
                        } catch (Throwable th2) {
                            In.a(cursor);
                            throw th2;
                        }
                    }
                }
                jSONObject = jSONObject2;
            }
            In.a(cursorA);
        } catch (Throwable th3) {
            th = th3;
        }
        Iterator it = arrayList3.iterator();
        while (it.hasNext()) {
            this.n.reportError("protobuf_serialization_error", (Throwable) it.next());
        }
        return new C4269lh(arrayList, arrayList2, jSONObject);
    }

    public static C4028c0 a(ContentValues contentValues) {
        C4284m7 model = new C4309n7(null, 1, null).toModel(contentValues);
        return new C4028c0((String) WrapUtils.getOrDefault(model.g.g, ""), ((Long) WrapUtils.getOrDefault(model.g.h, 0L)).longValue());
    }

    /* JADX WARN: Code duplicated, block: B:71:0x010e  */
    public final C4244kh a(long j, C4261l9 c4261l9, C4045ch c4045ch, ArrayList arrayList, int i) {
        Cursor cursorA;
        boolean z;
        C4244kh c4244kh;
        C4236k9 c4236k9A;
        int iComputeMessageSize;
        C3987a9 c3987a9;
        C4286m9 c4286m9 = new C4286m9();
        c4286m9.f11668a = j;
        c4286m9.b = c4261l9;
        EnumC4621zk enumC4621zk = (EnumC4621zk) Cf.b.get(c4261l9.c);
        if (enumC4621zk == null) {
            enumC4621zk = EnumC4621zk.FOREGROUND;
        }
        try {
            cursorA = a(j, enumC4621zk);
            if (cursorA != null) {
                try {
                    ArrayList arrayList2 = new ArrayList();
                    C4028c0 c4028c0 = null;
                    while (true) {
                        z = false;
                        if (!cursorA.moveToNext() || this.h >= 100) {
                            break;
                        }
                        ContentValues contentValues = new ContentValues();
                        DBUtils.cursorRowToContentValues(cursorA, contentValues);
                        try {
                            R8 r8 = new R8(contentValues);
                            EnumC4164hb enumC4164hb = r8.h;
                            if (enumC4164hb != null) {
                                c3987a9 = (C3987a9) Cf.d.get(enumC4164hb);
                            } else {
                                Map map = Cf.f11090a;
                                c3987a9 = null;
                            }
                            if (c3987a9 == null) {
                                c3987a9 = C3987a9.i;
                            }
                            try {
                                c4236k9A = c3987a9.a(r8, c4045ch);
                            } catch (Throwable th) {
                                th = th;
                                arrayList.add(th);
                                c4236k9A = null;
                            }
                        } catch (Throwable th2) {
                            th = th2;
                        }
                        if (c4236k9A != null) {
                            C4028c0 c4028c0A = a(contentValues);
                            if (c4028c0 == null) {
                                if (this.i < 0) {
                                    try {
                                        C4087e9[] c4087e9ArrA = a(new JSONObject(c4028c0A.f11486a));
                                        if (c4087e9ArrA != null) {
                                            iComputeMessageSize = 0;
                                            for (C4087e9 c4087e9 : c4087e9ArrA) {
                                                iComputeMessageSize += CodedOutputByteBufferNano.computeMessageSize(7, c4087e9);
                                            }
                                        } else {
                                            iComputeMessageSize = 0;
                                        }
                                    } catch (Throwable unused) {
                                    }
                                    this.i = iComputeMessageSize;
                                    this.g += iComputeMessageSize;
                                }
                                c4028c0 = c4028c0A;
                            } else if (!c4028c0.equals(c4028c0A)) {
                                z = true;
                                break;
                            }
                            C4454t3 c4454t3 = this.k;
                            byte[] bArr = c4236k9A.e;
                            c4454t3.getClass();
                            byte[] bArrA = c4454t3.a(bArr);
                            byte[] bArr2 = c4236k9A.e;
                            if (bArr2 != bArrA) {
                                c4236k9A.i = ((bArr2 == null ? 0 : bArr2.length) - (bArrA == null ? 0 : bArrA.length)) + c4236k9A.i;
                                c4236k9A.e = bArrA;
                            }
                            this.g += CodedOutputByteBufferNano.computeMessageSize(3, c4236k9A);
                            if (arrayList2.isEmpty() && i == 0) {
                                if (this.g >= 1048576) {
                                    break;
                                }
                            } else if (this.g >= 250880) {
                                break;
                            }
                        }
                        arrayList2.add(c4236k9A);
                        this.h++;
                    }
                    if (arrayList2.size() > 0) {
                        c4286m9.c = (C4236k9[]) arrayList2.toArray(new C4236k9[arrayList2.size()]);
                        c4244kh = new C4244kh(c4286m9, c4028c0, z);
                    } else {
                        c4244kh = null;
                    }
                } catch (Throwable th3) {
                    th = th3;
                    try {
                        arrayList.add(th);
                        return null;
                    } finally {
                        In.a(cursorA);
                    }
                }
            } else {
                c4244kh = null;
            }
            In.a(cursorA);
            return c4244kh;
        } catch (Throwable th4) {
            th = th4;
            cursorA = null;
        }
    }

    public final Cursor a() {
        Cursor cursorQuery;
        S6 s6 = this.e;
        LinkedHashMap linkedHashMap = this.b;
        s6.f11344a.lock();
        try {
            SQLiteDatabase readableDatabase = s6.c.getReadableDatabase();
            cursorQuery = readableDatabase != null ? readableDatabase.query("sessions", null, S6.a(linkedHashMap), S6.a(new String[]{Long.toString(0L)}, linkedHashMap), null, null, "id ASC", null) : null;
        } catch (Throwable unused) {
        }
        s6.f11344a.unlock();
        return cursorQuery;
    }

    public final Cursor a(long j, EnumC4621zk enumC4621zk) {
        Cursor cursorQuery;
        S6 s6 = this.e;
        s6.f11344a.lock();
        try {
            SQLiteDatabase readableDatabase = s6.c.getReadableDatabase();
            cursorQuery = readableDatabase != null ? readableDatabase.query("events", null, "session_id = ? AND session_type = ?", new String[]{Long.toString(j), Integer.toString(enumC4621zk.f11882a)}, null, null, "number_in_session ASC", null) : null;
        } catch (Throwable unused) {
        }
        s6.f11344a.unlock();
        return cursorQuery;
    }
}
