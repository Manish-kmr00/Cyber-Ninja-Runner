package com.pubmatic.sdk.common.models;

import com.pubmatic.sdk.common.POBCommonConstants;
import com.pubmatic.sdk.common.log.POBLog;
import com.pubmatic.sdk.common.utility.POBUtils;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes13.dex */
public class POBDataProvider {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f7579a;
    private final String b;
    private int c;
    private final Map d;
    private JSONObject e;

    public POBDataProvider(String str) {
        this(str, null);
    }

    public void addSegment(POBSegment pOBSegment) {
        if (pOBSegment == null || POBUtils.isNullOrEmpty(pOBSegment.getSegId())) {
            POBLog.warn("POBDataProvider", POBCommonConstants.MSG_INVALID_DATA, "segments");
            return;
        }
        String segId = pOBSegment.getSegId();
        if (this.d.containsKey(segId)) {
            POBLog.warn("POBDataProvider", POBCommonConstants.MSG_DUPLICATE_FIELD, "segments", "id");
        } else {
            this.d.put(segId, pOBSegment);
        }
    }

    public JSONObject getExt() {
        return this.e;
    }

    public String getId() {
        return this.f7579a;
    }

    public String getName() {
        return this.b;
    }

    public int getSegTax() {
        return this.c;
    }

    public POBSegment getSegment(String str) {
        return (POBSegment) this.d.get(str);
    }

    public Map<String, POBSegment> getSegments() {
        return this.d;
    }

    public void removeAllSegments() {
        this.d.clear();
    }

    public POBSegment removeSegment(String str) {
        return (POBSegment) this.d.remove(str);
    }

    public void setExt(JSONObject jSONObject) {
        this.e = jSONObject;
    }

    public void setSegTax(int i) {
        this.c = i;
    }

    public POBDataProvider(String str, String str2) {
        this.f7579a = str2;
        this.b = str;
        this.c = 0;
        this.d = Collections.synchronizedMap(new HashMap());
    }
}
