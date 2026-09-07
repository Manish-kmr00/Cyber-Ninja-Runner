package com.pubmatic.sdk.common.base;

import com.pubmatic.sdk.common.POBError;
import com.pubmatic.sdk.common.base.POBAdDescriptor;
import com.pubmatic.sdk.common.models.POBAdResponse;
import com.pubmatic.sdk.common.network.POBNetworkResult;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;

/* JADX INFO: loaded from: classes13.dex */
public class POBBidderResult<T extends POBAdDescriptor> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private POBAdResponse f7555a;
    private POBError b;
    private POBNetworkResult c;

    public POBAdResponse<T> getAdResponse() {
        return this.f7555a;
    }

    public POBError getError() {
        return this.b;
    }

    public POBNetworkResult getNetworkResult() {
        return this.c;
    }

    public void setAdResponse(POBAdResponse<T> pOBAdResponse) {
        this.f7555a = pOBAdResponse;
    }

    public void setError(POBError pOBError) {
        this.b = pOBError;
    }

    public void setNetworkResult(POBNetworkResult pOBNetworkResult) {
        this.c = pOBNetworkResult;
    }

    public String toString() {
        return "POBBidderResult{adResponse=" + this.f7555a + ", error=" + this.b + ", networkResult=" + this.c + AbstractJsonLexerKt.END_OBJ;
    }
}
