package com.yandex.mobile.ads.impl;

import android.content.Context;
import com.yandex.mobile.ads.R;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes6.dex */
public final class pz0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Context f9965a;

    public /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f9966a;

        static {
            int[] iArr = new int[oz0.values().length];
            try {
                oz0 oz0Var = oz0.INVALID_MEDIATION_ADAPTER_VERSION;
                iArr[0] = 1;
            } catch (NoSuchFieldError unused) {
            }
            f9966a = iArr;
        }
    }

    public pz0(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        this.f9965a = context;
    }

    public final String a(oz0 oz0Var) {
        int i = oz0Var == null ? -1 : a.f9966a[oz0Var.ordinal()];
        if (i == -1) {
            return null;
        }
        if (i == 1) {
            return this.f9965a.getString(R.string.invalid_mediation_adapter_version);
        }
        throw new NoWhenBranchMatchedException();
    }
}
