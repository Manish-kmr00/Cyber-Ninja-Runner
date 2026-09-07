package com.pubmatic.sdk.common.base;

import com.pubmatic.sdk.common.base.POBAdDescriptor;
import com.pubmatic.sdk.common.models.POBAdResponse;

/* JADX INFO: loaded from: classes11.dex */
public interface POBAdBuilding<T extends POBAdDescriptor> {

    public interface POBAdBuilderListener<T extends POBAdDescriptor> {
        void adBuilderOnSuccess(POBAdResponse<T> pOBAdResponse);
    }

    void build(POBAdResponse<T> pOBAdResponse);

    void setListener(POBAdBuilderListener<T> pOBAdBuilderListener);
}
