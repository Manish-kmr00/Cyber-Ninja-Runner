package com.json;

import com.mbridge.msdk.foundation.download.core.DownloadCommon;
import com.safedk.android.internal.partials.IronSourceNetworkBridge;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\b\u0012\u0004\u0012\u00020\u00040\u0003B\u0007¢\u0006\u0004\b\u0010\u0010\u0011J\u0010\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\u0010\u0010\n\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\bH\u0016R \u0010\u000f\u001a\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\r0\u000b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0007\u0010\u000e¨\u0006\u0012"}, d2 = {"Lcom/ironsource/un;", "Lcom/ironsource/ft;", "Lorg/json/JSONObject;", "Lcom/ironsource/dt;", "Lcom/ironsource/sn;", "record", "", "a", "Lcom/ironsource/et;", b9.a.t, DownloadCommon.DOWNLOAD_REPORT_FIND_FILE_RESULT_VALUE_B, "", "", "Lcom/ironsource/h3;", "Ljava/util/Map;", "advertiserBundlesHistory", "<init>", "()V", "mediationsdk_release"}, k = 1, mv = {1, 8, 0})
public final class un implements ft<JSONObject>, dt<sn> {

    /* JADX INFO: renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final Map<String, h3> advertiserBundlesHistory = new LinkedHashMap();

    @Override // com.json.dt
    public void a(sn record) {
        Intrinsics.checkNotNullParameter(record, "record");
        String advertiserBundleId = record.getAdvertiserBundleId();
        Map<String, h3> map = this.advertiserBundlesHistory;
        h3 h3Var = map.get(advertiserBundleId);
        if (h3Var == null) {
            h3Var = new h3();
            map.put(advertiserBundleId, h3Var);
        }
        h3Var.a(record.a(new tn()));
    }

    @Override // com.json.we
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public JSONObject a(et mode) throws JSONException {
        Intrinsics.checkNotNullParameter(mode, "mode");
        JSONObject jSONObjectJsonObjectInit = IronSourceNetworkBridge.jsonObjectInit();
        for (Map.Entry<String, h3> entry : this.advertiserBundlesHistory.entrySet()) {
            String key = entry.getKey();
            JSONArray jSONArrayA = entry.getValue().a(mode);
            if (jSONArrayA.length() > 0) {
                jSONObjectJsonObjectInit.put(key, jSONArrayA);
            }
        }
        return jSONObjectJsonObjectInit;
    }
}
