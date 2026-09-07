package io.bidmachine.rendering.model;

import io.bidmachine.rendering.utils.KeyHolder;
import io.bidmachine.rendering.utils.Utils;

/* JADX INFO: loaded from: classes11.dex */
public enum AdElementType implements KeyHolder {
    Mraid("mraid"),
    Video("video"),
    Image("image"),
    Countdown("countdown"),
    Progress("progress");


    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f12399a;

    AdElementType(String key) {
        this.f12399a = key;
    }

    public static AdElementType fromKey(String key) {
        return (AdElementType) Utils.fromKey(key, values());
    }

    @Override // io.bidmachine.rendering.utils.KeyHolder
    public String getKey() {
        return this.f12399a;
    }
}
