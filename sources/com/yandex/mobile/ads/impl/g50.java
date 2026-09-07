package com.yandex.mobile.ads.impl;

import android.content.Context;
import java.util.List;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.serialization.json.Json;

/* JADX INFO: loaded from: classes3.dex */
public final class g50 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final o3 f8965a;
    private final ea b;
    private final nk1 c;
    private final Json d;

    @DebugMetadata(c = "com.monetization.ads.base.mediation.prefetch.EncodedPrefetchedMediationDataLoader", f = "EncodedPrefetchedMediationDataLoader.kt", i = {0}, l = {33}, m = "loadEncodedPrefetchedMediationData", n = {"this"}, s = {"L$0"})
    static final class a extends ContinuationImpl {
        g50 b;
        /* synthetic */ Object c;
        int e;

        a(Continuation<? super a> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.c = obj;
            this.e |= Integer.MIN_VALUE;
            return g50.this.a(null, this);
        }
    }

    public g50(o3 adConfiguration, el biddingSettings, ea adUnitIdMediationPrefetchSettingsProvider, cy0 mediatedAdapterReporter, nk1 prefetchedMediationNetworksDataLoader, Json jsonEncoder) {
        Intrinsics.checkNotNullParameter(adConfiguration, "adConfiguration");
        Intrinsics.checkNotNullParameter(biddingSettings, "biddingSettings");
        Intrinsics.checkNotNullParameter(adUnitIdMediationPrefetchSettingsProvider, "adUnitIdMediationPrefetchSettingsProvider");
        Intrinsics.checkNotNullParameter(mediatedAdapterReporter, "mediatedAdapterReporter");
        Intrinsics.checkNotNullParameter(prefetchedMediationNetworksDataLoader, "prefetchedMediationNetworksDataLoader");
        Intrinsics.checkNotNullParameter(jsonEncoder, "jsonEncoder");
        this.f8965a = adConfiguration;
        this.b = adUnitIdMediationPrefetchSettingsProvider;
        this.c = prefetchedMediationNetworksDataLoader;
        this.d = jsonEncoder;
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    public final Object a(Context context, Continuation<? super String> continuation) throws Throwable {
        a aVar;
        g50 g50Var;
        if (continuation instanceof a) {
            aVar = (a) continuation;
            int i = aVar.e;
            if ((i & Integer.MIN_VALUE) != 0) {
                aVar.e = i - Integer.MIN_VALUE;
            } else {
                aVar = new a(continuation);
            }
        } else {
            aVar = new a(continuation);
        }
        Object objWithContext = aVar.c;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i2 = aVar.e;
        if (i2 == 0) {
            ResultKt.throwOnFailure(objWithContext);
            b01 b01VarA = this.b.a(this.f8965a.c());
            if (b01VarA == null) {
                return null;
            }
            List<c01> listB = b01VarA.b();
            long jA = b01VarA.a();
            zy1 zy1VarR = this.f8965a.r();
            nk1 nk1Var = this.c;
            aVar.b = this;
            aVar.e = 1;
            nk1Var.getClass();
            objWithContext = BuildersKt.withContext(nu.b(), new jk1(jA, context, zy1VarR, nk1Var, listB, null), aVar);
            if (objWithContext == coroutine_suspended) {
                return coroutine_suspended;
            }
            g50Var = this;
        } else {
            if (i2 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            g50Var = aVar.b;
            ResultKt.throwOnFailure(objWithContext);
        }
        Json json = g50Var.d;
        json.getSerializersModule();
        return json.encodeToString(bk1.Companion.serializer(), (bk1) objWithContext);
    }
}
