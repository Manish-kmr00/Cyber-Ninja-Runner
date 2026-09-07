package com.smaato.sdk.core.appconfigcheck;

import com.smaato.sdk.core.log.LogDomain;
import com.smaato.sdk.core.log.Logger;
import com.smaato.sdk.core.util.AppMetaData;
import com.smaato.sdk.core.util.Joiner;
import com.smaato.sdk.core.util.Objects;
import com.smaato.sdk.core.util.collections.Lists;
import com.smaato.sdk.core.util.fi.Predicate;
import java.util.List;

/* JADX INFO: loaded from: classes9.dex */
public final class AppConfigChecker {
    private final AppMetaData appMetaData;
    private final ExpectedManifestEntries expectedManifestEntries;
    private final Logger logger;

    public AppConfigChecker(Logger logger, ExpectedManifestEntries expectedManifestEntries, AppMetaData appMetaData) {
        this.logger = (Logger) Objects.requireNonNull(logger, "Parameter logger cannot be null for AppManifestConfigChecker::new");
        this.expectedManifestEntries = (ExpectedManifestEntries) Objects.requireNonNull(expectedManifestEntries, "Parameter expectedManifestEntries cannot be null for AppManifestConfigChecker::new");
        this.appMetaData = (AppMetaData) Objects.requireNonNull(appMetaData, "Parameter permissionChecker cannot be null for AppManifestConfigChecker::new");
    }

    public AppConfigCheckResult check() {
        return new AppConfigCheckResult(allMandatoryPermissionsDeclared(), allActivitiesDeclared());
    }

    private boolean allMandatoryPermissionsDeclared() {
        List listFilter = Lists.filter(this.expectedManifestEntries.getPermissionsMandatory(), new Predicate() { // from class: com.smaato.sdk.core.appconfigcheck.AppConfigChecker$$ExternalSyntheticLambda1
            @Override // com.smaato.sdk.core.util.fi.Predicate
            public final boolean test(Object obj) {
                return this.f$0.m5515x6f0f9cfc((String) obj);
            }
        });
        boolean zIsEmpty = listFilter.isEmpty();
        if (!zIsEmpty) {
            this.logger.error(LogDomain.APP_CONFIG_CHECK, "Mandatory permissions are not granted: %s", Joiner.join(", ", listFilter));
        }
        return zIsEmpty;
    }

    /* JADX INFO: renamed from: lambda$allMandatoryPermissionsDeclared$0$com-smaato-sdk-core-appconfigcheck-AppConfigChecker, reason: not valid java name */
    /* synthetic */ boolean m5515x6f0f9cfc(String str) {
        return !this.appMetaData.isPermissionGranted(str);
    }

    private boolean allActivitiesDeclared() {
        List listFilter = Lists.filter(this.expectedManifestEntries.getActivities(), new Predicate() { // from class: com.smaato.sdk.core.appconfigcheck.AppConfigChecker$$ExternalSyntheticLambda0
            @Override // com.smaato.sdk.core.util.fi.Predicate
            public final boolean test(Object obj) {
                return this.f$0.m5514x7c6ebeff((Class) obj);
            }
        });
        boolean zIsEmpty = listFilter.isEmpty();
        if (!zIsEmpty) {
            this.logger.error(LogDomain.APP_CONFIG_CHECK, "Mandatory activities are not declared in the application manifest: %s", Joiner.join(", ", listFilter));
        }
        return zIsEmpty;
    }

    /* JADX INFO: renamed from: lambda$allActivitiesDeclared$1$com-smaato-sdk-core-appconfigcheck-AppConfigChecker, reason: not valid java name */
    /* synthetic */ boolean m5514x7c6ebeff(Class cls) {
        return !this.appMetaData.isActivityRegistered(cls);
    }
}
