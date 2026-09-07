package androidx.compose.animation;

import androidx.compose.animation.core.AnimationSpecKt;
import androidx.compose.animation.core.AnimationVector1D;
import androidx.compose.animation.core.AnimationVector2D;
import androidx.compose.animation.core.FiniteAnimationSpec;
import androidx.compose.animation.core.SpringSpec;
import androidx.compose.animation.core.Transition;
import androidx.compose.animation.core.TwoWayConverter;
import androidx.compose.animation.core.VectorConvertersKt;
import androidx.compose.animation.core.VisibilityThresholdsKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.draw.ClipKt;
import androidx.compose.ui.graphics.GraphicsLayerModifierKt;
import androidx.compose.ui.graphics.GraphicsLayerScope;
import androidx.compose.ui.graphics.TransformOrigin;
import androidx.compose.ui.graphics.TransformOriginKt;
import androidx.compose.ui.unit.IntOffset;
import androidx.compose.ui.unit.IntOffsetKt;
import androidx.compose.ui.unit.IntSize;
import androidx.compose.ui.unit.IntSizeKt;
import androidx.profileinstaller.ProfileVerifier;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.FloatCompanionObject;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: EnterExitTransition.kt */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000\u0098\u0001\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\u001aT\u0010\r\u001a\u00020\u000e2\u000e\b\u0002\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\b0\u00102\b\b\u0002\u0010\u0011\u001a\u00020\u00122\b\b\u0002\u0010\u0013\u001a\u00020\u00142#\b\u0002\u0010\u0015\u001a\u001d\u0012\u0013\u0012\u00110\u0017¢\u0006\f\b\u0018\u0012\b\b\u0019\u0012\u0004\b\b(\u001a\u0012\u0004\u0012\u00020\u00170\u0016H\u0007ø\u0001\u0000\u001aT\u0010\u001b\u001a\u00020\u000e2\u000e\b\u0002\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\b0\u00102\b\b\u0002\u0010\u0011\u001a\u00020\u001c2\b\b\u0002\u0010\u0013\u001a\u00020\u00142#\b\u0002\u0010\u001d\u001a\u001d\u0012\u0013\u0012\u00110\b¢\u0006\f\b\u0018\u0012\b\b\u0019\u0012\u0004\b\b(\u001e\u0012\u0004\u0012\u00020\b0\u0016H\u0007ø\u0001\u0000\u001aT\u0010\u001f\u001a\u00020\u000e2\u000e\b\u0002\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\b0\u00102\b\b\u0002\u0010\u0011\u001a\u00020 2\b\b\u0002\u0010\u0013\u001a\u00020\u00142#\b\u0002\u0010!\u001a\u001d\u0012\u0013\u0012\u00110\u0017¢\u0006\f\b\u0018\u0012\b\b\u0019\u0012\u0004\b\b(\"\u0012\u0004\u0012\u00020\u00170\u0016H\u0007ø\u0001\u0000\u001a\"\u0010#\u001a\u00020\u000e2\u000e\b\u0002\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00020\u00102\b\b\u0002\u0010$\u001a\u00020\u0002H\u0007\u001a\"\u0010%\u001a\u00020&2\u000e\b\u0002\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00020\u00102\b\b\u0002\u0010'\u001a\u00020\u0002H\u0007\u001a9\u0010(\u001a\u00020\u000e2\u000e\b\u0002\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00020\u00102\b\b\u0002\u0010)\u001a\u00020\u00022\b\b\u0002\u0010*\u001a\u00020\u000bH\u0007ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b+\u0010,\u001a9\u0010-\u001a\u00020&2\u000e\b\u0002\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00020\u00102\b\b\u0002\u0010.\u001a\u00020\u00022\b\b\u0002\u0010*\u001a\u00020\u000bH\u0007ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b/\u00100\u001aT\u00101\u001a\u00020&2\u000e\b\u0002\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\b0\u00102\b\b\u0002\u00102\u001a\u00020\u00122\b\b\u0002\u0010\u0013\u001a\u00020\u00142#\b\u0002\u00103\u001a\u001d\u0012\u0013\u0012\u00110\u0017¢\u0006\f\b\u0018\u0012\b\b\u0019\u0012\u0004\b\b(\u001a\u0012\u0004\u0012\u00020\u00170\u0016H\u0007ø\u0001\u0000\u001aT\u00104\u001a\u00020&2\u000e\b\u0002\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\b0\u00102\b\b\u0002\u00102\u001a\u00020\u001c2\b\b\u0002\u0010\u0013\u001a\u00020\u00142#\b\u0002\u00105\u001a\u001d\u0012\u0013\u0012\u00110\b¢\u0006\f\b\u0018\u0012\b\b\u0019\u0012\u0004\b\b(\u001e\u0012\u0004\u0012\u00020\b0\u0016H\u0007ø\u0001\u0000\u001aT\u00106\u001a\u00020&2\u000e\b\u0002\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\b0\u00102\b\b\u0002\u00102\u001a\u00020 2\b\b\u0002\u0010\u0013\u001a\u00020\u00142#\b\u0002\u00107\u001a\u001d\u0012\u0013\u0012\u00110\u0017¢\u0006\f\b\u0018\u0012\b\b\u0019\u0012\u0004\b\b(\"\u0012\u0004\u0012\u00020\u00170\u0016H\u0007ø\u0001\u0000\u001a>\u00108\u001a\u00020\u000e2\u000e\b\u0002\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00060\u00102!\u00109\u001a\u001d\u0012\u0013\u0012\u00110\b¢\u0006\f\b\u0018\u0012\b\b\u0019\u0012\u0004\b\b(\u001e\u0012\u0004\u0012\u00020\u00060\u0016H\u0007ø\u0001\u0000\u001a@\u0010:\u001a\u00020\u000e2\u000e\b\u0002\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00060\u00102#\b\u0002\u0010;\u001a\u001d\u0012\u0013\u0012\u00110\u0017¢\u0006\f\b\u0018\u0012\b\b\u0019\u0012\u0004\b\b(\u001a\u0012\u0004\u0012\u00020\u00170\u0016H\u0007ø\u0001\u0000\u001a@\u0010<\u001a\u00020\u000e2\u000e\b\u0002\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00060\u00102#\b\u0002\u0010=\u001a\u001d\u0012\u0013\u0012\u00110\u0017¢\u0006\f\b\u0018\u0012\b\b\u0019\u0012\u0004\b\b(\"\u0012\u0004\u0012\u00020\u00170\u0016H\u0007ø\u0001\u0000\u001a>\u0010>\u001a\u00020&2\u000e\b\u0002\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00060\u00102!\u0010?\u001a\u001d\u0012\u0013\u0012\u00110\b¢\u0006\f\b\u0018\u0012\b\b\u0019\u0012\u0004\b\b(\u001e\u0012\u0004\u0012\u00020\u00060\u0016H\u0007ø\u0001\u0000\u001a@\u0010@\u001a\u00020&2\u000e\b\u0002\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00060\u00102#\b\u0002\u0010A\u001a\u001d\u0012\u0013\u0012\u00110\u0017¢\u0006\f\b\u0018\u0012\b\b\u0019\u0012\u0004\b\b(\u001a\u0012\u0004\u0012\u00020\u00170\u0016H\u0007ø\u0001\u0000\u001a@\u0010B\u001a\u00020&2\u000e\b\u0002\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00060\u00102#\b\u0002\u0010C\u001a\u001d\u0012\u0013\u0012\u00110\u0017¢\u0006\f\b\u0018\u0012\b\b\u0019\u0012\u0004\b\b(\"\u0012\u0004\u0012\u00020\u00170\u0016H\u0007ø\u0001\u0000\u001a/\u0010D\u001a\u00020E*\b\u0012\u0004\u0012\u00020G0F2\u0006\u0010H\u001a\u00020\u000e2\u0006\u0010I\u001a\u00020&2\u0006\u0010J\u001a\u00020KH\u0001¢\u0006\u0002\u0010L\u001aB\u0010M\u001a\u00020E*\u00020E2\f\u0010N\u001a\b\u0012\u0004\u0012\u00020G0F2\u000e\u0010O\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010Q0P2\u000e\u0010R\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010Q0P2\u0006\u0010S\u001a\u00020KH\u0002\u001aB\u0010T\u001a\u00020E*\u00020E2\f\u0010N\u001a\b\u0012\u0004\u0012\u00020G0F2\u000e\u00108\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010U0P2\u000e\u0010>\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010U0P2\u0006\u0010S\u001a\u00020KH\u0002\u001a\f\u0010V\u001a\u00020\u001c*\u00020\u0012H\u0002\u001a\f\u0010V\u001a\u00020\u001c*\u00020 H\u0002\"\u0014\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000\"\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000\"\u0017\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00060\u0004X\u0082\u0004ø\u0001\u0000¢\u0006\u0002\n\u0000\"\u0017\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\b0\u0004X\u0082\u0004ø\u0001\u0000¢\u0006\u0002\n\u0000\"\u001d\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\f0\nX\u0082\u0004ø\u0001\u0000¢\u0006\u0002\n\u0000\u0082\u0002\u000b\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001¨\u0006W"}, d2 = {"DefaultAlpha", "Landroidx/compose/runtime/MutableState;", "", "DefaultAlphaAndScaleSpring", "Landroidx/compose/animation/core/SpringSpec;", "DefaultOffsetAnimationSpec", "Landroidx/compose/ui/unit/IntOffset;", "DefaultSizeAnimationSpec", "Landroidx/compose/ui/unit/IntSize;", "TransformOriginVectorConverter", "Landroidx/compose/animation/core/TwoWayConverter;", "Landroidx/compose/ui/graphics/TransformOrigin;", "Landroidx/compose/animation/core/AnimationVector2D;", "expandHorizontally", "Landroidx/compose/animation/EnterTransition;", "animationSpec", "Landroidx/compose/animation/core/FiniteAnimationSpec;", "expandFrom", "Landroidx/compose/ui/Alignment$Horizontal;", "clip", "", "initialWidth", "Lkotlin/Function1;", "", "Lkotlin/ParameterName;", "name", "fullWidth", "expandIn", "Landroidx/compose/ui/Alignment;", "initialSize", "fullSize", "expandVertically", "Landroidx/compose/ui/Alignment$Vertical;", "initialHeight", "fullHeight", "fadeIn", "initialAlpha", "fadeOut", "Landroidx/compose/animation/ExitTransition;", "targetAlpha", "scaleIn", "initialScale", "transformOrigin", "scaleIn-L8ZKh-E", "(Landroidx/compose/animation/core/FiniteAnimationSpec;FJ)Landroidx/compose/animation/EnterTransition;", "scaleOut", "targetScale", "scaleOut-L8ZKh-E", "(Landroidx/compose/animation/core/FiniteAnimationSpec;FJ)Landroidx/compose/animation/ExitTransition;", "shrinkHorizontally", "shrinkTowards", "targetWidth", "shrinkOut", "targetSize", "shrinkVertically", "targetHeight", "slideIn", "initialOffset", "slideInHorizontally", "initialOffsetX", "slideInVertically", "initialOffsetY", "slideOut", "targetOffset", "slideOutHorizontally", "targetOffsetX", "slideOutVertically", "targetOffsetY", "createModifier", "Landroidx/compose/ui/Modifier;", "Landroidx/compose/animation/core/Transition;", "Landroidx/compose/animation/EnterExitState;", "enter", "exit", "label", "", "(Landroidx/compose/animation/core/Transition;Landroidx/compose/animation/EnterTransition;Landroidx/compose/animation/ExitTransition;Ljava/lang/String;Landroidx/compose/runtime/Composer;I)Landroidx/compose/ui/Modifier;", "shrinkExpand", "transition", "expand", "Landroidx/compose/runtime/State;", "Landroidx/compose/animation/ChangeSize;", "shrink", "labelPrefix", "slideInOut", "Landroidx/compose/animation/Slide;", "toAlignment", "animation_release"}, k = 2, mv = {1, 6, 0}, xi = 48)
public final class EnterExitTransitionKt {
    private static final TwoWayConverter<TransformOrigin, AnimationVector2D> TransformOriginVectorConverter = VectorConvertersKt.TwoWayConverter(new Function1<TransformOrigin, AnimationVector2D>() { // from class: androidx.compose.animation.EnterExitTransitionKt$TransformOriginVectorConverter$1
        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ AnimationVector2D invoke(TransformOrigin transformOrigin) {
            return m67invoke__ExYCQ(transformOrigin.getPackedValue());
        }

        /* JADX INFO: renamed from: invoke-__ExYCQ, reason: not valid java name */
        public final AnimationVector2D m67invoke__ExYCQ(long j) {
            return new AnimationVector2D(TransformOrigin.m1968getPivotFractionXimpl(j), TransformOrigin.m1969getPivotFractionYimpl(j));
        }
    }, new Function1<AnimationVector2D, TransformOrigin>() { // from class: androidx.compose.animation.EnterExitTransitionKt$TransformOriginVectorConverter$2
        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ TransformOrigin invoke(AnimationVector2D animationVector2D) {
            return TransformOrigin.m1960boximpl(m68invokeLIALnN8(animationVector2D));
        }

        /* JADX INFO: renamed from: invoke-LIALnN8, reason: not valid java name */
        public final long m68invokeLIALnN8(AnimationVector2D it) {
            Intrinsics.checkNotNullParameter(it, "it");
            return TransformOriginKt.TransformOrigin(it.getV1(), it.getV2());
        }
    });
    private static final MutableState<Float> DefaultAlpha = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(Float.valueOf(1.0f), null, 2, null);
    private static final SpringSpec<Float> DefaultAlphaAndScaleSpring = AnimationSpecKt.spring$default(0.0f, 400.0f, null, 5, null);
    private static final SpringSpec<IntOffset> DefaultOffsetAnimationSpec = AnimationSpecKt.spring$default(0.0f, 400.0f, IntOffset.m3952boximpl(VisibilityThresholdsKt.getVisibilityThreshold(IntOffset.INSTANCE)), 1, null);
    private static final SpringSpec<IntSize> DefaultSizeAnimationSpec = AnimationSpecKt.spring$default(0.0f, 400.0f, IntSize.m3995boximpl(VisibilityThresholdsKt.getVisibilityThreshold(IntSize.INSTANCE)), 1, null);

