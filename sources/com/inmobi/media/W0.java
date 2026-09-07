package com.inmobi.media;

import android.content.ContentValues;
import java.util.ArrayList;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes7.dex */
public final class W0 extends D1 {
    public W0() {
        super("asset", "(id INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, pending_attempts INTEGER NOT NULL, url TEXT NOT NULL, disk_uri TEXT, ts TEXT NOT NULL, created_ts TEXT NOT NULL, ttl TEXT NOT NULL, soft_ttl TEXT NOT NULL)");
    }

    @Override // com.inmobi.media.D1
    public final Object a(ContentValues contentValues) {
        Intrinsics.checkNotNullParameter(contentValues, "contentValues");
        Integer asInteger = contentValues.getAsInteger("id");
        Integer asInteger2 = contentValues.getAsInteger("pending_attempts");
        String asString = contentValues.getAsString("url");
        String asString2 = contentValues.getAsString("disk_uri");
        Long asLong = contentValues.getAsLong("ts");
        Long asLong2 = contentValues.getAsLong("created_ts");
        Long asLong3 = contentValues.getAsLong("ttl");
        Long asLong4 = contentValues.getAsLong("soft_ttl");
        Intrinsics.checkNotNull(asInteger);
        int iIntValue = asInteger.intValue();
        Intrinsics.checkNotNull(asString);
        Intrinsics.checkNotNull(asInteger2);
        int iIntValue2 = asInteger2.intValue();
        Intrinsics.checkNotNull(asLong);
        long jLongValue = asLong.longValue();
        Intrinsics.checkNotNull(asLong2);
        long jLongValue2 = asLong2.longValue();
        Intrinsics.checkNotNull(asLong3);
        long jLongValue3 = asLong3.longValue();
        Intrinsics.checkNotNull(asLong4);
        return new C3417j(iIntValue, asString, asString2, iIntValue2, jLongValue, jLongValue2, jLongValue3, asLong4.longValue());
    }

    @Override // com.inmobi.media.D1
    public final ContentValues b(Object obj) {
        C3417j adAsset = (C3417j) obj;
        Intrinsics.checkNotNullParameter(adAsset, "adAsset");
        ContentValues contentValues = new ContentValues();
        contentValues.put("id", Integer.valueOf(adAsset.f3343a));
        contentValues.put("url", adAsset.b);
        contentValues.put("disk_uri", adAsset.c);
        contentValues.put("pending_attempts", Integer.valueOf(adAsset.d));
        contentValues.put("ts", String.valueOf(adAsset.e));
        contentValues.put("created_ts", String.valueOf(adAsset.f));
        contentValues.put("ttl", String.valueOf(adAsset.g));
        contentValues.put("soft_ttl", String.valueOf(adAsset.h));
        return contentValues;
    }

    public final ArrayList a() {
        ArrayList arrayListA = D1.a(this, null, null, null, null, "created_ts DESC ", null, 47);
        ArrayList<C3417j> arrayList = new ArrayList();
        for (Object obj : arrayListA) {
            C3417j c3417j = (C3417j) obj;
            if (c3417j != null && c3417j.a()) {
                arrayList.add(obj);
            }
        }
        ArrayList arrayList2 = new ArrayList();
        for (C3417j c3417j2 : arrayList) {
            if (c3417j2 != null) {
                arrayList2.add(c3417j2);
            }
        }
        return arrayList2;
    }

    public final ArrayList b() {
        ArrayList arrayListA = D1.a(this, null, null, null, null, "ts ASC ", null, 47);
        ArrayList<C3417j> arrayList = new ArrayList();
        for (Object obj : arrayListA) {
            C3417j c3417j = (C3417j) obj;
            if (c3417j != null && !c3417j.a()) {
                arrayList.add(obj);
            }
        }
        ArrayList arrayList2 = new ArrayList();
        for (C3417j c3417j2 : arrayList) {
            if (c3417j2 != null) {
                arrayList2.add(c3417j2);
            }
        }
        return arrayList2;
    }

    public final C3417j a(String remoteUrl) {
        Intrinsics.checkNotNullParameter(remoteUrl, "remoteUrl");
        ArrayList arrayListA = D1.a(this, "url=? ", new String[]{remoteUrl}, null, null, "created_ts DESC ", 1, 12);
        if (arrayListA.isEmpty()) {
            return null;
        }
        return (C3417j) arrayListA.get(0);
    }

    public final void a(C3417j asset) {
        Intrinsics.checkNotNullParameter(asset, "asset");
        b(asset, "url = ?", new String[]{asset.b.toString()});
    }

    public final C3417j b(String remoteUrl) {
        Intrinsics.checkNotNullParameter(remoteUrl, "remoteUrl");
        ArrayList arrayListA = D1.a(this, "url=? ", new String[]{remoteUrl}, null, null, "created_ts DESC ", 1, 12);
        if (arrayListA.isEmpty()) {
            return null;
        }
        return (C3417j) arrayListA.get(0);
    }
}
