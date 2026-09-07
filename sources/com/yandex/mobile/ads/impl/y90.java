package com.yandex.mobile.ads.impl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;

/* JADX INFO: loaded from: classes6.dex */
public final class y90 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final i90 f10713a;

    @DebugMetadata(c = "com.monetization.ads.feed.data.preloader.FeedItemPreloadDataSource$prepareLoadedAd$2", f = "FeedItemPreloadDataSource.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    static final class a extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super k90>, Object> {
        final /* synthetic */ cs0 b;
        final /* synthetic */ y90 c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        a(cs0 cs0Var, y90 y90Var, Continuation<? super a> continuation) {
            super(2, continuation);
            this.b = cs0Var;
            this.c = y90Var;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new a(this.b, this.c, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super k90> continuation) {
            return new a(this.b, this.c, continuation).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            ResultKt.throwOnFailure(obj);
            uz1 uz1VarB = this.b.b();
            List<y20> listC = uz1VarB.c();
            if (listC == null) {
                listC = Collections.emptyList();
            }
            Intrinsics.checkNotNull(listC);
            y90 y90Var = this.c;
            ArrayList arrayList = new ArrayList();
            Iterator<T> it = listC.iterator();
            while (it.hasNext()) {
                rk1 rk1VarA = y90Var.f10713a.a((y20) it.next(), uz1VarB);
                if (rk1VarA != null) {
                    arrayList.add(rk1VarA);
                }
            }
            return new k90(this.b.b(), this.b.a(), arrayList);
        }
    }

    public y90(i90 divKitViewPreloader) {
        Intrinsics.checkNotNullParameter(divKitViewPreloader, "divKitViewPreloader");
        this.f10713a = divKitViewPreloader;
    }

    public final Object a(cs0 cs0Var, Continuation<? super k90> continuation) {
        return BuildersKt.withContext(Dispatchers.getDefault(), new a(cs0Var, this, null), continuation);
    }
}
