package com.yandex.mobile.ads.impl;

import com.adjust.sdk.Constants;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
public final class sq {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private l50 f10231a;
    private jc b;
    private final List<String> c;

    public /* synthetic */ sq() {
        this(new jc(), new l50());
    }

    public sq(jc advertisingConfiguration, l50 environmentConfiguration) {
        Intrinsics.checkNotNullParameter(environmentConfiguration, "environmentConfiguration");
        Intrinsics.checkNotNullParameter(advertisingConfiguration, "advertisingConfiguration");
        this.f10231a = environmentConfiguration;
        this.b = advertisingConfiguration;
        this.c = CollectionsKt.listOf((Object[]) new String[]{Constants.SMALL, "medium", Constants.LARGE});
    }

    public final l50 b() {
        return this.f10231a;
    }

    public final jc a() {
        return this.b;
    }

    public final void a(jc jcVar) {
        Intrinsics.checkNotNullParameter(jcVar, "<set-?>");
        this.b = jcVar;
    }

    public final List<String> c() {
        return this.c;
    }

    public final void a(l50 l50Var) {
        Intrinsics.checkNotNullParameter(l50Var, "<set-?>");
        this.f10231a = l50Var;
    }
}
