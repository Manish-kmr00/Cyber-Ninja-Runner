package com.chartboost.sdk;

import android.content.Context;
import com.chartboost.sdk.callbacks.StartCallback;
import com.chartboost.sdk.events.StartError;
import com.chartboost.sdk.impl.b7;
import com.chartboost.sdk.impl.h4;
import com.chartboost.sdk.impl.v6;
import com.chartboost.sdk.impl.y2;
import com.chartboost.sdk.privacy.model.DataUseConsent;
import com.google.firebase.remoteconfig.RemoteConfigConstants;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0018\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0007J\u0018\u0010\t\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\u000bH\u0007J\n\u0010\f\u001a\u0004\u0018\u00010\u000bH\u0007J\u001a\u0010\r\u001a\u0004\u0018\u00010\b2\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\u000bH\u0007J\b\u0010\u000e\u001a\u00020\u000bH\u0007J\u0010\u0010\u000f\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0002J\b\u0010\u0010\u001a\u00020\u0011H\u0007J\u0010\u0010\u0012\u001a\u00020\u00042\u0006\u0010\u0013\u001a\u00020\u0014H\u0007J(\u0010\u0015\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0016\u001a\u00020\u000b2\u0006\u0010\u0017\u001a\u00020\u000b2\u0006\u0010\u0018\u001a\u00020\u0019H\u0007¨\u0006\u001a"}, d2 = {"Lcom/chartboost/sdk/Chartboost;", "", "()V", "addDataUseConsent", "", "context", "Landroid/content/Context;", "dataUseConsent", "Lcom/chartboost/sdk/privacy/model/DataUseConsent;", "clearDataUseConsent", "privacyStandard", "", "getBidderToken", "getDataUseConsent", "getSDKVersion", "initContainer", "isSdkStarted", "", "setLoggingLevel", "level", "Lcom/chartboost/sdk/LoggingLevel;", "startWithAppId", RemoteConfigConstants.RequestFieldKey.APP_ID, "appSignature", "onStarted", "Lcom/chartboost/sdk/callbacks/StartCallback;", "ChartboostMonetization-9.8.3_productionRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class Chartboost {
    public static final Chartboost INSTANCE = new Chartboost();

    private Chartboost() {
    }

    @JvmStatic
    public static final void addDataUseConsent(Context context, DataUseConsent dataUseConsent) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(dataUseConsent, "dataUseConsent");
        INSTANCE.initContainer(context);
        y2 y2Var = y2.b;
        if (y2Var.g()) {
            y2Var.i().a().a(dataUseConsent);
        }
    }

    @JvmStatic
    public static final void clearDataUseConsent(Context context, String privacyStandard) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(privacyStandard, "privacyStandard");
        INSTANCE.initContainer(context);
        y2 y2Var = y2.b;
        if (y2Var.g()) {
            y2Var.i().a().b(privacyStandard);
        }
    }

    @JvmStatic
    public static final String getBidderToken() {
        if (isSdkStarted()) {
            return y2.b.k().b().a();
        }
        b7.b("Chartboost getBidderToken failed due to SDK not being initialized.", null, 2, null);
        return null;
    }

    @JvmStatic
    public static final DataUseConsent getDataUseConsent(Context context, String privacyStandard) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(privacyStandard, "privacyStandard");
        INSTANCE.initContainer(context);
        y2 y2Var = y2.b;
        if (y2Var.g()) {
            return y2Var.i().a().a(privacyStandard);
        }
        return null;
    }

    @JvmStatic
    public static final String getSDKVersion() {
        return "9.8.3";
    }

    private final void initContainer(Context context) {
        y2 y2Var = y2.b;
        if (y2Var.g()) {
            return;
        }
        y2Var.a(context);
    }

    @JvmStatic
    public static final boolean isSdkStarted() {
        y2 y2Var = y2.b;
        if (y2Var.g() && y2Var.l()) {
            try {
                return y2Var.k().c().getIsSDKInitialized();
            } catch (Exception unused) {
            }
        }
        return false;
    }

    @JvmStatic
    public static final void setLoggingLevel(LoggingLevel level) {
        Intrinsics.checkNotNullParameter(level, "level");
        b7.level = level;
    }

    @JvmStatic
    public static final synchronized void startWithAppId(Context context, String appId, String appSignature, StartCallback onStarted) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(appId, "appId");
        Intrinsics.checkNotNullParameter(appSignature, "appSignature");
        Intrinsics.checkNotNullParameter(onStarted, "onStarted");
        if (isSdkStarted()) {
            b7.c("Chartboost startWithAppId skipped due to SDK already being initialized. This method only needs to be called once per app session.", null, 2, null);
            onStarted.onStartCompleted(null);
            return;
        }
        v6 v6Var = new v6(context);
        if (!v6Var.d() && !isSdkStarted()) {
            b7.b("Chartboost startWithAppId failed due to preconditions not being met. Check the logs for more information.", null, 2, null);
            onStarted.onStartCompleted(new StartError(StartError.Code.INTERNAL, new Exception("Initialization preconditions not met")));
            return;
        }
        v6Var.a();
        INSTANCE.initContainer(context);
        h4.c.f1036a.a(context);
        y2 y2Var = y2.b;
        if (y2Var.g()) {
            if (!isSdkStarted()) {
                y2Var.a(appId, appSignature);
            }
            y2Var.m().a();
            y2Var.k().b().a(appId, appSignature, onStarted);
        } else {
            b7.b("Chartboost startWithAppId failed due to DI not being initialized.", null, 2, null);
            onStarted.onStartCompleted(new StartError(StartError.Code.INTERNAL, new Exception("DI not initialized")));
        }
    }
}
