package com.smaato.sdk.core;

import android.app.Application;
import android.content.Context;
import android.security.NetworkSecurityPolicy;
import android.util.Log;
import com.smaato.sdk.core.appconfigcheck.AppConfigChecker;
import com.smaato.sdk.core.appconfigcheck.ExpectedManifestEntries;
import com.smaato.sdk.core.ccpa.CcpaDataStorage;
import com.smaato.sdk.core.datacollector.DiDataCollectorLayer;
import com.smaato.sdk.core.di.ClassFactory;
import com.smaato.sdk.core.di.CoreDiNames;
import com.smaato.sdk.core.di.DiConstructor;
import com.smaato.sdk.core.di.DiRegistry;
import com.smaato.sdk.core.dns.DiDns;
import com.smaato.sdk.core.kpi.DiKpiDBHelper;
import com.smaato.sdk.core.locationaware.DiLocationAware;
import com.smaato.sdk.core.log.DiLogLayer;
import com.smaato.sdk.core.log.LogDomain;
import com.smaato.sdk.core.remoteconfig.global.GenericConfigProvider;
import com.smaato.sdk.core.util.AppMetaData;
import com.smaato.sdk.core.util.HeaderUtils;
import com.smaato.sdk.core.util.Objects;
import com.smaato.sdk.core.util.SdkConfigHintBuilder;
import com.smaato.sdk.core.util.appbackground.AppBackgroundDetector;
import com.smaato.sdk.core.util.fi.Consumer;
import com.smaato.sdk.core.violationreporter.DiAdQualityViolationReporterLayer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes12.dex */
class SmaatoInstance {
    private AdContentRating adContentRating;
    private Integer age;
    private DiConstructor diConstructor;
    private final List extensionConfigurations;
    private Gender gender;
    private Boolean isLgpdConsentEnabled;
    private String keywords;
    private String language;
    private LatLng latLng;
    private String mUnityVersion;
    private final String publisherId;
    private String region;
    private String searchQuery;
    private String zip;
    private boolean coppa = false;
    private boolean isAgeRestrictedUser = false;
    private boolean isGPSEnabled = false;
    private boolean isWatermarkEnabled = false;
    private boolean isCompanionAdSkippable = false;

    static /* synthetic */ Application lambda$createCoreOfCoreRegistry$2(Application application, DiConstructor diConstructor) {
        return application;
    }

    SmaatoInstance(Application application, Config config, List<DiRegistry> list, List<ExpectedManifestEntries> list2, String str) {
        this.publisherId = (String) Objects.requireNonNull(str, "Parameter PublisherId cannot be null for SmaatoInstance::new");
        this.adContentRating = ((Config) Objects.requireNonNull(config, "Parameter config cannot be null for SmaatoInstance::new")).getAdContentRating();
        this.mUnityVersion = ((Config) Objects.requireNonNull(config, "Parameter config cannot be null for SmaatoInstance::new")).getUnityVersion();
        this.extensionConfigurations = ((Config) Objects.requireNonNull(config, "Parameter config cannot be null for SmaatoInstance::new")).getExtensionConfigurations();
        this.diConstructor = initDi((Application) Objects.requireNonNull(application, "Parameter application cannot be null for SmaatoInstance::new"), config, (List) Objects.requireNonNull(list, "Parameter diRegistriesOfModules cannot be null for SmaatoInstance::new"), mergeExpectedManifestEntries(list2));
    }

    DiConstructor getDiConstructor() {
        return this.diConstructor;
    }

    private DiConstructor initDi(Application application, Config config, List list, ExpectedManifestEntries expectedManifestEntries) {
        HashSet hashSet = new HashSet(list);
        Collections.addAll(hashSet, createCoreOfCoreRegistry(application, expectedManifestEntries, isHttpsOnly(config), config.loggingEnabled()), DiLogLayer.createRegistry(config.loggingEnabled(), config.getConsoleLogLevel()), DiKpiDBHelper.createRegistry(application.getApplicationContext(), config.sessionTrackingDisabled()), DiDataCollectorLayer.createRegistry(), DiAdQualityViolationReporterLayer.createRegistry(), DiDns.createRegistry(), DiLocationAware.createRegistry());
        return DiConstructor.create(hashSet);
    }

    private boolean isHttpsOnly(Config config) {
        boolean zIsHttpsOnly = config.isHttpsOnly();
        if (zIsHttpsOnly || NetworkSecurityPolicy.getInstance().isCleartextTrafficPermitted()) {
            return zIsHttpsOnly;
        }
        Log.w(LogDomain.CORE.name(), "`httpsOnly` value overridden to TRUE, due to Network Security Configuration settings.");
        return true;
    }

    private DiRegistry createCoreOfCoreRegistry(final Application application, final ExpectedManifestEntries expectedManifestEntries, final boolean z, final boolean z2) {
        return DiRegistry.of(new Consumer() { // from class: com.smaato.sdk.core.SmaatoInstance$$ExternalSyntheticLambda1
            @Override // com.smaato.sdk.core.util.fi.Consumer
            public final void accept(Object obj) {
                SmaatoInstance.lambda$createCoreOfCoreRegistry$10(z, z2, application, expectedManifestEntries, (DiRegistry) obj);
            }
        });
    }

