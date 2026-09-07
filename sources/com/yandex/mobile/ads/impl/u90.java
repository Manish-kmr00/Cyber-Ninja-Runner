package com.yandex.mobile.ads.impl;

import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Result;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.SafeContinuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
public final class u90 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final t90 f10366a;
    private final c90 b;

    public u90(t90 feedItemLoadControllerCreator, c90 feedAdRequestDataProvider) {
        Intrinsics.checkNotNullParameter(feedItemLoadControllerCreator, "feedItemLoadControllerCreator");
        Intrinsics.checkNotNullParameter(feedAdRequestDataProvider, "feedAdRequestDataProvider");
        this.f10366a = feedItemLoadControllerCreator;
        this.b = feedAdRequestDataProvider;
    }

    public final Object a(v7 adRequestData, List<k90> feedItemList, Continuation<? super x90> continuation) {
        List<c41> listE;
        o8<String> o8VarA;
        SafeContinuation safeContinuation = new SafeContinuation(IntrinsicsKt.intercepted(continuation));
        a aVar = new a(safeContinuation);
        k90 k90Var = (k90) CollectionsKt.lastOrNull((List) feedItemList);
        ha0 ha0VarA = (k90Var == null || (o8VarA = k90Var.a()) == null) ? null : o8VarA.A();
        this.b.getClass();
        Intrinsics.checkNotNullParameter(adRequestData, "adRequestData");
        Intrinsics.checkNotNullParameter(feedItemList, "feedItemList");
        int size = feedItemList.size() + 1;
        Iterator<T> it = feedItemList.iterator();
        int size2 = 0;
        while (it.hasNext()) {
            u61 u61VarA = ((k90) it.next()).c().a();
            size2 += (u61VarA == null || (listE = u61VarA.e()) == null) ? 0 : listE.size();
        }
        Map mapCreateMapBuilder = MapsKt.createMapBuilder();
        Map<String, String> mapH = adRequestData.h();
        if (mapH == null) {
            mapH = MapsKt.emptyMap();
        }
        mapCreateMapBuilder.putAll(mapH);
        mapCreateMapBuilder.put("feed-page", String.valueOf(size));
        mapCreateMapBuilder.put("feed-ads-count", String.valueOf(size2));
        this.f10366a.a(aVar, v7.a(adRequestData, MapsKt.build(mapCreateMapBuilder), null, 4031), ha0VarA).y();
        Object orThrow = safeContinuation.getOrThrow();
        if (orThrow == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            DebugProbesKt.probeCoroutineSuspended(continuation);
        }
        return orThrow;
    }

    private static final class a implements w90 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final Continuation<x90> f10367a;

        public a(SafeContinuation continuation) {
            Intrinsics.checkNotNullParameter(continuation, "continuation");
            this.f10367a = continuation;
        }

        @Override // com.yandex.mobile.ads.impl.w90
        public final void a(w3 adRequestError) {
            Intrinsics.checkNotNullParameter(adRequestError, "adRequestError");
            Continuation<x90> continuation = this.f10367a;
            Result.Companion companion = Result.INSTANCE;
            continuation.resumeWith(Result.m7904constructorimpl(new x90.a(adRequestError)));
        }

        @Override // com.yandex.mobile.ads.impl.w90
        public final void a(cs0 loadedFeedItem) {
            Intrinsics.checkNotNullParameter(loadedFeedItem, "loadedFeedItem");
            Continuation<x90> continuation = this.f10367a;
            Result.Companion companion = Result.INSTANCE;
            continuation.resumeWith(Result.m7904constructorimpl(new x90.b(loadedFeedItem)));
        }
    }
}
