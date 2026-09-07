package com.yandex.div.core.expression.local;

import com.google.firebase.analytics.FirebaseAnalytics;
import com.google.firebase.sessions.settings.RemoteSettings;
import com.yandex.div.core.dagger.DivScope;
import com.yandex.div.core.expression.ExpressionsRuntime;
import com.yandex.div.core.state.DivStatePath;
import com.yandex.div.core.state.TabsStateCache;
import com.yandex.div.core.state.TemporaryDivStateCache;
import com.yandex.div.core.util.DivUtilKt;
import com.yandex.div.core.view2.Div2View;
import com.yandex.div.core.view2.divs.BaseDivViewExtensionsKt;
import com.yandex.div.data.Variable;
import com.yandex.div.internal.Assert;
import com.yandex.div.internal.KAssert;
import com.yandex.div.json.expressions.Expression;
import com.yandex.div.json.expressions.ExpressionResolver;
import com.yandex.div.state.DivStateCache;
import com.yandex.div2.Div;
import com.yandex.div2.DivState;
import com.yandex.div2.DivTabs;
import com.yandex.div2.DivVariable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: DivRuntimeVisitor.kt */
/* JADX INFO: loaded from: classes8.dex */
@Metadata(d1 = {"\u0000n\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010!\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0011\u0018\u00002\u00020\u0001B\u001f\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ \u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010H\u0016J(\u0010\u0011\u001a\u00020\n2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u000e2\u0006\u0010\u0015\u001a\u00020\u0016H\u0016J(\u0010\u0017\u001a\u00020\n2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0012\u001a\u00020\u00182\u0006\u0010\u0014\u001a\u00020\u000e2\u0006\u0010\u0015\u001a\u00020\u0016H\u0016J2\u0010\u0019\u001a\u0004\u0018\u00010\u001a2\u0006\u0010\u0012\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\u00102\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u001c0\u001b2\b\u0010\u001d\u001a\u0004\u0018\u00010\u001aH\u0012J0\u0010\u001e\u001a\u0004\u0018\u00010\u001c2\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u000f\u001a\u00020\u00102\f\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u001c0\u001b2\u0006\u0010\u001d\u001a\u00020\u001aH\u0012J<\u0010 \u001a\u00020\n2\u0006\u0010\u0012\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\u00102\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u001c0\u001b2\f\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u001c0\u001b2\u0006\u0010\u001d\u001a\u00020\u001aH\u0012JL\u0010!\u001a\u00020\n2\u0006\u0010\u0012\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\u00102\u000e\u0010\"\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010#2\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u001c0\u001b2\f\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u001c0\u001b2\u0006\u0010\u001d\u001a\u00020\u001aH\u0012J<\u0010$\u001a\u00020\n2\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u000f\u001a\u00020\u00102\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u001c0\u001b2\f\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u001c0\u001b2\u0006\u0010\u001d\u001a\u00020\u001aH\u0012J>\u0010%\u001a\u0004\u0018\u00010\u001a2\u0006\u0010\u0012\u001a\u00020\u00182\u0006\u0010\u000f\u001a\u00020\u00102\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u001c0\u001b2\f\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u001c0\u001b2\u0006\u0010\u001d\u001a\u00020\u001aH\u0012J\u001c\u0010&\u001a\u0012\u0012\u0004\u0012\u00020\u001c0'j\b\u0012\u0004\u0012\u00020\u001c`(*\u00020\u000eH\u0012R\u000e\u0010\u0002\u001a\u00020\u0003X\u0092\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0092\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0092\u0004¢\u0006\u0002\n\u0000¨\u0006)"}, d2 = {"Lcom/yandex/div/core/expression/local/DivRuntimeVisitor;", "", "divStateCache", "Lcom/yandex/div/state/DivStateCache;", "temporaryStateCache", "Lcom/yandex/div/core/state/TemporaryDivStateCache;", "tabsCache", "Lcom/yandex/div/core/state/TabsStateCache;", "(Lcom/yandex/div/state/DivStateCache;Lcom/yandex/div/core/state/TemporaryDivStateCache;Lcom/yandex/div/core/state/TabsStateCache;)V", "createAndAttachRuntimes", "", "rootDiv", "Lcom/yandex/div2/Div;", "rootPath", "Lcom/yandex/div/core/state/DivStatePath;", "divView", "Lcom/yandex/div/core/view2/Div2View;", "createAndAttachRuntimesToState", "div", "Lcom/yandex/div2/DivState;", "path", "expressionResolver", "Lcom/yandex/div/json/expressions/ExpressionResolver;", "createAndAttachRuntimesToTabs", "Lcom/yandex/div2/DivTabs;", "defaultVisit", "Lcom/yandex/div/core/expression/ExpressionsRuntime;", "", "", "parentRuntime", "getActiveStateId", "states", "visit", "visitContainer", FirebaseAnalytics.Param.ITEMS, "", "visitStates", "visitTabs", "getStatesFlat", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "div_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
@DivScope
public class DivRuntimeVisitor {
    private final DivStateCache divStateCache;
    private final TabsStateCache tabsCache;
    private final TemporaryDivStateCache temporaryStateCache;

    @Inject
    public DivRuntimeVisitor(DivStateCache divStateCache, TemporaryDivStateCache temporaryStateCache, TabsStateCache tabsCache) {
        Intrinsics.checkNotNullParameter(divStateCache, "divStateCache");
        Intrinsics.checkNotNullParameter(temporaryStateCache, "temporaryStateCache");
        Intrinsics.checkNotNullParameter(tabsCache, "tabsCache");
        this.divStateCache = divStateCache;
        this.temporaryStateCache = temporaryStateCache;
        this.tabsCache = tabsCache;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private ArrayList<String> getStatesFlat(DivStatePath divStatePath) {
        ArrayList<String> arrayList = new ArrayList<>(divStatePath.getStates().size() * 4);
        arrayList.add(String.valueOf(divStatePath.getTopLevelStateId()));
        Iterator<T> it = divStatePath.getStates().iterator();
        while (it.hasNext()) {
            Pair pair = (Pair) it.next();
            arrayList.add(pair.getFirst());
            arrayList.add(pair.getSecond());
        }
        return arrayList;
    }

    public void createAndAttachRuntimes(Div rootDiv, DivStatePath rootPath, Div2View divView) {
        ExpressionsRuntime rootRuntime;
        Intrinsics.checkNotNullParameter(rootDiv, "rootDiv");
        Intrinsics.checkNotNullParameter(rootPath, "rootPath");
        Intrinsics.checkNotNullParameter(divView, "divView");
        RuntimeStore runtimeStore = divView.getRuntimeStore();
        if (runtimeStore == null || (rootRuntime = runtimeStore.getRootRuntime()) == null) {
            return;
        }
        rootRuntime.onAttachedToWindow(divView);
        visit(rootDiv, divView, CollectionsKt.toMutableList((Collection) rootPath.getPath$div_release()), getStatesFlat(rootPath), rootRuntime);
    }

    public void createAndAttachRuntimesToState(Div2View divView, DivState div, DivStatePath path, ExpressionResolver expressionResolver) {
        ExpressionsRuntime runtimeWithOrNull$div_release;
        Intrinsics.checkNotNullParameter(divView, "divView");
        Intrinsics.checkNotNullParameter(div, "div");
        Intrinsics.checkNotNullParameter(path, "path");
        Intrinsics.checkNotNullParameter(expressionResolver, "expressionResolver");
        RuntimeStore runtimeStore = divView.getRuntimeStore();
        if (runtimeStore == null || (runtimeWithOrNull$div_release = runtimeStore.getRuntimeWithOrNull$div_release(expressionResolver)) == null) {
            return;
        }
        runtimeWithOrNull$div_release.onAttachedToWindow(divView);
        visitStates(div, divView, CollectionsKt.toMutableList((Collection) path.getPath$div_release()), getStatesFlat(path), runtimeWithOrNull$div_release);
    }

    public void createAndAttachRuntimesToTabs(Div2View divView, DivTabs div, DivStatePath path, ExpressionResolver expressionResolver) {
        ExpressionsRuntime runtimeWithOrNull$div_release;
        Intrinsics.checkNotNullParameter(divView, "divView");
        Intrinsics.checkNotNullParameter(div, "div");
        Intrinsics.checkNotNullParameter(path, "path");
        Intrinsics.checkNotNullParameter(expressionResolver, "expressionResolver");
        RuntimeStore runtimeStore = divView.getRuntimeStore();
        if (runtimeStore == null || (runtimeWithOrNull$div_release = runtimeStore.getRuntimeWithOrNull$div_release(expressionResolver)) == null) {
            return;
        }
        runtimeWithOrNull$div_release.onAttachedToWindow(divView);
        visitTabs(div, divView, CollectionsKt.toMutableList((Collection) path.getPath$div_release()), getStatesFlat(path), runtimeWithOrNull$div_release);
    }

    private void visit(Div div, Div2View divView, List<String> path, List<String> states, ExpressionsRuntime parentRuntime) {
        if (div instanceof Div.Container) {
            visitContainer(div, divView, ((Div.Container) div).getValue().items, path, states, parentRuntime);
            return;
        }
        if (div instanceof Div.Grid) {
            visitContainer(div, divView, ((Div.Grid) div).getValue().items, path, states, parentRuntime);
            return;
        }
        if (div instanceof Div.Gallery) {
            visitContainer(div, divView, ((Div.Gallery) div).getValue().items, path, states, parentRuntime);
            return;
        }
        if (div instanceof Div.Pager) {
            visitContainer(div, divView, ((Div.Pager) div).getValue().items, path, states, parentRuntime);
            return;
        }
        if (div instanceof Div.State) {
            visitStates(((Div.State) div).getValue(), divView, path, states, parentRuntime);
            return;
        }
        if (div instanceof Div.Tabs) {
            visitTabs(((Div.Tabs) div).getValue(), divView, path, states, parentRuntime);
            return;
        }
        if (div instanceof Div.Custom) {
            defaultVisit(div, divView, path, parentRuntime);
            return;
        }
        if (div instanceof Div.GifImage) {
            defaultVisit(div, divView, path, parentRuntime);
            return;
        }
        if (div instanceof Div.Image) {
            defaultVisit(div, divView, path, parentRuntime);
            return;
        }
        if (div instanceof Div.Indicator) {
            defaultVisit(div, divView, path, parentRuntime);
            return;
        }
        if (div instanceof Div.Input) {
            defaultVisit(div, divView, path, parentRuntime);
            return;
        }
        if (div instanceof Div.Select) {
            defaultVisit(div, divView, path, parentRuntime);
            return;
        }
        if (div instanceof Div.Separator) {
            defaultVisit(div, divView, path, parentRuntime);
            return;
        }
        if (div instanceof Div.Slider) {
            defaultVisit(div, divView, path, parentRuntime);
        } else if (div instanceof Div.Text) {
            defaultVisit(div, divView, path, parentRuntime);
        } else if (div instanceof Div.Video) {
            defaultVisit(div, divView, path, parentRuntime);
        }
    }

    private ExpressionsRuntime defaultVisit(Div div, Div2View divView, List<String> path, ExpressionsRuntime parentRuntime) {
        if (!UtilsKt.getNeedLocalRuntime(div)) {
            return parentRuntime;
        }
        String strJoinToString$default = CollectionsKt.joinToString$default(path, RemoteSettings.FORWARD_SLASH_STRING, null, null, 0, null, null, 62, null);
        RuntimeStore runtimeStore = divView.getRuntimeStore();
        if (runtimeStore != null) {
            List<DivVariable> variables = div.value().getVariables();
            ExpressionsRuntime orCreateRuntime$div_release = runtimeStore.getOrCreateRuntime$div_release(strJoinToString$default, (32 & 2) != 0 ? null : variables != null ? DivUtilKt.toVariables(variables) : null, (32 & 4) != 0 ? null : div.value().getVariableTriggers(), (32 & 8) != 0 ? null : div.value().getFunctions(), (32 & 16) != 0 ? null : null, (32 & 32) == 0 ? parentRuntime : null);
            if (orCreateRuntime$div_release != null) {
                orCreateRuntime$div_release.onAttachedToWindow(divView);
                return orCreateRuntime$div_release;
            }
        }
        Assert.fail("ExpressionRuntimeVisitor cannot create runtime for path = " + strJoinToString$default);
        return null;
    }

    private void visitContainer(Div div, Div2View divView, List<? extends Div> items, List<String> path, List<String> states, ExpressionsRuntime parentRuntime) {
        ExpressionsRuntime expressionsRuntimeDefaultVisit = defaultVisit(div, divView, path, parentRuntime);
        if (expressionsRuntimeDefaultVisit == null || items == null) {
            return;
        }
        int i = 0;
        for (Object obj : items) {
            int i2 = i + 1;
            if (i < 0) {
                CollectionsKt.throwIndexOverflow();
            }
            Div div2 = (Div) obj;
            if (!(div2 instanceof Div.State)) {
                path.add(BaseDivViewExtensionsKt.getChildPathUnit(div2.value(), i));
                visit(div2, divView, path, states, expressionsRuntimeDefaultVisit);
                CollectionsKt.removeLastOrNull(path);
            } else {
                visit(div2, divView, path, states, expressionsRuntimeDefaultVisit);
            }
            i = i2;
        }
    }

    private String getActiveStateId(DivState div, Div2View divView, List<String> states, ExpressionsRuntime parentRuntime) {
        String strEvaluate;
        String strJoinToString$default = CollectionsKt.joinToString$default(states, RemoteSettings.FORWARD_SLASH_STRING, null, null, 0, null, null, 62, null);
        String id = divView.getDivTag().getId();
        Intrinsics.checkNotNullExpressionValue(id, "divView.divTag.id");
        String state = this.temporaryStateCache.getState(id, strJoinToString$default);
        if (state != null) {
            return state;
        }
        String state2 = this.divStateCache.getState(id, strJoinToString$default);
        if (state2 != null) {
            return state2;
        }
        String str = div.stateIdVariable;
        if (str != null) {
            Variable mutableVariable = parentRuntime.getVariableController().getMutableVariable(str);
            strEvaluate = String.valueOf(mutableVariable != null ? mutableVariable.getValue() : null);
        } else {
            strEvaluate = null;
        }
        if (strEvaluate == null) {
            Expression<String> expression = div.defaultStateId;
            strEvaluate = expression != null ? expression.evaluate(parentRuntime.getExpressionResolver()) : null;
            if (strEvaluate == null) {
                DivState.State state3 = (DivState.State) CollectionsKt.firstOrNull((List) div.states);
                if (state3 != null) {
                    return state3.stateId;
                }
                return null;
            }
        }
        return strEvaluate;
    }

    private void visitStates(DivState div, Div2View divView, List<String> path, List<String> states, ExpressionsRuntime parentRuntime) {
        RuntimeTree tree;
        String id = div.getId();
        if (id == null && (id = div.divId) == null) {
            return;
        }
        path.add(id);
        states.add(id);
        String activeStateId = getActiveStateId(div, divView, states, parentRuntime);
        for (DivState.State state : div.states) {
            Div div2 = state.div;
            if (div2 != null) {
                path.add(state.stateId);
                if (Intrinsics.areEqual(state.stateId, activeStateId)) {
                    visit(div2, divView, path, states, parentRuntime);
                } else {
                    RuntimeStore runtimeStore = divView.getRuntimeStore();
                    if (runtimeStore != null && (tree = runtimeStore.getTree()) != null) {
                        tree.invokeRecursively(parentRuntime, CollectionsKt.joinToString$default(path, RemoteSettings.FORWARD_SLASH_STRING, null, null, 0, null, null, 62, null), new Function1<RuntimeTree.RuntimeNode, Unit>() { // from class: com.yandex.div.core.expression.local.DivRuntimeVisitor$visitStates$1$1$1
                            @Override // kotlin.jvm.functions.Function1
                            public /* bridge */ /* synthetic */ Unit invoke(RuntimeTree.RuntimeNode runtimeNode) {
                                invoke2(runtimeNode);
                                return Unit.INSTANCE;
                            }

                            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                            public final void invoke2(RuntimeTree.RuntimeNode node) {
                                Intrinsics.checkNotNullParameter(node, "node");
                                node.getRuntime().clearBinding();
                            }
                        });
                    }
                }
                CollectionsKt.removeLastOrNull(path);
            }
        }
        CollectionsKt.removeLastOrNull(path);
        CollectionsKt.removeLastOrNull(states);
    }

    private ExpressionsRuntime visitTabs(DivTabs div, Div2View divView, List<String> path, List<String> states, ExpressionsRuntime parentRuntime) {
        int iIntValue;
        RuntimeTree tree;
        TabsStateCache tabsStateCache = this.tabsCache;
        String id = divView.getDataTag().getId();
        Intrinsics.checkNotNullExpressionValue(id, "divView.dataTag.id");
        List<String> list = path;
        Integer selectedTab = tabsStateCache.getSelectedTab(id, CollectionsKt.joinToString$default(list, RemoteSettings.FORWARD_SLASH_STRING, null, null, 0, null, null, 62, null));
        if (selectedTab != null) {
            iIntValue = selectedTab.intValue();
        } else {
            long jLongValue = div.selectedTab.evaluate(parentRuntime.getExpressionResolver()).longValue();
            long j = jLongValue >> 31;
            if (j == 0 || j == -1) {
                iIntValue = (int) jLongValue;
            } else {
                KAssert kAssert = KAssert.INSTANCE;
                if (Assert.isEnabled()) {
                    Assert.fail("Unable convert '" + jLongValue + "' to Int");
                }
                iIntValue = jLongValue > 0 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            }
        }
        int i = iIntValue;
        int i2 = 0;
        for (Object obj : div.items) {
            int i3 = i2 + 1;
            if (i2 < 0) {
                CollectionsKt.throwIndexOverflow();
            }
            DivTabs.Item item = (DivTabs.Item) obj;
            path.add(BaseDivViewExtensionsKt.getChildPathUnit(item.div.value(), i2));
            if (i == i2) {
                visit(item.div, divView, path, states, parentRuntime);
            } else {
                RuntimeStore runtimeStore = divView.getRuntimeStore();
                if (runtimeStore != null && (tree = runtimeStore.getTree()) != null) {
                    tree.invokeRecursively(parentRuntime, CollectionsKt.joinToString$default(list, RemoteSettings.FORWARD_SLASH_STRING, null, null, 0, null, null, 62, null), new Function1<RuntimeTree.RuntimeNode, Unit>() { // from class: com.yandex.div.core.expression.local.DivRuntimeVisitor$visitTabs$1$1
                        @Override // kotlin.jvm.functions.Function1
                        public /* bridge */ /* synthetic */ Unit invoke(RuntimeTree.RuntimeNode runtimeNode) {
                            invoke2(runtimeNode);
                            return Unit.INSTANCE;
                        }

                        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                        public final void invoke2(RuntimeTree.RuntimeNode node) {
                            Intrinsics.checkNotNullParameter(node, "node");
                            node.getRuntime().clearBinding();
                        }
                    });
                }
                CollectionsKt.removeLastOrNull(path);
                i = i;
                i2 = i3;
            }
            CollectionsKt.removeLastOrNull(path);
            i = i;
            i2 = i3;
        }
        return null;
    }
}
