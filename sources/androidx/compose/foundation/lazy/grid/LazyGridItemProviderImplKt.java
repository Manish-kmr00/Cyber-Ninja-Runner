package androidx.compose.foundation.lazy.grid;

import androidx.compose.foundation.ExperimentalFoundationApi;
import androidx.compose.foundation.lazy.layout.IntervalList;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.compose.runtime.snapshots.Snapshot;
import com.google.android.exoplayer2.source.rtsp.SessionDescription;
import java.util.HashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntRange;
import kotlin.ranges.RangesKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;

/* JADX INFO: compiled from: LazyGridItemProviderImpl.kt */
/* JADX INFO: loaded from: classes10.dex */
@Metadata(d1 = {"\u0000H\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0001H\u0002\u001a*\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u00010\u00072\u0006\u0010\t\u001a\u00020\u00042\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000bH\u0001\u001a.\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\u0017\u0010\u0011\u001a\u0013\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020\u00140\u0012¢\u0006\u0002\b\u0015H\u0001¢\u0006\u0002\u0010\u0016\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0082D¢\u0006\u0002\n\u0000\"\u000e\u0010\u0002\u001a\u00020\u0001X\u0082D¢\u0006\u0002\n\u0000¨\u0006\u0017"}, d2 = {"ExtraItemsNearTheSlidingWindow", "", "VisibleItemsSlidingWindowSize", "calculateNearestItemsRange", "Lkotlin/ranges/IntRange;", "firstVisibleItem", "generateKeyToIndexMap", "", "", SessionDescription.ATTR_RANGE, "list", "Landroidx/compose/foundation/lazy/layout/IntervalList;", "Landroidx/compose/foundation/lazy/grid/LazyGridIntervalContent;", "rememberItemProvider", "Landroidx/compose/foundation/lazy/grid/LazyGridItemProvider;", "state", "Landroidx/compose/foundation/lazy/grid/LazyGridState;", "content", "Lkotlin/Function1;", "Landroidx/compose/foundation/lazy/grid/LazyGridScope;", "", "Lkotlin/ExtensionFunctionType;", "(Landroidx/compose/foundation/lazy/grid/LazyGridState;Lkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;I)Landroidx/compose/foundation/lazy/grid/LazyGridItemProvider;", "foundation_release"}, k = 2, mv = {1, 6, 0}, xi = 48)
public final class LazyGridItemProviderImplKt {
    private static final int ExtraItemsNearTheSlidingWindow = 200;
    private static final int VisibleItemsSlidingWindowSize = 90;

