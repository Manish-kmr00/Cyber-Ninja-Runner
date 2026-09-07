package com.smaato.sdk.core.mvvm.model.soma;

import com.smaato.sdk.core.mvvm.model.AdRequest;

/* JADX INFO: loaded from: classes13.dex */
public abstract class SomaAdRequest {
    private final AdRequest adRequest;

    public SomaAdRequest(AdRequest adRequest) {
        this.adRequest = adRequest;
    }

    public AdRequest getAdRequest() {
        return this.adRequest;
    }
}
