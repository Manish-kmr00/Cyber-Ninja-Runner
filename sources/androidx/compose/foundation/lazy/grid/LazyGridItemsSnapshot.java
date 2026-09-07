package androidx.compose.foundation.lazy.grid;

import androidx.compose.foundation.ExperimentalFoundationApi;
import androidx.compose.foundation.lazy.layout.IntervalList;
import androidx.compose.foundation.lazy.layout.Lazy_androidKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.ScopeUpdateScope;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntRange;

/* JADX INFO: compiled from: LazyGridItemProviderImpl.kt */
/* JADX INFO: loaded from: classes10.dex */
@ExperimentalFoundationApi
@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0001\u0018\u00002\u00020\u0001B#\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b¢\u0006\u0002\u0010\tJ\u0015\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\rH\u0007¢\u0006\u0002\u0010\u001bJ\u0010\u0010\u001c\u001a\u0004\u0018\u00010\u00012\u0006\u0010\u001a\u001a\u00020\rJ\u000e\u0010\u001d\u001a\u00020\u00012\u0006\u0010\u001a\u001a\u00020\rJ\"\u0010\u001e\u001a\u00020\u001f*\u00020 2\u0006\u0010\u001a\u001a\u00020\rø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0004\b!\u0010\"R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0014\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\f\u001a\u00020\r8F¢\u0006\u0006\u001a\u0004\b\u000e\u0010\u000fR\u001d\u0010\u0010\u001a\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\r0\u0011¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0011\u0010\u0014\u001a\u00020\u0015¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017\u0082\u0002\u000f\n\u0002\b\u0019\n\u0002\b!\n\u0005\b¡\u001e0\u0001¨\u0006#"}, d2 = {"Landroidx/compose/foundation/lazy/grid/LazyGridItemsSnapshot;", "", "intervals", "Landroidx/compose/foundation/lazy/layout/IntervalList;", "Landroidx/compose/foundation/lazy/grid/LazyGridIntervalContent;", "hasCustomSpans", "", "nearestItemsRange", "Lkotlin/ranges/IntRange;", "(Landroidx/compose/foundation/lazy/layout/IntervalList;ZLkotlin/ranges/IntRange;)V", "getHasCustomSpans", "()Z", "itemsCount", "", "getItemsCount", "()I", "keyToIndexMap", "", "getKeyToIndexMap", "()Ljava/util/Map;", "spanLayoutProvider", "Landroidx/compose/foundation/lazy/grid/LazyGridSpanLayoutProvider;", "getSpanLayoutProvider", "()Landroidx/compose/foundation/lazy/grid/LazyGridSpanLayoutProvider;", "Item", "", "index", "(ILandroidx/compose/runtime/Composer;I)V", "getContentType", "getKey", "getSpan", "Landroidx/compose/foundation/lazy/grid/GridItemSpan;", "Landroidx/compose/foundation/lazy/grid/LazyGridItemSpanScope;", "getSpan-_-orMbw", "(Landroidx/compose/foundation/lazy/grid/LazyGridItemSpanScope;I)J", "foundation_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class LazyGridItemsSnapshot {
    private final boolean hasCustomSpans;
    private final IntervalList<LazyGridIntervalContent> intervals;
    private final Map<Object, Integer> keyToIndexMap;
    private final LazyGridSpanLayoutProvider spanLayoutProvider;

    public LazyGridItemsSnapshot(IntervalList<LazyGridIntervalContent> intervals, boolean z, IntRange nearestItemsRange) {
        Intrinsics.checkNotNullParameter(intervals, "intervals");
        Intrinsics.checkNotNullParameter(nearestItemsRange, "nearestItemsRange");
        this.intervals = intervals;
        this.hasCustomSpans = z;
        this.spanLayoutProvider = new LazyGridSpanLayoutProvider(this);
        this.keyToIndexMap = LazyGridItemProviderImplKt.generateKeyToIndexMap(nearestItemsRange, intervals);
    }

    public final boolean getHasCustomSpans() {
        return this.hasCustomSpans;
    }

    public final int getItemsCount() {
        return this.intervals.getSize();
    }

    public final LazyGridSpanLayoutProvider getSpanLayoutProvider() {
        return this.spanLayoutProvider;
    }

    public final Object getKey(int index) {
        IntervalList.Interval<LazyGridIntervalContent> interval = this.intervals.get(index);
        int startIndex = index - interval.getStartIndex();
        Function1<Integer, Object> key = interval.getValue().getKey();
        Object objInvoke = key != null ? key.invoke(Integer.valueOf(startIndex)) : null;
        return objInvoke == null ? Lazy_androidKt.getDefaultLazyLayoutKey(index) : objInvoke;
    }

    /* JADX INFO: renamed from: getSpan-_-orMbw, reason: not valid java name */
    public final long m593getSpan_orMbw(LazyGridItemSpanScope getSpan, int i) {
        Intrinsics.checkNotNullParameter(getSpan, "$this$getSpan");
        IntervalList.Interval<LazyGridIntervalContent> interval = this.intervals.get(i);
        return interval.getValue().getSpan().invoke(getSpan, Integer.valueOf(i - interval.getStartIndex())).getPackedValue();
    }

    public final void Item(final int i, Composer composer, final int i2) {
        Composer composerStartRestartGroup = composer.startRestartGroup(-405085610);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(Item)96@3751L49:LazyGridItemProviderImpl.kt#7791vq");
        IntervalList.Interval<LazyGridIntervalContent> interval = this.intervals.get(i);
        interval.getValue().getItem().invoke(LazyGridItemScopeImpl.INSTANCE, Integer.valueOf(i - interval.getStartIndex()), composerStartRestartGroup, 6);
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup == null) {
            return;
        }
        scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.foundation.lazy.grid.LazyGridItemsSnapshot.Item.1
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
                LazyGridItemsSnapshot.this.Item(i, composer2, i2 | 1);
            }
        });
    }

    public final Map<Object, Integer> getKeyToIndexMap() {
        return this.keyToIndexMap;
    }

    public final Object getContentType(int index) {
        IntervalList.Interval<LazyGridIntervalContent> interval = this.intervals.get(index);
        return interval.getValue().getType().invoke(Integer.valueOf(index - interval.getStartIndex()));
    }
}
