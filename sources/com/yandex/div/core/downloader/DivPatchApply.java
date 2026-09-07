package com.yandex.div.core.downloader;

import android.view.View;
import android.view.ViewGroup;
import androidx.core.view.ViewGroupKt;
import androidx.recyclerview.widget.RecyclerView;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.yandex.div.core.DivActionHandler;
import com.yandex.div.core.view2.divs.gallery.DivGalleryAdapter;
import com.yandex.div.core.view2.divs.widgets.DivPagerView;
import com.yandex.div.core.view2.divs.widgets.DivRecyclerView;
import com.yandex.div.internal.Assert;
import com.yandex.div.internal.KAssert;
import com.yandex.div.internal.KLog;
import com.yandex.div.internal.core.DivCollectionExtensionsKt;
import com.yandex.div.json.expressions.ExpressionResolver;
import com.yandex.div.logging.Severity;
import com.yandex.div2.Div;
import com.yandex.div2.DivBase;
import com.yandex.div2.DivContainer;
import com.yandex.div2.DivCustom;
import com.yandex.div2.DivData;
import com.yandex.div2.DivGallery;
import com.yandex.div2.DivGrid;
import com.yandex.div2.DivPager;
import com.yandex.div2.DivPatch;
import com.yandex.div2.DivState;
import com.yandex.div2.DivTabs;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.ListIterator;
import java.util.Set;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: DivPatchApply.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000¢\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010#\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010(\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010!\n\u0002\b\u0004\b\u0000\u0018\u0000 =2\u00020\u0001:\u0001=B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0018\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rH\u0002J\u0018\u0010\b\u001a\u00020\u000e2\u0006\u0010\n\u001a\u00020\u000f2\u0006\u0010\f\u001a\u00020\rH\u0002J\u0018\u0010\b\u001a\u00020\u00102\u0006\u0010\n\u001a\u00020\u00112\u0006\u0010\f\u001a\u00020\rH\u0002J\u0018\u0010\b\u001a\u00020\u00122\u0006\u0010\n\u001a\u00020\u00132\u0006\u0010\f\u001a\u00020\rH\u0002J\u0018\u0010\b\u001a\u00020\u00142\u0006\u0010\n\u001a\u00020\u00152\u0006\u0010\f\u001a\u00020\rH\u0002J\u0018\u0010\b\u001a\u00020\u00162\u0006\u0010\n\u001a\u00020\u00172\u0006\u0010\f\u001a\u00020\rH\u0002J\u0018\u0010\b\u001a\u00020\u00182\u0006\u0010\n\u001a\u00020\u00192\u0006\u0010\f\u001a\u00020\rH\u0002J$\u0010\b\u001a\n\u0012\u0004\u0012\u00020\u001b\u0018\u00010\u001a2\f\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u001b0\u001a2\u0006\u0010\f\u001a\u00020\rJ\u001c\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u001e0\u001a2\u0006\u0010\n\u001a\u00020\u001e2\u0006\u0010\f\u001a\u00020\rJ&\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u001e0\u001a2\u000e\u0010 \u001a\n\u0012\u0004\u0012\u00020\u001e\u0018\u00010\u001a2\u0006\u0010\f\u001a\u00020\rH\u0002J$\u0010!\u001a\b\u0012\u0004\u0012\u00020\"0\u001a2\f\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\"0\u001a2\u0006\u0010\f\u001a\u00020\rH\u0002J\"\u0010#\u001a\u0004\u0018\u00010$2\u0006\u0010%\u001a\u00020$2\u0006\u0010&\u001a\u00020'2\u0006\u0010(\u001a\u00020\u0007H\u0002J\\\u0010)\u001a\u00020\u001e2\u0006\u0010*\u001a\u00020\u001e2\f\u0010+\u001a\b\u0012\u0004\u0012\u00020\u001e0\u001a2\f\u0010,\u001a\b\u0012\u0004\u0012\u00020\u001e0-2\u0006\u0010\f\u001a\u00020\r2\u0018\u0010.\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001e0\u001a\u0012\u0004\u0012\u00020\u001e0/2\f\u00100\u001a\b\u0012\u0004\u0012\u00020\u001e01H\u0002J&\u00102\u001a\u00020\u001e2\u0006\u0010*\u001a\u00020\u001e2\f\u0010,\u001a\b\u0012\u0004\u0012\u00020\u001e0-2\u0006\u0010\f\u001a\u00020\rH\u0002J(\u00103\u001a\u0004\u0018\u00010\u001e2\u0006\u00104\u001a\u00020$2\u0006\u00105\u001a\u00020\u001e2\u0006\u00106\u001a\u00020\u00072\u0006\u0010\f\u001a\u00020\rJ6\u00107\u001a\b\u0012\u0004\u0012\u00020\u001e0\u001a2\u0006\u0010*\u001a\u00020\u001e2\u0006\u00108\u001a\u00020\u00072\u0006\u0010\f\u001a\u00020\r2\u000e\b\u0002\u00109\u001a\b\u0012\u0004\u0012\u00020\u001e0:H\u0002J\u001a\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u001e0\u001a*\u00020\u001e2\u0006\u0010\f\u001a\u00020\rH\u0002J\u0012\u0010;\u001a\b\u0012\u0004\u0012\u00020\u001e0\u001a*\u00020\u001eH\u0002J8\u00107\u001a\b\u0012\u0004\u0012\u00020\u001e0\u001a*\b\u0012\u0004\u0012\u00020\u001e0\u001a2\u0006\u00108\u001a\u00020\u00072\u0006\u0010\f\u001a\u00020\r2\u000e\b\u0002\u00109\u001a\b\u0012\u0004\u0012\u00020\u001e0:H\u0002J\u0014\u0010<\u001a\u00020\"*\u00020\"2\u0006\u0010\f\u001a\u00020\rH\u0002R\u0014\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006>"}, d2 = {"Lcom/yandex/div/core/downloader/DivPatchApply;", "", DivActionHandler.DivActionReason.PATCH, "Lcom/yandex/div/core/downloader/DivPatchMap;", "(Lcom/yandex/div/core/downloader/DivPatchMap;)V", "appliedPatches", "", "", "applyPatch", "Lcom/yandex/div2/Div$Container;", "div", "Lcom/yandex/div2/DivContainer;", "resolver", "Lcom/yandex/div/json/expressions/ExpressionResolver;", "Lcom/yandex/div2/Div$Custom;", "Lcom/yandex/div2/DivCustom;", "Lcom/yandex/div2/Div$Gallery;", "Lcom/yandex/div2/DivGallery;", "Lcom/yandex/div2/Div$Grid;", "Lcom/yandex/div2/DivGrid;", "Lcom/yandex/div2/Div$Pager;", "Lcom/yandex/div2/DivPager;", "Lcom/yandex/div2/Div$State;", "Lcom/yandex/div2/DivState;", "Lcom/yandex/div2/Div$Tabs;", "Lcom/yandex/div2/DivTabs;", "", "Lcom/yandex/div2/DivData$State;", "states", "applyPatchForDiv", "Lcom/yandex/div2/Div;", "applyPatchForListOfDivs", "divs", "applyPatchForListStates", "Lcom/yandex/div2/DivState$State;", "findPatchedRecyclerViewAndNotifyChange", "Landroid/view/View;", "currentView", "divWithPatchedChild", "Lcom/yandex/div2/DivBase;", "patchedChildId", "getPatchedDivCollection", "currentDiv", FirebaseAnalytics.Param.ITEMS, "pathIterator", "", "createPatchedDiv", "Lkotlin/Function1;", "patchDiv", "Lkotlin/Function0;", "getPatchedTreeByPath", "patchDivChild", "parentView", "parentDiv", "idToPatch", "pathToChildWithId", "idToFind", "currentPath", "", "applyPatchForSingleDiv", "tryApplyPatchToDiv", "Companion", "div_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class DivPatchApply {
    private static final String PATH_FOLLOWING_ERROR = "Unable to find the next child to patch by following a precalculated path";
    public static final String TAG = "DivPatchApply";
    private final Set<String> appliedPatches;
    private final DivPatchMap patch;

    public DivPatchApply(DivPatchMap patch) {
        Intrinsics.checkNotNullParameter(patch, "patch");
        this.patch = patch;
        this.appliedPatches = new LinkedHashSet();
    }

    public final List<DivData.State> applyPatch(List<DivData.State> states, ExpressionResolver resolver) {
        Intrinsics.checkNotNullParameter(states, "states");
        Intrinsics.checkNotNullParameter(resolver, "resolver");
        ArrayList arrayList = new ArrayList(states.size());
        for (DivData.State state : states) {
            arrayList.add(new DivData.State(applyPatch(state.div, resolver).get(0), state.stateId));
        }
        if (this.patch.getMode().evaluate(resolver) != DivPatch.Mode.TRANSACTIONAL || this.appliedPatches.size() == this.patch.getPatches().size()) {
            return arrayList;
        }
        return null;
    }

    public final List<Div> applyPatchForDiv(Div div, ExpressionResolver resolver) {
        Intrinsics.checkNotNullParameter(div, "div");
        Intrinsics.checkNotNullParameter(resolver, "resolver");
        return applyPatch(div, resolver);
    }

    private final List<Div> applyPatch(Div div, ExpressionResolver expressionResolver) {
        String id = div.value().getId();
        if (id != null && this.patch.getPatches().containsKey(id)) {
            return applyPatchForSingleDiv(div);
        }
        if (div instanceof Div.Container) {
            div = applyPatch(((Div.Container) div).getValue(), expressionResolver);
        } else if (div instanceof Div.Grid) {
            div = applyPatch(((Div.Grid) div).getValue(), expressionResolver);
        } else if (div instanceof Div.Gallery) {
            div = applyPatch(((Div.Gallery) div).getValue(), expressionResolver);
        } else if (div instanceof Div.Pager) {
            div = applyPatch(((Div.Pager) div).getValue(), expressionResolver);
        } else if (div instanceof Div.State) {
            div = applyPatch(((Div.State) div).getValue(), expressionResolver);
        } else if (div instanceof Div.Tabs) {
            div = applyPatch(((Div.Tabs) div).getValue(), expressionResolver);
        } else if (div instanceof Div.Custom) {
            div = applyPatch(((Div.Custom) div).getValue(), expressionResolver);
        }
        return CollectionsKt.listOf(div);
    }

    private final List<Div> applyPatchForListOfDivs(List<? extends Div> divs, ExpressionResolver resolver) {
        ArrayList arrayList = new ArrayList();
        if (divs != null) {
            Iterator<T> it = divs.iterator();
            while (it.hasNext()) {
                arrayList.addAll(applyPatch((Div) it.next(), resolver));
            }
        }
        return arrayList;
    }

    private final List<Div> applyPatchForSingleDiv(Div div) {
        String id = div.value().getId();
        if (id == null) {
            return CollectionsKt.listOf(div);
        }
        List<Div> list = this.patch.getPatches().get(id);
        if (list != null) {
            this.appliedPatches.add(id);
            return list;
        }
        return CollectionsKt.listOf(div);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Div.Container applyPatch(DivContainer div, ExpressionResolver resolver) {
        return new Div.Container(DivContainer.copy$default(div, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, applyPatchForListOfDivs(div.items, resolver), null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, -33554433, 524287, null));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Div.Grid applyPatch(DivGrid div, ExpressionResolver resolver) {
        return new Div.Grid(DivGrid.copy$default(div, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, applyPatchForListOfDivs(div.items, resolver), null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, -8388609, 8191, null));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Div.Gallery applyPatch(DivGallery div, ExpressionResolver resolver) {
        return new Div.Gallery(DivGallery.copy$default(div, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, applyPatchForListOfDivs(div.items, resolver), null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, -1048577, 2047, null));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Div.Pager applyPatch(DivPager div, ExpressionResolver resolver) {
        return new Div.Pager(DivPager.copy$default(div, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, applyPatchForListOfDivs(div.items, resolver), null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, -524289, 2047, null));
    }

    private final Div.State applyPatch(DivState div, ExpressionResolver resolver) {
        return new Div.State(DivState.copy$default(div, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, applyPatchForListStates(div.states, resolver), null, null, null, null, null, null, null, null, null, null, null, null, null, -16777217, 63, null));
    }

    private final Div.Custom applyPatch(DivCustom div, ExpressionResolver resolver) {
        return new Div.Custom(div.copy(((-32769) & 1) != 0 ? div.getAccessibility() : null, ((-32769) & 2) != 0 ? div.getAlignmentHorizontal() : null, ((-32769) & 4) != 0 ? div.getAlignmentVertical() : null, ((-32769) & 8) != 0 ? div.getAlpha() : null, ((-32769) & 16) != 0 ? div.getAnimators() : null, ((-32769) & 32) != 0 ? div.getBackground() : null, ((-32769) & 64) != 0 ? div.getBorder() : null, ((-32769) & 128) != 0 ? div.getColumnSpan() : null, ((-32769) & 256) != 0 ? div.customProps : null, ((-32769) & 512) != 0 ? div.customType : null, ((-32769) & 1024) != 0 ? div.getDisappearActions() : null, ((-32769) & 2048) != 0 ? div.getExtensions() : null, ((-32769) & 4096) != 0 ? div.getFocus() : null, ((-32769) & 8192) != 0 ? div.getFunctions() : null, ((-32769) & 16384) != 0 ? div.getHeight() : null, ((-32769) & 32768) != 0 ? div.getId() : null, ((-32769) & 65536) != 0 ? div.items : applyPatchForListOfDivs(div.items, resolver), ((-32769) & 131072) != 0 ? div.getLayoutProvider() : null, ((-32769) & 262144) != 0 ? div.getMargins() : null, ((-32769) & 524288) != 0 ? div.getPaddings() : null, ((-32769) & 1048576) != 0 ? div.getReuseId() : null, ((-32769) & 2097152) != 0 ? div.getRowSpan() : null, ((-32769) & 4194304) != 0 ? div.getSelectedActions() : null, ((-32769) & 8388608) != 0 ? div.getTooltips() : null, ((-32769) & 16777216) != 0 ? div.getTransform() : null, ((-32769) & 33554432) != 0 ? div.getTransitionChange() : null, ((-32769) & 67108864) != 0 ? div.getTransitionIn() : null, ((-32769) & 134217728) != 0 ? div.getTransitionOut() : null, ((-32769) & 268435456) != 0 ? div.getTransitionTriggers() : null, ((-32769) & 536870912) != 0 ? div.getVariableTriggers() : null, ((-32769) & 1073741824) != 0 ? div.getVariables() : null, ((-32769) & Integer.MIN_VALUE) != 0 ? div.getVisibility() : null, (7 & 1) != 0 ? div.getVisibilityAction() : null, (7 & 2) != 0 ? div.getVisibilityActions() : null, (7 & 4) != 0 ? div.getWidth() : null));
    }

    private final List<DivState.State> applyPatchForListStates(List<DivState.State> states, ExpressionResolver resolver) {
        DivBase divBaseValue;
        ArrayList arrayList = new ArrayList();
        for (DivState.State state : states) {
            Div div = state.div;
            String id = (div == null || (divBaseValue = div.value()) == null) ? null : divBaseValue.getId();
            if (id != null) {
                List<Div> list = this.patch.getPatches().get(id);
                if (list != null && list.size() == 1) {
                    arrayList.add(new DivState.State(state.animationIn, state.animationOut, list.get(0), state.stateId, state.swipeOutActions));
                    this.appliedPatches.add(id);
                } else if (list != null && list.isEmpty()) {
                    this.appliedPatches.add(id);
                } else {
                    arrayList.add(tryApplyPatchToDiv(state, resolver));
                }
            } else {
                arrayList.add(tryApplyPatchToDiv(state, resolver));
            }
        }
        return arrayList;
    }

    private final DivState.State tryApplyPatchToDiv(DivState.State state, ExpressionResolver expressionResolver) {
        Div div = state.div;
        List<Div> listApplyPatch = div != null ? applyPatch(div, expressionResolver) : null;
        return (listApplyPatch == null || listApplyPatch.size() != 1) ? state : new DivState.State(state.animationIn, state.animationOut, listApplyPatch.get(0), state.stateId, state.swipeOutActions);
    }

    private final Div.Tabs applyPatch(DivTabs div, ExpressionResolver resolver) {
        ArrayList arrayList = new ArrayList();
        for (DivTabs.Item item : div.items) {
            List<Div> listApplyPatch = applyPatch(item.div, resolver);
            if (listApplyPatch.size() == 1) {
                arrayList.add(new DivTabs.Item(listApplyPatch.get(0), item.title, item.titleClickAction));
            } else {
                KLog kLog = KLog.INSTANCE;
                if (kLog.isAtLeast(Severity.ERROR)) {
                    kLog.print(6, TAG, "Unable to patch tab because there is more than 1 div in the patch");
                }
                arrayList.add(item);
            }
        }
        return new Div.Tabs(DivTabs.copy$default(div, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, arrayList, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, -65537, 2047, null));
    }

    public final Div patchDivChild(View parentView, Div parentDiv, String idToPatch, ExpressionResolver resolver) {
        DivBase divBaseValue;
        Intrinsics.checkNotNullParameter(parentView, "parentView");
        Intrinsics.checkNotNullParameter(parentDiv, "parentDiv");
        Intrinsics.checkNotNullParameter(idToPatch, "idToPatch");
        Intrinsics.checkNotNullParameter(resolver, "resolver");
        List listPathToChildWithId$default = pathToChildWithId$default(this, parentDiv, idToPatch, resolver, (List) null, 8, (Object) null);
        Iterator<? extends Div> it = listPathToChildWithId$default.iterator();
        Object obj = null;
        if (listPathToChildWithId$default.isEmpty()) {
            return null;
        }
        it.next();
        ListIterator listIterator = listPathToChildWithId$default.listIterator(listPathToChildWithId$default.size());
        while (listIterator.hasPrevious()) {
            Object objPrevious = listIterator.previous();
            Div div = (Div) objPrevious;
            if ((div.value() instanceof DivGallery) || (div.value() instanceof DivPager)) {
                obj = objPrevious;
                break;
            }
        }
        Div div2 = (Div) obj;
        if (div2 != null && (divBaseValue = div2.value()) != null) {
            findPatchedRecyclerViewAndNotifyChange(parentView, divBaseValue, idToPatch);
        }
        return getPatchedTreeByPath(parentDiv, it, resolver);
    }

    /* JADX WARN: Multi-variable type inference failed */
    static /* synthetic */ List pathToChildWithId$default(DivPatchApply divPatchApply, Div div, String str, ExpressionResolver expressionResolver, List list, int i, Object obj) {
        if ((i & 8) != 0) {
            list = new ArrayList();
        }
        return divPatchApply.pathToChildWithId(div, str, expressionResolver, (List<Div>) list);
    }

    private final List<Div> pathToChildWithId(Div currentDiv, String idToFind, ExpressionResolver resolver, List<Div> currentPath) {
        DivBase divBaseValue;
        currentPath.add(currentDiv);
        DivBase divBaseValue2 = currentDiv.value();
        if (divBaseValue2 instanceof DivContainer) {
            return pathToChildWithId(DivCollectionExtensionsKt.getNonNullItems((DivContainer) divBaseValue2), idToFind, resolver, currentPath);
        }
        if (divBaseValue2 instanceof DivGrid) {
            return pathToChildWithId(DivCollectionExtensionsKt.getNonNullItems((DivGrid) divBaseValue2), idToFind, resolver, currentPath);
        }
        if (divBaseValue2 instanceof DivGallery) {
            return pathToChildWithId(DivCollectionExtensionsKt.getNonNullItems((DivGallery) divBaseValue2), idToFind, resolver, currentPath);
        }
        if (divBaseValue2 instanceof DivPager) {
            return pathToChildWithId(DivCollectionExtensionsKt.getNonNullItems((DivPager) divBaseValue2), idToFind, resolver, currentPath);
        }
        if (divBaseValue2 instanceof DivTabs) {
            DivTabs divTabs = (DivTabs) divBaseValue2;
            List<DivTabs.Item> list = divTabs.items;
            if (!(list instanceof Collection) || !list.isEmpty()) {
                Iterator<T> it = list.iterator();
                while (it.hasNext()) {
                    if (Intrinsics.areEqual(((DivTabs.Item) it.next()).div.value().getId(), idToFind)) {
                        return currentPath;
                    }
                }
            }
            Iterator<T> it2 = divTabs.items.iterator();
            while (it2.hasNext()) {
                List<Div> listPathToChildWithId = pathToChildWithId(((DivTabs.Item) it2.next()).div, idToFind, resolver, currentPath);
                if (!listPathToChildWithId.isEmpty()) {
                    return listPathToChildWithId;
                }
                CollectionsKt.removeLast(currentPath);
            }
            return CollectionsKt.emptyList();
        }
        if (divBaseValue2 instanceof DivState) {
            DivState divState = (DivState) divBaseValue2;
            List<DivState.State> list2 = divState.states;
            if (!(list2 instanceof Collection) || !list2.isEmpty()) {
                Iterator<T> it3 = list2.iterator();
                while (it3.hasNext()) {
                    Div div = ((DivState.State) it3.next()).div;
                    if (Intrinsics.areEqual((div == null || (divBaseValue = div.value()) == null) ? null : divBaseValue.getId(), idToFind)) {
                        return currentPath;
                    }
                }
            }
            List<DivState.State> list3 = divState.states;
            ArrayList arrayList = new ArrayList();
            Iterator<T> it4 = list3.iterator();
            while (it4.hasNext()) {
                Div div2 = ((DivState.State) it4.next()).div;
                if (div2 != null) {
                    arrayList.add(div2);
                }
            }
            Iterator it5 = arrayList.iterator();
            while (it5.hasNext()) {
                List<Div> listPathToChildWithId2 = pathToChildWithId((Div) it5.next(), idToFind, resolver, currentPath);
                if (!listPathToChildWithId2.isEmpty()) {
                    return listPathToChildWithId2;
                }
                CollectionsKt.removeLast(currentPath);
            }
            return CollectionsKt.emptyList();
        }
        return CollectionsKt.emptyList();
    }

    /* JADX WARN: Multi-variable type inference failed */
    static /* synthetic */ List pathToChildWithId$default(DivPatchApply divPatchApply, List list, String str, ExpressionResolver expressionResolver, List list2, int i, Object obj) {
        if ((i & 4) != 0) {
            list2 = new ArrayList();
        }
        return divPatchApply.pathToChildWithId((List<? extends Div>) list, str, expressionResolver, (List<Div>) list2);
    }

    private final List<Div> pathToChildWithId(List<? extends Div> list, String str, ExpressionResolver expressionResolver, List<Div> list2) {
        List<? extends Div> list3 = list;
        if (!(list3 instanceof Collection) || !list3.isEmpty()) {
            Iterator<T> it = list3.iterator();
            while (it.hasNext()) {
                if (Intrinsics.areEqual(((Div) it.next()).value().getId(), str)) {
                    return list2;
                }
            }
        }
        Iterator<T> it2 = list3.iterator();
        while (it2.hasNext()) {
            List<Div> listPathToChildWithId = pathToChildWithId((Div) it2.next(), str, expressionResolver, list2);
            if (!listPathToChildWithId.isEmpty()) {
                return listPathToChildWithId;
            }
            CollectionsKt.removeLast(list2);
        }
        return CollectionsKt.emptyList();
    }

    private final Div getPatchedTreeByPath(Div currentDiv, Iterator<? extends Div> pathIterator, final ExpressionResolver resolver) {
        Div.State stateApplyPatch;
        Div.Tabs tabsApplyPatch;
        final DivBase divBaseValue = currentDiv.value();
        if (divBaseValue instanceof DivContainer) {
            return getPatchedDivCollection(currentDiv, DivCollectionExtensionsKt.getNonNullItems((DivContainer) divBaseValue), pathIterator, resolver, new Function1<List<? extends Div>, Div>() { // from class: com.yandex.div.core.downloader.DivPatchApply.getPatchedTreeByPath.1
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public final Div invoke(List<? extends Div> it) {
                    Intrinsics.checkNotNullParameter(it, "it");
                    return new Div.Container(DivContainer.copy$default((DivContainer) divBaseValue, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, it, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, -33554433, 524287, null));
                }
            }, new Function0<Div>() { // from class: com.yandex.div.core.downloader.DivPatchApply.getPatchedTreeByPath.2
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                }

                /* JADX WARN: Can't rename method to resolve collision */
                @Override // kotlin.jvm.functions.Function0
                public final Div invoke() {
                    return new DivPatchApply(DivPatchApply.this.patch).applyPatch((DivContainer) divBaseValue, resolver);
                }
            });
        }
        if (divBaseValue instanceof DivGrid) {
            return getPatchedDivCollection(currentDiv, DivCollectionExtensionsKt.getNonNullItems((DivGrid) divBaseValue), pathIterator, resolver, new Function1<List<? extends Div>, Div>() { // from class: com.yandex.div.core.downloader.DivPatchApply.getPatchedTreeByPath.3
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public final Div invoke(List<? extends Div> it) {
                    Intrinsics.checkNotNullParameter(it, "it");
                    return new Div.Grid(DivGrid.copy$default((DivGrid) divBaseValue, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, it, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, -8388609, 8191, null));
                }
            }, new Function0<Div>() { // from class: com.yandex.div.core.downloader.DivPatchApply.getPatchedTreeByPath.4
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                }

                /* JADX WARN: Can't rename method to resolve collision */
                @Override // kotlin.jvm.functions.Function0
                public final Div invoke() {
                    return new DivPatchApply(DivPatchApply.this.patch).applyPatch((DivGrid) divBaseValue, resolver);
                }
            });
        }
        if (divBaseValue instanceof DivGallery) {
            return getPatchedDivCollection(currentDiv, DivCollectionExtensionsKt.getNonNullItems((DivGallery) divBaseValue), pathIterator, resolver, new Function1<List<? extends Div>, Div>() { // from class: com.yandex.div.core.downloader.DivPatchApply.getPatchedTreeByPath.5
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public final Div invoke(List<? extends Div> it) {
                    Intrinsics.checkNotNullParameter(it, "it");
                    return new Div.Gallery(DivGallery.copy$default((DivGallery) divBaseValue, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, it, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, -1048577, 2047, null));
                }
            }, new Function0<Div>() { // from class: com.yandex.div.core.downloader.DivPatchApply.getPatchedTreeByPath.6
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                }

                /* JADX WARN: Can't rename method to resolve collision */
                @Override // kotlin.jvm.functions.Function0
                public final Div invoke() {
                    return new DivPatchApply(DivPatchApply.this.patch).applyPatch((DivGallery) divBaseValue, resolver);
                }
            });
        }
        if (divBaseValue instanceof DivPager) {
            return getPatchedDivCollection(currentDiv, DivCollectionExtensionsKt.getNonNullItems((DivPager) divBaseValue), pathIterator, resolver, new Function1<List<? extends Div>, Div>() { // from class: com.yandex.div.core.downloader.DivPatchApply.getPatchedTreeByPath.7
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public final Div invoke(List<? extends Div> it) {
                    Intrinsics.checkNotNullParameter(it, "it");
                    return new Div.Pager(DivPager.copy$default((DivPager) divBaseValue, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, it, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, -524289, 2047, null));
                }
            }, new Function0<Div>() { // from class: com.yandex.div.core.downloader.DivPatchApply.getPatchedTreeByPath.8
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                }

                /* JADX WARN: Can't rename method to resolve collision */
                @Override // kotlin.jvm.functions.Function0
                public final Div invoke() {
                    return new DivPatchApply(DivPatchApply.this.patch).applyPatch((DivPager) divBaseValue, resolver);
                }
            });
        }
        if (divBaseValue instanceof DivTabs) {
            if (pathIterator.hasNext()) {
                DivTabs divTabs = (DivTabs) divBaseValue;
                List mutableList = CollectionsKt.toMutableList((Collection) divTabs.items);
                List list = mutableList;
                ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
                Iterator it = list.iterator();
                while (it.hasNext()) {
                    arrayList.add(((DivTabs.Item) it.next()).div);
                }
                int iIndexOf = arrayList.indexOf(pathIterator.next());
                if (iIndexOf == -1) {
                    KAssert kAssert = KAssert.INSTANCE;
                    if (Assert.isEnabled()) {
                        Assert.fail(PATH_FOLLOWING_ERROR);
                    }
                    return currentDiv;
                }
                DivTabs.Item item = (DivTabs.Item) mutableList.get(iIndexOf);
                mutableList.set(iIndexOf, new DivTabs.Item(getPatchedTreeByPath(item.div, pathIterator, resolver), item.title, item.titleClickAction));
                tabsApplyPatch = new Div.Tabs(DivTabs.copy$default(divTabs, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, mutableList, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, -65537, 2047, null));
            } else {
                tabsApplyPatch = new DivPatchApply(this.patch).applyPatch((DivTabs) divBaseValue, resolver);
            }
            return tabsApplyPatch;
        }
        if (!(divBaseValue instanceof DivState)) {
            return currentDiv;
        }
        if (pathIterator.hasNext()) {
            DivState divState = (DivState) divBaseValue;
            List mutableList2 = CollectionsKt.toMutableList((Collection) divState.states);
            List list2 = mutableList2;
            ArrayList arrayList2 = new ArrayList(CollectionsKt.collectionSizeOrDefault(list2, 10));
            Iterator it2 = list2.iterator();
            while (it2.hasNext()) {
                arrayList2.add(((DivState.State) it2.next()).div);
            }
            int iIndexOf2 = arrayList2.indexOf(pathIterator.next());
            if (iIndexOf2 == -1) {
                KAssert kAssert2 = KAssert.INSTANCE;
                if (Assert.isEnabled()) {
                    Assert.fail(PATH_FOLLOWING_ERROR);
                }
                return currentDiv;
            }
            DivState.State state = (DivState.State) mutableList2.get(iIndexOf2);
            Div div = state.div;
            if (div == null) {
                return currentDiv;
            }
            mutableList2.set(iIndexOf2, new DivState.State(state.animationIn, state.animationOut, getPatchedTreeByPath(div, pathIterator, resolver), state.stateId, state.swipeOutActions));
            stateApplyPatch = new Div.State(DivState.copy$default(divState, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, mutableList2, null, null, null, null, null, null, null, null, null, null, null, null, null, -16777217, 63, null));
        } else {
            stateApplyPatch = new DivPatchApply(this.patch).applyPatch((DivState) divBaseValue, resolver);
        }
        return stateApplyPatch;
    }

    private final Div getPatchedDivCollection(Div currentDiv, List<? extends Div> items, Iterator<? extends Div> pathIterator, ExpressionResolver resolver, Function1<? super List<? extends Div>, ? extends Div> createPatchedDiv, Function0<? extends Div> patchDiv) {
        if (!pathIterator.hasNext()) {
            return patchDiv.invoke();
        }
        int iIndexOf = items.indexOf(pathIterator.next());
        if (iIndexOf == -1) {
            KAssert kAssert = KAssert.INSTANCE;
            if (Assert.isEnabled()) {
                Assert.fail(PATH_FOLLOWING_ERROR);
            }
            return currentDiv;
        }
        List mutableList = CollectionsKt.toMutableList((Collection) items);
        mutableList.set(iIndexOf, getPatchedTreeByPath((Div) mutableList.get(iIndexOf), pathIterator, resolver));
        return createPatchedDiv.invoke(mutableList);
    }

    private final View findPatchedRecyclerViewAndNotifyChange(View currentView, DivBase divWithPatchedChild, String patchedChildId) {
        RecyclerView.Adapter adapter;
        DivPager div;
        List<Div> list;
        DivGallery div2;
        List<Div> list2;
        int i = 0;
        if (currentView instanceof DivRecyclerView) {
            DivRecyclerView divRecyclerView = (DivRecyclerView) currentView;
            if (divRecyclerView.getDiv() == divWithPatchedChild) {
                RecyclerView.Adapter adapter2 = divRecyclerView.getAdapter();
                DivGalleryAdapter divGalleryAdapter = adapter2 instanceof DivGalleryAdapter ? (DivGalleryAdapter) adapter2 : null;
                if (divGalleryAdapter != null && (div2 = divRecyclerView.getDiv()) != null && (list2 = div2.items) != null) {
                    for (Object obj : list2) {
                        int i2 = i + 1;
                        if (i < 0) {
                            CollectionsKt.throwIndexOverflow();
                        }
                        if (Intrinsics.areEqual(((Div) obj).value().getId(), patchedChildId)) {
                            divGalleryAdapter.notifyItemChanged(i);
                            return currentView;
                        }
                        i = i2;
                    }
                }
                return currentView;
            }
        } else if (currentView instanceof DivPagerView) {
            DivPagerView divPagerView = (DivPagerView) currentView;
            if (divPagerView.getDiv() == divWithPatchedChild) {
                View childAt = divPagerView.getViewPager().getChildAt(0);
                RecyclerView recyclerView = childAt instanceof RecyclerView ? (RecyclerView) childAt : null;
                if (recyclerView != null && (adapter = recyclerView.getAdapter()) != null && (div = divPagerView.getDiv()) != null && (list = div.items) != null) {
                    for (Object obj2 : list) {
                        int i3 = i + 1;
                        if (i < 0) {
                            CollectionsKt.throwIndexOverflow();
                        }
                        if (Intrinsics.areEqual(((Div) obj2).value().getId(), patchedChildId)) {
                            adapter.notifyItemChanged(i);
                            return currentView;
                        }
                        i = i3;
                    }
                }
                return currentView;
            }
        }
        if (currentView instanceof ViewGroup) {
            Iterator<View> it = ViewGroupKt.getChildren((ViewGroup) currentView).iterator();
            while (it.hasNext()) {
                View viewFindPatchedRecyclerViewAndNotifyChange = findPatchedRecyclerViewAndNotifyChange(it.next(), divWithPatchedChild, patchedChildId);
                if (viewFindPatchedRecyclerViewAndNotifyChange != null) {
                    return viewFindPatchedRecyclerViewAndNotifyChange;
                }
            }
        }
        return null;
    }
}
