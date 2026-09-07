package com.yandex.div2;

import androidx.compose.material.OutlinedTextFieldKt;
import com.json.cc;
import com.yandex.div.data.Hashable;
import com.yandex.div.json.JSONSerializable;
import com.yandex.div.json.ParsingEnvironment;
import com.yandex.div.json.expressions.Expression;
import com.yandex.div.json.expressions.ExpressionResolver;
import com.yandex.div.serialization.BuiltInParserKt;
import com.yandex.div.serialization.ParsingContext;
import io.appmetrica.analytics.impl.J2;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import org.json.JSONObject;

/* JADX INFO: compiled from: DivState.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(d1 = {"\u0000ì\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0006\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b3\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 \u0085\u00012\u00020\u00012\u00020\u00022\u00020\u0003:\u0004\u0085\u0001\u0086\u0001BÃ\u0004\b\u0007\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\u0010\b\u0002\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007\u0012\u0010\b\u0002\u0010\t\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\u0007\u0012\u000e\b\u0002\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\f0\u0007\u0012\u0010\b\u0002\u0010\r\u001a\n\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u000e\u0012\u0010\b\u0002\u0010\u0010\u001a\n\u0012\u0004\u0012\u00020\u0011\u0018\u00010\u000e\u0012\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u0013\u0012\u000e\b\u0002\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00150\u0007\u0012\u0010\b\u0002\u0010\u0016\u001a\n\u0012\u0004\u0012\u00020\u0017\u0018\u00010\u0007\u0012\u0010\b\u0002\u0010\u0018\u001a\n\u0012\u0004\u0012\u00020\u0019\u0018\u00010\u0007\u0012\u0010\b\u0002\u0010\u001a\u001a\n\u0012\u0004\u0012\u00020\u001b\u0018\u00010\u000e\u0012\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\u0019\u0012\u0010\b\u0002\u0010\u001d\u001a\n\u0012\u0004\u0012\u00020\u001e\u0018\u00010\u000e\u0012\n\b\u0002\u0010\u001f\u001a\u0004\u0018\u00010 \u0012\u0010\b\u0002\u0010!\u001a\n\u0012\u0004\u0012\u00020\"\u0018\u00010\u000e\u0012\b\b\u0002\u0010#\u001a\u00020$\u0012\n\b\u0002\u0010%\u001a\u0004\u0018\u00010\u0019\u0012\n\b\u0002\u0010&\u001a\u0004\u0018\u00010'\u0012\n\b\u0002\u0010(\u001a\u0004\u0018\u00010)\u0012\n\b\u0002\u0010*\u001a\u0004\u0018\u00010)\u0012\u0010\b\u0002\u0010+\u001a\n\u0012\u0004\u0012\u00020\u0019\u0018\u00010\u0007\u0012\u0010\b\u0002\u0010,\u001a\n\u0012\u0004\u0012\u00020\u0017\u0018\u00010\u0007\u0012\u0010\b\u0002\u0010-\u001a\n\u0012\u0004\u0012\u00020.\u0018\u00010\u000e\u0012\n\b\u0002\u0010/\u001a\u0004\u0018\u00010\u0019\u0012\f\u00100\u001a\b\u0012\u0004\u0012\u0002010\u000e\u0012\u0010\b\u0002\u00102\u001a\n\u0012\u0004\u0012\u000203\u0018\u00010\u000e\u0012\n\b\u0002\u00104\u001a\u0004\u0018\u000105\u0012\u000e\b\u0002\u00106\u001a\b\u0012\u0004\u0012\u0002070\u0007\u0012\n\b\u0002\u00108\u001a\u0004\u0018\u000109\u0012\n\b\u0002\u0010:\u001a\u0004\u0018\u00010;\u0012\n\b\u0002\u0010<\u001a\u0004\u0018\u00010;\u0012\u0010\b\u0002\u0010=\u001a\n\u0012\u0004\u0012\u00020>\u0018\u00010\u000e\u0012\u0010\b\u0002\u0010?\u001a\n\u0012\u0004\u0012\u00020@\u0018\u00010\u000e\u0012\u0010\b\u0002\u0010A\u001a\n\u0012\u0004\u0012\u00020B\u0018\u00010\u000e\u0012\u000e\b\u0002\u0010C\u001a\b\u0012\u0004\u0012\u00020D0\u0007\u0012\n\b\u0002\u0010E\u001a\u0004\u0018\u00010F\u0012\u0010\b\u0002\u0010G\u001a\n\u0012\u0004\u0012\u00020F\u0018\u00010\u000e\u0012\b\b\u0002\u0010H\u001a\u00020$¢\u0006\u0002\u0010IJÄ\u0004\u0010{\u001a\u00020\u00002\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0010\b\u0002\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u00072\u0010\b\u0002\u0010\t\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\u00072\u000e\b\u0002\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\f0\u00072\u0010\b\u0002\u0010\r\u001a\n\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u000e2\u0010\b\u0002\u0010\u0010\u001a\n\u0012\u0004\u0012\u00020\u0011\u0018\u00010\u000e2\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u00132\u000e\b\u0002\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00150\u00072\u0010\b\u0002\u0010\u0016\u001a\n\u0012\u0004\u0012\u00020\u0017\u0018\u00010\u00072\u0010\b\u0002\u0010\u0018\u001a\n\u0012\u0004\u0012\u00020\u0019\u0018\u00010\u00072\u0010\b\u0002\u0010\u001a\u001a\n\u0012\u0004\u0012\u00020\u001b\u0018\u00010\u000e2\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\u00192\u0010\b\u0002\u0010\u001d\u001a\n\u0012\u0004\u0012\u00020\u001e\u0018\u00010\u000e2\n\b\u0002\u0010\u001f\u001a\u0004\u0018\u00010 2\u0010\b\u0002\u0010!\u001a\n\u0012\u0004\u0012\u00020\"\u0018\u00010\u000e2\b\b\u0002\u0010#\u001a\u00020$2\n\b\u0002\u0010%\u001a\u0004\u0018\u00010\u00192\n\b\u0002\u0010&\u001a\u0004\u0018\u00010'2\n\b\u0002\u0010(\u001a\u0004\u0018\u00010)2\n\b\u0002\u0010*\u001a\u0004\u0018\u00010)2\u0010\b\u0002\u0010+\u001a\n\u0012\u0004\u0012\u00020\u0019\u0018\u00010\u00072\u0010\b\u0002\u0010,\u001a\n\u0012\u0004\u0012\u00020\u0017\u0018\u00010\u00072\u0010\b\u0002\u0010-\u001a\n\u0012\u0004\u0012\u00020.\u0018\u00010\u000e2\n\b\u0002\u0010/\u001a\u0004\u0018\u00010\u00192\u000e\b\u0002\u00100\u001a\b\u0012\u0004\u0012\u0002010\u000e2\u0010\b\u0002\u00102\u001a\n\u0012\u0004\u0012\u000203\u0018\u00010\u000e2\n\b\u0002\u00104\u001a\u0004\u0018\u0001052\u000e\b\u0002\u00106\u001a\b\u0012\u0004\u0012\u0002070\u00072\n\b\u0002\u00108\u001a\u0004\u0018\u0001092\n\b\u0002\u0010:\u001a\u0004\u0018\u00010;2\n\b\u0002\u0010<\u001a\u0004\u0018\u00010;2\u0010\b\u0002\u0010=\u001a\n\u0012\u0004\u0012\u00020>\u0018\u00010\u000e2\u0010\b\u0002\u0010?\u001a\n\u0012\u0004\u0012\u00020@\u0018\u00010\u000e2\u0010\b\u0002\u0010A\u001a\n\u0012\u0004\u0012\u00020B\u0018\u00010\u000e2\u000e\b\u0002\u0010C\u001a\b\u0012\u0004\u0012\u00020D0\u00072\n\b\u0002\u0010E\u001a\u0004\u0018\u00010F2\u0010\b\u0002\u0010G\u001a\n\u0012\u0004\u0012\u00020F\u0018\u00010\u000e2\b\b\u0002\u0010H\u001a\u00020$J!\u0010|\u001a\u00020\u00152\b\u0010}\u001a\u0004\u0018\u00010\u00002\u0006\u0010~\u001a\u00020\u007f2\u0007\u0010\u0080\u0001\u001a\u00020\u007fJ\t\u0010\u0081\u0001\u001a\u00020KH\u0016J\t\u0010\u0082\u0001\u001a\u00020KH\u0016J\n\u0010\u0083\u0001\u001a\u00030\u0084\u0001H\u0016R\u0012\u0010J\u001a\u0004\u0018\u00010KX\u0082\u000e¢\u0006\u0004\n\u0002\u0010LR\u0012\u0010M\u001a\u0004\u0018\u00010KX\u0082\u000e¢\u0006\u0004\n\u0002\u0010LR\u0016\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\bN\u0010OR\u001c\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\bP\u0010QR\u001c\u0010\t\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\u0007X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\bR\u0010QR\u001a\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\f0\u0007X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\bS\u0010QR\u001c\u0010\r\u001a\n\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u000eX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\bT\u0010UR\u001c\u0010\u0010\u001a\n\u0012\u0004\u0012\u00020\u0011\u0018\u00010\u000eX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\bV\u0010UR\u0016\u0010\u0012\u001a\u0004\u0018\u00010\u0013X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\bW\u0010XR\u0016\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00150\u00078\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\u0016\u001a\n\u0012\u0004\u0012\u00020\u0017\u0018\u00010\u0007X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\bY\u0010QR\u0018\u0010\u0018\u001a\n\u0012\u0004\u0012\u00020\u0019\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\u001a\u001a\n\u0012\u0004\u0012\u00020\u001b\u0018\u00010\u000eX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\bZ\u0010UR\u0012\u0010\u001c\u001a\u0004\u0018\u00010\u00198\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\u001d\u001a\n\u0012\u0004\u0012\u00020\u001e\u0018\u00010\u000eX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b[\u0010UR\u0016\u0010\u001f\u001a\u0004\u0018\u00010 X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\\\u0010]R\u001c\u0010!\u001a\n\u0012\u0004\u0012\u00020\"\u0018\u00010\u000eX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b^\u0010UR\u0014\u0010#\u001a\u00020$X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b_\u0010`R\u0016\u0010%\u001a\u0004\u0018\u00010\u0019X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\ba\u0010bR\u0016\u0010&\u001a\u0004\u0018\u00010'X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\bc\u0010dR\u0016\u0010(\u001a\u0004\u0018\u00010)X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\be\u0010fR\u0016\u0010*\u001a\u0004\u0018\u00010)X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\bg\u0010fR\u001c\u0010+\u001a\n\u0012\u0004\u0012\u00020\u0019\u0018\u00010\u0007X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\bh\u0010QR\u001c\u0010,\u001a\n\u0012\u0004\u0012\u00020\u0017\u0018\u00010\u0007X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\bi\u0010QR\u001c\u0010-\u001a\n\u0012\u0004\u0012\u00020.\u0018\u00010\u000eX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\bj\u0010UR\u0012\u0010/\u001a\u0004\u0018\u00010\u00198\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0016\u00100\u001a\b\u0012\u0004\u0012\u0002010\u000e8\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u001c\u00102\u001a\n\u0012\u0004\u0012\u000203\u0018\u00010\u000eX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\bk\u0010UR\u0016\u00104\u001a\u0004\u0018\u000105X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\bl\u0010mR\u0016\u00106\u001a\b\u0012\u0004\u0012\u0002070\u00078\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0016\u00108\u001a\u0004\u0018\u000109X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\bn\u0010oR\u0016\u0010:\u001a\u0004\u0018\u00010;X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\bp\u0010qR\u0016\u0010<\u001a\u0004\u0018\u00010;X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\br\u0010qR\u001c\u0010=\u001a\n\u0012\u0004\u0012\u00020>\u0018\u00010\u000eX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\bs\u0010UR\u001c\u0010?\u001a\n\u0012\u0004\u0012\u00020@\u0018\u00010\u000eX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\bt\u0010UR\u001c\u0010A\u001a\n\u0012\u0004\u0012\u00020B\u0018\u00010\u000eX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\bu\u0010UR\u001a\u0010C\u001a\b\u0012\u0004\u0012\u00020D0\u0007X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\bv\u0010QR\u0016\u0010E\u001a\u0004\u0018\u00010FX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\bw\u0010xR\u001c\u0010G\u001a\n\u0012\u0004\u0012\u00020F\u0018\u00010\u000eX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\by\u0010UR\u0014\u0010H\u001a\u00020$X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\bz\u0010`¨\u0006\u0087\u0001"}, d2 = {"Lcom/yandex/div2/DivState;", "Lcom/yandex/div/json/JSONSerializable;", "Lcom/yandex/div/data/Hashable;", "Lcom/yandex/div2/DivBase;", "accessibility", "Lcom/yandex/div2/DivAccessibility;", "alignmentHorizontal", "Lcom/yandex/div/json/expressions/Expression;", "Lcom/yandex/div2/DivAlignmentHorizontal;", "alignmentVertical", "Lcom/yandex/div2/DivAlignmentVertical;", "alpha", "", "animators", "", "Lcom/yandex/div2/DivAnimator;", J2.g, "Lcom/yandex/div2/DivBackground;", OutlinedTextFieldKt.BorderId, "Lcom/yandex/div2/DivBorder;", "clipToBounds", "", "columnSpan", "", "defaultStateId", "", "disappearActions", "Lcom/yandex/div2/DivDisappearAction;", "divId", "extensions", "Lcom/yandex/div2/DivExtension;", "focus", "Lcom/yandex/div2/DivFocus;", "functions", "Lcom/yandex/div2/DivFunction;", "height", "Lcom/yandex/div2/DivSize;", "id", "layoutProvider", "Lcom/yandex/div2/DivLayoutProvider;", "margins", "Lcom/yandex/div2/DivEdgeInsets;", "paddings", "reuseId", "rowSpan", "selectedActions", "Lcom/yandex/div2/DivAction;", "stateIdVariable", "states", "Lcom/yandex/div2/DivState$State;", "tooltips", "Lcom/yandex/div2/DivTooltip;", "transform", "Lcom/yandex/div2/DivTransform;", "transitionAnimationSelector", "Lcom/yandex/div2/DivTransitionSelector;", "transitionChange", "Lcom/yandex/div2/DivChangeTransition;", "transitionIn", "Lcom/yandex/div2/DivAppearanceTransition;", "transitionOut", "transitionTriggers", "Lcom/yandex/div2/DivTransitionTrigger;", "variableTriggers", "Lcom/yandex/div2/DivTrigger;", "variables", "Lcom/yandex/div2/DivVariable;", "visibility", "Lcom/yandex/div2/DivVisibility;", "visibilityAction", "Lcom/yandex/div2/DivVisibilityAction;", "visibilityActions", "width", "(Lcom/yandex/div2/DivAccessibility;Lcom/yandex/div/json/expressions/Expression;Lcom/yandex/div/json/expressions/Expression;Lcom/yandex/div/json/expressions/Expression;Ljava/util/List;Ljava/util/List;Lcom/yandex/div2/DivBorder;Lcom/yandex/div/json/expressions/Expression;Lcom/yandex/div/json/expressions/Expression;Lcom/yandex/div/json/expressions/Expression;Ljava/util/List;Ljava/lang/String;Ljava/util/List;Lcom/yandex/div2/DivFocus;Ljava/util/List;Lcom/yandex/div2/DivSize;Ljava/lang/String;Lcom/yandex/div2/DivLayoutProvider;Lcom/yandex/div2/DivEdgeInsets;Lcom/yandex/div2/DivEdgeInsets;Lcom/yandex/div/json/expressions/Expression;Lcom/yandex/div/json/expressions/Expression;Ljava/util/List;Ljava/lang/String;Ljava/util/List;Ljava/util/List;Lcom/yandex/div2/DivTransform;Lcom/yandex/div/json/expressions/Expression;Lcom/yandex/div2/DivChangeTransition;Lcom/yandex/div2/DivAppearanceTransition;Lcom/yandex/div2/DivAppearanceTransition;Ljava/util/List;Ljava/util/List;Ljava/util/List;Lcom/yandex/div/json/expressions/Expression;Lcom/yandex/div2/DivVisibilityAction;Ljava/util/List;Lcom/yandex/div2/DivSize;)V", "_hash", "", "Ljava/lang/Integer;", "_propertiesHash", "getAccessibility", "()Lcom/yandex/div2/DivAccessibility;", "getAlignmentHorizontal", "()Lcom/yandex/div/json/expressions/Expression;", "getAlignmentVertical", "getAlpha", "getAnimators", "()Ljava/util/List;", "getBackground", "getBorder", "()Lcom/yandex/div2/DivBorder;", "getColumnSpan", "getDisappearActions", "getExtensions", "getFocus", "()Lcom/yandex/div2/DivFocus;", "getFunctions", "getHeight", "()Lcom/yandex/div2/DivSize;", "getId", "()Ljava/lang/String;", "getLayoutProvider", "()Lcom/yandex/div2/DivLayoutProvider;", "getMargins", "()Lcom/yandex/div2/DivEdgeInsets;", "getPaddings", "getReuseId", "getRowSpan", "getSelectedActions", "getTooltips", "getTransform", "()Lcom/yandex/div2/DivTransform;", "getTransitionChange", "()Lcom/yandex/div2/DivChangeTransition;", "getTransitionIn", "()Lcom/yandex/div2/DivAppearanceTransition;", "getTransitionOut", "getTransitionTriggers", "getVariableTriggers", "getVariables", "getVisibility", "getVisibilityAction", "()Lcom/yandex/div2/DivVisibilityAction;", "getVisibilityActions", "getWidth", "copy", "equals", "other", "resolver", "Lcom/yandex/div/json/expressions/ExpressionResolver;", "otherResolver", "hash", "propertiesHash", "writeToJSON", "Lorg/json/JSONObject;", "Companion", "State", "div-data_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class DivState implements JSONSerializable, Hashable, DivBase {
    public static final String TYPE = "state";
    private Integer _hash;
    private Integer _propertiesHash;
    private final DivAccessibility accessibility;
    private final Expression<DivAlignmentHorizontal> alignmentHorizontal;
    private final Expression<DivAlignmentVertical> alignmentVertical;
    private final Expression<Double> alpha;
    private final List<DivAnimator> animators;
    private final List<DivBackground> background;
    private final DivBorder border;
    public final Expression<Boolean> clipToBounds;
    private final Expression<Long> columnSpan;
    public final Expression<String> defaultStateId;
    private final List<DivDisappearAction> disappearActions;
    public final String divId;
    private final List<DivExtension> extensions;
    private final DivFocus focus;
    private final List<DivFunction> functions;
    private final DivSize height;
    private final String id;
    private final DivLayoutProvider layoutProvider;
    private final DivEdgeInsets margins;
    private final DivEdgeInsets paddings;
    private final Expression<String> reuseId;
    private final Expression<Long> rowSpan;
    private final List<DivAction> selectedActions;
    public final String stateIdVariable;
    public final List<State> states;
    private final List<DivTooltip> tooltips;
    private final DivTransform transform;
    public final Expression<DivTransitionSelector> transitionAnimationSelector;
    private final DivChangeTransition transitionChange;
    private final DivAppearanceTransition transitionIn;
    private final DivAppearanceTransition transitionOut;
    private final List<DivTransitionTrigger> transitionTriggers;
    private final List<DivTrigger> variableTriggers;
    private final List<DivVariable> variables;
    private final Expression<DivVisibility> visibility;
    private final DivVisibilityAction visibilityAction;
    private final List<DivVisibilityAction> visibilityActions;
    private final DivSize width;

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final Expression<Double> ALPHA_DEFAULT_VALUE = Expression.INSTANCE.constant(Double.valueOf(1.0d));
    private static final Expression<Boolean> CLIP_TO_BOUNDS_DEFAULT_VALUE = Expression.INSTANCE.constant(true);
    private static final DivSize.WrapContent HEIGHT_DEFAULT_VALUE = new DivSize.WrapContent(new DivWrapContentSize(null, null, null, 7, null));
    private static final Expression<DivTransitionSelector> TRANSITION_ANIMATION_SELECTOR_DEFAULT_VALUE = Expression.INSTANCE.constant(DivTransitionSelector.STATE_CHANGE);
    private static final Expression<DivVisibility> VISIBILITY_DEFAULT_VALUE = Expression.INSTANCE.constant(DivVisibility.VISIBLE);
    private static final DivSize.MatchParent WIDTH_DEFAULT_VALUE = new DivSize.MatchParent(new DivMatchParentSize(0 == true ? 1 : 0, 1, 0 == true ? 1 : 0));
    private static final Function2<ParsingEnvironment, JSONObject, DivState> CREATOR = new Function2<ParsingEnvironment, JSONObject, DivState>() { // from class: com.yandex.div2.DivState$Companion$CREATOR$1
        @Override // kotlin.jvm.functions.Function2
        public final DivState invoke(ParsingEnvironment env, JSONObject it) {
            Intrinsics.checkNotNullParameter(env, "env");
            Intrinsics.checkNotNullParameter(it, "it");
            return DivState.INSTANCE.fromJson(env, it);
        }
    };

    @JvmStatic
    public static final DivState fromJson(ParsingEnvironment parsingEnvironment, JSONObject jSONObject) {
        return INSTANCE.fromJson(parsingEnvironment, jSONObject);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public DivState(DivAccessibility divAccessibility, Expression<DivAlignmentHorizontal> expression, Expression<DivAlignmentVertical> expression2, Expression<Double> alpha, List<? extends DivAnimator> list, List<? extends DivBackground> list2, DivBorder divBorder, Expression<Boolean> clipToBounds, Expression<Long> expression3, Expression<String> expression4, List<DivDisappearAction> list3, String str, List<DivExtension> list4, DivFocus divFocus, List<DivFunction> list5, DivSize height, String str2, DivLayoutProvider divLayoutProvider, DivEdgeInsets divEdgeInsets, DivEdgeInsets divEdgeInsets2, Expression<String> expression5, Expression<Long> expression6, List<DivAction> list6, String str3, List<State> states, List<DivTooltip> list7, DivTransform divTransform, Expression<DivTransitionSelector> transitionAnimationSelector, DivChangeTransition divChangeTransition, DivAppearanceTransition divAppearanceTransition, DivAppearanceTransition divAppearanceTransition2, List<? extends DivTransitionTrigger> list8, List<DivTrigger> list9, List<? extends DivVariable> list10, Expression<DivVisibility> visibility, DivVisibilityAction divVisibilityAction, List<DivVisibilityAction> list11, DivSize width) {
        Intrinsics.checkNotNullParameter(alpha, "alpha");
        Intrinsics.checkNotNullParameter(clipToBounds, "clipToBounds");
        Intrinsics.checkNotNullParameter(height, "height");
        Intrinsics.checkNotNullParameter(states, "states");
        Intrinsics.checkNotNullParameter(transitionAnimationSelector, "transitionAnimationSelector");
        Intrinsics.checkNotNullParameter(visibility, "visibility");
        Intrinsics.checkNotNullParameter(width, "width");
        this.accessibility = divAccessibility;
        this.alignmentHorizontal = expression;
        this.alignmentVertical = expression2;
        this.alpha = alpha;
        this.animators = list;
        this.background = list2;
        this.border = divBorder;
        this.clipToBounds = clipToBounds;
        this.columnSpan = expression3;
        this.defaultStateId = expression4;
        this.disappearActions = list3;
        this.divId = str;
        this.extensions = list4;
        this.focus = divFocus;
        this.functions = list5;
        this.height = height;
        this.id = str2;
        this.layoutProvider = divLayoutProvider;
        this.margins = divEdgeInsets;
        this.paddings = divEdgeInsets2;
        this.reuseId = expression5;
        this.rowSpan = expression6;
        this.selectedActions = list6;
        this.stateIdVariable = str3;
        this.states = states;
        this.tooltips = list7;
        this.transform = divTransform;
        this.transitionAnimationSelector = transitionAnimationSelector;
        this.transitionChange = divChangeTransition;
        this.transitionIn = divAppearanceTransition;
        this.transitionOut = divAppearanceTransition2;
        this.transitionTriggers = list8;
        this.variableTriggers = list9;
        this.variables = list10;
        this.visibility = visibility;
        this.visibilityAction = divVisibilityAction;
        this.visibilityActions = list11;
        this.width = width;
    }

    @Override // com.yandex.div2.DivBase
    public DivAccessibility getAccessibility() {
        return this.accessibility;
    }

    @Override // com.yandex.div2.DivBase
    public Expression<DivAlignmentHorizontal> getAlignmentHorizontal() {
        return this.alignmentHorizontal;
    }

    @Override // com.yandex.div2.DivBase
    public Expression<DivAlignmentVertical> getAlignmentVertical() {
        return this.alignmentVertical;
    }

    public /* synthetic */ DivState(DivAccessibility divAccessibility, Expression expression, Expression expression2, Expression expression3, List list, List list2, DivBorder divBorder, Expression expression4, Expression expression5, Expression expression6, List list3, String str, List list4, DivFocus divFocus, List list5, DivSize divSize, String str2, DivLayoutProvider divLayoutProvider, DivEdgeInsets divEdgeInsets, DivEdgeInsets divEdgeInsets2, Expression expression7, Expression expression8, List list6, String str3, List list7, List list8, DivTransform divTransform, Expression expression9, DivChangeTransition divChangeTransition, DivAppearanceTransition divAppearanceTransition, DivAppearanceTransition divAppearanceTransition2, List list9, List list10, List list11, Expression expression10, DivVisibilityAction divVisibilityAction, List list12, DivSize divSize2, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : divAccessibility, (i & 2) != 0 ? null : expression, (i & 4) != 0 ? null : expression2, (i & 8) != 0 ? ALPHA_DEFAULT_VALUE : expression3, (i & 16) != 0 ? null : list, (i & 32) != 0 ? null : list2, (i & 64) != 0 ? null : divBorder, (i & 128) != 0 ? CLIP_TO_BOUNDS_DEFAULT_VALUE : expression4, (i & 256) != 0 ? null : expression5, (i & 512) != 0 ? null : expression6, (i & 1024) != 0 ? null : list3, (i & 2048) != 0 ? null : str, (i & 4096) != 0 ? null : list4, (i & 8192) != 0 ? null : divFocus, (i & 16384) != 0 ? null : list5, (32768 & i) != 0 ? HEIGHT_DEFAULT_VALUE : divSize, (65536 & i) != 0 ? null : str2, (131072 & i) != 0 ? null : divLayoutProvider, (262144 & i) != 0 ? null : divEdgeInsets, (524288 & i) != 0 ? null : divEdgeInsets2, (1048576 & i) != 0 ? null : expression7, (2097152 & i) != 0 ? null : expression8, (4194304 & i) != 0 ? null : list6, (8388608 & i) != 0 ? null : str3, list7, (33554432 & i) != 0 ? null : list8, (67108864 & i) != 0 ? null : divTransform, (134217728 & i) != 0 ? TRANSITION_ANIMATION_SELECTOR_DEFAULT_VALUE : expression9, (268435456 & i) != 0 ? null : divChangeTransition, (536870912 & i) != 0 ? null : divAppearanceTransition, (1073741824 & i) != 0 ? null : divAppearanceTransition2, (i & Integer.MIN_VALUE) != 0 ? null : list9, (i2 & 1) != 0 ? null : list10, (i2 & 2) != 0 ? null : list11, (i2 & 4) != 0 ? VISIBILITY_DEFAULT_VALUE : expression10, (i2 & 8) != 0 ? null : divVisibilityAction, (i2 & 16) != 0 ? null : list12, (i2 & 32) != 0 ? WIDTH_DEFAULT_VALUE : divSize2);
    }

    @Override // com.yandex.div2.DivBase
    public Expression<Double> getAlpha() {
        return this.alpha;
    }

    @Override // com.yandex.div2.DivBase
    public List<DivAnimator> getAnimators() {
        return this.animators;
    }

    @Override // com.yandex.div2.DivBase
    public List<DivBackground> getBackground() {
        return this.background;
    }

    @Override // com.yandex.div2.DivBase
    public DivBorder getBorder() {
        return this.border;
    }

    @Override // com.yandex.div2.DivBase
    public Expression<Long> getColumnSpan() {
        return this.columnSpan;
    }

    @Override // com.yandex.div2.DivBase
    public List<DivDisappearAction> getDisappearActions() {
        return this.disappearActions;
    }

    @Override // com.yandex.div2.DivBase
    public List<DivExtension> getExtensions() {
        return this.extensions;
    }

    @Override // com.yandex.div2.DivBase
    public DivFocus getFocus() {
        return this.focus;
    }

    @Override // com.yandex.div2.DivBase
    public List<DivFunction> getFunctions() {
        return this.functions;
    }

    @Override // com.yandex.div2.DivBase
    public DivSize getHeight() {
        return this.height;
    }

    @Override // com.yandex.div2.DivBase
    public String getId() {
        return this.id;
    }

    @Override // com.yandex.div2.DivBase
    public DivLayoutProvider getLayoutProvider() {
        return this.layoutProvider;
    }

    @Override // com.yandex.div2.DivBase
    public DivEdgeInsets getMargins() {
        return this.margins;
    }

    @Override // com.yandex.div2.DivBase
    public DivEdgeInsets getPaddings() {
        return this.paddings;
    }

    @Override // com.yandex.div2.DivBase
    public Expression<String> getReuseId() {
        return this.reuseId;
    }

    @Override // com.yandex.div2.DivBase
    public Expression<Long> getRowSpan() {
        return this.rowSpan;
    }

    @Override // com.yandex.div2.DivBase
    public List<DivAction> getSelectedActions() {
        return this.selectedActions;
    }

    @Override // com.yandex.div2.DivBase
    public List<DivTooltip> getTooltips() {
        return this.tooltips;
    }

    @Override // com.yandex.div2.DivBase
    public DivTransform getTransform() {
        return this.transform;
    }

    @Override // com.yandex.div2.DivBase
    public DivChangeTransition getTransitionChange() {
        return this.transitionChange;
    }

    @Override // com.yandex.div2.DivBase
    public DivAppearanceTransition getTransitionIn() {
        return this.transitionIn;
    }

    @Override // com.yandex.div2.DivBase
    public DivAppearanceTransition getTransitionOut() {
        return this.transitionOut;
    }

    @Override // com.yandex.div2.DivBase
    public List<DivTransitionTrigger> getTransitionTriggers() {
        return this.transitionTriggers;
    }

    @Override // com.yandex.div2.DivBase
    public List<DivTrigger> getVariableTriggers() {
        return this.variableTriggers;
    }

    @Override // com.yandex.div2.DivBase
    public List<DivVariable> getVariables() {
        return this.variables;
    }

    @Override // com.yandex.div2.DivBase
    public Expression<DivVisibility> getVisibility() {
        return this.visibility;
    }

    @Override // com.yandex.div2.DivBase
    public DivVisibilityAction getVisibilityAction() {
        return this.visibilityAction;
    }

    @Override // com.yandex.div2.DivBase
    public List<DivVisibilityAction> getVisibilityActions() {
        return this.visibilityActions;
    }

    @Override // com.yandex.div2.DivBase
    public DivSize getWidth() {
        return this.width;
    }

    @Override // com.yandex.div.data.Hashable
    public int propertiesHash() {
        int iHash;
        int iHash2;
        int iHash3;
        int iHash4;
        int iHash5;
        int iHash6;
        int iHash7;
        int iHash8;
        int iHash9;
        Integer num = this._propertiesHash;
        if (num != null) {
            return num.intValue();
        }
        int iHashCode = Reflection.getOrCreateKotlinClass(getClass()).hashCode();
        DivAccessibility accessibility = getAccessibility();
        int iHash10 = 0;
        int iHash11 = iHashCode + (accessibility != null ? accessibility.hash() : 0);
        Expression<DivAlignmentHorizontal> alignmentHorizontal = getAlignmentHorizontal();
        int iHashCode2 = iHash11 + (alignmentHorizontal != null ? alignmentHorizontal.hashCode() : 0);
        Expression<DivAlignmentVertical> alignmentVertical = getAlignmentVertical();
        int iHashCode3 = iHashCode2 + (alignmentVertical != null ? alignmentVertical.hashCode() : 0) + getAlpha().hashCode();
        List<DivAnimator> animators = getAnimators();
        if (animators != null) {
            Iterator<T> it = animators.iterator();
            iHash = 0;
            while (it.hasNext()) {
                iHash += ((DivAnimator) it.next()).hash();
            }
        } else {
            iHash = 0;
        }
        int i = iHashCode3 + iHash;
        List<DivBackground> background = getBackground();
        if (background != null) {
            Iterator<T> it2 = background.iterator();
            iHash2 = 0;
            while (it2.hasNext()) {
                iHash2 += ((DivBackground) it2.next()).hash();
            }
        } else {
            iHash2 = 0;
        }
        int i2 = i + iHash2;
        DivBorder border = getBorder();
        int iHash12 = i2 + (border != null ? border.hash() : 0) + this.clipToBounds.hashCode();
        Expression<Long> columnSpan = getColumnSpan();
        int iHashCode4 = iHash12 + (columnSpan != null ? columnSpan.hashCode() : 0);
        Expression<String> expression = this.defaultStateId;
        int iHashCode5 = iHashCode4 + (expression != null ? expression.hashCode() : 0);
        List<DivDisappearAction> disappearActions = getDisappearActions();
        if (disappearActions != null) {
            Iterator<T> it3 = disappearActions.iterator();
            iHash3 = 0;
            while (it3.hasNext()) {
                iHash3 += ((DivDisappearAction) it3.next()).hash();
            }
        } else {
            iHash3 = 0;
        }
        int i3 = iHashCode5 + iHash3;
        String str = this.divId;
        int iHashCode6 = i3 + (str != null ? str.hashCode() : 0);
        List<DivExtension> extensions = getExtensions();
        if (extensions != null) {
            Iterator<T> it4 = extensions.iterator();
            iHash4 = 0;
            while (it4.hasNext()) {
                iHash4 += ((DivExtension) it4.next()).hash();
            }
        } else {
            iHash4 = 0;
        }
        int i4 = iHashCode6 + iHash4;
        DivFocus focus = getFocus();
        int iHash13 = i4 + (focus != null ? focus.hash() : 0);
        List<DivFunction> functions = getFunctions();
        if (functions != null) {
            Iterator<T> it5 = functions.iterator();
            iHash5 = 0;
            while (it5.hasNext()) {
                iHash5 += ((DivFunction) it5.next()).hash();
            }
        } else {
            iHash5 = 0;
        }
        int iHash14 = iHash13 + iHash5 + getHeight().hash();
        String id = getId();
        int iHashCode7 = iHash14 + (id != null ? id.hashCode() : 0);
        DivLayoutProvider layoutProvider = getLayoutProvider();
        int iHash15 = iHashCode7 + (layoutProvider != null ? layoutProvider.hash() : 0);
        DivEdgeInsets margins = getMargins();
        int iHash16 = iHash15 + (margins != null ? margins.hash() : 0);
        DivEdgeInsets paddings = getPaddings();
        int iHash17 = iHash16 + (paddings != null ? paddings.hash() : 0);
        Expression<String> reuseId = getReuseId();
        int iHashCode8 = iHash17 + (reuseId != null ? reuseId.hashCode() : 0);
        Expression<Long> rowSpan = getRowSpan();
        int iHashCode9 = iHashCode8 + (rowSpan != null ? rowSpan.hashCode() : 0);
        List<DivAction> selectedActions = getSelectedActions();
        if (selectedActions != null) {
            Iterator<T> it6 = selectedActions.iterator();
            iHash6 = 0;
            while (it6.hasNext()) {
                iHash6 += ((DivAction) it6.next()).hash();
            }
        } else {
            iHash6 = 0;
        }
        int i5 = iHashCode9 + iHash6;
        String str2 = this.stateIdVariable;
        int iHashCode10 = i5 + (str2 != null ? str2.hashCode() : 0);
        List<DivTooltip> tooltips = getTooltips();
        if (tooltips != null) {
            Iterator<T> it7 = tooltips.iterator();
            iHash7 = 0;
            while (it7.hasNext()) {
                iHash7 += ((DivTooltip) it7.next()).hash();
            }
        } else {
            iHash7 = 0;
        }
        int i6 = iHashCode10 + iHash7;
        DivTransform transform = getTransform();
        int iHash18 = i6 + (transform != null ? transform.hash() : 0) + this.transitionAnimationSelector.hashCode();
        DivChangeTransition transitionChange = getTransitionChange();
        int iHash19 = iHash18 + (transitionChange != null ? transitionChange.hash() : 0);
        DivAppearanceTransition transitionIn = getTransitionIn();
        int iHash20 = iHash19 + (transitionIn != null ? transitionIn.hash() : 0);
        DivAppearanceTransition transitionOut = getTransitionOut();
        int iHash21 = iHash20 + (transitionOut != null ? transitionOut.hash() : 0);
        List<DivTransitionTrigger> transitionTriggers = getTransitionTriggers();
        int iHashCode11 = iHash21 + (transitionTriggers != null ? transitionTriggers.hashCode() : 0);
        List<DivTrigger> variableTriggers = getVariableTriggers();
        if (variableTriggers != null) {
            Iterator<T> it8 = variableTriggers.iterator();
            iHash8 = 0;
            while (it8.hasNext()) {
                iHash8 += ((DivTrigger) it8.next()).hash();
            }
        } else {
            iHash8 = 0;
        }
        int i7 = iHashCode11 + iHash8;
        List<DivVariable> variables = getVariables();
        if (variables != null) {
            Iterator<T> it9 = variables.iterator();
            iHash9 = 0;
            while (it9.hasNext()) {
                iHash9 += ((DivVariable) it9.next()).hash();
            }
        } else {
            iHash9 = 0;
        }
        int iHashCode12 = i7 + iHash9 + getVisibility().hashCode();
        DivVisibilityAction visibilityAction = getVisibilityAction();
        int iHash22 = iHashCode12 + (visibilityAction != null ? visibilityAction.hash() : 0);
        List<DivVisibilityAction> visibilityActions = getVisibilityActions();
        if (visibilityActions != null) {
            Iterator<T> it10 = visibilityActions.iterator();
            while (it10.hasNext()) {
                iHash10 += ((DivVisibilityAction) it10.next()).hash();
            }
        }
        int iHash23 = iHash22 + iHash10 + getWidth().hash();
        this._propertiesHash = Integer.valueOf(iHash23);
        return iHash23;
    }

    @Override // com.yandex.div.data.Hashable
    public int hash() {
        Integer num = this._hash;
        if (num != null) {
            return num.intValue();
        }
        int iPropertiesHash = propertiesHash();
        Iterator<T> it = this.states.iterator();
        int iHash = 0;
        while (it.hasNext()) {
            iHash += ((State) it.next()).hash();
        }
        int i = iPropertiesHash + iHash;
        this._hash = Integer.valueOf(i);
        return i;
    }

    public final boolean equals(DivState other, ExpressionResolver resolver, ExpressionResolver otherResolver) {
        boolean zEquals;
        boolean z;
        boolean z2;
        boolean zEquals2;
        boolean z3;
        boolean z4;
        boolean zEquals3;
        boolean z5;
        boolean zEquals4;
        boolean zEquals5;
        boolean zEquals6;
        boolean z6;
        boolean z7;
        boolean z8;
        boolean zEquals7;
        boolean zEquals8;
        boolean zEquals9;
        boolean zEquals10;
        boolean z9;
        boolean z10;
        boolean z11;
        boolean zEquals11;
        boolean z12;
        Intrinsics.checkNotNullParameter(resolver, "resolver");
        Intrinsics.checkNotNullParameter(otherResolver, "otherResolver");
        if (other == null) {
            return false;
        }
        DivAccessibility accessibility = getAccessibility();
        if (accessibility != null) {
            zEquals = accessibility.equals(other.getAccessibility(), resolver, otherResolver);
        } else {
            zEquals = other.getAccessibility() == null;
        }
        if (!zEquals) {
            return false;
        }
        Expression<DivAlignmentHorizontal> alignmentHorizontal = getAlignmentHorizontal();
        DivAlignmentHorizontal divAlignmentHorizontalEvaluate = alignmentHorizontal != null ? alignmentHorizontal.evaluate(resolver) : null;
        Expression<DivAlignmentHorizontal> alignmentHorizontal2 = other.getAlignmentHorizontal();
        if (divAlignmentHorizontalEvaluate != (alignmentHorizontal2 != null ? alignmentHorizontal2.evaluate(otherResolver) : null)) {
            return false;
        }
        Expression<DivAlignmentVertical> alignmentVertical = getAlignmentVertical();
        DivAlignmentVertical divAlignmentVerticalEvaluate = alignmentVertical != null ? alignmentVertical.evaluate(resolver) : null;
        Expression<DivAlignmentVertical> alignmentVertical2 = other.getAlignmentVertical();
        if (divAlignmentVerticalEvaluate != (alignmentVertical2 != null ? alignmentVertical2.evaluate(otherResolver) : null)) {
            return false;
        }
        if (!(getAlpha().evaluate(resolver).doubleValue() == other.getAlpha().evaluate(otherResolver).doubleValue())) {
            return false;
        }
        List<DivAnimator> animators = getAnimators();
        if (animators != null) {
            List<DivAnimator> animators2 = other.getAnimators();
            if (animators2 == null) {
                return false;
            }
            if (animators.size() == animators2.size()) {
                Iterator<T> it = animators.iterator();
                int i = 0;
                while (true) {
                    if (it.hasNext()) {
                        Object next = it.next();
                        int i2 = i + 1;
                        if (i < 0) {
                            CollectionsKt.throwIndexOverflow();
                        }
                        if (((DivAnimator) next).equals(animators2.get(i), resolver, otherResolver)) {
                            i = i2;
                        }
                    }
                }
            }
        } else {
            z = other.getAnimators() == null;
        }
        if (!z) {
            return false;
        }
        List<DivBackground> background = getBackground();
        if (background != null) {
            List<DivBackground> background2 = other.getBackground();
            if (background2 == null) {
                return false;
            }
            if (background.size() == background2.size()) {
                Iterator<T> it2 = background.iterator();
                int i3 = 0;
                while (true) {
                    if (it2.hasNext()) {
                        Object next2 = it2.next();
                        int i4 = i3 + 1;
                        if (i3 < 0) {
                            CollectionsKt.throwIndexOverflow();
                        }
                        if (((DivBackground) next2).equals(background2.get(i3), resolver, otherResolver)) {
                            i3 = i4;
                        }
                    }
                }
            }
        } else {
            z2 = other.getBackground() == null;
        }
        if (!z2) {
            return false;
        }
        DivBorder border = getBorder();
        if (border != null) {
            zEquals2 = border.equals(other.getBorder(), resolver, otherResolver);
        } else {
            zEquals2 = other.getBorder() == null;
        }
        if (!zEquals2 || this.clipToBounds.evaluate(resolver).booleanValue() != other.clipToBounds.evaluate(otherResolver).booleanValue()) {
            return false;
        }
        Expression<Long> columnSpan = getColumnSpan();
        Long lEvaluate = columnSpan != null ? columnSpan.evaluate(resolver) : null;
        Expression<Long> columnSpan2 = other.getColumnSpan();
        if (!Intrinsics.areEqual(lEvaluate, columnSpan2 != null ? columnSpan2.evaluate(otherResolver) : null)) {
            return false;
        }
        Expression<String> expression = this.defaultStateId;
        String strEvaluate = expression != null ? expression.evaluate(resolver) : null;
        Expression<String> expression2 = other.defaultStateId;
        if (!Intrinsics.areEqual(strEvaluate, expression2 != null ? expression2.evaluate(otherResolver) : null)) {
            return false;
        }
        List<DivDisappearAction> disappearActions = getDisappearActions();
        if (disappearActions != null) {
            List<DivDisappearAction> disappearActions2 = other.getDisappearActions();
            if (disappearActions2 == null) {
                return false;
            }
            if (disappearActions.size() == disappearActions2.size()) {
                Iterator<T> it3 = disappearActions.iterator();
                int i5 = 0;
                while (true) {
                    if (it3.hasNext()) {
                        Object next3 = it3.next();
                        int i6 = i5 + 1;
                        if (i5 < 0) {
                            CollectionsKt.throwIndexOverflow();
                        }
                        if (((DivDisappearAction) next3).equals(disappearActions2.get(i5), resolver, otherResolver)) {
                            i5 = i6;
                        }
                    }
                }
            }
        } else {
            z3 = other.getDisappearActions() == null;
        }
        if (!z3 || !Intrinsics.areEqual(this.divId, other.divId)) {
            return false;
        }
        List<DivExtension> extensions = getExtensions();
        if (extensions != null) {
            List<DivExtension> extensions2 = other.getExtensions();
            if (extensions2 == null) {
                return false;
            }
            if (extensions.size() == extensions2.size()) {
                Iterator<T> it4 = extensions.iterator();
                int i7 = 0;
                while (true) {
                    if (it4.hasNext()) {
                        Object next4 = it4.next();
                        int i8 = i7 + 1;
                        if (i7 < 0) {
                            CollectionsKt.throwIndexOverflow();
                        }
                        if (((DivExtension) next4).equals(extensions2.get(i7), resolver, otherResolver)) {
                            i7 = i8;
                        }
                    }
                }
            }
        } else {
            z4 = other.getExtensions() == null;
        }
        if (!z4) {
            return false;
        }
        DivFocus focus = getFocus();
        if (focus != null) {
            zEquals3 = focus.equals(other.getFocus(), resolver, otherResolver);
        } else {
            zEquals3 = other.getFocus() == null;
        }
        if (!zEquals3) {
            return false;
        }
        List<DivFunction> functions = getFunctions();
        if (functions != null) {
            List<DivFunction> functions2 = other.getFunctions();
            if (functions2 == null) {
                return false;
            }
            if (functions.size() == functions2.size()) {
                Iterator<T> it5 = functions.iterator();
                int i9 = 0;
                while (true) {
                    if (it5.hasNext()) {
                        Object next5 = it5.next();
                        int i10 = i9 + 1;
                        if (i9 < 0) {
                            CollectionsKt.throwIndexOverflow();
                        }
                        if (((DivFunction) next5).equals(functions2.get(i9), resolver, otherResolver)) {
                            i9 = i10;
                        }
                    }
                }
            }
        } else {
            z5 = other.getFunctions() == null;
        }
        if (!z5 || !getHeight().equals(other.getHeight(), resolver, otherResolver) || !Intrinsics.areEqual(getId(), other.getId())) {
            return false;
        }
        DivLayoutProvider layoutProvider = getLayoutProvider();
        if (layoutProvider != null) {
            zEquals4 = layoutProvider.equals(other.getLayoutProvider(), resolver, otherResolver);
        } else {
            zEquals4 = other.getLayoutProvider() == null;
        }
        if (!zEquals4) {
            return false;
        }
        DivEdgeInsets margins = getMargins();
        if (margins != null) {
            zEquals5 = margins.equals(other.getMargins(), resolver, otherResolver);
        } else {
            zEquals5 = other.getMargins() == null;
        }
        if (!zEquals5) {
            return false;
        }
        DivEdgeInsets paddings = getPaddings();
        if (paddings != null) {
            zEquals6 = paddings.equals(other.getPaddings(), resolver, otherResolver);
        } else {
            zEquals6 = other.getPaddings() == null;
        }
        if (!zEquals6) {
            return false;
        }
        Expression<String> reuseId = getReuseId();
        String strEvaluate2 = reuseId != null ? reuseId.evaluate(resolver) : null;
        Expression<String> reuseId2 = other.getReuseId();
        if (!Intrinsics.areEqual(strEvaluate2, reuseId2 != null ? reuseId2.evaluate(otherResolver) : null)) {
            return false;
        }
        Expression<Long> rowSpan = getRowSpan();
        Long lEvaluate2 = rowSpan != null ? rowSpan.evaluate(resolver) : null;
        Expression<Long> rowSpan2 = other.getRowSpan();
        if (!Intrinsics.areEqual(lEvaluate2, rowSpan2 != null ? rowSpan2.evaluate(otherResolver) : null)) {
            return false;
        }
        List<DivAction> selectedActions = getSelectedActions();
        if (selectedActions != null) {
            List<DivAction> selectedActions2 = other.getSelectedActions();
            if (selectedActions2 == null) {
                return false;
            }
            if (selectedActions.size() == selectedActions2.size()) {
                Iterator<T> it6 = selectedActions.iterator();
                int i11 = 0;
                while (true) {
                    if (it6.hasNext()) {
                        Object next6 = it6.next();
                        int i12 = i11 + 1;
                        if (i11 < 0) {
                            CollectionsKt.throwIndexOverflow();
                        }
                        if (((DivAction) next6).equals(selectedActions2.get(i11), resolver, otherResolver)) {
                            i11 = i12;
                        }
                    }
                }
            }
        } else {
            z6 = other.getSelectedActions() == null;
        }
        if (!z6 || !Intrinsics.areEqual(this.stateIdVariable, other.stateIdVariable)) {
            return false;
        }
        List<State> list = this.states;
        List<State> list2 = other.states;
        if (list.size() == list2.size()) {
            Iterator<T> it7 = list.iterator();
            int i13 = 0;
            while (true) {
                if (!it7.hasNext()) {
                    z7 = true;
                    break;
                }
                Object next7 = it7.next();
                int i14 = i13 + 1;
                if (i13 < 0) {
                    CollectionsKt.throwIndexOverflow();
                }
                if (!((State) next7).equals(list2.get(i13), resolver, otherResolver)) {
                    z7 = false;
                    break;
                }
                i13 = i14;
            }
        } else {
            z7 = false;
            break;
        }
        if (!z7) {
            return false;
        }
        List<DivTooltip> tooltips = getTooltips();
        if (tooltips != null) {
            List<DivTooltip> tooltips2 = other.getTooltips();
            if (tooltips2 == null) {
                return false;
            }
            if (tooltips.size() == tooltips2.size()) {
                Iterator<T> it8 = tooltips.iterator();
                int i15 = 0;
                while (true) {
                    if (it8.hasNext()) {
                        Object next8 = it8.next();
                        int i16 = i15 + 1;
                        if (i15 < 0) {
                            CollectionsKt.throwIndexOverflow();
                        }
                        if (((DivTooltip) next8).equals(tooltips2.get(i15), resolver, otherResolver)) {
                            i15 = i16;
                        }
                    }
                }
            }
        } else {
            z8 = other.getTooltips() == null;
        }
        if (!z8) {
            return false;
        }
        DivTransform transform = getTransform();
        if (transform != null) {
            zEquals7 = transform.equals(other.getTransform(), resolver, otherResolver);
        } else {
            zEquals7 = other.getTransform() == null;
        }
        if (!zEquals7 || this.transitionAnimationSelector.evaluate(resolver) != other.transitionAnimationSelector.evaluate(otherResolver)) {
            return false;
        }
        DivChangeTransition transitionChange = getTransitionChange();
        if (transitionChange != null) {
            zEquals8 = transitionChange.equals(other.getTransitionChange(), resolver, otherResolver);
        } else {
            zEquals8 = other.getTransitionChange() == null;
        }
        if (!zEquals8) {
            return false;
        }
        DivAppearanceTransition transitionIn = getTransitionIn();
        if (transitionIn != null) {
            zEquals9 = transitionIn.equals(other.getTransitionIn(), resolver, otherResolver);
        } else {
            zEquals9 = other.getTransitionIn() == null;
        }
        if (!zEquals9) {
            return false;
        }
        DivAppearanceTransition transitionOut = getTransitionOut();
        if (transitionOut != null) {
            zEquals10 = transitionOut.equals(other.getTransitionOut(), resolver, otherResolver);
        } else {
            zEquals10 = other.getTransitionOut() == null;
        }
        if (!zEquals10) {
            return false;
        }
        List<DivTransitionTrigger> transitionTriggers = getTransitionTriggers();
        if (transitionTriggers != null) {
            List<DivTransitionTrigger> transitionTriggers2 = other.getTransitionTriggers();
            if (transitionTriggers2 == null) {
                return false;
            }
            if (transitionTriggers.size() == transitionTriggers2.size()) {
                Iterator<T> it9 = transitionTriggers.iterator();
                int i17 = 0;
                while (true) {
                    if (it9.hasNext()) {
                        Object next9 = it9.next();
                        int i18 = i17 + 1;
                        if (i17 < 0) {
                            CollectionsKt.throwIndexOverflow();
                        }
                        if (((DivTransitionTrigger) next9) == transitionTriggers2.get(i17)) {
                            i17 = i18;
                        }
                    }
                }
            }
        } else {
            z9 = other.getTransitionTriggers() == null;
        }
        if (!z9) {
            return false;
        }
        List<DivTrigger> variableTriggers = getVariableTriggers();
        if (variableTriggers != null) {
            List<DivTrigger> variableTriggers2 = other.getVariableTriggers();
            if (variableTriggers2 == null) {
                return false;
            }
            if (variableTriggers.size() == variableTriggers2.size()) {
                Iterator<T> it10 = variableTriggers.iterator();
                int i19 = 0;
                while (true) {
                    if (it10.hasNext()) {
                        Object next10 = it10.next();
                        int i20 = i19 + 1;
                        if (i19 < 0) {
                            CollectionsKt.throwIndexOverflow();
                        }
                        if (((DivTrigger) next10).equals(variableTriggers2.get(i19), resolver, otherResolver)) {
                            i19 = i20;
                        }
                    }
                }
            }
        } else {
            z10 = other.getVariableTriggers() == null;
        }
        if (!z10) {
            return false;
        }
        List<DivVariable> variables = getVariables();
        if (variables != null) {
            List<DivVariable> variables2 = other.getVariables();
            if (variables2 == null) {
                return false;
            }
            if (variables.size() == variables2.size()) {
                Iterator<T> it11 = variables.iterator();
                int i21 = 0;
                while (true) {
                    if (it11.hasNext()) {
                        Object next11 = it11.next();
                        int i22 = i21 + 1;
                        if (i21 < 0) {
                            CollectionsKt.throwIndexOverflow();
                        }
                        if (((DivVariable) next11).equals(variables2.get(i21), resolver, otherResolver)) {
                            i21 = i22;
                        }
                    }
                }
            }
        } else {
            z11 = other.getVariables() == null;
        }
        if (!z11 || getVisibility().evaluate(resolver) != other.getVisibility().evaluate(otherResolver)) {
            return false;
        }
        DivVisibilityAction visibilityAction = getVisibilityAction();
        if (visibilityAction != null) {
            zEquals11 = visibilityAction.equals(other.getVisibilityAction(), resolver, otherResolver);
        } else {
            zEquals11 = other.getVisibilityAction() == null;
        }
        if (!zEquals11) {
            return false;
        }
        List<DivVisibilityAction> visibilityActions = getVisibilityActions();
        if (visibilityActions != null) {
            List<DivVisibilityAction> visibilityActions2 = other.getVisibilityActions();
            if (visibilityActions2 == null) {
                return false;
            }
            if (visibilityActions.size() == visibilityActions2.size()) {
                Iterator<T> it12 = visibilityActions.iterator();
                int i23 = 0;
                while (true) {
                    if (it12.hasNext()) {
                        Object next12 = it12.next();
                        int i24 = i23 + 1;
                        if (i23 < 0) {
                            CollectionsKt.throwIndexOverflow();
                        }
                        if (((DivVisibilityAction) next12).equals(visibilityActions2.get(i23), resolver, otherResolver)) {
                            i23 = i24;
                        }
                    }
                }
            }
        } else {
            z12 = other.getVisibilityActions() == null;
        }
        return z12 && getWidth().equals(other.getWidth(), resolver, otherResolver);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ DivState copy$default(DivState divState, DivAccessibility divAccessibility, Expression expression, Expression expression2, Expression expression3, List list, List list2, DivBorder divBorder, Expression expression4, Expression expression5, Expression expression6, List list3, String str, List list4, DivFocus divFocus, List list5, DivSize divSize, String str2, DivLayoutProvider divLayoutProvider, DivEdgeInsets divEdgeInsets, DivEdgeInsets divEdgeInsets2, Expression expression7, Expression expression8, List list6, String str3, List list7, List list8, DivTransform divTransform, Expression expression9, DivChangeTransition divChangeTransition, DivAppearanceTransition divAppearanceTransition, DivAppearanceTransition divAppearanceTransition2, List list9, List list10, List list11, Expression expression10, DivVisibilityAction divVisibilityAction, List list12, DivSize divSize2, int i, int i2, Object obj) {
        DivAccessibility accessibility = (i & 1) != 0 ? divState.getAccessibility() : divAccessibility;
        Expression alignmentHorizontal = (i & 2) != 0 ? divState.getAlignmentHorizontal() : expression;
        Expression alignmentVertical = (i & 4) != 0 ? divState.getAlignmentVertical() : expression2;
        Expression alpha = (i & 8) != 0 ? divState.getAlpha() : expression3;
        List animators = (i & 16) != 0 ? divState.getAnimators() : list;
        List background = (i & 32) != 0 ? divState.getBackground() : list2;
        DivBorder border = (i & 64) != 0 ? divState.getBorder() : divBorder;
        Expression expression11 = (i & 128) != 0 ? divState.clipToBounds : expression4;
        Expression columnSpan = (i & 256) != 0 ? divState.getColumnSpan() : expression5;
        Expression expression12 = (i & 512) != 0 ? divState.defaultStateId : expression6;
        List disappearActions = (i & 1024) != 0 ? divState.getDisappearActions() : list3;
        String str4 = (i & 2048) != 0 ? divState.divId : str;
        List extensions = (i & 4096) != 0 ? divState.getExtensions() : list4;
        DivFocus focus = (i & 8192) != 0 ? divState.getFocus() : divFocus;
        List functions = (i & 16384) != 0 ? divState.getFunctions() : list5;
        return divState.copy(accessibility, alignmentHorizontal, alignmentVertical, alpha, animators, background, border, expression11, columnSpan, expression12, disappearActions, str4, extensions, focus, functions, (i & 32768) != 0 ? divState.getHeight() : divSize, (i & 65536) != 0 ? divState.getId() : str2, (i & 131072) != 0 ? divState.getLayoutProvider() : divLayoutProvider, (i & 262144) != 0 ? divState.getMargins() : divEdgeInsets, (i & 524288) != 0 ? divState.getPaddings() : divEdgeInsets2, (i & 1048576) != 0 ? divState.getReuseId() : expression7, (i & 2097152) != 0 ? divState.getRowSpan() : expression8, (i & 4194304) != 0 ? divState.getSelectedActions() : list6, (i & 8388608) != 0 ? divState.stateIdVariable : str3, (i & 16777216) != 0 ? divState.states : list7, (i & 33554432) != 0 ? divState.getTooltips() : list8, (i & 67108864) != 0 ? divState.getTransform() : divTransform, (i & 134217728) != 0 ? divState.transitionAnimationSelector : expression9, (i & 268435456) != 0 ? divState.getTransitionChange() : divChangeTransition, (i & 536870912) != 0 ? divState.getTransitionIn() : divAppearanceTransition, (i & 1073741824) != 0 ? divState.getTransitionOut() : divAppearanceTransition2, (i & Integer.MIN_VALUE) != 0 ? divState.getTransitionTriggers() : list9, (i2 & 1) != 0 ? divState.getVariableTriggers() : list10, (i2 & 2) != 0 ? divState.getVariables() : list11, (i2 & 4) != 0 ? divState.getVisibility() : expression10, (i2 & 8) != 0 ? divState.getVisibilityAction() : divVisibilityAction, (i2 & 16) != 0 ? divState.getVisibilityActions() : list12, (i2 & 32) != 0 ? divState.getWidth() : divSize2);
    }

    public final DivState copy(DivAccessibility accessibility, Expression<DivAlignmentHorizontal> alignmentHorizontal, Expression<DivAlignmentVertical> alignmentVertical, Expression<Double> alpha, List<? extends DivAnimator> animators, List<? extends DivBackground> background, DivBorder border, Expression<Boolean> clipToBounds, Expression<Long> columnSpan, Expression<String> defaultStateId, List<DivDisappearAction> disappearActions, String divId, List<DivExtension> extensions, DivFocus focus, List<DivFunction> functions, DivSize height, String id, DivLayoutProvider layoutProvider, DivEdgeInsets margins, DivEdgeInsets paddings, Expression<String> reuseId, Expression<Long> rowSpan, List<DivAction> selectedActions, String stateIdVariable, List<State> states, List<DivTooltip> tooltips, DivTransform transform, Expression<DivTransitionSelector> transitionAnimationSelector, DivChangeTransition transitionChange, DivAppearanceTransition transitionIn, DivAppearanceTransition transitionOut, List<? extends DivTransitionTrigger> transitionTriggers, List<DivTrigger> variableTriggers, List<? extends DivVariable> variables, Expression<DivVisibility> visibility, DivVisibilityAction visibilityAction, List<DivVisibilityAction> visibilityActions, DivSize width) {
        Intrinsics.checkNotNullParameter(alpha, "alpha");
        Intrinsics.checkNotNullParameter(clipToBounds, "clipToBounds");
        Intrinsics.checkNotNullParameter(height, "height");
        Intrinsics.checkNotNullParameter(states, "states");
        Intrinsics.checkNotNullParameter(transitionAnimationSelector, "transitionAnimationSelector");
        Intrinsics.checkNotNullParameter(visibility, "visibility");
        Intrinsics.checkNotNullParameter(width, "width");
        return new DivState(accessibility, alignmentHorizontal, alignmentVertical, alpha, animators, background, border, clipToBounds, columnSpan, defaultStateId, disappearActions, divId, extensions, focus, functions, height, id, layoutProvider, margins, paddings, reuseId, rowSpan, selectedActions, stateIdVariable, states, tooltips, transform, transitionAnimationSelector, transitionChange, transitionIn, transitionOut, transitionTriggers, variableTriggers, variables, visibility, visibilityAction, visibilityActions, width);
    }

    @Override // com.yandex.div.json.JSONSerializable
    public JSONObject writeToJSON() {
        return BuiltInParserKt.getBuiltInParserComponent().getDivStateJsonEntityParser().getValue().serialize(BuiltInParserKt.getBuiltInParsingContext(), this);
    }

    /* JADX INFO: compiled from: DivState.kt */
    @Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0006\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u001e\u0010\u0019\u001a\u00020\f2\u0006\u0010\u001a\u001a\u00020\n2\u0006\u0010\u001b\u001a\u00020\u000bH\u0087\u0002¢\u0006\u0002\b\u001cR\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00070\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R#\u0010\b\u001a\u0014\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\f0\t¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u000e\u0010\u000f\u001a\u00020\u0010X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00120\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0014X\u0086T¢\u0006\u0002\n\u0000R\u0014\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00160\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0018X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001d"}, d2 = {"Lcom/yandex/div2/DivState$Companion;", "", "()V", "ALPHA_DEFAULT_VALUE", "Lcom/yandex/div/json/expressions/Expression;", "", "CLIP_TO_BOUNDS_DEFAULT_VALUE", "", "CREATOR", "Lkotlin/Function2;", "Lcom/yandex/div/json/ParsingEnvironment;", "Lorg/json/JSONObject;", "Lcom/yandex/div2/DivState;", "getCREATOR", "()Lkotlin/jvm/functions/Function2;", "HEIGHT_DEFAULT_VALUE", "Lcom/yandex/div2/DivSize$WrapContent;", "TRANSITION_ANIMATION_SELECTOR_DEFAULT_VALUE", "Lcom/yandex/div2/DivTransitionSelector;", "TYPE", "", "VISIBILITY_DEFAULT_VALUE", "Lcom/yandex/div2/DivVisibility;", "WIDTH_DEFAULT_VALUE", "Lcom/yandex/div2/DivSize$MatchParent;", "invoke", cc.o, "json", "fromJson", "div-data_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @JvmStatic
        public final DivState fromJson(ParsingEnvironment env, JSONObject json) {
            Intrinsics.checkNotNullParameter(env, "env");
            Intrinsics.checkNotNullParameter(json, "json");
            return BuiltInParserKt.getBuiltInParserComponent().getDivStateJsonEntityParser().getValue().deserialize((ParsingContext) env, json);
        }

        public final Function2<ParsingEnvironment, JSONObject, DivState> getCREATOR() {
            return DivState.CREATOR;
        }
    }

    /* JADX INFO: compiled from: DivState.kt */
    @Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \u001b2\u00020\u00012\u00020\u0002:\u0001\u001bBE\b\u0007\u0012\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0010\b\u0002\u0010\n\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u000b¢\u0006\u0002\u0010\rJF\u0010\u0011\u001a\u00020\u00002\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\u0010\b\u0002\u0010\n\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u000bJ \u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u00002\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0016J\b\u0010\u0018\u001a\u00020\u000fH\u0016J\b\u0010\u0019\u001a\u00020\u001aH\u0016R\u0012\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u0082\u000e¢\u0006\u0004\n\u0002\u0010\u0010R\u0012\u0010\u0003\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0012\u0010\u0005\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0012\u0010\u0006\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u00020\t8\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0018\u0010\n\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u000b8\u0006X\u0087\u0004¢\u0006\u0002\n\u0000¨\u0006\u001c"}, d2 = {"Lcom/yandex/div2/DivState$State;", "Lcom/yandex/div/json/JSONSerializable;", "Lcom/yandex/div/data/Hashable;", "animationIn", "Lcom/yandex/div2/DivAnimation;", "animationOut", "div", "Lcom/yandex/div2/Div;", "stateId", "", "swipeOutActions", "", "Lcom/yandex/div2/DivAction;", "(Lcom/yandex/div2/DivAnimation;Lcom/yandex/div2/DivAnimation;Lcom/yandex/div2/Div;Ljava/lang/String;Ljava/util/List;)V", "_hash", "", "Ljava/lang/Integer;", "copy", "equals", "", "other", "resolver", "Lcom/yandex/div/json/expressions/ExpressionResolver;", "otherResolver", "hash", "writeToJSON", "Lorg/json/JSONObject;", "Companion", "div-data_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class State implements JSONSerializable, Hashable {
        private Integer _hash;
        public final DivAnimation animationIn;
        public final DivAnimation animationOut;
        public final Div div;
        public final String stateId;
        public final List<DivAction> swipeOutActions;

        /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
        public static final Companion INSTANCE = new Companion(null);
        private static final Function2<ParsingEnvironment, JSONObject, State> CREATOR = new Function2<ParsingEnvironment, JSONObject, State>() { // from class: com.yandex.div2.DivState$State$Companion$CREATOR$1
            @Override // kotlin.jvm.functions.Function2
            public final DivState.State invoke(ParsingEnvironment env, JSONObject it) {
                Intrinsics.checkNotNullParameter(env, "env");
                Intrinsics.checkNotNullParameter(it, "it");
                return DivState.State.INSTANCE.fromJson(env, it);
            }
        };

        @JvmStatic
        public static final State fromJson(ParsingEnvironment parsingEnvironment, JSONObject jSONObject) {
            return INSTANCE.fromJson(parsingEnvironment, jSONObject);
        }

        public State(DivAnimation divAnimation, DivAnimation divAnimation2, Div div, String stateId, List<DivAction> list) {
            Intrinsics.checkNotNullParameter(stateId, "stateId");
            this.animationIn = divAnimation;
            this.animationOut = divAnimation2;
            this.div = div;
            this.stateId = stateId;
            this.swipeOutActions = list;
        }

        public /* synthetic */ State(DivAnimation divAnimation, DivAnimation divAnimation2, Div div, String str, List list, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this((i & 1) != 0 ? null : divAnimation, (i & 2) != 0 ? null : divAnimation2, (i & 4) != 0 ? null : div, str, (i & 16) != 0 ? null : list);
        }

        @Override // com.yandex.div.data.Hashable
        public int hash() {
            Integer num = this._hash;
            if (num != null) {
                return num.intValue();
            }
            int iHashCode = Reflection.getOrCreateKotlinClass(getClass()).hashCode();
            DivAnimation divAnimation = this.animationIn;
            int iHash = 0;
            int iHash2 = iHashCode + (divAnimation != null ? divAnimation.hash() : 0);
            DivAnimation divAnimation2 = this.animationOut;
            int iHash3 = iHash2 + (divAnimation2 != null ? divAnimation2.hash() : 0);
            Div div = this.div;
            int iHash4 = iHash3 + (div != null ? div.hash() : 0) + this.stateId.hashCode();
            List<DivAction> list = this.swipeOutActions;
            if (list != null) {
                Iterator<T> it = list.iterator();
                while (it.hasNext()) {
                    iHash += ((DivAction) it.next()).hash();
                }
            }
            int i = iHash4 + iHash;
            this._hash = Integer.valueOf(i);
            return i;
        }

        public final boolean equals(State other, ExpressionResolver resolver, ExpressionResolver otherResolver) {
            boolean zEquals;
            boolean zEquals2;
            boolean zEquals3;
            boolean z;
            Intrinsics.checkNotNullParameter(resolver, "resolver");
            Intrinsics.checkNotNullParameter(otherResolver, "otherResolver");
            if (other == null) {
                return false;
            }
            DivAnimation divAnimation = this.animationIn;
            if (divAnimation != null) {
                zEquals = divAnimation.equals(other.animationIn, resolver, otherResolver);
            } else {
                zEquals = other.animationIn == null;
            }
            if (!zEquals) {
                return false;
            }
            DivAnimation divAnimation2 = this.animationOut;
            if (divAnimation2 != null) {
                zEquals2 = divAnimation2.equals(other.animationOut, resolver, otherResolver);
            } else {
                zEquals2 = other.animationOut == null;
            }
            if (!zEquals2) {
                return false;
            }
            Div div = this.div;
            if (div != null) {
                zEquals3 = div.equals(other.div, resolver, otherResolver);
            } else {
                zEquals3 = other.div == null;
            }
            if (!zEquals3 || !Intrinsics.areEqual(this.stateId, other.stateId)) {
                return false;
            }
            List<DivAction> list = this.swipeOutActions;
            List<DivAction> list2 = other.swipeOutActions;
            if (list == null) {
                z = list2 == null;
            } else {
                if (list2 == null) {
                    return false;
                }
                if (list.size() == list2.size()) {
                    Iterator<T> it = list.iterator();
                    int i = 0;
                    while (true) {
                        if (it.hasNext()) {
                            Object next = it.next();
                            int i2 = i + 1;
                            if (i < 0) {
                                CollectionsKt.throwIndexOverflow();
                            }
                            if (((DivAction) next).equals(list2.get(i), resolver, otherResolver)) {
                                i = i2;
                            }
                        }
                    }
                }
            }
            return z;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ State copy$default(State state, DivAnimation divAnimation, DivAnimation divAnimation2, Div div, String str, List list, int i, Object obj) {
            if ((i & 1) != 0) {
                divAnimation = state.animationIn;
            }
            if ((i & 2) != 0) {
                divAnimation2 = state.animationOut;
            }
            DivAnimation divAnimation3 = divAnimation2;
            if ((i & 4) != 0) {
                div = state.div;
            }
            Div div2 = div;
            if ((i & 8) != 0) {
                str = state.stateId;
            }
            String str2 = str;
            if ((i & 16) != 0) {
                list = state.swipeOutActions;
            }
            return state.copy(divAnimation, divAnimation3, div2, str2, list);
        }

        public final State copy(DivAnimation animationIn, DivAnimation animationOut, Div div, String stateId, List<DivAction> swipeOutActions) {
            Intrinsics.checkNotNullParameter(stateId, "stateId");
            return new State(animationIn, animationOut, div, stateId, swipeOutActions);
        }

        @Override // com.yandex.div.json.JSONSerializable
        public JSONObject writeToJSON() {
            return BuiltInParserKt.getBuiltInParserComponent().getDivStateStateJsonEntityParser().getValue().serialize(BuiltInParserKt.getBuiltInParsingContext(), this);
        }

        /* JADX INFO: compiled from: DivState.kt */
        @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u001e\u0010\n\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\u00052\u0006\u0010\f\u001a\u00020\u0006H\u0087\u0002¢\u0006\u0002\b\rR#\u0010\u0003\u001a\u0014\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\t¨\u0006\u000e"}, d2 = {"Lcom/yandex/div2/DivState$State$Companion;", "", "()V", "CREATOR", "Lkotlin/Function2;", "Lcom/yandex/div/json/ParsingEnvironment;", "Lorg/json/JSONObject;", "Lcom/yandex/div2/DivState$State;", "getCREATOR", "()Lkotlin/jvm/functions/Function2;", "invoke", cc.o, "json", "fromJson", "div-data_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private Companion() {
            }

            @JvmStatic
            public final State fromJson(ParsingEnvironment env, JSONObject json) {
                Intrinsics.checkNotNullParameter(env, "env");
                Intrinsics.checkNotNullParameter(json, "json");
                return BuiltInParserKt.getBuiltInParserComponent().getDivStateStateJsonEntityParser().getValue().deserialize((ParsingContext) env, json);
            }

            public final Function2<ParsingEnvironment, JSONObject, State> getCREATOR() {
                return State.CREATOR;
            }
        }
    }
}
