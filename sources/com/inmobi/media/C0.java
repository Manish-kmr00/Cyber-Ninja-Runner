package com.inmobi.media;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import android.util.Log;
import android.util.SparseArray;
import android.widget.TextView;
import androidx.browser.customtabs.CustomTabsClient;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.recyclerview.widget.RecyclerView;
import com.amazon.aps.shared.metrics.model.ApsMetricsDataMap;
import com.facebook.share.internal.ShareConstants;
import com.iab.omid.library.inmobi.Omid;
import com.iab.omid.library.inmobi.adsession.AdSessionContext;
import com.iab.omid.library.inmobi.adsession.ImpressionType;
import com.iab.omid.library.inmobi.adsession.VerificationScriptResource;
import com.inmobi.adquality.models.AdQualityControl;
import com.inmobi.ads.AdMetaInfo;
import com.inmobi.ads.InMobiAdRequestStatus;
import com.inmobi.ads.WatermarkData;
import com.inmobi.commons.core.configs.AdConfig;
import com.inmobi.commons.core.configs.Config;
import com.inmobi.commons.core.configs.TelemetryConfig;
import com.inmobi.unification.sdk.model.Initialization.TimeoutConfigurations$ABConfig;
import com.inmobi.unification.sdk.model.Initialization.TimeoutConfigurations$AdABConfig;
import com.inmobi.unification.sdk.model.Initialization.TimeoutConfigurations$AdNonABConfig;
import com.inmobi.unification.sdk.model.Initialization.TimeoutConfigurations$AdPreloadConfig;
import com.inmobi.unification.sdk.model.Initialization.TimeoutConfigurations$MediationConfig;
import com.inmobi.unification.sdk.model.Initialization.TimeoutConfigurations$NonABConfig;
import com.inmobi.unification.sdk.model.Initialization.TimeoutConfigurations$PreloadConfig;
import io.appmetrica.analytics.coreutils.internal.StringUtils;
import java.io.UnsupportedEncodingException;
import java.lang.ref.WeakReference;
import java.net.URL;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.BitSet;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Timer;
import java.util.TreeSet;
import java.util.UUID;
import java.util.concurrent.ScheduledExecutorService;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.text.StringsKt;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes5.dex */
public abstract class C0 extends Da implements L1, InterfaceC3346dc, Pc, K {
    public static final /* synthetic */ int L = 0;
    public boolean A;
    public String B;
    public final C3575u C;
    public C3645z D;
    public C3525q5 E;
    public E6 F;
    public final Handler G;
    public final LinkedHashMap H;
    public final E0 I;
    public WatermarkData J;
    public final C3590v0 K;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public byte f3036a;
    public AdConfig b;
    public WeakReference c;
    public C3460lc d;
    public C3462m0 e;
    public WeakReference f;
    public ArrayList g;
    public C3313b7 h;
    public HashMap i;
    public L4 j;
    public byte k;
    public Handler l;
    public boolean m;
    public Ba n;
    public boolean o;
    public boolean p;
    public boolean q;
    public boolean r;
    public C3343d9 s;
    public J t;
    public C3418j0 u;
    public C3374fc v;
    public int w;
    public int x;
    public long y;
    public TreeSet z;

    public C0(Context context, J adPlacement, AbstractC3520q0 abstractC3520q0) {
        Boolean boolO;
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(adPlacement, "adPlacement");
        this.g = new ArrayList();
        this.y = -1L;
        this.z = new TreeSet();
        this.C = C3575u.f3438a;
        this.G = new Handler(Looper.getMainLooper());
        this.H = new LinkedHashMap();
        this.I = new E0(this);
        this.K = new C3590v0(this);
        Intrinsics.checkNotNullExpressionValue("C0", "TAG");
        toString();
        this.c = new WeakReference(context);
        this.t = adPlacement;
        WeakReference weakReference = new WeakReference(abstractC3520q0);
        this.f = weakReference;
        String strQ = q();
        C3418j0 c3418j0 = this.u;
        this.D = new C3645z(weakReference, strQ, (c3418j0 == null || (boolO = c3418j0.o()) == null) ? false : boolO.booleanValue());
        n0();
    }

    public static /* synthetic */ void R() {
    }

    public static /* synthetic */ void U() {
    }

    public static final /* synthetic */ String e() {
        return "C0";
    }

    public final int A() {
        return this.x;
    }

    public long A0() {
        L4 l4 = this.j;
        if (l4 != null) {
            ((M4) l4).c("C0", AbstractC3492o0.a("C0", "TAG", "timeSincePodShow ", this));
        }
        if (this.A) {
            return System.currentTimeMillis() - this.y;
        }
        return -1L;
    }

    public final TreeSet<Integer> B() {
        return this.z;
    }

    public final Qc B0() {
        L4 l4 = this.j;
        if (l4 != null) {
            ((M4) l4).c("C0", AbstractC3492o0.a("C0", "TAG", "trySetTheLocalVideoDescriptor ", this));
        }
        C3389h c3389hM = m();
        if (c3389hM == null) {
            throw new IllegalStateException("No ad");
        }
        if (!(c3389hM instanceof C3356e8)) {
            return null;
        }
        C3356e8 c3356e8 = (C3356e8) c3389hM;
        C3417j c3417jB = AbstractC3415ib.a().b(c3356e8.f3301a);
        if (c3417jB == null || !c3417jB.a()) {
            throw new IllegalStateException("Asset not available in cache");
        }
        String str = c3417jB.c;
        String str2 = c3356e8.b;
        String str3 = c3356e8.c;
        ArrayList arrayList = c3356e8.d;
        ArrayList arrayList2 = c3356e8.e;
        AdConfig adConfig = this.b;
        Intrinsics.checkNotNull(adConfig);
        return new Qc(str, str2, str3, arrayList, arrayList2, adConfig.getVastVideo());
    }

    public final long C() {
        return this.y;
    }

    public final Handler D() {
        return this.l;
    }

    public final String E() {
        String strU;
        L4 l4 = this.j;
        if (l4 != null) {
            ((M4) l4).c("C0", AbstractC3492o0.a("C0", "TAG", "markupType getter ", this));
        }
        C3389h c3389hM = m();
        return (c3389hM == null || (strU = c3389hM.u()) == null) ? "unknown" : strU;
    }

    public Integer F() {
        return null;
    }

    public final C3313b7 G() {
        return this.h;
    }

    public final C3343d9 H() {
        return this.s;
    }

    public final J I() {
        return this.t;
    }

    public abstract byte J();

    public String K() {
        L4 l4 = this.j;
        if (l4 != null) {
            ((M4) l4).c("C0", AbstractC3492o0.a("C0", "TAG", "getPodAdContext ", this));
        }
        if (this.A) {
            return this.B;
        }
        return null;
    }

    public final String L() {
        return c(0);
    }

    public final Map<String, String> M() {
        return this.t.f();
    }

    public JSONArray N() {
        L4 l4 = this.j;
        if (l4 != null) {
            ((M4) l4).c("C0", AbstractC3492o0.a("C0", "TAG", "getRenderableAdIndexes ", this));
        }
        JSONArray jSONArray = new JSONArray();
        for (Integer num : this.z) {
            Intrinsics.checkNotNull(num);
            jSONArray.put(num.intValue());
        }
        return jSONArray;
    }

    public long O() {
        L4 l4 = this.j;
        if (l4 != null) {
            ((M4) l4).c("C0", AbstractC3492o0.a("C0", "TAG", "getShowTimeStamp ", this));
        }
        if (this.A) {
            return this.y;
        }
        return -1L;
    }

    public final Unit P() {
        AbstractC3520q0 abstractC3520q0R = r();
        long jCurrentTimeMillis = System.currentTimeMillis();
        if (a(abstractC3520q0R, jCurrentTimeMillis)) {
            return Unit.INSTANCE;
        }
        this.r = true;
        if (this.s == null) {
            this.s = new C3343d9(this);
        }
        C3575u c3575u = this.C;
        int iHashCode = hashCode();
        Y3 y3 = new Y3(this, jCurrentTimeMillis, this.j);
        c3575u.getClass();
        C3575u.a(iHashCode, y3);
        return Unit.INSTANCE;
    }

    public final byte Q() {
        return this.f3036a;
    }

    public final String S() {
        LinkedList<C3389h> linkedListF;
        C3389h c3389h;
        String strW;
        C3418j0 c3418j0 = this.u;
        return (c3418j0 == null || (linkedListF = c3418j0.f()) == null || (c3389h = (C3389h) CollectionsKt.firstOrNull((List) linkedListF)) == null || (strW = c3389h.w()) == null) ? "" : strW;
    }

    public final byte T() {
        return this.k;
    }

    public final void V() {
        L4 l4 = this.j;
        if (l4 != null) {
            ((M4) l4).c("C0", AbstractC3492o0.a("C0", "TAG", "handleInterActive ", this));
        }
        C3575u c3575u = this.C;
        int iHashCode = hashCode();
        C3576u0 c3576u0 = new C3576u0(this);
        c3575u.getClass();
        C3575u.a(iHashCode, c3576u0);
    }

    public final boolean W() {
        L4 l4 = this.j;
        if (l4 != null) {
            ((M4) l4).c("C0", AbstractC3492o0.a("C0", "TAG", "hasAdExpired ", this));
        }
        C3389h c3389hM = m();
        if (c3389hM == null) {
            return false;
        }
        AdConfig adConfig = this.b;
        Intrinsics.checkNotNull(adConfig);
        return c3389hM.a(adConfig.getCacheConfig(q()).getTimeToLive());
    }

    public final boolean X() {
        AdConfig.RenderingConfig rendering;
        AdConfig adConfig = this.b;
        return adConfig != null && (rendering = adConfig.getRendering()) != null && rendering.getEnablePubMuteControl() && C3517pb.o();
    }

    public final boolean Y() {
        L4 l4 = this.j;
        if (l4 != null) {
            Intrinsics.checkNotNullExpressionValue("C0", "TAG");
            ((M4) l4).c("C0", "isBlockingStateForLoadWithResponse getter " + this + " state=" + ((int) this.f3036a));
        }
        if (!X3.f3234a.a()) {
            g();
            b(new InMobiAdRequestStatus(InMobiAdRequestStatus.StatusCode.GDPR_COMPLIANCE_ENFORCED), true, (short) 2141);
            return true;
        }
        if (f0()) {
            L4 l5 = this.j;
            if (l5 != null) {
                ((M4) l5).b("C0", O5.a("C0", "TAG", "Some of the dependency libraries for ").append(q()).append(" not found").toString());
            }
            b(new InMobiAdRequestStatus(InMobiAdRequestStatus.StatusCode.MISSING_REQUIRED_DEPENDENCIES), true, (short) 2007);
            return true;
        }
        byte b = this.f3036a;
        if (b == 1) {
            L4 l6 = this.j;
            if (l6 != null) {
                Intrinsics.checkNotNullExpressionValue("C0", "TAG");
                ((M4) l6).b("C0", "load with reasponse called while loading");
            }
            b(new InMobiAdRequestStatus(InMobiAdRequestStatus.StatusCode.LOAD_WITH_RESPONSE_CALLED_WHILE_LOADING), false, (short) 2001);
            return true;
        }
        if (b != 7) {
            return false;
        }
        L4 l7 = this.j;
        if (l7 != null) {
            Intrinsics.checkNotNullExpressionValue("C0", "TAG");
            ((M4) l7).b("C0", "ad active before load");
        }
        b(new InMobiAdRequestStatus(InMobiAdRequestStatus.StatusCode.AD_ACTIVE), false, (short) 2003);
        return true;
    }

    public final boolean Z() {
        return this.o;
    }

    @Override // com.inmobi.media.K
    public abstract /* synthetic */ void a(int i, Ba ba);

    @Override // com.inmobi.media.Da
    public void a(Ba renderView, boolean z) {
        Intrinsics.checkNotNullParameter(renderView, "renderView");
        Intrinsics.checkNotNullParameter(renderView, "renderView");
        L4 l4 = this.j;
        if (l4 != null) {
            Intrinsics.checkNotNullExpressionValue("C0", "TAG");
            ((M4) l4).c("C0", "onRenderProcessGone didCrash=" + z + " state=" + ((int) this.f3036a));
        }
        byte b = this.f3036a;
        if (b == 0) {
            short s = z ? (short) 2214 : (short) 2213;
            m0();
            renderView.a(z, s);
            return;
        }
        if (b == 1) {
            short s2 = z ? (short) 2216 : (short) 2215;
            m0();
            b(s2);
            AbstractC3520q0 abstractC3520q0R = r();
            if (abstractC3520q0R != null) {
                abstractC3520q0R.a(new InMobiAdRequestStatus(InMobiAdRequestStatus.StatusCode.INTERNAL_ERROR));
                return;
            }
            return;
        }
        if (b == 3) {
            renderView.a(z, z ? (short) 2226 : (short) 2225);
            return;
        }
        if (b == 2) {
            m0();
            b(z ? (short) 2218 : (short) 2217);
            AbstractC3520q0 abstractC3520q0R2 = r();
            if (abstractC3520q0R2 != null) {
                abstractC3520q0R2.a(this, new InMobiAdRequestStatus(InMobiAdRequestStatus.StatusCode.INTERNAL_ERROR));
            }
        }
    }

    public final boolean a0() {
        return this.m;
    }

    @Override // com.inmobi.media.K
    public abstract /* synthetic */ void b();

    public final boolean b0() {
        return this.A;
    }

    public final String c(int i) {
        L4 l4 = this.j;
        if (l4 != null) {
            ((M4) l4).c("C0", AbstractC3492o0.a("C0", "TAG", "getPubContent ", this));
        }
        if (i > 0 && !this.A) {
            return "";
        }
        C3389h c3389hA = a(i);
        if (c3389hA != null) {
            return c3389hA.x();
        }
        return null;
    }

    public void c0() {
        L4 l4 = this.j;
        if (l4 != null) {
            ((M4) l4).c("C0", AbstractC3492o0.a("C0", "TAG", "load  ", this));
        }
        E0 e0 = this.I;
        e0.getClass();
        e0.c = SystemClock.elapsedRealtime();
        a(new C3604w0(this), new C3618x0(this));
    }

    public final void d(byte b) {
        L4 l4 = this.j;
        if (l4 != null) {
            ((M4) l4).d("C0", O5.a("C0", "TAG", "from ").append((int) this.f3036a).append(" to ").append((int) b).append(' ').append(this).toString());
        }
        this.f3036a = b;
    }

    /* JADX WARN: Code duplicated, block: B:40:0x00bf  */
    /* JADX WARN: Code duplicated, block: B:42:0x00cf  */
    /* JADX WARN: Code duplicated, block: B:44:0x00d3  */
    /* JADX WARN: Code duplicated, block: B:49:0x00e6  */
    /* JADX WARN: Code duplicated, block: B:51:0x00e9  */
    /* JADX WARN: Code duplicated, block: B:56:0x00f8 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:57:0x00f9  */
    /* JADX WARN: Code duplicated, block: B:60:0x0103 A[LOOP:1: B:58:0x00fd->B:60:0x0103, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:66:0x00f3 A[ADDED_TO_REGION, REMOVE, SYNTHETIC] */
    public final void d0() throws IllegalStateException {
        List<String> listC;
        Iterator<String> it;
        int size;
        int i;
        C3418j0 c3418j0;
        List<String> listC2;
        LinkedList<C3389h> linkedListF;
        C3389h c3389h;
        L4 l4 = this.j;
        if (l4 != null) {
            ((M4) l4).c("C0", AbstractC3492o0.a("C0", "TAG", "loadAd_ ", this));
        }
        C3389h c3389hM = m();
        if (c3389hM == null || W()) {
            c3389hM = null;
        }
        if (c3389hM == null) {
            throw new IllegalStateException("Unable to get topAd");
        }
        String strU = c3389hM.u();
        int iHashCode = strU.hashCode();
        if (iHashCode == -1084172778) {
            if (strU.equals("inmobiJson")) {
                L4 l5 = this.j;
                if (l5 != null) {
                    ((M4) l5).a("C0", O5.a("C0", "TAG", "Loading ad with impressionId : ").append(c3389hM.s()).toString());
                }
                C3418j0 c3418j1 = this.u;
                if (c3418j1 != null) {
                    AdConfig adConfig = this.b;
                    Intrinsics.checkNotNull(adConfig);
                    c3418j1.a(adConfig, this, this.j);
                }
                listC = c3389hM.c(C3389h.WIN_BEACON);
                if (this.A) {
                    C3418j0 c3418j2 = this.u;
                    Intrinsics.checkNotNull(c3418j2);
                    size = c3418j2.f().size();
                    while (i < size) {
                        c3418j0 = this.u;
                        if (c3418j0 != null) {
                            listC2 = null;
                        } else {
                            listC2 = null;
                        }
                        if (listC2 == null) {
                        }
                    }
                }
                if (listC == null) {
                    return;
                }
                it = listC.iterator();
                while (it.hasNext()) {
                    C3364f2.f3308a.a(it.next(), true, this.j);
                }
            }
            L4 l6 = this.j;
            if (l6 != null) {
                ((M4) l6).b("C0", O5.a("C0", "TAG", "Can not handle fallback for").append(c3389hM.u()).toString());
            }
            throw new IllegalStateException("Can not handle fallback for markup type: " + c3389hM.u());
        }
        if (iHashCode == 3213227) {
            listC = c3389hM.c(C3389h.WIN_BEACON);
            if (this.A) {
                C3418j0 c3418j3 = this.u;
                Intrinsics.checkNotNull(c3418j3);
                size = c3418j3.f().size();
                while (i < size) {
                    c3418j0 = this.u;
                    if (c3418j0 != null) {
                        listC2 = null;
                    } else {
                        listC2 = null;
                    }
                    if (listC2 == null) {
                    }
                }
            }
            if (listC == null) {
                return;
            }
            it = listC.iterator();
            while (it.hasNext()) {
                C3364f2.f3308a.a(it.next(), true, this.j);
            }
        }
        listC = c3389hM.c(C3389h.WIN_BEACON);
        if (this.A) {
            C3418j0 c3418j4 = this.u;
            Intrinsics.checkNotNull(c3418j4);
            size = c3418j4.f().size();
            for (i = 1; i < size; i++) {
                c3418j0 = this.u;
                if (c3418j0 != null || (linkedListF = c3418j0.f()) == null || (c3389h = linkedListF.get(i)) == null) {
                    listC2 = null;
                } else {
                    listC2 = c3389h.c(C3389h.WIN_BEACON);
                }
                if (listC2 == null && (listC instanceof LinkedList)) {
                    ((LinkedList) listC).addAll(listC2);
                }
            }
        }
        if (listC == null) {
            return;
        }
        it = listC.iterator();
        while (it.hasNext()) {
            C3364f2.f3308a.a(it.next(), true, this.j);
        }
    }

    public final void e0() {
        L4 l4 = this.j;
        if (l4 != null) {
            ((M4) l4).a("C0", AbstractC3492o0.a("C0", "TAG", "makeUnitActive ", this));
        }
        this.o = false;
    }

    public final void f(AbstractC3520q0 listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        L4 l4 = this.j;
        if (l4 != null) {
            ((M4) l4).a("C0", AbstractC3492o0.a("C0", "TAG", "onLoadSuccess ", this));
        }
        AdMetaInfo adMetaInfoL = l();
        if (adMetaInfoL == null) {
            L4 l5 = this.j;
            if (l5 != null) {
                Intrinsics.checkNotNullExpressionValue("C0", "TAG");
                ((M4) l5).b("C0", "load success - ad unit null");
            }
            b(new InMobiAdRequestStatus(InMobiAdRequestStatus.StatusCode.INTERNAL_ERROR), true, (short) 2107);
            return;
        }
        b((byte) 1);
        L4 l6 = this.j;
        if (l6 != null) {
            Intrinsics.checkNotNullExpressionValue("C0", "TAG");
            ((M4) l6).a("C0", "callback - onAdLoadSucceeded");
        }
        listener.c(adMetaInfoL);
    }

    public boolean f0() {
        L4 l4 = this.j;
        if (l4 != null) {
            ((M4) l4).c("C0", AbstractC3492o0.a("C0", "TAG", "missingPrerequisitesForAd ", this));
        }
        try {
            Reflection.getOrCreateKotlinClass(RecyclerView.class).getSimpleName();
            Reflection.getOrCreateKotlinClass(CustomTabsClient.class).getSimpleName();
            return false;
        } catch (NoClassDefFoundError unused) {
            return true;
        }
    }

    public final void g(int i) {
        this.w = i;
    }

    public void g0() {
        E0 e0 = this.I;
        e0.getClass();
        e0.h = SystemClock.elapsedRealtime();
    }

    public final void h(int i) {
        this.x = i;
    }

    public final D h0() {
        String string;
        Integer num;
        Integer num2;
        L4 l4 = this.j;
        if (l4 != null) {
            ((M4) l4).a("C0", AbstractC3492o0.a("C0", "TAG", "prepareAdRequest ", this));
        }
        Context contextT = t();
        Y8 y8 = null;
        C3300a9 c3300a9 = contextT != null ? new C3300a9(contextT, this.j) : null;
        AdConfig adConfig = this.b;
        String url = adConfig != null ? adConfig.getUrl() : null;
        AdConfig adConfig2 = this.b;
        Intrinsics.checkNotNull(adConfig2);
        C3545rc c3545rc = new C3545rc(adConfig2.getIncludeIds());
        ArrayList arrayListA = AbstractC3415ib.a().a();
        if (arrayListA.isEmpty()) {
            string = null;
        } else {
            JSONArray jSONArray = new JSONArray();
            Iterator it = arrayListA.iterator();
            while (it.hasNext()) {
                try {
                    jSONArray.put(URLEncoder.encode(((C3417j) it.next()).b, "UTF-8"));
                } catch (UnsupportedEncodingException unused) {
                }
            }
            string = jSONArray.toString();
        }
        J j = this.t;
        if (c3300a9 != null) {
            if (c3300a9.d) {
                y8 = new Y8(MapsKt.hashMapOf(TuplesKt.to("n-h-id", c3300a9.c)));
            } else {
                L4 l5 = c3300a9.b;
                if (l5 != null) {
                    ((M4) l5).a("NovatiqDataHandler", "Novatiq disabled. skip");
                }
                y8 = new Y8(MapsKt.emptyMap());
            }
        }
        Y8 y9 = y8;
        L4 l6 = this.j;
        AdConfig adConfig3 = this.b;
        D d = new D(url, c3545rc, string, j, y9, l6, adConfig3 != null ? adConfig3.getApplyGzipReq() : false);
        d.C = this.t.i();
        d.B = q();
        Intrinsics.checkNotNullParameter("unifiedSdkJson", "<set-?>");
        d.A = "unifiedSdkJson";
        d.D = o();
        E6 e6 = this.F;
        int iIntValue = 15000;
        d.p = (e6 == null || (num2 = e6.d) == null) ? 15000 : num2.intValue();
        E6 e7 = this.F;
        if (e7 != null && (num = e7.d) != null) {
            iIntValue = num.intValue();
        }
        d.q = iIntValue;
        d.o = X();
        return d;
    }

    public final void i() {
        L4 l4 = this.j;
        if (l4 != null) {
            ((M4) l4).a("C0", AbstractC3492o0.a("C0", "TAG", "fireAdServedBeacon ", this));
        }
        r rVarK = k();
        if (rVarK == null) {
            return;
        }
        rVarK.a((byte) 2, null);
    }

    public C3460lc i0() {
        L4 l4 = this.j;
        if (l4 != null) {
            ((M4) l4).c("C0", AbstractC3492o0.a("C0", "TAG", "provideTimeoutConfigurations ", this));
        }
        C3460lc c3460lc = this.d;
        Intrinsics.checkNotNull(c3460lc);
        return c3460lc;
    }

    public final AdConfig j() {
        return this.b;
    }

    public abstract void j0();

    public final r k() {
        L4 l4 = this.j;
        if (l4 != null) {
            ((M4) l4).c("C0", AbstractC3492o0.a("C0", "TAG", "adMarkupContainer getter ", this));
        }
        byte b = this.f3036a;
        String strE = E();
        int iHashCode = strE.hashCode();
        if (iHashCode != -1084172778) {
            if (iHashCode != 3213227) {
                if (iHashCode == 1236050372 && strE.equals("htmlUrl") && b != 0 && 1 != b && 3 != b) {
                    return w();
                }
            } else if (strE.equals("html") && b != 0 && 1 != b && 3 != b) {
                return w();
            }
        } else if (strE.equals("inmobiJson") && b != 0 && 1 != b && 3 != b && 2 != b) {
            return this.h;
        }
        return null;
    }

    public void k0() {
        L4 l4 = this.j;
        if (l4 != null) {
            ((M4) l4).a("C0", AbstractC3492o0.a("C0", "TAG", "resetContainersForNextAd ", this));
        }
        C3313b7 c3313b7 = this.h;
        if (c3313b7 != null) {
            c3313b7.b();
        }
        this.h = null;
        int size = this.g.size();
        int i = this.x;
        if (size <= i || this.g.get(i) == null) {
            return;
        }
        a(this.x, false);
    }

    public final AdMetaInfo l() {
        L4 l4 = this.j;
        if (l4 != null) {
            ((M4) l4).c("C0", AbstractC3492o0.a("C0", "TAG", "adMetaInfo getter ", this));
        }
        C3389h c3389hM = m();
        if (c3389hM != null) {
            return c3389hM.d();
        }
        return null;
    }

    public final C3297a6 l0() {
        String strT;
        Boolean boolO;
        String strW;
        String strP;
        String strS;
        long jL = this.t.l();
        C3389h c3389hU = u();
        String str = (c3389hU == null || (strS = c3389hU.s()) == null) ? "" : strS;
        String strValueOf = String.valueOf(this.t.m());
        String strQ = q();
        String strE = E();
        C3389h c3389hU2 = u();
        String str2 = (c3389hU2 == null || (strP = c3389hU2.p()) == null) ? "" : strP;
        C3389h c3389hU3 = u();
        String str3 = (c3389hU3 == null || (strW = c3389hU3.w()) == null) ? "" : strW;
        C3418j0 c3418j0 = this.u;
        boolean zBooleanValue = (c3418j0 == null || (boolO = c3418j0.o()) == null) ? false : boolO.booleanValue();
        C3389h c3389hU4 = u();
        return new C3297a6(jL, str, strValueOf, strQ, strE, str2, str3, zBooleanValue, (c3389hU4 == null || (strT = c3389hU4.t()) == null) ? "" : strT);
    }

    public final C3389h m() {
        return a(0);
    }

    public final void m0() {
        L4 l4 = this.j;
        if (l4 != null) {
            Intrinsics.checkNotNullExpressionValue("C0", "TAG");
            ((M4) l4).d("C0", "AdUnit " + this + " state - FAILED");
        }
        d((byte) 3);
        b((byte) 1);
    }

    public final String n() {
        C3418j0 c3418j0 = this.u;
        if (c3418j0 != null) {
            return c3418j0.c();
        }
        return null;
    }

    public final void n0() {
        Intrinsics.checkNotNullExpressionValue("C0", "TAG");
        toString();
        String strB = C3517pb.b();
        LinkedHashMap linkedHashMap = C3578u2.f3440a;
        Config configA = C3549s2.a("ads", strB, null);
        this.b = configA instanceof AdConfig ? (AdConfig) configA : null;
        L4 l4 = this.j;
        if (l4 != null) {
            ((M4) l4).c("C0", AbstractC3492o0.a("C0", "TAG", "timeOutConfiguration getter ", this));
        }
        AdConfig adConfig = this.b;
        Intrinsics.checkNotNull(adConfig);
        this.d = adConfig.getTimeouts();
        d((byte) 0);
        this.e = new C3462m0(this, this, this.t);
        this.i = new HashMap();
        this.k = (byte) -1;
        this.l = new Handler(Looper.getMainLooper());
        this.m = false;
        this.v = new C3374fc(this);
    }

    public HashMap o() {
        return new HashMap();
    }

    public final boolean o0() {
        Unit unit;
        L4 l4 = this.j;
        if (l4 != null) {
            ((M4) l4).c("C0", AbstractC3492o0.a("C0", "TAG", "shouldBlockLoadAd ", this));
        }
        C3389h c3389hM = m();
        if (c3389hM != null && 4 == this.f3036a && !W()) {
            AbstractC3520q0 abstractC3520q0R = r();
            if (abstractC3520q0R != null) {
                L4 l5 = this.j;
                if (l5 != null) {
                    Intrinsics.checkNotNullExpressionValue("C0", "TAG");
                    ((M4) l5).a("C0", "ad is ready - load success");
                }
                f(abstractC3520q0R);
                unit = Unit.INSTANCE;
            } else {
                unit = null;
            }
            if (unit == null) {
                b((short) 2188);
            }
            return true;
        }
        if (c3389hM == null) {
            b(new InMobiAdRequestStatus(InMobiAdRequestStatus.StatusCode.AD_NO_LONGER_AVAILABLE), true, (short) 2131);
            L4 l6 = this.j;
            if (l6 != null) {
                Intrinsics.checkNotNullExpressionValue("C0", "TAG");
                ((M4) l6).b("C0", "ad no longer available");
            }
            return true;
        }
        if (2 != this.f3036a) {
            b(new InMobiAdRequestStatus(InMobiAdRequestStatus.StatusCode.AD_NO_LONGER_AVAILABLE), true, (short) 2132);
            L4 l7 = this.j;
            if (l7 != null) {
                ((M4) l7).b("C0", O5.a("C0", "TAG", "ad no longer available. state - ").append((int) this.f3036a).toString());
            }
            return true;
        }
        if (!W()) {
            return false;
        }
        b(new InMobiAdRequestStatus(InMobiAdRequestStatus.StatusCode.AD_NO_LONGER_AVAILABLE), true, (short) 2133);
        L4 l8 = this.j;
        if (l8 != null) {
            Intrinsics.checkNotNullExpressionValue("C0", "TAG");
            ((M4) l8).b("C0", "ad is expired");
        }
        return true;
    }

    public final C3462m0 p() {
        L4 l4 = this.j;
        if (l4 != null) {
            ((M4) l4).c("C0", AbstractC3492o0.a("C0", "TAG", "adStore getter ", this));
        }
        if (this.e == null) {
            this.e = new C3462m0(this, this, this.t);
        }
        C3462m0 c3462m0 = this.e;
        Intrinsics.checkNotNull(c3462m0);
        return c3462m0;
    }

    public final boolean p0() {
        AdConfig adConfig;
        return Intrinsics.areEqual(this.t.m(), "AB") && (adConfig = this.b) != null && adConfig.getSkipNetCheckHB();
    }

    public abstract String q();

    public void q0() {
        L4 l4 = this.j;
        if (l4 != null) {
            ((M4) l4).c("C0", AbstractC3492o0.a("C0", "TAG", "signalAvailabilityChange ", this));
        }
    }

    public final AbstractC3520q0 r() {
        L4 l4;
        L4 l5 = this.j;
        if (l5 != null) {
            ((M4) l5).c("C0", AbstractC3492o0.a("C0", "TAG", "adUnitEventListener getter ", this));
        }
        AbstractC3520q0 abstractC3520q0 = (AbstractC3520q0) this.f.get();
        if (abstractC3520q0 == null && (l4 = this.j) != null) {
            ((M4) l4).b("InMobi", "Listener was garbage collected. Unable to give callback");
        }
        return abstractC3520q0;
    }

    public void r0() {
        L4 l4 = this.j;
        if (l4 != null) {
            ((M4) l4).c("C0", AbstractC3492o0.a("C0", "TAG", "signalSuccess ", this));
        }
    }

    public final E0 s() {
        return this.I;
    }

    public final void s0() {
        LinkedList<C3389h> linkedListF;
        C3389h c3389h;
        L4 l4 = this.j;
        if (l4 != null) {
            ((M4) l4).c("C0", AbstractC3492o0.a("C0", "TAG", "startLoadingHTMLAd ", this));
        }
        Ba ba = null;
        try {
            e(this.w);
            L4 l5 = this.j;
            if (l5 != null) {
                Intrinsics.checkNotNullExpressionValue("C0", "TAG");
                StringBuilder sb = new StringBuilder("Loading ad with impressionId : ");
                C3418j0 c3418j0 = this.u;
                ((M4) l5).a("C0", sb.append((c3418j0 == null || (linkedListF = c3418j0.f()) == null || (c3389h = linkedListF.get(this.w)) == null) ? null : c3389h.s()).toString());
            }
            Ba ba2 = (Ba) this.g.get(this.w);
            String strE = E();
            if (Intrinsics.areEqual(strE, "html")) {
                L4 l6 = this.j;
                if (l6 != null) {
                    Intrinsics.checkNotNullExpressionValue("C0", "TAG");
                    ((M4) l6).a("C0", "loading into weview for " + E());
                }
                if (ba2 != null) {
                    ba2.c(c(this.w));
                }
            } else if (Intrinsics.areEqual(strE, "htmlUrl")) {
                L4 l7 = this.j;
                if (l7 != null) {
                    Intrinsics.checkNotNullExpressionValue("C0", "TAG");
                    ((M4) l7).a("C0", "loading into weview for " + E());
                }
                if (ba2 != null) {
                    ba2.d(c(this.w));
                }
            }
            a(true, ba2);
            if (ba2 == null || !Intrinsics.areEqual(E(), "htmlUrl")) {
                return;
            }
            j(ba2);
        } catch (Exception e) {
            L4 l8 = this.j;
            if (l8 != null) {
                ((M4) l8).a("C0", ld.a(e, O5.a("C0", "TAG", "Loading ad markup into container encountered an unexpected error: ")));
            }
            C3339d5 c3339d5 = C3339d5.f3292a;
            C3339d5.c.a(I4.a(e, "event"));
            int i = this.w;
            if (i >= 0 && i < this.g.size()) {
                ba = (Ba) this.g.get(this.w);
            }
            b(ba, (short) 2135);
        }
    }

    public final Context t() {
        WeakReference weakReference = this.c;
        if (weakReference != null) {
            return (Context) weakReference.get();
        }
        return null;
    }

    public final void t0() {
        L4 l4 = this.j;
        if (l4 != null) {
            ((M4) l4).c("C0", AbstractC3492o0.a("C0", "TAG", "submitAdLoadCalled ", this));
        }
        HashMap map = new HashMap();
        c(map);
        c("AdLoadCalled", map);
    }

    public final C3389h u() {
        return this.A ? a(this.w) : m();
    }

    public final void u0() {
        Boolean boolO;
        String strP;
        L4 l4 = this.j;
        if (l4 != null) {
            ((M4) l4).c("C0", O5.a("C0", "TAG", "submitAdLoadSuccessfulEvent ADunit markuptype : ").append(E()).append(' ').append(this).toString());
        }
        HashMap map = new HashMap();
        long j = this.I.c;
        ScheduledExecutorService scheduledExecutorService = Ec.f3062a;
        map.put("latency", Long.valueOf(SystemClock.elapsedRealtime() - j));
        map.put("markupType", E());
        C3389h c3389hU = u();
        if (c3389hU != null && (strP = c3389hU.p()) != null) {
            map.put("creativeType", "\"" + strP + '\"');
        }
        C3525q5 c3525q5 = this.E;
        if (c3525q5 != null) {
            map.put("retryCount", Integer.valueOf(c3525q5.b));
        }
        C3418j0 c3418j0 = this.u;
        if (c3418j0 != null && (boolO = c3418j0.o()) != null) {
            map.put("isRewarded", boolO);
        }
        if (S().length() > 0) {
            map.put("metadataBlob", S());
        }
        c(map);
        c("AdLoadSuccessful", map);
    }

    public final C3575u v() {
        return this.C;
    }

    public final void v0() {
        String strP;
        Boolean boolO;
        HashMap map = new HashMap();
        c(map);
        map.put("markupType", E());
        long j = this.I.h;
        ScheduledExecutorService scheduledExecutorService = Ec.f3062a;
        map.put("latency", Long.valueOf(SystemClock.elapsedRealtime() - j));
        map.put("metadataBlob", S());
        C3525q5 c3525q5 = this.E;
        if (c3525q5 != null) {
            map.put("retryCount", Integer.valueOf(c3525q5.b));
        }
        C3418j0 c3418j0 = this.u;
        if (c3418j0 != null && (boolO = c3418j0.o()) != null) {
            map.put("isRewarded", boolO);
        }
        C3389h c3389hU = u();
        if (c3389hU != null && (strP = c3389hU.p()) != null) {
            map.put("creativeType", "\"" + strP + '\"');
        }
        c("ParseSuccess", map);
    }

    public Ba w() {
        if (this.g.size() <= 0 || this.x >= this.g.size()) {
            return null;
        }
        return (Ba) this.g.get(this.x);
    }

    public final void w0() {
        Boolean boolO;
        String strP;
        L4 l4 = this.j;
        if (l4 != null) {
            ((M4) l4).c("C0", AbstractC3492o0.a("C0", "TAG", "submitAdShowCalled ", this));
        }
        E0 e0 = this.I;
        e0.getClass();
        e0.e = SystemClock.elapsedRealtime();
        HashMap map = new HashMap();
        map.put("markupType", E());
        long j = this.I.i;
        ScheduledExecutorService scheduledExecutorService = Ec.f3062a;
        map.put("latency", Long.valueOf(SystemClock.elapsedRealtime() - j));
        C3389h c3389hA = this.A ? a(this.x) : m();
        if (c3389hA != null && (strP = c3389hA.p()) != null) {
            map.put("creativeType", "\"" + strP + '\"');
        }
        C3418j0 c3418j0 = this.u;
        if (c3418j0 != null && (boolO = c3418j0.o()) != null) {
            map.put("isRewarded", boolO);
        }
        if (S().length() > 0) {
            map.put("metadataBlob", S());
        }
        c(map);
        c("AdShowCalled", map);
    }

    public final Ba x() {
        return this.n;
    }

    public final void x0() {
        Boolean boolO;
        String strP;
        L4 l4 = this.j;
        if (l4 != null) {
            ((M4) l4).c("C0", AbstractC3492o0.a("C0", "TAG", "submitAdShowSuccess ", this));
        }
        HashMap map = new HashMap();
        long j = this.I.e;
        ScheduledExecutorService scheduledExecutorService = Ec.f3062a;
        map.put("latency", Long.valueOf(SystemClock.elapsedRealtime() - j));
        map.put("markupType", E());
        C3389h c3389hA = this.A ? a(this.x) : m();
        if (c3389hA != null && (strP = c3389hA.p()) != null) {
            map.put("creativeType", "\"" + strP + '\"');
        }
        C3418j0 c3418j0 = this.u;
        if (c3418j0 != null && (boolO = c3418j0.o()) != null) {
            map.put("isRewarded", boolO);
        }
        if (S().length() > 0) {
            map.put("metadataBlob", S());
        }
        c(map);
        c("AdShowSuccessful", map);
    }

    public final C3418j0 y() {
        return this.u;
    }

    public final void y0() {
        HashMap map = new HashMap();
        c(map);
        c("AdGetSignalsCalled", map);
    }

    public final int z() {
        return this.w;
    }

    public final void z0() {
        Boolean boolO;
        String strP;
        L4 l4 = this.j;
        if (l4 != null) {
            ((M4) l4).c("C0", O5.a("C0", "TAG", "submitRenderSuccessEvent ADunit markuptype : ").append(E()).append(' ').append(this).toString());
        }
        HashMap map = new HashMap();
        long j = this.I.g;
        ScheduledExecutorService scheduledExecutorService = Ec.f3062a;
        map.put("latency", Long.valueOf(SystemClock.elapsedRealtime() - j));
        map.put("markupType", E());
        C3389h c3389hA = this.A ? a(this.x) : m();
        if (c3389hA != null && (strP = c3389hA.p()) != null) {
            map.put("creativeType", "\"" + strP + '\"');
        }
        C3525q5 c3525q5 = this.E;
        if (c3525q5 != null) {
            map.put("retryCount", Integer.valueOf(c3525q5.b));
        }
        map.put("plType", Byte.valueOf(J()));
        C3418j0 c3418j0 = this.u;
        if (c3418j0 != null && (boolO = c3418j0.o()) != null) {
            map.put("isRewarded", boolO);
        }
        if (S().length() > 0) {
            map.put("metadataBlob", S());
        }
        c(map);
        c((Map) map);
        c("RenderSuccess", map);
    }

    public final void e(C3418j0 c3418j0) {
        this.u = c3418j0;
    }

    public final void g(AbstractC3520q0 abstractC3520q0) {
        Boolean boolO;
        L4 l4 = this.j;
        if (l4 != null) {
            ((M4) l4).c("C0", AbstractC3492o0.a("C0", "TAG", "adUnitEventListener setter ", this));
        }
        WeakReference weakReference = new WeakReference(abstractC3520q0);
        this.f = weakReference;
        String strQ = q();
        C3418j0 c3418j0 = this.u;
        C3645z c3645z = new C3645z(weakReference, strQ, (c3418j0 == null || (boolO = c3418j0.o()) == null) ? false : boolO.booleanValue());
        this.D = c3645z;
        L4 logger = this.j;
        if (logger != null) {
            Intrinsics.checkNotNullParameter(logger, "logger");
            c3645z.f = logger;
        }
    }

    @Override // com.inmobi.media.Da
    public void h(final Ba renderView) {
        Intrinsics.checkNotNullParameter(renderView, "renderView");
        L4 l4 = this.j;
        if (l4 != null) {
            ((M4) l4).a("C0", AbstractC3492o0.a("C0", "TAG", "onRenderViewSignaledAdReady ", this));
        }
        if (this.o || t() == null) {
            b((short) 2186);
            return;
        }
        Handler handler = this.l;
        if (handler != null) {
            handler.post(new Runnable() { // from class: com.inmobi.media.C0$$ExternalSyntheticLambda2
                @Override // java.lang.Runnable
                public final void run() {
                    C0.c(this.f$0, renderView);
                }
            });
        } else {
            b((short) 2187);
        }
    }

    public final void j(Ba ba) {
        List<String> listC;
        int iIndexOf = this.g.indexOf(ba);
        L4 l4 = this.j;
        if (l4 != null) {
            Intrinsics.checkNotNullExpressionValue("C0", "TAG");
            ((M4) l4).a("C0", "fireLoadAdTokenUrlSuccessful : " + iIndexOf + ' ' + this);
        }
        C3389h c3389hA = a(iIndexOf);
        if (c3389hA == null || (listC = c3389hA.c(C3389h.LOAD_AD_TOKEN_URL)) == null) {
            return;
        }
        Iterator<String> it = listC.iterator();
        while (it.hasNext()) {
            C3364f2.f3308a.a(it.next(), true, this.j);
        }
    }

    public final void b(boolean z) {
        this.m = z;
    }

    public final void e(int i) {
        String strT;
        String strU;
        Ba ba;
        L4 l4 = this.j;
        if (l4 != null) {
            ((M4) l4).a("C0", AbstractC3492o0.a("C0", "TAG", "initializeHtmlAdContainer ", this));
        }
        Context contextT = t();
        if (contextT == null) {
            return;
        }
        try {
            if (this.g.get(i) == null || ((ba = (Ba) this.g.get(i)) != null && ba.I.get())) {
                C3389h c3389hA = a(i);
                Ea eaA = a(i, c3389hA);
                byte bJ = J();
                HashMap map = this.i;
                Set set = map != null ? (Set) map.get(Integer.valueOf(i)) : null;
                C3389h c3389hA2 = a(i);
                String strS = c3389hA2 != null ? c3389hA2.s() : null;
                if (c3389hA == null || (strT = c3389hA.t()) == null) {
                    strT = "DEFAULT";
                }
                Ba ba2 = new Ba(contextT, bJ, set, strS, false, strT, 0L, eaA, this.j, 80);
                String strP = c3389hA != null ? c3389hA.p() : null;
                L4 l5 = ba2.i;
                if (l5 != null) {
                    String TAG = Ba.O0;
                    Intrinsics.checkNotNullExpressionValue(TAG, "TAG");
                    ((M4) l5).c(TAG, "creativeType " + ba2 + ' ' + strP);
                }
                ba2.s0 = strP;
                if (c3389hA == null || (strU = c3389hA.u()) == null) {
                    strU = "html";
                }
                ba2.setMarkupTypeAdUnit(strU);
                this.g.set(i, ba2);
                if (Intrinsics.areEqual(this.t.b(), "banner") || Intrinsics.areEqual(this.t.b(), "audio")) {
                    ba2.setAdSize(this.t.a());
                }
                ba2.setAdType(this.t.b());
                ba2.setImmersiveMode(b(c3389hA));
                AdConfig adConfig = this.b;
                Intrinsics.checkNotNull(adConfig);
                ba2.a(this, adConfig);
                ba2.setAdPodHandler(this);
                ba2.setPlacementId(this.t.l());
                ba2.setAllowAutoRedirection(b(i));
                ba2.setContentURL(this.t.e());
                AdMetaInfo adMetaInfoL = l();
                if (adMetaInfoL != null) {
                    ba2.setCreativeId(adMetaInfoL.getCreativeID());
                }
                if (this.t.p()) {
                    ba2.e();
                }
                ba2.setTelemetryManagerMap(this.H);
                L4 l6 = ba2.i;
                if (l6 != null) {
                    String str = Ba.O0;
                    ((M4) l6).c(str, AbstractC3474ma.a(ba2, str, "TAG", "initContextualData "));
                }
                ba2.H0 = new J2(c3389hA, ba2.Q);
                a(c3389hA, ba2);
                WatermarkData watermarkData = this.J;
                if (watermarkData != null) {
                    ba2.setWatermark(watermarkData);
                }
            }
        } catch (Exception e) {
            b((Ba) this.g.get(this.w), (short) 2136);
            L4 l7 = this.j;
            if (l7 != null) {
                Intrinsics.checkNotNullExpressionValue("C0", "TAG");
                ((M4) l7).a("C0", "Exception while initializing WebView", e);
            }
            C3339d5 c3339d5 = C3339d5.f3292a;
            C3339d5.c.a(I4.a(e, "event"));
        }
    }

    public final boolean b(C3389h c3389h) {
        C3320c0 c3320c0Q;
        AdConfig.RenderingConfig rendering;
        AdConfig adConfig = this.b;
        boolean z = false;
        boolean enableImmersive = (adConfig == null || (rendering = adConfig.getRendering()) == null) ? false : rendering.getEnableImmersive();
        boolean z2 = AbstractC3565t3.i;
        boolean zA = (c3389h == null || (c3320c0Q = c3389h.q()) == null) ? false : c3320c0Q.a(false);
        if (enableImmersive && z2 && zA) {
            z = true;
        }
        if (!z) {
            b(enableImmersive, z2, zA);
        }
        L4 l4 = this.j;
        if (l4 != null) {
            Intrinsics.checkNotNullExpressionValue("C0", "TAG");
            ((M4) l4).a("C0", "Immersive support - config, device, adResponse - (" + enableImmersive + ' ' + z2 + ' ' + zA + ')');
        }
        return z;
    }

    public final void b(boolean z, boolean z2, boolean z3) {
        Pair<String, Short> pairA = a(z, z2, z3);
        String strComponent1 = pairA.component1();
        short sShortValue = pairA.component2().shortValue();
        HashMap map = new HashMap();
        map.put("reason", strComponent1);
        map.put("errorCode", Short.valueOf(sShortValue));
        c("ImmersiveNotSupported", map);
    }

    public final boolean b(int i) {
        L4 l4 = this.j;
        if (l4 != null) {
            Intrinsics.checkNotNullExpressionValue("C0", "TAG");
            ((M4) l4).c("C0", "getAllowAutoRedirectionForIndex " + this + " index - " + i);
        }
        C3389h c3389hA = a(i);
        return c3389hA != null && c3389hA.i();
    }

    public final int b(String str) {
        L4 l4 = this.j;
        if (l4 != null) {
            ((M4) l4).a("C0", AbstractC3492o0.a("C0", "TAG", "parseViewabilityResponseValue ", this));
        }
        if (StringsKt.startsWith$default(str, "track_", false, 2, (Object) null)) {
            str = str.substring(6);
            Intrinsics.checkNotNullExpressionValue(str, "this as java.lang.String).substring(startIndex)");
        }
        try {
            return Integer.parseInt(str);
        } catch (NumberFormatException unused) {
            return -1;
        }
    }

    public static final void a(Context context, C0 this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        C3487n9 c3487n9 = AbstractC3473m9.f3376a;
        AdConfig adConfig = this$0.b;
        c3487n9.getClass();
        try {
            if (!Omid.isActive()) {
                Omid.activate(context);
            } else {
                c3487n9.a(adConfig);
            }
        } catch (Exception e) {
            C3339d5 c3339d5 = C3339d5.f3292a;
            C3339d5.c.a(I4.a(e, "event"));
        }
    }

    public static final /* synthetic */ void a(C0 c0, C3389h c3389h, Ba ba) {
        c0.getClass();
        a(c3389h, ba);
    }

    public final void a(AdConfig adConfig) {
        this.b = adConfig;
    }

    public final void a(Handler handler) {
        this.l = handler;
    }

    public final void a(C3343d9 c3343d9) {
        this.s = c3343d9;
    }

    public final void a(long j) {
        this.y = j;
    }

    public final void a(TreeSet<Integer> treeSet) {
        Intrinsics.checkNotNullParameter(treeSet, "<set-?>");
        this.z = treeSet;
    }

    /* JADX WARN: Code duplicated, block: B:105:0x0216  */
    /* JADX WARN: Code duplicated, block: B:57:0x012b  */
    /* JADX WARN: Code duplicated, block: B:82:0x019a  */
    public final void a(Context context, J adPlacement, AbstractC3520q0 abstractC3520q0) {
        String placementType;
        String adTypes;
        TimeoutConfigurations$AdNonABConfig banner;
        E6 e6;
        TimeoutConfigurations$AdPreloadConfig banner2;
        TimeoutConfigurations$AdABConfig banner3;
        L4 l4;
        L4 l5;
        L4 l6;
        Boolean boolO;
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(adPlacement, "adPlacement");
        Intrinsics.checkNotNullExpressionValue("C0", "TAG");
        toString();
        a(context);
        WeakReference weakReference = new WeakReference(abstractC3520q0);
        this.f = weakReference;
        String strQ = q();
        C3418j0 c3418j0 = this.u;
        this.D = new C3645z(weakReference, strQ, (c3418j0 == null || (boolO = c3418j0.o()) == null) ? false : boolO.booleanValue());
        this.t = adPlacement;
        L4 l7 = this.j;
        if (l7 != null) {
            ((M4) l7).a("C0", AbstractC3492o0.a("C0", "TAG", "initTelemetry ", this));
        }
        this.H.put("AdImpressionSuccessful", this.I);
        L4 l8 = this.j;
        if (l8 != null) {
            Intrinsics.checkNotNullExpressionValue("C0", "TAG");
            ((M4) l8).c("C0", "initInternetAvailabilityAdRetry");
        }
        if (this.b == null && (l6 = this.j) != null) {
            Intrinsics.checkNotNullExpressionValue("C0", "TAG");
            ((M4) l6).c("C0", "adConfig is null");
            Unit unit = Unit.INSTANCE;
        }
        if (this.t.m() == null && (l5 = this.j) != null) {
            Intrinsics.checkNotNullExpressionValue("C0", "TAG");
            ((M4) l5).c("C0", "placement.placementType is null");
            Unit unit2 = Unit.INSTANCE;
        }
        if (this.t.b() == null && (l4 = this.j) != null) {
            Intrinsics.checkNotNullExpressionValue("C0", "TAG");
            ((M4) l4).c("C0", "placement.adType is null");
            Unit unit3 = Unit.INSTANCE;
        }
        AdConfig adConfig = this.b;
        if (adConfig != null && (placementType = this.t.m()) != null && (adTypes = this.t.b()) != null) {
            TimeoutConfigurations$MediationConfig mediationConfig = adConfig.getTimeouts().X();
            String strD = C3531qb.d();
            Intrinsics.checkNotNullParameter(mediationConfig, "mediationConfig");
            Intrinsics.checkNotNullParameter(placementType, "placementType");
            Intrinsics.checkNotNullParameter(adTypes, "adTypes");
            if (placementType.equals("AB")) {
                TimeoutConfigurations$ABConfig aBConfig = mediationConfig.getAb();
                int iHashCode = adTypes.hashCode();
                if (iHashCode != -1396342996) {
                    if (iHashCode != -1052618729) {
                        if (iHashCode != 104431) {
                            if (iHashCode == 93166550 && adTypes.equals("audio")) {
                                banner3 = aBConfig.getAudio();
                            } else {
                                banner3 = aBConfig.getBanner();
                            }
                        } else if (adTypes.equals(com.safedk.android.analytics.brandsafety.l.w)) {
                            banner3 = aBConfig.getInt();
                        } else {
                            banner3 = aBConfig.getBanner();
                        }
                    } else if (adTypes.equals("native")) {
                        banner3 = aBConfig.getNative();
                    } else {
                        banner3 = aBConfig.getBanner();
                    }
                } else if (!adTypes.equals("banner")) {
                    banner3 = aBConfig.getBanner();
                } else {
                    banner3 = aBConfig.getBanner();
                }
                e6 = new E6(D6.a(strD, banner3.getLoadRetryInterval()), D6.a(strD, banner3.getMaxLoadRetries()), D6.a(strD, banner3.getLoadTimeout()), (Integer) null, 24);
            } else if (placementType.equals("Preload")) {
                TimeoutConfigurations$PreloadConfig preloadConfig = mediationConfig.getPreload();
                int iHashCode2 = adTypes.hashCode();
                if (iHashCode2 != -1396342996) {
                    if (iHashCode2 != -1052618729) {
                        if (iHashCode2 != 104431) {
                            if (iHashCode2 == 93166550 && adTypes.equals("audio")) {
                                banner2 = preloadConfig.getAudio();
                            } else {
                                banner2 = preloadConfig.getBanner();
                            }
                        } else if (adTypes.equals(com.safedk.android.analytics.brandsafety.l.w)) {
                            banner2 = preloadConfig.getInt();
                        } else {
                            banner2 = preloadConfig.getBanner();
                        }
                    } else if (adTypes.equals("native")) {
                        banner2 = preloadConfig.getNative();
                    } else {
                        banner2 = preloadConfig.getBanner();
                    }
                } else if (!adTypes.equals("banner")) {
                    banner2 = preloadConfig.getBanner();
                } else {
                    banner2 = preloadConfig.getBanner();
                }
                e6 = new E6(D6.a(strD, banner2.getLoadRetryInterval()), D6.a(strD, banner2.getMaxLoadRetries()), D6.a(strD, banner2.getLoadTimeout()), Integer.valueOf(D6.a(strD, banner2.getMuttTimeout())), Integer.valueOf(D6.a(strD, banner2.getPreloadTimeout())));
            } else {
                TimeoutConfigurations$NonABConfig nonABConfig = mediationConfig.getNonAb();
                int iHashCode3 = adTypes.hashCode();
                if (iHashCode3 != -1396342996) {
                    if (iHashCode3 != -1052618729) {
                        if (iHashCode3 != 104431) {
                            if (iHashCode3 == 93166550 && adTypes.equals("audio")) {
                                banner = nonABConfig.getAudio();
                            } else {
                                banner = nonABConfig.getBanner();
                            }
                        } else if (adTypes.equals(com.safedk.android.analytics.brandsafety.l.w)) {
                            banner = nonABConfig.getInt();
                        } else {
                            banner = nonABConfig.getBanner();
                        }
                    } else if (adTypes.equals("native")) {
                        banner = nonABConfig.getNative();
                    } else {
                        banner = nonABConfig.getBanner();
                    }
                } else if (!adTypes.equals("banner")) {
                    banner = nonABConfig.getBanner();
                } else {
                    banner = nonABConfig.getBanner();
                }
                e6 = new E6(D6.a(strD, banner.getLoadRetryInterval()), D6.a(strD, banner.getMaxLoadRetries()), D6.a(strD, banner.getLoadTimeout()), Integer.valueOf(D6.a(strD, banner.getMuttTimeout())), 16);
            }
            this.E = new C3525q5(e6);
            this.F = e6;
        }
        C3579u3 c3579u3 = AbstractC3565t3.f3431a;
        if (context != null && AbstractC3565t3.h == null) {
            AbstractC3565t3.h = Float.valueOf(new TextView(context).getTextSize());
            Intrinsics.checkNotNullExpressionValue("t3", "TAG");
        } else {
            Intrinsics.checkNotNullExpressionValue("t3", "TAG");
        }
        n0();
    }

    public void a(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        L4 l4 = this.j;
        if (l4 != null) {
            ((M4) l4).c("C0", AbstractC3492o0.a("C0", "TAG", "setContext ", this));
        }
        this.c = new WeakReference(context);
    }

    public final Set d(int i) {
        L4 l4 = this.j;
        if (l4 != null) {
            ((M4) l4).c("C0", AbstractC3492o0.a("C0", "TAG", "getViewabilityTrackers ", this));
        }
        HashMap map = this.i;
        if (map != null) {
            return (Set) map.get(Integer.valueOf(i));
        }
        return null;
    }

    public final void c(boolean z) {
        L4 l4 = this.j;
        if (l4 != null) {
            ((M4) l4).c("C0", AbstractC3492o0.a("C0", "TAG", "setIsAssetReady ", this));
        }
        this.p = z;
    }

    public void g() {
        L4 l4 = this.j;
        if (l4 != null) {
            ((M4) l4).a("C0", AbstractC3492o0.a("C0", "TAG", "clear ", this));
        }
        if (this.o) {
            return;
        }
        this.o = true;
        Handler handler = this.l;
        if (handler != null) {
            handler.removeCallbacksAndMessages(null);
        }
        L4 l5 = this.j;
        if (l5 != null) {
            ((M4) l5).a("C0", AbstractC3492o0.a("C0", "TAG", "clearAdPods ", this));
        }
        if (this.A) {
            h();
            this.g.clear();
            this.w = 0;
            this.x = 0;
            this.z.clear();
        }
        C3525q5 c3525q5 = this.E;
        if (c3525q5 != null) {
            c3525q5.b = 0;
        }
        HashMap map = this.i;
        if (map != null) {
            map.clear();
        }
        k0();
        d((byte) 0);
        L4 l6 = this.j;
        if (l6 != null) {
            Intrinsics.checkNotNullExpressionValue("C0", "TAG");
            ((M4) l6).d("C0", "AdUnit " + this + " state - CREATED");
        }
        C3575u c3575u = this.C;
        int iHashCode = hashCode();
        c3575u.getClass();
        SparseArray sparseArray = C3575u.b;
        sparseArray.remove(iHashCode);
        Intrinsics.checkNotNullExpressionValue(ApsMetricsDataMap.APSMETRICS_FIELD_URL, "TAG");
        sparseArray.size();
        this.q = false;
        this.n = null;
        this.m = false;
        this.p = false;
        this.r = false;
        this.u = null;
        this.A = false;
    }

    public int k(Ba renderView) {
        Intrinsics.checkNotNullParameter(renderView, "renderView");
        L4 l4 = this.j;
        if (l4 != null) {
            ((M4) l4).c("C0", AbstractC3492o0.a("C0", "TAG", "getCurrentRenderingPodAdIndex ", this));
        }
        if (this.A) {
            return this.g.indexOf(renderView);
        }
        return -1;
    }

    public final void a(L4 logger) {
        Intrinsics.checkNotNullParameter(logger, "logger");
        this.j = logger;
        C3462m0 c3462m0P = p();
        c3462m0P.getClass();
        Intrinsics.checkNotNullParameter(logger, "logger");
        c3462m0P.f = logger;
        C3645z c3645z = this.D;
        c3645z.getClass();
        Intrinsics.checkNotNullParameter(logger, "logger");
        c3645z.f = logger;
    }

    public final void d(AbstractC3520q0 listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        L4 l4 = this.j;
        if (l4 != null) {
            ((M4) l4).c("C0", AbstractC3492o0.a("C0", "TAG", "onAdDisplayed ", this));
        }
        AdMetaInfo adMetaInfoL = l();
        if (adMetaInfoL == null) {
            L4 l5 = this.j;
            if (l5 != null) {
                Intrinsics.checkNotNullExpressionValue("C0", "TAG");
                ((M4) l5).b("C0", "callback onAdDisplayed failed. ad meta info is null");
            }
            a(listener, (short) 85);
            return;
        }
        L4 l6 = this.j;
        if (l6 != null) {
            Intrinsics.checkNotNullExpressionValue("C0", "TAG");
            ((M4) l6).a("C0", "callback - onAdDisplayed");
        }
        listener.a(adMetaInfoL);
    }

    public void l(Ba ba) {
        L4 l4 = this.j;
        if (l4 != null) {
            ((M4) l4).a("C0", O5.a("C0", "TAG", "Render view signaled ad ready, for index ").append(this.g.indexOf(ba)).append(' ').append(this).toString());
        }
        L4 l5 = this.j;
        if (l5 != null) {
            Intrinsics.checkNotNullExpressionValue("C0", "TAG");
            ((M4) l5).a("C0", "==== CHECKPOINT REACHED - LOAD SUCCESS ====");
        }
        L4 l6 = this.j;
        if (l6 != null) {
            ((M4) l6).b();
        }
    }

    @Override // com.inmobi.media.Da
    public void f(Ba renderView) {
        Intrinsics.checkNotNullParameter(renderView, "renderView");
        L4 l4 = this.j;
        if (l4 != null) {
            ((M4) l4).a("C0", O5.a("C0", "TAG", "RenderView completed loading ad content, for index ").append(this.g.indexOf(renderView)).append(' ').append(this).toString());
        }
    }

    public final Ea a(int i, C3389h c3389h) {
        String strP;
        String strO;
        Boolean boolO;
        String strW;
        LinkedHashMap linkedHashMap = C3578u2.f3440a;
        Ha ha = new Ha(((TelemetryConfig) B4.a("telemetry", "null cannot be cast to non-null type com.inmobi.commons.core.configs.TelemetryConfig", null)).getMaxTemplateEvents());
        J j = this.t;
        String strE = E();
        String str = (c3389h == null || (strW = c3389h.w()) == null) ? "" : strW;
        C3525q5 c3525q5 = this.E;
        int i2 = c3525q5 != null ? c3525q5.b : 0;
        C3389h c3389hU = u();
        if (c3389hU == null || (strP = c3389hU.p()) == null) {
            strP = "";
        }
        C3389h c3389hU2 = u();
        if (c3389hU2 == null || (strO = c3389hU2.o()) == null) {
            strO = "";
        }
        C3418j0 c3418j0 = this.u;
        return new Ea(j, strE, str, i2, strP, strO, (c3418j0 == null || (boolO = c3418j0.o()) == null) ? false : boolO.booleanValue(), i, this.I.j, ha);
    }

    public final void c(C3418j0 adSet) {
        Intrinsics.checkNotNullParameter(adSet, "adSet");
        L4 l4 = this.j;
        if (l4 != null) {
            ((M4) l4).c("C0", AbstractC3492o0.a("C0", "TAG", "onAdFetchSuccessful ", this));
        }
        if (this.f3036a == 1) {
            this.u = adSet;
        }
        if (!this.o && t() != null) {
            a(adSet);
            return;
        }
        b((short) 2185);
        L4 l5 = this.j;
        if (l5 != null) {
            Intrinsics.checkNotNullExpressionValue("C0", "TAG");
            ((M4) l5).b("C0", "adUnit is destroyed");
        }
    }

    public final void b(InMobiAdRequestStatus requestStatus, boolean z, short s) {
        Intrinsics.checkNotNullParameter(requestStatus, "requestStatus");
        L4 l4 = this.j;
        if (l4 != null) {
            Intrinsics.checkNotNullExpressionValue("C0", "TAG");
            ((M4) l4).b("C0", "handleAdLoadFailure " + this + " errorCode - " + ((int) s));
        }
        if (this.f3036a == 1 && z) {
            L4 l5 = this.j;
            if (l5 != null) {
                Intrinsics.checkNotNullExpressionValue("C0", "TAG");
                ((M4) l5).b("C0", "load failed - " + ((int) s));
            }
            L4 l6 = this.j;
            if (l6 != null) {
                Intrinsics.checkNotNullExpressionValue("C0", "TAG");
                ((M4) l6).d("C0", "AdUnit " + this + " state - FAILED");
            }
            d((byte) 3);
            b((byte) 1);
        }
        AbstractC3520q0 abstractC3520q0R = r();
        if (abstractC3520q0R != null) {
            abstractC3520q0R.a(this, requestStatus);
        } else {
            L4 l7 = this.j;
            if (l7 != null) {
                ((M4) l7).a();
            }
        }
        if (s != 0) {
            b(s);
        }
    }

    public final void b(C3418j0 adSet) {
        Intrinsics.checkNotNullParameter(adSet, "adSet");
        L4 l4 = this.j;
        if (l4 != null) {
            ((M4) l4).c("C0", AbstractC3492o0.a("C0", "TAG", "loadResponse ", this));
        }
        c(adSet);
    }

    public final Pair<String, Short> a(boolean z, boolean z2, boolean z3) {
        Short sh;
        StringBuilder sb = new StringBuilder("Immersive not supported on");
        BitSet bitSet = new BitSet(3);
        ArrayList arrayList = new ArrayList();
        if (!z) {
            arrayList.add(" config");
            bitSet.set(0);
        }
        if (!z2) {
            arrayList.add(" device");
            bitSet.set(1);
        }
        if (!z3) {
            arrayList.add(" ad");
            bitSet.set(2);
        }
        sb.append(CollectionsKt.joinToString$default(arrayList, StringUtils.COMMA, null, null, 0, null, null, 62, null));
        Intrinsics.checkNotNullParameter(bitSet, "bitSet");
        if (bitSet.get(0) && bitSet.get(1) && bitSet.get(2)) {
            sh = (short) 2202;
        } else if (bitSet.get(0) && bitSet.get(1)) {
            sh = (short) 2200;
        } else if (bitSet.get(0) && bitSet.get(2)) {
            sh = (short) 2199;
        } else if (bitSet.get(1) && bitSet.get(2)) {
            sh = (short) 2201;
        } else if (bitSet.get(0)) {
            sh = (short) 2196;
        } else if (bitSet.get(1)) {
            sh = (short) 2197;
        } else {
            sh = bitSet.get(2) ? (short) 2198 : null;
        }
        short sShortValue = sh != null ? sh.shortValue() : (short) -1;
        if (sShortValue == -1) {
            return new Pair<>("Invalid Reason", (short) -1);
        }
        return new Pair<>(sb.toString(), Short.valueOf(sShortValue));
    }

    public final void d(C3418j0 adSet) {
        Intrinsics.checkNotNullParameter(adSet, "adSet");
        L4 l4 = this.j;
        if (l4 != null) {
            ((M4) l4).c("C0", AbstractC3492o0.a("C0", "TAG", "onAuctionNotClosed ", this));
        }
        if (this.o || t() == null) {
            return;
        }
        L4 l5 = this.j;
        if (l5 != null) {
            ((M4) l5).c("C0", AbstractC3492o0.a("C0", "TAG", "handleAuctionNotClosed ", this));
        }
        if (this.f3036a == 1) {
            this.u = adSet;
            this.A = adSet != null ? adSet.n() : false;
            AbstractC3520q0 abstractC3520q0R = r();
            if (abstractC3520q0R != null) {
                abstractC3520q0R.a(this.t, adSet);
            }
        }
    }

    public static void a(C3389h c3389h, Ba ba) {
        AdQualityControl adQualityControl;
        Z adQualityManager;
        if (c3389h == null || (adQualityControl = c3389h.e()) == null || ba == null || (adQualityManager = ba.getAdQualityManager()) == null) {
            return;
        }
        Intrinsics.checkNotNullParameter(adQualityControl, "adQualityControl");
        adQualityManager.a("adQuality session setup");
        if (!adQualityManager.f3249a.getEnabled()) {
            adQualityManager.a("config kill switch - false. ad quality will skip");
            return;
        }
        if (adQualityManager.c.get()) {
            adQualityManager.a("session already started. skip");
            return;
        }
        adQualityManager.a("verifying control flags");
        String beacon = adQualityControl.getBeacon();
        if (beacon != null && beacon.length() == 0) {
            adQualityManager.a("no beacon received. aborting...");
            ScheduledExecutorService scheduledExecutorService = P.f3162a;
            if (scheduledExecutorService != null) {
                scheduledExecutorService.shutdown();
                try {
                    try {
                        scheduledExecutorService.shutdownNow();
                    } catch (InterruptedException unused) {
                        scheduledExecutorService.shutdownNow();
                        Thread.currentThread().interrupt();
                        adQualityManager.a("session end - cleanup");
                        adQualityManager.g = null;
                        adQualityManager.f.clear();
                        adQualityManager.c.set(false);
                        adQualityManager.d.set(false);
                        adQualityManager.a("ad quality session is already in progress. skipping...");
                        return;
                    }
                } catch (Exception e) {
                    Intrinsics.checkNotNullParameter("AdQualityComponent", "tag");
                    Intrinsics.checkNotNullParameter("shutdown fail", "message");
                    Log.e("AdQualityComponent", "shutdown fail", e);
                    Thread.currentThread().interrupt();
                }
            }
            adQualityManager.a("session end - cleanup");
            adQualityManager.g = null;
            adQualityManager.f.clear();
            adQualityManager.c.set(false);
            adQualityManager.d.set(false);
            adQualityManager.a("ad quality session is already in progress. skipping...");
            return;
        }
        adQualityManager.g = adQualityControl;
    }

    public final void e(AbstractC3520q0 listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        L4 l4 = this.j;
        if (l4 != null) {
            ((M4) l4).c("C0", AbstractC3492o0.a("C0", "TAG", "onFetchSuccess ", this));
        }
        v0();
        AdMetaInfo adMetaInfoL = l();
        if (adMetaInfoL == null) {
            L4 l5 = this.j;
            if (l5 != null) {
                Intrinsics.checkNotNullExpressionValue("C0", "TAG");
                ((M4) l5).b("C0", "ad meta info null. fail");
            }
            b(new InMobiAdRequestStatus(InMobiAdRequestStatus.StatusCode.INTERNAL_ERROR), true, (short) 2106);
            return;
        }
        L4 l6 = this.j;
        if (l6 != null) {
            Intrinsics.checkNotNullExpressionValue("C0", "TAG");
            ((M4) l6).a("C0", "callback - onAdFetchSuccess");
        }
        listener.b(adMetaInfoL);
    }

    @Override // com.inmobi.media.Da
    public void i(Ba renderView) {
        Intrinsics.checkNotNullParameter(renderView, "renderView");
        L4 l4 = this.j;
        if (l4 != null) {
            ((M4) l4).a("C0", O5.a("C0", "TAG", "RenderView visible, for index ").append(this.g.indexOf(renderView)).append(' ').append(this).toString());
        }
    }

    public final C3389h a(int i) {
        Iterable iterableEmptyList;
        LinkedList<C3389h> linkedListF;
        LinkedList<C3389h> linkedListF2;
        Intrinsics.checkNotNullExpressionValue("C0", "TAG");
        toString();
        C3418j0 c3418j0 = this.u;
        if (c3418j0 == null || (linkedListF2 = c3418j0.f()) == null || (iterableEmptyList = CollectionsKt.getIndices(linkedListF2)) == null) {
            iterableEmptyList = CollectionsKt.emptyList();
        }
        if (CollectionsKt.contains(iterableEmptyList, Integer.valueOf(i))) {
            C3418j0 c3418j1 = this.u;
            if (c3418j1 != null && (linkedListF = c3418j1.f()) != null) {
                return linkedListF.get(i);
            }
        } else {
            C3418j0 c3418j2 = this.u;
            if (c3418j2 != null) {
                return c3418j2.p();
            }
        }
        return null;
    }

    public final void a(AbstractC3520q0 listener, short s) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        L4 l4 = this.j;
        if (l4 != null) {
            ((M4) l4).a("C0", AbstractC3492o0.a("C0", "TAG", "onAdShowFailed ", this));
        }
        c(s);
        listener.d();
    }

    public void c(String monetizationContext) {
        Intrinsics.checkNotNullParameter(monetizationContext, "monetizationContext");
        L4 l4 = this.j;
        if (l4 != null) {
            ((M4) l4).c("C0", AbstractC3492o0.a("C0", "TAG", "setMonetizationContext ", this));
        }
        this.t.b(monetizationContext);
    }

    public final void h() {
        L4 l4 = this.j;
        if (l4 != null) {
            ((M4) l4).c("C0", AbstractC3492o0.a("C0", "TAG", "destroyAllContainer ", this));
        }
        int size = this.g.size();
        for (int i = 0; i < size; i++) {
            a(this, i, false, 2, null);
        }
    }

    public void b(AbstractC3520q0 abstractC3520q0) {
        L4 l4 = this.j;
        if (l4 != null) {
            ((M4) l4).c("C0", AbstractC3492o0.a("C0", "TAG", "handleAdScreenDisplayed ", this));
        }
    }

    @Override // com.inmobi.media.Da
    public void g(final Ba renderView) {
        Handler handler;
        Intrinsics.checkNotNullParameter(renderView, "renderView");
        L4 l4 = this.j;
        if (l4 != null) {
            ((M4) l4).a("C0", AbstractC3492o0.a("C0", "TAG", "onRenderViewSignaledAdFailed ", this));
        }
        if (this.o || t() == null || (handler = this.l) == null) {
            return;
        }
        handler.post(new Runnable() { // from class: com.inmobi.media.C0$$ExternalSyntheticLambda6
            @Override // java.lang.Runnable
            public final void run() {
                C0.b(this.f$0, renderView);
            }
        });
    }

    public void d(String podAdContext) {
        Intrinsics.checkNotNullParameter(podAdContext, "podAdContext");
        L4 l4 = this.j;
        if (l4 != null) {
            ((M4) l4).c("C0", AbstractC3492o0.a("C0", "TAG", "setPodAdContext ", this));
        }
        if (this.A) {
            this.B = podAdContext;
        }
    }

    /* JADX WARN: Code duplicated, block: B:24:0x003f  */
    public final boolean e(byte b) {
        int iY;
        Integer num;
        long j;
        Integer num2;
        L4 l4 = this.j;
        if (l4 != null) {
            ((M4) l4).a("C0", AbstractC3492o0.a("C0", "TAG", "startTimer ", this));
        }
        if (b == 0) {
            E6 e6 = this.F;
            if (e6 == null || (num2 = e6.d) == null) {
                j = 15000;
            } else {
                iY = num2.intValue();
                j = iY;
            }
        } else if (b == 1) {
            E6 e7 = this.F;
            if (e7 != null) {
                iY = e7.c;
                j = iY;
            } else {
                j = 15000;
            }
        } else {
            if (b == 2) {
                E6 e8 = this.F;
                if (e8 == null || (num = e8.e) == null) {
                    j = 15000;
                } else {
                    iY = num.intValue();
                }
            } else if (b == 4) {
                C3460lc c3460lc = this.d;
                Intrinsics.checkNotNull(c3460lc);
                iY = c3460lc.Y();
            } else {
                L4 l5 = this.j;
                if (l5 != null) {
                    Intrinsics.checkNotNullExpressionValue("C0", "TAG");
                    ((M4) l5).b("C0", "Invalid value for timeOutScenario passed!. Please pass a valid value");
                }
                return false;
            }
            j = iY;
        }
        C3374fc c3374fc = this.v;
        if (c3374fc == null) {
            return false;
        }
        Intrinsics.checkNotNullExpressionValue("fc", "TAG");
        if (c3374fc.b.containsKey(Byte.valueOf(b))) {
            Intrinsics.checkNotNullExpressionValue("fc", "TAG");
            Timer timer = (Timer) c3374fc.b.get(Byte.valueOf(b));
            if (timer != null) {
                timer.cancel();
                c3374fc.b.remove(Byte.valueOf(b));
            }
        }
        try {
            Timer timer2 = new Timer("fc");
            c3374fc.b.put(Byte.valueOf(b), timer2);
            timer2.schedule(new C3360ec(c3374fc, b), j);
            return true;
        } catch (InternalError e) {
            Intrinsics.checkNotNullExpressionValue("fc", "TAG");
            e.toString();
            return false;
        } catch (OutOfMemoryError unused) {
            Intrinsics.checkNotNullExpressionValue("fc", "TAG");
            AbstractC3498o6.a((byte) 1, "fc", "Could not execute timer due to OutOfMemory.");
            c3374fc.f3318a.c(b);
            return false;
        }
    }

    /* JADX WARN: Code duplicated, block: B:135:0x02b7  */
    /* JADX WARN: Code duplicated, block: B:138:0x02d4  */
    /* JADX WARN: Code duplicated, block: B:140:0x02e8  */
    /* JADX WARN: Code duplicated, block: B:148:0x02fc  */
    /* JADX WARN: Code duplicated, block: B:151:0x0317  */
    /* JADX WARN: Code duplicated, block: B:153:0x032b  */
    /* JADX WARN: Code duplicated, block: B:158:0x0336  */
    /* JADX WARN: Code duplicated, block: B:97:0x025a  */
    public boolean a(C3389h ad, int i, boolean z) {
        String str;
        boolean z2;
        L4 l4;
        HashMap map;
        String message;
        boolean z3;
        L4 l5;
        L4 l6;
        HashMap map2;
        String message2;
        boolean z4;
        AdConfig.ViewabilityConfig viewability;
        AdConfig.OmidConfig omidConfig;
        String str2 = "event";
        Intrinsics.checkNotNullParameter(ad, "ad");
        L4 l7 = this.j;
        Object obj = "reason";
        if (l7 != null) {
            Intrinsics.checkNotNullExpressionValue("C0", "TAG");
            ((M4) l7).c("C0", "didParseAdResponseAndExtractData " + this + " - index - " + i);
        }
        try {
            try {
                JSONObject jSONObjectC = ad.c();
                try {
                    if (Intrinsics.areEqual("unknown", ad.u())) {
                        L4 l8 = this.j;
                        if (l8 != null) {
                            Intrinsics.checkNotNullExpressionValue("C0", "TAG");
                            ((M4) l8).b("C0", "unknown markup type. fail");
                        }
                        if (!z) {
                            return false;
                        }
                        HashMap map3 = new HashMap();
                        map3.put("errorCode", (short) 2163);
                        b((Map<String, Object>) map3);
                        return false;
                    }
                    String strX = ad.x();
                    try {
                        try {
                            if (strX.length() > 0) {
                                try {
                                    long j = this.I.f;
                                    ScheduledExecutorService scheduledExecutorService = Ec.f3062a;
                                    ad.f(StringsKt.replace$default(strX, "@__imm_aft@", String.valueOf(SystemClock.elapsedRealtime() - j), false, 4, (Object) null));
                                    L4 l9 = this.j;
                                    if (l9 != null) {
                                        Intrinsics.checkNotNullExpressionValue("C0", "TAG");
                                        ((M4) l9).a("C0", "parsing of pub content success");
                                    }
                                    final Context contextD = C3517pb.d();
                                    HashMap map4 = this.i;
                                    Intrinsics.checkNotNull(map4);
                                    if (map4.get(Integer.valueOf(i)) == null) {
                                        Integer numValueOf = Integer.valueOf(i);
                                        HashMap map5 = this.i;
                                        Intrinsics.checkNotNull(map5);
                                        map5.put(numValueOf, new HashSet());
                                    }
                                    HashMap map6 = this.i;
                                    Intrinsics.checkNotNull(map6);
                                    Set set = (Set) map6.get(Integer.valueOf(i));
                                    if (set == null || !set.isEmpty()) {
                                        z4 = true;
                                    } else {
                                        L4 l10 = this.j;
                                        if (l10 != null) {
                                            Intrinsics.checkNotNullExpressionValue("C0", "TAG");
                                            ((M4) l10).c("C0", "empty trackers");
                                        }
                                        AdConfig adConfig = this.b;
                                        Boolean boolValueOf = (adConfig == null || (viewability = adConfig.getViewability()) == null || (omidConfig = viewability.getOmidConfig()) == null) ? null : Boolean.valueOf(omidConfig.isOmidEnabled());
                                        L4 l11 = this.j;
                                        if (l11 != null) {
                                            Intrinsics.checkNotNullExpressionValue("C0", "TAG");
                                            ((M4) l11).c("C0", "OMID enable - " + boolValueOf);
                                        }
                                        if (Intrinsics.areEqual(boolValueOf, Boolean.TRUE) && jSONObjectC != null && jSONObjectC.has("metaInfo")) {
                                            L4 l12 = this.j;
                                            if (l12 != null) {
                                                Intrinsics.checkNotNullExpressionValue("C0", "TAG");
                                                ((M4) l12).c("C0", "checking meta info");
                                            }
                                            JSONObject jSONObject = jSONObjectC.getJSONObject("metaInfo");
                                            if (jSONObject.has("omsdkInfo")) {
                                                L4 l13 = this.j;
                                                if (l13 != null) {
                                                    Intrinsics.checkNotNullExpressionValue("C0", "TAG");
                                                    ((M4) l13).c("C0", "checking OMSDK meta info");
                                                }
                                                JSONObject jSONObject2 = jSONObject.getJSONObject("omsdkInfo");
                                                if (jSONObject2.has("omidEnabled") && jSONObject2.getBoolean("omidEnabled")) {
                                                    String string = jSONObject.has("creativeType") ? jSONObject.getString("creativeType") : "unknown";
                                                    Handler handler = this.l;
                                                    if (handler != null) {
                                                        handler.post(new Runnable() { // from class: com.inmobi.media.C0$$ExternalSyntheticLambda0
                                                            @Override // java.lang.Runnable
                                                            public final void run() {
                                                                C0.a(contextD, this);
                                                            }
                                                        });
                                                    }
                                                    C3504oc c3504oc = new C3504oc((byte) 3);
                                                    boolean zOptBoolean = jSONObject2.optBoolean("isolateVerificationScripts");
                                                    String strOptString = jSONObject2.optString("customReferenceData");
                                                    JSONObject jSONObjectOptJSONObject = jSONObject2.optJSONObject("macros");
                                                    byte bOptInt = (byte) jSONObject2.optInt("impressionType");
                                                    Intrinsics.checkNotNull(string);
                                                    Intrinsics.checkNotNull(strOptString);
                                                    c3504oc.b = AbstractC3547s0.a(string, strOptString, zOptBoolean, jSONObjectOptJSONObject, bOptInt);
                                                    L4 l14 = this.j;
                                                    if (l14 != null) {
                                                        Intrinsics.checkNotNullExpressionValue("C0", "TAG");
                                                        ((M4) l14).c("C0", "Read out OMID params: " + c3504oc.b);
                                                    }
                                                    set.add(c3504oc);
                                                }
                                            }
                                        }
                                        if (jSONObjectC != null && jSONObjectC.has("viewability")) {
                                            L4 l15 = this.j;
                                            if (l15 != null) {
                                                Intrinsics.checkNotNullExpressionValue("C0", "TAG");
                                                ((M4) l15).c("C0", "checking viewability info");
                                            }
                                            JSONArray jSONArray = jSONObjectC.getJSONArray("viewability");
                                            Intrinsics.checkNotNullExpressionValue(jSONArray, "getJSONArray(...)");
                                            HashMap mapA = a(jSONArray);
                                            if (mapA != null && !mapA.isEmpty()) {
                                                L4 l16 = this.j;
                                                if (l16 != null) {
                                                    Intrinsics.checkNotNullExpressionValue("C0", "TAG");
                                                    ((M4) l16).c("C0", "checking for inmobi trackers");
                                                }
                                                C3504oc c3504oc2 = new C3504oc((byte) 2);
                                                c3504oc2.b = mapA;
                                                set.add(c3504oc2);
                                            }
                                        }
                                        if (jSONObjectC != null) {
                                            z4 = true;
                                            if (jSONObjectC.has("tracking") && Intrinsics.areEqual("web", jSONObjectC.getString("tracking"))) {
                                                this.k = (byte) 0;
                                            }
                                        } else {
                                            z4 = true;
                                        }
                                    }
                                    z3 = z4;
                                } catch (IllegalArgumentException e) {
                                    e = e;
                                    strX = "errorCode";
                                    str = strX;
                                    z2 = false;
                                    l6 = this.j;
                                    if (l6 != null) {
                                        Intrinsics.checkNotNullExpressionValue("C0", "TAG");
                                        ((M4) l6).a("C0", "Invalid Base64 encoding in received ad.", e);
                                    }
                                    C3339d5 c3339d5 = C3339d5.f3292a;
                                    P1 event = new P1(e);
                                    Intrinsics.checkNotNullParameter(event, "event");
                                    C3339d5.c.a(event);
                                    if (z) {
                                        map2 = new HashMap();
                                        map2.put(str, (short) 2121);
                                        message2 = e.getMessage();
                                        if (message2 != null) {
                                            map2.put(obj, message2);
                                        }
                                        b((Map<String, Object>) map2);
                                    }
                                    z3 = z2;
                                } catch (JSONException e2) {
                                    e = e2;
                                    strX = "errorCode";
                                    str = strX;
                                    z2 = false;
                                    l4 = this.j;
                                    if (l4 != null) {
                                        Intrinsics.checkNotNullExpressionValue("C0", "TAG");
                                        ((M4) l4).a("C0", "Exception while parsing received ad.", e);
                                    }
                                    C3339d5 c3339d6 = C3339d5.f3292a;
                                    P1 p1 = new P1(e);
                                    Intrinsics.checkNotNullParameter(p1, str2);
                                    C3339d5.c.a(p1);
                                    if (z) {
                                        map = new HashMap();
                                        map.put(str, (short) 2120);
                                        message = e.getMessage();
                                        if (message != null) {
                                            map.put(obj, message);
                                        }
                                        b((Map<String, Object>) map);
                                    }
                                    z3 = z2;
                                }
                                l5 = this.j;
                                if (l5 != null) {
                                    Intrinsics.checkNotNullExpressionValue("C0", "TAG");
                                    ((M4) l5).a("C0", "Parsing result - " + z3);
                                }
                                return z3;
                            }
                            try {
                                L4 l17 = this.j;
                                if (l17 != null) {
                                    Intrinsics.checkNotNullExpressionValue("C0", "TAG");
                                    ((M4) l17).a("C0", "empty punContent - fail");
                                }
                                if (!z) {
                                    return false;
                                }
                                try {
                                    HashMap map7 = new HashMap();
                                    str = "errorCode";
                                    try {
                                        map7.put(str, (short) 2162);
                                        b((Map<String, Object>) map7);
                                        return false;
                                    } catch (IllegalArgumentException e3) {
                                        e = e3;
                                        z2 = false;
                                        l6 = this.j;
                                        if (l6 != null) {
                                            Intrinsics.checkNotNullExpressionValue("C0", "TAG");
                                            ((M4) l6).a("C0", "Invalid Base64 encoding in received ad.", e);
                                        }
                                        C3339d5 c3339d7 = C3339d5.f3292a;
                                        P1 event2 = new P1(e);
                                        Intrinsics.checkNotNullParameter(event2, "event");
                                        C3339d5.c.a(event2);
                                        if (z) {
                                            map2 = new HashMap();
                                            map2.put(str, (short) 2121);
                                            message2 = e.getMessage();
                                            if (message2 != null) {
                                                map2.put(obj, message2);
                                            }
                                            b((Map<String, Object>) map2);
                                        }
                                        z3 = z2;
                                        l5 = this.j;
                                        if (l5 != null) {
                                            Intrinsics.checkNotNullExpressionValue("C0", "TAG");
                                            ((M4) l5).a("C0", "Parsing result - " + z3);
                                        }
                                        return z3;
                                    } catch (JSONException e4) {
                                        e = e4;
                                        z2 = false;
                                        l4 = this.j;
                                        if (l4 != null) {
                                            Intrinsics.checkNotNullExpressionValue("C0", "TAG");
                                            ((M4) l4).a("C0", "Exception while parsing received ad.", e);
                                        }
                                        C3339d5 c3339d8 = C3339d5.f3292a;
                                        P1 p2 = new P1(e);
                                        Intrinsics.checkNotNullParameter(p2, str2);
                                        C3339d5.c.a(p2);
                                        if (z) {
                                            map = new HashMap();
                                            map.put(str, (short) 2120);
                                            message = e.getMessage();
                                            if (message != null) {
                                                map.put(obj, message);
                                            }
                                            b((Map<String, Object>) map);
                                        }
                                        z3 = z2;
                                        l5 = this.j;
                                        if (l5 != null) {
                                            Intrinsics.checkNotNullExpressionValue("C0", "TAG");
                                            ((M4) l5).a("C0", "Parsing result - " + z3);
                                        }
                                        return z3;
                                    }
                                } catch (JSONException e5) {
                                    e = e5;
                                    str = "errorCode";
                                }
                            } catch (JSONException e6) {
                                e = e6;
                                str = "errorCode";
                            }
                        } catch (JSONException e7) {
                            e = e7;
                        }
                    } catch (IllegalArgumentException e8) {
                        e = e8;
                    }
                } catch (JSONException e9) {
                    e = e9;
                    str = "errorCode";
                }
                z2 = false;
                obj = obj;
                str2 = str2;
            } catch (IllegalArgumentException e10) {
                e = e10;
                str = "errorCode";
            }
        } catch (JSONException e11) {
            e = e11;
            str = "errorCode";
        }
        l4 = this.j;
        if (l4 != null) {
            Intrinsics.checkNotNullExpressionValue("C0", "TAG");
            ((M4) l4).a("C0", "Exception while parsing received ad.", e);
        }
        C3339d5 c3339d9 = C3339d5.f3292a;
        P1 p3 = new P1(e);
        Intrinsics.checkNotNullParameter(p3, str2);
        C3339d5.c.a(p3);
        if (z) {
            map = new HashMap();
            map.put(str, (short) 2120);
            message = e.getMessage();
            if (message != null) {
                map.put(obj, message);
            }
            b((Map<String, Object>) map);
        }
        z3 = z2;
        l5 = this.j;
        if (l5 != null) {
            Intrinsics.checkNotNullExpressionValue("C0", "TAG");
            ((M4) l5).a("C0", "Parsing result - " + z3);
        }
        return z3;
    }

    public final void f() {
        L4 l4 = this.j;
        if (l4 != null) {
            ((M4) l4).c("C0", AbstractC3492o0.a("C0", "TAG", "checkInteractiveAndSignal ", this));
        }
        if (this.m && this.p && this.q) {
            r0();
        }
    }

    public final HashMap a(JSONArray jSONArray) {
        JSONObject jSONObject;
        L4 l4 = this.j;
        if (l4 != null) {
            ((M4) l4).a("C0", AbstractC3492o0.a("C0", "TAG", "parseInMobiViewabilityParams ", this));
        }
        try {
            int length = jSONArray.length();
            int i = 0;
            while (true) {
                if (i >= length) {
                    jSONObject = null;
                    break;
                }
                JSONObject jSONObject2 = jSONArray.getJSONObject(i);
                if (jSONObject2.has("inmobi")) {
                    jSONObject = jSONObject2.getJSONObject("inmobi");
                    break;
                }
                i++;
            }
            if (jSONObject == null) {
                return null;
            }
            HashMap map = new HashMap();
            String strOptString = jSONObject.optString("time");
            Intrinsics.checkNotNullExpressionValue(strOptString, "optString(...)");
            int iB = b(strOptString);
            if (iB != -1) {
                map.put("time", Integer.valueOf(iB));
            }
            String strOptString2 = jSONObject.optString("view");
            Intrinsics.checkNotNullExpressionValue(strOptString2, "optString(...)");
            int iB2 = b(strOptString2);
            if (iB2 != -1) {
                map.put("view", Integer.valueOf(iB2));
            }
            String strOptString3 = jSONObject.optString("pixel");
            Intrinsics.checkNotNullExpressionValue(strOptString3, "optString(...)");
            int iB3 = b(strOptString3);
            if (iB3 != -1) {
                map.put("pixel", Integer.valueOf(iB3));
            }
            int iOptInt = jSONObject.optInt("type");
            if (iOptInt != -1) {
                map.put("type", Integer.valueOf(iOptInt));
                if (iOptInt == 2) {
                    JSONArray jSONArrayOptJSONArray = jSONObject.optJSONArray(TypedValues.AttributesType.S_FRAME);
                    if (jSONArrayOptJSONArray != null && jSONArrayOptJSONArray.length() == 4) {
                        JSONArray jSONArrayOptJSONArray2 = jSONObject.optJSONArray(TypedValues.AttributesType.S_FRAME);
                        Intrinsics.checkNotNullExpressionValue(jSONArrayOptJSONArray2, "optJSONArray(...)");
                        map.put(TypedValues.AttributesType.S_FRAME, jSONArrayOptJSONArray2);
                    } else {
                        map.put(TypedValues.AttributesType.S_FRAME, new JSONArray("[0,0,0,0]"));
                    }
                }
            }
            return map;
        } catch (JSONException e) {
            L4 l5 = this.j;
            if (l5 != null) {
                ((M4) l5).b("C0", AbstractC3506p0.a(e, O5.a("C0", "TAG", "Exception while parsing MoatParams from response : ")));
            }
            C3339d5 c3339d5 = C3339d5.f3292a;
            P1 event = new P1(e);
            Intrinsics.checkNotNullParameter(event, "event");
            C3339d5.c.a(event);
            return null;
        }
    }

    @Override // com.inmobi.media.K
    public void a(int i, Ba renderView, Context context) {
        Intrinsics.checkNotNullParameter(renderView, "renderView");
        L4 l4 = this.j;
        if (l4 != null) {
            Intrinsics.checkNotNullExpressionValue("C0", "TAG");
            ((M4) l4).c("C0", "Show pod ad with index : " + i + " from creative: " + this.g.indexOf(renderView) + ' ' + this);
        }
        if (i >= 0) {
            this.x = i;
        } else {
            this.x++;
        }
    }

    @Override // com.inmobi.media.K
    public void a(Ba renderView, Context context) {
        Intrinsics.checkNotNullParameter(renderView, "renderView");
        L4 l4 = this.j;
        if (l4 != null) {
            ((M4) l4).c("C0", AbstractC3492o0.a("C0", "TAG", "closeCurrentPodAd ", this));
        }
    }

    public void a(J placement, boolean z, short s) {
        Intrinsics.checkNotNullParameter(placement, "placement");
        L4 l4 = this.j;
        if (l4 != null) {
            ((M4) l4).a("C0", AbstractC3492o0.a("C0", "TAG", "onAssetAvailabilityChanged ", this));
        }
        if (this.o || t() == null) {
            return;
        }
        if (s != 0) {
            b(s);
        }
        a(placement, z);
    }

    public static final void c(C0 c0) {
        int i;
        String str;
        L4 l4 = c0.j;
        if (l4 != null) {
            ((M4) l4).a("C0", AbstractC3492o0.a("C0", "TAG", "startAdFetchWorker ", c0));
        }
        E0 e0 = c0.I;
        e0.getClass();
        e0.d = SystemClock.elapsedRealtime();
        L4 l5 = c0.j;
        if (l5 != null) {
            ((M4) l5).a("C0", AbstractC3492o0.a("C0", "TAG", "doAdLoadWork ", c0));
        }
        try {
            c0.d((byte) 1);
            L4 l6 = c0.j;
            if (l6 != null) {
                Intrinsics.checkNotNullExpressionValue("C0", "TAG");
                ((M4) l6).d("C0", "AdUnit " + c0 + " state - LOADING");
            }
            L4 l7 = c0.j;
            if (l7 != null) {
                Intrinsics.checkNotNullExpressionValue("C0", "TAG");
                ((M4) l7).c("C0", "printPublisherTestId " + c0);
            }
            C3532qc.f3412a.d();
            i = 0;
            if (c0.e((byte) 0)) {
                C3575u c3575u = c0.C;
                int iHashCode = c0.hashCode();
                C3617x c3617x = new C3617x(c0, c0.j);
                c3575u.getClass();
                C3575u.a(iHashCode, c3617x);
            } else {
                i = -2;
            }
        } catch (Exception e) {
            L4 l8 = c0.j;
            if (l8 != null) {
                ((M4) l8).b("C0", ld.a(e, O5.a("C0", "TAG", "Load failed with unexpected error: ")));
            }
            C3339d5 c3339d5 = C3339d5.f3292a;
            C3339d5.c.a(I4.a(e, "event"));
            c0.a(new InMobiAdRequestStatus(InMobiAdRequestStatus.StatusCode.INTERNAL_ERROR), true, (short) 2000);
        }
        if (i == -2) {
            str = "Loading an ad resulted in an unexpected error";
        } else if (i == -1) {
            str = "Ad request skipped as monetization is disabled";
        } else if (i == 0) {
            str = "Fresh ad requested";
        } else if (i == 1) {
            str = "Returning pre-cached ad";
        } else if (i != 2) {
            str = "Unknown return value (" + i + ") from #doAdLoadWork()";
        } else {
            str = "Already Loading";
        }
        L4 l9 = c0.j;
        if (l9 != null) {
            Intrinsics.checkNotNullExpressionValue("C0", "TAG");
            ((M4) l9).c("C0", str);
        }
    }

    /* JADX WARN: Code duplicated, block: B:48:0x0134  */
    public final short c(AbstractC3520q0 adUnitEventListener) {
        String str;
        String str2;
        String str3;
        L4 l4;
        HashMap mapA;
        short s;
        C3313b7 c3313b7;
        String str4 = "event";
        Intrinsics.checkNotNullParameter(adUnitEventListener, "adUnitEventListener");
        L4 l5 = this.j;
        String str5 = "TAG";
        String str6 = "C0";
        if (l5 != null) {
            ((M4) l5).c("C0", AbstractC3492o0.a("C0", "TAG", "loadMarkupInContainerNative ", this));
        }
        WeakReference weakReference = new WeakReference(adUnitEventListener);
        try {
            try {
                try {
                    try {
                        byte bJ = J();
                        JSONObject jSONObject = new JSONObject(L());
                        AdConfig adConfig = this.b;
                        Intrinsics.checkNotNull(adConfig);
                        C3418j0 c3418j0 = this.u;
                        if (c3418j0 == null) {
                            mapA = null;
                        } else {
                            boolean z = W8.f3228a;
                            mapA = W8.a(c3418j0.h());
                        }
                        C3625x7 dataModel = new C3625x7(bJ, jSONObject, adConfig, mapA, B0(), this.j);
                        C3389h c3389hM = m();
                        if (!dataModel.f() || t() == null || c3389hM == null) {
                            return (short) 20;
                        }
                        L4 l6 = this.j;
                        if (l6 != null) {
                            Intrinsics.checkNotNullExpressionValue("C0", "TAG");
                            ((M4) l6).a("C0", "creating native ad container");
                        }
                        Context context = t();
                        Intrinsics.checkNotNull(context);
                        byte bJ2 = J();
                        String adImpressionId = c3389hM.s();
                        Set setD = d(0);
                        AdConfig adConfig2 = this.b;
                        Intrinsics.checkNotNull(adConfig2);
                        long jL = this.t.l();
                        boolean zB = b(0);
                        String creativeId = c3389hM.o();
                        str = "event";
                        try {
                            try {
                                str2 = "TAG";
                                str3 = "C0";
                                try {
                                    J2 j2 = new J2(c3389hM, this.t.l());
                                    C3297a6 c3297a6L0 = l0();
                                    L4 l7 = this.j;
                                    Intrinsics.checkNotNullParameter(context, "context");
                                    Intrinsics.checkNotNullParameter(dataModel, "dataModel");
                                    Intrinsics.checkNotNullParameter(adImpressionId, "adImpressionId");
                                    Intrinsics.checkNotNullParameter(adConfig2, "adConfig");
                                    Intrinsics.checkNotNullParameter(creativeId, "creativeId");
                                    if (dataModel.c().contains(ShareConstants.VIDEO_URL)) {
                                        s = 0;
                                        c3313b7 = new C3398h8(context, bJ2, dataModel, adImpressionId, setD, adConfig2, jL, zB, creativeId, j2, c3297a6L0, l7);
                                    } else {
                                        s = 0;
                                        c3313b7 = new C3313b7(context, bJ2, dataModel, adImpressionId, setD, adConfig2, jL, zB, creativeId, j2, c3297a6L0, l7);
                                    }
                                    c3313b7.w = new A0(this, weakReference);
                                    this.h = c3313b7;
                                    c3313b7.R = this.H;
                                    return s;
                                } catch (IllegalStateException e) {
                                    e = e;
                                    str5 = str2;
                                    str6 = str3;
                                } catch (Exception e2) {
                                    e = e2;
                                    l4 = this.j;
                                    if (l4 != null) {
                                        String str7 = str3;
                                        ((M4) l4).b(str7, ld.a(e, O5.a(str7, str2, "Encountered unexpected error in loading ad markup into container: ")));
                                    }
                                    C3339d5 c3339d5 = C3339d5.f3292a;
                                    C3339d5.c.a(I4.a(e, str));
                                    return (short) 88;
                                }
                            } catch (Exception e3) {
                                e = e3;
                                str2 = "TAG";
                                str3 = "C0";
                                l4 = this.j;
                                if (l4 != null) {
                                    String str8 = str3;
                                    ((M4) l4).b(str8, ld.a(e, O5.a(str8, str2, "Encountered unexpected error in loading ad markup into container: ")));
                                }
                                C3339d5 c3339d6 = C3339d5.f3292a;
                                C3339d5.c.a(I4.a(e, str));
                                return (short) 88;
                            }
                        } catch (JSONException e4) {
                            e = e4;
                            str4 = str;
                            C3339d5 c3339d7 = C3339d5.f3292a;
                            P1 p1 = new P1(e);
                            Intrinsics.checkNotNullParameter(p1, str4);
                            C3339d5.c.a(p1);
                            return (short) 13;
                        }
                    } catch (JSONException e5) {
                        e = e5;
                    }
                } catch (IllegalStateException e6) {
                    e = e6;
                }
            } catch (IllegalStateException e7) {
                e = e7;
            } catch (JSONException e8) {
                e = e8;
            }
        } catch (Exception e9) {
            e = e9;
            str = "event";
        }
        L4 l8 = this.j;
        if (l8 != null) {
            Intrinsics.checkNotNullExpressionValue(str6, str5);
            ((M4) l8).a(str6, "Error while setting video descriptor", e);
        }
        return (short) 83;
    }

    public void a(J placement, boolean z) {
        Intrinsics.checkNotNullParameter(placement, "placement");
        L4 l4 = this.j;
        if (l4 != null) {
            ((M4) l4).c("C0", AbstractC3492o0.a("C0", "TAG", "handleAssetAvailabilityChanged ", this));
        }
        L4 l5 = this.j;
        if (l5 != null) {
            Intrinsics.checkNotNullExpressionValue("C0", "TAG");
            ((M4) l5).a("C0", "Asset availability changed (" + z + ") for placement ID (" + placement + ')');
        }
    }

    public static final void b(C0 this$0, Ba renderView) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(renderView, "$renderView");
        this$0.b(renderView, (short) 2137);
    }

    public void b(Ba ba, short s) {
        List<String> listC;
        L4 l4 = this.j;
        if (l4 != null) {
            ((M4) l4).b("C0", O5.a("C0", "TAG", "Render view signaled ad failed, for index ").append(this.g.indexOf(ba)).append(' ').append(this).toString());
        }
        if (ba == null || !Intrinsics.areEqual(ba.getMarkupType(), "htmlUrl")) {
            return;
        }
        int iIndexOf = this.g.indexOf(ba);
        L4 l5 = this.j;
        if (l5 != null) {
            Intrinsics.checkNotNullExpressionValue("C0", "TAG");
            ((M4) l5).b("C0", "fireLoadAdTokenUrlFailed : " + iIndexOf + ' ' + this);
        }
        C3389h c3389hA = a(iIndexOf);
        if (c3389hA == null || (listC = c3389hA.c(C3389h.LOAD_AD_TOKEN_URL_FAILURE)) == null) {
            return;
        }
        Iterator<String> it = listC.iterator();
        while (it.hasNext()) {
            C3364f2.f3308a.a(it.next(), true, this.j);
        }
    }

    public static final void d(C0 this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (6 == this$0.f3036a) {
            this$0.a(true, (short) 2158);
        }
    }

    public void a(C3418j0 adSet) {
        LinkedList<C3389h> linkedListF;
        LinkedList<C3389h> linkedListF2;
        Intrinsics.checkNotNullParameter(adSet, "adSet");
        L4 l4 = this.j;
        if (l4 != null) {
            ((M4) l4).c("C0", AbstractC3492o0.a("C0", "TAG", "handleAdFetchSuccessful ", this));
        }
        if (this.f3036a == 1) {
            this.u = adSet;
            int size = 0;
            this.A = adSet != null ? adSet.n() : false;
            C3418j0 c3418j0 = this.u;
            if (c3418j0 != null && (linkedListF2 = c3418j0.f()) != null) {
                size = linkedListF2.size();
            }
            this.g = new ArrayList(size);
            C3418j0 c3418j1 = this.u;
            if (c3418j1 != null && (linkedListF = c3418j1.f()) != null) {
                for (C3389h c3389h : linkedListF) {
                    this.g.add(null);
                }
            }
            C3389h c3389hP = adSet.p();
            if (c3389hP == null) {
                L4 l5 = this.j;
                if (l5 != null) {
                    Intrinsics.checkNotNullExpressionValue("C0", "TAG");
                    ((M4) l5).b("C0", "top ad is null. failed.");
                }
                b(new InMobiAdRequestStatus(InMobiAdRequestStatus.StatusCode.INTERNAL_ERROR), true, (short) 2119);
                return;
            }
            L4 l6 = this.j;
            if (l6 != null) {
                Intrinsics.checkNotNullExpressionValue("C0", "TAG");
                ((M4) l6).a("C0", "starting executor. parsing ad response");
            }
            C3575u c3575u = this.C;
            int iHashCode = hashCode();
            C3571t9 c3571t9 = new C3571t9(this, c3389hP, adSet, new InMobiAdRequestStatus(InMobiAdRequestStatus.StatusCode.INTERNAL_ERROR), this.j);
            c3575u.getClass();
            C3575u.a(iHashCode, c3571t9);
            return;
        }
        L4 l7 = this.j;
        if (l7 != null) {
            ((M4) l7).b("C0", O5.a("C0", "TAG", "incorrect state - ").append((int) this.f3036a).toString());
        }
        b(new InMobiAdRequestStatus(InMobiAdRequestStatus.StatusCode.INTERNAL_ERROR), true, (short) 2118);
    }

    public final void f(int i) {
        L4 l4 = this.j;
        if (l4 != null) {
            ((M4) l4).c("C0", AbstractC3492o0.a("C0", "TAG", "resetCurrentRenderingIndex ", this));
        }
        this.x = i;
    }

    @Override // com.inmobi.media.K
    public boolean a(Ba renderView) {
        Intrinsics.checkNotNullParameter(renderView, "renderView");
        L4 l4 = this.j;
        if (l4 == null) {
            return false;
        }
        ((M4) l4).c("C0", AbstractC3492o0.a("C0", "TAG", "hasNextAdInAdPod ", this));
        return false;
    }

    @Override // com.inmobi.media.Da
    public void b(HashMap<Object, Object> rewards) {
        Intrinsics.checkNotNullParameter(rewards, "rewards");
        L4 l4 = this.j;
        if (l4 != null) {
            ((M4) l4).c("C0", AbstractC3492o0.a("C0", "TAG", "onAdRewardActionCompleted ", this));
        }
        if (this.o || t() == null) {
            return;
        }
        L4 l5 = this.j;
        if (l5 != null) {
            Intrinsics.checkNotNullExpressionValue("C0", "TAG");
            ((M4) l5).a("C0", "Ad reward action completed. Params:" + rewards);
        }
        AbstractC3520q0 abstractC3520q0R = r();
        if (abstractC3520q0R != null) {
            abstractC3520q0R.b(rewards);
        }
    }

    public static final void c(C0 this$0, Ba renderView) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(renderView, "$renderView");
        this$0.l(renderView);
    }

    @Override // com.inmobi.media.Da
    public void c() {
        L4 l4 = this.j;
        if (l4 != null) {
            ((M4) l4).c("C0", AbstractC3492o0.a("C0", "TAG", "onAdScreenDisplayFailed ", this));
        }
        if (this.o || t() == null) {
            return;
        }
        L4 l5 = this.j;
        if (l5 != null) {
            Intrinsics.checkNotNullExpressionValue("C0", "TAG");
            ((M4) l5).b("C0", "Ad failed to display");
        }
        Handler handler = this.l;
        if (handler != null) {
            handler.post(new Runnable() { // from class: com.inmobi.media.C0$$ExternalSyntheticLambda5
                @Override // java.lang.Runnable
                public final void run() {
                    C0.d(this.f$0);
                }
            });
        }
    }

    public final void b(short s) {
        long j;
        long jElapsedRealtime;
        Boolean boolO;
        String strP;
        L4 l4 = this.j;
        if (l4 != null) {
            ((M4) l4).c("C0", AbstractC3492o0.a("C0", "TAG", "submitAdLoadFailedEvent ", this));
        }
        HashMap map = new HashMap();
        if (s == 2138 || s == 2109) {
            j = this.I.d;
            ScheduledExecutorService scheduledExecutorService = Ec.f3062a;
            jElapsedRealtime = SystemClock.elapsedRealtime();
        } else if (s == 2139) {
            j = this.I.g;
            ScheduledExecutorService scheduledExecutorService2 = Ec.f3062a;
            jElapsedRealtime = SystemClock.elapsedRealtime();
        } else {
            j = this.I.c;
            ScheduledExecutorService scheduledExecutorService3 = Ec.f3062a;
            jElapsedRealtime = SystemClock.elapsedRealtime();
        }
        map.put("latency", Long.valueOf(jElapsedRealtime - j));
        map.put("errorCode", Short.valueOf(s));
        map.put("markupType", E());
        C3389h c3389hU = u();
        if (c3389hU != null && (strP = c3389hU.p()) != null) {
            map.put("creativeType", "\"" + strP + '\"');
        }
        C3525q5 c3525q5 = this.E;
        if (c3525q5 != null) {
            map.put("retryCount", Integer.valueOf(c3525q5.b));
        }
        C3418j0 c3418j0 = this.u;
        if (c3418j0 != null && (boolO = c3418j0.o()) != null) {
            map.put("isRewarded", boolO);
        }
        if (S().length() > 0) {
            map.put("metadataBlob", S());
        }
        c(map);
        c((Map) map);
        c("AdLoadFailed", map);
    }

    @Override // com.inmobi.media.InterfaceC3346dc
    public void a(byte b) {
        L4 l4 = this.j;
        if (l4 != null) {
            ((M4) l4).a("C0", AbstractC3492o0.a("C0", "TAG", "onTimeOut ", this));
        }
        if (b == 0) {
            L4 l5 = this.j;
            if (l5 != null) {
                ((M4) l5).a("C0", O5.a("C0", "TAG", "AdRequestTimeOut by timer, Adstate=").append((int) this.f3036a).toString());
            }
            if (this.f3036a != 3) {
                a(this.t, new InMobiAdRequestStatus(InMobiAdRequestStatus.StatusCode.REQUEST_TIMED_OUT), (short) 2109);
                return;
            }
            return;
        }
        if (b != 2 && b != 1) {
            if (b == 4) {
                L4 l6 = this.j;
                if (l6 != null) {
                    Intrinsics.checkNotNullExpressionValue("C0", "TAG");
                    ((M4) l6).a("C0", "Show RequestTimeOut by show timer");
                }
                AbstractC3520q0 abstractC3520q0R = r();
                if (abstractC3520q0R != null) {
                    abstractC3520q0R.g();
                    return;
                }
                return;
            }
            if (b == 3) {
                L4 l7 = this.j;
                if (l7 != null) {
                    Intrinsics.checkNotNullExpressionValue("C0", "TAG");
                    ((M4) l7).a("C0", "Bitmap TimeOut not handled here");
                    return;
                }
                return;
            }
            L4 l8 = this.j;
            if (l8 != null) {
                Intrinsics.checkNotNullExpressionValue("C0", "TAG");
                ((M4) l8).a("C0", "Unknown TimeOut ignored");
                return;
            }
            return;
        }
        L4 l9 = this.j;
        if (l9 != null) {
            ((M4) l9).a("C0", O5.a("C0", "TAG", "Internal LoadTimeOut by timer, Adstate=").append((int) this.f3036a).toString());
        }
        if (this.f3036a != 3) {
            this.G.removeCallbacksAndMessages(null);
            L4 l10 = this.j;
            if (l10 != null) {
                ((M4) l10).a("C0", O5.a("C0", "TAG", "adUnitEventListener=").append(r()).append(", Adstate=").append((int) this.f3036a).toString());
            }
            byte b2 = this.f3036a;
            if (2 == b2) {
                m0();
                boolean z = W8.f3228a;
                b(W8.a(false) == null ? (short) 2139 : (short) 2203);
                AbstractC3520q0 abstractC3520q0R2 = r();
                if (abstractC3520q0R2 != null) {
                    abstractC3520q0R2.a(this, new InMobiAdRequestStatus(InMobiAdRequestStatus.StatusCode.INTERNAL_ERROR));
                    return;
                }
                return;
            }
            if (1 == b2) {
                m0();
                b((short) 2138);
                AbstractC3520q0 abstractC3520q0R3 = r();
                if (abstractC3520q0R3 != null) {
                    abstractC3520q0R3.a(this, new InMobiAdRequestStatus(InMobiAdRequestStatus.StatusCode.REQUEST_TIMED_OUT));
                }
            }
        }
    }

    public final void c(HashMap map) {
        L4 l4 = this.j;
        if (l4 != null) {
            ((M4) l4).c("C0", AbstractC3492o0.a("C0", "TAG", "constructTelemetryPayload ", this));
        }
        map.put(com.smaato.sdk.video.vast.model.Ad.AD_TYPE, q());
        map.put("networkType", C3435k3.q());
        map.put("plId", Long.valueOf(this.t.l()));
        String strM = this.t.m();
        if (strM != null) {
            map.put("plType", strM);
        }
    }

    public final void c(short s) {
        C3389h c3389hM;
        Boolean boolO;
        String strP;
        L4 l4 = this.j;
        if (l4 != null) {
            ((M4) l4).c("C0", AbstractC3492o0.a("C0", "TAG", "submitAdShowFailed ", this));
        }
        HashMap map = new HashMap();
        long j = this.I.e;
        ScheduledExecutorService scheduledExecutorService = Ec.f3062a;
        map.put("latency", Long.valueOf(SystemClock.elapsedRealtime() - j));
        map.put("errorCode", Short.valueOf(s));
        map.put("markupType", E());
        if (this.A) {
            c3389hM = a(this.x);
        } else {
            c3389hM = m();
        }
        if (c3389hM != null && (strP = c3389hM.p()) != null) {
            map.put("creativeType", "\"" + strP + '\"');
        }
        C3418j0 c3418j0 = this.u;
        if (c3418j0 != null && (boolO = c3418j0.o()) != null) {
            map.put("isRewarded", boolO);
        }
        if (S().length() > 0) {
            map.put("metadataBlob", S());
        }
        c(map);
        c((Map) map);
        c("AdShowFailed", map);
    }

    public void a(boolean z, InMobiAdRequestStatus status) {
        Intrinsics.checkNotNullParameter(status, "status");
        L4 l4 = this.j;
        if (l4 != null) {
            ((M4) l4).c("C0", AbstractC3492o0.a("C0", "TAG", "onDidParseAfterFetch ", this));
        }
        if (z) {
            L4 l5 = this.j;
            if (l5 != null) {
                Intrinsics.checkNotNullExpressionValue("C0", "TAG");
                ((M4) l5).a("C0", "Ad fetch successful");
            }
            L4 l6 = this.j;
            if (l6 != null) {
                Intrinsics.checkNotNullExpressionValue("C0", "TAG");
                ((M4) l6).d("C0", "AdUnit " + this + " state - AVAILABLE");
            }
            d((byte) 2);
            return;
        }
        L4 l7 = this.j;
        if (l7 != null) {
            Intrinsics.checkNotNullExpressionValue("C0", "TAG");
            ((M4) l7).b("C0", "onComplete parse success");
        }
        b(status, true, (short) 0);
    }

    public final void b(Map<String, Object> payload) {
        Boolean boolO;
        String strP;
        Intrinsics.checkNotNullParameter(payload, "payload");
        L4 l4 = this.j;
        if (l4 != null) {
            ((M4) l4).c("C0", AbstractC3492o0.a("C0", "TAG", "submitServerError ", this));
        }
        if (this.e == null) {
            return;
        }
        if (payload.get("reason") == null) {
            payload.put("reason", "");
        }
        C3389h c3389hU = u();
        if (c3389hU != null && (strP = c3389hU.p()) != null) {
            payload.put("creativeType", "\"" + strP + '\"');
        }
        C3525q5 c3525q5 = this.E;
        if (c3525q5 != null) {
            payload.put("retryCount", Integer.valueOf(c3525q5.b));
        }
        C3418j0 c3418j0 = this.u;
        if (c3418j0 != null && (boolO = c3418j0.o()) != null) {
            payload.put("isRewarded", boolO);
        }
        c(payload);
        C3462m0 c3462m0 = this.e;
        Intrinsics.checkNotNull(c3462m0);
        c3462m0.a(payload);
    }

    public final void a(J placement, InMobiAdRequestStatus requestStatus, short s) {
        Intrinsics.checkNotNullParameter(placement, "placement");
        Intrinsics.checkNotNullParameter(requestStatus, "requestStatus");
        L4 l4 = this.j;
        if (l4 != null) {
            ((M4) l4).a("C0", AbstractC3492o0.a("C0", "TAG", "onAdFetchFailed ", this));
        }
        if (!this.o && t() != null && this.f3036a != 3) {
            L4 l5 = this.j;
            if (l5 != null) {
                ((M4) l5).c("C0", AbstractC3492o0.a("C0", "TAG", "handleMarkupFetchFailure ", this));
            }
            try {
                if (Intrinsics.areEqual(this.t, placement) && this.f3036a == 1) {
                    L4 l6 = this.j;
                    if (l6 != null) {
                        Intrinsics.checkNotNullExpressionValue("C0", "TAG");
                        ((M4) l6).b("C0", "Failed to fetch ad for placement id: " + placement + ", reason - " + requestStatus.getMessage());
                    }
                    String str = "MarkupFetch failed reason is: " + requestStatus.getMessage();
                    L4 l7 = this.j;
                    if (l7 != null) {
                        Intrinsics.checkNotNullExpressionValue("C0", "TAG");
                        ((M4) l7).b("C0", str);
                    }
                    L4 l8 = this.j;
                    if (l8 != null) {
                        Intrinsics.checkNotNullExpressionValue("C0", "TAG");
                        ((M4) l8).d("C0", "AdUnit " + this + " state - FAILED");
                    }
                    d((byte) 3);
                    b((byte) 1);
                    if (s != 0) {
                        a(s);
                    }
                    AbstractC3520q0 abstractC3520q0R = r();
                    if (abstractC3520q0R != null) {
                        abstractC3520q0R.a(requestStatus);
                        return;
                    }
                    L4 l9 = this.j;
                    if (l9 != null) {
                        ((M4) l9).a();
                        return;
                    }
                    return;
                }
                return;
            } catch (Exception e) {
                L4 l10 = this.j;
                if (l10 != null) {
                    Intrinsics.checkNotNullExpressionValue("C0", "TAG");
                    ((M4) l10).a("C0", "onAdFetchFailed with error: ", e);
                }
                C3339d5 c3339d5 = C3339d5.f3292a;
                C3339d5.c.a(I4.a(e, "event"));
                return;
            }
        }
        L4 l11 = this.j;
        if (l11 != null) {
            ((M4) l11).b("C0", O5.a("C0", "TAG", "callback ignored - isDestroyed - ").append(this.o).append(" context - ").append(t()).append(" state- ").append((int) this.f3036a).toString());
        }
    }

    public final void c(Map map) {
        L4 l4 = this.j;
        if (l4 != null) {
            ((M4) l4).c("C0", AbstractC3492o0.a("C0", "TAG", "updateIdsInTelemetryPayload ", this));
        }
        C3389h c3389hM = m();
        if (c3389hM != null) {
            map.put("creativeId", "\"" + c3389hM.o() + '\"');
            map.put("impressionId", "\"" + c3389hM.s() + '\"');
        }
    }

    public final void b(long j) {
        L4 l4 = this.j;
        if (l4 != null) {
            ((M4) l4).c("C0", AbstractC3492o0.a("C0", "TAG", "submitAdGetSignalsSucceeded ", this));
        }
        this.r = false;
        HashMap map = new HashMap();
        map.put(com.smaato.sdk.video.vast.model.Ad.AD_TYPE, q());
        map.put("latency", Long.valueOf(System.currentTimeMillis() - j));
        map.put("networkType", C3435k3.q());
        c("AdGetSignalsSucceeded", map);
    }

    public final void a(boolean z, short s) {
        L4 l4 = this.j;
        if (l4 != null) {
            Intrinsics.checkNotNullExpressionValue("C0", "TAG");
            ((M4) l4).b("C0", "handleAdShowFailure " + this + " errorCode - " + ((int) s));
        }
        if (z) {
            L4 l5 = this.j;
            if (l5 != null) {
                Intrinsics.checkNotNullExpressionValue("C0", "TAG");
                ((M4) l5).d("C0", "AdUnit " + this + " state - FAILED");
            }
            d((byte) 3);
            b((byte) 4);
        }
        AbstractC3520q0 abstractC3520q0R = r();
        if (abstractC3520q0R != null) {
            abstractC3520q0R.d();
        }
        if (s != 0) {
            c(s);
        }
    }

    public final void a(InMobiAdRequestStatus requestStatus, boolean z, short s) {
        Intrinsics.checkNotNullParameter(requestStatus, "requestStatus");
        L4 l4 = this.j;
        if (l4 != null) {
            Intrinsics.checkNotNullExpressionValue("C0", "TAG");
            ((M4) l4).b("C0", "handleAdFetchFailure " + this + " errorCode - " + ((int) s));
        }
        if (this.f3036a == 1 && z) {
            L4 l5 = this.j;
            if (l5 != null) {
                Intrinsics.checkNotNullExpressionValue("C0", "TAG");
                ((M4) l5).d("C0", "AdUnit " + this + " state - FAILED");
            }
            d((byte) 3);
            b((byte) 1);
        }
        AbstractC3520q0 abstractC3520q0R = r();
        if (abstractC3520q0R != null) {
            abstractC3520q0R.a(this, requestStatus);
        }
        if (s != 0) {
            a(s);
        }
    }

    public final void a(Map<String, String> map) {
        L4 l4 = this.j;
        if (l4 != null) {
            Intrinsics.checkNotNullExpressionValue("C0", "TAG");
            ((M4) l4).c("C0", "setPublisherSuppliedExtras " + this + " - " + map);
        }
        this.t.a(map);
    }

    public final void a(final JSONObject responseJson) {
        Intrinsics.checkNotNullParameter(responseJson, "responseJson");
        L4 l4 = this.j;
        if (l4 != null) {
            ((M4) l4).c("C0", AbstractC3492o0.a("C0", "TAG", "onAuctionClosed ", this));
        }
        new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.inmobi.media.C0$$ExternalSyntheticLambda1
            @Override // java.lang.Runnable
            public final void run() {
                C0.a(this.f$0, responseJson);
            }
        });
    }

    public final void c(String eventType, Map<String, Object> kv) {
        Intrinsics.checkNotNullParameter(eventType, "eventType");
        Intrinsics.checkNotNullParameter(kv, "kv");
        L4 l4 = this.j;
        if (l4 != null) {
            ((M4) l4).c("C0", AbstractC3492o0.a("C0", "TAG", "submitTelemetryEvent ", this));
        }
        Ob ob = Ob.f3160a;
        Ob.b(eventType, kv, Sb.SDK);
    }

    public static final void a(C0 this$0, JSONObject responseJson) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(responseJson, "$responseJson");
        C3575u c3575u = this$0.C;
        int iHashCode = this$0.hashCode();
        C3405i1 c3405i1 = new C3405i1(this$0, responseJson, this$0.j);
        c3575u.getClass();
        C3575u.a(iHashCode, c3405i1);
    }

    public final void a(final Function0 onSuccess, final Function1 onMaxRetryReached) {
        Intrinsics.checkNotNullParameter(onSuccess, "onSuccess");
        Intrinsics.checkNotNullParameter(onMaxRetryReached, "onMaxRetryReached");
        L4 l4 = this.j;
        Object c3582u6 = null;
        if (l4 != null) {
            StringBuilder sbA = O5.a("C0", "TAG", "loadWithRetry ");
            C3525q5 c3525q5 = this.E;
            ((M4) l4).c("C0", sbA.append(c3525q5 != null ? Integer.valueOf(c3525q5.b) : null).toString());
        }
        C3525q5 c3525q6 = this.E;
        if (c3525q6 != null) {
            boolean z = W8.f3228a;
            I3 i3A = W8.a(false);
            if (i3A == null) {
                c3582u6 = C3557s9.f3428a;
            } else {
                int i = c3525q6.b + 1;
                c3525q6.b = i;
                if (i >= c3525q6.f3405a.b) {
                    c3582u6 = new C3582u6(i3A);
                } else {
                    c3582u6 = C3358ea.f3303a;
                }
            }
        }
        if (c3582u6 instanceof C3582u6) {
            onMaxRetryReached.invoke(((C3582u6) c3582u6).f3444a);
            return;
        }
        if (c3582u6 instanceof C3557s9) {
            L4 l5 = this.j;
            if (l5 != null) {
                Intrinsics.checkNotNullExpressionValue("C0", "TAG");
                ((M4) l5).c("C0", "load with retry success");
            }
            onSuccess.invoke();
            return;
        }
        if (!(c3582u6 instanceof C3358ea)) {
            if (c3582u6 == null) {
                L4 l6 = this.j;
                if (l6 != null) {
                    Intrinsics.checkNotNullExpressionValue("C0", "TAG");
                    ((M4) l6).c("C0", "shouldProceedToLoad result null. starting as if we have internet.");
                }
                onSuccess.invoke();
                return;
            }
            return;
        }
        L4 l7 = this.j;
        if (l7 != null) {
            Intrinsics.checkNotNullExpressionValue("C0", "TAG");
            ((M4) l7).c("C0", "load failed, retrying");
        }
        Handler handler = this.G;
        Runnable runnable = new Runnable() { // from class: com.inmobi.media.C0$$ExternalSyntheticLambda7
            @Override // java.lang.Runnable
            public final void run() {
                C0.a(this.f$0, onSuccess, onMaxRetryReached);
            }
        };
        E6 e6 = this.F;
        handler.postDelayed(runnable, e6 != null ? e6.f3057a : 1000L);
    }

    /* JADX WARN: Code duplicated, block: B:30:0x0086  */
    /* JADX WARN: Code duplicated, block: B:32:0x008a  */
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    public void b(String eventType, Map<String, Object> kv) {
        C3389h c3389hU;
        String strP;
        C3525q5 c3525q5;
        Intrinsics.checkNotNullParameter(eventType, "eventType");
        Intrinsics.checkNotNullParameter(kv, "kv");
        L4 l4 = this.j;
        if (l4 != null) {
            Intrinsics.checkNotNullExpressionValue("C0", "TAG");
            ((M4) l4).c("C0", "onTelemetryEvent " + this + " adState=" + ((int) this.f3036a));
        }
        if (this.f3036a != 3) {
            L4 l5 = this.j;
            if (l5 != null) {
                ((M4) l5).c("C0", P5.a("C0", "TAG", "addRetryCountToTelemetryEvent event - ", eventType));
            }
            switch (eventType.hashCode()) {
                case -1959333523:
                    if (eventType.equals("RenderSuccess")) {
                        c3525q5 = this.E;
                        if (c3525q5 != null) {
                            kv.put("retryCount", Integer.valueOf(c3525q5.b));
                        }
                    }
                    break;
                case 167123846:
                    if (eventType.equals("ServerFill")) {
                        c3525q5 = this.E;
                        if (c3525q5 != null) {
                            kv.put("retryCount", Integer.valueOf(c3525q5.b));
                        }
                    }
                    break;
                case 885222501:
                    if (eventType.equals("ServerError")) {
                        c3525q5 = this.E;
                        if (c3525q5 != null) {
                            kv.put("retryCount", Integer.valueOf(c3525q5.b));
                        }
                    }
                    break;
                case 925075267:
                    if (eventType.equals("AdLoadSuccessful")) {
                        c3525q5 = this.E;
                        if (c3525q5 != null) {
                            kv.put("retryCount", Integer.valueOf(c3525q5.b));
                        }
                    }
                    break;
                case 1881615718:
                    if (eventType.equals("AdLoadFailed")) {
                        c3525q5 = this.E;
                        if (c3525q5 != null) {
                            kv.put("retryCount", Integer.valueOf(c3525q5.b));
                        }
                    }
                    break;
                case 1925668903:
                    if (eventType.equals("ServerNoFill")) {
                        c3525q5 = this.E;
                        if (c3525q5 != null) {
                            kv.put("retryCount", Integer.valueOf(c3525q5.b));
                        }
                    }
                    break;
            }
            if ((Intrinsics.areEqual(eventType, "ServerFill") ? true : Intrinsics.areEqual(eventType, "ServerError")) && (c3389hU = u()) != null && (strP = c3389hU.p()) != null) {
                kv.put("creativeType", strP);
            }
            c(eventType, kv);
        }
    }

    public final void b(byte b) {
        C3374fc c3374fc;
        L4 l4 = this.j;
        if (l4 != null) {
            ((M4) l4).a("C0", AbstractC3492o0.a("C0", "TAG", "cancelTimer ", this));
        }
        if (b == 1 && (c3374fc = this.v) != null) {
            Intrinsics.checkNotNullExpressionValue("fc", "TAG");
            Timer timer = (Timer) c3374fc.b.get((byte) 2);
            if (timer != null) {
                timer.cancel();
                c3374fc.b.remove((byte) 2);
            }
        }
        C3374fc c3374fc2 = this.v;
        if (c3374fc2 != null) {
            Intrinsics.checkNotNullExpressionValue("fc", "TAG");
            Timer timer2 = (Timer) c3374fc2.b.get(Byte.valueOf(b));
            if (timer2 != null) {
                timer2.cancel();
                c3374fc2.b.remove(Byte.valueOf(b));
            }
        }
    }

    public static final void a(C0 this$0, Function0 onSuccess, Function1 onMaxRetryReached) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(onSuccess, "$onSuccess");
        Intrinsics.checkNotNullParameter(onMaxRetryReached, "$onMaxRetryReached");
        L4 l4 = this$0.j;
        if (l4 != null) {
            StringBuilder sbA = O5.a("C0", "TAG", "Loading from retry Handler ");
            C3525q5 c3525q5 = this$0.E;
            ((M4) l4).c("C0", sbA.append(c3525q5 != null ? Integer.valueOf(c3525q5.b) : null).toString());
        }
        this$0.a(onSuccess, onMaxRetryReached);
    }

    public void c(byte b) {
        L4 l4 = this.j;
        if (l4 != null) {
            ((M4) l4).b("C0", AbstractC3492o0.a("C0", "TAG", "onOOM ", this));
        }
        if (b == 0) {
            a(this.t, new InMobiAdRequestStatus(InMobiAdRequestStatus.StatusCode.LOW_MEMORY), (short) 2110);
            return;
        }
        if (b == 2 || b == 1) {
            byte b2 = this.f3036a;
            if (b2 == 0 || 1 == b2 || 2 == b2) {
                L4 l5 = this.j;
                if (l5 != null) {
                    Intrinsics.checkNotNullExpressionValue("C0", "TAG");
                    ((M4) l5).a("C0", "onOOM INTERNAL_LOAD_TIME_OUT or PRE_LOAD_TIME_OUT");
                }
                this.G.removeCallbacksAndMessages(null);
                m0();
                b((short) 2112);
                AbstractC3520q0 abstractC3520q0R = r();
                if (abstractC3520q0R != null) {
                    abstractC3520q0R.a(this, new InMobiAdRequestStatus(InMobiAdRequestStatus.StatusCode.LOW_MEMORY));
                    return;
                }
                return;
            }
            return;
        }
        if (b == 4) {
            AbstractC3520q0 abstractC3520q0R2 = r();
            if (abstractC3520q0R2 != null) {
                abstractC3520q0R2.g();
                return;
            }
            return;
        }
        if (b == 3) {
            L4 l6 = this.j;
            if (l6 != null) {
                Intrinsics.checkNotNullExpressionValue("C0", "TAG");
                ((M4) l6).a("C0", "OOM Timeout scenario ignored for : " + ((int) b));
                return;
            }
            return;
        }
        L4 l7 = this.j;
        if (l7 != null) {
            Intrinsics.checkNotNullExpressionValue("C0", "TAG");
            ((M4) l7).a("C0", "OOM Timeout scenario ignored for : " + ((int) b));
        }
    }

    public void a(byte[] bArr) {
        L4 l4 = this.j;
        if (l4 != null) {
            ((M4) l4).c("C0", AbstractC3492o0.a("C0", "TAG", "load response ", this));
        }
        E0 e0 = this.I;
        e0.getClass();
        e0.c = SystemClock.elapsedRealtime();
        E0 e1 = this.I;
        e1.getClass();
        e1.h = SystemClock.elapsedRealtime();
        if (Y()) {
            L4 l5 = this.j;
            if (l5 != null) {
                Intrinsics.checkNotNullExpressionValue("C0", "TAG");
                ((M4) l5).a("C0", "isBlockingStateForLoadWithResponse - blocking");
                return;
            }
            return;
        }
        if (bArr != null && bArr.length != 0) {
            if (this.s == null) {
                this.s = new C3343d9(this);
            }
            C3646z0 c3646z0 = new C3646z0(this, bArr);
            if (p0()) {
                L4 l6 = this.j;
                if (l6 != null) {
                    Intrinsics.checkNotNullExpressionValue("C0", "TAG");
                    ((M4) l6).a("C0", "skipping internet check on load(byte[])");
                }
                c3646z0.invoke();
                return;
            }
            L4 l7 = this.j;
            if (l7 != null) {
                Intrinsics.checkNotNullExpressionValue("C0", "TAG");
                ((M4) l7).a("C0", "starting load with retry");
            }
            a(c3646z0, new C3632y0(this));
            return;
        }
        b(new InMobiAdRequestStatus(InMobiAdRequestStatus.StatusCode.INVALID_RESPONSE_IN_LOAD), true, (short) 2143);
        L4 l8 = this.j;
        if (l8 != null) {
            Intrinsics.checkNotNullExpressionValue("C0", "TAG");
            ((M4) l8).a("C0", "null response. failing");
        }
    }

    public final void b(int i, boolean z) {
        Ba ba;
        L4 l4 = this.j;
        if (l4 != null) {
            ((M4) l4).a("C0", AbstractC3492o0.a("C0", "TAG", "fireAdPodShowResult ", this));
        }
        ArrayList list = this.g;
        Intrinsics.checkNotNullParameter(list, "list");
        if (i < 0 || i >= list.size() || (ba = (Ba) this.g.get(i)) == null) {
            return;
        }
        ba.b(z);
    }

    public final void a(InMobiAdRequestStatus requestStatus, short s) {
        Intrinsics.checkNotNullParameter(requestStatus, "requestStatus");
        L4 l4 = this.j;
        if (l4 != null) {
            Intrinsics.checkNotNullExpressionValue("C0", "TAG");
            ((M4) l4).b("C0", "loadResponseFailed " + this + " errorCode - " + ((int) s));
        }
        b(requestStatus, true, s);
    }

    public final boolean a(AbstractC3520q0 abstractC3520q0, long j) {
        L4 l4 = this.j;
        if (l4 != null) {
            ((M4) l4).c("C0", AbstractC3492o0.a("C0", "TAG", "isBlockingStateForGetSignals ", this));
        }
        if (this.r) {
            AbstractC3498o6.a((byte) 2, "InMobi", "getSignals() call is already in progress. Please wait for its execution to get complete");
            L4 l5 = this.j;
            if (l5 != null) {
                Intrinsics.checkNotNullExpressionValue("C0", "TAG");
                ((M4) l5).b("C0", "getSignals() call is already in progress. Please wait for its execution to get complete");
            }
            return true;
        }
        if (!f0()) {
            return false;
        }
        if (abstractC3520q0 != null) {
            abstractC3520q0.b(new InMobiAdRequestStatus(InMobiAdRequestStatus.StatusCode.MISSING_REQUIRED_DEPENDENCIES));
        }
        a(2007, j);
        return true;
    }

    @Override // com.inmobi.media.Da
    public void c(Ba renderView) {
        List<String> listC;
        Intrinsics.checkNotNullParameter(renderView, "renderView");
        L4 l4 = this.j;
        if (l4 != null) {
            ((M4) l4).a("C0", AbstractC3492o0.a("C0", "TAG", "fireImpressionTracker ", this));
        }
        Intrinsics.checkNotNullParameter(renderView, "renderView");
        C3389h c3389hA = a(this.g.indexOf(renderView));
        if (((c3389hA != null ? c3389hA.p() : null) != null && Intrinsics.areEqual(c3389hA.p(), "video")) || c3389hA == null || (listC = c3389hA.c("impression")) == null) {
            return;
        }
        for (String str : listC) {
            Yb telemetryOnAdImpression = renderView.getTelemetryOnAdImpression();
            telemetryOnAdImpression.getClass();
            Intrinsics.checkNotNullParameter("adResponseTracker", "<set-?>");
            telemetryOnAdImpression.e = "adResponseTracker";
            C3364f2.f3308a.b(str, true, (J1) new C3631y(this.D, telemetryOnAdImpression), this.j);
        }
    }

    public final void a(WeakReference<AbstractC3520q0> listenerWeakReference, short s, InMobiAdRequestStatus status) {
        Intrinsics.checkNotNullParameter(listenerWeakReference, "listenerWeakReference");
        Intrinsics.checkNotNullParameter(status, "status");
        L4 l4 = this.j;
        if (l4 != null) {
            ((M4) l4).a("C0", AbstractC3492o0.a("C0", "TAG", "onLoadAdMarkupFailed ", this));
        }
        d((byte) 3);
        L4 l5 = this.j;
        if (l5 != null) {
            Intrinsics.checkNotNullExpressionValue("C0", "TAG");
            ((M4) l5).d("C0", "AdUnit " + this + " state - FAILED");
        }
        b((byte) 1);
        if (this.o) {
            L4 l6 = this.j;
            if (l6 != null) {
                Intrinsics.checkNotNullExpressionValue("C0", "TAG");
                ((M4) l6).b("C0", "AdUnit destroyed while onLoadAdMarkupFailed");
                return;
            }
            return;
        }
        AbstractC3520q0 abstractC3520q0 = listenerWeakReference.get();
        if (abstractC3520q0 != null) {
            if (Intrinsics.areEqual(com.safedk.android.analytics.brandsafety.l.w, q())) {
                a(abstractC3520q0, s);
                return;
            } else {
                b(s);
                abstractC3520q0.a(this, status);
                return;
            }
        }
        L4 l7 = this.j;
        if (l7 != null) {
            Intrinsics.checkNotNullExpressionValue("C0", "TAG");
            ((M4) l7).b("C0", "Listener was garbage collected.Unable to give callback");
        }
    }

    public final void a(WatermarkData watermarkData) {
        Intrinsics.checkNotNullParameter(watermarkData, "watermarkData");
        this.J = watermarkData;
        Ba baW = w();
        if (baW != null) {
            baW.setWatermark(watermarkData);
        }
    }

    public static /* synthetic */ void a(C0 c0, int i, boolean z, int i2, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: destroyContainer");
        }
        if ((i2 & 2) != 0) {
            z = true;
        }
        c0.a(i, z);
    }

    public final void a(int i, boolean z) {
        L4 l4 = this.j;
        if (l4 != null) {
            Intrinsics.checkNotNullExpressionValue("C0", "TAG");
            ((M4) l4).a("C0", "Destroying container for index " + i + ' ' + this);
        }
        ArrayList list = this.g;
        Intrinsics.checkNotNullParameter(list, "list");
        if (i < 0 || i >= list.size()) {
            return;
        }
        Ba ba = (Ba) this.g.get(i);
        if (ba != null) {
            ba.v0.set(z);
            ba.stopLoading();
            ba.b();
        }
        this.g.set(i, null);
    }

    @Override // com.inmobi.media.Da
    public void a(Ba renderView, String trackerName, Map<String, String> macros) {
        Intrinsics.checkNotNullParameter(renderView, "renderView");
        Intrinsics.checkNotNullParameter(trackerName, "trackerName");
        Intrinsics.checkNotNullParameter(macros, "macros");
        L4 l4 = this.j;
        if (l4 != null) {
            Intrinsics.checkNotNullExpressionValue("C0", "TAG");
            ((M4) l4).a("C0", "fireLandingPageTracker " + trackerName + ' ' + this);
        }
        C3389h c3389hA = a(this.g.indexOf(renderView));
        if (c3389hA != null) {
            List<String> listC = c3389hA.c(trackerName);
            if (listC == null) {
                return;
            }
            for (String str : listC) {
                String strReplace$default = str;
                for (Map.Entry<String, String> entry : macros.entrySet()) {
                    strReplace$default = StringsKt.replace$default(strReplace$default, entry.getKey(), entry.getValue(), false, 4, (Object) null);
                }
                C3364f2.f3308a.a(strReplace$default, true, this.j);
            }
            return;
        }
        L4 l5 = this.j;
        if (l5 != null) {
            Intrinsics.checkNotNullExpressionValue("C0", "TAG");
            ((M4) l5).a("C0", "fireLandingPageTracker failed");
        }
    }

    @Override // com.inmobi.media.Da
    public void a(String log) {
        Intrinsics.checkNotNullParameter(log, "log");
        AbstractC3520q0 abstractC3520q0R = r();
        if (abstractC3520q0R != null) {
            abstractC3520q0R.a(log);
        }
    }

    @Override // com.inmobi.media.Da
    public void b(Ba renderView) {
        List<String> listC;
        Intrinsics.checkNotNullParameter(renderView, "renderView");
        L4 l4 = this.j;
        if (l4 != null) {
            ((M4) l4).a("C0", AbstractC3492o0.a("C0", "TAG", "fireClickTracker ", this));
        }
        Intrinsics.checkNotNullParameter(renderView, "renderView");
        C3389h c3389hA = a(this.g.indexOf(renderView));
        if (((c3389hA != null ? c3389hA.p() : null) != null && Intrinsics.areEqual(c3389hA.p(), "video")) || c3389hA == null || (listC = c3389hA.c("click")) == null) {
            return;
        }
        Iterator<String> it = listC.iterator();
        while (it.hasNext()) {
            C3364f2.f3308a.a(it.next(), true, this.j);
        }
    }

    public void a(AbstractC3520q0 abstractC3520q0) {
        L4 l4 = this.j;
        if (l4 != null) {
            ((M4) l4).c("C0", AbstractC3492o0.a("C0", "TAG", "handleAdScreenDismissed ", this));
        }
    }

    @Override // com.inmobi.media.Da
    public void a(final Ba renderView, final short s) {
        Intrinsics.checkNotNullParameter(renderView, "renderView");
        L4 l4 = this.j;
        if (l4 != null) {
            ((M4) l4).c("C0", AbstractC3492o0.a("C0", "TAG", "onRenderViewError ", this));
        }
        if (this.o || t() == null) {
            return;
        }
        try {
            Handler handler = this.l;
            if (handler != null) {
                handler.post(new Runnable() { // from class: com.inmobi.media.C0$$ExternalSyntheticLambda4
                    @Override // java.lang.Runnable
                    public final void run() {
                        C0.a(this.f$0, renderView, s);
                    }
                });
            }
        } catch (Exception e) {
            L4 l5 = this.j;
            if (l5 != null) {
                ((M4) l5).b("C0", ld.a(e, O5.a("C0", "TAG", "Loading ad markup into container encountered an unexpected error: ")));
            }
        }
    }

    public static final void a(C0 this$0, Ba renderView, short s) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(renderView, "$renderView");
        this$0.b(renderView, s);
    }

    @Override // com.inmobi.media.Da
    public void a(HashMap<Object, Object> params) {
        Intrinsics.checkNotNullParameter(params, "params");
        L4 l4 = this.j;
        if (l4 != null) {
            ((M4) l4).c("C0", AbstractC3492o0.a("C0", "TAG", "onAdInteraction ", this));
        }
        if (this.o || t() == null) {
            return;
        }
        L4 l5 = this.j;
        if (l5 != null) {
            Intrinsics.checkNotNullExpressionValue("C0", "TAG");
            ((M4) l5).a("C0", "Ad interaction. Params: " + params);
        }
        AbstractC3520q0 abstractC3520q0R = r();
        if (abstractC3520q0R != null) {
            abstractC3520q0R.a(params);
        }
    }

    @Override // com.inmobi.media.Da
    public void a(final Yb telemetryOnAdImpression) {
        Intrinsics.checkNotNullParameter(telemetryOnAdImpression, "telemetryOnAdImpression");
        L4 l4 = this.j;
        if (l4 != null) {
            ((M4) l4).c("C0", AbstractC3492o0.a("C0", "TAG", "onImpressionFiredFromTemplate ", this));
        }
        telemetryOnAdImpression.getClass();
        Intrinsics.checkNotNullParameter("imraid_impressionFired", "<set-?>");
        telemetryOnAdImpression.e = "imraid_impressionFired";
        if (!this.o && t() != null) {
            L4 l5 = this.j;
            if (l5 != null) {
                Intrinsics.checkNotNullExpressionValue("C0", "TAG");
                ((M4) l5).a("C0", "onImpressionFiredFromTemplate");
            }
            Handler handler = this.l;
            if (handler != null) {
                handler.post(new Runnable() { // from class: com.inmobi.media.C0$$ExternalSyntheticLambda3
                    @Override // java.lang.Runnable
                    public final void run() {
                        C0.a(this.f$0, telemetryOnAdImpression);
                    }
                });
                return;
            }
            return;
        }
        telemetryOnAdImpression.b();
    }

    public static final void a(C0 this$0, Yb telemetryOnAdImpression) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(telemetryOnAdImpression, "$telemetryOnAdImpression");
        this$0.D.a(telemetryOnAdImpression);
    }

    @Override // com.inmobi.media.Da, com.inmobi.media.Cc
    public void a() {
        L4 l4 = this.j;
        if (l4 != null) {
            ((M4) l4).c("C0", AbstractC3492o0.a("C0", "TAG", "onUserLeaveApplication ", this));
        }
        if (this.o || t() == null) {
            return;
        }
        L4 l5 = this.j;
        if (l5 != null) {
            Intrinsics.checkNotNullExpressionValue("C0", "TAG");
            ((M4) l5).a("C0", "User left application");
        }
        AbstractC3520q0 abstractC3520q0R = r();
        if (abstractC3520q0R != null) {
            abstractC3520q0R.h();
        }
    }

    public final void a(short s) {
        L4 l4 = this.j;
        if (l4 != null) {
            ((M4) l4).c("C0", AbstractC3492o0.a("C0", "TAG", "submitAdLoadDroppedAtSDK ", this));
        }
        HashMap map = new HashMap();
        map.put("errorCode", Short.valueOf(s));
        c(map);
        c("AdLoadDroppedAtSDK", map);
    }

    public final void a(int i, long j) {
        L4 l4 = this.j;
        if (l4 != null) {
            ((M4) l4).c("C0", AbstractC3492o0.a("C0", "TAG", "submitAdGetSignalsFailed ", this));
        }
        this.r = false;
        HashMap map = new HashMap();
        map.put(com.smaato.sdk.video.vast.model.Ad.AD_TYPE, q());
        map.put("latency", Long.valueOf(System.currentTimeMillis() - j));
        map.put("networkType", C3435k3.q());
        map.put("errorCode", Integer.valueOf(i));
        c("AdGetSignalsFailed", map);
    }

    @Override // com.inmobi.media.Da
    public void a(String eventType, Map<String, Object> kv) {
        Intrinsics.checkNotNullParameter(eventType, "eventType");
        Intrinsics.checkNotNullParameter(kv, "kv");
        L4 l4 = this.j;
        if (l4 != null) {
            ((M4) l4).c("C0", AbstractC3492o0.a("C0", "TAG", "onRenderViewRequestedAction ", this));
        }
        c(eventType, kv);
    }

    /* JADX WARN: Code duplicated, block: B:136:0x03ad  */
    /* JADX WARN: Code duplicated, block: B:162:0x0419  */
    /* JADX WARN: Code duplicated, block: B:75:0x0221  */
    public final void a(C3389h ad) {
        boolean z;
        String str;
        L4 l4;
        String str2;
        String str3;
        HashMap mapA;
        String strA;
        VerificationScriptResource verificationScriptResourceCreateVerificationScriptResourceWithoutParameters;
        String str4;
        String str5;
        HashMap mapA2;
        String strA2;
        VerificationScriptResource verificationScriptResourceCreateVerificationScriptResourceWithoutParameters2;
        AdConfig.ViewabilityConfig viewability;
        ad = ad;
        Intrinsics.checkNotNullParameter(ad, "ad");
        L4 l5 = this.j;
        String str6 = "TAG";
        String str7 = "C0";
        if (l5 != null) {
            ((M4) l5).c("C0", AbstractC3492o0.a("C0", "TAG", "initOmidForAd ", this));
        }
        Context contextT = t();
        AdConfig adConfig = this.b;
        AdConfig.OmidConfig omidConfig = (adConfig == null || (viewability = adConfig.getViewability()) == null) ? null : viewability.getOmidConfig();
        if (omidConfig == null || omidConfig.isOmidEnabled()) {
            AbstractC3473m9.f3376a.getClass();
            if (Omid.isActive()) {
                boolean z2 = ad instanceof C3356e8;
                Set setD = d(0);
                if (setD != null) {
                    Iterator it = setD.iterator();
                    while (it.hasNext()) {
                        C3504oc c3504oc = (C3504oc) it.next();
                        if (3 == c3504oc.f3393a) {
                            Iterator it2 = it;
                            if ("video" == c3504oc.b.get("creativeType") && z2) {
                                C3356e8 c3356e8 = (C3356e8) ad;
                                L4 l6 = this.j;
                                if (l6 != null) {
                                    ((M4) l6).b(str7, AbstractC3492o0.a(str7, str6, "initOmidForNativeVideoAd ", this));
                                }
                                try {
                                    L4 l7 = this.j;
                                    if (l7 != null) {
                                        Intrinsics.checkNotNullExpressionValue(str7, str6);
                                        ((M4) l7).a(str7, "Processing OMID meta data to bootstrap impression tracking for this ad response");
                                    }
                                    String str8 = c3356e8.f3301a;
                                    String str9 = c3356e8.b;
                                    z = z2;
                                    try {
                                        String str10 = c3356e8.c;
                                        str2 = str6;
                                        try {
                                            ArrayList arrayList = c3356e8.d;
                                            ArrayList arrayList2 = c3356e8.e;
                                            str3 = str7;
                                            try {
                                                AdConfig adConfig2 = this.b;
                                                Intrinsics.checkNotNull(adConfig2);
                                                Qc qc = new Qc(str8, str9, str10, arrayList, arrayList2, adConfig2.getVastVideo());
                                                byte bJ = J();
                                                String strL = L();
                                                Intrinsics.checkNotNull(strL);
                                                JSONObject pubContent = new JSONObject(strL);
                                                AdConfig adConfig3 = this.b;
                                                Intrinsics.checkNotNull(adConfig3);
                                                C3418j0 c3418j0 = this.u;
                                                if (c3418j0 == null) {
                                                    mapA2 = null;
                                                } else {
                                                    boolean z3 = W8.f3228a;
                                                    mapA2 = W8.a(c3418j0.h());
                                                }
                                                L4 l8 = this.j;
                                                Intrinsics.checkNotNullParameter(pubContent, "pubContent");
                                                Intrinsics.checkNotNullParameter(adConfig3, "adConfig");
                                                C3625x7 c3625x7 = new C3625x7(bJ, pubContent, null, false, adConfig3, mapA2, qc, l8);
                                                Object obj = c3625x7.n(ShareConstants.VIDEO_URL).get(0);
                                                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type com.inmobi.ads.modelsv2.NativeVideoAsset");
                                                C3426j8 c3426j8 = (C3426j8) obj;
                                                if (contextT != null) {
                                                    ArrayList verificationScriptResources = new ArrayList();
                                                    for (C3328c8 c3328c8 : c3426j8.s) {
                                                        if (Intrinsics.areEqual("OMID_VIEWABILITY", c3328c8.b) && (c3328c8 instanceof C3385g9)) {
                                                            Map map = (Map) c3504oc.a("macros", Map.class);
                                                            String strA3 = C3533r0.a(((C3385g9) c3328c8).g, map);
                                                            String str11 = ((C3385g9) c3328c8).h;
                                                            String strA4 = C3533r0.a(c3328c8.d, map);
                                                            if (AbstractC3420j2.a(strA3) && AbstractC3420j2.a(str11)) {
                                                                verificationScriptResourceCreateVerificationScriptResourceWithoutParameters2 = VerificationScriptResource.createVerificationScriptResourceWithParameters(str11, new URL(strA4), strA3);
                                                                Intrinsics.checkNotNull(verificationScriptResourceCreateVerificationScriptResourceWithoutParameters2);
                                                            } else {
                                                                verificationScriptResourceCreateVerificationScriptResourceWithoutParameters2 = VerificationScriptResource.createVerificationScriptResourceWithoutParameters(new URL(strA4));
                                                                Intrinsics.checkNotNull(verificationScriptResourceCreateVerificationScriptResourceWithoutParameters2);
                                                            }
                                                            verificationScriptResources.add(verificationScriptResourceCreateVerificationScriptResourceWithoutParameters2);
                                                        }
                                                    }
                                                    if (verificationScriptResources.size() != 0) {
                                                        C3455l7 c3455l7A = a(c3625x7);
                                                        if (c3455l7A != null) {
                                                            c3504oc.b.put("videoSkippable", Boolean.TRUE);
                                                            c3504oc.b.put("videoSkipOffset", Integer.valueOf(c3455l7A.n));
                                                        } else {
                                                            c3504oc.b.put("videoSkippable", Boolean.FALSE);
                                                            c3504oc.b.put("videoSkipOffset", 0);
                                                        }
                                                        HashMap map2 = c3504oc.b;
                                                        Object obj2 = c3426j8.t.get("shouldAutoPlay");
                                                        Intrinsics.checkNotNull(obj2, "null cannot be cast to non-null type kotlin.Any");
                                                        map2.put("videoAutoPlay", obj2);
                                                        HashMap map3 = c3504oc.b;
                                                        String strE = this.t.e();
                                                        String str12 = (String) c3504oc.b.get("creativeType");
                                                        Intrinsics.checkNotNullParameter(verificationScriptResources, "verificationScriptResources");
                                                        C3487n9 c3487n9 = AbstractC3473m9.f3376a;
                                                        c3487n9.getClass();
                                                        Intrinsics.checkNotNullParameter(verificationScriptResources, "verificationScriptResources");
                                                        Context contextD = C3517pb.d();
                                                        if (contextD == null) {
                                                            strA2 = ";(function(omidGlobal) {\n  'use strict';var n;function aa(a){var b=0;return function(){return b<a.length?{done:!1,value:a[b++]}:{done:!0}}}function p(a){var b='undefined'!=typeof Symbol&&Symbol.iterator&&a[Symbol.iterator];return b?b.call(a):{next:aa(a)}}function q(a){if(!(a instanceof Array)){a=p(a);for(var b,c=[];!(b=a.next()).done;)c.push(b.value);a=c}return a}var ba='function'==typeof Object.create?Object.create:function(a){function b(){}b.prototype=a;return new b},ca;\nif('function'==typeof Object.setPrototypeOf)ca=Object.setPrototypeOf;else{var da;a:{var ea={S:!0},fa={};try{fa.__proto__=ea;da=fa.S;break a}catch(a){}da=!1}ca=da?function(a,b){a.__proto__=b;if(a.__proto__!==b)throw new TypeError(a+' is not extensible');return a}:null}var ha=ca;\nfunction r(a,b){a.prototype=ba(b.prototype);a.prototype.constructor=a;if(ha)ha(a,b);else for(var c in b)if('prototype'!=c)if(Object.defineProperties){var d=Object.getOwnPropertyDescriptor(b,c);d&&Object.defineProperty(a,c,d)}else a[c]=b[c]}function ia(a){a=['object'==typeof window&&window,'object'==typeof self&&self,'object'==typeof global&&global,a];for(var b=0;b<a.length;++b){var c=a[b];if(c&&c.Math==Math)return c}return globalThis}\nvar t=ia(this),v='function'==typeof Object.defineProperties?Object.defineProperty:function(a,b,c){a!=Array.prototype&&a!=Object.prototype&&(a[b]=c.value)};function x(a,b){if(b){var c=t;a=a.split('.');for(var d=0;d<a.length-1;d++){var e=a[d];e in c||(c[e]={});c=c[e]}a=a[a.length-1];d=c[a];b=b(d);b!=d&&null!=b&&v(c,a,{configurable:!0,writable:!0,value:b})}}x('globalThis',function(a){return a||t});function y(a,b){return Object.prototype.hasOwnProperty.call(a,b)}\nvar ja='function'==typeof Object.assign?Object.assign:function(a,b){for(var c=1;c<arguments.length;c++){var d=arguments[c];if(d)for(var e in d)y(d,e)&&(a[e]=d[e])}return a};x('Object.assign',function(a){return a||ja});function ka(){ka=function(){};t.Symbol||(t.Symbol=la)}function ma(a,b){this.a=a;v(this,'description',{configurable:!0,writable:!0,value:b})}ma.prototype.toString=function(){return this.a};\nvar la=function(){function a(c){if(this instanceof a)throw new TypeError('Symbol is not a constructor');return new ma('jscomp_symbol_'+(c||'')+'_'+b++,c)}var b=0;return a}();function z(){ka();var a=t.Symbol.iterator;a||(a=t.Symbol.iterator=t.Symbol('Symbol.iterator'));'function'!=typeof Array.prototype[a]&&v(Array.prototype,a,{configurable:!0,writable:!0,value:function(){return na(aa(this))}});z=function(){}}function na(a){z();a={next:a};a[t.Symbol.iterator]=function(){return this};return a}\nx('WeakMap',function(a){function b(h){this.a=(g+=Math.random()+1).toString();if(h){h=p(h);for(var k;!(k=h.next()).done;)k=k.value,this.set(k[0],k[1])}}function c(){}function d(h){var k=typeof h;return'object'===k&&null!==h||'function'===k}function e(h){if(!y(h,l)){var k=new c;v(h,l,{value:k})}}function f(h){var k=Object[h];k&&(Object[h]=function(m){if(m instanceof c)return m;e(m);return k(m)})}if(function(){if(!a||!Object.seal)return!1;try{var h=Object.seal({}),k=Object.seal({}),m=new a([[h,2],[k,\n3]]);if(2!=m.get(h)||3!=m.get(k))return!1;m.delete(h);m.set(k,4);return!m.has(h)&&4==m.get(k)}catch(u){return!1}}())return a;var l='$jscomp_hidden_'+Math.random();f('freeze');f('preventExtensions');f('seal');var g=0;b.prototype.set=function(h,k){if(!d(h))throw Error('Invalid WeakMap key');e(h);if(!y(h,l))throw Error('WeakMap key fail: '+h);h[l][this.a]=k;return this};b.prototype.get=function(h){return d(h)&&y(h,l)?h[l][this.a]:void 0};b.prototype.has=function(h){return d(h)&&y(h,l)&&y(h[l],this.a)};\nb.prototype.delete=function(h){return d(h)&&y(h,l)&&y(h[l],this.a)?delete h[l][this.a]:!1};return b});\nx('Map',function(a){function b(){var g={};return g.A=g.next=g.head=g}function c(g,h){var k=g.a;return na(function(){if(k){for(;k.head!=g.a;)k=k.A;for(;k.next!=k.head;)return k=k.next,{done:!1,value:h(k)};k=null}return{done:!0,value:void 0}})}function d(g,h){var k=h&&typeof h;'object'==k||'function'==k?f.has(h)?k=f.get(h):(k=''+ ++l,f.set(h,k)):k='p_'+h;var m=g.b[k];if(m&&y(g.b,k))for(g=0;g<m.length;g++){var u=m[g];if(h!==h&&u.key!==u.key||h===u.key)return{id:k,list:m,index:g,s:u}}return{id:k,list:m,\nindex:-1,s:void 0}}function e(g){this.b={};this.a=b();this.size=0;if(g){g=p(g);for(var h;!(h=g.next()).done;)h=h.value,this.set(h[0],h[1])}}if(function(){if(!a||'function'!=typeof a||!a.prototype.entries||'function'!=typeof Object.seal)return!1;try{var g=Object.seal({x:4}),h=new a(p([[g,'s']]));if('s'!=h.get(g)||1!=h.size||h.get({x:4})||h.set({x:4},'t')!=h||2!=h.size)return!1;var k=h.entries(),m=k.next();if(m.done||m.value[0]!=g||'s'!=m.value[1])return!1;m=k.next();return m.done||4!=m.value[0].x||\n't'!=m.value[1]||!k.next().done?!1:!0}catch(u){return!1}}())return a;z();var f=new WeakMap;e.prototype.set=function(g,h){g=0===g?0:g;var k=d(this,g);k.list||(k.list=this.b[k.id]=[]);k.s?k.s.value=h:(k.s={next:this.a,A:this.a.A,head:this.a,key:g,value:h},k.list.push(k.s),this.a.A.next=k.s,this.a.A=k.s,this.size++);return this};e.prototype.delete=function(g){g=d(this,g);return g.s&&g.list?(g.list.splice(g.index,1),g.list.length||delete this.b[g.id],g.s.A.next=g.s.next,g.s.next.A=g.s.A,g.s.head=null,\nthis.size--,!0):!1};e.prototype.clear=function(){this.b={};this.a=this.a.A=b();this.size=0};e.prototype.has=function(g){return!!d(this,g).s};e.prototype.get=function(g){return(g=d(this,g).s)&&g.value};e.prototype.entries=function(){return c(this,function(g){return[g.key,g.value]})};e.prototype.keys=function(){return c(this,function(g){return g.key})};e.prototype.values=function(){return c(this,function(g){return g.value})};e.prototype.forEach=function(g,h){for(var k=this.entries(),m;!(m=k.next()).done;)m=\nm.value,g.call(h,m[1],m[0],this)};e.prototype[Symbol.iterator]=e.prototype.entries;var l=0;return e});x('Object.values',function(a){return a?a:function(b){var c=[],d;for(d in b)y(b,d)&&c.push(b[d]);return c}});\nx('Set',function(a){function b(c){this.a=new Map;if(c){c=p(c);for(var d;!(d=c.next()).done;)this.add(d.value)}this.size=this.a.size}if(function(){if(!a||'function'!=typeof a||!a.prototype.entries||'function'!=typeof Object.seal)return!1;try{var c=Object.seal({x:4}),d=new a(p([c]));if(!d.has(c)||1!=d.size||d.add(c)!=d||1!=d.size||d.add({x:4})!=d||2!=d.size)return!1;var e=d.entries(),f=e.next();if(f.done||f.value[0]!=c||f.value[1]!=c)return!1;f=e.next();return f.done||f.value[0]==c||4!=f.value[0].x||\nf.value[1]!=f.value[0]?!1:e.next().done}catch(l){return!1}}())return a;z();b.prototype.add=function(c){c=0===c?0:c;this.a.set(c,c);this.size=this.a.size;return this};b.prototype.delete=function(c){c=this.a.delete(c);this.size=this.a.size;return c};b.prototype.clear=function(){this.a.clear();this.size=0};b.prototype.has=function(c){return this.a.has(c)};b.prototype.entries=function(){return this.a.entries()};b.prototype.values=function(){return this.a.values()};b.prototype.keys=b.prototype.values;\nb.prototype[Symbol.iterator]=b.prototype.values;b.prototype.forEach=function(c,d){var e=this;this.a.forEach(function(f){return c.call(d,f,f,e)})};return b});x('Object.is',function(a){return a?a:function(b,c){return b===c?0!==b||1/b===1/c:b!==b&&c!==c}});x('Array.prototype.includes',function(a){return a?a:function(b,c){var d=this;d instanceof String&&(d=String(d));var e=d.length;c=c||0;for(0>c&&(c=Math.max(c+e,0));c<e;c++){var f=d[c];if(f===b||Object.is(f,b))return!0}return!1}});\nx('Object.entries',function(a){return a?a:function(b){var c=[],d;for(d in b)y(b,d)&&c.push([d,b[d]]);return c}});\nvar A={qa:'loaded',xa:'start',ka:'firstQuartile',sa:'midpoint',ya:'thirdQuartile',ia:'complete',ta:'pause',va:'resume',ha:'bufferStart',ga:'bufferFinish',wa:'skipped',Aa:'volumeChange',ua:'playerStateChange',da:'adUserInteraction'},oa={na:'generic',za:'video',ra:'media'},pa={R:'native',oa:'html',P:'javascript'},qa={R:'native',P:'javascript',NONE:'none'},sa={ma:'full',ja:'domain',pa:'limited'},ta={fa:'backgrounded',la:'foregrounded'},ua={ea:'app',Ba:'web'};function B(a,b){this.x=null!=a.x?a.x:a.left;this.y=null!=a.y?a.y:a.top;this.width=a.width;this.height=a.height;this.endX=this.x+this.width;this.endY=this.y+this.height;this.adSessionId=a.adSessionId||void 0;this.isFriendlyObstructionFor=a.isFriendlyObstructionFor||[];this.b=a.friendlyObstructionClass||void 0;this.c=a.friendlyObstructionPurpose||void 0;this.f=a.friendlyObstructionReason||void 0;this.clipsToBounds=void 0!==a.clipsToBounds?!0===a.clipsToBounds:!0;this.g=void 0!==a.hasWindowFocus?!0===\na.hasWindowFocus:!0;this.notVisibleReason=a.notVisibleReason||void 0;this.childViews=a.childViews||[];this.isCreative=a.isCreative||!1;this.a=b}function va(a){var b={};return b.width=a.width,b.height=a.height,b}function C(a){var b={};return Object.assign({},va(a),(b.x=a.x,b.y=a.y,b))}function wa(a){var b=C(a),c={};return Object.assign({},b,(c.endX=a.endX,c.endY=a.endY,c))}function xa(a,b,c){a.x+=b;a.y+=c;a.endX+=b;a.endY+=c}\nB.prototype.J=function(a){if(null==a)return!1;a=C(a);var b=a.y,c=a.width,d=a.height;return this.x===a.x&&this.y===b&&this.width===c&&this.height===d};function ya(a){return a.width*a.height}function za(a){return 0===a.width||0===a.height};function Aa(a,b){var c=0;if(0<b.length){var d=Ba(a,b);a=d.ba;d=d.ca;for(var e=0;e<a.length-1;e++)for(var f=(a[e]+(a[e]+1))/2,l=a[e+1]-a[e],g=0;g<d.length-1;g++){for(var h=(d[g]+(d[g]+1))/2,k=d[g+1]-d[g],m=!1,u=0;u<b.length;u++){var w=C(b[u]);if(w.x<f&&w.x+w.width>f&&w.y<h&&w.y+w.height>h){m=!0;break}}m&&(c+=Math.round(l)*Math.round(k))}}return c}\nfunction Ba(a,b){a=C(a);for(var c=[],d=[],e=0;e<b.length;e++){var f=C(b[e]);f=Ca(a,f);Da(c,f.x);Da(c,f.endX);Da(d,f.y);Da(d,f.endY)}c=c.sort(function(l,g){return l-g});d=d.sort(function(l,g){return l-g});return{ba:c,ca:d}}function Ca(a,b){return{x:Math.max(a.x,b.x),y:Math.max(a.y,b.y),endX:Math.min(a.x+a.width,b.x+b.width),endY:Math.min(a.y+a.height,b.y+b.height)}}function Da(a,b){-1===a.indexOf(b)&&a.push(b)};function Ea(){this.b=this.a=this.v=this.l=this.g=this.j=void 0;this.m=0;this.h=[];this.o=[];this.u=0;this.i=[];this.c=[];this.f=[]}Ea.prototype.J=function(a){return null==a?!1:JSON.stringify(Fa(this))===JSON.stringify(Fa(a))};\nfunction Fa(a){var b=[],c=[],d={viewport:a.j,adView:{percentageInView:a.m,pixelsInView:a.u,reasons:a.f},declaredFriendlyObstructions:a.h.length};if(void 0!==a.a){d.adView.geometry=C(a.a);d.adView.geometry.pixels=ya(a.a);d.adView.onScreenGeometry=C(a.b);d.adView.onScreenGeometry.pixels=Math.max(0,ya(a.b)-Aa(a.b,a.c));for(var e=0;e<a.c.length;e++)b.push(C(a.c[e]));for(e=0;e<a.o.length;e++){var f=a.o[e],l=f,g={};l.b&&(g.obstructionClass=l.b);l.c&&(g.obstructionPurpose=l.c);l.f&&(g.obstructionReason=\nl.f);f=Ca(a.a,f);c.push(Object.assign({},{x:f.x,y:f.y,width:f.endX-f.x,height:f.endY-f.y},g))}d.adView.onScreenGeometry.obstructions=b;d.adView.onScreenGeometry.friendlyObstructions=c;void 0!==a.l&&void 0!==a.v&&(d.adView.containerGeometry=C(a.l),d.adView.onScreenContainerGeometry=C(a.v),d.adView.measuringElement=!0)}return d}function Ga(a,b){b=va(b);a.j={};a.j.width=b.width;a.j.height=b.height;a.g={};a.g.x=0;a.g.y=0;a.g.width=b.width;a.g.height=b.height;a.g.endX=b.width;a.g.endY=b.height}\nfunction Ha(){return{x:0,y:0,endX:0,endY:0,width:0,height:0}}function Ia(a,b){var c={};c.x=Math.max(a.x,b.x);c.y=Math.max(a.y,b.y);c.endX=Math.min(a.endX,b.endX);c.endY=Math.min(a.endY,b.endY);c.width=Math.max(0,c.endX-c.x);c.height=Math.max(0,c.endY-c.y);return c}function Ja(a,b){return.01<b.width-a.width||.01<b.height-a.height}function Ka(a){if(-1!==a.f.indexOf('backgrounded'))a.m=0,a.u=0;else{var b=ya(a.a);if(0!==b){var c=Math.max(0,ya(a.b)-Aa(a.b,a.c));a.m=Math.round(c/b*100);a.u=c}}}\nfunction La(a,b){if(za(b)||!a.b)b=!1;else{var c=wa(a.b),d=c.y,e=c.endX;a=c.endY;var f=b.endX;c=c.x;(f=f<c||.01>Math.abs(f-c))||(f=b.x,f=f>e||.01>Math.abs(f-e));(e=f)||(e=b.endY,e=e<d||.01>Math.abs(e-d));(d=e)||(b=b.y,d=b>a||.01>Math.abs(b-a));b=!d}return b}function D(a,b){for(var c=!1,d=0;d<a.f.length;d++)a.f[d]===b&&(c=!0);c||a.f.push(b)};function Ma(a,b,c,d,e){var f=new Ea;b=new B(b,!1);Ga(f,b);Na(a,b,f,d);if(!e)return f.f=['unmeasurable'],f.j=void 0,f.m=0,f.c=[],f.a&&(a=f.a,c={},a=new B((c.x=0,c.y=0,c.width=a.width,c.height=a.height,c),a.a),f.a=a),f.b=Ha(),f;if('backgrounded'===c)D(f,'backgrounded');else if(void 0!==f.a){for(a=0;a<f.h.length;a++)La(f,f.h[a])&&f.o.push(f.h[a]);for(a=0;a<f.i.length;a++){if(c=La(f,f.i[a])){a:{c=f.i[a];for(d=0;d<f.c.length;d++)if(f.c[d].J(c)){c=!0;break a}c=!1}c=!c}c&&(D(f,'obstructed'),f.c.push(f.i[a]))}Ka(f)}else D(f,\n'notFound');return f}\nfunction Na(a,b,c,d){var e=b.isCreative?!0:b.adSessionId===d;if(e){c.a=b;var f=wa(c.a);a=Ia(c.g,f);var l=c.a;'notAttached'===l.notVisibleReason||'noWindowFocus'===l.notVisibleReason||'noAdView'===l.notVisibleReason?(D(c,'notFound'),c.b=new B(Ha(),!1)):(l=c.a,'viewInvisible'===l.notVisibleReason||'viewGone'===l.notVisibleReason||'viewNotVisible'===l.notVisibleReason||'viewAlphaZero'===l.notVisibleReason||'viewHidden'===l.notVisibleReason||void 0!==c.a.notVisibleReason||za(c.a)?(D(c,'hidden'),c.b=new B(Ha(),\n!1)):(c.a.g||(D(c,'backgrounded'),D(c,'noWindowFocus')),Ja(a,f)&&D(c,'clipped'),c.b=new B(a,!1)))}else if(f=!0,b.a&&(f=-1!==b.isFriendlyObstructionFor.indexOf(d)?!1:!1===b.clipsToBounds),f){l=b.childViews;for(var g=0;g<l.length;g++)f=void 0!==c.a,Na(a,new B(l[g],f),c,d)}e||void 0===c.a||(b.a?-1!==b.isFriendlyObstructionFor.indexOf(d)?c.h.push(b):c.i.push(b):(e=wa(b),d=wa(c.b),C(c.b),!za(c.b)&&b.clipsToBounds&&(b=Ia(d,e),Ja(b,d)&&(D(c,'clipped'),c.b=new B(b,!1)))))};function Oa(a,b){this.y=this.x=0;this.width=a;this.height=b};function Pa(){return{apiVersion:'1.0',accessMode:'limited',environment:'app',omidJsInfo:{omidImplementer:'omsdk',serviceVersion:'1.3.37-iab3566'}}}function Qa(){this.adSessionId=null;this.c=Pa();this.o=null;this.m='foregrounded';this.l=this.i='none';this.j=this.g=this.f=this.h=this.a=this.b=this.B=this.u=null;this.C=!0;this.v=new Map}var G;function H(){G||(G=new Qa);return G};var I=function(){if('undefined'!==typeof omidGlobal&&omidGlobal)return omidGlobal;if('undefined'!==typeof global&&global)return global;if('undefined'!==typeof window&&window)return window;if('undefined'!==typeof globalThis&&globalThis)return globalThis;var a=Function('return this')();if(a)return a;throw Error('Could not determine global object context.');}();function Ra(a,b){this.a=a;this.b=b}t.Object.defineProperties(Ra.prototype,{event:{configurable:!0,enumerable:!0,get:function(){return this.a}},origin:{configurable:!0,enumerable:!0,get:function(){return this.b}}});function J(a){for(var b=[],c=0;c<arguments.length;++c)b[c]=arguments[c];Sa(function(){throw new (Function.prototype.bind.apply(Error,[null,'Could not complete the test successfully - '].concat(q(b))));},function(){return console.error.apply(console,q(b))})}function Ta(a){for(var b=[],c=0;c<arguments.length;++c)b[c]=arguments[c];Sa(function(){},function(){return console.error.apply(console,q(b))})}\nfunction Sa(a,b){'undefined'!==typeof jasmine&&jasmine?a():'undefined'!==typeof console&&console&&console.error&&b()};function Ua(){this.f=[];this.b=[];this.c=[];this.g=[];this.i={};this.a=H()}function Va(a){a.f=[];a.b=[];a.c=[];a.g=[];a.i={};G.adSessionId=null;G.c=Pa();G.o=null;G.G=void 0;G.K=void 0;G.H=null;G.I=null;G.D=null;G.m='foregrounded';G.i='none';G.l='none';G.u=null;G.B=null;G.b=null;G.a=null;G.h=null;G.f=null;G.g=null;G.j=null;G.C=!0;G.v=new Map}\nfunction Wa(a,b){void 0!==a.a&&a.a.adSessionId&&!1!==Xa(a,b)&&a.c.filter(function(c){return c.type===b.event.type}).forEach(function(c){return a.h(c.F,b.event)})}function Ya(a,b){a.f.push(b);Wa(a,b)}function Za(a,b,c){void 0!==a.a&&a.a.adSessionId&&a.f.filter(function(d){return d.event.type===b&&Xa(a,d)}).map(function(d){return d.event}).forEach(c)}\nfunction Xa(a,b){var c=b.event.type,d=-1!==Object.values(A).indexOf(c)&&'volumeChange'!==c;return'impression'===c||'loaded'===c&&a.a.a?b.origin===H().l:d?b.origin===H().i:!0}function $a(a,b,c){'media'===b||'video'===b?ab(a,c):(a.c.push({type:b,F:c}),Za(a,b,c))}function ab(a,b){Object.keys(A).forEach(function(c){c=A[c];a.c.push({type:c,F:b});Za(a,c,b)})}function bb(a,b,c,d){var e={O:c,L:d,F:b};a.g.push(e);a.b.forEach(function(f){var l=cb(f);'sessionStart'===f.event.type&&db(a,l,e);a.h(b,l)})}\nfunction eb(a,b,c){var d=K(a,'sessionError','native',{errorType:b,message:c});a.b.push(d);a.g.forEach(function(e){a.h(e.F,d.event)})}function fb(a,b){a.i=Object.assign(a.i,b);b=a.a.c;if(void 0!==b){b=Object.assign({},gb(a,hb(a,{context:b}),!0),{supportsLoadedEvent:!!a.a.a||'video'==a.a.b});Object.assign(b,{pageUrl:null,contentUrl:a.a.o});var c=K(a,'sessionStart','native',b);a.b.push(c);a.g.forEach(function(d){var e=d.F,f=cb(c);db(a,f,d);a.h(e,f)},a);ib(a)}}\nfunction db(a,b,c){c.O&&(b.data.verificationParameters=a.i[c.O]);c.L&&(c=a.a.v.get(c.L))&&(b.data.verificationParameters=c.verificationParameters,b.data.context.accessMode=c.accessMode,'full'===c.accessMode&&(a.a.g&&(b.data.context.videoElement=a.a.g),a.a.f&&(b.data.context.slotElement=a.a.f)))}function jb(a){var b=a.g,c=K(a,'sessionFinish','native');a.b.push(c);var d=a.a.c;d&&'native'==d.adSessionType||Va(a);b.forEach(function(e){return a.h(e.F,c.event)})}\nUa.prototype.h=function(a,b){for(var c=[],d=1;d<arguments.length;++d)c[d-1]=arguments[d];try{a.apply(null,q(c))}catch(e){Ta(e)}};function kb(a,b){var c=(c=H().D)?Fa(c):void 0;c=gb(a,hb(a,c));Ya(a,K(a,'impression',b,c))}function lb(a,b,c){if(a.a.a||'display'!=a.a.b)b=K(a,'loaded',b,gb(a,hb(a,void 0===c?null:c))),Ya(a,b)}\nfunction mb(a,b,c,d){'start'!==b&&'volumeChange'!==b||null!=(d&&d.deviceVolume)||(d.deviceVolume=a.a.u);if(d&&('start'===b||'volumeChange'===b)){var e=d.videoPlayerVolume,f=d.mediaPlayerVolume;null!=e?(Object.assign(d,{mediaPlayerVolume:e}),a.a.B=e):null!=f&&(Object.assign(d,{videoPlayerVolume:f}),a.a.B=f)}Ya(a,K(a,b,c,d))}\nfunction ib(a){var b=a.f.filter(function(f){return Object.values(A).includes(f.event.type)&&'video'==a.a.b&&f.origin===a.a.i||'loaded'==f.event.type&&'display'==a.a.b&&f.origin===a.a.l?!0:!1}).map(function(f){return f.event}),c=a.a.adSessionId||'',d={};b=p(b);for(var e=b.next();!e.done;d={w:d.w},e=b.next()){d.w=e.value;d.w.adSessionId||(d.w.adSessionId=c);if('loaded'==d.w.type){if(!a.a.a&&'display'==a.a.b)continue;d.w.data=gb(a,hb(a,d.w.data))}a.c.filter(function(f){return function(l){return l.type===\nf.w.type}}(d)).forEach(function(f){return function(l){return l.F(f.w)}}(d))}}function nb(a,b,c){a:{c=new Set(c);a=p(a.f.concat(a.b));for(var d=a.next();!d.done;d=a.next())if(d=d.value,c.has(d.event.type)&&d.origin!=b){b=!0;break a}b=!1}return b?(J('Event owner cannot be registered after its events have already been published.'),!1):!0}function ob(a,b){nb(a,b,Object.values(A))&&L(a,b)&&(a.a.i=b)}function pb(a,b){nb(a,b,['impression'])&&qb(a,b)&&(a.a.l=b)}\nfunction qb(a,b){var c=a.a.l;return'none'!=c&&c!=b?(J('Impression event is owned by '+(a.a.l+', not ')+(b+'.')),!1):!0}function L(a,b){var c=a.a.i;return'none'!=c&&c!=b?(J('Media events are owned by '+(a.a.i+', not '+b+'.')),!1):!0}function gb(a,b,c){c=void 0===c?!1:c;b=Object.assign({},b);a.a.b&&Object.assign(b,{mediaType:a.a.b});a.a.a&&(c||'definedByJavaScript'!==a.a.a)&&Object.assign(b,{creativeType:a.a.a});return b}function hb(a,b){return a.a.h?Object.assign({},b,{impressionType:a.a.h}):b}\nfunction K(a,b,c,d){return new Ra({adSessionId:a.a.adSessionId||'',timestamp:(new Date).getTime(),type:b,data:d},c)}function cb(a){a=a.event;return{adSessionId:a.adSessionId,timestamp:a.timestamp,type:a.type,data:a.data}};function rb(a,b,c){'container'===b&&void 0!==a.a.G&&void 0!==a.a&&null!=a.a.adSessionId&&(a.a.H=Ma(a.c,a.a.G,a.a.m,a.a.adSessionId,!0));b=a.a;var d=b.H,e=b.I;if(d)if(e){b=new Ea;var f=d.j,l=d.a,g=d.b,h=e.a,k=e.b;f&&l&&g&&h&&k&&(Ga(b,f),b.l=new B(l,!1),b.v=new B(g,!1),b.i=Object.assign([],d.i),b.c=Object.assign([],d.c),b.h=Object.assign([],d.h),b.o=Object.assign([],d.o),b.f=Object.assign([],e.f,d.f),d=b.l.x,e=b.l.y,h=new B(h,!1),k=new B(k,!1),xa(h,d,e),xa(k,d,e),b.a=h,b.b=Ia(k,g),Ka(b))}else b=d;else b=\nnull;g=a.a.D;if(b&&!b.J(g)||c)g=Fa(b),c&&(g.adView.reasons=g.adView.reasons||[c]),c=a.b,'audio'!=c.a.a&&Ya(c,K(c,'geometryChange','native',g)),a.a.D=b};function M(a){return'object'===typeof a}function sb(a){return'number'===typeof a&&!isNaN(a)&&0<=a}function N(a){return'string'===typeof a}function O(a,b){return N(a)&&-1!==Object.values(b).indexOf(a)}function tb(a){return!(!a||!a.tagName||'iframe'!==a.tagName.toLowerCase())};function P(a,b,c){this.f=a;this.K=b;this.G=c;this.c=H();this.b=null;this.a=this.g=this.u=void 0;this.I=!0;this.B=void 0;Q(this)}function Q(a){if(!a.b){var b;a:{if((b=a.f.document)&&b.getElementsByClassName&&(b=b.getElementsByClassName('omid-element'))){if(1==b.length){b=b[0];break a}1<b.length&&a.I&&(eb(a.G,'generic',\"More than one element with 'omid-element' class name.\"),a.I=!1)}b=null}if(b&&b.tagName&&'video'===b.tagName.toLowerCase())a.c.g=b;else if(b&&b.tagName)a.c.f=b;else return;ub(a)}}\nfunction ub(a){a.c.g?(a.b=a.c.g,a.i()):a.c.f&&(a.b=a.c.f,tb(a.b)?a.c.j&&a.i():a.i())}function vb(a){a.a&&(tb(a.b)?a.c.j&&(a.D(),wb(a)):(a.D(),wb(a)))}P.prototype.m=function(){this.B&&(this.f.document.removeEventListener('visibilitychange',this.B),this.B=void 0)};P.prototype.i=function(){};function wb(a){a.u&&(a.c.I=a.u,rb(a.K,'creative'))}function xb(a){if(a.a&&a.c.j){var b=new B(a.c.j,!1);xa(b,a.a.x,a.a.y);b.clipsToBounds=!0;return b}};function yb(a,b,c){return zb(a,'setInterval')(b,c)}function Ab(a,b){zb(a,'clearInterval')(b)}function Bb(a,b){zb(a,'clearTimeout')(b)}function zb(a,b){return a.a&&a.a[b]?a.a[b]:Cb(a,b)}\nfunction Db(a,b,c,d){if(a.a.document&&a.a.document.body){var e=a.a.document.createElement('img');e.width=1;e.height=1;e.style.display='none';e.src=b;c&&e.addEventListener('load',function(){return c()});d&&e.addEventListener('error',function(){return d()});a.a.document.body.appendChild(e)}else Cb(a,'sendUrl')(b,c,d)}function Cb(a,b){if(a.a&&a.a.omidNative&&a.a.omidNative[b])return a.a.omidNative[b].bind(a.a.omidNative);throw Error('Native interface method \"'+b+'\" not found.');};function R(a,b,c,d,e){P.call(this,a,c,e);this.l=b;this.h=void 0;this.j=d}r(R,P);R.prototype.m=function(){void 0!==this.h&&(Ab(this.j,this.h),this.h=void 0);P.prototype.m.call(this)};R.prototype.i=function(){var a=this;P.prototype.i.call(this);null==this.b?this.h=void 0:void 0===this.h&&(this.h=yb(this.j,function(){return Eb(a)},200),Eb(this))};\nR.prototype.D=function(){if(this.g){var a=xb(this);if(a){this.a.isCreative=!1;a.isCreative=!0;for(var b=!1,c=0;c<this.a.childViews.length;c++)if(this.a.childViews[c].isCreative){this.a.childViews[c]=a;b=!0;break}b||this.a.childViews.push(a)}else this.a.isCreative=!0;this.u=Ma(this.l,this.g,this.c.m,this.c.adSessionId,this.C())}};R.prototype.C=function(){return!0};\nfunction Eb(a){if(void 0!==a.h){b:{try{var b=a.f.top;var c=0<=b.innerHeight&&0<=b.innerWidth;break b}catch(d){}c=!1}c?(c=a.f.top,c=new B(new Oa(c.innerWidth,c.innerHeight),!1)):c=new B(new Oa(0,0),!1);b=a.b.getBoundingClientRect();if(null==b.x||isNaN(b.x))b.x=b.left;if(null==b.y||isNaN(b.y))b.y=b.top;b=new B(b,!1);c.J(a.g)&&b.J(a.a)||(a.a=b,a.a.clipsToBounds=!0,a.g=c,a.g.childViews.push(a.a),vb(a))}};function S(a,b,c,d){P.call(this,a,c,d);this.o=this.j=this.l=this.h=void 0;this.H=!1;this.v=void 0}r(S,P);S.prototype.m=function(){this.h&&this.h.disconnect();Fb(this);P.prototype.m.call(this)};S.prototype.i=function(){P.prototype.i.call(this);this.b&&(this.h||(this.h=Gb(this)),Hb(this),Ib(this.b)&&Jb(this))};\nS.prototype.D=function(){if(this.a&&this.v){var a=xb(this);if(a){var b=a;var c=this.v;var d=Math.max(a.x,c.x);var e=Math.max(a.y,c.y),f=Math.min(a.endX,c.endX);a=Math.min(a.endY,c.endY);f<=d||a<=e?d=null:(c={},d=new B((c.x=d,c.y=e,c.width=Math.abs(f-d),c.height=Math.abs(a-e),c),!1));d||(d=new B({x:0,y:0,width:0,height:0},!1))}else b=this.a,d=this.v;e=new Ea;this.g&&Ga(e,this.g);e.a=b;e.b=d;Ka(e);this.H?za(e.a)?D(e,'hidden'):100===e.m||D(e,'clipped'):D(e,'viewport');this.u=e}};S.prototype.C=function(){return!0};\nfunction Fb(a){a.l&&(a.l.disconnect(),a.l=void 0);a.j&&(a.j.disconnect(),a.j=void 0);a.o&&((0,a.f.removeEventListener)('resize',a.o),a.o=void 0)}function Hb(a){a.h&&a.b&&(a.h.unobserve(a.b),a.h.observe(a.b))}function Ib(a){a=a.getBoundingClientRect();return 0==a.width||0==a.height}\nfunction Gb(a){return new a.f.IntersectionObserver(function(b){try{if(b.length){for(var c,d=b[0],e=1;e<b.length;e++)b[e].time>d.time&&(d=b[e]);c=d;a.g=Kb(c.rootBounds);a.a=Kb(c.boundingClientRect);a.v=Kb(c.intersectionRect);a.H=!!c.isIntersecting;vb(a)}}catch(f){a.m(),eb(a.G,'generic','Problem handling IntersectionObserver callback: '+f.message)}},{root:null,rootMargin:'0px',threshold:[0,.1,.2,.3,.4,.5,.6,.7,.8,.9,1]})}\nfunction Jb(a){a.f.ResizeObserver?a.l||(a.l=Lb(a,function(){return Mb(a)}),a.l.observe(a.b)):(a.o||(a.o=function(){return Mb(a)},(0,a.f.addEventListener)('resize',a.o)),a.j||(a.j=new MutationObserver(function(){return Mb(a)}),a.j.observe(a.b,{childList:!1,attributes:!0,subtree:!1})))}function Mb(a){a.b&&!Ib(a.b)&&(Hb(a),Fb(a))}function Lb(a,b){return new a.f.ResizeObserver(b)}function Kb(a){if(a&&null!==a.x&&null!==a.y&&null!==a.width&&null!==a.height)return new B(a,!1)};function Nb(a){return a&&M(a)?Object.entries(a).reduce(function(b,c){var d=p(c);c=d.next().value;d=d.next().value;return b&&N(c)&&null!=d&&M(d)&&N(d.resourceUrl)},!0):!1};function T(a,b,c,d){this.b=a;this.method=b;this.version=c;this.a=d}function Pb(a){return!!a&&void 0!==a.omid_message_guid&&void 0!==a.omid_message_method&&void 0!==a.omid_message_version&&'string'===typeof a.omid_message_guid&&'string'===typeof a.omid_message_method&&'string'===typeof a.omid_message_version&&(void 0===a.omid_message_args||void 0!==a.omid_message_args)}function Qb(a){return new T(a.omid_message_guid,a.omid_message_method,a.omid_message_version,a.omid_message_args)}\nfunction Rb(a){var b={};b=(b.omid_message_guid=a.b,b.omid_message_method=a.method,b.omid_message_version=a.version,b);void 0!==a.a&&(b.omid_message_args=a.a);return b};function Sb(a){this.c=a};function U(a){this.c=a;this.handleExportedMessage=U.prototype.f.bind(this)}r(U,Sb);U.prototype.b=function(a,b){b=void 0===b?this.c:b;if(!b)throw Error('Message destination must be defined at construction time or when sending the message.');b.handleExportedMessage(Rb(a),this)};U.prototype.f=function(a,b){Pb(a)&&this.a&&this.a(Qb(a),b)};function Tb(a){return Ub(a,'SessionService.')}function Ub(a,b){return(a=a.match(new RegExp('^'+b+'(.*)')))&&a[1]};function Vb(a,b){this.c=b=void 0===b?I:b;var c=this;a.addEventListener('message',function(d){if('object'===typeof d.data){var e=d.data;Pb(e)&&d.source&&c.a&&c.a(Qb(e),d.source)}})}r(Vb,Sb);Vb.prototype.b=function(a,b){b=void 0===b?this.c:b;if(!b)throw Error('Message destination must be defined at construction time or when sending the message.');b.postMessage(Rb(a),'*')};function Wb(){return'xxxxxxxx-xxxx-4xxx-yxxx-xxxxxxxxxxxx'.replace(/[xy]/g,function(a){var b=16*Math.random()|0;return'y'===a?(b&3|8).toString(16):b.toString(16)})};function Xb(a){if(!a.a||!a.a.document)throw Error('OMID Service Script is not running within a window.');var b=a.b;a.b=[];b.forEach(function(c){try{var d=a.c.C?'limited':'full',e=O(c.accessMode,sa)?c.accessMode:null;var f=e?'full'==e&&'limited'==d?d:'domain'==e?'limited':e:d;c.accessMode=f;a:{var l=c.resourceUrl,g=a.a.location.origin;try{var h=new URL(l,g);break a}catch(V){}try{h=new URL(l);break a}catch(V){}h=null}if(d=h){var k=Wb(),m=a.a.document,u=m.createElement('iframe');u.id='omid-verification-script-frame-'+\nk;u.style.display='none';['full','limited'].includes(f)?u.srcdoc=\"<html><head>\\n<script type=\\\"text/javascript\\\">window['omidVerificationProperties'] = {\\n'serviceWindow': window.parent,\\n'injectionSource': 'app',\\n'injectionId': '\"+(k+'\\',\\n};\\x3c/script>\\n<script type=\"text/javascript\" src=\"')+d.href+'\">\\x3c/script>\\n</head><body></body></html>':'domain'==f&&(u.src=Yb(a,k,d).href);['domain','limited'].includes(f)&&(u.sandbox='allow-scripts');m.body.appendChild(u);var w=c.vendorKey,E=c.verificationParameters;\nw=void 0===w?'':w;E=void 0===E?'':E;w&&'string'===typeof w&&''!==w&&E&&'string'===typeof E&&''!==E&&(a.f.i[w]=E);a.c.v.set(k,c)}}catch(V){Ta('OMID verification script '+c.resourceUrl+' failed to load: '+V)}})}\nfunction Yb(a,b,c){var d='/.well-known/omid/omloader-v1.html#';(new Map([['verificationScriptUrl',c.href],['injectionId',b]])).forEach(function(e,f){d+=encodeURIComponent(f)+'='+encodeURIComponent(e)+'&'});b=null;try{b=new URL(d,a.a.parent.location.origin)}catch(e){throw Error('OMID Service Script cannot access the parent window.');}return b};function Zb(){var a=$b,b=ac,c=this;this.c=X;this.b=a;this.a=H();this.g=b;this.f=!1;this.registerSessionObserver(function(d){return bc(c,d)})}n=Zb.prototype;n.registerSessionObserver=function(a){bb(this.c,a)};n.setSlotElement=function(a){a&&a.tagName?(this.a.f=a,this.b&&ub(this.b)):J('setSlotElement called with a non-HTMLElement.  It will be ignored.')};n.setElementBounds=function(a){this.a.j=a;this.b&&ub(this.b);this.b&&vb(this.b)};n.error=function(a,b){eb(this.c,a,b)};\nn.registerAdEvents=function(){pb(this.c,'javascript')};n.registerMediaEvents=function(){ob(this.c,'javascript')};function Y(a,b,c){'impression'==b?qb(a.c,'javascript')&&(kb(a.c,'javascript'),a.b&&Q(a.b)):('loaded'==b?(c=void 0===c?null:c,L(a.c,'javascript')&&lb(a.c,'javascript',c)):L(a.c,'javascript')&&mb(a.c,b,'javascript',c),['loaded','start'].includes(b)&&a.b&&Q(a.b))}n.injectVerificationScriptResources=function(a){var b=this.g;b.b.push.apply(b.b,q(a));if(this.f)try{Xb(this.g)}catch(c){J(c.message)}};\nn.setCreativeType=function(a,b){b=void 0===b?null:b;if(!this.a.b||this.a.a)this.a.a=a,'video'==a||'audio'==a?this.a.b='video':'htmlDisplay'==a||'nativeDisplay'==a?this.a.b='display':'definedByJavaScript'==a&&b&&(this.a.b='none'==b?'display':'video')};n.setImpressionType=function(a){if(!this.a.b||this.a.a)this.a.h=a};\nfunction bc(a,b){if('sessionStart'===b.type){a.f=!0;try{Xb(a.g)}catch(c){J(c.message)}}'sessionFinish'===b.type&&(a.f=!1,(b=H().c)&&'native'==b.adSessionType||a.registerSessionObserver(function(c){return bc(a,c)}))}n.setClientInfo=function(a,b,c){var d=this.a.c||{};d.omidJsInfo=Object.assign({},d.omidJsInfo,{sessionClientVersion:a,partnerName:b,partnerVersion:c});this.a.c=d;return this.a.c.omidJsInfo.serviceVersion};function cc(a){return/\\d+\\.\\d+\\.\\d+(-.*)?/.test(a)}function dc(a){a=a.split('-')[0].split('.');for(var b=['1','0','3'],c=0;3>c;c++){var d=parseInt(a[c],10),e=parseInt(b[c],10);if(d>e)break;else if(d<e)return!1}return!0};function ec(a,b){return cc(a)&&dc(a)?b?b:[]:b&&'string'===typeof b?JSON.parse(b):[]};var fc=new function(){};function gc(){var a=hc;var b=void 0===b?omidGlobal:b;this.a=a;this.g=b;this.b=new U;this.g.omid=this.g.omid||{};this.g.omid.v1_SessionServiceCommunication=this.b;this.f=b&&b.addEventListener&&b.postMessage?new Vb(b):null;this.c=null;this.b.a=this.h.bind(this);this.f&&(this.f.a=this.i.bind(this))}gc.prototype.h=function(a,b){null!=Tb(a.method)&&ic(this,fc)&&jc(this,a,b,this.b)};gc.prototype.i=function(a,b){null!=Tb(a.method)&&ic(this,b)&&jc(this,a,b,this.f)};\nfunction ic(a,b){a.c||(a.c=b);return a.c!=b?(J('The source of session client messages cannot be changed from the source of the first message.'),!1):!0}\nfunction jc(a,b,c,d){function e(h){for(var k=[],m=0;m<arguments.length;++m)k[m]=arguments[m];k=new T(f,'response',g,cc(g)&&dc(g)?k:JSON.stringify(k));d.b(k,c)}var f=b.b,l=b.method,g=b.version;b=ec(g,b.a);try{kc(a,l,e,b)}catch(h){d.b(new T(f,'error',g,'\\n        name: '+h.name+'\\n        message: '+h.message+'\\n        filename: '+h.filename+'\\n        lineNumber: '+h.lineNumber+'\\n        columnNumber: '+h.columnNumber+'\\n        stack: '+h.stack+'\\n        toString(): '+h.toString()),c)}}\nfunction kc(a,b,c,d){if(null!=Tb(b))switch(Tb(b)){case 'registerAdEvents':a.a.registerAdEvents();break;case 'registerMediaEvents':a.a.registerMediaEvents();break;case 'registerSessionObserver':a.a.registerSessionObserver(c);break;case 'setSlotElement':c=p(d).next().value;a.a.setSlotElement(c);break;case 'setVideoElement':c=p(d).next().value;a=a.a;c&&c.tagName&&'video'===c.tagName.toLowerCase()?(a.a.g=c,a.b&&ub(a.b)):J('setVideoElement called with a non-HTMLVideoElement. It will be ignored.');break;\ncase 'setElementBounds':c=p(d).next().value;a.a.setElementBounds(c);break;case 'startSession':J('Session start from JS is not supported in mobile app.');break;case 'finishSession':J('Session finish from JS is not supported in mobile app.');break;case 'impressionOccurred':Y(a.a,'impression');break;case 'loaded':(c=p(d).next().value)?(b={skippable:c.isSkippable,autoPlay:c.isAutoPlay,position:c.position},c.isSkippable&&(b.skipOffset=c.skipOffset),Y(a.a,'loaded',b)):Y(a.a,'loaded');break;case 'start':b=\np(d);c=b.next().value;b=b.next().value;Y(a.a,'start',{duration:c,mediaPlayerVolume:b});break;case 'firstQuartile':Y(a.a,'firstQuartile');break;case 'midpoint':Y(a.a,'midpoint');break;case 'thirdQuartile':Y(a.a,'thirdQuartile');break;case 'complete':Y(a.a,'complete');break;case 'pause':Y(a.a,'pause');break;case 'resume':Y(a.a,'resume');break;case 'bufferStart':Y(a.a,'bufferStart');break;case 'bufferFinish':Y(a.a,'bufferFinish');break;case 'skipped':Y(a.a,'skipped');break;case 'volumeChange':c={mediaPlayerVolume:p(d).next().value};\nY(a.a,'volumeChange',c);break;case 'playerStateChange':c={state:p(d).next().value};Y(a.a,'playerStateChange',c);break;case 'adUserInteraction':c={interactionType:p(d).next().value};Y(a.a,'adUserInteraction',c);break;case 'setClientInfo':var e=p(d);b=e.next().value;d=e.next().value;e=e.next().value;a=a.a.setClientInfo(b,d,e);c(a);break;case 'injectVerificationScriptResources':c=p(d).next().value;a.a.injectVerificationScriptResources(c);break;case 'setCreativeType':c=p(d).next().value;a.a.setCreativeType(c);\nbreak;case 'setImpressionType':c=p(d).next().value;a.a.setImpressionType(c);break;case 'setContentUrl':c=p(d).next().value;a.a.a.o=c;break;case 'sessionError':b=p(d),c=b.next().value,b=b.next().value,a.a.error(c,b)}};function Z(){var a=X,b=lc,c=mc,d=$b;this.f=hc;this.a=a;this.c=b;this.h=c;this.g=d;this.b=H()}n=Z.prototype;\nn.T=function(a){if(!(!(a&&M(a)&&O(a.impressionOwner,qa))||'videoEventsOwner'in a&&null!=a.videoEventsOwner&&!O(a.videoEventsOwner,qa)||'mediaEventsOwner'in a&&null!=a.mediaEventsOwner&&!O(a.mediaEventsOwner,qa))){if(a.creativeType&&a.impressionType){var b=a.mediaEventsOwner;null==this.b.a&&this.f.setCreativeType(a.creativeType,b);null==this.b.h&&(this.b.h=a.impressionType);ob(this.a,b)}else b=a.videoEventsOwner,this.b.b=null==b||'none'===b?'display':'video',this.b.a=null,this.b.h=null,ob(this.a,b);\npb(this.a,a.impressionOwner);a&&null!=a.isolateVerificationScripts&&'boolean'===typeof a.isolateVerificationScripts&&(this.b.C=a.isolateVerificationScripts)}};\nn.W=function(a,b,c,d){var e;if(M(b)){if(e=O(b.environment,ua)&&O(b.adSessionType,pa))e=b.omidNativeInfo,e=M(e)?N(e.partnerName)&&N(e.partnerVersion):!1;e&&(e=b.app,e=M(e)?N(e.libraryVersion)&&N(e.appId):!1)}else e=!1;e&&(Nb(d)&&(this.b.v=new Map(Object.entries(d))),d=this.f,c=void 0===c?null:c,null==a&&(a=Wb()),b.canMeasureVisibility=d.b.C(),d.a.adSessionId=a,a=d.a,e=b,void 0!==e.contentUrl&&(a.o=e.contentUrl,e.contentUrl=void 0),e=a.c||{},b.omidJsInfo=Object.assign({},e.omidJsInfo||{},b.omidJsInfo||\n{}),e=b=Object.assign({},e,b),a.C||(null!=a.g?(e.videoElement=a.g,e.accessMode='full'):null!=a.f&&(e.slotElement=a.f,e.accessMode='full')),a.c=b,fb(d.c,c),d.b&&Q(d.b))};n.U=function(){var a=this.f;jb(a.c);a.b.m()};n.$=function(a){M(a)&&sb(a.x)&&sb(a.y)&&sb(a.width)&&sb(a.height)&&(this.b.G=a,rb(this.c,'container'))};n.aa=function(a){O(a,ta)&&(this.b.m=a,'backgrounded'===a?rb(this.c,'container','backgrounded'):rb(this.c,'container'))};n.X=function(a){'impression'===a&&(this.M(),this.g&&Q(this.g))};\nn.M=function(){qb(this.a,'native')&&kb(this.a,'native')};n.V=function(a){a=void 0===a?null:a;L(this.a,'native')&&lb(this.a,'native',a)};n.error=function(a,b){O(a,oa)&&eb(this.a,a,b)};n.Y=function(a,b){this.N(a,b)};n.N=function(a,b){L(this.a,'native')&&O(a,A)&&(void 0===b||M(b))&&('loaded'==a?lb(this.a,'native',b):mb(this.a,a,'native',b))};\nn.Z=function(a){if('none'!==this.a.a.i&&'number'===typeof a&&!isNaN(a)){this.b.u=a;a=this.h;var b=a.a.B;null!=b&&mb(a.b,'volumeChange','native',{mediaPlayerVolume:b,deviceVolume:a.a.u})}};Z.prototype.startSession=Z.prototype.W;Z.prototype.error=Z.prototype.error;Z.prototype.finishSession=Z.prototype.U;Z.prototype.publishAdEvent=Z.prototype.X;Z.prototype.publishImpressionEvent=Z.prototype.M;Z.prototype.publishVideoEvent=Z.prototype.Y;Z.prototype.publishMediaEvent=Z.prototype.N;\nZ.prototype.publishLoadedEvent=Z.prototype.V;Z.prototype.setNativeViewHierarchy=Z.prototype.$;Z.prototype.setState=Z.prototype.aa;Z.prototype.setDeviceVolume=Z.prototype.Z;Z.prototype.init=Z.prototype.T;function nc(){var a=X,b=oc;var c=void 0===c?I:c;this.g=a;this.a=b;this.h={};this.f={};this.c=new U;c.omid=c.omid||{};c.omid.v1_VerificationServiceCommunication=this.c;this.b=null;c&&c.addEventListener&&c.postMessage&&(this.b=new Vb(c));this.c.a=this.i.bind(this);this.b&&(this.b.a=this.j.bind(this))}function pc(a,b,c,d){Db(a.a,b,c,d)}function qc(a,b,c,d){Cb(a.a,'downloadJavaScriptResource')(b,c,d)}nc.prototype.j=function(a,b){this.b&&rc(this,a,b,this.b)};nc.prototype.i=function(a,b){rc(this,a,b,this.c)};\nfunction rc(a,b,c,d){function e(F){for(var W=[],ra=0;ra<arguments.length;++ra)W[ra]=arguments[ra];W=new T(f,'response',g,cc(g)&&dc(g)?W:JSON.stringify(W));d.b(W,c)}var f=b.b,l=b.method,g=b.version;b=ec(g,b.a);if(null!=Ub(l,'VerificationService.')){l=Ub(l,'VerificationService.');try{switch(l){case 'addEventListener':var h=p(b).next().value;$a(a.g,h,e);break;case 'addSessionListener':var k=p(b),m=k.next().value,u=k.next().value;bb(a.g,e,m,u);break;case 'sendUrl':var w=p(b).next().value;pc(a,w,function(){return e(!0)},\nfunction(){return e(!1)});break;case 'setTimeout':var E=p(b),V=E.next().value,wc=E.next().value;a.h[V]=zb(a.a,'setTimeout')(e,wc);break;case 'clearTimeout':var xc=p(b).next().value;Bb(a.a,a.h[xc]);break;case 'setInterval':var Ob=p(b),yc=Ob.next().value,zc=Ob.next().value;a.f[yc]=yb(a.a,e,zc);break;case 'clearInterval':var Ac=p(b).next().value;Ab(a.a,a.f[Ac]);break;case 'injectJavaScriptResource':var Bc=p(b).next().value;qc(a,Bc,function(F){return e(!0,F)},function(){return e(!1)});break;case 'getVersion':p(b).next();\nvar Cc=H().c.omidJsInfo;e(Cc.serviceVersion)}}catch(F){d.b(new T(f,'error',g,'\\n              name: '+F.name+'\\n              message: '+F.message+'\\n              filename: '+F.filename+'\\n              lineNumber: '+F.lineNumber+'\\n              columnNumber: '+F.columnNumber+'\\n              stack: '+F.stack+'\\n              toString(): '+F.toString()+'\\n          '),c)}}};function sc(){var a=I.document.createElement('iframe');a.id='omid_v1_present';a.name='omid_v1_present';a.style.display='none';I.document.body.appendChild(a)}function tc(){var a=new MutationObserver(function(b){b.forEach(function(c){'BODY'===c.addedNodes[0].nodeName&&(sc(),a.disconnect())})});a.observe(I.document.documentElement,{childList:!0})};var X=new Ua,oc=new function(){var a;this.a=a=void 0===a?omidGlobal:a};new nc;var uc=new function(){},vc=new function(){},lc=new function(){this.b=X;this.c=vc;this.a=H()},Dc;I?Dc=I.IntersectionObserver&&(I.MutationObserver||I.ResizeObserver)?new S(I,uc,lc,X):new R(I,vc,lc,oc,X):Dc=null;var $b=Dc,ac=new function(){var a=X;var b=void 0===b?I:b;this.f=a;this.a=b;this.c=H();this.b=[]},hc=new Zb,mc=new function(){var a=X,b=H();this.b=a;this.a=b};I.omidBridge=new Z;new gc;\nif(I.frames&&I.document&&!('omid_v1_present'in I.frames)){var Ec;if(Ec=null==I.document.body)Ec='MutationObserver'in I;Ec?tc():I.document.body?sc():I.document.write('<iframe style=\"display:none\" id=\"omid_v1_present\" name=\"omid_v1_present\"></iframe>')};\n}).call(this, this);";
                                                        } else {
                                                            strA2 = new A9(contextD, "omid_js_store").a("omid_js_string");
                                                            if (strA2 == null) {
                                                                strA2 = null;
                                                            }
                                                            if (strA2 == null) {
                                                                strA2 = ";(function(omidGlobal) {\n  'use strict';var n;function aa(a){var b=0;return function(){return b<a.length?{done:!1,value:a[b++]}:{done:!0}}}function p(a){var b='undefined'!=typeof Symbol&&Symbol.iterator&&a[Symbol.iterator];return b?b.call(a):{next:aa(a)}}function q(a){if(!(a instanceof Array)){a=p(a);for(var b,c=[];!(b=a.next()).done;)c.push(b.value);a=c}return a}var ba='function'==typeof Object.create?Object.create:function(a){function b(){}b.prototype=a;return new b},ca;\nif('function'==typeof Object.setPrototypeOf)ca=Object.setPrototypeOf;else{var da;a:{var ea={S:!0},fa={};try{fa.__proto__=ea;da=fa.S;break a}catch(a){}da=!1}ca=da?function(a,b){a.__proto__=b;if(a.__proto__!==b)throw new TypeError(a+' is not extensible');return a}:null}var ha=ca;\nfunction r(a,b){a.prototype=ba(b.prototype);a.prototype.constructor=a;if(ha)ha(a,b);else for(var c in b)if('prototype'!=c)if(Object.defineProperties){var d=Object.getOwnPropertyDescriptor(b,c);d&&Object.defineProperty(a,c,d)}else a[c]=b[c]}function ia(a){a=['object'==typeof window&&window,'object'==typeof self&&self,'object'==typeof global&&global,a];for(var b=0;b<a.length;++b){var c=a[b];if(c&&c.Math==Math)return c}return globalThis}\nvar t=ia(this),v='function'==typeof Object.defineProperties?Object.defineProperty:function(a,b,c){a!=Array.prototype&&a!=Object.prototype&&(a[b]=c.value)};function x(a,b){if(b){var c=t;a=a.split('.');for(var d=0;d<a.length-1;d++){var e=a[d];e in c||(c[e]={});c=c[e]}a=a[a.length-1];d=c[a];b=b(d);b!=d&&null!=b&&v(c,a,{configurable:!0,writable:!0,value:b})}}x('globalThis',function(a){return a||t});function y(a,b){return Object.prototype.hasOwnProperty.call(a,b)}\nvar ja='function'==typeof Object.assign?Object.assign:function(a,b){for(var c=1;c<arguments.length;c++){var d=arguments[c];if(d)for(var e in d)y(d,e)&&(a[e]=d[e])}return a};x('Object.assign',function(a){return a||ja});function ka(){ka=function(){};t.Symbol||(t.Symbol=la)}function ma(a,b){this.a=a;v(this,'description',{configurable:!0,writable:!0,value:b})}ma.prototype.toString=function(){return this.a};\nvar la=function(){function a(c){if(this instanceof a)throw new TypeError('Symbol is not a constructor');return new ma('jscomp_symbol_'+(c||'')+'_'+b++,c)}var b=0;return a}();function z(){ka();var a=t.Symbol.iterator;a||(a=t.Symbol.iterator=t.Symbol('Symbol.iterator'));'function'!=typeof Array.prototype[a]&&v(Array.prototype,a,{configurable:!0,writable:!0,value:function(){return na(aa(this))}});z=function(){}}function na(a){z();a={next:a};a[t.Symbol.iterator]=function(){return this};return a}\nx('WeakMap',function(a){function b(h){this.a=(g+=Math.random()+1).toString();if(h){h=p(h);for(var k;!(k=h.next()).done;)k=k.value,this.set(k[0],k[1])}}function c(){}function d(h){var k=typeof h;return'object'===k&&null!==h||'function'===k}function e(h){if(!y(h,l)){var k=new c;v(h,l,{value:k})}}function f(h){var k=Object[h];k&&(Object[h]=function(m){if(m instanceof c)return m;e(m);return k(m)})}if(function(){if(!a||!Object.seal)return!1;try{var h=Object.seal({}),k=Object.seal({}),m=new a([[h,2],[k,\n3]]);if(2!=m.get(h)||3!=m.get(k))return!1;m.delete(h);m.set(k,4);return!m.has(h)&&4==m.get(k)}catch(u){return!1}}())return a;var l='$jscomp_hidden_'+Math.random();f('freeze');f('preventExtensions');f('seal');var g=0;b.prototype.set=function(h,k){if(!d(h))throw Error('Invalid WeakMap key');e(h);if(!y(h,l))throw Error('WeakMap key fail: '+h);h[l][this.a]=k;return this};b.prototype.get=function(h){return d(h)&&y(h,l)?h[l][this.a]:void 0};b.prototype.has=function(h){return d(h)&&y(h,l)&&y(h[l],this.a)};\nb.prototype.delete=function(h){return d(h)&&y(h,l)&&y(h[l],this.a)?delete h[l][this.a]:!1};return b});\nx('Map',function(a){function b(){var g={};return g.A=g.next=g.head=g}function c(g,h){var k=g.a;return na(function(){if(k){for(;k.head!=g.a;)k=k.A;for(;k.next!=k.head;)return k=k.next,{done:!1,value:h(k)};k=null}return{done:!0,value:void 0}})}function d(g,h){var k=h&&typeof h;'object'==k||'function'==k?f.has(h)?k=f.get(h):(k=''+ ++l,f.set(h,k)):k='p_'+h;var m=g.b[k];if(m&&y(g.b,k))for(g=0;g<m.length;g++){var u=m[g];if(h!==h&&u.key!==u.key||h===u.key)return{id:k,list:m,index:g,s:u}}return{id:k,list:m,\nindex:-1,s:void 0}}function e(g){this.b={};this.a=b();this.size=0;if(g){g=p(g);for(var h;!(h=g.next()).done;)h=h.value,this.set(h[0],h[1])}}if(function(){if(!a||'function'!=typeof a||!a.prototype.entries||'function'!=typeof Object.seal)return!1;try{var g=Object.seal({x:4}),h=new a(p([[g,'s']]));if('s'!=h.get(g)||1!=h.size||h.get({x:4})||h.set({x:4},'t')!=h||2!=h.size)return!1;var k=h.entries(),m=k.next();if(m.done||m.value[0]!=g||'s'!=m.value[1])return!1;m=k.next();return m.done||4!=m.value[0].x||\n't'!=m.value[1]||!k.next().done?!1:!0}catch(u){return!1}}())return a;z();var f=new WeakMap;e.prototype.set=function(g,h){g=0===g?0:g;var k=d(this,g);k.list||(k.list=this.b[k.id]=[]);k.s?k.s.value=h:(k.s={next:this.a,A:this.a.A,head:this.a,key:g,value:h},k.list.push(k.s),this.a.A.next=k.s,this.a.A=k.s,this.size++);return this};e.prototype.delete=function(g){g=d(this,g);return g.s&&g.list?(g.list.splice(g.index,1),g.list.length||delete this.b[g.id],g.s.A.next=g.s.next,g.s.next.A=g.s.A,g.s.head=null,\nthis.size--,!0):!1};e.prototype.clear=function(){this.b={};this.a=this.a.A=b();this.size=0};e.prototype.has=function(g){return!!d(this,g).s};e.prototype.get=function(g){return(g=d(this,g).s)&&g.value};e.prototype.entries=function(){return c(this,function(g){return[g.key,g.value]})};e.prototype.keys=function(){return c(this,function(g){return g.key})};e.prototype.values=function(){return c(this,function(g){return g.value})};e.prototype.forEach=function(g,h){for(var k=this.entries(),m;!(m=k.next()).done;)m=\nm.value,g.call(h,m[1],m[0],this)};e.prototype[Symbol.iterator]=e.prototype.entries;var l=0;return e});x('Object.values',function(a){return a?a:function(b){var c=[],d;for(d in b)y(b,d)&&c.push(b[d]);return c}});\nx('Set',function(a){function b(c){this.a=new Map;if(c){c=p(c);for(var d;!(d=c.next()).done;)this.add(d.value)}this.size=this.a.size}if(function(){if(!a||'function'!=typeof a||!a.prototype.entries||'function'!=typeof Object.seal)return!1;try{var c=Object.seal({x:4}),d=new a(p([c]));if(!d.has(c)||1!=d.size||d.add(c)!=d||1!=d.size||d.add({x:4})!=d||2!=d.size)return!1;var e=d.entries(),f=e.next();if(f.done||f.value[0]!=c||f.value[1]!=c)return!1;f=e.next();return f.done||f.value[0]==c||4!=f.value[0].x||\nf.value[1]!=f.value[0]?!1:e.next().done}catch(l){return!1}}())return a;z();b.prototype.add=function(c){c=0===c?0:c;this.a.set(c,c);this.size=this.a.size;return this};b.prototype.delete=function(c){c=this.a.delete(c);this.size=this.a.size;return c};b.prototype.clear=function(){this.a.clear();this.size=0};b.prototype.has=function(c){return this.a.has(c)};b.prototype.entries=function(){return this.a.entries()};b.prototype.values=function(){return this.a.values()};b.prototype.keys=b.prototype.values;\nb.prototype[Symbol.iterator]=b.prototype.values;b.prototype.forEach=function(c,d){var e=this;this.a.forEach(function(f){return c.call(d,f,f,e)})};return b});x('Object.is',function(a){return a?a:function(b,c){return b===c?0!==b||1/b===1/c:b!==b&&c!==c}});x('Array.prototype.includes',function(a){return a?a:function(b,c){var d=this;d instanceof String&&(d=String(d));var e=d.length;c=c||0;for(0>c&&(c=Math.max(c+e,0));c<e;c++){var f=d[c];if(f===b||Object.is(f,b))return!0}return!1}});\nx('Object.entries',function(a){return a?a:function(b){var c=[],d;for(d in b)y(b,d)&&c.push([d,b[d]]);return c}});\nvar A={qa:'loaded',xa:'start',ka:'firstQuartile',sa:'midpoint',ya:'thirdQuartile',ia:'complete',ta:'pause',va:'resume',ha:'bufferStart',ga:'bufferFinish',wa:'skipped',Aa:'volumeChange',ua:'playerStateChange',da:'adUserInteraction'},oa={na:'generic',za:'video',ra:'media'},pa={R:'native',oa:'html',P:'javascript'},qa={R:'native',P:'javascript',NONE:'none'},sa={ma:'full',ja:'domain',pa:'limited'},ta={fa:'backgrounded',la:'foregrounded'},ua={ea:'app',Ba:'web'};function B(a,b){this.x=null!=a.x?a.x:a.left;this.y=null!=a.y?a.y:a.top;this.width=a.width;this.height=a.height;this.endX=this.x+this.width;this.endY=this.y+this.height;this.adSessionId=a.adSessionId||void 0;this.isFriendlyObstructionFor=a.isFriendlyObstructionFor||[];this.b=a.friendlyObstructionClass||void 0;this.c=a.friendlyObstructionPurpose||void 0;this.f=a.friendlyObstructionReason||void 0;this.clipsToBounds=void 0!==a.clipsToBounds?!0===a.clipsToBounds:!0;this.g=void 0!==a.hasWindowFocus?!0===\na.hasWindowFocus:!0;this.notVisibleReason=a.notVisibleReason||void 0;this.childViews=a.childViews||[];this.isCreative=a.isCreative||!1;this.a=b}function va(a){var b={};return b.width=a.width,b.height=a.height,b}function C(a){var b={};return Object.assign({},va(a),(b.x=a.x,b.y=a.y,b))}function wa(a){var b=C(a),c={};return Object.assign({},b,(c.endX=a.endX,c.endY=a.endY,c))}function xa(a,b,c){a.x+=b;a.y+=c;a.endX+=b;a.endY+=c}\nB.prototype.J=function(a){if(null==a)return!1;a=C(a);var b=a.y,c=a.width,d=a.height;return this.x===a.x&&this.y===b&&this.width===c&&this.height===d};function ya(a){return a.width*a.height}function za(a){return 0===a.width||0===a.height};function Aa(a,b){var c=0;if(0<b.length){var d=Ba(a,b);a=d.ba;d=d.ca;for(var e=0;e<a.length-1;e++)for(var f=(a[e]+(a[e]+1))/2,l=a[e+1]-a[e],g=0;g<d.length-1;g++){for(var h=(d[g]+(d[g]+1))/2,k=d[g+1]-d[g],m=!1,u=0;u<b.length;u++){var w=C(b[u]);if(w.x<f&&w.x+w.width>f&&w.y<h&&w.y+w.height>h){m=!0;break}}m&&(c+=Math.round(l)*Math.round(k))}}return c}\nfunction Ba(a,b){a=C(a);for(var c=[],d=[],e=0;e<b.length;e++){var f=C(b[e]);f=Ca(a,f);Da(c,f.x);Da(c,f.endX);Da(d,f.y);Da(d,f.endY)}c=c.sort(function(l,g){return l-g});d=d.sort(function(l,g){return l-g});return{ba:c,ca:d}}function Ca(a,b){return{x:Math.max(a.x,b.x),y:Math.max(a.y,b.y),endX:Math.min(a.x+a.width,b.x+b.width),endY:Math.min(a.y+a.height,b.y+b.height)}}function Da(a,b){-1===a.indexOf(b)&&a.push(b)};function Ea(){this.b=this.a=this.v=this.l=this.g=this.j=void 0;this.m=0;this.h=[];this.o=[];this.u=0;this.i=[];this.c=[];this.f=[]}Ea.prototype.J=function(a){return null==a?!1:JSON.stringify(Fa(this))===JSON.stringify(Fa(a))};\nfunction Fa(a){var b=[],c=[],d={viewport:a.j,adView:{percentageInView:a.m,pixelsInView:a.u,reasons:a.f},declaredFriendlyObstructions:a.h.length};if(void 0!==a.a){d.adView.geometry=C(a.a);d.adView.geometry.pixels=ya(a.a);d.adView.onScreenGeometry=C(a.b);d.adView.onScreenGeometry.pixels=Math.max(0,ya(a.b)-Aa(a.b,a.c));for(var e=0;e<a.c.length;e++)b.push(C(a.c[e]));for(e=0;e<a.o.length;e++){var f=a.o[e],l=f,g={};l.b&&(g.obstructionClass=l.b);l.c&&(g.obstructionPurpose=l.c);l.f&&(g.obstructionReason=\nl.f);f=Ca(a.a,f);c.push(Object.assign({},{x:f.x,y:f.y,width:f.endX-f.x,height:f.endY-f.y},g))}d.adView.onScreenGeometry.obstructions=b;d.adView.onScreenGeometry.friendlyObstructions=c;void 0!==a.l&&void 0!==a.v&&(d.adView.containerGeometry=C(a.l),d.adView.onScreenContainerGeometry=C(a.v),d.adView.measuringElement=!0)}return d}function Ga(a,b){b=va(b);a.j={};a.j.width=b.width;a.j.height=b.height;a.g={};a.g.x=0;a.g.y=0;a.g.width=b.width;a.g.height=b.height;a.g.endX=b.width;a.g.endY=b.height}\nfunction Ha(){return{x:0,y:0,endX:0,endY:0,width:0,height:0}}function Ia(a,b){var c={};c.x=Math.max(a.x,b.x);c.y=Math.max(a.y,b.y);c.endX=Math.min(a.endX,b.endX);c.endY=Math.min(a.endY,b.endY);c.width=Math.max(0,c.endX-c.x);c.height=Math.max(0,c.endY-c.y);return c}function Ja(a,b){return.01<b.width-a.width||.01<b.height-a.height}function Ka(a){if(-1!==a.f.indexOf('backgrounded'))a.m=0,a.u=0;else{var b=ya(a.a);if(0!==b){var c=Math.max(0,ya(a.b)-Aa(a.b,a.c));a.m=Math.round(c/b*100);a.u=c}}}\nfunction La(a,b){if(za(b)||!a.b)b=!1;else{var c=wa(a.b),d=c.y,e=c.endX;a=c.endY;var f=b.endX;c=c.x;(f=f<c||.01>Math.abs(f-c))||(f=b.x,f=f>e||.01>Math.abs(f-e));(e=f)||(e=b.endY,e=e<d||.01>Math.abs(e-d));(d=e)||(b=b.y,d=b>a||.01>Math.abs(b-a));b=!d}return b}function D(a,b){for(var c=!1,d=0;d<a.f.length;d++)a.f[d]===b&&(c=!0);c||a.f.push(b)};function Ma(a,b,c,d,e){var f=new Ea;b=new B(b,!1);Ga(f,b);Na(a,b,f,d);if(!e)return f.f=['unmeasurable'],f.j=void 0,f.m=0,f.c=[],f.a&&(a=f.a,c={},a=new B((c.x=0,c.y=0,c.width=a.width,c.height=a.height,c),a.a),f.a=a),f.b=Ha(),f;if('backgrounded'===c)D(f,'backgrounded');else if(void 0!==f.a){for(a=0;a<f.h.length;a++)La(f,f.h[a])&&f.o.push(f.h[a]);for(a=0;a<f.i.length;a++){if(c=La(f,f.i[a])){a:{c=f.i[a];for(d=0;d<f.c.length;d++)if(f.c[d].J(c)){c=!0;break a}c=!1}c=!c}c&&(D(f,'obstructed'),f.c.push(f.i[a]))}Ka(f)}else D(f,\n'notFound');return f}\nfunction Na(a,b,c,d){var e=b.isCreative?!0:b.adSessionId===d;if(e){c.a=b;var f=wa(c.a);a=Ia(c.g,f);var l=c.a;'notAttached'===l.notVisibleReason||'noWindowFocus'===l.notVisibleReason||'noAdView'===l.notVisibleReason?(D(c,'notFound'),c.b=new B(Ha(),!1)):(l=c.a,'viewInvisible'===l.notVisibleReason||'viewGone'===l.notVisibleReason||'viewNotVisible'===l.notVisibleReason||'viewAlphaZero'===l.notVisibleReason||'viewHidden'===l.notVisibleReason||void 0!==c.a.notVisibleReason||za(c.a)?(D(c,'hidden'),c.b=new B(Ha(),\n!1)):(c.a.g||(D(c,'backgrounded'),D(c,'noWindowFocus')),Ja(a,f)&&D(c,'clipped'),c.b=new B(a,!1)))}else if(f=!0,b.a&&(f=-1!==b.isFriendlyObstructionFor.indexOf(d)?!1:!1===b.clipsToBounds),f){l=b.childViews;for(var g=0;g<l.length;g++)f=void 0!==c.a,Na(a,new B(l[g],f),c,d)}e||void 0===c.a||(b.a?-1!==b.isFriendlyObstructionFor.indexOf(d)?c.h.push(b):c.i.push(b):(e=wa(b),d=wa(c.b),C(c.b),!za(c.b)&&b.clipsToBounds&&(b=Ia(d,e),Ja(b,d)&&(D(c,'clipped'),c.b=new B(b,!1)))))};function Oa(a,b){this.y=this.x=0;this.width=a;this.height=b};function Pa(){return{apiVersion:'1.0',accessMode:'limited',environment:'app',omidJsInfo:{omidImplementer:'omsdk',serviceVersion:'1.3.37-iab3566'}}}function Qa(){this.adSessionId=null;this.c=Pa();this.o=null;this.m='foregrounded';this.l=this.i='none';this.j=this.g=this.f=this.h=this.a=this.b=this.B=this.u=null;this.C=!0;this.v=new Map}var G;function H(){G||(G=new Qa);return G};var I=function(){if('undefined'!==typeof omidGlobal&&omidGlobal)return omidGlobal;if('undefined'!==typeof global&&global)return global;if('undefined'!==typeof window&&window)return window;if('undefined'!==typeof globalThis&&globalThis)return globalThis;var a=Function('return this')();if(a)return a;throw Error('Could not determine global object context.');}();function Ra(a,b){this.a=a;this.b=b}t.Object.defineProperties(Ra.prototype,{event:{configurable:!0,enumerable:!0,get:function(){return this.a}},origin:{configurable:!0,enumerable:!0,get:function(){return this.b}}});function J(a){for(var b=[],c=0;c<arguments.length;++c)b[c]=arguments[c];Sa(function(){throw new (Function.prototype.bind.apply(Error,[null,'Could not complete the test successfully - '].concat(q(b))));},function(){return console.error.apply(console,q(b))})}function Ta(a){for(var b=[],c=0;c<arguments.length;++c)b[c]=arguments[c];Sa(function(){},function(){return console.error.apply(console,q(b))})}\nfunction Sa(a,b){'undefined'!==typeof jasmine&&jasmine?a():'undefined'!==typeof console&&console&&console.error&&b()};function Ua(){this.f=[];this.b=[];this.c=[];this.g=[];this.i={};this.a=H()}function Va(a){a.f=[];a.b=[];a.c=[];a.g=[];a.i={};G.adSessionId=null;G.c=Pa();G.o=null;G.G=void 0;G.K=void 0;G.H=null;G.I=null;G.D=null;G.m='foregrounded';G.i='none';G.l='none';G.u=null;G.B=null;G.b=null;G.a=null;G.h=null;G.f=null;G.g=null;G.j=null;G.C=!0;G.v=new Map}\nfunction Wa(a,b){void 0!==a.a&&a.a.adSessionId&&!1!==Xa(a,b)&&a.c.filter(function(c){return c.type===b.event.type}).forEach(function(c){return a.h(c.F,b.event)})}function Ya(a,b){a.f.push(b);Wa(a,b)}function Za(a,b,c){void 0!==a.a&&a.a.adSessionId&&a.f.filter(function(d){return d.event.type===b&&Xa(a,d)}).map(function(d){return d.event}).forEach(c)}\nfunction Xa(a,b){var c=b.event.type,d=-1!==Object.values(A).indexOf(c)&&'volumeChange'!==c;return'impression'===c||'loaded'===c&&a.a.a?b.origin===H().l:d?b.origin===H().i:!0}function $a(a,b,c){'media'===b||'video'===b?ab(a,c):(a.c.push({type:b,F:c}),Za(a,b,c))}function ab(a,b){Object.keys(A).forEach(function(c){c=A[c];a.c.push({type:c,F:b});Za(a,c,b)})}function bb(a,b,c,d){var e={O:c,L:d,F:b};a.g.push(e);a.b.forEach(function(f){var l=cb(f);'sessionStart'===f.event.type&&db(a,l,e);a.h(b,l)})}\nfunction eb(a,b,c){var d=K(a,'sessionError','native',{errorType:b,message:c});a.b.push(d);a.g.forEach(function(e){a.h(e.F,d.event)})}function fb(a,b){a.i=Object.assign(a.i,b);b=a.a.c;if(void 0!==b){b=Object.assign({},gb(a,hb(a,{context:b}),!0),{supportsLoadedEvent:!!a.a.a||'video'==a.a.b});Object.assign(b,{pageUrl:null,contentUrl:a.a.o});var c=K(a,'sessionStart','native',b);a.b.push(c);a.g.forEach(function(d){var e=d.F,f=cb(c);db(a,f,d);a.h(e,f)},a);ib(a)}}\nfunction db(a,b,c){c.O&&(b.data.verificationParameters=a.i[c.O]);c.L&&(c=a.a.v.get(c.L))&&(b.data.verificationParameters=c.verificationParameters,b.data.context.accessMode=c.accessMode,'full'===c.accessMode&&(a.a.g&&(b.data.context.videoElement=a.a.g),a.a.f&&(b.data.context.slotElement=a.a.f)))}function jb(a){var b=a.g,c=K(a,'sessionFinish','native');a.b.push(c);var d=a.a.c;d&&'native'==d.adSessionType||Va(a);b.forEach(function(e){return a.h(e.F,c.event)})}\nUa.prototype.h=function(a,b){for(var c=[],d=1;d<arguments.length;++d)c[d-1]=arguments[d];try{a.apply(null,q(c))}catch(e){Ta(e)}};function kb(a,b){var c=(c=H().D)?Fa(c):void 0;c=gb(a,hb(a,c));Ya(a,K(a,'impression',b,c))}function lb(a,b,c){if(a.a.a||'display'!=a.a.b)b=K(a,'loaded',b,gb(a,hb(a,void 0===c?null:c))),Ya(a,b)}\nfunction mb(a,b,c,d){'start'!==b&&'volumeChange'!==b||null!=(d&&d.deviceVolume)||(d.deviceVolume=a.a.u);if(d&&('start'===b||'volumeChange'===b)){var e=d.videoPlayerVolume,f=d.mediaPlayerVolume;null!=e?(Object.assign(d,{mediaPlayerVolume:e}),a.a.B=e):null!=f&&(Object.assign(d,{videoPlayerVolume:f}),a.a.B=f)}Ya(a,K(a,b,c,d))}\nfunction ib(a){var b=a.f.filter(function(f){return Object.values(A).includes(f.event.type)&&'video'==a.a.b&&f.origin===a.a.i||'loaded'==f.event.type&&'display'==a.a.b&&f.origin===a.a.l?!0:!1}).map(function(f){return f.event}),c=a.a.adSessionId||'',d={};b=p(b);for(var e=b.next();!e.done;d={w:d.w},e=b.next()){d.w=e.value;d.w.adSessionId||(d.w.adSessionId=c);if('loaded'==d.w.type){if(!a.a.a&&'display'==a.a.b)continue;d.w.data=gb(a,hb(a,d.w.data))}a.c.filter(function(f){return function(l){return l.type===\nf.w.type}}(d)).forEach(function(f){return function(l){return l.F(f.w)}}(d))}}function nb(a,b,c){a:{c=new Set(c);a=p(a.f.concat(a.b));for(var d=a.next();!d.done;d=a.next())if(d=d.value,c.has(d.event.type)&&d.origin!=b){b=!0;break a}b=!1}return b?(J('Event owner cannot be registered after its events have already been published.'),!1):!0}function ob(a,b){nb(a,b,Object.values(A))&&L(a,b)&&(a.a.i=b)}function pb(a,b){nb(a,b,['impression'])&&qb(a,b)&&(a.a.l=b)}\nfunction qb(a,b){var c=a.a.l;return'none'!=c&&c!=b?(J('Impression event is owned by '+(a.a.l+', not ')+(b+'.')),!1):!0}function L(a,b){var c=a.a.i;return'none'!=c&&c!=b?(J('Media events are owned by '+(a.a.i+', not '+b+'.')),!1):!0}function gb(a,b,c){c=void 0===c?!1:c;b=Object.assign({},b);a.a.b&&Object.assign(b,{mediaType:a.a.b});a.a.a&&(c||'definedByJavaScript'!==a.a.a)&&Object.assign(b,{creativeType:a.a.a});return b}function hb(a,b){return a.a.h?Object.assign({},b,{impressionType:a.a.h}):b}\nfunction K(a,b,c,d){return new Ra({adSessionId:a.a.adSessionId||'',timestamp:(new Date).getTime(),type:b,data:d},c)}function cb(a){a=a.event;return{adSessionId:a.adSessionId,timestamp:a.timestamp,type:a.type,data:a.data}};function rb(a,b,c){'container'===b&&void 0!==a.a.G&&void 0!==a.a&&null!=a.a.adSessionId&&(a.a.H=Ma(a.c,a.a.G,a.a.m,a.a.adSessionId,!0));b=a.a;var d=b.H,e=b.I;if(d)if(e){b=new Ea;var f=d.j,l=d.a,g=d.b,h=e.a,k=e.b;f&&l&&g&&h&&k&&(Ga(b,f),b.l=new B(l,!1),b.v=new B(g,!1),b.i=Object.assign([],d.i),b.c=Object.assign([],d.c),b.h=Object.assign([],d.h),b.o=Object.assign([],d.o),b.f=Object.assign([],e.f,d.f),d=b.l.x,e=b.l.y,h=new B(h,!1),k=new B(k,!1),xa(h,d,e),xa(k,d,e),b.a=h,b.b=Ia(k,g),Ka(b))}else b=d;else b=\nnull;g=a.a.D;if(b&&!b.J(g)||c)g=Fa(b),c&&(g.adView.reasons=g.adView.reasons||[c]),c=a.b,'audio'!=c.a.a&&Ya(c,K(c,'geometryChange','native',g)),a.a.D=b};function M(a){return'object'===typeof a}function sb(a){return'number'===typeof a&&!isNaN(a)&&0<=a}function N(a){return'string'===typeof a}function O(a,b){return N(a)&&-1!==Object.values(b).indexOf(a)}function tb(a){return!(!a||!a.tagName||'iframe'!==a.tagName.toLowerCase())};function P(a,b,c){this.f=a;this.K=b;this.G=c;this.c=H();this.b=null;this.a=this.g=this.u=void 0;this.I=!0;this.B=void 0;Q(this)}function Q(a){if(!a.b){var b;a:{if((b=a.f.document)&&b.getElementsByClassName&&(b=b.getElementsByClassName('omid-element'))){if(1==b.length){b=b[0];break a}1<b.length&&a.I&&(eb(a.G,'generic',\"More than one element with 'omid-element' class name.\"),a.I=!1)}b=null}if(b&&b.tagName&&'video'===b.tagName.toLowerCase())a.c.g=b;else if(b&&b.tagName)a.c.f=b;else return;ub(a)}}\nfunction ub(a){a.c.g?(a.b=a.c.g,a.i()):a.c.f&&(a.b=a.c.f,tb(a.b)?a.c.j&&a.i():a.i())}function vb(a){a.a&&(tb(a.b)?a.c.j&&(a.D(),wb(a)):(a.D(),wb(a)))}P.prototype.m=function(){this.B&&(this.f.document.removeEventListener('visibilitychange',this.B),this.B=void 0)};P.prototype.i=function(){};function wb(a){a.u&&(a.c.I=a.u,rb(a.K,'creative'))}function xb(a){if(a.a&&a.c.j){var b=new B(a.c.j,!1);xa(b,a.a.x,a.a.y);b.clipsToBounds=!0;return b}};function yb(a,b,c){return zb(a,'setInterval')(b,c)}function Ab(a,b){zb(a,'clearInterval')(b)}function Bb(a,b){zb(a,'clearTimeout')(b)}function zb(a,b){return a.a&&a.a[b]?a.a[b]:Cb(a,b)}\nfunction Db(a,b,c,d){if(a.a.document&&a.a.document.body){var e=a.a.document.createElement('img');e.width=1;e.height=1;e.style.display='none';e.src=b;c&&e.addEventListener('load',function(){return c()});d&&e.addEventListener('error',function(){return d()});a.a.document.body.appendChild(e)}else Cb(a,'sendUrl')(b,c,d)}function Cb(a,b){if(a.a&&a.a.omidNative&&a.a.omidNative[b])return a.a.omidNative[b].bind(a.a.omidNative);throw Error('Native interface method \"'+b+'\" not found.');};function R(a,b,c,d,e){P.call(this,a,c,e);this.l=b;this.h=void 0;this.j=d}r(R,P);R.prototype.m=function(){void 0!==this.h&&(Ab(this.j,this.h),this.h=void 0);P.prototype.m.call(this)};R.prototype.i=function(){var a=this;P.prototype.i.call(this);null==this.b?this.h=void 0:void 0===this.h&&(this.h=yb(this.j,function(){return Eb(a)},200),Eb(this))};\nR.prototype.D=function(){if(this.g){var a=xb(this);if(a){this.a.isCreative=!1;a.isCreative=!0;for(var b=!1,c=0;c<this.a.childViews.length;c++)if(this.a.childViews[c].isCreative){this.a.childViews[c]=a;b=!0;break}b||this.a.childViews.push(a)}else this.a.isCreative=!0;this.u=Ma(this.l,this.g,this.c.m,this.c.adSessionId,this.C())}};R.prototype.C=function(){return!0};\nfunction Eb(a){if(void 0!==a.h){b:{try{var b=a.f.top;var c=0<=b.innerHeight&&0<=b.innerWidth;break b}catch(d){}c=!1}c?(c=a.f.top,c=new B(new Oa(c.innerWidth,c.innerHeight),!1)):c=new B(new Oa(0,0),!1);b=a.b.getBoundingClientRect();if(null==b.x||isNaN(b.x))b.x=b.left;if(null==b.y||isNaN(b.y))b.y=b.top;b=new B(b,!1);c.J(a.g)&&b.J(a.a)||(a.a=b,a.a.clipsToBounds=!0,a.g=c,a.g.childViews.push(a.a),vb(a))}};function S(a,b,c,d){P.call(this,a,c,d);this.o=this.j=this.l=this.h=void 0;this.H=!1;this.v=void 0}r(S,P);S.prototype.m=function(){this.h&&this.h.disconnect();Fb(this);P.prototype.m.call(this)};S.prototype.i=function(){P.prototype.i.call(this);this.b&&(this.h||(this.h=Gb(this)),Hb(this),Ib(this.b)&&Jb(this))};\nS.prototype.D=function(){if(this.a&&this.v){var a=xb(this);if(a){var b=a;var c=this.v;var d=Math.max(a.x,c.x);var e=Math.max(a.y,c.y),f=Math.min(a.endX,c.endX);a=Math.min(a.endY,c.endY);f<=d||a<=e?d=null:(c={},d=new B((c.x=d,c.y=e,c.width=Math.abs(f-d),c.height=Math.abs(a-e),c),!1));d||(d=new B({x:0,y:0,width:0,height:0},!1))}else b=this.a,d=this.v;e=new Ea;this.g&&Ga(e,this.g);e.a=b;e.b=d;Ka(e);this.H?za(e.a)?D(e,'hidden'):100===e.m||D(e,'clipped'):D(e,'viewport');this.u=e}};S.prototype.C=function(){return!0};\nfunction Fb(a){a.l&&(a.l.disconnect(),a.l=void 0);a.j&&(a.j.disconnect(),a.j=void 0);a.o&&((0,a.f.removeEventListener)('resize',a.o),a.o=void 0)}function Hb(a){a.h&&a.b&&(a.h.unobserve(a.b),a.h.observe(a.b))}function Ib(a){a=a.getBoundingClientRect();return 0==a.width||0==a.height}\nfunction Gb(a){return new a.f.IntersectionObserver(function(b){try{if(b.length){for(var c,d=b[0],e=1;e<b.length;e++)b[e].time>d.time&&(d=b[e]);c=d;a.g=Kb(c.rootBounds);a.a=Kb(c.boundingClientRect);a.v=Kb(c.intersectionRect);a.H=!!c.isIntersecting;vb(a)}}catch(f){a.m(),eb(a.G,'generic','Problem handling IntersectionObserver callback: '+f.message)}},{root:null,rootMargin:'0px',threshold:[0,.1,.2,.3,.4,.5,.6,.7,.8,.9,1]})}\nfunction Jb(a){a.f.ResizeObserver?a.l||(a.l=Lb(a,function(){return Mb(a)}),a.l.observe(a.b)):(a.o||(a.o=function(){return Mb(a)},(0,a.f.addEventListener)('resize',a.o)),a.j||(a.j=new MutationObserver(function(){return Mb(a)}),a.j.observe(a.b,{childList:!1,attributes:!0,subtree:!1})))}function Mb(a){a.b&&!Ib(a.b)&&(Hb(a),Fb(a))}function Lb(a,b){return new a.f.ResizeObserver(b)}function Kb(a){if(a&&null!==a.x&&null!==a.y&&null!==a.width&&null!==a.height)return new B(a,!1)};function Nb(a){return a&&M(a)?Object.entries(a).reduce(function(b,c){var d=p(c);c=d.next().value;d=d.next().value;return b&&N(c)&&null!=d&&M(d)&&N(d.resourceUrl)},!0):!1};function T(a,b,c,d){this.b=a;this.method=b;this.version=c;this.a=d}function Pb(a){return!!a&&void 0!==a.omid_message_guid&&void 0!==a.omid_message_method&&void 0!==a.omid_message_version&&'string'===typeof a.omid_message_guid&&'string'===typeof a.omid_message_method&&'string'===typeof a.omid_message_version&&(void 0===a.omid_message_args||void 0!==a.omid_message_args)}function Qb(a){return new T(a.omid_message_guid,a.omid_message_method,a.omid_message_version,a.omid_message_args)}\nfunction Rb(a){var b={};b=(b.omid_message_guid=a.b,b.omid_message_method=a.method,b.omid_message_version=a.version,b);void 0!==a.a&&(b.omid_message_args=a.a);return b};function Sb(a){this.c=a};function U(a){this.c=a;this.handleExportedMessage=U.prototype.f.bind(this)}r(U,Sb);U.prototype.b=function(a,b){b=void 0===b?this.c:b;if(!b)throw Error('Message destination must be defined at construction time or when sending the message.');b.handleExportedMessage(Rb(a),this)};U.prototype.f=function(a,b){Pb(a)&&this.a&&this.a(Qb(a),b)};function Tb(a){return Ub(a,'SessionService.')}function Ub(a,b){return(a=a.match(new RegExp('^'+b+'(.*)')))&&a[1]};function Vb(a,b){this.c=b=void 0===b?I:b;var c=this;a.addEventListener('message',function(d){if('object'===typeof d.data){var e=d.data;Pb(e)&&d.source&&c.a&&c.a(Qb(e),d.source)}})}r(Vb,Sb);Vb.prototype.b=function(a,b){b=void 0===b?this.c:b;if(!b)throw Error('Message destination must be defined at construction time or when sending the message.');b.postMessage(Rb(a),'*')};function Wb(){return'xxxxxxxx-xxxx-4xxx-yxxx-xxxxxxxxxxxx'.replace(/[xy]/g,function(a){var b=16*Math.random()|0;return'y'===a?(b&3|8).toString(16):b.toString(16)})};function Xb(a){if(!a.a||!a.a.document)throw Error('OMID Service Script is not running within a window.');var b=a.b;a.b=[];b.forEach(function(c){try{var d=a.c.C?'limited':'full',e=O(c.accessMode,sa)?c.accessMode:null;var f=e?'full'==e&&'limited'==d?d:'domain'==e?'limited':e:d;c.accessMode=f;a:{var l=c.resourceUrl,g=a.a.location.origin;try{var h=new URL(l,g);break a}catch(V){}try{h=new URL(l);break a}catch(V){}h=null}if(d=h){var k=Wb(),m=a.a.document,u=m.createElement('iframe');u.id='omid-verification-script-frame-'+\nk;u.style.display='none';['full','limited'].includes(f)?u.srcdoc=\"<html><head>\\n<script type=\\\"text/javascript\\\">window['omidVerificationProperties'] = {\\n'serviceWindow': window.parent,\\n'injectionSource': 'app',\\n'injectionId': '\"+(k+'\\',\\n};\\x3c/script>\\n<script type=\"text/javascript\" src=\"')+d.href+'\">\\x3c/script>\\n</head><body></body></html>':'domain'==f&&(u.src=Yb(a,k,d).href);['domain','limited'].includes(f)&&(u.sandbox='allow-scripts');m.body.appendChild(u);var w=c.vendorKey,E=c.verificationParameters;\nw=void 0===w?'':w;E=void 0===E?'':E;w&&'string'===typeof w&&''!==w&&E&&'string'===typeof E&&''!==E&&(a.f.i[w]=E);a.c.v.set(k,c)}}catch(V){Ta('OMID verification script '+c.resourceUrl+' failed to load: '+V)}})}\nfunction Yb(a,b,c){var d='/.well-known/omid/omloader-v1.html#';(new Map([['verificationScriptUrl',c.href],['injectionId',b]])).forEach(function(e,f){d+=encodeURIComponent(f)+'='+encodeURIComponent(e)+'&'});b=null;try{b=new URL(d,a.a.parent.location.origin)}catch(e){throw Error('OMID Service Script cannot access the parent window.');}return b};function Zb(){var a=$b,b=ac,c=this;this.c=X;this.b=a;this.a=H();this.g=b;this.f=!1;this.registerSessionObserver(function(d){return bc(c,d)})}n=Zb.prototype;n.registerSessionObserver=function(a){bb(this.c,a)};n.setSlotElement=function(a){a&&a.tagName?(this.a.f=a,this.b&&ub(this.b)):J('setSlotElement called with a non-HTMLElement.  It will be ignored.')};n.setElementBounds=function(a){this.a.j=a;this.b&&ub(this.b);this.b&&vb(this.b)};n.error=function(a,b){eb(this.c,a,b)};\nn.registerAdEvents=function(){pb(this.c,'javascript')};n.registerMediaEvents=function(){ob(this.c,'javascript')};function Y(a,b,c){'impression'==b?qb(a.c,'javascript')&&(kb(a.c,'javascript'),a.b&&Q(a.b)):('loaded'==b?(c=void 0===c?null:c,L(a.c,'javascript')&&lb(a.c,'javascript',c)):L(a.c,'javascript')&&mb(a.c,b,'javascript',c),['loaded','start'].includes(b)&&a.b&&Q(a.b))}n.injectVerificationScriptResources=function(a){var b=this.g;b.b.push.apply(b.b,q(a));if(this.f)try{Xb(this.g)}catch(c){J(c.message)}};\nn.setCreativeType=function(a,b){b=void 0===b?null:b;if(!this.a.b||this.a.a)this.a.a=a,'video'==a||'audio'==a?this.a.b='video':'htmlDisplay'==a||'nativeDisplay'==a?this.a.b='display':'definedByJavaScript'==a&&b&&(this.a.b='none'==b?'display':'video')};n.setImpressionType=function(a){if(!this.a.b||this.a.a)this.a.h=a};\nfunction bc(a,b){if('sessionStart'===b.type){a.f=!0;try{Xb(a.g)}catch(c){J(c.message)}}'sessionFinish'===b.type&&(a.f=!1,(b=H().c)&&'native'==b.adSessionType||a.registerSessionObserver(function(c){return bc(a,c)}))}n.setClientInfo=function(a,b,c){var d=this.a.c||{};d.omidJsInfo=Object.assign({},d.omidJsInfo,{sessionClientVersion:a,partnerName:b,partnerVersion:c});this.a.c=d;return this.a.c.omidJsInfo.serviceVersion};function cc(a){return/\\d+\\.\\d+\\.\\d+(-.*)?/.test(a)}function dc(a){a=a.split('-')[0].split('.');for(var b=['1','0','3'],c=0;3>c;c++){var d=parseInt(a[c],10),e=parseInt(b[c],10);if(d>e)break;else if(d<e)return!1}return!0};function ec(a,b){return cc(a)&&dc(a)?b?b:[]:b&&'string'===typeof b?JSON.parse(b):[]};var fc=new function(){};function gc(){var a=hc;var b=void 0===b?omidGlobal:b;this.a=a;this.g=b;this.b=new U;this.g.omid=this.g.omid||{};this.g.omid.v1_SessionServiceCommunication=this.b;this.f=b&&b.addEventListener&&b.postMessage?new Vb(b):null;this.c=null;this.b.a=this.h.bind(this);this.f&&(this.f.a=this.i.bind(this))}gc.prototype.h=function(a,b){null!=Tb(a.method)&&ic(this,fc)&&jc(this,a,b,this.b)};gc.prototype.i=function(a,b){null!=Tb(a.method)&&ic(this,b)&&jc(this,a,b,this.f)};\nfunction ic(a,b){a.c||(a.c=b);return a.c!=b?(J('The source of session client messages cannot be changed from the source of the first message.'),!1):!0}\nfunction jc(a,b,c,d){function e(h){for(var k=[],m=0;m<arguments.length;++m)k[m]=arguments[m];k=new T(f,'response',g,cc(g)&&dc(g)?k:JSON.stringify(k));d.b(k,c)}var f=b.b,l=b.method,g=b.version;b=ec(g,b.a);try{kc(a,l,e,b)}catch(h){d.b(new T(f,'error',g,'\\n        name: '+h.name+'\\n        message: '+h.message+'\\n        filename: '+h.filename+'\\n        lineNumber: '+h.lineNumber+'\\n        columnNumber: '+h.columnNumber+'\\n        stack: '+h.stack+'\\n        toString(): '+h.toString()),c)}}\nfunction kc(a,b,c,d){if(null!=Tb(b))switch(Tb(b)){case 'registerAdEvents':a.a.registerAdEvents();break;case 'registerMediaEvents':a.a.registerMediaEvents();break;case 'registerSessionObserver':a.a.registerSessionObserver(c);break;case 'setSlotElement':c=p(d).next().value;a.a.setSlotElement(c);break;case 'setVideoElement':c=p(d).next().value;a=a.a;c&&c.tagName&&'video'===c.tagName.toLowerCase()?(a.a.g=c,a.b&&ub(a.b)):J('setVideoElement called with a non-HTMLVideoElement. It will be ignored.');break;\ncase 'setElementBounds':c=p(d).next().value;a.a.setElementBounds(c);break;case 'startSession':J('Session start from JS is not supported in mobile app.');break;case 'finishSession':J('Session finish from JS is not supported in mobile app.');break;case 'impressionOccurred':Y(a.a,'impression');break;case 'loaded':(c=p(d).next().value)?(b={skippable:c.isSkippable,autoPlay:c.isAutoPlay,position:c.position},c.isSkippable&&(b.skipOffset=c.skipOffset),Y(a.a,'loaded',b)):Y(a.a,'loaded');break;case 'start':b=\np(d);c=b.next().value;b=b.next().value;Y(a.a,'start',{duration:c,mediaPlayerVolume:b});break;case 'firstQuartile':Y(a.a,'firstQuartile');break;case 'midpoint':Y(a.a,'midpoint');break;case 'thirdQuartile':Y(a.a,'thirdQuartile');break;case 'complete':Y(a.a,'complete');break;case 'pause':Y(a.a,'pause');break;case 'resume':Y(a.a,'resume');break;case 'bufferStart':Y(a.a,'bufferStart');break;case 'bufferFinish':Y(a.a,'bufferFinish');break;case 'skipped':Y(a.a,'skipped');break;case 'volumeChange':c={mediaPlayerVolume:p(d).next().value};\nY(a.a,'volumeChange',c);break;case 'playerStateChange':c={state:p(d).next().value};Y(a.a,'playerStateChange',c);break;case 'adUserInteraction':c={interactionType:p(d).next().value};Y(a.a,'adUserInteraction',c);break;case 'setClientInfo':var e=p(d);b=e.next().value;d=e.next().value;e=e.next().value;a=a.a.setClientInfo(b,d,e);c(a);break;case 'injectVerificationScriptResources':c=p(d).next().value;a.a.injectVerificationScriptResources(c);break;case 'setCreativeType':c=p(d).next().value;a.a.setCreativeType(c);\nbreak;case 'setImpressionType':c=p(d).next().value;a.a.setImpressionType(c);break;case 'setContentUrl':c=p(d).next().value;a.a.a.o=c;break;case 'sessionError':b=p(d),c=b.next().value,b=b.next().value,a.a.error(c,b)}};function Z(){var a=X,b=lc,c=mc,d=$b;this.f=hc;this.a=a;this.c=b;this.h=c;this.g=d;this.b=H()}n=Z.prototype;\nn.T=function(a){if(!(!(a&&M(a)&&O(a.impressionOwner,qa))||'videoEventsOwner'in a&&null!=a.videoEventsOwner&&!O(a.videoEventsOwner,qa)||'mediaEventsOwner'in a&&null!=a.mediaEventsOwner&&!O(a.mediaEventsOwner,qa))){if(a.creativeType&&a.impressionType){var b=a.mediaEventsOwner;null==this.b.a&&this.f.setCreativeType(a.creativeType,b);null==this.b.h&&(this.b.h=a.impressionType);ob(this.a,b)}else b=a.videoEventsOwner,this.b.b=null==b||'none'===b?'display':'video',this.b.a=null,this.b.h=null,ob(this.a,b);\npb(this.a,a.impressionOwner);a&&null!=a.isolateVerificationScripts&&'boolean'===typeof a.isolateVerificationScripts&&(this.b.C=a.isolateVerificationScripts)}};\nn.W=function(a,b,c,d){var e;if(M(b)){if(e=O(b.environment,ua)&&O(b.adSessionType,pa))e=b.omidNativeInfo,e=M(e)?N(e.partnerName)&&N(e.partnerVersion):!1;e&&(e=b.app,e=M(e)?N(e.libraryVersion)&&N(e.appId):!1)}else e=!1;e&&(Nb(d)&&(this.b.v=new Map(Object.entries(d))),d=this.f,c=void 0===c?null:c,null==a&&(a=Wb()),b.canMeasureVisibility=d.b.C(),d.a.adSessionId=a,a=d.a,e=b,void 0!==e.contentUrl&&(a.o=e.contentUrl,e.contentUrl=void 0),e=a.c||{},b.omidJsInfo=Object.assign({},e.omidJsInfo||{},b.omidJsInfo||\n{}),e=b=Object.assign({},e,b),a.C||(null!=a.g?(e.videoElement=a.g,e.accessMode='full'):null!=a.f&&(e.slotElement=a.f,e.accessMode='full')),a.c=b,fb(d.c,c),d.b&&Q(d.b))};n.U=function(){var a=this.f;jb(a.c);a.b.m()};n.$=function(a){M(a)&&sb(a.x)&&sb(a.y)&&sb(a.width)&&sb(a.height)&&(this.b.G=a,rb(this.c,'container'))};n.aa=function(a){O(a,ta)&&(this.b.m=a,'backgrounded'===a?rb(this.c,'container','backgrounded'):rb(this.c,'container'))};n.X=function(a){'impression'===a&&(this.M(),this.g&&Q(this.g))};\nn.M=function(){qb(this.a,'native')&&kb(this.a,'native')};n.V=function(a){a=void 0===a?null:a;L(this.a,'native')&&lb(this.a,'native',a)};n.error=function(a,b){O(a,oa)&&eb(this.a,a,b)};n.Y=function(a,b){this.N(a,b)};n.N=function(a,b){L(this.a,'native')&&O(a,A)&&(void 0===b||M(b))&&('loaded'==a?lb(this.a,'native',b):mb(this.a,a,'native',b))};\nn.Z=function(a){if('none'!==this.a.a.i&&'number'===typeof a&&!isNaN(a)){this.b.u=a;a=this.h;var b=a.a.B;null!=b&&mb(a.b,'volumeChange','native',{mediaPlayerVolume:b,deviceVolume:a.a.u})}};Z.prototype.startSession=Z.prototype.W;Z.prototype.error=Z.prototype.error;Z.prototype.finishSession=Z.prototype.U;Z.prototype.publishAdEvent=Z.prototype.X;Z.prototype.publishImpressionEvent=Z.prototype.M;Z.prototype.publishVideoEvent=Z.prototype.Y;Z.prototype.publishMediaEvent=Z.prototype.N;\nZ.prototype.publishLoadedEvent=Z.prototype.V;Z.prototype.setNativeViewHierarchy=Z.prototype.$;Z.prototype.setState=Z.prototype.aa;Z.prototype.setDeviceVolume=Z.prototype.Z;Z.prototype.init=Z.prototype.T;function nc(){var a=X,b=oc;var c=void 0===c?I:c;this.g=a;this.a=b;this.h={};this.f={};this.c=new U;c.omid=c.omid||{};c.omid.v1_VerificationServiceCommunication=this.c;this.b=null;c&&c.addEventListener&&c.postMessage&&(this.b=new Vb(c));this.c.a=this.i.bind(this);this.b&&(this.b.a=this.j.bind(this))}function pc(a,b,c,d){Db(a.a,b,c,d)}function qc(a,b,c,d){Cb(a.a,'downloadJavaScriptResource')(b,c,d)}nc.prototype.j=function(a,b){this.b&&rc(this,a,b,this.b)};nc.prototype.i=function(a,b){rc(this,a,b,this.c)};\nfunction rc(a,b,c,d){function e(F){for(var W=[],ra=0;ra<arguments.length;++ra)W[ra]=arguments[ra];W=new T(f,'response',g,cc(g)&&dc(g)?W:JSON.stringify(W));d.b(W,c)}var f=b.b,l=b.method,g=b.version;b=ec(g,b.a);if(null!=Ub(l,'VerificationService.')){l=Ub(l,'VerificationService.');try{switch(l){case 'addEventListener':var h=p(b).next().value;$a(a.g,h,e);break;case 'addSessionListener':var k=p(b),m=k.next().value,u=k.next().value;bb(a.g,e,m,u);break;case 'sendUrl':var w=p(b).next().value;pc(a,w,function(){return e(!0)},\nfunction(){return e(!1)});break;case 'setTimeout':var E=p(b),V=E.next().value,wc=E.next().value;a.h[V]=zb(a.a,'setTimeout')(e,wc);break;case 'clearTimeout':var xc=p(b).next().value;Bb(a.a,a.h[xc]);break;case 'setInterval':var Ob=p(b),yc=Ob.next().value,zc=Ob.next().value;a.f[yc]=yb(a.a,e,zc);break;case 'clearInterval':var Ac=p(b).next().value;Ab(a.a,a.f[Ac]);break;case 'injectJavaScriptResource':var Bc=p(b).next().value;qc(a,Bc,function(F){return e(!0,F)},function(){return e(!1)});break;case 'getVersion':p(b).next();\nvar Cc=H().c.omidJsInfo;e(Cc.serviceVersion)}}catch(F){d.b(new T(f,'error',g,'\\n              name: '+F.name+'\\n              message: '+F.message+'\\n              filename: '+F.filename+'\\n              lineNumber: '+F.lineNumber+'\\n              columnNumber: '+F.columnNumber+'\\n              stack: '+F.stack+'\\n              toString(): '+F.toString()+'\\n          '),c)}}};function sc(){var a=I.document.createElement('iframe');a.id='omid_v1_present';a.name='omid_v1_present';a.style.display='none';I.document.body.appendChild(a)}function tc(){var a=new MutationObserver(function(b){b.forEach(function(c){'BODY'===c.addedNodes[0].nodeName&&(sc(),a.disconnect())})});a.observe(I.document.documentElement,{childList:!0})};var X=new Ua,oc=new function(){var a;this.a=a=void 0===a?omidGlobal:a};new nc;var uc=new function(){},vc=new function(){},lc=new function(){this.b=X;this.c=vc;this.a=H()},Dc;I?Dc=I.IntersectionObserver&&(I.MutationObserver||I.ResizeObserver)?new S(I,uc,lc,X):new R(I,vc,lc,oc,X):Dc=null;var $b=Dc,ac=new function(){var a=X;var b=void 0===b?I:b;this.f=a;this.a=b;this.c=H();this.b=[]},hc=new Zb,mc=new function(){var a=X,b=H();this.b=a;this.a=b};I.omidBridge=new Z;new gc;\nif(I.frames&&I.document&&!('omid_v1_present'in I.frames)){var Ec;if(Ec=null==I.document.body)Ec='MutationObserver'in I;Ec?tc():I.document.body?sc():I.document.write('<iframe style=\"display:none\" id=\"omid_v1_present\" name=\"omid_v1_present\"></iframe>')};\n}).call(this, this);";
                                                            }
                                                        }
                                                        AdSessionContext adSessionContextCreateNativeAdSessionContext = AdSessionContext.createNativeAdSessionContext(c3487n9.b, strA2, verificationScriptResources, strE, str12);
                                                        Intrinsics.checkNotNullExpressionValue(adSessionContextCreateNativeAdSessionContext, "createNativeAdSessionContext(...)");
                                                        map3.put("omidAdSession", new C3371f9("native_video_ad", ImpressionType.VIEWABLE, adSessionContextCreateNativeAdSessionContext, false));
                                                        c3504oc.b.put("deferred", Boolean.TRUE);
                                                        L4 l9 = this.j;
                                                        if (l9 != null) {
                                                            str4 = str2;
                                                            str5 = str3;
                                                            try {
                                                                Intrinsics.checkNotNullExpressionValue(str5, str4);
                                                                ((M4) l9).a(str5, "OMID video ad session created and JavaScript resources injected");
                                                            } catch (Exception e) {
                                                                e = e;
                                                                L4 l10 = this.j;
                                                                if (l10 != null) {
                                                                    ((M4) l10).b(str5, ld.a(e, O5.a(str5, str4, "Setting up impression tracking for OMID Native Video encountered an unexpected error: ")));
                                                                }
                                                                C3339d5 c3339d5 = C3339d5.f3292a;
                                                                C3339d5.c.a(I4.a(e, "event"));
                                                            }
                                                            str6 = str4;
                                                            str7 = str5;
                                                            it = it2;
                                                            z2 = z;
                                                        }
                                                    }
                                                }
                                                it = it2;
                                                z2 = z;
                                                str6 = str2;
                                                str7 = str3;
                                            } catch (Exception e2) {
                                                e = e2;
                                                str4 = str2;
                                                str5 = str3;
                                            }
                                        } catch (Exception e3) {
                                            e = e3;
                                            str5 = str7;
                                            str4 = str2;
                                        }
                                    } catch (Exception e4) {
                                        e = e4;
                                        str4 = str6;
                                        str5 = str7;
                                    }
                                } catch (Exception e5) {
                                    e = e5;
                                    str4 = str6;
                                    str5 = str7;
                                    z = z2;
                                }
                            } else {
                                String str13 = str6;
                                String str14 = str7;
                                z = z2;
                                L4 l11 = this.j;
                                if (l11 != null) {
                                    ((M4) l11).c(str14, AbstractC3492o0.a(str14, str13, "initOmidForNativeDisplayAd ", this));
                                }
                                try {
                                    byte bJ2 = J();
                                    str2 = str13;
                                    try {
                                        String strL2 = L();
                                        Intrinsics.checkNotNull(strL2);
                                        JSONObject pubContent2 = new JSONObject(strL2);
                                        AdConfig adConfig4 = this.b;
                                        Intrinsics.checkNotNull(adConfig4);
                                        str3 = str14;
                                        try {
                                            C3418j0 c3418j1 = this.u;
                                            if (c3418j1 == null) {
                                                mapA = null;
                                            } else {
                                                boolean z4 = W8.f3228a;
                                                mapA = W8.a(c3418j1.h());
                                            }
                                            L4 l12 = this.j;
                                            Intrinsics.checkNotNullParameter(pubContent2, "pubContent");
                                            Intrinsics.checkNotNullParameter(adConfig4, "adConfig");
                                            try {
                                                C3455l7 c3455l7 = (C3455l7) new C3625x7(bJ2, pubContent2, null, false, adConfig4, mapA, null, l12).n("CONTAINER").get(0);
                                                if (contextT != null) {
                                                    ArrayList verificationScriptResources2 = new ArrayList();
                                                    for (C3328c8 c3328c9 : c3455l7.s) {
                                                        if (Intrinsics.areEqual("OMID_VIEWABILITY", c3328c9.b) && (c3328c9 instanceof C3385g9)) {
                                                            Map map4 = (Map) c3504oc.a("macros", Map.class);
                                                            String strA5 = C3533r0.a(((C3385g9) c3328c9).g, map4);
                                                            String str15 = ((C3385g9) c3328c9).h;
                                                            String strA6 = C3533r0.a(c3328c9.d, map4);
                                                            if (AbstractC3420j2.a(strA5) && AbstractC3420j2.a(str15)) {
                                                                verificationScriptResourceCreateVerificationScriptResourceWithoutParameters = VerificationScriptResource.createVerificationScriptResourceWithParameters(str15, new URL(strA6), strA5);
                                                                Intrinsics.checkNotNull(verificationScriptResourceCreateVerificationScriptResourceWithoutParameters);
                                                            } else {
                                                                verificationScriptResourceCreateVerificationScriptResourceWithoutParameters = VerificationScriptResource.createVerificationScriptResourceWithoutParameters(new URL(strA6));
                                                                Intrinsics.checkNotNull(verificationScriptResourceCreateVerificationScriptResourceWithoutParameters);
                                                            }
                                                            verificationScriptResources2.add(verificationScriptResourceCreateVerificationScriptResourceWithoutParameters);
                                                        }
                                                    }
                                                    if (verificationScriptResources2.size() != 0) {
                                                        HashMap map5 = c3504oc.b;
                                                        String strE2 = this.t.e();
                                                        String str16 = (String) c3504oc.b.get("creativeType");
                                                        Intrinsics.checkNotNullParameter(verificationScriptResources2, "verificationScriptResources");
                                                        C3487n9 c3487n10 = AbstractC3473m9.f3376a;
                                                        c3487n10.getClass();
                                                        Intrinsics.checkNotNullParameter(verificationScriptResources2, "verificationScriptResources");
                                                        Context contextD2 = C3517pb.d();
                                                        if (contextD2 == null) {
                                                            strA = ";(function(omidGlobal) {\n  'use strict';var n;function aa(a){var b=0;return function(){return b<a.length?{done:!1,value:a[b++]}:{done:!0}}}function p(a){var b='undefined'!=typeof Symbol&&Symbol.iterator&&a[Symbol.iterator];return b?b.call(a):{next:aa(a)}}function q(a){if(!(a instanceof Array)){a=p(a);for(var b,c=[];!(b=a.next()).done;)c.push(b.value);a=c}return a}var ba='function'==typeof Object.create?Object.create:function(a){function b(){}b.prototype=a;return new b},ca;\nif('function'==typeof Object.setPrototypeOf)ca=Object.setPrototypeOf;else{var da;a:{var ea={S:!0},fa={};try{fa.__proto__=ea;da=fa.S;break a}catch(a){}da=!1}ca=da?function(a,b){a.__proto__=b;if(a.__proto__!==b)throw new TypeError(a+' is not extensible');return a}:null}var ha=ca;\nfunction r(a,b){a.prototype=ba(b.prototype);a.prototype.constructor=a;if(ha)ha(a,b);else for(var c in b)if('prototype'!=c)if(Object.defineProperties){var d=Object.getOwnPropertyDescriptor(b,c);d&&Object.defineProperty(a,c,d)}else a[c]=b[c]}function ia(a){a=['object'==typeof window&&window,'object'==typeof self&&self,'object'==typeof global&&global,a];for(var b=0;b<a.length;++b){var c=a[b];if(c&&c.Math==Math)return c}return globalThis}\nvar t=ia(this),v='function'==typeof Object.defineProperties?Object.defineProperty:function(a,b,c){a!=Array.prototype&&a!=Object.prototype&&(a[b]=c.value)};function x(a,b){if(b){var c=t;a=a.split('.');for(var d=0;d<a.length-1;d++){var e=a[d];e in c||(c[e]={});c=c[e]}a=a[a.length-1];d=c[a];b=b(d);b!=d&&null!=b&&v(c,a,{configurable:!0,writable:!0,value:b})}}x('globalThis',function(a){return a||t});function y(a,b){return Object.prototype.hasOwnProperty.call(a,b)}\nvar ja='function'==typeof Object.assign?Object.assign:function(a,b){for(var c=1;c<arguments.length;c++){var d=arguments[c];if(d)for(var e in d)y(d,e)&&(a[e]=d[e])}return a};x('Object.assign',function(a){return a||ja});function ka(){ka=function(){};t.Symbol||(t.Symbol=la)}function ma(a,b){this.a=a;v(this,'description',{configurable:!0,writable:!0,value:b})}ma.prototype.toString=function(){return this.a};\nvar la=function(){function a(c){if(this instanceof a)throw new TypeError('Symbol is not a constructor');return new ma('jscomp_symbol_'+(c||'')+'_'+b++,c)}var b=0;return a}();function z(){ka();var a=t.Symbol.iterator;a||(a=t.Symbol.iterator=t.Symbol('Symbol.iterator'));'function'!=typeof Array.prototype[a]&&v(Array.prototype,a,{configurable:!0,writable:!0,value:function(){return na(aa(this))}});z=function(){}}function na(a){z();a={next:a};a[t.Symbol.iterator]=function(){return this};return a}\nx('WeakMap',function(a){function b(h){this.a=(g+=Math.random()+1).toString();if(h){h=p(h);for(var k;!(k=h.next()).done;)k=k.value,this.set(k[0],k[1])}}function c(){}function d(h){var k=typeof h;return'object'===k&&null!==h||'function'===k}function e(h){if(!y(h,l)){var k=new c;v(h,l,{value:k})}}function f(h){var k=Object[h];k&&(Object[h]=function(m){if(m instanceof c)return m;e(m);return k(m)})}if(function(){if(!a||!Object.seal)return!1;try{var h=Object.seal({}),k=Object.seal({}),m=new a([[h,2],[k,\n3]]);if(2!=m.get(h)||3!=m.get(k))return!1;m.delete(h);m.set(k,4);return!m.has(h)&&4==m.get(k)}catch(u){return!1}}())return a;var l='$jscomp_hidden_'+Math.random();f('freeze');f('preventExtensions');f('seal');var g=0;b.prototype.set=function(h,k){if(!d(h))throw Error('Invalid WeakMap key');e(h);if(!y(h,l))throw Error('WeakMap key fail: '+h);h[l][this.a]=k;return this};b.prototype.get=function(h){return d(h)&&y(h,l)?h[l][this.a]:void 0};b.prototype.has=function(h){return d(h)&&y(h,l)&&y(h[l],this.a)};\nb.prototype.delete=function(h){return d(h)&&y(h,l)&&y(h[l],this.a)?delete h[l][this.a]:!1};return b});\nx('Map',function(a){function b(){var g={};return g.A=g.next=g.head=g}function c(g,h){var k=g.a;return na(function(){if(k){for(;k.head!=g.a;)k=k.A;for(;k.next!=k.head;)return k=k.next,{done:!1,value:h(k)};k=null}return{done:!0,value:void 0}})}function d(g,h){var k=h&&typeof h;'object'==k||'function'==k?f.has(h)?k=f.get(h):(k=''+ ++l,f.set(h,k)):k='p_'+h;var m=g.b[k];if(m&&y(g.b,k))for(g=0;g<m.length;g++){var u=m[g];if(h!==h&&u.key!==u.key||h===u.key)return{id:k,list:m,index:g,s:u}}return{id:k,list:m,\nindex:-1,s:void 0}}function e(g){this.b={};this.a=b();this.size=0;if(g){g=p(g);for(var h;!(h=g.next()).done;)h=h.value,this.set(h[0],h[1])}}if(function(){if(!a||'function'!=typeof a||!a.prototype.entries||'function'!=typeof Object.seal)return!1;try{var g=Object.seal({x:4}),h=new a(p([[g,'s']]));if('s'!=h.get(g)||1!=h.size||h.get({x:4})||h.set({x:4},'t')!=h||2!=h.size)return!1;var k=h.entries(),m=k.next();if(m.done||m.value[0]!=g||'s'!=m.value[1])return!1;m=k.next();return m.done||4!=m.value[0].x||\n't'!=m.value[1]||!k.next().done?!1:!0}catch(u){return!1}}())return a;z();var f=new WeakMap;e.prototype.set=function(g,h){g=0===g?0:g;var k=d(this,g);k.list||(k.list=this.b[k.id]=[]);k.s?k.s.value=h:(k.s={next:this.a,A:this.a.A,head:this.a,key:g,value:h},k.list.push(k.s),this.a.A.next=k.s,this.a.A=k.s,this.size++);return this};e.prototype.delete=function(g){g=d(this,g);return g.s&&g.list?(g.list.splice(g.index,1),g.list.length||delete this.b[g.id],g.s.A.next=g.s.next,g.s.next.A=g.s.A,g.s.head=null,\nthis.size--,!0):!1};e.prototype.clear=function(){this.b={};this.a=this.a.A=b();this.size=0};e.prototype.has=function(g){return!!d(this,g).s};e.prototype.get=function(g){return(g=d(this,g).s)&&g.value};e.prototype.entries=function(){return c(this,function(g){return[g.key,g.value]})};e.prototype.keys=function(){return c(this,function(g){return g.key})};e.prototype.values=function(){return c(this,function(g){return g.value})};e.prototype.forEach=function(g,h){for(var k=this.entries(),m;!(m=k.next()).done;)m=\nm.value,g.call(h,m[1],m[0],this)};e.prototype[Symbol.iterator]=e.prototype.entries;var l=0;return e});x('Object.values',function(a){return a?a:function(b){var c=[],d;for(d in b)y(b,d)&&c.push(b[d]);return c}});\nx('Set',function(a){function b(c){this.a=new Map;if(c){c=p(c);for(var d;!(d=c.next()).done;)this.add(d.value)}this.size=this.a.size}if(function(){if(!a||'function'!=typeof a||!a.prototype.entries||'function'!=typeof Object.seal)return!1;try{var c=Object.seal({x:4}),d=new a(p([c]));if(!d.has(c)||1!=d.size||d.add(c)!=d||1!=d.size||d.add({x:4})!=d||2!=d.size)return!1;var e=d.entries(),f=e.next();if(f.done||f.value[0]!=c||f.value[1]!=c)return!1;f=e.next();return f.done||f.value[0]==c||4!=f.value[0].x||\nf.value[1]!=f.value[0]?!1:e.next().done}catch(l){return!1}}())return a;z();b.prototype.add=function(c){c=0===c?0:c;this.a.set(c,c);this.size=this.a.size;return this};b.prototype.delete=function(c){c=this.a.delete(c);this.size=this.a.size;return c};b.prototype.clear=function(){this.a.clear();this.size=0};b.prototype.has=function(c){return this.a.has(c)};b.prototype.entries=function(){return this.a.entries()};b.prototype.values=function(){return this.a.values()};b.prototype.keys=b.prototype.values;\nb.prototype[Symbol.iterator]=b.prototype.values;b.prototype.forEach=function(c,d){var e=this;this.a.forEach(function(f){return c.call(d,f,f,e)})};return b});x('Object.is',function(a){return a?a:function(b,c){return b===c?0!==b||1/b===1/c:b!==b&&c!==c}});x('Array.prototype.includes',function(a){return a?a:function(b,c){var d=this;d instanceof String&&(d=String(d));var e=d.length;c=c||0;for(0>c&&(c=Math.max(c+e,0));c<e;c++){var f=d[c];if(f===b||Object.is(f,b))return!0}return!1}});\nx('Object.entries',function(a){return a?a:function(b){var c=[],d;for(d in b)y(b,d)&&c.push([d,b[d]]);return c}});\nvar A={qa:'loaded',xa:'start',ka:'firstQuartile',sa:'midpoint',ya:'thirdQuartile',ia:'complete',ta:'pause',va:'resume',ha:'bufferStart',ga:'bufferFinish',wa:'skipped',Aa:'volumeChange',ua:'playerStateChange',da:'adUserInteraction'},oa={na:'generic',za:'video',ra:'media'},pa={R:'native',oa:'html',P:'javascript'},qa={R:'native',P:'javascript',NONE:'none'},sa={ma:'full',ja:'domain',pa:'limited'},ta={fa:'backgrounded',la:'foregrounded'},ua={ea:'app',Ba:'web'};function B(a,b){this.x=null!=a.x?a.x:a.left;this.y=null!=a.y?a.y:a.top;this.width=a.width;this.height=a.height;this.endX=this.x+this.width;this.endY=this.y+this.height;this.adSessionId=a.adSessionId||void 0;this.isFriendlyObstructionFor=a.isFriendlyObstructionFor||[];this.b=a.friendlyObstructionClass||void 0;this.c=a.friendlyObstructionPurpose||void 0;this.f=a.friendlyObstructionReason||void 0;this.clipsToBounds=void 0!==a.clipsToBounds?!0===a.clipsToBounds:!0;this.g=void 0!==a.hasWindowFocus?!0===\na.hasWindowFocus:!0;this.notVisibleReason=a.notVisibleReason||void 0;this.childViews=a.childViews||[];this.isCreative=a.isCreative||!1;this.a=b}function va(a){var b={};return b.width=a.width,b.height=a.height,b}function C(a){var b={};return Object.assign({},va(a),(b.x=a.x,b.y=a.y,b))}function wa(a){var b=C(a),c={};return Object.assign({},b,(c.endX=a.endX,c.endY=a.endY,c))}function xa(a,b,c){a.x+=b;a.y+=c;a.endX+=b;a.endY+=c}\nB.prototype.J=function(a){if(null==a)return!1;a=C(a);var b=a.y,c=a.width,d=a.height;return this.x===a.x&&this.y===b&&this.width===c&&this.height===d};function ya(a){return a.width*a.height}function za(a){return 0===a.width||0===a.height};function Aa(a,b){var c=0;if(0<b.length){var d=Ba(a,b);a=d.ba;d=d.ca;for(var e=0;e<a.length-1;e++)for(var f=(a[e]+(a[e]+1))/2,l=a[e+1]-a[e],g=0;g<d.length-1;g++){for(var h=(d[g]+(d[g]+1))/2,k=d[g+1]-d[g],m=!1,u=0;u<b.length;u++){var w=C(b[u]);if(w.x<f&&w.x+w.width>f&&w.y<h&&w.y+w.height>h){m=!0;break}}m&&(c+=Math.round(l)*Math.round(k))}}return c}\nfunction Ba(a,b){a=C(a);for(var c=[],d=[],e=0;e<b.length;e++){var f=C(b[e]);f=Ca(a,f);Da(c,f.x);Da(c,f.endX);Da(d,f.y);Da(d,f.endY)}c=c.sort(function(l,g){return l-g});d=d.sort(function(l,g){return l-g});return{ba:c,ca:d}}function Ca(a,b){return{x:Math.max(a.x,b.x),y:Math.max(a.y,b.y),endX:Math.min(a.x+a.width,b.x+b.width),endY:Math.min(a.y+a.height,b.y+b.height)}}function Da(a,b){-1===a.indexOf(b)&&a.push(b)};function Ea(){this.b=this.a=this.v=this.l=this.g=this.j=void 0;this.m=0;this.h=[];this.o=[];this.u=0;this.i=[];this.c=[];this.f=[]}Ea.prototype.J=function(a){return null==a?!1:JSON.stringify(Fa(this))===JSON.stringify(Fa(a))};\nfunction Fa(a){var b=[],c=[],d={viewport:a.j,adView:{percentageInView:a.m,pixelsInView:a.u,reasons:a.f},declaredFriendlyObstructions:a.h.length};if(void 0!==a.a){d.adView.geometry=C(a.a);d.adView.geometry.pixels=ya(a.a);d.adView.onScreenGeometry=C(a.b);d.adView.onScreenGeometry.pixels=Math.max(0,ya(a.b)-Aa(a.b,a.c));for(var e=0;e<a.c.length;e++)b.push(C(a.c[e]));for(e=0;e<a.o.length;e++){var f=a.o[e],l=f,g={};l.b&&(g.obstructionClass=l.b);l.c&&(g.obstructionPurpose=l.c);l.f&&(g.obstructionReason=\nl.f);f=Ca(a.a,f);c.push(Object.assign({},{x:f.x,y:f.y,width:f.endX-f.x,height:f.endY-f.y},g))}d.adView.onScreenGeometry.obstructions=b;d.adView.onScreenGeometry.friendlyObstructions=c;void 0!==a.l&&void 0!==a.v&&(d.adView.containerGeometry=C(a.l),d.adView.onScreenContainerGeometry=C(a.v),d.adView.measuringElement=!0)}return d}function Ga(a,b){b=va(b);a.j={};a.j.width=b.width;a.j.height=b.height;a.g={};a.g.x=0;a.g.y=0;a.g.width=b.width;a.g.height=b.height;a.g.endX=b.width;a.g.endY=b.height}\nfunction Ha(){return{x:0,y:0,endX:0,endY:0,width:0,height:0}}function Ia(a,b){var c={};c.x=Math.max(a.x,b.x);c.y=Math.max(a.y,b.y);c.endX=Math.min(a.endX,b.endX);c.endY=Math.min(a.endY,b.endY);c.width=Math.max(0,c.endX-c.x);c.height=Math.max(0,c.endY-c.y);return c}function Ja(a,b){return.01<b.width-a.width||.01<b.height-a.height}function Ka(a){if(-1!==a.f.indexOf('backgrounded'))a.m=0,a.u=0;else{var b=ya(a.a);if(0!==b){var c=Math.max(0,ya(a.b)-Aa(a.b,a.c));a.m=Math.round(c/b*100);a.u=c}}}\nfunction La(a,b){if(za(b)||!a.b)b=!1;else{var c=wa(a.b),d=c.y,e=c.endX;a=c.endY;var f=b.endX;c=c.x;(f=f<c||.01>Math.abs(f-c))||(f=b.x,f=f>e||.01>Math.abs(f-e));(e=f)||(e=b.endY,e=e<d||.01>Math.abs(e-d));(d=e)||(b=b.y,d=b>a||.01>Math.abs(b-a));b=!d}return b}function D(a,b){for(var c=!1,d=0;d<a.f.length;d++)a.f[d]===b&&(c=!0);c||a.f.push(b)};function Ma(a,b,c,d,e){var f=new Ea;b=new B(b,!1);Ga(f,b);Na(a,b,f,d);if(!e)return f.f=['unmeasurable'],f.j=void 0,f.m=0,f.c=[],f.a&&(a=f.a,c={},a=new B((c.x=0,c.y=0,c.width=a.width,c.height=a.height,c),a.a),f.a=a),f.b=Ha(),f;if('backgrounded'===c)D(f,'backgrounded');else if(void 0!==f.a){for(a=0;a<f.h.length;a++)La(f,f.h[a])&&f.o.push(f.h[a]);for(a=0;a<f.i.length;a++){if(c=La(f,f.i[a])){a:{c=f.i[a];for(d=0;d<f.c.length;d++)if(f.c[d].J(c)){c=!0;break a}c=!1}c=!c}c&&(D(f,'obstructed'),f.c.push(f.i[a]))}Ka(f)}else D(f,\n'notFound');return f}\nfunction Na(a,b,c,d){var e=b.isCreative?!0:b.adSessionId===d;if(e){c.a=b;var f=wa(c.a);a=Ia(c.g,f);var l=c.a;'notAttached'===l.notVisibleReason||'noWindowFocus'===l.notVisibleReason||'noAdView'===l.notVisibleReason?(D(c,'notFound'),c.b=new B(Ha(),!1)):(l=c.a,'viewInvisible'===l.notVisibleReason||'viewGone'===l.notVisibleReason||'viewNotVisible'===l.notVisibleReason||'viewAlphaZero'===l.notVisibleReason||'viewHidden'===l.notVisibleReason||void 0!==c.a.notVisibleReason||za(c.a)?(D(c,'hidden'),c.b=new B(Ha(),\n!1)):(c.a.g||(D(c,'backgrounded'),D(c,'noWindowFocus')),Ja(a,f)&&D(c,'clipped'),c.b=new B(a,!1)))}else if(f=!0,b.a&&(f=-1!==b.isFriendlyObstructionFor.indexOf(d)?!1:!1===b.clipsToBounds),f){l=b.childViews;for(var g=0;g<l.length;g++)f=void 0!==c.a,Na(a,new B(l[g],f),c,d)}e||void 0===c.a||(b.a?-1!==b.isFriendlyObstructionFor.indexOf(d)?c.h.push(b):c.i.push(b):(e=wa(b),d=wa(c.b),C(c.b),!za(c.b)&&b.clipsToBounds&&(b=Ia(d,e),Ja(b,d)&&(D(c,'clipped'),c.b=new B(b,!1)))))};function Oa(a,b){this.y=this.x=0;this.width=a;this.height=b};function Pa(){return{apiVersion:'1.0',accessMode:'limited',environment:'app',omidJsInfo:{omidImplementer:'omsdk',serviceVersion:'1.3.37-iab3566'}}}function Qa(){this.adSessionId=null;this.c=Pa();this.o=null;this.m='foregrounded';this.l=this.i='none';this.j=this.g=this.f=this.h=this.a=this.b=this.B=this.u=null;this.C=!0;this.v=new Map}var G;function H(){G||(G=new Qa);return G};var I=function(){if('undefined'!==typeof omidGlobal&&omidGlobal)return omidGlobal;if('undefined'!==typeof global&&global)return global;if('undefined'!==typeof window&&window)return window;if('undefined'!==typeof globalThis&&globalThis)return globalThis;var a=Function('return this')();if(a)return a;throw Error('Could not determine global object context.');}();function Ra(a,b){this.a=a;this.b=b}t.Object.defineProperties(Ra.prototype,{event:{configurable:!0,enumerable:!0,get:function(){return this.a}},origin:{configurable:!0,enumerable:!0,get:function(){return this.b}}});function J(a){for(var b=[],c=0;c<arguments.length;++c)b[c]=arguments[c];Sa(function(){throw new (Function.prototype.bind.apply(Error,[null,'Could not complete the test successfully - '].concat(q(b))));},function(){return console.error.apply(console,q(b))})}function Ta(a){for(var b=[],c=0;c<arguments.length;++c)b[c]=arguments[c];Sa(function(){},function(){return console.error.apply(console,q(b))})}\nfunction Sa(a,b){'undefined'!==typeof jasmine&&jasmine?a():'undefined'!==typeof console&&console&&console.error&&b()};function Ua(){this.f=[];this.b=[];this.c=[];this.g=[];this.i={};this.a=H()}function Va(a){a.f=[];a.b=[];a.c=[];a.g=[];a.i={};G.adSessionId=null;G.c=Pa();G.o=null;G.G=void 0;G.K=void 0;G.H=null;G.I=null;G.D=null;G.m='foregrounded';G.i='none';G.l='none';G.u=null;G.B=null;G.b=null;G.a=null;G.h=null;G.f=null;G.g=null;G.j=null;G.C=!0;G.v=new Map}\nfunction Wa(a,b){void 0!==a.a&&a.a.adSessionId&&!1!==Xa(a,b)&&a.c.filter(function(c){return c.type===b.event.type}).forEach(function(c){return a.h(c.F,b.event)})}function Ya(a,b){a.f.push(b);Wa(a,b)}function Za(a,b,c){void 0!==a.a&&a.a.adSessionId&&a.f.filter(function(d){return d.event.type===b&&Xa(a,d)}).map(function(d){return d.event}).forEach(c)}\nfunction Xa(a,b){var c=b.event.type,d=-1!==Object.values(A).indexOf(c)&&'volumeChange'!==c;return'impression'===c||'loaded'===c&&a.a.a?b.origin===H().l:d?b.origin===H().i:!0}function $a(a,b,c){'media'===b||'video'===b?ab(a,c):(a.c.push({type:b,F:c}),Za(a,b,c))}function ab(a,b){Object.keys(A).forEach(function(c){c=A[c];a.c.push({type:c,F:b});Za(a,c,b)})}function bb(a,b,c,d){var e={O:c,L:d,F:b};a.g.push(e);a.b.forEach(function(f){var l=cb(f);'sessionStart'===f.event.type&&db(a,l,e);a.h(b,l)})}\nfunction eb(a,b,c){var d=K(a,'sessionError','native',{errorType:b,message:c});a.b.push(d);a.g.forEach(function(e){a.h(e.F,d.event)})}function fb(a,b){a.i=Object.assign(a.i,b);b=a.a.c;if(void 0!==b){b=Object.assign({},gb(a,hb(a,{context:b}),!0),{supportsLoadedEvent:!!a.a.a||'video'==a.a.b});Object.assign(b,{pageUrl:null,contentUrl:a.a.o});var c=K(a,'sessionStart','native',b);a.b.push(c);a.g.forEach(function(d){var e=d.F,f=cb(c);db(a,f,d);a.h(e,f)},a);ib(a)}}\nfunction db(a,b,c){c.O&&(b.data.verificationParameters=a.i[c.O]);c.L&&(c=a.a.v.get(c.L))&&(b.data.verificationParameters=c.verificationParameters,b.data.context.accessMode=c.accessMode,'full'===c.accessMode&&(a.a.g&&(b.data.context.videoElement=a.a.g),a.a.f&&(b.data.context.slotElement=a.a.f)))}function jb(a){var b=a.g,c=K(a,'sessionFinish','native');a.b.push(c);var d=a.a.c;d&&'native'==d.adSessionType||Va(a);b.forEach(function(e){return a.h(e.F,c.event)})}\nUa.prototype.h=function(a,b){for(var c=[],d=1;d<arguments.length;++d)c[d-1]=arguments[d];try{a.apply(null,q(c))}catch(e){Ta(e)}};function kb(a,b){var c=(c=H().D)?Fa(c):void 0;c=gb(a,hb(a,c));Ya(a,K(a,'impression',b,c))}function lb(a,b,c){if(a.a.a||'display'!=a.a.b)b=K(a,'loaded',b,gb(a,hb(a,void 0===c?null:c))),Ya(a,b)}\nfunction mb(a,b,c,d){'start'!==b&&'volumeChange'!==b||null!=(d&&d.deviceVolume)||(d.deviceVolume=a.a.u);if(d&&('start'===b||'volumeChange'===b)){var e=d.videoPlayerVolume,f=d.mediaPlayerVolume;null!=e?(Object.assign(d,{mediaPlayerVolume:e}),a.a.B=e):null!=f&&(Object.assign(d,{videoPlayerVolume:f}),a.a.B=f)}Ya(a,K(a,b,c,d))}\nfunction ib(a){var b=a.f.filter(function(f){return Object.values(A).includes(f.event.type)&&'video'==a.a.b&&f.origin===a.a.i||'loaded'==f.event.type&&'display'==a.a.b&&f.origin===a.a.l?!0:!1}).map(function(f){return f.event}),c=a.a.adSessionId||'',d={};b=p(b);for(var e=b.next();!e.done;d={w:d.w},e=b.next()){d.w=e.value;d.w.adSessionId||(d.w.adSessionId=c);if('loaded'==d.w.type){if(!a.a.a&&'display'==a.a.b)continue;d.w.data=gb(a,hb(a,d.w.data))}a.c.filter(function(f){return function(l){return l.type===\nf.w.type}}(d)).forEach(function(f){return function(l){return l.F(f.w)}}(d))}}function nb(a,b,c){a:{c=new Set(c);a=p(a.f.concat(a.b));for(var d=a.next();!d.done;d=a.next())if(d=d.value,c.has(d.event.type)&&d.origin!=b){b=!0;break a}b=!1}return b?(J('Event owner cannot be registered after its events have already been published.'),!1):!0}function ob(a,b){nb(a,b,Object.values(A))&&L(a,b)&&(a.a.i=b)}function pb(a,b){nb(a,b,['impression'])&&qb(a,b)&&(a.a.l=b)}\nfunction qb(a,b){var c=a.a.l;return'none'!=c&&c!=b?(J('Impression event is owned by '+(a.a.l+', not ')+(b+'.')),!1):!0}function L(a,b){var c=a.a.i;return'none'!=c&&c!=b?(J('Media events are owned by '+(a.a.i+', not '+b+'.')),!1):!0}function gb(a,b,c){c=void 0===c?!1:c;b=Object.assign({},b);a.a.b&&Object.assign(b,{mediaType:a.a.b});a.a.a&&(c||'definedByJavaScript'!==a.a.a)&&Object.assign(b,{creativeType:a.a.a});return b}function hb(a,b){return a.a.h?Object.assign({},b,{impressionType:a.a.h}):b}\nfunction K(a,b,c,d){return new Ra({adSessionId:a.a.adSessionId||'',timestamp:(new Date).getTime(),type:b,data:d},c)}function cb(a){a=a.event;return{adSessionId:a.adSessionId,timestamp:a.timestamp,type:a.type,data:a.data}};function rb(a,b,c){'container'===b&&void 0!==a.a.G&&void 0!==a.a&&null!=a.a.adSessionId&&(a.a.H=Ma(a.c,a.a.G,a.a.m,a.a.adSessionId,!0));b=a.a;var d=b.H,e=b.I;if(d)if(e){b=new Ea;var f=d.j,l=d.a,g=d.b,h=e.a,k=e.b;f&&l&&g&&h&&k&&(Ga(b,f),b.l=new B(l,!1),b.v=new B(g,!1),b.i=Object.assign([],d.i),b.c=Object.assign([],d.c),b.h=Object.assign([],d.h),b.o=Object.assign([],d.o),b.f=Object.assign([],e.f,d.f),d=b.l.x,e=b.l.y,h=new B(h,!1),k=new B(k,!1),xa(h,d,e),xa(k,d,e),b.a=h,b.b=Ia(k,g),Ka(b))}else b=d;else b=\nnull;g=a.a.D;if(b&&!b.J(g)||c)g=Fa(b),c&&(g.adView.reasons=g.adView.reasons||[c]),c=a.b,'audio'!=c.a.a&&Ya(c,K(c,'geometryChange','native',g)),a.a.D=b};function M(a){return'object'===typeof a}function sb(a){return'number'===typeof a&&!isNaN(a)&&0<=a}function N(a){return'string'===typeof a}function O(a,b){return N(a)&&-1!==Object.values(b).indexOf(a)}function tb(a){return!(!a||!a.tagName||'iframe'!==a.tagName.toLowerCase())};function P(a,b,c){this.f=a;this.K=b;this.G=c;this.c=H();this.b=null;this.a=this.g=this.u=void 0;this.I=!0;this.B=void 0;Q(this)}function Q(a){if(!a.b){var b;a:{if((b=a.f.document)&&b.getElementsByClassName&&(b=b.getElementsByClassName('omid-element'))){if(1==b.length){b=b[0];break a}1<b.length&&a.I&&(eb(a.G,'generic',\"More than one element with 'omid-element' class name.\"),a.I=!1)}b=null}if(b&&b.tagName&&'video'===b.tagName.toLowerCase())a.c.g=b;else if(b&&b.tagName)a.c.f=b;else return;ub(a)}}\nfunction ub(a){a.c.g?(a.b=a.c.g,a.i()):a.c.f&&(a.b=a.c.f,tb(a.b)?a.c.j&&a.i():a.i())}function vb(a){a.a&&(tb(a.b)?a.c.j&&(a.D(),wb(a)):(a.D(),wb(a)))}P.prototype.m=function(){this.B&&(this.f.document.removeEventListener('visibilitychange',this.B),this.B=void 0)};P.prototype.i=function(){};function wb(a){a.u&&(a.c.I=a.u,rb(a.K,'creative'))}function xb(a){if(a.a&&a.c.j){var b=new B(a.c.j,!1);xa(b,a.a.x,a.a.y);b.clipsToBounds=!0;return b}};function yb(a,b,c){return zb(a,'setInterval')(b,c)}function Ab(a,b){zb(a,'clearInterval')(b)}function Bb(a,b){zb(a,'clearTimeout')(b)}function zb(a,b){return a.a&&a.a[b]?a.a[b]:Cb(a,b)}\nfunction Db(a,b,c,d){if(a.a.document&&a.a.document.body){var e=a.a.document.createElement('img');e.width=1;e.height=1;e.style.display='none';e.src=b;c&&e.addEventListener('load',function(){return c()});d&&e.addEventListener('error',function(){return d()});a.a.document.body.appendChild(e)}else Cb(a,'sendUrl')(b,c,d)}function Cb(a,b){if(a.a&&a.a.omidNative&&a.a.omidNative[b])return a.a.omidNative[b].bind(a.a.omidNative);throw Error('Native interface method \"'+b+'\" not found.');};function R(a,b,c,d,e){P.call(this,a,c,e);this.l=b;this.h=void 0;this.j=d}r(R,P);R.prototype.m=function(){void 0!==this.h&&(Ab(this.j,this.h),this.h=void 0);P.prototype.m.call(this)};R.prototype.i=function(){var a=this;P.prototype.i.call(this);null==this.b?this.h=void 0:void 0===this.h&&(this.h=yb(this.j,function(){return Eb(a)},200),Eb(this))};\nR.prototype.D=function(){if(this.g){var a=xb(this);if(a){this.a.isCreative=!1;a.isCreative=!0;for(var b=!1,c=0;c<this.a.childViews.length;c++)if(this.a.childViews[c].isCreative){this.a.childViews[c]=a;b=!0;break}b||this.a.childViews.push(a)}else this.a.isCreative=!0;this.u=Ma(this.l,this.g,this.c.m,this.c.adSessionId,this.C())}};R.prototype.C=function(){return!0};\nfunction Eb(a){if(void 0!==a.h){b:{try{var b=a.f.top;var c=0<=b.innerHeight&&0<=b.innerWidth;break b}catch(d){}c=!1}c?(c=a.f.top,c=new B(new Oa(c.innerWidth,c.innerHeight),!1)):c=new B(new Oa(0,0),!1);b=a.b.getBoundingClientRect();if(null==b.x||isNaN(b.x))b.x=b.left;if(null==b.y||isNaN(b.y))b.y=b.top;b=new B(b,!1);c.J(a.g)&&b.J(a.a)||(a.a=b,a.a.clipsToBounds=!0,a.g=c,a.g.childViews.push(a.a),vb(a))}};function S(a,b,c,d){P.call(this,a,c,d);this.o=this.j=this.l=this.h=void 0;this.H=!1;this.v=void 0}r(S,P);S.prototype.m=function(){this.h&&this.h.disconnect();Fb(this);P.prototype.m.call(this)};S.prototype.i=function(){P.prototype.i.call(this);this.b&&(this.h||(this.h=Gb(this)),Hb(this),Ib(this.b)&&Jb(this))};\nS.prototype.D=function(){if(this.a&&this.v){var a=xb(this);if(a){var b=a;var c=this.v;var d=Math.max(a.x,c.x);var e=Math.max(a.y,c.y),f=Math.min(a.endX,c.endX);a=Math.min(a.endY,c.endY);f<=d||a<=e?d=null:(c={},d=new B((c.x=d,c.y=e,c.width=Math.abs(f-d),c.height=Math.abs(a-e),c),!1));d||(d=new B({x:0,y:0,width:0,height:0},!1))}else b=this.a,d=this.v;e=new Ea;this.g&&Ga(e,this.g);e.a=b;e.b=d;Ka(e);this.H?za(e.a)?D(e,'hidden'):100===e.m||D(e,'clipped'):D(e,'viewport');this.u=e}};S.prototype.C=function(){return!0};\nfunction Fb(a){a.l&&(a.l.disconnect(),a.l=void 0);a.j&&(a.j.disconnect(),a.j=void 0);a.o&&((0,a.f.removeEventListener)('resize',a.o),a.o=void 0)}function Hb(a){a.h&&a.b&&(a.h.unobserve(a.b),a.h.observe(a.b))}function Ib(a){a=a.getBoundingClientRect();return 0==a.width||0==a.height}\nfunction Gb(a){return new a.f.IntersectionObserver(function(b){try{if(b.length){for(var c,d=b[0],e=1;e<b.length;e++)b[e].time>d.time&&(d=b[e]);c=d;a.g=Kb(c.rootBounds);a.a=Kb(c.boundingClientRect);a.v=Kb(c.intersectionRect);a.H=!!c.isIntersecting;vb(a)}}catch(f){a.m(),eb(a.G,'generic','Problem handling IntersectionObserver callback: '+f.message)}},{root:null,rootMargin:'0px',threshold:[0,.1,.2,.3,.4,.5,.6,.7,.8,.9,1]})}\nfunction Jb(a){a.f.ResizeObserver?a.l||(a.l=Lb(a,function(){return Mb(a)}),a.l.observe(a.b)):(a.o||(a.o=function(){return Mb(a)},(0,a.f.addEventListener)('resize',a.o)),a.j||(a.j=new MutationObserver(function(){return Mb(a)}),a.j.observe(a.b,{childList:!1,attributes:!0,subtree:!1})))}function Mb(a){a.b&&!Ib(a.b)&&(Hb(a),Fb(a))}function Lb(a,b){return new a.f.ResizeObserver(b)}function Kb(a){if(a&&null!==a.x&&null!==a.y&&null!==a.width&&null!==a.height)return new B(a,!1)};function Nb(a){return a&&M(a)?Object.entries(a).reduce(function(b,c){var d=p(c);c=d.next().value;d=d.next().value;return b&&N(c)&&null!=d&&M(d)&&N(d.resourceUrl)},!0):!1};function T(a,b,c,d){this.b=a;this.method=b;this.version=c;this.a=d}function Pb(a){return!!a&&void 0!==a.omid_message_guid&&void 0!==a.omid_message_method&&void 0!==a.omid_message_version&&'string'===typeof a.omid_message_guid&&'string'===typeof a.omid_message_method&&'string'===typeof a.omid_message_version&&(void 0===a.omid_message_args||void 0!==a.omid_message_args)}function Qb(a){return new T(a.omid_message_guid,a.omid_message_method,a.omid_message_version,a.omid_message_args)}\nfunction Rb(a){var b={};b=(b.omid_message_guid=a.b,b.omid_message_method=a.method,b.omid_message_version=a.version,b);void 0!==a.a&&(b.omid_message_args=a.a);return b};function Sb(a){this.c=a};function U(a){this.c=a;this.handleExportedMessage=U.prototype.f.bind(this)}r(U,Sb);U.prototype.b=function(a,b){b=void 0===b?this.c:b;if(!b)throw Error('Message destination must be defined at construction time or when sending the message.');b.handleExportedMessage(Rb(a),this)};U.prototype.f=function(a,b){Pb(a)&&this.a&&this.a(Qb(a),b)};function Tb(a){return Ub(a,'SessionService.')}function Ub(a,b){return(a=a.match(new RegExp('^'+b+'(.*)')))&&a[1]};function Vb(a,b){this.c=b=void 0===b?I:b;var c=this;a.addEventListener('message',function(d){if('object'===typeof d.data){var e=d.data;Pb(e)&&d.source&&c.a&&c.a(Qb(e),d.source)}})}r(Vb,Sb);Vb.prototype.b=function(a,b){b=void 0===b?this.c:b;if(!b)throw Error('Message destination must be defined at construction time or when sending the message.');b.postMessage(Rb(a),'*')};function Wb(){return'xxxxxxxx-xxxx-4xxx-yxxx-xxxxxxxxxxxx'.replace(/[xy]/g,function(a){var b=16*Math.random()|0;return'y'===a?(b&3|8).toString(16):b.toString(16)})};function Xb(a){if(!a.a||!a.a.document)throw Error('OMID Service Script is not running within a window.');var b=a.b;a.b=[];b.forEach(function(c){try{var d=a.c.C?'limited':'full',e=O(c.accessMode,sa)?c.accessMode:null;var f=e?'full'==e&&'limited'==d?d:'domain'==e?'limited':e:d;c.accessMode=f;a:{var l=c.resourceUrl,g=a.a.location.origin;try{var h=new URL(l,g);break a}catch(V){}try{h=new URL(l);break a}catch(V){}h=null}if(d=h){var k=Wb(),m=a.a.document,u=m.createElement('iframe');u.id='omid-verification-script-frame-'+\nk;u.style.display='none';['full','limited'].includes(f)?u.srcdoc=\"<html><head>\\n<script type=\\\"text/javascript\\\">window['omidVerificationProperties'] = {\\n'serviceWindow': window.parent,\\n'injectionSource': 'app',\\n'injectionId': '\"+(k+'\\',\\n};\\x3c/script>\\n<script type=\"text/javascript\" src=\"')+d.href+'\">\\x3c/script>\\n</head><body></body></html>':'domain'==f&&(u.src=Yb(a,k,d).href);['domain','limited'].includes(f)&&(u.sandbox='allow-scripts');m.body.appendChild(u);var w=c.vendorKey,E=c.verificationParameters;\nw=void 0===w?'':w;E=void 0===E?'':E;w&&'string'===typeof w&&''!==w&&E&&'string'===typeof E&&''!==E&&(a.f.i[w]=E);a.c.v.set(k,c)}}catch(V){Ta('OMID verification script '+c.resourceUrl+' failed to load: '+V)}})}\nfunction Yb(a,b,c){var d='/.well-known/omid/omloader-v1.html#';(new Map([['verificationScriptUrl',c.href],['injectionId',b]])).forEach(function(e,f){d+=encodeURIComponent(f)+'='+encodeURIComponent(e)+'&'});b=null;try{b=new URL(d,a.a.parent.location.origin)}catch(e){throw Error('OMID Service Script cannot access the parent window.');}return b};function Zb(){var a=$b,b=ac,c=this;this.c=X;this.b=a;this.a=H();this.g=b;this.f=!1;this.registerSessionObserver(function(d){return bc(c,d)})}n=Zb.prototype;n.registerSessionObserver=function(a){bb(this.c,a)};n.setSlotElement=function(a){a&&a.tagName?(this.a.f=a,this.b&&ub(this.b)):J('setSlotElement called with a non-HTMLElement.  It will be ignored.')};n.setElementBounds=function(a){this.a.j=a;this.b&&ub(this.b);this.b&&vb(this.b)};n.error=function(a,b){eb(this.c,a,b)};\nn.registerAdEvents=function(){pb(this.c,'javascript')};n.registerMediaEvents=function(){ob(this.c,'javascript')};function Y(a,b,c){'impression'==b?qb(a.c,'javascript')&&(kb(a.c,'javascript'),a.b&&Q(a.b)):('loaded'==b?(c=void 0===c?null:c,L(a.c,'javascript')&&lb(a.c,'javascript',c)):L(a.c,'javascript')&&mb(a.c,b,'javascript',c),['loaded','start'].includes(b)&&a.b&&Q(a.b))}n.injectVerificationScriptResources=function(a){var b=this.g;b.b.push.apply(b.b,q(a));if(this.f)try{Xb(this.g)}catch(c){J(c.message)}};\nn.setCreativeType=function(a,b){b=void 0===b?null:b;if(!this.a.b||this.a.a)this.a.a=a,'video'==a||'audio'==a?this.a.b='video':'htmlDisplay'==a||'nativeDisplay'==a?this.a.b='display':'definedByJavaScript'==a&&b&&(this.a.b='none'==b?'display':'video')};n.setImpressionType=function(a){if(!this.a.b||this.a.a)this.a.h=a};\nfunction bc(a,b){if('sessionStart'===b.type){a.f=!0;try{Xb(a.g)}catch(c){J(c.message)}}'sessionFinish'===b.type&&(a.f=!1,(b=H().c)&&'native'==b.adSessionType||a.registerSessionObserver(function(c){return bc(a,c)}))}n.setClientInfo=function(a,b,c){var d=this.a.c||{};d.omidJsInfo=Object.assign({},d.omidJsInfo,{sessionClientVersion:a,partnerName:b,partnerVersion:c});this.a.c=d;return this.a.c.omidJsInfo.serviceVersion};function cc(a){return/\\d+\\.\\d+\\.\\d+(-.*)?/.test(a)}function dc(a){a=a.split('-')[0].split('.');for(var b=['1','0','3'],c=0;3>c;c++){var d=parseInt(a[c],10),e=parseInt(b[c],10);if(d>e)break;else if(d<e)return!1}return!0};function ec(a,b){return cc(a)&&dc(a)?b?b:[]:b&&'string'===typeof b?JSON.parse(b):[]};var fc=new function(){};function gc(){var a=hc;var b=void 0===b?omidGlobal:b;this.a=a;this.g=b;this.b=new U;this.g.omid=this.g.omid||{};this.g.omid.v1_SessionServiceCommunication=this.b;this.f=b&&b.addEventListener&&b.postMessage?new Vb(b):null;this.c=null;this.b.a=this.h.bind(this);this.f&&(this.f.a=this.i.bind(this))}gc.prototype.h=function(a,b){null!=Tb(a.method)&&ic(this,fc)&&jc(this,a,b,this.b)};gc.prototype.i=function(a,b){null!=Tb(a.method)&&ic(this,b)&&jc(this,a,b,this.f)};\nfunction ic(a,b){a.c||(a.c=b);return a.c!=b?(J('The source of session client messages cannot be changed from the source of the first message.'),!1):!0}\nfunction jc(a,b,c,d){function e(h){for(var k=[],m=0;m<arguments.length;++m)k[m]=arguments[m];k=new T(f,'response',g,cc(g)&&dc(g)?k:JSON.stringify(k));d.b(k,c)}var f=b.b,l=b.method,g=b.version;b=ec(g,b.a);try{kc(a,l,e,b)}catch(h){d.b(new T(f,'error',g,'\\n        name: '+h.name+'\\n        message: '+h.message+'\\n        filename: '+h.filename+'\\n        lineNumber: '+h.lineNumber+'\\n        columnNumber: '+h.columnNumber+'\\n        stack: '+h.stack+'\\n        toString(): '+h.toString()),c)}}\nfunction kc(a,b,c,d){if(null!=Tb(b))switch(Tb(b)){case 'registerAdEvents':a.a.registerAdEvents();break;case 'registerMediaEvents':a.a.registerMediaEvents();break;case 'registerSessionObserver':a.a.registerSessionObserver(c);break;case 'setSlotElement':c=p(d).next().value;a.a.setSlotElement(c);break;case 'setVideoElement':c=p(d).next().value;a=a.a;c&&c.tagName&&'video'===c.tagName.toLowerCase()?(a.a.g=c,a.b&&ub(a.b)):J('setVideoElement called with a non-HTMLVideoElement. It will be ignored.');break;\ncase 'setElementBounds':c=p(d).next().value;a.a.setElementBounds(c);break;case 'startSession':J('Session start from JS is not supported in mobile app.');break;case 'finishSession':J('Session finish from JS is not supported in mobile app.');break;case 'impressionOccurred':Y(a.a,'impression');break;case 'loaded':(c=p(d).next().value)?(b={skippable:c.isSkippable,autoPlay:c.isAutoPlay,position:c.position},c.isSkippable&&(b.skipOffset=c.skipOffset),Y(a.a,'loaded',b)):Y(a.a,'loaded');break;case 'start':b=\np(d);c=b.next().value;b=b.next().value;Y(a.a,'start',{duration:c,mediaPlayerVolume:b});break;case 'firstQuartile':Y(a.a,'firstQuartile');break;case 'midpoint':Y(a.a,'midpoint');break;case 'thirdQuartile':Y(a.a,'thirdQuartile');break;case 'complete':Y(a.a,'complete');break;case 'pause':Y(a.a,'pause');break;case 'resume':Y(a.a,'resume');break;case 'bufferStart':Y(a.a,'bufferStart');break;case 'bufferFinish':Y(a.a,'bufferFinish');break;case 'skipped':Y(a.a,'skipped');break;case 'volumeChange':c={mediaPlayerVolume:p(d).next().value};\nY(a.a,'volumeChange',c);break;case 'playerStateChange':c={state:p(d).next().value};Y(a.a,'playerStateChange',c);break;case 'adUserInteraction':c={interactionType:p(d).next().value};Y(a.a,'adUserInteraction',c);break;case 'setClientInfo':var e=p(d);b=e.next().value;d=e.next().value;e=e.next().value;a=a.a.setClientInfo(b,d,e);c(a);break;case 'injectVerificationScriptResources':c=p(d).next().value;a.a.injectVerificationScriptResources(c);break;case 'setCreativeType':c=p(d).next().value;a.a.setCreativeType(c);\nbreak;case 'setImpressionType':c=p(d).next().value;a.a.setImpressionType(c);break;case 'setContentUrl':c=p(d).next().value;a.a.a.o=c;break;case 'sessionError':b=p(d),c=b.next().value,b=b.next().value,a.a.error(c,b)}};function Z(){var a=X,b=lc,c=mc,d=$b;this.f=hc;this.a=a;this.c=b;this.h=c;this.g=d;this.b=H()}n=Z.prototype;\nn.T=function(a){if(!(!(a&&M(a)&&O(a.impressionOwner,qa))||'videoEventsOwner'in a&&null!=a.videoEventsOwner&&!O(a.videoEventsOwner,qa)||'mediaEventsOwner'in a&&null!=a.mediaEventsOwner&&!O(a.mediaEventsOwner,qa))){if(a.creativeType&&a.impressionType){var b=a.mediaEventsOwner;null==this.b.a&&this.f.setCreativeType(a.creativeType,b);null==this.b.h&&(this.b.h=a.impressionType);ob(this.a,b)}else b=a.videoEventsOwner,this.b.b=null==b||'none'===b?'display':'video',this.b.a=null,this.b.h=null,ob(this.a,b);\npb(this.a,a.impressionOwner);a&&null!=a.isolateVerificationScripts&&'boolean'===typeof a.isolateVerificationScripts&&(this.b.C=a.isolateVerificationScripts)}};\nn.W=function(a,b,c,d){var e;if(M(b)){if(e=O(b.environment,ua)&&O(b.adSessionType,pa))e=b.omidNativeInfo,e=M(e)?N(e.partnerName)&&N(e.partnerVersion):!1;e&&(e=b.app,e=M(e)?N(e.libraryVersion)&&N(e.appId):!1)}else e=!1;e&&(Nb(d)&&(this.b.v=new Map(Object.entries(d))),d=this.f,c=void 0===c?null:c,null==a&&(a=Wb()),b.canMeasureVisibility=d.b.C(),d.a.adSessionId=a,a=d.a,e=b,void 0!==e.contentUrl&&(a.o=e.contentUrl,e.contentUrl=void 0),e=a.c||{},b.omidJsInfo=Object.assign({},e.omidJsInfo||{},b.omidJsInfo||\n{}),e=b=Object.assign({},e,b),a.C||(null!=a.g?(e.videoElement=a.g,e.accessMode='full'):null!=a.f&&(e.slotElement=a.f,e.accessMode='full')),a.c=b,fb(d.c,c),d.b&&Q(d.b))};n.U=function(){var a=this.f;jb(a.c);a.b.m()};n.$=function(a){M(a)&&sb(a.x)&&sb(a.y)&&sb(a.width)&&sb(a.height)&&(this.b.G=a,rb(this.c,'container'))};n.aa=function(a){O(a,ta)&&(this.b.m=a,'backgrounded'===a?rb(this.c,'container','backgrounded'):rb(this.c,'container'))};n.X=function(a){'impression'===a&&(this.M(),this.g&&Q(this.g))};\nn.M=function(){qb(this.a,'native')&&kb(this.a,'native')};n.V=function(a){a=void 0===a?null:a;L(this.a,'native')&&lb(this.a,'native',a)};n.error=function(a,b){O(a,oa)&&eb(this.a,a,b)};n.Y=function(a,b){this.N(a,b)};n.N=function(a,b){L(this.a,'native')&&O(a,A)&&(void 0===b||M(b))&&('loaded'==a?lb(this.a,'native',b):mb(this.a,a,'native',b))};\nn.Z=function(a){if('none'!==this.a.a.i&&'number'===typeof a&&!isNaN(a)){this.b.u=a;a=this.h;var b=a.a.B;null!=b&&mb(a.b,'volumeChange','native',{mediaPlayerVolume:b,deviceVolume:a.a.u})}};Z.prototype.startSession=Z.prototype.W;Z.prototype.error=Z.prototype.error;Z.prototype.finishSession=Z.prototype.U;Z.prototype.publishAdEvent=Z.prototype.X;Z.prototype.publishImpressionEvent=Z.prototype.M;Z.prototype.publishVideoEvent=Z.prototype.Y;Z.prototype.publishMediaEvent=Z.prototype.N;\nZ.prototype.publishLoadedEvent=Z.prototype.V;Z.prototype.setNativeViewHierarchy=Z.prototype.$;Z.prototype.setState=Z.prototype.aa;Z.prototype.setDeviceVolume=Z.prototype.Z;Z.prototype.init=Z.prototype.T;function nc(){var a=X,b=oc;var c=void 0===c?I:c;this.g=a;this.a=b;this.h={};this.f={};this.c=new U;c.omid=c.omid||{};c.omid.v1_VerificationServiceCommunication=this.c;this.b=null;c&&c.addEventListener&&c.postMessage&&(this.b=new Vb(c));this.c.a=this.i.bind(this);this.b&&(this.b.a=this.j.bind(this))}function pc(a,b,c,d){Db(a.a,b,c,d)}function qc(a,b,c,d){Cb(a.a,'downloadJavaScriptResource')(b,c,d)}nc.prototype.j=function(a,b){this.b&&rc(this,a,b,this.b)};nc.prototype.i=function(a,b){rc(this,a,b,this.c)};\nfunction rc(a,b,c,d){function e(F){for(var W=[],ra=0;ra<arguments.length;++ra)W[ra]=arguments[ra];W=new T(f,'response',g,cc(g)&&dc(g)?W:JSON.stringify(W));d.b(W,c)}var f=b.b,l=b.method,g=b.version;b=ec(g,b.a);if(null!=Ub(l,'VerificationService.')){l=Ub(l,'VerificationService.');try{switch(l){case 'addEventListener':var h=p(b).next().value;$a(a.g,h,e);break;case 'addSessionListener':var k=p(b),m=k.next().value,u=k.next().value;bb(a.g,e,m,u);break;case 'sendUrl':var w=p(b).next().value;pc(a,w,function(){return e(!0)},\nfunction(){return e(!1)});break;case 'setTimeout':var E=p(b),V=E.next().value,wc=E.next().value;a.h[V]=zb(a.a,'setTimeout')(e,wc);break;case 'clearTimeout':var xc=p(b).next().value;Bb(a.a,a.h[xc]);break;case 'setInterval':var Ob=p(b),yc=Ob.next().value,zc=Ob.next().value;a.f[yc]=yb(a.a,e,zc);break;case 'clearInterval':var Ac=p(b).next().value;Ab(a.a,a.f[Ac]);break;case 'injectJavaScriptResource':var Bc=p(b).next().value;qc(a,Bc,function(F){return e(!0,F)},function(){return e(!1)});break;case 'getVersion':p(b).next();\nvar Cc=H().c.omidJsInfo;e(Cc.serviceVersion)}}catch(F){d.b(new T(f,'error',g,'\\n              name: '+F.name+'\\n              message: '+F.message+'\\n              filename: '+F.filename+'\\n              lineNumber: '+F.lineNumber+'\\n              columnNumber: '+F.columnNumber+'\\n              stack: '+F.stack+'\\n              toString(): '+F.toString()+'\\n          '),c)}}};function sc(){var a=I.document.createElement('iframe');a.id='omid_v1_present';a.name='omid_v1_present';a.style.display='none';I.document.body.appendChild(a)}function tc(){var a=new MutationObserver(function(b){b.forEach(function(c){'BODY'===c.addedNodes[0].nodeName&&(sc(),a.disconnect())})});a.observe(I.document.documentElement,{childList:!0})};var X=new Ua,oc=new function(){var a;this.a=a=void 0===a?omidGlobal:a};new nc;var uc=new function(){},vc=new function(){},lc=new function(){this.b=X;this.c=vc;this.a=H()},Dc;I?Dc=I.IntersectionObserver&&(I.MutationObserver||I.ResizeObserver)?new S(I,uc,lc,X):new R(I,vc,lc,oc,X):Dc=null;var $b=Dc,ac=new function(){var a=X;var b=void 0===b?I:b;this.f=a;this.a=b;this.c=H();this.b=[]},hc=new Zb,mc=new function(){var a=X,b=H();this.b=a;this.a=b};I.omidBridge=new Z;new gc;\nif(I.frames&&I.document&&!('omid_v1_present'in I.frames)){var Ec;if(Ec=null==I.document.body)Ec='MutationObserver'in I;Ec?tc():I.document.body?sc():I.document.write('<iframe style=\"display:none\" id=\"omid_v1_present\" name=\"omid_v1_present\"></iframe>')};\n}).call(this, this);";
                                                        } else {
                                                            strA = new A9(contextD2, "omid_js_store").a("omid_js_string");
                                                            if (strA == null) {
                                                                strA = null;
                                                            }
                                                            if (strA == null) {
                                                                strA = ";(function(omidGlobal) {\n  'use strict';var n;function aa(a){var b=0;return function(){return b<a.length?{done:!1,value:a[b++]}:{done:!0}}}function p(a){var b='undefined'!=typeof Symbol&&Symbol.iterator&&a[Symbol.iterator];return b?b.call(a):{next:aa(a)}}function q(a){if(!(a instanceof Array)){a=p(a);for(var b,c=[];!(b=a.next()).done;)c.push(b.value);a=c}return a}var ba='function'==typeof Object.create?Object.create:function(a){function b(){}b.prototype=a;return new b},ca;\nif('function'==typeof Object.setPrototypeOf)ca=Object.setPrototypeOf;else{var da;a:{var ea={S:!0},fa={};try{fa.__proto__=ea;da=fa.S;break a}catch(a){}da=!1}ca=da?function(a,b){a.__proto__=b;if(a.__proto__!==b)throw new TypeError(a+' is not extensible');return a}:null}var ha=ca;\nfunction r(a,b){a.prototype=ba(b.prototype);a.prototype.constructor=a;if(ha)ha(a,b);else for(var c in b)if('prototype'!=c)if(Object.defineProperties){var d=Object.getOwnPropertyDescriptor(b,c);d&&Object.defineProperty(a,c,d)}else a[c]=b[c]}function ia(a){a=['object'==typeof window&&window,'object'==typeof self&&self,'object'==typeof global&&global,a];for(var b=0;b<a.length;++b){var c=a[b];if(c&&c.Math==Math)return c}return globalThis}\nvar t=ia(this),v='function'==typeof Object.defineProperties?Object.defineProperty:function(a,b,c){a!=Array.prototype&&a!=Object.prototype&&(a[b]=c.value)};function x(a,b){if(b){var c=t;a=a.split('.');for(var d=0;d<a.length-1;d++){var e=a[d];e in c||(c[e]={});c=c[e]}a=a[a.length-1];d=c[a];b=b(d);b!=d&&null!=b&&v(c,a,{configurable:!0,writable:!0,value:b})}}x('globalThis',function(a){return a||t});function y(a,b){return Object.prototype.hasOwnProperty.call(a,b)}\nvar ja='function'==typeof Object.assign?Object.assign:function(a,b){for(var c=1;c<arguments.length;c++){var d=arguments[c];if(d)for(var e in d)y(d,e)&&(a[e]=d[e])}return a};x('Object.assign',function(a){return a||ja});function ka(){ka=function(){};t.Symbol||(t.Symbol=la)}function ma(a,b){this.a=a;v(this,'description',{configurable:!0,writable:!0,value:b})}ma.prototype.toString=function(){return this.a};\nvar la=function(){function a(c){if(this instanceof a)throw new TypeError('Symbol is not a constructor');return new ma('jscomp_symbol_'+(c||'')+'_'+b++,c)}var b=0;return a}();function z(){ka();var a=t.Symbol.iterator;a||(a=t.Symbol.iterator=t.Symbol('Symbol.iterator'));'function'!=typeof Array.prototype[a]&&v(Array.prototype,a,{configurable:!0,writable:!0,value:function(){return na(aa(this))}});z=function(){}}function na(a){z();a={next:a};a[t.Symbol.iterator]=function(){return this};return a}\nx('WeakMap',function(a){function b(h){this.a=(g+=Math.random()+1).toString();if(h){h=p(h);for(var k;!(k=h.next()).done;)k=k.value,this.set(k[0],k[1])}}function c(){}function d(h){var k=typeof h;return'object'===k&&null!==h||'function'===k}function e(h){if(!y(h,l)){var k=new c;v(h,l,{value:k})}}function f(h){var k=Object[h];k&&(Object[h]=function(m){if(m instanceof c)return m;e(m);return k(m)})}if(function(){if(!a||!Object.seal)return!1;try{var h=Object.seal({}),k=Object.seal({}),m=new a([[h,2],[k,\n3]]);if(2!=m.get(h)||3!=m.get(k))return!1;m.delete(h);m.set(k,4);return!m.has(h)&&4==m.get(k)}catch(u){return!1}}())return a;var l='$jscomp_hidden_'+Math.random();f('freeze');f('preventExtensions');f('seal');var g=0;b.prototype.set=function(h,k){if(!d(h))throw Error('Invalid WeakMap key');e(h);if(!y(h,l))throw Error('WeakMap key fail: '+h);h[l][this.a]=k;return this};b.prototype.get=function(h){return d(h)&&y(h,l)?h[l][this.a]:void 0};b.prototype.has=function(h){return d(h)&&y(h,l)&&y(h[l],this.a)};\nb.prototype.delete=function(h){return d(h)&&y(h,l)&&y(h[l],this.a)?delete h[l][this.a]:!1};return b});\nx('Map',function(a){function b(){var g={};return g.A=g.next=g.head=g}function c(g,h){var k=g.a;return na(function(){if(k){for(;k.head!=g.a;)k=k.A;for(;k.next!=k.head;)return k=k.next,{done:!1,value:h(k)};k=null}return{done:!0,value:void 0}})}function d(g,h){var k=h&&typeof h;'object'==k||'function'==k?f.has(h)?k=f.get(h):(k=''+ ++l,f.set(h,k)):k='p_'+h;var m=g.b[k];if(m&&y(g.b,k))for(g=0;g<m.length;g++){var u=m[g];if(h!==h&&u.key!==u.key||h===u.key)return{id:k,list:m,index:g,s:u}}return{id:k,list:m,\nindex:-1,s:void 0}}function e(g){this.b={};this.a=b();this.size=0;if(g){g=p(g);for(var h;!(h=g.next()).done;)h=h.value,this.set(h[0],h[1])}}if(function(){if(!a||'function'!=typeof a||!a.prototype.entries||'function'!=typeof Object.seal)return!1;try{var g=Object.seal({x:4}),h=new a(p([[g,'s']]));if('s'!=h.get(g)||1!=h.size||h.get({x:4})||h.set({x:4},'t')!=h||2!=h.size)return!1;var k=h.entries(),m=k.next();if(m.done||m.value[0]!=g||'s'!=m.value[1])return!1;m=k.next();return m.done||4!=m.value[0].x||\n't'!=m.value[1]||!k.next().done?!1:!0}catch(u){return!1}}())return a;z();var f=new WeakMap;e.prototype.set=function(g,h){g=0===g?0:g;var k=d(this,g);k.list||(k.list=this.b[k.id]=[]);k.s?k.s.value=h:(k.s={next:this.a,A:this.a.A,head:this.a,key:g,value:h},k.list.push(k.s),this.a.A.next=k.s,this.a.A=k.s,this.size++);return this};e.prototype.delete=function(g){g=d(this,g);return g.s&&g.list?(g.list.splice(g.index,1),g.list.length||delete this.b[g.id],g.s.A.next=g.s.next,g.s.next.A=g.s.A,g.s.head=null,\nthis.size--,!0):!1};e.prototype.clear=function(){this.b={};this.a=this.a.A=b();this.size=0};e.prototype.has=function(g){return!!d(this,g).s};e.prototype.get=function(g){return(g=d(this,g).s)&&g.value};e.prototype.entries=function(){return c(this,function(g){return[g.key,g.value]})};e.prototype.keys=function(){return c(this,function(g){return g.key})};e.prototype.values=function(){return c(this,function(g){return g.value})};e.prototype.forEach=function(g,h){for(var k=this.entries(),m;!(m=k.next()).done;)m=\nm.value,g.call(h,m[1],m[0],this)};e.prototype[Symbol.iterator]=e.prototype.entries;var l=0;return e});x('Object.values',function(a){return a?a:function(b){var c=[],d;for(d in b)y(b,d)&&c.push(b[d]);return c}});\nx('Set',function(a){function b(c){this.a=new Map;if(c){c=p(c);for(var d;!(d=c.next()).done;)this.add(d.value)}this.size=this.a.size}if(function(){if(!a||'function'!=typeof a||!a.prototype.entries||'function'!=typeof Object.seal)return!1;try{var c=Object.seal({x:4}),d=new a(p([c]));if(!d.has(c)||1!=d.size||d.add(c)!=d||1!=d.size||d.add({x:4})!=d||2!=d.size)return!1;var e=d.entries(),f=e.next();if(f.done||f.value[0]!=c||f.value[1]!=c)return!1;f=e.next();return f.done||f.value[0]==c||4!=f.value[0].x||\nf.value[1]!=f.value[0]?!1:e.next().done}catch(l){return!1}}())return a;z();b.prototype.add=function(c){c=0===c?0:c;this.a.set(c,c);this.size=this.a.size;return this};b.prototype.delete=function(c){c=this.a.delete(c);this.size=this.a.size;return c};b.prototype.clear=function(){this.a.clear();this.size=0};b.prototype.has=function(c){return this.a.has(c)};b.prototype.entries=function(){return this.a.entries()};b.prototype.values=function(){return this.a.values()};b.prototype.keys=b.prototype.values;\nb.prototype[Symbol.iterator]=b.prototype.values;b.prototype.forEach=function(c,d){var e=this;this.a.forEach(function(f){return c.call(d,f,f,e)})};return b});x('Object.is',function(a){return a?a:function(b,c){return b===c?0!==b||1/b===1/c:b!==b&&c!==c}});x('Array.prototype.includes',function(a){return a?a:function(b,c){var d=this;d instanceof String&&(d=String(d));var e=d.length;c=c||0;for(0>c&&(c=Math.max(c+e,0));c<e;c++){var f=d[c];if(f===b||Object.is(f,b))return!0}return!1}});\nx('Object.entries',function(a){return a?a:function(b){var c=[],d;for(d in b)y(b,d)&&c.push([d,b[d]]);return c}});\nvar A={qa:'loaded',xa:'start',ka:'firstQuartile',sa:'midpoint',ya:'thirdQuartile',ia:'complete',ta:'pause',va:'resume',ha:'bufferStart',ga:'bufferFinish',wa:'skipped',Aa:'volumeChange',ua:'playerStateChange',da:'adUserInteraction'},oa={na:'generic',za:'video',ra:'media'},pa={R:'native',oa:'html',P:'javascript'},qa={R:'native',P:'javascript',NONE:'none'},sa={ma:'full',ja:'domain',pa:'limited'},ta={fa:'backgrounded',la:'foregrounded'},ua={ea:'app',Ba:'web'};function B(a,b){this.x=null!=a.x?a.x:a.left;this.y=null!=a.y?a.y:a.top;this.width=a.width;this.height=a.height;this.endX=this.x+this.width;this.endY=this.y+this.height;this.adSessionId=a.adSessionId||void 0;this.isFriendlyObstructionFor=a.isFriendlyObstructionFor||[];this.b=a.friendlyObstructionClass||void 0;this.c=a.friendlyObstructionPurpose||void 0;this.f=a.friendlyObstructionReason||void 0;this.clipsToBounds=void 0!==a.clipsToBounds?!0===a.clipsToBounds:!0;this.g=void 0!==a.hasWindowFocus?!0===\na.hasWindowFocus:!0;this.notVisibleReason=a.notVisibleReason||void 0;this.childViews=a.childViews||[];this.isCreative=a.isCreative||!1;this.a=b}function va(a){var b={};return b.width=a.width,b.height=a.height,b}function C(a){var b={};return Object.assign({},va(a),(b.x=a.x,b.y=a.y,b))}function wa(a){var b=C(a),c={};return Object.assign({},b,(c.endX=a.endX,c.endY=a.endY,c))}function xa(a,b,c){a.x+=b;a.y+=c;a.endX+=b;a.endY+=c}\nB.prototype.J=function(a){if(null==a)return!1;a=C(a);var b=a.y,c=a.width,d=a.height;return this.x===a.x&&this.y===b&&this.width===c&&this.height===d};function ya(a){return a.width*a.height}function za(a){return 0===a.width||0===a.height};function Aa(a,b){var c=0;if(0<b.length){var d=Ba(a,b);a=d.ba;d=d.ca;for(var e=0;e<a.length-1;e++)for(var f=(a[e]+(a[e]+1))/2,l=a[e+1]-a[e],g=0;g<d.length-1;g++){for(var h=(d[g]+(d[g]+1))/2,k=d[g+1]-d[g],m=!1,u=0;u<b.length;u++){var w=C(b[u]);if(w.x<f&&w.x+w.width>f&&w.y<h&&w.y+w.height>h){m=!0;break}}m&&(c+=Math.round(l)*Math.round(k))}}return c}\nfunction Ba(a,b){a=C(a);for(var c=[],d=[],e=0;e<b.length;e++){var f=C(b[e]);f=Ca(a,f);Da(c,f.x);Da(c,f.endX);Da(d,f.y);Da(d,f.endY)}c=c.sort(function(l,g){return l-g});d=d.sort(function(l,g){return l-g});return{ba:c,ca:d}}function Ca(a,b){return{x:Math.max(a.x,b.x),y:Math.max(a.y,b.y),endX:Math.min(a.x+a.width,b.x+b.width),endY:Math.min(a.y+a.height,b.y+b.height)}}function Da(a,b){-1===a.indexOf(b)&&a.push(b)};function Ea(){this.b=this.a=this.v=this.l=this.g=this.j=void 0;this.m=0;this.h=[];this.o=[];this.u=0;this.i=[];this.c=[];this.f=[]}Ea.prototype.J=function(a){return null==a?!1:JSON.stringify(Fa(this))===JSON.stringify(Fa(a))};\nfunction Fa(a){var b=[],c=[],d={viewport:a.j,adView:{percentageInView:a.m,pixelsInView:a.u,reasons:a.f},declaredFriendlyObstructions:a.h.length};if(void 0!==a.a){d.adView.geometry=C(a.a);d.adView.geometry.pixels=ya(a.a);d.adView.onScreenGeometry=C(a.b);d.adView.onScreenGeometry.pixels=Math.max(0,ya(a.b)-Aa(a.b,a.c));for(var e=0;e<a.c.length;e++)b.push(C(a.c[e]));for(e=0;e<a.o.length;e++){var f=a.o[e],l=f,g={};l.b&&(g.obstructionClass=l.b);l.c&&(g.obstructionPurpose=l.c);l.f&&(g.obstructionReason=\nl.f);f=Ca(a.a,f);c.push(Object.assign({},{x:f.x,y:f.y,width:f.endX-f.x,height:f.endY-f.y},g))}d.adView.onScreenGeometry.obstructions=b;d.adView.onScreenGeometry.friendlyObstructions=c;void 0!==a.l&&void 0!==a.v&&(d.adView.containerGeometry=C(a.l),d.adView.onScreenContainerGeometry=C(a.v),d.adView.measuringElement=!0)}return d}function Ga(a,b){b=va(b);a.j={};a.j.width=b.width;a.j.height=b.height;a.g={};a.g.x=0;a.g.y=0;a.g.width=b.width;a.g.height=b.height;a.g.endX=b.width;a.g.endY=b.height}\nfunction Ha(){return{x:0,y:0,endX:0,endY:0,width:0,height:0}}function Ia(a,b){var c={};c.x=Math.max(a.x,b.x);c.y=Math.max(a.y,b.y);c.endX=Math.min(a.endX,b.endX);c.endY=Math.min(a.endY,b.endY);c.width=Math.max(0,c.endX-c.x);c.height=Math.max(0,c.endY-c.y);return c}function Ja(a,b){return.01<b.width-a.width||.01<b.height-a.height}function Ka(a){if(-1!==a.f.indexOf('backgrounded'))a.m=0,a.u=0;else{var b=ya(a.a);if(0!==b){var c=Math.max(0,ya(a.b)-Aa(a.b,a.c));a.m=Math.round(c/b*100);a.u=c}}}\nfunction La(a,b){if(za(b)||!a.b)b=!1;else{var c=wa(a.b),d=c.y,e=c.endX;a=c.endY;var f=b.endX;c=c.x;(f=f<c||.01>Math.abs(f-c))||(f=b.x,f=f>e||.01>Math.abs(f-e));(e=f)||(e=b.endY,e=e<d||.01>Math.abs(e-d));(d=e)||(b=b.y,d=b>a||.01>Math.abs(b-a));b=!d}return b}function D(a,b){for(var c=!1,d=0;d<a.f.length;d++)a.f[d]===b&&(c=!0);c||a.f.push(b)};function Ma(a,b,c,d,e){var f=new Ea;b=new B(b,!1);Ga(f,b);Na(a,b,f,d);if(!e)return f.f=['unmeasurable'],f.j=void 0,f.m=0,f.c=[],f.a&&(a=f.a,c={},a=new B((c.x=0,c.y=0,c.width=a.width,c.height=a.height,c),a.a),f.a=a),f.b=Ha(),f;if('backgrounded'===c)D(f,'backgrounded');else if(void 0!==f.a){for(a=0;a<f.h.length;a++)La(f,f.h[a])&&f.o.push(f.h[a]);for(a=0;a<f.i.length;a++){if(c=La(f,f.i[a])){a:{c=f.i[a];for(d=0;d<f.c.length;d++)if(f.c[d].J(c)){c=!0;break a}c=!1}c=!c}c&&(D(f,'obstructed'),f.c.push(f.i[a]))}Ka(f)}else D(f,\n'notFound');return f}\nfunction Na(a,b,c,d){var e=b.isCreative?!0:b.adSessionId===d;if(e){c.a=b;var f=wa(c.a);a=Ia(c.g,f);var l=c.a;'notAttached'===l.notVisibleReason||'noWindowFocus'===l.notVisibleReason||'noAdView'===l.notVisibleReason?(D(c,'notFound'),c.b=new B(Ha(),!1)):(l=c.a,'viewInvisible'===l.notVisibleReason||'viewGone'===l.notVisibleReason||'viewNotVisible'===l.notVisibleReason||'viewAlphaZero'===l.notVisibleReason||'viewHidden'===l.notVisibleReason||void 0!==c.a.notVisibleReason||za(c.a)?(D(c,'hidden'),c.b=new B(Ha(),\n!1)):(c.a.g||(D(c,'backgrounded'),D(c,'noWindowFocus')),Ja(a,f)&&D(c,'clipped'),c.b=new B(a,!1)))}else if(f=!0,b.a&&(f=-1!==b.isFriendlyObstructionFor.indexOf(d)?!1:!1===b.clipsToBounds),f){l=b.childViews;for(var g=0;g<l.length;g++)f=void 0!==c.a,Na(a,new B(l[g],f),c,d)}e||void 0===c.a||(b.a?-1!==b.isFriendlyObstructionFor.indexOf(d)?c.h.push(b):c.i.push(b):(e=wa(b),d=wa(c.b),C(c.b),!za(c.b)&&b.clipsToBounds&&(b=Ia(d,e),Ja(b,d)&&(D(c,'clipped'),c.b=new B(b,!1)))))};function Oa(a,b){this.y=this.x=0;this.width=a;this.height=b};function Pa(){return{apiVersion:'1.0',accessMode:'limited',environment:'app',omidJsInfo:{omidImplementer:'omsdk',serviceVersion:'1.3.37-iab3566'}}}function Qa(){this.adSessionId=null;this.c=Pa();this.o=null;this.m='foregrounded';this.l=this.i='none';this.j=this.g=this.f=this.h=this.a=this.b=this.B=this.u=null;this.C=!0;this.v=new Map}var G;function H(){G||(G=new Qa);return G};var I=function(){if('undefined'!==typeof omidGlobal&&omidGlobal)return omidGlobal;if('undefined'!==typeof global&&global)return global;if('undefined'!==typeof window&&window)return window;if('undefined'!==typeof globalThis&&globalThis)return globalThis;var a=Function('return this')();if(a)return a;throw Error('Could not determine global object context.');}();function Ra(a,b){this.a=a;this.b=b}t.Object.defineProperties(Ra.prototype,{event:{configurable:!0,enumerable:!0,get:function(){return this.a}},origin:{configurable:!0,enumerable:!0,get:function(){return this.b}}});function J(a){for(var b=[],c=0;c<arguments.length;++c)b[c]=arguments[c];Sa(function(){throw new (Function.prototype.bind.apply(Error,[null,'Could not complete the test successfully - '].concat(q(b))));},function(){return console.error.apply(console,q(b))})}function Ta(a){for(var b=[],c=0;c<arguments.length;++c)b[c]=arguments[c];Sa(function(){},function(){return console.error.apply(console,q(b))})}\nfunction Sa(a,b){'undefined'!==typeof jasmine&&jasmine?a():'undefined'!==typeof console&&console&&console.error&&b()};function Ua(){this.f=[];this.b=[];this.c=[];this.g=[];this.i={};this.a=H()}function Va(a){a.f=[];a.b=[];a.c=[];a.g=[];a.i={};G.adSessionId=null;G.c=Pa();G.o=null;G.G=void 0;G.K=void 0;G.H=null;G.I=null;G.D=null;G.m='foregrounded';G.i='none';G.l='none';G.u=null;G.B=null;G.b=null;G.a=null;G.h=null;G.f=null;G.g=null;G.j=null;G.C=!0;G.v=new Map}\nfunction Wa(a,b){void 0!==a.a&&a.a.adSessionId&&!1!==Xa(a,b)&&a.c.filter(function(c){return c.type===b.event.type}).forEach(function(c){return a.h(c.F,b.event)})}function Ya(a,b){a.f.push(b);Wa(a,b)}function Za(a,b,c){void 0!==a.a&&a.a.adSessionId&&a.f.filter(function(d){return d.event.type===b&&Xa(a,d)}).map(function(d){return d.event}).forEach(c)}\nfunction Xa(a,b){var c=b.event.type,d=-1!==Object.values(A).indexOf(c)&&'volumeChange'!==c;return'impression'===c||'loaded'===c&&a.a.a?b.origin===H().l:d?b.origin===H().i:!0}function $a(a,b,c){'media'===b||'video'===b?ab(a,c):(a.c.push({type:b,F:c}),Za(a,b,c))}function ab(a,b){Object.keys(A).forEach(function(c){c=A[c];a.c.push({type:c,F:b});Za(a,c,b)})}function bb(a,b,c,d){var e={O:c,L:d,F:b};a.g.push(e);a.b.forEach(function(f){var l=cb(f);'sessionStart'===f.event.type&&db(a,l,e);a.h(b,l)})}\nfunction eb(a,b,c){var d=K(a,'sessionError','native',{errorType:b,message:c});a.b.push(d);a.g.forEach(function(e){a.h(e.F,d.event)})}function fb(a,b){a.i=Object.assign(a.i,b);b=a.a.c;if(void 0!==b){b=Object.assign({},gb(a,hb(a,{context:b}),!0),{supportsLoadedEvent:!!a.a.a||'video'==a.a.b});Object.assign(b,{pageUrl:null,contentUrl:a.a.o});var c=K(a,'sessionStart','native',b);a.b.push(c);a.g.forEach(function(d){var e=d.F,f=cb(c);db(a,f,d);a.h(e,f)},a);ib(a)}}\nfunction db(a,b,c){c.O&&(b.data.verificationParameters=a.i[c.O]);c.L&&(c=a.a.v.get(c.L))&&(b.data.verificationParameters=c.verificationParameters,b.data.context.accessMode=c.accessMode,'full'===c.accessMode&&(a.a.g&&(b.data.context.videoElement=a.a.g),a.a.f&&(b.data.context.slotElement=a.a.f)))}function jb(a){var b=a.g,c=K(a,'sessionFinish','native');a.b.push(c);var d=a.a.c;d&&'native'==d.adSessionType||Va(a);b.forEach(function(e){return a.h(e.F,c.event)})}\nUa.prototype.h=function(a,b){for(var c=[],d=1;d<arguments.length;++d)c[d-1]=arguments[d];try{a.apply(null,q(c))}catch(e){Ta(e)}};function kb(a,b){var c=(c=H().D)?Fa(c):void 0;c=gb(a,hb(a,c));Ya(a,K(a,'impression',b,c))}function lb(a,b,c){if(a.a.a||'display'!=a.a.b)b=K(a,'loaded',b,gb(a,hb(a,void 0===c?null:c))),Ya(a,b)}\nfunction mb(a,b,c,d){'start'!==b&&'volumeChange'!==b||null!=(d&&d.deviceVolume)||(d.deviceVolume=a.a.u);if(d&&('start'===b||'volumeChange'===b)){var e=d.videoPlayerVolume,f=d.mediaPlayerVolume;null!=e?(Object.assign(d,{mediaPlayerVolume:e}),a.a.B=e):null!=f&&(Object.assign(d,{videoPlayerVolume:f}),a.a.B=f)}Ya(a,K(a,b,c,d))}\nfunction ib(a){var b=a.f.filter(function(f){return Object.values(A).includes(f.event.type)&&'video'==a.a.b&&f.origin===a.a.i||'loaded'==f.event.type&&'display'==a.a.b&&f.origin===a.a.l?!0:!1}).map(function(f){return f.event}),c=a.a.adSessionId||'',d={};b=p(b);for(var e=b.next();!e.done;d={w:d.w},e=b.next()){d.w=e.value;d.w.adSessionId||(d.w.adSessionId=c);if('loaded'==d.w.type){if(!a.a.a&&'display'==a.a.b)continue;d.w.data=gb(a,hb(a,d.w.data))}a.c.filter(function(f){return function(l){return l.type===\nf.w.type}}(d)).forEach(function(f){return function(l){return l.F(f.w)}}(d))}}function nb(a,b,c){a:{c=new Set(c);a=p(a.f.concat(a.b));for(var d=a.next();!d.done;d=a.next())if(d=d.value,c.has(d.event.type)&&d.origin!=b){b=!0;break a}b=!1}return b?(J('Event owner cannot be registered after its events have already been published.'),!1):!0}function ob(a,b){nb(a,b,Object.values(A))&&L(a,b)&&(a.a.i=b)}function pb(a,b){nb(a,b,['impression'])&&qb(a,b)&&(a.a.l=b)}\nfunction qb(a,b){var c=a.a.l;return'none'!=c&&c!=b?(J('Impression event is owned by '+(a.a.l+', not ')+(b+'.')),!1):!0}function L(a,b){var c=a.a.i;return'none'!=c&&c!=b?(J('Media events are owned by '+(a.a.i+', not '+b+'.')),!1):!0}function gb(a,b,c){c=void 0===c?!1:c;b=Object.assign({},b);a.a.b&&Object.assign(b,{mediaType:a.a.b});a.a.a&&(c||'definedByJavaScript'!==a.a.a)&&Object.assign(b,{creativeType:a.a.a});return b}function hb(a,b){return a.a.h?Object.assign({},b,{impressionType:a.a.h}):b}\nfunction K(a,b,c,d){return new Ra({adSessionId:a.a.adSessionId||'',timestamp:(new Date).getTime(),type:b,data:d},c)}function cb(a){a=a.event;return{adSessionId:a.adSessionId,timestamp:a.timestamp,type:a.type,data:a.data}};function rb(a,b,c){'container'===b&&void 0!==a.a.G&&void 0!==a.a&&null!=a.a.adSessionId&&(a.a.H=Ma(a.c,a.a.G,a.a.m,a.a.adSessionId,!0));b=a.a;var d=b.H,e=b.I;if(d)if(e){b=new Ea;var f=d.j,l=d.a,g=d.b,h=e.a,k=e.b;f&&l&&g&&h&&k&&(Ga(b,f),b.l=new B(l,!1),b.v=new B(g,!1),b.i=Object.assign([],d.i),b.c=Object.assign([],d.c),b.h=Object.assign([],d.h),b.o=Object.assign([],d.o),b.f=Object.assign([],e.f,d.f),d=b.l.x,e=b.l.y,h=new B(h,!1),k=new B(k,!1),xa(h,d,e),xa(k,d,e),b.a=h,b.b=Ia(k,g),Ka(b))}else b=d;else b=\nnull;g=a.a.D;if(b&&!b.J(g)||c)g=Fa(b),c&&(g.adView.reasons=g.adView.reasons||[c]),c=a.b,'audio'!=c.a.a&&Ya(c,K(c,'geometryChange','native',g)),a.a.D=b};function M(a){return'object'===typeof a}function sb(a){return'number'===typeof a&&!isNaN(a)&&0<=a}function N(a){return'string'===typeof a}function O(a,b){return N(a)&&-1!==Object.values(b).indexOf(a)}function tb(a){return!(!a||!a.tagName||'iframe'!==a.tagName.toLowerCase())};function P(a,b,c){this.f=a;this.K=b;this.G=c;this.c=H();this.b=null;this.a=this.g=this.u=void 0;this.I=!0;this.B=void 0;Q(this)}function Q(a){if(!a.b){var b;a:{if((b=a.f.document)&&b.getElementsByClassName&&(b=b.getElementsByClassName('omid-element'))){if(1==b.length){b=b[0];break a}1<b.length&&a.I&&(eb(a.G,'generic',\"More than one element with 'omid-element' class name.\"),a.I=!1)}b=null}if(b&&b.tagName&&'video'===b.tagName.toLowerCase())a.c.g=b;else if(b&&b.tagName)a.c.f=b;else return;ub(a)}}\nfunction ub(a){a.c.g?(a.b=a.c.g,a.i()):a.c.f&&(a.b=a.c.f,tb(a.b)?a.c.j&&a.i():a.i())}function vb(a){a.a&&(tb(a.b)?a.c.j&&(a.D(),wb(a)):(a.D(),wb(a)))}P.prototype.m=function(){this.B&&(this.f.document.removeEventListener('visibilitychange',this.B),this.B=void 0)};P.prototype.i=function(){};function wb(a){a.u&&(a.c.I=a.u,rb(a.K,'creative'))}function xb(a){if(a.a&&a.c.j){var b=new B(a.c.j,!1);xa(b,a.a.x,a.a.y);b.clipsToBounds=!0;return b}};function yb(a,b,c){return zb(a,'setInterval')(b,c)}function Ab(a,b){zb(a,'clearInterval')(b)}function Bb(a,b){zb(a,'clearTimeout')(b)}function zb(a,b){return a.a&&a.a[b]?a.a[b]:Cb(a,b)}\nfunction Db(a,b,c,d){if(a.a.document&&a.a.document.body){var e=a.a.document.createElement('img');e.width=1;e.height=1;e.style.display='none';e.src=b;c&&e.addEventListener('load',function(){return c()});d&&e.addEventListener('error',function(){return d()});a.a.document.body.appendChild(e)}else Cb(a,'sendUrl')(b,c,d)}function Cb(a,b){if(a.a&&a.a.omidNative&&a.a.omidNative[b])return a.a.omidNative[b].bind(a.a.omidNative);throw Error('Native interface method \"'+b+'\" not found.');};function R(a,b,c,d,e){P.call(this,a,c,e);this.l=b;this.h=void 0;this.j=d}r(R,P);R.prototype.m=function(){void 0!==this.h&&(Ab(this.j,this.h),this.h=void 0);P.prototype.m.call(this)};R.prototype.i=function(){var a=this;P.prototype.i.call(this);null==this.b?this.h=void 0:void 0===this.h&&(this.h=yb(this.j,function(){return Eb(a)},200),Eb(this))};\nR.prototype.D=function(){if(this.g){var a=xb(this);if(a){this.a.isCreative=!1;a.isCreative=!0;for(var b=!1,c=0;c<this.a.childViews.length;c++)if(this.a.childViews[c].isCreative){this.a.childViews[c]=a;b=!0;break}b||this.a.childViews.push(a)}else this.a.isCreative=!0;this.u=Ma(this.l,this.g,this.c.m,this.c.adSessionId,this.C())}};R.prototype.C=function(){return!0};\nfunction Eb(a){if(void 0!==a.h){b:{try{var b=a.f.top;var c=0<=b.innerHeight&&0<=b.innerWidth;break b}catch(d){}c=!1}c?(c=a.f.top,c=new B(new Oa(c.innerWidth,c.innerHeight),!1)):c=new B(new Oa(0,0),!1);b=a.b.getBoundingClientRect();if(null==b.x||isNaN(b.x))b.x=b.left;if(null==b.y||isNaN(b.y))b.y=b.top;b=new B(b,!1);c.J(a.g)&&b.J(a.a)||(a.a=b,a.a.clipsToBounds=!0,a.g=c,a.g.childViews.push(a.a),vb(a))}};function S(a,b,c,d){P.call(this,a,c,d);this.o=this.j=this.l=this.h=void 0;this.H=!1;this.v=void 0}r(S,P);S.prototype.m=function(){this.h&&this.h.disconnect();Fb(this);P.prototype.m.call(this)};S.prototype.i=function(){P.prototype.i.call(this);this.b&&(this.h||(this.h=Gb(this)),Hb(this),Ib(this.b)&&Jb(this))};\nS.prototype.D=function(){if(this.a&&this.v){var a=xb(this);if(a){var b=a;var c=this.v;var d=Math.max(a.x,c.x);var e=Math.max(a.y,c.y),f=Math.min(a.endX,c.endX);a=Math.min(a.endY,c.endY);f<=d||a<=e?d=null:(c={},d=new B((c.x=d,c.y=e,c.width=Math.abs(f-d),c.height=Math.abs(a-e),c),!1));d||(d=new B({x:0,y:0,width:0,height:0},!1))}else b=this.a,d=this.v;e=new Ea;this.g&&Ga(e,this.g);e.a=b;e.b=d;Ka(e);this.H?za(e.a)?D(e,'hidden'):100===e.m||D(e,'clipped'):D(e,'viewport');this.u=e}};S.prototype.C=function(){return!0};\nfunction Fb(a){a.l&&(a.l.disconnect(),a.l=void 0);a.j&&(a.j.disconnect(),a.j=void 0);a.o&&((0,a.f.removeEventListener)('resize',a.o),a.o=void 0)}function Hb(a){a.h&&a.b&&(a.h.unobserve(a.b),a.h.observe(a.b))}function Ib(a){a=a.getBoundingClientRect();return 0==a.width||0==a.height}\nfunction Gb(a){return new a.f.IntersectionObserver(function(b){try{if(b.length){for(var c,d=b[0],e=1;e<b.length;e++)b[e].time>d.time&&(d=b[e]);c=d;a.g=Kb(c.rootBounds);a.a=Kb(c.boundingClientRect);a.v=Kb(c.intersectionRect);a.H=!!c.isIntersecting;vb(a)}}catch(f){a.m(),eb(a.G,'generic','Problem handling IntersectionObserver callback: '+f.message)}},{root:null,rootMargin:'0px',threshold:[0,.1,.2,.3,.4,.5,.6,.7,.8,.9,1]})}\nfunction Jb(a){a.f.ResizeObserver?a.l||(a.l=Lb(a,function(){return Mb(a)}),a.l.observe(a.b)):(a.o||(a.o=function(){return Mb(a)},(0,a.f.addEventListener)('resize',a.o)),a.j||(a.j=new MutationObserver(function(){return Mb(a)}),a.j.observe(a.b,{childList:!1,attributes:!0,subtree:!1})))}function Mb(a){a.b&&!Ib(a.b)&&(Hb(a),Fb(a))}function Lb(a,b){return new a.f.ResizeObserver(b)}function Kb(a){if(a&&null!==a.x&&null!==a.y&&null!==a.width&&null!==a.height)return new B(a,!1)};function Nb(a){return a&&M(a)?Object.entries(a).reduce(function(b,c){var d=p(c);c=d.next().value;d=d.next().value;return b&&N(c)&&null!=d&&M(d)&&N(d.resourceUrl)},!0):!1};function T(a,b,c,d){this.b=a;this.method=b;this.version=c;this.a=d}function Pb(a){return!!a&&void 0!==a.omid_message_guid&&void 0!==a.omid_message_method&&void 0!==a.omid_message_version&&'string'===typeof a.omid_message_guid&&'string'===typeof a.omid_message_method&&'string'===typeof a.omid_message_version&&(void 0===a.omid_message_args||void 0!==a.omid_message_args)}function Qb(a){return new T(a.omid_message_guid,a.omid_message_method,a.omid_message_version,a.omid_message_args)}\nfunction Rb(a){var b={};b=(b.omid_message_guid=a.b,b.omid_message_method=a.method,b.omid_message_version=a.version,b);void 0!==a.a&&(b.omid_message_args=a.a);return b};function Sb(a){this.c=a};function U(a){this.c=a;this.handleExportedMessage=U.prototype.f.bind(this)}r(U,Sb);U.prototype.b=function(a,b){b=void 0===b?this.c:b;if(!b)throw Error('Message destination must be defined at construction time or when sending the message.');b.handleExportedMessage(Rb(a),this)};U.prototype.f=function(a,b){Pb(a)&&this.a&&this.a(Qb(a),b)};function Tb(a){return Ub(a,'SessionService.')}function Ub(a,b){return(a=a.match(new RegExp('^'+b+'(.*)')))&&a[1]};function Vb(a,b){this.c=b=void 0===b?I:b;var c=this;a.addEventListener('message',function(d){if('object'===typeof d.data){var e=d.data;Pb(e)&&d.source&&c.a&&c.a(Qb(e),d.source)}})}r(Vb,Sb);Vb.prototype.b=function(a,b){b=void 0===b?this.c:b;if(!b)throw Error('Message destination must be defined at construction time or when sending the message.');b.postMessage(Rb(a),'*')};function Wb(){return'xxxxxxxx-xxxx-4xxx-yxxx-xxxxxxxxxxxx'.replace(/[xy]/g,function(a){var b=16*Math.random()|0;return'y'===a?(b&3|8).toString(16):b.toString(16)})};function Xb(a){if(!a.a||!a.a.document)throw Error('OMID Service Script is not running within a window.');var b=a.b;a.b=[];b.forEach(function(c){try{var d=a.c.C?'limited':'full',e=O(c.accessMode,sa)?c.accessMode:null;var f=e?'full'==e&&'limited'==d?d:'domain'==e?'limited':e:d;c.accessMode=f;a:{var l=c.resourceUrl,g=a.a.location.origin;try{var h=new URL(l,g);break a}catch(V){}try{h=new URL(l);break a}catch(V){}h=null}if(d=h){var k=Wb(),m=a.a.document,u=m.createElement('iframe');u.id='omid-verification-script-frame-'+\nk;u.style.display='none';['full','limited'].includes(f)?u.srcdoc=\"<html><head>\\n<script type=\\\"text/javascript\\\">window['omidVerificationProperties'] = {\\n'serviceWindow': window.parent,\\n'injectionSource': 'app',\\n'injectionId': '\"+(k+'\\',\\n};\\x3c/script>\\n<script type=\"text/javascript\" src=\"')+d.href+'\">\\x3c/script>\\n</head><body></body></html>':'domain'==f&&(u.src=Yb(a,k,d).href);['domain','limited'].includes(f)&&(u.sandbox='allow-scripts');m.body.appendChild(u);var w=c.vendorKey,E=c.verificationParameters;\nw=void 0===w?'':w;E=void 0===E?'':E;w&&'string'===typeof w&&''!==w&&E&&'string'===typeof E&&''!==E&&(a.f.i[w]=E);a.c.v.set(k,c)}}catch(V){Ta('OMID verification script '+c.resourceUrl+' failed to load: '+V)}})}\nfunction Yb(a,b,c){var d='/.well-known/omid/omloader-v1.html#';(new Map([['verificationScriptUrl',c.href],['injectionId',b]])).forEach(function(e,f){d+=encodeURIComponent(f)+'='+encodeURIComponent(e)+'&'});b=null;try{b=new URL(d,a.a.parent.location.origin)}catch(e){throw Error('OMID Service Script cannot access the parent window.');}return b};function Zb(){var a=$b,b=ac,c=this;this.c=X;this.b=a;this.a=H();this.g=b;this.f=!1;this.registerSessionObserver(function(d){return bc(c,d)})}n=Zb.prototype;n.registerSessionObserver=function(a){bb(this.c,a)};n.setSlotElement=function(a){a&&a.tagName?(this.a.f=a,this.b&&ub(this.b)):J('setSlotElement called with a non-HTMLElement.  It will be ignored.')};n.setElementBounds=function(a){this.a.j=a;this.b&&ub(this.b);this.b&&vb(this.b)};n.error=function(a,b){eb(this.c,a,b)};\nn.registerAdEvents=function(){pb(this.c,'javascript')};n.registerMediaEvents=function(){ob(this.c,'javascript')};function Y(a,b,c){'impression'==b?qb(a.c,'javascript')&&(kb(a.c,'javascript'),a.b&&Q(a.b)):('loaded'==b?(c=void 0===c?null:c,L(a.c,'javascript')&&lb(a.c,'javascript',c)):L(a.c,'javascript')&&mb(a.c,b,'javascript',c),['loaded','start'].includes(b)&&a.b&&Q(a.b))}n.injectVerificationScriptResources=function(a){var b=this.g;b.b.push.apply(b.b,q(a));if(this.f)try{Xb(this.g)}catch(c){J(c.message)}};\nn.setCreativeType=function(a,b){b=void 0===b?null:b;if(!this.a.b||this.a.a)this.a.a=a,'video'==a||'audio'==a?this.a.b='video':'htmlDisplay'==a||'nativeDisplay'==a?this.a.b='display':'definedByJavaScript'==a&&b&&(this.a.b='none'==b?'display':'video')};n.setImpressionType=function(a){if(!this.a.b||this.a.a)this.a.h=a};\nfunction bc(a,b){if('sessionStart'===b.type){a.f=!0;try{Xb(a.g)}catch(c){J(c.message)}}'sessionFinish'===b.type&&(a.f=!1,(b=H().c)&&'native'==b.adSessionType||a.registerSessionObserver(function(c){return bc(a,c)}))}n.setClientInfo=function(a,b,c){var d=this.a.c||{};d.omidJsInfo=Object.assign({},d.omidJsInfo,{sessionClientVersion:a,partnerName:b,partnerVersion:c});this.a.c=d;return this.a.c.omidJsInfo.serviceVersion};function cc(a){return/\\d+\\.\\d+\\.\\d+(-.*)?/.test(a)}function dc(a){a=a.split('-')[0].split('.');for(var b=['1','0','3'],c=0;3>c;c++){var d=parseInt(a[c],10),e=parseInt(b[c],10);if(d>e)break;else if(d<e)return!1}return!0};function ec(a,b){return cc(a)&&dc(a)?b?b:[]:b&&'string'===typeof b?JSON.parse(b):[]};var fc=new function(){};function gc(){var a=hc;var b=void 0===b?omidGlobal:b;this.a=a;this.g=b;this.b=new U;this.g.omid=this.g.omid||{};this.g.omid.v1_SessionServiceCommunication=this.b;this.f=b&&b.addEventListener&&b.postMessage?new Vb(b):null;this.c=null;this.b.a=this.h.bind(this);this.f&&(this.f.a=this.i.bind(this))}gc.prototype.h=function(a,b){null!=Tb(a.method)&&ic(this,fc)&&jc(this,a,b,this.b)};gc.prototype.i=function(a,b){null!=Tb(a.method)&&ic(this,b)&&jc(this,a,b,this.f)};\nfunction ic(a,b){a.c||(a.c=b);return a.c!=b?(J('The source of session client messages cannot be changed from the source of the first message.'),!1):!0}\nfunction jc(a,b,c,d){function e(h){for(var k=[],m=0;m<arguments.length;++m)k[m]=arguments[m];k=new T(f,'response',g,cc(g)&&dc(g)?k:JSON.stringify(k));d.b(k,c)}var f=b.b,l=b.method,g=b.version;b=ec(g,b.a);try{kc(a,l,e,b)}catch(h){d.b(new T(f,'error',g,'\\n        name: '+h.name+'\\n        message: '+h.message+'\\n        filename: '+h.filename+'\\n        lineNumber: '+h.lineNumber+'\\n        columnNumber: '+h.columnNumber+'\\n        stack: '+h.stack+'\\n        toString(): '+h.toString()),c)}}\nfunction kc(a,b,c,d){if(null!=Tb(b))switch(Tb(b)){case 'registerAdEvents':a.a.registerAdEvents();break;case 'registerMediaEvents':a.a.registerMediaEvents();break;case 'registerSessionObserver':a.a.registerSessionObserver(c);break;case 'setSlotElement':c=p(d).next().value;a.a.setSlotElement(c);break;case 'setVideoElement':c=p(d).next().value;a=a.a;c&&c.tagName&&'video'===c.tagName.toLowerCase()?(a.a.g=c,a.b&&ub(a.b)):J('setVideoElement called with a non-HTMLVideoElement. It will be ignored.');break;\ncase 'setElementBounds':c=p(d).next().value;a.a.setElementBounds(c);break;case 'startSession':J('Session start from JS is not supported in mobile app.');break;case 'finishSession':J('Session finish from JS is not supported in mobile app.');break;case 'impressionOccurred':Y(a.a,'impression');break;case 'loaded':(c=p(d).next().value)?(b={skippable:c.isSkippable,autoPlay:c.isAutoPlay,position:c.position},c.isSkippable&&(b.skipOffset=c.skipOffset),Y(a.a,'loaded',b)):Y(a.a,'loaded');break;case 'start':b=\np(d);c=b.next().value;b=b.next().value;Y(a.a,'start',{duration:c,mediaPlayerVolume:b});break;case 'firstQuartile':Y(a.a,'firstQuartile');break;case 'midpoint':Y(a.a,'midpoint');break;case 'thirdQuartile':Y(a.a,'thirdQuartile');break;case 'complete':Y(a.a,'complete');break;case 'pause':Y(a.a,'pause');break;case 'resume':Y(a.a,'resume');break;case 'bufferStart':Y(a.a,'bufferStart');break;case 'bufferFinish':Y(a.a,'bufferFinish');break;case 'skipped':Y(a.a,'skipped');break;case 'volumeChange':c={mediaPlayerVolume:p(d).next().value};\nY(a.a,'volumeChange',c);break;case 'playerStateChange':c={state:p(d).next().value};Y(a.a,'playerStateChange',c);break;case 'adUserInteraction':c={interactionType:p(d).next().value};Y(a.a,'adUserInteraction',c);break;case 'setClientInfo':var e=p(d);b=e.next().value;d=e.next().value;e=e.next().value;a=a.a.setClientInfo(b,d,e);c(a);break;case 'injectVerificationScriptResources':c=p(d).next().value;a.a.injectVerificationScriptResources(c);break;case 'setCreativeType':c=p(d).next().value;a.a.setCreativeType(c);\nbreak;case 'setImpressionType':c=p(d).next().value;a.a.setImpressionType(c);break;case 'setContentUrl':c=p(d).next().value;a.a.a.o=c;break;case 'sessionError':b=p(d),c=b.next().value,b=b.next().value,a.a.error(c,b)}};function Z(){var a=X,b=lc,c=mc,d=$b;this.f=hc;this.a=a;this.c=b;this.h=c;this.g=d;this.b=H()}n=Z.prototype;\nn.T=function(a){if(!(!(a&&M(a)&&O(a.impressionOwner,qa))||'videoEventsOwner'in a&&null!=a.videoEventsOwner&&!O(a.videoEventsOwner,qa)||'mediaEventsOwner'in a&&null!=a.mediaEventsOwner&&!O(a.mediaEventsOwner,qa))){if(a.creativeType&&a.impressionType){var b=a.mediaEventsOwner;null==this.b.a&&this.f.setCreativeType(a.creativeType,b);null==this.b.h&&(this.b.h=a.impressionType);ob(this.a,b)}else b=a.videoEventsOwner,this.b.b=null==b||'none'===b?'display':'video',this.b.a=null,this.b.h=null,ob(this.a,b);\npb(this.a,a.impressionOwner);a&&null!=a.isolateVerificationScripts&&'boolean'===typeof a.isolateVerificationScripts&&(this.b.C=a.isolateVerificationScripts)}};\nn.W=function(a,b,c,d){var e;if(M(b)){if(e=O(b.environment,ua)&&O(b.adSessionType,pa))e=b.omidNativeInfo,e=M(e)?N(e.partnerName)&&N(e.partnerVersion):!1;e&&(e=b.app,e=M(e)?N(e.libraryVersion)&&N(e.appId):!1)}else e=!1;e&&(Nb(d)&&(this.b.v=new Map(Object.entries(d))),d=this.f,c=void 0===c?null:c,null==a&&(a=Wb()),b.canMeasureVisibility=d.b.C(),d.a.adSessionId=a,a=d.a,e=b,void 0!==e.contentUrl&&(a.o=e.contentUrl,e.contentUrl=void 0),e=a.c||{},b.omidJsInfo=Object.assign({},e.omidJsInfo||{},b.omidJsInfo||\n{}),e=b=Object.assign({},e,b),a.C||(null!=a.g?(e.videoElement=a.g,e.accessMode='full'):null!=a.f&&(e.slotElement=a.f,e.accessMode='full')),a.c=b,fb(d.c,c),d.b&&Q(d.b))};n.U=function(){var a=this.f;jb(a.c);a.b.m()};n.$=function(a){M(a)&&sb(a.x)&&sb(a.y)&&sb(a.width)&&sb(a.height)&&(this.b.G=a,rb(this.c,'container'))};n.aa=function(a){O(a,ta)&&(this.b.m=a,'backgrounded'===a?rb(this.c,'container','backgrounded'):rb(this.c,'container'))};n.X=function(a){'impression'===a&&(this.M(),this.g&&Q(this.g))};\nn.M=function(){qb(this.a,'native')&&kb(this.a,'native')};n.V=function(a){a=void 0===a?null:a;L(this.a,'native')&&lb(this.a,'native',a)};n.error=function(a,b){O(a,oa)&&eb(this.a,a,b)};n.Y=function(a,b){this.N(a,b)};n.N=function(a,b){L(this.a,'native')&&O(a,A)&&(void 0===b||M(b))&&('loaded'==a?lb(this.a,'native',b):mb(this.a,a,'native',b))};\nn.Z=function(a){if('none'!==this.a.a.i&&'number'===typeof a&&!isNaN(a)){this.b.u=a;a=this.h;var b=a.a.B;null!=b&&mb(a.b,'volumeChange','native',{mediaPlayerVolume:b,deviceVolume:a.a.u})}};Z.prototype.startSession=Z.prototype.W;Z.prototype.error=Z.prototype.error;Z.prototype.finishSession=Z.prototype.U;Z.prototype.publishAdEvent=Z.prototype.X;Z.prototype.publishImpressionEvent=Z.prototype.M;Z.prototype.publishVideoEvent=Z.prototype.Y;Z.prototype.publishMediaEvent=Z.prototype.N;\nZ.prototype.publishLoadedEvent=Z.prototype.V;Z.prototype.setNativeViewHierarchy=Z.prototype.$;Z.prototype.setState=Z.prototype.aa;Z.prototype.setDeviceVolume=Z.prototype.Z;Z.prototype.init=Z.prototype.T;function nc(){var a=X,b=oc;var c=void 0===c?I:c;this.g=a;this.a=b;this.h={};this.f={};this.c=new U;c.omid=c.omid||{};c.omid.v1_VerificationServiceCommunication=this.c;this.b=null;c&&c.addEventListener&&c.postMessage&&(this.b=new Vb(c));this.c.a=this.i.bind(this);this.b&&(this.b.a=this.j.bind(this))}function pc(a,b,c,d){Db(a.a,b,c,d)}function qc(a,b,c,d){Cb(a.a,'downloadJavaScriptResource')(b,c,d)}nc.prototype.j=function(a,b){this.b&&rc(this,a,b,this.b)};nc.prototype.i=function(a,b){rc(this,a,b,this.c)};\nfunction rc(a,b,c,d){function e(F){for(var W=[],ra=0;ra<arguments.length;++ra)W[ra]=arguments[ra];W=new T(f,'response',g,cc(g)&&dc(g)?W:JSON.stringify(W));d.b(W,c)}var f=b.b,l=b.method,g=b.version;b=ec(g,b.a);if(null!=Ub(l,'VerificationService.')){l=Ub(l,'VerificationService.');try{switch(l){case 'addEventListener':var h=p(b).next().value;$a(a.g,h,e);break;case 'addSessionListener':var k=p(b),m=k.next().value,u=k.next().value;bb(a.g,e,m,u);break;case 'sendUrl':var w=p(b).next().value;pc(a,w,function(){return e(!0)},\nfunction(){return e(!1)});break;case 'setTimeout':var E=p(b),V=E.next().value,wc=E.next().value;a.h[V]=zb(a.a,'setTimeout')(e,wc);break;case 'clearTimeout':var xc=p(b).next().value;Bb(a.a,a.h[xc]);break;case 'setInterval':var Ob=p(b),yc=Ob.next().value,zc=Ob.next().value;a.f[yc]=yb(a.a,e,zc);break;case 'clearInterval':var Ac=p(b).next().value;Ab(a.a,a.f[Ac]);break;case 'injectJavaScriptResource':var Bc=p(b).next().value;qc(a,Bc,function(F){return e(!0,F)},function(){return e(!1)});break;case 'getVersion':p(b).next();\nvar Cc=H().c.omidJsInfo;e(Cc.serviceVersion)}}catch(F){d.b(new T(f,'error',g,'\\n              name: '+F.name+'\\n              message: '+F.message+'\\n              filename: '+F.filename+'\\n              lineNumber: '+F.lineNumber+'\\n              columnNumber: '+F.columnNumber+'\\n              stack: '+F.stack+'\\n              toString(): '+F.toString()+'\\n          '),c)}}};function sc(){var a=I.document.createElement('iframe');a.id='omid_v1_present';a.name='omid_v1_present';a.style.display='none';I.document.body.appendChild(a)}function tc(){var a=new MutationObserver(function(b){b.forEach(function(c){'BODY'===c.addedNodes[0].nodeName&&(sc(),a.disconnect())})});a.observe(I.document.documentElement,{childList:!0})};var X=new Ua,oc=new function(){var a;this.a=a=void 0===a?omidGlobal:a};new nc;var uc=new function(){},vc=new function(){},lc=new function(){this.b=X;this.c=vc;this.a=H()},Dc;I?Dc=I.IntersectionObserver&&(I.MutationObserver||I.ResizeObserver)?new S(I,uc,lc,X):new R(I,vc,lc,oc,X):Dc=null;var $b=Dc,ac=new function(){var a=X;var b=void 0===b?I:b;this.f=a;this.a=b;this.c=H();this.b=[]},hc=new Zb,mc=new function(){var a=X,b=H();this.b=a;this.a=b};I.omidBridge=new Z;new gc;\nif(I.frames&&I.document&&!('omid_v1_present'in I.frames)){var Ec;if(Ec=null==I.document.body)Ec='MutationObserver'in I;Ec?tc():I.document.body?sc():I.document.write('<iframe style=\"display:none\" id=\"omid_v1_present\" name=\"omid_v1_present\"></iframe>')};\n}).call(this, this);";
                                                            }
                                                        }
                                                        AdSessionContext adSessionContextCreateNativeAdSessionContext2 = AdSessionContext.createNativeAdSessionContext(c3487n10.b, strA, verificationScriptResources2, strE2, str16);
                                                        Intrinsics.checkNotNullExpressionValue(adSessionContextCreateNativeAdSessionContext2, "createNativeAdSessionContext(...)");
                                                        try {
                                                            map5.put("omidAdSession", new C3371f9("native_display_ad", ImpressionType.VIEWABLE, adSessionContextCreateNativeAdSessionContext2, false));
                                                            c3504oc.b.put("deferred", Boolean.TRUE);
                                                            L4 l13 = this.j;
                                                            if (l13 != null) {
                                                                str13 = str2;
                                                                str = str3;
                                                                try {
                                                                    Intrinsics.checkNotNullExpressionValue(str, str13);
                                                                    ((M4) l13).a(str, "OMID video ad session created and JavaScript resources injected");
                                                                } catch (Exception e6) {
                                                                    e = e6;
                                                                    l4 = this.j;
                                                                    if (l4 != null) {
                                                                        ((M4) l4).b(str, ld.a(e, O5.a(str, str13, "Setting up impression tracking for OMID Native Display encountered an unexpected error: ")));
                                                                    }
                                                                    C3339d5 c3339d6 = C3339d5.f3292a;
                                                                    C3339d5.c.a(I4.a(e, "event"));
                                                                }
                                                                str7 = str;
                                                                it = it2;
                                                                z2 = z;
                                                                str6 = str13;
                                                            } else {
                                                                it = it2;
                                                                z2 = z;
                                                                str6 = str2;
                                                                str7 = str3;
                                                            }
                                                        } catch (Exception e7) {
                                                            e = e7;
                                                            str13 = str2;
                                                            str = str3;
                                                            l4 = this.j;
                                                            if (l4 != null) {
                                                                ((M4) l4).b(str, ld.a(e, O5.a(str, str13, "Setting up impression tracking for OMID Native Display encountered an unexpected error: ")));
                                                            }
                                                            C3339d5 c3339d7 = C3339d5.f3292a;
                                                            C3339d5.c.a(I4.a(e, "event"));
                                                            str7 = str;
                                                            it = it2;
                                                            z2 = z;
                                                            str6 = str13;
                                                        }
                                                    }
                                                }
                                                it = it2;
                                                z2 = z;
                                                str6 = str2;
                                                str7 = str3;
                                            } catch (Exception e8) {
                                                e = e8;
                                            }
                                        } catch (Exception e9) {
                                            e = e9;
                                            str13 = str2;
                                            str = str3;
                                            l4 = this.j;
                                            if (l4 != null) {
                                                ((M4) l4).b(str, ld.a(e, O5.a(str, str13, "Setting up impression tracking for OMID Native Display encountered an unexpected error: ")));
                                            }
                                            C3339d5 c3339d8 = C3339d5.f3292a;
                                            C3339d5.c.a(I4.a(e, "event"));
                                            str7 = str;
                                            it = it2;
                                            z2 = z;
                                            str6 = str13;
                                        }
                                    } catch (Exception e10) {
                                        e = e10;
                                        str = str14;
                                        str13 = str2;
                                    }
                                } catch (Exception e11) {
                                    e = e11;
                                    str = str14;
                                }
                            }
                        }
                    }
                }
            }
        }
    }

    public final C3455l7 a(C3625x7 c3625x7) {
        L4 l4 = this.j;
        if (l4 != null) {
            ((M4) l4).c("C0", AbstractC3492o0.a("C0", "TAG", "isSkippableVideo ", this));
        }
        Iterator it = c3625x7.c().iterator();
        while (it.hasNext()) {
            C3455l7 c3455l7 = (C3455l7) c3625x7.n((String) it.next()).get(0);
            if (2 == c3455l7.k) {
                return c3455l7;
            }
        }
        return null;
    }

    public final void a(boolean z, Ba ba) {
        Set<C3504oc> setD;
        AdConfig.ViewabilityConfig viewability;
        L4 l4 = this.j;
        if (l4 != null) {
            ((M4) l4).a("C0", AbstractC3492o0.a("C0", "TAG", "omidSessionForHtmlMarkup ", this));
        }
        AdConfig adConfig = this.b;
        AdConfig.OmidConfig omidConfig = (adConfig == null || (viewability = adConfig.getViewability()) == null) ? null : viewability.getOmidConfig();
        if (omidConfig == null || omidConfig.isOmidEnabled()) {
            AbstractC3473m9.f3376a.getClass();
            if (Omid.isActive() && (setD = d(this.g.indexOf(ba))) != null) {
                for (C3504oc c3504oc : setD) {
                    if (3 == c3504oc.f3393a) {
                        try {
                            String str = (String) c3504oc.a("creativeType", String.class);
                            String str2 = (String) c3504oc.a("customReferenceData", String.class);
                            Boolean bool = (Boolean) c3504oc.a("isolateVerificationScripts", Boolean.class);
                            Byte b = (Byte) c3504oc.a("impressionType", Byte.class);
                            C3371f9 c3371f9A = (str == null || bool == null || b == null) ? null : AbstractC3413i9.a(str, ba, bool.booleanValue(), this.t.e(), b.byteValue(), str2);
                            if (c3371f9A != null) {
                                c3504oc.b.put("omidAdSession", c3371f9A);
                                c3504oc.b.put("deferred", Boolean.valueOf(z));
                                L4 l5 = this.j;
                                if (l5 != null) {
                                    Intrinsics.checkNotNullExpressionValue("C0", "TAG");
                                    ((M4) l5).a("C0", "OMID ad session created and WebView container registered with OMID");
                                }
                            } else {
                                L4 l6 = this.j;
                                if (l6 != null) {
                                    Intrinsics.checkNotNullExpressionValue("C0", "TAG");
                                    ((M4) l6).a("C0", "Ignoring IAB meta data for this ad markup");
                                }
                            }
                        } catch (Exception e) {
                            L4 l7 = this.j;
                            if (l7 != null) {
                                ((M4) l7).b("C0", ld.a(e, O5.a("C0", "TAG", "Setting up impression tracking for IAB encountered an unexpected error: ")));
                            }
                            C3339d5 c3339d5 = C3339d5.f3292a;
                            C3339d5.c.a(I4.a(e, "event"));
                        }
                    }
                }
            }
        }
    }

    public static final void a(C0 c0, C3389h c3389h, String str) {
        L4 l4 = c0.j;
        if (l4 != null) {
            ((M4) l4).c("C0", AbstractC3492o0.a("C0", "TAG", "updateAdForBlob ", c0));
        }
        c3389h.e(str);
        L4 l5 = c0.j;
        if (l5 != null) {
            ((M4) l5).c("C0", AbstractC3492o0.a("C0", "TAG", "updateAd ", c0));
        }
        C3418j0 c3418j0 = c0.u;
        if (c3418j0 != null) {
            c3418j0.a(c3389h);
        }
    }

    public void a(String blob, String str) {
        Intrinsics.checkNotNullParameter(blob, "blob");
        L4 l4 = this.j;
        if (l4 != null) {
            ((M4) l4).c("C0", AbstractC3492o0.a("C0", "TAG", "saveBlob ", this));
        }
        C3575u c3575u = this.C;
        int iHashCode = hashCode();
        B0 b0 = new B0(this, str, blob);
        c3575u.getClass();
        C3575u.a(iHashCode, b0);
    }

    public void a(String jsCallbackNamespace, String callback, M1 receiver, String str) {
        Intrinsics.checkNotNullParameter(jsCallbackNamespace, "jsCallbackNamespace");
        Intrinsics.checkNotNullParameter(callback, "callback");
        Intrinsics.checkNotNullParameter(receiver, "receiver");
        L4 l4 = this.j;
        if (l4 != null) {
            ((M4) l4).c("C0", AbstractC3492o0.a("C0", "TAG", "getBlob ", this));
        }
        C3575u c3575u = this.C;
        int iHashCode = hashCode();
        C3562t0 c3562t0 = new C3562t0(this, str, receiver, jsCallbackNamespace, callback);
        c3575u.getClass();
        C3575u.a(iHashCode, c3562t0);
    }

    @Override // com.inmobi.media.Pc
    public void a(C3389h primaryAd, boolean z, short s) {
        C3418j0 c3418j0;
        Intrinsics.checkNotNullParameter(primaryAd, "ad");
        L4 l4 = this.j;
        if (l4 != null) {
            ((M4) l4).c("C0", AbstractC3492o0.a("C0", "TAG", "onVastProcessCompleted ", this));
        }
        C3389h c3389hM = m();
        if (c3389hM == null || W()) {
            c3389hM = null;
        }
        if (c3389hM == null) {
            return;
        }
        L4 l5 = this.j;
        if (l5 != null) {
            ((M4) l5).c("C0", O5.a("C0", "TAG", "Vast processing completed for ad with impressionId : ").append(c3389hM.s()).toString());
        }
        String strU = c3389hM.u();
        int iHashCode = strU.hashCode();
        if (iHashCode != -1084172778) {
            if (iHashCode != 3213227) {
                if (iHashCode == 1236050372 && strU.equals("htmlUrl")) {
                    return;
                }
            } else if (strU.equals("html")) {
                return;
            }
        } else if (strU.equals("inmobiJson")) {
            if (this.f3036a == 2 && (c3418j0 = this.u) != null) {
                c3418j0.a(primaryAd);
                C3462m0 c3462m0P = p();
                String clientReqId = c3418j0.k();
                c3462m0P.getClass();
                Intrinsics.checkNotNullParameter(primaryAd, "primaryAd");
                Intrinsics.checkNotNullParameter(clientReqId, "clientReqId");
                Set<C3372fa> setY = primaryAd.y();
                if (setY.isEmpty()) {
                    c3462m0P.f3372a.a(c3462m0P.c, true, (short) 0);
                    return;
                }
                String string = UUID.randomUUID().toString();
                Intrinsics.checkNotNullExpressionValue(string, "toString(...)");
                C3431k c3431k = new C3431k(string, setY, c3462m0P.g, null, 16);
                String strF = primaryAd.f();
                if (strF != null) {
                    C3335d1 c3335d1 = C3335d1.f3289a;
                    C3335d1.a(c3431k, strF);
                    return;
                }
                return;
            }
            L4 l6 = this.j;
            if (l6 != null) {
                Intrinsics.checkNotNullExpressionValue("C0", "TAG");
                ((M4) l6).b("C0", "Found inconsistent state after vast processing");
                return;
            }
            return;
        }
        L4 l7 = this.j;
        if (l7 != null) {
            ((M4) l7).b("C0", O5.a("C0", "TAG", "Can not handle fallback for").append(c3389hM.u()).toString());
        }
        throw new IllegalStateException("Can not handle fallback for markup type: " + c3389hM.u());
    }
}
