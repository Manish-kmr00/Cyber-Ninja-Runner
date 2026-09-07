package com.pubmatic.sdk.common;

import android.app.Application;
import android.content.Context;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.pubmatic.sdk.common.cache.POBCacheManager;
import com.pubmatic.sdk.common.log.POBLog;
import com.pubmatic.sdk.common.log.POBLogConstants;
import com.pubmatic.sdk.common.session.POBAppSessionHandler;
import com.pubmatic.sdk.common.taskhandler.POBTaskHandler;
import com.pubmatic.sdk.common.utility.POBSharedPreferenceUtil;
import com.pubmatic.sdk.common.utility.POBUtils;
import com.pubmatic.sdk.common.viewability.POBMeasurementProvider;
import com.unity3d.services.ads.gmascar.bridges.mobileads.MobileAdsBridgeBase;
import java.lang.reflect.Method;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÀ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0017\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\u0007\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\u0007\u0010\u0003J\u0017\u0010\u0007\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\tH\u0002¢\u0006\u0004\b\u0007\u0010\u000bJ'\u0010\u0010\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\u000eH\u0017¢\u0006\u0004\b\u0010\u0010\u0011J\u000f\u0010\u0013\u001a\u00020\u0012H\u0016¢\u0006\u0004\b\u0013\u0010\u0014R\u0016\u0010\u0013\u001a\u00020\u00158\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0007\u0010\u0016¨\u0006\u0017"}, d2 = {"Lcom/pubmatic/sdk/common/OpenWrapSDKInitializerImpl;", "Lcom/pubmatic/sdk/common/OpenWrapSDKInitializer;", "<init>", "()V", "Lcom/pubmatic/sdk/common/cache/POBCacheManager;", "cacheManager", "", "a", "(Lcom/pubmatic/sdk/common/cache/POBCacheManager;)V", "Landroid/content/Context;", "context", "(Landroid/content/Context;)V", "Lcom/pubmatic/sdk/common/OpenWrapSDKConfig;", "sdkConfig", "Lcom/pubmatic/sdk/common/OpenWrapSDKInitializer$Listener;", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, MobileAdsBridgeBase.initializeMethodName, "(Landroid/content/Context;Lcom/pubmatic/sdk/common/OpenWrapSDKConfig;Lcom/pubmatic/sdk/common/OpenWrapSDKInitializer$Listener;)V", "", "isInitialized", "()Z", "Ljava/util/concurrent/atomic/AtomicBoolean;", "Ljava/util/concurrent/atomic/AtomicBoolean;", "common_release"}, k = 1, mv = {1, 7, 1})
public final class OpenWrapSDKInitializerImpl implements OpenWrapSDKInitializer {
    public static final OpenWrapSDKInitializerImpl INSTANCE = new OpenWrapSDKInitializerImpl();

    /* JADX INFO: renamed from: a, reason: collision with root package name and from kotlin metadata */
    private static AtomicBoolean isInitialized = new AtomicBoolean(false);

    private OpenWrapSDKInitializerImpl() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(boolean z, final OpenWrapSDKInitializer.Listener listener, String it) {
        Intrinsics.checkNotNullParameter(listener, "$listener");
        Intrinsics.checkNotNullParameter(it, "it");
        POBLog.debug("OpenWrapSDKInitializer", POBLogConstants.USER_AGENT_FETCH_SUCCESSFUL + it, new Object[0]);
        if (z) {
            POBTaskHandler.INSTANCE.getInstance().runOnMainThread(new Runnable() { // from class: com.pubmatic.sdk.common.OpenWrapSDKInitializerImpl$$ExternalSyntheticLambda1
                @Override // java.lang.Runnable
                public final void run() {
                    OpenWrapSDKInitializerImpl.a(listener);
                }
            });
        } else {
            listener.onSuccess();
        }
    }

