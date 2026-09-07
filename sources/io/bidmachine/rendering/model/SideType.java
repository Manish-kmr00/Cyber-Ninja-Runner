package io.bidmachine.rendering.model;

import com.facebook.appevents.internal.ViewHierarchyConstants;
import io.bidmachine.rendering.utils.KeyHolder;
import io.bidmachine.rendering.utils.Utils;

/* JADX INFO: loaded from: classes10.dex */
public enum SideType implements KeyHolder {
    Left("left"),
    Top(ViewHierarchyConstants.DIMENSION_TOP_KEY),
    Right("right"),
    Bottom("bottom");


    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f12424a;

    SideType(String key) {
        this.f12424a = key;
    }

    public static SideType fromKey(String key) {
        return (SideType) Utils.fromKey(key, values());
    }

    @Override // io.bidmachine.rendering.utils.KeyHolder
    public String getKey() {
        return this.f12424a;
    }
}