    /* JADX INFO: compiled from: EnterExitTransition.kt */
    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[EnterExitState.values().length];
            iArr[EnterExitState.Visible.ordinal()] = 1;
            iArr[EnterExitState.PreEnter.ordinal()] = 2;
            iArr[EnterExitState.PostExit.ordinal()] = 3;
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public static /* synthetic */ EnterTransition fadeIn$default(FiniteAnimationSpec finiteAnimationSpec, float f, int i, Object obj) {
        if ((i & 1) != 0) {
            finiteAnimationSpec = AnimationSpecKt.spring$default(0.0f, 400.0f, null, 5, null);
        }
        if ((i & 2) != 0) {
            f = 0.0f;
        }
        return fadeIn(finiteAnimationSpec, f);
    }

    public static final EnterTransition fadeIn(FiniteAnimationSpec<Float> animationSpec, float f) {
        Intrinsics.checkNotNullParameter(animationSpec, "animationSpec");
        return new EnterTransitionImpl(new TransitionData(new Fade(f, animationSpec), null, null, null, 14, null));
    }

    public static /* synthetic */ ExitTransition fadeOut$default(FiniteAnimationSpec finiteAnimationSpec, float f, int i, Object obj) {
        if ((i & 1) != 0) {
            finiteAnimationSpec = AnimationSpecKt.spring$default(0.0f, 400.0f, null, 5, null);
        }
        if ((i & 2) != 0) {
            f = 0.0f;
        }
        return fadeOut(finiteAnimationSpec, f);
    }

    public static final ExitTransition fadeOut(FiniteAnimationSpec<Float> animationSpec, float f) {
        Intrinsics.checkNotNullParameter(animationSpec, "animationSpec");
        return new ExitTransitionImpl(new TransitionData(new Fade(f, animationSpec), null, null, null, 14, null));
    }

    public static /* synthetic */ EnterTransition slideIn$default(FiniteAnimationSpec finiteAnimationSpec, Function1 function1, int i, Object obj) {
        if ((i & 1) != 0) {
            finiteAnimationSpec = AnimationSpecKt.spring$default(0.0f, 400.0f, IntOffset.m3952boximpl(VisibilityThresholdsKt.getVisibilityThreshold(IntOffset.INSTANCE)), 1, null);
        }
        return slideIn(finiteAnimationSpec, function1);
    }

    public static final EnterTransition slideIn(FiniteAnimationSpec<IntOffset> animationSpec, Function1<? super IntSize, IntOffset> initialOffset) {
        Intrinsics.checkNotNullParameter(animationSpec, "animationSpec");
        Intrinsics.checkNotNullParameter(initialOffset, "initialOffset");
        return new EnterTransitionImpl(new TransitionData(null, new Slide(initialOffset, animationSpec), null, null, 13, null));
    }

    public static /* synthetic */ ExitTransition slideOut$default(FiniteAnimationSpec finiteAnimationSpec, Function1 function1, int i, Object obj) {
        if ((i & 1) != 0) {
            finiteAnimationSpec = AnimationSpecKt.spring$default(0.0f, 400.0f, IntOffset.m3952boximpl(VisibilityThresholdsKt.getVisibilityThreshold(IntOffset.INSTANCE)), 1, null);
        }
        return slideOut(finiteAnimationSpec, function1);
    }

    public static final ExitTransition slideOut(FiniteAnimationSpec<IntOffset> animationSpec, Function1<? super IntSize, IntOffset> targetOffset) {
        Intrinsics.checkNotNullParameter(animationSpec, "animationSpec");
        Intrinsics.checkNotNullParameter(targetOffset, "targetOffset");
        return new ExitTransitionImpl(new TransitionData(null, new Slide(targetOffset, animationSpec), null, null, 13, null));
    }

    /* JADX INFO: renamed from: scaleIn-L8ZKh-E$default, reason: not valid java name */
    public static /* synthetic */ EnterTransition m64scaleInL8ZKhE$default(FiniteAnimationSpec finiteAnimationSpec, float f, long j, int i, Object obj) {
        if ((i & 1) != 0) {
            finiteAnimationSpec = AnimationSpecKt.spring$default(0.0f, 400.0f, null, 5, null);
        }
        if ((i & 2) != 0) {
            f = 0.0f;
        }
        if ((i & 4) != 0) {
            j = TransformOrigin.INSTANCE.m1973getCenterSzJe1aQ();
        }
        return m63scaleInL8ZKhE(finiteAnimationSpec, f, j);
    }

    @ExperimentalAnimationApi
    /* JADX INFO: renamed from: scaleIn-L8ZKh-E, reason: not valid java name */
    public static final EnterTransition m63scaleInL8ZKhE(FiniteAnimationSpec<Float> animationSpec, float f, long j) {
        Intrinsics.checkNotNullParameter(animationSpec, "animationSpec");
        return new EnterTransitionImpl(new TransitionData(null, null, null, new Scale(f, j, animationSpec, null), 7, null));
    }

    /* JADX INFO: renamed from: scaleOut-L8ZKh-E$default, reason: not valid java name */
    public static /* synthetic */ ExitTransition m66scaleOutL8ZKhE$default(FiniteAnimationSpec finiteAnimationSpec, float f, long j, int i, Object obj) {
        if ((i & 1) != 0) {
            finiteAnimationSpec = AnimationSpecKt.spring$default(0.0f, 400.0f, null, 5, null);
        }
        if ((i & 2) != 0) {
            f = 0.0f;
        }
        if ((i & 4) != 0) {
            j = TransformOrigin.INSTANCE.m1973getCenterSzJe1aQ();
        }
        return m65scaleOutL8ZKhE(finiteAnimationSpec, f, j);
    }

    @ExperimentalAnimationApi
    /* JADX INFO: renamed from: scaleOut-L8ZKh-E, reason: not valid java name */
    public static final ExitTransition m65scaleOutL8ZKhE(FiniteAnimationSpec<Float> animationSpec, float f, long j) {
        Intrinsics.checkNotNullParameter(animationSpec, "animationSpec");
        return new ExitTransitionImpl(new TransitionData(null, null, null, new Scale(f, j, animationSpec, null), 7, null));
    }

    public static /* synthetic */ EnterTransition expandIn$default(FiniteAnimationSpec finiteAnimationSpec, Alignment alignment, boolean z, Function1 function1, int i, Object obj) {
        if ((i & 1) != 0) {
            finiteAnimationSpec = AnimationSpecKt.spring$default(0.0f, 400.0f, IntSize.m3995boximpl(VisibilityThresholdsKt.getVisibilityThreshold(IntSize.INSTANCE)), 1, null);
        }
        if ((i & 2) != 0) {
            alignment = Alignment.INSTANCE.getBottomEnd();
        }
        if ((i & 4) != 0) {
            z = true;
        }
        if ((i & 8) != 0) {
            function1 = new Function1<IntSize, IntSize>() { // from class: androidx.compose.animation.EnterExitTransitionKt.expandIn.1
                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ IntSize invoke(IntSize intSize) {
                    return IntSize.m3995boximpl(m70invokemzRDjE0(intSize.getPackedValue()));
                }

                /* JADX INFO: renamed from: invoke-mzRDjE0, reason: not valid java name */
                public final long m70invokemzRDjE0(long j) {
                    return IntSizeKt.IntSize(0, 0);
                }
            };
        }
        return expandIn(finiteAnimationSpec, alignment, z, function1);
    }

