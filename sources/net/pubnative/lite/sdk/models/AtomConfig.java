package net.pubnative.lite.sdk.models;

import java.util.Iterator;
import java.util.List;
import net.pubnative.lite.sdk.utils.json.BindField;
import net.pubnative.lite.sdk.utils.json.JsonModel;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes12.dex */
public class AtomConfig extends JsonModel {

    @BindField
    public List<AdData> app_level;

    public AtomConfig() {
    }

    public AtomConfig(JSONObject jSONObject) throws Exception {
        fromJson(jSONObject);
    }

    public Boolean isAtomEnabled() {
        AdData next;
        List<AdData> list = this.app_level;
        boolean z = false;
        if (list == null || list.isEmpty()) {
            return false;
        }
        Iterator<AdData> it = this.app_level.iterator();
        do {
            if (!it.hasNext()) {
                next = null;
                break;
            }
            next = it.next();
        } while (!next.type.equals("custom_cta"));
        if (next != null && next.getBooleanField("boolean").booleanValue()) {
            z = true;
        }
        return Boolean.valueOf(z);
    }
}
