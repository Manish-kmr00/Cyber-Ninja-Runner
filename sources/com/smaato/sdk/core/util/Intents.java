package com.smaato.sdk.core.util;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.util.Log;
import com.safedk.android.analytics.brandsafety.BrandSafetyUtils;
import com.safedk.android.utils.Logger;
import com.safedk.android.utils.h;

/* JADX INFO: loaded from: classes2.dex */
public final class Intents {
    public static void safedk_Context_startActivity_97cb3195734cf5c9cc3418feeafa6dd6(Context p0, Intent p1) {
        Logger.d("SafeDK-Special|SafeDK: Call> Landroid/content/Context;->startActivity(Landroid/content/Intent;)V");
        if (p1 == null) {
            return;
        }
        BrandSafetyUtils.detectAdClick(p1, h.v);
        p0.startActivity(p1);
    }

    public static Intent createViewIntent(String str) {
        return new Intent("android.intent.action.VIEW", Uri.parse(str));
    }

    public static boolean tryToStartAsAppLink(Context context, String str) {
        return tryToStartIntent(context, createViewIntent(str).addCategory("android.intent.category.BROWSABLE").addCategory("android.intent.category.DEFAULT").addFlags(268436480));
    }

    public static boolean tryToStartIntent(Context context, Intent intent) {
        try {
            if (!(context instanceof Activity)) {
                intent.addFlags(268435456);
            }
            safedk_Context_startActivity_97cb3195734cf5c9cc3418feeafa6dd6(context, intent);
            return true;
        } catch (ActivityNotFoundException e) {
            Log.e("Intents", "Activity not found exception", e);
            return false;
        }
    }

    public static void startIntent(final Context context, final Intent intent) {
        Threads.runOnUi(new Runnable() { // from class: com.smaato.sdk.core.util.Intents$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                Intents.lambda$startIntent$0(context, intent);
            }
        });
    }

    static /* synthetic */ void lambda$startIntent$0(Context context, Intent intent) {
        if (canHandleIntent(context, intent)) {
            if (!(context instanceof Activity)) {
                intent.addFlags(268435456);
            }
            safedk_Context_startActivity_97cb3195734cf5c9cc3418feeafa6dd6(context, intent);
        }
    }

    public static boolean canHandleIntent(Context context, Intent intent) {
        return !context.getPackageManager().queryIntentActivities(intent, 0).isEmpty();
    }
}
