package com.yandex.mobile.ads.impl;

import android.content.Context;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final class rx0 implements m51 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final a f10150a;

    public interface a {
        void a(l51 l51Var);
    }

    public rx0(a createEventControllerListener) {
        Intrinsics.checkNotNullParameter(createEventControllerListener, "createEventControllerListener");
        this.f10150a = createEventControllerListener;
    }

    @Override // com.yandex.mobile.ads.impl.m51
    public final l51 a(Context context, o8 adResponse, o3 adConfiguration) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(adConfiguration, "adConfiguration");
        Intrinsics.checkNotNullParameter(adResponse, "adResponse");
        l51 l51Var = new l51(context, adConfiguration, adResponse);
        this.f10150a.a(l51Var);
        return l51Var;
    }
}
