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
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import org.json.JSONObject;

/* JADX INFO: compiled from: DivIndicator.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000ü\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0006\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b4\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 \u008d\u00012\u00020\u00012\u00020\u00022\u00020\u0003:\u0004\u008c\u0001\u008d\u0001B\u008b\u0005\b\u0007\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\u000e\b\u0002\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007\u0012\u000e\b\u0002\u0010\t\u001a\b\u0012\u0004\u0012\u00020\n0\u0007\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\f\u0012\u0010\b\u0002\u0010\r\u001a\n\u0012\u0004\u0012\u00020\u000e\u0018\u00010\u0007\u0012\u0010\b\u0002\u0010\u000f\u001a\n\u0012\u0004\u0012\u00020\u0010\u0018\u00010\u0007\u0012\u000e\b\u0002\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\n0\u0007\u0012\u000e\b\u0002\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00130\u0007\u0012\u0010\b\u0002\u0010\u0014\u001a\n\u0012\u0004\u0012\u00020\u0016\u0018\u00010\u0015\u0012\u0010\b\u0002\u0010\u0017\u001a\n\u0012\u0004\u0012\u00020\u0018\u0018\u00010\u0015\u0012\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u001a\u0012\u0010\b\u0002\u0010\u001b\u001a\n\u0012\u0004\u0012\u00020\u001c\u0018\u00010\u0007\u0012\u0010\b\u0002\u0010\u001d\u001a\n\u0012\u0004\u0012\u00020\u001e\u0018\u00010\u0015\u0012\u0010\b\u0002\u0010\u001f\u001a\n\u0012\u0004\u0012\u00020 \u0018\u00010\u0015\u0012\n\b\u0002\u0010!\u001a\u0004\u0018\u00010\"\u0012\u0010\b\u0002\u0010#\u001a\n\u0012\u0004\u0012\u00020$\u0018\u00010\u0015\u0012\b\b\u0002\u0010%\u001a\u00020&\u0012\n\b\u0002\u0010'\u001a\u0004\u0018\u00010(\u0012\u000e\b\u0002\u0010)\u001a\b\u0012\u0004\u0012\u00020\b0\u0007\u0012\n\b\u0002\u0010*\u001a\u0004\u0018\u00010\f\u0012\n\b\u0002\u0010+\u001a\u0004\u0018\u00010\f\u0012\n\b\u0002\u0010,\u001a\u0004\u0018\u00010-\u0012\n\b\u0002\u0010.\u001a\u0004\u0018\u00010/\u0012\n\b\u0002\u00100\u001a\u0004\u0018\u000101\u0012\u000e\b\u0002\u00102\u001a\b\u0012\u0004\u0012\u00020\n0\u0007\u0012\n\b\u0002\u00103\u001a\u0004\u0018\u000101\u0012\n\b\u0002\u00104\u001a\u0004\u0018\u00010(\u0012\u0010\b\u0002\u00105\u001a\n\u0012\u0004\u0012\u00020(\u0018\u00010\u0007\u0012\u0010\b\u0002\u00106\u001a\n\u0012\u0004\u0012\u00020\u001c\u0018\u00010\u0007\u0012\u0010\b\u0002\u00107\u001a\n\u0012\u0004\u0012\u000208\u0018\u00010\u0015\u0012\b\b\u0002\u00109\u001a\u00020:\u0012\b\b\u0002\u0010;\u001a\u00020<\u0012\u0010\b\u0002\u0010=\u001a\n\u0012\u0004\u0012\u00020>\u0018\u00010\u0015\u0012\n\b\u0002\u0010?\u001a\u0004\u0018\u00010@\u0012\n\b\u0002\u0010A\u001a\u0004\u0018\u00010B\u0012\n\b\u0002\u0010C\u001a\u0004\u0018\u00010D\u0012\n\b\u0002\u0010E\u001a\u0004\u0018\u00010D\u0012\u0010\b\u0002\u0010F\u001a\n\u0012\u0004\u0012\u00020G\u0018\u00010\u0015\u0012\u0010\b\u0002\u0010H\u001a\n\u0012\u0004\u0012\u00020I\u0018\u00010\u0015\u0012\u0010\b\u0002\u0010J\u001a\n\u0012\u0004\u0012\u00020K\u0018\u00010\u0015\u0012\u000e\b\u0002\u0010L\u001a\b\u0012\u0004\u0012\u00020M0\u0007\u0012\n\b\u0002\u0010N\u001a\u0004\u0018\u00010O\u0012\u0010\b\u0002\u0010P\u001a\n\u0012\u0004\u0012\u00020O\u0018\u00010\u0015\u0012\b\b\u0002\u0010Q\u001a\u00020&¢\u0006\u0002\u0010RJ\u008b\u0005\u0010\u0082\u0001\u001a\u00020\u00002\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u000e\b\u0002\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u00072\u000e\b\u0002\u0010\t\u001a\b\u0012\u0004\u0012\u00020\n0\u00072\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\f2\u0010\b\u0002\u0010\r\u001a\n\u0012\u0004\u0012\u00020\u000e\u0018\u00010\u00072\u0010\b\u0002\u0010\u000f\u001a\n\u0012\u0004\u0012\u00020\u0010\u0018\u00010\u00072\u000e\b\u0002\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\n0\u00072\u000e\b\u0002\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00130\u00072\u0010\b\u0002\u0010\u0014\u001a\n\u0012\u0004\u0012\u00020\u0016\u0018\u00010\u00152\u0010\b\u0002\u0010\u0017\u001a\n\u0012\u0004\u0012\u00020\u0018\u0018\u00010\u00152\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u001a2\u0010\b\u0002\u0010\u001b\u001a\n\u0012\u0004\u0012\u00020\u001c\u0018\u00010\u00072\u0010\b\u0002\u0010\u001d\u001a\n\u0012\u0004\u0012\u00020\u001e\u0018\u00010\u00152\u0010\b\u0002\u0010\u001f\u001a\n\u0012\u0004\u0012\u00020 \u0018\u00010\u00152\n\b\u0002\u0010!\u001a\u0004\u0018\u00010\"2\u0010\b\u0002\u0010#\u001a\n\u0012\u0004\u0012\u00020$\u0018\u00010\u00152\b\b\u0002\u0010%\u001a\u00020&2\n\b\u0002\u0010'\u001a\u0004\u0018\u00010(2\u000e\b\u0002\u0010)\u001a\b\u0012\u0004\u0012\u00020\b0\u00072\n\b\u0002\u0010*\u001a\u0004\u0018\u00010\f2\n\b\u0002\u0010+\u001a\u0004\u0018\u00010\f2\n\b\u0002\u0010,\u001a\u0004\u0018\u00010-2\n\b\u0002\u0010.\u001a\u0004\u0018\u00010/2\n\b\u0002\u00100\u001a\u0004\u0018\u0001012\u000e\b\u0002\u00102\u001a\b\u0012\u0004\u0012\u00020\n0\u00072\n\b\u0002\u00103\u001a\u0004\u0018\u0001012\n\b\u0002\u00104\u001a\u0004\u0018\u00010(2\u0010\b\u0002\u00105\u001a\n\u0012\u0004\u0012\u00020(\u0018\u00010\u00072\u0010\b\u0002\u00106\u001a\n\u0012\u0004\u0012\u00020\u001c\u0018\u00010\u00072\u0010\b\u0002\u00107\u001a\n\u0012\u0004\u0012\u000208\u0018\u00010\u00152\b\b\u0002\u00109\u001a\u00020:2\b\b\u0002\u0010;\u001a\u00020<2\u0010\b\u0002\u0010=\u001a\n\u0012\u0004\u0012\u00020>\u0018\u00010\u00152\n\b\u0002\u0010?\u001a\u0004\u0018\u00010@2\n\b\u0002\u0010A\u001a\u0004\u0018\u00010B2\n\b\u0002\u0010C\u001a\u0004\u0018\u00010D2\n\b\u0002\u0010E\u001a\u0004\u0018\u00010D2\u0010\b\u0002\u0010F\u001a\n\u0012\u0004\u0012\u00020G\u0018\u00010\u00152\u0010\b\u0002\u0010H\u001a\n\u0012\u0004\u0012\u00020I\u0018\u00010\u00152\u0010\b\u0002\u0010J\u001a\n\u0012\u0004\u0012\u00020K\u0018\u00010\u00152\u000e\b\u0002\u0010L\u001a\b\u0012\u0004\u0012\u00020M0\u00072\n\b\u0002\u0010N\u001a\u0004\u0018\u00010O2\u0010\b\u0002\u0010P\u001a\n\u0012\u0004\u0012\u00020O\u0018\u00010\u00152\b\b\u0002\u0010Q\u001a\u00020&J'\u0010\u0083\u0001\u001a\u00030\u0084\u00012\t\u0010\u0085\u0001\u001a\u0004\u0018\u00010\u00002\b\u0010\u0086\u0001\u001a\u00030\u0087\u00012\b\u0010\u0088\u0001\u001a\u00030\u0087\u0001J\t\u0010\u0089\u0001\u001a\u00020\bH\u0016J\n\u0010\u008a\u0001\u001a\u00030\u008b\u0001H\u0016R\u0012\u0010S\u001a\u0004\u0018\u00010\bX\u0082\u000e¢\u0006\u0004\n\u0002\u0010TR\u0016\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\bU\u0010VR\u0016\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u00078\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\t\u001a\b\u0012\u0004\u0012\u00020\n0\u00078\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0012\u0010\u000b\u001a\u0004\u0018\u00010\f8\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\r\u001a\n\u0012\u0004\u0012\u00020\u000e\u0018\u00010\u0007X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\bW\u0010XR\u001c\u0010\u000f\u001a\n\u0012\u0004\u0012\u00020\u0010\u0018\u00010\u0007X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\bY\u0010XR\u001a\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\n0\u0007X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\bZ\u0010XR\u0016\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00130\u00078\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\u0014\u001a\n\u0012\u0004\u0012\u00020\u0016\u0018\u00010\u0015X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b[\u0010\\R\u001c\u0010\u0017\u001a\n\u0012\u0004\u0012\u00020\u0018\u0018\u00010\u0015X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b]\u0010\\R\u0016\u0010\u0019\u001a\u0004\u0018\u00010\u001aX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b^\u0010_R\u001c\u0010\u001b\u001a\n\u0012\u0004\u0012\u00020\u001c\u0018\u00010\u0007X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b`\u0010XR\u001c\u0010\u001d\u001a\n\u0012\u0004\u0012\u00020\u001e\u0018\u00010\u0015X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\ba\u0010\\R\u001c\u0010\u001f\u001a\n\u0012\u0004\u0012\u00020 \u0018\u00010\u0015X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\bb\u0010\\R\u0016\u0010!\u001a\u0004\u0018\u00010\"X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\bc\u0010dR\u001c\u0010#\u001a\n\u0012\u0004\u0012\u00020$\u0018\u00010\u0015X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\be\u0010\\R\u0014\u0010%\u001a\u00020&X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\bf\u0010gR\u0016\u0010'\u001a\u0004\u0018\u00010(X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\bh\u0010iR\u0016\u0010)\u001a\b\u0012\u0004\u0012\u00020\b0\u00078\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0012\u0010*\u001a\u0004\u0018\u00010\f8\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0012\u0010+\u001a\u0004\u0018\u00010\f8\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0012\u0010,\u001a\u0004\u0018\u00010-8\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0016\u0010.\u001a\u0004\u0018\u00010/X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\bj\u0010kR\u0016\u00100\u001a\u0004\u0018\u000101X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\bl\u0010mR\u0016\u00102\u001a\b\u0012\u0004\u0012\u00020\n0\u00078\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0016\u00103\u001a\u0004\u0018\u000101X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\bn\u0010mR\u0012\u00104\u001a\u0004\u0018\u00010(8\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u001c\u00105\u001a\n\u0012\u0004\u0012\u00020(\u0018\u00010\u0007X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\bo\u0010XR\u001c\u00106\u001a\n\u0012\u0004\u0012\u00020\u001c\u0018\u00010\u0007X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\bp\u0010XR\u001c\u00107\u001a\n\u0012\u0004\u0012\u000208\u0018\u00010\u0015X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\bq\u0010\\R\u0010\u00109\u001a\u00020:8\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0010\u0010;\u001a\u00020<8\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u001c\u0010=\u001a\n\u0012\u0004\u0012\u00020>\u0018\u00010\u0015X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\br\u0010\\R\u0016\u0010?\u001a\u0004\u0018\u00010@X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\bs\u0010tR\u0016\u0010A\u001a\u0004\u0018\u00010BX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\bu\u0010vR\u0016\u0010C\u001a\u0004\u0018\u00010DX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\bw\u0010xR\u0016\u0010E\u001a\u0004\u0018\u00010DX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\by\u0010xR\u001c\u0010F\u001a\n\u0012\u0004\u0012\u00020G\u0018\u00010\u0015X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\bz\u0010\\R\u001c\u0010H\u001a\n\u0012\u0004\u0012\u00020I\u0018\u00010\u0015X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b{\u0010\\R\u001c\u0010J\u001a\n\u0012\u0004\u0012\u00020K\u0018\u00010\u0015X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b|\u0010\\R\u001a\u0010L\u001a\b\u0012\u0004\u0012\u00020M0\u0007X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b}\u0010XR\u0016\u0010N\u001a\u0004\u0018\u00010OX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b~\u0010\u007fR\u001d\u0010P\u001a\n\u0012\u0004\u0012\u00020O\u0018\u00010\u0015X\u0096\u0004¢\u0006\t\n\u0000\u001a\u0005\b\u0080\u0001\u0010\\R\u0015\u0010Q\u001a\u00020&X\u0096\u0004¢\u0006\t\n\u0000\u001a\u0005\b\u0081\u0001\u0010g¨\u0006\u008e\u0001"}, d2 = {"Lcom/yandex/div2/DivIndicator;", "Lcom/yandex/div/json/JSONSerializable;", "Lcom/yandex/div/data/Hashable;", "Lcom/yandex/div2/DivBase;", "accessibility", "Lcom/yandex/div2/DivAccessibility;", "activeItemColor", "Lcom/yandex/div/json/expressions/Expression;", "", "activeItemSize", "", "activeShape", "Lcom/yandex/div2/DivRoundedRectangleShape;", "alignmentHorizontal", "Lcom/yandex/div2/DivAlignmentHorizontal;", "alignmentVertical", "Lcom/yandex/div2/DivAlignmentVertical;", "alpha", "animation", "Lcom/yandex/div2/DivIndicator$Animation;", "animators", "", "Lcom/yandex/div2/DivAnimator;", J2.g, "Lcom/yandex/div2/DivBackground;", OutlinedTextFieldKt.BorderId, "Lcom/yandex/div2/DivBorder;", "columnSpan", "", "disappearActions", "Lcom/yandex/div2/DivDisappearAction;", "extensions", "Lcom/yandex/div2/DivExtension;", "focus", "Lcom/yandex/div2/DivFocus;", "functions", "Lcom/yandex/div2/DivFunction;", "height", "Lcom/yandex/div2/DivSize;", "id", "", "inactiveItemColor", "inactiveMinimumShape", "inactiveShape", "itemsPlacement", "Lcom/yandex/div2/DivIndicatorItemPlacement;", "layoutProvider", "Lcom/yandex/div2/DivLayoutProvider;", "margins", "Lcom/yandex/div2/DivEdgeInsets;", "minimumItemSize", "paddings", "pagerId", "reuseId", "rowSpan", "selectedActions", "Lcom/yandex/div2/DivAction;", "shape", "Lcom/yandex/div2/DivShape;", "spaceBetweenCenters", "Lcom/yandex/div2/DivFixedSize;", "tooltips", "Lcom/yandex/div2/DivTooltip;", "transform", "Lcom/yandex/div2/DivTransform;", "transitionChange", "Lcom/yandex/div2/DivChangeTransition;", "transitionIn", "Lcom/yandex/div2/DivAppearanceTransition;", "transitionOut", "transitionTriggers", "Lcom/yandex/div2/DivTransitionTrigger;", "variableTriggers", "Lcom/yandex/div2/DivTrigger;", "variables", "Lcom/yandex/div2/DivVariable;", "visibility", "Lcom/yandex/div2/DivVisibility;", "visibilityAction", "Lcom/yandex/div2/DivVisibilityAction;", "visibilityActions", "width", "(Lcom/yandex/div2/DivAccessibility;Lcom/yandex/div/json/expressions/Expression;Lcom/yandex/div/json/expressions/Expression;Lcom/yandex/div2/DivRoundedRectangleShape;Lcom/yandex/div/json/expressions/Expression;Lcom/yandex/div/json/expressions/Expression;Lcom/yandex/div/json/expressions/Expression;Lcom/yandex/div/json/expressions/Expression;Ljava/util/List;Ljava/util/List;Lcom/yandex/div2/DivBorder;Lcom/yandex/div/json/expressions/Expression;Ljava/util/List;Ljava/util/List;Lcom/yandex/div2/DivFocus;Ljava/util/List;Lcom/yandex/div2/DivSize;Ljava/lang/String;Lcom/yandex/div/json/expressions/Expression;Lcom/yandex/div2/DivRoundedRectangleShape;Lcom/yandex/div2/DivRoundedRectangleShape;Lcom/yandex/div2/DivIndicatorItemPlacement;Lcom/yandex/div2/DivLayoutProvider;Lcom/yandex/div2/DivEdgeInsets;Lcom/yandex/div/json/expressions/Expression;Lcom/yandex/div2/DivEdgeInsets;Ljava/lang/String;Lcom/yandex/div/json/expressions/Expression;Lcom/yandex/div/json/expressions/Expression;Ljava/util/List;Lcom/yandex/div2/DivShape;Lcom/yandex/div2/DivFixedSize;Ljava/util/List;Lcom/yandex/div2/DivTransform;Lcom/yandex/div2/DivChangeTransition;Lcom/yandex/div2/DivAppearanceTransition;Lcom/yandex/div2/DivAppearanceTransition;Ljava/util/List;Ljava/util/List;Ljava/util/List;Lcom/yandex/div/json/expressions/Expression;Lcom/yandex/div2/DivVisibilityAction;Ljava/util/List;Lcom/yandex/div2/DivSize;)V", "_hash", "Ljava/lang/Integer;", "getAccessibility", "()Lcom/yandex/div2/DivAccessibility;", "getAlignmentHorizontal", "()Lcom/yandex/div/json/expressions/Expression;", "getAlignmentVertical", "getAlpha", "getAnimators", "()Ljava/util/List;", "getBackground", "getBorder", "()Lcom/yandex/div2/DivBorder;", "getColumnSpan", "getDisappearActions", "getExtensions", "getFocus", "()Lcom/yandex/div2/DivFocus;", "getFunctions", "getHeight", "()Lcom/yandex/div2/DivSize;", "getId", "()Ljava/lang/String;", "getLayoutProvider", "()Lcom/yandex/div2/DivLayoutProvider;", "getMargins", "()Lcom/yandex/div2/DivEdgeInsets;", "getPaddings", "getReuseId", "getRowSpan", "getSelectedActions", "getTooltips", "getTransform", "()Lcom/yandex/div2/DivTransform;", "getTransitionChange", "()Lcom/yandex/div2/DivChangeTransition;", "getTransitionIn", "()Lcom/yandex/div2/DivAppearanceTransition;", "getTransitionOut", "getTransitionTriggers", "getVariableTriggers", "getVariables", "getVisibility", "getVisibilityAction", "()Lcom/yandex/div2/DivVisibilityAction;", "getVisibilityActions", "getWidth", "copy", "equals", "", "other", "resolver", "Lcom/yandex/div/json/expressions/ExpressionResolver;", "otherResolver", "hash", "writeToJSON", "Lorg/json/JSONObject;", "Animation", "Companion", "div-data_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class DivIndicator implements JSONSerializable, Hashable, DivBase {
    private static final Function2<ParsingEnvironment, JSONObject, DivIndicator> CREATOR;
    private static final DivShape.RoundedRectangle SHAPE_DEFAULT_VALUE;
    private static final DivFixedSize SPACE_BETWEEN_CENTERS_DEFAULT_VALUE;
    public static final String TYPE = "indicator";
    private static final Expression<DivVisibility> VISIBILITY_DEFAULT_VALUE;
    private static final DivSize.MatchParent WIDTH_DEFAULT_VALUE;
    private Integer _hash;
    private final DivAccessibility accessibility;
    public final Expression<Integer> activeItemColor;
    public final Expression<Double> activeItemSize;
    public final DivRoundedRectangleShape activeShape;
    private final Expression<DivAlignmentHorizontal> alignmentHorizontal;
    private final Expression<DivAlignmentVertical> alignmentVertical;
    private final Expression<Double> alpha;
    public final Expression<Animation> animation;
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
    public final Expression<Integer> inactiveItemColor;
    public final DivRoundedRectangleShape inactiveMinimumShape;
    public final DivRoundedRectangleShape inactiveShape;
    public final DivIndicatorItemPlacement itemsPlacement;
    private final DivLayoutProvider layoutProvider;
    private final DivEdgeInsets margins;
    public final Expression<Double> minimumItemSize;
    private final DivEdgeInsets paddings;
    public final String pagerId;
    private final Expression<String> reuseId;
    private final Expression<Long> rowSpan;
    private final List<DivAction> selectedActions;
    public final DivShape shape;
    public final DivFixedSize spaceBetweenCenters;
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

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final Expression<Integer> ACTIVE_ITEM_COLOR_DEFAULT_VALUE = Expression.INSTANCE.constant(16768096);
    private static final Expression<Double> ACTIVE_ITEM_SIZE_DEFAULT_VALUE = Expression.INSTANCE.constant(Double.valueOf(1.3d));
    private static final Expression<Double> ALPHA_DEFAULT_VALUE = Expression.INSTANCE.constant(Double.valueOf(1.0d));
    private static final Expression<Animation> ANIMATION_DEFAULT_VALUE = Expression.INSTANCE.constant(Animation.SCALE);
    private static final DivSize.WrapContent HEIGHT_DEFAULT_VALUE = new DivSize.WrapContent(new DivWrapContentSize(null, null, null, 7, null));
    private static final Expression<Integer> INACTIVE_ITEM_COLOR_DEFAULT_VALUE = Expression.INSTANCE.constant(865180853);
    private static final Expression<Double> MINIMUM_ITEM_SIZE_DEFAULT_VALUE = Expression.INSTANCE.constant(Double.valueOf(0.5d));

    public DivIndicator() {
        this(null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, -1, 4095, null);
    }

    @JvmStatic
    public static final DivIndicator fromJson(ParsingEnvironment parsingEnvironment, JSONObject jSONObject) {
        return INSTANCE.fromJson(parsingEnvironment, jSONObject);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public DivIndicator(DivAccessibility divAccessibility, Expression<Integer> activeItemColor, Expression<Double> activeItemSize, DivRoundedRectangleShape divRoundedRectangleShape, Expression<DivAlignmentHorizontal> expression, Expression<DivAlignmentVertical> expression2, Expression<Double> alpha, Expression<Animation> animation, List<? extends DivAnimator> list, List<? extends DivBackground> list2, DivBorder divBorder, Expression<Long> expression3, List<DivDisappearAction> list3, List<DivExtension> list4, DivFocus divFocus, List<DivFunction> list5, DivSize height, String str, Expression<Integer> inactiveItemColor, DivRoundedRectangleShape divRoundedRectangleShape2, DivRoundedRectangleShape divRoundedRectangleShape3, DivIndicatorItemPlacement divIndicatorItemPlacement, DivLayoutProvider divLayoutProvider, DivEdgeInsets divEdgeInsets, Expression<Double> minimumItemSize, DivEdgeInsets divEdgeInsets2, String str2, Expression<String> expression4, Expression<Long> expression5, List<DivAction> list6, DivShape shape, DivFixedSize spaceBetweenCenters, List<DivTooltip> list7, DivTransform divTransform, DivChangeTransition divChangeTransition, DivAppearanceTransition divAppearanceTransition, DivAppearanceTransition divAppearanceTransition2, List<? extends DivTransitionTrigger> list8, List<DivTrigger> list9, List<? extends DivVariable> list10, Expression<DivVisibility> visibility, DivVisibilityAction divVisibilityAction, List<DivVisibilityAction> list11, DivSize width) {
        Intrinsics.checkNotNullParameter(activeItemColor, "activeItemColor");
        Intrinsics.checkNotNullParameter(activeItemSize, "activeItemSize");
        Intrinsics.checkNotNullParameter(alpha, "alpha");
        Intrinsics.checkNotNullParameter(animation, "animation");
        Intrinsics.checkNotNullParameter(height, "height");
        Intrinsics.checkNotNullParameter(inactiveItemColor, "inactiveItemColor");
        Intrinsics.checkNotNullParameter(minimumItemSize, "minimumItemSize");
        Intrinsics.checkNotNullParameter(shape, "shape");
        Intrinsics.checkNotNullParameter(spaceBetweenCenters, "spaceBetweenCenters");
        Intrinsics.checkNotNullParameter(visibility, "visibility");
        Intrinsics.checkNotNullParameter(width, "width");
        this.accessibility = divAccessibility;
        this.activeItemColor = activeItemColor;
        this.activeItemSize = activeItemSize;
        this.activeShape = divRoundedRectangleShape;
        this.alignmentHorizontal = expression;
        this.alignmentVertical = expression2;
        this.alpha = alpha;
        this.animation = animation;
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
        this.inactiveItemColor = inactiveItemColor;
        this.inactiveMinimumShape = divRoundedRectangleShape2;
        this.inactiveShape = divRoundedRectangleShape3;
        this.itemsPlacement = divIndicatorItemPlacement;
        this.layoutProvider = divLayoutProvider;
        this.margins = divEdgeInsets;
        this.minimumItemSize = minimumItemSize;
        this.paddings = divEdgeInsets2;
        this.pagerId = str2;
        this.reuseId = expression4;
        this.rowSpan = expression5;
        this.selectedActions = list6;
        this.shape = shape;
        this.spaceBetweenCenters = spaceBetweenCenters;
        this.tooltips = list7;
        this.transform = divTransform;
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

    public /* synthetic */ DivIndicator(DivAccessibility divAccessibility, Expression expression, Expression expression2, DivRoundedRectangleShape divRoundedRectangleShape, Expression expression3, Expression expression4, Expression expression5, Expression expression6, List list, List list2, DivBorder divBorder, Expression expression7, List list3, List list4, DivFocus divFocus, List list5, DivSize divSize, String str, Expression expression8, DivRoundedRectangleShape divRoundedRectangleShape2, DivRoundedRectangleShape divRoundedRectangleShape3, DivIndicatorItemPlacement divIndicatorItemPlacement, DivLayoutProvider divLayoutProvider, DivEdgeInsets divEdgeInsets, Expression expression9, DivEdgeInsets divEdgeInsets2, String str2, Expression expression10, Expression expression11, List list6, DivShape divShape, DivFixedSize divFixedSize, List list7, DivTransform divTransform, DivChangeTransition divChangeTransition, DivAppearanceTransition divAppearanceTransition, DivAppearanceTransition divAppearanceTransition2, List list8, List list9, List list10, Expression expression12, DivVisibilityAction divVisibilityAction, List list11, DivSize divSize2, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : divAccessibility, (i & 2) != 0 ? ACTIVE_ITEM_COLOR_DEFAULT_VALUE : expression, (i & 4) != 0 ? ACTIVE_ITEM_SIZE_DEFAULT_VALUE : expression2, (i & 8) != 0 ? null : divRoundedRectangleShape, (i & 16) != 0 ? null : expression3, (i & 32) != 0 ? null : expression4, (i & 64) != 0 ? ALPHA_DEFAULT_VALUE : expression5, (i & 128) != 0 ? ANIMATION_DEFAULT_VALUE : expression6, (i & 256) != 0 ? null : list, (i & 512) != 0 ? null : list2, (i & 1024) != 0 ? null : divBorder, (i & 2048) != 0 ? null : expression7, (i & 4096) != 0 ? null : list3, (i & 8192) != 0 ? null : list4, (i & 16384) != 0 ? null : divFocus, (i & 32768) != 0 ? null : list5, (i & 65536) != 0 ? HEIGHT_DEFAULT_VALUE : divSize, (i & 131072) != 0 ? null : str, (i & 262144) != 0 ? INACTIVE_ITEM_COLOR_DEFAULT_VALUE : expression8, (i & 524288) != 0 ? null : divRoundedRectangleShape2, (i & 1048576) != 0 ? null : divRoundedRectangleShape3, (i & 2097152) != 0 ? null : divIndicatorItemPlacement, (i & 4194304) != 0 ? null : divLayoutProvider, (i & 8388608) != 0 ? null : divEdgeInsets, (i & 16777216) != 0 ? MINIMUM_ITEM_SIZE_DEFAULT_VALUE : expression9, (i & 33554432) != 0 ? null : divEdgeInsets2, (i & 67108864) != 0 ? null : str2, (i & 134217728) != 0 ? null : expression10, (i & 268435456) != 0 ? null : expression11, (i & 536870912) != 0 ? null : list6, (i & 1073741824) != 0 ? SHAPE_DEFAULT_VALUE : divShape, (i & Integer.MIN_VALUE) != 0 ? SPACE_BETWEEN_CENTERS_DEFAULT_VALUE : divFixedSize, (i2 & 1) != 0 ? null : list7, (i2 & 2) != 0 ? null : divTransform, (i2 & 4) != 0 ? null : divChangeTransition, (i2 & 8) != 0 ? null : divAppearanceTransition, (i2 & 16) != 0 ? null : divAppearanceTransition2, (i2 & 32) != 0 ? null : list8, (i2 & 64) != 0 ? null : list9, (i2 & 128) != 0 ? null : list10, (i2 & 256) != 0 ? VISIBILITY_DEFAULT_VALUE : expression12, (i2 & 512) != 0 ? null : divVisibilityAction, (i2 & 1024) != 0 ? null : list11, (i2 & 2048) != 0 ? WIDTH_DEFAULT_VALUE : divSize2);
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
        Integer num = this._hash;
        if (num != null) {
            return num.intValue();
        }
        int iHashCode = Reflection.getOrCreateKotlinClass(getClass()).hashCode();
        DivAccessibility accessibility = getAccessibility();
        int iHash10 = 0;
        int iHash11 = iHashCode + (accessibility != null ? accessibility.hash() : 0) + this.activeItemColor.hashCode() + this.activeItemSize.hashCode();
        DivRoundedRectangleShape divRoundedRectangleShape = this.activeShape;
        int iHash12 = iHash11 + (divRoundedRectangleShape != null ? divRoundedRectangleShape.hash() : 0);
        Expression<DivAlignmentHorizontal> alignmentHorizontal = getAlignmentHorizontal();
        int iHashCode2 = iHash12 + (alignmentHorizontal != null ? alignmentHorizontal.hashCode() : 0);
        Expression<DivAlignmentVertical> alignmentVertical = getAlignmentVertical();
        int iHashCode3 = iHashCode2 + (alignmentVertical != null ? alignmentVertical.hashCode() : 0) + getAlpha().hashCode() + this.animation.hashCode();
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
        int iHashCode5 = iHash15 + (id != null ? id.hashCode() : 0) + this.inactiveItemColor.hashCode();
        DivRoundedRectangleShape divRoundedRectangleShape2 = this.inactiveMinimumShape;
        int iHash16 = iHashCode5 + (divRoundedRectangleShape2 != null ? divRoundedRectangleShape2.hash() : 0);
        DivRoundedRectangleShape divRoundedRectangleShape3 = this.inactiveShape;
        int iHash17 = iHash16 + (divRoundedRectangleShape3 != null ? divRoundedRectangleShape3.hash() : 0);
        DivIndicatorItemPlacement divIndicatorItemPlacement = this.itemsPlacement;
        int iHash18 = iHash17 + (divIndicatorItemPlacement != null ? divIndicatorItemPlacement.hash() : 0);
        DivLayoutProvider layoutProvider = getLayoutProvider();
        int iHash19 = iHash18 + (layoutProvider != null ? layoutProvider.hash() : 0);
        DivEdgeInsets margins = getMargins();
        int iHash20 = iHash19 + (margins != null ? margins.hash() : 0) + this.minimumItemSize.hashCode();
        DivEdgeInsets paddings = getPaddings();
        int iHash21 = iHash20 + (paddings != null ? paddings.hash() : 0);
        String str = this.pagerId;
        int iHashCode6 = iHash21 + (str != null ? str.hashCode() : 0);
        Expression<String> reuseId = getReuseId();
        int iHashCode7 = iHashCode6 + (reuseId != null ? reuseId.hashCode() : 0);
        Expression<Long> rowSpan = getRowSpan();
        int iHashCode8 = iHashCode7 + (rowSpan != null ? rowSpan.hashCode() : 0);
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
        int iHash22 = iHashCode8 + iHash6 + this.shape.hash() + this.spaceBetweenCenters.hash();
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
        int i5 = iHash22 + iHash7;
        DivTransform transform = getTransform();
        int iHash23 = i5 + (transform != null ? transform.hash() : 0);
        DivChangeTransition transitionChange = getTransitionChange();
        int iHash24 = iHash23 + (transitionChange != null ? transitionChange.hash() : 0);
        DivAppearanceTransition transitionIn = getTransitionIn();
        int iHash25 = iHash24 + (transitionIn != null ? transitionIn.hash() : 0);
        DivAppearanceTransition transitionOut = getTransitionOut();
        int iHash26 = iHash25 + (transitionOut != null ? transitionOut.hash() : 0);
        List<DivTransitionTrigger> transitionTriggers = getTransitionTriggers();
        int iHashCode9 = iHash26 + (transitionTriggers != null ? transitionTriggers.hashCode() : 0);
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
        int i6 = iHashCode9 + iHash8;
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
        int iHashCode10 = i6 + iHash9 + getVisibility().hashCode();
        DivVisibilityAction visibilityAction = getVisibilityAction();
        int iHash27 = iHashCode10 + (visibilityAction != null ? visibilityAction.hash() : 0);
        List<DivVisibilityAction> visibilityActions = getVisibilityActions();
        if (visibilityActions != null) {
            Iterator<T> it10 = visibilityActions.iterator();
            while (it10.hasNext()) {
                iHash10 += ((DivVisibilityAction) it10.next()).hash();
            }
        }
        int iHash28 = iHash27 + iHash10 + getWidth().hash();
        this._hash = Integer.valueOf(iHash28);
        return iHash28;
    }

    public final boolean equals(DivIndicator other, ExpressionResolver resolver, ExpressionResolver otherResolver) {
        boolean zEquals;
        boolean zEquals2;
        boolean z;
        boolean z2;
        boolean zEquals3;
        boolean z3;
        boolean z4;
        boolean zEquals4;
        boolean z5;
        boolean zEquals5;
        boolean zEquals6;
        boolean zEquals7;
        boolean zEquals8;
        boolean zEquals9;
        boolean zEquals10;
        boolean z6;
        boolean z7;
        boolean zEquals11;
        boolean zEquals12;
        boolean zEquals13;
        boolean zEquals14;
        boolean z8;
        boolean z9;
        boolean z10;
        boolean zEquals15;
        boolean z11;
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
        if (!zEquals || this.activeItemColor.evaluate(resolver).intValue() != other.activeItemColor.evaluate(otherResolver).intValue()) {
            return false;
        }
        if (!(this.activeItemSize.evaluate(resolver).doubleValue() == other.activeItemSize.evaluate(otherResolver).doubleValue())) {
            return false;
        }
        DivRoundedRectangleShape divRoundedRectangleShape = this.activeShape;
        if (divRoundedRectangleShape != null) {
            zEquals2 = divRoundedRectangleShape.equals(other.activeShape, resolver, otherResolver);
        } else {
            zEquals2 = other.activeShape == null;
        }
        if (!zEquals2) {
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
        if (!(getAlpha().evaluate(resolver).doubleValue() == other.getAlpha().evaluate(otherResolver).doubleValue()) || this.animation.evaluate(resolver) != other.animation.evaluate(otherResolver)) {
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
            zEquals3 = border.equals(other.getBorder(), resolver, otherResolver);
        } else {
            zEquals3 = other.getBorder() == null;
        }
        if (!zEquals3) {
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
        if (!z5 || !getHeight().equals(other.getHeight(), resolver, otherResolver) || !Intrinsics.areEqual(getId(), other.getId()) || this.inactiveItemColor.evaluate(resolver).intValue() != other.inactiveItemColor.evaluate(otherResolver).intValue()) {
            return false;
        }
        DivRoundedRectangleShape divRoundedRectangleShape2 = this.inactiveMinimumShape;
        if (divRoundedRectangleShape2 != null) {
            zEquals5 = divRoundedRectangleShape2.equals(other.inactiveMinimumShape, resolver, otherResolver);
        } else {
            zEquals5 = other.inactiveMinimumShape == null;
        }
        if (!zEquals5) {
            return false;
        }
        DivRoundedRectangleShape divRoundedRectangleShape3 = this.inactiveShape;
        if (divRoundedRectangleShape3 != null) {
            zEquals6 = divRoundedRectangleShape3.equals(other.inactiveShape, resolver, otherResolver);
        } else {
            zEquals6 = other.inactiveShape == null;
        }
        if (!zEquals6) {
            return false;
        }
        DivIndicatorItemPlacement divIndicatorItemPlacement = this.itemsPlacement;
        if (divIndicatorItemPlacement != null) {
            zEquals7 = divIndicatorItemPlacement.equals(other.itemsPlacement, resolver, otherResolver);
        } else {
            zEquals7 = other.itemsPlacement == null;
        }
        if (!zEquals7) {
            return false;
        }
        DivLayoutProvider layoutProvider = getLayoutProvider();
        if (layoutProvider != null) {
            zEquals8 = layoutProvider.equals(other.getLayoutProvider(), resolver, otherResolver);
        } else {
            zEquals8 = other.getLayoutProvider() == null;
        }
        if (!zEquals8) {
            return false;
        }
        DivEdgeInsets margins = getMargins();
        if (margins != null) {
            zEquals9 = margins.equals(other.getMargins(), resolver, otherResolver);
        } else {
            zEquals9 = other.getMargins() == null;
        }
        if (!zEquals9) {
            return false;
        }
        if (!(this.minimumItemSize.evaluate(resolver).doubleValue() == other.minimumItemSize.evaluate(otherResolver).doubleValue())) {
            return false;
        }
        DivEdgeInsets paddings = getPaddings();
        if (paddings != null) {
            zEquals10 = paddings.equals(other.getPaddings(), resolver, otherResolver);
        } else {
            zEquals10 = other.getPaddings() == null;
        }
        if (!zEquals10 || !Intrinsics.areEqual(this.pagerId, other.pagerId)) {
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
        if (!z6 || !this.shape.equals(other.shape, resolver, otherResolver) || !this.spaceBetweenCenters.equals(other.spaceBetweenCenters, resolver, otherResolver)) {
            return false;
        }
        List<DivTooltip> tooltips = getTooltips();
        if (tooltips != null) {
            List<DivTooltip> tooltips2 = other.getTooltips();
            if (tooltips2 == null) {
                return false;
            }
            if (tooltips.size() == tooltips2.size()) {
                Iterator<T> it7 = tooltips.iterator();
                int i13 = 0;
                while (true) {
                    if (it7.hasNext()) {
                        Object next7 = it7.next();
                        int i14 = i13 + 1;
                        if (i13 < 0) {
                            CollectionsKt.throwIndexOverflow();
                        }
                        if (((DivTooltip) next7).equals(tooltips2.get(i13), resolver, otherResolver)) {
                            i13 = i14;
                        }
                    }
                }
            }
        } else {
            z7 = other.getTooltips() == null;
        }
        if (!z7) {
            return false;
        }
        DivTransform transform = getTransform();
        if (transform != null) {
            zEquals11 = transform.equals(other.getTransform(), resolver, otherResolver);
        } else {
            zEquals11 = other.getTransform() == null;
        }
        if (!zEquals11) {
            return false;
        }
        DivChangeTransition transitionChange = getTransitionChange();
        if (transitionChange != null) {
            zEquals12 = transitionChange.equals(other.getTransitionChange(), resolver, otherResolver);
        } else {
            zEquals12 = other.getTransitionChange() == null;
        }
        if (!zEquals12) {
            return false;
        }
        DivAppearanceTransition transitionIn = getTransitionIn();
        if (transitionIn != null) {
            zEquals13 = transitionIn.equals(other.getTransitionIn(), resolver, otherResolver);
        } else {
            zEquals13 = other.getTransitionIn() == null;
        }
        if (!zEquals13) {
            return false;
        }
        DivAppearanceTransition transitionOut = getTransitionOut();
        if (transitionOut != null) {
            zEquals14 = transitionOut.equals(other.getTransitionOut(), resolver, otherResolver);
        } else {
            zEquals14 = other.getTransitionOut() == null;
        }
        if (!zEquals14) {
            return false;
        }
        List<DivTransitionTrigger> transitionTriggers = getTransitionTriggers();
        if (transitionTriggers != null) {
            List<DivTransitionTrigger> transitionTriggers2 = other.getTransitionTriggers();
            if (transitionTriggers2 == null) {
                return false;
            }
            if (transitionTriggers.size() == transitionTriggers2.size()) {
                Iterator<T> it8 = transitionTriggers.iterator();
                int i15 = 0;
                while (true) {
                    if (it8.hasNext()) {
                        Object next8 = it8.next();
                        int i16 = i15 + 1;
                        if (i15 < 0) {
                            CollectionsKt.throwIndexOverflow();
                        }
                        if (((DivTransitionTrigger) next8) == transitionTriggers2.get(i15)) {
                            i15 = i16;
                        }
                    }
                }
            }
        } else {
            z8 = other.getTransitionTriggers() == null;
        }
        if (!z8) {
            return false;
        }
        List<DivTrigger> variableTriggers = getVariableTriggers();
        if (variableTriggers != null) {
            List<DivTrigger> variableTriggers2 = other.getVariableTriggers();
            if (variableTriggers2 == null) {
                return false;
            }
            if (variableTriggers.size() == variableTriggers2.size()) {
                Iterator<T> it9 = variableTriggers.iterator();
                int i17 = 0;
                while (true) {
                    if (it9.hasNext()) {
                        Object next9 = it9.next();
                        int i18 = i17 + 1;
                        if (i17 < 0) {
                            CollectionsKt.throwIndexOverflow();
                        }
                        if (((DivTrigger) next9).equals(variableTriggers2.get(i17), resolver, otherResolver)) {
                            i17 = i18;
                        }
                    }
                }
            }
        } else {
            z9 = other.getVariableTriggers() == null;
        }
        if (!z9) {
            return false;
        }
        List<DivVariable> variables = getVariables();
        if (variables != null) {
            List<DivVariable> variables2 = other.getVariables();
            if (variables2 == null) {
                return false;
            }
            if (variables.size() == variables2.size()) {
                Iterator<T> it10 = variables.iterator();
                int i19 = 0;
                while (true) {
                    if (it10.hasNext()) {
                        Object next10 = it10.next();
                        int i20 = i19 + 1;
                        if (i19 < 0) {
                            CollectionsKt.throwIndexOverflow();
                        }
                        if (((DivVariable) next10).equals(variables2.get(i19), resolver, otherResolver)) {
                            i19 = i20;
                        }
                    }
                }
            }
        } else {
            z10 = other.getVariables() == null;
        }
        if (!z10 || getVisibility().evaluate(resolver) != other.getVisibility().evaluate(otherResolver)) {
            return false;
        }
        DivVisibilityAction visibilityAction = getVisibilityAction();
        if (visibilityAction != null) {
            zEquals15 = visibilityAction.equals(other.getVisibilityAction(), resolver, otherResolver);
        } else {
            zEquals15 = other.getVisibilityAction() == null;
        }
        if (!zEquals15) {
            return false;
        }
        List<DivVisibilityAction> visibilityActions = getVisibilityActions();
        if (visibilityActions != null) {
            List<DivVisibilityAction> visibilityActions2 = other.getVisibilityActions();
            if (visibilityActions2 == null) {
                return false;
            }
            if (visibilityActions.size() == visibilityActions2.size()) {
                Iterator<T> it11 = visibilityActions.iterator();
                int i21 = 0;
                while (true) {
                    if (it11.hasNext()) {
                        Object next11 = it11.next();
                        int i22 = i21 + 1;
                        if (i21 < 0) {
                            CollectionsKt.throwIndexOverflow();
                        }
                        if (((DivVisibilityAction) next11).equals(visibilityActions2.get(i21), resolver, otherResolver)) {
                            i21 = i22;
                        }
                    }
                }
            }
        } else {
            z11 = other.getVisibilityActions() == null;
        }
        return z11 && getWidth().equals(other.getWidth(), resolver, otherResolver);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ DivIndicator copy$default(DivIndicator divIndicator, DivAccessibility divAccessibility, Expression expression, Expression expression2, DivRoundedRectangleShape divRoundedRectangleShape, Expression expression3, Expression expression4, Expression expression5, Expression expression6, List list, List list2, DivBorder divBorder, Expression expression7, List list3, List list4, DivFocus divFocus, List list5, DivSize divSize, String str, Expression expression8, DivRoundedRectangleShape divRoundedRectangleShape2, DivRoundedRectangleShape divRoundedRectangleShape3, DivIndicatorItemPlacement divIndicatorItemPlacement, DivLayoutProvider divLayoutProvider, DivEdgeInsets divEdgeInsets, Expression expression9, DivEdgeInsets divEdgeInsets2, String str2, Expression expression10, Expression expression11, List list6, DivShape divShape, DivFixedSize divFixedSize, List list7, DivTransform divTransform, DivChangeTransition divChangeTransition, DivAppearanceTransition divAppearanceTransition, DivAppearanceTransition divAppearanceTransition2, List list8, List list9, List list10, Expression expression12, DivVisibilityAction divVisibilityAction, List list11, DivSize divSize2, int i, int i2, Object obj) {
        DivAccessibility accessibility = (i & 1) != 0 ? divIndicator.getAccessibility() : divAccessibility;
        Expression expression13 = (i & 2) != 0 ? divIndicator.activeItemColor : expression;
        Expression expression14 = (i & 4) != 0 ? divIndicator.activeItemSize : expression2;
        DivRoundedRectangleShape divRoundedRectangleShape4 = (i & 8) != 0 ? divIndicator.activeShape : divRoundedRectangleShape;
        Expression alignmentHorizontal = (i & 16) != 0 ? divIndicator.getAlignmentHorizontal() : expression3;
        Expression alignmentVertical = (i & 32) != 0 ? divIndicator.getAlignmentVertical() : expression4;
        Expression alpha = (i & 64) != 0 ? divIndicator.getAlpha() : expression5;
        Expression expression15 = (i & 128) != 0 ? divIndicator.animation : expression6;
        List animators = (i & 256) != 0 ? divIndicator.getAnimators() : list;
        List background = (i & 512) != 0 ? divIndicator.getBackground() : list2;
        DivBorder border = (i & 1024) != 0 ? divIndicator.getBorder() : divBorder;
        Expression columnSpan = (i & 2048) != 0 ? divIndicator.getColumnSpan() : expression7;
        List disappearActions = (i & 4096) != 0 ? divIndicator.getDisappearActions() : list3;
        List extensions = (i & 8192) != 0 ? divIndicator.getExtensions() : list4;
        DivFocus focus = (i & 16384) != 0 ? divIndicator.getFocus() : divFocus;
        List functions = (i & 32768) != 0 ? divIndicator.getFunctions() : list5;
        DivSize height = (i & 65536) != 0 ? divIndicator.getHeight() : divSize;
        String id = (i & 131072) != 0 ? divIndicator.getId() : str;
        DivFocus divFocus2 = focus;
        Expression expression16 = (i & 262144) != 0 ? divIndicator.inactiveItemColor : expression8;
        DivRoundedRectangleShape divRoundedRectangleShape5 = (i & 524288) != 0 ? divIndicator.inactiveMinimumShape : divRoundedRectangleShape2;
        DivRoundedRectangleShape divRoundedRectangleShape6 = (i & 1048576) != 0 ? divIndicator.inactiveShape : divRoundedRectangleShape3;
        DivIndicatorItemPlacement divIndicatorItemPlacement2 = (i & 2097152) != 0 ? divIndicator.itemsPlacement : divIndicatorItemPlacement;
        DivLayoutProvider layoutProvider = (i & 4194304) != 0 ? divIndicator.getLayoutProvider() : divLayoutProvider;
        DivEdgeInsets margins = (i & 8388608) != 0 ? divIndicator.getMargins() : divEdgeInsets;
        DivIndicatorItemPlacement divIndicatorItemPlacement3 = divIndicatorItemPlacement2;
        Expression expression17 = (i & 16777216) != 0 ? divIndicator.minimumItemSize : expression9;
        return divIndicator.copy(accessibility, expression13, expression14, divRoundedRectangleShape4, alignmentHorizontal, alignmentVertical, alpha, expression15, animators, background, border, columnSpan, disappearActions, extensions, divFocus2, functions, height, id, expression16, divRoundedRectangleShape5, divRoundedRectangleShape6, divIndicatorItemPlacement3, layoutProvider, margins, expression17, (i & 33554432) != 0 ? divIndicator.getPaddings() : divEdgeInsets2, (i & 67108864) != 0 ? divIndicator.pagerId : str2, (i & 134217728) != 0 ? divIndicator.getReuseId() : expression10, (i & 268435456) != 0 ? divIndicator.getRowSpan() : expression11, (i & 536870912) != 0 ? divIndicator.getSelectedActions() : list6, (i & 1073741824) != 0 ? divIndicator.shape : divShape, (i & Integer.MIN_VALUE) != 0 ? divIndicator.spaceBetweenCenters : divFixedSize, (i2 & 1) != 0 ? divIndicator.getTooltips() : list7, (i2 & 2) != 0 ? divIndicator.getTransform() : divTransform, (i2 & 4) != 0 ? divIndicator.getTransitionChange() : divChangeTransition, (i2 & 8) != 0 ? divIndicator.getTransitionIn() : divAppearanceTransition, (i2 & 16) != 0 ? divIndicator.getTransitionOut() : divAppearanceTransition2, (i2 & 32) != 0 ? divIndicator.getTransitionTriggers() : list8, (i2 & 64) != 0 ? divIndicator.getVariableTriggers() : list9, (i2 & 128) != 0 ? divIndicator.getVariables() : list10, (i2 & 256) != 0 ? divIndicator.getVisibility() : expression12, (i2 & 512) != 0 ? divIndicator.getVisibilityAction() : divVisibilityAction, (i2 & 1024) != 0 ? divIndicator.getVisibilityActions() : list11, (i2 & 2048) != 0 ? divIndicator.getWidth() : divSize2);
    }

    public final DivIndicator copy(DivAccessibility accessibility, Expression<Integer> activeItemColor, Expression<Double> activeItemSize, DivRoundedRectangleShape activeShape, Expression<DivAlignmentHorizontal> alignmentHorizontal, Expression<DivAlignmentVertical> alignmentVertical, Expression<Double> alpha, Expression<Animation> animation, List<? extends DivAnimator> animators, List<? extends DivBackground> background, DivBorder border, Expression<Long> columnSpan, List<DivDisappearAction> disappearActions, List<DivExtension> extensions, DivFocus focus, List<DivFunction> functions, DivSize height, String id, Expression<Integer> inactiveItemColor, DivRoundedRectangleShape inactiveMinimumShape, DivRoundedRectangleShape inactiveShape, DivIndicatorItemPlacement itemsPlacement, DivLayoutProvider layoutProvider, DivEdgeInsets margins, Expression<Double> minimumItemSize, DivEdgeInsets paddings, String pagerId, Expression<String> reuseId, Expression<Long> rowSpan, List<DivAction> selectedActions, DivShape shape, DivFixedSize spaceBetweenCenters, List<DivTooltip> tooltips, DivTransform transform, DivChangeTransition transitionChange, DivAppearanceTransition transitionIn, DivAppearanceTransition transitionOut, List<? extends DivTransitionTrigger> transitionTriggers, List<DivTrigger> variableTriggers, List<? extends DivVariable> variables, Expression<DivVisibility> visibility, DivVisibilityAction visibilityAction, List<DivVisibilityAction> visibilityActions, DivSize width) {
        Intrinsics.checkNotNullParameter(activeItemColor, "activeItemColor");
        Intrinsics.checkNotNullParameter(activeItemSize, "activeItemSize");
        Intrinsics.checkNotNullParameter(alpha, "alpha");
        Intrinsics.checkNotNullParameter(animation, "animation");
        Intrinsics.checkNotNullParameter(height, "height");
        Intrinsics.checkNotNullParameter(inactiveItemColor, "inactiveItemColor");
        Intrinsics.checkNotNullParameter(minimumItemSize, "minimumItemSize");
        Intrinsics.checkNotNullParameter(shape, "shape");
        Intrinsics.checkNotNullParameter(spaceBetweenCenters, "spaceBetweenCenters");
        Intrinsics.checkNotNullParameter(visibility, "visibility");
        Intrinsics.checkNotNullParameter(width, "width");
        return new DivIndicator(accessibility, activeItemColor, activeItemSize, activeShape, alignmentHorizontal, alignmentVertical, alpha, animation, animators, background, border, columnSpan, disappearActions, extensions, focus, functions, height, id, inactiveItemColor, inactiveMinimumShape, inactiveShape, itemsPlacement, layoutProvider, margins, minimumItemSize, paddings, pagerId, reuseId, rowSpan, selectedActions, shape, spaceBetweenCenters, tooltips, transform, transitionChange, transitionIn, transitionOut, transitionTriggers, variableTriggers, variables, visibility, visibilityAction, visibilityActions, width);
    }

    @Override // com.yandex.div.json.JSONSerializable
    public JSONObject writeToJSON() {
        return BuiltInParserKt.getBuiltInParserComponent().getDivIndicatorJsonEntityParser().getValue().serialize(BuiltInParserKt.getBuiltInParsingContext(), this);
    }

    /* JADX INFO: compiled from: DivIndicator.kt */
    @Metadata(d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0006\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u001e\u0010 \u001a\u00020\u000f2\u0006\u0010!\u001a\u00020\r2\u0006\u0010\"\u001a\u00020\u000eH\u0087\u0002¢\u0006\u0002\b#R\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00070\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\t\u001a\b\u0012\u0004\u0012\u00020\n0\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R#\u0010\u000b\u001a\u0014\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u000f0\f¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u000e\u0010\u0012\u001a\u00020\u0013X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00070\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0017X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0019X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u001bX\u0086T¢\u0006\u0002\n\u0000R\u0014\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u001d0\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\u001fX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006$"}, d2 = {"Lcom/yandex/div2/DivIndicator$Companion;", "", "()V", "ACTIVE_ITEM_COLOR_DEFAULT_VALUE", "Lcom/yandex/div/json/expressions/Expression;", "", "ACTIVE_ITEM_SIZE_DEFAULT_VALUE", "", "ALPHA_DEFAULT_VALUE", "ANIMATION_DEFAULT_VALUE", "Lcom/yandex/div2/DivIndicator$Animation;", "CREATOR", "Lkotlin/Function2;", "Lcom/yandex/div/json/ParsingEnvironment;", "Lorg/json/JSONObject;", "Lcom/yandex/div2/DivIndicator;", "getCREATOR", "()Lkotlin/jvm/functions/Function2;", "HEIGHT_DEFAULT_VALUE", "Lcom/yandex/div2/DivSize$WrapContent;", "INACTIVE_ITEM_COLOR_DEFAULT_VALUE", "MINIMUM_ITEM_SIZE_DEFAULT_VALUE", "SHAPE_DEFAULT_VALUE", "Lcom/yandex/div2/DivShape$RoundedRectangle;", "SPACE_BETWEEN_CENTERS_DEFAULT_VALUE", "Lcom/yandex/div2/DivFixedSize;", "TYPE", "", "VISIBILITY_DEFAULT_VALUE", "Lcom/yandex/div2/DivVisibility;", "WIDTH_DEFAULT_VALUE", "Lcom/yandex/div2/DivSize$MatchParent;", "invoke", cc.o, "json", "fromJson", "div-data_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @JvmStatic
        public final DivIndicator fromJson(ParsingEnvironment env, JSONObject json) {
            Intrinsics.checkNotNullParameter(env, "env");
            Intrinsics.checkNotNullParameter(json, "json");
            return BuiltInParserKt.getBuiltInParserComponent().getDivIndicatorJsonEntityParser().getValue().deserialize((ParsingContext) env, json);
        }

        public final Function2<ParsingEnvironment, JSONObject, DivIndicator> getCREATOR() {
            return DivIndicator.CREATOR;
        }
    }

    static {
        byte b = 0 == true ? 1 : 0;
        SHAPE_DEFAULT_VALUE = new DivShape.RoundedRectangle(new DivRoundedRectangleShape(null, 0 == true ? 1 : 0, 0 == true ? 1 : 0, null, b, 31, null));
        int i = 1;
        SPACE_BETWEEN_CENTERS_DEFAULT_VALUE = new DivFixedSize(0 == true ? 1 : 0, Expression.INSTANCE.constant(15L), i, 0 == true ? 1 : 0);
        VISIBILITY_DEFAULT_VALUE = Expression.INSTANCE.constant(DivVisibility.VISIBLE);
        WIDTH_DEFAULT_VALUE = new DivSize.MatchParent(new DivMatchParentSize(0 == true ? 1 : 0, i, 0 == true ? 1 : 0));
        CREATOR = new Function2<ParsingEnvironment, JSONObject, DivIndicator>() { // from class: com.yandex.div2.DivIndicator$Companion$CREATOR$1
            @Override // kotlin.jvm.functions.Function2
            public final DivIndicator invoke(ParsingEnvironment env, JSONObject it) {
                Intrinsics.checkNotNullParameter(env, "env");
                Intrinsics.checkNotNullParameter(it, "it");
                return DivIndicator.INSTANCE.fromJson(env, it);
            }
        };
    }

    /* JADX INFO: compiled from: DivIndicator.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\b\u0086\u0001\u0018\u0000 \b2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\bB\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007¨\u0006\t"}, d2 = {"Lcom/yandex/div2/DivIndicator$Animation;", "", "value", "", "(Ljava/lang/String;ILjava/lang/String;)V", "SCALE", "WORM", "SLIDER", "Converter", "div-data_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public enum Animation {
        SCALE("scale"),
        WORM("worm"),
        SLIDER("slider");

        private final String value;

        /* JADX INFO: renamed from: Converter, reason: from kotlin metadata */
        public static final Companion INSTANCE = new Companion(null);
        public static final Function1<Animation, String> TO_STRING = new Function1<Animation, String>() { // from class: com.yandex.div2.DivIndicator$Animation$Converter$TO_STRING$1
            @Override // kotlin.jvm.functions.Function1
            public final String invoke(DivIndicator.Animation value) {
                Intrinsics.checkNotNullParameter(value, "value");
                return DivIndicator.Animation.INSTANCE.toString(value);
            }
        };
        public static final Function1<String, Animation> FROM_STRING = new Function1<String, Animation>() { // from class: com.yandex.div2.DivIndicator$Animation$Converter$FROM_STRING$1
            @Override // kotlin.jvm.functions.Function1
            public final DivIndicator.Animation invoke(String value) {
                Intrinsics.checkNotNullParameter(value, "value");
                return DivIndicator.Animation.INSTANCE.fromString(value);
            }
        };

        Animation(String str) {
            this.value = str;
        }

        /* JADX INFO: renamed from: com.yandex.div2.DivIndicator$Animation$Converter, reason: from kotlin metadata */
        /* JADX INFO: compiled from: DivIndicator.kt */
        @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\b\u001a\u0004\u0018\u00010\u00062\u0006\u0010\t\u001a\u00020\u0005J\u000e\u0010\n\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\u0006R\u001e\u0010\u0003\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u00048\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00050\u00048\u0006X\u0087\u0004¢\u0006\u0002\n\u0000¨\u0006\f"}, d2 = {"Lcom/yandex/div2/DivIndicator$Animation$Converter;", "", "()V", "FROM_STRING", "Lkotlin/Function1;", "", "Lcom/yandex/div2/DivIndicator$Animation;", "TO_STRING", "fromString", "value", "toString", "obj", "div-data_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private Companion() {
            }

            public final String toString(Animation obj) {
                Intrinsics.checkNotNullParameter(obj, "obj");
                return obj.value;
            }

            public final Animation fromString(String value) {
                Intrinsics.checkNotNullParameter(value, "value");
                if (Intrinsics.areEqual(value, Animation.SCALE.value)) {
                    return Animation.SCALE;
                }
                if (Intrinsics.areEqual(value, Animation.WORM.value)) {
                    return Animation.WORM;
                }
                if (Intrinsics.areEqual(value, Animation.SLIDER.value)) {
                    return Animation.SLIDER;
                }
                return null;
            }
        }
    }
}
