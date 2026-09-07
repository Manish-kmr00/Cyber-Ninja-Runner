package com.json;

import android.content.Context;
import android.text.TextUtils;
import android.util.Base64;
import com.json.mediationsdk.IronSource;
import com.json.mediationsdk.IronSourceSegment;
import com.json.mediationsdk.events.ISErrorListener;
import com.json.mediationsdk.logger.IronLog;
import com.json.mediationsdk.p;
import com.json.mediationsdk.utils.IronSourceConstants;
import com.json.mediationsdk.utils.IronSourceUtils;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes9.dex */
public abstract class s7 implements rf {
    private int[] A;
    private int[] B;
    private int[] C;
    int G;
    String H;
    String I;
    Set<Integer> J;
    private bc K;
    private IronSourceSegment L;
    private ms M;
    private ISErrorListener N;
    private boolean l;
    private da p;
    private com.json.e q;
    private ArrayList<zb> r;
    private int t;
    private xh u;
    private Context v;
    private int[] z;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final int f4262a = 1;
    final int b = 100;
    final int c = 5000;
    final int d = 90000;
    final int e = 1024;
    final int f = 5;
    final String g = "supersonic_sdk.db";
    final String h = IronSourceConstants.EVENTS_PROVIDER;
    final String i = "placement";
    private final String j = fe.K0;
    private final String k = "mt";
    private boolean m = false;
    private boolean n = false;
    private int o = -1;
    private boolean s = true;
    private int w = 100;
    private int x = 5000;
    private int y = 1;
    private Map<String, String> D = new HashMap();
    private Map<String, String> E = new HashMap();
    private String F = "";
    private final Object O = new Object();

