package com.yandex.div2;

import androidx.compose.material.OutlinedTextFieldKt;
import com.yandex.div.json.expressions.Expression;
import io.appmetrica.analytics.impl.J2;
import java.util.List;
import kotlin.Metadata;

/* JADX INFO: compiled from: DivBase.kt */
/* JADX INFO: loaded from: classes12.dex */
@Metadata(d1 = {"\u0000â\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0006\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\bf\u0018\u00002\u00020\u0001R\u0014\u0010\u0002\u001a\u0004\u0018\u00010\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005R\u001a\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007X¦\u0004¢\u0006\u0006\u001a\u0004\b\t\u0010\nR\u001a\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u0007X¦\u0004¢\u0006\u0006\u001a\u0004\b\r\u0010\nR\u0018\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u000f0\u0007X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0010\u0010\nR\u001a\u0010\u0011\u001a\n\u0012\u0004\u0012\u00020\u0013\u0018\u00010\u0012X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0014\u0010\u0015R\u001a\u0010\u0016\u001a\n\u0012\u0004\u0012\u00020\u0017\u0018\u00010\u0012X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0018\u0010\u0015R\u0014\u0010\u0019\u001a\u0004\u0018\u00010\u001aX¦\u0004¢\u0006\u0006\u001a\u0004\b\u001b\u0010\u001cR\u001a\u0010\u001d\u001a\n\u0012\u0004\u0012\u00020\u001e\u0018\u00010\u0007X¦\u0004¢\u0006\u0006\u001a\u0004\b\u001f\u0010\nR\u001a\u0010 \u001a\n\u0012\u0004\u0012\u00020!\u0018\u00010\u0012X¦\u0004¢\u0006\u0006\u001a\u0004\b\"\u0010\u0015R\u001a\u0010#\u001a\n\u0012\u0004\u0012\u00020$\u0018\u00010\u0012X¦\u0004¢\u0006\u0006\u001a\u0004\b%\u0010\u0015R\u0014\u0010&\u001a\u0004\u0018\u00010'X¦\u0004¢\u0006\u0006\u001a\u0004\b(\u0010)R\u001a\u0010*\u001a\n\u0012\u0004\u0012\u00020+\u0018\u00010\u0012X¦\u0004¢\u0006\u0006\u001a\u0004\b,\u0010\u0015R\u0012\u0010-\u001a\u00020.X¦\u0004¢\u0006\u0006\u001a\u0004\b/\u00100R\u0014\u00101\u001a\u0004\u0018\u000102X¦\u0004¢\u0006\u0006\u001a\u0004\b3\u00104R\u0014\u00105\u001a\u0004\u0018\u000106X¦\u0004¢\u0006\u0006\u001a\u0004\b7\u00108R\u0014\u00109\u001a\u0004\u0018\u00010:X¦\u0004¢\u0006\u0006\u001a\u0004\b;\u0010<R\u0014\u0010=\u001a\u0004\u0018\u00010:X¦\u0004¢\u0006\u0006\u001a\u0004\b>\u0010<R\u001a\u0010?\u001a\n\u0012\u0004\u0012\u000202\u0018\u00010\u0007X¦\u0004¢\u0006\u0006\u001a\u0004\b@\u0010\nR\u001a\u0010A\u001a\n\u0012\u0004\u0012\u00020\u001e\u0018\u00010\u0007X¦\u0004¢\u0006\u0006\u001a\u0004\bB\u0010\nR\u001a\u0010C\u001a\n\u0012\u0004\u0012\u00020D\u0018\u00010\u0012X¦\u0004¢\u0006\u0006\u001a\u0004\bE\u0010\u0015R\u001a\u0010F\u001a\n\u0012\u0004\u0012\u00020G\u0018\u00010\u0012X¦\u0004¢\u0006\u0006\u001a\u0004\bH\u0010\u0015R\u0014\u0010I\u001a\u0004\u0018\u00010JX¦\u0004¢\u0006\u0006\u001a\u0004\bK\u0010LR\u0014\u0010M\u001a\u0004\u0018\u00010NX¦\u0004¢\u0006\u0006\u001a\u0004\bO\u0010PR\u0014\u0010Q\u001a\u0004\u0018\u00010RX¦\u0004¢\u0006\u0006\u001a\u0004\bS\u0010TR\u0014\u0010U\u001a\u0004\u0018\u00010RX¦\u0004¢\u0006\u0006\u001a\u0004\bV\u0010TR\u001a\u0010W\u001a\n\u0012\u0004\u0012\u00020X\u0018\u00010\u0012X¦\u0004¢\u0006\u0006\u001a\u0004\bY\u0010\u0015R\u001a\u0010Z\u001a\n\u0012\u0004\u0012\u00020[\u0018\u00010\u0012X¦\u0004¢\u0006\u0006\u001a\u0004\b\\\u0010\u0015R\u001a\u0010]\u001a\n\u0012\u0004\u0012\u00020^\u0018\u00010\u0012X¦\u0004¢\u0006\u0006\u001a\u0004\b_\u0010\u0015R\u0018\u0010`\u001a\b\u0012\u0004\u0012\u00020a0\u0007X¦\u0004¢\u0006\u0006\u001a\u0004\bb\u0010\nR\u0014\u0010c\u001a\u0004\u0018\u00010dX¦\u0004¢\u0006\u0006\u001a\u0004\be\u0010fR\u001a\u0010g\u001a\n\u0012\u0004\u0012\u00020d\u0018\u00010\u0012X¦\u0004¢\u0006\u0006\u001a\u0004\bh\u0010\u0015R\u0012\u0010i\u001a\u00020.X¦\u0004¢\u0006\u0006\u001a\u0004\bj\u00100ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006kÀ\u0006\u0001"}, d2 = {"Lcom/yandex/div2/DivBase;", "", "accessibility", "Lcom/yandex/div2/DivAccessibility;", "getAccessibility", "()Lcom/yandex/div2/DivAccessibility;", "alignmentHorizontal", "Lcom/yandex/div/json/expressions/Expression;", "Lcom/yandex/div2/DivAlignmentHorizontal;", "getAlignmentHorizontal", "()Lcom/yandex/div/json/expressions/Expression;", "alignmentVertical", "Lcom/yandex/div2/DivAlignmentVertical;", "getAlignmentVertical", "alpha", "", "getAlpha", "animators", "", "Lcom/yandex/div2/DivAnimator;", "getAnimators", "()Ljava/util/List;", J2.g, "Lcom/yandex/div2/DivBackground;", "getBackground", OutlinedTextFieldKt.BorderId, "Lcom/yandex/div2/DivBorder;", "getBorder", "()Lcom/yandex/div2/DivBorder;", "columnSpan", "", "getColumnSpan", "disappearActions", "Lcom/yandex/div2/DivDisappearAction;", "getDisappearActions", "extensions", "Lcom/yandex/div2/DivExtension;", "getExtensions", "focus", "Lcom/yandex/div2/DivFocus;", "getFocus", "()Lcom/yandex/div2/DivFocus;", "functions", "Lcom/yandex/div2/DivFunction;", "getFunctions", "height", "Lcom/yandex/div2/DivSize;", "getHeight", "()Lcom/yandex/div2/DivSize;", "id", "", "getId", "()Ljava/lang/String;", "layoutProvider", "Lcom/yandex/div2/DivLayoutProvider;", "getLayoutProvider", "()Lcom/yandex/div2/DivLayoutProvider;", "margins", "Lcom/yandex/div2/DivEdgeInsets;", "getMargins", "()Lcom/yandex/div2/DivEdgeInsets;", "paddings", "getPaddings", "reuseId", "getReuseId", "rowSpan", "getRowSpan", "selectedActions", "Lcom/yandex/div2/DivAction;", "getSelectedActions", "tooltips", "Lcom/yandex/div2/DivTooltip;", "getTooltips", "transform", "Lcom/yandex/div2/DivTransform;", "getTransform", "()Lcom/yandex/div2/DivTransform;", "transitionChange", "Lcom/yandex/div2/DivChangeTransition;", "getTransitionChange", "()Lcom/yandex/div2/DivChangeTransition;", "transitionIn", "Lcom/yandex/div2/DivAppearanceTransition;", "getTransitionIn", "()Lcom/yandex/div2/DivAppearanceTransition;", "transitionOut", "getTransitionOut", "transitionTriggers", "Lcom/yandex/div2/DivTransitionTrigger;", "getTransitionTriggers", "variableTriggers", "Lcom/yandex/div2/DivTrigger;", "getVariableTriggers", "variables", "Lcom/yandex/div2/DivVariable;", "getVariables", "visibility", "Lcom/yandex/div2/DivVisibility;", "getVisibility", "visibilityAction", "Lcom/yandex/div2/DivVisibilityAction;", "getVisibilityAction", "()Lcom/yandex/div2/DivVisibilityAction;", "visibilityActions", "getVisibilityActions", "width", "getWidth", "div-data_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public interface DivBase {
    DivAccessibility getAccessibility();

    Expression<DivAlignmentHorizontal> getAlignmentHorizontal();

    Expression<DivAlignmentVertical> getAlignmentVertical();

    Expression<Double> getAlpha();

    List<DivAnimator> getAnimators();

    List<DivBackground> getBackground();

    DivBorder getBorder();

    Expression<Long> getColumnSpan();

    List<DivDisappearAction> getDisappearActions();

    List<DivExtension> getExtensions();

    DivFocus getFocus();

    List<DivFunction> getFunctions();

    DivSize getHeight();

    String getId();

    DivLayoutProvider getLayoutProvider();

    DivEdgeInsets getMargins();

    DivEdgeInsets getPaddings();

    Expression<String> getReuseId();

    Expression<Long> getRowSpan();

    List<DivAction> getSelectedActions();

    List<DivTooltip> getTooltips();

    DivTransform getTransform();

    DivChangeTransition getTransitionChange();

    DivAppearanceTransition getTransitionIn();

    DivAppearanceTransition getTransitionOut();

    List<DivTransitionTrigger> getTransitionTriggers();

    List<DivTrigger> getVariableTriggers();

    List<DivVariable> getVariables();

    Expression<DivVisibility> getVisibility();

    DivVisibilityAction getVisibilityAction();

    List<DivVisibilityAction> getVisibilityActions();

    DivSize getWidth();
}
