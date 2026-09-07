package com.yandex.mobile.ads.impl;

import com.monetization.ads.core.utils.CallbackStackTraceMarker;
import com.yandex.mobile.ads.common.VideoEventListener;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes6.dex */
public final class jn2 implements iu {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final VideoEventListener f9338a;

    static final class a extends Lambda implements Function0<Unit> {
        a() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public final Unit invoke() {
            jn2.this.f9338a.onVideoComplete();
            return Unit.INSTANCE;
        }
    }

    public jn2(VideoEventListener videoEventListener) {
        Intrinsics.checkNotNullParameter(videoEventListener, "videoEventListener");
        this.f9338a = videoEventListener;
    }

    @Override // com.yandex.mobile.ads.impl.iu
    public final void onVideoComplete() {
        new CallbackStackTraceMarker(new a());
    }

    public final boolean equals(Object obj) {
        return (obj instanceof jn2) && Intrinsics.areEqual(((jn2) obj).f9338a, this.f9338a);
    }

    public final int hashCode() {
        return this.f9338a.hashCode();
    }
}
