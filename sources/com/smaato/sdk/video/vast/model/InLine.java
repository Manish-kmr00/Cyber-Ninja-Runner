package com.smaato.sdk.video.vast.model;

import com.smaato.sdk.core.util.Objects;
import com.smaato.sdk.video.vast.utils.VastModels;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes6.dex */
public class InLine {
    public static final String ADVERTISER = "Advertiser";
    public static final String AD_SERVING_ID = "AdServingId";
    public static final String AD_SYSTEM = "AdSystem";
    public static final String AD_TITLE = "AdTitle";
    public static final String AD_VERIFICATIONS = "AdVerifications";
    public static final String CATEGORY = "Category";
    public static final String CREATIVES = "Creatives";
    public static final String DESCRIPTION = "Description";
    public static final String ERROR = "Error";
    public static final String EXTENSIONS = "Extensions";
    public static final String IMPRESSION = "Impression";
    public static final String NAME = "InLine";
    public static final String VIEWABLE_IMPRESSION = "ViewableImpression";
    public final String adServingId;
    public final AdSystem adSystem;
    public final String adTitle;
    public final List<Verification> adVerifications;
    public final Advertiser advertiser;
    public final List<Category> categories;
    public final List<Creative> creatives;
    public final String description;
    public final List<String> errors;
    public final List<Extension> extensions;
    public final List<VastBeacon> impressions;
    public final ViewableImpression viewableImpression;

    public InLine(List<VastBeacon> list, List<Creative> list2, List<Verification> list3, List<Category> list4, List<String> list5, AdSystem adSystem, String str, String str2, String str3, Advertiser advertiser, ViewableImpression viewableImpression, List<Extension> list6) {
        this.adSystem = adSystem;
        this.adTitle = str;
        this.adServingId = str2;
        this.impressions = list;
        this.categories = list4;
        this.description = str3;
        this.advertiser = advertiser;
        this.errors = list5;
        this.viewableImpression = viewableImpression;
        this.creatives = list2;
        this.adVerifications = list3;
        this.extensions = list6;
    }

    public static class Builder {
        private String adServingId;
        private AdSystem adSystem;
        private String adTitle;
        private List adVerifications;
        private Advertiser advertiser;
        private List categories;
        private List creatives;
        private String description;
        private List errors;
        private List extensions;
        private List impressions;
        private ViewableImpression viewableImpression;

        public Builder setAdSystem(AdSystem adSystem) {
            this.adSystem = adSystem;
            return this;
        }

        public Builder setAdTitle(String str) {
            this.adTitle = str;
            return this;
        }

        public Builder setAdServingId(String str) {
            this.adServingId = str;
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

        public Builder setDescription(String str) {
            this.description = str;
            return this;
        }

        public Builder setAdvertiser(Advertiser advertiser) {
            this.advertiser = advertiser;
            return this;
        }

        public Builder setErrors(List<String> list) {
            this.errors = list;
            return this;
        }

        public Builder setViewableImpression(ViewableImpression viewableImpression) {
            this.viewableImpression = viewableImpression;
            return this;
        }

        public Builder setCreatives(List<Creative> list) {
            this.creatives = list;
            return this;
        }

        public Builder setAdVerifications(List<Verification> list) {
            this.adVerifications = list;
            return this;
        }

        public Builder setExtensions(List<Extension> list) {
            this.extensions = list;
            return this;
        }

        public InLine build() {
            ArrayList arrayList = new ArrayList();
            List list = this.adVerifications;
            if (list != null && !list.isEmpty()) {
                arrayList.addAll(this.adVerifications);
            }
            List list2 = this.extensions;
            if (list2 != null && !list2.isEmpty()) {
                Iterator it = this.extensions.iterator();
                while (it.hasNext()) {
                    Objects.onNotNull(((Extension) it.next()).adVerifications, new InLine$Builder$$ExternalSyntheticLambda0(arrayList));
                }
            }
            this.impressions = VastModels.toImmutableList(this.impressions);
            this.creatives = VastModels.toImmutableList(this.creatives);
            this.adVerifications = VastModels.toImmutableList(arrayList);
            this.categories = VastModels.toImmutableList(this.categories);
            this.errors = VastModels.toImmutableList(this.errors);
            List immutableList = VastModels.toImmutableList(this.extensions);
            this.extensions = immutableList;
            return new InLine(this.impressions, this.creatives, this.adVerifications, this.categories, this.errors, this.adSystem, this.adTitle, this.adServingId, this.description, this.advertiser, this.viewableImpression, immutableList);
        }
    }
}
