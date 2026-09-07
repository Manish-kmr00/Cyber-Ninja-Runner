package com.bytedance.adsdk.pA.Og.ZZv;

import com.google.firebase.sessions.settings.RemoteSettings;
import com.safedk.android.analytics.brandsafety.l;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import org.slf4j.Marker;

/* JADX INFO: loaded from: classes12.dex */
public enum KZx implements ML {
    QUESTION("?", 0),
    COLON(":", 0),
    DOUBLE_AMP("&&", 1),
    DOUBLE_BAR(l.ac, 1),
    EQ("==", 2),
    GT(">", 2),
    LT("<", 2),
    LT_EQ("<=", 2),
    GT_EQ(">=", 2),
    NOT_EQ("!=", 2),
    PLUS(Marker.ANY_NON_NULL_MARKER, 3),
    MINUS("-", 3),
    MULTI("*", 4),
    DIVISION(RemoteSettings.FORWARD_SLASH_STRING, 4),
    MOD("%", 4);

    private final String XT;
    private final int yFO;
    private static final Map<String, KZx> oX = new HashMap(128);
    private static final Set<KZx> aBv = new HashSet();

    static {
        for (KZx kZx : values()) {
            oX.put(kZx.pA(), kZx);
            aBv.add(kZx);
        }
    }

    KZx(String str, int i) {
        this.XT = str;
        this.yFO = i;
    }

    public static KZx pA(String str) {
        return oX.get(str);
    }

    public static boolean pA(ML ml) {
        return ml instanceof KZx;
    }

    public String pA() {
        return this.XT;
    }

    public int Og() {
        return this.yFO;
    }
}
