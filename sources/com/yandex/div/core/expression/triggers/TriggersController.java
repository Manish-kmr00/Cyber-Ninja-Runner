package com.yandex.div.core.expression.triggers;

import com.yandex.div.core.Div2Logger;
import com.yandex.div.core.DivViewFacade;
import com.yandex.div.core.expression.variables.VariableController;
import com.yandex.div.core.view2.divs.DivActionBinder;
import com.yandex.div.core.view2.errors.ErrorCollector;
import com.yandex.div.evaluable.Evaluable;
import com.yandex.div.evaluable.EvaluableException;
import com.yandex.div.evaluable.Evaluator;
import com.yandex.div.json.expressions.ExpressionResolver;
import com.yandex.div2.DivTrigger;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: TriggersController.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000d\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010%\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u0003\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0010\u0018\u00002\u00020\u0001B5\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\u0006\u0010\f\u001a\u00020\r¢\u0006\u0002\u0010\u000eJ\b\u0010\u0018\u001a\u00020\u0019H\u0016J\u0016\u0010\u001a\u001a\u00020\u00192\f\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u00110\u0010H\u0016J\u0018\u0010\u001c\u001a\u0004\u0018\u00010\u001d2\f\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u001f0\u0010H\u0012J\u0010\u0010 \u001a\u00020\u00192\u0006\u0010!\u001a\u00020\u0013H\u0016R\u0016\u0010\u000f\u001a\n\u0012\u0004\u0012\u00020\u0011\u0018\u00010\u0010X\u0092\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u0013X\u0092\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0092\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0092\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0092\u0004¢\u0006\u0002\n\u0000R&\u0010\u0014\u001a\u001a\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00110\u0010\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00170\u00160\u0015X\u0092\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0092\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0092\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0092\u0004¢\u0006\u0002\n\u0000¨\u0006\""}, d2 = {"Lcom/yandex/div/core/expression/triggers/TriggersController;", "", "variableController", "Lcom/yandex/div/core/expression/variables/VariableController;", "expressionResolver", "Lcom/yandex/div/json/expressions/ExpressionResolver;", "evaluator", "Lcom/yandex/div/evaluable/Evaluator;", "errorCollector", "Lcom/yandex/div/core/view2/errors/ErrorCollector;", "logger", "Lcom/yandex/div/core/Div2Logger;", "divActionBinder", "Lcom/yandex/div/core/view2/divs/DivActionBinder;", "(Lcom/yandex/div/core/expression/variables/VariableController;Lcom/yandex/div/json/expressions/ExpressionResolver;Lcom/yandex/div/evaluable/Evaluator;Lcom/yandex/div/core/view2/errors/ErrorCollector;Lcom/yandex/div/core/Div2Logger;Lcom/yandex/div/core/view2/divs/DivActionBinder;)V", "activeTriggers", "", "Lcom/yandex/div2/DivTrigger;", "currentView", "Lcom/yandex/div/core/DivViewFacade;", "executors", "", "", "Lcom/yandex/div/core/expression/triggers/TriggerExecutor;", "clearBinding", "", "ensureTriggersSynced", "divTriggers", "findErrors", "", "variables", "", "onAttachedToWindow", "view", "div_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public class TriggersController {
    private List<DivTrigger> activeTriggers;
    private DivViewFacade currentView;
    private final DivActionBinder divActionBinder;
    private final ErrorCollector errorCollector;
    private final Evaluator evaluator;
    private final Map<List<DivTrigger>, List<TriggerExecutor>> executors;
    private final ExpressionResolver expressionResolver;
    private final Div2Logger logger;
    private final VariableController variableController;

    public TriggersController(VariableController variableController, ExpressionResolver expressionResolver, Evaluator evaluator, ErrorCollector errorCollector, Div2Logger logger, DivActionBinder divActionBinder) {
        Intrinsics.checkNotNullParameter(variableController, "variableController");
        Intrinsics.checkNotNullParameter(expressionResolver, "expressionResolver");
        Intrinsics.checkNotNullParameter(evaluator, "evaluator");
        Intrinsics.checkNotNullParameter(errorCollector, "errorCollector");
        Intrinsics.checkNotNullParameter(logger, "logger");
        Intrinsics.checkNotNullParameter(divActionBinder, "divActionBinder");
        this.variableController = variableController;
        this.expressionResolver = expressionResolver;
        this.evaluator = evaluator;
        this.errorCollector = errorCollector;
        this.logger = logger;
        this.divActionBinder = divActionBinder;
        this.executors = new LinkedHashMap();
    }

    public void ensureTriggersSynced(List<DivTrigger> divTriggers) {
        Intrinsics.checkNotNullParameter(divTriggers, "divTriggers");
        if (this.activeTriggers == divTriggers) {
            return;
        }
        this.activeTriggers = divTriggers;
        DivViewFacade divViewFacade = this.currentView;
        Map<List<DivTrigger>, List<TriggerExecutor>> map = this.executors;
        ArrayList arrayList = map.get(divTriggers);
        if (arrayList == null) {
            arrayList = new ArrayList();
            map.put(divTriggers, arrayList);
        }
        List<TriggerExecutor> list = arrayList;
        clearBinding();
        for (DivTrigger divTrigger : divTriggers) {
            String string = divTrigger.condition.getRawValue().toString();
            try {
                Evaluable evaluableLazy = Evaluable.INSTANCE.lazy(string);
                Throwable thFindErrors = findErrors(evaluableLazy.getVariables());
                if (thFindErrors != null) {
                    this.errorCollector.logError(new IllegalStateException("Invalid condition: '" + divTrigger.condition + '\'', thFindErrors));
                } else {
                    list.add(new TriggerExecutor(string, evaluableLazy, this.evaluator, divTrigger.actions, divTrigger.mode, this.expressionResolver, this.variableController, this.errorCollector, this.logger, this.divActionBinder));
                }
            } catch (EvaluableException unused) {
            }
        }
        if (divViewFacade != null) {
            onAttachedToWindow(divViewFacade);
        }
    }

    private Throwable findErrors(List<String> variables) {
        if (variables.isEmpty()) {
            return new RuntimeException("No variables defined!");
        }
        return null;
    }

    public void clearBinding() {
        this.currentView = null;
        Iterator<Map.Entry<List<DivTrigger>, List<TriggerExecutor>>> it = this.executors.entrySet().iterator();
        while (it.hasNext()) {
            Iterator<T> it2 = it.next().getValue().iterator();
            while (it2.hasNext()) {
                ((TriggerExecutor) it2.next()).setView(null);
            }
        }
    }

    public void onAttachedToWindow(DivViewFacade view) {
        List<TriggerExecutor> list;
        Intrinsics.checkNotNullParameter(view, "view");
        if (Intrinsics.areEqual(this.currentView, view)) {
            return;
        }
        this.currentView = view;
        List<DivTrigger> list2 = this.activeTriggers;
        if (list2 == null || (list = this.executors.get(list2)) == null) {
            return;
        }
        Iterator<T> it = list.iterator();
        while (it.hasNext()) {
            ((TriggerExecutor) it.next()).setView(view);
        }
    }
}
