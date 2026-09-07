package io.appmetrica.analytics.impl;

import android.database.sqlite.SQLiteDatabase;
import io.appmetrica.analytics.coreapi.internal.db.DatabaseScript;

/* JADX INFO: renamed from: io.appmetrica.analytics.impl.b5, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes6.dex */
public final class C4008b5 extends DatabaseScript {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final C3983a5 f11475a = new C3983a5();
    public final Z4 b = new Z4();

    @Override // io.appmetrica.analytics.coreapi.internal.db.DatabaseScript
    public final void runScript(SQLiteDatabase sQLiteDatabase) {
        this.f11475a.runScript(sQLiteDatabase);
        this.b.runScript(sQLiteDatabase);
    }
}
