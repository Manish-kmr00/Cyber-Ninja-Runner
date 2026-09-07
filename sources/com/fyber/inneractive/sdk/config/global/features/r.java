package com.fyber.inneractive.sdk.config.global.features;

import java.util.Locale;

/* JADX INFO: loaded from: classes13.dex */
public final class r extends h {
    public r() {
        super("store_webpage");
    }

    @Override // com.fyber.inneractive.sdk.config.global.features.h
    public final h c() {
        r rVar = new r();
        a(rVar);
        return rVar;
    }

    public final q d() {
        String strA = a("presentation_mode", null);
        if (strA != null) {
            for (q qVar : q.values()) {
                Locale locale = Locale.US;
                if (strA.toLowerCase(locale).equals(qVar.value.toLowerCase(locale))) {
                    return qVar;
                }
            }
        }
        return q.FullScreen;
    }
}