    public static final EnterTransition expandIn(FiniteAnimationSpec<IntSize> animationSpec, Alignment expandFrom, boolean z, Function1<? super IntSize, IntSize> initialSize) {
        Intrinsics.checkNotNullParameter(animationSpec, "animationSpec");
        Intrinsics.checkNotNullParameter(expandFrom, "expandFrom");
        Intrinsics.checkNotNullParameter(initialSize, "initialSize");
        return new EnterTransitionImpl(new TransitionData(null, null, new ChangeSize(expandFrom, initialSize, animationSpec, z), null, 11, null));
    }

    public static /* synthetic */ ExitTransition shrinkOut$default(FiniteAnimationSpec finiteAnimationSpec, Alignment alignment, boolean z, Function1 function1, int i, Object obj) {
        if ((i & 1) != 0) {
            finiteAnimationSpec = AnimationSpecKt.spring$default(0.0f, 400.0f, IntSize.m3995boximpl(VisibilityThresholdsKt.getVisibilityThreshold(IntSize.INSTANCE)), 1, null);
        }
        if ((i & 2) != 0) {
            alignment = Alignment.INSTANCE.getBottomEnd();
        }
        if ((i & 4) != 0) {
            z = true;
        }
        if ((i & 8) != 0) {
            function1 = new Function1<IntSize, IntSize>() { // from class: androidx.compose.animation.EnterExitTransitionKt.shrinkOut.1
                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ IntSize invoke(IntSize intSize) {
                    return IntSize.m3995boximpl(m75invokemzRDjE0(intSize.getPackedValue()));
                }

                /* JADX INFO: renamed from: invoke-mzRDjE0, reason: not valid java name */
                public final long m75invokemzRDjE0(long j) {
                    return IntSizeKt.IntSize(0, 0);
                }
            };
        }
        return shrinkOut(finiteAnimationSpec, alignment, z, function1);
    }

    public static final ExitTransition shrinkOut(FiniteAnimationSpec<IntSize> animationSpec, Alignment shrinkTowards, boolean z, Function1<? super IntSize, IntSize> targetSize) {
        Intrinsics.checkNotNullParameter(animationSpec, "animationSpec");
        Intrinsics.checkNotNullParameter(shrinkTowards, "shrinkTowards");
        Intrinsics.checkNotNullParameter(targetSize, "targetSize");
        return new ExitTransitionImpl(new TransitionData(null, null, new ChangeSize(shrinkTowards, targetSize, animationSpec, z), null, 11, null));
    }

    public static /* synthetic */ EnterTransition expandHorizontally$default(FiniteAnimationSpec finiteAnimationSpec, Alignment.Horizontal horizontal, boolean z, Function1 function1, int i, Object obj) {
        if ((i & 1) != 0) {
            finiteAnimationSpec = AnimationSpecKt.spring$default(0.0f, 400.0f, IntSize.m3995boximpl(VisibilityThresholdsKt.getVisibilityThreshold(IntSize.INSTANCE)), 1, null);
        }
        if ((i & 2) != 0) {
            horizontal = Alignment.INSTANCE.getEnd();
        }
        if ((i & 4) != 0) {
            z = true;
        }
        if ((i & 8) != 0) {
            function1 = new Function1<Integer, Integer>() { // from class: androidx.compose.animation.EnterExitTransitionKt.expandHorizontally.1
                public final Integer invoke(int i2) {
                    return 0;
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Integer invoke(Integer num) {
                    return invoke(num.intValue());
                }
            };
        }
        return expandHorizontally(finiteAnimationSpec, horizontal, z, function1);
    }

    public static final EnterTransition expandHorizontally(FiniteAnimationSpec<IntSize> animationSpec, Alignment.Horizontal expandFrom, boolean z, final Function1<? super Integer, Integer> initialWidth) {
        Intrinsics.checkNotNullParameter(animationSpec, "animationSpec");
        Intrinsics.checkNotNullParameter(expandFrom, "expandFrom");
        Intrinsics.checkNotNullParameter(initialWidth, "initialWidth");
        return expandIn(animationSpec, toAlignment(expandFrom), z, new Function1<IntSize, IntSize>() { // from class: androidx.compose.animation.EnterExitTransitionKt.expandHorizontally.2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ IntSize invoke(IntSize intSize) {
                return IntSize.m3995boximpl(m69invokemzRDjE0(intSize.getPackedValue()));
            }

            /* JADX INFO: renamed from: invoke-mzRDjE0, reason: not valid java name */
            public final long m69invokemzRDjE0(long j) {
                return IntSizeKt.IntSize(initialWidth.invoke(Integer.valueOf(IntSize.m4003getWidthimpl(j))).intValue(), IntSize.m4002getHeightimpl(j));
            }
        });
    }

    public static /* synthetic */ EnterTransition expandVertically$default(FiniteAnimationSpec finiteAnimationSpec, Alignment.Vertical vertical, boolean z, Function1 function1, int i, Object obj) {
        if ((i & 1) != 0) {
            finiteAnimationSpec = AnimationSpecKt.spring$default(0.0f, 400.0f, IntSize.m3995boximpl(VisibilityThresholdsKt.getVisibilityThreshold(IntSize.INSTANCE)), 1, null);
        }
        if ((i & 2) != 0) {
            vertical = Alignment.INSTANCE.getBottom();
        }
        if ((i & 4) != 0) {
            z = true;
        }
        if ((i & 8) != 0) {
            function1 = new Function1<Integer, Integer>() { // from class: androidx.compose.animation.EnterExitTransitionKt.expandVertically.1
                public final Integer invoke(int i2) {
                    return 0;
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Integer invoke(Integer num) {
                    return invoke(num.intValue());
                }
            };
        }
        return expandVertically(finiteAnimationSpec, vertical, z, function1);
    }

    public static final EnterTransition expandVertically(FiniteAnimationSpec<IntSize> animationSpec, Alignment.Vertical expandFrom, boolean z, final Function1<? super Integer, Integer> initialHeight) {
        Intrinsics.checkNotNullParameter(animationSpec, "animationSpec");
        Intrinsics.checkNotNullParameter(expandFrom, "expandFrom");
        Intrinsics.checkNotNullParameter(initialHeight, "initialHeight");
        return expandIn(animationSpec, toAlignment(expandFrom), z, new Function1<IntSize, IntSize>() { // from class: androidx.compose.animation.EnterExitTransitionKt.expandVertically.2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ IntSize invoke(IntSize intSize) {
                return IntSize.m3995boximpl(m71invokemzRDjE0(intSize.getPackedValue()));
            }

            /* JADX INFO: renamed from: invoke-mzRDjE0, reason: not valid java name */
            public final long m71invokemzRDjE0(long j) {
                return IntSizeKt.IntSize(IntSize.m4003getWidthimpl(j), initialHeight.invoke(Integer.valueOf(IntSize.m4002getHeightimpl(j))).intValue());
            }
        });
    }

    public static /* synthetic */ ExitTransition shrinkHorizontally$default(FiniteAnimationSpec finiteAnimationSpec, Alignment.Horizontal horizontal, boolean z, Function1 function1, int i, Object obj) {
        if ((i & 1) != 0) {
            finiteAnimationSpec = AnimationSpecKt.spring$default(0.0f, 400.0f, IntSize.m3995boximpl(VisibilityThresholdsKt.getVisibilityThreshold(IntSize.INSTANCE)), 1, null);
        }
        if ((i & 2) != 0) {
            horizontal = Alignment.INSTANCE.getEnd();
        }
        if ((i & 4) != 0) {
            z = true;
        }
        if ((i & 8) != 0) {
            function1 = new Function1<Integer, Integer>() { // from class: androidx.compose.animation.EnterExitTransitionKt.shrinkHorizontally.1
                public final Integer invoke(int i2) {
                    return 0;
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Integer invoke(Integer num) {
                    return invoke(num.intValue());
                }
            };
        }
        return shrinkHorizontally(finiteAnimationSpec, horizontal, z, function1);
    }

    public static final ExitTransition shrinkHorizontally(FiniteAnimationSpec<IntSize> animationSpec, Alignment.Horizontal shrinkTowards, boolean z, final Function1<? super Integer, Integer> targetWidth) {
        Intrinsics.checkNotNullParameter(animationSpec, "animationSpec");
        Intrinsics.checkNotNullParameter(shrinkTowards, "shrinkTowards");
        Intrinsics.checkNotNullParameter(targetWidth, "targetWidth");
        return shrinkOut(animationSpec, toAlignment(shrinkTowards), z, new Function1<IntSize, IntSize>() { // from class: androidx.compose.animation.EnterExitTransitionKt.shrinkHorizontally.2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ IntSize invoke(IntSize intSize) {
                return IntSize.m3995boximpl(m74invokemzRDjE0(intSize.getPackedValue()));
            }

            /* JADX INFO: renamed from: invoke-mzRDjE0, reason: not valid java name */
            public final long m74invokemzRDjE0(long j) {
                return IntSizeKt.IntSize(targetWidth.invoke(Integer.valueOf(IntSize.m4003getWidthimpl(j))).intValue(), IntSize.m4002getHeightimpl(j));
            }
        });
    }

    public static /* synthetic */ ExitTransition shrinkVertically$default(FiniteAnimationSpec finiteAnimationSpec, Alignment.Vertical vertical, boolean z, Function1 function1, int i, Object obj) {
        if ((i & 1) != 0) {
            finiteAnimationSpec = AnimationSpecKt.spring$default(0.0f, 400.0f, IntSize.m3995boximpl(VisibilityThresholdsKt.getVisibilityThreshold(IntSize.INSTANCE)), 1, null);
        }
        if ((i & 2) != 0) {
            vertical = Alignment.INSTANCE.getBottom();
        }
        if ((i & 4) != 0) {
            z = true;
        }
        if ((i & 8) != 0) {
            function1 = new Function1<Integer, Integer>() { // from class: androidx.compose.animation.EnterExitTransitionKt.shrinkVertically.1
                public final Integer invoke(int i2) {
                    return 0;
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Integer invoke(Integer num) {
                    return invoke(num.intValue());
                }
            };
        }
        return shrinkVertically(finiteAnimationSpec, vertical, z, function1);
    }

    public static final ExitTransition shrinkVertically(FiniteAnimationSpec<IntSize> animationSpec, Alignment.Vertical shrinkTowards, boolean z, final Function1<? super Integer, Integer> targetHeight) {
        Intrinsics.checkNotNullParameter(animationSpec, "animationSpec");
        Intrinsics.checkNotNullParameter(shrinkTowards, "shrinkTowards");
        Intrinsics.checkNotNullParameter(targetHeight, "targetHeight");
        return shrinkOut(animationSpec, toAlignment(shrinkTowards), z, new Function1<IntSize, IntSize>() { // from class: androidx.compose.animation.EnterExitTransitionKt.shrinkVertically.2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ IntSize invoke(IntSize intSize) {
                return IntSize.m3995boximpl(m76invokemzRDjE0(intSize.getPackedValue()));
            }

            /* JADX INFO: renamed from: invoke-mzRDjE0, reason: not valid java name */
            public final long m76invokemzRDjE0(long j) {
                return IntSizeKt.IntSize(IntSize.m4003getWidthimpl(j), targetHeight.invoke(Integer.valueOf(IntSize.m4002getHeightimpl(j))).intValue());
            }
        });
    }

