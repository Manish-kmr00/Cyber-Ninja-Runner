package net.pubnative.lite.sdk.analytics;

import java.util.Arrays;

/* JADX INFO: loaded from: classes5.dex */
public class CrashController {
    public ReportingEvent formatException(Exception exc) {
        ReportingEvent reportingEvent = new ReportingEvent();
        reportingEvent.setEventType("error");
        reportingEvent.setPlatform("android");
        if (exc != null) {
            if (exc.getMessage() != null) {
                reportingEvent.setErrorMessage(exc.getMessage());
            }
            StackTraceElement[] stackTrace = exc.getStackTrace();
            if (stackTrace != null) {
                reportingEvent.setCustomString("Stacktrace", Arrays.toString(stackTrace));
            }
            if (exc.getLocalizedMessage() != null) {
                reportingEvent.setCustomString("LocalizedMessage", exc.getLocalizedMessage());
            }
        }
        return reportingEvent;
    }

    public ReportingEvent formatException(Throwable th) {
        ReportingEvent reportingEvent = new ReportingEvent();
        reportingEvent.setEventType("error");
        reportingEvent.setPlatform("android");
        if (th != null) {
            if (th.getMessage() != null) {
                reportingEvent.setErrorMessage(th.getMessage());
            }
            if (th.getStackTrace() != null) {
                reportingEvent.setCustomString("Stacktrace", Arrays.toString(th.getStackTrace()));
            }
            if (th.getLocalizedMessage() != null) {
                reportingEvent.setCustomString("LocalizedMessage", th.getLocalizedMessage());
            }
        }
        return reportingEvent;
    }
}
