package com.yandex.div.core.expression;

import com.yandex.div.DivDataTag;
import com.yandex.div.core.Div2Logger;
import com.yandex.div.core.dagger.DivScope;
import com.yandex.div.core.expression.local.RuntimeStore;
import com.yandex.div.core.expression.storedvalues.StoredValuesController;
import com.yandex.div.core.expression.triggers.TriggersController;
import com.yandex.div.core.expression.variables.DivVariableController;
import com.yandex.div.core.expression.variables.DivVariablesParserKt;
import com.yandex.div.core.expression.variables.VariableController;
import com.yandex.div.core.expression.variables.VariableControllerImpl;
import com.yandex.div.core.timer.TimerController;
import com.yandex.div.core.view2.Div2View;
import com.yandex.div.core.view2.divs.DivActionBinder;
import com.yandex.div.core.view2.errors.ErrorCollector;
import com.yandex.div.core.view2.errors.ErrorCollectors;
import com.yandex.div.data.StoredValue;
import com.yandex.div.data.Variable;
import com.yandex.div.data.VariableDeclarationException;
import com.yandex.div.evaluable.Evaluable;
import com.yandex.div.evaluable.EvaluationContext;
import com.yandex.div.evaluable.Evaluator;
import com.yandex.div.evaluable.StoredValueProvider;
import com.yandex.div.evaluable.WarningSender;
import com.yandex.div.evaluable.function.GeneratedBuiltinFunctionProvider;
import com.yandex.div2.DivData;
import com.yandex.div2.DivTrigger;
import com.yandex.div2.DivVariable;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.WeakHashMap;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: compiled from: ExpressionsRuntimeProvider.kt */
/* JADX INFO: loaded from: classes10.dex */
@Metadata(d1 = {"\u0000v\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010#\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010%\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010$\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010 \n\u0000\b\u0011\u0018\u00002\u00020\u0001B/\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b¢\u0006\u0002\u0010\fJ\u0015\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u000fH\u0010¢\u0006\u0002\b\u001aJ\u0018\u0010\u001b\u001a\u00020\u00152\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u001fH\u0012J \u0010 \u001a\u00020\u00182\u0006\u0010!\u001a\u00020\"2\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010#\u001a\u00020$H\u0012J%\u0010%\u001a\u00020\u00152\u0006\u0010\u001e\u001a\u00020\u001f2\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010&\u001a\u00020\u000fH\u0010¢\u0006\u0002\b'J\u0016\u0010(\u001a\u00020\u00182\f\u0010)\u001a\b\u0012\u0004\u0012\u00020\u001f0*H\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0092\u0004¢\u0006\u0002\n\u0000R \u0010\r\u001a\u0014\u0012\u0004\u0012\u00020\u000f\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00110\u00100\u000eX\u0092\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0092\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0092\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0092\u0004¢\u0006\u0002\n\u0000RN\u0010\u0012\u001aB\u0012\f\u0012\n \u0014*\u0004\u0018\u00010\u00110\u0011\u0012\f\u0012\n \u0014*\u0004\u0018\u00010\u00150\u0015 \u0014* \u0012\f\u0012\n \u0014*\u0004\u0018\u00010\u00110\u0011\u0012\f\u0012\n \u0014*\u0004\u0018\u00010\u00150\u0015\u0018\u00010\u00160\u0013X\u0092\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0092\u0004¢\u0006\u0002\n\u0000¨\u0006+"}, d2 = {"Lcom/yandex/div/core/expression/ExpressionsRuntimeProvider;", "", "divVariableController", "Lcom/yandex/div/core/expression/variables/DivVariableController;", "divActionBinder", "Lcom/yandex/div/core/view2/divs/DivActionBinder;", "errorCollectors", "Lcom/yandex/div/core/view2/errors/ErrorCollectors;", "logger", "Lcom/yandex/div/core/Div2Logger;", "storedValuesController", "Lcom/yandex/div/core/expression/storedvalues/StoredValuesController;", "(Lcom/yandex/div/core/expression/variables/DivVariableController;Lcom/yandex/div/core/view2/divs/DivActionBinder;Lcom/yandex/div/core/view2/errors/ErrorCollectors;Lcom/yandex/div/core/Div2Logger;Lcom/yandex/div/core/expression/storedvalues/StoredValuesController;)V", "divDataTags", "Ljava/util/WeakHashMap;", "Lcom/yandex/div/core/view2/Div2View;", "", "", "runtimes", "", "kotlin.jvm.PlatformType", "Lcom/yandex/div/core/expression/ExpressionsRuntime;", "", "cleanupRuntime", "", "view", "cleanupRuntime$div_release", "createRuntimeFor", "data", "Lcom/yandex/div2/DivData;", "tag", "Lcom/yandex/div/DivDataTag;", "ensureVariablesSynced", "v", "Lcom/yandex/div/core/expression/variables/VariableController;", "errorCollector", "Lcom/yandex/div/core/view2/errors/ErrorCollector;", "getOrCreate", "div2View", "getOrCreate$div_release", TimerController.RESET_COMMAND, "tags", "", "div_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
@DivScope
public class ExpressionsRuntimeProvider {
    private final DivActionBinder divActionBinder;
    private final WeakHashMap<Div2View, Set<String>> divDataTags;
    private final DivVariableController divVariableController;
    private final ErrorCollectors errorCollectors;
    private final Div2Logger logger;
    private final Map<String, ExpressionsRuntime> runtimes;
    private final StoredValuesController storedValuesController;

    @Inject
    public ExpressionsRuntimeProvider(DivVariableController divVariableController, DivActionBinder divActionBinder, ErrorCollectors errorCollectors, Div2Logger logger, StoredValuesController storedValuesController) {
        Intrinsics.checkNotNullParameter(divVariableController, "divVariableController");
        Intrinsics.checkNotNullParameter(divActionBinder, "divActionBinder");
        Intrinsics.checkNotNullParameter(errorCollectors, "errorCollectors");
        Intrinsics.checkNotNullParameter(logger, "logger");
        Intrinsics.checkNotNullParameter(storedValuesController, "storedValuesController");
        this.divVariableController = divVariableController;
        this.divActionBinder = divActionBinder;
        this.errorCollectors = errorCollectors;
        this.logger = logger;
        this.storedValuesController = storedValuesController;
        this.runtimes = Collections.synchronizedMap(new LinkedHashMap());
        this.divDataTags = new WeakHashMap<>();
    }

    public ExpressionsRuntime getOrCreate$div_release(DivDataTag tag, DivData data, Div2View div2View) {
        Intrinsics.checkNotNullParameter(tag, "tag");
        Intrinsics.checkNotNullParameter(data, "data");
        Intrinsics.checkNotNullParameter(div2View, "div2View");
        Map<String, ExpressionsRuntime> runtimes = this.runtimes;
        Intrinsics.checkNotNullExpressionValue(runtimes, "runtimes");
        String id = tag.getId();
        ExpressionsRuntime expressionsRuntimeCreateRuntimeFor = runtimes.get(id);
        if (expressionsRuntimeCreateRuntimeFor == null) {
            expressionsRuntimeCreateRuntimeFor = createRuntimeFor(data, tag);
            runtimes.put(id, expressionsRuntimeCreateRuntimeFor);
        }
        ExpressionsRuntime result = expressionsRuntimeCreateRuntimeFor;
        ErrorCollector orCreate = this.errorCollectors.getOrCreate(tag, data);
        WeakHashMap<Div2View, Set<String>> weakHashMap = this.divDataTags;
        LinkedHashSet linkedHashSet = weakHashMap.get(div2View);
        if (linkedHashSet == null) {
            linkedHashSet = new LinkedHashSet();
            weakHashMap.put(div2View, linkedHashSet);
        }
        String id2 = tag.getId();
        Intrinsics.checkNotNullExpressionValue(id2, "tag.id");
        linkedHashSet.add(id2);
        ensureVariablesSynced(result.getVariableController(), data, orCreate);
        TriggersController triggersController = result.getTriggersController();
        if (triggersController != null) {
            List<DivTrigger> listEmptyList = data.variableTriggers;
            if (listEmptyList == null) {
                listEmptyList = CollectionsKt.emptyList();
            }
            triggersController.ensureTriggersSynced(listEmptyList);
        }
        Intrinsics.checkNotNullExpressionValue(result, "result");
        return result;
    }

    public void reset(List<? extends DivDataTag> tags) {
        Intrinsics.checkNotNullParameter(tags, "tags");
        if (tags.isEmpty()) {
            this.runtimes.clear();
            return;
        }
        Iterator<T> it = tags.iterator();
        while (it.hasNext()) {
            this.runtimes.remove(((DivDataTag) it.next()).getId());
        }
    }

    public void cleanupRuntime$div_release(Div2View view) {
        RuntimeStore runtimeStore;
        Intrinsics.checkNotNullParameter(view, "view");
        Set<String> set = this.divDataTags.get(view);
        if (set != null) {
            Iterator<T> it = set.iterator();
            while (it.hasNext()) {
                ExpressionsRuntime expressionsRuntime = this.runtimes.get((String) it.next());
                if (expressionsRuntime != null && (runtimeStore = expressionsRuntime.getRuntimeStore()) != null) {
                    runtimeStore.cleanup$div_release();
                }
            }
        }
        this.divDataTags.remove(view);
    }

    private void ensureVariablesSynced(VariableController v, DivData data, ErrorCollector errorCollector) {
        boolean z;
        List<DivVariable> list = data.variables;
        if (list != null) {
            for (DivVariable divVariable : list) {
                Variable mutableVariable = v.getMutableVariable(ExpressionsRuntimeProviderKt.getName(divVariable));
                if (mutableVariable == null) {
                    try {
                        v.declare(DivVariablesParserKt.toVariable(divVariable));
                    } catch (VariableDeclarationException e) {
                        errorCollector.logError(e);
                    }
                } else {
                    if (divVariable instanceof DivVariable.Bool) {
                        z = mutableVariable instanceof Variable.BooleanVariable;
                    } else if (divVariable instanceof DivVariable.Integer) {
                        z = mutableVariable instanceof Variable.IntegerVariable;
                    } else if (divVariable instanceof DivVariable.Number) {
                        z = mutableVariable instanceof Variable.DoubleVariable;
                    } else if (divVariable instanceof DivVariable.Str) {
                        z = mutableVariable instanceof Variable.StringVariable;
                    } else if (divVariable instanceof DivVariable.Color) {
                        z = mutableVariable instanceof Variable.ColorVariable;
                    } else if (divVariable instanceof DivVariable.Url) {
                        z = mutableVariable instanceof Variable.UrlVariable;
                    } else if (divVariable instanceof DivVariable.Dict) {
                        z = mutableVariable instanceof Variable.DictVariable;
                    } else {
                        if (!(divVariable instanceof DivVariable.Array)) {
                            throw new NoWhenBranchMatchedException();
                        }
                        z = mutableVariable instanceof Variable.ArrayVariable;
                    }
                    if (!z) {
                        errorCollector.logError(new IllegalArgumentException(StringsKt.trimIndent("\n                           Variable inconsistency detected!\n                           at DivData: " + ExpressionsRuntimeProviderKt.getName(divVariable) + " (" + divVariable + ")\n                           at VariableController: " + v.getMutableVariable(ExpressionsRuntimeProviderKt.getName(divVariable)) + "\n                        ")));
                    }
                }
            }
        }
    }

    private ExpressionsRuntime createRuntimeFor(DivData data, DivDataTag tag) {
        final ErrorCollector orCreate = this.errorCollectors.getOrCreate(tag, data);
        VariableControllerImpl variableControllerImpl = new VariableControllerImpl(null, 1, 0 == true ? 1 : 0);
        List<DivVariable> list = data.variables;
        if (list != null) {
            Iterator<T> it = list.iterator();
            while (it.hasNext()) {
                try {
                    variableControllerImpl.declare(DivVariablesParserKt.toVariable((DivVariable) it.next()));
                } catch (VariableDeclarationException e) {
                    orCreate.logError(e);
                }
            }
        }
        variableControllerImpl.addSource(this.divVariableController.getVariableSource());
        FunctionProviderDecorator functionProviderDecorator = new FunctionProviderDecorator(GeneratedBuiltinFunctionProvider.INSTANCE);
        Evaluator evaluator = new Evaluator(new EvaluationContext(variableControllerImpl, new StoredValueProvider() { // from class: com.yandex.div.core.expression.ExpressionsRuntimeProvider$$ExternalSyntheticLambda0
            @Override // com.yandex.div.evaluable.StoredValueProvider
            public final Object get(String str) {
                return ExpressionsRuntimeProvider.createRuntimeFor$lambda$8(this.f$0, orCreate, str);
            }
        }, functionProviderDecorator, new WarningSender() { // from class: com.yandex.div.core.expression.ExpressionsRuntimeProvider$createRuntimeFor$evaluationContext$2
            @Override // com.yandex.div.evaluable.WarningSender
            /* JADX INFO: renamed from: send-BIH1yYw, reason: not valid java name */
            public final void mo6114sendBIH1yYw(Evaluable expressionContext, String message) {
                Intrinsics.checkNotNullParameter(expressionContext, "expressionContext");
                Intrinsics.checkNotNullParameter(message, "message");
                orCreate.logWarning(new Throwable("Warning occurred while evaluating '" + expressionContext.getRawExpr() + "': " + message));
            }
        }));
        final RuntimeStore runtimeStore = new RuntimeStore(evaluator, orCreate, this.logger, this.divActionBinder);
        VariableControllerImpl variableControllerImpl2 = variableControllerImpl;
        ExpressionResolverImpl expressionResolverImpl = new ExpressionResolverImpl(variableControllerImpl2, evaluator, orCreate, new ExpressionResolverImpl.OnCreateCallback() { // from class: com.yandex.div.core.expression.ExpressionsRuntimeProvider$$ExternalSyntheticLambda1
            @Override // com.yandex.div.core.expression.ExpressionResolverImpl.OnCreateCallback
            public final void onCreate(ExpressionResolverImpl expressionResolverImpl2, VariableController variableController, FunctionProviderDecorator functionProviderDecorator2) {
                ExpressionsRuntimeProvider.createRuntimeFor$lambda$9(runtimeStore, expressionResolverImpl2, variableController, functionProviderDecorator2);
            }
        });
        ExpressionsRuntime expressionsRuntime = new ExpressionsRuntime(expressionResolverImpl, variableControllerImpl2, new TriggersController(variableControllerImpl2, expressionResolverImpl, evaluator, orCreate, this.logger, this.divActionBinder), functionProviderDecorator, runtimeStore);
        runtimeStore.setRootRuntime$div_release(expressionsRuntime);
        return expressionsRuntime;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Object createRuntimeFor$lambda$8(ExpressionsRuntimeProvider this$0, ErrorCollector errorCollector, String storedValueName) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(errorCollector, "$errorCollector");
        Intrinsics.checkNotNullParameter(storedValueName, "storedValueName");
        StoredValue storedValue = this$0.storedValuesController.getStoredValue(storedValueName, errorCollector);
        if (storedValue != null) {
            return storedValue.getValue();
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void createRuntimeFor$lambda$9(RuntimeStore runtimeStore, ExpressionResolverImpl resolver, VariableController variableController, FunctionProviderDecorator functionProvider) {
        Intrinsics.checkNotNullParameter(runtimeStore, "$runtimeStore");
        Intrinsics.checkNotNullParameter(resolver, "resolver");
        Intrinsics.checkNotNullParameter(variableController, "variableController");
        Intrinsics.checkNotNullParameter(functionProvider, "functionProvider");
        runtimeStore.putRuntime$div_release(new ExpressionsRuntime(resolver, variableController, null, functionProvider, runtimeStore));
    }
}
