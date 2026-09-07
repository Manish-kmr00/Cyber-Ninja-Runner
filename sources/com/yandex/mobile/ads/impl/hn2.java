package com.yandex.mobile.ads.impl;

import com.yandex.mobile.ads.video.playback.model.AdPodInfo;
import com.yandex.mobile.ads.video.playback.model.MediaFile;
import com.yandex.mobile.ads.video.playback.model.SkipInfo;
import com.yandex.mobile.ads.video.playback.model.VideoAd;
import com.yandex.mobile.ads.video.playback.model.VideoAdInfo;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes12.dex */
public final class hn2 implements VideoAd {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final do0 f9121a;
    private final sb2 b;

    public hn2(do0 videoAd, sb2 videoAdInfoConverter) {
        Intrinsics.checkNotNullParameter(videoAd, "videoAd");
        Intrinsics.checkNotNullParameter(videoAdInfoConverter, "videoAdInfoConverter");
        this.f9121a = videoAd;
        this.b = videoAdInfoConverter;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof hn2)) {
            return false;
        }
        hn2 hn2Var = (hn2) obj;
        return Intrinsics.areEqual(this.f9121a, hn2Var.f9121a) && Intrinsics.areEqual(this.b, hn2Var.b);
    }

    @Override // com.yandex.mobile.ads.video.playback.model.VideoAd
    public final AdPodInfo getAdPodInfo() {
        return new cl2(this.f9121a.b());
    }

    @Override // com.yandex.mobile.ads.video.playback.model.VideoAd
    public final MediaFile getMediaFile() {
        return new hm2(this.f9121a.f());
    }

    public final int hashCode() {
        return this.b.hashCode() + (this.f9121a.hashCode() * 31);
    }

    public final String toString() {
        return "YandexVideoAd(videoAd=" + this.f9121a + ", videoAdInfoConverter=" + this.b + ")";
    }

    @Override // com.yandex.mobile.ads.video.playback.model.VideoAd
    public final SkipInfo getSkipInfo() {
        gd2 gd2VarG = this.f9121a.g();
        if (gd2VarG != null) {
            return new ym2(gd2VarG);
        }
        return null;
    }

    @Override // com.yandex.mobile.ads.video.playback.model.VideoAd
    public final List<MediaFile> getMediaFiles() {
        List<un0> listE = this.f9121a.e();
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(listE, 10));
        Iterator<T> it = listE.iterator();
        while (it.hasNext()) {
            arrayList.add(new hm2((un0) it.next()));
        }
        return arrayList;
    }

    @Override // com.yandex.mobile.ads.video.playback.model.VideoAd
    public final String getInfo() {
        return this.f9121a.a().e();
    }

    @Override // com.yandex.mobile.ads.video.playback.model.VideoAd
    public final VideoAdInfo getAdInfo() {
        sb2 sb2Var = this.b;
        zl0 instreamAdInfo = this.f9121a.a();
        sb2Var.getClass();
        Intrinsics.checkNotNullParameter(instreamAdInfo, "instreamAdInfo");
        return new VideoAdInfo(instreamAdInfo.a(), instreamAdInfo.d(), instreamAdInfo.c(), instreamAdInfo.e(), instreamAdInfo.b());
    }

    @Override // com.yandex.mobile.ads.video.playback.model.VideoAd
    public final long getDuration() {
        return this.f9121a.c();
    }
}
