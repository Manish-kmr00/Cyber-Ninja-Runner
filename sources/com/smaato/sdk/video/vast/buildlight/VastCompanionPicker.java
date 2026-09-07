package com.smaato.sdk.video.vast.buildlight;

import com.smaato.sdk.core.util.Objects;
import com.smaato.sdk.video.vast.buildlight.compare.SizeComparator;
import com.smaato.sdk.video.vast.model.Companion;
import com.smaato.sdk.video.vast.model.CompanionAds;
import com.smaato.sdk.video.vast.model.Creative;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes10.dex */
public class VastCompanionPicker {
    public Companion pickCompanion(CompanionAds companionAds, VastConfigurationSettings vastConfigurationSettings) {
        Objects.requireNonNull(companionAds, "Parameter companionAds should not be null for VastCompanionPicker::pickCompanion");
        Objects.requireNonNull(vastConfigurationSettings, "Parameter vastConfigurationSettings should not be null for VastCompanionPicker::pickCompanion");
        ArrayList<Companion> arrayList = new ArrayList(companionAds.companions);
        Collections.sort(arrayList, new SizeComparator(vastConfigurationSettings));
        for (Companion companion : arrayList) {
            if (!companion.staticResources.isEmpty() || !companion.iFrameResources.isEmpty() || !companion.htmlResources.isEmpty()) {
                return companion;
            }
        }
        return null;
    }

    public Companion pickCompanion(List<Creative> list, VastConfigurationSettings vastConfigurationSettings) {
        Companion companionPickCompanion;
        Objects.requireNonNull(list, "Parameter creatives should not be null for VastCompanionPicker::pickCompanion");
        Objects.requireNonNull(vastConfigurationSettings, "Parameter vastConfigurationSettings should not be null for VastCompanionPicker::pickCompanion");
        ArrayList arrayList = new ArrayList();
        Iterator<Creative> it = list.iterator();
        while (it.hasNext()) {
            CompanionAds companionAds = it.next().companionAds;
            if (companionAds != null && (companionPickCompanion = pickCompanion(companionAds, vastConfigurationSettings)) != null) {
                arrayList.add(companionPickCompanion);
            }
        }
        if (arrayList.isEmpty()) {
            return null;
        }
        Collections.sort(arrayList, new SizeComparator(vastConfigurationSettings));
        return (Companion) arrayList.get(0);
    }
}
