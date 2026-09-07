package com.yandex.div2;

import android.net.Uri;
import androidx.compose.material.OutlinedTextFieldKt;
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

/* JADX INFO: compiled from: DivGifImage.kt */
/* JADX INFO: loaded from: classes10.dex */
@Metadata(d1 = {"\u0000þ\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0006\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b6\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \u0090\u00012\u00020\u00012\u00020\u00022\u00020\u0003:\u0002\u0090\u0001Bû\u0005\b\u0007\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\t\u0012\u0010\b\u0002\u0010\n\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u000b\u0012\u0010\b\u0002\u0010\f\u001a\n\u0012\u0004\u0012\u00020\u000e\u0018\u00010\r\u0012\u0010\b\u0002\u0010\u000f\u001a\n\u0012\u0004\u0012\u00020\u0010\u0018\u00010\r\u0012\u000e\b\u0002\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00120\r\u0012\u0010\b\u0002\u0010\u0013\u001a\n\u0012\u0004\u0012\u00020\u0014\u0018\u00010\u000b\u0012\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u0016\u0012\u0010\b\u0002\u0010\u0017\u001a\n\u0012\u0004\u0012\u00020\u0018\u0018\u00010\u000b\u0012\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u001a\u0012\u0010\b\u0002\u0010\u001b\u001a\n\u0012\u0004\u0012\u00020\u001c\u0018\u00010\r\u0012\u000e\b\u0002\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u000e0\r\u0012\u000e\b\u0002\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u00100\r\u0012\u0010\b\u0002\u0010\u001f\u001a\n\u0012\u0004\u0012\u00020 \u0018\u00010\u000b\u0012\u0010\b\u0002\u0010!\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u000b\u0012\u0010\b\u0002\u0010\"\u001a\n\u0012\u0004\u0012\u00020#\u0018\u00010\u000b\u0012\n\b\u0002\u0010$\u001a\u0004\u0018\u00010%\u0012\u0010\b\u0002\u0010&\u001a\n\u0012\u0004\u0012\u00020'\u0018\u00010\u000b\u0012\f\u0010(\u001a\b\u0012\u0004\u0012\u00020)0\r\u0012\b\b\u0002\u0010*\u001a\u00020+\u0012\u0010\b\u0002\u0010,\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u000b\u0012\u0010\b\u0002\u0010-\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u000b\u0012\n\b\u0002\u0010.\u001a\u0004\u0018\u00010/\u0012\n\b\u0002\u00100\u001a\u0004\u0018\u000101\u0012\u0010\b\u0002\u00102\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u000b\u0012\n\b\u0002\u00103\u001a\u0004\u0018\u000104\u0012\n\b\u0002\u00105\u001a\u0004\u0018\u000104\u0012\u000e\b\u0002\u00106\u001a\b\u0012\u0004\u0012\u0002070\r\u0012\u000e\b\u0002\u00108\u001a\b\u0012\u0004\u0012\u0002090\r\u0012\u0010\b\u0002\u0010:\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u000b\u0012\u0010\b\u0002\u0010;\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u000b\u0012\u0010\b\u0002\u0010<\u001a\n\u0012\u0004\u0012\u00020/\u0018\u00010\r\u0012\u0010\b\u0002\u0010=\u001a\n\u0012\u0004\u0012\u00020/\u0018\u00010\r\u0012\u0010\b\u0002\u0010>\u001a\n\u0012\u0004\u0012\u00020\u001c\u0018\u00010\r\u0012\u000e\b\u0002\u0010?\u001a\b\u0012\u0004\u0012\u00020@0\r\u0012\u0010\b\u0002\u0010A\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u000b\u0012\u0010\b\u0002\u0010B\u001a\n\u0012\u0004\u0012\u00020C\u0018\u00010\u000b\u0012\n\b\u0002\u0010D\u001a\u0004\u0018\u00010E\u0012\n\b\u0002\u0010F\u001a\u0004\u0018\u00010G\u0012\n\b\u0002\u0010H\u001a\u0004\u0018\u00010I\u0012\n\b\u0002\u0010J\u001a\u0004\u0018\u00010I\u0012\u0010\b\u0002\u0010K\u001a\n\u0012\u0004\u0012\u00020L\u0018\u00010\u000b\u0012\u0010\b\u0002\u0010M\u001a\n\u0012\u0004\u0012\u00020N\u0018\u00010\u000b\u0012\u0010\b\u0002\u0010O\u001a\n\u0012\u0004\u0012\u00020P\u0018\u00010\u000b\u0012\u000e\b\u0002\u0010Q\u001a\b\u0012\u0004\u0012\u00020R0\r\u0012\n\b\u0002\u0010S\u001a\u0004\u0018\u00010T\u0012\u0010\b\u0002\u0010U\u001a\n\u0012\u0004\u0012\u00020T\u0018\u00010\u000b\u0012\b\b\u0002\u0010V\u001a\u00020+¢\u0006\u0002\u0010WJý\u0005\u0010\u0087\u0001\u001a\u00020\u00002\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\u0010\b\u0002\u0010\n\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u000b2\u0010\b\u0002\u0010\f\u001a\n\u0012\u0004\u0012\u00020\u000e\u0018\u00010\r2\u0010\b\u0002\u0010\u000f\u001a\n\u0012\u0004\u0012\u00020\u0010\u0018\u00010\r2\u000e\b\u0002\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00120\r2\u0010\b\u0002\u0010\u0013\u001a\n\u0012\u0004\u0012\u00020\u0014\u0018\u00010\u000b2\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u00162\u0010\b\u0002\u0010\u0017\u001a\n\u0012\u0004\u0012\u00020\u0018\u0018\u00010\u000b2\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u001a2\u0010\b\u0002\u0010\u001b\u001a\n\u0012\u0004\u0012\u00020\u001c\u0018\u00010\r2\u000e\b\u0002\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u000e0\r2\u000e\b\u0002\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u00100\r2\u0010\b\u0002\u0010\u001f\u001a\n\u0012\u0004\u0012\u00020 \u0018\u00010\u000b2\u0010\b\u0002\u0010!\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u000b2\u0010\b\u0002\u0010\"\u001a\n\u0012\u0004\u0012\u00020#\u0018\u00010\u000b2\n\b\u0002\u0010$\u001a\u0004\u0018\u00010%2\u0010\b\u0002\u0010&\u001a\n\u0012\u0004\u0012\u00020'\u0018\u00010\u000b2\u000e\b\u0002\u0010(\u001a\b\u0012\u0004\u0012\u00020)0\r2\b\b\u0002\u0010*\u001a\u00020+2\u0010\b\u0002\u0010,\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u000b2\u0010\b\u0002\u0010-\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u000b2\n\b\u0002\u0010.\u001a\u0004\u0018\u00010/2\n\b\u0002\u00100\u001a\u0004\u0018\u0001012\u0010\b\u0002\u00102\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u000b2\n\b\u0002\u00103\u001a\u0004\u0018\u0001042\n\b\u0002\u00105\u001a\u0004\u0018\u0001042\u000e\b\u0002\u00106\u001a\b\u0012\u0004\u0012\u0002070\r2\u000e\b\u0002\u00108\u001a\b\u0012\u0004\u0012\u0002090\r2\u0010\b\u0002\u0010:\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u000b2\u0010\b\u0002\u0010;\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u000b2\u0010\b\u0002\u0010<\u001a\n\u0012\u0004\u0012\u00020/\u0018\u00010\r2\u0010\b\u0002\u0010=\u001a\n\u0012\u0004\u0012\u00020/\u0018\u00010\r2\u0010\b\u0002\u0010>\u001a\n\u0012\u0004\u0012\u00020\u001c\u0018\u00010\r2\u000e\b\u0002\u0010?\u001a\b\u0012\u0004\u0012\u00020@0\r2\u0010\b\u0002\u0010A\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u000b2\u0010\b\u0002\u0010B\u001a\n\u0012\u0004\u0012\u00020C\u0018\u00010\u000b2\n\b\u0002\u0010D\u001a\u0004\u0018\u00010E2\n\b\u0002\u0010F\u001a\u0004\u0018\u00010G2\n\b\u0002\u0010H\u001a\u0004\u0018\u00010I2\n\b\u0002\u0010J\u001a\u0004\u0018\u00010I2\u0010\b\u0002\u0010K\u001a\n\u0012\u0004\u0012\u00020L\u0018\u00010\u000b2\u0010\b\u0002\u0010M\u001a\n\u0012\u0004\u0012\u00020N\u0018\u00010\u000b2\u0010\b\u0002\u0010O\u001a\n\u0012\u0004\u0012\u00020P\u0018\u00010\u000b2\u000e\b\u0002\u0010Q\u001a\b\u0012\u0004\u0012\u00020R0\r2\n\b\u0002\u0010S\u001a\u0004\u0018\u00010T2\u0010\b\u0002\u0010U\u001a\n\u0012\u0004\u0012\u00020T\u0018\u00010\u000b2\b\b\u0002\u0010V\u001a\u00020+J&\u0010\u0088\u0001\u001a\u0002092\t\u0010\u0089\u0001\u001a\u0004\u0018\u00010\u00002\b\u0010\u008a\u0001\u001a\u00030\u008b\u00012\b\u0010\u008c\u0001\u001a\u00030\u008b\u0001J\t\u0010\u008d\u0001\u001a\u000207H\u0016J\n\u0010\u008e\u0001\u001a\u00030\u008f\u0001H\u0016R\u0012\u0010X\u001a\u0004\u0018\u000107X\u0082\u000e¢\u0006\u0004\n\u0002\u0010YR\u0016\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\bZ\u0010[R\u0012\u0010\u0006\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u00020\t8\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0018\u0010\n\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u000b8\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\f\u001a\n\u0012\u0004\u0012\u00020\u000e\u0018\u00010\rX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\\\u0010]R\u001c\u0010\u000f\u001a\n\u0012\u0004\u0012\u00020\u0010\u0018\u00010\rX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b^\u0010]R\u001a\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00120\rX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b_\u0010]R\u001c\u0010\u0013\u001a\n\u0012\u0004\u0012\u00020\u0014\u0018\u00010\u000bX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b`\u0010aR\u0012\u0010\u0015\u001a\u0004\u0018\u00010\u00168\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\u0017\u001a\n\u0012\u0004\u0012\u00020\u0018\u0018\u00010\u000bX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\bb\u0010aR\u0016\u0010\u0019\u001a\u0004\u0018\u00010\u001aX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\bc\u0010dR\u001c\u0010\u001b\u001a\n\u0012\u0004\u0012\u00020\u001c\u0018\u00010\rX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\be\u0010]R\u0016\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u000e0\r8\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u00100\r8\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\u001f\u001a\n\u0012\u0004\u0012\u00020 \u0018\u00010\u000bX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\bf\u0010aR\u0018\u0010!\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u000b8\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\"\u001a\n\u0012\u0004\u0012\u00020#\u0018\u00010\u000bX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\bg\u0010aR\u0016\u0010$\u001a\u0004\u0018\u00010%X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\bh\u0010iR\u001c\u0010&\u001a\n\u0012\u0004\u0012\u00020'\u0018\u00010\u000bX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\bj\u0010aR\u0016\u0010(\u001a\b\u0012\u0004\u0012\u00020)0\r8\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0014\u0010*\u001a\u00020+X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\bk\u0010lR\u0018\u0010,\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u000b8\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0018\u0010-\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u000b8\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0016\u0010.\u001a\u0004\u0018\u00010/X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\bm\u0010nR\u0016\u00100\u001a\u0004\u0018\u000101X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\bo\u0010pR\u0018\u00102\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u000b8\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0016\u00103\u001a\u0004\u0018\u000104X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\bq\u0010rR\u0016\u00105\u001a\u0004\u0018\u000104X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\bs\u0010rR\u0016\u00106\u001a\b\u0012\u0004\u0012\u0002070\r8\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0016\u00108\u001a\b\u0012\u0004\u0012\u0002090\r8\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0018\u0010:\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u000b8\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0018\u0010;\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u000b8\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0018\u0010<\u001a\n\u0012\u0004\u0012\u00020/\u0018\u00010\r8\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u001c\u0010=\u001a\n\u0012\u0004\u0012\u00020/\u0018\u00010\rX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\bt\u0010]R\u001c\u0010>\u001a\n\u0012\u0004\u0012\u00020\u001c\u0018\u00010\rX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\bu\u0010]R\u0016\u0010?\u001a\b\u0012\u0004\u0012\u00020@0\r8\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u001c\u0010A\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u000bX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\bv\u0010aR\u001c\u0010B\u001a\n\u0012\u0004\u0012\u00020C\u0018\u00010\u000bX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\bw\u0010aR\u0016\u0010D\u001a\u0004\u0018\u00010EX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\bx\u0010yR\u0016\u0010F\u001a\u0004\u0018\u00010GX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\bz\u0010{R\u0016\u0010H\u001a\u0004\u0018\u00010IX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b|\u0010}R\u0016\u0010J\u001a\u0004\u0018\u00010IX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b~\u0010}R\u001c\u0010K\u001a\n\u0012\u0004\u0012\u00020L\u0018\u00010\u000bX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u007f\u0010aR\u001d\u0010M\u001a\n\u0012\u0004\u0012\u00020N\u0018\u00010\u000bX\u0096\u0004¢\u0006\t\n\u0000\u001a\u0005\b\u0080\u0001\u0010aR\u001d\u0010O\u001a\n\u0012\u0004\u0012\u00020P\u0018\u00010\u000bX\u0096\u0004¢\u0006\t\n\u0000\u001a\u0005\b\u0081\u0001\u0010aR\u001b\u0010Q\u001a\b\u0012\u0004\u0012\u00020R0\rX\u0096\u0004¢\u0006\t\n\u0000\u001a\u0005\b\u0082\u0001\u0010]R\u0018\u0010S\u001a\u0004\u0018\u00010TX\u0096\u0004¢\u0006\n\n\u0000\u001a\u0006\b\u0083\u0001\u0010\u0084\u0001R\u001d\u0010U\u001a\n\u0012\u0004\u0012\u00020T\u0018\u00010\u000bX\u0096\u0004¢\u0006\t\n\u0000\u001a\u0005\b\u0085\u0001\u0010aR\u0015\u0010V\u001a\u00020+X\u0096\u0004¢\u0006\t\n\u0000\u001a\u0005\b\u0086\u0001\u0010l¨\u0006\u0091\u0001"}, d2 = {"Lcom/yandex/div2/DivGifImage;", "Lcom/yandex/div/json/JSONSerializable;", "Lcom/yandex/div/data/Hashable;", "Lcom/yandex/div2/DivBase;", "accessibility", "Lcom/yandex/div2/DivAccessibility;", "action", "Lcom/yandex/div2/DivAction;", "actionAnimation", "Lcom/yandex/div2/DivAnimation;", "actions", "", "alignmentHorizontal", "Lcom/yandex/div/json/expressions/Expression;", "Lcom/yandex/div2/DivAlignmentHorizontal;", "alignmentVertical", "Lcom/yandex/div2/DivAlignmentVertical;", "alpha", "", "animators", "Lcom/yandex/div2/DivAnimator;", "aspect", "Lcom/yandex/div2/DivAspect;", J2.g, "Lcom/yandex/div2/DivBackground;", OutlinedTextFieldKt.BorderId, "Lcom/yandex/div2/DivBorder;", "columnSpan", "", "contentAlignmentHorizontal", "contentAlignmentVertical", "disappearActions", "Lcom/yandex/div2/DivDisappearAction;", "doubletapActions", "extensions", "Lcom/yandex/div2/DivExtension;", "focus", "Lcom/yandex/div2/DivFocus;", "functions", "Lcom/yandex/div2/DivFunction;", "gifUrl", "Landroid/net/Uri;", "height", "Lcom/yandex/div2/DivSize;", "hoverEndActions", "hoverStartActions", "id", "", "layoutProvider", "Lcom/yandex/div2/DivLayoutProvider;", "longtapActions", "margins", "Lcom/yandex/div2/DivEdgeInsets;", "paddings", "placeholderColor", "", "preloadRequired", "", "pressEndActions", "pressStartActions", "preview", "reuseId", "rowSpan", "scale", "Lcom/yandex/div2/DivImageScale;", "selectedActions", "tooltips", "Lcom/yandex/div2/DivTooltip;", "transform", "Lcom/yandex/div2/DivTransform;", "transitionChange", "Lcom/yandex/div2/DivChangeTransition;", "transitionIn", "Lcom/yandex/div2/DivAppearanceTransition;", "transitionOut", "transitionTriggers", "Lcom/yandex/div2/DivTransitionTrigger;", "variableTriggers", "Lcom/yandex/div2/DivTrigger;", "variables", "Lcom/yandex/div2/DivVariable;", "visibility", "Lcom/yandex/div2/DivVisibility;", "visibilityAction", "Lcom/yandex/div2/DivVisibilityAction;", "visibilityActions", "width", "(Lcom/yandex/div2/DivAccessibility;Lcom/yandex/div2/DivAction;Lcom/yandex/div2/DivAnimation;Ljava/util/List;Lcom/yandex/div/json/expressions/Expression;Lcom/yandex/div/json/expressions/Expression;Lcom/yandex/div/json/expressions/Expression;Ljava/util/List;Lcom/yandex/div2/DivAspect;Ljava/util/List;Lcom/yandex/div2/DivBorder;Lcom/yandex/div/json/expressions/Expression;Lcom/yandex/div/json/expressions/Expression;Lcom/yandex/div/json/expressions/Expression;Ljava/util/List;Ljava/util/List;Ljava/util/List;Lcom/yandex/div2/DivFocus;Ljava/util/List;Lcom/yandex/div/json/expressions/Expression;Lcom/yandex/div2/DivSize;Ljava/util/List;Ljava/util/List;Ljava/lang/String;Lcom/yandex/div2/DivLayoutProvider;Ljava/util/List;Lcom/yandex/div2/DivEdgeInsets;Lcom/yandex/div2/DivEdgeInsets;Lcom/yandex/div/json/expressions/Expression;Lcom/yandex/div/json/expressions/Expression;Ljava/util/List;Ljava/util/List;Lcom/yandex/div/json/expressions/Expression;Lcom/yandex/div/json/expressions/Expression;Lcom/yandex/div/json/expressions/Expression;Lcom/yandex/div/json/expressions/Expression;Ljava/util/List;Ljava/util/List;Lcom/yandex/div2/DivTransform;Lcom/yandex/div2/DivChangeTransition;Lcom/yandex/div2/DivAppearanceTransition;Lcom/yandex/div2/DivAppearanceTransition;Ljava/util/List;Ljava/util/List;Ljava/util/List;Lcom/yandex/div/json/expressions/Expression;Lcom/yandex/div2/DivVisibilityAction;Ljava/util/List;Lcom/yandex/div2/DivSize;)V", "_hash", "Ljava/lang/Integer;", "getAccessibility", "()Lcom/yandex/div2/DivAccessibility;", "getAlignmentHorizontal", "()Lcom/yandex/div/json/expressions/Expression;", "getAlignmentVertical", "getAlpha", "getAnimators", "()Ljava/util/List;", "getBackground", "getBorder", "()Lcom/yandex/div2/DivBorder;", "getColumnSpan", "getDisappearActions", "getExtensions", "getFocus", "()Lcom/yandex/div2/DivFocus;", "getFunctions", "getHeight", "()Lcom/yandex/div2/DivSize;", "getId", "()Ljava/lang/String;", "getLayoutProvider", "()Lcom/yandex/div2/DivLayoutProvider;", "getMargins", "()Lcom/yandex/div2/DivEdgeInsets;", "getPaddings", "getReuseId", "getRowSpan", "getSelectedActions", "getTooltips", "getTransform", "()Lcom/yandex/div2/DivTransform;", "getTransitionChange", "()Lcom/yandex/div2/DivChangeTransition;", "getTransitionIn", "()Lcom/yandex/div2/DivAppearanceTransition;", "getTransitionOut", "getTransitionTriggers", "getVariableTriggers", "getVariables", "getVisibility", "getVisibilityAction", "()Lcom/yandex/div2/DivVisibilityAction;", "getVisibilityActions", "getWidth", "copy", "equals", "other", "resolver", "Lcom/yandex/div/json/expressions/ExpressionResolver;", "otherResolver", "hash", "writeToJSON", "Lorg/json/JSONObject;", "Companion", "div-data_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class DivGifImage implements JSONSerializable, Hashable, DivBase {
    private static final DivAnimation ACTION_ANIMATION_DEFAULT_VALUE;
    private static final Expression<Double> ALPHA_DEFAULT_VALUE;
    private static final Expression<DivAlignmentHorizontal> CONTENT_ALIGNMENT_HORIZONTAL_DEFAULT_VALUE;
    private static final Expression<DivAlignmentVertical> CONTENT_ALIGNMENT_VERTICAL_DEFAULT_VALUE;
    private static final Function2<ParsingEnvironment, JSONObject, DivGifImage> CREATOR;

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final DivSize.WrapContent HEIGHT_DEFAULT_VALUE;
    private static final Expression<Integer> PLACEHOLDER_COLOR_DEFAULT_VALUE;
    private static final Expression<Boolean> PRELOAD_REQUIRED_DEFAULT_VALUE;
    private static final Expression<DivImageScale> SCALE_DEFAULT_VALUE;
    public static final String TYPE = "gif";
    private static final Expression<DivVisibility> VISIBILITY_DEFAULT_VALUE;
    private static final DivSize.MatchParent WIDTH_DEFAULT_VALUE;
    private Integer _hash;
    private final DivAccessibility accessibility;
    public final DivAction action;
    public final DivAnimation actionAnimation;
    public final List<DivAction> actions;
    private final Expression<DivAlignmentHorizontal> alignmentHorizontal;
    private final Expression<DivAlignmentVertical> alignmentVertical;
    private final Expression<Double> alpha;
    private final List<DivAnimator> animators;
    public final DivAspect aspect;
    private final List<DivBackground> background;
    private final DivBorder border;
    private final Expression<Long> columnSpan;
    public final Expression<DivAlignmentHorizontal> contentAlignmentHorizontal;
    public final Expression<DivAlignmentVertical> contentAlignmentVertical;
    private final List<DivDisappearAction> disappearActions;
    public final List<DivAction> doubletapActions;
    private final List<DivExtension> extensions;
    private final DivFocus focus;
    private final List<DivFunction> functions;
    public final Expression<Uri> gifUrl;
    private final DivSize height;
    public final List<DivAction> hoverEndActions;
    public final List<DivAction> hoverStartActions;
    private final String id;
    private final DivLayoutProvider layoutProvider;
    public final List<DivAction> longtapActions;
    private final DivEdgeInsets margins;
    private final DivEdgeInsets paddings;
    public final Expression<Integer> placeholderColor;
    public final Expression<Boolean> preloadRequired;
    public final List<DivAction> pressEndActions;
    public final List<DivAction> pressStartActions;
    public final Expression<String> preview;
    private final Expression<String> reuseId;
    private final Expression<Long> rowSpan;
    public final Expression<DivImageScale> scale;
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
    public static final DivGifImage fromJson(ParsingEnvironment parsingEnvironment, JSONObject jSONObject) {
        return INSTANCE.fromJson(parsingEnvironment, jSONObject);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public DivGifImage(DivAccessibility divAccessibility, DivAction divAction, DivAnimation actionAnimation, List<DivAction> list, Expression<DivAlignmentHorizontal> expression, Expression<DivAlignmentVertical> expression2, Expression<Double> alpha, List<? extends DivAnimator> list2, DivAspect divAspect, List<? extends DivBackground> list3, DivBorder divBorder, Expression<Long> expression3, Expression<DivAlignmentHorizontal> contentAlignmentHorizontal, Expression<DivAlignmentVertical> contentAlignmentVertical, List<DivDisappearAction> list4, List<DivAction> list5, List<DivExtension> list6, DivFocus divFocus, List<DivFunction> list7, Expression<Uri> gifUrl, DivSize height, List<DivAction> list8, List<DivAction> list9, String str, DivLayoutProvider divLayoutProvider, List<DivAction> list10, DivEdgeInsets divEdgeInsets, DivEdgeInsets divEdgeInsets2, Expression<Integer> placeholderColor, Expression<Boolean> preloadRequired, List<DivAction> list11, List<DivAction> list12, Expression<String> expression4, Expression<String> expression5, Expression<Long> expression6, Expression<DivImageScale> scale, List<DivAction> list13, List<DivTooltip> list14, DivTransform divTransform, DivChangeTransition divChangeTransition, DivAppearanceTransition divAppearanceTransition, DivAppearanceTransition divAppearanceTransition2, List<? extends DivTransitionTrigger> list15, List<DivTrigger> list16, List<? extends DivVariable> list17, Expression<DivVisibility> visibility, DivVisibilityAction divVisibilityAction, List<DivVisibilityAction> list18, DivSize width) {
        Intrinsics.checkNotNullParameter(actionAnimation, "actionAnimation");
        Intrinsics.checkNotNullParameter(alpha, "alpha");
        Intrinsics.checkNotNullParameter(contentAlignmentHorizontal, "contentAlignmentHorizontal");
        Intrinsics.checkNotNullParameter(contentAlignmentVertical, "contentAlignmentVertical");
        Intrinsics.checkNotNullParameter(gifUrl, "gifUrl");
        Intrinsics.checkNotNullParameter(height, "height");
        Intrinsics.checkNotNullParameter(placeholderColor, "placeholderColor");
        Intrinsics.checkNotNullParameter(preloadRequired, "preloadRequired");
        Intrinsics.checkNotNullParameter(scale, "scale");
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
        this.aspect = divAspect;
        this.background = list3;
        this.border = divBorder;
        this.columnSpan = expression3;
        this.contentAlignmentHorizontal = contentAlignmentHorizontal;
        this.contentAlignmentVertical = contentAlignmentVertical;
        this.disappearActions = list4;
        this.doubletapActions = list5;
        this.extensions = list6;
        this.focus = divFocus;
        this.functions = list7;
        this.gifUrl = gifUrl;
        this.height = height;
        this.hoverEndActions = list8;
        this.hoverStartActions = list9;
        this.id = str;
        this.layoutProvider = divLayoutProvider;
        this.longtapActions = list10;
        this.margins = divEdgeInsets;
        this.paddings = divEdgeInsets2;
        this.placeholderColor = placeholderColor;
        this.preloadRequired = preloadRequired;
        this.pressEndActions = list11;
        this.pressStartActions = list12;
        this.preview = expression4;
        this.reuseId = expression5;
        this.rowSpan = expression6;
        this.scale = scale;
        this.selectedActions = list13;
        this.tooltips = list14;
        this.transform = divTransform;
        this.transitionChange = divChangeTransition;
        this.transitionIn = divAppearanceTransition;
        this.transitionOut = divAppearanceTransition2;
        this.transitionTriggers = list15;
        this.variableTriggers = list16;
        this.variables = list17;
        this.visibility = visibility;
        this.visibilityAction = divVisibilityAction;
        this.visibilityActions = list18;
        this.width = width;
    }

    @Override // com.yandex.div2.DivBase
    public DivAccessibility getAccessibility() {
        return this.accessibility;
    }

    public /* synthetic */ DivGifImage(DivAccessibility divAccessibility, DivAction divAction, DivAnimation divAnimation, List list, Expression expression, Expression expression2, Expression expression3, List list2, DivAspect divAspect, List list3, DivBorder divBorder, Expression expression4, Expression expression5, Expression expression6, List list4, List list5, List list6, DivFocus divFocus, List list7, Expression expression7, DivSize divSize, List list8, List list9, String str, DivLayoutProvider divLayoutProvider, List list10, DivEdgeInsets divEdgeInsets, DivEdgeInsets divEdgeInsets2, Expression expression8, Expression expression9, List list11, List list12, Expression expression10, Expression expression11, Expression expression12, Expression expression13, List list13, List list14, DivTransform divTransform, DivChangeTransition divChangeTransition, DivAppearanceTransition divAppearanceTransition, DivAppearanceTransition divAppearanceTransition2, List list15, List list16, List list17, Expression expression14, DivVisibilityAction divVisibilityAction, List list18, DivSize divSize2, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : divAccessibility, (i & 2) != 0 ? null : divAction, (i & 4) != 0 ? ACTION_ANIMATION_DEFAULT_VALUE : divAnimation, (i & 8) != 0 ? null : list, (i & 16) != 0 ? null : expression, (i & 32) != 0 ? null : expression2, (i & 64) != 0 ? ALPHA_DEFAULT_VALUE : expression3, (i & 128) != 0 ? null : list2, (i & 256) != 0 ? null : divAspect, (i & 512) != 0 ? null : list3, (i & 1024) != 0 ? null : divBorder, (i & 2048) != 0 ? null : expression4, (i & 4096) != 0 ? CONTENT_ALIGNMENT_HORIZONTAL_DEFAULT_VALUE : expression5, (i & 8192) != 0 ? CONTENT_ALIGNMENT_VERTICAL_DEFAULT_VALUE : expression6, (i & 16384) != 0 ? null : list4, (i & 32768) != 0 ? null : list5, (i & 65536) != 0 ? null : list6, (i & 131072) != 0 ? null : divFocus, (i & 262144) != 0 ? null : list7, expression7, (i & 1048576) != 0 ? HEIGHT_DEFAULT_VALUE : divSize, (i & 2097152) != 0 ? null : list8, (i & 4194304) != 0 ? null : list9, (i & 8388608) != 0 ? null : str, (i & 16777216) != 0 ? null : divLayoutProvider, (i & 33554432) != 0 ? null : list10, (i & 67108864) != 0 ? null : divEdgeInsets, (i & 134217728) != 0 ? null : divEdgeInsets2, (i & 268435456) != 0 ? PLACEHOLDER_COLOR_DEFAULT_VALUE : expression8, (i & 536870912) != 0 ? PRELOAD_REQUIRED_DEFAULT_VALUE : expression9, (i & 1073741824) != 0 ? null : list11, (i & Integer.MIN_VALUE) != 0 ? null : list12, (i2 & 1) != 0 ? null : expression10, (i2 & 2) != 0 ? null : expression11, (i2 & 4) != 0 ? null : expression12, (i2 & 8) != 0 ? SCALE_DEFAULT_VALUE : expression13, (i2 & 16) != 0 ? null : list13, (i2 & 32) != 0 ? null : list14, (i2 & 64) != 0 ? null : divTransform, (i2 & 128) != 0 ? null : divChangeTransition, (i2 & 256) != 0 ? null : divAppearanceTransition, (i2 & 512) != 0 ? null : divAppearanceTransition2, (i2 & 1024) != 0 ? null : list15, (i2 & 2048) != 0 ? null : list16, (i2 & 4096) != 0 ? null : list17, (i2 & 8192) != 0 ? VISIBILITY_DEFAULT_VALUE : expression14, (i2 & 16384) != 0 ? null : divVisibilityAction, (i2 & 32768) != 0 ? null : list18, (i2 & 65536) != 0 ? WIDTH_DEFAULT_VALUE : divSize2);
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
        int iHash10;
        int iHash11;
        int iHash12;
        int iHash13;
        int iHash14;
        int iHash15;
        int iHash16;
        Integer num = this._hash;
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
        DivAspect divAspect = this.aspect;
        int iHash20 = i2 + (divAspect != null ? divAspect.hash() : 0);
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
        int i3 = iHash20 + iHash3;
        DivBorder border = getBorder();
        int iHash21 = i3 + (border != null ? border.hash() : 0);
        Expression<Long> columnSpan = getColumnSpan();
        int iHashCode4 = iHash21 + (columnSpan != null ? columnSpan.hashCode() : 0) + this.contentAlignmentHorizontal.hashCode() + this.contentAlignmentVertical.hashCode();
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
        int iHash22 = i6 + (focus != null ? focus.hash() : 0);
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
        int iHashCode5 = iHash22 + iHash7 + this.gifUrl.hashCode() + getHeight().hash();
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
        int i7 = iHashCode5 + iHash8;
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
        int iHashCode6 = i8 + (id != null ? id.hashCode() : 0);
        DivLayoutProvider layoutProvider = getLayoutProvider();
        int iHash23 = iHashCode6 + (layoutProvider != null ? layoutProvider.hash() : 0);
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
        int iHash25 = iHash24 + (paddings != null ? paddings.hash() : 0) + this.placeholderColor.hashCode() + this.preloadRequired.hashCode();
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
        Expression<String> expression = this.preview;
        int iHashCode7 = i11 + (expression != null ? expression.hashCode() : 0);
        Expression<String> reuseId = getReuseId();
        int iHashCode8 = iHashCode7 + (reuseId != null ? reuseId.hashCode() : 0);
        Expression<Long> rowSpan = getRowSpan();
        int iHashCode9 = iHashCode8 + (rowSpan != null ? rowSpan.hashCode() : 0) + this.scale.hashCode();
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
        int i12 = iHashCode9 + iHash13;
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
        int iHashCode10 = iHash29 + (transitionTriggers != null ? transitionTriggers.hashCode() : 0);
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
        int i14 = iHashCode10 + iHash15;
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
        int iHashCode11 = i14 + iHash16 + getVisibility().hashCode();
        DivVisibilityAction visibilityAction = getVisibilityAction();
        int iHash30 = iHashCode11 + (visibilityAction != null ? visibilityAction.hash() : 0);
        List<DivVisibilityAction> visibilityActions = getVisibilityActions();
        if (visibilityActions != null) {
            Iterator<T> it17 = visibilityActions.iterator();
            while (it17.hasNext()) {
                iHash17 += ((DivVisibilityAction) it17.next()).hash();
            }
        }
        int iHash31 = iHash30 + iHash17 + getWidth().hash();
        this._hash = Integer.valueOf(iHash31);
        return iHash31;
    }

    public final boolean equals(DivGifImage other, ExpressionResolver resolver, ExpressionResolver otherResolver) {
        boolean zEquals;
        boolean zEquals2;
        boolean z;
        boolean z2;
        boolean zEquals3;
        boolean z3;
        boolean zEquals4;
        boolean z4;
        boolean z5;
        boolean z6;
        boolean zEquals5;
        boolean z7;
        boolean z8;
        boolean z9;
        boolean zEquals6;
        boolean z10;
        boolean zEquals7;
        boolean zEquals8;
        boolean z11;
        boolean z12;
        boolean z13;
        boolean z14;
        boolean zEquals9;
        boolean zEquals10;
        boolean zEquals11;
        boolean zEquals12;
        boolean z15;
        boolean z16;
        boolean z17;
        boolean zEquals13;
        boolean z18;
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
        DivAspect divAspect = this.aspect;
        if (divAspect != null) {
            zEquals3 = divAspect.equals(other.aspect, resolver, otherResolver);
        } else {
            zEquals3 = other.aspect == null;
        }
        if (!zEquals3) {
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
            zEquals4 = border.equals(other.getBorder(), resolver, otherResolver);
        } else {
            zEquals4 = other.getBorder() == null;
        }
        if (!zEquals4) {
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
            zEquals5 = focus.equals(other.getFocus(), resolver, otherResolver);
        } else {
            zEquals5 = other.getFocus() == null;
        }
        if (!zEquals5) {
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
        if (!z7 || !Intrinsics.areEqual(this.gifUrl.evaluate(resolver), other.gifUrl.evaluate(otherResolver)) || !getHeight().equals(other.getHeight(), resolver, otherResolver)) {
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
        DivLayoutProvider layoutProvider = getLayoutProvider();
        if (layoutProvider != null) {
            zEquals6 = layoutProvider.equals(other.getLayoutProvider(), resolver, otherResolver);
        } else {
            zEquals6 = other.getLayoutProvider() == null;
        }
        if (!zEquals6) {
            return false;
        }
        List<DivAction> list9 = this.longtapActions;
        if (list9 != null) {
            List<DivAction> list10 = other.longtapActions;
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
            z10 = other.longtapActions == null;
        }
        if (!z10) {
            return false;
        }
        DivEdgeInsets margins = getMargins();
        if (margins != null) {
            zEquals7 = margins.equals(other.getMargins(), resolver, otherResolver);
        } else {
            zEquals7 = other.getMargins() == null;
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
        if (!zEquals8 || this.placeholderColor.evaluate(resolver).intValue() != other.placeholderColor.evaluate(otherResolver).intValue() || this.preloadRequired.evaluate(resolver).booleanValue() != other.preloadRequired.evaluate(otherResolver).booleanValue()) {
            return false;
        }
        List<DivAction> list11 = this.pressEndActions;
        if (list11 != null) {
            List<DivAction> list12 = other.pressEndActions;
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
            z11 = other.pressEndActions == null;
        }
        if (!z11) {
            return false;
        }
        List<DivAction> list13 = this.pressStartActions;
        if (list13 != null) {
            List<DivAction> list14 = other.pressStartActions;
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
            z12 = other.pressStartActions == null;
        }
        if (!z12) {
            return false;
        }
        Expression<String> expression = this.preview;
        String strEvaluate = expression != null ? expression.evaluate(resolver) : null;
        Expression<String> expression2 = other.preview;
        if (!Intrinsics.areEqual(strEvaluate, expression2 != null ? expression2.evaluate(otherResolver) : null)) {
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
                Iterator<T> it13 = selectedActions.iterator();
                int i25 = 0;
                while (true) {
                    if (it13.hasNext()) {
                        Object next13 = it13.next();
                        int i26 = i25 + 1;
                        if (i25 < 0) {
                            CollectionsKt.throwIndexOverflow();
                        }
                        if (((DivAction) next13).equals(selectedActions2.get(i25), resolver, otherResolver)) {
                            i25 = i26;
                        }
                    }
                }
            }
        } else {
            z13 = other.getSelectedActions() == null;
        }
        if (!z13) {
            return false;
        }
        List<DivTooltip> tooltips = getTooltips();
        if (tooltips != null) {
            List<DivTooltip> tooltips2 = other.getTooltips();
            if (tooltips2 == null) {
                return false;
            }
            if (tooltips.size() == tooltips2.size()) {
                Iterator<T> it14 = tooltips.iterator();
                int i27 = 0;
                while (true) {
                    if (it14.hasNext()) {
                        Object next14 = it14.next();
                        int i28 = i27 + 1;
                        if (i27 < 0) {
                            CollectionsKt.throwIndexOverflow();
                        }
                        if (((DivTooltip) next14).equals(tooltips2.get(i27), resolver, otherResolver)) {
                            i27 = i28;
                        }
                    }
                }
            }
        } else {
            z14 = other.getTooltips() == null;
        }
        if (!z14) {
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
                Iterator<T> it15 = transitionTriggers.iterator();
                int i29 = 0;
                while (true) {
                    if (it15.hasNext()) {
                        Object next15 = it15.next();
                        int i30 = i29 + 1;
                        if (i29 < 0) {
                            CollectionsKt.throwIndexOverflow();
                        }
                        if (((DivTransitionTrigger) next15) == transitionTriggers2.get(i29)) {
                            i29 = i30;
                        }
                    }
                }
            }
        } else {
            z15 = other.getTransitionTriggers() == null;
        }
        if (!z15) {
            return false;
        }
        List<DivTrigger> variableTriggers = getVariableTriggers();
        if (variableTriggers != null) {
            List<DivTrigger> variableTriggers2 = other.getVariableTriggers();
            if (variableTriggers2 == null) {
                return false;
            }
            if (variableTriggers.size() == variableTriggers2.size()) {
                Iterator<T> it16 = variableTriggers.iterator();
                int i31 = 0;
                while (true) {
                    if (it16.hasNext()) {
                        Object next16 = it16.next();
                        int i32 = i31 + 1;
                        if (i31 < 0) {
                            CollectionsKt.throwIndexOverflow();
                        }
                        if (((DivTrigger) next16).equals(variableTriggers2.get(i31), resolver, otherResolver)) {
                            i31 = i32;
                        }
                    }
                }
            }
        } else {
            z16 = other.getVariableTriggers() == null;
        }
        if (!z16) {
            return false;
        }
        List<DivVariable> variables = getVariables();
        if (variables != null) {
            List<DivVariable> variables2 = other.getVariables();
            if (variables2 == null) {
                return false;
            }
            if (variables.size() == variables2.size()) {
                Iterator<T> it17 = variables.iterator();
                int i33 = 0;
                while (true) {
                    if (it17.hasNext()) {
                        Object next17 = it17.next();
                        int i34 = i33 + 1;
                        if (i33 < 0) {
                            CollectionsKt.throwIndexOverflow();
                        }
                        if (((DivVariable) next17).equals(variables2.get(i33), resolver, otherResolver)) {
                            i33 = i34;
                        }
                    }
                }
            }
        } else {
            z17 = other.getVariables() == null;
        }
        if (!z17 || getVisibility().evaluate(resolver) != other.getVisibility().evaluate(otherResolver)) {
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
                Iterator<T> it18 = visibilityActions.iterator();
                int i35 = 0;
                while (true) {
                    if (it18.hasNext()) {
                        Object next18 = it18.next();
                        int i36 = i35 + 1;
                        if (i35 < 0) {
                            CollectionsKt.throwIndexOverflow();
                        }
                        if (((DivVisibilityAction) next18).equals(visibilityActions2.get(i35), resolver, otherResolver)) {
                            i35 = i36;
                        }
                    }
                }
            }
        } else {
            z18 = other.getVisibilityActions() == null;
        }
        return z18 && getWidth().equals(other.getWidth(), resolver, otherResolver);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ DivGifImage copy$default(DivGifImage divGifImage, DivAccessibility divAccessibility, DivAction divAction, DivAnimation divAnimation, List list, Expression expression, Expression expression2, Expression expression3, List list2, DivAspect divAspect, List list3, DivBorder divBorder, Expression expression4, Expression expression5, Expression expression6, List list4, List list5, List list6, DivFocus divFocus, List list7, Expression expression7, DivSize divSize, List list8, List list9, String str, DivLayoutProvider divLayoutProvider, List list10, DivEdgeInsets divEdgeInsets, DivEdgeInsets divEdgeInsets2, Expression expression8, Expression expression9, List list11, List list12, Expression expression10, Expression expression11, Expression expression12, Expression expression13, List list13, List list14, DivTransform divTransform, DivChangeTransition divChangeTransition, DivAppearanceTransition divAppearanceTransition, DivAppearanceTransition divAppearanceTransition2, List list15, List list16, List list17, Expression expression14, DivVisibilityAction divVisibilityAction, List list18, DivSize divSize2, int i, int i2, Object obj) {
        DivAccessibility accessibility = (i & 1) != 0 ? divGifImage.getAccessibility() : divAccessibility;
        DivAction divAction2 = (i & 2) != 0 ? divGifImage.action : divAction;
        DivAnimation divAnimation2 = (i & 4) != 0 ? divGifImage.actionAnimation : divAnimation;
        List list19 = (i & 8) != 0 ? divGifImage.actions : list;
        Expression alignmentHorizontal = (i & 16) != 0 ? divGifImage.getAlignmentHorizontal() : expression;
        Expression alignmentVertical = (i & 32) != 0 ? divGifImage.getAlignmentVertical() : expression2;
        Expression alpha = (i & 64) != 0 ? divGifImage.getAlpha() : expression3;
        List animators = (i & 128) != 0 ? divGifImage.getAnimators() : list2;
        DivAspect divAspect2 = (i & 256) != 0 ? divGifImage.aspect : divAspect;
        List background = (i & 512) != 0 ? divGifImage.getBackground() : list3;
        DivBorder border = (i & 1024) != 0 ? divGifImage.getBorder() : divBorder;
        Expression columnSpan = (i & 2048) != 0 ? divGifImage.getColumnSpan() : expression4;
        Expression expression15 = (i & 4096) != 0 ? divGifImage.contentAlignmentHorizontal : expression5;
        Expression expression16 = (i & 8192) != 0 ? divGifImage.contentAlignmentVertical : expression6;
        List disappearActions = (i & 16384) != 0 ? divGifImage.getDisappearActions() : list4;
        List list20 = (i & 32768) != 0 ? divGifImage.doubletapActions : list5;
        List extensions = (i & 65536) != 0 ? divGifImage.getExtensions() : list6;
        DivFocus focus = (i & 131072) != 0 ? divGifImage.getFocus() : divFocus;
        List functions = (i & 262144) != 0 ? divGifImage.getFunctions() : list7;
        List list21 = list20;
        Expression expression17 = (i & 524288) != 0 ? divGifImage.gifUrl : expression7;
        DivSize height = (i & 1048576) != 0 ? divGifImage.getHeight() : divSize;
        Expression expression18 = expression17;
        List list22 = (i & 2097152) != 0 ? divGifImage.hoverEndActions : list8;
        List list23 = (i & 4194304) != 0 ? divGifImage.hoverStartActions : list9;
        String id = (i & 8388608) != 0 ? divGifImage.getId() : str;
        DivLayoutProvider layoutProvider = (i & 16777216) != 0 ? divGifImage.getLayoutProvider() : divLayoutProvider;
        List list24 = list23;
        List list25 = (i & 33554432) != 0 ? divGifImage.longtapActions : list10;
        return divGifImage.copy(accessibility, divAction2, divAnimation2, list19, alignmentHorizontal, alignmentVertical, alpha, animators, divAspect2, background, border, columnSpan, expression15, expression16, disappearActions, list21, extensions, focus, functions, expression18, height, list22, list24, id, layoutProvider, list25, (i & 67108864) != 0 ? divGifImage.getMargins() : divEdgeInsets, (i & 134217728) != 0 ? divGifImage.getPaddings() : divEdgeInsets2, (i & 268435456) != 0 ? divGifImage.placeholderColor : expression8, (i & 536870912) != 0 ? divGifImage.preloadRequired : expression9, (i & 1073741824) != 0 ? divGifImage.pressEndActions : list11, (i & Integer.MIN_VALUE) != 0 ? divGifImage.pressStartActions : list12, (i2 & 1) != 0 ? divGifImage.preview : expression10, (i2 & 2) != 0 ? divGifImage.getReuseId() : expression11, (i2 & 4) != 0 ? divGifImage.getRowSpan() : expression12, (i2 & 8) != 0 ? divGifImage.scale : expression13, (i2 & 16) != 0 ? divGifImage.getSelectedActions() : list13, (i2 & 32) != 0 ? divGifImage.getTooltips() : list14, (i2 & 64) != 0 ? divGifImage.getTransform() : divTransform, (i2 & 128) != 0 ? divGifImage.getTransitionChange() : divChangeTransition, (i2 & 256) != 0 ? divGifImage.getTransitionIn() : divAppearanceTransition, (i2 & 512) != 0 ? divGifImage.getTransitionOut() : divAppearanceTransition2, (i2 & 1024) != 0 ? divGifImage.getTransitionTriggers() : list15, (i2 & 2048) != 0 ? divGifImage.getVariableTriggers() : list16, (i2 & 4096) != 0 ? divGifImage.getVariables() : list17, (i2 & 8192) != 0 ? divGifImage.getVisibility() : expression14, (i2 & 16384) != 0 ? divGifImage.getVisibilityAction() : divVisibilityAction, (i2 & 32768) != 0 ? divGifImage.getVisibilityActions() : list18, (i2 & 65536) != 0 ? divGifImage.getWidth() : divSize2);
    }

    public final DivGifImage copy(DivAccessibility accessibility, DivAction action, DivAnimation actionAnimation, List<DivAction> actions, Expression<DivAlignmentHorizontal> alignmentHorizontal, Expression<DivAlignmentVertical> alignmentVertical, Expression<Double> alpha, List<? extends DivAnimator> animators, DivAspect aspect, List<? extends DivBackground> background, DivBorder border, Expression<Long> columnSpan, Expression<DivAlignmentHorizontal> contentAlignmentHorizontal, Expression<DivAlignmentVertical> contentAlignmentVertical, List<DivDisappearAction> disappearActions, List<DivAction> doubletapActions, List<DivExtension> extensions, DivFocus focus, List<DivFunction> functions, Expression<Uri> gifUrl, DivSize height, List<DivAction> hoverEndActions, List<DivAction> hoverStartActions, String id, DivLayoutProvider layoutProvider, List<DivAction> longtapActions, DivEdgeInsets margins, DivEdgeInsets paddings, Expression<Integer> placeholderColor, Expression<Boolean> preloadRequired, List<DivAction> pressEndActions, List<DivAction> pressStartActions, Expression<String> preview, Expression<String> reuseId, Expression<Long> rowSpan, Expression<DivImageScale> scale, List<DivAction> selectedActions, List<DivTooltip> tooltips, DivTransform transform, DivChangeTransition transitionChange, DivAppearanceTransition transitionIn, DivAppearanceTransition transitionOut, List<? extends DivTransitionTrigger> transitionTriggers, List<DivTrigger> variableTriggers, List<? extends DivVariable> variables, Expression<DivVisibility> visibility, DivVisibilityAction visibilityAction, List<DivVisibilityAction> visibilityActions, DivSize width) {
        Intrinsics.checkNotNullParameter(actionAnimation, "actionAnimation");
        Intrinsics.checkNotNullParameter(alpha, "alpha");
        Intrinsics.checkNotNullParameter(contentAlignmentHorizontal, "contentAlignmentHorizontal");
        Intrinsics.checkNotNullParameter(contentAlignmentVertical, "contentAlignmentVertical");
        Intrinsics.checkNotNullParameter(gifUrl, "gifUrl");
        Intrinsics.checkNotNullParameter(height, "height");
        Intrinsics.checkNotNullParameter(placeholderColor, "placeholderColor");
        Intrinsics.checkNotNullParameter(preloadRequired, "preloadRequired");
        Intrinsics.checkNotNullParameter(scale, "scale");
        Intrinsics.checkNotNullParameter(visibility, "visibility");
        Intrinsics.checkNotNullParameter(width, "width");
        return new DivGifImage(accessibility, action, actionAnimation, actions, alignmentHorizontal, alignmentVertical, alpha, animators, aspect, background, border, columnSpan, contentAlignmentHorizontal, contentAlignmentVertical, disappearActions, doubletapActions, extensions, focus, functions, gifUrl, height, hoverEndActions, hoverStartActions, id, layoutProvider, longtapActions, margins, paddings, placeholderColor, preloadRequired, pressEndActions, pressStartActions, preview, reuseId, rowSpan, scale, selectedActions, tooltips, transform, transitionChange, transitionIn, transitionOut, transitionTriggers, variableTriggers, variables, visibility, visibilityAction, visibilityActions, width);
    }

    @Override // com.yandex.div.json.JSONSerializable
    public JSONObject writeToJSON() {
        return BuiltInParserKt.getBuiltInParserComponent().getDivGifImageJsonEntityParser().getValue().serialize(BuiltInParserKt.getBuiltInParsingContext(), this);
    }

    /* JADX INFO: compiled from: DivGifImage.kt */
    @Metadata(d1 = {"\u0000h\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0006\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u001e\u0010!\u001a\u00020\u00102\u0006\u0010\"\u001a\u00020\u000e2\u0006\u0010#\u001a\u00020\u000fH\u0087\u0002¢\u0006\u0002\b$R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\b\u001a\b\u0012\u0004\u0012\u00020\t0\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u000b0\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R#\u0010\f\u001a\u0014\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u00100\r¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u000e\u0010\u0013\u001a\u00020\u0014X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00160\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00180\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u001a0\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u001cX\u0086T¢\u0006\u0002\n\u0000R\u0014\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u001e0\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001f\u001a\u00020 X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006%"}, d2 = {"Lcom/yandex/div2/DivGifImage$Companion;", "", "()V", "ACTION_ANIMATION_DEFAULT_VALUE", "Lcom/yandex/div2/DivAnimation;", "ALPHA_DEFAULT_VALUE", "Lcom/yandex/div/json/expressions/Expression;", "", "CONTENT_ALIGNMENT_HORIZONTAL_DEFAULT_VALUE", "Lcom/yandex/div2/DivAlignmentHorizontal;", "CONTENT_ALIGNMENT_VERTICAL_DEFAULT_VALUE", "Lcom/yandex/div2/DivAlignmentVertical;", "CREATOR", "Lkotlin/Function2;", "Lcom/yandex/div/json/ParsingEnvironment;", "Lorg/json/JSONObject;", "Lcom/yandex/div2/DivGifImage;", "getCREATOR", "()Lkotlin/jvm/functions/Function2;", "HEIGHT_DEFAULT_VALUE", "Lcom/yandex/div2/DivSize$WrapContent;", "PLACEHOLDER_COLOR_DEFAULT_VALUE", "", "PRELOAD_REQUIRED_DEFAULT_VALUE", "", "SCALE_DEFAULT_VALUE", "Lcom/yandex/div2/DivImageScale;", "TYPE", "", "VISIBILITY_DEFAULT_VALUE", "Lcom/yandex/div2/DivVisibility;", "WIDTH_DEFAULT_VALUE", "Lcom/yandex/div2/DivSize$MatchParent;", "invoke", cc.o, "json", "fromJson", "div-data_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @JvmStatic
        public final DivGifImage fromJson(ParsingEnvironment env, JSONObject json) {
            Intrinsics.checkNotNullParameter(env, "env");
            Intrinsics.checkNotNullParameter(json, "json");
            return BuiltInParserKt.getBuiltInParserComponent().getDivGifImageJsonEntityParser().getValue().deserialize((ParsingContext) env, json);
        }

        public final Function2<ParsingEnvironment, JSONObject, DivGifImage> getCREATOR() {
            return DivGifImage.CREATOR;
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
        CONTENT_ALIGNMENT_HORIZONTAL_DEFAULT_VALUE = Expression.INSTANCE.constant(DivAlignmentHorizontal.CENTER);
        CONTENT_ALIGNMENT_VERTICAL_DEFAULT_VALUE = Expression.INSTANCE.constant(DivAlignmentVertical.CENTER);
        HEIGHT_DEFAULT_VALUE = new DivSize.WrapContent(new DivWrapContentSize(null, null, 0 == true ? 1 : 0, 7, null));
        PLACEHOLDER_COLOR_DEFAULT_VALUE = Expression.INSTANCE.constant(Integer.valueOf(DivSeparatorView.DEFAULT_DIVIDER_COLOR));
        PRELOAD_REQUIRED_DEFAULT_VALUE = Expression.INSTANCE.constant(false);
        SCALE_DEFAULT_VALUE = Expression.INSTANCE.constant(DivImageScale.FILL);
        VISIBILITY_DEFAULT_VALUE = Expression.INSTANCE.constant(DivVisibility.VISIBLE);
        WIDTH_DEFAULT_VALUE = new DivSize.MatchParent(new DivMatchParentSize(0 == true ? 1 : 0, 1, 0 == true ? 1 : 0));
        CREATOR = new Function2<ParsingEnvironment, JSONObject, DivGifImage>() { // from class: com.yandex.div2.DivGifImage$Companion$CREATOR$1
            @Override // kotlin.jvm.functions.Function2
            public final DivGifImage invoke(ParsingEnvironment env, JSONObject it) {
                Intrinsics.checkNotNullParameter(env, "env");
                Intrinsics.checkNotNullParameter(it, "it");
                return DivGifImage.INSTANCE.fromJson(env, it);
            }
        };
    }
}
