package com.yandex.div.internal.parser;

import _COROUTINE.ArtificialStackFrames;
import com.json.cc;
import com.yandex.div.json.JSONSerializable;
import com.yandex.div.json.ParsingEnvironment;
import com.yandex.div.json.ParsingErrorLogger;
import com.yandex.div.json.ParsingException;
import com.yandex.div.json.ParsingExceptionKt;
import com.yandex.div.json.expressions.ConstantExpressionList;
import com.yandex.div.json.expressions.Expression;
import com.yandex.div.json.expressions.ExpressionList;
import com.yandex.div.json.expressions.ExpressionResolver;
import com.yandex.div.json.expressions.MutableExpressionList;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: JsonParser.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000j\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001ay\u0010\u0000\u001a\u0002H\u0001\"\u0006\b\u0000\u0010\u0002\u0018\u0001\"\n\b\u0001\u0010\u0001\u0018\u0001*\u00020\u0003*\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062&\u0010\u0007\u001a\"\u0012\u0004\u0012\u0002H\u0002\u0012\u0006\u0012\u0004\u0018\u0001H\u00010\bj\u0010\u0012\u0004\u0012\u0002H\u0002\u0012\u0006\u0012\u0004\u0018\u0001H\u0001`\t2\u000e\b\u0002\u0010\n\u001a\b\u0012\u0004\u0012\u0002H\u00010\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fH\u0086\bø\u0001\u0000¢\u0006\u0002\u0010\u0010\u001ay\u0010\u0000\u001a\u0002H\u0001\"\b\b\u0000\u0010\u0001*\u00020\u0011*\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062F\u0010\u0012\u001aB\u0012\u0013\u0012\u00110\u000f¢\u0006\f\b\u0014\u0012\b\b\u0015\u0012\u0004\b\b(\u000e\u0012\u0013\u0012\u00110\u0004¢\u0006\f\b\u0014\u0012\b\b\u0015\u0012\u0004\b\b(\u0016\u0012\u0004\u0012\u0002H\u00010\u0013j\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u0002H\u0001`\u00172\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f¢\u0006\u0002\u0010\u0018\u001aA\u0010\u0000\u001a\u0002H\u0001\"\b\b\u0000\u0010\u0001*\u00020\u0003*\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u000e\b\u0002\u0010\n\u001a\b\u0012\u0004\u0012\u0002H\u00010\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f¢\u0006\u0002\u0010\u0019\u001a\u001a\u0010\u0000\u001a\u00020\u0006*\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\r\u001a\u0080\u0001\u0010\u001a\u001a\b\u0012\u0004\u0012\u0002H\u00010\u001b\"\u0004\b\u0000\u0010\u0002\"\b\b\u0001\u0010\u0001*\u00020\u0003*\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062&\u0010\u0007\u001a\"\u0012\u0004\u0012\u0002H\u0002\u0012\u0006\u0012\u0004\u0018\u0001H\u00010\bj\u0010\u0012\u0004\u0012\u0002H\u0002\u0012\u0006\u0012\u0004\u0018\u0001H\u0001`\t2\u000e\b\u0002\u0010\n\u001a\b\u0012\u0004\u0012\u0002H\u00010\u001c2\u000e\b\u0002\u0010\u001d\u001a\b\u0012\u0004\u0012\u0002H\u00010\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f\u001a\u008f\u0001\u0010\u001a\u001a\b\u0012\u0004\u0012\u0002H\u00010\u001b\"\b\b\u0000\u0010\u0001*\u00020\u0011*\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062F\u0010\u0012\u001aB\u0012\u0013\u0012\u00110\u000f¢\u0006\f\b\u0014\u0012\b\b\u0015\u0012\u0004\b\b(\u000e\u0012\u0013\u0012\u00110\u0004¢\u0006\f\b\u0014\u0012\b\b\u0015\u0012\u0004\b\b(\u0016\u0012\u0004\u0012\u0002H\u00010\u0013j\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u0002H\u0001`\u00172\f\u0010\n\u001a\b\u0012\u0004\u0012\u0002H\u00010\u001c2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fH\u0007¢\u0006\u0002\b\u001e\u001aR\u0010\u001a\u001a\b\u0012\u0004\u0012\u0002H\u00010\u001b\"\b\b\u0000\u0010\u0001*\u00020\u0003*\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u000e\b\u0002\u0010\n\u001a\b\u0012\u0004\u0012\u0002H\u00010\u001c2\u000e\b\u0002\u0010\u001d\u001a\b\u0012\u0004\u0012\u0002H\u00010\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f\u001aq\u0010\u001f\u001a\u0004\u0018\u0001H\u0001\"\u0004\b\u0000\u0010\u0002\"\b\b\u0001\u0010\u0001*\u00020\u0003*\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062&\u0010\u0007\u001a\"\u0012\u0004\u0012\u0002H\u0002\u0012\u0006\u0012\u0004\u0018\u0001H\u00010\bj\u0010\u0012\u0004\u0012\u0002H\u0002\u0012\u0006\u0012\u0004\u0018\u0001H\u0001`\t2\u000e\b\u0002\u0010\n\u001a\b\u0012\u0004\u0012\u0002H\u00010\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f¢\u0006\u0002\u0010\u0010\u001a{\u0010\u001f\u001a\u0004\u0018\u0001H\u0001\"\b\b\u0000\u0010\u0001*\u00020\u0011*\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062F\u0010\u0012\u001aB\u0012\u0013\u0012\u00110\u000f¢\u0006\f\b\u0014\u0012\b\b\u0015\u0012\u0004\b\b(\u000e\u0012\u0013\u0012\u00110\u0004¢\u0006\f\b\u0014\u0012\b\b\u0015\u0012\u0004\b\b(\u0016\u0012\u0004\u0012\u0002H\u00010\u0013j\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u0002H\u0001`\u00172\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f¢\u0006\u0002\u0010\u0018\u001aC\u0010\u001f\u001a\u0004\u0018\u0001H\u0001\"\b\b\u0000\u0010\u0001*\u00020\u0003*\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u000e\b\u0002\u0010\n\u001a\b\u0012\u0004\u0012\u0002H\u00010\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f¢\u0006\u0002\u0010\u0019\u001av\u0010 \u001a\n\u0012\u0004\u0012\u0002H\u0001\u0018\u00010\u001b\"\u0004\b\u0000\u0010\u0002\"\b\b\u0001\u0010\u0001*\u00020\u0003*\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062&\u0010\u0007\u001a\"\u0012\u0004\u0012\u0002H\u0002\u0012\u0006\u0012\u0004\u0018\u0001H\u00010\bj\u0010\u0012\u0004\u0012\u0002H\u0002\u0012\u0006\u0012\u0004\u0018\u0001H\u0001`\t2\f\u0010\n\u001a\b\u0012\u0004\u0012\u0002H\u00010\u001c2\f\u0010\u001d\u001a\b\u0012\u0004\u0012\u0002H\u00010\u000b2\u0006\u0010\f\u001a\u00020\r\u001a¡\u0001\u0010 \u001a\n\u0012\u0004\u0012\u0002H\u0001\u0018\u00010\u001b\"\b\b\u0000\u0010\u0001*\u00020\u0011*\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062F\u0010\u0012\u001aB\u0012\u0013\u0012\u00110\u000f¢\u0006\f\b\u0014\u0012\b\b\u0015\u0012\u0004\b\b(\u000e\u0012\u0013\u0012\u00110\u0004¢\u0006\f\b\u0014\u0012\b\b\u0015\u0012\u0004\b\b(\u0016\u0012\u0004\u0012\u0002H\u00010\u0013j\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u0002H\u0001`\u00172\f\u0010\n\u001a\b\u0012\u0004\u0012\u0002H\u00010\u001c2\u000e\b\u0002\u0010\u001d\u001a\b\u0012\u0004\u0012\u0002H\u00010\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fH\u0007¢\u0006\u0002\b!\u001aH\u0010 \u001a\n\u0012\u0004\u0012\u0002H\u0001\u0018\u00010\u001b\"\b\b\u0000\u0010\u0001*\u00020\u0003*\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\f\u0010\n\u001a\b\u0012\u0004\u0012\u0002H\u00010\u001c2\f\u0010\u001d\u001a\b\u0012\u0004\u0012\u0002H\u00010\u000b2\u0006\u0010\f\u001a\u00020\r\u001ax\u0010\"\u001a\b\u0012\u0004\u0012\u0002H\u00010\u001b\"\u0004\b\u0000\u0010\u0002\"\b\b\u0001\u0010\u0001*\u00020\u0003*\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062&\u0010\u0007\u001a\"\u0012\u0004\u0012\u0002H\u0002\u0012\u0006\u0012\u0004\u0018\u0001H\u00010\bj\u0010\u0012\u0004\u0012\u0002H\u0002\u0012\u0006\u0012\u0004\u0018\u0001H\u0001`\t2\u000e\b\u0002\u0010\n\u001a\b\u0012\u0004\u0012\u0002H\u00010\u001c2\u000e\b\u0002\u0010\u001d\u001a\b\u0012\u0004\u0012\u0002H\u00010\u000b2\u0006\u0010\f\u001a\u00020\r\u001a\u008f\u0001\u0010\"\u001a\b\u0012\u0004\u0012\u0002H\u00010\u001b\"\b\b\u0000\u0010\u0001*\u00020\u0011*\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062F\u0010\u0012\u001aB\u0012\u0013\u0012\u00110\u000f¢\u0006\f\b\u0014\u0012\b\b\u0015\u0012\u0004\b\b(\u000e\u0012\u0013\u0012\u00110\u0004¢\u0006\f\b\u0014\u0012\b\b\u0015\u0012\u0004\b\b(\u0016\u0012\u0004\u0012\u0002H\u00010\u0013j\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u0002H\u0001`\u00172\f\u0010\n\u001a\b\u0012\u0004\u0012\u0002H\u00010\u001c2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fH\u0007¢\u0006\u0002\b#\u001aJ\u0010\"\u001a\b\u0012\u0004\u0012\u0002H\u00010\u001b\"\b\b\u0000\u0010\u0001*\u00020\u0003*\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u000e\b\u0002\u0010\n\u001a\b\u0012\u0004\u0012\u0002H\u00010\u001c2\u000e\b\u0002\u0010\u001d\u001a\b\u0012\u0004\u0012\u0002H\u00010\u000b2\u0006\u0010\f\u001a\u00020\r\u001a0\u0010$\u001a\u00020%\"\n\b\u0000\u0010\u0001\u0018\u0001*\u00020\u0011*\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\b\u0010\u0016\u001a\u0004\u0018\u0001H\u0001H\u0086\b¢\u0006\u0002\u0010&\u001aQ\u0010$\u001a\u00020%\"\b\b\u0000\u0010\u0001*\u00020\u0003*\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\b\u0010\u0016\u001a\u0004\u0018\u0001H\u00012$\b\u0002\u0010\u0007\u001a\u001e\u0012\u0004\u0012\u0002H\u0001\u0012\u0004\u0012\u00020\u00030\bj\u000e\u0012\u0004\u0012\u0002H\u0001\u0012\u0004\u0012\u00020\u0003`\t¢\u0006\u0002\u0010'\u001a,\u0010$\u001a\u00020%\"\b\b\u0000\u0010\u0001*\u00020\u0003*\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u000e\u0010\u0016\u001a\n\u0012\u0004\u0012\u0002H\u0001\u0018\u00010\u001b\u001aP\u0010$\u001a\u00020%\"\b\b\u0000\u0010\u0001*\u00020\u0003*\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u000e\u0010\u0016\u001a\n\u0012\u0004\u0012\u0002H\u0001\u0018\u00010\u001b2\"\u0010\u0007\u001a\u001e\u0012\u0004\u0012\u0002H\u0001\u0012\u0004\u0012\u00020\u00030\bj\u000e\u0012\u0004\u0012\u0002H\u0001\u0012\u0004\u0012\u00020\u0003`\t\u001a,\u0010(\u001a\u00020%\"\b\b\u0000\u0010\u0001*\u00020\u0003*\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u000e\u0010\u0016\u001a\n\u0012\u0004\u0012\u0002H\u0001\u0018\u00010)\u001aV\u0010(\u001a\u00020%\"\b\b\u0000\u0010\u0001*\u00020\u0003\"\u0004\b\u0001\u0010\u0002*\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u000e\u0010\u0016\u001a\n\u0012\u0004\u0012\u0002H\u0001\u0018\u00010)2\"\u0010\u0007\u001a\u001e\u0012\u0004\u0012\u0002H\u0001\u0012\u0004\u0012\u0002H\u00020\bj\u000e\u0012\u0004\u0012\u0002H\u0001\u0012\u0004\u0012\u0002H\u0002`\t\u001a,\u0010*\u001a\u00020%\"\b\b\u0000\u0010\u0001*\u00020\u0003*\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u000e\u0010\u0016\u001a\n\u0012\u0004\u0012\u0002H\u0001\u0018\u00010+\u001aV\u0010*\u001a\u00020%\"\b\b\u0000\u0010\u0001*\u00020\u0003\"\u0004\b\u0001\u0010\u0002*\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u000e\u0010\u0016\u001a\n\u0012\u0004\u0012\u0002H\u0001\u0018\u00010+2\"\u0010\u0007\u001a\u001e\u0012\u0004\u0012\u0002H\u0001\u0012\u0004\u0012\u0002H\u00020\bj\u000e\u0012\u0004\u0012\u0002H\u0001\u0012\u0004\u0012\u0002H\u0002`\t\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006,"}, d2 = {"read", "T", "R", "", "Lorg/json/JSONObject;", "key", "", "converter", "Lkotlin/Function1;", "Lcom/yandex/div/internal/parser/Converter;", "validator", "Lcom/yandex/div/internal/parser/ValueValidator;", "logger", "Lcom/yandex/div/json/ParsingErrorLogger;", cc.o, "Lcom/yandex/div/json/ParsingEnvironment;", "(Lorg/json/JSONObject;Ljava/lang/String;Lkotlin/jvm/functions/Function1;Lcom/yandex/div/internal/parser/ValueValidator;Lcom/yandex/div/json/ParsingErrorLogger;Lcom/yandex/div/json/ParsingEnvironment;)Ljava/lang/Object;", "Lcom/yandex/div/json/JSONSerializable;", "creator", "Lkotlin/Function2;", "Lkotlin/ParameterName;", "name", "value", "Lcom/yandex/div/internal/parser/Creator;", "(Lorg/json/JSONObject;Ljava/lang/String;Lkotlin/jvm/functions/Function2;Lcom/yandex/div/json/ParsingErrorLogger;Lcom/yandex/div/json/ParsingEnvironment;)Lcom/yandex/div/json/JSONSerializable;", "(Lorg/json/JSONObject;Ljava/lang/String;Lcom/yandex/div/internal/parser/ValueValidator;Lcom/yandex/div/json/ParsingErrorLogger;Lcom/yandex/div/json/ParsingEnvironment;)Ljava/lang/Object;", "readList", "", "Lcom/yandex/div/internal/parser/ListValidator;", "itemValidator", "readSerializableList", "readOptional", "readOptionalList", "readOptionalSerializableList", "readStrictList", "readStrictSerializableList", "write", "", "(Lorg/json/JSONObject;Ljava/lang/String;Lcom/yandex/div/json/JSONSerializable;)V", "(Lorg/json/JSONObject;Ljava/lang/String;Ljava/lang/Object;Lkotlin/jvm/functions/Function1;)V", "writeExpression", "Lcom/yandex/div/json/expressions/Expression;", "writeExpressionList", "Lcom/yandex/div/json/expressions/ExpressionList;", "div-data_release"}, k = 2, mv = {1, 5, 1}, xi = 48)
public final class JsonParserKt {
    public static /* synthetic */ Object read$default(JSONObject jSONObject, String str, ValueValidator valueValidator, ParsingErrorLogger parsingErrorLogger, ParsingEnvironment parsingEnvironment, int i, Object obj) {
        if ((i & 2) != 0) {
            valueValidator = JsonParser.alwaysValid();
            Intrinsics.checkNotNullExpressionValue(valueValidator, "alwaysValid()");
        }
        return read(jSONObject, str, valueValidator, parsingErrorLogger, parsingEnvironment);
    }

