package com.pubmatic.sdk.common.session;

import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\b\u0010\u0006\u001a\u00020\u0003H&J\u0010\u0010\u0007\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&¨\u0006\b"}, d2 = {"Lcom/pubmatic/sdk/common/session/POBAppStateMonitoring;", "", "addAppLifecycleListener", "", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "Lcom/pubmatic/sdk/common/session/POBAppStateMonitor$POBAppLifecycleListener;", "release", "removeAppLifecycleListener", "common_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public interface POBAppStateMonitoring {
    void addAppLifecycleListener(POBAppStateMonitor.POBAppLifecycleListener listener);

    void release();

    void removeAppLifecycleListener(POBAppStateMonitor.POBAppLifecycleListener listener);
}
