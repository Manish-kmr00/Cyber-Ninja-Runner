package com.applovin.impl;

import android.content.Context;
import android.text.SpannableString;
import android.text.SpannedString;
import android.text.TextUtils;
import android.text.style.AbsoluteSizeSpan;
import com.applovin.impl.sdk.utils.CollectionUtils;
import com.applovin.impl.sdk.utils.StringUtils;
import com.applovin.mediation.adapter.MaxAdapter;
import com.applovin.sdk.R;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes7.dex */
public class d3 extends p2 {
    private final b3 e;
    private List f;
    private final List g;
    private final List h;
    private final List i;
    private final List j;
    private SpannedString k;

    public enum a {
        INTEGRATIONS,
        PERMISSIONS,
        CONFIGURATION,
        DEPENDENCIES,
        TEST_ADS,
        COUNT
    }

    d3(b3 b3Var, Context context) {
        super(context);
        this.e = b3Var;
        if (b3Var.q() == b3.a.INVALID_INTEGRATION) {
            SpannableString spannableString = new SpannableString("Tap for more information");
            spannableString.setSpan(new AbsoluteSizeSpan(12, true), 0, spannableString.length(), 33);
            this.k = new SpannedString(spannableString);
        } else {
            this.k = new SpannedString("");
        }
        this.f = g();
        this.g = b(b3Var.n());
        this.h = e();
        this.i = a(b3Var.f());
        this.j = j();
        notifyDataSetChanged();
    }

    private o2 f() {
        if (this.e.I()) {
            return null;
        }
        return o2.a().d("Initialization Status").c(f(this.e.i())).a(false).a();
    }

    private List g() {
        ArrayList arrayList = new ArrayList(3);
        CollectionUtils.addObjectIfExists(i(), arrayList);
        CollectionUtils.addObjectIfExists(d(), arrayList);
        CollectionUtils.addObjectIfExists(f(), arrayList);
        return arrayList;
    }

    private o2 i() {
        o2.b bVarC = o2.a().d("SDK").c(this.e.p());
        if (TextUtils.isEmpty(this.e.p())) {
            bVarC.a(a(this.e.G())).b(b(this.e.G()));
        }
        return bVarC.a();
    }

    private List j() {
        ArrayList arrayList = new ArrayList(3);
        if (StringUtils.isValidString(this.e.v())) {
            arrayList.add(o2.a(o2.c.DETAIL).d(this.e.v()).a());
        }
        if (this.e.y() == b3.b.NOT_SUPPORTED) {
            return arrayList;
        }
        if (this.e.s() != null) {
            arrayList.add(c(this.e.s()));
        }
        arrayList.add(a(this.e.y()));
        return arrayList;
    }

    public boolean a(i2 i2Var) {
        return i2Var.b() == a.TEST_ADS.ordinal() && i2Var.a() == this.j.size() - 1;
    }

    @Override // com.applovin.impl.p2
    protected int b() {
        return a.COUNT.ordinal();
    }

    @Override // com.applovin.impl.p2
    protected List c(int i) {
        if (i == a.INTEGRATIONS.ordinal()) {
            return this.f;
        }
        if (i == a.PERMISSIONS.ordinal()) {
            return this.g;
        }
        if (i == a.CONFIGURATION.ordinal()) {
            return this.h;
        }
        return i == a.DEPENDENCIES.ordinal() ? this.i : this.j;
    }

    @Override // com.applovin.impl.p2
    protected int d(int i) {
        if (i == a.INTEGRATIONS.ordinal()) {
            return this.f.size();
        }
        if (i == a.PERMISSIONS.ordinal()) {
            return this.g.size();
        }
        if (i == a.CONFIGURATION.ordinal()) {
            return this.h.size();
        }
        return i == a.DEPENDENCIES.ordinal() ? this.i.size() : this.j.size();
    }

