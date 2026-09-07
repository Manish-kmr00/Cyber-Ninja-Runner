package com.smaato.sdk.nativead.model;

import com.smaato.sdk.nativead.NativeAdAssets;
import com.smaato.sdk.nativead.NativeAdLink;
import com.smaato.sdk.nativead.NativeAdTracker;
import java.util.List;

/* JADX INFO: loaded from: classes7.dex */
public abstract class NativeAdComponents {

    public static abstract class Builder {
        public abstract Builder assets(NativeAdAssets nativeAdAssets);

        public abstract NativeAdComponents build();

        public abstract Builder link(NativeAdLink nativeAdLink);

        public abstract Builder mraidWrappedVast(String str);

        public abstract Builder privacyUrl(String str);

        public abstract Builder trackers(List<NativeAdTracker> list);
    }

    public abstract NativeAdAssets assets();

    public abstract NativeAdLink link();

    public abstract String mraidWrappedVast();

    public abstract String privacyUrl();

    public abstract List<NativeAdTracker> trackers();

    public static Builder builder() {
        return new AutoValue_NativeAdComponents.Builder();
    }

    public Builder buildUpon() {
        return builder().link(link()).assets(assets()).trackers(trackers()).privacyUrl(privacyUrl()).mraidWrappedVast(mraidWrappedVast());
    }
}
