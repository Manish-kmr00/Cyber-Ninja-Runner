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

/* JADX INFO: compiled from: DivVideo.kt */
/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000ô\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0006\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b2\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 \u008d\u00012\u00020\u00012\u00020\u00022\u00020\u0003:\u0002\u008d\u0001BÙ\u0005\b\u0007\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\u0010\b\u0002\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007\u0012\u0010\b\u0002\u0010\t\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\u0007\u0012\u000e\b\u0002\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\f0\u0007\u0012\u0010\b\u0002\u0010\r\u001a\n\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u000e\u0012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u0011\u0012\u000e\b\u0002\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00130\u0007\u0012\u0010\b\u0002\u0010\u0014\u001a\n\u0012\u0004\u0012\u00020\u0015\u0018\u00010\u000e\u0012\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u0017\u0012\u0010\b\u0002\u0010\u0018\u001a\n\u0012\u0004\u0012\u00020\u0019\u0018\u00010\u000e\u0012\u0010\b\u0002\u0010\u001a\u001a\n\u0012\u0004\u0012\u00020\u001b\u0018\u00010\u0007\u0012\u0010\b\u0002\u0010\u001c\u001a\n\u0012\u0004\u0012\u00020\u001d\u0018\u00010\u000e\u0012\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010\u001f\u0012\u0010\b\u0002\u0010 \u001a\n\u0012\u0004\u0012\u00020\u0019\u0018\u00010\u000e\u0012\u0010\b\u0002\u0010!\u001a\n\u0012\u0004\u0012\u00020\"\u0018\u00010\u000e\u0012\u0010\b\u0002\u0010#\u001a\n\u0012\u0004\u0012\u00020\u0019\u0018\u00010\u000e\u0012\n\b\u0002\u0010$\u001a\u0004\u0018\u00010%\u0012\u0010\b\u0002\u0010&\u001a\n\u0012\u0004\u0012\u00020'\u0018\u00010\u000e\u0012\b\b\u0002\u0010(\u001a\u00020)\u0012\n\b\u0002\u0010*\u001a\u0004\u0018\u00010\u001f\u0012\n\b\u0002\u0010+\u001a\u0004\u0018\u00010,\u0012\n\b\u0002\u0010-\u001a\u0004\u0018\u00010.\u0012\u000e\b\u0002\u0010/\u001a\b\u0012\u0004\u0012\u00020\u00130\u0007\u0012\n\b\u0002\u00100\u001a\u0004\u0018\u00010.\u0012\u0010\b\u0002\u00101\u001a\n\u0012\u0004\u0012\u00020\u0019\u0018\u00010\u000e\u0012\n\b\u0002\u00102\u001a\u0004\u0018\u000103\u0012\u000e\b\u0002\u00104\u001a\b\u0012\u0004\u0012\u00020\u00130\u0007\u0012\u0010\b\u0002\u00105\u001a\n\u0012\u0004\u0012\u00020\u001f\u0018\u00010\u0007\u0012\u000e\b\u0002\u00106\u001a\b\u0012\u0004\u0012\u00020\u00130\u0007\u0012\u0010\b\u0002\u00107\u001a\n\u0012\u0004\u0012\u00020\u0019\u0018\u00010\u000e\u0012\u0010\b\u0002\u00108\u001a\n\u0012\u0004\u0012\u00020\u001f\u0018\u00010\u0007\u0012\u0010\b\u0002\u00109\u001a\n\u0012\u0004\u0012\u00020\u001b\u0018\u00010\u0007\u0012\u000e\b\u0002\u0010:\u001a\b\u0012\u0004\u0012\u00020;0\u0007\u0012\u0010\b\u0002\u0010<\u001a\n\u0012\u0004\u0012\u00020\u0019\u0018\u00010\u000e\u0012\u0010\b\u0002\u0010=\u001a\n\u0012\u0004\u0012\u00020>\u0018\u00010\u000e\u0012\n\b\u0002\u0010?\u001a\u0004\u0018\u00010@\u0012\n\b\u0002\u0010A\u001a\u0004\u0018\u00010B\u0012\n\b\u0002\u0010C\u001a\u0004\u0018\u00010D\u0012\n\b\u0002\u0010E\u001a\u0004\u0018\u00010D\u0012\u0010\b\u0002\u0010F\u001a\n\u0012\u0004\u0012\u00020G\u0018\u00010\u000e\u0012\u0010\b\u0002\u0010H\u001a\n\u0012\u0004\u0012\u00020I\u0018\u00010\u000e\u0012\u0010\b\u0002\u0010J\u001a\n\u0012\u0004\u0012\u00020K\u0018\u00010\u000e\u0012\f\u0010L\u001a\b\u0012\u0004\u0012\u00020M0\u000e\u0012\u000e\b\u0002\u0010N\u001a\b\u0012\u0004\u0012\u00020O0\u0007\u0012\n\b\u0002\u0010P\u001a\u0004\u0018\u00010Q\u0012\u0010\b\u0002\u0010R\u001a\n\u0012\u0004\u0012\u00020Q\u0018\u00010\u000e\u0012\b\b\u0002\u0010S\u001a\u00020)¢\u0006\u0002\u0010TJÛ\u0005\u0010\u0085\u0001\u001a\u00020\u00002\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0010\b\u0002\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u00072\u0010\b\u0002\u0010\t\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\u00072\u000e\b\u0002\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\f0\u00072\u0010\b\u0002\u0010\r\u001a\n\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u000e2\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u00112\u000e\b\u0002\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00130\u00072\u0010\b\u0002\u0010\u0014\u001a\n\u0012\u0004\u0012\u00020\u0015\u0018\u00010\u000e2\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u00172\u0010\b\u0002\u0010\u0018\u001a\n\u0012\u0004\u0012\u00020\u0019\u0018\u00010\u000e2\u0010\b\u0002\u0010\u001a\u001a\n\u0012\u0004\u0012\u00020\u001b\u0018\u00010\u00072\u0010\b\u0002\u0010\u001c\u001a\n\u0012\u0004\u0012\u00020\u001d\u0018\u00010\u000e2\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010\u001f2\u0010\b\u0002\u0010 \u001a\n\u0012\u0004\u0012\u00020\u0019\u0018\u00010\u000e2\u0010\b\u0002\u0010!\u001a\n\u0012\u0004\u0012\u00020\"\u0018\u00010\u000e2\u0010\b\u0002\u0010#\u001a\n\u0012\u0004\u0012\u00020\u0019\u0018\u00010\u000e2\n\b\u0002\u0010$\u001a\u0004\u0018\u00010%2\u0010\b\u0002\u0010&\u001a\n\u0012\u0004\u0012\u00020'\u0018\u00010\u000e2\b\b\u0002\u0010(\u001a\u00020)2\n\b\u0002\u0010*\u001a\u0004\u0018\u00010\u001f2\n\b\u0002\u0010+\u001a\u0004\u0018\u00010,2\n\b\u0002\u0010-\u001a\u0004\u0018\u00010.2\u000e\b\u0002\u0010/\u001a\b\u0012\u0004\u0012\u00020\u00130\u00072\n\b\u0002\u00100\u001a\u0004\u0018\u00010.2\u0010\b\u0002\u00101\u001a\n\u0012\u0004\u0012\u00020\u0019\u0018\u00010\u000e2\n\b\u0002\u00102\u001a\u0004\u0018\u0001032\u000e\b\u0002\u00104\u001a\b\u0012\u0004\u0012\u00020\u00130\u00072\u0010\b\u0002\u00105\u001a\n\u0012\u0004\u0012\u00020\u001f\u0018\u00010\u00072\u000e\b\u0002\u00106\u001a\b\u0012\u0004\u0012\u00020\u00130\u00072\u0010\b\u0002\u00107\u001a\n\u0012\u0004\u0012\u00020\u0019\u0018\u00010\u000e2\u0010\b\u0002\u00108\u001a\n\u0012\u0004\u0012\u00020\u001f\u0018\u00010\u00072\u0010\b\u0002\u00109\u001a\n\u0012\u0004\u0012\u00020\u001b\u0018\u00010\u00072\u000e\b\u0002\u0010:\u001a\b\u0012\u0004\u0012\u00020;0\u00072\u0010\b\u0002\u0010<\u001a\n\u0012\u0004\u0012\u00020\u0019\u0018\u00010\u000e2\u0010\b\u0002\u0010=\u001a\n\u0012\u0004\u0012\u00020>\u0018\u00010\u000e2\n\b\u0002\u0010?\u001a\u0004\u0018\u00010@2\n\b\u0002\u0010A\u001a\u0004\u0018\u00010B2\n\b\u0002\u0010C\u001a\u0004\u0018\u00010D2\n\b\u0002\u0010E\u001a\u0004\u0018\u00010D2\u0010\b\u0002\u0010F\u001a\n\u0012\u0004\u0012\u00020G\u0018\u00010\u000e2\u0010\b\u0002\u0010H\u001a\n\u0012\u0004\u0012\u00020I\u0018\u00010\u000e2\u0010\b\u0002\u0010J\u001a\n\u0012\u0004\u0012\u00020K\u0018\u00010\u000e2\u000e\b\u0002\u0010L\u001a\b\u0012\u0004\u0012\u00020M0\u000e2\u000e\b\u0002\u0010N\u001a\b\u0012\u0004\u0012\u00020O0\u00072\n\b\u0002\u0010P\u001a\u0004\u0018\u00010Q2\u0010\b\u0002\u0010R\u001a\n\u0012\u0004\u0012\u00020Q\u0018\u00010\u000e2\b\b\u0002\u0010S\u001a\u00020)J&\u0010\u0086\u0001\u001a\u00020\u00132\t\u0010\u0087\u0001\u001a\u0004\u0018\u00010\u00002\b\u0010\u0088\u0001\u001a\u00030\u0089\u00012\b\u0010\u008a\u0001\u001a\u00030\u0089\u0001J\t\u0010\u008b\u0001\u001a\u00020VH\u0016J\t\u0010\u008c\u0001\u001a\u000203H\u0016R\u0012\u0010U\u001a\u0004\u0018\u00010VX\u0082\u000e¢\u0006\u0004\n\u0002\u0010WR\u0016\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\bX\u0010YR\u001c\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\bZ\u0010[R\u001c\u0010\t\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\u0007X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\\\u0010[R\u001a\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\f0\u0007X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b]\u0010[R\u001c\u0010\r\u001a\n\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u000eX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b^\u0010_R\u0012\u0010\u0010\u001a\u0004\u0018\u00010\u00118\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00130\u00078\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\u0014\u001a\n\u0012\u0004\u0012\u00020\u0015\u0018\u00010\u000eX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b`\u0010_R\u0016\u0010\u0016\u001a\u0004\u0018\u00010\u0017X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\ba\u0010bR\u0018\u0010\u0018\u001a\n\u0012\u0004\u0012\u00020\u0019\u0018\u00010\u000e8\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\u001a\u001a\n\u0012\u0004\u0012\u00020\u001b\u0018\u00010\u0007X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\bc\u0010[R\u001c\u0010\u001c\u001a\n\u0012\u0004\u0012\u00020\u001d\u0018\u00010\u000eX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\bd\u0010_R\u0012\u0010\u001e\u001a\u0004\u0018\u00010\u001f8\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0018\u0010 \u001a\n\u0012\u0004\u0012\u00020\u0019\u0018\u00010\u000e8\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u001c\u0010!\u001a\n\u0012\u0004\u0012\u00020\"\u0018\u00010\u000eX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\be\u0010_R\u0018\u0010#\u001a\n\u0012\u0004\u0012\u00020\u0019\u0018\u00010\u000e8\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0016\u0010$\u001a\u0004\u0018\u00010%X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\bf\u0010gR\u001c\u0010&\u001a\n\u0012\u0004\u0012\u00020'\u0018\u00010\u000eX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\bh\u0010_R\u0014\u0010(\u001a\u00020)X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\bi\u0010jR\u0016\u0010*\u001a\u0004\u0018\u00010\u001fX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\bk\u0010lR\u0016\u0010+\u001a\u0004\u0018\u00010,X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\bm\u0010nR\u0016\u0010-\u001a\u0004\u0018\u00010.X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\bo\u0010pR\u0016\u0010/\u001a\b\u0012\u0004\u0012\u00020\u00130\u00078\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0016\u00100\u001a\u0004\u0018\u00010.X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\bq\u0010pR\u0018\u00101\u001a\n\u0012\u0004\u0012\u00020\u0019\u0018\u00010\u000e8\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0012\u00102\u001a\u0004\u0018\u0001038\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0016\u00104\u001a\b\u0012\u0004\u0012\u00020\u00130\u00078\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0018\u00105\u001a\n\u0012\u0004\u0012\u00020\u001f\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0016\u00106\u001a\b\u0012\u0004\u0012\u00020\u00130\u00078\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0018\u00107\u001a\n\u0012\u0004\u0012\u00020\u0019\u0018\u00010\u000e8\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u001c\u00108\u001a\n\u0012\u0004\u0012\u00020\u001f\u0018\u00010\u0007X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\br\u0010[R\u001c\u00109\u001a\n\u0012\u0004\u0012\u00020\u001b\u0018\u00010\u0007X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\bs\u0010[R\u0016\u0010:\u001a\b\u0012\u0004\u0012\u00020;0\u00078\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u001c\u0010<\u001a\n\u0012\u0004\u0012\u00020\u0019\u0018\u00010\u000eX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\bt\u0010_R\u001c\u0010=\u001a\n\u0012\u0004\u0012\u00020>\u0018\u00010\u000eX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\bu\u0010_R\u0016\u0010?\u001a\u0004\u0018\u00010@X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\bv\u0010wR\u0016\u0010A\u001a\u0004\u0018\u00010BX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\bx\u0010yR\u0016\u0010C\u001a\u0004\u0018\u00010DX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\bz\u0010{R\u0016\u0010E\u001a\u0004\u0018\u00010DX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b|\u0010{R\u001c\u0010F\u001a\n\u0012\u0004\u0012\u00020G\u0018\u00010\u000eX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b}\u0010_R\u001c\u0010H\u001a\n\u0012\u0004\u0012\u00020I\u0018\u00010\u000eX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b~\u0010_R\u001c\u0010J\u001a\n\u0012\u0004\u0012\u00020K\u0018\u00010\u000eX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u007f\u0010_R\u0016\u0010L\u001a\b\u0012\u0004\u0012\u00020M0\u000e8\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u001b\u0010N\u001a\b\u0012\u0004\u0012\u00020O0\u0007X\u0096\u0004¢\u0006\t\n\u0000\u001a\u0005\b\u0080\u0001\u0010[R\u0018\u0010P\u001a\u0004\u0018\u00010QX\u0096\u0004¢\u0006\n\n\u0000\u001a\u0006\b\u0081\u0001\u0010\u0082\u0001R\u001d\u0010R\u001a\n\u0012\u0004\u0012\u00020Q\u0018\u00010\u000eX\u0096\u0004¢\u0006\t\n\u0000\u001a\u0005\b\u0083\u0001\u0010_R\u0015\u0010S\u001a\u00020)X\u0096\u0004¢\u0006\t\n\u0000\u001a\u0005\b\u0084\u0001\u0010j¨\u0006\u008e\u0001"}, d2 = {"Lcom/yandex/div2/DivVideo;", "Lcom/yandex/div/json/JSONSerializable;", "Lcom/yandex/div/data/Hashable;", "Lcom/yandex/div2/DivBase;", "accessibility", "Lcom/yandex/div2/DivAccessibility;", "alignmentHorizontal", "Lcom/yandex/div/json/expressions/Expression;", "Lcom/yandex/div2/DivAlignmentHorizontal;", "alignmentVertical", "Lcom/yandex/div2/DivAlignmentVertical;", "alpha", "", "animators", "", "Lcom/yandex/div2/DivAnimator;", "aspect", "Lcom/yandex/div2/DivAspect;", "autostart", "", J2.g, "Lcom/yandex/div2/DivBackground;", OutlinedTextFieldKt.BorderId, "Lcom/yandex/div2/DivBorder;", "bufferingActions", "Lcom/yandex/div2/DivAction;", "columnSpan", "", "disappearActions", "Lcom/yandex/div2/DivDisappearAction;", "elapsedTimeVariable", "", "endActions", "extensions", "Lcom/yandex/div2/DivExtension;", "fatalActions", "focus", "Lcom/yandex/div2/DivFocus;", "functions", "Lcom/yandex/div2/DivFunction;", "height", "Lcom/yandex/div2/DivSize;", "id", "layoutProvider", "Lcom/yandex/div2/DivLayoutProvider;", "margins", "Lcom/yandex/div2/DivEdgeInsets;", "muted", "paddings", "pauseActions", "playerSettingsPayload", "Lorg/json/JSONObject;", "preloadRequired", "preview", "repeatable", "resumeActions", "reuseId", "rowSpan", "scale", "Lcom/yandex/div2/DivVideoScale;", "selectedActions", "tooltips", "Lcom/yandex/div2/DivTooltip;", "transform", "Lcom/yandex/div2/DivTransform;", "transitionChange", "Lcom/yandex/div2/DivChangeTransition;", "transitionIn", "Lcom/yandex/div2/DivAppearanceTransition;", "transitionOut", "transitionTriggers", "Lcom/yandex/div2/DivTransitionTrigger;", "variableTriggers", "Lcom/yandex/div2/DivTrigger;", "variables", "Lcom/yandex/div2/DivVariable;", "videoSources", "Lcom/yandex/div2/DivVideoSource;", "visibility", "Lcom/yandex/div2/DivVisibility;", "visibilityAction", "Lcom/yandex/div2/DivVisibilityAction;", "visibilityActions", "width", "(Lcom/yandex/div2/DivAccessibility;Lcom/yandex/div/json/expressions/Expression;Lcom/yandex/div/json/expressions/Expression;Lcom/yandex/div/json/expressions/Expression;Ljava/util/List;Lcom/yandex/div2/DivAspect;Lcom/yandex/div/json/expressions/Expression;Ljava/util/List;Lcom/yandex/div2/DivBorder;Ljava/util/List;Lcom/yandex/div/json/expressions/Expression;Ljava/util/List;Ljava/lang/String;Ljava/util/List;Ljava/util/List;Ljava/util/List;Lcom/yandex/div2/DivFocus;Ljava/util/List;Lcom/yandex/div2/DivSize;Ljava/lang/String;Lcom/yandex/div2/DivLayoutProvider;Lcom/yandex/div2/DivEdgeInsets;Lcom/yandex/div/json/expressions/Expression;Lcom/yandex/div2/DivEdgeInsets;Ljava/util/List;Lorg/json/JSONObject;Lcom/yandex/div/json/expressions/Expression;Lcom/yandex/div/json/expressions/Expression;Lcom/yandex/div/json/expressions/Expression;Ljava/util/List;Lcom/yandex/div/json/expressions/Expression;Lcom/yandex/div/json/expressions/Expression;Lcom/yandex/div/json/expressions/Expression;Ljava/util/List;Ljava/util/List;Lcom/yandex/div2/DivTransform;Lcom/yandex/div2/DivChangeTransition;Lcom/yandex/div2/DivAppearanceTransition;Lcom/yandex/div2/DivAppearanceTransition;Ljava/util/List;Ljava/util/List;Ljava/util/List;Ljava/util/List;Lcom/yandex/div/json/expressions/Expression;Lcom/yandex/div2/DivVisibilityAction;Ljava/util/List;Lcom/yandex/div2/DivSize;)V", "_hash", "", "Ljava/lang/Integer;", "getAccessibility", "()Lcom/yandex/div2/DivAccessibility;", "getAlignmentHorizontal", "()Lcom/yandex/div/json/expressions/Expression;", "getAlignmentVertical", "getAlpha", "getAnimators", "()Ljava/util/List;", "getBackground", "getBorder", "()Lcom/yandex/div2/DivBorder;", "getColumnSpan", "getDisappearActions", "getExtensions", "getFocus", "()Lcom/yandex/div2/DivFocus;", "getFunctions", "getHeight", "()Lcom/yandex/div2/DivSize;", "getId", "()Ljava/lang/String;", "getLayoutProvider", "()Lcom/yandex/div2/DivLayoutProvider;", "getMargins", "()Lcom/yandex/div2/DivEdgeInsets;", "getPaddings", "getReuseId", "getRowSpan", "getSelectedActions", "getTooltips", "getTransform", "()Lcom/yandex/div2/DivTransform;", "getTransitionChange", "()Lcom/yandex/div2/DivChangeTransition;", "getTransitionIn", "()Lcom/yandex/div2/DivAppearanceTransition;", "getTransitionOut", "getTransitionTriggers", "getVariableTriggers", "getVariables", "getVisibility", "getVisibilityAction", "()Lcom/yandex/div2/DivVisibilityAction;", "getVisibilityActions", "getWidth", "copy", "equals", "other", "resolver", "Lcom/yandex/div/json/expressions/ExpressionResolver;", "otherResolver", "hash", "writeToJSON", "Companion", "div-data_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class DivVideo implements JSONSerializable, Hashable, DivBase {
    public static final String TYPE = "video";
    private Integer _hash;
    private final DivAccessibility accessibility;
    private final Expression<DivAlignmentHorizontal> alignmentHorizontal;
    private final Expression<DivAlignmentVertical> alignmentVertical;
    private final Expression<Double> alpha;
    private final List<DivAnimator> animators;
    public final DivAspect aspect;
    public final Expression<Boolean> autostart;
    private final List<DivBackground> background;
    private final DivBorder border;
    public final List<DivAction> bufferingActions;
    private final Expression<Long> columnSpan;
    private final List<DivDisappearAction> disappearActions;
    public final String elapsedTimeVariable;
    public final List<DivAction> endActions;
    private final List<DivExtension> extensions;
    public final List<DivAction> fatalActions;
    private final DivFocus focus;
    private final List<DivFunction> functions;
    private final DivSize height;
    private final String id;
    private final DivLayoutProvider layoutProvider;
    private final DivEdgeInsets margins;
    public final Expression<Boolean> muted;
    private final DivEdgeInsets paddings;
    public final List<DivAction> pauseActions;
    public final JSONObject playerSettingsPayload;
    public final Expression<Boolean> preloadRequired;
    public final Expression<String> preview;
    public final Expression<Boolean> repeatable;
    public final List<DivAction> resumeActions;
    private final Expression<String> reuseId;
    private final Expression<Long> rowSpan;
    public final Expression<DivVideoScale> scale;
    private final List<DivAction> selectedActions;
    private final List<DivTooltip> tooltips;
    private final DivTransform transform;
    private final DivChangeTransition transitionChange;
    private final DivAppearanceTransition transitionIn;
    private final DivAppearanceTransition transitionOut;
    private final List<DivTransitionTrigger> transitionTriggers;
    private final List<DivTrigger> variableTriggers;
    private final List<DivVariable> variables;
    public final List<DivVideoSource> videoSources;
    private final Expression<DivVisibility> visibility;
    private final DivVisibilityAction visibilityAction;
    private final List<DivVisibilityAction> visibilityActions;
    private final DivSize width;

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final Expression<Double> ALPHA_DEFAULT_VALUE = Expression.INSTANCE.constant(Double.valueOf(1.0d));
    private static final Expression<Boolean> AUTOSTART_DEFAULT_VALUE = Expression.INSTANCE.constant(false);
    private static final DivSize.WrapContent HEIGHT_DEFAULT_VALUE = new DivSize.WrapContent(new DivWrapContentSize(null, null, null, 7, null));
    private static final Expression<Boolean> MUTED_DEFAULT_VALUE = Expression.INSTANCE.constant(false);
    private static final Expression<Boolean> PRELOAD_REQUIRED_DEFAULT_VALUE = Expression.INSTANCE.constant(false);
    private static final Expression<Boolean> REPEATABLE_DEFAULT_VALUE = Expression.INSTANCE.constant(false);
    private static final Expression<DivVideoScale> SCALE_DEFAULT_VALUE = Expression.INSTANCE.constant(DivVideoScale.FIT);
    private static final Expression<DivVisibility> VISIBILITY_DEFAULT_VALUE = Expression.INSTANCE.constant(DivVisibility.VISIBLE);
    private static final DivSize.MatchParent WIDTH_DEFAULT_VALUE = new DivSize.MatchParent(new DivMatchParentSize(0 == true ? 1 : 0, 1, 0 == true ? 1 : 0));
    private static final Function2<ParsingEnvironment, JSONObject, DivVideo> CREATOR = new Function2<ParsingEnvironment, JSONObject, DivVideo>() { // from class: com.yandex.div2.DivVideo$Companion$CREATOR$1
        @Override // kotlin.jvm.functions.Function2
        public final DivVideo invoke(ParsingEnvironment env, JSONObject it) {
            Intrinsics.checkNotNullParameter(env, "env");
            Intrinsics.checkNotNullParameter(it, "it");
            return DivVideo.INSTANCE.fromJson(env, it);
        }
    };

    @JvmStatic
    public static final DivVideo fromJson(ParsingEnvironment parsingEnvironment, JSONObject jSONObject) {
        return INSTANCE.fromJson(parsingEnvironment, jSONObject);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public DivVideo(DivAccessibility divAccessibility, Expression<DivAlignmentHorizontal> expression, Expression<DivAlignmentVertical> expression2, Expression<Double> alpha, List<? extends DivAnimator> list, DivAspect divAspect, Expression<Boolean> autostart, List<? extends DivBackground> list2, DivBorder divBorder, List<DivAction> list3, Expression<Long> expression3, List<DivDisappearAction> list4, String str, List<DivAction> list5, List<DivExtension> list6, List<DivAction> list7, DivFocus divFocus, List<DivFunction> list8, DivSize height, String str2, DivLayoutProvider divLayoutProvider, DivEdgeInsets divEdgeInsets, Expression<Boolean> muted, DivEdgeInsets divEdgeInsets2, List<DivAction> list9, JSONObject jSONObject, Expression<Boolean> preloadRequired, Expression<String> expression4, Expression<Boolean> repeatable, List<DivAction> list10, Expression<String> expression5, Expression<Long> expression6, Expression<DivVideoScale> scale, List<DivAction> list11, List<DivTooltip> list12, DivTransform divTransform, DivChangeTransition divChangeTransition, DivAppearanceTransition divAppearanceTransition, DivAppearanceTransition divAppearanceTransition2, List<? extends DivTransitionTrigger> list13, List<DivTrigger> list14, List<? extends DivVariable> list15, List<DivVideoSource> videoSources, Expression<DivVisibility> visibility, DivVisibilityAction divVisibilityAction, List<DivVisibilityAction> list16, DivSize width) {
        Intrinsics.checkNotNullParameter(alpha, "alpha");
        Intrinsics.checkNotNullParameter(autostart, "autostart");
        Intrinsics.checkNotNullParameter(height, "height");
        Intrinsics.checkNotNullParameter(muted, "muted");
        Intrinsics.checkNotNullParameter(preloadRequired, "preloadRequired");
        Intrinsics.checkNotNullParameter(repeatable, "repeatable");
        Intrinsics.checkNotNullParameter(scale, "scale");
        Intrinsics.checkNotNullParameter(videoSources, "videoSources");
        Intrinsics.checkNotNullParameter(visibility, "visibility");
        Intrinsics.checkNotNullParameter(width, "width");
        this.accessibility = divAccessibility;
        this.alignmentHorizontal = expression;
        this.alignmentVertical = expression2;
        this.alpha = alpha;
        this.animators = list;
        this.aspect = divAspect;
        this.autostart = autostart;
        this.background = list2;
        this.border = divBorder;
        this.bufferingActions = list3;
        this.columnSpan = expression3;
        this.disappearActions = list4;
        this.elapsedTimeVariable = str;
        this.endActions = list5;
        this.extensions = list6;
        this.fatalActions = list7;
        this.focus = divFocus;
        this.functions = list8;
        this.height = height;
        this.id = str2;
        this.layoutProvider = divLayoutProvider;
        this.margins = divEdgeInsets;
        this.muted = muted;
        this.paddings = divEdgeInsets2;
        this.pauseActions = list9;
        this.playerSettingsPayload = jSONObject;
        this.preloadRequired = preloadRequired;
        this.preview = expression4;
        this.repeatable = repeatable;
        this.resumeActions = list10;
        this.reuseId = expression5;
        this.rowSpan = expression6;
        this.scale = scale;
        this.selectedActions = list11;
        this.tooltips = list12;
        this.transform = divTransform;
        this.transitionChange = divChangeTransition;
        this.transitionIn = divAppearanceTransition;
        this.transitionOut = divAppearanceTransition2;
        this.transitionTriggers = list13;
        this.variableTriggers = list14;
        this.variables = list15;
        this.videoSources = videoSources;
        this.visibility = visibility;
        this.visibilityAction = divVisibilityAction;
        this.visibilityActions = list16;
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

    public /* synthetic */ DivVideo(DivAccessibility divAccessibility, Expression expression, Expression expression2, Expression expression3, List list, DivAspect divAspect, Expression expression4, List list2, DivBorder divBorder, List list3, Expression expression5, List list4, String str, List list5, List list6, List list7, DivFocus divFocus, List list8, DivSize divSize, String str2, DivLayoutProvider divLayoutProvider, DivEdgeInsets divEdgeInsets, Expression expression6, DivEdgeInsets divEdgeInsets2, List list9, JSONObject jSONObject, Expression expression7, Expression expression8, Expression expression9, List list10, Expression expression10, Expression expression11, Expression expression12, List list11, List list12, DivTransform divTransform, DivChangeTransition divChangeTransition, DivAppearanceTransition divAppearanceTransition, DivAppearanceTransition divAppearanceTransition2, List list13, List list14, List list15, List list16, Expression expression13, DivVisibilityAction divVisibilityAction, List list17, DivSize divSize2, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : divAccessibility, (i & 2) != 0 ? null : expression, (i & 4) != 0 ? null : expression2, (i & 8) != 0 ? ALPHA_DEFAULT_VALUE : expression3, (i & 16) != 0 ? null : list, (i & 32) != 0 ? null : divAspect, (i & 64) != 0 ? AUTOSTART_DEFAULT_VALUE : expression4, (i & 128) != 0 ? null : list2, (i & 256) != 0 ? null : divBorder, (i & 512) != 0 ? null : list3, (i & 1024) != 0 ? null : expression5, (i & 2048) != 0 ? null : list4, (i & 4096) != 0 ? null : str, (i & 8192) != 0 ? null : list5, (i & 16384) != 0 ? null : list6, (32768 & i) != 0 ? null : list7, (65536 & i) != 0 ? null : divFocus, (131072 & i) != 0 ? null : list8, (262144 & i) != 0 ? HEIGHT_DEFAULT_VALUE : divSize, (524288 & i) != 0 ? null : str2, (1048576 & i) != 0 ? null : divLayoutProvider, (2097152 & i) != 0 ? null : divEdgeInsets, (4194304 & i) != 0 ? MUTED_DEFAULT_VALUE : expression6, (8388608 & i) != 0 ? null : divEdgeInsets2, (16777216 & i) != 0 ? null : list9, (33554432 & i) != 0 ? null : jSONObject, (67108864 & i) != 0 ? PRELOAD_REQUIRED_DEFAULT_VALUE : expression7, (134217728 & i) != 0 ? null : expression8, (268435456 & i) != 0 ? REPEATABLE_DEFAULT_VALUE : expression9, (536870912 & i) != 0 ? null : list10, (1073741824 & i) != 0 ? null : expression10, (i & Integer.MIN_VALUE) != 0 ? null : expression11, (i2 & 1) != 0 ? SCALE_DEFAULT_VALUE : expression12, (i2 & 2) != 0 ? null : list11, (i2 & 4) != 0 ? null : list12, (i2 & 8) != 0 ? null : divTransform, (i2 & 16) != 0 ? null : divChangeTransition, (i2 & 32) != 0 ? null : divAppearanceTransition, (i2 & 64) != 0 ? null : divAppearanceTransition2, (i2 & 128) != 0 ? null : list13, (i2 & 256) != 0 ? null : list14, (i2 & 512) != 0 ? null : list15, list16, (i2 & 2048) != 0 ? VISIBILITY_DEFAULT_VALUE : expression13, (i2 & 4096) != 0 ? null : divVisibilityAction, (i2 & 8192) != 0 ? null : list17, (i2 & 16384) != 0 ? WIDTH_DEFAULT_VALUE : divSize2);
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
        int iHash13;
        int iHash14;
        Integer num = this._hash;
        if (num != null) {
            return num.intValue();
        }
        int iHashCode = Reflection.getOrCreateKotlinClass(getClass()).hashCode();
        DivAccessibility accessibility = getAccessibility();
        int iHash15 = 0;
        int iHash16 = iHashCode + (accessibility != null ? accessibility.hash() : 0);
        Expression<DivAlignmentHorizontal> alignmentHorizontal = getAlignmentHorizontal();
        int iHashCode2 = iHash16 + (alignmentHorizontal != null ? alignmentHorizontal.hashCode() : 0);
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
        DivAspect divAspect = this.aspect;
        int iHash17 = i + (divAspect != null ? divAspect.hash() : 0) + this.autostart.hashCode();
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
        int i2 = iHash17 + iHash2;
        DivBorder border = getBorder();
        int iHash18 = i2 + (border != null ? border.hash() : 0);
        List<DivAction> list = this.bufferingActions;
        if (list != null) {
            Iterator<T> it3 = list.iterator();
            iHash3 = 0;
            while (it3.hasNext()) {
                iHash3 += ((DivAction) it3.next()).hash();
            }
        } else {
            iHash3 = 0;
        }
        int i3 = iHash18 + iHash3;
        Expression<Long> columnSpan = getColumnSpan();
        int iHashCode4 = i3 + (columnSpan != null ? columnSpan.hashCode() : 0);
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
        String str = this.elapsedTimeVariable;
        int iHashCode5 = i4 + (str != null ? str.hashCode() : 0);
        List<DivAction> list2 = this.endActions;
        if (list2 != null) {
            Iterator<T> it5 = list2.iterator();
            iHash5 = 0;
            while (it5.hasNext()) {
                iHash5 += ((DivAction) it5.next()).hash();
            }
        } else {
            iHash5 = 0;
        }
        int i5 = iHashCode5 + iHash5;
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
        List<DivAction> list3 = this.fatalActions;
        if (list3 != null) {
            Iterator<T> it7 = list3.iterator();
            iHash7 = 0;
            while (it7.hasNext()) {
                iHash7 += ((DivAction) it7.next()).hash();
            }
        } else {
            iHash7 = 0;
        }
        int i7 = i6 + iHash7;
        DivFocus focus = getFocus();
        int iHash19 = i7 + (focus != null ? focus.hash() : 0);
        List<DivFunction> functions = getFunctions();
        if (functions != null) {
            Iterator<T> it8 = functions.iterator();
            iHash8 = 0;
            while (it8.hasNext()) {
                iHash8 += ((DivFunction) it8.next()).hash();
            }
        } else {
            iHash8 = 0;
        }
        int iHash20 = iHash19 + iHash8 + getHeight().hash();
        String id = getId();
        int iHashCode6 = iHash20 + (id != null ? id.hashCode() : 0);
        DivLayoutProvider layoutProvider = getLayoutProvider();
        int iHash21 = iHashCode6 + (layoutProvider != null ? layoutProvider.hash() : 0);
        DivEdgeInsets margins = getMargins();
        int iHash22 = iHash21 + (margins != null ? margins.hash() : 0) + this.muted.hashCode();
        DivEdgeInsets paddings = getPaddings();
        int iHash23 = iHash22 + (paddings != null ? paddings.hash() : 0);
        List<DivAction> list4 = this.pauseActions;
        if (list4 != null) {
            Iterator<T> it9 = list4.iterator();
            iHash9 = 0;
            while (it9.hasNext()) {
                iHash9 += ((DivAction) it9.next()).hash();
            }
        } else {
            iHash9 = 0;
        }
        int i8 = iHash23 + iHash9;
        JSONObject jSONObject = this.playerSettingsPayload;
        int iHashCode7 = i8 + (jSONObject != null ? jSONObject.hashCode() : 0) + this.preloadRequired.hashCode();
        Expression<String> expression = this.preview;
        int iHashCode8 = iHashCode7 + (expression != null ? expression.hashCode() : 0) + this.repeatable.hashCode();
        List<DivAction> list5 = this.resumeActions;
        if (list5 != null) {
            Iterator<T> it10 = list5.iterator();
            iHash10 = 0;
            while (it10.hasNext()) {
                iHash10 += ((DivAction) it10.next()).hash();
            }
        } else {
            iHash10 = 0;
        }
        int i9 = iHashCode8 + iHash10;
        Expression<String> reuseId = getReuseId();
        int iHashCode9 = i9 + (reuseId != null ? reuseId.hashCode() : 0);
        Expression<Long> rowSpan = getRowSpan();
        int iHashCode10 = iHashCode9 + (rowSpan != null ? rowSpan.hashCode() : 0) + this.scale.hashCode();
        List<DivAction> selectedActions = getSelectedActions();
        if (selectedActions != null) {
            Iterator<T> it11 = selectedActions.iterator();
            iHash11 = 0;
            while (it11.hasNext()) {
                iHash11 += ((DivAction) it11.next()).hash();
            }
        } else {
            iHash11 = 0;
        }
        int i10 = iHashCode10 + iHash11;
        List<DivTooltip> tooltips = getTooltips();
        if (tooltips != null) {
            Iterator<T> it12 = tooltips.iterator();
            iHash12 = 0;
            while (it12.hasNext()) {
                iHash12 += ((DivTooltip) it12.next()).hash();
            }
        } else {
            iHash12 = 0;
        }
        int i11 = i10 + iHash12;
        DivTransform transform = getTransform();
        int iHash24 = i11 + (transform != null ? transform.hash() : 0);
        DivChangeTransition transitionChange = getTransitionChange();
        int iHash25 = iHash24 + (transitionChange != null ? transitionChange.hash() : 0);
        DivAppearanceTransition transitionIn = getTransitionIn();
        int iHash26 = iHash25 + (transitionIn != null ? transitionIn.hash() : 0);
        DivAppearanceTransition transitionOut = getTransitionOut();
        int iHash27 = iHash26 + (transitionOut != null ? transitionOut.hash() : 0);
        List<DivTransitionTrigger> transitionTriggers = getTransitionTriggers();
        int iHashCode11 = iHash27 + (transitionTriggers != null ? transitionTriggers.hashCode() : 0);
        List<DivTrigger> variableTriggers = getVariableTriggers();
        if (variableTriggers != null) {
            Iterator<T> it13 = variableTriggers.iterator();
            iHash13 = 0;
            while (it13.hasNext()) {
                iHash13 += ((DivTrigger) it13.next()).hash();
            }
        } else {
            iHash13 = 0;
        }
        int i12 = iHashCode11 + iHash13;
        List<DivVariable> variables = getVariables();
        if (variables != null) {
            Iterator<T> it14 = variables.iterator();
            iHash14 = 0;
            while (it14.hasNext()) {
                iHash14 += ((DivVariable) it14.next()).hash();
            }
        } else {
            iHash14 = 0;
        }
        int i13 = i12 + iHash14;
        Iterator<T> it15 = this.videoSources.iterator();
        int iHash28 = 0;
        while (it15.hasNext()) {
            iHash28 += ((DivVideoSource) it15.next()).hash();
        }
        int iHashCode12 = i13 + iHash28 + getVisibility().hashCode();
        DivVisibilityAction visibilityAction = getVisibilityAction();
        int iHash29 = iHashCode12 + (visibilityAction != null ? visibilityAction.hash() : 0);
        List<DivVisibilityAction> visibilityActions = getVisibilityActions();
        if (visibilityActions != null) {
            Iterator<T> it16 = visibilityActions.iterator();
            while (it16.hasNext()) {
                iHash15 += ((DivVisibilityAction) it16.next()).hash();
            }
        }
        int iHash30 = iHash29 + iHash15 + getWidth().hash();
        this._hash = Integer.valueOf(iHash30);
        return iHash30;
    }

    public final boolean equals(DivVideo other, ExpressionResolver resolver, ExpressionResolver otherResolver) {
        boolean zEquals;
        boolean z;
        boolean zEquals2;
        boolean z2;
        boolean zEquals3;
        boolean z3;
        boolean z4;
        boolean z5;
        boolean z6;
        boolean z7;
        boolean zEquals4;
        boolean z8;
        boolean zEquals5;
        boolean zEquals6;
        boolean zEquals7;
        boolean z9;
        boolean z10;
        boolean z11;
        boolean z12;
        boolean zEquals8;
        boolean zEquals9;
        boolean zEquals10;
        boolean zEquals11;
        boolean z13;
        boolean z14;
        boolean z15;
        boolean z16;
        boolean zEquals12;
        boolean z17;
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
        DivAspect divAspect = this.aspect;
        if (divAspect != null) {
            zEquals2 = divAspect.equals(other.aspect, resolver, otherResolver);
        } else {
            zEquals2 = other.aspect == null;
        }
        if (!zEquals2 || this.autostart.evaluate(resolver).booleanValue() != other.autostart.evaluate(otherResolver).booleanValue()) {
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
            zEquals3 = border.equals(other.getBorder(), resolver, otherResolver);
        } else {
            zEquals3 = other.getBorder() == null;
        }
        if (!zEquals3) {
            return false;
        }
        List<DivAction> list = this.bufferingActions;
        if (list != null) {
            List<DivAction> list2 = other.bufferingActions;
            if (list2 == null) {
                return false;
            }
            if (list.size() == list2.size()) {
                Iterator<T> it3 = list.iterator();
                int i5 = 0;
                while (true) {
                    if (it3.hasNext()) {
                        Object next3 = it3.next();
                        int i6 = i5 + 1;
                        if (i5 < 0) {
                            CollectionsKt.throwIndexOverflow();
                        }
                        if (((DivAction) next3).equals(list2.get(i5), resolver, otherResolver)) {
                            i5 = i6;
                        }
                    }
                }
            }
        } else {
            z3 = other.bufferingActions == null;
        }
        if (!z3) {
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
        if (!z4 || !Intrinsics.areEqual(this.elapsedTimeVariable, other.elapsedTimeVariable)) {
            return false;
        }
        List<DivAction> list3 = this.endActions;
        if (list3 != null) {
            List<DivAction> list4 = other.endActions;
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
            z5 = other.endActions == null;
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
        List<DivAction> list5 = this.fatalActions;
        if (list5 != null) {
            List<DivAction> list6 = other.fatalActions;
            if (list6 == null) {
                return false;
            }
            if (list5.size() == list6.size()) {
                Iterator<T> it7 = list5.iterator();
                int i13 = 0;
                while (true) {
                    if (it7.hasNext()) {
                        Object next7 = it7.next();
                        int i14 = i13 + 1;
                        if (i13 < 0) {
                            CollectionsKt.throwIndexOverflow();
                        }
                        if (((DivAction) next7).equals(list6.get(i13), resolver, otherResolver)) {
                            i13 = i14;
                        }
                    }
                }
            }
        } else {
            z7 = other.fatalActions == null;
        }
        if (!z7) {
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
                Iterator<T> it8 = functions.iterator();
                int i15 = 0;
                while (true) {
                    if (it8.hasNext()) {
                        Object next8 = it8.next();
                        int i16 = i15 + 1;
                        if (i15 < 0) {
                            CollectionsKt.throwIndexOverflow();
                        }
                        if (((DivFunction) next8).equals(functions2.get(i15), resolver, otherResolver)) {
                            i15 = i16;
                        }
                    }
                }
            }
        } else {
            z8 = other.getFunctions() == null;
        }
        if (!z8 || !getHeight().equals(other.getHeight(), resolver, otherResolver) || !Intrinsics.areEqual(getId(), other.getId())) {
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
        DivEdgeInsets margins = getMargins();
        if (margins != null) {
            zEquals6 = margins.equals(other.getMargins(), resolver, otherResolver);
        } else {
            zEquals6 = other.getMargins() == null;
        }
        if (!zEquals6 || this.muted.evaluate(resolver).booleanValue() != other.muted.evaluate(otherResolver).booleanValue()) {
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
        List<DivAction> list7 = this.pauseActions;
        if (list7 != null) {
            List<DivAction> list8 = other.pauseActions;
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
            z9 = other.pauseActions == null;
        }
        if (!z9 || !Intrinsics.areEqual(this.playerSettingsPayload, other.playerSettingsPayload) || this.preloadRequired.evaluate(resolver).booleanValue() != other.preloadRequired.evaluate(otherResolver).booleanValue()) {
            return false;
        }
        Expression<String> expression = this.preview;
        String strEvaluate = expression != null ? expression.evaluate(resolver) : null;
        Expression<String> expression2 = other.preview;
        if (!Intrinsics.areEqual(strEvaluate, expression2 != null ? expression2.evaluate(otherResolver) : null) || this.repeatable.evaluate(resolver).booleanValue() != other.repeatable.evaluate(otherResolver).booleanValue()) {
            return false;
        }
        List<DivAction> list9 = this.resumeActions;
        if (list9 != null) {
            List<DivAction> list10 = other.resumeActions;
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
                        if (((DivAction) next10).equals(list10.get(i19), resolver, otherResolver)) {
                            i19 = i20;
                        }
                    }
                }
            }
        } else {
            z10 = other.resumeActions == null;
        }
        if (!z10) {
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
        if (!Intrinsics.areEqual(lEvaluate2, rowSpan2 != null ? rowSpan2.evaluate(otherResolver) : null) || this.scale.evaluate(resolver) != other.scale.evaluate(otherResolver)) {
            return false;
        }
        List<DivAction> selectedActions = getSelectedActions();
        if (selectedActions != null) {
            List<DivAction> selectedActions2 = other.getSelectedActions();
            if (selectedActions2 == null) {
                return false;
            }
            if (selectedActions.size() == selectedActions2.size()) {
                Iterator<T> it11 = selectedActions.iterator();
                int i21 = 0;
                while (true) {
                    if (it11.hasNext()) {
                        Object next11 = it11.next();
                        int i22 = i21 + 1;
                        if (i21 < 0) {
                            CollectionsKt.throwIndexOverflow();
                        }
                        if (((DivAction) next11).equals(selectedActions2.get(i21), resolver, otherResolver)) {
                            i21 = i22;
                        }
                    }
                }
            }
        } else {
            z11 = other.getSelectedActions() == null;
        }
        if (!z11) {
            return false;
        }
        List<DivTooltip> tooltips = getTooltips();
        if (tooltips != null) {
            List<DivTooltip> tooltips2 = other.getTooltips();
            if (tooltips2 == null) {
                return false;
            }
            if (tooltips.size() == tooltips2.size()) {
                Iterator<T> it12 = tooltips.iterator();
                int i23 = 0;
                while (true) {
                    if (it12.hasNext()) {
                        Object next12 = it12.next();
                        int i24 = i23 + 1;
                        if (i23 < 0) {
                            CollectionsKt.throwIndexOverflow();
                        }
                        if (((DivTooltip) next12).equals(tooltips2.get(i23), resolver, otherResolver)) {
                            i23 = i24;
                        }
                    }
                }
            }
        } else {
            z12 = other.getTooltips() == null;
        }
        if (!z12) {
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
                Iterator<T> it13 = transitionTriggers.iterator();
                int i25 = 0;
                while (true) {
                    if (it13.hasNext()) {
                        Object next13 = it13.next();
                        int i26 = i25 + 1;
                        if (i25 < 0) {
                            CollectionsKt.throwIndexOverflow();
                        }
                        if (((DivTransitionTrigger) next13) == transitionTriggers2.get(i25)) {
                            i25 = i26;
                        }
                    }
                }
            }
        } else {
            z13 = other.getTransitionTriggers() == null;
        }
        if (!z13) {
            return false;
        }
        List<DivTrigger> variableTriggers = getVariableTriggers();
        if (variableTriggers != null) {
            List<DivTrigger> variableTriggers2 = other.getVariableTriggers();
            if (variableTriggers2 == null) {
                return false;
            }
            if (variableTriggers.size() == variableTriggers2.size()) {
                Iterator<T> it14 = variableTriggers.iterator();
                int i27 = 0;
                while (true) {
                    if (it14.hasNext()) {
                        Object next14 = it14.next();
                        int i28 = i27 + 1;
                        if (i27 < 0) {
                            CollectionsKt.throwIndexOverflow();
                        }
                        if (((DivTrigger) next14).equals(variableTriggers2.get(i27), resolver, otherResolver)) {
                            i27 = i28;
                        }
                    }
                }
            }
        } else {
            z14 = other.getVariableTriggers() == null;
        }
        if (!z14) {
            return false;
        }
        List<DivVariable> variables = getVariables();
        if (variables != null) {
            List<DivVariable> variables2 = other.getVariables();
            if (variables2 == null) {
                return false;
            }
            if (variables.size() == variables2.size()) {
                Iterator<T> it15 = variables.iterator();
                int i29 = 0;
                while (true) {
                    if (it15.hasNext()) {
                        Object next15 = it15.next();
                        int i30 = i29 + 1;
                        if (i29 < 0) {
                            CollectionsKt.throwIndexOverflow();
                        }
                        if (((DivVariable) next15).equals(variables2.get(i29), resolver, otherResolver)) {
                            i29 = i30;
                        }
                    }
                }
            }
        } else {
            z15 = other.getVariables() == null;
        }
        if (!z15) {
            return false;
        }
        List<DivVideoSource> list11 = this.videoSources;
        List<DivVideoSource> list12 = other.videoSources;
        if (list11.size() == list12.size()) {
            Iterator<T> it16 = list11.iterator();
            int i31 = 0;
            while (true) {
                if (!it16.hasNext()) {
                    z16 = true;
                    break;
                }
                Object next16 = it16.next();
                int i32 = i31 + 1;
                if (i31 < 0) {
                    CollectionsKt.throwIndexOverflow();
                }
                if (!((DivVideoSource) next16).equals(list12.get(i31), resolver, otherResolver)) {
                    z16 = false;
                    break;
                }
                i31 = i32;
            }
        } else {
            z16 = false;
            break;
        }
        if (!z16 || getVisibility().evaluate(resolver) != other.getVisibility().evaluate(otherResolver)) {
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
                Iterator<T> it17 = visibilityActions.iterator();
                int i33 = 0;
                while (true) {
                    if (it17.hasNext()) {
                        Object next17 = it17.next();
                        int i34 = i33 + 1;
                        if (i33 < 0) {
                            CollectionsKt.throwIndexOverflow();
                        }
                        if (((DivVisibilityAction) next17).equals(visibilityActions2.get(i33), resolver, otherResolver)) {
                            i33 = i34;
                        }
                    }
                }
            }
        } else {
            z17 = other.getVisibilityActions() == null;
        }
        return z17 && getWidth().equals(other.getWidth(), resolver, otherResolver);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ DivVideo copy$default(DivVideo divVideo, DivAccessibility divAccessibility, Expression expression, Expression expression2, Expression expression3, List list, DivAspect divAspect, Expression expression4, List list2, DivBorder divBorder, List list3, Expression expression5, List list4, String str, List list5, List list6, List list7, DivFocus divFocus, List list8, DivSize divSize, String str2, DivLayoutProvider divLayoutProvider, DivEdgeInsets divEdgeInsets, Expression expression6, DivEdgeInsets divEdgeInsets2, List list9, JSONObject jSONObject, Expression expression7, Expression expression8, Expression expression9, List list10, Expression expression10, Expression expression11, Expression expression12, List list11, List list12, DivTransform divTransform, DivChangeTransition divChangeTransition, DivAppearanceTransition divAppearanceTransition, DivAppearanceTransition divAppearanceTransition2, List list13, List list14, List list15, List list16, Expression expression13, DivVisibilityAction divVisibilityAction, List list17, DivSize divSize2, int i, int i2, Object obj) {
        DivAccessibility accessibility = (i & 1) != 0 ? divVideo.getAccessibility() : divAccessibility;
        Expression alignmentHorizontal = (i & 2) != 0 ? divVideo.getAlignmentHorizontal() : expression;
        Expression alignmentVertical = (i & 4) != 0 ? divVideo.getAlignmentVertical() : expression2;
        Expression alpha = (i & 8) != 0 ? divVideo.getAlpha() : expression3;
        List animators = (i & 16) != 0 ? divVideo.getAnimators() : list;
        DivAspect divAspect2 = (i & 32) != 0 ? divVideo.aspect : divAspect;
        Expression expression14 = (i & 64) != 0 ? divVideo.autostart : expression4;
        List background = (i & 128) != 0 ? divVideo.getBackground() : list2;
        DivBorder border = (i & 256) != 0 ? divVideo.getBorder() : divBorder;
        List list18 = (i & 512) != 0 ? divVideo.bufferingActions : list3;
        Expression columnSpan = (i & 1024) != 0 ? divVideo.getColumnSpan() : expression5;
        List disappearActions = (i & 2048) != 0 ? divVideo.getDisappearActions() : list4;
        String str3 = (i & 4096) != 0 ? divVideo.elapsedTimeVariable : str;
        List list19 = (i & 8192) != 0 ? divVideo.endActions : list5;
        List extensions = (i & 16384) != 0 ? divVideo.getExtensions() : list6;
        List list20 = (i & 32768) != 0 ? divVideo.fatalActions : list7;
        DivFocus focus = (i & 65536) != 0 ? divVideo.getFocus() : divFocus;
        List functions = (i & 131072) != 0 ? divVideo.getFunctions() : list8;
        DivSize height = (i & 262144) != 0 ? divVideo.getHeight() : divSize;
        String id = (i & 524288) != 0 ? divVideo.getId() : str2;
        DivLayoutProvider layoutProvider = (i & 1048576) != 0 ? divVideo.getLayoutProvider() : divLayoutProvider;
        DivEdgeInsets margins = (i & 2097152) != 0 ? divVideo.getMargins() : divEdgeInsets;
        List list21 = list20;
        Expression expression15 = (i & 4194304) != 0 ? divVideo.muted : expression6;
        return divVideo.copy(accessibility, alignmentHorizontal, alignmentVertical, alpha, animators, divAspect2, expression14, background, border, list18, columnSpan, disappearActions, str3, list19, extensions, list21, focus, functions, height, id, layoutProvider, margins, expression15, (i & 8388608) != 0 ? divVideo.getPaddings() : divEdgeInsets2, (i & 16777216) != 0 ? divVideo.pauseActions : list9, (i & 33554432) != 0 ? divVideo.playerSettingsPayload : jSONObject, (i & 67108864) != 0 ? divVideo.preloadRequired : expression7, (i & 134217728) != 0 ? divVideo.preview : expression8, (i & 268435456) != 0 ? divVideo.repeatable : expression9, (i & 536870912) != 0 ? divVideo.resumeActions : list10, (i & 1073741824) != 0 ? divVideo.getReuseId() : expression10, (i & Integer.MIN_VALUE) != 0 ? divVideo.getRowSpan() : expression11, (i2 & 1) != 0 ? divVideo.scale : expression12, (i2 & 2) != 0 ? divVideo.getSelectedActions() : list11, (i2 & 4) != 0 ? divVideo.getTooltips() : list12, (i2 & 8) != 0 ? divVideo.getTransform() : divTransform, (i2 & 16) != 0 ? divVideo.getTransitionChange() : divChangeTransition, (i2 & 32) != 0 ? divVideo.getTransitionIn() : divAppearanceTransition, (i2 & 64) != 0 ? divVideo.getTransitionOut() : divAppearanceTransition2, (i2 & 128) != 0 ? divVideo.getTransitionTriggers() : list13, (i2 & 256) != 0 ? divVideo.getVariableTriggers() : list14, (i2 & 512) != 0 ? divVideo.getVariables() : list15, (i2 & 1024) != 0 ? divVideo.videoSources : list16, (i2 & 2048) != 0 ? divVideo.getVisibility() : expression13, (i2 & 4096) != 0 ? divVideo.getVisibilityAction() : divVisibilityAction, (i2 & 8192) != 0 ? divVideo.getVisibilityActions() : list17, (i2 & 16384) != 0 ? divVideo.getWidth() : divSize2);
    }

    public final DivVideo copy(DivAccessibility accessibility, Expression<DivAlignmentHorizontal> alignmentHorizontal, Expression<DivAlignmentVertical> alignmentVertical, Expression<Double> alpha, List<? extends DivAnimator> animators, DivAspect aspect, Expression<Boolean> autostart, List<? extends DivBackground> background, DivBorder border, List<DivAction> bufferingActions, Expression<Long> columnSpan, List<DivDisappearAction> disappearActions, String elapsedTimeVariable, List<DivAction> endActions, List<DivExtension> extensions, List<DivAction> fatalActions, DivFocus focus, List<DivFunction> functions, DivSize height, String id, DivLayoutProvider layoutProvider, DivEdgeInsets margins, Expression<Boolean> muted, DivEdgeInsets paddings, List<DivAction> pauseActions, JSONObject playerSettingsPayload, Expression<Boolean> preloadRequired, Expression<String> preview, Expression<Boolean> repeatable, List<DivAction> resumeActions, Expression<String> reuseId, Expression<Long> rowSpan, Expression<DivVideoScale> scale, List<DivAction> selectedActions, List<DivTooltip> tooltips, DivTransform transform, DivChangeTransition transitionChange, DivAppearanceTransition transitionIn, DivAppearanceTransition transitionOut, List<? extends DivTransitionTrigger> transitionTriggers, List<DivTrigger> variableTriggers, List<? extends DivVariable> variables, List<DivVideoSource> videoSources, Expression<DivVisibility> visibility, DivVisibilityAction visibilityAction, List<DivVisibilityAction> visibilityActions, DivSize width) {
        Intrinsics.checkNotNullParameter(alpha, "alpha");
        Intrinsics.checkNotNullParameter(autostart, "autostart");
        Intrinsics.checkNotNullParameter(height, "height");
        Intrinsics.checkNotNullParameter(muted, "muted");
        Intrinsics.checkNotNullParameter(preloadRequired, "preloadRequired");
        Intrinsics.checkNotNullParameter(repeatable, "repeatable");
        Intrinsics.checkNotNullParameter(scale, "scale");
        Intrinsics.checkNotNullParameter(videoSources, "videoSources");
        Intrinsics.checkNotNullParameter(visibility, "visibility");
        Intrinsics.checkNotNullParameter(width, "width");
        return new DivVideo(accessibility, alignmentHorizontal, alignmentVertical, alpha, animators, aspect, autostart, background, border, bufferingActions, columnSpan, disappearActions, elapsedTimeVariable, endActions, extensions, fatalActions, focus, functions, height, id, layoutProvider, margins, muted, paddings, pauseActions, playerSettingsPayload, preloadRequired, preview, repeatable, resumeActions, reuseId, rowSpan, scale, selectedActions, tooltips, transform, transitionChange, transitionIn, transitionOut, transitionTriggers, variableTriggers, variables, videoSources, visibility, visibilityAction, visibilityActions, width);
    }

    @Override // com.yandex.div.json.JSONSerializable
    public JSONObject writeToJSON() {
        return BuiltInParserKt.getBuiltInParserComponent().getDivVideoJsonEntityParser().getValue().serialize(BuiltInParserKt.getBuiltInParsingContext(), this);
    }

    /* JADX INFO: compiled from: DivVideo.kt */
    @Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0006\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u001e\u0010\u001c\u001a\u00020\f2\u0006\u0010\u001d\u001a\u00020\n2\u0006\u0010\u001e\u001a\u00020\u000bH\u0087\u0002¢\u0006\u0002\b\u001fR\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00070\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R#\u0010\b\u001a\u0014\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\f0\t¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u000e\u0010\u000f\u001a\u00020\u0010X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00070\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00070\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00070\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00150\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0017X\u0086T¢\u0006\u0002\n\u0000R\u0014\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00190\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u001bX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006 "}, d2 = {"Lcom/yandex/div2/DivVideo$Companion;", "", "()V", "ALPHA_DEFAULT_VALUE", "Lcom/yandex/div/json/expressions/Expression;", "", "AUTOSTART_DEFAULT_VALUE", "", "CREATOR", "Lkotlin/Function2;", "Lcom/yandex/div/json/ParsingEnvironment;", "Lorg/json/JSONObject;", "Lcom/yandex/div2/DivVideo;", "getCREATOR", "()Lkotlin/jvm/functions/Function2;", "HEIGHT_DEFAULT_VALUE", "Lcom/yandex/div2/DivSize$WrapContent;", "MUTED_DEFAULT_VALUE", "PRELOAD_REQUIRED_DEFAULT_VALUE", "REPEATABLE_DEFAULT_VALUE", "SCALE_DEFAULT_VALUE", "Lcom/yandex/div2/DivVideoScale;", "TYPE", "", "VISIBILITY_DEFAULT_VALUE", "Lcom/yandex/div2/DivVisibility;", "WIDTH_DEFAULT_VALUE", "Lcom/yandex/div2/DivSize$MatchParent;", "invoke", cc.o, "json", "fromJson", "div-data_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @JvmStatic
        public final DivVideo fromJson(ParsingEnvironment env, JSONObject json) {
            Intrinsics.checkNotNullParameter(env, "env");
            Intrinsics.checkNotNullParameter(json, "json");
            return BuiltInParserKt.getBuiltInParserComponent().getDivVideoJsonEntityParser().getValue().deserialize((ParsingContext) env, json);
        }

        public final Function2<ParsingEnvironment, JSONObject, DivVideo> getCREATOR() {
            return DivVideo.CREATOR;
        }
    }
}
