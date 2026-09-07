package io.bidmachine.ads.networks.gam;

import io.bidmachine.AdsFormat;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes11.dex */
public class GAMTypeConfigFactory {
    private static final String KEY_AD_UNIT_ID = "ad_unit_id";
    private static final String KEY_CACHE_SIZE = "cache_size";
    private static final String KEY_FORMAT = "format";
    private static final String KEY_UNITS = "units";

    public static GAMTypeConfig create(JSONObject jSONObject) {
        try {
            AdsFormat adsFormatByRemoteName = AdsFormat.byRemoteName(jSONObject.getString("format"));
            if (adsFormatByRemoteName == null) {
                return null;
            }
            String string = jSONObject.getString(KEY_AD_UNIT_ID);
            ArrayList arrayList = new ArrayList();
            JSONArray jSONArray = jSONObject.getJSONArray(KEY_UNITS);
            for (int i = 0; i < jSONArray.length(); i++) {
                arrayList.add(GAMUnitDataFactory.create(string, jSONArray.getJSONObject(i)));
            }
            if (arrayList.isEmpty()) {
                return null;
            }
            return new GAMTypeConfig(adsFormatByRemoteName, arrayList, jSONObject.optInt(KEY_CACHE_SIZE, 2));
        } catch (Throwable unused) {
            return null;
        }
    }
}
