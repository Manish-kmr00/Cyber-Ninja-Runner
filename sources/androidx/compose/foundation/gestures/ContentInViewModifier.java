package androidx.compose.foundation.gestures;

import androidx.compose.foundation.FocusedBoundsKt;
import androidx.compose.foundation.relocation.BringIntoViewResponder;
import androidx.compose.foundation.relocation.BringIntoViewResponderKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.geometry.RectKt;
import androidx.compose.ui.geometry.Size;
import androidx.compose.ui.layout.LayoutCoordinates;
import androidx.compose.ui.layout.OnPlacedModifier;
import androidx.compose.ui.layout.OnRemeasuredModifier;
import androidx.compose.ui.unit.IntSize;
import androidx.compose.ui.unit.IntSizeKt;
import com.json.c9;
import io.ktor.http.ContentDisposition;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: compiled from: Scrollable.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0013\n\u0002\u0010\u0007\n\u0002\b\u0004\b\u0002\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003B%\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b¢\u0006\u0002\u0010\fJ\u0019\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u0019H\u0096@ø\u0001\u0000¢\u0006\u0002\u0010\u001aJ\u0010\u0010\u001b\u001a\u00020\u00192\u0006\u0010\u0018\u001a\u00020\u0019H\u0016J%\u0010\u001c\u001a\u00020\u00192\u0006\u0010\u001d\u001a\u00020\u00192\u0006\u0010\u001e\u001a\u00020\u0015H\u0002ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u001f\u0010 J\u0010\u0010!\u001a\u00020\u00172\u0006\u0010\r\u001a\u00020\u000eH\u0016J\u001d\u0010\"\u001a\u00020\u00172\u0006\u0010#\u001a\u00020\u0015H\u0016ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b$\u0010%J%\u0010&\u001a\u00020\u00172\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u0014\u001a\u00020\u0015H\u0002ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b'\u0010(J!\u0010)\u001a\u00020\u00172\u0006\u0010\u001d\u001a\u00020\u00192\u0006\u0010*\u001a\u00020\u0019H\u0082@ø\u0001\u0000¢\u0006\u0002\u0010+J \u0010,\u001a\u00020-2\u0006\u0010.\u001a\u00020-2\u0006\u0010/\u001a\u00020-2\u0006\u00100\u001a\u00020-H\u0002R\u0010\u0010\r\u001a\u0004\u0018\u00010\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u0011\u0010\u0010\u001a\u00020\u0011¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0019\u0010\u0014\u001a\u0004\u0018\u00010\u0015X\u0082\u000eø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000\u0082\u0002\u000f\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u00061"}, d2 = {"Landroidx/compose/foundation/gestures/ContentInViewModifier;", "Landroidx/compose/foundation/relocation/BringIntoViewResponder;", "Landroidx/compose/ui/layout/OnRemeasuredModifier;", "Landroidx/compose/ui/layout/OnPlacedModifier;", "scope", "Lkotlinx/coroutines/CoroutineScope;", "orientation", "Landroidx/compose/foundation/gestures/Orientation;", "scrollableState", "Landroidx/compose/foundation/gestures/ScrollableState;", "reverseDirection", "", "(Lkotlinx/coroutines/CoroutineScope;Landroidx/compose/foundation/gestures/Orientation;Landroidx/compose/foundation/gestures/ScrollableState;Z)V", c9.COORDINATES, "Landroidx/compose/ui/layout/LayoutCoordinates;", "focusedChild", "modifier", "Landroidx/compose/ui/Modifier;", "getModifier", "()Landroidx/compose/ui/Modifier;", "oldSize", "Landroidx/compose/ui/unit/IntSize;", "bringChildIntoView", "", "localRect", "Landroidx/compose/ui/geometry/Rect;", "(Landroidx/compose/ui/geometry/Rect;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "calculateRectForParent", "computeDestination", "source", "intSize", "computeDestination-O0kMr_c", "(Landroidx/compose/ui/geometry/Rect;J)Landroidx/compose/ui/geometry/Rect;", "onPlaced", "onRemeasured", ContentDisposition.Parameters.Size, "onRemeasured-ozmzZPI", "(J)V", "onSizeChanged", "onSizeChanged-O0kMr_c", "(Landroidx/compose/ui/layout/LayoutCoordinates;J)V", "performBringIntoView", "destination", "(Landroidx/compose/ui/geometry/Rect;Landroidx/compose/ui/geometry/Rect;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "relocationDistance", "", "leadingEdge", "trailingEdge", "parentSize", "foundation_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
final class ContentInViewModifier implements BringIntoViewResponder, OnRemeasuredModifier, OnPlacedModifier {
    private LayoutCoordinates coordinates;
    private LayoutCoordinates focusedChild;
    private final Modifier modifier;
    private IntSize oldSize;
    private final Orientation orientation;
    private final boolean reverseDirection;
    private final CoroutineScope scope;
    private final ScrollableState scrollableState;

    /* JADX INFO: compiled from: Scrollable.kt */
    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[Orientation.values().length];
            iArr[Orientation.Vertical.ordinal()] = 1;
            iArr[Orientation.Horizontal.ordinal()] = 2;
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public ContentInViewModifier(CoroutineScope scope, Orientation orientation, ScrollableState scrollableState, boolean z) {
        Intrinsics.checkNotNullParameter(scope, "scope");
        Intrinsics.checkNotNullParameter(orientation, "orientation");
        Intrinsics.checkNotNullParameter(scrollableState, "scrollableState");
        this.scope = scope;
        this.orientation = orientation;
        this.scrollableState = scrollableState;
        this.reverseDirection = z;
        this.modifier = BringIntoViewResponderKt.bringIntoViewResponder(FocusedBoundsKt.onFocusedBoundsChanged(this, new Function1<LayoutCoordinates, Unit>() { // from class: androidx.compose.foundation.gestures.ContentInViewModifier$modifier$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(LayoutCoordinates layoutCoordinates) {
                invoke2(layoutCoordinates);
                return Unit.INSTANCE;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(LayoutCoordinates layoutCoordinates) {
                this.this$0.focusedChild = layoutCoordinates;
            }
        }), this);
    }

    public final Modifier getModifier() {
        return this.modifier;
    }

    @Override // androidx.compose.ui.layout.OnRemeasuredModifier
    /* JADX INFO: renamed from: onRemeasured-ozmzZPI, reason: not valid java name */
    public void mo251onRemeasuredozmzZPI(long size) {
        LayoutCoordinates layoutCoordinates = this.coordinates;
        IntSize intSize = this.oldSize;
        if (intSize != null && !IntSize.m4001equalsimpl0(intSize.getPackedValue(), size) && layoutCoordinates != null && layoutCoordinates.isAttached()) {
            m250onSizeChangedO0kMr_c(layoutCoordinates, intSize.getPackedValue());
        }
        this.oldSize = IntSize.m3995boximpl(size);
    }

    @Override // androidx.compose.ui.layout.OnPlacedModifier
    public void onPlaced(LayoutCoordinates coordinates) {
        Intrinsics.checkNotNullParameter(coordinates, "coordinates");
        this.coordinates = coordinates;
    }

    @Override // androidx.compose.foundation.relocation.BringIntoViewResponder
    public Rect calculateRectForParent(Rect localRect) {
        Intrinsics.checkNotNullParameter(localRect, "localRect");
        IntSize intSize = this.oldSize;
        if (intSize == null) {
            throw new IllegalStateException("Expected BringIntoViewRequester to not be used before parents are placed.".toString());
        }
        return m249computeDestinationO0kMr_c(localRect, intSize.getPackedValue());
    }

    @Override // androidx.compose.foundation.relocation.BringIntoViewResponder
    public Object bringChildIntoView(Rect rect, Continuation<? super Unit> continuation) {
        Object objPerformBringIntoView = performBringIntoView(rect, calculateRectForParent(rect), continuation);
        return objPerformBringIntoView == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objPerformBringIntoView : Unit.INSTANCE;
    }

    /* JADX INFO: renamed from: onSizeChanged-O0kMr_c, reason: not valid java name */
    private final void m250onSizeChangedO0kMr_c(LayoutCoordinates coordinates, long oldSize) {
        Rect rectLocalBoundingBoxOf;
        if (this.orientation == Orientation.Horizontal) {
            if (IntSize.m4003getWidthimpl(coordinates.mo3126getSizeYbymL2g()) >= IntSize.m4003getWidthimpl(oldSize)) {
                return;
            }
        } else if (IntSize.m4002getHeightimpl(coordinates.mo3126getSizeYbymL2g()) >= IntSize.m4002getHeightimpl(oldSize)) {
            return;
        }
        LayoutCoordinates layoutCoordinates = this.focusedChild;
        if (layoutCoordinates == null || (rectLocalBoundingBoxOf = coordinates.localBoundingBoxOf(layoutCoordinates, false)) == null) {
            return;
        }
        Rect rectM1435Recttz77jQw = RectKt.m1435Recttz77jQw(Offset.INSTANCE.m1411getZeroF1C5BW0(), IntSizeKt.m4013toSizeozmzZPI(oldSize));
        Rect rectM249computeDestinationO0kMr_c = m249computeDestinationO0kMr_c(rectLocalBoundingBoxOf, coordinates.mo3126getSizeYbymL2g());
        boolean zOverlaps = rectM1435Recttz77jQw.overlaps(rectLocalBoundingBoxOf);
        boolean zAreEqual = Intrinsics.areEqual(rectM249computeDestinationO0kMr_c, rectLocalBoundingBoxOf);
        if (!zOverlaps || zAreEqual) {
            return;
        }
        BuildersKt__Builders_commonKt.launch$default(this.scope, null, null, new ContentInViewModifier$onSizeChanged$1(this, rectLocalBoundingBoxOf, rectM249computeDestinationO0kMr_c, null), 3, null);
    }

    /* JADX INFO: renamed from: computeDestination-O0kMr_c, reason: not valid java name */
    private final Rect m249computeDestinationO0kMr_c(Rect source, long intSize) {
        long jM4013toSizeozmzZPI = IntSizeKt.m4013toSizeozmzZPI(intSize);
        int i = WhenMappings.$EnumSwitchMapping$0[this.orientation.ordinal()];
        if (i == 1) {
            return source.translate(0.0f, relocationDistance(source.getTop(), source.getBottom(), Size.m1461getHeightimpl(jM4013toSizeozmzZPI)));
        }
        if (i == 2) {
            return source.translate(relocationDistance(source.getLeft(), source.getRight(), Size.m1464getWidthimpl(jM4013toSizeozmzZPI)), 0.0f);
        }
        throw new NoWhenBranchMatchedException();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object performBringIntoView(Rect rect, Rect rect2, Continuation<? super Unit> continuation) {
        float top;
        float top2;
        int i = WhenMappings.$EnumSwitchMapping$0[this.orientation.ordinal()];
        if (i == 1) {
            top = rect.getTop();
            top2 = rect2.getTop();
        } else {
            if (i != 2) {
                throw new NoWhenBranchMatchedException();
            }
            top = rect.getLeft();
            top2 = rect2.getLeft();
        }
        float f = top - top2;
        if (this.reverseDirection) {
            f = -f;
        }
        Object objAnimateScrollBy$default = ScrollExtensionsKt.animateScrollBy$default(this.scrollableState, f, null, continuation, 2, null);
        return objAnimateScrollBy$default == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objAnimateScrollBy$default : Unit.INSTANCE;
    }

    private final float relocationDistance(float leadingEdge, float trailingEdge, float parentSize) {
        if ((leadingEdge >= 0.0f && trailingEdge <= parentSize) || (leadingEdge < 0.0f && trailingEdge > parentSize)) {
            return 0.0f;
        }
        float f = trailingEdge - parentSize;
        return Math.abs(leadingEdge) < Math.abs(f) ? leadingEdge : f;
    }
}
