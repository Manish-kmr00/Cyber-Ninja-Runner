package com.yandex.mobile.ads.common;

import com.yandex.mobile.ads.impl.ie2;
import com.yandex.mobile.ads.impl.jn2;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0007\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\b\u001a\u00020\u0007¢\u0006\u0004\b\t\u0010\nJ\u0017\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\u000b"}, d2 = {"Lcom/yandex/mobile/ads/common/VideoController;", "", "Lcom/yandex/mobile/ads/common/VideoEventListener;", "videoEventListener", "", "setVideoEventListener", "(Lcom/yandex/mobile/ads/common/VideoEventListener;)V", "Lcom/yandex/mobile/ads/impl/ie2;", "videoEventController", "<init>", "(Lcom/yandex/mobile/ads/impl/ie2;)V", "mobileads_externalRelease"}, k = 1, mv = {1, 9, 0})
public final class VideoController {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final ie2 f8333a;

    public VideoController(ie2 videoEventController) {
        Intrinsics.checkNotNullParameter(videoEventController, "videoEventController");
        this.f8333a = videoEventController;
    }

    public final void setVideoEventListener(VideoEventListener videoEventListener) {
        if (videoEventListener == null) {
            this.f8333a.a((jn2) null);
        } else {
            this.f8333a.a(new jn2(videoEventListener));
        }
    }
}
