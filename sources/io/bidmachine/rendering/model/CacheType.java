package io.bidmachine.rendering.model;

import io.bidmachine.rendering.utils.KeyHolder;
import io.bidmachine.rendering.utils.Utils;

/* JADX INFO: loaded from: classes12.dex */
public enum CacheType implements KeyHolder {
    FullLoad("full_load"),
    PartialLoad("partial_load"),
    StreamLoad("stream_load");


    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f12406a;

    CacheType(String key) {
        this.f12406a = key;
    }

    public static CacheType fromKey(String key) {
        return (CacheType) Utils.fromKey(key, values());
    }

    @Override // io.bidmachine.rendering.utils.KeyHolder
    public String getKey() {
        return this.f12406a;
    }
}
