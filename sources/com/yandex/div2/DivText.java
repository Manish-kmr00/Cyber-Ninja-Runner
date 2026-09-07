package com.yandex.div2;

import android.net.Uri;
import androidx.compose.material.OutlinedTextFieldKt;
import androidx.core.view.ViewCompat;
import com.adjust.sdk.Constants;
import com.facebook.share.internal.ShareConstants;
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

/* JADX INFO: compiled from: DivText.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000¢\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0006\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b6\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 ¦\u00012\u00020\u00012\u00020\u00022\u00020\u0003:\b¦\u0001§\u0001¨\u0001©\u0001B\u0095\b\b\u0007\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\t\u0012\u0010\b\u0002\u0010\n\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u000b\u0012\u0010\b\u0002\u0010\f\u001a\n\u0012\u0004\u0012\u00020\u000e\u0018\u00010\r\u0012\u0010\b\u0002\u0010\u000f\u001a\n\u0012\u0004\u0012\u00020\u0010\u0018\u00010\r\u0012\u000e\b\u0002\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00120\r\u0012\u0010\b\u0002\u0010\u0013\u001a\n\u0012\u0004\u0012\u00020\u0014\u0018\u00010\u000b\u0012\u0010\b\u0002\u0010\u0015\u001a\n\u0012\u0004\u0012\u00020\u0016\u0018\u00010\r\u0012\u0010\b\u0002\u0010\u0017\u001a\n\u0012\u0004\u0012\u00020\u0018\u0018\u00010\u000b\u0012\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u001a\u0012\u0010\b\u0002\u0010\u001b\u001a\n\u0012\u0004\u0012\u00020\u001c\u0018\u00010\r\u0012\u0010\b\u0002\u0010\u001d\u001a\n\u0012\u0004\u0012\u00020\u001e\u0018\u00010\u000b\u0012\u0010\b\u0002\u0010\u001f\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u000b\u0012\n\b\u0002\u0010 \u001a\u0004\u0018\u00010!\u0012\u0010\b\u0002\u0010\"\u001a\n\u0012\u0004\u0012\u00020#\u0018\u00010\u000b\u0012\n\b\u0002\u0010$\u001a\u0004\u0018\u00010%\u0012\u0010\b\u0002\u0010&\u001a\n\u0012\u0004\u0012\u00020'\u0018\u00010\r\u0012\u0010\b\u0002\u0010(\u001a\n\u0012\u0004\u0012\u00020)\u0018\u00010\r\u0012\u0010\b\u0002\u0010*\u001a\n\u0012\u0004\u0012\u00020)\u0018\u00010\r\u0012\u000e\b\u0002\u0010+\u001a\b\u0012\u0004\u0012\u00020\u001c0\r\u0012\u000e\b\u0002\u0010,\u001a\b\u0012\u0004\u0012\u00020-0\r\u0012\u000e\b\u0002\u0010.\u001a\b\u0012\u0004\u0012\u00020/0\r\u0012\u0010\b\u0002\u00100\u001a\n\u0012\u0004\u0012\u00020\u001c\u0018\u00010\r\u0012\u0010\b\u0002\u00101\u001a\n\u0012\u0004\u0012\u000202\u0018\u00010\u000b\u0012\b\b\u0002\u00103\u001a\u000204\u0012\u0010\b\u0002\u00105\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u000b\u0012\u0010\b\u0002\u00106\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u000b\u0012\n\b\u0002\u00107\u001a\u0004\u0018\u00010)\u0012\u0010\b\u0002\u00108\u001a\n\u0012\u0004\u0012\u000209\u0018\u00010\u000b\u0012\n\b\u0002\u0010:\u001a\u0004\u0018\u00010;\u0012\u000e\b\u0002\u0010<\u001a\b\u0012\u0004\u0012\u00020\u00120\r\u0012\u0010\b\u0002\u0010=\u001a\n\u0012\u0004\u0012\u00020\u001c\u0018\u00010\r\u0012\u0010\b\u0002\u0010>\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u000b\u0012\n\b\u0002\u0010?\u001a\u0004\u0018\u00010@\u0012\u0010\b\u0002\u0010A\u001a\n\u0012\u0004\u0012\u00020\u001c\u0018\u00010\r\u0012\u0010\b\u0002\u0010B\u001a\n\u0012\u0004\u0012\u00020\u001c\u0018\u00010\r\u0012\n\b\u0002\u0010C\u001a\u0004\u0018\u00010@\u0012\u0010\b\u0002\u0010D\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u000b\u0012\u0010\b\u0002\u0010E\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u000b\u0012\u0010\b\u0002\u0010F\u001a\n\u0012\u0004\u0012\u00020G\u0018\u00010\u000b\u0012\u0010\b\u0002\u0010H\u001a\n\u0012\u0004\u0012\u00020)\u0018\u00010\r\u0012\u0010\b\u0002\u0010I\u001a\n\u0012\u0004\u0012\u00020\u001c\u0018\u00010\r\u0012\u000e\b\u0002\u0010J\u001a\b\u0012\u0004\u0012\u00020\u00160\r\u0012\u0010\b\u0002\u0010K\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u000b\u0012\u000e\b\u0002\u0010L\u001a\b\u0012\u0004\u0012\u00020M0\r\u0012\f\u0010N\u001a\b\u0012\u0004\u0012\u00020)0\r\u0012\u000e\b\u0002\u0010O\u001a\b\u0012\u0004\u0012\u00020\u000e0\r\u0012\u000e\b\u0002\u0010P\u001a\b\u0012\u0004\u0012\u00020\u00100\r\u0012\u000e\b\u0002\u0010Q\u001a\b\u0012\u0004\u0012\u00020'0\r\u0012\n\b\u0002\u0010R\u001a\u0004\u0018\u00010S\u0012\n\b\u0002\u0010T\u001a\u0004\u0018\u00010U\u0012\u000e\b\u0002\u0010V\u001a\b\u0012\u0004\u0012\u00020\u00160\r\u0012\u0010\b\u0002\u0010W\u001a\n\u0012\u0004\u0012\u00020X\u0018\u00010\u000b\u0012\n\b\u0002\u0010Y\u001a\u0004\u0018\u00010Z\u0012\n\b\u0002\u0010[\u001a\u0004\u0018\u00010\\\u0012\n\b\u0002\u0010]\u001a\u0004\u0018\u00010^\u0012\n\b\u0002\u0010_\u001a\u0004\u0018\u00010^\u0012\u0010\b\u0002\u0010`\u001a\n\u0012\u0004\u0012\u00020a\u0018\u00010\u000b\u0012\u000e\b\u0002\u0010b\u001a\b\u0012\u0004\u0012\u00020M0\r\u0012\u0010\b\u0002\u0010c\u001a\n\u0012\u0004\u0012\u00020d\u0018\u00010\u000b\u0012\u0010\b\u0002\u0010e\u001a\n\u0012\u0004\u0012\u00020f\u0018\u00010\u000b\u0012\u000e\b\u0002\u0010g\u001a\b\u0012\u0004\u0012\u00020h0\r\u0012\n\b\u0002\u0010i\u001a\u0004\u0018\u00010j\u0012\u0010\b\u0002\u0010k\u001a\n\u0012\u0004\u0012\u00020j\u0018\u00010\u000b\u0012\b\b\u0002\u0010l\u001a\u000204¢\u0006\u0002\u0010mJ\u0097\b\u0010\u009d\u0001\u001a\u00020\u00002\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\u0010\b\u0002\u0010\n\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u000b2\u0010\b\u0002\u0010\f\u001a\n\u0012\u0004\u0012\u00020\u000e\u0018\u00010\r2\u0010\b\u0002\u0010\u000f\u001a\n\u0012\u0004\u0012\u00020\u0010\u0018\u00010\r2\u000e\b\u0002\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00120\r2\u0010\b\u0002\u0010\u0013\u001a\n\u0012\u0004\u0012\u00020\u0014\u0018\u00010\u000b2\u0010\b\u0002\u0010\u0015\u001a\n\u0012\u0004\u0012\u00020\u0016\u0018\u00010\r2\u0010\b\u0002\u0010\u0017\u001a\n\u0012\u0004\u0012\u00020\u0018\u0018\u00010\u000b2\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u001a2\u0010\b\u0002\u0010\u001b\u001a\n\u0012\u0004\u0012\u00020\u001c\u0018\u00010\r2\u0010\b\u0002\u0010\u001d\u001a\n\u0012\u0004\u0012\u00020\u001e\u0018\u00010\u000b2\u0010\b\u0002\u0010\u001f\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u000b2\n\b\u0002\u0010 \u001a\u0004\u0018\u00010!2\u0010\b\u0002\u0010\"\u001a\n\u0012\u0004\u0012\u00020#\u0018\u00010\u000b2\n\b\u0002\u0010$\u001a\u0004\u0018\u00010%2\u0010\b\u0002\u0010&\u001a\n\u0012\u0004\u0012\u00020'\u0018\u00010\r2\u0010\b\u0002\u0010(\u001a\n\u0012\u0004\u0012\u00020)\u0018\u00010\r2\u0010\b\u0002\u0010*\u001a\n\u0012\u0004\u0012\u00020)\u0018\u00010\r2\u000e\b\u0002\u0010+\u001a\b\u0012\u0004\u0012\u00020\u001c0\r2\u000e\b\u0002\u0010,\u001a\b\u0012\u0004\u0012\u00020-0\r2\u000e\b\u0002\u0010.\u001a\b\u0012\u0004\u0012\u00020/0\r2\u0010\b\u0002\u00100\u001a\n\u0012\u0004\u0012\u00020\u001c\u0018\u00010\r2\u0010\b\u0002\u00101\u001a\n\u0012\u0004\u0012\u000202\u0018\u00010\u000b2\b\b\u0002\u00103\u001a\u0002042\u0010\b\u0002\u00105\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u000b2\u0010\b\u0002\u00106\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u000b2\n\b\u0002\u00107\u001a\u0004\u0018\u00010)2\u0010\b\u0002\u00108\u001a\n\u0012\u0004\u0012\u000209\u0018\u00010\u000b2\n\b\u0002\u0010:\u001a\u0004\u0018\u00010;2\u000e\b\u0002\u0010<\u001a\b\u0012\u0004\u0012\u00020\u00120\r2\u0010\b\u0002\u0010=\u001a\n\u0012\u0004\u0012\u00020\u001c\u0018\u00010\r2\u0010\b\u0002\u0010>\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u000b2\n\b\u0002\u0010?\u001a\u0004\u0018\u00010@2\u0010\b\u0002\u0010A\u001a\n\u0012\u0004\u0012\u00020\u001c\u0018\u00010\r2\u0010\b\u0002\u0010B\u001a\n\u0012\u0004\u0012\u00020\u001c\u0018\u00010\r2\n\b\u0002\u0010C\u001a\u0004\u0018\u00010@2\u0010\b\u0002\u0010D\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u000b2\u0010\b\u0002\u0010E\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u000b2\u0010\b\u0002\u0010F\u001a\n\u0012\u0004\u0012\u00020G\u0018\u00010\u000b2\u0010\b\u0002\u0010H\u001a\n\u0012\u0004\u0012\u00020)\u0018\u00010\r2\u0010\b\u0002\u0010I\u001a\n\u0012\u0004\u0012\u00020\u001c\u0018\u00010\r2\u000e\b\u0002\u0010J\u001a\b\u0012\u0004\u0012\u00020\u00160\r2\u0010\b\u0002\u0010K\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u000b2\u000e\b\u0002\u0010L\u001a\b\u0012\u0004\u0012\u00020M0\r2\u000e\b\u0002\u0010N\u001a\b\u0012\u0004\u0012\u00020)0\r2\u000e\b\u0002\u0010O\u001a\b\u0012\u0004\u0012\u00020\u000e0\r2\u000e\b\u0002\u0010P\u001a\b\u0012\u0004\u0012\u00020\u00100\r2\u000e\b\u0002\u0010Q\u001a\b\u0012\u0004\u0012\u00020'0\r2\n\b\u0002\u0010R\u001a\u0004\u0018\u00010S2\n\b\u0002\u0010T\u001a\u0004\u0018\u00010U2\u000e\b\u0002\u0010V\u001a\b\u0012\u0004\u0012\u00020\u00160\r2\u0010\b\u0002\u0010W\u001a\n\u0012\u0004\u0012\u00020X\u0018\u00010\u000b2\n\b\u0002\u0010Y\u001a\u0004\u0018\u00010Z2\n\b\u0002\u0010[\u001a\u0004\u0018\u00010\\2\n\b\u0002\u0010]\u001a\u0004\u0018\u00010^2\n\b\u0002\u0010_\u001a\u0004\u0018\u00010^2\u0010\b\u0002\u0010`\u001a\n\u0012\u0004\u0012\u00020a\u0018\u00010\u000b2\u000e\b\u0002\u0010b\u001a\b\u0012\u0004\u0012\u00020M0\r2\u0010\b\u0002\u0010c\u001a\n\u0012\u0004\u0012\u00020d\u0018\u00010\u000b2\u0010\b\u0002\u0010e\u001a\n\u0012\u0004\u0012\u00020f\u0018\u00010\u000b2\u000e\b\u0002\u0010g\u001a\b\u0012\u0004\u0012\u00020h0\r2\n\b\u0002\u0010i\u001a\u0004\u0018\u00010j2\u0010\b\u0002\u0010k\u001a\n\u0012\u0004\u0012\u00020j\u0018\u00010\u000b2\b\b\u0002\u0010l\u001a\u000204J&\u0010\u009e\u0001\u001a\u00020\u00162\t\u0010\u009f\u0001\u001a\u0004\u0018\u00010\u00002\b\u0010 \u0001\u001a\u00030¡\u00012\b\u0010¢\u0001\u001a\u00030¡\u0001J\t\u0010£\u0001\u001a\u00020'H\u0016J\n\u0010¤\u0001\u001a\u00030¥\u0001H\u0016R\u0012\u0010n\u001a\u0004\u0018\u00010'X\u0082\u000e¢\u0006\u0004\n\u0002\u0010oR\u0016\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\bp\u0010qR\u0012\u0010\u0006\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u00020\t8\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0018\u0010\n\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u000b8\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\f\u001a\n\u0012\u0004\u0012\u00020\u000e\u0018\u00010\rX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\br\u0010sR\u001c\u0010\u000f\u001a\n\u0012\u0004\u0012\u00020\u0010\u0018\u00010\rX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\bt\u0010sR\u001a\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00120\rX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\bu\u0010sR\u001c\u0010\u0013\u001a\n\u0012\u0004\u0012\u00020\u0014\u0018\u00010\u000bX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\bv\u0010wR\u0018\u0010\u0015\u001a\n\u0012\u0004\u0012\u00020\u0016\u0018\u00010\r8\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\u0017\u001a\n\u0012\u0004\u0012\u00020\u0018\u0018\u00010\u000bX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\bx\u0010wR\u0016\u0010\u0019\u001a\u0004\u0018\u00010\u001aX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\by\u0010zR\u001c\u0010\u001b\u001a\n\u0012\u0004\u0012\u00020\u001c\u0018\u00010\rX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b{\u0010sR\u001c\u0010\u001d\u001a\n\u0012\u0004\u0012\u00020\u001e\u0018\u00010\u000bX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b|\u0010wR\u0018\u0010\u001f\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u000b8\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0012\u0010 \u001a\u0004\u0018\u00010!8\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\"\u001a\n\u0012\u0004\u0012\u00020#\u0018\u00010\u000bX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b}\u0010wR\u0016\u0010$\u001a\u0004\u0018\u00010%X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b~\u0010\u007fR\u0018\u0010&\u001a\n\u0012\u0004\u0012\u00020'\u0018\u00010\r8\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0018\u0010(\u001a\n\u0012\u0004\u0012\u00020)\u0018\u00010\r8\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0018\u0010*\u001a\n\u0012\u0004\u0012\u00020)\u0018\u00010\r8\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0016\u0010+\u001a\b\u0012\u0004\u0012\u00020\u001c0\r8\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0016\u0010,\u001a\b\u0012\u0004\u0012\u00020-0\r8\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0016\u0010.\u001a\b\u0012\u0004\u0012\u00020/0\r8\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0018\u00100\u001a\n\u0012\u0004\u0012\u00020\u001c\u0018\u00010\r8\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u001d\u00101\u001a\n\u0012\u0004\u0012\u000202\u0018\u00010\u000bX\u0096\u0004¢\u0006\t\n\u0000\u001a\u0005\b\u0080\u0001\u0010wR\u0016\u00103\u001a\u000204X\u0096\u0004¢\u0006\n\n\u0000\u001a\u0006\b\u0081\u0001\u0010\u0082\u0001R\u0018\u00105\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u000b8\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0018\u00106\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u000b8\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0018\u00107\u001a\u0004\u0018\u00010)X\u0096\u0004¢\u0006\n\n\u0000\u001a\u0006\b\u0083\u0001\u0010\u0084\u0001R\u0018\u00108\u001a\n\u0012\u0004\u0012\u000209\u0018\u00010\u000b8\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0018\u0010:\u001a\u0004\u0018\u00010;X\u0096\u0004¢\u0006\n\n\u0000\u001a\u0006\b\u0085\u0001\u0010\u0086\u0001R\u0016\u0010<\u001a\b\u0012\u0004\u0012\u00020\u00120\r8\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0018\u0010=\u001a\n\u0012\u0004\u0012\u00020\u001c\u0018\u00010\r8\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0018\u0010>\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u000b8\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0018\u0010?\u001a\u0004\u0018\u00010@X\u0096\u0004¢\u0006\n\n\u0000\u001a\u0006\b\u0087\u0001\u0010\u0088\u0001R\u0018\u0010A\u001a\n\u0012\u0004\u0012\u00020\u001c\u0018\u00010\r8\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0018\u0010B\u001a\n\u0012\u0004\u0012\u00020\u001c\u0018\u00010\r8\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0018\u0010C\u001a\u0004\u0018\u00010@X\u0096\u0004¢\u0006\n\n\u0000\u001a\u0006\b\u0089\u0001\u0010\u0088\u0001R\u0018\u0010D\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u000b8\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0018\u0010E\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u000b8\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0018\u0010F\u001a\n\u0012\u0004\u0012\u00020G\u0018\u00010\u000b8\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u001d\u0010H\u001a\n\u0012\u0004\u0012\u00020)\u0018\u00010\rX\u0096\u0004¢\u0006\t\n\u0000\u001a\u0005\b\u008a\u0001\u0010sR\u001d\u0010I\u001a\n\u0012\u0004\u0012\u00020\u001c\u0018\u00010\rX\u0096\u0004¢\u0006\t\n\u0000\u001a\u0005\b\u008b\u0001\u0010sR\u0016\u0010J\u001a\b\u0012\u0004\u0012\u00020\u00160\r8\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u001d\u0010K\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u000bX\u0096\u0004¢\u0006\t\n\u0000\u001a\u0005\b\u008c\u0001\u0010wR\u0016\u0010L\u001a\b\u0012\u0004\u0012\u00020M0\r8\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0016\u0010N\u001a\b\u0012\u0004\u0012\u00020)0\r8\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0016\u0010O\u001a\b\u0012\u0004\u0012\u00020\u000e0\r8\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0016\u0010P\u001a\b\u0012\u0004\u0012\u00020\u00100\r8\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0016\u0010Q\u001a\b\u0012\u0004\u0012\u00020'0\r8\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0012\u0010R\u001a\u0004\u0018\u00010S8\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0012\u0010T\u001a\u0004\u0018\u00010U8\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0016\u0010V\u001a\b\u0012\u0004\u0012\u00020\u00160\r8\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u001d\u0010W\u001a\n\u0012\u0004\u0012\u00020X\u0018\u00010\u000bX\u0096\u0004¢\u0006\t\n\u0000\u001a\u0005\b\u008d\u0001\u0010wR\u0018\u0010Y\u001a\u0004\u0018\u00010ZX\u0096\u0004¢\u0006\n\n\u0000\u001a\u0006\b\u008e\u0001\u0010\u008f\u0001R\u0018\u0010[\u001a\u0004\u0018\u00010\\X\u0096\u0004¢\u0006\n\n\u0000\u001a\u0006\b\u0090\u0001\u0010\u0091\u0001R\u0018\u0010]\u001a\u0004\u0018\u00010^X\u0096\u0004¢\u0006\n\n\u0000\u001a\u0006\b\u0092\u0001\u0010\u0093\u0001R\u0018\u0010_\u001a\u0004\u0018\u00010^X\u0096\u0004¢\u0006\n\n\u0000\u001a\u0006\b\u0094\u0001\u0010\u0093\u0001R\u001d\u0010`\u001a\n\u0012\u0004\u0012\u00020a\u0018\u00010\u000bX\u0096\u0004¢\u0006\t\n\u0000\u001a\u0005\b\u0095\u0001\u0010wR\u0016\u0010b\u001a\b\u0012\u0004\u0012\u00020M0\r8\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u001d\u0010c\u001a\n\u0012\u0004\u0012\u00020d\u0018\u00010\u000bX\u0096\u0004¢\u0006\t\n\u0000\u001a\u0005\b\u0096\u0001\u0010wR\u001d\u0010e\u001a\n\u0012\u0004\u0012\u00020f\u0018\u00010\u000bX\u0096\u0004¢\u0006\t\n\u0000\u001a\u0005\b\u0097\u0001\u0010wR\u001b\u0010g\u001a\b\u0012\u0004\u0012\u00020h0\rX\u0096\u0004¢\u0006\t\n\u0000\u001a\u0005\b\u0098\u0001\u0010sR\u0018\u0010i\u001a\u0004\u0018\u00010jX\u0096\u0004¢\u0006\n\n\u0000\u001a\u0006\b\u0099\u0001\u0010\u009a\u0001R\u001d\u0010k\u001a\n\u0012\u0004\u0012\u00020j\u0018\u00010\u000bX\u0096\u0004¢\u0006\t\n\u0000\u001a\u0005\b\u009b\u0001\u0010wR\u0016\u0010l\u001a\u000204X\u0096\u0004¢\u0006\n\n\u0000\u001a\u0006\b\u009c\u0001\u0010\u0082\u0001¨\u0006ª\u0001"}, d2 = {"Lcom/yandex/div2/DivText;", "Lcom/yandex/div/json/JSONSerializable;", "Lcom/yandex/div/data/Hashable;", "Lcom/yandex/div2/DivBase;", "accessibility", "Lcom/yandex/div2/DivAccessibility;", "action", "Lcom/yandex/div2/DivAction;", "actionAnimation", "Lcom/yandex/div2/DivAnimation;", "actions", "", "alignmentHorizontal", "Lcom/yandex/div/json/expressions/Expression;", "Lcom/yandex/div2/DivAlignmentHorizontal;", "alignmentVertical", "Lcom/yandex/div2/DivAlignmentVertical;", "alpha", "", "animators", "Lcom/yandex/div2/DivAnimator;", "autoEllipsize", "", J2.g, "Lcom/yandex/div2/DivBackground;", OutlinedTextFieldKt.BorderId, "Lcom/yandex/div2/DivBorder;", "columnSpan", "", "disappearActions", "Lcom/yandex/div2/DivDisappearAction;", "doubletapActions", "ellipsis", "Lcom/yandex/div2/DivText$Ellipsis;", "extensions", "Lcom/yandex/div2/DivExtension;", "focus", "Lcom/yandex/div2/DivFocus;", "focusedTextColor", "", "fontFamily", "", "fontFeatureSettings", "fontSize", "fontSizeUnit", "Lcom/yandex/div2/DivSizeUnit;", "fontWeight", "Lcom/yandex/div2/DivFontWeight;", "fontWeightValue", "functions", "Lcom/yandex/div2/DivFunction;", "height", "Lcom/yandex/div2/DivSize;", "hoverEndActions", "hoverStartActions", "id", "images", "Lcom/yandex/div2/DivText$Image;", "layoutProvider", "Lcom/yandex/div2/DivLayoutProvider;", "letterSpacing", "lineHeight", "longtapActions", "margins", "Lcom/yandex/div2/DivEdgeInsets;", "maxLines", "minHiddenLines", "paddings", "pressEndActions", "pressStartActions", "ranges", "Lcom/yandex/div2/DivText$Range;", "reuseId", "rowSpan", "selectable", "selectedActions", "strike", "Lcom/yandex/div2/DivLineStyle;", "text", "textAlignmentHorizontal", "textAlignmentVertical", "textColor", "textGradient", "Lcom/yandex/div2/DivTextGradient;", "textShadow", "Lcom/yandex/div2/DivShadow;", "tightenWidth", "tooltips", "Lcom/yandex/div2/DivTooltip;", "transform", "Lcom/yandex/div2/DivTransform;", "transitionChange", "Lcom/yandex/div2/DivChangeTransition;", "transitionIn", "Lcom/yandex/div2/DivAppearanceTransition;", "transitionOut", "transitionTriggers", "Lcom/yandex/div2/DivTransitionTrigger;", "underline", "variableTriggers", "Lcom/yandex/div2/DivTrigger;", "variables", "Lcom/yandex/div2/DivVariable;", "visibility", "Lcom/yandex/div2/DivVisibility;", "visibilityAction", "Lcom/yandex/div2/DivVisibilityAction;", "visibilityActions", "width", "(Lcom/yandex/div2/DivAccessibility;Lcom/yandex/div2/DivAction;Lcom/yandex/div2/DivAnimation;Ljava/util/List;Lcom/yandex/div/json/expressions/Expression;Lcom/yandex/div/json/expressions/Expression;Lcom/yandex/div/json/expressions/Expression;Ljava/util/List;Lcom/yandex/div/json/expressions/Expression;Ljava/util/List;Lcom/yandex/div2/DivBorder;Lcom/yandex/div/json/expressions/Expression;Ljava/util/List;Ljava/util/List;Lcom/yandex/div2/DivText$Ellipsis;Ljava/util/List;Lcom/yandex/div2/DivFocus;Lcom/yandex/div/json/expressions/Expression;Lcom/yandex/div/json/expressions/Expression;Lcom/yandex/div/json/expressions/Expression;Lcom/yandex/div/json/expressions/Expression;Lcom/yandex/div/json/expressions/Expression;Lcom/yandex/div/json/expressions/Expression;Lcom/yandex/div/json/expressions/Expression;Ljava/util/List;Lcom/yandex/div2/DivSize;Ljava/util/List;Ljava/util/List;Ljava/lang/String;Ljava/util/List;Lcom/yandex/div2/DivLayoutProvider;Lcom/yandex/div/json/expressions/Expression;Lcom/yandex/div/json/expressions/Expression;Ljava/util/List;Lcom/yandex/div2/DivEdgeInsets;Lcom/yandex/div/json/expressions/Expression;Lcom/yandex/div/json/expressions/Expression;Lcom/yandex/div2/DivEdgeInsets;Ljava/util/List;Ljava/util/List;Ljava/util/List;Lcom/yandex/div/json/expressions/Expression;Lcom/yandex/div/json/expressions/Expression;Lcom/yandex/div/json/expressions/Expression;Ljava/util/List;Lcom/yandex/div/json/expressions/Expression;Lcom/yandex/div/json/expressions/Expression;Lcom/yandex/div/json/expressions/Expression;Lcom/yandex/div/json/expressions/Expression;Lcom/yandex/div/json/expressions/Expression;Lcom/yandex/div2/DivTextGradient;Lcom/yandex/div2/DivShadow;Lcom/yandex/div/json/expressions/Expression;Ljava/util/List;Lcom/yandex/div2/DivTransform;Lcom/yandex/div2/DivChangeTransition;Lcom/yandex/div2/DivAppearanceTransition;Lcom/yandex/div2/DivAppearanceTransition;Ljava/util/List;Lcom/yandex/div/json/expressions/Expression;Ljava/util/List;Ljava/util/List;Lcom/yandex/div/json/expressions/Expression;Lcom/yandex/div2/DivVisibilityAction;Ljava/util/List;Lcom/yandex/div2/DivSize;)V", "_hash", "Ljava/lang/Integer;", "getAccessibility", "()Lcom/yandex/div2/DivAccessibility;", "getAlignmentHorizontal", "()Lcom/yandex/div/json/expressions/Expression;", "getAlignmentVertical", "getAlpha", "getAnimators", "()Ljava/util/List;", "getBackground", "getBorder", "()Lcom/yandex/div2/DivBorder;", "getColumnSpan", "getDisappearActions", "getExtensions", "getFocus", "()Lcom/yandex/div2/DivFocus;", "getFunctions", "getHeight", "()Lcom/yandex/div2/DivSize;", "getId", "()Ljava/lang/String;", "getLayoutProvider", "()Lcom/yandex/div2/DivLayoutProvider;", "getMargins", "()Lcom/yandex/div2/DivEdgeInsets;", "getPaddings", "getReuseId", "getRowSpan", "getSelectedActions", "getTooltips", "getTransform", "()Lcom/yandex/div2/DivTransform;", "getTransitionChange", "()Lcom/yandex/div2/DivChangeTransition;", "getTransitionIn", "()Lcom/yandex/div2/DivAppearanceTransition;", "getTransitionOut", "getTransitionTriggers", "getVariableTriggers", "getVariables", "getVisibility", "getVisibilityAction", "()Lcom/yandex/div2/DivVisibilityAction;", "getVisibilityActions", "getWidth", "copy", "equals", "other", "resolver", "Lcom/yandex/div/json/expressions/ExpressionResolver;", "otherResolver", "hash", "writeToJSON", "Lorg/json/JSONObject;", "Companion", "Ellipsis", "Image", "Range", "div-data_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class DivText implements JSONSerializable, Hashable, DivBase {
    private static final DivAnimation ACTION_ANIMATION_DEFAULT_VALUE;
    private static final Expression<Double> ALPHA_DEFAULT_VALUE;
    private static final Function2<ParsingEnvironment, JSONObject, DivText> CREATOR;

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final Expression<Long> FONT_SIZE_DEFAULT_VALUE;
    private static final Expression<DivSizeUnit> FONT_SIZE_UNIT_DEFAULT_VALUE;
    private static final Expression<DivFontWeight> FONT_WEIGHT_DEFAULT_VALUE;
    private static final DivSize.WrapContent HEIGHT_DEFAULT_VALUE;
    private static final Expression<Double> LETTER_SPACING_DEFAULT_VALUE;
    private static final Expression<Boolean> SELECTABLE_DEFAULT_VALUE;
    private static final Expression<DivLineStyle> STRIKE_DEFAULT_VALUE;
    private static final Expression<DivAlignmentHorizontal> TEXT_ALIGNMENT_HORIZONTAL_DEFAULT_VALUE;
    private static final Expression<DivAlignmentVertical> TEXT_ALIGNMENT_VERTICAL_DEFAULT_VALUE;
    private static final Expression<Integer> TEXT_COLOR_DEFAULT_VALUE;
    private static final Expression<Boolean> TIGHTEN_WIDTH_DEFAULT_VALUE;
    public static final String TYPE = "text";
    private static final Expression<DivLineStyle> UNDERLINE_DEFAULT_VALUE;
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
    public final Expression<Boolean> autoEllipsize;
    private final List<DivBackground> background;
    private final DivBorder border;
    private final Expression<Long> columnSpan;
    private final List<DivDisappearAction> disappearActions;
    public final List<DivAction> doubletapActions;
    public final Ellipsis ellipsis;
    private final List<DivExtension> extensions;
    private final DivFocus focus;
    public final Expression<Integer> focusedTextColor;
    public final Expression<String> fontFamily;
    public final Expression<String> fontFeatureSettings;
    public final Expression<Long> fontSize;
    public final Expression<DivSizeUnit> fontSizeUnit;
    public final Expression<DivFontWeight> fontWeight;
    public final Expression<Long> fontWeightValue;
    private final List<DivFunction> functions;
    private final DivSize height;
    public final List<DivAction> hoverEndActions;
    public final List<DivAction> hoverStartActions;
    private final String id;
    public final List<Image> images;
    private final DivLayoutProvider layoutProvider;
    public final Expression<Double> letterSpacing;
    public final Expression<Long> lineHeight;
    public final List<DivAction> longtapActions;
    private final DivEdgeInsets margins;
    public final Expression<Long> maxLines;
    public final Expression<Long> minHiddenLines;
    private final DivEdgeInsets paddings;
    public final List<DivAction> pressEndActions;
    public final List<DivAction> pressStartActions;
    public final List<Range> ranges;
    private final Expression<String> reuseId;
    private final Expression<Long> rowSpan;
    public final Expression<Boolean> selectable;
    private final List<DivAction> selectedActions;
    public final Expression<DivLineStyle> strike;
    public final Expression<String> text;
    public final Expression<DivAlignmentHorizontal> textAlignmentHorizontal;
    public final Expression<DivAlignmentVertical> textAlignmentVertical;
    public final Expression<Integer> textColor;
    public final DivTextGradient textGradient;
    public final DivShadow textShadow;
    public final Expression<Boolean> tightenWidth;
    private final List<DivTooltip> tooltips;
    private final DivTransform transform;
    private final DivChangeTransition transitionChange;
    private final DivAppearanceTransition transitionIn;
    private final DivAppearanceTransition transitionOut;
    private final List<DivTransitionTrigger> transitionTriggers;
    public final Expression<DivLineStyle> underline;
    private final List<DivTrigger> variableTriggers;
    private final List<DivVariable> variables;
    private final Expression<DivVisibility> visibility;
    private final DivVisibilityAction visibilityAction;
    private final List<DivVisibilityAction> visibilityActions;
    private final DivSize width;

    @JvmStatic
    public static final DivText fromJson(ParsingEnvironment parsingEnvironment, JSONObject jSONObject) {
        return INSTANCE.fromJson(parsingEnvironment, jSONObject);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public DivText(DivAccessibility divAccessibility, DivAction divAction, DivAnimation actionAnimation, List<DivAction> list, Expression<DivAlignmentHorizontal> expression, Expression<DivAlignmentVertical> expression2, Expression<Double> alpha, List<? extends DivAnimator> list2, Expression<Boolean> expression3, List<? extends DivBackground> list3, DivBorder divBorder, Expression<Long> expression4, List<DivDisappearAction> list4, List<DivAction> list5, Ellipsis ellipsis, List<DivExtension> list6, DivFocus divFocus, Expression<Integer> expression5, Expression<String> expression6, Expression<String> expression7, Expression<Long> fontSize, Expression<DivSizeUnit> fontSizeUnit, Expression<DivFontWeight> fontWeight, Expression<Long> expression8, List<DivFunction> list7, DivSize height, List<DivAction> list8, List<DivAction> list9, String str, List<Image> list10, DivLayoutProvider divLayoutProvider, Expression<Double> letterSpacing, Expression<Long> expression9, List<DivAction> list11, DivEdgeInsets divEdgeInsets, Expression<Long> expression10, Expression<Long> expression11, DivEdgeInsets divEdgeInsets2, List<DivAction> list12, List<DivAction> list13, List<Range> list14, Expression<String> expression12, Expression<Long> expression13, Expression<Boolean> selectable, List<DivAction> list15, Expression<DivLineStyle> strike, Expression<String> text, Expression<DivAlignmentHorizontal> textAlignmentHorizontal, Expression<DivAlignmentVertical> textAlignmentVertical, Expression<Integer> textColor, DivTextGradient divTextGradient, DivShadow divShadow, Expression<Boolean> tightenWidth, List<DivTooltip> list16, DivTransform divTransform, DivChangeTransition divChangeTransition, DivAppearanceTransition divAppearanceTransition, DivAppearanceTransition divAppearanceTransition2, List<? extends DivTransitionTrigger> list17, Expression<DivLineStyle> underline, List<DivTrigger> list18, List<? extends DivVariable> list19, Expression<DivVisibility> visibility, DivVisibilityAction divVisibilityAction, List<DivVisibilityAction> list20, DivSize width) {
        Intrinsics.checkNotNullParameter(actionAnimation, "actionAnimation");
        Intrinsics.checkNotNullParameter(alpha, "alpha");
        Intrinsics.checkNotNullParameter(fontSize, "fontSize");
        Intrinsics.checkNotNullParameter(fontSizeUnit, "fontSizeUnit");
        Intrinsics.checkNotNullParameter(fontWeight, "fontWeight");
        Intrinsics.checkNotNullParameter(height, "height");
        Intrinsics.checkNotNullParameter(letterSpacing, "letterSpacing");
        Intrinsics.checkNotNullParameter(selectable, "selectable");
        Intrinsics.checkNotNullParameter(strike, "strike");
        Intrinsics.checkNotNullParameter(text, "text");
        Intrinsics.checkNotNullParameter(textAlignmentHorizontal, "textAlignmentHorizontal");
        Intrinsics.checkNotNullParameter(textAlignmentVertical, "textAlignmentVertical");
        Intrinsics.checkNotNullParameter(textColor, "textColor");
        Intrinsics.checkNotNullParameter(tightenWidth, "tightenWidth");
        Intrinsics.checkNotNullParameter(underline, "underline");
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
        this.autoEllipsize = expression3;
        this.background = list3;
        this.border = divBorder;
        this.columnSpan = expression4;
        this.disappearActions = list4;
        this.doubletapActions = list5;
        this.ellipsis = ellipsis;
        this.extensions = list6;
        this.focus = divFocus;
        this.focusedTextColor = expression5;
        this.fontFamily = expression6;
        this.fontFeatureSettings = expression7;
        this.fontSize = fontSize;
        this.fontSizeUnit = fontSizeUnit;
        this.fontWeight = fontWeight;
        this.fontWeightValue = expression8;
        this.functions = list7;
        this.height = height;
        this.hoverEndActions = list8;
        this.hoverStartActions = list9;
        this.id = str;
        this.images = list10;
        this.layoutProvider = divLayoutProvider;
        this.letterSpacing = letterSpacing;
        this.lineHeight = expression9;
        this.longtapActions = list11;
        this.margins = divEdgeInsets;
        this.maxLines = expression10;
        this.minHiddenLines = expression11;
        this.paddings = divEdgeInsets2;
        this.pressEndActions = list12;
        this.pressStartActions = list13;
        this.ranges = list14;
        this.reuseId = expression12;
        this.rowSpan = expression13;
        this.selectable = selectable;
        this.selectedActions = list15;
        this.strike = strike;
        this.text = text;
        this.textAlignmentHorizontal = textAlignmentHorizontal;
        this.textAlignmentVertical = textAlignmentVertical;
        this.textColor = textColor;
        this.textGradient = divTextGradient;
        this.textShadow = divShadow;
        this.tightenWidth = tightenWidth;
        this.tooltips = list16;
        this.transform = divTransform;
        this.transitionChange = divChangeTransition;
        this.transitionIn = divAppearanceTransition;
        this.transitionOut = divAppearanceTransition2;
        this.transitionTriggers = list17;
        this.underline = underline;
        this.variableTriggers = list18;
        this.variables = list19;
        this.visibility = visibility;
        this.visibilityAction = divVisibilityAction;
        this.visibilityActions = list20;
        this.width = width;
    }

    @Override // com.yandex.div2.DivBase
    public DivAccessibility getAccessibility() {
        return this.accessibility;
    }

    public /* synthetic */ DivText(DivAccessibility divAccessibility, DivAction divAction, DivAnimation divAnimation, List list, Expression expression, Expression expression2, Expression expression3, List list2, Expression expression4, List list3, DivBorder divBorder, Expression expression5, List list4, List list5, Ellipsis ellipsis, List list6, DivFocus divFocus, Expression expression6, Expression expression7, Expression expression8, Expression expression9, Expression expression10, Expression expression11, Expression expression12, List list7, DivSize divSize, List list8, List list9, String str, List list10, DivLayoutProvider divLayoutProvider, Expression expression13, Expression expression14, List list11, DivEdgeInsets divEdgeInsets, Expression expression15, Expression expression16, DivEdgeInsets divEdgeInsets2, List list12, List list13, List list14, Expression expression17, Expression expression18, Expression expression19, List list15, Expression expression20, Expression expression21, Expression expression22, Expression expression23, Expression expression24, DivTextGradient divTextGradient, DivShadow divShadow, Expression expression25, List list16, DivTransform divTransform, DivChangeTransition divChangeTransition, DivAppearanceTransition divAppearanceTransition, DivAppearanceTransition divAppearanceTransition2, List list17, Expression expression26, List list18, List list19, Expression expression27, DivVisibilityAction divVisibilityAction, List list20, DivSize divSize2, int i, int i2, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : divAccessibility, (i & 2) != 0 ? null : divAction, (i & 4) != 0 ? ACTION_ANIMATION_DEFAULT_VALUE : divAnimation, (i & 8) != 0 ? null : list, (i & 16) != 0 ? null : expression, (i & 32) != 0 ? null : expression2, (i & 64) != 0 ? ALPHA_DEFAULT_VALUE : expression3, (i & 128) != 0 ? null : list2, (i & 256) != 0 ? null : expression4, (i & 512) != 0 ? null : list3, (i & 1024) != 0 ? null : divBorder, (i & 2048) != 0 ? null : expression5, (i & 4096) != 0 ? null : list4, (i & 8192) != 0 ? null : list5, (i & 16384) != 0 ? null : ellipsis, (i & 32768) != 0 ? null : list6, (i & 65536) != 0 ? null : divFocus, (i & 131072) != 0 ? null : expression6, (i & 262144) != 0 ? null : expression7, (i & 524288) != 0 ? null : expression8, (i & 1048576) != 0 ? FONT_SIZE_DEFAULT_VALUE : expression9, (i & 2097152) != 0 ? FONT_SIZE_UNIT_DEFAULT_VALUE : expression10, (i & 4194304) != 0 ? FONT_WEIGHT_DEFAULT_VALUE : expression11, (i & 8388608) != 0 ? null : expression12, (i & 16777216) != 0 ? null : list7, (i & 33554432) != 0 ? HEIGHT_DEFAULT_VALUE : divSize, (i & 67108864) != 0 ? null : list8, (i & 134217728) != 0 ? null : list9, (i & 268435456) != 0 ? null : str, (i & 536870912) != 0 ? null : list10, (i & 1073741824) != 0 ? null : divLayoutProvider, (i & Integer.MIN_VALUE) != 0 ? LETTER_SPACING_DEFAULT_VALUE : expression13, (i2 & 1) != 0 ? null : expression14, (i2 & 2) != 0 ? null : list11, (i2 & 4) != 0 ? null : divEdgeInsets, (i2 & 8) != 0 ? null : expression15, (i2 & 16) != 0 ? null : expression16, (i2 & 32) != 0 ? null : divEdgeInsets2, (i2 & 64) != 0 ? null : list12, (i2 & 128) != 0 ? null : list13, (i2 & 256) != 0 ? null : list14, (i2 & 512) != 0 ? null : expression17, (i2 & 1024) != 0 ? null : expression18, (i2 & 2048) != 0 ? SELECTABLE_DEFAULT_VALUE : expression19, (i2 & 4096) != 0 ? null : list15, (i2 & 8192) != 0 ? STRIKE_DEFAULT_VALUE : expression20, expression21, (32768 & i2) != 0 ? TEXT_ALIGNMENT_HORIZONTAL_DEFAULT_VALUE : expression22, (65536 & i2) != 0 ? TEXT_ALIGNMENT_VERTICAL_DEFAULT_VALUE : expression23, (i2 & 131072) != 0 ? TEXT_COLOR_DEFAULT_VALUE : expression24, (i2 & 262144) != 0 ? null : divTextGradient, (i2 & 524288) != 0 ? null : divShadow, (i2 & 1048576) != 0 ? TIGHTEN_WIDTH_DEFAULT_VALUE : expression25, (i2 & 2097152) != 0 ? null : list16, (4194304 & i2) != 0 ? null : divTransform, (8388608 & i2) != 0 ? null : divChangeTransition, (16777216 & i2) != 0 ? null : divAppearanceTransition, (33554432 & i2) != 0 ? null : divAppearanceTransition2, (67108864 & i2) != 0 ? null : list17, (134217728 & i2) != 0 ? UNDERLINE_DEFAULT_VALUE : expression26, (268435456 & i2) != 0 ? null : list18, (536870912 & i2) != 0 ? null : list19, (1073741824 & i2) != 0 ? VISIBILITY_DEFAULT_VALUE : expression27, (i2 & Integer.MIN_VALUE) != 0 ? null : divVisibilityAction, (i3 & 1) != 0 ? null : list20, (i3 & 2) != 0 ? WIDTH_DEFAULT_VALUE : divSize2);
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
        int iHash17;
        int iHash18;
        Integer num = this._hash;
        if (num != null) {
            return num.intValue();
        }
        int iHashCode = Reflection.getOrCreateKotlinClass(getClass()).hashCode();
        DivAccessibility accessibility = getAccessibility();
        int iHash19 = 0;
        int iHash20 = iHashCode + (accessibility != null ? accessibility.hash() : 0);
        DivAction divAction = this.action;
        int iHash21 = iHash20 + (divAction != null ? divAction.hash() : 0) + this.actionAnimation.hash();
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
        int i = iHash21 + iHash;
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
        Expression<Boolean> expression = this.autoEllipsize;
        int iHashCode4 = i2 + (expression != null ? expression.hashCode() : 0);
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
        int i3 = iHashCode4 + iHash3;
        DivBorder border = getBorder();
        int iHash22 = i3 + (border != null ? border.hash() : 0);
        Expression<Long> columnSpan = getColumnSpan();
        int iHashCode5 = iHash22 + (columnSpan != null ? columnSpan.hashCode() : 0);
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
        int i4 = iHashCode5 + iHash4;
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
        Ellipsis ellipsis = this.ellipsis;
        int iHash23 = i5 + (ellipsis != null ? ellipsis.hash() : 0);
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
        int i6 = iHash23 + iHash6;
        DivFocus focus = getFocus();
        int iHash24 = i6 + (focus != null ? focus.hash() : 0);
        Expression<Integer> expression2 = this.focusedTextColor;
        int iHashCode6 = iHash24 + (expression2 != null ? expression2.hashCode() : 0);
        Expression<String> expression3 = this.fontFamily;
        int iHashCode7 = iHashCode6 + (expression3 != null ? expression3.hashCode() : 0);
        Expression<String> expression4 = this.fontFeatureSettings;
        int iHashCode8 = iHashCode7 + (expression4 != null ? expression4.hashCode() : 0) + this.fontSize.hashCode() + this.fontSizeUnit.hashCode() + this.fontWeight.hashCode();
        Expression<Long> expression5 = this.fontWeightValue;
        int iHashCode9 = iHashCode8 + (expression5 != null ? expression5.hashCode() : 0);
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
        int iHash25 = iHashCode9 + iHash7 + getHeight().hash();
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
        int i7 = iHash25 + iHash8;
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
        int iHashCode10 = i8 + (id != null ? id.hashCode() : 0);
        List<Image> list5 = this.images;
        if (list5 != null) {
            Iterator<T> it10 = list5.iterator();
            iHash10 = 0;
            while (it10.hasNext()) {
                iHash10 += ((Image) it10.next()).hash();
            }
        } else {
            iHash10 = 0;
        }
        int i9 = iHashCode10 + iHash10;
        DivLayoutProvider layoutProvider = getLayoutProvider();
        int iHash26 = i9 + (layoutProvider != null ? layoutProvider.hash() : 0) + this.letterSpacing.hashCode();
        Expression<Long> expression6 = this.lineHeight;
        int iHashCode11 = iHash26 + (expression6 != null ? expression6.hashCode() : 0);
        List<DivAction> list6 = this.longtapActions;
        if (list6 != null) {
            Iterator<T> it11 = list6.iterator();
            iHash11 = 0;
            while (it11.hasNext()) {
                iHash11 += ((DivAction) it11.next()).hash();
            }
        } else {
            iHash11 = 0;
        }
        int i10 = iHashCode11 + iHash11;
        DivEdgeInsets margins = getMargins();
        int iHash27 = i10 + (margins != null ? margins.hash() : 0);
        Expression<Long> expression7 = this.maxLines;
        int iHashCode12 = iHash27 + (expression7 != null ? expression7.hashCode() : 0);
        Expression<Long> expression8 = this.minHiddenLines;
        int iHashCode13 = iHashCode12 + (expression8 != null ? expression8.hashCode() : 0);
        DivEdgeInsets paddings = getPaddings();
        int iHash28 = iHashCode13 + (paddings != null ? paddings.hash() : 0);
        List<DivAction> list7 = this.pressEndActions;
        if (list7 != null) {
            Iterator<T> it12 = list7.iterator();
            iHash12 = 0;
            while (it12.hasNext()) {
                iHash12 += ((DivAction) it12.next()).hash();
            }
        } else {
            iHash12 = 0;
        }
        int i11 = iHash28 + iHash12;
        List<DivAction> list8 = this.pressStartActions;
        if (list8 != null) {
            Iterator<T> it13 = list8.iterator();
            iHash13 = 0;
            while (it13.hasNext()) {
                iHash13 += ((DivAction) it13.next()).hash();
            }
        } else {
            iHash13 = 0;
        }
        int i12 = i11 + iHash13;
        List<Range> list9 = this.ranges;
        if (list9 != null) {
            Iterator<T> it14 = list9.iterator();
            iHash14 = 0;
            while (it14.hasNext()) {
                iHash14 += ((Range) it14.next()).hash();
            }
        } else {
            iHash14 = 0;
        }
        int i13 = i12 + iHash14;
        Expression<String> reuseId = getReuseId();
        int iHashCode14 = i13 + (reuseId != null ? reuseId.hashCode() : 0);
        Expression<Long> rowSpan = getRowSpan();
        int iHashCode15 = iHashCode14 + (rowSpan != null ? rowSpan.hashCode() : 0) + this.selectable.hashCode();
        List<DivAction> selectedActions = getSelectedActions();
        if (selectedActions != null) {
            Iterator<T> it15 = selectedActions.iterator();
            iHash15 = 0;
            while (it15.hasNext()) {
                iHash15 += ((DivAction) it15.next()).hash();
            }
        } else {
            iHash15 = 0;
        }
        int iHashCode16 = iHashCode15 + iHash15 + this.strike.hashCode() + this.text.hashCode() + this.textAlignmentHorizontal.hashCode() + this.textAlignmentVertical.hashCode() + this.textColor.hashCode();
        DivTextGradient divTextGradient = this.textGradient;
        int iHash29 = iHashCode16 + (divTextGradient != null ? divTextGradient.hash() : 0);
        DivShadow divShadow = this.textShadow;
        int iHash30 = iHash29 + (divShadow != null ? divShadow.hash() : 0) + this.tightenWidth.hashCode();
        List<DivTooltip> tooltips = getTooltips();
        if (tooltips != null) {
            Iterator<T> it16 = tooltips.iterator();
            iHash16 = 0;
            while (it16.hasNext()) {
                iHash16 += ((DivTooltip) it16.next()).hash();
            }
        } else {
            iHash16 = 0;
        }
        int i14 = iHash30 + iHash16;
        DivTransform transform = getTransform();
        int iHash31 = i14 + (transform != null ? transform.hash() : 0);
        DivChangeTransition transitionChange = getTransitionChange();
        int iHash32 = iHash31 + (transitionChange != null ? transitionChange.hash() : 0);
        DivAppearanceTransition transitionIn = getTransitionIn();
        int iHash33 = iHash32 + (transitionIn != null ? transitionIn.hash() : 0);
        DivAppearanceTransition transitionOut = getTransitionOut();
        int iHash34 = iHash33 + (transitionOut != null ? transitionOut.hash() : 0);
        List<DivTransitionTrigger> transitionTriggers = getTransitionTriggers();
        int iHashCode17 = iHash34 + (transitionTriggers != null ? transitionTriggers.hashCode() : 0) + this.underline.hashCode();
        List<DivTrigger> variableTriggers = getVariableTriggers();
        if (variableTriggers != null) {
            Iterator<T> it17 = variableTriggers.iterator();
            iHash17 = 0;
            while (it17.hasNext()) {
                iHash17 += ((DivTrigger) it17.next()).hash();
            }
        } else {
            iHash17 = 0;
        }
        int i15 = iHashCode17 + iHash17;
        List<DivVariable> variables = getVariables();
        if (variables != null) {
            Iterator<T> it18 = variables.iterator();
            iHash18 = 0;
            while (it18.hasNext()) {
                iHash18 += ((DivVariable) it18.next()).hash();
            }
        } else {
            iHash18 = 0;
        }
        int iHashCode18 = i15 + iHash18 + getVisibility().hashCode();
        DivVisibilityAction visibilityAction = getVisibilityAction();
        int iHash35 = iHashCode18 + (visibilityAction != null ? visibilityAction.hash() : 0);
        List<DivVisibilityAction> visibilityActions = getVisibilityActions();
        if (visibilityActions != null) {
            Iterator<T> it19 = visibilityActions.iterator();
            while (it19.hasNext()) {
                iHash19 += ((DivVisibilityAction) it19.next()).hash();
            }
        }
        int iHash36 = iHash35 + iHash19 + getWidth().hash();
        this._hash = Integer.valueOf(iHash36);
        return iHash36;
    }

    public final boolean equals(DivText other, ExpressionResolver resolver, ExpressionResolver otherResolver) {
        boolean zEquals;
        boolean zEquals2;
        boolean z;
        boolean z2;
        boolean z3;
        boolean zEquals3;
        boolean z4;
        boolean z5;
        boolean zEquals4;
        boolean z6;
        boolean zEquals5;
        boolean z7;
        boolean z8;
        boolean z9;
        boolean z10;
        boolean zEquals6;
        boolean z11;
        boolean zEquals7;
        boolean zEquals8;
        boolean z12;
        boolean z13;
        boolean z14;
        boolean z15;
        boolean zEquals9;
        boolean zEquals10;
        boolean z16;
        boolean zEquals11;
        boolean zEquals12;
        boolean zEquals13;
        boolean zEquals14;
        boolean z17;
        boolean z18;
        boolean z19;
        boolean zEquals15;
        boolean z20;
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
        Expression<Boolean> expression = this.autoEllipsize;
        Boolean boolEvaluate = expression != null ? expression.evaluate(resolver) : null;
        Expression<Boolean> expression2 = other.autoEllipsize;
        if (!Intrinsics.areEqual(boolEvaluate, expression2 != null ? expression2.evaluate(otherResolver) : null)) {
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
        Ellipsis ellipsis = this.ellipsis;
        if (ellipsis != null) {
            zEquals4 = ellipsis.equals(other.ellipsis, resolver, otherResolver);
        } else {
            zEquals4 = other.ellipsis == null;
        }
        if (!zEquals4) {
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
        Expression<Integer> expression3 = this.focusedTextColor;
        Integer numEvaluate = expression3 != null ? expression3.evaluate(resolver) : null;
        Expression<Integer> expression4 = other.focusedTextColor;
        if (!Intrinsics.areEqual(numEvaluate, expression4 != null ? expression4.evaluate(otherResolver) : null)) {
            return false;
        }
        Expression<String> expression5 = this.fontFamily;
        String strEvaluate = expression5 != null ? expression5.evaluate(resolver) : null;
        Expression<String> expression6 = other.fontFamily;
        if (!Intrinsics.areEqual(strEvaluate, expression6 != null ? expression6.evaluate(otherResolver) : null)) {
            return false;
        }
        Expression<String> expression7 = this.fontFeatureSettings;
        String strEvaluate2 = expression7 != null ? expression7.evaluate(resolver) : null;
        Expression<String> expression8 = other.fontFeatureSettings;
        if (!Intrinsics.areEqual(strEvaluate2, expression8 != null ? expression8.evaluate(otherResolver) : null) || this.fontSize.evaluate(resolver).longValue() != other.fontSize.evaluate(otherResolver).longValue() || this.fontSizeUnit.evaluate(resolver) != other.fontSizeUnit.evaluate(otherResolver) || this.fontWeight.evaluate(resolver) != other.fontWeight.evaluate(otherResolver)) {
            return false;
        }
        Expression<Long> expression9 = this.fontWeightValue;
        Long lEvaluate2 = expression9 != null ? expression9.evaluate(resolver) : null;
        Expression<Long> expression10 = other.fontWeightValue;
        if (!Intrinsics.areEqual(lEvaluate2, expression10 != null ? expression10.evaluate(otherResolver) : null)) {
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
        List<Image> list9 = this.images;
        if (list9 != null) {
            List<Image> list10 = other.images;
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
                        if (((Image) next10).equals(list10.get(i19), resolver, otherResolver)) {
                            i19 = i20;
                        }
                    }
                }
            }
        } else {
            z10 = other.images == null;
        }
        if (!z10) {
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
        if (!(this.letterSpacing.evaluate(resolver).doubleValue() == other.letterSpacing.evaluate(otherResolver).doubleValue())) {
            return false;
        }
        Expression<Long> expression11 = this.lineHeight;
        Long lEvaluate3 = expression11 != null ? expression11.evaluate(resolver) : null;
        Expression<Long> expression12 = other.lineHeight;
        if (!Intrinsics.areEqual(lEvaluate3, expression12 != null ? expression12.evaluate(otherResolver) : null)) {
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
            zEquals7 = margins.equals(other.getMargins(), resolver, otherResolver);
        } else {
            zEquals7 = other.getMargins() == null;
        }
        if (!zEquals7) {
            return false;
        }
        Expression<Long> expression13 = this.maxLines;
        Long lEvaluate4 = expression13 != null ? expression13.evaluate(resolver) : null;
        Expression<Long> expression14 = other.maxLines;
        if (!Intrinsics.areEqual(lEvaluate4, expression14 != null ? expression14.evaluate(otherResolver) : null)) {
            return false;
        }
        Expression<Long> expression15 = this.minHiddenLines;
        Long lEvaluate5 = expression15 != null ? expression15.evaluate(resolver) : null;
        Expression<Long> expression16 = other.minHiddenLines;
        if (!Intrinsics.areEqual(lEvaluate5, expression16 != null ? expression16.evaluate(otherResolver) : null)) {
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
        List<Range> list17 = this.ranges;
        if (list17 != null) {
            List<Range> list18 = other.ranges;
            if (list18 == null) {
                return false;
            }
            if (list17.size() == list18.size()) {
                Iterator<T> it14 = list17.iterator();
                int i27 = 0;
                while (true) {
                    if (it14.hasNext()) {
                        Object next14 = it14.next();
                        int i28 = i27 + 1;
                        if (i27 < 0) {
                            CollectionsKt.throwIndexOverflow();
                        }
                        if (((Range) next14).equals(list18.get(i27), resolver, otherResolver)) {
                            i27 = i28;
                        }
                    }
                }
            }
        } else {
            z14 = other.ranges == null;
        }
        if (!z14) {
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
        if (!Intrinsics.areEqual(lEvaluate6, rowSpan2 != null ? rowSpan2.evaluate(otherResolver) : null) || this.selectable.evaluate(resolver).booleanValue() != other.selectable.evaluate(otherResolver).booleanValue()) {
            return false;
        }
        List<DivAction> selectedActions = getSelectedActions();
        if (selectedActions != null) {
            List<DivAction> selectedActions2 = other.getSelectedActions();
            if (selectedActions2 == null) {
                return false;
            }
            if (selectedActions.size() == selectedActions2.size()) {
                Iterator<T> it15 = selectedActions.iterator();
                int i29 = 0;
                while (true) {
                    if (it15.hasNext()) {
                        Object next15 = it15.next();
                        int i30 = i29 + 1;
                        if (i29 < 0) {
                            CollectionsKt.throwIndexOverflow();
                        }
                        if (((DivAction) next15).equals(selectedActions2.get(i29), resolver, otherResolver)) {
                            i29 = i30;
                        }
                    }
                }
            }
        } else {
            z15 = other.getSelectedActions() == null;
        }
        if (!z15 || this.strike.evaluate(resolver) != other.strike.evaluate(otherResolver) || !Intrinsics.areEqual(this.text.evaluate(resolver), other.text.evaluate(otherResolver)) || this.textAlignmentHorizontal.evaluate(resolver) != other.textAlignmentHorizontal.evaluate(otherResolver) || this.textAlignmentVertical.evaluate(resolver) != other.textAlignmentVertical.evaluate(otherResolver) || this.textColor.evaluate(resolver).intValue() != other.textColor.evaluate(otherResolver).intValue()) {
            return false;
        }
        DivTextGradient divTextGradient = this.textGradient;
        if (divTextGradient != null) {
            zEquals9 = divTextGradient.equals(other.textGradient, resolver, otherResolver);
        } else {
            zEquals9 = other.textGradient == null;
        }
        if (!zEquals9) {
            return false;
        }
        DivShadow divShadow = this.textShadow;
        if (divShadow != null) {
            zEquals10 = divShadow.equals(other.textShadow, resolver, otherResolver);
        } else {
            zEquals10 = other.textShadow == null;
        }
        if (!zEquals10 || this.tightenWidth.evaluate(resolver).booleanValue() != other.tightenWidth.evaluate(otherResolver).booleanValue()) {
            return false;
        }
        List<DivTooltip> tooltips = getTooltips();
        if (tooltips != null) {
            List<DivTooltip> tooltips2 = other.getTooltips();
            if (tooltips2 == null) {
                return false;
            }
            if (tooltips.size() == tooltips2.size()) {
                Iterator<T> it16 = tooltips.iterator();
                int i31 = 0;
                while (true) {
                    if (it16.hasNext()) {
                        Object next16 = it16.next();
                        int i32 = i31 + 1;
                        if (i31 < 0) {
                            CollectionsKt.throwIndexOverflow();
                        }
                        if (((DivTooltip) next16).equals(tooltips2.get(i31), resolver, otherResolver)) {
                            i31 = i32;
                        }
                    }
                }
            }
        } else {
            z16 = other.getTooltips() == null;
        }
        if (!z16) {
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
                Iterator<T> it17 = transitionTriggers.iterator();
                int i33 = 0;
                while (true) {
                    if (it17.hasNext()) {
                        Object next17 = it17.next();
                        int i34 = i33 + 1;
                        if (i33 < 0) {
                            CollectionsKt.throwIndexOverflow();
                        }
                        if (((DivTransitionTrigger) next17) == transitionTriggers2.get(i33)) {
                            i33 = i34;
                        }
                    }
                }
            }
        } else {
            z17 = other.getTransitionTriggers() == null;
        }
        if (!z17 || this.underline.evaluate(resolver) != other.underline.evaluate(otherResolver)) {
            return false;
        }
        List<DivTrigger> variableTriggers = getVariableTriggers();
        if (variableTriggers != null) {
            List<DivTrigger> variableTriggers2 = other.getVariableTriggers();
            if (variableTriggers2 == null) {
                return false;
            }
            if (variableTriggers.size() == variableTriggers2.size()) {
                Iterator<T> it18 = variableTriggers.iterator();
                int i35 = 0;
                while (true) {
                    if (it18.hasNext()) {
                        Object next18 = it18.next();
                        int i36 = i35 + 1;
                        if (i35 < 0) {
                            CollectionsKt.throwIndexOverflow();
                        }
                        if (((DivTrigger) next18).equals(variableTriggers2.get(i35), resolver, otherResolver)) {
                            i35 = i36;
                        }
                    }
                }
            }
        } else {
            z18 = other.getVariableTriggers() == null;
        }
        if (!z18) {
            return false;
        }
        List<DivVariable> variables = getVariables();
        if (variables != null) {
            List<DivVariable> variables2 = other.getVariables();
            if (variables2 == null) {
                return false;
            }
            if (variables.size() == variables2.size()) {
                Iterator<T> it19 = variables.iterator();
                int i37 = 0;
                while (true) {
                    if (it19.hasNext()) {
                        Object next19 = it19.next();
                        int i38 = i37 + 1;
                        if (i37 < 0) {
                            CollectionsKt.throwIndexOverflow();
                        }
                        if (((DivVariable) next19).equals(variables2.get(i37), resolver, otherResolver)) {
                            i37 = i38;
                        }
                    }
                }
            }
        } else {
            z19 = other.getVariables() == null;
        }
        if (!z19 || getVisibility().evaluate(resolver) != other.getVisibility().evaluate(otherResolver)) {
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
                Iterator<T> it20 = visibilityActions.iterator();
                int i39 = 0;
                while (true) {
                    if (it20.hasNext()) {
                        Object next20 = it20.next();
                        int i40 = i39 + 1;
                        if (i39 < 0) {
                            CollectionsKt.throwIndexOverflow();
                        }
                        if (((DivVisibilityAction) next20).equals(visibilityActions2.get(i39), resolver, otherResolver)) {
                            i39 = i40;
                        }
                    }
                }
            }
        } else {
            z20 = other.getVisibilityActions() == null;
        }
        return z20 && getWidth().equals(other.getWidth(), resolver, otherResolver);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ DivText copy$default(DivText divText, DivAccessibility divAccessibility, DivAction divAction, DivAnimation divAnimation, List list, Expression expression, Expression expression2, Expression expression3, List list2, Expression expression4, List list3, DivBorder divBorder, Expression expression5, List list4, List list5, Ellipsis ellipsis, List list6, DivFocus divFocus, Expression expression6, Expression expression7, Expression expression8, Expression expression9, Expression expression10, Expression expression11, Expression expression12, List list7, DivSize divSize, List list8, List list9, String str, List list10, DivLayoutProvider divLayoutProvider, Expression expression13, Expression expression14, List list11, DivEdgeInsets divEdgeInsets, Expression expression15, Expression expression16, DivEdgeInsets divEdgeInsets2, List list12, List list13, List list14, Expression expression17, Expression expression18, Expression expression19, List list15, Expression expression20, Expression expression21, Expression expression22, Expression expression23, Expression expression24, DivTextGradient divTextGradient, DivShadow divShadow, Expression expression25, List list16, DivTransform divTransform, DivChangeTransition divChangeTransition, DivAppearanceTransition divAppearanceTransition, DivAppearanceTransition divAppearanceTransition2, List list17, Expression expression26, List list18, List list19, Expression expression27, DivVisibilityAction divVisibilityAction, List list20, DivSize divSize2, int i, int i2, int i3, Object obj) {
        DivAccessibility accessibility = (i & 1) != 0 ? divText.getAccessibility() : divAccessibility;
        DivAction divAction2 = (i & 2) != 0 ? divText.action : divAction;
        DivAnimation divAnimation2 = (i & 4) != 0 ? divText.actionAnimation : divAnimation;
        List list21 = (i & 8) != 0 ? divText.actions : list;
        Expression alignmentHorizontal = (i & 16) != 0 ? divText.getAlignmentHorizontal() : expression;
        Expression alignmentVertical = (i & 32) != 0 ? divText.getAlignmentVertical() : expression2;
        Expression alpha = (i & 64) != 0 ? divText.getAlpha() : expression3;
        List animators = (i & 128) != 0 ? divText.getAnimators() : list2;
        Expression expression28 = (i & 256) != 0 ? divText.autoEllipsize : expression4;
        List background = (i & 512) != 0 ? divText.getBackground() : list3;
        DivBorder border = (i & 1024) != 0 ? divText.getBorder() : divBorder;
        Expression columnSpan = (i & 2048) != 0 ? divText.getColumnSpan() : expression5;
        List disappearActions = (i & 4096) != 0 ? divText.getDisappearActions() : list4;
        List list22 = (i & 8192) != 0 ? divText.doubletapActions : list5;
        Ellipsis ellipsis2 = (i & 16384) != 0 ? divText.ellipsis : ellipsis;
        List extensions = (i & 32768) != 0 ? divText.getExtensions() : list6;
        DivFocus focus = (i & 65536) != 0 ? divText.getFocus() : divFocus;
        Ellipsis ellipsis3 = ellipsis2;
        Expression expression29 = (i & 131072) != 0 ? divText.focusedTextColor : expression6;
        Expression expression30 = (i & 262144) != 0 ? divText.fontFamily : expression7;
        Expression expression31 = (i & 524288) != 0 ? divText.fontFeatureSettings : expression8;
        Expression expression32 = (i & 1048576) != 0 ? divText.fontSize : expression9;
        Expression expression33 = (i & 2097152) != 0 ? divText.fontSizeUnit : expression10;
        Expression expression34 = (i & 4194304) != 0 ? divText.fontWeight : expression11;
        Expression expression35 = (i & 8388608) != 0 ? divText.fontWeightValue : expression12;
        List functions = (i & 16777216) != 0 ? divText.getFunctions() : list7;
        DivSize height = (i & 33554432) != 0 ? divText.getHeight() : divSize;
        Expression expression36 = expression35;
        List list23 = (i & 67108864) != 0 ? divText.hoverEndActions : list8;
        List list24 = (i & 134217728) != 0 ? divText.hoverStartActions : list9;
        String id = (i & 268435456) != 0 ? divText.getId() : str;
        List list25 = list24;
        List list26 = (i & 536870912) != 0 ? divText.images : list10;
        DivLayoutProvider layoutProvider = (i & 1073741824) != 0 ? divText.getLayoutProvider() : divLayoutProvider;
        Expression expression37 = (i & Integer.MIN_VALUE) != 0 ? divText.letterSpacing : expression13;
        Expression expression38 = (i2 & 1) != 0 ? divText.lineHeight : expression14;
        List list27 = (i2 & 2) != 0 ? divText.longtapActions : list11;
        DivEdgeInsets margins = (i2 & 4) != 0 ? divText.getMargins() : divEdgeInsets;
        List list28 = list27;
        Expression expression39 = (i2 & 8) != 0 ? divText.maxLines : expression15;
        Expression expression40 = (i2 & 16) != 0 ? divText.minHiddenLines : expression16;
        return divText.copy(accessibility, divAction2, divAnimation2, list21, alignmentHorizontal, alignmentVertical, alpha, animators, expression28, background, border, columnSpan, disappearActions, list22, ellipsis3, extensions, focus, expression29, expression30, expression31, expression32, expression33, expression34, expression36, functions, height, list23, list25, id, list26, layoutProvider, expression37, expression38, list28, margins, expression39, expression40, (i2 & 32) != 0 ? divText.getPaddings() : divEdgeInsets2, (i2 & 64) != 0 ? divText.pressEndActions : list12, (i2 & 128) != 0 ? divText.pressStartActions : list13, (i2 & 256) != 0 ? divText.ranges : list14, (i2 & 512) != 0 ? divText.getReuseId() : expression17, (i2 & 1024) != 0 ? divText.getRowSpan() : expression18, (i2 & 2048) != 0 ? divText.selectable : expression19, (i2 & 4096) != 0 ? divText.getSelectedActions() : list15, (i2 & 8192) != 0 ? divText.strike : expression20, (i2 & 16384) != 0 ? divText.text : expression21, (i2 & 32768) != 0 ? divText.textAlignmentHorizontal : expression22, (i2 & 65536) != 0 ? divText.textAlignmentVertical : expression23, (i2 & 131072) != 0 ? divText.textColor : expression24, (i2 & 262144) != 0 ? divText.textGradient : divTextGradient, (i2 & 524288) != 0 ? divText.textShadow : divShadow, (i2 & 1048576) != 0 ? divText.tightenWidth : expression25, (i2 & 2097152) != 0 ? divText.getTooltips() : list16, (i2 & 4194304) != 0 ? divText.getTransform() : divTransform, (i2 & 8388608) != 0 ? divText.getTransitionChange() : divChangeTransition, (i2 & 16777216) != 0 ? divText.getTransitionIn() : divAppearanceTransition, (i2 & 33554432) != 0 ? divText.getTransitionOut() : divAppearanceTransition2, (i2 & 67108864) != 0 ? divText.getTransitionTriggers() : list17, (i2 & 134217728) != 0 ? divText.underline : expression26, (i2 & 268435456) != 0 ? divText.getVariableTriggers() : list18, (i2 & 536870912) != 0 ? divText.getVariables() : list19, (i2 & 1073741824) != 0 ? divText.getVisibility() : expression27, (i2 & Integer.MIN_VALUE) != 0 ? divText.getVisibilityAction() : divVisibilityAction, (i3 & 1) != 0 ? divText.getVisibilityActions() : list20, (i3 & 2) != 0 ? divText.getWidth() : divSize2);
    }

    public final DivText copy(DivAccessibility accessibility, DivAction action, DivAnimation actionAnimation, List<DivAction> actions, Expression<DivAlignmentHorizontal> alignmentHorizontal, Expression<DivAlignmentVertical> alignmentVertical, Expression<Double> alpha, List<? extends DivAnimator> animators, Expression<Boolean> autoEllipsize, List<? extends DivBackground> background, DivBorder border, Expression<Long> columnSpan, List<DivDisappearAction> disappearActions, List<DivAction> doubletapActions, Ellipsis ellipsis, List<DivExtension> extensions, DivFocus focus, Expression<Integer> focusedTextColor, Expression<String> fontFamily, Expression<String> fontFeatureSettings, Expression<Long> fontSize, Expression<DivSizeUnit> fontSizeUnit, Expression<DivFontWeight> fontWeight, Expression<Long> fontWeightValue, List<DivFunction> functions, DivSize height, List<DivAction> hoverEndActions, List<DivAction> hoverStartActions, String id, List<Image> images, DivLayoutProvider layoutProvider, Expression<Double> letterSpacing, Expression<Long> lineHeight, List<DivAction> longtapActions, DivEdgeInsets margins, Expression<Long> maxLines, Expression<Long> minHiddenLines, DivEdgeInsets paddings, List<DivAction> pressEndActions, List<DivAction> pressStartActions, List<Range> ranges, Expression<String> reuseId, Expression<Long> rowSpan, Expression<Boolean> selectable, List<DivAction> selectedActions, Expression<DivLineStyle> strike, Expression<String> text, Expression<DivAlignmentHorizontal> textAlignmentHorizontal, Expression<DivAlignmentVertical> textAlignmentVertical, Expression<Integer> textColor, DivTextGradient textGradient, DivShadow textShadow, Expression<Boolean> tightenWidth, List<DivTooltip> tooltips, DivTransform transform, DivChangeTransition transitionChange, DivAppearanceTransition transitionIn, DivAppearanceTransition transitionOut, List<? extends DivTransitionTrigger> transitionTriggers, Expression<DivLineStyle> underline, List<DivTrigger> variableTriggers, List<? extends DivVariable> variables, Expression<DivVisibility> visibility, DivVisibilityAction visibilityAction, List<DivVisibilityAction> visibilityActions, DivSize width) {
        Intrinsics.checkNotNullParameter(actionAnimation, "actionAnimation");
        Intrinsics.checkNotNullParameter(alpha, "alpha");
        Intrinsics.checkNotNullParameter(fontSize, "fontSize");
        Intrinsics.checkNotNullParameter(fontSizeUnit, "fontSizeUnit");
        Intrinsics.checkNotNullParameter(fontWeight, "fontWeight");
        Intrinsics.checkNotNullParameter(height, "height");
        Intrinsics.checkNotNullParameter(letterSpacing, "letterSpacing");
        Intrinsics.checkNotNullParameter(selectable, "selectable");
        Intrinsics.checkNotNullParameter(strike, "strike");
        Intrinsics.checkNotNullParameter(text, "text");
        Intrinsics.checkNotNullParameter(textAlignmentHorizontal, "textAlignmentHorizontal");
        Intrinsics.checkNotNullParameter(textAlignmentVertical, "textAlignmentVertical");
        Intrinsics.checkNotNullParameter(textColor, "textColor");
        Intrinsics.checkNotNullParameter(tightenWidth, "tightenWidth");
        Intrinsics.checkNotNullParameter(underline, "underline");
        Intrinsics.checkNotNullParameter(visibility, "visibility");
        Intrinsics.checkNotNullParameter(width, "width");
        return new DivText(accessibility, action, actionAnimation, actions, alignmentHorizontal, alignmentVertical, alpha, animators, autoEllipsize, background, border, columnSpan, disappearActions, doubletapActions, ellipsis, extensions, focus, focusedTextColor, fontFamily, fontFeatureSettings, fontSize, fontSizeUnit, fontWeight, fontWeightValue, functions, height, hoverEndActions, hoverStartActions, id, images, layoutProvider, letterSpacing, lineHeight, longtapActions, margins, maxLines, minHiddenLines, paddings, pressEndActions, pressStartActions, ranges, reuseId, rowSpan, selectable, selectedActions, strike, text, textAlignmentHorizontal, textAlignmentVertical, textColor, textGradient, textShadow, tightenWidth, tooltips, transform, transitionChange, transitionIn, transitionOut, transitionTriggers, underline, variableTriggers, variables, visibility, visibilityAction, visibilityActions, width);
    }

    @Override // com.yandex.div.json.JSONSerializable
    public JSONObject writeToJSON() {
        return BuiltInParserKt.getBuiltInParserComponent().getDivTextJsonEntityParser().getValue().serialize(BuiltInParserKt.getBuiltInParsingContext(), this);
    }

    /* JADX INFO: compiled from: DivText.kt */
    @Metadata(d1 = {"\u0000\u0080\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0006\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u001e\u0010*\u001a\u00020\f2\u0006\u0010+\u001a\u00020\n2\u0006\u0010,\u001a\u00020\u000bH\u0087\u0002¢\u0006\u0002\b-R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R#\u0010\b\u001a\u0014\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\f0\t¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0014\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00100\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00120\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00140\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0016X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00190\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u001b0\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u001d0\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u001f0\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010 \u001a\b\u0012\u0004\u0012\u00020!0\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\"\u001a\b\u0012\u0004\u0012\u00020\u00190\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010#\u001a\u00020$X\u0086T¢\u0006\u0002\n\u0000R\u0014\u0010%\u001a\b\u0012\u0004\u0012\u00020\u001b0\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010&\u001a\b\u0012\u0004\u0012\u00020'0\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010(\u001a\u00020)X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006."}, d2 = {"Lcom/yandex/div2/DivText$Companion;", "", "()V", "ACTION_ANIMATION_DEFAULT_VALUE", "Lcom/yandex/div2/DivAnimation;", "ALPHA_DEFAULT_VALUE", "Lcom/yandex/div/json/expressions/Expression;", "", "CREATOR", "Lkotlin/Function2;", "Lcom/yandex/div/json/ParsingEnvironment;", "Lorg/json/JSONObject;", "Lcom/yandex/div2/DivText;", "getCREATOR", "()Lkotlin/jvm/functions/Function2;", "FONT_SIZE_DEFAULT_VALUE", "", "FONT_SIZE_UNIT_DEFAULT_VALUE", "Lcom/yandex/div2/DivSizeUnit;", "FONT_WEIGHT_DEFAULT_VALUE", "Lcom/yandex/div2/DivFontWeight;", "HEIGHT_DEFAULT_VALUE", "Lcom/yandex/div2/DivSize$WrapContent;", "LETTER_SPACING_DEFAULT_VALUE", "SELECTABLE_DEFAULT_VALUE", "", "STRIKE_DEFAULT_VALUE", "Lcom/yandex/div2/DivLineStyle;", "TEXT_ALIGNMENT_HORIZONTAL_DEFAULT_VALUE", "Lcom/yandex/div2/DivAlignmentHorizontal;", "TEXT_ALIGNMENT_VERTICAL_DEFAULT_VALUE", "Lcom/yandex/div2/DivAlignmentVertical;", "TEXT_COLOR_DEFAULT_VALUE", "", "TIGHTEN_WIDTH_DEFAULT_VALUE", "TYPE", "", "UNDERLINE_DEFAULT_VALUE", "VISIBILITY_DEFAULT_VALUE", "Lcom/yandex/div2/DivVisibility;", "WIDTH_DEFAULT_VALUE", "Lcom/yandex/div2/DivSize$MatchParent;", "invoke", cc.o, "json", "fromJson", "div-data_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @JvmStatic
        public final DivText fromJson(ParsingEnvironment env, JSONObject json) {
            Intrinsics.checkNotNullParameter(env, "env");
            Intrinsics.checkNotNullParameter(json, "json");
            return BuiltInParserKt.getBuiltInParserComponent().getDivTextJsonEntityParser().getValue().deserialize((ParsingContext) env, json);
        }

        public final Function2<ParsingEnvironment, JSONObject, DivText> getCREATOR() {
            return DivText.CREATOR;
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
        FONT_SIZE_DEFAULT_VALUE = Expression.INSTANCE.constant(12L);
        FONT_SIZE_UNIT_DEFAULT_VALUE = Expression.INSTANCE.constant(DivSizeUnit.SP);
        FONT_WEIGHT_DEFAULT_VALUE = Expression.INSTANCE.constant(DivFontWeight.REGULAR);
        HEIGHT_DEFAULT_VALUE = new DivSize.WrapContent(new DivWrapContentSize(null, null, 0 == true ? 1 : 0, 7, null));
        LETTER_SPACING_DEFAULT_VALUE = Expression.INSTANCE.constant(Double.valueOf(0.0d));
        SELECTABLE_DEFAULT_VALUE = Expression.INSTANCE.constant(false);
        STRIKE_DEFAULT_VALUE = Expression.INSTANCE.constant(DivLineStyle.NONE);
        TEXT_ALIGNMENT_HORIZONTAL_DEFAULT_VALUE = Expression.INSTANCE.constant(DivAlignmentHorizontal.START);
        TEXT_ALIGNMENT_VERTICAL_DEFAULT_VALUE = Expression.INSTANCE.constant(DivAlignmentVertical.TOP);
        TEXT_COLOR_DEFAULT_VALUE = Expression.INSTANCE.constant(Integer.valueOf(ViewCompat.MEASURED_STATE_MASK));
        TIGHTEN_WIDTH_DEFAULT_VALUE = Expression.INSTANCE.constant(false);
        UNDERLINE_DEFAULT_VALUE = Expression.INSTANCE.constant(DivLineStyle.NONE);
        VISIBILITY_DEFAULT_VALUE = Expression.INSTANCE.constant(DivVisibility.VISIBLE);
        WIDTH_DEFAULT_VALUE = new DivSize.MatchParent(new DivMatchParentSize(0 == true ? 1 : 0, 1, 0 == true ? 1 : 0));
        CREATOR = new Function2<ParsingEnvironment, JSONObject, DivText>() { // from class: com.yandex.div2.DivText$Companion$CREATOR$1
            @Override // kotlin.jvm.functions.Function2
            public final DivText invoke(ParsingEnvironment env, JSONObject it) {
                Intrinsics.checkNotNullParameter(env, "env");
                Intrinsics.checkNotNullParameter(it, "it");
                return DivText.INSTANCE.fromJson(env, it);
            }
        };
    }

    /* JADX INFO: compiled from: DivText.kt */
    @Metadata(d1 = {"\u0000\u0084\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0006\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 42\u00020\u00012\u00020\u0002:\u00014Bã\u0002\b\u0007\u0012\u0010\b\u0002\u0010\u0003\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0004\u0012\u0010\b\u0002\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n\u0012\u000e\b\u0002\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\f0\u0007\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000e\u0012\u0010\b\u0002\u0010\u000f\u001a\n\u0012\u0004\u0012\u00020\u0010\u0018\u00010\u0007\u0012\u0010\b\u0002\u0010\u0011\u001a\n\u0012\u0004\u0012\u00020\u0012\u0018\u00010\u0007\u0012\u0010\b\u0002\u0010\u0013\u001a\n\u0012\u0004\u0012\u00020\u0012\u0018\u00010\u0007\u0012\u0010\b\u0002\u0010\u0014\u001a\n\u0012\u0004\u0012\u00020\u0010\u0018\u00010\u0007\u0012\u000e\b\u0002\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00160\u0007\u0012\u0010\b\u0002\u0010\u0017\u001a\n\u0012\u0004\u0012\u00020\u0018\u0018\u00010\u0007\u0012\u0010\b\u0002\u0010\u0019\u001a\n\u0012\u0004\u0012\u00020\u0010\u0018\u00010\u0007\u0012\u0010\b\u0002\u0010\u001a\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u0007\u0012\u0010\b\u0002\u0010\u001b\u001a\n\u0012\u0004\u0012\u00020\u0010\u0018\u00010\u0007\u0012\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\u001d\u0012\u000e\b\u0002\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u00100\u0007\u0012\u0010\b\u0002\u0010\u001f\u001a\n\u0012\u0004\u0012\u00020 \u0018\u00010\u0007\u0012\u0010\b\u0002\u0010!\u001a\n\u0012\u0004\u0012\u00020\"\u0018\u00010\u0007\u0012\n\b\u0002\u0010#\u001a\u0004\u0018\u00010$\u0012\u0010\b\u0002\u0010%\u001a\n\u0012\u0004\u0012\u00020\u0010\u0018\u00010\u0007\u0012\u0010\b\u0002\u0010&\u001a\n\u0012\u0004\u0012\u00020 \u0018\u00010\u0007¢\u0006\u0002\u0010'Jâ\u0002\u0010*\u001a\u00020\u00002\u0010\b\u0002\u0010\u0003\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u00042\u0010\b\u0002\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u00072\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n2\u000e\b\u0002\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\f0\u00072\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000e2\u0010\b\u0002\u0010\u000f\u001a\n\u0012\u0004\u0012\u00020\u0010\u0018\u00010\u00072\u0010\b\u0002\u0010\u0011\u001a\n\u0012\u0004\u0012\u00020\u0012\u0018\u00010\u00072\u0010\b\u0002\u0010\u0013\u001a\n\u0012\u0004\u0012\u00020\u0012\u0018\u00010\u00072\u0010\b\u0002\u0010\u0014\u001a\n\u0012\u0004\u0012\u00020\u0010\u0018\u00010\u00072\u000e\b\u0002\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00160\u00072\u0010\b\u0002\u0010\u0017\u001a\n\u0012\u0004\u0012\u00020\u0018\u0018\u00010\u00072\u0010\b\u0002\u0010\u0019\u001a\n\u0012\u0004\u0012\u00020\u0010\u0018\u00010\u00072\u0010\b\u0002\u0010\u001a\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u00072\u0010\b\u0002\u0010\u001b\u001a\n\u0012\u0004\u0012\u00020\u0010\u0018\u00010\u00072\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\u001d2\u000e\b\u0002\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u00100\u00072\u0010\b\u0002\u0010\u001f\u001a\n\u0012\u0004\u0012\u00020 \u0018\u00010\u00072\u0010\b\u0002\u0010!\u001a\n\u0012\u0004\u0012\u00020\"\u0018\u00010\u00072\n\b\u0002\u0010#\u001a\u0004\u0018\u00010$2\u0010\b\u0002\u0010%\u001a\n\u0012\u0004\u0012\u00020\u0010\u0018\u00010\u00072\u0010\b\u0002\u0010&\u001a\n\u0012\u0004\u0012\u00020 \u0018\u00010\u0007J \u0010+\u001a\u00020,2\b\u0010-\u001a\u0004\u0018\u00010\u00002\u0006\u0010.\u001a\u00020/2\u0006\u00100\u001a\u00020/J\b\u00101\u001a\u00020\"H\u0016J\b\u00102\u001a\u000203H\u0016R\u0012\u0010(\u001a\u0004\u0018\u00010\"X\u0082\u000e¢\u0006\u0004\n\u0002\u0010)R\u0018\u0010\u0003\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0018\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0012\u0010\t\u001a\u0004\u0018\u00010\n8\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\f0\u00078\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0012\u0010\r\u001a\u0004\u0018\u00010\u000e8\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0018\u0010\u000f\u001a\n\u0012\u0004\u0012\u00020\u0010\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0018\u0010\u0011\u001a\n\u0012\u0004\u0012\u00020\u0012\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0018\u0010\u0013\u001a\n\u0012\u0004\u0012\u00020\u0012\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0018\u0010\u0014\u001a\n\u0012\u0004\u0012\u00020\u0010\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00160\u00078\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0018\u0010\u0017\u001a\n\u0012\u0004\u0012\u00020\u0018\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0018\u0010\u0019\u001a\n\u0012\u0004\u0012\u00020\u0010\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0018\u0010\u001a\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0018\u0010\u001b\u001a\n\u0012\u0004\u0012\u00020\u0010\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0012\u0010\u001c\u001a\u0004\u0018\u00010\u001d8\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u00100\u00078\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0018\u0010\u001f\u001a\n\u0012\u0004\u0012\u00020 \u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0018\u0010!\u001a\n\u0012\u0004\u0012\u00020\"\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0012\u0010#\u001a\u0004\u0018\u00010$8\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0018\u0010%\u001a\n\u0012\u0004\u0012\u00020\u0010\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0018\u0010&\u001a\n\u0012\u0004\u0012\u00020 \u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\u0002\n\u0000¨\u00065"}, d2 = {"Lcom/yandex/div2/DivText$Range;", "Lcom/yandex/div/json/JSONSerializable;", "Lcom/yandex/div/data/Hashable;", "actions", "", "Lcom/yandex/div2/DivAction;", "alignmentVertical", "Lcom/yandex/div/json/expressions/Expression;", "Lcom/yandex/div2/DivTextAlignmentVertical;", J2.g, "Lcom/yandex/div2/DivTextRangeBackground;", "baselineOffset", "", OutlinedTextFieldKt.BorderId, "Lcom/yandex/div2/DivTextRangeBorder;", "end", "", "fontFamily", "", "fontFeatureSettings", "fontSize", "fontSizeUnit", "Lcom/yandex/div2/DivSizeUnit;", "fontWeight", "Lcom/yandex/div2/DivFontWeight;", "fontWeightValue", "letterSpacing", "lineHeight", "mask", "Lcom/yandex/div2/DivTextRangeMask;", "start", "strike", "Lcom/yandex/div2/DivLineStyle;", "textColor", "", "textShadow", "Lcom/yandex/div2/DivShadow;", "topOffset", "underline", "(Ljava/util/List;Lcom/yandex/div/json/expressions/Expression;Lcom/yandex/div2/DivTextRangeBackground;Lcom/yandex/div/json/expressions/Expression;Lcom/yandex/div2/DivTextRangeBorder;Lcom/yandex/div/json/expressions/Expression;Lcom/yandex/div/json/expressions/Expression;Lcom/yandex/div/json/expressions/Expression;Lcom/yandex/div/json/expressions/Expression;Lcom/yandex/div/json/expressions/Expression;Lcom/yandex/div/json/expressions/Expression;Lcom/yandex/div/json/expressions/Expression;Lcom/yandex/div/json/expressions/Expression;Lcom/yandex/div/json/expressions/Expression;Lcom/yandex/div2/DivTextRangeMask;Lcom/yandex/div/json/expressions/Expression;Lcom/yandex/div/json/expressions/Expression;Lcom/yandex/div/json/expressions/Expression;Lcom/yandex/div2/DivShadow;Lcom/yandex/div/json/expressions/Expression;Lcom/yandex/div/json/expressions/Expression;)V", "_hash", "Ljava/lang/Integer;", "copy", "equals", "", "other", "resolver", "Lcom/yandex/div/json/expressions/ExpressionResolver;", "otherResolver", "hash", "writeToJSON", "Lorg/json/JSONObject;", "Companion", "div-data_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class Range implements JSONSerializable, Hashable {
        private Integer _hash;
        public final List<DivAction> actions;
        public final Expression<DivTextAlignmentVertical> alignmentVertical;
        public final DivTextRangeBackground background;
        public final Expression<Double> baselineOffset;
        public final DivTextRangeBorder border;
        public final Expression<Long> end;
        public final Expression<String> fontFamily;
        public final Expression<String> fontFeatureSettings;
        public final Expression<Long> fontSize;
        public final Expression<DivSizeUnit> fontSizeUnit;
        public final Expression<DivFontWeight> fontWeight;
        public final Expression<Long> fontWeightValue;
        public final Expression<Double> letterSpacing;
        public final Expression<Long> lineHeight;
        public final DivTextRangeMask mask;
        public final Expression<Long> start;
        public final Expression<DivLineStyle> strike;
        public final Expression<Integer> textColor;
        public final DivShadow textShadow;
        public final Expression<Long> topOffset;
        public final Expression<DivLineStyle> underline;

        /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
        public static final Companion INSTANCE = new Companion(null);
        private static final Expression<Double> BASELINE_OFFSET_DEFAULT_VALUE = Expression.INSTANCE.constant(Double.valueOf(0.0d));
        private static final Expression<DivSizeUnit> FONT_SIZE_UNIT_DEFAULT_VALUE = Expression.INSTANCE.constant(DivSizeUnit.SP);
        private static final Expression<Long> START_DEFAULT_VALUE = Expression.INSTANCE.constant(0L);
        private static final Function2<ParsingEnvironment, JSONObject, Range> CREATOR = new Function2<ParsingEnvironment, JSONObject, Range>() { // from class: com.yandex.div2.DivText$Range$Companion$CREATOR$1
            @Override // kotlin.jvm.functions.Function2
            public final DivText.Range invoke(ParsingEnvironment env, JSONObject it) {
                Intrinsics.checkNotNullParameter(env, "env");
                Intrinsics.checkNotNullParameter(it, "it");
                return DivText.Range.INSTANCE.fromJson(env, it);
            }
        };

        public Range() {
            this(null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, 2097151, null);
        }

        @JvmStatic
        public static final Range fromJson(ParsingEnvironment parsingEnvironment, JSONObject jSONObject) {
            return INSTANCE.fromJson(parsingEnvironment, jSONObject);
        }

        public Range(List<DivAction> list, Expression<DivTextAlignmentVertical> expression, DivTextRangeBackground divTextRangeBackground, Expression<Double> baselineOffset, DivTextRangeBorder divTextRangeBorder, Expression<Long> expression2, Expression<String> expression3, Expression<String> expression4, Expression<Long> expression5, Expression<DivSizeUnit> fontSizeUnit, Expression<DivFontWeight> expression6, Expression<Long> expression7, Expression<Double> expression8, Expression<Long> expression9, DivTextRangeMask divTextRangeMask, Expression<Long> start, Expression<DivLineStyle> expression10, Expression<Integer> expression11, DivShadow divShadow, Expression<Long> expression12, Expression<DivLineStyle> expression13) {
            Intrinsics.checkNotNullParameter(baselineOffset, "baselineOffset");
            Intrinsics.checkNotNullParameter(fontSizeUnit, "fontSizeUnit");
            Intrinsics.checkNotNullParameter(start, "start");
            this.actions = list;
            this.alignmentVertical = expression;
            this.background = divTextRangeBackground;
            this.baselineOffset = baselineOffset;
            this.border = divTextRangeBorder;
            this.end = expression2;
            this.fontFamily = expression3;
            this.fontFeatureSettings = expression4;
            this.fontSize = expression5;
            this.fontSizeUnit = fontSizeUnit;
            this.fontWeight = expression6;
            this.fontWeightValue = expression7;
            this.letterSpacing = expression8;
            this.lineHeight = expression9;
            this.mask = divTextRangeMask;
            this.start = start;
            this.strike = expression10;
            this.textColor = expression11;
            this.textShadow = divShadow;
            this.topOffset = expression12;
            this.underline = expression13;
        }

        public /* synthetic */ Range(List list, Expression expression, DivTextRangeBackground divTextRangeBackground, Expression expression2, DivTextRangeBorder divTextRangeBorder, Expression expression3, Expression expression4, Expression expression5, Expression expression6, Expression expression7, Expression expression8, Expression expression9, Expression expression10, Expression expression11, DivTextRangeMask divTextRangeMask, Expression expression12, Expression expression13, Expression expression14, DivShadow divShadow, Expression expression15, Expression expression16, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this((i & 1) != 0 ? null : list, (i & 2) != 0 ? null : expression, (i & 4) != 0 ? null : divTextRangeBackground, (i & 8) != 0 ? BASELINE_OFFSET_DEFAULT_VALUE : expression2, (i & 16) != 0 ? null : divTextRangeBorder, (i & 32) != 0 ? null : expression3, (i & 64) != 0 ? null : expression4, (i & 128) != 0 ? null : expression5, (i & 256) != 0 ? null : expression6, (i & 512) != 0 ? FONT_SIZE_UNIT_DEFAULT_VALUE : expression7, (i & 1024) != 0 ? null : expression8, (i & 2048) != 0 ? null : expression9, (i & 4096) != 0 ? null : expression10, (i & 8192) != 0 ? null : expression11, (i & 16384) != 0 ? null : divTextRangeMask, (i & 32768) != 0 ? START_DEFAULT_VALUE : expression12, (i & 65536) != 0 ? null : expression13, (i & 131072) != 0 ? null : expression14, (i & 262144) != 0 ? null : divShadow, (i & 524288) != 0 ? null : expression15, (i & 1048576) != 0 ? null : expression16);
        }

        @Override // com.yandex.div.data.Hashable
        public int hash() {
            int iHash;
            Integer num = this._hash;
            if (num != null) {
                return num.intValue();
            }
            int iHashCode = Reflection.getOrCreateKotlinClass(getClass()).hashCode();
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
            int i = iHashCode + iHash;
            Expression<DivTextAlignmentVertical> expression = this.alignmentVertical;
            int iHashCode2 = i + (expression != null ? expression.hashCode() : 0);
            DivTextRangeBackground divTextRangeBackground = this.background;
            int iHash2 = iHashCode2 + (divTextRangeBackground != null ? divTextRangeBackground.hash() : 0) + this.baselineOffset.hashCode();
            DivTextRangeBorder divTextRangeBorder = this.border;
            int iHash3 = iHash2 + (divTextRangeBorder != null ? divTextRangeBorder.hash() : 0);
            Expression<Long> expression2 = this.end;
            int iHashCode3 = iHash3 + (expression2 != null ? expression2.hashCode() : 0);
            Expression<String> expression3 = this.fontFamily;
            int iHashCode4 = iHashCode3 + (expression3 != null ? expression3.hashCode() : 0);
            Expression<String> expression4 = this.fontFeatureSettings;
            int iHashCode5 = iHashCode4 + (expression4 != null ? expression4.hashCode() : 0);
            Expression<Long> expression5 = this.fontSize;
            int iHashCode6 = iHashCode5 + (expression5 != null ? expression5.hashCode() : 0) + this.fontSizeUnit.hashCode();
            Expression<DivFontWeight> expression6 = this.fontWeight;
            int iHashCode7 = iHashCode6 + (expression6 != null ? expression6.hashCode() : 0);
            Expression<Long> expression7 = this.fontWeightValue;
            int iHashCode8 = iHashCode7 + (expression7 != null ? expression7.hashCode() : 0);
            Expression<Double> expression8 = this.letterSpacing;
            int iHashCode9 = iHashCode8 + (expression8 != null ? expression8.hashCode() : 0);
            Expression<Long> expression9 = this.lineHeight;
            int iHashCode10 = iHashCode9 + (expression9 != null ? expression9.hashCode() : 0);
            DivTextRangeMask divTextRangeMask = this.mask;
            int iHash4 = iHashCode10 + (divTextRangeMask != null ? divTextRangeMask.hash() : 0) + this.start.hashCode();
            Expression<DivLineStyle> expression10 = this.strike;
            int iHashCode11 = iHash4 + (expression10 != null ? expression10.hashCode() : 0);
            Expression<Integer> expression11 = this.textColor;
            int iHashCode12 = iHashCode11 + (expression11 != null ? expression11.hashCode() : 0);
            DivShadow divShadow = this.textShadow;
            int iHash5 = iHashCode12 + (divShadow != null ? divShadow.hash() : 0);
            Expression<Long> expression12 = this.topOffset;
            int iHashCode13 = iHash5 + (expression12 != null ? expression12.hashCode() : 0);
            Expression<DivLineStyle> expression13 = this.underline;
            int iHashCode14 = iHashCode13 + (expression13 != null ? expression13.hashCode() : 0);
            this._hash = Integer.valueOf(iHashCode14);
            return iHashCode14;
        }

        public final boolean equals(Range other, ExpressionResolver resolver, ExpressionResolver otherResolver) {
            Intrinsics.checkNotNullParameter(resolver, "resolver");
            Intrinsics.checkNotNullParameter(otherResolver, "otherResolver");
            if (other == null) {
                return false;
            }
            List<DivAction> list = this.actions;
            if (list != null) {
                List<DivAction> list2 = other.actions;
                if (list2 == null || list.size() != list2.size()) {
                    return false;
                }
                int i = 0;
                for (Object obj : list) {
                    int i2 = i + 1;
                    if (i < 0) {
                        CollectionsKt.throwIndexOverflow();
                    }
                    if (!((DivAction) obj).equals(list2.get(i), resolver, otherResolver)) {
                        return false;
                    }
                    i = i2;
                }
            } else if (other.actions != null) {
                return false;
            }
            Expression<DivTextAlignmentVertical> expression = this.alignmentVertical;
            DivTextAlignmentVertical divTextAlignmentVerticalEvaluate = expression != null ? expression.evaluate(resolver) : null;
            Expression<DivTextAlignmentVertical> expression2 = other.alignmentVertical;
            if (divTextAlignmentVerticalEvaluate != (expression2 != null ? expression2.evaluate(otherResolver) : null)) {
                return false;
            }
            DivTextRangeBackground divTextRangeBackground = this.background;
            if (!(divTextRangeBackground != null ? divTextRangeBackground.equals(other.background, resolver, otherResolver) : other.background == null)) {
                return false;
            }
            if (!(this.baselineOffset.evaluate(resolver).doubleValue() == other.baselineOffset.evaluate(otherResolver).doubleValue())) {
                return false;
            }
            DivTextRangeBorder divTextRangeBorder = this.border;
            if (!(divTextRangeBorder != null ? divTextRangeBorder.equals(other.border, resolver, otherResolver) : other.border == null)) {
                return false;
            }
            Expression<Long> expression3 = this.end;
            Long lEvaluate = expression3 != null ? expression3.evaluate(resolver) : null;
            Expression<Long> expression4 = other.end;
            if (!Intrinsics.areEqual(lEvaluate, expression4 != null ? expression4.evaluate(otherResolver) : null)) {
                return false;
            }
            Expression<String> expression5 = this.fontFamily;
            String strEvaluate = expression5 != null ? expression5.evaluate(resolver) : null;
            Expression<String> expression6 = other.fontFamily;
            if (!Intrinsics.areEqual(strEvaluate, expression6 != null ? expression6.evaluate(otherResolver) : null)) {
                return false;
            }
            Expression<String> expression7 = this.fontFeatureSettings;
            String strEvaluate2 = expression7 != null ? expression7.evaluate(resolver) : null;
            Expression<String> expression8 = other.fontFeatureSettings;
            if (!Intrinsics.areEqual(strEvaluate2, expression8 != null ? expression8.evaluate(otherResolver) : null)) {
                return false;
            }
            Expression<Long> expression9 = this.fontSize;
            Long lEvaluate2 = expression9 != null ? expression9.evaluate(resolver) : null;
            Expression<Long> expression10 = other.fontSize;
            if (!Intrinsics.areEqual(lEvaluate2, expression10 != null ? expression10.evaluate(otherResolver) : null) || this.fontSizeUnit.evaluate(resolver) != other.fontSizeUnit.evaluate(otherResolver)) {
                return false;
            }
            Expression<DivFontWeight> expression11 = this.fontWeight;
            DivFontWeight divFontWeightEvaluate = expression11 != null ? expression11.evaluate(resolver) : null;
            Expression<DivFontWeight> expression12 = other.fontWeight;
            if (divFontWeightEvaluate != (expression12 != null ? expression12.evaluate(otherResolver) : null)) {
                return false;
            }
            Expression<Long> expression13 = this.fontWeightValue;
            Long lEvaluate3 = expression13 != null ? expression13.evaluate(resolver) : null;
            Expression<Long> expression14 = other.fontWeightValue;
            if (!Intrinsics.areEqual(lEvaluate3, expression14 != null ? expression14.evaluate(otherResolver) : null)) {
                return false;
            }
            Expression<Double> expression15 = this.letterSpacing;
            Double dEvaluate = expression15 != null ? expression15.evaluate(resolver) : null;
            Expression<Double> expression16 = other.letterSpacing;
            if (!Intrinsics.areEqual(dEvaluate, expression16 != null ? expression16.evaluate(otherResolver) : null)) {
                return false;
            }
            Expression<Long> expression17 = this.lineHeight;
            Long lEvaluate4 = expression17 != null ? expression17.evaluate(resolver) : null;
            Expression<Long> expression18 = other.lineHeight;
            if (!Intrinsics.areEqual(lEvaluate4, expression18 != null ? expression18.evaluate(otherResolver) : null)) {
                return false;
            }
            DivTextRangeMask divTextRangeMask = this.mask;
            if (!(divTextRangeMask != null ? divTextRangeMask.equals(other.mask, resolver, otherResolver) : other.mask == null) || this.start.evaluate(resolver).longValue() != other.start.evaluate(otherResolver).longValue()) {
                return false;
            }
            Expression<DivLineStyle> expression19 = this.strike;
            DivLineStyle divLineStyleEvaluate = expression19 != null ? expression19.evaluate(resolver) : null;
            Expression<DivLineStyle> expression20 = other.strike;
            if (divLineStyleEvaluate != (expression20 != null ? expression20.evaluate(otherResolver) : null)) {
                return false;
            }
            Expression<Integer> expression21 = this.textColor;
            Integer numEvaluate = expression21 != null ? expression21.evaluate(resolver) : null;
            Expression<Integer> expression22 = other.textColor;
            if (!Intrinsics.areEqual(numEvaluate, expression22 != null ? expression22.evaluate(otherResolver) : null)) {
                return false;
            }
            DivShadow divShadow = this.textShadow;
            if (!(divShadow != null ? divShadow.equals(other.textShadow, resolver, otherResolver) : other.textShadow == null)) {
                return false;
            }
            Expression<Long> expression23 = this.topOffset;
            Long lEvaluate5 = expression23 != null ? expression23.evaluate(resolver) : null;
            Expression<Long> expression24 = other.topOffset;
            if (!Intrinsics.areEqual(lEvaluate5, expression24 != null ? expression24.evaluate(otherResolver) : null)) {
                return false;
            }
            Expression<DivLineStyle> expression25 = this.underline;
            DivLineStyle divLineStyleEvaluate2 = expression25 != null ? expression25.evaluate(resolver) : null;
            Expression<DivLineStyle> expression26 = other.underline;
            return divLineStyleEvaluate2 == (expression26 != null ? expression26.evaluate(otherResolver) : null);
        }

        public final Range copy(List<DivAction> actions, Expression<DivTextAlignmentVertical> alignmentVertical, DivTextRangeBackground background, Expression<Double> baselineOffset, DivTextRangeBorder border, Expression<Long> end, Expression<String> fontFamily, Expression<String> fontFeatureSettings, Expression<Long> fontSize, Expression<DivSizeUnit> fontSizeUnit, Expression<DivFontWeight> fontWeight, Expression<Long> fontWeightValue, Expression<Double> letterSpacing, Expression<Long> lineHeight, DivTextRangeMask mask, Expression<Long> start, Expression<DivLineStyle> strike, Expression<Integer> textColor, DivShadow textShadow, Expression<Long> topOffset, Expression<DivLineStyle> underline) {
            Intrinsics.checkNotNullParameter(baselineOffset, "baselineOffset");
            Intrinsics.checkNotNullParameter(fontSizeUnit, "fontSizeUnit");
            Intrinsics.checkNotNullParameter(start, "start");
            return new Range(actions, alignmentVertical, background, baselineOffset, border, end, fontFamily, fontFeatureSettings, fontSize, fontSizeUnit, fontWeight, fontWeightValue, letterSpacing, lineHeight, mask, start, strike, textColor, textShadow, topOffset, underline);
        }

        @Override // com.yandex.div.json.JSONSerializable
        public JSONObject writeToJSON() {
            return BuiltInParserKt.getBuiltInParserComponent().getDivTextRangeJsonEntityParser().getValue().serialize(BuiltInParserKt.getBuiltInParsingContext(), this);
        }

        /* JADX INFO: compiled from: DivText.kt */
        @Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0006\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u001e\u0010\u0011\u001a\u00020\n2\u0006\u0010\u0012\u001a\u00020\b2\u0006\u0010\u0013\u001a\u00020\tH\u0087\u0002¢\u0006\u0002\b\u0014R\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R#\u0010\u0006\u001a\u0014\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\n0\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0014\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000e0\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00100\u0004X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0015"}, d2 = {"Lcom/yandex/div2/DivText$Range$Companion;", "", "()V", "BASELINE_OFFSET_DEFAULT_VALUE", "Lcom/yandex/div/json/expressions/Expression;", "", "CREATOR", "Lkotlin/Function2;", "Lcom/yandex/div/json/ParsingEnvironment;", "Lorg/json/JSONObject;", "Lcom/yandex/div2/DivText$Range;", "getCREATOR", "()Lkotlin/jvm/functions/Function2;", "FONT_SIZE_UNIT_DEFAULT_VALUE", "Lcom/yandex/div2/DivSizeUnit;", "START_DEFAULT_VALUE", "", "invoke", cc.o, "json", "fromJson", "div-data_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
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
                return BuiltInParserKt.getBuiltInParserComponent().getDivTextRangeJsonEntityParser().getValue().deserialize((ParsingContext) env, json);
            }

            public final Function2<ParsingEnvironment, JSONObject, Range> getCREATOR() {
                return Range.CREATOR;
            }
        }
    }

    /* JADX INFO: compiled from: DivText.kt */
    @Metadata(d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 $2\u00020\u00012\u00020\u0002:\u0003#$%B\u0095\u0001\b\u0007\u0012\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u0012\u000e\b\u0002\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006\u0012\b\b\u0002\u0010\b\u001a\u00020\t\u0012\u000e\b\u0002\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u000b0\u0006\u0012\u000e\b\u0002\u0010\f\u001a\b\u0012\u0004\u0012\u00020\r0\u0006\u0012\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u000f0\u0006\u0012\u0010\b\u0002\u0010\u0010\u001a\n\u0012\u0004\u0012\u00020\u0011\u0018\u00010\u0006\u0012\u000e\b\u0002\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00130\u0006\u0012\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00150\u0006\u0012\b\b\u0002\u0010\u0016\u001a\u00020\t¢\u0006\u0002\u0010\u0017J\u0098\u0001\u0010\u001a\u001a\u00020\u00002\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u00042\u000e\b\u0002\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\b\b\u0002\u0010\b\u001a\u00020\t2\u000e\b\u0002\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u000b0\u00062\u000e\b\u0002\u0010\f\u001a\b\u0012\u0004\u0012\u00020\r0\u00062\u000e\b\u0002\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u000f0\u00062\u0010\b\u0002\u0010\u0010\u001a\n\u0012\u0004\u0012\u00020\u0011\u0018\u00010\u00062\u000e\b\u0002\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00130\u00062\u000e\b\u0002\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00150\u00062\b\b\u0002\u0010\u0016\u001a\u00020\tJ \u0010\u001b\u001a\u00020\r2\b\u0010\u001c\u001a\u0004\u0018\u00010\u00002\u0006\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020\u001eJ\b\u0010 \u001a\u00020\u0011H\u0016J\b\u0010!\u001a\u00020\"H\u0016R\u0012\u0010\u0018\u001a\u0004\u0018\u00010\u0011X\u0082\u000e¢\u0006\u0004\n\u0002\u0010\u0019R\u0012\u0010\u0003\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u00068\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u00020\t8\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u000b0\u00068\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\f\u001a\b\u0012\u0004\u0012\u00020\r0\u00068\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u000f0\u00068\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0018\u0010\u0010\u001a\n\u0012\u0004\u0012\u00020\u0011\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00130\u00068\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00150\u00068\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0016\u001a\u00020\t8\u0006X\u0087\u0004¢\u0006\u0002\n\u0000¨\u0006&"}, d2 = {"Lcom/yandex/div2/DivText$Image;", "Lcom/yandex/div/json/JSONSerializable;", "Lcom/yandex/div/data/Hashable;", "accessibility", "Lcom/yandex/div2/DivText$Image$Accessibility;", "alignmentVertical", "Lcom/yandex/div/json/expressions/Expression;", "Lcom/yandex/div2/DivTextAlignmentVertical;", "height", "Lcom/yandex/div2/DivFixedSize;", "indexingDirection", "Lcom/yandex/div2/DivText$Image$IndexingDirection;", "preloadRequired", "", "start", "", "tintColor", "", "tintMode", "Lcom/yandex/div2/DivBlendMode;", "url", "Landroid/net/Uri;", "width", "(Lcom/yandex/div2/DivText$Image$Accessibility;Lcom/yandex/div/json/expressions/Expression;Lcom/yandex/div2/DivFixedSize;Lcom/yandex/div/json/expressions/Expression;Lcom/yandex/div/json/expressions/Expression;Lcom/yandex/div/json/expressions/Expression;Lcom/yandex/div/json/expressions/Expression;Lcom/yandex/div/json/expressions/Expression;Lcom/yandex/div/json/expressions/Expression;Lcom/yandex/div2/DivFixedSize;)V", "_hash", "Ljava/lang/Integer;", "copy", "equals", "other", "resolver", "Lcom/yandex/div/json/expressions/ExpressionResolver;", "otherResolver", "hash", "writeToJSON", "Lorg/json/JSONObject;", "Accessibility", "Companion", "IndexingDirection", "div-data_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class Image implements JSONSerializable, Hashable {
        private static final DivFixedSize HEIGHT_DEFAULT_VALUE;
        private static final DivFixedSize WIDTH_DEFAULT_VALUE;
        private Integer _hash;
        public final Accessibility accessibility;
        public final Expression<DivTextAlignmentVertical> alignmentVertical;
        public final DivFixedSize height;
        public final Expression<IndexingDirection> indexingDirection;
        public final Expression<Boolean> preloadRequired;
        public final Expression<Long> start;
        public final Expression<Integer> tintColor;
        public final Expression<DivBlendMode> tintMode;
        public final Expression<Uri> url;
        public final DivFixedSize width;

        /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
        public static final Companion INSTANCE = new Companion(null);
        private static final Expression<DivTextAlignmentVertical> ALIGNMENT_VERTICAL_DEFAULT_VALUE = Expression.INSTANCE.constant(DivTextAlignmentVertical.CENTER);
        private static final Expression<IndexingDirection> INDEXING_DIRECTION_DEFAULT_VALUE = Expression.INSTANCE.constant(IndexingDirection.NORMAL);
        private static final Expression<Boolean> PRELOAD_REQUIRED_DEFAULT_VALUE = Expression.INSTANCE.constant(false);
        private static final Expression<DivBlendMode> TINT_MODE_DEFAULT_VALUE = Expression.INSTANCE.constant(DivBlendMode.SOURCE_IN);
        private static final Function2<ParsingEnvironment, JSONObject, Image> CREATOR = new Function2<ParsingEnvironment, JSONObject, Image>() { // from class: com.yandex.div2.DivText$Image$Companion$CREATOR$1
            @Override // kotlin.jvm.functions.Function2
            public final DivText.Image invoke(ParsingEnvironment env, JSONObject it) {
                Intrinsics.checkNotNullParameter(env, "env");
                Intrinsics.checkNotNullParameter(it, "it");
                return DivText.Image.INSTANCE.fromJson(env, it);
            }
        };

        @JvmStatic
        public static final Image fromJson(ParsingEnvironment parsingEnvironment, JSONObject jSONObject) {
            return INSTANCE.fromJson(parsingEnvironment, jSONObject);
        }

        public Image(Accessibility accessibility, Expression<DivTextAlignmentVertical> alignmentVertical, DivFixedSize height, Expression<IndexingDirection> indexingDirection, Expression<Boolean> preloadRequired, Expression<Long> start, Expression<Integer> expression, Expression<DivBlendMode> tintMode, Expression<Uri> url, DivFixedSize width) {
            Intrinsics.checkNotNullParameter(alignmentVertical, "alignmentVertical");
            Intrinsics.checkNotNullParameter(height, "height");
            Intrinsics.checkNotNullParameter(indexingDirection, "indexingDirection");
            Intrinsics.checkNotNullParameter(preloadRequired, "preloadRequired");
            Intrinsics.checkNotNullParameter(start, "start");
            Intrinsics.checkNotNullParameter(tintMode, "tintMode");
            Intrinsics.checkNotNullParameter(url, "url");
            Intrinsics.checkNotNullParameter(width, "width");
            this.accessibility = accessibility;
            this.alignmentVertical = alignmentVertical;
            this.height = height;
            this.indexingDirection = indexingDirection;
            this.preloadRequired = preloadRequired;
            this.start = start;
            this.tintColor = expression;
            this.tintMode = tintMode;
            this.url = url;
            this.width = width;
        }

        public /* synthetic */ Image(Accessibility accessibility, Expression expression, DivFixedSize divFixedSize, Expression expression2, Expression expression3, Expression expression4, Expression expression5, Expression expression6, Expression expression7, DivFixedSize divFixedSize2, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this((i & 1) != 0 ? null : accessibility, (i & 2) != 0 ? ALIGNMENT_VERTICAL_DEFAULT_VALUE : expression, (i & 4) != 0 ? HEIGHT_DEFAULT_VALUE : divFixedSize, (i & 8) != 0 ? INDEXING_DIRECTION_DEFAULT_VALUE : expression2, (i & 16) != 0 ? PRELOAD_REQUIRED_DEFAULT_VALUE : expression3, expression4, (i & 64) != 0 ? null : expression5, (i & 128) != 0 ? TINT_MODE_DEFAULT_VALUE : expression6, expression7, (i & 512) != 0 ? WIDTH_DEFAULT_VALUE : divFixedSize2);
        }

        @Override // com.yandex.div.data.Hashable
        public int hash() {
            Integer num = this._hash;
            if (num != null) {
                return num.intValue();
            }
            int iHashCode = Reflection.getOrCreateKotlinClass(getClass()).hashCode();
            Accessibility accessibility = this.accessibility;
            int iHash = iHashCode + (accessibility != null ? accessibility.hash() : 0) + this.alignmentVertical.hashCode() + this.height.hash() + this.indexingDirection.hashCode() + this.preloadRequired.hashCode() + this.start.hashCode();
            Expression<Integer> expression = this.tintColor;
            int iHashCode2 = iHash + (expression != null ? expression.hashCode() : 0) + this.tintMode.hashCode() + this.url.hashCode() + this.width.hash();
            this._hash = Integer.valueOf(iHashCode2);
            return iHashCode2;
        }

        public final boolean equals(Image other, ExpressionResolver resolver, ExpressionResolver otherResolver) {
            boolean zEquals;
            Intrinsics.checkNotNullParameter(resolver, "resolver");
            Intrinsics.checkNotNullParameter(otherResolver, "otherResolver");
            if (other == null) {
                return false;
            }
            Accessibility accessibility = this.accessibility;
            if (accessibility != null) {
                zEquals = accessibility.equals(other.accessibility, resolver, otherResolver);
            } else {
                zEquals = other.accessibility == null;
            }
            if (!zEquals || this.alignmentVertical.evaluate(resolver) != other.alignmentVertical.evaluate(otherResolver) || !this.height.equals(other.height, resolver, otherResolver) || this.indexingDirection.evaluate(resolver) != other.indexingDirection.evaluate(otherResolver) || this.preloadRequired.evaluate(resolver).booleanValue() != other.preloadRequired.evaluate(otherResolver).booleanValue() || this.start.evaluate(resolver).longValue() != other.start.evaluate(otherResolver).longValue()) {
                return false;
            }
            Expression<Integer> expression = this.tintColor;
            Integer numEvaluate = expression != null ? expression.evaluate(resolver) : null;
            Expression<Integer> expression2 = other.tintColor;
            return Intrinsics.areEqual(numEvaluate, expression2 != null ? expression2.evaluate(otherResolver) : null) && this.tintMode.evaluate(resolver) == other.tintMode.evaluate(otherResolver) && Intrinsics.areEqual(this.url.evaluate(resolver), other.url.evaluate(otherResolver)) && this.width.equals(other.width, resolver, otherResolver);
        }

        public final Image copy(Accessibility accessibility, Expression<DivTextAlignmentVertical> alignmentVertical, DivFixedSize height, Expression<IndexingDirection> indexingDirection, Expression<Boolean> preloadRequired, Expression<Long> start, Expression<Integer> tintColor, Expression<DivBlendMode> tintMode, Expression<Uri> url, DivFixedSize width) {
            Intrinsics.checkNotNullParameter(alignmentVertical, "alignmentVertical");
            Intrinsics.checkNotNullParameter(height, "height");
            Intrinsics.checkNotNullParameter(indexingDirection, "indexingDirection");
            Intrinsics.checkNotNullParameter(preloadRequired, "preloadRequired");
            Intrinsics.checkNotNullParameter(start, "start");
            Intrinsics.checkNotNullParameter(tintMode, "tintMode");
            Intrinsics.checkNotNullParameter(url, "url");
            Intrinsics.checkNotNullParameter(width, "width");
            return new Image(accessibility, alignmentVertical, height, indexingDirection, preloadRequired, start, tintColor, tintMode, url, width);
        }

        @Override // com.yandex.div.json.JSONSerializable
        public JSONObject writeToJSON() {
            return BuiltInParserKt.getBuiltInParserComponent().getDivTextImageJsonEntityParser().getValue().serialize(BuiltInParserKt.getBuiltInParsingContext(), this);
        }

        /* JADX INFO: compiled from: DivText.kt */
        @Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u001e\u0010\u0016\u001a\u00020\n2\u0006\u0010\u0017\u001a\u00020\b2\u0006\u0010\u0018\u001a\u00020\tH\u0087\u0002¢\u0006\u0002\b\u0019R\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R#\u0010\u0006\u001a\u0014\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\n0\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u000e\u0010\r\u001a\u00020\u000eX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00100\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00120\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00140\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u000eX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001a"}, d2 = {"Lcom/yandex/div2/DivText$Image$Companion;", "", "()V", "ALIGNMENT_VERTICAL_DEFAULT_VALUE", "Lcom/yandex/div/json/expressions/Expression;", "Lcom/yandex/div2/DivTextAlignmentVertical;", "CREATOR", "Lkotlin/Function2;", "Lcom/yandex/div/json/ParsingEnvironment;", "Lorg/json/JSONObject;", "Lcom/yandex/div2/DivText$Image;", "getCREATOR", "()Lkotlin/jvm/functions/Function2;", "HEIGHT_DEFAULT_VALUE", "Lcom/yandex/div2/DivFixedSize;", "INDEXING_DIRECTION_DEFAULT_VALUE", "Lcom/yandex/div2/DivText$Image$IndexingDirection;", "PRELOAD_REQUIRED_DEFAULT_VALUE", "", "TINT_MODE_DEFAULT_VALUE", "Lcom/yandex/div2/DivBlendMode;", "WIDTH_DEFAULT_VALUE", "invoke", cc.o, "json", "fromJson", "div-data_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private Companion() {
            }

            @JvmStatic
            public final Image fromJson(ParsingEnvironment env, JSONObject json) {
                Intrinsics.checkNotNullParameter(env, "env");
                Intrinsics.checkNotNullParameter(json, "json");
                return BuiltInParserKt.getBuiltInParserComponent().getDivTextImageJsonEntityParser().getValue().deserialize((ParsingContext) env, json);
            }

            public final Function2<ParsingEnvironment, JSONObject, Image> getCREATOR() {
                return Image.CREATOR;
            }
        }

        static {
            int i = 1;
            HEIGHT_DEFAULT_VALUE = new DivFixedSize(0 == true ? 1 : 0, Expression.INSTANCE.constant(20L), i, 0 == true ? 1 : 0);
            WIDTH_DEFAULT_VALUE = new DivFixedSize(0 == true ? 1 : 0, Expression.INSTANCE.constant(20L), i, 0 == true ? 1 : 0);
        }

        /* JADX INFO: compiled from: DivText.kt */
        @Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 \u00162\u00020\u00012\u00020\u0002:\u0002\u0016\u0017B#\b\u0007\u0012\u0010\b\u0002\u0010\u0003\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0004\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\"\u0010\f\u001a\u00020\u00002\u0010\b\u0002\u0010\u0003\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u00042\b\b\u0002\u0010\u0006\u001a\u00020\u0007J \u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u00002\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0011J\b\u0010\u0013\u001a\u00020\nH\u0016J\b\u0010\u0014\u001a\u00020\u0015H\u0016R\u0012\u0010\t\u001a\u0004\u0018\u00010\nX\u0082\u000e¢\u0006\u0004\n\u0002\u0010\u000bR\u0018\u0010\u0003\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u00020\u00078\u0006X\u0087\u0004¢\u0006\u0002\n\u0000¨\u0006\u0018"}, d2 = {"Lcom/yandex/div2/DivText$Image$Accessibility;", "Lcom/yandex/div/json/JSONSerializable;", "Lcom/yandex/div/data/Hashable;", "description", "Lcom/yandex/div/json/expressions/Expression;", "", "type", "Lcom/yandex/div2/DivText$Image$Accessibility$Type;", "(Lcom/yandex/div/json/expressions/Expression;Lcom/yandex/div2/DivText$Image$Accessibility$Type;)V", "_hash", "", "Ljava/lang/Integer;", "copy", "equals", "", "other", "resolver", "Lcom/yandex/div/json/expressions/ExpressionResolver;", "otherResolver", "hash", "writeToJSON", "Lorg/json/JSONObject;", "Companion", "Type", "div-data_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
        public static final class Accessibility implements JSONSerializable, Hashable {
            private Integer _hash;
            public final Expression<String> description;
            public final Type type;

            /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
            public static final Companion INSTANCE = new Companion(null);
            private static final Type TYPE_DEFAULT_VALUE = Type.AUTO;
            private static final Function2<ParsingEnvironment, JSONObject, Accessibility> CREATOR = new Function2<ParsingEnvironment, JSONObject, Accessibility>() { // from class: com.yandex.div2.DivText$Image$Accessibility$Companion$CREATOR$1
                @Override // kotlin.jvm.functions.Function2
                public final DivText.Image.Accessibility invoke(ParsingEnvironment env, JSONObject it) {
                    Intrinsics.checkNotNullParameter(env, "env");
                    Intrinsics.checkNotNullParameter(it, "it");
                    return DivText.Image.Accessibility.INSTANCE.fromJson(env, it);
                }
            };

            public Accessibility() {
                this(null, 0 == true ? 1 : 0, 3, 0 == true ? 1 : 0);
            }

            @JvmStatic
            public static final Accessibility fromJson(ParsingEnvironment parsingEnvironment, JSONObject jSONObject) {
                return INSTANCE.fromJson(parsingEnvironment, jSONObject);
            }

            public Accessibility(Expression<String> expression, Type type) {
                Intrinsics.checkNotNullParameter(type, "type");
                this.description = expression;
                this.type = type;
            }

            public /* synthetic */ Accessibility(Expression expression, Type type, int i, DefaultConstructorMarker defaultConstructorMarker) {
                this((i & 1) != 0 ? null : expression, (i & 2) != 0 ? TYPE_DEFAULT_VALUE : type);
            }

            @Override // com.yandex.div.data.Hashable
            public int hash() {
                Integer num = this._hash;
                if (num != null) {
                    return num.intValue();
                }
                int iHashCode = Reflection.getOrCreateKotlinClass(getClass()).hashCode();
                Expression<String> expression = this.description;
                int iHashCode2 = iHashCode + (expression != null ? expression.hashCode() : 0) + this.type.hashCode();
                this._hash = Integer.valueOf(iHashCode2);
                return iHashCode2;
            }

            public final boolean equals(Accessibility other, ExpressionResolver resolver, ExpressionResolver otherResolver) {
                Intrinsics.checkNotNullParameter(resolver, "resolver");
                Intrinsics.checkNotNullParameter(otherResolver, "otherResolver");
                if (other == null) {
                    return false;
                }
                Expression<String> expression = this.description;
                String strEvaluate = expression != null ? expression.evaluate(resolver) : null;
                Expression<String> expression2 = other.description;
                return Intrinsics.areEqual(strEvaluate, expression2 != null ? expression2.evaluate(otherResolver) : null) && this.type == other.type;
            }

            /* JADX WARN: Multi-variable type inference failed */
            public static /* synthetic */ Accessibility copy$default(Accessibility accessibility, Expression expression, Type type, int i, Object obj) {
                if ((i & 1) != 0) {
                    expression = accessibility.description;
                }
                if ((i & 2) != 0) {
                    type = accessibility.type;
                }
                return accessibility.copy(expression, type);
            }

            public final Accessibility copy(Expression<String> description, Type type) {
                Intrinsics.checkNotNullParameter(type, "type");
                return new Accessibility(description, type);
            }

            @Override // com.yandex.div.json.JSONSerializable
            public JSONObject writeToJSON() {
                return BuiltInParserKt.getBuiltInParserComponent().getDivTextImageAccessibilityJsonEntityParser().getValue().serialize(BuiltInParserKt.getBuiltInParsingContext(), this);
            }

            /* JADX INFO: compiled from: DivText.kt */
            @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u001e\u0010\f\u001a\u00020\u00072\u0006\u0010\r\u001a\u00020\u00052\u0006\u0010\u000e\u001a\u00020\u0006H\u0087\u0002¢\u0006\u0002\b\u000fR#\u0010\u0003\u001a\u0014\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0010"}, d2 = {"Lcom/yandex/div2/DivText$Image$Accessibility$Companion;", "", "()V", "CREATOR", "Lkotlin/Function2;", "Lcom/yandex/div/json/ParsingEnvironment;", "Lorg/json/JSONObject;", "Lcom/yandex/div2/DivText$Image$Accessibility;", "getCREATOR", "()Lkotlin/jvm/functions/Function2;", "TYPE_DEFAULT_VALUE", "Lcom/yandex/div2/DivText$Image$Accessibility$Type;", "invoke", cc.o, "json", "fromJson", "div-data_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
            public static final class Companion {
                public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                    this();
                }

                private Companion() {
                }

                @JvmStatic
                public final Accessibility fromJson(ParsingEnvironment env, JSONObject json) {
                    Intrinsics.checkNotNullParameter(env, "env");
                    Intrinsics.checkNotNullParameter(json, "json");
                    return BuiltInParserKt.getBuiltInParserComponent().getDivTextImageAccessibilityJsonEntityParser().getValue().deserialize((ParsingContext) env, json);
                }

                public final Function2<ParsingEnvironment, JSONObject, Accessibility> getCREATOR() {
                    return Accessibility.CREATOR;
                }
            }

            /* JADX INFO: compiled from: DivText.kt */
            @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\b\b\u0086\u0001\u0018\u0000 \n2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\nB\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\t¨\u0006\u000b"}, d2 = {"Lcom/yandex/div2/DivText$Image$Accessibility$Type;", "", "value", "", "(Ljava/lang/String;ILjava/lang/String;)V", "NONE", "BUTTON", ShareConstants.IMAGE_URL, "TEXT", "AUTO", "Converter", "div-data_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
            public enum Type {
                NONE("none"),
                BUTTON("button"),
                IMAGE("image"),
                TEXT("text"),
                AUTO("auto");

                private final String value;

                /* JADX INFO: renamed from: Converter, reason: from kotlin metadata */
                public static final Companion INSTANCE = new Companion(null);
                public static final Function1<Type, String> TO_STRING = new Function1<Type, String>() { // from class: com.yandex.div2.DivText$Image$Accessibility$Type$Converter$TO_STRING$1
                    @Override // kotlin.jvm.functions.Function1
                    public final String invoke(DivText.Image.Accessibility.Type value) {
                        Intrinsics.checkNotNullParameter(value, "value");
                        return DivText.Image.Accessibility.Type.INSTANCE.toString(value);
                    }
                };
                public static final Function1<String, Type> FROM_STRING = new Function1<String, Type>() { // from class: com.yandex.div2.DivText$Image$Accessibility$Type$Converter$FROM_STRING$1
                    @Override // kotlin.jvm.functions.Function1
                    public final DivText.Image.Accessibility.Type invoke(String value) {
                        Intrinsics.checkNotNullParameter(value, "value");
                        return DivText.Image.Accessibility.Type.INSTANCE.fromString(value);
                    }
                };

                Type(String str) {
                    this.value = str;
                }

                /* JADX INFO: renamed from: com.yandex.div2.DivText$Image$Accessibility$Type$Converter, reason: from kotlin metadata */
                /* JADX INFO: compiled from: DivText.kt */
                @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\b\u001a\u0004\u0018\u00010\u00062\u0006\u0010\t\u001a\u00020\u0005J\u000e\u0010\n\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\u0006R\u001e\u0010\u0003\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u00048\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00050\u00048\u0006X\u0087\u0004¢\u0006\u0002\n\u0000¨\u0006\f"}, d2 = {"Lcom/yandex/div2/DivText$Image$Accessibility$Type$Converter;", "", "()V", "FROM_STRING", "Lkotlin/Function1;", "", "Lcom/yandex/div2/DivText$Image$Accessibility$Type;", "TO_STRING", "fromString", "value", "toString", "obj", "div-data_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
                public static final class Companion {
                    public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                        this();
                    }

                    private Companion() {
                    }

                    public final String toString(Type obj) {
                        Intrinsics.checkNotNullParameter(obj, "obj");
                        return obj.value;
                    }

                    public final Type fromString(String value) {
                        Intrinsics.checkNotNullParameter(value, "value");
                        if (Intrinsics.areEqual(value, Type.NONE.value)) {
                            return Type.NONE;
                        }
                        if (Intrinsics.areEqual(value, Type.BUTTON.value)) {
                            return Type.BUTTON;
                        }
                        if (Intrinsics.areEqual(value, Type.IMAGE.value)) {
                            return Type.IMAGE;
                        }
                        if (Intrinsics.areEqual(value, Type.TEXT.value)) {
                            return Type.TEXT;
                        }
                        if (Intrinsics.areEqual(value, Type.AUTO.value)) {
                            return Type.AUTO;
                        }
                        return null;
                    }
                }
            }
        }

        /* JADX INFO: compiled from: DivText.kt */
        @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0001\u0018\u0000 \u00072\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u0007B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000j\u0002\b\u0005j\u0002\b\u0006¨\u0006\b"}, d2 = {"Lcom/yandex/div2/DivText$Image$IndexingDirection;", "", "value", "", "(Ljava/lang/String;ILjava/lang/String;)V", "NORMAL", "REVERSED", "Converter", "div-data_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
        public enum IndexingDirection {
            NORMAL(Constants.NORMAL),
            REVERSED("reversed");

            private final String value;

            /* JADX INFO: renamed from: Converter, reason: from kotlin metadata */
            public static final Companion INSTANCE = new Companion(null);
            public static final Function1<IndexingDirection, String> TO_STRING = new Function1<IndexingDirection, String>() { // from class: com.yandex.div2.DivText$Image$IndexingDirection$Converter$TO_STRING$1
                @Override // kotlin.jvm.functions.Function1
                public final String invoke(DivText.Image.IndexingDirection value) {
                    Intrinsics.checkNotNullParameter(value, "value");
                    return DivText.Image.IndexingDirection.INSTANCE.toString(value);
                }
            };
            public static final Function1<String, IndexingDirection> FROM_STRING = new Function1<String, IndexingDirection>() { // from class: com.yandex.div2.DivText$Image$IndexingDirection$Converter$FROM_STRING$1
                @Override // kotlin.jvm.functions.Function1
                public final DivText.Image.IndexingDirection invoke(String value) {
                    Intrinsics.checkNotNullParameter(value, "value");
                    return DivText.Image.IndexingDirection.INSTANCE.fromString(value);
                }
            };

            IndexingDirection(String str) {
                this.value = str;
            }

            /* JADX INFO: renamed from: com.yandex.div2.DivText$Image$IndexingDirection$Converter, reason: from kotlin metadata */
            /* JADX INFO: compiled from: DivText.kt */
            @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\b\u001a\u0004\u0018\u00010\u00062\u0006\u0010\t\u001a\u00020\u0005J\u000e\u0010\n\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\u0006R\u001e\u0010\u0003\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u00048\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00050\u00048\u0006X\u0087\u0004¢\u0006\u0002\n\u0000¨\u0006\f"}, d2 = {"Lcom/yandex/div2/DivText$Image$IndexingDirection$Converter;", "", "()V", "FROM_STRING", "Lkotlin/Function1;", "", "Lcom/yandex/div2/DivText$Image$IndexingDirection;", "TO_STRING", "fromString", "value", "toString", "obj", "div-data_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
            public static final class Companion {
                public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                    this();
                }

                private Companion() {
                }

                public final String toString(IndexingDirection obj) {
                    Intrinsics.checkNotNullParameter(obj, "obj");
                    return obj.value;
                }

                public final IndexingDirection fromString(String value) {
                    Intrinsics.checkNotNullParameter(value, "value");
                    if (Intrinsics.areEqual(value, IndexingDirection.NORMAL.value)) {
                        return IndexingDirection.NORMAL;
                    }
                    if (Intrinsics.areEqual(value, IndexingDirection.REVERSED.value)) {
                        return IndexingDirection.REVERSED;
                    }
                    return null;
                }
            }
        }
    }

    /* JADX INFO: compiled from: DivText.kt */
    @Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \u001b2\u00020\u00012\u00020\u0002:\u0001\u001bBK\b\u0007\u0012\u0010\b\u0002\u0010\u0003\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0004\u0012\u0010\b\u0002\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0004\u0012\u0010\b\u0002\u0010\b\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\u0004\u0012\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000b¢\u0006\u0002\u0010\rJL\u0010\u0011\u001a\u00020\u00002\u0010\b\u0002\u0010\u0003\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u00042\u0010\b\u0002\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u00042\u0010\b\u0002\u0010\b\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\u00042\u000e\b\u0002\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000bJ \u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u00002\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0016J\b\u0010\u0018\u001a\u00020\u000fH\u0016J\b\u0010\u0019\u001a\u00020\u001aH\u0016R\u0012\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u0082\u000e¢\u0006\u0004\n\u0002\u0010\u0010R\u0018\u0010\u0003\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0018\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0018\u0010\b\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000b8\u0006X\u0087\u0004¢\u0006\u0002\n\u0000¨\u0006\u001c"}, d2 = {"Lcom/yandex/div2/DivText$Ellipsis;", "Lcom/yandex/div/json/JSONSerializable;", "Lcom/yandex/div/data/Hashable;", "actions", "", "Lcom/yandex/div2/DivAction;", "images", "Lcom/yandex/div2/DivText$Image;", "ranges", "Lcom/yandex/div2/DivText$Range;", "text", "Lcom/yandex/div/json/expressions/Expression;", "", "(Ljava/util/List;Ljava/util/List;Ljava/util/List;Lcom/yandex/div/json/expressions/Expression;)V", "_hash", "", "Ljava/lang/Integer;", "copy", "equals", "", "other", "resolver", "Lcom/yandex/div/json/expressions/ExpressionResolver;", "otherResolver", "hash", "writeToJSON", "Lorg/json/JSONObject;", "Companion", "div-data_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class Ellipsis implements JSONSerializable, Hashable {
        private Integer _hash;
        public final List<DivAction> actions;
        public final List<Image> images;
        public final List<Range> ranges;
        public final Expression<String> text;

        /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
        public static final Companion INSTANCE = new Companion(null);
        private static final Function2<ParsingEnvironment, JSONObject, Ellipsis> CREATOR = new Function2<ParsingEnvironment, JSONObject, Ellipsis>() { // from class: com.yandex.div2.DivText$Ellipsis$Companion$CREATOR$1
            @Override // kotlin.jvm.functions.Function2
            public final DivText.Ellipsis invoke(ParsingEnvironment env, JSONObject it) {
                Intrinsics.checkNotNullParameter(env, "env");
                Intrinsics.checkNotNullParameter(it, "it");
                return DivText.Ellipsis.INSTANCE.fromJson(env, it);
            }
        };

        @JvmStatic
        public static final Ellipsis fromJson(ParsingEnvironment parsingEnvironment, JSONObject jSONObject) {
            return INSTANCE.fromJson(parsingEnvironment, jSONObject);
        }

        public Ellipsis(List<DivAction> list, List<Image> list2, List<Range> list3, Expression<String> text) {
            Intrinsics.checkNotNullParameter(text, "text");
            this.actions = list;
            this.images = list2;
            this.ranges = list3;
            this.text = text;
        }

        public /* synthetic */ Ellipsis(List list, List list2, List list3, Expression expression, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this((i & 1) != 0 ? null : list, (i & 2) != 0 ? null : list2, (i & 4) != 0 ? null : list3, expression);
        }

        @Override // com.yandex.div.data.Hashable
        public int hash() {
            int iHash;
            int iHash2;
            Integer num = this._hash;
            if (num != null) {
                return num.intValue();
            }
            int iHashCode = Reflection.getOrCreateKotlinClass(getClass()).hashCode();
            List<DivAction> list = this.actions;
            int iHash3 = 0;
            if (list != null) {
                Iterator<T> it = list.iterator();
                iHash = 0;
                while (it.hasNext()) {
                    iHash += ((DivAction) it.next()).hash();
                }
            } else {
                iHash = 0;
            }
            int i = iHashCode + iHash;
            List<Image> list2 = this.images;
            if (list2 != null) {
                Iterator<T> it2 = list2.iterator();
                iHash2 = 0;
                while (it2.hasNext()) {
                    iHash2 += ((Image) it2.next()).hash();
                }
            } else {
                iHash2 = 0;
            }
            int i2 = i + iHash2;
            List<Range> list3 = this.ranges;
            if (list3 != null) {
                Iterator<T> it3 = list3.iterator();
                while (it3.hasNext()) {
                    iHash3 += ((Range) it3.next()).hash();
                }
            }
            int iHashCode2 = i2 + iHash3 + this.text.hashCode();
            this._hash = Integer.valueOf(iHashCode2);
            return iHashCode2;
        }

        public final boolean equals(Ellipsis other, ExpressionResolver resolver, ExpressionResolver otherResolver) {
            Intrinsics.checkNotNullParameter(resolver, "resolver");
            Intrinsics.checkNotNullParameter(otherResolver, "otherResolver");
            if (other == null) {
                return false;
            }
            List<DivAction> list = this.actions;
            if (list != null) {
                List<DivAction> list2 = other.actions;
                if (list2 == null || list.size() != list2.size()) {
                    return false;
                }
                int i = 0;
                for (Object obj : list) {
                    int i2 = i + 1;
                    if (i < 0) {
                        CollectionsKt.throwIndexOverflow();
                    }
                    if (!((DivAction) obj).equals(list2.get(i), resolver, otherResolver)) {
                        return false;
                    }
                    i = i2;
                }
            } else if (other.actions != null) {
                return false;
            }
            List<Image> list3 = this.images;
            if (list3 != null) {
                List<Image> list4 = other.images;
                if (list4 == null || list3.size() != list4.size()) {
                    return false;
                }
                int i3 = 0;
                for (Object obj2 : list3) {
                    int i4 = i3 + 1;
                    if (i3 < 0) {
                        CollectionsKt.throwIndexOverflow();
                    }
                    if (!((Image) obj2).equals(list4.get(i3), resolver, otherResolver)) {
                        return false;
                    }
                    i3 = i4;
                }
            } else if (other.images != null) {
                return false;
            }
            List<Range> list5 = this.ranges;
            if (list5 != null) {
                List<Range> list6 = other.ranges;
                if (list6 == null || list5.size() != list6.size()) {
                    return false;
                }
                int i5 = 0;
                for (Object obj3 : list5) {
                    int i6 = i5 + 1;
                    if (i5 < 0) {
                        CollectionsKt.throwIndexOverflow();
                    }
                    if (!((Range) obj3).equals(list6.get(i5), resolver, otherResolver)) {
                        return false;
                    }
                    i5 = i6;
                }
            } else if (other.ranges != null) {
                return false;
            }
            return Intrinsics.areEqual(this.text.evaluate(resolver), other.text.evaluate(otherResolver));
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ Ellipsis copy$default(Ellipsis ellipsis, List list, List list2, List list3, Expression expression, int i, Object obj) {
            if ((i & 1) != 0) {
                list = ellipsis.actions;
            }
            if ((i & 2) != 0) {
                list2 = ellipsis.images;
            }
            if ((i & 4) != 0) {
                list3 = ellipsis.ranges;
            }
            if ((i & 8) != 0) {
                expression = ellipsis.text;
            }
            return ellipsis.copy(list, list2, list3, expression);
        }

        public final Ellipsis copy(List<DivAction> actions, List<Image> images, List<Range> ranges, Expression<String> text) {
            Intrinsics.checkNotNullParameter(text, "text");
            return new Ellipsis(actions, images, ranges, text);
        }

        @Override // com.yandex.div.json.JSONSerializable
        public JSONObject writeToJSON() {
            return BuiltInParserKt.getBuiltInParserComponent().getDivTextEllipsisJsonEntityParser().getValue().serialize(BuiltInParserKt.getBuiltInParsingContext(), this);
        }

        /* JADX INFO: compiled from: DivText.kt */
        @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u001e\u0010\n\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\u00052\u0006\u0010\f\u001a\u00020\u0006H\u0087\u0002¢\u0006\u0002\b\rR#\u0010\u0003\u001a\u0014\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\t¨\u0006\u000e"}, d2 = {"Lcom/yandex/div2/DivText$Ellipsis$Companion;", "", "()V", "CREATOR", "Lkotlin/Function2;", "Lcom/yandex/div/json/ParsingEnvironment;", "Lorg/json/JSONObject;", "Lcom/yandex/div2/DivText$Ellipsis;", "getCREATOR", "()Lkotlin/jvm/functions/Function2;", "invoke", cc.o, "json", "fromJson", "div-data_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private Companion() {
            }

            @JvmStatic
            public final Ellipsis fromJson(ParsingEnvironment env, JSONObject json) {
                Intrinsics.checkNotNullParameter(env, "env");
                Intrinsics.checkNotNullParameter(json, "json");
                return BuiltInParserKt.getBuiltInParserComponent().getDivTextEllipsisJsonEntityParser().getValue().deserialize((ParsingContext) env, json);
            }

            public final Function2<ParsingEnvironment, JSONObject, Ellipsis> getCREATOR() {
                return Ellipsis.CREATOR;
            }
        }
    }
}
