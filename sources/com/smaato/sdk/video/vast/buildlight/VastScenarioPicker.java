package com.smaato.sdk.video.vast.buildlight;

import com.smaato.sdk.core.log.Logger;
import com.smaato.sdk.core.util.Objects;
import com.smaato.sdk.video.vast.model.InLine;
import com.smaato.sdk.video.vast.model.VastRawScenario;
import com.smaato.sdk.video.vast.model.VastScenario;
import com.smaato.sdk.video.vast.model.VastTree;
import com.smaato.sdk.video.vast.model.Wrapper;
import java.util.HashSet;

/* JADX INFO: loaded from: classes12.dex */
public class VastScenarioPicker {
    private final InLineAdContainerPicker inLineAdContainerPicker;
    private final VastScenarioMapper vastScenarioMapper;
    private final VastScenarioWrapperMapper vastScenarioWrapperMapper;
    private final VastScenarioWrapperMerger vastScenarioWrapperMerger;
    private final WrapperAdContainerPicker wrapperAdContainerPicker;

    public VastScenarioPicker(InLineAdContainerPicker inLineAdContainerPicker, WrapperAdContainerPicker wrapperAdContainerPicker, VastScenarioWrapperMerger vastScenarioWrapperMerger, VastScenarioMapper vastScenarioMapper, VastScenarioWrapperMapper vastScenarioWrapperMapper) {
        this.inLineAdContainerPicker = (InLineAdContainerPicker) Objects.requireNonNull(inLineAdContainerPicker, "Parameter inLineAdContainerPicker should be null for VastScenarioPicker::new");
        this.wrapperAdContainerPicker = (WrapperAdContainerPicker) Objects.requireNonNull(wrapperAdContainerPicker, "Parameter wrapperAdContainerPicker should be null for VastScenarioPicker::new");
        this.vastScenarioWrapperMerger = (VastScenarioWrapperMerger) Objects.requireNonNull(vastScenarioWrapperMerger, "Parameter vastScenarioWrapperMerger should be null for VastScenarioPicker::new");
        this.vastScenarioMapper = (VastScenarioMapper) Objects.requireNonNull(vastScenarioMapper, "Parameter vastScenarioMapper should be null for VastScenarioPicker::new");
        this.vastScenarioWrapperMapper = (VastScenarioWrapperMapper) Objects.requireNonNull(vastScenarioWrapperMapper, "Parameter vastScenarioWrapperMapper should be null for VastScenarioPicker::new");
    }

    public VastScenarioResult pickVastScenario(Logger logger, VastTree vastTree, VastConfigurationSettings vastConfigurationSettings) {
        Objects.requireNonNull(logger, "Parameter logger should not be null for VastScenarioPicker::pickVastScenario");
        Objects.requireNonNull(vastTree, "Parameter vastTree should not be null for VastScenarioPicker::pickVastScenario");
        Objects.requireNonNull(vastConfigurationSettings, "Parameter vastConfigurationSettings should not be null for VastScenarioPicker::pickVastScenario");
        HashSet hashSet = new HashSet();
        HashSet hashSet2 = new HashSet(vastTree.errors);
        VastScenarioResult.Builder errorUrls = new VastScenarioResult.Builder().setErrors(hashSet).setErrorUrls(hashSet2);
        if (vastTree.ads.isEmpty()) {
            return errorUrls.build();
        }
        AdContainer<InLine> adContainerPickInLineContainer = this.inLineAdContainerPicker.pickInLineContainer(vastTree.ads);
        if (adContainerPickInLineContainer != null) {
            VastScenarioResult vastScenarioResultMapVastScenario = this.vastScenarioMapper.mapVastScenario(logger, adContainerPickInLineContainer.model, vastConfigurationSettings);
            hashSet.addAll(vastScenarioResultMapVastScenario.errors);
            hashSet2.addAll(vastScenarioResultMapVastScenario.errorUrls);
            return errorUrls.setVastScenario(vastScenarioResultMapVastScenario.vastScenario).build();
        }
        AdContainer<Wrapper> adContainerPickWrapperContainer = this.wrapperAdContainerPicker.pickWrapperContainer(vastTree.ads);
        if (adContainerPickWrapperContainer != null) {
            Wrapper wrapper = adContainerPickWrapperContainer.model;
            hashSet2.addAll(wrapper.errors);
            if (wrapper.vastTree != null) {
                VastRawScenario vastRawScenarioMapVastScenarioForWrapper = this.vastScenarioWrapperMapper.mapVastScenarioForWrapper(logger, wrapper, vastConfigurationSettings);
                hashSet2.addAll(vastRawScenarioMapVastScenarioForWrapper.errors);
                VastScenarioResult vastScenarioResultPickVastScenario = pickVastScenario(logger, wrapper.vastTree, vastConfigurationSettings);
                hashSet.addAll(vastScenarioResultPickVastScenario.errors);
                hashSet2.addAll(vastScenarioResultPickVastScenario.errorUrls);
                VastScenario vastScenario = vastScenarioResultPickVastScenario.vastScenario;
                if (vastScenario != null) {
                    errorUrls.setVastScenario(this.vastScenarioWrapperMerger.merge(vastScenario, vastRawScenarioMapVastScenarioForWrapper, vastConfigurationSettings));
                }
            }
        }
        return errorUrls.build();
    }
}
