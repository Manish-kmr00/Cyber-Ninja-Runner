package androidx.compose.foundation.gestures;

import androidx.compose.foundation.interaction.DragInteraction;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.runtime.MutableState;
import androidx.compose.ui.geometry.Offset;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: compiled from: Draggable.kt */
/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0002\u0018\u00002\u00020\u0001B¡\u0001\u0012<\u0010\u0002\u001a8\b\u0001\u0012\u0004\u0012\u00020\u0004\u0012\u0013\u0012\u00110\u0005¢\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\b\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\t\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0003¢\u0006\u0002\b\u000b\u0012<\u0010\f\u001a8\b\u0001\u0012\u0004\u0012\u00020\u0004\u0012\u0013\u0012\u00110\r¢\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\t\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0003¢\u0006\u0002\b\u000b\u0012\u000e\u0010\u000f\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00110\u0010\u0012\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013ø\u0001\u0000ø\u0001\u0000¢\u0006\u0002\u0010\u0014J\u0015\u0010\u001d\u001a\u00020\n*\u00020\u0004H\u0086@ø\u0001\u0000¢\u0006\u0002\u0010\u001eJ\u001d\u0010\u001f\u001a\u00020\n*\u00020\u00042\u0006\u0010 \u001a\u00020!H\u0086@ø\u0001\u0000¢\u0006\u0002\u0010\"J\u001d\u0010#\u001a\u00020\n*\u00020\u00042\u0006\u0010 \u001a\u00020$H\u0086@ø\u0001\u0000¢\u0006\u0002\u0010%R\u0019\u0010\u000f\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00110\u0010¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0013\u0010\u0012\u001a\u0004\u0018\u00010\u0013¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018RO\u0010\u0002\u001a8\b\u0001\u0012\u0004\u0012\u00020\u0004\u0012\u0013\u0012\u00110\u0005¢\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\b\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\t\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0003¢\u0006\u0002\b\u000bø\u0001\u0000ø\u0001\u0000¢\u0006\n\n\u0002\u0010\u001b\u001a\u0004\b\u0019\u0010\u001aRL\u0010\f\u001a8\b\u0001\u0012\u0004\u0012\u00020\u0004\u0012\u0013\u0012\u00110\r¢\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\t\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0003¢\u0006\u0002\b\u000bø\u0001\u0000¢\u0006\n\n\u0002\u0010\u001b\u001a\u0004\b\u001c\u0010\u001a\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006&"}, d2 = {"Landroidx/compose/foundation/gestures/DragLogic;", "", "onDragStarted", "Lkotlin/Function3;", "Lkotlinx/coroutines/CoroutineScope;", "Landroidx/compose/ui/geometry/Offset;", "Lkotlin/ParameterName;", "name", "startedPosition", "Lkotlin/coroutines/Continuation;", "", "Lkotlin/ExtensionFunctionType;", "onDragStopped", "", "velocity", "dragStartInteraction", "Landroidx/compose/runtime/MutableState;", "Landroidx/compose/foundation/interaction/DragInteraction$Start;", "interactionSource", "Landroidx/compose/foundation/interaction/MutableInteractionSource;", "(Lkotlin/jvm/functions/Function3;Lkotlin/jvm/functions/Function3;Landroidx/compose/runtime/MutableState;Landroidx/compose/foundation/interaction/MutableInteractionSource;)V", "getDragStartInteraction", "()Landroidx/compose/runtime/MutableState;", "getInteractionSource", "()Landroidx/compose/foundation/interaction/MutableInteractionSource;", "getOnDragStarted", "()Lkotlin/jvm/functions/Function3;", "Lkotlin/jvm/functions/Function3;", "getOnDragStopped", "processDragCancel", "(Lkotlinx/coroutines/CoroutineScope;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "processDragStart", "event", "Landroidx/compose/foundation/gestures/DragEvent$DragStarted;", "(Lkotlinx/coroutines/CoroutineScope;Landroidx/compose/foundation/gestures/DragEvent$DragStarted;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "processDragStop", "Landroidx/compose/foundation/gestures/DragEvent$DragStopped;", "(Lkotlinx/coroutines/CoroutineScope;Landroidx/compose/foundation/gestures/DragEvent$DragStopped;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "foundation_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
final class DragLogic {
    private final MutableState<DragInteraction.Start> dragStartInteraction;
    private final MutableInteractionSource interactionSource;
    private final Function3<CoroutineScope, Offset, Continuation<? super Unit>, Object> onDragStarted;
    private final Function3<CoroutineScope, Float, Continuation<? super Unit>, Object> onDragStopped;

    /* JADX INFO: renamed from: androidx.compose.foundation.gestures.DragLogic$processDragCancel$1, reason: invalid class name */
    /* JADX INFO: compiled from: Draggable.kt */
    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    @DebugMetadata(c = "androidx.compose.foundation.gestures.DragLogic", f = "Draggable.kt", i = {0, 0}, l = {408, 411}, m = "processDragCancel", n = {"this", "$this$processDragCancel"}, s = {"L$0", "L$1"})
    static final class AnonymousClass1 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        int label;
        /* synthetic */ Object result;

        AnonymousClass1(Continuation<? super AnonymousClass1> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return DragLogic.this.processDragCancel(null, this);
        }
    }

    /* JADX INFO: renamed from: androidx.compose.foundation.gestures.DragLogic$processDragStart$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: Draggable.kt */
    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    @DebugMetadata(c = "androidx.compose.foundation.gestures.DragLogic", f = "Draggable.kt", i = {0, 0, 0, 1, 1, 1, 1}, l = {390, 393, 395}, m = "processDragStart", n = {"this", "$this$processDragStart", "event", "this", "$this$processDragStart", "event", "interaction"}, s = {"L$0", "L$1", "L$2", "L$0", "L$1", "L$2", "L$3"})
    static final class C09721 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        int label;
        /* synthetic */ Object result;

        C09721(Continuation<? super C09721> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return DragLogic.this.processDragStart(null, null, this);
        }
    }

    /* JADX INFO: renamed from: androidx.compose.foundation.gestures.DragLogic$processDragStop$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: Draggable.kt */
    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    @DebugMetadata(c = "androidx.compose.foundation.gestures.DragLogic", f = "Draggable.kt", i = {0, 0, 0}, l = {400, 403}, m = "processDragStop", n = {"this", "$this$processDragStop", "event"}, s = {"L$0", "L$1", "L$2"})
    static final class C09731 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        Object L$2;
        int label;
        /* synthetic */ Object result;

        C09731(Continuation<? super C09731> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return DragLogic.this.processDragStop(null, null, this);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public DragLogic(Function3<? super CoroutineScope, ? super Offset, ? super Continuation<? super Unit>, ? extends Object> onDragStarted, Function3<? super CoroutineScope, ? super Float, ? super Continuation<? super Unit>, ? extends Object> onDragStopped, MutableState<DragInteraction.Start> dragStartInteraction, MutableInteractionSource mutableInteractionSource) {
        Intrinsics.checkNotNullParameter(onDragStarted, "onDragStarted");
        Intrinsics.checkNotNullParameter(onDragStopped, "onDragStopped");
        Intrinsics.checkNotNullParameter(dragStartInteraction, "dragStartInteraction");
        this.onDragStarted = onDragStarted;
        this.onDragStopped = onDragStopped;
        this.dragStartInteraction = dragStartInteraction;
        this.interactionSource = mutableInteractionSource;
    }

    public final Function3<CoroutineScope, Offset, Continuation<? super Unit>, Object> getOnDragStarted() {
        return this.onDragStarted;
    }

    public final Function3<CoroutineScope, Float, Continuation<? super Unit>, Object> getOnDragStopped() {
        return this.onDragStopped;
    }

    public final MutableState<DragInteraction.Start> getDragStartInteraction() {
        return this.dragStartInteraction;
    }

    public final MutableInteractionSource getInteractionSource() {
        return this.interactionSource;
    }

    /* JADX WARN: Code duplicated, block: B:35:0x00cb A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    public final Object processDragStart(CoroutineScope coroutineScope, DragEvent.DragStarted dragStarted, Continuation<? super Unit> continuation) throws Throwable {
        C09721 c09721;
        DragLogic dragLogic;
        MutableInteractionSource mutableInteractionSource;
        DragInteraction.Start start;
        DragLogic dragLogic2;
        CoroutineScope coroutineScope2;
        DragInteraction.Start start2;
        Function3<CoroutineScope, Offset, Continuation<? super Unit>, Object> function3;
        Offset offsetM1384boximpl;
        if (continuation instanceof C09721) {
            c09721 = (C09721) continuation;
            if ((c09721.label & Integer.MIN_VALUE) != 0) {
                c09721.label -= Integer.MIN_VALUE;
            } else {
                c09721 = new C09721(continuation);
            }
        } else {
            c09721 = new C09721(continuation);
        }
        Object obj = c09721.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = c09721.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            DragInteraction.Start value = this.dragStartInteraction.getValue();
            if (value != null && (mutableInteractionSource = this.interactionSource) != null) {
                DragInteraction.Cancel cancel = new DragInteraction.Cancel(value);
                c09721.L$0 = this;
                c09721.L$1 = coroutineScope;
                c09721.L$2 = dragStarted;
                c09721.label = 1;
                if (mutableInteractionSource.emit(cancel, c09721) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            }
            dragLogic = this;
        } else {
            if (i == 1) {
                DragEvent.DragStarted dragStarted2 = (DragEvent.DragStarted) c09721.L$2;
                CoroutineScope coroutineScope3 = (CoroutineScope) c09721.L$1;
                dragLogic = (DragLogic) c09721.L$0;
                ResultKt.throwOnFailure(obj);
                dragStarted = dragStarted2;
                coroutineScope = coroutineScope3;
            } else if (i == 2) {
                start2 = (DragInteraction.Start) c09721.L$3;
                dragStarted = (DragEvent.DragStarted) c09721.L$2;
                coroutineScope2 = (CoroutineScope) c09721.L$1;
                dragLogic2 = (DragLogic) c09721.L$0;
                ResultKt.throwOnFailure(obj);
                start = start2;
                coroutineScope = coroutineScope2;
                dragLogic = dragLogic2;
                dragLogic.dragStartInteraction.setValue(start);
                function3 = dragLogic.onDragStarted;
                offsetM1384boximpl = Offset.m1384boximpl(dragStarted.getStartPoint());
                c09721.L$0 = null;
                c09721.L$1 = null;
                c09721.L$2 = null;
                c09721.L$3 = null;
                c09721.label = 3;
                if (function3.invoke(coroutineScope, offsetM1384boximpl, c09721) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 3) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            }
            return Unit.INSTANCE;
        }
        start = new DragInteraction.Start();
        MutableInteractionSource mutableInteractionSource2 = dragLogic.interactionSource;
        if (mutableInteractionSource2 != null) {
            c09721.L$0 = dragLogic;
            c09721.L$1 = coroutineScope;
            c09721.L$2 = dragStarted;
            c09721.L$3 = start;
            c09721.label = 2;
            if (mutableInteractionSource2.emit(start, c09721) == coroutine_suspended) {
                return coroutine_suspended;
            }
            dragLogic2 = dragLogic;
            coroutineScope2 = coroutineScope;
            start2 = start;
            start = start2;
            coroutineScope = coroutineScope2;
            dragLogic = dragLogic2;
        }
        dragLogic.dragStartInteraction.setValue(start);
        function3 = dragLogic.onDragStarted;
        offsetM1384boximpl = Offset.m1384boximpl(dragStarted.getStartPoint());
        c09721.L$0 = null;
        c09721.L$1 = null;
        c09721.L$2 = null;
        c09721.L$3 = null;
        c09721.label = 3;
        if (function3.invoke(coroutineScope, offsetM1384boximpl, c09721) == coroutine_suspended) {
            return coroutine_suspended;
        }
        return Unit.INSTANCE;
    }

    /* JADX WARN: Code duplicated, block: B:28:0x0090 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    public final Object processDragStop(CoroutineScope coroutineScope, DragEvent.DragStopped dragStopped, Continuation<? super Unit> continuation) throws Throwable {
        C09731 c09731;
        DragLogic dragLogic;
        Function3<CoroutineScope, Float, Continuation<? super Unit>, Object> function3;
        Float fBoxFloat;
        if (continuation instanceof C09731) {
            c09731 = (C09731) continuation;
            if ((c09731.label & Integer.MIN_VALUE) != 0) {
                c09731.label -= Integer.MIN_VALUE;
            } else {
                c09731 = new C09731(continuation);
            }
        } else {
            c09731 = new C09731(continuation);
        }
        Object obj = c09731.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = c09731.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            DragInteraction.Start value = this.dragStartInteraction.getValue();
            if (value != null) {
                MutableInteractionSource mutableInteractionSource = this.interactionSource;
                if (mutableInteractionSource != null) {
                    DragInteraction.Stop stop = new DragInteraction.Stop(value);
                    c09731.L$0 = this;
                    c09731.L$1 = coroutineScope;
                    c09731.L$2 = dragStopped;
                    c09731.label = 1;
                    if (mutableInteractionSource.emit(stop, c09731) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                }
                dragLogic = this;
            } else {
                dragLogic = this;
            }
            function3 = dragLogic.onDragStopped;
            fBoxFloat = Boxing.boxFloat(dragStopped.getVelocity());
            c09731.L$0 = null;
            c09731.L$1 = null;
            c09731.L$2 = null;
            c09731.label = 2;
            if (function3.invoke(coroutineScope, fBoxFloat, c09731) == coroutine_suspended) {
                return coroutine_suspended;
            }
            return Unit.INSTANCE;
        }
        if (i == 1) {
            DragEvent.DragStopped dragStopped2 = (DragEvent.DragStopped) c09731.L$2;
            CoroutineScope coroutineScope2 = (CoroutineScope) c09731.L$1;
            dragLogic = (DragLogic) c09731.L$0;
            ResultKt.throwOnFailure(obj);
            dragStopped = dragStopped2;
            coroutineScope = coroutineScope2;
        } else {
            if (i != 2) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
        }
        return Unit.INSTANCE;
        dragLogic.dragStartInteraction.setValue(null);
        function3 = dragLogic.onDragStopped;
        fBoxFloat = Boxing.boxFloat(dragStopped.getVelocity());
        c09731.L$0 = null;
        c09731.L$1 = null;
        c09731.L$2 = null;
        c09731.label = 2;
        if (function3.invoke(coroutineScope, fBoxFloat, c09731) == coroutine_suspended) {
            return coroutine_suspended;
        }
        return Unit.INSTANCE;
    }

    /* JADX WARN: Code duplicated, block: B:28:0x0082 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    public final Object processDragCancel(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) throws Throwable {
        AnonymousClass1 anonymousClass1;
        DragLogic dragLogic;
        Function3<CoroutineScope, Float, Continuation<? super Unit>, Object> function3;
        Float fBoxFloat;
        if (continuation instanceof AnonymousClass1) {
            anonymousClass1 = (AnonymousClass1) continuation;
            if ((anonymousClass1.label & Integer.MIN_VALUE) != 0) {
                anonymousClass1.label -= Integer.MIN_VALUE;
            } else {
                anonymousClass1 = new AnonymousClass1(continuation);
            }
        } else {
            anonymousClass1 = new AnonymousClass1(continuation);
        }
        Object obj = anonymousClass1.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = anonymousClass1.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            DragInteraction.Start value = this.dragStartInteraction.getValue();
            if (value != null) {
                MutableInteractionSource mutableInteractionSource = this.interactionSource;
                if (mutableInteractionSource != null) {
                    DragInteraction.Cancel cancel = new DragInteraction.Cancel(value);
                    anonymousClass1.L$0 = this;
                    anonymousClass1.L$1 = coroutineScope;
                    anonymousClass1.label = 1;
                    if (mutableInteractionSource.emit(cancel, anonymousClass1) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                }
                dragLogic = this;
            } else {
                dragLogic = this;
            }
            function3 = dragLogic.onDragStopped;
            fBoxFloat = Boxing.boxFloat(0.0f);
            anonymousClass1.L$0 = null;
            anonymousClass1.L$1 = null;
            anonymousClass1.label = 2;
            if (function3.invoke(coroutineScope, fBoxFloat, anonymousClass1) == coroutine_suspended) {
                return coroutine_suspended;
            }
            return Unit.INSTANCE;
        }
        if (i == 1) {
            coroutineScope = (CoroutineScope) anonymousClass1.L$1;
            dragLogic = (DragLogic) anonymousClass1.L$0;
            ResultKt.throwOnFailure(obj);
        } else {
            if (i != 2) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
        }
        return Unit.INSTANCE;
        dragLogic.dragStartInteraction.setValue(null);
        function3 = dragLogic.onDragStopped;
        fBoxFloat = Boxing.boxFloat(0.0f);
        anonymousClass1.L$0 = null;
        anonymousClass1.L$1 = null;
        anonymousClass1.label = 2;
        if (function3.invoke(coroutineScope, fBoxFloat, anonymousClass1) == coroutine_suspended) {
            return coroutine_suspended;
        }
        return Unit.INSTANCE;
    }
}
