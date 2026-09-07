package com.fyber.inneractive.sdk.config.global.features;

/* JADX INFO: loaded from: classes13.dex */
public final class b extends h {
    public static final a e = a.OPEN;

    public b() {
        super("ad_identifier");
    }

    @Override // com.fyber.inneractive.sdk.config.global.features.h
    public final h c() {
        b bVar = new b();
        a(bVar);
        return bVar;
    }

    public final a d() {
        String strA = a("identifier_click_action", e.mKey);
        for (a aVar : a.values()) {
            if (strA.equalsIgnoreCase(aVar.mKey)) {
                return aVar;
            }
        }
        return a.NONE;
    }
}
