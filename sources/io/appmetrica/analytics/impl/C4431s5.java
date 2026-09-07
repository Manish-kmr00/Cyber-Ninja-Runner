package io.appmetrica.analytics.impl;

import android.content.Context;
import java.util.HashMap;

/* JADX INFO: renamed from: io.appmetrica.analytics.impl.s5, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes8.dex */
public final class C4431s5 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final HashMap f11759a = new HashMap();
    public final HashMap b = new HashMap();
    public final Context c;

    public C4431s5(Context context) {
        this.c = context.getApplicationContext();
    }

    public final Na a(C4108f5 c4108f5, G4 g4, T7 t7, HashMap map) {
        Na na = (Na) map.get(c4108f5.toString());
        if (na != null) {
            na.a(g4);
            return na;
        }
        Na naA = t7.a(this.c, c4108f5, g4);
        map.put(c4108f5.toString(), naA);
        return naA;
    }
}
