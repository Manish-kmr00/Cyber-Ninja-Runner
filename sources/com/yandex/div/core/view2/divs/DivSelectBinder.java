package com.yandex.div.core.view2.divs;

import android.util.DisplayMetrics;
import com.yandex.div.core.Disposable;
import com.yandex.div.core.dagger.DivScope;
import com.yandex.div.core.expression.variables.TwoWayStringVariableBinder;
import com.yandex.div.core.state.DivStatePath;
import com.yandex.div.core.view2.BindingContext;
import com.yandex.div.core.view2.Div2View;
import com.yandex.div.core.view2.DivTypefaceResolver;
import com.yandex.div.core.view2.DivTypefaceResolverKt;
import com.yandex.div.core.view2.DivViewBinder;
import com.yandex.div.core.view2.animations.UtilsKt;
import com.yandex.div.core.view2.divs.widgets.DivSelectView;
import com.yandex.div.core.view2.errors.ErrorCollector;
import com.yandex.div.core.view2.errors.ErrorCollectors;
import com.yandex.div.internal.Assert;
import com.yandex.div.internal.KAssert;
import com.yandex.div.json.expressions.Expression;
import com.yandex.div.json.expressions.ExpressionResolver;
import com.yandex.div2.DivFontWeight;
import com.yandex.div2.DivSelect;
import com.yandex.div2.DivSizeUnit;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.sequences.Sequence;
import kotlin.sequences.SequencesKt;

/* JADX INFO: compiled from: DivSelectBinder.kt */
/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\b\u0001\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B'\b\u0007\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b¢\u0006\u0002\u0010\fJ(\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00032\u0006\u0010\u0012\u001a\u00020\u00022\u0006\u0010\u0013\u001a\u00020\u0014H\u0016J\u001c\u0010\u0015\u001a\u00020\u000e*\u00020\u00032\u0006\u0010\u0012\u001a\u00020\u00022\u0006\u0010\u0016\u001a\u00020\u0010H\u0002J\u001c\u0010\u0017\u001a\u00020\u000e*\u00020\u00032\u0006\u0010\u0012\u001a\u00020\u00022\u0006\u0010\u0018\u001a\u00020\u0019H\u0002J\"\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u001c0\u001b*\u00020\u00032\u0006\u0010\u0012\u001a\u00020\u00022\u0006\u0010\u0018\u001a\u00020\u0019H\u0002J\u001c\u0010\u001d\u001a\u00020\u000e*\u00020\u00032\u0006\u0010\u0012\u001a\u00020\u00022\u0006\u0010\u0018\u001a\u00020\u0019H\u0002J\u001c\u0010\u001e\u001a\u00020\u000e*\u00020\u00032\u0006\u0010\u0012\u001a\u00020\u00022\u0006\u0010\u0018\u001a\u00020\u0019H\u0002J\u001c\u0010\u001f\u001a\u00020\u000e*\u00020\u00032\u0006\u0010\u0012\u001a\u00020\u00022\u0006\u0010\u0018\u001a\u00020\u0019H\u0002J\u001c\u0010 \u001a\u00020\u000e*\u00020\u00032\u0006\u0010\u0012\u001a\u00020\u00022\u0006\u0010\u0018\u001a\u00020\u0019H\u0002J\u001c\u0010!\u001a\u00020\u000e*\u00020\u00032\u0006\u0010\u0012\u001a\u00020\u00022\u0006\u0010\u0018\u001a\u00020\u0019H\u0002J\u001c\u0010\"\u001a\u00020\u000e*\u00020\u00032\u0006\u0010\u0012\u001a\u00020\u00022\u0006\u0010\u0018\u001a\u00020\u0019H\u0002J,\u0010#\u001a\u00020\u000e*\u00020\u00032\u0006\u0010\u0012\u001a\u00020\u00022\u0006\u0010\u0016\u001a\u00020\u00102\u0006\u0010$\u001a\u00020%2\u0006\u0010\u0013\u001a\u00020\u0014H\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006&"}, d2 = {"Lcom/yandex/div/core/view2/divs/DivSelectBinder;", "Lcom/yandex/div/core/view2/DivViewBinder;", "Lcom/yandex/div2/DivSelect;", "Lcom/yandex/div/core/view2/divs/widgets/DivSelectView;", "baseBinder", "Lcom/yandex/div/core/view2/divs/DivBaseBinder;", "typefaceResolver", "Lcom/yandex/div/core/view2/DivTypefaceResolver;", "variableBinder", "Lcom/yandex/div/core/expression/variables/TwoWayStringVariableBinder;", "errorCollectors", "Lcom/yandex/div/core/view2/errors/ErrorCollectors;", "(Lcom/yandex/div/core/view2/divs/DivBaseBinder;Lcom/yandex/div/core/view2/DivTypefaceResolver;Lcom/yandex/div/core/expression/variables/TwoWayStringVariableBinder;Lcom/yandex/div/core/view2/errors/ErrorCollectors;)V", "bindView", "", "context", "Lcom/yandex/div/core/view2/BindingContext;", "view", "div", "path", "Lcom/yandex/div/core/state/DivStatePath;", "applyOptions", "bindingContext", "applyTypeface", "resolver", "Lcom/yandex/div/json/expressions/ExpressionResolver;", "createObservedItemList", "", "", "observeFontSize", "observeHintColor", "observeHintText", "observeLineHeight", "observeTextColor", "observeTypeface", "observeVariable", "errorCollector", "Lcom/yandex/div/core/view2/errors/ErrorCollector;", "div_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
@DivScope
public final class DivSelectBinder implements DivViewBinder<DivSelect, DivSelectView> {
    private final DivBaseBinder baseBinder;
    private final ErrorCollectors errorCollectors;
    private final DivTypefaceResolver typefaceResolver;
    private final TwoWayStringVariableBinder variableBinder;

