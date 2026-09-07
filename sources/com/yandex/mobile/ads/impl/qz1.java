package com.yandex.mobile.ads.impl;

import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes9.dex */
public final class qz1 extends k41 {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public qz1(List<? extends ig<?>> assets, s71 configuration) {
        super(assets, configuration);
        Intrinsics.checkNotNullParameter(assets, "assets");
        Intrinsics.checkNotNullParameter(configuration, "configuration");
    }

    @Override // com.yandex.mobile.ads.impl.k41
    public final boolean a(w71.a validator, List<? extends ig<?>> assets) {
        Intrinsics.checkNotNullParameter(validator, "validator");
        Intrinsics.checkNotNullParameter(assets, "assets");
        b().c();
        return validator.a(assets);
    }
}
