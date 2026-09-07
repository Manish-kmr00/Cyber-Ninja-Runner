package io.bidmachine.tracking;

import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes13.dex */
public class TrackEventInfo {
    private Map<String, Object> eventParameters;
    private long finishTimeMs;
    private final long startTimeMs;

    public TrackEventInfo() {
        long jCurrentTimeMillis = System.currentTimeMillis();
        this.startTimeMs = jCurrentTimeMillis;
        this.finishTimeMs = jCurrentTimeMillis;
    }

    public long getStartTimeMs() {
        return this.startTimeMs;
    }

    public long getFinishTimeMs() {
        return this.finishTimeMs;
    }

    public void setFinishTimeMs(long j) {
        this.finishTimeMs = Math.max(j, this.startTimeMs);
    }

    public TrackEventInfo withParameter(String str, Object obj) {
        if (this.eventParameters == null) {
            this.eventParameters = new HashMap();
        }
        this.eventParameters.put(str, obj);
        return this;
    }

    public Map<String, Object> getEventParameters() {
        return this.eventParameters;
    }
}
