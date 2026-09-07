package com.yandex.div.internal.parser;

import com.json.cc;
import com.pubmatic.sdk.nativead.POBNativeConstants;
import com.yandex.div.internal.template.Field;
import com.yandex.div.internal.template.FieldKt;
import com.yandex.div.json.JSONSerializable;
import com.yandex.div.json.ParsingEnvironment;
import com.yandex.div.json.ParsingErrorLogger;
import com.yandex.div.json.ParsingException;
import com.yandex.div.json.ParsingExceptionKt;
import com.yandex.div.json.ParsingExceptionReason;
import com.yandex.div.json.expressions.Expression;
import com.yandex.div.json.expressions.ExpressionList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: JsonTemplateParser.kt */
/* JADX INFO: loaded from: classes10.dex */
@Metadata(d1 = {"\u0000\u0080\u0001\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\u001a8\u0010\u0000\u001a\n\u0012\u0004\u0012\u0002H\u0002\u0018\u00010\u0001\"\u0004\b\u0000\u0010\u00022\u0006\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\u000e\u0010\u0007\u001a\n\u0012\u0004\u0012\u0002H\u0002\u0018\u00010\u0001H\u0001\u001a\u000e\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b\u001a\u0092\u0001\u0010\f\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0006\b\u0000\u0010\r\u0018\u0001\"\n\b\u0001\u0010\u0002\u0018\u0001*\u00020\u000e*\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00042\u000e\u0010\u0007\u001a\n\u0012\u0004\u0012\u0002H\u0002\u0018\u00010\u00012&\u0010\u0011\u001a\"\u0012\u0004\u0012\u0002H\r\u0012\u0006\u0012\u0004\u0018\u0001H\u00020\u0012j\u0010\u0012\u0004\u0012\u0002H\r\u0012\u0006\u0012\u0004\u0018\u0001H\u0002`\u00132\u000e\b\u0002\u0010\u0014\u001a\b\u0012\u0004\u0012\u0002H\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u0019H\u0086\bø\u0001\u0000\u001a\u0099\u0001\u0010\f\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\b\b\u0000\u0010\u0002*\u00020\u001a*\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00042\u000e\u0010\u0007\u001a\n\u0012\u0004\u0012\u0002H\u0002\u0018\u00010\u00012F\u0010\u001b\u001aB\u0012\u0013\u0012\u00110\u0019¢\u0006\f\b\u001d\u0012\b\b\u001e\u0012\u0004\b\b(\u0018\u0012\u0013\u0012\u00110\u000f¢\u0006\f\b\u001d\u0012\b\b\u001e\u0012\u0004\b\b(\u001f\u0012\u0004\u0012\u0002H\u00020\u001cj\u000e\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u0002H\u0002` 2\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u0019H\u0007¢\u0006\u0002\b!\u001aZ\u0010\f\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\b\b\u0000\u0010\u0002*\u00020\u000e*\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00042\u000e\u0010\u0007\u001a\n\u0012\u0004\u0012\u0002H\u0002\u0018\u00010\u00012\u000e\b\u0002\u0010\u0014\u001a\b\u0012\u0004\u0012\u0002H\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u0019\u001a¤\u0001\u0010\"\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00020#0\u0001\"\u0004\b\u0000\u0010\r\"\b\b\u0001\u0010\u0002*\u00020\u000e*\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00042\u0014\u0010\u0007\u001a\u0010\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00020#\u0018\u00010\u00012&\u0010\u0011\u001a\"\u0012\u0004\u0012\u0002H\r\u0012\u0006\u0012\u0004\u0018\u0001H\u00020\u0012j\u0010\u0012\u0004\u0012\u0002H\r\u0012\u0006\u0012\u0004\u0018\u0001H\u0002`\u00132\u000e\b\u0002\u0010\u0014\u001a\b\u0012\u0004\u0012\u0002H\u00020$2\u000e\b\u0002\u0010%\u001a\b\u0012\u0004\u0012\u0002H\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u0019\u001aµ\u0001\u0010\"\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00020#0\u0001\"\b\b\u0000\u0010\u0002*\u00020\u001a*\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00042\u0014\u0010\u0007\u001a\u0010\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00020#\u0018\u00010\u00012F\u0010\u001b\u001aB\u0012\u0013\u0012\u00110\u0019¢\u0006\f\b\u001d\u0012\b\b\u001e\u0012\u0004\b\b(\u0018\u0012\u0013\u0012\u00110\u000f¢\u0006\f\b\u001d\u0012\b\b\u001e\u0012\u0004\b\b(\u001f\u0012\u0004\u0012\u0002H\u00020\u001cj\u000e\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u0002H\u0002` 2\u000e\b\u0002\u0010\u0014\u001a\b\u0012\u0004\u0012\u0002H\u00020$2\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u0019H\u0007¢\u0006\u0002\b&\u001av\u0010\"\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00020#0\u0001\"\b\b\u0000\u0010\u0002*\u00020\u000e*\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00042\u0014\u0010\u0007\u001a\u0010\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00020#\u0018\u00010\u00012\u000e\b\u0002\u0010\u0014\u001a\b\u0012\u0004\u0012\u0002H\u00020$2\u000e\b\u0002\u0010%\u001a\b\u0012\u0004\u0012\u0002H\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u0019\u001a\u0088\u0001\u0010'\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\r\"\b\b\u0001\u0010\u0002*\u00020\u000e*\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00042\u000e\u0010\u0007\u001a\n\u0012\u0004\u0012\u0002H\u0002\u0018\u00010\u00012&\u0010\u0011\u001a\"\u0012\u0004\u0012\u0002H\r\u0012\u0006\u0012\u0004\u0018\u0001H\u00020\u0012j\u0010\u0012\u0004\u0012\u0002H\r\u0012\u0006\u0012\u0004\u0018\u0001H\u0002`\u00132\u000e\b\u0002\u0010\u0014\u001a\b\u0012\u0004\u0012\u0002H\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u0019\u001a\u0099\u0001\u0010'\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\b\b\u0000\u0010\u0002*\u00020\u001a*\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00042\u000e\u0010\u0007\u001a\n\u0012\u0004\u0012\u0002H\u0002\u0018\u00010\u00012F\u0010\u001b\u001aB\u0012\u0013\u0012\u00110\u0019¢\u0006\f\b\u001d\u0012\b\b\u001e\u0012\u0004\b\b(\u0018\u0012\u0013\u0012\u00110\u000f¢\u0006\f\b\u001d\u0012\b\b\u001e\u0012\u0004\b\b(\u001f\u0012\u0004\u0012\u0002H\u00020\u001cj\u000e\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u0002H\u0002` 2\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u0019H\u0007¢\u0006\u0002\b(\u001aZ\u0010'\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\b\b\u0000\u0010\u0002*\u00020\u000e*\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00042\u000e\u0010\u0007\u001a\n\u0012\u0004\u0012\u0002H\u0002\u0018\u00010\u00012\u000e\b\u0002\u0010\u0014\u001a\b\u0012\u0004\u0012\u0002H\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u0019\u001a¤\u0001\u0010)\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00020#0\u0001\"\u0004\b\u0000\u0010\r\"\b\b\u0001\u0010\u0002*\u00020\u000e*\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00042\u0014\u0010\u0007\u001a\u0010\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00020#\u0018\u00010\u00012&\u0010\u0011\u001a\"\u0012\u0004\u0012\u0002H\r\u0012\u0006\u0012\u0004\u0018\u0001H\u00020\u0012j\u0010\u0012\u0004\u0012\u0002H\r\u0012\u0006\u0012\u0004\u0018\u0001H\u0002`\u00132\u000e\b\u0002\u0010\u0014\u001a\b\u0012\u0004\u0012\u0002H\u00020$2\u000e\b\u0002\u0010%\u001a\b\u0012\u0004\u0012\u0002H\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u0019\u001aÅ\u0001\u0010)\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00020#0\u0001\"\b\b\u0000\u0010\u0002*\u00020\u001a*\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00042\u0014\u0010\u0007\u001a\u0010\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00020#\u0018\u00010\u00012F\u0010\u001b\u001aB\u0012\u0013\u0012\u00110\u0019¢\u0006\f\b\u001d\u0012\b\b\u001e\u0012\u0004\b\b(\u0018\u0012\u0013\u0012\u00110\u000f¢\u0006\f\b\u001d\u0012\b\b\u001e\u0012\u0004\b\b(\u001f\u0012\u0004\u0012\u0002H\u00020\u001cj\u000e\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u0002H\u0002` 2\u000e\b\u0002\u0010\u0014\u001a\b\u0012\u0004\u0012\u0002H\u00020$2\u000e\b\u0002\u0010%\u001a\b\u0012\u0004\u0012\u0002H\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u0019H\u0007¢\u0006\u0002\b*\u001av\u0010)\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00020#0\u0001\"\b\b\u0000\u0010\u0002*\u00020\u000e*\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00042\u0014\u0010\u0007\u001a\u0010\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00020#\u0018\u00010\u00012\u000e\b\u0002\u0010\u0014\u001a\b\u0012\u0004\u0012\u0002H\u00020$2\u000e\b\u0002\u0010%\u001a\b\u0012\u0004\u0012\u0002H\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u0019\u001a&\u0010+\u001a\u0004\u0018\u00010\u0006*\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00062\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u0019H\u0001\u001a¤\u0001\u0010,\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00020#0\u0001\"\u0004\b\u0000\u0010\r\"\b\b\u0001\u0010\u0002*\u00020\u000e*\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00042\u0014\u0010\u0007\u001a\u0010\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00020#\u0018\u00010\u00012&\u0010\u0011\u001a\"\u0012\u0004\u0012\u0002H\r\u0012\u0006\u0012\u0004\u0018\u0001H\u00020\u0012j\u0010\u0012\u0004\u0012\u0002H\r\u0012\u0006\u0012\u0004\u0018\u0001H\u0002`\u00132\u000e\b\u0002\u0010\u0014\u001a\b\u0012\u0004\u0012\u0002H\u00020$2\u000e\b\u0002\u0010%\u001a\b\u0012\u0004\u0012\u0002H\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u0019\u001aµ\u0001\u0010,\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00020#0\u0001\"\b\b\u0000\u0010\u0002*\u00020\u001a*\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00042\u0014\u0010\u0007\u001a\u0010\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00020#\u0018\u00010\u00012F\u0010\u001b\u001aB\u0012\u0013\u0012\u00110\u0019¢\u0006\f\b\u001d\u0012\b\b\u001e\u0012\u0004\b\b(\u0018\u0012\u0013\u0012\u00110\u000f¢\u0006\f\b\u001d\u0012\b\b\u001e\u0012\u0004\b\b(\u001f\u0012\u0004\u0012\u0002H\u00020\u001cj\u000e\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u0002H\u0002` 2\u000e\b\u0002\u0010\u0014\u001a\b\u0012\u0004\u0012\u0002H\u00020$2\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u0019H\u0007¢\u0006\u0002\b-\u001av\u0010,\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00020#0\u0001\"\b\b\u0000\u0010\u0002*\u00020\u000e*\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00042\u0014\u0010\u0007\u001a\u0010\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00020#\u0018\u00010\u00012\u000e\b\u0002\u0010\u0014\u001a\b\u0012\u0004\u0012\u0002H\u00020$2\u000e\b\u0002\u0010%\u001a\b\u0012\u0004\u0012\u0002H\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u0019\u001a2\u0010.\u001a\u00020\t\"\b\b\u0000\u0010\u0002*\u00020\u000e*\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00062\u0014\u0010/\u001a\u0010\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u000200\u0018\u00010\u0001\u001aV\u0010.\u001a\u00020\t\"\b\b\u0000\u0010\u0002*\u00020\u000e*\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00062\u0014\u0010/\u001a\u0010\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u000200\u0018\u00010\u00012\"\u0010\u0011\u001a\u001e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u00020\u000e0\u0012j\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u00020\u000e`\u0013\u001a3\u00101\u001a\u00020\t\"\b\b\u0000\u0010\u0002*\u00020\u001a*\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00062\u000e\u0010/\u001a\n\u0012\u0004\u0012\u0002H\u0002\u0018\u00010\u0001H\u0007¢\u0006\u0002\b2\u001aR\u00101\u001a\u00020\t\"\b\b\u0000\u0010\u0002*\u00020\u000e*\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00062\u000e\u0010/\u001a\n\u0012\u0004\u0012\u0002H\u0002\u0018\u00010\u00012$\b\u0002\u0010\u0011\u001a\u001e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u00020\u000e0\u0012j\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u00020\u000e`\u0013\u001a9\u00101\u001a\u00020\t\"\b\b\u0000\u0010\u0002*\u00020\u000e*\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00062\u0014\u0010/\u001a\u0010\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00020#\u0018\u00010\u0001H\u0007¢\u0006\u0002\b3\u001a]\u00101\u001a\u00020\t\"\b\b\u0000\u0010\u0002*\u00020\u000e*\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00062\u0014\u0010/\u001a\u0010\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00020#\u0018\u00010\u00012\"\u0010\u0011\u001a\u001e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u00020\u000e0\u0012j\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u00020\u000e`\u0013H\u0007¢\u0006\u0002\b3\u001a2\u00104\u001a\u00020\t\"\b\b\u0000\u0010\u0002*\u00020\u000e*\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00062\u0014\u0010/\u001a\u0010\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u000205\u0018\u00010\u0001\u001a\\\u00104\u001a\u00020\t\"\b\b\u0000\u0010\u0002*\u00020\u000e\"\u0004\b\u0001\u0010\r*\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00062\u0014\u0010/\u001a\u0010\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u000205\u0018\u00010\u00012\"\u0010\u0011\u001a\u001e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\r0\u0012j\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\r`\u0013\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u00066"}, d2 = {"referenceOrFallback", "Lcom/yandex/div/internal/template/Field;", "T", "overridable", "", "reference", "", POBNativeConstants.NATIVE_FALLBACK_URL, "suppressMissingValueOrThrow", "", "e", "Lcom/yandex/div/json/ParsingException;", "readField", "R", "", "Lorg/json/JSONObject;", "key", "converter", "Lkotlin/Function1;", "Lcom/yandex/div/internal/parser/Converter;", "validator", "Lcom/yandex/div/internal/parser/ValueValidator;", "logger", "Lcom/yandex/div/json/ParsingErrorLogger;", cc.o, "Lcom/yandex/div/json/ParsingEnvironment;", "Lcom/yandex/div/json/JSONSerializable;", "creator", "Lkotlin/Function2;", "Lkotlin/ParameterName;", "name", "value", "Lcom/yandex/div/internal/parser/Creator;", "readSerializableField", "readListField", "", "Lcom/yandex/div/internal/parser/ListValidator;", "itemValidator", "readSerializableListField", "readOptionalField", "readSerializableOptionalField", "readOptionalListField", "readSerializableOptionalListField", "readReference", "readStrictListField", "readStrictSerializableListField", "writeExpressionListField", "field", "Lcom/yandex/div/json/expressions/ExpressionList;", "writeField", "writeSerializableField", "writeListField", "writeFieldWithExpression", "Lcom/yandex/div/json/expressions/Expression;", "div-data_release"}, k = 2, mv = {1, 5, 1}, xi = 48)
public final class JsonTemplateParserKt {
    public static /* synthetic */ Field readField$default(JSONObject jSONObject, String str, boolean z, Field field, ValueValidator valueValidator, ParsingErrorLogger parsingErrorLogger, ParsingEnvironment parsingEnvironment, int i, Object obj) {
        if ((i & 8) != 0) {
            valueValidator = JsonParser.alwaysValid();
            Intrinsics.checkNotNullExpressionValue(valueValidator, "alwaysValid()");
        }
        return readField(jSONObject, str, z, field, valueValidator, parsingErrorLogger, parsingEnvironment);
    }

