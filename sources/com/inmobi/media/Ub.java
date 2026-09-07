package com.inmobi.media;

import android.content.ContentValues;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes7.dex */
public final class Ub extends K3 {
    public Ub() {
        super("telemetry", "(id INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, eventType TEXT NOT NULL, payload TEXT NOT NULL, eventSource TEXT NOT NULL, ts TEXT NOT NULL)");
    }

    @Override // com.inmobi.media.D1
    public final Object a(ContentValues contentValues) {
        Intrinsics.checkNotNullParameter(contentValues, "contentValues");
        Intrinsics.checkNotNullParameter(contentValues, "contentValues");
        String asString = contentValues.getAsString("eventType");
        String asString2 = contentValues.getAsString("payload");
        String asString3 = contentValues.getAsString("eventSource");
        String asString4 = contentValues.getAsString("ts");
        Intrinsics.checkNotNullExpressionValue(asString4, "getAsString(...)");
        long j = Long.parseLong(asString4);
        Intrinsics.checkNotNull(asString);
        Intrinsics.checkNotNull(asString3);
        Vb vb = new Vb(asString, asString2, asString3);
        vb.b = j;
        Integer asInteger = contentValues.getAsInteger("id");
        Intrinsics.checkNotNullExpressionValue(asInteger, "getAsInteger(...)");
        vb.c = asInteger.intValue();
        return vb;
    }

    @Override // com.inmobi.media.D1
    public final ContentValues b(Object obj) {
        Vb item = (Vb) obj;
        Intrinsics.checkNotNullParameter(item, "item");
        item.getClass();
        ContentValues contentValues = new ContentValues();
        contentValues.put("eventType", item.f3054a);
        contentValues.put("payload", item.a());
        contentValues.put("eventSource", item.e);
        contentValues.put("ts", String.valueOf(item.b));
        return contentValues;
    }
}
