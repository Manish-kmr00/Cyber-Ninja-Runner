package com.yandex.div2;

import android.net.Uri;
import androidx.compose.material.OutlinedTextFieldKt;
import com.json.cc;
import com.yandex.div.core.view2.divs.widgets.DivSeparatorView;
import com.yandex.div.internal.template.Field;
import com.yandex.div.json.JSONSerializable;
import com.yandex.div.json.JsonTemplate;
import com.yandex.div.json.ParsingEnvironment;
import com.yandex.div.json.expressions.Expression;
import com.yandex.div.serialization.BuiltInParserKt;
import com.yandex.div.serialization.ParsingContext;
import io.appmetrica.analytics.impl.J2;
import io.bidmachine.unified.UnifiedMediationParams;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: compiled from: DivImageTemplate.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000\u0094\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0006\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 k2\u00020\u00012\b\u0012\u0004\u0012\u00020\u00030\u0002:\u0001kBÓ\u0007\b\u0016\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\b0\u0005\u0012\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\n0\u0005\u0012\u0012\u0010\u000b\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\f0\u0005\u0012\u0012\u0010\r\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000f0\u000e0\u0005\u0012\u0012\u0010\u0010\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00110\u000e0\u0005\u0012\u0012\u0010\u0012\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00130\u000e0\u0005\u0012\u0012\u0010\u0014\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00150\f0\u0005\u0012\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00170\u0005\u0012\f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00190\u0005\u0012\u0012\u0010\u001a\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001b0\f0\u0005\u0012\f\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u001d0\u0005\u0012\u0012\u0010\u001e\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001f0\u000e0\u0005\u0012\u0012\u0010 \u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000f0\u000e0\u0005\u0012\u0012\u0010!\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00110\u000e0\u0005\u0012\u0012\u0010\"\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020#0\f0\u0005\u0012\u0012\u0010$\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\f0\u0005\u0012\u0012\u0010%\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020&0\f0\u0005\u0012\u0012\u0010'\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020(0\f0\u0005\u0012\f\u0010)\u001a\b\u0012\u0004\u0012\u00020*0\u0005\u0012\u0012\u0010+\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020,0\f0\u0005\u0012\f\u0010-\u001a\b\u0012\u0004\u0012\u00020.0\u0005\u0012\u0012\u0010/\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002000\u000e0\u0005\u0012\u0012\u00101\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\f0\u0005\u0012\u0012\u00102\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\f0\u0005\u0012\f\u00103\u001a\b\u0012\u0004\u0012\u0002040\u0005\u0012\u0012\u00105\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002060\u000e0\u0005\u0012\f\u00107\u001a\b\u0012\u0004\u0012\u0002080\u0005\u0012\u0012\u00109\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\f0\u0005\u0012\f\u0010:\u001a\b\u0012\u0004\u0012\u00020;0\u0005\u0012\f\u0010<\u001a\b\u0012\u0004\u0012\u00020;0\u0005\u0012\u0012\u0010=\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020>0\u000e0\u0005\u0012\u0012\u0010?\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002000\u000e0\u0005\u0012\u0012\u0010@\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\f0\u0005\u0012\u0012\u0010A\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\f0\u0005\u0012\u0012\u0010B\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002040\u000e0\u0005\u0012\u0012\u0010C\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002040\u000e0\u0005\u0012\u0012\u0010D\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001f0\u000e0\u0005\u0012\u0012\u0010E\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020F0\u000e0\u0005\u0012\u0012\u0010G\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\f0\u0005\u0012\u0012\u0010H\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020>0\u000e0\u0005\u0012\u0012\u0010I\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020J0\u000e0\u0005\u0012\u0012\u0010K\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020L0\f0\u0005\u0012\f\u0010M\u001a\b\u0012\u0004\u0012\u00020N0\u0005\u0012\f\u0010O\u001a\b\u0012\u0004\u0012\u00020P0\u0005\u0012\f\u0010Q\u001a\b\u0012\u0004\u0012\u00020R0\u0005\u0012\f\u0010S\u001a\b\u0012\u0004\u0012\u00020R0\u0005\u0012\u0012\u0010T\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020U0\f0\u0005\u0012\u0012\u0010V\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020W0\f0\u0005\u0012\u0012\u0010X\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020Y0\f0\u0005\u0012\u0012\u0010Z\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020[0\u000e0\u0005\u0012\f\u0010\\\u001a\b\u0012\u0004\u0012\u00020]0\u0005\u0012\u0012\u0010^\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020]0\f0\u0005\u0012\f\u0010_\u001a\b\u0012\u0004\u0012\u00020.0\u0005¢\u0006\u0002\u0010`B-\b\u0016\u0012\u0006\u0010a\u001a\u00020b\u0012\n\b\u0002\u0010c\u001a\u0004\u0018\u00010\u0000\u0012\b\b\u0002\u0010d\u001a\u000200\u0012\u0006\u0010e\u001a\u00020f¢\u0006\u0002\u0010gJ\u0018\u0010h\u001a\u00020\u00032\u0006\u0010a\u001a\u00020b2\u0006\u0010i\u001a\u00020fH\u0016J\b\u0010j\u001a\u00020fH\u0016R\u0016\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u00058\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\b0\u00058\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\t\u001a\b\u0012\u0004\u0012\u00020\n0\u00058\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\u000b\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\f0\u00058\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\r\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000f0\u000e0\u00058\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\u0010\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00110\u000e0\u00058\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\u0012\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00130\u000e0\u00058\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\u0014\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00150\f0\u00058\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00170\u00058\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00190\u00058\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\u001a\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001b0\f0\u00058\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u001d0\u00058\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\u001e\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001f0\u000e0\u00058\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u001c\u0010 \u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000f0\u000e0\u00058\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u001c\u0010!\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00110\u000e0\u00058\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\"\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020#0\f0\u00058\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u001c\u0010$\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\f0\u00058\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u001c\u0010%\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020&0\f0\u00058\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u001c\u0010'\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020(0\f0\u00058\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0016\u0010)\u001a\b\u0012\u0004\u0012\u00020*0\u00058\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u001c\u0010+\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020,0\f0\u00058\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0016\u0010-\u001a\b\u0012\u0004\u0012\u00020.0\u00058\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u001c\u0010/\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002000\u000e0\u00058\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u001c\u00101\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\f0\u00058\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u001c\u00102\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\f0\u00058\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0016\u00103\u001a\b\u0012\u0004\u0012\u0002040\u00058\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u001c\u00105\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002060\u000e0\u00058\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0016\u00107\u001a\b\u0012\u0004\u0012\u0002080\u00058\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u001c\u00109\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\f0\u00058\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0016\u0010:\u001a\b\u0012\u0004\u0012\u00020;0\u00058\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0016\u0010<\u001a\b\u0012\u0004\u0012\u00020;0\u00058\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u001c\u0010=\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020>0\u000e0\u00058\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u001c\u0010?\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002000\u000e0\u00058\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u001c\u0010@\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\f0\u00058\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u001c\u0010A\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\f0\u00058\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u001c\u0010B\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002040\u000e0\u00058\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u001c\u0010C\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002040\u000e0\u00058\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u001c\u0010D\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001f0\u000e0\u00058\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u001c\u0010E\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020F0\u000e0\u00058\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u001c\u0010G\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\f0\u00058\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u001c\u0010H\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020>0\u000e0\u00058\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u001c\u0010I\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020J0\u000e0\u00058\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u001c\u0010K\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020L0\f0\u00058\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0016\u0010M\u001a\b\u0012\u0004\u0012\u00020N0\u00058\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0016\u0010O\u001a\b\u0012\u0004\u0012\u00020P0\u00058\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0016\u0010Q\u001a\b\u0012\u0004\u0012\u00020R0\u00058\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0016\u0010S\u001a\b\u0012\u0004\u0012\u00020R0\u00058\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u001c\u0010T\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020U0\f0\u00058\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u001c\u0010V\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020W0\f0\u00058\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u001c\u0010X\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020Y0\f0\u00058\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u001c\u0010Z\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020[0\u000e0\u00058\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\\\u001a\b\u0012\u0004\u0012\u00020]0\u00058\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u001c\u0010^\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020]0\f0\u00058\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0016\u0010_\u001a\b\u0012\u0004\u0012\u00020.0\u00058\u0006X\u0087\u0004¢\u0006\u0002\n\u0000¨\u0006l"}, d2 = {"Lcom/yandex/div2/DivImageTemplate;", "Lcom/yandex/div/json/JSONSerializable;", "Lcom/yandex/div/json/JsonTemplate;", "Lcom/yandex/div2/DivImage;", "accessibility", "Lcom/yandex/div/internal/template/Field;", "Lcom/yandex/div2/DivAccessibilityTemplate;", "action", "Lcom/yandex/div2/DivActionTemplate;", "actionAnimation", "Lcom/yandex/div2/DivAnimationTemplate;", "actions", "", "alignmentHorizontal", "Lcom/yandex/div/json/expressions/Expression;", "Lcom/yandex/div2/DivAlignmentHorizontal;", "alignmentVertical", "Lcom/yandex/div2/DivAlignmentVertical;", "alpha", "", "animators", "Lcom/yandex/div2/DivAnimatorTemplate;", "appearanceAnimation", "Lcom/yandex/div2/DivFadeTransitionTemplate;", "aspect", "Lcom/yandex/div2/DivAspectTemplate;", J2.g, "Lcom/yandex/div2/DivBackgroundTemplate;", OutlinedTextFieldKt.BorderId, "Lcom/yandex/div2/DivBorderTemplate;", "columnSpan", "", "contentAlignmentHorizontal", "contentAlignmentVertical", "disappearActions", "Lcom/yandex/div2/DivDisappearActionTemplate;", "doubletapActions", "extensions", "Lcom/yandex/div2/DivExtensionTemplate;", "filters", "Lcom/yandex/div2/DivFilterTemplate;", "focus", "Lcom/yandex/div2/DivFocusTemplate;", "functions", "Lcom/yandex/div2/DivFunctionTemplate;", "height", "Lcom/yandex/div2/DivSizeTemplate;", "highPriorityPreviewShow", "", "hoverEndActions", "hoverStartActions", "id", "", UnifiedMediationParams.KEY_IMAGE_URL, "Landroid/net/Uri;", "layoutProvider", "Lcom/yandex/div2/DivLayoutProviderTemplate;", "longtapActions", "margins", "Lcom/yandex/div2/DivEdgeInsetsTemplate;", "paddings", "placeholderColor", "", "preloadRequired", "pressEndActions", "pressStartActions", "preview", "reuseId", "rowSpan", "scale", "Lcom/yandex/div2/DivImageScale;", "selectedActions", "tintColor", "tintMode", "Lcom/yandex/div2/DivBlendMode;", "tooltips", "Lcom/yandex/div2/DivTooltipTemplate;", "transform", "Lcom/yandex/div2/DivTransformTemplate;", "transitionChange", "Lcom/yandex/div2/DivChangeTransitionTemplate;", "transitionIn", "Lcom/yandex/div2/DivAppearanceTransitionTemplate;", "transitionOut", "transitionTriggers", "Lcom/yandex/div2/DivTransitionTrigger;", "variableTriggers", "Lcom/yandex/div2/DivTriggerTemplate;", "variables", "Lcom/yandex/div2/DivVariableTemplate;", "visibility", "Lcom/yandex/div2/DivVisibility;", "visibilityAction", "Lcom/yandex/div2/DivVisibilityActionTemplate;", "visibilityActions", "width", "(Lcom/yandex/div/internal/template/Field;Lcom/yandex/div/internal/template/Field;Lcom/yandex/div/internal/template/Field;Lcom/yandex/div/internal/template/Field;Lcom/yandex/div/internal/template/Field;Lcom/yandex/div/internal/template/Field;Lcom/yandex/div/internal/template/Field;Lcom/yandex/div/internal/template/Field;Lcom/yandex/div/internal/template/Field;Lcom/yandex/div/internal/template/Field;Lcom/yandex/div/internal/template/Field;Lcom/yandex/div/internal/template/Field;Lcom/yandex/div/internal/template/Field;Lcom/yandex/div/internal/template/Field;Lcom/yandex/div/internal/template/Field;Lcom/yandex/div/internal/template/Field;Lcom/yandex/div/internal/template/Field;Lcom/yandex/div/internal/template/Field;Lcom/yandex/div/internal/template/Field;Lcom/yandex/div/internal/template/Field;Lcom/yandex/div/internal/template/Field;Lcom/yandex/div/internal/template/Field;Lcom/yandex/div/internal/template/Field;Lcom/yandex/div/internal/template/Field;Lcom/yandex/div/internal/template/Field;Lcom/yandex/div/internal/template/Field;Lcom/yandex/div/internal/template/Field;Lcom/yandex/div/internal/template/Field;Lcom/yandex/div/internal/template/Field;Lcom/yandex/div/internal/template/Field;Lcom/yandex/div/internal/template/Field;Lcom/yandex/div/internal/template/Field;Lcom/yandex/div/internal/template/Field;Lcom/yandex/div/internal/template/Field;Lcom/yandex/div/internal/template/Field;Lcom/yandex/div/internal/template/Field;Lcom/yandex/div/internal/template/Field;Lcom/yandex/div/internal/template/Field;Lcom/yandex/div/internal/template/Field;Lcom/yandex/div/internal/template/Field;Lcom/yandex/div/internal/template/Field;Lcom/yandex/div/internal/template/Field;Lcom/yandex/div/internal/template/Field;Lcom/yandex/div/internal/template/Field;Lcom/yandex/div/internal/template/Field;Lcom/yandex/div/internal/template/Field;Lcom/yandex/div/internal/template/Field;Lcom/yandex/div/internal/template/Field;Lcom/yandex/div/internal/template/Field;Lcom/yandex/div/internal/template/Field;Lcom/yandex/div/internal/template/Field;Lcom/yandex/div/internal/template/Field;Lcom/yandex/div/internal/template/Field;Lcom/yandex/div/internal/template/Field;)V", cc.o, "Lcom/yandex/div/json/ParsingEnvironment;", "parent", "topLevel", "json", "Lorg/json/JSONObject;", "(Lcom/yandex/div/json/ParsingEnvironment;Lcom/yandex/div2/DivImageTemplate;ZLorg/json/JSONObject;)V", "resolve", "data", "writeToJSON", "Companion", "div-data_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class DivImageTemplate implements JSONSerializable, JsonTemplate<DivImage> {
    private static final DivAnimation ACTION_ANIMATION_DEFAULT_VALUE;
    private static final Expression<Double> ALPHA_DEFAULT_VALUE;
    private static final Expression<DivAlignmentHorizontal> CONTENT_ALIGNMENT_HORIZONTAL_DEFAULT_VALUE;
    private static final Expression<DivAlignmentVertical> CONTENT_ALIGNMENT_VERTICAL_DEFAULT_VALUE;
    private static final Function2<ParsingEnvironment, JSONObject, DivImageTemplate> CREATOR;

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final DivSize.WrapContent HEIGHT_DEFAULT_VALUE;
    private static final Expression<Boolean> HIGH_PRIORITY_PREVIEW_SHOW_DEFAULT_VALUE;
    private static final Expression<Integer> PLACEHOLDER_COLOR_DEFAULT_VALUE;
    private static final Expression<Boolean> PRELOAD_REQUIRED_DEFAULT_VALUE;
    private static final Expression<DivImageScale> SCALE_DEFAULT_VALUE;
    private static final Expression<DivBlendMode> TINT_MODE_DEFAULT_VALUE;
    public static final String TYPE = "image";
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
    public final Field<DivFadeTransitionTemplate> appearanceAnimation;
    public final Field<DivAspectTemplate> aspect;
    public final Field<List<DivBackgroundTemplate>> background;
    public final Field<DivBorderTemplate> border;
    public final Field<Expression<Long>> columnSpan;
    public final Field<Expression<DivAlignmentHorizontal>> contentAlignmentHorizontal;
    public final Field<Expression<DivAlignmentVertical>> contentAlignmentVertical;
    public final Field<List<DivDisappearActionTemplate>> disappearActions;
    public final Field<List<DivActionTemplate>> doubletapActions;
    public final Field<List<DivExtensionTemplate>> extensions;
    public final Field<List<DivFilterTemplate>> filters;
    public final Field<DivFocusTemplate> focus;
    public final Field<List<DivFunctionTemplate>> functions;
    public final Field<DivSizeTemplate> height;
    public final Field<Expression<Boolean>> highPriorityPreviewShow;
    public final Field<List<DivActionTemplate>> hoverEndActions;
    public final Field<List<DivActionTemplate>> hoverStartActions;
    public final Field<String> id;
    public final Field<Expression<Uri>> imageUrl;
    public final Field<DivLayoutProviderTemplate> layoutProvider;
    public final Field<List<DivActionTemplate>> longtapActions;
    public final Field<DivEdgeInsetsTemplate> margins;
    public final Field<DivEdgeInsetsTemplate> paddings;
    public final Field<Expression<Integer>> placeholderColor;
    public final Field<Expression<Boolean>> preloadRequired;
    public final Field<List<DivActionTemplate>> pressEndActions;
    public final Field<List<DivActionTemplate>> pressStartActions;
    public final Field<Expression<String>> preview;
    public final Field<Expression<String>> reuseId;
    public final Field<Expression<Long>> rowSpan;
    public final Field<Expression<DivImageScale>> scale;
    public final Field<List<DivActionTemplate>> selectedActions;
    public final Field<Expression<Integer>> tintColor;
    public final Field<Expression<DivBlendMode>> tintMode;
    public final Field<List<DivTooltipTemplate>> tooltips;
    public final Field<DivTransformTemplate> transform;
    public final Field<DivChangeTransitionTemplate> transitionChange;
    public final Field<DivAppearanceTransitionTemplate> transitionIn;
    public final Field<DivAppearanceTransitionTemplate> transitionOut;
    public final Field<List<DivTransitionTrigger>> transitionTriggers;
    public final Field<List<DivTriggerTemplate>> variableTriggers;
    public final Field<List<DivVariableTemplate>> variables;
    public final Field<Expression<DivVisibility>> visibility;
    public final Field<DivVisibilityActionTemplate> visibilityAction;
    public final Field<List<DivVisibilityActionTemplate>> visibilityActions;
    public final Field<DivSizeTemplate> width;

    public DivImageTemplate(Field<DivAccessibilityTemplate> accessibility, Field<DivActionTemplate> action, Field<DivAnimationTemplate> actionAnimation, Field<List<DivActionTemplate>> actions, Field<Expression<DivAlignmentHorizontal>> alignmentHorizontal, Field<Expression<DivAlignmentVertical>> alignmentVertical, Field<Expression<Double>> alpha, Field<List<DivAnimatorTemplate>> animators, Field<DivFadeTransitionTemplate> appearanceAnimation, Field<DivAspectTemplate> aspect, Field<List<DivBackgroundTemplate>> background, Field<DivBorderTemplate> border, Field<Expression<Long>> columnSpan, Field<Expression<DivAlignmentHorizontal>> contentAlignmentHorizontal, Field<Expression<DivAlignmentVertical>> contentAlignmentVertical, Field<List<DivDisappearActionTemplate>> disappearActions, Field<List<DivActionTemplate>> doubletapActions, Field<List<DivExtensionTemplate>> extensions, Field<List<DivFilterTemplate>> filters, Field<DivFocusTemplate> focus, Field<List<DivFunctionTemplate>> functions, Field<DivSizeTemplate> height, Field<Expression<Boolean>> highPriorityPreviewShow, Field<List<DivActionTemplate>> hoverEndActions, Field<List<DivActionTemplate>> hoverStartActions, Field<String> id, Field<Expression<Uri>> imageUrl, Field<DivLayoutProviderTemplate> layoutProvider, Field<List<DivActionTemplate>> longtapActions, Field<DivEdgeInsetsTemplate> margins, Field<DivEdgeInsetsTemplate> paddings, Field<Expression<Integer>> placeholderColor, Field<Expression<Boolean>> preloadRequired, Field<List<DivActionTemplate>> pressEndActions, Field<List<DivActionTemplate>> pressStartActions, Field<Expression<String>> preview, Field<Expression<String>> reuseId, Field<Expression<Long>> rowSpan, Field<Expression<DivImageScale>> scale, Field<List<DivActionTemplate>> selectedActions, Field<Expression<Integer>> tintColor, Field<Expression<DivBlendMode>> tintMode, Field<List<DivTooltipTemplate>> tooltips, Field<DivTransformTemplate> transform, Field<DivChangeTransitionTemplate> transitionChange, Field<DivAppearanceTransitionTemplate> transitionIn, Field<DivAppearanceTransitionTemplate> transitionOut, Field<List<DivTransitionTrigger>> transitionTriggers, Field<List<DivTriggerTemplate>> variableTriggers, Field<List<DivVariableTemplate>> variables, Field<Expression<DivVisibility>> visibility, Field<DivVisibilityActionTemplate> visibilityAction, Field<List<DivVisibilityActionTemplate>> visibilityActions, Field<DivSizeTemplate> width) {
        Intrinsics.checkNotNullParameter(accessibility, "accessibility");
        Intrinsics.checkNotNullParameter(action, "action");
        Intrinsics.checkNotNullParameter(actionAnimation, "actionAnimation");
        Intrinsics.checkNotNullParameter(actions, "actions");
        Intrinsics.checkNotNullParameter(alignmentHorizontal, "alignmentHorizontal");
        Intrinsics.checkNotNullParameter(alignmentVertical, "alignmentVertical");
        Intrinsics.checkNotNullParameter(alpha, "alpha");
        Intrinsics.checkNotNullParameter(animators, "animators");
        Intrinsics.checkNotNullParameter(appearanceAnimation, "appearanceAnimation");
        Intrinsics.checkNotNullParameter(aspect, "aspect");
        Intrinsics.checkNotNullParameter(background, "background");
        Intrinsics.checkNotNullParameter(border, "border");
        Intrinsics.checkNotNullParameter(columnSpan, "columnSpan");
        Intrinsics.checkNotNullParameter(contentAlignmentHorizontal, "contentAlignmentHorizontal");
        Intrinsics.checkNotNullParameter(contentAlignmentVertical, "contentAlignmentVertical");
        Intrinsics.checkNotNullParameter(disappearActions, "disappearActions");
        Intrinsics.checkNotNullParameter(doubletapActions, "doubletapActions");
        Intrinsics.checkNotNullParameter(extensions, "extensions");
        Intrinsics.checkNotNullParameter(filters, "filters");
        Intrinsics.checkNotNullParameter(focus, "focus");
        Intrinsics.checkNotNullParameter(functions, "functions");
        Intrinsics.checkNotNullParameter(height, "height");
        Intrinsics.checkNotNullParameter(highPriorityPreviewShow, "highPriorityPreviewShow");
        Intrinsics.checkNotNullParameter(hoverEndActions, "hoverEndActions");
        Intrinsics.checkNotNullParameter(hoverStartActions, "hoverStartActions");
        Intrinsics.checkNotNullParameter(id, "id");
        Intrinsics.checkNotNullParameter(imageUrl, "imageUrl");
        Intrinsics.checkNotNullParameter(layoutProvider, "layoutProvider");
        Intrinsics.checkNotNullParameter(longtapActions, "longtapActions");
        Intrinsics.checkNotNullParameter(margins, "margins");
        Intrinsics.checkNotNullParameter(paddings, "paddings");
        Intrinsics.checkNotNullParameter(placeholderColor, "placeholderColor");
        Intrinsics.checkNotNullParameter(preloadRequired, "preloadRequired");
        Intrinsics.checkNotNullParameter(pressEndActions, "pressEndActions");
        Intrinsics.checkNotNullParameter(pressStartActions, "pressStartActions");
        Intrinsics.checkNotNullParameter(preview, "preview");
        Intrinsics.checkNotNullParameter(reuseId, "reuseId");
        Intrinsics.checkNotNullParameter(rowSpan, "rowSpan");
        Intrinsics.checkNotNullParameter(scale, "scale");
        Intrinsics.checkNotNullParameter(selectedActions, "selectedActions");
        Intrinsics.checkNotNullParameter(tintColor, "tintColor");
        Intrinsics.checkNotNullParameter(tintMode, "tintMode");
        Intrinsics.checkNotNullParameter(tooltips, "tooltips");
        Intrinsics.checkNotNullParameter(transform, "transform");
        Intrinsics.checkNotNullParameter(transitionChange, "transitionChange");
        Intrinsics.checkNotNullParameter(transitionIn, "transitionIn");
        Intrinsics.checkNotNullParameter(transitionOut, "transitionOut");
        Intrinsics.checkNotNullParameter(transitionTriggers, "transitionTriggers");
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
        this.appearanceAnimation = appearanceAnimation;
        this.aspect = aspect;
        this.background = background;
        this.border = border;
        this.columnSpan = columnSpan;
        this.contentAlignmentHorizontal = contentAlignmentHorizontal;
        this.contentAlignmentVertical = contentAlignmentVertical;
        this.disappearActions = disappearActions;
        this.doubletapActions = doubletapActions;
        this.extensions = extensions;
        this.filters = filters;
        this.focus = focus;
        this.functions = functions;
        this.height = height;
        this.highPriorityPreviewShow = highPriorityPreviewShow;
        this.hoverEndActions = hoverEndActions;
        this.hoverStartActions = hoverStartActions;
        this.id = id;
        this.imageUrl = imageUrl;
        this.layoutProvider = layoutProvider;
        this.longtapActions = longtapActions;
        this.margins = margins;
        this.paddings = paddings;
        this.placeholderColor = placeholderColor;
        this.preloadRequired = preloadRequired;
        this.pressEndActions = pressEndActions;
        this.pressStartActions = pressStartActions;
        this.preview = preview;
        this.reuseId = reuseId;
        this.rowSpan = rowSpan;
        this.scale = scale;
        this.selectedActions = selectedActions;
        this.tintColor = tintColor;
        this.tintMode = tintMode;
        this.tooltips = tooltips;
        this.transform = transform;
        this.transitionChange = transitionChange;
        this.transitionIn = transitionIn;
        this.transitionOut = transitionOut;
        this.transitionTriggers = transitionTriggers;
        this.variableTriggers = variableTriggers;
        this.variables = variables;
        this.visibility = visibility;
        this.visibilityAction = visibilityAction;
        this.visibilityActions = visibilityActions;
        this.width = width;
    }

    public /* synthetic */ DivImageTemplate(ParsingEnvironment parsingEnvironment, DivImageTemplate divImageTemplate, boolean z, JSONObject jSONObject, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(parsingEnvironment, (i & 2) != 0 ? null : divImageTemplate, (i & 4) != 0 ? false : z, jSONObject);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public DivImageTemplate(ParsingEnvironment env, DivImageTemplate divImageTemplate, boolean z, JSONObject json) {
        this(Field.INSTANCE.nullField(false), Field.INSTANCE.nullField(false), Field.INSTANCE.nullField(false), Field.INSTANCE.nullField(false), Field.INSTANCE.nullField(false), Field.INSTANCE.nullField(false), Field.INSTANCE.nullField(false), Field.INSTANCE.nullField(false), Field.INSTANCE.nullField(false), Field.INSTANCE.nullField(false), Field.INSTANCE.nullField(false), Field.INSTANCE.nullField(false), Field.INSTANCE.nullField(false), Field.INSTANCE.nullField(false), Field.INSTANCE.nullField(false), Field.INSTANCE.nullField(false), Field.INSTANCE.nullField(false), Field.INSTANCE.nullField(false), Field.INSTANCE.nullField(false), Field.INSTANCE.nullField(false), Field.INSTANCE.nullField(false), Field.INSTANCE.nullField(false), Field.INSTANCE.nullField(false), Field.INSTANCE.nullField(false), Field.INSTANCE.nullField(false), Field.INSTANCE.nullField(false), Field.INSTANCE.nullField(false), Field.INSTANCE.nullField(false), Field.INSTANCE.nullField(false), Field.INSTANCE.nullField(false), Field.INSTANCE.nullField(false), Field.INSTANCE.nullField(false), Field.INSTANCE.nullField(false), Field.INSTANCE.nullField(false), Field.INSTANCE.nullField(false), Field.INSTANCE.nullField(false), Field.INSTANCE.nullField(false), Field.INSTANCE.nullField(false), Field.INSTANCE.nullField(false), Field.INSTANCE.nullField(false), Field.INSTANCE.nullField(false), Field.INSTANCE.nullField(false), Field.INSTANCE.nullField(false), Field.INSTANCE.nullField(false), Field.INSTANCE.nullField(false), Field.INSTANCE.nullField(false), Field.INSTANCE.nullField(false), Field.INSTANCE.nullField(false), Field.INSTANCE.nullField(false), Field.INSTANCE.nullField(false), Field.INSTANCE.nullField(false), Field.INSTANCE.nullField(false), Field.INSTANCE.nullField(false), Field.INSTANCE.nullField(false));
        Intrinsics.checkNotNullParameter(env, "env");
        Intrinsics.checkNotNullParameter(json, "json");
        throw new UnsupportedOperationException("Do not use this constructor directly.");
    }

    @Override // com.yandex.div.json.JsonTemplate
    public DivImage resolve(ParsingEnvironment env, JSONObject data) {
        Intrinsics.checkNotNullParameter(env, "env");
        Intrinsics.checkNotNullParameter(data, "data");
        return BuiltInParserKt.getBuiltInParserComponent().getDivImageJsonTemplateResolver().getValue().resolve((ParsingContext) env, this, data);
    }

    @Override // com.yandex.div.json.JSONSerializable
    public JSONObject writeToJSON() {
        return BuiltInParserKt.getBuiltInParserComponent().getDivImageJsonTemplateParser().getValue().serialize(BuiltInParserKt.getBuiltInParsingContext(), this);
    }

    /* JADX INFO: compiled from: DivImageTemplate.kt */
    @Metadata(d1 = {"\u0000n\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0006\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\b\u001a\b\u0012\u0004\u0012\u00020\t0\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u000b0\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R#\u0010\f\u001a\u0014\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u00100\r¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u000e\u0010\u0013\u001a\u00020\u0014X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00160\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00180\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00160\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u001b0\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u001d0\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\u001fX\u0086T¢\u0006\u0002\n\u0000R\u0014\u0010 \u001a\b\u0012\u0004\u0012\u00020!0\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\"\u001a\u00020#X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006$"}, d2 = {"Lcom/yandex/div2/DivImageTemplate$Companion;", "", "()V", "ACTION_ANIMATION_DEFAULT_VALUE", "Lcom/yandex/div2/DivAnimation;", "ALPHA_DEFAULT_VALUE", "Lcom/yandex/div/json/expressions/Expression;", "", "CONTENT_ALIGNMENT_HORIZONTAL_DEFAULT_VALUE", "Lcom/yandex/div2/DivAlignmentHorizontal;", "CONTENT_ALIGNMENT_VERTICAL_DEFAULT_VALUE", "Lcom/yandex/div2/DivAlignmentVertical;", "CREATOR", "Lkotlin/Function2;", "Lcom/yandex/div/json/ParsingEnvironment;", "Lorg/json/JSONObject;", "Lcom/yandex/div2/DivImageTemplate;", "getCREATOR", "()Lkotlin/jvm/functions/Function2;", "HEIGHT_DEFAULT_VALUE", "Lcom/yandex/div2/DivSize$WrapContent;", "HIGH_PRIORITY_PREVIEW_SHOW_DEFAULT_VALUE", "", "PLACEHOLDER_COLOR_DEFAULT_VALUE", "", "PRELOAD_REQUIRED_DEFAULT_VALUE", "SCALE_DEFAULT_VALUE", "Lcom/yandex/div2/DivImageScale;", "TINT_MODE_DEFAULT_VALUE", "Lcom/yandex/div2/DivBlendMode;", "TYPE", "", "VISIBILITY_DEFAULT_VALUE", "Lcom/yandex/div2/DivVisibility;", "WIDTH_DEFAULT_VALUE", "Lcom/yandex/div2/DivSize$MatchParent;", "div-data_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final Function2<ParsingEnvironment, JSONObject, DivImageTemplate> getCREATOR() {
            return DivImageTemplate.CREATOR;
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
        HEIGHT_DEFAULT_VALUE = new DivSize.WrapContent(new DivWrapContentSize(null, null, null, 7, null));
        HIGH_PRIORITY_PREVIEW_SHOW_DEFAULT_VALUE = Expression.INSTANCE.constant(false);
        PLACEHOLDER_COLOR_DEFAULT_VALUE = Expression.INSTANCE.constant(Integer.valueOf(DivSeparatorView.DEFAULT_DIVIDER_COLOR));
        PRELOAD_REQUIRED_DEFAULT_VALUE = Expression.INSTANCE.constant(false);
        SCALE_DEFAULT_VALUE = Expression.INSTANCE.constant(DivImageScale.FILL);
        TINT_MODE_DEFAULT_VALUE = Expression.INSTANCE.constant(DivBlendMode.SOURCE_IN);
        VISIBILITY_DEFAULT_VALUE = Expression.INSTANCE.constant(DivVisibility.VISIBLE);
        WIDTH_DEFAULT_VALUE = new DivSize.MatchParent(new DivMatchParentSize(0 == true ? 1 : 0, 1, 0 == true ? 1 : 0));
        CREATOR = new Function2<ParsingEnvironment, JSONObject, DivImageTemplate>() { // from class: com.yandex.div2.DivImageTemplate$Companion$CREATOR$1
            @Override // kotlin.jvm.functions.Function2
            public final DivImageTemplate invoke(ParsingEnvironment env, JSONObject it) {
                Intrinsics.checkNotNullParameter(env, "env");
                Intrinsics.checkNotNullParameter(it, "it");
                return new DivImageTemplate(env, null, false, it, 6, null);
            }
        };
    }
}
