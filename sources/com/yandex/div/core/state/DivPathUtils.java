package com.yandex.div.core.state;

import android.view.View;
import android.view.ViewGroup;
import androidx.core.view.ViewGroupKt;
import com.yandex.div.core.view2.divs.widgets.DivStateLayout;
import com.yandex.div.internal.core.DivCollectionExtensionsKt;
import com.yandex.div.internal.core.DivItemBuilderResult;
import com.yandex.div.json.expressions.ExpressionResolver;
import com.yandex.div2.Div;
import com.yandex.div2.DivData;
import com.yandex.div2.DivState;
import com.yandex.div2.DivTabs;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: DivPathUtils.kt */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000l\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u001c\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bÀ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J!\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004H\u0000¢\u0006\u0002\b\u0007J\u001e\u0010\b\u001a\u0004\u0018\u00010\t*\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rH\u0002J#\u0010\u000e\u001a\u0004\u0018\u00010\t*\u00020\t2\u0006\u0010\u000f\u001a\u00020\u00052\u0006\u0010\f\u001a\u00020\rH\u0000¢\u0006\u0002\b\u0010JB\u0010\u0011\u001a\u0004\u0018\u00010\t\"\u0004\b\u0000\u0010\u0012*\b\u0012\u0004\u0012\u0002H\u00120\u00132\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0016\b\u0002\u0010\u0014\u001a\u0010\u0012\u0004\u0012\u0002H\u0012\u0012\u0006\u0012\u0004\u0018\u00010\t0\u0015H\u0002J\u001c\u0010\u0011\u001a\u0004\u0018\u00010\t*\b\u0012\u0004\u0012\u00020\u00160\u00132\u0006\u0010\n\u001a\u00020\u000bH\u0002J\u001b\u0010\u0017\u001a\u0004\u0018\u00010\u0018*\u00020\u00192\u0006\u0010\u000f\u001a\u00020\u0005H\u0000¢\u0006\u0002\b\u001aJ#\u0010\u001b\u001a\u00020\u000b*\u00020\u001c2\u0010\b\u0002\u0010\u001d\u001a\n\u0012\u0004\u0012\u00020\u001f\u0018\u00010\u001eH\u0000¢\u0006\u0002\b J9\u0010!\u001a\u0012\u0012\u0006\u0012\u0004\u0018\u00010\u0018\u0012\u0004\u0012\u00020#\u0018\u00010\"*\u00020\u00192\u0006\u0010$\u001a\u00020%2\u0006\u0010\u000f\u001a\u00020\u00052\u0006\u0010\f\u001a\u00020\rH\u0000¢\u0006\u0002\b&¨\u0006'"}, d2 = {"Lcom/yandex/div/core/state/DivPathUtils;", "", "()V", "compactPathList", "", "Lcom/yandex/div/core/state/DivStatePath;", "paths", "compactPathList$div_release", "findByPath", "Lcom/yandex/div2/Div;", "divId", "", "resolver", "Lcom/yandex/div/json/expressions/ExpressionResolver;", "findDivState", "path", "findDivState$div_release", "findRecursively", "T", "", "getDiv", "Lkotlin/Function1;", "Lcom/yandex/div/internal/core/DivItemBuilderResult;", "findStateLayout", "Lcom/yandex/div/core/view2/divs/widgets/DivStateLayout;", "Landroid/view/View;", "findStateLayout$div_release", "getId", "Lcom/yandex/div2/DivState;", "errorCallback", "Lkotlin/Function0;", "", "getId$div_release", "tryFindStateDivAndLayout", "Lkotlin/Pair;", "Lcom/yandex/div2/Div$State;", "state", "Lcom/yandex/div2/DivData$State;", "tryFindStateDivAndLayout$div_release", "div_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class DivPathUtils {
    public static final DivPathUtils INSTANCE = new DivPathUtils();

    private DivPathUtils() {
    }

    public final DivStateLayout findStateLayout$div_release(View view, DivStatePath path) throws StateConflictException {
        Intrinsics.checkNotNullParameter(view, "<this>");
        Intrinsics.checkNotNullParameter(path, "path");
        if (!(view instanceof ViewGroup)) {
            return null;
        }
        if (view instanceof DivStateLayout) {
            DivStateLayout divStateLayout = (DivStateLayout) view;
            DivStatePath path2 = divStateLayout.getPath();
            if (Intrinsics.areEqual(path2 != null ? path2.getPathToLastState() : null, path.getPathToLastState())) {
                return divStateLayout;
            }
        }
        Iterator<View> it = ViewGroupKt.getChildren((ViewGroup) view).iterator();
        DivStateLayout divStateLayout2 = null;
        while (it.hasNext()) {
            DivStateLayout divStateLayoutFindStateLayout$div_release = findStateLayout$div_release(it.next(), path);
            if (divStateLayoutFindStateLayout$div_release != null) {
                if (Intrinsics.areEqual(String.valueOf(divStateLayout2 != null ? divStateLayout2.getPath() : null), String.valueOf(divStateLayoutFindStateLayout$div_release.getPath()))) {
                    throw new StateConflictException("Error resolving state for '" + path + "'. Found multiple elements that respond to path '" + divStateLayoutFindStateLayout$div_release.getPath() + "'!", null, 2, null);
                }
                divStateLayout2 = divStateLayoutFindStateLayout$div_release;
            }
        }
        return divStateLayout2;
    }

    public final Div findDivState$div_release(Div div, DivStatePath path, ExpressionResolver resolver) {
        Intrinsics.checkNotNullParameter(div, "<this>");
        Intrinsics.checkNotNullParameter(path, "path");
        Intrinsics.checkNotNullParameter(resolver, "resolver");
        List<Pair<String, String>> states = path.getStates();
        if (states.isEmpty()) {
            return null;
        }
        Iterator<T> it = states.iterator();
        while (it.hasNext()) {
            String str = (String) ((Pair) it.next()).component1();
            if (div == null || (div = INSTANCE.findByPath(div, str, resolver)) == null) {
                return null;
            }
        }
        return div;
    }

    public final Pair<DivStateLayout, Div.State> tryFindStateDivAndLayout$div_release(View view, DivData.State state, DivStatePath path, ExpressionResolver resolver) throws StateConflictException {
        Intrinsics.checkNotNullParameter(view, "<this>");
        Intrinsics.checkNotNullParameter(state, "state");
        Intrinsics.checkNotNullParameter(path, "path");
        Intrinsics.checkNotNullParameter(resolver, "resolver");
        DivStateLayout divStateLayoutFindStateLayout$div_release = findStateLayout$div_release(view, path);
        if (divStateLayoutFindStateLayout$div_release == null) {
            DivStatePath divStatePathParentState = path.parentState();
            if ((divStatePathParentState.isRootPath() && state.stateId == path.getTopLevelStateId()) || findStateLayout$div_release(view, divStatePathParentState) == null) {
                return null;
            }
        }
        Div divFindDivState$div_release = findDivState$div_release(state.div, path, resolver);
        Div.State state2 = divFindDivState$div_release instanceof Div.State ? (Div.State) divFindDivState$div_release : null;
        if (state2 == null) {
            return null;
        }
        return new Pair<>(divStateLayoutFindStateLayout$div_release, state2);
    }

    public final List<DivStatePath> compactPathList$div_release(List<DivStatePath> paths) {
        ArrayList arrayListListOf;
        Intrinsics.checkNotNullParameter(paths, "paths");
        if (paths.isEmpty()) {
            return paths;
        }
        List listSortedWith = CollectionsKt.sortedWith(paths, DivStatePath.INSTANCE.alphabeticalComparator$div_release());
        List<DivStatePath> list = listSortedWith;
        Object objFirst = CollectionsKt.first((List<? extends Object>) listSortedWith);
        int iCollectionSizeOrDefault = CollectionsKt.collectionSizeOrDefault(list, 9);
        if (iCollectionSizeOrDefault == 0) {
            arrayListListOf = CollectionsKt.listOf(objFirst);
        } else {
            ArrayList arrayList = new ArrayList(iCollectionSizeOrDefault + 1);
            arrayList.add(objFirst);
            Object obj = objFirst;
            for (DivStatePath divStatePath : list) {
                DivStatePath divStatePath2 = (DivStatePath) obj;
                if (!divStatePath2.isAncestorOf(divStatePath)) {
                    divStatePath2 = divStatePath;
                }
                arrayList.add(divStatePath2);
                obj = divStatePath2;
            }
            arrayListListOf = arrayList;
        }
        return CollectionsKt.distinct(arrayListListOf);
    }

    private final Div findByPath(Div div, String str, ExpressionResolver expressionResolver) {
        if (div instanceof Div.State) {
            Div.State state = (Div.State) div;
            if (!Intrinsics.areEqual(getId$div_release$default(INSTANCE, state.getValue(), null, 1, null), str)) {
                div = null;
            }
            Div.State state2 = (Div.State) div;
            return state2 != null ? state2 : findRecursively(state.getValue().states, str, expressionResolver, new Function1<DivState.State, Div>() { // from class: com.yandex.div.core.state.DivPathUtils.findByPath.2
                @Override // kotlin.jvm.functions.Function1
                public final Div invoke(DivState.State it) {
                    Intrinsics.checkNotNullParameter(it, "it");
                    return it.div;
                }
            });
        }
        if (div instanceof Div.Tabs) {
            return findRecursively(((Div.Tabs) div).getValue().items, str, expressionResolver, new Function1<DivTabs.Item, Div>() { // from class: com.yandex.div.core.state.DivPathUtils.findByPath.3
                @Override // kotlin.jvm.functions.Function1
                public final Div invoke(DivTabs.Item it) {
                    Intrinsics.checkNotNullParameter(it, "it");
                    return it.div;
                }
            });
        }
        if (div instanceof Div.Container) {
            return findRecursively(DivCollectionExtensionsKt.buildItems(((Div.Container) div).getValue(), expressionResolver), str);
        }
        if (div instanceof Div.Grid) {
            return findRecursively$default(this, DivCollectionExtensionsKt.getNonNullItems(((Div.Grid) div).getValue()), str, expressionResolver, null, 4, null);
        }
        if (div instanceof Div.Gallery) {
            return findRecursively(DivCollectionExtensionsKt.buildItems(((Div.Gallery) div).getValue(), expressionResolver), str);
        }
        if (div instanceof Div.Pager) {
            return findRecursively(DivCollectionExtensionsKt.buildItems(((Div.Pager) div).getValue(), expressionResolver), str);
        }
        if (div instanceof Div.Custom) {
            List<Div> list = ((Div.Custom) div).getValue().items;
            if (list != null) {
                return findRecursively$default(this, list, str, expressionResolver, null, 4, null);
            }
            return null;
        }
        if ((div instanceof Div.Text) || (div instanceof Div.Image) || (div instanceof Div.Slider) || (div instanceof Div.Input) || (div instanceof Div.GifImage) || (div instanceof Div.Indicator) || (div instanceof Div.Separator) || (div instanceof Div.Select) || (div instanceof Div.Video) || (div instanceof Div.Switch)) {
            return null;
        }
        throw new NoWhenBranchMatchedException();
    }

    static /* synthetic */ Div findRecursively$default(DivPathUtils divPathUtils, Iterable iterable, String str, ExpressionResolver expressionResolver, Function1 function1, int i, Object obj) {
        if ((i & 4) != 0) {
            function1 = new Function1<T, Div>() { // from class: com.yandex.div.core.state.DivPathUtils.findRecursively.1
                /* JADX WARN: Can't rename method to resolve collision */
                /* JADX WARN: Multi-variable type inference failed */
                @Override // kotlin.jvm.functions.Function1
                public final Div invoke(T t) {
                    return (Div) t;
                }
            };
        }
        return divPathUtils.findRecursively(iterable, str, expressionResolver, function1);
    }

    private final <T> Div findRecursively(Iterable<? extends T> iterable, String str, ExpressionResolver expressionResolver, Function1<? super T, ? extends Div> function1) {
        Div divFindByPath;
        Iterator<? extends T> it = iterable.iterator();
        do {
            divFindByPath = null;
            if (!it.hasNext()) {
                break;
            }
            Div divInvoke = function1.invoke(it.next());
            if (divInvoke != null) {
                divFindByPath = INSTANCE.findByPath(divInvoke, str, expressionResolver);
            }
        } while (divFindByPath == null);
        return divFindByPath;
    }

    private final Div findRecursively(Iterable<DivItemBuilderResult> iterable, String str) {
        for (DivItemBuilderResult divItemBuilderResult : iterable) {
            Div divFindByPath = INSTANCE.findByPath(divItemBuilderResult.getDiv(), str, divItemBuilderResult.getExpressionResolver());
            if (divFindByPath != null) {
                return divFindByPath;
            }
        }
        return null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ String getId$div_release$default(DivPathUtils divPathUtils, DivState divState, Function0 function0, int i, Object obj) {
        if ((i & 1) != 0) {
            function0 = null;
        }
        return divPathUtils.getId$div_release(divState, function0);
    }

    public final String getId$div_release(DivState divState, Function0<Unit> function0) {
        Intrinsics.checkNotNullParameter(divState, "<this>");
        String str = divState.divId;
        if (str != null) {
            return str;
        }
        String id = divState.getId();
        if (id != null) {
            return id;
        }
        if (function0 != null) {
            function0.invoke();
        }
        return "";
    }
}
