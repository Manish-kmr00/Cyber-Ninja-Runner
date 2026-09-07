package com.inmobi.media;

import android.content.ContentValues;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: renamed from: com.inmobi.media.b5, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes8.dex */
public final class C3311b5 extends K3 {
    public C3311b5() {
        super("crash", "(id INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, componentType TEXT NOT NULL, eventId TEXT NOT NULL, eventType TEXT NOT NULL, payload TEXT NOT NULL, ts TEXT NOT NULL)");
    }

    @Override // com.inmobi.media.D1
    public final Object a(ContentValues contentValues) {
        Intrinsics.checkNotNullParameter(contentValues, "contentValues");
        Intrinsics.checkNotNullParameter(contentValues, "contentValues");
        String asString = contentValues.getAsString("eventId");
        String asString2 = contentValues.getAsString("eventType");
        String asString3 = contentValues.getAsString("componentType");
        String asString4 = contentValues.getAsString("payload");
        String asString5 = contentValues.getAsString("ts");
        Intrinsics.checkNotNullExpressionValue(asString5, "getAsString(...)");
        long j = Long.parseLong(asString5);
        Intrinsics.checkNotNull(asString);
        Intrinsics.checkNotNull(asString3);
        Intrinsics.checkNotNull(asString2);
        C3353e5 c3353e5 = new C3353e5(asString, asString3, asString2, asString4);
        c3353e5.b = j;
        Integer asInteger = contentValues.getAsInteger("id");
        Intrinsics.checkNotNullExpressionValue(asInteger, "getAsInteger(...)");
        c3353e5.c = asInteger.intValue();
        return c3353e5;
    }

    @Override // com.inmobi.media.D1
    public final ContentValues b(Object obj) {
        C3353e5 item = (C3353e5) obj;
        Intrinsics.checkNotNullParameter(item, "item");
        item.getClass();
        ContentValues contentValues = new ContentValues();
        contentValues.put("eventId", item.e);
        contentValues.put("componentType", item.f);
        contentValues.put("eventType", item.f3054a);
        contentValues.put("payload", item.a());
        contentValues.put("ts", String.valueOf(item.b));
        return contentValues;
    }
}
