package com.applovin.impl;

import android.content.Context;
import android.text.TextUtils;
import com.applovin.communicator.AppLovinCommunicator;
import com.applovin.communicator.AppLovinCommunicatorMessage;
import com.applovin.communicator.AppLovinCommunicatorSubscriber;
import com.applovin.impl.sdk.utils.StringUtils;
import com.applovin.sdk.AppLovinSdk;
import com.applovin.sdk.AppLovinSdkConfiguration;
import com.applovin.sdk.AppLovinSdkUtils;
import com.applovin.sdk.R;
import com.facebook.internal.AnalyticsEvents;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.UByte$$ExternalSyntheticBackport0;

/* JADX INFO: loaded from: classes3.dex */
public class l3 extends p2 implements AppLovinCommunicatorSubscriber, b0.a {
    private List A;
    private List B;
    private List C;
    private List D;
    private List E;
    private com.applovin.impl.sdk.k e;
    private List f;
    private List g;
    private List h;
    private List i;
    private String j;
    private String k;
    private String l;
    private boolean m;
    private final StringBuilder n;
    private final AtomicBoolean o;
    private boolean p;
    private List q;
    private List r;
    private List s;
    private List t;
    private List u;
    private List v;
    private List w;
    private List x;
    private List y;
    private List z;

    static /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f486a;