    public static final <T> Field<T> readField(JSONObject jSONObject, String key, boolean z, Field<T> field, ValueValidator<T> validator, ParsingErrorLogger logger, ParsingEnvironment env) {
        Intrinsics.checkNotNullParameter(jSONObject, "<this>");
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(validator, "validator");
        Intrinsics.checkNotNullParameter(logger, "logger");
        Intrinsics.checkNotNullParameter(env, "env");
        try {
            return new Field.Value(z, JsonParserKt.read(jSONObject, key, validator, logger, env));
        } catch (ParsingException e) {
            suppressMissingValueOrThrow(e);
            Field<T> fieldReferenceOrFallback = referenceOrFallback(z, readReference(jSONObject, key, logger, env), field);
            if (fieldReferenceOrFallback != null) {
                return fieldReferenceOrFallback;
            }
            throw e;
        }
    }

    public static /* synthetic */ Field readField$default(JSONObject jSONObject, String key, boolean z, Field field, Function1 converter, ValueValidator validator, ParsingErrorLogger logger, ParsingEnvironment env, int i, Object obj) {
        Object objInvoke;
        if ((i & 16) != 0) {
            validator = JsonParser.alwaysValid();
            Intrinsics.checkNotNullExpressionValue(validator, "alwaysValid()");
        }
        Intrinsics.checkNotNullParameter(jSONObject, "<this>");
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(converter, "converter");
        Intrinsics.checkNotNullParameter(validator, "validator");
        Intrinsics.checkNotNullParameter(logger, "logger");
        Intrinsics.checkNotNullParameter(env, "env");
        try {
            Object objOptSafe = JsonParserInternalsKt.optSafe(jSONObject, key);
            if (objOptSafe == null) {
                throw ParsingExceptionKt.missingValue(jSONObject, key);
            }
            Intrinsics.reifiedOperationMarker(2, "R");
            Object obj2 = objOptSafe;
            if (objOptSafe == null) {
                throw ParsingExceptionKt.typeMismatch(jSONObject, key, objOptSafe);
            }
            try {
                objInvoke = converter.invoke(objOptSafe);
            } catch (Exception unused) {
                objInvoke = null;
            }
            if (objInvoke == null) {
                throw ParsingExceptionKt.invalidValue(jSONObject, key, objOptSafe);
            }
            if (validator.isValid(objInvoke)) {
                return new Field.Value(z, objInvoke);
            }
            throw ParsingExceptionKt.invalidValue(jSONObject, key, objInvoke);
        } catch (ParsingException e) {
            suppressMissingValueOrThrow(e);
            Field fieldReferenceOrFallback = referenceOrFallback(z, readReference(jSONObject, key, logger, env), field);
            if (fieldReferenceOrFallback != null) {
                return fieldReferenceOrFallback;
            }
            throw e;
        }
    }

