package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreapi.internal.data.Converter;
import io.appmetrica.analytics.protobuf.nano.InvalidProtocolBufferNanoException;
import io.appmetrica.analytics.protobuf.nano.MessageNano;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: renamed from: io.appmetrica.analytics.impl.k7, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes9.dex */
public final class C4234k7 implements Converter {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final C4209j7 f11632a;

    public C4234k7() {
        this(null, 1, 0 == true ? 1 : 0);
    }

    public final byte[] a(C4259l7 c4259l7) {
        return MessageNano.toByteArray(this.f11632a.fromModel(c4259l7));
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    public final Object fromModel(Object obj) {
        return MessageNano.toByteArray(this.f11632a.fromModel((C4259l7) obj));
    }

    public C4234k7(C4209j7 c4209j7) {
        this.f11632a = c4209j7;
    }

    /* JADX WARN: Code duplicated, block: B:5:0x000f A[Catch: InvalidProtocolBufferNanoException -> 0x0015, TRY_LEAVE, TryCatch #0 {InvalidProtocolBufferNanoException -> 0x0015, blocks: (B:3:0x0002, B:5:0x000f), top: B:10:0x0002 }] */
    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public final C4259l7 toModel(byte[] bArr) {
        C4483u7 c4483u7;
        if (bArr != null) {
            try {
                c4483u7 = (C4483u7) MessageNano.mergeFrom(new C4483u7(), bArr);
                if (c4483u7 == null) {
                    c4483u7 = new C4483u7();
                }
            } catch (InvalidProtocolBufferNanoException unused) {
                c4483u7 = new C4483u7();
            }
        } else {
            c4483u7 = new C4483u7();
        }
        return this.f11632a.toModel(c4483u7);
    }

    public /* synthetic */ C4234k7(C4209j7 c4209j7, int i, DefaultConstructorMarker defaultConstructorMarker) {
        if ((i & 1) != 0) {
            c4209j7 = new C4209j7(null, 0 == true ? 1 : 0, 3, 0 == true ? 1 : 0);
        }
        this(c4209j7);
    }
}
