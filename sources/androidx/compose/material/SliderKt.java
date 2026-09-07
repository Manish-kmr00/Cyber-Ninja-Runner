package androidx.compose.material;

import androidx.compose.animation.core.Animatable;
import androidx.compose.animation.core.AnimatableKt;
import androidx.compose.animation.core.AnimationVector1D;
import androidx.compose.animation.core.TweenSpec;
import androidx.compose.foundation.BackgroundKt;
import androidx.compose.foundation.CanvasKt;
import androidx.compose.foundation.FocusableKt;
import androidx.compose.foundation.HoverableKt;
import androidx.compose.foundation.IndicationKt;
import androidx.compose.foundation.MutatePriority;
import androidx.compose.foundation.ProgressSemanticsKt;
import androidx.compose.foundation.gestures.DragGestureDetectorKt;
import androidx.compose.foundation.gestures.DragScope;
import androidx.compose.foundation.gestures.DraggableKt;
import androidx.compose.foundation.gestures.DraggableState;
import androidx.compose.foundation.gestures.ForEachGestureKt;
import androidx.compose.foundation.gestures.GestureCancellationException;
import androidx.compose.foundation.gestures.Orientation;
import androidx.compose.foundation.gestures.PressGestureScope;
import androidx.compose.foundation.gestures.TapGestureDetectorKt;
import androidx.compose.foundation.interaction.DragInteraction;
import androidx.compose.foundation.interaction.InteractionSourceKt;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScope;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.BoxWithConstraintsKt;
import androidx.compose.foundation.layout.BoxWithConstraintsScope;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.layout.SpacerKt;
import androidx.compose.foundation.shape.RoundedCornerShapeKt;
import androidx.compose.material.ripple.RippleKt;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionScopedCoroutineScopeCanceller;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.ProvidableCompositionLocal;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SkippableUpdater;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.runtime.snapshots.SnapshotStateList;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.draw.ShadowKt;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.OffsetKt;
import androidx.compose.ui.geometry.Size;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.PointMode;
import androidx.compose.ui.graphics.StrokeCap;
import androidx.compose.ui.graphics.drawscope.DrawScope;
import androidx.compose.ui.input.pointer.AwaitPointerEventScope;
import androidx.compose.ui.input.pointer.PointerEventKt;
import androidx.compose.ui.input.pointer.PointerInputChange;
import androidx.compose.ui.input.pointer.PointerInputScope;
import androidx.compose.ui.input.pointer.SuspendingPointerInputFilterKt;
import androidx.compose.ui.layout.LayoutKt;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.platform.InspectableValueKt;
import androidx.compose.ui.platform.InspectorInfo;
import androidx.compose.ui.platform.ViewConfiguration;
import androidx.compose.ui.semantics.SemanticsModifierKt;
import androidx.compose.ui.semantics.SemanticsPropertiesKt;
import androidx.compose.ui.semantics.SemanticsPropertyReceiver;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.LayoutDirection;
import androidx.compose.ui.util.MathHelpersKt;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.profileinstaller.ProfileVerifier;
import com.amazon.device.ads.DtbConstants;
import com.mbridge.msdk.foundation.download.core.DownloadCommon;
import com.pubmatic.sdk.openwrap.core.POBConstants;
import io.bidmachine.iab.vast.tags.VastAttributes;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.RestrictedSuspendLambda;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.Ref;
import kotlin.ranges.ClosedFloatingPointRange;
import kotlin.ranges.RangesKt;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;

/* JADX INFO: compiled from: Slider.kt */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000\u009e\u0001\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\b\t\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\b\u0014\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\u001aS\u0010\u0011\u001a\u00020\u00122\u0012\u0010\u0013\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\b0\u00142\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\b0\u00162\f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\b0\u00162\f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\b0\u00192\u0006\u0010\u001a\u001a\u00020\bH\u0003¢\u0006\u0002\u0010\u001b\u001a\u007f\u0010\u001c\u001a\u00020\u00122\f\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\b0\u00162\u0018\u0010\u001e\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u0016\u0012\u0004\u0012\u00020\u00120\u00142\b\b\u0002\u0010\u001f\u001a\u00020\u00012\b\b\u0002\u0010 \u001a\u00020!2\u000e\b\u0002\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\b0\u00162\b\b\u0002\u0010\"\u001a\u00020#2\u0010\b\u0002\u0010$\u001a\n\u0012\u0004\u0012\u00020\u0012\u0018\u00010%2\b\b\u0002\u0010&\u001a\u00020'H\u0007¢\u0006\u0002\u0010(\u001ak\u0010)\u001a\u00020\u00122\u0006\u0010 \u001a\u00020!2\u0006\u0010*\u001a\u00020\b2\u0006\u0010+\u001a\u00020\b2\f\u0010,\u001a\b\u0012\u0004\u0012\u00020\b0-2\u0006\u0010&\u001a\u00020'2\u0006\u0010.\u001a\u00020\b2\u0006\u0010/\u001a\u0002002\u0006\u00101\u001a\u0002002\u0006\u0010\u001f\u001a\u00020\u00012\u0006\u00102\u001a\u00020\u00012\u0006\u00103\u001a\u00020\u0001H\u0003¢\u0006\u0002\u00104\u001a}\u00105\u001a\u00020\u00122\u0006\u0010\u001a\u001a\u00020\b2\u0012\u0010\u001e\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u00120\u00142\b\b\u0002\u0010\u001f\u001a\u00020\u00012\b\b\u0002\u0010 \u001a\u00020!2\u000e\b\u0002\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\b0\u00162\b\b\u0002\u0010\"\u001a\u00020#2\u0010\b\u0002\u0010$\u001a\n\u0012\u0004\u0012\u00020\u0012\u0018\u00010%2\b\b\u0002\u00106\u001a\u0002002\b\b\u0002\u0010&\u001a\u00020'H\u0007¢\u0006\u0002\u00107\u001aK\u00108\u001a\u00020\u00122\u0006\u0010 \u001a\u00020!2\u0006\u00109\u001a\u00020\b2\f\u0010,\u001a\b\u0012\u0004\u0012\u00020\b0-2\u0006\u0010&\u001a\u00020'2\u0006\u0010.\u001a\u00020\b2\u0006\u00106\u001a\u0002002\u0006\u0010\u001f\u001a\u00020\u0001H\u0003¢\u0006\u0002\u0010:\u001aS\u0010;\u001a\u00020\u00122\u0006\u0010\u001f\u001a\u00020\u00012\u0006\u0010&\u001a\u00020'2\u0006\u0010 \u001a\u00020!2\u0006\u0010*\u001a\u00020\b2\u0006\u0010+\u001a\u00020\b2\f\u0010,\u001a\b\u0012\u0004\u0012\u00020\b0-2\u0006\u0010<\u001a\u00020\b2\u0006\u0010=\u001a\u00020\bH\u0003¢\u0006\u0002\u0010>\u001a1\u0010?\u001a\u00020\u00122\u0006\u0010@\u001a\u00020A2\u0006\u0010B\u001a\u00020\b2\u0006\u0010C\u001a\u00020\b2\u0006\u0010D\u001a\u00020\bH\u0082@ø\u0001\u0000¢\u0006\u0002\u0010E\u001a \u0010F\u001a\u00020\b2\u0006\u0010G\u001a\u00020\b2\u0006\u0010H\u001a\u00020\b2\u0006\u0010I\u001a\u00020\bH\u0002\u001a0\u0010J\u001a\u00020\b2\u0006\u0010K\u001a\u00020\b2\u0006\u0010L\u001a\u00020\b2\u0006\u0010M\u001a\u00020\b2\u0006\u0010N\u001a\u00020\b2\u0006\u0010O\u001a\u00020\bH\u0002\u001a<\u0010J\u001a\b\u0012\u0004\u0012\u00020\b0\u00162\u0006\u0010K\u001a\u00020\b2\u0006\u0010L\u001a\u00020\b2\f\u0010P\u001a\b\u0012\u0004\u0012\u00020\b0\u00162\u0006\u0010N\u001a\u00020\b2\u0006\u0010O\u001a\u00020\bH\u0002\u001a.\u0010Q\u001a\u00020\b2\u0006\u0010B\u001a\u00020\b2\f\u0010,\u001a\b\u0012\u0004\u0012\u00020\b0-2\u0006\u0010R\u001a\u00020\b2\u0006\u0010S\u001a\u00020\bH\u0002\u001a\u0016\u0010T\u001a\b\u0012\u0004\u0012\u00020\b0-2\u0006\u0010\"\u001a\u00020#H\u0002\u001aI\u0010U\u001a\u00020\u0012*\u00020V2\u0006\u0010\u001f\u001a\u00020\u00012\u0006\u0010W\u001a\u00020\u00032\u0006\u00106\u001a\u0002002\u0006\u0010&\u001a\u00020'2\u0006\u0010 \u001a\u00020!2\u0006\u0010X\u001a\u00020\u0003H\u0003ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\bY\u0010Z\u001a;\u0010[\u001a\u0010\u0012\u0004\u0012\u00020]\u0012\u0004\u0012\u00020\b\u0018\u00010\\*\u00020^2\u0006\u0010_\u001a\u00020`2\u0006\u0010a\u001a\u00020bH\u0082@ø\u0001\u0000ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\bc\u0010d\u001a\u0098\u0001\u0010e\u001a\u00020\u0001*\u00020\u00012\u0006\u0010/\u001a\u0002002\u0006\u00101\u001a\u0002002\f\u0010f\u001a\b\u0012\u0004\u0012\u00020\b0g2\f\u0010h\u001a\b\u0012\u0004\u0012\u00020\b0g2\u0006\u0010 \u001a\u00020!2\u0006\u0010i\u001a\u00020!2\u0006\u0010S\u001a\u00020\b2\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\b0\u00162\u0018\u0010j\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020!\u0012\u0004\u0012\u00020\u00120\u00140g2\u001e\u0010k\u001a\u001a\u0012\u0016\u0012\u0014\u0012\u0004\u0012\u00020!\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u00120l0gH\u0002\u001aX\u0010m\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u001a\u001a\u00020\b2\f\u0010,\u001a\b\u0012\u0004\u0012\u00020\b0-2\u0006\u0010 \u001a\u00020!2\u0012\u0010\u001e\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u00120\u00142\u000e\b\u0002\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\b0\u00162\b\b\u0002\u0010\"\u001a\u00020#H\u0002\u001aj\u0010n\u001a\u00020\u0001*\u00020\u00012\u0006\u0010@\u001a\u00020A2\u0006\u00106\u001a\u0002002\u0006\u0010S\u001a\u00020\b2\u0006\u0010i\u001a\u00020!2\f\u0010o\u001a\b\u0012\u0004\u0012\u00020\b0g2\u0018\u0010j\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u00120\u00140g2\f\u0010p\u001a\b\u0012\u0004\u0012\u00020\b0\u00192\u0006\u0010 \u001a\u00020!H\u0002\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000\"\u0013\u0010\u0002\u001a\u00020\u0003X\u0082\u0004ø\u0001\u0000¢\u0006\u0004\n\u0002\u0010\u0004\"\u0013\u0010\u0005\u001a\u00020\u0003X\u0082\u0004ø\u0001\u0000¢\u0006\u0004\n\u0002\u0010\u0004\"\u0014\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007X\u0082\u0004¢\u0006\u0002\n\u0000\"\u0013\u0010\t\u001a\u00020\u0003X\u0082\u0004ø\u0001\u0000¢\u0006\u0004\n\u0002\u0010\u0004\"\u0013\u0010\n\u001a\u00020\u0003X\u0082\u0004ø\u0001\u0000¢\u0006\u0004\n\u0002\u0010\u0004\"\u0019\u0010\u000b\u001a\u00020\u0003X\u0080\u0004ø\u0001\u0000¢\u0006\n\n\u0002\u0010\u0004\u001a\u0004\b\f\u0010\r\"\u0013\u0010\u000e\u001a\u00020\u0003X\u0082\u0004ø\u0001\u0000¢\u0006\u0004\n\u0002\u0010\u0004\"\u0019\u0010\u000f\u001a\u00020\u0003X\u0080\u0004ø\u0001\u0000¢\u0006\n\n\u0002\u0010\u0004\u001a\u0004\b\u0010\u0010\r\u0082\u0002\u000b\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001¨\u0006q"}, d2 = {"DefaultSliderConstraints", "Landroidx/compose/ui/Modifier;", "SliderHeight", "Landroidx/compose/ui/unit/Dp;", "F", "SliderMinWidth", "SliderToTickAnimation", "Landroidx/compose/animation/core/TweenSpec;", "", "ThumbDefaultElevation", "ThumbPressedElevation", "ThumbRadius", "getThumbRadius", "()F", "ThumbRippleRadius", "TrackHeight", "getTrackHeight", "CorrectValueSideEffect", "", "scaleToOffset", "Lkotlin/Function1;", "valueRange", "Lkotlin/ranges/ClosedFloatingPointRange;", "trackRange", "valueState", "Landroidx/compose/runtime/MutableState;", "value", "(Lkotlin/jvm/functions/Function1;Lkotlin/ranges/ClosedFloatingPointRange;Lkotlin/ranges/ClosedFloatingPointRange;Landroidx/compose/runtime/MutableState;FLandroidx/compose/runtime/Composer;I)V", "RangeSlider", "values", "onValueChange", "modifier", "enabled", "", "steps", "", "onValueChangeFinished", "Lkotlin/Function0;", "colors", "Landroidx/compose/material/SliderColors;", "(Lkotlin/ranges/ClosedFloatingPointRange;Lkotlin/jvm/functions/Function1;Landroidx/compose/ui/Modifier;ZLkotlin/ranges/ClosedFloatingPointRange;ILkotlin/jvm/functions/Function0;Landroidx/compose/material/SliderColors;Landroidx/compose/runtime/Composer;II)V", "RangeSliderImpl", "positionFractionStart", "positionFractionEnd", "tickFractions", "", "width", "startInteractionSource", "Landroidx/compose/foundation/interaction/MutableInteractionSource;", "endInteractionSource", "startThumbSemantics", "endThumbSemantics", "(ZFFLjava/util/List;Landroidx/compose/material/SliderColors;FLandroidx/compose/foundation/interaction/MutableInteractionSource;Landroidx/compose/foundation/interaction/MutableInteractionSource;Landroidx/compose/ui/Modifier;Landroidx/compose/ui/Modifier;Landroidx/compose/ui/Modifier;Landroidx/compose/runtime/Composer;II)V", "Slider", "interactionSource", "(FLkotlin/jvm/functions/Function1;Landroidx/compose/ui/Modifier;ZLkotlin/ranges/ClosedFloatingPointRange;ILkotlin/jvm/functions/Function0;Landroidx/compose/foundation/interaction/MutableInteractionSource;Landroidx/compose/material/SliderColors;Landroidx/compose/runtime/Composer;II)V", "SliderImpl", "positionFraction", "(ZFLjava/util/List;Landroidx/compose/material/SliderColors;FLandroidx/compose/foundation/interaction/MutableInteractionSource;Landroidx/compose/ui/Modifier;Landroidx/compose/runtime/Composer;I)V", "Track", "thumbPx", "trackStrokeWidth", "(Landroidx/compose/ui/Modifier;Landroidx/compose/material/SliderColors;ZFFLjava/util/List;FFLandroidx/compose/runtime/Composer;I)V", "animateToTarget", "draggableState", "Landroidx/compose/foundation/gestures/DraggableState;", "current", TypedValues.AttributesType.S_TARGET, "velocity", "(Landroidx/compose/foundation/gestures/DraggableState;FFFLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "calcFraction", "a", DownloadCommon.DOWNLOAD_REPORT_FIND_FILE_RESULT_VALUE_B, POBConstants.KEY_POSITION, "scale", "a1", "b1", "x1", "a2", "b2", VastAttributes.HORIZONTAL_POSITION, "snapValueToTick", "minPx", "maxPx", "stepsToTickFractions", "SliderThumb", "Landroidx/compose/foundation/layout/BoxScope;", "offset", "thumbSize", "SliderThumb-PcYyNuk", "(Landroidx/compose/foundation/layout/BoxScope;Landroidx/compose/ui/Modifier;FLandroidx/compose/foundation/interaction/MutableInteractionSource;Landroidx/compose/material/SliderColors;ZFLandroidx/compose/runtime/Composer;I)V", "awaitSlop", "Lkotlin/Pair;", "Landroidx/compose/ui/input/pointer/PointerInputChange;", "Landroidx/compose/ui/input/pointer/AwaitPointerEventScope;", "id", "Landroidx/compose/ui/input/pointer/PointerId;", "type", "Landroidx/compose/ui/input/pointer/PointerType;", "awaitSlop-8vUncbI", "(Landroidx/compose/ui/input/pointer/AwaitPointerEventScope;JILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "rangeSliderPressDragModifier", "rawOffsetStart", "Landroidx/compose/runtime/State;", "rawOffsetEnd", "isRtl", "gestureEndAction", "onDrag", "Lkotlin/Function2;", "sliderSemantics", "sliderTapModifier", "rawOffset", "pressOffset", "material_release"}, k = 2, mv = {1, 6, 0}, xi = 48)
public final class SliderKt {
    private static final Modifier DefaultSliderConstraints;
    private static final float SliderHeight;
    private static final float SliderMinWidth;
    private static final TweenSpec<Float> SliderToTickAnimation;
    private static final float ThumbRadius = Dp.m3843constructorimpl(10);
    private static final float ThumbRippleRadius = Dp.m3843constructorimpl(24);
    private static final float ThumbDefaultElevation = Dp.m3843constructorimpl(1);
    private static final float ThumbPressedElevation = Dp.m3843constructorimpl(6);
    private static final float TrackHeight = Dp.m3843constructorimpl(4);

    /* JADX WARN: Code duplicated, block: B:101:0x0128  */
    /* JADX WARN: Code duplicated, block: B:105:0x013e  */
    /* JADX WARN: Code duplicated, block: B:107:0x014c  */
    /* JADX WARN: Code duplicated, block: B:118:0x017c A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:119:0x017e  */
    /* JADX WARN: Code duplicated, block: B:120:0x0183  */
    /* JADX WARN: Code duplicated, block: B:122:0x0187  */
    /* JADX WARN: Code duplicated, block: B:125:0x018c  */
    /* JADX WARN: Code duplicated, block: B:126:0x0196  */
    /* JADX WARN: Code duplicated, block: B:128:0x0199  */
    /* JADX WARN: Code duplicated, block: B:129:0x019b  */
    /* JADX WARN: Code duplicated, block: B:131:0x019e  */
    /* JADX WARN: Code duplicated, block: B:132:0x01a0  */
    /* JADX WARN: Code duplicated, block: B:134:0x01a4  */
    /* JADX WARN: Code duplicated, block: B:136:0x01bb  */
    /* JADX WARN: Code duplicated, block: B:138:0x01c8  */
    /* JADX WARN: Code duplicated, block: B:141:0x01ce  */
    /* JADX WARN: Code duplicated, block: B:142:0x01f6  */
    /* JADX WARN: Code duplicated, block: B:145:0x01fd  */
    /* JADX WARN: Code duplicated, block: B:147:0x021e  */
    /* JADX WARN: Code duplicated, block: B:149:0x0226  */
    /* JADX WARN: Code duplicated, block: B:154:0x02b9  */
    /* JADX WARN: Code duplicated, block: B:156:0x02cd  */
    /* JADX WARN: Code duplicated, block: B:158:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:36:0x006e  */
    /* JADX WARN: Code duplicated, block: B:37:0x0071  */
    /* JADX WARN: Code duplicated, block: B:39:0x0075  */
    /* JADX WARN: Code duplicated, block: B:41:0x007d  */
    /* JADX WARN: Code duplicated, block: B:42:0x0080  */
    /* JADX WARN: Code duplicated, block: B:47:0x008c  */
    /* JADX WARN: Code duplicated, block: B:49:0x0090  */
    /* JADX WARN: Code duplicated, block: B:51:0x0098  */
    /* JADX WARN: Code duplicated, block: B:52:0x009b  */
    /* JADX WARN: Code duplicated, block: B:55:0x00a1  */
    /* JADX WARN: Code duplicated, block: B:58:0x00a7  */
    /* JADX WARN: Code duplicated, block: B:59:0x00ab  */
    /* JADX WARN: Code duplicated, block: B:61:0x00b0  */
    /* JADX WARN: Code duplicated, block: B:63:0x00b8  */
    /* JADX WARN: Code duplicated, block: B:64:0x00bb  */
    /* JADX WARN: Code duplicated, block: B:69:0x00c5  */
    /* JADX WARN: Code duplicated, block: B:70:0x00c9  */
    /* JADX WARN: Code duplicated, block: B:72:0x00ce  */
    /* JADX WARN: Code duplicated, block: B:74:0x00d6  */
    /* JADX WARN: Code duplicated, block: B:75:0x00d9  */
    /* JADX WARN: Code duplicated, block: B:80:0x00e4  */
    /* JADX WARN: Code duplicated, block: B:81:0x00eb  */
    /* JADX WARN: Code duplicated, block: B:83:0x00f3  */
    /* JADX WARN: Code duplicated, block: B:85:0x00f9  */
    /* JADX WARN: Code duplicated, block: B:86:0x00fc  */
    /* JADX WARN: Code duplicated, block: B:90:0x0106  */
    /* JADX WARN: Code duplicated, block: B:92:0x010a  */
    /* JADX WARN: Code duplicated, block: B:95:0x0115 A[ADDED_TO_REGION] */
    /* JADX WARN: Code duplicated, block: B:98:0x011c  */
    public static final void Slider(final float f, final Function1<? super Float, Unit> onValueChange, Modifier modifier, boolean z, ClosedFloatingPointRange<Float> closedFloatingPointRange, int i, Function0<Unit> function0, MutableInteractionSource mutableInteractionSource, SliderColors sliderColors, Composer composer, final int i2, final int i3) {
        int i4;
        int i5;
        boolean z2;
        int i6;
        ClosedFloatingPointRange<Float> closedFloatingPointRange2;
        int i7;
        int i8;
        int i9;
        int i10;
        Function0<Unit> function1;
        int i11;
        int i12;
        int i13;
        Modifier.Companion companion;
        final ClosedFloatingPointRange<Float> closedFloatingPointRangeRangeTo;
        int i14;
        Function0<Unit> function2;
        MutableInteractionSource mutableInteractionSource2;
        int i15;
        SliderColors sliderColorsM1150colorsq0g_0yA;
        Object objRememberedValue;
        boolean zChanged;
        Object objRememberedValue2;
        final int i16;
        final Function0<Unit> function3;
        final SliderColors sliderColors2;
        final boolean z3;
        final MutableInteractionSource mutableInteractionSource3;
        final Modifier modifier2;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        Intrinsics.checkNotNullParameter(onValueChange, "onValueChange");
        Composer composerStartRestartGroup = composer.startRestartGroup(-1962335196);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(Slider)P(7,4,3,1,8,6,5,2)152@7357L39,153@7440L8,156@7533L35,157@7593L59,160@7657L3277:Slider.kt#jmzs0o");
        if ((i3 & 1) != 0) {
            i4 = i2 | 6;
        } else if ((i2 & 14) == 0) {
            i4 = (composerStartRestartGroup.changed(f) ? 4 : 2) | i2;
        } else {
            i4 = i2;
        }
        if ((i3 & 2) != 0) {
            i4 |= 48;
        } else if ((i2 & 112) == 0) {
            i4 |= composerStartRestartGroup.changed(onValueChange) ? 32 : 16;
        }
        int i17 = i3 & 4;
        if (i17 == 0) {
            if ((i2 & 896) == 0) {
                i4 |= composerStartRestartGroup.changed(modifier) ? 256 : 128;
            }
            i5 = i3 & 8;
            if (i5 != 0) {
                if ((i2 & 7168) == 0) {
                    z2 = z;
                    if (composerStartRestartGroup.changed(z2)) {
                        i6 = 2048;
                    } else {
                        i6 = 1024;
                    }
                    i4 |= i6;
                }
                if ((57344 & i2) == 0) {
                    if ((i3 & 16) == 0) {
                        closedFloatingPointRange2 = closedFloatingPointRange;
                        int i18 = composerStartRestartGroup.changed(closedFloatingPointRange2) ? 16384 : 8192;
                        i4 |= i18;
                    } else {
                        closedFloatingPointRange2 = closedFloatingPointRange;
                    }
                    i4 |= i18;
                } else {
                    closedFloatingPointRange2 = closedFloatingPointRange;
                }
                i7 = i3 & 32;
                if (i7 != 0) {
                    if ((458752 & i2) == 0) {
                        i8 = i;
                        if (composerStartRestartGroup.changed(i8)) {
                            i9 = 131072;
                        } else {
                            i9 = 65536;
                        }
                        i4 |= i9;
                    }
                    i10 = i3 & 64;
                    if (i10 != 0) {
                        if ((3670016 & i2) == 0) {
                            function1 = function0;
                            if (composerStartRestartGroup.changed(function1)) {
                                i11 = 1048576;
                            } else {
                                i11 = 524288;
                            }
                            i4 |= i11;
                        }
                        i12 = i3 & 128;
                        if (i12 != 0) {
                            i4 |= 12582912;
                        } else if ((i2 & 29360128) == 0) {
                            if (composerStartRestartGroup.changed(mutableInteractionSource)) {
                                i13 = 8388608;
                            } else {
                                i13 = 4194304;
                            }
                            i4 |= i13;
                        }
                        if ((i2 & 234881024) != 0) {
                            i4 |= ((i3 & 256) == 0 || !composerStartRestartGroup.changed(sliderColors)) ? 33554432 : 67108864;
                        }
                        if ((i4 & 191739611) == 38347922 || !composerStartRestartGroup.getSkipping()) {
                            composerStartRestartGroup.startDefaults();
                            if ((i2 & 1) != 0 || composerStartRestartGroup.getDefaultsInvalid()) {
                                if (i17 != 0) {
                                    companion = Modifier.INSTANCE;
                                } else {
                                    companion = modifier;
                                }
                                if (i5 != 0) {
                                    z2 = true;
                                }
                                if ((i3 & 16) != 0) {
                                    closedFloatingPointRangeRangeTo = RangesKt.rangeTo(0.0f, 1.0f);
                                    i4 &= -57345;
                                } else {
                                    closedFloatingPointRangeRangeTo = closedFloatingPointRange2;
                                }
                                if (i7 != 0) {
                                    i14 = 0;
                                } else {
                                    i14 = i8;
                                }
                                if (i10 != 0) {
                                    function2 = null;
                                } else {
                                    function2 = function0;
                                }
                                if (i12 != 0) {
                                    composerStartRestartGroup.startReplaceableGroup(-492369756);
                                    ComposerKt.sourceInformation(composerStartRestartGroup, "C(remember):Composables.kt#9igjgp");
                                    objRememberedValue = composerStartRestartGroup.rememberedValue();
                                    if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                                        objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                                    }
                                    composerStartRestartGroup.endReplaceableGroup();
                                    mutableInteractionSource2 = (MutableInteractionSource) objRememberedValue;
                                } else {
                                    mutableInteractionSource2 = mutableInteractionSource;
                                }
                                if ((i3 & 256) != 0) {
                                    i15 = i4 & (-234881025);
                                    sliderColorsM1150colorsq0g_0yA = SliderDefaults.INSTANCE.m1150colorsq0g_0yA(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 0, 6, 1023);
                                } else {
                                    i15 = i4;
                                    sliderColorsM1150colorsq0g_0yA = sliderColors;
                                }
                            } else {
                                composerStartRestartGroup.skipToGroupEnd();
                                if ((i3 & 16) != 0) {
                                    i4 &= -57345;
                                }
                                if ((i3 & 256) != 0) {
                                    int i19 = i4 & (-234881025);
                                    mutableInteractionSource2 = mutableInteractionSource;
                                    sliderColorsM1150colorsq0g_0yA = sliderColors;
                                    i15 = i19;
                                    closedFloatingPointRangeRangeTo = closedFloatingPointRange2;
                                    i14 = i8;
                                    companion = modifier;
                                    function2 = function0;
                                } else {
                                    companion = modifier;
                                    mutableInteractionSource2 = mutableInteractionSource;
                                    i15 = i4;
                                    closedFloatingPointRangeRangeTo = closedFloatingPointRange2;
                                    i14 = i8;
                                    function2 = function0;
                                    sliderColorsM1150colorsq0g_0yA = sliderColors;
                                }
                            }
                            composerStartRestartGroup.endDefaults();
                            if (i14 < 0) {
                                throw new IllegalArgumentException("steps should be >= 0".toString());
                            }
                            State stateRememberUpdatedState = SnapshotStateKt.rememberUpdatedState(onValueChange, composerStartRestartGroup, (i15 >> 3) & 14);
                            Integer numValueOf = Integer.valueOf(i14);
                            composerStartRestartGroup.startReplaceableGroup(1157296644);
                            ComposerKt.sourceInformation(composerStartRestartGroup, "C(remember)P(1):Composables.kt#9igjgp");
                            zChanged = composerStartRestartGroup.changed(numValueOf);
                            objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                            if (!zChanged || objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                                objRememberedValue2 = stepsToTickFractions(i14);
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                            }
                            composerStartRestartGroup.endReplaceableGroup();
                            List list = (List) objRememberedValue2;
                            Modifier modifierMinimumTouchTargetSize = TouchTargetKt.minimumTouchTargetSize(companion);
                            float f2 = ThumbRadius;
                            float f3 = 2;
                            BoxWithConstraintsKt.BoxWithConstraints(FocusableKt.focusable(sliderSemantics(SizeKt.m460requiredSizeInqDBjuR0$default(modifierMinimumTouchTargetSize, Dp.m3843constructorimpl(f2 * f3), Dp.m3843constructorimpl(f2 * f3), 0.0f, 0.0f, 12, null), f, list, z2, onValueChange, closedFloatingPointRangeRangeTo, i14), z2, mutableInteractionSource2), null, false, ComposableLambdaKt.composableLambda(composerStartRestartGroup, 2085116814, true, new C10663(closedFloatingPointRangeRangeTo, i15, f, mutableInteractionSource2, z2, list, sliderColorsM1150colorsq0g_0yA, stateRememberUpdatedState, function2)), composerStartRestartGroup, 3072, 6);
                            i16 = i14;
                            function3 = function2;
                            sliderColors2 = sliderColorsM1150colorsq0g_0yA;
                            z3 = z2;
                            mutableInteractionSource3 = mutableInteractionSource2;
                            modifier2 = companion;
                        } else {
                            composerStartRestartGroup.skipToGroupEnd();
                            modifier2 = modifier;
                            z3 = z2;
                            closedFloatingPointRangeRangeTo = closedFloatingPointRange2;
                            i16 = i8;
                            function3 = function1;
                            mutableInteractionSource3 = mutableInteractionSource;
                            sliderColors2 = sliderColors;
                        }
                        scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                        if (scopeUpdateScopeEndRestartGroup == null) {
                            return;
                        }
                        scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.SliderKt.Slider.4
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            /* JADX WARN: Multi-variable type inference failed */
                            {
                                super(2);
                            }

                            @Override // kotlin.jvm.functions.Function2
                            public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                                invoke(composer2, num.intValue());
                                return Unit.INSTANCE;
                            }

                            public final void invoke(Composer composer2, int i20) {
                                SliderKt.Slider(f, onValueChange, modifier2, z3, closedFloatingPointRangeRangeTo, i16, function3, mutableInteractionSource3, sliderColors2, composer2, i2 | 1, i3);
                            }
                        });
                    }
                    i4 |= 1572864;
                    function1 = function0;
                    i12 = i3 & 128;
                    if (i12 != 0) {
                        i4 |= 12582912;
                    } else if ((i2 & 29360128) == 0) {
                        if (composerStartRestartGroup.changed(mutableInteractionSource)) {
                            i13 = 8388608;
                        } else {
                            i13 = 4194304;
                        }
                        i4 |= i13;
                    }
                    if ((i2 & 234881024) != 0) {
                        i4 |= ((i3 & 256) == 0 || !composerStartRestartGroup.changed(sliderColors)) ? 33554432 : 67108864;
                    }
                    if ((i4 & 191739611) == 38347922) {
                        composerStartRestartGroup.startDefaults();
                        if ((i2 & 1) != 0) {
                            if (i17 != 0) {
                                companion = Modifier.INSTANCE;
                            } else {
                                companion = modifier;
                            }
                            if (i5 != 0) {
                                z2 = true;
                            }
                            if ((i3 & 16) != 0) {
                                closedFloatingPointRangeRangeTo = RangesKt.rangeTo(0.0f, 1.0f);
                                i4 &= -57345;
                            } else {
                                closedFloatingPointRangeRangeTo = closedFloatingPointRange2;
                            }
                            if (i7 != 0) {
                                i14 = 0;
                            } else {
                                i14 = i8;
                            }
                            if (i10 != 0) {
                                function2 = null;
                            } else {
                                function2 = function0;
                            }
                            if (i12 != 0) {
                                composerStartRestartGroup.startReplaceableGroup(-492369756);
                                ComposerKt.sourceInformation(composerStartRestartGroup, "C(remember):Composables.kt#9igjgp");
                                objRememberedValue = composerStartRestartGroup.rememberedValue();
                                if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                                    objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                                }
                                composerStartRestartGroup.endReplaceableGroup();
                                mutableInteractionSource2 = (MutableInteractionSource) objRememberedValue;
                            } else {
                                mutableInteractionSource2 = mutableInteractionSource;
                            }
                            if ((i3 & 256) != 0) {
                                i15 = i4 & (-234881025);
                                sliderColorsM1150colorsq0g_0yA = SliderDefaults.INSTANCE.m1150colorsq0g_0yA(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 0, 6, 1023);
                            } else {
                                i15 = i4;
                                sliderColorsM1150colorsq0g_0yA = sliderColors;
                            }
                        } else {
                            if (i17 != 0) {
                                companion = Modifier.INSTANCE;
                            } else {
                                companion = modifier;
                            }
                            if (i5 != 0) {
                                z2 = true;
                            }
                            if ((i3 & 16) != 0) {
                                closedFloatingPointRangeRangeTo = RangesKt.rangeTo(0.0f, 1.0f);
                                i4 &= -57345;
                            } else {
                                closedFloatingPointRangeRangeTo = closedFloatingPointRange2;
                            }
                            if (i7 != 0) {
                                i14 = 0;
                            } else {
                                i14 = i8;
                            }
                            if (i10 != 0) {
                                function2 = null;
                            } else {
                                function2 = function0;
                            }
                            if (i12 != 0) {
                                composerStartRestartGroup.startReplaceableGroup(-492369756);
                                ComposerKt.sourceInformation(composerStartRestartGroup, "C(remember):Composables.kt#9igjgp");
                                objRememberedValue = composerStartRestartGroup.rememberedValue();
                                if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                                    objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                                }
                                composerStartRestartGroup.endReplaceableGroup();
                                mutableInteractionSource2 = (MutableInteractionSource) objRememberedValue;
                            } else {
                                mutableInteractionSource2 = mutableInteractionSource;
                            }
                            if ((i3 & 256) != 0) {
                                i15 = i4 & (-234881025);
                                sliderColorsM1150colorsq0g_0yA = SliderDefaults.INSTANCE.m1150colorsq0g_0yA(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 0, 6, 1023);
                            } else {
                                i15 = i4;
                                sliderColorsM1150colorsq0g_0yA = sliderColors;
                            }
                        }
                        composerStartRestartGroup.endDefaults();
                        if (i14 < 0) {
                            throw new IllegalArgumentException("steps should be >= 0".toString());
                        }
                        State stateRememberUpdatedState2 = SnapshotStateKt.rememberUpdatedState(onValueChange, composerStartRestartGroup, (i15 >> 3) & 14);
                        Integer numValueOf2 = Integer.valueOf(i14);
                        composerStartRestartGroup.startReplaceableGroup(1157296644);
                        ComposerKt.sourceInformation(composerStartRestartGroup, "C(remember)P(1):Composables.kt#9igjgp");
                        zChanged = composerStartRestartGroup.changed(numValueOf2);
                        objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                        if (!zChanged) {
                            objRememberedValue2 = stepsToTickFractions(i14);
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                        } else {
                            objRememberedValue2 = stepsToTickFractions(i14);
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                        }
                        composerStartRestartGroup.endReplaceableGroup();
                        List list2 = (List) objRememberedValue2;
                        Modifier modifierMinimumTouchTargetSize2 = TouchTargetKt.minimumTouchTargetSize(companion);
                        float f4 = ThumbRadius;
                        float f5 = 2;
                        BoxWithConstraintsKt.BoxWithConstraints(FocusableKt.focusable(sliderSemantics(SizeKt.m460requiredSizeInqDBjuR0$default(modifierMinimumTouchTargetSize2, Dp.m3843constructorimpl(f4 * f5), Dp.m3843constructorimpl(f4 * f5), 0.0f, 0.0f, 12, null), f, list2, z2, onValueChange, closedFloatingPointRangeRangeTo, i14), z2, mutableInteractionSource2), null, false, ComposableLambdaKt.composableLambda(composerStartRestartGroup, 2085116814, true, new C10663(closedFloatingPointRangeRangeTo, i15, f, mutableInteractionSource2, z2, list2, sliderColorsM1150colorsq0g_0yA, stateRememberUpdatedState2, function2)), composerStartRestartGroup, 3072, 6);
                        i16 = i14;
                        function3 = function2;
                        sliderColors2 = sliderColorsM1150colorsq0g_0yA;
                        z3 = z2;
                        mutableInteractionSource3 = mutableInteractionSource2;
                        modifier2 = companion;
                    } else {
                        composerStartRestartGroup.startDefaults();
                        if ((i2 & 1) != 0) {
                            if (i17 != 0) {
                                companion = Modifier.INSTANCE;
                            } else {
                                companion = modifier;
                            }
                            if (i5 != 0) {
                                z2 = true;
                            }
                            if ((i3 & 16) != 0) {
                                closedFloatingPointRangeRangeTo = RangesKt.rangeTo(0.0f, 1.0f);
                                i4 &= -57345;
                            } else {
                                closedFloatingPointRangeRangeTo = closedFloatingPointRange2;
                            }
                            if (i7 != 0) {
                                i14 = 0;
                            } else {
                                i14 = i8;
                            }
                            if (i10 != 0) {
                                function2 = null;
                            } else {
                                function2 = function0;
                            }
                            if (i12 != 0) {
                                composerStartRestartGroup.startReplaceableGroup(-492369756);
                                ComposerKt.sourceInformation(composerStartRestartGroup, "C(remember):Composables.kt#9igjgp");
                                objRememberedValue = composerStartRestartGroup.rememberedValue();
                                if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                                    objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                                }
                                composerStartRestartGroup.endReplaceableGroup();
                                mutableInteractionSource2 = (MutableInteractionSource) objRememberedValue;
                            } else {
                                mutableInteractionSource2 = mutableInteractionSource;
                            }
                            if ((i3 & 256) != 0) {
                                i15 = i4 & (-234881025);
                                sliderColorsM1150colorsq0g_0yA = SliderDefaults.INSTANCE.m1150colorsq0g_0yA(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 0, 6, 1023);
                            } else {
                                i15 = i4;
                                sliderColorsM1150colorsq0g_0yA = sliderColors;
                            }
                        } else {
                            if (i17 != 0) {
                                companion = Modifier.INSTANCE;
                            } else {
                                companion = modifier;
                            }
                            if (i5 != 0) {
                                z2 = true;
                            }
                            if ((i3 & 16) != 0) {
                                closedFloatingPointRangeRangeTo = RangesKt.rangeTo(0.0f, 1.0f);
                                i4 &= -57345;
                            } else {
                                closedFloatingPointRangeRangeTo = closedFloatingPointRange2;
                            }
                            if (i7 != 0) {
                                i14 = 0;
                            } else {
                                i14 = i8;
                            }
                            if (i10 != 0) {
                                function2 = null;
                            } else {
                                function2 = function0;
                            }
                            if (i12 != 0) {
                                composerStartRestartGroup.startReplaceableGroup(-492369756);
                                ComposerKt.sourceInformation(composerStartRestartGroup, "C(remember):Composables.kt#9igjgp");
                                objRememberedValue = composerStartRestartGroup.rememberedValue();
                                if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                                    objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                                }
                                composerStartRestartGroup.endReplaceableGroup();
                                mutableInteractionSource2 = (MutableInteractionSource) objRememberedValue;
                            } else {
                                mutableInteractionSource2 = mutableInteractionSource;
                            }
                            if ((i3 & 256) != 0) {
                                i15 = i4 & (-234881025);
                                sliderColorsM1150colorsq0g_0yA = SliderDefaults.INSTANCE.m1150colorsq0g_0yA(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 0, 6, 1023);
                            } else {
                                i15 = i4;
                                sliderColorsM1150colorsq0g_0yA = sliderColors;
                            }
                        }
                        composerStartRestartGroup.endDefaults();
                        if (i14 < 0) {
                            throw new IllegalArgumentException("steps should be >= 0".toString());
                        }
                        State stateRememberUpdatedState3 = SnapshotStateKt.rememberUpdatedState(onValueChange, composerStartRestartGroup, (i15 >> 3) & 14);
                        Integer numValueOf3 = Integer.valueOf(i14);
                        composerStartRestartGroup.startReplaceableGroup(1157296644);
                        ComposerKt.sourceInformation(composerStartRestartGroup, "C(remember)P(1):Composables.kt#9igjgp");
                        zChanged = composerStartRestartGroup.changed(numValueOf3);
                        objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                        if (!zChanged) {
                            objRememberedValue2 = stepsToTickFractions(i14);
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                        } else {
                            objRememberedValue2 = stepsToTickFractions(i14);
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                        }
                        composerStartRestartGroup.endReplaceableGroup();
                        List list3 = (List) objRememberedValue2;
                        Modifier modifierMinimumTouchTargetSize3 = TouchTargetKt.minimumTouchTargetSize(companion);
                        float f6 = ThumbRadius;
                        float f7 = 2;
                        BoxWithConstraintsKt.BoxWithConstraints(FocusableKt.focusable(sliderSemantics(SizeKt.m460requiredSizeInqDBjuR0$default(modifierMinimumTouchTargetSize3, Dp.m3843constructorimpl(f6 * f7), Dp.m3843constructorimpl(f6 * f7), 0.0f, 0.0f, 12, null), f, list3, z2, onValueChange, closedFloatingPointRangeRangeTo, i14), z2, mutableInteractionSource2), null, false, ComposableLambdaKt.composableLambda(composerStartRestartGroup, 2085116814, true, new C10663(closedFloatingPointRangeRangeTo, i15, f, mutableInteractionSource2, z2, list3, sliderColorsM1150colorsq0g_0yA, stateRememberUpdatedState3, function2)), composerStartRestartGroup, 3072, 6);
                        i16 = i14;
                        function3 = function2;
                        sliderColors2 = sliderColorsM1150colorsq0g_0yA;
                        z3 = z2;
                        mutableInteractionSource3 = mutableInteractionSource2;
                        modifier2 = companion;
                    }
                    scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup == null) {
                        return;
                    }
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.SliderKt.Slider.4
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        /* JADX WARN: Multi-variable type inference failed */
                        {
                            super(2);
                        }

                        @Override // kotlin.jvm.functions.Function2
                        public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                            invoke(composer2, num.intValue());
                            return Unit.INSTANCE;
                        }

                        public final void invoke(Composer composer2, int i20) {
                            SliderKt.Slider(f, onValueChange, modifier2, z3, closedFloatingPointRangeRangeTo, i16, function3, mutableInteractionSource3, sliderColors2, composer2, i2 | 1, i3);
                        }
                    });
                }
                i4 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
                i8 = i;
                i10 = i3 & 64;
                if (i10 != 0) {
                    if ((3670016 & i2) == 0) {
                        function1 = function0;
                        if (composerStartRestartGroup.changed(function1)) {
                            i11 = 1048576;
                        } else {
                            i11 = 524288;
                        }
                        i4 |= i11;
                    }
                    i12 = i3 & 128;
                    if (i12 != 0) {
                        i4 |= 12582912;
                    } else if ((i2 & 29360128) == 0) {
                        if (composerStartRestartGroup.changed(mutableInteractionSource)) {
                            i13 = 8388608;
                        } else {
                            i13 = 4194304;
                        }
                        i4 |= i13;
                    }
                    if ((i2 & 234881024) != 0) {
                        i4 |= ((i3 & 256) == 0 || !composerStartRestartGroup.changed(sliderColors)) ? 33554432 : 67108864;
                    }
                    if ((i4 & 191739611) == 38347922) {
                        composerStartRestartGroup.startDefaults();
                        if ((i2 & 1) != 0) {
                            if (i17 != 0) {
                                companion = Modifier.INSTANCE;
                            } else {
                                companion = modifier;
                            }
                            if (i5 != 0) {
                                z2 = true;
                            }
                            if ((i3 & 16) != 0) {
                                closedFloatingPointRangeRangeTo = RangesKt.rangeTo(0.0f, 1.0f);
                                i4 &= -57345;
                            } else {
                                closedFloatingPointRangeRangeTo = closedFloatingPointRange2;
                            }
                            if (i7 != 0) {
                                i14 = 0;
                            } else {
                                i14 = i8;
                            }
                            if (i10 != 0) {
                                function2 = null;
                            } else {
                                function2 = function0;
                            }
                            if (i12 != 0) {
                                composerStartRestartGroup.startReplaceableGroup(-492369756);
                                ComposerKt.sourceInformation(composerStartRestartGroup, "C(remember):Composables.kt#9igjgp");
                                objRememberedValue = composerStartRestartGroup.rememberedValue();
                                if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                                    objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                                }
                                composerStartRestartGroup.endReplaceableGroup();
                                mutableInteractionSource2 = (MutableInteractionSource) objRememberedValue;
                            } else {
                                mutableInteractionSource2 = mutableInteractionSource;
                            }
                            if ((i3 & 256) != 0) {
                                i15 = i4 & (-234881025);
                                sliderColorsM1150colorsq0g_0yA = SliderDefaults.INSTANCE.m1150colorsq0g_0yA(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 0, 6, 1023);
                            } else {
                                i15 = i4;
                                sliderColorsM1150colorsq0g_0yA = sliderColors;
                            }
                        } else {
                            if (i17 != 0) {
                                companion = Modifier.INSTANCE;
                            } else {
                                companion = modifier;
                            }
                            if (i5 != 0) {
                                z2 = true;
                            }
                            if ((i3 & 16) != 0) {
                                closedFloatingPointRangeRangeTo = RangesKt.rangeTo(0.0f, 1.0f);
                                i4 &= -57345;
                            } else {
                                closedFloatingPointRangeRangeTo = closedFloatingPointRange2;
                            }
                            if (i7 != 0) {
                                i14 = 0;
                            } else {
                                i14 = i8;
                            }
                            if (i10 != 0) {
                                function2 = null;
                            } else {
                                function2 = function0;
                            }
                            if (i12 != 0) {
                                composerStartRestartGroup.startReplaceableGroup(-492369756);
                                ComposerKt.sourceInformation(composerStartRestartGroup, "C(remember):Composables.kt#9igjgp");
                                objRememberedValue = composerStartRestartGroup.rememberedValue();
                                if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                                    objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                                }
                                composerStartRestartGroup.endReplaceableGroup();
                                mutableInteractionSource2 = (MutableInteractionSource) objRememberedValue;
                            } else {
                                mutableInteractionSource2 = mutableInteractionSource;
                            }
                            if ((i3 & 256) != 0) {
                                i15 = i4 & (-234881025);
                                sliderColorsM1150colorsq0g_0yA = SliderDefaults.INSTANCE.m1150colorsq0g_0yA(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 0, 6, 1023);
                            } else {
                                i15 = i4;
                                sliderColorsM1150colorsq0g_0yA = sliderColors;
                            }
                        }
                        composerStartRestartGroup.endDefaults();
                        if (i14 < 0) {
                            throw new IllegalArgumentException("steps should be >= 0".toString());
                        }
                        State stateRememberUpdatedState4 = SnapshotStateKt.rememberUpdatedState(onValueChange, composerStartRestartGroup, (i15 >> 3) & 14);
                        Integer numValueOf4 = Integer.valueOf(i14);
                        composerStartRestartGroup.startReplaceableGroup(1157296644);
                        ComposerKt.sourceInformation(composerStartRestartGroup, "C(remember)P(1):Composables.kt#9igjgp");
                        zChanged = composerStartRestartGroup.changed(numValueOf4);
                        objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                        if (!zChanged) {
                            objRememberedValue2 = stepsToTickFractions(i14);
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                        } else {
                            objRememberedValue2 = stepsToTickFractions(i14);
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                        }
                        composerStartRestartGroup.endReplaceableGroup();
                        List list4 = (List) objRememberedValue2;
                        Modifier modifierMinimumTouchTargetSize4 = TouchTargetKt.minimumTouchTargetSize(companion);
                        float f8 = ThumbRadius;
                        float f9 = 2;
                        BoxWithConstraintsKt.BoxWithConstraints(FocusableKt.focusable(sliderSemantics(SizeKt.m460requiredSizeInqDBjuR0$default(modifierMinimumTouchTargetSize4, Dp.m3843constructorimpl(f8 * f9), Dp.m3843constructorimpl(f8 * f9), 0.0f, 0.0f, 12, null), f, list4, z2, onValueChange, closedFloatingPointRangeRangeTo, i14), z2, mutableInteractionSource2), null, false, ComposableLambdaKt.composableLambda(composerStartRestartGroup, 2085116814, true, new C10663(closedFloatingPointRangeRangeTo, i15, f, mutableInteractionSource2, z2, list4, sliderColorsM1150colorsq0g_0yA, stateRememberUpdatedState4, function2)), composerStartRestartGroup, 3072, 6);
                        i16 = i14;
                        function3 = function2;
                        sliderColors2 = sliderColorsM1150colorsq0g_0yA;
                        z3 = z2;
                        mutableInteractionSource3 = mutableInteractionSource2;
                        modifier2 = companion;
                    } else {
                        composerStartRestartGroup.startDefaults();
                        if ((i2 & 1) != 0) {
                            if (i17 != 0) {
                                companion = Modifier.INSTANCE;
                            } else {
                                companion = modifier;
                            }
                            if (i5 != 0) {
                                z2 = true;
                            }
                            if ((i3 & 16) != 0) {
                                closedFloatingPointRangeRangeTo = RangesKt.rangeTo(0.0f, 1.0f);
                                i4 &= -57345;
                            } else {
                                closedFloatingPointRangeRangeTo = closedFloatingPointRange2;
                            }
                            if (i7 != 0) {
                                i14 = 0;
                            } else {
                                i14 = i8;
                            }
                            if (i10 != 0) {
                                function2 = null;
                            } else {
                                function2 = function0;
                            }
                            if (i12 != 0) {
                                composerStartRestartGroup.startReplaceableGroup(-492369756);
                                ComposerKt.sourceInformation(composerStartRestartGroup, "C(remember):Composables.kt#9igjgp");
                                objRememberedValue = composerStartRestartGroup.rememberedValue();
                                if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                                    objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                                }
                                composerStartRestartGroup.endReplaceableGroup();
                                mutableInteractionSource2 = (MutableInteractionSource) objRememberedValue;
                            } else {
                                mutableInteractionSource2 = mutableInteractionSource;
                            }
                            if ((i3 & 256) != 0) {
                                i15 = i4 & (-234881025);
                                sliderColorsM1150colorsq0g_0yA = SliderDefaults.INSTANCE.m1150colorsq0g_0yA(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 0, 6, 1023);
                            } else {
                                i15 = i4;
                                sliderColorsM1150colorsq0g_0yA = sliderColors;
                            }
                        } else {
                            if (i17 != 0) {
                                companion = Modifier.INSTANCE;
                            } else {
                                companion = modifier;
                            }
                            if (i5 != 0) {
                                z2 = true;
                            }
                            if ((i3 & 16) != 0) {
                                closedFloatingPointRangeRangeTo = RangesKt.rangeTo(0.0f, 1.0f);
                                i4 &= -57345;
                            } else {
                                closedFloatingPointRangeRangeTo = closedFloatingPointRange2;
                            }
                            if (i7 != 0) {
                                i14 = 0;
                            } else {
                                i14 = i8;
                            }
                            if (i10 != 0) {
                                function2 = null;
                            } else {
                                function2 = function0;
                            }
                            if (i12 != 0) {
                                composerStartRestartGroup.startReplaceableGroup(-492369756);
                                ComposerKt.sourceInformation(composerStartRestartGroup, "C(remember):Composables.kt#9igjgp");
                                objRememberedValue = composerStartRestartGroup.rememberedValue();
                                if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                                    objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                                }
                                composerStartRestartGroup.endReplaceableGroup();
                                mutableInteractionSource2 = (MutableInteractionSource) objRememberedValue;
                            } else {
                                mutableInteractionSource2 = mutableInteractionSource;
                            }
                            if ((i3 & 256) != 0) {
                                i15 = i4 & (-234881025);
                                sliderColorsM1150colorsq0g_0yA = SliderDefaults.INSTANCE.m1150colorsq0g_0yA(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 0, 6, 1023);
                            } else {
                                i15 = i4;
                                sliderColorsM1150colorsq0g_0yA = sliderColors;
                            }
                        }
                        composerStartRestartGroup.endDefaults();
                        if (i14 < 0) {
                            throw new IllegalArgumentException("steps should be >= 0".toString());
                        }
                        State stateRememberUpdatedState5 = SnapshotStateKt.rememberUpdatedState(onValueChange, composerStartRestartGroup, (i15 >> 3) & 14);
                        Integer numValueOf5 = Integer.valueOf(i14);
                        composerStartRestartGroup.startReplaceableGroup(1157296644);
                        ComposerKt.sourceInformation(composerStartRestartGroup, "C(remember)P(1):Composables.kt#9igjgp");
                        zChanged = composerStartRestartGroup.changed(numValueOf5);
                        objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                        if (!zChanged) {
                            objRememberedValue2 = stepsToTickFractions(i14);
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                        } else {
                            objRememberedValue2 = stepsToTickFractions(i14);
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                        }
                        composerStartRestartGroup.endReplaceableGroup();
                        List list5 = (List) objRememberedValue2;
                        Modifier modifierMinimumTouchTargetSize5 = TouchTargetKt.minimumTouchTargetSize(companion);
                        float f10 = ThumbRadius;
                        float f11 = 2;
                        BoxWithConstraintsKt.BoxWithConstraints(FocusableKt.focusable(sliderSemantics(SizeKt.m460requiredSizeInqDBjuR0$default(modifierMinimumTouchTargetSize5, Dp.m3843constructorimpl(f10 * f11), Dp.m3843constructorimpl(f10 * f11), 0.0f, 0.0f, 12, null), f, list5, z2, onValueChange, closedFloatingPointRangeRangeTo, i14), z2, mutableInteractionSource2), null, false, ComposableLambdaKt.composableLambda(composerStartRestartGroup, 2085116814, true, new C10663(closedFloatingPointRangeRangeTo, i15, f, mutableInteractionSource2, z2, list5, sliderColorsM1150colorsq0g_0yA, stateRememberUpdatedState5, function2)), composerStartRestartGroup, 3072, 6);
                        i16 = i14;
                        function3 = function2;
                        sliderColors2 = sliderColorsM1150colorsq0g_0yA;
                        z3 = z2;
                        mutableInteractionSource3 = mutableInteractionSource2;
                        modifier2 = companion;
                    }
                    scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup == null) {
                        return;
                    }
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.SliderKt.Slider.4
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        /* JADX WARN: Multi-variable type inference failed */
                        {
                            super(2);
                        }

                        @Override // kotlin.jvm.functions.Function2
                        public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                            invoke(composer2, num.intValue());
                            return Unit.INSTANCE;
                        }

                        public final void invoke(Composer composer2, int i20) {
                            SliderKt.Slider(f, onValueChange, modifier2, z3, closedFloatingPointRangeRangeTo, i16, function3, mutableInteractionSource3, sliderColors2, composer2, i2 | 1, i3);
                        }
                    });
                }
                i4 |= 1572864;
                function1 = function0;
                i12 = i3 & 128;
                if (i12 != 0) {
                    i4 |= 12582912;
                } else if ((i2 & 29360128) == 0) {
                    if (composerStartRestartGroup.changed(mutableInteractionSource)) {
                        i13 = 8388608;
                    } else {
                        i13 = 4194304;
                    }
                    i4 |= i13;
                }
                if ((i2 & 234881024) != 0) {
                    i4 |= ((i3 & 256) == 0 || !composerStartRestartGroup.changed(sliderColors)) ? 33554432 : 67108864;
                }
                if ((i4 & 191739611) == 38347922) {
                    composerStartRestartGroup.startDefaults();
                    if ((i2 & 1) != 0) {
                        if (i17 != 0) {
                            companion = Modifier.INSTANCE;
                        } else {
                            companion = modifier;
                        }
                        if (i5 != 0) {
                            z2 = true;
                        }
                        if ((i3 & 16) != 0) {
                            closedFloatingPointRangeRangeTo = RangesKt.rangeTo(0.0f, 1.0f);
                            i4 &= -57345;
                        } else {
                            closedFloatingPointRangeRangeTo = closedFloatingPointRange2;
                        }
                        if (i7 != 0) {
                            i14 = 0;
                        } else {
                            i14 = i8;
                        }
                        if (i10 != 0) {
                            function2 = null;
                        } else {
                            function2 = function0;
                        }
                        if (i12 != 0) {
                            composerStartRestartGroup.startReplaceableGroup(-492369756);
                            ComposerKt.sourceInformation(composerStartRestartGroup, "C(remember):Composables.kt#9igjgp");
                            objRememberedValue = composerStartRestartGroup.rememberedValue();
                            if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                                objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                            }
                            composerStartRestartGroup.endReplaceableGroup();
                            mutableInteractionSource2 = (MutableInteractionSource) objRememberedValue;
                        } else {
                            mutableInteractionSource2 = mutableInteractionSource;
                        }
                        if ((i3 & 256) != 0) {
                            i15 = i4 & (-234881025);
                            sliderColorsM1150colorsq0g_0yA = SliderDefaults.INSTANCE.m1150colorsq0g_0yA(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 0, 6, 1023);
                        } else {
                            i15 = i4;
                            sliderColorsM1150colorsq0g_0yA = sliderColors;
                        }
                    } else {
                        if (i17 != 0) {
                            companion = Modifier.INSTANCE;
                        } else {
                            companion = modifier;
                        }
                        if (i5 != 0) {
                            z2 = true;
                        }
                        if ((i3 & 16) != 0) {
                            closedFloatingPointRangeRangeTo = RangesKt.rangeTo(0.0f, 1.0f);
                            i4 &= -57345;
                        } else {
                            closedFloatingPointRangeRangeTo = closedFloatingPointRange2;
                        }
                        if (i7 != 0) {
                            i14 = 0;
                        } else {
                            i14 = i8;
                        }
                        if (i10 != 0) {
                            function2 = null;
                        } else {
                            function2 = function0;
                        }
                        if (i12 != 0) {
                            composerStartRestartGroup.startReplaceableGroup(-492369756);
                            ComposerKt.sourceInformation(composerStartRestartGroup, "C(remember):Composables.kt#9igjgp");
                            objRememberedValue = composerStartRestartGroup.rememberedValue();
                            if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                                objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                            }
                            composerStartRestartGroup.endReplaceableGroup();
                            mutableInteractionSource2 = (MutableInteractionSource) objRememberedValue;
                        } else {
                            mutableInteractionSource2 = mutableInteractionSource;
                        }
                        if ((i3 & 256) != 0) {
                            i15 = i4 & (-234881025);
                            sliderColorsM1150colorsq0g_0yA = SliderDefaults.INSTANCE.m1150colorsq0g_0yA(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 0, 6, 1023);
                        } else {
                            i15 = i4;
                            sliderColorsM1150colorsq0g_0yA = sliderColors;
                        }
                    }
                    composerStartRestartGroup.endDefaults();
                    if (i14 < 0) {
                        throw new IllegalArgumentException("steps should be >= 0".toString());
                    }
                    State stateRememberUpdatedState6 = SnapshotStateKt.rememberUpdatedState(onValueChange, composerStartRestartGroup, (i15 >> 3) & 14);
                    Integer numValueOf6 = Integer.valueOf(i14);
                    composerStartRestartGroup.startReplaceableGroup(1157296644);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "C(remember)P(1):Composables.kt#9igjgp");
                    zChanged = composerStartRestartGroup.changed(numValueOf6);
                    objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                    if (!zChanged) {
                        objRememberedValue2 = stepsToTickFractions(i14);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                    } else {
                        objRememberedValue2 = stepsToTickFractions(i14);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                    }
                    composerStartRestartGroup.endReplaceableGroup();
                    List list6 = (List) objRememberedValue2;
                    Modifier modifierMinimumTouchTargetSize6 = TouchTargetKt.minimumTouchTargetSize(companion);
                    float f12 = ThumbRadius;
                    float f13 = 2;
                    BoxWithConstraintsKt.BoxWithConstraints(FocusableKt.focusable(sliderSemantics(SizeKt.m460requiredSizeInqDBjuR0$default(modifierMinimumTouchTargetSize6, Dp.m3843constructorimpl(f12 * f13), Dp.m3843constructorimpl(f12 * f13), 0.0f, 0.0f, 12, null), f, list6, z2, onValueChange, closedFloatingPointRangeRangeTo, i14), z2, mutableInteractionSource2), null, false, ComposableLambdaKt.composableLambda(composerStartRestartGroup, 2085116814, true, new C10663(closedFloatingPointRangeRangeTo, i15, f, mutableInteractionSource2, z2, list6, sliderColorsM1150colorsq0g_0yA, stateRememberUpdatedState6, function2)), composerStartRestartGroup, 3072, 6);
                    i16 = i14;
                    function3 = function2;
                    sliderColors2 = sliderColorsM1150colorsq0g_0yA;
                    z3 = z2;
                    mutableInteractionSource3 = mutableInteractionSource2;
                    modifier2 = companion;
                } else {
                    composerStartRestartGroup.startDefaults();
                    if ((i2 & 1) != 0) {
                        if (i17 != 0) {
                            companion = Modifier.INSTANCE;
                        } else {
                            companion = modifier;
                        }
                        if (i5 != 0) {
                            z2 = true;
                        }
                        if ((i3 & 16) != 0) {
                            closedFloatingPointRangeRangeTo = RangesKt.rangeTo(0.0f, 1.0f);
                            i4 &= -57345;
                        } else {
                            closedFloatingPointRangeRangeTo = closedFloatingPointRange2;
                        }
                        if (i7 != 0) {
                            i14 = 0;
                        } else {
                            i14 = i8;
                        }
                        if (i10 != 0) {
                            function2 = null;
                        } else {
                            function2 = function0;
                        }
                        if (i12 != 0) {
                            composerStartRestartGroup.startReplaceableGroup(-492369756);
                            ComposerKt.sourceInformation(composerStartRestartGroup, "C(remember):Composables.kt#9igjgp");
                            objRememberedValue = composerStartRestartGroup.rememberedValue();
                            if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                                objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                            }
                            composerStartRestartGroup.endReplaceableGroup();
                            mutableInteractionSource2 = (MutableInteractionSource) objRememberedValue;
                        } else {
                            mutableInteractionSource2 = mutableInteractionSource;
                        }
                        if ((i3 & 256) != 0) {
                            i15 = i4 & (-234881025);
                            sliderColorsM1150colorsq0g_0yA = SliderDefaults.INSTANCE.m1150colorsq0g_0yA(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 0, 6, 1023);
                        } else {
                            i15 = i4;
                            sliderColorsM1150colorsq0g_0yA = sliderColors;
                        }
                    } else {
                        if (i17 != 0) {
                            companion = Modifier.INSTANCE;
                        } else {
                            companion = modifier;
                        }
                        if (i5 != 0) {
                            z2 = true;
                        }
                        if ((i3 & 16) != 0) {
                            closedFloatingPointRangeRangeTo = RangesKt.rangeTo(0.0f, 1.0f);
                            i4 &= -57345;
                        } else {
                            closedFloatingPointRangeRangeTo = closedFloatingPointRange2;
                        }
                        if (i7 != 0) {
                            i14 = 0;
                        } else {
                            i14 = i8;
                        }
                        if (i10 != 0) {
                            function2 = null;
                        } else {
                            function2 = function0;
                        }
                        if (i12 != 0) {
                            composerStartRestartGroup.startReplaceableGroup(-492369756);
                            ComposerKt.sourceInformation(composerStartRestartGroup, "C(remember):Composables.kt#9igjgp");
                            objRememberedValue = composerStartRestartGroup.rememberedValue();
                            if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                                objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                            }
                            composerStartRestartGroup.endReplaceableGroup();
                            mutableInteractionSource2 = (MutableInteractionSource) objRememberedValue;
                        } else {
                            mutableInteractionSource2 = mutableInteractionSource;
                        }
                        if ((i3 & 256) != 0) {
                            i15 = i4 & (-234881025);
                            sliderColorsM1150colorsq0g_0yA = SliderDefaults.INSTANCE.m1150colorsq0g_0yA(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 0, 6, 1023);
                        } else {
                            i15 = i4;
                            sliderColorsM1150colorsq0g_0yA = sliderColors;
                        }
                    }
                    composerStartRestartGroup.endDefaults();
                    if (i14 < 0) {
                        throw new IllegalArgumentException("steps should be >= 0".toString());
                    }
                    State stateRememberUpdatedState7 = SnapshotStateKt.rememberUpdatedState(onValueChange, composerStartRestartGroup, (i15 >> 3) & 14);
                    Integer numValueOf7 = Integer.valueOf(i14);
                    composerStartRestartGroup.startReplaceableGroup(1157296644);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "C(remember)P(1):Composables.kt#9igjgp");
                    zChanged = composerStartRestartGroup.changed(numValueOf7);
                    objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                    if (!zChanged) {
                        objRememberedValue2 = stepsToTickFractions(i14);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                    } else {
                        objRememberedValue2 = stepsToTickFractions(i14);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                    }
                    composerStartRestartGroup.endReplaceableGroup();
                    List list7 = (List) objRememberedValue2;
                    Modifier modifierMinimumTouchTargetSize7 = TouchTargetKt.minimumTouchTargetSize(companion);
                    float f14 = ThumbRadius;
                    float f15 = 2;
                    BoxWithConstraintsKt.BoxWithConstraints(FocusableKt.focusable(sliderSemantics(SizeKt.m460requiredSizeInqDBjuR0$default(modifierMinimumTouchTargetSize7, Dp.m3843constructorimpl(f14 * f15), Dp.m3843constructorimpl(f14 * f15), 0.0f, 0.0f, 12, null), f, list7, z2, onValueChange, closedFloatingPointRangeRangeTo, i14), z2, mutableInteractionSource2), null, false, ComposableLambdaKt.composableLambda(composerStartRestartGroup, 2085116814, true, new C10663(closedFloatingPointRangeRangeTo, i15, f, mutableInteractionSource2, z2, list7, sliderColorsM1150colorsq0g_0yA, stateRememberUpdatedState7, function2)), composerStartRestartGroup, 3072, 6);
                    i16 = i14;
                    function3 = function2;
                    sliderColors2 = sliderColorsM1150colorsq0g_0yA;
                    z3 = z2;
                    mutableInteractionSource3 = mutableInteractionSource2;
                    modifier2 = companion;
                }
                scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup == null) {
                    return;
                }
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.SliderKt.Slider.4
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    /* JADX WARN: Multi-variable type inference failed */
                    {
                        super(2);
                    }

                    @Override // kotlin.jvm.functions.Function2
                    public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                        invoke(composer2, num.intValue());
                        return Unit.INSTANCE;
                    }

                    public final void invoke(Composer composer2, int i20) {
                        SliderKt.Slider(f, onValueChange, modifier2, z3, closedFloatingPointRangeRangeTo, i16, function3, mutableInteractionSource3, sliderColors2, composer2, i2 | 1, i3);
                    }
                });
            }
            i4 |= 3072;
            z2 = z;
            if ((57344 & i2) == 0) {
                if ((i3 & 16) == 0) {
                    closedFloatingPointRange2 = closedFloatingPointRange;
                    if (composerStartRestartGroup.changed(closedFloatingPointRange2)) {
                    }
                    i4 |= i18;
                } else {
                    closedFloatingPointRange2 = closedFloatingPointRange;
                }
                i4 |= i18;
            } else {
                closedFloatingPointRange2 = closedFloatingPointRange;
            }
            i7 = i3 & 32;
            if (i7 != 0) {
                if ((458752 & i2) == 0) {
                    i8 = i;
                    if (composerStartRestartGroup.changed(i8)) {
                        i9 = 131072;
                    } else {
                        i9 = 65536;
                    }
                    i4 |= i9;
                }
                i10 = i3 & 64;
                if (i10 != 0) {
                    if ((3670016 & i2) == 0) {
                        function1 = function0;
                        if (composerStartRestartGroup.changed(function1)) {
                            i11 = 1048576;
                        } else {
                            i11 = 524288;
                        }
                        i4 |= i11;
                    }
                    i12 = i3 & 128;
                    if (i12 != 0) {
                        i4 |= 12582912;
                    } else if ((i2 & 29360128) == 0) {
                        if (composerStartRestartGroup.changed(mutableInteractionSource)) {
                            i13 = 8388608;
                        } else {
                            i13 = 4194304;
                        }
                        i4 |= i13;
                    }
                    if ((i2 & 234881024) != 0) {
                        i4 |= ((i3 & 256) == 0 || !composerStartRestartGroup.changed(sliderColors)) ? 33554432 : 67108864;
                    }
                    if ((i4 & 191739611) == 38347922) {
                        composerStartRestartGroup.startDefaults();
                        if ((i2 & 1) != 0) {
                            if (i17 != 0) {
                                companion = Modifier.INSTANCE;
                            } else {
                                companion = modifier;
                            }
                            if (i5 != 0) {
                                z2 = true;
                            }
                            if ((i3 & 16) != 0) {
                                closedFloatingPointRangeRangeTo = RangesKt.rangeTo(0.0f, 1.0f);
                                i4 &= -57345;
                            } else {
                                closedFloatingPointRangeRangeTo = closedFloatingPointRange2;
                            }
                            if (i7 != 0) {
                                i14 = 0;
                            } else {
                                i14 = i8;
                            }
                            if (i10 != 0) {
                                function2 = null;
                            } else {
                                function2 = function0;
                            }
                            if (i12 != 0) {
                                composerStartRestartGroup.startReplaceableGroup(-492369756);
                                ComposerKt.sourceInformation(composerStartRestartGroup, "C(remember):Composables.kt#9igjgp");
                                objRememberedValue = composerStartRestartGroup.rememberedValue();
                                if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                                    objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                                }
                                composerStartRestartGroup.endReplaceableGroup();
                                mutableInteractionSource2 = (MutableInteractionSource) objRememberedValue;
                            } else {
                                mutableInteractionSource2 = mutableInteractionSource;
                            }
                            if ((i3 & 256) != 0) {
                                i15 = i4 & (-234881025);
                                sliderColorsM1150colorsq0g_0yA = SliderDefaults.INSTANCE.m1150colorsq0g_0yA(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 0, 6, 1023);
                            } else {
                                i15 = i4;
                                sliderColorsM1150colorsq0g_0yA = sliderColors;
                            }
                        } else {
                            if (i17 != 0) {
                                companion = Modifier.INSTANCE;
                            } else {
                                companion = modifier;
                            }
                            if (i5 != 0) {
                                z2 = true;
                            }
                            if ((i3 & 16) != 0) {
                                closedFloatingPointRangeRangeTo = RangesKt.rangeTo(0.0f, 1.0f);
                                i4 &= -57345;
                            } else {
                                closedFloatingPointRangeRangeTo = closedFloatingPointRange2;
                            }
                            if (i7 != 0) {
                                i14 = 0;
                            } else {
                                i14 = i8;
                            }
                            if (i10 != 0) {
                                function2 = null;
                            } else {
                                function2 = function0;
                            }
                            if (i12 != 0) {
                                composerStartRestartGroup.startReplaceableGroup(-492369756);
                                ComposerKt.sourceInformation(composerStartRestartGroup, "C(remember):Composables.kt#9igjgp");
                                objRememberedValue = composerStartRestartGroup.rememberedValue();
                                if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                                    objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                                }
                                composerStartRestartGroup.endReplaceableGroup();
                                mutableInteractionSource2 = (MutableInteractionSource) objRememberedValue;
                            } else {
                                mutableInteractionSource2 = mutableInteractionSource;
                            }
                            if ((i3 & 256) != 0) {
                                i15 = i4 & (-234881025);
                                sliderColorsM1150colorsq0g_0yA = SliderDefaults.INSTANCE.m1150colorsq0g_0yA(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 0, 6, 1023);
                            } else {
                                i15 = i4;
                                sliderColorsM1150colorsq0g_0yA = sliderColors;
                            }
                        }
                        composerStartRestartGroup.endDefaults();
                        if (i14 < 0) {
                            throw new IllegalArgumentException("steps should be >= 0".toString());
                        }
                        State stateRememberUpdatedState8 = SnapshotStateKt.rememberUpdatedState(onValueChange, composerStartRestartGroup, (i15 >> 3) & 14);
                        Integer numValueOf8 = Integer.valueOf(i14);
                        composerStartRestartGroup.startReplaceableGroup(1157296644);
                        ComposerKt.sourceInformation(composerStartRestartGroup, "C(remember)P(1):Composables.kt#9igjgp");
                        zChanged = composerStartRestartGroup.changed(numValueOf8);
                        objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                        if (!zChanged) {
                            objRememberedValue2 = stepsToTickFractions(i14);
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                        } else {
                            objRememberedValue2 = stepsToTickFractions(i14);
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                        }
                        composerStartRestartGroup.endReplaceableGroup();
                        List list8 = (List) objRememberedValue2;
                        Modifier modifierMinimumTouchTargetSize8 = TouchTargetKt.minimumTouchTargetSize(companion);
                        float f16 = ThumbRadius;
                        float f17 = 2;
                        BoxWithConstraintsKt.BoxWithConstraints(FocusableKt.focusable(sliderSemantics(SizeKt.m460requiredSizeInqDBjuR0$default(modifierMinimumTouchTargetSize8, Dp.m3843constructorimpl(f16 * f17), Dp.m3843constructorimpl(f16 * f17), 0.0f, 0.0f, 12, null), f, list8, z2, onValueChange, closedFloatingPointRangeRangeTo, i14), z2, mutableInteractionSource2), null, false, ComposableLambdaKt.composableLambda(composerStartRestartGroup, 2085116814, true, new C10663(closedFloatingPointRangeRangeTo, i15, f, mutableInteractionSource2, z2, list8, sliderColorsM1150colorsq0g_0yA, stateRememberUpdatedState8, function2)), composerStartRestartGroup, 3072, 6);
                        i16 = i14;
                        function3 = function2;
                        sliderColors2 = sliderColorsM1150colorsq0g_0yA;
                        z3 = z2;
                        mutableInteractionSource3 = mutableInteractionSource2;
                        modifier2 = companion;
                    } else {
                        composerStartRestartGroup.startDefaults();
                        if ((i2 & 1) != 0) {
                            if (i17 != 0) {
                                companion = Modifier.INSTANCE;
                            } else {
                                companion = modifier;
                            }
                            if (i5 != 0) {
                                z2 = true;
                            }
                            if ((i3 & 16) != 0) {
                                closedFloatingPointRangeRangeTo = RangesKt.rangeTo(0.0f, 1.0f);
                                i4 &= -57345;
                            } else {
                                closedFloatingPointRangeRangeTo = closedFloatingPointRange2;
                            }
                            if (i7 != 0) {
                                i14 = 0;
                            } else {
                                i14 = i8;
                            }
                            if (i10 != 0) {
                                function2 = null;
                            } else {
                                function2 = function0;
                            }
                            if (i12 != 0) {
                                composerStartRestartGroup.startReplaceableGroup(-492369756);
                                ComposerKt.sourceInformation(composerStartRestartGroup, "C(remember):Composables.kt#9igjgp");
                                objRememberedValue = composerStartRestartGroup.rememberedValue();
                                if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                                    objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                                }
                                composerStartRestartGroup.endReplaceableGroup();
                                mutableInteractionSource2 = (MutableInteractionSource) objRememberedValue;
                            } else {
                                mutableInteractionSource2 = mutableInteractionSource;
                            }
                            if ((i3 & 256) != 0) {
                                i15 = i4 & (-234881025);
                                sliderColorsM1150colorsq0g_0yA = SliderDefaults.INSTANCE.m1150colorsq0g_0yA(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 0, 6, 1023);
                            } else {
                                i15 = i4;
                                sliderColorsM1150colorsq0g_0yA = sliderColors;
                            }
                        } else {
                            if (i17 != 0) {
                                companion = Modifier.INSTANCE;
                            } else {
                                companion = modifier;
                            }
                            if (i5 != 0) {
                                z2 = true;
                            }
                            if ((i3 & 16) != 0) {
                                closedFloatingPointRangeRangeTo = RangesKt.rangeTo(0.0f, 1.0f);
                                i4 &= -57345;
                            } else {
                                closedFloatingPointRangeRangeTo = closedFloatingPointRange2;
                            }
                            if (i7 != 0) {
                                i14 = 0;
                            } else {
                                i14 = i8;
                            }
                            if (i10 != 0) {
                                function2 = null;
                            } else {
                                function2 = function0;
                            }
                            if (i12 != 0) {
                                composerStartRestartGroup.startReplaceableGroup(-492369756);
                                ComposerKt.sourceInformation(composerStartRestartGroup, "C(remember):Composables.kt#9igjgp");
                                objRememberedValue = composerStartRestartGroup.rememberedValue();
                                if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                                    objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                                }
                                composerStartRestartGroup.endReplaceableGroup();
                                mutableInteractionSource2 = (MutableInteractionSource) objRememberedValue;
                            } else {
                                mutableInteractionSource2 = mutableInteractionSource;
                            }
                            if ((i3 & 256) != 0) {
                                i15 = i4 & (-234881025);
                                sliderColorsM1150colorsq0g_0yA = SliderDefaults.INSTANCE.m1150colorsq0g_0yA(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 0, 6, 1023);
                            } else {
                                i15 = i4;
                                sliderColorsM1150colorsq0g_0yA = sliderColors;
                            }
                        }
                        composerStartRestartGroup.endDefaults();
                        if (i14 < 0) {
                            throw new IllegalArgumentException("steps should be >= 0".toString());
                        }
                        State stateRememberUpdatedState9 = SnapshotStateKt.rememberUpdatedState(onValueChange, composerStartRestartGroup, (i15 >> 3) & 14);
                        Integer numValueOf9 = Integer.valueOf(i14);
                        composerStartRestartGroup.startReplaceableGroup(1157296644);
                        ComposerKt.sourceInformation(composerStartRestartGroup, "C(remember)P(1):Composables.kt#9igjgp");
                        zChanged = composerStartRestartGroup.changed(numValueOf9);
                        objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                        if (!zChanged) {
                            objRememberedValue2 = stepsToTickFractions(i14);
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                        } else {
                            objRememberedValue2 = stepsToTickFractions(i14);
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                        }
                        composerStartRestartGroup.endReplaceableGroup();
                        List list9 = (List) objRememberedValue2;
                        Modifier modifierMinimumTouchTargetSize9 = TouchTargetKt.minimumTouchTargetSize(companion);
                        float f18 = ThumbRadius;
                        float f19 = 2;
                        BoxWithConstraintsKt.BoxWithConstraints(FocusableKt.focusable(sliderSemantics(SizeKt.m460requiredSizeInqDBjuR0$default(modifierMinimumTouchTargetSize9, Dp.m3843constructorimpl(f18 * f19), Dp.m3843constructorimpl(f18 * f19), 0.0f, 0.0f, 12, null), f, list9, z2, onValueChange, closedFloatingPointRangeRangeTo, i14), z2, mutableInteractionSource2), null, false, ComposableLambdaKt.composableLambda(composerStartRestartGroup, 2085116814, true, new C10663(closedFloatingPointRangeRangeTo, i15, f, mutableInteractionSource2, z2, list9, sliderColorsM1150colorsq0g_0yA, stateRememberUpdatedState9, function2)), composerStartRestartGroup, 3072, 6);
                        i16 = i14;
                        function3 = function2;
                        sliderColors2 = sliderColorsM1150colorsq0g_0yA;
                        z3 = z2;
                        mutableInteractionSource3 = mutableInteractionSource2;
                        modifier2 = companion;
                    }
                    scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup == null) {
                        return;
                    }
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.SliderKt.Slider.4
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        /* JADX WARN: Multi-variable type inference failed */
                        {
                            super(2);
                        }

                        @Override // kotlin.jvm.functions.Function2
                        public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                            invoke(composer2, num.intValue());
                            return Unit.INSTANCE;
                        }

                        public final void invoke(Composer composer2, int i20) {
                            SliderKt.Slider(f, onValueChange, modifier2, z3, closedFloatingPointRangeRangeTo, i16, function3, mutableInteractionSource3, sliderColors2, composer2, i2 | 1, i3);
                        }
                    });
                }
                i4 |= 1572864;
                function1 = function0;
                i12 = i3 & 128;
                if (i12 != 0) {
                    i4 |= 12582912;
                } else if ((i2 & 29360128) == 0) {
                    if (composerStartRestartGroup.changed(mutableInteractionSource)) {
                        i13 = 8388608;
                    } else {
                        i13 = 4194304;
                    }
                    i4 |= i13;
                }
                if ((i2 & 234881024) != 0) {
                    i4 |= ((i3 & 256) == 0 || !composerStartRestartGroup.changed(sliderColors)) ? 33554432 : 67108864;
                }
                if ((i4 & 191739611) == 38347922) {
                    composerStartRestartGroup.startDefaults();
                    if ((i2 & 1) != 0) {
                        if (i17 != 0) {
                            companion = Modifier.INSTANCE;
                        } else {
                            companion = modifier;
                        }
                        if (i5 != 0) {
                            z2 = true;
                        }
                        if ((i3 & 16) != 0) {
                            closedFloatingPointRangeRangeTo = RangesKt.rangeTo(0.0f, 1.0f);
                            i4 &= -57345;
                        } else {
                            closedFloatingPointRangeRangeTo = closedFloatingPointRange2;
                        }
                        if (i7 != 0) {
                            i14 = 0;
                        } else {
                            i14 = i8;
                        }
                        if (i10 != 0) {
                            function2 = null;
                        } else {
                            function2 = function0;
                        }
                        if (i12 != 0) {
                            composerStartRestartGroup.startReplaceableGroup(-492369756);
                            ComposerKt.sourceInformation(composerStartRestartGroup, "C(remember):Composables.kt#9igjgp");
                            objRememberedValue = composerStartRestartGroup.rememberedValue();
                            if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                                objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                            }
                            composerStartRestartGroup.endReplaceableGroup();
                            mutableInteractionSource2 = (MutableInteractionSource) objRememberedValue;
                        } else {
                            mutableInteractionSource2 = mutableInteractionSource;
                        }
                        if ((i3 & 256) != 0) {
                            i15 = i4 & (-234881025);
                            sliderColorsM1150colorsq0g_0yA = SliderDefaults.INSTANCE.m1150colorsq0g_0yA(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 0, 6, 1023);
                        } else {
                            i15 = i4;
                            sliderColorsM1150colorsq0g_0yA = sliderColors;
                        }
                    } else {
                        if (i17 != 0) {
                            companion = Modifier.INSTANCE;
                        } else {
                            companion = modifier;
                        }
                        if (i5 != 0) {
                            z2 = true;
                        }
                        if ((i3 & 16) != 0) {
                            closedFloatingPointRangeRangeTo = RangesKt.rangeTo(0.0f, 1.0f);
                            i4 &= -57345;
                        } else {
                            closedFloatingPointRangeRangeTo = closedFloatingPointRange2;
                        }
                        if (i7 != 0) {
                            i14 = 0;
                        } else {
                            i14 = i8;
                        }
                        if (i10 != 0) {
                            function2 = null;
                        } else {
                            function2 = function0;
                        }
                        if (i12 != 0) {
                            composerStartRestartGroup.startReplaceableGroup(-492369756);
                            ComposerKt.sourceInformation(composerStartRestartGroup, "C(remember):Composables.kt#9igjgp");
                            objRememberedValue = composerStartRestartGroup.rememberedValue();
                            if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                                objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                            }
                            composerStartRestartGroup.endReplaceableGroup();
                            mutableInteractionSource2 = (MutableInteractionSource) objRememberedValue;
                        } else {
                            mutableInteractionSource2 = mutableInteractionSource;
                        }
                        if ((i3 & 256) != 0) {
                            i15 = i4 & (-234881025);
                            sliderColorsM1150colorsq0g_0yA = SliderDefaults.INSTANCE.m1150colorsq0g_0yA(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 0, 6, 1023);
                        } else {
                            i15 = i4;
                            sliderColorsM1150colorsq0g_0yA = sliderColors;
                        }
                    }
                    composerStartRestartGroup.endDefaults();
                    if (i14 < 0) {
                        throw new IllegalArgumentException("steps should be >= 0".toString());
                    }
                    State stateRememberUpdatedState10 = SnapshotStateKt.rememberUpdatedState(onValueChange, composerStartRestartGroup, (i15 >> 3) & 14);
                    Integer numValueOf10 = Integer.valueOf(i14);
                    composerStartRestartGroup.startReplaceableGroup(1157296644);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "C(remember)P(1):Composables.kt#9igjgp");
                    zChanged = composerStartRestartGroup.changed(numValueOf10);
                    objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                    if (!zChanged) {
                        objRememberedValue2 = stepsToTickFractions(i14);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                    } else {
                        objRememberedValue2 = stepsToTickFractions(i14);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                    }
                    composerStartRestartGroup.endReplaceableGroup();
                    List list10 = (List) objRememberedValue2;
                    Modifier modifierMinimumTouchTargetSize10 = TouchTargetKt.minimumTouchTargetSize(companion);
                    float f110 = ThumbRadius;
                    float f111 = 2;
                    BoxWithConstraintsKt.BoxWithConstraints(FocusableKt.focusable(sliderSemantics(SizeKt.m460requiredSizeInqDBjuR0$default(modifierMinimumTouchTargetSize10, Dp.m3843constructorimpl(f110 * f111), Dp.m3843constructorimpl(f110 * f111), 0.0f, 0.0f, 12, null), f, list10, z2, onValueChange, closedFloatingPointRangeRangeTo, i14), z2, mutableInteractionSource2), null, false, ComposableLambdaKt.composableLambda(composerStartRestartGroup, 2085116814, true, new C10663(closedFloatingPointRangeRangeTo, i15, f, mutableInteractionSource2, z2, list10, sliderColorsM1150colorsq0g_0yA, stateRememberUpdatedState10, function2)), composerStartRestartGroup, 3072, 6);
                    i16 = i14;
                    function3 = function2;
                    sliderColors2 = sliderColorsM1150colorsq0g_0yA;
                    z3 = z2;
                    mutableInteractionSource3 = mutableInteractionSource2;
                    modifier2 = companion;
                } else {
                    composerStartRestartGroup.startDefaults();
                    if ((i2 & 1) != 0) {
                        if (i17 != 0) {
                            companion = Modifier.INSTANCE;
                        } else {
                            companion = modifier;
                        }
                        if (i5 != 0) {
                            z2 = true;
                        }
                        if ((i3 & 16) != 0) {
                            closedFloatingPointRangeRangeTo = RangesKt.rangeTo(0.0f, 1.0f);
                            i4 &= -57345;
                        } else {
                            closedFloatingPointRangeRangeTo = closedFloatingPointRange2;
                        }
                        if (i7 != 0) {
                            i14 = 0;
                        } else {
                            i14 = i8;
                        }
                        if (i10 != 0) {
                            function2 = null;
                        } else {
                            function2 = function0;
                        }
                        if (i12 != 0) {
                            composerStartRestartGroup.startReplaceableGroup(-492369756);
                            ComposerKt.sourceInformation(composerStartRestartGroup, "C(remember):Composables.kt#9igjgp");
                            objRememberedValue = composerStartRestartGroup.rememberedValue();
                            if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                                objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                            }
                            composerStartRestartGroup.endReplaceableGroup();
                            mutableInteractionSource2 = (MutableInteractionSource) objRememberedValue;
                        } else {
                            mutableInteractionSource2 = mutableInteractionSource;
                        }
                        if ((i3 & 256) != 0) {
                            i15 = i4 & (-234881025);
                            sliderColorsM1150colorsq0g_0yA = SliderDefaults.INSTANCE.m1150colorsq0g_0yA(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 0, 6, 1023);
                        } else {
                            i15 = i4;
                            sliderColorsM1150colorsq0g_0yA = sliderColors;
                        }
                    } else {
                        if (i17 != 0) {
                            companion = Modifier.INSTANCE;
                        } else {
                            companion = modifier;
                        }
                        if (i5 != 0) {
                            z2 = true;
                        }
                        if ((i3 & 16) != 0) {
                            closedFloatingPointRangeRangeTo = RangesKt.rangeTo(0.0f, 1.0f);
                            i4 &= -57345;
                        } else {
                            closedFloatingPointRangeRangeTo = closedFloatingPointRange2;
                        }
                        if (i7 != 0) {
                            i14 = 0;
                        } else {
                            i14 = i8;
                        }
                        if (i10 != 0) {
                            function2 = null;
                        } else {
                            function2 = function0;
                        }
                        if (i12 != 0) {
                            composerStartRestartGroup.startReplaceableGroup(-492369756);
                            ComposerKt.sourceInformation(composerStartRestartGroup, "C(remember):Composables.kt#9igjgp");
                            objRememberedValue = composerStartRestartGroup.rememberedValue();
                            if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                                objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                            }
                            composerStartRestartGroup.endReplaceableGroup();
                            mutableInteractionSource2 = (MutableInteractionSource) objRememberedValue;
                        } else {
                            mutableInteractionSource2 = mutableInteractionSource;
                        }
                        if ((i3 & 256) != 0) {
                            i15 = i4 & (-234881025);
                            sliderColorsM1150colorsq0g_0yA = SliderDefaults.INSTANCE.m1150colorsq0g_0yA(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 0, 6, 1023);
                        } else {
                            i15 = i4;
                            sliderColorsM1150colorsq0g_0yA = sliderColors;
                        }
                    }
                    composerStartRestartGroup.endDefaults();
                    if (i14 < 0) {
                        throw new IllegalArgumentException("steps should be >= 0".toString());
                    }
                    State stateRememberUpdatedState11 = SnapshotStateKt.rememberUpdatedState(onValueChange, composerStartRestartGroup, (i15 >> 3) & 14);
                    Integer numValueOf11 = Integer.valueOf(i14);
                    composerStartRestartGroup.startReplaceableGroup(1157296644);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "C(remember)P(1):Composables.kt#9igjgp");
                    zChanged = composerStartRestartGroup.changed(numValueOf11);
                    objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                    if (!zChanged) {
                        objRememberedValue2 = stepsToTickFractions(i14);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                    } else {
                        objRememberedValue2 = stepsToTickFractions(i14);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                    }
                    composerStartRestartGroup.endReplaceableGroup();
                    List list11 = (List) objRememberedValue2;
                    Modifier modifierMinimumTouchTargetSize11 = TouchTargetKt.minimumTouchTargetSize(companion);
                    float f112 = ThumbRadius;
                    float f113 = 2;
                    BoxWithConstraintsKt.BoxWithConstraints(FocusableKt.focusable(sliderSemantics(SizeKt.m460requiredSizeInqDBjuR0$default(modifierMinimumTouchTargetSize11, Dp.m3843constructorimpl(f112 * f113), Dp.m3843constructorimpl(f112 * f113), 0.0f, 0.0f, 12, null), f, list11, z2, onValueChange, closedFloatingPointRangeRangeTo, i14), z2, mutableInteractionSource2), null, false, ComposableLambdaKt.composableLambda(composerStartRestartGroup, 2085116814, true, new C10663(closedFloatingPointRangeRangeTo, i15, f, mutableInteractionSource2, z2, list11, sliderColorsM1150colorsq0g_0yA, stateRememberUpdatedState11, function2)), composerStartRestartGroup, 3072, 6);
                    i16 = i14;
                    function3 = function2;
                    sliderColors2 = sliderColorsM1150colorsq0g_0yA;
                    z3 = z2;
                    mutableInteractionSource3 = mutableInteractionSource2;
                    modifier2 = companion;
                }
                scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup == null) {
                    return;
                }
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.SliderKt.Slider.4
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    /* JADX WARN: Multi-variable type inference failed */
                    {
                        super(2);
                    }

                    @Override // kotlin.jvm.functions.Function2
                    public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                        invoke(composer2, num.intValue());
                        return Unit.INSTANCE;
                    }

                    public final void invoke(Composer composer2, int i20) {
                        SliderKt.Slider(f, onValueChange, modifier2, z3, closedFloatingPointRangeRangeTo, i16, function3, mutableInteractionSource3, sliderColors2, composer2, i2 | 1, i3);
                    }
                });
            }
            i4 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
            i8 = i;
            i10 = i3 & 64;
            if (i10 != 0) {
                if ((3670016 & i2) == 0) {
                    function1 = function0;
                    if (composerStartRestartGroup.changed(function1)) {
                        i11 = 1048576;
                    } else {
                        i11 = 524288;
                    }
                    i4 |= i11;
                }
                i12 = i3 & 128;
                if (i12 != 0) {
                    i4 |= 12582912;
                } else if ((i2 & 29360128) == 0) {
                    if (composerStartRestartGroup.changed(mutableInteractionSource)) {
                        i13 = 8388608;
                    } else {
                        i13 = 4194304;
                    }
                    i4 |= i13;
                }
                if ((i2 & 234881024) != 0) {
                    i4 |= ((i3 & 256) == 0 || !composerStartRestartGroup.changed(sliderColors)) ? 33554432 : 67108864;
                }
                if ((i4 & 191739611) == 38347922) {
                    composerStartRestartGroup.startDefaults();
                    if ((i2 & 1) != 0) {
                        if (i17 != 0) {
                            companion = Modifier.INSTANCE;
                        } else {
                            companion = modifier;
                        }
                        if (i5 != 0) {
                            z2 = true;
                        }
                        if ((i3 & 16) != 0) {
                            closedFloatingPointRangeRangeTo = RangesKt.rangeTo(0.0f, 1.0f);
                            i4 &= -57345;
                        } else {
                            closedFloatingPointRangeRangeTo = closedFloatingPointRange2;
                        }
                        if (i7 != 0) {
                            i14 = 0;
                        } else {
                            i14 = i8;
                        }
                        if (i10 != 0) {
                            function2 = null;
                        } else {
                            function2 = function0;
                        }
                        if (i12 != 0) {
                            composerStartRestartGroup.startReplaceableGroup(-492369756);
                            ComposerKt.sourceInformation(composerStartRestartGroup, "C(remember):Composables.kt#9igjgp");
                            objRememberedValue = composerStartRestartGroup.rememberedValue();
                            if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                                objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                            }
                            composerStartRestartGroup.endReplaceableGroup();
                            mutableInteractionSource2 = (MutableInteractionSource) objRememberedValue;
                        } else {
                            mutableInteractionSource2 = mutableInteractionSource;
                        }
                        if ((i3 & 256) != 0) {
                            i15 = i4 & (-234881025);
                            sliderColorsM1150colorsq0g_0yA = SliderDefaults.INSTANCE.m1150colorsq0g_0yA(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 0, 6, 1023);
                        } else {
                            i15 = i4;
                            sliderColorsM1150colorsq0g_0yA = sliderColors;
                        }
                    } else {
                        if (i17 != 0) {
                            companion = Modifier.INSTANCE;
                        } else {
                            companion = modifier;
                        }
                        if (i5 != 0) {
                            z2 = true;
                        }
                        if ((i3 & 16) != 0) {
                            closedFloatingPointRangeRangeTo = RangesKt.rangeTo(0.0f, 1.0f);
                            i4 &= -57345;
                        } else {
                            closedFloatingPointRangeRangeTo = closedFloatingPointRange2;
                        }
                        if (i7 != 0) {
                            i14 = 0;
                        } else {
                            i14 = i8;
                        }
                        if (i10 != 0) {
                            function2 = null;
                        } else {
                            function2 = function0;
                        }
                        if (i12 != 0) {
                            composerStartRestartGroup.startReplaceableGroup(-492369756);
                            ComposerKt.sourceInformation(composerStartRestartGroup, "C(remember):Composables.kt#9igjgp");
                            objRememberedValue = composerStartRestartGroup.rememberedValue();
                            if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                                objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                            }
                            composerStartRestartGroup.endReplaceableGroup();
                            mutableInteractionSource2 = (MutableInteractionSource) objRememberedValue;
                        } else {
                            mutableInteractionSource2 = mutableInteractionSource;
                        }
                        if ((i3 & 256) != 0) {
                            i15 = i4 & (-234881025);
                            sliderColorsM1150colorsq0g_0yA = SliderDefaults.INSTANCE.m1150colorsq0g_0yA(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 0, 6, 1023);
                        } else {
                            i15 = i4;
                            sliderColorsM1150colorsq0g_0yA = sliderColors;
                        }
                    }
                    composerStartRestartGroup.endDefaults();
                    if (i14 < 0) {
                        throw new IllegalArgumentException("steps should be >= 0".toString());
                    }
                    State stateRememberUpdatedState12 = SnapshotStateKt.rememberUpdatedState(onValueChange, composerStartRestartGroup, (i15 >> 3) & 14);
                    Integer numValueOf12 = Integer.valueOf(i14);
                    composerStartRestartGroup.startReplaceableGroup(1157296644);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "C(remember)P(1):Composables.kt#9igjgp");
                    zChanged = composerStartRestartGroup.changed(numValueOf12);
                    objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                    if (!zChanged) {
                        objRememberedValue2 = stepsToTickFractions(i14);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                    } else {
                        objRememberedValue2 = stepsToTickFractions(i14);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                    }
                    composerStartRestartGroup.endReplaceableGroup();
                    List list12 = (List) objRememberedValue2;
                    Modifier modifierMinimumTouchTargetSize12 = TouchTargetKt.minimumTouchTargetSize(companion);
                    float f114 = ThumbRadius;
                    float f115 = 2;
                    BoxWithConstraintsKt.BoxWithConstraints(FocusableKt.focusable(sliderSemantics(SizeKt.m460requiredSizeInqDBjuR0$default(modifierMinimumTouchTargetSize12, Dp.m3843constructorimpl(f114 * f115), Dp.m3843constructorimpl(f114 * f115), 0.0f, 0.0f, 12, null), f, list12, z2, onValueChange, closedFloatingPointRangeRangeTo, i14), z2, mutableInteractionSource2), null, false, ComposableLambdaKt.composableLambda(composerStartRestartGroup, 2085116814, true, new C10663(closedFloatingPointRangeRangeTo, i15, f, mutableInteractionSource2, z2, list12, sliderColorsM1150colorsq0g_0yA, stateRememberUpdatedState12, function2)), composerStartRestartGroup, 3072, 6);
                    i16 = i14;
                    function3 = function2;
                    sliderColors2 = sliderColorsM1150colorsq0g_0yA;
                    z3 = z2;
                    mutableInteractionSource3 = mutableInteractionSource2;
                    modifier2 = companion;
                } else {
                    composerStartRestartGroup.startDefaults();
                    if ((i2 & 1) != 0) {
                        if (i17 != 0) {
                            companion = Modifier.INSTANCE;
                        } else {
                            companion = modifier;
                        }
                        if (i5 != 0) {
                            z2 = true;
                        }
                        if ((i3 & 16) != 0) {
                            closedFloatingPointRangeRangeTo = RangesKt.rangeTo(0.0f, 1.0f);
                            i4 &= -57345;
                        } else {
                            closedFloatingPointRangeRangeTo = closedFloatingPointRange2;
                        }
                        if (i7 != 0) {
                            i14 = 0;
                        } else {
                            i14 = i8;
                        }
                        if (i10 != 0) {
                            function2 = null;
                        } else {
                            function2 = function0;
                        }
                        if (i12 != 0) {
                            composerStartRestartGroup.startReplaceableGroup(-492369756);
                            ComposerKt.sourceInformation(composerStartRestartGroup, "C(remember):Composables.kt#9igjgp");
                            objRememberedValue = composerStartRestartGroup.rememberedValue();
                            if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                                objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                            }
                            composerStartRestartGroup.endReplaceableGroup();
                            mutableInteractionSource2 = (MutableInteractionSource) objRememberedValue;
                        } else {
                            mutableInteractionSource2 = mutableInteractionSource;
                        }
                        if ((i3 & 256) != 0) {
                            i15 = i4 & (-234881025);
                            sliderColorsM1150colorsq0g_0yA = SliderDefaults.INSTANCE.m1150colorsq0g_0yA(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 0, 6, 1023);
                        } else {
                            i15 = i4;
                            sliderColorsM1150colorsq0g_0yA = sliderColors;
                        }
                    } else {
                        if (i17 != 0) {
                            companion = Modifier.INSTANCE;
                        } else {
                            companion = modifier;
                        }
                        if (i5 != 0) {
                            z2 = true;
                        }
                        if ((i3 & 16) != 0) {
                            closedFloatingPointRangeRangeTo = RangesKt.rangeTo(0.0f, 1.0f);
                            i4 &= -57345;
                        } else {
                            closedFloatingPointRangeRangeTo = closedFloatingPointRange2;
                        }
                        if (i7 != 0) {
                            i14 = 0;
                        } else {
                            i14 = i8;
                        }
                        if (i10 != 0) {
                            function2 = null;
                        } else {
                            function2 = function0;
                        }
                        if (i12 != 0) {
                            composerStartRestartGroup.startReplaceableGroup(-492369756);
                            ComposerKt.sourceInformation(composerStartRestartGroup, "C(remember):Composables.kt#9igjgp");
                            objRememberedValue = composerStartRestartGroup.rememberedValue();
                            if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                                objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                            }
                            composerStartRestartGroup.endReplaceableGroup();
                            mutableInteractionSource2 = (MutableInteractionSource) objRememberedValue;
                        } else {
                            mutableInteractionSource2 = mutableInteractionSource;
                        }
                        if ((i3 & 256) != 0) {
                            i15 = i4 & (-234881025);
                            sliderColorsM1150colorsq0g_0yA = SliderDefaults.INSTANCE.m1150colorsq0g_0yA(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 0, 6, 1023);
                        } else {
                            i15 = i4;
                            sliderColorsM1150colorsq0g_0yA = sliderColors;
                        }
                    }
                    composerStartRestartGroup.endDefaults();
                    if (i14 < 0) {
                        throw new IllegalArgumentException("steps should be >= 0".toString());
                    }
                    State stateRememberUpdatedState13 = SnapshotStateKt.rememberUpdatedState(onValueChange, composerStartRestartGroup, (i15 >> 3) & 14);
                    Integer numValueOf13 = Integer.valueOf(i14);
                    composerStartRestartGroup.startReplaceableGroup(1157296644);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "C(remember)P(1):Composables.kt#9igjgp");
                    zChanged = composerStartRestartGroup.changed(numValueOf13);
                    objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                    if (!zChanged) {
                        objRememberedValue2 = stepsToTickFractions(i14);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                    } else {
                        objRememberedValue2 = stepsToTickFractions(i14);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                    }
                    composerStartRestartGroup.endReplaceableGroup();
                    List list13 = (List) objRememberedValue2;
                    Modifier modifierMinimumTouchTargetSize13 = TouchTargetKt.minimumTouchTargetSize(companion);
                    float f116 = ThumbRadius;
                    float f117 = 2;
                    BoxWithConstraintsKt.BoxWithConstraints(FocusableKt.focusable(sliderSemantics(SizeKt.m460requiredSizeInqDBjuR0$default(modifierMinimumTouchTargetSize13, Dp.m3843constructorimpl(f116 * f117), Dp.m3843constructorimpl(f116 * f117), 0.0f, 0.0f, 12, null), f, list13, z2, onValueChange, closedFloatingPointRangeRangeTo, i14), z2, mutableInteractionSource2), null, false, ComposableLambdaKt.composableLambda(composerStartRestartGroup, 2085116814, true, new C10663(closedFloatingPointRangeRangeTo, i15, f, mutableInteractionSource2, z2, list13, sliderColorsM1150colorsq0g_0yA, stateRememberUpdatedState13, function2)), composerStartRestartGroup, 3072, 6);
                    i16 = i14;
                    function3 = function2;
                    sliderColors2 = sliderColorsM1150colorsq0g_0yA;
                    z3 = z2;
                    mutableInteractionSource3 = mutableInteractionSource2;
                    modifier2 = companion;
                }
                scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup == null) {
                    return;
                }
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.SliderKt.Slider.4
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    /* JADX WARN: Multi-variable type inference failed */
                    {
                        super(2);
                    }

                    @Override // kotlin.jvm.functions.Function2
                    public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                        invoke(composer2, num.intValue());
                        return Unit.INSTANCE;
                    }

                    public final void invoke(Composer composer2, int i20) {
                        SliderKt.Slider(f, onValueChange, modifier2, z3, closedFloatingPointRangeRangeTo, i16, function3, mutableInteractionSource3, sliderColors2, composer2, i2 | 1, i3);
                    }
                });
            }
            i4 |= 1572864;
            function1 = function0;
            i12 = i3 & 128;
            if (i12 != 0) {
                i4 |= 12582912;
            } else if ((i2 & 29360128) == 0) {
                if (composerStartRestartGroup.changed(mutableInteractionSource)) {
                    i13 = 8388608;
                } else {
                    i13 = 4194304;
                }
                i4 |= i13;
            }
            if ((i2 & 234881024) != 0) {
                i4 |= ((i3 & 256) == 0 || !composerStartRestartGroup.changed(sliderColors)) ? 33554432 : 67108864;
            }
            if ((i4 & 191739611) == 38347922) {
                composerStartRestartGroup.startDefaults();
                if ((i2 & 1) != 0) {
                    if (i17 != 0) {
                        companion = Modifier.INSTANCE;
                    } else {
                        companion = modifier;
                    }
                    if (i5 != 0) {
                        z2 = true;
                    }
                    if ((i3 & 16) != 0) {
                        closedFloatingPointRangeRangeTo = RangesKt.rangeTo(0.0f, 1.0f);
                        i4 &= -57345;
                    } else {
                        closedFloatingPointRangeRangeTo = closedFloatingPointRange2;
                    }
                    if (i7 != 0) {
                        i14 = 0;
                    } else {
                        i14 = i8;
                    }
                    if (i10 != 0) {
                        function2 = null;
                    } else {
                        function2 = function0;
                    }
                    if (i12 != 0) {
                        composerStartRestartGroup.startReplaceableGroup(-492369756);
                        ComposerKt.sourceInformation(composerStartRestartGroup, "C(remember):Composables.kt#9igjgp");
                        objRememberedValue = composerStartRestartGroup.rememberedValue();
                        if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                            objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                        }
                        composerStartRestartGroup.endReplaceableGroup();
                        mutableInteractionSource2 = (MutableInteractionSource) objRememberedValue;
                    } else {
                        mutableInteractionSource2 = mutableInteractionSource;
                    }
                    if ((i3 & 256) != 0) {
                        i15 = i4 & (-234881025);
                        sliderColorsM1150colorsq0g_0yA = SliderDefaults.INSTANCE.m1150colorsq0g_0yA(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 0, 6, 1023);
                    } else {
                        i15 = i4;
                        sliderColorsM1150colorsq0g_0yA = sliderColors;
                    }
                } else {
                    if (i17 != 0) {
                        companion = Modifier.INSTANCE;
                    } else {
                        companion = modifier;
                    }
                    if (i5 != 0) {
                        z2 = true;
                    }
                    if ((i3 & 16) != 0) {
                        closedFloatingPointRangeRangeTo = RangesKt.rangeTo(0.0f, 1.0f);
                        i4 &= -57345;
                    } else {
                        closedFloatingPointRangeRangeTo = closedFloatingPointRange2;
                    }
                    if (i7 != 0) {
                        i14 = 0;
                    } else {
                        i14 = i8;
                    }
                    if (i10 != 0) {
                        function2 = null;
                    } else {
                        function2 = function0;
                    }
                    if (i12 != 0) {
                        composerStartRestartGroup.startReplaceableGroup(-492369756);
                        ComposerKt.sourceInformation(composerStartRestartGroup, "C(remember):Composables.kt#9igjgp");
                        objRememberedValue = composerStartRestartGroup.rememberedValue();
                        if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                            objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                        }
                        composerStartRestartGroup.endReplaceableGroup();
                        mutableInteractionSource2 = (MutableInteractionSource) objRememberedValue;
                    } else {
                        mutableInteractionSource2 = mutableInteractionSource;
                    }
                    if ((i3 & 256) != 0) {
                        i15 = i4 & (-234881025);
                        sliderColorsM1150colorsq0g_0yA = SliderDefaults.INSTANCE.m1150colorsq0g_0yA(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 0, 6, 1023);
                    } else {
                        i15 = i4;
                        sliderColorsM1150colorsq0g_0yA = sliderColors;
                    }
                }
                composerStartRestartGroup.endDefaults();
                if (i14 < 0) {
                    throw new IllegalArgumentException("steps should be >= 0".toString());
                }
                State stateRememberUpdatedState14 = SnapshotStateKt.rememberUpdatedState(onValueChange, composerStartRestartGroup, (i15 >> 3) & 14);
                Integer numValueOf14 = Integer.valueOf(i14);
                composerStartRestartGroup.startReplaceableGroup(1157296644);
                ComposerKt.sourceInformation(composerStartRestartGroup, "C(remember)P(1):Composables.kt#9igjgp");
                zChanged = composerStartRestartGroup.changed(numValueOf14);
                objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                if (!zChanged) {
                    objRememberedValue2 = stepsToTickFractions(i14);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                } else {
                    objRememberedValue2 = stepsToTickFractions(i14);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                }
                composerStartRestartGroup.endReplaceableGroup();
                List list14 = (List) objRememberedValue2;
                Modifier modifierMinimumTouchTargetSize14 = TouchTargetKt.minimumTouchTargetSize(companion);
                float f118 = ThumbRadius;
                float f119 = 2;
                BoxWithConstraintsKt.BoxWithConstraints(FocusableKt.focusable(sliderSemantics(SizeKt.m460requiredSizeInqDBjuR0$default(modifierMinimumTouchTargetSize14, Dp.m3843constructorimpl(f118 * f119), Dp.m3843constructorimpl(f118 * f119), 0.0f, 0.0f, 12, null), f, list14, z2, onValueChange, closedFloatingPointRangeRangeTo, i14), z2, mutableInteractionSource2), null, false, ComposableLambdaKt.composableLambda(composerStartRestartGroup, 2085116814, true, new C10663(closedFloatingPointRangeRangeTo, i15, f, mutableInteractionSource2, z2, list14, sliderColorsM1150colorsq0g_0yA, stateRememberUpdatedState14, function2)), composerStartRestartGroup, 3072, 6);
                i16 = i14;
                function3 = function2;
                sliderColors2 = sliderColorsM1150colorsq0g_0yA;
                z3 = z2;
                mutableInteractionSource3 = mutableInteractionSource2;
                modifier2 = companion;
            } else {
                composerStartRestartGroup.startDefaults();
                if ((i2 & 1) != 0) {
                    if (i17 != 0) {
                        companion = Modifier.INSTANCE;
                    } else {
                        companion = modifier;
                    }
                    if (i5 != 0) {
                        z2 = true;
                    }
                    if ((i3 & 16) != 0) {
                        closedFloatingPointRangeRangeTo = RangesKt.rangeTo(0.0f, 1.0f);
                        i4 &= -57345;
                    } else {
                        closedFloatingPointRangeRangeTo = closedFloatingPointRange2;
                    }
                    if (i7 != 0) {
                        i14 = 0;
                    } else {
                        i14 = i8;
                    }
                    if (i10 != 0) {
                        function2 = null;
                    } else {
                        function2 = function0;
                    }
                    if (i12 != 0) {
                        composerStartRestartGroup.startReplaceableGroup(-492369756);
                        ComposerKt.sourceInformation(composerStartRestartGroup, "C(remember):Composables.kt#9igjgp");
                        objRememberedValue = composerStartRestartGroup.rememberedValue();
                        if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                            objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                        }
                        composerStartRestartGroup.endReplaceableGroup();
                        mutableInteractionSource2 = (MutableInteractionSource) objRememberedValue;
                    } else {
                        mutableInteractionSource2 = mutableInteractionSource;
                    }
                    if ((i3 & 256) != 0) {
                        i15 = i4 & (-234881025);
                        sliderColorsM1150colorsq0g_0yA = SliderDefaults.INSTANCE.m1150colorsq0g_0yA(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 0, 6, 1023);
                    } else {
                        i15 = i4;
                        sliderColorsM1150colorsq0g_0yA = sliderColors;
                    }
                } else {
                    if (i17 != 0) {
                        companion = Modifier.INSTANCE;
                    } else {
                        companion = modifier;
                    }
                    if (i5 != 0) {
                        z2 = true;
                    }
                    if ((i3 & 16) != 0) {
                        closedFloatingPointRangeRangeTo = RangesKt.rangeTo(0.0f, 1.0f);
                        i4 &= -57345;
                    } else {
                        closedFloatingPointRangeRangeTo = closedFloatingPointRange2;
                    }
                    if (i7 != 0) {
                        i14 = 0;
                    } else {
                        i14 = i8;
                    }
                    if (i10 != 0) {
                        function2 = null;
                    } else {
                        function2 = function0;
                    }
                    if (i12 != 0) {
                        composerStartRestartGroup.startReplaceableGroup(-492369756);
                        ComposerKt.sourceInformation(composerStartRestartGroup, "C(remember):Composables.kt#9igjgp");
                        objRememberedValue = composerStartRestartGroup.rememberedValue();
                        if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                            objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                        }
                        composerStartRestartGroup.endReplaceableGroup();
                        mutableInteractionSource2 = (MutableInteractionSource) objRememberedValue;
                    } else {
                        mutableInteractionSource2 = mutableInteractionSource;
                    }
                    if ((i3 & 256) != 0) {
                        i15 = i4 & (-234881025);
                        sliderColorsM1150colorsq0g_0yA = SliderDefaults.INSTANCE.m1150colorsq0g_0yA(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 0, 6, 1023);
                    } else {
                        i15 = i4;
                        sliderColorsM1150colorsq0g_0yA = sliderColors;
                    }
                }
                composerStartRestartGroup.endDefaults();
                if (i14 < 0) {
                    throw new IllegalArgumentException("steps should be >= 0".toString());
                }
                State stateRememberUpdatedState15 = SnapshotStateKt.rememberUpdatedState(onValueChange, composerStartRestartGroup, (i15 >> 3) & 14);
                Integer numValueOf15 = Integer.valueOf(i14);
                composerStartRestartGroup.startReplaceableGroup(1157296644);
                ComposerKt.sourceInformation(composerStartRestartGroup, "C(remember)P(1):Composables.kt#9igjgp");
                zChanged = composerStartRestartGroup.changed(numValueOf15);
                objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                if (!zChanged) {
                    objRememberedValue2 = stepsToTickFractions(i14);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                } else {
                    objRememberedValue2 = stepsToTickFractions(i14);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                }
                composerStartRestartGroup.endReplaceableGroup();
                List list15 = (List) objRememberedValue2;
                Modifier modifierMinimumTouchTargetSize15 = TouchTargetKt.minimumTouchTargetSize(companion);
                float f1110 = ThumbRadius;
                float f1111 = 2;
                BoxWithConstraintsKt.BoxWithConstraints(FocusableKt.focusable(sliderSemantics(SizeKt.m460requiredSizeInqDBjuR0$default(modifierMinimumTouchTargetSize15, Dp.m3843constructorimpl(f1110 * f1111), Dp.m3843constructorimpl(f1110 * f1111), 0.0f, 0.0f, 12, null), f, list15, z2, onValueChange, closedFloatingPointRangeRangeTo, i14), z2, mutableInteractionSource2), null, false, ComposableLambdaKt.composableLambda(composerStartRestartGroup, 2085116814, true, new C10663(closedFloatingPointRangeRangeTo, i15, f, mutableInteractionSource2, z2, list15, sliderColorsM1150colorsq0g_0yA, stateRememberUpdatedState15, function2)), composerStartRestartGroup, 3072, 6);
                i16 = i14;
                function3 = function2;
                sliderColors2 = sliderColorsM1150colorsq0g_0yA;
                z3 = z2;
                mutableInteractionSource3 = mutableInteractionSource2;
                modifier2 = companion;
            }
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup == null) {
                return;
            }
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.SliderKt.Slider.4
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                    invoke(composer2, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(Composer composer2, int i20) {
                    SliderKt.Slider(f, onValueChange, modifier2, z3, closedFloatingPointRangeRangeTo, i16, function3, mutableInteractionSource3, sliderColors2, composer2, i2 | 1, i3);
                }
            });
        }
        i4 |= 384;
        i5 = i3 & 8;
        if (i5 != 0) {
            if ((i2 & 7168) == 0) {
                z2 = z;
                if (composerStartRestartGroup.changed(z2)) {
                    i6 = 2048;
                } else {
                    i6 = 1024;
                }
                i4 |= i6;
            }
            if ((57344 & i2) == 0) {
                if ((i3 & 16) == 0) {
                    closedFloatingPointRange2 = closedFloatingPointRange;
                    if (composerStartRestartGroup.changed(closedFloatingPointRange2)) {
                    }
                    i4 |= i18;
                } else {
                    closedFloatingPointRange2 = closedFloatingPointRange;
                }
                i4 |= i18;
            } else {
                closedFloatingPointRange2 = closedFloatingPointRange;
            }
            i7 = i3 & 32;
            if (i7 != 0) {
                if ((458752 & i2) == 0) {
                    i8 = i;
                    if (composerStartRestartGroup.changed(i8)) {
                        i9 = 131072;
                    } else {
                        i9 = 65536;
                    }
                    i4 |= i9;
                }
                i10 = i3 & 64;
                if (i10 != 0) {
                    if ((3670016 & i2) == 0) {
                        function1 = function0;
                        if (composerStartRestartGroup.changed(function1)) {
                            i11 = 1048576;
                        } else {
                            i11 = 524288;
                        }
                        i4 |= i11;
                    }
                    i12 = i3 & 128;
                    if (i12 != 0) {
                        i4 |= 12582912;
                    } else if ((i2 & 29360128) == 0) {
                        if (composerStartRestartGroup.changed(mutableInteractionSource)) {
                            i13 = 8388608;
                        } else {
                            i13 = 4194304;
                        }
                        i4 |= i13;
                    }
                    if ((i2 & 234881024) != 0) {
                        i4 |= ((i3 & 256) == 0 || !composerStartRestartGroup.changed(sliderColors)) ? 33554432 : 67108864;
                    }
                    if ((i4 & 191739611) == 38347922) {
                        composerStartRestartGroup.startDefaults();
                        if ((i2 & 1) != 0) {
                            if (i17 != 0) {
                                companion = Modifier.INSTANCE;
                            } else {
                                companion = modifier;
                            }
                            if (i5 != 0) {
                                z2 = true;
                            }
                            if ((i3 & 16) != 0) {
                                closedFloatingPointRangeRangeTo = RangesKt.rangeTo(0.0f, 1.0f);
                                i4 &= -57345;
                            } else {
                                closedFloatingPointRangeRangeTo = closedFloatingPointRange2;
                            }
                            if (i7 != 0) {
                                i14 = 0;
                            } else {
                                i14 = i8;
                            }
                            if (i10 != 0) {
                                function2 = null;
                            } else {
                                function2 = function0;
                            }
                            if (i12 != 0) {
                                composerStartRestartGroup.startReplaceableGroup(-492369756);
                                ComposerKt.sourceInformation(composerStartRestartGroup, "C(remember):Composables.kt#9igjgp");
                                objRememberedValue = composerStartRestartGroup.rememberedValue();
                                if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                                    objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                                }
                                composerStartRestartGroup.endReplaceableGroup();
                                mutableInteractionSource2 = (MutableInteractionSource) objRememberedValue;
                            } else {
                                mutableInteractionSource2 = mutableInteractionSource;
                            }
                            if ((i3 & 256) != 0) {
                                i15 = i4 & (-234881025);
                                sliderColorsM1150colorsq0g_0yA = SliderDefaults.INSTANCE.m1150colorsq0g_0yA(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 0, 6, 1023);
                            } else {
                                i15 = i4;
                                sliderColorsM1150colorsq0g_0yA = sliderColors;
                            }
                        } else {
                            if (i17 != 0) {
                                companion = Modifier.INSTANCE;
                            } else {
                                companion = modifier;
                            }
                            if (i5 != 0) {
                                z2 = true;
                            }
                            if ((i3 & 16) != 0) {
                                closedFloatingPointRangeRangeTo = RangesKt.rangeTo(0.0f, 1.0f);
                                i4 &= -57345;
                            } else {
                                closedFloatingPointRangeRangeTo = closedFloatingPointRange2;
                            }
                            if (i7 != 0) {
                                i14 = 0;
                            } else {
                                i14 = i8;
                            }
                            if (i10 != 0) {
                                function2 = null;
                            } else {
                                function2 = function0;
                            }
                            if (i12 != 0) {
                                composerStartRestartGroup.startReplaceableGroup(-492369756);
                                ComposerKt.sourceInformation(composerStartRestartGroup, "C(remember):Composables.kt#9igjgp");
                                objRememberedValue = composerStartRestartGroup.rememberedValue();
                                if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                                    objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                                }
                                composerStartRestartGroup.endReplaceableGroup();
                                mutableInteractionSource2 = (MutableInteractionSource) objRememberedValue;
                            } else {
                                mutableInteractionSource2 = mutableInteractionSource;
                            }
                            if ((i3 & 256) != 0) {
                                i15 = i4 & (-234881025);
                                sliderColorsM1150colorsq0g_0yA = SliderDefaults.INSTANCE.m1150colorsq0g_0yA(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 0, 6, 1023);
                            } else {
                                i15 = i4;
                                sliderColorsM1150colorsq0g_0yA = sliderColors;
                            }
                        }
                        composerStartRestartGroup.endDefaults();
                        if (i14 < 0) {
                            throw new IllegalArgumentException("steps should be >= 0".toString());
                        }
                        State stateRememberUpdatedState16 = SnapshotStateKt.rememberUpdatedState(onValueChange, composerStartRestartGroup, (i15 >> 3) & 14);
                        Integer numValueOf16 = Integer.valueOf(i14);
                        composerStartRestartGroup.startReplaceableGroup(1157296644);
                        ComposerKt.sourceInformation(composerStartRestartGroup, "C(remember)P(1):Composables.kt#9igjgp");
                        zChanged = composerStartRestartGroup.changed(numValueOf16);
                        objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                        if (!zChanged) {
                            objRememberedValue2 = stepsToTickFractions(i14);
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                        } else {
                            objRememberedValue2 = stepsToTickFractions(i14);
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                        }
                        composerStartRestartGroup.endReplaceableGroup();
                        List list16 = (List) objRememberedValue2;
                        Modifier modifierMinimumTouchTargetSize16 = TouchTargetKt.minimumTouchTargetSize(companion);
                        float f1112 = ThumbRadius;
                        float f1113 = 2;
                        BoxWithConstraintsKt.BoxWithConstraints(FocusableKt.focusable(sliderSemantics(SizeKt.m460requiredSizeInqDBjuR0$default(modifierMinimumTouchTargetSize16, Dp.m3843constructorimpl(f1112 * f1113), Dp.m3843constructorimpl(f1112 * f1113), 0.0f, 0.0f, 12, null), f, list16, z2, onValueChange, closedFloatingPointRangeRangeTo, i14), z2, mutableInteractionSource2), null, false, ComposableLambdaKt.composableLambda(composerStartRestartGroup, 2085116814, true, new C10663(closedFloatingPointRangeRangeTo, i15, f, mutableInteractionSource2, z2, list16, sliderColorsM1150colorsq0g_0yA, stateRememberUpdatedState16, function2)), composerStartRestartGroup, 3072, 6);
                        i16 = i14;
                        function3 = function2;
                        sliderColors2 = sliderColorsM1150colorsq0g_0yA;
                        z3 = z2;
                        mutableInteractionSource3 = mutableInteractionSource2;
                        modifier2 = companion;
                    } else {
                        composerStartRestartGroup.startDefaults();
                        if ((i2 & 1) != 0) {
                            if (i17 != 0) {
                                companion = Modifier.INSTANCE;
                            } else {
                                companion = modifier;
                            }
                            if (i5 != 0) {
                                z2 = true;
                            }
                            if ((i3 & 16) != 0) {
                                closedFloatingPointRangeRangeTo = RangesKt.rangeTo(0.0f, 1.0f);
                                i4 &= -57345;
                            } else {
                                closedFloatingPointRangeRangeTo = closedFloatingPointRange2;
                            }
                            if (i7 != 0) {
                                i14 = 0;
                            } else {
                                i14 = i8;
                            }
                            if (i10 != 0) {
                                function2 = null;
                            } else {
                                function2 = function0;
                            }
                            if (i12 != 0) {
                                composerStartRestartGroup.startReplaceableGroup(-492369756);
                                ComposerKt.sourceInformation(composerStartRestartGroup, "C(remember):Composables.kt#9igjgp");
                                objRememberedValue = composerStartRestartGroup.rememberedValue();
                                if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                                    objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                                }
                                composerStartRestartGroup.endReplaceableGroup();
                                mutableInteractionSource2 = (MutableInteractionSource) objRememberedValue;
                            } else {
                                mutableInteractionSource2 = mutableInteractionSource;
                            }
                            if ((i3 & 256) != 0) {
                                i15 = i4 & (-234881025);
                                sliderColorsM1150colorsq0g_0yA = SliderDefaults.INSTANCE.m1150colorsq0g_0yA(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 0, 6, 1023);
                            } else {
                                i15 = i4;
                                sliderColorsM1150colorsq0g_0yA = sliderColors;
                            }
                        } else {
                            if (i17 != 0) {
                                companion = Modifier.INSTANCE;
                            } else {
                                companion = modifier;
                            }
                            if (i5 != 0) {
                                z2 = true;
                            }
                            if ((i3 & 16) != 0) {
                                closedFloatingPointRangeRangeTo = RangesKt.rangeTo(0.0f, 1.0f);
                                i4 &= -57345;
                            } else {
                                closedFloatingPointRangeRangeTo = closedFloatingPointRange2;
                            }
                            if (i7 != 0) {
                                i14 = 0;
                            } else {
                                i14 = i8;
                            }
                            if (i10 != 0) {
                                function2 = null;
                            } else {
                                function2 = function0;
                            }
                            if (i12 != 0) {
                                composerStartRestartGroup.startReplaceableGroup(-492369756);
                                ComposerKt.sourceInformation(composerStartRestartGroup, "C(remember):Composables.kt#9igjgp");
                                objRememberedValue = composerStartRestartGroup.rememberedValue();
                                if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                                    objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                                }
                                composerStartRestartGroup.endReplaceableGroup();
                                mutableInteractionSource2 = (MutableInteractionSource) objRememberedValue;
                            } else {
                                mutableInteractionSource2 = mutableInteractionSource;
                            }
                            if ((i3 & 256) != 0) {
                                i15 = i4 & (-234881025);
                                sliderColorsM1150colorsq0g_0yA = SliderDefaults.INSTANCE.m1150colorsq0g_0yA(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 0, 6, 1023);
                            } else {
                                i15 = i4;
                                sliderColorsM1150colorsq0g_0yA = sliderColors;
                            }
                        }
                        composerStartRestartGroup.endDefaults();
                        if (i14 < 0) {
                            throw new IllegalArgumentException("steps should be >= 0".toString());
                        }
                        State stateRememberUpdatedState17 = SnapshotStateKt.rememberUpdatedState(onValueChange, composerStartRestartGroup, (i15 >> 3) & 14);
                        Integer numValueOf17 = Integer.valueOf(i14);
                        composerStartRestartGroup.startReplaceableGroup(1157296644);
                        ComposerKt.sourceInformation(composerStartRestartGroup, "C(remember)P(1):Composables.kt#9igjgp");
                        zChanged = composerStartRestartGroup.changed(numValueOf17);
                        objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                        if (!zChanged) {
                            objRememberedValue2 = stepsToTickFractions(i14);
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                        } else {
                            objRememberedValue2 = stepsToTickFractions(i14);
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                        }
                        composerStartRestartGroup.endReplaceableGroup();
                        List list17 = (List) objRememberedValue2;
                        Modifier modifierMinimumTouchTargetSize17 = TouchTargetKt.minimumTouchTargetSize(companion);
                        float f1114 = ThumbRadius;
                        float f1115 = 2;
                        BoxWithConstraintsKt.BoxWithConstraints(FocusableKt.focusable(sliderSemantics(SizeKt.m460requiredSizeInqDBjuR0$default(modifierMinimumTouchTargetSize17, Dp.m3843constructorimpl(f1114 * f1115), Dp.m3843constructorimpl(f1114 * f1115), 0.0f, 0.0f, 12, null), f, list17, z2, onValueChange, closedFloatingPointRangeRangeTo, i14), z2, mutableInteractionSource2), null, false, ComposableLambdaKt.composableLambda(composerStartRestartGroup, 2085116814, true, new C10663(closedFloatingPointRangeRangeTo, i15, f, mutableInteractionSource2, z2, list17, sliderColorsM1150colorsq0g_0yA, stateRememberUpdatedState17, function2)), composerStartRestartGroup, 3072, 6);
                        i16 = i14;
                        function3 = function2;
                        sliderColors2 = sliderColorsM1150colorsq0g_0yA;
                        z3 = z2;
                        mutableInteractionSource3 = mutableInteractionSource2;
                        modifier2 = companion;
                    }
                    scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup == null) {
                        return;
                    }
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.SliderKt.Slider.4
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        /* JADX WARN: Multi-variable type inference failed */
                        {
                            super(2);
                        }

                        @Override // kotlin.jvm.functions.Function2
                        public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                            invoke(composer2, num.intValue());
                            return Unit.INSTANCE;
                        }

                        public final void invoke(Composer composer2, int i20) {
                            SliderKt.Slider(f, onValueChange, modifier2, z3, closedFloatingPointRangeRangeTo, i16, function3, mutableInteractionSource3, sliderColors2, composer2, i2 | 1, i3);
                        }
                    });
                }
                i4 |= 1572864;
                function1 = function0;
                i12 = i3 & 128;
                if (i12 != 0) {
                    i4 |= 12582912;
                } else if ((i2 & 29360128) == 0) {
                    if (composerStartRestartGroup.changed(mutableInteractionSource)) {
                        i13 = 8388608;
                    } else {
                        i13 = 4194304;
                    }
                    i4 |= i13;
                }
                if ((i2 & 234881024) != 0) {
                    i4 |= ((i3 & 256) == 0 || !composerStartRestartGroup.changed(sliderColors)) ? 33554432 : 67108864;
                }
                if ((i4 & 191739611) == 38347922) {
                    composerStartRestartGroup.startDefaults();
                    if ((i2 & 1) != 0) {
                        if (i17 != 0) {
                            companion = Modifier.INSTANCE;
                        } else {
                            companion = modifier;
                        }
                        if (i5 != 0) {
                            z2 = true;
                        }
                        if ((i3 & 16) != 0) {
                            closedFloatingPointRangeRangeTo = RangesKt.rangeTo(0.0f, 1.0f);
                            i4 &= -57345;
                        } else {
                            closedFloatingPointRangeRangeTo = closedFloatingPointRange2;
                        }
                        if (i7 != 0) {
                            i14 = 0;
                        } else {
                            i14 = i8;
                        }
                        if (i10 != 0) {
                            function2 = null;
                        } else {
                            function2 = function0;
                        }
                        if (i12 != 0) {
                            composerStartRestartGroup.startReplaceableGroup(-492369756);
                            ComposerKt.sourceInformation(composerStartRestartGroup, "C(remember):Composables.kt#9igjgp");
                            objRememberedValue = composerStartRestartGroup.rememberedValue();
                            if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                                objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                            }
                            composerStartRestartGroup.endReplaceableGroup();
                            mutableInteractionSource2 = (MutableInteractionSource) objRememberedValue;
                        } else {
                            mutableInteractionSource2 = mutableInteractionSource;
                        }
                        if ((i3 & 256) != 0) {
                            i15 = i4 & (-234881025);
                            sliderColorsM1150colorsq0g_0yA = SliderDefaults.INSTANCE.m1150colorsq0g_0yA(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 0, 6, 1023);
                        } else {
                            i15 = i4;
                            sliderColorsM1150colorsq0g_0yA = sliderColors;
                        }
                    } else {
                        if (i17 != 0) {
                            companion = Modifier.INSTANCE;
                        } else {
                            companion = modifier;
                        }
                        if (i5 != 0) {
                            z2 = true;
                        }
                        if ((i3 & 16) != 0) {
                            closedFloatingPointRangeRangeTo = RangesKt.rangeTo(0.0f, 1.0f);
                            i4 &= -57345;
                        } else {
                            closedFloatingPointRangeRangeTo = closedFloatingPointRange2;
                        }
                        if (i7 != 0) {
                            i14 = 0;
                        } else {
                            i14 = i8;
                        }
                        if (i10 != 0) {
                            function2 = null;
                        } else {
                            function2 = function0;
                        }
                        if (i12 != 0) {
                            composerStartRestartGroup.startReplaceableGroup(-492369756);
                            ComposerKt.sourceInformation(composerStartRestartGroup, "C(remember):Composables.kt#9igjgp");
                            objRememberedValue = composerStartRestartGroup.rememberedValue();
                            if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                                objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                            }
                            composerStartRestartGroup.endReplaceableGroup();
                            mutableInteractionSource2 = (MutableInteractionSource) objRememberedValue;
                        } else {
                            mutableInteractionSource2 = mutableInteractionSource;
                        }
                        if ((i3 & 256) != 0) {
                            i15 = i4 & (-234881025);
                            sliderColorsM1150colorsq0g_0yA = SliderDefaults.INSTANCE.m1150colorsq0g_0yA(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 0, 6, 1023);
                        } else {
                            i15 = i4;
                            sliderColorsM1150colorsq0g_0yA = sliderColors;
                        }
                    }
                    composerStartRestartGroup.endDefaults();
                    if (i14 < 0) {
                        throw new IllegalArgumentException("steps should be >= 0".toString());
                    }
                    State stateRememberUpdatedState18 = SnapshotStateKt.rememberUpdatedState(onValueChange, composerStartRestartGroup, (i15 >> 3) & 14);
                    Integer numValueOf18 = Integer.valueOf(i14);
                    composerStartRestartGroup.startReplaceableGroup(1157296644);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "C(remember)P(1):Composables.kt#9igjgp");
                    zChanged = composerStartRestartGroup.changed(numValueOf18);
                    objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                    if (!zChanged) {
                        objRememberedValue2 = stepsToTickFractions(i14);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                    } else {
                        objRememberedValue2 = stepsToTickFractions(i14);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                    }
                    composerStartRestartGroup.endReplaceableGroup();
                    List list18 = (List) objRememberedValue2;
                    Modifier modifierMinimumTouchTargetSize18 = TouchTargetKt.minimumTouchTargetSize(companion);
                    float f1116 = ThumbRadius;
                    float f1117 = 2;
                    BoxWithConstraintsKt.BoxWithConstraints(FocusableKt.focusable(sliderSemantics(SizeKt.m460requiredSizeInqDBjuR0$default(modifierMinimumTouchTargetSize18, Dp.m3843constructorimpl(f1116 * f1117), Dp.m3843constructorimpl(f1116 * f1117), 0.0f, 0.0f, 12, null), f, list18, z2, onValueChange, closedFloatingPointRangeRangeTo, i14), z2, mutableInteractionSource2), null, false, ComposableLambdaKt.composableLambda(composerStartRestartGroup, 2085116814, true, new C10663(closedFloatingPointRangeRangeTo, i15, f, mutableInteractionSource2, z2, list18, sliderColorsM1150colorsq0g_0yA, stateRememberUpdatedState18, function2)), composerStartRestartGroup, 3072, 6);
                    i16 = i14;
                    function3 = function2;
                    sliderColors2 = sliderColorsM1150colorsq0g_0yA;
                    z3 = z2;
                    mutableInteractionSource3 = mutableInteractionSource2;
                    modifier2 = companion;
                } else {
                    composerStartRestartGroup.startDefaults();
                    if ((i2 & 1) != 0) {
                        if (i17 != 0) {
                            companion = Modifier.INSTANCE;
                        } else {
                            companion = modifier;
                        }
                        if (i5 != 0) {
                            z2 = true;
                        }
                        if ((i3 & 16) != 0) {
                            closedFloatingPointRangeRangeTo = RangesKt.rangeTo(0.0f, 1.0f);
                            i4 &= -57345;
                        } else {
                            closedFloatingPointRangeRangeTo = closedFloatingPointRange2;
                        }
                        if (i7 != 0) {
                            i14 = 0;
                        } else {
                            i14 = i8;
                        }
                        if (i10 != 0) {
                            function2 = null;
                        } else {
                            function2 = function0;
                        }
                        if (i12 != 0) {
                            composerStartRestartGroup.startReplaceableGroup(-492369756);
                            ComposerKt.sourceInformation(composerStartRestartGroup, "C(remember):Composables.kt#9igjgp");
                            objRememberedValue = composerStartRestartGroup.rememberedValue();
                            if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                                objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                            }
                            composerStartRestartGroup.endReplaceableGroup();
                            mutableInteractionSource2 = (MutableInteractionSource) objRememberedValue;
                        } else {
                            mutableInteractionSource2 = mutableInteractionSource;
                        }
                        if ((i3 & 256) != 0) {
                            i15 = i4 & (-234881025);
                            sliderColorsM1150colorsq0g_0yA = SliderDefaults.INSTANCE.m1150colorsq0g_0yA(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 0, 6, 1023);
                        } else {
                            i15 = i4;
                            sliderColorsM1150colorsq0g_0yA = sliderColors;
                        }
                    } else {
                        if (i17 != 0) {
                            companion = Modifier.INSTANCE;
                        } else {
                            companion = modifier;
                        }
                        if (i5 != 0) {
                            z2 = true;
                        }
                        if ((i3 & 16) != 0) {
                            closedFloatingPointRangeRangeTo = RangesKt.rangeTo(0.0f, 1.0f);
                            i4 &= -57345;
                        } else {
                            closedFloatingPointRangeRangeTo = closedFloatingPointRange2;
                        }
                        if (i7 != 0) {
                            i14 = 0;
                        } else {
                            i14 = i8;
                        }
                        if (i10 != 0) {
                            function2 = null;
                        } else {
                            function2 = function0;
                        }
                        if (i12 != 0) {
                            composerStartRestartGroup.startReplaceableGroup(-492369756);
                            ComposerKt.sourceInformation(composerStartRestartGroup, "C(remember):Composables.kt#9igjgp");
                            objRememberedValue = composerStartRestartGroup.rememberedValue();
                            if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                                objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                            }
                            composerStartRestartGroup.endReplaceableGroup();
                            mutableInteractionSource2 = (MutableInteractionSource) objRememberedValue;
                        } else {
                            mutableInteractionSource2 = mutableInteractionSource;
                        }
                        if ((i3 & 256) != 0) {
                            i15 = i4 & (-234881025);
                            sliderColorsM1150colorsq0g_0yA = SliderDefaults.INSTANCE.m1150colorsq0g_0yA(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 0, 6, 1023);
                        } else {
                            i15 = i4;
                            sliderColorsM1150colorsq0g_0yA = sliderColors;
                        }
                    }
                    composerStartRestartGroup.endDefaults();
                    if (i14 < 0) {
                        throw new IllegalArgumentException("steps should be >= 0".toString());
                    }
                    State stateRememberUpdatedState19 = SnapshotStateKt.rememberUpdatedState(onValueChange, composerStartRestartGroup, (i15 >> 3) & 14);
                    Integer numValueOf19 = Integer.valueOf(i14);
                    composerStartRestartGroup.startReplaceableGroup(1157296644);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "C(remember)P(1):Composables.kt#9igjgp");
                    zChanged = composerStartRestartGroup.changed(numValueOf19);
                    objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                    if (!zChanged) {
                        objRememberedValue2 = stepsToTickFractions(i14);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                    } else {
                        objRememberedValue2 = stepsToTickFractions(i14);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                    }
                    composerStartRestartGroup.endReplaceableGroup();
                    List list19 = (List) objRememberedValue2;
                    Modifier modifierMinimumTouchTargetSize19 = TouchTargetKt.minimumTouchTargetSize(companion);
                    float f1118 = ThumbRadius;
                    float f1119 = 2;
                    BoxWithConstraintsKt.BoxWithConstraints(FocusableKt.focusable(sliderSemantics(SizeKt.m460requiredSizeInqDBjuR0$default(modifierMinimumTouchTargetSize19, Dp.m3843constructorimpl(f1118 * f1119), Dp.m3843constructorimpl(f1118 * f1119), 0.0f, 0.0f, 12, null), f, list19, z2, onValueChange, closedFloatingPointRangeRangeTo, i14), z2, mutableInteractionSource2), null, false, ComposableLambdaKt.composableLambda(composerStartRestartGroup, 2085116814, true, new C10663(closedFloatingPointRangeRangeTo, i15, f, mutableInteractionSource2, z2, list19, sliderColorsM1150colorsq0g_0yA, stateRememberUpdatedState19, function2)), composerStartRestartGroup, 3072, 6);
                    i16 = i14;
                    function3 = function2;
                    sliderColors2 = sliderColorsM1150colorsq0g_0yA;
                    z3 = z2;
                    mutableInteractionSource3 = mutableInteractionSource2;
                    modifier2 = companion;
                }
                scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup == null) {
                    return;
                }
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.SliderKt.Slider.4
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    /* JADX WARN: Multi-variable type inference failed */
                    {
                        super(2);
                    }

                    @Override // kotlin.jvm.functions.Function2
                    public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                        invoke(composer2, num.intValue());
                        return Unit.INSTANCE;
                    }

                    public final void invoke(Composer composer2, int i20) {
                        SliderKt.Slider(f, onValueChange, modifier2, z3, closedFloatingPointRangeRangeTo, i16, function3, mutableInteractionSource3, sliderColors2, composer2, i2 | 1, i3);
                    }
                });
            }
            i4 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
            i8 = i;
            i10 = i3 & 64;
            if (i10 != 0) {
                if ((3670016 & i2) == 0) {
                    function1 = function0;
                    if (composerStartRestartGroup.changed(function1)) {
                        i11 = 1048576;
                    } else {
                        i11 = 524288;
                    }
                    i4 |= i11;
                }
                i12 = i3 & 128;
                if (i12 != 0) {
                    i4 |= 12582912;
                } else if ((i2 & 29360128) == 0) {
                    if (composerStartRestartGroup.changed(mutableInteractionSource)) {
                        i13 = 8388608;
                    } else {
                        i13 = 4194304;
                    }
                    i4 |= i13;
                }
                if ((i2 & 234881024) != 0) {
                    i4 |= ((i3 & 256) == 0 || !composerStartRestartGroup.changed(sliderColors)) ? 33554432 : 67108864;
                }
                if ((i4 & 191739611) == 38347922) {
                    composerStartRestartGroup.startDefaults();
                    if ((i2 & 1) != 0) {
                        if (i17 != 0) {
                            companion = Modifier.INSTANCE;
                        } else {
                            companion = modifier;
                        }
                        if (i5 != 0) {
                            z2 = true;
                        }
                        if ((i3 & 16) != 0) {
                            closedFloatingPointRangeRangeTo = RangesKt.rangeTo(0.0f, 1.0f);
                            i4 &= -57345;
                        } else {
                            closedFloatingPointRangeRangeTo = closedFloatingPointRange2;
                        }
                        if (i7 != 0) {
                            i14 = 0;
                        } else {
                            i14 = i8;
                        }
                        if (i10 != 0) {
                            function2 = null;
                        } else {
                            function2 = function0;
                        }
                        if (i12 != 0) {
                            composerStartRestartGroup.startReplaceableGroup(-492369756);
                            ComposerKt.sourceInformation(composerStartRestartGroup, "C(remember):Composables.kt#9igjgp");
                            objRememberedValue = composerStartRestartGroup.rememberedValue();
                            if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                                objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                            }
                            composerStartRestartGroup.endReplaceableGroup();
                            mutableInteractionSource2 = (MutableInteractionSource) objRememberedValue;
                        } else {
                            mutableInteractionSource2 = mutableInteractionSource;
                        }
                        if ((i3 & 256) != 0) {
                            i15 = i4 & (-234881025);
                            sliderColorsM1150colorsq0g_0yA = SliderDefaults.INSTANCE.m1150colorsq0g_0yA(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 0, 6, 1023);
                        } else {
                            i15 = i4;
                            sliderColorsM1150colorsq0g_0yA = sliderColors;
                        }
                    } else {
                        if (i17 != 0) {
                            companion = Modifier.INSTANCE;
                        } else {
                            companion = modifier;
                        }
                        if (i5 != 0) {
                            z2 = true;
                        }
                        if ((i3 & 16) != 0) {
                            closedFloatingPointRangeRangeTo = RangesKt.rangeTo(0.0f, 1.0f);
                            i4 &= -57345;
                        } else {
                            closedFloatingPointRangeRangeTo = closedFloatingPointRange2;
                        }
                        if (i7 != 0) {
                            i14 = 0;
                        } else {
                            i14 = i8;
                        }
                        if (i10 != 0) {
                            function2 = null;
                        } else {
                            function2 = function0;
                        }
                        if (i12 != 0) {
                            composerStartRestartGroup.startReplaceableGroup(-492369756);
                            ComposerKt.sourceInformation(composerStartRestartGroup, "C(remember):Composables.kt#9igjgp");
                            objRememberedValue = composerStartRestartGroup.rememberedValue();
                            if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                                objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                            }
                            composerStartRestartGroup.endReplaceableGroup();
                            mutableInteractionSource2 = (MutableInteractionSource) objRememberedValue;
                        } else {
                            mutableInteractionSource2 = mutableInteractionSource;
                        }
                        if ((i3 & 256) != 0) {
                            i15 = i4 & (-234881025);
                            sliderColorsM1150colorsq0g_0yA = SliderDefaults.INSTANCE.m1150colorsq0g_0yA(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 0, 6, 1023);
                        } else {
                            i15 = i4;
                            sliderColorsM1150colorsq0g_0yA = sliderColors;
                        }
                    }
                    composerStartRestartGroup.endDefaults();
                    if (i14 < 0) {
                        throw new IllegalArgumentException("steps should be >= 0".toString());
                    }
                    State stateRememberUpdatedState110 = SnapshotStateKt.rememberUpdatedState(onValueChange, composerStartRestartGroup, (i15 >> 3) & 14);
                    Integer numValueOf110 = Integer.valueOf(i14);
                    composerStartRestartGroup.startReplaceableGroup(1157296644);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "C(remember)P(1):Composables.kt#9igjgp");
                    zChanged = composerStartRestartGroup.changed(numValueOf110);
                    objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                    if (!zChanged) {
                        objRememberedValue2 = stepsToTickFractions(i14);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                    } else {
                        objRememberedValue2 = stepsToTickFractions(i14);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                    }
                    composerStartRestartGroup.endReplaceableGroup();
                    List list110 = (List) objRememberedValue2;
                    Modifier modifierMinimumTouchTargetSize110 = TouchTargetKt.minimumTouchTargetSize(companion);
                    float f11110 = ThumbRadius;
                    float f11111 = 2;
                    BoxWithConstraintsKt.BoxWithConstraints(FocusableKt.focusable(sliderSemantics(SizeKt.m460requiredSizeInqDBjuR0$default(modifierMinimumTouchTargetSize110, Dp.m3843constructorimpl(f11110 * f11111), Dp.m3843constructorimpl(f11110 * f11111), 0.0f, 0.0f, 12, null), f, list110, z2, onValueChange, closedFloatingPointRangeRangeTo, i14), z2, mutableInteractionSource2), null, false, ComposableLambdaKt.composableLambda(composerStartRestartGroup, 2085116814, true, new C10663(closedFloatingPointRangeRangeTo, i15, f, mutableInteractionSource2, z2, list110, sliderColorsM1150colorsq0g_0yA, stateRememberUpdatedState110, function2)), composerStartRestartGroup, 3072, 6);
                    i16 = i14;
                    function3 = function2;
                    sliderColors2 = sliderColorsM1150colorsq0g_0yA;
                    z3 = z2;
                    mutableInteractionSource3 = mutableInteractionSource2;
                    modifier2 = companion;
                } else {
                    composerStartRestartGroup.startDefaults();
                    if ((i2 & 1) != 0) {
                        if (i17 != 0) {
                            companion = Modifier.INSTANCE;
                        } else {
                            companion = modifier;
                        }
                        if (i5 != 0) {
                            z2 = true;
                        }
                        if ((i3 & 16) != 0) {
                            closedFloatingPointRangeRangeTo = RangesKt.rangeTo(0.0f, 1.0f);
                            i4 &= -57345;
                        } else {
                            closedFloatingPointRangeRangeTo = closedFloatingPointRange2;
                        }
                        if (i7 != 0) {
                            i14 = 0;
                        } else {
                            i14 = i8;
                        }
                        if (i10 != 0) {
                            function2 = null;
                        } else {
                            function2 = function0;
                        }
                        if (i12 != 0) {
                            composerStartRestartGroup.startReplaceableGroup(-492369756);
                            ComposerKt.sourceInformation(composerStartRestartGroup, "C(remember):Composables.kt#9igjgp");
                            objRememberedValue = composerStartRestartGroup.rememberedValue();
                            if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                                objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                            }
                            composerStartRestartGroup.endReplaceableGroup();
                            mutableInteractionSource2 = (MutableInteractionSource) objRememberedValue;
                        } else {
                            mutableInteractionSource2 = mutableInteractionSource;
                        }
                        if ((i3 & 256) != 0) {
                            i15 = i4 & (-234881025);
                            sliderColorsM1150colorsq0g_0yA = SliderDefaults.INSTANCE.m1150colorsq0g_0yA(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 0, 6, 1023);
                        } else {
                            i15 = i4;
                            sliderColorsM1150colorsq0g_0yA = sliderColors;
                        }
                    } else {
                        if (i17 != 0) {
                            companion = Modifier.INSTANCE;
                        } else {
                            companion = modifier;
                        }
                        if (i5 != 0) {
                            z2 = true;
                        }
                        if ((i3 & 16) != 0) {
                            closedFloatingPointRangeRangeTo = RangesKt.rangeTo(0.0f, 1.0f);
                            i4 &= -57345;
                        } else {
                            closedFloatingPointRangeRangeTo = closedFloatingPointRange2;
                        }
                        if (i7 != 0) {
                            i14 = 0;
                        } else {
                            i14 = i8;
                        }
                        if (i10 != 0) {
                            function2 = null;
                        } else {
                            function2 = function0;
                        }
                        if (i12 != 0) {
                            composerStartRestartGroup.startReplaceableGroup(-492369756);
                            ComposerKt.sourceInformation(composerStartRestartGroup, "C(remember):Composables.kt#9igjgp");
                            objRememberedValue = composerStartRestartGroup.rememberedValue();
                            if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                                objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                            }
                            composerStartRestartGroup.endReplaceableGroup();
                            mutableInteractionSource2 = (MutableInteractionSource) objRememberedValue;
                        } else {
                            mutableInteractionSource2 = mutableInteractionSource;
                        }
                        if ((i3 & 256) != 0) {
                            i15 = i4 & (-234881025);
                            sliderColorsM1150colorsq0g_0yA = SliderDefaults.INSTANCE.m1150colorsq0g_0yA(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 0, 6, 1023);
                        } else {
                            i15 = i4;
                            sliderColorsM1150colorsq0g_0yA = sliderColors;
                        }
                    }
                    composerStartRestartGroup.endDefaults();
                    if (i14 < 0) {
                        throw new IllegalArgumentException("steps should be >= 0".toString());
                    }
                    State stateRememberUpdatedState111 = SnapshotStateKt.rememberUpdatedState(onValueChange, composerStartRestartGroup, (i15 >> 3) & 14);
                    Integer numValueOf111 = Integer.valueOf(i14);
                    composerStartRestartGroup.startReplaceableGroup(1157296644);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "C(remember)P(1):Composables.kt#9igjgp");
                    zChanged = composerStartRestartGroup.changed(numValueOf111);
                    objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                    if (!zChanged) {
                        objRememberedValue2 = stepsToTickFractions(i14);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                    } else {
                        objRememberedValue2 = stepsToTickFractions(i14);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                    }
                    composerStartRestartGroup.endReplaceableGroup();
                    List list111 = (List) objRememberedValue2;
                    Modifier modifierMinimumTouchTargetSize111 = TouchTargetKt.minimumTouchTargetSize(companion);
                    float f11112 = ThumbRadius;
                    float f11113 = 2;
                    BoxWithConstraintsKt.BoxWithConstraints(FocusableKt.focusable(sliderSemantics(SizeKt.m460requiredSizeInqDBjuR0$default(modifierMinimumTouchTargetSize111, Dp.m3843constructorimpl(f11112 * f11113), Dp.m3843constructorimpl(f11112 * f11113), 0.0f, 0.0f, 12, null), f, list111, z2, onValueChange, closedFloatingPointRangeRangeTo, i14), z2, mutableInteractionSource2), null, false, ComposableLambdaKt.composableLambda(composerStartRestartGroup, 2085116814, true, new C10663(closedFloatingPointRangeRangeTo, i15, f, mutableInteractionSource2, z2, list111, sliderColorsM1150colorsq0g_0yA, stateRememberUpdatedState111, function2)), composerStartRestartGroup, 3072, 6);
                    i16 = i14;
                    function3 = function2;
                    sliderColors2 = sliderColorsM1150colorsq0g_0yA;
                    z3 = z2;
                    mutableInteractionSource3 = mutableInteractionSource2;
                    modifier2 = companion;
                }
                scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup == null) {
                    return;
                }
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.SliderKt.Slider.4
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    /* JADX WARN: Multi-variable type inference failed */
                    {
                        super(2);
                    }

                    @Override // kotlin.jvm.functions.Function2
                    public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                        invoke(composer2, num.intValue());
                        return Unit.INSTANCE;
                    }

                    public final void invoke(Composer composer2, int i20) {
                        SliderKt.Slider(f, onValueChange, modifier2, z3, closedFloatingPointRangeRangeTo, i16, function3, mutableInteractionSource3, sliderColors2, composer2, i2 | 1, i3);
                    }
                });
            }
            i4 |= 1572864;
            function1 = function0;
            i12 = i3 & 128;
            if (i12 != 0) {
                i4 |= 12582912;
            } else if ((i2 & 29360128) == 0) {
                if (composerStartRestartGroup.changed(mutableInteractionSource)) {
                    i13 = 8388608;
                } else {
                    i13 = 4194304;
                }
                i4 |= i13;
            }
            if ((i2 & 234881024) != 0) {
                i4 |= ((i3 & 256) == 0 || !composerStartRestartGroup.changed(sliderColors)) ? 33554432 : 67108864;
            }
            if ((i4 & 191739611) == 38347922) {
                composerStartRestartGroup.startDefaults();
                if ((i2 & 1) != 0) {
                    if (i17 != 0) {
                        companion = Modifier.INSTANCE;
                    } else {
                        companion = modifier;
                    }
                    if (i5 != 0) {
                        z2 = true;
                    }
                    if ((i3 & 16) != 0) {
                        closedFloatingPointRangeRangeTo = RangesKt.rangeTo(0.0f, 1.0f);
                        i4 &= -57345;
                    } else {
                        closedFloatingPointRangeRangeTo = closedFloatingPointRange2;
                    }
                    if (i7 != 0) {
                        i14 = 0;
                    } else {
                        i14 = i8;
                    }
                    if (i10 != 0) {
                        function2 = null;
                    } else {
                        function2 = function0;
                    }
                    if (i12 != 0) {
                        composerStartRestartGroup.startReplaceableGroup(-492369756);
                        ComposerKt.sourceInformation(composerStartRestartGroup, "C(remember):Composables.kt#9igjgp");
                        objRememberedValue = composerStartRestartGroup.rememberedValue();
                        if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                            objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                        }
                        composerStartRestartGroup.endReplaceableGroup();
                        mutableInteractionSource2 = (MutableInteractionSource) objRememberedValue;
                    } else {
                        mutableInteractionSource2 = mutableInteractionSource;
                    }
                    if ((i3 & 256) != 0) {
                        i15 = i4 & (-234881025);
                        sliderColorsM1150colorsq0g_0yA = SliderDefaults.INSTANCE.m1150colorsq0g_0yA(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 0, 6, 1023);
                    } else {
                        i15 = i4;
                        sliderColorsM1150colorsq0g_0yA = sliderColors;
                    }
                } else {
                    if (i17 != 0) {
                        companion = Modifier.INSTANCE;
                    } else {
                        companion = modifier;
                    }
                    if (i5 != 0) {
                        z2 = true;
                    }
                    if ((i3 & 16) != 0) {
                        closedFloatingPointRangeRangeTo = RangesKt.rangeTo(0.0f, 1.0f);
                        i4 &= -57345;
                    } else {
                        closedFloatingPointRangeRangeTo = closedFloatingPointRange2;
                    }
                    if (i7 != 0) {
                        i14 = 0;
                    } else {
                        i14 = i8;
                    }
                    if (i10 != 0) {
                        function2 = null;
                    } else {
                        function2 = function0;
                    }
                    if (i12 != 0) {
                        composerStartRestartGroup.startReplaceableGroup(-492369756);
                        ComposerKt.sourceInformation(composerStartRestartGroup, "C(remember):Composables.kt#9igjgp");
                        objRememberedValue = composerStartRestartGroup.rememberedValue();
                        if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                            objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                        }
                        composerStartRestartGroup.endReplaceableGroup();
                        mutableInteractionSource2 = (MutableInteractionSource) objRememberedValue;
                    } else {
                        mutableInteractionSource2 = mutableInteractionSource;
                    }
                    if ((i3 & 256) != 0) {
                        i15 = i4 & (-234881025);
                        sliderColorsM1150colorsq0g_0yA = SliderDefaults.INSTANCE.m1150colorsq0g_0yA(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 0, 6, 1023);
                    } else {
                        i15 = i4;
                        sliderColorsM1150colorsq0g_0yA = sliderColors;
                    }
                }
                composerStartRestartGroup.endDefaults();
                if (i14 < 0) {
                    throw new IllegalArgumentException("steps should be >= 0".toString());
                }
                State stateRememberUpdatedState112 = SnapshotStateKt.rememberUpdatedState(onValueChange, composerStartRestartGroup, (i15 >> 3) & 14);
                Integer numValueOf112 = Integer.valueOf(i14);
                composerStartRestartGroup.startReplaceableGroup(1157296644);
                ComposerKt.sourceInformation(composerStartRestartGroup, "C(remember)P(1):Composables.kt#9igjgp");
                zChanged = composerStartRestartGroup.changed(numValueOf112);
                objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                if (!zChanged) {
                    objRememberedValue2 = stepsToTickFractions(i14);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                } else {
                    objRememberedValue2 = stepsToTickFractions(i14);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                }
                composerStartRestartGroup.endReplaceableGroup();
                List list112 = (List) objRememberedValue2;
                Modifier modifierMinimumTouchTargetSize112 = TouchTargetKt.minimumTouchTargetSize(companion);
                float f11114 = ThumbRadius;
                float f11115 = 2;
                BoxWithConstraintsKt.BoxWithConstraints(FocusableKt.focusable(sliderSemantics(SizeKt.m460requiredSizeInqDBjuR0$default(modifierMinimumTouchTargetSize112, Dp.m3843constructorimpl(f11114 * f11115), Dp.m3843constructorimpl(f11114 * f11115), 0.0f, 0.0f, 12, null), f, list112, z2, onValueChange, closedFloatingPointRangeRangeTo, i14), z2, mutableInteractionSource2), null, false, ComposableLambdaKt.composableLambda(composerStartRestartGroup, 2085116814, true, new C10663(closedFloatingPointRangeRangeTo, i15, f, mutableInteractionSource2, z2, list112, sliderColorsM1150colorsq0g_0yA, stateRememberUpdatedState112, function2)), composerStartRestartGroup, 3072, 6);
                i16 = i14;
                function3 = function2;
                sliderColors2 = sliderColorsM1150colorsq0g_0yA;
                z3 = z2;
                mutableInteractionSource3 = mutableInteractionSource2;
                modifier2 = companion;
            } else {
                composerStartRestartGroup.startDefaults();
                if ((i2 & 1) != 0) {
                    if (i17 != 0) {
                        companion = Modifier.INSTANCE;
                    } else {
                        companion = modifier;
                    }
                    if (i5 != 0) {
                        z2 = true;
                    }
                    if ((i3 & 16) != 0) {
                        closedFloatingPointRangeRangeTo = RangesKt.rangeTo(0.0f, 1.0f);
                        i4 &= -57345;
                    } else {
                        closedFloatingPointRangeRangeTo = closedFloatingPointRange2;
                    }
                    if (i7 != 0) {
                        i14 = 0;
                    } else {
                        i14 = i8;
                    }
                    if (i10 != 0) {
                        function2 = null;
                    } else {
                        function2 = function0;
                    }
                    if (i12 != 0) {
                        composerStartRestartGroup.startReplaceableGroup(-492369756);
                        ComposerKt.sourceInformation(composerStartRestartGroup, "C(remember):Composables.kt#9igjgp");
                        objRememberedValue = composerStartRestartGroup.rememberedValue();
                        if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                            objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                        }
                        composerStartRestartGroup.endReplaceableGroup();
                        mutableInteractionSource2 = (MutableInteractionSource) objRememberedValue;
                    } else {
                        mutableInteractionSource2 = mutableInteractionSource;
                    }
                    if ((i3 & 256) != 0) {
                        i15 = i4 & (-234881025);
                        sliderColorsM1150colorsq0g_0yA = SliderDefaults.INSTANCE.m1150colorsq0g_0yA(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 0, 6, 1023);
                    } else {
                        i15 = i4;
                        sliderColorsM1150colorsq0g_0yA = sliderColors;
                    }
                } else {
                    if (i17 != 0) {
                        companion = Modifier.INSTANCE;
                    } else {
                        companion = modifier;
                    }
                    if (i5 != 0) {
                        z2 = true;
                    }
                    if ((i3 & 16) != 0) {
                        closedFloatingPointRangeRangeTo = RangesKt.rangeTo(0.0f, 1.0f);
                        i4 &= -57345;
                    } else {
                        closedFloatingPointRangeRangeTo = closedFloatingPointRange2;
                    }
                    if (i7 != 0) {
                        i14 = 0;
                    } else {
                        i14 = i8;
                    }
                    if (i10 != 0) {
                        function2 = null;
                    } else {
                        function2 = function0;
                    }
                    if (i12 != 0) {
                        composerStartRestartGroup.startReplaceableGroup(-492369756);
                        ComposerKt.sourceInformation(composerStartRestartGroup, "C(remember):Composables.kt#9igjgp");
                        objRememberedValue = composerStartRestartGroup.rememberedValue();
                        if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                            objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                        }
                        composerStartRestartGroup.endReplaceableGroup();
                        mutableInteractionSource2 = (MutableInteractionSource) objRememberedValue;
                    } else {
                        mutableInteractionSource2 = mutableInteractionSource;
                    }
                    if ((i3 & 256) != 0) {
                        i15 = i4 & (-234881025);
                        sliderColorsM1150colorsq0g_0yA = SliderDefaults.INSTANCE.m1150colorsq0g_0yA(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 0, 6, 1023);
                    } else {
                        i15 = i4;
                        sliderColorsM1150colorsq0g_0yA = sliderColors;
                    }
                }
                composerStartRestartGroup.endDefaults();
                if (i14 < 0) {
                    throw new IllegalArgumentException("steps should be >= 0".toString());
                }
                State stateRememberUpdatedState113 = SnapshotStateKt.rememberUpdatedState(onValueChange, composerStartRestartGroup, (i15 >> 3) & 14);
                Integer numValueOf113 = Integer.valueOf(i14);
                composerStartRestartGroup.startReplaceableGroup(1157296644);
                ComposerKt.sourceInformation(composerStartRestartGroup, "C(remember)P(1):Composables.kt#9igjgp");
                zChanged = composerStartRestartGroup.changed(numValueOf113);
                objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                if (!zChanged) {
                    objRememberedValue2 = stepsToTickFractions(i14);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                } else {
                    objRememberedValue2 = stepsToTickFractions(i14);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                }
                composerStartRestartGroup.endReplaceableGroup();
                List list113 = (List) objRememberedValue2;
                Modifier modifierMinimumTouchTargetSize113 = TouchTargetKt.minimumTouchTargetSize(companion);
                float f11116 = ThumbRadius;
                float f11117 = 2;
                BoxWithConstraintsKt.BoxWithConstraints(FocusableKt.focusable(sliderSemantics(SizeKt.m460requiredSizeInqDBjuR0$default(modifierMinimumTouchTargetSize113, Dp.m3843constructorimpl(f11116 * f11117), Dp.m3843constructorimpl(f11116 * f11117), 0.0f, 0.0f, 12, null), f, list113, z2, onValueChange, closedFloatingPointRangeRangeTo, i14), z2, mutableInteractionSource2), null, false, ComposableLambdaKt.composableLambda(composerStartRestartGroup, 2085116814, true, new C10663(closedFloatingPointRangeRangeTo, i15, f, mutableInteractionSource2, z2, list113, sliderColorsM1150colorsq0g_0yA, stateRememberUpdatedState113, function2)), composerStartRestartGroup, 3072, 6);
                i16 = i14;
                function3 = function2;
                sliderColors2 = sliderColorsM1150colorsq0g_0yA;
                z3 = z2;
                mutableInteractionSource3 = mutableInteractionSource2;
                modifier2 = companion;
            }
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup == null) {
                return;
            }
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.SliderKt.Slider.4
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                    invoke(composer2, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(Composer composer2, int i20) {
                    SliderKt.Slider(f, onValueChange, modifier2, z3, closedFloatingPointRangeRangeTo, i16, function3, mutableInteractionSource3, sliderColors2, composer2, i2 | 1, i3);
                }
            });
        }
        i4 |= 3072;
        z2 = z;
        if ((57344 & i2) == 0) {
            if ((i3 & 16) == 0) {
                closedFloatingPointRange2 = closedFloatingPointRange;
                if (composerStartRestartGroup.changed(closedFloatingPointRange2)) {
                }
                i4 |= i18;
            } else {
                closedFloatingPointRange2 = closedFloatingPointRange;
            }
            i4 |= i18;
        } else {
            closedFloatingPointRange2 = closedFloatingPointRange;
        }
        i7 = i3 & 32;
        if (i7 != 0) {
            if ((458752 & i2) == 0) {
                i8 = i;
                if (composerStartRestartGroup.changed(i8)) {
                    i9 = 131072;
                } else {
                    i9 = 65536;
                }
                i4 |= i9;
            }
            i10 = i3 & 64;
            if (i10 != 0) {
                if ((3670016 & i2) == 0) {
                    function1 = function0;
                    if (composerStartRestartGroup.changed(function1)) {
                        i11 = 1048576;
                    } else {
                        i11 = 524288;
                    }
                    i4 |= i11;
                }
                i12 = i3 & 128;
                if (i12 != 0) {
                    i4 |= 12582912;
                } else if ((i2 & 29360128) == 0) {
                    if (composerStartRestartGroup.changed(mutableInteractionSource)) {
                        i13 = 8388608;
                    } else {
                        i13 = 4194304;
                    }
                    i4 |= i13;
                }
                if ((i2 & 234881024) != 0) {
                    i4 |= ((i3 & 256) == 0 || !composerStartRestartGroup.changed(sliderColors)) ? 33554432 : 67108864;
                }
                if ((i4 & 191739611) == 38347922) {
                    composerStartRestartGroup.startDefaults();
                    if ((i2 & 1) != 0) {
                        if (i17 != 0) {
                            companion = Modifier.INSTANCE;
                        } else {
                            companion = modifier;
                        }
                        if (i5 != 0) {
                            z2 = true;
                        }
                        if ((i3 & 16) != 0) {
                            closedFloatingPointRangeRangeTo = RangesKt.rangeTo(0.0f, 1.0f);
                            i4 &= -57345;
                        } else {
                            closedFloatingPointRangeRangeTo = closedFloatingPointRange2;
                        }
                        if (i7 != 0) {
                            i14 = 0;
                        } else {
                            i14 = i8;
                        }
                        if (i10 != 0) {
                            function2 = null;
                        } else {
                            function2 = function0;
                        }
                        if (i12 != 0) {
                            composerStartRestartGroup.startReplaceableGroup(-492369756);
                            ComposerKt.sourceInformation(composerStartRestartGroup, "C(remember):Composables.kt#9igjgp");
                            objRememberedValue = composerStartRestartGroup.rememberedValue();
                            if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                                objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                            }
                            composerStartRestartGroup.endReplaceableGroup();
                            mutableInteractionSource2 = (MutableInteractionSource) objRememberedValue;
                        } else {
                            mutableInteractionSource2 = mutableInteractionSource;
                        }
                        if ((i3 & 256) != 0) {
                            i15 = i4 & (-234881025);
                            sliderColorsM1150colorsq0g_0yA = SliderDefaults.INSTANCE.m1150colorsq0g_0yA(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 0, 6, 1023);
                        } else {
                            i15 = i4;
                            sliderColorsM1150colorsq0g_0yA = sliderColors;
                        }
                    } else {
                        if (i17 != 0) {
                            companion = Modifier.INSTANCE;
                        } else {
                            companion = modifier;
                        }
                        if (i5 != 0) {
                            z2 = true;
                        }
                        if ((i3 & 16) != 0) {
                            closedFloatingPointRangeRangeTo = RangesKt.rangeTo(0.0f, 1.0f);
                            i4 &= -57345;
                        } else {
                            closedFloatingPointRangeRangeTo = closedFloatingPointRange2;
                        }
                        if (i7 != 0) {
                            i14 = 0;
                        } else {
                            i14 = i8;
                        }
                        if (i10 != 0) {
                            function2 = null;
                        } else {
                            function2 = function0;
                        }
                        if (i12 != 0) {
                            composerStartRestartGroup.startReplaceableGroup(-492369756);
                            ComposerKt.sourceInformation(composerStartRestartGroup, "C(remember):Composables.kt#9igjgp");
                            objRememberedValue = composerStartRestartGroup.rememberedValue();
                            if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                                objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                            }
                            composerStartRestartGroup.endReplaceableGroup();
                            mutableInteractionSource2 = (MutableInteractionSource) objRememberedValue;
                        } else {
                            mutableInteractionSource2 = mutableInteractionSource;
                        }
                        if ((i3 & 256) != 0) {
                            i15 = i4 & (-234881025);
                            sliderColorsM1150colorsq0g_0yA = SliderDefaults.INSTANCE.m1150colorsq0g_0yA(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 0, 6, 1023);
                        } else {
                            i15 = i4;
                            sliderColorsM1150colorsq0g_0yA = sliderColors;
                        }
                    }
                    composerStartRestartGroup.endDefaults();
                    if (i14 < 0) {
                        throw new IllegalArgumentException("steps should be >= 0".toString());
                    }
                    State stateRememberUpdatedState114 = SnapshotStateKt.rememberUpdatedState(onValueChange, composerStartRestartGroup, (i15 >> 3) & 14);
                    Integer numValueOf114 = Integer.valueOf(i14);
                    composerStartRestartGroup.startReplaceableGroup(1157296644);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "C(remember)P(1):Composables.kt#9igjgp");
                    zChanged = composerStartRestartGroup.changed(numValueOf114);
                    objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                    if (!zChanged) {
                        objRememberedValue2 = stepsToTickFractions(i14);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                    } else {
                        objRememberedValue2 = stepsToTickFractions(i14);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                    }
                    composerStartRestartGroup.endReplaceableGroup();
                    List list114 = (List) objRememberedValue2;
                    Modifier modifierMinimumTouchTargetSize114 = TouchTargetKt.minimumTouchTargetSize(companion);
                    float f11118 = ThumbRadius;
                    float f11119 = 2;
                    BoxWithConstraintsKt.BoxWithConstraints(FocusableKt.focusable(sliderSemantics(SizeKt.m460requiredSizeInqDBjuR0$default(modifierMinimumTouchTargetSize114, Dp.m3843constructorimpl(f11118 * f11119), Dp.m3843constructorimpl(f11118 * f11119), 0.0f, 0.0f, 12, null), f, list114, z2, onValueChange, closedFloatingPointRangeRangeTo, i14), z2, mutableInteractionSource2), null, false, ComposableLambdaKt.composableLambda(composerStartRestartGroup, 2085116814, true, new C10663(closedFloatingPointRangeRangeTo, i15, f, mutableInteractionSource2, z2, list114, sliderColorsM1150colorsq0g_0yA, stateRememberUpdatedState114, function2)), composerStartRestartGroup, 3072, 6);
                    i16 = i14;
                    function3 = function2;
                    sliderColors2 = sliderColorsM1150colorsq0g_0yA;
                    z3 = z2;
                    mutableInteractionSource3 = mutableInteractionSource2;
                    modifier2 = companion;
                } else {
                    composerStartRestartGroup.startDefaults();
                    if ((i2 & 1) != 0) {
                        if (i17 != 0) {
                            companion = Modifier.INSTANCE;
                        } else {
                            companion = modifier;
                        }
                        if (i5 != 0) {
                            z2 = true;
                        }
                        if ((i3 & 16) != 0) {
                            closedFloatingPointRangeRangeTo = RangesKt.rangeTo(0.0f, 1.0f);
                            i4 &= -57345;
                        } else {
                            closedFloatingPointRangeRangeTo = closedFloatingPointRange2;
                        }
                        if (i7 != 0) {
                            i14 = 0;
                        } else {
                            i14 = i8;
                        }
                        if (i10 != 0) {
                            function2 = null;
                        } else {
                            function2 = function0;
                        }
                        if (i12 != 0) {
                            composerStartRestartGroup.startReplaceableGroup(-492369756);
                            ComposerKt.sourceInformation(composerStartRestartGroup, "C(remember):Composables.kt#9igjgp");
                            objRememberedValue = composerStartRestartGroup.rememberedValue();
                            if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                                objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                            }
                            composerStartRestartGroup.endReplaceableGroup();
                            mutableInteractionSource2 = (MutableInteractionSource) objRememberedValue;
                        } else {
                            mutableInteractionSource2 = mutableInteractionSource;
                        }
                        if ((i3 & 256) != 0) {
                            i15 = i4 & (-234881025);
                            sliderColorsM1150colorsq0g_0yA = SliderDefaults.INSTANCE.m1150colorsq0g_0yA(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 0, 6, 1023);
                        } else {
                            i15 = i4;
                            sliderColorsM1150colorsq0g_0yA = sliderColors;
                        }
                    } else {
                        if (i17 != 0) {
                            companion = Modifier.INSTANCE;
                        } else {
                            companion = modifier;
                        }
                        if (i5 != 0) {
                            z2 = true;
                        }
                        if ((i3 & 16) != 0) {
                            closedFloatingPointRangeRangeTo = RangesKt.rangeTo(0.0f, 1.0f);
                            i4 &= -57345;
                        } else {
                            closedFloatingPointRangeRangeTo = closedFloatingPointRange2;
                        }
                        if (i7 != 0) {
                            i14 = 0;
                        } else {
                            i14 = i8;
                        }
                        if (i10 != 0) {
                            function2 = null;
                        } else {
                            function2 = function0;
                        }
                        if (i12 != 0) {
                            composerStartRestartGroup.startReplaceableGroup(-492369756);
                            ComposerKt.sourceInformation(composerStartRestartGroup, "C(remember):Composables.kt#9igjgp");
                            objRememberedValue = composerStartRestartGroup.rememberedValue();
                            if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                                objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                            }
                            composerStartRestartGroup.endReplaceableGroup();
                            mutableInteractionSource2 = (MutableInteractionSource) objRememberedValue;
                        } else {
                            mutableInteractionSource2 = mutableInteractionSource;
                        }
                        if ((i3 & 256) != 0) {
                            i15 = i4 & (-234881025);
                            sliderColorsM1150colorsq0g_0yA = SliderDefaults.INSTANCE.m1150colorsq0g_0yA(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 0, 6, 1023);
                        } else {
                            i15 = i4;
                            sliderColorsM1150colorsq0g_0yA = sliderColors;
                        }
                    }
                    composerStartRestartGroup.endDefaults();
                    if (i14 < 0) {
                        throw new IllegalArgumentException("steps should be >= 0".toString());
                    }
                    State stateRememberUpdatedState115 = SnapshotStateKt.rememberUpdatedState(onValueChange, composerStartRestartGroup, (i15 >> 3) & 14);
                    Integer numValueOf115 = Integer.valueOf(i14);
                    composerStartRestartGroup.startReplaceableGroup(1157296644);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "C(remember)P(1):Composables.kt#9igjgp");
                    zChanged = composerStartRestartGroup.changed(numValueOf115);
                    objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                    if (!zChanged) {
                        objRememberedValue2 = stepsToTickFractions(i14);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                    } else {
                        objRememberedValue2 = stepsToTickFractions(i14);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                    }
                    composerStartRestartGroup.endReplaceableGroup();
                    List list115 = (List) objRememberedValue2;
                    Modifier modifierMinimumTouchTargetSize115 = TouchTargetKt.minimumTouchTargetSize(companion);
                    float f111110 = ThumbRadius;
                    float f111111 = 2;
                    BoxWithConstraintsKt.BoxWithConstraints(FocusableKt.focusable(sliderSemantics(SizeKt.m460requiredSizeInqDBjuR0$default(modifierMinimumTouchTargetSize115, Dp.m3843constructorimpl(f111110 * f111111), Dp.m3843constructorimpl(f111110 * f111111), 0.0f, 0.0f, 12, null), f, list115, z2, onValueChange, closedFloatingPointRangeRangeTo, i14), z2, mutableInteractionSource2), null, false, ComposableLambdaKt.composableLambda(composerStartRestartGroup, 2085116814, true, new C10663(closedFloatingPointRangeRangeTo, i15, f, mutableInteractionSource2, z2, list115, sliderColorsM1150colorsq0g_0yA, stateRememberUpdatedState115, function2)), composerStartRestartGroup, 3072, 6);
                    i16 = i14;
                    function3 = function2;
                    sliderColors2 = sliderColorsM1150colorsq0g_0yA;
                    z3 = z2;
                    mutableInteractionSource3 = mutableInteractionSource2;
                    modifier2 = companion;
                }
                scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup == null) {
                    return;
                }
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.SliderKt.Slider.4
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    /* JADX WARN: Multi-variable type inference failed */
                    {
                        super(2);
                    }

                    @Override // kotlin.jvm.functions.Function2
                    public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                        invoke(composer2, num.intValue());
                        return Unit.INSTANCE;
                    }

                    public final void invoke(Composer composer2, int i20) {
                        SliderKt.Slider(f, onValueChange, modifier2, z3, closedFloatingPointRangeRangeTo, i16, function3, mutableInteractionSource3, sliderColors2, composer2, i2 | 1, i3);
                    }
                });
            }
            i4 |= 1572864;
            function1 = function0;
            i12 = i3 & 128;
            if (i12 != 0) {
                i4 |= 12582912;
            } else if ((i2 & 29360128) == 0) {
                if (composerStartRestartGroup.changed(mutableInteractionSource)) {
                    i13 = 8388608;
                } else {
                    i13 = 4194304;
                }
                i4 |= i13;
            }
            if ((i2 & 234881024) != 0) {
                i4 |= ((i3 & 256) == 0 || !composerStartRestartGroup.changed(sliderColors)) ? 33554432 : 67108864;
            }
            if ((i4 & 191739611) == 38347922) {
                composerStartRestartGroup.startDefaults();
                if ((i2 & 1) != 0) {
                    if (i17 != 0) {
                        companion = Modifier.INSTANCE;
                    } else {
                        companion = modifier;
                    }
                    if (i5 != 0) {
                        z2 = true;
                    }
                    if ((i3 & 16) != 0) {
                        closedFloatingPointRangeRangeTo = RangesKt.rangeTo(0.0f, 1.0f);
                        i4 &= -57345;
                    } else {
                        closedFloatingPointRangeRangeTo = closedFloatingPointRange2;
                    }
                    if (i7 != 0) {
                        i14 = 0;
                    } else {
                        i14 = i8;
                    }
                    if (i10 != 0) {
                        function2 = null;
                    } else {
                        function2 = function0;
                    }
                    if (i12 != 0) {
                        composerStartRestartGroup.startReplaceableGroup(-492369756);
                        ComposerKt.sourceInformation(composerStartRestartGroup, "C(remember):Composables.kt#9igjgp");
                        objRememberedValue = composerStartRestartGroup.rememberedValue();
                        if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                            objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                        }
                        composerStartRestartGroup.endReplaceableGroup();
                        mutableInteractionSource2 = (MutableInteractionSource) objRememberedValue;
                    } else {
                        mutableInteractionSource2 = mutableInteractionSource;
                    }
                    if ((i3 & 256) != 0) {
                        i15 = i4 & (-234881025);
                        sliderColorsM1150colorsq0g_0yA = SliderDefaults.INSTANCE.m1150colorsq0g_0yA(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 0, 6, 1023);
                    } else {
                        i15 = i4;
                        sliderColorsM1150colorsq0g_0yA = sliderColors;
                    }
                } else {
                    if (i17 != 0) {
                        companion = Modifier.INSTANCE;
                    } else {
                        companion = modifier;
                    }
                    if (i5 != 0) {
                        z2 = true;
                    }
                    if ((i3 & 16) != 0) {
                        closedFloatingPointRangeRangeTo = RangesKt.rangeTo(0.0f, 1.0f);
                        i4 &= -57345;
                    } else {
                        closedFloatingPointRangeRangeTo = closedFloatingPointRange2;
                    }
                    if (i7 != 0) {
                        i14 = 0;
                    } else {
                        i14 = i8;
                    }
                    if (i10 != 0) {
                        function2 = null;
                    } else {
                        function2 = function0;
                    }
                    if (i12 != 0) {
                        composerStartRestartGroup.startReplaceableGroup(-492369756);
                        ComposerKt.sourceInformation(composerStartRestartGroup, "C(remember):Composables.kt#9igjgp");
                        objRememberedValue = composerStartRestartGroup.rememberedValue();
                        if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                            objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                        }
                        composerStartRestartGroup.endReplaceableGroup();
                        mutableInteractionSource2 = (MutableInteractionSource) objRememberedValue;
                    } else {
                        mutableInteractionSource2 = mutableInteractionSource;
                    }
                    if ((i3 & 256) != 0) {
                        i15 = i4 & (-234881025);
                        sliderColorsM1150colorsq0g_0yA = SliderDefaults.INSTANCE.m1150colorsq0g_0yA(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 0, 6, 1023);
                    } else {
                        i15 = i4;
                        sliderColorsM1150colorsq0g_0yA = sliderColors;
                    }
                }
                composerStartRestartGroup.endDefaults();
                if (i14 < 0) {
                    throw new IllegalArgumentException("steps should be >= 0".toString());
                }
                State stateRememberUpdatedState116 = SnapshotStateKt.rememberUpdatedState(onValueChange, composerStartRestartGroup, (i15 >> 3) & 14);
                Integer numValueOf116 = Integer.valueOf(i14);
                composerStartRestartGroup.startReplaceableGroup(1157296644);
                ComposerKt.sourceInformation(composerStartRestartGroup, "C(remember)P(1):Composables.kt#9igjgp");
                zChanged = composerStartRestartGroup.changed(numValueOf116);
                objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                if (!zChanged) {
                    objRememberedValue2 = stepsToTickFractions(i14);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                } else {
                    objRememberedValue2 = stepsToTickFractions(i14);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                }
                composerStartRestartGroup.endReplaceableGroup();
                List list116 = (List) objRememberedValue2;
                Modifier modifierMinimumTouchTargetSize116 = TouchTargetKt.minimumTouchTargetSize(companion);
                float f111112 = ThumbRadius;
                float f111113 = 2;
                BoxWithConstraintsKt.BoxWithConstraints(FocusableKt.focusable(sliderSemantics(SizeKt.m460requiredSizeInqDBjuR0$default(modifierMinimumTouchTargetSize116, Dp.m3843constructorimpl(f111112 * f111113), Dp.m3843constructorimpl(f111112 * f111113), 0.0f, 0.0f, 12, null), f, list116, z2, onValueChange, closedFloatingPointRangeRangeTo, i14), z2, mutableInteractionSource2), null, false, ComposableLambdaKt.composableLambda(composerStartRestartGroup, 2085116814, true, new C10663(closedFloatingPointRangeRangeTo, i15, f, mutableInteractionSource2, z2, list116, sliderColorsM1150colorsq0g_0yA, stateRememberUpdatedState116, function2)), composerStartRestartGroup, 3072, 6);
                i16 = i14;
                function3 = function2;
                sliderColors2 = sliderColorsM1150colorsq0g_0yA;
                z3 = z2;
                mutableInteractionSource3 = mutableInteractionSource2;
                modifier2 = companion;
            } else {
                composerStartRestartGroup.startDefaults();
                if ((i2 & 1) != 0) {
                    if (i17 != 0) {
                        companion = Modifier.INSTANCE;
                    } else {
                        companion = modifier;
                    }
                    if (i5 != 0) {
                        z2 = true;
                    }
                    if ((i3 & 16) != 0) {
                        closedFloatingPointRangeRangeTo = RangesKt.rangeTo(0.0f, 1.0f);
                        i4 &= -57345;
                    } else {
                        closedFloatingPointRangeRangeTo = closedFloatingPointRange2;
                    }
                    if (i7 != 0) {
                        i14 = 0;
                    } else {
                        i14 = i8;
                    }
                    if (i10 != 0) {
                        function2 = null;
                    } else {
                        function2 = function0;
                    }
                    if (i12 != 0) {
                        composerStartRestartGroup.startReplaceableGroup(-492369756);
                        ComposerKt.sourceInformation(composerStartRestartGroup, "C(remember):Composables.kt#9igjgp");
                        objRememberedValue = composerStartRestartGroup.rememberedValue();
                        if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                            objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                        }
                        composerStartRestartGroup.endReplaceableGroup();
                        mutableInteractionSource2 = (MutableInteractionSource) objRememberedValue;
                    } else {
                        mutableInteractionSource2 = mutableInteractionSource;
                    }
                    if ((i3 & 256) != 0) {
                        i15 = i4 & (-234881025);
                        sliderColorsM1150colorsq0g_0yA = SliderDefaults.INSTANCE.m1150colorsq0g_0yA(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 0, 6, 1023);
                    } else {
                        i15 = i4;
                        sliderColorsM1150colorsq0g_0yA = sliderColors;
                    }
                } else {
                    if (i17 != 0) {
                        companion = Modifier.INSTANCE;
                    } else {
                        companion = modifier;
                    }
                    if (i5 != 0) {
                        z2 = true;
                    }
                    if ((i3 & 16) != 0) {
                        closedFloatingPointRangeRangeTo = RangesKt.rangeTo(0.0f, 1.0f);
                        i4 &= -57345;
                    } else {
                        closedFloatingPointRangeRangeTo = closedFloatingPointRange2;
                    }
                    if (i7 != 0) {
                        i14 = 0;
                    } else {
                        i14 = i8;
                    }
                    if (i10 != 0) {
                        function2 = null;
                    } else {
                        function2 = function0;
                    }
                    if (i12 != 0) {
                        composerStartRestartGroup.startReplaceableGroup(-492369756);
                        ComposerKt.sourceInformation(composerStartRestartGroup, "C(remember):Composables.kt#9igjgp");
                        objRememberedValue = composerStartRestartGroup.rememberedValue();
                        if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                            objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                        }
                        composerStartRestartGroup.endReplaceableGroup();
                        mutableInteractionSource2 = (MutableInteractionSource) objRememberedValue;
                    } else {
                        mutableInteractionSource2 = mutableInteractionSource;
                    }
                    if ((i3 & 256) != 0) {
                        i15 = i4 & (-234881025);
                        sliderColorsM1150colorsq0g_0yA = SliderDefaults.INSTANCE.m1150colorsq0g_0yA(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 0, 6, 1023);
                    } else {
                        i15 = i4;
                        sliderColorsM1150colorsq0g_0yA = sliderColors;
                    }
                }
                composerStartRestartGroup.endDefaults();
                if (i14 < 0) {
                    throw new IllegalArgumentException("steps should be >= 0".toString());
                }
                State stateRememberUpdatedState117 = SnapshotStateKt.rememberUpdatedState(onValueChange, composerStartRestartGroup, (i15 >> 3) & 14);
                Integer numValueOf117 = Integer.valueOf(i14);
                composerStartRestartGroup.startReplaceableGroup(1157296644);
                ComposerKt.sourceInformation(composerStartRestartGroup, "C(remember)P(1):Composables.kt#9igjgp");
                zChanged = composerStartRestartGroup.changed(numValueOf117);
                objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                if (!zChanged) {
                    objRememberedValue2 = stepsToTickFractions(i14);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                } else {
                    objRememberedValue2 = stepsToTickFractions(i14);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                }
                composerStartRestartGroup.endReplaceableGroup();
                List list117 = (List) objRememberedValue2;
                Modifier modifierMinimumTouchTargetSize117 = TouchTargetKt.minimumTouchTargetSize(companion);
                float f111114 = ThumbRadius;
                float f111115 = 2;
                BoxWithConstraintsKt.BoxWithConstraints(FocusableKt.focusable(sliderSemantics(SizeKt.m460requiredSizeInqDBjuR0$default(modifierMinimumTouchTargetSize117, Dp.m3843constructorimpl(f111114 * f111115), Dp.m3843constructorimpl(f111114 * f111115), 0.0f, 0.0f, 12, null), f, list117, z2, onValueChange, closedFloatingPointRangeRangeTo, i14), z2, mutableInteractionSource2), null, false, ComposableLambdaKt.composableLambda(composerStartRestartGroup, 2085116814, true, new C10663(closedFloatingPointRangeRangeTo, i15, f, mutableInteractionSource2, z2, list117, sliderColorsM1150colorsq0g_0yA, stateRememberUpdatedState117, function2)), composerStartRestartGroup, 3072, 6);
                i16 = i14;
                function3 = function2;
                sliderColors2 = sliderColorsM1150colorsq0g_0yA;
                z3 = z2;
                mutableInteractionSource3 = mutableInteractionSource2;
                modifier2 = companion;
            }
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup == null) {
                return;
            }
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.SliderKt.Slider.4
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                    invoke(composer2, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(Composer composer2, int i20) {
                    SliderKt.Slider(f, onValueChange, modifier2, z3, closedFloatingPointRangeRangeTo, i16, function3, mutableInteractionSource3, sliderColors2, composer2, i2 | 1, i3);
                }
            });
        }
        i4 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
        i8 = i;
        i10 = i3 & 64;
        if (i10 != 0) {
            if ((3670016 & i2) == 0) {
                function1 = function0;
                if (composerStartRestartGroup.changed(function1)) {
                    i11 = 1048576;
                } else {
                    i11 = 524288;
                }
                i4 |= i11;
            }
            i12 = i3 & 128;
            if (i12 != 0) {
                i4 |= 12582912;
            } else if ((i2 & 29360128) == 0) {
                if (composerStartRestartGroup.changed(mutableInteractionSource)) {
                    i13 = 8388608;
                } else {
                    i13 = 4194304;
                }
                i4 |= i13;
            }
            if ((i2 & 234881024) != 0) {
                i4 |= ((i3 & 256) == 0 || !composerStartRestartGroup.changed(sliderColors)) ? 33554432 : 67108864;
            }
            if ((i4 & 191739611) == 38347922) {
                composerStartRestartGroup.startDefaults();
                if ((i2 & 1) != 0) {
                    if (i17 != 0) {
                        companion = Modifier.INSTANCE;
                    } else {
                        companion = modifier;
                    }
                    if (i5 != 0) {
                        z2 = true;
                    }
                    if ((i3 & 16) != 0) {
                        closedFloatingPointRangeRangeTo = RangesKt.rangeTo(0.0f, 1.0f);
                        i4 &= -57345;
                    } else {
                        closedFloatingPointRangeRangeTo = closedFloatingPointRange2;
                    }
                    if (i7 != 0) {
                        i14 = 0;
                    } else {
                        i14 = i8;
                    }
                    if (i10 != 0) {
                        function2 = null;
                    } else {
                        function2 = function0;
                    }
                    if (i12 != 0) {
                        composerStartRestartGroup.startReplaceableGroup(-492369756);
                        ComposerKt.sourceInformation(composerStartRestartGroup, "C(remember):Composables.kt#9igjgp");
                        objRememberedValue = composerStartRestartGroup.rememberedValue();
                        if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                            objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                        }
                        composerStartRestartGroup.endReplaceableGroup();
                        mutableInteractionSource2 = (MutableInteractionSource) objRememberedValue;
                    } else {
                        mutableInteractionSource2 = mutableInteractionSource;
                    }
                    if ((i3 & 256) != 0) {
                        i15 = i4 & (-234881025);
                        sliderColorsM1150colorsq0g_0yA = SliderDefaults.INSTANCE.m1150colorsq0g_0yA(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 0, 6, 1023);
                    } else {
                        i15 = i4;
                        sliderColorsM1150colorsq0g_0yA = sliderColors;
                    }
                } else {
                    if (i17 != 0) {
                        companion = Modifier.INSTANCE;
                    } else {
                        companion = modifier;
                    }
                    if (i5 != 0) {
                        z2 = true;
                    }
                    if ((i3 & 16) != 0) {
                        closedFloatingPointRangeRangeTo = RangesKt.rangeTo(0.0f, 1.0f);
                        i4 &= -57345;
                    } else {
                        closedFloatingPointRangeRangeTo = closedFloatingPointRange2;
                    }
                    if (i7 != 0) {
                        i14 = 0;
                    } else {
                        i14 = i8;
                    }
                    if (i10 != 0) {
                        function2 = null;
                    } else {
                        function2 = function0;
                    }
                    if (i12 != 0) {
                        composerStartRestartGroup.startReplaceableGroup(-492369756);
                        ComposerKt.sourceInformation(composerStartRestartGroup, "C(remember):Composables.kt#9igjgp");
                        objRememberedValue = composerStartRestartGroup.rememberedValue();
                        if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                            objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                        }
                        composerStartRestartGroup.endReplaceableGroup();
                        mutableInteractionSource2 = (MutableInteractionSource) objRememberedValue;
                    } else {
                        mutableInteractionSource2 = mutableInteractionSource;
                    }
                    if ((i3 & 256) != 0) {
                        i15 = i4 & (-234881025);
                        sliderColorsM1150colorsq0g_0yA = SliderDefaults.INSTANCE.m1150colorsq0g_0yA(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 0, 6, 1023);
                    } else {
                        i15 = i4;
                        sliderColorsM1150colorsq0g_0yA = sliderColors;
                    }
                }
                composerStartRestartGroup.endDefaults();
                if (i14 < 0) {
                    throw new IllegalArgumentException("steps should be >= 0".toString());
                }
                State stateRememberUpdatedState118 = SnapshotStateKt.rememberUpdatedState(onValueChange, composerStartRestartGroup, (i15 >> 3) & 14);
                Integer numValueOf118 = Integer.valueOf(i14);
                composerStartRestartGroup.startReplaceableGroup(1157296644);
                ComposerKt.sourceInformation(composerStartRestartGroup, "C(remember)P(1):Composables.kt#9igjgp");
                zChanged = composerStartRestartGroup.changed(numValueOf118);
                objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                if (!zChanged) {
                    objRememberedValue2 = stepsToTickFractions(i14);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                } else {
                    objRememberedValue2 = stepsToTickFractions(i14);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                }
                composerStartRestartGroup.endReplaceableGroup();
                List list118 = (List) objRememberedValue2;
                Modifier modifierMinimumTouchTargetSize118 = TouchTargetKt.minimumTouchTargetSize(companion);
                float f111116 = ThumbRadius;
                float f111117 = 2;
                BoxWithConstraintsKt.BoxWithConstraints(FocusableKt.focusable(sliderSemantics(SizeKt.m460requiredSizeInqDBjuR0$default(modifierMinimumTouchTargetSize118, Dp.m3843constructorimpl(f111116 * f111117), Dp.m3843constructorimpl(f111116 * f111117), 0.0f, 0.0f, 12, null), f, list118, z2, onValueChange, closedFloatingPointRangeRangeTo, i14), z2, mutableInteractionSource2), null, false, ComposableLambdaKt.composableLambda(composerStartRestartGroup, 2085116814, true, new C10663(closedFloatingPointRangeRangeTo, i15, f, mutableInteractionSource2, z2, list118, sliderColorsM1150colorsq0g_0yA, stateRememberUpdatedState118, function2)), composerStartRestartGroup, 3072, 6);
                i16 = i14;
                function3 = function2;
                sliderColors2 = sliderColorsM1150colorsq0g_0yA;
                z3 = z2;
                mutableInteractionSource3 = mutableInteractionSource2;
                modifier2 = companion;
            } else {
                composerStartRestartGroup.startDefaults();
                if ((i2 & 1) != 0) {
                    if (i17 != 0) {
                        companion = Modifier.INSTANCE;
                    } else {
                        companion = modifier;
                    }
                    if (i5 != 0) {
                        z2 = true;
                    }
                    if ((i3 & 16) != 0) {
                        closedFloatingPointRangeRangeTo = RangesKt.rangeTo(0.0f, 1.0f);
                        i4 &= -57345;
                    } else {
                        closedFloatingPointRangeRangeTo = closedFloatingPointRange2;
                    }
                    if (i7 != 0) {
                        i14 = 0;
                    } else {
                        i14 = i8;
                    }
                    if (i10 != 0) {
                        function2 = null;
                    } else {
                        function2 = function0;
                    }
                    if (i12 != 0) {
                        composerStartRestartGroup.startReplaceableGroup(-492369756);
                        ComposerKt.sourceInformation(composerStartRestartGroup, "C(remember):Composables.kt#9igjgp");
                        objRememberedValue = composerStartRestartGroup.rememberedValue();
                        if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                            objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                        }
                        composerStartRestartGroup.endReplaceableGroup();
                        mutableInteractionSource2 = (MutableInteractionSource) objRememberedValue;
                    } else {
                        mutableInteractionSource2 = mutableInteractionSource;
                    }
                    if ((i3 & 256) != 0) {
                        i15 = i4 & (-234881025);
                        sliderColorsM1150colorsq0g_0yA = SliderDefaults.INSTANCE.m1150colorsq0g_0yA(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 0, 6, 1023);
                    } else {
                        i15 = i4;
                        sliderColorsM1150colorsq0g_0yA = sliderColors;
                    }
                } else {
                    if (i17 != 0) {
                        companion = Modifier.INSTANCE;
                    } else {
                        companion = modifier;
                    }
                    if (i5 != 0) {
                        z2 = true;
                    }
                    if ((i3 & 16) != 0) {
                        closedFloatingPointRangeRangeTo = RangesKt.rangeTo(0.0f, 1.0f);
                        i4 &= -57345;
                    } else {
                        closedFloatingPointRangeRangeTo = closedFloatingPointRange2;
                    }
                    if (i7 != 0) {
                        i14 = 0;
                    } else {
                        i14 = i8;
                    }
                    if (i10 != 0) {
                        function2 = null;
                    } else {
                        function2 = function0;
                    }
                    if (i12 != 0) {
                        composerStartRestartGroup.startReplaceableGroup(-492369756);
                        ComposerKt.sourceInformation(composerStartRestartGroup, "C(remember):Composables.kt#9igjgp");
                        objRememberedValue = composerStartRestartGroup.rememberedValue();
                        if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                            objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                        }
                        composerStartRestartGroup.endReplaceableGroup();
                        mutableInteractionSource2 = (MutableInteractionSource) objRememberedValue;
                    } else {
                        mutableInteractionSource2 = mutableInteractionSource;
                    }
                    if ((i3 & 256) != 0) {
                        i15 = i4 & (-234881025);
                        sliderColorsM1150colorsq0g_0yA = SliderDefaults.INSTANCE.m1150colorsq0g_0yA(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 0, 6, 1023);
                    } else {
                        i15 = i4;
                        sliderColorsM1150colorsq0g_0yA = sliderColors;
                    }
                }
                composerStartRestartGroup.endDefaults();
                if (i14 < 0) {
                    throw new IllegalArgumentException("steps should be >= 0".toString());
                }
                State stateRememberUpdatedState119 = SnapshotStateKt.rememberUpdatedState(onValueChange, composerStartRestartGroup, (i15 >> 3) & 14);
                Integer numValueOf119 = Integer.valueOf(i14);
                composerStartRestartGroup.startReplaceableGroup(1157296644);
                ComposerKt.sourceInformation(composerStartRestartGroup, "C(remember)P(1):Composables.kt#9igjgp");
                zChanged = composerStartRestartGroup.changed(numValueOf119);
                objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                if (!zChanged) {
                    objRememberedValue2 = stepsToTickFractions(i14);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                } else {
                    objRememberedValue2 = stepsToTickFractions(i14);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                }
                composerStartRestartGroup.endReplaceableGroup();
                List list119 = (List) objRememberedValue2;
                Modifier modifierMinimumTouchTargetSize119 = TouchTargetKt.minimumTouchTargetSize(companion);
                float f111118 = ThumbRadius;
                float f111119 = 2;
                BoxWithConstraintsKt.BoxWithConstraints(FocusableKt.focusable(sliderSemantics(SizeKt.m460requiredSizeInqDBjuR0$default(modifierMinimumTouchTargetSize119, Dp.m3843constructorimpl(f111118 * f111119), Dp.m3843constructorimpl(f111118 * f111119), 0.0f, 0.0f, 12, null), f, list119, z2, onValueChange, closedFloatingPointRangeRangeTo, i14), z2, mutableInteractionSource2), null, false, ComposableLambdaKt.composableLambda(composerStartRestartGroup, 2085116814, true, new C10663(closedFloatingPointRangeRangeTo, i15, f, mutableInteractionSource2, z2, list119, sliderColorsM1150colorsq0g_0yA, stateRememberUpdatedState119, function2)), composerStartRestartGroup, 3072, 6);
                i16 = i14;
                function3 = function2;
                sliderColors2 = sliderColorsM1150colorsq0g_0yA;
                z3 = z2;
                mutableInteractionSource3 = mutableInteractionSource2;
                modifier2 = companion;
            }
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup == null) {
                return;
            }
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.SliderKt.Slider.4
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                    invoke(composer2, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(Composer composer2, int i20) {
                    SliderKt.Slider(f, onValueChange, modifier2, z3, closedFloatingPointRangeRangeTo, i16, function3, mutableInteractionSource3, sliderColors2, composer2, i2 | 1, i3);
                }
            });
        }
        i4 |= 1572864;
        function1 = function0;
        i12 = i3 & 128;
        if (i12 != 0) {
            i4 |= 12582912;
        } else if ((i2 & 29360128) == 0) {
            if (composerStartRestartGroup.changed(mutableInteractionSource)) {
                i13 = 8388608;
            } else {
                i13 = 4194304;
            }
            i4 |= i13;
        }
        if ((i2 & 234881024) != 0) {
            i4 |= ((i3 & 256) == 0 || !composerStartRestartGroup.changed(sliderColors)) ? 33554432 : 67108864;
        }
        if ((i4 & 191739611) == 38347922) {
            composerStartRestartGroup.startDefaults();
            if ((i2 & 1) != 0) {
                if (i17 != 0) {
                    companion = Modifier.INSTANCE;
                } else {
                    companion = modifier;
                }
                if (i5 != 0) {
                    z2 = true;
                }
                if ((i3 & 16) != 0) {
                    closedFloatingPointRangeRangeTo = RangesKt.rangeTo(0.0f, 1.0f);
                    i4 &= -57345;
                } else {
                    closedFloatingPointRangeRangeTo = closedFloatingPointRange2;
                }
                if (i7 != 0) {
                    i14 = 0;
                } else {
                    i14 = i8;
                }
                if (i10 != 0) {
                    function2 = null;
                } else {
                    function2 = function0;
                }
                if (i12 != 0) {
                    composerStartRestartGroup.startReplaceableGroup(-492369756);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "C(remember):Composables.kt#9igjgp");
                    objRememberedValue = composerStartRestartGroup.rememberedValue();
                    if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                        objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                    }
                    composerStartRestartGroup.endReplaceableGroup();
                    mutableInteractionSource2 = (MutableInteractionSource) objRememberedValue;
                } else {
                    mutableInteractionSource2 = mutableInteractionSource;
                }
                if ((i3 & 256) != 0) {
                    i15 = i4 & (-234881025);
                    sliderColorsM1150colorsq0g_0yA = SliderDefaults.INSTANCE.m1150colorsq0g_0yA(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 0, 6, 1023);
                } else {
                    i15 = i4;
                    sliderColorsM1150colorsq0g_0yA = sliderColors;
                }
            } else {
                if (i17 != 0) {
                    companion = Modifier.INSTANCE;
                } else {
                    companion = modifier;
                }
                if (i5 != 0) {
                    z2 = true;
                }
                if ((i3 & 16) != 0) {
                    closedFloatingPointRangeRangeTo = RangesKt.rangeTo(0.0f, 1.0f);
                    i4 &= -57345;
                } else {
                    closedFloatingPointRangeRangeTo = closedFloatingPointRange2;
                }
                if (i7 != 0) {
                    i14 = 0;
                } else {
                    i14 = i8;
                }
                if (i10 != 0) {
                    function2 = null;
                } else {
                    function2 = function0;
                }
                if (i12 != 0) {
                    composerStartRestartGroup.startReplaceableGroup(-492369756);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "C(remember):Composables.kt#9igjgp");
                    objRememberedValue = composerStartRestartGroup.rememberedValue();
                    if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                        objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                    }
                    composerStartRestartGroup.endReplaceableGroup();
                    mutableInteractionSource2 = (MutableInteractionSource) objRememberedValue;
                } else {
                    mutableInteractionSource2 = mutableInteractionSource;
                }
                if ((i3 & 256) != 0) {
                    i15 = i4 & (-234881025);
                    sliderColorsM1150colorsq0g_0yA = SliderDefaults.INSTANCE.m1150colorsq0g_0yA(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 0, 6, 1023);
                } else {
                    i15 = i4;
                    sliderColorsM1150colorsq0g_0yA = sliderColors;
                }
            }
            composerStartRestartGroup.endDefaults();
            if (i14 < 0) {
                throw new IllegalArgumentException("steps should be >= 0".toString());
            }
            State stateRememberUpdatedState1110 = SnapshotStateKt.rememberUpdatedState(onValueChange, composerStartRestartGroup, (i15 >> 3) & 14);
            Integer numValueOf1110 = Integer.valueOf(i14);
            composerStartRestartGroup.startReplaceableGroup(1157296644);
            ComposerKt.sourceInformation(composerStartRestartGroup, "C(remember)P(1):Composables.kt#9igjgp");
            zChanged = composerStartRestartGroup.changed(numValueOf1110);
            objRememberedValue2 = composerStartRestartGroup.rememberedValue();
            if (!zChanged) {
                objRememberedValue2 = stepsToTickFractions(i14);
                composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
            } else {
                objRememberedValue2 = stepsToTickFractions(i14);
                composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
            }
            composerStartRestartGroup.endReplaceableGroup();
            List list1110 = (List) objRememberedValue2;
            Modifier modifierMinimumTouchTargetSize1110 = TouchTargetKt.minimumTouchTargetSize(companion);
            float f1111110 = ThumbRadius;
            float f1111111 = 2;
            BoxWithConstraintsKt.BoxWithConstraints(FocusableKt.focusable(sliderSemantics(SizeKt.m460requiredSizeInqDBjuR0$default(modifierMinimumTouchTargetSize1110, Dp.m3843constructorimpl(f1111110 * f1111111), Dp.m3843constructorimpl(f1111110 * f1111111), 0.0f, 0.0f, 12, null), f, list1110, z2, onValueChange, closedFloatingPointRangeRangeTo, i14), z2, mutableInteractionSource2), null, false, ComposableLambdaKt.composableLambda(composerStartRestartGroup, 2085116814, true, new C10663(closedFloatingPointRangeRangeTo, i15, f, mutableInteractionSource2, z2, list1110, sliderColorsM1150colorsq0g_0yA, stateRememberUpdatedState1110, function2)), composerStartRestartGroup, 3072, 6);
            i16 = i14;
            function3 = function2;
            sliderColors2 = sliderColorsM1150colorsq0g_0yA;
            z3 = z2;
            mutableInteractionSource3 = mutableInteractionSource2;
            modifier2 = companion;
        } else {
            composerStartRestartGroup.startDefaults();
            if ((i2 & 1) != 0) {
                if (i17 != 0) {
                    companion = Modifier.INSTANCE;
                } else {
                    companion = modifier;
                }
                if (i5 != 0) {
                    z2 = true;
                }
                if ((i3 & 16) != 0) {
                    closedFloatingPointRangeRangeTo = RangesKt.rangeTo(0.0f, 1.0f);
                    i4 &= -57345;
                } else {
                    closedFloatingPointRangeRangeTo = closedFloatingPointRange2;
                }
                if (i7 != 0) {
                    i14 = 0;
                } else {
                    i14 = i8;
                }
                if (i10 != 0) {
                    function2 = null;
                } else {
                    function2 = function0;
                }
                if (i12 != 0) {
                    composerStartRestartGroup.startReplaceableGroup(-492369756);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "C(remember):Composables.kt#9igjgp");
                    objRememberedValue = composerStartRestartGroup.rememberedValue();
                    if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                        objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                    }
                    composerStartRestartGroup.endReplaceableGroup();
                    mutableInteractionSource2 = (MutableInteractionSource) objRememberedValue;
                } else {
                    mutableInteractionSource2 = mutableInteractionSource;
                }
                if ((i3 & 256) != 0) {
                    i15 = i4 & (-234881025);
                    sliderColorsM1150colorsq0g_0yA = SliderDefaults.INSTANCE.m1150colorsq0g_0yA(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 0, 6, 1023);
                } else {
                    i15 = i4;
                    sliderColorsM1150colorsq0g_0yA = sliderColors;
                }
            } else {
                if (i17 != 0) {
                    companion = Modifier.INSTANCE;
                } else {
                    companion = modifier;
                }
                if (i5 != 0) {
                    z2 = true;
                }
                if ((i3 & 16) != 0) {
                    closedFloatingPointRangeRangeTo = RangesKt.rangeTo(0.0f, 1.0f);
                    i4 &= -57345;
                } else {
                    closedFloatingPointRangeRangeTo = closedFloatingPointRange2;
                }
                if (i7 != 0) {
                    i14 = 0;
                } else {
                    i14 = i8;
                }
                if (i10 != 0) {
                    function2 = null;
                } else {
                    function2 = function0;
                }
                if (i12 != 0) {
                    composerStartRestartGroup.startReplaceableGroup(-492369756);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "C(remember):Composables.kt#9igjgp");
                    objRememberedValue = composerStartRestartGroup.rememberedValue();
                    if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                        objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                    }
                    composerStartRestartGroup.endReplaceableGroup();
                    mutableInteractionSource2 = (MutableInteractionSource) objRememberedValue;
                } else {
                    mutableInteractionSource2 = mutableInteractionSource;
                }
                if ((i3 & 256) != 0) {
                    i15 = i4 & (-234881025);
                    sliderColorsM1150colorsq0g_0yA = SliderDefaults.INSTANCE.m1150colorsq0g_0yA(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 0, 6, 1023);
                } else {
                    i15 = i4;
                    sliderColorsM1150colorsq0g_0yA = sliderColors;
                }
            }
            composerStartRestartGroup.endDefaults();
            if (i14 < 0) {
                throw new IllegalArgumentException("steps should be >= 0".toString());
            }
            State stateRememberUpdatedState1111 = SnapshotStateKt.rememberUpdatedState(onValueChange, composerStartRestartGroup, (i15 >> 3) & 14);
            Integer numValueOf1111 = Integer.valueOf(i14);
            composerStartRestartGroup.startReplaceableGroup(1157296644);
            ComposerKt.sourceInformation(composerStartRestartGroup, "C(remember)P(1):Composables.kt#9igjgp");
            zChanged = composerStartRestartGroup.changed(numValueOf1111);
            objRememberedValue2 = composerStartRestartGroup.rememberedValue();
            if (!zChanged) {
                objRememberedValue2 = stepsToTickFractions(i14);
                composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
            } else {
                objRememberedValue2 = stepsToTickFractions(i14);
                composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
            }
            composerStartRestartGroup.endReplaceableGroup();
            List list1111 = (List) objRememberedValue2;
            Modifier modifierMinimumTouchTargetSize1111 = TouchTargetKt.minimumTouchTargetSize(companion);
            float f1111112 = ThumbRadius;
            float f1111113 = 2;
            BoxWithConstraintsKt.BoxWithConstraints(FocusableKt.focusable(sliderSemantics(SizeKt.m460requiredSizeInqDBjuR0$default(modifierMinimumTouchTargetSize1111, Dp.m3843constructorimpl(f1111112 * f1111113), Dp.m3843constructorimpl(f1111112 * f1111113), 0.0f, 0.0f, 12, null), f, list1111, z2, onValueChange, closedFloatingPointRangeRangeTo, i14), z2, mutableInteractionSource2), null, false, ComposableLambdaKt.composableLambda(composerStartRestartGroup, 2085116814, true, new C10663(closedFloatingPointRangeRangeTo, i15, f, mutableInteractionSource2, z2, list1111, sliderColorsM1150colorsq0g_0yA, stateRememberUpdatedState1111, function2)), composerStartRestartGroup, 3072, 6);
            i16 = i14;
            function3 = function2;
            sliderColors2 = sliderColorsM1150colorsq0g_0yA;
            z3 = z2;
            mutableInteractionSource3 = mutableInteractionSource2;
            modifier2 = companion;
        }
        scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup == null) {
            return;
        }
        scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.SliderKt.Slider.4
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                invoke(composer2, num.intValue());
                return Unit.INSTANCE;
            }

            public final void invoke(Composer composer2, int i20) {
                SliderKt.Slider(f, onValueChange, modifier2, z3, closedFloatingPointRangeRangeTo, i16, function3, mutableInteractionSource3, sliderColors2, composer2, i2 | 1, i3);
            }
        });
    }

    /* JADX INFO: renamed from: androidx.compose.material.SliderKt$Slider$3, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: Slider.kt */
    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    static final class C10663 extends Lambda implements Function3<BoxWithConstraintsScope, Composer, Integer, Unit> {
        final /* synthetic */ int $$dirty;
        final /* synthetic */ SliderColors $colors;
        final /* synthetic */ boolean $enabled;
        final /* synthetic */ MutableInteractionSource $interactionSource;
        final /* synthetic */ Function0<Unit> $onValueChangeFinished;
        final /* synthetic */ State<Function1<Float, Unit>> $onValueChangeState;
        final /* synthetic */ List<Float> $tickFractions;
        final /* synthetic */ float $value;
        final /* synthetic */ ClosedFloatingPointRange<Float> $valueRange;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        C10663(ClosedFloatingPointRange<Float> closedFloatingPointRange, int i, float f, MutableInteractionSource mutableInteractionSource, boolean z, List<Float> list, SliderColors sliderColors, State<? extends Function1<? super Float, Unit>> state, Function0<Unit> function0) {
            super(3);
            this.$valueRange = closedFloatingPointRange;
            this.$$dirty = i;
            this.$value = f;
            this.$interactionSource = mutableInteractionSource;
            this.$enabled = z;
            this.$tickFractions = list;
            this.$colors = sliderColors;
            this.$onValueChangeState = state;
            this.$onValueChangeFinished = function0;
        }

        @Override // kotlin.jvm.functions.Function3
        public /* bridge */ /* synthetic */ Unit invoke(BoxWithConstraintsScope boxWithConstraintsScope, Composer composer, Integer num) {
            invoke(boxWithConstraintsScope, composer, num.intValue());
            return Unit.INSTANCE;
        }

        public final void invoke(BoxWithConstraintsScope BoxWithConstraints, Composer composer, int i) {
            int i2;
            Intrinsics.checkNotNullParameter(BoxWithConstraints, "$this$BoxWithConstraints");
            ComposerKt.sourceInformation(composer, "C167@8011L7,*172@8172L7,183@8586L24,184@8635L49,185@8711L31,187@8773L367,196@9150L83,198@9266L618,227@10378L55,234@10719L209:Slider.kt#jmzs0o");
            if ((i & 14) == 0) {
                i2 = i | (composer.changed(BoxWithConstraints) ? 4 : 2);
            } else {
                i2 = i;
            }
            if ((i2 & 91) != 18 || !composer.getSkipping()) {
                ProvidableCompositionLocal<LayoutDirection> localLayoutDirection = CompositionLocalsKt.getLocalLayoutDirection();
                ComposerKt.sourceInformationMarkerStart(composer, 2023513938, "C:CompositionLocal.kt#9igjgp");
                Object objConsume = composer.consume(localLayoutDirection);
                ComposerKt.sourceInformationMarkerEnd(composer);
                boolean z = objConsume == LayoutDirection.Rtl;
                float fM3799getMaxWidthimpl = Constraints.m3799getMaxWidthimpl(BoxWithConstraints.getConstraints());
                final Ref.FloatRef floatRef = new Ref.FloatRef();
                final Ref.FloatRef floatRef2 = new Ref.FloatRef();
                ProvidableCompositionLocal<Density> localDensity = CompositionLocalsKt.getLocalDensity();
                ComposerKt.sourceInformationMarkerStart(composer, 2023513938, "C:CompositionLocal.kt#9igjgp");
                Object objConsume2 = composer.consume(localDensity);
                ComposerKt.sourceInformationMarkerEnd(composer);
                Density density = (Density) objConsume2;
                floatRef.element = Math.max(fM3799getMaxWidthimpl - density.mo318toPx0680j_4(SliderKt.getThumbRadius()), 0.0f);
                floatRef2.element = Math.min(density.mo318toPx0680j_4(SliderKt.getThumbRadius()), floatRef.element);
                composer.startReplaceableGroup(773894976);
                ComposerKt.sourceInformation(composer, "C(rememberCoroutineScope)475@19849L144:Effects.kt#9igjgp");
                composer.startReplaceableGroup(-492369756);
                ComposerKt.sourceInformation(composer, "C(remember):Composables.kt#9igjgp");
                Object objRememberedValue = composer.rememberedValue();
                if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                    Object compositionScopedCoroutineScopeCanceller = new CompositionScopedCoroutineScopeCanceller(EffectsKt.createCompositionCoroutineScope(EmptyCoroutineContext.INSTANCE, composer));
                    composer.updateRememberedValue(compositionScopedCoroutineScopeCanceller);
                    objRememberedValue = compositionScopedCoroutineScopeCanceller;
                }
                composer.endReplaceableGroup();
                final CoroutineScope coroutineScope = ((CompositionScopedCoroutineScopeCanceller) objRememberedValue).getCoroutineScope();
                composer.endReplaceableGroup();
                float f = this.$value;
                ClosedFloatingPointRange<Float> closedFloatingPointRange = this.$valueRange;
                composer.startReplaceableGroup(-492369756);
                ComposerKt.sourceInformation(composer, "C(remember):Composables.kt#9igjgp");
                Object objRememberedValue2 = composer.rememberedValue();
                if (objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue2 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(Float.valueOf(invoke$scaleToOffset(closedFloatingPointRange, floatRef2, floatRef, f)), null, 2, null);
                    composer.updateRememberedValue(objRememberedValue2);
                }
                composer.endReplaceableGroup();
                final MutableState mutableState = (MutableState) objRememberedValue2;
                composer.startReplaceableGroup(-492369756);
                ComposerKt.sourceInformation(composer, "C(remember):Composables.kt#9igjgp");
                Object objRememberedValue3 = composer.rememberedValue();
                if (objRememberedValue3 == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue3 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(Float.valueOf(0.0f), null, 2, null);
                    composer.updateRememberedValue(objRememberedValue3);
                }
                composer.endReplaceableGroup();
                final MutableState mutableState2 = (MutableState) objRememberedValue3;
                Object objValueOf = Float.valueOf(floatRef2.element);
                Object objValueOf2 = Float.valueOf(floatRef.element);
                final ClosedFloatingPointRange<Float> closedFloatingPointRange2 = this.$valueRange;
                final State<Function1<Float, Unit>> state = this.$onValueChangeState;
                composer.startReplaceableGroup(1618982084);
                ComposerKt.sourceInformation(composer, "C(remember)P(1,2,3):Composables.kt#9igjgp");
                boolean zChanged = composer.changed(objValueOf) | composer.changed(objValueOf2) | composer.changed(closedFloatingPointRange2);
                Object objRememberedValue4 = composer.rememberedValue();
                if (zChanged || objRememberedValue4 == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue4 = new SliderDraggableState(new Function1<Float, Unit>() { // from class: androidx.compose.material.SliderKt$Slider$3$draggableState$1$1
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        /* JADX WARN: Multi-variable type inference failed */
                        {
                            super(1);
                        }

                        @Override // kotlin.jvm.functions.Function1
                        public /* bridge */ /* synthetic */ Unit invoke(Float f2) {
                            invoke(f2.floatValue());
                            return Unit.INSTANCE;
                        }

                        public final void invoke(float f2) {
                            MutableState<Float> mutableState3 = mutableState;
                            mutableState3.setValue(Float.valueOf(mutableState3.getValue().floatValue() + f2 + mutableState2.getValue().floatValue()));
                            mutableState2.setValue(Float.valueOf(0.0f));
                            state.getValue().invoke(Float.valueOf(SliderKt.C10663.invoke$scaleToUserValue(floatRef2, floatRef, closedFloatingPointRange2, RangesKt.coerceIn(mutableState.getValue().floatValue(), floatRef2.element, floatRef.element))));
                        }
                    });
                    composer.updateRememberedValue(objRememberedValue4);
                }
                composer.endReplaceableGroup();
                final SliderDraggableState sliderDraggableState = (SliderDraggableState) objRememberedValue4;
                AnonymousClass2 anonymousClass2 = new AnonymousClass2(this.$valueRange, floatRef2, floatRef);
                ClosedFloatingPointRange<Float> closedFloatingPointRange3 = this.$valueRange;
                ClosedFloatingPointRange<Float> closedFloatingPointRangeRangeTo = RangesKt.rangeTo(floatRef2.element, floatRef.element);
                float f2 = this.$value;
                int i3 = this.$$dirty;
                SliderKt.CorrectValueSideEffect(anonymousClass2, closedFloatingPointRange3, closedFloatingPointRangeRangeTo, mutableState, f2, composer, ((i3 >> 9) & 112) | 3072 | ((i3 << 12) & 57344));
                final List<Float> list = this.$tickFractions;
                final Function0<Unit> function0 = this.$onValueChangeFinished;
                State stateRememberUpdatedState = SnapshotStateKt.rememberUpdatedState(new Function1<Float, Unit>() { // from class: androidx.compose.material.SliderKt$Slider$3$gestureEndAction$1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(Float f3) {
                        invoke(f3.floatValue());
                        return Unit.INSTANCE;
                    }

                    public final void invoke(float f3) {
                        Function0<Unit> function1;
                        float fFloatValue = mutableState.getValue().floatValue();
                        float fSnapValueToTick = SliderKt.snapValueToTick(fFloatValue, list, floatRef2.element, floatRef.element);
                        if (fFloatValue != fSnapValueToTick) {
                            BuildersKt__Builders_commonKt.launch$default(coroutineScope, null, null, new AnonymousClass1(sliderDraggableState, fFloatValue, fSnapValueToTick, f3, function0, null), 3, null);
                        } else {
                            if (sliderDraggableState.isDragging() || (function1 = function0) == null) {
                                return;
                            }
                            function1.invoke();
                        }
                    }

                    /* JADX INFO: renamed from: androidx.compose.material.SliderKt$Slider$3$gestureEndAction$1$1, reason: invalid class name */
                    /* JADX INFO: compiled from: Slider.kt */
                    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
                    @DebugMetadata(c = "androidx.compose.material.SliderKt$Slider$3$gestureEndAction$1$1", f = "Slider.kt", i = {}, l = {204}, m = "invokeSuspend", n = {}, s = {})
                    static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
                        final /* synthetic */ float $current;
                        final /* synthetic */ SliderDraggableState $draggableState;
                        final /* synthetic */ Function0<Unit> $onValueChangeFinished;
                        final /* synthetic */ float $target;
                        final /* synthetic */ float $velocity;
                        int label;

                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        AnonymousClass1(SliderDraggableState sliderDraggableState, float f, float f2, float f3, Function0<Unit> function0, Continuation<? super AnonymousClass1> continuation) {
                            super(2, continuation);
                            this.$draggableState = sliderDraggableState;
                            this.$current = f;
                            this.$target = f2;
                            this.$velocity = f3;
                            this.$onValueChangeFinished = function0;
                        }

                        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                            return new AnonymousClass1(this.$draggableState, this.$current, this.$target, this.$velocity, this.$onValueChangeFinished, continuation);
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
                                if (SliderKt.animateToTarget(this.$draggableState, this.$current, this.$target, this.$velocity, this) == coroutine_suspended) {
                                    return coroutine_suspended;
                                }
                            } else {
                                if (i != 1) {
                                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                                }
                                ResultKt.throwOnFailure(obj);
                            }
                            Function0<Unit> function0 = this.$onValueChangeFinished;
                            if (function0 != null) {
                                function0.invoke();
                            }
                            return Unit.INSTANCE;
                        }
                    }
                }, composer, 0);
                SliderDraggableState sliderDraggableState2 = sliderDraggableState;
                Modifier modifierSliderTapModifier = SliderKt.sliderTapModifier(Modifier.INSTANCE, sliderDraggableState2, this.$interactionSource, fM3799getMaxWidthimpl, z, mutableState, stateRememberUpdatedState, mutableState2, this.$enabled);
                Modifier.Companion companion = Modifier.INSTANCE;
                Orientation orientation = Orientation.Horizontal;
                boolean zIsDragging = sliderDraggableState.isDragging();
                Modifier.Companion companion2 = companion;
                boolean z2 = this.$enabled;
                MutableInteractionSource mutableInteractionSource = this.$interactionSource;
                composer.startReplaceableGroup(1157296644);
                ComposerKt.sourceInformation(composer, "C(remember)P(1):Composables.kt#9igjgp");
                boolean zChanged2 = composer.changed(stateRememberUpdatedState);
                Object objRememberedValue5 = composer.rememberedValue();
                if (zChanged2 || objRememberedValue5 == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue5 = (Function3) new SliderKt$Slider$3$drag$1$1(stateRememberUpdatedState, null);
                    composer.updateRememberedValue(objRememberedValue5);
                }
                composer.endReplaceableGroup();
                Modifier modifierDraggable = DraggableKt.draggable(companion2, sliderDraggableState2, orientation, (32 & 4) != 0 ? true : z2, (32 & 8) != 0 ? null : mutableInteractionSource, (32 & 16) != 0 ? false : zIsDragging, (32 & 32) != 0 ? new DraggableKt.C09741(null) : null, (32 & 64) != 0 ? new DraggableKt.AnonymousClass2(null) : (Function3) objRememberedValue5, (32 & 128) != 0 ? false : z);
                float fCalcFraction = SliderKt.calcFraction(this.$valueRange.getStart().floatValue(), this.$valueRange.getEndInclusive().floatValue(), RangesKt.coerceIn(this.$value, this.$valueRange.getStart().floatValue(), this.$valueRange.getEndInclusive().floatValue()));
                boolean z3 = this.$enabled;
                List<Float> list2 = this.$tickFractions;
                SliderColors sliderColors = this.$colors;
                float f3 = floatRef.element - floatRef2.element;
                MutableInteractionSource mutableInteractionSource2 = this.$interactionSource;
                Modifier modifierThen = modifierSliderTapModifier.then(modifierDraggable);
                int i4 = this.$$dirty;
                SliderKt.SliderImpl(z3, fCalcFraction, list2, sliderColors, f3, mutableInteractionSource2, modifierThen, composer, ((i4 >> 9) & 14) | 512 | ((i4 >> 15) & 7168) | ((i4 >> 6) & 458752));
                return;
            }
            composer.skipToGroupEnd();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final float invoke$scaleToUserValue(Ref.FloatRef floatRef, Ref.FloatRef floatRef2, ClosedFloatingPointRange<Float> closedFloatingPointRange, float f) {
            return SliderKt.scale(floatRef.element, floatRef2.element, f, closedFloatingPointRange.getStart().floatValue(), closedFloatingPointRange.getEndInclusive().floatValue());
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final float invoke$scaleToOffset(ClosedFloatingPointRange<Float> closedFloatingPointRange, Ref.FloatRef floatRef, Ref.FloatRef floatRef2, float f) {
            return SliderKt.scale(closedFloatingPointRange.getStart().floatValue(), closedFloatingPointRange.getEndInclusive().floatValue(), f, floatRef.element, floatRef2.element);
        }

        /* JADX INFO: renamed from: androidx.compose.material.SliderKt$Slider$3$2, reason: invalid class name */
        /* JADX INFO: compiled from: Slider.kt */
        @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
        /* synthetic */ class AnonymousClass2 extends FunctionReferenceImpl implements Function1<Float, Float> {
            final /* synthetic */ Ref.FloatRef $maxPx;
            final /* synthetic */ Ref.FloatRef $minPx;
            final /* synthetic */ ClosedFloatingPointRange<Float> $valueRange;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            AnonymousClass2(ClosedFloatingPointRange<Float> closedFloatingPointRange, Ref.FloatRef floatRef, Ref.FloatRef floatRef2) {
                super(1, Intrinsics.Kotlin.class, "scaleToOffset", "invoke$scaleToOffset(Lkotlin/ranges/ClosedFloatingPointRange;Lkotlin/jvm/internal/Ref$FloatRef;Lkotlin/jvm/internal/Ref$FloatRef;F)F", 0);
                this.$valueRange = closedFloatingPointRange;
                this.$minPx = floatRef;
                this.$maxPx = floatRef2;
            }

            public final Float invoke(float f) {
                return Float.valueOf(C10663.invoke$scaleToOffset(this.$valueRange, this.$minPx, this.$maxPx, f));
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Float invoke(Float f) {
                return invoke(f.floatValue());
            }
        }
    }

    /* JADX WARN: Code duplicated, block: B:106:0x0151 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:107:0x0153  */
    /* JADX WARN: Code duplicated, block: B:108:0x0158  */
    /* JADX WARN: Code duplicated, block: B:110:0x015b  */
    /* JADX WARN: Code duplicated, block: B:113:0x0160  */
    /* JADX WARN: Code duplicated, block: B:115:0x016c  */
    /* JADX WARN: Code duplicated, block: B:117:0x0170  */
    /* JADX WARN: Code duplicated, block: B:118:0x0172  */
    /* JADX WARN: Code duplicated, block: B:121:0x0178  */
    /* JADX WARN: Code duplicated, block: B:122:0x01a5  */
    /* JADX WARN: Code duplicated, block: B:126:0x01cc  */
    /* JADX WARN: Code duplicated, block: B:129:0x01eb  */
    /* JADX WARN: Code duplicated, block: B:132:0x01fa  */
    /* JADX WARN: Code duplicated, block: B:134:0x021b  */
    /* JADX WARN: Code duplicated, block: B:136:0x0223  */
    /* JADX WARN: Code duplicated, block: B:141:0x0298  */
    /* JADX WARN: Code duplicated, block: B:143:0x02ac  */
    /* JADX WARN: Code duplicated, block: B:145:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:36:0x006f  */
    /* JADX WARN: Code duplicated, block: B:37:0x0072  */
    /* JADX WARN: Code duplicated, block: B:39:0x0076  */
    /* JADX WARN: Code duplicated, block: B:41:0x007e  */
    /* JADX WARN: Code duplicated, block: B:42:0x0081  */
    /* JADX WARN: Code duplicated, block: B:47:0x008d  */
    /* JADX WARN: Code duplicated, block: B:49:0x0091  */
    /* JADX WARN: Code duplicated, block: B:51:0x0099  */
    /* JADX WARN: Code duplicated, block: B:52:0x009c  */
    /* JADX WARN: Code duplicated, block: B:55:0x00a2  */
    /* JADX WARN: Code duplicated, block: B:58:0x00a8  */
    /* JADX WARN: Code duplicated, block: B:59:0x00ac  */
    /* JADX WARN: Code duplicated, block: B:61:0x00b1  */
    /* JADX WARN: Code duplicated, block: B:63:0x00b9  */
    /* JADX WARN: Code duplicated, block: B:64:0x00bc  */
    /* JADX WARN: Code duplicated, block: B:69:0x00c6  */
    /* JADX WARN: Code duplicated, block: B:70:0x00cd  */
    /* JADX WARN: Code duplicated, block: B:72:0x00d5  */
    /* JADX WARN: Code duplicated, block: B:74:0x00db  */
    /* JADX WARN: Code duplicated, block: B:75:0x00de  */
    /* JADX WARN: Code duplicated, block: B:79:0x00e8  */
    /* JADX WARN: Code duplicated, block: B:81:0x00ec  */
    /* JADX WARN: Code duplicated, block: B:84:0x00f7 A[ADDED_TO_REGION] */
    /* JADX WARN: Code duplicated, block: B:87:0x00fe  */
    /* JADX WARN: Code duplicated, block: B:90:0x010a  */
    /* JADX WARN: Code duplicated, block: B:94:0x011f  */
    /* JADX WARN: Code duplicated, block: B:96:0x012a  */
    @ExperimentalMaterialApi
    public static final void RangeSlider(final ClosedFloatingPointRange<Float> values, final Function1<? super ClosedFloatingPointRange<Float>, Unit> onValueChange, Modifier modifier, boolean z, ClosedFloatingPointRange<Float> closedFloatingPointRange, int i, Function0<Unit> function0, SliderColors sliderColors, Composer composer, final int i2, final int i3) {
        int i4;
        Modifier modifier2;
        int i5;
        boolean z2;
        int i6;
        ClosedFloatingPointRange<Float> closedFloatingPointRangeRangeTo;
        int i7;
        int i8;
        int i9;
        int i10;
        int i11;
        Modifier.Companion companion;
        Function0<Unit> function1;
        SliderColors sliderColorsM1150colorsq0g_0yA;
        boolean z3;
        ClosedFloatingPointRange<Float> closedFloatingPointRange2;
        int i12;
        int i13;
        Object objRememberedValue;
        MutableInteractionSource mutableInteractionSource;
        Object objRememberedValue2;
        MutableInteractionSource mutableInteractionSource2;
        boolean zChanged;
        Object objRememberedValue3;
        Composer composer2;
        final Modifier modifier3;
        final boolean z4;
        final ClosedFloatingPointRange<Float> closedFloatingPointRange3;
        final int i14;
        final Function0<Unit> function2;
        final SliderColors sliderColors2;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        Intrinsics.checkNotNullParameter(values, "values");
        Intrinsics.checkNotNullParameter(onValueChange, "onValueChange");
        Composer composerStartRestartGroup = composer.startRestartGroup(-1556183027);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(RangeSlider)P(7,3,2,1,6,5,4)290@13278L8,292@13350L39,293@13447L39,296@13568L35,297@13628L59,301@13693L4911:Slider.kt#jmzs0o");
        if ((i3 & 1) != 0) {
            i4 = i2 | 6;
        } else if ((i2 & 14) == 0) {
            i4 = (composerStartRestartGroup.changed(values) ? 4 : 2) | i2;
        } else {
            i4 = i2;
        }
        if ((i3 & 2) != 0) {
            i4 |= 48;
        } else if ((i2 & 112) == 0) {
            i4 |= composerStartRestartGroup.changed(onValueChange) ? 32 : 16;
        }
        int i15 = i3 & 4;
        if (i15 == 0) {
            if ((i2 & 896) == 0) {
                modifier2 = modifier;
                i4 |= composerStartRestartGroup.changed(modifier2) ? 256 : 128;
            }
            i5 = i3 & 8;
            if (i5 != 0) {
                if ((i2 & 7168) == 0) {
                    z2 = z;
                    if (composerStartRestartGroup.changed(z2)) {
                        i6 = 2048;
                    } else {
                        i6 = 1024;
                    }
                    i4 |= i6;
                }
                if ((57344 & i2) == 0) {
                    if ((i3 & 16) == 0) {
                        closedFloatingPointRangeRangeTo = closedFloatingPointRange;
                        int i16 = composerStartRestartGroup.changed(closedFloatingPointRangeRangeTo) ? 16384 : 8192;
                        i4 |= i16;
                    } else {
                        closedFloatingPointRangeRangeTo = closedFloatingPointRange;
                    }
                    i4 |= i16;
                } else {
                    closedFloatingPointRangeRangeTo = closedFloatingPointRange;
                }
                i7 = i3 & 32;
                if (i7 != 0) {
                    if ((458752 & i2) == 0) {
                        i8 = i;
                        if (composerStartRestartGroup.changed(i8)) {
                            i9 = 131072;
                        } else {
                            i9 = 65536;
                        }
                        i4 |= i9;
                    }
                    i10 = i3 & 64;
                    if (i10 != 0) {
                        i4 |= 1572864;
                    } else if ((i2 & 3670016) == 0) {
                        if (composerStartRestartGroup.changed(function0)) {
                            i11 = 1048576;
                        } else {
                            i11 = 524288;
                        }
                        i4 |= i11;
                    }
                    if ((i2 & 29360128) != 0) {
                        i4 |= ((i3 & 128) == 0 || !composerStartRestartGroup.changed(sliderColors)) ? 4194304 : 8388608;
                    }
                    if ((i4 & 23967451) == 4793490 || !composerStartRestartGroup.getSkipping()) {
                        composerStartRestartGroup.startDefaults();
                        if ((i2 & 1) != 0 || composerStartRestartGroup.getDefaultsInvalid()) {
                            if (i15 != 0) {
                                companion = Modifier.INSTANCE;
                            } else {
                                companion = modifier2;
                            }
                            if (i5 != 0) {
                                z2 = true;
                            }
                            if ((i3 & 16) != 0) {
                                i4 &= -57345;
                                closedFloatingPointRangeRangeTo = RangesKt.rangeTo(0.0f, 1.0f);
                            }
                            if (i7 != 0) {
                                i8 = 0;
                            }
                            if (i10 != 0) {
                                function1 = null;
                            } else {
                                function1 = function0;
                            }
                            if ((i3 & 128) != 0) {
                                i4 &= -29360129;
                                sliderColorsM1150colorsq0g_0yA = SliderDefaults.INSTANCE.m1150colorsq0g_0yA(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 0, 6, 1023);
                            } else {
                                sliderColorsM1150colorsq0g_0yA = sliderColors;
                            }
                            z3 = z2;
                            closedFloatingPointRange2 = closedFloatingPointRangeRangeTo;
                            i12 = i8;
                            i13 = i4;
                        } else {
                            composerStartRestartGroup.skipToGroupEnd();
                            if ((i3 & 16) != 0) {
                                i4 &= -57345;
                            }
                            if ((i3 & 128) != 0) {
                                i4 &= -29360129;
                            }
                            function1 = function0;
                            sliderColorsM1150colorsq0g_0yA = sliderColors;
                            i13 = i4;
                            companion = modifier2;
                            z3 = z2;
                            closedFloatingPointRange2 = closedFloatingPointRangeRangeTo;
                            i12 = i8;
                        }
                        composerStartRestartGroup.endDefaults();
                        composerStartRestartGroup.startReplaceableGroup(-492369756);
                        ComposerKt.sourceInformation(composerStartRestartGroup, "C(remember):Composables.kt#9igjgp");
                        objRememberedValue = composerStartRestartGroup.rememberedValue();
                        if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                            objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                        }
                        composerStartRestartGroup.endReplaceableGroup();
                        mutableInteractionSource = (MutableInteractionSource) objRememberedValue;
                        composerStartRestartGroup.startReplaceableGroup(-492369756);
                        ComposerKt.sourceInformation(composerStartRestartGroup, "C(remember):Composables.kt#9igjgp");
                        objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                        if (objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                            objRememberedValue2 = InteractionSourceKt.MutableInteractionSource();
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                        }
                        composerStartRestartGroup.endReplaceableGroup();
                        mutableInteractionSource2 = (MutableInteractionSource) objRememberedValue2;
                        if (i12 < 0) {
                            throw new IllegalArgumentException("steps should be >= 0".toString());
                        }
                        State stateRememberUpdatedState = SnapshotStateKt.rememberUpdatedState(onValueChange, composerStartRestartGroup, (i13 >> 3) & 14);
                        Integer numValueOf = Integer.valueOf(i12);
                        composerStartRestartGroup.startReplaceableGroup(1157296644);
                        ComposerKt.sourceInformation(composerStartRestartGroup, "C(remember)P(1):Composables.kt#9igjgp");
                        zChanged = composerStartRestartGroup.changed(numValueOf);
                        objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                        if (!zChanged || objRememberedValue3 == Composer.INSTANCE.getEmpty()) {
                            objRememberedValue3 = stepsToTickFractions(i12);
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                        }
                        composerStartRestartGroup.endReplaceableGroup();
                        Modifier modifierMinimumTouchTargetSize = TouchTargetKt.minimumTouchTargetSize(companion);
                        float f = ThumbRadius;
                        composer2 = composerStartRestartGroup;
                        BoxWithConstraintsKt.BoxWithConstraints(SizeKt.m460requiredSizeInqDBjuR0$default(modifierMinimumTouchTargetSize, Dp.m3843constructorimpl(4 * f), Dp.m3843constructorimpl(f * 2), 0.0f, 0.0f, 12, null), null, false, ComposableLambdaKt.composableLambda(composer2, 652589923, true, new C10642(closedFloatingPointRange2, values, i13, stateRememberUpdatedState, mutableInteractionSource, mutableInteractionSource2, z3, (List) objRememberedValue3, i12, sliderColorsM1150colorsq0g_0yA, function1)), composer2, 3072, 6);
                        modifier3 = companion;
                        z4 = z3;
                        closedFloatingPointRange3 = closedFloatingPointRange2;
                        i14 = i12;
                        function2 = function1;
                        sliderColors2 = sliderColorsM1150colorsq0g_0yA;
                    } else {
                        composerStartRestartGroup.skipToGroupEnd();
                        sliderColors2 = sliderColors;
                        modifier3 = modifier2;
                        z4 = z2;
                        closedFloatingPointRange3 = closedFloatingPointRangeRangeTo;
                        i14 = i8;
                        composer2 = composerStartRestartGroup;
                        function2 = function0;
                    }
                    scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup == null) {
                        return;
                    }
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.SliderKt.RangeSlider.3
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        /* JADX WARN: Multi-variable type inference failed */
                        {
                            super(2);
                        }

                        @Override // kotlin.jvm.functions.Function2
                        public /* bridge */ /* synthetic */ Unit invoke(Composer composer3, Integer num) {
                            invoke(composer3, num.intValue());
                            return Unit.INSTANCE;
                        }

                        public final void invoke(Composer composer3, int i17) {
                            SliderKt.RangeSlider(values, onValueChange, modifier3, z4, closedFloatingPointRange3, i14, function2, sliderColors2, composer3, i2 | 1, i3);
                        }
                    });
                }
                i4 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
                i8 = i;
                i10 = i3 & 64;
                if (i10 != 0) {
                    i4 |= 1572864;
                } else if ((i2 & 3670016) == 0) {
                    if (composerStartRestartGroup.changed(function0)) {
                        i11 = 1048576;
                    } else {
                        i11 = 524288;
                    }
                    i4 |= i11;
                }
                if ((i2 & 29360128) != 0) {
                    i4 |= ((i3 & 128) == 0 || !composerStartRestartGroup.changed(sliderColors)) ? 4194304 : 8388608;
                }
                if ((i4 & 23967451) == 4793490) {
                    composerStartRestartGroup.startDefaults();
                    if ((i2 & 1) != 0) {
                        if (i15 != 0) {
                            companion = Modifier.INSTANCE;
                        } else {
                            companion = modifier2;
                        }
                        if (i5 != 0) {
                            z2 = true;
                        }
                        if ((i3 & 16) != 0) {
                            i4 &= -57345;
                            closedFloatingPointRangeRangeTo = RangesKt.rangeTo(0.0f, 1.0f);
                        }
                        if (i7 != 0) {
                            i8 = 0;
                        }
                        if (i10 != 0) {
                            function1 = null;
                        } else {
                            function1 = function0;
                        }
                        if ((i3 & 128) != 0) {
                            i4 &= -29360129;
                            sliderColorsM1150colorsq0g_0yA = SliderDefaults.INSTANCE.m1150colorsq0g_0yA(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 0, 6, 1023);
                        } else {
                            sliderColorsM1150colorsq0g_0yA = sliderColors;
                        }
                        z3 = z2;
                        closedFloatingPointRange2 = closedFloatingPointRangeRangeTo;
                        i12 = i8;
                        i13 = i4;
                    } else {
                        if (i15 != 0) {
                            companion = Modifier.INSTANCE;
                        } else {
                            companion = modifier2;
                        }
                        if (i5 != 0) {
                            z2 = true;
                        }
                        if ((i3 & 16) != 0) {
                            i4 &= -57345;
                            closedFloatingPointRangeRangeTo = RangesKt.rangeTo(0.0f, 1.0f);
                        }
                        if (i7 != 0) {
                            i8 = 0;
                        }
                        if (i10 != 0) {
                            function1 = null;
                        } else {
                            function1 = function0;
                        }
                        if ((i3 & 128) != 0) {
                            i4 &= -29360129;
                            sliderColorsM1150colorsq0g_0yA = SliderDefaults.INSTANCE.m1150colorsq0g_0yA(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 0, 6, 1023);
                        } else {
                            sliderColorsM1150colorsq0g_0yA = sliderColors;
                        }
                        z3 = z2;
                        closedFloatingPointRange2 = closedFloatingPointRangeRangeTo;
                        i12 = i8;
                        i13 = i4;
                    }
                    composerStartRestartGroup.endDefaults();
                    composerStartRestartGroup.startReplaceableGroup(-492369756);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "C(remember):Composables.kt#9igjgp");
                    objRememberedValue = composerStartRestartGroup.rememberedValue();
                    if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                        objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                    }
                    composerStartRestartGroup.endReplaceableGroup();
                    mutableInteractionSource = (MutableInteractionSource) objRememberedValue;
                    composerStartRestartGroup.startReplaceableGroup(-492369756);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "C(remember):Composables.kt#9igjgp");
                    objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                    if (objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                        objRememberedValue2 = InteractionSourceKt.MutableInteractionSource();
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                    }
                    composerStartRestartGroup.endReplaceableGroup();
                    mutableInteractionSource2 = (MutableInteractionSource) objRememberedValue2;
                    if (i12 < 0) {
                        throw new IllegalArgumentException("steps should be >= 0".toString());
                    }
                    State stateRememberUpdatedState2 = SnapshotStateKt.rememberUpdatedState(onValueChange, composerStartRestartGroup, (i13 >> 3) & 14);
                    Integer numValueOf2 = Integer.valueOf(i12);
                    composerStartRestartGroup.startReplaceableGroup(1157296644);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "C(remember)P(1):Composables.kt#9igjgp");
                    zChanged = composerStartRestartGroup.changed(numValueOf2);
                    objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                    if (!zChanged) {
                        objRememberedValue3 = stepsToTickFractions(i12);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                    } else {
                        objRememberedValue3 = stepsToTickFractions(i12);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                    }
                    composerStartRestartGroup.endReplaceableGroup();
                    Modifier modifierMinimumTouchTargetSize2 = TouchTargetKt.minimumTouchTargetSize(companion);
                    float f2 = ThumbRadius;
                    composer2 = composerStartRestartGroup;
                    BoxWithConstraintsKt.BoxWithConstraints(SizeKt.m460requiredSizeInqDBjuR0$default(modifierMinimumTouchTargetSize2, Dp.m3843constructorimpl(4 * f2), Dp.m3843constructorimpl(f2 * 2), 0.0f, 0.0f, 12, null), null, false, ComposableLambdaKt.composableLambda(composer2, 652589923, true, new C10642(closedFloatingPointRange2, values, i13, stateRememberUpdatedState2, mutableInteractionSource, mutableInteractionSource2, z3, (List) objRememberedValue3, i12, sliderColorsM1150colorsq0g_0yA, function1)), composer2, 3072, 6);
                    modifier3 = companion;
                    z4 = z3;
                    closedFloatingPointRange3 = closedFloatingPointRange2;
                    i14 = i12;
                    function2 = function1;
                    sliderColors2 = sliderColorsM1150colorsq0g_0yA;
                } else {
                    composerStartRestartGroup.startDefaults();
                    if ((i2 & 1) != 0) {
                        if (i15 != 0) {
                            companion = Modifier.INSTANCE;
                        } else {
                            companion = modifier2;
                        }
                        if (i5 != 0) {
                            z2 = true;
                        }
                        if ((i3 & 16) != 0) {
                            i4 &= -57345;
                            closedFloatingPointRangeRangeTo = RangesKt.rangeTo(0.0f, 1.0f);
                        }
                        if (i7 != 0) {
                            i8 = 0;
                        }
                        if (i10 != 0) {
                            function1 = null;
                        } else {
                            function1 = function0;
                        }
                        if ((i3 & 128) != 0) {
                            i4 &= -29360129;
                            sliderColorsM1150colorsq0g_0yA = SliderDefaults.INSTANCE.m1150colorsq0g_0yA(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 0, 6, 1023);
                        } else {
                            sliderColorsM1150colorsq0g_0yA = sliderColors;
                        }
                        z3 = z2;
                        closedFloatingPointRange2 = closedFloatingPointRangeRangeTo;
                        i12 = i8;
                        i13 = i4;
                    } else {
                        if (i15 != 0) {
                            companion = Modifier.INSTANCE;
                        } else {
                            companion = modifier2;
                        }
                        if (i5 != 0) {
                            z2 = true;
                        }
                        if ((i3 & 16) != 0) {
                            i4 &= -57345;
                            closedFloatingPointRangeRangeTo = RangesKt.rangeTo(0.0f, 1.0f);
                        }
                        if (i7 != 0) {
                            i8 = 0;
                        }
                        if (i10 != 0) {
                            function1 = null;
                        } else {
                            function1 = function0;
                        }
                        if ((i3 & 128) != 0) {
                            i4 &= -29360129;
                            sliderColorsM1150colorsq0g_0yA = SliderDefaults.INSTANCE.m1150colorsq0g_0yA(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 0, 6, 1023);
                        } else {
                            sliderColorsM1150colorsq0g_0yA = sliderColors;
                        }
                        z3 = z2;
                        closedFloatingPointRange2 = closedFloatingPointRangeRangeTo;
                        i12 = i8;
                        i13 = i4;
                    }
                    composerStartRestartGroup.endDefaults();
                    composerStartRestartGroup.startReplaceableGroup(-492369756);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "C(remember):Composables.kt#9igjgp");
                    objRememberedValue = composerStartRestartGroup.rememberedValue();
                    if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                        objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                    }
                    composerStartRestartGroup.endReplaceableGroup();
                    mutableInteractionSource = (MutableInteractionSource) objRememberedValue;
                    composerStartRestartGroup.startReplaceableGroup(-492369756);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "C(remember):Composables.kt#9igjgp");
                    objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                    if (objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                        objRememberedValue2 = InteractionSourceKt.MutableInteractionSource();
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                    }
                    composerStartRestartGroup.endReplaceableGroup();
                    mutableInteractionSource2 = (MutableInteractionSource) objRememberedValue2;
                    if (i12 < 0) {
                        throw new IllegalArgumentException("steps should be >= 0".toString());
                    }
                    State stateRememberUpdatedState3 = SnapshotStateKt.rememberUpdatedState(onValueChange, composerStartRestartGroup, (i13 >> 3) & 14);
                    Integer numValueOf3 = Integer.valueOf(i12);
                    composerStartRestartGroup.startReplaceableGroup(1157296644);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "C(remember)P(1):Composables.kt#9igjgp");
                    zChanged = composerStartRestartGroup.changed(numValueOf3);
                    objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                    if (!zChanged) {
                        objRememberedValue3 = stepsToTickFractions(i12);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                    } else {
                        objRememberedValue3 = stepsToTickFractions(i12);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                    }
                    composerStartRestartGroup.endReplaceableGroup();
                    Modifier modifierMinimumTouchTargetSize3 = TouchTargetKt.minimumTouchTargetSize(companion);
                    float f3 = ThumbRadius;
                    composer2 = composerStartRestartGroup;
                    BoxWithConstraintsKt.BoxWithConstraints(SizeKt.m460requiredSizeInqDBjuR0$default(modifierMinimumTouchTargetSize3, Dp.m3843constructorimpl(4 * f3), Dp.m3843constructorimpl(f3 * 2), 0.0f, 0.0f, 12, null), null, false, ComposableLambdaKt.composableLambda(composer2, 652589923, true, new C10642(closedFloatingPointRange2, values, i13, stateRememberUpdatedState3, mutableInteractionSource, mutableInteractionSource2, z3, (List) objRememberedValue3, i12, sliderColorsM1150colorsq0g_0yA, function1)), composer2, 3072, 6);
                    modifier3 = companion;
                    z4 = z3;
                    closedFloatingPointRange3 = closedFloatingPointRange2;
                    i14 = i12;
                    function2 = function1;
                    sliderColors2 = sliderColorsM1150colorsq0g_0yA;
                }
                scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup == null) {
                    return;
                }
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.SliderKt.RangeSlider.3
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    /* JADX WARN: Multi-variable type inference failed */
                    {
                        super(2);
                    }

                    @Override // kotlin.jvm.functions.Function2
                    public /* bridge */ /* synthetic */ Unit invoke(Composer composer3, Integer num) {
                        invoke(composer3, num.intValue());
                        return Unit.INSTANCE;
                    }

                    public final void invoke(Composer composer3, int i17) {
                        SliderKt.RangeSlider(values, onValueChange, modifier3, z4, closedFloatingPointRange3, i14, function2, sliderColors2, composer3, i2 | 1, i3);
                    }
                });
            }
            i4 |= 3072;
            z2 = z;
            if ((57344 & i2) == 0) {
                if ((i3 & 16) == 0) {
                    closedFloatingPointRangeRangeTo = closedFloatingPointRange;
                    if (composerStartRestartGroup.changed(closedFloatingPointRangeRangeTo)) {
                    }
                    i4 |= i16;
                } else {
                    closedFloatingPointRangeRangeTo = closedFloatingPointRange;
                }
                i4 |= i16;
            } else {
                closedFloatingPointRangeRangeTo = closedFloatingPointRange;
            }
            i7 = i3 & 32;
            if (i7 != 0) {
                if ((458752 & i2) == 0) {
                    i8 = i;
                    if (composerStartRestartGroup.changed(i8)) {
                        i9 = 131072;
                    } else {
                        i9 = 65536;
                    }
                    i4 |= i9;
                }
                i10 = i3 & 64;
                if (i10 != 0) {
                    i4 |= 1572864;
                } else if ((i2 & 3670016) == 0) {
                    if (composerStartRestartGroup.changed(function0)) {
                        i11 = 1048576;
                    } else {
                        i11 = 524288;
                    }
                    i4 |= i11;
                }
                if ((i2 & 29360128) != 0) {
                    i4 |= ((i3 & 128) == 0 || !composerStartRestartGroup.changed(sliderColors)) ? 4194304 : 8388608;
                }
                if ((i4 & 23967451) == 4793490) {
                    composerStartRestartGroup.startDefaults();
                    if ((i2 & 1) != 0) {
                        if (i15 != 0) {
                            companion = Modifier.INSTANCE;
                        } else {
                            companion = modifier2;
                        }
                        if (i5 != 0) {
                            z2 = true;
                        }
                        if ((i3 & 16) != 0) {
                            i4 &= -57345;
                            closedFloatingPointRangeRangeTo = RangesKt.rangeTo(0.0f, 1.0f);
                        }
                        if (i7 != 0) {
                            i8 = 0;
                        }
                        if (i10 != 0) {
                            function1 = null;
                        } else {
                            function1 = function0;
                        }
                        if ((i3 & 128) != 0) {
                            i4 &= -29360129;
                            sliderColorsM1150colorsq0g_0yA = SliderDefaults.INSTANCE.m1150colorsq0g_0yA(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 0, 6, 1023);
                        } else {
                            sliderColorsM1150colorsq0g_0yA = sliderColors;
                        }
                        z3 = z2;
                        closedFloatingPointRange2 = closedFloatingPointRangeRangeTo;
                        i12 = i8;
                        i13 = i4;
                    } else {
                        if (i15 != 0) {
                            companion = Modifier.INSTANCE;
                        } else {
                            companion = modifier2;
                        }
                        if (i5 != 0) {
                            z2 = true;
                        }
                        if ((i3 & 16) != 0) {
                            i4 &= -57345;
                            closedFloatingPointRangeRangeTo = RangesKt.rangeTo(0.0f, 1.0f);
                        }
                        if (i7 != 0) {
                            i8 = 0;
                        }
                        if (i10 != 0) {
                            function1 = null;
                        } else {
                            function1 = function0;
                        }
                        if ((i3 & 128) != 0) {
                            i4 &= -29360129;
                            sliderColorsM1150colorsq0g_0yA = SliderDefaults.INSTANCE.m1150colorsq0g_0yA(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 0, 6, 1023);
                        } else {
                            sliderColorsM1150colorsq0g_0yA = sliderColors;
                        }
                        z3 = z2;
                        closedFloatingPointRange2 = closedFloatingPointRangeRangeTo;
                        i12 = i8;
                        i13 = i4;
                    }
                    composerStartRestartGroup.endDefaults();
                    composerStartRestartGroup.startReplaceableGroup(-492369756);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "C(remember):Composables.kt#9igjgp");
                    objRememberedValue = composerStartRestartGroup.rememberedValue();
                    if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                        objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                    }
                    composerStartRestartGroup.endReplaceableGroup();
                    mutableInteractionSource = (MutableInteractionSource) objRememberedValue;
                    composerStartRestartGroup.startReplaceableGroup(-492369756);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "C(remember):Composables.kt#9igjgp");
                    objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                    if (objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                        objRememberedValue2 = InteractionSourceKt.MutableInteractionSource();
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                    }
                    composerStartRestartGroup.endReplaceableGroup();
                    mutableInteractionSource2 = (MutableInteractionSource) objRememberedValue2;
                    if (i12 < 0) {
                        throw new IllegalArgumentException("steps should be >= 0".toString());
                    }
                    State stateRememberUpdatedState4 = SnapshotStateKt.rememberUpdatedState(onValueChange, composerStartRestartGroup, (i13 >> 3) & 14);
                    Integer numValueOf4 = Integer.valueOf(i12);
                    composerStartRestartGroup.startReplaceableGroup(1157296644);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "C(remember)P(1):Composables.kt#9igjgp");
                    zChanged = composerStartRestartGroup.changed(numValueOf4);
                    objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                    if (!zChanged) {
                        objRememberedValue3 = stepsToTickFractions(i12);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                    } else {
                        objRememberedValue3 = stepsToTickFractions(i12);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                    }
                    composerStartRestartGroup.endReplaceableGroup();
                    Modifier modifierMinimumTouchTargetSize4 = TouchTargetKt.minimumTouchTargetSize(companion);
                    float f4 = ThumbRadius;
                    composer2 = composerStartRestartGroup;
                    BoxWithConstraintsKt.BoxWithConstraints(SizeKt.m460requiredSizeInqDBjuR0$default(modifierMinimumTouchTargetSize4, Dp.m3843constructorimpl(4 * f4), Dp.m3843constructorimpl(f4 * 2), 0.0f, 0.0f, 12, null), null, false, ComposableLambdaKt.composableLambda(composer2, 652589923, true, new C10642(closedFloatingPointRange2, values, i13, stateRememberUpdatedState4, mutableInteractionSource, mutableInteractionSource2, z3, (List) objRememberedValue3, i12, sliderColorsM1150colorsq0g_0yA, function1)), composer2, 3072, 6);
                    modifier3 = companion;
                    z4 = z3;
                    closedFloatingPointRange3 = closedFloatingPointRange2;
                    i14 = i12;
                    function2 = function1;
                    sliderColors2 = sliderColorsM1150colorsq0g_0yA;
                } else {
                    composerStartRestartGroup.startDefaults();
                    if ((i2 & 1) != 0) {
                        if (i15 != 0) {
                            companion = Modifier.INSTANCE;
                        } else {
                            companion = modifier2;
                        }
                        if (i5 != 0) {
                            z2 = true;
                        }
                        if ((i3 & 16) != 0) {
                            i4 &= -57345;
                            closedFloatingPointRangeRangeTo = RangesKt.rangeTo(0.0f, 1.0f);
                        }
                        if (i7 != 0) {
                            i8 = 0;
                        }
                        if (i10 != 0) {
                            function1 = null;
                        } else {
                            function1 = function0;
                        }
                        if ((i3 & 128) != 0) {
                            i4 &= -29360129;
                            sliderColorsM1150colorsq0g_0yA = SliderDefaults.INSTANCE.m1150colorsq0g_0yA(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 0, 6, 1023);
                        } else {
                            sliderColorsM1150colorsq0g_0yA = sliderColors;
                        }
                        z3 = z2;
                        closedFloatingPointRange2 = closedFloatingPointRangeRangeTo;
                        i12 = i8;
                        i13 = i4;
                    } else {
                        if (i15 != 0) {
                            companion = Modifier.INSTANCE;
                        } else {
                            companion = modifier2;
                        }
                        if (i5 != 0) {
                            z2 = true;
                        }
                        if ((i3 & 16) != 0) {
                            i4 &= -57345;
                            closedFloatingPointRangeRangeTo = RangesKt.rangeTo(0.0f, 1.0f);
                        }
                        if (i7 != 0) {
                            i8 = 0;
                        }
                        if (i10 != 0) {
                            function1 = null;
                        } else {
                            function1 = function0;
                        }
                        if ((i3 & 128) != 0) {
                            i4 &= -29360129;
                            sliderColorsM1150colorsq0g_0yA = SliderDefaults.INSTANCE.m1150colorsq0g_0yA(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 0, 6, 1023);
                        } else {
                            sliderColorsM1150colorsq0g_0yA = sliderColors;
                        }
                        z3 = z2;
                        closedFloatingPointRange2 = closedFloatingPointRangeRangeTo;
                        i12 = i8;
                        i13 = i4;
                    }
                    composerStartRestartGroup.endDefaults();
                    composerStartRestartGroup.startReplaceableGroup(-492369756);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "C(remember):Composables.kt#9igjgp");
                    objRememberedValue = composerStartRestartGroup.rememberedValue();
                    if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                        objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                    }
                    composerStartRestartGroup.endReplaceableGroup();
                    mutableInteractionSource = (MutableInteractionSource) objRememberedValue;
                    composerStartRestartGroup.startReplaceableGroup(-492369756);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "C(remember):Composables.kt#9igjgp");
                    objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                    if (objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                        objRememberedValue2 = InteractionSourceKt.MutableInteractionSource();
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                    }
                    composerStartRestartGroup.endReplaceableGroup();
                    mutableInteractionSource2 = (MutableInteractionSource) objRememberedValue2;
                    if (i12 < 0) {
                        throw new IllegalArgumentException("steps should be >= 0".toString());
                    }
                    State stateRememberUpdatedState5 = SnapshotStateKt.rememberUpdatedState(onValueChange, composerStartRestartGroup, (i13 >> 3) & 14);
                    Integer numValueOf5 = Integer.valueOf(i12);
                    composerStartRestartGroup.startReplaceableGroup(1157296644);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "C(remember)P(1):Composables.kt#9igjgp");
                    zChanged = composerStartRestartGroup.changed(numValueOf5);
                    objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                    if (!zChanged) {
                        objRememberedValue3 = stepsToTickFractions(i12);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                    } else {
                        objRememberedValue3 = stepsToTickFractions(i12);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                    }
                    composerStartRestartGroup.endReplaceableGroup();
                    Modifier modifierMinimumTouchTargetSize5 = TouchTargetKt.minimumTouchTargetSize(companion);
                    float f5 = ThumbRadius;
                    composer2 = composerStartRestartGroup;
                    BoxWithConstraintsKt.BoxWithConstraints(SizeKt.m460requiredSizeInqDBjuR0$default(modifierMinimumTouchTargetSize5, Dp.m3843constructorimpl(4 * f5), Dp.m3843constructorimpl(f5 * 2), 0.0f, 0.0f, 12, null), null, false, ComposableLambdaKt.composableLambda(composer2, 652589923, true, new C10642(closedFloatingPointRange2, values, i13, stateRememberUpdatedState5, mutableInteractionSource, mutableInteractionSource2, z3, (List) objRememberedValue3, i12, sliderColorsM1150colorsq0g_0yA, function1)), composer2, 3072, 6);
                    modifier3 = companion;
                    z4 = z3;
                    closedFloatingPointRange3 = closedFloatingPointRange2;
                    i14 = i12;
                    function2 = function1;
                    sliderColors2 = sliderColorsM1150colorsq0g_0yA;
                }
                scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup == null) {
                    return;
                }
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.SliderKt.RangeSlider.3
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    /* JADX WARN: Multi-variable type inference failed */
                    {
                        super(2);
                    }

                    @Override // kotlin.jvm.functions.Function2
                    public /* bridge */ /* synthetic */ Unit invoke(Composer composer3, Integer num) {
                        invoke(composer3, num.intValue());
                        return Unit.INSTANCE;
                    }

                    public final void invoke(Composer composer3, int i17) {
                        SliderKt.RangeSlider(values, onValueChange, modifier3, z4, closedFloatingPointRange3, i14, function2, sliderColors2, composer3, i2 | 1, i3);
                    }
                });
            }
            i4 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
            i8 = i;
            i10 = i3 & 64;
            if (i10 != 0) {
                i4 |= 1572864;
            } else if ((i2 & 3670016) == 0) {
                if (composerStartRestartGroup.changed(function0)) {
                    i11 = 1048576;
                } else {
                    i11 = 524288;
                }
                i4 |= i11;
            }
            if ((i2 & 29360128) != 0) {
                i4 |= ((i3 & 128) == 0 || !composerStartRestartGroup.changed(sliderColors)) ? 4194304 : 8388608;
            }
            if ((i4 & 23967451) == 4793490) {
                composerStartRestartGroup.startDefaults();
                if ((i2 & 1) != 0) {
                    if (i15 != 0) {
                        companion = Modifier.INSTANCE;
                    } else {
                        companion = modifier2;
                    }
                    if (i5 != 0) {
                        z2 = true;
                    }
                    if ((i3 & 16) != 0) {
                        i4 &= -57345;
                        closedFloatingPointRangeRangeTo = RangesKt.rangeTo(0.0f, 1.0f);
                    }
                    if (i7 != 0) {
                        i8 = 0;
                    }
                    if (i10 != 0) {
                        function1 = null;
                    } else {
                        function1 = function0;
                    }
                    if ((i3 & 128) != 0) {
                        i4 &= -29360129;
                        sliderColorsM1150colorsq0g_0yA = SliderDefaults.INSTANCE.m1150colorsq0g_0yA(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 0, 6, 1023);
                    } else {
                        sliderColorsM1150colorsq0g_0yA = sliderColors;
                    }
                    z3 = z2;
                    closedFloatingPointRange2 = closedFloatingPointRangeRangeTo;
                    i12 = i8;
                    i13 = i4;
                } else {
                    if (i15 != 0) {
                        companion = Modifier.INSTANCE;
                    } else {
                        companion = modifier2;
                    }
                    if (i5 != 0) {
                        z2 = true;
                    }
                    if ((i3 & 16) != 0) {
                        i4 &= -57345;
                        closedFloatingPointRangeRangeTo = RangesKt.rangeTo(0.0f, 1.0f);
                    }
                    if (i7 != 0) {
                        i8 = 0;
                    }
                    if (i10 != 0) {
                        function1 = null;
                    } else {
                        function1 = function0;
                    }
                    if ((i3 & 128) != 0) {
                        i4 &= -29360129;
                        sliderColorsM1150colorsq0g_0yA = SliderDefaults.INSTANCE.m1150colorsq0g_0yA(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 0, 6, 1023);
                    } else {
                        sliderColorsM1150colorsq0g_0yA = sliderColors;
                    }
                    z3 = z2;
                    closedFloatingPointRange2 = closedFloatingPointRangeRangeTo;
                    i12 = i8;
                    i13 = i4;
                }
                composerStartRestartGroup.endDefaults();
                composerStartRestartGroup.startReplaceableGroup(-492369756);
                ComposerKt.sourceInformation(composerStartRestartGroup, "C(remember):Composables.kt#9igjgp");
                objRememberedValue = composerStartRestartGroup.rememberedValue();
                if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                }
                composerStartRestartGroup.endReplaceableGroup();
                mutableInteractionSource = (MutableInteractionSource) objRememberedValue;
                composerStartRestartGroup.startReplaceableGroup(-492369756);
                ComposerKt.sourceInformation(composerStartRestartGroup, "C(remember):Composables.kt#9igjgp");
                objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                if (objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue2 = InteractionSourceKt.MutableInteractionSource();
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                }
                composerStartRestartGroup.endReplaceableGroup();
                mutableInteractionSource2 = (MutableInteractionSource) objRememberedValue2;
                if (i12 < 0) {
                    throw new IllegalArgumentException("steps should be >= 0".toString());
                }
                State stateRememberUpdatedState6 = SnapshotStateKt.rememberUpdatedState(onValueChange, composerStartRestartGroup, (i13 >> 3) & 14);
                Integer numValueOf6 = Integer.valueOf(i12);
                composerStartRestartGroup.startReplaceableGroup(1157296644);
                ComposerKt.sourceInformation(composerStartRestartGroup, "C(remember)P(1):Composables.kt#9igjgp");
                zChanged = composerStartRestartGroup.changed(numValueOf6);
                objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                if (!zChanged) {
                    objRememberedValue3 = stepsToTickFractions(i12);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                } else {
                    objRememberedValue3 = stepsToTickFractions(i12);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                }
                composerStartRestartGroup.endReplaceableGroup();
                Modifier modifierMinimumTouchTargetSize6 = TouchTargetKt.minimumTouchTargetSize(companion);
                float f6 = ThumbRadius;
                composer2 = composerStartRestartGroup;
                BoxWithConstraintsKt.BoxWithConstraints(SizeKt.m460requiredSizeInqDBjuR0$default(modifierMinimumTouchTargetSize6, Dp.m3843constructorimpl(4 * f6), Dp.m3843constructorimpl(f6 * 2), 0.0f, 0.0f, 12, null), null, false, ComposableLambdaKt.composableLambda(composer2, 652589923, true, new C10642(closedFloatingPointRange2, values, i13, stateRememberUpdatedState6, mutableInteractionSource, mutableInteractionSource2, z3, (List) objRememberedValue3, i12, sliderColorsM1150colorsq0g_0yA, function1)), composer2, 3072, 6);
                modifier3 = companion;
                z4 = z3;
                closedFloatingPointRange3 = closedFloatingPointRange2;
                i14 = i12;
                function2 = function1;
                sliderColors2 = sliderColorsM1150colorsq0g_0yA;
            } else {
                composerStartRestartGroup.startDefaults();
                if ((i2 & 1) != 0) {
                    if (i15 != 0) {
                        companion = Modifier.INSTANCE;
                    } else {
                        companion = modifier2;
                    }
                    if (i5 != 0) {
                        z2 = true;
                    }
                    if ((i3 & 16) != 0) {
                        i4 &= -57345;
                        closedFloatingPointRangeRangeTo = RangesKt.rangeTo(0.0f, 1.0f);
                    }
                    if (i7 != 0) {
                        i8 = 0;
                    }
                    if (i10 != 0) {
                        function1 = null;
                    } else {
                        function1 = function0;
                    }
                    if ((i3 & 128) != 0) {
                        i4 &= -29360129;
                        sliderColorsM1150colorsq0g_0yA = SliderDefaults.INSTANCE.m1150colorsq0g_0yA(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 0, 6, 1023);
                    } else {
                        sliderColorsM1150colorsq0g_0yA = sliderColors;
                    }
                    z3 = z2;
                    closedFloatingPointRange2 = closedFloatingPointRangeRangeTo;
                    i12 = i8;
                    i13 = i4;
                } else {
                    if (i15 != 0) {
                        companion = Modifier.INSTANCE;
                    } else {
                        companion = modifier2;
                    }
                    if (i5 != 0) {
                        z2 = true;
                    }
                    if ((i3 & 16) != 0) {
                        i4 &= -57345;
                        closedFloatingPointRangeRangeTo = RangesKt.rangeTo(0.0f, 1.0f);
                    }
                    if (i7 != 0) {
                        i8 = 0;
                    }
                    if (i10 != 0) {
                        function1 = null;
                    } else {
                        function1 = function0;
                    }
                    if ((i3 & 128) != 0) {
                        i4 &= -29360129;
                        sliderColorsM1150colorsq0g_0yA = SliderDefaults.INSTANCE.m1150colorsq0g_0yA(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 0, 6, 1023);
                    } else {
                        sliderColorsM1150colorsq0g_0yA = sliderColors;
                    }
                    z3 = z2;
                    closedFloatingPointRange2 = closedFloatingPointRangeRangeTo;
                    i12 = i8;
                    i13 = i4;
                }
                composerStartRestartGroup.endDefaults();
                composerStartRestartGroup.startReplaceableGroup(-492369756);
                ComposerKt.sourceInformation(composerStartRestartGroup, "C(remember):Composables.kt#9igjgp");
                objRememberedValue = composerStartRestartGroup.rememberedValue();
                if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                }
                composerStartRestartGroup.endReplaceableGroup();
                mutableInteractionSource = (MutableInteractionSource) objRememberedValue;
                composerStartRestartGroup.startReplaceableGroup(-492369756);
                ComposerKt.sourceInformation(composerStartRestartGroup, "C(remember):Composables.kt#9igjgp");
                objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                if (objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue2 = InteractionSourceKt.MutableInteractionSource();
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                }
                composerStartRestartGroup.endReplaceableGroup();
                mutableInteractionSource2 = (MutableInteractionSource) objRememberedValue2;
                if (i12 < 0) {
                    throw new IllegalArgumentException("steps should be >= 0".toString());
                }
                State stateRememberUpdatedState7 = SnapshotStateKt.rememberUpdatedState(onValueChange, composerStartRestartGroup, (i13 >> 3) & 14);
                Integer numValueOf7 = Integer.valueOf(i12);
                composerStartRestartGroup.startReplaceableGroup(1157296644);
                ComposerKt.sourceInformation(composerStartRestartGroup, "C(remember)P(1):Composables.kt#9igjgp");
                zChanged = composerStartRestartGroup.changed(numValueOf7);
                objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                if (!zChanged) {
                    objRememberedValue3 = stepsToTickFractions(i12);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                } else {
                    objRememberedValue3 = stepsToTickFractions(i12);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                }
                composerStartRestartGroup.endReplaceableGroup();
                Modifier modifierMinimumTouchTargetSize7 = TouchTargetKt.minimumTouchTargetSize(companion);
                float f7 = ThumbRadius;
                composer2 = composerStartRestartGroup;
                BoxWithConstraintsKt.BoxWithConstraints(SizeKt.m460requiredSizeInqDBjuR0$default(modifierMinimumTouchTargetSize7, Dp.m3843constructorimpl(4 * f7), Dp.m3843constructorimpl(f7 * 2), 0.0f, 0.0f, 12, null), null, false, ComposableLambdaKt.composableLambda(composer2, 652589923, true, new C10642(closedFloatingPointRange2, values, i13, stateRememberUpdatedState7, mutableInteractionSource, mutableInteractionSource2, z3, (List) objRememberedValue3, i12, sliderColorsM1150colorsq0g_0yA, function1)), composer2, 3072, 6);
                modifier3 = companion;
                z4 = z3;
                closedFloatingPointRange3 = closedFloatingPointRange2;
                i14 = i12;
                function2 = function1;
                sliderColors2 = sliderColorsM1150colorsq0g_0yA;
            }
            scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup == null) {
                return;
            }
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.SliderKt.RangeSlider.3
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Composer composer3, Integer num) {
                    invoke(composer3, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(Composer composer3, int i17) {
                    SliderKt.RangeSlider(values, onValueChange, modifier3, z4, closedFloatingPointRange3, i14, function2, sliderColors2, composer3, i2 | 1, i3);
                }
            });
        }
        i4 |= 384;
        modifier2 = modifier;
        i5 = i3 & 8;
        if (i5 != 0) {
            if ((i2 & 7168) == 0) {
                z2 = z;
                if (composerStartRestartGroup.changed(z2)) {
                    i6 = 2048;
                } else {
                    i6 = 1024;
                }
                i4 |= i6;
            }
            if ((57344 & i2) == 0) {
                if ((i3 & 16) == 0) {
                    closedFloatingPointRangeRangeTo = closedFloatingPointRange;
                    if (composerStartRestartGroup.changed(closedFloatingPointRangeRangeTo)) {
                    }
                    i4 |= i16;
                } else {
                    closedFloatingPointRangeRangeTo = closedFloatingPointRange;
                }
                i4 |= i16;
            } else {
                closedFloatingPointRangeRangeTo = closedFloatingPointRange;
            }
            i7 = i3 & 32;
            if (i7 != 0) {
                if ((458752 & i2) == 0) {
                    i8 = i;
                    if (composerStartRestartGroup.changed(i8)) {
                        i9 = 131072;
                    } else {
                        i9 = 65536;
                    }
                    i4 |= i9;
                }
                i10 = i3 & 64;
                if (i10 != 0) {
                    i4 |= 1572864;
                } else if ((i2 & 3670016) == 0) {
                    if (composerStartRestartGroup.changed(function0)) {
                        i11 = 1048576;
                    } else {
                        i11 = 524288;
                    }
                    i4 |= i11;
                }
                if ((i2 & 29360128) != 0) {
                    i4 |= ((i3 & 128) == 0 || !composerStartRestartGroup.changed(sliderColors)) ? 4194304 : 8388608;
                }
                if ((i4 & 23967451) == 4793490) {
                    composerStartRestartGroup.startDefaults();
                    if ((i2 & 1) != 0) {
                        if (i15 != 0) {
                            companion = Modifier.INSTANCE;
                        } else {
                            companion = modifier2;
                        }
                        if (i5 != 0) {
                            z2 = true;
                        }
                        if ((i3 & 16) != 0) {
                            i4 &= -57345;
                            closedFloatingPointRangeRangeTo = RangesKt.rangeTo(0.0f, 1.0f);
                        }
                        if (i7 != 0) {
                            i8 = 0;
                        }
                        if (i10 != 0) {
                            function1 = null;
                        } else {
                            function1 = function0;
                        }
                        if ((i3 & 128) != 0) {
                            i4 &= -29360129;
                            sliderColorsM1150colorsq0g_0yA = SliderDefaults.INSTANCE.m1150colorsq0g_0yA(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 0, 6, 1023);
                        } else {
                            sliderColorsM1150colorsq0g_0yA = sliderColors;
                        }
                        z3 = z2;
                        closedFloatingPointRange2 = closedFloatingPointRangeRangeTo;
                        i12 = i8;
                        i13 = i4;
                    } else {
                        if (i15 != 0) {
                            companion = Modifier.INSTANCE;
                        } else {
                            companion = modifier2;
                        }
                        if (i5 != 0) {
                            z2 = true;
                        }
                        if ((i3 & 16) != 0) {
                            i4 &= -57345;
                            closedFloatingPointRangeRangeTo = RangesKt.rangeTo(0.0f, 1.0f);
                        }
                        if (i7 != 0) {
                            i8 = 0;
                        }
                        if (i10 != 0) {
                            function1 = null;
                        } else {
                            function1 = function0;
                        }
                        if ((i3 & 128) != 0) {
                            i4 &= -29360129;
                            sliderColorsM1150colorsq0g_0yA = SliderDefaults.INSTANCE.m1150colorsq0g_0yA(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 0, 6, 1023);
                        } else {
                            sliderColorsM1150colorsq0g_0yA = sliderColors;
                        }
                        z3 = z2;
                        closedFloatingPointRange2 = closedFloatingPointRangeRangeTo;
                        i12 = i8;
                        i13 = i4;
                    }
                    composerStartRestartGroup.endDefaults();
                    composerStartRestartGroup.startReplaceableGroup(-492369756);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "C(remember):Composables.kt#9igjgp");
                    objRememberedValue = composerStartRestartGroup.rememberedValue();
                    if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                        objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                    }
                    composerStartRestartGroup.endReplaceableGroup();
                    mutableInteractionSource = (MutableInteractionSource) objRememberedValue;
                    composerStartRestartGroup.startReplaceableGroup(-492369756);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "C(remember):Composables.kt#9igjgp");
                    objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                    if (objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                        objRememberedValue2 = InteractionSourceKt.MutableInteractionSource();
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                    }
                    composerStartRestartGroup.endReplaceableGroup();
                    mutableInteractionSource2 = (MutableInteractionSource) objRememberedValue2;
                    if (i12 < 0) {
                        throw new IllegalArgumentException("steps should be >= 0".toString());
                    }
                    State stateRememberUpdatedState8 = SnapshotStateKt.rememberUpdatedState(onValueChange, composerStartRestartGroup, (i13 >> 3) & 14);
                    Integer numValueOf8 = Integer.valueOf(i12);
                    composerStartRestartGroup.startReplaceableGroup(1157296644);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "C(remember)P(1):Composables.kt#9igjgp");
                    zChanged = composerStartRestartGroup.changed(numValueOf8);
                    objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                    if (!zChanged) {
                        objRememberedValue3 = stepsToTickFractions(i12);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                    } else {
                        objRememberedValue3 = stepsToTickFractions(i12);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                    }
                    composerStartRestartGroup.endReplaceableGroup();
                    Modifier modifierMinimumTouchTargetSize8 = TouchTargetKt.minimumTouchTargetSize(companion);
                    float f8 = ThumbRadius;
                    composer2 = composerStartRestartGroup;
                    BoxWithConstraintsKt.BoxWithConstraints(SizeKt.m460requiredSizeInqDBjuR0$default(modifierMinimumTouchTargetSize8, Dp.m3843constructorimpl(4 * f8), Dp.m3843constructorimpl(f8 * 2), 0.0f, 0.0f, 12, null), null, false, ComposableLambdaKt.composableLambda(composer2, 652589923, true, new C10642(closedFloatingPointRange2, values, i13, stateRememberUpdatedState8, mutableInteractionSource, mutableInteractionSource2, z3, (List) objRememberedValue3, i12, sliderColorsM1150colorsq0g_0yA, function1)), composer2, 3072, 6);
                    modifier3 = companion;
                    z4 = z3;
                    closedFloatingPointRange3 = closedFloatingPointRange2;
                    i14 = i12;
                    function2 = function1;
                    sliderColors2 = sliderColorsM1150colorsq0g_0yA;
                } else {
                    composerStartRestartGroup.startDefaults();
                    if ((i2 & 1) != 0) {
                        if (i15 != 0) {
                            companion = Modifier.INSTANCE;
                        } else {
                            companion = modifier2;
                        }
                        if (i5 != 0) {
                            z2 = true;
                        }
                        if ((i3 & 16) != 0) {
                            i4 &= -57345;
                            closedFloatingPointRangeRangeTo = RangesKt.rangeTo(0.0f, 1.0f);
                        }
                        if (i7 != 0) {
                            i8 = 0;
                        }
                        if (i10 != 0) {
                            function1 = null;
                        } else {
                            function1 = function0;
                        }
                        if ((i3 & 128) != 0) {
                            i4 &= -29360129;
                            sliderColorsM1150colorsq0g_0yA = SliderDefaults.INSTANCE.m1150colorsq0g_0yA(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 0, 6, 1023);
                        } else {
                            sliderColorsM1150colorsq0g_0yA = sliderColors;
                        }
                        z3 = z2;
                        closedFloatingPointRange2 = closedFloatingPointRangeRangeTo;
                        i12 = i8;
                        i13 = i4;
                    } else {
                        if (i15 != 0) {
                            companion = Modifier.INSTANCE;
                        } else {
                            companion = modifier2;
                        }
                        if (i5 != 0) {
                            z2 = true;
                        }
                        if ((i3 & 16) != 0) {
                            i4 &= -57345;
                            closedFloatingPointRangeRangeTo = RangesKt.rangeTo(0.0f, 1.0f);
                        }
                        if (i7 != 0) {
                            i8 = 0;
                        }
                        if (i10 != 0) {
                            function1 = null;
                        } else {
                            function1 = function0;
                        }
                        if ((i3 & 128) != 0) {
                            i4 &= -29360129;
                            sliderColorsM1150colorsq0g_0yA = SliderDefaults.INSTANCE.m1150colorsq0g_0yA(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 0, 6, 1023);
                        } else {
                            sliderColorsM1150colorsq0g_0yA = sliderColors;
                        }
                        z3 = z2;
                        closedFloatingPointRange2 = closedFloatingPointRangeRangeTo;
                        i12 = i8;
                        i13 = i4;
                    }
                    composerStartRestartGroup.endDefaults();
                    composerStartRestartGroup.startReplaceableGroup(-492369756);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "C(remember):Composables.kt#9igjgp");
                    objRememberedValue = composerStartRestartGroup.rememberedValue();
                    if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                        objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                    }
                    composerStartRestartGroup.endReplaceableGroup();
                    mutableInteractionSource = (MutableInteractionSource) objRememberedValue;
                    composerStartRestartGroup.startReplaceableGroup(-492369756);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "C(remember):Composables.kt#9igjgp");
                    objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                    if (objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                        objRememberedValue2 = InteractionSourceKt.MutableInteractionSource();
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                    }
                    composerStartRestartGroup.endReplaceableGroup();
                    mutableInteractionSource2 = (MutableInteractionSource) objRememberedValue2;
                    if (i12 < 0) {
                        throw new IllegalArgumentException("steps should be >= 0".toString());
                    }
                    State stateRememberUpdatedState9 = SnapshotStateKt.rememberUpdatedState(onValueChange, composerStartRestartGroup, (i13 >> 3) & 14);
                    Integer numValueOf9 = Integer.valueOf(i12);
                    composerStartRestartGroup.startReplaceableGroup(1157296644);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "C(remember)P(1):Composables.kt#9igjgp");
                    zChanged = composerStartRestartGroup.changed(numValueOf9);
                    objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                    if (!zChanged) {
                        objRememberedValue3 = stepsToTickFractions(i12);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                    } else {
                        objRememberedValue3 = stepsToTickFractions(i12);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                    }
                    composerStartRestartGroup.endReplaceableGroup();
                    Modifier modifierMinimumTouchTargetSize9 = TouchTargetKt.minimumTouchTargetSize(companion);
                    float f9 = ThumbRadius;
                    composer2 = composerStartRestartGroup;
                    BoxWithConstraintsKt.BoxWithConstraints(SizeKt.m460requiredSizeInqDBjuR0$default(modifierMinimumTouchTargetSize9, Dp.m3843constructorimpl(4 * f9), Dp.m3843constructorimpl(f9 * 2), 0.0f, 0.0f, 12, null), null, false, ComposableLambdaKt.composableLambda(composer2, 652589923, true, new C10642(closedFloatingPointRange2, values, i13, stateRememberUpdatedState9, mutableInteractionSource, mutableInteractionSource2, z3, (List) objRememberedValue3, i12, sliderColorsM1150colorsq0g_0yA, function1)), composer2, 3072, 6);
                    modifier3 = companion;
                    z4 = z3;
                    closedFloatingPointRange3 = closedFloatingPointRange2;
                    i14 = i12;
                    function2 = function1;
                    sliderColors2 = sliderColorsM1150colorsq0g_0yA;
                }
                scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup == null) {
                    return;
                }
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.SliderKt.RangeSlider.3
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    /* JADX WARN: Multi-variable type inference failed */
                    {
                        super(2);
                    }

                    @Override // kotlin.jvm.functions.Function2
                    public /* bridge */ /* synthetic */ Unit invoke(Composer composer3, Integer num) {
                        invoke(composer3, num.intValue());
                        return Unit.INSTANCE;
                    }

                    public final void invoke(Composer composer3, int i17) {
                        SliderKt.RangeSlider(values, onValueChange, modifier3, z4, closedFloatingPointRange3, i14, function2, sliderColors2, composer3, i2 | 1, i3);
                    }
                });
            }
            i4 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
            i8 = i;
            i10 = i3 & 64;
            if (i10 != 0) {
                i4 |= 1572864;
            } else if ((i2 & 3670016) == 0) {
                if (composerStartRestartGroup.changed(function0)) {
                    i11 = 1048576;
                } else {
                    i11 = 524288;
                }
                i4 |= i11;
            }
            if ((i2 & 29360128) != 0) {
                i4 |= ((i3 & 128) == 0 || !composerStartRestartGroup.changed(sliderColors)) ? 4194304 : 8388608;
            }
            if ((i4 & 23967451) == 4793490) {
                composerStartRestartGroup.startDefaults();
                if ((i2 & 1) != 0) {
                    if (i15 != 0) {
                        companion = Modifier.INSTANCE;
                    } else {
                        companion = modifier2;
                    }
                    if (i5 != 0) {
                        z2 = true;
                    }
                    if ((i3 & 16) != 0) {
                        i4 &= -57345;
                        closedFloatingPointRangeRangeTo = RangesKt.rangeTo(0.0f, 1.0f);
                    }
                    if (i7 != 0) {
                        i8 = 0;
                    }
                    if (i10 != 0) {
                        function1 = null;
                    } else {
                        function1 = function0;
                    }
                    if ((i3 & 128) != 0) {
                        i4 &= -29360129;
                        sliderColorsM1150colorsq0g_0yA = SliderDefaults.INSTANCE.m1150colorsq0g_0yA(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 0, 6, 1023);
                    } else {
                        sliderColorsM1150colorsq0g_0yA = sliderColors;
                    }
                    z3 = z2;
                    closedFloatingPointRange2 = closedFloatingPointRangeRangeTo;
                    i12 = i8;
                    i13 = i4;
                } else {
                    if (i15 != 0) {
                        companion = Modifier.INSTANCE;
                    } else {
                        companion = modifier2;
                    }
                    if (i5 != 0) {
                        z2 = true;
                    }
                    if ((i3 & 16) != 0) {
                        i4 &= -57345;
                        closedFloatingPointRangeRangeTo = RangesKt.rangeTo(0.0f, 1.0f);
                    }
                    if (i7 != 0) {
                        i8 = 0;
                    }
                    if (i10 != 0) {
                        function1 = null;
                    } else {
                        function1 = function0;
                    }
                    if ((i3 & 128) != 0) {
                        i4 &= -29360129;
                        sliderColorsM1150colorsq0g_0yA = SliderDefaults.INSTANCE.m1150colorsq0g_0yA(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 0, 6, 1023);
                    } else {
                        sliderColorsM1150colorsq0g_0yA = sliderColors;
                    }
                    z3 = z2;
                    closedFloatingPointRange2 = closedFloatingPointRangeRangeTo;
                    i12 = i8;
                    i13 = i4;
                }
                composerStartRestartGroup.endDefaults();
                composerStartRestartGroup.startReplaceableGroup(-492369756);
                ComposerKt.sourceInformation(composerStartRestartGroup, "C(remember):Composables.kt#9igjgp");
                objRememberedValue = composerStartRestartGroup.rememberedValue();
                if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                }
                composerStartRestartGroup.endReplaceableGroup();
                mutableInteractionSource = (MutableInteractionSource) objRememberedValue;
                composerStartRestartGroup.startReplaceableGroup(-492369756);
                ComposerKt.sourceInformation(composerStartRestartGroup, "C(remember):Composables.kt#9igjgp");
                objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                if (objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue2 = InteractionSourceKt.MutableInteractionSource();
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                }
                composerStartRestartGroup.endReplaceableGroup();
                mutableInteractionSource2 = (MutableInteractionSource) objRememberedValue2;
                if (i12 < 0) {
                    throw new IllegalArgumentException("steps should be >= 0".toString());
                }
                State stateRememberUpdatedState10 = SnapshotStateKt.rememberUpdatedState(onValueChange, composerStartRestartGroup, (i13 >> 3) & 14);
                Integer numValueOf10 = Integer.valueOf(i12);
                composerStartRestartGroup.startReplaceableGroup(1157296644);
                ComposerKt.sourceInformation(composerStartRestartGroup, "C(remember)P(1):Composables.kt#9igjgp");
                zChanged = composerStartRestartGroup.changed(numValueOf10);
                objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                if (!zChanged) {
                    objRememberedValue3 = stepsToTickFractions(i12);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                } else {
                    objRememberedValue3 = stepsToTickFractions(i12);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                }
                composerStartRestartGroup.endReplaceableGroup();
                Modifier modifierMinimumTouchTargetSize10 = TouchTargetKt.minimumTouchTargetSize(companion);
                float f10 = ThumbRadius;
                composer2 = composerStartRestartGroup;
                BoxWithConstraintsKt.BoxWithConstraints(SizeKt.m460requiredSizeInqDBjuR0$default(modifierMinimumTouchTargetSize10, Dp.m3843constructorimpl(4 * f10), Dp.m3843constructorimpl(f10 * 2), 0.0f, 0.0f, 12, null), null, false, ComposableLambdaKt.composableLambda(composer2, 652589923, true, new C10642(closedFloatingPointRange2, values, i13, stateRememberUpdatedState10, mutableInteractionSource, mutableInteractionSource2, z3, (List) objRememberedValue3, i12, sliderColorsM1150colorsq0g_0yA, function1)), composer2, 3072, 6);
                modifier3 = companion;
                z4 = z3;
                closedFloatingPointRange3 = closedFloatingPointRange2;
                i14 = i12;
                function2 = function1;
                sliderColors2 = sliderColorsM1150colorsq0g_0yA;
            } else {
                composerStartRestartGroup.startDefaults();
                if ((i2 & 1) != 0) {
                    if (i15 != 0) {
                        companion = Modifier.INSTANCE;
                    } else {
                        companion = modifier2;
                    }
                    if (i5 != 0) {
                        z2 = true;
                    }
                    if ((i3 & 16) != 0) {
                        i4 &= -57345;
                        closedFloatingPointRangeRangeTo = RangesKt.rangeTo(0.0f, 1.0f);
                    }
                    if (i7 != 0) {
                        i8 = 0;
                    }
                    if (i10 != 0) {
                        function1 = null;
                    } else {
                        function1 = function0;
                    }
                    if ((i3 & 128) != 0) {
                        i4 &= -29360129;
                        sliderColorsM1150colorsq0g_0yA = SliderDefaults.INSTANCE.m1150colorsq0g_0yA(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 0, 6, 1023);
                    } else {
                        sliderColorsM1150colorsq0g_0yA = sliderColors;
                    }
                    z3 = z2;
                    closedFloatingPointRange2 = closedFloatingPointRangeRangeTo;
                    i12 = i8;
                    i13 = i4;
                } else {
                    if (i15 != 0) {
                        companion = Modifier.INSTANCE;
                    } else {
                        companion = modifier2;
                    }
                    if (i5 != 0) {
                        z2 = true;
                    }
                    if ((i3 & 16) != 0) {
                        i4 &= -57345;
                        closedFloatingPointRangeRangeTo = RangesKt.rangeTo(0.0f, 1.0f);
                    }
                    if (i7 != 0) {
                        i8 = 0;
                    }
                    if (i10 != 0) {
                        function1 = null;
                    } else {
                        function1 = function0;
                    }
                    if ((i3 & 128) != 0) {
                        i4 &= -29360129;
                        sliderColorsM1150colorsq0g_0yA = SliderDefaults.INSTANCE.m1150colorsq0g_0yA(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 0, 6, 1023);
                    } else {
                        sliderColorsM1150colorsq0g_0yA = sliderColors;
                    }
                    z3 = z2;
                    closedFloatingPointRange2 = closedFloatingPointRangeRangeTo;
                    i12 = i8;
                    i13 = i4;
                }
                composerStartRestartGroup.endDefaults();
                composerStartRestartGroup.startReplaceableGroup(-492369756);
                ComposerKt.sourceInformation(composerStartRestartGroup, "C(remember):Composables.kt#9igjgp");
                objRememberedValue = composerStartRestartGroup.rememberedValue();
                if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                }
                composerStartRestartGroup.endReplaceableGroup();
                mutableInteractionSource = (MutableInteractionSource) objRememberedValue;
                composerStartRestartGroup.startReplaceableGroup(-492369756);
                ComposerKt.sourceInformation(composerStartRestartGroup, "C(remember):Composables.kt#9igjgp");
                objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                if (objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue2 = InteractionSourceKt.MutableInteractionSource();
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                }
                composerStartRestartGroup.endReplaceableGroup();
                mutableInteractionSource2 = (MutableInteractionSource) objRememberedValue2;
                if (i12 < 0) {
                    throw new IllegalArgumentException("steps should be >= 0".toString());
                }
                State stateRememberUpdatedState11 = SnapshotStateKt.rememberUpdatedState(onValueChange, composerStartRestartGroup, (i13 >> 3) & 14);
                Integer numValueOf11 = Integer.valueOf(i12);
                composerStartRestartGroup.startReplaceableGroup(1157296644);
                ComposerKt.sourceInformation(composerStartRestartGroup, "C(remember)P(1):Composables.kt#9igjgp");
                zChanged = composerStartRestartGroup.changed(numValueOf11);
                objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                if (!zChanged) {
                    objRememberedValue3 = stepsToTickFractions(i12);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                } else {
                    objRememberedValue3 = stepsToTickFractions(i12);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                }
                composerStartRestartGroup.endReplaceableGroup();
                Modifier modifierMinimumTouchTargetSize11 = TouchTargetKt.minimumTouchTargetSize(companion);
                float f11 = ThumbRadius;
                composer2 = composerStartRestartGroup;
                BoxWithConstraintsKt.BoxWithConstraints(SizeKt.m460requiredSizeInqDBjuR0$default(modifierMinimumTouchTargetSize11, Dp.m3843constructorimpl(4 * f11), Dp.m3843constructorimpl(f11 * 2), 0.0f, 0.0f, 12, null), null, false, ComposableLambdaKt.composableLambda(composer2, 652589923, true, new C10642(closedFloatingPointRange2, values, i13, stateRememberUpdatedState11, mutableInteractionSource, mutableInteractionSource2, z3, (List) objRememberedValue3, i12, sliderColorsM1150colorsq0g_0yA, function1)), composer2, 3072, 6);
                modifier3 = companion;
                z4 = z3;
                closedFloatingPointRange3 = closedFloatingPointRange2;
                i14 = i12;
                function2 = function1;
                sliderColors2 = sliderColorsM1150colorsq0g_0yA;
            }
            scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup == null) {
                return;
            }
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.SliderKt.RangeSlider.3
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Composer composer3, Integer num) {
                    invoke(composer3, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(Composer composer3, int i17) {
                    SliderKt.RangeSlider(values, onValueChange, modifier3, z4, closedFloatingPointRange3, i14, function2, sliderColors2, composer3, i2 | 1, i3);
                }
            });
        }
        i4 |= 3072;
        z2 = z;
        if ((57344 & i2) == 0) {
            if ((i3 & 16) == 0) {
                closedFloatingPointRangeRangeTo = closedFloatingPointRange;
                if (composerStartRestartGroup.changed(closedFloatingPointRangeRangeTo)) {
                }
                i4 |= i16;
            } else {
                closedFloatingPointRangeRangeTo = closedFloatingPointRange;
            }
            i4 |= i16;
        } else {
            closedFloatingPointRangeRangeTo = closedFloatingPointRange;
        }
        i7 = i3 & 32;
        if (i7 != 0) {
            if ((458752 & i2) == 0) {
                i8 = i;
                if (composerStartRestartGroup.changed(i8)) {
                    i9 = 131072;
                } else {
                    i9 = 65536;
                }
                i4 |= i9;
            }
            i10 = i3 & 64;
            if (i10 != 0) {
                i4 |= 1572864;
            } else if ((i2 & 3670016) == 0) {
                if (composerStartRestartGroup.changed(function0)) {
                    i11 = 1048576;
                } else {
                    i11 = 524288;
                }
                i4 |= i11;
            }
            if ((i2 & 29360128) != 0) {
                i4 |= ((i3 & 128) == 0 || !composerStartRestartGroup.changed(sliderColors)) ? 4194304 : 8388608;
            }
            if ((i4 & 23967451) == 4793490) {
                composerStartRestartGroup.startDefaults();
                if ((i2 & 1) != 0) {
                    if (i15 != 0) {
                        companion = Modifier.INSTANCE;
                    } else {
                        companion = modifier2;
                    }
                    if (i5 != 0) {
                        z2 = true;
                    }
                    if ((i3 & 16) != 0) {
                        i4 &= -57345;
                        closedFloatingPointRangeRangeTo = RangesKt.rangeTo(0.0f, 1.0f);
                    }
                    if (i7 != 0) {
                        i8 = 0;
                    }
                    if (i10 != 0) {
                        function1 = null;
                    } else {
                        function1 = function0;
                    }
                    if ((i3 & 128) != 0) {
                        i4 &= -29360129;
                        sliderColorsM1150colorsq0g_0yA = SliderDefaults.INSTANCE.m1150colorsq0g_0yA(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 0, 6, 1023);
                    } else {
                        sliderColorsM1150colorsq0g_0yA = sliderColors;
                    }
                    z3 = z2;
                    closedFloatingPointRange2 = closedFloatingPointRangeRangeTo;
                    i12 = i8;
                    i13 = i4;
                } else {
                    if (i15 != 0) {
                        companion = Modifier.INSTANCE;
                    } else {
                        companion = modifier2;
                    }
                    if (i5 != 0) {
                        z2 = true;
                    }
                    if ((i3 & 16) != 0) {
                        i4 &= -57345;
                        closedFloatingPointRangeRangeTo = RangesKt.rangeTo(0.0f, 1.0f);
                    }
                    if (i7 != 0) {
                        i8 = 0;
                    }
                    if (i10 != 0) {
                        function1 = null;
                    } else {
                        function1 = function0;
                    }
                    if ((i3 & 128) != 0) {
                        i4 &= -29360129;
                        sliderColorsM1150colorsq0g_0yA = SliderDefaults.INSTANCE.m1150colorsq0g_0yA(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 0, 6, 1023);
                    } else {
                        sliderColorsM1150colorsq0g_0yA = sliderColors;
                    }
                    z3 = z2;
                    closedFloatingPointRange2 = closedFloatingPointRangeRangeTo;
                    i12 = i8;
                    i13 = i4;
                }
                composerStartRestartGroup.endDefaults();
                composerStartRestartGroup.startReplaceableGroup(-492369756);
                ComposerKt.sourceInformation(composerStartRestartGroup, "C(remember):Composables.kt#9igjgp");
                objRememberedValue = composerStartRestartGroup.rememberedValue();
                if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                }
                composerStartRestartGroup.endReplaceableGroup();
                mutableInteractionSource = (MutableInteractionSource) objRememberedValue;
                composerStartRestartGroup.startReplaceableGroup(-492369756);
                ComposerKt.sourceInformation(composerStartRestartGroup, "C(remember):Composables.kt#9igjgp");
                objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                if (objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue2 = InteractionSourceKt.MutableInteractionSource();
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                }
                composerStartRestartGroup.endReplaceableGroup();
                mutableInteractionSource2 = (MutableInteractionSource) objRememberedValue2;
                if (i12 < 0) {
                    throw new IllegalArgumentException("steps should be >= 0".toString());
                }
                State stateRememberUpdatedState12 = SnapshotStateKt.rememberUpdatedState(onValueChange, composerStartRestartGroup, (i13 >> 3) & 14);
                Integer numValueOf12 = Integer.valueOf(i12);
                composerStartRestartGroup.startReplaceableGroup(1157296644);
                ComposerKt.sourceInformation(composerStartRestartGroup, "C(remember)P(1):Composables.kt#9igjgp");
                zChanged = composerStartRestartGroup.changed(numValueOf12);
                objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                if (!zChanged) {
                    objRememberedValue3 = stepsToTickFractions(i12);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                } else {
                    objRememberedValue3 = stepsToTickFractions(i12);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                }
                composerStartRestartGroup.endReplaceableGroup();
                Modifier modifierMinimumTouchTargetSize12 = TouchTargetKt.minimumTouchTargetSize(companion);
                float f12 = ThumbRadius;
                composer2 = composerStartRestartGroup;
                BoxWithConstraintsKt.BoxWithConstraints(SizeKt.m460requiredSizeInqDBjuR0$default(modifierMinimumTouchTargetSize12, Dp.m3843constructorimpl(4 * f12), Dp.m3843constructorimpl(f12 * 2), 0.0f, 0.0f, 12, null), null, false, ComposableLambdaKt.composableLambda(composer2, 652589923, true, new C10642(closedFloatingPointRange2, values, i13, stateRememberUpdatedState12, mutableInteractionSource, mutableInteractionSource2, z3, (List) objRememberedValue3, i12, sliderColorsM1150colorsq0g_0yA, function1)), composer2, 3072, 6);
                modifier3 = companion;
                z4 = z3;
                closedFloatingPointRange3 = closedFloatingPointRange2;
                i14 = i12;
                function2 = function1;
                sliderColors2 = sliderColorsM1150colorsq0g_0yA;
            } else {
                composerStartRestartGroup.startDefaults();
                if ((i2 & 1) != 0) {
                    if (i15 != 0) {
                        companion = Modifier.INSTANCE;
                    } else {
                        companion = modifier2;
                    }
                    if (i5 != 0) {
                        z2 = true;
                    }
                    if ((i3 & 16) != 0) {
                        i4 &= -57345;
                        closedFloatingPointRangeRangeTo = RangesKt.rangeTo(0.0f, 1.0f);
                    }
                    if (i7 != 0) {
                        i8 = 0;
                    }
                    if (i10 != 0) {
                        function1 = null;
                    } else {
                        function1 = function0;
                    }
                    if ((i3 & 128) != 0) {
                        i4 &= -29360129;
                        sliderColorsM1150colorsq0g_0yA = SliderDefaults.INSTANCE.m1150colorsq0g_0yA(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 0, 6, 1023);
                    } else {
                        sliderColorsM1150colorsq0g_0yA = sliderColors;
                    }
                    z3 = z2;
                    closedFloatingPointRange2 = closedFloatingPointRangeRangeTo;
                    i12 = i8;
                    i13 = i4;
                } else {
                    if (i15 != 0) {
                        companion = Modifier.INSTANCE;
                    } else {
                        companion = modifier2;
                    }
                    if (i5 != 0) {
                        z2 = true;
                    }
                    if ((i3 & 16) != 0) {
                        i4 &= -57345;
                        closedFloatingPointRangeRangeTo = RangesKt.rangeTo(0.0f, 1.0f);
                    }
                    if (i7 != 0) {
                        i8 = 0;
                    }
                    if (i10 != 0) {
                        function1 = null;
                    } else {
                        function1 = function0;
                    }
                    if ((i3 & 128) != 0) {
                        i4 &= -29360129;
                        sliderColorsM1150colorsq0g_0yA = SliderDefaults.INSTANCE.m1150colorsq0g_0yA(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 0, 6, 1023);
                    } else {
                        sliderColorsM1150colorsq0g_0yA = sliderColors;
                    }
                    z3 = z2;
                    closedFloatingPointRange2 = closedFloatingPointRangeRangeTo;
                    i12 = i8;
                    i13 = i4;
                }
                composerStartRestartGroup.endDefaults();
                composerStartRestartGroup.startReplaceableGroup(-492369756);
                ComposerKt.sourceInformation(composerStartRestartGroup, "C(remember):Composables.kt#9igjgp");
                objRememberedValue = composerStartRestartGroup.rememberedValue();
                if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                }
                composerStartRestartGroup.endReplaceableGroup();
                mutableInteractionSource = (MutableInteractionSource) objRememberedValue;
                composerStartRestartGroup.startReplaceableGroup(-492369756);
                ComposerKt.sourceInformation(composerStartRestartGroup, "C(remember):Composables.kt#9igjgp");
                objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                if (objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue2 = InteractionSourceKt.MutableInteractionSource();
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                }
                composerStartRestartGroup.endReplaceableGroup();
                mutableInteractionSource2 = (MutableInteractionSource) objRememberedValue2;
                if (i12 < 0) {
                    throw new IllegalArgumentException("steps should be >= 0".toString());
                }
                State stateRememberUpdatedState13 = SnapshotStateKt.rememberUpdatedState(onValueChange, composerStartRestartGroup, (i13 >> 3) & 14);
                Integer numValueOf13 = Integer.valueOf(i12);
                composerStartRestartGroup.startReplaceableGroup(1157296644);
                ComposerKt.sourceInformation(composerStartRestartGroup, "C(remember)P(1):Composables.kt#9igjgp");
                zChanged = composerStartRestartGroup.changed(numValueOf13);
                objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                if (!zChanged) {
                    objRememberedValue3 = stepsToTickFractions(i12);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                } else {
                    objRememberedValue3 = stepsToTickFractions(i12);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                }
                composerStartRestartGroup.endReplaceableGroup();
                Modifier modifierMinimumTouchTargetSize13 = TouchTargetKt.minimumTouchTargetSize(companion);
                float f13 = ThumbRadius;
                composer2 = composerStartRestartGroup;
                BoxWithConstraintsKt.BoxWithConstraints(SizeKt.m460requiredSizeInqDBjuR0$default(modifierMinimumTouchTargetSize13, Dp.m3843constructorimpl(4 * f13), Dp.m3843constructorimpl(f13 * 2), 0.0f, 0.0f, 12, null), null, false, ComposableLambdaKt.composableLambda(composer2, 652589923, true, new C10642(closedFloatingPointRange2, values, i13, stateRememberUpdatedState13, mutableInteractionSource, mutableInteractionSource2, z3, (List) objRememberedValue3, i12, sliderColorsM1150colorsq0g_0yA, function1)), composer2, 3072, 6);
                modifier3 = companion;
                z4 = z3;
                closedFloatingPointRange3 = closedFloatingPointRange2;
                i14 = i12;
                function2 = function1;
                sliderColors2 = sliderColorsM1150colorsq0g_0yA;
            }
            scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup == null) {
                return;
            }
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.SliderKt.RangeSlider.3
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Composer composer3, Integer num) {
                    invoke(composer3, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(Composer composer3, int i17) {
                    SliderKt.RangeSlider(values, onValueChange, modifier3, z4, closedFloatingPointRange3, i14, function2, sliderColors2, composer3, i2 | 1, i3);
                }
            });
        }
        i4 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
        i8 = i;
        i10 = i3 & 64;
        if (i10 != 0) {
            i4 |= 1572864;
        } else if ((i2 & 3670016) == 0) {
            if (composerStartRestartGroup.changed(function0)) {
                i11 = 1048576;
            } else {
                i11 = 524288;
            }
            i4 |= i11;
        }
        if ((i2 & 29360128) != 0) {
            i4 |= ((i3 & 128) == 0 || !composerStartRestartGroup.changed(sliderColors)) ? 4194304 : 8388608;
        }
        if ((i4 & 23967451) == 4793490) {
            composerStartRestartGroup.startDefaults();
            if ((i2 & 1) != 0) {
                if (i15 != 0) {
                    companion = Modifier.INSTANCE;
                } else {
                    companion = modifier2;
                }
                if (i5 != 0) {
                    z2 = true;
                }
                if ((i3 & 16) != 0) {
                    i4 &= -57345;
                    closedFloatingPointRangeRangeTo = RangesKt.rangeTo(0.0f, 1.0f);
                }
                if (i7 != 0) {
                    i8 = 0;
                }
                if (i10 != 0) {
                    function1 = null;
                } else {
                    function1 = function0;
                }
                if ((i3 & 128) != 0) {
                    i4 &= -29360129;
                    sliderColorsM1150colorsq0g_0yA = SliderDefaults.INSTANCE.m1150colorsq0g_0yA(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 0, 6, 1023);
                } else {
                    sliderColorsM1150colorsq0g_0yA = sliderColors;
                }
                z3 = z2;
                closedFloatingPointRange2 = closedFloatingPointRangeRangeTo;
                i12 = i8;
                i13 = i4;
            } else {
                if (i15 != 0) {
                    companion = Modifier.INSTANCE;
                } else {
                    companion = modifier2;
                }
                if (i5 != 0) {
                    z2 = true;
                }
                if ((i3 & 16) != 0) {
                    i4 &= -57345;
                    closedFloatingPointRangeRangeTo = RangesKt.rangeTo(0.0f, 1.0f);
                }
                if (i7 != 0) {
                    i8 = 0;
                }
                if (i10 != 0) {
                    function1 = null;
                } else {
                    function1 = function0;
                }
                if ((i3 & 128) != 0) {
                    i4 &= -29360129;
                    sliderColorsM1150colorsq0g_0yA = SliderDefaults.INSTANCE.m1150colorsq0g_0yA(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 0, 6, 1023);
                } else {
                    sliderColorsM1150colorsq0g_0yA = sliderColors;
                }
                z3 = z2;
                closedFloatingPointRange2 = closedFloatingPointRangeRangeTo;
                i12 = i8;
                i13 = i4;
            }
            composerStartRestartGroup.endDefaults();
            composerStartRestartGroup.startReplaceableGroup(-492369756);
            ComposerKt.sourceInformation(composerStartRestartGroup, "C(remember):Composables.kt#9igjgp");
            objRememberedValue = composerStartRestartGroup.rememberedValue();
            if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
            }
            composerStartRestartGroup.endReplaceableGroup();
            mutableInteractionSource = (MutableInteractionSource) objRememberedValue;
            composerStartRestartGroup.startReplaceableGroup(-492369756);
            ComposerKt.sourceInformation(composerStartRestartGroup, "C(remember):Composables.kt#9igjgp");
            objRememberedValue2 = composerStartRestartGroup.rememberedValue();
            if (objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                objRememberedValue2 = InteractionSourceKt.MutableInteractionSource();
                composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
            }
            composerStartRestartGroup.endReplaceableGroup();
            mutableInteractionSource2 = (MutableInteractionSource) objRememberedValue2;
            if (i12 < 0) {
                throw new IllegalArgumentException("steps should be >= 0".toString());
            }
            State stateRememberUpdatedState14 = SnapshotStateKt.rememberUpdatedState(onValueChange, composerStartRestartGroup, (i13 >> 3) & 14);
            Integer numValueOf14 = Integer.valueOf(i12);
            composerStartRestartGroup.startReplaceableGroup(1157296644);
            ComposerKt.sourceInformation(composerStartRestartGroup, "C(remember)P(1):Composables.kt#9igjgp");
            zChanged = composerStartRestartGroup.changed(numValueOf14);
            objRememberedValue3 = composerStartRestartGroup.rememberedValue();
            if (!zChanged) {
                objRememberedValue3 = stepsToTickFractions(i12);
                composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
            } else {
                objRememberedValue3 = stepsToTickFractions(i12);
                composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
            }
            composerStartRestartGroup.endReplaceableGroup();
            Modifier modifierMinimumTouchTargetSize14 = TouchTargetKt.minimumTouchTargetSize(companion);
            float f14 = ThumbRadius;
            composer2 = composerStartRestartGroup;
            BoxWithConstraintsKt.BoxWithConstraints(SizeKt.m460requiredSizeInqDBjuR0$default(modifierMinimumTouchTargetSize14, Dp.m3843constructorimpl(4 * f14), Dp.m3843constructorimpl(f14 * 2), 0.0f, 0.0f, 12, null), null, false, ComposableLambdaKt.composableLambda(composer2, 652589923, true, new C10642(closedFloatingPointRange2, values, i13, stateRememberUpdatedState14, mutableInteractionSource, mutableInteractionSource2, z3, (List) objRememberedValue3, i12, sliderColorsM1150colorsq0g_0yA, function1)), composer2, 3072, 6);
            modifier3 = companion;
            z4 = z3;
            closedFloatingPointRange3 = closedFloatingPointRange2;
            i14 = i12;
            function2 = function1;
            sliderColors2 = sliderColorsM1150colorsq0g_0yA;
        } else {
            composerStartRestartGroup.startDefaults();
            if ((i2 & 1) != 0) {
                if (i15 != 0) {
                    companion = Modifier.INSTANCE;
                } else {
                    companion = modifier2;
                }
                if (i5 != 0) {
                    z2 = true;
                }
                if ((i3 & 16) != 0) {
                    i4 &= -57345;
                    closedFloatingPointRangeRangeTo = RangesKt.rangeTo(0.0f, 1.0f);
                }
                if (i7 != 0) {
                    i8 = 0;
                }
                if (i10 != 0) {
                    function1 = null;
                } else {
                    function1 = function0;
                }
                if ((i3 & 128) != 0) {
                    i4 &= -29360129;
                    sliderColorsM1150colorsq0g_0yA = SliderDefaults.INSTANCE.m1150colorsq0g_0yA(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 0, 6, 1023);
                } else {
                    sliderColorsM1150colorsq0g_0yA = sliderColors;
                }
                z3 = z2;
                closedFloatingPointRange2 = closedFloatingPointRangeRangeTo;
                i12 = i8;
                i13 = i4;
            } else {
                if (i15 != 0) {
                    companion = Modifier.INSTANCE;
                } else {
                    companion = modifier2;
                }
                if (i5 != 0) {
                    z2 = true;
                }
                if ((i3 & 16) != 0) {
                    i4 &= -57345;
                    closedFloatingPointRangeRangeTo = RangesKt.rangeTo(0.0f, 1.0f);
                }
                if (i7 != 0) {
                    i8 = 0;
                }
                if (i10 != 0) {
                    function1 = null;
                } else {
                    function1 = function0;
                }
                if ((i3 & 128) != 0) {
                    i4 &= -29360129;
                    sliderColorsM1150colorsq0g_0yA = SliderDefaults.INSTANCE.m1150colorsq0g_0yA(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 0, 6, 1023);
                } else {
                    sliderColorsM1150colorsq0g_0yA = sliderColors;
                }
                z3 = z2;
                closedFloatingPointRange2 = closedFloatingPointRangeRangeTo;
                i12 = i8;
                i13 = i4;
            }
            composerStartRestartGroup.endDefaults();
            composerStartRestartGroup.startReplaceableGroup(-492369756);
            ComposerKt.sourceInformation(composerStartRestartGroup, "C(remember):Composables.kt#9igjgp");
            objRememberedValue = composerStartRestartGroup.rememberedValue();
            if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
            }
            composerStartRestartGroup.endReplaceableGroup();
            mutableInteractionSource = (MutableInteractionSource) objRememberedValue;
            composerStartRestartGroup.startReplaceableGroup(-492369756);
            ComposerKt.sourceInformation(composerStartRestartGroup, "C(remember):Composables.kt#9igjgp");
            objRememberedValue2 = composerStartRestartGroup.rememberedValue();
            if (objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                objRememberedValue2 = InteractionSourceKt.MutableInteractionSource();
                composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
            }
            composerStartRestartGroup.endReplaceableGroup();
            mutableInteractionSource2 = (MutableInteractionSource) objRememberedValue2;
            if (i12 < 0) {
                throw new IllegalArgumentException("steps should be >= 0".toString());
            }
            State stateRememberUpdatedState15 = SnapshotStateKt.rememberUpdatedState(onValueChange, composerStartRestartGroup, (i13 >> 3) & 14);
            Integer numValueOf15 = Integer.valueOf(i12);
            composerStartRestartGroup.startReplaceableGroup(1157296644);
            ComposerKt.sourceInformation(composerStartRestartGroup, "C(remember)P(1):Composables.kt#9igjgp");
            zChanged = composerStartRestartGroup.changed(numValueOf15);
            objRememberedValue3 = composerStartRestartGroup.rememberedValue();
            if (!zChanged) {
                objRememberedValue3 = stepsToTickFractions(i12);
                composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
            } else {
                objRememberedValue3 = stepsToTickFractions(i12);
                composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
            }
            composerStartRestartGroup.endReplaceableGroup();
            Modifier modifierMinimumTouchTargetSize15 = TouchTargetKt.minimumTouchTargetSize(companion);
            float f15 = ThumbRadius;
            composer2 = composerStartRestartGroup;
            BoxWithConstraintsKt.BoxWithConstraints(SizeKt.m460requiredSizeInqDBjuR0$default(modifierMinimumTouchTargetSize15, Dp.m3843constructorimpl(4 * f15), Dp.m3843constructorimpl(f15 * 2), 0.0f, 0.0f, 12, null), null, false, ComposableLambdaKt.composableLambda(composer2, 652589923, true, new C10642(closedFloatingPointRange2, values, i13, stateRememberUpdatedState15, mutableInteractionSource, mutableInteractionSource2, z3, (List) objRememberedValue3, i12, sliderColorsM1150colorsq0g_0yA, function1)), composer2, 3072, 6);
            modifier3 = companion;
            z4 = z3;
            closedFloatingPointRange3 = closedFloatingPointRange2;
            i14 = i12;
            function2 = function1;
            sliderColors2 = sliderColorsM1150colorsq0g_0yA;
        }
        scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup == null) {
            return;
        }
        scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.SliderKt.RangeSlider.3
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Unit invoke(Composer composer3, Integer num) {
                invoke(composer3, num.intValue());
                return Unit.INSTANCE;
            }

            public final void invoke(Composer composer3, int i17) {
                SliderKt.RangeSlider(values, onValueChange, modifier3, z4, closedFloatingPointRange3, i14, function2, sliderColors2, composer3, i2 | 1, i3);
            }
        });
    }

    /* JADX INFO: renamed from: androidx.compose.material.SliderKt$RangeSlider$2, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: Slider.kt */
    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    static final class C10642 extends Lambda implements Function3<BoxWithConstraintsScope, Composer, Integer, Unit> {
        final /* synthetic */ int $$dirty;
        final /* synthetic */ SliderColors $colors;
        final /* synthetic */ boolean $enabled;
        final /* synthetic */ MutableInteractionSource $endInteractionSource;
        final /* synthetic */ Function0<Unit> $onValueChangeFinished;
        final /* synthetic */ State<Function1<ClosedFloatingPointRange<Float>, Unit>> $onValueChangeState;
        final /* synthetic */ MutableInteractionSource $startInteractionSource;
        final /* synthetic */ int $steps;
        final /* synthetic */ List<Float> $tickFractions;
        final /* synthetic */ ClosedFloatingPointRange<Float> $valueRange;
        final /* synthetic */ ClosedFloatingPointRange<Float> $values;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        C10642(ClosedFloatingPointRange<Float> closedFloatingPointRange, ClosedFloatingPointRange<Float> closedFloatingPointRange2, int i, State<? extends Function1<? super ClosedFloatingPointRange<Float>, Unit>> state, MutableInteractionSource mutableInteractionSource, MutableInteractionSource mutableInteractionSource2, boolean z, List<Float> list, int i2, SliderColors sliderColors, Function0<Unit> function0) {
            super(3);
            this.$valueRange = closedFloatingPointRange;
            this.$values = closedFloatingPointRange2;
            this.$$dirty = i;
            this.$onValueChangeState = state;
            this.$startInteractionSource = mutableInteractionSource;
            this.$endInteractionSource = mutableInteractionSource2;
            this.$enabled = z;
            this.$tickFractions = list;
            this.$steps = i2;
            this.$colors = sliderColors;
            this.$onValueChangeFinished = function0;
        }

        @Override // kotlin.jvm.functions.Function3
        public /* bridge */ /* synthetic */ Unit invoke(BoxWithConstraintsScope boxWithConstraintsScope, Composer composer, Integer num) {
            invoke(boxWithConstraintsScope, composer, num.intValue());
            return Unit.INSTANCE;
        }

        public final void invoke(BoxWithConstraintsScope BoxWithConstraints, Composer composer, int i) {
            Intrinsics.checkNotNullParameter(BoxWithConstraints, "$this$BoxWithConstraints");
            ComposerKt.sourceInformation(composer, "C306@13913L7,*311@14074L7,322@14502L56,323@14586L63,325@14659L165,332@14833L170,340@15025L24,341@15081L944,365@16095L809,365@16048L856,405@17826L63,413@18103L65,418@18258L340:Slider.kt#jmzs0o");
            if ((((i & 14) == 0 ? i | (composer.changed(BoxWithConstraints) ? 4 : 2) : i) & 91) != 18 || !composer.getSkipping()) {
                ProvidableCompositionLocal<LayoutDirection> localLayoutDirection = CompositionLocalsKt.getLocalLayoutDirection();
                ComposerKt.sourceInformationMarkerStart(composer, 2023513938, "C:CompositionLocal.kt#9igjgp");
                Object objConsume = composer.consume(localLayoutDirection);
                ComposerKt.sourceInformationMarkerEnd(composer);
                boolean z = objConsume == LayoutDirection.Rtl;
                float fM3799getMaxWidthimpl = Constraints.m3799getMaxWidthimpl(BoxWithConstraints.getConstraints());
                final Ref.FloatRef floatRef = new Ref.FloatRef();
                final Ref.FloatRef floatRef2 = new Ref.FloatRef();
                ProvidableCompositionLocal<Density> localDensity = CompositionLocalsKt.getLocalDensity();
                ComposerKt.sourceInformationMarkerStart(composer, 2023513938, "C:CompositionLocal.kt#9igjgp");
                Object objConsume2 = composer.consume(localDensity);
                ComposerKt.sourceInformationMarkerEnd(composer);
                Density density = (Density) objConsume2;
                floatRef.element = fM3799getMaxWidthimpl - density.mo318toPx0680j_4(SliderKt.getThumbRadius());
                floatRef2.element = density.mo318toPx0680j_4(SliderKt.getThumbRadius());
                Unit unit = Unit.INSTANCE;
                ClosedFloatingPointRange<Float> closedFloatingPointRange = this.$values;
                ClosedFloatingPointRange<Float> closedFloatingPointRange2 = this.$valueRange;
                composer.startReplaceableGroup(-492369756);
                ComposerKt.sourceInformation(composer, "C(remember):Composables.kt#9igjgp");
                Object objRememberedValue = composer.rememberedValue();
                if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(Float.valueOf(invoke$scaleToOffset(closedFloatingPointRange2, floatRef2, floatRef, closedFloatingPointRange.getStart().floatValue())), null, 2, null);
                    composer.updateRememberedValue(objRememberedValue);
                }
                composer.endReplaceableGroup();
                final MutableState mutableState = (MutableState) objRememberedValue;
                ClosedFloatingPointRange<Float> closedFloatingPointRange3 = this.$values;
                ClosedFloatingPointRange<Float> closedFloatingPointRange4 = this.$valueRange;
                composer.startReplaceableGroup(-492369756);
                ComposerKt.sourceInformation(composer, "C(remember):Composables.kt#9igjgp");
                Object objRememberedValue2 = composer.rememberedValue();
                if (objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue2 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(Float.valueOf(invoke$scaleToOffset(closedFloatingPointRange4, floatRef2, floatRef, closedFloatingPointRange3.getEndInclusive().floatValue())), null, 2, null);
                    composer.updateRememberedValue(objRememberedValue2);
                }
                composer.endReplaceableGroup();
                final MutableState mutableState2 = (MutableState) objRememberedValue2;
                SliderKt.CorrectValueSideEffect(new C00762(this.$valueRange, floatRef2, floatRef), this.$valueRange, RangesKt.rangeTo(floatRef2.element, floatRef.element), mutableState, this.$values.getStart().floatValue(), composer, ((this.$$dirty >> 9) & 112) | 3072);
                SliderKt.CorrectValueSideEffect(new AnonymousClass3(this.$valueRange, floatRef2, floatRef), this.$valueRange, RangesKt.rangeTo(floatRef2.element, floatRef.element), mutableState2, this.$values.getEndInclusive().floatValue(), composer, ((this.$$dirty >> 9) & 112) | 3072);
                composer.startReplaceableGroup(773894976);
                ComposerKt.sourceInformation(composer, "C(rememberCoroutineScope)475@19849L144:Effects.kt#9igjgp");
                composer.startReplaceableGroup(-492369756);
                ComposerKt.sourceInformation(composer, "C(remember):Composables.kt#9igjgp");
                Object objRememberedValue3 = composer.rememberedValue();
                if (objRememberedValue3 == Composer.INSTANCE.getEmpty()) {
                    CompositionScopedCoroutineScopeCanceller compositionScopedCoroutineScopeCanceller = new CompositionScopedCoroutineScopeCanceller(EffectsKt.createCompositionCoroutineScope(EmptyCoroutineContext.INSTANCE, composer));
                    composer.updateRememberedValue(compositionScopedCoroutineScopeCanceller);
                    objRememberedValue3 = compositionScopedCoroutineScopeCanceller;
                }
                composer.endReplaceableGroup();
                final CoroutineScope coroutineScope = ((CompositionScopedCoroutineScopeCanceller) objRememberedValue3).getCoroutineScope();
                composer.endReplaceableGroup();
                final List<Float> list = this.$tickFractions;
                final Function0<Unit> function0 = this.$onValueChangeFinished;
                final State<Function1<ClosedFloatingPointRange<Float>, Unit>> state = this.$onValueChangeState;
                final ClosedFloatingPointRange<Float> closedFloatingPointRange5 = this.$valueRange;
                State stateRememberUpdatedState = SnapshotStateKt.rememberUpdatedState(new Function1<Boolean, Unit>() { // from class: androidx.compose.material.SliderKt$RangeSlider$2$gestureEndAction$1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    /* JADX WARN: Multi-variable type inference failed */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
                        invoke(bool.booleanValue());
                        return Unit.INSTANCE;
                    }

                    public final void invoke(boolean z2) {
                        float fFloatValue = (z2 ? mutableState : mutableState2).getValue().floatValue();
                        float fSnapValueToTick = SliderKt.snapValueToTick(fFloatValue, list, floatRef2.element, floatRef.element);
                        if (fFloatValue != fSnapValueToTick) {
                            BuildersKt__Builders_commonKt.launch$default(coroutineScope, null, null, new AnonymousClass1(fFloatValue, fSnapValueToTick, function0, z2, mutableState, mutableState2, state, floatRef2, floatRef, closedFloatingPointRange5, null), 3, null);
                            return;
                        }
                        Function0<Unit> function1 = function0;
                        if (function1 != null) {
                            function1.invoke();
                        }
                    }

                    /* JADX INFO: renamed from: androidx.compose.material.SliderKt$RangeSlider$2$gestureEndAction$1$1, reason: invalid class name */
                    /* JADX INFO: compiled from: Slider.kt */
                    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
                    @DebugMetadata(c = "androidx.compose.material.SliderKt$RangeSlider$2$gestureEndAction$1$1", f = "Slider.kt", i = {}, l = {352}, m = "invokeSuspend", n = {}, s = {})
                    static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
                        final /* synthetic */ float $current;
                        final /* synthetic */ boolean $isStart;
                        final /* synthetic */ Ref.FloatRef $maxPx;
                        final /* synthetic */ Ref.FloatRef $minPx;
                        final /* synthetic */ Function0<Unit> $onValueChangeFinished;
                        final /* synthetic */ State<Function1<ClosedFloatingPointRange<Float>, Unit>> $onValueChangeState;
                        final /* synthetic */ MutableState<Float> $rawOffsetEnd;
                        final /* synthetic */ MutableState<Float> $rawOffsetStart;
                        final /* synthetic */ float $target;
                        final /* synthetic */ ClosedFloatingPointRange<Float> $valueRange;
                        int label;

                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        /* JADX WARN: Multi-variable type inference failed */
                        AnonymousClass1(float f, float f2, Function0<Unit> function0, boolean z, MutableState<Float> mutableState, MutableState<Float> mutableState2, State<? extends Function1<? super ClosedFloatingPointRange<Float>, Unit>> state, Ref.FloatRef floatRef, Ref.FloatRef floatRef2, ClosedFloatingPointRange<Float> closedFloatingPointRange, Continuation<? super AnonymousClass1> continuation) {
                            super(2, continuation);
                            this.$current = f;
                            this.$target = f2;
                            this.$onValueChangeFinished = function0;
                            this.$isStart = z;
                            this.$rawOffsetStart = mutableState;
                            this.$rawOffsetEnd = mutableState2;
                            this.$onValueChangeState = state;
                            this.$minPx = floatRef;
                            this.$maxPx = floatRef2;
                            this.$valueRange = closedFloatingPointRange;
                        }

                        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                            return new AnonymousClass1(this.$current, this.$target, this.$onValueChangeFinished, this.$isStart, this.$rawOffsetStart, this.$rawOffsetEnd, this.$onValueChangeState, this.$minPx, this.$maxPx, this.$valueRange, continuation);
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
                                Animatable animatableAnimatable$default = AnimatableKt.Animatable$default(this.$current, 0.0f, 2, null);
                                Float fBoxFloat = Boxing.boxFloat(this.$target);
                                TweenSpec tweenSpec = SliderKt.SliderToTickAnimation;
                                Float fBoxFloat2 = Boxing.boxFloat(0.0f);
                                final boolean z = this.$isStart;
                                final MutableState<Float> mutableState = this.$rawOffsetStart;
                                final MutableState<Float> mutableState2 = this.$rawOffsetEnd;
                                final State<Function1<ClosedFloatingPointRange<Float>, Unit>> state = this.$onValueChangeState;
                                final Ref.FloatRef floatRef = this.$minPx;
                                final Ref.FloatRef floatRef2 = this.$maxPx;
                                final ClosedFloatingPointRange<Float> closedFloatingPointRange = this.$valueRange;
                                this.label = 1;
                                if (animatableAnimatable$default.animateTo(fBoxFloat, tweenSpec, fBoxFloat2, new Function1<Animatable<Float, AnimationVector1D>, Unit>() { // from class: androidx.compose.material.SliderKt.RangeSlider.2.gestureEndAction.1.1.1
                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                    /* JADX WARN: Multi-variable type inference failed */
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public /* bridge */ /* synthetic */ Unit invoke(Animatable<Float, AnimationVector1D> animatable) {
                                        invoke2(animatable);
                                        return Unit.INSTANCE;
                                    }

                                    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                                    public final void invoke2(Animatable<Float, AnimationVector1D> animateTo) {
                                        Intrinsics.checkNotNullParameter(animateTo, "$this$animateTo");
                                        (z ? mutableState : mutableState2).setValue(animateTo.getValue());
                                        state.getValue().invoke(SliderKt.C10642.invoke$scaleToUserValue(floatRef, floatRef2, closedFloatingPointRange, RangesKt.rangeTo(mutableState.getValue().floatValue(), mutableState2.getValue().floatValue())));
                                    }
                                }, this) == coroutine_suspended) {
                                    return coroutine_suspended;
                                }
                            } else {
                                if (i != 1) {
                                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                                }
                                ResultKt.throwOnFailure(obj);
                            }
                            Function0<Unit> function0 = this.$onValueChangeFinished;
                            if (function0 != null) {
                                function0.invoke();
                            }
                            return Unit.INSTANCE;
                        }
                    }
                }, composer, 0);
                ClosedFloatingPointRange<Float> closedFloatingPointRange6 = this.$valueRange;
                Float fValueOf = Float.valueOf(floatRef2.element);
                Float fValueOf2 = Float.valueOf(floatRef.element);
                final ClosedFloatingPointRange<Float> closedFloatingPointRange7 = this.$values;
                final State<Function1<ClosedFloatingPointRange<Float>, Unit>> state2 = this.$onValueChangeState;
                Object[] objArr = {mutableState, mutableState2, closedFloatingPointRange6, fValueOf, fValueOf2, closedFloatingPointRange7, state2};
                final ClosedFloatingPointRange<Float> closedFloatingPointRange8 = this.$valueRange;
                composer.startReplaceableGroup(-568225417);
                ComposerKt.sourceInformation(composer, "C(remember)P(1):Composables.kt#9igjgp");
                boolean zChanged = false;
                for (int i2 = 0; i2 < 7; i2++) {
                    zChanged |= composer.changed(objArr[i2]);
                }
                Object objRememberedValue4 = composer.rememberedValue();
                if (zChanged || objRememberedValue4 == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue4 = (Function2) new Function2<Boolean, Float, Unit>() { // from class: androidx.compose.material.SliderKt$RangeSlider$2$onDrag$1$1
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        /* JADX WARN: Multi-variable type inference failed */
                        {
                            super(2);
                        }

                        @Override // kotlin.jvm.functions.Function2
                        public /* bridge */ /* synthetic */ Unit invoke(Boolean bool, Float f) {
                            invoke(bool.booleanValue(), f.floatValue());
                            return Unit.INSTANCE;
                        }

                        public final void invoke(boolean z2, float f) {
                            ClosedFloatingPointRange<Float> closedFloatingPointRangeRangeTo;
                            if (z2) {
                                MutableState<Float> mutableState3 = mutableState;
                                mutableState3.setValue(Float.valueOf(mutableState3.getValue().floatValue() + f));
                                mutableState2.setValue(Float.valueOf(SliderKt.C10642.invoke$scaleToOffset(closedFloatingPointRange8, floatRef2, floatRef, closedFloatingPointRange7.getEndInclusive().floatValue())));
                                float fFloatValue = mutableState2.getValue().floatValue();
                                closedFloatingPointRangeRangeTo = RangesKt.rangeTo(RangesKt.coerceIn(mutableState.getValue().floatValue(), floatRef2.element, fFloatValue), fFloatValue);
                            } else {
                                MutableState<Float> mutableState4 = mutableState2;
                                mutableState4.setValue(Float.valueOf(mutableState4.getValue().floatValue() + f));
                                mutableState.setValue(Float.valueOf(SliderKt.C10642.invoke$scaleToOffset(closedFloatingPointRange8, floatRef2, floatRef, closedFloatingPointRange7.getStart().floatValue())));
                                float fFloatValue2 = mutableState.getValue().floatValue();
                                closedFloatingPointRangeRangeTo = RangesKt.rangeTo(fFloatValue2, RangesKt.coerceIn(mutableState2.getValue().floatValue(), fFloatValue2, floatRef.element));
                            }
                            state2.getValue().invoke(SliderKt.C10642.invoke$scaleToUserValue(floatRef2, floatRef, closedFloatingPointRange8, closedFloatingPointRangeRangeTo));
                        }
                    };
                    composer.updateRememberedValue(objRememberedValue4);
                }
                composer.endReplaceableGroup();
                Modifier modifierRangeSliderPressDragModifier = SliderKt.rangeSliderPressDragModifier(Modifier.INSTANCE, this.$startInteractionSource, this.$endInteractionSource, mutableState, mutableState2, this.$enabled, z, fM3799getMaxWidthimpl, this.$valueRange, stateRememberUpdatedState, SnapshotStateKt.rememberUpdatedState(objRememberedValue4, composer, 0));
                final float fCoerceIn = RangesKt.coerceIn(this.$values.getStart().floatValue(), this.$valueRange.getStart().floatValue(), this.$values.getEndInclusive().floatValue());
                final float fCoerceIn2 = RangesKt.coerceIn(this.$values.getEndInclusive().floatValue(), this.$values.getStart().floatValue(), this.$valueRange.getEndInclusive().floatValue());
                float fCalcFraction = SliderKt.calcFraction(this.$valueRange.getStart().floatValue(), this.$valueRange.getEndInclusive().floatValue(), fCoerceIn);
                float fCalcFraction2 = SliderKt.calcFraction(this.$valueRange.getStart().floatValue(), this.$valueRange.getEndInclusive().floatValue(), fCoerceIn2);
                Modifier.Companion companion = Modifier.INSTANCE;
                List<Float> list2 = this.$tickFractions;
                boolean z2 = this.$enabled;
                State<Function1<ClosedFloatingPointRange<Float>, Unit>> state3 = this.$onValueChangeState;
                Float fValueOf3 = Float.valueOf(fCoerceIn2);
                final State<Function1<ClosedFloatingPointRange<Float>, Unit>> state4 = this.$onValueChangeState;
                composer.startReplaceableGroup(511388516);
                ComposerKt.sourceInformation(composer, "C(remember)P(1,2):Composables.kt#9igjgp");
                boolean zChanged2 = composer.changed(state3) | composer.changed(fValueOf3);
                Object objRememberedValue5 = composer.rememberedValue();
                if (zChanged2 || objRememberedValue5 == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue5 = (Function1) new Function1<Float, Unit>() { // from class: androidx.compose.material.SliderKt$RangeSlider$2$startThumbSemantics$1$1
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        /* JADX WARN: Multi-variable type inference failed */
                        {
                            super(1);
                        }

                        @Override // kotlin.jvm.functions.Function1
                        public /* bridge */ /* synthetic */ Unit invoke(Float f) {
                            invoke(f.floatValue());
                            return Unit.INSTANCE;
                        }

                        public final void invoke(float f) {
                            state4.getValue().invoke(RangesKt.rangeTo(f, fCoerceIn2));
                        }
                    };
                    composer.updateRememberedValue(objRememberedValue5);
                }
                composer.endReplaceableGroup();
                Modifier modifierSliderSemantics = SliderKt.sliderSemantics(companion, fCoerceIn, list2, z2, (Function1) objRememberedValue5, RangesKt.rangeTo(this.$valueRange.getStart().floatValue(), fCoerceIn2), this.$steps);
                Modifier.Companion companion2 = Modifier.INSTANCE;
                List<Float> list3 = this.$tickFractions;
                boolean z3 = this.$enabled;
                State<Function1<ClosedFloatingPointRange<Float>, Unit>> state5 = this.$onValueChangeState;
                Float fValueOf4 = Float.valueOf(fCoerceIn);
                final State<Function1<ClosedFloatingPointRange<Float>, Unit>> state6 = this.$onValueChangeState;
                composer.startReplaceableGroup(511388516);
                ComposerKt.sourceInformation(composer, "C(remember)P(1,2):Composables.kt#9igjgp");
                boolean zChanged3 = composer.changed(state5) | composer.changed(fValueOf4);
                Object objRememberedValue6 = composer.rememberedValue();
                if (zChanged3 || objRememberedValue6 == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue6 = (Function1) new Function1<Float, Unit>() { // from class: androidx.compose.material.SliderKt$RangeSlider$2$endThumbSemantics$1$1
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        /* JADX WARN: Multi-variable type inference failed */
                        {
                            super(1);
                        }

                        @Override // kotlin.jvm.functions.Function1
                        public /* bridge */ /* synthetic */ Unit invoke(Float f) {
                            invoke(f.floatValue());
                            return Unit.INSTANCE;
                        }

                        public final void invoke(float f) {
                            state6.getValue().invoke(RangesKt.rangeTo(fCoerceIn, f));
                        }
                    };
                    composer.updateRememberedValue(objRememberedValue6);
                }
                composer.endReplaceableGroup();
                Modifier modifierSliderSemantics2 = SliderKt.sliderSemantics(companion2, fCoerceIn2, list3, z3, (Function1) objRememberedValue6, RangesKt.rangeTo(fCoerceIn, this.$valueRange.getEndInclusive().floatValue()), this.$steps);
                boolean z4 = this.$enabled;
                List<Float> list4 = this.$tickFractions;
                SliderColors sliderColors = this.$colors;
                float f = floatRef.element - floatRef2.element;
                MutableInteractionSource mutableInteractionSource = this.$startInteractionSource;
                MutableInteractionSource mutableInteractionSource2 = this.$endInteractionSource;
                int i3 = this.$$dirty;
                SliderKt.RangeSliderImpl(z4, fCalcFraction, fCalcFraction2, list4, sliderColors, f, mutableInteractionSource, mutableInteractionSource2, modifierRangeSliderPressDragModifier, modifierSliderSemantics, modifierSliderSemantics2, composer, ((i3 >> 9) & 14) | 14159872 | ((i3 >> 9) & 57344), 0);
                return;
            }
            composer.skipToGroupEnd();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final ClosedFloatingPointRange<Float> invoke$scaleToUserValue(Ref.FloatRef floatRef, Ref.FloatRef floatRef2, ClosedFloatingPointRange<Float> closedFloatingPointRange, ClosedFloatingPointRange<Float> closedFloatingPointRange2) {
            return SliderKt.scale(floatRef.element, floatRef2.element, closedFloatingPointRange2, closedFloatingPointRange.getStart().floatValue(), closedFloatingPointRange.getEndInclusive().floatValue());
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final float invoke$scaleToOffset(ClosedFloatingPointRange<Float> closedFloatingPointRange, Ref.FloatRef floatRef, Ref.FloatRef floatRef2, float f) {
            return SliderKt.scale(closedFloatingPointRange.getStart().floatValue(), closedFloatingPointRange.getEndInclusive().floatValue(), f, floatRef.element, floatRef2.element);
        }

        /* JADX INFO: renamed from: androidx.compose.material.SliderKt$RangeSlider$2$2, reason: invalid class name and collision with other inner class name */
        /* JADX INFO: compiled from: Slider.kt */
        @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
        /* synthetic */ class C00762 extends FunctionReferenceImpl implements Function1<Float, Float> {
            final /* synthetic */ Ref.FloatRef $maxPx;
            final /* synthetic */ Ref.FloatRef $minPx;
            final /* synthetic */ ClosedFloatingPointRange<Float> $valueRange;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            C00762(ClosedFloatingPointRange<Float> closedFloatingPointRange, Ref.FloatRef floatRef, Ref.FloatRef floatRef2) {
                super(1, Intrinsics.Kotlin.class, "scaleToOffset", "invoke$scaleToOffset(Lkotlin/ranges/ClosedFloatingPointRange;Lkotlin/jvm/internal/Ref$FloatRef;Lkotlin/jvm/internal/Ref$FloatRef;F)F", 0);
                this.$valueRange = closedFloatingPointRange;
                this.$minPx = floatRef;
                this.$maxPx = floatRef2;
            }

            public final Float invoke(float f) {
                return Float.valueOf(C10642.invoke$scaleToOffset(this.$valueRange, this.$minPx, this.$maxPx, f));
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Float invoke(Float f) {
                return invoke(f.floatValue());
            }
        }

        /* JADX INFO: renamed from: androidx.compose.material.SliderKt$RangeSlider$2$3, reason: invalid class name */
        /* JADX INFO: compiled from: Slider.kt */
        @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
        /* synthetic */ class AnonymousClass3 extends FunctionReferenceImpl implements Function1<Float, Float> {
            final /* synthetic */ Ref.FloatRef $maxPx;
            final /* synthetic */ Ref.FloatRef $minPx;
            final /* synthetic */ ClosedFloatingPointRange<Float> $valueRange;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            AnonymousClass3(ClosedFloatingPointRange<Float> closedFloatingPointRange, Ref.FloatRef floatRef, Ref.FloatRef floatRef2) {
                super(1, Intrinsics.Kotlin.class, "scaleToOffset", "invoke$scaleToOffset(Lkotlin/ranges/ClosedFloatingPointRange;Lkotlin/jvm/internal/Ref$FloatRef;Lkotlin/jvm/internal/Ref$FloatRef;F)F", 0);
                this.$valueRange = closedFloatingPointRange;
                this.$minPx = floatRef;
                this.$maxPx = floatRef2;
            }

            public final Float invoke(float f) {
                return Float.valueOf(C10642.invoke$scaleToOffset(this.$valueRange, this.$minPx, this.$maxPx, f));
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Float invoke(Float f) {
                return invoke(f.floatValue());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void SliderImpl(final boolean z, final float f, final List<Float> list, final SliderColors sliderColors, final float f2, final MutableInteractionSource mutableInteractionSource, final Modifier modifier, Composer composer, final int i) {
        Composer composerStartRestartGroup = composer.startRestartGroup(1679682785);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(SliderImpl)P(1,4,5!1,6)576@24423L712:Slider.kt#jmzs0o");
        Modifier modifierThen = modifier.then(DefaultSliderConstraints);
        composerStartRestartGroup.startReplaceableGroup(733328855);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(Box)P(2,1,3)70@3267L67,71@3339L130:Box.kt#2w3rfo");
        MeasurePolicy measurePolicyRememberBoxMeasurePolicy = BoxKt.rememberBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), false, composerStartRestartGroup, 0);
        composerStartRestartGroup.startReplaceableGroup(-1323940314);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(Layout)P(!1,2)74@2915L7,75@2970L7,76@3029L7,77@3041L460:Layout.kt#80mrfh");
        ProvidableCompositionLocal<Density> localDensity = CompositionLocalsKt.getLocalDensity();
        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "C:CompositionLocal.kt#9igjgp");
        Object objConsume = composerStartRestartGroup.consume(localDensity);
        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
        Density density = (Density) objConsume;
        ProvidableCompositionLocal<LayoutDirection> localLayoutDirection = CompositionLocalsKt.getLocalLayoutDirection();
        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "C:CompositionLocal.kt#9igjgp");
        Object objConsume2 = composerStartRestartGroup.consume(localLayoutDirection);
        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
        LayoutDirection layoutDirection = (LayoutDirection) objConsume2;
        ProvidableCompositionLocal<ViewConfiguration> localViewConfiguration = CompositionLocalsKt.getLocalViewConfiguration();
        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "C:CompositionLocal.kt#9igjgp");
        Object objConsume3 = composerStartRestartGroup.consume(localViewConfiguration);
        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
        ViewConfiguration viewConfiguration = (ViewConfiguration) objConsume3;
        Function0<ComposeUiNode> constructor = ComposeUiNode.INSTANCE.getConstructor();
        Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> function3MaterializerOf = LayoutKt.materializerOf(modifierThen);
        if (!(composerStartRestartGroup.getApplier() instanceof Applier)) {
            ComposablesKt.invalidApplier();
        }
        composerStartRestartGroup.startReusableNode();
        if (composerStartRestartGroup.getInserting()) {
            composerStartRestartGroup.createNode(constructor);
        } else {
            composerStartRestartGroup.useNode();
        }
        composerStartRestartGroup.disableReusing();
        Composer composerM1286constructorimpl = Updater.m1286constructorimpl(composerStartRestartGroup);
        Updater.m1293setimpl(composerM1286constructorimpl, measurePolicyRememberBoxMeasurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
        Updater.m1293setimpl(composerM1286constructorimpl, density, ComposeUiNode.INSTANCE.getSetDensity());
        Updater.m1293setimpl(composerM1286constructorimpl, layoutDirection, ComposeUiNode.INSTANCE.getSetLayoutDirection());
        Updater.m1293setimpl(composerM1286constructorimpl, viewConfiguration, ComposeUiNode.INSTANCE.getSetViewConfiguration());
        composerStartRestartGroup.enableReusing();
        function3MaterializerOf.invoke(SkippableUpdater.m1276boximpl(SkippableUpdater.m1277constructorimpl(composerStartRestartGroup)), composerStartRestartGroup, 0);
        composerStartRestartGroup.startReplaceableGroup(2058660585);
        composerStartRestartGroup.startReplaceableGroup(-2137368960);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C72@3384L9:Box.kt#2w3rfo");
        BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
        composerStartRestartGroup.startReplaceableGroup(231316251);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C*580@24583L7,589@24828L216,599@25053L76:Slider.kt#jmzs0o");
        ProvidableCompositionLocal<Density> localDensity2 = CompositionLocalsKt.getLocalDensity();
        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "C:CompositionLocal.kt#9igjgp");
        Object objConsume4 = composerStartRestartGroup.consume(localDensity2);
        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
        Density density2 = (Density) objConsume4;
        float fMo318toPx0680j_4 = density2.mo318toPx0680j_4(TrackHeight);
        float f3 = ThumbRadius;
        float fMo318toPx0680j_5 = density2.mo318toPx0680j_4(f3);
        float fMo314toDpu2uoSUM = density2.mo314toDpu2uoSUM(f2);
        float fM3843constructorimpl = Dp.m3843constructorimpl(f3 * 2);
        float fM3843constructorimpl2 = Dp.m3843constructorimpl(fMo314toDpu2uoSUM * f);
        int i2 = i >> 6;
        Track(SizeKt.fillMaxSize$default(Modifier.INSTANCE, 0.0f, 1, null), sliderColors, z, 0.0f, f, list, fMo318toPx0680j_5, fMo318toPx0680j_4, composerStartRestartGroup, (i2 & 112) | 265222 | ((i << 6) & 896) | ((i << 9) & 57344));
        m1151SliderThumbPcYyNuk(boxScopeInstance, Modifier.INSTANCE, fM3843constructorimpl2, mutableInteractionSource, sliderColors, z, fM3843constructorimpl, composerStartRestartGroup, (i2 & 7168) | 1572918 | ((i << 3) & 57344) | ((i << 15) & 458752));
        composerStartRestartGroup.endReplaceableGroup();
        composerStartRestartGroup.endReplaceableGroup();
        composerStartRestartGroup.endReplaceableGroup();
        composerStartRestartGroup.endNode();
        composerStartRestartGroup.endReplaceableGroup();
        composerStartRestartGroup.endReplaceableGroup();
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup == null) {
            return;
        }
        scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.SliderKt.SliderImpl.2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                invoke(composer2, num.intValue());
                return Unit.INSTANCE;
            }

            public final void invoke(Composer composer2, int i3) {
                SliderKt.SliderImpl(z, f, list, sliderColors, f2, mutableInteractionSource, modifier, composer2, i | 1);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void RangeSliderImpl(final boolean z, final float f, final float f2, final List<Float> list, final SliderColors sliderColors, final float f3, final MutableInteractionSource mutableInteractionSource, final MutableInteractionSource mutableInteractionSource2, final Modifier modifier, final Modifier modifier2, final Modifier modifier3, Composer composer, final int i, final int i2) {
        Composer composerStartRestartGroup = composer.startRestartGroup(-278895713);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(RangeSliderImpl)P(1,6,5,9!1,10,7!1,4,8)618@25580L35,619@25648L33,620@25686L1488:Slider.kt#jmzs0o");
        final String strM1173getString4foXLRw = Strings_androidKt.m1173getString4foXLRw(Strings.INSTANCE.m1172getSliderRangeStartUdPEhr4(), composerStartRestartGroup, 6);
        final String strM1173getString4foXLRw2 = Strings_androidKt.m1173getString4foXLRw(Strings.INSTANCE.m1171getSliderRangeEndUdPEhr4(), composerStartRestartGroup, 6);
        Modifier modifierThen = modifier.then(DefaultSliderConstraints);
        composerStartRestartGroup.startReplaceableGroup(733328855);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(Box)P(2,1,3)70@3267L67,71@3339L130:Box.kt#2w3rfo");
        MeasurePolicy measurePolicyRememberBoxMeasurePolicy = BoxKt.rememberBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), false, composerStartRestartGroup, 0);
        composerStartRestartGroup.startReplaceableGroup(-1323940314);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(Layout)P(!1,2)74@2915L7,75@2970L7,76@3029L7,77@3041L460:Layout.kt#80mrfh");
        ProvidableCompositionLocal<Density> localDensity = CompositionLocalsKt.getLocalDensity();
        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "C:CompositionLocal.kt#9igjgp");
        Object objConsume = composerStartRestartGroup.consume(localDensity);
        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
        Density density = (Density) objConsume;
        ProvidableCompositionLocal<LayoutDirection> localLayoutDirection = CompositionLocalsKt.getLocalLayoutDirection();
        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "C:CompositionLocal.kt#9igjgp");
        Object objConsume2 = composerStartRestartGroup.consume(localLayoutDirection);
        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
        LayoutDirection layoutDirection = (LayoutDirection) objConsume2;
        ProvidableCompositionLocal<ViewConfiguration> localViewConfiguration = CompositionLocalsKt.getLocalViewConfiguration();
        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "C:CompositionLocal.kt#9igjgp");
        Object objConsume3 = composerStartRestartGroup.consume(localViewConfiguration);
        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
        ViewConfiguration viewConfiguration = (ViewConfiguration) objConsume3;
        Function0<ComposeUiNode> constructor = ComposeUiNode.INSTANCE.getConstructor();
        Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> function3MaterializerOf = LayoutKt.materializerOf(modifierThen);
        if (!(composerStartRestartGroup.getApplier() instanceof Applier)) {
            ComposablesKt.invalidApplier();
        }
        composerStartRestartGroup.startReusableNode();
        if (composerStartRestartGroup.getInserting()) {
            composerStartRestartGroup.createNode(constructor);
        } else {
            composerStartRestartGroup.useNode();
        }
        composerStartRestartGroup.disableReusing();
        Composer composerM1286constructorimpl = Updater.m1286constructorimpl(composerStartRestartGroup);
        Updater.m1293setimpl(composerM1286constructorimpl, measurePolicyRememberBoxMeasurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
        Updater.m1293setimpl(composerM1286constructorimpl, density, ComposeUiNode.INSTANCE.getSetDensity());
        Updater.m1293setimpl(composerM1286constructorimpl, layoutDirection, ComposeUiNode.INSTANCE.getSetLayoutDirection());
        Updater.m1293setimpl(composerM1286constructorimpl, viewConfiguration, ComposeUiNode.INSTANCE.getSetViewConfiguration());
        composerStartRestartGroup.enableReusing();
        function3MaterializerOf.invoke(SkippableUpdater.m1276boximpl(SkippableUpdater.m1277constructorimpl(composerStartRestartGroup)), composerStartRestartGroup, 0);
        composerStartRestartGroup.startReplaceableGroup(2058660585);
        composerStartRestartGroup.startReplaceableGroup(-2137368960);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C72@3384L9:Box.kt#2w3rfo");
        BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
        composerStartRestartGroup.startReplaceableGroup(2044256857);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C*624@25846L7,633@26154L267,646@26517L48,644@26431L369,657@26895L46,655@26809L359:Slider.kt#jmzs0o");
        ProvidableCompositionLocal<Density> localDensity2 = CompositionLocalsKt.getLocalDensity();
        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "C:CompositionLocal.kt#9igjgp");
        Object objConsume4 = composerStartRestartGroup.consume(localDensity2);
        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
        Density density2 = (Density) objConsume4;
        float fMo318toPx0680j_4 = density2.mo318toPx0680j_4(TrackHeight);
        float f4 = ThumbRadius;
        float fMo318toPx0680j_5 = density2.mo318toPx0680j_4(f4);
        float fMo314toDpu2uoSUM = density2.mo314toDpu2uoSUM(f3);
        Unit unit = Unit.INSTANCE;
        float fM3843constructorimpl = Dp.m3843constructorimpl(f4 * 2);
        float fM3843constructorimpl2 = Dp.m3843constructorimpl(fMo314toDpu2uoSUM * f);
        float fM3843constructorimpl3 = Dp.m3843constructorimpl(fMo314toDpu2uoSUM * f2);
        int i3 = i >> 9;
        int i4 = i << 6;
        Track(SizeKt.fillMaxSize$default(boxScopeInstance.align(Modifier.INSTANCE, Alignment.INSTANCE.getCenterStart()), 0.0f, 1, null), sliderColors, z, f, f2, list, fMo318toPx0680j_5, fMo318toPx0680j_4, composerStartRestartGroup, (i3 & 112) | 262144 | (i4 & 896) | (i4 & 7168) | (i4 & 57344));
        Modifier.Companion companion = Modifier.INSTANCE;
        composerStartRestartGroup.startReplaceableGroup(1157296644);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(remember)P(1):Composables.kt#9igjgp");
        boolean zChanged = composerStartRestartGroup.changed(strM1173getString4foXLRw);
        Object objRememberedValue = composerStartRestartGroup.rememberedValue();
        if (zChanged || objRememberedValue == Composer.INSTANCE.getEmpty()) {
            objRememberedValue = (Function1) new Function1<SemanticsPropertyReceiver, Unit>() { // from class: androidx.compose.material.SliderKt$RangeSliderImpl$1$2$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(SemanticsPropertyReceiver semanticsPropertyReceiver) {
                    invoke2(semanticsPropertyReceiver);
                    return Unit.INSTANCE;
                }

                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(SemanticsPropertyReceiver semantics) {
                    Intrinsics.checkNotNullParameter(semantics, "$this$semantics");
                    SemanticsPropertiesKt.setContentDescription(semantics, strM1173getString4foXLRw);
                }
            };
            composerStartRestartGroup.updateRememberedValue(objRememberedValue);
        }
        composerStartRestartGroup.endReplaceableGroup();
        int i5 = i & 57344;
        int i6 = (i << 15) & 458752;
        m1151SliderThumbPcYyNuk(boxScopeInstance, FocusableKt.focusable(SemanticsModifierKt.semantics(companion, true, (Function1) objRememberedValue), true, mutableInteractionSource).then(modifier2), fM3843constructorimpl2, mutableInteractionSource, sliderColors, z, fM3843constructorimpl, composerStartRestartGroup, (i3 & 7168) | 1572870 | i5 | i6);
        Modifier.Companion companion2 = Modifier.INSTANCE;
        composerStartRestartGroup.startReplaceableGroup(1157296644);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(remember)P(1):Composables.kt#9igjgp");
        boolean zChanged2 = composerStartRestartGroup.changed(strM1173getString4foXLRw2);
        Object objRememberedValue2 = composerStartRestartGroup.rememberedValue();
        if (zChanged2 || objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
            objRememberedValue2 = (Function1) new Function1<SemanticsPropertyReceiver, Unit>() { // from class: androidx.compose.material.SliderKt$RangeSliderImpl$1$3$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(SemanticsPropertyReceiver semanticsPropertyReceiver) {
                    invoke2(semanticsPropertyReceiver);
                    return Unit.INSTANCE;
                }

                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(SemanticsPropertyReceiver semantics) {
                    Intrinsics.checkNotNullParameter(semantics, "$this$semantics");
                    SemanticsPropertiesKt.setContentDescription(semantics, strM1173getString4foXLRw2);
                }
            };
            composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
        }
        composerStartRestartGroup.endReplaceableGroup();
        m1151SliderThumbPcYyNuk(boxScopeInstance, FocusableKt.focusable(SemanticsModifierKt.semantics(companion2, true, (Function1) objRememberedValue2), true, mutableInteractionSource2).then(modifier3), fM3843constructorimpl3, mutableInteractionSource2, sliderColors, z, fM3843constructorimpl, composerStartRestartGroup, ((i >> 12) & 7168) | 1572870 | i5 | i6);
        composerStartRestartGroup.endReplaceableGroup();
        composerStartRestartGroup.endReplaceableGroup();
        composerStartRestartGroup.endReplaceableGroup();
        composerStartRestartGroup.endNode();
        composerStartRestartGroup.endReplaceableGroup();
        composerStartRestartGroup.endReplaceableGroup();
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup == null) {
            return;
        }
        scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.SliderKt.RangeSliderImpl.2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                invoke(composer2, num.intValue());
                return Unit.INSTANCE;
            }

            public final void invoke(Composer composer2, int i7) {
                SliderKt.RangeSliderImpl(z, f, f2, list, sliderColors, f3, mutableInteractionSource, mutableInteractionSource2, modifier, modifier2, modifier3, composer2, i | 1, i2);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: SliderThumb-PcYyNuk, reason: not valid java name */
    public static final void m1151SliderThumbPcYyNuk(final BoxScope boxScope, final Modifier modifier, final float f, final MutableInteractionSource mutableInteractionSource, final SliderColors sliderColors, final boolean z, final float f2, Composer composer, final int i) {
        int i2;
        float f3;
        Composer composerStartRestartGroup = composer.startRestartGroup(428907178);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(SliderThumb)P(3,4:c#ui.unit.Dp,2!,5:c#ui.unit.Dp)678@27387L1518:Slider.kt#jmzs0o");
        if ((i & 14) == 0) {
            i2 = (composerStartRestartGroup.changed(boxScope) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 112) == 0) {
            i2 |= composerStartRestartGroup.changed(modifier) ? 32 : 16;
        }
        if ((i & 896) == 0) {
            i2 |= composerStartRestartGroup.changed(f) ? 256 : 128;
        }
        if ((i & 7168) == 0) {
            i2 |= composerStartRestartGroup.changed(mutableInteractionSource) ? 2048 : 1024;
        }
        if ((57344 & i) == 0) {
            i2 |= composerStartRestartGroup.changed(sliderColors) ? 16384 : 8192;
        }
        if ((458752 & i) == 0) {
            i2 |= composerStartRestartGroup.changed(z) ? 131072 : 65536;
        }
        if ((3670016 & i) == 0) {
            i2 |= composerStartRestartGroup.changed(f2) ? 1048576 : 524288;
        }
        if ((2995931 & i2) != 599186 || !composerStartRestartGroup.getSkipping()) {
            Modifier modifierAlign = boxScope.align(PaddingKt.m427paddingqDBjuR0$default(Modifier.INSTANCE, f, 0.0f, 0.0f, 0.0f, 14, null), Alignment.INSTANCE.getCenterStart());
            composerStartRestartGroup.startReplaceableGroup(733328855);
            ComposerKt.sourceInformation(composerStartRestartGroup, "C(Box)P(2,1,3)70@3267L67,71@3339L130:Box.kt#2w3rfo");
            MeasurePolicy measurePolicyRememberBoxMeasurePolicy = BoxKt.rememberBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), false, composerStartRestartGroup, 0);
            composerStartRestartGroup.startReplaceableGroup(-1323940314);
            ComposerKt.sourceInformation(composerStartRestartGroup, "C(Layout)P(!1,2)74@2915L7,75@2970L7,76@3029L7,77@3041L460:Layout.kt#80mrfh");
            ProvidableCompositionLocal<Density> localDensity = CompositionLocalsKt.getLocalDensity();
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "C:CompositionLocal.kt#9igjgp");
            Object objConsume = composerStartRestartGroup.consume(localDensity);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            Density density = (Density) objConsume;
            ProvidableCompositionLocal<LayoutDirection> localLayoutDirection = CompositionLocalsKt.getLocalLayoutDirection();
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "C:CompositionLocal.kt#9igjgp");
            Object objConsume2 = composerStartRestartGroup.consume(localLayoutDirection);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            LayoutDirection layoutDirection = (LayoutDirection) objConsume2;
            ProvidableCompositionLocal<ViewConfiguration> localViewConfiguration = CompositionLocalsKt.getLocalViewConfiguration();
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "C:CompositionLocal.kt#9igjgp");
            Object objConsume3 = composerStartRestartGroup.consume(localViewConfiguration);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ViewConfiguration viewConfiguration = (ViewConfiguration) objConsume3;
            Function0<ComposeUiNode> constructor = ComposeUiNode.INSTANCE.getConstructor();
            Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> function3MaterializerOf = LayoutKt.materializerOf(modifierAlign);
            if (!(composerStartRestartGroup.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            composerStartRestartGroup.startReusableNode();
            if (composerStartRestartGroup.getInserting()) {
                composerStartRestartGroup.createNode(constructor);
            } else {
                composerStartRestartGroup.useNode();
            }
            composerStartRestartGroup.disableReusing();
            Composer composerM1286constructorimpl = Updater.m1286constructorimpl(composerStartRestartGroup);
            Updater.m1293setimpl(composerM1286constructorimpl, measurePolicyRememberBoxMeasurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
            Updater.m1293setimpl(composerM1286constructorimpl, density, ComposeUiNode.INSTANCE.getSetDensity());
            Updater.m1293setimpl(composerM1286constructorimpl, layoutDirection, ComposeUiNode.INSTANCE.getSetLayoutDirection());
            Updater.m1293setimpl(composerM1286constructorimpl, viewConfiguration, ComposeUiNode.INSTANCE.getSetViewConfiguration());
            composerStartRestartGroup.enableReusing();
            function3MaterializerOf.invoke(SkippableUpdater.m1276boximpl(SkippableUpdater.m1277constructorimpl(composerStartRestartGroup)), composerStartRestartGroup, 0);
            composerStartRestartGroup.startReplaceableGroup(2058660585);
            composerStartRestartGroup.startReplaceableGroup(-2137368960);
            ComposerKt.sourceInformation(composerStartRestartGroup, "C72@3384L9:Box.kt#2w3rfo");
            BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
            composerStartRestartGroup.startReplaceableGroup(-587645648);
            ComposerKt.sourceInformation(composerStartRestartGroup, "C679@27483L46,680@27572L658,680@27538L692,703@28586L59,707@28850L19,698@28392L507:Slider.kt#jmzs0o");
            composerStartRestartGroup.startReplaceableGroup(-492369756);
            ComposerKt.sourceInformation(composerStartRestartGroup, "C(remember):Composables.kt#9igjgp");
            Object objRememberedValue = composerStartRestartGroup.rememberedValue();
            if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                objRememberedValue = SnapshotStateKt.mutableStateListOf();
                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
            }
            composerStartRestartGroup.endReplaceableGroup();
            SnapshotStateList snapshotStateList = (SnapshotStateList) objRememberedValue;
            int i3 = i2 >> 9;
            int i4 = i3 & 14;
            composerStartRestartGroup.startReplaceableGroup(511388516);
            ComposerKt.sourceInformation(composerStartRestartGroup, "C(remember)P(1,2):Composables.kt#9igjgp");
            boolean zChanged = composerStartRestartGroup.changed(mutableInteractionSource) | composerStartRestartGroup.changed(snapshotStateList);
            Object objRememberedValue2 = composerStartRestartGroup.rememberedValue();
            if (zChanged || objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                objRememberedValue2 = (Function2) new SliderKt$SliderThumb$1$1$1(mutableInteractionSource, snapshotStateList, null);
                composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
            }
            composerStartRestartGroup.endReplaceableGroup();
            EffectsKt.LaunchedEffect(mutableInteractionSource, (Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object>) objRememberedValue2, composerStartRestartGroup, i4);
            if (!snapshotStateList.isEmpty()) {
                f3 = ThumbPressedElevation;
            } else {
                f3 = ThumbDefaultElevation;
            }
            SpacerKt.Spacer(BackgroundKt.m175backgroundbw27NRU(ShadowKt.m1324shadows4CzXII$default(HoverableKt.hoverable$default(IndicationKt.indication(SizeKt.m466sizeVpY3zN4(modifier, f2, f2), mutableInteractionSource, RippleKt.m1265rememberRipple9IZ8Weo(false, ThumbRippleRadius, 0L, composerStartRestartGroup, 54, 4)), mutableInteractionSource, false, 2, null), z ? f3 : Dp.m3843constructorimpl(0), RoundedCornerShapeKt.getCircleShape(), false, 0L, 0L, 24, null), sliderColors.thumbColor(z, composerStartRestartGroup, ((i2 >> 15) & 14) | (i3 & 112)).getValue().m1641unboximpl(), RoundedCornerShapeKt.getCircleShape()), composerStartRestartGroup, 0);
            composerStartRestartGroup.endReplaceableGroup();
            composerStartRestartGroup.endReplaceableGroup();
            composerStartRestartGroup.endReplaceableGroup();
            composerStartRestartGroup.endNode();
            composerStartRestartGroup.endReplaceableGroup();
            composerStartRestartGroup.endReplaceableGroup();
        } else {
            composerStartRestartGroup.skipToGroupEnd();
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup == null) {
            return;
        }
        scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.SliderKt$SliderThumb$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                invoke(composer2, num.intValue());
                return Unit.INSTANCE;
            }

            public final void invoke(Composer composer2, int i5) {
                SliderKt.m1151SliderThumbPcYyNuk(boxScope, modifier, f, mutableInteractionSource, sliderColors, z, f2, composer2, i | 1);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Track(final Modifier modifier, final SliderColors sliderColors, final boolean z, final float f, final float f2, final List<Float> list, final float f3, final float f4, Composer composer, final int i) {
        Composer composerStartRestartGroup = composer.startRestartGroup(1833126050);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(Track)P(2!2,4!1,6)723@29198L35,724@29268L34,725@29338L34,726@29406L33,727@29444L1514:Slider.kt#jmzs0o");
        int i2 = ((i >> 6) & 14) | 48 | ((i << 3) & 896);
        final State<Color> stateTrackColor = sliderColors.trackColor(z, false, composerStartRestartGroup, i2);
        final State<Color> stateTrackColor2 = sliderColors.trackColor(z, true, composerStartRestartGroup, i2);
        final State<Color> stateTickColor = sliderColors.tickColor(z, false, composerStartRestartGroup, i2);
        final State<Color> stateTickColor2 = sliderColors.tickColor(z, true, composerStartRestartGroup, i2);
        CanvasKt.Canvas(modifier, new Function1<DrawScope, Unit>() { // from class: androidx.compose.material.SliderKt.Track.1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(DrawScope drawScope) {
                invoke2(drawScope);
                return Unit.INSTANCE;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(DrawScope Canvas) {
                Intrinsics.checkNotNullParameter(Canvas, "$this$Canvas");
                boolean z2 = Canvas.getLayoutDirection() == LayoutDirection.Rtl;
                long jOffset = OffsetKt.Offset(f3, Offset.m1396getYimpl(Canvas.mo2124getCenterF1C5BW0()));
                long jOffset2 = OffsetKt.Offset(Size.m1464getWidthimpl(Canvas.mo2125getSizeNHjbRc()) - f3, Offset.m1396getYimpl(Canvas.mo2124getCenterF1C5BW0()));
                long j = z2 ? jOffset2 : jOffset;
                long j2 = z2 ? jOffset : jOffset2;
                long j3 = j2;
                long j4 = j;
                DrawScope.m2112drawLineNGM6Ib0$default(Canvas, stateTrackColor.getValue().m1641unboximpl(), j, j2, f4, StrokeCap.INSTANCE.m1936getRoundKaPHkGw(), null, 0.0f, null, 0, DtbConstants.DEFAULT_PLAYER_HEIGHT, null);
                DrawScope.m2112drawLineNGM6Ib0$default(Canvas, stateTrackColor2.getValue().m1641unboximpl(), OffsetKt.Offset(Offset.m1395getXimpl(j4) + ((Offset.m1395getXimpl(j3) - Offset.m1395getXimpl(j4)) * f), Offset.m1396getYimpl(Canvas.mo2124getCenterF1C5BW0())), OffsetKt.Offset(Offset.m1395getXimpl(j4) + ((Offset.m1395getXimpl(j3) - Offset.m1395getXimpl(j4)) * f2), Offset.m1396getYimpl(Canvas.mo2124getCenterF1C5BW0())), f4, StrokeCap.INSTANCE.m1936getRoundKaPHkGw(), null, 0.0f, null, 0, DtbConstants.DEFAULT_PLAYER_HEIGHT, null);
                List<Float> list2 = list;
                float f5 = f2;
                float f6 = f;
                LinkedHashMap linkedHashMap = new LinkedHashMap();
                for (Object obj : list2) {
                    float fFloatValue = ((Number) obj).floatValue();
                    Boolean boolValueOf = Boolean.valueOf(fFloatValue > f5 || fFloatValue < f6);
                    Object obj2 = linkedHashMap.get(boolValueOf);
                    if (obj2 == null) {
                        obj2 = (List) new ArrayList();
                        linkedHashMap.put(boolValueOf, obj2);
                    }
                    ((List) obj2).add(obj);
                }
                State<Color> state = stateTickColor;
                State<Color> state2 = stateTickColor2;
                float f7 = f4;
                for (Map.Entry entry : linkedHashMap.entrySet()) {
                    boolean zBooleanValue = ((Boolean) entry.getKey()).booleanValue();
                    List list3 = (List) entry.getValue();
                    ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list3, 10));
                    Iterator it = list3.iterator();
                    while (it.hasNext()) {
                        arrayList.add(Offset.m1384boximpl(OffsetKt.Offset(Offset.m1395getXimpl(OffsetKt.m1418lerpWko1d7g(j4, j3, ((Number) it.next()).floatValue())), Offset.m1396getYimpl(Canvas.mo2124getCenterF1C5BW0()))));
                    }
                    long j5 = j3;
                    j4 = j4;
                    DrawScope.m2117drawPointsF8ZwMP8$default(Canvas, arrayList, PointMode.INSTANCE.m1897getPointsr_lszbg(), (zBooleanValue ? state : state2).getValue().m1641unboximpl(), f7, StrokeCap.INSTANCE.m1936getRoundKaPHkGw(), null, 0.0f, null, 0, DtbConstants.DEFAULT_PLAYER_HEIGHT, null);
                    f7 = f7;
                    j3 = j5;
                }
            }
        }, composerStartRestartGroup, i & 14);
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup == null) {
            return;
        }
        scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.SliderKt.Track.2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                invoke(composer2, num.intValue());
                return Unit.INSTANCE;
            }

            public final void invoke(Composer composer2, int i3) {
                SliderKt.Track(modifier, sliderColors, z, f, f2, list, f3, f4, composer2, i | 1);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final float snapValueToTick(float f, List<Float> list, float f2, float f3) {
        Object obj;
        Iterator<T> it = list.iterator();
        if (it.hasNext()) {
            Object next = it.next();
            if (it.hasNext()) {
                float fAbs = Math.abs(MathHelpersKt.lerp(f2, f3, ((Number) next).floatValue()) - f);
                do {
                    Object next2 = it.next();
                    float fAbs2 = Math.abs(MathHelpersKt.lerp(f2, f3, ((Number) next2).floatValue()) - f);
                    if (Float.compare(fAbs, fAbs2) > 0) {
                        next = next2;
                        fAbs = fAbs2;
                    }
                } while (it.hasNext());
            }
            obj = next;
        } else {
            obj = null;
        }
        Float f4 = (Float) obj;
        return f4 != null ? MathHelpersKt.lerp(f2, f3, f4.floatValue()) : f;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    /* JADX INFO: renamed from: awaitSlop-8vUncbI, reason: not valid java name */
    public static final Object m1154awaitSlop8vUncbI(AwaitPointerEventScope awaitPointerEventScope, long j, int i, Continuation<? super Pair<PointerInputChange, Float>> continuation) throws Throwable {
        SliderKt$awaitSlop$1 sliderKt$awaitSlop$1;
        Ref.FloatRef floatRef;
        if (continuation instanceof SliderKt$awaitSlop$1) {
            sliderKt$awaitSlop$1 = (SliderKt$awaitSlop$1) continuation;
            if ((sliderKt$awaitSlop$1.label & Integer.MIN_VALUE) != 0) {
                sliderKt$awaitSlop$1.label -= Integer.MIN_VALUE;
            } else {
                sliderKt$awaitSlop$1 = new SliderKt$awaitSlop$1(continuation);
            }
        } else {
            sliderKt$awaitSlop$1 = new SliderKt$awaitSlop$1(continuation);
        }
        SliderKt$awaitSlop$1 sliderKt$awaitSlop$2 = sliderKt$awaitSlop$1;
        Object obj = sliderKt$awaitSlop$2.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i2 = sliderKt$awaitSlop$2.label;
        if (i2 == 0) {
            ResultKt.throwOnFailure(obj);
            final Ref.FloatRef floatRef2 = new Ref.FloatRef();
            Function2<PointerInputChange, Float, Unit> function2 = new Function2<PointerInputChange, Float, Unit>() { // from class: androidx.compose.material.SliderKt$awaitSlop$postPointerSlop$1
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(PointerInputChange pointerInputChange, Float f) {
                    invoke(pointerInputChange, f.floatValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(PointerInputChange pointerInput, float f) {
                    Intrinsics.checkNotNullParameter(pointerInput, "pointerInput");
                    pointerInput.consume();
                    floatRef2.element = f;
                }
            };
            sliderKt$awaitSlop$2.L$0 = floatRef2;
            sliderKt$awaitSlop$2.label = 1;
            Object objM1020awaitHorizontalPointerSlopOrCancellationgDDlDlE = DragGestureDetectorCopyKt.m1020awaitHorizontalPointerSlopOrCancellationgDDlDlE(awaitPointerEventScope, j, i, function2, sliderKt$awaitSlop$2);
            if (objM1020awaitHorizontalPointerSlopOrCancellationgDDlDlE == coroutine_suspended) {
                return coroutine_suspended;
            }
            obj = objM1020awaitHorizontalPointerSlopOrCancellationgDDlDlE;
            floatRef = floatRef2;
        } else {
            if (i2 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            floatRef = (Ref.FloatRef) sliderKt$awaitSlop$2.L$0;
            ResultKt.throwOnFailure(obj);
        }
        PointerInputChange pointerInputChange = (PointerInputChange) obj;
        if (pointerInputChange != null) {
            return TuplesKt.to(pointerInputChange, Boxing.boxFloat(floatRef.element));
        }
        return null;
    }

    private static final List<Float> stepsToTickFractions(int i) {
        if (i == 0) {
            return CollectionsKt.emptyList();
        }
        int i2 = i + 2;
        ArrayList arrayList = new ArrayList(i2);
        for (int i3 = 0; i3 < i2; i3++) {
            arrayList.add(Float.valueOf(i3 / (i + 1)));
        }
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final float scale(float f, float f2, float f3, float f4, float f5) {
        return MathHelpersKt.lerp(f4, f5, calcFraction(f, f2, f3));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ClosedFloatingPointRange<Float> scale(float f, float f2, ClosedFloatingPointRange<Float> closedFloatingPointRange, float f3, float f4) {
        return RangesKt.rangeTo(scale(f, f2, closedFloatingPointRange.getStart().floatValue(), f3, f4), scale(f, f2, closedFloatingPointRange.getEndInclusive().floatValue(), f3, f4));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final float calcFraction(float f, float f2, float f3) {
        float f4 = f2 - f;
        return RangesKt.coerceIn(f4 == 0.0f ? 0.0f : (f3 - f) / f4, 0.0f, 1.0f);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void CorrectValueSideEffect(final Function1<? super Float, Float> function1, final ClosedFloatingPointRange<Float> closedFloatingPointRange, final ClosedFloatingPointRange<Float> closedFloatingPointRange2, final MutableState<Float> mutableState, final float f, Composer composer, final int i) {
        Composer composerStartRestartGroup = composer.startRestartGroup(-743965752);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(CorrectValueSideEffect)P(!1,3!1,4)822@32812L300,822@32801L311:Slider.kt#jmzs0o");
        int i2 = (i & 14) == 0 ? (composerStartRestartGroup.changed(function1) ? 4 : 2) | i : i;
        if ((i & 112) == 0) {
            i2 |= composerStartRestartGroup.changed(closedFloatingPointRange) ? 32 : 16;
        }
        if ((i & 896) == 0) {
            i2 |= composerStartRestartGroup.changed(closedFloatingPointRange2) ? 256 : 128;
        }
        if ((i & 7168) == 0) {
            i2 |= composerStartRestartGroup.changed(mutableState) ? 2048 : 1024;
        }
        if ((57344 & i) == 0) {
            i2 |= composerStartRestartGroup.changed(f) ? 16384 : 8192;
        }
        if ((i2 & 46811) != 9362 || !composerStartRestartGroup.getSkipping()) {
            Object[] objArr = {closedFloatingPointRange, function1, Float.valueOf(f), mutableState, closedFloatingPointRange2};
            composerStartRestartGroup.startReplaceableGroup(-568225417);
            ComposerKt.sourceInformation(composerStartRestartGroup, "C(remember)P(1):Composables.kt#9igjgp");
            boolean zChanged = false;
            for (int i3 = 0; i3 < 5; i3++) {
                zChanged |= composerStartRestartGroup.changed(objArr[i3]);
            }
            Object objRememberedValue = composerStartRestartGroup.rememberedValue();
            if (zChanged || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                objRememberedValue = (Function0) new Function0<Unit>() { // from class: androidx.compose.material.SliderKt$CorrectValueSideEffect$1$1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    /* JADX WARN: Multi-variable type inference failed */
                    {
                        super(0);
                    }

                    @Override // kotlin.jvm.functions.Function0
                    public /* bridge */ /* synthetic */ Unit invoke() {
                        invoke2();
                        return Unit.INSTANCE;
                    }

                    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2() {
                        float fFloatValue = (closedFloatingPointRange.getEndInclusive().floatValue() - closedFloatingPointRange.getStart().floatValue()) / 1000;
                        float fFloatValue2 = function1.invoke(Float.valueOf(f)).floatValue();
                        if (Math.abs(fFloatValue2 - mutableState.getValue().floatValue()) <= fFloatValue || !closedFloatingPointRange2.contains(mutableState.getValue())) {
                            return;
                        }
                        mutableState.setValue(Float.valueOf(fFloatValue2));
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
            }
            composerStartRestartGroup.endReplaceableGroup();
            EffectsKt.SideEffect((Function0) objRememberedValue, composerStartRestartGroup, 0);
        } else {
            composerStartRestartGroup.skipToGroupEnd();
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup == null) {
            return;
        }
        scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.SliderKt.CorrectValueSideEffect.2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                invoke(composer2, num.intValue());
                return Unit.INSTANCE;
            }

            public final void invoke(Composer composer2, int i4) {
                SliderKt.CorrectValueSideEffect(function1, closedFloatingPointRange, closedFloatingPointRange2, mutableState, f, composer2, i | 1);
            }
        });
    }

    static /* synthetic */ Modifier sliderSemantics$default(Modifier modifier, float f, List list, boolean z, Function1 function1, ClosedFloatingPointRange closedFloatingPointRange, int i, int i2, Object obj) {
        if ((i2 & 16) != 0) {
            closedFloatingPointRange = RangesKt.rangeTo(0.0f, 1.0f);
        }
        ClosedFloatingPointRange closedFloatingPointRange2 = closedFloatingPointRange;
        if ((i2 & 32) != 0) {
            i = 0;
        }
        return sliderSemantics(modifier, f, list, z, function1, closedFloatingPointRange2, i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Modifier sliderSemantics(Modifier modifier, float f, final List<Float> list, final boolean z, final Function1<? super Float, Unit> function1, final ClosedFloatingPointRange<Float> closedFloatingPointRange, final int i) {
        final float fCoerceIn = RangesKt.coerceIn(f, closedFloatingPointRange.getStart().floatValue(), closedFloatingPointRange.getEndInclusive().floatValue());
        return ProgressSemanticsKt.progressSemantics(SemanticsModifierKt.semantics$default(modifier, false, new Function1<SemanticsPropertyReceiver, Unit>() { // from class: androidx.compose.material.SliderKt.sliderSemantics.1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(SemanticsPropertyReceiver semanticsPropertyReceiver) {
                invoke2(semanticsPropertyReceiver);
                return Unit.INSTANCE;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(SemanticsPropertyReceiver semantics) {
                Intrinsics.checkNotNullParameter(semantics, "$this$semantics");
                if (!z) {
                    SemanticsPropertiesKt.disabled(semantics);
                }
                final ClosedFloatingPointRange<Float> closedFloatingPointRange2 = closedFloatingPointRange;
                final int i2 = i;
                final List<Float> list2 = list;
                final float f2 = fCoerceIn;
                final Function1<Float, Unit> function2 = function1;
                SemanticsPropertiesKt.setProgress$default(semantics, null, new Function1<Float, Boolean>() { // from class: androidx.compose.material.SliderKt.sliderSemantics.1.1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    /* JADX WARN: Multi-variable type inference failed */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Boolean invoke(Float f3) {
                        return invoke(f3.floatValue());
                    }

                    public final Boolean invoke(float f3) {
                        boolean z2;
                        Object obj;
                        float fCoerceIn2 = RangesKt.coerceIn(f3, closedFloatingPointRange2.getStart().floatValue(), closedFloatingPointRange2.getEndInclusive().floatValue());
                        if (i2 > 0) {
                            List<Float> list3 = list2;
                            ClosedFloatingPointRange<Float> closedFloatingPointRange3 = closedFloatingPointRange2;
                            ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list3, 10));
                            Iterator<T> it = list3.iterator();
                            while (it.hasNext()) {
                                arrayList.add(Float.valueOf(MathHelpersKt.lerp(closedFloatingPointRange3.getStart().floatValue(), closedFloatingPointRange3.getEndInclusive().floatValue(), ((Number) it.next()).floatValue())));
                            }
                            Iterator it2 = arrayList.iterator();
                            if (it2.hasNext()) {
                                Object next = it2.next();
                                if (it2.hasNext()) {
                                    float fAbs = Math.abs(((Number) next).floatValue() - fCoerceIn2);
                                    do {
                                        Object next2 = it2.next();
                                        float fAbs2 = Math.abs(((Number) next2).floatValue() - fCoerceIn2);
                                        if (Float.compare(fAbs, fAbs2) > 0) {
                                            next = next2;
                                            fAbs = fAbs2;
                                        }
                                    } while (it2.hasNext());
                                }
                                obj = next;
                            } else {
                                obj = null;
                            }
                            Float f4 = (Float) obj;
                            if (f4 != null) {
                                fCoerceIn2 = f4.floatValue();
                            }
                        }
                        if (fCoerceIn2 == f2) {
                            z2 = false;
                        } else {
                            function2.invoke(Float.valueOf(fCoerceIn2));
                            z2 = true;
                        }
                        return Boolean.valueOf(z2);
                    }
                }, 1, null);
            }
        }, 1, null), f, closedFloatingPointRange, i);
    }

    /* JADX INFO: renamed from: androidx.compose.material.SliderKt$animateToTarget$2, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: Slider.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Landroidx/compose/foundation/gestures/DragScope;"}, k = 3, mv = {1, 6, 0}, xi = 48)
    @DebugMetadata(c = "androidx.compose.material.SliderKt$animateToTarget$2", f = "Slider.kt", i = {}, l = {927}, m = "invokeSuspend", n = {}, s = {})
    static final class C10692 extends SuspendLambda implements Function2<DragScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ float $current;
        final /* synthetic */ float $target;
        final /* synthetic */ float $velocity;
        private /* synthetic */ Object L$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C10692(float f, float f2, float f3, Continuation<? super C10692> continuation) {
            super(2, continuation);
            this.$current = f;
            this.$target = f2;
            this.$velocity = f3;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            C10692 c10692 = new C10692(this.$current, this.$target, this.$velocity, continuation);
            c10692.L$0 = obj;
            return c10692;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(DragScope dragScope, Continuation<? super Unit> continuation) {
            return ((C10692) create(dragScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                final DragScope dragScope = (DragScope) this.L$0;
                final Ref.FloatRef floatRef = new Ref.FloatRef();
                floatRef.element = this.$current;
                this.label = 1;
                if (AnimatableKt.Animatable$default(this.$current, 0.0f, 2, null).animateTo(Boxing.boxFloat(this.$target), SliderKt.SliderToTickAnimation, Boxing.boxFloat(this.$velocity), new Function1<Animatable<Float, AnimationVector1D>, Unit>() { // from class: androidx.compose.material.SliderKt.animateToTarget.2.1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(Animatable<Float, AnimationVector1D> animatable) {
                        invoke2(animatable);
                        return Unit.INSTANCE;
                    }

                    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(Animatable<Float, AnimationVector1D> animateTo) {
                        Intrinsics.checkNotNullParameter(animateTo, "$this$animateTo");
                        dragScope.dragBy(animateTo.getValue().floatValue() - floatRef.element);
                        floatRef.element = animateTo.getValue().floatValue();
                    }
                }, this) == coroutine_suspended) {
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

    /* JADX INFO: Access modifiers changed from: private */
    public static final Object animateToTarget(DraggableState draggableState, float f, float f2, float f3, Continuation<? super Unit> continuation) {
        Object objDrag$default = DraggableState.drag$default(draggableState, null, new C10692(f, f2, f3, null), continuation, 1, null);
        return objDrag$default == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objDrag$default : Unit.INSTANCE;
    }

    /* JADX INFO: renamed from: androidx.compose.material.SliderKt$rangeSliderPressDragModifier$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: Slider.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Landroidx/compose/ui/input/pointer/PointerInputScope;"}, k = 3, mv = {1, 6, 0}, xi = 48)
    @DebugMetadata(c = "androidx.compose.material.SliderKt$rangeSliderPressDragModifier$1", f = "Slider.kt", i = {}, l = {955}, m = "invokeSuspend", n = {}, s = {})
    static final class C10701 extends SuspendLambda implements Function2<PointerInputScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ MutableInteractionSource $endInteractionSource;
        final /* synthetic */ State<Function1<Boolean, Unit>> $gestureEndAction;
        final /* synthetic */ boolean $isRtl;
        final /* synthetic */ float $maxPx;
        final /* synthetic */ State<Function2<Boolean, Float, Unit>> $onDrag;
        final /* synthetic */ State<Float> $rawOffsetEnd;
        final /* synthetic */ State<Float> $rawOffsetStart;
        final /* synthetic */ MutableInteractionSource $startInteractionSource;
        private /* synthetic */ Object L$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        C10701(MutableInteractionSource mutableInteractionSource, MutableInteractionSource mutableInteractionSource2, State<Float> state, State<Float> state2, State<? extends Function2<? super Boolean, ? super Float, Unit>> state3, boolean z, float f, State<? extends Function1<? super Boolean, Unit>> state4, Continuation<? super C10701> continuation) {
            super(2, continuation);
            this.$startInteractionSource = mutableInteractionSource;
            this.$endInteractionSource = mutableInteractionSource2;
            this.$rawOffsetStart = state;
            this.$rawOffsetEnd = state2;
            this.$onDrag = state3;
            this.$isRtl = z;
            this.$maxPx = f;
            this.$gestureEndAction = state4;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            C10701 c10701 = new C10701(this.$startInteractionSource, this.$endInteractionSource, this.$rawOffsetStart, this.$rawOffsetEnd, this.$onDrag, this.$isRtl, this.$maxPx, this.$gestureEndAction, continuation);
            c10701.L$0 = obj;
            return c10701;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(PointerInputScope pointerInputScope, Continuation<? super Unit> continuation) {
            return ((C10701) create(pointerInputScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                PointerInputScope pointerInputScope = (PointerInputScope) this.L$0;
                RangeSliderLogic rangeSliderLogic = new RangeSliderLogic(this.$startInteractionSource, this.$endInteractionSource, this.$rawOffsetStart, this.$rawOffsetEnd, this.$onDrag);
                this.label = 1;
                if (CoroutineScopeKt.coroutineScope(new C00781(pointerInputScope, this.$isRtl, this.$maxPx, rangeSliderLogic, this.$rawOffsetStart, this.$gestureEndAction, this.$rawOffsetEnd, this.$onDrag, null), this) == coroutine_suspended) {
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

        /* JADX INFO: renamed from: androidx.compose.material.SliderKt$rangeSliderPressDragModifier$1$1, reason: invalid class name and collision with other inner class name */
        /* JADX INFO: compiled from: Slider.kt */
        @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 6, 0}, xi = 48)
        @DebugMetadata(c = "androidx.compose.material.SliderKt$rangeSliderPressDragModifier$1$1", f = "Slider.kt", i = {}, l = {956}, m = "invokeSuspend", n = {}, s = {})
        static final class C00781 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
            final /* synthetic */ PointerInputScope $$this$pointerInput;
            final /* synthetic */ State<Function1<Boolean, Unit>> $gestureEndAction;
            final /* synthetic */ boolean $isRtl;
            final /* synthetic */ float $maxPx;
            final /* synthetic */ State<Function2<Boolean, Float, Unit>> $onDrag;
            final /* synthetic */ RangeSliderLogic $rangeSliderLogic;
            final /* synthetic */ State<Float> $rawOffsetEnd;
            final /* synthetic */ State<Float> $rawOffsetStart;
            private /* synthetic */ Object L$0;
            int label;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            C00781(PointerInputScope pointerInputScope, boolean z, float f, RangeSliderLogic rangeSliderLogic, State<Float> state, State<? extends Function1<? super Boolean, Unit>> state2, State<Float> state3, State<? extends Function2<? super Boolean, ? super Float, Unit>> state4, Continuation<? super C00781> continuation) {
                super(2, continuation);
                this.$$this$pointerInput = pointerInputScope;
                this.$isRtl = z;
                this.$maxPx = f;
                this.$rangeSliderLogic = rangeSliderLogic;
                this.$rawOffsetStart = state;
                this.$gestureEndAction = state2;
                this.$rawOffsetEnd = state3;
                this.$onDrag = state4;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                C00781 c00781 = new C00781(this.$$this$pointerInput, this.$isRtl, this.$maxPx, this.$rangeSliderLogic, this.$rawOffsetStart, this.$gestureEndAction, this.$rawOffsetEnd, this.$onDrag, continuation);
                c00781.L$0 = obj;
                return c00781;
            }

            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
                return ((C00781) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
            }

            /* JADX INFO: renamed from: androidx.compose.material.SliderKt$rangeSliderPressDragModifier$1$1$1, reason: invalid class name and collision with other inner class name */
            /* JADX INFO: compiled from: Slider.kt */
            @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Landroidx/compose/ui/input/pointer/PointerInputScope;"}, k = 3, mv = {1, 6, 0}, xi = 48)
            @DebugMetadata(c = "androidx.compose.material.SliderKt$rangeSliderPressDragModifier$1$1$1", f = "Slider.kt", i = {}, l = {957}, m = "invokeSuspend", n = {}, s = {})
            static final class C00791 extends SuspendLambda implements Function2<PointerInputScope, Continuation<? super Unit>, Object> {
                final /* synthetic */ CoroutineScope $$this$coroutineScope;
                final /* synthetic */ State<Function1<Boolean, Unit>> $gestureEndAction;
                final /* synthetic */ boolean $isRtl;
                final /* synthetic */ float $maxPx;
                final /* synthetic */ State<Function2<Boolean, Float, Unit>> $onDrag;
                final /* synthetic */ RangeSliderLogic $rangeSliderLogic;
                final /* synthetic */ State<Float> $rawOffsetEnd;
                final /* synthetic */ State<Float> $rawOffsetStart;
                private /* synthetic */ Object L$0;
                int label;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                C00791(boolean z, float f, RangeSliderLogic rangeSliderLogic, State<Float> state, CoroutineScope coroutineScope, State<? extends Function1<? super Boolean, Unit>> state2, State<Float> state3, State<? extends Function2<? super Boolean, ? super Float, Unit>> state4, Continuation<? super C00791> continuation) {
                    super(2, continuation);
                    this.$isRtl = z;
                    this.$maxPx = f;
                    this.$rangeSliderLogic = rangeSliderLogic;
                    this.$rawOffsetStart = state;
                    this.$$this$coroutineScope = coroutineScope;
                    this.$gestureEndAction = state2;
                    this.$rawOffsetEnd = state3;
                    this.$onDrag = state4;
                }

                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                    C00791 c00791 = new C00791(this.$isRtl, this.$maxPx, this.$rangeSliderLogic, this.$rawOffsetStart, this.$$this$coroutineScope, this.$gestureEndAction, this.$rawOffsetEnd, this.$onDrag, continuation);
                    c00791.L$0 = obj;
                    return c00791;
                }

                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(PointerInputScope pointerInputScope, Continuation<? super Unit> continuation) {
                    return ((C00791) create(pointerInputScope, continuation)).invokeSuspend(Unit.INSTANCE);
                }

                /* JADX INFO: renamed from: androidx.compose.material.SliderKt$rangeSliderPressDragModifier$1$1$1$1, reason: invalid class name and collision with other inner class name */
                /* JADX INFO: compiled from: Slider.kt */
                @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Landroidx/compose/ui/input/pointer/AwaitPointerEventScope;"}, k = 3, mv = {1, 6, 0}, xi = 48)
                @DebugMetadata(c = "androidx.compose.material.SliderKt$rangeSliderPressDragModifier$1$1$1$1", f = "Slider.kt", i = {0, 1, 1, 1, 1, 1, 2, 2}, l = {958, 968, 987}, m = "invokeSuspend", n = {"$this$awaitPointerEventScope", "$this$awaitPointerEventScope", "event", "interaction", "posX", "draggingStart", "interaction", "draggingStart"}, s = {"L$0", "L$0", "L$1", "L$2", "L$3", "L$4", "L$0", "L$1"})
                static final class C00801 extends RestrictedSuspendLambda implements Function2<AwaitPointerEventScope, Continuation<? super Unit>, Object> {
                    final /* synthetic */ CoroutineScope $$this$coroutineScope;
                    final /* synthetic */ State<Function1<Boolean, Unit>> $gestureEndAction;
                    final /* synthetic */ boolean $isRtl;
                    final /* synthetic */ float $maxPx;
                    final /* synthetic */ State<Function2<Boolean, Float, Unit>> $onDrag;
                    final /* synthetic */ RangeSliderLogic $rangeSliderLogic;
                    final /* synthetic */ State<Float> $rawOffsetEnd;
                    final /* synthetic */ State<Float> $rawOffsetStart;
                    private /* synthetic */ Object L$0;
                    Object L$1;
                    Object L$2;
                    Object L$3;
                    Object L$4;
                    int label;

                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    /* JADX WARN: Multi-variable type inference failed */
                    C00801(boolean z, float f, RangeSliderLogic rangeSliderLogic, State<Float> state, CoroutineScope coroutineScope, State<? extends Function1<? super Boolean, Unit>> state2, State<Float> state3, State<? extends Function2<? super Boolean, ? super Float, Unit>> state4, Continuation<? super C00801> continuation) {
                        super(2, continuation);
                        this.$isRtl = z;
                        this.$maxPx = f;
                        this.$rangeSliderLogic = rangeSliderLogic;
                        this.$rawOffsetStart = state;
                        this.$$this$coroutineScope = coroutineScope;
                        this.$gestureEndAction = state2;
                        this.$rawOffsetEnd = state3;
                        this.$onDrag = state4;
                    }

                    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                        C00801 c00801 = new C00801(this.$isRtl, this.$maxPx, this.$rangeSliderLogic, this.$rawOffsetStart, this.$$this$coroutineScope, this.$gestureEndAction, this.$rawOffsetEnd, this.$onDrag, continuation);
                        c00801.L$0 = obj;
                        return c00801;
                    }

                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(AwaitPointerEventScope awaitPointerEventScope, Continuation<? super Unit> continuation) {
                        return ((C00801) create(awaitPointerEventScope, continuation)).invokeSuspend(Unit.INSTANCE);
                    }

                    /* JADX WARN: Code duplicated, block: B:35:0x00e1  */
                    /* JADX WARN: Code duplicated, block: B:52:0x017d A[RETURN] */
                    /* JADX WARN: Code duplicated, block: B:53:0x017e  */
                    /* JADX WARN: Code duplicated, block: B:56:0x0188 A[Catch: CancellationException -> 0x019a, TryCatch #1 {CancellationException -> 0x019a, blocks: (B:8:0x001d, B:54:0x0180, B:56:0x0188, B:57:0x0190), top: B:66:0x001d }] */
                    /* JADX WARN: Code duplicated, block: B:57:0x0190 A[Catch: CancellationException -> 0x019a, TRY_LEAVE, TryCatch #1 {CancellationException -> 0x019a, blocks: (B:8:0x001d, B:54:0x0180, B:56:0x0188, B:57:0x0190), top: B:66:0x001d }] */
                    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                    public final Object invokeSuspend(Object obj) throws Throwable {
                        AwaitPointerEventScope awaitPointerEventScope;
                        Object objAwaitFirstDown;
                        Object objM1154awaitSlop8vUncbI;
                        AwaitPointerEventScope awaitPointerEventScope2;
                        PointerInputChange pointerInputChange;
                        Ref.FloatRef floatRef;
                        DragInteraction.Start start;
                        final Ref.BooleanRef booleanRef;
                        Pair pair;
                        Ref.BooleanRef booleanRef2;
                        DragInteraction.Start start2;
                        Object objM269horizontalDragjO51t88;
                        State<Float> state;
                        boolean z;
                        float fM1023pointerSlopE8SPZFQ;
                        DragInteraction.Cancel cancel;
                        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                        int i = this.label;
                        if (i == 0) {
                            ResultKt.throwOnFailure(obj);
                            awaitPointerEventScope = (AwaitPointerEventScope) this.L$0;
                            this.L$0 = awaitPointerEventScope;
                            this.label = 1;
                            objAwaitFirstDown = TapGestureDetectorKt.awaitFirstDown(awaitPointerEventScope, false, this);
                            if (objAwaitFirstDown == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                        } else if (i == 1) {
                            awaitPointerEventScope = (AwaitPointerEventScope) this.L$0;
                            ResultKt.throwOnFailure(obj);
                            objAwaitFirstDown = obj;
                        } else {
                            if (i != 2) {
                                if (i == 3) {
                                    booleanRef2 = (Ref.BooleanRef) this.L$1;
                                    start2 = (DragInteraction.Start) this.L$0;
                                    try {
                                        ResultKt.throwOnFailure(obj);
                                        objM269horizontalDragjO51t88 = obj;
                                        if (((Boolean) objM269horizontalDragjO51t88).booleanValue()) {
                                            cancel = new DragInteraction.Stop(start2);
                                        } else {
                                            cancel = new DragInteraction.Cancel(start2);
                                        }
                                    } catch (CancellationException unused) {
                                        cancel = new DragInteraction.Cancel(start2);
                                    }
                                    this.$gestureEndAction.getValue().invoke(Boxing.boxBoolean(booleanRef2.element));
                                    BuildersKt__Builders_commonKt.launch$default(this.$$this$coroutineScope, null, null, new AnonymousClass2(this.$rangeSliderLogic, booleanRef2, cancel, null), 3, null);
                                    return Unit.INSTANCE;
                                }
                                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                            }
                            booleanRef = (Ref.BooleanRef) this.L$4;
                            Ref.FloatRef floatRef2 = (Ref.FloatRef) this.L$3;
                            start = (DragInteraction.Start) this.L$2;
                            PointerInputChange pointerInputChange2 = (PointerInputChange) this.L$1;
                            AwaitPointerEventScope awaitPointerEventScope3 = (AwaitPointerEventScope) this.L$0;
                            ResultKt.throwOnFailure(obj);
                            awaitPointerEventScope2 = awaitPointerEventScope3;
                            pointerInputChange = pointerInputChange2;
                            floatRef = floatRef2;
                            objM1154awaitSlop8vUncbI = obj;
                            pair = (Pair) objM1154awaitSlop8vUncbI;
                            if (pair != null) {
                                state = this.$rawOffsetEnd;
                                State<Float> state2 = this.$rawOffsetStart;
                                z = this.$isRtl;
                                fM1023pointerSlopE8SPZFQ = DragGestureDetectorCopyKt.m1023pointerSlopE8SPZFQ(awaitPointerEventScope2.getViewConfiguration(), pointerInputChange.getType());
                                if (Math.abs(state.getValue().floatValue() - floatRef.element) < fM1023pointerSlopE8SPZFQ && Math.abs(state2.getValue().floatValue() - floatRef.element) < fM1023pointerSlopE8SPZFQ) {
                                    float fFloatValue = ((Number) pair.getSecond()).floatValue();
                                    booleanRef.element = z ? fFloatValue < 0.0f : fFloatValue >= 0.0f;
                                    floatRef.element += Offset.m1395getXimpl(PointerEventKt.positionChange((PointerInputChange) pair.getFirst()));
                                }
                            }
                            this.$rangeSliderLogic.captureThumb(booleanRef.element, floatRef.element, start, this.$$this$coroutineScope);
                            try {
                                long id = pointerInputChange.getId();
                                final State<Function2<Boolean, Float, Unit>> state3 = this.$onDrag;
                                final boolean z2 = this.$isRtl;
                                this.L$0 = start;
                                this.L$1 = booleanRef;
                                this.L$2 = null;
                                this.L$3 = null;
                                this.L$4 = null;
                                this.label = 3;
                                objM269horizontalDragjO51t88 = DragGestureDetectorKt.m269horizontalDragjO51t88(awaitPointerEventScope2, id, new Function1<PointerInputChange, Unit>() { // from class: androidx.compose.material.SliderKt$rangeSliderPressDragModifier$1$1$1$1$finishInteraction$success$1
                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                    /* JADX WARN: Multi-variable type inference failed */
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public /* bridge */ /* synthetic */ Unit invoke(PointerInputChange pointerInputChange3) {
                                        invoke2(pointerInputChange3);
                                        return Unit.INSTANCE;
                                    }

                                    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                                    public final void invoke2(PointerInputChange it) {
                                        Intrinsics.checkNotNullParameter(it, "it");
                                        float fM1395getXimpl = Offset.m1395getXimpl(PointerEventKt.positionChange(it));
                                        Function2<Boolean, Float, Unit> value = state3.getValue();
                                        Boolean boolValueOf = Boolean.valueOf(booleanRef.element);
                                        if (z2) {
                                            fM1395getXimpl = -fM1395getXimpl;
                                        }
                                        value.invoke(boolValueOf, Float.valueOf(fM1395getXimpl));
                                    }
                                }, this);
                                if (objM269horizontalDragjO51t88 == coroutine_suspended) {
                                    return coroutine_suspended;
                                }
                                booleanRef2 = booleanRef;
                                start2 = start;
                                if (((Boolean) objM269horizontalDragjO51t88).booleanValue()) {
                                    cancel = new DragInteraction.Stop(start2);
                                } else {
                                    cancel = new DragInteraction.Cancel(start2);
                                }
                                this.$gestureEndAction.getValue().invoke(Boxing.boxBoolean(booleanRef2.element));
                                BuildersKt__Builders_commonKt.launch$default(this.$$this$coroutineScope, null, null, new AnonymousClass2(this.$rangeSliderLogic, booleanRef2, cancel, null), 3, null);
                                return Unit.INSTANCE;
                            } catch (CancellationException unused2) {
                                booleanRef2 = booleanRef;
                                start2 = start;
                                cancel = new DragInteraction.Cancel(start2);
                            }
                        }
                        AwaitPointerEventScope awaitPointerEventScope4 = awaitPointerEventScope;
                        PointerInputChange pointerInputChange3 = (PointerInputChange) objAwaitFirstDown;
                        DragInteraction.Start start3 = new DragInteraction.Start();
                        Ref.FloatRef floatRef3 = new Ref.FloatRef();
                        floatRef3.element = this.$isRtl ? this.$maxPx - Offset.m1395getXimpl(pointerInputChange3.getPosition()) : Offset.m1395getXimpl(pointerInputChange3.getPosition());
                        int iCompareOffsets = this.$rangeSliderLogic.compareOffsets(floatRef3.element);
                        Ref.BooleanRef booleanRef3 = new Ref.BooleanRef();
                        booleanRef3.element = iCompareOffsets == 0 ? this.$rawOffsetStart.getValue().floatValue() > floatRef3.element : iCompareOffsets < 0;
                        this.L$0 = awaitPointerEventScope4;
                        this.L$1 = pointerInputChange3;
                        this.L$2 = start3;
                        this.L$3 = floatRef3;
                        this.L$4 = booleanRef3;
                        this.label = 2;
                        objM1154awaitSlop8vUncbI = SliderKt.m1154awaitSlop8vUncbI(awaitPointerEventScope4, pointerInputChange3.getId(), pointerInputChange3.getType(), this);
                        if (objM1154awaitSlop8vUncbI == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        awaitPointerEventScope2 = awaitPointerEventScope4;
                        pointerInputChange = pointerInputChange3;
                        floatRef = floatRef3;
                        start = start3;
                        booleanRef = booleanRef3;
                        pair = (Pair) objM1154awaitSlop8vUncbI;
                        if (pair != null) {
                            state = this.$rawOffsetEnd;
                            State<Float> state4 = this.$rawOffsetStart;
                            z = this.$isRtl;
                            fM1023pointerSlopE8SPZFQ = DragGestureDetectorCopyKt.m1023pointerSlopE8SPZFQ(awaitPointerEventScope2.getViewConfiguration(), pointerInputChange.getType());
                            if (Math.abs(state.getValue().floatValue() - floatRef.element) < fM1023pointerSlopE8SPZFQ) {
                                float fFloatValue2 = ((Number) pair.getSecond()).floatValue();
                                booleanRef.element = z ? fFloatValue2 < 0.0f : fFloatValue2 >= 0.0f;
                                floatRef.element += Offset.m1395getXimpl(PointerEventKt.positionChange((PointerInputChange) pair.getFirst()));
                            }
                        }
                        this.$rangeSliderLogic.captureThumb(booleanRef.element, floatRef.element, start, this.$$this$coroutineScope);
                        long id2 = pointerInputChange.getId();
                        final State<? extends Function2<? super Boolean, ? super Float, Unit>> state5 = this.$onDrag;
                        final boolean z3 = this.$isRtl;
                        this.L$0 = start;
                        this.L$1 = booleanRef;
                        this.L$2 = null;
                        this.L$3 = null;
                        this.L$4 = null;
                        this.label = 3;
                        objM269horizontalDragjO51t88 = DragGestureDetectorKt.m269horizontalDragjO51t88(awaitPointerEventScope2, id2, new Function1<PointerInputChange, Unit>() { // from class: androidx.compose.material.SliderKt$rangeSliderPressDragModifier$1$1$1$1$finishInteraction$success$1
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            /* JADX WARN: Multi-variable type inference failed */
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public /* bridge */ /* synthetic */ Unit invoke(PointerInputChange pointerInputChange4) {
                                invoke2(pointerInputChange4);
                                return Unit.INSTANCE;
                            }

                            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                            public final void invoke2(PointerInputChange it) {
                                Intrinsics.checkNotNullParameter(it, "it");
                                float fM1395getXimpl = Offset.m1395getXimpl(PointerEventKt.positionChange(it));
                                Function2<Boolean, Float, Unit> value = state5.getValue();
                                Boolean boolValueOf = Boolean.valueOf(booleanRef.element);
                                if (z3) {
                                    fM1395getXimpl = -fM1395getXimpl;
                                }
                                value.invoke(boolValueOf, Float.valueOf(fM1395getXimpl));
                            }
                        }, this);
                        if (objM269horizontalDragjO51t88 == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        booleanRef2 = booleanRef;
                        start2 = start;
                        if (((Boolean) objM269horizontalDragjO51t88).booleanValue()) {
                            cancel = new DragInteraction.Stop(start2);
                        } else {
                            cancel = new DragInteraction.Cancel(start2);
                        }
                        this.$gestureEndAction.getValue().invoke(Boxing.boxBoolean(booleanRef2.element));
                        BuildersKt__Builders_commonKt.launch$default(this.$$this$coroutineScope, null, null, new AnonymousClass2(this.$rangeSliderLogic, booleanRef2, cancel, null), 3, null);
                        return Unit.INSTANCE;
                    }

                    /* JADX INFO: renamed from: androidx.compose.material.SliderKt$rangeSliderPressDragModifier$1$1$1$1$2, reason: invalid class name */
                    /* JADX INFO: compiled from: Slider.kt */
                    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 6, 0}, xi = 48)
                    @DebugMetadata(c = "androidx.compose.material.SliderKt$rangeSliderPressDragModifier$1$1$1$1$2", f = "Slider.kt", i = {}, l = {1004}, m = "invokeSuspend", n = {}, s = {})
                    static final class AnonymousClass2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
                        final /* synthetic */ Ref.BooleanRef $draggingStart;
                        final /* synthetic */ DragInteraction $finishInteraction;
                        final /* synthetic */ RangeSliderLogic $rangeSliderLogic;
                        int label;

                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        AnonymousClass2(RangeSliderLogic rangeSliderLogic, Ref.BooleanRef booleanRef, DragInteraction dragInteraction, Continuation<? super AnonymousClass2> continuation) {
                            super(2, continuation);
                            this.$rangeSliderLogic = rangeSliderLogic;
                            this.$draggingStart = booleanRef;
                            this.$finishInteraction = dragInteraction;
                        }

                        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                            return new AnonymousClass2(this.$rangeSliderLogic, this.$draggingStart, this.$finishInteraction, continuation);
                        }

                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
                            return ((AnonymousClass2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
                        }

                        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                        public final Object invokeSuspend(Object obj) throws Throwable {
                            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                            int i = this.label;
                            if (i == 0) {
                                ResultKt.throwOnFailure(obj);
                                this.label = 1;
                                if (this.$rangeSliderLogic.activeInteraction(this.$draggingStart.element).emit(this.$finishInteraction, this) == coroutine_suspended) {
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

                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                public final Object invokeSuspend(Object obj) throws Throwable {
                    Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                    int i = this.label;
                    if (i == 0) {
                        ResultKt.throwOnFailure(obj);
                        this.label = 1;
                        if (((PointerInputScope) this.L$0).awaitPointerEventScope(new C00801(this.$isRtl, this.$maxPx, this.$rangeSliderLogic, this.$rawOffsetStart, this.$$this$coroutineScope, this.$gestureEndAction, this.$rawOffsetEnd, this.$onDrag, null), this) == coroutine_suspended) {
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

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object obj) throws Throwable {
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                int i = this.label;
                if (i == 0) {
                    ResultKt.throwOnFailure(obj);
                    CoroutineScope coroutineScope = (CoroutineScope) this.L$0;
                    this.label = 1;
                    if (ForEachGestureKt.forEachGesture(this.$$this$pointerInput, new C00791(this.$isRtl, this.$maxPx, this.$rangeSliderLogic, this.$rawOffsetStart, coroutineScope, this.$gestureEndAction, this.$rawOffsetEnd, this.$onDrag, null), this) == coroutine_suspended) {
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

    /* JADX INFO: Access modifiers changed from: private */
    public static final Modifier rangeSliderPressDragModifier(Modifier modifier, MutableInteractionSource mutableInteractionSource, MutableInteractionSource mutableInteractionSource2, State<Float> state, State<Float> state2, boolean z, boolean z2, float f, ClosedFloatingPointRange<Float> closedFloatingPointRange, State<? extends Function1<? super Boolean, Unit>> state3, State<? extends Function2<? super Boolean, ? super Float, Unit>> state4) {
        return z ? SuspendingPointerInputFilterKt.pointerInput(modifier, new Object[]{mutableInteractionSource, mutableInteractionSource2, Float.valueOf(f), Boolean.valueOf(z2), closedFloatingPointRange}, (Function2<? super PointerInputScope, ? super Continuation<? super Unit>, ? extends Object>) new C10701(mutableInteractionSource, mutableInteractionSource2, state, state2, state4, z2, f, state3, null)) : modifier;
    }

    public static final float getThumbRadius() {
        return ThumbRadius;
    }

    public static final float getTrackHeight() {
        return TrackHeight;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Modifier sliderTapModifier(Modifier modifier, final DraggableState draggableState, final MutableInteractionSource mutableInteractionSource, final float f, final boolean z, final State<Float> state, final State<? extends Function1<? super Float, Unit>> state2, final MutableState<Float> mutableState, final boolean z2) {
        return ComposedModifierKt.composed(modifier, InspectableValueKt.isDebugInspectorInfoEnabled() ? new Function1<InspectorInfo, Unit>() { // from class: androidx.compose.material.SliderKt$sliderTapModifier$$inlined$debugInspectorInfo$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
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
                inspectorInfo.setName("sliderTapModifier");
                inspectorInfo.getProperties().set("draggableState", draggableState);
                inspectorInfo.getProperties().set("interactionSource", mutableInteractionSource);
                inspectorInfo.getProperties().set("maxPx", Float.valueOf(f));
                inspectorInfo.getProperties().set("isRtl", Boolean.valueOf(z));
                inspectorInfo.getProperties().set("rawOffset", state);
                inspectorInfo.getProperties().set("gestureEndAction", state2);
                inspectorInfo.getProperties().set("pressOffset", mutableState);
                inspectorInfo.getProperties().set("enabled", Boolean.valueOf(z2));
            }
        } : InspectableValueKt.getNoInspectorInfo(), new Function3<Modifier, Composer, Integer, Modifier>() { // from class: androidx.compose.material.SliderKt.sliderTapModifier.2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(3);
            }

            @Override // kotlin.jvm.functions.Function3
            public /* bridge */ /* synthetic */ Modifier invoke(Modifier modifier2, Composer composer, Integer num) {
                return invoke(modifier2, composer, num.intValue());
            }

            public final Modifier invoke(Modifier composed, Composer composer, int i) {
                Intrinsics.checkNotNullParameter(composed, "$this$composed");
                composer.startReplaceableGroup(1945228890);
                ComposerKt.sourceInformation(composer, "C879@34727L24:Slider.kt#jmzs0o");
                if (z2) {
                    composer.startReplaceableGroup(773894976);
                    ComposerKt.sourceInformation(composer, "C(rememberCoroutineScope)475@19849L144:Effects.kt#9igjgp");
                    composer.startReplaceableGroup(-492369756);
                    ComposerKt.sourceInformation(composer, "C(remember):Composables.kt#9igjgp");
                    Object objRememberedValue = composer.rememberedValue();
                    if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                        CompositionScopedCoroutineScopeCanceller compositionScopedCoroutineScopeCanceller = new CompositionScopedCoroutineScopeCanceller(EffectsKt.createCompositionCoroutineScope(EmptyCoroutineContext.INSTANCE, composer));
                        composer.updateRememberedValue(compositionScopedCoroutineScopeCanceller);
                        objRememberedValue = compositionScopedCoroutineScopeCanceller;
                    }
                    composer.endReplaceableGroup();
                    CoroutineScope coroutineScope = ((CompositionScopedCoroutineScopeCanceller) objRememberedValue).getCoroutineScope();
                    composer.endReplaceableGroup();
                    composed = SuspendingPointerInputFilterKt.pointerInput(composed, new Object[]{draggableState, mutableInteractionSource, Float.valueOf(f), Boolean.valueOf(z)}, (Function2<? super PointerInputScope, ? super Continuation<? super Unit>, ? extends Object>) new AnonymousClass1(z, f, mutableState, state, coroutineScope, draggableState, state2, null));
                }
                composer.endReplaceableGroup();
                return composed;
            }

            /* JADX INFO: renamed from: androidx.compose.material.SliderKt$sliderTapModifier$2$1, reason: invalid class name */
            /* JADX INFO: compiled from: Slider.kt */
            @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
            @DebugMetadata(c = "androidx.compose.material.SliderKt$sliderTapModifier$2$1", f = "Slider.kt", i = {}, l = {882}, m = "invokeSuspend", n = {}, s = {})
            static final class AnonymousClass1 extends SuspendLambda implements Function2<PointerInputScope, Continuation<? super Unit>, Object> {
                final /* synthetic */ DraggableState $draggableState;
                final /* synthetic */ State<Function1<Float, Unit>> $gestureEndAction;
                final /* synthetic */ boolean $isRtl;
                final /* synthetic */ float $maxPx;
                final /* synthetic */ MutableState<Float> $pressOffset;
                final /* synthetic */ State<Float> $rawOffset;
                final /* synthetic */ CoroutineScope $scope;
                private /* synthetic */ Object L$0;
                int label;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                AnonymousClass1(boolean z, float f, MutableState<Float> mutableState, State<Float> state, CoroutineScope coroutineScope, DraggableState draggableState, State<? extends Function1<? super Float, Unit>> state2, Continuation<? super AnonymousClass1> continuation) {
                    super(2, continuation);
                    this.$isRtl = z;
                    this.$maxPx = f;
                    this.$pressOffset = mutableState;
                    this.$rawOffset = state;
                    this.$scope = coroutineScope;
                    this.$draggableState = draggableState;
                    this.$gestureEndAction = state2;
                }

                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                    AnonymousClass1 anonymousClass1 = new AnonymousClass1(this.$isRtl, this.$maxPx, this.$pressOffset, this.$rawOffset, this.$scope, this.$draggableState, this.$gestureEndAction, continuation);
                    anonymousClass1.L$0 = obj;
                    return anonymousClass1;
                }

                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(PointerInputScope pointerInputScope, Continuation<? super Unit> continuation) {
                    return ((AnonymousClass1) create(pointerInputScope, continuation)).invokeSuspend(Unit.INSTANCE);
                }

                /* JADX INFO: renamed from: androidx.compose.material.SliderKt$sliderTapModifier$2$1$1, reason: invalid class name and collision with other inner class name */
                /* JADX INFO: compiled from: Slider.kt */
                @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
                @DebugMetadata(c = "androidx.compose.material.SliderKt$sliderTapModifier$2$1$1", f = "Slider.kt", i = {}, l = {887}, m = "invokeSuspend", n = {}, s = {})
                static final class C00821 extends SuspendLambda implements Function3<PressGestureScope, Offset, Continuation<? super Unit>, Object> {
                    final /* synthetic */ boolean $isRtl;
                    final /* synthetic */ float $maxPx;
                    final /* synthetic */ MutableState<Float> $pressOffset;
                    final /* synthetic */ State<Float> $rawOffset;
                    /* synthetic */ long J$0;
                    private /* synthetic */ Object L$0;
                    int label;

                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    C00821(boolean z, float f, MutableState<Float> mutableState, State<Float> state, Continuation<? super C00821> continuation) {
                        super(3, continuation);
                        this.$isRtl = z;
                        this.$maxPx = f;
                        this.$pressOffset = mutableState;
                        this.$rawOffset = state;
                    }

                    @Override // kotlin.jvm.functions.Function3
                    public /* bridge */ /* synthetic */ Object invoke(PressGestureScope pressGestureScope, Offset offset, Continuation<? super Unit> continuation) {
                        return m1155invoked4ec7I(pressGestureScope, offset.getPackedValue(), continuation);
                    }

                    /* JADX INFO: renamed from: invoke-d-4ec7I, reason: not valid java name */
                    public final Object m1155invoked4ec7I(PressGestureScope pressGestureScope, long j, Continuation<? super Unit> continuation) {
                        C00821 c00821 = new C00821(this.$isRtl, this.$maxPx, this.$pressOffset, this.$rawOffset, continuation);
                        c00821.L$0 = pressGestureScope;
                        c00821.J$0 = j;
                        return c00821.invokeSuspend(Unit.INSTANCE);
                    }

                    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                    public final Object invokeSuspend(Object obj) throws Throwable {
                        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                        int i = this.label;
                        try {
                            if (i == 0) {
                                ResultKt.throwOnFailure(obj);
                                PressGestureScope pressGestureScope = (PressGestureScope) this.L$0;
                                long j = this.J$0;
                                this.$pressOffset.setValue(Boxing.boxFloat((this.$isRtl ? this.$maxPx - Offset.m1395getXimpl(j) : Offset.m1395getXimpl(j)) - this.$rawOffset.getValue().floatValue()));
                                this.label = 1;
                                if (pressGestureScope.awaitRelease(this) == coroutine_suspended) {
                                    return coroutine_suspended;
                                }
                            } else {
                                if (i != 1) {
                                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                                }
                                ResultKt.throwOnFailure(obj);
                            }
                        } catch (GestureCancellationException unused) {
                            this.$pressOffset.setValue(Boxing.boxFloat(0.0f));
                        }
                        return Unit.INSTANCE;
                    }
                }

                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                public final Object invokeSuspend(Object obj) throws Throwable {
                    Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                    int i = this.label;
                    if (i == 0) {
                        ResultKt.throwOnFailure(obj);
                        PointerInputScope pointerInputScope = (PointerInputScope) this.L$0;
                        C00821 c00821 = new C00821(this.$isRtl, this.$maxPx, this.$pressOffset, this.$rawOffset, null);
                        final CoroutineScope coroutineScope = this.$scope;
                        final DraggableState draggableState = this.$draggableState;
                        final State<Function1<Float, Unit>> state = this.$gestureEndAction;
                        this.label = 1;
                        if (TapGestureDetectorKt.detectTapGestures$default(pointerInputScope, null, null, c00821, new Function1<Offset, Unit>() { // from class: androidx.compose.material.SliderKt.sliderTapModifier.2.1.2
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            /* JADX WARN: Multi-variable type inference failed */
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public /* bridge */ /* synthetic */ Unit invoke(Offset offset) {
                                m1156invokek4lQ0M(offset.getPackedValue());
                                return Unit.INSTANCE;
                            }

                            /* JADX INFO: renamed from: invoke-k-4lQ0M, reason: not valid java name */
                            public final void m1156invokek4lQ0M(long j) {
                                BuildersKt__Builders_commonKt.launch$default(coroutineScope, null, null, new C00841(draggableState, state, null), 3, null);
                            }

                            /* JADX INFO: renamed from: androidx.compose.material.SliderKt$sliderTapModifier$2$1$2$1, reason: invalid class name and collision with other inner class name */
                            /* JADX INFO: compiled from: Slider.kt */
                            @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
                            @DebugMetadata(c = "androidx.compose.material.SliderKt$sliderTapModifier$2$1$2$1", f = "Slider.kt", i = {}, l = {894}, m = "invokeSuspend", n = {}, s = {})
                            static final class C00841 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
                                final /* synthetic */ DraggableState $draggableState;
                                final /* synthetic */ State<Function1<Float, Unit>> $gestureEndAction;
                                int label;

                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                /* JADX WARN: Multi-variable type inference failed */
                                C00841(DraggableState draggableState, State<? extends Function1<? super Float, Unit>> state, Continuation<? super C00841> continuation) {
                                    super(2, continuation);
                                    this.$draggableState = draggableState;
                                    this.$gestureEndAction = state;
                                }

                                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                                public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                                    return new C00841(this.$draggableState, this.$gestureEndAction, continuation);
                                }

                                @Override // kotlin.jvm.functions.Function2
                                public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
                                    return ((C00841) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
                                }

                                /* JADX INFO: renamed from: androidx.compose.material.SliderKt$sliderTapModifier$2$1$2$1$1, reason: invalid class name and collision with other inner class name */
                                /* JADX INFO: compiled from: Slider.kt */
                                @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
                                @DebugMetadata(c = "androidx.compose.material.SliderKt$sliderTapModifier$2$1$2$1$1", f = "Slider.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
                                static final class C00851 extends SuspendLambda implements Function2<DragScope, Continuation<? super Unit>, Object> {
                                    private /* synthetic */ Object L$0;
                                    int label;

                                    C00851(Continuation<? super C00851> continuation) {
                                        super(2, continuation);
                                    }

                                    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                                    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                                        C00851 c00851 = new C00851(continuation);
                                        c00851.L$0 = obj;
                                        return c00851;
                                    }

                                    @Override // kotlin.jvm.functions.Function2
                                    public final Object invoke(DragScope dragScope, Continuation<? super Unit> continuation) {
                                        return ((C00851) create(dragScope, continuation)).invokeSuspend(Unit.INSTANCE);
                                    }

                                    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                                    public final Object invokeSuspend(Object obj) throws Throwable {
                                        IntrinsicsKt.getCOROUTINE_SUSPENDED();
                                        if (this.label != 0) {
                                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                                        }
                                        ResultKt.throwOnFailure(obj);
                                        ((DragScope) this.L$0).dragBy(0.0f);
                                        return Unit.INSTANCE;
                                    }
                                }

                                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                                public final Object invokeSuspend(Object obj) throws Throwable {
                                    Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                                    int i = this.label;
                                    if (i == 0) {
                                        ResultKt.throwOnFailure(obj);
                                        this.label = 1;
                                        if (this.$draggableState.drag(MutatePriority.UserInput, new C00851(null), this) == coroutine_suspended) {
                                            return coroutine_suspended;
                                        }
                                    } else {
                                        if (i != 1) {
                                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                                        }
                                        ResultKt.throwOnFailure(obj);
                                    }
                                    this.$gestureEndAction.getValue().invoke(Boxing.boxFloat(0.0f));
                                    return Unit.INSTANCE;
                                }
                            }
                        }, this, 3, null) == coroutine_suspended) {
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
        });
    }

    static {
        float fM3843constructorimpl = Dp.m3843constructorimpl(48);
        SliderHeight = fM3843constructorimpl;
        float fM3843constructorimpl2 = Dp.m3843constructorimpl(144);
        SliderMinWidth = fM3843constructorimpl2;
        DefaultSliderConstraints = SizeKt.m452heightInVpY3zN4$default(SizeKt.m471widthInVpY3zN4$default(Modifier.INSTANCE, fM3843constructorimpl2, 0.0f, 2, null), 0.0f, fM3843constructorimpl, 1, null);
        SliderToTickAnimation = new TweenSpec<>(100, 0, null, 6, null);
    }
}
