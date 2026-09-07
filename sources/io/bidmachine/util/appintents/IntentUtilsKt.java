package io.bidmachine.util.appintents;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import com.facebook.gamingservices.cloudgaming.internal.SDKConstants;
import com.safedk.android.analytics.brandsafety.BrandSafetyUtils;
import com.safedk.android.utils.Logger;
import io.bidmachine.util.Executable;
import io.bidmachine.util.UiUtils;
import io.bidmachine.util.Utils;
import java.net.URLDecoder;
import java.util.List;
import java.util.concurrent.Executors;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;

/* JADX INFO: compiled from: IntentUtils.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000.\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\u001a\u0012\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0004\u001a\u0014\u0010\u0005\u001a\u0004\u0018\u00010\u0006*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0004\u001a$\u0010\u0007\u001a\u00020\u0001*\u00020\u00022\b\u0010\b\u001a\u0004\u0018\u00010\t2\u000e\u0010\n\u001a\n\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u000b\u001a\u0014\u0010\f\u001a\u00020\u0001*\u00020\u00022\b\u0010\b\u001a\u0004\u0018\u00010\t\u001a$\u0010\r\u001a\u00020\u0001*\u00020\u00022\b\u0010\b\u001a\u0004\u0018\u00010\t2\u000e\u0010\n\u001a\n\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u000b\u001a\n\u0010\u000e\u001a\u00020\u0004*\u00020\u000f¨\u0006\u0010"}, d2 = {"findAndSetIntentComponent", "", "Landroid/content/Context;", SDKConstants.PARAM_INTENT, "Landroid/content/Intent;", "findComponentName", "Landroid/content/ComponentName;", "findEndpointAndOpenUrl", "url", "", "postMethod", "Lio/bidmachine/util/Executable;", "openUrl", "openUrlWithPostback", "toIntent", "Landroid/net/Uri;", "bidmachine-android-util_c_0_4_0"}, k = 2, mv = {1, 7, 1}, xi = 48)
public final class IntentUtilsKt {
    public static void safedk_Context_startActivity_97cb3195734cf5c9cc3418feeafa6dd6(Context p0, Intent p1) {
        Logger.d("SafeDK-Special|SafeDK: Call> Landroid/content/Context;->startActivity(Landroid/content/Intent;)V");
        if (p1 == null) {
            return;
        }
        BrandSafetyUtils.detectAdClick(p1, "io.bidmachine");
        p0.startActivity(p1);
    }

    public static final boolean findEndpointAndOpenUrl(Context context, String str, final Executable<Boolean> executable) {
        Intrinsics.checkNotNullParameter(context, "<this>");
        String str2 = str;
        if (str2 == null || str2.length() == 0) {
            if (executable != null) {
                executable.execute(false);
            }
            return false;
        }
        final Context applicationContext = context.getApplicationContext();
        final String validUrl = Utils.getValidUrl(str);
        String str3 = validUrl;
        if (str3 == null || str3.length() == 0) {
            if (executable != null) {
                executable.execute(false);
            }
            return false;
        }
        if (Utils.isHttpUrl(validUrl)) {
            Executors.newSingleThreadExecutor().execute(new Runnable() { // from class: io.bidmachine.util.appintents.IntentUtilsKt$$ExternalSyntheticLambda0
                @Override // java.lang.Runnable
                public final void run() {
                    IntentUtilsKt.findEndpointAndOpenUrl$lambda$0(applicationContext, validUrl, executable);
                }
            });
            return true;
        }
        Intrinsics.checkNotNullExpressionValue(applicationContext, "applicationContext");
        return openUrlWithPostback(applicationContext, validUrl, executable);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void findEndpointAndOpenUrl$lambda$0(Context applicationContext, String str, Executable executable) {
        Intrinsics.checkNotNullExpressionValue(applicationContext, "applicationContext");
        openUrlWithPostback(applicationContext, Utils.findEndpoint(str), executable);
    }

    public static final boolean openUrl(Context context, String str) {
        Boolean bool;
        Intrinsics.checkNotNullParameter(context, "<this>");
        String str2 = str;
        if (str2 == null || str2.length() == 0) {
            return false;
        }
        try {
            Intent intentUrlToIntent = IntentUtils.urlToIntent(str);
            if (!IntentUtils.findAndSetIntentComponent(context, intentUrlToIntent)) {
                String decodedUrl = URLDecoder.decode(str, Charsets.UTF_8.name());
                Intrinsics.checkNotNullExpressionValue(decodedUrl, "decodedUrl");
                intentUrlToIntent = IntentUtils.urlToIntent(decodedUrl);
                IntentUtils.findAndSetIntentComponent(context, intentUrlToIntent);
            }
            safedk_Context_startActivity_97cb3195734cf5c9cc3418feeafa6dd6(context, intentUrlToIntent);
            bool = true;
        } catch (Throwable unused) {
            bool = null;
        }
        return Intrinsics.areEqual((Object) bool, (Object) true);
    }

    public static final boolean openUrlWithPostback(Context context, String str, final Executable<Boolean> executable) {
        Intrinsics.checkNotNullParameter(context, "<this>");
        final boolean zOpenUrl = openUrl(context, str);
        UiUtils.onUiThread(new Runnable() { // from class: io.bidmachine.util.appintents.IntentUtilsKt$$ExternalSyntheticLambda1
            @Override // java.lang.Runnable
            public final void run() {
                IntentUtilsKt.openUrlWithPostback$lambda$3$lambda$2(executable, zOpenUrl);
            }
        });
        return zOpenUrl;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void openUrlWithPostback$lambda$3$lambda$2(Executable executable, boolean z) {
        if (executable != null) {
            executable.execute(Boolean.valueOf(z));
        }
    }

    public static final Intent toIntent(Uri uri) {
        Intrinsics.checkNotNullParameter(uri, "<this>");
        Intent intent = new Intent("android.intent.action.VIEW", uri);
        intent.setFlags(268435456);
        return intent;
    }

    public static final boolean findAndSetIntentComponent(Context context, Intent intent) {
        Intrinsics.checkNotNullParameter(context, "<this>");
        Intrinsics.checkNotNullParameter(intent, "intent");
        ComponentName componentNameFindComponentName = findComponentName(context, intent);
        if (componentNameFindComponentName == null) {
            return false;
        }
        intent.setComponent(componentNameFindComponentName);
        return true;
    }

    public static final ComponentName findComponentName(Context context, Intent intent) {
        Intrinsics.checkNotNullParameter(context, "<this>");
        Intrinsics.checkNotNullParameter(intent, "intent");
        List<ResolveInfo> listQueryIntentActivities = context.getPackageManager().queryIntentActivities(intent, 0);
        Intrinsics.checkNotNullExpressionValue(listQueryIntentActivities, "packageManager.queryIntentActivities(intent, 0)");
        if (listQueryIntentActivities.isEmpty()) {
            return null;
        }
        ComponentName componentNameFindStoreComponentName = IntentUtils.findStoreComponentName(listQueryIntentActivities);
        return componentNameFindStoreComponentName == null ? new ComponentName(listQueryIntentActivities.get(0).activityInfo.packageName, listQueryIntentActivities.get(0).activityInfo.name) : componentNameFindStoreComponentName;
    }
}
