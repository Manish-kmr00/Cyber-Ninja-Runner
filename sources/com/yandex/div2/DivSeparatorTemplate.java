package com.yandex.div2;

import androidx.compose.material.OutlinedTextFieldKt;
import com.json.cc;
import com.yandex.div.core.view2.divs.widgets.DivSeparatorView;
import com.yandex.div.internal.template.Field;
import com.yandex.div.json.JSONSerializable;
import com.yandex.div.json.JsonTemplate;
import com.yandex.div.json.ParsingEnvironment;
import com.yandex.div.json.expressions.Expression;
import com.yandex.div.serialization.BuiltInParserKt;
import com.yandex.div.serialization.ParsingContext;
import io.appmetrica.analytics.impl.J2;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: compiled from: DivSeparatorTemplate.kt */
/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000ê\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0006\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 Y2\u00020\u00012\b\u0012\u0004\u0012\u00020\u00030\u0002:\u0002YZBé\u0005\b\u0016\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\b0\u0005\u0012\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\n0\u0005\u0012\u0012\u0010\u000b\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\f0\u0005\u0012\u0012\u0010\r\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000f0\u000e0\u0005\u0012\u0012\u0010\u0010\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00110\u000e0\u0005\u0012\u0012\u0010\u0012\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00130\u000e0\u0005\u0012\u0012\u0010\u0014\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00150\f0\u0005\u0012\u0012\u0010\u0016\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00170\f0\u0005\u0012\f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00190\u0005\u0012\u0012\u0010\u001a\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001b0\u000e0\u0005\u0012\f\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u001d0\u0005\u0012\u0012\u0010\u001e\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001f0\f0\u0005\u0012\u0012\u0010 \u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\f0\u0005\u0012\u0012\u0010!\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\"0\f0\u0005\u0012\f\u0010#\u001a\b\u0012\u0004\u0012\u00020$0\u0005\u0012\u0012\u0010%\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020&0\f0\u0005\u0012\f\u0010'\u001a\b\u0012\u0004\u0012\u00020(0\u0005\u0012\u0012\u0010)\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\f0\u0005\u0012\u0012\u0010*\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\f0\u0005\u0012\f\u0010+\u001a\b\u0012\u0004\u0012\u00020,0\u0005\u0012\f\u0010-\u001a\b\u0012\u0004\u0012\u00020.0\u0005\u0012\u0012\u0010/\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\f0\u0005\u0012\f\u00100\u001a\b\u0012\u0004\u0012\u0002010\u0005\u0012\f\u00102\u001a\b\u0012\u0004\u0012\u0002010\u0005\u0012\u0012\u00103\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\f0\u0005\u0012\u0012\u00104\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\f0\u0005\u0012\u0012\u00105\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020,0\u000e0\u0005\u0012\u0012\u00106\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001b0\u000e0\u0005\u0012\u0012\u00107\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\f0\u0005\u0012\u0012\u00108\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002090\f0\u0005\u0012\f\u0010:\u001a\b\u0012\u0004\u0012\u00020;0\u0005\u0012\f\u0010<\u001a\b\u0012\u0004\u0012\u00020=0\u0005\u0012\f\u0010>\u001a\b\u0012\u0004\u0012\u00020?0\u0005\u0012\f\u0010@\u001a\b\u0012\u0004\u0012\u00020?0\u0005\u0012\u0012\u0010A\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020B0\f0\u0005\u0012\u0012\u0010C\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020D0\f0\u0005\u0012\u0012\u0010E\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020F0\f0\u0005\u0012\u0012\u0010G\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020H0\u000e0\u0005\u0012\f\u0010I\u001a\b\u0012\u0004\u0012\u00020J0\u0005\u0012\u0012\u0010K\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020J0\f0\u0005\u0012\f\u0010L\u001a\b\u0012\u0004\u0012\u00020(0\u0005¢\u0006\u0002\u0010MB-\b\u0016\u0012\u0006\u0010N\u001a\u00020O\u0012\n\b\u0002\u0010P\u001a\u0004\u0018\u00010\u0000\u0012\b\b\u0002\u0010Q\u001a\u00020R\u0012\u0006\u0010S\u001a\u00020T¢\u0006\u0002\u0010UJ\u0018\u0010V\u001a\u00020\u00032\u0006\u0010N\u001a\u00020O2\u0006\u0010W\u001a\u00020TH\u0016J\b\u0010X\u001a\u00020TH\u0016R\u0016\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u00058\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\b0\u00058\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\t\u001a\b\u0012\u0004\u0012\u00020\n0\u00058\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\u000b\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\f0\u00058\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\r\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000f0\u000e0\u00058\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\u0010\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00110\u000e0\u00058\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\u0012\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00130\u000e0\u00058\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\u0014\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00150\f0\u00058\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\u0016\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00170\f0\u00058\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00190\u00058\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\u001a\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001b0\u000e0\u00058\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u001d0\u00058\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\u001e\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001f0\f0\u00058\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u001c\u0010 \u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\f0\u00058\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u001c\u0010!\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\"0\f0\u00058\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0016\u0010#\u001a\b\u0012\u0004\u0012\u00020$0\u00058\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u001c\u0010%\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020&0\f0\u00058\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0016\u0010'\u001a\b\u0012\u0004\u0012\u00020(0\u00058\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u001c\u0010)\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\f0\u00058\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u001c\u0010*\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\f0\u00058\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0016\u0010+\u001a\b\u0012\u0004\u0012\u00020,0\u00058\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0016\u0010-\u001a\b\u0012\u0004\u0012\u00020.0\u00058\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u001c\u0010/\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\f0\u00058\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0016\u00100\u001a\b\u0012\u0004\u0012\u0002010\u00058\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0016\u00102\u001a\b\u0012\u0004\u0012\u0002010\u00058\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u001c\u00103\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\f0\u00058\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u001c\u00104\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\f0\u00058\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u001c\u00105\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020,0\u000e0\u00058\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u001c\u00106\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001b0\u000e0\u00058\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u001c\u00107\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\f0\u00058\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u001c\u00108\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002090\f0\u00058\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0016\u0010:\u001a\b\u0012\u0004\u0012\u00020;0\u00058\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0016\u0010<\u001a\b\u0012\u0004\u0012\u00020=0\u00058\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0016\u0010>\u001a\b\u0012\u0004\u0012\u00020?0\u00058\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0016\u0010@\u001a\b\u0012\u0004\u0012\u00020?0\u00058\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u001c\u0010A\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020B0\f0\u00058\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u001c\u0010C\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020D0\f0\u00058\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u001c\u0010E\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020F0\f0\u00058\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u001c\u0010G\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020H0\u000e0\u00058\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0016\u0010I\u001a\b\u0012\u0004\u0012\u00020J0\u00058\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u001c\u0010K\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020J0\f0\u00058\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0016\u0010L\u001a\b\u0012\u0004\u0012\u00020(0\u00058\u0006X\u0087\u0004¢\u0006\u0002\n\u0000¨\u0006["}, d2 = {"Lcom/yandex/div2/DivSeparatorTemplate;", "Lcom/yandex/div/json/JSONSerializable;", "Lcom/yandex/div/json/JsonTemplate;", "Lcom/yandex/div2/DivSeparator;", "accessibility", "Lcom/yandex/div/internal/template/Field;", "Lcom/yandex/div2/DivAccessibilityTemplate;", "action", "Lcom/yandex/div2/DivActionTemplate;", "actionAnimation", "Lcom/yandex/div2/DivAnimationTemplate;", "actions", "", "alignmentHorizontal", "Lcom/yandex/div/json/expressions/Expression;", "Lcom/yandex/div2/DivAlignmentHorizontal;", "alignmentVertical", "Lcom/yandex/div2/DivAlignmentVertical;", "alpha", "", "animators", "Lcom/yandex/div2/DivAnimatorTemplate;", J2.g, "Lcom/yandex/div2/DivBackgroundTemplate;", OutlinedTextFieldKt.BorderId, "Lcom/yandex/div2/DivBorderTemplate;", "columnSpan", "", "delimiterStyle", "Lcom/yandex/div2/DivSeparatorTemplate$DelimiterStyleTemplate;", "disappearActions", "Lcom/yandex/div2/DivDisappearActionTemplate;", "doubletapActions", "extensions", "Lcom/yandex/div2/DivExtensionTemplate;", "focus", "Lcom/yandex/div2/DivFocusTemplate;", "functions", "Lcom/yandex/div2/DivFunctionTemplate;", "height", "Lcom/yandex/div2/DivSizeTemplate;", "hoverEndActions", "hoverStartActions", "id", "", "layoutProvider", "Lcom/yandex/div2/DivLayoutProviderTemplate;", "longtapActions", "margins", "Lcom/yandex/div2/DivEdgeInsetsTemplate;", "paddings", "pressEndActions", "pressStartActions", "reuseId", "rowSpan", "selectedActions", "tooltips", "Lcom/yandex/div2/DivTooltipTemplate;", "transform", "Lcom/yandex/div2/DivTransformTemplate;", "transitionChange", "Lcom/yandex/div2/DivChangeTransitionTemplate;", "transitionIn", "Lcom/yandex/div2/DivAppearanceTransitionTemplate;", "transitionOut", "transitionTriggers", "Lcom/yandex/div2/DivTransitionTrigger;", "variableTriggers", "Lcom/yandex/div2/DivTriggerTemplate;", "variables", "Lcom/yandex/div2/DivVariableTemplate;", "visibility", "Lcom/yandex/div2/DivVisibility;", "visibilityAction", "Lcom/yandex/div2/DivVisibilityActionTemplate;", "visibilityActions", "width", "(Lcom/yandex/div/internal/template/Field;Lcom/yandex/div/internal/template/Field;Lcom/yandex/div/internal/template/Field;Lcom/yandex/div/internal/template/Field;Lcom/yandex/div/internal/template/Field;Lcom/yandex/div/internal/template/Field;Lcom/yandex/div/internal/template/Field;Lcom/yandex/div/internal/template/Field;Lcom/yandex/div/internal/template/Field;Lcom/yandex/div/internal/template/Field;Lcom/yandex/div/internal/template/Field;Lcom/yandex/div/internal/template/Field;Lcom/yandex/div/internal/template/Field;Lcom/yandex/div/internal/template/Field;Lcom/yandex/div/internal/template/Field;Lcom/yandex/div/internal/template/Field;Lcom/yandex/div/internal/template/Field;Lcom/yandex/div/internal/template/Field;Lcom/yandex/div/internal/template/Field;Lcom/yandex/div/internal/template/Field;Lcom/yandex/div/internal/template/Field;Lcom/yandex/div/internal/template/Field;Lcom/yandex/div/internal/template/Field;Lcom/yandex/div/internal/template/Field;Lcom/yandex/div/internal/template/Field;Lcom/yandex/div/internal/template/Field;Lcom/yandex/div/internal/template/Field;Lcom/yandex/div/internal/template/Field;Lcom/yandex/div/internal/template/Field;Lcom/yandex/div/internal/template/Field;Lcom/yandex/div/internal/template/Field;Lcom/yandex/div/internal/template/Field;Lcom/yandex/div/internal/template/Field;Lcom/yandex/div/internal/template/Field;Lcom/yandex/div/internal/template/Field;Lcom/yandex/div/internal/template/Field;Lcom/yandex/div/internal/template/Field;Lcom/yandex/div/internal/template/Field;Lcom/yandex/div/internal/template/Field;Lcom/yandex/div/internal/template/Field;Lcom/yandex/div/internal/template/Field;Lcom/yandex/div/internal/template/Field;)V", cc.o, "Lcom/yandex/div/json/ParsingEnvironment;", "parent", "topLevel", "", "json", "Lorg/json/JSONObject;", "(Lcom/yandex/div/json/ParsingEnvironment;Lcom/yandex/div2/DivSeparatorTemplate;ZLorg/json/JSONObject;)V", "resolve", "data", "writeToJSON", "Companion", "DelimiterStyleTemplate", "div-data_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class DivSeparatorTemplate implements JSONSerializable, JsonTemplate<DivSeparator> {
    private static final DivAnimation ACTION_ANIMATION_DEFAULT_VALUE;
    private static final Expression<Double> ALPHA_DEFAULT_VALUE;
    private static final Function2<ParsingEnvironment, JSONObject, DivSeparatorTemplate> CREATOR;

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final DivSize.WrapContent HEIGHT_DEFAULT_VALUE;
    public static final String TYPE = "separator";
    private static final Expression<DivVisibility> VISIBILITY_DEFAULT_VALUE;
    private static final DivSize.MatchParent WIDTH_DEFAULT_VALUE;
    public final Field<DivAccessibilityTemplate> accessibility;
    public final Field<DivActionTemplate> action;
    public final Field<DivAnimationTemplate> actionAnimation;
    public final Field<List<DivActionTemplate>> actions;
    public final Field<Expression<DivAlignmentHorizontal>> alignmentHorizontal;
    public final Field<Expression<DivAlignmentVertical>> alignmentVertical;
    public final Field<Expression<Double>> alpha;
    public final Field<List<DivAnimatorTemplate>> animators;
    public final Field<List<DivBackgroundTemplate>> background;
    public final Field<DivBorderTemplate> border;
    public final Field<Expression<Long>> columnSpan;
    public final Field<DelimiterStyleTemplate> delimiterStyle;
    public final Field<List<DivDisappearActionTemplate>> disappearActions;
    public final Field<List<DivActionTemplate>> doubletapActions;
    public final Field<List<DivExtensionTemplate>> extensions;
    public final Field<DivFocusTemplate> focus;
    public final Field<List<DivFunctionTemplate>> functions;
    public final Field<DivSizeTemplate> height;
    public final Field<List<DivActionTemplate>> hoverEndActions;
    public final Field<List<DivActionTemplate>> hoverStartActions;
    public final Field<String> id;
    public final Field<DivLayoutProviderTemplate> layoutProvider;
    public final Field<List<DivActionTemplate>> longtapActions;
    public final Field<DivEdgeInsetsTemplate> margins;
    public final Field<DivEdgeInsetsTemplate> paddings;
    public final Field<List<DivActionTemplate>> pressEndActions;
    public final Field<List<DivActionTemplate>> pressStartActions;
    public final Field<Expression<String>> reuseId;
    public final Field<Expression<Long>> rowSpan;
    public final Field<List<DivActionTemplate>> selectedActions;
    public final Field<List<DivTooltipTemplate>> tooltips;
    public final Field<DivTransformTemplate> transform;
    public final Field<DivChangeTransitionTemplate> transitionChange;
    public final Field<DivAppearanceTransitionTemplate> transitionIn;
    public final Field<DivAppearanceTransitionTemplate> transitionOut;
    public final Field<List<DivTransitionTrigger>> transitionTriggers;
    public final Field<List<DivTriggerTemplate>> variableTriggers;
    public final Field<List<DivVariableTemplate>> variables;
    public final Field<Expression<DivVisibility>> visibility;
    public final Field<DivVisibilityActionTemplate> visibilityAction;
    public final Field<List<DivVisibilityActionTemplate>> visibilityActions;
    public final Field<DivSizeTemplate> width;

    public DivSeparatorTemplate(Field<DivAccessibilityTemplate> accessibility, Field<DivActionTemplate> action, Field<DivAnimationTemplate> actionAnimation, Field<List<DivActionTemplate>> actions, Field<Expression<DivAlignmentHorizontal>> alignmentHorizontal, Field<Expression<DivAlignmentVertical>> alignmentVertical, Field<Expression<Double>> alpha, Field<List<DivAnimatorTemplate>> animators, Field<List<DivBackgroundTemplate>> background, Field<DivBorderTemplate> border, Field<Expression<Long>> columnSpan, Field<DelimiterStyleTemplate> delimiterStyle, Field<List<DivDisappearActionTemplate>> disappearActions, Field<List<DivActionTemplate>> doubletapActions, Field<List<DivExtensionTemplate>> extensions, Field<DivFocusTemplate> focus, Field<List<DivFunctionTemplate>> functions, Field<DivSizeTemplate> height, Field<List<DivActionTemplate>> hoverEndActions, Field<List<DivActionTemplate>> hoverStartActions, Field<String> id, Field<DivLayoutProviderTemplate> layoutProvider, Field<List<DivActionTemplate>> longtapActions, Field<DivEdgeInsetsTemplate> margins, Field<DivEdgeInsetsTemplate> paddings, Field<List<DivActionTemplate>> pressEndActions, Field<List<DivActionTemplate>> pressStartActions, Field<Expression<String>> reuseId, Field<Expression<Long>> rowSpan, Field<List<DivActionTemplate>> selectedActions, Field<List<DivTooltipTemplate>> tooltips, Field<DivTransformTemplate> transform, Field<DivChangeTransitionTemplate> transitionChange, Field<DivAppearanceTransitionTemplate> transitionIn, Field<DivAppearanceTransitionTemplate> transitionOut, Field<List<DivTransitionTrigger>> transitionTriggers, Field<List<DivTriggerTemplate>> variableTriggers, Field<List<DivVariableTemplate>> variables, Field<Expression<DivVisibility>> visibility, Field<DivVisibilityActionTemplate> visibilityAction, Field<List<DivVisibilityActionTemplate>> visibilityActions, Field<DivSizeTemplate> width) {
        Intrinsics.checkNotNullParameter(accessibility, "accessibility");
        Intrinsics.checkNotNullParameter(action, "action");
        Intrinsics.checkNotNullParameter(actionAnimation, "actionAnimation");
        Intrinsics.checkNotNullParameter(actions, "actions");
        Intrinsics.checkNotNullParameter(alignmentHorizontal, "alignmentHorizontal");
        Intrinsics.checkNotNullParameter(alignmentVertical, "alignmentVertical");
        Intrinsics.checkNotNullParameter(alpha, "alpha");
        Intrinsics.checkNotNullParameter(animators, "animators");
        Intrinsics.checkNotNullParameter(background, "background");
        Intrinsics.checkNotNullParameter(border, "border");
        Intrinsics.checkNotNullParameter(columnSpan, "columnSpan");
        Intrinsics.checkNotNullParameter(delimiterStyle, "delimiterStyle");
        Intrinsics.checkNotNullParameter(disappearActions, "disappearActions");
        Intrinsics.checkNotNullParameter(doubletapActions, "doubletapActions");
        Intrinsics.checkNotNullParameter(extensions, "extensions");
        Intrinsics.checkNotNullParameter(focus, "focus");
        Intrinsics.checkNotNullParameter(functions, "functions");
        Intrinsics.checkNotNullParameter(height, "height");
        Intrinsics.checkNotNullParameter(hoverEndActions, "hoverEndActions");
        Intrinsics.checkNotNullParameter(hoverStartActions, "hoverStartActions");
        Intrinsics.checkNotNullParameter(id, "id");
        Intrinsics.checkNotNullParameter(layoutProvider, "layoutProvider");
        Intrinsics.checkNotNullParameter(longtapActions, "longtapActions");
        Intrinsics.checkNotNullParameter(margins, "margins");
        Intrinsics.checkNotNullParameter(paddings, "paddings");
        Intrinsics.checkNotNullParameter(pressEndActions, "pressEndActions");
        Intrinsics.checkNotNullParameter(pressStartActions, "pressStartActions");
        Intrinsics.checkNotNullParameter(reuseId, "reuseId");
        Intrinsics.checkNotNullParameter(rowSpan, "rowSpan");
        Intrinsics.checkNotNullParameter(selectedActions, "selectedActions");
        Intrinsics.checkNotNullParameter(tooltips, "tooltips");
        Intrinsics.checkNotNullParameter(transform, "transform");
        Intrinsics.checkNotNullParameter(transitionChange, "transitionChange");
        Intrinsics.checkNotNullParameter(transitionIn, "transitionIn");
        Intrinsics.checkNotNullParameter(transitionOut, "transitionOut");
        Intrinsics.checkNotNullParameter(transitionTriggers, "transitionTriggers");
        Intrinsics.checkNotNullParameter(variableTriggers, "variableTriggers");
        Intrinsics.checkNotNullParameter(variables, "variables");
        Intrinsics.checkNotNullParameter(visibility, "visibility");
        Intrinsics.checkNotNullParameter(visibilityAction, "visibilityAction");
        Intrinsics.checkNotNullParameter(visibilityActions, "visibilityActions");
        Intrinsics.checkNotNullParameter(width, "width");
        this.accessibility = accessibility;
        this.action = action;
        this.actionAnimation = actionAnimation;
        this.actions = actions;
        this.alignmentHorizontal = alignmentHorizontal;
        this.alignmentVertical = alignmentVertical;
        this.alpha = alpha;
        this.animators = animators;
        this.background = background;
        this.border = border;
        this.columnSpan = columnSpan;
        this.delimiterStyle = delimiterStyle;
        this.disappearActions = disappearActions;
        this.doubletapActions = doubletapActions;
        this.extensions = extensions;
        this.focus = focus;
        this.functions = functions;
        this.height = height;
        this.hoverEndActions = hoverEndActions;
        this.hoverStartActions = hoverStartActions;
        this.id = id;
        this.layoutProvider = layoutProvider;
        this.longtapActions = longtapActions;
        this.margins = margins;
        this.paddings = paddings;
        this.pressEndActions = pressEndActions;
        this.pressStartActions = pressStartActions;
        this.reuseId = reuseId;
        this.rowSpan = rowSpan;
        this.selectedActions = selectedActions;
        this.tooltips = tooltips;
        this.transform = transform;
        this.transitionChange = transitionChange;
        this.transitionIn = transitionIn;
        this.transitionOut = transitionOut;
        this.transitionTriggers = transitionTriggers;
        this.variableTriggers = variableTriggers;
        this.variables = variables;
        this.visibility = visibility;
        this.visibilityAction = visibilityAction;
        this.visibilityActions = visibilityActions;
        this.width = width;
    }

    public /* synthetic */ DivSeparatorTemplate(ParsingEnvironment parsingEnvironment, DivSeparatorTemplate divSeparatorTemplate, boolean z, JSONObject jSONObject, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(parsingEnvironment, (i & 2) != 0 ? null : divSeparatorTemplate, (i & 4) != 0 ? false : z, jSONObject);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public DivSeparatorTemplate(ParsingEnvironment env, DivSeparatorTemplate divSeparatorTemplate, boolean z, JSONObject json) {
        this(Field.INSTANCE.nullField(false), Field.INSTANCE.nullField(false), Field.INSTANCE.nullField(false), Field.INSTANCE.nullField(false), Field.INSTANCE.nullField(false), Field.INSTANCE.nullField(false), Field.INSTANCE.nullField(false), Field.INSTANCE.nullField(false), Field.INSTANCE.nullField(false), Field.INSTANCE.nullField(false), Field.INSTANCE.nullField(false), Field.INSTANCE.nullField(false), Field.INSTANCE.nullField(false), Field.INSTANCE.nullField(false), Field.INSTANCE.nullField(false), Field.INSTANCE.nullField(false), Field.INSTANCE.nullField(false), Field.INSTANCE.nullField(false), Field.INSTANCE.nullField(false), Field.INSTANCE.nullField(false), Field.INSTANCE.nullField(false), Field.INSTANCE.nullField(false), Field.INSTANCE.nullField(false), Field.INSTANCE.nullField(false), Field.INSTANCE.nullField(false), Field.INSTANCE.nullField(false), Field.INSTANCE.nullField(false), Field.INSTANCE.nullField(false), Field.INSTANCE.nullField(false), Field.INSTANCE.nullField(false), Field.INSTANCE.nullField(false), Field.INSTANCE.nullField(false), Field.INSTANCE.nullField(false), Field.INSTANCE.nullField(false), Field.INSTANCE.nullField(false), Field.INSTANCE.nullField(false), Field.INSTANCE.nullField(false), Field.INSTANCE.nullField(false), Field.INSTANCE.nullField(false), Field.INSTANCE.nullField(false), Field.INSTANCE.nullField(false), Field.INSTANCE.nullField(false));
        Intrinsics.checkNotNullParameter(env, "env");
        Intrinsics.checkNotNullParameter(json, "json");
        throw new UnsupportedOperationException("Do not use this constructor directly.");
    }

    @Override // com.yandex.div.json.JsonTemplate
    public DivSeparator resolve(ParsingEnvironment env, JSONObject data) {
        Intrinsics.checkNotNullParameter(env, "env");
        Intrinsics.checkNotNullParameter(data, "data");
        return BuiltInParserKt.getBuiltInParserComponent().getDivSeparatorJsonTemplateResolver().getValue().resolve((ParsingContext) env, this, data);
    }

    @Override // com.yandex.div.json.JSONSerializable
    public JSONObject writeToJSON() {
        return BuiltInParserKt.getBuiltInParserComponent().getDivSeparatorJsonTemplateParser().getValue().serialize(BuiltInParserKt.getBuiltInParsingContext(), this);
    }

    /* JADX INFO: compiled from: DivSeparatorTemplate.kt */
    @Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0006\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R#\u0010\b\u001a\u0014\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\f0\t¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u000e\u0010\u000f\u001a\u00020\u0010X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X\u0086T¢\u0006\u0002\n\u0000R\u0014\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00140\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0016X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0017"}, d2 = {"Lcom/yandex/div2/DivSeparatorTemplate$Companion;", "", "()V", "ACTION_ANIMATION_DEFAULT_VALUE", "Lcom/yandex/div2/DivAnimation;", "ALPHA_DEFAULT_VALUE", "Lcom/yandex/div/json/expressions/Expression;", "", "CREATOR", "Lkotlin/Function2;", "Lcom/yandex/div/json/ParsingEnvironment;", "Lorg/json/JSONObject;", "Lcom/yandex/div2/DivSeparatorTemplate;", "getCREATOR", "()Lkotlin/jvm/functions/Function2;", "HEIGHT_DEFAULT_VALUE", "Lcom/yandex/div2/DivSize$WrapContent;", "TYPE", "", "VISIBILITY_DEFAULT_VALUE", "Lcom/yandex/div2/DivVisibility;", "WIDTH_DEFAULT_VALUE", "Lcom/yandex/div2/DivSize$MatchParent;", "div-data_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final Function2<ParsingEnvironment, JSONObject, DivSeparatorTemplate> getCREATOR() {
            return DivSeparatorTemplate.CREATOR;
        }
    }

    static {
        Expression expressionConstant = Expression.INSTANCE.constant(100L);
        Expression expressionConstant2 = Expression.INSTANCE.constant(Double.valueOf(0.6d));
        Expression expressionConstant3 = Expression.INSTANCE.constant(DivAnimation.Name.FADE);
        Expression.Companion companion = Expression.INSTANCE;
        Double dValueOf = Double.valueOf(1.0d);
        ACTION_ANIMATION_DEFAULT_VALUE = new DivAnimation(expressionConstant, expressionConstant2, null, null, expressionConstant3, null, null, companion.constant(dValueOf), 108, null);
        ALPHA_DEFAULT_VALUE = Expression.INSTANCE.constant(dValueOf);
        HEIGHT_DEFAULT_VALUE = new DivSize.WrapContent(new DivWrapContentSize(null, null, 0 == true ? 1 : 0, 7, null));
        VISIBILITY_DEFAULT_VALUE = Expression.INSTANCE.constant(DivVisibility.VISIBLE);
        WIDTH_DEFAULT_VALUE = new DivSize.MatchParent(new DivMatchParentSize(0 == true ? 1 : 0, 1, 0 == true ? 1 : 0));
        CREATOR = new Function2<ParsingEnvironment, JSONObject, DivSeparatorTemplate>() { // from class: com.yandex.div2.DivSeparatorTemplate$Companion$CREATOR$1
            @Override // kotlin.jvm.functions.Function2
            public final DivSeparatorTemplate invoke(ParsingEnvironment env, JSONObject it) {
                Intrinsics.checkNotNullParameter(env, "env");
                Intrinsics.checkNotNullParameter(it, "it");
                return new DivSeparatorTemplate(env, null, false, it, 6, null);
            }
        };
    }

    /* JADX INFO: compiled from: DivSeparatorTemplate.kt */
    @Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 \u00162\u00020\u00012\b\u0012\u0004\u0012\u00020\u00030\u0002:\u0001\u0016B/\b\u0016\u0012\u0012\u0010\u0004\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u00060\u0005\u0012\u0012\u0010\b\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0\u00060\u0005¢\u0006\u0002\u0010\nB-\b\u0016\u0012\u0006\u0010\u000b\u001a\u00020\f\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u0000\u0012\b\b\u0002\u0010\u000e\u001a\u00020\u000f\u0012\u0006\u0010\u0010\u001a\u00020\u0011¢\u0006\u0002\u0010\u0012J\u0018\u0010\u0013\u001a\u00020\u00032\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\u0014\u001a\u00020\u0011H\u0016J\b\u0010\u0015\u001a\u00020\u0011H\u0016R\u001c\u0010\u0004\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u00060\u00058\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\b\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0\u00060\u00058\u0006X\u0087\u0004¢\u0006\u0002\n\u0000¨\u0006\u0017"}, d2 = {"Lcom/yandex/div2/DivSeparatorTemplate$DelimiterStyleTemplate;", "Lcom/yandex/div/json/JSONSerializable;", "Lcom/yandex/div/json/JsonTemplate;", "Lcom/yandex/div2/DivSeparator$DelimiterStyle;", "color", "Lcom/yandex/div/internal/template/Field;", "Lcom/yandex/div/json/expressions/Expression;", "", "orientation", "Lcom/yandex/div2/DivSeparator$DelimiterStyle$Orientation;", "(Lcom/yandex/div/internal/template/Field;Lcom/yandex/div/internal/template/Field;)V", cc.o, "Lcom/yandex/div/json/ParsingEnvironment;", "parent", "topLevel", "", "json", "Lorg/json/JSONObject;", "(Lcom/yandex/div/json/ParsingEnvironment;Lcom/yandex/div2/DivSeparatorTemplate$DelimiterStyleTemplate;ZLorg/json/JSONObject;)V", "resolve", "data", "writeToJSON", "Companion", "div-data_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class DelimiterStyleTemplate implements JSONSerializable, JsonTemplate<DivSeparator.DelimiterStyle> {
        public final Field<Expression<Integer>> color;
        public final Field<Expression<DivSeparator.DelimiterStyle.Orientation>> orientation;

        /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
        public static final Companion INSTANCE = new Companion(null);
        private static final Expression<Integer> COLOR_DEFAULT_VALUE = Expression.INSTANCE.constant(Integer.valueOf(DivSeparatorView.DEFAULT_DIVIDER_COLOR));
        private static final Expression<DivSeparator.DelimiterStyle.Orientation> ORIENTATION_DEFAULT_VALUE = Expression.INSTANCE.constant(DivSeparator.DelimiterStyle.Orientation.HORIZONTAL);
        private static final Function2<ParsingEnvironment, JSONObject, DelimiterStyleTemplate> CREATOR = new Function2<ParsingEnvironment, JSONObject, DelimiterStyleTemplate>() { // from class: com.yandex.div2.DivSeparatorTemplate$DelimiterStyleTemplate$Companion$CREATOR$1
            @Override // kotlin.jvm.functions.Function2
            public final DivSeparatorTemplate.DelimiterStyleTemplate invoke(ParsingEnvironment env, JSONObject it) {
                Intrinsics.checkNotNullParameter(env, "env");
                Intrinsics.checkNotNullParameter(it, "it");
                return new DivSeparatorTemplate.DelimiterStyleTemplate(env, null, false, it, 6, null);
            }
        };

        public DelimiterStyleTemplate(Field<Expression<Integer>> color, Field<Expression<DivSeparator.DelimiterStyle.Orientation>> orientation) {
            Intrinsics.checkNotNullParameter(color, "color");
            Intrinsics.checkNotNullParameter(orientation, "orientation");
            this.color = color;
            this.orientation = orientation;
        }

        public /* synthetic */ DelimiterStyleTemplate(ParsingEnvironment parsingEnvironment, DelimiterStyleTemplate delimiterStyleTemplate, boolean z, JSONObject jSONObject, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this(parsingEnvironment, (i & 2) != 0 ? null : delimiterStyleTemplate, (i & 4) != 0 ? false : z, jSONObject);
        }

        /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
        public DelimiterStyleTemplate(ParsingEnvironment env, DelimiterStyleTemplate delimiterStyleTemplate, boolean z, JSONObject json) {
            this(Field.INSTANCE.nullField(false), Field.INSTANCE.nullField(false));
            Intrinsics.checkNotNullParameter(env, "env");
            Intrinsics.checkNotNullParameter(json, "json");
            throw new UnsupportedOperationException("Do not use this constructor directly.");
        }

        @Override // com.yandex.div.json.JsonTemplate
        public DivSeparator.DelimiterStyle resolve(ParsingEnvironment env, JSONObject data) {
            Intrinsics.checkNotNullParameter(env, "env");
            Intrinsics.checkNotNullParameter(data, "data");
            return BuiltInParserKt.getBuiltInParserComponent().getDivSeparatorDelimiterStyleJsonTemplateResolver().getValue().resolve((ParsingContext) env, this, data);
        }

        @Override // com.yandex.div.json.JSONSerializable
        public JSONObject writeToJSON() {
            return BuiltInParserKt.getBuiltInParserComponent().getDivSeparatorDelimiterStyleJsonTemplateParser().getValue().serialize(BuiltInParserKt.getBuiltInParsingContext(), this);
        }

        /* JADX INFO: compiled from: DivSeparatorTemplate.kt */
        @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R#\u0010\u0006\u001a\u0014\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\n0\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0014\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000e0\u0004X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000f"}, d2 = {"Lcom/yandex/div2/DivSeparatorTemplate$DelimiterStyleTemplate$Companion;", "", "()V", "COLOR_DEFAULT_VALUE", "Lcom/yandex/div/json/expressions/Expression;", "", "CREATOR", "Lkotlin/Function2;", "Lcom/yandex/div/json/ParsingEnvironment;", "Lorg/json/JSONObject;", "Lcom/yandex/div2/DivSeparatorTemplate$DelimiterStyleTemplate;", "getCREATOR", "()Lkotlin/jvm/functions/Function2;", "ORIENTATION_DEFAULT_VALUE", "Lcom/yandex/div2/DivSeparator$DelimiterStyle$Orientation;", "div-data_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private Companion() {
            }

            public final Function2<ParsingEnvironment, JSONObject, DelimiterStyleTemplate> getCREATOR() {
                return DelimiterStyleTemplate.CREATOR;
            }
        }
    }
}
