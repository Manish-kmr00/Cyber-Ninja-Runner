package com.smaato.sdk.video.vast.buildlight;

import com.json.x8;
import com.smaato.sdk.core.log.Logger;
import com.smaato.sdk.core.util.Objects;
import com.smaato.sdk.video.vast.buildlight.compare.AverageBitratePicker;
import com.smaato.sdk.video.vast.buildlight.compare.BitrateComparator;
import com.smaato.sdk.video.vast.buildlight.compare.MediaFileComparator;
import com.smaato.sdk.video.vast.buildlight.compare.SizeComparator;
import com.smaato.sdk.video.vast.model.Companion;
import com.smaato.sdk.video.vast.model.CompanionAds;
import com.smaato.sdk.video.vast.model.Creative;
import com.smaato.sdk.video.vast.model.InLine;
import com.smaato.sdk.video.vast.model.Linear;
import com.smaato.sdk.video.vast.model.MediaFile;
import com.smaato.sdk.video.vast.model.VastCompanionScenario;
import com.smaato.sdk.video.vast.model.VastMediaFileScenario;
import com.smaato.sdk.video.vast.model.VastScenario;
import com.smaato.sdk.video.vast.model.VastScenarioCreativeData;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

/* JADX INFO: loaded from: classes7.dex */
public class VastScenarioMapper {
    private final VastCompanionPicker vastCompanionPicker;
    private final VastCompanionScenarioMapper vastCompanionScenarioMapper;
    private final VastMediaFileScenarioMapper vastMediaFileScenarioMapper;
    private final VastLinearMediaFilePicker vastMediaFileScenarioPicker;
    private final VastScenarioCreativeDataMapper vastScenarioCreativeDataMapper;

    public VastScenarioMapper(VastLinearMediaFilePicker vastLinearMediaFilePicker, VastCompanionPicker vastCompanionPicker, VastCompanionScenarioMapper vastCompanionScenarioMapper, VastMediaFileScenarioMapper vastMediaFileScenarioMapper, VastScenarioCreativeDataMapper vastScenarioCreativeDataMapper) {
        this.vastMediaFileScenarioPicker = (VastLinearMediaFilePicker) Objects.requireNonNull(vastLinearMediaFilePicker, "Parameter vastLinearMediaFilePicker should be null for VastScenarioPicker::new");
        this.vastCompanionPicker = (VastCompanionPicker) Objects.requireNonNull(vastCompanionPicker, "Parameter vastCompanionPicker should be null for VastScenarioPicker::new");
        this.vastCompanionScenarioMapper = (VastCompanionScenarioMapper) Objects.requireNonNull(vastCompanionScenarioMapper, "Parameter vastCompanionScenarioMapper should be null for VastScenarioPicker::new");
        this.vastMediaFileScenarioMapper = (VastMediaFileScenarioMapper) Objects.requireNonNull(vastMediaFileScenarioMapper, "Parameter vastMediaFileScenarioMapper should be null for VastScenarioPicker::new");
        this.vastScenarioCreativeDataMapper = (VastScenarioCreativeDataMapper) Objects.requireNonNull(vastScenarioCreativeDataMapper, "Parameter vastScenarioCreativeDataMapper should be null for VastScenarioPicker::new");
    }

