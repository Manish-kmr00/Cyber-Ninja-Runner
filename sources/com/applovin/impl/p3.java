package com.applovin.impl;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/* JADX INFO: loaded from: classes.dex */
public class p3 {
    private static final Set c = new HashSet();
    private static final Map d = new HashMap();
    public static final p3 e;
    public static final p3 f;
    public static final p3 g;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private String f578a;
    private Set b;

    public enum a {
        SESSION("session"),
        INSTALL("install");


        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final String f579a;

        a(String str) {
            this.f579a = str;
        }

        public String b() {
            return this.f579a;
        }
    }

    public interface b {
        Object a(Object obj);
    }

    static {
        a aVar = a.SESSION;
        e = a("ars", aVar, a.INSTALL);
        f = a("ar", aVar);
        g = a("ttdasi_ms", aVar);
    }

    private p3(String str, Set set) {
        this.f578a = str;
        this.b = set;
    }

    protected boolean a(Object obj) {
        return obj instanceof p3;
    }

    public Set b() {
        return this.b;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof p3)) {
            return false;
        }
        p3 p3Var = (p3) obj;
        if (!p3Var.a(this)) {
            return false;
        }
        String strA = a();
        String strA2 = p3Var.a();
        if (strA != null ? !strA.equals(strA2) : strA2 != null) {
            return false;
        }
        Set setB = b();
        Set setB2 = p3Var.b();
        return setB != null ? setB.equals(setB2) : setB2 == null;
    }

    public int hashCode() {
        String strA = a();
        int iHashCode = strA == null ? 43 : strA.hashCode();
        Set setB = b();
        return ((iHashCode + 59) * 59) + (setB != null ? setB.hashCode() : 43);
    }

    public String toString() {
        return this.f578a;
    }

    public String a() {
        return this.f578a;
    }

    private static p3 a(String str, a... aVarArr) {
        Set set = c;
        if (!set.contains(str)) {
            p3 p3Var = new p3(str, new HashSet(Arrays.asList(aVarArr)));
            set.add(str);
            d.put(str, p3Var);
            return p3Var;
        }
        throw new IllegalArgumentException("Key has already been used: " + str);
    }

    public boolean a(a aVar) {
        return this.b.contains(aVar);
    }

    public static p3 a(String str) {
        return (p3) d.get(str);
    }
}
