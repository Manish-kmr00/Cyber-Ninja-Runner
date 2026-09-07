package com.pubmatic.sdk.common.base;

import android.os.Trace;
import com.pubmatic.sdk.common.POBError;
import com.pubmatic.sdk.common.base.POBAdDescriptor;
import com.pubmatic.sdk.common.log.POBLog;
import com.pubmatic.sdk.common.models.POBAdResponse;
import com.pubmatic.sdk.common.network.POBHttpRequest;
import com.pubmatic.sdk.common.network.POBNetworkHandler;
import com.pubmatic.sdk.common.network.POBNetworkResult;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes8.dex */
public class POBCommunicator<AdDescriptorType extends POBAdDescriptor> implements POBNetworkHandler.POBNetworkListener<JSONObject>, POBResponseParsing.POBResponseParserListener<AdDescriptorType>, POBAdBuilding.POBAdBuilderListener<AdDescriptorType>, POBNetworkHandler.POBNetworkResultListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final POBRequestBuilding f7556a;
    private final POBResponseParsing b;
    private final POBAdBuilding c;
    private final POBNetworkHandler d;
    private POBCommunicatorListener e;
    private POBNetworkResult f;
    private POBErrorCustomisationListener g;

    public interface POBCommunicatorListener<AdDescriptorType extends POBAdDescriptor> {
        void onError(POBError pOBError);

        void onSuccess(POBAdResponse<AdDescriptorType> pOBAdResponse);
    }

    public interface POBErrorCustomisationListener {
        POBError customisePOBError(POBError pOBError, POBNetworkResult pOBNetworkResult);
    }

    public POBCommunicator(POBRequestBuilding pOBRequestBuilding, POBResponseParsing pOBResponseParsing, POBAdBuilding<AdDescriptorType> pOBAdBuilding, POBNetworkHandler pOBNetworkHandler) {
        this.f7556a = pOBRequestBuilding;
        this.d = pOBNetworkHandler;
        this.c = pOBAdBuilding;
        pOBAdBuilding.setListener(this);
        this.b = pOBResponseParsing;
        pOBResponseParsing.setListener(this);
    }

    private void a(POBError pOBError) {
        POBCommunicatorListener pOBCommunicatorListener = this.e;
        if (pOBCommunicatorListener != null) {
            pOBCommunicatorListener.onError(pOBError);
        }
    }

    @Override // com.pubmatic.sdk.common.base.POBAdBuilding.POBAdBuilderListener
    public void adBuilderOnSuccess(POBAdResponse<AdDescriptorType> pOBAdResponse) {
        POBCommunicatorListener pOBCommunicatorListener = this.e;
        if (pOBCommunicatorListener != null) {
            pOBCommunicatorListener.onSuccess(pOBAdResponse);
        }
    }

    public void cancel() {
        this.d.cancelRequest(String.valueOf(this.f7556a.hashCode()));
    }

    public POBNetworkResult getNetworkResult() {
        return this.f;
    }

    @Override // com.pubmatic.sdk.common.network.POBNetworkHandler.POBNetworkListener
    public void onFailure(POBError pOBError) {
        POBErrorCustomisationListener pOBErrorCustomisationListener = this.g;
        if (pOBErrorCustomisationListener != null) {
            pOBError = pOBErrorCustomisationListener.customisePOBError(pOBError, this.f);
        }
        POBLog.debug("POBCommunicator", "Failed to receive an Ad response from server - %s", pOBError.getErrorMessage());
        a(pOBError);
    }

    @Override // com.pubmatic.sdk.common.network.POBNetworkHandler.POBNetworkResultListener
    public void onResult(POBNetworkResult pOBNetworkResult) {
        this.f = pOBNetworkResult;
    }

    @Override // com.pubmatic.sdk.common.base.POBResponseParsing.POBResponseParserListener
    public void parserOnError(POBError pOBError) {
        a(pOBError);
    }

    @Override // com.pubmatic.sdk.common.base.POBResponseParsing.POBResponseParserListener
    public void parserOnSuccess(POBAdResponse<AdDescriptorType> pOBAdResponse) {
        this.c.build(new POBAdResponse.Builder(pOBAdResponse).build());
    }

    public void requestAd() {
        POBHttpRequest pOBHttpRequestBuild = this.f7556a.build();
        if (pOBHttpRequestBuild == null) {
            a(new POBError(1001, "Exception occurred while preparing this ad request"));
            return;
        }
        Trace.endSection();
        Trace.beginSection("POB Network Call");
        POBLog.debug("POBCommunicator", "Sending an Ad request - : %s", pOBHttpRequestBuild.toString());
        this.d.sendJSONRequest(pOBHttpRequestBuild, this, this);
    }

    public void setListener(POBCommunicatorListener<AdDescriptorType> pOBCommunicatorListener) {
        this.e = pOBCommunicatorListener;
    }

    public void setPOBErrorCustomisationListener(POBErrorCustomisationListener pOBErrorCustomisationListener) {
        this.g = pOBErrorCustomisationListener;
    }

    @Override // com.pubmatic.sdk.common.network.POBNetworkHandler.POBNetworkListener
    public void onSuccess(JSONObject jSONObject) {
        if (jSONObject != null) {
            POBLog.debug("POBCommunicator", "Successfully received Ad response from server - %s", jSONObject.toString());
        }
        Trace.endSection();
        Trace.beginSection("POB Response Parsing");
        this.b.parse(jSONObject);
    }
}
