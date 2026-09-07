package com.yandex.div2;

import androidx.compose.material.OutlinedTextFieldKt;
import androidx.core.view.ViewCompat;
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

/* JADX INFO: compiled from: DivSlider.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(d1 = {"\u0000ò\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0006\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b2\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 \u008d\u00012\u00020\u00012\u00020\u00022\u00020\u0003:\u0006\u008d\u0001\u008e\u0001\u008f\u0001B¥\u0005\b\u0007\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\u0010\b\u0002\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007\u0012\u0010\b\u0002\u0010\t\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\u0007\u0012\u000e\b\u0002\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\f0\u0007\u0012\u0010\b\u0002\u0010\r\u001a\n\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u000e\u0012\u0010\b\u0002\u0010\u0010\u001a\n\u0012\u0004\u0012\u00020\u0011\u0018\u00010\u000e\u0012\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u0013\u0012\u0010\b\u0002\u0010\u0014\u001a\n\u0012\u0004\u0012\u00020\u0015\u0018\u00010\u0007\u0012\u0010\b\u0002\u0010\u0016\u001a\n\u0012\u0004\u0012\u00020\u0017\u0018\u00010\u000e\u0012\u0010\b\u0002\u0010\u0018\u001a\n\u0012\u0004\u0012\u00020\u0019\u0018\u00010\u000e\u0012\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u001b\u0012\u0010\b\u0002\u0010\u001c\u001a\n\u0012\u0004\u0012\u00020\u001d\u0018\u00010\u000e\u0012\b\b\u0002\u0010\u001e\u001a\u00020\u001f\u0012\n\b\u0002\u0010 \u001a\u0004\u0018\u00010!\u0012\u000e\b\u0002\u0010\"\u001a\b\u0012\u0004\u0012\u00020#0\u0007\u0012\n\b\u0002\u0010$\u001a\u0004\u0018\u00010%\u0012\n\b\u0002\u0010&\u001a\u0004\u0018\u00010'\u0012\u000e\b\u0002\u0010(\u001a\b\u0012\u0004\u0012\u00020\u00150\u0007\u0012\u000e\b\u0002\u0010)\u001a\b\u0012\u0004\u0012\u00020\u00150\u0007\u0012\n\b\u0002\u0010*\u001a\u0004\u0018\u00010'\u0012\u0010\b\u0002\u0010+\u001a\n\u0012\u0004\u0012\u00020,\u0018\u00010\u000e\u0012\u0010\b\u0002\u0010-\u001a\n\u0012\u0004\u0012\u00020!\u0018\u00010\u0007\u0012\u0010\b\u0002\u0010.\u001a\n\u0012\u0004\u0012\u00020\u0015\u0018\u00010\u0007\u0012\n\b\u0002\u0010/\u001a\u0004\u0018\u00010\u0005\u0012\u0010\b\u0002\u00100\u001a\n\u0012\u0004\u0012\u000201\u0018\u00010\u000e\u0012\n\b\u0002\u00102\u001a\u0004\u0018\u000103\u0012\n\b\u0002\u00104\u001a\u0004\u0018\u000105\u0012\n\b\u0002\u00106\u001a\u0004\u0018\u00010!\u0012\u0006\u00107\u001a\u000203\u0012\n\b\u0002\u00108\u001a\u0004\u0018\u000105\u0012\n\b\u0002\u00109\u001a\u0004\u0018\u00010!\u0012\n\b\u0002\u0010:\u001a\u0004\u0018\u000103\u0012\n\b\u0002\u0010;\u001a\u0004\u0018\u000103\u0012\u0010\b\u0002\u0010<\u001a\n\u0012\u0004\u0012\u00020=\u0018\u00010\u000e\u0012\u0006\u0010>\u001a\u000203\u0012\u0006\u0010?\u001a\u000203\u0012\n\b\u0002\u0010@\u001a\u0004\u0018\u00010A\u0012\n\b\u0002\u0010B\u001a\u0004\u0018\u00010C\u0012\n\b\u0002\u0010D\u001a\u0004\u0018\u00010E\u0012\n\b\u0002\u0010F\u001a\u0004\u0018\u00010E\u0012\u0010\b\u0002\u0010G\u001a\n\u0012\u0004\u0012\u00020H\u0018\u00010\u000e\u0012\u0010\b\u0002\u0010I\u001a\n\u0012\u0004\u0012\u00020J\u0018\u00010\u000e\u0012\u0010\b\u0002\u0010K\u001a\n\u0012\u0004\u0012\u00020L\u0018\u00010\u000e\u0012\u000e\b\u0002\u0010M\u001a\b\u0012\u0004\u0012\u00020N0\u0007\u0012\n\b\u0002\u0010O\u001a\u0004\u0018\u00010P\u0012\u0010\b\u0002\u0010Q\u001a\n\u0012\u0004\u0012\u00020P\u0018\u00010\u000e\u0012\b\b\u0002\u0010R\u001a\u00020\u001f¢\u0006\u0002\u0010SJ«\u0005\u0010\u0084\u0001\u001a\u00020\u00002\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0010\b\u0002\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u00072\u0010\b\u0002\u0010\t\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\u00072\u000e\b\u0002\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\f0\u00072\u0010\b\u0002\u0010\r\u001a\n\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u000e2\u0010\b\u0002\u0010\u0010\u001a\n\u0012\u0004\u0012\u00020\u0011\u0018\u00010\u000e2\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u00132\u0010\b\u0002\u0010\u0014\u001a\n\u0012\u0004\u0012\u00020\u0015\u0018\u00010\u00072\u0010\b\u0002\u0010\u0016\u001a\n\u0012\u0004\u0012\u00020\u0017\u0018\u00010\u000e2\u0010\b\u0002\u0010\u0018\u001a\n\u0012\u0004\u0012\u00020\u0019\u0018\u00010\u000e2\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u001b2\u0010\b\u0002\u0010\u001c\u001a\n\u0012\u0004\u0012\u00020\u001d\u0018\u00010\u000e2\b\b\u0002\u0010\u001e\u001a\u00020\u001f2\n\b\u0002\u0010 \u001a\u0004\u0018\u00010!2\u000e\b\u0002\u0010\"\u001a\b\u0012\u0004\u0012\u00020#0\u00072\n\b\u0002\u0010$\u001a\u0004\u0018\u00010%2\n\b\u0002\u0010&\u001a\u0004\u0018\u00010'2\u000e\b\u0002\u0010(\u001a\b\u0012\u0004\u0012\u00020\u00150\u00072\u000e\b\u0002\u0010)\u001a\b\u0012\u0004\u0012\u00020\u00150\u00072\n\b\u0002\u0010*\u001a\u0004\u0018\u00010'2\u0010\b\u0002\u0010+\u001a\n\u0012\u0004\u0012\u00020,\u0018\u00010\u000e2\u0010\b\u0002\u0010-\u001a\n\u0012\u0004\u0012\u00020!\u0018\u00010\u00072\u0010\b\u0002\u0010.\u001a\n\u0012\u0004\u0012\u00020\u0015\u0018\u00010\u00072\n\b\u0002\u0010/\u001a\u0004\u0018\u00010\u00052\u0010\b\u0002\u00100\u001a\n\u0012\u0004\u0012\u000201\u0018\u00010\u000e2\n\b\u0002\u00102\u001a\u0004\u0018\u0001032\n\b\u0002\u00104\u001a\u0004\u0018\u0001052\n\b\u0002\u00106\u001a\u0004\u0018\u00010!2\b\b\u0002\u00107\u001a\u0002032\n\b\u0002\u00108\u001a\u0004\u0018\u0001052\n\b\u0002\u00109\u001a\u0004\u0018\u00010!2\n\b\u0002\u0010:\u001a\u0004\u0018\u0001032\n\b\u0002\u0010;\u001a\u0004\u0018\u0001032\u0010\b\u0002\u0010<\u001a\n\u0012\u0004\u0012\u00020=\u0018\u00010\u000e2\b\b\u0002\u0010>\u001a\u0002032\b\b\u0002\u0010?\u001a\u0002032\n\b\u0002\u0010@\u001a\u0004\u0018\u00010A2\n\b\u0002\u0010B\u001a\u0004\u0018\u00010C2\n\b\u0002\u0010D\u001a\u0004\u0018\u00010E2\n\b\u0002\u0010F\u001a\u0004\u0018\u00010E2\u0010\b\u0002\u0010G\u001a\n\u0012\u0004\u0012\u00020H\u0018\u00010\u000e2\u0010\b\u0002\u0010I\u001a\n\u0012\u0004\u0012\u00020J\u0018\u00010\u000e2\u0010\b\u0002\u0010K\u001a\n\u0012\u0004\u0012\u00020L\u0018\u00010\u000e2\u000e\b\u0002\u0010M\u001a\b\u0012\u0004\u0012\u00020N0\u00072\n\b\u0002\u0010O\u001a\u0004\u0018\u00010P2\u0010\b\u0002\u0010Q\u001a\n\u0012\u0004\u0012\u00020P\u0018\u00010\u000e2\b\b\u0002\u0010R\u001a\u00020\u001fJ&\u0010\u0085\u0001\u001a\u00020#2\t\u0010\u0086\u0001\u001a\u0004\u0018\u00010\u00002\b\u0010\u0087\u0001\u001a\u00030\u0088\u00012\b\u0010\u0089\u0001\u001a\u00030\u0088\u0001J\t\u0010\u008a\u0001\u001a\u00020UH\u0016J\n\u0010\u008b\u0001\u001a\u00030\u008c\u0001H\u0016R\u0012\u0010T\u001a\u0004\u0018\u00010UX\u0082\u000e¢\u0006\u0004\n\u0002\u0010VR\u0016\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\bW\u0010XR\u001c\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\bY\u0010ZR\u001c\u0010\t\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\u0007X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b[\u0010ZR\u001a\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\f0\u0007X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\\\u0010ZR\u001c\u0010\r\u001a\n\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u000eX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b]\u0010^R\u001c\u0010\u0010\u001a\n\u0012\u0004\u0012\u00020\u0011\u0018\u00010\u000eX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b_\u0010^R\u0016\u0010\u0012\u001a\u0004\u0018\u00010\u0013X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b`\u0010aR\u001c\u0010\u0014\u001a\n\u0012\u0004\u0012\u00020\u0015\u0018\u00010\u0007X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\bb\u0010ZR\u001c\u0010\u0016\u001a\n\u0012\u0004\u0012\u00020\u0017\u0018\u00010\u000eX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\bc\u0010^R\u001c\u0010\u0018\u001a\n\u0012\u0004\u0012\u00020\u0019\u0018\u00010\u000eX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\bd\u0010^R\u0016\u0010\u001a\u001a\u0004\u0018\u00010\u001bX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\be\u0010fR\u001c\u0010\u001c\u001a\n\u0012\u0004\u0012\u00020\u001d\u0018\u00010\u000eX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\bg\u0010^R\u0014\u0010\u001e\u001a\u00020\u001fX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\bh\u0010iR\u0016\u0010 \u001a\u0004\u0018\u00010!X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\bj\u0010kR\u0016\u0010\"\u001a\b\u0012\u0004\u0012\u00020#0\u00078\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0016\u0010$\u001a\u0004\u0018\u00010%X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\bl\u0010mR\u0016\u0010&\u001a\u0004\u0018\u00010'X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\bn\u0010oR\u0016\u0010(\u001a\b\u0012\u0004\u0012\u00020\u00150\u00078\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0016\u0010)\u001a\b\u0012\u0004\u0012\u00020\u00150\u00078\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0016\u0010*\u001a\u0004\u0018\u00010'X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\bp\u0010oR\u0018\u0010+\u001a\n\u0012\u0004\u0012\u00020,\u0018\u00010\u000e8\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u001c\u0010-\u001a\n\u0012\u0004\u0012\u00020!\u0018\u00010\u0007X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\bq\u0010ZR\u001c\u0010.\u001a\n\u0012\u0004\u0012\u00020\u0015\u0018\u00010\u0007X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\br\u0010ZR\u0012\u0010/\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u001c\u00100\u001a\n\u0012\u0004\u0012\u000201\u0018\u00010\u000eX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\bs\u0010^R\u0012\u00102\u001a\u0004\u0018\u0001038\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0012\u00104\u001a\u0004\u0018\u0001058\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0012\u00106\u001a\u0004\u0018\u00010!8\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0010\u00107\u001a\u0002038\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0012\u00108\u001a\u0004\u0018\u0001058\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0012\u00109\u001a\u0004\u0018\u00010!8\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0012\u0010:\u001a\u0004\u0018\u0001038\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0012\u0010;\u001a\u0004\u0018\u0001038\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u001c\u0010<\u001a\n\u0012\u0004\u0012\u00020=\u0018\u00010\u000eX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\bt\u0010^R\u0010\u0010>\u001a\u0002038\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0010\u0010?\u001a\u0002038\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0016\u0010@\u001a\u0004\u0018\u00010AX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\bu\u0010vR\u0016\u0010B\u001a\u0004\u0018\u00010CX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\bw\u0010xR\u0016\u0010D\u001a\u0004\u0018\u00010EX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\by\u0010zR\u0016\u0010F\u001a\u0004\u0018\u00010EX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b{\u0010zR\u001c\u0010G\u001a\n\u0012\u0004\u0012\u00020H\u0018\u00010\u000eX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b|\u0010^R\u001c\u0010I\u001a\n\u0012\u0004\u0012\u00020J\u0018\u00010\u000eX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b}\u0010^R\u001c\u0010K\u001a\n\u0012\u0004\u0012\u00020L\u0018\u00010\u000eX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b~\u0010^R\u001a\u0010M\u001a\b\u0012\u0004\u0012\u00020N0\u0007X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u007f\u0010ZR\u0018\u0010O\u001a\u0004\u0018\u00010PX\u0096\u0004¢\u0006\n\n\u0000\u001a\u0006\b\u0080\u0001\u0010\u0081\u0001R\u001d\u0010Q\u001a\n\u0012\u0004\u0012\u00020P\u0018\u00010\u000eX\u0096\u0004¢\u0006\t\n\u0000\u001a\u0005\b\u0082\u0001\u0010^R\u0015\u0010R\u001a\u00020\u001fX\u0096\u0004¢\u0006\t\n\u0000\u001a\u0005\b\u0083\u0001\u0010i¨\u0006\u0090\u0001"}, d2 = {"Lcom/yandex/div2/DivSlider;", "Lcom/yandex/div/json/JSONSerializable;", "Lcom/yandex/div/data/Hashable;", "Lcom/yandex/div2/DivBase;", "accessibility", "Lcom/yandex/div2/DivAccessibility;", "alignmentHorizontal", "Lcom/yandex/div/json/expressions/Expression;", "Lcom/yandex/div2/DivAlignmentHorizontal;", "alignmentVertical", "Lcom/yandex/div2/DivAlignmentVertical;", "alpha", "", "animators", "", "Lcom/yandex/div2/DivAnimator;", J2.g, "Lcom/yandex/div2/DivBackground;", OutlinedTextFieldKt.BorderId, "Lcom/yandex/div2/DivBorder;", "columnSpan", "", "disappearActions", "Lcom/yandex/div2/DivDisappearAction;", "extensions", "Lcom/yandex/div2/DivExtension;", "focus", "Lcom/yandex/div2/DivFocus;", "functions", "Lcom/yandex/div2/DivFunction;", "height", "Lcom/yandex/div2/DivSize;", "id", "", "isEnabled", "", "layoutProvider", "Lcom/yandex/div2/DivLayoutProvider;", "margins", "Lcom/yandex/div2/DivEdgeInsets;", "maxValue", "minValue", "paddings", "ranges", "Lcom/yandex/div2/DivSlider$Range;", "reuseId", "rowSpan", "secondaryValueAccessibility", "selectedActions", "Lcom/yandex/div2/DivAction;", "thumbSecondaryStyle", "Lcom/yandex/div2/DivDrawable;", "thumbSecondaryTextStyle", "Lcom/yandex/div2/DivSlider$TextStyle;", "thumbSecondaryValueVariable", "thumbStyle", "thumbTextStyle", "thumbValueVariable", "tickMarkActiveStyle", "tickMarkInactiveStyle", "tooltips", "Lcom/yandex/div2/DivTooltip;", "trackActiveStyle", "trackInactiveStyle", "transform", "Lcom/yandex/div2/DivTransform;", "transitionChange", "Lcom/yandex/div2/DivChangeTransition;", "transitionIn", "Lcom/yandex/div2/DivAppearanceTransition;", "transitionOut", "transitionTriggers", "Lcom/yandex/div2/DivTransitionTrigger;", "variableTriggers", "Lcom/yandex/div2/DivTrigger;", "variables", "Lcom/yandex/div2/DivVariable;", "visibility", "Lcom/yandex/div2/DivVisibility;", "visibilityAction", "Lcom/yandex/div2/DivVisibilityAction;", "visibilityActions", "width", "(Lcom/yandex/div2/DivAccessibility;Lcom/yandex/div/json/expressions/Expression;Lcom/yandex/div/json/expressions/Expression;Lcom/yandex/div/json/expressions/Expression;Ljava/util/List;Ljava/util/List;Lcom/yandex/div2/DivBorder;Lcom/yandex/div/json/expressions/Expression;Ljava/util/List;Ljava/util/List;Lcom/yandex/div2/DivFocus;Ljava/util/List;Lcom/yandex/div2/DivSize;Ljava/lang/String;Lcom/yandex/div/json/expressions/Expression;Lcom/yandex/div2/DivLayoutProvider;Lcom/yandex/div2/DivEdgeInsets;Lcom/yandex/div/json/expressions/Expression;Lcom/yandex/div/json/expressions/Expression;Lcom/yandex/div2/DivEdgeInsets;Ljava/util/List;Lcom/yandex/div/json/expressions/Expression;Lcom/yandex/div/json/expressions/Expression;Lcom/yandex/div2/DivAccessibility;Ljava/util/List;Lcom/yandex/div2/DivDrawable;Lcom/yandex/div2/DivSlider$TextStyle;Ljava/lang/String;Lcom/yandex/div2/DivDrawable;Lcom/yandex/div2/DivSlider$TextStyle;Ljava/lang/String;Lcom/yandex/div2/DivDrawable;Lcom/yandex/div2/DivDrawable;Ljava/util/List;Lcom/yandex/div2/DivDrawable;Lcom/yandex/div2/DivDrawable;Lcom/yandex/div2/DivTransform;Lcom/yandex/div2/DivChangeTransition;Lcom/yandex/div2/DivAppearanceTransition;Lcom/yandex/div2/DivAppearanceTransition;Ljava/util/List;Ljava/util/List;Ljava/util/List;Lcom/yandex/div/json/expressions/Expression;Lcom/yandex/div2/DivVisibilityAction;Ljava/util/List;Lcom/yandex/div2/DivSize;)V", "_hash", "", "Ljava/lang/Integer;", "getAccessibility", "()Lcom/yandex/div2/DivAccessibility;", "getAlignmentHorizontal", "()Lcom/yandex/div/json/expressions/Expression;", "getAlignmentVertical", "getAlpha", "getAnimators", "()Ljava/util/List;", "getBackground", "getBorder", "()Lcom/yandex/div2/DivBorder;", "getColumnSpan", "getDisappearActions", "getExtensions", "getFocus", "()Lcom/yandex/div2/DivFocus;", "getFunctions", "getHeight", "()Lcom/yandex/div2/DivSize;", "getId", "()Ljava/lang/String;", "getLayoutProvider", "()Lcom/yandex/div2/DivLayoutProvider;", "getMargins", "()Lcom/yandex/div2/DivEdgeInsets;", "getPaddings", "getReuseId", "getRowSpan", "getSelectedActions", "getTooltips", "getTransform", "()Lcom/yandex/div2/DivTransform;", "getTransitionChange", "()Lcom/yandex/div2/DivChangeTransition;", "getTransitionIn", "()Lcom/yandex/div2/DivAppearanceTransition;", "getTransitionOut", "getTransitionTriggers", "getVariableTriggers", "getVariables", "getVisibility", "getVisibilityAction", "()Lcom/yandex/div2/DivVisibilityAction;", "getVisibilityActions", "getWidth", "copy", "equals", "other", "resolver", "Lcom/yandex/div/json/expressions/ExpressionResolver;", "otherResolver", "hash", "writeToJSON", "Lorg/json/JSONObject;", "Companion", "Range", "TextStyle", "div-data_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class DivSlider implements JSONSerializable, Hashable, DivBase {
    public static final String TYPE = "slider";
    private Integer _hash;
    private final DivAccessibility accessibility;
    private final Expression<DivAlignmentHorizontal> alignmentHorizontal;
    private final Expression<DivAlignmentVertical> alignmentVertical;
    private final Expression<Double> alpha;
    private final List<DivAnimator> animators;
    private final List<DivBackground> background;
    private final DivBorder border;
    private final Expression<Long> columnSpan;
    private final List<DivDisappearAction> disappearActions;
    private final List<DivExtension> extensions;
    private final DivFocus focus;
    private final List<DivFunction> functions;
    private final DivSize height;
    private final String id;
    public final Expression<Boolean> isEnabled;
    private final DivLayoutProvider layoutProvider;
    private final DivEdgeInsets margins;
    public final Expression<Long> maxValue;
    public final Expression<Long> minValue;
    private final DivEdgeInsets paddings;
    public final List<Range> ranges;
    private final Expression<String> reuseId;
    private final Expression<Long> rowSpan;
    public final DivAccessibility secondaryValueAccessibility;
    private final List<DivAction> selectedActions;
    public final DivDrawable thumbSecondaryStyle;
    public final TextStyle thumbSecondaryTextStyle;
    public final String thumbSecondaryValueVariable;
    public final DivDrawable thumbStyle;
    public final TextStyle thumbTextStyle;
    public final String thumbValueVariable;
    public final DivDrawable tickMarkActiveStyle;
    public final DivDrawable tickMarkInactiveStyle;
    private final List<DivTooltip> tooltips;
    public final DivDrawable trackActiveStyle;
    public final DivDrawable trackInactiveStyle;
    private final DivTransform transform;
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
    private static final DivSize.WrapContent HEIGHT_DEFAULT_VALUE = new DivSize.WrapContent(new DivWrapContentSize(null, null, null, 7, null));
    private static final Expression<Boolean> IS_ENABLED_DEFAULT_VALUE = Expression.INSTANCE.constant(true);
    private static final Expression<Long> MAX_VALUE_DEFAULT_VALUE = Expression.INSTANCE.constant(100L);
    private static final Expression<Long> MIN_VALUE_DEFAULT_VALUE = Expression.INSTANCE.constant(0L);
    private static final Expression<DivVisibility> VISIBILITY_DEFAULT_VALUE = Expression.INSTANCE.constant(DivVisibility.VISIBLE);
    private static final DivSize.MatchParent WIDTH_DEFAULT_VALUE = new DivSize.MatchParent(new DivMatchParentSize(0 == true ? 1 : 0, 1, 0 == true ? 1 : 0));
    private static final Function2<ParsingEnvironment, JSONObject, DivSlider> CREATOR = new Function2<ParsingEnvironment, JSONObject, DivSlider>() { // from class: com.yandex.div2.DivSlider$Companion$CREATOR$1
        @Override // kotlin.jvm.functions.Function2
        public final DivSlider invoke(ParsingEnvironment env, JSONObject it) {
            Intrinsics.checkNotNullParameter(env, "env");
            Intrinsics.checkNotNullParameter(it, "it");
            return DivSlider.INSTANCE.fromJson(env, it);
        }
    };

    @JvmStatic
    public static final DivSlider fromJson(ParsingEnvironment parsingEnvironment, JSONObject jSONObject) {
        return INSTANCE.fromJson(parsingEnvironment, jSONObject);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public DivSlider(DivAccessibility divAccessibility, Expression<DivAlignmentHorizontal> expression, Expression<DivAlignmentVertical> expression2, Expression<Double> alpha, List<? extends DivAnimator> list, List<? extends DivBackground> list2, DivBorder divBorder, Expression<Long> expression3, List<DivDisappearAction> list3, List<DivExtension> list4, DivFocus divFocus, List<DivFunction> list5, DivSize height, String str, Expression<Boolean> isEnabled, DivLayoutProvider divLayoutProvider, DivEdgeInsets divEdgeInsets, Expression<Long> maxValue, Expression<Long> minValue, DivEdgeInsets divEdgeInsets2, List<Range> list6, Expression<String> expression4, Expression<Long> expression5, DivAccessibility divAccessibility2, List<DivAction> list7, DivDrawable divDrawable, TextStyle textStyle, String str2, DivDrawable thumbStyle, TextStyle textStyle2, String str3, DivDrawable divDrawable2, DivDrawable divDrawable3, List<DivTooltip> list8, DivDrawable trackActiveStyle, DivDrawable trackInactiveStyle, DivTransform divTransform, DivChangeTransition divChangeTransition, DivAppearanceTransition divAppearanceTransition, DivAppearanceTransition divAppearanceTransition2, List<? extends DivTransitionTrigger> list9, List<DivTrigger> list10, List<? extends DivVariable> list11, Expression<DivVisibility> visibility, DivVisibilityAction divVisibilityAction, List<DivVisibilityAction> list12, DivSize width) {
        Intrinsics.checkNotNullParameter(alpha, "alpha");
        Intrinsics.checkNotNullParameter(height, "height");
        Intrinsics.checkNotNullParameter(isEnabled, "isEnabled");
        Intrinsics.checkNotNullParameter(maxValue, "maxValue");
        Intrinsics.checkNotNullParameter(minValue, "minValue");
        Intrinsics.checkNotNullParameter(thumbStyle, "thumbStyle");
        Intrinsics.checkNotNullParameter(trackActiveStyle, "trackActiveStyle");
        Intrinsics.checkNotNullParameter(trackInactiveStyle, "trackInactiveStyle");
        Intrinsics.checkNotNullParameter(visibility, "visibility");
        Intrinsics.checkNotNullParameter(width, "width");
        this.accessibility = divAccessibility;
        this.alignmentHorizontal = expression;
        this.alignmentVertical = expression2;
        this.alpha = alpha;
        this.animators = list;
        this.background = list2;
        this.border = divBorder;
        this.columnSpan = expression3;
        this.disappearActions = list3;
        this.extensions = list4;
        this.focus = divFocus;
        this.functions = list5;
        this.height = height;
        this.id = str;
        this.isEnabled = isEnabled;
        this.layoutProvider = divLayoutProvider;
        this.margins = divEdgeInsets;
        this.maxValue = maxValue;
        this.minValue = minValue;
        this.paddings = divEdgeInsets2;
        this.ranges = list6;
        this.reuseId = expression4;
        this.rowSpan = expression5;
        this.secondaryValueAccessibility = divAccessibility2;
        this.selectedActions = list7;
        this.thumbSecondaryStyle = divDrawable;
        this.thumbSecondaryTextStyle = textStyle;
        this.thumbSecondaryValueVariable = str2;
        this.thumbStyle = thumbStyle;
        this.thumbTextStyle = textStyle2;
        this.thumbValueVariable = str3;
        this.tickMarkActiveStyle = divDrawable2;
        this.tickMarkInactiveStyle = divDrawable3;
        this.tooltips = list8;
        this.trackActiveStyle = trackActiveStyle;
        this.trackInactiveStyle = trackInactiveStyle;
        this.transform = divTransform;
        this.transitionChange = divChangeTransition;
        this.transitionIn = divAppearanceTransition;
        this.transitionOut = divAppearanceTransition2;
        this.transitionTriggers = list9;
        this.variableTriggers = list10;
        this.variables = list11;
        this.visibility = visibility;
        this.visibilityAction = divVisibilityAction;
        this.visibilityActions = list12;
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

    public /* synthetic */ DivSlider(DivAccessibility divAccessibility, Expression expression, Expression expression2, Expression expression3, List list, List list2, DivBorder divBorder, Expression expression4, List list3, List list4, DivFocus divFocus, List list5, DivSize divSize, String str, Expression expression5, DivLayoutProvider divLayoutProvider, DivEdgeInsets divEdgeInsets, Expression expression6, Expression expression7, DivEdgeInsets divEdgeInsets2, List list6, Expression expression8, Expression expression9, DivAccessibility divAccessibility2, List list7, DivDrawable divDrawable, TextStyle textStyle, String str2, DivDrawable divDrawable2, TextStyle textStyle2, String str3, DivDrawable divDrawable3, DivDrawable divDrawable4, List list8, DivDrawable divDrawable5, DivDrawable divDrawable6, DivTransform divTransform, DivChangeTransition divChangeTransition, DivAppearanceTransition divAppearanceTransition, DivAppearanceTransition divAppearanceTransition2, List list9, List list10, List list11, Expression expression10, DivVisibilityAction divVisibilityAction, List list12, DivSize divSize2, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : divAccessibility, (i & 2) != 0 ? null : expression, (i & 4) != 0 ? null : expression2, (i & 8) != 0 ? ALPHA_DEFAULT_VALUE : expression3, (i & 16) != 0 ? null : list, (i & 32) != 0 ? null : list2, (i & 64) != 0 ? null : divBorder, (i & 128) != 0 ? null : expression4, (i & 256) != 0 ? null : list3, (i & 512) != 0 ? null : list4, (i & 1024) != 0 ? null : divFocus, (i & 2048) != 0 ? null : list5, (i & 4096) != 0 ? HEIGHT_DEFAULT_VALUE : divSize, (i & 8192) != 0 ? null : str, (i & 16384) != 0 ? IS_ENABLED_DEFAULT_VALUE : expression5, (32768 & i) != 0 ? null : divLayoutProvider, (65536 & i) != 0 ? null : divEdgeInsets, (131072 & i) != 0 ? MAX_VALUE_DEFAULT_VALUE : expression6, (262144 & i) != 0 ? MIN_VALUE_DEFAULT_VALUE : expression7, (524288 & i) != 0 ? null : divEdgeInsets2, (1048576 & i) != 0 ? null : list6, (2097152 & i) != 0 ? null : expression8, (4194304 & i) != 0 ? null : expression9, (8388608 & i) != 0 ? null : divAccessibility2, (16777216 & i) != 0 ? null : list7, (33554432 & i) != 0 ? null : divDrawable, (67108864 & i) != 0 ? null : textStyle, (134217728 & i) != 0 ? null : str2, divDrawable2, (536870912 & i) != 0 ? null : textStyle2, (1073741824 & i) != 0 ? null : str3, (i & Integer.MIN_VALUE) != 0 ? null : divDrawable3, (i2 & 1) != 0 ? null : divDrawable4, (i2 & 2) != 0 ? null : list8, divDrawable5, divDrawable6, (i2 & 16) != 0 ? null : divTransform, (i2 & 32) != 0 ? null : divChangeTransition, (i2 & 64) != 0 ? null : divAppearanceTransition, (i2 & 128) != 0 ? null : divAppearanceTransition2, (i2 & 256) != 0 ? null : list9, (i2 & 512) != 0 ? null : list10, (i2 & 1024) != 0 ? null : list11, (i2 & 2048) != 0 ? VISIBILITY_DEFAULT_VALUE : expression10, (i2 & 4096) != 0 ? null : divVisibilityAction, (i2 & 8192) != 0 ? null : list12, (i2 & 16384) != 0 ? WIDTH_DEFAULT_VALUE : divSize2);
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
    public int hash() {
        int iHash;
        int iHash2;
        int iHash3;
        int iHash4;
        int iHash5;
        int iHash6;
        int iHash7;
        int iHash8;
        int iHash9;
        int iHash10;
        Integer num = this._hash;
        if (num != null) {
            return num.intValue();
        }
        int iHashCode = Reflection.getOrCreateKotlinClass(getClass()).hashCode();
        DivAccessibility accessibility = getAccessibility();
        int iHash11 = 0;
        int iHash12 = iHashCode + (accessibility != null ? accessibility.hash() : 0);
        Expression<DivAlignmentHorizontal> alignmentHorizontal = getAlignmentHorizontal();
        int iHashCode2 = iHash12 + (alignmentHorizontal != null ? alignmentHorizontal.hashCode() : 0);
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
        int iHash13 = i2 + (border != null ? border.hash() : 0);
        Expression<Long> columnSpan = getColumnSpan();
        int iHashCode4 = iHash13 + (columnSpan != null ? columnSpan.hashCode() : 0);
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
        int i3 = iHashCode4 + iHash3;
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
        int i4 = i3 + iHash4;
        DivFocus focus = getFocus();
        int iHash14 = i4 + (focus != null ? focus.hash() : 0);
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
        int iHash15 = iHash14 + iHash5 + getHeight().hash();
        String id = getId();
        int iHashCode5 = iHash15 + (id != null ? id.hashCode() : 0) + this.isEnabled.hashCode();
        DivLayoutProvider layoutProvider = getLayoutProvider();
        int iHash16 = iHashCode5 + (layoutProvider != null ? layoutProvider.hash() : 0);
        DivEdgeInsets margins = getMargins();
        int iHash17 = iHash16 + (margins != null ? margins.hash() : 0) + this.maxValue.hashCode() + this.minValue.hashCode();
        DivEdgeInsets paddings = getPaddings();
        int iHash18 = iHash17 + (paddings != null ? paddings.hash() : 0);
        List<Range> list = this.ranges;
        if (list != null) {
            Iterator<T> it6 = list.iterator();
            iHash6 = 0;
            while (it6.hasNext()) {
                iHash6 += ((Range) it6.next()).hash();
            }
        } else {
            iHash6 = 0;
        }
        int i5 = iHash18 + iHash6;
        Expression<String> reuseId = getReuseId();
        int iHashCode6 = i5 + (reuseId != null ? reuseId.hashCode() : 0);
        Expression<Long> rowSpan = getRowSpan();
        int iHashCode7 = iHashCode6 + (rowSpan != null ? rowSpan.hashCode() : 0);
        DivAccessibility divAccessibility = this.secondaryValueAccessibility;
        int iHash19 = iHashCode7 + (divAccessibility != null ? divAccessibility.hash() : 0);
        List<DivAction> selectedActions = getSelectedActions();
        if (selectedActions != null) {
            Iterator<T> it7 = selectedActions.iterator();
            iHash7 = 0;
            while (it7.hasNext()) {
                iHash7 += ((DivAction) it7.next()).hash();
            }
        } else {
            iHash7 = 0;
        }
        int i6 = iHash19 + iHash7;
        DivDrawable divDrawable = this.thumbSecondaryStyle;
        int iHash20 = i6 + (divDrawable != null ? divDrawable.hash() : 0);
        TextStyle textStyle = this.thumbSecondaryTextStyle;
        int iHash21 = iHash20 + (textStyle != null ? textStyle.hash() : 0);
        String str = this.thumbSecondaryValueVariable;
        int iHashCode8 = iHash21 + (str != null ? str.hashCode() : 0) + this.thumbStyle.hash();
        TextStyle textStyle2 = this.thumbTextStyle;
        int iHash22 = iHashCode8 + (textStyle2 != null ? textStyle2.hash() : 0);
        String str2 = this.thumbValueVariable;
        int iHashCode9 = iHash22 + (str2 != null ? str2.hashCode() : 0);
        DivDrawable divDrawable2 = this.tickMarkActiveStyle;
        int iHash23 = iHashCode9 + (divDrawable2 != null ? divDrawable2.hash() : 0);
        DivDrawable divDrawable3 = this.tickMarkInactiveStyle;
        int iHash24 = iHash23 + (divDrawable3 != null ? divDrawable3.hash() : 0);
        List<DivTooltip> tooltips = getTooltips();
        if (tooltips != null) {
            Iterator<T> it8 = tooltips.iterator();
            iHash8 = 0;
            while (it8.hasNext()) {
                iHash8 += ((DivTooltip) it8.next()).hash();
            }
        } else {
            iHash8 = 0;
        }
        int iHash25 = iHash24 + iHash8 + this.trackActiveStyle.hash() + this.trackInactiveStyle.hash();
        DivTransform transform = getTransform();
        int iHash26 = iHash25 + (transform != null ? transform.hash() : 0);
        DivChangeTransition transitionChange = getTransitionChange();
        int iHash27 = iHash26 + (transitionChange != null ? transitionChange.hash() : 0);
        DivAppearanceTransition transitionIn = getTransitionIn();
        int iHash28 = iHash27 + (transitionIn != null ? transitionIn.hash() : 0);
        DivAppearanceTransition transitionOut = getTransitionOut();
        int iHash29 = iHash28 + (transitionOut != null ? transitionOut.hash() : 0);
        List<DivTransitionTrigger> transitionTriggers = getTransitionTriggers();
        int iHashCode10 = iHash29 + (transitionTriggers != null ? transitionTriggers.hashCode() : 0);
        List<DivTrigger> variableTriggers = getVariableTriggers();
        if (variableTriggers != null) {
            Iterator<T> it9 = variableTriggers.iterator();
            iHash9 = 0;
            while (it9.hasNext()) {
                iHash9 += ((DivTrigger) it9.next()).hash();
            }
        } else {
            iHash9 = 0;
        }
        int i7 = iHashCode10 + iHash9;
        List<DivVariable> variables = getVariables();
        if (variables != null) {
            Iterator<T> it10 = variables.iterator();
            iHash10 = 0;
            while (it10.hasNext()) {
                iHash10 += ((DivVariable) it10.next()).hash();
            }
        } else {
            iHash10 = 0;
        }
        int iHashCode11 = i7 + iHash10 + getVisibility().hashCode();
        DivVisibilityAction visibilityAction = getVisibilityAction();
        int iHash30 = iHashCode11 + (visibilityAction != null ? visibilityAction.hash() : 0);
        List<DivVisibilityAction> visibilityActions = getVisibilityActions();
        if (visibilityActions != null) {
            Iterator<T> it11 = visibilityActions.iterator();
            while (it11.hasNext()) {
                iHash11 += ((DivVisibilityAction) it11.next()).hash();
            }
        }
        int iHash31 = iHash30 + iHash11 + getWidth().hash();
        this._hash = Integer.valueOf(iHash31);
        return iHash31;
    }

    public final boolean equals(DivSlider other, ExpressionResolver resolver, ExpressionResolver otherResolver) {
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
        boolean zEquals7;
        boolean z7;
        boolean zEquals8;
        boolean zEquals9;
        boolean zEquals10;
        boolean zEquals11;
        boolean zEquals12;
        boolean z8;
        boolean zEquals13;
        boolean zEquals14;
        boolean zEquals15;
        boolean zEquals16;
        boolean z9;
        boolean z10;
        boolean z11;
        boolean zEquals17;
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
        if (!zEquals2) {
            return false;
        }
        Expression<Long> columnSpan = getColumnSpan();
        Long lEvaluate = columnSpan != null ? columnSpan.evaluate(resolver) : null;
        Expression<Long> columnSpan2 = other.getColumnSpan();
        if (!Intrinsics.areEqual(lEvaluate, columnSpan2 != null ? columnSpan2.evaluate(otherResolver) : null)) {
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
        if (!z3) {
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
        if (!z5 || !getHeight().equals(other.getHeight(), resolver, otherResolver) || !Intrinsics.areEqual(getId(), other.getId()) || this.isEnabled.evaluate(resolver).booleanValue() != other.isEnabled.evaluate(otherResolver).booleanValue()) {
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
        if (!zEquals5 || this.maxValue.evaluate(resolver).longValue() != other.maxValue.evaluate(otherResolver).longValue() || this.minValue.evaluate(resolver).longValue() != other.minValue.evaluate(otherResolver).longValue()) {
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
        List<Range> list = this.ranges;
        if (list != null) {
            List<Range> list2 = other.ranges;
            if (list2 == null) {
                return false;
            }
            if (list.size() == list2.size()) {
                Iterator<T> it6 = list.iterator();
                int i11 = 0;
                while (true) {
                    if (it6.hasNext()) {
                        Object next6 = it6.next();
                        int i12 = i11 + 1;
                        if (i11 < 0) {
                            CollectionsKt.throwIndexOverflow();
                        }
                        if (((Range) next6).equals(list2.get(i11), resolver, otherResolver)) {
                            i11 = i12;
                        }
                    }
                }
            }
        } else {
            z6 = other.ranges == null;
        }
        if (!z6) {
            return false;
        }
        Expression<String> reuseId = getReuseId();
        String strEvaluate = reuseId != null ? reuseId.evaluate(resolver) : null;
        Expression<String> reuseId2 = other.getReuseId();
        if (!Intrinsics.areEqual(strEvaluate, reuseId2 != null ? reuseId2.evaluate(otherResolver) : null)) {
            return false;
        }
        Expression<Long> rowSpan = getRowSpan();
        Long lEvaluate2 = rowSpan != null ? rowSpan.evaluate(resolver) : null;
        Expression<Long> rowSpan2 = other.getRowSpan();
        if (!Intrinsics.areEqual(lEvaluate2, rowSpan2 != null ? rowSpan2.evaluate(otherResolver) : null)) {
            return false;
        }
        DivAccessibility divAccessibility = this.secondaryValueAccessibility;
        if (divAccessibility != null) {
            zEquals7 = divAccessibility.equals(other.secondaryValueAccessibility, resolver, otherResolver);
        } else {
            zEquals7 = other.secondaryValueAccessibility == null;
        }
        if (!zEquals7) {
            return false;
        }
        List<DivAction> selectedActions = getSelectedActions();
        if (selectedActions != null) {
            List<DivAction> selectedActions2 = other.getSelectedActions();
            if (selectedActions2 == null) {
                return false;
            }
            if (selectedActions.size() == selectedActions2.size()) {
                Iterator<T> it7 = selectedActions.iterator();
                int i13 = 0;
                while (true) {
                    if (it7.hasNext()) {
                        Object next7 = it7.next();
                        int i14 = i13 + 1;
                        if (i13 < 0) {
                            CollectionsKt.throwIndexOverflow();
                        }
                        if (((DivAction) next7).equals(selectedActions2.get(i13), resolver, otherResolver)) {
                            i13 = i14;
                        }
                    }
                }
            }
        } else {
            z7 = other.getSelectedActions() == null;
        }
        if (!z7) {
            return false;
        }
        DivDrawable divDrawable = this.thumbSecondaryStyle;
        if (divDrawable != null) {
            zEquals8 = divDrawable.equals(other.thumbSecondaryStyle, resolver, otherResolver);
        } else {
            zEquals8 = other.thumbSecondaryStyle == null;
        }
        if (!zEquals8) {
            return false;
        }
        TextStyle textStyle = this.thumbSecondaryTextStyle;
        if (textStyle != null) {
            zEquals9 = textStyle.equals(other.thumbSecondaryTextStyle, resolver, otherResolver);
        } else {
            zEquals9 = other.thumbSecondaryTextStyle == null;
        }
        if (!zEquals9 || !Intrinsics.areEqual(this.thumbSecondaryValueVariable, other.thumbSecondaryValueVariable) || !this.thumbStyle.equals(other.thumbStyle, resolver, otherResolver)) {
            return false;
        }
        TextStyle textStyle2 = this.thumbTextStyle;
        if (textStyle2 != null) {
            zEquals10 = textStyle2.equals(other.thumbTextStyle, resolver, otherResolver);
        } else {
            zEquals10 = other.thumbTextStyle == null;
        }
        if (!zEquals10 || !Intrinsics.areEqual(this.thumbValueVariable, other.thumbValueVariable)) {
            return false;
        }
        DivDrawable divDrawable2 = this.tickMarkActiveStyle;
        if (divDrawable2 != null) {
            zEquals11 = divDrawable2.equals(other.tickMarkActiveStyle, resolver, otherResolver);
        } else {
            zEquals11 = other.tickMarkActiveStyle == null;
        }
        if (!zEquals11) {
            return false;
        }
        DivDrawable divDrawable3 = this.tickMarkInactiveStyle;
        if (divDrawable3 != null) {
            zEquals12 = divDrawable3.equals(other.tickMarkInactiveStyle, resolver, otherResolver);
        } else {
            zEquals12 = other.tickMarkInactiveStyle == null;
        }
        if (!zEquals12) {
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
        if (!z8 || !this.trackActiveStyle.equals(other.trackActiveStyle, resolver, otherResolver) || !this.trackInactiveStyle.equals(other.trackInactiveStyle, resolver, otherResolver)) {
            return false;
        }
        DivTransform transform = getTransform();
        if (transform != null) {
            zEquals13 = transform.equals(other.getTransform(), resolver, otherResolver);
        } else {
            zEquals13 = other.getTransform() == null;
        }
        if (!zEquals13) {
            return false;
        }
        DivChangeTransition transitionChange = getTransitionChange();
        if (transitionChange != null) {
            zEquals14 = transitionChange.equals(other.getTransitionChange(), resolver, otherResolver);
        } else {
            zEquals14 = other.getTransitionChange() == null;
        }
        if (!zEquals14) {
            return false;
        }
        DivAppearanceTransition transitionIn = getTransitionIn();
        if (transitionIn != null) {
            zEquals15 = transitionIn.equals(other.getTransitionIn(), resolver, otherResolver);
        } else {
            zEquals15 = other.getTransitionIn() == null;
        }
        if (!zEquals15) {
            return false;
        }
        DivAppearanceTransition transitionOut = getTransitionOut();
        if (transitionOut != null) {
            zEquals16 = transitionOut.equals(other.getTransitionOut(), resolver, otherResolver);
        } else {
            zEquals16 = other.getTransitionOut() == null;
        }
        if (!zEquals16) {
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
            zEquals17 = visibilityAction.equals(other.getVisibilityAction(), resolver, otherResolver);
        } else {
            zEquals17 = other.getVisibilityAction() == null;
        }
        if (!zEquals17) {
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
    public static /* synthetic */ DivSlider copy$default(DivSlider divSlider, DivAccessibility divAccessibility, Expression expression, Expression expression2, Expression expression3, List list, List list2, DivBorder divBorder, Expression expression4, List list3, List list4, DivFocus divFocus, List list5, DivSize divSize, String str, Expression expression5, DivLayoutProvider divLayoutProvider, DivEdgeInsets divEdgeInsets, Expression expression6, Expression expression7, DivEdgeInsets divEdgeInsets2, List list6, Expression expression8, Expression expression9, DivAccessibility divAccessibility2, List list7, DivDrawable divDrawable, TextStyle textStyle, String str2, DivDrawable divDrawable2, TextStyle textStyle2, String str3, DivDrawable divDrawable3, DivDrawable divDrawable4, List list8, DivDrawable divDrawable5, DivDrawable divDrawable6, DivTransform divTransform, DivChangeTransition divChangeTransition, DivAppearanceTransition divAppearanceTransition, DivAppearanceTransition divAppearanceTransition2, List list9, List list10, List list11, Expression expression10, DivVisibilityAction divVisibilityAction, List list12, DivSize divSize2, int i, int i2, Object obj) {
        DivAccessibility accessibility = (i & 1) != 0 ? divSlider.getAccessibility() : divAccessibility;
        Expression alignmentHorizontal = (i & 2) != 0 ? divSlider.getAlignmentHorizontal() : expression;
        Expression alignmentVertical = (i & 4) != 0 ? divSlider.getAlignmentVertical() : expression2;
        Expression alpha = (i & 8) != 0 ? divSlider.getAlpha() : expression3;
        List animators = (i & 16) != 0 ? divSlider.getAnimators() : list;
        List background = (i & 32) != 0 ? divSlider.getBackground() : list2;
        DivBorder border = (i & 64) != 0 ? divSlider.getBorder() : divBorder;
        Expression columnSpan = (i & 128) != 0 ? divSlider.getColumnSpan() : expression4;
        List disappearActions = (i & 256) != 0 ? divSlider.getDisappearActions() : list3;
        List extensions = (i & 512) != 0 ? divSlider.getExtensions() : list4;
        DivFocus focus = (i & 1024) != 0 ? divSlider.getFocus() : divFocus;
        List functions = (i & 2048) != 0 ? divSlider.getFunctions() : list5;
        DivSize height = (i & 4096) != 0 ? divSlider.getHeight() : divSize;
        String id = (i & 8192) != 0 ? divSlider.getId() : str;
        Expression expression11 = (i & 16384) != 0 ? divSlider.isEnabled : expression5;
        DivLayoutProvider layoutProvider = (i & 32768) != 0 ? divSlider.getLayoutProvider() : divLayoutProvider;
        DivEdgeInsets margins = (i & 65536) != 0 ? divSlider.getMargins() : divEdgeInsets;
        Expression expression12 = expression11;
        Expression expression13 = (i & 131072) != 0 ? divSlider.maxValue : expression6;
        Expression expression14 = (i & 262144) != 0 ? divSlider.minValue : expression7;
        DivEdgeInsets paddings = (i & 524288) != 0 ? divSlider.getPaddings() : divEdgeInsets2;
        Expression expression15 = expression14;
        List list13 = (i & 1048576) != 0 ? divSlider.ranges : list6;
        Expression reuseId = (i & 2097152) != 0 ? divSlider.getReuseId() : expression8;
        Expression rowSpan = (i & 4194304) != 0 ? divSlider.getRowSpan() : expression9;
        List list14 = list13;
        DivAccessibility divAccessibility3 = (i & 8388608) != 0 ? divSlider.secondaryValueAccessibility : divAccessibility2;
        return divSlider.copy(accessibility, alignmentHorizontal, alignmentVertical, alpha, animators, background, border, columnSpan, disappearActions, extensions, focus, functions, height, id, expression12, layoutProvider, margins, expression13, expression15, paddings, list14, reuseId, rowSpan, divAccessibility3, (i & 16777216) != 0 ? divSlider.getSelectedActions() : list7, (i & 33554432) != 0 ? divSlider.thumbSecondaryStyle : divDrawable, (i & 67108864) != 0 ? divSlider.thumbSecondaryTextStyle : textStyle, (i & 134217728) != 0 ? divSlider.thumbSecondaryValueVariable : str2, (i & 268435456) != 0 ? divSlider.thumbStyle : divDrawable2, (i & 536870912) != 0 ? divSlider.thumbTextStyle : textStyle2, (i & 1073741824) != 0 ? divSlider.thumbValueVariable : str3, (i & Integer.MIN_VALUE) != 0 ? divSlider.tickMarkActiveStyle : divDrawable3, (i2 & 1) != 0 ? divSlider.tickMarkInactiveStyle : divDrawable4, (i2 & 2) != 0 ? divSlider.getTooltips() : list8, (i2 & 4) != 0 ? divSlider.trackActiveStyle : divDrawable5, (i2 & 8) != 0 ? divSlider.trackInactiveStyle : divDrawable6, (i2 & 16) != 0 ? divSlider.getTransform() : divTransform, (i2 & 32) != 0 ? divSlider.getTransitionChange() : divChangeTransition, (i2 & 64) != 0 ? divSlider.getTransitionIn() : divAppearanceTransition, (i2 & 128) != 0 ? divSlider.getTransitionOut() : divAppearanceTransition2, (i2 & 256) != 0 ? divSlider.getTransitionTriggers() : list9, (i2 & 512) != 0 ? divSlider.getVariableTriggers() : list10, (i2 & 1024) != 0 ? divSlider.getVariables() : list11, (i2 & 2048) != 0 ? divSlider.getVisibility() : expression10, (i2 & 4096) != 0 ? divSlider.getVisibilityAction() : divVisibilityAction, (i2 & 8192) != 0 ? divSlider.getVisibilityActions() : list12, (i2 & 16384) != 0 ? divSlider.getWidth() : divSize2);
    }

    public final DivSlider copy(DivAccessibility accessibility, Expression<DivAlignmentHorizontal> alignmentHorizontal, Expression<DivAlignmentVertical> alignmentVertical, Expression<Double> alpha, List<? extends DivAnimator> animators, List<? extends DivBackground> background, DivBorder border, Expression<Long> columnSpan, List<DivDisappearAction> disappearActions, List<DivExtension> extensions, DivFocus focus, List<DivFunction> functions, DivSize height, String id, Expression<Boolean> isEnabled, DivLayoutProvider layoutProvider, DivEdgeInsets margins, Expression<Long> maxValue, Expression<Long> minValue, DivEdgeInsets paddings, List<Range> ranges, Expression<String> reuseId, Expression<Long> rowSpan, DivAccessibility secondaryValueAccessibility, List<DivAction> selectedActions, DivDrawable thumbSecondaryStyle, TextStyle thumbSecondaryTextStyle, String thumbSecondaryValueVariable, DivDrawable thumbStyle, TextStyle thumbTextStyle, String thumbValueVariable, DivDrawable tickMarkActiveStyle, DivDrawable tickMarkInactiveStyle, List<DivTooltip> tooltips, DivDrawable trackActiveStyle, DivDrawable trackInactiveStyle, DivTransform transform, DivChangeTransition transitionChange, DivAppearanceTransition transitionIn, DivAppearanceTransition transitionOut, List<? extends DivTransitionTrigger> transitionTriggers, List<DivTrigger> variableTriggers, List<? extends DivVariable> variables, Expression<DivVisibility> visibility, DivVisibilityAction visibilityAction, List<DivVisibilityAction> visibilityActions, DivSize width) {
        Intrinsics.checkNotNullParameter(alpha, "alpha");
        Intrinsics.checkNotNullParameter(height, "height");
        Intrinsics.checkNotNullParameter(isEnabled, "isEnabled");
        Intrinsics.checkNotNullParameter(maxValue, "maxValue");
        Intrinsics.checkNotNullParameter(minValue, "minValue");
        Intrinsics.checkNotNullParameter(thumbStyle, "thumbStyle");
        Intrinsics.checkNotNullParameter(trackActiveStyle, "trackActiveStyle");
        Intrinsics.checkNotNullParameter(trackInactiveStyle, "trackInactiveStyle");
        Intrinsics.checkNotNullParameter(visibility, "visibility");
        Intrinsics.checkNotNullParameter(width, "width");
        return new DivSlider(accessibility, alignmentHorizontal, alignmentVertical, alpha, animators, background, border, columnSpan, disappearActions, extensions, focus, functions, height, id, isEnabled, layoutProvider, margins, maxValue, minValue, paddings, ranges, reuseId, rowSpan, secondaryValueAccessibility, selectedActions, thumbSecondaryStyle, thumbSecondaryTextStyle, thumbSecondaryValueVariable, thumbStyle, thumbTextStyle, thumbValueVariable, tickMarkActiveStyle, tickMarkInactiveStyle, tooltips, trackActiveStyle, trackInactiveStyle, transform, transitionChange, transitionIn, transitionOut, transitionTriggers, variableTriggers, variables, visibility, visibilityAction, visibilityActions, width);
    }

    @Override // com.yandex.div.json.JSONSerializable
    public JSONObject writeToJSON() {
        return BuiltInParserKt.getBuiltInParserComponent().getDivSliderJsonEntityParser().getValue().serialize(BuiltInParserKt.getBuiltInParsingContext(), this);
    }

    /* JADX INFO: compiled from: DivSlider.kt */
    @Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0006\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u001e\u0010\u001a\u001a\u00020\n2\u0006\u0010\u001b\u001a\u00020\b2\u0006\u0010\u001c\u001a\u00020\tH\u0087\u0002¢\u0006\u0002\b\u001dR\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R#\u0010\u0006\u001a\u0014\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\n0\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u000e\u0010\r\u001a\u00020\u000eX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00100\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00120\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00120\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0015X\u0086T¢\u0006\u0002\n\u0000R\u0014\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00170\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0019X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001e"}, d2 = {"Lcom/yandex/div2/DivSlider$Companion;", "", "()V", "ALPHA_DEFAULT_VALUE", "Lcom/yandex/div/json/expressions/Expression;", "", "CREATOR", "Lkotlin/Function2;", "Lcom/yandex/div/json/ParsingEnvironment;", "Lorg/json/JSONObject;", "Lcom/yandex/div2/DivSlider;", "getCREATOR", "()Lkotlin/jvm/functions/Function2;", "HEIGHT_DEFAULT_VALUE", "Lcom/yandex/div2/DivSize$WrapContent;", "IS_ENABLED_DEFAULT_VALUE", "", "MAX_VALUE_DEFAULT_VALUE", "", "MIN_VALUE_DEFAULT_VALUE", "TYPE", "", "VISIBILITY_DEFAULT_VALUE", "Lcom/yandex/div2/DivVisibility;", "WIDTH_DEFAULT_VALUE", "Lcom/yandex/div2/DivSize$MatchParent;", "invoke", cc.o, "json", "fromJson", "div-data_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @JvmStatic
        public final DivSlider fromJson(ParsingEnvironment env, JSONObject json) {
            Intrinsics.checkNotNullParameter(env, "env");
            Intrinsics.checkNotNullParameter(json, "json");
            return BuiltInParserKt.getBuiltInParserComponent().getDivSliderJsonEntityParser().getValue().deserialize((ParsingContext) env, json);
        }

        public final Function2<ParsingEnvironment, JSONObject, DivSlider> getCREATOR() {
            return DivSlider.CREATOR;
        }
    }

    /* JADX INFO: compiled from: DivSlider.kt */
    @Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \u001c2\u00020\u00012\u00020\u0002:\u0001\u001cBc\b\u0007\u0012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004\u0012\u000e\b\u0002\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00070\u0004\u0012\u000e\b\u0002\u0010\b\u001a\b\u0012\u0004\u0012\u00020\t0\u0004\u0012\u0010\b\u0002\u0010\n\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\f\u0012\u000e\b\u0002\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000e0\u0004¢\u0006\u0002\u0010\u000fJd\u0010\u0012\u001a\u00020\u00002\u000e\b\u0002\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\u000e\b\u0002\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00070\u00042\u000e\b\u0002\u0010\b\u001a\b\u0012\u0004\u0012\u00020\t0\u00042\u0010\b\u0002\u0010\n\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u00042\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\f2\u000e\b\u0002\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000e0\u0004J \u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u00002\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u0017J\b\u0010\u0019\u001a\u00020\u000eH\u0016J\b\u0010\u001a\u001a\u00020\u001bH\u0016R\u0012\u0010\u0010\u001a\u0004\u0018\u00010\u000eX\u0082\u000e¢\u0006\u0004\n\u0002\u0010\u0011R\u0016\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u00048\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00070\u00048\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\b\u001a\b\u0012\u0004\u0012\u00020\t0\u00048\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0018\u0010\n\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0012\u0010\u000b\u001a\u0004\u0018\u00010\f8\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000e0\u00048\u0006X\u0087\u0004¢\u0006\u0002\n\u0000¨\u0006\u001d"}, d2 = {"Lcom/yandex/div2/DivSlider$TextStyle;", "Lcom/yandex/div/json/JSONSerializable;", "Lcom/yandex/div/data/Hashable;", "fontSize", "Lcom/yandex/div/json/expressions/Expression;", "", "fontSizeUnit", "Lcom/yandex/div2/DivSizeUnit;", "fontWeight", "Lcom/yandex/div2/DivFontWeight;", "fontWeightValue", "offset", "Lcom/yandex/div2/DivPoint;", "textColor", "", "(Lcom/yandex/div/json/expressions/Expression;Lcom/yandex/div/json/expressions/Expression;Lcom/yandex/div/json/expressions/Expression;Lcom/yandex/div/json/expressions/Expression;Lcom/yandex/div2/DivPoint;Lcom/yandex/div/json/expressions/Expression;)V", "_hash", "Ljava/lang/Integer;", "copy", "equals", "", "other", "resolver", "Lcom/yandex/div/json/expressions/ExpressionResolver;", "otherResolver", "hash", "writeToJSON", "Lorg/json/JSONObject;", "Companion", "div-data_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class TextStyle implements JSONSerializable, Hashable {
        private Integer _hash;
        public final Expression<Long> fontSize;
        public final Expression<DivSizeUnit> fontSizeUnit;
        public final Expression<DivFontWeight> fontWeight;
        public final Expression<Long> fontWeightValue;
        public final DivPoint offset;
        public final Expression<Integer> textColor;

        /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
        public static final Companion INSTANCE = new Companion(null);
        private static final Expression<DivSizeUnit> FONT_SIZE_UNIT_DEFAULT_VALUE = Expression.INSTANCE.constant(DivSizeUnit.SP);
        private static final Expression<DivFontWeight> FONT_WEIGHT_DEFAULT_VALUE = Expression.INSTANCE.constant(DivFontWeight.REGULAR);
        private static final Expression<Integer> TEXT_COLOR_DEFAULT_VALUE = Expression.INSTANCE.constant(Integer.valueOf(ViewCompat.MEASURED_STATE_MASK));
        private static final Function2<ParsingEnvironment, JSONObject, TextStyle> CREATOR = new Function2<ParsingEnvironment, JSONObject, TextStyle>() { // from class: com.yandex.div2.DivSlider$TextStyle$Companion$CREATOR$1
            @Override // kotlin.jvm.functions.Function2
            public final DivSlider.TextStyle invoke(ParsingEnvironment env, JSONObject it) {
                Intrinsics.checkNotNullParameter(env, "env");
                Intrinsics.checkNotNullParameter(it, "it");
                return DivSlider.TextStyle.INSTANCE.fromJson(env, it);
            }
        };

        @JvmStatic
        public static final TextStyle fromJson(ParsingEnvironment parsingEnvironment, JSONObject jSONObject) {
            return INSTANCE.fromJson(parsingEnvironment, jSONObject);
        }

        public TextStyle(Expression<Long> fontSize, Expression<DivSizeUnit> fontSizeUnit, Expression<DivFontWeight> fontWeight, Expression<Long> expression, DivPoint divPoint, Expression<Integer> textColor) {
            Intrinsics.checkNotNullParameter(fontSize, "fontSize");
            Intrinsics.checkNotNullParameter(fontSizeUnit, "fontSizeUnit");
            Intrinsics.checkNotNullParameter(fontWeight, "fontWeight");
            Intrinsics.checkNotNullParameter(textColor, "textColor");
            this.fontSize = fontSize;
            this.fontSizeUnit = fontSizeUnit;
            this.fontWeight = fontWeight;
            this.fontWeightValue = expression;
            this.offset = divPoint;
            this.textColor = textColor;
        }

        public /* synthetic */ TextStyle(Expression expression, Expression expression2, Expression expression3, Expression expression4, DivPoint divPoint, Expression expression5, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this(expression, (i & 2) != 0 ? FONT_SIZE_UNIT_DEFAULT_VALUE : expression2, (i & 4) != 0 ? FONT_WEIGHT_DEFAULT_VALUE : expression3, (i & 8) != 0 ? null : expression4, (i & 16) != 0 ? null : divPoint, (i & 32) != 0 ? TEXT_COLOR_DEFAULT_VALUE : expression5);
        }

        @Override // com.yandex.div.data.Hashable
        public int hash() {
            Integer num = this._hash;
            if (num != null) {
                return num.intValue();
            }
            int iHashCode = Reflection.getOrCreateKotlinClass(getClass()).hashCode() + this.fontSize.hashCode() + this.fontSizeUnit.hashCode() + this.fontWeight.hashCode();
            Expression<Long> expression = this.fontWeightValue;
            int iHashCode2 = iHashCode + (expression != null ? expression.hashCode() : 0);
            DivPoint divPoint = this.offset;
            int iHash = iHashCode2 + (divPoint != null ? divPoint.hash() : 0) + this.textColor.hashCode();
            this._hash = Integer.valueOf(iHash);
            return iHash;
        }

        public final boolean equals(TextStyle other, ExpressionResolver resolver, ExpressionResolver otherResolver) {
            boolean zEquals;
            Intrinsics.checkNotNullParameter(resolver, "resolver");
            Intrinsics.checkNotNullParameter(otherResolver, "otherResolver");
            if (other == null || this.fontSize.evaluate(resolver).longValue() != other.fontSize.evaluate(otherResolver).longValue() || this.fontSizeUnit.evaluate(resolver) != other.fontSizeUnit.evaluate(otherResolver) || this.fontWeight.evaluate(resolver) != other.fontWeight.evaluate(otherResolver)) {
                return false;
            }
            Expression<Long> expression = this.fontWeightValue;
            Long lEvaluate = expression != null ? expression.evaluate(resolver) : null;
            Expression<Long> expression2 = other.fontWeightValue;
            if (!Intrinsics.areEqual(lEvaluate, expression2 != null ? expression2.evaluate(otherResolver) : null)) {
                return false;
            }
            DivPoint divPoint = this.offset;
            if (divPoint != null) {
                zEquals = divPoint.equals(other.offset, resolver, otherResolver);
            } else {
                zEquals = other.offset == null;
            }
            return zEquals && this.textColor.evaluate(resolver).intValue() == other.textColor.evaluate(otherResolver).intValue();
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ TextStyle copy$default(TextStyle textStyle, Expression expression, Expression expression2, Expression expression3, Expression expression4, DivPoint divPoint, Expression expression5, int i, Object obj) {
            if ((i & 1) != 0) {
                expression = textStyle.fontSize;
            }
            if ((i & 2) != 0) {
                expression2 = textStyle.fontSizeUnit;
            }
            Expression expression6 = expression2;
            if ((i & 4) != 0) {
                expression3 = textStyle.fontWeight;
            }
            Expression expression7 = expression3;
            if ((i & 8) != 0) {
                expression4 = textStyle.fontWeightValue;
            }
            Expression expression8 = expression4;
            if ((i & 16) != 0) {
                divPoint = textStyle.offset;
            }
            DivPoint divPoint2 = divPoint;
            if ((i & 32) != 0) {
                expression5 = textStyle.textColor;
            }
            return textStyle.copy(expression, expression6, expression7, expression8, divPoint2, expression5);
        }

        public final TextStyle copy(Expression<Long> fontSize, Expression<DivSizeUnit> fontSizeUnit, Expression<DivFontWeight> fontWeight, Expression<Long> fontWeightValue, DivPoint offset, Expression<Integer> textColor) {
            Intrinsics.checkNotNullParameter(fontSize, "fontSize");
            Intrinsics.checkNotNullParameter(fontSizeUnit, "fontSizeUnit");
            Intrinsics.checkNotNullParameter(fontWeight, "fontWeight");
            Intrinsics.checkNotNullParameter(textColor, "textColor");
            return new TextStyle(fontSize, fontSizeUnit, fontWeight, fontWeightValue, offset, textColor);
        }

        @Override // com.yandex.div.json.JSONSerializable
        public JSONObject writeToJSON() {
            return BuiltInParserKt.getBuiltInParserComponent().getDivSliderTextStyleJsonEntityParser().getValue().serialize(BuiltInParserKt.getBuiltInParsingContext(), this);
        }

        /* JADX INFO: compiled from: DivSlider.kt */
        @Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u001e\u0010\u0011\u001a\u00020\u00072\u0006\u0010\u0012\u001a\u00020\u00052\u0006\u0010\u0013\u001a\u00020\u0006H\u0087\u0002¢\u0006\u0002\b\u0014R#\u0010\u0003\u001a\u0014\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0014\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000e0\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00100\u000bX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0015"}, d2 = {"Lcom/yandex/div2/DivSlider$TextStyle$Companion;", "", "()V", "CREATOR", "Lkotlin/Function2;", "Lcom/yandex/div/json/ParsingEnvironment;", "Lorg/json/JSONObject;", "Lcom/yandex/div2/DivSlider$TextStyle;", "getCREATOR", "()Lkotlin/jvm/functions/Function2;", "FONT_SIZE_UNIT_DEFAULT_VALUE", "Lcom/yandex/div/json/expressions/Expression;", "Lcom/yandex/div2/DivSizeUnit;", "FONT_WEIGHT_DEFAULT_VALUE", "Lcom/yandex/div2/DivFontWeight;", "TEXT_COLOR_DEFAULT_VALUE", "", "invoke", cc.o, "json", "fromJson", "div-data_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private Companion() {
            }

            @JvmStatic
            public final TextStyle fromJson(ParsingEnvironment env, JSONObject json) {
                Intrinsics.checkNotNullParameter(env, "env");
                Intrinsics.checkNotNullParameter(json, "json");
                return BuiltInParserKt.getBuiltInParserComponent().getDivSliderTextStyleJsonEntityParser().getValue().deserialize((ParsingContext) env, json);
            }

            public final Function2<ParsingEnvironment, JSONObject, TextStyle> getCREATOR() {
                return TextStyle.CREATOR;
            }
        }
    }

    /* JADX INFO: compiled from: DivSlider.kt */
    @Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \u001a2\u00020\u00012\u00020\u0002:\u0001\u001aBO\b\u0007\u0012\u0010\b\u0002\u0010\u0003\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\u0010\b\u0002\u0010\b\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0004\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\n¢\u0006\u0002\u0010\fJN\u0010\u0010\u001a\u00020\u00002\u0010\b\u0002\u0010\u0003\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u00042\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\u0010\b\u0002\u0010\b\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u00042\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\nJ \u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u00002\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0015J\b\u0010\u0017\u001a\u00020\u000eH\u0016J\b\u0010\u0018\u001a\u00020\u0019H\u0016R\u0012\u0010\r\u001a\u0004\u0018\u00010\u000eX\u0082\u000e¢\u0006\u0004\n\u0002\u0010\u000fR\u0018\u0010\u0003\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0012\u0010\u0006\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0018\u0010\b\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0012\u0010\t\u001a\u0004\u0018\u00010\n8\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0012\u0010\u000b\u001a\u0004\u0018\u00010\n8\u0006X\u0087\u0004¢\u0006\u0002\n\u0000¨\u0006\u001b"}, d2 = {"Lcom/yandex/div2/DivSlider$Range;", "Lcom/yandex/div/json/JSONSerializable;", "Lcom/yandex/div/data/Hashable;", "end", "Lcom/yandex/div/json/expressions/Expression;", "", "margins", "Lcom/yandex/div2/DivEdgeInsets;", "start", "trackActiveStyle", "Lcom/yandex/div2/DivDrawable;", "trackInactiveStyle", "(Lcom/yandex/div/json/expressions/Expression;Lcom/yandex/div2/DivEdgeInsets;Lcom/yandex/div/json/expressions/Expression;Lcom/yandex/div2/DivDrawable;Lcom/yandex/div2/DivDrawable;)V", "_hash", "", "Ljava/lang/Integer;", "copy", "equals", "", "other", "resolver", "Lcom/yandex/div/json/expressions/ExpressionResolver;", "otherResolver", "hash", "writeToJSON", "Lorg/json/JSONObject;", "Companion", "div-data_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class Range implements JSONSerializable, Hashable {
        private Integer _hash;
        public final Expression<Long> end;
        public final DivEdgeInsets margins;
        public final Expression<Long> start;
        public final DivDrawable trackActiveStyle;
        public final DivDrawable trackInactiveStyle;

        /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
        public static final Companion INSTANCE = new Companion(null);
        private static final Function2<ParsingEnvironment, JSONObject, Range> CREATOR = new Function2<ParsingEnvironment, JSONObject, Range>() { // from class: com.yandex.div2.DivSlider$Range$Companion$CREATOR$1
            @Override // kotlin.jvm.functions.Function2
            public final DivSlider.Range invoke(ParsingEnvironment env, JSONObject it) {
                Intrinsics.checkNotNullParameter(env, "env");
                Intrinsics.checkNotNullParameter(it, "it");
                return DivSlider.Range.INSTANCE.fromJson(env, it);
            }
        };

        public Range() {
            this(null, null, null, null, null, 31, null);
        }

        @JvmStatic
        public static final Range fromJson(ParsingEnvironment parsingEnvironment, JSONObject jSONObject) {
            return INSTANCE.fromJson(parsingEnvironment, jSONObject);
        }

        public Range(Expression<Long> expression, DivEdgeInsets divEdgeInsets, Expression<Long> expression2, DivDrawable divDrawable, DivDrawable divDrawable2) {
            this.end = expression;
            this.margins = divEdgeInsets;
            this.start = expression2;
            this.trackActiveStyle = divDrawable;
            this.trackInactiveStyle = divDrawable2;
        }

        public /* synthetic */ Range(Expression expression, DivEdgeInsets divEdgeInsets, Expression expression2, DivDrawable divDrawable, DivDrawable divDrawable2, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this((i & 1) != 0 ? null : expression, (i & 2) != 0 ? null : divEdgeInsets, (i & 4) != 0 ? null : expression2, (i & 8) != 0 ? null : divDrawable, (i & 16) != 0 ? null : divDrawable2);
        }

        @Override // com.yandex.div.data.Hashable
        public int hash() {
            Integer num = this._hash;
            if (num != null) {
                return num.intValue();
            }
            int iHashCode = Reflection.getOrCreateKotlinClass(getClass()).hashCode();
            Expression<Long> expression = this.end;
            int iHashCode2 = iHashCode + (expression != null ? expression.hashCode() : 0);
            DivEdgeInsets divEdgeInsets = this.margins;
            int iHash = iHashCode2 + (divEdgeInsets != null ? divEdgeInsets.hash() : 0);
            Expression<Long> expression2 = this.start;
            int iHashCode3 = iHash + (expression2 != null ? expression2.hashCode() : 0);
            DivDrawable divDrawable = this.trackActiveStyle;
            int iHash2 = iHashCode3 + (divDrawable != null ? divDrawable.hash() : 0);
            DivDrawable divDrawable2 = this.trackInactiveStyle;
            int iHash3 = iHash2 + (divDrawable2 != null ? divDrawable2.hash() : 0);
            this._hash = Integer.valueOf(iHash3);
            return iHash3;
        }

        public final boolean equals(Range other, ExpressionResolver resolver, ExpressionResolver otherResolver) {
            boolean zEquals;
            boolean zEquals2;
            boolean zEquals3;
            Intrinsics.checkNotNullParameter(resolver, "resolver");
            Intrinsics.checkNotNullParameter(otherResolver, "otherResolver");
            if (other == null) {
                return false;
            }
            Expression<Long> expression = this.end;
            Long lEvaluate = expression != null ? expression.evaluate(resolver) : null;
            Expression<Long> expression2 = other.end;
            if (!Intrinsics.areEqual(lEvaluate, expression2 != null ? expression2.evaluate(otherResolver) : null)) {
                return false;
            }
            DivEdgeInsets divEdgeInsets = this.margins;
            if (divEdgeInsets != null) {
                zEquals = divEdgeInsets.equals(other.margins, resolver, otherResolver);
            } else {
                zEquals = other.margins == null;
            }
            if (!zEquals) {
                return false;
            }
            Expression<Long> expression3 = this.start;
            Long lEvaluate2 = expression3 != null ? expression3.evaluate(resolver) : null;
            Expression<Long> expression4 = other.start;
            if (!Intrinsics.areEqual(lEvaluate2, expression4 != null ? expression4.evaluate(otherResolver) : null)) {
                return false;
            }
            DivDrawable divDrawable = this.trackActiveStyle;
            if (divDrawable != null) {
                zEquals2 = divDrawable.equals(other.trackActiveStyle, resolver, otherResolver);
            } else {
                zEquals2 = other.trackActiveStyle == null;
            }
            if (!zEquals2) {
                return false;
            }
            DivDrawable divDrawable2 = this.trackInactiveStyle;
            DivDrawable divDrawable3 = other.trackInactiveStyle;
            if (divDrawable2 != null) {
                zEquals3 = divDrawable2.equals(divDrawable3, resolver, otherResolver);
            } else {
                zEquals3 = divDrawable3 == null;
            }
            return zEquals3;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ Range copy$default(Range range, Expression expression, DivEdgeInsets divEdgeInsets, Expression expression2, DivDrawable divDrawable, DivDrawable divDrawable2, int i, Object obj) {
            if ((i & 1) != 0) {
                expression = range.end;
            }
            if ((i & 2) != 0) {
                divEdgeInsets = range.margins;
            }
            DivEdgeInsets divEdgeInsets2 = divEdgeInsets;
            if ((i & 4) != 0) {
                expression2 = range.start;
            }
            Expression expression3 = expression2;
            if ((i & 8) != 0) {
                divDrawable = range.trackActiveStyle;
            }
            DivDrawable divDrawable3 = divDrawable;
            if ((i & 16) != 0) {
                divDrawable2 = range.trackInactiveStyle;
            }
            return range.copy(expression, divEdgeInsets2, expression3, divDrawable3, divDrawable2);
        }

        public final Range copy(Expression<Long> end, DivEdgeInsets margins, Expression<Long> start, DivDrawable trackActiveStyle, DivDrawable trackInactiveStyle) {
            return new Range(end, margins, start, trackActiveStyle, trackInactiveStyle);
        }

        @Override // com.yandex.div.json.JSONSerializable
        public JSONObject writeToJSON() {
            return BuiltInParserKt.getBuiltInParserComponent().getDivSliderRangeJsonEntityParser().getValue().serialize(BuiltInParserKt.getBuiltInParsingContext(), this);
        }

        /* JADX INFO: compiled from: DivSlider.kt */
        @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u001e\u0010\n\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\u00052\u0006\u0010\f\u001a\u00020\u0006H\u0087\u0002¢\u0006\u0002\b\rR#\u0010\u0003\u001a\u0014\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\t¨\u0006\u000e"}, d2 = {"Lcom/yandex/div2/DivSlider$Range$Companion;", "", "()V", "CREATOR", "Lkotlin/Function2;", "Lcom/yandex/div/json/ParsingEnvironment;", "Lorg/json/JSONObject;", "Lcom/yandex/div2/DivSlider$Range;", "getCREATOR", "()Lkotlin/jvm/functions/Function2;", "invoke", cc.o, "json", "fromJson", "div-data_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private Companion() {
            }

            @JvmStatic
            public final Range fromJson(ParsingEnvironment env, JSONObject json) {
                Intrinsics.checkNotNullParameter(env, "env");
                Intrinsics.checkNotNullParameter(json, "json");
                return BuiltInParserKt.getBuiltInParserComponent().getDivSliderRangeJsonEntityParser().getValue().deserialize((ParsingContext) env, json);
            }

            public final Function2<ParsingEnvironment, JSONObject, Range> getCREATOR() {
                return Range.CREATOR;
            }
        }
    }
}