    @Override // com.pubmatic.sdk.common.OpenWrapSDKInitializer
    public void initialize(Context context, OpenWrapSDKConfig sdkConfig, final OpenWrapSDKInitializer.Listener listener) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(sdkConfig, "sdkConfig");
        Intrinsics.checkNotNullParameter(listener, "listener");
        if (StringsKt.isBlank(sdkConfig.getPublisherId()) || sdkConfig.getProfileIds().isEmpty()) {
            isInitialized.set(false);
            listener.onFailure(new POBError(1013, POBCommonConstants.INVALID_CONFIG_MESSAGE));
            return;
        }
        POBCacheManager cacheManager = POBInstanceProvider.getCacheManager(context);
        Intrinsics.checkNotNullExpressionValue(cacheManager, "getCacheManager(context)");
        cacheManager.fetchProfileConfigs(context, sdkConfig);
        if (!isInitialized.compareAndSet(false, true)) {
            listener.onSuccess();
            return;
        }
        final boolean zIsMainThread = POBUtils.isMainThread();
        a(cacheManager);
        POBSharedPreferenceUtil.init(context);
        cacheManager.loadMraidJs();
        a();
        cacheManager.generateUserAgent(new POBCacheManager.UserAgentListener() { // from class: com.pubmatic.sdk.common.OpenWrapSDKInitializerImpl$$ExternalSyntheticLambda0
            @Override // com.pubmatic.sdk.common.cache.POBCacheManager.UserAgentListener
            public final void onUserAgentReceived(String str) {
                OpenWrapSDKInitializerImpl.a(zIsMainThread, listener, str);
            }
        });
        a(context);
    }

    @Override // com.pubmatic.sdk.common.OpenWrapSDKInitializer
    public boolean isInitialized() {
        return isInitialized.get();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(OpenWrapSDKInitializer.Listener listener) {
        Intrinsics.checkNotNullParameter(listener, "$listener");
        listener.onSuccess();
    }

    private final void a(POBCacheManager cacheManager) {
        cacheManager.loadInternalServiceJS(new POBMeasurementProvider.POBScriptListener() { // from class: com.pubmatic.sdk.common.OpenWrapSDKInitializerImpl$fetchOmidJsScript$1
            @Override // com.pubmatic.sdk.common.viewability.POBMeasurementProvider.POBScriptListener
            public void onFailedToReceiveMeasurementScript(int scriptError) {
                POBLog.error("OpenWrapSDKInitializer", POBLogConstants.OMID_JS_SCRIPT_FAILURE, new Object[0]);
            }

            @Override // com.pubmatic.sdk.common.viewability.POBMeasurementProvider.POBScriptListener
            public void onMeasurementScriptReceived(String script) {
                Intrinsics.checkNotNullParameter(script, "script");
                POBLog.info("OpenWrapSDKInitializer", "Successfully fetched OMID JS script.", new Object[0]);
            }
        });
    }

    private final void a() {
        try {
            Method method = Class.forName("com.pubmatic.sdk.monitor.POBMonitor").getMethod("load", null);
            method.setAccessible(true);
            method.invoke(null, null);
        } catch (Exception e) {
            POBLog.error("OpenWrapSDKInitializer", e.getMessage(), new Object[0]);
        }
    }

    private final void a(Context context) {
        Context applicationContext = context.getApplicationContext();
        Application application = applicationContext instanceof Application ? (Application) applicationContext : null;
        if (application != null) {
            POBAppSessionHandler applicationSessionHandler = POBInstanceProvider.getApplicationSessionHandler(application);
            Intrinsics.checkNotNullExpressionValue(applicationSessionHandler, "getApplicationSessionHandler(application)");
            POBInstanceProvider.getImpDepthHandler(applicationSessionHandler).initiate();
            applicationSessionHandler.initiateSession();
            POBLog.debug("OpenWrapSDKInitializer", POBLogConstants.SESSION_HANDLER_INITIALIZATION_SUCCESSFUL, new Object[0]);
            return;
        }
        POBLog.error("OpenWrapSDKInitializer", POBLogConstants.SESSION_HANDLER_INITIALIZATION_FAILED, new Object[0]);
    }
}
