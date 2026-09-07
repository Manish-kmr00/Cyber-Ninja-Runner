package com.smaato.sdk.video.vast.buildlight;

import com.smaato.sdk.core.log.LogDomain;
import com.smaato.sdk.core.log.Logger;
import com.smaato.sdk.core.util.Objects;
import com.smaato.sdk.video.vast.exceptions.VastElementMissingException;
import com.smaato.sdk.video.vast.model.Companion;
import com.smaato.sdk.video.vast.model.VastCompanionScenario;
import com.smaato.sdk.video.vast.model.VastScenarioCreativeData;
import com.smaato.sdk.video.vast.model.VastScenarioResourceData;

/* JADX INFO: loaded from: classes13.dex */
public class VastCompanionScenarioMapper {
    public VastCompanionScenario mapVastCompanionScenario(Logger logger, Companion companion, VastScenarioCreativeData vastScenarioCreativeData, boolean z) {
        Objects.requireNonNull(logger);
        try {
            return new VastCompanionScenario.Builder().setVastScenarioResourceData(new VastScenarioResourceData.Builder().setStaticResource(companion.staticResources.isEmpty() ? null : companion.staticResources.get(0)).setHtmlResources(companion.htmlResources.isEmpty() ? null : companion.htmlResources.get(0)).setIFrameResources(companion.iFrameResources.isEmpty() ? null : companion.iFrameResources.get(0)).build(z)).setVastScenarioCreativeData(vastScenarioCreativeData).setId(companion.id).setAdParameters(companion.adParameters).setAdSlotID(companion.adSlotID).setAltText(companion.altText).setApiFramework(companion.apiFramework).setWidth(companion.width).setHeight(companion.height).setAssetHeight(companion.assetHeight).setAssetWidth(companion.assetWidth).setExpandedHeight(companion.expandedHeight).setExpandedWidth(companion.expandedWidth).setPxRatio(companion.pxRatio).setTrackingEvents(companion.trackingEvents).setCompanionClickThrough(companion.companionClickThrough).setCompanionClickTrackings(companion.companionClickTrackings).build();
        } catch (VastElementMissingException e) {
            logger.error(LogDomain.VAST, e, "Cannot build VastCompanionScenario", new Object[0]);
            return null;
        }
    }
}
