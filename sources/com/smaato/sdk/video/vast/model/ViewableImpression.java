package com.smaato.sdk.video.vast.model;

import com.smaato.sdk.video.vast.utils.VastModels;
import java.util.List;

/* JADX INFO: loaded from: classes5.dex */
public class ViewableImpression {
    public static final String ID = "id";
    public static final String NAME = "ViewableImpression";
    public static final String NOT_VIEWABLE = "NotViewable";
    public static final String VIEWABLE = "Viewable";
    public static final String VIEW_UNDETERMINED = "ViewUndetermined";
    public final String id;
    public final List<String> notViewable;
    public final List<String> viewUndetermined;
    public final List<String> viewable;

    ViewableImpression(List<String> list, List<String> list2, List<String> list3, String str) {
        this.id = str;
        this.viewable = list;
        this.notViewable = list2;
        this.viewUndetermined = list3;
    }

    public static class Builder {
        private String id;
        private List notViewable;
        private List viewUndetermined;
        private List viewable;

        public Builder setId(String str) {
            this.id = str;
            return this;
        }

        public Builder setViewable(List<String> list) {
            this.viewable = list;
            return this;
        }

        public Builder setNotViewable(List<String> list) {
            this.notViewable = list;
            return this;
        }

        public Builder setViewUndetermined(List<String> list) {
            this.viewUndetermined = list;
            return this;
        }

        public ViewableImpression build() {
            this.viewable = VastModels.toImmutableList(this.viewable);
            this.notViewable = VastModels.toImmutableList(this.notViewable);
            List immutableList = VastModels.toImmutableList(this.viewUndetermined);
            this.viewUndetermined = immutableList;
            return new ViewableImpression(this.viewable, this.notViewable, immutableList, this.id);
        }
    }
}
