package androidx.compose.foundation.lazy;

import androidx.compose.animation.core.FiniteAnimationSpec;
import androidx.compose.foundation.ExperimentalFoundationApi;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.platform.InspectableValueKt;
import androidx.compose.ui.platform.InspectorInfo;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.IntOffset;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: LazyItemScopeImpl.kt */
/* JADX INFO: loaded from: classes10.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0003\b\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u001d\u0010\u0010\u001a\u00020\u0011*\u00020\u00112\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00140\u0013H\u0017ø\u0001\u0000J\u0014\u0010\u0015\u001a\u00020\u0011*\u00020\u00112\u0006\u0010\u0016\u001a\u00020\u0017H\u0016J\u0014\u0010\u0018\u001a\u00020\u0011*\u00020\u00112\u0006\u0010\u0016\u001a\u00020\u0017H\u0016J\u0014\u0010\u0019\u001a\u00020\u0011*\u00020\u00112\u0006\u0010\u0016\u001a\u00020\u0017H\u0016R4\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00048F@FX\u0086\u008e\u0002ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR4\u0010\f\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00048F@FX\u0086\u008e\u0002ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0012\n\u0004\b\u000f\u0010\u000b\u001a\u0004\b\r\u0010\u0007\"\u0004\b\u000e\u0010\t\u0082\u0002\u000f\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006\u001a"}, d2 = {"Landroidx/compose/foundation/lazy/LazyItemScopeImpl;", "Landroidx/compose/foundation/lazy/LazyItemScope;", "()V", "<set-?>", "Landroidx/compose/ui/unit/Dp;", "maxHeight", "getMaxHeight-D9Ej5fM", "()F", "setMaxHeight-0680j_4", "(F)V", "maxHeight$delegate", "Landroidx/compose/runtime/MutableState;", "maxWidth", "getMaxWidth-D9Ej5fM", "setMaxWidth-0680j_4", "maxWidth$delegate", "animateItemPlacement", "Landroidx/compose/ui/Modifier;", "animationSpec", "Landroidx/compose/animation/core/FiniteAnimationSpec;", "Landroidx/compose/ui/unit/IntOffset;", "fillParentMaxHeight", "fraction", "", "fillParentMaxSize", "fillParentMaxWidth", "foundation_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class LazyItemScopeImpl implements LazyItemScope {

    /* JADX INFO: renamed from: maxWidth$delegate, reason: from kotlin metadata */
    private final MutableState maxWidth = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(Dp.m3841boximpl(Dp.INSTANCE.m3863getUnspecifiedD9Ej5fM()), null, 2, null);

    /* JADX INFO: renamed from: maxHeight$delegate, reason: from kotlin metadata */
    private final MutableState maxHeight = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(Dp.m3841boximpl(Dp.INSTANCE.m3863getUnspecifiedD9Ej5fM()), null, 2, null);

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX INFO: renamed from: getMaxWidth-D9Ej5fM, reason: not valid java name */
    public final float m527getMaxWidthD9Ej5fM() {
        return ((Dp) this.maxWidth.getValue()).m3857unboximpl();
    }

    /* JADX INFO: renamed from: setMaxWidth-0680j_4, reason: not valid java name */
    public final void m529setMaxWidth0680j_4(float f) {
        this.maxWidth.setValue(Dp.m3841boximpl(f));
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX INFO: renamed from: getMaxHeight-D9Ej5fM, reason: not valid java name */
    public final float m526getMaxHeightD9Ej5fM() {
        return ((Dp) this.maxHeight.getValue()).m3857unboximpl();
    }

    /* JADX INFO: renamed from: setMaxHeight-0680j_4, reason: not valid java name */
    public final void m528setMaxHeight0680j_4(float f) {
        this.maxHeight.setValue(Dp.m3841boximpl(f));
    }

    @Override // androidx.compose.foundation.lazy.LazyItemScope
    public Modifier fillParentMaxSize(Modifier modifier, float f) {
        Intrinsics.checkNotNullParameter(modifier, "<this>");
        return SizeKt.m466sizeVpY3zN4(modifier, Dp.m3843constructorimpl(m527getMaxWidthD9Ej5fM() * f), Dp.m3843constructorimpl(m526getMaxHeightD9Ej5fM() * f));
    }

    @Override // androidx.compose.foundation.lazy.LazyItemScope
    public Modifier fillParentMaxWidth(Modifier modifier, float f) {
        Intrinsics.checkNotNullParameter(modifier, "<this>");
        return SizeKt.m469width3ABfNKs(modifier, Dp.m3843constructorimpl(m527getMaxWidthD9Ej5fM() * f));
    }

    @Override // androidx.compose.foundation.lazy.LazyItemScope
    public Modifier fillParentMaxHeight(Modifier modifier, float f) {
        Intrinsics.checkNotNullParameter(modifier, "<this>");
        return SizeKt.m450height3ABfNKs(modifier, Dp.m3843constructorimpl(m526getMaxHeightD9Ej5fM() * f));
    }

    @Override // androidx.compose.foundation.lazy.LazyItemScope
    @ExperimentalFoundationApi
    public Modifier animateItemPlacement(Modifier modifier, final FiniteAnimationSpec<IntOffset> animationSpec) {
        Intrinsics.checkNotNullParameter(modifier, "<this>");
        Intrinsics.checkNotNullParameter(animationSpec, "animationSpec");
        return modifier.then(new AnimateItemPlacementModifier(animationSpec, InspectableValueKt.isDebugInspectorInfoEnabled() ? new Function1<InspectorInfo, Unit>() { // from class: androidx.compose.foundation.lazy.LazyItemScopeImpl$animateItemPlacement$$inlined$debugInspectorInfo$1
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
                inspectorInfo.setName("animateItemPlacement");
                inspectorInfo.setValue(animationSpec);
            }
        } : InspectableValueKt.getNoInspectorInfo()));
    }
}
