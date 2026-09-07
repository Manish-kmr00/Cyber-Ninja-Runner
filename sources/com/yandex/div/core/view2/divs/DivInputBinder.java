package com.yandex.div.core.view2.divs;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.Editable;
import android.text.InputFilter;
import android.text.TextWatcher;
import android.text.method.DigitsKeyListener;
import android.text.method.KeyListener;
import android.view.View;
import com.yandex.div.core.Disposable;
import com.yandex.div.core.actions.DivActionTypedUtilsKt;
import com.yandex.div.core.dagger.DivScope;
import com.yandex.div.core.expression.variables.TwoWayStringVariableBinder;
import com.yandex.div.core.state.DivStatePath;
import com.yandex.div.core.util.AccessibilityStateProvider;
import com.yandex.div.core.util.DivDataExtensionsKt;
import com.yandex.div.core.util.ReleasablesKt;
import com.yandex.div.core.util.mask.BaseInputMask;
import com.yandex.div.core.util.mask.CurrencyInputMask;
import com.yandex.div.core.util.mask.FixedLengthInputMask;
import com.yandex.div.core.util.mask.PhoneInputMask;
import com.yandex.div.core.util.mask.PhoneInputMaskKt;
import com.yandex.div.core.util.validator.ExpressionValidator;
import com.yandex.div.core.util.validator.RegexValidator;
import com.yandex.div.core.util.validator.ValidatorItemData;
import com.yandex.div.core.view2.BindingContext;
import com.yandex.div.core.view2.Div2View;
import com.yandex.div.core.view2.DivTypefaceResolver;
import com.yandex.div.core.view2.DivTypefaceResolverKt;
import com.yandex.div.core.view2.DivViewBinder;
import com.yandex.div.core.view2.DivViewIdProvider;
import com.yandex.div.core.view2.divs.widgets.DivInputView;
import com.yandex.div.core.view2.errors.ErrorCollector;
import com.yandex.div.core.view2.errors.ErrorCollectors;
import com.yandex.div.core.view2.reuse.InputFocusTracker;
import com.yandex.div.internal.Assert;
import com.yandex.div.internal.KAssert;
import com.yandex.div.internal.core.VariableMutationHandler;
import com.yandex.div.json.expressions.Expression;
import com.yandex.div.json.expressions.ExpressionResolver;
import com.yandex.div2.DivAlignmentHorizontal;
import com.yandex.div2.DivAlignmentVertical;
import com.yandex.div2.DivCurrencyInputMask;
import com.yandex.div2.DivFixedLengthInputMask;
import com.yandex.div2.DivFontWeight;
import com.yandex.div2.DivInput;
import com.yandex.div2.DivInputMask;
import com.yandex.div2.DivInputMaskBase;
import com.yandex.div2.DivInputValidator;
import com.yandex.div2.DivInputValidatorExpression;
import com.yandex.div2.DivInputValidatorRegex;
import com.yandex.div2.DivPhoneInputMask;
import com.yandex.div2.DivSizeUnit;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.regex.PatternSyntaxException;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.text.Regex;
import kotlin.text.StringsKt;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;

