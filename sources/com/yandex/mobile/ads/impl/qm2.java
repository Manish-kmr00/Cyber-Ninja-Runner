package com.yandex.mobile.ads.impl;

import com.monetization.ads.core.utils.CallbackStackTraceMarker;
import com.yandex.mobile.ads.common.AdRequestError;
import com.yandex.mobile.ads.nativeads.NativeBulkAdLoadListener;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes12.dex */
public final class qm2 implements yt {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final NativeBulkAdLoadListener f10037a;

    static final class a extends Lambda implements Function0<Unit> {
        final /* synthetic */ AdRequestError c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        a(AdRequestError adRequestError) {
            super(0);
            this.c = adRequestError;
        }

        @Override // kotlin.jvm.functions.Function0
        public final Unit invoke() {
            qm2.this.f10037a.onAdsFailedToLoad(this.c);
            return Unit.INSTANCE;
        }
    }

    static final class b extends Lambda implements Function0<Unit> {
        final /* synthetic */ List<com.yandex.mobile.ads.nativeads.e> c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        b(ArrayList arrayList) {
            super(0);
            this.c = arrayList;
        }

        @Override // kotlin.jvm.functions.Function0
        public final Unit invoke() {
            qm2.this.f10037a.onAdsLoaded(this.c);
            return Unit.INSTANCE;
        }
    }

    public qm2(NativeBulkAdLoadListener loadListener) {
        Intrinsics.checkNotNullParameter(loadListener, "loadListener");
        this.f10037a = loadListener;
    }

    @Override // com.yandex.mobile.ads.impl.yt
    public final void onAdsLoaded(List<? extends m61> nativeAds) {
        Intrinsics.checkNotNullParameter(nativeAds, "nativeAds");
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(nativeAds, 10));
        Iterator<T> it = nativeAds.iterator();
        while (it.hasNext()) {
            arrayList.add(new com.yandex.mobile.ads.nativeads.e((m61) it.next()));
        }
        new CallbackStackTraceMarker(new b(arrayList));
    }

    @Override // com.yandex.mobile.ads.impl.yt
    public final void a(w3 error) {
        Intrinsics.checkNotNullParameter(error, "error");
        new CallbackStackTraceMarker(new a(new AdRequestError(error.b(), error.d(), error.a())));
    }
}
