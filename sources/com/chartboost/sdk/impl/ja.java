package com.chartboost.sdk.impl;

import com.mbridge.msdk.foundation.download.core.DownloadCommon;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\b\u001a\u0013\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u0000¢\u0006\u0004\b\u0002\u0010\u0003\u001a\u0019\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004*\u00020\u0000H\u0002¢\u0006\u0004\b\u0006\u0010\u0007\"&\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00050\u00048\u0006X\u0087\u0004¢\u0006\u0012\n\u0004\b\u0006\u0010\b\u0012\u0004\b\n\u0010\u000b\u001a\u0004\b\u0006\u0010\t¨\u0006\r"}, d2 = {"Lorg/json/JSONObject;", "Lcom/chartboost/sdk/impl/ia;", DownloadCommon.DOWNLOAD_REPORT_FIND_FILE_RESULT_VALUE_B, "(Lorg/json/JSONObject;)Lcom/chartboost/sdk/impl/ia;", "", "Lcom/chartboost/sdk/impl/ma;", "a", "(Lorg/json/JSONObject;)Ljava/util/List;", "Ljava/util/List;", "()Ljava/util/List;", "getTRACKING_BLACKLIST_DEFAULT$annotations", "()V", "TRACKING_BLACKLIST_DEFAULT", "ChartboostMonetization-9.8.3_productionRelease"}, k = 2, mv = {1, 8, 0})
public final class ja {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final List<ma> f1052a = CollectionsKt.emptyList();

    public static final ia b(JSONObject jSONObject) {
        Intrinsics.checkNotNullParameter(jSONObject, "<this>");
        JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject("tracking");
        if (jSONObjectOptJSONObject == null) {
            return new ia(false, null, null, 0, 0, false, 0, 127, null);
        }
        boolean zOptBoolean = jSONObjectOptJSONObject.optBoolean("enabled", false);
        String strOptString = jSONObjectOptJSONObject.optString(com.json.cc.r, "https://ssp-events.chartboost.com/track/sdk");
        int iOptInt = jSONObjectOptJSONObject.optInt("eventLimit", 10);
        int iOptInt2 = jSONObjectOptJSONObject.optInt("windowDuration", 60);
        boolean zOptBoolean2 = jSONObjectOptJSONObject.optBoolean("persistenceEnabled", true);
        int iOptInt3 = jSONObjectOptJSONObject.optInt("persistenceMaxEvents", 100);
        List<ma> listA = a(jSONObjectOptJSONObject);
        Intrinsics.checkNotNullExpressionValue(strOptString, "optString(TRACKING_ENDPO…NDPOINT_TRACKING_DEFAULT)");
        return new ia(zOptBoolean, listA, strOptString, iOptInt, iOptInt2, zOptBoolean2, iOptInt3);
    }

    public static final List<ma> a(JSONObject jSONObject) {
        List listAsList;
        List<ma> listA;
        JSONArray jSONArrayOptJSONArray = jSONObject.optJSONArray("blacklist");
        return (jSONArrayOptJSONArray == null || (listAsList = b5.asList(jSONArrayOptJSONArray)) == null || (listA = na.a(listAsList)) == null) ? f1052a : listA;
    }

    public static final List<ma> a() {
        return f1052a;
    }
}
