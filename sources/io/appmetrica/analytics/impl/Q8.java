package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreapi.internal.data.IBinaryDataHelper;
import io.appmetrica.analytics.coreutils.internal.collection.CollectionUtils;
import io.appmetrica.analytics.protobuf.nano.MessageNano;

/* JADX INFO: loaded from: classes.dex */
public final class Q8 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f11308a;
    public final V8 b;
    public S8 c;

    public Q8(V8 v8, int i) {
        this.f11308a = i;
        this.b = v8;
    }

    public final void a() {
        S8 s8;
        V8 v8 = this.b;
        v8.getClass();
        try {
            byte[] bArr = v8.c.get("event_hashes");
            if (bArr == null || bArr.length == 0) {
                T8 t8 = v8.f11390a;
                v8.b.getClass();
                A9 a9 = new A9();
                t8.getClass();
                s8 = new S8(a9.f11057a, a9.b, a9.c, CollectionUtils.hashSetFromIntArray(a9.d));
            } else {
                T8 t9 = v8.f11390a;
                A9 state = v8.b.toState(bArr);
                t9.getClass();
                s8 = new S8(state.f11057a, state.b, state.c, CollectionUtils.hashSetFromIntArray(state.d));
            }
        } catch (Throwable unused) {
            T8 t10 = v8.f11390a;
            v8.b.getClass();
            A9 a10 = new A9();
            t10.getClass();
            s8 = new S8(a10.f11057a, a10.b, a10.c, CollectionUtils.hashSetFromIntArray(a10.d));
        }
        this.c = s8;
        int i = s8.c;
        int i2 = this.f11308a;
        if (i != i2) {
            s8.c = i2;
            s8.d = 0;
            V8 v9 = this.b;
            IBinaryDataHelper iBinaryDataHelper = v9.c;
            U8 u8 = v9.b;
            v9.f11390a.getClass();
            A9 a9A = T8.a(s8);
            u8.getClass();
            iBinaryDataHelper.insert("event_hashes", MessageNano.toByteArray(a9A));
        }
    }
}
