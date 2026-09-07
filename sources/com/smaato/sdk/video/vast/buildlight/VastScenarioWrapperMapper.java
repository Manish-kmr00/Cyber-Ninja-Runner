package com.smaato.sdk.video.vast.buildlight;

import com.smaato.sdk.core.log.Logger;
import com.smaato.sdk.core.util.Objects;
import com.smaato.sdk.video.vast.model.Companion;
import com.smaato.sdk.video.vast.model.CompanionAds;
import com.smaato.sdk.video.vast.model.Creative;
import com.smaato.sdk.video.vast.model.Linear;
import com.smaato.sdk.video.vast.model.VastRawScenario;
import com.smaato.sdk.video.vast.model.VastScenarioCreativeData;
import com.smaato.sdk.video.vast.model.Wrapper;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;

/* JADX INFO: loaded from: classes13.dex */
public class VastScenarioWrapperMapper {
    private final VastCompanionPicker vastCompanionPicker;
    private final VastCompanionScenarioMapper vastCompanionScenarioMapper;
    private final VastMediaFileScenarioWrapperMapper vastMediaFileScenarioWrapperMapper;
    private final VastScenarioCreativeDataMapper vastScenarioCreativeDataMapper;

    public VastScenarioWrapperMapper(VastCompanionPicker vastCompanionPicker, VastCompanionScenarioMapper vastCompanionScenarioMapper, VastMediaFileScenarioWrapperMapper vastMediaFileScenarioWrapperMapper, VastScenarioCreativeDataMapper vastScenarioCreativeDataMapper) {
        this.vastCompanionPicker = (VastCompanionPicker) Objects.requireNonNull(vastCompanionPicker, "Parameter vastCompanionPicker should be null for VastScenarioPicker::new");
        this.vastCompanionScenarioMapper = (VastCompanionScenarioMapper) Objects.requireNonNull(vastCompanionScenarioMapper, "Parameter vastCompanionScenarioMapper should be null for VastScenarioPicker::new");
        this.vastMediaFileScenarioWrapperMapper = (VastMediaFileScenarioWrapperMapper) Objects.requireNonNull(vastMediaFileScenarioWrapperMapper, "Parameter vastMediaFileScenarioWrapperMapper should be null for VastScenarioPicker::new");
        this.vastScenarioCreativeDataMapper = (VastScenarioCreativeDataMapper) Objects.requireNonNull(vastScenarioCreativeDataMapper, "Parameter vastScenarioCreativeDataMapper should be null for VastScenarioPicker::new");
    }

    VastRawScenario mapVastScenarioForWrapper(Logger logger, Wrapper wrapper, VastConfigurationSettings vastConfigurationSettings) {
        Objects.requireNonNull(logger);
        Objects.requireNonNull(vastConfigurationSettings);
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        for (Creative creative : wrapper.creatives) {
            VastScenarioCreativeData vastScenarioCreativeDataMapVastScenarioCreativeData = this.vastScenarioCreativeDataMapper.mapVastScenarioCreativeData(creative);
            Linear linear = creative.linear;
            if (linear != null) {
                arrayList.add(this.vastMediaFileScenarioWrapperMapper.mapMediaFileScenario(logger, linear, vastScenarioCreativeDataMapVastScenarioCreativeData));
            }
            CompanionAds companionAds = creative.companionAds;
            if (companionAds != null && companionAds.companions.size() > 0) {
                Iterator<Companion> it = creative.companionAds.companions.iterator();
                while (it.hasNext()) {
                    arrayList2.add(this.vastCompanionScenarioMapper.mapVastCompanionScenario(logger, it.next(), vastScenarioCreativeDataMapVastScenarioCreativeData, true));
                }
            }
        }
        String str = wrapper.blockedAdCategories;
        return new VastRawScenario.Builder().setAdSystem(wrapper.adSystem).setAdVerifications(wrapper.adVerifications).setImpressions(wrapper.impressions).setErrors(wrapper.errors).setVastCompanionScenarios(arrayList2).setViewableImpression(wrapper.viewableImpression).setVastMediaFileScenarios(arrayList).setBlockedAdCategories(str == null ? Collections.emptyList() : Arrays.asList(str.split("\\s*,\\s*"))).build();
    }
}
