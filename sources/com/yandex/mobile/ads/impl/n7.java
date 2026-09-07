package com.yandex.mobile.ads.impl;

import com.monetization.ads.quality.base.model.AdQualityVerificationError;
import com.monetization.ads.quality.base.model.configuration.AdQualityVerificationAdConfiguration;
import com.monetization.ads.quality.base.result.AdQualityVerificationResult;
import kotlin.jvm.internal.Intrinsics;
import kotlin.random.Random;

/* JADX INFO: loaded from: classes.dex */
public final class n7 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final d7 f9703a;

    public n7(d7 verificationPolicy) {
        Intrinsics.checkNotNullParameter(verificationPolicy, "verificationPolicy");
        this.f9703a = verificationPolicy;
    }

    public final AdQualityVerificationResult.NotVerified a(AdQualityVerificationAdConfiguration adConfiguration) {
        boolean zC;
        Intrinsics.checkNotNullParameter(adConfiguration, "adConfiguration");
        m7 m7Var = this.f9703a.a().get(adConfiguration.getVerifiableAdNetwork());
        int iB = m7Var != null ? m7Var.b() : this.f9703a.e();
        boolean z = true;
        if (m7Var != null) {
            zC = !m7Var.a();
        } else {
            zC = this.f9703a.c();
        }
        if (!this.f9703a.d().contains(adConfiguration.getAdUnitId()) && !this.f9703a.d().isEmpty()) {
            z = false;
        }
        if (!zC || !z) {
            return new AdQualityVerificationResult.NotVerified(new AdQualityVerificationError.DisabledError());
        }
        if (Random.INSTANCE.nextInt(0, 100) < iB) {
            return null;
        }
        return new AdQualityVerificationResult.NotVerified(new AdQualityVerificationError.LowUsagePercent());
    }
}
