package com.yandex.mobile.ads.impl;

import android.content.Context;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes6.dex */
public final class zq implements z00 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final z00[] f10845a;

    public zq(z00... designConstraints) {
        Intrinsics.checkNotNullParameter(designConstraints, "designConstraints");
        this.f10845a = designConstraints;
    }

    @Override // com.yandex.mobile.ads.impl.z00
    public final boolean a(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        for (z00 z00Var : this.f10845a) {
            if (!z00Var.a(context)) {
                return false;
            }
        }
        return true;
    }
}
