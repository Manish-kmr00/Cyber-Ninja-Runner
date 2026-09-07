package androidx.compose.ui.node;

import androidx.compose.runtime.collection.MutableVector;
import androidx.compose.ui.graphics.GraphicsLayerScope;
import androidx.compose.ui.layout.AlignmentLine;
import androidx.compose.ui.layout.Measurable;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.IntOffset;
import androidx.compose.ui.unit.IntSize;
import androidx.compose.ui.unit.IntSizeKt;
import com.json.b9;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: OuterMeasurablePlaceable.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(d1 = {"\u0000d\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\b\n\u0002\b\n\n\u0002\u0010\u0000\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u001b\b\u0000\u0018\u00002\u00020\u00012\u00020\u0002B\u0015\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\u0011\u0010-\u001a\u00020\u001d2\u0006\u0010.\u001a\u00020/H\u0096\u0002J\u000e\u00100\u001a\u00020\u00152\u0006\u00101\u001a\u00020\tJ\u0010\u00102\u001a\u00020\u001d2\u0006\u00103\u001a\u00020\u001dH\u0016J\u0010\u00104\u001a\u00020\u001d2\u0006\u00105\u001a\u00020\u001dH\u0016J\u001d\u00106\u001a\u00020\u00022\u0006\u00107\u001a\u00020\u000fH\u0016ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b8\u00109J\u0010\u0010:\u001a\u00020\u001d2\u0006\u00103\u001a\u00020\u001dH\u0016J\u0010\u0010;\u001a\u00020\u001d2\u0006\u00105\u001a\u00020\u001dH\u0016J\b\u0010<\u001a\u00020\u0015H\u0002J@\u0010=\u001a\u00020\u00152\u0006\u0010>\u001a\u00020\u00182\u0006\u0010?\u001a\u00020\u001b2\u0019\u0010@\u001a\u0015\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\u0015\u0018\u00010\u0013¢\u0006\u0002\b\u0016H\u0014ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\bA\u0010BJ@\u0010C\u001a\u00020\u00152\u0006\u0010>\u001a\u00020\u00182\u0006\u0010?\u001a\u00020\u001b2\u0019\u0010@\u001a\u0015\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\u0015\u0018\u00010\u0013¢\u0006\u0002\b\u0016H\u0002ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\bD\u0010BJ\u0006\u0010E\u001a\u00020\u0015J\u001b\u0010F\u001a\u00020\t2\u0006\u00107\u001a\u00020\u000fø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\bG\u0010HJ\u0006\u0010I\u001a\u00020\u0015R\u001a\u0010\b\u001a\u00020\tX\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u001c\u0010\u000e\u001a\u0004\u0018\u00010\u000f8Fø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0006\u001a\u0004\b\u0010\u0010\u0011R!\u0010\u0012\u001a\u0015\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\u0015\u0018\u00010\u0013¢\u0006\u0002\b\u0016X\u0082\u000e¢\u0006\u0002\n\u0000R\u0019\u0010\u0017\u001a\u00020\u0018X\u0082\u000eø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0004\n\u0002\u0010\u0019R\u000e\u0010\u001a\u001a\u00020\u001bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u001c\u001a\u00020\u001d8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u001e\u0010\u001fR\u000e\u0010 \u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010!\u001a\u00020\u001d8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\"\u0010\u001fR\u001a\u0010\u0005\u001a\u00020\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b#\u0010$\"\u0004\b%\u0010&R\"\u0010)\u001a\u0004\u0018\u00010(2\b\u0010'\u001a\u0004\u0018\u00010(@RX\u0096\u000e¢\u0006\b\n\u0000\u001a\u0004\b*\u0010+R\u000e\u0010,\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000\u0082\u0002\u000f\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006J"}, d2 = {"Landroidx/compose/ui/node/OuterMeasurablePlaceable;", "Landroidx/compose/ui/layout/Measurable;", "Landroidx/compose/ui/layout/Placeable;", "layoutNode", "Landroidx/compose/ui/node/LayoutNode;", "outerWrapper", "Landroidx/compose/ui/node/LayoutNodeWrapper;", "(Landroidx/compose/ui/node/LayoutNode;Landroidx/compose/ui/node/LayoutNodeWrapper;)V", "duringAlignmentLinesQuery", "", "getDuringAlignmentLinesQuery$ui_release", "()Z", "setDuringAlignmentLinesQuery$ui_release", "(Z)V", "lastConstraints", "Landroidx/compose/ui/unit/Constraints;", "getLastConstraints-DWUhwKw", "()Landroidx/compose/ui/unit/Constraints;", "lastLayerBlock", "Lkotlin/Function1;", "Landroidx/compose/ui/graphics/GraphicsLayerScope;", "", "Lkotlin/ExtensionFunctionType;", "lastPosition", "Landroidx/compose/ui/unit/IntOffset;", "J", "lastZIndex", "", "measuredHeight", "", "getMeasuredHeight", "()I", "measuredOnce", "measuredWidth", "getMeasuredWidth", "getOuterWrapper", "()Landroidx/compose/ui/node/LayoutNodeWrapper;", "setOuterWrapper", "(Landroidx/compose/ui/node/LayoutNodeWrapper;)V", "<set-?>", "", "parentData", "getParentData", "()Ljava/lang/Object;", "placedOnce", "get", "alignmentLine", "Landroidx/compose/ui/layout/AlignmentLine;", "invalidateIntrinsicsParent", "forceRequest", "maxIntrinsicHeight", "width", "maxIntrinsicWidth", "height", "measure", "constraints", "measure-BRTryo0", "(J)Landroidx/compose/ui/layout/Placeable;", "minIntrinsicHeight", "minIntrinsicWidth", "onIntrinsicsQueried", "placeAt", b9.h.L, "zIndex", "layerBlock", "placeAt-f8xVGno", "(JFLkotlin/jvm/functions/Function1;)V", "placeOuterWrapper", "placeOuterWrapper-f8xVGno", "recalculateParentData", "remeasure", "remeasure-BRTryo0", "(J)Z", "replace", "ui_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class OuterMeasurablePlaceable extends Placeable implements Measurable {
    private boolean duringAlignmentLinesQuery;
    private Function1<? super GraphicsLayerScope, Unit> lastLayerBlock;
    private long lastPosition;
    private float lastZIndex;
    private final LayoutNode layoutNode;
    private boolean measuredOnce;
    private LayoutNodeWrapper outerWrapper;
    private Object parentData;
    private boolean placedOnce;

    /* JADX INFO: compiled from: OuterMeasurablePlaceable.kt */
    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;
        public static final /* synthetic */ int[] $EnumSwitchMapping$1;

        static {
            int[] iArr = new int[LayoutNode.LayoutState.values().length];
            iArr[LayoutNode.LayoutState.Measuring.ordinal()] = 1;
            iArr[LayoutNode.LayoutState.LayingOut.ordinal()] = 2;
            $EnumSwitchMapping$0 = iArr;
            int[] iArr2 = new int[LayoutNode.UsageByParent.values().length];
            iArr2[LayoutNode.UsageByParent.InMeasureBlock.ordinal()] = 1;
            iArr2[LayoutNode.UsageByParent.InLayoutBlock.ordinal()] = 2;
            $EnumSwitchMapping$1 = iArr2;
        }
    }

    public final LayoutNodeWrapper getOuterWrapper() {
        return this.outerWrapper;
    }

    public final void setOuterWrapper(LayoutNodeWrapper layoutNodeWrapper) {
        Intrinsics.checkNotNullParameter(layoutNodeWrapper, "<set-?>");
        this.outerWrapper = layoutNodeWrapper;
    }

    public OuterMeasurablePlaceable(LayoutNode layoutNode, LayoutNodeWrapper outerWrapper) {
        Intrinsics.checkNotNullParameter(layoutNode, "layoutNode");
        Intrinsics.checkNotNullParameter(outerWrapper, "outerWrapper");
        this.layoutNode = layoutNode;
        this.outerWrapper = outerWrapper;
        this.lastPosition = IntOffset.INSTANCE.m3971getZeronOccac();
    }

    /* JADX INFO: renamed from: getLastConstraints-DWUhwKw, reason: not valid java name */
    public final Constraints m3289getLastConstraintsDWUhwKw() {
        if (this.measuredOnce) {
            return Constraints.m3787boximpl(getMeasurementConstraints());
        }
        return null;
    }

    /* JADX INFO: renamed from: getDuringAlignmentLinesQuery$ui_release, reason: from getter */
    public final boolean getDuringAlignmentLinesQuery() {
        return this.duringAlignmentLinesQuery;
    }

    public final void setDuringAlignmentLinesQuery$ui_release(boolean z) {
        this.duringAlignmentLinesQuery = z;
    }

    @Override // androidx.compose.ui.layout.Measured, androidx.compose.ui.layout.IntrinsicMeasurable
    public Object getParentData() {
        return this.parentData;
    }

    @Override // androidx.compose.ui.layout.Measurable
    /* JADX INFO: renamed from: measure-BRTryo0 */
    public Placeable mo3124measureBRTryo0(long constraints) {
        LayoutNode.UsageByParent usageByParent;
        LayoutNode parent$ui_release = this.layoutNode.getParent$ui_release();
        if (parent$ui_release == null) {
            this.layoutNode.setMeasuredByParent$ui_release(LayoutNode.UsageByParent.NotUsed);
        } else {
            if (this.layoutNode.getMeasuredByParent() != LayoutNode.UsageByParent.NotUsed && !this.layoutNode.getCanMultiMeasure()) {
                throw new IllegalStateException(("measure() may not be called multiple times on the same Measurable. Current state " + this.layoutNode.getMeasuredByParent() + ". Parent state " + parent$ui_release.getLayoutState() + '.').toString());
            }
            LayoutNode layoutNode = this.layoutNode;
            int i = WhenMappings.$EnumSwitchMapping$0[parent$ui_release.getLayoutState().ordinal()];
            if (i == 1) {
                usageByParent = LayoutNode.UsageByParent.InMeasureBlock;
            } else {
                if (i != 2) {
                    throw new IllegalStateException("Measurable could be only measured from the parent's measure or layout block.Parents state is " + parent$ui_release.getLayoutState());
                }
                usageByParent = LayoutNode.UsageByParent.InLayoutBlock;
            }
            layoutNode.setMeasuredByParent$ui_release(usageByParent);
        }
        m3290remeasureBRTryo0(constraints);
        return this;
    }

    /* JADX INFO: renamed from: remeasure-BRTryo0, reason: not valid java name */
    public final boolean m3290remeasureBRTryo0(long constraints) {
        Owner ownerRequireOwner = LayoutNodeKt.requireOwner(this.layoutNode);
        LayoutNode parent$ui_release = this.layoutNode.getParent$ui_release();
        LayoutNode layoutNode = this.layoutNode;
        boolean z = true;
        layoutNode.setCanMultiMeasure$ui_release(layoutNode.getCanMultiMeasure() || (parent$ui_release != null && parent$ui_release.getCanMultiMeasure()));
        if (this.layoutNode.getMeasurePending() || !Constraints.m3792equalsimpl0(getMeasurementConstraints(), constraints)) {
            this.layoutNode.getAlignmentLines().setUsedByModifierMeasurement$ui_release(false);
            MutableVector<LayoutNode> mutableVector = this.layoutNode.get_children$ui_release();
            int size = mutableVector.getSize();
            if (size > 0) {
                LayoutNode[] content = mutableVector.getContent();
                int i = 0;
                do {
                    content[i].getAlignmentLines().setUsedDuringParentMeasurement$ui_release(false);
                    i++;
                } while (i < size);
            }
            this.measuredOnce = true;
            long jMo3126getSizeYbymL2g = this.outerWrapper.mo3126getSizeYbymL2g();
            m3165setMeasurementConstraintsBRTryo0(constraints);
            this.layoutNode.m3251performMeasureBRTryo0$ui_release(constraints);
            if (IntSize.m4001equalsimpl0(this.outerWrapper.mo3126getSizeYbymL2g(), jMo3126getSizeYbymL2g) && this.outerWrapper.getWidth() == getWidth() && this.outerWrapper.getHeight() == getHeight()) {
                z = false;
            }
            m3164setMeasuredSizeozmzZPI(IntSizeKt.IntSize(this.outerWrapper.getWidth(), this.outerWrapper.getHeight()));
            return z;
        }
        ownerRequireOwner.forceMeasureTheSubtree(this.layoutNode);
        this.layoutNode.resetSubtreeIntrinsicsUsage$ui_release();
        return false;
    }

    @Override // androidx.compose.ui.layout.Placeable, androidx.compose.ui.layout.Measured
    public int getMeasuredWidth() {
        return this.outerWrapper.getMeasuredWidth();
    }

    @Override // androidx.compose.ui.layout.Placeable, androidx.compose.ui.layout.Measured
    public int getMeasuredHeight() {
        return this.outerWrapper.getMeasuredHeight();
    }

    @Override // androidx.compose.ui.layout.Measured
    public int get(AlignmentLine alignmentLine) {
        Intrinsics.checkNotNullParameter(alignmentLine, "alignmentLine");
        LayoutNode parent$ui_release = this.layoutNode.getParent$ui_release();
        if ((parent$ui_release != null ? parent$ui_release.getLayoutState() : null) == LayoutNode.LayoutState.Measuring) {
            this.layoutNode.getAlignmentLines().setUsedDuringParentMeasurement$ui_release(true);
        } else {
            LayoutNode parent$ui_release2 = this.layoutNode.getParent$ui_release();
            if ((parent$ui_release2 != null ? parent$ui_release2.getLayoutState() : null) == LayoutNode.LayoutState.LayingOut) {
                this.layoutNode.getAlignmentLines().setUsedDuringParentLayout$ui_release(true);
            }
        }
        this.duringAlignmentLinesQuery = true;
        int i = this.outerWrapper.get(alignmentLine);
        this.duringAlignmentLinesQuery = false;
        return i;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.compose.ui.layout.Placeable
    /* JADX INFO: renamed from: placeAt-f8xVGno */
    public void mo3125placeAtf8xVGno(final long position, final float zIndex, final Function1<? super GraphicsLayerScope, Unit> layerBlock) {
        this.lastPosition = position;
        this.lastZIndex = zIndex;
        this.lastLayerBlock = layerBlock;
        LayoutNodeWrapper wrappedBy = this.outerWrapper.getWrappedBy();
        if (wrappedBy != null && wrappedBy.getIsShallowPlacing()) {
            m3288placeOuterWrapperf8xVGno(position, zIndex, layerBlock);
            return;
        }
        this.placedOnce = true;
        this.layoutNode.getAlignmentLines().setUsedByModifierLayout$ui_release(false);
        LayoutNodeKt.requireOwner(this.layoutNode).getSnapshotObserver().observeLayoutModifierSnapshotReads$ui_release(this.layoutNode, new Function0<Unit>() { // from class: androidx.compose.ui.node.OuterMeasurablePlaceable$placeAt$1
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
                this.this$0.m3288placeOuterWrapperf8xVGno(position, zIndex, layerBlock);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: placeOuterWrapper-f8xVGno, reason: not valid java name */
    public final void m3288placeOuterWrapperf8xVGno(long position, float zIndex, Function1<? super GraphicsLayerScope, Unit> layerBlock) {
        Placeable.PlacementScope.Companion companion = Placeable.PlacementScope.INSTANCE;
        if (layerBlock == null) {
            companion.m3170place70tqf50(this.outerWrapper, position, zIndex);
        } else {
            companion.m3175placeWithLayeraW9wM(this.outerWrapper, position, zIndex, layerBlock);
        }
    }

    public final void replace() {
        if (!this.placedOnce) {
            throw new IllegalStateException("Check failed.".toString());
        }
        mo3125placeAtf8xVGno(this.lastPosition, this.lastZIndex, this.lastLayerBlock);
    }

    @Override // androidx.compose.ui.layout.IntrinsicMeasurable
    public int minIntrinsicWidth(int height) {
        onIntrinsicsQueried();
        return this.outerWrapper.minIntrinsicWidth(height);
    }

    @Override // androidx.compose.ui.layout.IntrinsicMeasurable
    public int maxIntrinsicWidth(int height) {
        onIntrinsicsQueried();
        return this.outerWrapper.maxIntrinsicWidth(height);
    }

    @Override // androidx.compose.ui.layout.IntrinsicMeasurable
    public int minIntrinsicHeight(int width) {
        onIntrinsicsQueried();
        return this.outerWrapper.minIntrinsicHeight(width);
    }

    @Override // androidx.compose.ui.layout.IntrinsicMeasurable
    public int maxIntrinsicHeight(int width) {
        onIntrinsicsQueried();
        return this.outerWrapper.maxIntrinsicHeight(width);
    }

    private final void onIntrinsicsQueried() {
        LayoutNode.UsageByParent intrinsicsUsageByParent;
        LayoutNode.requestRemeasure$ui_release$default(this.layoutNode, false, 1, null);
        LayoutNode parent$ui_release = this.layoutNode.getParent$ui_release();
        if (parent$ui_release == null || this.layoutNode.getIntrinsicsUsageByParent() != LayoutNode.UsageByParent.NotUsed) {
            return;
        }
        LayoutNode layoutNode = this.layoutNode;
        int i = WhenMappings.$EnumSwitchMapping$0[parent$ui_release.getLayoutState().ordinal()];
        if (i == 1) {
            intrinsicsUsageByParent = LayoutNode.UsageByParent.InMeasureBlock;
        } else if (i == 2) {
            intrinsicsUsageByParent = LayoutNode.UsageByParent.InLayoutBlock;
        } else {
            intrinsicsUsageByParent = parent$ui_release.getIntrinsicsUsageByParent();
        }
        layoutNode.setIntrinsicsUsageByParent$ui_release(intrinsicsUsageByParent);
    }

    public final void invalidateIntrinsicsParent(boolean forceRequest) {
        LayoutNode parent$ui_release;
        LayoutNode parent$ui_release2 = this.layoutNode.getParent$ui_release();
        LayoutNode.UsageByParent intrinsicsUsageByParent = this.layoutNode.getIntrinsicsUsageByParent();
        if (parent$ui_release2 == null || intrinsicsUsageByParent == LayoutNode.UsageByParent.NotUsed) {
            return;
        }
        while (parent$ui_release2.getIntrinsicsUsageByParent() == intrinsicsUsageByParent && (parent$ui_release = parent$ui_release2.getParent$ui_release()) != null) {
            parent$ui_release2 = parent$ui_release;
        }
        int i = WhenMappings.$EnumSwitchMapping$1[intrinsicsUsageByParent.ordinal()];
        if (i == 1) {
            parent$ui_release2.requestRemeasure$ui_release(forceRequest);
        } else {
            if (i == 2) {
                parent$ui_release2.requestRelayout$ui_release(forceRequest);
                return;
            }
            throw new IllegalStateException("Intrinsics isn't used by the parent".toString());
        }
    }

    public final void recalculateParentData() {
        this.parentData = this.outerWrapper.getParentData();
    }
}
