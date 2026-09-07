package com.yandex.mobile.ads.impl;

import com.monetization.ads.core.utils.CallbackStackTraceMarker;
import com.yandex.mobile.ads.common.BidderTokenLoadListener;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes9.dex */
public final class ml2 implements xs {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final BidderTokenLoadListener f9653a;

    static final class a extends Lambda implements Function0<Unit> {
        final /* synthetic */ String c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        a(String str) {
            super(0);
            this.c = str;
        }

        @Override // kotlin.jvm.functions.Function0
        public final Unit invoke() {
            ml2.this.f9653a.onBidderTokenLoaded(this.c);
            return Unit.INSTANCE;
        }
    }

    public ml2(BidderTokenLoadListener bidderTokenLoadListener) {
        Intrinsics.checkNotNullParameter(bidderTokenLoadListener, "bidderTokenLoadListener");
        this.f9653a = bidderTokenLoadListener;
    }

    @Override // com.yandex.mobile.ads.impl.xs
    public final void onBidderTokenLoaded(String bidderToken) {
        Intrinsics.checkNotNullParameter(bidderToken, "bidderToken");
        new CallbackStackTraceMarker(new a(bidderToken));
    }

    @Override // com.yandex.mobile.ads.impl.xs
    public final void a() {
        Intrinsics.checkNotNullParameter("Cannot load bidder token. Token generation failed", "failureReason");
        new CallbackStackTraceMarker(new ll2(this));
    }
}
