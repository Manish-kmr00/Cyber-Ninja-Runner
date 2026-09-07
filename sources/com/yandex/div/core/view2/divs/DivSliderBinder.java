package com.yandex.div.core.view2.divs;

import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.util.DisplayMetrics;
import androidx.core.view.OneShotPreDrawListener;
import com.yandex.div.core.Div2Logger;
import com.yandex.div.core.dagger.ExperimentFlag;
import com.yandex.div.core.experiments.Experiment;
import com.yandex.div.core.expression.variables.TwoWayIntegerVariableBinder;
import com.yandex.div.core.font.DivTypefaceProvider;
import com.yandex.div.core.state.DivStatePath;
import com.yandex.div.core.util.ExpressionSubscribersKt;
import com.yandex.div.core.view2.BindingContext;
import com.yandex.div.core.view2.Div2View;
import com.yandex.div.core.view2.DivViewBinder;
import com.yandex.div.core.view2.divs.widgets.DivSliderView;
import com.yandex.div.core.view2.errors.ErrorCollector;
import com.yandex.div.core.view2.errors.ErrorCollectors;
import com.yandex.div.internal.Assert;
import com.yandex.div.internal.KAssert;
import com.yandex.div.internal.widget.slider.SliderTextStyle;
import com.yandex.div.internal.widget.slider.SliderView;
import com.yandex.div.internal.widget.slider.shapes.TextDrawable;
import com.yandex.div.json.expressions.Expression;
import com.yandex.div.json.expressions.ExpressionResolver;
import com.yandex.div2.DivDimension;
import com.yandex.div2.DivDrawable;
import com.yandex.div2.DivEdgeInsets;
import com.yandex.div2.DivFontWeight;
import com.yandex.div2.DivPoint;
import com.yandex.div2.DivSizeUnit;
import com.yandex.div2.DivSlider;
import io.bidmachine.iab.vast.tags.VastAttributes;
import java.util.Iterator;
import java.util.List;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;

