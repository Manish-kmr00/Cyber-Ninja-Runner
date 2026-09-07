package com.json;

import com.amazon.aps.shared.metrics.model.ApsMetricsDataMap;
import com.fyber.inneractive.sdk.external.InneractiveMediationDefs;
import com.mbridge.msdk.foundation.download.core.DownloadCommon;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.collections.IntIterator;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntRange;
import kotlin.ranges.RangesKt;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes10.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b$\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b+\u0010,J\u001e\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002R\u0017\u0010\r\u001a\u00020\t8\u0006¢\u0006\f\n\u0004\b\b\u0010\n\u001a\u0004\b\u000b\u0010\fR\u0017\u0010\u0010\u001a\u00020\t8\u0006¢\u0006\f\n\u0004\b\u000e\u0010\n\u001a\u0004\b\u000f\u0010\fR\u0017\u0010\u0012\u001a\u00020\t8\u0006¢\u0006\f\n\u0004\b\u0011\u0010\n\u001a\u0004\b\u000e\u0010\fR\u0017\u0010\u0016\u001a\u00020\u00078\u0006¢\u0006\f\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0011\u0010\u0015R\u0017\u0010\u001b\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0019\u0010\u001aR\u0017\u0010\u001d\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u001c\u0010\u0018\u001a\u0004\b\u0013\u0010\u001aR\u0017\u0010\u001f\u001a\u00020\u00078\u0006¢\u0006\f\n\u0004\b\u001e\u0010\u0014\u001a\u0004\b\b\u0010\u0015R\u0017\u0010!\u001a\u00020\u00078\u0006¢\u0006\f\n\u0004\b \u0010\u0014\u001a\u0004\b\u001c\u0010\u0015R\u0017\u0010#\u001a\u00020\u00078\u0006¢\u0006\f\n\u0004\b\"\u0010\u0014\u001a\u0004\b\u0017\u0010\u0015R\u001d\u0010&\u001a\b\u0012\u0004\u0012\u00020\u00070\u00068\u0006¢\u0006\f\n\u0004\b\u000f\u0010$\u001a\u0004\b\"\u0010%R\u001d\u0010'\u001a\b\u0012\u0004\u0012\u00020\u00070\u00068\u0006¢\u0006\f\n\u0004\b\u000b\u0010$\u001a\u0004\b \u0010%R\u001d\u0010)\u001a\b\u0012\u0004\u0012\u00020\u00070\u00068\u0006¢\u0006\f\n\u0004\b\u0019\u0010$\u001a\u0004\b(\u0010%R\u001d\u0010*\u001a\b\u0012\u0004\u0012\u00020\u00070\u00068\u0006¢\u0006\f\n\u0004\b(\u0010$\u001a\u0004\b\u001e\u0010%¨\u0006-"}, d2 = {"Lcom/ironsource/g4;", "", "Lorg/json/JSONObject;", "applicationEvents", "", "key", "", "", "a", "", "Z", CampaignEx.JSON_KEY_AD_K, "()Z", i4.f3767a, DownloadCommon.DOWNLOAD_REPORT_FIND_FILE_RESULT_VALUE_B, "j", i4.b, ApsMetricsDataMap.APSMETRICS_FIELD_CUSTOM, i4.c, "d", "I", "()I", i4.d, "e", "Ljava/lang/String;", "l", "()Ljava/lang/String;", i4.e, InneractiveMediationDefs.GENDER_FEMALE, "eventsType", "g", i4.g, "h", i4.h, "i", i4.i, "Ljava/util/List;", "()Ljava/util/List;", "optOutEvents", "optInEvents", "m", i4.l, i4.m, "<init>", "(Lorg/json/JSONObject;)V", "mediationsdk_release"}, k = 1, mv = {1, 8, 0})
public final class g4 {

    /* JADX INFO: renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final boolean sendUltraEvents;

    /* JADX INFO: renamed from: b, reason: from kotlin metadata */
    private final boolean sendEventsToggle;

    /* JADX INFO: renamed from: c, reason: from kotlin metadata */
    private final boolean eventsCompression;

    /* JADX INFO: renamed from: d, reason: from kotlin metadata */
    private final int eventsCompressionLevel;

    /* JADX INFO: renamed from: e, reason: from kotlin metadata */
    private final String serverEventsURL;

    /* JADX INFO: renamed from: f, reason: from kotlin metadata */
    private final String eventsType;

    /* JADX INFO: renamed from: g, reason: from kotlin metadata */
    private final int backupThreshold;

