package com.mbridge.msdk.splash.common;

import com.mbridge.msdk.foundation.entity.CampaignEx;

/* JADX INFO: compiled from: ViewRenderParam.java */
/* JADX INFO: loaded from: classes11.dex */
public class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private String f5409a;
    private String b;
    private CampaignEx c;
    private String d;
    private boolean e;
    private int f;
    private int g;
    private int h;
    private int i;
    private int j;
    private int k;
    private int l;
    private int m;
    private int n;

    /* JADX INFO: compiled from: ViewRenderParam.java */
    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private String f5410a;
        private String b;
        private CampaignEx c;
        private String d;
        private boolean e;
        private int f;
        private int g = 0;
        private int h = 1;
        private int i = 0;
        private int j = 0;
        private int k = 10;
        private int l = 5;
        private int m = 1;
        private int n;

        public a a(String str) {
            this.f5410a = str;
            return this;
        }

        public a b(String str) {
            this.b = str;
            return this;
        }

        public a c(int i) {
            this.f = i;
            return this;
        }

        public a d(int i) {
            this.m = i;
            return this;
        }

        public a e(int i) {
            this.h = i;
            return this;
        }

        public a f(int i) {
            this.n = i;
            return this;
        }

        public a g(int i) {
            this.j = i;
            return this;
        }

        public a h(int i) {
            this.k = i;
            return this;
        }

        public a i(int i) {
            this.l = i;
            return this;
        }

        public a a(CampaignEx campaignEx) {
            this.c = campaignEx;
            return this;
        }

        public a b(int i) {
            this.g = i;
            return this;
        }

        public a a(boolean z) {
            this.e = z;
            return this;
        }

        public a a(int i) {
            this.i = i;
            return this;
        }

        public c a() {
            return new c(this);
        }
    }

    public c(a aVar) {
        this.g = 0;
        this.h = 1;
        this.i = 0;
        this.j = 0;
        this.k = 10;
        this.l = 5;
        this.m = 1;
        this.f5409a = aVar.f5410a;
        this.b = aVar.b;
        this.c = aVar.c;
        this.d = aVar.d;
        this.e = aVar.e;
        this.f = aVar.f;
        this.g = aVar.g;
        this.h = aVar.h;
        this.i = aVar.i;
        this.j = aVar.j;
        this.k = aVar.k;
        this.l = aVar.l;
        this.n = aVar.n;
        this.m = aVar.m;
    }

    public int a() {
        return this.i;
    }

    public CampaignEx b() {
        return this.c;
    }

    public int c() {
        return this.g;
    }

    public int d() {
        return this.f;
    }

    public int e() {
        return this.m;
    }

    public int f() {
        return this.h;
    }

    public int g() {
        return this.n;
    }

    public String h() {
        return this.f5409a;
    }

    public int i() {
        return this.j;
    }

    public int j() {
        return this.k;
    }

    public int k() {
        return this.l;
    }

    public String l() {
        return this.b;
    }

    public boolean m() {
        return this.e;
    }
}