    @Override // com.applovin.impl.p2
    protected o2 e(int i) {
        if (i == a.INTEGRATIONS.ordinal()) {
            return new t4("INTEGRATIONS");
        }
        if (i == a.PERMISSIONS.ordinal()) {
            return new t4("PERMISSIONS");
        }
        if (i == a.CONFIGURATION.ordinal()) {
            return new t4("CONFIGURATION");
        }
        return i == a.DEPENDENCIES.ordinal() ? new t4("DEPENDENCIES") : new t4("TEST ADS");
    }

    public b3 h() {
        return this.e;
    }

    public void k() {
        this.f = g();
    }

    public String toString() {
        return "MediatedNetworkListAdapter{}";
    }

    private List a(List list) {
        ArrayList arrayList = new ArrayList(list.size());
        if (list.size() > 0) {
            Iterator it = list.iterator();
            while (it.hasNext()) {
                j1 j1Var = (j1) it.next();
                arrayList.add(a(j1Var.b(), j1Var.a(), j1Var.c(), true));
            }
        }
        return arrayList;
    }

    private List b(List list) {
        ArrayList arrayList = new ArrayList(list.size());
        if (list.size() > 0) {
            Iterator it = list.iterator();
            while (it.hasNext()) {
                m4 m4Var = (m4) it.next();
                arrayList.add(a(m4Var.b(), m4Var.a(), m4Var.c(), true));
            }
        }
        return arrayList;
    }

    private String f(int i) {
        if (MaxAdapter.InitializationStatus.INITIALIZED_SUCCESS.getCode() != i && MaxAdapter.InitializationStatus.INITIALIZED_UNKNOWN.getCode() != i && MaxAdapter.InitializationStatus.DOES_NOT_APPLY.getCode() != i) {
            if (MaxAdapter.InitializationStatus.INITIALIZED_FAILURE.getCode() == i) {
                return "Failure";
            }
            if (MaxAdapter.InitializationStatus.INITIALIZING.getCode() == i) {
                return "Initializing...";
            }
            return "Not Initialized";
        }
        return "Initialized";
    }

    private o2 a(b3.b bVar) {
        o2.b bVarA = o2.a();
        if (bVar == b3.b.READY) {
            bVarA.a(this.f577a);
        }
        return bVarA.d("Test Mode").c(bVar.c()).c(bVar.d()).b("Restart Required").a(bVar.b()).a(true).a();
    }

    private int b(boolean z) {
        return m0.a(z ? R.color.applovin_sdk_checkmarkColor : R.color.applovin_sdk_xmarkColor, this.f577a);
    }

    private o2 c(List list) {
        return o2.a().d("Region/VPN Required").c(CollectionUtils.implode(list, ", ", list.size())).a();
    }

    private o2 d() {
        o2.b bVarC = o2.a().d("Adapter").c(this.e.c());
        if (TextUtils.isEmpty(this.e.c())) {
            bVarC.a(a(this.e.A())).b(b(this.e.A()));
        }
        return bVarC.a();
    }

    private List e() {
        ArrayList arrayList = new ArrayList(1);
        if (this.e.E()) {
            arrayList.add(a("Java 8", "For optimal performance, please enable Java 8 support. See: https://developers.applovin.com/en/android/overview/integration", com.applovin.impl.sdk.k.G0(), true));
        }
        return arrayList;
    }

    private o2 a(String str, String str2, boolean z, boolean z2) {
        return o2.a(z ? o2.c.RIGHT_DETAIL : o2.c.DETAIL).d(str).a(z ? null : this.k).b("Instructions").a(str2).a(z ? R.drawable.applovin_ic_check_mark_bordered : c(z2)).b(z ? m0.a(R.color.applovin_sdk_checkmarkColor, this.f577a) : d(z2)).a(!z).a();
    }

    private int c(boolean z) {
        return z ? R.drawable.applovin_ic_x_mark : R.drawable.applovin_ic_warning;
    }

    private int d(boolean z) {
        return m0.a(z ? R.color.applovin_sdk_xmarkColor : R.color.applovin_sdk_warningColor, this.f577a);
    }

    private int a(boolean z) {
        return z ? R.drawable.applovin_ic_check_mark_bordered : R.drawable.applovin_ic_x_mark;
    }
}