    public static /* synthetic */ EnterTransition slideInHorizontally$default(FiniteAnimationSpec finiteAnimationSpec, Function1 function1, int i, Object obj) {
        if ((i & 1) != 0) {
            finiteAnimationSpec = AnimationSpecKt.spring$default(0.0f, 400.0f, IntOffset.m3952boximpl(VisibilityThresholdsKt.getVisibilityThreshold(IntOffset.INSTANCE)), 1, null);
        }
        if ((i & 2) != 0) {
            function1 = new Function1<Integer, Integer>() { // from class: androidx.compose.animation.EnterExitTransitionKt.slideInHorizontally.1
                public final Integer invoke(int i2) {
                    return Integer.valueOf((-i2) / 2);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Integer invoke(Integer num) {
                    return invoke(num.intValue());
                }
            };
        }
        return slideInHorizontally(finiteAnimationSpec, function1);
    }

    public static final EnterTransition slideInHorizontally(FiniteAnimationSpec<IntOffset> animationSpec, final Function1<? super Integer, Integer> initialOffsetX) {
        Intrinsics.checkNotNullParameter(animationSpec, "animationSpec");
        Intrinsics.checkNotNullParameter(initialOffsetX, "initialOffsetX");
        return slideIn(animationSpec, new Function1<IntSize, IntOffset>() { // from class: androidx.compose.animation.EnterExitTransitionKt.slideInHorizontally.2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ IntOffset invoke(IntSize intSize) {
                return IntOffset.m3952boximpl(m77invokemHKZG7I(intSize.getPackedValue()));
            }

            /* JADX INFO: renamed from: invoke-mHKZG7I, reason: not valid java name */
            public final long m77invokemHKZG7I(long j) {
                return IntOffsetKt.IntOffset(initialOffsetX.invoke(Integer.valueOf(IntSize.m4003getWidthimpl(j))).intValue(), 0);
            }
        });
    }

    public static /* synthetic */ EnterTransition slideInVertically$default(FiniteAnimationSpec finiteAnimationSpec, Function1 function1, int i, Object obj) {
        if ((i & 1) != 0) {
            finiteAnimationSpec = AnimationSpecKt.spring$default(0.0f, 400.0f, IntOffset.m3952boximpl(VisibilityThresholdsKt.getVisibilityThreshold(IntOffset.INSTANCE)), 1, null);
        }
        if ((i & 2) != 0) {
            function1 = new Function1<Integer, Integer>() { // from class: androidx.compose.animation.EnterExitTransitionKt.slideInVertically.1
                public final Integer invoke(int i2) {
                    return Integer.valueOf((-i2) / 2);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Integer invoke(Integer num) {
                    return invoke(num.intValue());
                }
            };
        }
        return slideInVertically(finiteAnimationSpec, function1);
    }

    public static final EnterTransition slideInVertically(FiniteAnimationSpec<IntOffset> animationSpec, final Function1<? super Integer, Integer> initialOffsetY) {
        Intrinsics.checkNotNullParameter(animationSpec, "animationSpec");
        Intrinsics.checkNotNullParameter(initialOffsetY, "initialOffsetY");
        return slideIn(animationSpec, new Function1<IntSize, IntOffset>() { // from class: androidx.compose.animation.EnterExitTransitionKt.slideInVertically.2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ IntOffset invoke(IntSize intSize) {
                return IntOffset.m3952boximpl(m80invokemHKZG7I(intSize.getPackedValue()));
            }

            /* JADX INFO: renamed from: invoke-mHKZG7I, reason: not valid java name */
            public final long m80invokemHKZG7I(long j) {
                return IntOffsetKt.IntOffset(0, initialOffsetY.invoke(Integer.valueOf(IntSize.m4002getHeightimpl(j))).intValue());
            }
        });
    }

    public static /* synthetic */ ExitTransition slideOutHorizontally$default(FiniteAnimationSpec finiteAnimationSpec, Function1 function1, int i, Object obj) {
        if ((i & 1) != 0) {
            finiteAnimationSpec = AnimationSpecKt.spring$default(0.0f, 400.0f, IntOffset.m3952boximpl(VisibilityThresholdsKt.getVisibilityThreshold(IntOffset.INSTANCE)), 1, null);
        }
        if ((i & 2) != 0) {
            function1 = new Function1<Integer, Integer>() { // from class: androidx.compose.animation.EnterExitTransitionKt.slideOutHorizontally.1
                public final Integer invoke(int i2) {
                    return Integer.valueOf((-i2) / 2);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Integer invoke(Integer num) {
                    return invoke(num.intValue());
                }
            };
        }
        return slideOutHorizontally(finiteAnimationSpec, function1);
    }

    public static final ExitTransition slideOutHorizontally(FiniteAnimationSpec<IntOffset> animationSpec, final Function1<? super Integer, Integer> targetOffsetX) {
        Intrinsics.checkNotNullParameter(animationSpec, "animationSpec");
        Intrinsics.checkNotNullParameter(targetOffsetX, "targetOffsetX");
        return slideOut(animationSpec, new Function1<IntSize, IntOffset>() { // from class: androidx.compose.animation.EnterExitTransitionKt.slideOutHorizontally.2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ IntOffset invoke(IntSize intSize) {
                return IntOffset.m3952boximpl(m81invokemHKZG7I(intSize.getPackedValue()));
            }

            /* JADX INFO: renamed from: invoke-mHKZG7I, reason: not valid java name */
            public final long m81invokemHKZG7I(long j) {
                return IntOffsetKt.IntOffset(targetOffsetX.invoke(Integer.valueOf(IntSize.m4003getWidthimpl(j))).intValue(), 0);
            }
        });
    }

    public static /* synthetic */ ExitTransition slideOutVertically$default(FiniteAnimationSpec finiteAnimationSpec, Function1 function1, int i, Object obj) {
        if ((i & 1) != 0) {
            finiteAnimationSpec = AnimationSpecKt.spring$default(0.0f, 400.0f, IntOffset.m3952boximpl(VisibilityThresholdsKt.getVisibilityThreshold(IntOffset.INSTANCE)), 1, null);
        }
        if ((i & 2) != 0) {
            function1 = new Function1<Integer, Integer>() { // from class: androidx.compose.animation.EnterExitTransitionKt.slideOutVertically.1
                public final Integer invoke(int i2) {
                    return Integer.valueOf((-i2) / 2);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Integer invoke(Integer num) {
                    return invoke(num.intValue());
                }
            };
        }
        return slideOutVertically(finiteAnimationSpec, function1);
    }

    public static final ExitTransition slideOutVertically(FiniteAnimationSpec<IntOffset> animationSpec, final Function1<? super Integer, Integer> targetOffsetY) {
        Intrinsics.checkNotNullParameter(animationSpec, "animationSpec");
        Intrinsics.checkNotNullParameter(targetOffsetY, "targetOffsetY");
        return slideOut(animationSpec, new Function1<IntSize, IntOffset>() { // from class: androidx.compose.animation.EnterExitTransitionKt.slideOutVertically.2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ IntOffset invoke(IntSize intSize) {
                return IntOffset.m3952boximpl(m82invokemHKZG7I(intSize.getPackedValue()));
            }

            /* JADX INFO: renamed from: invoke-mHKZG7I, reason: not valid java name */
            public final long m82invokemHKZG7I(long j) {
                return IntOffsetKt.IntOffset(0, targetOffsetY.invoke(Integer.valueOf(IntSize.m4002getHeightimpl(j))).intValue());
            }
        });
    }

    private static final Alignment toAlignment(Alignment.Horizontal horizontal) {
        if (Intrinsics.areEqual(horizontal, Alignment.INSTANCE.getStart())) {
            return Alignment.INSTANCE.getCenterStart();
        }
        return Intrinsics.areEqual(horizontal, Alignment.INSTANCE.getEnd()) ? Alignment.INSTANCE.getCenterEnd() : Alignment.INSTANCE.getCenter();
    }

    private static final Alignment toAlignment(Alignment.Vertical vertical) {
        if (Intrinsics.areEqual(vertical, Alignment.INSTANCE.getTop())) {
            return Alignment.INSTANCE.getTopCenter();
        }
        return Intrinsics.areEqual(vertical, Alignment.INSTANCE.getBottom()) ? Alignment.INSTANCE.getBottomCenter() : Alignment.INSTANCE.getCenter();
    }

