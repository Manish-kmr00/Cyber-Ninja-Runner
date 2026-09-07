package com.smaato.sdk.nativead;

import java.util.List;

/* JADX INFO: loaded from: classes7.dex */
public abstract class NativeAdLink {
    public abstract List<String> trackers();

    public abstract String url();

    public static NativeAdLink create(String str, List<String> list) {
        return new AutoValue_NativeAdLink(str, list);
    }
}