/* JADX INFO: compiled from: DivSliderBinder.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000|\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0010\u000e\n\u0002\b\u000f\b\u0000\u0018\u0000 B2\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0001BBA\b\u0007\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\u0006\u0010\f\u001a\u00020\r\u0012\u0006\u0010\u000e\u001a\u00020\u000f\u0012\b\b\u0001\u0010\u0010\u001a\u00020\u0011¢\u0006\u0002\u0010\u0012J(\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u00032\u0006\u0010\u001a\u001a\u00020\u00022\u0006\u0010\u001b\u001a\u00020\u001cH\u0016J\u001c\u0010\u001d\u001a\u00020\u0016*\u00020\u001e2\u0006\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020\"H\u0002J\u001e\u0010#\u001a\u00020\u0016*\u00020\u001e2\u0006\u0010\u001f\u001a\u00020 2\b\u0010$\u001a\u0004\u0018\u00010%H\u0002J\u001c\u0010&\u001a\u00020\u0016*\u00020\u001e2\u0006\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020\"H\u0002J\u001e\u0010'\u001a\u00020\u0016*\u00020\u001e2\u0006\u0010\u001f\u001a\u00020 2\b\u0010$\u001a\u0004\u0018\u00010%H\u0002J\u001e\u0010(\u001a\u00020\u0016*\u00020\u00032\u0006\u0010\u001f\u001a\u00020 2\b\u0010)\u001a\u0004\u0018\u00010\"H\u0002J\u001e\u0010*\u001a\u00020\u0016*\u00020\u00032\u0006\u0010\u001f\u001a\u00020 2\b\u0010)\u001a\u0004\u0018\u00010\"H\u0002J\u001c\u0010+\u001a\u00020\u0016*\u00020\u001e2\u0006\u0010\u001f\u001a\u00020 2\u0006\u0010,\u001a\u00020\"H\u0002J\u001c\u0010-\u001a\u00020\u0016*\u00020\u001e2\u0006\u0010\u001f\u001a\u00020 2\u0006\u0010,\u001a\u00020\"H\u0002J\f\u0010.\u001a\u00020\u0016*\u00020\u0003H\u0002J\u001e\u0010/\u001a\u00020\u0016*\u00020\u00032\u0006\u0010\u001f\u001a\u00020 2\b\u0010!\u001a\u0004\u0018\u00010\"H\u0002J\u001e\u00100\u001a\u00020\u0016*\u00020\u00032\u0006\u0010\u001f\u001a\u00020 2\b\u00101\u001a\u0004\u0018\u00010%H\u0002J$\u00102\u001a\u00020\u0016*\u00020\u00032\u0006\u00103\u001a\u0002042\u0006\u00105\u001a\u00020\u00182\u0006\u0010\u001b\u001a\u00020\u001cH\u0002J\u001c\u00106\u001a\u00020\u0016*\u00020\u00032\u0006\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020\"H\u0002J\u001e\u00107\u001a\u00020\u0016*\u00020\u00032\u0006\u0010\u001f\u001a\u00020 2\b\u00101\u001a\u0004\u0018\u00010%H\u0002J$\u00108\u001a\u00020\u0016*\u00020\u00032\u0006\u0010\u001a\u001a\u00020\u00022\u0006\u00105\u001a\u00020\u00182\u0006\u0010\u001b\u001a\u00020\u001cH\u0002J\u001e\u00109\u001a\u00020\u0016*\u00020\u00032\u0006\u0010\u001f\u001a\u00020 2\b\u0010)\u001a\u0004\u0018\u00010\"H\u0002J\u001e\u0010:\u001a\u00020\u0016*\u00020\u00032\u0006\u0010\u001f\u001a\u00020 2\b\u0010)\u001a\u0004\u0018\u00010\"H\u0002J\u001c\u0010;\u001a\u00020\u0016*\u00020\u00032\u0006\u0010\u001f\u001a\u00020 2\u0006\u0010,\u001a\u00020\"H\u0002J\u001c\u0010<\u001a\u00020\u0016*\u00020\u00032\u0006\u0010\u001f\u001a\u00020 2\u0006\u0010,\u001a\u00020\"H\u0002J\u001c\u0010=\u001a\u00020\u0016*\u00020\u00032\u0006\u0010\u001a\u001a\u00020\u00022\u0006\u0010\u001f\u001a\u00020 H\u0002J$\u0010>\u001a\u00020\u0016*\u00020\u00032\u0006\u0010\u001a\u001a\u00020\u00022\u0006\u00105\u001a\u00020\u00182\u0006\u0010\u001b\u001a\u00020\u001cH\u0002J$\u0010?\u001a\u00020\u0016*\u00020\u00032\u0006\u0010\u001a\u001a\u00020\u00022\u0006\u00105\u001a\u00020\u00182\u0006\u0010\u001b\u001a\u00020\u001cH\u0002J\u001c\u0010@\u001a\u00020\u0016*\u00020\u00032\u0006\u0010\u001a\u001a\u00020\u00022\u0006\u0010\u001f\u001a\u00020 H\u0002J\u001c\u0010A\u001a\u00020\u0016*\u00020\u00032\u0006\u0010\u001a\u001a\u00020\u00022\u0006\u0010\u001f\u001a\u00020 H\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0013\u001a\u0004\u0018\u00010\u0014X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006C"}, d2 = {"Lcom/yandex/div/core/view2/divs/DivSliderBinder;", "Lcom/yandex/div/core/view2/DivViewBinder;", "Lcom/yandex/div2/DivSlider;", "Lcom/yandex/div/core/view2/divs/widgets/DivSliderView;", "baseBinder", "Lcom/yandex/div/core/view2/divs/DivBaseBinder;", "logger", "Lcom/yandex/div/core/Div2Logger;", "typefaceProvider", "Lcom/yandex/div/core/font/DivTypefaceProvider;", "variableBinder", "Lcom/yandex/div/core/expression/variables/TwoWayIntegerVariableBinder;", "errorCollectors", "Lcom/yandex/div/core/view2/errors/ErrorCollectors;", "horizontalInterceptionAngle", "", "visualErrorsEnabled", "", "(Lcom/yandex/div/core/view2/divs/DivBaseBinder;Lcom/yandex/div/core/Div2Logger;Lcom/yandex/div/core/font/DivTypefaceProvider;Lcom/yandex/div/core/expression/variables/TwoWayIntegerVariableBinder;Lcom/yandex/div/core/view2/errors/ErrorCollectors;FZ)V", "errorCollector", "Lcom/yandex/div/core/view2/errors/ErrorCollector;", "bindView", "", "context", "Lcom/yandex/div/core/view2/BindingContext;", "view", "div", "path", "Lcom/yandex/div/core/state/DivStatePath;", "applyThumbSecondaryStyle", "Lcom/yandex/div/internal/widget/slider/SliderView;", "resolver", "Lcom/yandex/div/json/expressions/ExpressionResolver;", "thumbStyle", "Lcom/yandex/div2/DivDrawable;", "applyThumbSecondaryTextStyle", "textStyle", "Lcom/yandex/div2/DivSlider$TextStyle;", "applyThumbStyle", "applyThumbTextStyle", "applyTickMarkActiveStyle", "tickMarkStyle", "applyTickMarkInactiveStyle", "applyTrackActiveStyle", "trackStyle", "applyTrackInactiveStyle", "checkSliderTicks", "observeThumbSecondaryStyle", "observeThumbSecondaryTextStyle", "thumbTextStyle", "observeThumbSecondaryValue", "variableName", "", "bindingContext", "observeThumbStyle", "observeThumbTextStyle", "observeThumbValue", "observeTickMarkActiveStyle", "observeTickMarkInactiveStyle", "observeTrackActiveStyle", "observeTrackInactiveStyle", "setupRanges", "setupSecondaryThumb", "setupThumb", "setupTickMarks", "setupTrack", "Companion", "div_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class DivSliderBinder implements DivViewBinder<DivSlider, DivSliderView> {
    private static final Companion Companion = new Companion(null);
    private final DivBaseBinder baseBinder;
    private ErrorCollector errorCollector;
    private final ErrorCollectors errorCollectors;
    private final float horizontalInterceptionAngle;
    private final Div2Logger logger;
    private final DivTypefaceProvider typefaceProvider;
    private final TwoWayIntegerVariableBinder variableBinder;
    private final boolean visualErrorsEnabled;

    @Inject
    public DivSliderBinder(DivBaseBinder baseBinder, Div2Logger logger, DivTypefaceProvider typefaceProvider, TwoWayIntegerVariableBinder variableBinder, ErrorCollectors errorCollectors, float f, @ExperimentFlag(experiment = Experiment.VISUAL_ERRORS_ENABLED) boolean z) {
        Intrinsics.checkNotNullParameter(baseBinder, "baseBinder");
        Intrinsics.checkNotNullParameter(logger, "logger");
        Intrinsics.checkNotNullParameter(typefaceProvider, "typefaceProvider");
        Intrinsics.checkNotNullParameter(variableBinder, "variableBinder");
        Intrinsics.checkNotNullParameter(errorCollectors, "errorCollectors");
        this.baseBinder = baseBinder;
        this.logger = logger;
        this.typefaceProvider = typefaceProvider;
        this.variableBinder = variableBinder;
        this.errorCollectors = errorCollectors;
        this.horizontalInterceptionAngle = f;
        this.visualErrorsEnabled = z;
    }

    @Override // com.yandex.div.core.view2.DivViewBinder
    public void bindView(BindingContext context, final DivSliderView view, DivSlider div, DivStatePath path) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(div, "div");
        Intrinsics.checkNotNullParameter(path, "path");
        DivSlider div2 = view.getDiv();
        Div2View divView = context.getDivView();
        this.errorCollector = this.errorCollectors.getOrCreate(divView.getDataTag(), divView.getDivData());
        if (div == div2) {
            return;
        }
        ExpressionResolver expressionResolver = context.getExpressionResolver();
        this.baseBinder.bindView(context, view, div, div2);
        view.setInterceptionAngle(this.horizontalInterceptionAngle);
        view.addSubscription(div.minValue.observeAndGet(expressionResolver, new Function1<Long, Unit>() { // from class: com.yandex.div.core.view2.divs.DivSliderBinder.bindView.1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Long l) {
                invoke(l.longValue());
                return Unit.INSTANCE;
            }

            public final void invoke(long j) {
                view.setMinValue(j);
                this.checkSliderTicks(view);
            }
        }));
        view.addSubscription(div.maxValue.observeAndGet(expressionResolver, new Function1<Long, Unit>() { // from class: com.yandex.div.core.view2.divs.DivSliderBinder.bindView.2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Long l) {
                invoke(l.longValue());
                return Unit.INSTANCE;
            }

            public final void invoke(long j) {
                view.setMaxValue(j);
                this.checkSliderTicks(view);
            }
        }));
        view.addSubscription(div.isEnabled.observeAndGet(expressionResolver, new Function1<Boolean, Unit>() { // from class: com.yandex.div.core.view2.divs.DivSliderBinder.bindView.3
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
                invoke(bool.booleanValue());
                return Unit.INSTANCE;
            }

            public final void invoke(boolean z) {
                view.setInteractive(z);
            }
        }));
        view.clearOnThumbChangedListener();
        setupThumb(view, div, context, path);
        setupSecondaryThumb(view, div, context, path);
        setupTrack(view, div, expressionResolver);
        setupTickMarks(view, div, expressionResolver);
        setupRanges(view, div, expressionResolver);
    }

    private final void setupThumb(DivSliderView divSliderView, DivSlider divSlider, BindingContext bindingContext, DivStatePath divStatePath) {
        observeThumbValue(divSliderView, divSlider, bindingContext, divStatePath);
        observeThumbStyle(divSliderView, bindingContext.getExpressionResolver(), divSlider.thumbStyle);
        observeThumbTextStyle(divSliderView, bindingContext.getExpressionResolver(), divSlider.thumbTextStyle);
    }

    private final void observeThumbValue(final DivSliderView divSliderView, DivSlider divSlider, final BindingContext bindingContext, DivStatePath divStatePath) {
        String str = divSlider.thumbValueVariable;
        if (str == null) {
            return;
        }
        divSliderView.addSubscription(this.variableBinder.bindVariable(bindingContext, str, new TwoWayIntegerVariableBinder.Callbacks() { // from class: com.yandex.div.core.view2.divs.DivSliderBinder$observeThumbValue$callbacks$1
            @Override // com.yandex.div.core.expression.variables.TwoWayVariableBinder.Callbacks
            public void onVariableChanged(Long value) {
                divSliderView.setThumbValue(value != null ? value.longValue() : 0.0f, false);
            }

            @Override // com.yandex.div.core.expression.variables.TwoWayVariableBinder.Callbacks
            public void setViewStateChangeListener(final Function1<? super Long, Unit> valueUpdater) {
                Intrinsics.checkNotNullParameter(valueUpdater, "valueUpdater");
                DivSliderView divSliderView2 = divSliderView;
                final DivSliderBinder divSliderBinder = this;
                final BindingContext bindingContext2 = bindingContext;
                final DivSliderView divSliderView3 = divSliderView;
                divSliderView2.addOnThumbChangedListener(new SliderView.ChangedListener() { // from class: com.yandex.div.core.view2.divs.DivSliderBinder$observeThumbValue$callbacks$1$setViewStateChangeListener$1
                    @Override // com.yandex.div.internal.widget.slider.SliderView.ChangedListener
                    public void onThumbValueChanged(float value) {
                        divSliderBinder.logger.logSliderDrag(bindingContext2.getDivView(), divSliderView3, Float.valueOf(value));
                        valueUpdater.invoke(Long.valueOf(MathKt.roundToLong(value)));
                    }
                });
            }
        }, divStatePath));
    }

    private final void observeThumbStyle(final DivSliderView divSliderView, final ExpressionResolver expressionResolver, final DivDrawable divDrawable) {
        applyThumbStyle(divSliderView, expressionResolver, divDrawable);
        ExpressionSubscribersKt.observeDrawable(divSliderView, divDrawable, expressionResolver, new Function1<Object, Unit>() { // from class: com.yandex.div.core.view2.divs.DivSliderBinder.observeThumbStyle.1
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
            public final void invoke2(Object it) {
                Intrinsics.checkNotNullParameter(it, "it");
                DivSliderBinder.this.applyThumbStyle(divSliderView, expressionResolver, divDrawable);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void applyThumbStyle(SliderView sliderView, ExpressionResolver expressionResolver, DivDrawable divDrawable) {
        DisplayMetrics displayMetrics = sliderView.getResources().getDisplayMetrics();
        Intrinsics.checkNotNullExpressionValue(displayMetrics, "resources.displayMetrics");
        sliderView.setThumbDrawable(BaseDivViewExtensionsKt.toDrawable(divDrawable, displayMetrics, expressionResolver));
    }

    private final void observeThumbSecondaryStyle(final DivSliderView divSliderView, final ExpressionResolver expressionResolver, final DivDrawable divDrawable) {
        if (divDrawable == null) {
            return;
        }
        applyThumbSecondaryStyle(divSliderView, expressionResolver, divDrawable);
        ExpressionSubscribersKt.observeDrawable(divSliderView, divDrawable, expressionResolver, new Function1<Object, Unit>() { // from class: com.yandex.div.core.view2.divs.DivSliderBinder.observeThumbSecondaryStyle.1
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
            public final void invoke2(Object it) {
                Intrinsics.checkNotNullParameter(it, "it");
                DivSliderBinder.this.applyThumbSecondaryStyle(divSliderView, expressionResolver, divDrawable);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void applyThumbSecondaryStyle(SliderView sliderView, ExpressionResolver expressionResolver, DivDrawable divDrawable) {
        DisplayMetrics displayMetrics = sliderView.getResources().getDisplayMetrics();
        Intrinsics.checkNotNullExpressionValue(displayMetrics, "resources.displayMetrics");
        sliderView.setThumbSecondaryDrawable(BaseDivViewExtensionsKt.toDrawable(divDrawable, displayMetrics, expressionResolver));
    }

    private final void observeThumbTextStyle(final DivSliderView divSliderView, final ExpressionResolver expressionResolver, final DivSlider.TextStyle textStyle) {
        applyThumbTextStyle(divSliderView, expressionResolver, textStyle);
        if (textStyle == null) {
            return;
        }
        divSliderView.addSubscription(textStyle.textColor.observe(expressionResolver, new Function1<Integer, Unit>() { // from class: com.yandex.div.core.view2.divs.DivSliderBinder.observeThumbTextStyle.1
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
                DivSliderBinder.this.applyThumbTextStyle(divSliderView, expressionResolver, textStyle);
            }
        }));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void applyThumbTextStyle(SliderView sliderView, ExpressionResolver expressionResolver, DivSlider.TextStyle textStyle) {
        TextDrawable textDrawable;
        if (textStyle != null) {
            Companion companion = Companion;
            DisplayMetrics displayMetrics = sliderView.getResources().getDisplayMetrics();
            Intrinsics.checkNotNullExpressionValue(displayMetrics, "resources.displayMetrics");
            textDrawable = new TextDrawable(companion.toSliderTextStyle(textStyle, displayMetrics, this.typefaceProvider, expressionResolver));
        } else {
            textDrawable = null;
        }
        sliderView.setThumbTextDrawable(textDrawable);
    }

    private final void observeThumbSecondaryTextStyle(final DivSliderView divSliderView, final ExpressionResolver expressionResolver, final DivSlider.TextStyle textStyle) {
        applyThumbSecondaryTextStyle(divSliderView, expressionResolver, textStyle);
        if (textStyle == null) {
            return;
        }
        divSliderView.addSubscription(textStyle.textColor.observe(expressionResolver, new Function1<Integer, Unit>() { // from class: com.yandex.div.core.view2.divs.DivSliderBinder.observeThumbSecondaryTextStyle.1
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
                DivSliderBinder.this.applyThumbSecondaryTextStyle(divSliderView, expressionResolver, textStyle);
            }
        }));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void applyThumbSecondaryTextStyle(SliderView sliderView, ExpressionResolver expressionResolver, DivSlider.TextStyle textStyle) {
        TextDrawable textDrawable;
        if (textStyle != null) {
            Companion companion = Companion;
            DisplayMetrics displayMetrics = sliderView.getResources().getDisplayMetrics();
            Intrinsics.checkNotNullExpressionValue(displayMetrics, "resources.displayMetrics");
            textDrawable = new TextDrawable(companion.toSliderTextStyle(textStyle, displayMetrics, this.typefaceProvider, expressionResolver));
        } else {
            textDrawable = null;
        }
        sliderView.setThumbSecondTextDrawable(textDrawable);
    }

    private final void setupSecondaryThumb(DivSliderView divSliderView, DivSlider divSlider, BindingContext bindingContext, DivStatePath divStatePath) {
        String str = divSlider.thumbSecondaryValueVariable;
        Unit unit = null;
        if (str == null) {
            divSliderView.setThumbSecondaryDrawable(null);
            divSliderView.setThumbSecondaryValue(null, false);
            return;
        }
        ExpressionResolver expressionResolver = bindingContext.getExpressionResolver();
        observeThumbSecondaryValue(divSliderView, str, bindingContext, divStatePath);
        DivDrawable divDrawable = divSlider.thumbSecondaryStyle;
        if (divDrawable != null) {
            observeThumbSecondaryStyle(divSliderView, expressionResolver, divDrawable);
            unit = Unit.INSTANCE;
        }
        if (unit == null) {
            observeThumbSecondaryStyle(divSliderView, expressionResolver, divSlider.thumbStyle);
        }
        observeThumbSecondaryTextStyle(divSliderView, expressionResolver, divSlider.thumbSecondaryTextStyle);
    }

    private final void observeThumbSecondaryValue(final DivSliderView divSliderView, String str, final BindingContext bindingContext, DivStatePath divStatePath) {
        divSliderView.addSubscription(this.variableBinder.bindVariable(bindingContext, str, new TwoWayIntegerVariableBinder.Callbacks() { // from class: com.yandex.div.core.view2.divs.DivSliderBinder$observeThumbSecondaryValue$callbacks$1
            @Override // com.yandex.div.core.expression.variables.TwoWayVariableBinder.Callbacks
            public void onVariableChanged(Long value) {
                divSliderView.setThumbSecondaryValue(value != null ? Float.valueOf(value.longValue()) : null, false);
            }

            @Override // com.yandex.div.core.expression.variables.TwoWayVariableBinder.Callbacks
            public void setViewStateChangeListener(final Function1<? super Long, Unit> valueUpdater) {
                Intrinsics.checkNotNullParameter(valueUpdater, "valueUpdater");
                DivSliderView divSliderView2 = divSliderView;
                final DivSliderBinder divSliderBinder = this;
                final BindingContext bindingContext2 = bindingContext;
                final DivSliderView divSliderView3 = divSliderView;
                divSliderView2.addOnThumbChangedListener(new SliderView.ChangedListener() { // from class: com.yandex.div.core.view2.divs.DivSliderBinder$observeThumbSecondaryValue$callbacks$1$setViewStateChangeListener$1
                    @Override // com.yandex.div.internal.widget.slider.SliderView.ChangedListener
                    public void onThumbSecondaryValueChanged(Float value) {
                        divSliderBinder.logger.logSliderDrag(bindingContext2.getDivView(), divSliderView3, value);
                        valueUpdater.invoke(Long.valueOf(value != null ? MathKt.roundToLong(value.floatValue()) : 0L));
                    }
                });
            }
        }, divStatePath));
    }

    private final void setupTrack(DivSliderView divSliderView, DivSlider divSlider, ExpressionResolver expressionResolver) {
        observeTrackActiveStyle(divSliderView, expressionResolver, divSlider.trackActiveStyle);
        observeTrackInactiveStyle(divSliderView, expressionResolver, divSlider.trackInactiveStyle);
    }

    private final void observeTrackActiveStyle(final DivSliderView divSliderView, final ExpressionResolver expressionResolver, final DivDrawable divDrawable) {
        applyTrackActiveStyle(divSliderView, expressionResolver, divDrawable);
        ExpressionSubscribersKt.observeDrawable(divSliderView, divDrawable, expressionResolver, new Function1<Object, Unit>() { // from class: com.yandex.div.core.view2.divs.DivSliderBinder.observeTrackActiveStyle.1
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
            public final void invoke2(Object it) {
                Intrinsics.checkNotNullParameter(it, "it");
                DivSliderBinder.this.applyTrackActiveStyle(divSliderView, expressionResolver, divDrawable);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void applyTrackActiveStyle(SliderView sliderView, ExpressionResolver expressionResolver, DivDrawable divDrawable) {
        DisplayMetrics displayMetrics = sliderView.getResources().getDisplayMetrics();
        Intrinsics.checkNotNullExpressionValue(displayMetrics, "resources.displayMetrics");
        sliderView.setActiveTrackDrawable(BaseDivViewExtensionsKt.toDrawable(divDrawable, displayMetrics, expressionResolver));
    }

    private final void observeTrackInactiveStyle(final DivSliderView divSliderView, final ExpressionResolver expressionResolver, final DivDrawable divDrawable) {
        applyTrackInactiveStyle(divSliderView, expressionResolver, divDrawable);
        ExpressionSubscribersKt.observeDrawable(divSliderView, divDrawable, expressionResolver, new Function1<Object, Unit>() { // from class: com.yandex.div.core.view2.divs.DivSliderBinder.observeTrackInactiveStyle.1
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
            public final void invoke2(Object it) {
                Intrinsics.checkNotNullParameter(it, "it");
                DivSliderBinder.this.applyTrackInactiveStyle(divSliderView, expressionResolver, divDrawable);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void applyTrackInactiveStyle(SliderView sliderView, ExpressionResolver expressionResolver, DivDrawable divDrawable) {
        DisplayMetrics displayMetrics = sliderView.getResources().getDisplayMetrics();
        Intrinsics.checkNotNullExpressionValue(displayMetrics, "resources.displayMetrics");
        sliderView.setInactiveTrackDrawable(BaseDivViewExtensionsKt.toDrawable(divDrawable, displayMetrics, expressionResolver));
    }

    private final void setupTickMarks(DivSliderView divSliderView, DivSlider divSlider, ExpressionResolver expressionResolver) {
        observeTickMarkActiveStyle(divSliderView, expressionResolver, divSlider.tickMarkActiveStyle);
        observeTickMarkInactiveStyle(divSliderView, expressionResolver, divSlider.tickMarkInactiveStyle);
    }

    private final void observeTickMarkActiveStyle(final DivSliderView divSliderView, final ExpressionResolver expressionResolver, final DivDrawable divDrawable) {
        applyTickMarkActiveStyle(divSliderView, expressionResolver, divDrawable);
        ExpressionSubscribersKt.observeDrawable(divSliderView, divDrawable, expressionResolver, new Function1<Object, Unit>() { // from class: com.yandex.div.core.view2.divs.DivSliderBinder.observeTickMarkActiveStyle.1
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
            public final void invoke2(Object it) {
                Intrinsics.checkNotNullParameter(it, "it");
                DivSliderBinder.this.applyTickMarkActiveStyle(divSliderView, expressionResolver, divDrawable);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void applyTickMarkActiveStyle(DivSliderView divSliderView, ExpressionResolver expressionResolver, DivDrawable divDrawable) {
        Drawable drawable;
        if (divDrawable != null) {
            DisplayMetrics displayMetrics = divSliderView.getResources().getDisplayMetrics();
            Intrinsics.checkNotNullExpressionValue(displayMetrics, "resources.displayMetrics");
            drawable = BaseDivViewExtensionsKt.toDrawable(divDrawable, displayMetrics, expressionResolver);
        } else {
            drawable = null;
        }
        divSliderView.setActiveTickMarkDrawable(drawable);
        checkSliderTicks(divSliderView);
    }

    private final void observeTickMarkInactiveStyle(final DivSliderView divSliderView, final ExpressionResolver expressionResolver, final DivDrawable divDrawable) {
        applyTickMarkInactiveStyle(divSliderView, expressionResolver, divDrawable);
        ExpressionSubscribersKt.observeDrawable(divSliderView, divDrawable, expressionResolver, new Function1<Object, Unit>() { // from class: com.yandex.div.core.view2.divs.DivSliderBinder.observeTickMarkInactiveStyle.1
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
            public final void invoke2(Object it) {
                Intrinsics.checkNotNullParameter(it, "it");
                DivSliderBinder.this.applyTickMarkInactiveStyle(divSliderView, expressionResolver, divDrawable);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void applyTickMarkInactiveStyle(DivSliderView divSliderView, ExpressionResolver expressionResolver, DivDrawable divDrawable) {
        Drawable drawable;
        if (divDrawable != null) {
            DisplayMetrics displayMetrics = divSliderView.getResources().getDisplayMetrics();
            Intrinsics.checkNotNullExpressionValue(displayMetrics, "resources.displayMetrics");
            drawable = BaseDivViewExtensionsKt.toDrawable(divDrawable, displayMetrics, expressionResolver);
        } else {
            drawable = null;
        }
        divSliderView.setInactiveTickMarkDrawable(drawable);
        checkSliderTicks(divSliderView);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void checkSliderTicks(final DivSliderView divSliderView) {
        if (!this.visualErrorsEnabled || this.errorCollector == null) {
            return;
        }
        final DivSliderView divSliderView2 = divSliderView;
        OneShotPreDrawListener.add(divSliderView2, new Runnable() { // from class: com.yandex.div.core.view2.divs.DivSliderBinder$checkSliderTicks$$inlined$doOnPreDraw$1
            @Override // java.lang.Runnable
            public final void run() {
                ErrorCollector errorCollector;
                if (divSliderView.getActiveTickMarkDrawable() == null && divSliderView.getInactiveTickMarkDrawable() == null) {
                    return;
                }
                float maxValue = divSliderView.getMaxValue() - divSliderView.getMinValue();
                Drawable activeTickMarkDrawable = divSliderView.getActiveTickMarkDrawable();
                boolean z = false;
                int intrinsicWidth = activeTickMarkDrawable != null ? activeTickMarkDrawable.getIntrinsicWidth() : 0;
                Drawable inactiveTickMarkDrawable = divSliderView.getInactiveTickMarkDrawable();
                if (Math.max(intrinsicWidth, inactiveTickMarkDrawable != null ? inactiveTickMarkDrawable.getIntrinsicWidth() : 0) * maxValue <= divSliderView.getWidth() || this.errorCollector == null) {
                    return;
                }
                ErrorCollector errorCollector2 = this.errorCollector;
                Intrinsics.checkNotNull(errorCollector2);
                Iterator<Throwable> warnings = errorCollector2.getWarnings();
                while (warnings.hasNext()) {
                    if (Intrinsics.areEqual(warnings.next().getMessage(), "Slider ticks overlap each other.")) {
                        z = true;
                    }
                }
                if (z || (errorCollector = this.errorCollector) == null) {
                    return;
                }
                errorCollector.logWarning(new Throwable("Slider ticks overlap each other."));
            }
        });
    }

    private final void setupRanges(final DivSliderView divSliderView, DivSlider divSlider, final ExpressionResolver expressionResolver) {
        divSliderView.getRanges().clear();
        List<DivSlider.Range> list = divSlider.ranges;
        if (list == null) {
            return;
        }
        final DisplayMetrics displayMetrics = divSliderView.getResources().getDisplayMetrics();
        for (DivSlider.Range range : list) {
            final SliderView.Range range2 = new SliderView.Range();
            divSliderView.getRanges().add(range2);
            Expression<Long> expression = range.start;
            if (expression == null) {
                expression = divSlider.minValue;
            }
            divSliderView.addSubscription(expression.observeAndGet(expressionResolver, new Function1<Long, Unit>() { // from class: com.yandex.div.core.view2.divs.DivSliderBinder$setupRanges$1$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(Long l) {
                    invoke(l.longValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(long j) {
                    DivSliderBinder.Companion unused = DivSliderBinder.Companion;
                    DivSliderView divSliderView2 = divSliderView;
                    range2.setStartValue(j);
                    divSliderView2.requestLayout();
                    divSliderView2.invalidate();
                }
            }));
            Expression<Long> expression2 = range.end;
            if (expression2 == null) {
                expression2 = divSlider.maxValue;
            }
            divSliderView.addSubscription(expression2.observeAndGet(expressionResolver, new Function1<Long, Unit>() { // from class: com.yandex.div.core.view2.divs.DivSliderBinder$setupRanges$1$2
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(Long l) {
                    invoke(l.longValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(long j) {
                    DivSliderBinder.Companion unused = DivSliderBinder.Companion;
                    DivSliderView divSliderView2 = divSliderView;
                    range2.setEndValue(j);
                    divSliderView2.requestLayout();
                    divSliderView2.invalidate();
                }
            }));
            final DivEdgeInsets divEdgeInsets = range.margins;
            if (divEdgeInsets == null) {
                range2.setMarginStart(0);
                range2.setMarginEnd(0);
            } else {
                boolean z = (divEdgeInsets.start == null && divEdgeInsets.end == null) ? false : true;
                final Expression<Long> expression3 = z ? divEdgeInsets.start : divEdgeInsets.left;
                final Expression<Long> expression4 = z ? divEdgeInsets.end : divEdgeInsets.right;
                if (expression3 != null) {
                    divSliderView.addSubscription(expression3.observe(expressionResolver, new Function1<Long, Unit>() { // from class: com.yandex.div.core.view2.divs.DivSliderBinder$setupRanges$1$3$1$1
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(1);
                        }

                        @Override // kotlin.jvm.functions.Function1
                        public /* bridge */ /* synthetic */ Unit invoke(Long l) {
                            invoke(l.longValue());
                            return Unit.INSTANCE;
                        }

                        public final void invoke(long j) {
                            DivSliderBinder.Companion unused = DivSliderBinder.Companion;
                            DivSliderView divSliderView2 = divSliderView;
                            SliderView.Range range3 = range2;
                            DivEdgeInsets divEdgeInsets2 = divEdgeInsets;
                            ExpressionResolver expressionResolver2 = expressionResolver;
                            DisplayMetrics metrics = displayMetrics;
                            DivSliderBinder.Companion companion = DivSliderBinder.Companion;
                            Intrinsics.checkNotNullExpressionValue(metrics, "metrics");
                            range3.setMarginStart(companion.applyUnit(divEdgeInsets2, j, expressionResolver2, metrics));
                            divSliderView2.requestLayout();
                            divSliderView2.invalidate();
                        }
                    }));
                }
                if (expression4 != null) {
                    divSliderView.addSubscription(expression4.observe(expressionResolver, new Function1<Long, Unit>() { // from class: com.yandex.div.core.view2.divs.DivSliderBinder$setupRanges$1$3$2$1
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(1);
                        }

                        @Override // kotlin.jvm.functions.Function1
                        public /* bridge */ /* synthetic */ Unit invoke(Long l) {
                            invoke(l.longValue());
                            return Unit.INSTANCE;
                        }

                        public final void invoke(long j) {
                            DivSliderBinder.Companion unused = DivSliderBinder.Companion;
                            DivSliderView divSliderView2 = divSliderView;
                            SliderView.Range range3 = range2;
                            DivEdgeInsets divEdgeInsets2 = divEdgeInsets;
                            ExpressionResolver expressionResolver2 = expressionResolver;
                            DisplayMetrics metrics = displayMetrics;
                            DivSliderBinder.Companion companion = DivSliderBinder.Companion;
                            Intrinsics.checkNotNullExpressionValue(metrics, "metrics");
                            range3.setMarginEnd(companion.applyUnit(divEdgeInsets2, j, expressionResolver2, metrics));
                            divSliderView2.requestLayout();
                            divSliderView2.invalidate();
                        }
                    }));
                }
                divEdgeInsets.unit.observeAndGet(expressionResolver, new Function1<DivSizeUnit, Unit>() { // from class: com.yandex.div.core.view2.divs.DivSliderBinder$setupRanges$1$3$3
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(DivSizeUnit divSizeUnit) {
                        invoke2(divSizeUnit);
                        return Unit.INSTANCE;
                    }

                    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(DivSizeUnit unit) {
                        Intrinsics.checkNotNullParameter(unit, "unit");
                        DivSliderBinder.Companion unused = DivSliderBinder.Companion;
                        DivSliderView divSliderView2 = divSliderView;
                        Expression<Long> expression5 = expression3;
                        Expression<Long> expression6 = expression4;
                        SliderView.Range range3 = range2;
                        ExpressionResolver expressionResolver2 = expressionResolver;
                        DisplayMetrics metrics = displayMetrics;
                        if (expression5 != null) {
                            DivSliderBinder.Companion companion = DivSliderBinder.Companion;
                            long jLongValue = expression5.evaluate(expressionResolver2).longValue();
                            Intrinsics.checkNotNullExpressionValue(metrics, "metrics");
                            range3.setMarginStart(companion.castToUnit(jLongValue, unit, metrics));
                        }
                        if (expression6 != null) {
                            DivSliderBinder.Companion companion2 = DivSliderBinder.Companion;
                            long jLongValue2 = expression6.evaluate(expressionResolver2).longValue();
                            Intrinsics.checkNotNullExpressionValue(metrics, "metrics");
                            range3.setMarginEnd(companion2.castToUnit(jLongValue2, unit, metrics));
                        }
                        divSliderView2.requestLayout();
                        divSliderView2.invalidate();
                    }
                });
            }
            DivDrawable divDrawable = range.trackActiveStyle;
            if (divDrawable == null) {
                divDrawable = divSlider.trackActiveStyle;
            }
            final DivDrawable divDrawable2 = divDrawable;
            Function1<Object, Unit> function1 = new Function1<Object, Unit>() { // from class: com.yandex.div.core.view2.divs.DivSliderBinder$setupRanges$1$applyActiveTrackStyle$1
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
                    DivSliderBinder.Companion unused = DivSliderBinder.Companion;
                    DivSliderView divSliderView2 = divSliderView;
                    SliderView.Range range3 = range2;
                    DivDrawable divDrawable3 = divDrawable2;
                    DisplayMetrics metrics = displayMetrics;
                    ExpressionResolver expressionResolver2 = expressionResolver;
                    Intrinsics.checkNotNullExpressionValue(metrics, "metrics");
                    range3.setActiveTrackDrawable(BaseDivViewExtensionsKt.toDrawable(divDrawable3, metrics, expressionResolver2));
                    divSliderView2.requestLayout();
                    divSliderView2.invalidate();
                }
            };
            function1.invoke(Unit.INSTANCE);
            DivSliderView divSliderView2 = divSliderView;
            ExpressionSubscribersKt.observeDrawable(divSliderView2, divDrawable2, expressionResolver, function1);
            DivDrawable divDrawable3 = range.trackInactiveStyle;
            if (divDrawable3 == null) {
                divDrawable3 = divSlider.trackInactiveStyle;
            }
            final DivDrawable divDrawable4 = divDrawable3;
            Function1<Object, Unit> function2 = new Function1<Object, Unit>() { // from class: com.yandex.div.core.view2.divs.DivSliderBinder$setupRanges$1$applyInactiveTrackStyle$1
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
                    DivSliderBinder.Companion unused = DivSliderBinder.Companion;
                    DivSliderView divSliderView3 = divSliderView;
                    SliderView.Range range3 = range2;
                    DivDrawable divDrawable5 = divDrawable4;
                    DisplayMetrics metrics = displayMetrics;
                    ExpressionResolver expressionResolver2 = expressionResolver;
                    Intrinsics.checkNotNullExpressionValue(metrics, "metrics");
                    range3.setInactiveTrackDrawable(BaseDivViewExtensionsKt.toDrawable(divDrawable5, metrics, expressionResolver2));
                    divSliderView3.requestLayout();
                    divSliderView3.invalidate();
                }
            };
            function2.invoke(Unit.INSTANCE);
            ExpressionSubscribersKt.observeDrawable(divSliderView2, divDrawable4, expressionResolver, function2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: compiled from: DivSliderBinder.kt */
    @Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0082\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\"\u0010\u0003\u001a\u00020\u0004*\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bJ\u001a\u0010\f\u001a\u00020\u0004*\u00020\u00072\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\n\u001a\u00020\u000bJ\"\u0010\u000f\u001a\u00020\u0010*\u00020\u00112\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\b\u001a\u00020\tJ\u001e\u0010\u0014\u001a\u00020\u0015*\u00020\u00162\f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00150\u0018H\u0086\bø\u0001\u0000\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006\u0019"}, d2 = {"Lcom/yandex/div/core/view2/divs/DivSliderBinder$Companion;", "", "()V", "applyUnit", "", "Lcom/yandex/div2/DivEdgeInsets;", VastAttributes.MARGIN, "", "resolver", "Lcom/yandex/div/json/expressions/ExpressionResolver;", "metrics", "Landroid/util/DisplayMetrics;", "castToUnit", "unit", "Lcom/yandex/div2/DivSizeUnit;", "toSliderTextStyle", "Lcom/yandex/div/internal/widget/slider/SliderTextStyle;", "Lcom/yandex/div2/DivSlider$TextStyle;", "typefaceProvider", "Lcom/yandex/div/core/font/DivTypefaceProvider;", "updateAfter", "", "Lcom/yandex/div/internal/widget/slider/SliderView;", "block", "Lkotlin/Function0;", "div_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    static final class Companion {

        /* JADX INFO: compiled from: DivSliderBinder.kt */
        @Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
        public /* synthetic */ class WhenMappings {
            public static final /* synthetic */ int[] $EnumSwitchMapping$0;

            static {
                int[] iArr = new int[DivSizeUnit.values().length];
                try {
                    iArr[DivSizeUnit.DP.ordinal()] = 1;
                } catch (NoSuchFieldError unused) {
                }
                try {
                    iArr[DivSizeUnit.SP.ordinal()] = 2;
                } catch (NoSuchFieldError unused2) {
                }
                try {
                    iArr[DivSizeUnit.PX.ordinal()] = 3;
                } catch (NoSuchFieldError unused3) {
                }
                $EnumSwitchMapping$0 = iArr;
            }
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final SliderTextStyle toSliderTextStyle(DivSlider.TextStyle textStyle, DisplayMetrics metrics, DivTypefaceProvider typefaceProvider, ExpressionResolver resolver) {
            DivDimension divDimension;
            DivDimension divDimension2;
            Intrinsics.checkNotNullParameter(textStyle, "<this>");
            Intrinsics.checkNotNullParameter(metrics, "metrics");
            Intrinsics.checkNotNullParameter(typefaceProvider, "typefaceProvider");
            Intrinsics.checkNotNullParameter(resolver, "resolver");
            float fFontSizeToPx = BaseDivViewExtensionsKt.fontSizeToPx(textStyle.fontSize.evaluate(resolver).longValue(), textStyle.fontSizeUnit.evaluate(resolver), metrics);
            DivFontWeight divFontWeightEvaluate = textStyle.fontWeight.evaluate(resolver);
            Expression<Long> expression = textStyle.fontWeightValue;
            Typeface typeface = BaseDivViewExtensionsKt.getTypeface(BaseDivViewExtensionsKt.getTypefaceValue(divFontWeightEvaluate, expression != null ? expression.evaluate(resolver) : null), typefaceProvider);
            DivPoint divPoint = textStyle.offset;
            float px = (divPoint == null || (divDimension2 = divPoint.x) == null) ? 0.0f : BaseDivViewExtensionsKt.toPx(divDimension2, metrics, resolver);
            DivPoint divPoint2 = textStyle.offset;
            return new SliderTextStyle(fFontSizeToPx, typeface, px, (divPoint2 == null || (divDimension = divPoint2.y) == null) ? 0.0f : BaseDivViewExtensionsKt.toPx(divDimension, metrics, resolver), textStyle.textColor.evaluate(resolver).intValue());
        }

        public final void updateAfter(SliderView sliderView, Function0<Unit> block) {
            Intrinsics.checkNotNullParameter(sliderView, "<this>");
            Intrinsics.checkNotNullParameter(block, "block");
            block.invoke();
            sliderView.requestLayout();
            sliderView.invalidate();
        }

        public final int applyUnit(DivEdgeInsets divEdgeInsets, long j, ExpressionResolver resolver, DisplayMetrics metrics) {
            Intrinsics.checkNotNullParameter(divEdgeInsets, "<this>");
            Intrinsics.checkNotNullParameter(resolver, "resolver");
            Intrinsics.checkNotNullParameter(metrics, "metrics");
            return castToUnit(j, divEdgeInsets.unit.evaluate(resolver), metrics);
        }

        public final int castToUnit(long j, DivSizeUnit unit, DisplayMetrics metrics) {
            Intrinsics.checkNotNullParameter(unit, "unit");
            Intrinsics.checkNotNullParameter(metrics, "metrics");
            int i = WhenMappings.$EnumSwitchMapping$0[unit.ordinal()];
            if (i == 1) {
                return BaseDivViewExtensionsKt.dpToPx(Long.valueOf(j), metrics);
            }
            if (i == 2) {
                return BaseDivViewExtensionsKt.spToPx(Long.valueOf(j), metrics);
            }
            if (i != 3) {
                throw new NoWhenBranchMatchedException();
            }
            long j2 = j >> 31;
            if (j2 == 0 || j2 == -1) {
                return (int) j;
            }
            KAssert kAssert = KAssert.INSTANCE;
            if (Assert.isEnabled()) {
                Assert.fail("Unable convert '" + j + "' to Int");
            }
            return j > 0 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
        }
    }
}
