package androidx.compose.ui.node;

import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import androidx.compose.ui.graphics.AndroidPaint_androidKt;
import androidx.compose.ui.graphics.Canvas;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.GraphicsLayerScope;
import androidx.compose.ui.graphics.Paint;
import androidx.compose.ui.graphics.PaintingStyle;
import androidx.compose.ui.layout.AlignmentLine;
import androidx.compose.ui.layout.HorizontalAlignmentLine;
import androidx.compose.ui.layout.LayoutModifier;
import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.unit.IntOffset;
import androidx.compose.ui.unit.IntSize;
import androidx.compose.ui.unit.LayoutDirection;
import com.json.b9;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: ModifiedLayoutNode.kt */
/* JADX INFO: loaded from: classes8.dex */
@Metadata(d1 = {"\u0000r\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\n\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0000\u0018\u0000 =2\u00020\u0001:\u0001=B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0001\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\u0010\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u001eH\u0016J\u0010\u0010\u001f\u001a\u00020\u001c2\u0006\u0010 \u001a\u00020\u001cH\u0016J\u0010\u0010!\u001a\u00020\u001c2\u0006\u0010\"\u001a\u00020\u001cH\u0016J\u001d\u0010#\u001a\u00020$2\u0006\u0010%\u001a\u00020&H\u0016ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b'\u0010(J\u0010\u0010)\u001a\u00020\u001c2\u0006\u0010 \u001a\u00020\u001cH\u0016J\u0010\u0010*\u001a\u00020\u001c2\u0006\u0010\"\u001a\u00020\u001cH\u0016J\b\u0010+\u001a\u00020\u0004H\u0002J\b\u0010,\u001a\u00020-H\u0016J\b\u0010.\u001a\u00020-H\u0016J\u0010\u0010/\u001a\u00020-2\u0006\u00100\u001a\u000201H\u0016J@\u00102\u001a\u00020-2\u0006\u00103\u001a\u0002042\u0006\u00105\u001a\u0002062\u0019\u00107\u001a\u0015\u0012\u0004\u0012\u000209\u0012\u0004\u0012\u00020-\u0018\u000108¢\u0006\u0002\b:H\u0014ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b;\u0010<R\u0014\u0010\u0006\u001a\u00020\u00078VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\b\u0010\tR\u001a\u0010\u0003\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u0016\u0010\u000e\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u0010\u001a\u00020\u0011X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R$\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0016\u001a\u00020\u0001@VX\u0090\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001a\u0082\u0002\u000b\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001¨\u0006>"}, d2 = {"Landroidx/compose/ui/node/ModifiedLayoutNode;", "Landroidx/compose/ui/node/LayoutNodeWrapper;", "wrapped", "modifier", "Landroidx/compose/ui/layout/LayoutModifier;", "(Landroidx/compose/ui/node/LayoutNodeWrapper;Landroidx/compose/ui/layout/LayoutModifier;)V", "measureScope", "Landroidx/compose/ui/layout/MeasureScope;", "getMeasureScope", "()Landroidx/compose/ui/layout/MeasureScope;", "getModifier", "()Landroidx/compose/ui/layout/LayoutModifier;", "setModifier", "(Landroidx/compose/ui/layout/LayoutModifier;)V", "modifierState", "Landroidx/compose/runtime/MutableState;", "toBeReusedForSameModifier", "", "getToBeReusedForSameModifier", "()Z", "setToBeReusedForSameModifier", "(Z)V", "<set-?>", "getWrapped$ui_release", "()Landroidx/compose/ui/node/LayoutNodeWrapper;", "setWrapped", "(Landroidx/compose/ui/node/LayoutNodeWrapper;)V", "calculateAlignmentLine", "", "alignmentLine", "Landroidx/compose/ui/layout/AlignmentLine;", "maxIntrinsicHeight", "width", "maxIntrinsicWidth", "height", "measure", "Landroidx/compose/ui/layout/Placeable;", "constraints", "Landroidx/compose/ui/unit/Constraints;", "measure-BRTryo0", "(J)Landroidx/compose/ui/layout/Placeable;", "minIntrinsicHeight", "minIntrinsicWidth", "modifierFromState", "onInitialize", "", "onModifierChanged", "performDraw", "canvas", "Landroidx/compose/ui/graphics/Canvas;", "placeAt", b9.h.L, "Landroidx/compose/ui/unit/IntOffset;", "zIndex", "", "layerBlock", "Lkotlin/Function1;", "Landroidx/compose/ui/graphics/GraphicsLayerScope;", "Lkotlin/ExtensionFunctionType;", "placeAt-f8xVGno", "(JFLkotlin/jvm/functions/Function1;)V", "Companion", "ui_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class ModifiedLayoutNode extends LayoutNodeWrapper {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final Paint modifierBoundsPaint;
    private LayoutModifier modifier;
    private MutableState<LayoutModifier> modifierState;
    private boolean toBeReusedForSameModifier;
    private LayoutNodeWrapper wrapped;

    @Override // androidx.compose.ui.node.LayoutNodeWrapper
    /* JADX INFO: renamed from: getWrapped$ui_release, reason: from getter */
    public LayoutNodeWrapper getWrapped() {
        return this.wrapped;
    }

    public void setWrapped(LayoutNodeWrapper layoutNodeWrapper) {
        Intrinsics.checkNotNullParameter(layoutNodeWrapper, "<set-?>");
        this.wrapped = layoutNodeWrapper;
    }

    public final LayoutModifier getModifier() {
        return this.modifier;
    }

    public final void setModifier(LayoutModifier layoutModifier) {
        Intrinsics.checkNotNullParameter(layoutModifier, "<set-?>");
        this.modifier = layoutModifier;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ModifiedLayoutNode(LayoutNodeWrapper wrapped, LayoutModifier modifier) {
        super(wrapped.getLayoutNode());
        Intrinsics.checkNotNullParameter(wrapped, "wrapped");
        Intrinsics.checkNotNullParameter(modifier, "modifier");
        this.wrapped = wrapped;
        this.modifier = modifier;
    }

    @Override // androidx.compose.ui.node.LayoutNodeWrapper
    public MeasureScope getMeasureScope() {
        return getWrapped().getMeasureScope();
    }

    public final boolean getToBeReusedForSameModifier() {
        return this.toBeReusedForSameModifier;
    }

    public final void setToBeReusedForSameModifier(boolean z) {
        this.toBeReusedForSameModifier = z;
    }

    @Override // androidx.compose.ui.node.LayoutNodeWrapper
    public void onInitialize() {
        super.onInitialize();
        getWrapped().setWrappedBy$ui_release(this);
    }

    @Override // androidx.compose.ui.layout.Measurable
    /* JADX INFO: renamed from: measure-BRTryo0 */
    public Placeable mo3124measureBRTryo0(long constraints) {
        ModifiedLayoutNode modifiedLayoutNode = this;
        modifiedLayoutNode.m3165setMeasurementConstraintsBRTryo0(constraints);
        setMeasureResult$ui_release(this.modifier.mo33measure3p2s80s(getMeasureScope(), getWrapped(), constraints));
        ModifiedLayoutNode modifiedLayoutNode2 = this;
        OwnedLayer layer = modifiedLayoutNode.getLayer();
        if (layer != null) {
            layer.mo3294resizeozmzZPI(modifiedLayoutNode.getMeasuredSize());
        }
        onMeasured();
        return modifiedLayoutNode2;
    }

    @Override // androidx.compose.ui.layout.IntrinsicMeasurable
    public int minIntrinsicWidth(int height) {
        return modifierFromState().minIntrinsicWidth(getMeasureScope(), getWrapped(), height);
    }

    @Override // androidx.compose.ui.layout.IntrinsicMeasurable
    public int maxIntrinsicWidth(int height) {
        return modifierFromState().maxIntrinsicWidth(getMeasureScope(), getWrapped(), height);
    }

    @Override // androidx.compose.ui.layout.IntrinsicMeasurable
    public int minIntrinsicHeight(int width) {
        return modifierFromState().minIntrinsicHeight(getMeasureScope(), getWrapped(), width);
    }

    @Override // androidx.compose.ui.layout.IntrinsicMeasurable
    public int maxIntrinsicHeight(int width) {
        return modifierFromState().maxIntrinsicHeight(getMeasureScope(), getWrapped(), width);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.compose.ui.node.LayoutNodeWrapper, androidx.compose.ui.layout.Placeable
    /* JADX INFO: renamed from: placeAt-f8xVGno */
    public void mo3125placeAtf8xVGno(long position, float zIndex, Function1<? super GraphicsLayerScope, Unit> layerBlock) {
        super.mo3125placeAtf8xVGno(position, zIndex, layerBlock);
        LayoutNodeWrapper wrappedBy$ui_release = getWrappedBy();
        if (wrappedBy$ui_release == null || !wrappedBy$ui_release.getIsShallowPlacing()) {
            onPlaced();
            Placeable.PlacementScope.Companion companion = Placeable.PlacementScope.INSTANCE;
            int iM4003getWidthimpl = IntSize.m4003getWidthimpl(getMeasuredSize());
            LayoutDirection layoutDirection = getMeasureScope().getLayoutDirection();
            int parentWidth = Placeable.PlacementScope.INSTANCE.getParentWidth();
            LayoutDirection parentLayoutDirection = Placeable.PlacementScope.INSTANCE.getParentLayoutDirection();
            Placeable.PlacementScope.Companion companion2 = Placeable.PlacementScope.INSTANCE;
            Placeable.PlacementScope.parentWidth = iM4003getWidthimpl;
            Placeable.PlacementScope.Companion companion3 = Placeable.PlacementScope.INSTANCE;
            Placeable.PlacementScope.parentLayoutDirection = layoutDirection;
            getMeasureResult().placeChildren();
            Placeable.PlacementScope.Companion companion4 = Placeable.PlacementScope.INSTANCE;
            Placeable.PlacementScope.parentWidth = parentWidth;
            Placeable.PlacementScope.Companion companion5 = Placeable.PlacementScope.INSTANCE;
            Placeable.PlacementScope.parentLayoutDirection = parentLayoutDirection;
        }
    }

    private final LayoutModifier modifierFromState() {
        MutableState<LayoutModifier> mutableStateMutableStateOf$default = this.modifierState;
        if (mutableStateMutableStateOf$default == null) {
            mutableStateMutableStateOf$default = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(this.modifier, null, 2, null);
        }
        this.modifierState = mutableStateMutableStateOf$default;
        return mutableStateMutableStateOf$default.getValue();
    }

    @Override // androidx.compose.ui.node.LayoutNodeWrapper
    public void onModifierChanged() {
        super.onModifierChanged();
        MutableState<LayoutModifier> mutableState = this.modifierState;
        if (mutableState == null) {
            return;
        }
        mutableState.setValue(this.modifier);
    }

    @Override // androidx.compose.ui.node.LayoutNodeWrapper
    public int calculateAlignmentLine(AlignmentLine alignmentLine) {
        int iM3961getXimpl;
        Intrinsics.checkNotNullParameter(alignmentLine, "alignmentLine");
        if (getMeasureResult().getAlignmentLines().containsKey(alignmentLine)) {
            Integer num = getMeasureResult().getAlignmentLines().get(alignmentLine);
            if (num != null) {
                return num.intValue();
            }
            return Integer.MIN_VALUE;
        }
        int i = getWrapped().get(alignmentLine);
        if (i == Integer.MIN_VALUE) {
            return Integer.MIN_VALUE;
        }
        setShallowPlacing(true);
        mo3125placeAtf8xVGno(getPosition(), getZIndex(), getLayerBlock());
        setShallowPlacing(false);
        if (alignmentLine instanceof HorizontalAlignmentLine) {
            iM3961getXimpl = IntOffset.m3962getYimpl(getWrapped().getPosition());
        } else {
            iM3961getXimpl = IntOffset.m3961getXimpl(getWrapped().getPosition());
        }
        return i + iM3961getXimpl;
    }

    @Override // androidx.compose.ui.node.LayoutNodeWrapper
    public void performDraw(Canvas canvas) {
        Intrinsics.checkNotNullParameter(canvas, "canvas");
        getWrapped().draw(canvas);
        if (LayoutNodeKt.requireOwner(getLayoutNode()).getShowLayoutBounds()) {
            drawBorder(canvas, modifierBoundsPaint);
        }
    }

    /* JADX INFO: compiled from: ModifiedLayoutNode.kt */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0080\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Landroidx/compose/ui/node/ModifiedLayoutNode$Companion;", "", "()V", "modifierBoundsPaint", "Landroidx/compose/ui/graphics/Paint;", "getModifierBoundsPaint", "()Landroidx/compose/ui/graphics/Paint;", "ui_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final Paint getModifierBoundsPaint() {
            return ModifiedLayoutNode.modifierBoundsPaint;
        }
    }

    static {
        Paint Paint = AndroidPaint_androidKt.Paint();
        Paint.mo1515setColor8_81llA(Color.INSTANCE.m1658getBlue0d7_KjU());
        Paint.setStrokeWidth(1.0f);
        Paint.mo1519setStylek9PVt8s(PaintingStyle.INSTANCE.m1862getStrokeTiuSbCo());
        modifierBoundsPaint = Paint;
    }
}
