package sg.bigo.ads.ad.banner;

import com.amazon.aps.shared.metrics.model.ApsMetricsDataMap;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import sg.bigo.ads.api.AdSize;

/* JADX INFO: loaded from: classes13.dex */
public final class a {
    public static JSONArray a(List<AdSize> list) {
        JSONArray jSONArray = new JSONArray();
        for (AdSize adSize : list) {
            if (adSize != null) {
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put("w", adSize.getWidth());
                    jSONObject.put("h", adSize.getHeight());
                    jSONObject.put(ApsMetricsDataMap.APSMETRICS_FIELD_TIMESTAMP, AdSize.ADAPTIVE.equals(adSize.f13083a) ? 1 : 0);
                } catch (JSONException unused) {
                }
                jSONArray.put(jSONObject);
            }
        }
        return jSONArray;
    }
}
