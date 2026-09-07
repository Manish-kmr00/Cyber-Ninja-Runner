package com.safedk.android.analytics.events;

import com.safedk.android.analytics.StatsCollector;
import com.safedk.android.analytics.events.base.StatsEvent;
import java.io.Serializable;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes13.dex */
public class CaughtCrashEvent extends CrashEvent implements Serializable {
    private static final String j = "CaughtCrashEvent";
    private static final long serialVersionUID = 0;

    public CaughtCrashEvent(JSONObject report) {
        super(null, StatsCollector.EventType.crash, report);
    }

    @Override // com.safedk.android.analytics.events.CrashEvent
    protected boolean c() {
        return true;
    }

    @Override // com.safedk.android.analytics.events.CrashEvent, com.safedk.android.analytics.events.base.StatsEvent
    public StatsCollector.EventType a() {
        return StatsCollector.EventType.crash;
    }

    @Override // com.safedk.android.analytics.events.CrashEvent, com.safedk.android.analytics.events.base.StatsEvent
    public String b() {
        return "";
    }

    @Override // com.safedk.android.analytics.events.CrashEvent, com.safedk.android.analytics.events.base.StatsEvent
    public void a(StatsEvent statsEvent) {
    }
}
