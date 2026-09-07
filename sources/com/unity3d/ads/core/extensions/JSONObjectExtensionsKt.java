package com.unity3d.ads.core.extensions;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.sequences.Sequence;
import kotlin.sequences.SequencesKt;
import org.json.JSONObject;

/* JADX INFO: compiled from: JSONObjectExtensions.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\u001a\u0018\u0010\u0000\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u0001*\u00020\u0004¨\u0006\u0005"}, d2 = {"toBuiltInMap", "", "", "", "Lorg/json/JSONObject;", "unity-ads_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class JSONObjectExtensionsKt {
    /* JADX WARN: Code duplicated, block: B:12:0x0050  */
    public static final Map<String, Object> toBuiltInMap(JSONObject jSONObject) {
        Intrinsics.checkNotNullParameter(jSONObject, "<this>");
        Iterator<String> itKeys = jSONObject.keys();
        Intrinsics.checkNotNullExpressionValue(itKeys, "keys()");
        Sequence sequenceAsSequence = SequencesKt.asSequence(itKeys);
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (Object obj : sequenceAsSequence) {
            LinkedHashMap linkedHashMap2 = linkedHashMap;
            Object objOpt = jSONObject.opt((String) obj);
            if (objOpt != null) {
                Intrinsics.checkNotNullExpressionValue(objOpt, "opt(value)");
                if (Intrinsics.areEqual(String.valueOf(objOpt), "undefined") || Intrinsics.areEqual(String.valueOf(objOpt), "null")) {
                    objOpt = null;
                }
            } else {
                objOpt = null;
            }
            linkedHashMap2.put(obj, objOpt);
        }
        return linkedHashMap;
    }
}
