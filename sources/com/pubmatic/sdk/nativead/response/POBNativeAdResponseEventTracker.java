package com.pubmatic.sdk.nativead.response;

import com.pubmatic.sdk.common.viewability.POBVerificationScriptResource;
import com.pubmatic.sdk.nativead.POBNativeConstants;
import com.pubmatic.sdk.openwrap.core.nativead.POBNativeEventTrackingMethod;
import com.pubmatic.sdk.openwrap.core.nativead.POBNativeEventType;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes13.dex */
public class POBNativeAdResponseEventTracker implements POBVerificationScriptResource {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f7706a;
    private final POBNativeEventType b;
    private final POBNativeEventTrackingMethod c;
    private JSONObject d;
    private final List e;

    public POBNativeAdResponseEventTracker(String str, POBNativeEventType pOBNativeEventType, POBNativeEventTrackingMethod pOBNativeEventTrackingMethod) {
        this.f7706a = str;
        this.b = pOBNativeEventType;
        this.c = pOBNativeEventTrackingMethod;
        ArrayList arrayList = new ArrayList();
        this.e = arrayList;
        arrayList.add(str);
    }

    public JSONObject getExt() {
        return this.d;
    }

    @Override // com.pubmatic.sdk.common.viewability.POBVerificationScriptResource
    public List<String> getJavaScriptResource() {
        return this.e;
    }

    public POBNativeEventTrackingMethod getTrackingMethod() {
        return this.c;
    }

    public POBNativeEventType getType() {
        return this.b;
    }

    public String getUrl() {
        return this.f7706a;
    }

    @Override // com.pubmatic.sdk.common.viewability.POBVerificationScriptResource
    public String getVendorKey() {
        JSONObject jSONObject = this.d;
        if (jSONObject != null) {
            return jSONObject.optString(POBNativeConstants.NATIVE_VENDOR_KEY);
        }
        return null;
    }

    @Override // com.pubmatic.sdk.common.viewability.POBVerificationScriptResource
    public String getVerificationParameter() {
        JSONObject jSONObject = this.d;
        if (jSONObject != null) {
            return jSONObject.optString(POBNativeConstants.NATIVE_VERIFICATION_PARAMETERS);
        }
        return null;
    }

    public void setExt(JSONObject jSONObject) {
        this.d = jSONObject;
    }

    public String toString() {
        return "{\n Event Type: " + this.b + "\nEvent Tracking Method: " + this.c + "\nUrl: " + this.f7706a + " \n}";
    }
}
