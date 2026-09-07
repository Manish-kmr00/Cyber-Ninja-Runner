package io.bidmachine.rendering.model;

import io.bidmachine.rendering.utils.KeyHolder;
import io.bidmachine.rendering.utils.Utils;

/* JADX INFO: loaded from: classes11.dex */
public enum Orientation implements KeyHolder {
    Portrait("portrait", 7),
    Landscape("landscape", 6);


    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f12419a;
    private final int b;

    Orientation(String key, int activityOrientation) {
        this.f12419a = key;
        this.b = activityOrientation;
    }

    public static Orientation fromKey(String key) {
        return (Orientation) Utils.fromKey(key, values());
    }

    public int getActivityOrientation() {
        return this.b;
    }

    @Override // io.bidmachine.rendering.utils.KeyHolder
    public String getKey() {
        return this.f12419a;
    }
}
