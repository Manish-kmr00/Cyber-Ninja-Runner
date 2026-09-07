package com.iab.omid.library.amazon.internal;

import android.view.View;
import com.iab.omid.library.amazon.adsession.FriendlyObstructionPurpose;

/* JADX INFO: loaded from: classes12.dex */
public class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final com.iab.omid.library.amazon.weakreference.a f2450a;
    private final String b;
    private final FriendlyObstructionPurpose c;
    private final String d;

    public e(View view, FriendlyObstructionPurpose friendlyObstructionPurpose, String str) {
        this.f2450a = new com.iab.omid.library.amazon.weakreference.a(view);
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

    public com.iab.omid.library.amazon.weakreference.a c() {
        return this.f2450a;
    }

    public String d() {
        return this.b;
    }
}