    /* JADX WARN: Code duplicated, block: B:100:0x0398  */
    /* JADX WARN: Code duplicated, block: B:106:0x03b6  */
    /* JADX WARN: Code duplicated, block: B:112:0x03d4  */
    /* JADX WARN: Code duplicated, block: B:115:0x0400  */
    /* JADX WARN: Code duplicated, block: B:117:0x0403  */
    /* JADX WARN: Code duplicated, block: B:119:0x0406  */
    /* JADX WARN: Code duplicated, block: B:125:0x0424  */
    /* JADX WARN: Code duplicated, block: B:127:0x042a  */
    /* JADX WARN: Code duplicated, block: B:133:0x0448  */
    /* JADX WARN: Code duplicated, block: B:134:0x044b  */
    /* JADX WARN: Code duplicated, block: B:136:0x044f  */
    /* JADX WARN: Code duplicated, block: B:137:0x0454  */
    /* JADX WARN: Code duplicated, block: B:140:0x0477 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:141:0x0479  */
    /* JADX WARN: Code duplicated, block: B:143:0x047c  */
    /* JADX WARN: Code duplicated, block: B:149:0x049a  */
    /* JADX WARN: Code duplicated, block: B:151:0x04a0  */
    /* JADX WARN: Code duplicated, block: B:157:0x04be  */
    /* JADX WARN: Code duplicated, block: B:159:0x04c2  */
    /* JADX WARN: Code duplicated, block: B:160:0x04c7  */
    /* JADX WARN: Code duplicated, block: B:46:0x01c2  */
    /* JADX WARN: Code duplicated, block: B:88:0x033c A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:89:0x033e A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:90:0x0340  */
    /* JADX WARN: Code duplicated, block: B:92:0x034a  */
    /* JADX WARN: Code duplicated, block: B:93:0x034f  */
    /* JADX WARN: Code duplicated, block: B:95:0x0355  */
    /* JADX WARN: Code duplicated, block: B:97:0x035f  */
    public static final Modifier createModifier(Transition<EnterExitState> transition, final EnterTransition enter, final ExitTransition exit, String label, Composer composer, int i) {
        String str;
        MutableState mutableState;
        MutableState mutableState2;
        TransformOrigin transformOrigin;
        String str2;
        int i2;
        String str3;
        MutableState<Float> mutableStateCreateTransitionAnimation;
        Modifier modifierGraphicsLayer;
        int i3;
        int i4;
        float scale;
        int i5;
        Scale scale2;
        TransformOrigin transformOriginM1960boximpl;
        int i6;
        int i7;
        TransformOrigin transformOriginM1960boximpl2;
        long jM1973getCenterSzJe1aQ;
        int i8;
        long jM1973getCenterSzJe1aQ2;
        Scale scale3;
        Scale scale4;
        Scale scale5;
        Scale scale6;
        Scale scale7;
        Scale scale8;
        Scale scale9;
        float alpha;
        String str4;
        float alpha2;
        Intrinsics.checkNotNullParameter(transition, "<this>");
        Intrinsics.checkNotNullParameter(enter, "enter");
        Intrinsics.checkNotNullParameter(exit, "exit");
        Intrinsics.checkNotNullParameter(label, "label");
        composer.startReplaceableGroup(914000546);
        ComposerKt.sourceInformation(composer, "C(createModifier)806@35287L38,807@35335L37,811@35430L43,812@35483L42,819@35854L40,820@35925L40,867@37800L27,857@37277L800,883@38570L536:EnterExitTransition.kt#xbi5r1");
        Modifier modifierShrinkExpand = shrinkExpand(slideInOut(Modifier.INSTANCE, transition, SnapshotStateKt.rememberUpdatedState(enter.getData().getSlide(), composer, 0), SnapshotStateKt.rememberUpdatedState(exit.getData().getSlide(), composer, 0), label), transition, SnapshotStateKt.rememberUpdatedState(enter.getData().getChangeSize(), composer, 0), SnapshotStateKt.rememberUpdatedState(exit.getData().getChangeSize(), composer, 0), label);
        int i9 = i & 14;
        composer.startReplaceableGroup(1157296644);
        ComposerKt.sourceInformation(composer, "C(remember)P(1):Composables.kt#9igjgp");
        boolean zChanged = composer.changed(transition);
        Object objRememberedValue = composer.rememberedValue();
        if (zChanged || objRememberedValue == Composer.INSTANCE.getEmpty()) {
            objRememberedValue = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(false, null, 2, null);
            composer.updateRememberedValue(objRememberedValue);
        }
        composer.endReplaceableGroup();
        MutableState mutableState3 = (MutableState) objRememberedValue;
        composer.startReplaceableGroup(1157296644);
        ComposerKt.sourceInformation(composer, "C(remember)P(1):Composables.kt#9igjgp");
        boolean zChanged2 = composer.changed(transition);
        Object objRememberedValue2 = composer.rememberedValue();
        if (zChanged2 || objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
            objRememberedValue2 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(false, null, 2, null);
            composer.updateRememberedValue(objRememberedValue2);
        }
        composer.endReplaceableGroup();
        MutableState mutableState4 = (MutableState) objRememberedValue2;
        if (transition.getCurrentState() != transition.getTargetState() || transition.isSeeking()) {
            if (enter.getData().getFade() != null || exit.getData().getFade() != null) {
                m59createModifier$lambda2(mutableState3, true);
            }
            if (enter.getData().getScale() != null || exit.getData().getScale() != null) {
                m61createModifier$lambda5(mutableState4, true);
            }
        } else {
            m59createModifier$lambda2(mutableState3, false);
            m61createModifier$lambda5(mutableState4, false);
        }
        composer.startReplaceableGroup(1657240548);
        ComposerKt.sourceInformation(composer, "844@36909L27,834@36388L796");
        float scale10 = 1.0f;
        if (m56createModifier$lambda1(mutableState3)) {
            Function3<Transition.Segment<EnterExitState>, Composer, Integer, FiniteAnimationSpec<Float>> function3 = new Function3<Transition.Segment<EnterExitState>, Composer, Integer, FiniteAnimationSpec<Float>>() { // from class: androidx.compose.animation.EnterExitTransitionKt$createModifier$alpha$2
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(3);
                }

                @Override // kotlin.jvm.functions.Function3
                public /* bridge */ /* synthetic */ FiniteAnimationSpec<Float> invoke(Transition.Segment<EnterExitState> segment, Composer composer2, Integer num) {
                    return invoke(segment, composer2, num.intValue());
                }

                public final FiniteAnimationSpec<Float> invoke(Transition.Segment<EnterExitState> animateFloat, Composer composer2, int i10) {
                    SpringSpec animationSpec;
                    Fade fade;
                    Intrinsics.checkNotNullParameter(animateFloat, "$this$animateFloat");
                    composer2.startReplaceableGroup(-57153604);
                    if (animateFloat.isTransitioningTo(EnterExitState.PreEnter, EnterExitState.Visible)) {
                        Fade fade2 = enter.getData().getFade();
                        if (fade2 == null || (animationSpec = fade2.getAnimationSpec()) == null) {
                            animationSpec = EnterExitTransitionKt.DefaultAlphaAndScaleSpring;
                        }
                    } else if (!animateFloat.isTransitioningTo(EnterExitState.Visible, EnterExitState.PostExit) || (fade = exit.getData().getFade()) == null || (animationSpec = fade.getAnimationSpec()) == null) {
                        animationSpec = EnterExitTransitionKt.DefaultAlphaAndScaleSpring;
                    }
                    composer2.endReplaceableGroup();
                    return animationSpec;
                }
            };
            composer.startReplaceableGroup(-492369756);
            ComposerKt.sourceInformation(composer, "C(remember):Composables.kt#9igjgp");
            Object objRememberedValue3 = composer.rememberedValue();
            if (objRememberedValue3 == Composer.INSTANCE.getEmpty()) {
                objRememberedValue3 = label + " alpha";
                composer.updateRememberedValue(objRememberedValue3);
            }
            composer.endReplaceableGroup();
            String str5 = (String) objRememberedValue3;
            composer.startReplaceableGroup(-1338768149);
            ComposerKt.sourceInformation(composer, "C(animateFloat)P(2)933@37134L78:Transition.kt#pdpnli");
            TwoWayConverter<Float, AnimationVector1D> vectorConverter = VectorConvertersKt.getVectorConverter(FloatCompanionObject.INSTANCE);
            int i10 = ((i9 | 384) & 14) | 3072;
            composer.startReplaceableGroup(-142660079);
            ComposerKt.sourceInformation(composer, "C(animateValue)P(3,2)851@33724L32,852@33779L31,853@33835L23,855@33871L89:Transition.kt#pdpnli");
            EnterExitState currentState = transition.getCurrentState();
            composer.startReplaceableGroup(755689166);
            ComposerKt.sourceInformation(composer, "C:EnterExitTransition.kt#xbi5r1");
            int i11 = WhenMappings.$EnumSwitchMapping$0[currentState.ordinal()];
            if (i11 == 1) {
                alpha = 1.0f;
            } else if (i11 == 2) {
                Fade fade = enter.getData().getFade();
                if (fade != null) {
                    alpha = fade.getAlpha();
                } else {
                    alpha = 1.0f;
                }
            } else {
                if (i11 != 3) {
                    throw new NoWhenBranchMatchedException();
                }
                Fade fade2 = exit.getData().getFade();
                if (fade2 != null) {
                    alpha = fade2.getAlpha();
                } else {
                    alpha = 1.0f;
                }
            }
            composer.endReplaceableGroup();
            Float fValueOf = Float.valueOf(alpha);
            EnterExitState targetState = transition.getTargetState();
            composer.startReplaceableGroup(755689166);
            ComposerKt.sourceInformation(composer, "C:EnterExitTransition.kt#xbi5r1");
            int i12 = WhenMappings.$EnumSwitchMapping$0[targetState.ordinal()];
            if (i12 != 1) {
                str4 = "C(remember):Composables.kt#9igjgp";
                if (i12 == 2) {
                    Fade fade3 = enter.getData().getFade();
                    if (fade3 != null) {
                        alpha2 = fade3.getAlpha();
                    }
                } else {
                    if (i12 != 3) {
                        throw new NoWhenBranchMatchedException();
                    }
                    Fade fade4 = exit.getData().getFade();
                    if (fade4 != null) {
                        alpha2 = fade4.getAlpha();
                    }
                }
                composer.endReplaceableGroup();
                str = "C(animateValue)P(3,2)851@33724L32,852@33779L31,853@33835L23,855@33871L89:Transition.kt#pdpnli";
                str3 = "C(animateFloat)P(2)933@37134L78:Transition.kt#pdpnli";
                i2 = -492369756;
                mutableState = mutableState4;
                mutableState2 = mutableState3;
                transformOrigin = null;
                str2 = str4;
                mutableStateCreateTransitionAnimation = androidx.compose.animation.core.TransitionKt.createTransitionAnimation(transition, fValueOf, Float.valueOf(alpha2), function3.invoke(transition.getSegment(), composer, 0), vectorConverter, str5, composer, (i10 & 14) | ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE);
                composer.endReplaceableGroup();
                composer.endReplaceableGroup();
            } else {
                str4 = "C(remember):Composables.kt#9igjgp";
            }
            alpha2 = 1.0f;
            composer.endReplaceableGroup();
            str = "C(animateValue)P(3,2)851@33724L32,852@33779L31,853@33835L23,855@33871L89:Transition.kt#pdpnli";
            str3 = "C(animateFloat)P(2)933@37134L78:Transition.kt#pdpnli";
            i2 = -492369756;
            mutableState = mutableState4;
            mutableState2 = mutableState3;
            transformOrigin = null;
            str2 = str4;
            mutableStateCreateTransitionAnimation = androidx.compose.animation.core.TransitionKt.createTransitionAnimation(transition, fValueOf, Float.valueOf(alpha2), function3.invoke(transition.getSegment(), composer, 0), vectorConverter, str5, composer, (i10 & 14) | ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE);
            composer.endReplaceableGroup();
            composer.endReplaceableGroup();
        } else {
            str = "C(animateValue)P(3,2)851@33724L32,852@33779L31,853@33835L23,855@33871L89:Transition.kt#pdpnli";
            mutableState = mutableState4;
            mutableState2 = mutableState3;
            transformOrigin = null;
            str2 = "C(remember):Composables.kt#9igjgp";
            i2 = -492369756;
            str3 = "C(animateFloat)P(2)933@37134L78:Transition.kt#pdpnli";
            mutableStateCreateTransitionAnimation = DefaultAlpha;
        }
        final State state = mutableStateCreateTransitionAnimation;
        composer.endReplaceableGroup();
        if (m60createModifier$lambda4(mutableState)) {
            Function3<Transition.Segment<EnterExitState>, Composer, Integer, FiniteAnimationSpec<Float>> function4 = new Function3<Transition.Segment<EnterExitState>, Composer, Integer, FiniteAnimationSpec<Float>>() { // from class: androidx.compose.animation.EnterExitTransitionKt$createModifier$scale$2
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(3);
                }

                @Override // kotlin.jvm.functions.Function3
                public /* bridge */ /* synthetic */ FiniteAnimationSpec<Float> invoke(Transition.Segment<EnterExitState> segment, Composer composer2, Integer num) {
                    return invoke(segment, composer2, num.intValue());
                }

                public final FiniteAnimationSpec<Float> invoke(Transition.Segment<EnterExitState> animateFloat, Composer composer2, int i13) {
                    SpringSpec animationSpec;
                    Scale scale11;
                    Intrinsics.checkNotNullParameter(animateFloat, "$this$animateFloat");
                    composer2.startReplaceableGroup(-53984035);
                    if (animateFloat.isTransitioningTo(EnterExitState.PreEnter, EnterExitState.Visible)) {
                        Scale scale12 = enter.getData().getScale();
                        if (scale12 == null || (animationSpec = scale12.getAnimationSpec()) == null) {
                            animationSpec = EnterExitTransitionKt.DefaultAlphaAndScaleSpring;
                        }
                    } else if (!animateFloat.isTransitioningTo(EnterExitState.Visible, EnterExitState.PostExit) || (scale11 = exit.getData().getScale()) == null || (animationSpec = scale11.getAnimationSpec()) == null) {
                        animationSpec = EnterExitTransitionKt.DefaultAlphaAndScaleSpring;
                    }
                    composer2.endReplaceableGroup();
                    return animationSpec;
                }
            };
            composer.startReplaceableGroup(i2);
            ComposerKt.sourceInformation(composer, str2);
            Object objRememberedValue4 = composer.rememberedValue();
            if (objRememberedValue4 == Composer.INSTANCE.getEmpty()) {
                objRememberedValue4 = label + " scale";
                composer.updateRememberedValue(objRememberedValue4);
            }
            composer.endReplaceableGroup();
            String str6 = (String) objRememberedValue4;
            composer.startReplaceableGroup(-1338768149);
            ComposerKt.sourceInformation(composer, str3);
            TwoWayConverter<Float, AnimationVector1D> vectorConverter2 = VectorConvertersKt.getVectorConverter(FloatCompanionObject.INSTANCE);
            int i13 = ((i9 | 384) & 14) | 3072;
            composer.startReplaceableGroup(-142660079);
            ComposerKt.sourceInformation(composer, str);
            EnterExitState currentState2 = transition.getCurrentState();
            composer.startReplaceableGroup(-596129937);
            ComposerKt.sourceInformation(composer, "C:EnterExitTransition.kt#xbi5r1");
            int i14 = WhenMappings.$EnumSwitchMapping$0[currentState2.ordinal()];
            if (i14 != 1) {
                i3 = 2;
                if (i14 != 2) {
                    i4 = 3;
                    if (i14 != 3) {
                        throw new NoWhenBranchMatchedException();
                    }
                    Scale scale11 = exit.getData().getScale();
                    if (scale11 != null) {
                        scale = scale11.getScale();
                    }
                } else {
                    i4 = 3;
                    Scale scale12 = enter.getData().getScale();
                    if (scale12 != null) {
                        scale = scale12.getScale();
                    }
                }
                composer.endReplaceableGroup();
                Float fValueOf2 = Float.valueOf(scale);
                EnterExitState targetState2 = transition.getTargetState();
                composer.startReplaceableGroup(-596129937);
                ComposerKt.sourceInformation(composer, "C:EnterExitTransition.kt#xbi5r1");
                i5 = WhenMappings.$EnumSwitchMapping$0[targetState2.ordinal()];
                if (i5 != 1) {
                    if (i5 != i3) {
                        scale8 = enter.getData().getScale();
                        if (scale8 != null) {
                            scale10 = scale8.getScale();
                        }
                    } else {
                        if (i5 == i4) {
                            throw new NoWhenBranchMatchedException();
                        }
                        scale9 = exit.getData().getScale();
                        if (scale9 != null) {
                            scale10 = scale9.getScale();
                        }
                    }
                }
                composer.endReplaceableGroup();
                final State stateCreateTransitionAnimation = androidx.compose.animation.core.TransitionKt.createTransitionAnimation(transition, fValueOf2, Float.valueOf(scale10), function4.invoke(transition.getSegment(), composer, 0), vectorConverter2, str6, composer, (i13 & 14) | ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE);
                composer.endReplaceableGroup();
                composer.endReplaceableGroup();
                if (transition.getCurrentState() == EnterExitState.PreEnter) {
                    scale7 = enter.getData().getScale();
                    if (scale7 == null && (scale7 = exit.getData().getScale()) == null) {
                        transformOriginM1960boximpl = transformOrigin;
                    } else {
                        transformOriginM1960boximpl = TransformOrigin.m1960boximpl(scale7.m90getTransformOriginSzJe1aQ());
                    }
                } else {
                    scale2 = exit.getData().getScale();
                    if (scale2 == null && (scale2 = enter.getData().getScale()) == null) {
                        transformOriginM1960boximpl = transformOrigin;
                    } else {
                        transformOriginM1960boximpl = TransformOrigin.m1960boximpl(scale2.m90getTransformOriginSzJe1aQ());
                    }
                }
                TwoWayConverter<TransformOrigin, AnimationVector2D> twoWayConverter = TransformOriginVectorConverter;
                int i15 = i9 | 3136;
                composer.startReplaceableGroup(-142660079);
                ComposerKt.sourceInformation(composer, str);
                EnterExitTransitionKt$createModifier$$inlined$animateValue$1 enterExitTransitionKt$createModifier$$inlined$animateValue$1 = new Function3<Transition.Segment<EnterExitState>, Composer, Integer, SpringSpec<TransformOrigin>>() { // from class: androidx.compose.animation.EnterExitTransitionKt$createModifier$$inlined$animateValue$1
                    public final SpringSpec<TransformOrigin> invoke(Transition.Segment<EnterExitState> segment, Composer composer2, int i16) {
                        Intrinsics.checkNotNullParameter(segment, "$this$null");
                        composer2.startReplaceableGroup(-895531546);
                        SpringSpec<TransformOrigin> springSpecSpring$default = AnimationSpecKt.spring$default(0.0f, 0.0f, null, 7, null);
                        composer2.endReplaceableGroup();
                        return springSpecSpring$default;
                    }

                    @Override // kotlin.jvm.functions.Function3
                    public /* bridge */ /* synthetic */ SpringSpec<TransformOrigin> invoke(Transition.Segment<EnterExitState> segment, Composer composer2, Integer num) {
                        return invoke(segment, composer2, num.intValue());
                    }
                };
                EnterExitState currentState3 = transition.getCurrentState();
                composer.startReplaceableGroup(-288165413);
                ComposerKt.sourceInformation(composer, "C:EnterExitTransition.kt#xbi5r1");
                i6 = WhenMappings.$EnumSwitchMapping$0[currentState3.ordinal()];
                if (i6 != 1) {
                    i7 = 2;
                    if (i6 != 2) {
                        scale5 = enter.getData().getScale();
                        if (scale5 == null && (scale5 = exit.getData().getScale()) == null) {
                            transformOriginM1960boximpl2 = transformOrigin;
                        } else {
                            transformOriginM1960boximpl2 = TransformOrigin.m1960boximpl(scale5.m90getTransformOriginSzJe1aQ());
                        }
                    } else {
                        if (i6 == 3) {
                            throw new NoWhenBranchMatchedException();
                        }
                        scale6 = exit.getData().getScale();
                        if (scale6 == null && (scale6 = enter.getData().getScale()) == null) {
                            transformOriginM1960boximpl2 = transformOrigin;
                        } else {
                            transformOriginM1960boximpl2 = TransformOrigin.m1960boximpl(scale6.m90getTransformOriginSzJe1aQ());
                        }
                    }
                } else {
                    i7 = 2;
                    transformOriginM1960boximpl2 = transformOriginM1960boximpl;
                }
                if (transformOriginM1960boximpl2 != null) {
                    jM1973getCenterSzJe1aQ = transformOriginM1960boximpl2.getPackedValue();
                } else {
                    jM1973getCenterSzJe1aQ = TransformOrigin.INSTANCE.m1973getCenterSzJe1aQ();
                }
                composer.endReplaceableGroup();
                TransformOrigin transformOriginM1960boximpl3 = TransformOrigin.m1960boximpl(jM1973getCenterSzJe1aQ);
                EnterExitState targetState3 = transition.getTargetState();
                composer.startReplaceableGroup(-288165413);
                ComposerKt.sourceInformation(composer, "C:EnterExitTransition.kt#xbi5r1");
                i8 = WhenMappings.$EnumSwitchMapping$0[targetState3.ordinal()];
                if (i8 != 1) {
                    if (i8 != i7) {
                        scale3 = enter.getData().getScale();
                        if (scale3 == null && (scale3 = exit.getData().getScale()) == null) {
                            transformOriginM1960boximpl = transformOrigin;
                        } else {
                            transformOriginM1960boximpl = TransformOrigin.m1960boximpl(scale3.m90getTransformOriginSzJe1aQ());
                        }
                    } else {
                        if (i8 == 3) {
                            throw new NoWhenBranchMatchedException();
                        }
                        scale4 = exit.getData().getScale();
                        if (scale4 == null && (scale4 = enter.getData().getScale()) == null) {
                            transformOriginM1960boximpl = transformOrigin;
                        } else {
                            transformOriginM1960boximpl = TransformOrigin.m1960boximpl(scale4.m90getTransformOriginSzJe1aQ());
                        }
                    }
                }
                if (transformOriginM1960boximpl != null) {
                    jM1973getCenterSzJe1aQ2 = transformOriginM1960boximpl.getPackedValue();
                } else {
                    jM1973getCenterSzJe1aQ2 = TransformOrigin.INSTANCE.m1973getCenterSzJe1aQ();
                }
                composer.endReplaceableGroup();
                final State stateCreateTransitionAnimation2 = androidx.compose.animation.core.TransitionKt.createTransitionAnimation(transition, transformOriginM1960boximpl3, TransformOrigin.m1960boximpl(jM1973getCenterSzJe1aQ2), enterExitTransitionKt$createModifier$$inlined$animateValue$1.invoke(transition.getSegment(), composer, 0), twoWayConverter, "TransformOriginInterruptionHandling", composer, (i15 & 14) | 229376);
                composer.endReplaceableGroup();
                modifierGraphicsLayer = GraphicsLayerModifierKt.graphicsLayer(modifierShrinkExpand, new Function1<GraphicsLayerScope, Unit>() { // from class: androidx.compose.animation.EnterExitTransitionKt.createModifier.1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(GraphicsLayerScope graphicsLayerScope) {
                        invoke2(graphicsLayerScope);
                        return Unit.INSTANCE;
                    }

                    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(GraphicsLayerScope graphicsLayer) {
                        Intrinsics.checkNotNullParameter(graphicsLayer, "$this$graphicsLayer");
                        graphicsLayer.setAlpha(EnterExitTransitionKt.m62createModifier$lambda8(state));
                        graphicsLayer.setScaleX(EnterExitTransitionKt.m57createModifier$lambda11(stateCreateTransitionAnimation));
                        graphicsLayer.setScaleY(EnterExitTransitionKt.m57createModifier$lambda11(stateCreateTransitionAnimation));
                        graphicsLayer.mo1792setTransformOrigin__ExYCQ(EnterExitTransitionKt.m58createModifier$lambda13(stateCreateTransitionAnimation2));
                    }
                });
            } else {
                i3 = 2;
                i4 = 3;
            }
            scale = 1.0f;
            composer.endReplaceableGroup();
            Float fValueOf3 = Float.valueOf(scale);
            EnterExitState targetState4 = transition.getTargetState();
            composer.startReplaceableGroup(-596129937);
            ComposerKt.sourceInformation(composer, "C:EnterExitTransition.kt#xbi5r1");
            i5 = WhenMappings.$EnumSwitchMapping$0[targetState4.ordinal()];
            if (i5 != 1) {
                if (i5 != i3) {
                    scale8 = enter.getData().getScale();
                    if (scale8 != null) {
                        scale10 = scale8.getScale();
                    }
                } else {
                    if (i5 == i4) {
                        throw new NoWhenBranchMatchedException();
                    }
                    scale9 = exit.getData().getScale();
                    if (scale9 != null) {
                        scale10 = scale9.getScale();
                    }
                }
            }
            composer.endReplaceableGroup();
            final State<Float> stateCreateTransitionAnimation3 = androidx.compose.animation.core.TransitionKt.createTransitionAnimation(transition, fValueOf3, Float.valueOf(scale10), function4.invoke(transition.getSegment(), composer, 0), vectorConverter2, str6, composer, (i13 & 14) | ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE);
            composer.endReplaceableGroup();
            composer.endReplaceableGroup();
            if (transition.getCurrentState() == EnterExitState.PreEnter) {
                scale7 = enter.getData().getScale();
                if (scale7 == null) {
                    transformOriginM1960boximpl = transformOrigin;
                }
                transformOriginM1960boximpl = TransformOrigin.m1960boximpl(scale7.m90getTransformOriginSzJe1aQ());
            } else {
                scale2 = exit.getData().getScale();
                if (scale2 == null) {
                    transformOriginM1960boximpl = transformOrigin;
                }
                transformOriginM1960boximpl = TransformOrigin.m1960boximpl(scale2.m90getTransformOriginSzJe1aQ());
            }
            TwoWayConverter<TransformOrigin, AnimationVector2D> twoWayConverter2 = TransformOriginVectorConverter;
            int i16 = i9 | 3136;
            composer.startReplaceableGroup(-142660079);
            ComposerKt.sourceInformation(composer, str);
            EnterExitTransitionKt$createModifier$$inlined$animateValue$1 enterExitTransitionKt$createModifier$$inlined$animateValue$2 = new Function3<Transition.Segment<EnterExitState>, Composer, Integer, SpringSpec<TransformOrigin>>() { // from class: androidx.compose.animation.EnterExitTransitionKt$createModifier$$inlined$animateValue$1
                public final SpringSpec<TransformOrigin> invoke(Transition.Segment<EnterExitState> segment, Composer composer2, int i17) {
                    Intrinsics.checkNotNullParameter(segment, "$this$null");
                    composer2.startReplaceableGroup(-895531546);
                    SpringSpec<TransformOrigin> springSpecSpring$default = AnimationSpecKt.spring$default(0.0f, 0.0f, null, 7, null);
                    composer2.endReplaceableGroup();
                    return springSpecSpring$default;
                }

                @Override // kotlin.jvm.functions.Function3
                public /* bridge */ /* synthetic */ SpringSpec<TransformOrigin> invoke(Transition.Segment<EnterExitState> segment, Composer composer2, Integer num) {
                    return invoke(segment, composer2, num.intValue());
                }
            };
            EnterExitState currentState4 = transition.getCurrentState();
            composer.startReplaceableGroup(-288165413);
            ComposerKt.sourceInformation(composer, "C:EnterExitTransition.kt#xbi5r1");
            i6 = WhenMappings.$EnumSwitchMapping$0[currentState4.ordinal()];
            if (i6 != 1) {
                i7 = 2;
                if (i6 != 2) {
                    scale5 = enter.getData().getScale();
                    if (scale5 == null) {
                        transformOriginM1960boximpl2 = transformOrigin;
                    }
                    transformOriginM1960boximpl2 = TransformOrigin.m1960boximpl(scale5.m90getTransformOriginSzJe1aQ());
                } else {
                    if (i6 == 3) {
                        throw new NoWhenBranchMatchedException();
                    }
                    scale6 = exit.getData().getScale();
                    if (scale6 == null) {
                        transformOriginM1960boximpl2 = transformOrigin;
                    }
                    transformOriginM1960boximpl2 = TransformOrigin.m1960boximpl(scale6.m90getTransformOriginSzJe1aQ());
                }
            } else {
                i7 = 2;
                transformOriginM1960boximpl2 = transformOriginM1960boximpl;
            }
            if (transformOriginM1960boximpl2 != null) {
                jM1973getCenterSzJe1aQ = transformOriginM1960boximpl2.getPackedValue();
            } else {
                jM1973getCenterSzJe1aQ = TransformOrigin.INSTANCE.m1973getCenterSzJe1aQ();
            }
            composer.endReplaceableGroup();
            TransformOrigin transformOriginM1960boximpl4 = TransformOrigin.m1960boximpl(jM1973getCenterSzJe1aQ);
            EnterExitState targetState5 = transition.getTargetState();
            composer.startReplaceableGroup(-288165413);
            ComposerKt.sourceInformation(composer, "C:EnterExitTransition.kt#xbi5r1");
            i8 = WhenMappings.$EnumSwitchMapping$0[targetState5.ordinal()];
            if (i8 != 1) {
                if (i8 != i7) {
                    scale3 = enter.getData().getScale();
                    if (scale3 == null) {
                        transformOriginM1960boximpl = transformOrigin;
                    }
                    transformOriginM1960boximpl = TransformOrigin.m1960boximpl(scale3.m90getTransformOriginSzJe1aQ());
                } else {
                    if (i8 == 3) {
                        throw new NoWhenBranchMatchedException();
                    }
                    scale4 = exit.getData().getScale();
                    if (scale4 == null) {
                        transformOriginM1960boximpl = transformOrigin;
                    }
                    transformOriginM1960boximpl = TransformOrigin.m1960boximpl(scale4.m90getTransformOriginSzJe1aQ());
                }
            }
            if (transformOriginM1960boximpl != null) {
                jM1973getCenterSzJe1aQ2 = transformOriginM1960boximpl.getPackedValue();
            } else {
                jM1973getCenterSzJe1aQ2 = TransformOrigin.INSTANCE.m1973getCenterSzJe1aQ();
            }
            composer.endReplaceableGroup();
            final State<TransformOrigin> stateCreateTransitionAnimation4 = androidx.compose.animation.core.TransitionKt.createTransitionAnimation(transition, transformOriginM1960boximpl4, TransformOrigin.m1960boximpl(jM1973getCenterSzJe1aQ2), enterExitTransitionKt$createModifier$$inlined$animateValue$2.invoke(transition.getSegment(), composer, 0), twoWayConverter2, "TransformOriginInterruptionHandling", composer, (i16 & 14) | 229376);
            composer.endReplaceableGroup();
            modifierGraphicsLayer = GraphicsLayerModifierKt.graphicsLayer(modifierShrinkExpand, new Function1<GraphicsLayerScope, Unit>() { // from class: androidx.compose.animation.EnterExitTransitionKt.createModifier.1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(GraphicsLayerScope graphicsLayerScope) {
                    invoke2(graphicsLayerScope);
                    return Unit.INSTANCE;
                }

                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(GraphicsLayerScope graphicsLayer) {
                    Intrinsics.checkNotNullParameter(graphicsLayer, "$this$graphicsLayer");
                    graphicsLayer.setAlpha(EnterExitTransitionKt.m62createModifier$lambda8(state));
                    graphicsLayer.setScaleX(EnterExitTransitionKt.m57createModifier$lambda11(stateCreateTransitionAnimation3));
                    graphicsLayer.setScaleY(EnterExitTransitionKt.m57createModifier$lambda11(stateCreateTransitionAnimation3));
                    graphicsLayer.mo1792setTransformOrigin__ExYCQ(EnterExitTransitionKt.m58createModifier$lambda13(stateCreateTransitionAnimation4));
                }
            });
        } else {
            modifierGraphicsLayer = m56createModifier$lambda1(mutableState2) ? GraphicsLayerModifierKt.graphicsLayer(modifierShrinkExpand, new Function1<GraphicsLayerScope, Unit>() { // from class: androidx.compose.animation.EnterExitTransitionKt.createModifier.2
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(GraphicsLayerScope graphicsLayerScope) {
                    invoke2(graphicsLayerScope);
                    return Unit.INSTANCE;
                }

                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(GraphicsLayerScope graphicsLayer) {
                    Intrinsics.checkNotNullParameter(graphicsLayer, "$this$graphicsLayer");
                    graphicsLayer.setAlpha(EnterExitTransitionKt.m62createModifier$lambda8(state));
                }
            }) : modifierShrinkExpand;
        }
        composer.endReplaceableGroup();
        return modifierGraphicsLayer;
    }

    /* JADX INFO: renamed from: createModifier$lambda-1, reason: not valid java name */
    private static final boolean m56createModifier$lambda1(MutableState<Boolean> mutableState) {
        return mutableState.getValue().booleanValue();
    }

    /* JADX INFO: renamed from: createModifier$lambda-2, reason: not valid java name */
    private static final void m59createModifier$lambda2(MutableState<Boolean> mutableState, boolean z) {
        mutableState.setValue(Boolean.valueOf(z));
    }

    /* JADX INFO: renamed from: createModifier$lambda-4, reason: not valid java name */
    private static final boolean m60createModifier$lambda4(MutableState<Boolean> mutableState) {
        return mutableState.getValue().booleanValue();
    }

    /* JADX INFO: renamed from: createModifier$lambda-5, reason: not valid java name */
    private static final void m61createModifier$lambda5(MutableState<Boolean> mutableState, boolean z) {
        mutableState.setValue(Boolean.valueOf(z));
    }

    private static final Modifier slideInOut(Modifier modifier, final Transition<EnterExitState> transition, final State<Slide> state, final State<Slide> state2, final String str) {
        return ComposedModifierKt.composed$default(modifier, null, new Function3<Modifier, Composer, Integer, Modifier>() { // from class: androidx.compose.animation.EnterExitTransitionKt.slideInOut.1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(3);
            }

            @Override // kotlin.jvm.functions.Function3
            public /* bridge */ /* synthetic */ Modifier invoke(Modifier modifier2, Composer composer, Integer num) {
                return invoke(modifier2, composer, num.intValue());
            }

            /* JADX INFO: renamed from: invoke$lambda-1, reason: not valid java name */
            private static final boolean m78invoke$lambda1(MutableState<Boolean> mutableState) {
                return mutableState.getValue().booleanValue();
            }

            /* JADX INFO: renamed from: invoke$lambda-2, reason: not valid java name */
            private static final void m79invoke$lambda2(MutableState<Boolean> mutableState, boolean z) {
                mutableState.setValue(Boolean.valueOf(z));
            }

            public final Modifier invoke(Modifier composed, Composer composer, int i) {
                Intrinsics.checkNotNullParameter(composed, "$this$composed");
                composer.startReplaceableGroup(158379472);
                ComposerKt.sourceInformation(composer, "C928@40296L46,940@40721L33,938@40645L119,942@40788L88:EnterExitTransition.kt#xbi5r1");
                Transition<EnterExitState> transition2 = transition;
                composer.startReplaceableGroup(1157296644);
                ComposerKt.sourceInformation(composer, "C(remember)P(1):Composables.kt#9igjgp");
                boolean zChanged = composer.changed(transition2);
                Object objRememberedValue = composer.rememberedValue();
                if (zChanged || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(false, null, 2, null);
                    composer.updateRememberedValue(objRememberedValue);
                }
                composer.endReplaceableGroup();
                MutableState mutableState = (MutableState) objRememberedValue;
                if (transition.getCurrentState() == transition.getTargetState() && !transition.isSeeking()) {
                    m79invoke$lambda2(mutableState, false);
                } else if (state.getValue() != null || state2.getValue() != null) {
                    m79invoke$lambda2(mutableState, true);
                }
                if (m78invoke$lambda1(mutableState)) {
                    Transition<EnterExitState> transition3 = transition;
                    TwoWayConverter<IntOffset, AnimationVector2D> vectorConverter = VectorConvertersKt.getVectorConverter(IntOffset.INSTANCE);
                    String str2 = str;
                    composer.startReplaceableGroup(-492369756);
                    ComposerKt.sourceInformation(composer, "C(remember):Composables.kt#9igjgp");
                    Object objRememberedValue2 = composer.rememberedValue();
                    if (objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                        objRememberedValue2 = str2 + " slide";
                        composer.updateRememberedValue(objRememberedValue2);
                    }
                    composer.endReplaceableGroup();
                    Transition.DeferredAnimation deferredAnimationCreateDeferredAnimation = androidx.compose.animation.core.TransitionKt.createDeferredAnimation(transition3, vectorConverter, (String) objRememberedValue2, composer, 448, 0);
                    Transition<EnterExitState> transition4 = transition;
                    State<Slide> state3 = state;
                    State<Slide> state4 = state2;
                    composer.startReplaceableGroup(1157296644);
                    ComposerKt.sourceInformation(composer, "C(remember)P(1):Composables.kt#9igjgp");
                    boolean zChanged2 = composer.changed(transition4);
                    Object objRememberedValue3 = composer.rememberedValue();
                    if (zChanged2 || objRememberedValue3 == Composer.INSTANCE.getEmpty()) {
                        objRememberedValue3 = new SlideModifier(deferredAnimationCreateDeferredAnimation, state3, state4);
                        composer.updateRememberedValue(objRememberedValue3);
                    }
                    composer.endReplaceableGroup();
                    composed = composed.then((SlideModifier) objRememberedValue3);
                }
                composer.endReplaceableGroup();
                return composed;
            }
        }, 1, null);
    }

    private static final Modifier shrinkExpand(Modifier modifier, final Transition<EnterExitState> transition, final State<ChangeSize> state, final State<ChangeSize> state2, final String str) {
        return ComposedModifierKt.composed$default(modifier, null, new Function3<Modifier, Composer, Integer, Modifier>() { // from class: androidx.compose.animation.EnterExitTransitionKt.shrinkExpand.1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(3);
            }

            @Override // kotlin.jvm.functions.Function3
            public /* bridge */ /* synthetic */ Modifier invoke(Modifier modifier2, Composer composer, Integer num) {
                return invoke(modifier2, composer, num.intValue());
            }

            /* JADX INFO: renamed from: invoke$lambda-1, reason: not valid java name */
            private static final boolean m72invoke$lambda1(MutableState<Boolean> mutableState) {
                return mutableState.getValue().booleanValue();
            }

            /* JADX INFO: renamed from: invoke$lambda-2, reason: not valid java name */
            private static final void m73invoke$lambda2(MutableState<Boolean> mutableState, boolean z) {
                mutableState.setValue(Boolean.valueOf(z));
            }

            /* JADX WARN: Code duplicated, block: B:35:0x00c6  */
            public final Modifier invoke(Modifier modifier2, Composer composer, int i) {
                Alignment alignment;
                ChangeSize value;
                Modifier composed = modifier2;
                Intrinsics.checkNotNullParameter(composed, "$this$composed");
                composer.startReplaceableGroup(-140634085);
                ComposerKt.sourceInformation(composer, "C1011@43374L46,1021@43728L396,1034@44238L41,1032@44164L125,1043@44599L218:EnterExitTransition.kt#xbi5r1");
                Transition<EnterExitState> transition2 = transition;
                composer.startReplaceableGroup(1157296644);
                ComposerKt.sourceInformation(composer, "C(remember)P(1):Composables.kt#9igjgp");
                boolean zChanged = composer.changed(transition2);
                Object objRememberedValue = composer.rememberedValue();
                if (zChanged || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(false, null, 2, null);
                    composer.updateRememberedValue(objRememberedValue);
                }
                composer.endReplaceableGroup();
                MutableState mutableState = (MutableState) objRememberedValue;
                if (transition.getCurrentState() == transition.getTargetState() && !transition.isSeeking()) {
                    m73invoke$lambda2(mutableState, false);
                } else if (state.getValue() != null || state2.getValue() != null) {
                    m73invoke$lambda2(mutableState, true);
                }
                if (m72invoke$lambda1(mutableState)) {
                    boolean zIsTransitioningTo = transition.getSegment().isTransitioningTo(EnterExitState.PreEnter, EnterExitState.Visible);
                    State<ChangeSize> state3 = state;
                    State<ChangeSize> state4 = state2;
                    if (zIsTransitioningTo) {
                        ChangeSize value2 = state3.getValue();
                        if (value2 == null || (alignment = value2.getAlignment()) == null) {
                            ChangeSize value3 = state4.getValue();
                            if (value3 != null) {
                                alignment = value3.getAlignment();
                            } else {
                                alignment = null;
                            }
                        }
                    } else {
                        ChangeSize value4 = state4.getValue();
                        if (value4 == null || (alignment = value4.getAlignment()) == null) {
                            ChangeSize value5 = state3.getValue();
                            if (value5 != null) {
                                alignment = value5.getAlignment();
                            } else {
                                alignment = null;
                            }
                        }
                    }
                    State stateRememberUpdatedState = SnapshotStateKt.rememberUpdatedState(alignment, composer, 0);
                    Transition<EnterExitState> transition3 = transition;
                    TwoWayConverter<IntSize, AnimationVector2D> vectorConverter = VectorConvertersKt.getVectorConverter(IntSize.INSTANCE);
                    String str2 = str;
                    composer.startReplaceableGroup(-492369756);
                    ComposerKt.sourceInformation(composer, "C(remember):Composables.kt#9igjgp");
                    Object objRememberedValue2 = composer.rememberedValue();
                    if (objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                        objRememberedValue2 = str2 + " shrink/expand";
                        composer.updateRememberedValue(objRememberedValue2);
                    }
                    composer.endReplaceableGroup();
                    Transition.DeferredAnimation deferredAnimationCreateDeferredAnimation = androidx.compose.animation.core.TransitionKt.createDeferredAnimation(transition3, vectorConverter, (String) objRememberedValue2, composer, 448, 0);
                    composer.startMovableGroup(-1553214637, Boolean.valueOf(transition.getCurrentState() == transition.getTargetState()));
                    ComposerKt.sourceInformation(composer, "1039@44484L54,1037@44400L152");
                    Transition<EnterExitState> transition4 = transition;
                    TwoWayConverter<IntOffset, AnimationVector2D> vectorConverter2 = VectorConvertersKt.getVectorConverter(IntOffset.INSTANCE);
                    String str3 = str;
                    composer.startReplaceableGroup(-492369756);
                    ComposerKt.sourceInformation(composer, "C(remember):Composables.kt#9igjgp");
                    Object objRememberedValue3 = composer.rememberedValue();
                    if (objRememberedValue3 == Composer.INSTANCE.getEmpty()) {
                        objRememberedValue3 = str3 + " InterruptionHandlingOffset";
                        composer.updateRememberedValue(objRememberedValue3);
                    }
                    composer.endReplaceableGroup();
                    Transition.DeferredAnimation deferredAnimationCreateDeferredAnimation2 = androidx.compose.animation.core.TransitionKt.createDeferredAnimation(transition4, vectorConverter2, (String) objRememberedValue3, composer, 448, 0);
                    composer.endMovableGroup();
                    Transition<EnterExitState> transition5 = transition;
                    State<ChangeSize> state5 = state;
                    State<ChangeSize> state6 = state2;
                    composer.startReplaceableGroup(1157296644);
                    ComposerKt.sourceInformation(composer, "C(remember)P(1):Composables.kt#9igjgp");
                    boolean zChanged2 = composer.changed(transition5);
                    Object objRememberedValue4 = composer.rememberedValue();
                    if (zChanged2 || objRememberedValue4 == Composer.INSTANCE.getEmpty()) {
                        objRememberedValue4 = new ExpandShrinkModifier(deferredAnimationCreateDeferredAnimation, deferredAnimationCreateDeferredAnimation2, state5, state6, stateRememberUpdatedState);
                        composer.updateRememberedValue(objRememberedValue4);
                    }
                    composer.endReplaceableGroup();
                    ExpandShrinkModifier expandShrinkModifier = (ExpandShrinkModifier) objRememberedValue4;
                    if (transition.getCurrentState() == transition.getTargetState()) {
                        expandShrinkModifier.setCurrentAlignment(null);
                    } else if (expandShrinkModifier.getCurrentAlignment() == null) {
                        Alignment topStart = (Alignment) stateRememberUpdatedState.getValue();
                        if (topStart == null) {
                            topStart = Alignment.INSTANCE.getTopStart();
                        }
                        expandShrinkModifier.setCurrentAlignment(topStart);
                    }
                    ChangeSize value6 = state.getValue();
                    composed = composed.then(((value6 == null || value6.getClip()) && ((value = state2.getValue()) == null || value.getClip())) ? ClipKt.clipToBounds(Modifier.INSTANCE) : Modifier.INSTANCE).then(expandShrinkModifier);
                }
                composer.endReplaceableGroup();
                return composed;
            }
        }, 1, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: createModifier$lambda-8, reason: not valid java name */
    public static final float m62createModifier$lambda8(State<Float> state) {
        return state.getValue().floatValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: createModifier$lambda-11, reason: not valid java name */
    public static final float m57createModifier$lambda11(State<Float> state) {
        return state.getValue().floatValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: createModifier$lambda-13, reason: not valid java name */
    public static final long m58createModifier$lambda13(State<TransformOrigin> state) {
        return state.getValue().getPackedValue();
    }
}
