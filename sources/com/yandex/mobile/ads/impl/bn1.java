package com.yandex.mobile.ads.impl;

import android.net.Uri;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: classes11.dex */
public final class bn1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Map<String, String> f8523a;

    public static final class a {
        @JvmStatic
        public static Uri a(Uri uri, Function1 modifier) {
            Map mapEmptyMap;
            Intrinsics.checkNotNullParameter(uri, "<this>");
            Intrinsics.checkNotNullParameter(modifier, "modifier");
            Set<String> queryParameterNames = uri.getQueryParameterNames();
            if (queryParameterNames != null) {
                mapEmptyMap = new LinkedHashMap(RangesKt.coerceAtLeast(MapsKt.mapCapacity(CollectionsKt.collectionSizeOrDefault(queryParameterNames, 10)), 16));
                for (String str : queryParameterNames) {
                    Pair pair = TuplesKt.to(str, uri.getQueryParameter(str));
                    mapEmptyMap.put(pair.getFirst(), pair.getSecond());
                }
            } else {
                mapEmptyMap = null;
            }
            if (mapEmptyMap == null) {
                mapEmptyMap = MapsKt.emptyMap();
            }
            bn1 bn1Var = (bn1) ((ga2) modifier).invoke(new bn1(mapEmptyMap));
            Uri.Builder builderClearQuery = uri.buildUpon().clearQuery();
            for (Map.Entry<String, String> entry : bn1Var.a().entrySet()) {
                builderClearQuery.appendQueryParameter(entry.getKey(), entry.getValue());
            }
            Uri uriBuild = builderClearQuery.build();
            Intrinsics.checkNotNullExpressionValue(uriBuild, "build(...)");
            return uriBuild;
        }
    }

    public bn1(Map<String, String> rawParams) {
        Intrinsics.checkNotNullParameter(rawParams, "rawParams");
        this.f8523a = MapsKt.toMutableMap(rawParams);
    }

    public final Map<String, String> a() {
        return this.f8523a;
    }

    public final void a(String key, String str) {
        Intrinsics.checkNotNullParameter(key, "key");
        if (str == null || str.length() <= 0) {
            return;
        }
        this.f8523a.put(key, str);
    }
}
