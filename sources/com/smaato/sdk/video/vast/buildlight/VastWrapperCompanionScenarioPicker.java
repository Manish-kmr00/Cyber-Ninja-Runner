package com.smaato.sdk.video.vast.buildlight;

import com.smaato.sdk.core.util.Objects;
import com.smaato.sdk.video.vast.buildlight.compare.SizeComparator;
import com.smaato.sdk.video.vast.model.UniversalAdId;
import com.smaato.sdk.video.vast.model.VastCompanionScenario;
import com.smaato.sdk.video.vast.model.VastScenarioResourceData;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* JADX INFO: loaded from: classes9.dex */
public class VastWrapperCompanionScenarioPicker {
    public VastCompanionScenario pickWrapperCompanionScenario(UniversalAdId universalAdId, List<VastCompanionScenario> list, VastConfigurationSettings vastConfigurationSettings) {
        ArrayList<VastCompanionScenario> arrayList;
        Objects.requireNonNull(universalAdId, "Parameter universalAdId should not be null for VastWrapperCompanionScenarioPicker::pickWrapperCompanionScenario");
        Objects.requireNonNull(list, "Parameter wrapperVastCompanionScenarios should not be null for VastWrapperCompanionScenarioPicker::pickWrapperCompanionScenario");
        Objects.requireNonNull(vastConfigurationSettings, "Parameter vastConfigurationSettings should not be null for VastWrapperCompanionScenarioPicker::pickWrapperCompanionScenario");
        if (list.isEmpty()) {
            return null;
        }
        if (universalAdId.equals(UniversalAdId.DEFAULT)) {
            arrayList = new ArrayList(list);
        } else {
            ArrayList arrayList2 = new ArrayList();
            ArrayList arrayList3 = new ArrayList();
            for (VastCompanionScenario vastCompanionScenario : list) {
                if (vastCompanionScenario.vastScenarioCreativeData.universalAdId.equals(universalAdId)) {
                    arrayList2.add(vastCompanionScenario);
                } else if (vastCompanionScenario.vastScenarioCreativeData.universalAdId.equals(UniversalAdId.DEFAULT)) {
                    arrayList3.add(vastCompanionScenario);
                }
            }
            if (arrayList2.isEmpty()) {
                arrayList = arrayList3.isEmpty() ? new ArrayList(list) : arrayList3;
            } else {
                arrayList = arrayList2;
            }
        }
        Collections.sort(arrayList, new SizeComparator(vastConfigurationSettings));
        for (VastCompanionScenario vastCompanionScenario2 : arrayList) {
            VastScenarioResourceData vastScenarioResourceData = vastCompanionScenario2.resourceData;
            if (vastScenarioResourceData.staticResources != null || vastScenarioResourceData.iFrameResources != null || vastScenarioResourceData.htmlResources != null) {
                return vastCompanionScenario2;
            }
        }
        return (VastCompanionScenario) arrayList.get(0);
    }
}
