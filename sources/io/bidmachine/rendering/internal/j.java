package io.bidmachine.rendering.internal;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.provider.CalendarContract;
import com.facebook.internal.AnalyticsEvents;
import com.json.b9;
import com.safedk.android.analytics.brandsafety.BrandSafetyUtils;
import com.safedk.android.utils.Logger;
import io.bidmachine.iab.mraid.MraidCalendarEvent;
import io.bidmachine.rendering.utils.UiUtils;
import io.bidmachine.util.Executable;
import io.bidmachine.util.Utils;
import io.bidmachine.util.appintents.IntentUtils;
import java.util.Date;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import net.pubnative.lite.sdk.mraid.nativefeature.MRAIDNativeFeatureProvider;

/* JADX INFO: loaded from: classes9.dex */
public final class j {
    public static final a b = new a(null);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final ExecutorService f12367a;

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public j() {
        ExecutorService executorServiceNewSingleThreadExecutor = Executors.newSingleThreadExecutor();
        Intrinsics.checkNotNullExpressionValue(executorServiceNewSingleThreadExecutor, "newSingleThreadExecutor()");
        this.f12367a = executorServiceNewSingleThreadExecutor;
    }

    private final Intent a(MraidCalendarEvent mraidCalendarEvent) {
        int i;
        Intent intentPutExtra = new Intent("android.intent.action.INSERT").setData(CalendarContract.Events.CONTENT_URI).putExtra("title", mraidCalendarEvent.getDescription()).putExtra(MRAIDNativeFeatureProvider.EXTRA_EVENT_BEGIN_TIME, mraidCalendarEvent.getStart().getTime());
        Intrinsics.checkNotNullExpressionValue(intentPutExtra, "Intent(Intent.ACTION_INS…CalendarEvent.start.time)");
        Date end = mraidCalendarEvent.getEnd();
        if (end != null) {
            intentPutExtra.putExtra("endTime", end.getTime());
        }
        String summary = mraidCalendarEvent.getSummary();
        if (summary != null) {
            intentPutExtra.putExtra("description", summary);
        }
        String location = mraidCalendarEvent.getLocation();
        if (location != null) {
            intentPutExtra.putExtra(MRAIDNativeFeatureProvider.EVENT_LOCATION, location);
        }
        String status = mraidCalendarEvent.getStatus();
        int i2 = 2;
        if (status != null) {
            if (Intrinsics.areEqual(status, "confirmed")) {
                i = 1;
            } else {
                i = Intrinsics.areEqual(status, AnalyticsEvents.PARAMETER_SHARE_OUTCOME_CANCELLED) ? 2 : 0;
            }
            intentPutExtra.putExtra(MRAIDNativeFeatureProvider.STATUS, i);
        }
        String transparency = mraidCalendarEvent.getTransparency();
        if (transparency != null) {
            if (Intrinsics.areEqual(transparency, b9.h.T)) {
                i2 = 1;
            } else if (Intrinsics.areEqual(transparency, "opaque")) {
                i2 = 0;
            }
            intentPutExtra.putExtra("availability", i2);
        }
        String recurrence = mraidCalendarEvent.getRecurrence();
        if (recurrence != null) {
            intentPutExtra.putExtra("rrule", recurrence);
        }
        return intentPutExtra;
    }

    private final void b(Context context, final Uri uri, final Executable executable) {
        final Context applicationContext = context.getApplicationContext();
        this.f12367a.execute(new Runnable() { // from class: io.bidmachine.rendering.internal.j$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                j.a(this.f$0, applicationContext, uri, executable);
            }
        });
    }

    private final void c(Context context, Uri uri, Executable executable) {
        IntentUtils.findEndpointAndOpenUrl(context, uri.toString(), executable);
    }

    public static void safedk_Context_startActivity_97cb3195734cf5c9cc3418feeafa6dd6(Context p0, Intent p1) {
        Logger.d("SafeDK-Special|SafeDK: Call> Landroid/content/Context;->startActivity(Landroid/content/Intent;)V");
        if (p1 == null) {
            return;
        }
        BrandSafetyUtils.detectAdClick(p1, "io.bidmachine");
        p0.startActivity(p1);
    }

    private final Intent a(Intent intent) {
        Intent flags = Intent.createChooser(intent, "").setFlags(268435456);
        Intrinsics.checkNotNullExpressionValue(flags, "createChooser(intent, \"\"…t.FLAG_ACTIVITY_NEW_TASK)");
        return flags;
    }

    private final void b(Context context, MraidCalendarEvent mraidCalendarEvent, Executable executable) {
        a(context, a(a(mraidCalendarEvent)), executable);
    }

    public final void a(Context context, Uri uri, Executable executable) {
        Boolean boolValueOf;
        Intrinsics.checkNotNullParameter(context, "context");
        if (uri == null) {
            m.a("IntentLauncher", "launch - Uri is null", new Object[0]);
            UiUtils.onUiThreadWithArgSafely(Boolean.FALSE, executable);
        } else {
            if (Utils.isHttpUri(uri)) {
                b(context, uri, executable);
                return;
            }
            if (uri.getScheme() != null) {
                boolValueOf = Boolean.valueOf(IntentUtils.openUrl(context, uri.toString()));
            } else {
                m.a("IntentLauncher", "launch - Invalid uri: %s", uri);
                boolValueOf = Boolean.FALSE;
            }
            UiUtils.onUiThreadWithArgSafely(boolValueOf, executable);
        }
    }

    public final void a(Context context, MraidCalendarEvent mraidCalendarEvent, Executable executable) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(mraidCalendarEvent, "mraidCalendarEvent");
        Context applicationContext = context.getApplicationContext();
        Intrinsics.checkNotNullExpressionValue(applicationContext, "applicationContext");
        b(applicationContext, mraidCalendarEvent, executable);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(j this$0, Context applicationContext, Uri uri, Executable executable) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(uri, "$uri");
        Intrinsics.checkNotNullExpressionValue(applicationContext, "applicationContext");
        this$0.c(applicationContext, uri, executable);
    }

    private final void a(Context context, Intent intent, Executable executable) {
        try {
            safedk_Context_startActivity_97cb3195734cf5c9cc3418feeafa6dd6(context, intent);
            UiUtils.onUiThreadWithArgSafely(Boolean.TRUE, executable);
        } catch (Exception e) {
            m.b(e);
            UiUtils.onUiThreadWithArgSafely(Boolean.FALSE, executable);
        }
    }
}
