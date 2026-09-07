package com.bytedance.adsdk.pA.Og.ZZv;

import com.json.b9;
import io.appmetrica.analytics.coreutils.internal.StringUtils;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes4.dex */
public enum ZZv implements ML {
    LEFT_PAREN("("),
    RIGHT_PAREN(")"),
    LEFT_BRACKET(b9.i.d),
    RIGHT_BRACKET(b9.i.e),
    COMMA(StringUtils.COMMA);

    private static final Map<String, ZZv> JG;
    private final String SD;

    static {
        HashMap map = new HashMap(128);
        JG = map;
        for (ZZv zZv : map.values()) {
            JG.put(zZv.pA(), zZv);
        }
    }

    ZZv(String str) {
        this.SD = str;
    }

    public static boolean pA(ML ml) {
        return ml instanceof ZZv;
    }

    public String pA() {
        return this.SD;
    }
}
