package com.smaato.sdk.core.appconfigcheck;

/* JADX INFO: loaded from: classes13.dex */
public final class AppConfigCheckResult {
    private final boolean allActivitiesDeclared;
    private final boolean allMandatoryPermissionsDeclared;

    AppConfigCheckResult(boolean z, boolean z2) {
        this.allMandatoryPermissionsDeclared = z;
        this.allActivitiesDeclared = z2;
    }

    public boolean isAppConfiguredProperly() {
        return this.allMandatoryPermissionsDeclared && this.allActivitiesDeclared;
    }

    boolean allMandatoryPermissionsDeclared() {
        return this.allMandatoryPermissionsDeclared;
    }

    boolean allActivitiesDeclared() {
        return this.allActivitiesDeclared;
    }
}
