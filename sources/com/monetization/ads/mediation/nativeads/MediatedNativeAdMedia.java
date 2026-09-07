package com.monetization.ads.mediation.nativeads;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: classes13.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0007\n\u0002\b\t\u0018\u00002\u00020\u0001:\u0001\nB\u0011\b\u0002\u0012\u0006\u0010\u0007\u001a\u00020\u0002¢\u0006\u0004\b\b\u0010\tR\u0017\u0010\u0007\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u000b"}, d2 = {"Lcom/monetization/ads/mediation/nativeads/MediatedNativeAdMedia;", "", "", "a", "F", "getAspectRatio", "()F", "aspectRatio", "<init>", "(F)V", "Builder", "mobileads_externalRelease"}, k = 1, mv = {1, 9, 0})
public final class MediatedNativeAdMedia {

    /* JADX INFO: renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final float aspectRatio;

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\n\u001a\u00020\u0005¢\u0006\u0004\b\u000b\u0010\fJ\r\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0003\u0010\u0004R\u0017\u0010\n\u001a\u00020\u00058\u0006¢\u0006\f\n\u0004\b\u0006\u0010\u0007\u001a\u0004\b\b\u0010\t¨\u0006\r"}, d2 = {"Lcom/monetization/ads/mediation/nativeads/MediatedNativeAdMedia$Builder;", "", "Lcom/monetization/ads/mediation/nativeads/MediatedNativeAdMedia;", "build", "()Lcom/monetization/ads/mediation/nativeads/MediatedNativeAdMedia;", "", "a", "F", "getAspectRatio", "()F", "aspectRatio", "<init>", "(F)V", "mobileads_externalRelease"}, k = 1, mv = {1, 9, 0})
    public static final class Builder {

        /* JADX INFO: renamed from: a, reason: collision with root package name and from kotlin metadata */
        private final float aspectRatio;

        public Builder(float f) {
            this.aspectRatio = f;
        }

        public final MediatedNativeAdMedia build() {
            return new MediatedNativeAdMedia(this.aspectRatio, null);
        }

        public final float getAspectRatio() {
            return this.aspectRatio;
        }
    }

    public /* synthetic */ MediatedNativeAdMedia(float f, DefaultConstructorMarker defaultConstructorMarker) {
        this(f);
    }

    public final float getAspectRatio() {
        return this.aspectRatio;
    }

    private MediatedNativeAdMedia(float f) {
        this.aspectRatio = f;
    }
}
