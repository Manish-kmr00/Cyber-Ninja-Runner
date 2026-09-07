package com.yandex.div2;

import androidx.compose.material.OutlinedTextFieldKt;
import com.google.firebase.analytics.FirebaseAnalytics;
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

/* JADX INFO: compiled from: DivGrid.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000ò\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0006\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b1\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \u008c\u00012\u00020\u00012\u00020\u00022\u00020\u0003:\u0002\u008c\u0001B¿\u0005\b\u0007\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\t\u0012\u0010\b\u0002\u0010\n\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u000b\u0012\u0010\b\u0002\u0010\f\u001a\n\u0012\u0004\u0012\u00020\u000e\u0018\u00010\r\u0012\u0010\b\u0002\u0010\u000f\u001a\n\u0012\u0004\u0012\u00020\u0010\u0018\u00010\r\u0012\u000e\b\u0002\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00120\r\u0012\u0010\b\u0002\u0010\u0013\u001a\n\u0012\u0004\u0012\u00020\u0014\u0018\u00010\u000b\u0012\u0010\b\u0002\u0010\u0015\u001a\n\u0012\u0004\u0012\u00020\u0016\u0018\u00010\u000b\u0012\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u0018\u0012\f\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u001a0\r\u0012\u0010\b\u0002\u0010\u001b\u001a\n\u0012\u0004\u0012\u00020\u001a\u0018\u00010\r\u0012\u000e\b\u0002\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u000e0\r\u0012\u000e\b\u0002\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u00100\r\u0012\u0010\b\u0002\u0010\u001e\u001a\n\u0012\u0004\u0012\u00020\u001f\u0018\u00010\u000b\u0012\u0010\b\u0002\u0010 \u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u000b\u0012\u0010\b\u0002\u0010!\u001a\n\u0012\u0004\u0012\u00020\"\u0018\u00010\u000b\u0012\n\b\u0002\u0010#\u001a\u0004\u0018\u00010$\u0012\u0010\b\u0002\u0010%\u001a\n\u0012\u0004\u0012\u00020&\u0018\u00010\u000b\u0012\b\b\u0002\u0010'\u001a\u00020(\u0012\u0010\b\u0002\u0010)\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u000b\u0012\u0010\b\u0002\u0010*\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u000b\u0012\n\b\u0002\u0010+\u001a\u0004\u0018\u00010,\u0012\u0010\b\u0002\u0010-\u001a\n\u0012\u0004\u0012\u00020.\u0018\u00010\u000b\u0012\n\b\u0002\u0010/\u001a\u0004\u0018\u000100\u0012\u0010\b\u0002\u00101\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u000b\u0012\n\b\u0002\u00102\u001a\u0004\u0018\u000103\u0012\n\b\u0002\u00104\u001a\u0004\u0018\u000103\u0012\u0010\b\u0002\u00105\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u000b\u0012\u0010\b\u0002\u00106\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u000b\u0012\u0010\b\u0002\u00107\u001a\n\u0012\u0004\u0012\u00020,\u0018\u00010\r\u0012\u0010\b\u0002\u00108\u001a\n\u0012\u0004\u0012\u00020\u001a\u0018\u00010\r\u0012\u0010\b\u0002\u00109\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u000b\u0012\u0010\b\u0002\u0010:\u001a\n\u0012\u0004\u0012\u00020;\u0018\u00010\u000b\u0012\n\b\u0002\u0010<\u001a\u0004\u0018\u00010=\u0012\n\b\u0002\u0010>\u001a\u0004\u0018\u00010?\u0012\n\b\u0002\u0010@\u001a\u0004\u0018\u00010A\u0012\n\b\u0002\u0010B\u001a\u0004\u0018\u00010A\u0012\u0010\b\u0002\u0010C\u001a\n\u0012\u0004\u0012\u00020D\u0018\u00010\u000b\u0012\u0010\b\u0002\u0010E\u001a\n\u0012\u0004\u0012\u00020F\u0018\u00010\u000b\u0012\u0010\b\u0002\u0010G\u001a\n\u0012\u0004\u0012\u00020H\u0018\u00010\u000b\u0012\u000e\b\u0002\u0010I\u001a\b\u0012\u0004\u0012\u00020J0\r\u0012\n\b\u0002\u0010K\u001a\u0004\u0018\u00010L\u0012\u0010\b\u0002\u0010M\u001a\n\u0012\u0004\u0012\u00020L\u0018\u00010\u000b\u0012\b\b\u0002\u0010N\u001a\u00020(¢\u0006\u0002\u0010OJÁ\u0005\u0010\u0081\u0001\u001a\u00020\u00002\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\u0010\b\u0002\u0010\n\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u000b2\u0010\b\u0002\u0010\f\u001a\n\u0012\u0004\u0012\u00020\u000e\u0018\u00010\r2\u0010\b\u0002\u0010\u000f\u001a\n\u0012\u0004\u0012\u00020\u0010\u0018\u00010\r2\u000e\b\u0002\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00120\r2\u0010\b\u0002\u0010\u0013\u001a\n\u0012\u0004\u0012\u00020\u0014\u0018\u00010\u000b2\u0010\b\u0002\u0010\u0015\u001a\n\u0012\u0004\u0012\u00020\u0016\u0018\u00010\u000b2\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u00182\u000e\b\u0002\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u001a0\r2\u0010\b\u0002\u0010\u001b\u001a\n\u0012\u0004\u0012\u00020\u001a\u0018\u00010\r2\u000e\b\u0002\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u000e0\r2\u000e\b\u0002\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u00100\r2\u0010\b\u0002\u0010\u001e\u001a\n\u0012\u0004\u0012\u00020\u001f\u0018\u00010\u000b2\u0010\b\u0002\u0010 \u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u000b2\u0010\b\u0002\u0010!\u001a\n\u0012\u0004\u0012\u00020\"\u0018\u00010\u000b2\n\b\u0002\u0010#\u001a\u0004\u0018\u00010$2\u0010\b\u0002\u0010%\u001a\n\u0012\u0004\u0012\u00020&\u0018\u00010\u000b2\b\b\u0002\u0010'\u001a\u00020(2\u0010\b\u0002\u0010)\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u000b2\u0010\b\u0002\u0010*\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u000b2\n\b\u0002\u0010+\u001a\u0004\u0018\u00010,2\u0010\b\u0002\u0010-\u001a\n\u0012\u0004\u0012\u00020.\u0018\u00010\u000b2\n\b\u0002\u0010/\u001a\u0004\u0018\u0001002\u0010\b\u0002\u00101\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u000b2\n\b\u0002\u00102\u001a\u0004\u0018\u0001032\n\b\u0002\u00104\u001a\u0004\u0018\u0001032\u0010\b\u0002\u00105\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u000b2\u0010\b\u0002\u00106\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u000b2\u0010\b\u0002\u00107\u001a\n\u0012\u0004\u0012\u00020,\u0018\u00010\r2\u0010\b\u0002\u00108\u001a\n\u0012\u0004\u0012\u00020\u001a\u0018\u00010\r2\u0010\b\u0002\u00109\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u000b2\u0010\b\u0002\u0010:\u001a\n\u0012\u0004\u0012\u00020;\u0018\u00010\u000b2\n\b\u0002\u0010<\u001a\u0004\u0018\u00010=2\n\b\u0002\u0010>\u001a\u0004\u0018\u00010?2\n\b\u0002\u0010@\u001a\u0004\u0018\u00010A2\n\b\u0002\u0010B\u001a\u0004\u0018\u00010A2\u0010\b\u0002\u0010C\u001a\n\u0012\u0004\u0012\u00020D\u0018\u00010\u000b2\u0010\b\u0002\u0010E\u001a\n\u0012\u0004\u0012\u00020F\u0018\u00010\u000b2\u0010\b\u0002\u0010G\u001a\n\u0012\u0004\u0012\u00020H\u0018\u00010\u000b2\u000e\b\u0002\u0010I\u001a\b\u0012\u0004\u0012\u00020J0\r2\n\b\u0002\u0010K\u001a\u0004\u0018\u00010L2\u0010\b\u0002\u0010M\u001a\n\u0012\u0004\u0012\u00020L\u0018\u00010\u000b2\b\b\u0002\u0010N\u001a\u00020(J'\u0010\u0082\u0001\u001a\u00030\u0083\u00012\t\u0010\u0084\u0001\u001a\u0004\u0018\u00010\u00002\b\u0010\u0085\u0001\u001a\u00030\u0086\u00012\b\u0010\u0087\u0001\u001a\u00030\u0086\u0001J\t\u0010\u0088\u0001\u001a\u00020QH\u0016J\t\u0010\u0089\u0001\u001a\u00020QH\u0016J\n\u0010\u008a\u0001\u001a\u00030\u008b\u0001H\u0016R\u0012\u0010P\u001a\u0004\u0018\u00010QX\u0082\u000e¢\u0006\u0004\n\u0002\u0010RR\u0012\u0010S\u001a\u0004\u0018\u00010QX\u0082\u000e¢\u0006\u0004\n\u0002\u0010RR\u0016\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\bT\u0010UR\u0012\u0010\u0006\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u00020\t8\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0018\u0010\n\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u000b8\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\f\u001a\n\u0012\u0004\u0012\u00020\u000e\u0018\u00010\rX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\bV\u0010WR\u001c\u0010\u000f\u001a\n\u0012\u0004\u0012\u00020\u0010\u0018\u00010\rX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\bX\u0010WR\u001a\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00120\rX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\bY\u0010WR\u001c\u0010\u0013\u001a\n\u0012\u0004\u0012\u00020\u0014\u0018\u00010\u000bX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\bZ\u0010[R\u001c\u0010\u0015\u001a\n\u0012\u0004\u0012\u00020\u0016\u0018\u00010\u000bX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\\\u0010[R\u0016\u0010\u0017\u001a\u0004\u0018\u00010\u0018X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b]\u0010^R\u0016\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u001a0\r8\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\u001b\u001a\n\u0012\u0004\u0012\u00020\u001a\u0018\u00010\rX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b_\u0010WR\u0016\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u000e0\r8\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u00100\r8\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\u001e\u001a\n\u0012\u0004\u0012\u00020\u001f\u0018\u00010\u000bX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b`\u0010[R\u0018\u0010 \u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u000b8\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u001c\u0010!\u001a\n\u0012\u0004\u0012\u00020\"\u0018\u00010\u000bX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\ba\u0010[R\u0016\u0010#\u001a\u0004\u0018\u00010$X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\bb\u0010cR\u001c\u0010%\u001a\n\u0012\u0004\u0012\u00020&\u0018\u00010\u000bX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\bd\u0010[R\u0014\u0010'\u001a\u00020(X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\be\u0010fR\u0018\u0010)\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u000b8\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0018\u0010*\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u000b8\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0016\u0010+\u001a\u0004\u0018\u00010,X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\bg\u0010hR\u0018\u0010-\u001a\n\u0012\u0004\u0012\u00020.\u0018\u00010\u000b8\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0016\u0010/\u001a\u0004\u0018\u000100X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\bi\u0010jR\u0018\u00101\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u000b8\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0016\u00102\u001a\u0004\u0018\u000103X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\bk\u0010lR\u0016\u00104\u001a\u0004\u0018\u000103X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\bm\u0010lR\u0018\u00105\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u000b8\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0018\u00106\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u000b8\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u001c\u00107\u001a\n\u0012\u0004\u0012\u00020,\u0018\u00010\rX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\bn\u0010WR\u001c\u00108\u001a\n\u0012\u0004\u0012\u00020\u001a\u0018\u00010\rX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\bo\u0010WR\u001c\u00109\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u000bX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\bp\u0010[R\u001c\u0010:\u001a\n\u0012\u0004\u0012\u00020;\u0018\u00010\u000bX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\bq\u0010[R\u0016\u0010<\u001a\u0004\u0018\u00010=X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\br\u0010sR\u0016\u0010>\u001a\u0004\u0018\u00010?X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\bt\u0010uR\u0016\u0010@\u001a\u0004\u0018\u00010AX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\bv\u0010wR\u0016\u0010B\u001a\u0004\u0018\u00010AX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\bx\u0010wR\u001c\u0010C\u001a\n\u0012\u0004\u0012\u00020D\u0018\u00010\u000bX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\by\u0010[R\u001c\u0010E\u001a\n\u0012\u0004\u0012\u00020F\u0018\u00010\u000bX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\bz\u0010[R\u001c\u0010G\u001a\n\u0012\u0004\u0012\u00020H\u0018\u00010\u000bX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b{\u0010[R\u001a\u0010I\u001a\b\u0012\u0004\u0012\u00020J0\rX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b|\u0010WR\u0016\u0010K\u001a\u0004\u0018\u00010LX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b}\u0010~R\u001c\u0010M\u001a\n\u0012\u0004\u0012\u00020L\u0018\u00010\u000bX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u007f\u0010[R\u0015\u0010N\u001a\u00020(X\u0096\u0004¢\u0006\t\n\u0000\u001a\u0005\b\u0080\u0001\u0010f¨\u0006\u008d\u0001"}, d2 = {"Lcom/yandex/div2/DivGrid;", "Lcom/yandex/div/json/JSONSerializable;", "Lcom/yandex/div/data/Hashable;", "Lcom/yandex/div2/DivBase;", "accessibility", "Lcom/yandex/div2/DivAccessibility;", "action", "Lcom/yandex/div2/DivAction;", "actionAnimation", "Lcom/yandex/div2/DivAnimation;", "actions", "", "alignmentHorizontal", "Lcom/yandex/div/json/expressions/Expression;", "Lcom/yandex/div2/DivAlignmentHorizontal;", "alignmentVertical", "Lcom/yandex/div2/DivAlignmentVertical;", "alpha", "", "animators", "Lcom/yandex/div2/DivAnimator;", J2.g, "Lcom/yandex/div2/DivBackground;", OutlinedTextFieldKt.BorderId, "Lcom/yandex/div2/DivBorder;", "columnCount", "", "columnSpan", "contentAlignmentHorizontal", "contentAlignmentVertical", "disappearActions", "Lcom/yandex/div2/DivDisappearAction;", "doubletapActions", "extensions", "Lcom/yandex/div2/DivExtension;", "focus", "Lcom/yandex/div2/DivFocus;", "functions", "Lcom/yandex/div2/DivFunction;", "height", "Lcom/yandex/div2/DivSize;", "hoverEndActions", "hoverStartActions", "id", "", FirebaseAnalytics.Param.ITEMS, "Lcom/yandex/div2/Div;", "layoutProvider", "Lcom/yandex/div2/DivLayoutProvider;", "longtapActions", "margins", "Lcom/yandex/div2/DivEdgeInsets;", "paddings", "pressEndActions", "pressStartActions", "reuseId", "rowSpan", "selectedActions", "tooltips", "Lcom/yandex/div2/DivTooltip;", "transform", "Lcom/yandex/div2/DivTransform;", "transitionChange", "Lcom/yandex/div2/DivChangeTransition;", "transitionIn", "Lcom/yandex/div2/DivAppearanceTransition;", "transitionOut", "transitionTriggers", "Lcom/yandex/div2/DivTransitionTrigger;", "variableTriggers", "Lcom/yandex/div2/DivTrigger;", "variables", "Lcom/yandex/div2/DivVariable;", "visibility", "Lcom/yandex/div2/DivVisibility;", "visibilityAction", "Lcom/yandex/div2/DivVisibilityAction;", "visibilityActions", "width", "(Lcom/yandex/div2/DivAccessibility;Lcom/yandex/div2/DivAction;Lcom/yandex/div2/DivAnimation;Ljava/util/List;Lcom/yandex/div/json/expressions/Expression;Lcom/yandex/div/json/expressions/Expression;Lcom/yandex/div/json/expressions/Expression;Ljava/util/List;Ljava/util/List;Lcom/yandex/div2/DivBorder;Lcom/yandex/div/json/expressions/Expression;Lcom/yandex/div/json/expressions/Expression;Lcom/yandex/div/json/expressions/Expression;Lcom/yandex/div/json/expressions/Expression;Ljava/util/List;Ljava/util/List;Ljava/util/List;Lcom/yandex/div2/DivFocus;Ljava/util/List;Lcom/yandex/div2/DivSize;Ljava/util/List;Ljava/util/List;Ljava/lang/String;Ljava/util/List;Lcom/yandex/div2/DivLayoutProvider;Ljava/util/List;Lcom/yandex/div2/DivEdgeInsets;Lcom/yandex/div2/DivEdgeInsets;Ljava/util/List;Ljava/util/List;Lcom/yandex/div/json/expressions/Expression;Lcom/yandex/div/json/expressions/Expression;Ljava/util/List;Ljava/util/List;Lcom/yandex/div2/DivTransform;Lcom/yandex/div2/DivChangeTransition;Lcom/yandex/div2/DivAppearanceTransition;Lcom/yandex/div2/DivAppearanceTransition;Ljava/util/List;Ljava/util/List;Ljava/util/List;Lcom/yandex/div/json/expressions/Expression;Lcom/yandex/div2/DivVisibilityAction;Ljava/util/List;Lcom/yandex/div2/DivSize;)V", "_hash", "", "Ljava/lang/Integer;", "_propertiesHash", "getAccessibility", "()Lcom/yandex/div2/DivAccessibility;", "getAlignmentHorizontal", "()Lcom/yandex/div/json/expressions/Expression;", "getAlignmentVertical", "getAlpha", "getAnimators", "()Ljava/util/List;", "getBackground", "getBorder", "()Lcom/yandex/div2/DivBorder;", "getColumnSpan", "getDisappearActions", "getExtensions", "getFocus", "()Lcom/yandex/div2/DivFocus;", "getFunctions", "getHeight", "()Lcom/yandex/div2/DivSize;", "getId", "()Ljava/lang/String;", "getLayoutProvider", "()Lcom/yandex/div2/DivLayoutProvider;", "getMargins", "()Lcom/yandex/div2/DivEdgeInsets;", "getPaddings", "getReuseId", "getRowSpan", "getSelectedActions", "getTooltips", "getTransform", "()Lcom/yandex/div2/DivTransform;", "getTransitionChange", "()Lcom/yandex/div2/DivChangeTransition;", "getTransitionIn", "()Lcom/yandex/div2/DivAppearanceTransition;", "getTransitionOut", "getTransitionTriggers", "getVariableTriggers", "getVariables", "getVisibility", "getVisibilityAction", "()Lcom/yandex/div2/DivVisibilityAction;", "getVisibilityActions", "getWidth", "copy", "equals", "", "other", "resolver", "Lcom/yandex/div/json/expressions/ExpressionResolver;", "otherResolver", "hash", "propertiesHash", "writeToJSON", "Lorg/json/JSONObject;", "Companion", "div-data_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class DivGrid implements JSONSerializable, Hashable, DivBase {
    private static final DivAnimation ACTION_ANIMATION_DEFAULT_VALUE;
    private static final Expression<Double> ALPHA_DEFAULT_VALUE;
    private static final Expression<DivAlignmentHorizontal> CONTENT_ALIGNMENT_HORIZONTAL_DEFAULT_VALUE;
    private static final Expression<DivAlignmentVertical> CONTENT_ALIGNMENT_VERTICAL_DEFAULT_VALUE;
    private static final Function2<ParsingEnvironment, JSONObject, DivGrid> CREATOR;

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final DivSize.WrapContent HEIGHT_DEFAULT_VALUE;
    public static final String TYPE = "grid";
    private static final Expression<DivVisibility> VISIBILITY_DEFAULT_VALUE;
    private static final DivSize.MatchParent WIDTH_DEFAULT_VALUE;
    private Integer _hash;
    private Integer _propertiesHash;
    private final DivAccessibility accessibility;
    public final DivAction action;
    public final DivAnimation actionAnimation;
    public final List<DivAction> actions;
    private final Expression<DivAlignmentHorizontal> alignmentHorizontal;
    private final Expression<DivAlignmentVertical> alignmentVertical;
    private final Expression<Double> alpha;
    private final List<DivAnimator> animators;
    private final List<DivBackground> background;
    private final DivBorder border;
    public final Expression<Long> columnCount;
    private final Expression<Long> columnSpan;
    public final Expression<DivAlignmentHorizontal> contentAlignmentHorizontal;
    public final Expression<DivAlignmentVertical> contentAlignmentVertical;
    private final List<DivDisappearAction> disappearActions;
    public final List<DivAction> doubletapActions;
    private final List<DivExtension> extensions;
    private final DivFocus focus;
    private final List<DivFunction> functions;
    private final DivSize height;
    public final List<DivAction> hoverEndActions;
    public final List<DivAction> hoverStartActions;
    private final String id;
    public final List<Div> items;
    private final DivLayoutProvider layoutProvider;
    public final List<DivAction> longtapActions;
    private final DivEdgeInsets margins;
    private final DivEdgeInsets paddings;
    public final List<DivAction> pressEndActions;
    public final List<DivAction> pressStartActions;
    private final Expression<String> reuseId;
    private final Expression<Long> rowSpan;
    private final List<DivAction> selectedActions;
    private final List<DivTooltip> tooltips;
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

    @JvmStatic
    public static final DivGrid fromJson(ParsingEnvironment parsingEnvironment, JSONObject jSONObject) {
        return INSTANCE.fromJson(parsingEnvironment, jSONObject);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public DivGrid(DivAccessibility divAccessibility, DivAction divAction, DivAnimation actionAnimation, List<DivAction> list, Expression<DivAlignmentHorizontal> expression, Expression<DivAlignmentVertical> expression2, Expression<Double> alpha, List<? extends DivAnimator> list2, List<? extends DivBackground> list3, DivBorder divBorder, Expression<Long> columnCount, Expression<Long> expression3, Expression<DivAlignmentHorizontal> contentAlignmentHorizontal, Expression<DivAlignmentVertical> contentAlignmentVertical, List<DivDisappearAction> list4, List<DivAction> list5, List<DivExtension> list6, DivFocus divFocus, List<DivFunction> list7, DivSize height, List<DivAction> list8, List<DivAction> list9, String str, List<? extends Div> list10, DivLayoutProvider divLayoutProvider, List<DivAction> list11, DivEdgeInsets divEdgeInsets, DivEdgeInsets divEdgeInsets2, List<DivAction> list12, List<DivAction> list13, Expression<String> expression4, Expression<Long> expression5, List<DivAction> list14, List<DivTooltip> list15, DivTransform divTransform, DivChangeTransition divChangeTransition, DivAppearanceTransition divAppearanceTransition, DivAppearanceTransition divAppearanceTransition2, List<? extends DivTransitionTrigger> list16, List<DivTrigger> list17, List<? extends DivVariable> list18, Expression<DivVisibility> visibility, DivVisibilityAction divVisibilityAction, List<DivVisibilityAction> list19, DivSize width) {
        Intrinsics.checkNotNullParameter(actionAnimation, "actionAnimation");
        Intrinsics.checkNotNullParameter(alpha, "alpha");
        Intrinsics.checkNotNullParameter(columnCount, "columnCount");
        Intrinsics.checkNotNullParameter(contentAlignmentHorizontal, "contentAlignmentHorizontal");
        Intrinsics.checkNotNullParameter(contentAlignmentVertical, "contentAlignmentVertical");
        Intrinsics.checkNotNullParameter(height, "height");
        Intrinsics.checkNotNullParameter(visibility, "visibility");
        Intrinsics.checkNotNullParameter(width, "width");
        this.accessibility = divAccessibility;
        this.action = divAction;
        this.actionAnimation = actionAnimation;
        this.actions = list;
        this.alignmentHorizontal = expression;
        this.alignmentVertical = expression2;
        this.alpha = alpha;
        this.animators = list2;
        this.background = list3;
        this.border = divBorder;
        this.columnCount = columnCount;
        this.columnSpan = expression3;
        this.contentAlignmentHorizontal = contentAlignmentHorizontal;
        this.contentAlignmentVertical = contentAlignmentVertical;
        this.disappearActions = list4;
        this.doubletapActions = list5;
        this.extensions = list6;
        this.focus = divFocus;
        this.functions = list7;
        this.height = height;
        this.hoverEndActions = list8;
        this.hoverStartActions = list9;
        this.id = str;
        this.items = list10;
        this.layoutProvider = divLayoutProvider;
        this.longtapActions = list11;
        this.margins = divEdgeInsets;
        this.paddings = divEdgeInsets2;
        this.pressEndActions = list12;
        this.pressStartActions = list13;
        this.reuseId = expression4;
        this.rowSpan = expression5;
        this.selectedActions = list14;
        this.tooltips = list15;
        this.transform = divTransform;
        this.transitionChange = divChangeTransition;
        this.transitionIn = divAppearanceTransition;
        this.transitionOut = divAppearanceTransition2;
        this.transitionTriggers = list16;
        this.variableTriggers = list17;
        this.variables = list18;
        this.visibility = visibility;
        this.visibilityAction = divVisibilityAction;
        this.visibilityActions = list19;
        this.width = width;
    }

    @Override // com.yandex.div2.DivBase
    public DivAccessibility getAccessibility() {
        return this.accessibility;
    }

    public /* synthetic */ DivGrid(DivAccessibility divAccessibility, DivAction divAction, DivAnimation divAnimation, List list, Expression expression, Expression expression2, Expression expression3, List list2, List list3, DivBorder divBorder, Expression expression4, Expression expression5, Expression expression6, Expression expression7, List list4, List list5, List list6, DivFocus divFocus, List list7, DivSize divSize, List list8, List list9, String str, List list10, DivLayoutProvider divLayoutProvider, List list11, DivEdgeInsets divEdgeInsets, DivEdgeInsets divEdgeInsets2, List list12, List list13, Expression expression8, Expression expression9, List list14, List list15, DivTransform divTransform, DivChangeTransition divChangeTransition, DivAppearanceTransition divAppearanceTransition, DivAppearanceTransition divAppearanceTransition2, List list16, List list17, List list18, Expression expression10, DivVisibilityAction divVisibilityAction, List list19, DivSize divSize2, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : divAccessibility, (i & 2) != 0 ? null : divAction, (i & 4) != 0 ? ACTION_ANIMATION_DEFAULT_VALUE : divAnimation, (i & 8) != 0 ? null : list, (i & 16) != 0 ? null : expression, (i & 32) != 0 ? null : expression2, (i & 64) != 0 ? ALPHA_DEFAULT_VALUE : expression3, (i & 128) != 0 ? null : list2, (i & 256) != 0 ? null : list3, (i & 512) != 0 ? null : divBorder, expression4, (i & 2048) != 0 ? null : expression5, (i & 4096) != 0 ? CONTENT_ALIGNMENT_HORIZONTAL_DEFAULT_VALUE : expression6, (i & 8192) != 0 ? CONTENT_ALIGNMENT_VERTICAL_DEFAULT_VALUE : expression7, (i & 16384) != 0 ? null : list4, (32768 & i) != 0 ? null : list5, (65536 & i) != 0 ? null : list6, (131072 & i) != 0 ? null : divFocus, (262144 & i) != 0 ? null : list7, (524288 & i) != 0 ? HEIGHT_DEFAULT_VALUE : divSize, (1048576 & i) != 0 ? null : list8, (2097152 & i) != 0 ? null : list9, (4194304 & i) != 0 ? null : str, (8388608 & i) != 0 ? null : list10, (16777216 & i) != 0 ? null : divLayoutProvider, (33554432 & i) != 0 ? null : list11, (67108864 & i) != 0 ? null : divEdgeInsets, (134217728 & i) != 0 ? null : divEdgeInsets2, (268435456 & i) != 0 ? null : list12, (536870912 & i) != 0 ? null : list13, (1073741824 & i) != 0 ? null : expression8, (i & Integer.MIN_VALUE) != 0 ? null : expression9, (i2 & 1) != 0 ? null : list14, (i2 & 2) != 0 ? null : list15, (i2 & 4) != 0 ? null : divTransform, (i2 & 8) != 0 ? null : divChangeTransition, (i2 & 16) != 0 ? null : divAppearanceTransition, (i2 & 32) != 0 ? null : divAppearanceTransition2, (i2 & 64) != 0 ? null : list16, (i2 & 128) != 0 ? null : list17, (i2 & 256) != 0 ? null : list18, (i2 & 512) != 0 ? VISIBILITY_DEFAULT_VALUE : expression10, (i2 & 1024) != 0 ? null : divVisibilityAction, (i2 & 2048) != 0 ? null : list19, (i2 & 4096) != 0 ? WIDTH_DEFAULT_VALUE : divSize2);
    }

    @Override // com.yandex.div2.DivBase
    public Expression<DivAlignmentHorizontal> getAlignmentHorizontal() {
        return this.alignmentHorizontal;
    }

    @Override // com.yandex.div2.DivBase
    public Expression<DivAlignmentVertical> getAlignmentVertical() {
        return this.alignmentVertical;
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
        int iHash10;
        int iHash11;
        int iHash12;
        int iHash13;
        int iHash14;
        int iHash15;
        int iHash16;
        Integer num = this._propertiesHash;
        if (num != null) {
            return num.intValue();
        }
        int iHashCode = Reflection.getOrCreateKotlinClass(getClass()).hashCode();
        DivAccessibility accessibility = getAccessibility();
        int iHash17 = 0;
        int iHash18 = iHashCode + (accessibility != null ? accessibility.hash() : 0);
        DivAction divAction = this.action;
        int iHash19 = iHash18 + (divAction != null ? divAction.hash() : 0) + this.actionAnimation.hash();
        List<DivAction> list = this.actions;
        if (list != null) {
            Iterator<T> it = list.iterator();
            iHash = 0;
            while (it.hasNext()) {
                iHash += ((DivAction) it.next()).hash();
            }
        } else {
            iHash = 0;
        }
        int i = iHash19 + iHash;
        Expression<DivAlignmentHorizontal> alignmentHorizontal = getAlignmentHorizontal();
        int iHashCode2 = i + (alignmentHorizontal != null ? alignmentHorizontal.hashCode() : 0);
        Expression<DivAlignmentVertical> alignmentVertical = getAlignmentVertical();
        int iHashCode3 = iHashCode2 + (alignmentVertical != null ? alignmentVertical.hashCode() : 0) + getAlpha().hashCode();
        List<DivAnimator> animators = getAnimators();
        if (animators != null) {
            Iterator<T> it2 = animators.iterator();
            iHash2 = 0;
            while (it2.hasNext()) {
                iHash2 += ((DivAnimator) it2.next()).hash();
            }
        } else {
            iHash2 = 0;
        }
        int i2 = iHashCode3 + iHash2;
        List<DivBackground> background = getBackground();
        if (background != null) {
            Iterator<T> it3 = background.iterator();
            iHash3 = 0;
            while (it3.hasNext()) {
                iHash3 += ((DivBackground) it3.next()).hash();
            }
        } else {
            iHash3 = 0;
        }
        int i3 = i2 + iHash3;
        DivBorder border = getBorder();
        int iHash20 = i3 + (border != null ? border.hash() : 0) + this.columnCount.hashCode();
        Expression<Long> columnSpan = getColumnSpan();
        int iHashCode4 = iHash20 + (columnSpan != null ? columnSpan.hashCode() : 0) + this.contentAlignmentHorizontal.hashCode() + this.contentAlignmentVertical.hashCode();
        List<DivDisappearAction> disappearActions = getDisappearActions();
        if (disappearActions != null) {
            Iterator<T> it4 = disappearActions.iterator();
            iHash4 = 0;
            while (it4.hasNext()) {
                iHash4 += ((DivDisappearAction) it4.next()).hash();
            }
        } else {
            iHash4 = 0;
        }
        int i4 = iHashCode4 + iHash4;
        List<DivAction> list2 = this.doubletapActions;
        if (list2 != null) {
            Iterator<T> it5 = list2.iterator();
            iHash5 = 0;
            while (it5.hasNext()) {
                iHash5 += ((DivAction) it5.next()).hash();
            }
        } else {
            iHash5 = 0;
        }
        int i5 = i4 + iHash5;
        List<DivExtension> extensions = getExtensions();
        if (extensions != null) {
            Iterator<T> it6 = extensions.iterator();
            iHash6 = 0;
            while (it6.hasNext()) {
                iHash6 += ((DivExtension) it6.next()).hash();
            }
        } else {
            iHash6 = 0;
        }
        int i6 = i5 + iHash6;
        DivFocus focus = getFocus();
        int iHash21 = i6 + (focus != null ? focus.hash() : 0);
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
        int iHash22 = iHash21 + iHash7 + getHeight().hash();
        List<DivAction> list3 = this.hoverEndActions;
        if (list3 != null) {
            Iterator<T> it8 = list3.iterator();
            iHash8 = 0;
            while (it8.hasNext()) {
                iHash8 += ((DivAction) it8.next()).hash();
            }
        } else {
            iHash8 = 0;
        }
        int i7 = iHash22 + iHash8;
        List<DivAction> list4 = this.hoverStartActions;
        if (list4 != null) {
            Iterator<T> it9 = list4.iterator();
            iHash9 = 0;
            while (it9.hasNext()) {
                iHash9 += ((DivAction) it9.next()).hash();
            }
        } else {
            iHash9 = 0;
        }
        int i8 = i7 + iHash9;
        String id = getId();
        int iHashCode5 = i8 + (id != null ? id.hashCode() : 0);
        DivLayoutProvider layoutProvider = getLayoutProvider();
        int iHash23 = iHashCode5 + (layoutProvider != null ? layoutProvider.hash() : 0);
        List<DivAction> list5 = this.longtapActions;
        if (list5 != null) {
            Iterator<T> it10 = list5.iterator();
            iHash10 = 0;
            while (it10.hasNext()) {
                iHash10 += ((DivAction) it10.next()).hash();
            }
        } else {
            iHash10 = 0;
        }
        int i9 = iHash23 + iHash10;
        DivEdgeInsets margins = getMargins();
        int iHash24 = i9 + (margins != null ? margins.hash() : 0);
        DivEdgeInsets paddings = getPaddings();
        int iHash25 = iHash24 + (paddings != null ? paddings.hash() : 0);
        List<DivAction> list6 = this.pressEndActions;
        if (list6 != null) {
            Iterator<T> it11 = list6.iterator();
            iHash11 = 0;
            while (it11.hasNext()) {
                iHash11 += ((DivAction) it11.next()).hash();
            }
        } else {
            iHash11 = 0;
        }
        int i10 = iHash25 + iHash11;
        List<DivAction> list7 = this.pressStartActions;
        if (list7 != null) {
            Iterator<T> it12 = list7.iterator();
            iHash12 = 0;
            while (it12.hasNext()) {
                iHash12 += ((DivAction) it12.next()).hash();
            }
        } else {
            iHash12 = 0;
        }
        int i11 = i10 + iHash12;
        Expression<String> reuseId = getReuseId();
        int iHashCode6 = i11 + (reuseId != null ? reuseId.hashCode() : 0);
        Expression<Long> rowSpan = getRowSpan();
        int iHashCode7 = iHashCode6 + (rowSpan != null ? rowSpan.hashCode() : 0);
        List<DivAction> selectedActions = getSelectedActions();
        if (selectedActions != null) {
            Iterator<T> it13 = selectedActions.iterator();
            iHash13 = 0;
            while (it13.hasNext()) {
                iHash13 += ((DivAction) it13.next()).hash();
            }
        } else {
            iHash13 = 0;
        }
        int i12 = iHashCode7 + iHash13;
        List<DivTooltip> tooltips = getTooltips();
        if (tooltips != null) {
            Iterator<T> it14 = tooltips.iterator();
            iHash14 = 0;
            while (it14.hasNext()) {
                iHash14 += ((DivTooltip) it14.next()).hash();
            }
        } else {
            iHash14 = 0;
        }
        int i13 = i12 + iHash14;
        DivTransform transform = getTransform();
        int iHash26 = i13 + (transform != null ? transform.hash() : 0);
        DivChangeTransition transitionChange = getTransitionChange();
        int iHash27 = iHash26 + (transitionChange != null ? transitionChange.hash() : 0);
        DivAppearanceTransition transitionIn = getTransitionIn();
        int iHash28 = iHash27 + (transitionIn != null ? transitionIn.hash() : 0);
        DivAppearanceTransition transitionOut = getTransitionOut();
        int iHash29 = iHash28 + (transitionOut != null ? transitionOut.hash() : 0);
        List<DivTransitionTrigger> transitionTriggers = getTransitionTriggers();
        int iHashCode8 = iHash29 + (transitionTriggers != null ? transitionTriggers.hashCode() : 0);
        List<DivTrigger> variableTriggers = getVariableTriggers();
        if (variableTriggers != null) {
            Iterator<T> it15 = variableTriggers.iterator();
            iHash15 = 0;
            while (it15.hasNext()) {
                iHash15 += ((DivTrigger) it15.next()).hash();
            }
        } else {
            iHash15 = 0;
        }
        int i14 = iHashCode8 + iHash15;
        List<DivVariable> variables = getVariables();
        if (variables != null) {
            Iterator<T> it16 = variables.iterator();
            iHash16 = 0;
            while (it16.hasNext()) {
                iHash16 += ((DivVariable) it16.next()).hash();
            }
        } else {
            iHash16 = 0;
        }
        int iHashCode9 = i14 + iHash16 + getVisibility().hashCode();
        DivVisibilityAction visibilityAction = getVisibilityAction();
        int iHash30 = iHashCode9 + (visibilityAction != null ? visibilityAction.hash() : 0);
        List<DivVisibilityAction> visibilityActions = getVisibilityActions();
        if (visibilityActions != null) {
            Iterator<T> it17 = visibilityActions.iterator();
            while (it17.hasNext()) {
                iHash17 += ((DivVisibilityAction) it17.next()).hash();
            }
        }
        int iHash31 = iHash30 + iHash17 + getWidth().hash();
        this._propertiesHash = Integer.valueOf(iHash31);
        return iHash31;
    }

    @Override // com.yandex.div.data.Hashable
    public int hash() {
        Integer num = this._hash;
        if (num != null) {
            return num.intValue();
        }
        int iPropertiesHash = propertiesHash();
        List<Div> list = this.items;
        int iHash = 0;
        if (list != null) {
            Iterator<T> it = list.iterator();
            while (it.hasNext()) {
                iHash += ((Div) it.next()).hash();
            }
        }
        int i = iPropertiesHash + iHash;
        this._hash = Integer.valueOf(i);
        return i;
    }

    public final boolean equals(DivGrid other, ExpressionResolver resolver, ExpressionResolver otherResolver) {
        boolean zEquals;
        boolean zEquals2;
        boolean z;
        boolean z2;
        boolean z3;
        boolean zEquals3;
        boolean z4;
        boolean z5;
        boolean z6;
        boolean zEquals4;
        boolean z7;
        boolean z8;
        boolean z9;
        boolean z10;
        boolean zEquals5;
        boolean z11;
        boolean zEquals6;
        boolean zEquals7;
        boolean z12;
        boolean z13;
        boolean z14;
        boolean z15;
        boolean zEquals8;
        boolean zEquals9;
        boolean zEquals10;
        boolean zEquals11;
        boolean z16;
        boolean z17;
        boolean z18;
        boolean zEquals12;
        boolean z19;
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
        DivAction divAction = this.action;
        if (divAction != null) {
            zEquals2 = divAction.equals(other.action, resolver, otherResolver);
        } else {
            zEquals2 = other.action == null;
        }
        if (!zEquals2 || !this.actionAnimation.equals(other.actionAnimation, resolver, otherResolver)) {
            return false;
        }
        List<DivAction> list = this.actions;
        if (list != null) {
            List<DivAction> list2 = other.actions;
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
        } else {
            z = other.actions == null;
        }
        if (!z) {
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
                Iterator<T> it2 = animators.iterator();
                int i3 = 0;
                while (true) {
                    if (it2.hasNext()) {
                        Object next2 = it2.next();
                        int i4 = i3 + 1;
                        if (i3 < 0) {
                            CollectionsKt.throwIndexOverflow();
                        }
                        if (((DivAnimator) next2).equals(animators2.get(i3), resolver, otherResolver)) {
                            i3 = i4;
                        }
                    }
                }
            }
        } else {
            z2 = other.getAnimators() == null;
        }
        if (!z2) {
            return false;
        }
        List<DivBackground> background = getBackground();
        if (background != null) {
            List<DivBackground> background2 = other.getBackground();
            if (background2 == null) {
                return false;
            }
            if (background.size() == background2.size()) {
                Iterator<T> it3 = background.iterator();
                int i5 = 0;
                while (true) {
                    if (it3.hasNext()) {
                        Object next3 = it3.next();
                        int i6 = i5 + 1;
                        if (i5 < 0) {
                            CollectionsKt.throwIndexOverflow();
                        }
                        if (((DivBackground) next3).equals(background2.get(i5), resolver, otherResolver)) {
                            i5 = i6;
                        }
                    }
                }
            }
        } else {
            z3 = other.getBackground() == null;
        }
        if (!z3) {
            return false;
        }
        DivBorder border = getBorder();
        if (border != null) {
            zEquals3 = border.equals(other.getBorder(), resolver, otherResolver);
        } else {
            zEquals3 = other.getBorder() == null;
        }
        if (!zEquals3 || this.columnCount.evaluate(resolver).longValue() != other.columnCount.evaluate(otherResolver).longValue()) {
            return false;
        }
        Expression<Long> columnSpan = getColumnSpan();
        Long lEvaluate = columnSpan != null ? columnSpan.evaluate(resolver) : null;
        Expression<Long> columnSpan2 = other.getColumnSpan();
        if (!Intrinsics.areEqual(lEvaluate, columnSpan2 != null ? columnSpan2.evaluate(otherResolver) : null) || this.contentAlignmentHorizontal.evaluate(resolver) != other.contentAlignmentHorizontal.evaluate(otherResolver) || this.contentAlignmentVertical.evaluate(resolver) != other.contentAlignmentVertical.evaluate(otherResolver)) {
            return false;
        }
        List<DivDisappearAction> disappearActions = getDisappearActions();
        if (disappearActions != null) {
            List<DivDisappearAction> disappearActions2 = other.getDisappearActions();
            if (disappearActions2 == null) {
                return false;
            }
            if (disappearActions.size() == disappearActions2.size()) {
                Iterator<T> it4 = disappearActions.iterator();
                int i7 = 0;
                while (true) {
                    if (it4.hasNext()) {
                        Object next4 = it4.next();
                        int i8 = i7 + 1;
                        if (i7 < 0) {
                            CollectionsKt.throwIndexOverflow();
                        }
                        if (((DivDisappearAction) next4).equals(disappearActions2.get(i7), resolver, otherResolver)) {
                            i7 = i8;
                        }
                    }
                }
            }
        } else {
            z4 = other.getDisappearActions() == null;
        }
        if (!z4) {
            return false;
        }
        List<DivAction> list3 = this.doubletapActions;
        if (list3 != null) {
            List<DivAction> list4 = other.doubletapActions;
            if (list4 == null) {
                return false;
            }
            if (list3.size() == list4.size()) {
                Iterator<T> it5 = list3.iterator();
                int i9 = 0;
                while (true) {
                    if (it5.hasNext()) {
                        Object next5 = it5.next();
                        int i10 = i9 + 1;
                        if (i9 < 0) {
                            CollectionsKt.throwIndexOverflow();
                        }
                        if (((DivAction) next5).equals(list4.get(i9), resolver, otherResolver)) {
                            i9 = i10;
                        }
                    }
                }
            }
        } else {
            z5 = other.doubletapActions == null;
        }
        if (!z5) {
            return false;
        }
        List<DivExtension> extensions = getExtensions();
        if (extensions != null) {
            List<DivExtension> extensions2 = other.getExtensions();
            if (extensions2 == null) {
                return false;
            }
            if (extensions.size() == extensions2.size()) {
                Iterator<T> it6 = extensions.iterator();
                int i11 = 0;
                while (true) {
                    if (it6.hasNext()) {
                        Object next6 = it6.next();
                        int i12 = i11 + 1;
                        if (i11 < 0) {
                            CollectionsKt.throwIndexOverflow();
                        }
                        if (((DivExtension) next6).equals(extensions2.get(i11), resolver, otherResolver)) {
                            i11 = i12;
                        }
                    }
                }
            }
        } else {
            z6 = other.getExtensions() == null;
        }
        if (!z6) {
            return false;
        }
        DivFocus focus = getFocus();
        if (focus != null) {
            zEquals4 = focus.equals(other.getFocus(), resolver, otherResolver);
        } else {
            zEquals4 = other.getFocus() == null;
        }
        if (!zEquals4) {
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
        List<DivAction> list5 = this.hoverEndActions;
        if (list5 != null) {
            List<DivAction> list6 = other.hoverEndActions;
            if (list6 == null) {
                return false;
            }
            if (list5.size() == list6.size()) {
                Iterator<T> it8 = list5.iterator();
                int i15 = 0;
                while (true) {
                    if (it8.hasNext()) {
                        Object next8 = it8.next();
                        int i16 = i15 + 1;
                        if (i15 < 0) {
                            CollectionsKt.throwIndexOverflow();
                        }
                        if (((DivAction) next8).equals(list6.get(i15), resolver, otherResolver)) {
                            i15 = i16;
                        }
                    }
                }
            }
        } else {
            z8 = other.hoverEndActions == null;
        }
        if (!z8) {
            return false;
        }
        List<DivAction> list7 = this.hoverStartActions;
        if (list7 != null) {
            List<DivAction> list8 = other.hoverStartActions;
            if (list8 == null) {
                return false;
            }
            if (list7.size() == list8.size()) {
                Iterator<T> it9 = list7.iterator();
                int i17 = 0;
                while (true) {
                    if (it9.hasNext()) {
                        Object next9 = it9.next();
                        int i18 = i17 + 1;
                        if (i17 < 0) {
                            CollectionsKt.throwIndexOverflow();
                        }
                        if (((DivAction) next9).equals(list8.get(i17), resolver, otherResolver)) {
                            i17 = i18;
                        }
                    }
                }
            }
        } else {
            z9 = other.hoverStartActions == null;
        }
        if (!z9 || !Intrinsics.areEqual(getId(), other.getId())) {
            return false;
        }
        List<Div> list9 = this.items;
        if (list9 != null) {
            List<Div> list10 = other.items;
            if (list10 == null) {
                return false;
            }
            if (list9.size() == list10.size()) {
                Iterator<T> it10 = list9.iterator();
                int i19 = 0;
                while (true) {
                    if (it10.hasNext()) {
                        Object next10 = it10.next();
                        int i20 = i19 + 1;
                        if (i19 < 0) {
                            CollectionsKt.throwIndexOverflow();
                        }
                        if (((Div) next10).equals(list10.get(i19), resolver, otherResolver)) {
                            i19 = i20;
                        }
                    }
                }
            }
        } else {
            z10 = other.items == null;
        }
        if (!z10) {
            return false;
        }
        DivLayoutProvider layoutProvider = getLayoutProvider();
        if (layoutProvider != null) {
            zEquals5 = layoutProvider.equals(other.getLayoutProvider(), resolver, otherResolver);
        } else {
            zEquals5 = other.getLayoutProvider() == null;
        }
        if (!zEquals5) {
            return false;
        }
        List<DivAction> list11 = this.longtapActions;
        if (list11 != null) {
            List<DivAction> list12 = other.longtapActions;
            if (list12 == null) {
                return false;
            }
            if (list11.size() == list12.size()) {
                Iterator<T> it11 = list11.iterator();
                int i21 = 0;
                while (true) {
                    if (it11.hasNext()) {
                        Object next11 = it11.next();
                        int i22 = i21 + 1;
                        if (i21 < 0) {
                            CollectionsKt.throwIndexOverflow();
                        }
                        if (((DivAction) next11).equals(list12.get(i21), resolver, otherResolver)) {
                            i21 = i22;
                        }
                    }
                }
            }
        } else {
            z11 = other.longtapActions == null;
        }
        if (!z11) {
            return false;
        }
        DivEdgeInsets margins = getMargins();
        if (margins != null) {
            zEquals6 = margins.equals(other.getMargins(), resolver, otherResolver);
        } else {
            zEquals6 = other.getMargins() == null;
        }
        if (!zEquals6) {
            return false;
        }
        DivEdgeInsets paddings = getPaddings();
        if (paddings != null) {
            zEquals7 = paddings.equals(other.getPaddings(), resolver, otherResolver);
        } else {
            zEquals7 = other.getPaddings() == null;
        }
        if (!zEquals7) {
            return false;
        }
        List<DivAction> list13 = this.pressEndActions;
        if (list13 != null) {
            List<DivAction> list14 = other.pressEndActions;
            if (list14 == null) {
                return false;
            }
            if (list13.size() == list14.size()) {
                Iterator<T> it12 = list13.iterator();
                int i23 = 0;
                while (true) {
                    if (it12.hasNext()) {
                        Object next12 = it12.next();
                        int i24 = i23 + 1;
                        if (i23 < 0) {
                            CollectionsKt.throwIndexOverflow();
                        }
                        if (((DivAction) next12).equals(list14.get(i23), resolver, otherResolver)) {
                            i23 = i24;
                        }
                    }
                }
            }
        } else {
            z12 = other.pressEndActions == null;
        }
        if (!z12) {
            return false;
        }
        List<DivAction> list15 = this.pressStartActions;
        if (list15 != null) {
            List<DivAction> list16 = other.pressStartActions;
            if (list16 == null) {
                return false;
            }
            if (list15.size() == list16.size()) {
                Iterator<T> it13 = list15.iterator();
                int i25 = 0;
                while (true) {
                    if (it13.hasNext()) {
                        Object next13 = it13.next();
                        int i26 = i25 + 1;
                        if (i25 < 0) {
                            CollectionsKt.throwIndexOverflow();
                        }
                        if (((DivAction) next13).equals(list16.get(i25), resolver, otherResolver)) {
                            i25 = i26;
                        }
                    }
                }
            }
        } else {
            z13 = other.pressStartActions == null;
        }
        if (!z13) {
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
        List<DivAction> selectedActions = getSelectedActions();
        if (selectedActions != null) {
            List<DivAction> selectedActions2 = other.getSelectedActions();
            if (selectedActions2 == null) {
                return false;
            }
            if (selectedActions.size() == selectedActions2.size()) {
                Iterator<T> it14 = selectedActions.iterator();
                int i27 = 0;
                while (true) {
                    if (it14.hasNext()) {
                        Object next14 = it14.next();
                        int i28 = i27 + 1;
                        if (i27 < 0) {
                            CollectionsKt.throwIndexOverflow();
                        }
                        if (((DivAction) next14).equals(selectedActions2.get(i27), resolver, otherResolver)) {
                            i27 = i28;
                        }
                    }
                }
            }
        } else {
            z14 = other.getSelectedActions() == null;
        }
        if (!z14) {
            return false;
        }
        List<DivTooltip> tooltips = getTooltips();
        if (tooltips != null) {
            List<DivTooltip> tooltips2 = other.getTooltips();
            if (tooltips2 == null) {
                return false;
            }
            if (tooltips.size() == tooltips2.size()) {
                Iterator<T> it15 = tooltips.iterator();
                int i29 = 0;
                while (true) {
                    if (it15.hasNext()) {
                        Object next15 = it15.next();
                        int i30 = i29 + 1;
                        if (i29 < 0) {
                            CollectionsKt.throwIndexOverflow();
                        }
                        if (((DivTooltip) next15).equals(tooltips2.get(i29), resolver, otherResolver)) {
                            i29 = i30;
                        }
                    }
                }
            }
        } else {
            z15 = other.getTooltips() == null;
        }
        if (!z15) {
            return false;
        }
        DivTransform transform = getTransform();
        if (transform != null) {
            zEquals8 = transform.equals(other.getTransform(), resolver, otherResolver);
        } else {
            zEquals8 = other.getTransform() == null;
        }
        if (!zEquals8) {
            return false;
        }
        DivChangeTransition transitionChange = getTransitionChange();
        if (transitionChange != null) {
            zEquals9 = transitionChange.equals(other.getTransitionChange(), resolver, otherResolver);
        } else {
            zEquals9 = other.getTransitionChange() == null;
        }
        if (!zEquals9) {
            return false;
        }
        DivAppearanceTransition transitionIn = getTransitionIn();
        if (transitionIn != null) {
            zEquals10 = transitionIn.equals(other.getTransitionIn(), resolver, otherResolver);
        } else {
            zEquals10 = other.getTransitionIn() == null;
        }
        if (!zEquals10) {
            return false;
        }
        DivAppearanceTransition transitionOut = getTransitionOut();
        if (transitionOut != null) {
            zEquals11 = transitionOut.equals(other.getTransitionOut(), resolver, otherResolver);
        } else {
            zEquals11 = other.getTransitionOut() == null;
        }
        if (!zEquals11) {
            return false;
        }
        List<DivTransitionTrigger> transitionTriggers = getTransitionTriggers();
        if (transitionTriggers != null) {
            List<DivTransitionTrigger> transitionTriggers2 = other.getTransitionTriggers();
            if (transitionTriggers2 == null) {
                return false;
            }
            if (transitionTriggers.size() == transitionTriggers2.size()) {
                Iterator<T> it16 = transitionTriggers.iterator();
                int i31 = 0;
                while (true) {
                    if (it16.hasNext()) {
                        Object next16 = it16.next();
                        int i32 = i31 + 1;
                        if (i31 < 0) {
                            CollectionsKt.throwIndexOverflow();
                        }
                        if (((DivTransitionTrigger) next16) == transitionTriggers2.get(i31)) {
                            i31 = i32;
                        }
                    }
                }
            }
        } else {
            z16 = other.getTransitionTriggers() == null;
        }
        if (!z16) {
            return false;
        }
        List<DivTrigger> variableTriggers = getVariableTriggers();
        if (variableTriggers != null) {
            List<DivTrigger> variableTriggers2 = other.getVariableTriggers();
            if (variableTriggers2 == null) {
                return false;
            }
            if (variableTriggers.size() == variableTriggers2.size()) {
                Iterator<T> it17 = variableTriggers.iterator();
                int i33 = 0;
                while (true) {
                    if (it17.hasNext()) {
                        Object next17 = it17.next();
                        int i34 = i33 + 1;
                        if (i33 < 0) {
                            CollectionsKt.throwIndexOverflow();
                        }
                        if (((DivTrigger) next17).equals(variableTriggers2.get(i33), resolver, otherResolver)) {
                            i33 = i34;
                        }
                    }
                }
            }
        } else {
            z17 = other.getVariableTriggers() == null;
        }
        if (!z17) {
            return false;
        }
        List<DivVariable> variables = getVariables();
        if (variables != null) {
            List<DivVariable> variables2 = other.getVariables();
            if (variables2 == null) {
                return false;
            }
            if (variables.size() == variables2.size()) {
                Iterator<T> it18 = variables.iterator();
                int i35 = 0;
                while (true) {
                    if (it18.hasNext()) {
                        Object next18 = it18.next();
                        int i36 = i35 + 1;
                        if (i35 < 0) {
                            CollectionsKt.throwIndexOverflow();
                        }
                        if (((DivVariable) next18).equals(variables2.get(i35), resolver, otherResolver)) {
                            i35 = i36;
                        }
                    }
                }
            }
        } else {
            z18 = other.getVariables() == null;
        }
        if (!z18 || getVisibility().evaluate(resolver) != other.getVisibility().evaluate(otherResolver)) {
            return false;
        }
        DivVisibilityAction visibilityAction = getVisibilityAction();
        if (visibilityAction != null) {
            zEquals12 = visibilityAction.equals(other.getVisibilityAction(), resolver, otherResolver);
        } else {
            zEquals12 = other.getVisibilityAction() == null;
        }
        if (!zEquals12) {
            return false;
        }
        List<DivVisibilityAction> visibilityActions = getVisibilityActions();
        if (visibilityActions != null) {
            List<DivVisibilityAction> visibilityActions2 = other.getVisibilityActions();
            if (visibilityActions2 == null) {
                return false;
            }
            if (visibilityActions.size() == visibilityActions2.size()) {
                Iterator<T> it19 = visibilityActions.iterator();
                int i37 = 0;
                while (true) {
                    if (it19.hasNext()) {
                        Object next19 = it19.next();
                        int i38 = i37 + 1;
                        if (i37 < 0) {
                            CollectionsKt.throwIndexOverflow();
                        }
                        if (((DivVisibilityAction) next19).equals(visibilityActions2.get(i37), resolver, otherResolver)) {
                            i37 = i38;
                        }
                    }
                }
            }
        } else {
            z19 = other.getVisibilityActions() == null;
        }
        return z19 && getWidth().equals(other.getWidth(), resolver, otherResolver);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ DivGrid copy$default(DivGrid divGrid, DivAccessibility divAccessibility, DivAction divAction, DivAnimation divAnimation, List list, Expression expression, Expression expression2, Expression expression3, List list2, List list3, DivBorder divBorder, Expression expression4, Expression expression5, Expression expression6, Expression expression7, List list4, List list5, List list6, DivFocus divFocus, List list7, DivSize divSize, List list8, List list9, String str, List list10, DivLayoutProvider divLayoutProvider, List list11, DivEdgeInsets divEdgeInsets, DivEdgeInsets divEdgeInsets2, List list12, List list13, Expression expression8, Expression expression9, List list14, List list15, DivTransform divTransform, DivChangeTransition divChangeTransition, DivAppearanceTransition divAppearanceTransition, DivAppearanceTransition divAppearanceTransition2, List list16, List list17, List list18, Expression expression10, DivVisibilityAction divVisibilityAction, List list19, DivSize divSize2, int i, int i2, Object obj) {
        DivAccessibility accessibility = (i & 1) != 0 ? divGrid.getAccessibility() : divAccessibility;
        DivAction divAction2 = (i & 2) != 0 ? divGrid.action : divAction;
        DivAnimation divAnimation2 = (i & 4) != 0 ? divGrid.actionAnimation : divAnimation;
        List list20 = (i & 8) != 0 ? divGrid.actions : list;
        Expression alignmentHorizontal = (i & 16) != 0 ? divGrid.getAlignmentHorizontal() : expression;
        Expression alignmentVertical = (i & 32) != 0 ? divGrid.getAlignmentVertical() : expression2;
        Expression alpha = (i & 64) != 0 ? divGrid.getAlpha() : expression3;
        List animators = (i & 128) != 0 ? divGrid.getAnimators() : list2;
        List background = (i & 256) != 0 ? divGrid.getBackground() : list3;
        DivBorder border = (i & 512) != 0 ? divGrid.getBorder() : divBorder;
        Expression expression11 = (i & 1024) != 0 ? divGrid.columnCount : expression4;
        Expression columnSpan = (i & 2048) != 0 ? divGrid.getColumnSpan() : expression5;
        Expression expression12 = (i & 4096) != 0 ? divGrid.contentAlignmentHorizontal : expression6;
        Expression expression13 = (i & 8192) != 0 ? divGrid.contentAlignmentVertical : expression7;
        List disappearActions = (i & 16384) != 0 ? divGrid.getDisappearActions() : list4;
        List list21 = (i & 32768) != 0 ? divGrid.doubletapActions : list5;
        List extensions = (i & 65536) != 0 ? divGrid.getExtensions() : list6;
        DivFocus focus = (i & 131072) != 0 ? divGrid.getFocus() : divFocus;
        List functions = (i & 262144) != 0 ? divGrid.getFunctions() : list7;
        DivSize height = (i & 524288) != 0 ? divGrid.getHeight() : divSize;
        List list22 = list21;
        List list23 = (i & 1048576) != 0 ? divGrid.hoverEndActions : list8;
        List list24 = (i & 2097152) != 0 ? divGrid.hoverStartActions : list9;
        String id = (i & 4194304) != 0 ? divGrid.getId() : str;
        List list25 = list24;
        List list26 = (i & 8388608) != 0 ? divGrid.items : list10;
        return divGrid.copy(accessibility, divAction2, divAnimation2, list20, alignmentHorizontal, alignmentVertical, alpha, animators, background, border, expression11, columnSpan, expression12, expression13, disappearActions, list22, extensions, focus, functions, height, list23, list25, id, list26, (i & 16777216) != 0 ? divGrid.getLayoutProvider() : divLayoutProvider, (i & 33554432) != 0 ? divGrid.longtapActions : list11, (i & 67108864) != 0 ? divGrid.getMargins() : divEdgeInsets, (i & 134217728) != 0 ? divGrid.getPaddings() : divEdgeInsets2, (i & 268435456) != 0 ? divGrid.pressEndActions : list12, (i & 536870912) != 0 ? divGrid.pressStartActions : list13, (i & 1073741824) != 0 ? divGrid.getReuseId() : expression8, (i & Integer.MIN_VALUE) != 0 ? divGrid.getRowSpan() : expression9, (i2 & 1) != 0 ? divGrid.getSelectedActions() : list14, (i2 & 2) != 0 ? divGrid.getTooltips() : list15, (i2 & 4) != 0 ? divGrid.getTransform() : divTransform, (i2 & 8) != 0 ? divGrid.getTransitionChange() : divChangeTransition, (i2 & 16) != 0 ? divGrid.getTransitionIn() : divAppearanceTransition, (i2 & 32) != 0 ? divGrid.getTransitionOut() : divAppearanceTransition2, (i2 & 64) != 0 ? divGrid.getTransitionTriggers() : list16, (i2 & 128) != 0 ? divGrid.getVariableTriggers() : list17, (i2 & 256) != 0 ? divGrid.getVariables() : list18, (i2 & 512) != 0 ? divGrid.getVisibility() : expression10, (i2 & 1024) != 0 ? divGrid.getVisibilityAction() : divVisibilityAction, (i2 & 2048) != 0 ? divGrid.getVisibilityActions() : list19, (i2 & 4096) != 0 ? divGrid.getWidth() : divSize2);
    }

    public final DivGrid copy(DivAccessibility accessibility, DivAction action, DivAnimation actionAnimation, List<DivAction> actions, Expression<DivAlignmentHorizontal> alignmentHorizontal, Expression<DivAlignmentVertical> alignmentVertical, Expression<Double> alpha, List<? extends DivAnimator> animators, List<? extends DivBackground> background, DivBorder border, Expression<Long> columnCount, Expression<Long> columnSpan, Expression<DivAlignmentHorizontal> contentAlignmentHorizontal, Expression<DivAlignmentVertical> contentAlignmentVertical, List<DivDisappearAction> disappearActions, List<DivAction> doubletapActions, List<DivExtension> extensions, DivFocus focus, List<DivFunction> functions, DivSize height, List<DivAction> hoverEndActions, List<DivAction> hoverStartActions, String id, List<? extends Div> items, DivLayoutProvider layoutProvider, List<DivAction> longtapActions, DivEdgeInsets margins, DivEdgeInsets paddings, List<DivAction> pressEndActions, List<DivAction> pressStartActions, Expression<String> reuseId, Expression<Long> rowSpan, List<DivAction> selectedActions, List<DivTooltip> tooltips, DivTransform transform, DivChangeTransition transitionChange, DivAppearanceTransition transitionIn, DivAppearanceTransition transitionOut, List<? extends DivTransitionTrigger> transitionTriggers, List<DivTrigger> variableTriggers, List<? extends DivVariable> variables, Expression<DivVisibility> visibility, DivVisibilityAction visibilityAction, List<DivVisibilityAction> visibilityActions, DivSize width) {
        Intrinsics.checkNotNullParameter(actionAnimation, "actionAnimation");
        Intrinsics.checkNotNullParameter(alpha, "alpha");
        Intrinsics.checkNotNullParameter(columnCount, "columnCount");
        Intrinsics.checkNotNullParameter(contentAlignmentHorizontal, "contentAlignmentHorizontal");
        Intrinsics.checkNotNullParameter(contentAlignmentVertical, "contentAlignmentVertical");
        Intrinsics.checkNotNullParameter(height, "height");
        Intrinsics.checkNotNullParameter(visibility, "visibility");
        Intrinsics.checkNotNullParameter(width, "width");
        return new DivGrid(accessibility, action, actionAnimation, actions, alignmentHorizontal, alignmentVertical, alpha, animators, background, border, columnCount, columnSpan, contentAlignmentHorizontal, contentAlignmentVertical, disappearActions, doubletapActions, extensions, focus, functions, height, hoverEndActions, hoverStartActions, id, items, layoutProvider, longtapActions, margins, paddings, pressEndActions, pressStartActions, reuseId, rowSpan, selectedActions, tooltips, transform, transitionChange, transitionIn, transitionOut, transitionTriggers, variableTriggers, variables, visibility, visibilityAction, visibilityActions, width);
    }

    @Override // com.yandex.div.json.JSONSerializable
    public JSONObject writeToJSON() {
        return BuiltInParserKt.getBuiltInParserComponent().getDivGridJsonEntityParser().getValue().serialize(BuiltInParserKt.getBuiltInParsingContext(), this);
    }

    /* JADX INFO: compiled from: DivGrid.kt */
    @Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0006\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u001e\u0010\u001b\u001a\u00020\u00102\u0006\u0010\u001c\u001a\u00020\u000e2\u0006\u0010\u001d\u001a\u00020\u000fH\u0087\u0002¢\u0006\u0002\b\u001eR\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\b\u001a\b\u0012\u0004\u0012\u00020\t0\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u000b0\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R#\u0010\f\u001a\u0014\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u00100\r¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u000e\u0010\u0013\u001a\u00020\u0014X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0016X\u0086T¢\u0006\u0002\n\u0000R\u0014\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00180\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u001aX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001f"}, d2 = {"Lcom/yandex/div2/DivGrid$Companion;", "", "()V", "ACTION_ANIMATION_DEFAULT_VALUE", "Lcom/yandex/div2/DivAnimation;", "ALPHA_DEFAULT_VALUE", "Lcom/yandex/div/json/expressions/Expression;", "", "CONTENT_ALIGNMENT_HORIZONTAL_DEFAULT_VALUE", "Lcom/yandex/div2/DivAlignmentHorizontal;", "CONTENT_ALIGNMENT_VERTICAL_DEFAULT_VALUE", "Lcom/yandex/div2/DivAlignmentVertical;", "CREATOR", "Lkotlin/Function2;", "Lcom/yandex/div/json/ParsingEnvironment;", "Lorg/json/JSONObject;", "Lcom/yandex/div2/DivGrid;", "getCREATOR", "()Lkotlin/jvm/functions/Function2;", "HEIGHT_DEFAULT_VALUE", "Lcom/yandex/div2/DivSize$WrapContent;", "TYPE", "", "VISIBILITY_DEFAULT_VALUE", "Lcom/yandex/div2/DivVisibility;", "WIDTH_DEFAULT_VALUE", "Lcom/yandex/div2/DivSize$MatchParent;", "invoke", cc.o, "json", "fromJson", "div-data_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @JvmStatic
        public final DivGrid fromJson(ParsingEnvironment env, JSONObject json) {
            Intrinsics.checkNotNullParameter(env, "env");
            Intrinsics.checkNotNullParameter(json, "json");
            return BuiltInParserKt.getBuiltInParserComponent().getDivGridJsonEntityParser().getValue().deserialize((ParsingContext) env, json);
        }

        public final Function2<ParsingEnvironment, JSONObject, DivGrid> getCREATOR() {
            return DivGrid.CREATOR;
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
        CONTENT_ALIGNMENT_HORIZONTAL_DEFAULT_VALUE = Expression.INSTANCE.constant(DivAlignmentHorizontal.START);
        CONTENT_ALIGNMENT_VERTICAL_DEFAULT_VALUE = Expression.INSTANCE.constant(DivAlignmentVertical.TOP);
        HEIGHT_DEFAULT_VALUE = new DivSize.WrapContent(new DivWrapContentSize(null, null, 0 == true ? 1 : 0, 7, null));
        VISIBILITY_DEFAULT_VALUE = Expression.INSTANCE.constant(DivVisibility.VISIBLE);
        WIDTH_DEFAULT_VALUE = new DivSize.MatchParent(new DivMatchParentSize(0 == true ? 1 : 0, 1, 0 == true ? 1 : 0));
        CREATOR = new Function2<ParsingEnvironment, JSONObject, DivGrid>() { // from class: com.yandex.div2.DivGrid$Companion$CREATOR$1
            @Override // kotlin.jvm.functions.Function2
            public final DivGrid invoke(ParsingEnvironment env, JSONObject it) {
                Intrinsics.checkNotNullParameter(env, "env");
                Intrinsics.checkNotNullParameter(it, "it");
                return DivGrid.INSTANCE.fromJson(env, it);
            }
        };
    }
}