    public static final <T extends JSONSerializable> Field<T> readSerializableField(JSONObject jSONObject, String key, boolean z, Field<T> field, Function2<? super ParsingEnvironment, ? super JSONObject, ? extends T> creator, ParsingErrorLogger logger, ParsingEnvironment env) {
        Intrinsics.checkNotNullParameter(jSONObject, "<this>");
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(creator, "creator");
        Intrinsics.checkNotNullParameter(logger, "logger");
        Intrinsics.checkNotNullParameter(env, "env");
        try {
            return new Field.Value(z, JsonParserKt.read(jSONObject, key, creator, logger, env));
        } catch (ParsingException e) {
            suppressMissingValueOrThrow(e);
            Field<T> fieldReferenceOrFallback = referenceOrFallback(z, readReference(jSONObject, key, logger, env), field);
            if (fieldReferenceOrFallback != null) {
                return fieldReferenceOrFallback;
            }
            throw e;
        }
    }

    public static /* synthetic */ Field readOptionalField$default(JSONObject jSONObject, String str, boolean z, Field field, ValueValidator valueValidator, ParsingErrorLogger parsingErrorLogger, ParsingEnvironment parsingEnvironment, int i, Object obj) {
        if ((i & 8) != 0) {
            valueValidator = JsonParser.alwaysValid();
            Intrinsics.checkNotNullExpressionValue(valueValidator, "alwaysValid()");
        }
        return readOptionalField(jSONObject, str, z, field, valueValidator, parsingErrorLogger, parsingEnvironment);
    }

