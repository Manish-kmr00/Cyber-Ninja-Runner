package com.json;

import android.util.Pair;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public final class ec {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private String f3648a;
    private boolean b;
    private String c;
    private vf d;
    private boolean e;
    private ArrayList<Pair<String, String>> f;

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private String f3649a;
        private vf d;
        private boolean b = false;
        private String c = "POST";
        private boolean e = false;
        private ArrayList<Pair<String, String>> f = new ArrayList<>();

        public a(String str) {
            this.f3649a = "";
            if (str == null || str.isEmpty()) {
                return;
            }
            this.f3649a = str;
        }

        public a a(Pair<String, String> pair) {
            this.f.add(pair);
            return this;
        }

        public a a(vf vfVar) {
            this.d = vfVar;
            return this;
        }

        public a a(List<Pair<String, String>> list) {
            this.f.addAll(list);
            return this;
        }

        public a a(boolean z) {
            this.e = z;
            return this;
        }

        public ec a() {
            return new ec(this);
        }

        public a b() {
            this.c = "GET";
            return this;
        }

        public a b(boolean z) {
            this.b = z;
            return this;
        }

        public a c() {
            this.c = "POST";
            return this;
        }
    }

    ec(a aVar) {
        this.e = false;
        this.f3648a = aVar.f3649a;
        this.b = aVar.b;
        this.c = aVar.c;
        this.d = aVar.d;
        this.e = aVar.e;
        if (aVar.f != null) {
            this.f = new ArrayList<>(aVar.f);
        }
    }

    public boolean a() {
        return this.b;
    }

    public String b() {
        return this.f3648a;
    }

    public vf c() {
        return this.d;
    }

    public ArrayList<Pair<String, String>> d() {
        return new ArrayList<>(this.f);
    }

    public String e() {
        return this.c;
    }

    public boolean f() {
        return this.e;
    }
}
