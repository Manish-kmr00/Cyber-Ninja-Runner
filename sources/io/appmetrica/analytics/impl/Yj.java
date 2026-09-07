package io.appmetrica.analytics.impl;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.text.TextUtils;
import io.appmetrica.analytics.coreutils.internal.encryption.AESEncrypter;
import io.appmetrica.analytics.coreutils.internal.io.CloseableUtilsKt;
import io.appmetrica.analytics.coreutils.internal.parsing.JsonUtils;
import io.appmetrica.analytics.protobuf.nano.MessageNano;

/* JADX INFO: loaded from: classes7.dex */
public final class Yj implements Oc {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Tn f11440a;
    public final String b = "startup_state";
    public final AESEncrypter c;

    public Yj(Tn tn) {
        this.f11440a = tn;
        C3977a c3977a = new C3977a(C4486ua.j().f());
        this.c = new AESEncrypter(AESEncrypter.DEFAULT_ALGORITHM, c3977a.b(), c3977a.a());
    }

    @Override // io.appmetrica.analytics.impl.Oc
    public final void a(Context context) {
        SQLiteDatabase readableDatabase = C4135g7.a(context).h().getReadableDatabase();
        if (readableDatabase != null) {
            try {
                Fb fbA = a(readableDatabase);
                Kl kl = new Kl(new C4(new A4()));
                if (fbA != null) {
                    a(this.f11440a, kl, fbA);
                    kl.p = fbA.c;
                    kl.r = fbA.b;
                }
                Ll ll = new Ll(kl);
                AbstractC4473tm abstractC4473tmA = C4448sm.a(Ll.class);
                abstractC4473tmA.a(context, abstractC4473tmA.d(context)).save(ll);
            } catch (Throwable unused) {
            }
        }
    }

    public static void a(Tn tn, Kl kl, Fb fb) {
        String strOptStringOrNull;
        synchronized (tn) {
            strOptStringOrNull = JsonUtils.optStringOrNull(tn.f11370a.a(), "device_id");
        }
        if (TextUtils.isEmpty(strOptStringOrNull)) {
            if (!TextUtils.isEmpty(fb.d)) {
                tn.a(fb.d);
            }
            if (!TextUtils.isEmpty(fb.e)) {
                tn.b(fb.e);
            }
            if (TextUtils.isEmpty(fb.f11139a)) {
                return;
            }
            kl.f11230a = fb.f11139a;
        }
    }

    /* JADX WARN: Code duplicated, block: B:13:0x0048 A[Catch: all -> 0x004d, TRY_ENTER, TRY_LEAVE, TryCatch #1 {all -> 0x004d, blocks: (B:5:0x001d, B:7:0x0023, B:9:0x0029, B:13:0x0048), top: B:21:0x001d }] */
    public final Fb a(SQLiteDatabase sQLiteDatabase) {
        Cursor cursorQuery;
        try {
            cursorQuery = sQLiteDatabase.query("binary_data", new String[]{"value"}, "data_key = ?", new String[]{this.b}, null, null, null);
            if (cursorQuery != null) {
                try {
                    if (cursorQuery.getCount() == 1 && cursorQuery.moveToFirst()) {
                        Fb fb = (Fb) MessageNano.mergeFrom(new Fb(), this.c.decrypt(cursorQuery.getBlob(cursorQuery.getColumnIndexOrThrow("value"))));
                        CloseableUtilsKt.closeSafely(cursorQuery);
                        return fb;
                    }
                    if (cursorQuery != null) {
                        cursorQuery.getCount();
                    }
                } catch (Throwable unused) {
                }
            } else if (cursorQuery != null) {
                cursorQuery.getCount();
            }
        } catch (Throwable unused2) {
            cursorQuery = null;
        }
        CloseableUtilsKt.closeSafely(cursorQuery);
        return null;
    }
}
