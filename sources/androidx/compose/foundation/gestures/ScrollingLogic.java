package androidx.compose.foundation.gestures;

import androidx.compose.foundation.OverscrollEffect;
import androidx.compose.runtime.State;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.OffsetKt;
import androidx.compose.ui.input.nestedscroll.NestedScrollDispatcher;
import androidx.compose.ui.unit.Velocity;
import androidx.compose.ui.unit.VelocityKt;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;

/* JADX INFO: compiled from: Scrollable.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0012\b\u0002\u0018\u00002\u00020\u0001B=\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007\u0012\u0006\u0010\t\u001a\u00020\n\u0012\u0006\u0010\u000b\u001a\u00020\f\u0012\b\u0010\r\u001a\u0004\u0018\u00010\u000e¢\u0006\u0002\u0010\u000fJ!\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u001dH\u0086@ø\u0001\u0000ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u001f\u0010 J\u0019\u0010!\u001a\u00020\"2\u0006\u0010#\u001a\u00020$H\u0086@ø\u0001\u0000¢\u0006\u0002\u0010%J\u001b\u0010&\u001a\u00020'2\u0006\u0010(\u001a\u00020'ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b)\u0010*J\u0006\u0010+\u001a\u00020\u0005J1\u0010,\u001a\u00020'*\u00020-2\u0006\u0010.\u001a\u00020'2\b\u0010/\u001a\u0004\u0018\u00010'2\u0006\u00100\u001a\u000201ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b2\u00103J\u0017\u00104\u001a\u00020'*\u00020'ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b5\u0010*J\n\u00104\u001a\u00020$*\u00020$J\u0017\u00106\u001a\u00020$*\u00020'ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b7\u00108J\u0017\u00106\u001a\u00020$*\u00020\u001dø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b9\u00108J\u001a\u0010:\u001a\u00020'*\u00020$ø\u0001\u0000ø\u0001\u0002ø\u0001\u0001¢\u0006\u0004\b;\u0010<J\u001a\u0010=\u001a\u00020\u001d*\u00020$ø\u0001\u0000ø\u0001\u0002ø\u0001\u0001¢\u0006\u0004\b>\u0010<J\u001f\u0010?\u001a\u00020\u001d*\u00020\u001d2\u0006\u0010@\u001a\u00020$ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\bA\u0010BR\u0011\u0010\u000b\u001a\u00020\f¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0017\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0013\u0010\r\u001a\u0004\u0018\u00010\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019R\u0011\u0010\t\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u001b\u0082\u0002\u000f\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006C"}, d2 = {"Landroidx/compose/foundation/gestures/ScrollingLogic;", "", "orientation", "Landroidx/compose/foundation/gestures/Orientation;", "reverseDirection", "", "nestedScrollDispatcher", "Landroidx/compose/runtime/State;", "Landroidx/compose/ui/input/nestedscroll/NestedScrollDispatcher;", "scrollableState", "Landroidx/compose/foundation/gestures/ScrollableState;", "flingBehavior", "Landroidx/compose/foundation/gestures/FlingBehavior;", "overscrollEffect", "Landroidx/compose/foundation/OverscrollEffect;", "(Landroidx/compose/foundation/gestures/Orientation;ZLandroidx/compose/runtime/State;Landroidx/compose/foundation/gestures/ScrollableState;Landroidx/compose/foundation/gestures/FlingBehavior;Landroidx/compose/foundation/OverscrollEffect;)V", "getFlingBehavior", "()Landroidx/compose/foundation/gestures/FlingBehavior;", "getNestedScrollDispatcher", "()Landroidx/compose/runtime/State;", "getOrientation", "()Landroidx/compose/foundation/gestures/Orientation;", "getOverscrollEffect", "()Landroidx/compose/foundation/OverscrollEffect;", "getReverseDirection", "()Z", "getScrollableState", "()Landroidx/compose/foundation/gestures/ScrollableState;", "doFlingAnimation", "Landroidx/compose/ui/unit/Velocity;", "available", "doFlingAnimation-QWom1Mo", "(JLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "onDragStopped", "", "axisVelocity", "", "(FLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "performRawScroll", "Landroidx/compose/ui/geometry/Offset;", "scroll", "performRawScroll-MK-Hz9U", "(J)J", "shouldScrollImmediately", "dispatchScroll", "Landroidx/compose/foundation/gestures/ScrollScope;", "scrollDelta", "pointerPosition", "source", "Landroidx/compose/ui/input/nestedscroll/NestedScrollSource;", "dispatchScroll-f0eR0lY", "(Landroidx/compose/foundation/gestures/ScrollScope;JLandroidx/compose/ui/geometry/Offset;I)J", "reverseIfNeeded", "reverseIfNeeded-MK-Hz9U", "toFloat", "toFloat-k-4lQ0M", "(J)F", "toFloat-TH1AsA0", "toOffset", "toOffset-tuRUvjQ", "(F)J", "toVelocity", "toVelocity-adjELrA", "update", "newValue", "update-QWom1Mo", "(JF)J", "foundation_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
final class ScrollingLogic {
    private final FlingBehavior flingBehavior;
    private final State<NestedScrollDispatcher> nestedScrollDispatcher;
    private final Orientation orientation;
    private final OverscrollEffect overscrollEffect;
    private final boolean reverseDirection;
    private final ScrollableState scrollableState;

    /* JADX INFO: renamed from: androidx.compose.foundation.gestures.ScrollingLogic$onDragStopped$1, reason: invalid class name */
    /* JADX INFO: compiled from: Scrollable.kt */
    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    @DebugMetadata(c = "androidx.compose.foundation.gestures.ScrollingLogic", f = "Scrollable.kt", i = {0, 0, 1, 1, 2, 2, 3, 3}, l = {378, 383, 385, 387, 393}, m = "onDragStopped", n = {"this", "axisVelocity", "this", "velocity", "this", "available", "this", "velocityLeft"}, s = {"L$0", "F$0", "L$0", "J$0", "L$0", "J$0", "L$0", "J$0"})
    static final class AnonymousClass1 extends ContinuationImpl {
        float F$0;
        long J$0;
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
            return ScrollingLogic.this.onDragStopped(0.0f, this);
        }
    }

    public ScrollingLogic(Orientation orientation, boolean z, State<NestedScrollDispatcher> nestedScrollDispatcher, ScrollableState scrollableState, FlingBehavior flingBehavior, OverscrollEffect overscrollEffect) {
        Intrinsics.checkNotNullParameter(orientation, "orientation");
        Intrinsics.checkNotNullParameter(nestedScrollDispatcher, "nestedScrollDispatcher");
        Intrinsics.checkNotNullParameter(scrollableState, "scrollableState");
        Intrinsics.checkNotNullParameter(flingBehavior, "flingBehavior");
        this.orientation = orientation;
        this.reverseDirection = z;
        this.nestedScrollDispatcher = nestedScrollDispatcher;
        this.scrollableState = scrollableState;
        this.flingBehavior = flingBehavior;
        this.overscrollEffect = overscrollEffect;
    }

    public final Orientation getOrientation() {
        return this.orientation;
    }

    public final boolean getReverseDirection() {
        return this.reverseDirection;
    }

    public final State<NestedScrollDispatcher> getNestedScrollDispatcher() {
        return this.nestedScrollDispatcher;
    }

    public final ScrollableState getScrollableState() {
        return this.scrollableState;
    }

    public final FlingBehavior getFlingBehavior() {
        return this.flingBehavior;
    }

    public final OverscrollEffect getOverscrollEffect() {
        return this.overscrollEffect;
    }

    /* JADX INFO: renamed from: toOffset-tuRUvjQ, reason: not valid java name */
    public final long m331toOffsettuRUvjQ(float f) {
        if (f == 0.0f) {
            return Offset.INSTANCE.m1411getZeroF1C5BW0();
        }
        return this.orientation == Orientation.Horizontal ? OffsetKt.Offset(f, 0.0f) : OffsetKt.Offset(0.0f, f);
    }

    /* JADX INFO: renamed from: toVelocity-adjELrA, reason: not valid java name */
    public final long m332toVelocityadjELrA(float f) {
        return this.orientation == Orientation.Horizontal ? VelocityKt.Velocity(f, 0.0f) : VelocityKt.Velocity(0.0f, f);
    }

    /* JADX INFO: renamed from: toFloat-k-4lQ0M, reason: not valid java name */
    public final float m330toFloatk4lQ0M(long j) {
        return this.orientation == Orientation.Horizontal ? Offset.m1395getXimpl(j) : Offset.m1396getYimpl(j);
    }

    /* JADX INFO: renamed from: toFloat-TH1AsA0, reason: not valid java name */
    public final float m329toFloatTH1AsA0(long j) {
        return this.orientation == Orientation.Horizontal ? Velocity.m4068getXimpl(j) : Velocity.m4069getYimpl(j);
    }

    /* JADX INFO: renamed from: update-QWom1Mo, reason: not valid java name */
    public final long m333updateQWom1Mo(long j, float f) {
        return this.orientation == Orientation.Horizontal ? Velocity.m4064copyOhffZ5M$default(j, f, 0.0f, 2, null) : Velocity.m4064copyOhffZ5M$default(j, 0.0f, f, 1, null);
    }

    public final float reverseIfNeeded(float f) {
        return this.reverseDirection ? f * (-1) : f;
    }

    /* JADX INFO: renamed from: reverseIfNeeded-MK-Hz9U, reason: not valid java name */
    public final long m328reverseIfNeededMKHz9U(long j) {
        return this.reverseDirection ? Offset.m1402timestuRUvjQ(j, -1.0f) : j;
    }

    /* JADX INFO: renamed from: dispatchScroll-f0eR0lY, reason: not valid java name */
    public final long m325dispatchScrollf0eR0lY(ScrollScope dispatchScroll, long j, Offset offset, int i) {
        long jM1411getZeroF1C5BW0;
        Intrinsics.checkNotNullParameter(dispatchScroll, "$this$dispatchScroll");
        OverscrollEffect overscrollEffect = this.overscrollEffect;
        if (overscrollEffect != null && overscrollEffect.isEnabled()) {
            jM1411getZeroF1C5BW0 = this.overscrollEffect.mo171consumePreScrollA0NYTsA(j, offset, i);
        } else {
            jM1411getZeroF1C5BW0 = Offset.INSTANCE.m1411getZeroF1C5BW0();
        }
        long jM1399minusMKHz9U = Offset.m1399minusMKHz9U(j, jM1411getZeroF1C5BW0);
        NestedScrollDispatcher value = this.nestedScrollDispatcher.getValue();
        long jM1399minusMKHz9U2 = Offset.m1399minusMKHz9U(jM1399minusMKHz9U, value.m2889dispatchPreScrollOzD1aCk(jM1399minusMKHz9U, i));
        long jM328reverseIfNeededMKHz9U = m328reverseIfNeededMKHz9U(m331toOffsettuRUvjQ(dispatchScroll.scrollBy(m330toFloatk4lQ0M(m328reverseIfNeededMKHz9U(jM1399minusMKHz9U2)))));
        long jM1399minusMKHz9U3 = Offset.m1399minusMKHz9U(jM1399minusMKHz9U2, jM328reverseIfNeededMKHz9U);
        long jM2887dispatchPostScrollDzOQY0M = value.m2887dispatchPostScrollDzOQY0M(jM328reverseIfNeededMKHz9U, jM1399minusMKHz9U3, i);
        OverscrollEffect overscrollEffect2 = this.overscrollEffect;
        if (overscrollEffect2 != null && overscrollEffect2.isEnabled()) {
            this.overscrollEffect.mo169consumePostScrolll7mfB5k(jM1399minusMKHz9U2, Offset.m1399minusMKHz9U(jM1399minusMKHz9U3, jM2887dispatchPostScrollDzOQY0M), offset, i);
        }
        return jM1399minusMKHz9U3;
    }

    /* JADX INFO: renamed from: performRawScroll-MK-Hz9U, reason: not valid java name */
    public final long m327performRawScrollMKHz9U(long scroll) {
        if (this.scrollableState.isScrollInProgress()) {
            return Offset.INSTANCE.m1411getZeroF1C5BW0();
        }
        return m331toOffsettuRUvjQ(reverseIfNeeded(this.scrollableState.dispatchRawDelta(reverseIfNeeded(m330toFloatk4lQ0M(scroll)))));
    }

    /* JADX WARN: Code duplicated, block: B:34:0x00bf A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:35:0x00c0  */
    /* JADX WARN: Code duplicated, block: B:38:0x00d7 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:39:0x00d8  */
    /* JADX WARN: Code duplicated, block: B:42:0x00fb A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:43:0x00fc  */
    /* JADX WARN: Code duplicated, block: B:46:0x010b  */
    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    public final Object onDragStopped(float f, Continuation<? super Unit> continuation) throws Throwable {
        AnonymousClass1 anonymousClass1;
        float fM329toFloatTH1AsA0;
        float f2;
        ScrollingLogic scrollingLogic;
        ScrollingLogic scrollingLogic2;
        ScrollingLogic scrollingLogic3;
        long jM332toVelocityadjELrA;
        long j;
        long jM4071minusAH228Gc;
        long j2;
        long packedValue;
        long j3;
        OverscrollEffect overscrollEffect;
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
        Object objMo170consumePreFlingQWom1Mo = anonymousClass1.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = anonymousClass1.label;
        if (i == 0) {
            ResultKt.throwOnFailure(objMo170consumePreFlingQWom1Mo);
            OverscrollEffect overscrollEffect2 = this.overscrollEffect;
            if (overscrollEffect2 == null || !overscrollEffect2.isEnabled()) {
                fM329toFloatTH1AsA0 = 0.0f;
                f2 = f;
                scrollingLogic = this;
            } else {
                OverscrollEffect overscrollEffect3 = this.overscrollEffect;
                long jM332toVelocityadjELrA2 = m332toVelocityadjELrA(f);
                anonymousClass1.L$0 = this;
                anonymousClass1.L$1 = this;
                anonymousClass1.F$0 = f;
                anonymousClass1.label = 1;
                objMo170consumePreFlingQWom1Mo = overscrollEffect3.mo170consumePreFlingQWom1Mo(jM332toVelocityadjELrA2, anonymousClass1);
                if (objMo170consumePreFlingQWom1Mo == coroutine_suspended) {
                    return coroutine_suspended;
                }
                scrollingLogic2 = this;
                scrollingLogic3 = scrollingLogic2;
            }
            jM332toVelocityadjELrA = scrollingLogic.m332toVelocityadjELrA(f2 - fM329toFloatTH1AsA0);
            NestedScrollDispatcher value = scrollingLogic.nestedScrollDispatcher.getValue();
            anonymousClass1.L$0 = scrollingLogic;
            anonymousClass1.L$1 = null;
            anonymousClass1.J$0 = jM332toVelocityadjELrA;
            anonymousClass1.label = 2;
            objMo170consumePreFlingQWom1Mo = value.m2888dispatchPreFlingQWom1Mo(jM332toVelocityadjELrA, anonymousClass1);
            if (objMo170consumePreFlingQWom1Mo == coroutine_suspended) {
                return coroutine_suspended;
            }
            j = jM332toVelocityadjELrA;
            jM4071minusAH228Gc = Velocity.m4071minusAH228Gc(j, ((Velocity) objMo170consumePreFlingQWom1Mo).getPackedValue());
            anonymousClass1.L$0 = scrollingLogic;
            anonymousClass1.J$0 = jM4071minusAH228Gc;
            anonymousClass1.label = 3;
            objMo170consumePreFlingQWom1Mo = scrollingLogic.m326doFlingAnimationQWom1Mo(jM4071minusAH228Gc, anonymousClass1);
            if (objMo170consumePreFlingQWom1Mo == coroutine_suspended) {
                return coroutine_suspended;
            }
            j2 = jM4071minusAH228Gc;
            packedValue = ((Velocity) objMo170consumePreFlingQWom1Mo).getPackedValue();
            NestedScrollDispatcher value2 = scrollingLogic.nestedScrollDispatcher.getValue();
            long jM4071minusAH228Gc2 = Velocity.m4071minusAH228Gc(j2, packedValue);
            anonymousClass1.L$0 = scrollingLogic;
            anonymousClass1.J$0 = packedValue;
            anonymousClass1.label = 4;
            objMo170consumePreFlingQWom1Mo = value2.m2886dispatchPostFlingRZ2iAVY(jM4071minusAH228Gc2, packedValue, anonymousClass1);
            if (objMo170consumePreFlingQWom1Mo == coroutine_suspended) {
                return coroutine_suspended;
            }
            j3 = packedValue;
            long jM4071minusAH228Gc3 = Velocity.m4071minusAH228Gc(j3, ((Velocity) objMo170consumePreFlingQWom1Mo).getPackedValue());
            overscrollEffect = scrollingLogic.overscrollEffect;
            if (overscrollEffect != null) {
            }
            return Unit.INSTANCE;
        }
        if (i == 1) {
            f = anonymousClass1.F$0;
            scrollingLogic2 = (ScrollingLogic) anonymousClass1.L$1;
            scrollingLogic3 = (ScrollingLogic) anonymousClass1.L$0;
            ResultKt.throwOnFailure(objMo170consumePreFlingQWom1Mo);
        } else {
            if (i == 2) {
                j = anonymousClass1.J$0;
                scrollingLogic = (ScrollingLogic) anonymousClass1.L$0;
                ResultKt.throwOnFailure(objMo170consumePreFlingQWom1Mo);
                jM4071minusAH228Gc = Velocity.m4071minusAH228Gc(j, ((Velocity) objMo170consumePreFlingQWom1Mo).getPackedValue());
                anonymousClass1.L$0 = scrollingLogic;
                anonymousClass1.J$0 = jM4071minusAH228Gc;
                anonymousClass1.label = 3;
                objMo170consumePreFlingQWom1Mo = scrollingLogic.m326doFlingAnimationQWom1Mo(jM4071minusAH228Gc, anonymousClass1);
                if (objMo170consumePreFlingQWom1Mo == coroutine_suspended) {
                    return coroutine_suspended;
                }
                j2 = jM4071minusAH228Gc;
                packedValue = ((Velocity) objMo170consumePreFlingQWom1Mo).getPackedValue();
                NestedScrollDispatcher value3 = scrollingLogic.nestedScrollDispatcher.getValue();
                long jM4071minusAH228Gc4 = Velocity.m4071minusAH228Gc(j2, packedValue);
                anonymousClass1.L$0 = scrollingLogic;
                anonymousClass1.J$0 = packedValue;
                anonymousClass1.label = 4;
                objMo170consumePreFlingQWom1Mo = value3.m2886dispatchPostFlingRZ2iAVY(jM4071minusAH228Gc4, packedValue, anonymousClass1);
                if (objMo170consumePreFlingQWom1Mo == coroutine_suspended) {
                    return coroutine_suspended;
                }
                j3 = packedValue;
                long jM4071minusAH228Gc5 = Velocity.m4071minusAH228Gc(j3, ((Velocity) objMo170consumePreFlingQWom1Mo).getPackedValue());
                overscrollEffect = scrollingLogic.overscrollEffect;
                if (overscrollEffect != null) {
                }
                return Unit.INSTANCE;
            }
            if (i == 3) {
                j2 = anonymousClass1.J$0;
                scrollingLogic = (ScrollingLogic) anonymousClass1.L$0;
                ResultKt.throwOnFailure(objMo170consumePreFlingQWom1Mo);
                packedValue = ((Velocity) objMo170consumePreFlingQWom1Mo).getPackedValue();
                NestedScrollDispatcher value4 = scrollingLogic.nestedScrollDispatcher.getValue();
                long jM4071minusAH228Gc6 = Velocity.m4071minusAH228Gc(j2, packedValue);
                anonymousClass1.L$0 = scrollingLogic;
                anonymousClass1.J$0 = packedValue;
                anonymousClass1.label = 4;
                objMo170consumePreFlingQWom1Mo = value4.m2886dispatchPostFlingRZ2iAVY(jM4071minusAH228Gc6, packedValue, anonymousClass1);
                if (objMo170consumePreFlingQWom1Mo == coroutine_suspended) {
                    return coroutine_suspended;
                }
                j3 = packedValue;
                long jM4071minusAH228Gc7 = Velocity.m4071minusAH228Gc(j3, ((Velocity) objMo170consumePreFlingQWom1Mo).getPackedValue());
                overscrollEffect = scrollingLogic.overscrollEffect;
                if (overscrollEffect != null) {
                }
                return Unit.INSTANCE;
            }
            if (i == 4) {
                j3 = anonymousClass1.J$0;
                scrollingLogic = (ScrollingLogic) anonymousClass1.L$0;
                ResultKt.throwOnFailure(objMo170consumePreFlingQWom1Mo);
                long jM4071minusAH228Gc8 = Velocity.m4071minusAH228Gc(j3, ((Velocity) objMo170consumePreFlingQWom1Mo).getPackedValue());
                overscrollEffect = scrollingLogic.overscrollEffect;
                if (overscrollEffect != null || !overscrollEffect.isEnabled()) {
                    return Unit.INSTANCE;
                }
                OverscrollEffect overscrollEffect4 = scrollingLogic.overscrollEffect;
                long jM332toVelocityadjELrA3 = scrollingLogic.m332toVelocityadjELrA(scrollingLogic.m329toFloatTH1AsA0(jM4071minusAH228Gc8));
                anonymousClass1.L$0 = null;
                anonymousClass1.label = 5;
                if (overscrollEffect4.mo168consumePostFlingsFctU(jM332toVelocityadjELrA3, anonymousClass1) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 5) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(objMo170consumePreFlingQWom1Mo);
            }
        }
        return Unit.INSTANCE;
        fM329toFloatTH1AsA0 = scrollingLogic2.m329toFloatTH1AsA0(((Velocity) objMo170consumePreFlingQWom1Mo).getPackedValue());
        f2 = f;
        scrollingLogic = scrollingLogic3;
        jM332toVelocityadjELrA = scrollingLogic.m332toVelocityadjELrA(f2 - fM329toFloatTH1AsA0);
        NestedScrollDispatcher value5 = scrollingLogic.nestedScrollDispatcher.getValue();
        anonymousClass1.L$0 = scrollingLogic;
        anonymousClass1.L$1 = null;
        anonymousClass1.J$0 = jM332toVelocityadjELrA;
        anonymousClass1.label = 2;
        objMo170consumePreFlingQWom1Mo = value5.m2888dispatchPreFlingQWom1Mo(jM332toVelocityadjELrA, anonymousClass1);
        if (objMo170consumePreFlingQWom1Mo == coroutine_suspended) {
            return coroutine_suspended;
        }
        j = jM332toVelocityadjELrA;
        jM4071minusAH228Gc = Velocity.m4071minusAH228Gc(j, ((Velocity) objMo170consumePreFlingQWom1Mo).getPackedValue());
        anonymousClass1.L$0 = scrollingLogic;
        anonymousClass1.J$0 = jM4071minusAH228Gc;
        anonymousClass1.label = 3;
        objMo170consumePreFlingQWom1Mo = scrollingLogic.m326doFlingAnimationQWom1Mo(jM4071minusAH228Gc, anonymousClass1);
        if (objMo170consumePreFlingQWom1Mo == coroutine_suspended) {
            return coroutine_suspended;
        }
        j2 = jM4071minusAH228Gc;
        packedValue = ((Velocity) objMo170consumePreFlingQWom1Mo).getPackedValue();
        NestedScrollDispatcher value6 = scrollingLogic.nestedScrollDispatcher.getValue();
        long jM4071minusAH228Gc9 = Velocity.m4071minusAH228Gc(j2, packedValue);
        anonymousClass1.L$0 = scrollingLogic;
        anonymousClass1.J$0 = packedValue;
        anonymousClass1.label = 4;
        objMo170consumePreFlingQWom1Mo = value6.m2886dispatchPostFlingRZ2iAVY(jM4071minusAH228Gc9, packedValue, anonymousClass1);
        if (objMo170consumePreFlingQWom1Mo == coroutine_suspended) {
            return coroutine_suspended;
        }
        j3 = packedValue;
        long jM4071minusAH228Gc10 = Velocity.m4071minusAH228Gc(j3, ((Velocity) objMo170consumePreFlingQWom1Mo).getPackedValue());
        overscrollEffect = scrollingLogic.overscrollEffect;
        if (overscrollEffect != null) {
        }
        return Unit.INSTANCE;
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    /* JADX INFO: renamed from: doFlingAnimation-QWom1Mo, reason: not valid java name */
    public final Object m326doFlingAnimationQWom1Mo(long j, Continuation<? super Velocity> continuation) throws Throwable {
        ScrollingLogic$doFlingAnimation$1 scrollingLogic$doFlingAnimation$1;
        Ref.LongRef longRef;
        if (continuation instanceof ScrollingLogic$doFlingAnimation$1) {
            scrollingLogic$doFlingAnimation$1 = (ScrollingLogic$doFlingAnimation$1) continuation;
            if ((scrollingLogic$doFlingAnimation$1.label & Integer.MIN_VALUE) != 0) {
                scrollingLogic$doFlingAnimation$1.label -= Integer.MIN_VALUE;
            } else {
                scrollingLogic$doFlingAnimation$1 = new ScrollingLogic$doFlingAnimation$1(this, continuation);
            }
        } else {
            scrollingLogic$doFlingAnimation$1 = new ScrollingLogic$doFlingAnimation$1(this, continuation);
        }
        ScrollingLogic$doFlingAnimation$1 scrollingLogic$doFlingAnimation$2 = scrollingLogic$doFlingAnimation$1;
        Object obj = scrollingLogic$doFlingAnimation$2.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = scrollingLogic$doFlingAnimation$2.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            Ref.LongRef longRef2 = new Ref.LongRef();
            longRef2.element = j;
            ScrollableState scrollableState = this.scrollableState;
            ScrollingLogic$doFlingAnimation$2 scrollingLogic$doFlingAnimation$3 = new ScrollingLogic$doFlingAnimation$2(this, longRef2, j, null);
            scrollingLogic$doFlingAnimation$2.L$0 = longRef2;
            scrollingLogic$doFlingAnimation$2.label = 1;
            if (ScrollableState.scroll$default(scrollableState, null, scrollingLogic$doFlingAnimation$3, scrollingLogic$doFlingAnimation$2, 1, null) == coroutine_suspended) {
                return coroutine_suspended;
            }
            longRef = longRef2;
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            longRef = (Ref.LongRef) scrollingLogic$doFlingAnimation$2.L$0;
            ResultKt.throwOnFailure(obj);
        }
        return Velocity.m4059boximpl(longRef.element);
    }

    public final boolean shouldScrollImmediately() {
        if (!this.scrollableState.isScrollInProgress()) {
            OverscrollEffect overscrollEffect = this.overscrollEffect;
            if (!(overscrollEffect != null ? overscrollEffect.isInProgress() : false)) {
                return false;
            }
        }
        return true;
    }
}
