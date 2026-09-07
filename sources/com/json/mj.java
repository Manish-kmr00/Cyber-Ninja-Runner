package com.json;

import com.json.mediationsdk.model.InterstitialPlacement;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;

/* JADX INFO: loaded from: classes10.dex */
public class mj {
    private static final int n = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private ArrayList<InterstitialPlacement> f4037a;
    private h4 b;
    private int c;
    private boolean d;
    private int e;
    private int f;
    private o5 g;
    private boolean h;
    private long i;
    private boolean j;
    private boolean k;
    private boolean l;
    private InterstitialPlacement m;

    public mj() {
        this.f4037a = new ArrayList<>();
        this.b = new h4();
        this.g = new o5();
    }

    public mj(int i, boolean z, int i2, h4 h4Var, o5 o5Var, int i3, boolean z2, long j, boolean z3, boolean z4, boolean z5) {
        this.f4037a = new ArrayList<>();
        this.c = i;
        this.d = z;
        this.e = i2;
        this.b = h4Var;
        this.g = o5Var;
        this.j = z3;
        this.k = z4;
        this.f = i3;
        this.h = z2;
        this.i = j;
        this.l = z5;
    }

    public InterstitialPlacement a() {
        for (InterstitialPlacement interstitialPlacement : this.f4037a) {
            if (interstitialPlacement.getIsDefault()) {
                return interstitialPlacement;
            }
        }
        return this.m;
    }

    public InterstitialPlacement a(String str) {
        for (InterstitialPlacement interstitialPlacement : this.f4037a) {
            if (interstitialPlacement.getPlacementName().equals(str)) {
                return interstitialPlacement;
            }
        }
        return null;
    }

    public void a(InterstitialPlacement interstitialPlacement) {
        if (interstitialPlacement != null) {
            this.f4037a.add(interstitialPlacement);
            if (this.m == null || interstitialPlacement.isPlacementId(0)) {
                this.m = interstitialPlacement;
            }
        }
    }

    public int b() {
        return this.f;
    }

    public int c() {
        return this.c;
    }

    public int d() {
        return this.e;
    }

    public long e() {
        return TimeUnit.SECONDS.toMillis(this.e);
    }

    public boolean f() {
        return this.d;
    }

    public o5 g() {
        return this.g;
    }

    public long h() {
        return this.i;
    }

    public h4 i() {
        return this.b;
    }

    public boolean j() {
        return this.h;
    }

    public boolean k() {
        return this.j;
    }

    public boolean l() {
        return this.l;
    }

    public boolean m() {
        return this.k;
    }

    public String toString() {
        return "InterstitialConfigurations{parallelLoad=" + this.c + ", bidderExclusive=" + this.d + AbstractJsonLexerKt.END_OBJ;
    }
}
