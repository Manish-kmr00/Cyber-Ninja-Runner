package com.smaato.sdk.core.mvvm.model.csm;

import java.io.IOException;

/* JADX INFO: loaded from: classes12.dex */
public class CsmException extends IOException {
    public CsmParameters csmParameters;
    public String somaCsmJson;

    public CsmException(String str, CsmParameters csmParameters) {
        this.somaCsmJson = str;
        this.csmParameters = csmParameters;
    }
}
