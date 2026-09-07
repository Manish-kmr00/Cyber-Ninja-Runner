package com.inmobi.media;

import com.inmobi.commons.core.configs.Config;
import java.util.HashMap;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: renamed from: com.inmobi.media.e3, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes9.dex */
public abstract class AbstractC3351e3 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final HashMap f3298a = new HashMap();

    public static Config a(String str, String type) {
        Intrinsics.checkNotNullParameter(type, "type");
        String strB = b(str, type);
        HashMap map = f3298a;
        Object objA = map.get(strB);
        if (objA == null) {
            Config.Companion.getClass();
            objA = C3464m2.a(type, str);
            map.put(strB, objA);
        }
        return (Config) objA;
    }

    public static String b(String str, String type) {
        Intrinsics.checkNotNullParameter(type, "type");
        return str + '-' + type;
    }
}
