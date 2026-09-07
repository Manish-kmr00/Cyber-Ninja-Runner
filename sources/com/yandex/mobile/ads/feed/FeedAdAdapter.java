package com.yandex.mobile.ads.feed;

import com.monetization.ads.core.utils.CallbackStackTraceMarker;
import com.yandex.mobile.ads.impl.d90;
import com.yandex.mobile.ads.impl.ie2;
import com.yandex.mobile.ads.impl.ka0;
import com.yandex.mobile.ads.impl.pt;
import com.yandex.mobile.ads.impl.ql2;
import com.yandex.mobile.ads.impl.t4;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001:\u0001\u000eB\u000f\u0012\u0006\u0010\u000b\u001a\u00020\n¢\u0006\u0004\b\f\u0010\rR$\u0010\t\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\b¨\u0006\u000f"}, d2 = {"Lcom/yandex/mobile/ads/feed/FeedAdAdapter;", "Lcom/yandex/mobile/ads/impl/d90;", "Lcom/yandex/mobile/ads/feed/FeedAdEventListener;", "g", "Lcom/yandex/mobile/ads/feed/FeedAdEventListener;", "getEventListener", "()Lcom/yandex/mobile/ads/feed/FeedAdEventListener;", "setEventListener", "(Lcom/yandex/mobile/ads/feed/FeedAdEventListener;)V", "eventListener", "Lcom/yandex/mobile/ads/feed/FeedAd;", "feedAd", "<init>", "(Lcom/yandex/mobile/ads/feed/FeedAd;)V", "a", "mobileads_externalRelease"}, k = 1, mv = {1, 9, 0})
public final class FeedAdAdapter extends d90 {

    /* JADX INFO: renamed from: g, reason: from kotlin metadata */
    private FeedAdEventListener eventListener;
    private final pt h;
    private final ie2 i;

    /* JADX WARN: Illegal instructions before constructor call */
    public FeedAdAdapter(FeedAd feedAd) {
        Intrinsics.checkNotNullParameter(feedAd, "feedAd");
        ka0 ka0VarA = feedAd.a();
        Intrinsics.checkNotNullExpressionValue(ka0VarA, "getFeedViewModel(...)");
        super(ka0VarA, null, 2, null);
        this.h = new a();
        this.i = new ie2();
    }

    public final FeedAdEventListener getEventListener() {
        return this.eventListener;
    }

    public final void setEventListener(FeedAdEventListener feedAdEventListener) {
        this.eventListener = feedAdEventListener;
    }

    @Override // com.yandex.mobile.ads.impl.d90
    /* JADX INFO: renamed from: a, reason: from getter */
    protected final pt getH() {
        return this.h;
    }

    @Override // com.yandex.mobile.ads.impl.d90
    /* JADX INFO: renamed from: b, reason: from getter */
    protected final ie2 getI() {
        return this.i;
    }

    private final class a implements pt {

        /* JADX INFO: renamed from: com.yandex.mobile.ads.feed.FeedAdAdapter$a$a, reason: collision with other inner class name */
        static final class C0734a extends Lambda implements Function0<Unit> {
            final /* synthetic */ FeedAdAdapter b;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            C0734a(FeedAdAdapter feedAdAdapter) {
                super(0);
                this.b = feedAdAdapter;
            }

            @Override // kotlin.jvm.functions.Function0
            public final Unit invoke() {
                FeedAdEventListener eventListener = this.b.getEventListener();
                if (eventListener != null) {
                    eventListener.onAdClicked();
                }
                return Unit.INSTANCE;
            }
        }

        static final class b extends Lambda implements Function0<Unit> {
            final /* synthetic */ FeedAdAdapter b;
            final /* synthetic */ ql2 c;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            b(FeedAdAdapter feedAdAdapter, ql2 ql2Var) {
                super(0);
                this.b = feedAdAdapter;
                this.c = ql2Var;
            }

            @Override // kotlin.jvm.functions.Function0
            public final Unit invoke() {
                FeedAdEventListener eventListener = this.b.getEventListener();
                if (eventListener != null) {
                    eventListener.onImpression(this.c);
                }
                return Unit.INSTANCE;
            }
        }

        public a() {
        }

        @Override // com.yandex.mobile.ads.impl.pt
        public final void closeNativeAd() {
        }

        @Override // com.yandex.mobile.ads.impl.pt
        public final void onAdClicked() {
            new CallbackStackTraceMarker(new C0734a(FeedAdAdapter.this));
        }

        @Override // com.yandex.mobile.ads.impl.pt
        public final void onLeftApplication() {
        }

        @Override // com.yandex.mobile.ads.impl.pt
        public final void onReturnedToApplication() {
        }

        @Override // com.yandex.mobile.ads.impl.pt
        public final void a(t4 t4Var) {
            new CallbackStackTraceMarker(new b(FeedAdAdapter.this, t4Var != null ? new ql2(t4Var) : null));
        }
    }
}
