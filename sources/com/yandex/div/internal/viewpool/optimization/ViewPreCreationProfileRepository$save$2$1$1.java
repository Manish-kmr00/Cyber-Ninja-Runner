package com.yandex.div.internal.viewpool.optimization;

import com.yandex.div.internal.viewpool.ViewPreCreationProfile;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;

/* JADX INFO: compiled from: ViewPreCreationProfileRepository.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u0004\u0018\u00010\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0001H\u008a@"}, d2 = {"<anonymous>", "Lcom/yandex/div/internal/viewpool/ViewPreCreationProfile;", "it"}, k = 3, mv = {1, 5, 1}, xi = 48)
@DebugMetadata(c = "com.yandex.div.internal.viewpool.optimization.ViewPreCreationProfileRepository$save$2$1$1", f = "ViewPreCreationProfileRepository.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
final class ViewPreCreationProfileRepository$save$2$1$1 extends SuspendLambda implements Function2<ViewPreCreationProfile, Continuation<? super ViewPreCreationProfile>, Object> {
    final /* synthetic */ ViewPreCreationProfile $profile;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    ViewPreCreationProfileRepository$save$2$1$1(ViewPreCreationProfile viewPreCreationProfile, Continuation<? super ViewPreCreationProfileRepository$save$2$1$1> continuation) {
        super(2, continuation);
        this.$profile = viewPreCreationProfile;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new ViewPreCreationProfileRepository$save$2$1$1(this.$profile, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(ViewPreCreationProfile viewPreCreationProfile, Continuation<? super ViewPreCreationProfile> continuation) {
        return ((ViewPreCreationProfileRepository$save$2$1$1) create(viewPreCreationProfile, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        ResultKt.throwOnFailure(obj);
        return this.$profile;
    }
}
