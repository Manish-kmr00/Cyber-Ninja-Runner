package com.amazon.aps.ads.util;

import com.amazon.aps.ads.ApsLog;
import com.amazon.aps.shared.APSAnalytics;
import com.amazon.aps.shared.analytics.APSEventSeverity;
import com.amazon.aps.shared.analytics.APSEventType;
import com.facebook.gamingservices.cloudgaming.internal.SDKConstants;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: ApsAdExtensions.kt */
/* JADX INFO: loaded from: classes10.dex */
@Metadata(d1 = {"\u0000.\n\u0000\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u0012\u0010\u0005\u001a\u00020\u0006*\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0001\u001a\u0012\u0010\b\u001a\u00020\u0006*\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0001\u001a\u0012\u0010\t\u001a\u00020\u0006*\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0001\u001a(\u0010\n\u001a\u00020\u0006*\u00020\u00022\b\u0010\u000b\u001a\u0004\u0018\u00010\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0001\u001a8\u0010\n\u001a\u00020\u0006*\u00020\u00022\b\u0010\u000b\u001a\u0004\u0018\u00010\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u00012\u000e\u0010\b\u001a\n\u0018\u00010\u0010j\u0004\u0018\u0001`\u0011\u001a8\u0010\u0012\u001a\u00020\u0006*\u00020\u00022\b\u0010\u000b\u001a\u0004\u0018\u00010\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u00012\u000e\u0010\b\u001a\n\u0018\u00010\u0010j\u0004\u0018\u0001`\u0011\"\u0015\u0010\u0000\u001a\u00020\u0001*\u00020\u00028F¢\u0006\u0006\u001a\u0004\b\u0003\u0010\u0004¨\u0006\u0013"}, d2 = {"TAG", "", "", "getTAG", "(Ljava/lang/Object;)Ljava/lang/String;", "d", "", "message", "e", "i", "logEvent", SDKConstants.PARAM_DEBUG_MESSAGE_SEVERITY, "Lcom/amazon/aps/shared/analytics/APSEventSeverity;", "eventType", "Lcom/amazon/aps/shared/analytics/APSEventType;", "errorDetails", "Ljava/lang/Exception;", "Lkotlin/Exception;", "remoteLog", "DTBAndroidSDK_release"}, k = 2, mv = {1, 6, 0}, xi = 48)
public final class ApsAdExtensionsKt {
    public static final String getTAG(Object obj) {
        Intrinsics.checkNotNullParameter(obj, "<this>");
        String simpleName = obj.getClass().getSimpleName();
        Intrinsics.checkNotNullExpressionValue(simpleName, "this::class.java.simpleName");
        return simpleName;
    }

    public static final void d(Object obj, String message) {
        Intrinsics.checkNotNullParameter(obj, "<this>");
        Intrinsics.checkNotNullParameter(message, "message");
        ApsLog.d(getTAG(obj), message);
    }

    public static final void e(Object obj, String message) {
        Intrinsics.checkNotNullParameter(obj, "<this>");
        Intrinsics.checkNotNullParameter(message, "message");
        ApsLog.d(getTAG(obj), message);
    }

    public static final void i(Object obj, String message) {
        Intrinsics.checkNotNullParameter(obj, "<this>");
        Intrinsics.checkNotNullParameter(message, "message");
        ApsLog.d(getTAG(obj), message);
    }

    public static final void logEvent(Object obj, APSEventSeverity aPSEventSeverity, APSEventType aPSEventType, String str, Exception exc) {
        Intrinsics.checkNotNullParameter(obj, "<this>");
        APSAnalytics.logEvent(aPSEventSeverity, aPSEventType, str, exc);
    }

    public static final void remoteLog(Object obj, APSEventSeverity aPSEventSeverity, APSEventType aPSEventType, String str, Exception exc) {
        Intrinsics.checkNotNullParameter(obj, "<this>");
        APSAnalytics.logEvent(aPSEventSeverity, aPSEventType, str, exc);
    }

    public static final void logEvent(Object obj, APSEventSeverity aPSEventSeverity, APSEventType aPSEventType, String str) {
        Intrinsics.checkNotNullParameter(obj, "<this>");
        APSAnalytics.logEvent(aPSEventSeverity, aPSEventType, str);
    }
}
