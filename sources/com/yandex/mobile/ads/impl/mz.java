package com.yandex.mobile.ads.impl;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.net.Uri;
import android.text.TextUtils;
import com.playon.bridge.Ad;
import com.smaato.sdk.core.dns.DnsName;
import io.appmetrica.analytics.coreutils.internal.StringUtils;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;

/* JADX INFO: loaded from: classes5.dex */
public final class mz implements sk2 {
    private static final String e;
    private static final String[] f;
    private final wv b;
    private boolean d;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f9678a = "ExoPlayerDownloads";
    private final Object c = new Object();

    public mz(d22 d22Var, int i) {
        this.b = d22Var;
    }

    private static ArrayList a(String str) {
        ArrayList arrayList = new ArrayList();
        if (TextUtils.isEmpty(str)) {
            return arrayList;
        }
        int i = x82.f10629a;
        for (String str2 : str.split(StringUtils.COMMA, -1)) {
            String[] strArrSplit = str2.split(DnsName.ESCAPED_DOT, -1);
            if (strArrSplit.length != 3) {
                throw new IllegalStateException();
            }
            arrayList.add(new p22(Integer.parseInt(strArrSplit[0]), Integer.parseInt(strArrSplit[1]), Integer.parseInt(strArrSplit[2])));
        }
        return arrayList;
    }

    static {
        int[] iArr = {3, 4};
        StringBuilder sb = new StringBuilder("state IN (");
        for (int i = 0; i < 2; i++) {
            if (i > 0) {
                sb.append(AbstractJsonLexerKt.COMMA);
            }
            sb.append(iArr[i]);
        }
        sb.append(')');
        e = sb.toString();
        f = new String[]{"id", Ad.MIME_TYPE, "uri", "stream_keys", "custom_cache_key", "data", "state", "start_time_ms", "update_time_ms", "content_length", "stop_reason", "failure_reason", "percent_downloaded", "bytes_downloaded", "key_set_id"};
    }

    public final t30 b(String str) throws vv {
        a();
        try {
            Cursor cursorA = a("id = ?", new String[]{str});
            try {
                if (cursorA.getCount() == 0) {
                    cursorA.close();
                    return null;
                }
                cursorA.moveToNext();
                t30 t30VarA = a(cursorA);
                cursorA.close();
                return t30VarA;
            } catch (Throwable th) {
                if (cursorA != null) {
                    try {
                        cursorA.close();
                    } catch (Throwable th2) {
                        th.addSuppressed(th2);
                    }
                }
                throw th;
            }
        } catch (SQLiteException e2) {
            throw new vv(e2);
        }
        throw new vv(e2);
    }

    public final void c(String str) throws vv {
        a();
        try {
            this.b.getWritableDatabase().delete(this.f9678a, "id = ?", new String[]{str});
        } catch (Throwable th) {
            throw new vv(th);
        }
    }

    private void a() throws vv {
        ArrayList arrayList;
        synchronized (this.c) {
            if (this.d) {
                return;
            }
            try {
                int iA = bb2.a(this.b.getReadableDatabase(), 0, "");
                if (iA != 3) {
                    SQLiteDatabase writableDatabase = this.b.getWritableDatabase();
                    writableDatabase.beginTransactionNonExclusive();
                    try {
                        bb2.a(writableDatabase, 0, "", 3);
                        if (iA == 2) {
                            arrayList = a(writableDatabase);
                        } else {
                            arrayList = new ArrayList();
                        }
                        writableDatabase.execSQL("DROP TABLE IF EXISTS " + this.f9678a);
                        writableDatabase.execSQL("CREATE TABLE " + this.f9678a + " (id TEXT PRIMARY KEY NOT NULL,mime_type TEXT,uri TEXT NOT NULL,stream_keys TEXT NOT NULL,custom_cache_key TEXT,data BLOB NOT NULL,state INTEGER NOT NULL,start_time_ms INTEGER NOT NULL,update_time_ms INTEGER NOT NULL,content_length INTEGER NOT NULL,stop_reason INTEGER NOT NULL,failure_reason INTEGER NOT NULL,percent_downloaded REAL NOT NULL,bytes_downloaded INTEGER NOT NULL,key_set_id BLOB NOT NULL)");
                        Iterator it = arrayList.iterator();
                        while (it.hasNext()) {
                            a((t30) it.next(), writableDatabase);
                        }
                        writableDatabase.setTransactionSuccessful();
                        writableDatabase.endTransaction();
                    } catch (Throwable th) {
                        writableDatabase.endTransaction();
                        throw th;
                    }
                }
                this.d = true;
            } catch (Throwable th2) {
                throw new vv(th2);
            }
        }
    }

