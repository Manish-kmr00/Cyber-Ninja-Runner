package com.applovin.impl;

import android.view.View;
import com.iab.omid.library.applovin.adsession.FriendlyObstructionPurpose;

/* JADX INFO: loaded from: classes7.dex */
public class e4 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final View f404a;
    private final FriendlyObstructionPurpose b;
    private final String c;

    public e4(View view, FriendlyObstructionPurpose friendlyObstructionPurpose, String str) {
        this.f404a = view;
        this.b = friendlyObstructionPurpose;
        this.c = str;
    }

    public String a() {
        return this.c;
    }

    public FriendlyObstructionPurpose b() {
        return this.b;
    }

    public View c() {
        return this.f404a;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        e4 e4Var = (e4) obj;
        View view = this.f404a;
        if (view == null ? e4Var.f404a != null : !view.equals(e4Var.f404a)) {
            return false;
        }
        if (this.b != e4Var.b) {
            return false;
        }
        String str = this.c;
        String str2 = e4Var.c;
        if (str != null) {
            return str.equals(str2);
        }
        return str2 == null;
    }

    public int hashCode() {
        View view = this.f404a;
        int iHashCode = (view != null ? view.hashCode() : 0) * 31;
        FriendlyObstructionPurpose friendlyObstructionPurpose = this.b;
        int iHashCode2 = (iHashCode + (friendlyObstructionPurpose != null ? friendlyObstructionPurpose.hashCode() : 0)) * 31;
        String str = this.c;
        return iHashCode2 + (str != null ? str.hashCode() : 0);
    }
}
