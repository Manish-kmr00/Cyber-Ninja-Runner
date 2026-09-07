package com.yandex.mobile.ads.impl;

import android.content.Context;
import com.monetization.ads.quality.base.AdQualityVerifierAdapter;
import com.monetization.ads.quality.base.model.configuration.AdQualityVerifierAdapterConfiguration;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
public final class q7 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final j7 f9990a;
    private final k7 b;
    private final o7 c;

    public final p7 a(Context context) {
        Object objM7904constructorimpl;
        Object x6Var;
        Intrinsics.checkNotNullParameter(context, "context");
        try {
            Result.Companion companion = Result.INSTANCE;
            int i = iw1.l;
            cu1 cu1VarA = iw1.a.a().a(context);
            b7 b7VarF = cu1VarA != null ? cu1VarA.f() : null;
            if (b7VarF == null || !b7VarF.e()) {
                op0.a(new Object[0]);
                x6Var = new x6();
            } else {
                this.b.getClass();
                AdQualityVerifierAdapterConfiguration adQualityVerifierAdapterConfigurationA = k7.a(b7VarF);
                this.f9990a.getClass();
                AdQualityVerifierAdapter adQualityVerifierAdapterA = j7.a();
                if (adQualityVerifierAdapterA == null) {
                    op0.a(new Object[0]);
                    x6Var = new x6();
                } else {
                    this.c.getClass();
                    d7 d7VarA = o7.a(b7VarF);
                    long verificationTimeoutInSec = 1 + adQualityVerifierAdapterConfigurationA.getVerificationTimeoutInSec();
                    n7 n7Var = new n7(d7VarA);
                    h7 h7Var = new h7(d7VarA);
                    op0.a(new Object[0]);
                    x6Var = new y6(adQualityVerifierAdapterA, adQualityVerifierAdapterConfigurationA, verificationTimeoutInSec, n7Var, h7Var);
                }
            }
            objM7904constructorimpl = Result.m7904constructorimpl(x6Var);
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            objM7904constructorimpl = Result.m7904constructorimpl(ResultKt.createFailure(th));
        }
        Throwable thM7907exceptionOrNullimpl = Result.m7907exceptionOrNullimpl(objM7904constructorimpl);
        if (thM7907exceptionOrNullimpl != null) {
            String str = "Created empty ad quality verifier with throwable: " + thM7907exceptionOrNullimpl.getMessage();
            op0.a(new Object[0]);
            objM7904constructorimpl = new x6();
        }
        return (p7) objM7904constructorimpl;
    }

    public /* synthetic */ q7(int i) {
        this(new j7(), new k7(), new o7());
    }

    public q7(j7 verifierAdapterCreator, k7 verifierAdapterConfigurationFactory, o7 adQualityVerifierVerificationPolicyFactory) {
        Intrinsics.checkNotNullParameter(verifierAdapterCreator, "verifierAdapterCreator");
        Intrinsics.checkNotNullParameter(verifierAdapterConfigurationFactory, "verifierAdapterConfigurationFactory");
        Intrinsics.checkNotNullParameter(adQualityVerifierVerificationPolicyFactory, "adQualityVerifierVerificationPolicyFactory");
        this.f9990a = verifierAdapterCreator;
        this.b = verifierAdapterConfigurationFactory;
        this.c = adQualityVerifierVerificationPolicyFactory;
    }
}
