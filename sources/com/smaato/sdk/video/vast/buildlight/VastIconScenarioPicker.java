package com.smaato.sdk.video.vast.buildlight;

import com.smaato.sdk.core.log.Logger;
import com.smaato.sdk.core.util.Objects;
import com.smaato.sdk.video.vast.model.Icon;
import com.smaato.sdk.video.vast.model.VastIconScenario;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class VastIconScenarioPicker {
    private final VastIconScenarioMapper vastIconScenarioMapper;

    public VastIconScenarioPicker(VastIconScenarioMapper vastIconScenarioMapper) {
        this.vastIconScenarioMapper = (VastIconScenarioMapper) Objects.requireNonNull(vastIconScenarioMapper);
    }

    public VastIconScenario pickIconScenario(Logger logger, List<Icon> list, boolean z) {
        Objects.requireNonNull(logger);
        Objects.requireNonNull(list);
        VastIconScenario vastIconScenarioMapVastIconScenario = null;
        if (list.isEmpty()) {
            return null;
        }
        for (Icon icon : list) {
            if (!icon.staticResources.isEmpty() || !icon.iFrameResources.isEmpty() || !icon.htmlResources.isEmpty()) {
                vastIconScenarioMapVastIconScenario = this.vastIconScenarioMapper.mapVastIconScenario(logger, icon, z);
                if (vastIconScenarioMapVastIconScenario != null) {
                    break;
                }
            }
        }
        return vastIconScenarioMapVastIconScenario;
    }
}
