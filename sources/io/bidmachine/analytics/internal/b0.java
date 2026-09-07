package io.bidmachine.analytics.internal;

import com.explorestack.protobuf.ListValue;
import com.explorestack.protobuf.StringValue;
import com.explorestack.protobuf.Struct;
import com.explorestack.protobuf.Timestamp;
import com.explorestack.protobuf.Value;
import java.util.List;
import java.util.Map;
import kotlin.Result;
import kotlin.ResultKt;

/* JADX INFO: loaded from: classes11.dex */
public abstract class b0 {
    public static final Timestamp a(long j) {
        long j2 = 1000;
        return Timestamp.newBuilder().setSeconds(j / j2).setNanos((int) ((j % j2) * ((long) 1000000))).build();
    }

    public static final ListValue a(List list) {
        Value.Builder numberValue;
        ListValue.Builder builderNewBuilder = ListValue.newBuilder();
        for (Object obj : list) {
            try {
                Result.Companion companion = Result.INSTANCE;
                if (obj instanceof List) {
                    numberValue = Value.newBuilder().setListValue(a((List) obj));
                } else if (obj instanceof Map) {
                    numberValue = Value.newBuilder().setStructValue(a((Map) obj));
                } else if (obj instanceof Boolean) {
                    numberValue = Value.newBuilder().setBoolValue(((Boolean) obj).booleanValue());
                } else {
                    numberValue = obj instanceof Number ? Value.newBuilder().setNumberValue(((Number) obj).doubleValue()) : Value.newBuilder().setStringValue(String.valueOf(obj));
                }
                Result.m7904constructorimpl(builderNewBuilder.addValues(numberValue.build()));
            } catch (Throwable th) {
                Result.Companion companion2 = Result.INSTANCE;
                Result.m7904constructorimpl(ResultKt.createFailure(th));
            }
        }
        return builderNewBuilder.build();
    }

    public static final StringValue a(String str) {
        return StringValue.newBuilder().setValue(str).build();
    }

    public static final Struct a(Map map) {
        Value.Builder numberValue;
        Struct.Builder builderNewBuilder = Struct.newBuilder();
        for (Map.Entry entry : map.entrySet()) {
            Object key = entry.getKey();
            Object value = entry.getValue();
            try {
                Result.Companion companion = Result.INSTANCE;
                String strValueOf = String.valueOf(key);
                if (value instanceof List) {
                    numberValue = Value.newBuilder().setListValue(a((List) value));
                } else if (value instanceof Map) {
                    numberValue = Value.newBuilder().setStructValue(a((Map) value));
                } else if (value instanceof Boolean) {
                    numberValue = Value.newBuilder().setBoolValue(((Boolean) value).booleanValue());
                } else {
                    numberValue = value instanceof Number ? Value.newBuilder().setNumberValue(((Number) value).doubleValue()) : Value.newBuilder().setStringValue(String.valueOf(value));
                }
                Result.m7904constructorimpl(builderNewBuilder.putFields(strValueOf, numberValue.build()));
            } catch (Throwable th) {
                Result.Companion companion2 = Result.INSTANCE;
                Result.m7904constructorimpl(ResultKt.createFailure(th));
            }
        }
        return builderNewBuilder.build();
    }
}