    /* JADX INFO: renamed from: h, reason: from kotlin metadata */
    private final int maxNumberOfEvents;

    /* JADX INFO: renamed from: i, reason: from kotlin metadata */
    private final int maxEventsPerBatch;

    /* JADX INFO: renamed from: j, reason: from kotlin metadata */
    private final List<Integer> optOutEvents;

    /* JADX INFO: renamed from: k, reason: from kotlin metadata */
    private final List<Integer> optInEvents;

    /* JADX INFO: renamed from: l, reason: from kotlin metadata */
    private final List<Integer> triggerEvents;

    /* JADX INFO: renamed from: m, reason: from kotlin metadata */
    private final List<Integer> nonConnectivityEvents;

    public g4(JSONObject applicationEvents) {
        Intrinsics.checkNotNullParameter(applicationEvents, "applicationEvents");
        this.sendUltraEvents = applicationEvents.optBoolean(i4.f3767a, false);
        this.sendEventsToggle = applicationEvents.optBoolean(i4.b, false);
        this.eventsCompression = applicationEvents.optBoolean(i4.c, false);
        this.eventsCompressionLevel = applicationEvents.optInt(i4.d, -1);
        String strOptString = applicationEvents.optString(i4.e);
        Intrinsics.checkNotNullExpressionValue(strOptString, "applicationEvents.optStr…(SERVER_EVENTS_URL_FIELD)");
        this.serverEventsURL = strOptString;
        String strOptString2 = applicationEvents.optString(i4.f);
        Intrinsics.checkNotNullExpressionValue(strOptString2, "applicationEvents.optString(SERVER_EVENTS_TYPE)");
        this.eventsType = strOptString2;
        this.backupThreshold = applicationEvents.optInt(i4.g, -1);
        this.maxNumberOfEvents = applicationEvents.optInt(i4.h, -1);
        this.maxEventsPerBatch = applicationEvents.optInt(i4.i, 5000);
        this.optOutEvents = a(applicationEvents, i4.j);
        this.optInEvents = a(applicationEvents, i4.k);
        this.triggerEvents = a(applicationEvents, i4.l);
        this.nonConnectivityEvents = a(applicationEvents, i4.m);
    }

    private final List<Integer> a(JSONObject applicationEvents, String key) {
        JSONArray jSONArrayOptJSONArray = applicationEvents.optJSONArray(key);
        if (jSONArrayOptJSONArray == null) {
            return CollectionsKt.emptyList();
        }
        IntRange intRangeUntil = RangesKt.until(0, jSONArrayOptJSONArray.length());
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(intRangeUntil, 10));
        Iterator<Integer> it = intRangeUntil.iterator();
        while (it.hasNext()) {
            arrayList.add(Integer.valueOf(jSONArrayOptJSONArray.getInt(((IntIterator) it).nextInt())));
        }
        return arrayList;
    }

    /* JADX INFO: renamed from: a, reason: from getter */
    public final int getBackupThreshold() {
        return this.backupThreshold;
    }

    /* JADX INFO: renamed from: b, reason: from getter */
    public final boolean getEventsCompression() {
        return this.eventsCompression;
    }

    /* JADX INFO: renamed from: c, reason: from getter */
    public final int getEventsCompressionLevel() {
        return this.eventsCompressionLevel;
    }

    /* JADX INFO: renamed from: d, reason: from getter */
    public final String getEventsType() {
        return this.eventsType;
    }

    /* JADX INFO: renamed from: e, reason: from getter */
    public final int getMaxEventsPerBatch() {
        return this.maxEventsPerBatch;
    }

    /* JADX INFO: renamed from: f, reason: from getter */
    public final int getMaxNumberOfEvents() {
        return this.maxNumberOfEvents;
    }

    public final List<Integer> g() {
        return this.nonConnectivityEvents;
    }

    public final List<Integer> h() {
        return this.optInEvents;
    }

    public final List<Integer> i() {
        return this.optOutEvents;
    }

    /* JADX INFO: renamed from: j, reason: from getter */
    public final boolean getSendEventsToggle() {
        return this.sendEventsToggle;
    }

    /* JADX INFO: renamed from: k, reason: from getter */
    public final boolean getSendUltraEvents() {
        return this.sendUltraEvents;
    }

    /* JADX INFO: renamed from: l, reason: from getter */
    public final String getServerEventsURL() {
        return this.serverEventsURL;
    }

    public final List<Integer> m() {
        return this.triggerEvents;
    }
}
