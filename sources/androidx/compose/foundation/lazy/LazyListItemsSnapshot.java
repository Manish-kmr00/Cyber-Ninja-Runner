package androidx.compose.foundation.lazy;

import androidx.compose.foundation.ExperimentalFoundationApi;
import androidx.compose.foundation.lazy.layout.IntervalList;
import androidx.compose.foundation.lazy.layout.Lazy_androidKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.ScopeUpdateScope;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntRange;

/* JADX INFO: compiled from: LazyListItemProviderImpl.kt */
/* JADX INFO: loaded from: classes11.dex */
@ExperimentalFoundationApi
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010$\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0001\u0018\u00002\u00020\u0001B)\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ\u001d\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u0007H\u0007¢\u0006\u0002\u0010\u0019J\u0010\u0010\u001a\u001a\u0004\u0018\u00010\u00012\u0006\u0010\u0018\u001a\u00020\u0007J\u000e\u0010\u001b\u001a\u00020\u00012\u0006\u0010\u0018\u001a\u00020\u0007R\u0017\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0014\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\r\u001a\u00020\u00078F¢\u0006\u0006\u001a\u0004\b\u000e\u0010\u000fR\u001d\u0010\u0010\u001a\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u00070\u0011¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013¨\u0006\u001c"}, d2 = {"Landroidx/compose/foundation/lazy/LazyListItemsSnapshot;", "", "intervals", "Landroidx/compose/foundation/lazy/layout/IntervalList;", "Landroidx/compose/foundation/lazy/LazyListIntervalContent;", "headerIndexes", "", "", "nearestItemsRange", "Lkotlin/ranges/IntRange;", "(Landroidx/compose/foundation/lazy/layout/IntervalList;Ljava/util/List;Lkotlin/ranges/IntRange;)V", "getHeaderIndexes", "()Ljava/util/List;", "itemsCount", "getItemsCount", "()I", "keyToIndexMap", "", "getKeyToIndexMap", "()Ljava/util/Map;", "Item", "", "scope", "Landroidx/compose/foundation/lazy/LazyItemScope;", "index", "(Landroidx/compose/foundation/lazy/LazyItemScope;ILandroidx/compose/runtime/Composer;I)V", "getContentType", "getKey", "foundation_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class LazyListItemsSnapshot {
    private final List<Integer> headerIndexes;
    private final IntervalList<LazyListIntervalContent> intervals;
    private final Map<Object, Integer> keyToIndexMap;

    public LazyListItemsSnapshot(IntervalList<LazyListIntervalContent> intervals, List<Integer> headerIndexes, IntRange nearestItemsRange) {
        Intrinsics.checkNotNullParameter(intervals, "intervals");
        Intrinsics.checkNotNullParameter(headerIndexes, "headerIndexes");
        Intrinsics.checkNotNullParameter(nearestItemsRange, "nearestItemsRange");
        this.intervals = intervals;
        this.headerIndexes = headerIndexes;
        this.keyToIndexMap = LazyListItemProviderImplKt.generateKeyToIndexMap(nearestItemsRange, intervals);
    }

    public final List<Integer> getHeaderIndexes() {
        return this.headerIndexes;
    }

    public final int getItemsCount() {
        return this.intervals.getSize();
    }

    public final Object getKey(int index) {
        IntervalList.Interval<LazyListIntervalContent> interval = this.intervals.get(index);
        int startIndex = index - interval.getStartIndex();
        Function1<Integer, Object> key = interval.getValue().getKey();
        Object objInvoke = key != null ? key.invoke(Integer.valueOf(startIndex)) : null;
        return objInvoke == null ? Lazy_androidKt.getDefaultLazyLayoutKey(index) : objInvoke;
    }

    public final void Item(final LazyItemScope scope, final int i, Composer composer, final int i2) {
        Intrinsics.checkNotNullParameter(scope, "scope");
        Composer composerStartRestartGroup = composer.startRestartGroup(1922528915);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(Item)P(1)89@3463L33:LazyListItemProviderImpl.kt#428nma");
        IntervalList.Interval<LazyListIntervalContent> interval = this.intervals.get(i);
        interval.getValue().getItem().invoke(scope, Integer.valueOf(i - interval.getStartIndex()), composerStartRestartGroup, Integer.valueOf(i2 & 14));
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup == null) {
            return;
        }
        scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.foundation.lazy.LazyListItemsSnapshot.Item.1
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
                LazyListItemsSnapshot.this.Item(scope, i, composer2, i2 | 1);
            }
        });
    }

    public final Map<Object, Integer> getKeyToIndexMap() {
        return this.keyToIndexMap;
    }

    public final Object getContentType(int index) {
        IntervalList.Interval<LazyListIntervalContent> interval = this.intervals.get(index);
        return interval.getValue().getType().invoke(Integer.valueOf(index - interval.getStartIndex()));
    }
}
