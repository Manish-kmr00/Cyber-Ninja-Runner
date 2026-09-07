package io.appmetrica.analytics.impl;

import android.database.sqlite.SQLiteDatabase;

/* JADX INFO: loaded from: classes3.dex */
public final class Sk implements F6 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final C4110f7 f11352a;

    public Sk(C4110f7 c4110f7) {
        this.f11352a = c4110f7;
    }

    @Override // io.appmetrica.analytics.impl.F6
    public final void a(SQLiteDatabase sQLiteDatabase) {
    }

    @Override // io.appmetrica.analytics.impl.F6
    public final SQLiteDatabase a() {
        try {
            return this.f11352a.getWritableDatabase();
        } catch (Throwable unused) {
            return null;
        }
    }
}
