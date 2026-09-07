package com.inmobi.media;

import android.content.ContentValues;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: renamed from: com.inmobi.media.v2, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes11.dex */
public final class C3592v2 extends Lambda implements Function1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final C3592v2 f3452a = new C3592v2();

    public C3592v2() {
        super(1);
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Object obj) {
        ContentValues contentValues = (ContentValues) obj;
        Intrinsics.checkNotNullParameter(contentValues, "contentValues");
        if (contentValues.getAsString("config_value") != null) {
            return contentValues.getAsLong("update_ts");
        }
        return null;
    }
}
