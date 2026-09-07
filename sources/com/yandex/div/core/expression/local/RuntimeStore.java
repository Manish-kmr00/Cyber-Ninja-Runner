package com.yandex.div.core.expression.local;

import com.yandex.div.core.Div2Logger;
import com.yandex.div.core.ObserverList;
import com.yandex.div.core.expression.ExpressionResolverImpl;
import com.yandex.div.core.expression.ExpressionsRuntime;
import com.yandex.div.core.expression.FunctionProviderDecorator;
import com.yandex.div.core.expression.triggers.TriggersController;
import com.yandex.div.core.expression.variables.VariableControllerImpl;
import com.yandex.div.core.util.FunctionMapperKt;
import com.yandex.div.core.view2.divs.DivActionBinder;
import com.yandex.div.core.view2.errors.ErrorCollector;
import com.yandex.div.data.Variable;
import com.yandex.div.evaluable.EvaluationContext;
import com.yandex.div.evaluable.Evaluator;
import com.yandex.div.internal.Assert;
import com.yandex.div.json.expressions.ExpressionResolver;
import com.yandex.div2.DivBase;
import com.yandex.div2.DivFunction;
import com.yandex.div2.DivTrigger;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: RuntimeStore.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000\u0086\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010$\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0000\u0018\u00002\u00020\u0001B%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ\r\u0010#\u001a\u00020$H\u0000¢\u0006\u0002\b%J\r\u0010&\u001a\u00020$H\u0000¢\u0006\u0002\b'JR\u0010(\u001a\u00020\r2\u0006\u0010)\u001a\u00020\r2\b\u0010*\u001a\u0004\u0018\u00010\r2\u0006\u0010+\u001a\u00020,2\u000e\u0010-\u001a\n\u0012\u0004\u0012\u00020/\u0018\u00010.2\u000e\u00100\u001a\n\u0012\u0004\u0012\u000201\u0018\u00010.2\u000e\u00102\u001a\n\u0012\u0004\u0012\u000203\u0018\u00010.H\u0002Je\u00104\u001a\u0004\u0018\u00010\r2\u0006\u0010+\u001a\u00020,2\u0010\b\u0002\u0010-\u001a\n\u0012\u0004\u0012\u00020/\u0018\u00010.2\u0010\b\u0002\u00105\u001a\n\u0012\u0004\u0012\u000201\u0018\u00010.2\u0010\b\u0002\u00102\u001a\n\u0012\u0004\u0012\u000203\u0018\u00010.2\n\b\u0002\u00106\u001a\u0004\u0018\u00010\u00162\n\b\u0002\u0010*\u001a\u0004\u0018\u00010\rH\u0000¢\u0006\u0002\b7Jf\u00108\u001a\u0004\u0018\u00010\r2\u0006\u0010+\u001a\u00020,2\u000e\u0010-\u001a\n\u0012\u0004\u0012\u00020/\u0018\u00010.2\u000e\u00100\u001a\n\u0012\u0004\u0012\u000201\u0018\u00010.2\u000e\u00102\u001a\n\u0012\u0004\u0012\u000203\u0018\u00010.2\n\b\u0002\u00109\u001a\u0004\u0018\u00010\r2\n\b\u0002\u00106\u001a\u0004\u0018\u00010\u00162\n\b\u0002\u0010*\u001a\u0004\u0018\u00010\rH\u0002J\u0017\u0010:\u001a\u0004\u0018\u00010\r2\u0006\u0010;\u001a\u00020\u0016H\u0000¢\u0006\u0002\b<J\u0019\u0010=\u001a\u000e\u0012\u0004\u0012\u00020,\u0012\u0004\u0012\u00020\r0>H\u0000¢\u0006\u0002\b?J\u0015\u0010@\u001a\u00020$2\u0006\u0010A\u001a\u00020\rH\u0000¢\u0006\u0002\bBJ'\u0010@\u001a\u00020$2\u0006\u0010A\u001a\u00020\r2\u0006\u0010+\u001a\u00020,2\b\u0010*\u001a\u0004\u0018\u00010\rH\u0000¢\u0006\u0002\bBJ\u0010\u0010C\u001a\u00020$2\u0006\u0010D\u001a\u00020,H\u0002JY\u0010E\u001a\u0004\u0018\u00010\r2\u0006\u0010+\u001a\u00020,2\u000e\u0010-\u001a\n\u0012\u0004\u0012\u00020/\u0018\u00010.2\u000e\u00105\u001a\n\u0012\u0004\u0012\u000201\u0018\u00010.2\u000e\u00102\u001a\n\u0012\u0004\u0012\u000203\u0018\u00010.2\u0006\u0010;\u001a\u00020\u00162\b\u00106\u001a\u0004\u0018\u00010\u0016H\u0000¢\u0006\u0002\bFJ\u0015\u0010G\u001a\u00020$2\u0006\u0010H\u001a\u00020IH\u0000¢\u0006\u0002\bJJ\r\u0010K\u001a\u00020$H\u0000¢\u0006\u0002\bLR\u0014\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\r0\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u001b\u0010\u000e\u001a\u00020\u000f8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0010\u0010\u0011R\u001c\u0010\u0014\u001a\u0010\u0012\u0004\u0012\u00020\u0016\u0012\u0006\u0012\u0004\u0018\u00010\r0\u0015X\u0082\u0004¢\u0006\u0002\n\u0000R(\u0010\u0018\u001a\u0004\u0018\u00010\r2\b\u0010\u0017\u001a\u0004\u0018\u00010\r@@X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001cR\u0014\u0010\u001d\u001a\u00020\u001eX\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010 R\u000e\u0010!\u001a\u00020\"X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006M"}, d2 = {"Lcom/yandex/div/core/expression/local/RuntimeStore;", "", "evaluator", "Lcom/yandex/div/evaluable/Evaluator;", "errorCollector", "Lcom/yandex/div/core/view2/errors/ErrorCollector;", "div2Logger", "Lcom/yandex/div/core/Div2Logger;", "divActionBinder", "Lcom/yandex/div/core/view2/divs/DivActionBinder;", "(Lcom/yandex/div/evaluable/Evaluator;Lcom/yandex/div/core/view2/errors/ErrorCollector;Lcom/yandex/div/core/Div2Logger;Lcom/yandex/div/core/view2/divs/DivActionBinder;)V", "allRuntimes", "Lcom/yandex/div/core/ObserverList;", "Lcom/yandex/div/core/expression/ExpressionsRuntime;", "onCreateCallback", "Lcom/yandex/div/core/expression/ExpressionResolverImpl$OnCreateCallback;", "getOnCreateCallback", "()Lcom/yandex/div/core/expression/ExpressionResolverImpl$OnCreateCallback;", "onCreateCallback$delegate", "Lkotlin/Lazy;", "resolverToRuntime", "", "Lcom/yandex/div/json/expressions/ExpressionResolver;", "value", "rootRuntime", "getRootRuntime$div_release", "()Lcom/yandex/div/core/expression/ExpressionsRuntime;", "setRootRuntime$div_release", "(Lcom/yandex/div/core/expression/ExpressionsRuntime;)V", "tree", "Lcom/yandex/div/core/expression/local/RuntimeTree;", "getTree$div_release", "()Lcom/yandex/div/core/expression/local/RuntimeTree;", "warningShown", "", "cleanup", "", "cleanup$div_release", "clearBindings", "clearBindings$div_release", "createChildRuntime", "baseRuntime", "parentRuntime", "path", "", "variables", "", "Lcom/yandex/div/data/Variable;", "variablesTriggers", "Lcom/yandex/div2/DivTrigger;", "functions", "Lcom/yandex/div2/DivFunction;", "getOrCreateRuntime", "triggers", "parentResolver", "getOrCreateRuntime$div_release", "getRuntimeOrCreateChild", "existingRuntime", "getRuntimeWithOrNull", "resolver", "getRuntimeWithOrNull$div_release", "getUniquePathsAndRuntimes", "", "getUniquePathsAndRuntimes$div_release", "putRuntime", "runtime", "putRuntime$div_release", "reportError", "message", "resolveRuntimeWith", "resolveRuntimeWith$div_release", "showWarningIfNeeded", "child", "Lcom/yandex/div2/DivBase;", "showWarningIfNeeded$div_release", "updateSubscriptions", "updateSubscriptions$div_release", "div_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class RuntimeStore {
    private final ObserverList<ExpressionsRuntime> allRuntimes;
    private final Div2Logger div2Logger;
    private final DivActionBinder divActionBinder;
    private final ErrorCollector errorCollector;
    private final Evaluator evaluator;

    /* JADX INFO: renamed from: onCreateCallback$delegate, reason: from kotlin metadata */
    private final Lazy onCreateCallback;
    private final Map<ExpressionResolver, ExpressionsRuntime> resolverToRuntime;
    private ExpressionsRuntime rootRuntime;
    private final RuntimeTree tree;
    private boolean warningShown;

    public RuntimeStore(Evaluator evaluator, ErrorCollector errorCollector, Div2Logger div2Logger, DivActionBinder divActionBinder) {
        Intrinsics.checkNotNullParameter(evaluator, "evaluator");
        Intrinsics.checkNotNullParameter(errorCollector, "errorCollector");
        Intrinsics.checkNotNullParameter(div2Logger, "div2Logger");
        Intrinsics.checkNotNullParameter(divActionBinder, "divActionBinder");
        this.evaluator = evaluator;
        this.errorCollector = errorCollector;
        this.div2Logger = div2Logger;
        this.divActionBinder = divActionBinder;
        this.resolverToRuntime = new LinkedHashMap();
        this.allRuntimes = new ObserverList<>();
        this.tree = new RuntimeTree();
        this.onCreateCallback = LazyKt.lazy(new RuntimeStore$onCreateCallback$2(this));
    }

    /* JADX INFO: renamed from: getTree$div_release, reason: from getter */
    public final RuntimeTree getTree() {
        return this.tree;
    }

    /* JADX INFO: renamed from: getRootRuntime$div_release, reason: from getter */
    public final ExpressionsRuntime getRootRuntime() {
        return this.rootRuntime;
    }

    public final void setRootRuntime$div_release(ExpressionsRuntime expressionsRuntime) {
        this.rootRuntime = expressionsRuntime;
        if (expressionsRuntime != null) {
            putRuntime$div_release(expressionsRuntime, "", null);
        }
    }

    private final ExpressionResolverImpl.OnCreateCallback getOnCreateCallback() {
        return (ExpressionResolverImpl.OnCreateCallback) this.onCreateCallback.getValue();
    }

    public final void showWarningIfNeeded$div_release(DivBase child) {
        Intrinsics.checkNotNullParameter(child, "child");
        if (this.warningShown || child.getVariables() == null) {
            return;
        }
        this.warningShown = true;
        this.errorCollector.logWarning(new Throwable("You are using local variables. Please ensure that all elements that use local variables and all of their parents recursively have an 'id' attribute."));
    }

    public final ExpressionsRuntime getOrCreateRuntime$div_release(String path, List<? extends Variable> variables, List<DivTrigger> triggers, List<DivFunction> functions, ExpressionResolver parentResolver, ExpressionsRuntime parentRuntime) {
        ExpressionsRuntime runtime;
        Intrinsics.checkNotNullParameter(path, "path");
        RuntimeTree.RuntimeNode node = this.tree.getNode(path);
        return (node == null || (runtime = node.getRuntime()) == null) ? getRuntimeOrCreateChild(path, variables, triggers, functions, null, parentResolver, parentRuntime) : runtime;
    }

    public final ExpressionsRuntime getRuntimeWithOrNull$div_release(ExpressionResolver resolver) {
        Intrinsics.checkNotNullParameter(resolver, "resolver");
        return this.resolverToRuntime.get(resolver);
    }

    public final void putRuntime$div_release(ExpressionsRuntime runtime) {
        Intrinsics.checkNotNullParameter(runtime, "runtime");
        this.resolverToRuntime.put(runtime.getExpressionResolver(), runtime);
        this.allRuntimes.addObserver(runtime);
    }

    public final void putRuntime$div_release(ExpressionsRuntime runtime, String path, ExpressionsRuntime parentRuntime) {
        Intrinsics.checkNotNullParameter(runtime, "runtime");
        Intrinsics.checkNotNullParameter(path, "path");
        putRuntime$div_release(runtime);
        this.tree.storeRuntime(runtime, parentRuntime, path);
        runtime.updateSubscriptions();
    }

    public final ExpressionsRuntime resolveRuntimeWith$div_release(String path, List<? extends Variable> variables, List<DivTrigger> triggers, List<DivFunction> functions, ExpressionResolver resolver, ExpressionResolver parentResolver) {
        Intrinsics.checkNotNullParameter(path, "path");
        Intrinsics.checkNotNullParameter(resolver, "resolver");
        RuntimeTree.RuntimeNode node = this.tree.getNode(path);
        ExpressionsRuntime runtime = node != null ? node.getRuntime() : null;
        if (Intrinsics.areEqual(resolver, runtime != null ? runtime.getExpressionResolver() : null)) {
            return runtime;
        }
        ExpressionsRuntime runtimeWithOrNull$div_release = getRuntimeWithOrNull$div_release(resolver);
        if (runtimeWithOrNull$div_release == null) {
            reportError("ExpressionResolverImpl didn't call RuntimeStore#putRuntime on create.");
            return null;
        }
        if (runtime != null) {
            this.tree.removeRuntimeAndCleanup(runtime, path);
        }
        return getRuntimeOrCreateChild$default(this, path, variables, triggers, functions, runtimeWithOrNull$div_release, parentResolver, null, 64, null);
    }

    public final void cleanup$div_release() {
        this.warningShown = false;
        Iterator<ExpressionsRuntime> it = this.allRuntimes.iterator();
        while (it.hasNext()) {
            it.next().cleanup$div_release();
        }
    }

    public final void updateSubscriptions$div_release() {
        Iterator<ExpressionsRuntime> it = this.allRuntimes.iterator();
        while (it.hasNext()) {
            it.next().updateSubscriptions();
        }
    }

    public final void clearBindings$div_release() {
        Iterator<ExpressionsRuntime> it = this.allRuntimes.iterator();
        while (it.hasNext()) {
            it.next().clearBinding();
        }
    }

    public final Map<String, ExpressionsRuntime> getUniquePathsAndRuntimes$div_release() {
        return this.tree.getPathToRuntimes();
    }

    private final void reportError(String message) {
        Assert.fail(message);
        this.errorCollector.logError(new AssertionError(message));
    }

    private final ExpressionsRuntime createChildRuntime(ExpressionsRuntime baseRuntime, ExpressionsRuntime parentRuntime, String path, List<? extends Variable> variables, List<DivTrigger> variablesTriggers, List<DivFunction> functions) {
        TriggersController triggersController;
        VariableControllerImpl variableControllerImpl = new VariableControllerImpl(baseRuntime.getVariableController());
        if (variables != null) {
            Iterator<T> it = variables.iterator();
            while (it.hasNext()) {
                variableControllerImpl.declare((Variable) it.next());
            }
        }
        FunctionProviderDecorator functionProvider = baseRuntime.getFunctionProvider();
        if (functions != null) {
            functionProvider = functionProvider.plus(FunctionMapperKt.toLocalFunctions(functions));
        }
        FunctionProviderDecorator functionProviderDecorator = functionProvider;
        Evaluator evaluator = new Evaluator(new EvaluationContext(variableControllerImpl, this.evaluator.getEvaluationContext().getStoredValueProvider(), functionProviderDecorator, this.evaluator.getEvaluationContext().getWarningSender()));
        VariableControllerImpl variableControllerImpl2 = variableControllerImpl;
        ExpressionResolverImpl expressionResolverImpl = new ExpressionResolverImpl(variableControllerImpl2, evaluator, this.errorCollector, getOnCreateCallback());
        if (variablesTriggers == null) {
            triggersController = null;
        } else {
            TriggersController triggersController2 = new TriggersController(variableControllerImpl2, expressionResolverImpl, evaluator, this.errorCollector, this.div2Logger, this.divActionBinder);
            triggersController2.ensureTriggersSynced(variablesTriggers);
            triggersController = triggersController2;
        }
        ExpressionsRuntime expressionsRuntime = new ExpressionsRuntime(expressionResolverImpl, variableControllerImpl2, triggersController, functionProviderDecorator, this);
        putRuntime$div_release(expressionsRuntime, path, parentRuntime);
        return expressionsRuntime;
    }

    static /* synthetic */ ExpressionsRuntime getRuntimeOrCreateChild$default(RuntimeStore runtimeStore, String str, List list, List list2, List list3, ExpressionsRuntime expressionsRuntime, ExpressionResolver expressionResolver, ExpressionsRuntime expressionsRuntime2, int i, Object obj) {
        return runtimeStore.getRuntimeOrCreateChild(str, list, list2, list3, (i & 16) != 0 ? null : expressionsRuntime, (i & 32) != 0 ? null : expressionResolver, (i & 64) != 0 ? null : expressionsRuntime2);
    }

    private final ExpressionsRuntime getRuntimeOrCreateChild(String path, List<? extends Variable> variables, List<DivTrigger> variablesTriggers, List<DivFunction> functions, ExpressionsRuntime existingRuntime, ExpressionResolver parentResolver, ExpressionsRuntime parentRuntime) {
        ExpressionsRuntime expressionsRuntime;
        ExpressionsRuntime expressionsRuntime2;
        if (existingRuntime != null) {
            expressionsRuntime = existingRuntime;
        } else if (parentRuntime == null) {
            existingRuntime = parentResolver != null ? getRuntimeWithOrNull$div_release(parentResolver) : null;
            if (existingRuntime == null && (existingRuntime = this.rootRuntime) == null) {
                reportError(RuntimeStoreKt.ERROR_ROOT_RUNTIME_NOT_SPECIFIED);
                return null;
            }
            expressionsRuntime = existingRuntime;
        } else {
            expressionsRuntime = parentRuntime;
        }
        if (parentRuntime != null) {
            expressionsRuntime2 = parentRuntime;
        } else if (parentResolver != null) {
            parentRuntime = getRuntimeWithOrNull$div_release(parentResolver);
            expressionsRuntime2 = parentRuntime;
        } else {
            expressionsRuntime2 = null;
        }
        if (UtilsKt.needLocalRuntime(variables, variablesTriggers, functions)) {
            return createChildRuntime(expressionsRuntime, expressionsRuntime2, path, variables, variablesTriggers, functions);
        }
        this.tree.storeRuntime(expressionsRuntime, expressionsRuntime2, path);
        expressionsRuntime.updateSubscriptions();
        return expressionsRuntime;
    }
}
