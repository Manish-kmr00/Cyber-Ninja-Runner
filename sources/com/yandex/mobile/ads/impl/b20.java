package com.yandex.mobile.ads.impl;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes9.dex */
public final class b20 extends y10 {
    @Override // com.yandex.div.core.DivCustomContainerViewAdapter
    public final boolean isCustomTypeSupported(String type) {
        Intrinsics.checkNotNullParameter(type, "type");
        return Intrinsics.areEqual("video_progress", type);
    }
}
