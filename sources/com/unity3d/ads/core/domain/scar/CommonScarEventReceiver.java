package com.unity3d.ads.core.domain.scar;

import com.unity3d.scar.adapter.common.GMAEvent;
import com.unity3d.services.banners.bridge.BannerBridge;
import com.unity3d.services.core.webview.WebViewEventCategory;
import com.unity3d.services.core.webview.bridge.IEventSender;
import com.vungle.ads.internal.protos.Sdk;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.SetsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.FlowKt;
import kotlinx.coroutines.flow.MutableSharedFlow;
import kotlinx.coroutines.flow.SharedFlow;
import kotlinx.coroutines.flow.SharedFlowKt;

/* JADX INFO: compiled from: CommonScarEventReceiver.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0010\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\u0010\u0000\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\b\u0010\u0010\u001a\u00020\u0011H\u0016J9\u0010\u0012\u001a\u00020\u00112\n\u0010\u0013\u001a\u0006\u0012\u0002\b\u00030\u00142\n\u0010\u0015\u001a\u0006\u0012\u0002\b\u00030\u00142\u0012\u0010\u0016\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00180\u0017\"\u00020\u0018H\u0016¢\u0006\u0002\u0010\u0019R\u0014\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\b\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\t0\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00070\u000b¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0019\u0010\u000e\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\t0\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\r¨\u0006\u001a"}, d2 = {"Lcom/unity3d/ads/core/domain/scar/CommonScarEventReceiver;", "Lcom/unity3d/services/core/webview/bridge/IEventSender;", "scope", "Lkotlinx/coroutines/CoroutineScope;", "(Lkotlinx/coroutines/CoroutineScope;)V", "_gmaEventFlow", "Lkotlinx/coroutines/flow/MutableSharedFlow;", "Lcom/unity3d/ads/core/domain/scar/GmaEventData;", "_versionFlow", "", "gmaEventFlow", "Lkotlinx/coroutines/flow/SharedFlow;", "getGmaEventFlow", "()Lkotlinx/coroutines/flow/SharedFlow;", "versionFlow", "getVersionFlow", "canSend", "", "sendEvent", "eventCategory", "", "eventId", "params", "", "", "(Ljava/lang/Enum;Ljava/lang/Enum;[Ljava/lang/Object;)Z", "unity-ads_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class CommonScarEventReceiver implements IEventSender {
    private final MutableSharedFlow<GmaEventData> _gmaEventFlow;
    private final MutableSharedFlow<String> _versionFlow;
    private final SharedFlow<GmaEventData> gmaEventFlow;
    private final CoroutineScope scope;
    private final SharedFlow<String> versionFlow;

    @Override // com.unity3d.services.core.webview.bridge.IEventSender
    public boolean canSend() {
        return true;
    }

    public CommonScarEventReceiver(CoroutineScope scope) {
        Intrinsics.checkNotNullParameter(scope, "scope");
        this.scope = scope;
        MutableSharedFlow<String> mutableSharedFlowMutableSharedFlow$default = SharedFlowKt.MutableSharedFlow$default(0, 0, null, 7, null);
        this._versionFlow = mutableSharedFlowMutableSharedFlow$default;
        this.versionFlow = FlowKt.asSharedFlow(mutableSharedFlowMutableSharedFlow$default);
        MutableSharedFlow<GmaEventData> mutableSharedFlowMutableSharedFlow$default2 = SharedFlowKt.MutableSharedFlow$default(0, 0, null, 7, null);
        this._gmaEventFlow = mutableSharedFlowMutableSharedFlow$default2;
        this.gmaEventFlow = FlowKt.asSharedFlow(mutableSharedFlowMutableSharedFlow$default2);
    }

    public final SharedFlow<String> getVersionFlow() {
        return this.versionFlow;
    }

    public final SharedFlow<GmaEventData> getGmaEventFlow() {
        return this.gmaEventFlow;
    }

    @Override // com.unity3d.services.core.webview.bridge.IEventSender
    public boolean sendEvent(Enum<?> eventCategory, Enum<?> eventId, Object... params) {
        Intrinsics.checkNotNullParameter(eventCategory, "eventCategory");
        Intrinsics.checkNotNullParameter(eventId, "eventId");
        Intrinsics.checkNotNullParameter(params, "params");
        if (!CollectionsKt.contains(SetsKt.setOf((Object[]) new WebViewEventCategory[]{WebViewEventCategory.INIT_GMA, WebViewEventCategory.GMA, WebViewEventCategory.BANNER}), eventCategory)) {
            return false;
        }
        BuildersKt__Builders_commonKt.launch$default(this.scope, null, null, new AnonymousClass1(eventId, params, this, null), 3, null);
        return true;
    }

    /* JADX INFO: renamed from: com.unity3d.ads.core.domain.scar.CommonScarEventReceiver$sendEvent$1, reason: invalid class name */
    /* JADX INFO: compiled from: CommonScarEventReceiver.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
    @DebugMetadata(c = "com.unity3d.ads.core.domain.scar.CommonScarEventReceiver$sendEvent$1", f = "CommonScarEventReceiver.kt", i = {}, l = {35, 41, 52, 66, 73}, m = "invokeSuspend", n = {}, s = {})
    static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ Enum<?> $eventId;
        final /* synthetic */ Object[] $params;
        int label;
        final /* synthetic */ CommonScarEventReceiver this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(Enum<?> r1, Object[] objArr, CommonScarEventReceiver commonScarEventReceiver, Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
            this.$eventId = r1;
            this.$params = objArr;
            this.this$0 = commonScarEventReceiver;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new AnonymousClass1(this.$eventId, this.$params, this.this$0, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Code duplicated, block: B:40:0x0103  */
        /* JADX WARN: Code duplicated, block: B:42:0x0135 A[RETURN] */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            MutableSharedFlow mutableSharedFlow;
            GMAEvent gMAEvent;
            BannerBridge.BannerEvent bannerEvent;
            Object obj2;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i != 0) {
                if (i != 1 && i != 2 && i != 3) {
                    if (i == 4) {
                        ResultKt.throwOnFailure(obj);
                        if (this.$eventId instanceof BannerBridge.BannerEvent) {
                            mutableSharedFlow = this.this$0._gmaEventFlow;
                            gMAEvent = GMAEvent.BANNER;
                            bannerEvent = (BannerBridge.BannerEvent) this.$eventId;
                            obj2 = this.$params[0];
                            Intrinsics.checkNotNull(obj2, "null cannot be cast to non-null type kotlin.String");
                            this.label = 5;
                            if (mutableSharedFlow.emit(new GmaEventData(gMAEvent, bannerEvent, (String) obj2, null, null, null, null, 120, null), this) == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                        }
                    } else if (i != 5) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                }
                ResultKt.throwOnFailure(obj);
            } else {
                ResultKt.throwOnFailure(obj);
                Enum<?> r2 = this.$eventId;
                if (r2 == GMAEvent.VERSION) {
                    Object[] objArr = this.$params;
                    CommonScarEventReceiver commonScarEventReceiver = this.this$0;
                    String str = (String) objArr[0];
                    MutableSharedFlow mutableSharedFlow2 = commonScarEventReceiver._versionFlow;
                    if (Intrinsics.areEqual(str, "0.0.0")) {
                        str = null;
                    }
                    this.label = 1;
                    if (mutableSharedFlow2.emit(str, this) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                } else if (r2 == GMAEvent.AD_LOADED) {
                    Object[] objArr2 = this.$params;
                    MutableSharedFlow mutableSharedFlow3 = this.this$0._gmaEventFlow;
                    GMAEvent gMAEvent2 = GMAEvent.AD_LOADED;
                    Object obj3 = objArr2[0];
                    Intrinsics.checkNotNull(obj3, "null cannot be cast to non-null type kotlin.String");
                    GmaEventData gmaEventData = new GmaEventData(gMAEvent2, null, null, (String) obj3, null, null, null, Sdk.SDKError.Reason.PROTOBUF_SERIALIZATION_ERROR_VALUE, null);
                    this.label = 2;
                    if (mutableSharedFlow3.emit(gmaEventData, this) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                } else if (r2 == GMAEvent.LOAD_ERROR) {
                    Object[] objArr3 = this.$params;
                    MutableSharedFlow mutableSharedFlow4 = this.this$0._gmaEventFlow;
                    GMAEvent gMAEvent3 = GMAEvent.LOAD_ERROR;
                    Object obj4 = objArr3[0];
                    Intrinsics.checkNotNull(obj4, "null cannot be cast to non-null type kotlin.String");
                    Object obj5 = objArr3[1];
                    Intrinsics.checkNotNull(obj5, "null cannot be cast to non-null type kotlin.String");
                    Object obj6 = objArr3[2];
                    Intrinsics.checkNotNull(obj6, "null cannot be cast to non-null type kotlin.String");
                    Object obj7 = objArr3[3];
                    Intrinsics.checkNotNull(obj7, "null cannot be cast to non-null type kotlin.Int");
                    GmaEventData gmaEventData2 = new GmaEventData(gMAEvent3, null, null, (String) obj4, (String) obj5, (String) obj6, (Integer) obj7, 6, null);
                    this.label = 3;
                    if (mutableSharedFlow4.emit(gmaEventData2, this) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                } else {
                    if (this.$eventId instanceof GMAEvent) {
                        this.label = 4;
                        if (this.this$0._gmaEventFlow.emit(new GmaEventData((GMAEvent) this.$eventId, null, null, null, null, null, null, 126, null), this) == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                    }
                    if (this.$eventId instanceof BannerBridge.BannerEvent) {
                        mutableSharedFlow = this.this$0._gmaEventFlow;
                        gMAEvent = GMAEvent.BANNER;
                        bannerEvent = (BannerBridge.BannerEvent) this.$eventId;
                        obj2 = this.$params[0];
                        Intrinsics.checkNotNull(obj2, "null cannot be cast to non-null type kotlin.String");
                        this.label = 5;
                        if (mutableSharedFlow.emit(new GmaEventData(gMAEvent, bannerEvent, (String) obj2, null, null, null, null, 120, null), this) == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                    }
                }
            }
            return Unit.INSTANCE;
        }
    }
}
