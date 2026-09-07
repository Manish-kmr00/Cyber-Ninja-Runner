package com.yandex.div.core.util;

import com.yandex.div.core.expression.local.LocalFunction;
import com.yandex.div.evaluable.EvaluableType;
import com.yandex.div.evaluable.FunctionArgument;
import com.yandex.div2.DivEvaluableType;
import com.yandex.div2.DivFunction;
import com.yandex.div2.DivFunctionArgument;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: FunctionMapper.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\u001a\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u001a\f\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u0002\u001a\u0018\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004*\b\u0012\u0004\u0012\u00020\u00060\u0004H\u0000¨\u0006\u0007"}, d2 = {"toEvaluableType", "Lcom/yandex/div/evaluable/EvaluableType;", "Lcom/yandex/div2/DivEvaluableType;", "toLocalFunctions", "", "Lcom/yandex/div/core/expression/local/LocalFunction;", "Lcom/yandex/div2/DivFunction;", "div_release"}, k = 2, mv = {1, 5, 1}, xi = 48)
public final class FunctionMapperKt {

    /* JADX INFO: compiled from: FunctionMapper.kt */
    @Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[DivEvaluableType.values().length];
            try {
                iArr[DivEvaluableType.STRING.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[DivEvaluableType.INTEGER.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[DivEvaluableType.NUMBER.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[DivEvaluableType.BOOLEAN.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                iArr[DivEvaluableType.DATETIME.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                iArr[DivEvaluableType.COLOR.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                iArr[DivEvaluableType.URL.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                iArr[DivEvaluableType.DICT.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                iArr[DivEvaluableType.ARRAY.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public static final List<LocalFunction> toLocalFunctions(List<DivFunction> list) {
        Intrinsics.checkNotNullParameter(list, "<this>");
        List<DivFunction> list2 = list;
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list2, 10));
        for (DivFunction divFunction : list2) {
            ArrayList arrayList2 = new ArrayList();
            ArrayList arrayList3 = new ArrayList();
            for (DivFunctionArgument divFunctionArgument : divFunction.arguments) {
                arrayList2.add(divFunctionArgument.name);
                arrayList3.add(new FunctionArgument(toEvaluableType(divFunctionArgument.type), false, 2, null));
            }
            arrayList.add(new LocalFunction(divFunction.name, arrayList3, toEvaluableType(divFunction.returnType), arrayList2, divFunction.body));
        }
        return arrayList;
    }

    private static final EvaluableType toEvaluableType(DivEvaluableType divEvaluableType) {
        switch (WhenMappings.$EnumSwitchMapping$0[divEvaluableType.ordinal()]) {
            case 1:
                return EvaluableType.STRING;
            case 2:
                return EvaluableType.INTEGER;
            case 3:
                return EvaluableType.NUMBER;
            case 4:
                return EvaluableType.BOOLEAN;
            case 5:
                return EvaluableType.DATETIME;
            case 6:
                return EvaluableType.COLOR;
            case 7:
                return EvaluableType.URL;
            case 8:
                return EvaluableType.DICT;
            case 9:
                return EvaluableType.ARRAY;
            default:
                throw new NoWhenBranchMatchedException();
        }
    }
}
