package com.yandex.mobile.ads.impl;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes6.dex */
public final class wl {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final bw0 f10572a;

    public wl(bw0 referenceMediaFileInfo) {
        Intrinsics.checkNotNullParameter(referenceMediaFileInfo, "referenceMediaFileInfo");
        this.f10572a = referenceMediaFileInfo;
    }

    public final int a(aw0 mediaFile) {
        Intrinsics.checkNotNullParameter(mediaFile, "mediaFile");
        int iB = mediaFile.b();
        if (iB != 0) {
            return iB;
        }
        return (int) (((mediaFile.d() * mediaFile.h()) / (this.f10572a.b() * this.f10572a.c())) * this.f10572a.a());
    }
}
