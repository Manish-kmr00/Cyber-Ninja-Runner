package com.json;

import com.json.mediationsdk.model.Placement;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;

/* JADX INFO: loaded from: classes8.dex */
public class yq {
    private static final int o = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private ArrayList<Placement> f4630a;
    private h4 b;
    private int c;
    private boolean d;
    private int e;
    private int f;
    private int g;
    private long h;
    private boolean i;
    private boolean j;
    private boolean k;
    private Placement l;
    private o5 m;
    private boolean n;

    public yq() {
        this.f4630a = new ArrayList<>();
        this.b = new h4();
    }

    public yq(int i, boolean z, int i2, int i3, h4 h4Var, o5 o5Var, int i4, boolean z2, long j, boolean z3, boolean z4, boolean z5) {
        this.f4630a = new ArrayList<>();
        this.c = i;
        this.d = z;
        this.e = i2;
        this.b = h4Var;
        this.f = i3;
        this.m = o5Var;
        this.g = i4;
        this.n = z2;
        this.h = j;
        this.i = z3;
        this.j = z4;
        this.k = z5;
    }

    public Placement a() {
        for (Placement placement : this.f4630a) {
            if (placement.getIsDefault()) {
                return placement;
            }
        }
        return this.l;
    }

    public Placement a(String str) {
        for (Placement placement : this.f4630a) {
            if (placement.getPlacementName().equals(str)) {
                return placement;
            }
        }
        return null;
    }

    public void a(Placement placement) {
        if (placement != null) {
            this.f4630a.add(placement);
            if (this.l == null || placement.isPlacementId(0)) {
                this.l = placement;
            }
        }
    }

    public int b() {
        return this.g;
    }

    public int c() {
        return this.f;
    }

    public boolean d() {
        return this.n;
    }

    public ArrayList<Placement> e() {
        return this.f4630a;
    }

    public boolean f() {
        return this.i;
    }

    public int g() {
        return this.c;
    }

    public int h() {
        return this.e;
    }

    public long i() {
        return TimeUnit.SECONDS.toMillis(this.e);
    }

    public boolean j() {
        return this.d;
    }

    public o5 k() {
        return this.m;
    }

    public long l() {
        return this.h;
    }

    public h4 m() {
        return this.b;
    }

    public boolean n() {
        return this.k;
    }

    public boolean o() {
        return this.j;
    }

    public String toString() {
        return "RewardedVideoConfigurations{parallelLoad=" + this.c + ", bidderExclusive=" + this.d + AbstractJsonLexerKt.END_OBJ;
    }
}
