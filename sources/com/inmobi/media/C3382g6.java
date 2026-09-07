package com.inmobi.media;

import android.content.ContentValues;
import io.ktor.http.ContentDisposition;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: renamed from: com.inmobi.media.g6, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes9.dex */
public final class C3382g6 extends D1 {
    public O4 b;

    static {
        Intrinsics.checkNotNullExpressionValue("g6", "getSimpleName(...)");
    }

    public C3382g6() {
        super("logs_v2", "(id INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, filename TEXT NOT NULL, saveTimestamp INTEGER NOT NULL, retryCount INTEGER NOT NULL, hasLoggerFinished INTEGER NOT NULL, checkpoints INTEGER NOT NULL,lastRetryTimestamp INTEGER NOT NULL )");
    }

    @Override // com.inmobi.media.D1
    public final Object a(ContentValues contentValues) {
        Intrinsics.checkNotNullParameter(contentValues, "contentValues");
        String asString = contentValues.getAsString(ContentDisposition.Parameters.FileName);
        Long asLong = contentValues.getAsLong("saveTimestamp");
        Integer asInteger = contentValues.getAsInteger("retryCount");
        Long asLong2 = contentValues.getAsLong("lastRetryTimestamp");
        Integer asInteger2 = contentValues.getAsInteger("checkpoints");
        Integer asInteger3 = contentValues.getAsInteger("hasLoggerFinished");
        boolean z = asInteger3 != null && asInteger3.intValue() == 1;
        Intrinsics.checkNotNull(asString);
        Intrinsics.checkNotNull(asLong);
        long jLongValue = asLong.longValue();
        Intrinsics.checkNotNull(asInteger);
        int iIntValue = asInteger.intValue();
        Intrinsics.checkNotNull(asLong2);
        long jLongValue2 = asLong2.longValue();
        Intrinsics.checkNotNull(asInteger2);
        return new C3368f6(asString, jLongValue, iIntValue, jLongValue2, z, asInteger2.intValue());
    }

    @Override // com.inmobi.media.D1
    public final ContentValues b(Object obj) {
        C3368f6 item = (C3368f6) obj;
        Intrinsics.checkNotNullParameter(item, "item");
        ContentValues contentValues = new ContentValues();
        contentValues.put(ContentDisposition.Parameters.FileName, item.f3312a);
        contentValues.put("saveTimestamp", Long.valueOf(item.b));
        contentValues.put("retryCount", Integer.valueOf(item.c));
        contentValues.put("lastRetryTimestamp", Long.valueOf(item.d));
        contentValues.put("checkpoints", Integer.valueOf(item.f));
        contentValues.put("hasLoggerFinished", Integer.valueOf(item.e ? 1 : 0));
        return contentValues;
    }

    public final void b(C3368f6 data) {
        Intrinsics.checkNotNullParameter(data, "data");
        b(data, "filename=\"" + data.f3312a + '\"', null);
        if (this.b != null) {
            O4.a();
        }
    }

    public final void a(C3368f6 data) {
        Intrinsics.checkNotNullParameter(data, "data");
        a("filename=\"" + data.f3312a + '\"', null);
    }
}
