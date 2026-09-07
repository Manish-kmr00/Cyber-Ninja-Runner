package net.pubnative.lite.sdk.models.request;

import net.pubnative.lite.sdk.utils.json.BindField;
import net.pubnative.lite.sdk.utils.json.JsonModel;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes6.dex */
public class Format extends JsonModel {

    @BindField
    private Integer h;

    @BindField
    private Integer hratio;

    @BindField
    private Integer w;

    @BindField
    private Integer wmin;

    @BindField
    private Integer wratio;

    public Format() {
    }

    public Format(JSONObject jSONObject) throws Exception {
        fromJson(jSONObject);
    }

    public Integer getWidth() {
        return this.w;
    }

    public void setWidth(Integer num) {
        this.w = num;
    }

    public Integer getHeight() {
        return this.h;
    }

    public void setHeight(Integer num) {
        this.h = num;
    }

    public Integer getWidthRatio() {
        return this.wratio;
    }

    public void setWidthRatio(Integer num) {
        this.wratio = num;
    }

    public Integer getHeightRatio() {
        return this.hratio;
    }

    public void setHeightRatio(Integer num) {
        this.hratio = num;
    }

    public Integer getWidthMin() {
        return this.wmin;
    }

    public void setWidthMin(Integer num) {
        this.wmin = num;
    }
}