    @ExperimentalFoundationApi
    public static final LazyGridItemProvider rememberItemProvider(LazyGridState state, Function1<? super LazyGridScope, Unit> content, Composer composer, int i) {
        Intrinsics.checkNotNullParameter(state, "state");
        Intrinsics.checkNotNullParameter(content, "content");
        composer.startReplaceableGroup(1895482293);
        ComposerKt.sourceInformation(composer, "C(rememberItemProvider)P(1)37@1458L29,40@1716L290,48@2011L344,55@2368L399:LazyGridItemProviderImpl.kt#7791vq");
        final State stateRememberUpdatedState = SnapshotStateKt.rememberUpdatedState(content, composer, (i >> 3) & 14);
        composer.startReplaceableGroup(1157296644);
        ComposerKt.sourceInformation(composer, "C(remember)P(1):Composables.kt#9igjgp");
        boolean zChanged = composer.changed(state);
        Object objRememberedValue = composer.rememberedValue();
        if (zChanged || objRememberedValue == Composer.INSTANCE.getEmpty()) {
            Snapshot snapshotCreateNonObservableSnapshot = Snapshot.INSTANCE.createNonObservableSnapshot();
            try {
                Snapshot snapshotMakeCurrent = snapshotCreateNonObservableSnapshot.makeCurrent();
                try {
                    IntRange intRangeCalculateNearestItemsRange = calculateNearestItemsRange(state.getFirstVisibleItemIndex());
                    snapshotCreateNonObservableSnapshot.restoreCurrent(snapshotMakeCurrent);
                    snapshotCreateNonObservableSnapshot.dispose();
                    objRememberedValue = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(intRangeCalculateNearestItemsRange, null, 2, null);
                    composer.updateRememberedValue(objRememberedValue);
                } catch (Throwable th) {
                    snapshotCreateNonObservableSnapshot.restoreCurrent(snapshotMakeCurrent);
                    throw th;
                }
            } catch (Throwable th2) {
                snapshotCreateNonObservableSnapshot.dispose();
                throw th2;
            }
        }
        composer.endReplaceableGroup();
        final MutableState mutableState = (MutableState) objRememberedValue;
        EffectsKt.LaunchedEffect(mutableState, new AnonymousClass1(state, mutableState, null), composer, 0);
        composer.startReplaceableGroup(1157296644);
        ComposerKt.sourceInformation(composer, "C(remember)P(1):Composables.kt#9igjgp");
        boolean zChanged2 = composer.changed(mutableState);
        Object objRememberedValue2 = composer.rememberedValue();
        if (zChanged2 || objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
            objRememberedValue2 = new LazyGridItemProviderImpl(SnapshotStateKt.derivedStateOf(new Function0<LazyGridItemsSnapshot>() { // from class: androidx.compose.foundation.lazy.grid.LazyGridItemProviderImplKt$rememberItemProvider$2$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                {
                    super(0);
                }

                /* JADX WARN: Can't rename method to resolve collision */
                @Override // kotlin.jvm.functions.Function0
                public final LazyGridItemsSnapshot invoke() {
                    LazyGridScopeImpl lazyGridScopeImpl = new LazyGridScopeImpl();
                    stateRememberUpdatedState.getValue().invoke(lazyGridScopeImpl);
                    return new LazyGridItemsSnapshot(lazyGridScopeImpl.getIntervals$foundation_release(), lazyGridScopeImpl.getHasCustomSpans(), mutableState.getValue());
                }
            }));
            composer.updateRememberedValue(objRememberedValue2);
        }
        composer.endReplaceableGroup();
        composer.endReplaceableGroup();
        return (LazyGridItemProviderImpl) objRememberedValue2;
    }

    @ExperimentalFoundationApi
    public static final Map<Object, Integer> generateKeyToIndexMap(IntRange range, IntervalList<LazyGridIntervalContent> list) {
        Intrinsics.checkNotNullParameter(range, "range");
        Intrinsics.checkNotNullParameter(list, "list");
        final int first = range.getFirst();
        if (first < 0) {
            throw new IllegalStateException("Check failed.".toString());
        }
        final int iMin = Math.min(range.getLast(), list.getSize() - 1);
        if (iMin < first) {
            return MapsKt.emptyMap();
        }
        final HashMap map = new HashMap();
        list.forEach(first, iMin, new Function1<IntervalList.Interval<LazyGridIntervalContent>, Unit>() { // from class: androidx.compose.foundation.lazy.grid.LazyGridItemProviderImplKt$generateKeyToIndexMap$1$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(IntervalList.Interval<LazyGridIntervalContent> interval) {
                invoke2(interval);
                return Unit.INSTANCE;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(IntervalList.Interval<LazyGridIntervalContent> it) {
                Intrinsics.checkNotNullParameter(it, "it");
                if (it.getValue().getKey() == null) {
                    return;
                }
                Function1<Integer, Object> key = it.getValue().getKey();
                if (key == null) {
                    throw new IllegalArgumentException("Required value was null.".toString());
                }
                int iMax = Math.max(first, it.getStartIndex());
                int iMin2 = Math.min(iMin, (it.getStartIndex() + it.getSize()) - 1);
                if (iMax > iMin2) {
                    return;
                }
                while (true) {
                    map.put(key.invoke(Integer.valueOf(iMax - it.getStartIndex())), Integer.valueOf(iMax));
                    if (iMax == iMin2) {
                        return;
                    } else {
                        iMax++;
                    }
                }
            }
        });
        return map;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final IntRange calculateNearestItemsRange(int i) {
        int i2 = VisibleItemsSlidingWindowSize;
        int i3 = (i / i2) * i2;
        int i4 = ExtraItemsNearTheSlidingWindow;
        return RangesKt.until(Math.max(i3 - i4, 0), i3 + i2 + i4);
    }

    /* JADX INFO: renamed from: androidx.compose.foundation.lazy.grid.LazyGridItemProviderImplKt$rememberItemProvider$1, reason: invalid class name */
    /* JADX INFO: compiled from: LazyGridItemProviderImpl.kt */
    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    @DebugMetadata(c = "androidx.compose.foundation.lazy.grid.LazyGridItemProviderImplKt$rememberItemProvider$1", f = "LazyGridItemProviderImpl.kt", i = {}, l = {53}, m = "invokeSuspend", n = {}, s = {})
    static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ MutableState<IntRange> $nearestItemsRangeState;
        final /* synthetic */ LazyGridState $state;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(LazyGridState lazyGridState, MutableState<IntRange> mutableState, Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
            this.$state = lazyGridState;
            this.$nearestItemsRangeState = mutableState;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new AnonymousClass1(this.$state, this.$nearestItemsRangeState, continuation);
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
                final LazyGridState lazyGridState = this.$state;
                Flow flowSnapshotFlow = SnapshotStateKt.snapshotFlow(new Function0<IntRange>() { // from class: androidx.compose.foundation.lazy.grid.LazyGridItemProviderImplKt.rememberItemProvider.1.1
                    {
                        super(0);
                    }

                    @Override // kotlin.jvm.functions.Function0
                    public final IntRange invoke() {
                        return LazyGridItemProviderImplKt.calculateNearestItemsRange(lazyGridState.getFirstVisibleItemIndex());
                    }
                });
                final MutableState<IntRange> mutableState = this.$nearestItemsRangeState;
                this.label = 1;
                if (flowSnapshotFlow.collect(new FlowCollector<IntRange>() { // from class: androidx.compose.foundation.lazy.grid.LazyGridItemProviderImplKt.rememberItemProvider.1.2
                    @Override // kotlinx.coroutines.flow.FlowCollector
                    public /* bridge */ /* synthetic */ Object emit(IntRange intRange, Continuation continuation) {
                        return emit2(intRange, (Continuation<? super Unit>) continuation);
                    }

                    /* JADX INFO: renamed from: emit, reason: avoid collision after fix types in other method */
                    public final Object emit2(IntRange intRange, Continuation<? super Unit> continuation) {
                        mutableState.setValue(intRange);
                        return Unit.INSTANCE;
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
}
