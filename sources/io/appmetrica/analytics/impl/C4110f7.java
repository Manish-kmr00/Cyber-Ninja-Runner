package io.appmetrica.analytics.impl;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import io.appmetrica.analytics.coreapi.internal.db.DatabaseScript;
import io.appmetrica.analytics.logger.appmetrica.internal.PublicLogger;
import java.io.Closeable;
import java.util.Collection;
import java.util.Iterator;

/* JADX INFO: renamed from: io.appmetrica.analytics.impl.f7, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes6.dex */
public final class C4110f7 extends SQLiteOpenHelper implements Closeable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f11546a;
    public final PublicLogger b;
    public final Hm c;

    public C4110f7(Context context, String str, Hm hm, PublicLogger publicLogger) {
        super(context, str, (SQLiteDatabase.CursorFactory) null, J5.b);
        this.c = hm;
        this.f11546a = str;
        this.b = publicLogger;
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public final SQLiteDatabase getReadableDatabase() {
        try {
            return super.getReadableDatabase();
        } catch (Throwable th) {
            this.b.error(th, "Could not get readable database %s due to an exception. AppMetrica SDK may behave unexpectedly.", this.f11546a);
            Fj fj = AbstractC4097ej.f11536a;
            fj.getClass();
            fj.a(new C4122fj("db_read_error", th));
            return null;
        }
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public final SQLiteDatabase getWritableDatabase() {
        try {
            return super.getWritableDatabase();
        } catch (Throwable th) {
            this.b.error(th, "Could not get writable database %s due to an exception. AppMetrica SDK may behave unexpectedly.", this.f11546a);
            Fj fj = AbstractC4097ej.f11536a;
            fj.getClass();
            fj.a(new C4122fj("db_write_error", th));
            return null;
        }
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public final void onCreate(SQLiteDatabase sQLiteDatabase) {
        try {
            this.c.f11182a.runScript(sQLiteDatabase);
        } catch (Throwable unused) {
        }
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public final void onDowngrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
        Hm hm = this.c;
        if (i <= i2) {
            hm.getClass();
            return;
        }
        try {
            hm.b.runScript(sQLiteDatabase);
        } catch (Throwable unused) {
        }
        try {
            hm.f11182a.runScript(sQLiteDatabase);
        } catch (Throwable unused2) {
        }
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public final void onOpen(SQLiteDatabase sQLiteDatabase) {
        super.onOpen(sQLiteDatabase);
        Hm hm = this.c;
        hm.getClass();
        try {
            Im im = hm.d;
            if (im == null || im.a(sQLiteDatabase)) {
                return;
            }
            try {
                hm.b.runScript(sQLiteDatabase);
            } catch (Throwable unused) {
            }
            hm.f11182a.runScript(sQLiteDatabase);
        } catch (Throwable unused2) {
        }
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public final void onUpgrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
        boolean z;
        Hm hm = this.c;
        hm.getClass();
        if (i2 > i) {
            for (int i3 = i + 1; i3 <= i2; i3++) {
                try {
                    Collection collection = (Collection) hm.c.f11830a.get(Integer.valueOf(i3));
                    if (collection != null) {
                        Iterator it = collection.iterator();
                        while (it.hasNext()) {
                            ((DatabaseScript) it.next()).runScript(sQLiteDatabase);
                        }
                    }
                } catch (Throwable unused) {
                }
            }
            z = false;
        } else {
            z = true;
        }
        if (z || (!hm.d.a(sQLiteDatabase))) {
            try {
                hm.b.runScript(sQLiteDatabase);
            } catch (Throwable unused2) {
            }
            try {
                hm.f11182a.runScript(sQLiteDatabase);
            } catch (Throwable unused3) {
            }
        }
    }
}
