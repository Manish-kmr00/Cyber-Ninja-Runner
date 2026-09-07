package com.yandex.mobile.ads.impl;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import kotlin.collections.CollectionsKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.builtins.BuiltinSerializersKt;
import kotlinx.serialization.json.Json;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public final class gl {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final Json f9014a;
    public static final /* synthetic */ int b = 0;

    static {
        rq0.f10131a.getClass();
        f9014a = rq0.a();
    }

    public static el a(ls0 localStorage) {
        Intrinsics.checkNotNullParameter(localStorage, "localStorage");
        Set<String> setA = localStorage.a("BiddingSettingsAdUnitIdsSet", SetsKt.emptySet());
        if (setA == null) {
            setA = SetsKt.emptySet();
        }
        Set<String> setA2 = localStorage.a("MediationPrefetchSettingsAdUnitIdsSet", SetsKt.emptySet());
        if (setA2 == null) {
            setA2 = SetsKt.emptySet();
        }
        fl flVar = new fl();
        ArrayList arrayList = new ArrayList(setA.size());
        Iterator<String> it = setA.iterator();
        while (it.hasNext()) {
            String strD = localStorage.d(a(it.next()));
            if (strD != null && strD.length() != 0) {
                try {
                    ba baVarA = flVar.a(new JSONObject(strD));
                    if (baVarA != null) {
                        arrayList.add(baVarA);
                    }
                } catch (JSONException unused) {
                    op0.b(new Object[0]);
                }
            }
        }
        long jB = localStorage.b("MediationPrefetchLoadTimeoutMillis");
        ArrayList arrayList2 = new ArrayList(setA2.size());
        Iterator<String> it2 = setA2.iterator();
        while (it2.hasNext()) {
            String strD2 = localStorage.d(b(it2.next()));
            if (strD2 != null) {
                Json json = f9014a;
                json.getSerializersModule();
                a01 a01Var = (a01) json.decodeFromString(BuiltinSerializersKt.getNullable(a01.Companion.serializer()), strD2);
                if (a01Var != null) {
                    arrayList2.add(a01Var);
                }
            }
        }
        d01 d01Var = new d01(jB, arrayList2);
        if (arrayList.isEmpty() && setA2.isEmpty()) {
            return null;
        }
        return new el(arrayList, d01Var);
    }

    private static String b(String str) {
        return "MediationPrefetchSettingsAdUnitIdsInfo_" + str;
    }

    public static void b(ls0 localStorage) {
        Intrinsics.checkNotNullParameter(localStorage, "localStorage");
        Set<String> setA = localStorage.a("BiddingSettingsAdUnitIdsSet", SetsKt.emptySet());
        if (setA == null) {
            setA = SetsKt.emptySet();
        }
        Set<String> setA2 = localStorage.a("MediationPrefetchSettingsAdUnitIdsSet", SetsKt.emptySet());
        if (setA2 == null) {
            setA2 = SetsKt.emptySet();
        }
        Iterator<String> it = setA.iterator();
        while (it.hasNext()) {
            localStorage.a(a(it.next()));
        }
        Iterator<String> it2 = setA2.iterator();
        while (it2.hasNext()) {
            localStorage.a(b(it2.next()));
        }
        localStorage.a("BiddingSettingsAdUnitIdsSet");
        localStorage.a("MediationPrefetchSettingsAdUnitIdsSet");
    }

    private static String a(String str) {
        return "BiddingSettingsAdUnitIdsInfo_" + str;
    }

    public static void a(ls0 localStorage, el biddingSettings) {
        List<a01> listEmptyList;
        Intrinsics.checkNotNullParameter(localStorage, "localStorage");
        Intrinsics.checkNotNullParameter(biddingSettings, "biddingSettings");
        List<ba> listC = biddingSettings.c();
        HashSet hashSet = new HashSet(listC.size());
        for (ba baVar : listC) {
            String strC = baVar.c();
            String strD = baVar.d();
            hashSet.add(strC);
            localStorage.a(a(strC), strD);
        }
        Set<String> setA = localStorage.a("BiddingSettingsAdUnitIdsSet", SetsKt.emptySet());
        if (setA == null) {
            setA = SetsKt.emptySet();
        }
        for (String str : setA) {
            if (!hashSet.contains(str)) {
                localStorage.a(a(str));
            }
        }
        localStorage.a("BiddingSettingsAdUnitIdsSet", hashSet);
        d01 d01VarD = biddingSettings.d();
        long jD = d01VarD != null ? d01VarD.d() : 0L;
        if (d01VarD == null || (listEmptyList = d01VarD.e()) == null) {
            listEmptyList = CollectionsKt.emptyList();
        }
        HashSet hashSet2 = new HashSet(listEmptyList.size());
        for (a01 a01Var : listEmptyList) {
            hashSet2.add(a01Var.d());
            String strB = b(a01Var.d());
            Json json = f9014a;
            json.getSerializersModule();
            localStorage.a(strB, json.encodeToString(a01.Companion.serializer(), a01Var));
        }
        Set<String> setA2 = localStorage.a("MediationPrefetchSettingsAdUnitIdsSet", SetsKt.emptySet());
        if (setA2 == null) {
            setA2 = SetsKt.emptySet();
        }
        for (String str2 : setA2) {
            if (!hashSet2.contains(str2)) {
                localStorage.a(b(str2));
            }
        }
        localStorage.a("MediationPrefetchSettingsAdUnitIdsSet", hashSet2);
        localStorage.a("MediationPrefetchLoadTimeoutMillis", jD);
    }
}
