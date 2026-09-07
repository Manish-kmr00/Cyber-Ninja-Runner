package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreapi.internal.data.Converter;
import io.appmetrica.analytics.protobuf.nano.InvalidProtocolBufferNanoException;
import io.appmetrica.analytics.protobuf.nano.MessageNano;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: renamed from: io.appmetrica.analytics.impl.y7, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes8.dex */
public final class C4583y7 implements Converter {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final C4558x7 f11855a;

    public C4583y7() {
        this(null, 1, 0 == true ? 1 : 0);
    }

    public final byte[] a(C4608z7 c4608z7) {
        return MessageNano.toByteArray(this.f11855a.fromModel(c4608z7));
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    public final Object fromModel(Object obj) {
        return MessageNano.toByteArray(this.f11855a.fromModel((C4608z7) obj));
    }

    public C4583y7(C4558x7 c4558x7) {
        this.f11855a = c4558x7;
    }

    /* JADX WARN: Code duplicated, block: B:5:0x000f A[Catch: InvalidProtocolBufferNanoException -> 0x0015, TRY_LEAVE, TryCatch #0 {InvalidProtocolBufferNanoException -> 0x0015, blocks: (B:3:0x0002, B:5:0x000f), top: B:10:0x0002 }] */
    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public final C4608z7 toModel(byte[] bArr) {
        C4533w7 c4533w7;
        if (bArr != null) {
            try {
                c4533w7 = (C4533w7) MessageNano.mergeFrom(new C4533w7(), bArr);
                if (c4533w7 == null) {
                    c4533w7 = new C4533w7();
                }
            } catch (InvalidProtocolBufferNanoException unused) {
                c4533w7 = new C4533w7();
            }
        } else {
            c4533w7 = new C4533w7();
        }
        return this.f11855a.toModel(c4533w7);
    }

    public /* synthetic */ C4583y7(C4558x7 c4558x7, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? new C4558x7(null, 1, null) : c4558x7);
    }
}
