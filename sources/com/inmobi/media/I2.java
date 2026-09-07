package com.inmobi.media;

import android.content.ContentValues;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes6.dex */
public final class I2 extends D1 {
    public I2() {
        super("c_data", "(id INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, e_data TEXT NOT NULL, timestamp INTEGER NOT NULL )");
        Intrinsics.checkNotNullExpressionValue("I2", "getSimpleName(...)");
    }

    @Override // com.inmobi.media.D1
    public final Object a(ContentValues contentValues) {
        Intrinsics.checkNotNullParameter(contentValues, "contentValues");
        String asString = contentValues.getAsString("e_data");
        Intrinsics.checkNotNullExpressionValue(asString, "getAsString(...)");
        Long asLong = contentValues.getAsLong("timestamp");
        Intrinsics.checkNotNullExpressionValue(asLong, "getAsLong(...)");
        return new F3(asString, asLong.longValue());
    }

    @Override // com.inmobi.media.D1
    public final ContentValues b(Object obj) {
        F3 data = (F3) obj;
        Intrinsics.checkNotNullParameter(data, "data");
        ContentValues contentValues = new ContentValues();
        contentValues.put("e_data", data.f3066a);
        contentValues.put("timestamp", Long.valueOf(data.b));
        return contentValues;
    }
}
