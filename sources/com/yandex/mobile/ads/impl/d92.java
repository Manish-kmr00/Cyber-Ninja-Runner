package com.yandex.mobile.ads.impl;

import android.util.Log;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes13.dex */
public final class d92 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final List<String> f8673a = CollectionsKt.listOf((Object[]) new String[]{"The integrated version of the Yandex Mobile Ads SDK is outdated.", "Please update com.yandex.android:mobileads to the latest version."});

    public static void b() {
        Integer numValueOf;
        List listPlus = CollectionsKt.plus((Collection) CollectionsKt.plus((Collection) f8673a, (Iterable) CollectionsKt.listOf((Object[]) new String[]{"Learn more about the latest version of the SDK here:", "https://yandex.ru/dev/mobile-ads/doc/android/quick-start/android-ads-component.html"})), (Iterable) a());
        Iterator it = listPlus.iterator();
        String strJoinToString$default = null;
        if (it.hasNext()) {
            numValueOf = Integer.valueOf(((String) it.next()).length());
            while (it.hasNext()) {
                Integer numValueOf2 = Integer.valueOf(((String) it.next()).length());
                if (numValueOf.compareTo(numValueOf2) < 0) {
                    numValueOf = numValueOf2;
                }
            }
        } else {
            numValueOf = null;
        }
        if (numValueOf != null) {
            int iIntValue = numValueOf.intValue();
            String strRepeat = StringsKt.repeat("*", iIntValue + 4);
            ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(listPlus, 10));
            Iterator it2 = listPlus.iterator();
            while (it2.hasNext()) {
                arrayList.add(a(iIntValue, (String) it2.next()));
            }
            strJoinToString$default = CollectionsKt.joinToString$default(CollectionsKt.plus((Collection<? extends String>) CollectionsKt.plus((Collection) CollectionsKt.listOf(strRepeat), (Iterable) arrayList), strRepeat), "\n", null, null, 0, null, null, 62, null);
        }
        Log.e("Yandex Mobile Ads", "Yandex Mobile Ads version validation\n" + strJoinToString$default + "\n");
    }

    private static String a(int i, String str) {
        return "* " + str + StringsKt.repeat(" ", i - str.length()) + " *";
    }

    private static List a() {
        if (gm.a() != null) {
            return CollectionsKt.listOf("Changelog: " + gm.a());
        }
        return CollectionsKt.emptyList();
    }
}
