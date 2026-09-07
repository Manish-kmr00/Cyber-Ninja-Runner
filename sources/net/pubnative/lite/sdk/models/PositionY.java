package net.pubnative.lite.sdk.models;

import com.facebook.appevents.internal.ViewHierarchyConstants;

/* JADX INFO: loaded from: classes11.dex */
public enum PositionY {
    TOP(ViewHierarchyConstants.DIMENSION_TOP_KEY),
    BOTTOM("bottom");

    private String value;

    PositionY(String str) {
        this.value = str;
    }

    public String getValue() {
        return this.value;
    }
}
