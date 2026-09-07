package com.applovin.impl;

import com.applovin.sdk.AppLovinAdLoadListener;
import com.smaato.sdk.video.vast.model.ViewableImpression;
import java.util.HashSet;

/* JADX INFO: loaded from: classes3.dex */
class i6 extends g5 {
    private final p7 g;
    private final AppLovinAdLoadListener h;

    i6(p7 p7Var, AppLovinAdLoadListener appLovinAdLoadListener, com.applovin.impl.sdk.k kVar) {
        super("TaskRenderVastAd", kVar);
        this.h = appLovinAdLoadListener;
        this.g = p7Var;
    }

    @Override // java.lang.Runnable
    public void run() {
        if (com.applovin.impl.sdk.o.a()) {
            this.c.a(this.b, "Rendering VAST ad...");
        }
        int size = this.g.a().size();
        HashSet hashSet = new HashSet(size);
        HashSet hashSet2 = new HashSet(size);
        String strA = "";
        u7 u7VarA = null;
        y7 y7VarA = null;
        o7 o7VarA = null;
        n7 n7VarA = null;
        String strA2 = "";
        for (m8 m8Var : this.g.a()) {
            m8 m8VarB = m8Var.b(x7.b(m8Var) ? "Wrapper" : "InLine");
            if (m8VarB != null) {
                m8 m8VarB2 = m8VarB.b("AdSystem");
                if (m8VarB2 != null) {
                    u7VarA = u7.a(m8VarB2, u7VarA, this.f424a);
                }
                strA = x7.a(m8VarB, "AdTitle", strA);
                strA2 = x7.a(m8VarB, "Description", strA2);
                x7.a(m8VarB.a("Impression"), hashSet, this.g, this.f424a);
                m8 m8VarC = m8VarB.c("ViewableImpression");
                if (m8VarC != null) {
                    x7.a(m8VarC.a(ViewableImpression.VIEWABLE), hashSet, this.g, this.f424a);
                }
                m8 m8VarB3 = m8VarB.b("AdVerifications");
                if (m8VarB3 != null) {
                    n7VarA = n7.a(m8VarB3, n7VarA, this.g, this.f424a);
                }
                x7.a(m8VarB.a("Error"), hashSet2, this.g, this.f424a);
                m8 m8VarC2 = m8VarB.c("Creatives");
                if (m8VarC2 != null) {
                    for (m8 m8Var2 : m8VarC2.b()) {
                        m8 m8VarC3 = m8Var2.c("Linear");
                        if (m8VarC3 != null) {
                            y7VarA = y7.a(m8VarC3, y7VarA, this.g, this.f424a);
                        } else {
                            m8 m8VarB4 = m8Var2.b("CompanionAds");
                            if (m8VarB4 != null) {
                                m8 m8VarB5 = m8VarB4.b("Companion");
                                if (m8VarB5 != null) {
                                    o7VarA = o7.a(m8VarB5, o7VarA, this.g, this.f424a);
                                }
                            } else if (com.applovin.impl.sdk.o.a()) {
                                this.c.b(this.b, "Received and will skip rendering for an unidentified creative: " + m8Var2);
                            }
                        }
                    }
                }
            } else if (com.applovin.impl.sdk.o.a()) {
                this.c.b(this.b, "Did not find wrapper or inline response for node: " + m8Var);
            }
        }
        l7 l7VarA = new l7.b().a(this.f424a).a(this.g.b()).b(this.g.e()).a(this.g.c()).b(strA).a(strA2).a(u7VarA).a(y7VarA).a(o7VarA).a(n7VarA).b(hashSet).a(n7VarA).a(hashSet2).a();
        q7 q7VarC = x7.c(l7VarA);
        if (q7VarC != null) {
            x7.a(this.g, this.h, q7VarC, -6, this.f424a);
            return;
        }
        if (com.applovin.impl.sdk.o.a()) {
            this.c.a(this.b, "Finished rendering VAST ad: " + l7VarA);
        }
        l7VarA.getAdEventTracker().e();
        this.f424a.r0().a((g5) new l5(l7VarA, this.f424a, this.h), b6.b.CACHING);
    }
}
