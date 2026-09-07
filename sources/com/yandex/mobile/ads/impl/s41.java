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

/* JADX INFO: loaded from: classes8.dex */
public final class s41 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final iw1 f10176a;
    private final lc1 b;
    private final hc1 c;

    @DebugMetadata(c = "com.monetization.ads.nativeads.creator.videowrapper.NativeAdBlockVideoWrapperLoader", f = "NativeAdBlockVideoWrapperLoader.kt", i = {0}, l = {30}, m = "updateNativeAdBlockWithWrapperVideo", n = {"nativeAdBlock"}, s = {"L$0"})
    static final class a extends ContinuationImpl {
        o41 b;
        /* synthetic */ Object c;
        int e;

        a(Continuation<? super a> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.c = obj;
            this.e |= Integer.MIN_VALUE;
            return s41.this.a((Context) null, (o41) null, this);
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ s41(Context context, o3 o3Var) {
        this(context, o3Var, iw1.a.a(), new lc1(context, o3Var), new hc1());
        int i = iw1.l;
    }

    public s41(Context context, o3 adConfiguration, iw1 sdkSettings, lc1 nativeWrapperVideoLoader, hc1 nativeWrapperVideoAssetChecker) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(adConfiguration, "adConfiguration");
        Intrinsics.checkNotNullParameter(sdkSettings, "sdkSettings");
        Intrinsics.checkNotNullParameter(nativeWrapperVideoLoader, "nativeWrapperVideoLoader");
        Intrinsics.checkNotNullParameter(nativeWrapperVideoAssetChecker, "nativeWrapperVideoAssetChecker");
        this.f10176a = sdkSettings;
        this.b = nativeWrapperVideoLoader;
        this.c = nativeWrapperVideoAssetChecker;
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0016  */
    public static final Object a(s41 s41Var, ig igVar, Continuation continuation) throws Throwable {
        r41 r41Var;
        ig igVar2;
        ig igVar3;
        s41Var.getClass();
        if (continuation instanceof r41) {
            r41Var = (r41) continuation;
            int i = r41Var.e;
            if ((i & Integer.MIN_VALUE) != 0) {
                r41Var.e = i - Integer.MIN_VALUE;
            } else {
                r41Var = new r41(s41Var, continuation);
            }
        } else {
            r41Var = new r41(s41Var, continuation);
        }
        Object obj = r41Var.c;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i2 = r41Var.e;
        if (i2 == 0) {
            ResultKt.throwOnFailure(obj);
            if (igVar.d() instanceof ax0) {
                Intrinsics.checkNotNull(igVar, "null cannot be cast to non-null type com.monetization.ads.network.model.Asset<R of com.monetization.ads.network.model.AssetKt.cast>");
                igVar2 = igVar;
            } else {
                igVar2 = null;
            }
            if (igVar2 == null) {
                return igVar;
            }
            lc1 lc1Var = s41Var.b;
            db2 db2VarC = ((ax0) igVar2.d()).c();
            r41Var.b = igVar2;
            r41Var.e = 1;
            lc1Var.getClass();
            Object objWithContext = BuildersKt.withContext(nu.a(), new ic1(db2VarC, lc1Var, null), r41Var);
            if (objWithContext == coroutine_suspended) {
                return coroutine_suspended;
            }
            ig igVar4 = igVar2;
            obj = objWithContext;
            igVar3 = igVar4;
        } else {
            if (i2 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            igVar3 = r41Var.b;
            ResultKt.throwOnFailure(obj);
        }
        db2 db2Var = (db2) obj;
        if (db2Var == null && ((ax0) igVar3.d()).a() == null && ((ax0) igVar3.d()).b() == null) {
            return null;
        }
        return ig.a(igVar3, ax0.a((ax0) igVar3.d(), db2Var));
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    public final Object a(Context context, o41 o41Var, Continuation<? super o41> continuation) throws Throwable {
        a aVar;
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
            cu1 cu1VarA = this.f10176a.a(context);
            if (cu1VarA == null || !cu1VarA.G()) {
                return o41Var;
            }
            List<c41> listE = o41Var.c().e();
            aVar.b = o41Var;
            aVar.e = 1;
            objWithContext = BuildersKt.withContext(nu.a(), new t41(listE, this, null), aVar);
            if (objWithContext == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i2 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            o41Var = aVar.b;
            ResultKt.throwOnFailure(objWithContext);
        }
        List list = (List) objWithContext;
        if (list == null) {
            return null;
        }
        return o41.a(o41Var, u61.a(o41Var.c(), list));
    }
}
