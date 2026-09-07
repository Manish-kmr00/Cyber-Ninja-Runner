package androidx.compose.foundation.lazy.grid;

import androidx.compose.foundation.gestures.Orientation;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.ConstraintsKt;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.LayoutDirection;
import com.safedk.android.analytics.reporters.b;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;
import kotlin.ranges.IntRange;
import kotlin.ranges.RangesKt;

/* JADX INFO: compiled from: LazyGridMeasure.kt */
/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000\u0084\u0001\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u001ap\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u00012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\u00072\u0006\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u00112\u0006\u0010\u0012\u001a\u00020\r2\u0006\u0010\u0013\u001a\u00020\u0014H\u0002\u001aÒ\u0001\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00072\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u00072\u0006\u0010\u001d\u001a\u00020\u00072\u0006\u0010\u001e\u001a\u00020\u00072\u0006\u0010\u001f\u001a\u00020\u00072\u0006\u0010 \u001a\u00020!2\u0006\u0010\"\u001a\u00020\u00072\u0006\u0010#\u001a\u00020$2\u0006\u0010%\u001a\u00020&2\u0006\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u00112\u0006\u0010\u0012\u001a\u00020\r2\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010'\u001a\u00020(2/\u0010)\u001a+\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u0007\u0012\u0015\u0012\u0013\u0012\u0004\u0012\u00020,\u0012\u0004\u0012\u00020-0+¢\u0006\u0002\b.\u0012\u0004\u0012\u00020/0*H\u0000ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b0\u00101\u0082\u0002\u000b\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001¨\u00062"}, d2 = {"calculateItemsOffsets", "", "Landroidx/compose/foundation/lazy/grid/LazyGridPositionedItem;", b.d, "", "Landroidx/compose/foundation/lazy/grid/LazyMeasuredLine;", "layoutWidth", "", "layoutHeight", "finalMainAxisOffset", "maxOffset", "firstLineScrollOffset", "isVertical", "", "verticalArrangement", "Landroidx/compose/foundation/layout/Arrangement$Vertical;", "horizontalArrangement", "Landroidx/compose/foundation/layout/Arrangement$Horizontal;", "reverseLayout", "density", "Landroidx/compose/ui/unit/Density;", "measureLazyGrid", "Landroidx/compose/foundation/lazy/grid/LazyGridMeasureResult;", "itemsCount", "measuredLineProvider", "Landroidx/compose/foundation/lazy/grid/LazyMeasuredLineProvider;", "measuredItemProvider", "Landroidx/compose/foundation/lazy/grid/LazyMeasuredItemProvider;", "mainAxisAvailableSize", "slotsPerLine", "beforeContentPadding", "afterContentPadding", "firstVisibleLineIndex", "Landroidx/compose/foundation/lazy/grid/LineIndex;", "firstVisibleLineScrollOffset", "scrollToBeConsumed", "", "constraints", "Landroidx/compose/ui/unit/Constraints;", "placementAnimator", "Landroidx/compose/foundation/lazy/grid/LazyGridItemPlacementAnimator;", "layout", "Lkotlin/Function3;", "Lkotlin/Function1;", "Landroidx/compose/ui/layout/Placeable$PlacementScope;", "", "Lkotlin/ExtensionFunctionType;", "Landroidx/compose/ui/layout/MeasureResult;", "measureLazyGrid-zIfe3eg", "(ILandroidx/compose/foundation/lazy/grid/LazyMeasuredLineProvider;Landroidx/compose/foundation/lazy/grid/LazyMeasuredItemProvider;IIIIIIFJZLandroidx/compose/foundation/layout/Arrangement$Vertical;Landroidx/compose/foundation/layout/Arrangement$Horizontal;ZLandroidx/compose/ui/unit/Density;Landroidx/compose/foundation/lazy/grid/LazyGridItemPlacementAnimator;Lkotlin/jvm/functions/Function3;)Landroidx/compose/foundation/lazy/grid/LazyGridMeasureResult;", "foundation_release"}, k = 2, mv = {1, 6, 0}, xi = 48)
public final class LazyGridMeasureKt {
    private static final int calculateItemsOffsets$reverseAware(int i, boolean z, int i2) {
        return !z ? i : (i2 - i) - 1;
    }

