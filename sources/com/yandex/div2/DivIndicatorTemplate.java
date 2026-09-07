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

/* JADX INFO: compiled from: DivIndicatorTemplate.kt */
/* JADX INFO: loaded from: classes8.dex */
@Metadata(d1 = {"\u0000þ\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0006\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 _2\u00020\u00012\b\u0012\u0004\u0012\u00020\u00030\u0002:\u0001_Bù\u0005\b\u0016\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\u0012\u0010\u0007\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0\b0\u0005\u0012\u0012\u0010\n\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000b0\b0\u0005\u0012\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\r0\u0005\u0012\u0012\u0010\u000e\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000f0\b0\u0005\u0012\u0012\u0010\u0010\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00110\b0\u0005\u0012\u0012\u0010\u0012\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000b0\b0\u0005\u0012\u0012\u0010\u0013\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00140\b0\u0005\u0012\u0012\u0010\u0015\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00170\u00160\u0005\u0012\u0012\u0010\u0018\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00190\u00160\u0005\u0012\f\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u001b0\u0005\u0012\u0012\u0010\u001c\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001d0\b0\u0005\u0012\u0012\u0010\u001e\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001f0\u00160\u0005\u0012\u0012\u0010 \u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020!0\u00160\u0005\u0012\f\u0010\"\u001a\b\u0012\u0004\u0012\u00020#0\u0005\u0012\u0012\u0010$\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020%0\u00160\u0005\u0012\f\u0010&\u001a\b\u0012\u0004\u0012\u00020'0\u0005\u0012\f\u0010(\u001a\b\u0012\u0004\u0012\u00020)0\u0005\u0012\u0012\u0010*\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0\b0\u0005\u0012\f\u0010+\u001a\b\u0012\u0004\u0012\u00020\r0\u0005\u0012\f\u0010,\u001a\b\u0012\u0004\u0012\u00020\r0\u0005\u0012\f\u0010-\u001a\b\u0012\u0004\u0012\u00020.0\u0005\u0012\f\u0010/\u001a\b\u0012\u0004\u0012\u0002000\u0005\u0012\f\u00101\u001a\b\u0012\u0004\u0012\u0002020\u0005\u0012\u0012\u00103\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000b0\b0\u0005\u0012\f\u00104\u001a\b\u0012\u0004\u0012\u0002020\u0005\u0012\f\u00105\u001a\b\u0012\u0004\u0012\u00020)0\u0005\u0012\u0012\u00106\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020)0\b0\u0005\u0012\u0012\u00107\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001d0\b0\u0005\u0012\u0012\u00108\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002090\u00160\u0005\u0012\f\u0010:\u001a\b\u0012\u0004\u0012\u00020;0\u0005\u0012\f\u0010<\u001a\b\u0012\u0004\u0012\u00020=0\u0005\u0012\u0012\u0010>\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020?0\u00160\u0005\u0012\f\u0010@\u001a\b\u0012\u0004\u0012\u00020A0\u0005\u0012\f\u0010B\u001a\b\u0012\u0004\u0012\u00020C0\u0005\u0012\f\u0010D\u001a\b\u0012\u0004\u0012\u00020E0\u0005\u0012\f\u0010F\u001a\b\u0012\u0004\u0012\u00020E0\u0005\u0012\u0012\u0010G\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020H0\u00160\u0005\u0012\u0012\u0010I\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020J0\u00160\u0005\u0012\u0012\u0010K\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020L0\u00160\u0005\u0012\u0012\u0010M\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020N0\b0\u0005\u0012\f\u0010O\u001a\b\u0012\u0004\u0012\u00020P0\u0005\u0012\u0012\u0010Q\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020P0\u00160\u0005\u0012\f\u0010R\u001a\b\u0012\u0004\u0012\u00020'0\u0005¢\u0006\u0002\u0010SB-\b\u0016\u0012\u0006\u0010T\u001a\u00020U\u0012\n\b\u0002\u0010V\u001a\u0004\u0018\u00010\u0000\u0012\b\b\u0002\u0010W\u001a\u00020X\u0012\u0006\u0010Y\u001a\u00020Z¢\u0006\u0002\u0010[J\u0018\u0010\\\u001a\u00020\u00032\u0006\u0010T\u001a\u00020U2\u0006\u0010]\u001a\u00020ZH\u0016J\b\u0010^\u001a\u00020ZH\u0016R\u0016\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u00058\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\u0007\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0\b0\u00058\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\n\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000b0\b0\u00058\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\f\u001a\b\u0012\u0004\u0012\u00020\r0\u00058\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\u000e\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000f0\b0\u00058\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\u0010\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00110\b0\u00058\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\u0012\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000b0\b0\u00058\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\u0013\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00140\b0\u00058\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\u0015\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00170\u00160\u00058\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\u0018\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00190\u00160\u00058\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u001b0\u00058\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\u001c\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001d0\b0\u00058\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\u001e\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001f0\u00160\u00058\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u001c\u0010 \u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020!0\u00160\u00058\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\"\u001a\b\u0012\u0004\u0012\u00020#0\u00058\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u001c\u0010$\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020%0\u00160\u00058\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0016\u0010&\u001a\b\u0012\u0004\u0012\u00020'0\u00058\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0016\u0010(\u001a\b\u0012\u0004\u0012\u00020)0\u00058\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u001c\u0010*\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0\b0\u00058\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0016\u0010+\u001a\b\u0012\u0004\u0012\u00020\r0\u00058\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0016\u0010,\u001a\b\u0012\u0004\u0012\u00020\r0\u00058\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0016\u0010-\u001a\b\u0012\u0004\u0012\u00020.0\u00058\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0016\u0010/\u001a\b\u0012\u0004\u0012\u0002000\u00058\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0016\u00101\u001a\b\u0012\u0004\u0012\u0002020\u00058\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u001c\u00103\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000b0\b0\u00058\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0016\u00104\u001a\b\u0012\u0004\u0012\u0002020\u00058\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0016\u00105\u001a\b\u0012\u0004\u0012\u00020)0\u00058\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u001c\u00106\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020)0\b0\u00058\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u001c\u00107\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001d0\b0\u00058\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u001c\u00108\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002090\u00160\u00058\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0016\u0010:\u001a\b\u0012\u0004\u0012\u00020;0\u00058\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0016\u0010<\u001a\b\u0012\u0004\u0012\u00020=0\u00058\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u001c\u0010>\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020?0\u00160\u00058\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0016\u0010@\u001a\b\u0012\u0004\u0012\u00020A0\u00058\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0016\u0010B\u001a\b\u0012\u0004\u0012\u00020C0\u00058\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0016\u0010D\u001a\b\u0012\u0004\u0012\u00020E0\u00058\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0016\u0010F\u001a\b\u0012\u0004\u0012\u00020E0\u00058\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u001c\u0010G\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020H0\u00160\u00058\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u001c\u0010I\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020J0\u00160\u00058\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u001c\u0010K\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020L0\u00160\u00058\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u001c\u0010M\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020N0\b0\u00058\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0016\u0010O\u001a\b\u0012\u0004\u0012\u00020P0\u00058\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u001c\u0010Q\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020P0\u00160\u00058\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0016\u0010R\u001a\b\u0012\u0004\u0012\u00020'0\u00058\u0006X\u0087\u0004¢\u0006\u0002\n\u0000¨\u0006`"}, d2 = {"Lcom/yandex/div2/DivIndicatorTemplate;", "Lcom/yandex/div/json/JSONSerializable;", "Lcom/yandex/div/json/JsonTemplate;", "Lcom/yandex/div2/DivIndicator;", "accessibility", "Lcom/yandex/div/internal/template/Field;", "Lcom/yandex/div2/DivAccessibilityTemplate;", "activeItemColor", "Lcom/yandex/div/json/expressions/Expression;", "", "activeItemSize", "", "activeShape", "Lcom/yandex/div2/DivRoundedRectangleShapeTemplate;", "alignmentHorizontal", "Lcom/yandex/div2/DivAlignmentHorizontal;", "alignmentVertical", "Lcom/yandex/div2/DivAlignmentVertical;", "alpha", "animation", "Lcom/yandex/div2/DivIndicator$Animation;", "animators", "", "Lcom/yandex/div2/DivAnimatorTemplate;", J2.g, "Lcom/yandex/div2/DivBackgroundTemplate;", OutlinedTextFieldKt.BorderId, "Lcom/yandex/div2/DivBorderTemplate;", "columnSpan", "", "disappearActions", "Lcom/yandex/div2/DivDisappearActionTemplate;", "extensions", "Lcom/yandex/div2/DivExtensionTemplate;", "focus", "Lcom/yandex/div2/DivFocusTemplate;", "functions", "Lcom/yandex/div2/DivFunctionTemplate;", "height", "Lcom/yandex/div2/DivSizeTemplate;", "id", "", "inactiveItemColor", "inactiveMinimumShape", "inactiveShape", "itemsPlacement", "Lcom/yandex/div2/DivIndicatorItemPlacementTemplate;", "layoutProvider", "Lcom/yandex/div2/DivLayoutProviderTemplate;", "margins", "Lcom/yandex/div2/DivEdgeInsetsTemplate;", "minimumItemSize", "paddings", "pagerId", "reuseId", "rowSpan", "selectedActions", "Lcom/yandex/div2/DivActionTemplate;", "shape", "Lcom/yandex/div2/DivShapeTemplate;", "spaceBetweenCenters", "Lcom/yandex/div2/DivFixedSizeTemplate;", "tooltips", "Lcom/yandex/div2/DivTooltipTemplate;", "transform", "Lcom/yandex/div2/DivTransformTemplate;", "transitionChange", "Lcom/yandex/div2/DivChangeTransitionTemplate;", "transitionIn", "Lcom/yandex/div2/DivAppearanceTransitionTemplate;", "transitionOut", "transitionTriggers", "Lcom/yandex/div2/DivTransitionTrigger;", "variableTriggers", "Lcom/yandex/div2/DivTriggerTemplate;", "variables", "Lcom/yandex/div2/DivVariableTemplate;", "visibility", "Lcom/yandex/div2/DivVisibility;", "visibilityAction", "Lcom/yandex/div2/DivVisibilityActionTemplate;", "visibilityActions", "width", "(Lcom/yandex/div/internal/template/Field;Lcom/yandex/div/internal/template/Field;Lcom/yandex/div/internal/template/Field;Lcom/yandex/div/internal/template/Field;Lcom/yandex/div/internal/template/Field;Lcom/yandex/div/internal/template/Field;Lcom/yandex/div/internal/template/Field;Lcom/yandex/div/internal/template/Field;Lcom/yandex/div/internal/template/Field;Lcom/yandex/div/internal/template/Field;Lcom/yandex/div/internal/template/Field;Lcom/yandex/div/internal/template/Field;Lcom/yandex/div/internal/template/Field;Lcom/yandex/div/internal/template/Field;Lcom/yandex/div/internal/template/Field;Lcom/yandex/div/internal/template/Field;Lcom/yandex/div/internal/template/Field;Lcom/yandex/div/internal/template/Field;Lcom/yandex/div/internal/template/Field;Lcom/yandex/div/internal/template/Field;Lcom/yandex/div/internal/template/Field;Lcom/yandex/div/internal/template/Field;Lcom/yandex/div/internal/template/Field;Lcom/yandex/div/internal/template/Field;Lcom/yandex/div/internal/template/Field;Lcom/yandex/div/internal/template/Field;Lcom/yandex/div/internal/template/Field;Lcom/yandex/div/internal/template/Field;Lcom/yandex/div/internal/template/Field;Lcom/yandex/div/internal/template/Field;Lcom/yandex/div/internal/template/Field;Lcom/yandex/div/internal/template/Field;Lcom/yandex/div/internal/template/Field;Lcom/yandex/div/internal/template/Field;Lcom/yandex/div/internal/template/Field;Lcom/yandex/div/internal/template/Field;Lcom/yandex/div/internal/template/Field;Lcom/yandex/div/internal/template/Field;Lcom/yandex/div/internal/template/Field;Lcom/yandex/div/internal/template/Field;Lcom/yandex/div/internal/template/Field;Lcom/yandex/div/internal/template/Field;Lcom/yandex/div/internal/template/Field;Lcom/yandex/div/internal/template/Field;)V", cc.o, "Lcom/yandex/div/json/ParsingEnvironment;", "parent", "topLevel", "", "json", "Lorg/json/JSONObject;", "(Lcom/yandex/div/json/ParsingEnvironment;Lcom/yandex/div2/DivIndicatorTemplate;ZLorg/json/JSONObject;)V", "resolve", "data", "writeToJSON", "Companion", "div-data_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class DivIndicatorTemplate implements JSONSerializable, JsonTemplate<DivIndicator> {
    private static final Function2<ParsingEnvironment, JSONObject, DivIndicatorTemplate> CREATOR;
    private static final DivShape.RoundedRectangle SHAPE_DEFAULT_VALUE;
    private static final DivFixedSize SPACE_BETWEEN_CENTERS_DEFAULT_VALUE;
    public static final String TYPE = "indicator";
    private static final Expression<DivVisibility> VISIBILITY_DEFAULT_VALUE;
    private static final DivSize.MatchParent WIDTH_DEFAULT_VALUE;
    public final Field<DivAccessibilityTemplate> accessibility;
    public final Field<Expression<Integer>> activeItemColor;
    public final Field<Expression<Double>> activeItemSize;
    public final Field<DivRoundedRectangleShapeTemplate> activeShape;
    public final Field<Expression<DivAlignmentHorizontal>> alignmentHorizontal;
    public final Field<Expression<DivAlignmentVertical>> alignmentVertical;
    public final Field<Expression<Double>> alpha;
    public final Field<Expression<DivIndicator.Animation>> animation;
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
    public final Field<Expression<Integer>> inactiveItemColor;
    public final Field<DivRoundedRectangleShapeTemplate> inactiveMinimumShape;
    public final Field<DivRoundedRectangleShapeTemplate> inactiveShape;
    public final Field<DivIndicatorItemPlacementTemplate> itemsPlacement;
    public final Field<DivLayoutProviderTemplate> layoutProvider;
    public final Field<DivEdgeInsetsTemplate> margins;
    public final Field<Expression<Double>> minimumItemSize;
    public final Field<DivEdgeInsetsTemplate> paddings;
    public final Field<String> pagerId;
    public final Field<Expression<String>> reuseId;
    public final Field<Expression<Long>> rowSpan;
    public final Field<List<DivActionTemplate>> selectedActions;
    public final Field<DivShapeTemplate> shape;
    public final Field<DivFixedSizeTemplate> spaceBetweenCenters;
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
    private static final Expression<Integer> ACTIVE_ITEM_COLOR_DEFAULT_VALUE = Expression.INSTANCE.constant(16768096);
    private static final Expression<Double> ACTIVE_ITEM_SIZE_DEFAULT_VALUE = Expression.INSTANCE.constant(Double.valueOf(1.3d));
    private static final Expression<Double> ALPHA_DEFAULT_VALUE = Expression.INSTANCE.constant(Double.valueOf(1.0d));
    private static final Expression<DivIndicator.Animation> ANIMATION_DEFAULT_VALUE = Expression.INSTANCE.constant(DivIndicator.Animation.SCALE);
    private static final DivSize.WrapContent HEIGHT_DEFAULT_VALUE = new DivSize.WrapContent(new DivWrapContentSize(null, null, null, 7, null));
    private static final Expression<Integer> INACTIVE_ITEM_COLOR_DEFAULT_VALUE = Expression.INSTANCE.constant(865180853);
    private static final Expression<Double> MINIMUM_ITEM_SIZE_DEFAULT_VALUE = Expression.INSTANCE.constant(Double.valueOf(0.5d));

    public DivIndicatorTemplate(Field<DivAccessibilityTemplate> accessibility, Field<Expression<Integer>> activeItemColor, Field<Expression<Double>> activeItemSize, Field<DivRoundedRectangleShapeTemplate> activeShape, Field<Expression<DivAlignmentHorizontal>> alignmentHorizontal, Field<Expression<DivAlignmentVertical>> alignmentVertical, Field<Expression<Double>> alpha, Field<Expression<DivIndicator.Animation>> animation, Field<List<DivAnimatorTemplate>> animators, Field<List<DivBackgroundTemplate>> background, Field<DivBorderTemplate> border, Field<Expression<Long>> columnSpan, Field<List<DivDisappearActionTemplate>> disappearActions, Field<List<DivExtensionTemplate>> extensions, Field<DivFocusTemplate> focus, Field<List<DivFunctionTemplate>> functions, Field<DivSizeTemplate> height, Field<String> id, Field<Expression<Integer>> inactiveItemColor, Field<DivRoundedRectangleShapeTemplate> inactiveMinimumShape, Field<DivRoundedRectangleShapeTemplate> inactiveShape, Field<DivIndicatorItemPlacementTemplate> itemsPlacement, Field<DivLayoutProviderTemplate> layoutProvider, Field<DivEdgeInsetsTemplate> margins, Field<Expression<Double>> minimumItemSize, Field<DivEdgeInsetsTemplate> paddings, Field<String> pagerId, Field<Expression<String>> reuseId, Field<Expression<Long>> rowSpan, Field<List<DivActionTemplate>> selectedActions, Field<DivShapeTemplate> shape, Field<DivFixedSizeTemplate> spaceBetweenCenters, Field<List<DivTooltipTemplate>> tooltips, Field<DivTransformTemplate> transform, Field<DivChangeTransitionTemplate> transitionChange, Field<DivAppearanceTransitionTemplate> transitionIn, Field<DivAppearanceTransitionTemplate> transitionOut, Field<List<DivTransitionTrigger>> transitionTriggers, Field<List<DivTriggerTemplate>> variableTriggers, Field<List<DivVariableTemplate>> variables, Field<Expression<DivVisibility>> visibility, Field<DivVisibilityActionTemplate> visibilityAction, Field<List<DivVisibilityActionTemplate>> visibilityActions, Field<DivSizeTemplate> width) {
        Intrinsics.checkNotNullParameter(accessibility, "accessibility");
        Intrinsics.checkNotNullParameter(activeItemColor, "activeItemColor");
        Intrinsics.checkNotNullParameter(activeItemSize, "activeItemSize");
        Intrinsics.checkNotNullParameter(activeShape, "activeShape");
        Intrinsics.checkNotNullParameter(alignmentHorizontal, "alignmentHorizontal");
        Intrinsics.checkNotNullParameter(alignmentVertical, "alignmentVertical");
        Intrinsics.checkNotNullParameter(alpha, "alpha");
        Intrinsics.checkNotNullParameter(animation, "animation");
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
        Intrinsics.checkNotNullParameter(inactiveItemColor, "inactiveItemColor");
        Intrinsics.checkNotNullParameter(inactiveMinimumShape, "inactiveMinimumShape");
        Intrinsics.checkNotNullParameter(inactiveShape, "inactiveShape");
        Intrinsics.checkNotNullParameter(itemsPlacement, "itemsPlacement");
        Intrinsics.checkNotNullParameter(layoutProvider, "layoutProvider");
        Intrinsics.checkNotNullParameter(margins, "margins");
        Intrinsics.checkNotNullParameter(minimumItemSize, "minimumItemSize");
        Intrinsics.checkNotNullParameter(paddings, "paddings");
        Intrinsics.checkNotNullParameter(pagerId, "pagerId");
        Intrinsics.checkNotNullParameter(reuseId, "reuseId");
        Intrinsics.checkNotNullParameter(rowSpan, "rowSpan");
        Intrinsics.checkNotNullParameter(selectedActions, "selectedActions");
        Intrinsics.checkNotNullParameter(shape, "shape");
        Intrinsics.checkNotNullParameter(spaceBetweenCenters, "spaceBetweenCenters");
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
        this.activeItemColor = activeItemColor;
        this.activeItemSize = activeItemSize;
        this.activeShape = activeShape;
        this.alignmentHorizontal = alignmentHorizontal;
        this.alignmentVertical = alignmentVertical;
        this.alpha = alpha;
        this.animation = animation;
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
        this.inactiveItemColor = inactiveItemColor;
        this.inactiveMinimumShape = inactiveMinimumShape;
        this.inactiveShape = inactiveShape;
        this.itemsPlacement = itemsPlacement;
        this.layoutProvider = layoutProvider;
        this.margins = margins;
        this.minimumItemSize = minimumItemSize;
        this.paddings = paddings;
        this.pagerId = pagerId;
        this.reuseId = reuseId;
        this.rowSpan = rowSpan;
        this.selectedActions = selectedActions;
        this.shape = shape;
        this.spaceBetweenCenters = spaceBetweenCenters;
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

    public /* synthetic */ DivIndicatorTemplate(ParsingEnvironment parsingEnvironment, DivIndicatorTemplate divIndicatorTemplate, boolean z, JSONObject jSONObject, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(parsingEnvironment, (i & 2) != 0 ? null : divIndicatorTemplate, (i & 4) != 0 ? false : z, jSONObject);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public DivIndicatorTemplate(ParsingEnvironment env, DivIndicatorTemplate divIndicatorTemplate, boolean z, JSONObject json) {
        this(Field.INSTANCE.nullField(false), Field.INSTANCE.nullField(false), Field.INSTANCE.nullField(false), Field.INSTANCE.nullField(false), Field.INSTANCE.nullField(false), Field.INSTANCE.nullField(false), Field.INSTANCE.nullField(false), Field.INSTANCE.nullField(false), Field.INSTANCE.nullField(false), Field.INSTANCE.nullField(false), Field.INSTANCE.nullField(false), Field.INSTANCE.nullField(false), Field.INSTANCE.nullField(false), Field.INSTANCE.nullField(false), Field.INSTANCE.nullField(false), Field.INSTANCE.nullField(false), Field.INSTANCE.nullField(false), Field.INSTANCE.nullField(false), Field.INSTANCE.nullField(false), Field.INSTANCE.nullField(false), Field.INSTANCE.nullField(false), Field.INSTANCE.nullField(false), Field.INSTANCE.nullField(false), Field.INSTANCE.nullField(false), Field.INSTANCE.nullField(false), Field.INSTANCE.nullField(false), Field.INSTANCE.nullField(false), Field.INSTANCE.nullField(false), Field.INSTANCE.nullField(false), Field.INSTANCE.nullField(false), Field.INSTANCE.nullField(false), Field.INSTANCE.nullField(false), Field.INSTANCE.nullField(false), Field.INSTANCE.nullField(false), Field.INSTANCE.nullField(false), Field.INSTANCE.nullField(false), Field.INSTANCE.nullField(false), Field.INSTANCE.nullField(false), Field.INSTANCE.nullField(false), Field.INSTANCE.nullField(false), Field.INSTANCE.nullField(false), Field.INSTANCE.nullField(false), Field.INSTANCE.nullField(false), Field.INSTANCE.nullField(false));
        Intrinsics.checkNotNullParameter(env, "env");
        Intrinsics.checkNotNullParameter(json, "json");
        throw new UnsupportedOperationException("Do not use this constructor directly.");
    }

    @Override // com.yandex.div.json.JsonTemplate
    public DivIndicator resolve(ParsingEnvironment env, JSONObject data) {
        Intrinsics.checkNotNullParameter(env, "env");
        Intrinsics.checkNotNullParameter(data, "data");
        return BuiltInParserKt.getBuiltInParserComponent().getDivIndicatorJsonTemplateResolver().getValue().resolve((ParsingContext) env, this, data);
    }

    @Override // com.yandex.div.json.JSONSerializable
    public JSONObject writeToJSON() {
        return BuiltInParserKt.getBuiltInParserComponent().getDivIndicatorJsonTemplateParser().getValue().serialize(BuiltInParserKt.getBuiltInParsingContext(), this);
    }

    /* JADX INFO: compiled from: DivIndicatorTemplate.kt */
    @Metadata(d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0006\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00070\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\t\u001a\b\u0012\u0004\u0012\u00020\n0\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R#\u0010\u000b\u001a\u0014\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u000f0\f¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u000e\u0010\u0012\u001a\u00020\u0013X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00070\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0017X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0019X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u001bX\u0086T¢\u0006\u0002\n\u0000R\u0014\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u001d0\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\u001fX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006 "}, d2 = {"Lcom/yandex/div2/DivIndicatorTemplate$Companion;", "", "()V", "ACTIVE_ITEM_COLOR_DEFAULT_VALUE", "Lcom/yandex/div/json/expressions/Expression;", "", "ACTIVE_ITEM_SIZE_DEFAULT_VALUE", "", "ALPHA_DEFAULT_VALUE", "ANIMATION_DEFAULT_VALUE", "Lcom/yandex/div2/DivIndicator$Animation;", "CREATOR", "Lkotlin/Function2;", "Lcom/yandex/div/json/ParsingEnvironment;", "Lorg/json/JSONObject;", "Lcom/yandex/div2/DivIndicatorTemplate;", "getCREATOR", "()Lkotlin/jvm/functions/Function2;", "HEIGHT_DEFAULT_VALUE", "Lcom/yandex/div2/DivSize$WrapContent;", "INACTIVE_ITEM_COLOR_DEFAULT_VALUE", "MINIMUM_ITEM_SIZE_DEFAULT_VALUE", "SHAPE_DEFAULT_VALUE", "Lcom/yandex/div2/DivShape$RoundedRectangle;", "SPACE_BETWEEN_CENTERS_DEFAULT_VALUE", "Lcom/yandex/div2/DivFixedSize;", "TYPE", "", "VISIBILITY_DEFAULT_VALUE", "Lcom/yandex/div2/DivVisibility;", "WIDTH_DEFAULT_VALUE", "Lcom/yandex/div2/DivSize$MatchParent;", "div-data_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final Function2<ParsingEnvironment, JSONObject, DivIndicatorTemplate> getCREATOR() {
            return DivIndicatorTemplate.CREATOR;
        }
    }

    static {
        byte b = 0 == true ? 1 : 0;
        SHAPE_DEFAULT_VALUE = new DivShape.RoundedRectangle(new DivRoundedRectangleShape(null, 0 == true ? 1 : 0, 0 == true ? 1 : 0, null, b, 31, null));
        int i = 1;
        SPACE_BETWEEN_CENTERS_DEFAULT_VALUE = new DivFixedSize(0 == true ? 1 : 0, Expression.INSTANCE.constant(15L), i, 0 == true ? 1 : 0);
        VISIBILITY_DEFAULT_VALUE = Expression.INSTANCE.constant(DivVisibility.VISIBLE);
        WIDTH_DEFAULT_VALUE = new DivSize.MatchParent(new DivMatchParentSize(0 == true ? 1 : 0, i, 0 == true ? 1 : 0));
        CREATOR = new Function2<ParsingEnvironment, JSONObject, DivIndicatorTemplate>() { // from class: com.yandex.div2.DivIndicatorTemplate$Companion$CREATOR$1
            @Override // kotlin.jvm.functions.Function2
            public final DivIndicatorTemplate invoke(ParsingEnvironment env, JSONObject it) {
                Intrinsics.checkNotNullParameter(env, "env");
                Intrinsics.checkNotNullParameter(it, "it");
                return new DivIndicatorTemplate(env, null, false, it, 6, null);
            }
        };
    }
}
