package com.smaato.sdk.core.linkhandler;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.content.Intent;
import com.safedk.android.analytics.brandsafety.BrandSafetyUtils;
import com.safedk.android.utils.Logger;
import com.safedk.android.utils.h;
import com.smaato.sdk.core.lifecycle.ActivityProvider;
import com.smaato.sdk.core.util.Threads;

/* JADX INFO: loaded from: classes9.dex */
public class IntentLauncher {
    private final Application application;
    private boolean wasLaunched = false;

    public static void safedk_Activity_startActivity_9d898b58165fa4ba0e12c3900a2b8533(Activity p0, Intent p1) {
        Logger.d("SafeDK-Special|SafeDK: Call> Landroid/app/Activity;->startActivity(Landroid/content/Intent;)V");
        if (p1 == null) {
            return;
        }
        BrandSafetyUtils.detectAdClick(p1, h.v);
        p0.startActivity(p1);
    }

    public static void safedk_Context_startActivity_97cb3195734cf5c9cc3418feeafa6dd6(Context p0, Intent p1) {
        Logger.d("SafeDK-Special|SafeDK: Call> Landroid/content/Context;->startActivity(Landroid/content/Intent;)V");
        if (p1 == null) {
            return;
        }
        BrandSafetyUtils.detectAdClick(p1, h.v);
        p0.startActivity(p1);
    }

    public IntentLauncher(Application application) {
        this.application = application;
    }

    public boolean launch(final Intent intent) {
        Threads.runOnUiBlocking(new Runnable() { // from class: com.smaato.sdk.core.linkhandler.IntentLauncher$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.m5549lambda$launch$0$comsmaatosdkcorelinkhandlerIntentLauncher(intent);
            }
        });
        return this.wasLaunched;
    }

    /* JADX INFO: renamed from: lambda$launch$0$com-smaato-sdk-core-linkhandler-IntentLauncher, reason: not valid java name */
    /* synthetic */ void m5549lambda$launch$0$comsmaatosdkcorelinkhandlerIntentLauncher(Intent intent) {
        try {
            Activity currentActivity = ActivityProvider.get().getCurrentActivity();
            if (currentActivity != null) {
                safedk_Activity_startActivity_9d898b58165fa4ba0e12c3900a2b8533(currentActivity, intent);
            } else {
                safedk_Context_startActivity_97cb3195734cf5c9cc3418feeafa6dd6(this.application, intent.addFlags(268435456));
            }
            this.wasLaunched = true;
        } catch (Exception unused) {
            this.wasLaunched = false;
        }
    }
}
