package com.yandex.mobile.ads.impl;

import java.util.Iterator;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes9.dex */
public final class zu0 implements vg<ax0> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final dj0 f10851a;
    private final zw0 b;

    public zu0(dj0 imageAssetValueValidator, zw0 mediaValidator) {
        Intrinsics.checkNotNullParameter(imageAssetValueValidator, "imageAssetValueValidator");
        Intrinsics.checkNotNullParameter(mediaValidator, "mediaValidator");
        this.f10851a = imageAssetValueValidator;
        this.b = mediaValidator;
    }

    /* JADX WARN: Code duplicated, block: B:19:0x004d  */
    @Override // com.yandex.mobile.ads.impl.vg
    public final boolean a(ax0 ax0Var) {
        boolean z;
        boolean z2;
        ax0 value = ax0Var;
        Intrinsics.checkNotNullParameter(value, "value");
        List<uj0> listA = value.a();
        su0 media = value.b();
        if (listA == null) {
            z = false;
        } else {
            if (!listA.isEmpty()) {
                Iterator<T> it = listA.iterator();
                while (true) {
                    if (it.hasNext()) {
                        if (!this.f10851a.a((uj0) it.next())) {
                            z = false;
                        }
                    }
                }
            }
            z = true;
        }
        if (media != null) {
            this.b.getClass();
            Intrinsics.checkNotNullParameter(media, "media");
            if (media.a() > 0.0f) {
                z2 = true;
            } else {
                z2 = false;
            }
        } else {
            z2 = false;
        }
        if (listA == null || media == null) {
            if (listA != null) {
                return z;
            }
            if (media != null) {
                return z2;
            }
        } else if (z2 && z) {
            return true;
        }
        return false;
    }
}