    /* JADX INFO: renamed from: measureLazyGrid-zIfe3eg, reason: not valid java name */
    public static final LazyGridMeasureResult m598measureLazyGridzIfe3eg(int i, LazyMeasuredLineProvider lazyMeasuredLineProvider, LazyMeasuredItemProvider measuredItemProvider, int i2, int i3, int i4, int i5, int i6, int i7, float f, long j, boolean z, Arrangement.Vertical vertical, Arrangement.Horizontal horizontal, boolean z2, Density density, LazyGridItemPlacementAnimator placementAnimator, Function3<? super Integer, ? super Integer, ? super Function1<? super Placeable.PlacementScope, Unit>, ? extends MeasureResult> layout) {
        int i8;
        int i9;
        int iM620constructorimpl;
        int i10;
        LazyMeasuredLine lazyMeasuredLine;
        int i11;
        int iM3813constrainWidthK40F9xA;
        int iM3798getMaxHeightimpl;
        LazyMeasuredLineProvider measuredLineProvider = lazyMeasuredLineProvider;
        Intrinsics.checkNotNullParameter(measuredLineProvider, "measuredLineProvider");
        Intrinsics.checkNotNullParameter(measuredItemProvider, "measuredItemProvider");
        Intrinsics.checkNotNullParameter(density, "density");
        Intrinsics.checkNotNullParameter(placementAnimator, "placementAnimator");
        Intrinsics.checkNotNullParameter(layout, "layout");
        if (i4 < 0) {
            throw new IllegalArgumentException("Failed requirement.".toString());
        }
        if (i5 < 0) {
            throw new IllegalArgumentException("Failed requirement.".toString());
        }
        if (i <= 0) {
            return new LazyGridMeasureResult(null, 0, false, 0.0f, layout.invoke(Integer.valueOf(Constraints.m3801getMinWidthimpl(j)), Integer.valueOf(Constraints.m3800getMinHeightimpl(j)), new Function1<Placeable.PlacementScope, Unit>() { // from class: androidx.compose.foundation.lazy.grid.LazyGridMeasureKt$measureLazyGrid$1
                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(Placeable.PlacementScope invoke) {
                    Intrinsics.checkNotNullParameter(invoke, "$this$invoke");
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(Placeable.PlacementScope placementScope) {
                    invoke2(placementScope);
                    return Unit.INSTANCE;
                }
            }), CollectionsKt.emptyList(), -i4, i2 + i5, 0, z2, z ? Orientation.Vertical : Orientation.Horizontal, i5);
        }
        int iRoundToInt = MathKt.roundToInt(f);
        int i12 = i7 - iRoundToInt;
        int iM620constructorimpl2 = i6;
        if (LineIndex.m623equalsimpl0(iM620constructorimpl2, LineIndex.m620constructorimpl(0)) && i12 < 0) {
            iRoundToInt += i12;
            i12 = 0;
        }
        ArrayList arrayList = new ArrayList();
        int mainAxisSizeWithSpacings = i12 - i4;
        int i13 = -i4;
        while (mainAxisSizeWithSpacings < 0 && iM620constructorimpl2 - LineIndex.m620constructorimpl(0) > 0) {
            iM620constructorimpl2 = LineIndex.m620constructorimpl(iM620constructorimpl2 - 1);
            LazyMeasuredLine lazyMeasuredLineM616getAndMeasurebKFJvoY = measuredLineProvider.m616getAndMeasurebKFJvoY(iM620constructorimpl2);
            arrayList.add(0, lazyMeasuredLineM616getAndMeasurebKFJvoY);
            mainAxisSizeWithSpacings += lazyMeasuredLineM616getAndMeasurebKFJvoY.getMainAxisSizeWithSpacings();
        }
        if (mainAxisSizeWithSpacings < i13) {
            i8 = iRoundToInt + mainAxisSizeWithSpacings;
            i9 = i13;
        } else {
            int i14 = mainAxisSizeWithSpacings;
            i8 = iRoundToInt;
            i9 = i14;
        }
        int i15 = i9 + i4;
        int i16 = i2 + i5;
        int i17 = iM620constructorimpl2;
        int iCoerceAtLeast = RangesKt.coerceAtLeast(i16, 0);
        int mainAxisSizeWithSpacings2 = -i15;
        int size = arrayList.size();
        int iM620constructorimpl3 = i17;
        int i18 = i16;
        for (int i19 = 0; i19 < size; i19++) {
            LazyMeasuredLine lazyMeasuredLine2 = (LazyMeasuredLine) arrayList.get(i19);
            iM620constructorimpl3 = LineIndex.m620constructorimpl(iM620constructorimpl3 + 1);
            mainAxisSizeWithSpacings2 += lazyMeasuredLine2.getMainAxisSizeWithSpacings();
        }
        int mainAxisSizeWithSpacings3 = i15;
        int iM620constructorimpl4 = iM620constructorimpl3;
        while (true) {
            if (mainAxisSizeWithSpacings2 > iCoerceAtLeast && !arrayList.isEmpty()) {
                break;
            }
            int i20 = iCoerceAtLeast;
            LazyMeasuredLine lazyMeasuredLineM616getAndMeasurebKFJvoY2 = measuredLineProvider.m616getAndMeasurebKFJvoY(iM620constructorimpl4);
            if (!lazyMeasuredLineM616getAndMeasurebKFJvoY2.isEmpty()) {
                int i21 = i13;
                int i22 = i18;
                mainAxisSizeWithSpacings2 += lazyMeasuredLineM616getAndMeasurebKFJvoY2.getMainAxisSizeWithSpacings();
                if (mainAxisSizeWithSpacings2 > i21 || ((LazyMeasuredItem) ArraysKt.last(lazyMeasuredLineM616getAndMeasurebKFJvoY2.getItems())).getIndex() == i - 1) {
                    arrayList.add(lazyMeasuredLineM616getAndMeasurebKFJvoY2);
                    iM620constructorimpl = i17;
                } else {
                    iM620constructorimpl = LineIndex.m620constructorimpl(iM620constructorimpl4 + 1);
                    mainAxisSizeWithSpacings3 -= lazyMeasuredLineM616getAndMeasurebKFJvoY2.getMainAxisSizeWithSpacings();
                }
                iM620constructorimpl4 = LineIndex.m620constructorimpl(iM620constructorimpl4 + 1);
                i17 = iM620constructorimpl;
                i13 = i21;
                iCoerceAtLeast = i20;
                i18 = i22;
                measuredLineProvider = lazyMeasuredLineProvider;
            } else {
                LineIndex.m620constructorimpl(iM620constructorimpl4 - 1);
                break;
            }
        }
        if (mainAxisSizeWithSpacings2 < i2) {
            int i23 = i2 - mainAxisSizeWithSpacings2;
            mainAxisSizeWithSpacings3 -= i23;
            mainAxisSizeWithSpacings2 += i23;
            int iM620constructorimpl5 = i17;
            while (true) {
                if (mainAxisSizeWithSpacings3 >= i4) {
                    i10 = 0;
                    break;
                }
                if (iM620constructorimpl5 - LineIndex.m620constructorimpl(0) <= 0) {
                    i10 = 0;
                    break;
                }
                iM620constructorimpl5 = LineIndex.m620constructorimpl(iM620constructorimpl5 - 1);
                int i24 = i13;
                LazyMeasuredLine lazyMeasuredLineM616getAndMeasurebKFJvoY3 = measuredLineProvider.m616getAndMeasurebKFJvoY(iM620constructorimpl5);
                arrayList.add(0, lazyMeasuredLineM616getAndMeasurebKFJvoY3);
                mainAxisSizeWithSpacings3 += lazyMeasuredLineM616getAndMeasurebKFJvoY3.getMainAxisSizeWithSpacings();
                i13 = i24;
            }
            i8 += i23;
            if (mainAxisSizeWithSpacings3 < 0) {
                i8 += mainAxisSizeWithSpacings3;
                mainAxisSizeWithSpacings2 += mainAxisSizeWithSpacings3;
                mainAxisSizeWithSpacings3 = i10;
            }
        } else {
            i13 = i13;
            i10 = 0;
        }
        float f2 = (MathKt.getSign(MathKt.roundToInt(f)) != MathKt.getSign(i8) || Math.abs(MathKt.roundToInt(f)) < Math.abs(i8)) ? f : i8;
        int i25 = -mainAxisSizeWithSpacings3;
        LazyMeasuredLine lazyMeasuredLine3 = (LazyMeasuredLine) CollectionsKt.first((List) arrayList);
        if (i4 > 0) {
            int size2 = arrayList.size();
            int i26 = mainAxisSizeWithSpacings3;
            LazyMeasuredLine lazyMeasuredLine4 = lazyMeasuredLine3;
            int i27 = i10;
            while (i27 < size2) {
                int mainAxisSizeWithSpacings4 = ((LazyMeasuredLine) arrayList.get(i27)).getMainAxisSizeWithSpacings();
                if (i26 == 0 || mainAxisSizeWithSpacings4 > i26 || i27 == CollectionsKt.getLastIndex(arrayList)) {
                    break;
                }
                i26 -= mainAxisSizeWithSpacings4;
                i27++;
                lazyMeasuredLine4 = (LazyMeasuredLine) arrayList.get(i27);
            }
            lazyMeasuredLine = lazyMeasuredLine4;
            i11 = i26;
        } else {
            lazyMeasuredLine = lazyMeasuredLine3;
            i11 = mainAxisSizeWithSpacings3;
        }
        if (z) {
            iM3813constrainWidthK40F9xA = Constraints.m3799getMaxWidthimpl(j);
        } else {
            iM3813constrainWidthK40F9xA = ConstraintsKt.m3813constrainWidthK40F9xA(j, mainAxisSizeWithSpacings2);
        }
        int i28 = iM3813constrainWidthK40F9xA;
        if (z) {
            iM3798getMaxHeightimpl = ConstraintsKt.m3812constrainHeightK40F9xA(j, mainAxisSizeWithSpacings2);
        } else {
            iM3798getMaxHeightimpl = Constraints.m3798getMaxHeightimpl(j);
        }
        int i29 = iM3798getMaxHeightimpl;
        int i30 = i18;
        float f3 = f2;
        int i31 = i13;
        final List<LazyGridPositionedItem> listCalculateItemsOffsets = calculateItemsOffsets(arrayList, i28, i29, mainAxisSizeWithSpacings2, i2, i25, z, vertical, horizontal, z2, density);
        int i32 = mainAxisSizeWithSpacings2;
        placementAnimator.onMeasured((int) f3, i28, i29, i3, z2, listCalculateItemsOffsets, measuredItemProvider);
        return new LazyGridMeasureResult(lazyMeasuredLine, i11, i32 > i2, f3, layout.invoke(Integer.valueOf(i28), Integer.valueOf(i29), new Function1<Placeable.PlacementScope, Unit>() { // from class: androidx.compose.foundation.lazy.grid.LazyGridMeasureKt$measureLazyGrid$3
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Placeable.PlacementScope placementScope) {
                invoke2(placementScope);
                return Unit.INSTANCE;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Placeable.PlacementScope invoke) {
                Intrinsics.checkNotNullParameter(invoke, "$this$invoke");
                List<LazyGridPositionedItem> list = listCalculateItemsOffsets;
                int size3 = list.size();
                for (int i33 = 0; i33 < size3; i33++) {
                    list.get(i33).place(invoke);
                }
            }
        }), listCalculateItemsOffsets, i31, i30, i, z2, z ? Orientation.Vertical : Orientation.Horizontal, i5);
    }

