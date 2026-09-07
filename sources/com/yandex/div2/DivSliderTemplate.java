package com.yandex.div2;

import androidx.compose.material.OutlinedTextFieldKt;
import androidx.core.view.ViewCompat;
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

/* JADX INFO: compiled from: DivSliderTemplate.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000î\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0006\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 _2\u00020\u00012\b\u0012\u0004\u0012\u00020\u00030\u0002:\u0003_`aB\u009d\u0006\b\u0016\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\u0012\u0010\u0007\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0\b0\u0005\u0012\u0012\u0010\n\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000b0\b0\u0005\u0012\u0012\u0010\f\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\r0\b0\u0005\u0012\u0012\u0010\u000e\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00100\u000f0\u0005\u0012\u0012\u0010\u0011\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00120\u000f0\u0005\u0012\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00140\u0005\u0012\u0012\u0010\u0015\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00160\b0\u0005\u0012\u0012\u0010\u0017\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00180\u000f0\u0005\u0012\u0012\u0010\u0019\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001a0\u000f0\u0005\u0012\f\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u001c0\u0005\u0012\u0012\u0010\u001d\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001e0\u000f0\u0005\u0012\f\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020 0\u0005\u0012\f\u0010!\u001a\b\u0012\u0004\u0012\u00020\"0\u0005\u0012\u0012\u0010#\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020$0\b0\u0005\u0012\f\u0010%\u001a\b\u0012\u0004\u0012\u00020&0\u0005\u0012\f\u0010'\u001a\b\u0012\u0004\u0012\u00020(0\u0005\u0012\u0012\u0010)\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00160\b0\u0005\u0012\u0012\u0010*\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00160\b0\u0005\u0012\f\u0010+\u001a\b\u0012\u0004\u0012\u00020(0\u0005\u0012\u0012\u0010,\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020-0\u000f0\u0005\u0012\u0012\u0010.\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\"0\b0\u0005\u0012\u0012\u0010/\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00160\b0\u0005\u0012\f\u00100\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\u0012\u00101\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002020\u000f0\u0005\u0012\f\u00103\u001a\b\u0012\u0004\u0012\u0002040\u0005\u0012\f\u00105\u001a\b\u0012\u0004\u0012\u0002060\u0005\u0012\f\u00107\u001a\b\u0012\u0004\u0012\u00020\"0\u0005\u0012\f\u00108\u001a\b\u0012\u0004\u0012\u0002040\u0005\u0012\f\u00109\u001a\b\u0012\u0004\u0012\u0002060\u0005\u0012\f\u0010:\u001a\b\u0012\u0004\u0012\u00020\"0\u0005\u0012\f\u0010;\u001a\b\u0012\u0004\u0012\u0002040\u0005\u0012\f\u0010<\u001a\b\u0012\u0004\u0012\u0002040\u0005\u0012\u0012\u0010=\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020>0\u000f0\u0005\u0012\f\u0010?\u001a\b\u0012\u0004\u0012\u0002040\u0005\u0012\f\u0010@\u001a\b\u0012\u0004\u0012\u0002040\u0005\u0012\f\u0010A\u001a\b\u0012\u0004\u0012\u00020B0\u0005\u0012\f\u0010C\u001a\b\u0012\u0004\u0012\u00020D0\u0005\u0012\f\u0010E\u001a\b\u0012\u0004\u0012\u00020F0\u0005\u0012\f\u0010G\u001a\b\u0012\u0004\u0012\u00020F0\u0005\u0012\u0012\u0010H\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020I0\u000f0\u0005\u0012\u0012\u0010J\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020K0\u000f0\u0005\u0012\u0012\u0010L\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020M0\u000f0\u0005\u0012\u0012\u0010N\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020O0\b0\u0005\u0012\f\u0010P\u001a\b\u0012\u0004\u0012\u00020Q0\u0005\u0012\u0012\u0010R\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020Q0\u000f0\u0005\u0012\f\u0010S\u001a\b\u0012\u0004\u0012\u00020 0\u0005¢\u0006\u0002\u0010TB-\b\u0016\u0012\u0006\u0010U\u001a\u00020V\u0012\n\b\u0002\u0010W\u001a\u0004\u0018\u00010\u0000\u0012\b\b\u0002\u0010X\u001a\u00020$\u0012\u0006\u0010Y\u001a\u00020Z¢\u0006\u0002\u0010[J\u0018\u0010\\\u001a\u00020\u00032\u0006\u0010U\u001a\u00020V2\u0006\u0010]\u001a\u00020ZH\u0016J\b\u0010^\u001a\u00020ZH\u0016R\u0016\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u00058\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\u0007\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0\b0\u00058\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\n\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000b0\b0\u00058\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\f\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\r0\b0\u00058\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\u000e\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00100\u000f0\u00058\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\u0011\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00120\u000f0\u00058\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00140\u00058\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\u0015\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00160\b0\u00058\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\u0017\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00180\u000f0\u00058\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\u0019\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001a0\u000f0\u00058\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u001c0\u00058\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\u001d\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001e0\u000f0\u00058\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020 0\u00058\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0016\u0010!\u001a\b\u0012\u0004\u0012\u00020\"0\u00058\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u001c\u0010#\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020$0\b0\u00058\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0016\u0010%\u001a\b\u0012\u0004\u0012\u00020&0\u00058\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0016\u0010'\u001a\b\u0012\u0004\u0012\u00020(0\u00058\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u001c\u0010)\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00160\b0\u00058\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u001c\u0010*\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00160\b0\u00058\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0016\u0010+\u001a\b\u0012\u0004\u0012\u00020(0\u00058\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u001c\u0010,\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020-0\u000f0\u00058\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u001c\u0010.\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\"0\b0\u00058\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u001c\u0010/\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00160\b0\u00058\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0016\u00100\u001a\b\u0012\u0004\u0012\u00020\u00060\u00058\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u001c\u00101\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002020\u000f0\u00058\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0016\u00103\u001a\b\u0012\u0004\u0012\u0002040\u00058\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0016\u00105\u001a\b\u0012\u0004\u0012\u0002060\u00058\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0016\u00107\u001a\b\u0012\u0004\u0012\u00020\"0\u00058\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0016\u00108\u001a\b\u0012\u0004\u0012\u0002040\u00058\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0016\u00109\u001a\b\u0012\u0004\u0012\u0002060\u00058\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0016\u0010:\u001a\b\u0012\u0004\u0012\u00020\"0\u00058\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0016\u0010;\u001a\b\u0012\u0004\u0012\u0002040\u00058\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0016\u0010<\u001a\b\u0012\u0004\u0012\u0002040\u00058\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u001c\u0010=\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020>0\u000f0\u00058\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0016\u0010?\u001a\b\u0012\u0004\u0012\u0002040\u00058\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0016\u0010@\u001a\b\u0012\u0004\u0012\u0002040\u00058\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0016\u0010A\u001a\b\u0012\u0004\u0012\u00020B0\u00058\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0016\u0010C\u001a\b\u0012\u0004\u0012\u00020D0\u00058\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0016\u0010E\u001a\b\u0012\u0004\u0012\u00020F0\u00058\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0016\u0010G\u001a\b\u0012\u0004\u0012\u00020F0\u00058\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u001c\u0010H\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020I0\u000f0\u00058\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u001c\u0010J\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020K0\u000f0\u00058\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u001c\u0010L\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020M0\u000f0\u00058\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u001c\u0010N\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020O0\b0\u00058\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0016\u0010P\u001a\b\u0012\u0004\u0012\u00020Q0\u00058\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u001c\u0010R\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020Q0\u000f0\u00058\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0016\u0010S\u001a\b\u0012\u0004\u0012\u00020 0\u00058\u0006X\u0087\u0004¢\u0006\u0002\n\u0000¨\u0006b"}, d2 = {"Lcom/yandex/div2/DivSliderTemplate;", "Lcom/yandex/div/json/JSONSerializable;", "Lcom/yandex/div/json/JsonTemplate;", "Lcom/yandex/div2/DivSlider;", "accessibility", "Lcom/yandex/div/internal/template/Field;", "Lcom/yandex/div2/DivAccessibilityTemplate;", "alignmentHorizontal", "Lcom/yandex/div/json/expressions/Expression;", "Lcom/yandex/div2/DivAlignmentHorizontal;", "alignmentVertical", "Lcom/yandex/div2/DivAlignmentVertical;", "alpha", "", "animators", "", "Lcom/yandex/div2/DivAnimatorTemplate;", J2.g, "Lcom/yandex/div2/DivBackgroundTemplate;", OutlinedTextFieldKt.BorderId, "Lcom/yandex/div2/DivBorderTemplate;", "columnSpan", "", "disappearActions", "Lcom/yandex/div2/DivDisappearActionTemplate;", "extensions", "Lcom/yandex/div2/DivExtensionTemplate;", "focus", "Lcom/yandex/div2/DivFocusTemplate;", "functions", "Lcom/yandex/div2/DivFunctionTemplate;", "height", "Lcom/yandex/div2/DivSizeTemplate;", "id", "", "isEnabled", "", "layoutProvider", "Lcom/yandex/div2/DivLayoutProviderTemplate;", "margins", "Lcom/yandex/div2/DivEdgeInsetsTemplate;", "maxValue", "minValue", "paddings", "ranges", "Lcom/yandex/div2/DivSliderTemplate$RangeTemplate;", "reuseId", "rowSpan", "secondaryValueAccessibility", "selectedActions", "Lcom/yandex/div2/DivActionTemplate;", "thumbSecondaryStyle", "Lcom/yandex/div2/DivDrawableTemplate;", "thumbSecondaryTextStyle", "Lcom/yandex/div2/DivSliderTemplate$TextStyleTemplate;", "thumbSecondaryValueVariable", "thumbStyle", "thumbTextStyle", "thumbValueVariable", "tickMarkActiveStyle", "tickMarkInactiveStyle", "tooltips", "Lcom/yandex/div2/DivTooltipTemplate;", "trackActiveStyle", "trackInactiveStyle", "transform", "Lcom/yandex/div2/DivTransformTemplate;", "transitionChange", "Lcom/yandex/div2/DivChangeTransitionTemplate;", "transitionIn", "Lcom/yandex/div2/DivAppearanceTransitionTemplate;", "transitionOut", "transitionTriggers", "Lcom/yandex/div2/DivTransitionTrigger;", "variableTriggers", "Lcom/yandex/div2/DivTriggerTemplate;", "variables", "Lcom/yandex/div2/DivVariableTemplate;", "visibility", "Lcom/yandex/div2/DivVisibility;", "visibilityAction", "Lcom/yandex/div2/DivVisibilityActionTemplate;", "visibilityActions", "width", "(Lcom/yandex/div/internal/template/Field;Lcom/yandex/div/internal/template/Field;Lcom/yandex/div/internal/template/Field;Lcom/yandex/div/internal/template/Field;Lcom/yandex/div/internal/template/Field;Lcom/yandex/div/internal/template/Field;Lcom/yandex/div/internal/template/Field;Lcom/yandex/div/internal/template/Field;Lcom/yandex/div/internal/template/Field;Lcom/yandex/div/internal/template/Field;Lcom/yandex/div/internal/template/Field;Lcom/yandex/div/internal/template/Field;Lcom/yandex/div/internal/template/Field;Lcom/yandex/div/internal/template/Field;Lcom/yandex/div/internal/template/Field;Lcom/yandex/div/internal/template/Field;Lcom/yandex/div/internal/template/Field;Lcom/yandex/div/internal/template/Field;Lcom/yandex/div/internal/template/Field;Lcom/yandex/div/internal/template/Field;Lcom/yandex/div/internal/template/Field;Lcom/yandex/div/internal/template/Field;Lcom/yandex/div/internal/template/Field;Lcom/yandex/div/internal/template/Field;Lcom/yandex/div/internal/template/Field;Lcom/yandex/div/internal/template/Field;Lcom/yandex/div/internal/template/Field;Lcom/yandex/div/internal/template/Field;Lcom/yandex/div/internal/template/Field;Lcom/yandex/div/internal/template/Field;Lcom/yandex/div/internal/template/Field;Lcom/yandex/div/internal/template/Field;Lcom/yandex/div/internal/template/Field;Lcom/yandex/div/internal/template/Field;Lcom/yandex/div/internal/template/Field;Lcom/yandex/div/internal/template/Field;Lcom/yandex/div/internal/template/Field;Lcom/yandex/div/internal/template/Field;Lcom/yandex/div/internal/template/Field;Lcom/yandex/div/internal/template/Field;Lcom/yandex/div/internal/template/Field;Lcom/yandex/div/internal/template/Field;Lcom/yandex/div/internal/template/Field;Lcom/yandex/div/internal/template/Field;Lcom/yandex/div/internal/template/Field;Lcom/yandex/div/internal/template/Field;Lcom/yandex/div/internal/template/Field;)V", cc.o, "Lcom/yandex/div/json/ParsingEnvironment;", "parent", "topLevel", "json", "Lorg/json/JSONObject;", "(Lcom/yandex/div/json/ParsingEnvironment;Lcom/yandex/div2/DivSliderTemplate;ZLorg/json/JSONObject;)V", "resolve", "data", "writeToJSON", "Companion", "RangeTemplate", "TextStyleTemplate", "div-data_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class DivSliderTemplate implements JSONSerializable, JsonTemplate<DivSlider> {
    public static final String TYPE = "slider";
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
    public final Field<DivLayoutProviderTemplate> layoutProvider;
    public final Field<DivEdgeInsetsTemplate> margins;
    public final Field<Expression<Long>> maxValue;
    public final Field<Expression<Long>> minValue;
    public final Field<DivEdgeInsetsTemplate> paddings;
    public final Field<List<RangeTemplate>> ranges;
    public final Field<Expression<String>> reuseId;
    public final Field<Expression<Long>> rowSpan;
    public final Field<DivAccessibilityTemplate> secondaryValueAccessibility;
    public final Field<List<DivActionTemplate>> selectedActions;
    public final Field<DivDrawableTemplate> thumbSecondaryStyle;
    public final Field<TextStyleTemplate> thumbSecondaryTextStyle;
    public final Field<String> thumbSecondaryValueVariable;
    public final Field<DivDrawableTemplate> thumbStyle;
    public final Field<TextStyleTemplate> thumbTextStyle;
    public final Field<String> thumbValueVariable;
    public final Field<DivDrawableTemplate> tickMarkActiveStyle;
    public final Field<DivDrawableTemplate> tickMarkInactiveStyle;
    public final Field<List<DivTooltipTemplate>> tooltips;
    public final Field<DivDrawableTemplate> trackActiveStyle;
    public final Field<DivDrawableTemplate> trackInactiveStyle;
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
    private static final Expression<Long> MAX_VALUE_DEFAULT_VALUE = Expression.INSTANCE.constant(100L);
    private static final Expression<Long> MIN_VALUE_DEFAULT_VALUE = Expression.INSTANCE.constant(0L);
    private static final Expression<DivVisibility> VISIBILITY_DEFAULT_VALUE = Expression.INSTANCE.constant(DivVisibility.VISIBLE);
    private static final DivSize.MatchParent WIDTH_DEFAULT_VALUE = new DivSize.MatchParent(new DivMatchParentSize(0 == true ? 1 : 0, 1, 0 == true ? 1 : 0));
    private static final Function2<ParsingEnvironment, JSONObject, DivSliderTemplate> CREATOR = new Function2<ParsingEnvironment, JSONObject, DivSliderTemplate>() { // from class: com.yandex.div2.DivSliderTemplate$Companion$CREATOR$1
        @Override // kotlin.jvm.functions.Function2
        public final DivSliderTemplate invoke(ParsingEnvironment env, JSONObject it) {
            Intrinsics.checkNotNullParameter(env, "env");
            Intrinsics.checkNotNullParameter(it, "it");
            return new DivSliderTemplate(env, null, false, it, 6, null);
        }
    };

    public DivSliderTemplate(Field<DivAccessibilityTemplate> accessibility, Field<Expression<DivAlignmentHorizontal>> alignmentHorizontal, Field<Expression<DivAlignmentVertical>> alignmentVertical, Field<Expression<Double>> alpha, Field<List<DivAnimatorTemplate>> animators, Field<List<DivBackgroundTemplate>> background, Field<DivBorderTemplate> border, Field<Expression<Long>> columnSpan, Field<List<DivDisappearActionTemplate>> disappearActions, Field<List<DivExtensionTemplate>> extensions, Field<DivFocusTemplate> focus, Field<List<DivFunctionTemplate>> functions, Field<DivSizeTemplate> height, Field<String> id, Field<Expression<Boolean>> isEnabled, Field<DivLayoutProviderTemplate> layoutProvider, Field<DivEdgeInsetsTemplate> margins, Field<Expression<Long>> maxValue, Field<Expression<Long>> minValue, Field<DivEdgeInsetsTemplate> paddings, Field<List<RangeTemplate>> ranges, Field<Expression<String>> reuseId, Field<Expression<Long>> rowSpan, Field<DivAccessibilityTemplate> secondaryValueAccessibility, Field<List<DivActionTemplate>> selectedActions, Field<DivDrawableTemplate> thumbSecondaryStyle, Field<TextStyleTemplate> thumbSecondaryTextStyle, Field<String> thumbSecondaryValueVariable, Field<DivDrawableTemplate> thumbStyle, Field<TextStyleTemplate> thumbTextStyle, Field<String> thumbValueVariable, Field<DivDrawableTemplate> tickMarkActiveStyle, Field<DivDrawableTemplate> tickMarkInactiveStyle, Field<List<DivTooltipTemplate>> tooltips, Field<DivDrawableTemplate> trackActiveStyle, Field<DivDrawableTemplate> trackInactiveStyle, Field<DivTransformTemplate> transform, Field<DivChangeTransitionTemplate> transitionChange, Field<DivAppearanceTransitionTemplate> transitionIn, Field<DivAppearanceTransitionTemplate> transitionOut, Field<List<DivTransitionTrigger>> transitionTriggers, Field<List<DivTriggerTemplate>> variableTriggers, Field<List<DivVariableTemplate>> variables, Field<Expression<DivVisibility>> visibility, Field<DivVisibilityActionTemplate> visibilityAction, Field<List<DivVisibilityActionTemplate>> visibilityActions, Field<DivSizeTemplate> width) {
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
        Intrinsics.checkNotNullParameter(layoutProvider, "layoutProvider");
        Intrinsics.checkNotNullParameter(margins, "margins");
        Intrinsics.checkNotNullParameter(maxValue, "maxValue");
        Intrinsics.checkNotNullParameter(minValue, "minValue");
        Intrinsics.checkNotNullParameter(paddings, "paddings");
        Intrinsics.checkNotNullParameter(ranges, "ranges");
        Intrinsics.checkNotNullParameter(reuseId, "reuseId");
        Intrinsics.checkNotNullParameter(rowSpan, "rowSpan");
        Intrinsics.checkNotNullParameter(secondaryValueAccessibility, "secondaryValueAccessibility");
        Intrinsics.checkNotNullParameter(selectedActions, "selectedActions");
        Intrinsics.checkNotNullParameter(thumbSecondaryStyle, "thumbSecondaryStyle");
        Intrinsics.checkNotNullParameter(thumbSecondaryTextStyle, "thumbSecondaryTextStyle");
        Intrinsics.checkNotNullParameter(thumbSecondaryValueVariable, "thumbSecondaryValueVariable");
        Intrinsics.checkNotNullParameter(thumbStyle, "thumbStyle");
        Intrinsics.checkNotNullParameter(thumbTextStyle, "thumbTextStyle");
        Intrinsics.checkNotNullParameter(thumbValueVariable, "thumbValueVariable");
        Intrinsics.checkNotNullParameter(tickMarkActiveStyle, "tickMarkActiveStyle");
        Intrinsics.checkNotNullParameter(tickMarkInactiveStyle, "tickMarkInactiveStyle");
        Intrinsics.checkNotNullParameter(tooltips, "tooltips");
        Intrinsics.checkNotNullParameter(trackActiveStyle, "trackActiveStyle");
        Intrinsics.checkNotNullParameter(trackInactiveStyle, "trackInactiveStyle");
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
        this.layoutProvider = layoutProvider;
        this.margins = margins;
        this.maxValue = maxValue;
        this.minValue = minValue;
        this.paddings = paddings;
        this.ranges = ranges;
        this.reuseId = reuseId;
        this.rowSpan = rowSpan;
        this.secondaryValueAccessibility = secondaryValueAccessibility;
        this.selectedActions = selectedActions;
        this.thumbSecondaryStyle = thumbSecondaryStyle;
        this.thumbSecondaryTextStyle = thumbSecondaryTextStyle;
        this.thumbSecondaryValueVariable = thumbSecondaryValueVariable;
        this.thumbStyle = thumbStyle;
        this.thumbTextStyle = thumbTextStyle;
        this.thumbValueVariable = thumbValueVariable;
        this.tickMarkActiveStyle = tickMarkActiveStyle;
        this.tickMarkInactiveStyle = tickMarkInactiveStyle;
        this.tooltips = tooltips;
        this.trackActiveStyle = trackActiveStyle;
        this.trackInactiveStyle = trackInactiveStyle;
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

    public /* synthetic */ DivSliderTemplate(ParsingEnvironment parsingEnvironment, DivSliderTemplate divSliderTemplate, boolean z, JSONObject jSONObject, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(parsingEnvironment, (i & 2) != 0 ? null : divSliderTemplate, (i & 4) != 0 ? false : z, jSONObject);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public DivSliderTemplate(ParsingEnvironment env, DivSliderTemplate divSliderTemplate, boolean z, JSONObject json) {
        this(Field.INSTANCE.nullField(false), Field.INSTANCE.nullField(false), Field.INSTANCE.nullField(false), Field.INSTANCE.nullField(false), Field.INSTANCE.nullField(false), Field.INSTANCE.nullField(false), Field.INSTANCE.nullField(false), Field.INSTANCE.nullField(false), Field.INSTANCE.nullField(false), Field.INSTANCE.nullField(false), Field.INSTANCE.nullField(false), Field.INSTANCE.nullField(false), Field.INSTANCE.nullField(false), Field.INSTANCE.nullField(false), Field.INSTANCE.nullField(false), Field.INSTANCE.nullField(false), Field.INSTANCE.nullField(false), Field.INSTANCE.nullField(false), Field.INSTANCE.nullField(false), Field.INSTANCE.nullField(false), Field.INSTANCE.nullField(false), Field.INSTANCE.nullField(false), Field.INSTANCE.nullField(false), Field.INSTANCE.nullField(false), Field.INSTANCE.nullField(false), Field.INSTANCE.nullField(false), Field.INSTANCE.nullField(false), Field.INSTANCE.nullField(false), Field.INSTANCE.nullField(false), Field.INSTANCE.nullField(false), Field.INSTANCE.nullField(false), Field.INSTANCE.nullField(false), Field.INSTANCE.nullField(false), Field.INSTANCE.nullField(false), Field.INSTANCE.nullField(false), Field.INSTANCE.nullField(false), Field.INSTANCE.nullField(false), Field.INSTANCE.nullField(false), Field.INSTANCE.nullField(false), Field.INSTANCE.nullField(false), Field.INSTANCE.nullField(false), Field.INSTANCE.nullField(false), Field.INSTANCE.nullField(false), Field.INSTANCE.nullField(false), Field.INSTANCE.nullField(false), Field.INSTANCE.nullField(false), Field.INSTANCE.nullField(false));
        Intrinsics.checkNotNullParameter(env, "env");
        Intrinsics.checkNotNullParameter(json, "json");
        throw new UnsupportedOperationException("Do not use this constructor directly.");
    }

    @Override // com.yandex.div.json.JsonTemplate
    public DivSlider resolve(ParsingEnvironment env, JSONObject data) {
        Intrinsics.checkNotNullParameter(env, "env");
        Intrinsics.checkNotNullParameter(data, "data");
        return BuiltInParserKt.getBuiltInParserComponent().getDivSliderJsonTemplateResolver().getValue().resolve((ParsingContext) env, this, data);
    }

    @Override // com.yandex.div.json.JSONSerializable
    public JSONObject writeToJSON() {
        return BuiltInParserKt.getBuiltInParserComponent().getDivSliderJsonTemplateParser().getValue().serialize(BuiltInParserKt.getBuiltInParsingContext(), this);
    }

    /* JADX INFO: compiled from: DivSliderTemplate.kt */
    @Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0006\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R#\u0010\u0006\u001a\u0014\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\n0\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u000e\u0010\r\u001a\u00020\u000eX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00100\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00120\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00120\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0015X\u0086T¢\u0006\u0002\n\u0000R\u0014\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00170\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0019X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001a"}, d2 = {"Lcom/yandex/div2/DivSliderTemplate$Companion;", "", "()V", "ALPHA_DEFAULT_VALUE", "Lcom/yandex/div/json/expressions/Expression;", "", "CREATOR", "Lkotlin/Function2;", "Lcom/yandex/div/json/ParsingEnvironment;", "Lorg/json/JSONObject;", "Lcom/yandex/div2/DivSliderTemplate;", "getCREATOR", "()Lkotlin/jvm/functions/Function2;", "HEIGHT_DEFAULT_VALUE", "Lcom/yandex/div2/DivSize$WrapContent;", "IS_ENABLED_DEFAULT_VALUE", "", "MAX_VALUE_DEFAULT_VALUE", "", "MIN_VALUE_DEFAULT_VALUE", "TYPE", "", "VISIBILITY_DEFAULT_VALUE", "Lcom/yandex/div2/DivVisibility;", "WIDTH_DEFAULT_VALUE", "Lcom/yandex/div2/DivSize$MatchParent;", "div-data_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final Function2<ParsingEnvironment, JSONObject, DivSliderTemplate> getCREATOR() {
            return DivSliderTemplate.CREATOR;
        }
    }

    /* JADX INFO: compiled from: DivSliderTemplate.kt */
    @Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 \u001d2\u00020\u00012\b\u0012\u0004\u0012\u00020\u00030\u0002:\u0001\u001dBy\b\u0016\u0012\u0012\u0010\u0004\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u00060\u0005\u0012\u0012\u0010\b\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0\u00060\u0005\u0012\u0012\u0010\n\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000b0\u00060\u0005\u0012\u0012\u0010\f\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u00060\u0005\u0012\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000e0\u0005\u0012\u0012\u0010\u000f\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00100\u00060\u0005¢\u0006\u0002\u0010\u0011B-\b\u0016\u0012\u0006\u0010\u0012\u001a\u00020\u0013\u0012\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u0000\u0012\b\b\u0002\u0010\u0015\u001a\u00020\u0016\u0012\u0006\u0010\u0017\u001a\u00020\u0018¢\u0006\u0002\u0010\u0019J\u0018\u0010\u001a\u001a\u00020\u00032\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u001b\u001a\u00020\u0018H\u0016J\b\u0010\u001c\u001a\u00020\u0018H\u0016R\u001c\u0010\u0004\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u00060\u00058\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\b\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0\u00060\u00058\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\n\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000b0\u00060\u00058\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\f\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u00060\u00058\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000e0\u00058\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\u000f\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00100\u00060\u00058\u0006X\u0087\u0004¢\u0006\u0002\n\u0000¨\u0006\u001e"}, d2 = {"Lcom/yandex/div2/DivSliderTemplate$TextStyleTemplate;", "Lcom/yandex/div/json/JSONSerializable;", "Lcom/yandex/div/json/JsonTemplate;", "Lcom/yandex/div2/DivSlider$TextStyle;", "fontSize", "Lcom/yandex/div/internal/template/Field;", "Lcom/yandex/div/json/expressions/Expression;", "", "fontSizeUnit", "Lcom/yandex/div2/DivSizeUnit;", "fontWeight", "Lcom/yandex/div2/DivFontWeight;", "fontWeightValue", "offset", "Lcom/yandex/div2/DivPointTemplate;", "textColor", "", "(Lcom/yandex/div/internal/template/Field;Lcom/yandex/div/internal/template/Field;Lcom/yandex/div/internal/template/Field;Lcom/yandex/div/internal/template/Field;Lcom/yandex/div/internal/template/Field;Lcom/yandex/div/internal/template/Field;)V", cc.o, "Lcom/yandex/div/json/ParsingEnvironment;", "parent", "topLevel", "", "json", "Lorg/json/JSONObject;", "(Lcom/yandex/div/json/ParsingEnvironment;Lcom/yandex/div2/DivSliderTemplate$TextStyleTemplate;ZLorg/json/JSONObject;)V", "resolve", "data", "writeToJSON", "Companion", "div-data_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class TextStyleTemplate implements JSONSerializable, JsonTemplate<DivSlider.TextStyle> {
        public final Field<Expression<Long>> fontSize;
        public final Field<Expression<DivSizeUnit>> fontSizeUnit;
        public final Field<Expression<DivFontWeight>> fontWeight;
        public final Field<Expression<Long>> fontWeightValue;
        public final Field<DivPointTemplate> offset;
        public final Field<Expression<Integer>> textColor;

        /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
        public static final Companion INSTANCE = new Companion(null);
        private static final Expression<DivSizeUnit> FONT_SIZE_UNIT_DEFAULT_VALUE = Expression.INSTANCE.constant(DivSizeUnit.SP);
        private static final Expression<DivFontWeight> FONT_WEIGHT_DEFAULT_VALUE = Expression.INSTANCE.constant(DivFontWeight.REGULAR);
        private static final Expression<Integer> TEXT_COLOR_DEFAULT_VALUE = Expression.INSTANCE.constant(Integer.valueOf(ViewCompat.MEASURED_STATE_MASK));
        private static final Function2<ParsingEnvironment, JSONObject, TextStyleTemplate> CREATOR = new Function2<ParsingEnvironment, JSONObject, TextStyleTemplate>() { // from class: com.yandex.div2.DivSliderTemplate$TextStyleTemplate$Companion$CREATOR$1
            @Override // kotlin.jvm.functions.Function2
            public final DivSliderTemplate.TextStyleTemplate invoke(ParsingEnvironment env, JSONObject it) {
                Intrinsics.checkNotNullParameter(env, "env");
                Intrinsics.checkNotNullParameter(it, "it");
                return new DivSliderTemplate.TextStyleTemplate(env, (DivSliderTemplate.TextStyleTemplate) null, false, it, 6, (DefaultConstructorMarker) null);
            }
        };

        public TextStyleTemplate(Field<Expression<Long>> fontSize, Field<Expression<DivSizeUnit>> fontSizeUnit, Field<Expression<DivFontWeight>> fontWeight, Field<Expression<Long>> fontWeightValue, Field<DivPointTemplate> offset, Field<Expression<Integer>> textColor) {
            Intrinsics.checkNotNullParameter(fontSize, "fontSize");
            Intrinsics.checkNotNullParameter(fontSizeUnit, "fontSizeUnit");
            Intrinsics.checkNotNullParameter(fontWeight, "fontWeight");
            Intrinsics.checkNotNullParameter(fontWeightValue, "fontWeightValue");
            Intrinsics.checkNotNullParameter(offset, "offset");
            Intrinsics.checkNotNullParameter(textColor, "textColor");
            this.fontSize = fontSize;
            this.fontSizeUnit = fontSizeUnit;
            this.fontWeight = fontWeight;
            this.fontWeightValue = fontWeightValue;
            this.offset = offset;
            this.textColor = textColor;
        }

        public /* synthetic */ TextStyleTemplate(ParsingEnvironment parsingEnvironment, TextStyleTemplate textStyleTemplate, boolean z, JSONObject jSONObject, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this(parsingEnvironment, (i & 2) != 0 ? null : textStyleTemplate, (i & 4) != 0 ? false : z, jSONObject);
        }

        /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
        public TextStyleTemplate(ParsingEnvironment env, TextStyleTemplate textStyleTemplate, boolean z, JSONObject json) {
            this((Field<Expression<Long>>) Field.INSTANCE.nullField(false), (Field<Expression<DivSizeUnit>>) Field.INSTANCE.nullField(false), (Field<Expression<DivFontWeight>>) Field.INSTANCE.nullField(false), (Field<Expression<Long>>) Field.INSTANCE.nullField(false), (Field<DivPointTemplate>) Field.INSTANCE.nullField(false), (Field<Expression<Integer>>) Field.INSTANCE.nullField(false));
            Intrinsics.checkNotNullParameter(env, "env");
            Intrinsics.checkNotNullParameter(json, "json");
            throw new UnsupportedOperationException("Do not use this constructor directly.");
        }

        @Override // com.yandex.div.json.JsonTemplate
        public DivSlider.TextStyle resolve(ParsingEnvironment env, JSONObject data) {
            Intrinsics.checkNotNullParameter(env, "env");
            Intrinsics.checkNotNullParameter(data, "data");
            return BuiltInParserKt.getBuiltInParserComponent().getDivSliderTextStyleJsonTemplateResolver().getValue().resolve((ParsingContext) env, this, data);
        }

        @Override // com.yandex.div.json.JSONSerializable
        public JSONObject writeToJSON() {
            return BuiltInParserKt.getBuiltInParserComponent().getDivSliderTextStyleJsonTemplateParser().getValue().serialize(BuiltInParserKt.getBuiltInParsingContext(), this);
        }

        /* JADX INFO: compiled from: DivSliderTemplate.kt */
        @Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R#\u0010\u0003\u001a\u0014\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0014\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000e0\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00100\u000bX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0011"}, d2 = {"Lcom/yandex/div2/DivSliderTemplate$TextStyleTemplate$Companion;", "", "()V", "CREATOR", "Lkotlin/Function2;", "Lcom/yandex/div/json/ParsingEnvironment;", "Lorg/json/JSONObject;", "Lcom/yandex/div2/DivSliderTemplate$TextStyleTemplate;", "getCREATOR", "()Lkotlin/jvm/functions/Function2;", "FONT_SIZE_UNIT_DEFAULT_VALUE", "Lcom/yandex/div/json/expressions/Expression;", "Lcom/yandex/div2/DivSizeUnit;", "FONT_WEIGHT_DEFAULT_VALUE", "Lcom/yandex/div2/DivFontWeight;", "TEXT_COLOR_DEFAULT_VALUE", "", "div-data_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private Companion() {
            }

            public final Function2<ParsingEnvironment, JSONObject, TextStyleTemplate> getCREATOR() {
                return TextStyleTemplate.CREATOR;
            }
        }
    }

    /* JADX INFO: compiled from: DivSliderTemplate.kt */
    @Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 \u001a2\u00020\u00012\b\u0012\u0004\u0012\u00020\u00030\u0002:\u0001\u001aBY\b\u0016\u0012\u0012\u0010\u0004\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u00060\u0005\u0012\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\t0\u0005\u0012\u0012\u0010\n\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u00060\u0005\u0012\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\f0\u0005\u0012\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\f0\u0005¢\u0006\u0002\u0010\u000eB-\b\u0016\u0012\u0006\u0010\u000f\u001a\u00020\u0010\u0012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0000\u0012\b\b\u0002\u0010\u0012\u001a\u00020\u0013\u0012\u0006\u0010\u0014\u001a\u00020\u0015¢\u0006\u0002\u0010\u0016J\u0018\u0010\u0017\u001a\u00020\u00032\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0018\u001a\u00020\u0015H\u0016J\b\u0010\u0019\u001a\u00020\u0015H\u0016R\u001c\u0010\u0004\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u00060\u00058\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\b\u001a\b\u0012\u0004\u0012\u00020\t0\u00058\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\n\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u00060\u00058\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\f0\u00058\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\r\u001a\b\u0012\u0004\u0012\u00020\f0\u00058\u0006X\u0087\u0004¢\u0006\u0002\n\u0000¨\u0006\u001b"}, d2 = {"Lcom/yandex/div2/DivSliderTemplate$RangeTemplate;", "Lcom/yandex/div/json/JSONSerializable;", "Lcom/yandex/div/json/JsonTemplate;", "Lcom/yandex/div2/DivSlider$Range;", "end", "Lcom/yandex/div/internal/template/Field;", "Lcom/yandex/div/json/expressions/Expression;", "", "margins", "Lcom/yandex/div2/DivEdgeInsetsTemplate;", "start", "trackActiveStyle", "Lcom/yandex/div2/DivDrawableTemplate;", "trackInactiveStyle", "(Lcom/yandex/div/internal/template/Field;Lcom/yandex/div/internal/template/Field;Lcom/yandex/div/internal/template/Field;Lcom/yandex/div/internal/template/Field;Lcom/yandex/div/internal/template/Field;)V", cc.o, "Lcom/yandex/div/json/ParsingEnvironment;", "parent", "topLevel", "", "json", "Lorg/json/JSONObject;", "(Lcom/yandex/div/json/ParsingEnvironment;Lcom/yandex/div2/DivSliderTemplate$RangeTemplate;ZLorg/json/JSONObject;)V", "resolve", "data", "writeToJSON", "Companion", "div-data_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class RangeTemplate implements JSONSerializable, JsonTemplate<DivSlider.Range> {
        public final Field<Expression<Long>> end;
        public final Field<DivEdgeInsetsTemplate> margins;
        public final Field<Expression<Long>> start;
        public final Field<DivDrawableTemplate> trackActiveStyle;
        public final Field<DivDrawableTemplate> trackInactiveStyle;

        /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
        public static final Companion INSTANCE = new Companion(null);
        private static final Function2<ParsingEnvironment, JSONObject, RangeTemplate> CREATOR = new Function2<ParsingEnvironment, JSONObject, RangeTemplate>() { // from class: com.yandex.div2.DivSliderTemplate$RangeTemplate$Companion$CREATOR$1
            @Override // kotlin.jvm.functions.Function2
            public final DivSliderTemplate.RangeTemplate invoke(ParsingEnvironment env, JSONObject it) {
                Intrinsics.checkNotNullParameter(env, "env");
                Intrinsics.checkNotNullParameter(it, "it");
                return new DivSliderTemplate.RangeTemplate(env, null, false, it, 6, null);
            }
        };

        public RangeTemplate(Field<Expression<Long>> end, Field<DivEdgeInsetsTemplate> margins, Field<Expression<Long>> start, Field<DivDrawableTemplate> trackActiveStyle, Field<DivDrawableTemplate> trackInactiveStyle) {
            Intrinsics.checkNotNullParameter(end, "end");
            Intrinsics.checkNotNullParameter(margins, "margins");
            Intrinsics.checkNotNullParameter(start, "start");
            Intrinsics.checkNotNullParameter(trackActiveStyle, "trackActiveStyle");
            Intrinsics.checkNotNullParameter(trackInactiveStyle, "trackInactiveStyle");
            this.end = end;
            this.margins = margins;
            this.start = start;
            this.trackActiveStyle = trackActiveStyle;
            this.trackInactiveStyle = trackInactiveStyle;
        }

        public /* synthetic */ RangeTemplate(ParsingEnvironment parsingEnvironment, RangeTemplate rangeTemplate, boolean z, JSONObject jSONObject, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this(parsingEnvironment, (i & 2) != 0 ? null : rangeTemplate, (i & 4) != 0 ? false : z, jSONObject);
        }

        /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
        public RangeTemplate(ParsingEnvironment env, RangeTemplate rangeTemplate, boolean z, JSONObject json) {
            this(Field.INSTANCE.nullField(false), Field.INSTANCE.nullField(false), Field.INSTANCE.nullField(false), Field.INSTANCE.nullField(false), Field.INSTANCE.nullField(false));
            Intrinsics.checkNotNullParameter(env, "env");
            Intrinsics.checkNotNullParameter(json, "json");
            throw new UnsupportedOperationException("Do not use this constructor directly.");
        }

        @Override // com.yandex.div.json.JsonTemplate
        public DivSlider.Range resolve(ParsingEnvironment env, JSONObject data) {
            Intrinsics.checkNotNullParameter(env, "env");
            Intrinsics.checkNotNullParameter(data, "data");
            return BuiltInParserKt.getBuiltInParserComponent().getDivSliderRangeJsonTemplateResolver().getValue().resolve((ParsingContext) env, this, data);
        }

        @Override // com.yandex.div.json.JSONSerializable
        public JSONObject writeToJSON() {
            return BuiltInParserKt.getBuiltInParserComponent().getDivSliderRangeJsonTemplateParser().getValue().serialize(BuiltInParserKt.getBuiltInParsingContext(), this);
        }

        /* JADX INFO: compiled from: DivSliderTemplate.kt */
        @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R#\u0010\u0003\u001a\u0014\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\t¨\u0006\n"}, d2 = {"Lcom/yandex/div2/DivSliderTemplate$RangeTemplate$Companion;", "", "()V", "CREATOR", "Lkotlin/Function2;", "Lcom/yandex/div/json/ParsingEnvironment;", "Lorg/json/JSONObject;", "Lcom/yandex/div2/DivSliderTemplate$RangeTemplate;", "getCREATOR", "()Lkotlin/jvm/functions/Function2;", "div-data_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private Companion() {
            }

            public final Function2<ParsingEnvironment, JSONObject, RangeTemplate> getCREATOR() {
                return RangeTemplate.CREATOR;
            }
        }
    }
}
