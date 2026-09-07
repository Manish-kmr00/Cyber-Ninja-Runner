package com.yandex.div.internal.parser;

import java.util.List;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: classes12.dex */
public class JsonParsers {
    private static final ValueValidator<?> ALWAYS_VALID = new ValueValidator() { // from class: com.yandex.div.internal.parser.JsonParsers$$ExternalSyntheticLambda0
        @Override // com.yandex.div.internal.parser.ValueValidator
        public final boolean isValid(Object obj) {
            return JsonParsers.lambda$static$0(obj);
        }
    };
    private static final ValueValidator<String> ALWAYS_VALID_STRING = new ValueValidator() { // from class: com.yandex.div.internal.parser.JsonParsers$$ExternalSyntheticLambda1
        @Override // com.yandex.div.internal.parser.ValueValidator
        public final boolean isValid(Object obj) {
            return JsonParsers.lambda$static$1((String) obj);
        }
    };
    private static final ListValidator<?> ALWAYS_VALID_LIST = new ListValidator() { // from class: com.yandex.div.internal.parser.JsonParsers$$ExternalSyntheticLambda2
        @Override // com.yandex.div.internal.parser.ListValidator
        public final boolean isValid(List list) {
            return JsonParsers.lambda$static$2(list);
        }
    };
    private static final Function1<?, ?> AS_IS = new Function1() { // from class: com.yandex.div.internal.parser.JsonParsers$$ExternalSyntheticLambda3
        @Override // kotlin.jvm.functions.Function1
        public final Object invoke(Object obj) {
            return JsonParsers.lambda$static$3(obj);
        }
    };

    static /* synthetic */ boolean lambda$static$0(Object obj) {
        return true;
    }

    static /* synthetic */ boolean lambda$static$1(String str) {
        return true;
    }

    static /* synthetic */ boolean lambda$static$2(List list) {
        return true;
    }

    static /* synthetic */ Object lambda$static$3(Object obj) {
        return obj;
    }

    private JsonParsers() {
    }

    public static <T> ValueValidator<T> alwaysValid() {
        return (ValueValidator<T>) ALWAYS_VALID;
    }

    static ValueValidator<String> alwaysValidString() {
        return ALWAYS_VALID_STRING;
    }

    public static <T> ListValidator<T> alwaysValidList() {
        return (ListValidator<T>) ALWAYS_VALID_LIST;
    }

    public static <T> Function1<T, T> doNotConvert() {
        return (Function1<T, T>) AS_IS;
    }
}
