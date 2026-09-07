package com.smaato.sdk.video.vast.buildlight;

import com.smaato.sdk.core.util.Objects;
import com.smaato.sdk.video.vast.model.Ad;

/* JADX INFO: loaded from: classes12.dex */
class AdContainer<VastModel> {
    public final Ad ad;
    public final VastModel model;

    AdContainer(Ad ad, VastModel vastmodel) {
        Objects.requireNonNull(ad, "Parameter ad cannot be null for AdContainer::new");
        Objects.requireNonNull(vastmodel, "Parameter model cannot be null for AdContainer::new");
        this.ad = ad;
        this.model = vastmodel;
    }
}
