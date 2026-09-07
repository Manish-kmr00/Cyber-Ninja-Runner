package com.yandex.div.core.view2;

import android.content.Context;
import android.view.View;
import android.widget.CheckBox;
import android.widget.RadioButton;
import androidx.core.view.ViewCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import com.facebook.share.internal.ShareConstants;
import com.json.b9;
import com.unity3d.ads.core.domain.HandleInvocationsFromAdViewer;
import com.yandex.div.core.dagger.DivScope;
import com.yandex.div.core.dagger.ExperimentFlag;
import com.yandex.div.core.experiments.Experiment;
import com.yandex.div.core.util.AccessibilityStateProvider;
import com.yandex.div.core.view2.backbutton.BackHandlingRecyclerView;
import com.yandex.div.core.view2.divs.widgets.DivInputView;
import com.yandex.div.core.view2.divs.widgets.DivSliderView;
import com.yandex.div.json.expressions.Expression;
import com.yandex.div.json.expressions.ExpressionResolver;
import com.yandex.div2.DivAccessibility;
import com.yandex.div2.DivAction;
import com.yandex.div2.DivBase;
import com.yandex.div2.DivGallery;
import com.yandex.div2.DivImage;
import com.yandex.div2.DivInput;
import com.yandex.div2.DivSelect;
import com.yandex.div2.DivSeparator;
import com.yandex.div2.DivSlider;
import com.yandex.div2.DivTabs;
import com.yandex.div2.DivText;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: DivAccessibilityBinder.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0011\u0018\u00002\u00020\u0001:\u0001+B\u0019\b\u0007\u0012\b\b\u0001\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J*\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\n2\u0006\u0010\u0019\u001a\u00020\u000bH\u0016J(\u0010\u001a\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0019\u001a\u00020\u000b2\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u001eH\u0016J\u0018\u0010\u001f\u001a\u00020\n2\u0006\u0010 \u001a\u00020\n2\u0006\u0010\u0018\u001a\u00020\nH\u0012J$\u0010!\u001a\u00020\u0013*\u00020\u00152\u0006\u0010\u0018\u001a\u00020\n2\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\"\u001a\u00020\u0003H\u0012J\u0014\u0010\u001a\u001a\u00020\u0013*\u00020#2\u0006\u0010\u001b\u001a\u00020$H\u0012J\u0014\u0010%\u001a\u00020\u0003*\u00020&2\u0006\u0010\u001d\u001a\u00020\u001eH\u0012J\u0014\u0010'\u001a\u00020\u0013*\u00020\u00152\u0006\u0010(\u001a\u00020\u0003H\u0012J\u001c\u0010)\u001a\u00020$*\u00020\u001c2\u0006\u0010*\u001a\u00020\u000b2\u0006\u0010\u001d\u001a\u00020\u001eH\u0012R\u000e\u0010\u0004\u001a\u00020\u0005X\u0092\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0002\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0018\u0010\t\u001a\u00020\n*\u00020\u000b8RX\u0092\u0004¢\u0006\u0006\u001a\u0004\b\f\u0010\rR\u0018\u0010\u000e\u001a\u00020\u000f*\u00020\n8RX\u0092\u0004¢\u0006\u0006\u001a\u0004\b\u0010\u0010\u0011¨\u0006,"}, d2 = {"Lcom/yandex/div/core/view2/DivAccessibilityBinder;", "", "enabled", "", "accessibilityStateProvider", "Lcom/yandex/div/core/util/AccessibilityStateProvider;", "(ZLcom/yandex/div/core/util/AccessibilityStateProvider;)V", "getEnabled", "()Z", "getDefaultAccessibilityMode", "Lcom/yandex/div2/DivAccessibility$Mode;", "Lcom/yandex/div2/DivBase;", "getGetDefaultAccessibilityMode", "(Lcom/yandex/div2/DivBase;)Lcom/yandex/div2/DivAccessibility$Mode;", HandleInvocationsFromAdViewer.KEY_DOWNLOAD_PRIORITY, "", "getPriority", "(Lcom/yandex/div2/DivAccessibility$Mode;)I", "bindAccessibilityMode", "", "view", "Landroid/view/View;", "divView", "Lcom/yandex/div/core/view2/Div2View;", b9.a.t, "divBase", "bindType", "type", "Lcom/yandex/div2/DivAccessibility$Type;", "resolver", "Lcom/yandex/div/json/expressions/ExpressionResolver;", "getPropagatedMode", "parentMode", "applyAccessibilityMode", "isDescendant", "Landroidx/core/view/accessibility/AccessibilityNodeInfoCompat;", "Lcom/yandex/div/core/view2/DivAccessibilityBinder$AccessibilityType;", "isClickable", "Lcom/yandex/div2/DivImage;", "setActionable", "actionable", "toAccessibilityType", "div", "AccessibilityType", "div_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
@DivScope
public class DivAccessibilityBinder {
    private final AccessibilityStateProvider accessibilityStateProvider;
    private final boolean enabled;

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: compiled from: DivAccessibilityBinder.kt */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u000f\b\u0082\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000f¨\u0006\u0010"}, d2 = {"Lcom/yandex/div/core/view2/DivAccessibilityBinder$AccessibilityType;", "", "(Ljava/lang/String;I)V", "NONE", "BUTTON", "EDIT_TEXT", "HEADER", ShareConstants.IMAGE_URL, "LIST", "SLIDER", "SELECT", "TAB_WIDGET", "PAGER", "TEXT", "RADIO_BUTTON", "CHECK_BOX", "div_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    enum AccessibilityType {
        NONE,
        BUTTON,
        EDIT_TEXT,
        HEADER,
        IMAGE,
        LIST,
        SLIDER,
        SELECT,
        TAB_WIDGET,
        PAGER,
        TEXT,
        RADIO_BUTTON,
        CHECK_BOX
    }

    /* JADX INFO: compiled from: DivAccessibilityBinder.kt */
    @Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;
        public static final /* synthetic */ int[] $EnumSwitchMapping$1;
        public static final /* synthetic */ int[] $EnumSwitchMapping$2;

        static {
            int[] iArr = new int[AccessibilityType.values().length];
            try {
                iArr[AccessibilityType.NONE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[AccessibilityType.BUTTON.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[AccessibilityType.EDIT_TEXT.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[AccessibilityType.HEADER.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                iArr[AccessibilityType.IMAGE.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                iArr[AccessibilityType.LIST.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                iArr[AccessibilityType.PAGER.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                iArr[AccessibilityType.SLIDER.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                iArr[AccessibilityType.SELECT.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                iArr[AccessibilityType.TAB_WIDGET.ordinal()] = 10;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                iArr[AccessibilityType.TEXT.ordinal()] = 11;
            } catch (NoSuchFieldError unused11) {
            }
            try {
                iArr[AccessibilityType.CHECK_BOX.ordinal()] = 12;
            } catch (NoSuchFieldError unused12) {
            }
            try {
                iArr[AccessibilityType.RADIO_BUTTON.ordinal()] = 13;
            } catch (NoSuchFieldError unused13) {
            }
            $EnumSwitchMapping$0 = iArr;
            int[] iArr2 = new int[DivAccessibility.Mode.values().length];
            try {
                iArr2[DivAccessibility.Mode.EXCLUDE.ordinal()] = 1;
            } catch (NoSuchFieldError unused14) {
            }
            try {
                iArr2[DivAccessibility.Mode.MERGE.ordinal()] = 2;
            } catch (NoSuchFieldError unused15) {
            }
            try {
                iArr2[DivAccessibility.Mode.DEFAULT.ordinal()] = 3;
            } catch (NoSuchFieldError unused16) {
            }
            $EnumSwitchMapping$1 = iArr2;
            int[] iArr3 = new int[DivAccessibility.Type.values().length];
            try {
                iArr3[DivAccessibility.Type.AUTO.ordinal()] = 1;
            } catch (NoSuchFieldError unused17) {
            }
            try {
                iArr3[DivAccessibility.Type.NONE.ordinal()] = 2;
            } catch (NoSuchFieldError unused18) {
            }
            try {
                iArr3[DivAccessibility.Type.BUTTON.ordinal()] = 3;
            } catch (NoSuchFieldError unused19) {
            }
            try {
                iArr3[DivAccessibility.Type.IMAGE.ordinal()] = 4;
            } catch (NoSuchFieldError unused20) {
            }
            try {
                iArr3[DivAccessibility.Type.TEXT.ordinal()] = 5;
            } catch (NoSuchFieldError unused21) {
            }
            try {
                iArr3[DivAccessibility.Type.EDIT_TEXT.ordinal()] = 6;
            } catch (NoSuchFieldError unused22) {
            }
            try {
                iArr3[DivAccessibility.Type.HEADER.ordinal()] = 7;
            } catch (NoSuchFieldError unused23) {
            }
            try {
                iArr3[DivAccessibility.Type.LIST.ordinal()] = 8;
            } catch (NoSuchFieldError unused24) {
            }
            try {
                iArr3[DivAccessibility.Type.SELECT.ordinal()] = 9;
            } catch (NoSuchFieldError unused25) {
            }
            try {
                iArr3[DivAccessibility.Type.TAB_BAR.ordinal()] = 10;
            } catch (NoSuchFieldError unused26) {
            }
            try {
                iArr3[DivAccessibility.Type.RADIO.ordinal()] = 11;
            } catch (NoSuchFieldError unused27) {
            }
            try {
                iArr3[DivAccessibility.Type.CHECKBOX.ordinal()] = 12;
            } catch (NoSuchFieldError unused28) {
            }
            $EnumSwitchMapping$2 = iArr3;
        }
    }

    @Inject
    public DivAccessibilityBinder(@ExperimentFlag(experiment = Experiment.ACCESSIBILITY_ENABLED) boolean z, AccessibilityStateProvider accessibilityStateProvider) {
        Intrinsics.checkNotNullParameter(accessibilityStateProvider, "accessibilityStateProvider");
        this.enabled = z;
        this.accessibilityStateProvider = accessibilityStateProvider;
    }

    public boolean getEnabled() {
        return this.enabled;
    }

    public void bindAccessibilityMode(View view, Div2View divView, DivAccessibility.Mode mode, DivBase divBase) {
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(divView, "divView");
        Intrinsics.checkNotNullParameter(divBase, "divBase");
        if (getEnabled()) {
            Object parent = view.getParent();
            View view2 = parent instanceof View ? (View) parent : null;
            DivAccessibility.Mode propagatedAccessibilityMode$div_release = view2 != null ? divView.getPropagatedAccessibilityMode$div_release(view2) : null;
            if (propagatedAccessibilityMode$div_release == null) {
                if (mode == null) {
                    mode = getGetDefaultAccessibilityMode(divBase);
                }
                applyAccessibilityMode(view, mode, divView, false);
            } else {
                if (mode == null) {
                    mode = getGetDefaultAccessibilityMode(divBase);
                }
                DivAccessibility.Mode propagatedMode = getPropagatedMode(propagatedAccessibilityMode$div_release, mode);
                applyAccessibilityMode(view, propagatedMode, divView, propagatedAccessibilityMode$div_release == propagatedMode);
            }
        }
    }

    public void bindType(View view, DivBase divBase, DivAccessibility.Type type, ExpressionResolver resolver) {
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(divBase, "divBase");
        Intrinsics.checkNotNullParameter(type, "type");
        Intrinsics.checkNotNullParameter(resolver, "resolver");
        AccessibilityStateProvider accessibilityStateProvider = this.accessibilityStateProvider;
        Context context = view.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "view.context");
        if (accessibilityStateProvider.isAccessibilityEnabled(context)) {
            AccessibilityDelegateWrapper accessibilityDelegate = ViewCompat.getAccessibilityDelegate(view);
            final AccessibilityType accessibilityType = toAccessibilityType(type, divBase, resolver);
            if (accessibilityType == AccessibilityType.LIST && (view instanceof BackHandlingRecyclerView)) {
                accessibilityDelegate = new AccessibilityListDelegate((BackHandlingRecyclerView) view);
            } else if (accessibilityDelegate instanceof AccessibilityDelegateWrapper) {
                ((AccessibilityDelegateWrapper) accessibilityDelegate).setInitializeAccessibilityNodeInfo(new Function2<View, AccessibilityNodeInfoCompat, Unit>() { // from class: com.yandex.div.core.view2.DivAccessibilityBinder$bindType$accessibilityDelegate$1$1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(2);
                    }

                    @Override // kotlin.jvm.functions.Function2
                    public /* bridge */ /* synthetic */ Unit invoke(View view2, AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
                        invoke2(view2, accessibilityNodeInfoCompat);
                        return Unit.INSTANCE;
                    }

                    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(View view2, AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
                        if (accessibilityNodeInfoCompat != null) {
                            this.this$0.bindType(accessibilityNodeInfoCompat, accessibilityType);
                        }
                    }
                });
            } else {
                accessibilityDelegate = new AccessibilityDelegateWrapper(accessibilityDelegate, new Function2<View, AccessibilityNodeInfoCompat, Unit>() { // from class: com.yandex.div.core.view2.DivAccessibilityBinder$bindType$accessibilityDelegate$2
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(2);
                    }

                    @Override // kotlin.jvm.functions.Function2
                    public /* bridge */ /* synthetic */ Unit invoke(View view2, AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
                        invoke2(view2, accessibilityNodeInfoCompat);
                        return Unit.INSTANCE;
                    }

                    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(View view2, AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
                        if (accessibilityNodeInfoCompat != null) {
                            this.this$0.bindType(accessibilityNodeInfoCompat, accessibilityType);
                        }
                    }
                }, null, 4, null);
            }
            ViewCompat.setAccessibilityDelegate(view, accessibilityDelegate);
        }
    }

    private DivAccessibility.Mode getGetDefaultAccessibilityMode(DivBase divBase) {
        DivSeparator divSeparator;
        List<DivAction> list;
        List<DivAction> list2;
        List<DivAction> list3;
        DivImage divImage;
        List<DivAction> list4;
        List<DivAction> list5;
        List<DivAction> list6;
        if (divBase instanceof DivImage) {
            if (divBase.getAccessibility() == null && (((list4 = (divImage = (DivImage) divBase).doubletapActions) == null || list4.isEmpty()) && (((list5 = divImage.actions) == null || list5.isEmpty()) && ((list6 = divImage.longtapActions) == null || list6.isEmpty())))) {
                return DivAccessibility.Mode.EXCLUDE;
            }
            return DivAccessibility.Mode.DEFAULT;
        }
        if (!(divBase instanceof DivSeparator)) {
            return DivAccessibility.Mode.DEFAULT;
        }
        if (divBase.getAccessibility() == null && (((list = (divSeparator = (DivSeparator) divBase).doubletapActions) == null || list.isEmpty()) && (((list2 = divSeparator.actions) == null || list2.isEmpty()) && ((list3 = divSeparator.longtapActions) == null || list3.isEmpty())))) {
            return DivAccessibility.Mode.EXCLUDE;
        }
        return DivAccessibility.Mode.DEFAULT;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bindType(AccessibilityNodeInfoCompat accessibilityNodeInfoCompat, AccessibilityType accessibilityType) {
        CharSequence charSequence;
        switch (WhenMappings.$EnumSwitchMapping$0[accessibilityType.ordinal()]) {
            case 1:
                break;
            case 2:
                break;
            case 3:
                break;
            case 4:
                break;
            case 5:
                break;
            case 6:
                break;
            case 7:
                break;
            case 8:
                break;
            case 9:
                break;
            case 10:
                break;
            case 11:
                break;
            case 12:
                break;
            case 13:
                break;
            default:
                throw new NoWhenBranchMatchedException();
        }
        accessibilityNodeInfoCompat.setClassName(charSequence);
        if (AccessibilityType.HEADER == accessibilityType) {
            accessibilityNodeInfoCompat.setHeading(true);
        }
    }

    private int getPriority(DivAccessibility.Mode mode) {
        int i = WhenMappings.$EnumSwitchMapping$1[mode.ordinal()];
        if (i == 1) {
            return 0;
        }
        if (i == 2) {
            return 1;
        }
        if (i == 3) {
            return 2;
        }
        throw new NoWhenBranchMatchedException();
    }

    private DivAccessibility.Mode getPropagatedMode(DivAccessibility.Mode parentMode, DivAccessibility.Mode mode) {
        return getPriority(parentMode) < getPriority(mode) ? parentMode : mode;
    }

    private void applyAccessibilityMode(View view, DivAccessibility.Mode mode, Div2View div2View, boolean z) {
        int i = WhenMappings.$EnumSwitchMapping$1[mode.ordinal()];
        if (i == 1) {
            view.setImportantForAccessibility(4);
            view.setFocusable(false);
            if (view instanceof DivInputView) {
                ((DivInputView) view).setFocusableInTouchMode(true);
            }
        } else if (i == 2) {
            view.setImportantForAccessibility(1);
            if (!z) {
                view.setFocusable(!(view instanceof DivSliderView));
            } else {
                setActionable(view, false);
            }
        } else if (i == 3) {
            view.setImportantForAccessibility(0);
            view.setFocusable(!(view instanceof DivSliderView));
        }
        div2View.setPropagatedAccessibilityMode$div_release(view, mode);
    }

    private void setActionable(View view, boolean z) {
        view.setClickable(z);
        view.setLongClickable(z);
        view.setFocusable(z);
    }

    private boolean isClickable(DivImage divImage, ExpressionResolver expressionResolver) {
        List<DivAction> list;
        List<DivAction> list2;
        DivAction divAction;
        Expression<Boolean> expression;
        if (divImage.action != null && (divAction = divImage.action) != null && (expression = divAction.isEnabled) != null && expression.evaluate(expressionResolver).booleanValue()) {
            return true;
        }
        if (divImage.actions != null && (list2 = divImage.actions) != null) {
            List<DivAction> list3 = list2;
            if (!(list3 instanceof Collection) || !list3.isEmpty()) {
                Iterator<T> it = list3.iterator();
                while (it.hasNext()) {
                    if (((DivAction) it.next()).isEnabled.evaluate(expressionResolver).booleanValue()) {
                        return true;
                    }
                }
            }
        }
        if (divImage.longtapActions != null && (list = divImage.longtapActions) != null) {
            List<DivAction> list4 = list;
            if (!(list4 instanceof Collection) || !list4.isEmpty()) {
                Iterator<T> it2 = list4.iterator();
                while (it2.hasNext()) {
                    if (((DivAction) it2.next()).isEnabled.evaluate(expressionResolver).booleanValue()) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    private AccessibilityType toAccessibilityType(DivAccessibility.Type type, DivBase divBase, ExpressionResolver expressionResolver) {
        Expression<DivAccessibility.Mode> expression;
        switch (WhenMappings.$EnumSwitchMapping$2[type.ordinal()]) {
            case 1:
                DivAccessibility accessibility = divBase.getAccessibility();
                if (((accessibility == null || (expression = accessibility.mode) == null) ? null : expression.evaluate(expressionResolver)) == DivAccessibility.Mode.EXCLUDE) {
                    return AccessibilityType.NONE;
                }
                if (divBase instanceof DivInput) {
                    return AccessibilityType.EDIT_TEXT;
                }
                if (divBase instanceof DivText) {
                    return AccessibilityType.TEXT;
                }
                if (divBase instanceof DivTabs) {
                    return AccessibilityType.TAB_WIDGET;
                }
                if (divBase instanceof DivSelect) {
                    return AccessibilityType.SELECT;
                }
                if (divBase instanceof DivSlider) {
                    return AccessibilityType.SLIDER;
                }
                if ((divBase instanceof DivImage) && (divBase.getAccessibility() != null || isClickable((DivImage) divBase, expressionResolver))) {
                    return AccessibilityType.IMAGE;
                }
                if (divBase instanceof DivGallery) {
                    DivAccessibility accessibility2 = divBase.getAccessibility();
                    if ((accessibility2 != null ? accessibility2.description : null) != null) {
                        return AccessibilityType.PAGER;
                    }
                }
                if (divBase instanceof RadioButton) {
                    return AccessibilityType.RADIO_BUTTON;
                }
                return divBase instanceof CheckBox ? AccessibilityType.CHECK_BOX : AccessibilityType.NONE;
            case 2:
                return AccessibilityType.NONE;
            case 3:
                return AccessibilityType.BUTTON;
            case 4:
                return AccessibilityType.IMAGE;
            case 5:
                return AccessibilityType.TEXT;
            case 6:
                return AccessibilityType.EDIT_TEXT;
            case 7:
                return AccessibilityType.HEADER;
            case 8:
                return AccessibilityType.LIST;
            case 9:
                return AccessibilityType.SELECT;
            case 10:
                return AccessibilityType.TAB_WIDGET;
            case 11:
                return AccessibilityType.RADIO_BUTTON;
            case 12:
                return AccessibilityType.CHECK_BOX;
            default:
                throw new NoWhenBranchMatchedException();
        }
    }
}
