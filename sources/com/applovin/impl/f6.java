package com.applovin.impl;

import com.applovin.impl.sdk.utils.JsonUtils;
import com.applovin.impl.sdk.utils.StringUtils;
import com.applovin.sdk.AppLovinAdLoadListener;
import java.util.Iterator;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes7.dex */
public abstract class f6 extends g5 {
    private final AppLovinAdLoadListener g;
    private final a h;

    private static final class a extends p7 {
        a(JSONObject jSONObject, JSONObject jSONObject2, com.applovin.impl.sdk.k kVar) {
            super(jSONObject, jSONObject2, kVar);
        }

        void a(m8 m8Var) {
            if (m8Var == null) {
                throw new IllegalArgumentException("No aggregated vast response specified");
            }
            this.b.add(m8Var);
        }
    }

    private static final class b extends f6 {
        private final String i;

        b(String str, p7 p7Var, AppLovinAdLoadListener appLovinAdLoadListener, com.applovin.impl.sdk.k kVar) {
            super(p7Var, appLovinAdLoadListener, kVar);
            this.i = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            m8 m8VarB = b(this.i);
            if (m8VarB != null) {
                a(m8VarB);
                return;
            }
            if (com.applovin.impl.sdk.o.a()) {
                this.c.b(this.b, "Unable to process XML: " + this.i);
            }
            c(this.i);
            a(q7.XML_PARSING);
        }
    }

    private static final class c extends f6 {
        private final JSONObject i;

        c(p7 p7Var, AppLovinAdLoadListener appLovinAdLoadListener, com.applovin.impl.sdk.k kVar) {
            super(p7Var, appLovinAdLoadListener, kVar);
            this.i = p7Var.b();
        }

        @Override // java.lang.Runnable
        public void run() {
            if (com.applovin.impl.sdk.o.a()) {
                this.c.a(this.b, "Processing SDK JSON response...");
            }
            String string = JsonUtils.getString(this.i, "xml", null);
            if (!StringUtils.isValidString(string)) {
                if (com.applovin.impl.sdk.o.a()) {
                    this.c.b(this.b, "No VAST response received.");
                }
                a(q7.NO_WRAPPER_RESPONSE);
            } else {
                if (string.length() >= ((Integer) this.f424a.a(v4.F4)).intValue()) {
                    if (com.applovin.impl.sdk.o.a()) {
                        this.c.b(this.b, "VAST response is over max length");
                    }
                    a(q7.XML_PARSING);
                    return;
                }
                m8 m8VarB = b(string);
                if (m8VarB != null) {
                    a(m8VarB);
                    return;
                }
                if (com.applovin.impl.sdk.o.a()) {
                    this.c.b(this.b, "Unable to process XML: " + string);
                }
                c(string);
                a(q7.XML_PARSING);
            }
        }
    }

    private static final class d extends f6 {
        private final m8 i;

        d(m8 m8Var, p7 p7Var, AppLovinAdLoadListener appLovinAdLoadListener, com.applovin.impl.sdk.k kVar) {
            super(p7Var, appLovinAdLoadListener, kVar);
            if (m8Var == null) {
                throw new IllegalArgumentException("No response specified.");
            }
            if (p7Var == null) {
                throw new IllegalArgumentException("No context specified.");
            }
            if (appLovinAdLoadListener == null) {
                throw new IllegalArgumentException("No callback specified.");
            }
            this.i = m8Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (com.applovin.impl.sdk.o.a()) {
                this.c.a(this.b, "Processing VAST Wrapper response...");
            }
            a(this.i);
        }
    }

    f6(p7 p7Var, AppLovinAdLoadListener appLovinAdLoadListener, com.applovin.impl.sdk.k kVar) {
        super("TaskProcessVastResponse", kVar);
        if (p7Var == null) {
            throw new IllegalArgumentException("No context specified.");
        }
        this.g = appLovinAdLoadListener;
        this.h = (a) p7Var;
    }

    public static f6 a(JSONObject jSONObject, JSONObject jSONObject2, AppLovinAdLoadListener appLovinAdLoadListener, com.applovin.impl.sdk.k kVar) {
        return new c(new a(jSONObject, jSONObject2, kVar), appLovinAdLoadListener, kVar);
    }

    protected m8 b(String str) {
        try {
            return n8.a(str, this.f424a);
        } catch (Throwable th) {
            if (com.applovin.impl.sdk.o.a()) {
                this.c.a(this.b, "Failed to process VAST response", th);
            }
            a(q7.XML_PARSING);
            this.f424a.E().a(this.b, th);
            return null;
        }
    }

    protected void c(String str) {
        if (str == null) {
            return;
        }
        Iterator<String> it = StringUtils.getRegexMatches(StringUtils.match(str, (String) this.f424a.a(v4.Y4)), 1).iterator();
        while (it.hasNext()) {
            m8 m8VarB = b("<VAST>" + it.next() + "</VAST>");
            if (m8VarB != null) {
                this.h.a(m8VarB);
            }
        }
    }

    public static f6 a(String str, JSONObject jSONObject, JSONObject jSONObject2, AppLovinAdLoadListener appLovinAdLoadListener, com.applovin.impl.sdk.k kVar) {
        return new b(str, new a(jSONObject, jSONObject2, kVar), appLovinAdLoadListener, kVar);
    }

    public static f6 a(m8 m8Var, p7 p7Var, AppLovinAdLoadListener appLovinAdLoadListener, com.applovin.impl.sdk.k kVar) {
        return new d(m8Var, p7Var, appLovinAdLoadListener, kVar);
    }

    void a(m8 m8Var) {
        int iD = this.h.d();
        if (com.applovin.impl.sdk.o.a()) {
            this.c.a(this.b, "Finished parsing XML at depth " + iD);
        }
        this.h.a(m8Var);
        if (x7.b(m8Var)) {
            int iIntValue = ((Integer) this.f424a.a(v4.G4)).intValue();
            if (iD < iIntValue) {
                if (com.applovin.impl.sdk.o.a()) {
                    this.c.a(this.b, "VAST response is wrapper. Resolving...");
                }
                this.f424a.r0().a(new n6(this.h, this.g, this.f424a));
                return;
            }
            if (com.applovin.impl.sdk.o.a()) {
                this.c.b(this.b, "Reached beyond max wrapper depth of " + iIntValue);
            }
            a(q7.WRAPPER_LIMIT_REACHED);
            return;
        }
        if (x7.a(m8Var)) {
            if (com.applovin.impl.sdk.o.a()) {
                this.c.a(this.b, "VAST response is inline. Rendering ad...");
            }
            this.f424a.r0().a(new i6(this.h, this.g, this.f424a));
            return;
        }
        if (com.applovin.impl.sdk.o.a()) {
            this.c.b(this.b, "VAST response is an error");
        }
        a(q7.NO_WRAPPER_RESPONSE);
    }

    void a(q7 q7Var) {
        if (com.applovin.impl.sdk.o.a()) {
            this.c.b(this.b, "Failed to process VAST response due to VAST error code " + q7Var);
        }
        x7.a(this.h, this.g, q7Var, -6, this.f424a);
    }
}