    VastScenarioResult mapVastScenario(Logger logger, InLine inLine, VastConfigurationSettings vastConfigurationSettings) {
        Companion companionPickCompanion;
        Objects.requireNonNull(logger);
        Objects.requireNonNull(vastConfigurationSettings);
        HashSet hashSet = new HashSet();
        VastScenarioResult.Builder errorUrls = new VastScenarioResult.Builder().setErrors(hashSet).setErrorUrls(new HashSet(inLine.errors));
        TreeMap treeMap = new TreeMap(new MediaFileComparator(new SizeComparator(vastConfigurationSettings), new BitrateComparator(new AverageBitratePicker(vastConfigurationSettings).getAverageBitrate(), x8.b.equalsIgnoreCase(vastConfigurationSettings.connectionType))));
        Set setPickMediaFile = pickMediaFile(inLine, vastConfigurationSettings, treeMap);
        Map.Entry entryFirstEntry = treeMap.firstEntry();
        if (treeMap.isEmpty() || entryFirstEntry == null) {
            if (setPickMediaFile.isEmpty()) {
                hashSet.add(400);
            } else {
                hashSet.addAll(setPickMediaFile);
            }
            return errorUrls.build();
        }
        Creative creative = ((CreativeLinearContainer) entryFirstEntry.getValue()).creative;
        Linear linear = ((CreativeLinearContainer) entryFirstEntry.getValue()).linear;
        MediaFile mediaFile = (MediaFile) entryFirstEntry.getKey();
        VastScenarioCreativeData vastScenarioCreativeDataMapVastScenarioCreativeData = this.vastScenarioCreativeDataMapper.mapVastScenarioCreativeData(creative);
        VastMediaFileScenario vastMediaFileScenarioMapMediaFileScenario = this.vastMediaFileScenarioMapper.mapMediaFileScenario(logger, mediaFile, linear, vastScenarioCreativeDataMapVastScenarioCreativeData);
        ArrayList arrayList = new ArrayList();
        CompanionAds companionAds = creative.companionAds;
        VastCompanionScenario vastCompanionScenarioMapVastCompanionScenario = null;
        if (companionAds != null) {
            companionPickCompanion = this.vastCompanionPicker.pickCompanion(companionAds, vastConfigurationSettings);
            for (Companion companion : creative.companionAds.companions) {
                if (companion != companionPickCompanion && companion.isResourcesEmpty()) {
                    arrayList.add(this.vastCompanionScenarioMapper.mapVastCompanionScenario(logger, companion, vastScenarioCreativeDataMapVastScenarioCreativeData, true));
                }
            }
        } else {
            companionPickCompanion = null;
        }
        if (companionPickCompanion == null) {
            companionPickCompanion = this.vastCompanionPicker.pickCompanion(inLine.creatives, vastConfigurationSettings);
            Iterator<Creative> it = inLine.creatives.iterator();
            while (it.hasNext()) {
                CompanionAds companionAds2 = it.next().companionAds;
                if (companionAds2 != null) {
                    for (Companion companion2 : companionAds2.companions) {
                        if (companion2 != companionPickCompanion && companion2.isResourcesEmpty()) {
                            arrayList.add(this.vastCompanionScenarioMapper.mapVastCompanionScenario(logger, companion2, vastScenarioCreativeDataMapVastScenarioCreativeData, true));
                        }
                    }
                }
            }
        }
        if (companionPickCompanion == null) {
            if (creative.hasCompanions()) {
                hashSet.add(600);
            }
        } else {
            vastCompanionScenarioMapVastCompanionScenario = this.vastCompanionScenarioMapper.mapVastCompanionScenario(logger, companionPickCompanion, vastScenarioCreativeDataMapVastScenarioCreativeData, false);
        }
        return errorUrls.setVastScenario(mapVastScenario(inLine, vastMediaFileScenarioMapMediaFileScenario, vastCompanionScenarioMapVastCompanionScenario, arrayList)).build();
    }

    private Set pickMediaFile(InLine inLine, VastConfigurationSettings vastConfigurationSettings, TreeMap treeMap) {
        HashSet hashSet = new HashSet();
        for (Creative creative : inLine.creatives) {
            Linear linear = creative.linear;
            if (linear != null && !linear.mediaFiles.isEmpty()) {
                MediaFileResult mediaFileResultPickMediaFile = this.vastMediaFileScenarioPicker.pickMediaFile(linear.mediaFiles, vastConfigurationSettings);
                MediaFile mediaFile = mediaFileResultPickMediaFile.mediaFile;
                if (mediaFile != null) {
                    treeMap.put(mediaFile, new CreativeLinearContainer(creative, linear));
                    break;
                }
                hashSet.addAll(mediaFileResultPickMediaFile.errors);
            }
        }
        return hashSet;
    }

    private VastScenario mapVastScenario(InLine inLine, VastMediaFileScenario vastMediaFileScenario, VastCompanionScenario vastCompanionScenario, List list) {
        return new VastScenario.Builder().setAdSystem(inLine.adSystem).setAdTitle(inLine.adTitle).setAdVerifications(inLine.adVerifications).setAdvertiser(inLine.advertiser).setCategories(inLine.categories).setDescription(inLine.description).setVastCompanionScenarioList(list).setErrors(inLine.errors).setImpressions(inLine.impressions).setViewableImpression(inLine.viewableImpression).setVastMediaFileScenario(vastMediaFileScenario).setVastCompanionScenario(vastCompanionScenario).setAdServingId(inLine.adServingId).build();
    }

    private static final class CreativeLinearContainer {
        public final Creative creative;
        public final Linear linear;

        private CreativeLinearContainer(Creative creative, Linear linear) {
            this.creative = (Creative) Objects.requireNonNull(creative);
            this.linear = (Linear) Objects.requireNonNull(linear);
        }
    }
}