    public final void c() throws vv {
        a();
        try {
            ContentValues contentValues = new ContentValues();
            contentValues.put("state", (Integer) 5);
            contentValues.put("failure_reason", (Integer) 0);
            this.b.getWritableDatabase().update(this.f9678a, contentValues, null, null);
        } catch (Throwable th) {
            throw new vv(th);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    static final class a implements u30 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final Cursor f9679a;

        private a(Cursor cursor) {
            this.f9679a = cursor;
        }

        public final t30 a() {
            return mz.a(this.f9679a);
        }

        public final int b() {
            return this.f9679a.getPosition();
        }

        @Override // java.io.Closeable, java.lang.AutoCloseable
        public final void close() {
            this.f9679a.close();
        }

        public final boolean a(int i) {
            return this.f9679a.moveToPosition(i);
        }
    }

    private static t30 b(Cursor cursor) {
        String str;
        String string = cursor.getString(0);
        string.getClass();
        String string2 = cursor.getString(2);
        string2.getClass();
        x30.b bVar = new x30.b(Uri.parse(string2), string);
        String string3 = cursor.getString(1);
        if ("dash".equals(string3)) {
            str = "application/dash+xml";
        } else if ("hls".equals(string3)) {
            str = "application/x-mpegURL";
        } else if ("ss".equals(string3)) {
            str = "application/vnd.ms-sstr+xml";
        } else {
            str = "video/x-unknown";
        }
        x30 x30VarA = bVar.b(str).a(a(cursor.getString(3))).a(cursor.getString(4)).a(cursor.getBlob(5)).a();
        w30 w30Var = new w30();
        w30Var.f10531a = cursor.getLong(13);
        w30Var.b = cursor.getFloat(12);
        int i = cursor.getInt(6);
        return new t30(x30VarA, i, cursor.getLong(7), cursor.getLong(8), cursor.getLong(9), cursor.getInt(10), i == 4 ? cursor.getInt(11) : 0, w30Var);
    }

    private Cursor a(String str, String[] strArr) throws vv {
        try {
            return this.b.getReadableDatabase().query(this.f9678a, f, str, strArr, null, null, "start_time_ms ASC");
        } catch (Throwable th) {
            throw new vv(th);
        }
    }

    public final void b() throws vv {
        a();
        try {
            ContentValues contentValues = new ContentValues();
            contentValues.put("state", (Integer) 0);
            this.b.getWritableDatabase().update(this.f9678a, contentValues, "state = 2", null);
        } catch (Throwable th) {
            throw new vv(th);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static t30 a(Cursor cursor) {
        byte[] blob = cursor.getBlob(14);
        String string = cursor.getString(0);
        string.getClass();
        String string2 = cursor.getString(2);
        string2.getClass();
        x30.b bVarA = new x30.b(Uri.parse(string2), string).b(cursor.getString(1)).a(a(cursor.getString(3)));
        if (blob.length <= 0) {
            blob = null;
        }
        x30 x30VarA = bVarA.b(blob).a(cursor.getString(4)).a(cursor.getBlob(5)).a();
        w30 w30Var = new w30();
        w30Var.f10531a = cursor.getLong(13);
        w30Var.b = cursor.getFloat(12);
        int i = cursor.getInt(6);
        return new t30(x30VarA, i, cursor.getLong(7), cursor.getLong(8), cursor.getLong(9), cursor.getInt(10), i == 4 ? cursor.getInt(11) : 0, w30Var);
    }

    public final u30 a(int... iArr) throws vv {
        String string;
        a();
        if (iArr.length == 0) {
            string = "1";
        } else {
            StringBuilder sb = new StringBuilder("state IN (");
            for (int i = 0; i < iArr.length; i++) {
                if (i > 0) {
                    sb.append(AbstractJsonLexerKt.COMMA);
                }
                sb.append(iArr[i]);
            }
            sb.append(')');
            string = sb.toString();
        }
        return new a(a(string, (String[]) null));
    }

    private ArrayList a(SQLiteDatabase sQLiteDatabase) {
        ArrayList arrayList = new ArrayList();
        if (!x82.a(sQLiteDatabase, this.f9678a)) {
            return arrayList;
        }
        Cursor cursorQuery = sQLiteDatabase.query(this.f9678a, new String[]{"id", "title", "uri", "stream_keys", "custom_cache_key", "data", "state", "start_time_ms", "update_time_ms", "content_length", "stop_reason", "failure_reason", "percent_downloaded", "bytes_downloaded"}, null, null, null, null, null);
        while (cursorQuery.moveToNext()) {
            try {
                arrayList.add(b(cursorQuery));
            } catch (Throwable th) {
                if (cursorQuery != null) {
                    try {
                        cursorQuery.close();
                    } catch (Throwable th2) {
                        th.addSuppressed(th2);
                    }
                }
                throw th;
            }
        }
        cursorQuery.close();
        return arrayList;
    }

    public final void a(t30 t30Var) throws vv {
        a();
        try {
            a(t30Var, this.b.getWritableDatabase());
        } catch (Throwable th) {
            throw new vv(th);
        }
    }

    private void a(t30 t30Var, SQLiteDatabase sQLiteDatabase) {
        byte[] bArr = t30Var.f10264a.f;
        if (bArr == null) {
            bArr = x82.f;
        }
        ContentValues contentValues = new ContentValues();
        contentValues.put("id", t30Var.f10264a.b);
        contentValues.put(Ad.MIME_TYPE, t30Var.f10264a.d);
        contentValues.put("uri", t30Var.f10264a.c.toString());
        List<p22> list = t30Var.f10264a.e;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < list.size(); i++) {
            p22 p22Var = list.get(i);
            sb.append(p22Var.b).append('.').append(p22Var.c).append('.').append(p22Var.d).append(AbstractJsonLexerKt.COMMA);
        }
        if (sb.length() > 0) {
            sb.setLength(sb.length() - 1);
        }
        contentValues.put("stream_keys", sb.toString());
        contentValues.put("custom_cache_key", t30Var.f10264a.g);
        contentValues.put("data", t30Var.f10264a.h);
        contentValues.put("state", Integer.valueOf(t30Var.b));
        contentValues.put("start_time_ms", Long.valueOf(t30Var.c));
        contentValues.put("update_time_ms", Long.valueOf(t30Var.d));
        contentValues.put("content_length", Long.valueOf(t30Var.e));
        contentValues.put("stop_reason", Integer.valueOf(t30Var.f));
        contentValues.put("failure_reason", Integer.valueOf(t30Var.g));
        contentValues.put("percent_downloaded", Float.valueOf(t30Var.h.b));
        contentValues.put("bytes_downloaded", Long.valueOf(t30Var.h.f10531a));
        contentValues.put("key_set_id", bArr);
        sQLiteDatabase.replaceOrThrow(this.f9678a, null, contentValues);
    }

    public final void a(int i) throws vv {
        a();
        try {
            ContentValues contentValues = new ContentValues();
            contentValues.put("stop_reason", Integer.valueOf(i));
            this.b.getWritableDatabase().update(this.f9678a, contentValues, e, null);
        } catch (Throwable th) {
            throw new vv(th);
        }
    }

    public final void a(int i, String str) throws vv {
        a();
        try {
            ContentValues contentValues = new ContentValues();
            contentValues.put("stop_reason", Integer.valueOf(i));
            this.b.getWritableDatabase().update(this.f9678a, contentValues, e + " AND id = ?", new String[]{str});
        } catch (Throwable th) {
            throw new vv(th);
        }
    }
}
