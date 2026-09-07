package io.appmetrica.analytics.impl;

import android.content.ContentResolver;
import android.database.Cursor;
import android.net.Uri;
import android.text.TextUtils;
import java.util.concurrent.Callable;

/* JADX INFO: loaded from: classes4.dex */
public final class Fa implements Callable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Ga f11138a;

    public Fa(Ga ga) {
        this.f11138a = ga;
    }

    @Override // java.util.concurrent.Callable
    public final Object call() {
        Uri uri = Uri.parse("content://com.huawei.appmarket.commondata/item/5");
        ContentResolver contentResolver = this.f11138a.f11159a.getContentResolver();
        Ga ga = this.f11138a;
        ga.b = contentResolver.query(uri, null, null, new String[]{ga.f11159a.getPackageName()}, null);
        Cursor cursor = this.f11138a.b;
        if (cursor != null && cursor.moveToFirst()) {
            String string = this.f11138a.b.getString(0);
            if (!TextUtils.isEmpty(string)) {
                return new C4044cg(string, this.f11138a.b.getLong(1), this.f11138a.b.getLong(2), EnumC4019bg.d);
            }
        }
        return null;
    }
}
