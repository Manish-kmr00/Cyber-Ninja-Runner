package com.applovin.impl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;

/* JADX INFO: loaded from: classes2.dex */
public class m8 {
    public static final m8 f = new m8();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final m8 f509a;
    private final String b;
    private final Map c;
    protected String d;
    protected final List e;

    public m8(String str, Map map, m8 m8Var) {
        this.f509a = m8Var;
        this.b = str;
        this.c = Collections.unmodifiableMap(map);
        this.e = new ArrayList();
    }

    public Map a() {
        return this.c;
    }

    public List b() {
        return Collections.unmodifiableList(this.e);
    }

    public String c() {
        return this.b;
    }

    public String d() {
        return this.d;
    }

    public String toString() {
        return "XmlNode{elementName='" + this.b + "', text='" + this.d + "', attributes=" + this.c + AbstractJsonLexerKt.END_OBJ;
    }

    public List a(String str) {
        if (str == null) {
            throw new IllegalArgumentException("No name specified.");
        }
        ArrayList arrayList = new ArrayList(this.e.size());
        for (m8 m8Var : this.e) {
            if (str.equalsIgnoreCase(m8Var.c())) {
                arrayList.add(m8Var);
            }
        }
        return arrayList;
    }

    public m8 b(String str) {
        if (str == null) {
            throw new IllegalArgumentException("No name specified.");
        }
        if (this.e.size() <= 0) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        arrayList.add(this);
        while (!arrayList.isEmpty()) {
            m8 m8Var = (m8) arrayList.get(0);
            arrayList.remove(0);
            if (str.equalsIgnoreCase(m8Var.c())) {
                return m8Var;
            }
            arrayList.addAll(m8Var.b());
        }
        return null;
    }

    public m8 c(String str) {
        if (str == null) {
            throw new IllegalArgumentException("No name specified.");
        }
        for (m8 m8Var : this.e) {
            if (str.equalsIgnoreCase(m8Var.c())) {
                return m8Var;
            }
        }
        return null;
    }

    private m8() {
        this.f509a = null;
        this.b = "";
        this.c = Collections.emptyMap();
        this.d = "";
        this.e = Collections.emptyList();
    }
}