/* JADX INFO: compiled from: DivInputBinder.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000²\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0001\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B7\b\u0007\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\u0006\u0010\f\u001a\u00020\r\u0012\u0006\u0010\u000e\u001a\u00020\u000f¢\u0006\u0002\u0010\u0010J(\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00032\u0006\u0010\u0016\u001a\u00020\u00022\u0006\u0010\u0017\u001a\u00020\u0018H\u0016J\u0018\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u0016\u001a\u00020\u00022\u0006\u0010\u001b\u001a\u00020\u001cH\u0002J\u0010\u0010\u001d\u001a\u00020\u001a2\u0006\u0010\u001e\u001a\u00020\u001fH\u0002J\u0010\u0010 \u001a\u00020\u001a2\u0006\u0010\u001e\u001a\u00020!H\u0002J\u001c\u0010\"\u001a\u00020\u0012*\u00020\u00032\u0006\u0010\u0016\u001a\u00020\u00022\u0006\u0010\u001b\u001a\u00020\u001cH\u0002J&\u0010#\u001a\u00020\u0012*\u00020\u00032\u0006\u0010$\u001a\u00020\u00142\u0006\u0010%\u001a\u00020\u00022\b\u0010&\u001a\u0004\u0018\u00010\u0002H\u0002J\u001e\u0010'\u001a\u00020\u0012*\u00020\u00032\b\u0010(\u001a\u0004\u0018\u00010)2\u0006\u0010*\u001a\u00020+H\u0002J\u001c\u0010,\u001a\u00020\u0012*\u00020\u00032\u0006\u0010\u0016\u001a\u00020\u00022\u0006\u0010\u001b\u001a\u00020\u001cH\u0002J$\u0010-\u001a\u00020\u0012*\u00020.2\u0006\u0010/\u001a\u0002002\u0006\u0010\u0015\u001a\u00020\u00032\u0006\u00101\u001a\u000202H\u0002J.\u00103\u001a\u00020\u0012*\u00020\u00032\u0006\u0010$\u001a\u00020\u00142\u0006\u0010%\u001a\u00020\u00022\b\u0010&\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u001b\u001a\u00020\u001cH\u0002J$\u00104\u001a\u00020\u0012*\u00020\u00032\u0006\u0010\u0016\u001a\u00020\u00022\u0006\u0010$\u001a\u00020\u00142\u0006\u0010\u001b\u001a\u00020\u001cH\u0002J\u001c\u00105\u001a\u00020\u0012*\u00020\u00032\u0006\u0010\u0016\u001a\u00020\u00022\u0006\u0010\u001b\u001a\u00020\u001cH\u0002J\u001c\u00106\u001a\u00020\u0012*\u00020\u00032\u0006\u0010\u0016\u001a\u00020\u00022\u0006\u0010\u001b\u001a\u00020\u001cH\u0002J\u001c\u00107\u001a\u00020\u0012*\u00020\u00032\u0006\u0010\u0016\u001a\u00020\u00022\u0006\u0010\u001b\u001a\u00020\u001cH\u0002J\u001c\u00108\u001a\u00020\u0012*\u00020\u00032\u0006\u0010\u0016\u001a\u00020\u00022\u0006\u0010\u001b\u001a\u00020\u001cH\u0002J\u001c\u00109\u001a\u00020\u0012*\u00020\u00032\u0006\u0010\u0016\u001a\u00020\u00022\u0006\u0010\u001b\u001a\u00020\u001cH\u0002J\u001c\u0010:\u001a\u00020\u0012*\u00020\u00032\u0006\u0010\u0016\u001a\u00020\u00022\u0006\u0010\u001b\u001a\u00020\u001cH\u0002J\u001c\u0010;\u001a\u00020\u0012*\u00020\u00032\u0006\u0010\u0016\u001a\u00020\u00022\u0006\u0010\u001b\u001a\u00020\u001cH\u0002J:\u0010<\u001a\u00020\u0012*\u00020\u00032\u0006\u0010\u0016\u001a\u00020\u00022\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010/\u001a\u0002002\u0014\u0010=\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u00010?\u0012\u0004\u0012\u00020\u00120>H\u0002J\u001c\u0010@\u001a\u00020\u0012*\u00020\u00032\u0006\u0010\u0016\u001a\u00020\u00022\u0006\u0010\u001b\u001a\u00020\u001cH\u0002J\u001c\u0010A\u001a\u00020\u0012*\u00020\u00032\u0006\u0010\u0016\u001a\u00020\u00022\u0006\u0010\u001b\u001a\u00020\u001cH\u0002J\u001c\u0010B\u001a\u00020\u0012*\u00020\u00032\u0006\u0010\u0016\u001a\u00020\u00022\u0006\u0010\u001b\u001a\u00020\u001cH\u0002J$\u0010C\u001a\u00020\u0012*\u00020\u00032\u0006\u0010\u0016\u001a\u00020\u00022\u0006\u0010$\u001a\u00020\u00142\u0006\u0010\u0017\u001a\u00020\u0018H\u0002J0\u0010D\u001a\u00020\u0012*\u00020\u00032\f\u0010(\u001a\b\u0012\u0004\u0012\u00020)0E2\f\u0010*\u001a\b\u0012\u0004\u0012\u00020+0E2\u0006\u0010\u001b\u001a\u00020\u001cH\u0002J\u001c\u0010F\u001a\u00020\u0012*\u00020\u00032\u0006\u0010\u0016\u001a\u00020\u00022\u0006\u0010\u001b\u001a\u00020\u001cH\u0002J\u001c\u0010G\u001a\u00020\u0012*\u00020\u00032\u0006\u0010\u0016\u001a\u00020\u00022\u0006\u0010\u001b\u001a\u00020\u001cH\u0002J$\u0010H\u001a\u00020\u0012*\u00020\u00032\u0006\u0010\u0016\u001a\u00020\u00022\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010/\u001a\u000200H\u0002J\u001e\u0010I\u001a\u0004\u0018\u00010.*\u00020J2\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010K\u001a\u00020LH\u0002J,\u0010M\u001a\u00020\u0012*\u00020.2\u0006\u0010N\u001a\u00020O2\u0006\u0010\u0015\u001a\u00020\u00032\u0006\u0010/\u001a\u0002002\u0006\u0010\u001b\u001a\u00020\u001cH\u0002R\u000e\u0010\f\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006P"}, d2 = {"Lcom/yandex/div/core/view2/divs/DivInputBinder;", "Lcom/yandex/div/core/view2/DivViewBinder;", "Lcom/yandex/div2/DivInput;", "Lcom/yandex/div/core/view2/divs/widgets/DivInputView;", "baseBinder", "Lcom/yandex/div/core/view2/divs/DivBaseBinder;", "typefaceResolver", "Lcom/yandex/div/core/view2/DivTypefaceResolver;", "variableBinder", "Lcom/yandex/div/core/expression/variables/TwoWayStringVariableBinder;", "actionBinder", "Lcom/yandex/div/core/view2/divs/DivActionBinder;", "accessibilityStateProvider", "Lcom/yandex/div/core/util/AccessibilityStateProvider;", "errorCollectors", "Lcom/yandex/div/core/view2/errors/ErrorCollectors;", "(Lcom/yandex/div/core/view2/divs/DivBaseBinder;Lcom/yandex/div/core/view2/DivTypefaceResolver;Lcom/yandex/div/core/expression/variables/TwoWayStringVariableBinder;Lcom/yandex/div/core/view2/divs/DivActionBinder;Lcom/yandex/div/core/util/AccessibilityStateProvider;Lcom/yandex/div/core/view2/errors/ErrorCollectors;)V", "bindView", "", "context", "Lcom/yandex/div/core/view2/BindingContext;", "view", "div", "path", "Lcom/yandex/div/core/state/DivStatePath;", "getCapitalization", "", "resolver", "Lcom/yandex/div/json/expressions/ExpressionResolver;", "getImeAction", "type", "Lcom/yandex/div2/DivInput$EnterKeyType;", "getKeyboardType", "Lcom/yandex/div2/DivInput$KeyboardType;", "applyFontSize", "applyNativeBackgroundColor", "bindingContext", "newDiv", "oldDiv", "applyTextAlignment", "horizontalAlignment", "Lcom/yandex/div2/DivAlignmentHorizontal;", "verticalAlignment", "Lcom/yandex/div2/DivAlignmentVertical;", "applyTypeface", "attachAccessibility", "Lcom/yandex/div/core/util/validator/ValidatorItemData;", "divView", "Lcom/yandex/div/core/view2/Div2View;", "isValid", "", "observeBackground", "observeEnterTypeAndActions", "observeFontSize", "observeHighlightColor", "observeHintColor", "observeHintText", "observeIsEnabled", "observeKeyboardTypeAndCapitalization", "observeLineHeight", "observeMask", "onMaskUpdate", "Lkotlin/Function1;", "Lcom/yandex/div/core/util/mask/BaseInputMask;", "observeMaxLength", "observeMaxVisibleLines", "observeSelectAllOnFocus", "observeText", "observeTextAlignment", "Lcom/yandex/div/json/expressions/Expression;", "observeTextColor", "observeTypeface", "observeValidators", "toValidatorDataItem", "Lcom/yandex/div2/DivInputValidator;", "errorCollector", "Lcom/yandex/div/core/view2/errors/ErrorCollector;", "validate", "newValue", "", "div_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
@DivScope
public final class DivInputBinder implements DivViewBinder<DivInput, DivInputView> {
    private final AccessibilityStateProvider accessibilityStateProvider;
    private final DivActionBinder actionBinder;
    private final DivBaseBinder baseBinder;
    private final ErrorCollectors errorCollectors;
    private final DivTypefaceResolver typefaceResolver;
    private final TwoWayStringVariableBinder variableBinder;

    /* JADX INFO: compiled from: DivInputBinder.kt */
    @Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;
        public static final /* synthetic */ int[] $EnumSwitchMapping$1;
        public static final /* synthetic */ int[] $EnumSwitchMapping$2;
        public static final /* synthetic */ int[] $EnumSwitchMapping$3;

        static {
            int[] iArr = new int[DivAlignmentHorizontal.values().length];
            try {
                iArr[DivAlignmentHorizontal.LEFT.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[DivAlignmentHorizontal.CENTER.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[DivAlignmentHorizontal.RIGHT.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[DivAlignmentHorizontal.START.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                iArr[DivAlignmentHorizontal.END.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            $EnumSwitchMapping$0 = iArr;
            int[] iArr2 = new int[DivInput.KeyboardType.values().length];
            try {
                iArr2[DivInput.KeyboardType.SINGLE_LINE_TEXT.ordinal()] = 1;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                iArr2[DivInput.KeyboardType.MULTI_LINE_TEXT.ordinal()] = 2;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                iArr2[DivInput.KeyboardType.EMAIL.ordinal()] = 3;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                iArr2[DivInput.KeyboardType.URI.ordinal()] = 4;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                iArr2[DivInput.KeyboardType.NUMBER.ordinal()] = 5;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                iArr2[DivInput.KeyboardType.PHONE.ordinal()] = 6;
            } catch (NoSuchFieldError unused11) {
            }
            try {
                iArr2[DivInput.KeyboardType.PASSWORD.ordinal()] = 7;
            } catch (NoSuchFieldError unused12) {
            }
            $EnumSwitchMapping$1 = iArr2;
            int[] iArr3 = new int[DivInput.EnterKeyType.values().length];
            try {
                iArr3[DivInput.EnterKeyType.DEFAULT.ordinal()] = 1;
            } catch (NoSuchFieldError unused13) {
            }
            try {
                iArr3[DivInput.EnterKeyType.SEND.ordinal()] = 2;
            } catch (NoSuchFieldError unused14) {
            }
            try {
                iArr3[DivInput.EnterKeyType.DONE.ordinal()] = 3;
            } catch (NoSuchFieldError unused15) {
            }
            try {
                iArr3[DivInput.EnterKeyType.SEARCH.ordinal()] = 4;
            } catch (NoSuchFieldError unused16) {
            }
            try {
                iArr3[DivInput.EnterKeyType.GO.ordinal()] = 5;
            } catch (NoSuchFieldError unused17) {
            }
            $EnumSwitchMapping$2 = iArr3;
            int[] iArr4 = new int[DivInput.Autocapitalization.values().length];
            try {
                iArr4[DivInput.Autocapitalization.SENTENCES.ordinal()] = 1;
            } catch (NoSuchFieldError unused18) {
            }
            try {
                iArr4[DivInput.Autocapitalization.WORDS.ordinal()] = 2;
            } catch (NoSuchFieldError unused19) {
            }
            try {
                iArr4[DivInput.Autocapitalization.ALL_CHARACTERS.ordinal()] = 3;
            } catch (NoSuchFieldError unused20) {
            }
            $EnumSwitchMapping$3 = iArr4;
        }
    }

    @Inject
    public DivInputBinder(DivBaseBinder baseBinder, DivTypefaceResolver typefaceResolver, TwoWayStringVariableBinder variableBinder, DivActionBinder actionBinder, AccessibilityStateProvider accessibilityStateProvider, ErrorCollectors errorCollectors) {
        Intrinsics.checkNotNullParameter(baseBinder, "baseBinder");
        Intrinsics.checkNotNullParameter(typefaceResolver, "typefaceResolver");
        Intrinsics.checkNotNullParameter(variableBinder, "variableBinder");
        Intrinsics.checkNotNullParameter(actionBinder, "actionBinder");
        Intrinsics.checkNotNullParameter(accessibilityStateProvider, "accessibilityStateProvider");
        Intrinsics.checkNotNullParameter(errorCollectors, "errorCollectors");
        this.baseBinder = baseBinder;
        this.typefaceResolver = typefaceResolver;
        this.variableBinder = variableBinder;
        this.actionBinder = actionBinder;
        this.accessibilityStateProvider = accessibilityStateProvider;
        this.errorCollectors = errorCollectors;
    }

    @Override // com.yandex.div.core.view2.DivViewBinder
    public void bindView(BindingContext context, DivInputView view, DivInput div, DivStatePath path) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(div, "div");
        Intrinsics.checkNotNullParameter(path, "path");
        DivInput div2 = view.getDiv();
        if (div == div2) {
            return;
        }
        ExpressionResolver expressionResolver = context.getExpressionResolver();
        DivInputView divInputView = view;
        this.baseBinder.bindView(context, divInputView, div, div2);
        view.setFocusable(true);
        view.setFocusableInTouchMode(true);
        view.setTextAlignment(5);
        AccessibilityStateProvider accessibilityStateProvider = this.accessibilityStateProvider;
        Context context2 = view.getContext();
        Intrinsics.checkNotNullExpressionValue(context2, "view.context");
        view.setAccessibilityEnabled$div_release(accessibilityStateProvider.isAccessibilityEnabled(context2));
        observeBackground(view, context, div, div2, expressionResolver);
        observeFontSize(view, div, expressionResolver);
        observeTypeface(view, div, expressionResolver);
        observeTextColor(view, div, expressionResolver);
        observeTextAlignment(view, div.textAlignmentHorizontal, div.textAlignmentVertical, expressionResolver);
        observeLineHeight(view, div, expressionResolver);
        observeMaxVisibleLines(view, div, expressionResolver);
        observeMaxLength(view, div, expressionResolver);
        observeHintText(view, div, expressionResolver);
        observeHintColor(view, div, expressionResolver);
        observeHighlightColor(view, div, expressionResolver);
        observeKeyboardTypeAndCapitalization(view, div, expressionResolver);
        observeEnterTypeAndActions(view, div, context, expressionResolver);
        observeSelectAllOnFocus(view, div, expressionResolver);
        observeIsEnabled(view, div, expressionResolver);
        observeText(view, div, context, path);
        view.setFocusTracker$div_release(context.getDivView().getInputFocusTracker());
        InputFocusTracker focusTracker = view.getFocusTracker();
        if (focusTracker != null) {
            focusTracker.requestFocusIfNeeded(divInputView);
        }
    }

    private final void observeTextAlignment(final DivInputView divInputView, final Expression<DivAlignmentHorizontal> expression, final Expression<DivAlignmentVertical> expression2, final ExpressionResolver expressionResolver) {
        applyTextAlignment(divInputView, expression.evaluate(expressionResolver), expression2.evaluate(expressionResolver));
        Function1<? super DivAlignmentHorizontal, Unit> function1 = new Function1<Object, Unit>() { // from class: com.yandex.div.core.view2.divs.DivInputBinder$observeTextAlignment$callback$1
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
                this.this$0.applyTextAlignment(divInputView, expression.evaluate(expressionResolver), expression2.evaluate(expressionResolver));
            }
        };
        divInputView.addSubscription(expression.observe(expressionResolver, function1));
        divInputView.addSubscription(expression2.observe(expressionResolver, function1));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void applyTextAlignment(DivInputView divInputView, DivAlignmentHorizontal divAlignmentHorizontal, DivAlignmentVertical divAlignmentVertical) {
        divInputView.setGravity(BaseDivViewExtensionsKt.evaluateGravity(divAlignmentHorizontal, divAlignmentVertical));
        int i = divAlignmentHorizontal == null ? -1 : WhenMappings.$EnumSwitchMapping$0[divAlignmentHorizontal.ordinal()];
        int i2 = 5;
        if (i != 1) {
            if (i == 2) {
                i2 = 4;
            } else if (i == 3 || (i != 4 && i == 5)) {
                i2 = 6;
            }
        }
        divInputView.setTextAlignment(i2);
    }

    private final void observeBackground(final DivInputView divInputView, final BindingContext bindingContext, final DivInput divInput, final DivInput divInput2, ExpressionResolver expressionResolver) {
        Expression<Integer> expression;
        Disposable disposableObserveAndGet = null;
        if (DivDataExtensionsKt.equalsToConstant(divInput.nativeInterface, divInput2 != null ? divInput2.nativeInterface : null)) {
            return;
        }
        applyNativeBackgroundColor(divInputView, bindingContext, divInput, divInput2);
        if (DivDataExtensionsKt.isConstant(divInput.nativeInterface)) {
            return;
        }
        DivInput.NativeInterface nativeInterface = divInput.nativeInterface;
        if (nativeInterface != null && (expression = nativeInterface.color) != null) {
            disposableObserveAndGet = expression.observeAndGet(expressionResolver, new Function1<Integer, Unit>() { // from class: com.yandex.div.core.view2.divs.DivInputBinder.observeBackground.1
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
                    DivInputBinder.this.applyNativeBackgroundColor(divInputView, bindingContext, divInput, divInput2);
                }
            });
        }
        divInputView.addSubscription(disposableObserveAndGet);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void applyNativeBackgroundColor(DivInputView divInputView, BindingContext bindingContext, DivInput divInput, DivInput divInput2) {
        Drawable nativeBackground;
        Drawable drawable;
        Expression<Integer> expression;
        ExpressionResolver expressionResolver = bindingContext.getExpressionResolver();
        DivInput.NativeInterface nativeInterface = divInput.nativeInterface;
        int iIntValue = (nativeInterface == null || (expression = nativeInterface.color) == null) ? 0 : expression.evaluate(expressionResolver).intValue();
        if (iIntValue == 0 || (nativeBackground = divInputView.getNativeBackground()) == null) {
            drawable = null;
        } else {
            nativeBackground.setTint(iIntValue);
            drawable = nativeBackground;
        }
        DivInputView divInputView2 = divInputView;
        this.baseBinder.bindBackground$div_release(bindingContext, divInputView2, divInput, divInput2, ReleasablesKt.getExpressionSubscriber(divInputView2), drawable);
    }

    private final void observeFontSize(final DivInputView divInputView, final DivInput divInput, final ExpressionResolver expressionResolver) {
        Function1<? super Long, Unit> function1 = new Function1<Object, Unit>() { // from class: com.yandex.div.core.view2.divs.DivInputBinder$observeFontSize$callback$1
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
                this.this$0.applyFontSize(divInputView, divInput, expressionResolver);
            }
        };
        divInputView.addSubscription(divInput.fontSize.observeAndGet(expressionResolver, function1));
        divInputView.addSubscription(divInput.letterSpacing.observe(expressionResolver, function1));
        divInputView.addSubscription(divInput.fontSizeUnit.observe(expressionResolver, function1));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void applyFontSize(DivInputView divInputView, DivInput divInput, ExpressionResolver expressionResolver) {
        int i;
        long jLongValue = divInput.fontSize.evaluate(expressionResolver).longValue();
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
        DivInputView divInputView2 = divInputView;
        BaseDivViewExtensionsKt.applyFontSize(divInputView2, i, divInput.fontSizeUnit.evaluate(expressionResolver));
        BaseDivViewExtensionsKt.applyLetterSpacing(divInputView2, divInput.letterSpacing.evaluate(expressionResolver).doubleValue(), i);
    }

    private final void observeTypeface(final DivInputView divInputView, final DivInput divInput, final ExpressionResolver expressionResolver) {
        Disposable disposableObserveAndGet;
        applyTypeface(divInputView, divInput, expressionResolver);
        Function1<? super String, Unit> function1 = new Function1<Object, Unit>() { // from class: com.yandex.div.core.view2.divs.DivInputBinder$observeTypeface$callback$1
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
                this.this$0.applyTypeface(divInputView, divInput, expressionResolver);
            }
        };
        Expression<String> expression = divInput.fontFamily;
        if (expression != null && (disposableObserveAndGet = expression.observeAndGet(expressionResolver, function1)) != null) {
            divInputView.addSubscription(disposableObserveAndGet);
        }
        divInputView.addSubscription(divInput.fontWeight.observe(expressionResolver, function1));
        Expression<Long> expression2 = divInput.fontWeightValue;
        divInputView.addSubscription(expression2 != null ? expression2.observe(expressionResolver, function1) : null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void applyTypeface(DivInputView divInputView, DivInput divInput, ExpressionResolver expressionResolver) {
        DivTypefaceResolver divTypefaceResolver = this.typefaceResolver;
        Expression<String> expression = divInput.fontFamily;
        String strEvaluate = expression != null ? expression.evaluate(expressionResolver) : null;
        DivFontWeight divFontWeightEvaluate = divInput.fontWeight.evaluate(expressionResolver);
        Expression<Long> expression2 = divInput.fontWeightValue;
        divInputView.setTypeface(DivTypefaceResolverKt.getTypeface(divTypefaceResolver, strEvaluate, divFontWeightEvaluate, expression2 != null ? expression2.evaluate(expressionResolver) : null));
    }

    private final void observeTextColor(final DivInputView divInputView, final DivInput divInput, final ExpressionResolver expressionResolver) {
        divInputView.addSubscription(divInput.textColor.observeAndGet(expressionResolver, new Function1<Object, Unit>() { // from class: com.yandex.div.core.view2.divs.DivInputBinder$observeTextColor$callback$1
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
                divInputView.setTextColor(divInput.textColor.evaluate(expressionResolver).intValue());
            }
        }));
    }

    private final void observeLineHeight(final DivInputView divInputView, DivInput divInput, final ExpressionResolver expressionResolver) {
        final DivSizeUnit divSizeUnitEvaluate = divInput.fontSizeUnit.evaluate(expressionResolver);
        final Expression<Long> expression = divInput.lineHeight;
        if (expression == null) {
            BaseDivViewExtensionsKt.applyLineHeight(divInputView, null, divSizeUnitEvaluate);
        } else {
            divInputView.addSubscription(expression.observeAndGet(expressionResolver, new Function1<Object, Unit>() { // from class: com.yandex.div.core.view2.divs.DivInputBinder$observeLineHeight$callback$1
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
                    BaseDivViewExtensionsKt.applyLineHeight(divInputView, expression.evaluate(expressionResolver), divSizeUnitEvaluate);
                }
            }));
        }
    }

    private final void observeMaxVisibleLines(final DivInputView divInputView, DivInput divInput, final ExpressionResolver expressionResolver) {
        final Expression<Long> expression = divInput.maxVisibleLines;
        if (expression == null) {
            return;
        }
        divInputView.addSubscription(expression.observeAndGet(expressionResolver, new Function1<Object, Unit>() { // from class: com.yandex.div.core.view2.divs.DivInputBinder$observeMaxVisibleLines$callback$1
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
                DivInputView divInputView2 = divInputView;
                long jLongValue = expression.evaluate(expressionResolver).longValue();
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
                divInputView2.setMaxLines(i);
            }
        }));
    }

    private final void observeMaxLength(final DivInputView divInputView, DivInput divInput, final ExpressionResolver expressionResolver) {
        final Expression<Long> expression = divInput.maxLength;
        if (expression == null) {
            return;
        }
        divInputView.addSubscription(expression.observeAndGet(expressionResolver, new Function1<Object, Unit>() { // from class: com.yandex.div.core.view2.divs.DivInputBinder$observeMaxLength$callback$1
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
                DivInputView divInputView2 = divInputView;
                InputFilter.LengthFilter[] lengthFilterArr = new InputFilter.LengthFilter[1];
                long jLongValue = expression.evaluate(expressionResolver).longValue();
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
                lengthFilterArr[0] = new InputFilter.LengthFilter(i);
                divInputView2.setFilters(lengthFilterArr);
            }
        }));
    }

    private final void observeHintText(final DivInputView divInputView, DivInput divInput, final ExpressionResolver expressionResolver) {
        final Expression<String> expression = divInput.hintText;
        if (expression == null) {
            return;
        }
        divInputView.addSubscription(expression.observeAndGet(expressionResolver, new Function1<Object, Unit>() { // from class: com.yandex.div.core.view2.divs.DivInputBinder$observeHintText$callback$1
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
                divInputView.setInputHint(expression.evaluate(expressionResolver));
            }
        }));
    }

    private final void observeHintColor(final DivInputView divInputView, final DivInput divInput, final ExpressionResolver expressionResolver) {
        divInputView.addSubscription(divInput.hintColor.observeAndGet(expressionResolver, new Function1<Object, Unit>() { // from class: com.yandex.div.core.view2.divs.DivInputBinder$observeHintColor$callback$1
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
                divInputView.setHintTextColor(divInput.hintColor.evaluate(expressionResolver).intValue());
            }
        }));
    }

    private final void observeHighlightColor(final DivInputView divInputView, DivInput divInput, final ExpressionResolver expressionResolver) {
        final Expression<Integer> expression = divInput.highlightColor;
        if (expression == null) {
            return;
        }
        divInputView.addSubscription(expression.observeAndGet(expressionResolver, new Function1<Object, Unit>() { // from class: com.yandex.div.core.view2.divs.DivInputBinder$observeHighlightColor$callback$1
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
                divInputView.setHighlightColor(expression.evaluate(expressionResolver).intValue());
            }
        }));
    }

    private final void observeKeyboardTypeAndCapitalization(final DivInputView divInputView, final DivInput divInput, final ExpressionResolver expressionResolver) {
        Function1<? super DivInput.KeyboardType, Unit> function1 = new Function1<Object, Unit>() { // from class: com.yandex.div.core.view2.divs.DivInputBinder$observeKeyboardTypeAndCapitalization$callback$1
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
                DivInput.KeyboardType keyboardTypeEvaluate = divInput.keyboardType.evaluate(expressionResolver);
                divInputView.setInputType(this.getKeyboardType(keyboardTypeEvaluate) | this.getCapitalization(divInput, expressionResolver));
                divInputView.setHorizontallyScrolling(keyboardTypeEvaluate != DivInput.KeyboardType.MULTI_LINE_TEXT);
            }
        };
        divInputView.addSubscription(divInput.keyboardType.observe(expressionResolver, function1));
        divInputView.addSubscription(divInput.autocapitalization.observeAndGet(expressionResolver, function1));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final int getKeyboardType(DivInput.KeyboardType type) {
        switch (WhenMappings.$EnumSwitchMapping$1[type.ordinal()]) {
            case 1:
                return 1;
            case 2:
                return 131073;
            case 3:
                return 33;
            case 4:
                return 17;
            case 5:
                return 12290;
            case 6:
                return 3;
            case 7:
                return 129;
            default:
                throw new NoWhenBranchMatchedException();
        }
    }

    private final void observeEnterTypeAndActions(DivInputView divInputView, DivInput divInput, BindingContext bindingContext, ExpressionResolver expressionResolver) {
        divInputView.addSubscription(divInput.enterKeyType.observeAndGet(expressionResolver, new DivInputBinder$observeEnterTypeAndActions$callback$1(divInput, expressionResolver, divInputView, this, bindingContext)));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final int getImeAction(DivInput.EnterKeyType type) {
        int i = WhenMappings.$EnumSwitchMapping$2[type.ordinal()];
        if (i == 1) {
            return 0;
        }
        if (i == 2) {
            return 4;
        }
        if (i == 3) {
            return 6;
        }
        if (i == 4) {
            return 3;
        }
        if (i == 5) {
            return 2;
        }
        throw new NoWhenBranchMatchedException();
    }

    private final void observeSelectAllOnFocus(final DivInputView divInputView, final DivInput divInput, final ExpressionResolver expressionResolver) {
        divInputView.addSubscription(divInput.selectAllOnFocus.observeAndGet(expressionResolver, new Function1<Object, Unit>() { // from class: com.yandex.div.core.view2.divs.DivInputBinder$observeSelectAllOnFocus$callback$1
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
                divInputView.setSelectAllOnFocus(divInput.selectAllOnFocus.evaluate(expressionResolver).booleanValue());
            }
        }));
    }

    private final void observeIsEnabled(final DivInputView divInputView, DivInput divInput, ExpressionResolver expressionResolver) {
        divInputView.addSubscription(divInput.isEnabled.observeAndGet(expressionResolver, new Function1<Boolean, Unit>() { // from class: com.yandex.div.core.view2.divs.DivInputBinder$observeIsEnabled$callback$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
                invoke(bool.booleanValue());
                return Unit.INSTANCE;
            }

            public final void invoke(boolean z) {
                if (!z && divInputView.isFocused()) {
                    DivActionTypedUtilsKt.closeKeyboard(divInputView);
                }
                divInputView.setEnabled$div_release(z);
            }
        }));
    }

    /* JADX WARN: Type inference failed for: r2v4, types: [T, java.lang.String] */
    private final void observeText(final DivInputView divInputView, DivInput divInput, BindingContext bindingContext, DivStatePath divStatePath) {
        String rawTextVariable;
        DivInputMaskBase divInputMaskBaseValue;
        final Div2View divView = bindingContext.getDivView();
        divInputView.removeAfterTextChangeListener();
        final Ref.ObjectRef objectRef = new Ref.ObjectRef();
        observeMask(divInputView, divInput, bindingContext.getExpressionResolver(), divView, new Function1<BaseInputMask, Unit>() { // from class: com.yandex.div.core.view2.divs.DivInputBinder.observeText.1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(BaseInputMask baseInputMask) {
                invoke2(baseInputMask);
                return Unit.INSTANCE;
            }

            /* JADX WARN: Multi-variable type inference failed */
            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(BaseInputMask baseInputMask) {
                objectRef.element = baseInputMask;
                BaseInputMask baseInputMask2 = objectRef.element;
                if (baseInputMask2 != null) {
                    DivInputView divInputView2 = divInputView;
                    divInputView2.setText(baseInputMask2.getValue());
                    divInputView2.setSelection(baseInputMask2.getCursorPosition());
                }
            }
        });
        final Ref.ObjectRef objectRef2 = new Ref.ObjectRef();
        if (divInput.mask != null) {
            DivInputMask divInputMask = divInput.mask;
            if (divInputMask == null || (divInputMaskBaseValue = divInputMask.value()) == null || (rawTextVariable = divInputMaskBaseValue.getRawTextVariable()) == null) {
                return;
            } else {
                objectRef2.element = divInput.textVariable;
            }
        } else {
            rawTextVariable = divInput.textVariable;
        }
        final Function1<String, Unit> function1 = new Function1<String, Unit>() { // from class: com.yandex.div.core.view2.divs.DivInputBinder$observeText$setSecondVariable$1
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
            public final void invoke2(String value) {
                Intrinsics.checkNotNullParameter(value, "value");
                if (objectRef2.element != null) {
                    divView.setVariable(objectRef2.element, value);
                }
            }
        };
        divInputView.addSubscription(this.variableBinder.bindVariable(bindingContext, rawTextVariable, new TwoWayStringVariableBinder.Callbacks() { // from class: com.yandex.div.core.view2.divs.DivInputBinder$observeText$callbacks$1
            @Override // com.yandex.div.core.expression.variables.TwoWayVariableBinder.Callbacks
            public void onVariableChanged(String value) {
                BaseInputMask baseInputMask = objectRef.element;
                if (baseInputMask != null) {
                    Function1<String, Unit> function2 = function1;
                    baseInputMask.overrideRawValue(value == null ? "" : value);
                    function2.invoke(baseInputMask.getValue());
                    String value2 = baseInputMask.getValue();
                    if (value2 != null) {
                        value = value2;
                    }
                }
                divInputView.setText(value);
            }

            @Override // com.yandex.div.core.expression.variables.TwoWayVariableBinder.Callbacks
            public void setViewStateChangeListener(final Function1<? super String, Unit> valueUpdater) {
                Intrinsics.checkNotNullParameter(valueUpdater, "valueUpdater");
                DivInputView divInputView2 = divInputView;
                final Ref.ObjectRef<BaseInputMask> objectRef3 = objectRef;
                final DivInputView divInputView3 = divInputView;
                final Function1<String, Unit> function2 = function1;
                divInputView2.addAfterTextChangeAction(new Function1<Editable, Unit>() { // from class: com.yandex.div.core.view2.divs.DivInputBinder$observeText$callbacks$1$setViewStateChangeListener$1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    /* JADX WARN: Multi-variable type inference failed */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(Editable editable) {
                        invoke2(editable);
                        return Unit.INSTANCE;
                    }

                    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(Editable editable) {
                        String string;
                        String rawValue;
                        String strReplace$default;
                        String string2;
                        String str = "";
                        if (editable == null || (string = editable.toString()) == null) {
                            string = "";
                        }
                        BaseInputMask baseInputMask = objectRef3.element;
                        if (baseInputMask != null) {
                            DivInputView divInputView4 = divInputView3;
                            Function1<String, Unit> function3 = function2;
                            if (!Intrinsics.areEqual(baseInputMask.getValue(), string)) {
                                Editable text = divInputView4.getText();
                                if (text != null && (string2 = text.toString()) != null) {
                                    str = string2;
                                }
                                baseInputMask.applyChangeFrom(str, Integer.valueOf(divInputView4.getSelectionStart()));
                                divInputView4.setText(baseInputMask.getValue());
                                divInputView4.setSelection(baseInputMask.getCursorPosition());
                                function3.invoke(baseInputMask.getValue());
                            }
                        }
                        BaseInputMask baseInputMask2 = objectRef3.element;
                        if (baseInputMask2 != null && (rawValue = baseInputMask2.getRawValue()) != null && (strReplace$default = StringsKt.replace$default(rawValue, AbstractJsonLexerKt.COMMA, '.', false, 4, (Object) null)) != null) {
                            string = strReplace$default;
                        }
                        valueUpdater.invoke(string);
                    }
                });
            }
        }, divStatePath));
        observeValidators(divInputView, divInput, bindingContext.getExpressionResolver(), divView);
    }

    private final void observeValidators(final DivInputView divInputView, final DivInput divInput, final ExpressionResolver expressionResolver, final Div2View div2View) {
        final ArrayList arrayList = new ArrayList();
        final ErrorCollector orCreate = this.errorCollectors.getOrCreate(div2View.getDataTag(), div2View.getDivData());
        final Function1<Integer, Unit> function1 = new Function1<Integer, Unit>() { // from class: com.yandex.div.core.view2.divs.DivInputBinder$observeValidators$revalidateExpressionValidator$1
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
                this.this$0.validate(arrayList.get(i), String.valueOf(divInputView.getText()), divInputView, div2View, expressionResolver);
            }
        };
        divInputView.addTextChangedListener(new TextWatcher() { // from class: com.yandex.div.core.view2.divs.DivInputBinder$observeValidators$$inlined$doAfterTextChanged$1
            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence text, int start, int count, int after) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence text, int start, int before, int count) {
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable s) {
                if (s != null) {
                    Iterator it = arrayList.iterator();
                    while (it.hasNext()) {
                        this.validate((ValidatorItemData) it.next(), String.valueOf(divInputView.getText()), divInputView, div2View, expressionResolver);
                    }
                }
            }
        });
        Function1<? super String, Unit> function2 = new Function1<Object, Unit>() { // from class: com.yandex.div.core.view2.divs.DivInputBinder$observeValidators$callback$1
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
                arrayList.clear();
                List<DivInputValidator> list = divInput.validators;
                if (list != null) {
                    DivInputBinder divInputBinder = this;
                    ExpressionResolver expressionResolver2 = expressionResolver;
                    ErrorCollector errorCollector = orCreate;
                    List<ValidatorItemData> list2 = arrayList;
                    Iterator<T> it = list.iterator();
                    while (it.hasNext()) {
                        ValidatorItemData validatorDataItem = divInputBinder.toValidatorDataItem((DivInputValidator) it.next(), expressionResolver2, errorCollector);
                        if (validatorDataItem != null) {
                            list2.add(validatorDataItem);
                        }
                    }
                    List<ValidatorItemData> list3 = arrayList;
                    DivInputBinder divInputBinder2 = this;
                    DivInputView divInputView2 = divInputView;
                    Div2View div2View2 = div2View;
                    ExpressionResolver expressionResolver3 = expressionResolver;
                    Iterator<T> it2 = list3.iterator();
                    while (it2.hasNext()) {
                        divInputBinder2.validate((ValidatorItemData) it2.next(), String.valueOf(divInputView2.getText()), divInputView2, div2View2, expressionResolver3);
                    }
                }
            }
        };
        List<DivInputValidator> list = divInput.validators;
        if (list != null) {
            final int i = 0;
            for (Object obj : list) {
                int i2 = i + 1;
                if (i < 0) {
                    CollectionsKt.throwIndexOverflow();
                }
                DivInputValidator divInputValidator = (DivInputValidator) obj;
                if (divInputValidator instanceof DivInputValidator.Regex) {
                    DivInputValidator.Regex regex = (DivInputValidator.Regex) divInputValidator;
                    divInputView.addSubscription(regex.getValue().pattern.observe(expressionResolver, function2));
                    divInputView.addSubscription(regex.getValue().labelId.observe(expressionResolver, function2));
                    divInputView.addSubscription(regex.getValue().allowEmpty.observe(expressionResolver, function2));
                } else {
                    if (!(divInputValidator instanceof DivInputValidator.Expression)) {
                        throw new NoWhenBranchMatchedException();
                    }
                    DivInputValidator.Expression expression = (DivInputValidator.Expression) divInputValidator;
                    divInputView.addSubscription(expression.getValue().condition.observe(expressionResolver, new Function1<Boolean, Unit>() { // from class: com.yandex.div.core.view2.divs.DivInputBinder$observeValidators$2$1
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        /* JADX WARN: Multi-variable type inference failed */
                        {
                            super(1);
                        }

                        @Override // kotlin.jvm.functions.Function1
                        public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
                            invoke(bool.booleanValue());
                            return Unit.INSTANCE;
                        }

                        public final void invoke(boolean z) {
                            function1.invoke(Integer.valueOf(i));
                        }
                    }));
                    divInputView.addSubscription(expression.getValue().labelId.observe(expressionResolver, function2));
                    divInputView.addSubscription(expression.getValue().allowEmpty.observe(expressionResolver, function2));
                }
                i = i2;
            }
        }
        function2.invoke(Unit.INSTANCE);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final ValidatorItemData toValidatorDataItem(DivInputValidator divInputValidator, final ExpressionResolver expressionResolver, ErrorCollector errorCollector) {
        if (divInputValidator instanceof DivInputValidator.Regex) {
            DivInputValidatorRegex value = ((DivInputValidator.Regex) divInputValidator).getValue();
            try {
                return new ValidatorItemData(new RegexValidator(new Regex(value.pattern.evaluate(expressionResolver)), value.allowEmpty.evaluate(expressionResolver).booleanValue()), value.variable, value.labelId.evaluate(expressionResolver));
            } catch (PatternSyntaxException e) {
                errorCollector.logError(new IllegalArgumentException("Invalid regex pattern '" + e.getPattern() + '\'', e));
                return null;
            }
        }
        if (!(divInputValidator instanceof DivInputValidator.Expression)) {
            throw new NoWhenBranchMatchedException();
        }
        final DivInputValidatorExpression value2 = ((DivInputValidator.Expression) divInputValidator).getValue();
        return new ValidatorItemData(new ExpressionValidator(value2.allowEmpty.evaluate(expressionResolver).booleanValue(), new Function0<Boolean>() { // from class: com.yandex.div.core.view2.divs.DivInputBinder.toValidatorDataItem.1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final Boolean invoke() {
                return value2.condition.evaluate(expressionResolver);
            }
        }), value2.variable, value2.labelId.evaluate(expressionResolver));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void validate(ValidatorItemData validatorItemData, String str, DivInputView divInputView, Div2View div2View, ExpressionResolver expressionResolver) {
        boolean zValidate = validatorItemData.getValidator().validate(str);
        VariableMutationHandler.INSTANCE.setVariable(div2View, validatorItemData.getVariableName(), String.valueOf(zValidate), expressionResolver);
        attachAccessibility(validatorItemData, div2View, divInputView, zValidate);
    }

    private final void attachAccessibility(final ValidatorItemData validatorItemData, Div2View div2View, final DivInputView divInputView, final boolean z) {
        final IllegalArgumentException illegalArgumentException = new IllegalArgumentException("Can't find label with id '" + validatorItemData.getLabelId() + '\'');
        final ErrorCollector orCreate = this.errorCollectors.getOrCreate(div2View.getDataTag(), div2View.getDivData());
        final DivViewIdProvider viewIdProvider = div2View.getViewComponent().getViewIdProvider();
        DivInputView divInputView2 = divInputView;
        if (divInputView2.isLaidOut() && !divInputView2.isLayoutRequested()) {
            int viewId = viewIdProvider.getViewId(validatorItemData.getLabelId());
            if (viewId != -1) {
                View viewFindViewById = divInputView.getRootView().findViewById(viewId);
                if (viewFindViewById != null) {
                    viewFindViewById.setLabelFor(z ? -1 : divInputView.getId());
                    return;
                } else {
                    orCreate.logError(illegalArgumentException);
                    return;
                }
            }
            orCreate.logError(illegalArgumentException);
            return;
        }
        divInputView2.addOnLayoutChangeListener(new View.OnLayoutChangeListener() { // from class: com.yandex.div.core.view2.divs.DivInputBinder$attachAccessibility$$inlined$doOnLayout$1
            @Override // android.view.View.OnLayoutChangeListener
            public void onLayoutChange(View view, int left, int top, int right, int bottom, int oldLeft, int oldTop, int oldRight, int oldBottom) {
                view.removeOnLayoutChangeListener(this);
                int viewId2 = viewIdProvider.getViewId(validatorItemData.getLabelId());
                if (viewId2 != -1) {
                    View viewFindViewById2 = divInputView.getRootView().findViewById(viewId2);
                    if (viewFindViewById2 != null) {
                        viewFindViewById2.setLabelFor(z ? -1 : divInputView.getId());
                        return;
                    } else {
                        orCreate.logError(illegalArgumentException);
                        return;
                    }
                }
                orCreate.logError(illegalArgumentException);
            }
        });
    }

    private final void observeMask(final DivInputView divInputView, final DivInput divInput, final ExpressionResolver expressionResolver, Div2View div2View, final Function1<? super BaseInputMask, Unit> function1) {
        Expression<String> expression;
        Disposable disposableObserve;
        final Ref.ObjectRef objectRef = new Ref.ObjectRef();
        final ErrorCollector orCreate = this.errorCollectors.getOrCreate(div2View.getDataTag(), div2View.getDivData());
        final KeyListener keyListener = divInputView.getKeyListener();
        final Function2<Exception, Function0<? extends Unit>, Unit> function2 = new Function2<Exception, Function0<? extends Unit>, Unit>() { // from class: com.yandex.div.core.view2.divs.DivInputBinder$observeMask$catchCommonMaskException$1
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Unit invoke(Exception exc, Function0<? extends Unit> function0) {
                invoke2(exc, (Function0<Unit>) function0);
                return Unit.INSTANCE;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Exception exception, Function0<Unit> other) {
                Intrinsics.checkNotNullParameter(exception, "exception");
                Intrinsics.checkNotNullParameter(other, "other");
                if (exception instanceof PatternSyntaxException) {
                    orCreate.logError(new IllegalArgumentException("Invalid regex pattern '" + ((PatternSyntaxException) exception).getPattern() + "'."));
                } else {
                    other.invoke();
                }
            }
        };
        Function1<? super String, Unit> function3 = new Function1<Object, Unit>() { // from class: com.yandex.div.core.view2.divs.DivInputBinder$observeMask$updateMaskData$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Object obj) {
                invoke2(obj);
                return Unit.INSTANCE;
            }

            /* JADX WARN: Multi-variable type inference failed */
            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Object obj) {
                BaseInputMask baseInputMask;
                Locale locale;
                Intrinsics.checkNotNullParameter(obj, "<anonymous parameter 0>");
                DivInputMask divInputMask = divInput.mask;
                T phoneInputMask = 0;
                DivInputMaskBase divInputMaskBaseValue = divInputMask != null ? divInputMask.value() : null;
                Ref.ObjectRef<BaseInputMask> objectRef2 = objectRef;
                if (divInputMaskBaseValue instanceof DivFixedLengthInputMask) {
                    divInputView.setKeyListener(keyListener);
                    DivFixedLengthInputMask divFixedLengthInputMask = (DivFixedLengthInputMask) divInputMaskBaseValue;
                    String strEvaluate = divFixedLengthInputMask.pattern.evaluate(expressionResolver);
                    List<DivFixedLengthInputMask.PatternElement> list = divFixedLengthInputMask.patternElements;
                    ExpressionResolver expressionResolver2 = expressionResolver;
                    ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
                    for (DivFixedLengthInputMask.PatternElement patternElement : list) {
                        char cFirst = StringsKt.first(patternElement.key.evaluate(expressionResolver2));
                        Expression<String> expression2 = patternElement.regex;
                        String strEvaluate2 = expression2 != null ? expression2.evaluate(expressionResolver2) : null;
                        Character chFirstOrNull = StringsKt.firstOrNull(patternElement.placeholder.evaluate(expressionResolver2));
                        arrayList.add(new BaseInputMask.MaskKey(cFirst, strEvaluate2, chFirstOrNull != null ? chFirstOrNull.charValue() : (char) 0));
                    }
                    BaseInputMask.MaskData maskData = new BaseInputMask.MaskData(strEvaluate, arrayList, divFixedLengthInputMask.alwaysVisible.evaluate(expressionResolver).booleanValue());
                    baseInputMask = objectRef.element;
                    if (baseInputMask != null) {
                        BaseInputMask.updateMaskData$default(baseInputMask, maskData, false, 2, null);
                        phoneInputMask = baseInputMask;
                    } else {
                        final Function2<Exception, Function0<Unit>, Unit> function4 = function2;
                        phoneInputMask = new FixedLengthInputMask(maskData, new Function1<Exception, Unit>() { // from class: com.yandex.div.core.view2.divs.DivInputBinder$observeMask$updateMaskData$1.2
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            /* JADX WARN: Multi-variable type inference failed */
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public /* bridge */ /* synthetic */ Unit invoke(Exception exc) {
                                invoke2(exc);
                                return Unit.INSTANCE;
                            }

                            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                            public final void invoke2(Exception it) {
                                Intrinsics.checkNotNullParameter(it, "it");
                                function4.invoke(it, new Function0<Unit>() { // from class: com.yandex.div.core.view2.divs.DivInputBinder.observeMask.updateMaskData.1.2.1
                                    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                                    public final void invoke2() {
                                    }

                                    @Override // kotlin.jvm.functions.Function0
                                    public /* bridge */ /* synthetic */ Unit invoke() {
                                        invoke2();
                                        return Unit.INSTANCE;
                                    }
                                });
                            }
                        });
                    }
                } else if (divInputMaskBaseValue instanceof DivCurrencyInputMask) {
                    Expression<String> expression3 = ((DivCurrencyInputMask) divInputMaskBaseValue).locale;
                    String strEvaluate3 = expression3 != null ? expression3.evaluate(expressionResolver) : null;
                    if (strEvaluate3 != null) {
                        locale = Locale.forLanguageTag(strEvaluate3);
                        ErrorCollector errorCollector = orCreate;
                        String languageTag = locale.toLanguageTag();
                        if (!Intrinsics.areEqual(languageTag, strEvaluate3)) {
                            errorCollector.logWarning(new IllegalArgumentException("Original locale tag '" + strEvaluate3 + "' is not equals to final one '" + languageTag + '\''));
                        }
                    } else {
                        locale = Locale.getDefault();
                    }
                    divInputView.setKeyListener(DigitsKeyListener.getInstance("1234567890.,"));
                    BaseInputMask baseInputMask2 = objectRef.element;
                    if (baseInputMask2 != null) {
                        BaseInputMask baseInputMask3 = objectRef.element;
                        Intrinsics.checkNotNull(baseInputMask3, "null cannot be cast to non-null type com.yandex.div.core.util.mask.CurrencyInputMask");
                        Intrinsics.checkNotNullExpressionValue(locale, "locale");
                        ((CurrencyInputMask) baseInputMask3).updateCurrencyParams(locale);
                        phoneInputMask = baseInputMask2;
                    } else {
                        Intrinsics.checkNotNullExpressionValue(locale, "locale");
                        final Function2<Exception, Function0<Unit>, Unit> function5 = function2;
                        phoneInputMask = new CurrencyInputMask(locale, new Function1<Exception, Unit>() { // from class: com.yandex.div.core.view2.divs.DivInputBinder$observeMask$updateMaskData$1.4
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            /* JADX WARN: Multi-variable type inference failed */
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public /* bridge */ /* synthetic */ Unit invoke(Exception exc) {
                                invoke2(exc);
                                return Unit.INSTANCE;
                            }

                            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                            public final void invoke2(Exception it) {
                                Intrinsics.checkNotNullParameter(it, "it");
                                function5.invoke(it, new Function0<Unit>() { // from class: com.yandex.div.core.view2.divs.DivInputBinder.observeMask.updateMaskData.1.4.1
                                    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                                    public final void invoke2() {
                                    }

                                    @Override // kotlin.jvm.functions.Function0
                                    public /* bridge */ /* synthetic */ Unit invoke() {
                                        invoke2();
                                        return Unit.INSTANCE;
                                    }
                                });
                            }
                        });
                    }
                } else if (divInputMaskBaseValue instanceof DivPhoneInputMask) {
                    divInputView.setKeyListener(DigitsKeyListener.getInstance("1234567890"));
                    baseInputMask = objectRef.element;
                    if (baseInputMask != null) {
                        BaseInputMask.updateMaskData$default(baseInputMask, PhoneInputMaskKt.getDEFAULT_MASK_DATA(), false, 2, null);
                        phoneInputMask = baseInputMask;
                    } else {
                        final Function2<Exception, Function0<Unit>, Unit> function6 = function2;
                        phoneInputMask = new PhoneInputMask(new Function1<Exception, Unit>() { // from class: com.yandex.div.core.view2.divs.DivInputBinder$observeMask$updateMaskData$1.6
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            /* JADX WARN: Multi-variable type inference failed */
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public /* bridge */ /* synthetic */ Unit invoke(Exception exc) {
                                invoke2(exc);
                                return Unit.INSTANCE;
                            }

                            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                            public final void invoke2(Exception it) {
                                Intrinsics.checkNotNullParameter(it, "it");
                                function6.invoke(it, new Function0<Unit>() { // from class: com.yandex.div.core.view2.divs.DivInputBinder.observeMask.updateMaskData.1.6.1
                                    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                                    public final void invoke2() {
                                    }

                                    @Override // kotlin.jvm.functions.Function0
                                    public /* bridge */ /* synthetic */ Unit invoke() {
                                        invoke2();
                                        return Unit.INSTANCE;
                                    }
                                });
                            }
                        });
                    }
                } else {
                    divInputView.setKeyListener(keyListener);
                }
                objectRef2.element = phoneInputMask;
                function1.invoke(objectRef.element);
            }
        };
        DivInputMask divInputMask = divInput.mask;
        DivInputMaskBase divInputMaskBaseValue = divInputMask != null ? divInputMask.value() : null;
        if (divInputMaskBaseValue instanceof DivFixedLengthInputMask) {
            DivFixedLengthInputMask divFixedLengthInputMask = (DivFixedLengthInputMask) divInputMaskBaseValue;
            divInputView.addSubscription(divFixedLengthInputMask.pattern.observe(expressionResolver, function3));
            for (DivFixedLengthInputMask.PatternElement patternElement : divFixedLengthInputMask.patternElements) {
                divInputView.addSubscription(patternElement.key.observe(expressionResolver, function3));
                Expression<String> expression2 = patternElement.regex;
                if (expression2 != null) {
                    divInputView.addSubscription(expression2.observe(expressionResolver, function3));
                }
                divInputView.addSubscription(patternElement.placeholder.observe(expressionResolver, function3));
            }
            divInputView.addSubscription(divFixedLengthInputMask.alwaysVisible.observe(expressionResolver, function3));
        } else if ((divInputMaskBaseValue instanceof DivCurrencyInputMask) && (expression = ((DivCurrencyInputMask) divInputMaskBaseValue).locale) != null && (disposableObserve = expression.observe(expressionResolver, function3)) != null) {
            divInputView.addSubscription(disposableObserve);
        }
        function3.invoke(Unit.INSTANCE);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final int getCapitalization(DivInput div, ExpressionResolver resolver) {
        int i = WhenMappings.$EnumSwitchMapping$3[div.autocapitalization.evaluate(resolver).ordinal()];
        if (i == 1) {
            return 16384;
        }
        if (i != 2) {
            return i != 3 ? 0 : 4096;
        }
        return 8192;
    }
}
