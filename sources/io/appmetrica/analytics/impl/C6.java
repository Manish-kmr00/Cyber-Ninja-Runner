package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreapi.internal.data.ProtobufConverter;
import io.appmetrica.analytics.coreutils.internal.StringUtils;

/* JADX INFO: loaded from: classes13.dex */
public final class C6 implements ProtobufConverter {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final C4467tg f11084a;

    public C6() {
        this(new C4467tg());
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public final C4184i6 fromModel(B6 b6) {
        C4184i6 c4184i6FromModel = this.f11084a.fromModel(b6.f11072a);
        c4184i6FromModel.g = 1;
        C4159h6 c4159h6 = new C4159h6();
        c4184i6FromModel.h = c4159h6;
        c4159h6.f11580a = StringUtils.correctIllFormedString(b6.b);
        return c4184i6FromModel;
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    public final Object toModel(Object obj) {
        throw new UnsupportedOperationException();
    }

    public C6(C4467tg c4467tg) {
        this.f11084a = c4467tg;
    }

    public final B6 a(C4184i6 c4184i6) {
        throw new UnsupportedOperationException();
    }
}
