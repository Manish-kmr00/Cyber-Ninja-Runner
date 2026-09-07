package com.smaato.sdk.video.vast.buildlight;

import com.smaato.sdk.core.util.Objects;
import com.smaato.sdk.video.vast.model.UniversalAdId;
import com.smaato.sdk.video.vast.model.VastCompanionScenario;
import com.smaato.sdk.video.vast.model.VastMediaFileScenario;
import com.smaato.sdk.video.vast.model.VastRawScenario;
import com.smaato.sdk.video.vast.model.VastScenario;

/* JADX INFO: loaded from: classes6.dex */
public class VastScenarioWrapperMerger {
    private final VastCompanionScenarioMerger vastCompanionScenarioMerger;
    private final VastMediaFileScenarioMerger vastMediaFileScenarioMerger;
    private final ViewableImpressionMerger viewableImpressionMerger;
    private final VastWrapperCompanionScenarioPicker wrapperCompanionScenarioPicker;

    public VastScenarioWrapperMerger(VastMediaFileScenarioMerger vastMediaFileScenarioMerger, VastWrapperCompanionScenarioPicker vastWrapperCompanionScenarioPicker, VastCompanionScenarioMerger vastCompanionScenarioMerger, ViewableImpressionMerger viewableImpressionMerger) {
        this.vastMediaFileScenarioMerger = (VastMediaFileScenarioMerger) Objects.requireNonNull(vastMediaFileScenarioMerger, "Parameter vastMediaFileScenarioMerger should be null for VastScenarioWrapperMerger::new");
        this.wrapperCompanionScenarioPicker = (VastWrapperCompanionScenarioPicker) Objects.requireNonNull(vastWrapperCompanionScenarioPicker, "Parameter wrapperCompanionScenarioPicker should be null for VastScenarioWrapperMerger::new");
        this.vastCompanionScenarioMerger = (VastCompanionScenarioMerger) Objects.requireNonNull(vastCompanionScenarioMerger, "Parameter vastCompanionScenarioMerger should be null for VastScenarioWrapperMerger::new");
        this.viewableImpressionMerger = (ViewableImpressionMerger) Objects.requireNonNull(viewableImpressionMerger, "Parameter viewableImpressionMerger should be null for VastScenarioWrapperMerger::new");
    }

    VastScenario merge(VastScenario vastScenario, VastRawScenario vastRawScenario, VastConfigurationSettings vastConfigurationSettings) {
        VastCompanionScenario vastCompanionScenarioMerge;
        VastScenario.Builder blockedAdCategories = vastScenario.newBuilder().setImpressions(VastScenarioMergeUtils.merge(vastScenario.impressions, vastRawScenario.impressions)).setAdVerifications(VastScenarioMergeUtils.merge(vastScenario.adVerifications, vastRawScenario.adVerifications)).setCategories(VastScenarioMergeUtils.merge(vastScenario.categories, vastRawScenario.categories)).setErrors(VastScenarioMergeUtils.merge(vastScenario.errors, vastRawScenario.errors)).setViewableImpression(this.viewableImpressionMerger.merge(vastScenario.viewableImpression, vastRawScenario.viewableImpression)).setBlockedAdCategories(VastScenarioMergeUtils.merge(vastScenario.blockedAdCategories, vastRawScenario.blockedAdCategories));
        VastMediaFileScenario vastMediaFileScenario = vastScenario.vastMediaFileScenario;
        blockedAdCategories.setVastMediaFileScenario(this.vastMediaFileScenarioMerger.merge(vastMediaFileScenario, vastRawScenario.vastRawMediaFileScenarios));
        UniversalAdId universalAdId = vastMediaFileScenario.vastScenarioCreativeData.universalAdId;
        VastCompanionScenario vastCompanionScenario = vastScenario.vastCompanionScenario;
        if (vastCompanionScenario == null) {
            vastCompanionScenarioMerge = this.wrapperCompanionScenarioPicker.pickWrapperCompanionScenario(universalAdId, vastRawScenario.vastCompanionScenarios, vastConfigurationSettings);
            if (!vastScenario.vastCompanionScenarioList.isEmpty() && vastCompanionScenarioMerge != null) {
                vastCompanionScenarioMerge = this.vastCompanionScenarioMerger.merge(vastCompanionScenarioMerge, vastScenario.vastCompanionScenarioList);
            }
        } else {
            vastCompanionScenarioMerge = this.vastCompanionScenarioMerger.merge(vastCompanionScenario, vastRawScenario.vastCompanionScenarios);
        }
        if (vastCompanionScenarioMerge != null) {
            blockedAdCategories.setVastCompanionScenario(vastCompanionScenarioMerge);
        }
        return blockedAdCategories.build();
    }
}
