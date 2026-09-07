package androidx.compose.foundation.lazy;

import androidx.compose.animation.core.FiniteAnimationSpec;
import androidx.compose.ui.unit.IntOffset;
import androidx.compose.ui.unit.IntOffsetKt;
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
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntRange;
import kotlin.ranges.RangesKt;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: compiled from: LazyListItemPlacementAnimator.kt */
/* JADX INFO: loaded from: classes8.dex */
@Metadata(d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0010\b\n\u0000\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010#\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010!\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\b\u0000\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J[\u0010\u0017\u001a\u00020\t2\u0006\u0010\u0018\u001a\u00020\t2\u0006\u0010\u0019\u001a\u00020\t2\u0006\u0010\u001a\u001a\u00020\t2\u0006\u0010\u001b\u001a\u00020\u00142\u0006\u0010\u001c\u001a\u00020\u00052\u0006\u0010\u001d\u001a\u00020\t2\u0006\u0010\u001e\u001a\u00020\t2\f\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020!0 H\u0002ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\"\u0010#J;\u0010$\u001a\u00020\u00142\u0006\u0010%\u001a\u00020\u00012\u0006\u0010&\u001a\u00020\t2\u0006\u0010'\u001a\u00020\t2\u0006\u0010(\u001a\u00020\t2\u0006\u0010)\u001a\u00020\u0014ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b*\u0010+J<\u0010,\u001a\u00020-2\u0006\u0010.\u001a\u00020\t2\u0006\u0010/\u001a\u00020\t2\u0006\u00100\u001a\u00020\t2\u0006\u0010\u001c\u001a\u00020\u00052\f\u00101\u001a\b\u0012\u0004\u0012\u00020!022\u0006\u00103\u001a\u000204J\u0006\u00105\u001a\u00020-J\u0018\u00106\u001a\u00020-2\u0006\u00107\u001a\u00020!2\u0006\u00108\u001a\u00020\fH\u0002J\"\u00109\u001a\u00020\t*\b\u0012\u0004\u0012\u00020!0 2\u0006\u0010:\u001a\u00020\t2\u0006\u0010\u001e\u001a\u00020\tH\u0002J\u001c\u0010;\u001a\u00020\u0014*\u00020\tH\u0002ø\u0001\u0000ø\u0001\u0002ø\u0001\u0001¢\u0006\u0004\b<\u0010=R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\t0\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\f0\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00010\u000eX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u0010\u0013\u001a\u00020\t*\u00020\u00148BX\u0082\u0004ø\u0001\u0000¢\u0006\u0006\u001a\u0004\b\u0015\u0010\u0016\u0082\u0002\u000f\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006>"}, d2 = {"Landroidx/compose/foundation/lazy/LazyListItemPlacementAnimator;", "", "scope", "Lkotlinx/coroutines/CoroutineScope;", "isVertical", "", "(Lkotlinx/coroutines/CoroutineScope;Z)V", "keyToIndexMap", "", "", "keyToItemInfoMap", "", "Landroidx/compose/foundation/lazy/ItemInfo;", "positionedKeys", "", "viewportEndItemIndex", "viewportEndItemNotVisiblePartSize", "viewportStartItemIndex", "viewportStartItemNotVisiblePartSize", "mainAxis", "Landroidx/compose/ui/unit/IntOffset;", "getMainAxis--gyyYBs", "(J)I", "calculateExpectedOffset", "index", "sizeWithSpacings", "averageItemsSize", "scrolledBy", "reverseLayout", "mainAxisLayoutSize", POBNativeConstants.NATIVE_FALLBACK_URL, "visibleItems", "", "Landroidx/compose/foundation/lazy/LazyListPositionedItem;", "calculateExpectedOffset-diAxcj4", "(IIIJZIILjava/util/List;)I", "getAnimatedOffset", "key", "placeableIndex", "minOffset", "maxOffset", "rawOffset", "getAnimatedOffset-YT5a7pE", "(Ljava/lang/Object;IIIJ)J", "onMeasured", "", "consumedScroll", "layoutWidth", "layoutHeight", "positionedItems", "", "itemProvider", "Landroidx/compose/foundation/lazy/LazyMeasuredItemProvider;", TimerController.RESET_COMMAND, "startAnimationsIfNeeded", "item", "itemInfo", "getItemSize", "itemIndex", "toOffset", "toOffset-Bjo55l4", "(I)J", "foundation_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class LazyListItemPlacementAnimator {
    private final boolean isVertical;
    private Map<Object, Integer> keyToIndexMap;
    private final Map<Object, ItemInfo> keyToItemInfoMap;
    private final Set<Object> positionedKeys;
    private final CoroutineScope scope;
    private int viewportEndItemIndex;
    private int viewportEndItemNotVisiblePartSize;
    private int viewportStartItemIndex;
    private int viewportStartItemNotVisiblePartSize;

    public LazyListItemPlacementAnimator(CoroutineScope scope, boolean z) {
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
    public final long m537getAnimatedOffsetYT5a7pE(Object key, int placeableIndex, int minOffset, int maxOffset, long rawOffset) {
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
        if (placeableInfo.getInProgress() && ((m535getMainAxisgyyYBs(jIntOffset2) < minOffset && m535getMainAxisgyyYBs(jIntOffset) < minOffset) || (m535getMainAxisgyyYBs(jIntOffset2) > maxOffset && m535getMainAxisgyyYBs(jIntOffset) > maxOffset))) {
            BuildersKt__Builders_commonKt.launch$default(this.scope, null, null, new LazyListItemPlacementAnimator$getAnimatedOffset$1(placeableInfo, null), 3, null);
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

    /* JADX INFO: renamed from: calculateExpectedOffset-diAxcj4, reason: not valid java name */
    private final int m534calculateExpectedOffsetdiAxcj4(int index, int sizeWithSpacings, int averageItemsSize, long scrolledBy, boolean reverseLayout, int mainAxisLayoutSize, int fallback, List<LazyListPositionedItem> visibleItems) {
        IntRange intRangeUntil;
        IntRange intRangeUntil2;
        int itemSize = 0;
        int i = this.viewportEndItemIndex;
        boolean z = reverseLayout ? i > index : i < index;
        int i2 = this.viewportStartItemIndex;
        boolean z2 = reverseLayout ? i2 < index : i2 > index;
        if (z) {
            if (!reverseLayout) {
                intRangeUntil2 = RangesKt.until(this.viewportEndItemIndex + 1, index);
            } else {
                intRangeUntil2 = RangesKt.until(index + 1, this.viewportEndItemIndex);
            }
            int first = intRangeUntil2.getFirst();
            int last = intRangeUntil2.getLast();
            if (first <= last) {
                while (true) {
                    itemSize += getItemSize(visibleItems, first, averageItemsSize);
                    if (first == last) {
                        break;
                    }
                    first++;
                }
            }
            return mainAxisLayoutSize + this.viewportEndItemNotVisiblePartSize + itemSize + m535getMainAxisgyyYBs(scrolledBy);
        }
        if (!z2) {
            return fallback;
        }
        if (!reverseLayout) {
            intRangeUntil = RangesKt.until(index + 1, this.viewportStartItemIndex);
        } else {
            intRangeUntil = RangesKt.until(this.viewportStartItemIndex + 1, index);
        }
        int first2 = intRangeUntil.getFirst();
        int last2 = intRangeUntil.getLast();
        if (first2 <= last2) {
            while (true) {
                sizeWithSpacings += getItemSize(visibleItems, first2, averageItemsSize);
                if (first2 == last2) {
                    break;
                }
                first2++;
            }
        }
        return (this.viewportStartItemNotVisiblePartSize - sizeWithSpacings) + m535getMainAxisgyyYBs(scrolledBy);
    }

    private final int getItemSize(List<LazyListPositionedItem> list, int i, int i2) {
        if (!list.isEmpty() && i >= ((LazyListPositionedItem) CollectionsKt.first((List) list)).getIndex() && i <= ((LazyListPositionedItem) CollectionsKt.last((List) list)).getIndex()) {
            if (i - ((LazyListPositionedItem) CollectionsKt.first((List) list)).getIndex() < ((LazyListPositionedItem) CollectionsKt.last((List) list)).getIndex() - i) {
                int size = list.size();
                for (int i3 = 0; i3 < size; i3++) {
                    LazyListPositionedItem lazyListPositionedItem = list.get(i3);
                    if (lazyListPositionedItem.getIndex() == i) {
                        return lazyListPositionedItem.getSizeWithSpacings();
                    }
                    if (lazyListPositionedItem.getIndex() > i) {
                        break;
                    }
                }
            } else {
                for (int lastIndex = CollectionsKt.getLastIndex(list); -1 < lastIndex; lastIndex--) {
                    LazyListPositionedItem lazyListPositionedItem2 = list.get(lastIndex);
                    if (lazyListPositionedItem2.getIndex() == i) {
                        return lazyListPositionedItem2.getSizeWithSpacings();
                    }
                    if (lazyListPositionedItem2.getIndex() < i) {
                        break;
                    }
                }
            }
        }
        return i2;
    }

    /* JADX WARN: Code duplicated, block: B:16:0x00da  */
    private final void startAnimationsIfNeeded(LazyListPositionedItem item, ItemInfo itemInfo) {
        while (itemInfo.getPlaceables().size() > item.getPlaceablesCount()) {
            CollectionsKt.removeLast(itemInfo.getPlaceables());
        }
        while (itemInfo.getPlaceables().size() < item.getPlaceablesCount()) {
            int size = itemInfo.getPlaceables().size();
            long jM544getOffsetBjo55l4 = item.m544getOffsetBjo55l4(size);
            List<PlaceableInfo> placeables = itemInfo.getPlaceables();
            long notAnimatableDelta = itemInfo.getNotAnimatableDelta();
            placeables.add(new PlaceableInfo(IntOffsetKt.IntOffset(IntOffset.m3961getXimpl(jM544getOffsetBjo55l4) - IntOffset.m3961getXimpl(notAnimatableDelta), IntOffset.m3962getYimpl(jM544getOffsetBjo55l4) - IntOffset.m3962getYimpl(notAnimatableDelta)), item.getMainAxisSize(size), null));
        }
        List<PlaceableInfo> placeables2 = itemInfo.getPlaceables();
        int size2 = placeables2.size();
        for (int i = 0; i < size2; i++) {
            PlaceableInfo placeableInfo = placeables2.get(i);
            long targetOffset = placeableInfo.getTargetOffset();
            long notAnimatableDelta2 = itemInfo.getNotAnimatableDelta();
            long jIntOffset = IntOffsetKt.IntOffset(IntOffset.m3961getXimpl(targetOffset) + IntOffset.m3961getXimpl(notAnimatableDelta2), IntOffset.m3962getYimpl(targetOffset) + IntOffset.m3962getYimpl(notAnimatableDelta2));
            long jM544getOffsetBjo55l5 = item.m544getOffsetBjo55l4(i);
            placeableInfo.setSize(item.getMainAxisSize(i));
            FiniteAnimationSpec<IntOffset> animationSpec = item.getAnimationSpec(i);
            if (!IntOffset.m3960equalsimpl0(jIntOffset, jM544getOffsetBjo55l5)) {
                long notAnimatableDelta3 = itemInfo.getNotAnimatableDelta();
                placeableInfo.m556setTargetOffsetgyyYBs(IntOffsetKt.IntOffset(IntOffset.m3961getXimpl(jM544getOffsetBjo55l5) - IntOffset.m3961getXimpl(notAnimatableDelta3), IntOffset.m3962getYimpl(jM544getOffsetBjo55l5) - IntOffset.m3962getYimpl(notAnimatableDelta3)));
                if (animationSpec != null) {
                    placeableInfo.setInProgress(true);
                    BuildersKt__Builders_commonKt.launch$default(this.scope, null, null, new LazyListItemPlacementAnimator$startAnimationsIfNeeded$1$1(placeableInfo, animationSpec, null), 3, null);
                }
            }
        }
    }

    /* JADX INFO: renamed from: toOffset-Bjo55l4, reason: not valid java name */
    private final long m536toOffsetBjo55l4(int i) {
        boolean z = this.isVertical;
        int i2 = z ? 0 : i;
        if (!z) {
            i = 0;
        }
        return IntOffsetKt.IntOffset(i2, i);
    }

    /* JADX INFO: renamed from: getMainAxis--gyyYBs, reason: not valid java name */
    private final int m535getMainAxisgyyYBs(long j) {
        return this.isVertical ? IntOffset.m3962getYimpl(j) : IntOffset.m3961getXimpl(j);
    }

    public final void onMeasured(int consumedScroll, int layoutWidth, int layoutHeight, boolean reverseLayout, List<LazyListPositionedItem> positionedItems, LazyMeasuredItemProvider itemProvider) {
        boolean z;
        boolean z2;
        int iM535getMainAxisgyyYBs;
        LazyListPositionedItem lazyListPositionedItem;
        int iM534calculateExpectedOffsetdiAxcj4;
        long jM3957copyiSbpLlY$default;
        LazyMeasuredItemProvider itemProvider2 = itemProvider;
        Intrinsics.checkNotNullParameter(positionedItems, "positionedItems");
        Intrinsics.checkNotNullParameter(itemProvider2, "itemProvider");
        int size = positionedItems.size();
        int i = 0;
        int i2 = 0;
        while (i2 < size) {
            if (positionedItems.get(i2).getHasAnimations()) {
                int i3 = this.isVertical ? layoutHeight : layoutWidth;
                long jM536toOffsetBjo55l4 = m536toOffsetBjo55l4(reverseLayout ? -consumedScroll : consumedScroll);
                LazyListPositionedItem lazyListPositionedItem2 = (LazyListPositionedItem) CollectionsKt.first((List) positionedItems);
                LazyListPositionedItem lazyListPositionedItem3 = (LazyListPositionedItem) CollectionsKt.last((List) positionedItems);
                int size2 = positionedItems.size();
                int i4 = i;
                int sizeWithSpacings = i4;
                while (i4 < size2) {
                    LazyListPositionedItem lazyListPositionedItem4 = positionedItems.get(i4);
                    ItemInfo itemInfo = this.keyToItemInfoMap.get(lazyListPositionedItem4.getKey());
                    if (itemInfo != null) {
                        itemInfo.setIndex(lazyListPositionedItem4.getIndex());
                    }
                    sizeWithSpacings += lazyListPositionedItem4.getSizeWithSpacings();
                    i4++;
                }
                int size3 = sizeWithSpacings / positionedItems.size();
                this.positionedKeys.clear();
                int size4 = positionedItems.size();
                int i5 = i;
                while (i5 < size4) {
                    LazyListPositionedItem lazyListPositionedItem5 = positionedItems.get(i5);
                    this.positionedKeys.add(lazyListPositionedItem5.getKey());
                    ItemInfo itemInfo2 = this.keyToItemInfoMap.get(lazyListPositionedItem5.getKey());
                    if (itemInfo2 == null) {
                        if (lazyListPositionedItem5.getHasAnimations()) {
                            ItemInfo itemInfo3 = new ItemInfo(lazyListPositionedItem5.getIndex());
                            Integer num = this.keyToIndexMap.get(lazyListPositionedItem5.getKey());
                            long jM544getOffsetBjo55l4 = lazyListPositionedItem5.m544getOffsetBjo55l4(i);
                            int mainAxisSize = lazyListPositionedItem5.getMainAxisSize(i);
                            if (num == null) {
                                iM534calculateExpectedOffsetdiAxcj4 = m535getMainAxisgyyYBs(jM544getOffsetBjo55l4);
                                lazyListPositionedItem = lazyListPositionedItem5;
                            } else {
                                if (!reverseLayout) {
                                    iM535getMainAxisgyyYBs = m535getMainAxisgyyYBs(jM544getOffsetBjo55l4);
                                } else {
                                    iM535getMainAxisgyyYBs = (m535getMainAxisgyyYBs(jM544getOffsetBjo55l4) - lazyListPositionedItem5.getSizeWithSpacings()) + mainAxisSize;
                                }
                                lazyListPositionedItem = lazyListPositionedItem5;
                                iM534calculateExpectedOffsetdiAxcj4 = m534calculateExpectedOffsetdiAxcj4(num.intValue(), lazyListPositionedItem5.getSizeWithSpacings(), size3, jM536toOffsetBjo55l4, reverseLayout, i3, iM535getMainAxisgyyYBs, positionedItems) + (reverseLayout ? lazyListPositionedItem.getSize() - mainAxisSize : i);
                            }
                            if (this.isVertical) {
                                jM3957copyiSbpLlY$default = IntOffset.m3957copyiSbpLlY$default(jM544getOffsetBjo55l4, 0, iM534calculateExpectedOffsetdiAxcj4, 1, null);
                            } else {
                                jM3957copyiSbpLlY$default = IntOffset.m3957copyiSbpLlY$default(jM544getOffsetBjo55l4, iM534calculateExpectedOffsetdiAxcj4, 0, 2, null);
                            }
                            int placeablesCount = lazyListPositionedItem.getPlaceablesCount();
                            for (int i6 = i; i6 < placeablesCount; i6++) {
                                LazyListPositionedItem lazyListPositionedItem6 = lazyListPositionedItem;
                                long jM544getOffsetBjo55l5 = lazyListPositionedItem6.m544getOffsetBjo55l4(i6);
                                long jIntOffset = IntOffsetKt.IntOffset(IntOffset.m3961getXimpl(jM544getOffsetBjo55l5) - IntOffset.m3961getXimpl(jM544getOffsetBjo55l4), IntOffset.m3962getYimpl(jM544getOffsetBjo55l5) - IntOffset.m3962getYimpl(jM544getOffsetBjo55l4));
                                itemInfo3.getPlaceables().add(new PlaceableInfo(IntOffsetKt.IntOffset(IntOffset.m3961getXimpl(jM3957copyiSbpLlY$default) + IntOffset.m3961getXimpl(jIntOffset), IntOffset.m3962getYimpl(jM3957copyiSbpLlY$default) + IntOffset.m3962getYimpl(jIntOffset)), lazyListPositionedItem6.getMainAxisSize(i6), null));
                                Unit unit = Unit.INSTANCE;
                            }
                            LazyListPositionedItem lazyListPositionedItem7 = lazyListPositionedItem;
                            this.keyToItemInfoMap.put(lazyListPositionedItem7.getKey(), itemInfo3);
                            startAnimationsIfNeeded(lazyListPositionedItem7, itemInfo3);
                        } else {
                            i5 = i5;
                            size4 = size4;
                        }
                    } else {
                        i5 = i5;
                        size4 = size4;
                        if (lazyListPositionedItem5.getHasAnimations()) {
                            long notAnimatableDelta = itemInfo2.getNotAnimatableDelta();
                            itemInfo2.m525setNotAnimatableDeltagyyYBs(IntOffsetKt.IntOffset(IntOffset.m3961getXimpl(notAnimatableDelta) + IntOffset.m3961getXimpl(jM536toOffsetBjo55l4), IntOffset.m3962getYimpl(notAnimatableDelta) + IntOffset.m3962getYimpl(jM536toOffsetBjo55l4)));
                            startAnimationsIfNeeded(lazyListPositionedItem5, itemInfo2);
                        } else {
                            this.keyToItemInfoMap.remove(lazyListPositionedItem5.getKey());
                        }
                    }
                    i5++;
                    size4 = size4;
                    i = 0;
                }
                if (!reverseLayout) {
                    this.viewportStartItemIndex = lazyListPositionedItem2.getIndex();
                    this.viewportStartItemNotVisiblePartSize = lazyListPositionedItem2.getOffset();
                    this.viewportEndItemIndex = lazyListPositionedItem3.getIndex();
                    this.viewportEndItemNotVisiblePartSize = (lazyListPositionedItem3.getOffset() + lazyListPositionedItem3.getSizeWithSpacings()) - i3;
                } else {
                    this.viewportStartItemIndex = lazyListPositionedItem3.getIndex();
                    this.viewportStartItemNotVisiblePartSize = (i3 - lazyListPositionedItem3.getOffset()) - lazyListPositionedItem3.getSize();
                    this.viewportEndItemIndex = lazyListPositionedItem2.getIndex();
                    this.viewportEndItemNotVisiblePartSize = (-lazyListPositionedItem2.getOffset()) + (lazyListPositionedItem2.getSizeWithSpacings() - lazyListPositionedItem2.getSize());
                }
                Iterator<Map.Entry<Object, ItemInfo>> it = this.keyToItemInfoMap.entrySet().iterator();
                while (it.hasNext()) {
                    Map.Entry<Object, ItemInfo> next = it.next();
                    if (!this.positionedKeys.contains(next.getKey())) {
                        ItemInfo value = next.getValue();
                        long notAnimatableDelta2 = value.getNotAnimatableDelta();
                        value.m525setNotAnimatableDeltagyyYBs(IntOffsetKt.IntOffset(IntOffset.m3961getXimpl(notAnimatableDelta2) + IntOffset.m3961getXimpl(jM536toOffsetBjo55l4), IntOffset.m3962getYimpl(notAnimatableDelta2) + IntOffset.m3962getYimpl(jM536toOffsetBjo55l4)));
                        Integer num2 = itemProvider.getKeyToIndexMap().get(next.getKey());
                        List<PlaceableInfo> placeables = value.getPlaceables();
                        int size5 = placeables.size();
                        int i7 = 0;
                        while (true) {
                            z = true;
                            if (i7 >= size5) {
                                z2 = false;
                                break;
                            }
                            PlaceableInfo placeableInfo = placeables.get(i7);
                            long targetOffset = placeableInfo.getTargetOffset();
                            long notAnimatableDelta3 = value.getNotAnimatableDelta();
                            long jIntOffset2 = IntOffsetKt.IntOffset(IntOffset.m3961getXimpl(targetOffset) + IntOffset.m3961getXimpl(notAnimatableDelta3), IntOffset.m3962getYimpl(targetOffset) + IntOffset.m3962getYimpl(notAnimatableDelta3));
                            if (m535getMainAxisgyyYBs(jIntOffset2) + placeableInfo.getSize() > 0 && m535getMainAxisgyyYBs(jIntOffset2) < i3) {
                                z2 = true;
                                break;
                            }
                            i7++;
                        }
                        List<PlaceableInfo> placeables2 = value.getPlaceables();
                        int size6 = placeables2.size();
                        int i8 = 0;
                        while (true) {
                            if (i8 >= size6) {
                                z = false;
                                break;
                            } else if (placeables2.get(i8).getInProgress()) {
                                break;
                            } else {
                                i8++;
                            }
                        }
                        if ((!z2 && !z) || num2 == null || value.getPlaceables().isEmpty()) {
                            it.remove();
                        } else {
                            LazyMeasuredItem lazyMeasuredItemM553getAndMeasureZjPyQlc = itemProvider2.m553getAndMeasureZjPyQlc(DataIndex.m512constructorimpl(num2.intValue()));
                            int iM534calculateExpectedOffsetdiAxcj5 = m534calculateExpectedOffsetdiAxcj4(num2.intValue(), lazyMeasuredItemM553getAndMeasureZjPyQlc.getSizeWithSpacings(), size3, jM536toOffsetBjo55l4, reverseLayout, i3, i3, positionedItems);
                            if (reverseLayout) {
                                iM534calculateExpectedOffsetdiAxcj5 = (i3 - iM534calculateExpectedOffsetdiAxcj5) - lazyMeasuredItemM553getAndMeasureZjPyQlc.getSize();
                            }
                            LazyListPositionedItem lazyListPositionedItemPosition = lazyMeasuredItemM553getAndMeasureZjPyQlc.position(iM534calculateExpectedOffsetdiAxcj5, layoutWidth, layoutHeight);
                            positionedItems.add(lazyListPositionedItemPosition);
                            startAnimationsIfNeeded(lazyListPositionedItemPosition, value);
                        }
                    }
                    itemProvider2 = itemProvider;
                }
                this.keyToIndexMap = itemProvider.getKeyToIndexMap();
                return;
            }
            i2++;
            itemProvider2 = itemProvider;
            i = 0;
        }
        reset();
    }
}
