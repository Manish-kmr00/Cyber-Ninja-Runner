package net.pubnative.lite.sdk.models.request;

import java.util.List;
import net.pubnative.lite.sdk.utils.json.BindField;
import net.pubnative.lite.sdk.utils.json.JsonModel;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes13.dex */
public class Data extends JsonModel {

    @BindField
    private DataExtension ext;

    @BindField
    private String id;

    @BindField
    private String name;

    @BindField
    private List<Segment> segment;

    public Data() {
    }

    public Data(JSONObject jSONObject) throws Exception {
        fromJson(jSONObject);
    }

    public String getId() {
        return this.id;
    }

    public void setId(String str) {
        this.id = str;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String str) {
        this.name = str;
    }

    public List<Segment> getSegment() {
        return this.segment;
    }

    public void setSegment(List<Segment> list) {
        this.segment = list;
    }

    public DataExtension getExt() {
        return this.ext;
    }

    public void setExt(DataExtension dataExtension) {
        this.ext = dataExtension;
    }
}
