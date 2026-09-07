package com.pubmatic.sdk.video.vastparser;

import com.pubmatic.sdk.video.POBVastError;
import com.pubmatic.sdk.video.vastmodels.POBVast;

/* JADX INFO: loaded from: classes11.dex */
public interface POBVastParserListener {
    void onFailure(POBVast pOBVast, POBVastError pOBVastError);

    void onSuccess(POBVast pOBVast);
}
