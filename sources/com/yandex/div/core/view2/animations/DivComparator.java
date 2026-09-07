package com.yandex.div.core.view2.animations;

import com.yandex.div.core.view2.divs.BaseDivViewExtensionsKt;
import com.yandex.div.internal.core.DivCollectionExtensionsKt;
import com.yandex.div.internal.core.DivItemBuilderResult;
import com.yandex.div.json.expressions.ExpressionResolver;
import com.yandex.div2.Div;
import com.yandex.div2.DivBase;
import com.yandex.div2.DivContainer;
import com.yandex.div2.DivCustom;
import com.yandex.div2.DivData;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: DivComparator.kt */
/* JADX INFO: loaded from: classes10.dex */
@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\bÀ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J.\u0010\u0003\u001a\u00020\u00042\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\nJ6\u0010\u000b\u001a\u00020\u00042\b\u0010\f\u001a\u0004\u0018\u00010\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\r2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00102\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\nJ2\u0010\u0012\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\u00132\u0006\u0010\u000e\u001a\u00020\u00132\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00102\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\nJ\u001e\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\u0006\u0010\u0015\u001a\u00020\r2\u0006\u0010\u0016\u001a\u00020\u0010H\u0002J<\u0010\u0017\u001a\u00020\u00042\b\u0010\f\u001a\u0004\u0018\u00010\u00182\u0006\u0010\u000e\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00102\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\nJ\f\u0010\u001b\u001a\u00020\u0004*\u00020\u0013H\u0002J\u0014\u0010\u001c\u001a\u00020\u0004*\u00020\u001d2\u0006\u0010\u0016\u001a\u00020\u0010H\u0002¨\u0006\u001e"}, d2 = {"Lcom/yandex/div/core/view2/animations/DivComparator;", "", "()V", "areChildrenReplaceable", "", "oldChildren", "", "Lcom/yandex/div/internal/core/DivItemBuilderResult;", "newChildren", "reporter", "Lcom/yandex/div/core/view2/animations/DivComparatorReporter;", "areDivsReplaceable", "old", "Lcom/yandex/div2/Div;", "new", "oldResolver", "Lcom/yandex/div/json/expressions/ExpressionResolver;", "newResolver", "areValuesReplaceable", "Lcom/yandex/div2/DivBase;", "extractChildren", "div", "resolver", "isDivDataReplaceable", "Lcom/yandex/div2/DivData;", "stateId", "", "hasTransitions", "isOverlap", "Lcom/yandex/div2/DivContainer;", "div_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class DivComparator {
    public static final DivComparator INSTANCE = new DivComparator();

    private DivComparator() {
    }

    public final boolean isDivDataReplaceable(DivData old, DivData divData, long stateId, ExpressionResolver oldResolver, ExpressionResolver newResolver, DivComparatorReporter reporter) {
        Object obj;
        Object next;
        Intrinsics.checkNotNullParameter(divData, "new");
        Intrinsics.checkNotNullParameter(oldResolver, "oldResolver");
        Intrinsics.checkNotNullParameter(newResolver, "newResolver");
        if (old == null) {
            if (reporter != null) {
                reporter.onComparisonNoOldData();
            }
            return false;
        }
        Iterator<T> it = old.states.iterator();
        do {
            obj = null;
            if (!it.hasNext()) {
                next = null;
                break;
            }
            next = it.next();
        } while (((DivData.State) next).stateId != stateId);
        DivData.State state = (DivData.State) next;
        for (Object obj2 : divData.states) {
            if (((DivData.State) obj2).stateId == stateId) {
                obj = obj2;
                break;
            }
        }
        DivData.State state2 = (DivData.State) obj;
        if (state == null || state2 == null) {
            if (reporter != null) {
                reporter.onComparisonNoState();
            }
            return false;
        }
        boolean zAreDivsReplaceable = areDivsReplaceable(state.div, state2.div, oldResolver, newResolver, reporter);
        if (zAreDivsReplaceable && reporter != null) {
            reporter.onComparisonSuccess();
        }
        return zAreDivsReplaceable;
    }

    public static /* synthetic */ boolean areDivsReplaceable$default(DivComparator divComparator, Div div, Div div2, ExpressionResolver expressionResolver, ExpressionResolver expressionResolver2, DivComparatorReporter divComparatorReporter, int i, Object obj) {
        if ((i & 16) != 0) {
            divComparatorReporter = null;
        }
        return divComparator.areDivsReplaceable(div, div2, expressionResolver, expressionResolver2, divComparatorReporter);
    }

    public final boolean areDivsReplaceable(Div old, Div div, ExpressionResolver oldResolver, ExpressionResolver newResolver, DivComparatorReporter reporter) {
        Intrinsics.checkNotNullParameter(oldResolver, "oldResolver");
        Intrinsics.checkNotNullParameter(newResolver, "newResolver");
        if (!Intrinsics.areEqual(old != null ? old.getClass() : null, div != null ? div.getClass() : null)) {
            if (reporter != null) {
                reporter.onComparisonDifferentClasses();
            }
            return false;
        }
        if (old == null || div == null || old == div) {
            return true;
        }
        return areValuesReplaceable(old.value(), div.value(), oldResolver, newResolver, reporter) && areChildrenReplaceable(extractChildren(old, oldResolver), extractChildren(div, newResolver), reporter);
    }

    public static /* synthetic */ boolean areValuesReplaceable$default(DivComparator divComparator, DivBase divBase, DivBase divBase2, ExpressionResolver expressionResolver, ExpressionResolver expressionResolver2, DivComparatorReporter divComparatorReporter, int i, Object obj) {
        if ((i & 16) != 0) {
            divComparatorReporter = null;
        }
        return divComparator.areValuesReplaceable(divBase, divBase2, expressionResolver, expressionResolver2, divComparatorReporter);
    }

    public final boolean areValuesReplaceable(DivBase old, DivBase divBase, ExpressionResolver oldResolver, ExpressionResolver newResolver, DivComparatorReporter reporter) {
        Intrinsics.checkNotNullParameter(old, "old");
        Intrinsics.checkNotNullParameter(divBase, "new");
        Intrinsics.checkNotNullParameter(oldResolver, "oldResolver");
        Intrinsics.checkNotNullParameter(newResolver, "newResolver");
        if (old.getId() != null && divBase.getId() != null && !Intrinsics.areEqual(old.getId(), divBase.getId()) && (hasTransitions(old) || hasTransitions(divBase))) {
            if (reporter != null) {
                reporter.onComparisonDifferentIdsWithTransition();
            }
            return false;
        }
        if ((old instanceof DivCustom) && (divBase instanceof DivCustom) && !Intrinsics.areEqual(((DivCustom) old).customType, ((DivCustom) divBase).customType)) {
            if (reporter != null) {
                reporter.onComparisonDifferentCustomTypes();
            }
            return false;
        }
        if (!(old instanceof DivContainer) || !(divBase instanceof DivContainer)) {
            return true;
        }
        DivContainer divContainer = (DivContainer) old;
        DivContainer divContainer2 = (DivContainer) divBase;
        if (isOverlap(divContainer, oldResolver) != isOverlap(divContainer2, newResolver)) {
            if (reporter != null) {
                reporter.onComparisonDifferentOverlap();
            }
            return false;
        }
        if (BaseDivViewExtensionsKt.isWrapContainer(divContainer, oldResolver) == BaseDivViewExtensionsKt.isWrapContainer(divContainer2, newResolver)) {
            return true;
        }
        if (reporter != null) {
            reporter.onComparisonDifferentWrap();
        }
        return false;
    }

    public static /* synthetic */ boolean areChildrenReplaceable$default(DivComparator divComparator, List list, List list2, DivComparatorReporter divComparatorReporter, int i, Object obj) {
        if ((i & 4) != 0) {
            divComparatorReporter = null;
        }
        return divComparator.areChildrenReplaceable(list, list2, divComparatorReporter);
    }

    public final boolean areChildrenReplaceable(List<DivItemBuilderResult> oldChildren, List<DivItemBuilderResult> newChildren, DivComparatorReporter reporter) {
        Intrinsics.checkNotNullParameter(oldChildren, "oldChildren");
        Intrinsics.checkNotNullParameter(newChildren, "newChildren");
        if (oldChildren.size() != newChildren.size()) {
            if (reporter != null) {
                reporter.onComparisonDifferentChildCount();
            }
            return false;
        }
        List<Pair> listZip = CollectionsKt.zip(oldChildren, newChildren);
        if (!(listZip instanceof Collection) || !listZip.isEmpty()) {
            for (Pair pair : listZip) {
                if (!INSTANCE.areDivsReplaceable(((DivItemBuilderResult) pair.getFirst()).getDiv(), ((DivItemBuilderResult) pair.getSecond()).getDiv(), ((DivItemBuilderResult) pair.getFirst()).getExpressionResolver(), ((DivItemBuilderResult) pair.getSecond()).getExpressionResolver(), reporter)) {
                    return false;
                }
            }
        }
        return true;
    }

    private final List<DivItemBuilderResult> extractChildren(Div div, ExpressionResolver resolver) {
        if (div instanceof Div.Container) {
            return DivCollectionExtensionsKt.buildItems(((Div.Container) div).getValue(), resolver);
        }
        if (div instanceof Div.Grid) {
            return DivCollectionExtensionsKt.itemsToDivItemBuilderResult(((Div.Grid) div).getValue(), resolver);
        }
        if (!(div instanceof Div.Image) && !(div instanceof Div.GifImage) && !(div instanceof Div.Text) && !(div instanceof Div.Separator) && !(div instanceof Div.Gallery) && !(div instanceof Div.Pager) && !(div instanceof Div.Tabs) && !(div instanceof Div.State) && !(div instanceof Div.Custom) && !(div instanceof Div.Input) && !(div instanceof Div.Select) && !(div instanceof Div.Indicator) && !(div instanceof Div.Slider) && !(div instanceof Div.Video) && !(div instanceof Div.Switch)) {
            throw new NoWhenBranchMatchedException();
        }
        return CollectionsKt.emptyList();
    }

    private final boolean hasTransitions(DivBase divBase) {
        return (divBase.getTransitionIn() == null && divBase.getTransitionOut() == null && divBase.getTransitionChange() == null) ? false : true;
    }

    private final boolean isOverlap(DivContainer divContainer, ExpressionResolver expressionResolver) {
        return divContainer.orientation.evaluate(expressionResolver) == DivContainer.Orientation.OVERLAP;
    }
}
