package com.smaato.sdk.video.vast.buildlight;

import com.smaato.sdk.core.util.Objects;
import com.smaato.sdk.core.util.TextUtils;
import com.smaato.sdk.video.vast.model.UniversalAdId;
import com.smaato.sdk.video.vast.model.VastCompanionScenario;
import java.util.List;

/* JADX INFO: loaded from: classes11.dex */
public class VastCompanionScenarioMerger {
    public VastCompanionScenario merge(VastCompanionScenario vastCompanionScenario, List<VastCompanionScenario> list) {
        Objects.requireNonNull(vastCompanionScenario, "Parameter companionScenario should not be null for VastCompanionScenarioMerger::merge");
        Objects.requireNonNull(list, "Parameter wrapperCompanionScenarios should not be null for VastCompanionScenarioMerger::merge");
        VastCompanionScenario vastCompanionScenarioMerge = vastCompanionScenario;
        for (VastCompanionScenario vastCompanionScenario2 : list) {
            if (validToMerge(vastCompanionScenario, vastCompanionScenario2)) {
                vastCompanionScenarioMerge = merge(vastCompanionScenarioMerge, vastCompanionScenario2);
            }
        }
        return vastCompanionScenarioMerge;
    }

    private VastCompanionScenario merge(VastCompanionScenario vastCompanionScenario, VastCompanionScenario vastCompanionScenario2) {
        return vastCompanionScenario.newBuilder().setTrackingEvents(VastScenarioMergeUtils.merge(vastCompanionScenario.trackingEvents, vastCompanionScenario2.trackingEvents)).setCompanionClickTrackings(VastScenarioMergeUtils.merge(vastCompanionScenario.companionClickTrackings, vastCompanionScenario2.companionClickTrackings)).setCompanionClickThrough(TextUtils.isEmpty(vastCompanionScenario.companionClickThrough) ? vastCompanionScenario2.companionClickThrough : vastCompanionScenario.companionClickThrough).build();
    }

    private boolean validToMerge(VastCompanionScenario vastCompanionScenario, VastCompanionScenario vastCompanionScenario2) {
        return validToMerge(vastCompanionScenario.vastScenarioCreativeData.universalAdId, vastCompanionScenario2.vastScenarioCreativeData.universalAdId);
    }

    private boolean validToMerge(UniversalAdId universalAdId, UniversalAdId universalAdId2) {
        return universalAdId.equals(universalAdId2) || universalAdId2.equals(UniversalAdId.DEFAULT);
    }
}
