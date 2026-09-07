package com.smaato.sdk.core.violationreporter;

import com.smaato.sdk.core.log.LogDomain;
import com.smaato.sdk.core.log.Logger;
import com.smaato.sdk.core.simplehttp.SimpleHttpClient;
import com.smaato.sdk.core.util.Objects;
import com.smaato.sdk.core.util.Threads;
import java.util.List;
import java.util.Map;
import org.json.JSONException;

/* JADX INFO: loaded from: classes6.dex */
public final class AdQualityViolationReporter {
    private final AdQualityViolationReportMapper adQualityViolationReportMapper;
    private final Logger logger;
    private final String reportingApiUrl;
    private final SimpleHttpClient simpleHttpClient;

    public AdQualityViolationReporter(Logger logger, SimpleHttpClient simpleHttpClient, AdQualityViolationReportMapper adQualityViolationReportMapper, String str) {
        this.logger = logger;
        this.simpleHttpClient = simpleHttpClient;
        this.adQualityViolationReportMapper = (AdQualityViolationReportMapper) Objects.requireNonNull(adQualityViolationReportMapper);
        this.reportingApiUrl = (String) Objects.requireNonNull(str);
    }

    public void reportRichMediaAdViolation(String str, Map<String, List<String>> map, String str2, String str3, String str4, String str5, String str6, String str7, List<String> list) {
        send(this.adQualityViolationReportMapper.mapToReport(str, map, str2, str3, str4, str5, str6 == null ? "" : str6, "", "", "", str7, list, System.currentTimeMillis()));
    }

    public void reportRichMediaAdViolation(String str, String str2, String str3, String str4, String str5, String str6, String str7, List<String> list, String str8, String str9) {
        send(this.adQualityViolationReportMapper.mapToReport(str, str2, str3, str4, str5, str6 == null ? "" : str6, "", "", "", str7, list, System.currentTimeMillis(), str8, str9));
    }

    public void reportImageLoadingAdViolation(ImageAdLoadingViolationException imageAdLoadingViolationException) {
        try {
            AdQualityViolationReportMapper adQualityViolationReportMapper = this.adQualityViolationReportMapper;
            String str = imageAdLoadingViolationException.adQualityViolationType;
            Map<String, List<String>> map = imageAdLoadingViolationException.responseHeaders;
            String str2 = imageAdLoadingViolationException.publisherId;
            String str3 = imageAdLoadingViolationException.adSpaceId;
            String str4 = imageAdLoadingViolationException.bundle;
            String str5 = imageAdLoadingViolationException.client;
            String str6 = imageAdLoadingViolationException.violatedUrl;
            String str7 = imageAdLoadingViolationException.originalUrl;
            send(adQualityViolationReportMapper.mapToReport(str, map, str2, str3, str4, str5, str6, str7, str7.equals(str6) ? "" : imageAdLoadingViolationException.violatedUrl, imageAdLoadingViolationException.clickUrl, "", imageAdLoadingViolationException.clickTrackingUrls, System.currentTimeMillis()));
        } catch (Exception e) {
            this.logger.error(LogDomain.CORE, "failed to create ad quality violation report for image ad", e);
        }
    }

    public void reportAdTrackerViolation(String str, Map<String, List<String>> map, String str2, String str3, String str4, String str5, String str6, String str7, List<String> list) {
        try {
            send(this.adQualityViolationReportMapper.mapToReport(str, map, str2, str3, str4, str5, str6, str7, !str7.isEmpty() ? "" : str6, "", "", list, System.currentTimeMillis()));
        } catch (Exception e) {
            this.logger.error(LogDomain.CORE, "failed to create ad quality violation report", e);
        }
    }

    public void reportAdTrackerViolation(String str, String str2, String str3, String str4, String str5, String str6, String str7, List<String> list, String str8, String str9) {
        try {
            send(this.adQualityViolationReportMapper.mapToReport(str, str2, str3, str4, str5, str6, str7, !str7.isEmpty() ? "" : str6, "", "", list, System.currentTimeMillis(), str8, str9));
        } catch (Exception e) {
            this.logger.error(LogDomain.CORE, "failed to create ad quality violation report", e);
        }
    }

    private void send(Report report) {
        try {
            final String string = report.toJson().toString();
            this.logger.debug(LogDomain.CORE, "going to send: %s", string);
            Threads.runOnBackgroundThread(new Runnable() { // from class: com.smaato.sdk.core.violationreporter.AdQualityViolationReporter$$ExternalSyntheticLambda0
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.m5578xb38cb3(string);
                }
            });
        } catch (JSONException e) {
            this.logger.error(LogDomain.CORE, e, "Error while sending violation report", new Object[0]);
        }
    }

    /* JADX INFO: renamed from: lambda$send$0$com-smaato-sdk-core-violationreporter-AdQualityViolationReporter, reason: not valid java name */
    /* synthetic */ void m5578xb38cb3(String str) {
        this.simpleHttpClient.sendDataAndForget(this.reportingApiUrl, str);
    }
}
