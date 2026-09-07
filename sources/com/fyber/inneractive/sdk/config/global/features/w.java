package com.fyber.inneractive.sdk.config.global.features;

/* JADX INFO: loaded from: classes13.dex */
public final class w extends h {
    public static final u e = u.NONE;
    public static final v f = v.NONE;

    public w() {
        super("video_player");
    }

    @Override // com.fyber.inneractive.sdk.config.global.features.h
    public final h c() {
        w wVar = new w();
        a(wVar);
        return wVar;
    }

    public final u d() {
        String strA = a("click_action", e.mKey);
        for (u uVar : u.values()) {
            if (strA.equalsIgnoreCase(uVar.mKey)) {
                return uVar;
            }
        }
        return u.NONE;
    }

    public final v e() {
        String strA = a("endcard_animation_type", f.mKey);
        for (v vVar : v.values()) {
            if (strA.equalsIgnoreCase(vVar.mKey)) {
                return vVar;
            }
        }
        return v.NONE;
    }
}