    public static final <T> Field<T> readOptionalField(JSONObject jSONObject, String key, boolean z, Field<T> field, ValueValidator<T> validator, ParsingErrorLogger logger, ParsingEnvironment env) {
        Intrinsics.checkNotNullParameter(jSONObject, "<this>");
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(validator, "validator");
        Intrinsics.checkNotNullParameter(logger, "logger");
        Intrinsics.checkNotNullParameter(env, "env");
        Object optional = JsonParserKt.readOptional(jSONObject, key, validator, logger, env);
        if (optional != null) {
            return new Field.Value(z, optional);
        }
        String reference = readReference(jSONObject, key, logger, env);
        if (reference != null) {
            return new Field.Reference(z, reference);
        }
        if (field != null) {
            return FieldKt.clone(field, z);
        }
        return Field.INSTANCE.nullField(z);
    }

    public static /* synthetic */ Field readOptionalField$default(JSONObject jSONObject, String str, boolean z, Field field, Function1 function1, ValueValidator valueValidator, ParsingErrorLogger parsingErrorLogger, ParsingEnvironment parsingEnvironment, int i, Object obj) {
        ValueValidator valueValidator2;
        if ((i & 16) != 0) {
            ValueValidator valueValidatorAlwaysValid = JsonParser.alwaysValid();
            Intrinsics.checkNotNullExpressionValue(valueValidatorAlwaysValid, "alwaysValid()");
            valueValidator2 = valueValidatorAlwaysValid;
        } else {
            valueValidator2 = valueValidator;
        }
        return readOptionalField(jSONObject, str, z, field, function1, valueValidator2, parsingErrorLogger, parsingEnvironment);
    }

    public static final <R, T> Field<T> readOptionalField(JSONObject jSONObject, String key, boolean z, Field<T> field, Function1<? super R, ? extends T> converter, ValueValidator<T> validator, ParsingErrorLogger logger, ParsingEnvironment env) {
        Intrinsics.checkNotNullParameter(jSONObject, "<this>");
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(converter, "converter");
        Intrinsics.checkNotNullParameter(validator, "validator");
        Intrinsics.checkNotNullParameter(logger, "logger");
        Intrinsics.checkNotNullParameter(env, "env");
        Object optional = JsonParserKt.readOptional(jSONObject, key, converter, validator, logger, env);
        if (optional != null) {
            return new Field.Value(z, optional);
        }
        String reference = readReference(jSONObject, key, logger, env);
        if (reference != null) {
            return new Field.Reference(z, reference);
        }
        if (field != null) {
            return FieldKt.clone(field, z);
        }
        return Field.INSTANCE.nullField(z);
    }

    public static final <T extends JSONSerializable> Field<T> readSerializableOptionalField(JSONObject jSONObject, String key, boolean z, Field<T> field, Function2<? super ParsingEnvironment, ? super JSONObject, ? extends T> creator, ParsingErrorLogger logger, ParsingEnvironment env) {
        Intrinsics.checkNotNullParameter(jSONObject, "<this>");
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(creator, "creator");
        Intrinsics.checkNotNullParameter(logger, "logger");
        Intrinsics.checkNotNullParameter(env, "env");
        JSONSerializable optional = JsonParserKt.readOptional(jSONObject, key, creator, logger, env);
        if (optional != null) {
            return new Field.Value(z, optional);
        }
        String reference = readReference(jSONObject, key, logger, env);
        if (reference != null) {
            return new Field.Reference(z, reference);
        }
        if (field != null) {
            return FieldKt.clone(field, z);
        }
        return Field.INSTANCE.nullField(z);
    }

    public static /* synthetic */ Field readListField$default(JSONObject jSONObject, String str, boolean z, Field field, ListValidator listValidator, ValueValidator valueValidator, ParsingErrorLogger parsingErrorLogger, ParsingEnvironment parsingEnvironment, int i, Object obj) {
        ListValidator listValidator2;
        ValueValidator valueValidator2;
        if ((i & 8) != 0) {
            ListValidator listValidatorAlwaysValidList = JsonParser.alwaysValidList();
            Intrinsics.checkNotNullExpressionValue(listValidatorAlwaysValidList, "alwaysValidList()");
            listValidator2 = listValidatorAlwaysValidList;
        } else {
            listValidator2 = listValidator;
        }
        if ((i & 16) != 0) {
            ValueValidator valueValidatorAlwaysValid = JsonParser.alwaysValid();
            Intrinsics.checkNotNullExpressionValue(valueValidatorAlwaysValid, "alwaysValid()");
            valueValidator2 = valueValidatorAlwaysValid;
        } else {
            valueValidator2 = valueValidator;
        }
        return readListField(jSONObject, str, z, field, listValidator2, valueValidator2, parsingErrorLogger, parsingEnvironment);
    }

    public static final <T> Field<List<T>> readListField(JSONObject jSONObject, String key, boolean z, Field<List<T>> field, ListValidator<T> validator, ValueValidator<T> itemValidator, ParsingErrorLogger logger, ParsingEnvironment env) {
        Intrinsics.checkNotNullParameter(jSONObject, "<this>");
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(validator, "validator");
        Intrinsics.checkNotNullParameter(itemValidator, "itemValidator");
        Intrinsics.checkNotNullParameter(logger, "logger");
        Intrinsics.checkNotNullParameter(env, "env");
        try {
            return new Field.Value(z, JsonParserKt.readList(jSONObject, key, validator, itemValidator, logger, env));
        } catch (ParsingException e) {
            suppressMissingValueOrThrow(e);
            Field<List<T>> fieldReferenceOrFallback = referenceOrFallback(z, readReference(jSONObject, key, logger, env), field);
            if (fieldReferenceOrFallback != null) {
                return fieldReferenceOrFallback;
            }
            throw e;
        }
    }

