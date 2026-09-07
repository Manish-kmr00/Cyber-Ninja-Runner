package com.smaato.sdk.video.vast.model;

import com.smaato.sdk.core.util.Objects;
import com.smaato.sdk.video.vast.utils.VastModels;
import java.util.List;

/* JADX INFO: loaded from: classes5.dex */
public final class VastScenario {
    public final String adServingId;
    public final AdSystem adSystem;
    public final String adTitle;
    public final List<Verification> adVerifications;
    public final Advertiser advertiser;
    public final List<String> blockedAdCategories;
    public final List<Category> categories;
    public final String description;
    public final List<String> errors;
    public final List<VastBeacon> impressions;
    public final VastCompanionScenario vastCompanionScenario;
    public final List<VastCompanionScenario> vastCompanionScenarioList;
    public final VastMediaFileScenario vastMediaFileScenario;
    public final ViewableImpression viewableImpression;

    private VastScenario(List list, List list2, List list3, List list4, List list5, List list6, VastMediaFileScenario vastMediaFileScenario, VastCompanionScenario vastCompanionScenario, AdSystem adSystem, String str, String str2, Advertiser advertiser, ViewableImpression viewableImpression, String str3) {
        this.impressions = (List) Objects.requireNonNull(list);
        this.adVerifications = (List) Objects.requireNonNull(list2);
        this.categories = (List) Objects.requireNonNull(list3);
        this.errors = (List) Objects.requireNonNull(list4);
        this.vastMediaFileScenario = (VastMediaFileScenario) Objects.requireNonNull(vastMediaFileScenario);
        this.blockedAdCategories = (List) Objects.requireNonNull(list5);
        this.vastCompanionScenario = vastCompanionScenario;
        this.adSystem = adSystem;
        this.adTitle = str;
        this.description = str2;
        this.advertiser = advertiser;
        this.viewableImpression = viewableImpression;
        this.adServingId = str3;
        this.vastCompanionScenarioList = (List) Objects.requireNonNull(list6);
    }

    public Builder newBuilder() {
        return new Builder(this);
    }

    public static class Builder {
        private String adServingId;
        private AdSystem adSystem;
        private String adTitle;
        private List adVerifications;
        private Advertiser advertiser;
        private List blockedAdCategories;
        private List categories;
        private String description;
        private List errors;
        private List impressions;
        private VastCompanionScenario vastCompanionScenario;
        public List<VastCompanionScenario> vastCompanionScenarioList;
        private VastMediaFileScenario vastMediaFileScenario;
        private ViewableImpression viewableImpression;

        public Builder() {
        }

        public Builder(VastScenario vastScenario) {
            this.impressions = vastScenario.impressions;
            this.adVerifications = vastScenario.adVerifications;
            this.categories = vastScenario.categories;
            this.errors = vastScenario.errors;
            this.adSystem = vastScenario.adSystem;
            this.adTitle = vastScenario.adTitle;
            this.description = vastScenario.description;
            this.advertiser = vastScenario.advertiser;
            this.viewableImpression = vastScenario.viewableImpression;
            this.vastMediaFileScenario = vastScenario.vastMediaFileScenario;
            this.vastCompanionScenario = vastScenario.vastCompanionScenario;
            this.blockedAdCategories = vastScenario.blockedAdCategories;
            this.adServingId = vastScenario.adServingId;
            this.vastCompanionScenarioList = vastScenario.vastCompanionScenarioList;
        }

        public Builder setAdSystem(AdSystem adSystem) {
            this.adSystem = adSystem;
            return this;
        }

        public Builder setAdTitle(String str) {
            this.adTitle = str;
            return this;
        }

        public Builder setDescription(String str) {
            this.description = str;
            return this;
        }

        public Builder setAdvertiser(Advertiser advertiser) {
            this.advertiser = advertiser;
            return this;
        }

        public Builder setViewableImpression(ViewableImpression viewableImpression) {
            this.viewableImpression = viewableImpression;
            return this;
        }

        public Builder setAdVerifications(List<Verification> list) {
            this.adVerifications = list;
            return this;
        }

        public Builder setVastMediaFileScenario(VastMediaFileScenario vastMediaFileScenario) {
            this.vastMediaFileScenario = vastMediaFileScenario;
            return this;
        }

        public Builder setVastCompanionScenario(VastCompanionScenario vastCompanionScenario) {
            this.vastCompanionScenario = vastCompanionScenario;
            return this;
        }

        public Builder setImpressions(List<VastBeacon> list) {
            this.impressions = list;
            return this;
        }

        public Builder setCategories(List<Category> list) {
            this.categories = list;
            return this;
        }

        public Builder setErrors(List<String> list) {
            this.errors = list;
            return this;
        }

        public Builder setBlockedAdCategories(List<String> list) {
            this.blockedAdCategories = list;
            return this;
        }

        public Builder setVastCompanionScenarioList(List<VastCompanionScenario> list) {
            this.vastCompanionScenarioList = list;
            return this;
        }

        public Builder setAdServingId(String str) {
            this.adServingId = str;
            return this;
        }

        public VastScenario build() {
            return new VastScenario(VastModels.toImmutableList(this.impressions), VastModels.toImmutableList(this.adVerifications), VastModels.toImmutableList(this.categories), VastModels.toImmutableList(this.errors), VastModels.toImmutableList(this.blockedAdCategories), VastModels.toImmutableList(this.vastCompanionScenarioList), (VastMediaFileScenario) Objects.requireNonNull(this.vastMediaFileScenario), this.vastCompanionScenario, this.adSystem, this.adTitle, this.description, this.advertiser, this.viewableImpression, this.adServingId);
        }
    }
}
