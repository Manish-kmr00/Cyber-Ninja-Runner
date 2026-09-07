package com.yandex.div2;

import androidx.compose.material.OutlinedTextFieldKt;
import com.json.cc;
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

/* JADX INFO: compiled from: DivSwitchTemplate.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(d1 = {"\u0000Þ\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0006\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 Q2\u00020\u00012\b\u0012\u0004\u0012\u00020\u00030\u0002:\u0001QBé\u0004\b\u0016\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\u0012\u0010\u0007\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0\b0\u0005\u0012\u0012\u0010\n\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000b0\b0\u0005\u0012\u0012\u0010\f\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\r0\b0\u0005\u0012\u0012\u0010\u000e\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00100\u000f0\u0005\u0012\u0012\u0010\u0011\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00120\u000f0\u0005\u0012\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00140\u0005\u0012\u0012\u0010\u0015\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00160\b0\u0005\u0012\u0012\u0010\u0017\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00180\u000f0\u0005\u0012\u0012\u0010\u0019\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001a0\u000f0\u0005\u0012\f\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u001c0\u0005\u0012\u0012\u0010\u001d\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001e0\u000f0\u0005\u0012\f\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020 0\u0005\u0012\f\u0010!\u001a\b\u0012\u0004\u0012\u00020\"0\u0005\u0012\u0012\u0010#\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020$0\b0\u0005\u0012\f\u0010%\u001a\b\u0012\u0004\u0012\u00020\"0\u0005\u0012\f\u0010&\u001a\b\u0012\u0004\u0012\u00020'0\u0005\u0012\f\u0010(\u001a\b\u0012\u0004\u0012\u00020)0\u0005\u0012\u0012\u0010*\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020+0\b0\u0005\u0012\f\u0010,\u001a\b\u0012\u0004\u0012\u00020)0\u0005\u0012\u0012\u0010-\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\"0\b0\u0005\u0012\u0012\u0010.\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00160\b0\u0005\u0012\u0012\u0010/\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002000\u000f0\u0005\u0012\u0012\u00101\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002020\u000f0\u0005\u0012\f\u00103\u001a\b\u0012\u0004\u0012\u0002040\u0005\u0012\f\u00105\u001a\b\u0012\u0004\u0012\u0002060\u0005\u0012\f\u00107\u001a\b\u0012\u0004\u0012\u0002080\u0005\u0012\f\u00109\u001a\b\u0012\u0004\u0012\u0002080\u0005\u0012\u0012\u0010:\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020;0\u000f0\u0005\u0012\u0012\u0010<\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020=0\u000f0\u0005\u0012\u0012\u0010>\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020?0\u000f0\u0005\u0012\u0012\u0010@\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020A0\b0\u0005\u0012\f\u0010B\u001a\b\u0012\u0004\u0012\u00020C0\u0005\u0012\u0012\u0010D\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020C0\u000f0\u0005\u0012\f\u0010E\u001a\b\u0012\u0004\u0012\u00020 0\u0005¢\u0006\u0002\u0010FB-\b\u0016\u0012\u0006\u0010G\u001a\u00020H\u0012\n\b\u0002\u0010I\u001a\u0004\u0018\u00010\u0000\u0012\b\b\u0002\u0010J\u001a\u00020$\u0012\u0006\u0010K\u001a\u00020L¢\u0006\u0002\u0010MJ\u0018\u0010N\u001a\u00020\u00032\u0006\u0010G\u001a\u00020H2\u0006\u0010O\u001a\u00020LH\u0016J\b\u0010P\u001a\u00020LH\u0016R\u0016\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u00058\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\u0007\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0\b0\u00058\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\n\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000b0\b0\u00058\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\f\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\r0\b0\u00058\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\u000e\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00100\u000f0\u00058\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\u0011\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00120\u000f0\u00058\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00140\u00058\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\u0015\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00160\b0\u00058\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\u0017\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00180\u000f0\u00058\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\u0019\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001a0\u000f0\u00058\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u001c0\u00058\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\u001d\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001e0\u000f0\u00058\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020 0\u00058\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0016\u0010!\u001a\b\u0012\u0004\u0012\u00020\"0\u00058\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u001c\u0010#\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020$0\b0\u00058\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0016\u0010%\u001a\b\u0012\u0004\u0012\u00020\"0\u00058\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0016\u0010&\u001a\b\u0012\u0004\u0012\u00020'0\u00058\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0016\u0010(\u001a\b\u0012\u0004\u0012\u00020)0\u00058\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u001c\u0010*\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020+0\b0\u00058\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0016\u0010,\u001a\b\u0012\u0004\u0012\u00020)0\u00058\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u001c\u0010-\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\"0\b0\u00058\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u001c\u0010.\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00160\b0\u00058\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u001c\u0010/\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002000\u000f0\u00058\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u001c\u00101\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002020\u000f0\u00058\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0016\u00103\u001a\b\u0012\u0004\u0012\u0002040\u00058\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0016\u00105\u001a\b\u0012\u0004\u0012\u0002060\u00058\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0016\u00107\u001a\b\u0012\u0004\u0012\u0002080\u00058\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0016\u00109\u001a\b\u0012\u0004\u0012\u0002080\u00058\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u001c\u0010:\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020;0\u000f0\u00058\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u001c\u0010<\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020=0\u000f0\u00058\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u001c\u0010>\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020?0\u000f0\u00058\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u001c\u0010@\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020A0\b0\u00058\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0016\u0010B\u001a\b\u0012\u0004\u0012\u00020C0\u00058\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u001c\u0010D\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020C0\u000f0\u00058\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0016\u0010E\u001a\b\u0012\u0004\u0012\u00020 0\u00058\u0006X\u0087\u0004¢\u0006\u0002\n\u0000¨\u0006R"}, d2 = {"Lcom/yandex/div2/DivSwitchTemplate;", "Lcom/yandex/div/json/JSONSerializable;", "Lcom/yandex/div/json/JsonTemplate;", "Lcom/yandex/div2/DivSwitch;", "accessibility", "Lcom/yandex/div/internal/template/Field;", "Lcom/yandex/div2/DivAccessibilityTemplate;", "alignmentHorizontal", "Lcom/yandex/div/json/expressions/Expression;", "Lcom/yandex/div2/DivAlignmentHorizontal;", "alignmentVertical", "Lcom/yandex/div2/DivAlignmentVertical;", "alpha", "", "animators", "", "Lcom/yandex/div2/DivAnimatorTemplate;", J2.g, "Lcom/yandex/div2/DivBackgroundTemplate;", OutlinedTextFieldKt.BorderId, "Lcom/yandex/div2/DivBorderTemplate;", "columnSpan", "", "disappearActions", "Lcom/yandex/div2/DivDisappearActionTemplate;", "extensions", "Lcom/yandex/div2/DivExtensionTemplate;", "focus", "Lcom/yandex/div2/DivFocusTemplate;", "functions", "Lcom/yandex/div2/DivFunctionTemplate;", "height", "Lcom/yandex/div2/DivSizeTemplate;", "id", "", "isEnabled", "", "isOnVariable", "layoutProvider", "Lcom/yandex/div2/DivLayoutProviderTemplate;", "margins", "Lcom/yandex/div2/DivEdgeInsetsTemplate;", "onColor", "", "paddings", "reuseId", "rowSpan", "selectedActions", "Lcom/yandex/div2/DivActionTemplate;", "tooltips", "Lcom/yandex/div2/DivTooltipTemplate;", "transform", "Lcom/yandex/div2/DivTransformTemplate;", "transitionChange", "Lcom/yandex/div2/DivChangeTransitionTemplate;", "transitionIn", "Lcom/yandex/div2/DivAppearanceTransitionTemplate;", "transitionOut", "transitionTriggers", "Lcom/yandex/div2/DivTransitionTrigger;", "variableTriggers", "Lcom/yandex/div2/DivTriggerTemplate;", "variables", "Lcom/yandex/div2/DivVariableTemplate;", "visibility", "Lcom/yandex/div2/DivVisibility;", "visibilityAction", "Lcom/yandex/div2/DivVisibilityActionTemplate;", "visibilityActions", "width", "(Lcom/yandex/div/internal/template/Field;Lcom/yandex/div/internal/template/Field;Lcom/yandex/div/internal/template/Field;Lcom/yandex/div/internal/template/Field;Lcom/yandex/div/internal/template/Field;Lcom/yandex/div/internal/template/Field;Lcom/yandex/div/internal/template/Field;Lcom/yandex/div/internal/template/Field;Lcom/yandex/div/internal/template/Field;Lcom/yandex/div/internal/template/Field;Lcom/yandex/div/internal/template/Field;Lcom/yandex/div/internal/template/Field;Lcom/yandex/div/internal/template/Field;Lcom/yandex/div/internal/template/Field;Lcom/yandex/div/internal/template/Field;Lcom/yandex/div/internal/template/Field;Lcom/yandex/div/internal/template/Field;Lcom/yandex/div/internal/template/Field;Lcom/yandex/div/internal/template/Field;Lcom/yandex/div/internal/template/Field;Lcom/yandex/div/internal/template/Field;Lcom/yandex/div/internal/template/Field;Lcom/yandex/div/internal/template/Field;Lcom/yandex/div/internal/template/Field;Lcom/yandex/div/internal/template/Field;Lcom/yandex/div/internal/template/Field;Lcom/yandex/div/internal/template/Field;Lcom/yandex/div/internal/template/Field;Lcom/yandex/div/internal/template/Field;Lcom/yandex/div/internal/template/Field;Lcom/yandex/div/internal/template/Field;Lcom/yandex/div/internal/template/Field;Lcom/yandex/div/internal/template/Field;Lcom/yandex/div/internal/template/Field;Lcom/yandex/div/internal/template/Field;)V", cc.o, "Lcom/yandex/div/json/ParsingEnvironment;", "parent", "topLevel", "json", "Lorg/json/JSONObject;", "(Lcom/yandex/div/json/ParsingEnvironment;Lcom/yandex/div2/DivSwitchTemplate;ZLorg/json/JSONObject;)V", "resolve", "data", "writeToJSON", "Companion", "div-data_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class DivSwitchTemplate implements JSONSerializable, JsonTemplate<DivSwitch> {
    public static final String TYPE = "switch";
    public final Field<DivAccessibilityTemplate> accessibility;
    public final Field<Expression<DivAlignmentHorizontal>> alignmentHorizontal;
    public final Field<Expression<DivAlignmentVertical>> alignmentVertical;
    public final Field<Expression<Double>> alpha;
    public final Field<List<DivAnimatorTemplate>> animators;
    public final Field<List<DivBackgroundTemplate>> background;
    public final Field<DivBorderTemplate> border;
    public final Field<Expression<Long>> columnSpan;
    public final Field<List<DivDisappearActionTemplate>> disappearActions;
    public final Field<List<DivExtensionTemplate>> extensions;
    public final Field<DivFocusTemplate> focus;
    public final Field<List<DivFunctionTemplate>> functions;
    public final Field<DivSizeTemplate> height;
    public final Field<String> id;
    public final Field<Expression<Boolean>> isEnabled;
    public final Field<String> isOnVariable;
    public final Field<DivLayoutProviderTemplate> layoutProvider;
    public final Field<DivEdgeInsetsTemplate> margins;
    public final Field<Expression<Integer>> onColor;
    public final Field<DivEdgeInsetsTemplate> paddings;
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

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final Expression<Double> ALPHA_DEFAULT_VALUE = Expression.INSTANCE.constant(Double.valueOf(1.0d));
    private static final DivSize.WrapContent HEIGHT_DEFAULT_VALUE = new DivSize.WrapContent(new DivWrapContentSize(null, null, null, 7, null));
    private static final Expression<Boolean> IS_ENABLED_DEFAULT_VALUE = Expression.INSTANCE.constant(true);
    private static final Expression<DivVisibility> VISIBILITY_DEFAULT_VALUE = Expression.INSTANCE.constant(DivVisibility.VISIBLE);
    private static final DivSize.MatchParent WIDTH_DEFAULT_VALUE = new DivSize.MatchParent(new DivMatchParentSize(0 == true ? 1 : 0, 1, 0 == true ? 1 : 0));
    private static final Function2<ParsingEnvironment, JSONObject, DivSwitchTemplate> CREATOR = new Function2<ParsingEnvironment, JSONObject, DivSwitchTemplate>() { // from class: com.yandex.div2.DivSwitchTemplate$Companion$CREATOR$1
        @Override // kotlin.jvm.functions.Function2
        public final DivSwitchTemplate invoke(ParsingEnvironment env, JSONObject it) {
            Intrinsics.checkNotNullParameter(env, "env");
            Intrinsics.checkNotNullParameter(it, "it");
            return new DivSwitchTemplate(env, null, false, it, 6, null);
        }
    };

    public DivSwitchTemplate(Field<DivAccessibilityTemplate> accessibility, Field<Expression<DivAlignmentHorizontal>> alignmentHorizontal, Field<Expression<DivAlignmentVertical>> alignmentVertical, Field<Expression<Double>> alpha, Field<List<DivAnimatorTemplate>> animators, Field<List<DivBackgroundTemplate>> background, Field<DivBorderTemplate> border, Field<Expression<Long>> columnSpan, Field<List<DivDisappearActionTemplate>> disappearActions, Field<List<DivExtensionTemplate>> extensions, Field<DivFocusTemplate> focus, Field<List<DivFunctionTemplate>> functions, Field<DivSizeTemplate> height, Field<String> id, Field<Expression<Boolean>> isEnabled, Field<String> isOnVariable, Field<DivLayoutProviderTemplate> layoutProvider, Field<DivEdgeInsetsTemplate> margins, Field<Expression<Integer>> onColor, Field<DivEdgeInsetsTemplate> paddings, Field<Expression<String>> reuseId, Field<Expression<Long>> rowSpan, Field<List<DivActionTemplate>> selectedActions, Field<List<DivTooltipTemplate>> tooltips, Field<DivTransformTemplate> transform, Field<DivChangeTransitionTemplate> transitionChange, Field<DivAppearanceTransitionTemplate> transitionIn, Field<DivAppearanceTransitionTemplate> transitionOut, Field<List<DivTransitionTrigger>> transitionTriggers, Field<List<DivTriggerTemplate>> variableTriggers, Field<List<DivVariableTemplate>> variables, Field<Expression<DivVisibility>> visibility, Field<DivVisibilityActionTemplate> visibilityAction, Field<List<DivVisibilityActionTemplate>> visibilityActions, Field<DivSizeTemplate> width) {
        Intrinsics.checkNotNullParameter(accessibility, "accessibility");
        Intrinsics.checkNotNullParameter(alignmentHorizontal, "alignmentHorizontal");
        Intrinsics.checkNotNullParameter(alignmentVertical, "alignmentVertical");
        Intrinsics.checkNotNullParameter(alpha, "alpha");
        Intrinsics.checkNotNullParameter(animators, "animators");
        Intrinsics.checkNotNullParameter(background, "background");
        Intrinsics.checkNotNullParameter(border, "border");
        Intrinsics.checkNotNullParameter(columnSpan, "columnSpan");
        Intrinsics.checkNotNullParameter(disappearActions, "disappearActions");
        Intrinsics.checkNotNullParameter(extensions, "extensions");
        Intrinsics.checkNotNullParameter(focus, "focus");
        Intrinsics.checkNotNullParameter(functions, "functions");
        Intrinsics.checkNotNullParameter(height, "height");
        Intrinsics.checkNotNullParameter(id, "id");
        Intrinsics.checkNotNullParameter(isEnabled, "isEnabled");
        Intrinsics.checkNotNullParameter(isOnVariable, "isOnVariable");
        Intrinsics.checkNotNullParameter(layoutProvider, "layoutProvider");
        Intrinsics.checkNotNullParameter(margins, "margins");
        Intrinsics.checkNotNullParameter(onColor, "onColor");
        Intrinsics.checkNotNullParameter(paddings, "paddings");
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
        this.alignmentHorizontal = alignmentHorizontal;
        this.alignmentVertical = alignmentVertical;
        this.alpha = alpha;
        this.animators = animators;
        this.background = background;
        this.border = border;
        this.columnSpan = columnSpan;
        this.disappearActions = disappearActions;
        this.extensions = extensions;
        this.focus = focus;
        this.functions = functions;
        this.height = height;
        this.id = id;
        this.isEnabled = isEnabled;
        this.isOnVariable = isOnVariable;
        this.layoutProvider = layoutProvider;
        this.margins = margins;
        this.onColor = onColor;
        this.paddings = paddings;
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

    public /* synthetic */ DivSwitchTemplate(ParsingEnvironment parsingEnvironment, DivSwitchTemplate divSwitchTemplate, boolean z, JSONObject jSONObject, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(parsingEnvironment, (i & 2) != 0 ? null : divSwitchTemplate, (i & 4) != 0 ? false : z, jSONObject);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public DivSwitchTemplate(ParsingEnvironment env, DivSwitchTemplate divSwitchTemplate, boolean z, JSONObject json) {
        this(Field.INSTANCE.nullField(false), Field.INSTANCE.nullField(false), Field.INSTANCE.nullField(false), Field.INSTANCE.nullField(false), Field.INSTANCE.nullField(false), Field.INSTANCE.nullField(false), Field.INSTANCE.nullField(false), Field.INSTANCE.nullField(false), Field.INSTANCE.nullField(false), Field.INSTANCE.nullField(false), Field.INSTANCE.nullField(false), Field.INSTANCE.nullField(false), Field.INSTANCE.nullField(false), Field.INSTANCE.nullField(false), Field.INSTANCE.nullField(false), Field.INSTANCE.nullField(false), Field.INSTANCE.nullField(false), Field.INSTANCE.nullField(false), Field.INSTANCE.nullField(false), Field.INSTANCE.nullField(false), Field.INSTANCE.nullField(false), Field.INSTANCE.nullField(false), Field.INSTANCE.nullField(false), Field.INSTANCE.nullField(false), Field.INSTANCE.nullField(false), Field.INSTANCE.nullField(false), Field.INSTANCE.nullField(false), Field.INSTANCE.nullField(false), Field.INSTANCE.nullField(false), Field.INSTANCE.nullField(false), Field.INSTANCE.nullField(false), Field.INSTANCE.nullField(false), Field.INSTANCE.nullField(false), Field.INSTANCE.nullField(false), Field.INSTANCE.nullField(false));
        Intrinsics.checkNotNullParameter(env, "env");
        Intrinsics.checkNotNullParameter(json, "json");
        throw new UnsupportedOperationException("Do not use this constructor directly.");
    }

    @Override // com.yandex.div.json.JsonTemplate
    public DivSwitch resolve(ParsingEnvironment env, JSONObject data) {
        Intrinsics.checkNotNullParameter(env, "env");
        Intrinsics.checkNotNullParameter(data, "data");
        return BuiltInParserKt.getBuiltInParserComponent().getDivSwitchJsonTemplateResolver().getValue().resolve((ParsingContext) env, this, data);
    }

    @Override // com.yandex.div.json.JSONSerializable
    public JSONObject writeToJSON() {
        return BuiltInParserKt.getBuiltInParserComponent().getDivSwitchJsonTemplateParser().getValue().serialize(BuiltInParserKt.getBuiltInParsingContext(), this);
    }

    /* JADX INFO: compiled from: DivSwitchTemplate.kt */
    @Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0006\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R#\u0010\u0006\u001a\u0014\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\n0\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u000e\u0010\r\u001a\u00020\u000eX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00100\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X\u0086T¢\u0006\u0002\n\u0000R\u0014\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00140\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0016X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0017"}, d2 = {"Lcom/yandex/div2/DivSwitchTemplate$Companion;", "", "()V", "ALPHA_DEFAULT_VALUE", "Lcom/yandex/div/json/expressions/Expression;", "", "CREATOR", "Lkotlin/Function2;", "Lcom/yandex/div/json/ParsingEnvironment;", "Lorg/json/JSONObject;", "Lcom/yandex/div2/DivSwitchTemplate;", "getCREATOR", "()Lkotlin/jvm/functions/Function2;", "HEIGHT_DEFAULT_VALUE", "Lcom/yandex/div2/DivSize$WrapContent;", "IS_ENABLED_DEFAULT_VALUE", "", "TYPE", "", "VISIBILITY_DEFAULT_VALUE", "Lcom/yandex/div2/DivVisibility;", "WIDTH_DEFAULT_VALUE", "Lcom/yandex/div2/DivSize$MatchParent;", "div-data_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final Function2<ParsingEnvironment, JSONObject, DivSwitchTemplate> getCREATOR() {
            return DivSwitchTemplate.CREATOR;
        }
    }
}
