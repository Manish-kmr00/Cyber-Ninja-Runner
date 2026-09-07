package io.appmetrica.analytics.impl;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import io.appmetrica.analytics.logger.appmetrica.internal.PublicLogger;
import java.io.Closeable;

/* JADX INFO: renamed from: io.appmetrica.analytics.impl.ec, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes6.dex */
public final class C4090ec implements F6 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f11531a;
    public final String b;
    public final Hm c;
    public final C4113fa d;
    public C4110f7 e;

    public C4090ec(Context context, String str, Hm hm) {
        this(context, str, new C4113fa(str), hm);
    }

    @Override // io.appmetrica.analytics.impl.F6
    public final synchronized SQLiteDatabase a() {
        C4110f7 c4110f7;
        try {
            this.d.a();
            c4110f7 = new C4110f7(this.f11531a, this.b, this.c, PublicLogger.getAnonymousInstance());
            this.e = c4110f7;
        } catch (Throwable unused) {
            return null;
        }
        return c4110f7.getWritableDatabase();
    }

    public C4090ec(Context context, String str, C4113fa c4113fa, Hm hm) {
        this.f11531a = context;
        this.b = str;
        this.d = c4113fa;
        this.c = hm;
    }

    @Override // io.appmetrica.analytics.impl.F6
    public final synchronized void a(SQLiteDatabase sQLiteDatabase) {
        if (sQLiteDatabase != null) {
            try {
                sQLiteDatabase.close();
            } catch (Throwable unused) {
            }
        }
        In.a((Closeable) this.e);
        this.d.b();
        this.e = null;
    }
}