    public static final <T> T read(JSONObject jSONObject, String key, ValueValidator<T> validator, ParsingErrorLogger logger, ParsingEnvironment env) {
        Intrinsics.checkNotNullParameter(jSONObject, "<this>");
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(validator, "validator");
        Intrinsics.checkNotNullParameter(logger, "logger");
        Intrinsics.checkNotNullParameter(env, "env");
        T t = (T) JsonParserInternalsKt.optSafe(jSONObject, key);
        if (t == null) {
            throw ParsingExceptionKt.missingValue(jSONObject, key);
        }
        if (t == null) {
            throw ParsingExceptionKt.typeMismatch(jSONObject, key, t);
        }
        if (validator.isValid(t)) {
            return t;
        }
        throw ParsingExceptionKt.invalidValue(jSONObject, key, t);
    }

    public static /* synthetic */ Object read$default(JSONObject jSONObject, String key, Function1 converter, ValueValidator validator, ParsingErrorLogger logger, ParsingEnvironment env, int i, Object obj) {
        Object objInvoke;
        if ((i & 4) != 0) {
            validator = JsonParser.alwaysValid();
            Intrinsics.checkNotNullExpressionValue(validator, "alwaysValid()");
        }
        Intrinsics.checkNotNullParameter(jSONObject, "<this>");
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(converter, "converter");
        Intrinsics.checkNotNullParameter(validator, "validator");
        Intrinsics.checkNotNullParameter(logger, "logger");
        Intrinsics.checkNotNullParameter(env, "env");
        Object objOptSafe = JsonParserInternalsKt.optSafe(jSONObject, key);
        if (objOptSafe == null) {
            throw ParsingExceptionKt.missingValue(jSONObject, key);
        }
        Intrinsics.reifiedOperationMarker(2, "R");
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
            return objInvoke;
        }
        throw ParsingExceptionKt.invalidValue(jSONObject, key, objInvoke);
    }

    public static final /* synthetic */ <R, T> T read(JSONObject jSONObject, String key, Function1<? super R, ? extends T> converter, ValueValidator<T> validator, ParsingErrorLogger logger, ParsingEnvironment env) {
        T tInvoke;
        Intrinsics.checkNotNullParameter(jSONObject, "<this>");
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(converter, "converter");
        Intrinsics.checkNotNullParameter(validator, "validator");
        Intrinsics.checkNotNullParameter(logger, "logger");
        Intrinsics.checkNotNullParameter(env, "env");
        Object objOptSafe = JsonParserInternalsKt.optSafe(jSONObject, key);
        if (objOptSafe == null) {
            throw ParsingExceptionKt.missingValue(jSONObject, key);
        }
        Intrinsics.reifiedOperationMarker(2, "R");
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
            return tInvoke;
        }
        throw ParsingExceptionKt.invalidValue(jSONObject, key, tInvoke);
    }

    public static final String read(JSONObject jSONObject, String key, ParsingErrorLogger logger) {
        Intrinsics.checkNotNullParameter(jSONObject, "<this>");
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(logger, "logger");
        String strOptString = jSONObject.optString(key);
        if (strOptString != null) {
            return strOptString;
        }
        throw ParsingExceptionKt.missingValue(jSONObject, key);
    }

    public static final <T extends JSONSerializable> T read(JSONObject jSONObject, String key, Function2<? super ParsingEnvironment, ? super JSONObject, ? extends T> creator, ParsingErrorLogger logger, ParsingEnvironment env) {
        Intrinsics.checkNotNullParameter(jSONObject, "<this>");
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(creator, "creator");
        Intrinsics.checkNotNullParameter(logger, "logger");
        Intrinsics.checkNotNullParameter(env, "env");
        JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject(key);
        if (jSONObjectOptJSONObject == null) {
            throw ParsingExceptionKt.missingValue(jSONObject, key);
        }
        try {
            return creator.invoke(env, jSONObjectOptJSONObject);
        } catch (ParsingException e) {
            throw ParsingExceptionKt.dependencyFailed(jSONObject, key, e);
        }
    }

    public static /* synthetic */ Object readOptional$default(JSONObject jSONObject, String str, ValueValidator valueValidator, ParsingErrorLogger parsingErrorLogger, ParsingEnvironment parsingEnvironment, int i, Object obj) {
        if ((i & 2) != 0) {
            valueValidator = JsonParser.alwaysValid();
            Intrinsics.checkNotNullExpressionValue(valueValidator, "alwaysValid()");
        }
        return readOptional(jSONObject, str, valueValidator, parsingErrorLogger, parsingEnvironment);
    }

    public static final <T> T readOptional(JSONObject jSONObject, String key, ValueValidator<T> validator, ParsingErrorLogger logger, ParsingEnvironment env) {
        Intrinsics.checkNotNullParameter(jSONObject, "<this>");
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(validator, "validator");
        Intrinsics.checkNotNullParameter(logger, "logger");
        Intrinsics.checkNotNullParameter(env, "env");
        T t = (T) JsonParserInternalsKt.optSafe(jSONObject, key);
        if (t == null) {
            return null;
        }
        if (t == null) {
            logger.logError(ParsingExceptionKt.typeMismatch(jSONObject, key, t));
            return null;
        }
        if (validator.isValid(t)) {
            return t;
        }
        logger.logError(ParsingExceptionKt.invalidValue(jSONObject, key, t));
        return null;
    }

    public static /* synthetic */ Object readOptional$default(JSONObject jSONObject, String str, Function1 function1, ValueValidator valueValidator, ParsingErrorLogger parsingErrorLogger, ParsingEnvironment parsingEnvironment, int i, Object obj) {
        if ((i & 4) != 0) {
            valueValidator = JsonParser.alwaysValid();
            Intrinsics.checkNotNullExpressionValue(valueValidator, "alwaysValid()");
        }
        return readOptional(jSONObject, str, function1, valueValidator, parsingErrorLogger, parsingEnvironment);
    }

    public static final <R, T> T readOptional(JSONObject jSONObject, String key, Function1<? super R, ? extends T> converter, ValueValidator<T> validator, ParsingErrorLogger logger, ParsingEnvironment env) {
        T tInvoke;
        Intrinsics.checkNotNullParameter(jSONObject, "<this>");
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(converter, "converter");
        Intrinsics.checkNotNullParameter(validator, "validator");
        Intrinsics.checkNotNullParameter(logger, "logger");
        Intrinsics.checkNotNullParameter(env, "env");
        ArtificialStackFrames artificialStackFrames = (Object) JsonParserInternalsKt.optSafe(jSONObject, key);
        if (artificialStackFrames == null) {
            return null;
        }
        if (artificialStackFrames == null) {
            logger.logError(ParsingExceptionKt.typeMismatch(jSONObject, key, artificialStackFrames));
            return null;
        }
        try {
            tInvoke = converter.invoke(artificialStackFrames);
        } catch (Exception unused) {
            tInvoke = null;
        }
        if (tInvoke == null) {
            logger.logError(ParsingExceptionKt.invalidValue(jSONObject, key, artificialStackFrames));
            return null;
        }
        if (validator.isValid(tInvoke)) {
            return tInvoke;
        }
        logger.logError(ParsingExceptionKt.invalidValue(jSONObject, key, tInvoke));
        return null;
    }

    public static final <T extends JSONSerializable> T readOptional(JSONObject jSONObject, String key, Function2<? super ParsingEnvironment, ? super JSONObject, ? extends T> creator, ParsingErrorLogger logger, ParsingEnvironment env) {
        Intrinsics.checkNotNullParameter(jSONObject, "<this>");
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(creator, "creator");
        Intrinsics.checkNotNullParameter(logger, "logger");
        Intrinsics.checkNotNullParameter(env, "env");
        JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject(key);
        if (jSONObjectOptJSONObject == null) {
            return null;
        }
        return (T) JsonParserInternalsKt.tryCreate(creator, env, jSONObjectOptJSONObject, logger);
    }

    public static /* synthetic */ List readList$default(JSONObject jSONObject, String str, ListValidator listValidator, ValueValidator valueValidator, ParsingErrorLogger parsingErrorLogger, ParsingEnvironment parsingEnvironment, int i, Object obj) {
        if ((i & 2) != 0) {
            listValidator = JsonParser.alwaysValidList();
            Intrinsics.checkNotNullExpressionValue(listValidator, "alwaysValidList()");
        }
        ListValidator listValidator2 = listValidator;
        if ((i & 4) != 0) {
            valueValidator = JsonParser.alwaysValid();
            Intrinsics.checkNotNullExpressionValue(valueValidator, "alwaysValid()");
        }
        return readList(jSONObject, str, listValidator2, valueValidator, parsingErrorLogger, parsingEnvironment);
    }

    public static final <T> List<T> readList(JSONObject jSONObject, final String key, ListValidator<T> validator, final ValueValidator<T> itemValidator, final ParsingErrorLogger logger, ParsingEnvironment env) {
        Intrinsics.checkNotNullParameter(jSONObject, "<this>");
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(validator, "validator");
        Intrinsics.checkNotNullParameter(itemValidator, "itemValidator");
        Intrinsics.checkNotNullParameter(logger, "logger");
        Intrinsics.checkNotNullParameter(env, "env");
        return JsonParserInternalsKt.getList(jSONObject, key, validator, logger, new Function2<JSONArray, Integer, T>() { // from class: com.yandex.div.internal.parser.JsonParserKt.readList.1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Object invoke(JSONArray jSONArray, Integer num) {
                return invoke(jSONArray, num.intValue());
            }

            public final T invoke(JSONArray jsonArray, int i) {
                Intrinsics.checkNotNullParameter(jsonArray, "jsonArray");
                Object objOptSafe = JsonParserInternalsKt.optSafe(jsonArray, i);
                T t = null;
                if (objOptSafe == null) {
                    objOptSafe = null;
                }
                if (objOptSafe == null) {
                    return null;
                }
                if (itemValidator.isValid((T) objOptSafe)) {
                    t = (T) objOptSafe;
                }
                ParsingErrorLogger parsingErrorLogger = logger;
                String str = key;
                if (t == null) {
                    parsingErrorLogger.logError(ParsingExceptionKt.invalidValue(jsonArray, str, i, objOptSafe));
                }
                return t;
            }
        });
    }

    public static /* synthetic */ List readList$default(JSONObject jSONObject, String str, Function1 function1, ListValidator listValidator, ValueValidator valueValidator, ParsingErrorLogger parsingErrorLogger, ParsingEnvironment parsingEnvironment, int i, Object obj) {
        if ((i & 4) != 0) {
            listValidator = JsonParser.alwaysValidList();
            Intrinsics.checkNotNullExpressionValue(listValidator, "alwaysValidList()");
        }
        ListValidator listValidator2 = listValidator;
        if ((i & 8) != 0) {
            valueValidator = JsonParser.alwaysValid();
            Intrinsics.checkNotNullExpressionValue(valueValidator, "alwaysValid()");
        }
        return readList(jSONObject, str, function1, listValidator2, valueValidator, parsingErrorLogger, parsingEnvironment);
    }

    public static final <R, T> List<T> readList(final JSONObject jSONObject, final String key, final Function1<? super R, ? extends T> converter, ListValidator<T> validator, final ValueValidator<T> itemValidator, final ParsingErrorLogger logger, ParsingEnvironment env) {
        Intrinsics.checkNotNullParameter(jSONObject, "<this>");
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(converter, "converter");
        Intrinsics.checkNotNullParameter(validator, "validator");
        Intrinsics.checkNotNullParameter(itemValidator, "itemValidator");
        Intrinsics.checkNotNullParameter(logger, "logger");
        Intrinsics.checkNotNullParameter(env, "env");
        return JsonParserInternalsKt.getList(jSONObject, key, validator, logger, new Function2<JSONArray, Integer, T>() { // from class: com.yandex.div.internal.parser.JsonParserKt.readList.2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Object invoke(JSONArray jSONArray, Integer num) {
                return invoke(jSONArray, num.intValue());
            }

            /* JADX WARN: Type inference incomplete: some casts might be missing */
            public final T invoke(JSONArray jsonArray, int i) {
                T tInvoke;
                Intrinsics.checkNotNullParameter(jsonArray, "jsonArray");
                Object objOptSafe = JsonParserInternalsKt.optSafe(jsonArray, i);
                if (objOptSafe == null) {
                    objOptSafe = null;
                }
                if (objOptSafe == null) {
                    return null;
                }
                try {
                    tInvoke = converter.invoke((R) objOptSafe);
                } catch (Exception unused) {
                    tInvoke = null;
                }
                ParsingErrorLogger parsingErrorLogger = logger;
                JSONObject jSONObject2 = jSONObject;
                String str = key;
                if (tInvoke == null) {
                    parsingErrorLogger.logError(ParsingExceptionKt.invalidValue(jSONObject2, str, objOptSafe));
                }
                if (tInvoke == null) {
                    return null;
                }
                T t = itemValidator.isValid(tInvoke) ? tInvoke : null;
                ParsingErrorLogger parsingErrorLogger2 = logger;
                String str2 = key;
                if (t == null) {
                    parsingErrorLogger2.logError(ParsingExceptionKt.invalidValue(jsonArray, str2, i, tInvoke));
                }
                return t;
            }
        });
    }

    public static final <T extends JSONSerializable> List<T> readSerializableList(JSONObject jSONObject, String key, final Function2<? super ParsingEnvironment, ? super JSONObject, ? extends T> creator, ListValidator<T> validator, final ParsingErrorLogger logger, final ParsingEnvironment env) {
        Intrinsics.checkNotNullParameter(jSONObject, "<this>");
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(creator, "creator");
        Intrinsics.checkNotNullParameter(validator, "validator");
        Intrinsics.checkNotNullParameter(logger, "logger");
        Intrinsics.checkNotNullParameter(env, "env");
        return JsonParserInternalsKt.getList(jSONObject, key, validator, logger, new Function2<JSONArray, Integer, T>() { // from class: com.yandex.div.internal.parser.JsonParserKt.readList.3
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Object invoke(JSONArray jSONArray, Integer num) {
                return invoke(jSONArray, num.intValue());
            }

            /* JADX WARN: Incorrect return type in method signature: (Lorg/json/JSONArray;I)TT; */
            public final JSONSerializable invoke(JSONArray jsonArray, int i) {
                JSONSerializable jSONSerializableTryCreate;
                Intrinsics.checkNotNullParameter(jsonArray, "jsonArray");
                JSONObject jSONObjectOptJSONObject = jsonArray.optJSONObject(i);
                if (jSONObjectOptJSONObject == null || (jSONSerializableTryCreate = JsonParserInternalsKt.tryCreate(creator, env, jSONObjectOptJSONObject, logger)) == null) {
                    return null;
                }
                return jSONSerializableTryCreate;
            }
        });
    }

    public static /* synthetic */ List readStrictList$default(JSONObject jSONObject, String str, ListValidator listValidator, ValueValidator valueValidator, ParsingErrorLogger parsingErrorLogger, int i, Object obj) {
        if ((i & 2) != 0) {
            listValidator = JsonParser.alwaysValidList();
            Intrinsics.checkNotNullExpressionValue(listValidator, "alwaysValidList()");
        }
        if ((i & 4) != 0) {
            valueValidator = JsonParser.alwaysValid();
            Intrinsics.checkNotNullExpressionValue(valueValidator, "alwaysValid()");
        }
        return readStrictList(jSONObject, str, listValidator, valueValidator, parsingErrorLogger);
    }

    public static final <T> List<T> readStrictList(JSONObject jSONObject, final String key, ListValidator<T> validator, final ValueValidator<T> itemValidator, ParsingErrorLogger logger) {
        Intrinsics.checkNotNullParameter(jSONObject, "<this>");
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(validator, "validator");
        Intrinsics.checkNotNullParameter(itemValidator, "itemValidator");
        Intrinsics.checkNotNullParameter(logger, "logger");
        return JsonParserInternalsKt.getList(jSONObject, key, validator, logger, new Function2<JSONArray, Integer, T>() { // from class: com.yandex.div.internal.parser.JsonParserKt.readStrictList.1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Object invoke(JSONArray jSONArray, Integer num) {
                return invoke(jSONArray, num.intValue());
            }

            public final T invoke(JSONArray jsonArray, int i) {
                Intrinsics.checkNotNullParameter(jsonArray, "jsonArray");
                Object objOptSafe = JsonParserInternalsKt.optSafe(jsonArray, i);
                if (objOptSafe == null) {
                    throw ParsingExceptionKt.missingValue(jsonArray, key, i);
                }
                if (objOptSafe == null) {
                    throw ParsingExceptionKt.typeMismatch(jsonArray, key, i, objOptSafe);
                }
                T t = itemValidator.isValid((T) objOptSafe) ? (T) objOptSafe : null;
                if (t != null) {
                    return t;
                }
                throw ParsingExceptionKt.invalidValue(jsonArray, key, i, objOptSafe);
            }
        });
    }

    public static /* synthetic */ List readStrictList$default(JSONObject jSONObject, String str, Function1 function1, ListValidator listValidator, ValueValidator valueValidator, ParsingErrorLogger parsingErrorLogger, int i, Object obj) {
        if ((i & 4) != 0) {
            listValidator = JsonParser.alwaysValidList();
            Intrinsics.checkNotNullExpressionValue(listValidator, "alwaysValidList()");
        }
        ListValidator listValidator2 = listValidator;
        if ((i & 8) != 0) {
            valueValidator = JsonParser.alwaysValid();
            Intrinsics.checkNotNullExpressionValue(valueValidator, "alwaysValid()");
        }
        return readStrictList(jSONObject, str, function1, listValidator2, valueValidator, parsingErrorLogger);
    }

    public static final <R, T> List<T> readStrictList(JSONObject jSONObject, final String key, final Function1<? super R, ? extends T> converter, ListValidator<T> validator, final ValueValidator<T> itemValidator, ParsingErrorLogger logger) {
        Intrinsics.checkNotNullParameter(jSONObject, "<this>");
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(converter, "converter");
        Intrinsics.checkNotNullParameter(validator, "validator");
        Intrinsics.checkNotNullParameter(itemValidator, "itemValidator");
        Intrinsics.checkNotNullParameter(logger, "logger");
        return JsonParserInternalsKt.getList(jSONObject, key, validator, logger, new Function2<JSONArray, Integer, T>() { // from class: com.yandex.div.internal.parser.JsonParserKt.readStrictList.2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Object invoke(JSONArray jSONArray, Integer num) {
                return invoke(jSONArray, num.intValue());
            }

            /* JADX WARN: Type inference incomplete: some casts might be missing */
            public final T invoke(JSONArray jsonArray, int i) {
                T tInvoke;
                Intrinsics.checkNotNullParameter(jsonArray, "jsonArray");
                Object objOptSafe = JsonParserInternalsKt.optSafe(jsonArray, i);
                if (objOptSafe == null) {
                    throw ParsingExceptionKt.missingValue(jsonArray, key, i);
                }
                if (objOptSafe == null) {
                    throw ParsingExceptionKt.typeMismatch(jsonArray, key, i, objOptSafe);
                }
                try {
                    tInvoke = converter.invoke((R) objOptSafe);
                } catch (Exception unused) {
                    tInvoke = null;
                }
                if (tInvoke == null) {
                    throw ParsingExceptionKt.invalidValue(jsonArray, key, i, objOptSafe);
                }
                T t = itemValidator.isValid(tInvoke) ? tInvoke : null;
                if (t != null) {
                    return t;
                }
                throw ParsingExceptionKt.invalidValue(jsonArray, key, i, tInvoke);
            }
        });
    }

    public static final <T extends JSONSerializable> List<T> readStrictSerializableList(JSONObject jSONObject, final String key, final Function2<? super ParsingEnvironment, ? super JSONObject, ? extends T> creator, ListValidator<T> validator, ParsingErrorLogger logger, final ParsingEnvironment env) {
        Intrinsics.checkNotNullParameter(jSONObject, "<this>");
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(creator, "creator");
        Intrinsics.checkNotNullParameter(validator, "validator");
        Intrinsics.checkNotNullParameter(logger, "logger");
        Intrinsics.checkNotNullParameter(env, "env");
        return JsonParserInternalsKt.getList(jSONObject, key, validator, logger, new Function2<JSONArray, Integer, T>() { // from class: com.yandex.div.internal.parser.JsonParserKt.readStrictList.3
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Object invoke(JSONArray jSONArray, Integer num) {
                return invoke(jSONArray, num.intValue());
            }

            /* JADX WARN: Incorrect return type in method signature: (Lorg/json/JSONArray;I)TT; */
            public final JSONSerializable invoke(JSONArray jsonArray, int i) {
                Intrinsics.checkNotNullParameter(jsonArray, "jsonArray");
                JSONObject jSONObjectOptJSONObject = jsonArray.optJSONObject(i);
                if (jSONObjectOptJSONObject == null) {
                    throw ParsingExceptionKt.missingValue(jsonArray, key, i);
                }
                try {
                    return (JSONSerializable) creator.invoke(env, jSONObjectOptJSONObject);
                } catch (ParsingException e) {
                    throw ParsingExceptionKt.dependencyFailed(jsonArray, key, i, e);
                }
            }
        });
    }

    public static final <T> List<T> readOptionalList(JSONObject jSONObject, final String key, ListValidator<T> validator, final ValueValidator<T> itemValidator, final ParsingErrorLogger logger) {
        Intrinsics.checkNotNullParameter(jSONObject, "<this>");
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(validator, "validator");
        Intrinsics.checkNotNullParameter(itemValidator, "itemValidator");
        Intrinsics.checkNotNullParameter(logger, "logger");
        return JsonParserInternalsKt.optList(jSONObject, key, validator, logger, new Function2<JSONArray, Integer, T>() { // from class: com.yandex.div.internal.parser.JsonParserKt.readOptionalList.1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Object invoke(JSONArray jSONArray, Integer num) {
                return invoke(jSONArray, num.intValue());
            }

            public final T invoke(JSONArray jsonArray, int i) {
                Intrinsics.checkNotNullParameter(jsonArray, "jsonArray");
                Object objOptSafe = JsonParserInternalsKt.optSafe(jsonArray, i);
                T t = null;
                if (objOptSafe == null) {
                    objOptSafe = null;
                }
                if (objOptSafe == null) {
                    return null;
                }
                if (itemValidator.isValid((T) objOptSafe)) {
                    t = (T) objOptSafe;
                }
                ParsingErrorLogger parsingErrorLogger = logger;
                String str = key;
                if (t == null) {
                    parsingErrorLogger.logError(ParsingExceptionKt.invalidValue(jsonArray, str, i, objOptSafe));
                }
                return t;
            }
        });
    }

    public static final <R, T> List<T> readOptionalList(final JSONObject jSONObject, final String key, final Function1<? super R, ? extends T> converter, ListValidator<T> validator, final ValueValidator<T> itemValidator, final ParsingErrorLogger logger) {
        Intrinsics.checkNotNullParameter(jSONObject, "<this>");
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(converter, "converter");
        Intrinsics.checkNotNullParameter(validator, "validator");
        Intrinsics.checkNotNullParameter(itemValidator, "itemValidator");
        Intrinsics.checkNotNullParameter(logger, "logger");
        return JsonParserInternalsKt.optList(jSONObject, key, validator, logger, new Function2<JSONArray, Integer, T>() { // from class: com.yandex.div.internal.parser.JsonParserKt.readOptionalList.2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Object invoke(JSONArray jSONArray, Integer num) {
                return invoke(jSONArray, num.intValue());
            }

            /* JADX WARN: Type inference incomplete: some casts might be missing */
            public final T invoke(JSONArray jsonArray, int i) {
                T tInvoke;
                Intrinsics.checkNotNullParameter(jsonArray, "jsonArray");
                Object objOptSafe = JsonParserInternalsKt.optSafe(jsonArray, i);
                if (objOptSafe == null) {
                    objOptSafe = null;
                }
                if (objOptSafe == null) {
                    return null;
                }
                try {
                    tInvoke = converter.invoke((R) objOptSafe);
                } catch (Exception unused) {
                    tInvoke = null;
                }
                ParsingErrorLogger parsingErrorLogger = logger;
                JSONObject jSONObject2 = jSONObject;
                String str = key;
                if (tInvoke == null) {
                    parsingErrorLogger.logError(ParsingExceptionKt.invalidValue(jSONObject2, str, objOptSafe));
                }
                if (tInvoke == null) {
                    return null;
                }
                T t = itemValidator.isValid(tInvoke) ? tInvoke : null;
                ParsingErrorLogger parsingErrorLogger2 = logger;
                String str2 = key;
                if (t == null) {
                    parsingErrorLogger2.logError(ParsingExceptionKt.invalidValue(jsonArray, str2, i, tInvoke));
                }
                return t;
            }
        });
    }

    public static /* synthetic */ List readOptionalSerializableList$default(JSONObject jSONObject, String str, Function2 function2, ListValidator listValidator, ValueValidator valueValidator, ParsingErrorLogger parsingErrorLogger, ParsingEnvironment parsingEnvironment, int i, Object obj) {
        if ((i & 8) != 0) {
            valueValidator = JsonParser.alwaysValid();
            Intrinsics.checkNotNullExpressionValue(valueValidator, "alwaysValid()");
        }
        return readOptionalSerializableList(jSONObject, str, function2, listValidator, valueValidator, parsingErrorLogger, parsingEnvironment);
    }

    public static final <T extends JSONSerializable> List<T> readOptionalSerializableList(JSONObject jSONObject, final String key, final Function2<? super ParsingEnvironment, ? super JSONObject, ? extends T> creator, ListValidator<T> validator, final ValueValidator<T> itemValidator, final ParsingErrorLogger logger, final ParsingEnvironment env) {
        Intrinsics.checkNotNullParameter(jSONObject, "<this>");
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(creator, "creator");
        Intrinsics.checkNotNullParameter(validator, "validator");
        Intrinsics.checkNotNullParameter(itemValidator, "itemValidator");
        Intrinsics.checkNotNullParameter(logger, "logger");
        Intrinsics.checkNotNullParameter(env, "env");
        return JsonParserInternalsKt.optList(jSONObject, key, validator, logger, new Function2<JSONArray, Integer, T>() { // from class: com.yandex.div.internal.parser.JsonParserKt.readOptionalList.3
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Object invoke(JSONArray jSONArray, Integer num) {
                return invoke(jSONArray, num.intValue());
            }

            /* JADX WARN: Incorrect return type in method signature: (Lorg/json/JSONArray;I)TT; */
            public final JSONSerializable invoke(JSONArray jsonArray, int i) {
                JSONSerializable jSONSerializableTryCreate;
                Intrinsics.checkNotNullParameter(jsonArray, "jsonArray");
                JSONObject jSONObjectOptJSONObject = jsonArray.optJSONObject(i);
                if (jSONObjectOptJSONObject == null || (jSONSerializableTryCreate = JsonParserInternalsKt.tryCreate(creator, env, jSONObjectOptJSONObject, logger)) == null) {
                    return null;
                }
                JSONSerializable jSONSerializable = itemValidator.isValid(jSONSerializableTryCreate) ? jSONSerializableTryCreate : null;
                ParsingErrorLogger parsingErrorLogger = logger;
                String str = key;
                if (jSONSerializable == null) {
                    parsingErrorLogger.logError(ParsingExceptionKt.invalidValue(jsonArray, str, i, jSONSerializableTryCreate));
                }
                return jSONSerializable;
            }
        });
    }

    public static /* synthetic */ void write$default(JSONObject jSONObject, String str, Object obj, Function1 function1, int i, Object obj2) throws JSONException {
        if ((i & 4) != 0) {
            function1 = new Function1<T, T>() { // from class: com.yandex.div.internal.parser.JsonParserKt.write.1
                @Override // kotlin.jvm.functions.Function1
                public final T invoke(T it) {
                    Intrinsics.checkNotNullParameter(it, "it");
                    return it;
                }
            };
        }
        write(jSONObject, str, obj, (Function1<? super Object, ? extends Object>) function1);
    }

    public static final <T> void write(JSONObject jSONObject, String key, T t, Function1<? super T, ? extends Object> converter) throws JSONException {
        Intrinsics.checkNotNullParameter(jSONObject, "<this>");
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(converter, "converter");
        if (t != null) {
            jSONObject.put(key, converter.invoke(t));
        }
    }

    public static final /* synthetic */ <T extends JSONSerializable> void write(JSONObject jSONObject, String key, T t) throws JSONException {
        Intrinsics.checkNotNullParameter(jSONObject, "<this>");
        Intrinsics.checkNotNullParameter(key, "key");
        if (t != null) {
            jSONObject.put(key, t.writeToJSON());
        }
    }

    public static final <T> void writeExpression(JSONObject jSONObject, String key, Expression<T> expression) throws JSONException {
        Intrinsics.checkNotNullParameter(jSONObject, "<this>");
        Intrinsics.checkNotNullParameter(key, "key");
        writeExpression(jSONObject, key, expression, new Function1<T, T>() { // from class: com.yandex.div.internal.parser.JsonParserKt.writeExpression.1
            @Override // kotlin.jvm.functions.Function1
            public final T invoke(T it) {
                Intrinsics.checkNotNullParameter(it, "it");
                return it;
            }
        });
    }

    public static final <T, R> void writeExpression(JSONObject jSONObject, String key, Expression<T> expression, Function1<? super T, ? extends R> converter) throws JSONException {
        Intrinsics.checkNotNullParameter(jSONObject, "<this>");
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(converter, "converter");
        if (expression == null) {
            return;
        }
        Object rawValue = expression.getRawValue();
        if (!Expression.INSTANCE.mayBeExpression(rawValue)) {
            Intrinsics.checkNotNull(rawValue, "null cannot be cast to non-null type T of com.yandex.div.internal.parser.JsonParserKt.writeExpression");
            jSONObject.put(key, converter.invoke(rawValue));
        } else {
            jSONObject.put(key, rawValue);
        }
    }

    public static final <T> void writeExpressionList(JSONObject jSONObject, String key, ExpressionList<T> expressionList) throws JSONException {
        Intrinsics.checkNotNullParameter(jSONObject, "<this>");
        Intrinsics.checkNotNullParameter(key, "key");
        writeExpressionList(jSONObject, key, expressionList, new Function1<T, T>() { // from class: com.yandex.div.internal.parser.JsonParserKt.writeExpressionList.1
            @Override // kotlin.jvm.functions.Function1
            public final T invoke(T it) {
                Intrinsics.checkNotNullParameter(it, "it");
                return it;
            }
        });
    }

    public static final <T, R> void writeExpressionList(JSONObject jSONObject, String key, ExpressionList<T> expressionList, Function1<? super T, ? extends R> converter) throws JSONException {
        Object rawValue;
        Intrinsics.checkNotNullParameter(jSONObject, "<this>");
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(converter, "converter");
        if (expressionList == null) {
            return;
        }
        if (expressionList instanceof MutableExpressionList) {
            List<Expression<T>> expressionsInternal = ((MutableExpressionList) expressionList).getExpressionsInternal();
            if (expressionsInternal.isEmpty()) {
                return;
            }
            List<Expression<T>> list = expressionsInternal;
            ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
            Iterator<T> it = list.iterator();
            while (it.hasNext()) {
                Expression expression = (Expression) it.next();
                if (expression instanceof Expression.ConstantExpression) {
                    rawValue = converter.invoke((Object) expression.evaluate(ExpressionResolver.EMPTY));
                } else {
                    rawValue = expression.getRawValue();
                }
                arrayList.add(rawValue);
            }
            jSONObject.put(key, new JSONArray((Collection) arrayList));
            return;
        }
        if (expressionList instanceof ConstantExpressionList) {
            List<T> listEvaluate = ((ConstantExpressionList) expressionList).evaluate(ExpressionResolver.EMPTY);
            ArrayList arrayList2 = new ArrayList(CollectionsKt.collectionSizeOrDefault(listEvaluate, 10));
            Iterator<T> it2 = listEvaluate.iterator();
            while (it2.hasNext()) {
                arrayList2.add(converter.invoke(it2.next()));
            }
            jSONObject.put(key, new JSONArray((Collection) arrayList2));
        }
    }

    public static final <T> void write(JSONObject jSONObject, String key, List<? extends T> list) throws JSONException {
        Intrinsics.checkNotNullParameter(jSONObject, "<this>");
        Intrinsics.checkNotNullParameter(key, "key");
        if (list != null) {
            List<? extends T> list2 = list;
            if (list2.isEmpty()) {
                return;
            }
            if (CollectionsKt.first((List) list) instanceof JSONSerializable) {
                jSONObject.put(key, JsonParserInternalsKt.toJsonArray(list));
            } else {
                jSONObject.put(key, new JSONArray((Collection) list2));
            }
        }
    }

    public static final <T> void write(JSONObject jSONObject, String key, List<? extends T> list, Function1<? super T, ? extends Object> converter) throws JSONException {
        Intrinsics.checkNotNullParameter(jSONObject, "<this>");
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(converter, "converter");
        if (list == null || list.isEmpty()) {
            return;
        }
        if (CollectionsKt.first((List) list) instanceof JSONSerializable) {
            jSONObject.put(key, JsonParserInternalsKt.toJsonArray(list));
            return;
        }
        List<? extends T> list2 = list;
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list2, 10));
        Iterator<T> it = list2.iterator();
        while (it.hasNext()) {
            arrayList.add(converter.invoke(it.next()));
        }
        jSONObject.put(key, new JSONArray((Collection) arrayList));
    }
}
