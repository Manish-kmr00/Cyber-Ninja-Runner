package io.bidmachine.ads.networks.gam;

import android.text.TextUtils;
import io.bidmachine.core.Utils;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class GAMUnitDataFactory {
    static GAMUnitData create(String str, JSONObject jSONObject) {
        try {
            return create(str, Utils.toMap(jSONObject));
        } catch (Throwable unused) {
            return null;
        }
    }

    static GAMUnitData create(String str, Map<String, String> map) {
        if (map.isEmpty()) {
            return null;
        }
        String str2 = map.get("score");
        if (TextUtils.isEmpty(str2)) {
            return null;
        }
        String str3 = map.get("price");
        if (TextUtils.isEmpty(str3)) {
            return null;
        }
        return create(str, str2, str3, map);
    }

    static GAMUnitData create(String str, String str2, String str3, Map<String, String> map) {
        return new GAMUnitData(str, Float.parseFloat(str2), Float.parseFloat(str3), map);
    }
}
