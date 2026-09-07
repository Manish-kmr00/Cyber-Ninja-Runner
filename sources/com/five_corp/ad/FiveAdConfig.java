package com.five_corp.ad;

import java.util.EnumSet;
import java.util.Objects;

/* JADX INFO: loaded from: classes12.dex */
public class FiveAdConfig {
    public final String appId;
    public FiveAdAgeRating fiveAdAgeRating;
    public NeedChildDirectedTreatment needChildDirectedTreatment;
    public NeedGdprNonPersonalizedAdsTreatment needGdprNonPersonalizedAdsTreatment;

    @Deprecated
    public EnumSet<FiveAdFormat> formats = EnumSet.noneOf(FiveAdFormat.class);
    public boolean isTest = false;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f1245a = 1;

    public FiveAdConfig(String str) {
        this.appId = str;
    }

    public FiveAdConfig deepCopy() {
        FiveAdConfig fiveAdConfig = new FiveAdConfig(this.appId);
        fiveAdConfig.isTest = this.isTest;
        fiveAdConfig.needGdprNonPersonalizedAdsTreatment = getNeedGdprNonPersonalizedAdsTreatment();
        fiveAdConfig.needChildDirectedTreatment = getNeedChildDirectedTreatment();
        fiveAdConfig.fiveAdAgeRating = getFiveAdAgeRating();
        fiveAdConfig.f1245a = this.f1245a;
        return fiveAdConfig;
    }

    public void enableSoundByDefault(boolean z) {
        this.f1245a = z ? 2 : 3;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        FiveAdConfig fiveAdConfig = (FiveAdConfig) obj;
        if (this.isTest != fiveAdConfig.isTest) {
            return false;
        }
        return Objects.equals(this.appId, fiveAdConfig.appId);
    }

    public FiveAdAgeRating getFiveAdAgeRating() {
        FiveAdAgeRating fiveAdAgeRating = this.fiveAdAgeRating;
        return fiveAdAgeRating == null ? FiveAdAgeRating.UNSPECIFIED : fiveAdAgeRating;
    }

    public NeedChildDirectedTreatment getNeedChildDirectedTreatment() {
        NeedChildDirectedTreatment needChildDirectedTreatment = this.needChildDirectedTreatment;
        return needChildDirectedTreatment == null ? NeedChildDirectedTreatment.UNSPECIFIED : needChildDirectedTreatment;
    }

    public NeedGdprNonPersonalizedAdsTreatment getNeedGdprNonPersonalizedAdsTreatment() {
        NeedGdprNonPersonalizedAdsTreatment needGdprNonPersonalizedAdsTreatment = this.needGdprNonPersonalizedAdsTreatment;
        return needGdprNonPersonalizedAdsTreatment == null ? NeedGdprNonPersonalizedAdsTreatment.UNSPECIFIED : needGdprNonPersonalizedAdsTreatment;
    }

    public int hashCode() {
        String str = this.appId;
        return ((str != null ? str.hashCode() : 0) * 31) + (this.isTest ? 1 : 0);
    }
}
