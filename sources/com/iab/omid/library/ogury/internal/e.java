package com.iab.omid.library.ogury.internal;

import android.view.View;
import com.iab.omid.library.ogury.adsession.FriendlyObstructionPurpose;

/* JADX INFO: loaded from: classes13.dex */
public class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final com.iab.omid.library.ogury.weakreference.a f2804a;
    private final String b;
    private final FriendlyObstructionPurpose c;
    private final String d;

    public e(View view, FriendlyObstructionPurpose friendlyObstructionPurpose, String str) {
        this.f2804a = new com.iab.omid.library.ogury.weakreference.a(view);
        this.b = view.getClass().getCanonicalName();
        this.c = friendlyObstructionPurpose;
        this.d = str;
    }

    public String a() {
        return this.d;
    }

    public FriendlyObstructionPurpose b() {
        return this.c;
    }

    public com.iab.omid.library.ogury.weakreference.a c() {
        return this.f2804a;
    }

    public String d() {
        return this.b;
    }
}