    public static /* synthetic */ Field readListField$default(JSONObject jSONObject, String str, boolean z, Field field, Function1 function1, ListValidator listValidator, ValueValidator valueValidator, ParsingErrorLogger parsingErrorLogger, ParsingEnvironment parsingEnvironment, int i, Object obj) {
        ListValidator listValidator2;
        ValueValidator valueValidator2;
        if ((i & 16) != 0) {
            ListValidator listValidatorAlwaysValidList = JsonParser.alwaysValidList();
            Intrinsics.checkNotNullExpressionValue(listValidatorAlwaysValidList, "alwaysValidList()");
            listValidator2 = listValidatorAlwaysValidList;
        } else {
            listValidator2 = listValidator;
        }
        if ((i & 32) != 0) {
            ValueValidator valueValidatorAlwaysValid = JsonParser.alwaysValid();
            Intrinsics.checkNotNullExpressionValue(valueValidatorAlwaysValid, "alwaysValid()");
            valueValidator2 = valueValidatorAlwaysValid;
        } else {
            valueValidator2 = valueValidator;
        }
        return readListField(jSONObject, str, z, field, function1, listValidator2, valueValidator2, parsingErrorLogger, parsingEnvironment);
    }

    public static final <R, T> Field<List<T>> readListField(JSONObject jSONObject, String key, boolean z, Field<List<T>> field, Function1<? super R, ? extends T> converter, ListValidator<T> validator, ValueValidator<T> itemValidator, ParsingErrorLogger logger, ParsingEnvironment env) {
        Intrinsics.checkNotNullParameter(jSONObject, "<this>");
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(converter, "converter");
        Intrinsics.checkNotNullParameter(validator, "validator");
        Intrinsics.checkNotNullParameter(itemValidator, "itemValidator");
        Intrinsics.checkNotNullParameter(logger, "logger");
        Intrinsics.checkNotNullParameter(env, "env");
        try {
            return new Field.Value(z, JsonParserKt.readList(jSONObject, key, converter, validator, itemValidator, logger, env));
        } catch (ParsingException e) {
            suppressMissingValueOrThrow(e);
            Field<List<T>> fieldReferenceOrFallback = referenceOrFallback(z, readReference(jSONObject, key, logger, env), field);
            if (fieldReferenceOrFallback != null) {
                return fieldReferenceOrFallback;
            }
            throw e;
        }
    }

    public static /* synthetic */ Field readSerializableListField$default(JSONObject jSONObject, String str, boolean z, Field field, Function2 function2, ListValidator listValidator, ParsingErrorLogger parsingErrorLogger, ParsingEnvironment parsingEnvironment, int i, Object obj) {
        ListValidator listValidator2;
        if ((i & 16) != 0) {
            ListValidator listValidatorAlwaysValidList = JsonParser.alwaysValidList();
            Intrinsics.checkNotNullExpressionValue(listValidatorAlwaysValidList, "alwaysValidList()");
            listValidator2 = listValidatorAlwaysValidList;
        } else {
            listValidator2 = listValidator;
        }
        return readSerializableListField(jSONObject, str, z, field, function2, listValidator2, parsingErrorLogger, parsingEnvironment);
    }

    public static final <T extends JSONSerializable> Field<List<T>> readSerializableListField(JSONObject jSONObject, String key, boolean z, Field<List<T>> field, Function2<? super ParsingEnvironment, ? super JSONObject, ? extends T> creator, ListValidator<T> validator, ParsingErrorLogger logger, ParsingEnvironment env) {
        Intrinsics.checkNotNullParameter(jSONObject, "<this>");
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(creator, "creator");
        Intrinsics.checkNotNullParameter(validator, "validator");
        Intrinsics.checkNotNullParameter(logger, "logger");
        Intrinsics.checkNotNullParameter(env, "env");
        try {
            return new Field.Value(z, JsonParserKt.readSerializableList(jSONObject, key, creator, validator, logger, env));
        } catch (ParsingException e) {
            suppressMissingValueOrThrow(e);
            Field<List<T>> fieldReferenceOrFallback = referenceOrFallback(z, readReference(jSONObject, key, logger, env), field);
            if (fieldReferenceOrFallback != null) {
                return fieldReferenceOrFallback;
            }
            throw e;
        }
    }

    public static /* synthetic */ Field readOptionalListField$default(JSONObject jSONObject, String str, boolean z, Field field, ListValidator listValidator, ValueValidator valueValidator, ParsingErrorLogger parsingErrorLogger, ParsingEnvironment parsingEnvironment, int i, Object obj) {
        ListValidator listValidator2;
        ValueValidator valueValidator2;
        if ((i & 8) != 0) {
            ListValidator listValidatorAlwaysValidList = JsonParser.alwaysValidList();
            Intrinsics.checkNotNullExpressionValue(listValidatorAlwaysValidList, "alwaysValidList()");
            listValidator2 = listValidatorAlwaysValidList;
        } else {
            listValidator2 = listValidator;
        }
        if ((i & 16) != 0) {
            ValueValidator valueValidatorAlwaysValid = JsonParser.alwaysValid();
            Intrinsics.checkNotNullExpressionValue(valueValidatorAlwaysValid, "alwaysValid()");
            valueValidator2 = valueValidatorAlwaysValid;
        } else {
            valueValidator2 = valueValidator;
        }
        return readOptionalListField(jSONObject, str, z, field, listValidator2, valueValidator2, parsingErrorLogger, parsingEnvironment);
    }

    public static final <T> Field<List<T>> readOptionalListField(JSONObject jSONObject, String key, boolean z, Field<List<T>> field, ListValidator<T> validator, ValueValidator<T> itemValidator, ParsingErrorLogger logger, ParsingEnvironment env) {
        Intrinsics.checkNotNullParameter(jSONObject, "<this>");
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(validator, "validator");
        Intrinsics.checkNotNullParameter(itemValidator, "itemValidator");
        Intrinsics.checkNotNullParameter(logger, "logger");
        Intrinsics.checkNotNullParameter(env, "env");
        List optionalList = JsonParserKt.readOptionalList(jSONObject, key, validator, itemValidator, logger);
        if (optionalList != null) {
            return new Field.Value(z, optionalList);
        }
        String reference = readReference(jSONObject, key, logger, env);
        if (reference != null) {
            return new Field.Reference(z, reference);
        }
        if (field != null) {
            return FieldKt.clone(field, z);
        }
        return Field.INSTANCE.nullField(z);
    }

