package com.pubmatic.sdk.common.session;

import com.amazon.aps.shared.metrics.model.ApsMetricsDataMap;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.mbridge.msdk.foundation.download.core.DownloadCommon;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0010!\n\u0002\b\u0006\u0018\u0000 \u001e2\u00020\u0001:\u0002\u001e\u001fB\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u000f\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\u0007\u0010\bJ\r\u0010\t\u001a\u00020\u0006¢\u0006\u0004\b\t\u0010\bJ\u0017\u0010\f\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\nH\u0016¢\u0006\u0004\b\f\u0010\rJ\u0017\u0010\u000e\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\nH\u0016¢\u0006\u0004\b\u000e\u0010\rJ\u000f\u0010\u0010\u001a\u00020\u000fH\u0016¢\u0006\u0004\b\u0010\u0010\u0011R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0012\u0010\u0013R\u0016\u0010\u0017\u001a\u00020\u00148\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0015\u0010\u0016R\u0016\u0010\u0019\u001a\u00020\u00148\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0018\u0010\u0016R\u001c\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\n0\u001a8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001b\u0010\u001c¨\u0006 "}, d2 = {"Lcom/pubmatic/sdk/common/session/POBAppSessionHandler;", "Lcom/pubmatic/sdk/common/session/POBAppSessionHandling;", "Lcom/pubmatic/sdk/common/session/POBAppStateMonitoring;", "appStateMonitor", "<init>", "(Lcom/pubmatic/sdk/common/session/POBAppStateMonitoring;)V", "", "initiateSession", "()V", "resetSession", "Lcom/pubmatic/sdk/common/session/POBAppSessionHandler$POBAppSessionListener;", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "addAppSessionListener", "(Lcom/pubmatic/sdk/common/session/POBAppSessionHandler$POBAppSessionListener;)V", "removeAppSessionListener", "", "getSessionDuration", "()I", "a", "Lcom/pubmatic/sdk/common/session/POBAppStateMonitoring;", "", DownloadCommon.DOWNLOAD_REPORT_FIND_FILE_RESULT_VALUE_B, "J", "appForegroundStartTimer", ApsMetricsDataMap.APSMETRICS_FIELD_CUSTOM, "appBackgroundStartTimer", "", "d", "Ljava/util/List;", "listeners", "Companion", "POBAppSessionListener", "common_release"}, k = 1, mv = {1, 7, 1})
public final class POBAppSessionHandler implements POBAppSessionHandling {

    /* JADX INFO: renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final POBAppStateMonitoring appStateMonitor;

    /* JADX INFO: renamed from: b, reason: from kotlin metadata */
    private long appForegroundStartTimer;

    /* JADX INFO: renamed from: c, reason: from kotlin metadata */
    private long appBackgroundStartTimer;

    /* JADX INFO: renamed from: d, reason: from kotlin metadata */
    private List listeners;

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\b\u0010\u0004\u001a\u00020\u0003H&¨\u0006\u0005"}, d2 = {"Lcom/pubmatic/sdk/common/session/POBAppSessionHandler$POBAppSessionListener;", "", "onAppSessionReset", "", "onAppSessionStarted", "common_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public interface POBAppSessionListener {
        void onAppSessionReset();

        void onAppSessionStarted();
    }

    public POBAppSessionHandler(POBAppStateMonitoring appStateMonitor) {
        Intrinsics.checkNotNullParameter(appStateMonitor, "appStateMonitor");
        this.appStateMonitor = appStateMonitor;
        this.listeners = new ArrayList();
    }

    @Override // com.pubmatic.sdk.common.session.POBAppSessionHandling
    public void addAppSessionListener(POBAppSessionListener listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        this.listeners.add(listener);
    }

    @Override // com.pubmatic.sdk.common.session.POBAppSessionHandling
    public int getSessionDuration() {
        if (this.appForegroundStartTimer == 0) {
            return 0;
        }
        return (int) TimeUnit.MILLISECONDS.toSeconds(System.currentTimeMillis() - this.appForegroundStartTimer);
    }

    @Override // com.pubmatic.sdk.common.session.POBAppSessionHandling
    public void initiateSession() {
        this.appForegroundStartTimer = System.currentTimeMillis();
        this.appStateMonitor.addAppLifecycleListener(new POBAppStateMonitor.POBAppLifecycleListener() { // from class: com.pubmatic.sdk.common.session.POBAppSessionHandler.initiateSession.1
            @Override // com.pubmatic.sdk.common.session.POBAppStateMonitor.POBAppLifecycleListener
            public void onAppMovedToBackground() {
                POBAppSessionHandler.this.appBackgroundStartTimer = System.currentTimeMillis();
            }

            @Override // com.pubmatic.sdk.common.session.POBAppStateMonitor.POBAppLifecycleListener
            public void onAppMovedToForeground() {
                long jCurrentTimeMillis = System.currentTimeMillis() - POBAppSessionHandler.this.appBackgroundStartTimer;
                if (jCurrentTimeMillis < 0 || jCurrentTimeMillis > 180000) {
                    POBAppSessionHandler.this.resetSession();
                }
            }
        });
        Iterator it = this.listeners.iterator();
        while (it.hasNext()) {
            ((POBAppSessionListener) it.next()).onAppSessionStarted();
        }
    }

    @Override // com.pubmatic.sdk.common.session.POBAppSessionHandling
    public void removeAppSessionListener(POBAppSessionListener listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        this.listeners.remove(listener);
    }

    public final void resetSession() {
        this.appForegroundStartTimer = System.currentTimeMillis();
        this.appBackgroundStartTimer = 0L;
        Iterator it = this.listeners.iterator();
        while (it.hasNext()) {
            ((POBAppSessionListener) it.next()).onAppSessionReset();
        }
    }
}
