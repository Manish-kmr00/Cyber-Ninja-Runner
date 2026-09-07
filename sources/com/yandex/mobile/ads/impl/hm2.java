package com.yandex.mobile.ads.impl;

import com.yandex.mobile.ads.video.playback.model.MediaFile;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes12.dex */
public final class hm2 implements MediaFile {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final un0 f9115a;

    public hm2(un0 mediaFile) {
        Intrinsics.checkNotNullParameter(mediaFile, "mediaFile");
        this.f9115a = mediaFile;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof hm2) && Intrinsics.areEqual(this.f9115a, ((hm2) obj).f9115a);
    }

    public final int hashCode() {
        return this.f9115a.hashCode();
    }

    public final String toString() {
        return "YandexMediaFile(mediaFile=" + this.f9115a + ")";
    }

    @Override // com.yandex.mobile.ads.video.playback.model.MediaFile, com.yandex.mobile.ads.impl.jc2
    public final String getUrl() {
        return this.f9115a.getUrl();
    }

    @Override // com.yandex.mobile.ads.video.playback.model.MediaFile
    public final int getAdWidth() {
        return this.f9115a.getAdWidth();
    }

    @Override // com.yandex.mobile.ads.video.playback.model.MediaFile
    public final int getAdHeight() {
        return this.f9115a.getAdHeight();
    }

    @Override // com.yandex.mobile.ads.video.playback.model.MediaFile
    public final String getMediaType() {
        return this.f9115a.getMediaType();
    }

    @Override // com.yandex.mobile.ads.video.playback.model.MediaFile
    public final Integer getBitrate() {
        return this.f9115a.getBitrate();
    }

    @Override // com.yandex.mobile.ads.video.playback.model.MediaFile
    public final String getApiFramework() {
        return this.f9115a.getApiFramework();
    }
}
