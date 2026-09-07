package com.yandex.div;

import android.net.Uri;
import com.yandex.div2.ArrayVariable;
import com.yandex.div2.BoolVariable;
import com.yandex.div2.ColorVariable;
import com.yandex.div2.DictVariable;
import com.yandex.div2.DivVariable;
import com.yandex.div2.IntegerVariable;
import com.yandex.div2.NumberVariable;
import com.yandex.div2.StrVariable;
import com.yandex.div2.UrlVariable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: compiled from: DivVariables.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000V\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0006\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u001a\u0018\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0000\u001a\u0016\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\b\u001a\u0018\u0010\t\u001a\u00020\n2\u0006\u0010\u0002\u001a\u00020\u00032\b\b\u0001\u0010\u0004\u001a\u00020\u000b\u001a\u0018\u0010\f\u001a\u00020\r2\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u000eH\u0000\u001a\u0016\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0011\u001a\u0016\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0014\u001a\u0016\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0003\u001a\u0016\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0019¨\u0006\u001a"}, d2 = {"arrayVariable", "Lcom/yandex/div2/DivVariable$Array;", "name", "", "value", "Lorg/json/JSONArray;", "boolVariable", "Lcom/yandex/div2/DivVariable$Bool;", "", "colorVariable", "Lcom/yandex/div2/DivVariable$Color;", "", "dictVariable", "Lcom/yandex/div2/DivVariable$Dict;", "Lorg/json/JSONObject;", "integerVariable", "Lcom/yandex/div2/DivVariable$Integer;", "", "numberVariable", "Lcom/yandex/div2/DivVariable$Number;", "", "stringVariable", "Lcom/yandex/div2/DivVariable$Str;", "urlVariable", "Lcom/yandex/div2/DivVariable$Url;", "Landroid/net/Uri;", "div-data_release"}, k = 2, mv = {1, 5, 1}, xi = 48)
public final class DivVariables {
    public static final DivVariable.Integer integerVariable(String name, long j) {
        Intrinsics.checkNotNullParameter(name, "name");
        return new DivVariable.Integer(new IntegerVariable(name, j));
    }

    public static final DivVariable.Number numberVariable(String name, double d) {
        Intrinsics.checkNotNullParameter(name, "name");
        return new DivVariable.Number(new NumberVariable(name, d));
    }

    public static final DivVariable.Bool boolVariable(String name, boolean z) {
        Intrinsics.checkNotNullParameter(name, "name");
        return new DivVariable.Bool(new BoolVariable(name, z));
    }

    public static final DivVariable.Str stringVariable(String name, String value) {
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(value, "value");
        return new DivVariable.Str(new StrVariable(name, value));
    }

    public static final DivVariable.Color colorVariable(String name, int i) {
        Intrinsics.checkNotNullParameter(name, "name");
        return new DivVariable.Color(new ColorVariable(name, i));
    }

    public static final DivVariable.Url urlVariable(String name, Uri value) {
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(value, "value");
        return new DivVariable.Url(new UrlVariable(name, value));
    }

    public static final DivVariable.Dict dictVariable(String name, JSONObject value) {
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(value, "value");
        return new DivVariable.Dict(new DictVariable(name, value));
    }

    public static final DivVariable.Array arrayVariable(String name, JSONArray value) {
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(value, "value");
        return new DivVariable.Array(new ArrayVariable(name, value));
    }
}
