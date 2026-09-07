package androidx.compose.foundation.lazy.grid;

import androidx.compose.animation.core.FiniteAnimationSpec;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.IntOffset;
import androidx.compose.ui.unit.IntOffsetKt;
import androidx.compose.ui.unit.IntSize;
import com.pubmatic.sdk.nativead.POBNativeConstants;
import com.yandex.div.core.timer.TimerController;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: compiled from: LazyGridItemPlacementAnimator.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0010\b\n\u0000\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010#\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0015\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\b\u0000\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006JM\u0010\u0018\u001a\u00020\t2\u0006\u0010\u0019\u001a\u00020\t2\u0006\u0010\u001a\u001a\u00020\t2\u0006\u0010\u001b\u001a\u00020\t2\u0006\u0010\u001c\u001a\u00020\u00152\u0006\u0010\u001d\u001a\u00020\u00052\u0006\u0010\u001e\u001a\u00020\t2\u0006\u0010\u001f\u001a\u00020\tH\u0002ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b \u0010!J;\u0010\"\u001a\u00020\u00152\u0006\u0010#\u001a\u00020\u00012\u0006\u0010$\u001a\u00020\t2\u0006\u0010%\u001a\u00020\t2\u0006\u0010&\u001a\u00020\t2\u0006\u0010'\u001a\u00020\u0015ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b(\u0010)JD\u0010*\u001a\u00020+2\u0006\u0010,\u001a\u00020\t2\u0006\u0010-\u001a\u00020\t2\u0006\u0010.\u001a\u00020\t2\u0006\u0010\u000f\u001a\u00020\t2\u0006\u0010\u001d\u001a\u00020\u00052\f\u0010/\u001a\b\u0012\u0004\u0012\u000201002\u0006\u00102\u001a\u000203J\u0006\u00104\u001a\u00020+J\u0018\u00105\u001a\u00020+2\u0006\u00106\u001a\u0002012\u0006\u00107\u001a\u00020\fH\u0002J\u001c\u00108\u001a\u00020\u0015*\u00020\tH\u0002ø\u0001\u0000ø\u0001\u0002ø\u0001\u0001¢\u0006\u0004\b9\u0010:R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\t0\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\f0\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00010\u000eX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u0010\u0014\u001a\u00020\t*\u00020\u00158BX\u0082\u0004ø\u0001\u0000¢\u0006\u0006\u001a\u0004\b\u0016\u0010\u0017\u0082\u0002\u000f\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006;"}, d2 = {"Landroidx/compose/foundation/lazy/grid/LazyGridItemPlacementAnimator;", "", "scope", "Lkotlinx/coroutines/CoroutineScope;", "isVertical", "", "(Lkotlinx/coroutines/CoroutineScope;Z)V", "keyToIndexMap", "", "", "keyToItemInfoMap", "", "Landroidx/compose/foundation/lazy/grid/ItemInfo;", "positionedKeys", "", "slotsPerLine", "viewportEndItemIndex", "viewportEndItemNotVisiblePartSize", "viewportStartItemIndex", "viewportStartItemNotVisiblePartSize", "mainAxis", "Landroidx/compose/ui/unit/IntOffset;", "getMainAxis--gyyYBs", "(J)I", "calculateExpectedOffset", "index", "mainAxisSizeWithSpacings", "averageLineMainAxisSize", "scrolledBy", "reverseLayout", "mainAxisLayoutSize", POBNativeConstants.NATIVE_FALLBACK_URL, "calculateExpectedOffset-tGxSNXI", "(IIIJZII)I", "getAnimatedOffset", "key", "placeableIndex", "minOffset", "maxOffset", "rawOffset", "getAnimatedOffset-YT5a7pE", "(Ljava/lang/Object;IIIJ)J", "onMeasured", "", "consumedScroll", "layoutWidth", "layoutHeight", "positionedItems", "", "Landroidx/compose/foundation/lazy/grid/LazyGridPositionedItem;", "measuredItemProvider", "Landroidx/compose/foundation/lazy/grid/LazyMeasuredItemProvider;", TimerController.RESET_COMMAND, "startAnimationsIfNeeded", "item", "itemInfo", "toOffset", "toOffset-Bjo55l4", "(I)J", "foundation_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class LazyGridItemPlacementAnimator {
    private final boolean isVertical;
    private Map<Object, Integer> keyToIndexMap;
    private final Map<Object, ItemInfo> keyToItemInfoMap;
    private final Set<Object> positionedKeys;
    private final CoroutineScope scope;
    private int slotsPerLine;
    private int viewportEndItemIndex;
    private int viewportEndItemNotVisiblePartSize;
    private int viewportStartItemIndex;
    private int viewportStartItemNotVisiblePartSize;

    public LazyGridItemPlacementAnimator(CoroutineScope scope, boolean z) {
        Intrinsics.checkNotNullParameter(scope, "scope");
        this.scope = scope;
        this.isVertical = z;
        this.keyToItemInfoMap = new LinkedHashMap();
        this.keyToIndexMap = MapsKt.emptyMap();
        this.viewportStartItemIndex = -1;
        this.viewportEndItemIndex = -1;
        this.positionedKeys = new LinkedHashSet();
    }

    /* JADX INFO: renamed from: getAnimatedOffset-YT5a7pE, reason: not valid java name */
    public final long m592getAnimatedOffsetYT5a7pE(Object key, int placeableIndex, int minOffset, int maxOffset, long rawOffset) {
        Intrinsics.checkNotNullParameter(key, "key");
        ItemInfo itemInfo = this.keyToItemInfoMap.get(key);
        if (itemInfo == null) {
            return rawOffset;
        }
        PlaceableInfo placeableInfo = itemInfo.getPlaceables().get(placeableIndex);
        long packedValue = placeableInfo.getAnimatedOffset().getValue().getPackedValue();
        long notAnimatableDelta = itemInfo.getNotAnimatableDelta();
        long jIntOffset = IntOffsetKt.IntOffset(IntOffset.m3961getXimpl(packedValue) + IntOffset.m3961getXimpl(notAnimatableDelta), IntOffset.m3962getYimpl(packedValue) + IntOffset.m3962getYimpl(notAnimatableDelta));
        long targetOffset = placeableInfo.getTargetOffset();
        long notAnimatableDelta2 = itemInfo.getNotAnimatableDelta();
        long jIntOffset2 = IntOffsetKt.IntOffset(IntOffset.m3961getXimpl(targetOffset) + IntOffset.m3961getXimpl(notAnimatableDelta2), IntOffset.m3962getYimpl(targetOffset) + IntOffset.m3962getYimpl(notAnimatableDelta2));
        if (placeableInfo.getInProgress() && ((m590getMainAxisgyyYBs(jIntOffset2) < minOffset && m590getMainAxisgyyYBs(jIntOffset) < minOffset) || (m590getMainAxisgyyYBs(jIntOffset2) > maxOffset && m590getMainAxisgyyYBs(jIntOffset) > maxOffset))) {
            BuildersKt__Builders_commonKt.launch$default(this.scope, null, null, new LazyGridItemPlacementAnimator$getAnimatedOffset$1(placeableInfo, null), 3, null);
        }
        return jIntOffset;
    }

    public final void reset() {
        this.keyToItemInfoMap.clear();
        this.keyToIndexMap = MapsKt.emptyMap();
        this.viewportStartItemIndex = -1;
        this.viewportStartItemNotVisiblePartSize = 0;
        this.viewportEndItemIndex = -1;
        this.viewportEndItemNotVisiblePartSize = 0;
    }

    /* JADX INFO: renamed from: calculateExpectedOffset-tGxSNXI, reason: not valid java name */
    private final int m589calculateExpectedOffsettGxSNXI(int index, int mainAxisSizeWithSpacings, int averageLineMainAxisSize, long scrolledBy, boolean reverseLayout, int mainAxisLayoutSize, int fallback) {
        if (this.slotsPerLine == 0) {
            throw new IllegalArgumentException("Failed requirement.".toString());
        }
        boolean z = false;
        int i = this.viewportEndItemIndex;
        boolean z2 = reverseLayout ? i > index : i < index;
        if (reverseLayout ? this.viewportStartItemIndex < index : this.viewportStartItemIndex > index) {
            z = true;
        }
        if (z2) {
            int iAbs = Math.abs(index - this.viewportEndItemIndex);
            int i2 = this.slotsPerLine;
            return mainAxisLayoutSize + this.viewportEndItemNotVisiblePartSize + (averageLineMainAxisSize * ((((iAbs + i2) - 1) / i2) - 1)) + m590getMainAxisgyyYBs(scrolledBy);
        }
        if (!z) {
            return fallback;
        }
        int iAbs2 = Math.abs(this.viewportStartItemIndex - index);
        int i3 = this.slotsPerLine;
        return ((this.viewportStartItemNotVisiblePartSize - mainAxisSizeWithSpacings) - (averageLineMainAxisSize * ((((iAbs2 + i3) - 1) / i3) - 1))) + m590getMainAxisgyyYBs(scrolledBy);
    }

    /* JADX WARN: Code duplicated, block: B:16:0x00da  */
    private final void startAnimationsIfNeeded(LazyGridPositionedItem item, ItemInfo itemInfo) {
        while (itemInfo.getPlaceables().size() > item.getPlaceablesCount()) {
            CollectionsKt.removeLast(itemInfo.getPlaceables());
        }
        while (itemInfo.getPlaceables().size() < item.getPlaceablesCount()) {
            int size = itemInfo.getPlaceables().size();
            long jMo587getOffsetnOccac = item.getOffset();
            List<PlaceableInfo> placeables = itemInfo.getPlaceables();
            long notAnimatableDelta = itemInfo.getNotAnimatableDelta();
            placeables.add(new PlaceableInfo(IntOffsetKt.IntOffset(IntOffset.m3961getXimpl(jMo587getOffsetnOccac) - IntOffset.m3961getXimpl(notAnimatableDelta), IntOffset.m3962getYimpl(jMo587getOffsetnOccac) - IntOffset.m3962getYimpl(notAnimatableDelta)), item.getMainAxisSize(size), null));
        }
        List<PlaceableInfo> placeables2 = itemInfo.getPlaceables();
        int size2 = placeables2.size();
        for (int i = 0; i < size2; i++) {
            PlaceableInfo placeableInfo = placeables2.get(i);
            long targetOffset = placeableInfo.getTargetOffset();
            long notAnimatableDelta2 = itemInfo.getNotAnimatableDelta();
            long jIntOffset = IntOffsetKt.IntOffset(IntOffset.m3961getXimpl(targetOffset) + IntOffset.m3961getXimpl(notAnimatableDelta2), IntOffset.m3962getYimpl(targetOffset) + IntOffset.m3962getYimpl(notAnimatableDelta2));
            long jM601getPlaceableOffsetnOccac = item.getPlaceableOffset();
            placeableInfo.setMainAxisSize(item.getMainAxisSize(i));
            FiniteAnimationSpec<IntOffset> animationSpec = item.getAnimationSpec(i);
            if (!IntOffset.m3960equalsimpl0(jIntOffset, jM601getPlaceableOffsetnOccac)) {
                long notAnimatableDelta3 = itemInfo.getNotAnimatableDelta();
                placeableInfo.m632setTargetOffsetgyyYBs(IntOffsetKt.IntOffset(IntOffset.m3961getXimpl(jM601getPlaceableOffsetnOccac) - IntOffset.m3961getXimpl(notAnimatableDelta3), IntOffset.m3962getYimpl(jM601getPlaceableOffsetnOccac) - IntOffset.m3962getYimpl(notAnimatableDelta3)));
                if (animationSpec != null) {
                    placeableInfo.setInProgress(true);
                    BuildersKt__Builders_commonKt.launch$default(this.scope, null, null, new LazyGridItemPlacementAnimator$startAnimationsIfNeeded$1$1(placeableInfo, animationSpec, null), 3, null);
                }
            }
        }
    }

    /* JADX INFO: renamed from: toOffset-Bjo55l4, reason: not valid java name */
    private final long m591toOffsetBjo55l4(int i) {
        boolean z = this.isVertical;
        int i2 = z ? 0 : i;
        if (!z) {
            i = 0;
        }
        return IntOffsetKt.IntOffset(i2, i);
    }

    /* JADX INFO: renamed from: getMainAxis--gyyYBs, reason: not valid java name */
    private final int m590getMainAxisgyyYBs(long j) {
        return this.isVertical ? IntOffset.m3962getYimpl(j) : IntOffset.m3961getXimpl(j);
    }

    public final void onMeasured(int consumedScroll, int layoutWidth, int layoutHeight, int slotsPerLine, boolean reverseLayout, final List<LazyGridPositionedItem> positionedItems, LazyMeasuredItemProvider measuredItemProvider) {
        boolean z;
        boolean z2;
        long jM3808fixedHeightOenEA2s;
        int iM590getMainAxisgyyYBs;
        int iM589calculateExpectedOffsettGxSNXI;
        long jM3957copyiSbpLlY$default;
        Intrinsics.checkNotNullParameter(positionedItems, "positionedItems");
        Intrinsics.checkNotNullParameter(measuredItemProvider, "measuredItemProvider");
        int size = positionedItems.size();
        for (int i = 0; i < size; i++) {
            if (positionedItems.get(i).getHasAnimations()) {
                this.slotsPerLine = slotsPerLine;
                int i2 = this.isVertical ? layoutHeight : layoutWidth;
                long jM591toOffsetBjo55l4 = m591toOffsetBjo55l4(reverseLayout ? -consumedScroll : consumedScroll);
                LazyGridPositionedItem lazyGridPositionedItem = (LazyGridPositionedItem) CollectionsKt.first((List) positionedItems);
                LazyGridPositionedItem lazyGridPositionedItem2 = (LazyGridPositionedItem) CollectionsKt.last((List) positionedItems);
                int size2 = positionedItems.size();
                for (int i3 = 0; i3 < size2; i3++) {
                    LazyGridPositionedItem lazyGridPositionedItem3 = positionedItems.get(i3);
                    ItemInfo itemInfo = this.keyToItemInfoMap.get(lazyGridPositionedItem3.getKey());
                    if (itemInfo != null) {
                        itemInfo.setIndex(lazyGridPositionedItem3.getIndex());
                        itemInfo.setCrossAxisSize(lazyGridPositionedItem3.getCrossAxisSize());
                        itemInfo.setCrossAxisOffset(lazyGridPositionedItem3.getCrossAxisOffset());
                    }
                }
                Function1<Integer, Integer> function1 = new Function1<Integer, Integer>() { // from class: androidx.compose.foundation.lazy.grid.LazyGridItemPlacementAnimator$onMeasured$averageLineMainAxisSize$1$lineOf$1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Integer invoke(Integer num) {
                        return invoke(num.intValue());
                    }

                    public final Integer invoke(int i4) {
                        return Integer.valueOf(this.$this_run.isVertical ? positionedItems.get(i4).getRow() : positionedItems.get(i4).getColumn());
                    }
                };
                int i4 = 0;
                int i5 = 0;
                int i6 = 0;
                while (i4 < positionedItems.size()) {
                    int iIntValue = function1.invoke(Integer.valueOf(i4)).intValue();
                    if (iIntValue == -1) {
                        i4++;
                    } else {
                        int iMax = 0;
                        while (i4 < positionedItems.size() && function1.invoke(Integer.valueOf(i4)).intValue() == iIntValue) {
                            iMax = Math.max(iMax, positionedItems.get(i4).getMainAxisSizeWithSpacings());
                            i4++;
                        }
                        i5 += iMax;
                        i6++;
                    }
                }
                int i7 = i5 / i6;
                this.positionedKeys.clear();
                int size3 = positionedItems.size();
                int i8 = 0;
                while (i8 < size3) {
                    LazyGridPositionedItem lazyGridPositionedItem4 = positionedItems.get(i8);
                    this.positionedKeys.add(lazyGridPositionedItem4.getKey());
                    ItemInfo itemInfo2 = this.keyToItemInfoMap.get(lazyGridPositionedItem4.getKey());
                    if (itemInfo2 == null) {
                        if (lazyGridPositionedItem4.getHasAnimations()) {
                            ItemInfo itemInfo3 = new ItemInfo(lazyGridPositionedItem4.getIndex(), lazyGridPositionedItem4.getCrossAxisSize(), lazyGridPositionedItem4.getCrossAxisOffset());
                            Integer num = this.keyToIndexMap.get(lazyGridPositionedItem4.getKey());
                            long jM601getPlaceableOffsetnOccac = lazyGridPositionedItem4.getPlaceableOffset();
                            if (num == null) {
                                iM589calculateExpectedOffsettGxSNXI = m590getMainAxisgyyYBs(jM601getPlaceableOffsetnOccac);
                            } else {
                                if (!reverseLayout) {
                                    iM590getMainAxisgyyYBs = m590getMainAxisgyyYBs(jM601getPlaceableOffsetnOccac);
                                } else {
                                    iM590getMainAxisgyyYBs = m590getMainAxisgyyYBs(jM601getPlaceableOffsetnOccac) - lazyGridPositionedItem4.getMainAxisSizeWithSpacings();
                                }
                                iM589calculateExpectedOffsettGxSNXI = m589calculateExpectedOffsettGxSNXI(num.intValue(), lazyGridPositionedItem4.getMainAxisSizeWithSpacings(), i7, jM591toOffsetBjo55l4, reverseLayout, i2, iM590getMainAxisgyyYBs);
                            }
                            if (this.isVertical) {
                                jM3957copyiSbpLlY$default = IntOffset.m3957copyiSbpLlY$default(jM601getPlaceableOffsetnOccac, 0, iM589calculateExpectedOffsettGxSNXI, 1, null);
                            } else {
                                jM3957copyiSbpLlY$default = IntOffset.m3957copyiSbpLlY$default(jM601getPlaceableOffsetnOccac, iM589calculateExpectedOffsettGxSNXI, 0, 2, null);
                            }
                            int placeablesCount = lazyGridPositionedItem4.getPlaceablesCount();
                            for (int i9 = 0; i9 < placeablesCount; i9++) {
                                itemInfo3.getPlaceables().add(new PlaceableInfo(jM3957copyiSbpLlY$default, lazyGridPositionedItem4.getMainAxisSize(i9), null));
                                Unit unit = Unit.INSTANCE;
                            }
                            this.keyToItemInfoMap.put(lazyGridPositionedItem4.getKey(), itemInfo3);
                            startAnimationsIfNeeded(lazyGridPositionedItem4, itemInfo3);
                        } else {
                            i8 = i8;
                            size3 = size3;
                        }
                    } else {
                        i8 = i8;
                        size3 = size3;
                        if (lazyGridPositionedItem4.getHasAnimations()) {
                            long notAnimatableDelta = itemInfo2.getNotAnimatableDelta();
                            itemInfo2.m580setNotAnimatableDeltagyyYBs(IntOffsetKt.IntOffset(IntOffset.m3961getXimpl(notAnimatableDelta) + IntOffset.m3961getXimpl(jM591toOffsetBjo55l4), IntOffset.m3962getYimpl(notAnimatableDelta) + IntOffset.m3962getYimpl(jM591toOffsetBjo55l4)));
                            startAnimationsIfNeeded(lazyGridPositionedItem4, itemInfo2);
                        } else {
                            this.keyToItemInfoMap.remove(lazyGridPositionedItem4.getKey());
                        }
                    }
                    i8++;
                    size3 = size3;
                }
                if (!reverseLayout) {
                    this.viewportStartItemIndex = lazyGridPositionedItem.getIndex();
                    this.viewportStartItemNotVisiblePartSize = m590getMainAxisgyyYBs(lazyGridPositionedItem.getOffset());
                    this.viewportEndItemIndex = lazyGridPositionedItem2.getIndex();
                    this.viewportEndItemNotVisiblePartSize = (m590getMainAxisgyyYBs(lazyGridPositionedItem2.getOffset()) + lazyGridPositionedItem2.getLineMainAxisSizeWithSpacings()) - i2;
                } else {
                    this.viewportStartItemIndex = lazyGridPositionedItem2.getIndex();
                    this.viewportStartItemNotVisiblePartSize = (i2 - m590getMainAxisgyyYBs(lazyGridPositionedItem2.getOffset())) - lazyGridPositionedItem2.getLineMainAxisSize();
                    this.viewportEndItemIndex = lazyGridPositionedItem.getIndex();
                    this.viewportEndItemNotVisiblePartSize = (-m590getMainAxisgyyYBs(lazyGridPositionedItem.getOffset())) + (lazyGridPositionedItem.getLineMainAxisSizeWithSpacings() - (this.isVertical ? IntSize.m4002getHeightimpl(lazyGridPositionedItem.getSize()) : IntSize.m4003getWidthimpl(lazyGridPositionedItem.getSize())));
                }
                Iterator<Map.Entry<Object, ItemInfo>> it = this.keyToItemInfoMap.entrySet().iterator();
                while (it.hasNext()) {
                    Map.Entry<Object, ItemInfo> next = it.next();
                    if (!this.positionedKeys.contains(next.getKey())) {
                        ItemInfo value = next.getValue();
                        long notAnimatableDelta2 = value.getNotAnimatableDelta();
                        value.m580setNotAnimatableDeltagyyYBs(IntOffsetKt.IntOffset(IntOffset.m3961getXimpl(notAnimatableDelta2) + IntOffset.m3961getXimpl(jM591toOffsetBjo55l4), IntOffset.m3962getYimpl(notAnimatableDelta2) + IntOffset.m3962getYimpl(jM591toOffsetBjo55l4)));
                        Integer num2 = measuredItemProvider.getKeyToIndexMap().get(next.getKey());
                        List<PlaceableInfo> placeables = value.getPlaceables();
                        int size4 = placeables.size();
                        int i10 = 0;
                        while (true) {
                            if (i10 >= size4) {
                                z = false;
                                break;
                            }
                            PlaceableInfo placeableInfo = placeables.get(i10);
                            long targetOffset = placeableInfo.getTargetOffset();
                            long notAnimatableDelta3 = value.getNotAnimatableDelta();
                            long jIntOffset = IntOffsetKt.IntOffset(IntOffset.m3961getXimpl(targetOffset) + IntOffset.m3961getXimpl(notAnimatableDelta3), IntOffset.m3962getYimpl(targetOffset) + IntOffset.m3962getYimpl(notAnimatableDelta3));
                            if (m590getMainAxisgyyYBs(jIntOffset) + placeableInfo.getMainAxisSize() > 0 && m590getMainAxisgyyYBs(jIntOffset) < i2) {
                                z = true;
                                break;
                            }
                            i10++;
                        }
                        List<PlaceableInfo> placeables2 = value.getPlaceables();
                        int size5 = placeables2.size();
                        int i11 = 0;
                        while (true) {
                            if (i11 >= size5) {
                                z2 = false;
                                break;
                            } else {
                                if (placeables2.get(i11).getInProgress()) {
                                    z2 = true;
                                    break;
                                }
                                i11++;
                            }
                        }
                        if ((!z && !z2) || num2 == null || value.getPlaceables().isEmpty()) {
                            it.remove();
                        } else {
                            int iM568constructorimpl = ItemIndex.m568constructorimpl(num2.intValue());
                            if (this.isVertical) {
                                jM3808fixedHeightOenEA2s = Constraints.INSTANCE.m3809fixedWidthOenEA2s(value.getCrossAxisSize());
                            } else {
                                jM3808fixedHeightOenEA2s = Constraints.INSTANCE.m3808fixedHeightOenEA2s(value.getCrossAxisSize());
                            }
                            LazyMeasuredItem lazyMeasuredItemM613getAndMeasureednRnyU$default = LazyMeasuredItemProvider.m613getAndMeasureednRnyU$default(measuredItemProvider, iM568constructorimpl, 0, jM3808fixedHeightOenEA2s, 2, null);
                            int iM589calculateExpectedOffsettGxSNXI2 = m589calculateExpectedOffsettGxSNXI(num2.intValue(), lazyMeasuredItemM613getAndMeasureednRnyU$default.getMainAxisSizeWithSpacings(), i7, jM591toOffsetBjo55l4, reverseLayout, i2, i2);
                            if (reverseLayout) {
                                iM589calculateExpectedOffsettGxSNXI2 = (i2 - iM589calculateExpectedOffsettGxSNXI2) - lazyMeasuredItemM613getAndMeasureednRnyU$default.getMainAxisSize();
                            }
                            LazyGridPositionedItem lazyGridPositionedItemPosition = lazyMeasuredItemM613getAndMeasureednRnyU$default.position(iM589calculateExpectedOffsettGxSNXI2, value.getCrossAxisOffset(), layoutWidth, layoutHeight, -1, -1, lazyMeasuredItemM613getAndMeasureednRnyU$default.getMainAxisSize());
                            positionedItems.add(lazyGridPositionedItemPosition);
                            startAnimationsIfNeeded(lazyGridPositionedItemPosition, value);
                        }
                    }
                }
                this.keyToIndexMap = measuredItemProvider.getKeyToIndexMap();
                return;
            }
        }
        reset();
    }
}
