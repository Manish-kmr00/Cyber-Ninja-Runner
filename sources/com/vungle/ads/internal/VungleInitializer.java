package com.vungle.ads.internal;

import android.content.Context;
import android.os.Build;
import androidx.core.content.PermissionChecker;
import com.google.firebase.remoteconfig.RemoteConfigConstants;
import com.google.firebase.sessions.settings.RemoteSettings;
import com.vungle.ads.AnalyticsClient;
import com.vungle.ads.InitializationListener;
import com.vungle.ads.InvalidAppId;
import com.vungle.ads.OutOfMemory;
import com.vungle.ads.SdkNotInitialized;
import com.vungle.ads.SdkVersionTooLow;
import com.vungle.ads.ServiceLocator;
import com.vungle.ads.SingleValueMetric;
import com.vungle.ads.VungleAds;
import com.vungle.ads.VungleError;
import com.vungle.ads.internal.downloader.Downloader;
import com.vungle.ads.internal.executor.Executors;
import com.vungle.ads.internal.load.MraidJsLoader;
import com.vungle.ads.internal.model.ConfigPayload;
import com.vungle.ads.internal.network.VungleApiClient;
import com.vungle.ads.internal.network.VungleHeader;
import com.vungle.ads.internal.persistence.FilePreferences;
import com.vungle.ads.internal.privacy.PrivacyManager;
import com.vungle.ads.internal.protos.Sdk;
import com.vungle.ads.internal.task.CleanupJob;
import com.vungle.ads.internal.task.JobRunner;
import com.vungle.ads.internal.task.ResendTpatJob;
import com.vungle.ads.internal.util.ActivityManager;
import com.vungle.ads.internal.util.LogEntry;
import com.vungle.ads.internal.util.Logger;
import com.vungle.ads.internal.util.PathProvider;
import com.vungle.ads.internal.util.ThreadUtil;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: compiled from: VungleInitializer.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000l\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\b\u0000\u0018\u0000 $2\u00020\u0001:\u0001$B\u0005¢\u0006\u0002\u0010\u0002J\u0018\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0012H\u0002J\r\u0010\u0013\u001a\u00020\u000eH\u0000¢\u0006\u0002\b\u0014J\u0010\u0010\u0015\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010H\u0002J\u0010\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u0012H\u0002J\u001e\u0010\u0019\u001a\u00020\u000e2\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u001a\u001a\u00020\u0005J\u0010\u0010\u001b\u001a\u00020\u00172\u0006\u0010\u0011\u001a\u00020\u0012H\u0002J\u0006\u0010\u0006\u001a\u00020\u0017J\u0010\u0010\u001c\u001a\u00020\u000e2\u0006\u0010\u001d\u001a\u00020\u001eH\u0002J\b\u0010\u001f\u001a\u00020\u000eH\u0002J\u0016\u0010 \u001a\u00020\u000e2\u0006\u0010!\u001a\u00020\"2\u0006\u0010#\u001a\u00020\u0012R\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R$\u0010\u0006\u001a\u00020\u00078\u0000@\u0000X\u0081\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b\b\u0010\u0002\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\f¨\u0006%²\u0006\n\u0010&\u001a\u00020'X\u008a\u0084\u0002²\u0006\n\u0010(\u001a\u00020)X\u008a\u0084\u0002²\u0006\n\u0010(\u001a\u00020)X\u008a\u0084\u0002²\u0006\n\u0010*\u001a\u00020+X\u008a\u0084\u0002²\u0006\n\u0010&\u001a\u00020'X\u008a\u0084\u0002²\u0006\n\u0010,\u001a\u00020-X\u008a\u0084\u0002²\u0006\n\u0010.\u001a\u00020/X\u008a\u0084\u0002²\u0006\n\u00100\u001a\u000201X\u008a\u0084\u0002²\u0006\n\u0010&\u001a\u00020'X\u008a\u0084\u0002"}, d2 = {"Lcom/vungle/ads/internal/VungleInitializer;", "", "()V", "initializationCallbackArray", "Ljava/util/concurrent/CopyOnWriteArrayList;", "Lcom/vungle/ads/InitializationListener;", "isInitialized", "Ljava/util/concurrent/atomic/AtomicBoolean;", "isInitialized$vungle_ads_release$annotations", "isInitialized$vungle_ads_release", "()Ljava/util/concurrent/atomic/AtomicBoolean;", "setInitialized$vungle_ads_release", "(Ljava/util/concurrent/atomic/AtomicBoolean;)V", "configure", "", "context", "Landroid/content/Context;", RemoteConfigConstants.RequestFieldKey.APP_ID, "", "deInit", "deInit$vungle_ads_release", "downloadMraidJs", "hasInvalidChar", "", "value", "init", "initializationCallback", "isAppIdInvalid", "onInitError", "exception", "Lcom/vungle/ads/VungleError;", "onInitSuccess", "setIntegrationName", "wrapperFramework", "Lcom/vungle/ads/VungleAds$WrapperFramework;", "wrapperFrameworkVersion", "Companion", "vungle-ads_release", "sdkExecutors", "Lcom/vungle/ads/internal/executor/Executors;", "vungleApiClient", "Lcom/vungle/ads/internal/network/VungleApiClient;", "filePreferences", "Lcom/vungle/ads/internal/persistence/FilePreferences;", "jobRunner", "Lcom/vungle/ads/internal/task/JobRunner;", "pathProvider", "Lcom/vungle/ads/internal/util/PathProvider;", "downloader", "Lcom/vungle/ads/internal/downloader/Downloader;"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class VungleInitializer {
    private static final String TAG = "VungleInitializer";
    private AtomicBoolean isInitialized = new AtomicBoolean(false);
    private final CopyOnWriteArrayList<InitializationListener> initializationCallbackArray = new CopyOnWriteArrayList<>();

    public static /* synthetic */ void isInitialized$vungle_ads_release$annotations() {
    }

    /* JADX INFO: renamed from: isInitialized$vungle_ads_release, reason: from getter */
    public final AtomicBoolean getIsInitialized() {
        return this.isInitialized;
    }

    public final void setInitialized$vungle_ads_release(AtomicBoolean atomicBoolean) {
        Intrinsics.checkNotNullParameter(atomicBoolean, "<set-?>");
        this.isInitialized = atomicBoolean;
    }

    public final void init(final String appId, final Context context, InitializationListener initializationCallback) {
        Intrinsics.checkNotNullParameter(appId, "appId");
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(initializationCallback, "initializationCallback");
        AnalyticsClient.logMetric$vungle_ads_release$default(AnalyticsClient.INSTANCE, new SingleValueMetric(Sdk.SDKMetric.SDKMetricType.SDK_INIT_API), (LogEntry) null, (String) null, 6, (Object) null);
        this.initializationCallbackArray.add(initializationCallback);
        ActivityManager.INSTANCE.init(context);
        if (isAppIdInvalid(appId)) {
            onInitError(new InvalidAppId("App id invalid: " + appId + ", package name: " + context.getPackageName()).logError$vungle_ads_release());
            return;
        }
        if (Build.VERSION.SDK_INT < 25) {
            Logger.INSTANCE.e(TAG, "SDK is supported only for API versions 25 and above.");
            onInitError(new SdkVersionTooLow("SDK is supported only for API versions 25 and above.").logError$vungle_ads_release());
            return;
        }
        ConfigManager.INSTANCE.setAppId$vungle_ads_release(appId);
        if (this.isInitialized.get()) {
            Logger.INSTANCE.d(TAG, "init already complete");
            onInitSuccess();
        } else {
            if (PermissionChecker.checkCallingOrSelfPermission(context, "android.permission.ACCESS_NETWORK_STATE") != 0 || PermissionChecker.checkCallingOrSelfPermission(context, "android.permission.INTERNET") != 0) {
                Logger.INSTANCE.e(TAG, "Network permissions not granted");
                onInitError(new SdkNotInitialized("Network permissions not granted").logError$vungle_ads_release());
                return;
            }
            ServiceLocator.Companion companion = ServiceLocator.INSTANCE;
            Lazy lazy = LazyKt.lazy(LazyThreadSafetyMode.SYNCHRONIZED, (Function0) new Function0<Executors>() { // from class: com.vungle.ads.internal.VungleInitializer$init$$inlined$inject$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                }

                /* JADX WARN: Type inference failed for: r0v2, types: [com.vungle.ads.internal.executor.Executors, java.lang.Object] */
                @Override // kotlin.jvm.functions.Function0
                public final Executors invoke() {
                    return ServiceLocator.INSTANCE.getInstance(context).getService(Executors.class);
                }
            });
            ServiceLocator.Companion companion2 = ServiceLocator.INSTANCE;
            final Lazy lazy2 = LazyKt.lazy(LazyThreadSafetyMode.SYNCHRONIZED, (Function0) new Function0<VungleApiClient>() { // from class: com.vungle.ads.internal.VungleInitializer$init$$inlined$inject$2
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                }

                /* JADX WARN: Type inference failed for: r0v2, types: [com.vungle.ads.internal.network.VungleApiClient, java.lang.Object] */
                @Override // kotlin.jvm.functions.Function0
                public final VungleApiClient invoke() {
                    return ServiceLocator.INSTANCE.getInstance(context).getService(VungleApiClient.class);
                }
            });
            m6020init$lambda0(lazy).getBACKGROUND_EXECUTOR().execute(new Runnable() { // from class: com.vungle.ads.internal.VungleInitializer$$ExternalSyntheticLambda1
                @Override // java.lang.Runnable
                public final void run() {
                    VungleInitializer.m6022init$lambda2(context, appId, this, lazy2);
                }
            }, new Runnable() { // from class: com.vungle.ads.internal.VungleInitializer$$ExternalSyntheticLambda2
                @Override // java.lang.Runnable
                public final void run() {
                    VungleInitializer.m6023init$lambda3(this.f$0);
                }
            });
        }
    }

    /* JADX INFO: renamed from: init$lambda-0, reason: not valid java name */
    private static final Executors m6020init$lambda0(Lazy<? extends Executors> lazy) {
        return lazy.getValue();
    }

    /* JADX INFO: renamed from: init$lambda-1, reason: not valid java name */
    private static final VungleApiClient m6021init$lambda1(Lazy<VungleApiClient> lazy) {
        return lazy.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: init$lambda-2, reason: not valid java name */
    public static final void m6022init$lambda2(Context context, String appId, VungleInitializer this$0, Lazy vungleApiClient$delegate) {
        Intrinsics.checkNotNullParameter(context, "$context");
        Intrinsics.checkNotNullParameter(appId, "$appId");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(vungleApiClient$delegate, "$vungleApiClient$delegate");
        PrivacyManager.INSTANCE.init(context);
        m6021init$lambda1(vungleApiClient$delegate).initialize(appId);
        this$0.configure(context, appId);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: init$lambda-3, reason: not valid java name */
    public static final void m6023init$lambda3(VungleInitializer this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.onInitError(new OutOfMemory("Config: Out of Memory").logError$vungle_ads_release());
    }

    private final boolean isAppIdInvalid(String appId) {
        return StringsKt.isBlank(appId) || hasInvalidChar(appId);
    }

    private final void configure(final Context context, String appId) {
        boolean z;
        ServiceLocator.Companion companion = ServiceLocator.INSTANCE;
        Lazy lazy = LazyKt.lazy(LazyThreadSafetyMode.SYNCHRONIZED, (Function0) new Function0<VungleApiClient>() { // from class: com.vungle.ads.internal.VungleInitializer$configure$$inlined$inject$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Type inference failed for: r0v2, types: [com.vungle.ads.internal.network.VungleApiClient, java.lang.Object] */
            @Override // kotlin.jvm.functions.Function0
            public final VungleApiClient invoke() {
                return ServiceLocator.INSTANCE.getInstance(context).getService(VungleApiClient.class);
            }
        });
        try {
            ServiceLocator.Companion companion2 = ServiceLocator.INSTANCE;
            ConfigPayload cachedConfig = ConfigManager.INSTANCE.getCachedConfig(m6014configure$lambda5(LazyKt.lazy(LazyThreadSafetyMode.SYNCHRONIZED, (Function0) new Function0<FilePreferences>() { // from class: com.vungle.ads.internal.VungleInitializer$configure$$inlined$inject$2
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                }

                /* JADX WARN: Type inference failed for: r0v2, types: [com.vungle.ads.internal.persistence.FilePreferences, java.lang.Object] */
                @Override // kotlin.jvm.functions.Function0
                public final FilePreferences invoke() {
                    return ServiceLocator.INSTANCE.getInstance(context).getService(FilePreferences.class);
                }
            })), appId);
            if (cachedConfig != null) {
                ConfigManager.initWithConfig$vungle_ads_release$default(ConfigManager.INSTANCE, context, cachedConfig, true, null, 8, null);
                z = true;
            } else {
                z = false;
            }
            ServiceLocator.Companion companion3 = ServiceLocator.INSTANCE;
            AnalyticsClient.INSTANCE.init$vungle_ads_release(m6013configure$lambda4(lazy), m6015configure$lambda6(LazyKt.lazy(LazyThreadSafetyMode.SYNCHRONIZED, (Function0) new Function0<Executors>() { // from class: com.vungle.ads.internal.VungleInitializer$configure$$inlined$inject$3
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                }

                /* JADX WARN: Type inference failed for: r0v2, types: [com.vungle.ads.internal.executor.Executors, java.lang.Object] */
                @Override // kotlin.jvm.functions.Function0
                public final Executors invoke() {
                    return ServiceLocator.INSTANCE.getInstance(context).getService(Executors.class);
                }
            })).getLOGGER_EXECUTOR(), ConfigManager.INSTANCE.getLogLevel(), ConfigManager.INSTANCE.getMetricsEnabled());
            this.isInitialized.set(true);
            onInitSuccess();
            Logger.INSTANCE.d(TAG, "Running cleanup and resend tpat jobs. " + Thread.currentThread().getId());
            ServiceLocator.Companion companion4 = ServiceLocator.INSTANCE;
            Lazy lazy2 = LazyKt.lazy(LazyThreadSafetyMode.SYNCHRONIZED, (Function0) new Function0<JobRunner>() { // from class: com.vungle.ads.internal.VungleInitializer$configure$$inlined$inject$4
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                }

                /* JADX WARN: Type inference failed for: r0v2, types: [com.vungle.ads.internal.task.JobRunner, java.lang.Object] */
                @Override // kotlin.jvm.functions.Function0
                public final JobRunner invoke() {
                    return ServiceLocator.INSTANCE.getInstance(context).getService(JobRunner.class);
                }
            });
            m6016configure$lambda7(lazy2).execute(CleanupJob.Companion.makeJobInfo$default(CleanupJob.INSTANCE, null, 1, null));
            m6016configure$lambda7(lazy2).execute(ResendTpatJob.INSTANCE.makeJobInfo());
            if (z) {
                downloadMraidJs(context);
            } else {
                ConfigManager.INSTANCE.fetchConfigAsync$vungle_ads_release(context, new Function1<Boolean, Unit>() { // from class: com.vungle.ads.internal.VungleInitializer.configure.1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
                        invoke(bool.booleanValue());
                        return Unit.INSTANCE;
                    }

                    public final void invoke(boolean z2) {
                        if (z2) {
                            VungleInitializer.this.downloadMraidJs(context);
                        }
                    }
                });
            }
        } catch (Throwable th) {
            Logger.INSTANCE.e(TAG, "Cannot get config", th);
        }
    }

    /* JADX INFO: renamed from: configure$lambda-4, reason: not valid java name */
    private static final VungleApiClient m6013configure$lambda4(Lazy<VungleApiClient> lazy) {
        return lazy.getValue();
    }

    /* JADX INFO: renamed from: configure$lambda-5, reason: not valid java name */
    private static final FilePreferences m6014configure$lambda5(Lazy<FilePreferences> lazy) {
        return lazy.getValue();
    }

    /* JADX INFO: renamed from: configure$lambda-6, reason: not valid java name */
    private static final Executors m6015configure$lambda6(Lazy<? extends Executors> lazy) {
        return lazy.getValue();
    }

    /* JADX INFO: renamed from: configure$lambda-7, reason: not valid java name */
    private static final JobRunner m6016configure$lambda7(Lazy<? extends JobRunner> lazy) {
        return lazy.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void downloadMraidJs(final Context context) {
        ServiceLocator.Companion companion = ServiceLocator.INSTANCE;
        Lazy lazy = LazyKt.lazy(LazyThreadSafetyMode.SYNCHRONIZED, (Function0) new Function0<PathProvider>() { // from class: com.vungle.ads.internal.VungleInitializer$downloadMraidJs$$inlined$inject$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Type inference failed for: r0v2, types: [com.vungle.ads.internal.util.PathProvider, java.lang.Object] */
            @Override // kotlin.jvm.functions.Function0
            public final PathProvider invoke() {
                return ServiceLocator.INSTANCE.getInstance(context).getService(PathProvider.class);
            }
        });
        ServiceLocator.Companion companion2 = ServiceLocator.INSTANCE;
        Lazy lazy2 = LazyKt.lazy(LazyThreadSafetyMode.SYNCHRONIZED, (Function0) new Function0<Downloader>() { // from class: com.vungle.ads.internal.VungleInitializer$downloadMraidJs$$inlined$inject$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Type inference failed for: r0v2, types: [com.vungle.ads.internal.downloader.Downloader, java.lang.Object] */
            @Override // kotlin.jvm.functions.Function0
            public final Downloader invoke() {
                return ServiceLocator.INSTANCE.getInstance(context).getService(Downloader.class);
            }
        });
        ServiceLocator.Companion companion3 = ServiceLocator.INSTANCE;
        MraidJsLoader.INSTANCE.downloadJs(m6018downloadMraidJs$lambda8(lazy), m6019downloadMraidJs$lambda9(lazy2), m6017downloadMraidJs$lambda10(LazyKt.lazy(LazyThreadSafetyMode.SYNCHRONIZED, (Function0) new Function0<Executors>() { // from class: com.vungle.ads.internal.VungleInitializer$downloadMraidJs$$inlined$inject$3
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Type inference failed for: r0v2, types: [com.vungle.ads.internal.executor.Executors, java.lang.Object] */
            @Override // kotlin.jvm.functions.Function0
            public final Executors invoke() {
                return ServiceLocator.INSTANCE.getInstance(context).getService(Executors.class);
            }
        })).getBACKGROUND_EXECUTOR(), (24 & 8) != 0 ? null : null, (24 & 16) != 0 ? null : null);
    }

    /* JADX INFO: renamed from: downloadMraidJs$lambda-8, reason: not valid java name */
    private static final PathProvider m6018downloadMraidJs$lambda8(Lazy<PathProvider> lazy) {
        return lazy.getValue();
    }

    /* JADX INFO: renamed from: downloadMraidJs$lambda-9, reason: not valid java name */
    private static final Downloader m6019downloadMraidJs$lambda9(Lazy<? extends Downloader> lazy) {
        return lazy.getValue();
    }

    /* JADX INFO: renamed from: downloadMraidJs$lambda-10, reason: not valid java name */
    private static final Executors m6017downloadMraidJs$lambda10(Lazy<? extends Executors> lazy) {
        return lazy.getValue();
    }

    private final void onInitError(final VungleError exception) {
        ThreadUtil.INSTANCE.runOnUiThread(new Runnable() { // from class: com.vungle.ads.internal.VungleInitializer$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                VungleInitializer.m6024onInitError$lambda12(this.f$0, exception);
            }
        });
        String localizedMessage = exception.getLocalizedMessage();
        if (localizedMessage == null) {
            localizedMessage = "Exception code is " + exception.getCode();
        }
        Logger.INSTANCE.e(TAG, localizedMessage);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: onInitError$lambda-12, reason: not valid java name */
    public static final void m6024onInitError$lambda12(VungleInitializer this$0, VungleError exception) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(exception, "$exception");
        Logger.INSTANCE.e(TAG, "onError");
        Iterator<T> it = this$0.initializationCallbackArray.iterator();
        while (it.hasNext()) {
            ((InitializationListener) it.next()).onError(exception);
        }
        this$0.initializationCallbackArray.clear();
    }

    private final void onInitSuccess() {
        Logger.INSTANCE.d(TAG, "onSuccess " + Thread.currentThread().getId());
        ThreadUtil.INSTANCE.runOnUiThread(new Runnable() { // from class: com.vungle.ads.internal.VungleInitializer$$ExternalSyntheticLambda3
            @Override // java.lang.Runnable
            public final void run() {
                VungleInitializer.m6025onInitSuccess$lambda14(this.f$0);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: onInitSuccess$lambda-14, reason: not valid java name */
    public static final void m6025onInitSuccess$lambda14(VungleInitializer this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Iterator<T> it = this$0.initializationCallbackArray.iterator();
        while (it.hasNext()) {
            ((InitializationListener) it.next()).onSuccess();
        }
        this$0.initializationCallbackArray.clear();
    }

    private final boolean hasInvalidChar(String value) {
        String str = value;
        for (int i = 0; i < str.length(); i++) {
            char cCharAt = str.charAt(i);
            if (!Character.isLetterOrDigit(cCharAt) && cCharAt != '.') {
                return true;
            }
        }
        return false;
    }

    public final boolean isInitialized() {
        return this.isInitialized.get();
    }

    public final void deInit$vungle_ads_release() {
        ServiceLocator.INSTANCE.deInit();
        VungleApiClient.INSTANCE.reset$vungle_ads_release();
        this.isInitialized.set(false);
    }

    public final void setIntegrationName(VungleAds.WrapperFramework wrapperFramework, String wrapperFrameworkVersion) {
        Intrinsics.checkNotNullParameter(wrapperFramework, "wrapperFramework");
        Intrinsics.checkNotNullParameter(wrapperFrameworkVersion, "wrapperFrameworkVersion");
        if (wrapperFramework == VungleAds.WrapperFramework.none) {
            Logger.INSTANCE.e(TAG, "Wrapper is null or is none");
            return;
        }
        String headerUa = VungleHeader.INSTANCE.getHeaderUa();
        String str = wrapperFramework.name() + (wrapperFrameworkVersion.length() > 0 ? RemoteSettings.FORWARD_SLASH_STRING + wrapperFrameworkVersion : "");
        if (StringsKt.contains$default((CharSequence) headerUa, (CharSequence) str, false, 2, (Object) null)) {
            Logger.INSTANCE.w(TAG, "Wrapper info already set");
            return;
        }
        VungleHeader.INSTANCE.setHeaderUa(headerUa + ';' + str);
        if (isInitialized()) {
            Logger.INSTANCE.w(TAG, "VUNGLE WARNING: SDK already initialized, you should've set wrapper info before");
        }
    }
}
