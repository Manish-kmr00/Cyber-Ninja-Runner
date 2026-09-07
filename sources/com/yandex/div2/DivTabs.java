package com.yandex.div2;

import android.net.Uri;
import androidx.compose.material.OutlinedTextFieldKt;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.json.cc;
import com.yandex.div.core.view2.divs.widgets.DivSeparatorView;
import com.yandex.div.data.Hashable;
import com.yandex.div.json.JSONSerializable;
import com.yandex.div.json.ParsingEnvironment;
import com.yandex.div.json.expressions.Expression;
import com.yandex.div.json.expressions.ExpressionResolver;
import com.yandex.div.serialization.BuiltInParserKt;
import com.yandex.div.serialization.ParsingContext;
import io.appmetrica.analytics.impl.J2;
import io.bidmachine.unified.UnifiedMediationParams;
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

/* JADX INFO: compiled from: DivTabs.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000ò\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0006\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b7\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 \u008b\u00012\u00020\u00012\u00020\u00022\u00020\u0003:\b\u008b\u0001\u008c\u0001\u008d\u0001\u008e\u0001B\u0085\u0005\b\u0007\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\u0010\b\u0002\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007\u0012\u0010\b\u0002\u0010\t\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\u0007\u0012\u000e\b\u0002\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\f0\u0007\u0012\u0010\b\u0002\u0010\r\u001a\n\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u000e\u0012\u0010\b\u0002\u0010\u0010\u001a\n\u0012\u0004\u0012\u00020\u0011\u0018\u00010\u000e\u0012\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u0013\u0012\u0010\b\u0002\u0010\u0014\u001a\n\u0012\u0004\u0012\u00020\u0015\u0018\u00010\u0007\u0012\u0010\b\u0002\u0010\u0016\u001a\n\u0012\u0004\u0012\u00020\u0017\u0018\u00010\u000e\u0012\u000e\b\u0002\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00190\u0007\u0012\u0010\b\u0002\u0010\u001a\u001a\n\u0012\u0004\u0012\u00020\u001b\u0018\u00010\u000e\u0012\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\u001d\u0012\u0010\b\u0002\u0010\u001e\u001a\n\u0012\u0004\u0012\u00020\u001f\u0018\u00010\u000e\u0012\u000e\b\u0002\u0010 \u001a\b\u0012\u0004\u0012\u00020\u00190\u0007\u0012\b\b\u0002\u0010!\u001a\u00020\"\u0012\n\b\u0002\u0010#\u001a\u0004\u0018\u00010$\u0012\f\u0010%\u001a\b\u0012\u0004\u0012\u00020&0\u000e\u0012\n\b\u0002\u0010'\u001a\u0004\u0018\u00010(\u0012\n\b\u0002\u0010)\u001a\u0004\u0018\u00010*\u0012\n\b\u0002\u0010+\u001a\u0004\u0018\u00010*\u0012\u000e\b\u0002\u0010,\u001a\b\u0012\u0004\u0012\u00020\u00190\u0007\u0012\u0010\b\u0002\u0010-\u001a\n\u0012\u0004\u0012\u00020$\u0018\u00010\u0007\u0012\u0010\b\u0002\u0010.\u001a\n\u0012\u0004\u0012\u00020\u0015\u0018\u00010\u0007\u0012\u0010\b\u0002\u0010/\u001a\n\u0012\u0004\u0012\u000200\u0018\u00010\u000e\u0012\u000e\b\u0002\u00101\u001a\b\u0012\u0004\u0012\u00020\u00150\u0007\u0012\u000e\b\u0002\u00102\u001a\b\u0012\u0004\u0012\u0002030\u0007\u0012\b\b\u0002\u00104\u001a\u00020*\u0012\u000e\b\u0002\u00105\u001a\b\u0012\u0004\u0012\u00020\u00190\u0007\u0012\n\b\u0002\u00106\u001a\u0004\u0018\u000107\u0012\n\b\u0002\u00108\u001a\u0004\u0018\u000109\u0012\b\b\u0002\u0010:\u001a\u00020*\u0012\u0010\b\u0002\u0010;\u001a\n\u0012\u0004\u0012\u00020<\u0018\u00010\u000e\u0012\n\b\u0002\u0010=\u001a\u0004\u0018\u00010>\u0012\n\b\u0002\u0010?\u001a\u0004\u0018\u00010@\u0012\n\b\u0002\u0010A\u001a\u0004\u0018\u00010B\u0012\n\b\u0002\u0010C\u001a\u0004\u0018\u00010B\u0012\u0010\b\u0002\u0010D\u001a\n\u0012\u0004\u0012\u00020E\u0018\u00010\u000e\u0012\u0010\b\u0002\u0010F\u001a\n\u0012\u0004\u0012\u00020G\u0018\u00010\u000e\u0012\u0010\b\u0002\u0010H\u001a\n\u0012\u0004\u0012\u00020I\u0018\u00010\u000e\u0012\u000e\b\u0002\u0010J\u001a\b\u0012\u0004\u0012\u00020K0\u0007\u0012\n\b\u0002\u0010L\u001a\u0004\u0018\u00010M\u0012\u0010\b\u0002\u0010N\u001a\n\u0012\u0004\u0012\u00020M\u0018\u00010\u000e\u0012\b\b\u0002\u0010O\u001a\u00020\"¢\u0006\u0002\u0010PJ\u0087\u0005\u0010\u0081\u0001\u001a\u00020\u00002\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0010\b\u0002\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u00072\u0010\b\u0002\u0010\t\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\u00072\u000e\b\u0002\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\f0\u00072\u0010\b\u0002\u0010\r\u001a\n\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u000e2\u0010\b\u0002\u0010\u0010\u001a\n\u0012\u0004\u0012\u00020\u0011\u0018\u00010\u000e2\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u00132\u0010\b\u0002\u0010\u0014\u001a\n\u0012\u0004\u0012\u00020\u0015\u0018\u00010\u00072\u0010\b\u0002\u0010\u0016\u001a\n\u0012\u0004\u0012\u00020\u0017\u0018\u00010\u000e2\u000e\b\u0002\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00190\u00072\u0010\b\u0002\u0010\u001a\u001a\n\u0012\u0004\u0012\u00020\u001b\u0018\u00010\u000e2\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\u001d2\u0010\b\u0002\u0010\u001e\u001a\n\u0012\u0004\u0012\u00020\u001f\u0018\u00010\u000e2\u000e\b\u0002\u0010 \u001a\b\u0012\u0004\u0012\u00020\u00190\u00072\b\b\u0002\u0010!\u001a\u00020\"2\n\b\u0002\u0010#\u001a\u0004\u0018\u00010$2\u000e\b\u0002\u0010%\u001a\b\u0012\u0004\u0012\u00020&0\u000e2\n\b\u0002\u0010'\u001a\u0004\u0018\u00010(2\n\b\u0002\u0010)\u001a\u0004\u0018\u00010*2\n\b\u0002\u0010+\u001a\u0004\u0018\u00010*2\u000e\b\u0002\u0010,\u001a\b\u0012\u0004\u0012\u00020\u00190\u00072\u0010\b\u0002\u0010-\u001a\n\u0012\u0004\u0012\u00020$\u0018\u00010\u00072\u0010\b\u0002\u0010.\u001a\n\u0012\u0004\u0012\u00020\u0015\u0018\u00010\u00072\u0010\b\u0002\u0010/\u001a\n\u0012\u0004\u0012\u000200\u0018\u00010\u000e2\u000e\b\u0002\u00101\u001a\b\u0012\u0004\u0012\u00020\u00150\u00072\u000e\b\u0002\u00102\u001a\b\u0012\u0004\u0012\u0002030\u00072\b\b\u0002\u00104\u001a\u00020*2\u000e\b\u0002\u00105\u001a\b\u0012\u0004\u0012\u00020\u00190\u00072\n\b\u0002\u00106\u001a\u0004\u0018\u0001072\n\b\u0002\u00108\u001a\u0004\u0018\u0001092\b\b\u0002\u0010:\u001a\u00020*2\u0010\b\u0002\u0010;\u001a\n\u0012\u0004\u0012\u00020<\u0018\u00010\u000e2\n\b\u0002\u0010=\u001a\u0004\u0018\u00010>2\n\b\u0002\u0010?\u001a\u0004\u0018\u00010@2\n\b\u0002\u0010A\u001a\u0004\u0018\u00010B2\n\b\u0002\u0010C\u001a\u0004\u0018\u00010B2\u0010\b\u0002\u0010D\u001a\n\u0012\u0004\u0012\u00020E\u0018\u00010\u000e2\u0010\b\u0002\u0010F\u001a\n\u0012\u0004\u0012\u00020G\u0018\u00010\u000e2\u0010\b\u0002\u0010H\u001a\n\u0012\u0004\u0012\u00020I\u0018\u00010\u000e2\u000e\b\u0002\u0010J\u001a\b\u0012\u0004\u0012\u00020K0\u00072\n\b\u0002\u0010L\u001a\u0004\u0018\u00010M2\u0010\b\u0002\u0010N\u001a\n\u0012\u0004\u0012\u00020M\u0018\u00010\u000e2\b\b\u0002\u0010O\u001a\u00020\"J&\u0010\u0082\u0001\u001a\u00020\u00192\t\u0010\u0083\u0001\u001a\u0004\u0018\u00010\u00002\b\u0010\u0084\u0001\u001a\u00030\u0085\u00012\b\u0010\u0086\u0001\u001a\u00030\u0085\u0001J\t\u0010\u0087\u0001\u001a\u000203H\u0016J\t\u0010\u0088\u0001\u001a\u000203H\u0016J\n\u0010\u0089\u0001\u001a\u00030\u008a\u0001H\u0016R\u0012\u0010Q\u001a\u0004\u0018\u000103X\u0082\u000e¢\u0006\u0004\n\u0002\u0010RR\u0012\u0010S\u001a\u0004\u0018\u000103X\u0082\u000e¢\u0006\u0004\n\u0002\u0010RR\u0016\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\bT\u0010UR\u001c\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\bV\u0010WR\u001c\u0010\t\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\u0007X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\bX\u0010WR\u001a\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\f0\u0007X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\bY\u0010WR\u001c\u0010\r\u001a\n\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u000eX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\bZ\u0010[R\u001c\u0010\u0010\u001a\n\u0012\u0004\u0012\u00020\u0011\u0018\u00010\u000eX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\\\u0010[R\u0016\u0010\u0012\u001a\u0004\u0018\u00010\u0013X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b]\u0010^R\u001c\u0010\u0014\u001a\n\u0012\u0004\u0012\u00020\u0015\u0018\u00010\u0007X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b_\u0010WR\u001c\u0010\u0016\u001a\n\u0012\u0004\u0012\u00020\u0017\u0018\u00010\u000eX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b`\u0010[R\u0016\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00190\u00078\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\u001a\u001a\n\u0012\u0004\u0012\u00020\u001b\u0018\u00010\u000eX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\ba\u0010[R\u0016\u0010\u001c\u001a\u0004\u0018\u00010\u001dX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\bb\u0010cR\u001c\u0010\u001e\u001a\n\u0012\u0004\u0012\u00020\u001f\u0018\u00010\u000eX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\bd\u0010[R\u0016\u0010 \u001a\b\u0012\u0004\u0012\u00020\u00190\u00078\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0014\u0010!\u001a\u00020\"X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\be\u0010fR\u0016\u0010#\u001a\u0004\u0018\u00010$X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\bg\u0010hR\u0016\u0010%\u001a\b\u0012\u0004\u0012\u00020&0\u000e8\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0016\u0010'\u001a\u0004\u0018\u00010(X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\bi\u0010jR\u0016\u0010)\u001a\u0004\u0018\u00010*X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\bk\u0010lR\u0016\u0010+\u001a\u0004\u0018\u00010*X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\bm\u0010lR\u0016\u0010,\u001a\b\u0012\u0004\u0012\u00020\u00190\u00078\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u001c\u0010-\u001a\n\u0012\u0004\u0012\u00020$\u0018\u00010\u0007X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\bn\u0010WR\u001c\u0010.\u001a\n\u0012\u0004\u0012\u00020\u0015\u0018\u00010\u0007X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\bo\u0010WR\u001c\u0010/\u001a\n\u0012\u0004\u0012\u000200\u0018\u00010\u000eX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\bp\u0010[R\u0016\u00101\u001a\b\u0012\u0004\u0012\u00020\u00150\u00078\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0016\u00102\u001a\b\u0012\u0004\u0012\u0002030\u00078\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0010\u00104\u001a\u00020*8\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0016\u00105\u001a\b\u0012\u0004\u0012\u00020\u00190\u00078\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0012\u00106\u001a\u0004\u0018\u0001078\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0012\u00108\u001a\u0004\u0018\u0001098\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0010\u0010:\u001a\u00020*8\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u001c\u0010;\u001a\n\u0012\u0004\u0012\u00020<\u0018\u00010\u000eX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\bq\u0010[R\u0016\u0010=\u001a\u0004\u0018\u00010>X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\br\u0010sR\u0016\u0010?\u001a\u0004\u0018\u00010@X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\bt\u0010uR\u0016\u0010A\u001a\u0004\u0018\u00010BX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\bv\u0010wR\u0016\u0010C\u001a\u0004\u0018\u00010BX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\bx\u0010wR\u001c\u0010D\u001a\n\u0012\u0004\u0012\u00020E\u0018\u00010\u000eX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\by\u0010[R\u001c\u0010F\u001a\n\u0012\u0004\u0012\u00020G\u0018\u00010\u000eX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\bz\u0010[R\u001c\u0010H\u001a\n\u0012\u0004\u0012\u00020I\u0018\u00010\u000eX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b{\u0010[R\u001a\u0010J\u001a\b\u0012\u0004\u0012\u00020K0\u0007X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b|\u0010WR\u0016\u0010L\u001a\u0004\u0018\u00010MX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b}\u0010~R\u001c\u0010N\u001a\n\u0012\u0004\u0012\u00020M\u0018\u00010\u000eX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u007f\u0010[R\u0015\u0010O\u001a\u00020\"X\u0096\u0004¢\u0006\t\n\u0000\u001a\u0005\b\u0080\u0001\u0010f¨\u0006\u008f\u0001"}, d2 = {"Lcom/yandex/div2/DivTabs;", "Lcom/yandex/div/json/JSONSerializable;", "Lcom/yandex/div/data/Hashable;", "Lcom/yandex/div2/DivBase;", "accessibility", "Lcom/yandex/div2/DivAccessibility;", "alignmentHorizontal", "Lcom/yandex/div/json/expressions/Expression;", "Lcom/yandex/div2/DivAlignmentHorizontal;", "alignmentVertical", "Lcom/yandex/div2/DivAlignmentVertical;", "alpha", "", "animators", "", "Lcom/yandex/div2/DivAnimator;", J2.g, "Lcom/yandex/div2/DivBackground;", OutlinedTextFieldKt.BorderId, "Lcom/yandex/div2/DivBorder;", "columnSpan", "", "disappearActions", "Lcom/yandex/div2/DivDisappearAction;", "dynamicHeight", "", "extensions", "Lcom/yandex/div2/DivExtension;", "focus", "Lcom/yandex/div2/DivFocus;", "functions", "Lcom/yandex/div2/DivFunction;", "hasSeparator", "height", "Lcom/yandex/div2/DivSize;", "id", "", FirebaseAnalytics.Param.ITEMS, "Lcom/yandex/div2/DivTabs$Item;", "layoutProvider", "Lcom/yandex/div2/DivLayoutProvider;", "margins", "Lcom/yandex/div2/DivEdgeInsets;", "paddings", "restrictParentScroll", "reuseId", "rowSpan", "selectedActions", "Lcom/yandex/div2/DivAction;", "selectedTab", "separatorColor", "", "separatorPaddings", "switchTabsByContentSwipeEnabled", "tabTitleDelimiter", "Lcom/yandex/div2/DivTabs$TabTitleDelimiter;", "tabTitleStyle", "Lcom/yandex/div2/DivTabs$TabTitleStyle;", "titlePaddings", "tooltips", "Lcom/yandex/div2/DivTooltip;", "transform", "Lcom/yandex/div2/DivTransform;", "transitionChange", "Lcom/yandex/div2/DivChangeTransition;", "transitionIn", "Lcom/yandex/div2/DivAppearanceTransition;", "transitionOut", "transitionTriggers", "Lcom/yandex/div2/DivTransitionTrigger;", "variableTriggers", "Lcom/yandex/div2/DivTrigger;", "variables", "Lcom/yandex/div2/DivVariable;", "visibility", "Lcom/yandex/div2/DivVisibility;", "visibilityAction", "Lcom/yandex/div2/DivVisibilityAction;", "visibilityActions", "width", "(Lcom/yandex/div2/DivAccessibility;Lcom/yandex/div/json/expressions/Expression;Lcom/yandex/div/json/expressions/Expression;Lcom/yandex/div/json/expressions/Expression;Ljava/util/List;Ljava/util/List;Lcom/yandex/div2/DivBorder;Lcom/yandex/div/json/expressions/Expression;Ljava/util/List;Lcom/yandex/div/json/expressions/Expression;Ljava/util/List;Lcom/yandex/div2/DivFocus;Ljava/util/List;Lcom/yandex/div/json/expressions/Expression;Lcom/yandex/div2/DivSize;Ljava/lang/String;Ljava/util/List;Lcom/yandex/div2/DivLayoutProvider;Lcom/yandex/div2/DivEdgeInsets;Lcom/yandex/div2/DivEdgeInsets;Lcom/yandex/div/json/expressions/Expression;Lcom/yandex/div/json/expressions/Expression;Lcom/yandex/div/json/expressions/Expression;Ljava/util/List;Lcom/yandex/div/json/expressions/Expression;Lcom/yandex/div/json/expressions/Expression;Lcom/yandex/div2/DivEdgeInsets;Lcom/yandex/div/json/expressions/Expression;Lcom/yandex/div2/DivTabs$TabTitleDelimiter;Lcom/yandex/div2/DivTabs$TabTitleStyle;Lcom/yandex/div2/DivEdgeInsets;Ljava/util/List;Lcom/yandex/div2/DivTransform;Lcom/yandex/div2/DivChangeTransition;Lcom/yandex/div2/DivAppearanceTransition;Lcom/yandex/div2/DivAppearanceTransition;Ljava/util/List;Ljava/util/List;Ljava/util/List;Lcom/yandex/div/json/expressions/Expression;Lcom/yandex/div2/DivVisibilityAction;Ljava/util/List;Lcom/yandex/div2/DivSize;)V", "_hash", "Ljava/lang/Integer;", "_propertiesHash", "getAccessibility", "()Lcom/yandex/div2/DivAccessibility;", "getAlignmentHorizontal", "()Lcom/yandex/div/json/expressions/Expression;", "getAlignmentVertical", "getAlpha", "getAnimators", "()Ljava/util/List;", "getBackground", "getBorder", "()Lcom/yandex/div2/DivBorder;", "getColumnSpan", "getDisappearActions", "getExtensions", "getFocus", "()Lcom/yandex/div2/DivFocus;", "getFunctions", "getHeight", "()Lcom/yandex/div2/DivSize;", "getId", "()Ljava/lang/String;", "getLayoutProvider", "()Lcom/yandex/div2/DivLayoutProvider;", "getMargins", "()Lcom/yandex/div2/DivEdgeInsets;", "getPaddings", "getReuseId", "getRowSpan", "getSelectedActions", "getTooltips", "getTransform", "()Lcom/yandex/div2/DivTransform;", "getTransitionChange", "()Lcom/yandex/div2/DivChangeTransition;", "getTransitionIn", "()Lcom/yandex/div2/DivAppearanceTransition;", "getTransitionOut", "getTransitionTriggers", "getVariableTriggers", "getVariables", "getVisibility", "getVisibilityAction", "()Lcom/yandex/div2/DivVisibilityAction;", "getVisibilityActions", "getWidth", "copy", "equals", "other", "resolver", "Lcom/yandex/div/json/expressions/ExpressionResolver;", "otherResolver", "hash", "propertiesHash", "writeToJSON", "Lorg/json/JSONObject;", "Companion", "Item", "TabTitleDelimiter", "TabTitleStyle", "div-data_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class DivTabs implements JSONSerializable, Hashable, DivBase {
    public static final String TYPE = "tabs";
    private Integer _hash;
    private Integer _propertiesHash;
    private final DivAccessibility accessibility;
    private final Expression<DivAlignmentHorizontal> alignmentHorizontal;
    private final Expression<DivAlignmentVertical> alignmentVertical;
    private final Expression<Double> alpha;
    private final List<DivAnimator> animators;
    private final List<DivBackground> background;
    private final DivBorder border;
    private final Expression<Long> columnSpan;
    private final List<DivDisappearAction> disappearActions;
    public final Expression<Boolean> dynamicHeight;
    private final List<DivExtension> extensions;
    private final DivFocus focus;
    private final List<DivFunction> functions;
    public final Expression<Boolean> hasSeparator;
    private final DivSize height;
    private final String id;
    public final List<Item> items;
    private final DivLayoutProvider layoutProvider;
    private final DivEdgeInsets margins;
    private final DivEdgeInsets paddings;
    public final Expression<Boolean> restrictParentScroll;
    private final Expression<String> reuseId;
    private final Expression<Long> rowSpan;
    private final List<DivAction> selectedActions;
    public final Expression<Long> selectedTab;
    public final Expression<Integer> separatorColor;
    public final DivEdgeInsets separatorPaddings;
    public final Expression<Boolean> switchTabsByContentSwipeEnabled;
    public final TabTitleDelimiter tabTitleDelimiter;
    public final TabTitleStyle tabTitleStyle;
    public final DivEdgeInsets titlePaddings;
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
    private static final Expression<Double> ALPHA_DEFAULT_VALUE = Expression.INSTANCE.constant(Double.valueOf(1.0d));
    private static final Expression<Boolean> DYNAMIC_HEIGHT_DEFAULT_VALUE = Expression.INSTANCE.constant(false);
    private static final Expression<Boolean> HAS_SEPARATOR_DEFAULT_VALUE = Expression.INSTANCE.constant(false);
    private static final DivSize.WrapContent HEIGHT_DEFAULT_VALUE = new DivSize.WrapContent(new DivWrapContentSize(null, null, null, 7, null));
    private static final Expression<Boolean> RESTRICT_PARENT_SCROLL_DEFAULT_VALUE = Expression.INSTANCE.constant(false);
    private static final Expression<Long> SELECTED_TAB_DEFAULT_VALUE = Expression.INSTANCE.constant(0L);
    private static final Expression<Integer> SEPARATOR_COLOR_DEFAULT_VALUE = Expression.INSTANCE.constant(Integer.valueOf(DivSeparatorView.DEFAULT_DIVIDER_COLOR));
    private static final DivEdgeInsets SEPARATOR_PADDINGS_DEFAULT_VALUE = new DivEdgeInsets(Expression.INSTANCE.constant(0L), null, Expression.INSTANCE.constant(12L), Expression.INSTANCE.constant(12L), 0 == true ? 1 : 0, Expression.INSTANCE.constant(0L), null, 82, null);
    private static final Expression<Boolean> SWITCH_TABS_BY_CONTENT_SWIPE_ENABLED_DEFAULT_VALUE = Expression.INSTANCE.constant(true);
    private static final DivEdgeInsets TITLE_PADDINGS_DEFAULT_VALUE = new DivEdgeInsets(Expression.INSTANCE.constant(8L), null, Expression.INSTANCE.constant(12L), Expression.INSTANCE.constant(12L), null, Expression.INSTANCE.constant(0L), null, 82, null);
    private static final Expression<DivVisibility> VISIBILITY_DEFAULT_VALUE = Expression.INSTANCE.constant(DivVisibility.VISIBLE);
    private static final DivSize.MatchParent WIDTH_DEFAULT_VALUE = new DivSize.MatchParent(new DivMatchParentSize(0 == true ? 1 : 0, 1, 0 == true ? 1 : 0));
    private static final Function2<ParsingEnvironment, JSONObject, DivTabs> CREATOR = new Function2<ParsingEnvironment, JSONObject, DivTabs>() { // from class: com.yandex.div2.DivTabs$Companion$CREATOR$1
        @Override // kotlin.jvm.functions.Function2
        public final DivTabs invoke(ParsingEnvironment env, JSONObject it) {
            Intrinsics.checkNotNullParameter(env, "env");
            Intrinsics.checkNotNullParameter(it, "it");
            return DivTabs.INSTANCE.fromJson(env, it);
        }
    };

    @JvmStatic
    public static final DivTabs fromJson(ParsingEnvironment parsingEnvironment, JSONObject jSONObject) {
        return INSTANCE.fromJson(parsingEnvironment, jSONObject);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public DivTabs(DivAccessibility divAccessibility, Expression<DivAlignmentHorizontal> expression, Expression<DivAlignmentVertical> expression2, Expression<Double> alpha, List<? extends DivAnimator> list, List<? extends DivBackground> list2, DivBorder divBorder, Expression<Long> expression3, List<DivDisappearAction> list3, Expression<Boolean> dynamicHeight, List<DivExtension> list4, DivFocus divFocus, List<DivFunction> list5, Expression<Boolean> hasSeparator, DivSize height, String str, List<Item> items, DivLayoutProvider divLayoutProvider, DivEdgeInsets divEdgeInsets, DivEdgeInsets divEdgeInsets2, Expression<Boolean> restrictParentScroll, Expression<String> expression4, Expression<Long> expression5, List<DivAction> list6, Expression<Long> selectedTab, Expression<Integer> separatorColor, DivEdgeInsets separatorPaddings, Expression<Boolean> switchTabsByContentSwipeEnabled, TabTitleDelimiter tabTitleDelimiter, TabTitleStyle tabTitleStyle, DivEdgeInsets titlePaddings, List<DivTooltip> list7, DivTransform divTransform, DivChangeTransition divChangeTransition, DivAppearanceTransition divAppearanceTransition, DivAppearanceTransition divAppearanceTransition2, List<? extends DivTransitionTrigger> list8, List<DivTrigger> list9, List<? extends DivVariable> list10, Expression<DivVisibility> visibility, DivVisibilityAction divVisibilityAction, List<DivVisibilityAction> list11, DivSize width) {
        Intrinsics.checkNotNullParameter(alpha, "alpha");
        Intrinsics.checkNotNullParameter(dynamicHeight, "dynamicHeight");
        Intrinsics.checkNotNullParameter(hasSeparator, "hasSeparator");
        Intrinsics.checkNotNullParameter(height, "height");
        Intrinsics.checkNotNullParameter(items, "items");
        Intrinsics.checkNotNullParameter(restrictParentScroll, "restrictParentScroll");
        Intrinsics.checkNotNullParameter(selectedTab, "selectedTab");
        Intrinsics.checkNotNullParameter(separatorColor, "separatorColor");
        Intrinsics.checkNotNullParameter(separatorPaddings, "separatorPaddings");
        Intrinsics.checkNotNullParameter(switchTabsByContentSwipeEnabled, "switchTabsByContentSwipeEnabled");
        Intrinsics.checkNotNullParameter(titlePaddings, "titlePaddings");
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
        this.dynamicHeight = dynamicHeight;
        this.extensions = list4;
        this.focus = divFocus;
        this.functions = list5;
        this.hasSeparator = hasSeparator;
        this.height = height;
        this.id = str;
        this.items = items;
        this.layoutProvider = divLayoutProvider;
        this.margins = divEdgeInsets;
        this.paddings = divEdgeInsets2;
        this.restrictParentScroll = restrictParentScroll;
        this.reuseId = expression4;
        this.rowSpan = expression5;
        this.selectedActions = list6;
        this.selectedTab = selectedTab;
        this.separatorColor = separatorColor;
        this.separatorPaddings = separatorPaddings;
        this.switchTabsByContentSwipeEnabled = switchTabsByContentSwipeEnabled;
        this.tabTitleDelimiter = tabTitleDelimiter;
        this.tabTitleStyle = tabTitleStyle;
        this.titlePaddings = titlePaddings;
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

    @Override // com.yandex.div2.DivBase
    public Expression<DivAlignmentHorizontal> getAlignmentHorizontal() {
        return this.alignmentHorizontal;
    }

    @Override // com.yandex.div2.DivBase
    public Expression<DivAlignmentVertical> getAlignmentVertical() {
        return this.alignmentVertical;
    }

    public /* synthetic */ DivTabs(DivAccessibility divAccessibility, Expression expression, Expression expression2, Expression expression3, List list, List list2, DivBorder divBorder, Expression expression4, List list3, Expression expression5, List list4, DivFocus divFocus, List list5, Expression expression6, DivSize divSize, String str, List list6, DivLayoutProvider divLayoutProvider, DivEdgeInsets divEdgeInsets, DivEdgeInsets divEdgeInsets2, Expression expression7, Expression expression8, Expression expression9, List list7, Expression expression10, Expression expression11, DivEdgeInsets divEdgeInsets3, Expression expression12, TabTitleDelimiter tabTitleDelimiter, TabTitleStyle tabTitleStyle, DivEdgeInsets divEdgeInsets4, List list8, DivTransform divTransform, DivChangeTransition divChangeTransition, DivAppearanceTransition divAppearanceTransition, DivAppearanceTransition divAppearanceTransition2, List list9, List list10, List list11, Expression expression13, DivVisibilityAction divVisibilityAction, List list12, DivSize divSize2, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : divAccessibility, (i & 2) != 0 ? null : expression, (i & 4) != 0 ? null : expression2, (i & 8) != 0 ? ALPHA_DEFAULT_VALUE : expression3, (i & 16) != 0 ? null : list, (i & 32) != 0 ? null : list2, (i & 64) != 0 ? null : divBorder, (i & 128) != 0 ? null : expression4, (i & 256) != 0 ? null : list3, (i & 512) != 0 ? DYNAMIC_HEIGHT_DEFAULT_VALUE : expression5, (i & 1024) != 0 ? null : list4, (i & 2048) != 0 ? null : divFocus, (i & 4096) != 0 ? null : list5, (i & 8192) != 0 ? HAS_SEPARATOR_DEFAULT_VALUE : expression6, (i & 16384) != 0 ? HEIGHT_DEFAULT_VALUE : divSize, (32768 & i) != 0 ? null : str, list6, (131072 & i) != 0 ? null : divLayoutProvider, (262144 & i) != 0 ? null : divEdgeInsets, (524288 & i) != 0 ? null : divEdgeInsets2, (1048576 & i) != 0 ? RESTRICT_PARENT_SCROLL_DEFAULT_VALUE : expression7, (2097152 & i) != 0 ? null : expression8, (4194304 & i) != 0 ? null : expression9, (8388608 & i) != 0 ? null : list7, (16777216 & i) != 0 ? SELECTED_TAB_DEFAULT_VALUE : expression10, (33554432 & i) != 0 ? SEPARATOR_COLOR_DEFAULT_VALUE : expression11, (67108864 & i) != 0 ? SEPARATOR_PADDINGS_DEFAULT_VALUE : divEdgeInsets3, (134217728 & i) != 0 ? SWITCH_TABS_BY_CONTENT_SWIPE_ENABLED_DEFAULT_VALUE : expression12, (268435456 & i) != 0 ? null : tabTitleDelimiter, (536870912 & i) != 0 ? null : tabTitleStyle, (1073741824 & i) != 0 ? TITLE_PADDINGS_DEFAULT_VALUE : divEdgeInsets4, (i & Integer.MIN_VALUE) != 0 ? null : list8, (i2 & 1) != 0 ? null : divTransform, (i2 & 2) != 0 ? null : divChangeTransition, (i2 & 4) != 0 ? null : divAppearanceTransition, (i2 & 8) != 0 ? null : divAppearanceTransition2, (i2 & 16) != 0 ? null : list9, (i2 & 32) != 0 ? null : list10, (i2 & 64) != 0 ? null : list11, (i2 & 128) != 0 ? VISIBILITY_DEFAULT_VALUE : expression13, (i2 & 256) != 0 ? null : divVisibilityAction, (i2 & 512) != 0 ? null : list12, (i2 & 1024) != 0 ? WIDTH_DEFAULT_VALUE : divSize2);
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
        int iHash12 = i2 + (border != null ? border.hash() : 0);
        Expression<Long> columnSpan = getColumnSpan();
        int iHashCode4 = iHash12 + (columnSpan != null ? columnSpan.hashCode() : 0);
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
        int iHashCode5 = iHashCode4 + iHash3 + this.dynamicHeight.hashCode();
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
        int i3 = iHashCode5 + iHash4;
        DivFocus focus = getFocus();
        int iHash13 = i3 + (focus != null ? focus.hash() : 0);
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
        int iHashCode6 = iHash13 + iHash5 + this.hasSeparator.hashCode() + getHeight().hash();
        String id = getId();
        int iHashCode7 = iHashCode6 + (id != null ? id.hashCode() : 0);
        DivLayoutProvider layoutProvider = getLayoutProvider();
        int iHash14 = iHashCode7 + (layoutProvider != null ? layoutProvider.hash() : 0);
        DivEdgeInsets margins = getMargins();
        int iHash15 = iHash14 + (margins != null ? margins.hash() : 0);
        DivEdgeInsets paddings = getPaddings();
        int iHash16 = iHash15 + (paddings != null ? paddings.hash() : 0) + this.restrictParentScroll.hashCode();
        Expression<String> reuseId = getReuseId();
        int iHashCode8 = iHash16 + (reuseId != null ? reuseId.hashCode() : 0);
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
        int iHashCode10 = iHashCode9 + iHash6 + this.selectedTab.hashCode() + this.separatorColor.hashCode() + this.separatorPaddings.hash() + this.switchTabsByContentSwipeEnabled.hashCode();
        TabTitleDelimiter tabTitleDelimiter = this.tabTitleDelimiter;
        int iHash17 = iHashCode10 + (tabTitleDelimiter != null ? tabTitleDelimiter.hash() : 0);
        TabTitleStyle tabTitleStyle = this.tabTitleStyle;
        int iHash18 = iHash17 + (tabTitleStyle != null ? tabTitleStyle.hash() : 0) + this.titlePaddings.hash();
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
        int i4 = iHash18 + iHash7;
        DivTransform transform = getTransform();
        int iHash19 = i4 + (transform != null ? transform.hash() : 0);
        DivChangeTransition transitionChange = getTransitionChange();
        int iHash20 = iHash19 + (transitionChange != null ? transitionChange.hash() : 0);
        DivAppearanceTransition transitionIn = getTransitionIn();
        int iHash21 = iHash20 + (transitionIn != null ? transitionIn.hash() : 0);
        DivAppearanceTransition transitionOut = getTransitionOut();
        int iHash22 = iHash21 + (transitionOut != null ? transitionOut.hash() : 0);
        List<DivTransitionTrigger> transitionTriggers = getTransitionTriggers();
        int iHashCode11 = iHash22 + (transitionTriggers != null ? transitionTriggers.hashCode() : 0);
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
        int i5 = iHashCode11 + iHash8;
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
        int iHashCode12 = i5 + iHash9 + getVisibility().hashCode();
        DivVisibilityAction visibilityAction = getVisibilityAction();
        int iHash23 = iHashCode12 + (visibilityAction != null ? visibilityAction.hash() : 0);
        List<DivVisibilityAction> visibilityActions = getVisibilityActions();
        if (visibilityActions != null) {
            Iterator<T> it10 = visibilityActions.iterator();
            while (it10.hasNext()) {
                iHash10 += ((DivVisibilityAction) it10.next()).hash();
            }
        }
        int iHash24 = iHash23 + iHash10 + getWidth().hash();
        this._propertiesHash = Integer.valueOf(iHash24);
        return iHash24;
    }

    @Override // com.yandex.div.data.Hashable
    public int hash() {
        Integer num = this._hash;
        if (num != null) {
            return num.intValue();
        }
        int iPropertiesHash = propertiesHash();
        Iterator<T> it = this.items.iterator();
        int iHash = 0;
        while (it.hasNext()) {
            iHash += ((Item) it.next()).hash();
        }
        int i = iPropertiesHash + iHash;
        this._hash = Integer.valueOf(i);
        return i;
    }

    public final boolean equals(DivTabs other, ExpressionResolver resolver, ExpressionResolver otherResolver) {
        boolean zEquals;
        boolean z;
        boolean z2;
        boolean zEquals2;
        boolean z3;
        boolean z4;
        boolean zEquals3;
        boolean z5;
        boolean z6;
        boolean zEquals4;
        boolean zEquals5;
        boolean zEquals6;
        boolean z7;
        boolean zEquals7;
        boolean zEquals8;
        boolean z8;
        boolean zEquals9;
        boolean zEquals10;
        boolean zEquals11;
        boolean zEquals12;
        boolean z9;
        boolean z10;
        boolean z11;
        boolean zEquals13;
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
        if (!z3 || this.dynamicHeight.evaluate(resolver).booleanValue() != other.dynamicHeight.evaluate(otherResolver).booleanValue()) {
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
        if (!z5 || this.hasSeparator.evaluate(resolver).booleanValue() != other.hasSeparator.evaluate(otherResolver).booleanValue() || !getHeight().equals(other.getHeight(), resolver, otherResolver) || !Intrinsics.areEqual(getId(), other.getId())) {
            return false;
        }
        List<Item> list = this.items;
        List<Item> list2 = other.items;
        if (list.size() == list2.size()) {
            Iterator<T> it6 = list.iterator();
            int i11 = 0;
            while (true) {
                if (!it6.hasNext()) {
                    z6 = true;
                    break;
                }
                Object next6 = it6.next();
                int i12 = i11 + 1;
                if (i11 < 0) {
                    CollectionsKt.throwIndexOverflow();
                }
                if (!((Item) next6).equals(list2.get(i11), resolver, otherResolver)) {
                    z6 = false;
                    break;
                }
                i11 = i12;
            }
        } else {
            z6 = false;
            break;
        }
        if (!z6) {
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
        if (!zEquals6 || this.restrictParentScroll.evaluate(resolver).booleanValue() != other.restrictParentScroll.evaluate(otherResolver).booleanValue()) {
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
        if (!z7 || this.selectedTab.evaluate(resolver).longValue() != other.selectedTab.evaluate(otherResolver).longValue() || this.separatorColor.evaluate(resolver).intValue() != other.separatorColor.evaluate(otherResolver).intValue() || !this.separatorPaddings.equals(other.separatorPaddings, resolver, otherResolver) || this.switchTabsByContentSwipeEnabled.evaluate(resolver).booleanValue() != other.switchTabsByContentSwipeEnabled.evaluate(otherResolver).booleanValue()) {
            return false;
        }
        TabTitleDelimiter tabTitleDelimiter = this.tabTitleDelimiter;
        if (tabTitleDelimiter != null) {
            zEquals7 = tabTitleDelimiter.equals(other.tabTitleDelimiter, resolver, otherResolver);
        } else {
            zEquals7 = other.tabTitleDelimiter == null;
        }
        if (!zEquals7) {
            return false;
        }
        TabTitleStyle tabTitleStyle = this.tabTitleStyle;
        if (tabTitleStyle != null) {
            zEquals8 = tabTitleStyle.equals(other.tabTitleStyle, resolver, otherResolver);
        } else {
            zEquals8 = other.tabTitleStyle == null;
        }
        if (!zEquals8 || !this.titlePaddings.equals(other.titlePaddings, resolver, otherResolver)) {
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
    public static /* synthetic */ DivTabs copy$default(DivTabs divTabs, DivAccessibility divAccessibility, Expression expression, Expression expression2, Expression expression3, List list, List list2, DivBorder divBorder, Expression expression4, List list3, Expression expression5, List list4, DivFocus divFocus, List list5, Expression expression6, DivSize divSize, String str, List list6, DivLayoutProvider divLayoutProvider, DivEdgeInsets divEdgeInsets, DivEdgeInsets divEdgeInsets2, Expression expression7, Expression expression8, Expression expression9, List list7, Expression expression10, Expression expression11, DivEdgeInsets divEdgeInsets3, Expression expression12, TabTitleDelimiter tabTitleDelimiter, TabTitleStyle tabTitleStyle, DivEdgeInsets divEdgeInsets4, List list8, DivTransform divTransform, DivChangeTransition divChangeTransition, DivAppearanceTransition divAppearanceTransition, DivAppearanceTransition divAppearanceTransition2, List list9, List list10, List list11, Expression expression13, DivVisibilityAction divVisibilityAction, List list12, DivSize divSize2, int i, int i2, Object obj) {
        DivAccessibility accessibility = (i & 1) != 0 ? divTabs.getAccessibility() : divAccessibility;
        Expression alignmentHorizontal = (i & 2) != 0 ? divTabs.getAlignmentHorizontal() : expression;
        Expression alignmentVertical = (i & 4) != 0 ? divTabs.getAlignmentVertical() : expression2;
        Expression alpha = (i & 8) != 0 ? divTabs.getAlpha() : expression3;
        List animators = (i & 16) != 0 ? divTabs.getAnimators() : list;
        List background = (i & 32) != 0 ? divTabs.getBackground() : list2;
        DivBorder border = (i & 64) != 0 ? divTabs.getBorder() : divBorder;
        Expression columnSpan = (i & 128) != 0 ? divTabs.getColumnSpan() : expression4;
        List disappearActions = (i & 256) != 0 ? divTabs.getDisappearActions() : list3;
        Expression expression14 = (i & 512) != 0 ? divTabs.dynamicHeight : expression5;
        List extensions = (i & 1024) != 0 ? divTabs.getExtensions() : list4;
        DivFocus focus = (i & 2048) != 0 ? divTabs.getFocus() : divFocus;
        List functions = (i & 4096) != 0 ? divTabs.getFunctions() : list5;
        Expression expression15 = (i & 8192) != 0 ? divTabs.hasSeparator : expression6;
        DivSize height = (i & 16384) != 0 ? divTabs.getHeight() : divSize;
        String id = (i & 32768) != 0 ? divTabs.getId() : str;
        DivSize divSize3 = height;
        List list13 = (i & 65536) != 0 ? divTabs.items : list6;
        return divTabs.copy(accessibility, alignmentHorizontal, alignmentVertical, alpha, animators, background, border, columnSpan, disappearActions, expression14, extensions, focus, functions, expression15, divSize3, id, list13, (i & 131072) != 0 ? divTabs.getLayoutProvider() : divLayoutProvider, (i & 262144) != 0 ? divTabs.getMargins() : divEdgeInsets, (i & 524288) != 0 ? divTabs.getPaddings() : divEdgeInsets2, (i & 1048576) != 0 ? divTabs.restrictParentScroll : expression7, (i & 2097152) != 0 ? divTabs.getReuseId() : expression8, (i & 4194304) != 0 ? divTabs.getRowSpan() : expression9, (i & 8388608) != 0 ? divTabs.getSelectedActions() : list7, (i & 16777216) != 0 ? divTabs.selectedTab : expression10, (i & 33554432) != 0 ? divTabs.separatorColor : expression11, (i & 67108864) != 0 ? divTabs.separatorPaddings : divEdgeInsets3, (i & 134217728) != 0 ? divTabs.switchTabsByContentSwipeEnabled : expression12, (i & 268435456) != 0 ? divTabs.tabTitleDelimiter : tabTitleDelimiter, (i & 536870912) != 0 ? divTabs.tabTitleStyle : tabTitleStyle, (i & 1073741824) != 0 ? divTabs.titlePaddings : divEdgeInsets4, (i & Integer.MIN_VALUE) != 0 ? divTabs.getTooltips() : list8, (i2 & 1) != 0 ? divTabs.getTransform() : divTransform, (i2 & 2) != 0 ? divTabs.getTransitionChange() : divChangeTransition, (i2 & 4) != 0 ? divTabs.getTransitionIn() : divAppearanceTransition, (i2 & 8) != 0 ? divTabs.getTransitionOut() : divAppearanceTransition2, (i2 & 16) != 0 ? divTabs.getTransitionTriggers() : list9, (i2 & 32) != 0 ? divTabs.getVariableTriggers() : list10, (i2 & 64) != 0 ? divTabs.getVariables() : list11, (i2 & 128) != 0 ? divTabs.getVisibility() : expression13, (i2 & 256) != 0 ? divTabs.getVisibilityAction() : divVisibilityAction, (i2 & 512) != 0 ? divTabs.getVisibilityActions() : list12, (i2 & 1024) != 0 ? divTabs.getWidth() : divSize2);
    }

    public final DivTabs copy(DivAccessibility accessibility, Expression<DivAlignmentHorizontal> alignmentHorizontal, Expression<DivAlignmentVertical> alignmentVertical, Expression<Double> alpha, List<? extends DivAnimator> animators, List<? extends DivBackground> background, DivBorder border, Expression<Long> columnSpan, List<DivDisappearAction> disappearActions, Expression<Boolean> dynamicHeight, List<DivExtension> extensions, DivFocus focus, List<DivFunction> functions, Expression<Boolean> hasSeparator, DivSize height, String id, List<Item> items, DivLayoutProvider layoutProvider, DivEdgeInsets margins, DivEdgeInsets paddings, Expression<Boolean> restrictParentScroll, Expression<String> reuseId, Expression<Long> rowSpan, List<DivAction> selectedActions, Expression<Long> selectedTab, Expression<Integer> separatorColor, DivEdgeInsets separatorPaddings, Expression<Boolean> switchTabsByContentSwipeEnabled, TabTitleDelimiter tabTitleDelimiter, TabTitleStyle tabTitleStyle, DivEdgeInsets titlePaddings, List<DivTooltip> tooltips, DivTransform transform, DivChangeTransition transitionChange, DivAppearanceTransition transitionIn, DivAppearanceTransition transitionOut, List<? extends DivTransitionTrigger> transitionTriggers, List<DivTrigger> variableTriggers, List<? extends DivVariable> variables, Expression<DivVisibility> visibility, DivVisibilityAction visibilityAction, List<DivVisibilityAction> visibilityActions, DivSize width) {
        Intrinsics.checkNotNullParameter(alpha, "alpha");
        Intrinsics.checkNotNullParameter(dynamicHeight, "dynamicHeight");
        Intrinsics.checkNotNullParameter(hasSeparator, "hasSeparator");
        Intrinsics.checkNotNullParameter(height, "height");
        Intrinsics.checkNotNullParameter(items, "items");
        Intrinsics.checkNotNullParameter(restrictParentScroll, "restrictParentScroll");
        Intrinsics.checkNotNullParameter(selectedTab, "selectedTab");
        Intrinsics.checkNotNullParameter(separatorColor, "separatorColor");
        Intrinsics.checkNotNullParameter(separatorPaddings, "separatorPaddings");
        Intrinsics.checkNotNullParameter(switchTabsByContentSwipeEnabled, "switchTabsByContentSwipeEnabled");
        Intrinsics.checkNotNullParameter(titlePaddings, "titlePaddings");
        Intrinsics.checkNotNullParameter(visibility, "visibility");
        Intrinsics.checkNotNullParameter(width, "width");
        return new DivTabs(accessibility, alignmentHorizontal, alignmentVertical, alpha, animators, background, border, columnSpan, disappearActions, dynamicHeight, extensions, focus, functions, hasSeparator, height, id, items, layoutProvider, margins, paddings, restrictParentScroll, reuseId, rowSpan, selectedActions, selectedTab, separatorColor, separatorPaddings, switchTabsByContentSwipeEnabled, tabTitleDelimiter, tabTitleStyle, titlePaddings, tooltips, transform, transitionChange, transitionIn, transitionOut, transitionTriggers, variableTriggers, variables, visibility, visibilityAction, visibilityActions, width);
    }

    @Override // com.yandex.div.json.JSONSerializable
    public JSONObject writeToJSON() {
        return BuiltInParserKt.getBuiltInParserComponent().getDivTabsJsonEntityParser().getValue().serialize(BuiltInParserKt.getBuiltInParsingContext(), this);
    }

    /* JADX INFO: compiled from: DivTabs.kt */
    @Metadata(d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0006\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u001e\u0010!\u001a\u00020\n2\u0006\u0010\"\u001a\u00020\b2\u0006\u0010#\u001a\u00020\tH\u0087\u0002¢\u0006\u0002\b$R\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R#\u0010\u0006\u001a\u0014\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\n0\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0014\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000e0\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u000e0\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u000e0\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00140\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00160\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0018X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u000e0\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u0018X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u001cX\u0086T¢\u0006\u0002\n\u0000R\u0014\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u001e0\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001f\u001a\u00020 X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006%"}, d2 = {"Lcom/yandex/div2/DivTabs$Companion;", "", "()V", "ALPHA_DEFAULT_VALUE", "Lcom/yandex/div/json/expressions/Expression;", "", "CREATOR", "Lkotlin/Function2;", "Lcom/yandex/div/json/ParsingEnvironment;", "Lorg/json/JSONObject;", "Lcom/yandex/div2/DivTabs;", "getCREATOR", "()Lkotlin/jvm/functions/Function2;", "DYNAMIC_HEIGHT_DEFAULT_VALUE", "", "HAS_SEPARATOR_DEFAULT_VALUE", "HEIGHT_DEFAULT_VALUE", "Lcom/yandex/div2/DivSize$WrapContent;", "RESTRICT_PARENT_SCROLL_DEFAULT_VALUE", "SELECTED_TAB_DEFAULT_VALUE", "", "SEPARATOR_COLOR_DEFAULT_VALUE", "", "SEPARATOR_PADDINGS_DEFAULT_VALUE", "Lcom/yandex/div2/DivEdgeInsets;", "SWITCH_TABS_BY_CONTENT_SWIPE_ENABLED_DEFAULT_VALUE", "TITLE_PADDINGS_DEFAULT_VALUE", "TYPE", "", "VISIBILITY_DEFAULT_VALUE", "Lcom/yandex/div2/DivVisibility;", "WIDTH_DEFAULT_VALUE", "Lcom/yandex/div2/DivSize$MatchParent;", "invoke", cc.o, "json", "fromJson", "div-data_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @JvmStatic
        public final DivTabs fromJson(ParsingEnvironment env, JSONObject json) {
            Intrinsics.checkNotNullParameter(env, "env");
            Intrinsics.checkNotNullParameter(json, "json");
            return BuiltInParserKt.getBuiltInParserComponent().getDivTabsJsonEntityParser().getValue().deserialize((ParsingContext) env, json);
        }

        public final Function2<ParsingEnvironment, JSONObject, DivTabs> getCREATOR() {
            return DivTabs.CREATOR;
        }
    }

    /* JADX INFO: compiled from: DivTabs.kt */
    @Metadata(d1 = {"\u0000l\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0006\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 -2\u00020\u00012\u00020\u0002:\u0002,-B©\u0002\b\u0007\u0012\u000e\b\u0002\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004\u0012\u0010\b\u0002\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0004\u0012\u000e\b\u0002\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004\u0012\u000e\b\u0002\u0010\t\u001a\b\u0012\u0004\u0012\u00020\n0\u0004\u0012\u000e\b\u0002\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\f0\u0004\u0012\u0010\b\u0002\u0010\r\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u000f\u0012\u0010\b\u0002\u0010\u0010\u001a\n\u0012\u0004\u0012\u00020\u0011\u0018\u00010\u0004\u0012\u000e\b\u0002\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\n0\u0004\u0012\u000e\b\u0002\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00140\u0004\u0012\u000e\b\u0002\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00070\u0004\u0012\u0010\b\u0002\u0010\u0016\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0004\u0012\u0010\b\u0002\u0010\u0017\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0004\u0012\u000e\b\u0002\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004\u0012\u000e\b\u0002\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\n0\u0004\u0012\u000e\b\u0002\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u001b0\u0004\u0012\u0010\b\u0002\u0010\u001c\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\u0004\u0012\b\b\u0002\u0010\u001d\u001a\u00020\u001e¢\u0006\u0002\u0010\u001fJ¨\u0002\u0010\"\u001a\u00020\u00002\u000e\b\u0002\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\u0010\b\u0002\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u00042\u000e\b\u0002\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\u000e\b\u0002\u0010\t\u001a\b\u0012\u0004\u0012\u00020\n0\u00042\u000e\b\u0002\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\f0\u00042\u0010\b\u0002\u0010\r\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\u00042\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\u0010\b\u0002\u0010\u0010\u001a\n\u0012\u0004\u0012\u00020\u0011\u0018\u00010\u00042\u000e\b\u0002\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\n0\u00042\u000e\b\u0002\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00140\u00042\u000e\b\u0002\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00070\u00042\u0010\b\u0002\u0010\u0016\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u00042\u0010\b\u0002\u0010\u0017\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u00042\u000e\b\u0002\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\u000e\b\u0002\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\n0\u00042\u000e\b\u0002\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u001b0\u00042\u0010\b\u0002\u0010\u001c\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\u00042\b\b\u0002\u0010\u001d\u001a\u00020\u001eJ \u0010#\u001a\u00020$2\b\u0010%\u001a\u0004\u0018\u00010\u00002\u0006\u0010&\u001a\u00020'2\u0006\u0010(\u001a\u00020'J\b\u0010)\u001a\u00020\u0005H\u0016J\b\u0010*\u001a\u00020+H\u0016R\u0012\u0010 \u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0004\n\u0002\u0010!R\u0016\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u00048\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0018\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00050\u00048\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\t\u001a\b\u0012\u0004\u0012\u00020\n0\u00048\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\f0\u00048\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0018\u0010\r\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0012\u0010\u000e\u001a\u0004\u0018\u00010\u000f8\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0018\u0010\u0010\u001a\n\u0012\u0004\u0012\u00020\u0011\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\n0\u00048\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00140\u00048\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00070\u00048\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0018\u0010\u0016\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0018\u0010\u0017\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00050\u00048\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\n0\u00048\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u001b0\u00048\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0018\u0010\u001c\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u001d\u001a\u00020\u001e8\u0006X\u0087\u0004¢\u0006\u0002\n\u0000¨\u0006."}, d2 = {"Lcom/yandex/div2/DivTabs$TabTitleStyle;", "Lcom/yandex/div/json/JSONSerializable;", "Lcom/yandex/div/data/Hashable;", "activeBackgroundColor", "Lcom/yandex/div/json/expressions/Expression;", "", "activeFontWeight", "Lcom/yandex/div2/DivFontWeight;", "activeTextColor", "animationDuration", "", "animationType", "Lcom/yandex/div2/DivTabs$TabTitleStyle$AnimationType;", "cornerRadius", "cornersRadius", "Lcom/yandex/div2/DivCornersRadius;", "fontFamily", "", "fontSize", "fontSizeUnit", "Lcom/yandex/div2/DivSizeUnit;", "fontWeight", "inactiveBackgroundColor", "inactiveFontWeight", "inactiveTextColor", "itemSpacing", "letterSpacing", "", "lineHeight", "paddings", "Lcom/yandex/div2/DivEdgeInsets;", "(Lcom/yandex/div/json/expressions/Expression;Lcom/yandex/div/json/expressions/Expression;Lcom/yandex/div/json/expressions/Expression;Lcom/yandex/div/json/expressions/Expression;Lcom/yandex/div/json/expressions/Expression;Lcom/yandex/div/json/expressions/Expression;Lcom/yandex/div2/DivCornersRadius;Lcom/yandex/div/json/expressions/Expression;Lcom/yandex/div/json/expressions/Expression;Lcom/yandex/div/json/expressions/Expression;Lcom/yandex/div/json/expressions/Expression;Lcom/yandex/div/json/expressions/Expression;Lcom/yandex/div/json/expressions/Expression;Lcom/yandex/div/json/expressions/Expression;Lcom/yandex/div/json/expressions/Expression;Lcom/yandex/div/json/expressions/Expression;Lcom/yandex/div/json/expressions/Expression;Lcom/yandex/div2/DivEdgeInsets;)V", "_hash", "Ljava/lang/Integer;", "copy", "equals", "", "other", "resolver", "Lcom/yandex/div/json/expressions/ExpressionResolver;", "otherResolver", "hash", "writeToJSON", "Lorg/json/JSONObject;", "AnimationType", "Companion", "div-data_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class TabTitleStyle implements JSONSerializable, Hashable {
        private Integer _hash;
        public final Expression<Integer> activeBackgroundColor;
        public final Expression<DivFontWeight> activeFontWeight;
        public final Expression<Integer> activeTextColor;
        public final Expression<Long> animationDuration;
        public final Expression<AnimationType> animationType;
        public final Expression<Long> cornerRadius;
        public final DivCornersRadius cornersRadius;
        public final Expression<String> fontFamily;
        public final Expression<Long> fontSize;
        public final Expression<DivSizeUnit> fontSizeUnit;
        public final Expression<DivFontWeight> fontWeight;
        public final Expression<Integer> inactiveBackgroundColor;
        public final Expression<DivFontWeight> inactiveFontWeight;
        public final Expression<Integer> inactiveTextColor;
        public final Expression<Long> itemSpacing;
        public final Expression<Double> letterSpacing;
        public final Expression<Long> lineHeight;
        public final DivEdgeInsets paddings;

        /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
        public static final Companion INSTANCE = new Companion(null);
        private static final Expression<Integer> ACTIVE_BACKGROUND_COLOR_DEFAULT_VALUE = Expression.INSTANCE.constant(-9120);
        private static final Expression<Integer> ACTIVE_TEXT_COLOR_DEFAULT_VALUE = Expression.INSTANCE.constant(-872415232);
        private static final Expression<Long> ANIMATION_DURATION_DEFAULT_VALUE = Expression.INSTANCE.constant(300L);
        private static final Expression<AnimationType> ANIMATION_TYPE_DEFAULT_VALUE = Expression.INSTANCE.constant(AnimationType.SLIDE);
        private static final Expression<Long> FONT_SIZE_DEFAULT_VALUE = Expression.INSTANCE.constant(12L);
        private static final Expression<DivSizeUnit> FONT_SIZE_UNIT_DEFAULT_VALUE = Expression.INSTANCE.constant(DivSizeUnit.SP);
        private static final Expression<DivFontWeight> FONT_WEIGHT_DEFAULT_VALUE = Expression.INSTANCE.constant(DivFontWeight.REGULAR);
        private static final Expression<Integer> INACTIVE_TEXT_COLOR_DEFAULT_VALUE = Expression.INSTANCE.constant(Integer.MIN_VALUE);
        private static final Expression<Long> ITEM_SPACING_DEFAULT_VALUE = Expression.INSTANCE.constant(0L);
        private static final Expression<Double> LETTER_SPACING_DEFAULT_VALUE = Expression.INSTANCE.constant(Double.valueOf(0.0d));
        private static final DivEdgeInsets PADDINGS_DEFAULT_VALUE = new DivEdgeInsets(Expression.INSTANCE.constant(6L), null, Expression.INSTANCE.constant(8L), Expression.INSTANCE.constant(8L), null, Expression.INSTANCE.constant(6L), null, 82, null);
        private static final Function2<ParsingEnvironment, JSONObject, TabTitleStyle> CREATOR = new Function2<ParsingEnvironment, JSONObject, TabTitleStyle>() { // from class: com.yandex.div2.DivTabs$TabTitleStyle$Companion$CREATOR$1
            @Override // kotlin.jvm.functions.Function2
            public final DivTabs.TabTitleStyle invoke(ParsingEnvironment env, JSONObject it) {
                Intrinsics.checkNotNullParameter(env, "env");
                Intrinsics.checkNotNullParameter(it, "it");
                return DivTabs.TabTitleStyle.INSTANCE.fromJson(env, it);
            }
        };

        public TabTitleStyle() {
            this(null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, 262143, null);
        }

        @JvmStatic
        public static final TabTitleStyle fromJson(ParsingEnvironment parsingEnvironment, JSONObject jSONObject) {
            return INSTANCE.fromJson(parsingEnvironment, jSONObject);
        }

        public TabTitleStyle(Expression<Integer> activeBackgroundColor, Expression<DivFontWeight> expression, Expression<Integer> activeTextColor, Expression<Long> animationDuration, Expression<AnimationType> animationType, Expression<Long> expression2, DivCornersRadius divCornersRadius, Expression<String> expression3, Expression<Long> fontSize, Expression<DivSizeUnit> fontSizeUnit, Expression<DivFontWeight> fontWeight, Expression<Integer> expression4, Expression<DivFontWeight> expression5, Expression<Integer> inactiveTextColor, Expression<Long> itemSpacing, Expression<Double> letterSpacing, Expression<Long> expression6, DivEdgeInsets paddings) {
            Intrinsics.checkNotNullParameter(activeBackgroundColor, "activeBackgroundColor");
            Intrinsics.checkNotNullParameter(activeTextColor, "activeTextColor");
            Intrinsics.checkNotNullParameter(animationDuration, "animationDuration");
            Intrinsics.checkNotNullParameter(animationType, "animationType");
            Intrinsics.checkNotNullParameter(fontSize, "fontSize");
            Intrinsics.checkNotNullParameter(fontSizeUnit, "fontSizeUnit");
            Intrinsics.checkNotNullParameter(fontWeight, "fontWeight");
            Intrinsics.checkNotNullParameter(inactiveTextColor, "inactiveTextColor");
            Intrinsics.checkNotNullParameter(itemSpacing, "itemSpacing");
            Intrinsics.checkNotNullParameter(letterSpacing, "letterSpacing");
            Intrinsics.checkNotNullParameter(paddings, "paddings");
            this.activeBackgroundColor = activeBackgroundColor;
            this.activeFontWeight = expression;
            this.activeTextColor = activeTextColor;
            this.animationDuration = animationDuration;
            this.animationType = animationType;
            this.cornerRadius = expression2;
            this.cornersRadius = divCornersRadius;
            this.fontFamily = expression3;
            this.fontSize = fontSize;
            this.fontSizeUnit = fontSizeUnit;
            this.fontWeight = fontWeight;
            this.inactiveBackgroundColor = expression4;
            this.inactiveFontWeight = expression5;
            this.inactiveTextColor = inactiveTextColor;
            this.itemSpacing = itemSpacing;
            this.letterSpacing = letterSpacing;
            this.lineHeight = expression6;
            this.paddings = paddings;
        }

        public /* synthetic */ TabTitleStyle(Expression expression, Expression expression2, Expression expression3, Expression expression4, Expression expression5, Expression expression6, DivCornersRadius divCornersRadius, Expression expression7, Expression expression8, Expression expression9, Expression expression10, Expression expression11, Expression expression12, Expression expression13, Expression expression14, Expression expression15, Expression expression16, DivEdgeInsets divEdgeInsets, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this((i & 1) != 0 ? ACTIVE_BACKGROUND_COLOR_DEFAULT_VALUE : expression, (i & 2) != 0 ? null : expression2, (i & 4) != 0 ? ACTIVE_TEXT_COLOR_DEFAULT_VALUE : expression3, (i & 8) != 0 ? ANIMATION_DURATION_DEFAULT_VALUE : expression4, (i & 16) != 0 ? ANIMATION_TYPE_DEFAULT_VALUE : expression5, (i & 32) != 0 ? null : expression6, (i & 64) != 0 ? null : divCornersRadius, (i & 128) != 0 ? null : expression7, (i & 256) != 0 ? FONT_SIZE_DEFAULT_VALUE : expression8, (i & 512) != 0 ? FONT_SIZE_UNIT_DEFAULT_VALUE : expression9, (i & 1024) != 0 ? FONT_WEIGHT_DEFAULT_VALUE : expression10, (i & 2048) != 0 ? null : expression11, (i & 4096) != 0 ? null : expression12, (i & 8192) != 0 ? INACTIVE_TEXT_COLOR_DEFAULT_VALUE : expression13, (i & 16384) != 0 ? ITEM_SPACING_DEFAULT_VALUE : expression14, (i & 32768) != 0 ? LETTER_SPACING_DEFAULT_VALUE : expression15, (i & 65536) != 0 ? null : expression16, (i & 131072) != 0 ? PADDINGS_DEFAULT_VALUE : divEdgeInsets);
        }

        @Override // com.yandex.div.data.Hashable
        public int hash() {
            Integer num = this._hash;
            if (num != null) {
                return num.intValue();
            }
            int iHashCode = Reflection.getOrCreateKotlinClass(getClass()).hashCode() + this.activeBackgroundColor.hashCode();
            Expression<DivFontWeight> expression = this.activeFontWeight;
            int iHashCode2 = iHashCode + (expression != null ? expression.hashCode() : 0) + this.activeTextColor.hashCode() + this.animationDuration.hashCode() + this.animationType.hashCode();
            Expression<Long> expression2 = this.cornerRadius;
            int iHashCode3 = iHashCode2 + (expression2 != null ? expression2.hashCode() : 0);
            DivCornersRadius divCornersRadius = this.cornersRadius;
            int iHash = iHashCode3 + (divCornersRadius != null ? divCornersRadius.hash() : 0);
            Expression<String> expression3 = this.fontFamily;
            int iHashCode4 = iHash + (expression3 != null ? expression3.hashCode() : 0) + this.fontSize.hashCode() + this.fontSizeUnit.hashCode() + this.fontWeight.hashCode();
            Expression<Integer> expression4 = this.inactiveBackgroundColor;
            int iHashCode5 = iHashCode4 + (expression4 != null ? expression4.hashCode() : 0);
            Expression<DivFontWeight> expression5 = this.inactiveFontWeight;
            int iHashCode6 = iHashCode5 + (expression5 != null ? expression5.hashCode() : 0) + this.inactiveTextColor.hashCode() + this.itemSpacing.hashCode() + this.letterSpacing.hashCode();
            Expression<Long> expression6 = this.lineHeight;
            int iHashCode7 = iHashCode6 + (expression6 != null ? expression6.hashCode() : 0) + this.paddings.hash();
            this._hash = Integer.valueOf(iHashCode7);
            return iHashCode7;
        }

        public final boolean equals(TabTitleStyle other, ExpressionResolver resolver, ExpressionResolver otherResolver) {
            boolean zEquals;
            Intrinsics.checkNotNullParameter(resolver, "resolver");
            Intrinsics.checkNotNullParameter(otherResolver, "otherResolver");
            if (other == null || this.activeBackgroundColor.evaluate(resolver).intValue() != other.activeBackgroundColor.evaluate(otherResolver).intValue()) {
                return false;
            }
            Expression<DivFontWeight> expression = this.activeFontWeight;
            DivFontWeight divFontWeightEvaluate = expression != null ? expression.evaluate(resolver) : null;
            Expression<DivFontWeight> expression2 = other.activeFontWeight;
            if (divFontWeightEvaluate != (expression2 != null ? expression2.evaluate(otherResolver) : null) || this.activeTextColor.evaluate(resolver).intValue() != other.activeTextColor.evaluate(otherResolver).intValue() || this.animationDuration.evaluate(resolver).longValue() != other.animationDuration.evaluate(otherResolver).longValue() || this.animationType.evaluate(resolver) != other.animationType.evaluate(otherResolver)) {
                return false;
            }
            Expression<Long> expression3 = this.cornerRadius;
            Long lEvaluate = expression3 != null ? expression3.evaluate(resolver) : null;
            Expression<Long> expression4 = other.cornerRadius;
            if (!Intrinsics.areEqual(lEvaluate, expression4 != null ? expression4.evaluate(otherResolver) : null)) {
                return false;
            }
            DivCornersRadius divCornersRadius = this.cornersRadius;
            if (divCornersRadius != null) {
                zEquals = divCornersRadius.equals(other.cornersRadius, resolver, otherResolver);
            } else {
                zEquals = other.cornersRadius == null;
            }
            if (!zEquals) {
                return false;
            }
            Expression<String> expression5 = this.fontFamily;
            String strEvaluate = expression5 != null ? expression5.evaluate(resolver) : null;
            Expression<String> expression6 = other.fontFamily;
            if (!Intrinsics.areEqual(strEvaluate, expression6 != null ? expression6.evaluate(otherResolver) : null) || this.fontSize.evaluate(resolver).longValue() != other.fontSize.evaluate(otherResolver).longValue() || this.fontSizeUnit.evaluate(resolver) != other.fontSizeUnit.evaluate(otherResolver) || this.fontWeight.evaluate(resolver) != other.fontWeight.evaluate(otherResolver)) {
                return false;
            }
            Expression<Integer> expression7 = this.inactiveBackgroundColor;
            Integer numEvaluate = expression7 != null ? expression7.evaluate(resolver) : null;
            Expression<Integer> expression8 = other.inactiveBackgroundColor;
            if (!Intrinsics.areEqual(numEvaluate, expression8 != null ? expression8.evaluate(otherResolver) : null)) {
                return false;
            }
            Expression<DivFontWeight> expression9 = this.inactiveFontWeight;
            DivFontWeight divFontWeightEvaluate2 = expression9 != null ? expression9.evaluate(resolver) : null;
            Expression<DivFontWeight> expression10 = other.inactiveFontWeight;
            if (divFontWeightEvaluate2 != (expression10 != null ? expression10.evaluate(otherResolver) : null) || this.inactiveTextColor.evaluate(resolver).intValue() != other.inactiveTextColor.evaluate(otherResolver).intValue() || this.itemSpacing.evaluate(resolver).longValue() != other.itemSpacing.evaluate(otherResolver).longValue()) {
                return false;
            }
            if (!(this.letterSpacing.evaluate(resolver).doubleValue() == other.letterSpacing.evaluate(otherResolver).doubleValue())) {
                return false;
            }
            Expression<Long> expression11 = this.lineHeight;
            Long lEvaluate2 = expression11 != null ? expression11.evaluate(resolver) : null;
            Expression<Long> expression12 = other.lineHeight;
            return Intrinsics.areEqual(lEvaluate2, expression12 != null ? expression12.evaluate(otherResolver) : null) && this.paddings.equals(other.paddings, resolver, otherResolver);
        }

        public final TabTitleStyle copy(Expression<Integer> activeBackgroundColor, Expression<DivFontWeight> activeFontWeight, Expression<Integer> activeTextColor, Expression<Long> animationDuration, Expression<AnimationType> animationType, Expression<Long> cornerRadius, DivCornersRadius cornersRadius, Expression<String> fontFamily, Expression<Long> fontSize, Expression<DivSizeUnit> fontSizeUnit, Expression<DivFontWeight> fontWeight, Expression<Integer> inactiveBackgroundColor, Expression<DivFontWeight> inactiveFontWeight, Expression<Integer> inactiveTextColor, Expression<Long> itemSpacing, Expression<Double> letterSpacing, Expression<Long> lineHeight, DivEdgeInsets paddings) {
            Intrinsics.checkNotNullParameter(activeBackgroundColor, "activeBackgroundColor");
            Intrinsics.checkNotNullParameter(activeTextColor, "activeTextColor");
            Intrinsics.checkNotNullParameter(animationDuration, "animationDuration");
            Intrinsics.checkNotNullParameter(animationType, "animationType");
            Intrinsics.checkNotNullParameter(fontSize, "fontSize");
            Intrinsics.checkNotNullParameter(fontSizeUnit, "fontSizeUnit");
            Intrinsics.checkNotNullParameter(fontWeight, "fontWeight");
            Intrinsics.checkNotNullParameter(inactiveTextColor, "inactiveTextColor");
            Intrinsics.checkNotNullParameter(itemSpacing, "itemSpacing");
            Intrinsics.checkNotNullParameter(letterSpacing, "letterSpacing");
            Intrinsics.checkNotNullParameter(paddings, "paddings");
            return new TabTitleStyle(activeBackgroundColor, activeFontWeight, activeTextColor, animationDuration, animationType, cornerRadius, cornersRadius, fontFamily, fontSize, fontSizeUnit, fontWeight, inactiveBackgroundColor, inactiveFontWeight, inactiveTextColor, itemSpacing, letterSpacing, lineHeight, paddings);
        }

        @Override // com.yandex.div.json.JSONSerializable
        public JSONObject writeToJSON() {
            return BuiltInParserKt.getBuiltInParserComponent().getDivTabsTabTitleStyleJsonEntityParser().getValue().serialize(BuiltInParserKt.getBuiltInParsingContext(), this);
        }

        /* JADX INFO: compiled from: DivTabs.kt */
        @Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0006\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u001e\u0010\u001d\u001a\u00020\u000f2\u0006\u0010\u001e\u001a\u00020\r2\u0006\u0010\u001f\u001a\u00020\u000eH\u0087\u0002¢\u0006\u0002\b R\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\b0\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\t\u001a\b\u0012\u0004\u0012\u00020\n0\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R#\u0010\u000b\u001a\u0014\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u000f0\f¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0014\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\b0\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00140\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00160\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\b0\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u001a0\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u001cX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006!"}, d2 = {"Lcom/yandex/div2/DivTabs$TabTitleStyle$Companion;", "", "()V", "ACTIVE_BACKGROUND_COLOR_DEFAULT_VALUE", "Lcom/yandex/div/json/expressions/Expression;", "", "ACTIVE_TEXT_COLOR_DEFAULT_VALUE", "ANIMATION_DURATION_DEFAULT_VALUE", "", "ANIMATION_TYPE_DEFAULT_VALUE", "Lcom/yandex/div2/DivTabs$TabTitleStyle$AnimationType;", "CREATOR", "Lkotlin/Function2;", "Lcom/yandex/div/json/ParsingEnvironment;", "Lorg/json/JSONObject;", "Lcom/yandex/div2/DivTabs$TabTitleStyle;", "getCREATOR", "()Lkotlin/jvm/functions/Function2;", "FONT_SIZE_DEFAULT_VALUE", "FONT_SIZE_UNIT_DEFAULT_VALUE", "Lcom/yandex/div2/DivSizeUnit;", "FONT_WEIGHT_DEFAULT_VALUE", "Lcom/yandex/div2/DivFontWeight;", "INACTIVE_TEXT_COLOR_DEFAULT_VALUE", "ITEM_SPACING_DEFAULT_VALUE", "LETTER_SPACING_DEFAULT_VALUE", "", "PADDINGS_DEFAULT_VALUE", "Lcom/yandex/div2/DivEdgeInsets;", "invoke", cc.o, "json", "fromJson", "div-data_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private Companion() {
            }

            @JvmStatic
            public final TabTitleStyle fromJson(ParsingEnvironment env, JSONObject json) {
                Intrinsics.checkNotNullParameter(env, "env");
                Intrinsics.checkNotNullParameter(json, "json");
                return BuiltInParserKt.getBuiltInParserComponent().getDivTabsTabTitleStyleJsonEntityParser().getValue().deserialize((ParsingContext) env, json);
            }

            public final Function2<ParsingEnvironment, JSONObject, TabTitleStyle> getCREATOR() {
                return TabTitleStyle.CREATOR;
            }
        }

        /* JADX INFO: compiled from: DivTabs.kt */
        @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\b\u0086\u0001\u0018\u0000 \b2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\bB\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007¨\u0006\t"}, d2 = {"Lcom/yandex/div2/DivTabs$TabTitleStyle$AnimationType;", "", "value", "", "(Ljava/lang/String;ILjava/lang/String;)V", "SLIDE", "FADE", "NONE", "Converter", "div-data_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
        public enum AnimationType {
            SLIDE("slide"),
            FADE("fade"),
            NONE("none");

            private final String value;

            /* JADX INFO: renamed from: Converter, reason: from kotlin metadata */
            public static final Companion INSTANCE = new Companion(null);
            public static final Function1<AnimationType, String> TO_STRING = new Function1<AnimationType, String>() { // from class: com.yandex.div2.DivTabs$TabTitleStyle$AnimationType$Converter$TO_STRING$1
                @Override // kotlin.jvm.functions.Function1
                public final String invoke(DivTabs.TabTitleStyle.AnimationType value) {
                    Intrinsics.checkNotNullParameter(value, "value");
                    return DivTabs.TabTitleStyle.AnimationType.INSTANCE.toString(value);
                }
            };
            public static final Function1<String, AnimationType> FROM_STRING = new Function1<String, AnimationType>() { // from class: com.yandex.div2.DivTabs$TabTitleStyle$AnimationType$Converter$FROM_STRING$1
                @Override // kotlin.jvm.functions.Function1
                public final DivTabs.TabTitleStyle.AnimationType invoke(String value) {
                    Intrinsics.checkNotNullParameter(value, "value");
                    return DivTabs.TabTitleStyle.AnimationType.INSTANCE.fromString(value);
                }
            };

            AnimationType(String str) {
                this.value = str;
            }

            /* JADX INFO: renamed from: com.yandex.div2.DivTabs$TabTitleStyle$AnimationType$Converter, reason: from kotlin metadata */
            /* JADX INFO: compiled from: DivTabs.kt */
            @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\b\u001a\u0004\u0018\u00010\u00062\u0006\u0010\t\u001a\u00020\u0005J\u000e\u0010\n\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\u0006R\u001e\u0010\u0003\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u00048\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00050\u00048\u0006X\u0087\u0004¢\u0006\u0002\n\u0000¨\u0006\f"}, d2 = {"Lcom/yandex/div2/DivTabs$TabTitleStyle$AnimationType$Converter;", "", "()V", "FROM_STRING", "Lkotlin/Function1;", "", "Lcom/yandex/div2/DivTabs$TabTitleStyle$AnimationType;", "TO_STRING", "fromString", "value", "toString", "obj", "div-data_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
            public static final class Companion {
                public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                    this();
                }

                private Companion() {
                }

                public final String toString(AnimationType obj) {
                    Intrinsics.checkNotNullParameter(obj, "obj");
                    return obj.value;
                }

                public final AnimationType fromString(String value) {
                    Intrinsics.checkNotNullParameter(value, "value");
                    if (Intrinsics.areEqual(value, AnimationType.SLIDE.value)) {
                        return AnimationType.SLIDE;
                    }
                    if (Intrinsics.areEqual(value, AnimationType.FADE.value)) {
                        return AnimationType.FADE;
                    }
                    if (Intrinsics.areEqual(value, AnimationType.NONE.value)) {
                        return AnimationType.NONE;
                    }
                    return null;
                }
            }
        }
    }

    /* JADX INFO: compiled from: DivTabs.kt */
    @Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \u00172\u00020\u00012\u00020\u0002:\u0001\u0017B)\b\u0007\u0012\b\b\u0002\u0010\u0003\u001a\u00020\u0004\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006\u0012\b\b\u0002\u0010\b\u001a\u00020\u0004¢\u0006\u0002\u0010\tJ*\u0010\r\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00042\u000e\b\u0002\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\b\b\u0002\u0010\b\u001a\u00020\u0004J \u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u00002\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0012J\b\u0010\u0014\u001a\u00020\u000bH\u0016J\b\u0010\u0015\u001a\u00020\u0016H\u0016R\u0012\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0004\n\u0002\u0010\fR\u0010\u0010\u0003\u001a\u00020\u00048\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u00068\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u00020\u00048\u0006X\u0087\u0004¢\u0006\u0002\n\u0000¨\u0006\u0018"}, d2 = {"Lcom/yandex/div2/DivTabs$TabTitleDelimiter;", "Lcom/yandex/div/json/JSONSerializable;", "Lcom/yandex/div/data/Hashable;", "height", "Lcom/yandex/div2/DivFixedSize;", UnifiedMediationParams.KEY_IMAGE_URL, "Lcom/yandex/div/json/expressions/Expression;", "Landroid/net/Uri;", "width", "(Lcom/yandex/div2/DivFixedSize;Lcom/yandex/div/json/expressions/Expression;Lcom/yandex/div2/DivFixedSize;)V", "_hash", "", "Ljava/lang/Integer;", "copy", "equals", "", "other", "resolver", "Lcom/yandex/div/json/expressions/ExpressionResolver;", "otherResolver", "hash", "writeToJSON", "Lorg/json/JSONObject;", "Companion", "div-data_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class TabTitleDelimiter implements JSONSerializable, Hashable {
        private static final DivFixedSize HEIGHT_DEFAULT_VALUE;
        private static final DivFixedSize WIDTH_DEFAULT_VALUE;
        private Integer _hash;
        public final DivFixedSize height;
        public final Expression<Uri> imageUrl;
        public final DivFixedSize width;

        /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
        public static final Companion INSTANCE = new Companion(null);
        private static final Function2<ParsingEnvironment, JSONObject, TabTitleDelimiter> CREATOR = new Function2<ParsingEnvironment, JSONObject, TabTitleDelimiter>() { // from class: com.yandex.div2.DivTabs$TabTitleDelimiter$Companion$CREATOR$1
            @Override // kotlin.jvm.functions.Function2
            public final DivTabs.TabTitleDelimiter invoke(ParsingEnvironment env, JSONObject it) {
                Intrinsics.checkNotNullParameter(env, "env");
                Intrinsics.checkNotNullParameter(it, "it");
                return DivTabs.TabTitleDelimiter.INSTANCE.fromJson(env, it);
            }
        };

        @JvmStatic
        public static final TabTitleDelimiter fromJson(ParsingEnvironment parsingEnvironment, JSONObject jSONObject) {
            return INSTANCE.fromJson(parsingEnvironment, jSONObject);
        }

        public TabTitleDelimiter(DivFixedSize height, Expression<Uri> imageUrl, DivFixedSize width) {
            Intrinsics.checkNotNullParameter(height, "height");
            Intrinsics.checkNotNullParameter(imageUrl, "imageUrl");
            Intrinsics.checkNotNullParameter(width, "width");
            this.height = height;
            this.imageUrl = imageUrl;
            this.width = width;
        }

        public /* synthetic */ TabTitleDelimiter(DivFixedSize divFixedSize, Expression expression, DivFixedSize divFixedSize2, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this((i & 1) != 0 ? HEIGHT_DEFAULT_VALUE : divFixedSize, expression, (i & 4) != 0 ? WIDTH_DEFAULT_VALUE : divFixedSize2);
        }

        @Override // com.yandex.div.data.Hashable
        public int hash() {
            Integer num = this._hash;
            if (num != null) {
                return num.intValue();
            }
            int iHashCode = Reflection.getOrCreateKotlinClass(getClass()).hashCode() + this.height.hash() + this.imageUrl.hashCode() + this.width.hash();
            this._hash = Integer.valueOf(iHashCode);
            return iHashCode;
        }

        public final boolean equals(TabTitleDelimiter other, ExpressionResolver resolver, ExpressionResolver otherResolver) {
            Intrinsics.checkNotNullParameter(resolver, "resolver");
            Intrinsics.checkNotNullParameter(otherResolver, "otherResolver");
            return other != null && this.height.equals(other.height, resolver, otherResolver) && Intrinsics.areEqual(this.imageUrl.evaluate(resolver), other.imageUrl.evaluate(otherResolver)) && this.width.equals(other.width, resolver, otherResolver);
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ TabTitleDelimiter copy$default(TabTitleDelimiter tabTitleDelimiter, DivFixedSize divFixedSize, Expression expression, DivFixedSize divFixedSize2, int i, Object obj) {
            if ((i & 1) != 0) {
                divFixedSize = tabTitleDelimiter.height;
            }
            if ((i & 2) != 0) {
                expression = tabTitleDelimiter.imageUrl;
            }
            if ((i & 4) != 0) {
                divFixedSize2 = tabTitleDelimiter.width;
            }
            return tabTitleDelimiter.copy(divFixedSize, expression, divFixedSize2);
        }

        public final TabTitleDelimiter copy(DivFixedSize height, Expression<Uri> imageUrl, DivFixedSize width) {
            Intrinsics.checkNotNullParameter(height, "height");
            Intrinsics.checkNotNullParameter(imageUrl, "imageUrl");
            Intrinsics.checkNotNullParameter(width, "width");
            return new TabTitleDelimiter(height, imageUrl, width);
        }

        @Override // com.yandex.div.json.JSONSerializable
        public JSONObject writeToJSON() {
            return BuiltInParserKt.getBuiltInParserComponent().getDivTabsTabTitleDelimiterJsonEntityParser().getValue().serialize(BuiltInParserKt.getBuiltInParsingContext(), this);
        }

        /* JADX INFO: compiled from: DivTabs.kt */
        @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u001e\u0010\r\u001a\u00020\u00072\u0006\u0010\u000e\u001a\u00020\u00052\u0006\u0010\u000f\u001a\u00020\u0006H\u0087\u0002¢\u0006\u0002\b\u0010R#\u0010\u0003\u001a\u0014\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0011"}, d2 = {"Lcom/yandex/div2/DivTabs$TabTitleDelimiter$Companion;", "", "()V", "CREATOR", "Lkotlin/Function2;", "Lcom/yandex/div/json/ParsingEnvironment;", "Lorg/json/JSONObject;", "Lcom/yandex/div2/DivTabs$TabTitleDelimiter;", "getCREATOR", "()Lkotlin/jvm/functions/Function2;", "HEIGHT_DEFAULT_VALUE", "Lcom/yandex/div2/DivFixedSize;", "WIDTH_DEFAULT_VALUE", "invoke", cc.o, "json", "fromJson", "div-data_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private Companion() {
            }

            @JvmStatic
            public final TabTitleDelimiter fromJson(ParsingEnvironment env, JSONObject json) {
                Intrinsics.checkNotNullParameter(env, "env");
                Intrinsics.checkNotNullParameter(json, "json");
                return BuiltInParserKt.getBuiltInParserComponent().getDivTabsTabTitleDelimiterJsonEntityParser().getValue().deserialize((ParsingContext) env, json);
            }

            public final Function2<ParsingEnvironment, JSONObject, TabTitleDelimiter> getCREATOR() {
                return TabTitleDelimiter.CREATOR;
            }
        }

        static {
            int i = 1;
            HEIGHT_DEFAULT_VALUE = new DivFixedSize(0 == true ? 1 : 0, Expression.INSTANCE.constant(12L), i, 0 == true ? 1 : 0);
            WIDTH_DEFAULT_VALUE = new DivFixedSize(0 == true ? 1 : 0, Expression.INSTANCE.constant(12L), i, 0 == true ? 1 : 0);
        }
    }

    /* JADX INFO: compiled from: DivTabs.kt */
    @Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \u00182\u00020\u00012\u00020\u0002:\u0001\u0018B)\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\u0002\u0010\nJ,\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00042\u000e\b\u0002\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\tJ \u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u00002\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0013J\b\u0010\u0015\u001a\u00020\fH\u0016J\b\u0010\u0016\u001a\u00020\u0017H\u0016R\u0012\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0082\u000e¢\u0006\u0004\n\u0002\u0010\rR\u0010\u0010\u0003\u001a\u00020\u00048\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u00068\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0012\u0010\b\u001a\u0004\u0018\u00010\t8\u0006X\u0087\u0004¢\u0006\u0002\n\u0000¨\u0006\u0019"}, d2 = {"Lcom/yandex/div2/DivTabs$Item;", "Lcom/yandex/div/json/JSONSerializable;", "Lcom/yandex/div/data/Hashable;", "div", "Lcom/yandex/div2/Div;", "title", "Lcom/yandex/div/json/expressions/Expression;", "", "titleClickAction", "Lcom/yandex/div2/DivAction;", "(Lcom/yandex/div2/Div;Lcom/yandex/div/json/expressions/Expression;Lcom/yandex/div2/DivAction;)V", "_hash", "", "Ljava/lang/Integer;", "copy", "equals", "", "other", "resolver", "Lcom/yandex/div/json/expressions/ExpressionResolver;", "otherResolver", "hash", "writeToJSON", "Lorg/json/JSONObject;", "Companion", "div-data_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class Item implements JSONSerializable, Hashable {
        private Integer _hash;
        public final Div div;
        public final Expression<String> title;
        public final DivAction titleClickAction;

        /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
        public static final Companion INSTANCE = new Companion(null);
        private static final Function2<ParsingEnvironment, JSONObject, Item> CREATOR = new Function2<ParsingEnvironment, JSONObject, Item>() { // from class: com.yandex.div2.DivTabs$Item$Companion$CREATOR$1
            @Override // kotlin.jvm.functions.Function2
            public final DivTabs.Item invoke(ParsingEnvironment env, JSONObject it) {
                Intrinsics.checkNotNullParameter(env, "env");
                Intrinsics.checkNotNullParameter(it, "it");
                return DivTabs.Item.INSTANCE.fromJson(env, it);
            }
        };

        @JvmStatic
        public static final Item fromJson(ParsingEnvironment parsingEnvironment, JSONObject jSONObject) {
            return INSTANCE.fromJson(parsingEnvironment, jSONObject);
        }

        public Item(Div div, Expression<String> title, DivAction divAction) {
            Intrinsics.checkNotNullParameter(div, "div");
            Intrinsics.checkNotNullParameter(title, "title");
            this.div = div;
            this.title = title;
            this.titleClickAction = divAction;
        }

        public /* synthetic */ Item(Div div, Expression expression, DivAction divAction, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this(div, expression, (i & 4) != 0 ? null : divAction);
        }

        @Override // com.yandex.div.data.Hashable
        public int hash() {
            Integer num = this._hash;
            if (num != null) {
                return num.intValue();
            }
            int iHashCode = Reflection.getOrCreateKotlinClass(getClass()).hashCode() + this.div.hash() + this.title.hashCode();
            DivAction divAction = this.titleClickAction;
            int iHash = iHashCode + (divAction != null ? divAction.hash() : 0);
            this._hash = Integer.valueOf(iHash);
            return iHash;
        }

        public final boolean equals(Item other, ExpressionResolver resolver, ExpressionResolver otherResolver) {
            boolean zEquals;
            Intrinsics.checkNotNullParameter(resolver, "resolver");
            Intrinsics.checkNotNullParameter(otherResolver, "otherResolver");
            if (other == null || !this.div.equals(other.div, resolver, otherResolver) || !Intrinsics.areEqual(this.title.evaluate(resolver), other.title.evaluate(otherResolver))) {
                return false;
            }
            DivAction divAction = this.titleClickAction;
            DivAction divAction2 = other.titleClickAction;
            if (divAction != null) {
                zEquals = divAction.equals(divAction2, resolver, otherResolver);
            } else {
                zEquals = divAction2 == null;
            }
            return zEquals;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ Item copy$default(Item item, Div div, Expression expression, DivAction divAction, int i, Object obj) {
            if ((i & 1) != 0) {
                div = item.div;
            }
            if ((i & 2) != 0) {
                expression = item.title;
            }
            if ((i & 4) != 0) {
                divAction = item.titleClickAction;
            }
            return item.copy(div, expression, divAction);
        }

        public final Item copy(Div div, Expression<String> title, DivAction titleClickAction) {
            Intrinsics.checkNotNullParameter(div, "div");
            Intrinsics.checkNotNullParameter(title, "title");
            return new Item(div, title, titleClickAction);
        }

        @Override // com.yandex.div.json.JSONSerializable
        public JSONObject writeToJSON() {
            return BuiltInParserKt.getBuiltInParserComponent().getDivTabsItemJsonEntityParser().getValue().serialize(BuiltInParserKt.getBuiltInParsingContext(), this);
        }

        /* JADX INFO: compiled from: DivTabs.kt */
        @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u001e\u0010\n\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\u00052\u0006\u0010\f\u001a\u00020\u0006H\u0087\u0002¢\u0006\u0002\b\rR#\u0010\u0003\u001a\u0014\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\t¨\u0006\u000e"}, d2 = {"Lcom/yandex/div2/DivTabs$Item$Companion;", "", "()V", "CREATOR", "Lkotlin/Function2;", "Lcom/yandex/div/json/ParsingEnvironment;", "Lorg/json/JSONObject;", "Lcom/yandex/div2/DivTabs$Item;", "getCREATOR", "()Lkotlin/jvm/functions/Function2;", "invoke", cc.o, "json", "fromJson", "div-data_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private Companion() {
            }

            @JvmStatic
            public final Item fromJson(ParsingEnvironment env, JSONObject json) {
                Intrinsics.checkNotNullParameter(env, "env");
                Intrinsics.checkNotNullParameter(json, "json");
                return BuiltInParserKt.getBuiltInParserComponent().getDivTabsItemJsonEntityParser().getValue().deserialize((ParsingContext) env, json);
            }

            public final Function2<ParsingEnvironment, JSONObject, Item> getCREATOR() {
                return Item.CREATOR;
            }
        }
    }
}