    static /* synthetic */ void lambda$createCoreOfCoreRegistry$10(final boolean z, final boolean z2, final Application application, final ExpectedManifestEntries expectedManifestEntries, DiRegistry diRegistry) {
        diRegistry.registerFactory(CoreDiNames.NAME_HTTPS_ONLY, Boolean.class, new ClassFactory() { // from class: com.smaato.sdk.core.SmaatoInstance$$ExternalSyntheticLambda0
            @Override // com.smaato.sdk.core.di.ClassFactory
            /* JADX INFO: renamed from: get */
            public final Object get2(DiConstructor diConstructor) {
                return Boolean.valueOf(z);
            }
        });
        diRegistry.registerFactory(CoreDiNames.NAME_IS_LOGGING_ENABLED, Boolean.class, new ClassFactory() { // from class: com.smaato.sdk.core.SmaatoInstance$$ExternalSyntheticLambda2
            @Override // com.smaato.sdk.core.di.ClassFactory
            /* JADX INFO: renamed from: get */
            public final Object get2(DiConstructor diConstructor) {
                return Boolean.valueOf(z2);
            }
        });
        diRegistry.registerFactory(Application.class, new ClassFactory() { // from class: com.smaato.sdk.core.SmaatoInstance$$ExternalSyntheticLambda3
            @Override // com.smaato.sdk.core.di.ClassFactory
            /* JADX INFO: renamed from: get */
            public final Object get2(DiConstructor diConstructor) {
                return SmaatoInstance.lambda$createCoreOfCoreRegistry$2(application, diConstructor);
            }
        });
        diRegistry.registerFactory(CoreDiNames.SOMA_API_URL, String.class, new ClassFactory() { // from class: com.smaato.sdk.core.SmaatoInstance$$ExternalSyntheticLambda4
            @Override // com.smaato.sdk.core.di.ClassFactory
            /* JADX INFO: renamed from: get */
            public final Object get2(DiConstructor diConstructor) {
                return ((GenericConfigProvider) diConstructor.get(GenericConfigProvider.class)).getConfiguration().getConfigUrls().getSomaUrl();
            }
        });
        diRegistry.registerSingletonFactory(AppMetaData.class, new ClassFactory() { // from class: com.smaato.sdk.core.SmaatoInstance$$ExternalSyntheticLambda5
            @Override // com.smaato.sdk.core.di.ClassFactory
            /* JADX INFO: renamed from: get */
            public final Object get2(DiConstructor diConstructor) {
                return SmaatoInstance.lambda$createCoreOfCoreRegistry$4(diConstructor);
            }
        });
        diRegistry.registerSingletonFactory(SdkConfigHintBuilder.class, new ClassFactory() { // from class: com.smaato.sdk.core.SmaatoInstance$$ExternalSyntheticLambda6
            @Override // com.smaato.sdk.core.di.ClassFactory
            /* JADX INFO: renamed from: get */
            public final Object get2(DiConstructor diConstructor) {
                return SmaatoInstance.lambda$createCoreOfCoreRegistry$5(diConstructor);
            }
        });
        diRegistry.registerSingletonFactory(AppConfigChecker.class, new ClassFactory() { // from class: com.smaato.sdk.core.SmaatoInstance$$ExternalSyntheticLambda7
            @Override // com.smaato.sdk.core.di.ClassFactory
            /* JADX INFO: renamed from: get */
            public final Object get2(DiConstructor diConstructor) {
                return SmaatoInstance.lambda$createCoreOfCoreRegistry$6(expectedManifestEntries, diConstructor);
            }
        });
        diRegistry.registerSingletonFactory(AppBackgroundDetector.class, new ClassFactory() { // from class: com.smaato.sdk.core.SmaatoInstance$$ExternalSyntheticLambda8
            @Override // com.smaato.sdk.core.di.ClassFactory
            /* JADX INFO: renamed from: get */
            public final Object get2(DiConstructor diConstructor) {
                return SmaatoInstance.lambda$createCoreOfCoreRegistry$7(diConstructor);
            }
        });
        diRegistry.registerSingletonFactory(HeaderUtils.class, new ClassFactory() { // from class: com.smaato.sdk.core.SmaatoInstance$$ExternalSyntheticLambda9
            @Override // com.smaato.sdk.core.di.ClassFactory
            /* JADX INFO: renamed from: get */
            public final Object get2(DiConstructor diConstructor) {
                return SmaatoInstance.lambda$createCoreOfCoreRegistry$8(diConstructor);
            }
        });
        diRegistry.registerSingletonFactory(SdkConfiguration.class, new ClassFactory() { // from class: com.smaato.sdk.core.SmaatoInstance$$ExternalSyntheticLambda10
            @Override // com.smaato.sdk.core.di.ClassFactory
            /* JADX INFO: renamed from: get */
            public final Object get2(DiConstructor diConstructor) {
                return SmaatoInstance.lambda$createCoreOfCoreRegistry$9(diConstructor);
            }
        });
    }

