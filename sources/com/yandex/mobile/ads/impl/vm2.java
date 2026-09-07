package com.yandex.mobile.ads.impl;

import com.monetization.ads.core.utils.CallbackStackTraceMarker;
import com.yandex.mobile.ads.common.AdRequestError;
import com.yandex.mobile.ads.rewarded.RewardedAdLoadListener;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes10.dex */
public final class vm2 implements fu {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final RewardedAdLoadListener f10496a;

    static final class a extends Lambda implements Function0<Unit> {
        final /* synthetic */ AdRequestError c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        a(AdRequestError adRequestError) {
            super(0);
            this.c = adRequestError;
        }

        @Override // kotlin.jvm.functions.Function0
        public final Unit invoke() {
            RewardedAdLoadListener rewardedAdLoadListener = vm2.this.f10496a;
            if (rewardedAdLoadListener != null) {
                rewardedAdLoadListener.onAdFailedToLoad(this.c);
            }
            return Unit.INSTANCE;
        }
    }

    static final class b extends Lambda implements Function0<Unit> {
        final /* synthetic */ tm2 c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        b(tm2 tm2Var) {
            super(0);
            this.c = tm2Var;
        }

        @Override // kotlin.jvm.functions.Function0
        public final Unit invoke() {
            RewardedAdLoadListener rewardedAdLoadListener = vm2.this.f10496a;
            if (rewardedAdLoadListener != null) {
                rewardedAdLoadListener.onAdLoaded(this.c);
            }
            return Unit.INSTANCE;
        }
    }

    public vm2(RewardedAdLoadListener rewardedAdLoadListener) {
        this.f10496a = rewardedAdLoadListener;
    }

    @Override // com.yandex.mobile.ads.impl.fu
    public final void a(w3 error) {
        Intrinsics.checkNotNullParameter(error, "error");
        Intrinsics.checkNotNullParameter(error, "error");
        new CallbackStackTraceMarker(new a(new AdRequestError(error.b(), error.d(), error.a())));
    }

    @Override // com.yandex.mobile.ads.impl.fu
    public final void a(du rewarded) {
        Intrinsics.checkNotNullParameter(rewarded, "rewarded");
        new CallbackStackTraceMarker(new b(new tm2(rewarded, new bl2())));
    }
}
