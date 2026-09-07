package io.appmetrica.analytics.impl;

import android.content.Context;
import io.appmetrica.analytics.coreapi.internal.data.IBinaryDataHelper;

/* JADX INFO: loaded from: classes3.dex */
public final class V8 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final T8 f11390a;
    public final U8 b;
    public final IBinaryDataHelper c;

    public V8(Context context, C4108f5 c4108f5) {
        this(new U8(), new T8(), C4135g7.a(context).a(c4108f5));
    }

    public V8(U8 u8, T8 t8, IBinaryDataHelper iBinaryDataHelper) {
        this.b = u8;
        this.f11390a = t8;
        this.c = iBinaryDataHelper;
    }
}
