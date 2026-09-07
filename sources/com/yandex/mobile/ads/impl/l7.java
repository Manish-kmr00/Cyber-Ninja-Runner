package com.yandex.mobile.ads.impl;

import android.content.Context;
import com.monetization.ads.mediation.base.model.MediatedAdObjectInfo;
import com.monetization.ads.quality.base.model.AdQualityVerificationBlockingReasons;
import com.monetization.ads.quality.base.result.AdQualityVerificationResult;
import com.monetization.ads.quality.base.state.AdQualityVerificationState;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes.dex */
public final class l7 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final o3 f9485a;
    private final Context b;
    private final e7 c;
    private o8<?> d;
    private AdQualityVerificationResult e;
    private final Lazy f;

    static final class a extends Lambda implements Function0<p7> {
        a() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public final p7 invoke() {
            return new q7(0).a(l7.this.b);
        }
    }

    @DebugMetadata(c = "com.monetization.ads.base.quality.AdQualityVerifierController", f = "AdQualityVerifierController.kt", i = {0}, l = {42}, m = "verifyAd-BWLJW6A", n = {"this"}, s = {"L$0"})
    static final class b extends ContinuationImpl {
        l7 b;
        /* synthetic */ Object c;
        int e;

        b(Continuation<? super b> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.c = obj;
            this.e |= Integer.MIN_VALUE;
            Object objA = l7.this.a(null, null, null, this);
            return objA == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objA : Result.m7903boximpl(objA);
        }
    }

    private final boolean e() {
        int i = iw1.l;
        cu1 cu1VarA = iw1.a.a().a(this.b);
        b7 b7VarF = cu1VarA != null ? cu1VarA.f() : null;
        return b7VarF != null && b7VarF.e();
    }

    public /* synthetic */ l7(o3 o3Var, Context context) {
        this(o3Var, context, new e7(o3Var));
    }

    public l7(o3 adConfiguration, Context context, e7 adQualityVerificationReporter) {
        Intrinsics.checkNotNullParameter(adConfiguration, "adConfiguration");
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(adQualityVerificationReporter, "adQualityVerificationReporter");
        this.f9485a = adConfiguration;
        this.b = context;
        this.c = adQualityVerificationReporter;
        this.e = AdQualityVerificationResult.WaitingForVerification.INSTANCE;
        this.f = LazyKt.lazy(new a());
    }

    public final void c() {
        if (e()) {
            ((p7) this.f.getValue()).onAdWillDisplay();
        }
    }

    public final void b() {
        if (e()) {
            ((p7) this.f.getValue()).onAdClosed();
            d();
        }
    }

    public final void d() {
        if (e()) {
            this.c.a(this.b, this.e, this.d);
            ((p7) this.f.getValue()).onInvalidated();
        }
    }

    public final void a() {
        if (e()) {
            ((p7) this.f.getValue()).onAdClicked();
        }
    }

    /* JADX WARN: Code duplicated, block: B:28:0x008a  */
    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    public final Object a(Object obj, o8<?> o8Var, MediatedAdObjectInfo mediatedAdObjectInfo, Continuation<? super Result<Unit>> continuation) {
        b bVar;
        l7 l7Var;
        AdQualityVerificationBlockingReasons reason;
        if (continuation instanceof b) {
            bVar = (b) continuation;
            int i = bVar.e;
            if ((i & Integer.MIN_VALUE) != 0) {
                bVar.e = i - Integer.MIN_VALUE;
            } else {
                bVar = new b(continuation);
            }
        } else {
            bVar = new b(continuation);
        }
        b bVar2 = bVar;
        Object objA = bVar2.c;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i2 = bVar2.e;
        if (i2 == 0) {
            ResultKt.throwOnFailure(objA);
            if (e()) {
                this.d = o8Var;
                p7 p7Var = (p7) this.f.getValue();
                Context context = this.b;
                o3 o3Var = this.f9485a;
                bVar2.b = this;
                bVar2.e = 1;
                objA = p7Var.a(context, obj, o8Var, o3Var, mediatedAdObjectInfo, bVar2);
                if (objA == coroutine_suspended) {
                    return coroutine_suspended;
                }
                l7Var = this;
            } else {
                Result.Companion companion = Result.INSTANCE;
                return Result.m7904constructorimpl(Unit.INSTANCE);
            }
        } else {
            if (i2 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            l7Var = bVar2.b;
            ResultKt.throwOnFailure(objA);
        }
        AdQualityVerificationResult adQualityVerificationResult = (AdQualityVerificationResult) objA;
        l7Var.e = adQualityVerificationResult;
        if (adQualityVerificationResult instanceof AdQualityVerificationResult.Verified) {
            AdQualityVerificationState value = ((AdQualityVerificationResult.Verified) adQualityVerificationResult).getVerifiedAd().getVerificationResultStateFlow().getValue();
            if (value instanceof AdQualityVerificationState.Blocked) {
                reason = ((AdQualityVerificationState.Blocked) value).getReason();
            } else if (value instanceof AdQualityVerificationState.ShouldBeBlockedOnDisplay) {
                reason = ((AdQualityVerificationState.ShouldBeBlockedOnDisplay) value).getReason();
            } else {
                reason = null;
            }
        } else {
            reason = null;
        }
        if (reason != null && (!reason.getBlockReasons().isEmpty() || !reason.getReportReasons().isEmpty())) {
            Result.Companion companion2 = Result.INSTANCE;
            return Result.m7904constructorimpl(ResultKt.createFailure(new Throwable(reason.toString())));
        }
        Result.Companion companion3 = Result.INSTANCE;
        return Result.m7904constructorimpl(Unit.INSTANCE);
    }
}