        static {
            int[] iArr = new int[b0.b.values().length];
            f486a = iArr;
            try {
                iArr[b0.b.APP_DETAILS_NOT_FOUND.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f486a[b0.b.INVALID_DEVELOPER_URI.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f486a[b0.b.APPADSTXT_NOT_FOUND.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f486a[b0.b.MISSING_APPLOVIN_ENTRIES.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f486a[b0.b.MISSING_NON_APPLOVIN_ENTRIES.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
        }
    }

    public enum b {
        AD_UNITS,
        SELECT_LIVE_NETWORKS,
        SELECT_TEST_MODE_NETWORKS,
        INITIALIZATION_AD_UNITS,
        COUNT
    }

    private enum c {
        SUCCESS,
        WARNING,
        ERROR
    }

    public enum d {
        CMP,
        NETWORK_CONSENT_STATUSES,
        DO_NOT_SELL,
        COUNT
    }

    public enum e {
        APP_INFO,
        MAX,
        PRIVACY,
        ADS,
        INCOMPLETE_NETWORKS,
        MICRO_SDK_PARTNER_NETWORKS,
        COMPLETED_NETWORKS,
        MISSING_NETWORKS,
        COUNT
    }

    public l3(Context context) {
        super(context);
        this.n = new StringBuilder("");
        this.o = new AtomicBoolean();
        this.q = new ArrayList();
        this.r = new ArrayList();
        this.s = new ArrayList();
        this.t = new ArrayList();
        this.u = new ArrayList();
        this.v = new ArrayList();
        this.w = new ArrayList();
        this.x = new ArrayList();
        this.y = new ArrayList();
        this.z = new ArrayList();
        this.A = new ArrayList();
        this.B = new ArrayList();
        this.C = new ArrayList();
        this.D = new ArrayList();
        this.E = new ArrayList();
    }

    private List g() {
        boolean zC = this.e.t0().c();
        List listB = this.e.t0().b();
        return zC ? a((String) null, a(listB, false)) : a(a(listB, true), (String) null);
    }

    private List j() {
        String str;
        ArrayList arrayList = new ArrayList(7);
        try {
            str = this.f577a.getPackageManager().getPackageInfo(this.f577a.getPackageName(), 0).versionName;
        } catch (Throwable unused) {
            str = null;
        }
        arrayList.add(o2.a().d("Package Name").c(this.f577a.getPackageName()).a());
        o2.b bVarD = o2.a().d("App Version");
        if (!StringUtils.isValidString(str)) {
            str = "None";
        }
        arrayList.add(bVarD.c(str).a());
        arrayList.add(o2.a().d(com.moloco.sdk.acm.b.d).c(k7.d()).a());
        arrayList.add(o2.a().d("Account").c(StringUtils.isValidString(this.l) ? this.l : "None").a());
        arrayList.add(o2.a().d("Mediation Provider").c(StringUtils.isValidString(this.e.V()) ? this.e.V() : "None").a());
        arrayList.add(o2.a().d("OM SDK Version").c(this.e.e0().c()).a());
        arrayList.add(a(com.applovin.impl.sdk.k.G0()));
        return arrayList;
    }

    private o2 l() {
        String strD = this.e.s0().d();
        boolean zIsValidString = StringUtils.isValidString(strD);
        boolean zIsValidString2 = StringUtils.isValidString(this.e.s0().j());
        o2.b bVarD = o2.a(o2.c.DETAIL).d("CMP (Consent Management Platform)");
        if (!zIsValidString) {
            strD = zIsValidString2 ? AnalyticsEvents.PARAMETER_DIALOG_OUTCOME_VALUE_UNKNOWN : "None";
        }
        o2.b bVarC = bVarD.c(strD);
        if (this.m) {
            bVarC.a(true);
            if (zIsValidString2) {
                bVarC.a(this.f577a);
            } else {
                bVarC.b("TC Data Not Found");
                bVarC.a("By January 16, 2024, if you use Google AdMob or Google Ad Manager, you must also use a Google-certified CMP. Test your app in EEA and UK regions to ensure that this warning doesn't appear in those regions.\n\nFor more details, see:\nhttps://support.google.com/admob/answer/13554116");
                boolean z = this.e.w().getConsentFlowUserGeography() == AppLovinSdkConfiguration.ConsentFlowUserGeography.GDPR;
                bVarC.a(z ? R.drawable.applovin_ic_x_mark : R.drawable.applovin_ic_warning);
                bVarC.b(m0.a(z ? R.color.applovin_sdk_xmarkColor : R.color.applovin_sdk_warningColor, this.f577a));
            }
        }
        return bVarC.a();
    }

    private o2 m() {
        return o2.a().d("MAX Terms and Privacy Policy Flow").a(this.f577a).a(true).a();
    }

    private o2 n() {
        boolean zHasSupportedCmp = this.e.t().hasSupportedCmp();
        return o2.a().d("Google UMP SDK").a(zHasSupportedCmp ? R.drawable.applovin_ic_check_mark_bordered : R.drawable.applovin_ic_x_mark).b(m0.a(zHasSupportedCmp ? R.color.applovin_sdk_checkmarkColor : R.color.applovin_sdk_xmarkColor, this.f577a)).b("Google UMP SDK").a("In order to use MAX Terms and Privacy Policy Flow, you must add the Google User Messaging Platform SDK as a dependency.\n\nFor more details, see:\nhttps://developers.applovin.com/en/android/overview/terms-and-privacy-policy-flow").a(!zHasSupportedCmp).a();
    }

    private List q() {
        ArrayList arrayList = new ArrayList(7);
        arrayList.add(o2.a().d("SDK Version").c(AppLovinSdk.VERSION).a());
        String str = (String) this.e.a(v4.I3);
        o2.b bVarD = o2.a().d("Plugin Version");
        if (!StringUtils.isValidString(str)) {
            str = "None";
        }
        arrayList.add(bVarD.c(str).a());
        arrayList.add(e());
        if (this.e.I0()) {
            String strA = k7.a(this.e.o0());
            arrayList.add(b("Unity Version", StringUtils.isValidString(strA) ? strA : "None"));
        }
        if (this.e.y().j()) {
            arrayList.add(m());
            arrayList.add(n());
        } else if (this.e.y().l()) {
            arrayList.add(u());
        }
        return arrayList;
    }

    private o2 r() {
        return o2.a().d("Network Consent Statuses").a(this.f577a).a(true).a();
    }

    private List s() {
        ArrayList arrayList = new ArrayList(d.COUNT.ordinal());
        arrayList.add(l());
        if (StringUtils.isValidString(this.e.s0().j())) {
            arrayList.add(r());
        } else {
            arrayList.add(new p4(p0.b(), false, this.f577a));
        }
        arrayList.add(new p4(p0.a(), true, this.f577a));
        return arrayList;
    }

    private o2 u() {
        return o2.a().d("Terms Flow").a(R.drawable.applovin_ic_x_mark).b(m0.a(R.color.applovin_sdk_xmarkColor, this.f577a)).b("Terms Flow has been replaced").a(this.e.y().g()).a(true).a();
    }

    private void z() {
        StringBuilder sb = new StringBuilder("\n========== MEDIATION DEBUGGER ==========");
        sb.append("\n========== APP INFO ==========");
        sb.append("\nDev Build - " + k7.c(this.e));
        sb.append("\nTest Mode - ".concat(this.e.t0().c() ? "enabled" : "disabled"));
        sb.append("\nTarget SDK - " + this.e.B().E().get("target_sdk"));
        sb.append("\n========== MAX ==========");
        String str = AppLovinSdk.VERSION;
        String str2 = (String) this.e.a(v4.I3);
        String strB = j.b();
        sb.append("\nSDK Version - " + str);
        StringBuilder sb2 = new StringBuilder("\nPlugin Version - ");
        if (!StringUtils.isValidString(str2)) {
            str2 = "None";
        }
        sb.append(sb2.append(str2).toString());
        StringBuilder sb3 = new StringBuilder("\nAd Review Version - ");
        if (!StringUtils.isValidString(strB)) {
            strB = "Disabled";
        }
        sb.append(sb3.append(strB).toString());
        if (this.e.I0()) {
            String strA = k7.a(this.e.o0());
            sb.append("\nUnity Version - " + (StringUtils.isValidString(strA) ? strA : "None"));
        }
        sb.append("\n========== PRIVACY ==========");
        sb.append(p0.a(this.f577a));
        sb.append(this.e.y().e());
        sb.append("\n========== CMP (CONSENT MANAGEMENT PLATFORM) ==========");
        sb.append(this.e.s0().i());
        sb.append("\n========== NETWORK CONSENT STATUSES ==========");
        Iterator it = d().iterator();
        while (it.hasNext()) {
            sb.append(((x6) it.next()).e());
        }
        sb.append("\n========== NETWORKS ==========");
        Iterator it2 = this.r.iterator();
        while (it2.hasNext()) {
            a(sb, ((b3) it2.next()).j());
        }
        Iterator it3 = this.s.iterator();
        while (it3.hasNext()) {
            a(sb, ((b3) it3.next()).j());
        }
        Iterator it4 = this.q.iterator();
        while (it4.hasNext()) {
            a(sb, ((b3) it4.next()).j());
        }
        sb.append("\n========== AD UNITS ==========");
        Iterator it5 = this.g.iterator();
        while (it5.hasNext()) {
            a(sb, ((n) it5.next()).e());
        }
        sb.append("\n========== END ==========");
        com.applovin.impl.sdk.o.g("MediationDebuggerListAdapter", sb.toString());
        this.n.append(sb.toString());
    }

    public boolean a(o2 o2Var) {
        if (o2Var.k() == null) {
            return false;
        }
        return "MAX Terms and Privacy Policy Flow".equals(o2Var.k().toString());
    }

    public void b(boolean z) {
        this.p = z;
    }

    @Override // com.applovin.impl.p2
    protected List c(int i) {
        if (i == e.APP_INFO.ordinal()) {
            return this.x;
        }
        if (i == e.MAX.ordinal()) {
            return this.y;
        }
        if (i == e.PRIVACY.ordinal()) {
            return this.z;
        }
        if (i == e.ADS.ordinal()) {
            return this.A;
        }
        if (i == e.INCOMPLETE_NETWORKS.ordinal()) {
            return this.B;
        }
        if (i == e.MICRO_SDK_PARTNER_NETWORKS.ordinal()) {
            return this.C;
        }
        return i == e.COMPLETED_NETWORKS.ordinal() ? this.D : this.E;
    }

    public List d() {
        ArrayList<x6> arrayList = new ArrayList();
        Iterator it = this.f.iterator();
        while (it.hasNext()) {
            arrayList.add(((b3) it.next()).t());
        }
        String strK = this.e.s0().k();
        if (strK != null) {
            String strC = this.e.s0().c();
            for (x6 x6Var : arrayList) {
                if (x6Var.f() == x6.a.TCF_VENDOR && x6Var.d() != null) {
                    x6Var.a(Boolean.valueOf(z6.a(strK, x6Var.d().intValue() - 1)));
                } else if (x6Var.f() == x6.a.ATP_NETWORK && x6Var.d() != null) {
                    x6Var.a(z6.a(x6Var.d().intValue(), strC));
                }
            }
        } else {
            Iterator it2 = arrayList.iterator();
            while (it2.hasNext()) {
                ((x6) it2.next()).a(null);
            }
        }
        return arrayList;
    }

    @Override // com.applovin.impl.p2
    protected o2 e(int i) {
        if (i == e.APP_INFO.ordinal()) {
            return new t4("APP INFO");
        }
        if (i == e.MAX.ordinal()) {
            return new t4("MAX");
        }
        if (i == e.PRIVACY.ordinal()) {
            return new t4("PRIVACY");
        }
        if (i == e.ADS.ordinal()) {
            return new t4("ADS");
        }
        if (i == e.INCOMPLETE_NETWORKS.ordinal()) {
            return new t4("INCOMPLETE SDK INTEGRATIONS");
        }
        if (i == e.MICRO_SDK_PARTNER_NETWORKS.ordinal()) {
            return new t4("APPLOVIN MICRO SDK PARTNERS");
        }
        return i == e.COMPLETED_NETWORKS.ordinal() ? new t4("COMPLETED SDK INTEGRATIONS") : new t4("MISSING SDK INTEGRATIONS");
    }

    public List f() {
        return this.g;
    }

    @Override // com.applovin.communicator.AppLovinCommunicatorEntity
    public String getCommunicatorId() {
        return "MediationDebuggerListAdapter";
    }

    public String h() {
        return this.k;
    }

    public String i() {
        return this.j;
    }

    public List k() {
        return this.u;
    }

    public List o() {
        return this.h;
    }

    @Override // com.applovin.communicator.AppLovinCommunicatorSubscriber
    public void onMessageReceived(AppLovinCommunicatorMessage appLovinCommunicatorMessage) {
        if ("privacy_setting_updated".equals(appLovinCommunicatorMessage.getTopic())) {
            this.z = s();
            c();
            return;
        }
        if ("network_sdk_version_updated".equals(appLovinCommunicatorMessage.getTopic())) {
            this.B = a(this.q);
            this.C = a(this.r);
            this.D = a(this.s);
            c();
            return;
        }
        if ("live_networks_updated".equals(appLovinCommunicatorMessage.getTopic())) {
            this.A = a(a((List) appLovinCommunicatorMessage.getMessageData().getStringArrayList("live_networks"), true), (String) null);
            c();
        } else if ("test_mode_networks_updated".equals(appLovinCommunicatorMessage.getTopic())) {
            this.A = a((String) null, a((List) appLovinCommunicatorMessage.getMessageData().getStringArrayList("test_mode_networks"), false));
            c();
        }
    }

    public String p() {
        return this.n.toString();
    }

    public com.applovin.impl.sdk.k t() {
        return this.e;
    }

    public String toString() {
        return "MediationDebuggerListAdapter{isInitialized=" + this.o.get() + "}";
    }

    public List v() {
        return this.w;
    }

    public List w() {
        return this.v;
    }

    public boolean x() {
        return this.p;
    }

    public boolean y() {
        return this.o.get();
    }

    @Override // com.applovin.impl.p2
    protected int b() {
        return e.COUNT.ordinal();
    }

    private void b(List list) {
        HashSet hashSet = new HashSet();
        HashSet hashSet2 = new HashSet();
        Iterator it = list.iterator();
        while (it.hasNext()) {
            o oVarF = ((n) it.next()).f();
            Iterator it2 = oVarF.a().iterator();
            while (it2.hasNext()) {
                hashSet.add(((f8) it2.next()).b());
            }
            Iterator it3 = oVarF.e().iterator();
            while (it3.hasNext()) {
                hashSet2.add(((f8) it3.next()).b());
            }
        }
        this.u = new ArrayList(hashSet);
        this.v = new ArrayList(hashSet2);
        Collections.sort(this.u);
        Collections.sort(this.v);
    }

    public void a(List list, List list2, List list3, List list4, String str, String str2, String str3, boolean z, com.applovin.impl.sdk.k kVar) {
        this.e = kVar;
        this.f = list;
        this.g = list2;
        this.h = list3;
        this.i = list4;
        this.j = str;
        this.k = str2;
        this.l = str3;
        this.m = z;
        if (list != null && this.o.compareAndSet(false, true)) {
            kVar.O();
            if (com.applovin.impl.sdk.o.a()) {
                kVar.O().a("MediationDebuggerListAdapter", "Populating networks...");
            }
            c(list);
            b(list2);
            d(this.s);
            this.x.addAll(j());
            this.y.addAll(q());
            this.z.addAll(s());
            this.A.addAll(g());
            this.B = a(this.q);
            this.C = a(this.r);
            this.D = a(this.s);
            this.E = a(this.t);
            ArrayList arrayList = new ArrayList(3);
            arrayList.add("privacy_setting_updated");
            arrayList.add("network_sdk_version_updated");
            arrayList.add("live_networks_updated");
            arrayList.add("test_mode_networks_updated");
            AppLovinCommunicator.getInstance(this.f577a).subscribe(this, arrayList);
            z();
        }
        AppLovinSdkUtils.runOnUiThread(new Runnable() { // from class: com.applovin.impl.l3$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.notifyDataSetChanged();
            }
        });
    }

    private o2 b(String str, String str2) {
        o2.b bVarD = o2.a().d(str);
        if (StringUtils.isValidString(str2)) {
            bVarD.c(str2);
        } else {
            bVarD.a(R.drawable.applovin_ic_x_mark);
            bVarD.b(m0.a(R.color.applovin_sdk_xmarkColor, this.f577a));
        }
        return bVarD.a();
    }

    @Override // com.applovin.impl.p2
    protected int d(int i) {
        if (i == e.APP_INFO.ordinal()) {
            return this.x.size();
        }
        if (i == e.MAX.ordinal()) {
            return this.y.size();
        }
        if (i == e.PRIVACY.ordinal()) {
            return this.z.size();
        }
        if (i == e.ADS.ordinal()) {
            return this.A.size();
        }
        if (i == e.INCOMPLETE_NETWORKS.ordinal()) {
            return this.B.size();
        }
        if (i == e.MICRO_SDK_PARTNER_NETWORKS.ordinal()) {
            return this.C.size();
        }
        if (i == e.COMPLETED_NETWORKS.ordinal()) {
            return this.D.size();
        }
        return this.E.size();
    }

    private void c(List list) {
        Iterator it = list.iterator();
        while (it.hasNext()) {
            b3 b3Var = (b3) it.next();
            if (!b3Var.H()) {
                if (b3Var.q() != b3.a.INCOMPLETE_INTEGRATION && b3Var.q() != b3.a.INVALID_INTEGRATION) {
                    if (b3Var.q() == b3.a.COMPLETE) {
                        if (b3Var.z()) {
                            this.r.add(b3Var);
                        } else {
                            this.s.add(b3Var);
                        }
                    } else if (b3Var.q() == b3.a.MISSING) {
                        this.t.add(b3Var);
                    }
                } else if (b3Var.z()) {
                    this.r.add(b3Var);
                } else {
                    this.q.add(b3Var);
                }
            }
        }
    }

    private o2 e() {
        String str;
        o2.b bVarD = o2.a().d("Ad Review Version");
        String strB = j.b();
        if (StringUtils.isValidString(strB)) {
            String strA = j.a();
            if (!StringUtils.isValidString(strA) || strA.equals(this.e.j0())) {
                str = null;
            } else {
                str = "MAX Ad Review integrated with wrong SDK key. Please check that your " + (this.e.I0() ? "SDK key is downloaded" : "Gradle plugin snippet is integrated") + " from the correct account.";
            }
        } else {
            str = "Integrating MAX Ad review is OPTIONAL. This feature gives developers unprecedented transparency into the creatives the users see in their apps.";
        }
        if (str != null) {
            bVarD.b("MAX Ad Review").a(str).a(R.drawable.applovin_ic_x_mark).b(m0.a(R.color.applovin_sdk_xmarkColor, this.f577a)).a(true);
        } else {
            bVarD.c(strB);
        }
        return bVarD.a();
    }

    private o2 b(String str) {
        o2.b bVarA = o2.a();
        if (this.e.t0().c()) {
            bVarA.a(this.f577a);
        }
        o2.b bVarD = bVarA.d((StringUtils.isValidString(str) ? "" : "Select ").concat("Test Mode Network"));
        if (!this.e.t0().c()) {
            str = "Enable";
        }
        return bVarD.c(str).c(-16776961).a("Please re-launch the app to enable test mode. This will allow the selection of test mode networks.").a(true).a();
    }

    @Override // com.applovin.impl.b0.a
    public void a(z zVar, String str) {
        String strA;
        c cVarA;
        c cVar;
        String str2;
        List<a0> listA = b0.a(zVar, this.i);
        if (listA.isEmpty()) {
            str2 = "All required entries found at " + str + ".";
            cVar = c.SUCCESS;
        } else {
            a0 a0Var = null;
            for (a0 a0Var2 : listA) {
                this.e.O();
                if (com.applovin.impl.sdk.o.a()) {
                    this.e.O().b("MediationDebuggerListAdapter", str + " is missing a required entry: " + a0Var2.d());
                }
                if (a0Var2.g()) {
                    a0Var = a0Var2;
                }
            }
            if (a0Var != null) {
                b0.b bVar = b0.b.MISSING_APPLOVIN_ENTRIES;
                strA = a(bVar, str, a0Var.d());
                cVarA = a(bVar);
            } else {
                b0.b bVar2 = b0.b.MISSING_NON_APPLOVIN_ENTRIES;
                strA = a(bVar2, str, null);
                cVarA = a(bVar2);
            }
            String str3 = strA;
            cVar = cVarA;
            str2 = str3;
        }
        this.y.add(a(str2, cVar));
        c();
    }

    private void d(List list) {
        Iterator it = list.iterator();
        while (it.hasNext()) {
            b3 b3Var = (b3) it.next();
            if (b3Var.y() == b3.b.READY) {
                this.w.add(b3Var);
            }
        }
    }

    @Override // com.applovin.impl.b0.a
    public void a(b0.b bVar, String str) {
        if (bVar == b0.b.APP_DETAILS_NOT_FOUND) {
            this.e.O();
            if (com.applovin.impl.sdk.o.a()) {
                this.e.O().a("MediationDebuggerListAdapter", "Could not retrieve app details for this package name; app-ads.txt row will not show on the mediation debugger.");
                return;
            }
            return;
        }
        this.y.add(a(a(bVar, str, null), a(bVar)));
        c();
    }

    private void a(StringBuilder sb, String str) {
        String string = sb.toString();
        if (string.length() + str.length() >= ((Integer) this.e.a(v4.r)).intValue()) {
            com.applovin.impl.sdk.o.g("MediationDebuggerListAdapter", string);
            this.n.append(string);
            sb.setLength(1);
        }
        sb.append(str);
    }

    private List a(String str, String str2) {
        ArrayList arrayList = new ArrayList(3);
        arrayList.add(o2.a().d("View Ad Units (" + this.g.size() + ")").a(this.f577a).a(true).a());
        arrayList.add(a(str));
        arrayList.add(b(str2));
        if (!this.h.isEmpty()) {
            arrayList.add(o2.a().d("Selective Init Ad Units (" + this.h.size() + ")").a(this.f577a).a(true).a());
        }
        arrayList.add(o2.a().d("Test Mode Enabled").c(String.valueOf(this.e.t0().c())).a());
        return arrayList;
    }

    private List a(List list) {
        ArrayList arrayList = new ArrayList(list.size());
        Iterator it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(new w3((b3) it.next(), this.f577a));
        }
        return arrayList;
    }

    private o2 a(String str) {
        o2.b bVarA = o2.a();
        if (!this.e.t0().c()) {
            bVarA.a(this.f577a);
        }
        o2.b bVarD = bVarA.d((StringUtils.isValidString(str) ? "" : "Select ").concat("Live Network"));
        if (this.e.t0().c()) {
            str = "Enable";
        }
        return bVarD.c(str).c(-16776961).a("Ad loads are not supported while Test Mode is enabled. Please restart the app and make sure your GAID has not been enabled for test mode and that you are not on an emulator.").a(true).a();
    }

    private o2 a(boolean z) {
        return o2.a().d("Java 8").a(z ? R.drawable.applovin_ic_check_mark_bordered : R.drawable.applovin_ic_x_mark).b(m0.a(z ? R.color.applovin_sdk_checkmarkColor : R.color.applovin_sdk_xmarkColor, this.f577a)).b("Upgrade to Java 8").a("For optimal performance, please enable Java 8 support. This will be required in a future SDK release. See: https://developers.applovin.com/en/android/overview/integration").a(!z).a();
    }

    private o2 a(String str, c cVar) {
        int i;
        int iA;
        if (cVar == c.SUCCESS) {
            i = R.drawable.applovin_ic_check_mark_bordered;
            iA = m0.a(R.color.applovin_sdk_checkmarkColor, this.f577a);
        } else if (cVar == c.WARNING) {
            i = R.drawable.applovin_ic_warning;
            iA = m0.a(R.color.applovin_sdk_warningColor, this.f577a);
        } else {
            i = R.drawable.applovin_ic_x_mark;
            iA = m0.a(R.color.applovin_sdk_xmarkColor, this.f577a);
        }
        return o2.a().d("app-ads.txt").a(i).b(iA).b("app-ads.txt").a(str).a(true).a();
    }

    private String a(b0.b bVar, String str, String str2) {
        if (TextUtils.isEmpty(str)) {
            str = "app-ads.txt URL";
        }
        int i = a.f486a[bVar.ordinal()];
        if (i == 1) {
            return "Could not retrieve app details from the Play Store for this package name. Check back once this app has been published on the Play Store.";
        }
        if (i == 2) {
            return "Unable to find a valid developer URL from the Play Store listing.";
        }
        if (i == 3) {
            return "Unable to find app-ads.txt file or parse entries of the file at " + str + ".\n\nFor more information, please visit Account -> App-Ads.txt Info at:\nhttps://dash.applovin.com/o/account?r=2#app_ads_txt";
        }
        if (i == 4) {
            return "Text file at " + str + " is missing the required AppLovin line:\n\n" + str2 + "\n\nFor more information, please visit Account -> App-Ads.txt Info at:\nhttps://dash.applovin.com/o/account?r=2#app_ads_txt";
        }
        if (i != 5) {
            return "";
        }
        return "Text file at " + str + " is missing some of the suggested lines.\n\nFor more information, please visit Account -> App-Ads.txt Info at:\nhttps://dash.applovin.com/o/account?r=2#app_ads_txt";
    }

    private c a(b0.b bVar) {
        int i = a.f486a[bVar.ordinal()];
        if (i == 1 || i == 2 || i == 3 || i == 4) {
            return c.ERROR;
        }
        if (i != 5) {
            return c.ERROR;
        }
        return c.WARNING;
    }

    private String a(List list, boolean z) {
        if (list == null || list.isEmpty()) {
            return null;
        }
        if (z) {
            for (r2 r2Var : this.u) {
                if (list.equals(r2Var.b())) {
                    return r2Var.a();
                }
            }
            for (r2 r2Var2 : this.v) {
                if (list.equals(r2Var2.b())) {
                    return r2Var2.a();
                }
            }
        } else {
            for (b3 b3Var : this.w) {
                if (list.equals(b3Var.u())) {
                    return b3Var.g();
                }
            }
        }
        return UByte$$ExternalSyntheticBackport0.m(io.appmetrica.analytics.coreutils.internal.StringUtils.COMMA, list);
    }
}
