package com.amazon.device.ads;

import com.amazon.aps.shared.APSAnalytics;
import com.amazon.aps.shared.analytics.APSEventSeverity;
import com.amazon.aps.shared.analytics.APSEventType;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONException;

/* JADX INFO: loaded from: classes2.dex */
public class DTBMetricsProcessor {
    static String ALERT_SDK_WRAPPING = "alert_sdk_wrapping";
    static String ALERT_SDK_WRAPPING_V2 = "alert_sdk_wrapping_v2";
    static String REPORT_LOAD_FAILURE = "fetch_failure";
    static String REPORT_LOAD_LATENCY = "fetch_latency";
    static String REPORT_LOST_BID = "lost_bid";
    static String REPORT_MEDIATION_LATENCY = "mediation_latency";
    private static String SIMPLE_TAG = "DTB_Metrics";
    private static DTBMetricsProcessor theProcessor = new DTBMetricsProcessor();
    private final Object lock = new Object();
    private List<DTBMetricReport> reportQueue = new ArrayList();
    private boolean running;

    static DTBMetricsProcessor getInstance() {
        return theProcessor;
    }

    private DTBMetricsProcessor() {
    }

    private boolean isMainThread() {
        return DTBAdUtil.isMainThread();
    }

    void submitExpiredReport(final List<DTBMetricReport.BidWrapper> list) {
        if (isMainThread()) {
            DtbThreadService.getInstance().execute(new Runnable() { // from class: com.amazon.device.ads.DTBMetricsProcessor$$ExternalSyntheticLambda0
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.m4417x770f9e76(list);
                }
            });
        } else {
            m4417x770f9e76(list);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: submitExpiredReportImpl, reason: merged with bridge method [inline-methods] */
    public void m4417x770f9e76(List<DTBMetricReport.BidWrapper> list) {
        Iterator<DTBMetricReport.BidWrapper> it = list.iterator();
        while (it.hasNext()) {
            addReport(DTBMetricReport.reportWithBidIdAndType(it.next(), REPORT_LOST_BID));
        }
        dispenseReport();
    }

    void submitSimpleReportBidId(DTBMetricReport.BidWrapper bidWrapper, String str) {
        addReport(DTBMetricReport.reportWithBidIdAndType(bidWrapper, str));
        dispenseReport();
    }

    void submitErrorReport(String str, Map<String, Object> map) {
        addReport(DTBMetricReport.reportWithTypeAndExtraProperties(str, map));
        dispenseReport();
    }

    void submitErrorReport(String str, Map<String, Object> map, DTBMetricReport.BidWrapper bidWrapper) {
        addReport(DTBMetricReport.reportWithTypeAndExtraProperties(str, map, bidWrapper));
        dispenseReport();
    }

    void submitLatencyReportBidId(DTBMetricReport.BidWrapper bidWrapper, String str, int i) {
        addReport(DTBMetricReport.reportWithBidTypeLatency(bidWrapper, str, i));
        dispenseReport();
    }

    private void dispenseReport() {
        if (isMainThread()) {
            DtbThreadService.getInstance().execute(new Runnable() { // from class: com.amazon.device.ads.DTBMetricsProcessor$$ExternalSyntheticLambda1
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.m4416xbe5b2681();
                }
            });
        } else {
            m4416xbe5b2681();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: dispenseReportImpl, reason: merged with bridge method [inline-methods] */
    public void m4416xbe5b2681() {
        synchronized (this.lock) {
            if (this.running) {
                return;
            }
            this.running = true;
            while (this.reportQueue.size() > 0) {
                DTBMetricReport dTBMetricReport = this.reportQueue.get(0);
                try {
                    if (!DTBMetricsConfiguration.getInstance().isTypeEnabled(dTBMetricReport.getType())) {
                        DtbLog.debug(SIMPLE_TAG, "Report type:" + dTBMetricReport.getType() + " is ignored");
                        removeFromQueue();
                    } else {
                        String completeURLForPixelsBasedOnReportURL = getCompleteURLForPixelsBasedOnReportURL(dTBMetricReport);
                        DtbLog.debug(SIMPLE_TAG, "Report URL:\n" + completeURLForPixelsBasedOnReportURL + "\nType:" + dTBMetricReport.getType());
                        DtbLog.debug(SIMPLE_TAG, "Report:\n" + dTBMetricReport);
                        new DtbHttpClient(completeURLForPixelsBasedOnReportURL).executeGET(60000);
                        removeFromQueue();
                        DtbLog.debug(SIMPLE_TAG, "Report Submission Success");
                    }
                } catch (MalformedURLException e) {
                    DtbLog.warn("Malformed Exception:" + e.getMessage());
                } catch (IOException e2) {
                    DtbLog.warn("IOException:" + e2.getMessage());
                    DtbLog.debug(SIMPLE_TAG, "Report Submission Failure");
                } catch (RuntimeException e3) {
                    e = e3;
                    DtbLog.warn("Exception:" + e.getMessage());
                    removeFromQueue();
                    APSAnalytics.logEvent(APSEventSeverity.FATAL, APSEventType.EXCEPTION, "Exception occurred while processing metric report", e);
                } catch (JSONException e4) {
                    e = e4;
                    DtbLog.warn("Exception:" + e.getMessage());
                    removeFromQueue();
                    APSAnalytics.logEvent(APSEventSeverity.FATAL, APSEventType.EXCEPTION, "Exception occurred while processing metric report", e);
                }
            }
            this.running = false;
        }
    }

    private void addReport(DTBMetricReport dTBMetricReport) {
        synchronized (this.reportQueue) {
            this.reportQueue.add(dTBMetricReport);
        }
    }

    private void removeFromQueue() {
        synchronized (this.reportQueue) {
            this.reportQueue.remove(0);
        }
    }

    private String getCompleteURLForPixelsBasedOnReportURL(DTBMetricReport dTBMetricReport) throws UnsupportedEncodingException {
        String hostname;
        if (dTBMetricReport.getHostname() == null || dTBMetricReport.getHostname().trim().length() == 0) {
            hostname = DtbConstants.AAX_HOSTNAME;
        } else {
            hostname = dTBMetricReport.getHostname();
        }
        if (dTBMetricReport.getBidId() != null && dTBMetricReport.getBidId().trim().length() != 0) {
            return String.format("%s/x/px/%s/%s%s", hostname, dTBMetricReport.getBidId(), dTBMetricReport.toEncodedString(), cacheBusterQueryString());
        }
        return String.format("%s/x/px/p/PH/%s%s", hostname, dTBMetricReport.toEncodedString(), cacheBusterQueryString());
    }

    private static String cacheBusterQueryString() {
        if (AdRegistration.isTestMode()) {
            return "?cb=0";
        }
        return String.format("?cb=%d", Integer.valueOf((int) (Math.random() * 1.0E7d)));
    }
}
