package com.yandex.div.core.expression.triggers;

import com.json.b9;
import com.yandex.div.core.Disposable;
import com.yandex.div.core.Div2Logger;
import com.yandex.div.core.DivActionHandler;
import com.yandex.div.core.DivViewFacade;
import com.yandex.div.core.downloader.PersistentDivDataObserver;
import com.yandex.div.core.expression.variables.VariableController;
import com.yandex.div.core.view2.Div2View;
import com.yandex.div.core.view2.divs.DivActionBinder;
import com.yandex.div.core.view2.errors.ErrorCollector;
import com.yandex.div.data.Variable;
import com.yandex.div.evaluable.Evaluable;
import com.yandex.div.evaluable.EvaluableException;
import com.yandex.div.evaluable.Evaluator;
import com.yandex.div.internal.Assert;
import com.yandex.div.json.expressions.Expression;
import com.yandex.div.json.expressions.ExpressionResolver;
import com.yandex.div2.DivAction;
import com.yandex.div2.DivTrigger;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: TriggersController.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000|\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\b\u0002\u0018\u00002\u00020\u0001Ba\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\t\u0012\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\r0\f\u0012\u0006\u0010\u000e\u001a\u00020\u000f\u0012\u0006\u0010\u0010\u001a\u00020\u0011\u0012\u0006\u0010\u0012\u001a\u00020\u0013\u0012\u0006\u0010\u0014\u001a\u00020\u0015\u0012\u0006\u0010\u0016\u001a\u00020\u0017¢\u0006\u0002\u0010\u0018J\b\u0010,\u001a\u00020+H\u0002J\b\u0010-\u001a\u00020\u001eH\u0002J\b\u0010.\u001a\u00020\u001eH\u0002J\b\u0010/\u001a\u00020\u001eH\u0002J\u0010\u00100\u001a\u00020\u001e2\u0006\u00101\u001a\u000202H\u0002R\u0014\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u001aX\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u001b\u001a\u000e\u0012\u0004\u0012\u00020\u001d\u0012\u0004\u0012\u00020\u001e0\u001cX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001f\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0017X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0015X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\r0\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010 \u001a\u00020\u001aX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010!\u001a\u00020\u001aX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\"\u001a\u00020\u001aX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0082\u0004¢\u0006\u0002\n\u0000R(\u0010%\u001a\u0004\u0018\u00010$2\b\u0010#\u001a\u0004\u0018\u00010$@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b&\u0010'\"\u0004\b(\u0010)R\u000e\u0010*\u001a\u00020+X\u0082\u000e¢\u0006\u0002\n\u0000¨\u00063"}, d2 = {"Lcom/yandex/div/core/expression/triggers/TriggerExecutor;", "", "rawExpression", "", "condition", "Lcom/yandex/div/evaluable/Evaluable;", "evaluator", "Lcom/yandex/div/evaluable/Evaluator;", "actions", "", "Lcom/yandex/div2/DivAction;", b9.a.t, "Lcom/yandex/div/json/expressions/Expression;", "Lcom/yandex/div2/DivTrigger$Mode;", "resolver", "Lcom/yandex/div/json/expressions/ExpressionResolver;", "variableController", "Lcom/yandex/div/core/expression/variables/VariableController;", "errorCollector", "Lcom/yandex/div/core/view2/errors/ErrorCollector;", "logger", "Lcom/yandex/div/core/Div2Logger;", "divActionBinder", "Lcom/yandex/div/core/view2/divs/DivActionBinder;", "(Ljava/lang/String;Lcom/yandex/div/evaluable/Evaluable;Lcom/yandex/div/evaluable/Evaluator;Ljava/util/List;Lcom/yandex/div/json/expressions/Expression;Lcom/yandex/div/json/expressions/ExpressionResolver;Lcom/yandex/div/core/expression/variables/VariableController;Lcom/yandex/div/core/view2/errors/ErrorCollector;Lcom/yandex/div/core/Div2Logger;Lcom/yandex/div/core/view2/divs/DivActionBinder;)V", "bindCompletionDisposable", "Lcom/yandex/div/core/Disposable;", "changeTrigger", "Lkotlin/Function1;", "Lcom/yandex/div/data/Variable;", "", "currentMode", "modeObserver", "observersDisposable", "removingDisposable", "value", "Lcom/yandex/div/core/DivViewFacade;", "view", "getView", "()Lcom/yandex/div/core/DivViewFacade;", "setView", "(Lcom/yandex/div/core/DivViewFacade;)V", "wasConditionSatisfied", "", "conditionSatisfied", "startObserving", "stopObserving", "tryTriggerActions", "tryTriggerActionsAfterBind", "div2View", "Lcom/yandex/div/core/view2/Div2View;", "div_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
final class TriggerExecutor {
    private final List<DivAction> actions;
    private Disposable bindCompletionDisposable;
    private final Function1<Variable, Unit> changeTrigger;
    private final Evaluable condition;
    private DivTrigger.Mode currentMode;
    private final DivActionBinder divActionBinder;
    private final ErrorCollector errorCollector;
    private final Evaluator evaluator;
    private final Div2Logger logger;
    private final Expression<DivTrigger.Mode> mode;
    private Disposable modeObserver;
    private Disposable observersDisposable;
    private final String rawExpression;
    private Disposable removingDisposable;
    private final ExpressionResolver resolver;
    private final VariableController variableController;
    private DivViewFacade view;
    private boolean wasConditionSatisfied;

    public TriggerExecutor(String rawExpression, Evaluable condition, Evaluator evaluator, List<DivAction> actions, Expression<DivTrigger.Mode> mode, ExpressionResolver resolver, VariableController variableController, ErrorCollector errorCollector, Div2Logger logger, DivActionBinder divActionBinder) {
        Intrinsics.checkNotNullParameter(rawExpression, "rawExpression");
        Intrinsics.checkNotNullParameter(condition, "condition");
        Intrinsics.checkNotNullParameter(evaluator, "evaluator");
        Intrinsics.checkNotNullParameter(actions, "actions");
        Intrinsics.checkNotNullParameter(mode, "mode");
        Intrinsics.checkNotNullParameter(resolver, "resolver");
        Intrinsics.checkNotNullParameter(variableController, "variableController");
        Intrinsics.checkNotNullParameter(errorCollector, "errorCollector");
        Intrinsics.checkNotNullParameter(logger, "logger");
        Intrinsics.checkNotNullParameter(divActionBinder, "divActionBinder");
        this.rawExpression = rawExpression;
        this.condition = condition;
        this.evaluator = evaluator;
        this.actions = actions;
        this.mode = mode;
        this.resolver = resolver;
        this.variableController = variableController;
        this.errorCollector = errorCollector;
        this.logger = logger;
        this.divActionBinder = divActionBinder;
        this.changeTrigger = new Function1<Variable, Unit>() { // from class: com.yandex.div.core.expression.triggers.TriggerExecutor$changeTrigger$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Variable variable) {
                invoke2(variable);
                return Unit.INSTANCE;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Variable variable) {
                Intrinsics.checkNotNullParameter(variable, "<anonymous parameter 0>");
                this.this$0.tryTriggerActions();
            }
        };
        this.modeObserver = mode.observeAndGet(resolver, new Function1<DivTrigger.Mode, Unit>() { // from class: com.yandex.div.core.expression.triggers.TriggerExecutor$modeObserver$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(DivTrigger.Mode mode2) {
                invoke2(mode2);
                return Unit.INSTANCE;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(DivTrigger.Mode it) {
                Intrinsics.checkNotNullParameter(it, "it");
                this.this$0.currentMode = it;
            }
        });
        this.currentMode = DivTrigger.Mode.ON_CONDITION;
        this.observersDisposable = Disposable.NULL;
        this.removingDisposable = Disposable.NULL;
        this.bindCompletionDisposable = Disposable.NULL;
    }

    public final DivViewFacade getView() {
        return this.view;
    }

    public final void setView(DivViewFacade divViewFacade) {
        this.view = divViewFacade;
        if (divViewFacade == null) {
            stopObserving();
        } else {
            startObserving();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void stopObserving() {
        this.modeObserver.close();
        this.observersDisposable.close();
        this.removingDisposable.close();
        this.bindCompletionDisposable.close();
    }

    private final void startObserving() {
        this.modeObserver.close();
        this.observersDisposable = this.variableController.subscribeToVariablesChange(this.condition.getVariables(), false, this.changeTrigger);
        this.removingDisposable = this.variableController.subscribeToVariablesUndeclared(this.condition.getVariables(), new Function1<Variable, Unit>() { // from class: com.yandex.div.core.expression.triggers.TriggerExecutor.startObserving.1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Variable variable) {
                invoke2(variable);
                return Unit.INSTANCE;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Variable it) {
                Intrinsics.checkNotNullParameter(it, "it");
                TriggerExecutor.this.stopObserving();
            }
        });
        this.modeObserver = this.mode.observeAndGet(this.resolver, new Function1<DivTrigger.Mode, Unit>() { // from class: com.yandex.div.core.expression.triggers.TriggerExecutor.startObserving.2
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(DivTrigger.Mode mode) {
                invoke2(mode);
                return Unit.INSTANCE;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(DivTrigger.Mode it) {
                Intrinsics.checkNotNullParameter(it, "it");
                TriggerExecutor.this.currentMode = it;
            }
        });
        tryTriggerActions();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void tryTriggerActions() {
        Assert.assertMainThread();
        DivViewFacade divViewFacade = this.view;
        if (divViewFacade == null) {
            return;
        }
        boolean z = divViewFacade instanceof Div2View;
        Div2View div2View = z ? (Div2View) divViewFacade : null;
        if (div2View != null) {
            if (!div2View.getInMiddleOfBind()) {
                div2View = null;
            }
            if (div2View != null) {
                tryTriggerActionsAfterBind(div2View);
                return;
            }
        }
        if (conditionSatisfied()) {
            for (DivAction divAction : this.actions) {
                Div2View div2View2 = z ? (Div2View) divViewFacade : null;
                if (div2View2 != null) {
                    this.logger.logTrigger(div2View2, divAction);
                }
            }
            DivActionBinder.handleActions$div_release$default(this.divActionBinder, divViewFacade, this.resolver, this.actions, DivActionHandler.DivActionReason.TRIGGER, null, 16, null);
        }
    }

    /* JADX WARN: Type inference failed for: r0v1, types: [com.yandex.div.core.expression.triggers.TriggerExecutor$tryTriggerActionsAfterBind$observer$1] */
    private final void tryTriggerActionsAfterBind(final Div2View div2View) {
        this.bindCompletionDisposable.close();
        final ?? r0 = new PersistentDivDataObserver() { // from class: com.yandex.div.core.expression.triggers.TriggerExecutor$tryTriggerActionsAfterBind$observer$1
            @Override // com.yandex.div.core.downloader.PersistentDivDataObserver
            public void onAfterDivDataChanged() {
                div2View.removePersistentDivDataObserver$div_release(this);
                this.tryTriggerActions();
            }
        };
        this.bindCompletionDisposable = new Disposable() { // from class: com.yandex.div.core.expression.triggers.TriggerExecutor$$ExternalSyntheticLambda0
            @Override // com.yandex.div.core.Disposable, java.lang.AutoCloseable, java.io.Closeable
            public final void close() {
                TriggerExecutor.tryTriggerActionsAfterBind$lambda$4(div2View, r0);
            }
        };
        div2View.addPersistentDivDataObserver$div_release((PersistentDivDataObserver) r0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void tryTriggerActionsAfterBind$lambda$4(Div2View div2View, TriggerExecutor$tryTriggerActionsAfterBind$observer$1 observer) {
        Intrinsics.checkNotNullParameter(div2View, "$div2View");
        Intrinsics.checkNotNullParameter(observer, "$observer");
        div2View.removePersistentDivDataObserver$div_release(observer);
    }

    private final boolean conditionSatisfied() throws Exception {
        RuntimeException runtimeException;
        try {
            boolean zBooleanValue = ((Boolean) this.evaluator.eval(this.condition)).booleanValue();
            boolean z = this.wasConditionSatisfied;
            this.wasConditionSatisfied = zBooleanValue;
            if (zBooleanValue) {
                return (this.currentMode == DivTrigger.Mode.ON_CONDITION && z && zBooleanValue) ? false : true;
            }
            return false;
        } catch (Exception e) {
            if (e instanceof ClassCastException) {
                runtimeException = new RuntimeException("Condition evaluated in non-boolean result! (expression: '" + this.rawExpression + "')", e);
            } else if (e instanceof EvaluableException) {
                runtimeException = new RuntimeException("Condition evaluation failed! (expression: '" + this.rawExpression + "')", e);
            } else {
                throw e;
            }
            this.errorCollector.logError(runtimeException);
            return false;
        }
    }
}
