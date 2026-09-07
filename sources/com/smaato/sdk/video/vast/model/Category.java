package com.smaato.sdk.video.vast.model;

import com.smaato.sdk.video.vast.exceptions.VastElementMissingException;
import com.smaato.sdk.video.vast.utils.VastModels;

/* JADX INFO: loaded from: classes8.dex */
public class Category {
    public static final String AUTHORITY = "authority";
    public static final String NAME = "Category";
    public final String authority;
    public final String categoryCode;

    Category(String str, String str2) {
        this.categoryCode = str;
        this.authority = str2;
    }

    public static class Builder {
        private String authority;
        private String categoryCode;

        public Builder setAuthority(String str) {
            this.authority = str;
            return this;
        }

        public Builder setCategoryCode(String str) {
            this.categoryCode = str;
            return this;
        }

        public Category build() throws VastElementMissingException {
            VastModels.requireNonNull(this.categoryCode, "Cannot build Category: categoryCode is missing");
            return new Category(this.categoryCode, this.authority);
        }
    }
}