    public static /* synthetic */ Field readOptionalListField$default(JSONObject jSONObject, String str, boolean z, Field field, Function1 function1, ListValidator listValidator, ValueValidator valueValidator, ParsingErrorLogger parsingErrorLogger, ParsingEnvironment parsingEnvironment, int i, Object obj) {
        ListValidator listValidator2;
        ValueValidator valueValidator2;
        if ((i & 16) != 0) {
            ListValidator listValidatorAlwaysValidList = JsonParser.alwaysValidList();
            Intrinsics.checkNotNullExpressionValue(listValidatorAlwaysValidList, "alwaysValidList()");
            listValidator2 = listValidatorAlwaysValidList;
        } else {
            listValidator2 = listValidator;
        }
        if ((i & 32) != 0) {
            ValueValidator valueValidatorAlwaysValid = JsonParser.alwaysValid();
            Intrinsics.checkNotNullExpressionValue(valueValidatorAlwaysValid, "alwaysValid()");
            valueValidator2 = valueValidatorAlwaysValid;
        } else {
            valueValidator2 = valueValidator;
        }
        return readOptionalListField(jSONObject, str, z, field, function1, listValidator2, valueValidator2, parsingErrorLogger, parsingEnvironment);
    }

    public static final <R, T> Field<List<T>> readOptionalListField(JSONObject jSONObject, String key, boolean z, Field<List<T>> field, Function1<? super R, ? extends T> converter, ListValidator<T> validator, ValueValidator<T> itemValidator, ParsingErrorLogger logger, ParsingEnvironment env) {
        Intrinsics.checkNotNullParameter(jSONObject, "<this>");
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(converter, "converter");
        Intrinsics.checkNotNullParameter(validator, "validator");
        Intrinsics.checkNotNullParameter(itemValidator, "itemValidator");
        Intrinsics.checkNotNullParameter(logger, "logger");
        Intrinsics.checkNotNullParameter(env, "env");
        List optionalList = JsonParserKt.readOptionalList(jSONObject, key, converter, validator, itemValidator, logger);
        if (optionalList != null) {
            return new Field.Value(z, optionalList);
        }
        String reference = readReference(jSONObject, key, logger, env);
        if (reference != null) {
            return new Field.Reference(z, reference);
        }
        if (field != null) {
            return FieldKt.clone(field, z);
        }
        return Field.INSTANCE.nullField(z);
    }

    public static /* synthetic */ Field readSerializableOptionalListField$default(JSONObject jSONObject, String str, boolean z, Field field, Function2 function2, ListValidator listValidator, ValueValidator valueValidator, ParsingErrorLogger parsingErrorLogger, ParsingEnvironment parsingEnvironment, int i, Object obj) {
        ListValidator listValidator2;
        ValueValidator valueValidator2;
        if ((i & 16) != 0) {
            ListValidator listValidatorAlwaysValidList = JsonParser.alwaysValidList();
            Intrinsics.checkNotNullExpressionValue(listValidatorAlwaysValidList, "alwaysValidList()");
            listValidator2 = listValidatorAlwaysValidList;
        } else {
            listValidator2 = listValidator;
        }
        if ((i & 32) != 0) {
            ValueValidator valueValidatorAlwaysValid = JsonParser.alwaysValid();
            Intrinsics.checkNotNullExpressionValue(valueValidatorAlwaysValid, "alwaysValid()");
            valueValidator2 = valueValidatorAlwaysValid;
        } else {
            valueValidator2 = valueValidator;
        }
        return readSerializableOptionalListField(jSONObject, str, z, field, function2, listValidator2, valueValidator2, parsingErrorLogger, parsingEnvironment);
    }

    public static final <T extends JSONSerializable> Field<List<T>> readSerializableOptionalListField(JSONObject jSONObject, String key, boolean z, Field<List<T>> field, Function2<? super ParsingEnvironment, ? super JSONObject, ? extends T> creator, ListValidator<T> validator, ValueValidator<T> itemValidator, ParsingErrorLogger logger, ParsingEnvironment env) {
        Intrinsics.checkNotNullParameter(jSONObject, "<this>");
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(creator, "creator");
        Intrinsics.checkNotNullParameter(validator, "validator");
        Intrinsics.checkNotNullParameter(itemValidator, "itemValidator");
        Intrinsics.checkNotNullParameter(logger, "logger");
        Intrinsics.checkNotNullParameter(env, "env");
        List optionalSerializableList = JsonParserKt.readOptionalSerializableList(jSONObject, key, creator, validator, itemValidator, logger, env);
        if (optionalSerializableList != null) {
            return new Field.Value(z, optionalSerializableList);
        }
        String reference = readReference(jSONObject, key, logger, env);
        if (reference != null) {
            return new Field.Reference(z, reference);
        }
        if (field != null) {
            return FieldKt.clone(field, z);
        }
        return Field.INSTANCE.nullField(z);
    }

    public static /* synthetic */ Field readStrictListField$default(JSONObject jSONObject, String str, boolean z, Field field, ListValidator listValidator, ValueValidator valueValidator, ParsingErrorLogger parsingErrorLogger, ParsingEnvironment parsingEnvironment, int i, Object obj) {
        ListValidator listValidator2;
        ValueValidator valueValidator2;
        if ((i & 8) != 0) {
            ListValidator listValidatorAlwaysValidList = JsonParser.alwaysValidList();
            Intrinsics.checkNotNullExpressionValue(listValidatorAlwaysValidList, "alwaysValidList()");
            listValidator2 = listValidatorAlwaysValidList;
        } else {
            listValidator2 = listValidator;
        }
        if ((i & 16) != 0) {
            ValueValidator valueValidatorAlwaysValid = JsonParser.alwaysValid();
            Intrinsics.checkNotNullExpressionValue(valueValidatorAlwaysValid, "alwaysValid()");
            valueValidator2 = valueValidatorAlwaysValid;
        } else {
            valueValidator2 = valueValidator;
        }
        return readStrictListField(jSONObject, str, z, field, listValidator2, valueValidator2, parsingErrorLogger, parsingEnvironment);
    }

    public static final <T> Field<List<T>> readStrictListField(JSONObject jSONObject, String key, boolean z, Field<List<T>> field, ListValidator<T> validator, ValueValidator<T> itemValidator, ParsingErrorLogger logger, ParsingEnvironment env) {
        Intrinsics.checkNotNullParameter(jSONObject, "<this>");
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(validator, "validator");
        Intrinsics.checkNotNullParameter(itemValidator, "itemValidator");
        Intrinsics.checkNotNullParameter(logger, "logger");
        Intrinsics.checkNotNullParameter(env, "env");
        try {
            return new Field.Value(z, JsonParserKt.readStrictList(jSONObject, key, validator, itemValidator, logger));
        } catch (ParsingException e) {
            suppressMissingValueOrThrow(e);
            Field<List<T>> fieldReferenceOrFallback = referenceOrFallback(z, readReference(jSONObject, key, logger, env), field);
            if (fieldReferenceOrFallback != null) {
                return fieldReferenceOrFallback;
            }
            throw e;
        }
    }

