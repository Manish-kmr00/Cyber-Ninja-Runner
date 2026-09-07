package com.yandex.div.serialization;

import androidx.exifinterface.media.ExifInterface;
import com.json.cc;
import com.yandex.div.core.annotations.ExperimentalApi;
import com.yandex.div.json.ParsingEnvironment;
import com.yandex.div.json.ParsingException;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: compiled from: Serializers.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000@\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0000\u001aE\u0010\u0000\u001a\u001e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u00020\u00030\u0001j\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u00020\u0003`\u0004\"\u0006\b\u0000\u0010\u0002\u0018\u0001*\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u0002H\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0081\b\u001aa\u0010\b\u001aB\u0012\u0013\u0012\u00110\n¢\u0006\f\b\u000b\u0012\b\b\f\u0012\u0004\b\b(\r\u0012\u0013\u0012\u0011H\u0002¢\u0006\f\b\u000b\u0012\b\b\f\u0012\u0004\b\b(\u000e\u0012\u0004\u0012\u00020\u00030\tj\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u00020\u0003`\u000f\"\u0006\b\u0000\u0010\u0002\u0018\u0001*\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u0002H\u00020\u0005H\u0080\b\u001a7\u0010\u0010\u001a\u0004\u0018\u00010\u0003\"\u0004\b\u0000\u0010\u0002*\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u0002H\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\b\u0010\u000e\u001a\u0004\u0018\u0001H\u0002H\u0007¢\u0006\u0002\u0010\u0011\u001a8\u0010\u0010\u001a\u0004\u0018\u00010\u0012\"\u0004\b\u0000\u0010\u0002*\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u0002H\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u000e\u0010\u0013\u001a\n\u0012\u0004\u0012\u0002H\u0002\u0018\u00010\u0014H\u0007¨\u0006\u0015"}, d2 = {"asConverter", "Lkotlin/Function1;", ExifInterface.GPS_MEASUREMENT_INTERRUPTED, "Lorg/json/JSONObject;", "Lcom/yandex/div/internal/parser/Converter;", "Lcom/yandex/div/serialization/Serializer;", "context", "Lcom/yandex/div/serialization/ParsingContext;", "asCreator", "Lkotlin/Function2;", "Lcom/yandex/div/json/ParsingEnvironment;", "Lkotlin/ParameterName;", "name", cc.o, "value", "Lcom/yandex/div/internal/parser/Creator;", "serialize", "(Lcom/yandex/div/serialization/Serializer;Lcom/yandex/div/serialization/ParsingContext;Ljava/lang/Object;)Lorg/json/JSONObject;", "Lorg/json/JSONArray;", "list", "", "div-data_release"}, k = 2, mv = {1, 5, 1}, xi = 48)
public final class SerializersKt {
    @ExperimentalApi
    public static final <V> JSONObject serialize(Serializer<JSONObject, V> serializer, ParsingContext context, V v) {
        Intrinsics.checkNotNullParameter(serializer, "<this>");
        Intrinsics.checkNotNullParameter(context, "context");
        if (v == null) {
            return null;
        }
        try {
            return serializer.serialize(context, v);
        } catch (ParsingException e) {
            context.getLogger().logError(e);
            return null;
        }
    }

    @ExperimentalApi
    public static final <V> JSONArray serialize(Serializer<JSONObject, V> serializer, ParsingContext context, List<? extends V> list) {
        Intrinsics.checkNotNullParameter(serializer, "<this>");
        Intrinsics.checkNotNullParameter(context, "context");
        if (list == null) {
            return null;
        }
        try {
            JSONArray jSONArray = new JSONArray();
            int size = list.size();
            for (int i = 0; i < size; i++) {
                jSONArray.put(serializer.serialize(context, list.get(i)));
            }
            return jSONArray;
        } catch (ParsingException e) {
            context.getLogger().logError(e);
            return null;
        }
    }

    @ExperimentalApi
    public static final /* synthetic */ <V> Function1<V, JSONObject> asConverter(final Serializer<JSONObject, V> serializer, final ParsingContext context) {
        Intrinsics.checkNotNullParameter(serializer, "<this>");
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.needClassReification();
        return new Function1<V, JSONObject>() { // from class: com.yandex.div.serialization.SerializersKt.asConverter.1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final JSONObject invoke(V v) {
                return serializer.serialize(context, v);
            }
        };
    }

    public static final /* synthetic */ <V> Function2<ParsingEnvironment, V, JSONObject> asCreator(final Serializer<JSONObject, V> serializer) {
        Intrinsics.checkNotNullParameter(serializer, "<this>");
        Intrinsics.needClassReification();
        return new Function2<ParsingEnvironment, V, JSONObject>() { // from class: com.yandex.div.serialization.SerializersKt.asCreator.1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public final JSONObject invoke(ParsingEnvironment env, V v) {
                Intrinsics.checkNotNullParameter(env, "env");
                return serializer.serialize(env, v);
            }
        };
    }
}