    private static final List<LazyGridPositionedItem> calculateItemsOffsets(List<LazyMeasuredLine> list, int i, int i2, int i3, int i4, int i5, boolean z, Arrangement.Vertical vertical, Arrangement.Horizontal horizontal, boolean z2, Density density) {
        int i6 = z ? i2 : i;
        boolean z3 = i3 < Math.min(i6, i4);
        if (z3 && i5 != 0) {
            throw new IllegalStateException("Check failed.".toString());
        }
        int size = list.size();
        int length = 0;
        for (int i7 = 0; i7 < size; i7++) {
            length += list.get(i7).getItems().length;
        }
        ArrayList arrayList = new ArrayList(length);
        if (z3) {
            int size2 = list.size();
            int[] iArr = new int[size2];
            for (int i8 = 0; i8 < size2; i8++) {
                iArr[i8] = list.get(calculateItemsOffsets$reverseAware(i8, z2, size2)).getMainAxisSize();
            }
            int[] iArr2 = new int[size2];
            for (int i9 = 0; i9 < size2; i9++) {
                iArr2[i9] = 0;
            }
            if (z) {
                if (vertical == null) {
                    throw new IllegalArgumentException("Required value was null.".toString());
                }
                vertical.arrange(density, i6, iArr, iArr2);
            } else {
                if (horizontal == null) {
                    throw new IllegalArgumentException("Required value was null.".toString());
                }
                horizontal.arrange(density, i6, iArr, LayoutDirection.Ltr, iArr2);
            }
            IntRange indices = ArraysKt.getIndices(iArr2);
            if (z2) {
                indices = RangesKt.reversed(indices);
            }
            int first = indices.getFirst();
            int last = indices.getLast();
            int step = indices.getStep();
            if ((step > 0 && first <= last) || (step < 0 && last <= first)) {
                while (true) {
                    int mainAxisSize = iArr2[first];
                    LazyMeasuredLine lazyMeasuredLine = list.get(calculateItemsOffsets$reverseAware(first, z2, size2));
                    if (z2) {
                        mainAxisSize = (i6 - mainAxisSize) - lazyMeasuredLine.getMainAxisSize();
                    }
                    arrayList.addAll(lazyMeasuredLine.position(mainAxisSize, i, i2));
                    if (first == last) {
                        break;
                    }
                    first += step;
                }
            }
        } else {
            int size3 = list.size();
            int mainAxisSizeWithSpacings = i5;
            for (int i10 = 0; i10 < size3; i10++) {
                LazyMeasuredLine lazyMeasuredLine2 = list.get(i10);
                arrayList.addAll(lazyMeasuredLine2.position(mainAxisSizeWithSpacings, i, i2));
                mainAxisSizeWithSpacings += lazyMeasuredLine2.getMainAxisSizeWithSpacings();
            }
        }
        return arrayList;
    }
}