    public static /* synthetic */ Field readStrictListField$default(JSONObject jSONObject, String str, boolean z, Field field, Function1 function1, ListValidator listValidator, ValueValidator valueValidator, ParsingErrorLogger parsingErrorLogger, ParsingEnvironment parsingEnvironment, int i, Object obj) {
        ListValidator listValidator2;
        ValueValidator valueValidator2;
        if ((i & 16) != 0) {
            ListValidator listValidatorAlwaysValidList = JsonParser.alwaysValidList();
            Intrinsics.checkNotNullExpressionValue(listValidatorAlwaysValidList, "alwaysValidList()");
            listValidator2 = listValidatorAlwaysValidList;
        } else {
            listValidator2 = listValidator;
        }
        if ((i & 32) != 0) {
            ValueValidator valueValidatorAlwaysValid = JsonParser.alwaysValid();
            Intrinsics.checkNotNullExpressionValue(valueValidatorAlwaysValid, "alwaysValid()");
            valueValidator2 = valueValidatorAlwaysValid;
        } else {
            valueValidator2 = valueValidator;
        }
        return readStrictListField(jSONObject, str, z, field, function1, listValidator2, valueValidator2, parsingErrorLogger, parsingEnvironment);
    }

    public static final <R, T> Field<List<T>> readStrictListField(JSONObject jSONObject, String key, boolean z, Field<List<T>> field, Function1<? super R, ? extends T> converter, ListValidator<T> validator, ValueValidator<T> itemValidator, ParsingErrorLogger logger, ParsingEnvironment env) {
        Intrinsics.checkNotNullParameter(jSONObject, "<this>");
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(converter, "converter");
        Intrinsics.checkNotNullParameter(validator, "validator");
        Intrinsics.checkNotNullParameter(itemValidator, "itemValidator");
        Intrinsics.checkNotNullParameter(logger, "logger");
        Intrinsics.checkNotNullParameter(env, "env");
        try {
            return new Field.Value(z, JsonParserKt.readStrictList(jSONObject, key, converter, validator, itemValidator, logger));
        } catch (ParsingException e) {
            suppressMissingValueOrThrow(e);
            Field<List<T>> fieldReferenceOrFallback = referenceOrFallback(z, readReference(jSONObject, key, logger, env), field);
            if (fieldReferenceOrFallback != null) {
                return fieldReferenceOrFallback;
            }
            throw e;
        }
    }

    public static /* synthetic */ Field readStrictSerializableListField$default(JSONObject jSONObject, String str, boolean z, Field field, Function2 function2, ListValidator listValidator, ParsingErrorLogger parsingErrorLogger, ParsingEnvironment parsingEnvironment, int i, Object obj) {
        ListValidator listValidator2;
        if ((i & 16) != 0) {
            ListValidator listValidatorAlwaysValidList = JsonParser.alwaysValidList();
            Intrinsics.checkNotNullExpressionValue(listValidatorAlwaysValidList, "alwaysValidList()");
            listValidator2 = listValidatorAlwaysValidList;
        } else {
            listValidator2 = listValidator;
        }
        return readStrictSerializableListField(jSONObject, str, z, field, function2, listValidator2, parsingErrorLogger, parsingEnvironment);
    }

    public static final <T extends JSONSerializable> Field<List<T>> readStrictSerializableListField(JSONObject jSONObject, String key, boolean z, Field<List<T>> field, Function2<? super ParsingEnvironment, ? super JSONObject, ? extends T> creator, ListValidator<T> validator, ParsingErrorLogger logger, ParsingEnvironment env) {
        Intrinsics.checkNotNullParameter(jSONObject, "<this>");
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(creator, "creator");
        Intrinsics.checkNotNullParameter(validator, "validator");
        Intrinsics.checkNotNullParameter(logger, "logger");
        Intrinsics.checkNotNullParameter(env, "env");
        try {
            return new Field.Value(z, JsonParserKt.readStrictSerializableList(jSONObject, key, creator, validator, logger, env));
        } catch (ParsingException e) {
            suppressMissingValueOrThrow(e);
            Field<List<T>> fieldReferenceOrFallback = referenceOrFallback(z, readReference(jSONObject, key, logger, env), field);
            if (fieldReferenceOrFallback != null) {
                return fieldReferenceOrFallback;
            }
            throw e;
        }
    }

    public static final void suppressMissingValueOrThrow(ParsingException e) {
        Intrinsics.checkNotNullParameter(e, "e");
        if (e.getReason() != ParsingExceptionReason.MISSING_VALUE) {
            throw e;
        }
    }

