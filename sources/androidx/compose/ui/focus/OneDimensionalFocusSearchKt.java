package androidx.compose.ui.focus;

import androidx.compose.runtime.collection.MutableVector;
import androidx.compose.ui.layout.BeyondBoundsLayout;
import androidx.compose.ui.node.LayoutNode;
import androidx.compose.ui.node.LayoutNodeWrapper;
import java.util.Comparator;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.comparisons.ComparisonsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntRange;

/* JADX INFO: compiled from: OneDimensionalFocusSearch.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u00000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\f\u001a \u0010\u0003\u001a\u00020\u0004*\u00020\u00052\u0012\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00040\u0007H\u0002\u001aE\u0010\b\u001a\u00020\t\"\u0004\b\u0000\u0010\n*\b\u0012\u0004\u0012\u0002H\n0\u000b2\u0006\u0010\f\u001a\u0002H\n2\u0012\u0010\r\u001a\u000e\u0012\u0004\u0012\u0002H\n\u0012\u0004\u0012\u00020\t0\u0007H\u0082\b\u0082\u0002\b\n\u0006\b\u0001\u0012\u0002\u0010\u0002¢\u0006\u0002\u0010\u000e\u001aE\u0010\u000f\u001a\u00020\t\"\u0004\b\u0000\u0010\n*\b\u0012\u0004\u0012\u0002H\n0\u000b2\u0006\u0010\f\u001a\u0002H\n2\u0012\u0010\r\u001a\u000e\u0012\u0004\u0012\u0002H\n\u0012\u0004\u0012\u00020\t0\u0007H\u0082\b\u0082\u0002\b\n\u0006\b\u0001\u0012\u0002\u0010\u0002¢\u0006\u0002\u0010\u000e\u001a \u0010\u0010\u001a\u00020\u0004*\u00020\u00052\u0012\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00040\u0007H\u0002\u001a=\u0010\u0011\u001a\u00020\u0004*\u00020\u00052\u0006\u0010\u0012\u001a\u00020\u00052\u0006\u0010\u0013\u001a\u00020\u00142\u0012\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00040\u0007H\u0002ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u0015\u0010\u0016\u001a\f\u0010\u0017\u001a\u00020\u0004*\u00020\u0005H\u0002\u001a5\u0010\u0018\u001a\u00020\u0004*\u00020\u00052\u0006\u0010\u0013\u001a\u00020\u00142\u0012\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00040\u0007H\u0000ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u0019\u0010\u001a\u001a \u0010\u001b\u001a\u00020\u0004*\u00020\u00052\u0012\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00040\u0007H\u0002\u001a \u0010\u001c\u001a\u00020\u0004*\u00020\u00052\u0012\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00040\u0007H\u0002\u001a=\u0010\u001d\u001a\u00020\u0004*\u00020\u00052\u0006\u0010\u0012\u001a\u00020\u00052\u0006\u0010\u0013\u001a\u00020\u00142\u0012\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00040\u0007H\u0002ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u001e\u0010\u0016\u001a\u0012\u0010\u001f\u001a\u00020\t*\b\u0012\u0004\u0012\u00020\u00050\u000bH\u0002\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0002\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\u0082\u0002\u000b\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001¨\u0006 "}, d2 = {"InvalidFocusDirection", "", "NoActiveChild", "backwardFocusSearch", "", "Landroidx/compose/ui/focus/FocusModifier;", "onFound", "Lkotlin/Function1;", "forEachItemAfter", "", "T", "Landroidx/compose/runtime/collection/MutableVector;", "item", "action", "(Landroidx/compose/runtime/collection/MutableVector;Ljava/lang/Object;Lkotlin/jvm/functions/Function1;)V", "forEachItemBefore", "forwardFocusSearch", "generateAndSearchChildren", "focusedItem", "direction", "Landroidx/compose/ui/focus/FocusDirection;", "generateAndSearchChildren-4C6V_qg", "(Landroidx/compose/ui/focus/FocusModifier;Landroidx/compose/ui/focus/FocusModifier;ILkotlin/jvm/functions/Function1;)Z", "isRoot", "oneDimensionalFocusSearch", "oneDimensionalFocusSearch--OM-vw8", "(Landroidx/compose/ui/focus/FocusModifier;ILkotlin/jvm/functions/Function1;)Z", "pickChildForBackwardSearch", "pickChildForForwardSearch", "searchChildren", "searchChildren-4C6V_qg", "sort", "ui_release"}, k = 2, mv = {1, 6, 0}, xi = 48)
public final class OneDimensionalFocusSearchKt {
    private static final String InvalidFocusDirection = "This function should only be used for 1-D focus search";
    private static final String NoActiveChild = "ActiveParent must have a focusedChild";

    /* JADX INFO: compiled from: OneDimensionalFocusSearch.kt */
    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[FocusStateImpl.values().length];
            iArr[FocusStateImpl.ActiveParent.ordinal()] = 1;
            iArr[FocusStateImpl.DeactivatedParent.ordinal()] = 2;
            iArr[FocusStateImpl.Active.ordinal()] = 3;
            iArr[FocusStateImpl.Captured.ordinal()] = 4;
            iArr[FocusStateImpl.Deactivated.ordinal()] = 5;
            iArr[FocusStateImpl.Inactive.ordinal()] = 6;
            $EnumSwitchMapping$0 = iArr;
        }
    }

    /* JADX INFO: renamed from: oneDimensionalFocusSearch--OM-vw8, reason: not valid java name */
    public static final boolean m1351oneDimensionalFocusSearchOMvw8(FocusModifier oneDimensionalFocusSearch, int i, Function1<? super FocusModifier, Boolean> onFound) {
        Intrinsics.checkNotNullParameter(oneDimensionalFocusSearch, "$this$oneDimensionalFocusSearch");
        Intrinsics.checkNotNullParameter(onFound, "onFound");
        if (FocusDirection.m1331equalsimpl0(i, FocusDirection.INSTANCE.m1340getNextdhqQ8s())) {
            return forwardFocusSearch(oneDimensionalFocusSearch, onFound);
        }
        if (FocusDirection.m1331equalsimpl0(i, FocusDirection.INSTANCE.m1342getPreviousdhqQ8s())) {
            return backwardFocusSearch(oneDimensionalFocusSearch, onFound);
        }
        throw new IllegalStateException(InvalidFocusDirection.toString());
    }

    private static final boolean forwardFocusSearch(FocusModifier focusModifier, Function1<? super FocusModifier, Boolean> function1) {
        switch (WhenMappings.$EnumSwitchMapping$0[focusModifier.getFocusState().ordinal()]) {
            case 1:
            case 2:
                FocusModifier focusedChild = focusModifier.getFocusedChild();
                if (focusedChild != null) {
                    return forwardFocusSearch(focusedChild, function1) || m1350generateAndSearchChildren4C6V_qg(focusModifier, focusedChild, FocusDirection.INSTANCE.m1340getNextdhqQ8s(), function1);
                }
                throw new IllegalStateException(NoActiveChild.toString());
            case 3:
            case 4:
            case 5:
                return pickChildForForwardSearch(focusModifier, function1);
            case 6:
                return function1.invoke(focusModifier).booleanValue();
            default:
                throw new NoWhenBranchMatchedException();
        }
    }

    private static final boolean backwardFocusSearch(FocusModifier focusModifier, Function1<? super FocusModifier, Boolean> function1) {
        switch (WhenMappings.$EnumSwitchMapping$0[focusModifier.getFocusState().ordinal()]) {
            case 1:
            case 2:
                FocusModifier focusedChild = focusModifier.getFocusedChild();
                if (focusedChild == null) {
                    throw new IllegalStateException(NoActiveChild.toString());
                }
                switch (WhenMappings.$EnumSwitchMapping$0[focusedChild.getFocusState().ordinal()]) {
                    case 1:
                        if (!backwardFocusSearch(focusedChild, function1) && !function1.invoke(focusedChild).booleanValue()) {
                            return false;
                        }
                        break;
                    case 2:
                        if (!backwardFocusSearch(focusedChild, function1) && !m1350generateAndSearchChildren4C6V_qg(focusModifier, focusedChild, FocusDirection.INSTANCE.m1342getPreviousdhqQ8s(), function1)) {
                            return false;
                        }
                        break;
                    case 3:
                    case 4:
                        return m1350generateAndSearchChildren4C6V_qg(focusModifier, focusedChild, FocusDirection.INSTANCE.m1342getPreviousdhqQ8s(), function1);
                    case 5:
                    case 6:
                        throw new IllegalStateException(NoActiveChild.toString());
                    default:
                        throw new NoWhenBranchMatchedException();
                }
                break;
            case 3:
            case 4:
            case 5:
                return pickChildForBackwardSearch(focusModifier, function1);
            case 6:
                if (!pickChildForBackwardSearch(focusModifier, function1) && !function1.invoke(focusModifier).booleanValue()) {
                    return false;
                }
                break;
            default:
                throw new NoWhenBranchMatchedException();
        }
        return true;
    }

    /* JADX INFO: renamed from: generateAndSearchChildren-4C6V_qg, reason: not valid java name */
    private static final boolean m1350generateAndSearchChildren4C6V_qg(final FocusModifier focusModifier, final FocusModifier focusModifier2, final int i, final Function1<? super FocusModifier, Boolean> function1) {
        if (m1352searchChildren4C6V_qg(focusModifier, focusModifier2, i, function1)) {
            return true;
        }
        Boolean bool = (Boolean) BeyondBoundsLayoutKt.m1327searchBeyondBoundsOMvw8(focusModifier, i, new Function1<BeyondBoundsLayout.BeyondBoundsScope, Boolean>() { // from class: androidx.compose.ui.focus.OneDimensionalFocusSearchKt$generateAndSearchChildren$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Boolean invoke(BeyondBoundsLayout.BeyondBoundsScope searchBeyondBounds) {
                Intrinsics.checkNotNullParameter(searchBeyondBounds, "$this$searchBeyondBounds");
                Boolean boolValueOf = Boolean.valueOf(OneDimensionalFocusSearchKt.m1352searchChildren4C6V_qg(focusModifier, focusModifier2, i, function1));
                if (boolValueOf.booleanValue() || !searchBeyondBounds.getHasMoreContent()) {
                    return boolValueOf;
                }
                return null;
            }
        });
        if (bool != null) {
            return bool.booleanValue();
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: searchChildren-4C6V_qg, reason: not valid java name */
    public static final boolean m1352searchChildren4C6V_qg(FocusModifier focusModifier, FocusModifier focusModifier2, int i, Function1<? super FocusModifier, Boolean> function1) {
        if (focusModifier.getFocusState() != FocusStateImpl.ActiveParent && focusModifier.getFocusState() != FocusStateImpl.DeactivatedParent) {
            throw new IllegalStateException("This function should only be used within a parent that has focus.".toString());
        }
        sort(focusModifier.getChildren());
        if (!FocusDirection.m1331equalsimpl0(i, FocusDirection.INSTANCE.m1340getNextdhqQ8s())) {
            if (FocusDirection.m1331equalsimpl0(i, FocusDirection.INSTANCE.m1342getPreviousdhqQ8s())) {
                MutableVector<FocusModifier> children = focusModifier.getChildren();
                IntRange intRange = new IntRange(0, children.getSize() - 1);
                int first = intRange.getFirst();
                int last = intRange.getLast();
                if (first <= last) {
                    boolean z = false;
                    while (true) {
                        if (z) {
                            FocusModifier focusModifier3 = children.getContent()[last];
                            if (FocusTraversalKt.isEligibleForFocusSearch(focusModifier3) && backwardFocusSearch(focusModifier3, function1)) {
                                return true;
                            }
                        }
                        if (Intrinsics.areEqual(children.getContent()[last], focusModifier2)) {
                            z = true;
                        }
                        if (last == first) {
                            break;
                        }
                        last--;
                    }
                }
            } else {
                throw new IllegalStateException(InvalidFocusDirection.toString());
            }
        } else {
            MutableVector<FocusModifier> children2 = focusModifier.getChildren();
            IntRange intRange2 = new IntRange(0, children2.getSize() - 1);
            int first2 = intRange2.getFirst();
            int last2 = intRange2.getLast();
            if (first2 <= last2) {
                boolean z2 = false;
                while (true) {
                    if (z2) {
                        FocusModifier focusModifier4 = children2.getContent()[first2];
                        if (FocusTraversalKt.isEligibleForFocusSearch(focusModifier4) && forwardFocusSearch(focusModifier4, function1)) {
                            return true;
                        }
                    }
                    if (Intrinsics.areEqual(children2.getContent()[first2], focusModifier2)) {
                        z2 = true;
                    }
                    if (first2 == last2) {
                        break;
                    }
                    first2++;
                }
            }
        }
        if (FocusDirection.m1331equalsimpl0(i, FocusDirection.INSTANCE.m1340getNextdhqQ8s()) || focusModifier.getFocusState() == FocusStateImpl.DeactivatedParent || isRoot(focusModifier)) {
            return false;
        }
        return function1.invoke(focusModifier).booleanValue();
    }

    private static final boolean pickChildForForwardSearch(FocusModifier focusModifier, Function1<? super FocusModifier, Boolean> function1) {
        sort(focusModifier.getChildren());
        MutableVector<FocusModifier> children = focusModifier.getChildren();
        int size = children.getSize();
        if (size <= 0) {
            return false;
        }
        FocusModifier[] content = children.getContent();
        int i = 0;
        do {
            FocusModifier focusModifier2 = content[i];
            if (FocusTraversalKt.isEligibleForFocusSearch(focusModifier2) && forwardFocusSearch(focusModifier2, function1)) {
                return true;
            }
            i++;
        } while (i < size);
        return false;
    }

    private static final boolean pickChildForBackwardSearch(FocusModifier focusModifier, Function1<? super FocusModifier, Boolean> function1) {
        sort(focusModifier.getChildren());
        MutableVector<FocusModifier> children = focusModifier.getChildren();
        int size = children.getSize();
        if (size <= 0) {
            return false;
        }
        int i = size - 1;
        FocusModifier[] content = children.getContent();
        do {
            FocusModifier focusModifier2 = content[i];
            if (FocusTraversalKt.isEligibleForFocusSearch(focusModifier2) && backwardFocusSearch(focusModifier2, function1)) {
                return true;
            }
            i--;
        } while (i >= 0);
        return false;
    }

    private static final boolean isRoot(FocusModifier focusModifier) {
        return focusModifier.getParent() == null;
    }

    private static final void sort(MutableVector<FocusModifier> mutableVector) {
        mutableVector.sortWith(new Comparator() { // from class: androidx.compose.ui.focus.OneDimensionalFocusSearchKt$sort$$inlined$compareBy$1
            /* JADX WARN: Multi-variable type inference failed */
            @Override // java.util.Comparator
            public final int compare(T t, T t2) {
                LayoutNode layoutNode;
                LayoutNode layoutNode2;
                LayoutNodeWrapper layoutNodeWrapper = ((FocusModifier) t).getLayoutNodeWrapper();
                Integer numValueOf = null;
                Integer numValueOf2 = (layoutNodeWrapper == null || (layoutNode2 = layoutNodeWrapper.getLayoutNode()) == null) ? null : Integer.valueOf(layoutNode2.getPlaceOrder());
                LayoutNodeWrapper layoutNodeWrapper2 = ((FocusModifier) t2).getLayoutNodeWrapper();
                if (layoutNodeWrapper2 != null && (layoutNode = layoutNodeWrapper2.getLayoutNode()) != null) {
                    numValueOf = Integer.valueOf(layoutNode.getPlaceOrder());
                }
                return ComparisonsKt.compareValues(numValueOf2, numValueOf);
            }
        });
    }

    private static final <T> void forEachItemAfter(MutableVector<T> mutableVector, T t, Function1<? super T, Unit> function1) {
        boolean z = false;
        IntRange intRange = new IntRange(0, mutableVector.getSize() - 1);
        int first = intRange.getFirst();
        int last = intRange.getLast();
        if (first > last) {
            return;
        }
        while (true) {
            if (z) {
                function1.invoke(mutableVector.getContent()[first]);
            }
            if (Intrinsics.areEqual(mutableVector.getContent()[first], t)) {
                z = true;
            }
            if (first == last) {
                return;
            } else {
                first++;
            }
        }
    }

    private static final <T> void forEachItemBefore(MutableVector<T> mutableVector, T t, Function1<? super T, Unit> function1) {
        boolean z = false;
        IntRange intRange = new IntRange(0, mutableVector.getSize() - 1);
        int first = intRange.getFirst();
        int last = intRange.getLast();
        if (first > last) {
            return;
        }
        while (true) {
            if (z) {
                function1.invoke(mutableVector.getContent()[last]);
            }
            if (Intrinsics.areEqual(mutableVector.getContent()[last], t)) {
                z = true;
            }
            if (last == first) {
                return;
            } else {
                last--;
            }
        }
    }
}
