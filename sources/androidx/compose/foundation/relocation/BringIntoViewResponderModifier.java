package androidx.compose.foundation.relocation;

import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.layout.LayoutCoordinates;
import androidx.compose.ui.modifier.ModifierLocalProvider;
import androidx.compose.ui.modifier.ProvidableModifierLocal;
import com.vungle.ads.internal.protos.Sdk;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.JobKt;

/* JADX INFO: compiled from: BringIntoViewResponder.kt */
/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0002\u0018\u00002\u00020\u00012\n\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u00022\u00020\u0003B\r\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0002\u0010\u0005J!\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\f2\u0006\u0010\u001b\u001a\u00020\u001cH\u0096@ø\u0001\u0000¢\u0006\u0002\u0010\u001dJ-\u0010\u001e\u001a\u00020\u00192\u0012\u0010\u001f\u001a\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\r0\u000b2\u0006\u0010 \u001a\u00020\u001cH\u0082@ø\u0001\u0000¢\u0006\u0002\u0010!R\u001c\u0010\u0006\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u00078VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\b\u0010\tR\u001c\u0010\n\u001a\u0010\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\r\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u001c\u0010\u000e\u001a\u0010\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\r\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u000f\u001a\u00020\u0010X\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u0014\u0010\u0015\u001a\u00020\u00038VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0016\u0010\u0017\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\""}, d2 = {"Landroidx/compose/foundation/relocation/BringIntoViewResponderModifier;", "Landroidx/compose/foundation/relocation/BringIntoViewChildModifier;", "Landroidx/compose/ui/modifier/ModifierLocalProvider;", "Landroidx/compose/foundation/relocation/BringIntoViewParent;", "defaultParent", "(Landroidx/compose/foundation/relocation/BringIntoViewParent;)V", "key", "Landroidx/compose/ui/modifier/ProvidableModifierLocal;", "getKey", "()Landroidx/compose/ui/modifier/ProvidableModifierLocal;", "newestDispatchedRequest", "Lkotlin/Pair;", "Landroidx/compose/ui/geometry/Rect;", "Lkotlinx/coroutines/Job;", "newestReceivedRequest", "responder", "Landroidx/compose/foundation/relocation/BringIntoViewResponder;", "getResponder", "()Landroidx/compose/foundation/relocation/BringIntoViewResponder;", "setResponder", "(Landroidx/compose/foundation/relocation/BringIntoViewResponder;)V", "value", "getValue", "()Landroidx/compose/foundation/relocation/BringIntoViewParent;", "bringChildIntoView", "", "rect", "childCoordinates", "Landroidx/compose/ui/layout/LayoutCoordinates;", "(Landroidx/compose/ui/geometry/Rect;Landroidx/compose/ui/layout/LayoutCoordinates;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "dispatchRequest", "request", "layoutCoordinates", "(Lkotlin/Pair;Landroidx/compose/ui/layout/LayoutCoordinates;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "foundation_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
final class BringIntoViewResponderModifier extends BringIntoViewChildModifier implements ModifierLocalProvider<BringIntoViewParent>, BringIntoViewParent {
    private Pair<Rect, ? extends Job> newestDispatchedRequest;
    private Pair<Rect, ? extends Job> newestReceivedRequest;
    public BringIntoViewResponder responder;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BringIntoViewResponderModifier(BringIntoViewParent defaultParent) {
        super(defaultParent);
        Intrinsics.checkNotNullParameter(defaultParent, "defaultParent");
    }

    public final BringIntoViewResponder getResponder() {
        BringIntoViewResponder bringIntoViewResponder = this.responder;
        if (bringIntoViewResponder != null) {
            return bringIntoViewResponder;
        }
        Intrinsics.throwUninitializedPropertyAccessException("responder");
        return null;
    }

    public final void setResponder(BringIntoViewResponder bringIntoViewResponder) {
        Intrinsics.checkNotNullParameter(bringIntoViewResponder, "<set-?>");
        this.responder = bringIntoViewResponder;
    }

    @Override // androidx.compose.ui.modifier.ModifierLocalProvider
    public ProvidableModifierLocal<BringIntoViewParent> getKey() {
        return BringIntoViewKt.getModifierLocalBringIntoViewParent();
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // androidx.compose.ui.modifier.ModifierLocalProvider
    public BringIntoViewParent getValue() {
        return this;
    }

    /* JADX INFO: renamed from: androidx.compose.foundation.relocation.BringIntoViewResponderModifier$bringChildIntoView$2, reason: invalid class name */
    /* JADX INFO: compiled from: BringIntoViewResponder.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 6, 0}, xi = 48)
    @DebugMetadata(c = "androidx.compose.foundation.relocation.BringIntoViewResponderModifier$bringChildIntoView$2", f = "BringIntoViewResponder.kt", i = {0, 1, 1, 1, 2}, l = {Sdk.SDKError.Reason.INVALID_GZIP_BID_PAYLOAD_VALUE, Sdk.SDKError.Reason.STALE_CACHED_RESPONSE_VALUE, 230}, m = "invokeSuspend", n = {"thisRequest", "layoutCoordinates", "thisRequest", "previousRequest", "thisRequest"}, s = {"L$0", "L$0", "L$1", "L$2", "L$0"})
    static final class AnonymousClass2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ LayoutCoordinates $childCoordinates;
        final /* synthetic */ Rect $rect;
        private /* synthetic */ Object L$0;
        Object L$1;
        Object L$2;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass2(LayoutCoordinates layoutCoordinates, Rect rect, Continuation<? super AnonymousClass2> continuation) {
            super(2, continuation);
            this.$childCoordinates = layoutCoordinates;
            this.$rect = rect;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            AnonymousClass2 anonymousClass2 = BringIntoViewResponderModifier.this.new AnonymousClass2(this.$childCoordinates, this.$rect, continuation);
            anonymousClass2.L$0 = obj;
            return anonymousClass2;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Code duplicated, block: B:41:0x00b3 A[Catch: all -> 0x0034, TRY_LEAVE, TryCatch #2 {all -> 0x0034, blocks: (B:13:0x002f, B:39:0x00ab, B:41:0x00b3), top: B:77:0x002f }] */
        /* JADX WARN: Code duplicated, block: B:43:0x00c6 A[RETURN] */
        /* JADX WARN: Code duplicated, block: B:44:0x00c7  */
        /* JADX WARN: Code duplicated, block: B:61:0x010d  */
        /* JADX WARN: Code duplicated, block: B:64:0x011a  */
        /* JADX WARN: Code duplicated, block: B:70:0x0130  */
        /* JADX WARN: Code duplicated, block: B:73:0x013d  */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            LayoutCoordinates layoutCoordinates;
            Pair pair;
            Pair pair2;
            Pair pair3;
            Pair pair4;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            try {
                if (i == 0) {
                    ResultKt.throwOnFailure(obj);
                    CoroutineScope coroutineScope = (CoroutineScope) this.L$0;
                    LayoutCoordinates layoutCoordinates2 = BringIntoViewResponderModifier.this.getLayoutCoordinates();
                    if (layoutCoordinates2 != null && this.$childCoordinates.isAttached()) {
                        Rect rectLocalRectOf = BringIntoViewResponderKt.localRectOf(layoutCoordinates2, this.$childCoordinates, this.$rect);
                        Pair pair5 = new Pair(rectLocalRectOf, JobKt.getJob(coroutineScope.getCoroutineContext()));
                        Pair pair6 = BringIntoViewResponderModifier.this.newestReceivedRequest;
                        BringIntoViewResponderModifier.this.newestReceivedRequest = pair5;
                        if (pair6 != null) {
                            try {
                                if (BringIntoViewResponderKt.completelyOverlaps((Rect) pair6.getFirst(), rectLocalRectOf)) {
                                    this.L$0 = layoutCoordinates2;
                                    this.L$1 = pair5;
                                    this.L$2 = pair6;
                                    this.label = 2;
                                    if (((Job) pair6.getSecond()).join(this) == coroutine_suspended) {
                                        return coroutine_suspended;
                                    }
                                    layoutCoordinates = layoutCoordinates2;
                                    pair = pair5;
                                    pair2 = pair6;
                                    if (BringIntoViewResponderModifier.this.newestDispatchedRequest == pair2) {
                                        this.L$0 = pair;
                                        this.L$1 = null;
                                        this.L$2 = null;
                                        this.label = 3;
                                        if (BringIntoViewResponderModifier.this.dispatchRequest(pair, layoutCoordinates, this) == coroutine_suspended) {
                                            return coroutine_suspended;
                                        }
                                        pair4 = pair;
                                        pair = pair4;
                                    }
                                }
                            } catch (Throwable th) {
                                th = th;
                                coroutine_suspended = pair5;
                                if (BringIntoViewResponderModifier.this.newestDispatchedRequest == BringIntoViewResponderModifier.this.newestReceivedRequest) {
                                    BringIntoViewResponderModifier.this.newestDispatchedRequest = null;
                                }
                                if (BringIntoViewResponderModifier.this.newestReceivedRequest == coroutine_suspended) {
                                    BringIntoViewResponderModifier.this.newestReceivedRequest = null;
                                }
                                throw th;
                            }
                        }
                        this.L$0 = pair5;
                        this.label = 1;
                        if (BringIntoViewResponderModifier.this.dispatchRequest(pair5, layoutCoordinates2, this) == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        pair3 = pair5;
                        Unit unit = Unit.INSTANCE;
                        if (BringIntoViewResponderModifier.this.newestDispatchedRequest == BringIntoViewResponderModifier.this.newestReceivedRequest) {
                            BringIntoViewResponderModifier.this.newestDispatchedRequest = null;
                        }
                        if (BringIntoViewResponderModifier.this.newestReceivedRequest == pair3) {
                            BringIntoViewResponderModifier.this.newestReceivedRequest = null;
                        }
                        return unit;
                    }
                    return Unit.INSTANCE;
                }
                if (i == 1) {
                    pair3 = (Pair) this.L$0;
                    ResultKt.throwOnFailure(obj);
                    Unit unit2 = Unit.INSTANCE;
                    if (BringIntoViewResponderModifier.this.newestDispatchedRequest == BringIntoViewResponderModifier.this.newestReceivedRequest) {
                        BringIntoViewResponderModifier.this.newestDispatchedRequest = null;
                    }
                    if (BringIntoViewResponderModifier.this.newestReceivedRequest == pair3) {
                        BringIntoViewResponderModifier.this.newestReceivedRequest = null;
                    }
                    return unit2;
                }
                if (i == 2) {
                    pair2 = (Pair) this.L$2;
                    pair = (Pair) this.L$1;
                    layoutCoordinates = (LayoutCoordinates) this.L$0;
                    try {
                        ResultKt.throwOnFailure(obj);
                        if (BringIntoViewResponderModifier.this.newestDispatchedRequest == pair2) {
                            this.L$0 = pair;
                            this.L$1 = null;
                            this.L$2 = null;
                            this.label = 3;
                            if (BringIntoViewResponderModifier.this.dispatchRequest(pair, layoutCoordinates, this) == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                            pair4 = pair;
                        }
                    } catch (Throwable th2) {
                        th = th2;
                        coroutine_suspended = pair;
                        if (BringIntoViewResponderModifier.this.newestDispatchedRequest == BringIntoViewResponderModifier.this.newestReceivedRequest) {
                            BringIntoViewResponderModifier.this.newestDispatchedRequest = null;
                        }
                        if (BringIntoViewResponderModifier.this.newestReceivedRequest == coroutine_suspended) {
                            BringIntoViewResponderModifier.this.newestReceivedRequest = null;
                        }
                        throw th;
                    }
                } else {
                    if (i != 3) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    pair4 = (Pair) this.L$0;
                    ResultKt.throwOnFailure(obj);
                }
                pair = pair4;
                if (BringIntoViewResponderModifier.this.newestDispatchedRequest == BringIntoViewResponderModifier.this.newestReceivedRequest) {
                    BringIntoViewResponderModifier.this.newestDispatchedRequest = null;
                }
                if (BringIntoViewResponderModifier.this.newestReceivedRequest == pair) {
                    BringIntoViewResponderModifier.this.newestReceivedRequest = null;
                }
                return Unit.INSTANCE;
            } catch (Throwable th3) {
                th = th3;
            }
        }
    }

    @Override // androidx.compose.foundation.relocation.BringIntoViewParent
    public Object bringChildIntoView(Rect rect, LayoutCoordinates layoutCoordinates, Continuation<? super Unit> continuation) {
        Object objCoroutineScope = CoroutineScopeKt.coroutineScope(new AnonymousClass2(layoutCoordinates, rect, null), continuation);
        return objCoroutineScope == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objCoroutineScope : Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object dispatchRequest(Pair<Rect, ? extends Job> pair, LayoutCoordinates layoutCoordinates, Continuation<? super Unit> continuation) {
        this.newestDispatchedRequest = pair;
        Rect first = pair.getFirst();
        Object objCoroutineScope = CoroutineScopeKt.coroutineScope(new C10282(getResponder().calculateRectForParent(first), layoutCoordinates, first, null), continuation);
        return objCoroutineScope == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objCoroutineScope : Unit.INSTANCE;
    }

    /* JADX INFO: renamed from: androidx.compose.foundation.relocation.BringIntoViewResponderModifier$dispatchRequest$2, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: BringIntoViewResponder.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 6, 0}, xi = 48)
    @DebugMetadata(c = "androidx.compose.foundation.relocation.BringIntoViewResponderModifier$dispatchRequest$2", f = "BringIntoViewResponder.kt", i = {}, l = {272}, m = "invokeSuspend", n = {}, s = {})
    static final class C10282 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ LayoutCoordinates $layoutCoordinates;
        final /* synthetic */ Rect $localRect;
        final /* synthetic */ Rect $parentRect;
        private /* synthetic */ Object L$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C10282(Rect rect, LayoutCoordinates layoutCoordinates, Rect rect2, Continuation<? super C10282> continuation) {
            super(2, continuation);
            this.$parentRect = rect;
            this.$layoutCoordinates = layoutCoordinates;
            this.$localRect = rect2;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            C10282 c10282 = BringIntoViewResponderModifier.this.new C10282(this.$parentRect, this.$layoutCoordinates, this.$localRect, continuation);
            c10282.L$0 = obj;
            return c10282;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C10282) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                BuildersKt__Builders_commonKt.launch$default((CoroutineScope) this.L$0, null, null, new AnonymousClass1(BringIntoViewResponderModifier.this, this.$localRect, null), 3, null);
                this.label = 1;
                if (BringIntoViewResponderModifier.this.getParent().bringChildIntoView(this.$parentRect, this.$layoutCoordinates, this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            }
            return Unit.INSTANCE;
        }

        /* JADX INFO: renamed from: androidx.compose.foundation.relocation.BringIntoViewResponderModifier$dispatchRequest$2$1, reason: invalid class name */
        /* JADX INFO: compiled from: BringIntoViewResponder.kt */
        @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 6, 0}, xi = 48)
        @DebugMetadata(c = "androidx.compose.foundation.relocation.BringIntoViewResponderModifier$dispatchRequest$2$1", f = "BringIntoViewResponder.kt", i = {}, l = {267}, m = "invokeSuspend", n = {}, s = {})
        static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
            final /* synthetic */ Rect $localRect;
            int label;
            final /* synthetic */ BringIntoViewResponderModifier this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            AnonymousClass1(BringIntoViewResponderModifier bringIntoViewResponderModifier, Rect rect, Continuation<? super AnonymousClass1> continuation) {
                super(2, continuation);
                this.this$0 = bringIntoViewResponderModifier;
                this.$localRect = rect;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                return new AnonymousClass1(this.this$0, this.$localRect, continuation);
            }

            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
                return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object obj) throws Throwable {
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                int i = this.label;
                if (i == 0) {
                    ResultKt.throwOnFailure(obj);
                    this.label = 1;
                    if (this.this$0.getResponder().bringChildIntoView(this.$localRect, this) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                } else {
                    if (i != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    ResultKt.throwOnFailure(obj);
                }
                return Unit.INSTANCE;
            }
        }
    }
}
