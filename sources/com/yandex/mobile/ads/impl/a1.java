package com.yandex.mobile.ads.impl;

import android.content.pm.ActivityInfo;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes14.dex */
public final class a1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final String f8350a = "com.yandex.mobile.ads.common.AdActivity has missed configuration attribute %s.";
    private static final Map<Integer, String> b = MapsKt.mapOf(TuplesKt.to(16, "ActivityInfo.CONFIG_KEYBOARD"), TuplesKt.to(32, "ActivityInfo.CONFIG_KEYBOARD_HIDDEN"), TuplesKt.to(128, "ActivityInfo.CONFIG_ORIENTATION"), TuplesKt.to(256, "ActivityInfo.CONFIG_SCREEN_LAYOUT"), TuplesKt.to(512, "ActivityInfo.CONFIG_UI_MODE"), TuplesKt.to(1024, "ActivityInfo.CONFIG_SCREEN_SIZE"), TuplesKt.to(2048, "CONFIG_SMALLEST_SCREEN_SIZE"));

    public static void a(ActivityInfo adActivity) {
        Object obj;
        Intrinsics.checkNotNullParameter(adActivity, "adActivity");
        Map<Integer, String> map = b;
        ArrayList arrayList = new ArrayList(map.size());
        Iterator<Map.Entry<Integer, String>> it = map.entrySet().iterator();
        while (true) {
            obj = null;
            if (!it.hasNext()) {
                break;
            }
            Map.Entry<Integer, String> next = it.next();
            int iIntValue = next.getKey().intValue();
            String value = next.getValue();
            if ((iIntValue & adActivity.configChanges) == 0) {
                obj = value;
            }
            arrayList.add(obj);
        }
        for (Object obj2 : arrayList) {
            if (((String) obj2) != null) {
                obj = obj2;
                break;
            }
        }
        String str = (String) obj;
        if (str == null) {
            return;
        }
        String strA = z0.a(new Object[]{str}, 1, f8350a, "format(...)");
        throw new xo0(strA, strA);
    }
}