    static /* synthetic */ AppMetaData lambda$createCoreOfCoreRegistry$4(DiConstructor diConstructor) {
        return new AppMetaData((Context) diConstructor.get(Application.class), DiLogLayer.getLoggerFrom(diConstructor));
    }

    static /* synthetic */ SdkConfigHintBuilder lambda$createCoreOfCoreRegistry$5(DiConstructor diConstructor) {
        return new SdkConfigHintBuilder();
    }

    static /* synthetic */ AppConfigChecker lambda$createCoreOfCoreRegistry$6(ExpectedManifestEntries expectedManifestEntries, DiConstructor diConstructor) {
        return new AppConfigChecker(DiLogLayer.getLoggerFrom(diConstructor), expectedManifestEntries, (AppMetaData) diConstructor.get(AppMetaData.class));
    }

    static /* synthetic */ AppBackgroundDetector lambda$createCoreOfCoreRegistry$7(DiConstructor diConstructor) {
        return new AppBackgroundDetector(DiLogLayer.getLoggerFrom(diConstructor));
    }

    static /* synthetic */ HeaderUtils lambda$createCoreOfCoreRegistry$8(DiConstructor diConstructor) {
        return new HeaderUtils();
    }

    static /* synthetic */ SdkConfiguration lambda$createCoreOfCoreRegistry$9(DiConstructor diConstructor) {
        return new SdkConfiguration();
    }

    String getKeywords() {
        return this.keywords;
    }

    void setKeywords(String str) {
        this.keywords = str;
    }

    String getSearchQuery() {
        return this.searchQuery;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setSearchQuery(String str) {
        this.searchQuery = str;
    }

    Gender getGender() {
        return this.gender;
    }

    void setGender(Gender gender) {
        this.gender = gender;
    }

    Integer getAge() {
        return this.age;
    }

    void setAge(Integer num) {
        this.age = num;
    }

    LatLng getLatLng() {
        return this.latLng;
    }

    void setLatLng(LatLng latLng) {
        this.latLng = latLng;
    }

    String getRegion() {
        return this.region;
    }

    void setRegion(String str) {
        this.region = str;
    }

    String getZip() {
        return this.zip;
    }

    void setZip(String str) {
        this.zip = str;
    }

    public void setUnityVersion(String str) {
        this.mUnityVersion = str;
    }

    String getLanguage() {
        return this.language;
    }

    void setLanguage(String str) {
        this.language = str;
    }

    boolean getCoppa() {
        return this.coppa;
    }

    void setCoppa(boolean z) {
        this.coppa = z;
    }

    public boolean isAgeRestrictedUser() {
        return this.isAgeRestrictedUser;
    }

    public void setAgeRestrictedUser(boolean z) {
        this.isAgeRestrictedUser = z;
    }

    String getPublisherId() {
        return this.publisherId;
    }

    boolean isGPSEnabled() {
        return this.isGPSEnabled;
    }

    void setGPSEnabled(boolean z) {
        this.isGPSEnabled = z;
    }

    Boolean isLgpdConsentEnabled() {
        return this.isLgpdConsentEnabled;
    }

    public void setLgpdConsentEnabled(Boolean bool) {
        this.isLgpdConsentEnabled = bool;
    }

    boolean isWatermarkEnabled() {
        return this.isWatermarkEnabled;
    }

    void setWatermarkEnabled(boolean z) {
        this.isWatermarkEnabled = z;
    }

    List<ExtensionConfiguration> getExtensionConfigurations() {
        return new ArrayList(this.extensionConfigurations);
    }

    boolean isCompanionAdSkippable() {
        return this.isCompanionAdSkippable;
    }

    void setIsCompanionAdSkippable(boolean z) {
        this.isCompanionAdSkippable = z;
    }

    String getUsPrivacyString() {
        return ((CcpaDataStorage) this.diConstructor.get(CcpaDataStorage.class)).getUsPrivacyString();
    }

    AdContentRating getAdContentRating() {
        return this.adContentRating;
    }

    void setAdContentRating(AdContentRating adContentRating) {
        this.adContentRating = adContentRating;
    }

    public String getUnityVersion() {
        return this.mUnityVersion;
    }

    private ExpectedManifestEntries mergeExpectedManifestEntries(List list) {
        HashSet hashSet = new HashSet();
        HashSet hashSet2 = new HashSet();
        Iterator it = list.iterator();
        while (it.hasNext()) {
            ExpectedManifestEntries expectedManifestEntries = (ExpectedManifestEntries) it.next();
            hashSet.addAll(expectedManifestEntries.getPermissionsMandatory());
            hashSet2.addAll(expectedManifestEntries.getActivities());
        }
        return new ExpectedManifestEntries(hashSet, hashSet2);
    }
}
