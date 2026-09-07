package net.pubnative.lite.sdk.analytics;

import android.os.Handler;
import android.os.Looper;
import java.util.ArrayList;
import java.util.List;
import net.pubnative.lite.sdk.analytics.tracker.ReportingTracker;
import net.pubnative.lite.sdk.analytics.tracker.ReportingTrackerCallback;
import net.pubnative.lite.sdk.utils.Logger;

/* JADX INFO: loaded from: classes13.dex */
public class ReportingController {
    private static final String TAG = "ReportingController";
    private List<ReportingEvent> adEventList;
    private List<ReportingTracker> adFiredTrackers;
    private final List<ReportingEventCallback> mListeners = new ArrayList();
    private final List<ReportingTrackerCallback> mTrackerListeners = new ArrayList();

    public void addCallback(ReportingEventCallback reportingEventCallback) {
        synchronized (this) {
            if (reportingEventCallback != null) {
                if (!this.mListeners.contains(reportingEventCallback)) {
                    this.mListeners.add(reportingEventCallback);
                }
            }
        }
    }

    public boolean removeCallback(ReportingEventCallback reportingEventCallback) {
        synchronized (this) {
            try {
                if (reportingEventCallback == null) {
                    return false;
                }
                int iIndexOf = this.mListeners.indexOf(reportingEventCallback);
                if (iIndexOf == -1) {
                    return false;
                }
                this.mListeners.remove(iIndexOf);
                return true;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public synchronized void reportEvent(final ReportingEvent reportingEvent) {
        new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: net.pubnative.lite.sdk.analytics.ReportingController$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.m9531xacad7329(reportingEvent);
            }
        });
    }

    /* JADX INFO: renamed from: lambda$reportEvent$0$net-pubnative-lite-sdk-analytics-ReportingController, reason: not valid java name */
    /* synthetic */ void m9531xacad7329(ReportingEvent reportingEvent) {
        ReportingEventCallback reportingEventCallback;
        for (int i = 0; i < this.mListeners.size(); i++) {
            try {
                if (i < this.mListeners.size() && (reportingEventCallback = this.mListeners.get(i)) != null) {
                    reportingEventCallback.onEvent(reportingEvent);
                }
            } catch (Exception e) {
                Logger.d("exception - ReportingController", e.toString());
            }
        }
    }

    public void cacheAdEventList(List<ReportingEvent> list) {
        this.adEventList = list;
    }

    public List<ReportingEvent> getAdEventList() {
        return this.adEventList;
    }

    public void clearAdEventList() {
        List<ReportingEvent> list = this.adEventList;
        if (list != null) {
            list.clear();
        }
    }

    public synchronized void reportFiredTracker(final ReportingTracker reportingTracker) {
        new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: net.pubnative.lite.sdk.analytics.ReportingController$$ExternalSyntheticLambda1
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.m9532x5281cc36(reportingTracker);
            }
        });
    }

    /* JADX INFO: renamed from: lambda$reportFiredTracker$1$net-pubnative-lite-sdk-analytics-ReportingController, reason: not valid java name */
    /* synthetic */ void m9532x5281cc36(ReportingTracker reportingTracker) {
        ReportingTrackerCallback reportingTrackerCallback;
        for (int i = 0; i < this.mTrackerListeners.size(); i++) {
            try {
                if (i < this.mTrackerListeners.size() && (reportingTrackerCallback = this.mTrackerListeners.get(i)) != null) {
                    reportingTrackerCallback.onFire(reportingTracker);
                }
            } catch (Exception e) {
                Logger.d("exception - ReportingController", e.toString());
            }
        }
    }

    public void addTrackerCallback(ReportingTrackerCallback reportingTrackerCallback) {
        synchronized (this) {
            if (reportingTrackerCallback != null) {
                if (!this.mTrackerListeners.contains(reportingTrackerCallback)) {
                    this.mTrackerListeners.add(reportingTrackerCallback);
                }
            }
        }
    }

    public boolean removeTrackerCallback(ReportingTrackerCallback reportingTrackerCallback) {
        synchronized (this) {
            try {
                if (reportingTrackerCallback == null) {
                    return false;
                }
                int iIndexOf = this.mTrackerListeners.indexOf(reportingTrackerCallback);
                if (iIndexOf == -1) {
                    return false;
                }
                this.mTrackerListeners.remove(iIndexOf);
                return true;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public List<ReportingTracker> getFiredTrackersList() {
        return this.adFiredTrackers;
    }

    public void clearFiredTrackerstList() {
        List<ReportingTracker> list = this.adFiredTrackers;
        if (list != null) {
            list.clear();
        }
    }
}
