package net.pubnative.lite.sdk.models;

import com.pubmatic.sdk.openwrap.core.POBConstants;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;
import net.pubnative.lite.sdk.utils.json.BindField;
import net.pubnative.lite.sdk.utils.json.JsonModel;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes13.dex */
public class AdData extends JsonModel implements Serializable {

    @BindField
    public Map<String, Object> data;

    @BindField
    public String type;

    public AdData() {
    }

    public AdData(JSONObject jSONObject) throws Exception {
        fromJson(jSONObject);
    }

    public AdData(String str, String str2, String str3) {
        HashMap map = new HashMap();
        this.data = map;
        map.put(str, str3);
        this.type = str2;
    }

    public String getText() {
        return getStringField("text");
    }

    public Double getNumber() {
        return getDoubleField("number");
    }

    public String getURL() {
        return getStringField("url");
    }

    public String getJS() {
        return getStringField(POBConstants.KEY_JS);
    }

    public String getHtml() {
        return getStringField("html");
    }

    public int getWidth() {
        return getIntField("w").intValue();
    }

    public int getHeight() {
        return getIntField("h").intValue();
    }

    public String getStringField(String str) {
        try {
            return (String) getDataField(str);
        } catch (ClassCastException unused) {
            return "";
        }
    }

    public JSONObject getJSONObjectField(String str) {
        return (JSONObject) getDataField(str);
    }

    public Double getDoubleField(String str) {
        if (getDataField(str) instanceof Number) {
            return Double.valueOf(((Number) getDataField(str)).doubleValue());
        }
        return null;
    }

    public Integer getIntField(String str) {
        return (Integer) getDataField(str);
    }

    public Boolean getBooleanField(String str) {
        return (Boolean) getDataField(str);
    }

    public Boolean hasField(String str) {
        return Boolean.valueOf(this.data.containsKey(str));
    }

    protected Object getDataField(String str) {
        Map<String, Object> map = this.data;
        if (map == null || !map.containsKey(str)) {
            return null;
        }
        return this.data.get(str);
    }
}
