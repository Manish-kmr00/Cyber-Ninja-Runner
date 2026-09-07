package com.pubmatic.sdk.common.base;

import com.pubmatic.sdk.common.POBError;
import com.pubmatic.sdk.common.base.POBAdDescriptor;
import com.pubmatic.sdk.common.models.POBAdResponse;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes7.dex */
public interface POBResponseParsing<T extends POBAdDescriptor> {

    public interface POBResponseParserListener<T extends POBAdDescriptor> {
        void parserOnError(POBError pOBError);

        void parserOnSuccess(POBAdResponse<T> pOBAdResponse);
    }

    void parse(JSONObject jSONObject);

    void setListener(POBResponseParserListener<T> pOBResponseParserListener);
}