    @Inject
    public DivSelectBinder(DivBaseBinder baseBinder, DivTypefaceResolver typefaceResolver, TwoWayStringVariableBinder variableBinder, ErrorCollectors errorCollectors) {
        Intrinsics.checkNotNullParameter(baseBinder, "baseBinder");
        Intrinsics.checkNotNullParameter(typefaceResolver, "typefaceResolver");
        Intrinsics.checkNotNullParameter(variableBinder, "variableBinder");
        Intrinsics.checkNotNullParameter(errorCollectors, "errorCollectors");
        this.baseBinder = baseBinder;
        this.typefaceResolver = typefaceResolver;
        this.variableBinder = variableBinder;
        this.errorCollectors = errorCollectors;
    }

    @Override // com.yandex.div.core.view2.DivViewBinder
    public void bindView(BindingContext context, DivSelectView view, DivSelect div, DivStatePath path) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(div, "div");
        Intrinsics.checkNotNullParameter(path, "path");
        DivSelect div2 = view.getDiv();
        if (div == div2) {
            return;
        }
        Div2View divView = context.getDivView();
        ExpressionResolver expressionResolver = context.getExpressionResolver();
        ErrorCollector orCreate = this.errorCollectors.getOrCreate(divView.getDataTag(), divView.getDivData());
        this.baseBinder.bindView(context, view, div, div2);
        view.setTextAlignment(5);
        view.setFocusTracker(context.getDivView().getInputFocusTracker());
        applyOptions(view, div, context);
        observeVariable(view, div, context, orCreate, path);
        observeFontSize(view, div, expressionResolver);
        observeTypeface(view, div, expressionResolver);
        observeTextColor(view, div, expressionResolver);
        observeLineHeight(view, div, expressionResolver);
        observeHintText(view, div, expressionResolver);
        observeHintColor(view, div, expressionResolver);
    }

    private final void applyOptions(final DivSelectView divSelectView, final DivSelect divSelect, final BindingContext bindingContext) {
        BaseDivViewExtensionsKt.setAnimatedTouchListener(divSelectView, bindingContext, UtilsKt.getDEFAULT_CLICK_ANIMATION(), null);
        final List<String> listCreateObservedItemList = createObservedItemList(divSelectView, divSelect, bindingContext.getExpressionResolver());
        divSelectView.setItems(listCreateObservedItemList);
        divSelectView.setOnItemSelectedListener(new Function1<Integer, Unit>() { // from class: com.yandex.div.core.view2.divs.DivSelectBinder.applyOptions.1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Integer num) {
                invoke(num.intValue());
                return Unit.INSTANCE;
            }

            public final void invoke(int i) {
                divSelectView.setText(listCreateObservedItemList.get(i));
                Function1<String, Unit> valueUpdater = divSelectView.getValueUpdater();
                if (valueUpdater != null) {
                    valueUpdater.invoke(divSelect.options.get(i).value.evaluate(bindingContext.getExpressionResolver()));
                }
            }
        });
    }

    private final List<String> createObservedItemList(final DivSelectView divSelectView, DivSelect divSelect, ExpressionResolver expressionResolver) {
        final ArrayList arrayList = new ArrayList();
        final int i = 0;
        for (Object obj : divSelect.options) {
            int i2 = i + 1;
            if (i < 0) {
                CollectionsKt.throwIndexOverflow();
            }
            DivSelect.Option option = (DivSelect.Option) obj;
            Expression<String> expression = option.text;
            if (expression == null) {
                expression = option.value;
            }
            arrayList.add(expression.evaluate(expressionResolver));
            expression.observe(expressionResolver, new Function1<String, Unit>() { // from class: com.yandex.div.core.view2.divs.DivSelectBinder$createObservedItemList$1$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(String str) {
                    invoke2(str);
                    return Unit.INSTANCE;
                }

                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(String it) {
                    Intrinsics.checkNotNullParameter(it, "it");
                    arrayList.set(i, it);
                    divSelectView.setItems(arrayList);
                }
            });
            i = i2;
        }
        return arrayList;
    }

    private final void observeVariable(final DivSelectView divSelectView, final DivSelect divSelect, BindingContext bindingContext, final ErrorCollector errorCollector, DivStatePath divStatePath) {
        final ExpressionResolver expressionResolver = bindingContext.getExpressionResolver();
        divSelectView.addSubscription(this.variableBinder.bindVariable(bindingContext, divSelect.valueVariable, new TwoWayStringVariableBinder.Callbacks() { // from class: com.yandex.div.core.view2.divs.DivSelectBinder$observeVariable$subscription$1
            @Override // com.yandex.div.core.expression.variables.TwoWayVariableBinder.Callbacks
            public void onVariableChanged(final String value) {
                String strEvaluate;
                Sequence sequenceAsSequence = CollectionsKt.asSequence(divSelect.options);
                final ExpressionResolver expressionResolver2 = expressionResolver;
                Iterator it = SequencesKt.filter(sequenceAsSequence, new Function1<DivSelect.Option, Boolean>() { // from class: com.yandex.div.core.view2.divs.DivSelectBinder$observeVariable$subscription$1$onVariableChanged$matchingOptionsSequence$1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final Boolean invoke(DivSelect.Option it2) {
                        Intrinsics.checkNotNullParameter(it2, "it");
                        return Boolean.valueOf(Intrinsics.areEqual(it2.value.evaluate(expressionResolver2), value));
                    }
                }).iterator();
                DivSelectView divSelectView2 = divSelectView;
                if (!it.hasNext()) {
                    errorCollector.logWarning(new Throwable("No option found with value = \"" + value + '\"'));
                } else {
                    DivSelect.Option option = (DivSelect.Option) it.next();
                    if (it.hasNext()) {
                        errorCollector.logWarning(new Throwable("Multiple options found with value = \"" + value + "\", selecting first one"));
                    }
                    Expression<String> expression = option.text;
                    if (expression == null) {
                        expression = option.value;
                    }
                    strEvaluate = expression.evaluate(expressionResolver);
                }
                divSelectView2.setText(strEvaluate);
            }

            @Override // com.yandex.div.core.expression.variables.TwoWayVariableBinder.Callbacks
            public void setViewStateChangeListener(Function1<? super String, Unit> valueUpdater) {
                Intrinsics.checkNotNullParameter(valueUpdater, "valueUpdater");
                divSelectView.setValueUpdater(valueUpdater);
            }
        }, divStatePath));
    }

    private final void observeFontSize(final DivSelectView divSelectView, final DivSelect divSelect, final ExpressionResolver expressionResolver) {
        Function1<? super Long, Unit> function1 = new Function1<Object, Unit>() { // from class: com.yandex.div.core.view2.divs.DivSelectBinder$observeFontSize$callback$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Object obj) {
                invoke2(obj);
                return Unit.INSTANCE;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Object obj) {
                int i;
                Intrinsics.checkNotNullParameter(obj, "<anonymous parameter 0>");
                long jLongValue = divSelect.fontSize.evaluate(expressionResolver).longValue();
                long j = jLongValue >> 31;
                if (j == 0 || j == -1) {
                    i = (int) jLongValue;
                } else {
                    KAssert kAssert = KAssert.INSTANCE;
                    if (Assert.isEnabled()) {
                        Assert.fail("Unable convert '" + jLongValue + "' to Int");
                    }
                    i = jLongValue > 0 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
                }
                BaseDivViewExtensionsKt.applyFontSize(divSelectView, i, divSelect.fontSizeUnit.evaluate(expressionResolver));
                BaseDivViewExtensionsKt.applyLetterSpacing(divSelectView, divSelect.letterSpacing.evaluate(expressionResolver).doubleValue(), i);
            }
        };
        divSelectView.addSubscription(divSelect.fontSize.observeAndGet(expressionResolver, function1));
        divSelectView.addSubscription(divSelect.letterSpacing.observe(expressionResolver, function1));
        divSelectView.addSubscription(divSelect.fontSizeUnit.observe(expressionResolver, function1));
    }

    private final void observeTypeface(final DivSelectView divSelectView, final DivSelect divSelect, final ExpressionResolver expressionResolver) {
        Disposable disposableObserveAndGet;
        applyTypeface(divSelectView, divSelect, expressionResolver);
        Function1<? super String, Unit> function1 = new Function1<Object, Unit>() { // from class: com.yandex.div.core.view2.divs.DivSelectBinder$observeTypeface$callback$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Object obj) {
                invoke2(obj);
                return Unit.INSTANCE;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Object obj) {
                Intrinsics.checkNotNullParameter(obj, "<anonymous parameter 0>");
                this.this$0.applyTypeface(divSelectView, divSelect, expressionResolver);
            }
        };
        Expression<String> expression = divSelect.fontFamily;
        if (expression != null && (disposableObserveAndGet = expression.observeAndGet(expressionResolver, function1)) != null) {
            divSelectView.addSubscription(disposableObserveAndGet);
        }
        divSelectView.addSubscription(divSelect.fontWeight.observe(expressionResolver, function1));
        Expression<Long> expression2 = divSelect.fontWeightValue;
        divSelectView.addSubscription(expression2 != null ? expression2.observe(expressionResolver, function1) : null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void applyTypeface(DivSelectView divSelectView, DivSelect divSelect, ExpressionResolver expressionResolver) {
        DivTypefaceResolver divTypefaceResolver = this.typefaceResolver;
        Expression<String> expression = divSelect.fontFamily;
        String strEvaluate = expression != null ? expression.evaluate(expressionResolver) : null;
        DivFontWeight divFontWeightEvaluate = divSelect.fontWeight.evaluate(expressionResolver);
        Expression<Long> expression2 = divSelect.fontWeightValue;
        divSelectView.setTypeface(DivTypefaceResolverKt.getTypeface(divTypefaceResolver, strEvaluate, divFontWeightEvaluate, expression2 != null ? expression2.evaluate(expressionResolver) : null));
    }

    private final void observeTextColor(final DivSelectView divSelectView, DivSelect divSelect, ExpressionResolver expressionResolver) {
        divSelectView.addSubscription(divSelect.textColor.observeAndGet(expressionResolver, new Function1<Integer, Unit>() { // from class: com.yandex.div.core.view2.divs.DivSelectBinder.observeTextColor.1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Integer num) {
                invoke(num.intValue());
                return Unit.INSTANCE;
            }

            public final void invoke(int i) {
                divSelectView.setTextColor(i);
            }
        }));
    }

    private final void observeLineHeight(final DivSelectView divSelectView, final DivSelect divSelect, final ExpressionResolver expressionResolver) {
        final Expression<Long> expression = divSelect.lineHeight;
        if (expression == null) {
            BaseDivViewExtensionsKt.applyLineHeight(divSelectView, null, divSelect.fontSizeUnit.evaluate(expressionResolver));
            return;
        }
        Function1<? super Long, Unit> function1 = new Function1<Object, Unit>() { // from class: com.yandex.div.core.view2.divs.DivSelectBinder$observeLineHeight$callback$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Object obj) {
                invoke2(obj);
                return Unit.INSTANCE;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Object obj) {
                Intrinsics.checkNotNullParameter(obj, "<anonymous parameter 0>");
                long jLongValue = expression.evaluate(expressionResolver).longValue();
                DivSizeUnit divSizeUnitEvaluate = divSelect.fontSizeUnit.evaluate(expressionResolver);
                DivSelectView divSelectView2 = divSelectView;
                Long lValueOf = Long.valueOf(jLongValue);
                DisplayMetrics displayMetrics = divSelectView.getResources().getDisplayMetrics();
                Intrinsics.checkNotNullExpressionValue(displayMetrics, "resources.displayMetrics");
                divSelectView2.setLineHeight(BaseDivViewExtensionsKt.unitToPx(lValueOf, displayMetrics, divSizeUnitEvaluate));
                BaseDivViewExtensionsKt.applyLineHeight(divSelectView, Long.valueOf(jLongValue), divSizeUnitEvaluate);
            }
        };
        divSelectView.addSubscription(expression.observeAndGet(expressionResolver, function1));
        divSelectView.addSubscription(divSelect.fontSizeUnit.observe(expressionResolver, function1));
    }

    private final void observeHintText(final DivSelectView divSelectView, DivSelect divSelect, ExpressionResolver expressionResolver) {
        Expression<String> expression = divSelect.hintText;
        if (expression == null) {
            return;
        }
        divSelectView.addSubscription(expression.observeAndGet(expressionResolver, new Function1<String, Unit>() { // from class: com.yandex.div.core.view2.divs.DivSelectBinder.observeHintText.1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(String str) {
                invoke2(str);
                return Unit.INSTANCE;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(String hint) {
                Intrinsics.checkNotNullParameter(hint, "hint");
                divSelectView.setHint(hint);
            }
        }));
    }

    private final void observeHintColor(final DivSelectView divSelectView, DivSelect divSelect, ExpressionResolver expressionResolver) {
        divSelectView.addSubscription(divSelect.hintColor.observeAndGet(expressionResolver, new Function1<Integer, Unit>() { // from class: com.yandex.div.core.view2.divs.DivSelectBinder.observeHintColor.1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Integer num) {
                invoke(num.intValue());
                return Unit.INSTANCE;
            }

            public final void invoke(int i) {
                divSelectView.setHintTextColor(i);
            }
        }));
    }
}