    class a implements Runnable {
        a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            s7.this.a();
        }
    }

    class b implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ zb f4264a;
        final /* synthetic */ IronSource.AD_UNIT b;

        b(zb zbVar, IronSource.AD_UNIT ad_unit) {
            this.f4264a = zbVar;
            this.b = ad_unit;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.f4264a.a("eventSessionId", s7.this.u.b());
            this.f4264a.a("essn", Integer.valueOf(s7.this.u.getSessionNumber()));
            String connectionType = IronSourceUtils.getConnectionType(s7.this.v);
            if (s7.this.g(this.f4264a)) {
                this.f4264a.a(b9.i.t, connectionType);
            }
            if (s7.this.a(connectionType, this.f4264a)) {
                zb zbVar = this.f4264a;
                zbVar.a(s7.this.b(zbVar));
            }
            String strD = y8.d(s7.this.v);
            if (strD != null) {
                this.f4264a.a(b9.i.u, strD);
            }
            int iA = s7.this.a(this.f4264a.c(), this.b);
            if (iA != e.NOT_SUPPORTED.a()) {
                this.f4264a.a("adUnit", Integer.valueOf(iA));
            }
            s7.this.a(this.f4264a, "reason");
            s7.this.a(this.f4264a, IronSourceConstants.EVENTS_EXT1);
            if (!s7.this.E.isEmpty()) {
                for (Map.Entry entry : s7.this.E.entrySet()) {
                    if (!this.f4264a.b().has((String) entry.getKey()) && entry.getKey() != "eventId" && entry.getKey() != "timestamp") {
                        this.f4264a.a((String) entry.getKey(), entry.getValue());
                    }
                }
            }
            if (s7.this.i(this.f4264a)) {
                if (s7.this.h(this.f4264a) && !s7.this.e(this.f4264a)) {
                    this.f4264a.a("sessionDepth", Integer.valueOf(s7.this.c(this.f4264a)));
                }
                if (s7.this.j(this.f4264a)) {
                    s7.this.f(this.f4264a);
                }
                long jA = s7.this.u.getFirstSessionTimestamp();
                if (jA > 0) {
                    this.f4264a.a("firstSessionTimestamp", Long.valueOf(jA));
                }
                IronLog.EVENT.verbose(this.f4264a.toString());
                s7.this.r.add(this.f4264a);
                s7.d(s7.this);
            }
            s7 s7Var = s7.this;
            boolean zA = s7Var.a(s7Var.B) ? s7.this.a(this.f4264a.c(), s7.this.B) : s7.this.d(this.f4264a);
            if (!s7.this.m && zA) {
                s7.this.m = true;
            }
            if (s7.this.p != null) {
                if (s7.this.g()) {
                    s7.this.f();
                    return;
                }
                s7 s7Var2 = s7.this;
                if (s7Var2.b((ArrayList<zb>) s7Var2.r) || zA) {
                    s7.this.a();
                }
            }
        }
    }

    class c implements sf {
        c() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void b(sf.a aVar) {
            try {
                if (aVar.c()) {
                    ArrayList<zb> arrayListA = s7.this.p.a(s7.this.I);
                    s7.this.t = arrayListA.size() + s7.this.r.size();
                } else {
                    IronLog.INTERNAL.error("Failed to send events. Saving them back to storage.");
                    s7.this.a(s7.this.a(aVar.b(), aVar.a()));
                }
            } catch (Exception e) {
                o9.d().a(e);
                if (s7.this.N != null) {
                    s7.this.N.onError(new IllegalStateException("Error on sending data ", e));
                }
            }
            a(aVar.b());
        }

        @Override // com.json.sf
        public synchronized void a(final sf.a aVar) {
            s7.this.K.a(new Runnable() { // from class: com.ironsource.s7$c$$ExternalSyntheticLambda0
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.b(aVar);
                }
            });
        }

        public void a(ArrayList<zb> arrayList) {
            if (arrayList != null) {
                try {
                    arrayList.clear();
                } catch (Exception e) {
                    o9.d().a(e);
                    IronLog.INTERNAL.error("clearData exception: " + e.getMessage());
                }
            }
        }
    }

    class d implements Runnable {
        d() {
        }

        @Override // java.lang.Runnable
        public void run() {
            s7.this.f();
        }
    }

    public enum e {
        NOT_SUPPORTED(-1),
        INTERSTITIAL(2),
        REWARDED_VIDEO(3),
        NATIVE_AD(4),
        BANNER(8);


        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private int f4267a;

        e(int i) {
            this.f4267a = i;
        }

        public int a() {
            return this.f4267a;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int a(int i, IronSource.AD_UNIT ad_unit) {
        e eVar;
        int iA = e.NOT_SUPPORTED.a();
        if (ad_unit == IronSource.AD_UNIT.REWARDED_VIDEO || ((i >= 1000 && i < 2000) || (i >= 91000 && i < 92000))) {
            eVar = e.REWARDED_VIDEO;
        } else if (ad_unit == IronSource.AD_UNIT.INTERSTITIAL || ((i >= 2000 && i < 3000) || (i >= 92000 && i < 93000))) {
            eVar = e.INTERSTITIAL;
        } else if (ad_unit == IronSource.AD_UNIT.BANNER || ((i >= 3000 && i < 4000) || (i >= 93000 && i < 94000))) {
            eVar = e.BANNER;
        } else {
            if (ad_unit != IronSource.AD_UNIT.NATIVE_AD && ((i < 4000 || i >= 5000) && (i < 94000 || i >= 95000))) {
                return iA;
            }
            eVar = e.NATIVE_AD;
        }
        return eVar.a();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public ArrayList<zb> a(ArrayList<zb> arrayList, String str) {
        String strA = a(str, 1024);
        Iterator<zb> it = arrayList.iterator();
        while (it.hasNext()) {
            it.next().a(strA);
        }
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a() {
        synchronized (this.O) {
            this.p.a(this.r, this.I);
            this.r.clear();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(zb zbVar, String str) {
        a(zbVar, str, 1024);
    }

    private void a(zb zbVar, String str, int i) {
        JSONObject jSONObjectB = zbVar.b();
        if (jSONObjectB == null || !jSONObjectB.has(str)) {
            return;
        }
        try {
            zbVar.a(str, a(jSONObjectB.optString(str, null), i));
        } catch (Exception e2) {
            o9.d().a(e2);
            IronLog.INTERNAL.error(e2.toString());
        }
    }

    private void a(JSONObject jSONObject) {
        try {
            IronSourceSegment ironSourceSegment = this.L;
            if (ironSourceSegment != null) {
                if (ironSourceSegment.getAge() > 0) {
                    jSONObject.put("age", this.L.getAge());
                }
                if (!TextUtils.isEmpty(this.L.getGender())) {
                    jSONObject.put(IronSourceSegment.GENDER, this.L.getGender());
                }
                if (this.L.getLevel() > 0) {
                    jSONObject.put("lvl", this.L.getLevel());
                }
                if (this.L.getIsPaying() != null) {
                    jSONObject.put(IronSourceSegment.PAYING, this.L.getIsPaying().get());
                }
                if (this.L.getIapt() > 0.0d) {
                    jSONObject.put(IronSourceSegment.IAPT, this.L.getIapt());
                }
                if (this.L.getUcd() > 0) {
                    jSONObject.put(IronSourceSegment.USER_CREATION_DATE, this.L.getUcd());
                }
            }
            ms msVar = this.M;
            if (msVar != null) {
                String strB = msVar.b();
                if (!TextUtils.isEmpty(strB)) {
                    jSONObject.put("segmentId", strB);
                }
                JSONObject jSONObjectA = this.M.a();
                Iterator<String> itKeys = jSONObjectA.keys();
                while (itKeys.hasNext()) {
                    String next = itKeys.next();
                    jSONObject.put(next, jSONObjectA.get(next));
                }
            }
        } catch (JSONException e2) {
            o9.d().a(e2);
            IronLog.INTERNAL.error(e2.toString());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean a(int i, int[] iArr) {
        if (!a(iArr)) {
            return false;
        }
        for (int i2 : iArr) {
            if (i == i2) {
                return true;
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized boolean a(String str, zb zbVar) {
        if (str.equalsIgnoreCase("none")) {
            return a(this.C) ? a(zbVar.c(), this.C) : this.J.contains(Integer.valueOf(zbVar.c()));
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean a(int[] iArr) {
        return iArr != null && iArr.length > 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized int b(zb zbVar) {
        return zbVar.c() + 90000;
    }

    private void b(String str) {
        com.json.e eVar = this.q;
        if (eVar == null || !eVar.c().equals(str)) {
            this.q = gc.a(str, this.G);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean b(ArrayList<zb> arrayList) {
        return arrayList != null && arrayList.size() >= this.y;
    }

    static /* synthetic */ int d(s7 s7Var) {
        int i = s7Var.t;
        s7Var.t = i + 1;
        return i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean e(zb zbVar) {
        JSONObject jSONObjectB = zbVar.b();
        if (jSONObjectB == null) {
            return false;
        }
        return jSONObjectB.has("sessionDepth");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    public void f() {
        ArrayList<zb> arrayListA;
        try {
            this.m = false;
            ArrayList<zb> arrayList = new ArrayList<>();
            try {
                synchronized (this.O) {
                    arrayListA = this.p.a(this.I);
                    this.p.b(this.I);
                }
                dc.c cVar = new dc.c(new dc.a(arrayListA, this.r), this.x);
                this.p.a(cVar.a(), this.I);
                arrayList.addAll(cVar.b());
            } catch (Throwable th) {
                o9.d().a(th);
                IronLog.INTERNAL.error("CombinedEventList exception: " + th.getMessage());
                ISErrorListener iSErrorListener = this.N;
                if (iSErrorListener != null) {
                    iSErrorListener.onError(new IllegalStateException("Combined event exception: ", th));
                }
                arrayList.clear();
                arrayList.addAll(this.r);
            }
            if (arrayList.size() > 0) {
                this.r.clear();
                this.t = 0;
                JSONObject jSONObjectB = ce.a().b();
                try {
                    a(jSONObjectB);
                    String strB = b();
                    if (!TextUtils.isEmpty(strB)) {
                        jSONObjectB.put(fe.K0, strB);
                    }
                    String strQ = p.m().q();
                    if (!TextUtils.isEmpty(strQ)) {
                        jSONObjectB.put("mt", strQ);
                    }
                    Map<String, String> mapC = c();
                    if (!mapC.isEmpty()) {
                        for (Map.Entry<String, String> entry : mapC.entrySet()) {
                            if (!jSONObjectB.has(entry.getKey())) {
                                jSONObjectB.put(entry.getKey(), entry.getValue());
                            }
                        }
                    }
                    JSONObject jSONObjectA = new ic().a();
                    Iterator<String> itKeys = jSONObjectA.keys();
                    while (itKeys.hasNext()) {
                        String next = itKeys.next();
                        jSONObjectB.put(next, jSONObjectA.get(next));
                    }
                } catch (Throwable th2) {
                    o9.d().a(th2);
                    IronLog.INTERNAL.error("Exception while building the event general properties: " + th2.getMessage());
                }
                String strA = this.q.a(arrayList, jSONObjectB);
                if (TextUtils.isEmpty(strA)) {
                    IronLog.INTERNAL.error("Failed to parse events.");
                    ISErrorListener iSErrorListener2 = this.N;
                    if (iSErrorListener2 != null) {
                        iSErrorListener2.onError(new IllegalStateException("Event parse failed"));
                        return;
                    }
                    return;
                }
                if (this.n) {
                    try {
                        strA = Base64.encodeToString(xj.a(strA, this.o), 0);
                    } catch (Exception e2) {
                        o9.d().a(e2);
                        ISErrorListener iSErrorListener3 = this.N;
                        if (iSErrorListener3 != null) {
                            iSErrorListener3.onError(new IllegalStateException("Error on compression: ", e2));
                        }
                    }
                }
                wt.f4570a.a(new jc(new c(), strA, this.q.b(), arrayList));
            }
        } catch (Throwable th3) {
            o9.d().a(th3);
            IronLog.INTERNAL.error("Send event exception: " + th3.getMessage());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean g() {
        return (this.t >= this.w || this.m) && this.l;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean i(zb zbVar) {
        if (zbVar == null) {
            return false;
        }
        if (a(this.z)) {
            return true ^ a(zbVar.c(), this.z);
        }
        if (a(this.A)) {
            return a(zbVar.c(), this.A);
        }
        return true;
    }

    String a(String str, int i) {
        return (TextUtils.isEmpty(str) || str.length() <= i) ? str : str.substring(0, i);
    }

    @Override // com.json.rf
    public void a(int i) {
        if (i > 0) {
            this.x = i;
        }
    }

    public synchronized void a(Context context, IronSourceSegment ironSourceSegment) {
        String defaultEventsFormatterType = IronSourceUtils.getDefaultEventsFormatterType(context, this.I, this.H);
        this.H = defaultEventsFormatterType;
        b(defaultEventsFormatterType);
        this.q.a(IronSourceUtils.getDefaultEventsURL(context, this.I, null));
        this.p = da.a(context, "supersonic_sdk.db", 5);
        this.K.a(new a());
        this.z = IronSourceUtils.getDefaultOptOutEvents(context, this.I);
        this.A = IronSourceUtils.getDefaultOptInEvents(context, this.I);
        this.B = IronSourceUtils.getDefaultTriggerEvents(context, this.I);
        this.C = IronSourceUtils.getDefaultNonConnectivityEvents(context, this.I);
        this.L = ironSourceSegment;
        this.v = context;
    }

    public void a(IronSourceSegment ironSourceSegment) {
        this.L = ironSourceSegment;
    }

    public void a(ISErrorListener iSErrorListener) {
        this.N = iSErrorListener;
    }

    public synchronized void a(ms msVar) {
        this.M = msVar;
    }

    @Override // com.json.rf
    public synchronized void a(zb zbVar) {
        a(zbVar, (IronSource.AD_UNIT) null);
    }

    public synchronized void a(zb zbVar, IronSource.AD_UNIT ad_unit) {
        if (zbVar != null) {
            if (this.s) {
                this.K.a(new b(zbVar, ad_unit));
            }
        }
    }

    void a(Runnable runnable) {
        this.K.a(runnable);
    }

    public void a(String str) {
        this.F = str;
    }

    @Override // com.json.rf
    public void a(String str, Context context) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        this.H = str;
        IronSourceUtils.saveDefaultEventsFormatterType(context, this.I, str);
        b(str);
    }

    protected void a(ArrayList<zb> arrayList) {
        if (arrayList != null) {
            synchronized (this.O) {
                this.p.a(arrayList, this.I);
                this.t = this.p.a(this.I).size() + this.r.size();
            }
        }
    }

    public void a(Map<String, String> map) {
        this.D.putAll(map);
    }

    public void a(Map<String, Object> map, int i, String str) {
        map.put(IronSourceConstants.AUCTION_TRIALS, Integer.valueOf(i));
        if (TextUtils.isEmpty(str)) {
            return;
        }
        map.put(IronSourceConstants.AUCTION_FALLBACK, str);
    }

    @Override // com.json.rf
    public void a(boolean z) {
        this.n = z;
    }

    @Override // com.json.rf
    public void a(int[] iArr, Context context) {
        this.A = iArr;
        IronSourceUtils.saveDefaultOptInEvents(context, this.I, iArr);
    }

    public String b() {
        return this.F;
    }

    @Override // com.json.rf
    public void b(int i) {
        if (i > 0) {
            this.w = i;
        }
    }

    @Override // com.json.rf
    public void b(String str, Context context) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        com.json.e eVar = this.q;
        if (eVar != null) {
            eVar.a(str);
        }
        IronSourceUtils.saveDefaultEventsURL(context, this.I, str);
    }

    public void b(Map<String, String> map) {
        this.E.putAll(map);
    }

    @Override // com.json.rf
    public void b(boolean z) {
        this.s = z;
    }

    @Override // com.json.rf
    public void b(int[] iArr, Context context) {
        this.B = iArr;
        IronSourceUtils.saveDefaultTriggerEvents(context, this.I, iArr);
    }

    protected abstract int c(zb zbVar);

    public Map<String, String> c() {
        return this.D;
    }

    @Override // com.json.rf
    public void c(int i) {
        if (i > 0) {
            this.y = i;
        }
    }

    public void c(boolean z) {
        this.l = z;
    }

    @Override // com.json.rf
    public void c(int[] iArr, Context context) {
        this.z = iArr;
        IronSourceUtils.saveDefaultOptOutEvents(context, this.I, iArr);
    }

    abstract void d();

    @Override // com.json.rf
    public void d(int i) {
        this.o = i;
    }

    @Override // com.json.rf
    public void d(int[] iArr, Context context) {
        this.C = iArr;
        IronSourceUtils.saveDefaultNonConnectivityEvents(context, this.I, iArr);
    }

    protected abstract boolean d(zb zbVar);

    protected abstract String e(int i);

    void e() {
        this.r = new ArrayList<>();
        this.t = 0;
        this.q = gc.a(this.H, this.G);
        bc bcVar = new bc(this.I + "EventThread");
        this.K = bcVar;
        bcVar.start();
        this.K.a();
        this.u = mm.S().h();
        this.J = new HashSet();
        d();
    }

    protected int f(int i) {
        return a(i, (IronSource.AD_UNIT) null);
    }

    protected abstract void f(zb zbVar);

    protected boolean g(zb zbVar) {
        return (zbVar.c() == 40 || zbVar.c() == 41 || zbVar.c() == 50 || zbVar.c() == 51 || zbVar.c() == 52) ? false : true;
    }

    public void h() {
        this.K.a(new d());
    }

    protected boolean h(zb zbVar) {
        return (zbVar.c() == 14 || zbVar.c() == 114 || zbVar.c() == 514 || zbVar.c() == 515 || zbVar.c() == 516 || zbVar.c() == 140 || zbVar.c() == 40 || zbVar.c() == 41 || zbVar.c() == 50 || zbVar.c() == 51 || zbVar.c() == 52) ? false : true;
    }

    protected abstract boolean j(zb zbVar);
}
