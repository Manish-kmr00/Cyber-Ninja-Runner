package com.yandex.div.core.expression.variables;

import com.yandex.div.data.DivParsingEnvironment;
import com.yandex.div.data.Variable;
import com.yandex.div.internal.parser.JsonParser;
import com.yandex.div.json.ParsingErrorLogger;
import com.yandex.div.json.ParsingException;
import com.yandex.div2.DivVariable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: DivVariablesParser.kt */
/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u001c\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t¨\u0006\n"}, d2 = {"Lcom/yandex/div/core/expression/variables/DivVariablesParser;", "", "()V", "parse", "", "Lcom/yandex/div/data/Variable;", "variablesArray", "Lorg/json/JSONArray;", "logger", "Lcom/yandex/div/json/ParsingErrorLogger;", "div_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class DivVariablesParser {
    public static final DivVariablesParser INSTANCE = new DivVariablesParser();

    private DivVariablesParser() {
    }

    public final List<Variable> parse(JSONArray variablesArray, ParsingErrorLogger logger) throws JSONException, ParsingException {
        Intrinsics.checkNotNullParameter(variablesArray, "variablesArray");
        Intrinsics.checkNotNullParameter(logger, "logger");
        DivParsingEnvironment divParsingEnvironment = new DivParsingEnvironment(logger, null, 2, null);
        DivVariablesParser$parse$listValidator$1 divVariablesParser$parse$listValidator$1 = new Function1<List<? extends DivVariable>, Boolean>() { // from class: com.yandex.div.core.expression.variables.DivVariablesParser$parse$listValidator$1
            @Override // kotlin.jvm.functions.Function1
            public final Boolean invoke(List<? extends DivVariable> it) {
                Intrinsics.checkNotNullParameter(it, "it");
                return true;
            }
        };
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("variables", variablesArray);
        List list = JsonParser.readList(jSONObject, "variables", DivVariable.INSTANCE.getCREATOR(), new DivVariablesParserKt$sam$com_yandex_div_internal_parser_ListValidator$0(divVariablesParser$parse$listValidator$1), logger, divParsingEnvironment);
        Intrinsics.checkNotNullExpressionValue(list, "readList(\n            js…stValidator, logger, env)");
        List list2 = list;
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list2, 10));
        Iterator it = list2.iterator();
        while (it.hasNext()) {
            arrayList.add(DivVariablesParserKt.toVariable((DivVariable) it.next()));
        }
        return arrayList;
    }
}