    public static final String readReference(JSONObject jSONObject, String key, ParsingErrorLogger logger, ParsingEnvironment env) {
        Intrinsics.checkNotNullParameter(jSONObject, "<this>");
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(logger, "logger");
        Intrinsics.checkNotNullParameter(env, "env");
        return (String) JsonParserKt.readOptional(jSONObject, "$" + key, new ValueValidator() { // from class: com.yandex.div.internal.parser.JsonTemplateParserKt$$ExternalSyntheticLambda0
            @Override // com.yandex.div.internal.parser.ValueValidator
            public final boolean isValid(Object obj) {
                return JsonTemplateParserKt.readReference$lambda$27((String) obj);
            }
        }, logger, env);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean readReference$lambda$27(String it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return it.length() > 0;
    }

    public static final <T> Field<T> referenceOrFallback(boolean z, String str, Field<T> field) {
        if (str != null) {
            return new Field.Reference(z, str);
        }
        if (field != null) {
            return FieldKt.clone(field, z);
        }
        if (z) {
            return Field.INSTANCE.nullField(z);
        }
        return null;
    }

    public static /* synthetic */ void writeField$default(JSONObject jSONObject, String str, Field field, Function1 function1, int i, Object obj) throws JSONException {
        if ((i & 4) != 0) {
            function1 = new Function1<T, T>() { // from class: com.yandex.div.internal.parser.JsonTemplateParserKt.writeField.1
                @Override // kotlin.jvm.functions.Function1
                public final T invoke(T it) {
                    Intrinsics.checkNotNullParameter(it, "it");
                    return it;
                }
            };
        }
        writeField(jSONObject, str, field, function1);
    }

    public static final <T> void writeField(JSONObject jSONObject, String key, Field<T> field, Function1<? super T, ? extends Object> converter) throws JSONException {
        Intrinsics.checkNotNullParameter(jSONObject, "<this>");
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(converter, "converter");
        if (field instanceof Field.Value) {
            JsonParserKt.write$default(jSONObject, key, converter.invoke(((Field.Value) field).value), null, 4, null);
        } else if (field instanceof Field.Reference) {
            JsonParserKt.write$default(jSONObject, "$" + key, ((Field.Reference) field).reference, null, 4, null);
        }
    }

    public static final <T, R> void writeFieldWithExpression(JSONObject jSONObject, String key, Field<Expression<T>> field, Function1<? super T, ? extends R> converter) throws JSONException {
        Intrinsics.checkNotNullParameter(jSONObject, "<this>");
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(converter, "converter");
        if (field instanceof Field.Value) {
            JsonParserKt.writeExpression(jSONObject, key, (Expression) ((Field.Value) field).value, converter);
        } else if (field instanceof Field.Reference) {
            JsonParserKt.write$default(jSONObject, "$" + key, ((Field.Reference) field).reference, null, 4, null);
        }
    }

    public static final <T extends JSONSerializable> void writeSerializableField(JSONObject jSONObject, String key, Field<T> field) throws JSONException {
        Intrinsics.checkNotNullParameter(jSONObject, "<this>");
        Intrinsics.checkNotNullParameter(key, "key");
        if (field instanceof Field.Value) {
            JsonParserKt.write$default(jSONObject, key, ((JSONSerializable) ((Field.Value) field).value).writeToJSON(), null, 4, null);
        } else if (field instanceof Field.Reference) {
            JsonParserKt.write$default(jSONObject, "$" + key, ((Field.Reference) field).reference, null, 4, null);
        }
    }

    public static final <T> void writeFieldWithExpression(JSONObject jSONObject, String key, Field<Expression<T>> field) throws JSONException {
        Intrinsics.checkNotNullParameter(jSONObject, "<this>");
        Intrinsics.checkNotNullParameter(key, "key");
        if (field instanceof Field.Value) {
            JsonParserKt.writeExpression(jSONObject, key, (Expression) ((Field.Value) field).value);
        } else if (field instanceof Field.Reference) {
            JsonParserKt.write$default(jSONObject, "$" + key, ((Field.Reference) field).reference, null, 4, null);
        }
    }

    public static final <T> void writeExpressionListField(JSONObject jSONObject, String key, Field<ExpressionList<T>> field, Function1<? super T, ? extends Object> converter) throws JSONException {
        Intrinsics.checkNotNullParameter(jSONObject, "<this>");
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(converter, "converter");
        if (field instanceof Field.Value) {
            JsonParserKt.writeExpressionList(jSONObject, key, (ExpressionList) ((Field.Value) field).value, converter);
        } else if (field instanceof Field.Reference) {
            JsonParserKt.write$default(jSONObject, "$" + key, ((Field.Reference) field).reference, null, 4, null);
        }
    }

    public static final <T> void writeExpressionListField(JSONObject jSONObject, String key, Field<ExpressionList<T>> field) throws JSONException {
        Intrinsics.checkNotNullParameter(jSONObject, "<this>");
        Intrinsics.checkNotNullParameter(key, "key");
        Function1 function1DoNotConvert = JsonParser.doNotConvert();
        Intrinsics.checkNotNullExpressionValue(function1DoNotConvert, "doNotConvert()");
        writeExpressionListField(jSONObject, key, field, function1DoNotConvert);
    }

    public static final <T> void writeListField(JSONObject jSONObject, String key, Field<List<T>> field) throws JSONException {
        Intrinsics.checkNotNullParameter(jSONObject, "<this>");
        Intrinsics.checkNotNullParameter(key, "key");
        if (field instanceof Field.Value) {
            JsonParserKt.write(jSONObject, key, (List) ((Field.Value) field).value);
        } else if (field instanceof Field.Reference) {
            JsonParserKt.write$default(jSONObject, "$" + key, ((Field.Reference) field).reference, null, 4, null);
        }
    }

    public static final <T> void writeListField(JSONObject jSONObject, String key, Field<List<T>> field, Function1<? super T, ? extends Object> converter) throws JSONException {
        Intrinsics.checkNotNullParameter(jSONObject, "<this>");
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(converter, "converter");
        if (field instanceof Field.Value) {
            JsonParserKt.write(jSONObject, key, (List) ((Field.Value) field).value, (Function1) converter);
        } else if (field instanceof Field.Reference) {
            JsonParserKt.write$default(jSONObject, "$" + key, ((Field.Reference) field).reference, null, 4, null);
        }
    }

    public static final /* synthetic */ <R, T> Field<T> readField(JSONObject jSONObject, String key, boolean z, Field<T> field, Function1<? super R, ? extends T> converter, ValueValidator<T> validator, ParsingErrorLogger logger, ParsingEnvironment env) {
        T tInvoke;
        Intrinsics.checkNotNullParameter(jSONObject, "<this>");
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(converter, "converter");
        Intrinsics.checkNotNullParameter(validator, "validator");
        Intrinsics.checkNotNullParameter(logger, "logger");
        Intrinsics.checkNotNullParameter(env, "env");
        try {
            Object objOptSafe = JsonParserInternalsKt.optSafe(jSONObject, key);
            if (objOptSafe == null) {
                throw ParsingExceptionKt.missingValue(jSONObject, key);
            }
            Intrinsics.reifiedOperationMarker(2, "R");
            Object obj = objOptSafe;
            if (objOptSafe == null) {
                throw ParsingExceptionKt.typeMismatch(jSONObject, key, objOptSafe);
            }
            try {
                tInvoke = converter.invoke(objOptSafe);
            } catch (Exception unused) {
                tInvoke = null;
            }
            if (tInvoke == null) {
                throw ParsingExceptionKt.invalidValue(jSONObject, key, objOptSafe);
            }
            if (validator.isValid(tInvoke)) {
                return new Field.Value(z, tInvoke);
            }
            throw ParsingExceptionKt.invalidValue(jSONObject, key, tInvoke);
        } catch (ParsingException e) {
            suppressMissingValueOrThrow(e);
            Field<T> fieldReferenceOrFallback = referenceOrFallback(z, readReference(jSONObject, key, logger, env), field);
            if (fieldReferenceOrFallback != null) {
                return fieldReferenceOrFallback;
            }
            throw e;
        }
    }
}
