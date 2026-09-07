package net.pubnative.lite.sdk.models.request;

import net.pubnative.lite.sdk.utils.json.BindField;
import net.pubnative.lite.sdk.utils.json.JsonModel;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes13.dex */
public class Source extends JsonModel {

    @BindField
    private Integer fd;

    @BindField
    private String pchain;

    @BindField
    private String tid;

    public Source() {
    }

    public Source(JSONObject jSONObject) throws Exception {
        fromJson(jSONObject);
    }

    public Integer getFinalDecision() {
        return this.fd;
    }

    public String getTransactionId() {
        return this.tid;
    }

    public String getPaymentIdChain() {
        return this.pchain;
    }
}
