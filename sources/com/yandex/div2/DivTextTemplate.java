package com.yandex.div2;

import android.net.Uri;
import androidx.compose.material.OutlinedTextFieldKt;
import androidx.core.view.ViewCompat;
import com.json.cc;
import com.yandex.div.internal.template.Field;
import com.yandex.div.json.JSONSerializable;
import com.yandex.div.json.JsonTemplate;
import com.yandex.div.json.ParsingEnvironment;
import com.yandex.div.json.expressions.Expression;
import com.yandex.div.serialization.BuiltInParserKt;
import com.yandex.div.serialization.ParsingContext;
import io.appmetrica.analytics.impl.J2;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: compiled from: DivTextTemplate.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000¦\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0006\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u0000 y2\u00020\u00012\b\u0012\u0004\u0012\u00020\u00030\u0002:\u0004yz{|B½\t\b\u0016\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\b0\u0005\u0012\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\n0\u0005\u0012\u0012\u0010\u000b\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\f0\u0005\u0012\u0012\u0010\r\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000f0\u000e0\u0005\u0012\u0012\u0010\u0010\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00110\u000e0\u0005\u0012\u0012\u0010\u0012\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00130\u000e0\u0005\u0012\u0012\u0010\u0014\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00150\f0\u0005\u0012\u0012\u0010\u0016\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00170\u000e0\u0005\u0012\u0012\u0010\u0018\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00190\f0\u0005\u0012\f\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u001b0\u0005\u0012\u0012\u0010\u001c\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001d0\u000e0\u0005\u0012\u0012\u0010\u001e\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001f0\f0\u0005\u0012\u0012\u0010 \u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\f0\u0005\u0012\f\u0010!\u001a\b\u0012\u0004\u0012\u00020\"0\u0005\u0012\u0012\u0010#\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020$0\f0\u0005\u0012\f\u0010%\u001a\b\u0012\u0004\u0012\u00020&0\u0005\u0012\u0012\u0010'\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020(0\u000e0\u0005\u0012\u0012\u0010)\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020*0\u000e0\u0005\u0012\u0012\u0010+\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020*0\u000e0\u0005\u0012\u0012\u0010,\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001d0\u000e0\u0005\u0012\u0012\u0010-\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020.0\u000e0\u0005\u0012\u0012\u0010/\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002000\u000e0\u0005\u0012\u0012\u00101\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001d0\u000e0\u0005\u0012\u0012\u00102\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002030\f0\u0005\u0012\f\u00104\u001a\b\u0012\u0004\u0012\u0002050\u0005\u0012\u0012\u00106\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\f0\u0005\u0012\u0012\u00107\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\f0\u0005\u0012\f\u00108\u001a\b\u0012\u0004\u0012\u00020*0\u0005\u0012\u0012\u00109\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020:0\f0\u0005\u0012\f\u0010;\u001a\b\u0012\u0004\u0012\u00020<0\u0005\u0012\u0012\u0010=\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00130\u000e0\u0005\u0012\u0012\u0010>\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001d0\u000e0\u0005\u0012\u0012\u0010?\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\f0\u0005\u0012\f\u0010@\u001a\b\u0012\u0004\u0012\u00020A0\u0005\u0012\u0012\u0010B\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001d0\u000e0\u0005\u0012\u0012\u0010C\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001d0\u000e0\u0005\u0012\f\u0010D\u001a\b\u0012\u0004\u0012\u00020A0\u0005\u0012\u0012\u0010E\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\f0\u0005\u0012\u0012\u0010F\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\f0\u0005\u0012\u0012\u0010G\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020H0\f0\u0005\u0012\u0012\u0010I\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020*0\u000e0\u0005\u0012\u0012\u0010J\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001d0\u000e0\u0005\u0012\u0012\u0010K\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00170\u000e0\u0005\u0012\u0012\u0010L\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\f0\u0005\u0012\u0012\u0010M\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020N0\u000e0\u0005\u0012\u0012\u0010O\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020*0\u000e0\u0005\u0012\u0012\u0010P\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000f0\u000e0\u0005\u0012\u0012\u0010Q\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00110\u000e0\u0005\u0012\u0012\u0010R\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020(0\u000e0\u0005\u0012\f\u0010S\u001a\b\u0012\u0004\u0012\u00020T0\u0005\u0012\f\u0010U\u001a\b\u0012\u0004\u0012\u00020V0\u0005\u0012\u0012\u0010W\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00170\u000e0\u0005\u0012\u0012\u0010X\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020Y0\f0\u0005\u0012\f\u0010Z\u001a\b\u0012\u0004\u0012\u00020[0\u0005\u0012\f\u0010\\\u001a\b\u0012\u0004\u0012\u00020]0\u0005\u0012\f\u0010^\u001a\b\u0012\u0004\u0012\u00020_0\u0005\u0012\f\u0010`\u001a\b\u0012\u0004\u0012\u00020_0\u0005\u0012\u0012\u0010a\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020b0\f0\u0005\u0012\u0012\u0010c\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020N0\u000e0\u0005\u0012\u0012\u0010d\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020e0\f0\u0005\u0012\u0012\u0010f\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020g0\f0\u0005\u0012\u0012\u0010h\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020i0\u000e0\u0005\u0012\f\u0010j\u001a\b\u0012\u0004\u0012\u00020k0\u0005\u0012\u0012\u0010l\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020k0\f0\u0005\u0012\f\u0010m\u001a\b\u0012\u0004\u0012\u0002050\u0005¢\u0006\u0002\u0010nB-\b\u0016\u0012\u0006\u0010o\u001a\u00020p\u0012\n\b\u0002\u0010q\u001a\u0004\u0018\u00010\u0000\u0012\b\b\u0002\u0010r\u001a\u00020\u0017\u0012\u0006\u0010s\u001a\u00020t¢\u0006\u0002\u0010uJ\u0018\u0010v\u001a\u00020\u00032\u0006\u0010o\u001a\u00020p2\u0006\u0010w\u001a\u00020tH\u0016J\b\u0010x\u001a\u00020tH\u0016R\u0016\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u00058\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\b0\u00058\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\t\u001a\b\u0012\u0004\u0012\u00020\n0\u00058\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\u000b\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\f0\u00058\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\r\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000f0\u000e0\u00058\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\u0010\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00110\u000e0\u00058\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\u0012\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00130\u000e0\u00058\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\u0014\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00150\f0\u00058\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\u0016\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00170\u000e0\u00058\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\u0018\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00190\f0\u00058\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u001b0\u00058\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\u001c\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001d0\u000e0\u00058\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\u001e\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001f0\f0\u00058\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u001c\u0010 \u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\f0\u00058\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0016\u0010!\u001a\b\u0012\u0004\u0012\u00020\"0\u00058\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u001c\u0010#\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020$0\f0\u00058\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0016\u0010%\u001a\b\u0012\u0004\u0012\u00020&0\u00058\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u001c\u0010'\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020(0\u000e0\u00058\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u001c\u0010)\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020*0\u000e0\u00058\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u001c\u0010+\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020*0\u000e0\u00058\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u001c\u0010,\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001d0\u000e0\u00058\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u001c\u0010-\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020.0\u000e0\u00058\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u001c\u0010/\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002000\u000e0\u00058\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u001c\u00101\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001d0\u000e0\u00058\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u001c\u00102\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002030\f0\u00058\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0016\u00104\u001a\b\u0012\u0004\u0012\u0002050\u00058\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u001c\u00106\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\f0\u00058\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u001c\u00107\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\f0\u00058\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0016\u00108\u001a\b\u0012\u0004\u0012\u00020*0\u00058\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u001c\u00109\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020:0\f0\u00058\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0016\u0010;\u001a\b\u0012\u0004\u0012\u00020<0\u00058\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u001c\u0010=\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00130\u000e0\u00058\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u001c\u0010>\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001d0\u000e0\u00058\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u001c\u0010?\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\f0\u00058\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0016\u0010@\u001a\b\u0012\u0004\u0012\u00020A0\u00058\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u001c\u0010B\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001d0\u000e0\u00058\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u001c\u0010C\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001d0\u000e0\u00058\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0016\u0010D\u001a\b\u0012\u0004\u0012\u00020A0\u00058\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u001c\u0010E\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\f0\u00058\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u001c\u0010F\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\f0\u00058\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u001c\u0010G\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020H0\f0\u00058\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u001c\u0010I\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020*0\u000e0\u00058\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u001c\u0010J\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001d0\u000e0\u00058\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u001c\u0010K\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00170\u000e0\u00058\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u001c\u0010L\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\f0\u00058\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u001c\u0010M\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020N0\u000e0\u00058\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u001c\u0010O\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020*0\u000e0\u00058\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u001c\u0010P\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000f0\u000e0\u00058\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u001c\u0010Q\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00110\u000e0\u00058\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u001c\u0010R\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020(0\u000e0\u00058\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0016\u0010S\u001a\b\u0012\u0004\u0012\u00020T0\u00058\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0016\u0010U\u001a\b\u0012\u0004\u0012\u00020V0\u00058\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u001c\u0010W\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00170\u000e0\u00058\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u001c\u0010X\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020Y0\f0\u00058\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0016\u0010Z\u001a\b\u0012\u0004\u0012\u00020[0\u00058\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\\\u001a\b\u0012\u0004\u0012\u00020]0\u00058\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0016\u0010^\u001a\b\u0012\u0004\u0012\u00020_0\u00058\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0016\u0010`\u001a\b\u0012\u0004\u0012\u00020_0\u00058\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u001c\u0010a\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020b0\f0\u00058\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u001c\u0010c\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020N0\u000e0\u00058\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u001c\u0010d\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020e0\f0\u00058\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u001c\u0010f\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020g0\f0\u00058\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u001c\u0010h\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020i0\u000e0\u00058\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0016\u0010j\u001a\b\u0012\u0004\u0012\u00020k0\u00058\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u001c\u0010l\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020k0\f0\u00058\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0016\u0010m\u001a\b\u0012\u0004\u0012\u0002050\u00058\u0006X\u0087\u0004¢\u0006\u0002\n\u0000¨\u0006}"}, d2 = {"Lcom/yandex/div2/DivTextTemplate;", "Lcom/yandex/div/json/JSONSerializable;", "Lcom/yandex/div/json/JsonTemplate;", "Lcom/yandex/div2/DivText;", "accessibility", "Lcom/yandex/div/internal/template/Field;", "Lcom/yandex/div2/DivAccessibilityTemplate;", "action", "Lcom/yandex/div2/DivActionTemplate;", "actionAnimation", "Lcom/yandex/div2/DivAnimationTemplate;", "actions", "", "alignmentHorizontal", "Lcom/yandex/div/json/expressions/Expression;", "Lcom/yandex/div2/DivAlignmentHorizontal;", "alignmentVertical", "Lcom/yandex/div2/DivAlignmentVertical;", "alpha", "", "animators", "Lcom/yandex/div2/DivAnimatorTemplate;", "autoEllipsize", "", J2.g, "Lcom/yandex/div2/DivBackgroundTemplate;", OutlinedTextFieldKt.BorderId, "Lcom/yandex/div2/DivBorderTemplate;", "columnSpan", "", "disappearActions", "Lcom/yandex/div2/DivDisappearActionTemplate;", "doubletapActions", "ellipsis", "Lcom/yandex/div2/DivTextTemplate$EllipsisTemplate;", "extensions", "Lcom/yandex/div2/DivExtensionTemplate;", "focus", "Lcom/yandex/div2/DivFocusTemplate;", "focusedTextColor", "", "fontFamily", "", "fontFeatureSettings", "fontSize", "fontSizeUnit", "Lcom/yandex/div2/DivSizeUnit;", "fontWeight", "Lcom/yandex/div2/DivFontWeight;", "fontWeightValue", "functions", "Lcom/yandex/div2/DivFunctionTemplate;", "height", "Lcom/yandex/div2/DivSizeTemplate;", "hoverEndActions", "hoverStartActions", "id", "images", "Lcom/yandex/div2/DivTextTemplate$ImageTemplate;", "layoutProvider", "Lcom/yandex/div2/DivLayoutProviderTemplate;", "letterSpacing", "lineHeight", "longtapActions", "margins", "Lcom/yandex/div2/DivEdgeInsetsTemplate;", "maxLines", "minHiddenLines", "paddings", "pressEndActions", "pressStartActions", "ranges", "Lcom/yandex/div2/DivTextTemplate$RangeTemplate;", "reuseId", "rowSpan", "selectable", "selectedActions", "strike", "Lcom/yandex/div2/DivLineStyle;", "text", "textAlignmentHorizontal", "textAlignmentVertical", "textColor", "textGradient", "Lcom/yandex/div2/DivTextGradientTemplate;", "textShadow", "Lcom/yandex/div2/DivShadowTemplate;", "tightenWidth", "tooltips", "Lcom/yandex/div2/DivTooltipTemplate;", "transform", "Lcom/yandex/div2/DivTransformTemplate;", "transitionChange", "Lcom/yandex/div2/DivChangeTransitionTemplate;", "transitionIn", "Lcom/yandex/div2/DivAppearanceTransitionTemplate;", "transitionOut", "transitionTriggers", "Lcom/yandex/div2/DivTransitionTrigger;", "underline", "variableTriggers", "Lcom/yandex/div2/DivTriggerTemplate;", "variables", "Lcom/yandex/div2/DivVariableTemplate;", "visibility", "Lcom/yandex/div2/DivVisibility;", "visibilityAction", "Lcom/yandex/div2/DivVisibilityActionTemplate;", "visibilityActions", "width", "(Lcom/yandex/div/internal/template/Field;Lcom/yandex/div/internal/template/Field;Lcom/yandex/div/internal/template/Field;Lcom/yandex/div/internal/template/Field;Lcom/yandex/div/internal/template/Field;Lcom/yandex/div/internal/template/Field;Lcom/yandex/div/internal/template/Field;Lcom/yandex/div/internal/template/Field;Lcom/yandex/div/internal/template/Field;Lcom/yandex/div/internal/template/Field;Lcom/yandex/div/internal/template/Field;Lcom/yandex/div/internal/template/Field;Lcom/yandex/div/internal/template/Field;Lcom/yandex/div/internal/template/Field;Lcom/yandex/div/internal/template/Field;Lcom/yandex/div/internal/template/Field;Lcom/yandex/div/internal/template/Field;Lcom/yandex/div/internal/template/Field;Lcom/yandex/div/internal/template/Field;Lcom/yandex/div/internal/template/Field;Lcom/yandex/div/internal/template/Field;Lcom/yandex/div/internal/template/Field;Lcom/yandex/div/internal/template/Field;Lcom/yandex/div/internal/template/Field;Lcom/yandex/div/internal/template/Field;Lcom/yandex/div/internal/template/Field;Lcom/yandex/div/internal/template/Field;Lcom/yandex/div/internal/template/Field;Lcom/yandex/div/internal/template/Field;Lcom/yandex/div/internal/template/Field;Lcom/yandex/div/internal/template/Field;Lcom/yandex/div/internal/template/Field;Lcom/yandex/div/internal/template/Field;Lcom/yandex/div/internal/template/Field;Lcom/yandex/div/internal/template/Field;Lcom/yandex/div/internal/template/Field;Lcom/yandex/div/internal/template/Field;Lcom/yandex/div/internal/template/Field;Lcom/yandex/div/internal/template/Field;Lcom/yandex/div/internal/template/Field;Lcom/yandex/div/internal/template/Field;Lcom/yandex/div/internal/template/Field;Lcom/yandex/div/internal/template/Field;Lcom/yandex/div/internal/template/Field;Lcom/yandex/div/internal/template/Field;Lcom/yandex/div/internal/template/Field;Lcom/yandex/div/internal/template/Field;Lcom/yandex/div/internal/template/Field;Lcom/yandex/div/internal/template/Field;Lcom/yandex/div/internal/template/Field;Lcom/yandex/div/internal/template/Field;Lcom/yandex/div/internal/template/Field;Lcom/yandex/div/internal/template/Field;Lcom/yandex/div/internal/template/Field;Lcom/yandex/div/internal/template/Field;Lcom/yandex/div/internal/template/Field;Lcom/yandex/div/internal/template/Field;Lcom/yandex/div/internal/template/Field;Lcom/yandex/div/internal/template/Field;Lcom/yandex/div/internal/template/Field;Lcom/yandex/div/internal/template/Field;Lcom/yandex/div/internal/template/Field;Lcom/yandex/div/internal/template/Field;Lcom/yandex/div/internal/template/Field;Lcom/yandex/div/internal/template/Field;Lcom/yandex/div/internal/template/Field;)V", cc.o, "Lcom/yandex/div/json/ParsingEnvironment;", "parent", "topLevel", "json", "Lorg/json/JSONObject;", "(Lcom/yandex/div/json/ParsingEnvironment;Lcom/yandex/div2/DivTextTemplate;ZLorg/json/JSONObject;)V", "resolve", "data", "writeToJSON", "Companion", "EllipsisTemplate", "ImageTemplate", "RangeTemplate", "div-data_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class DivTextTemplate implements JSONSerializable, JsonTemplate<DivText> {
    private static final DivAnimation ACTION_ANIMATION_DEFAULT_VALUE;
    private static final Expression<Double> ALPHA_DEFAULT_VALUE;
    private static final Function2<ParsingEnvironment, JSONObject, DivTextTemplate> CREATOR;

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
    public final Field<DivAccessibilityTemplate> accessibility;
    public final Field<DivActionTemplate> action;
    public final Field<DivAnimationTemplate> actionAnimation;
    public final Field<List<DivActionTemplate>> actions;
    public final Field<Expression<DivAlignmentHorizontal>> alignmentHorizontal;
    public final Field<Expression<DivAlignmentVertical>> alignmentVertical;
    public final Field<Expression<Double>> alpha;
    public final Field<List<DivAnimatorTemplate>> animators;
    public final Field<Expression<Boolean>> autoEllipsize;
    public final Field<List<DivBackgroundTemplate>> background;
    public final Field<DivBorderTemplate> border;
    public final Field<Expression<Long>> columnSpan;
    public final Field<List<DivDisappearActionTemplate>> disappearActions;
    public final Field<List<DivActionTemplate>> doubletapActions;
    public final Field<EllipsisTemplate> ellipsis;
    public final Field<List<DivExtensionTemplate>> extensions;
    public final Field<DivFocusTemplate> focus;
    public final Field<Expression<Integer>> focusedTextColor;
    public final Field<Expression<String>> fontFamily;
    public final Field<Expression<String>> fontFeatureSettings;
    public final Field<Expression<Long>> fontSize;
    public final Field<Expression<DivSizeUnit>> fontSizeUnit;
    public final Field<Expression<DivFontWeight>> fontWeight;
    public final Field<Expression<Long>> fontWeightValue;
    public final Field<List<DivFunctionTemplate>> functions;
    public final Field<DivSizeTemplate> height;
    public final Field<List<DivActionTemplate>> hoverEndActions;
    public final Field<List<DivActionTemplate>> hoverStartActions;
    public final Field<String> id;
    public final Field<List<ImageTemplate>> images;
    public final Field<DivLayoutProviderTemplate> layoutProvider;
    public final Field<Expression<Double>> letterSpacing;
    public final Field<Expression<Long>> lineHeight;
    public final Field<List<DivActionTemplate>> longtapActions;
    public final Field<DivEdgeInsetsTemplate> margins;
    public final Field<Expression<Long>> maxLines;
    public final Field<Expression<Long>> minHiddenLines;
    public final Field<DivEdgeInsetsTemplate> paddings;
    public final Field<List<DivActionTemplate>> pressEndActions;
    public final Field<List<DivActionTemplate>> pressStartActions;
    public final Field<List<RangeTemplate>> ranges;
    public final Field<Expression<String>> reuseId;
    public final Field<Expression<Long>> rowSpan;
    public final Field<Expression<Boolean>> selectable;
    public final Field<List<DivActionTemplate>> selectedActions;
    public final Field<Expression<DivLineStyle>> strike;
    public final Field<Expression<String>> text;
    public final Field<Expression<DivAlignmentHorizontal>> textAlignmentHorizontal;
    public final Field<Expression<DivAlignmentVertical>> textAlignmentVertical;
    public final Field<Expression<Integer>> textColor;
    public final Field<DivTextGradientTemplate> textGradient;
    public final Field<DivShadowTemplate> textShadow;
    public final Field<Expression<Boolean>> tightenWidth;
    public final Field<List<DivTooltipTemplate>> tooltips;
    public final Field<DivTransformTemplate> transform;
    public final Field<DivChangeTransitionTemplate> transitionChange;
    public final Field<DivAppearanceTransitionTemplate> transitionIn;
    public final Field<DivAppearanceTransitionTemplate> transitionOut;
    public final Field<List<DivTransitionTrigger>> transitionTriggers;
    public final Field<Expression<DivLineStyle>> underline;
    public final Field<List<DivTriggerTemplate>> variableTriggers;
    public final Field<List<DivVariableTemplate>> variables;
    public final Field<Expression<DivVisibility>> visibility;
    public final Field<DivVisibilityActionTemplate> visibilityAction;
    public final Field<List<DivVisibilityActionTemplate>> visibilityActions;
    public final Field<DivSizeTemplate> width;

    public DivTextTemplate(Field<DivAccessibilityTemplate> accessibility, Field<DivActionTemplate> action, Field<DivAnimationTemplate> actionAnimation, Field<List<DivActionTemplate>> actions, Field<Expression<DivAlignmentHorizontal>> alignmentHorizontal, Field<Expression<DivAlignmentVertical>> alignmentVertical, Field<Expression<Double>> alpha, Field<List<DivAnimatorTemplate>> animators, Field<Expression<Boolean>> autoEllipsize, Field<List<DivBackgroundTemplate>> background, Field<DivBorderTemplate> border, Field<Expression<Long>> columnSpan, Field<List<DivDisappearActionTemplate>> disappearActions, Field<List<DivActionTemplate>> doubletapActions, Field<EllipsisTemplate> ellipsis, Field<List<DivExtensionTemplate>> extensions, Field<DivFocusTemplate> focus, Field<Expression<Integer>> focusedTextColor, Field<Expression<String>> fontFamily, Field<Expression<String>> fontFeatureSettings, Field<Expression<Long>> fontSize, Field<Expression<DivSizeUnit>> fontSizeUnit, Field<Expression<DivFontWeight>> fontWeight, Field<Expression<Long>> fontWeightValue, Field<List<DivFunctionTemplate>> functions, Field<DivSizeTemplate> height, Field<List<DivActionTemplate>> hoverEndActions, Field<List<DivActionTemplate>> hoverStartActions, Field<String> id, Field<List<ImageTemplate>> images, Field<DivLayoutProviderTemplate> layoutProvider, Field<Expression<Double>> letterSpacing, Field<Expression<Long>> lineHeight, Field<List<DivActionTemplate>> longtapActions, Field<DivEdgeInsetsTemplate> margins, Field<Expression<Long>> maxLines, Field<Expression<Long>> minHiddenLines, Field<DivEdgeInsetsTemplate> paddings, Field<List<DivActionTemplate>> pressEndActions, Field<List<DivActionTemplate>> pressStartActions, Field<List<RangeTemplate>> ranges, Field<Expression<String>> reuseId, Field<Expression<Long>> rowSpan, Field<Expression<Boolean>> selectable, Field<List<DivActionTemplate>> selectedActions, Field<Expression<DivLineStyle>> strike, Field<Expression<String>> text, Field<Expression<DivAlignmentHorizontal>> textAlignmentHorizontal, Field<Expression<DivAlignmentVertical>> textAlignmentVertical, Field<Expression<Integer>> textColor, Field<DivTextGradientTemplate> textGradient, Field<DivShadowTemplate> textShadow, Field<Expression<Boolean>> tightenWidth, Field<List<DivTooltipTemplate>> tooltips, Field<DivTransformTemplate> transform, Field<DivChangeTransitionTemplate> transitionChange, Field<DivAppearanceTransitionTemplate> transitionIn, Field<DivAppearanceTransitionTemplate> transitionOut, Field<List<DivTransitionTrigger>> transitionTriggers, Field<Expression<DivLineStyle>> underline, Field<List<DivTriggerTemplate>> variableTriggers, Field<List<DivVariableTemplate>> variables, Field<Expression<DivVisibility>> visibility, Field<DivVisibilityActionTemplate> visibilityAction, Field<List<DivVisibilityActionTemplate>> visibilityActions, Field<DivSizeTemplate> width) {
        Intrinsics.checkNotNullParameter(accessibility, "accessibility");
        Intrinsics.checkNotNullParameter(action, "action");
        Intrinsics.checkNotNullParameter(actionAnimation, "actionAnimation");
        Intrinsics.checkNotNullParameter(actions, "actions");
        Intrinsics.checkNotNullParameter(alignmentHorizontal, "alignmentHorizontal");
        Intrinsics.checkNotNullParameter(alignmentVertical, "alignmentVertical");
        Intrinsics.checkNotNullParameter(alpha, "alpha");
        Intrinsics.checkNotNullParameter(animators, "animators");
        Intrinsics.checkNotNullParameter(autoEllipsize, "autoEllipsize");
        Intrinsics.checkNotNullParameter(background, "background");
        Intrinsics.checkNotNullParameter(border, "border");
        Intrinsics.checkNotNullParameter(columnSpan, "columnSpan");
        Intrinsics.checkNotNullParameter(disappearActions, "disappearActions");
        Intrinsics.checkNotNullParameter(doubletapActions, "doubletapActions");
        Intrinsics.checkNotNullParameter(ellipsis, "ellipsis");
        Intrinsics.checkNotNullParameter(extensions, "extensions");
        Intrinsics.checkNotNullParameter(focus, "focus");
        Intrinsics.checkNotNullParameter(focusedTextColor, "focusedTextColor");
        Intrinsics.checkNotNullParameter(fontFamily, "fontFamily");
        Intrinsics.checkNotNullParameter(fontFeatureSettings, "fontFeatureSettings");
        Intrinsics.checkNotNullParameter(fontSize, "fontSize");
        Intrinsics.checkNotNullParameter(fontSizeUnit, "fontSizeUnit");
        Intrinsics.checkNotNullParameter(fontWeight, "fontWeight");
        Intrinsics.checkNotNullParameter(fontWeightValue, "fontWeightValue");
        Intrinsics.checkNotNullParameter(functions, "functions");
        Intrinsics.checkNotNullParameter(height, "height");
        Intrinsics.checkNotNullParameter(hoverEndActions, "hoverEndActions");
        Intrinsics.checkNotNullParameter(hoverStartActions, "hoverStartActions");
        Intrinsics.checkNotNullParameter(id, "id");
        Intrinsics.checkNotNullParameter(images, "images");
        Intrinsics.checkNotNullParameter(layoutProvider, "layoutProvider");
        Intrinsics.checkNotNullParameter(letterSpacing, "letterSpacing");
        Intrinsics.checkNotNullParameter(lineHeight, "lineHeight");
        Intrinsics.checkNotNullParameter(longtapActions, "longtapActions");
        Intrinsics.checkNotNullParameter(margins, "margins");
        Intrinsics.checkNotNullParameter(maxLines, "maxLines");
        Intrinsics.checkNotNullParameter(minHiddenLines, "minHiddenLines");
        Intrinsics.checkNotNullParameter(paddings, "paddings");
        Intrinsics.checkNotNullParameter(pressEndActions, "pressEndActions");
        Intrinsics.checkNotNullParameter(pressStartActions, "pressStartActions");
        Intrinsics.checkNotNullParameter(ranges, "ranges");
        Intrinsics.checkNotNullParameter(reuseId, "reuseId");
        Intrinsics.checkNotNullParameter(rowSpan, "rowSpan");
        Intrinsics.checkNotNullParameter(selectable, "selectable");
        Intrinsics.checkNotNullParameter(selectedActions, "selectedActions");
        Intrinsics.checkNotNullParameter(strike, "strike");
        Intrinsics.checkNotNullParameter(text, "text");
        Intrinsics.checkNotNullParameter(textAlignmentHorizontal, "textAlignmentHorizontal");
        Intrinsics.checkNotNullParameter(textAlignmentVertical, "textAlignmentVertical");
        Intrinsics.checkNotNullParameter(textColor, "textColor");
        Intrinsics.checkNotNullParameter(textGradient, "textGradient");
        Intrinsics.checkNotNullParameter(textShadow, "textShadow");
        Intrinsics.checkNotNullParameter(tightenWidth, "tightenWidth");
        Intrinsics.checkNotNullParameter(tooltips, "tooltips");
        Intrinsics.checkNotNullParameter(transform, "transform");
        Intrinsics.checkNotNullParameter(transitionChange, "transitionChange");
        Intrinsics.checkNotNullParameter(transitionIn, "transitionIn");
        Intrinsics.checkNotNullParameter(transitionOut, "transitionOut");
        Intrinsics.checkNotNullParameter(transitionTriggers, "transitionTriggers");
        Intrinsics.checkNotNullParameter(underline, "underline");
        Intrinsics.checkNotNullParameter(variableTriggers, "variableTriggers");
        Intrinsics.checkNotNullParameter(variables, "variables");
        Intrinsics.checkNotNullParameter(visibility, "visibility");
        Intrinsics.checkNotNullParameter(visibilityAction, "visibilityAction");
        Intrinsics.checkNotNullParameter(visibilityActions, "visibilityActions");
        Intrinsics.checkNotNullParameter(width, "width");
        this.accessibility = accessibility;
        this.action = action;
        this.actionAnimation = actionAnimation;
        this.actions = actions;
        this.alignmentHorizontal = alignmentHorizontal;
        this.alignmentVertical = alignmentVertical;
        this.alpha = alpha;
        this.animators = animators;
        this.autoEllipsize = autoEllipsize;
        this.background = background;
        this.border = border;
        this.columnSpan = columnSpan;
        this.disappearActions = disappearActions;
        this.doubletapActions = doubletapActions;
        this.ellipsis = ellipsis;
        this.extensions = extensions;
        this.focus = focus;
        this.focusedTextColor = focusedTextColor;
        this.fontFamily = fontFamily;
        this.fontFeatureSettings = fontFeatureSettings;
        this.fontSize = fontSize;
        this.fontSizeUnit = fontSizeUnit;
        this.fontWeight = fontWeight;
        this.fontWeightValue = fontWeightValue;
        this.functions = functions;
        this.height = height;
        this.hoverEndActions = hoverEndActions;
        this.hoverStartActions = hoverStartActions;
        this.id = id;
        this.images = images;
        this.layoutProvider = layoutProvider;
        this.letterSpacing = letterSpacing;
        this.lineHeight = lineHeight;
        this.longtapActions = longtapActions;
        this.margins = margins;
        this.maxLines = maxLines;
        this.minHiddenLines = minHiddenLines;
        this.paddings = paddings;
        this.pressEndActions = pressEndActions;
        this.pressStartActions = pressStartActions;
        this.ranges = ranges;
        this.reuseId = reuseId;
        this.rowSpan = rowSpan;
        this.selectable = selectable;
        this.selectedActions = selectedActions;
        this.strike = strike;
        this.text = text;
        this.textAlignmentHorizontal = textAlignmentHorizontal;
        this.textAlignmentVertical = textAlignmentVertical;
        this.textColor = textColor;
        this.textGradient = textGradient;
        this.textShadow = textShadow;
        this.tightenWidth = tightenWidth;
        this.tooltips = tooltips;
        this.transform = transform;
        this.transitionChange = transitionChange;
        this.transitionIn = transitionIn;
        this.transitionOut = transitionOut;
        this.transitionTriggers = transitionTriggers;
        this.underline = underline;
        this.variableTriggers = variableTriggers;
        this.variables = variables;
        this.visibility = visibility;
        this.visibilityAction = visibilityAction;
        this.visibilityActions = visibilityActions;
        this.width = width;
    }

    public /* synthetic */ DivTextTemplate(ParsingEnvironment parsingEnvironment, DivTextTemplate divTextTemplate, boolean z, JSONObject jSONObject, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(parsingEnvironment, (i & 2) != 0 ? null : divTextTemplate, (i & 4) != 0 ? false : z, jSONObject);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public DivTextTemplate(ParsingEnvironment env, DivTextTemplate divTextTemplate, boolean z, JSONObject json) {
        this(Field.INSTANCE.nullField(false), Field.INSTANCE.nullField(false), Field.INSTANCE.nullField(false), Field.INSTANCE.nullField(false), Field.INSTANCE.nullField(false), Field.INSTANCE.nullField(false), Field.INSTANCE.nullField(false), Field.INSTANCE.nullField(false), Field.INSTANCE.nullField(false), Field.INSTANCE.nullField(false), Field.INSTANCE.nullField(false), Field.INSTANCE.nullField(false), Field.INSTANCE.nullField(false), Field.INSTANCE.nullField(false), Field.INSTANCE.nullField(false), Field.INSTANCE.nullField(false), Field.INSTANCE.nullField(false), Field.INSTANCE.nullField(false), Field.INSTANCE.nullField(false), Field.INSTANCE.nullField(false), Field.INSTANCE.nullField(false), Field.INSTANCE.nullField(false), Field.INSTANCE.nullField(false), Field.INSTANCE.nullField(false), Field.INSTANCE.nullField(false), Field.INSTANCE.nullField(false), Field.INSTANCE.nullField(false), Field.INSTANCE.nullField(false), Field.INSTANCE.nullField(false), Field.INSTANCE.nullField(false), Field.INSTANCE.nullField(false), Field.INSTANCE.nullField(false), Field.INSTANCE.nullField(false), Field.INSTANCE.nullField(false), Field.INSTANCE.nullField(false), Field.INSTANCE.nullField(false), Field.INSTANCE.nullField(false), Field.INSTANCE.nullField(false), Field.INSTANCE.nullField(false), Field.INSTANCE.nullField(false), Field.INSTANCE.nullField(false), Field.INSTANCE.nullField(false), Field.INSTANCE.nullField(false), Field.INSTANCE.nullField(false), Field.INSTANCE.nullField(false), Field.INSTANCE.nullField(false), Field.INSTANCE.nullField(false), Field.INSTANCE.nullField(false), Field.INSTANCE.nullField(false), Field.INSTANCE.nullField(false), Field.INSTANCE.nullField(false), Field.INSTANCE.nullField(false), Field.INSTANCE.nullField(false), Field.INSTANCE.nullField(false), Field.INSTANCE.nullField(false), Field.INSTANCE.nullField(false), Field.INSTANCE.nullField(false), Field.INSTANCE.nullField(false), Field.INSTANCE.nullField(false), Field.INSTANCE.nullField(false), Field.INSTANCE.nullField(false), Field.INSTANCE.nullField(false), Field.INSTANCE.nullField(false), Field.INSTANCE.nullField(false), Field.INSTANCE.nullField(false), Field.INSTANCE.nullField(false));
        Intrinsics.checkNotNullParameter(env, "env");
        Intrinsics.checkNotNullParameter(json, "json");
        throw new UnsupportedOperationException("Do not use this constructor directly.");
    }

    @Override // com.yandex.div.json.JsonTemplate
    public DivText resolve(ParsingEnvironment env, JSONObject data) {
        Intrinsics.checkNotNullParameter(env, "env");
        Intrinsics.checkNotNullParameter(data, "data");
        return BuiltInParserKt.getBuiltInParserComponent().getDivTextJsonTemplateResolver().getValue().resolve((ParsingContext) env, this, data);
    }

    @Override // com.yandex.div.json.JSONSerializable
    public JSONObject writeToJSON() {
        return BuiltInParserKt.getBuiltInParserComponent().getDivTextJsonTemplateParser().getValue().serialize(BuiltInParserKt.getBuiltInParsingContext(), this);
    }

    /* JADX INFO: compiled from: DivTextTemplate.kt */
    @Metadata(d1 = {"\u0000~\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0006\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R#\u0010\b\u001a\u0014\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\f0\t¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0014\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00100\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00120\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00140\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0016X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00190\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u001b0\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u001d0\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u001f0\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010 \u001a\b\u0012\u0004\u0012\u00020!0\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\"\u001a\b\u0012\u0004\u0012\u00020\u00190\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010#\u001a\u00020$X\u0086T¢\u0006\u0002\n\u0000R\u0014\u0010%\u001a\b\u0012\u0004\u0012\u00020\u001b0\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010&\u001a\b\u0012\u0004\u0012\u00020'0\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010(\u001a\u00020)X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006*"}, d2 = {"Lcom/yandex/div2/DivTextTemplate$Companion;", "", "()V", "ACTION_ANIMATION_DEFAULT_VALUE", "Lcom/yandex/div2/DivAnimation;", "ALPHA_DEFAULT_VALUE", "Lcom/yandex/div/json/expressions/Expression;", "", "CREATOR", "Lkotlin/Function2;", "Lcom/yandex/div/json/ParsingEnvironment;", "Lorg/json/JSONObject;", "Lcom/yandex/div2/DivTextTemplate;", "getCREATOR", "()Lkotlin/jvm/functions/Function2;", "FONT_SIZE_DEFAULT_VALUE", "", "FONT_SIZE_UNIT_DEFAULT_VALUE", "Lcom/yandex/div2/DivSizeUnit;", "FONT_WEIGHT_DEFAULT_VALUE", "Lcom/yandex/div2/DivFontWeight;", "HEIGHT_DEFAULT_VALUE", "Lcom/yandex/div2/DivSize$WrapContent;", "LETTER_SPACING_DEFAULT_VALUE", "SELECTABLE_DEFAULT_VALUE", "", "STRIKE_DEFAULT_VALUE", "Lcom/yandex/div2/DivLineStyle;", "TEXT_ALIGNMENT_HORIZONTAL_DEFAULT_VALUE", "Lcom/yandex/div2/DivAlignmentHorizontal;", "TEXT_ALIGNMENT_VERTICAL_DEFAULT_VALUE", "Lcom/yandex/div2/DivAlignmentVertical;", "TEXT_COLOR_DEFAULT_VALUE", "", "TIGHTEN_WIDTH_DEFAULT_VALUE", "TYPE", "", "UNDERLINE_DEFAULT_VALUE", "VISIBILITY_DEFAULT_VALUE", "Lcom/yandex/div2/DivVisibility;", "WIDTH_DEFAULT_VALUE", "Lcom/yandex/div2/DivSize$MatchParent;", "div-data_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final Function2<ParsingEnvironment, JSONObject, DivTextTemplate> getCREATOR() {
            return DivTextTemplate.CREATOR;
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
        CREATOR = new Function2<ParsingEnvironment, JSONObject, DivTextTemplate>() { // from class: com.yandex.div2.DivTextTemplate$Companion$CREATOR$1
            @Override // kotlin.jvm.functions.Function2
            public final DivTextTemplate invoke(ParsingEnvironment env, JSONObject it) {
                Intrinsics.checkNotNullParameter(env, "env");
                Intrinsics.checkNotNullParameter(it, "it");
                return new DivTextTemplate(env, null, false, it, 6, null);
            }
        };
    }

    /* JADX INFO: compiled from: DivTextTemplate.kt */
    @Metadata(d1 = {"\u0000\u008a\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0006\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 52\u00020\u00012\b\u0012\u0004\u0012\u00020\u00030\u0002:\u00015B\u0093\u0003\b\u0016\u0012\u0012\u0010\u0004\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u00060\u0005\u0012\u0012\u0010\b\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\t0\u0005\u0012\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\f0\u0005\u0012\u0012\u0010\r\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000e0\t0\u0005\u0012\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00100\u0005\u0012\u0012\u0010\u0011\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00120\t0\u0005\u0012\u0012\u0010\u0013\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00140\t0\u0005\u0012\u0012\u0010\u0015\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00140\t0\u0005\u0012\u0012\u0010\u0016\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00120\t0\u0005\u0012\u0012\u0010\u0017\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00180\t0\u0005\u0012\u0012\u0010\u0019\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001a0\t0\u0005\u0012\u0012\u0010\u001b\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00120\t0\u0005\u0012\u0012\u0010\u001c\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000e0\t0\u0005\u0012\u0012\u0010\u001d\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00120\t0\u0005\u0012\f\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u001f0\u0005\u0012\u0012\u0010 \u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00120\t0\u0005\u0012\u0012\u0010!\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\"0\t0\u0005\u0012\u0012\u0010#\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020$0\t0\u0005\u0012\f\u0010%\u001a\b\u0012\u0004\u0012\u00020&0\u0005\u0012\u0012\u0010'\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00120\t0\u0005\u0012\u0012\u0010(\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\"0\t0\u0005¢\u0006\u0002\u0010)B-\b\u0016\u0012\u0006\u0010*\u001a\u00020+\u0012\n\b\u0002\u0010,\u001a\u0004\u0018\u00010\u0000\u0012\b\b\u0002\u0010-\u001a\u00020.\u0012\u0006\u0010/\u001a\u000200¢\u0006\u0002\u00101J\u0018\u00102\u001a\u00020\u00032\u0006\u0010*\u001a\u00020+2\u0006\u00103\u001a\u000200H\u0016J\b\u00104\u001a\u000200H\u0016R\u001c\u0010\u0004\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u00060\u00058\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\b\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\t0\u00058\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\f0\u00058\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\r\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000e0\t0\u00058\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00100\u00058\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\u0011\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00120\t0\u00058\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\u0013\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00140\t0\u00058\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\u0015\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00140\t0\u00058\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\u0016\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00120\t0\u00058\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\u0017\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00180\t0\u00058\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\u0019\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001a0\t0\u00058\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\u001b\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00120\t0\u00058\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\u001c\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000e0\t0\u00058\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\u001d\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00120\t0\u00058\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u001f0\u00058\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u001c\u0010 \u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00120\t0\u00058\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u001c\u0010!\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\"0\t0\u00058\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u001c\u0010#\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020$0\t0\u00058\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0016\u0010%\u001a\b\u0012\u0004\u0012\u00020&0\u00058\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u001c\u0010'\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00120\t0\u00058\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u001c\u0010(\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\"0\t0\u00058\u0006X\u0087\u0004¢\u0006\u0002\n\u0000¨\u00066"}, d2 = {"Lcom/yandex/div2/DivTextTemplate$RangeTemplate;", "Lcom/yandex/div/json/JSONSerializable;", "Lcom/yandex/div/json/JsonTemplate;", "Lcom/yandex/div2/DivText$Range;", "actions", "Lcom/yandex/div/internal/template/Field;", "", "Lcom/yandex/div2/DivActionTemplate;", "alignmentVertical", "Lcom/yandex/div/json/expressions/Expression;", "Lcom/yandex/div2/DivTextAlignmentVertical;", J2.g, "Lcom/yandex/div2/DivTextRangeBackgroundTemplate;", "baselineOffset", "", OutlinedTextFieldKt.BorderId, "Lcom/yandex/div2/DivTextRangeBorderTemplate;", "end", "", "fontFamily", "", "fontFeatureSettings", "fontSize", "fontSizeUnit", "Lcom/yandex/div2/DivSizeUnit;", "fontWeight", "Lcom/yandex/div2/DivFontWeight;", "fontWeightValue", "letterSpacing", "lineHeight", "mask", "Lcom/yandex/div2/DivTextRangeMaskTemplate;", "start", "strike", "Lcom/yandex/div2/DivLineStyle;", "textColor", "", "textShadow", "Lcom/yandex/div2/DivShadowTemplate;", "topOffset", "underline", "(Lcom/yandex/div/internal/template/Field;Lcom/yandex/div/internal/template/Field;Lcom/yandex/div/internal/template/Field;Lcom/yandex/div/internal/template/Field;Lcom/yandex/div/internal/template/Field;Lcom/yandex/div/internal/template/Field;Lcom/yandex/div/internal/template/Field;Lcom/yandex/div/internal/template/Field;Lcom/yandex/div/internal/template/Field;Lcom/yandex/div/internal/template/Field;Lcom/yandex/div/internal/template/Field;Lcom/yandex/div/internal/template/Field;Lcom/yandex/div/internal/template/Field;Lcom/yandex/div/internal/template/Field;Lcom/yandex/div/internal/template/Field;Lcom/yandex/div/internal/template/Field;Lcom/yandex/div/internal/template/Field;Lcom/yandex/div/internal/template/Field;Lcom/yandex/div/internal/template/Field;Lcom/yandex/div/internal/template/Field;Lcom/yandex/div/internal/template/Field;)V", cc.o, "Lcom/yandex/div/json/ParsingEnvironment;", "parent", "topLevel", "", "json", "Lorg/json/JSONObject;", "(Lcom/yandex/div/json/ParsingEnvironment;Lcom/yandex/div2/DivTextTemplate$RangeTemplate;ZLorg/json/JSONObject;)V", "resolve", "data", "writeToJSON", "Companion", "div-data_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class RangeTemplate implements JSONSerializable, JsonTemplate<DivText.Range> {
        public final Field<List<DivActionTemplate>> actions;
        public final Field<Expression<DivTextAlignmentVertical>> alignmentVertical;
        public final Field<DivTextRangeBackgroundTemplate> background;
        public final Field<Expression<Double>> baselineOffset;
        public final Field<DivTextRangeBorderTemplate> border;
        public final Field<Expression<Long>> end;
        public final Field<Expression<String>> fontFamily;
        public final Field<Expression<String>> fontFeatureSettings;
        public final Field<Expression<Long>> fontSize;
        public final Field<Expression<DivSizeUnit>> fontSizeUnit;
        public final Field<Expression<DivFontWeight>> fontWeight;
        public final Field<Expression<Long>> fontWeightValue;
        public final Field<Expression<Double>> letterSpacing;
        public final Field<Expression<Long>> lineHeight;
        public final Field<DivTextRangeMaskTemplate> mask;
        public final Field<Expression<Long>> start;
        public final Field<Expression<DivLineStyle>> strike;
        public final Field<Expression<Integer>> textColor;
        public final Field<DivShadowTemplate> textShadow;
        public final Field<Expression<Long>> topOffset;
        public final Field<Expression<DivLineStyle>> underline;

        /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
        public static final Companion INSTANCE = new Companion(null);
        private static final Expression<Double> BASELINE_OFFSET_DEFAULT_VALUE = Expression.INSTANCE.constant(Double.valueOf(0.0d));
        private static final Expression<DivSizeUnit> FONT_SIZE_UNIT_DEFAULT_VALUE = Expression.INSTANCE.constant(DivSizeUnit.SP);
        private static final Expression<Long> START_DEFAULT_VALUE = Expression.INSTANCE.constant(0L);
        private static final Function2<ParsingEnvironment, JSONObject, RangeTemplate> CREATOR = new Function2<ParsingEnvironment, JSONObject, RangeTemplate>() { // from class: com.yandex.div2.DivTextTemplate$RangeTemplate$Companion$CREATOR$1
            @Override // kotlin.jvm.functions.Function2
            public final DivTextTemplate.RangeTemplate invoke(ParsingEnvironment env, JSONObject it) {
                Intrinsics.checkNotNullParameter(env, "env");
                Intrinsics.checkNotNullParameter(it, "it");
                return new DivTextTemplate.RangeTemplate(env, null, false, it, 6, null);
            }
        };

        public RangeTemplate(Field<List<DivActionTemplate>> actions, Field<Expression<DivTextAlignmentVertical>> alignmentVertical, Field<DivTextRangeBackgroundTemplate> background, Field<Expression<Double>> baselineOffset, Field<DivTextRangeBorderTemplate> border, Field<Expression<Long>> end, Field<Expression<String>> fontFamily, Field<Expression<String>> fontFeatureSettings, Field<Expression<Long>> fontSize, Field<Expression<DivSizeUnit>> fontSizeUnit, Field<Expression<DivFontWeight>> fontWeight, Field<Expression<Long>> fontWeightValue, Field<Expression<Double>> letterSpacing, Field<Expression<Long>> lineHeight, Field<DivTextRangeMaskTemplate> mask, Field<Expression<Long>> start, Field<Expression<DivLineStyle>> strike, Field<Expression<Integer>> textColor, Field<DivShadowTemplate> textShadow, Field<Expression<Long>> topOffset, Field<Expression<DivLineStyle>> underline) {
            Intrinsics.checkNotNullParameter(actions, "actions");
            Intrinsics.checkNotNullParameter(alignmentVertical, "alignmentVertical");
            Intrinsics.checkNotNullParameter(background, "background");
            Intrinsics.checkNotNullParameter(baselineOffset, "baselineOffset");
            Intrinsics.checkNotNullParameter(border, "border");
            Intrinsics.checkNotNullParameter(end, "end");
            Intrinsics.checkNotNullParameter(fontFamily, "fontFamily");
            Intrinsics.checkNotNullParameter(fontFeatureSettings, "fontFeatureSettings");
            Intrinsics.checkNotNullParameter(fontSize, "fontSize");
            Intrinsics.checkNotNullParameter(fontSizeUnit, "fontSizeUnit");
            Intrinsics.checkNotNullParameter(fontWeight, "fontWeight");
            Intrinsics.checkNotNullParameter(fontWeightValue, "fontWeightValue");
            Intrinsics.checkNotNullParameter(letterSpacing, "letterSpacing");
            Intrinsics.checkNotNullParameter(lineHeight, "lineHeight");
            Intrinsics.checkNotNullParameter(mask, "mask");
            Intrinsics.checkNotNullParameter(start, "start");
            Intrinsics.checkNotNullParameter(strike, "strike");
            Intrinsics.checkNotNullParameter(textColor, "textColor");
            Intrinsics.checkNotNullParameter(textShadow, "textShadow");
            Intrinsics.checkNotNullParameter(topOffset, "topOffset");
            Intrinsics.checkNotNullParameter(underline, "underline");
            this.actions = actions;
            this.alignmentVertical = alignmentVertical;
            this.background = background;
            this.baselineOffset = baselineOffset;
            this.border = border;
            this.end = end;
            this.fontFamily = fontFamily;
            this.fontFeatureSettings = fontFeatureSettings;
            this.fontSize = fontSize;
            this.fontSizeUnit = fontSizeUnit;
            this.fontWeight = fontWeight;
            this.fontWeightValue = fontWeightValue;
            this.letterSpacing = letterSpacing;
            this.lineHeight = lineHeight;
            this.mask = mask;
            this.start = start;
            this.strike = strike;
            this.textColor = textColor;
            this.textShadow = textShadow;
            this.topOffset = topOffset;
            this.underline = underline;
        }

        public /* synthetic */ RangeTemplate(ParsingEnvironment parsingEnvironment, RangeTemplate rangeTemplate, boolean z, JSONObject jSONObject, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this(parsingEnvironment, (i & 2) != 0 ? null : rangeTemplate, (i & 4) != 0 ? false : z, jSONObject);
        }

        /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
        public RangeTemplate(ParsingEnvironment env, RangeTemplate rangeTemplate, boolean z, JSONObject json) {
            this(Field.INSTANCE.nullField(false), Field.INSTANCE.nullField(false), Field.INSTANCE.nullField(false), Field.INSTANCE.nullField(false), Field.INSTANCE.nullField(false), Field.INSTANCE.nullField(false), Field.INSTANCE.nullField(false), Field.INSTANCE.nullField(false), Field.INSTANCE.nullField(false), Field.INSTANCE.nullField(false), Field.INSTANCE.nullField(false), Field.INSTANCE.nullField(false), Field.INSTANCE.nullField(false), Field.INSTANCE.nullField(false), Field.INSTANCE.nullField(false), Field.INSTANCE.nullField(false), Field.INSTANCE.nullField(false), Field.INSTANCE.nullField(false), Field.INSTANCE.nullField(false), Field.INSTANCE.nullField(false), Field.INSTANCE.nullField(false));
            Intrinsics.checkNotNullParameter(env, "env");
            Intrinsics.checkNotNullParameter(json, "json");
            throw new UnsupportedOperationException("Do not use this constructor directly.");
        }

        @Override // com.yandex.div.json.JsonTemplate
        public DivText.Range resolve(ParsingEnvironment env, JSONObject data) {
            Intrinsics.checkNotNullParameter(env, "env");
            Intrinsics.checkNotNullParameter(data, "data");
            return BuiltInParserKt.getBuiltInParserComponent().getDivTextRangeJsonTemplateResolver().getValue().resolve((ParsingContext) env, this, data);
        }

        @Override // com.yandex.div.json.JSONSerializable
        public JSONObject writeToJSON() {
            return BuiltInParserKt.getBuiltInParserComponent().getDivTextRangeJsonTemplateParser().getValue().serialize(BuiltInParserKt.getBuiltInParsingContext(), this);
        }

        /* JADX INFO: compiled from: DivTextTemplate.kt */
        @Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0006\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R#\u0010\u0006\u001a\u0014\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\n0\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0014\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000e0\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00100\u0004X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0011"}, d2 = {"Lcom/yandex/div2/DivTextTemplate$RangeTemplate$Companion;", "", "()V", "BASELINE_OFFSET_DEFAULT_VALUE", "Lcom/yandex/div/json/expressions/Expression;", "", "CREATOR", "Lkotlin/Function2;", "Lcom/yandex/div/json/ParsingEnvironment;", "Lorg/json/JSONObject;", "Lcom/yandex/div2/DivTextTemplate$RangeTemplate;", "getCREATOR", "()Lkotlin/jvm/functions/Function2;", "FONT_SIZE_UNIT_DEFAULT_VALUE", "Lcom/yandex/div2/DivSizeUnit;", "START_DEFAULT_VALUE", "", "div-data_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private Companion() {
            }

            public final Function2<ParsingEnvironment, JSONObject, RangeTemplate> getCREATOR() {
                return RangeTemplate.CREATOR;
            }
        }
    }

    /* JADX INFO: compiled from: DivTextTemplate.kt */
    @Metadata(d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 %2\u00020\u00012\b\u0012\u0004\u0012\u00020\u00030\u0002:\u0002$%B½\u0001\b\u0016\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\u0012\u0010\u0007\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0\b0\u0005\u0012\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u000b0\u0005\u0012\u0012\u0010\f\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\r0\b0\u0005\u0012\u0012\u0010\u000e\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000f0\b0\u0005\u0012\u0012\u0010\u0010\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00110\b0\u0005\u0012\u0012\u0010\u0012\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00130\b0\u0005\u0012\u0012\u0010\u0014\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00150\b0\u0005\u0012\u0012\u0010\u0016\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00170\b0\u0005\u0012\f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u000b0\u0005¢\u0006\u0002\u0010\u0019B-\b\u0016\u0012\u0006\u0010\u001a\u001a\u00020\u001b\u0012\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\u0000\u0012\b\b\u0002\u0010\u001d\u001a\u00020\u000f\u0012\u0006\u0010\u001e\u001a\u00020\u001f¢\u0006\u0002\u0010 J\u0018\u0010!\u001a\u00020\u00032\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\"\u001a\u00020\u001fH\u0016J\b\u0010#\u001a\u00020\u001fH\u0016R\u0016\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u00058\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\u0007\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0\b0\u00058\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u000b0\u00058\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\f\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\r0\b0\u00058\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\u000e\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000f0\b0\u00058\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\u0010\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00110\b0\u00058\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\u0012\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00130\b0\u00058\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\u0014\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00150\b0\u00058\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\u0016\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00170\b0\u00058\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u000b0\u00058\u0006X\u0087\u0004¢\u0006\u0002\n\u0000¨\u0006&"}, d2 = {"Lcom/yandex/div2/DivTextTemplate$ImageTemplate;", "Lcom/yandex/div/json/JSONSerializable;", "Lcom/yandex/div/json/JsonTemplate;", "Lcom/yandex/div2/DivText$Image;", "accessibility", "Lcom/yandex/div/internal/template/Field;", "Lcom/yandex/div2/DivTextTemplate$ImageTemplate$AccessibilityTemplate;", "alignmentVertical", "Lcom/yandex/div/json/expressions/Expression;", "Lcom/yandex/div2/DivTextAlignmentVertical;", "height", "Lcom/yandex/div2/DivFixedSizeTemplate;", "indexingDirection", "Lcom/yandex/div2/DivText$Image$IndexingDirection;", "preloadRequired", "", "start", "", "tintColor", "", "tintMode", "Lcom/yandex/div2/DivBlendMode;", "url", "Landroid/net/Uri;", "width", "(Lcom/yandex/div/internal/template/Field;Lcom/yandex/div/internal/template/Field;Lcom/yandex/div/internal/template/Field;Lcom/yandex/div/internal/template/Field;Lcom/yandex/div/internal/template/Field;Lcom/yandex/div/internal/template/Field;Lcom/yandex/div/internal/template/Field;Lcom/yandex/div/internal/template/Field;Lcom/yandex/div/internal/template/Field;Lcom/yandex/div/internal/template/Field;)V", cc.o, "Lcom/yandex/div/json/ParsingEnvironment;", "parent", "topLevel", "json", "Lorg/json/JSONObject;", "(Lcom/yandex/div/json/ParsingEnvironment;Lcom/yandex/div2/DivTextTemplate$ImageTemplate;ZLorg/json/JSONObject;)V", "resolve", "data", "writeToJSON", "AccessibilityTemplate", "Companion", "div-data_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class ImageTemplate implements JSONSerializable, JsonTemplate<DivText.Image> {
        private static final DivFixedSize HEIGHT_DEFAULT_VALUE;
        private static final DivFixedSize WIDTH_DEFAULT_VALUE;
        public final Field<AccessibilityTemplate> accessibility;
        public final Field<Expression<DivTextAlignmentVertical>> alignmentVertical;
        public final Field<DivFixedSizeTemplate> height;
        public final Field<Expression<DivText.Image.IndexingDirection>> indexingDirection;
        public final Field<Expression<Boolean>> preloadRequired;
        public final Field<Expression<Long>> start;
        public final Field<Expression<Integer>> tintColor;
        public final Field<Expression<DivBlendMode>> tintMode;
        public final Field<Expression<Uri>> url;
        public final Field<DivFixedSizeTemplate> width;

        /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
        public static final Companion INSTANCE = new Companion(null);
        private static final Expression<DivTextAlignmentVertical> ALIGNMENT_VERTICAL_DEFAULT_VALUE = Expression.INSTANCE.constant(DivTextAlignmentVertical.CENTER);
        private static final Expression<DivText.Image.IndexingDirection> INDEXING_DIRECTION_DEFAULT_VALUE = Expression.INSTANCE.constant(DivText.Image.IndexingDirection.NORMAL);
        private static final Expression<Boolean> PRELOAD_REQUIRED_DEFAULT_VALUE = Expression.INSTANCE.constant(false);
        private static final Expression<DivBlendMode> TINT_MODE_DEFAULT_VALUE = Expression.INSTANCE.constant(DivBlendMode.SOURCE_IN);
        private static final Function2<ParsingEnvironment, JSONObject, ImageTemplate> CREATOR = new Function2<ParsingEnvironment, JSONObject, ImageTemplate>() { // from class: com.yandex.div2.DivTextTemplate$ImageTemplate$Companion$CREATOR$1
            @Override // kotlin.jvm.functions.Function2
            public final DivTextTemplate.ImageTemplate invoke(ParsingEnvironment env, JSONObject it) {
                Intrinsics.checkNotNullParameter(env, "env");
                Intrinsics.checkNotNullParameter(it, "it");
                return new DivTextTemplate.ImageTemplate(env, null, false, it, 6, null);
            }
        };

        public ImageTemplate(Field<AccessibilityTemplate> accessibility, Field<Expression<DivTextAlignmentVertical>> alignmentVertical, Field<DivFixedSizeTemplate> height, Field<Expression<DivText.Image.IndexingDirection>> indexingDirection, Field<Expression<Boolean>> preloadRequired, Field<Expression<Long>> start, Field<Expression<Integer>> tintColor, Field<Expression<DivBlendMode>> tintMode, Field<Expression<Uri>> url, Field<DivFixedSizeTemplate> width) {
            Intrinsics.checkNotNullParameter(accessibility, "accessibility");
            Intrinsics.checkNotNullParameter(alignmentVertical, "alignmentVertical");
            Intrinsics.checkNotNullParameter(height, "height");
            Intrinsics.checkNotNullParameter(indexingDirection, "indexingDirection");
            Intrinsics.checkNotNullParameter(preloadRequired, "preloadRequired");
            Intrinsics.checkNotNullParameter(start, "start");
            Intrinsics.checkNotNullParameter(tintColor, "tintColor");
            Intrinsics.checkNotNullParameter(tintMode, "tintMode");
            Intrinsics.checkNotNullParameter(url, "url");
            Intrinsics.checkNotNullParameter(width, "width");
            this.accessibility = accessibility;
            this.alignmentVertical = alignmentVertical;
            this.height = height;
            this.indexingDirection = indexingDirection;
            this.preloadRequired = preloadRequired;
            this.start = start;
            this.tintColor = tintColor;
            this.tintMode = tintMode;
            this.url = url;
            this.width = width;
        }

        public /* synthetic */ ImageTemplate(ParsingEnvironment parsingEnvironment, ImageTemplate imageTemplate, boolean z, JSONObject jSONObject, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this(parsingEnvironment, (i & 2) != 0 ? null : imageTemplate, (i & 4) != 0 ? false : z, jSONObject);
        }

        /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
        public ImageTemplate(ParsingEnvironment env, ImageTemplate imageTemplate, boolean z, JSONObject json) {
            this(Field.INSTANCE.nullField(false), Field.INSTANCE.nullField(false), Field.INSTANCE.nullField(false), Field.INSTANCE.nullField(false), Field.INSTANCE.nullField(false), Field.INSTANCE.nullField(false), Field.INSTANCE.nullField(false), Field.INSTANCE.nullField(false), Field.INSTANCE.nullField(false), Field.INSTANCE.nullField(false));
            Intrinsics.checkNotNullParameter(env, "env");
            Intrinsics.checkNotNullParameter(json, "json");
            throw new UnsupportedOperationException("Do not use this constructor directly.");
        }

        @Override // com.yandex.div.json.JsonTemplate
        public DivText.Image resolve(ParsingEnvironment env, JSONObject data) {
            Intrinsics.checkNotNullParameter(env, "env");
            Intrinsics.checkNotNullParameter(data, "data");
            return BuiltInParserKt.getBuiltInParserComponent().getDivTextImageJsonTemplateResolver().getValue().resolve((ParsingContext) env, this, data);
        }

        @Override // com.yandex.div.json.JSONSerializable
        public JSONObject writeToJSON() {
            return BuiltInParserKt.getBuiltInParserComponent().getDivTextImageJsonTemplateParser().getValue().serialize(BuiltInParserKt.getBuiltInParsingContext(), this);
        }

        /* JADX INFO: compiled from: DivTextTemplate.kt */
        @Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R#\u0010\u0006\u001a\u0014\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\n0\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u000e\u0010\r\u001a\u00020\u000eX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00100\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00120\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00140\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u000eX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0016"}, d2 = {"Lcom/yandex/div2/DivTextTemplate$ImageTemplate$Companion;", "", "()V", "ALIGNMENT_VERTICAL_DEFAULT_VALUE", "Lcom/yandex/div/json/expressions/Expression;", "Lcom/yandex/div2/DivTextAlignmentVertical;", "CREATOR", "Lkotlin/Function2;", "Lcom/yandex/div/json/ParsingEnvironment;", "Lorg/json/JSONObject;", "Lcom/yandex/div2/DivTextTemplate$ImageTemplate;", "getCREATOR", "()Lkotlin/jvm/functions/Function2;", "HEIGHT_DEFAULT_VALUE", "Lcom/yandex/div2/DivFixedSize;", "INDEXING_DIRECTION_DEFAULT_VALUE", "Lcom/yandex/div2/DivText$Image$IndexingDirection;", "PRELOAD_REQUIRED_DEFAULT_VALUE", "", "TINT_MODE_DEFAULT_VALUE", "Lcom/yandex/div2/DivBlendMode;", "WIDTH_DEFAULT_VALUE", "div-data_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private Companion() {
            }

            public final Function2<ParsingEnvironment, JSONObject, ImageTemplate> getCREATOR() {
                return ImageTemplate.CREATOR;
            }
        }

        static {
            int i = 1;
            HEIGHT_DEFAULT_VALUE = new DivFixedSize(0 == true ? 1 : 0, Expression.INSTANCE.constant(20L), i, 0 == true ? 1 : 0);
            WIDTH_DEFAULT_VALUE = new DivFixedSize(0 == true ? 1 : 0, Expression.INSTANCE.constant(20L), i, 0 == true ? 1 : 0);
        }

        /* JADX INFO: compiled from: DivTextTemplate.kt */
        @Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 \u00162\u00020\u00012\b\u0012\u0004\u0012\u00020\u00030\u0002:\u0001\u0016B)\b\u0016\u0012\u0012\u0010\u0004\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u00060\u0005\u0012\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\t0\u0005¢\u0006\u0002\u0010\nB-\b\u0016\u0012\u0006\u0010\u000b\u001a\u00020\f\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u0000\u0012\b\b\u0002\u0010\u000e\u001a\u00020\u000f\u0012\u0006\u0010\u0010\u001a\u00020\u0011¢\u0006\u0002\u0010\u0012J\u0018\u0010\u0013\u001a\u00020\u00032\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\u0014\u001a\u00020\u0011H\u0016J\b\u0010\u0015\u001a\u00020\u0011H\u0016R\u001c\u0010\u0004\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u00060\u00058\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\b\u001a\b\u0012\u0004\u0012\u00020\t0\u00058\u0006X\u0087\u0004¢\u0006\u0002\n\u0000¨\u0006\u0017"}, d2 = {"Lcom/yandex/div2/DivTextTemplate$ImageTemplate$AccessibilityTemplate;", "Lcom/yandex/div/json/JSONSerializable;", "Lcom/yandex/div/json/JsonTemplate;", "Lcom/yandex/div2/DivText$Image$Accessibility;", "description", "Lcom/yandex/div/internal/template/Field;", "Lcom/yandex/div/json/expressions/Expression;", "", "type", "Lcom/yandex/div2/DivText$Image$Accessibility$Type;", "(Lcom/yandex/div/internal/template/Field;Lcom/yandex/div/internal/template/Field;)V", cc.o, "Lcom/yandex/div/json/ParsingEnvironment;", "parent", "topLevel", "", "json", "Lorg/json/JSONObject;", "(Lcom/yandex/div/json/ParsingEnvironment;Lcom/yandex/div2/DivTextTemplate$ImageTemplate$AccessibilityTemplate;ZLorg/json/JSONObject;)V", "resolve", "data", "writeToJSON", "Companion", "div-data_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
        public static final class AccessibilityTemplate implements JSONSerializable, JsonTemplate<DivText.Image.Accessibility> {
            public final Field<Expression<String>> description;
            public final Field<DivText.Image.Accessibility.Type> type;

            /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
            public static final Companion INSTANCE = new Companion(null);
            private static final DivText.Image.Accessibility.Type TYPE_DEFAULT_VALUE = DivText.Image.Accessibility.Type.AUTO;
            private static final Function2<ParsingEnvironment, JSONObject, AccessibilityTemplate> CREATOR = new Function2<ParsingEnvironment, JSONObject, AccessibilityTemplate>() { // from class: com.yandex.div2.DivTextTemplate$ImageTemplate$AccessibilityTemplate$Companion$CREATOR$1
                @Override // kotlin.jvm.functions.Function2
                public final DivTextTemplate.ImageTemplate.AccessibilityTemplate invoke(ParsingEnvironment env, JSONObject it) {
                    Intrinsics.checkNotNullParameter(env, "env");
                    Intrinsics.checkNotNullParameter(it, "it");
                    return new DivTextTemplate.ImageTemplate.AccessibilityTemplate(env, null, false, it, 6, null);
                }
            };

            public AccessibilityTemplate(Field<Expression<String>> description, Field<DivText.Image.Accessibility.Type> type) {
                Intrinsics.checkNotNullParameter(description, "description");
                Intrinsics.checkNotNullParameter(type, "type");
                this.description = description;
                this.type = type;
            }

            public /* synthetic */ AccessibilityTemplate(ParsingEnvironment parsingEnvironment, AccessibilityTemplate accessibilityTemplate, boolean z, JSONObject jSONObject, int i, DefaultConstructorMarker defaultConstructorMarker) {
                this(parsingEnvironment, (i & 2) != 0 ? null : accessibilityTemplate, (i & 4) != 0 ? false : z, jSONObject);
            }

            /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
            public AccessibilityTemplate(ParsingEnvironment env, AccessibilityTemplate accessibilityTemplate, boolean z, JSONObject json) {
                this(Field.INSTANCE.nullField(false), Field.INSTANCE.nullField(false));
                Intrinsics.checkNotNullParameter(env, "env");
                Intrinsics.checkNotNullParameter(json, "json");
                throw new UnsupportedOperationException("Do not use this constructor directly.");
            }

            @Override // com.yandex.div.json.JsonTemplate
            public DivText.Image.Accessibility resolve(ParsingEnvironment env, JSONObject data) {
                Intrinsics.checkNotNullParameter(env, "env");
                Intrinsics.checkNotNullParameter(data, "data");
                return BuiltInParserKt.getBuiltInParserComponent().getDivTextImageAccessibilityJsonTemplateResolver().getValue().resolve((ParsingContext) env, this, data);
            }

            @Override // com.yandex.div.json.JSONSerializable
            public JSONObject writeToJSON() {
                return BuiltInParserKt.getBuiltInParserComponent().getDivTextImageAccessibilityJsonTemplateParser().getValue().serialize(BuiltInParserKt.getBuiltInParsingContext(), this);
            }

            /* JADX INFO: compiled from: DivTextTemplate.kt */
            @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R#\u0010\u0003\u001a\u0014\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\f"}, d2 = {"Lcom/yandex/div2/DivTextTemplate$ImageTemplate$AccessibilityTemplate$Companion;", "", "()V", "CREATOR", "Lkotlin/Function2;", "Lcom/yandex/div/json/ParsingEnvironment;", "Lorg/json/JSONObject;", "Lcom/yandex/div2/DivTextTemplate$ImageTemplate$AccessibilityTemplate;", "getCREATOR", "()Lkotlin/jvm/functions/Function2;", "TYPE_DEFAULT_VALUE", "Lcom/yandex/div2/DivText$Image$Accessibility$Type;", "div-data_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
            public static final class Companion {
                public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                    this();
                }

                private Companion() {
                }

                public final Function2<ParsingEnvironment, JSONObject, AccessibilityTemplate> getCREATOR() {
                    return AccessibilityTemplate.CREATOR;
                }
            }
        }
    }

    /* JADX INFO: compiled from: DivTextTemplate.kt */
    @Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 \u001b2\u00020\u00012\b\u0012\u0004\u0012\u00020\u00030\u0002:\u0001\u001bBW\b\u0016\u0012\u0012\u0010\u0004\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u00060\u0005\u0012\u0012\u0010\b\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0\u00060\u0005\u0012\u0012\u0010\n\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000b0\u00060\u0005\u0012\u0012\u0010\f\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000e0\r0\u0005¢\u0006\u0002\u0010\u000fB-\b\u0016\u0012\u0006\u0010\u0010\u001a\u00020\u0011\u0012\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u0000\u0012\b\b\u0002\u0010\u0013\u001a\u00020\u0014\u0012\u0006\u0010\u0015\u001a\u00020\u0016¢\u0006\u0002\u0010\u0017J\u0018\u0010\u0018\u001a\u00020\u00032\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0019\u001a\u00020\u0016H\u0016J\b\u0010\u001a\u001a\u00020\u0016H\u0016R\u001c\u0010\u0004\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u00060\u00058\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\b\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0\u00060\u00058\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\n\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000b0\u00060\u00058\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\f\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000e0\r0\u00058\u0006X\u0087\u0004¢\u0006\u0002\n\u0000¨\u0006\u001c"}, d2 = {"Lcom/yandex/div2/DivTextTemplate$EllipsisTemplate;", "Lcom/yandex/div/json/JSONSerializable;", "Lcom/yandex/div/json/JsonTemplate;", "Lcom/yandex/div2/DivText$Ellipsis;", "actions", "Lcom/yandex/div/internal/template/Field;", "", "Lcom/yandex/div2/DivActionTemplate;", "images", "Lcom/yandex/div2/DivTextTemplate$ImageTemplate;", "ranges", "Lcom/yandex/div2/DivTextTemplate$RangeTemplate;", "text", "Lcom/yandex/div/json/expressions/Expression;", "", "(Lcom/yandex/div/internal/template/Field;Lcom/yandex/div/internal/template/Field;Lcom/yandex/div/internal/template/Field;Lcom/yandex/div/internal/template/Field;)V", cc.o, "Lcom/yandex/div/json/ParsingEnvironment;", "parent", "topLevel", "", "json", "Lorg/json/JSONObject;", "(Lcom/yandex/div/json/ParsingEnvironment;Lcom/yandex/div2/DivTextTemplate$EllipsisTemplate;ZLorg/json/JSONObject;)V", "resolve", "data", "writeToJSON", "Companion", "div-data_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class EllipsisTemplate implements JSONSerializable, JsonTemplate<DivText.Ellipsis> {
        public final Field<List<DivActionTemplate>> actions;
        public final Field<List<ImageTemplate>> images;
        public final Field<List<RangeTemplate>> ranges;
        public final Field<Expression<String>> text;

        /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
        public static final Companion INSTANCE = new Companion(null);
        private static final Function2<ParsingEnvironment, JSONObject, EllipsisTemplate> CREATOR = new Function2<ParsingEnvironment, JSONObject, EllipsisTemplate>() { // from class: com.yandex.div2.DivTextTemplate$EllipsisTemplate$Companion$CREATOR$1
            @Override // kotlin.jvm.functions.Function2
            public final DivTextTemplate.EllipsisTemplate invoke(ParsingEnvironment env, JSONObject it) {
                Intrinsics.checkNotNullParameter(env, "env");
                Intrinsics.checkNotNullParameter(it, "it");
                return new DivTextTemplate.EllipsisTemplate(env, null, false, it, 6, null);
            }
        };

        public EllipsisTemplate(Field<List<DivActionTemplate>> actions, Field<List<ImageTemplate>> images, Field<List<RangeTemplate>> ranges, Field<Expression<String>> text) {
            Intrinsics.checkNotNullParameter(actions, "actions");
            Intrinsics.checkNotNullParameter(images, "images");
            Intrinsics.checkNotNullParameter(ranges, "ranges");
            Intrinsics.checkNotNullParameter(text, "text");
            this.actions = actions;
            this.images = images;
            this.ranges = ranges;
            this.text = text;
        }

        public /* synthetic */ EllipsisTemplate(ParsingEnvironment parsingEnvironment, EllipsisTemplate ellipsisTemplate, boolean z, JSONObject jSONObject, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this(parsingEnvironment, (i & 2) != 0 ? null : ellipsisTemplate, (i & 4) != 0 ? false : z, jSONObject);
        }

        /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
        public EllipsisTemplate(ParsingEnvironment env, EllipsisTemplate ellipsisTemplate, boolean z, JSONObject json) {
            this((Field<List<DivActionTemplate>>) Field.INSTANCE.nullField(false), (Field<List<ImageTemplate>>) Field.INSTANCE.nullField(false), (Field<List<RangeTemplate>>) Field.INSTANCE.nullField(false), (Field<Expression<String>>) Field.INSTANCE.nullField(false));
            Intrinsics.checkNotNullParameter(env, "env");
            Intrinsics.checkNotNullParameter(json, "json");
            throw new UnsupportedOperationException("Do not use this constructor directly.");
        }

        @Override // com.yandex.div.json.JsonTemplate
        public DivText.Ellipsis resolve(ParsingEnvironment env, JSONObject data) {
            Intrinsics.checkNotNullParameter(env, "env");
            Intrinsics.checkNotNullParameter(data, "data");
            return BuiltInParserKt.getBuiltInParserComponent().getDivTextEllipsisJsonTemplateResolver().getValue().resolve((ParsingContext) env, this, data);
        }

        @Override // com.yandex.div.json.JSONSerializable
        public JSONObject writeToJSON() {
            return BuiltInParserKt.getBuiltInParserComponent().getDivTextEllipsisJsonTemplateParser().getValue().serialize(BuiltInParserKt.getBuiltInParsingContext(), this);
        }

        /* JADX INFO: compiled from: DivTextTemplate.kt */
        @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R#\u0010\u0003\u001a\u0014\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\t¨\u0006\n"}, d2 = {"Lcom/yandex/div2/DivTextTemplate$EllipsisTemplate$Companion;", "", "()V", "CREATOR", "Lkotlin/Function2;", "Lcom/yandex/div/json/ParsingEnvironment;", "Lorg/json/JSONObject;", "Lcom/yandex/div2/DivTextTemplate$EllipsisTemplate;", "getCREATOR", "()Lkotlin/jvm/functions/Function2;", "div-data_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private Companion() {
            }

            public final Function2<ParsingEnvironment, JSONObject, EllipsisTemplate> getCREATOR() {
                return EllipsisTemplate.CREATOR;
            }
        }
    }
}
