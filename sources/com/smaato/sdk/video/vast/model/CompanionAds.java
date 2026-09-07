package com.smaato.sdk.video.vast.model;

import com.smaato.sdk.video.vast.exceptions.VastElementMissingException;
import com.smaato.sdk.video.vast.utils.VastModels;
import java.util.List;

/* JADX INFO: loaded from: classes6.dex */
public class CompanionAds {
    public static final String COMPANION = "Companion";
    public static final String NAME = "CompanionAds";
    public static final String REQUIRED = "required";
    public final List<Companion> companions;
    public final Required required;

    CompanionAds(List<Companion> list, Required required) {
        this.companions = list;
        this.required = required;
    }

    public enum Required {
        ALL,
        ANY,
        NONE;

        public static Required parse(String str) {
            for (Required required : values()) {
                if (required.name().equalsIgnoreCase(str)) {
                    return required;
                }
            }
            return null;
        }
    }

    public static class Builder {
        private List companions;
        private Required required;

        public Builder setCompanions(List<Companion> list) {
            this.companions = list;
            return this;
        }

        public Builder setRequired(Required required) {
            this.required = required;
            return this;
        }

        public CompanionAds build() throws VastElementMissingException {
            VastModels.requireNonEmpty(this.companions, "Cannot build CompanionAds: companions are missing");
            return new CompanionAds(VastModels.toImmutableList(this.companions), this.required);
        }
    }
}
