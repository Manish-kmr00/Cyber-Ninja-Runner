package com.yandex.mobile.ads.impl;

import com.monetization.ads.core.utils.CallbackStackTraceMarker;
import com.yandex.mobile.ads.common.AdRequestError;
import com.yandex.mobile.ads.feed.FeedAdLoadListener;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes11.dex */
public final class a90 implements ys {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final FeedAdLoadListener f8380a;

    static final class a extends Lambda implements Function0<Unit> {
        final /* synthetic */ AdRequestError c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        a(AdRequestError adRequestError) {
            super(0);
            this.c = adRequestError;
        }

        @Override // kotlin.jvm.functions.Function0
        public final Unit invoke() {
            FeedAdLoadListener feedAdLoadListener = a90.this.f8380a;
            if (feedAdLoadListener != null) {
                feedAdLoadListener.onAdFailedToLoad(this.c);
            }
            return Unit.INSTANCE;
        }
    }

    static final class b extends Lambda implements Function0<Unit> {
        b() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public final Unit invoke() {
            FeedAdLoadListener feedAdLoadListener = a90.this.f8380a;
            if (feedAdLoadListener != null) {
                feedAdLoadListener.onAdLoaded();
            }
            return Unit.INSTANCE;
        }
    }

    @Override // com.yandex.mobile.ads.impl.ys
    public final void onAdLoaded() {
        new CallbackStackTraceMarker(new b());
    }

    public a90(FeedAdLoadListener feedAdLoadListener) {
        this.f8380a = feedAdLoadListener;
    }

    @Override // com.yandex.mobile.ads.impl.ys
    public final void a(w3 error) {
        Intrinsics.checkNotNullParameter(error, "error");
        Intrinsics.checkNotNullParameter(error, "error");
        new CallbackStackTraceMarker(new a(new AdRequestError(error.b(), error.d(), error.a())));
    }
}
