package com.smaato.sdk.video.vast.buildlight;

import com.smaato.sdk.video.vast.model.Creative;
import com.smaato.sdk.video.vast.model.VastScenarioCreativeData;

/* JADX INFO: loaded from: classes3.dex */
public class VastScenarioCreativeDataMapper {
    public VastScenarioCreativeData mapVastScenarioCreativeData(Creative creative) {
        return new VastScenarioCreativeData.Builder().setUniversalAdId(creative.universalAdId).setAdId(creative.adId).setId(creative.id).setApiFramework(creative.apiFramework).setSequence(creative.sequence).build();
    }
}
