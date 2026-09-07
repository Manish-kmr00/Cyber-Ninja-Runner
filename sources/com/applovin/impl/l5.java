package com.applovin.impl;

import android.net.Uri;
import android.text.TextUtils;
import android.webkit.URLUtil;
import com.amazon.aps.shared.util.APSSharedUtil;
import com.applovin.impl.sdk.ad.AppLovinAdImpl;
import com.applovin.impl.sdk.utils.StringUtils;
import com.applovin.sdk.AppLovinAdLoadListener;
import java.util.ArrayList;
import java.util.Collections;

/* JADX INFO: loaded from: classes3.dex */
class l5 extends j5 {
    private final l7 q;

    class a implements e0.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ t7 f492a;

        a(t7 t7Var) {
            this.f492a = t7Var;
        }

        @Override // com.applovin.impl.e0.a
        public void a(Uri uri) {
            if (uri != null) {
                this.f492a.a(uri);
                l5.this.q.b(true);
                return;
            }
            com.applovin.impl.sdk.o oVar = l5.this.c;
            if (com.applovin.impl.sdk.o.a()) {
                l5 l5Var = l5.this;
                l5Var.c.b(l5Var.b, "Failed to cache static companion ad");
            }
        }
    }

    class b implements j5.e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ t7 f493a;

        b(t7 t7Var) {
            this.f493a = t7Var;
        }

        @Override // com.applovin.impl.j5.e
        public void a(String str) {
            this.f493a.a(str);
            l5.this.q.b(true);
        }
    }

    class c implements j5.e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ t7 f494a;

        c(t7 t7Var) {
            this.f494a = t7Var;
        }

        @Override // com.applovin.impl.j5.e
        public void a(String str) {
            this.f494a.a(str);
            l5.this.q.b(true);
        }
    }

    class d implements e0.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ z7 f495a;

        d(z7 z7Var) {
            this.f495a = z7Var;
        }

        @Override // com.applovin.impl.e0.a
        public void a(Uri uri) {
            if (uri != null) {
                com.applovin.impl.sdk.o oVar = l5.this.c;
                if (com.applovin.impl.sdk.o.a()) {
                    l5 l5Var = l5.this;
                    l5Var.c.a(l5Var.b, "Video file successfully cached into: " + uri);
                }
                this.f495a.a(uri);
                return;
            }
            com.applovin.impl.sdk.o oVar2 = l5.this.c;
            if (com.applovin.impl.sdk.o.a()) {
                l5 l5Var2 = l5.this;
                l5Var2.c.b(l5Var2.b, "Failed to cache video file: " + this.f495a);
            }
        }
    }

    class e implements j5.e {
        e() {
        }

        @Override // com.applovin.impl.j5.e
        public void a(String str) {
            if (l5.this.q.isOpenMeasurementEnabled()) {
                str = l5.this.f424a.e0().a(str, e2.a((AppLovinAdImpl) l5.this.g));
            }
            l5.this.q.d(str);
            com.applovin.impl.sdk.o oVar = l5.this.c;
            if (com.applovin.impl.sdk.o.a()) {
                l5 l5Var = l5.this;
                l5Var.c.a(l5Var.b, "Finish caching HTML template " + l5.this.q.u1() + " for ad #" + l5.this.q.getAdIdNumber());
            }
        }
    }

    public l5(l7 l7Var, com.applovin.impl.sdk.k kVar, AppLovinAdLoadListener appLovinAdLoadListener) {
        super("TaskCacheVastAd", l7Var, kVar, appLovinAdLoadListener);
        this.q = l7Var;
    }

    private String d(String str) {
        for (String str2 : StringUtils.getRegexMatches(StringUtils.match(str, (String) this.f424a.a(v4.X4)), 1)) {
            if (!TextUtils.isEmpty(str2)) {
                Uri uriA = a(str2, Collections.emptyList(), false);
                if (uriA != null) {
                    str = str.replace(str2, uriA.toString());
                    this.g.a(uriA);
                } else if (com.applovin.impl.sdk.o.a()) {
                    this.c.b(this.b, "Failed to cache JavaScript resource: " + str2);
                }
            }
        }
        return str;
    }

    private void m() {
        if (l()) {
            return;
        }
        if (!this.q.G1()) {
            if (com.applovin.impl.sdk.o.a()) {
                this.c.a(this.b, "Companion ad caching disabled. Skipping...");
                return;
            }
            return;
        }
        o7 o7VarS1 = this.q.s1();
        if (o7VarS1 == null) {
            if (com.applovin.impl.sdk.o.a()) {
                this.c.a(this.b, "No companion ad provided. Skipping...");
                return;
            }
            return;
        }
        t7 t7VarE = o7VarS1.e();
        if (t7VarE == null) {
            if (com.applovin.impl.sdk.o.a()) {
                this.c.b(this.b, "Failed to retrieve non-video resources from companion ad. Skipping...");
                return;
            }
            return;
        }
        Uri uriC = t7VarE.c();
        String string = uriC != null ? uriC.toString() : "";
        String strB = t7VarE.b();
        if (!URLUtil.isValidUrl(string) && !StringUtils.isValidString(strB)) {
            if (com.applovin.impl.sdk.o.a()) {
                this.c.k(this.b, "Companion ad does not have any resources attached. Skipping...");
                return;
            }
            return;
        }
        if (t7VarE.d() == t7.a.STATIC) {
            if (com.applovin.impl.sdk.o.a()) {
                this.c.a(this.b, "Caching static companion ad at " + string + APSSharedUtil.TRUNCATE_SEPARATOR);
            }
            Uri uriA = a(string, Collections.emptyList(), false);
            if (uriA != null) {
                t7VarE.a(uriA);
                this.q.b(true);
                return;
            } else {
                if (com.applovin.impl.sdk.o.a()) {
                    this.c.b(this.b, "Failed to cache static companion ad");
                    return;
                }
                return;
            }
        }
        if (t7VarE.d() != t7.a.HTML) {
            if (t7VarE.d() == t7.a.IFRAME && com.applovin.impl.sdk.o.a()) {
                this.c.a(this.b, "Skip caching of iFrame resource...");
                return;
            }
            return;
        }
        if (!StringUtils.isValidString(string)) {
            if (com.applovin.impl.sdk.o.a()) {
                this.c.a(this.b, "Caching provided HTML for companion ad. No fetch required. HTML: " + strB);
            }
            if (((Boolean) this.f424a.a(v4.W4)).booleanValue()) {
                strB = d(strB);
            }
            t7VarE.a(a(strB, Collections.emptyList(), this.q));
            this.q.b(true);
            return;
        }
        if (com.applovin.impl.sdk.o.a()) {
            this.c.a(this.b, "Begin caching HTML companion ad. Fetching from " + string + APSSharedUtil.TRUNCATE_SEPARATOR);
        }
        String strC = c(string, null, false);
        if (!StringUtils.isValidString(strC)) {
            if (com.applovin.impl.sdk.o.a()) {
                this.c.b(this.b, "Unable to load companion ad resources from " + string);
            }
        } else {
            if (com.applovin.impl.sdk.o.a()) {
                this.c.a(this.b, "HTML fetched. Caching HTML now...");
            }
            t7VarE.a(a(strC, Collections.emptyList(), this.q));
            this.q.b(true);
        }
    }

    private void n() {
        if (l() || !x7.a(this.q)) {
            return;
        }
        String strU1 = this.q.u1();
        if (!StringUtils.isValidString(strU1)) {
            if (com.applovin.impl.sdk.o.a()) {
                this.c.a(this.b, "Unable to load HTML template");
                return;
            }
            return;
        }
        String strA = a(strU1, this.q.c0(), this.g);
        if (this.q.isOpenMeasurementEnabled()) {
            strA = this.f424a.e0().a(strA, e2.a((AppLovinAdImpl) this.g));
        }
        this.q.d(strA);
        if (com.applovin.impl.sdk.o.a()) {
            this.c.a(this.b, "Finish caching HTML template " + this.q.u1() + " for ad #" + this.q.getAdIdNumber());
        }
    }

    private void o() {
        z7 z7VarC1;
        Uri uriE;
        if (l()) {
            return;
        }
        if (!this.q.H1()) {
            if (com.applovin.impl.sdk.o.a()) {
                this.c.a(this.b, "Video caching disabled. Skipping...");
            }
        } else {
            if (this.q.B1() == null || (z7VarC1 = this.q.C1()) == null || (uriE = z7VarC1.e()) == null) {
                return;
            }
            Uri uriB = b(uriE.toString(), Collections.emptyList(), false);
            if (uriB != null) {
                if (com.applovin.impl.sdk.o.a()) {
                    this.c.a(this.b, "Video file successfully cached into: " + uriB);
                }
                z7VarC1.a(uriB);
            } else if (com.applovin.impl.sdk.o.a()) {
                this.c.b(this.b, "Failed to cache video file: " + z7VarC1);
            }
        }
    }

    private c0 p() {
        if (!this.q.G1()) {
            if (com.applovin.impl.sdk.o.a()) {
                this.c.a(this.b, "Companion ad caching disabled. Skipping...");
            }
            return null;
        }
        o7 o7VarS1 = this.q.s1();
        if (o7VarS1 == null) {
            if (com.applovin.impl.sdk.o.a()) {
                this.c.a(this.b, "No companion ad provided. Skipping...");
            }
            return null;
        }
        t7 t7VarE = o7VarS1.e();
        if (t7VarE == null) {
            if (com.applovin.impl.sdk.o.a()) {
                this.c.b(this.b, "Failed to retrieve non-video resources from companion ad. Skipping...");
            }
            return null;
        }
        Uri uriC = t7VarE.c();
        String string = uriC != null ? uriC.toString() : "";
        String strB = t7VarE.b();
        if (URLUtil.isValidUrl(string) || StringUtils.isValidString(strB)) {
            if (t7VarE.d() == t7.a.STATIC) {
                if (com.applovin.impl.sdk.o.a()) {
                    this.c.a(this.b, "Caching static companion ad at " + string + APSSharedUtil.TRUNCATE_SEPARATOR);
                }
                return new e0(string, this.q, Collections.emptyList(), false, this.i, this.f424a, new a(t7VarE));
            }
            if (t7VarE.d() == t7.a.HTML) {
                if (!StringUtils.isValidString(string)) {
                    if (com.applovin.impl.sdk.o.a()) {
                        this.c.a(this.b, "Caching provided HTML for companion ad. No fetch required. HTML: " + strB);
                    }
                    return a(strB, Collections.emptyList(), new c(t7VarE));
                }
                if (com.applovin.impl.sdk.o.a()) {
                    this.c.a(this.b, "Begin caching HTML companion ad. Fetching from " + string + APSSharedUtil.TRUNCATE_SEPARATOR);
                }
                String strC = c(string, null, false);
                if (StringUtils.isValidString(strC)) {
                    if (com.applovin.impl.sdk.o.a()) {
                        this.c.a(this.b, "HTML fetched. Caching HTML now...");
                    }
                    return a(strC, Collections.emptyList(), new b(t7VarE));
                }
                if (com.applovin.impl.sdk.o.a()) {
                    this.c.b(this.b, "Unable to load companion ad resources from " + string);
                }
            } else if (t7VarE.d() == t7.a.IFRAME && com.applovin.impl.sdk.o.a()) {
                this.c.a(this.b, "Skip caching of iFrame resource...");
            }
        } else if (com.applovin.impl.sdk.o.a()) {
            this.c.k(this.b, "Companion ad does not have any resources attached. Skipping...");
        }
        return null;
    }

    @Override // com.applovin.impl.j5
    void f() {
        this.q.getAdEventTracker().h();
        super.f();
    }

    protected d0 q() {
        if (!TextUtils.isEmpty(this.q.u1())) {
            return a(this.q.u1(), this.q.c0(), new e());
        }
        if (!com.applovin.impl.sdk.o.a()) {
            return null;
        }
        this.c.a(this.b, "Unable to load HTML template");
        return null;
    }

    protected e0 r() {
        z7 z7VarC1;
        Uri uriE;
        if (!this.q.H1()) {
            if (com.applovin.impl.sdk.o.a()) {
                this.c.a(this.b, "Video caching disabled. Skipping...");
            }
            return null;
        }
        if (this.q.B1() == null || (z7VarC1 = this.q.C1()) == null || (uriE = z7VarC1.e()) == null) {
            return null;
        }
        if (com.applovin.impl.sdk.o.a()) {
            this.c.a(this.b, "Caching video file " + z7VarC1 + " creative...");
        }
        return a(uriE.toString(), Collections.emptyList(), false, new d(z7VarC1));
    }

    @Override // com.applovin.impl.j5, java.lang.Runnable
    public void run() {
        super.run();
        boolean zO0 = this.q.O0();
        if (com.applovin.impl.sdk.o.a()) {
            this.c.a(this.b, "Begin caching for VAST " + (zO0 ? "streaming " : "") + "ad #" + this.g.getAdIdNumber() + APSSharedUtil.TRUNCATE_SEPARATOR);
        }
        if (zO0) {
            if (((Boolean) this.f424a.a(v4.I0)).booleanValue()) {
                if (!o0.e()) {
                    a(e());
                }
                if (this.q.E1()) {
                    f();
                    ArrayList arrayList = new ArrayList();
                    c0 c0VarP = p();
                    if (c0VarP != null) {
                        arrayList.add(c0VarP);
                    }
                    d0 d0VarQ = q();
                    if (d0VarQ != null) {
                        arrayList.add(d0VarQ);
                    }
                    e0 e0VarR = r();
                    if (e0VarR != null) {
                        arrayList.add(e0VarR);
                    }
                    a(arrayList);
                } else {
                    ArrayList arrayList2 = new ArrayList();
                    ArrayList arrayList3 = new ArrayList();
                    if (this.q.v1() == l7.c.COMPANION_AD) {
                        c0 c0VarP2 = p();
                        if (c0VarP2 != null) {
                            arrayList2.add(c0VarP2);
                        }
                        d0 d0VarQ2 = q();
                        if (d0VarQ2 != null) {
                            arrayList2.add(d0VarQ2);
                        }
                        a(arrayList2);
                        f();
                        e0 e0VarR2 = r();
                        if (e0VarR2 != null) {
                            arrayList3.add(e0VarR2);
                        }
                        a(arrayList3);
                    } else {
                        e0 e0VarR3 = r();
                        if (e0VarR3 != null) {
                            arrayList2.add(e0VarR3);
                        }
                        a(arrayList2);
                        f();
                        c0 c0VarP3 = p();
                        if (c0VarP3 != null) {
                            arrayList3.add(c0VarP3);
                        }
                        d0 d0VarQ3 = q();
                        if (d0VarQ3 != null) {
                            arrayList3.add(d0VarQ3);
                        }
                        a(arrayList3);
                    }
                }
            } else {
                j();
                if (this.q.E1()) {
                    f();
                }
                l7.c cVarV1 = this.q.v1();
                l7.c cVar = l7.c.COMPANION_AD;
                if (cVarV1 == cVar) {
                    m();
                    n();
                    a(this.q);
                } else {
                    o();
                }
                if (!this.q.E1()) {
                    f();
                }
                if (this.q.v1() == cVar) {
                    o();
                } else {
                    m();
                    n();
                    a(this.q);
                }
            }
        } else if (((Boolean) this.f424a.a(v4.I0)).booleanValue()) {
            ArrayList arrayList4 = new ArrayList();
            if (!o0.e()) {
                arrayList4.addAll(e());
            }
            c0 c0VarP4 = p();
            if (c0VarP4 != null) {
                arrayList4.add(c0VarP4);
            }
            e0 e0VarR4 = r();
            if (e0VarR4 != null) {
                arrayList4.add(e0VarR4);
            }
            d0 d0VarQ4 = q();
            if (d0VarQ4 != null) {
                arrayList4.add(d0VarQ4);
            }
            a(arrayList4);
            f();
        } else {
            j();
            m();
            o();
            n();
            a(this.q);
            f();
        }
        if (com.applovin.impl.sdk.o.a()) {
            this.c.a(this.b, "Finished caching VAST ad #" + this.q.getAdIdNumber());
        }
        this.q.F1();
        k();
    }

    @Override // com.applovin.impl.j5
    void a(int i) {
        this.q.getAdEventTracker().f();
        super.a(i);
    }
}
