package com.yandex.div2;

import androidx.compose.material.OutlinedTextFieldKt;
import androidx.exifinterface.media.ExifInterface;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.json.cc;
import com.pubmatic.sdk.omsdk.POBOMSDKLogConstants;
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

/* JADX INFO: compiled from: DivGallery.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\u0086\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0006\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b3\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 \u008e\u00012\u00020\u00012\u00020\u00022\u00020\u0003:\n\u008e\u0001\u008f\u0001\u0090\u0001\u0091\u0001\u0092\u0001B\u009d\u0005\b\u0007\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\u0010\b\u0002\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007\u0012\u0010\b\u0002\u0010\t\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\u0007\u0012\u000e\b\u0002\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\f0\u0007\u0012\u0010\b\u0002\u0010\r\u001a\n\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u000e\u0012\u0010\b\u0002\u0010\u0010\u001a\n\u0012\u0004\u0012\u00020\u0011\u0018\u00010\u000e\u0012\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u0013\u0012\u0010\b\u0002\u0010\u0014\u001a\n\u0012\u0004\u0012\u00020\u0015\u0018\u00010\u0007\u0012\u0010\b\u0002\u0010\u0016\u001a\n\u0012\u0004\u0012\u00020\u0015\u0018\u00010\u0007\u0012\u000e\b\u0002\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00180\u0007\u0012\u0010\b\u0002\u0010\u0019\u001a\n\u0012\u0004\u0012\u00020\u0015\u0018\u00010\u0007\u0012\u000e\b\u0002\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00150\u0007\u0012\u0010\b\u0002\u0010\u001b\u001a\n\u0012\u0004\u0012\u00020\u001c\u0018\u00010\u000e\u0012\u0010\b\u0002\u0010\u001d\u001a\n\u0012\u0004\u0012\u00020\u001e\u0018\u00010\u000e\u0012\n\b\u0002\u0010\u001f\u001a\u0004\u0018\u00010 \u0012\u0010\b\u0002\u0010!\u001a\n\u0012\u0004\u0012\u00020\"\u0018\u00010\u000e\u0012\b\b\u0002\u0010#\u001a\u00020$\u0012\n\b\u0002\u0010%\u001a\u0004\u0018\u00010&\u0012\n\b\u0002\u0010'\u001a\u0004\u0018\u00010(\u0012\u000e\b\u0002\u0010)\u001a\b\u0012\u0004\u0012\u00020\u00150\u0007\u0012\u0010\b\u0002\u0010*\u001a\n\u0012\u0004\u0012\u00020+\u0018\u00010\u000e\u0012\n\b\u0002\u0010,\u001a\u0004\u0018\u00010-\u0012\n\b\u0002\u0010.\u001a\u0004\u0018\u00010/\u0012\u000e\b\u0002\u00100\u001a\b\u0012\u0004\u0012\u0002010\u0007\u0012\n\b\u0002\u00102\u001a\u0004\u0018\u00010/\u0012\u000e\b\u0002\u00103\u001a\b\u0012\u0004\u0012\u0002040\u0007\u0012\u0010\b\u0002\u00105\u001a\n\u0012\u0004\u0012\u00020&\u0018\u00010\u0007\u0012\u0010\b\u0002\u00106\u001a\n\u0012\u0004\u0012\u00020\u0015\u0018\u00010\u0007\u0012\u000e\b\u0002\u00107\u001a\b\u0012\u0004\u0012\u0002080\u0007\u0012\u000e\b\u0002\u00109\u001a\b\u0012\u0004\u0012\u00020:0\u0007\u0012\u0010\b\u0002\u0010;\u001a\n\u0012\u0004\u0012\u00020<\u0018\u00010\u000e\u0012\u0010\b\u0002\u0010=\u001a\n\u0012\u0004\u0012\u00020>\u0018\u00010\u000e\u0012\n\b\u0002\u0010?\u001a\u0004\u0018\u00010@\u0012\n\b\u0002\u0010A\u001a\u0004\u0018\u00010B\u0012\n\b\u0002\u0010C\u001a\u0004\u0018\u00010D\u0012\n\b\u0002\u0010E\u001a\u0004\u0018\u00010D\u0012\u0010\b\u0002\u0010F\u001a\n\u0012\u0004\u0012\u00020G\u0018\u00010\u000e\u0012\u0010\b\u0002\u0010H\u001a\n\u0012\u0004\u0012\u00020I\u0018\u00010\u000e\u0012\u0010\b\u0002\u0010J\u001a\n\u0012\u0004\u0012\u00020K\u0018\u00010\u000e\u0012\u000e\b\u0002\u0010L\u001a\b\u0012\u0004\u0012\u00020M0\u0007\u0012\n\b\u0002\u0010N\u001a\u0004\u0018\u00010O\u0012\u0010\b\u0002\u0010P\u001a\n\u0012\u0004\u0012\u00020O\u0018\u00010\u000e\u0012\b\b\u0002\u0010Q\u001a\u00020$¢\u0006\u0002\u0010RJ\u009d\u0005\u0010\u0084\u0001\u001a\u00020\u00002\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0010\b\u0002\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u00072\u0010\b\u0002\u0010\t\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\u00072\u000e\b\u0002\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\f0\u00072\u0010\b\u0002\u0010\r\u001a\n\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u000e2\u0010\b\u0002\u0010\u0010\u001a\n\u0012\u0004\u0012\u00020\u0011\u0018\u00010\u000e2\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u00132\u0010\b\u0002\u0010\u0014\u001a\n\u0012\u0004\u0012\u00020\u0015\u0018\u00010\u00072\u0010\b\u0002\u0010\u0016\u001a\n\u0012\u0004\u0012\u00020\u0015\u0018\u00010\u00072\u000e\b\u0002\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00180\u00072\u0010\b\u0002\u0010\u0019\u001a\n\u0012\u0004\u0012\u00020\u0015\u0018\u00010\u00072\u000e\b\u0002\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00150\u00072\u0010\b\u0002\u0010\u001b\u001a\n\u0012\u0004\u0012\u00020\u001c\u0018\u00010\u000e2\u0010\b\u0002\u0010\u001d\u001a\n\u0012\u0004\u0012\u00020\u001e\u0018\u00010\u000e2\n\b\u0002\u0010\u001f\u001a\u0004\u0018\u00010 2\u0010\b\u0002\u0010!\u001a\n\u0012\u0004\u0012\u00020\"\u0018\u00010\u000e2\b\b\u0002\u0010#\u001a\u00020$2\n\b\u0002\u0010%\u001a\u0004\u0018\u00010&2\n\b\u0002\u0010'\u001a\u0004\u0018\u00010(2\u000e\b\u0002\u0010)\u001a\b\u0012\u0004\u0012\u00020\u00150\u00072\u0010\b\u0002\u0010*\u001a\n\u0012\u0004\u0012\u00020+\u0018\u00010\u000e2\n\b\u0002\u0010,\u001a\u0004\u0018\u00010-2\n\b\u0002\u0010.\u001a\u0004\u0018\u00010/2\u000e\b\u0002\u00100\u001a\b\u0012\u0004\u0012\u0002010\u00072\n\b\u0002\u00102\u001a\u0004\u0018\u00010/2\u000e\b\u0002\u00103\u001a\b\u0012\u0004\u0012\u0002040\u00072\u0010\b\u0002\u00105\u001a\n\u0012\u0004\u0012\u00020&\u0018\u00010\u00072\u0010\b\u0002\u00106\u001a\n\u0012\u0004\u0012\u00020\u0015\u0018\u00010\u00072\u000e\b\u0002\u00107\u001a\b\u0012\u0004\u0012\u0002080\u00072\u000e\b\u0002\u00109\u001a\b\u0012\u0004\u0012\u00020:0\u00072\u0010\b\u0002\u0010;\u001a\n\u0012\u0004\u0012\u00020<\u0018\u00010\u000e2\u0010\b\u0002\u0010=\u001a\n\u0012\u0004\u0012\u00020>\u0018\u00010\u000e2\n\b\u0002\u0010?\u001a\u0004\u0018\u00010@2\n\b\u0002\u0010A\u001a\u0004\u0018\u00010B2\n\b\u0002\u0010C\u001a\u0004\u0018\u00010D2\n\b\u0002\u0010E\u001a\u0004\u0018\u00010D2\u0010\b\u0002\u0010F\u001a\n\u0012\u0004\u0012\u00020G\u0018\u00010\u000e2\u0010\b\u0002\u0010H\u001a\n\u0012\u0004\u0012\u00020I\u0018\u00010\u000e2\u0010\b\u0002\u0010J\u001a\n\u0012\u0004\u0012\u00020K\u0018\u00010\u000e2\u000e\b\u0002\u0010L\u001a\b\u0012\u0004\u0012\u00020M0\u00072\n\b\u0002\u0010N\u001a\u0004\u0018\u00010O2\u0010\b\u0002\u0010P\u001a\n\u0012\u0004\u0012\u00020O\u0018\u00010\u000e2\b\b\u0002\u0010Q\u001a\u00020$J&\u0010\u0085\u0001\u001a\u0002042\t\u0010\u0086\u0001\u001a\u0004\u0018\u00010\u00002\b\u0010\u0087\u0001\u001a\u00030\u0088\u00012\b\u0010\u0089\u0001\u001a\u00030\u0088\u0001J\t\u0010\u008a\u0001\u001a\u00020TH\u0016J\t\u0010\u008b\u0001\u001a\u00020TH\u0016J\n\u0010\u008c\u0001\u001a\u00030\u008d\u0001H\u0016R\u0012\u0010S\u001a\u0004\u0018\u00010TX\u0082\u000e¢\u0006\u0004\n\u0002\u0010UR\u0012\u0010V\u001a\u0004\u0018\u00010TX\u0082\u000e¢\u0006\u0004\n\u0002\u0010UR\u0016\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\bW\u0010XR\u001c\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\bY\u0010ZR\u001c\u0010\t\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\u0007X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b[\u0010ZR\u001a\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\f0\u0007X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\\\u0010ZR\u001c\u0010\r\u001a\n\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u000eX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b]\u0010^R\u001c\u0010\u0010\u001a\n\u0012\u0004\u0012\u00020\u0011\u0018\u00010\u000eX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b_\u0010^R\u0016\u0010\u0012\u001a\u0004\u0018\u00010\u0013X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b`\u0010aR\u0018\u0010\u0014\u001a\n\u0012\u0004\u0012\u00020\u0015\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\u0016\u001a\n\u0012\u0004\u0012\u00020\u0015\u0018\u00010\u0007X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\bb\u0010ZR\u0016\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00180\u00078\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0018\u0010\u0019\u001a\n\u0012\u0004\u0012\u00020\u0015\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00150\u00078\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\u001b\u001a\n\u0012\u0004\u0012\u00020\u001c\u0018\u00010\u000eX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\bc\u0010^R\u001c\u0010\u001d\u001a\n\u0012\u0004\u0012\u00020\u001e\u0018\u00010\u000eX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\bd\u0010^R\u0016\u0010\u001f\u001a\u0004\u0018\u00010 X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\be\u0010fR\u001c\u0010!\u001a\n\u0012\u0004\u0012\u00020\"\u0018\u00010\u000eX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\bg\u0010^R\u0014\u0010#\u001a\u00020$X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\bh\u0010iR\u0016\u0010%\u001a\u0004\u0018\u00010&X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\bj\u0010kR\u0012\u0010'\u001a\u0004\u0018\u00010(8\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0016\u0010)\u001a\b\u0012\u0004\u0012\u00020\u00150\u00078\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0018\u0010*\u001a\n\u0012\u0004\u0012\u00020+\u0018\u00010\u000e8\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0016\u0010,\u001a\u0004\u0018\u00010-X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\bl\u0010mR\u0016\u0010.\u001a\u0004\u0018\u00010/X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\bn\u0010oR\u0016\u00100\u001a\b\u0012\u0004\u0012\u0002010\u00078\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0016\u00102\u001a\u0004\u0018\u00010/X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\bp\u0010oR\u0016\u00103\u001a\b\u0012\u0004\u0012\u0002040\u00078\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u001c\u00105\u001a\n\u0012\u0004\u0012\u00020&\u0018\u00010\u0007X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\bq\u0010ZR\u001c\u00106\u001a\n\u0012\u0004\u0012\u00020\u0015\u0018\u00010\u0007X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\br\u0010ZR\u0016\u00107\u001a\b\u0012\u0004\u0012\u0002080\u00078\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0016\u00109\u001a\b\u0012\u0004\u0012\u00020:0\u00078\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u001c\u0010;\u001a\n\u0012\u0004\u0012\u00020<\u0018\u00010\u000eX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\bs\u0010^R\u001c\u0010=\u001a\n\u0012\u0004\u0012\u00020>\u0018\u00010\u000eX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\bt\u0010^R\u0016\u0010?\u001a\u0004\u0018\u00010@X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\bu\u0010vR\u0016\u0010A\u001a\u0004\u0018\u00010BX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\bw\u0010xR\u0016\u0010C\u001a\u0004\u0018\u00010DX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\by\u0010zR\u0016\u0010E\u001a\u0004\u0018\u00010DX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b{\u0010zR\u001c\u0010F\u001a\n\u0012\u0004\u0012\u00020G\u0018\u00010\u000eX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b|\u0010^R\u001c\u0010H\u001a\n\u0012\u0004\u0012\u00020I\u0018\u00010\u000eX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b}\u0010^R\u001c\u0010J\u001a\n\u0012\u0004\u0012\u00020K\u0018\u00010\u000eX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b~\u0010^R\u001a\u0010L\u001a\b\u0012\u0004\u0012\u00020M0\u0007X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u007f\u0010ZR\u0018\u0010N\u001a\u0004\u0018\u00010OX\u0096\u0004¢\u0006\n\n\u0000\u001a\u0006\b\u0080\u0001\u0010\u0081\u0001R\u001d\u0010P\u001a\n\u0012\u0004\u0012\u00020O\u0018\u00010\u000eX\u0096\u0004¢\u0006\t\n\u0000\u001a\u0005\b\u0082\u0001\u0010^R\u0015\u0010Q\u001a\u00020$X\u0096\u0004¢\u0006\t\n\u0000\u001a\u0005\b\u0083\u0001\u0010i¨\u0006\u0093\u0001"}, d2 = {"Lcom/yandex/div2/DivGallery;", "Lcom/yandex/div/json/JSONSerializable;", "Lcom/yandex/div/data/Hashable;", "Lcom/yandex/div2/DivBase;", "accessibility", "Lcom/yandex/div2/DivAccessibility;", "alignmentHorizontal", "Lcom/yandex/div/json/expressions/Expression;", "Lcom/yandex/div2/DivAlignmentHorizontal;", "alignmentVertical", "Lcom/yandex/div2/DivAlignmentVertical;", "alpha", "", "animators", "", "Lcom/yandex/div2/DivAnimator;", J2.g, "Lcom/yandex/div2/DivBackground;", OutlinedTextFieldKt.BorderId, "Lcom/yandex/div2/DivBorder;", "columnCount", "", "columnSpan", "crossContentAlignment", "Lcom/yandex/div2/DivGallery$CrossContentAlignment;", "crossSpacing", "defaultItem", "disappearActions", "Lcom/yandex/div2/DivDisappearAction;", "extensions", "Lcom/yandex/div2/DivExtension;", "focus", "Lcom/yandex/div2/DivFocus;", "functions", "Lcom/yandex/div2/DivFunction;", "height", "Lcom/yandex/div2/DivSize;", "id", "", "itemBuilder", "Lcom/yandex/div2/DivCollectionItemBuilder;", "itemSpacing", FirebaseAnalytics.Param.ITEMS, "Lcom/yandex/div2/Div;", "layoutProvider", "Lcom/yandex/div2/DivLayoutProvider;", "margins", "Lcom/yandex/div2/DivEdgeInsets;", "orientation", "Lcom/yandex/div2/DivGallery$Orientation;", "paddings", "restrictParentScroll", "", "reuseId", "rowSpan", "scrollMode", "Lcom/yandex/div2/DivGallery$ScrollMode;", "scrollbar", "Lcom/yandex/div2/DivGallery$Scrollbar;", "selectedActions", "Lcom/yandex/div2/DivAction;", "tooltips", "Lcom/yandex/div2/DivTooltip;", "transform", "Lcom/yandex/div2/DivTransform;", "transitionChange", "Lcom/yandex/div2/DivChangeTransition;", "transitionIn", "Lcom/yandex/div2/DivAppearanceTransition;", "transitionOut", "transitionTriggers", "Lcom/yandex/div2/DivTransitionTrigger;", "variableTriggers", "Lcom/yandex/div2/DivTrigger;", "variables", "Lcom/yandex/div2/DivVariable;", "visibility", "Lcom/yandex/div2/DivVisibility;", "visibilityAction", "Lcom/yandex/div2/DivVisibilityAction;", "visibilityActions", "width", "(Lcom/yandex/div2/DivAccessibility;Lcom/yandex/div/json/expressions/Expression;Lcom/yandex/div/json/expressions/Expression;Lcom/yandex/div/json/expressions/Expression;Ljava/util/List;Ljava/util/List;Lcom/yandex/div2/DivBorder;Lcom/yandex/div/json/expressions/Expression;Lcom/yandex/div/json/expressions/Expression;Lcom/yandex/div/json/expressions/Expression;Lcom/yandex/div/json/expressions/Expression;Lcom/yandex/div/json/expressions/Expression;Ljava/util/List;Ljava/util/List;Lcom/yandex/div2/DivFocus;Ljava/util/List;Lcom/yandex/div2/DivSize;Ljava/lang/String;Lcom/yandex/div2/DivCollectionItemBuilder;Lcom/yandex/div/json/expressions/Expression;Ljava/util/List;Lcom/yandex/div2/DivLayoutProvider;Lcom/yandex/div2/DivEdgeInsets;Lcom/yandex/div/json/expressions/Expression;Lcom/yandex/div2/DivEdgeInsets;Lcom/yandex/div/json/expressions/Expression;Lcom/yandex/div/json/expressions/Expression;Lcom/yandex/div/json/expressions/Expression;Lcom/yandex/div/json/expressions/Expression;Lcom/yandex/div/json/expressions/Expression;Ljava/util/List;Ljava/util/List;Lcom/yandex/div2/DivTransform;Lcom/yandex/div2/DivChangeTransition;Lcom/yandex/div2/DivAppearanceTransition;Lcom/yandex/div2/DivAppearanceTransition;Ljava/util/List;Ljava/util/List;Ljava/util/List;Lcom/yandex/div/json/expressions/Expression;Lcom/yandex/div2/DivVisibilityAction;Ljava/util/List;Lcom/yandex/div2/DivSize;)V", "_hash", "", "Ljava/lang/Integer;", "_propertiesHash", "getAccessibility", "()Lcom/yandex/div2/DivAccessibility;", "getAlignmentHorizontal", "()Lcom/yandex/div/json/expressions/Expression;", "getAlignmentVertical", "getAlpha", "getAnimators", "()Ljava/util/List;", "getBackground", "getBorder", "()Lcom/yandex/div2/DivBorder;", "getColumnSpan", "getDisappearActions", "getExtensions", "getFocus", "()Lcom/yandex/div2/DivFocus;", "getFunctions", "getHeight", "()Lcom/yandex/div2/DivSize;", "getId", "()Ljava/lang/String;", "getLayoutProvider", "()Lcom/yandex/div2/DivLayoutProvider;", "getMargins", "()Lcom/yandex/div2/DivEdgeInsets;", "getPaddings", "getReuseId", "getRowSpan", "getSelectedActions", "getTooltips", "getTransform", "()Lcom/yandex/div2/DivTransform;", "getTransitionChange", "()Lcom/yandex/div2/DivChangeTransition;", "getTransitionIn", "()Lcom/yandex/div2/DivAppearanceTransition;", "getTransitionOut", "getTransitionTriggers", "getVariableTriggers", "getVariables", "getVisibility", "getVisibilityAction", "()Lcom/yandex/div2/DivVisibilityAction;", "getVisibilityActions", "getWidth", "copy", "equals", "other", "resolver", "Lcom/yandex/div/json/expressions/ExpressionResolver;", "otherResolver", "hash", "propertiesHash", "writeToJSON", "Lorg/json/JSONObject;", "Companion", "CrossContentAlignment", ExifInterface.TAG_ORIENTATION, "ScrollMode", "Scrollbar", "div-data_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class DivGallery implements JSONSerializable, Hashable, DivBase {
    public static final String TYPE = "gallery";
    private Integer _hash;
    private Integer _propertiesHash;
    private final DivAccessibility accessibility;
    private final Expression<DivAlignmentHorizontal> alignmentHorizontal;
    private final Expression<DivAlignmentVertical> alignmentVertical;
    private final Expression<Double> alpha;
    private final List<DivAnimator> animators;
    private final List<DivBackground> background;
    private final DivBorder border;
    public final Expression<Long> columnCount;
    private final Expression<Long> columnSpan;
    public final Expression<CrossContentAlignment> crossContentAlignment;
    public final Expression<Long> crossSpacing;
    public final Expression<Long> defaultItem;
    private final List<DivDisappearAction> disappearActions;
    private final List<DivExtension> extensions;
    private final DivFocus focus;
    private final List<DivFunction> functions;
    private final DivSize height;
    private final String id;
    public final DivCollectionItemBuilder itemBuilder;
    public final Expression<Long> itemSpacing;
    public final List<Div> items;
    private final DivLayoutProvider layoutProvider;
    private final DivEdgeInsets margins;
    public final Expression<Orientation> orientation;
    private final DivEdgeInsets paddings;
    public final Expression<Boolean> restrictParentScroll;
    private final Expression<String> reuseId;
    private final Expression<Long> rowSpan;
    public final Expression<ScrollMode> scrollMode;
    public final Expression<Scrollbar> scrollbar;
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

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final Expression<Double> ALPHA_DEFAULT_VALUE = Expression.INSTANCE.constant(Double.valueOf(1.0d));
    private static final Expression<CrossContentAlignment> CROSS_CONTENT_ALIGNMENT_DEFAULT_VALUE = Expression.INSTANCE.constant(CrossContentAlignment.START);
    private static final Expression<Long> DEFAULT_ITEM_DEFAULT_VALUE = Expression.INSTANCE.constant(0L);
    private static final DivSize.WrapContent HEIGHT_DEFAULT_VALUE = new DivSize.WrapContent(new DivWrapContentSize(null, null, null, 7, null));
    private static final Expression<Long> ITEM_SPACING_DEFAULT_VALUE = Expression.INSTANCE.constant(8L);
    private static final Expression<Orientation> ORIENTATION_DEFAULT_VALUE = Expression.INSTANCE.constant(Orientation.HORIZONTAL);
    private static final Expression<Boolean> RESTRICT_PARENT_SCROLL_DEFAULT_VALUE = Expression.INSTANCE.constant(false);
    private static final Expression<ScrollMode> SCROLL_MODE_DEFAULT_VALUE = Expression.INSTANCE.constant(ScrollMode.DEFAULT);
    private static final Expression<Scrollbar> SCROLLBAR_DEFAULT_VALUE = Expression.INSTANCE.constant(Scrollbar.NONE);
    private static final Expression<DivVisibility> VISIBILITY_DEFAULT_VALUE = Expression.INSTANCE.constant(DivVisibility.VISIBLE);
    private static final DivSize.MatchParent WIDTH_DEFAULT_VALUE = new DivSize.MatchParent(new DivMatchParentSize(0 == true ? 1 : 0, 1, 0 == true ? 1 : 0));
    private static final Function2<ParsingEnvironment, JSONObject, DivGallery> CREATOR = new Function2<ParsingEnvironment, JSONObject, DivGallery>() { // from class: com.yandex.div2.DivGallery$Companion$CREATOR$1
        @Override // kotlin.jvm.functions.Function2
        public final DivGallery invoke(ParsingEnvironment env, JSONObject it) {
            Intrinsics.checkNotNullParameter(env, "env");
            Intrinsics.checkNotNullParameter(it, "it");
            return DivGallery.INSTANCE.fromJson(env, it);
        }
    };

    public DivGallery() {
        this(null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, -1, 2047, null);
    }

    @JvmStatic
    public static final DivGallery fromJson(ParsingEnvironment parsingEnvironment, JSONObject jSONObject) {
        return INSTANCE.fromJson(parsingEnvironment, jSONObject);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public DivGallery(DivAccessibility divAccessibility, Expression<DivAlignmentHorizontal> expression, Expression<DivAlignmentVertical> expression2, Expression<Double> alpha, List<? extends DivAnimator> list, List<? extends DivBackground> list2, DivBorder divBorder, Expression<Long> expression3, Expression<Long> expression4, Expression<CrossContentAlignment> crossContentAlignment, Expression<Long> expression5, Expression<Long> defaultItem, List<DivDisappearAction> list3, List<DivExtension> list4, DivFocus divFocus, List<DivFunction> list5, DivSize height, String str, DivCollectionItemBuilder divCollectionItemBuilder, Expression<Long> itemSpacing, List<? extends Div> list6, DivLayoutProvider divLayoutProvider, DivEdgeInsets divEdgeInsets, Expression<Orientation> orientation, DivEdgeInsets divEdgeInsets2, Expression<Boolean> restrictParentScroll, Expression<String> expression6, Expression<Long> expression7, Expression<ScrollMode> scrollMode, Expression<Scrollbar> scrollbar, List<DivAction> list7, List<DivTooltip> list8, DivTransform divTransform, DivChangeTransition divChangeTransition, DivAppearanceTransition divAppearanceTransition, DivAppearanceTransition divAppearanceTransition2, List<? extends DivTransitionTrigger> list9, List<DivTrigger> list10, List<? extends DivVariable> list11, Expression<DivVisibility> visibility, DivVisibilityAction divVisibilityAction, List<DivVisibilityAction> list12, DivSize width) {
        Intrinsics.checkNotNullParameter(alpha, "alpha");
        Intrinsics.checkNotNullParameter(crossContentAlignment, "crossContentAlignment");
        Intrinsics.checkNotNullParameter(defaultItem, "defaultItem");
        Intrinsics.checkNotNullParameter(height, "height");
        Intrinsics.checkNotNullParameter(itemSpacing, "itemSpacing");
        Intrinsics.checkNotNullParameter(orientation, "orientation");
        Intrinsics.checkNotNullParameter(restrictParentScroll, "restrictParentScroll");
        Intrinsics.checkNotNullParameter(scrollMode, "scrollMode");
        Intrinsics.checkNotNullParameter(scrollbar, "scrollbar");
        Intrinsics.checkNotNullParameter(visibility, "visibility");
        Intrinsics.checkNotNullParameter(width, "width");
        this.accessibility = divAccessibility;
        this.alignmentHorizontal = expression;
        this.alignmentVertical = expression2;
        this.alpha = alpha;
        this.animators = list;
        this.background = list2;
        this.border = divBorder;
        this.columnCount = expression3;
        this.columnSpan = expression4;
        this.crossContentAlignment = crossContentAlignment;
        this.crossSpacing = expression5;
        this.defaultItem = defaultItem;
        this.disappearActions = list3;
        this.extensions = list4;
        this.focus = divFocus;
        this.functions = list5;
        this.height = height;
        this.id = str;
        this.itemBuilder = divCollectionItemBuilder;
        this.itemSpacing = itemSpacing;
        this.items = list6;
        this.layoutProvider = divLayoutProvider;
        this.margins = divEdgeInsets;
        this.orientation = orientation;
        this.paddings = divEdgeInsets2;
        this.restrictParentScroll = restrictParentScroll;
        this.reuseId = expression6;
        this.rowSpan = expression7;
        this.scrollMode = scrollMode;
        this.scrollbar = scrollbar;
        this.selectedActions = list7;
        this.tooltips = list8;
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

    public /* synthetic */ DivGallery(DivAccessibility divAccessibility, Expression expression, Expression expression2, Expression expression3, List list, List list2, DivBorder divBorder, Expression expression4, Expression expression5, Expression expression6, Expression expression7, Expression expression8, List list3, List list4, DivFocus divFocus, List list5, DivSize divSize, String str, DivCollectionItemBuilder divCollectionItemBuilder, Expression expression9, List list6, DivLayoutProvider divLayoutProvider, DivEdgeInsets divEdgeInsets, Expression expression10, DivEdgeInsets divEdgeInsets2, Expression expression11, Expression expression12, Expression expression13, Expression expression14, Expression expression15, List list7, List list8, DivTransform divTransform, DivChangeTransition divChangeTransition, DivAppearanceTransition divAppearanceTransition, DivAppearanceTransition divAppearanceTransition2, List list9, List list10, List list11, Expression expression16, DivVisibilityAction divVisibilityAction, List list12, DivSize divSize2, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : divAccessibility, (i & 2) != 0 ? null : expression, (i & 4) != 0 ? null : expression2, (i & 8) != 0 ? ALPHA_DEFAULT_VALUE : expression3, (i & 16) != 0 ? null : list, (i & 32) != 0 ? null : list2, (i & 64) != 0 ? null : divBorder, (i & 128) != 0 ? null : expression4, (i & 256) != 0 ? null : expression5, (i & 512) != 0 ? CROSS_CONTENT_ALIGNMENT_DEFAULT_VALUE : expression6, (i & 1024) != 0 ? null : expression7, (i & 2048) != 0 ? DEFAULT_ITEM_DEFAULT_VALUE : expression8, (i & 4096) != 0 ? null : list3, (i & 8192) != 0 ? null : list4, (i & 16384) != 0 ? null : divFocus, (i & 32768) != 0 ? null : list5, (i & 65536) != 0 ? HEIGHT_DEFAULT_VALUE : divSize, (i & 131072) != 0 ? null : str, (i & 262144) != 0 ? null : divCollectionItemBuilder, (i & 524288) != 0 ? ITEM_SPACING_DEFAULT_VALUE : expression9, (i & 1048576) != 0 ? null : list6, (i & 2097152) != 0 ? null : divLayoutProvider, (i & 4194304) != 0 ? null : divEdgeInsets, (i & 8388608) != 0 ? ORIENTATION_DEFAULT_VALUE : expression10, (i & 16777216) != 0 ? null : divEdgeInsets2, (i & 33554432) != 0 ? RESTRICT_PARENT_SCROLL_DEFAULT_VALUE : expression11, (i & 67108864) != 0 ? null : expression12, (i & 134217728) != 0 ? null : expression13, (i & 268435456) != 0 ? SCROLL_MODE_DEFAULT_VALUE : expression14, (i & 536870912) != 0 ? SCROLLBAR_DEFAULT_VALUE : expression15, (i & 1073741824) != 0 ? null : list7, (i & Integer.MIN_VALUE) != 0 ? null : list8, (i2 & 1) != 0 ? null : divTransform, (i2 & 2) != 0 ? null : divChangeTransition, (i2 & 4) != 0 ? null : divAppearanceTransition, (i2 & 8) != 0 ? null : divAppearanceTransition2, (i2 & 16) != 0 ? null : list9, (i2 & 32) != 0 ? null : list10, (i2 & 64) != 0 ? null : list11, (i2 & 128) != 0 ? VISIBILITY_DEFAULT_VALUE : expression16, (i2 & 256) != 0 ? null : divVisibilityAction, (i2 & 512) != 0 ? null : list12, (i2 & 1024) != 0 ? WIDTH_DEFAULT_VALUE : divSize2);
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
        Expression<Long> expression = this.columnCount;
        int iHashCode4 = iHash12 + (expression != null ? expression.hashCode() : 0);
        Expression<Long> columnSpan = getColumnSpan();
        int iHashCode5 = iHashCode4 + (columnSpan != null ? columnSpan.hashCode() : 0) + this.crossContentAlignment.hashCode();
        Expression<Long> expression2 = this.crossSpacing;
        int iHashCode6 = iHashCode5 + (expression2 != null ? expression2.hashCode() : 0) + this.defaultItem.hashCode();
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
        int i3 = iHashCode6 + iHash3;
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
        DivCollectionItemBuilder divCollectionItemBuilder = this.itemBuilder;
        int iHash15 = iHashCode7 + (divCollectionItemBuilder != null ? divCollectionItemBuilder.hash() : 0) + this.itemSpacing.hashCode();
        DivLayoutProvider layoutProvider = getLayoutProvider();
        int iHash16 = iHash15 + (layoutProvider != null ? layoutProvider.hash() : 0);
        DivEdgeInsets margins = getMargins();
        int iHash17 = iHash16 + (margins != null ? margins.hash() : 0) + this.orientation.hashCode();
        DivEdgeInsets paddings = getPaddings();
        int iHash18 = iHash17 + (paddings != null ? paddings.hash() : 0) + this.restrictParentScroll.hashCode();
        Expression<String> reuseId = getReuseId();
        int iHashCode8 = iHash18 + (reuseId != null ? reuseId.hashCode() : 0);
        Expression<Long> rowSpan = getRowSpan();
        int iHashCode9 = iHashCode8 + (rowSpan != null ? rowSpan.hashCode() : 0) + this.scrollMode.hashCode() + this.scrollbar.hashCode();
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
        int i6 = i5 + iHash7;
        DivTransform transform = getTransform();
        int iHash19 = i6 + (transform != null ? transform.hash() : 0);
        DivChangeTransition transitionChange = getTransitionChange();
        int iHash20 = iHash19 + (transitionChange != null ? transitionChange.hash() : 0);
        DivAppearanceTransition transitionIn = getTransitionIn();
        int iHash21 = iHash20 + (transitionIn != null ? transitionIn.hash() : 0);
        DivAppearanceTransition transitionOut = getTransitionOut();
        int iHash22 = iHash21 + (transitionOut != null ? transitionOut.hash() : 0);
        List<DivTransitionTrigger> transitionTriggers = getTransitionTriggers();
        int iHashCode10 = iHash22 + (transitionTriggers != null ? transitionTriggers.hashCode() : 0);
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
        int i7 = iHashCode10 + iHash8;
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
        int iHashCode11 = i7 + iHash9 + getVisibility().hashCode();
        DivVisibilityAction visibilityAction = getVisibilityAction();
        int iHash23 = iHashCode11 + (visibilityAction != null ? visibilityAction.hash() : 0);
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

    public final boolean equals(DivGallery other, ExpressionResolver resolver, ExpressionResolver otherResolver) {
        boolean zEquals;
        boolean z;
        boolean z2;
        boolean zEquals2;
        boolean z3;
        boolean z4;
        boolean zEquals3;
        boolean z5;
        boolean zEquals4;
        boolean z6;
        boolean zEquals5;
        boolean zEquals6;
        boolean zEquals7;
        boolean z7;
        boolean z8;
        boolean zEquals8;
        boolean zEquals9;
        boolean zEquals10;
        boolean zEquals11;
        boolean z9;
        boolean z10;
        boolean z11;
        boolean zEquals12;
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
        Expression<Long> expression = this.columnCount;
        Long lEvaluate = expression != null ? expression.evaluate(resolver) : null;
        Expression<Long> expression2 = other.columnCount;
        if (!Intrinsics.areEqual(lEvaluate, expression2 != null ? expression2.evaluate(otherResolver) : null)) {
            return false;
        }
        Expression<Long> columnSpan = getColumnSpan();
        Long lEvaluate2 = columnSpan != null ? columnSpan.evaluate(resolver) : null;
        Expression<Long> columnSpan2 = other.getColumnSpan();
        if (!Intrinsics.areEqual(lEvaluate2, columnSpan2 != null ? columnSpan2.evaluate(otherResolver) : null) || this.crossContentAlignment.evaluate(resolver) != other.crossContentAlignment.evaluate(otherResolver)) {
            return false;
        }
        Expression<Long> expression3 = this.crossSpacing;
        Long lEvaluate3 = expression3 != null ? expression3.evaluate(resolver) : null;
        Expression<Long> expression4 = other.crossSpacing;
        if (!Intrinsics.areEqual(lEvaluate3, expression4 != null ? expression4.evaluate(otherResolver) : null) || this.defaultItem.evaluate(resolver).longValue() != other.defaultItem.evaluate(otherResolver).longValue()) {
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
        if (!z5 || !getHeight().equals(other.getHeight(), resolver, otherResolver) || !Intrinsics.areEqual(getId(), other.getId())) {
            return false;
        }
        DivCollectionItemBuilder divCollectionItemBuilder = this.itemBuilder;
        if (divCollectionItemBuilder != null) {
            zEquals4 = divCollectionItemBuilder.equals(other.itemBuilder, resolver, otherResolver);
        } else {
            zEquals4 = other.itemBuilder == null;
        }
        if (!zEquals4 || this.itemSpacing.evaluate(resolver).longValue() != other.itemSpacing.evaluate(otherResolver).longValue()) {
            return false;
        }
        List<Div> list = this.items;
        if (list != null) {
            List<Div> list2 = other.items;
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
                        if (((Div) next6).equals(list2.get(i11), resolver, otherResolver)) {
                            i11 = i12;
                        }
                    }
                }
            }
        } else {
            z6 = other.items == null;
        }
        if (!z6) {
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
        if (!zEquals6 || this.orientation.evaluate(resolver) != other.orientation.evaluate(otherResolver)) {
            return false;
        }
        DivEdgeInsets paddings = getPaddings();
        if (paddings != null) {
            zEquals7 = paddings.equals(other.getPaddings(), resolver, otherResolver);
        } else {
            zEquals7 = other.getPaddings() == null;
        }
        if (!zEquals7 || this.restrictParentScroll.evaluate(resolver).booleanValue() != other.restrictParentScroll.evaluate(otherResolver).booleanValue()) {
            return false;
        }
        Expression<String> reuseId = getReuseId();
        String strEvaluate = reuseId != null ? reuseId.evaluate(resolver) : null;
        Expression<String> reuseId2 = other.getReuseId();
        if (!Intrinsics.areEqual(strEvaluate, reuseId2 != null ? reuseId2.evaluate(otherResolver) : null)) {
            return false;
        }
        Expression<Long> rowSpan = getRowSpan();
        Long lEvaluate4 = rowSpan != null ? rowSpan.evaluate(resolver) : null;
        Expression<Long> rowSpan2 = other.getRowSpan();
        if (!Intrinsics.areEqual(lEvaluate4, rowSpan2 != null ? rowSpan2.evaluate(otherResolver) : null) || this.scrollMode.evaluate(resolver) != other.scrollMode.evaluate(otherResolver) || this.scrollbar.evaluate(resolver) != other.scrollbar.evaluate(otherResolver)) {
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
    public static /* synthetic */ DivGallery copy$default(DivGallery divGallery, DivAccessibility divAccessibility, Expression expression, Expression expression2, Expression expression3, List list, List list2, DivBorder divBorder, Expression expression4, Expression expression5, Expression expression6, Expression expression7, Expression expression8, List list3, List list4, DivFocus divFocus, List list5, DivSize divSize, String str, DivCollectionItemBuilder divCollectionItemBuilder, Expression expression9, List list6, DivLayoutProvider divLayoutProvider, DivEdgeInsets divEdgeInsets, Expression expression10, DivEdgeInsets divEdgeInsets2, Expression expression11, Expression expression12, Expression expression13, Expression expression14, Expression expression15, List list7, List list8, DivTransform divTransform, DivChangeTransition divChangeTransition, DivAppearanceTransition divAppearanceTransition, DivAppearanceTransition divAppearanceTransition2, List list9, List list10, List list11, Expression expression16, DivVisibilityAction divVisibilityAction, List list12, DivSize divSize2, int i, int i2, Object obj) {
        DivAccessibility accessibility = (i & 1) != 0 ? divGallery.getAccessibility() : divAccessibility;
        Expression alignmentHorizontal = (i & 2) != 0 ? divGallery.getAlignmentHorizontal() : expression;
        Expression alignmentVertical = (i & 4) != 0 ? divGallery.getAlignmentVertical() : expression2;
        Expression alpha = (i & 8) != 0 ? divGallery.getAlpha() : expression3;
        List animators = (i & 16) != 0 ? divGallery.getAnimators() : list;
        List background = (i & 32) != 0 ? divGallery.getBackground() : list2;
        DivBorder border = (i & 64) != 0 ? divGallery.getBorder() : divBorder;
        Expression expression17 = (i & 128) != 0 ? divGallery.columnCount : expression4;
        Expression columnSpan = (i & 256) != 0 ? divGallery.getColumnSpan() : expression5;
        Expression expression18 = (i & 512) != 0 ? divGallery.crossContentAlignment : expression6;
        Expression expression19 = (i & 1024) != 0 ? divGallery.crossSpacing : expression7;
        Expression expression20 = (i & 2048) != 0 ? divGallery.defaultItem : expression8;
        List disappearActions = (i & 4096) != 0 ? divGallery.getDisappearActions() : list3;
        List extensions = (i & 8192) != 0 ? divGallery.getExtensions() : list4;
        DivFocus focus = (i & 16384) != 0 ? divGallery.getFocus() : divFocus;
        List functions = (i & 32768) != 0 ? divGallery.getFunctions() : list5;
        DivSize height = (i & 65536) != 0 ? divGallery.getHeight() : divSize;
        String id = (i & 131072) != 0 ? divGallery.getId() : str;
        DivFocus divFocus2 = focus;
        DivCollectionItemBuilder divCollectionItemBuilder2 = (i & 262144) != 0 ? divGallery.itemBuilder : divCollectionItemBuilder;
        Expression expression21 = (i & 524288) != 0 ? divGallery.itemSpacing : expression9;
        List list13 = (i & 1048576) != 0 ? divGallery.items : list6;
        DivLayoutProvider layoutProvider = (i & 2097152) != 0 ? divGallery.getLayoutProvider() : divLayoutProvider;
        DivEdgeInsets margins = (i & 4194304) != 0 ? divGallery.getMargins() : divEdgeInsets;
        List list14 = list13;
        Expression expression22 = (i & 8388608) != 0 ? divGallery.orientation : expression10;
        return divGallery.copy(accessibility, alignmentHorizontal, alignmentVertical, alpha, animators, background, border, expression17, columnSpan, expression18, expression19, expression20, disappearActions, extensions, divFocus2, functions, height, id, divCollectionItemBuilder2, expression21, list14, layoutProvider, margins, expression22, (i & 16777216) != 0 ? divGallery.getPaddings() : divEdgeInsets2, (i & 33554432) != 0 ? divGallery.restrictParentScroll : expression11, (i & 67108864) != 0 ? divGallery.getReuseId() : expression12, (i & 134217728) != 0 ? divGallery.getRowSpan() : expression13, (i & 268435456) != 0 ? divGallery.scrollMode : expression14, (i & 536870912) != 0 ? divGallery.scrollbar : expression15, (i & 1073741824) != 0 ? divGallery.getSelectedActions() : list7, (i & Integer.MIN_VALUE) != 0 ? divGallery.getTooltips() : list8, (i2 & 1) != 0 ? divGallery.getTransform() : divTransform, (i2 & 2) != 0 ? divGallery.getTransitionChange() : divChangeTransition, (i2 & 4) != 0 ? divGallery.getTransitionIn() : divAppearanceTransition, (i2 & 8) != 0 ? divGallery.getTransitionOut() : divAppearanceTransition2, (i2 & 16) != 0 ? divGallery.getTransitionTriggers() : list9, (i2 & 32) != 0 ? divGallery.getVariableTriggers() : list10, (i2 & 64) != 0 ? divGallery.getVariables() : list11, (i2 & 128) != 0 ? divGallery.getVisibility() : expression16, (i2 & 256) != 0 ? divGallery.getVisibilityAction() : divVisibilityAction, (i2 & 512) != 0 ? divGallery.getVisibilityActions() : list12, (i2 & 1024) != 0 ? divGallery.getWidth() : divSize2);
    }

    public final DivGallery copy(DivAccessibility accessibility, Expression<DivAlignmentHorizontal> alignmentHorizontal, Expression<DivAlignmentVertical> alignmentVertical, Expression<Double> alpha, List<? extends DivAnimator> animators, List<? extends DivBackground> background, DivBorder border, Expression<Long> columnCount, Expression<Long> columnSpan, Expression<CrossContentAlignment> crossContentAlignment, Expression<Long> crossSpacing, Expression<Long> defaultItem, List<DivDisappearAction> disappearActions, List<DivExtension> extensions, DivFocus focus, List<DivFunction> functions, DivSize height, String id, DivCollectionItemBuilder itemBuilder, Expression<Long> itemSpacing, List<? extends Div> items, DivLayoutProvider layoutProvider, DivEdgeInsets margins, Expression<Orientation> orientation, DivEdgeInsets paddings, Expression<Boolean> restrictParentScroll, Expression<String> reuseId, Expression<Long> rowSpan, Expression<ScrollMode> scrollMode, Expression<Scrollbar> scrollbar, List<DivAction> selectedActions, List<DivTooltip> tooltips, DivTransform transform, DivChangeTransition transitionChange, DivAppearanceTransition transitionIn, DivAppearanceTransition transitionOut, List<? extends DivTransitionTrigger> transitionTriggers, List<DivTrigger> variableTriggers, List<? extends DivVariable> variables, Expression<DivVisibility> visibility, DivVisibilityAction visibilityAction, List<DivVisibilityAction> visibilityActions, DivSize width) {
        Intrinsics.checkNotNullParameter(alpha, "alpha");
        Intrinsics.checkNotNullParameter(crossContentAlignment, "crossContentAlignment");
        Intrinsics.checkNotNullParameter(defaultItem, "defaultItem");
        Intrinsics.checkNotNullParameter(height, "height");
        Intrinsics.checkNotNullParameter(itemSpacing, "itemSpacing");
        Intrinsics.checkNotNullParameter(orientation, "orientation");
        Intrinsics.checkNotNullParameter(restrictParentScroll, "restrictParentScroll");
        Intrinsics.checkNotNullParameter(scrollMode, "scrollMode");
        Intrinsics.checkNotNullParameter(scrollbar, "scrollbar");
        Intrinsics.checkNotNullParameter(visibility, "visibility");
        Intrinsics.checkNotNullParameter(width, "width");
        return new DivGallery(accessibility, alignmentHorizontal, alignmentVertical, alpha, animators, background, border, columnCount, columnSpan, crossContentAlignment, crossSpacing, defaultItem, disappearActions, extensions, focus, functions, height, id, itemBuilder, itemSpacing, items, layoutProvider, margins, orientation, paddings, restrictParentScroll, reuseId, rowSpan, scrollMode, scrollbar, selectedActions, tooltips, transform, transitionChange, transitionIn, transitionOut, transitionTriggers, variableTriggers, variables, visibility, visibilityAction, visibilityActions, width);
    }

    @Override // com.yandex.div.json.JSONSerializable
    public JSONObject writeToJSON() {
        return BuiltInParserKt.getBuiltInParserComponent().getDivGalleryJsonEntityParser().getValue().serialize(BuiltInParserKt.getBuiltInParsingContext(), this);
    }

    /* JADX INFO: compiled from: DivGallery.kt */
    @Metadata(d1 = {"\u0000j\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0006\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u001e\u0010\"\u001a\u00020\n2\u0006\u0010#\u001a\u00020\b2\u0006\u0010$\u001a\u00020\tH\u0087\u0002¢\u0006\u0002\b%R\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R#\u0010\u0006\u001a\u0014\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\n0\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0014\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000e0\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00100\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00100\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00150\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00170\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00190\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u001b0\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u001dX\u0086T¢\u0006\u0002\n\u0000R\u0014\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u001f0\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010 \u001a\u00020!X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006&"}, d2 = {"Lcom/yandex/div2/DivGallery$Companion;", "", "()V", "ALPHA_DEFAULT_VALUE", "Lcom/yandex/div/json/expressions/Expression;", "", "CREATOR", "Lkotlin/Function2;", "Lcom/yandex/div/json/ParsingEnvironment;", "Lorg/json/JSONObject;", "Lcom/yandex/div2/DivGallery;", "getCREATOR", "()Lkotlin/jvm/functions/Function2;", "CROSS_CONTENT_ALIGNMENT_DEFAULT_VALUE", "Lcom/yandex/div2/DivGallery$CrossContentAlignment;", "DEFAULT_ITEM_DEFAULT_VALUE", "", "HEIGHT_DEFAULT_VALUE", "Lcom/yandex/div2/DivSize$WrapContent;", "ITEM_SPACING_DEFAULT_VALUE", "ORIENTATION_DEFAULT_VALUE", "Lcom/yandex/div2/DivGallery$Orientation;", "RESTRICT_PARENT_SCROLL_DEFAULT_VALUE", "", "SCROLLBAR_DEFAULT_VALUE", "Lcom/yandex/div2/DivGallery$Scrollbar;", "SCROLL_MODE_DEFAULT_VALUE", "Lcom/yandex/div2/DivGallery$ScrollMode;", "TYPE", "", "VISIBILITY_DEFAULT_VALUE", "Lcom/yandex/div2/DivVisibility;", "WIDTH_DEFAULT_VALUE", "Lcom/yandex/div2/DivSize$MatchParent;", "invoke", cc.o, "json", "fromJson", "div-data_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @JvmStatic
        public final DivGallery fromJson(ParsingEnvironment env, JSONObject json) {
            Intrinsics.checkNotNullParameter(env, "env");
            Intrinsics.checkNotNullParameter(json, "json");
            return BuiltInParserKt.getBuiltInParserComponent().getDivGalleryJsonEntityParser().getValue().deserialize((ParsingContext) env, json);
        }

        public final Function2<ParsingEnvironment, JSONObject, DivGallery> getCREATOR() {
            return DivGallery.CREATOR;
        }
    }

    /* JADX INFO: compiled from: DivGallery.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\b\u0086\u0001\u0018\u0000 \b2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\bB\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007¨\u0006\t"}, d2 = {"Lcom/yandex/div2/DivGallery$CrossContentAlignment;", "", "value", "", "(Ljava/lang/String;ILjava/lang/String;)V", POBOMSDKLogConstants.MSG_OMSDK_START_EVENT, "CENTER", "END", "Converter", "div-data_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public enum CrossContentAlignment {
        START("start"),
        CENTER("center"),
        END("end");

        private final String value;

        /* JADX INFO: renamed from: Converter, reason: from kotlin metadata */
        public static final Companion INSTANCE = new Companion(null);
        public static final Function1<CrossContentAlignment, String> TO_STRING = new Function1<CrossContentAlignment, String>() { // from class: com.yandex.div2.DivGallery$CrossContentAlignment$Converter$TO_STRING$1
            @Override // kotlin.jvm.functions.Function1
            public final String invoke(DivGallery.CrossContentAlignment value) {
                Intrinsics.checkNotNullParameter(value, "value");
                return DivGallery.CrossContentAlignment.INSTANCE.toString(value);
            }
        };
        public static final Function1<String, CrossContentAlignment> FROM_STRING = new Function1<String, CrossContentAlignment>() { // from class: com.yandex.div2.DivGallery$CrossContentAlignment$Converter$FROM_STRING$1
            @Override // kotlin.jvm.functions.Function1
            public final DivGallery.CrossContentAlignment invoke(String value) {
                Intrinsics.checkNotNullParameter(value, "value");
                return DivGallery.CrossContentAlignment.INSTANCE.fromString(value);
            }
        };

        CrossContentAlignment(String str) {
            this.value = str;
        }

        /* JADX INFO: renamed from: com.yandex.div2.DivGallery$CrossContentAlignment$Converter, reason: from kotlin metadata */
        /* JADX INFO: compiled from: DivGallery.kt */
        @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\b\u001a\u0004\u0018\u00010\u00062\u0006\u0010\t\u001a\u00020\u0005J\u000e\u0010\n\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\u0006R\u001e\u0010\u0003\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u00048\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00050\u00048\u0006X\u0087\u0004¢\u0006\u0002\n\u0000¨\u0006\f"}, d2 = {"Lcom/yandex/div2/DivGallery$CrossContentAlignment$Converter;", "", "()V", "FROM_STRING", "Lkotlin/Function1;", "", "Lcom/yandex/div2/DivGallery$CrossContentAlignment;", "TO_STRING", "fromString", "value", "toString", "obj", "div-data_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private Companion() {
            }

            public final String toString(CrossContentAlignment obj) {
                Intrinsics.checkNotNullParameter(obj, "obj");
                return obj.value;
            }

            public final CrossContentAlignment fromString(String value) {
                Intrinsics.checkNotNullParameter(value, "value");
                if (Intrinsics.areEqual(value, CrossContentAlignment.START.value)) {
                    return CrossContentAlignment.START;
                }
                if (Intrinsics.areEqual(value, CrossContentAlignment.CENTER.value)) {
                    return CrossContentAlignment.CENTER;
                }
                if (Intrinsics.areEqual(value, CrossContentAlignment.END.value)) {
                    return CrossContentAlignment.END;
                }
                return null;
            }
        }
    }

    /* JADX INFO: compiled from: DivGallery.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0001\u0018\u0000 \u00072\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u0007B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000j\u0002\b\u0005j\u0002\b\u0006¨\u0006\b"}, d2 = {"Lcom/yandex/div2/DivGallery$ScrollMode;", "", "value", "", "(Ljava/lang/String;ILjava/lang/String;)V", "PAGING", "DEFAULT", "Converter", "div-data_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public enum ScrollMode {
        PAGING("paging"),
        DEFAULT("default");

        private final String value;

        /* JADX INFO: renamed from: Converter, reason: from kotlin metadata */
        public static final Companion INSTANCE = new Companion(null);
        public static final Function1<ScrollMode, String> TO_STRING = new Function1<ScrollMode, String>() { // from class: com.yandex.div2.DivGallery$ScrollMode$Converter$TO_STRING$1
            @Override // kotlin.jvm.functions.Function1
            public final String invoke(DivGallery.ScrollMode value) {
                Intrinsics.checkNotNullParameter(value, "value");
                return DivGallery.ScrollMode.INSTANCE.toString(value);
            }
        };
        public static final Function1<String, ScrollMode> FROM_STRING = new Function1<String, ScrollMode>() { // from class: com.yandex.div2.DivGallery$ScrollMode$Converter$FROM_STRING$1
            @Override // kotlin.jvm.functions.Function1
            public final DivGallery.ScrollMode invoke(String value) {
                Intrinsics.checkNotNullParameter(value, "value");
                return DivGallery.ScrollMode.INSTANCE.fromString(value);
            }
        };

        ScrollMode(String str) {
            this.value = str;
        }

        /* JADX INFO: renamed from: com.yandex.div2.DivGallery$ScrollMode$Converter, reason: from kotlin metadata */
        /* JADX INFO: compiled from: DivGallery.kt */
        @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\b\u001a\u0004\u0018\u00010\u00062\u0006\u0010\t\u001a\u00020\u0005J\u000e\u0010\n\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\u0006R\u001e\u0010\u0003\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u00048\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00050\u00048\u0006X\u0087\u0004¢\u0006\u0002\n\u0000¨\u0006\f"}, d2 = {"Lcom/yandex/div2/DivGallery$ScrollMode$Converter;", "", "()V", "FROM_STRING", "Lkotlin/Function1;", "", "Lcom/yandex/div2/DivGallery$ScrollMode;", "TO_STRING", "fromString", "value", "toString", "obj", "div-data_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private Companion() {
            }

            public final String toString(ScrollMode obj) {
                Intrinsics.checkNotNullParameter(obj, "obj");
                return obj.value;
            }

            public final ScrollMode fromString(String value) {
                Intrinsics.checkNotNullParameter(value, "value");
                if (Intrinsics.areEqual(value, ScrollMode.PAGING.value)) {
                    return ScrollMode.PAGING;
                }
                if (Intrinsics.areEqual(value, ScrollMode.DEFAULT.value)) {
                    return ScrollMode.DEFAULT;
                }
                return null;
            }
        }
    }

    /* JADX INFO: compiled from: DivGallery.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0001\u0018\u0000 \u00072\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u0007B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000j\u0002\b\u0005j\u0002\b\u0006¨\u0006\b"}, d2 = {"Lcom/yandex/div2/DivGallery$Orientation;", "", "value", "", "(Ljava/lang/String;ILjava/lang/String;)V", "HORIZONTAL", "VERTICAL", "Converter", "div-data_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public enum Orientation {
        HORIZONTAL("horizontal"),
        VERTICAL("vertical");

        private final String value;

        /* JADX INFO: renamed from: Converter, reason: from kotlin metadata */
        public static final Companion INSTANCE = new Companion(null);
        public static final Function1<Orientation, String> TO_STRING = new Function1<Orientation, String>() { // from class: com.yandex.div2.DivGallery$Orientation$Converter$TO_STRING$1
            @Override // kotlin.jvm.functions.Function1
            public final String invoke(DivGallery.Orientation value) {
                Intrinsics.checkNotNullParameter(value, "value");
                return DivGallery.Orientation.INSTANCE.toString(value);
            }
        };
        public static final Function1<String, Orientation> FROM_STRING = new Function1<String, Orientation>() { // from class: com.yandex.div2.DivGallery$Orientation$Converter$FROM_STRING$1
            @Override // kotlin.jvm.functions.Function1
            public final DivGallery.Orientation invoke(String value) {
                Intrinsics.checkNotNullParameter(value, "value");
                return DivGallery.Orientation.INSTANCE.fromString(value);
            }
        };

        Orientation(String str) {
            this.value = str;
        }

        /* JADX INFO: renamed from: com.yandex.div2.DivGallery$Orientation$Converter, reason: from kotlin metadata */
        /* JADX INFO: compiled from: DivGallery.kt */
        @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\b\u001a\u0004\u0018\u00010\u00062\u0006\u0010\t\u001a\u00020\u0005J\u000e\u0010\n\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\u0006R\u001e\u0010\u0003\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u00048\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00050\u00048\u0006X\u0087\u0004¢\u0006\u0002\n\u0000¨\u0006\f"}, d2 = {"Lcom/yandex/div2/DivGallery$Orientation$Converter;", "", "()V", "FROM_STRING", "Lkotlin/Function1;", "", "Lcom/yandex/div2/DivGallery$Orientation;", "TO_STRING", "fromString", "value", "toString", "obj", "div-data_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private Companion() {
            }

            public final String toString(Orientation obj) {
                Intrinsics.checkNotNullParameter(obj, "obj");
                return obj.value;
            }

            public final Orientation fromString(String value) {
                Intrinsics.checkNotNullParameter(value, "value");
                if (Intrinsics.areEqual(value, Orientation.HORIZONTAL.value)) {
                    return Orientation.HORIZONTAL;
                }
                if (Intrinsics.areEqual(value, Orientation.VERTICAL.value)) {
                    return Orientation.VERTICAL;
                }
                return null;
            }
        }
    }

    /* JADX INFO: compiled from: DivGallery.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0001\u0018\u0000 \u00072\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u0007B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000j\u0002\b\u0005j\u0002\b\u0006¨\u0006\b"}, d2 = {"Lcom/yandex/div2/DivGallery$Scrollbar;", "", "value", "", "(Ljava/lang/String;ILjava/lang/String;)V", "NONE", "AUTO", "Converter", "div-data_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public enum Scrollbar {
        NONE("none"),
        AUTO("auto");

        private final String value;

        /* JADX INFO: renamed from: Converter, reason: from kotlin metadata */
        public static final Companion INSTANCE = new Companion(null);
        public static final Function1<Scrollbar, String> TO_STRING = new Function1<Scrollbar, String>() { // from class: com.yandex.div2.DivGallery$Scrollbar$Converter$TO_STRING$1
            @Override // kotlin.jvm.functions.Function1
            public final String invoke(DivGallery.Scrollbar value) {
                Intrinsics.checkNotNullParameter(value, "value");
                return DivGallery.Scrollbar.INSTANCE.toString(value);
            }
        };
        public static final Function1<String, Scrollbar> FROM_STRING = new Function1<String, Scrollbar>() { // from class: com.yandex.div2.DivGallery$Scrollbar$Converter$FROM_STRING$1
            @Override // kotlin.jvm.functions.Function1
            public final DivGallery.Scrollbar invoke(String value) {
                Intrinsics.checkNotNullParameter(value, "value");
                return DivGallery.Scrollbar.INSTANCE.fromString(value);
            }
        };

        Scrollbar(String str) {
            this.value = str;
        }

        /* JADX INFO: renamed from: com.yandex.div2.DivGallery$Scrollbar$Converter, reason: from kotlin metadata */
        /* JADX INFO: compiled from: DivGallery.kt */
        @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\b\u001a\u0004\u0018\u00010\u00062\u0006\u0010\t\u001a\u00020\u0005J\u000e\u0010\n\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\u0006R\u001e\u0010\u0003\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u00048\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00050\u00048\u0006X\u0087\u0004¢\u0006\u0002\n\u0000¨\u0006\f"}, d2 = {"Lcom/yandex/div2/DivGallery$Scrollbar$Converter;", "", "()V", "FROM_STRING", "Lkotlin/Function1;", "", "Lcom/yandex/div2/DivGallery$Scrollbar;", "TO_STRING", "fromString", "value", "toString", "obj", "div-data_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private Companion() {
            }

            public final String toString(Scrollbar obj) {
                Intrinsics.checkNotNullParameter(obj, "obj");
                return obj.value;
            }

            public final Scrollbar fromString(String value) {
                Intrinsics.checkNotNullParameter(value, "value");
                if (Intrinsics.areEqual(value, Scrollbar.NONE.value)) {
                    return Scrollbar.NONE;
                }
                if (Intrinsics.areEqual(value, Scrollbar.AUTO.value)) {
                    return Scrollbar.AUTO;
                }
                return null;
            }
        }
    }
}
