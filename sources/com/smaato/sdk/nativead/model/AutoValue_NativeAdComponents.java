package com.smaato.sdk.nativead.model;

import com.smaato.sdk.nativead.NativeAdAssets;
import com.smaato.sdk.nativead.NativeAdLink;
import java.util.List;

/* JADX INFO: loaded from: classes10.dex */
final class AutoValue_NativeAdComponents extends NativeAdComponents {
    private final NativeAdAssets assets;
    private final NativeAdLink link;
    private final String mraidWrappedVast;
    private final String privacyUrl;
    private final List trackers;

    private AutoValue_NativeAdComponents(NativeAdAssets nativeAdAssets, NativeAdLink nativeAdLink, List list, String str, String str2) {
        this.assets = nativeAdAssets;
        this.link = nativeAdLink;
        this.trackers = list;
        this.privacyUrl = str;
        this.mraidWrappedVast = str2;
    }

    @Override // com.smaato.sdk.nativead.model.NativeAdComponents
    public NativeAdAssets assets() {
        return this.assets;
    }

    @Override // com.smaato.sdk.nativead.model.NativeAdComponents
    public NativeAdLink link() {
        return this.link;
    }

    @Override // com.smaato.sdk.nativead.model.NativeAdComponents
    public List trackers() {
        return this.trackers;
    }

    @Override // com.smaato.sdk.nativead.model.NativeAdComponents
    public String privacyUrl() {
        return this.privacyUrl;
    }

    @Override // com.smaato.sdk.nativead.model.NativeAdComponents
    public String mraidWrappedVast() {
        return this.mraidWrappedVast;
    }

    public String toString() {
        return "NativeAdComponents{assets=" + this.assets + ", link=" + this.link + ", trackers=" + this.trackers + ", privacyUrl=" + this.privacyUrl + ", mraidWrappedVast=" + this.mraidWrappedVast + "}";
    }

    public boolean equals(Object obj) {
        String str;
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof NativeAdComponents)) {
            return false;
        }
        NativeAdComponents nativeAdComponents = (NativeAdComponents) obj;
        if (this.assets.equals(nativeAdComponents.assets()) && this.link.equals(nativeAdComponents.link()) && this.trackers.equals(nativeAdComponents.trackers()) && ((str = this.privacyUrl) != null ? str.equals(nativeAdComponents.privacyUrl()) : nativeAdComponents.privacyUrl() == null)) {
            String str2 = this.mraidWrappedVast;
            if (str2 == null) {
                if (nativeAdComponents.mraidWrappedVast() == null) {
                    return true;
                }
            } else if (str2.equals(nativeAdComponents.mraidWrappedVast())) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        int iHashCode = (((((this.assets.hashCode() ^ 1000003) * 1000003) ^ this.link.hashCode()) * 1000003) ^ this.trackers.hashCode()) * 1000003;
        String str = this.privacyUrl;
        int iHashCode2 = (iHashCode ^ (str == null ? 0 : str.hashCode())) * 1000003;
        String str2 = this.mraidWrappedVast;
        return iHashCode2 ^ (str2 != null ? str2.hashCode() : 0);
    }

    static final class Builder extends NativeAdComponents.Builder {
        private NativeAdAssets assets;
        private NativeAdLink link;
        private String mraidWrappedVast;
        private String privacyUrl;
        private List trackers;

        Builder() {
        }

        @Override // com.smaato.sdk.nativead.model.NativeAdComponents.Builder
        public NativeAdComponents.Builder assets(NativeAdAssets nativeAdAssets) {
            if (nativeAdAssets == null) {
                throw new NullPointerException("Null assets");
            }
            this.assets = nativeAdAssets;
            return this;
        }

        @Override // com.smaato.sdk.nativead.model.NativeAdComponents.Builder
        public NativeAdComponents.Builder link(NativeAdLink nativeAdLink) {
            if (nativeAdLink == null) {
                throw new NullPointerException("Null link");
            }
            this.link = nativeAdLink;
            return this;
        }

        @Override // com.smaato.sdk.nativead.model.NativeAdComponents.Builder
        public NativeAdComponents.Builder trackers(List list) {
            if (list == null) {
                throw new NullPointerException("Null trackers");
            }
            this.trackers = list;
            return this;
        }

        @Override // com.smaato.sdk.nativead.model.NativeAdComponents.Builder
        public NativeAdComponents.Builder privacyUrl(String str) {
            this.privacyUrl = str;
            return this;
        }

        @Override // com.smaato.sdk.nativead.model.NativeAdComponents.Builder
        public NativeAdComponents.Builder mraidWrappedVast(String str) {
            this.mraidWrappedVast = str;
            return this;
        }

        @Override // com.smaato.sdk.nativead.model.NativeAdComponents.Builder
        public NativeAdComponents build() {
            String str;
            if (this.assets != null) {
                str = "";
            } else {
                str = " assets";
            }
            if (this.link == null) {
                str = str + " link";
            }
            if (this.trackers == null) {
                str = str + " trackers";
            }
            if (!str.isEmpty()) {
                throw new IllegalStateException("Missing required properties:" + str);
            }
            return new AutoValue_NativeAdComponents(this.assets, this.link, this.trackers, this.privacyUrl, this.mraidWrappedVast);
        }
    }
}
