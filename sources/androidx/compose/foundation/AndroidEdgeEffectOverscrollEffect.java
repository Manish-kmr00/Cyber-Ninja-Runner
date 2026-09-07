package androidx.compose.foundation;

import android.content.Context;
import android.graphics.Canvas;
import android.widget.EdgeEffect;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.OffsetKt;
import androidx.compose.ui.geometry.Size;
import androidx.compose.ui.geometry.SizeKt;
import androidx.compose.ui.graphics.AndroidCanvas_androidKt;
import androidx.compose.ui.graphics.ColorKt;
import androidx.compose.ui.graphics.drawscope.DrawScope;
import androidx.compose.ui.input.nestedscroll.NestedScrollSource;
import androidx.compose.ui.layout.OnRemeasuredModifierKt;
import androidx.compose.ui.platform.InspectableValueKt;
import androidx.compose.ui.platform.InspectorInfo;
import androidx.compose.ui.unit.IntSize;
import androidx.compose.ui.unit.IntSizeKt;
import androidx.compose.ui.unit.Velocity;
import androidx.compose.ui.unit.VelocityKt;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;

/* JADX INFO: compiled from: AndroidOverscroll.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\u0088\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u0007\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\b\u0000\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\b\u0010-\u001a\u00020&H\u0002J!\u0010.\u001a\u00020&2\u0006\u0010/\u001a\u000200H\u0096@ø\u0001\u0000ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b1\u00102J7\u00103\u001a\u00020&2\u0006\u00104\u001a\u0002052\u0006\u00106\u001a\u0002052\b\u00107\u001a\u0004\u0018\u0001052\u0006\u00108\u001a\u000209H\u0016ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b:\u0010;J!\u0010<\u001a\u0002002\u0006\u0010/\u001a\u000200H\u0096@ø\u0001\u0000ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b=\u00102J/\u0010>\u001a\u0002052\u0006\u0010?\u001a\u0002052\b\u00107\u001a\u0004\u0018\u0001052\u0006\u00108\u001a\u000209H\u0016ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b@\u0010AJ\b\u0010B\u001a\u00020&H\u0002J%\u0010C\u001a\u00020D2\u0006\u0010E\u001a\u0002052\u0006\u0010F\u001a\u000205H\u0002ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\bG\u0010HJ%\u0010I\u001a\u00020D2\u0006\u0010E\u001a\u0002052\u0006\u0010F\u001a\u000205H\u0002ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\bJ\u0010HJ%\u0010K\u001a\u00020D2\u0006\u0010E\u001a\u0002052\u0006\u0010F\u001a\u000205H\u0002ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\bL\u0010HJ%\u0010M\u001a\u00020D2\u0006\u0010E\u001a\u0002052\u0006\u0010F\u001a\u000205H\u0002ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\bN\u0010HJ\u001d\u0010O\u001a\u00020\u00142\u0006\u0010P\u001a\u000205H\u0002ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\bQ\u0010RJ\b\u0010S\u001a\u00020\u0014H\u0002J \u0010T\u001a\u00020\u0014*\u00020U2\u0006\u0010V\u001a\u00020\t2\n\u0010W\u001a\u00060Xj\u0002`YH\u0002J \u0010Z\u001a\u00020\u0014*\u00020U2\u0006\u0010[\u001a\u00020\t2\n\u0010W\u001a\u00060Xj\u0002`YH\u0002J\n\u0010\\\u001a\u00020&*\u00020UJ \u0010]\u001a\u00020\u0014*\u00020U2\u0006\u0010^\u001a\u00020\t2\n\u0010W\u001a\u00060Xj\u0002`YH\u0002J \u0010_\u001a\u00020\u0014*\u00020U2\u0006\u0010`\u001a\u00020\t2\n\u0010W\u001a\u00060Xj\u0002`YH\u0002R\u0014\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u0019\u0010\f\u001a\u00020\rX\u0082\u000eø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0004\n\u0002\u0010\u000eR\u0014\u0010\u000f\u001a\u00020\u0010X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R$\u0010\u0013\u001a\u00020\u00148\u0000@\u0000X\u0081\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR&\u0010\u001c\u001a\u00020\u00142\u0006\u0010\u001b\u001a\u00020\u00148V@VX\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u0018\"\u0004\b\u001d\u0010\u001aR\u0014\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u00140\u001fX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010 \u001a\u00020\u00148VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b \u0010\u0018R\u000e\u0010!\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\"\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u001d\u0010#\u001a\u000e\u0012\u0004\u0012\u00020%\u0012\u0004\u0012\u00020&0$X\u0082\u0004ø\u0001\u0000¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010'\u001a\b\u0012\u0004\u0012\u00020&0\u001fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010(\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010)\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010*\u001a\u00020\u0014X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010+\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010,\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000\u0082\u0002\u000f\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006a"}, d2 = {"Landroidx/compose/foundation/AndroidEdgeEffectOverscrollEffect;", "Landroidx/compose/foundation/OverscrollEffect;", "context", "Landroid/content/Context;", "overscrollConfig", "Landroidx/compose/foundation/OverscrollConfiguration;", "(Landroid/content/Context;Landroidx/compose/foundation/OverscrollConfiguration;)V", "allEffects", "", "Landroid/widget/EdgeEffect;", "bottomEffect", "bottomEffectNegation", "containerSize", "Landroidx/compose/ui/geometry/Size;", "J", "effectModifier", "Landroidx/compose/ui/Modifier;", "getEffectModifier", "()Landroidx/compose/ui/Modifier;", "invalidationEnabled", "", "getInvalidationEnabled$foundation_release$annotations", "()V", "getInvalidationEnabled$foundation_release", "()Z", "setInvalidationEnabled$foundation_release", "(Z)V", "value", "isEnabled", "setEnabled", "isEnabledState", "Landroidx/compose/runtime/MutableState;", "isInProgress", "leftEffect", "leftEffectNegation", "onNewSize", "Lkotlin/Function1;", "Landroidx/compose/ui/unit/IntSize;", "", "redrawSignal", "rightEffect", "rightEffectNegation", "scrollCycleInProgress", "topEffect", "topEffectNegation", "animateToRelease", "consumePostFling", "velocity", "Landroidx/compose/ui/unit/Velocity;", "consumePostFling-sF-c-tU", "(JLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "consumePostScroll", "initialDragDelta", "Landroidx/compose/ui/geometry/Offset;", "overscrollDelta", "pointerPosition", "source", "Landroidx/compose/ui/input/nestedscroll/NestedScrollSource;", "consumePostScroll-l7mfB5k", "(JJLandroidx/compose/ui/geometry/Offset;I)V", "consumePreFling", "consumePreFling-QWom1Mo", "consumePreScroll", "scrollDelta", "consumePreScroll-A0NYTsA", "(JLandroidx/compose/ui/geometry/Offset;I)J", "invalidateOverscroll", "pullBottom", "", "scroll", "displacement", "pullBottom-0a9Yr6o", "(JJ)F", "pullLeft", "pullLeft-0a9Yr6o", "pullRight", "pullRight-0a9Yr6o", "pullTop", "pullTop-0a9Yr6o", "releaseOppositeOverscroll", "delta", "releaseOppositeOverscroll-k-4lQ0M", "(J)Z", "stopOverscrollAnimation", "drawBottom", "Landroidx/compose/ui/graphics/drawscope/DrawScope;", "bottom", "canvas", "Landroid/graphics/Canvas;", "Landroidx/compose/ui/graphics/NativeCanvas;", "drawLeft", "left", "drawOverscroll", "drawRight", "right", "drawTop", ViewHierarchyConstants.DIMENSION_TOP_KEY, "foundation_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class AndroidEdgeEffectOverscrollEffect implements OverscrollEffect {
    private final List<EdgeEffect> allEffects;
    private final EdgeEffect bottomEffect;
    private final EdgeEffect bottomEffectNegation;
    private long containerSize;
    private final Modifier effectModifier;
    private boolean invalidationEnabled;
    private boolean isEnabled;
    private final MutableState<Boolean> isEnabledState;
    private final EdgeEffect leftEffect;
    private final EdgeEffect leftEffectNegation;
    private final Function1<IntSize, Unit> onNewSize;
    private final OverscrollConfiguration overscrollConfig;
    private final MutableState<Unit> redrawSignal;
    private final EdgeEffect rightEffect;
    private final EdgeEffect rightEffectNegation;
    private boolean scrollCycleInProgress;
    private final EdgeEffect topEffect;
    private final EdgeEffect topEffectNegation;

    public static /* synthetic */ void getInvalidationEnabled$foundation_release$annotations() {
    }

    public AndroidEdgeEffectOverscrollEffect(Context context, OverscrollConfiguration overscrollConfig) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(overscrollConfig, "overscrollConfig");
        this.overscrollConfig = overscrollConfig;
        EdgeEffect edgeEffectCreate = EdgeEffectCompat.INSTANCE.create(context, null);
        this.topEffect = edgeEffectCreate;
        EdgeEffect edgeEffectCreate2 = EdgeEffectCompat.INSTANCE.create(context, null);
        this.bottomEffect = edgeEffectCreate2;
        EdgeEffect edgeEffectCreate3 = EdgeEffectCompat.INSTANCE.create(context, null);
        this.leftEffect = edgeEffectCreate3;
        EdgeEffect edgeEffectCreate4 = EdgeEffectCompat.INSTANCE.create(context, null);
        this.rightEffect = edgeEffectCreate4;
        List<EdgeEffect> listListOf = CollectionsKt.listOf((Object[]) new EdgeEffect[]{edgeEffectCreate3, edgeEffectCreate, edgeEffectCreate4, edgeEffectCreate2});
        this.allEffects = listListOf;
        this.topEffectNegation = EdgeEffectCompat.INSTANCE.create(context, null);
        this.bottomEffectNegation = EdgeEffectCompat.INSTANCE.create(context, null);
        this.leftEffectNegation = EdgeEffectCompat.INSTANCE.create(context, null);
        this.rightEffectNegation = EdgeEffectCompat.INSTANCE.create(context, null);
        int size = listListOf.size();
        for (int i = 0; i < size; i++) {
            listListOf.get(i).setColor(ColorKt.m1686toArgb8_81llA(this.overscrollConfig.getGlowColor()));
        }
        this.redrawSignal = SnapshotStateKt.mutableStateOf(Unit.INSTANCE, SnapshotStateKt.neverEqualPolicy());
        this.invalidationEnabled = true;
        this.containerSize = Size.INSTANCE.m1473getZeroNHjbRc();
        this.isEnabledState = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(false, null, 2, null);
        Function1<IntSize, Unit> function1 = new Function1<IntSize, Unit>() { // from class: androidx.compose.foundation.AndroidEdgeEffectOverscrollEffect$onNewSize$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(IntSize intSize) {
                m172invokeozmzZPI(intSize.getPackedValue());
                return Unit.INSTANCE;
            }

            /* JADX INFO: renamed from: invoke-ozmzZPI, reason: not valid java name */
            public final void m172invokeozmzZPI(long j) {
                boolean zM1460equalsimpl0 = Size.m1460equalsimpl0(IntSizeKt.m4013toSizeozmzZPI(j), this.this$0.containerSize);
                this.this$0.containerSize = IntSizeKt.m4013toSizeozmzZPI(j);
                if (!zM1460equalsimpl0) {
                    this.this$0.topEffect.setSize(IntSize.m4003getWidthimpl(j), IntSize.m4002getHeightimpl(j));
                    this.this$0.bottomEffect.setSize(IntSize.m4003getWidthimpl(j), IntSize.m4002getHeightimpl(j));
                    this.this$0.leftEffect.setSize(IntSize.m4002getHeightimpl(j), IntSize.m4003getWidthimpl(j));
                    this.this$0.rightEffect.setSize(IntSize.m4002getHeightimpl(j), IntSize.m4003getWidthimpl(j));
                    this.this$0.topEffectNegation.setSize(IntSize.m4003getWidthimpl(j), IntSize.m4002getHeightimpl(j));
                    this.this$0.bottomEffectNegation.setSize(IntSize.m4003getWidthimpl(j), IntSize.m4002getHeightimpl(j));
                    this.this$0.leftEffectNegation.setSize(IntSize.m4002getHeightimpl(j), IntSize.m4003getWidthimpl(j));
                    this.this$0.rightEffectNegation.setSize(IntSize.m4002getHeightimpl(j), IntSize.m4003getWidthimpl(j));
                }
                if (zM1460equalsimpl0) {
                    return;
                }
                this.this$0.invalidateOverscroll();
                this.this$0.animateToRelease();
            }
        };
        this.onNewSize = function1;
        this.effectModifier = OnRemeasuredModifierKt.onSizeChanged(Modifier.INSTANCE.then(AndroidOverscrollKt.StretchOverscrollNonClippingLayer), function1).then(new DrawOverscrollModifier(this, InspectableValueKt.isDebugInspectorInfoEnabled() ? new Function1<InspectorInfo, Unit>() { // from class: androidx.compose.foundation.AndroidEdgeEffectOverscrollEffect$special$$inlined$debugInspectorInfo$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(InspectorInfo inspectorInfo) {
                invoke2(inspectorInfo);
                return Unit.INSTANCE;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(InspectorInfo inspectorInfo) {
                Intrinsics.checkNotNullParameter(inspectorInfo, "$this$null");
                inspectorInfo.setName("overscroll");
                inspectorInfo.setValue(this.this$0);
            }
        } : InspectableValueKt.getNoInspectorInfo()));
    }

    /* JADX INFO: renamed from: getInvalidationEnabled$foundation_release, reason: from getter */
    public final boolean getInvalidationEnabled() {
        return this.invalidationEnabled;
    }

    public final void setInvalidationEnabled$foundation_release(boolean z) {
        this.invalidationEnabled = z;
    }

    /* JADX WARN: Code duplicated, block: B:10:0x0020  */
    @Override // androidx.compose.foundation.OverscrollEffect
    /* JADX INFO: renamed from: consumePreScroll-A0NYTsA, reason: not valid java name */
    public long mo171consumePreScrollA0NYTsA(long scrollDelta, Offset pointerPosition, int source) {
        float fM166pullTop0a9Yr6o;
        float fM164pullLeft0a9Yr6o;
        if (!this.scrollCycleInProgress) {
            stopOverscrollAnimation();
            this.scrollCycleInProgress = true;
        }
        long packedValue = pointerPosition != null ? pointerPosition.getPackedValue() : SizeKt.m1474getCenteruvyYCjk(this.containerSize);
        float f = 0.0f;
        if (Offset.m1396getYimpl(scrollDelta) == 0.0f) {
            fM166pullTop0a9Yr6o = 0.0f;
        } else if (EdgeEffectCompat.INSTANCE.getDistanceCompat(this.topEffect) != 0.0f) {
            fM166pullTop0a9Yr6o = m166pullTop0a9Yr6o(scrollDelta, packedValue);
            if (EdgeEffectCompat.INSTANCE.getDistanceCompat(this.topEffect) == 0.0f) {
                this.topEffect.onRelease();
            }
        } else if (EdgeEffectCompat.INSTANCE.getDistanceCompat(this.bottomEffect) == 0.0f) {
            fM166pullTop0a9Yr6o = 0.0f;
        } else {
            fM166pullTop0a9Yr6o = m163pullBottom0a9Yr6o(scrollDelta, packedValue);
            if (EdgeEffectCompat.INSTANCE.getDistanceCompat(this.bottomEffect) == 0.0f) {
                this.bottomEffect.onRelease();
            }
        }
        if (Offset.m1395getXimpl(scrollDelta) != 0.0f) {
            if (EdgeEffectCompat.INSTANCE.getDistanceCompat(this.leftEffect) != 0.0f) {
                fM164pullLeft0a9Yr6o = m164pullLeft0a9Yr6o(scrollDelta, packedValue);
                if (EdgeEffectCompat.INSTANCE.getDistanceCompat(this.leftEffect) == 0.0f) {
                    this.leftEffect.onRelease();
                }
            } else if (EdgeEffectCompat.INSTANCE.getDistanceCompat(this.rightEffect) != 0.0f) {
                fM164pullLeft0a9Yr6o = m165pullRight0a9Yr6o(scrollDelta, packedValue);
                if (EdgeEffectCompat.INSTANCE.getDistanceCompat(this.rightEffect) == 0.0f) {
                    this.rightEffect.onRelease();
                }
            }
            f = fM164pullLeft0a9Yr6o;
        }
        long jOffset = OffsetKt.Offset(f, fM166pullTop0a9Yr6o);
        if (!Offset.m1392equalsimpl0(jOffset, Offset.INSTANCE.m1411getZeroF1C5BW0())) {
            invalidateOverscroll();
        }
        return jOffset;
    }

    @Override // androidx.compose.foundation.OverscrollEffect
    /* JADX INFO: renamed from: consumePostScroll-l7mfB5k, reason: not valid java name */
    public void mo169consumePostScrolll7mfB5k(long initialDragDelta, long overscrollDelta, Offset pointerPosition, int source) {
        boolean z;
        if (NestedScrollSource.m2893equalsimpl0(source, NestedScrollSource.INSTANCE.m2898getDragWNlRxjI())) {
            long packedValue = pointerPosition != null ? pointerPosition.getPackedValue() : SizeKt.m1474getCenteruvyYCjk(this.containerSize);
            if (Offset.m1395getXimpl(overscrollDelta) > 0.0f) {
                m164pullLeft0a9Yr6o(overscrollDelta, packedValue);
            } else if (Offset.m1395getXimpl(overscrollDelta) < 0.0f) {
                m165pullRight0a9Yr6o(overscrollDelta, packedValue);
            }
            if (Offset.m1396getYimpl(overscrollDelta) > 0.0f) {
                m166pullTop0a9Yr6o(overscrollDelta, packedValue);
            } else if (Offset.m1396getYimpl(overscrollDelta) < 0.0f) {
                m163pullBottom0a9Yr6o(overscrollDelta, packedValue);
            }
            z = !Offset.m1392equalsimpl0(overscrollDelta, Offset.INSTANCE.m1411getZeroF1C5BW0());
        } else {
            z = false;
        }
        if (m167releaseOppositeOverscrollk4lQ0M(initialDragDelta) || z) {
            invalidateOverscroll();
        }
    }

    @Override // androidx.compose.foundation.OverscrollEffect
    /* JADX INFO: renamed from: consumePreFling-QWom1Mo, reason: not valid java name */
    public Object mo170consumePreFlingQWom1Mo(long j, Continuation<? super Velocity> continuation) {
        float fM4068getXimpl;
        float fM4069getYimpl = 0.0f;
        if (Velocity.m4068getXimpl(j) > 0.0f && EdgeEffectCompat.INSTANCE.getDistanceCompat(this.leftEffect) != 0.0f) {
            EdgeEffectCompat.INSTANCE.onAbsorbCompat(this.leftEffect, MathKt.roundToInt(Velocity.m4068getXimpl(j)));
            fM4068getXimpl = Velocity.m4068getXimpl(j);
        } else if (Velocity.m4068getXimpl(j) >= 0.0f || EdgeEffectCompat.INSTANCE.getDistanceCompat(this.rightEffect) == 0.0f) {
            fM4068getXimpl = 0.0f;
        } else {
            EdgeEffectCompat.INSTANCE.onAbsorbCompat(this.rightEffect, -MathKt.roundToInt(Velocity.m4068getXimpl(j)));
            fM4068getXimpl = Velocity.m4068getXimpl(j);
        }
        if (Velocity.m4069getYimpl(j) > 0.0f && EdgeEffectCompat.INSTANCE.getDistanceCompat(this.topEffect) != 0.0f) {
            EdgeEffectCompat.INSTANCE.onAbsorbCompat(this.topEffect, MathKt.roundToInt(Velocity.m4069getYimpl(j)));
            fM4069getYimpl = Velocity.m4069getYimpl(j);
        } else if (Velocity.m4069getYimpl(j) < 0.0f && EdgeEffectCompat.INSTANCE.getDistanceCompat(this.bottomEffect) != 0.0f) {
            EdgeEffectCompat.INSTANCE.onAbsorbCompat(this.bottomEffect, -MathKt.roundToInt(Velocity.m4069getYimpl(j)));
            fM4069getYimpl = Velocity.m4069getYimpl(j);
        }
        long jVelocity = VelocityKt.Velocity(fM4068getXimpl, fM4069getYimpl);
        if (!Velocity.m4067equalsimpl0(jVelocity, Velocity.INSTANCE.m4079getZero9UxMQ8M())) {
            invalidateOverscroll();
        }
        return Velocity.m4059boximpl(jVelocity);
    }

    @Override // androidx.compose.foundation.OverscrollEffect
    /* JADX INFO: renamed from: consumePostFling-sF-c-tU, reason: not valid java name */
    public Object mo168consumePostFlingsFctU(long j, Continuation<? super Unit> continuation) {
        this.scrollCycleInProgress = false;
        if (Velocity.m4068getXimpl(j) > 0.0f) {
            EdgeEffectCompat.INSTANCE.onAbsorbCompat(this.leftEffect, MathKt.roundToInt(Velocity.m4068getXimpl(j)));
        } else if (Velocity.m4068getXimpl(j) < 0.0f) {
            EdgeEffectCompat.INSTANCE.onAbsorbCompat(this.rightEffect, -MathKt.roundToInt(Velocity.m4068getXimpl(j)));
        }
        if (Velocity.m4069getYimpl(j) > 0.0f) {
            EdgeEffectCompat.INSTANCE.onAbsorbCompat(this.topEffect, MathKt.roundToInt(Velocity.m4069getYimpl(j)));
        } else if (Velocity.m4069getYimpl(j) < 0.0f) {
            EdgeEffectCompat.INSTANCE.onAbsorbCompat(this.bottomEffect, -MathKt.roundToInt(Velocity.m4069getYimpl(j)));
        }
        if (!Velocity.m4067equalsimpl0(j, Velocity.INSTANCE.m4079getZero9UxMQ8M())) {
            invalidateOverscroll();
        }
        animateToRelease();
        return Unit.INSTANCE;
    }

    @Override // androidx.compose.foundation.OverscrollEffect
    public boolean isEnabled() {
        return this.isEnabledState.getValue().booleanValue();
    }

    @Override // androidx.compose.foundation.OverscrollEffect
    public void setEnabled(boolean z) {
        boolean z2 = this.isEnabled != z;
        this.isEnabledState.setValue(Boolean.valueOf(z));
        this.isEnabled = z;
        if (z2) {
            this.scrollCycleInProgress = false;
            animateToRelease();
        }
    }

    @Override // androidx.compose.foundation.OverscrollEffect
    public boolean isInProgress() {
        List<EdgeEffect> list = this.allEffects;
        int size = list.size();
        for (int i = 0; i < size; i++) {
            if (!(EdgeEffectCompat.INSTANCE.getDistanceCompat(list.get(i)) == 0.0f)) {
                return true;
            }
        }
        return false;
    }

    private final boolean stopOverscrollAnimation() {
        boolean z;
        long jM1474getCenteruvyYCjk = SizeKt.m1474getCenteruvyYCjk(this.containerSize);
        if (EdgeEffectCompat.INSTANCE.getDistanceCompat(this.leftEffect) == 0.0f) {
            z = false;
        } else {
            m164pullLeft0a9Yr6o(Offset.INSTANCE.m1411getZeroF1C5BW0(), jM1474getCenteruvyYCjk);
            z = true;
        }
        if (EdgeEffectCompat.INSTANCE.getDistanceCompat(this.rightEffect) != 0.0f) {
            m165pullRight0a9Yr6o(Offset.INSTANCE.m1411getZeroF1C5BW0(), jM1474getCenteruvyYCjk);
            z = true;
        }
        if (EdgeEffectCompat.INSTANCE.getDistanceCompat(this.topEffect) != 0.0f) {
            m166pullTop0a9Yr6o(Offset.INSTANCE.m1411getZeroF1C5BW0(), jM1474getCenteruvyYCjk);
            z = true;
        }
        if (EdgeEffectCompat.INSTANCE.getDistanceCompat(this.bottomEffect) == 0.0f) {
            return z;
        }
        m163pullBottom0a9Yr6o(Offset.INSTANCE.m1411getZeroF1C5BW0(), jM1474getCenteruvyYCjk);
        return true;
    }

    @Override // androidx.compose.foundation.OverscrollEffect
    public Modifier getEffectModifier() {
        return this.effectModifier;
    }

    private final boolean drawLeft(DrawScope drawScope, EdgeEffect edgeEffect, Canvas canvas) {
        int iSave = canvas.save();
        canvas.rotate(270.0f);
        canvas.translate(-Size.m1461getHeightimpl(this.containerSize), drawScope.mo318toPx0680j_4(this.overscrollConfig.getDrawPadding().mo404calculateLeftPaddingu2uoSUM(drawScope.getLayoutDirection())));
        boolean zDraw = edgeEffect.draw(canvas);
        canvas.restoreToCount(iSave);
        return zDraw;
    }

    private final boolean drawTop(DrawScope drawScope, EdgeEffect edgeEffect, Canvas canvas) {
        int iSave = canvas.save();
        canvas.translate(0.0f, drawScope.mo318toPx0680j_4(this.overscrollConfig.getDrawPadding().getTop()));
        boolean zDraw = edgeEffect.draw(canvas);
        canvas.restoreToCount(iSave);
        return zDraw;
    }

    private final boolean drawRight(DrawScope drawScope, EdgeEffect edgeEffect, Canvas canvas) {
        int iSave = canvas.save();
        int iRoundToInt = MathKt.roundToInt(Size.m1464getWidthimpl(this.containerSize));
        float fMo405calculateRightPaddingu2uoSUM = this.overscrollConfig.getDrawPadding().mo405calculateRightPaddingu2uoSUM(drawScope.getLayoutDirection());
        canvas.rotate(90.0f);
        canvas.translate(0.0f, (-iRoundToInt) + drawScope.mo318toPx0680j_4(fMo405calculateRightPaddingu2uoSUM));
        boolean zDraw = edgeEffect.draw(canvas);
        canvas.restoreToCount(iSave);
        return zDraw;
    }

    private final boolean drawBottom(DrawScope drawScope, EdgeEffect edgeEffect, Canvas canvas) {
        int iSave = canvas.save();
        canvas.rotate(180.0f);
        canvas.translate(-Size.m1464getWidthimpl(this.containerSize), (-Size.m1461getHeightimpl(this.containerSize)) + drawScope.mo318toPx0680j_4(this.overscrollConfig.getDrawPadding().getBottom()));
        boolean zDraw = edgeEffect.draw(canvas);
        canvas.restoreToCount(iSave);
        return zDraw;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void invalidateOverscroll() {
        if (this.invalidationEnabled) {
            this.redrawSignal.setValue(Unit.INSTANCE);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void animateToRelease() {
        List<EdgeEffect> list = this.allEffects;
        int size = list.size();
        boolean z = false;
        for (int i = 0; i < size; i++) {
            EdgeEffect edgeEffect = list.get(i);
            edgeEffect.onRelease();
            z = edgeEffect.isFinished() || z;
        }
        if (z) {
            invalidateOverscroll();
        }
    }

    /* JADX INFO: renamed from: releaseOppositeOverscroll-k-4lQ0M, reason: not valid java name */
    private final boolean m167releaseOppositeOverscrollk4lQ0M(long delta) {
        boolean zIsFinished;
        if (this.leftEffect.isFinished() || Offset.m1395getXimpl(delta) >= 0.0f) {
            zIsFinished = false;
        } else {
            this.leftEffect.onRelease();
            zIsFinished = this.leftEffect.isFinished();
        }
        if (!this.rightEffect.isFinished() && Offset.m1395getXimpl(delta) > 0.0f) {
            this.rightEffect.onRelease();
            zIsFinished = zIsFinished || this.rightEffect.isFinished();
        }
        if (!this.topEffect.isFinished() && Offset.m1396getYimpl(delta) < 0.0f) {
            this.topEffect.onRelease();
            zIsFinished = zIsFinished || this.topEffect.isFinished();
        }
        if (this.bottomEffect.isFinished() || Offset.m1396getYimpl(delta) <= 0.0f) {
            return zIsFinished;
        }
        this.bottomEffect.onRelease();
        return zIsFinished || this.bottomEffect.isFinished();
    }

    /* JADX INFO: renamed from: pullTop-0a9Yr6o, reason: not valid java name */
    private final float m166pullTop0a9Yr6o(long scroll, long displacement) {
        float fM1395getXimpl = Offset.m1395getXimpl(displacement) / Size.m1464getWidthimpl(this.containerSize);
        return EdgeEffectCompat.INSTANCE.onPullDistanceCompat(this.topEffect, Offset.m1396getYimpl(scroll) / Size.m1461getHeightimpl(this.containerSize), fM1395getXimpl) * Size.m1461getHeightimpl(this.containerSize);
    }

    /* JADX INFO: renamed from: pullBottom-0a9Yr6o, reason: not valid java name */
    private final float m163pullBottom0a9Yr6o(long scroll, long displacement) {
        return (-EdgeEffectCompat.INSTANCE.onPullDistanceCompat(this.bottomEffect, -(Offset.m1396getYimpl(scroll) / Size.m1461getHeightimpl(this.containerSize)), 1 - (Offset.m1395getXimpl(displacement) / Size.m1464getWidthimpl(this.containerSize)))) * Size.m1461getHeightimpl(this.containerSize);
    }

    /* JADX INFO: renamed from: pullLeft-0a9Yr6o, reason: not valid java name */
    private final float m164pullLeft0a9Yr6o(long scroll, long displacement) {
        return EdgeEffectCompat.INSTANCE.onPullDistanceCompat(this.leftEffect, Offset.m1395getXimpl(scroll) / Size.m1464getWidthimpl(this.containerSize), 1 - (Offset.m1396getYimpl(displacement) / Size.m1461getHeightimpl(this.containerSize))) * Size.m1464getWidthimpl(this.containerSize);
    }

    /* JADX INFO: renamed from: pullRight-0a9Yr6o, reason: not valid java name */
    private final float m165pullRight0a9Yr6o(long scroll, long displacement) {
        return (-EdgeEffectCompat.INSTANCE.onPullDistanceCompat(this.rightEffect, -(Offset.m1395getXimpl(scroll) / Size.m1464getWidthimpl(this.containerSize)), Offset.m1396getYimpl(displacement) / Size.m1461getHeightimpl(this.containerSize))) * Size.m1464getWidthimpl(this.containerSize);
    }

    public final void drawOverscroll(DrawScope drawScope) {
        boolean zDrawLeft;
        Intrinsics.checkNotNullParameter(drawScope, "<this>");
        androidx.compose.ui.graphics.Canvas canvas = drawScope.getDrawContext().getCanvas();
        this.redrawSignal.getValue();
        Canvas nativeCanvas = AndroidCanvas_androidKt.getNativeCanvas(canvas);
        if (EdgeEffectCompat.INSTANCE.getDistanceCompat(this.leftEffectNegation) != 0.0f) {
            drawRight(drawScope, this.leftEffectNegation, nativeCanvas);
            this.leftEffectNegation.finish();
        }
        if (this.leftEffect.isFinished()) {
            zDrawLeft = false;
        } else {
            zDrawLeft = drawLeft(drawScope, this.leftEffect, nativeCanvas);
            EdgeEffectCompat.INSTANCE.onPullDistanceCompat(this.leftEffectNegation, EdgeEffectCompat.INSTANCE.getDistanceCompat(this.leftEffect), 0.0f);
        }
        if (EdgeEffectCompat.INSTANCE.getDistanceCompat(this.topEffectNegation) != 0.0f) {
            drawBottom(drawScope, this.topEffectNegation, nativeCanvas);
            this.topEffectNegation.finish();
        }
        if (!this.topEffect.isFinished()) {
            zDrawLeft = drawTop(drawScope, this.topEffect, nativeCanvas) || zDrawLeft;
            EdgeEffectCompat.INSTANCE.onPullDistanceCompat(this.topEffectNegation, EdgeEffectCompat.INSTANCE.getDistanceCompat(this.topEffect), 0.0f);
        }
        if (EdgeEffectCompat.INSTANCE.getDistanceCompat(this.rightEffectNegation) != 0.0f) {
            drawLeft(drawScope, this.rightEffectNegation, nativeCanvas);
            this.rightEffectNegation.finish();
        }
        if (!this.rightEffect.isFinished()) {
            zDrawLeft = drawRight(drawScope, this.rightEffect, nativeCanvas) || zDrawLeft;
            EdgeEffectCompat.INSTANCE.onPullDistanceCompat(this.rightEffectNegation, EdgeEffectCompat.INSTANCE.getDistanceCompat(this.rightEffect), 0.0f);
        }
        if (EdgeEffectCompat.INSTANCE.getDistanceCompat(this.bottomEffectNegation) != 0.0f) {
            drawTop(drawScope, this.bottomEffectNegation, nativeCanvas);
            this.bottomEffectNegation.finish();
        }
        if (!this.bottomEffect.isFinished()) {
            boolean z = drawBottom(drawScope, this.bottomEffect, nativeCanvas) || zDrawLeft;
            EdgeEffectCompat.INSTANCE.onPullDistanceCompat(this.bottomEffectNegation, EdgeEffectCompat.INSTANCE.getDistanceCompat(this.bottomEffect), 0.0f);
            zDrawLeft = z;
        }
        if (zDrawLeft) {
            invalidateOverscroll();
        }
    }
}
