package com.yandex.div2;

import androidx.autofill.HintConstants;
import androidx.compose.material.OutlinedTextFieldKt;
import androidx.core.view.ViewCompat;
import com.facebook.appevents.internal.ViewHierarchyConstants;
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
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import org.json.JSONObject;

/* JADX INFO: compiled from: DivInput.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\u0098\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0006\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b6\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 \u009f\u00012\u00020\u00012\u00020\u00022\u00020\u0003:\n\u009e\u0001\u009f\u0001 \u0001¡\u0001¢\u0001B\u008f\u0007\b\u0007\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\u0010\b\u0002\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007\u0012\u0010\b\u0002\u0010\t\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\u0007\u0012\u000e\b\u0002\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\f0\u0007\u0012\u0010\b\u0002\u0010\r\u001a\n\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u000e\u0012\u000e\b\u0002\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00110\u0007\u0012\u0010\b\u0002\u0010\u0012\u001a\n\u0012\u0004\u0012\u00020\u0013\u0018\u00010\u000e\u0012\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u0015\u0012\u0010\b\u0002\u0010\u0016\u001a\n\u0012\u0004\u0012\u00020\u0017\u0018\u00010\u0007\u0012\u0010\b\u0002\u0010\u0018\u001a\n\u0012\u0004\u0012\u00020\u0019\u0018\u00010\u000e\u0012\u0010\b\u0002\u0010\u001a\u001a\n\u0012\u0004\u0012\u00020\u001b\u0018\u00010\u000e\u0012\u000e\b\u0002\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u001d0\u0007\u0012\u0010\b\u0002\u0010\u001e\u001a\n\u0012\u0004\u0012\u00020\u001f\u0018\u00010\u000e\u0012\u0010\b\u0002\u0010 \u001a\n\u0012\u0004\u0012\u00020!\u0018\u00010\u000e\u0012\n\b\u0002\u0010\"\u001a\u0004\u0018\u00010#\u0012\u0010\b\u0002\u0010$\u001a\n\u0012\u0004\u0012\u00020%\u0018\u00010\u0007\u0012\u000e\b\u0002\u0010&\u001a\b\u0012\u0004\u0012\u00020\u00170\u0007\u0012\u000e\b\u0002\u0010'\u001a\b\u0012\u0004\u0012\u00020(0\u0007\u0012\u000e\b\u0002\u0010)\u001a\b\u0012\u0004\u0012\u00020*0\u0007\u0012\u0010\b\u0002\u0010+\u001a\n\u0012\u0004\u0012\u00020\u0017\u0018\u00010\u0007\u0012\u0010\b\u0002\u0010,\u001a\n\u0012\u0004\u0012\u00020-\u0018\u00010\u000e\u0012\b\b\u0002\u0010.\u001a\u00020/\u0012\u0010\b\u0002\u00100\u001a\n\u0012\u0004\u0012\u000201\u0018\u00010\u0007\u0012\u000e\b\u0002\u00102\u001a\b\u0012\u0004\u0012\u0002010\u0007\u0012\u0010\b\u0002\u00103\u001a\n\u0012\u0004\u0012\u00020%\u0018\u00010\u0007\u0012\n\b\u0002\u00104\u001a\u0004\u0018\u00010%\u0012\u000e\b\u0002\u00105\u001a\b\u0012\u0004\u0012\u0002060\u0007\u0012\u000e\b\u0002\u00107\u001a\b\u0012\u0004\u0012\u0002080\u0007\u0012\n\b\u0002\u00109\u001a\u0004\u0018\u00010:\u0012\u000e\b\u0002\u0010;\u001a\b\u0012\u0004\u0012\u00020\f0\u0007\u0012\u0010\b\u0002\u0010<\u001a\n\u0012\u0004\u0012\u00020\u0017\u0018\u00010\u0007\u0012\n\b\u0002\u0010=\u001a\u0004\u0018\u00010>\u0012\n\b\u0002\u0010?\u001a\u0004\u0018\u00010@\u0012\u0010\b\u0002\u0010A\u001a\n\u0012\u0004\u0012\u00020\u0017\u0018\u00010\u0007\u0012\u0010\b\u0002\u0010B\u001a\n\u0012\u0004\u0012\u00020\u0017\u0018\u00010\u0007\u0012\n\b\u0002\u0010C\u001a\u0004\u0018\u00010D\u0012\n\b\u0002\u0010E\u001a\u0004\u0018\u00010>\u0012\u0010\b\u0002\u0010F\u001a\n\u0012\u0004\u0012\u00020%\u0018\u00010\u0007\u0012\u0010\b\u0002\u0010G\u001a\n\u0012\u0004\u0012\u00020\u0017\u0018\u00010\u0007\u0012\u000e\b\u0002\u0010H\u001a\b\u0012\u0004\u0012\u0002060\u0007\u0012\u0010\b\u0002\u0010I\u001a\n\u0012\u0004\u0012\u00020\u001b\u0018\u00010\u000e\u0012\u000e\b\u0002\u0010J\u001a\b\u0012\u0004\u0012\u00020\b0\u0007\u0012\u000e\b\u0002\u0010K\u001a\b\u0012\u0004\u0012\u00020\n0\u0007\u0012\u000e\b\u0002\u0010L\u001a\b\u0012\u0004\u0012\u0002010\u0007\u0012\u0006\u0010M\u001a\u00020%\u0012\u0010\b\u0002\u0010N\u001a\n\u0012\u0004\u0012\u00020O\u0018\u00010\u000e\u0012\n\b\u0002\u0010P\u001a\u0004\u0018\u00010Q\u0012\n\b\u0002\u0010R\u001a\u0004\u0018\u00010S\u0012\n\b\u0002\u0010T\u001a\u0004\u0018\u00010U\u0012\n\b\u0002\u0010V\u001a\u0004\u0018\u00010U\u0012\u0010\b\u0002\u0010W\u001a\n\u0012\u0004\u0012\u00020X\u0018\u00010\u000e\u0012\u0010\b\u0002\u0010Y\u001a\n\u0012\u0004\u0012\u00020Z\u0018\u00010\u000e\u0012\u0010\b\u0002\u0010[\u001a\n\u0012\u0004\u0012\u00020\\\u0018\u00010\u000e\u0012\u0010\b\u0002\u0010]\u001a\n\u0012\u0004\u0012\u00020^\u0018\u00010\u000e\u0012\u000e\b\u0002\u0010_\u001a\b\u0012\u0004\u0012\u00020`0\u0007\u0012\n\b\u0002\u0010a\u001a\u0004\u0018\u00010b\u0012\u0010\b\u0002\u0010c\u001a\n\u0012\u0004\u0012\u00020b\u0018\u00010\u000e\u0012\b\b\u0002\u0010d\u001a\u00020/¢\u0006\u0002\u0010eJ\u0091\u0007\u0010\u0095\u0001\u001a\u00020\u00002\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0010\b\u0002\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u00072\u0010\b\u0002\u0010\t\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\u00072\u000e\b\u0002\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\f0\u00072\u0010\b\u0002\u0010\r\u001a\n\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u000e2\u000e\b\u0002\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00110\u00072\u0010\b\u0002\u0010\u0012\u001a\n\u0012\u0004\u0012\u00020\u0013\u0018\u00010\u000e2\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u00152\u0010\b\u0002\u0010\u0016\u001a\n\u0012\u0004\u0012\u00020\u0017\u0018\u00010\u00072\u0010\b\u0002\u0010\u0018\u001a\n\u0012\u0004\u0012\u00020\u0019\u0018\u00010\u000e2\u0010\b\u0002\u0010\u001a\u001a\n\u0012\u0004\u0012\u00020\u001b\u0018\u00010\u000e2\u000e\b\u0002\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u001d0\u00072\u0010\b\u0002\u0010\u001e\u001a\n\u0012\u0004\u0012\u00020\u001f\u0018\u00010\u000e2\u0010\b\u0002\u0010 \u001a\n\u0012\u0004\u0012\u00020!\u0018\u00010\u000e2\n\b\u0002\u0010\"\u001a\u0004\u0018\u00010#2\u0010\b\u0002\u0010$\u001a\n\u0012\u0004\u0012\u00020%\u0018\u00010\u00072\u000e\b\u0002\u0010&\u001a\b\u0012\u0004\u0012\u00020\u00170\u00072\u000e\b\u0002\u0010'\u001a\b\u0012\u0004\u0012\u00020(0\u00072\u000e\b\u0002\u0010)\u001a\b\u0012\u0004\u0012\u00020*0\u00072\u0010\b\u0002\u0010+\u001a\n\u0012\u0004\u0012\u00020\u0017\u0018\u00010\u00072\u0010\b\u0002\u0010,\u001a\n\u0012\u0004\u0012\u00020-\u0018\u00010\u000e2\b\b\u0002\u0010.\u001a\u00020/2\u0010\b\u0002\u00100\u001a\n\u0012\u0004\u0012\u000201\u0018\u00010\u00072\u000e\b\u0002\u00102\u001a\b\u0012\u0004\u0012\u0002010\u00072\u0010\b\u0002\u00103\u001a\n\u0012\u0004\u0012\u00020%\u0018\u00010\u00072\n\b\u0002\u00104\u001a\u0004\u0018\u00010%2\u000e\b\u0002\u00105\u001a\b\u0012\u0004\u0012\u0002060\u00072\u000e\b\u0002\u00107\u001a\b\u0012\u0004\u0012\u0002080\u00072\n\b\u0002\u00109\u001a\u0004\u0018\u00010:2\u000e\b\u0002\u0010;\u001a\b\u0012\u0004\u0012\u00020\f0\u00072\u0010\b\u0002\u0010<\u001a\n\u0012\u0004\u0012\u00020\u0017\u0018\u00010\u00072\n\b\u0002\u0010=\u001a\u0004\u0018\u00010>2\n\b\u0002\u0010?\u001a\u0004\u0018\u00010@2\u0010\b\u0002\u0010A\u001a\n\u0012\u0004\u0012\u00020\u0017\u0018\u00010\u00072\u0010\b\u0002\u0010B\u001a\n\u0012\u0004\u0012\u00020\u0017\u0018\u00010\u00072\n\b\u0002\u0010C\u001a\u0004\u0018\u00010D2\n\b\u0002\u0010E\u001a\u0004\u0018\u00010>2\u0010\b\u0002\u0010F\u001a\n\u0012\u0004\u0012\u00020%\u0018\u00010\u00072\u0010\b\u0002\u0010G\u001a\n\u0012\u0004\u0012\u00020\u0017\u0018\u00010\u00072\u000e\b\u0002\u0010H\u001a\b\u0012\u0004\u0012\u0002060\u00072\u0010\b\u0002\u0010I\u001a\n\u0012\u0004\u0012\u00020\u001b\u0018\u00010\u000e2\u000e\b\u0002\u0010J\u001a\b\u0012\u0004\u0012\u00020\b0\u00072\u000e\b\u0002\u0010K\u001a\b\u0012\u0004\u0012\u00020\n0\u00072\u000e\b\u0002\u0010L\u001a\b\u0012\u0004\u0012\u0002010\u00072\b\b\u0002\u0010M\u001a\u00020%2\u0010\b\u0002\u0010N\u001a\n\u0012\u0004\u0012\u00020O\u0018\u00010\u000e2\n\b\u0002\u0010P\u001a\u0004\u0018\u00010Q2\n\b\u0002\u0010R\u001a\u0004\u0018\u00010S2\n\b\u0002\u0010T\u001a\u0004\u0018\u00010U2\n\b\u0002\u0010V\u001a\u0004\u0018\u00010U2\u0010\b\u0002\u0010W\u001a\n\u0012\u0004\u0012\u00020X\u0018\u00010\u000e2\u0010\b\u0002\u0010Y\u001a\n\u0012\u0004\u0012\u00020Z\u0018\u00010\u000e2\u0010\b\u0002\u0010[\u001a\n\u0012\u0004\u0012\u00020\\\u0018\u00010\u000e2\u0010\b\u0002\u0010]\u001a\n\u0012\u0004\u0012\u00020^\u0018\u00010\u000e2\u000e\b\u0002\u0010_\u001a\b\u0012\u0004\u0012\u00020`0\u00072\n\b\u0002\u0010a\u001a\u0004\u0018\u00010b2\u0010\b\u0002\u0010c\u001a\n\u0012\u0004\u0012\u00020b\u0018\u00010\u000e2\b\b\u0002\u0010d\u001a\u00020/J&\u0010\u0096\u0001\u001a\u0002062\t\u0010\u0097\u0001\u001a\u0004\u0018\u00010\u00002\b\u0010\u0098\u0001\u001a\u00030\u0099\u00012\b\u0010\u009a\u0001\u001a\u00030\u0099\u0001J\t\u0010\u009b\u0001\u001a\u000201H\u0016J\n\u0010\u009c\u0001\u001a\u00030\u009d\u0001H\u0016R\u0012\u0010f\u001a\u0004\u0018\u000101X\u0082\u000e¢\u0006\u0004\n\u0002\u0010gR\u0016\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\bh\u0010iR\u001c\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\bj\u0010kR\u001c\u0010\t\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\u0007X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\bl\u0010kR\u001a\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\f0\u0007X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\bm\u0010kR\u001c\u0010\r\u001a\n\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u000eX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\bn\u0010oR\u0016\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00110\u00078\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\u0012\u001a\n\u0012\u0004\u0012\u00020\u0013\u0018\u00010\u000eX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\bp\u0010oR\u0016\u0010\u0014\u001a\u0004\u0018\u00010\u0015X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\bq\u0010rR\u001c\u0010\u0016\u001a\n\u0012\u0004\u0012\u00020\u0017\u0018\u00010\u0007X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\bs\u0010kR\u001c\u0010\u0018\u001a\n\u0012\u0004\u0012\u00020\u0019\u0018\u00010\u000eX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\bt\u0010oR\u0018\u0010\u001a\u001a\n\u0012\u0004\u0012\u00020\u001b\u0018\u00010\u000e8\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u001d0\u00078\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\u001e\u001a\n\u0012\u0004\u0012\u00020\u001f\u0018\u00010\u000eX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\bu\u0010oR\u0018\u0010 \u001a\n\u0012\u0004\u0012\u00020!\u0018\u00010\u000e8\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\"\u001a\u0004\u0018\u00010#X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\bv\u0010wR\u0018\u0010$\u001a\n\u0012\u0004\u0012\u00020%\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0016\u0010&\u001a\b\u0012\u0004\u0012\u00020\u00170\u00078\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0016\u0010'\u001a\b\u0012\u0004\u0012\u00020(0\u00078\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0016\u0010)\u001a\b\u0012\u0004\u0012\u00020*0\u00078\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0018\u0010+\u001a\n\u0012\u0004\u0012\u00020\u0017\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u001c\u0010,\u001a\n\u0012\u0004\u0012\u00020-\u0018\u00010\u000eX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\bx\u0010oR\u0014\u0010.\u001a\u00020/X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\by\u0010zR\u0018\u00100\u001a\n\u0012\u0004\u0012\u000201\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0016\u00102\u001a\b\u0012\u0004\u0012\u0002010\u00078\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0018\u00103\u001a\n\u0012\u0004\u0012\u00020%\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0016\u00104\u001a\u0004\u0018\u00010%X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b{\u0010|R\u0016\u00105\u001a\b\u0012\u0004\u0012\u0002060\u00078\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0016\u00107\u001a\b\u0012\u0004\u0012\u0002080\u00078\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0016\u00109\u001a\u0004\u0018\u00010:X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b}\u0010~R\u0016\u0010;\u001a\b\u0012\u0004\u0012\u00020\f0\u00078\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0018\u0010<\u001a\n\u0012\u0004\u0012\u00020\u0017\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0017\u0010=\u001a\u0004\u0018\u00010>X\u0096\u0004¢\u0006\t\n\u0000\u001a\u0005\b\u007f\u0010\u0080\u0001R\u0012\u0010?\u001a\u0004\u0018\u00010@8\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0018\u0010A\u001a\n\u0012\u0004\u0012\u00020\u0017\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0018\u0010B\u001a\n\u0012\u0004\u0012\u00020\u0017\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0012\u0010C\u001a\u0004\u0018\u00010D8\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0018\u0010E\u001a\u0004\u0018\u00010>X\u0096\u0004¢\u0006\n\n\u0000\u001a\u0006\b\u0081\u0001\u0010\u0080\u0001R\u001d\u0010F\u001a\n\u0012\u0004\u0012\u00020%\u0018\u00010\u0007X\u0096\u0004¢\u0006\t\n\u0000\u001a\u0005\b\u0082\u0001\u0010kR\u001d\u0010G\u001a\n\u0012\u0004\u0012\u00020\u0017\u0018\u00010\u0007X\u0096\u0004¢\u0006\t\n\u0000\u001a\u0005\b\u0083\u0001\u0010kR\u0016\u0010H\u001a\b\u0012\u0004\u0012\u0002060\u00078\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u001d\u0010I\u001a\n\u0012\u0004\u0012\u00020\u001b\u0018\u00010\u000eX\u0096\u0004¢\u0006\t\n\u0000\u001a\u0005\b\u0084\u0001\u0010oR\u0016\u0010J\u001a\b\u0012\u0004\u0012\u00020\b0\u00078\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0016\u0010K\u001a\b\u0012\u0004\u0012\u00020\n0\u00078\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0016\u0010L\u001a\b\u0012\u0004\u0012\u0002010\u00078\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0010\u0010M\u001a\u00020%8\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u001d\u0010N\u001a\n\u0012\u0004\u0012\u00020O\u0018\u00010\u000eX\u0096\u0004¢\u0006\t\n\u0000\u001a\u0005\b\u0085\u0001\u0010oR\u0018\u0010P\u001a\u0004\u0018\u00010QX\u0096\u0004¢\u0006\n\n\u0000\u001a\u0006\b\u0086\u0001\u0010\u0087\u0001R\u0018\u0010R\u001a\u0004\u0018\u00010SX\u0096\u0004¢\u0006\n\n\u0000\u001a\u0006\b\u0088\u0001\u0010\u0089\u0001R\u0018\u0010T\u001a\u0004\u0018\u00010UX\u0096\u0004¢\u0006\n\n\u0000\u001a\u0006\b\u008a\u0001\u0010\u008b\u0001R\u0018\u0010V\u001a\u0004\u0018\u00010UX\u0096\u0004¢\u0006\n\n\u0000\u001a\u0006\b\u008c\u0001\u0010\u008b\u0001R\u001d\u0010W\u001a\n\u0012\u0004\u0012\u00020X\u0018\u00010\u000eX\u0096\u0004¢\u0006\t\n\u0000\u001a\u0005\b\u008d\u0001\u0010oR\u0018\u0010Y\u001a\n\u0012\u0004\u0012\u00020Z\u0018\u00010\u000e8\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u001d\u0010[\u001a\n\u0012\u0004\u0012\u00020\\\u0018\u00010\u000eX\u0096\u0004¢\u0006\t\n\u0000\u001a\u0005\b\u008e\u0001\u0010oR\u001d\u0010]\u001a\n\u0012\u0004\u0012\u00020^\u0018\u00010\u000eX\u0096\u0004¢\u0006\t\n\u0000\u001a\u0005\b\u008f\u0001\u0010oR\u001b\u0010_\u001a\b\u0012\u0004\u0012\u00020`0\u0007X\u0096\u0004¢\u0006\t\n\u0000\u001a\u0005\b\u0090\u0001\u0010kR\u0018\u0010a\u001a\u0004\u0018\u00010bX\u0096\u0004¢\u0006\n\n\u0000\u001a\u0006\b\u0091\u0001\u0010\u0092\u0001R\u001d\u0010c\u001a\n\u0012\u0004\u0012\u00020b\u0018\u00010\u000eX\u0096\u0004¢\u0006\t\n\u0000\u001a\u0005\b\u0093\u0001\u0010oR\u0015\u0010d\u001a\u00020/X\u0096\u0004¢\u0006\t\n\u0000\u001a\u0005\b\u0094\u0001\u0010z¨\u0006£\u0001"}, d2 = {"Lcom/yandex/div2/DivInput;", "Lcom/yandex/div/json/JSONSerializable;", "Lcom/yandex/div/data/Hashable;", "Lcom/yandex/div2/DivBase;", "accessibility", "Lcom/yandex/div2/DivAccessibility;", "alignmentHorizontal", "Lcom/yandex/div/json/expressions/Expression;", "Lcom/yandex/div2/DivAlignmentHorizontal;", "alignmentVertical", "Lcom/yandex/div2/DivAlignmentVertical;", "alpha", "", "animators", "", "Lcom/yandex/div2/DivAnimator;", "autocapitalization", "Lcom/yandex/div2/DivInput$Autocapitalization;", J2.g, "Lcom/yandex/div2/DivBackground;", OutlinedTextFieldKt.BorderId, "Lcom/yandex/div2/DivBorder;", "columnSpan", "", "disappearActions", "Lcom/yandex/div2/DivDisappearAction;", "enterKeyActions", "Lcom/yandex/div2/DivAction;", "enterKeyType", "Lcom/yandex/div2/DivInput$EnterKeyType;", "extensions", "Lcom/yandex/div2/DivExtension;", "filters", "Lcom/yandex/div2/DivInputFilter;", "focus", "Lcom/yandex/div2/DivFocus;", "fontFamily", "", "fontSize", "fontSizeUnit", "Lcom/yandex/div2/DivSizeUnit;", "fontWeight", "Lcom/yandex/div2/DivFontWeight;", "fontWeightValue", "functions", "Lcom/yandex/div2/DivFunction;", "height", "Lcom/yandex/div2/DivSize;", "highlightColor", "", "hintColor", "hintText", "id", "isEnabled", "", "keyboardType", "Lcom/yandex/div2/DivInput$KeyboardType;", "layoutProvider", "Lcom/yandex/div2/DivLayoutProvider;", "letterSpacing", "lineHeight", "margins", "Lcom/yandex/div2/DivEdgeInsets;", "mask", "Lcom/yandex/div2/DivInputMask;", "maxLength", "maxVisibleLines", "nativeInterface", "Lcom/yandex/div2/DivInput$NativeInterface;", "paddings", "reuseId", "rowSpan", "selectAllOnFocus", "selectedActions", "textAlignmentHorizontal", "textAlignmentVertical", "textColor", "textVariable", "tooltips", "Lcom/yandex/div2/DivTooltip;", "transform", "Lcom/yandex/div2/DivTransform;", "transitionChange", "Lcom/yandex/div2/DivChangeTransition;", "transitionIn", "Lcom/yandex/div2/DivAppearanceTransition;", "transitionOut", "transitionTriggers", "Lcom/yandex/div2/DivTransitionTrigger;", "validators", "Lcom/yandex/div2/DivInputValidator;", "variableTriggers", "Lcom/yandex/div2/DivTrigger;", "variables", "Lcom/yandex/div2/DivVariable;", "visibility", "Lcom/yandex/div2/DivVisibility;", "visibilityAction", "Lcom/yandex/div2/DivVisibilityAction;", "visibilityActions", "width", "(Lcom/yandex/div2/DivAccessibility;Lcom/yandex/div/json/expressions/Expression;Lcom/yandex/div/json/expressions/Expression;Lcom/yandex/div/json/expressions/Expression;Ljava/util/List;Lcom/yandex/div/json/expressions/Expression;Ljava/util/List;Lcom/yandex/div2/DivBorder;Lcom/yandex/div/json/expressions/Expression;Ljava/util/List;Ljava/util/List;Lcom/yandex/div/json/expressions/Expression;Ljava/util/List;Ljava/util/List;Lcom/yandex/div2/DivFocus;Lcom/yandex/div/json/expressions/Expression;Lcom/yandex/div/json/expressions/Expression;Lcom/yandex/div/json/expressions/Expression;Lcom/yandex/div/json/expressions/Expression;Lcom/yandex/div/json/expressions/Expression;Ljava/util/List;Lcom/yandex/div2/DivSize;Lcom/yandex/div/json/expressions/Expression;Lcom/yandex/div/json/expressions/Expression;Lcom/yandex/div/json/expressions/Expression;Ljava/lang/String;Lcom/yandex/div/json/expressions/Expression;Lcom/yandex/div/json/expressions/Expression;Lcom/yandex/div2/DivLayoutProvider;Lcom/yandex/div/json/expressions/Expression;Lcom/yandex/div/json/expressions/Expression;Lcom/yandex/div2/DivEdgeInsets;Lcom/yandex/div2/DivInputMask;Lcom/yandex/div/json/expressions/Expression;Lcom/yandex/div/json/expressions/Expression;Lcom/yandex/div2/DivInput$NativeInterface;Lcom/yandex/div2/DivEdgeInsets;Lcom/yandex/div/json/expressions/Expression;Lcom/yandex/div/json/expressions/Expression;Lcom/yandex/div/json/expressions/Expression;Ljava/util/List;Lcom/yandex/div/json/expressions/Expression;Lcom/yandex/div/json/expressions/Expression;Lcom/yandex/div/json/expressions/Expression;Ljava/lang/String;Ljava/util/List;Lcom/yandex/div2/DivTransform;Lcom/yandex/div2/DivChangeTransition;Lcom/yandex/div2/DivAppearanceTransition;Lcom/yandex/div2/DivAppearanceTransition;Ljava/util/List;Ljava/util/List;Ljava/util/List;Ljava/util/List;Lcom/yandex/div/json/expressions/Expression;Lcom/yandex/div2/DivVisibilityAction;Ljava/util/List;Lcom/yandex/div2/DivSize;)V", "_hash", "Ljava/lang/Integer;", "getAccessibility", "()Lcom/yandex/div2/DivAccessibility;", "getAlignmentHorizontal", "()Lcom/yandex/div/json/expressions/Expression;", "getAlignmentVertical", "getAlpha", "getAnimators", "()Ljava/util/List;", "getBackground", "getBorder", "()Lcom/yandex/div2/DivBorder;", "getColumnSpan", "getDisappearActions", "getExtensions", "getFocus", "()Lcom/yandex/div2/DivFocus;", "getFunctions", "getHeight", "()Lcom/yandex/div2/DivSize;", "getId", "()Ljava/lang/String;", "getLayoutProvider", "()Lcom/yandex/div2/DivLayoutProvider;", "getMargins", "()Lcom/yandex/div2/DivEdgeInsets;", "getPaddings", "getReuseId", "getRowSpan", "getSelectedActions", "getTooltips", "getTransform", "()Lcom/yandex/div2/DivTransform;", "getTransitionChange", "()Lcom/yandex/div2/DivChangeTransition;", "getTransitionIn", "()Lcom/yandex/div2/DivAppearanceTransition;", "getTransitionOut", "getTransitionTriggers", "getVariableTriggers", "getVariables", "getVisibility", "getVisibilityAction", "()Lcom/yandex/div2/DivVisibilityAction;", "getVisibilityActions", "getWidth", "copy", "equals", "other", "resolver", "Lcom/yandex/div/json/expressions/ExpressionResolver;", "otherResolver", "hash", "writeToJSON", "Lorg/json/JSONObject;", "Autocapitalization", "Companion", "EnterKeyType", "KeyboardType", "NativeInterface", "div-data_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class DivInput implements JSONSerializable, Hashable, DivBase {
    public static final String TYPE = "input";
    private Integer _hash;
    private final DivAccessibility accessibility;
    private final Expression<DivAlignmentHorizontal> alignmentHorizontal;
    private final Expression<DivAlignmentVertical> alignmentVertical;
    private final Expression<Double> alpha;
    private final List<DivAnimator> animators;
    public final Expression<Autocapitalization> autocapitalization;
    private final List<DivBackground> background;
    private final DivBorder border;
    private final Expression<Long> columnSpan;
    private final List<DivDisappearAction> disappearActions;
    public final List<DivAction> enterKeyActions;
    public final Expression<EnterKeyType> enterKeyType;
    private final List<DivExtension> extensions;
    public final List<DivInputFilter> filters;
    private final DivFocus focus;
    public final Expression<String> fontFamily;
    public final Expression<Long> fontSize;
    public final Expression<DivSizeUnit> fontSizeUnit;
    public final Expression<DivFontWeight> fontWeight;
    public final Expression<Long> fontWeightValue;
    private final List<DivFunction> functions;
    private final DivSize height;
    public final Expression<Integer> highlightColor;
    public final Expression<Integer> hintColor;
    public final Expression<String> hintText;
    private final String id;
    public final Expression<Boolean> isEnabled;
    public final Expression<KeyboardType> keyboardType;
    private final DivLayoutProvider layoutProvider;
    public final Expression<Double> letterSpacing;
    public final Expression<Long> lineHeight;
    private final DivEdgeInsets margins;
    public final DivInputMask mask;
    public final Expression<Long> maxLength;
    public final Expression<Long> maxVisibleLines;
    public final NativeInterface nativeInterface;
    private final DivEdgeInsets paddings;
    private final Expression<String> reuseId;
    private final Expression<Long> rowSpan;
    public final Expression<Boolean> selectAllOnFocus;
    private final List<DivAction> selectedActions;
    public final Expression<DivAlignmentHorizontal> textAlignmentHorizontal;
    public final Expression<DivAlignmentVertical> textAlignmentVertical;
    public final Expression<Integer> textColor;
    public final String textVariable;
    private final List<DivTooltip> tooltips;
    private final DivTransform transform;
    private final DivChangeTransition transitionChange;
    private final DivAppearanceTransition transitionIn;
    private final DivAppearanceTransition transitionOut;
    private final List<DivTransitionTrigger> transitionTriggers;
    public final List<DivInputValidator> validators;
    private final List<DivTrigger> variableTriggers;
    private final List<DivVariable> variables;
    private final Expression<DivVisibility> visibility;
    private final DivVisibilityAction visibilityAction;
    private final List<DivVisibilityAction> visibilityActions;
    private final DivSize width;

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final Expression<Double> ALPHA_DEFAULT_VALUE = Expression.INSTANCE.constant(Double.valueOf(1.0d));
    private static final Expression<Autocapitalization> AUTOCAPITALIZATION_DEFAULT_VALUE = Expression.INSTANCE.constant(Autocapitalization.AUTO);
    private static final Expression<EnterKeyType> ENTER_KEY_TYPE_DEFAULT_VALUE = Expression.INSTANCE.constant(EnterKeyType.DEFAULT);
    private static final Expression<Long> FONT_SIZE_DEFAULT_VALUE = Expression.INSTANCE.constant(12L);
    private static final Expression<DivSizeUnit> FONT_SIZE_UNIT_DEFAULT_VALUE = Expression.INSTANCE.constant(DivSizeUnit.SP);
    private static final Expression<DivFontWeight> FONT_WEIGHT_DEFAULT_VALUE = Expression.INSTANCE.constant(DivFontWeight.REGULAR);
    private static final DivSize.WrapContent HEIGHT_DEFAULT_VALUE = new DivSize.WrapContent(new DivWrapContentSize(null, null, null, 7, null));
    private static final Expression<Integer> HINT_COLOR_DEFAULT_VALUE = Expression.INSTANCE.constant(1929379840);
    private static final Expression<Boolean> IS_ENABLED_DEFAULT_VALUE = Expression.INSTANCE.constant(true);
    private static final Expression<KeyboardType> KEYBOARD_TYPE_DEFAULT_VALUE = Expression.INSTANCE.constant(KeyboardType.MULTI_LINE_TEXT);
    private static final Expression<Double> LETTER_SPACING_DEFAULT_VALUE = Expression.INSTANCE.constant(Double.valueOf(0.0d));
    private static final Expression<Boolean> SELECT_ALL_ON_FOCUS_DEFAULT_VALUE = Expression.INSTANCE.constant(false);
    private static final Expression<DivAlignmentHorizontal> TEXT_ALIGNMENT_HORIZONTAL_DEFAULT_VALUE = Expression.INSTANCE.constant(DivAlignmentHorizontal.START);
    private static final Expression<DivAlignmentVertical> TEXT_ALIGNMENT_VERTICAL_DEFAULT_VALUE = Expression.INSTANCE.constant(DivAlignmentVertical.CENTER);
    private static final Expression<Integer> TEXT_COLOR_DEFAULT_VALUE = Expression.INSTANCE.constant(Integer.valueOf(ViewCompat.MEASURED_STATE_MASK));
    private static final Expression<DivVisibility> VISIBILITY_DEFAULT_VALUE = Expression.INSTANCE.constant(DivVisibility.VISIBLE);
    private static final DivSize.MatchParent WIDTH_DEFAULT_VALUE = new DivSize.MatchParent(new DivMatchParentSize(0 == true ? 1 : 0, 1, 0 == true ? 1 : 0));
    private static final Function2<ParsingEnvironment, JSONObject, DivInput> CREATOR = new Function2<ParsingEnvironment, JSONObject, DivInput>() { // from class: com.yandex.div2.DivInput$Companion$CREATOR$1
        @Override // kotlin.jvm.functions.Function2
        public final DivInput invoke(ParsingEnvironment env, JSONObject it) {
            Intrinsics.checkNotNullParameter(env, "env");
            Intrinsics.checkNotNullParameter(it, "it");
            return DivInput.INSTANCE.fromJson(env, it);
        }
    };

    @JvmStatic
    public static final DivInput fromJson(ParsingEnvironment parsingEnvironment, JSONObject jSONObject) {
        return INSTANCE.fromJson(parsingEnvironment, jSONObject);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public DivInput(DivAccessibility divAccessibility, Expression<DivAlignmentHorizontal> expression, Expression<DivAlignmentVertical> expression2, Expression<Double> alpha, List<? extends DivAnimator> list, Expression<Autocapitalization> autocapitalization, List<? extends DivBackground> list2, DivBorder divBorder, Expression<Long> expression3, List<DivDisappearAction> list3, List<DivAction> list4, Expression<EnterKeyType> enterKeyType, List<DivExtension> list5, List<? extends DivInputFilter> list6, DivFocus divFocus, Expression<String> expression4, Expression<Long> fontSize, Expression<DivSizeUnit> fontSizeUnit, Expression<DivFontWeight> fontWeight, Expression<Long> expression5, List<DivFunction> list7, DivSize height, Expression<Integer> expression6, Expression<Integer> hintColor, Expression<String> expression7, String str, Expression<Boolean> isEnabled, Expression<KeyboardType> keyboardType, DivLayoutProvider divLayoutProvider, Expression<Double> letterSpacing, Expression<Long> expression8, DivEdgeInsets divEdgeInsets, DivInputMask divInputMask, Expression<Long> expression9, Expression<Long> expression10, NativeInterface nativeInterface, DivEdgeInsets divEdgeInsets2, Expression<String> expression11, Expression<Long> expression12, Expression<Boolean> selectAllOnFocus, List<DivAction> list8, Expression<DivAlignmentHorizontal> textAlignmentHorizontal, Expression<DivAlignmentVertical> textAlignmentVertical, Expression<Integer> textColor, String textVariable, List<DivTooltip> list9, DivTransform divTransform, DivChangeTransition divChangeTransition, DivAppearanceTransition divAppearanceTransition, DivAppearanceTransition divAppearanceTransition2, List<? extends DivTransitionTrigger> list10, List<? extends DivInputValidator> list11, List<DivTrigger> list12, List<? extends DivVariable> list13, Expression<DivVisibility> visibility, DivVisibilityAction divVisibilityAction, List<DivVisibilityAction> list14, DivSize width) {
        Intrinsics.checkNotNullParameter(alpha, "alpha");
        Intrinsics.checkNotNullParameter(autocapitalization, "autocapitalization");
        Intrinsics.checkNotNullParameter(enterKeyType, "enterKeyType");
        Intrinsics.checkNotNullParameter(fontSize, "fontSize");
        Intrinsics.checkNotNullParameter(fontSizeUnit, "fontSizeUnit");
        Intrinsics.checkNotNullParameter(fontWeight, "fontWeight");
        Intrinsics.checkNotNullParameter(height, "height");
        Intrinsics.checkNotNullParameter(hintColor, "hintColor");
        Intrinsics.checkNotNullParameter(isEnabled, "isEnabled");
        Intrinsics.checkNotNullParameter(keyboardType, "keyboardType");
        Intrinsics.checkNotNullParameter(letterSpacing, "letterSpacing");
        Intrinsics.checkNotNullParameter(selectAllOnFocus, "selectAllOnFocus");
        Intrinsics.checkNotNullParameter(textAlignmentHorizontal, "textAlignmentHorizontal");
        Intrinsics.checkNotNullParameter(textAlignmentVertical, "textAlignmentVertical");
        Intrinsics.checkNotNullParameter(textColor, "textColor");
        Intrinsics.checkNotNullParameter(textVariable, "textVariable");
        Intrinsics.checkNotNullParameter(visibility, "visibility");
        Intrinsics.checkNotNullParameter(width, "width");
        this.accessibility = divAccessibility;
        this.alignmentHorizontal = expression;
        this.alignmentVertical = expression2;
        this.alpha = alpha;
        this.animators = list;
        this.autocapitalization = autocapitalization;
        this.background = list2;
        this.border = divBorder;
        this.columnSpan = expression3;
        this.disappearActions = list3;
        this.enterKeyActions = list4;
        this.enterKeyType = enterKeyType;
        this.extensions = list5;
        this.filters = list6;
        this.focus = divFocus;
        this.fontFamily = expression4;
        this.fontSize = fontSize;
        this.fontSizeUnit = fontSizeUnit;
        this.fontWeight = fontWeight;
        this.fontWeightValue = expression5;
        this.functions = list7;
        this.height = height;
        this.highlightColor = expression6;
        this.hintColor = hintColor;
        this.hintText = expression7;
        this.id = str;
        this.isEnabled = isEnabled;
        this.keyboardType = keyboardType;
        this.layoutProvider = divLayoutProvider;
        this.letterSpacing = letterSpacing;
        this.lineHeight = expression8;
        this.margins = divEdgeInsets;
        this.mask = divInputMask;
        this.maxLength = expression9;
        this.maxVisibleLines = expression10;
        this.nativeInterface = nativeInterface;
        this.paddings = divEdgeInsets2;
        this.reuseId = expression11;
        this.rowSpan = expression12;
        this.selectAllOnFocus = selectAllOnFocus;
        this.selectedActions = list8;
        this.textAlignmentHorizontal = textAlignmentHorizontal;
        this.textAlignmentVertical = textAlignmentVertical;
        this.textColor = textColor;
        this.textVariable = textVariable;
        this.tooltips = list9;
        this.transform = divTransform;
        this.transitionChange = divChangeTransition;
        this.transitionIn = divAppearanceTransition;
        this.transitionOut = divAppearanceTransition2;
        this.transitionTriggers = list10;
        this.validators = list11;
        this.variableTriggers = list12;
        this.variables = list13;
        this.visibility = visibility;
        this.visibilityAction = divVisibilityAction;
        this.visibilityActions = list14;
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

    public /* synthetic */ DivInput(DivAccessibility divAccessibility, Expression expression, Expression expression2, Expression expression3, List list, Expression expression4, List list2, DivBorder divBorder, Expression expression5, List list3, List list4, Expression expression6, List list5, List list6, DivFocus divFocus, Expression expression7, Expression expression8, Expression expression9, Expression expression10, Expression expression11, List list7, DivSize divSize, Expression expression12, Expression expression13, Expression expression14, String str, Expression expression15, Expression expression16, DivLayoutProvider divLayoutProvider, Expression expression17, Expression expression18, DivEdgeInsets divEdgeInsets, DivInputMask divInputMask, Expression expression19, Expression expression20, NativeInterface nativeInterface, DivEdgeInsets divEdgeInsets2, Expression expression21, Expression expression22, Expression expression23, List list8, Expression expression24, Expression expression25, Expression expression26, String str2, List list9, DivTransform divTransform, DivChangeTransition divChangeTransition, DivAppearanceTransition divAppearanceTransition, DivAppearanceTransition divAppearanceTransition2, List list10, List list11, List list12, List list13, Expression expression27, DivVisibilityAction divVisibilityAction, List list14, DivSize divSize2, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : divAccessibility, (i & 2) != 0 ? null : expression, (i & 4) != 0 ? null : expression2, (i & 8) != 0 ? ALPHA_DEFAULT_VALUE : expression3, (i & 16) != 0 ? null : list, (i & 32) != 0 ? AUTOCAPITALIZATION_DEFAULT_VALUE : expression4, (i & 64) != 0 ? null : list2, (i & 128) != 0 ? null : divBorder, (i & 256) != 0 ? null : expression5, (i & 512) != 0 ? null : list3, (i & 1024) != 0 ? null : list4, (i & 2048) != 0 ? ENTER_KEY_TYPE_DEFAULT_VALUE : expression6, (i & 4096) != 0 ? null : list5, (i & 8192) != 0 ? null : list6, (i & 16384) != 0 ? null : divFocus, (i & 32768) != 0 ? null : expression7, (i & 65536) != 0 ? FONT_SIZE_DEFAULT_VALUE : expression8, (i & 131072) != 0 ? FONT_SIZE_UNIT_DEFAULT_VALUE : expression9, (i & 262144) != 0 ? FONT_WEIGHT_DEFAULT_VALUE : expression10, (i & 524288) != 0 ? null : expression11, (i & 1048576) != 0 ? null : list7, (i & 2097152) != 0 ? HEIGHT_DEFAULT_VALUE : divSize, (i & 4194304) != 0 ? null : expression12, (i & 8388608) != 0 ? HINT_COLOR_DEFAULT_VALUE : expression13, (i & 16777216) != 0 ? null : expression14, (i & 33554432) != 0 ? null : str, (i & 67108864) != 0 ? IS_ENABLED_DEFAULT_VALUE : expression15, (i & 134217728) != 0 ? KEYBOARD_TYPE_DEFAULT_VALUE : expression16, (i & 268435456) != 0 ? null : divLayoutProvider, (i & 536870912) != 0 ? LETTER_SPACING_DEFAULT_VALUE : expression17, (i & 1073741824) != 0 ? null : expression18, (i & Integer.MIN_VALUE) != 0 ? null : divEdgeInsets, (i2 & 1) != 0 ? null : divInputMask, (i2 & 2) != 0 ? null : expression19, (i2 & 4) != 0 ? null : expression20, (i2 & 8) != 0 ? null : nativeInterface, (i2 & 16) != 0 ? null : divEdgeInsets2, (i2 & 32) != 0 ? null : expression21, (i2 & 64) != 0 ? null : expression22, (i2 & 128) != 0 ? SELECT_ALL_ON_FOCUS_DEFAULT_VALUE : expression23, (i2 & 256) != 0 ? null : list8, (i2 & 512) != 0 ? TEXT_ALIGNMENT_HORIZONTAL_DEFAULT_VALUE : expression24, (i2 & 1024) != 0 ? TEXT_ALIGNMENT_VERTICAL_DEFAULT_VALUE : expression25, (i2 & 2048) != 0 ? TEXT_COLOR_DEFAULT_VALUE : expression26, str2, (i2 & 8192) != 0 ? null : list9, (i2 & 16384) != 0 ? null : divTransform, (32768 & i2) != 0 ? null : divChangeTransition, (65536 & i2) != 0 ? null : divAppearanceTransition, (i2 & 131072) != 0 ? null : divAppearanceTransition2, (i2 & 262144) != 0 ? null : list10, (i2 & 524288) != 0 ? null : list11, (i2 & 1048576) != 0 ? null : list12, (i2 & 2097152) != 0 ? null : list13, (4194304 & i2) != 0 ? VISIBILITY_DEFAULT_VALUE : expression27, (8388608 & i2) != 0 ? null : divVisibilityAction, (16777216 & i2) != 0 ? null : list14, (i2 & 33554432) != 0 ? WIDTH_DEFAULT_VALUE : divSize2);
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
        int iHash11;
        int iHash12;
        Integer num = this._hash;
        if (num != null) {
            return num.intValue();
        }
        int iHashCode = Reflection.getOrCreateKotlinClass(getClass()).hashCode();
        DivAccessibility accessibility = getAccessibility();
        int iHash13 = 0;
        int iHash14 = iHashCode + (accessibility != null ? accessibility.hash() : 0);
        Expression<DivAlignmentHorizontal> alignmentHorizontal = getAlignmentHorizontal();
        int iHashCode2 = iHash14 + (alignmentHorizontal != null ? alignmentHorizontal.hashCode() : 0);
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
        int iHashCode4 = iHashCode3 + iHash + this.autocapitalization.hashCode();
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
        int i = iHashCode4 + iHash2;
        DivBorder border = getBorder();
        int iHash15 = i + (border != null ? border.hash() : 0);
        Expression<Long> columnSpan = getColumnSpan();
        int iHashCode5 = iHash15 + (columnSpan != null ? columnSpan.hashCode() : 0);
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
        int i2 = iHashCode5 + iHash3;
        List<DivAction> list = this.enterKeyActions;
        if (list != null) {
            Iterator<T> it4 = list.iterator();
            iHash4 = 0;
            while (it4.hasNext()) {
                iHash4 += ((DivAction) it4.next()).hash();
            }
        } else {
            iHash4 = 0;
        }
        int iHashCode6 = i2 + iHash4 + this.enterKeyType.hashCode();
        List<DivExtension> extensions = getExtensions();
        if (extensions != null) {
            Iterator<T> it5 = extensions.iterator();
            iHash5 = 0;
            while (it5.hasNext()) {
                iHash5 += ((DivExtension) it5.next()).hash();
            }
        } else {
            iHash5 = 0;
        }
        int i3 = iHashCode6 + iHash5;
        List<DivInputFilter> list2 = this.filters;
        if (list2 != null) {
            Iterator<T> it6 = list2.iterator();
            iHash6 = 0;
            while (it6.hasNext()) {
                iHash6 += ((DivInputFilter) it6.next()).hash();
            }
        } else {
            iHash6 = 0;
        }
        int i4 = i3 + iHash6;
        DivFocus focus = getFocus();
        int iHash16 = i4 + (focus != null ? focus.hash() : 0);
        Expression<String> expression = this.fontFamily;
        int iHashCode7 = iHash16 + (expression != null ? expression.hashCode() : 0) + this.fontSize.hashCode() + this.fontSizeUnit.hashCode() + this.fontWeight.hashCode();
        Expression<Long> expression2 = this.fontWeightValue;
        int iHashCode8 = iHashCode7 + (expression2 != null ? expression2.hashCode() : 0);
        List<DivFunction> functions = getFunctions();
        if (functions != null) {
            Iterator<T> it7 = functions.iterator();
            iHash7 = 0;
            while (it7.hasNext()) {
                iHash7 += ((DivFunction) it7.next()).hash();
            }
        } else {
            iHash7 = 0;
        }
        int iHash17 = iHashCode8 + iHash7 + getHeight().hash();
        Expression<Integer> expression3 = this.highlightColor;
        int iHashCode9 = iHash17 + (expression3 != null ? expression3.hashCode() : 0) + this.hintColor.hashCode();
        Expression<String> expression4 = this.hintText;
        int iHashCode10 = iHashCode9 + (expression4 != null ? expression4.hashCode() : 0);
        String id = getId();
        int iHashCode11 = iHashCode10 + (id != null ? id.hashCode() : 0) + this.isEnabled.hashCode() + this.keyboardType.hashCode();
        DivLayoutProvider layoutProvider = getLayoutProvider();
        int iHash18 = iHashCode11 + (layoutProvider != null ? layoutProvider.hash() : 0) + this.letterSpacing.hashCode();
        Expression<Long> expression5 = this.lineHeight;
        int iHashCode12 = iHash18 + (expression5 != null ? expression5.hashCode() : 0);
        DivEdgeInsets margins = getMargins();
        int iHash19 = iHashCode12 + (margins != null ? margins.hash() : 0);
        DivInputMask divInputMask = this.mask;
        int iHash20 = iHash19 + (divInputMask != null ? divInputMask.hash() : 0);
        Expression<Long> expression6 = this.maxLength;
        int iHashCode13 = iHash20 + (expression6 != null ? expression6.hashCode() : 0);
        Expression<Long> expression7 = this.maxVisibleLines;
        int iHashCode14 = iHashCode13 + (expression7 != null ? expression7.hashCode() : 0);
        NativeInterface nativeInterface = this.nativeInterface;
        int iHash21 = iHashCode14 + (nativeInterface != null ? nativeInterface.hash() : 0);
        DivEdgeInsets paddings = getPaddings();
        int iHash22 = iHash21 + (paddings != null ? paddings.hash() : 0);
        Expression<String> reuseId = getReuseId();
        int iHashCode15 = iHash22 + (reuseId != null ? reuseId.hashCode() : 0);
        Expression<Long> rowSpan = getRowSpan();
        int iHashCode16 = iHashCode15 + (rowSpan != null ? rowSpan.hashCode() : 0) + this.selectAllOnFocus.hashCode();
        List<DivAction> selectedActions = getSelectedActions();
        if (selectedActions != null) {
            Iterator<T> it8 = selectedActions.iterator();
            iHash8 = 0;
            while (it8.hasNext()) {
                iHash8 += ((DivAction) it8.next()).hash();
            }
        } else {
            iHash8 = 0;
        }
        int iHashCode17 = iHashCode16 + iHash8 + this.textAlignmentHorizontal.hashCode() + this.textAlignmentVertical.hashCode() + this.textColor.hashCode() + this.textVariable.hashCode();
        List<DivTooltip> tooltips = getTooltips();
        if (tooltips != null) {
            Iterator<T> it9 = tooltips.iterator();
            iHash9 = 0;
            while (it9.hasNext()) {
                iHash9 += ((DivTooltip) it9.next()).hash();
            }
        } else {
            iHash9 = 0;
        }
        int i5 = iHashCode17 + iHash9;
        DivTransform transform = getTransform();
        int iHash23 = i5 + (transform != null ? transform.hash() : 0);
        DivChangeTransition transitionChange = getTransitionChange();
        int iHash24 = iHash23 + (transitionChange != null ? transitionChange.hash() : 0);
        DivAppearanceTransition transitionIn = getTransitionIn();
        int iHash25 = iHash24 + (transitionIn != null ? transitionIn.hash() : 0);
        DivAppearanceTransition transitionOut = getTransitionOut();
        int iHash26 = iHash25 + (transitionOut != null ? transitionOut.hash() : 0);
        List<DivTransitionTrigger> transitionTriggers = getTransitionTriggers();
        int iHashCode18 = iHash26 + (transitionTriggers != null ? transitionTriggers.hashCode() : 0);
        List<DivInputValidator> list3 = this.validators;
        if (list3 != null) {
            Iterator<T> it10 = list3.iterator();
            iHash10 = 0;
            while (it10.hasNext()) {
                iHash10 += ((DivInputValidator) it10.next()).hash();
            }
        } else {
            iHash10 = 0;
        }
        int i6 = iHashCode18 + iHash10;
        List<DivTrigger> variableTriggers = getVariableTriggers();
        if (variableTriggers != null) {
            Iterator<T> it11 = variableTriggers.iterator();
            iHash11 = 0;
            while (it11.hasNext()) {
                iHash11 += ((DivTrigger) it11.next()).hash();
            }
        } else {
            iHash11 = 0;
        }
        int i7 = i6 + iHash11;
        List<DivVariable> variables = getVariables();
        if (variables != null) {
            Iterator<T> it12 = variables.iterator();
            iHash12 = 0;
            while (it12.hasNext()) {
                iHash12 += ((DivVariable) it12.next()).hash();
            }
        } else {
            iHash12 = 0;
        }
        int iHashCode19 = i7 + iHash12 + getVisibility().hashCode();
        DivVisibilityAction visibilityAction = getVisibilityAction();
        int iHash27 = iHashCode19 + (visibilityAction != null ? visibilityAction.hash() : 0);
        List<DivVisibilityAction> visibilityActions = getVisibilityActions();
        if (visibilityActions != null) {
            Iterator<T> it13 = visibilityActions.iterator();
            while (it13.hasNext()) {
                iHash13 += ((DivVisibilityAction) it13.next()).hash();
            }
        }
        int iHash28 = iHash27 + iHash13 + getWidth().hash();
        this._hash = Integer.valueOf(iHash28);
        return iHash28;
    }

    public final boolean equals(DivInput other, ExpressionResolver resolver, ExpressionResolver otherResolver) {
        boolean zEquals;
        boolean z;
        boolean z2;
        boolean zEquals2;
        boolean z3;
        boolean z4;
        boolean z5;
        boolean z6;
        boolean zEquals3;
        boolean z7;
        boolean zEquals4;
        boolean zEquals5;
        boolean zEquals6;
        boolean zEquals7;
        boolean zEquals8;
        boolean z8;
        boolean z9;
        boolean zEquals9;
        boolean zEquals10;
        boolean zEquals11;
        boolean zEquals12;
        boolean z10;
        boolean z11;
        boolean z12;
        boolean z13;
        boolean zEquals13;
        boolean z14;
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
        if (!z || this.autocapitalization.evaluate(resolver) != other.autocapitalization.evaluate(otherResolver)) {
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
        List<DivAction> list = this.enterKeyActions;
        if (list != null) {
            List<DivAction> list2 = other.enterKeyActions;
            if (list2 == null) {
                return false;
            }
            if (list.size() == list2.size()) {
                Iterator<T> it4 = list.iterator();
                int i7 = 0;
                while (true) {
                    if (it4.hasNext()) {
                        Object next4 = it4.next();
                        int i8 = i7 + 1;
                        if (i7 < 0) {
                            CollectionsKt.throwIndexOverflow();
                        }
                        if (((DivAction) next4).equals(list2.get(i7), resolver, otherResolver)) {
                            i7 = i8;
                        }
                    }
                }
            }
        } else {
            z4 = other.enterKeyActions == null;
        }
        if (!z4 || this.enterKeyType.evaluate(resolver) != other.enterKeyType.evaluate(otherResolver)) {
            return false;
        }
        List<DivExtension> extensions = getExtensions();
        if (extensions != null) {
            List<DivExtension> extensions2 = other.getExtensions();
            if (extensions2 == null) {
                return false;
            }
            if (extensions.size() == extensions2.size()) {
                Iterator<T> it5 = extensions.iterator();
                int i9 = 0;
                while (true) {
                    if (it5.hasNext()) {
                        Object next5 = it5.next();
                        int i10 = i9 + 1;
                        if (i9 < 0) {
                            CollectionsKt.throwIndexOverflow();
                        }
                        if (((DivExtension) next5).equals(extensions2.get(i9), resolver, otherResolver)) {
                            i9 = i10;
                        }
                    }
                }
            }
        } else {
            z5 = other.getExtensions() == null;
        }
        if (!z5) {
            return false;
        }
        List<DivInputFilter> list3 = this.filters;
        if (list3 != null) {
            List<DivInputFilter> list4 = other.filters;
            if (list4 == null) {
                return false;
            }
            if (list3.size() == list4.size()) {
                Iterator<T> it6 = list3.iterator();
                int i11 = 0;
                while (true) {
                    if (it6.hasNext()) {
                        Object next6 = it6.next();
                        int i12 = i11 + 1;
                        if (i11 < 0) {
                            CollectionsKt.throwIndexOverflow();
                        }
                        if (((DivInputFilter) next6).equals(list4.get(i11), resolver, otherResolver)) {
                            i11 = i12;
                        }
                    }
                }
            }
        } else {
            z6 = other.filters == null;
        }
        if (!z6) {
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
        Expression<String> expression = this.fontFamily;
        String strEvaluate = expression != null ? expression.evaluate(resolver) : null;
        Expression<String> expression2 = other.fontFamily;
        if (!Intrinsics.areEqual(strEvaluate, expression2 != null ? expression2.evaluate(otherResolver) : null) || this.fontSize.evaluate(resolver).longValue() != other.fontSize.evaluate(otherResolver).longValue() || this.fontSizeUnit.evaluate(resolver) != other.fontSizeUnit.evaluate(otherResolver) || this.fontWeight.evaluate(resolver) != other.fontWeight.evaluate(otherResolver)) {
            return false;
        }
        Expression<Long> expression3 = this.fontWeightValue;
        Long lEvaluate2 = expression3 != null ? expression3.evaluate(resolver) : null;
        Expression<Long> expression4 = other.fontWeightValue;
        if (!Intrinsics.areEqual(lEvaluate2, expression4 != null ? expression4.evaluate(otherResolver) : null)) {
            return false;
        }
        List<DivFunction> functions = getFunctions();
        if (functions != null) {
            List<DivFunction> functions2 = other.getFunctions();
            if (functions2 == null) {
                return false;
            }
            if (functions.size() == functions2.size()) {
                Iterator<T> it7 = functions.iterator();
                int i13 = 0;
                while (true) {
                    if (it7.hasNext()) {
                        Object next7 = it7.next();
                        int i14 = i13 + 1;
                        if (i13 < 0) {
                            CollectionsKt.throwIndexOverflow();
                        }
                        if (((DivFunction) next7).equals(functions2.get(i13), resolver, otherResolver)) {
                            i13 = i14;
                        }
                    }
                }
            }
        } else {
            z7 = other.getFunctions() == null;
        }
        if (!z7 || !getHeight().equals(other.getHeight(), resolver, otherResolver)) {
            return false;
        }
        Expression<Integer> expression5 = this.highlightColor;
        Integer numEvaluate = expression5 != null ? expression5.evaluate(resolver) : null;
        Expression<Integer> expression6 = other.highlightColor;
        if (!Intrinsics.areEqual(numEvaluate, expression6 != null ? expression6.evaluate(otherResolver) : null) || this.hintColor.evaluate(resolver).intValue() != other.hintColor.evaluate(otherResolver).intValue()) {
            return false;
        }
        Expression<String> expression7 = this.hintText;
        String strEvaluate2 = expression7 != null ? expression7.evaluate(resolver) : null;
        Expression<String> expression8 = other.hintText;
        if (!Intrinsics.areEqual(strEvaluate2, expression8 != null ? expression8.evaluate(otherResolver) : null) || !Intrinsics.areEqual(getId(), other.getId()) || this.isEnabled.evaluate(resolver).booleanValue() != other.isEnabled.evaluate(otherResolver).booleanValue() || this.keyboardType.evaluate(resolver) != other.keyboardType.evaluate(otherResolver)) {
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
        if (!(this.letterSpacing.evaluate(resolver).doubleValue() == other.letterSpacing.evaluate(otherResolver).doubleValue())) {
            return false;
        }
        Expression<Long> expression9 = this.lineHeight;
        Long lEvaluate3 = expression9 != null ? expression9.evaluate(resolver) : null;
        Expression<Long> expression10 = other.lineHeight;
        if (!Intrinsics.areEqual(lEvaluate3, expression10 != null ? expression10.evaluate(otherResolver) : null)) {
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
        DivInputMask divInputMask = this.mask;
        if (divInputMask != null) {
            zEquals6 = divInputMask.equals(other.mask, resolver, otherResolver);
        } else {
            zEquals6 = other.mask == null;
        }
        if (!zEquals6) {
            return false;
        }
        Expression<Long> expression11 = this.maxLength;
        Long lEvaluate4 = expression11 != null ? expression11.evaluate(resolver) : null;
        Expression<Long> expression12 = other.maxLength;
        if (!Intrinsics.areEqual(lEvaluate4, expression12 != null ? expression12.evaluate(otherResolver) : null)) {
            return false;
        }
        Expression<Long> expression13 = this.maxVisibleLines;
        Long lEvaluate5 = expression13 != null ? expression13.evaluate(resolver) : null;
        Expression<Long> expression14 = other.maxVisibleLines;
        if (!Intrinsics.areEqual(lEvaluate5, expression14 != null ? expression14.evaluate(otherResolver) : null)) {
            return false;
        }
        NativeInterface nativeInterface = this.nativeInterface;
        if (nativeInterface != null) {
            zEquals7 = nativeInterface.equals(other.nativeInterface, resolver, otherResolver);
        } else {
            zEquals7 = other.nativeInterface == null;
        }
        if (!zEquals7) {
            return false;
        }
        DivEdgeInsets paddings = getPaddings();
        if (paddings != null) {
            zEquals8 = paddings.equals(other.getPaddings(), resolver, otherResolver);
        } else {
            zEquals8 = other.getPaddings() == null;
        }
        if (!zEquals8) {
            return false;
        }
        Expression<String> reuseId = getReuseId();
        String strEvaluate3 = reuseId != null ? reuseId.evaluate(resolver) : null;
        Expression<String> reuseId2 = other.getReuseId();
        if (!Intrinsics.areEqual(strEvaluate3, reuseId2 != null ? reuseId2.evaluate(otherResolver) : null)) {
            return false;
        }
        Expression<Long> rowSpan = getRowSpan();
        Long lEvaluate6 = rowSpan != null ? rowSpan.evaluate(resolver) : null;
        Expression<Long> rowSpan2 = other.getRowSpan();
        if (!Intrinsics.areEqual(lEvaluate6, rowSpan2 != null ? rowSpan2.evaluate(otherResolver) : null) || this.selectAllOnFocus.evaluate(resolver).booleanValue() != other.selectAllOnFocus.evaluate(otherResolver).booleanValue()) {
            return false;
        }
        List<DivAction> selectedActions = getSelectedActions();
        if (selectedActions != null) {
            List<DivAction> selectedActions2 = other.getSelectedActions();
            if (selectedActions2 == null) {
                return false;
            }
            if (selectedActions.size() == selectedActions2.size()) {
                Iterator<T> it8 = selectedActions.iterator();
                int i15 = 0;
                while (true) {
                    if (it8.hasNext()) {
                        Object next8 = it8.next();
                        int i16 = i15 + 1;
                        if (i15 < 0) {
                            CollectionsKt.throwIndexOverflow();
                        }
                        if (((DivAction) next8).equals(selectedActions2.get(i15), resolver, otherResolver)) {
                            i15 = i16;
                        }
                    }
                }
            }
        } else {
            z8 = other.getSelectedActions() == null;
        }
        if (!z8 || this.textAlignmentHorizontal.evaluate(resolver) != other.textAlignmentHorizontal.evaluate(otherResolver) || this.textAlignmentVertical.evaluate(resolver) != other.textAlignmentVertical.evaluate(otherResolver) || this.textColor.evaluate(resolver).intValue() != other.textColor.evaluate(otherResolver).intValue() || !Intrinsics.areEqual(this.textVariable, other.textVariable)) {
            return false;
        }
        List<DivTooltip> tooltips = getTooltips();
        if (tooltips != null) {
            List<DivTooltip> tooltips2 = other.getTooltips();
            if (tooltips2 == null) {
                return false;
            }
            if (tooltips.size() == tooltips2.size()) {
                Iterator<T> it9 = tooltips.iterator();
                int i17 = 0;
                while (true) {
                    if (it9.hasNext()) {
                        Object next9 = it9.next();
                        int i18 = i17 + 1;
                        if (i17 < 0) {
                            CollectionsKt.throwIndexOverflow();
                        }
                        if (((DivTooltip) next9).equals(tooltips2.get(i17), resolver, otherResolver)) {
                            i17 = i18;
                        }
                    }
                }
            }
        } else {
            z9 = other.getTooltips() == null;
        }
        if (!z9) {
            return false;
        }
        DivTransform transform = getTransform();
        if (transform != null) {
            zEquals9 = transform.equals(other.getTransform(), resolver, otherResolver);
        } else {
            zEquals9 = other.getTransform() == null;
        }
        if (!zEquals9) {
            return false;
        }
        DivChangeTransition transitionChange = getTransitionChange();
        if (transitionChange != null) {
            zEquals10 = transitionChange.equals(other.getTransitionChange(), resolver, otherResolver);
        } else {
            zEquals10 = other.getTransitionChange() == null;
        }
        if (!zEquals10) {
            return false;
        }
        DivAppearanceTransition transitionIn = getTransitionIn();
        if (transitionIn != null) {
            zEquals11 = transitionIn.equals(other.getTransitionIn(), resolver, otherResolver);
        } else {
            zEquals11 = other.getTransitionIn() == null;
        }
        if (!zEquals11) {
            return false;
        }
        DivAppearanceTransition transitionOut = getTransitionOut();
        if (transitionOut != null) {
            zEquals12 = transitionOut.equals(other.getTransitionOut(), resolver, otherResolver);
        } else {
            zEquals12 = other.getTransitionOut() == null;
        }
        if (!zEquals12) {
            return false;
        }
        List<DivTransitionTrigger> transitionTriggers = getTransitionTriggers();
        if (transitionTriggers != null) {
            List<DivTransitionTrigger> transitionTriggers2 = other.getTransitionTriggers();
            if (transitionTriggers2 == null) {
                return false;
            }
            if (transitionTriggers.size() == transitionTriggers2.size()) {
                Iterator<T> it10 = transitionTriggers.iterator();
                int i19 = 0;
                while (true) {
                    if (it10.hasNext()) {
                        Object next10 = it10.next();
                        int i20 = i19 + 1;
                        if (i19 < 0) {
                            CollectionsKt.throwIndexOverflow();
                        }
                        if (((DivTransitionTrigger) next10) == transitionTriggers2.get(i19)) {
                            i19 = i20;
                        }
                    }
                }
            }
        } else {
            z10 = other.getTransitionTriggers() == null;
        }
        if (!z10) {
            return false;
        }
        List<DivInputValidator> list5 = this.validators;
        if (list5 != null) {
            List<DivInputValidator> list6 = other.validators;
            if (list6 == null) {
                return false;
            }
            if (list5.size() == list6.size()) {
                Iterator<T> it11 = list5.iterator();
                int i21 = 0;
                while (true) {
                    if (it11.hasNext()) {
                        Object next11 = it11.next();
                        int i22 = i21 + 1;
                        if (i21 < 0) {
                            CollectionsKt.throwIndexOverflow();
                        }
                        if (((DivInputValidator) next11).equals(list6.get(i21), resolver, otherResolver)) {
                            i21 = i22;
                        }
                    }
                }
            }
        } else {
            z11 = other.validators == null;
        }
        if (!z11) {
            return false;
        }
        List<DivTrigger> variableTriggers = getVariableTriggers();
        if (variableTriggers != null) {
            List<DivTrigger> variableTriggers2 = other.getVariableTriggers();
            if (variableTriggers2 == null) {
                return false;
            }
            if (variableTriggers.size() == variableTriggers2.size()) {
                Iterator<T> it12 = variableTriggers.iterator();
                int i23 = 0;
                while (true) {
                    if (it12.hasNext()) {
                        Object next12 = it12.next();
                        int i24 = i23 + 1;
                        if (i23 < 0) {
                            CollectionsKt.throwIndexOverflow();
                        }
                        if (((DivTrigger) next12).equals(variableTriggers2.get(i23), resolver, otherResolver)) {
                            i23 = i24;
                        }
                    }
                }
            }
        } else {
            z12 = other.getVariableTriggers() == null;
        }
        if (!z12) {
            return false;
        }
        List<DivVariable> variables = getVariables();
        if (variables != null) {
            List<DivVariable> variables2 = other.getVariables();
            if (variables2 == null) {
                return false;
            }
            if (variables.size() == variables2.size()) {
                Iterator<T> it13 = variables.iterator();
                int i25 = 0;
                while (true) {
                    if (it13.hasNext()) {
                        Object next13 = it13.next();
                        int i26 = i25 + 1;
                        if (i25 < 0) {
                            CollectionsKt.throwIndexOverflow();
                        }
                        if (((DivVariable) next13).equals(variables2.get(i25), resolver, otherResolver)) {
                            i25 = i26;
                        }
                    }
                }
            }
        } else {
            z13 = other.getVariables() == null;
        }
        if (!z13 || getVisibility().evaluate(resolver) != other.getVisibility().evaluate(otherResolver)) {
            return false;
        }
        DivVisibilityAction visibilityAction = getVisibilityAction();
        if (visibilityAction != null) {
            zEquals13 = visibilityAction.equals(other.getVisibilityAction(), resolver, otherResolver);
        } else {
            zEquals13 = other.getVisibilityAction() == null;
        }
        if (!zEquals13) {
            return false;
        }
        List<DivVisibilityAction> visibilityActions = getVisibilityActions();
        if (visibilityActions != null) {
            List<DivVisibilityAction> visibilityActions2 = other.getVisibilityActions();
            if (visibilityActions2 == null) {
                return false;
            }
            if (visibilityActions.size() == visibilityActions2.size()) {
                Iterator<T> it14 = visibilityActions.iterator();
                int i27 = 0;
                while (true) {
                    if (it14.hasNext()) {
                        Object next14 = it14.next();
                        int i28 = i27 + 1;
                        if (i27 < 0) {
                            CollectionsKt.throwIndexOverflow();
                        }
                        if (((DivVisibilityAction) next14).equals(visibilityActions2.get(i27), resolver, otherResolver)) {
                            i27 = i28;
                        }
                    }
                }
            }
        } else {
            z14 = other.getVisibilityActions() == null;
        }
        return z14 && getWidth().equals(other.getWidth(), resolver, otherResolver);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ DivInput copy$default(DivInput divInput, DivAccessibility divAccessibility, Expression expression, Expression expression2, Expression expression3, List list, Expression expression4, List list2, DivBorder divBorder, Expression expression5, List list3, List list4, Expression expression6, List list5, List list6, DivFocus divFocus, Expression expression7, Expression expression8, Expression expression9, Expression expression10, Expression expression11, List list7, DivSize divSize, Expression expression12, Expression expression13, Expression expression14, String str, Expression expression15, Expression expression16, DivLayoutProvider divLayoutProvider, Expression expression17, Expression expression18, DivEdgeInsets divEdgeInsets, DivInputMask divInputMask, Expression expression19, Expression expression20, NativeInterface nativeInterface, DivEdgeInsets divEdgeInsets2, Expression expression21, Expression expression22, Expression expression23, List list8, Expression expression24, Expression expression25, Expression expression26, String str2, List list9, DivTransform divTransform, DivChangeTransition divChangeTransition, DivAppearanceTransition divAppearanceTransition, DivAppearanceTransition divAppearanceTransition2, List list10, List list11, List list12, List list13, Expression expression27, DivVisibilityAction divVisibilityAction, List list14, DivSize divSize2, int i, int i2, Object obj) {
        DivAccessibility accessibility = (i & 1) != 0 ? divInput.getAccessibility() : divAccessibility;
        Expression alignmentHorizontal = (i & 2) != 0 ? divInput.getAlignmentHorizontal() : expression;
        Expression alignmentVertical = (i & 4) != 0 ? divInput.getAlignmentVertical() : expression2;
        Expression alpha = (i & 8) != 0 ? divInput.getAlpha() : expression3;
        List animators = (i & 16) != 0 ? divInput.getAnimators() : list;
        Expression expression28 = (i & 32) != 0 ? divInput.autocapitalization : expression4;
        List background = (i & 64) != 0 ? divInput.getBackground() : list2;
        DivBorder border = (i & 128) != 0 ? divInput.getBorder() : divBorder;
        Expression columnSpan = (i & 256) != 0 ? divInput.getColumnSpan() : expression5;
        List disappearActions = (i & 512) != 0 ? divInput.getDisappearActions() : list3;
        List list15 = (i & 1024) != 0 ? divInput.enterKeyActions : list4;
        Expression expression29 = (i & 2048) != 0 ? divInput.enterKeyType : expression6;
        List extensions = (i & 4096) != 0 ? divInput.getExtensions() : list5;
        List list16 = (i & 8192) != 0 ? divInput.filters : list6;
        DivFocus focus = (i & 16384) != 0 ? divInput.getFocus() : divFocus;
        Expression expression30 = (i & 32768) != 0 ? divInput.fontFamily : expression7;
        Expression expression31 = (i & 65536) != 0 ? divInput.fontSize : expression8;
        Expression expression32 = (i & 131072) != 0 ? divInput.fontSizeUnit : expression9;
        Expression expression33 = (i & 262144) != 0 ? divInput.fontWeight : expression10;
        Expression expression34 = (i & 524288) != 0 ? divInput.fontWeightValue : expression11;
        List functions = (i & 1048576) != 0 ? divInput.getFunctions() : list7;
        DivSize height = (i & 2097152) != 0 ? divInput.getHeight() : divSize;
        Expression expression35 = expression34;
        Expression expression36 = (i & 4194304) != 0 ? divInput.highlightColor : expression12;
        Expression expression37 = (i & 8388608) != 0 ? divInput.hintColor : expression13;
        Expression expression38 = (i & 16777216) != 0 ? divInput.hintText : expression14;
        String id = (i & 33554432) != 0 ? divInput.getId() : str;
        Expression expression39 = expression38;
        Expression expression40 = (i & 67108864) != 0 ? divInput.isEnabled : expression15;
        Expression expression41 = (i & 134217728) != 0 ? divInput.keyboardType : expression16;
        DivLayoutProvider layoutProvider = (i & 268435456) != 0 ? divInput.getLayoutProvider() : divLayoutProvider;
        Expression expression42 = expression41;
        Expression expression43 = (i & 536870912) != 0 ? divInput.letterSpacing : expression17;
        Expression expression44 = (i & 1073741824) != 0 ? divInput.lineHeight : expression18;
        DivEdgeInsets margins = (i & Integer.MIN_VALUE) != 0 ? divInput.getMargins() : divEdgeInsets;
        DivInputMask divInputMask2 = (i2 & 1) != 0 ? divInput.mask : divInputMask;
        Expression expression45 = (i2 & 2) != 0 ? divInput.maxLength : expression19;
        Expression expression46 = (i2 & 4) != 0 ? divInput.maxVisibleLines : expression20;
        NativeInterface nativeInterface2 = (i2 & 8) != 0 ? divInput.nativeInterface : nativeInterface;
        return divInput.copy(accessibility, alignmentHorizontal, alignmentVertical, alpha, animators, expression28, background, border, columnSpan, disappearActions, list15, expression29, extensions, list16, focus, expression30, expression31, expression32, expression33, expression35, functions, height, expression36, expression37, expression39, id, expression40, expression42, layoutProvider, expression43, expression44, margins, divInputMask2, expression45, expression46, nativeInterface2, (i2 & 16) != 0 ? divInput.getPaddings() : divEdgeInsets2, (i2 & 32) != 0 ? divInput.getReuseId() : expression21, (i2 & 64) != 0 ? divInput.getRowSpan() : expression22, (i2 & 128) != 0 ? divInput.selectAllOnFocus : expression23, (i2 & 256) != 0 ? divInput.getSelectedActions() : list8, (i2 & 512) != 0 ? divInput.textAlignmentHorizontal : expression24, (i2 & 1024) != 0 ? divInput.textAlignmentVertical : expression25, (i2 & 2048) != 0 ? divInput.textColor : expression26, (i2 & 4096) != 0 ? divInput.textVariable : str2, (i2 & 8192) != 0 ? divInput.getTooltips() : list9, (i2 & 16384) != 0 ? divInput.getTransform() : divTransform, (i2 & 32768) != 0 ? divInput.getTransitionChange() : divChangeTransition, (i2 & 65536) != 0 ? divInput.getTransitionIn() : divAppearanceTransition, (i2 & 131072) != 0 ? divInput.getTransitionOut() : divAppearanceTransition2, (i2 & 262144) != 0 ? divInput.getTransitionTriggers() : list10, (i2 & 524288) != 0 ? divInput.validators : list11, (i2 & 1048576) != 0 ? divInput.getVariableTriggers() : list12, (i2 & 2097152) != 0 ? divInput.getVariables() : list13, (i2 & 4194304) != 0 ? divInput.getVisibility() : expression27, (i2 & 8388608) != 0 ? divInput.getVisibilityAction() : divVisibilityAction, (i2 & 16777216) != 0 ? divInput.getVisibilityActions() : list14, (i2 & 33554432) != 0 ? divInput.getWidth() : divSize2);
    }

    public final DivInput copy(DivAccessibility accessibility, Expression<DivAlignmentHorizontal> alignmentHorizontal, Expression<DivAlignmentVertical> alignmentVertical, Expression<Double> alpha, List<? extends DivAnimator> animators, Expression<Autocapitalization> autocapitalization, List<? extends DivBackground> background, DivBorder border, Expression<Long> columnSpan, List<DivDisappearAction> disappearActions, List<DivAction> enterKeyActions, Expression<EnterKeyType> enterKeyType, List<DivExtension> extensions, List<? extends DivInputFilter> filters, DivFocus focus, Expression<String> fontFamily, Expression<Long> fontSize, Expression<DivSizeUnit> fontSizeUnit, Expression<DivFontWeight> fontWeight, Expression<Long> fontWeightValue, List<DivFunction> functions, DivSize height, Expression<Integer> highlightColor, Expression<Integer> hintColor, Expression<String> hintText, String id, Expression<Boolean> isEnabled, Expression<KeyboardType> keyboardType, DivLayoutProvider layoutProvider, Expression<Double> letterSpacing, Expression<Long> lineHeight, DivEdgeInsets margins, DivInputMask mask, Expression<Long> maxLength, Expression<Long> maxVisibleLines, NativeInterface nativeInterface, DivEdgeInsets paddings, Expression<String> reuseId, Expression<Long> rowSpan, Expression<Boolean> selectAllOnFocus, List<DivAction> selectedActions, Expression<DivAlignmentHorizontal> textAlignmentHorizontal, Expression<DivAlignmentVertical> textAlignmentVertical, Expression<Integer> textColor, String textVariable, List<DivTooltip> tooltips, DivTransform transform, DivChangeTransition transitionChange, DivAppearanceTransition transitionIn, DivAppearanceTransition transitionOut, List<? extends DivTransitionTrigger> transitionTriggers, List<? extends DivInputValidator> validators, List<DivTrigger> variableTriggers, List<? extends DivVariable> variables, Expression<DivVisibility> visibility, DivVisibilityAction visibilityAction, List<DivVisibilityAction> visibilityActions, DivSize width) {
        Intrinsics.checkNotNullParameter(alpha, "alpha");
        Intrinsics.checkNotNullParameter(autocapitalization, "autocapitalization");
        Intrinsics.checkNotNullParameter(enterKeyType, "enterKeyType");
        Intrinsics.checkNotNullParameter(fontSize, "fontSize");
        Intrinsics.checkNotNullParameter(fontSizeUnit, "fontSizeUnit");
        Intrinsics.checkNotNullParameter(fontWeight, "fontWeight");
        Intrinsics.checkNotNullParameter(height, "height");
        Intrinsics.checkNotNullParameter(hintColor, "hintColor");
        Intrinsics.checkNotNullParameter(isEnabled, "isEnabled");
        Intrinsics.checkNotNullParameter(keyboardType, "keyboardType");
        Intrinsics.checkNotNullParameter(letterSpacing, "letterSpacing");
        Intrinsics.checkNotNullParameter(selectAllOnFocus, "selectAllOnFocus");
        Intrinsics.checkNotNullParameter(textAlignmentHorizontal, "textAlignmentHorizontal");
        Intrinsics.checkNotNullParameter(textAlignmentVertical, "textAlignmentVertical");
        Intrinsics.checkNotNullParameter(textColor, "textColor");
        Intrinsics.checkNotNullParameter(textVariable, "textVariable");
        Intrinsics.checkNotNullParameter(visibility, "visibility");
        Intrinsics.checkNotNullParameter(width, "width");
        return new DivInput(accessibility, alignmentHorizontal, alignmentVertical, alpha, animators, autocapitalization, background, border, columnSpan, disappearActions, enterKeyActions, enterKeyType, extensions, filters, focus, fontFamily, fontSize, fontSizeUnit, fontWeight, fontWeightValue, functions, height, highlightColor, hintColor, hintText, id, isEnabled, keyboardType, layoutProvider, letterSpacing, lineHeight, margins, mask, maxLength, maxVisibleLines, nativeInterface, paddings, reuseId, rowSpan, selectAllOnFocus, selectedActions, textAlignmentHorizontal, textAlignmentVertical, textColor, textVariable, tooltips, transform, transitionChange, transitionIn, transitionOut, transitionTriggers, validators, variableTriggers, variables, visibility, visibilityAction, visibilityActions, width);
    }

    @Override // com.yandex.div.json.JSONSerializable
    public JSONObject writeToJSON() {
        return BuiltInParserKt.getBuiltInParserComponent().getDivInputJsonEntityParser().getValue().serialize(BuiltInParserKt.getBuiltInParsingContext(), this);
    }

    /* JADX INFO: compiled from: DivInput.kt */
    @Metadata(d1 = {"\u0000\u0084\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0006\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u001e\u0010,\u001a\u00020\f2\u0006\u0010-\u001a\u00020\n2\u0006\u0010.\u001a\u00020\u000bH\u0087\u0002¢\u0006\u0002\b/R\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00070\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R#\u0010\b\u001a\u0014\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\f0\t¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0014\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00100\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00120\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00140\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00160\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0018X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u001a0\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u001c0\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u001e0\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010 \u001a\b\u0012\u0004\u0012\u00020\u001c0\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010!\u001a\b\u0012\u0004\u0012\u00020\"0\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010#\u001a\b\u0012\u0004\u0012\u00020$0\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010%\u001a\b\u0012\u0004\u0012\u00020\u001a0\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010&\u001a\u00020'X\u0086T¢\u0006\u0002\n\u0000R\u0014\u0010(\u001a\b\u0012\u0004\u0012\u00020)0\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010*\u001a\u00020+X\u0082\u0004¢\u0006\u0002\n\u0000¨\u00060"}, d2 = {"Lcom/yandex/div2/DivInput$Companion;", "", "()V", "ALPHA_DEFAULT_VALUE", "Lcom/yandex/div/json/expressions/Expression;", "", "AUTOCAPITALIZATION_DEFAULT_VALUE", "Lcom/yandex/div2/DivInput$Autocapitalization;", "CREATOR", "Lkotlin/Function2;", "Lcom/yandex/div/json/ParsingEnvironment;", "Lorg/json/JSONObject;", "Lcom/yandex/div2/DivInput;", "getCREATOR", "()Lkotlin/jvm/functions/Function2;", "ENTER_KEY_TYPE_DEFAULT_VALUE", "Lcom/yandex/div2/DivInput$EnterKeyType;", "FONT_SIZE_DEFAULT_VALUE", "", "FONT_SIZE_UNIT_DEFAULT_VALUE", "Lcom/yandex/div2/DivSizeUnit;", "FONT_WEIGHT_DEFAULT_VALUE", "Lcom/yandex/div2/DivFontWeight;", "HEIGHT_DEFAULT_VALUE", "Lcom/yandex/div2/DivSize$WrapContent;", "HINT_COLOR_DEFAULT_VALUE", "", "IS_ENABLED_DEFAULT_VALUE", "", "KEYBOARD_TYPE_DEFAULT_VALUE", "Lcom/yandex/div2/DivInput$KeyboardType;", "LETTER_SPACING_DEFAULT_VALUE", "SELECT_ALL_ON_FOCUS_DEFAULT_VALUE", "TEXT_ALIGNMENT_HORIZONTAL_DEFAULT_VALUE", "Lcom/yandex/div2/DivAlignmentHorizontal;", "TEXT_ALIGNMENT_VERTICAL_DEFAULT_VALUE", "Lcom/yandex/div2/DivAlignmentVertical;", "TEXT_COLOR_DEFAULT_VALUE", "TYPE", "", "VISIBILITY_DEFAULT_VALUE", "Lcom/yandex/div2/DivVisibility;", "WIDTH_DEFAULT_VALUE", "Lcom/yandex/div2/DivSize$MatchParent;", "invoke", cc.o, "json", "fromJson", "div-data_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @JvmStatic
        public final DivInput fromJson(ParsingEnvironment env, JSONObject json) {
            Intrinsics.checkNotNullParameter(env, "env");
            Intrinsics.checkNotNullParameter(json, "json");
            return BuiltInParserKt.getBuiltInParserComponent().getDivInputJsonEntityParser().getValue().deserialize((ParsingContext) env, json);
        }

        public final Function2<ParsingEnvironment, JSONObject, DivInput> getCREATOR() {
            return DivInput.CREATOR;
        }
    }

    /* JADX INFO: compiled from: DivInput.kt */
    @Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \u00132\u00020\u00012\u00020\u0002:\u0001\u0013B\u0015\b\u0007\u0012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\u0002\u0010\u0006J\u0016\u0010\t\u001a\u00020\u00002\u000e\b\u0002\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004J \u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\u00002\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u000eJ\b\u0010\u0010\u001a\u00020\u0005H\u0016J\b\u0010\u0011\u001a\u00020\u0012H\u0016R\u0012\u0010\u0007\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0004\n\u0002\u0010\bR\u0016\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u00048\u0006X\u0087\u0004¢\u0006\u0002\n\u0000¨\u0006\u0014"}, d2 = {"Lcom/yandex/div2/DivInput$NativeInterface;", "Lcom/yandex/div/json/JSONSerializable;", "Lcom/yandex/div/data/Hashable;", "color", "Lcom/yandex/div/json/expressions/Expression;", "", "(Lcom/yandex/div/json/expressions/Expression;)V", "_hash", "Ljava/lang/Integer;", "copy", "equals", "", "other", "resolver", "Lcom/yandex/div/json/expressions/ExpressionResolver;", "otherResolver", "hash", "writeToJSON", "Lorg/json/JSONObject;", "Companion", "div-data_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class NativeInterface implements JSONSerializable, Hashable {
        private Integer _hash;
        public final Expression<Integer> color;

        /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
        public static final Companion INSTANCE = new Companion(null);
        private static final Function2<ParsingEnvironment, JSONObject, NativeInterface> CREATOR = new Function2<ParsingEnvironment, JSONObject, NativeInterface>() { // from class: com.yandex.div2.DivInput$NativeInterface$Companion$CREATOR$1
            @Override // kotlin.jvm.functions.Function2
            public final DivInput.NativeInterface invoke(ParsingEnvironment env, JSONObject it) {
                Intrinsics.checkNotNullParameter(env, "env");
                Intrinsics.checkNotNullParameter(it, "it");
                return DivInput.NativeInterface.INSTANCE.fromJson(env, it);
            }
        };

        @JvmStatic
        public static final NativeInterface fromJson(ParsingEnvironment parsingEnvironment, JSONObject jSONObject) {
            return INSTANCE.fromJson(parsingEnvironment, jSONObject);
        }

        public NativeInterface(Expression<Integer> color) {
            Intrinsics.checkNotNullParameter(color, "color");
            this.color = color;
        }

        @Override // com.yandex.div.data.Hashable
        public int hash() {
            Integer num = this._hash;
            if (num != null) {
                return num.intValue();
            }
            int iHashCode = Reflection.getOrCreateKotlinClass(getClass()).hashCode() + this.color.hashCode();
            this._hash = Integer.valueOf(iHashCode);
            return iHashCode;
        }

        public final boolean equals(NativeInterface other, ExpressionResolver resolver, ExpressionResolver otherResolver) {
            Intrinsics.checkNotNullParameter(resolver, "resolver");
            Intrinsics.checkNotNullParameter(otherResolver, "otherResolver");
            return other != null && this.color.evaluate(resolver).intValue() == other.color.evaluate(otherResolver).intValue();
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ NativeInterface copy$default(NativeInterface nativeInterface, Expression expression, int i, Object obj) {
            if ((i & 1) != 0) {
                expression = nativeInterface.color;
            }
            return nativeInterface.copy(expression);
        }

        public final NativeInterface copy(Expression<Integer> color) {
            Intrinsics.checkNotNullParameter(color, "color");
            return new NativeInterface(color);
        }

        @Override // com.yandex.div.json.JSONSerializable
        public JSONObject writeToJSON() {
            return BuiltInParserKt.getBuiltInParserComponent().getDivInputNativeInterfaceJsonEntityParser().getValue().serialize(BuiltInParserKt.getBuiltInParsingContext(), this);
        }

        /* JADX INFO: compiled from: DivInput.kt */
        @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u001e\u0010\n\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\u00052\u0006\u0010\f\u001a\u00020\u0006H\u0087\u0002¢\u0006\u0002\b\rR#\u0010\u0003\u001a\u0014\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\t¨\u0006\u000e"}, d2 = {"Lcom/yandex/div2/DivInput$NativeInterface$Companion;", "", "()V", "CREATOR", "Lkotlin/Function2;", "Lcom/yandex/div/json/ParsingEnvironment;", "Lorg/json/JSONObject;", "Lcom/yandex/div2/DivInput$NativeInterface;", "getCREATOR", "()Lkotlin/jvm/functions/Function2;", "invoke", cc.o, "json", "fromJson", "div-data_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private Companion() {
            }

            @JvmStatic
            public final NativeInterface fromJson(ParsingEnvironment env, JSONObject json) {
                Intrinsics.checkNotNullParameter(env, "env");
                Intrinsics.checkNotNullParameter(json, "json");
                return BuiltInParserKt.getBuiltInParserComponent().getDivInputNativeInterfaceJsonEntityParser().getValue().deserialize((ParsingContext) env, json);
            }

            public final Function2<ParsingEnvironment, JSONObject, NativeInterface> getCREATOR() {
                return NativeInterface.CREATOR;
            }
        }
    }

    /* JADX INFO: compiled from: DivInput.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\b\b\u0086\u0001\u0018\u0000 \n2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\nB\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\t¨\u0006\u000b"}, d2 = {"Lcom/yandex/div2/DivInput$Autocapitalization;", "", "value", "", "(Ljava/lang/String;ILjava/lang/String;)V", "AUTO", "NONE", "WORDS", "SENTENCES", "ALL_CHARACTERS", "Converter", "div-data_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public enum Autocapitalization {
        AUTO("auto"),
        NONE("none"),
        WORDS("words"),
        SENTENCES("sentences"),
        ALL_CHARACTERS("all_characters");

        private final String value;

        /* JADX INFO: renamed from: Converter, reason: from kotlin metadata */
        public static final Companion INSTANCE = new Companion(null);
        public static final Function1<Autocapitalization, String> TO_STRING = new Function1<Autocapitalization, String>() { // from class: com.yandex.div2.DivInput$Autocapitalization$Converter$TO_STRING$1
            @Override // kotlin.jvm.functions.Function1
            public final String invoke(DivInput.Autocapitalization value) {
                Intrinsics.checkNotNullParameter(value, "value");
                return DivInput.Autocapitalization.INSTANCE.toString(value);
            }
        };
        public static final Function1<String, Autocapitalization> FROM_STRING = new Function1<String, Autocapitalization>() { // from class: com.yandex.div2.DivInput$Autocapitalization$Converter$FROM_STRING$1
            @Override // kotlin.jvm.functions.Function1
            public final DivInput.Autocapitalization invoke(String value) {
                Intrinsics.checkNotNullParameter(value, "value");
                return DivInput.Autocapitalization.INSTANCE.fromString(value);
            }
        };

        Autocapitalization(String str) {
            this.value = str;
        }

        /* JADX INFO: renamed from: com.yandex.div2.DivInput$Autocapitalization$Converter, reason: from kotlin metadata */
        /* JADX INFO: compiled from: DivInput.kt */
        @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\b\u001a\u0004\u0018\u00010\u00062\u0006\u0010\t\u001a\u00020\u0005J\u000e\u0010\n\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\u0006R\u001e\u0010\u0003\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u00048\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00050\u00048\u0006X\u0087\u0004¢\u0006\u0002\n\u0000¨\u0006\f"}, d2 = {"Lcom/yandex/div2/DivInput$Autocapitalization$Converter;", "", "()V", "FROM_STRING", "Lkotlin/Function1;", "", "Lcom/yandex/div2/DivInput$Autocapitalization;", "TO_STRING", "fromString", "value", "toString", "obj", "div-data_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private Companion() {
            }

            public final String toString(Autocapitalization obj) {
                Intrinsics.checkNotNullParameter(obj, "obj");
                return obj.value;
            }

            public final Autocapitalization fromString(String value) {
                Intrinsics.checkNotNullParameter(value, "value");
                if (Intrinsics.areEqual(value, Autocapitalization.AUTO.value)) {
                    return Autocapitalization.AUTO;
                }
                if (Intrinsics.areEqual(value, Autocapitalization.NONE.value)) {
                    return Autocapitalization.NONE;
                }
                if (Intrinsics.areEqual(value, Autocapitalization.WORDS.value)) {
                    return Autocapitalization.WORDS;
                }
                if (Intrinsics.areEqual(value, Autocapitalization.SENTENCES.value)) {
                    return Autocapitalization.SENTENCES;
                }
                if (Intrinsics.areEqual(value, Autocapitalization.ALL_CHARACTERS.value)) {
                    return Autocapitalization.ALL_CHARACTERS;
                }
                return null;
            }
        }
    }

    /* JADX INFO: compiled from: DivInput.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\b\b\u0086\u0001\u0018\u0000 \n2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\nB\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\t¨\u0006\u000b"}, d2 = {"Lcom/yandex/div2/DivInput$EnterKeyType;", "", "value", "", "(Ljava/lang/String;ILjava/lang/String;)V", "DEFAULT", "GO", ViewHierarchyConstants.SEARCH, "SEND", "DONE", "Converter", "div-data_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public enum EnterKeyType {
        DEFAULT("default"),
        GO("go"),
        SEARCH("search"),
        SEND("send"),
        DONE("done");

        private final String value;

        /* JADX INFO: renamed from: Converter, reason: from kotlin metadata */
        public static final Companion INSTANCE = new Companion(null);
        public static final Function1<EnterKeyType, String> TO_STRING = new Function1<EnterKeyType, String>() { // from class: com.yandex.div2.DivInput$EnterKeyType$Converter$TO_STRING$1
            @Override // kotlin.jvm.functions.Function1
            public final String invoke(DivInput.EnterKeyType value) {
                Intrinsics.checkNotNullParameter(value, "value");
                return DivInput.EnterKeyType.INSTANCE.toString(value);
            }
        };
        public static final Function1<String, EnterKeyType> FROM_STRING = new Function1<String, EnterKeyType>() { // from class: com.yandex.div2.DivInput$EnterKeyType$Converter$FROM_STRING$1
            @Override // kotlin.jvm.functions.Function1
            public final DivInput.EnterKeyType invoke(String value) {
                Intrinsics.checkNotNullParameter(value, "value");
                return DivInput.EnterKeyType.INSTANCE.fromString(value);
            }
        };

        EnterKeyType(String str) {
            this.value = str;
        }

        /* JADX INFO: renamed from: com.yandex.div2.DivInput$EnterKeyType$Converter, reason: from kotlin metadata */
        /* JADX INFO: compiled from: DivInput.kt */
        @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\b\u001a\u0004\u0018\u00010\u00062\u0006\u0010\t\u001a\u00020\u0005J\u000e\u0010\n\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\u0006R\u001e\u0010\u0003\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u00048\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00050\u00048\u0006X\u0087\u0004¢\u0006\u0002\n\u0000¨\u0006\f"}, d2 = {"Lcom/yandex/div2/DivInput$EnterKeyType$Converter;", "", "()V", "FROM_STRING", "Lkotlin/Function1;", "", "Lcom/yandex/div2/DivInput$EnterKeyType;", "TO_STRING", "fromString", "value", "toString", "obj", "div-data_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private Companion() {
            }

            public final String toString(EnterKeyType obj) {
                Intrinsics.checkNotNullParameter(obj, "obj");
                return obj.value;
            }

            public final EnterKeyType fromString(String value) {
                Intrinsics.checkNotNullParameter(value, "value");
                if (Intrinsics.areEqual(value, EnterKeyType.DEFAULT.value)) {
                    return EnterKeyType.DEFAULT;
                }
                if (Intrinsics.areEqual(value, EnterKeyType.GO.value)) {
                    return EnterKeyType.GO;
                }
                if (Intrinsics.areEqual(value, EnterKeyType.SEARCH.value)) {
                    return EnterKeyType.SEARCH;
                }
                if (Intrinsics.areEqual(value, EnterKeyType.SEND.value)) {
                    return EnterKeyType.SEND;
                }
                if (Intrinsics.areEqual(value, EnterKeyType.DONE.value)) {
                    return EnterKeyType.DONE;
                }
                return null;
            }
        }
    }

    /* JADX INFO: compiled from: DivInput.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\n\b\u0086\u0001\u0018\u0000 \f2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\fB\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000b¨\u0006\r"}, d2 = {"Lcom/yandex/div2/DivInput$KeyboardType;", "", "value", "", "(Ljava/lang/String;ILjava/lang/String;)V", "SINGLE_LINE_TEXT", "MULTI_LINE_TEXT", "PHONE", "NUMBER", "EMAIL", "URI", "PASSWORD", "Converter", "div-data_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public enum KeyboardType {
        SINGLE_LINE_TEXT("single_line_text"),
        MULTI_LINE_TEXT("multi_line_text"),
        PHONE("phone"),
        NUMBER("number"),
        EMAIL("email"),
        URI("uri"),
        PASSWORD(HintConstants.AUTOFILL_HINT_PASSWORD);

        private final String value;

        /* JADX INFO: renamed from: Converter, reason: from kotlin metadata */
        public static final Companion INSTANCE = new Companion(null);
        public static final Function1<KeyboardType, String> TO_STRING = new Function1<KeyboardType, String>() { // from class: com.yandex.div2.DivInput$KeyboardType$Converter$TO_STRING$1
            @Override // kotlin.jvm.functions.Function1
            public final String invoke(DivInput.KeyboardType value) {
                Intrinsics.checkNotNullParameter(value, "value");
                return DivInput.KeyboardType.INSTANCE.toString(value);
            }
        };
        public static final Function1<String, KeyboardType> FROM_STRING = new Function1<String, KeyboardType>() { // from class: com.yandex.div2.DivInput$KeyboardType$Converter$FROM_STRING$1
            @Override // kotlin.jvm.functions.Function1
            public final DivInput.KeyboardType invoke(String value) {
                Intrinsics.checkNotNullParameter(value, "value");
                return DivInput.KeyboardType.INSTANCE.fromString(value);
            }
        };

        KeyboardType(String str) {
            this.value = str;
        }

        /* JADX INFO: renamed from: com.yandex.div2.DivInput$KeyboardType$Converter, reason: from kotlin metadata */
        /* JADX INFO: compiled from: DivInput.kt */
        @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\b\u001a\u0004\u0018\u00010\u00062\u0006\u0010\t\u001a\u00020\u0005J\u000e\u0010\n\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\u0006R\u001e\u0010\u0003\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u00048\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00050\u00048\u0006X\u0087\u0004¢\u0006\u0002\n\u0000¨\u0006\f"}, d2 = {"Lcom/yandex/div2/DivInput$KeyboardType$Converter;", "", "()V", "FROM_STRING", "Lkotlin/Function1;", "", "Lcom/yandex/div2/DivInput$KeyboardType;", "TO_STRING", "fromString", "value", "toString", "obj", "div-data_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private Companion() {
            }

            public final String toString(KeyboardType obj) {
                Intrinsics.checkNotNullParameter(obj, "obj");
                return obj.value;
            }

            public final KeyboardType fromString(String value) {
                Intrinsics.checkNotNullParameter(value, "value");
                if (Intrinsics.areEqual(value, KeyboardType.SINGLE_LINE_TEXT.value)) {
                    return KeyboardType.SINGLE_LINE_TEXT;
                }
                if (Intrinsics.areEqual(value, KeyboardType.MULTI_LINE_TEXT.value)) {
                    return KeyboardType.MULTI_LINE_TEXT;
                }
                if (Intrinsics.areEqual(value, KeyboardType.PHONE.value)) {
                    return KeyboardType.PHONE;
                }
                if (Intrinsics.areEqual(value, KeyboardType.NUMBER.value)) {
                    return KeyboardType.NUMBER;
                }
                if (Intrinsics.areEqual(value, KeyboardType.EMAIL.value)) {
                    return KeyboardType.EMAIL;
                }
                if (Intrinsics.areEqual(value, KeyboardType.URI.value)) {
                    return KeyboardType.URI;
                }
                if (Intrinsics.areEqual(value, KeyboardType.PASSWORD.value)) {
                    return KeyboardType.PASSWORD;
                }
                return null;
            }
        }
    }
}
