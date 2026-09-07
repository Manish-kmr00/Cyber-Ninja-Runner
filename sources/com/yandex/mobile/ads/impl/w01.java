package com.yandex.mobile.ads.impl;

import com.yandex.div.BuildConfig;
import com.yandex.div.core.DivKit;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes12.dex */
public final class w01 extends d11 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final boolean f10523a;
    private final ab2 b;

    @Override // com.yandex.mobile.ads.impl.d11
    protected final void a(Function1<? super xo0, Unit> onValidationFailed) {
        Intrinsics.checkNotNullParameter(onValidationFailed, "onValidationFailed");
        try {
            ab2 ab2Var = this.b;
            String versionName = DivKit.INSTANCE.getVersionName();
            ab2Var.getClass();
            za2 za2VarA = ab2.a(versionName);
            this.b.getClass();
            za2 za2VarA2 = ab2.a(BuildConfig.VERSION_NAME);
            Integer numValueOf = za2VarA2 != null ? Integer.valueOf(za2VarA2.a()) : null;
            if (numValueOf != null) {
                int iIntValue = numValueOf.intValue();
                if (za2VarA == null || !(this.f10523a || za2VarA.a() == iIntValue)) {
                    String strA = z0.a(new Object[]{numValueOf, za2VarA != null ? Integer.valueOf(za2VarA.a()) : null}, 2, "Unsupported DivKit major version. Expected: %s. Actual: %s", "format(...)");
                    onValidationFailed.invoke(new xo0(strA, strA));
                    throw null;
                }
            }
        } catch (NoClassDefFoundError unused) {
            String strA2 = z0.a(new Object[0], 0, "DivKit is unavailable. Please check your buildscripts for exclusion rules for 'com.yandex.div:div'", "format(...)");
            onValidationFailed.invoke(new xo0(strA2, strA2));
            throw null;
        }
    }

    public /* synthetic */ w01() {
        this(new ab2());
    }

    public w01(ab2 versionNameParser) {
        Intrinsics.checkNotNullParameter(versionNameParser, "versionNameParser");
        this.f10523a = false;
        this.b = versionNameParser;
    }
}
