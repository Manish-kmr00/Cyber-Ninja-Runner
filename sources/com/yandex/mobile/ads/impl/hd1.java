package com.yandex.mobile.ads.impl;

import android.content.Context;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
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
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes9.dex */
public final class hd1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final lz0 f9084a;
    private final Object b;

    @DebugMetadata(c = "com.monetization.ads.base.mediation.bidding.NetworksHeaderBiddingDataLoader$loadNetworksBiddingDataInternal$3", f = "NetworksHeaderBiddingDataLoader.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    static final class a extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super JSONArray>, Object> {
        final /* synthetic */ CountDownLatch c;
        final /* synthetic */ ArrayList<JSONObject> d;
        final /* synthetic */ dl e;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        a(CountDownLatch countDownLatch, ArrayList<JSONObject> arrayList, dl dlVar, Continuation<? super a> continuation) {
            super(2, continuation);
            this.c = countDownLatch;
            this.d = arrayList;
            this.e = dlVar;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return hd1.this.new a(this.c, this.d, this.e, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super JSONArray> continuation) {
            return ((a) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            ResultKt.throwOnFailure(obj);
            return hd1.a(hd1.this, this.c, this.d, this.e);
        }
    }

    public /* synthetic */ hd1(cy0 cy0Var) {
        this(cy0Var, new lz0(cy0Var));
    }

    public static final JSONArray a(hd1 hd1Var, CountDownLatch countDownLatch, ArrayList arrayList, dl dlVar) {
        JSONArray jSONArray;
        hd1Var.getClass();
        try {
            if (!countDownLatch.await(1000L, TimeUnit.MILLISECONDS)) {
                op0.b(new Object[0]);
            }
            dlVar.b();
            synchronized (hd1Var.b) {
                jSONArray = new JSONArray((Collection) arrayList);
            }
            return jSONArray;
        } catch (InterruptedException unused) {
            op0.c(new Object[0]);
            return null;
        }
    }

    public hd1(cy0 mediatedAdapterReporter, lz0 mediationNetworkBiddingDataLoader) {
        Intrinsics.checkNotNullParameter(mediatedAdapterReporter, "mediatedAdapterReporter");
        Intrinsics.checkNotNullParameter(mediationNetworkBiddingDataLoader, "mediationNetworkBiddingDataLoader");
        this.f9084a = mediationNetworkBiddingDataLoader;
        this.b = new Object();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object a(Context context, zy1 zy1Var, List<hz0> list, Continuation<? super JSONArray> continuation) {
        final ArrayList arrayList = new ArrayList(list.size());
        final CountDownLatch countDownLatch = new CountDownLatch(list.size());
        dl dlVar = new dl();
        Iterator<hz0> it = list.iterator();
        while (it.hasNext()) {
            this.f9084a.a(context, zy1Var, it.next(), dlVar, new lz0.a() { // from class: com.yandex.mobile.ads.impl.hd1$$ExternalSyntheticLambda0
                @Override // com.yandex.mobile.ads.impl.lz0.a
                public final void a(JSONObject jSONObject) {
                    hd1.a(this.f$0, countDownLatch, arrayList, jSONObject);
                }
            });
        }
        return BuildersKt.withContext(nu.a(), new a(countDownLatch, arrayList, dlVar, null), continuation);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(hd1 this$0, CountDownLatch resultsCollectingLatch, ArrayList networksBiddingDataList, JSONObject jSONObject) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(resultsCollectingLatch, "$resultsCollectingLatch");
        Intrinsics.checkNotNullParameter(networksBiddingDataList, "$networksBiddingDataList");
        if (jSONObject != null) {
            synchronized (this$0.b) {
                networksBiddingDataList.add(jSONObject);
            }
        }
        resultsCollectingLatch.countDown();
    }
}
