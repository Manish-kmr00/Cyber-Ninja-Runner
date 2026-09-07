package com.smaato.sdk.core.util;

import android.net.UrlQuerySanitizer;
import com.smaato.sdk.core.util.collections.Maps;
import com.smaato.sdk.core.util.fi.Function;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes13.dex */
public final class TextUtils {
    public static boolean isEmpty(CharSequence charSequence) {
        return charSequence == null || charSequence.length() == 0;
    }

    public static Map<String, String> parseQuery(String str) {
        if (isEmpty(str)) {
            return Collections.emptyMap();
        }
        UrlQuerySanitizer urlQuerySanitizer = new UrlQuerySanitizer();
        urlQuerySanitizer.setAllowUnregisteredParamaters(true);
        urlQuerySanitizer.parseQuery(str);
        return Maps.toMap(urlQuerySanitizer.getParameterList(), new Function() { // from class: com.smaato.sdk.core.util.TextUtils$$ExternalSyntheticLambda0
            @Override // com.smaato.sdk.core.util.fi.Function
            public final Object apply(Object obj) {
                return ((UrlQuerySanitizer.ParameterValuePair) obj).mParameter;
            }
        }, new Function() { // from class: com.smaato.sdk.core.util.TextUtils$$ExternalSyntheticLambda1
            @Override // com.smaato.sdk.core.util.fi.Function
            public final Object apply(Object obj) {
                return ((UrlQuerySanitizer.ParameterValuePair) obj).mValue;
            }
        });
    }

    public static Map<String, String> convertJsonStringToMap(String str) {
        if (isEmpty(str)) {
            return Collections.emptyMap();
        }
        try {
            HashMap map = new HashMap();
            JSONObject jSONObject = new JSONObject(str);
            java.util.Iterator<String> itKeys = jSONObject.keys();
            while (itKeys.hasNext()) {
                String next = itKeys.next();
                map.put(next, jSONObject.getString(next));
            }
            return map;
        } catch (JSONException unused) {
            return Collections.emptyMap();
        }
    }

    public static TreeMap<String, String> parseQueryToCaseInsensitiveMap(String str) {
        TreeMap<String, String> treeMap = new TreeMap<>((Comparator<? super String>) String.CASE_INSENSITIVE_ORDER);
        treeMap.putAll(parseQuery(str));
        return treeMap;
    }
}
