package sg.bigo.ads.ad.interstitial;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Bitmap;
import android.graphics.drawable.GradientDrawable;
import android.os.SystemClock;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.webkit.RenderProcessGoneDetail;
import android.webkit.URLUtil;
import android.webkit.WebResourceError;
import android.webkit.WebResourceRequest;
import android.webkit.WebView;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.facebook.share.internal.ShareConstants;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import sg.bigo.ads.R;
import sg.bigo.ads.common.view.AdImageView;
import sg.bigo.ads.common.view.AutoNextLineLinearLayout;
import sg.bigo.ads.common.view.RoundedFrameLayout;

/* JADX INFO: loaded from: classes5.dex */
public final class p {
    final d A;
    final e B;
    c C;
    private final f F;
    private Runnable G;
    private Runnable H;
    private View I;
    private int M;
    private long N;
    private boolean O;
    private Runnable P;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final Context f12896a;
    final sg.bigo.ads.ad.b.c b;
    final sg.bigo.ads.api.core.c c;
    final sg.bigo.ads.api.a.m d;
    Runnable e;
    FrameLayout f;
    FrameLayout g;
    AlertDialog h;
    boolean o;
    boolean p;
    int q;
    long s;
    List<Integer> t;
    long u;
    Runnable v;
    Runnable w;
    Runnable x;
    final a z;
    boolean i = true;
    private boolean J = false;
    boolean j = false;
    private boolean K = false;
    boolean k = false;
    boolean l = false;
    boolean m = false;
    boolean n = false;
    int r = 0;
    private long L = -1;
    private final List<Runnable> Q = new ArrayList();
    public final b y = new b();
    boolean D = false;
    int E = 0;

    static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f12922a;
        boolean b;
        boolean c;
        boolean d;
        boolean e;
        int f;
        boolean g;
        int h;
        boolean i;
        int j;
        float k;
        float l;
        View m;
        View n;
        View o;
        p p;
        final Map<View, sg.bigo.ads.core.adview.h> q;
        final sg.bigo.ads.core.adview.h r;

        private a() {
            this.f12922a = 0;
            this.q = new HashMap();
            this.r = new sg.bigo.ads.core.adview.h() { // from class: sg.bigo.ads.ad.interstitial.p.a.1
                @Override // sg.bigo.ads.core.adview.h
                public final void a(int i, int i2, int i3, int i4, int i5, int i6) {
                    sg.bigo.ads.common.t.a.a(0, 3, "InterstitialMidPageRenderer", "Disable click by style config.");
                }
            };
        }

        /* synthetic */ a(byte b) {
            this();
        }

        static /* synthetic */ View a(a aVar, View view, float f, float f2) {
            ArrayList arrayList = new ArrayList();
            aVar.a(view, f, f2, 0, new int[2], arrayList);
            if (arrayList.size() > 0) {
                return arrayList.get(arrayList.size() - 1);
            }
            return null;
        }

        private void a(View view, float f, float f2, int i, int[] iArr, List<View> list) {
            if (i > 10) {
                return;
            }
            int i2 = i + 1;
            if (view == null) {
                return;
            }
            view.getLocationOnScreen(iArr);
            int i3 = iArr[0];
            int i4 = iArr[1];
            if (f > i3 && f < i3 + view.getWidth() && f2 > i4 && f2 < i4 + view.getHeight() && (view.getTag() instanceof Integer) && this.q.containsKey(view)) {
                list.add(view);
            }
            if (view instanceof ViewGroup) {
                ViewGroup viewGroup = (ViewGroup) view;
                int childCount = viewGroup.getChildCount();
                for (int i5 = 0; i5 < childCount; i5++) {
                    a(viewGroup.getChildAt(i5), f, f2, i2, iArr, list);
                }
            }
        }

        private void a(final sg.bigo.ads.ad.b.c cVar, final View view, final int i) {
            final int scaledTouchSlop = ViewConfiguration.get(view.getContext()).getScaledTouchSlop();
            view.setOnTouchListener(new View.OnTouchListener() { // from class: sg.bigo.ads.ad.interstitial.p.a.2

                /* JADX INFO: renamed from: a, reason: collision with root package name */
                boolean f12924a;
                int b;
                int c;
                final /* synthetic */ int h = 11;

                private View a(float f) {
                    if (f < a.this.h) {
                        return a.this.n;
                    }
                    if (a.this.f <= 0 || f <= a.this.j - a.this.f) {
                        return null;
                    }
                    return a.this.o;
                }

                /* JADX WARN: Code duplicated, block: B:69:0x0165 A[DONT_INVERT] */
                /* JADX WARN: Code duplicated, block: B:70:0x0167  */
                /* JADX WARN: Code duplicated, block: B:71:0x016d  */
                /*  JADX ERROR: JadxRuntimeException in pass: RegionMakerVisitor
                    jadx.core.utils.exceptions.JadxRuntimeException: Not found exit edge by exit block: B:74:0x019a
                    	at jadx.core.dex.visitors.regions.maker.LoopRegionMaker.checkLoopExits(LoopRegionMaker.java:272)
                    	at jadx.core.dex.visitors.regions.maker.LoopRegionMaker.makeLoopRegion(LoopRegionMaker.java:237)
                    	at jadx.core.dex.visitors.regions.maker.LoopRegionMaker.process(LoopRegionMaker.java:80)
                    	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:92)
                    	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
                    	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:111)
                    	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
                    	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
                    	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:117)
                    	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
                    	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
                    	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:117)
                    	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
                    	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
                    	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:111)
                    	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
                    	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
                    	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:111)
                    	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
                    	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
                    	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:117)
                    	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
                    	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
                    	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:117)
                    	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
                    	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
                    	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeMthRegion(RegionMaker.java:49)
                    	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:25)
                    */
                @Override // android.view.View.OnTouchListener
                public final boolean onTouch(android.view.View r17, android.view.MotionEvent r18) {
                    /*
                        Method dump skipped, instruction units count: 494
                        To view this dump change 'Code comments level' option to 'DEBUG'
                    */
                    throw new UnsupportedOperationException("Method not decompiled: sg.bigo.ads.ad.interstitial.p.a.AnonymousClass2.onTouch(android.view.View, android.view.MotionEvent):boolean");
                }
            });
        }

        private void a(sg.bigo.ads.ad.b.c cVar, View view, View view2, sg.bigo.ads.core.adview.h hVar, int i) {
            if (hVar == null) {
                view2.setOnTouchListener(null);
            } else {
                a(cVar, view, i);
            }
        }

        final sg.bigo.ads.core.adview.h a(final sg.bigo.ads.ad.b.c cVar, sg.bigo.ads.core.adview.h hVar) {
            return hVar == cVar ? new sg.bigo.ads.core.adview.h() { // from class: sg.bigo.ads.ad.interstitial.p.a.3
                @Override // sg.bigo.ads.core.adview.h
                public final void a(int i, int i2, int i3, int i4, int i5, int i6) {
                    a.this.p.m = true;
                    cVar.a(i, i2, i3, i4, i5, i6);
                }
            } : hVar;
        }

        final void a(sg.bigo.ads.ad.b.c cVar, View view, View view2, int i, sg.bigo.ads.core.adview.h hVar) {
            if (view.getTag() != null) {
                sg.bigo.ads.common.t.a.a(0, 3, "InterstitialMidPageRenderer", "Error that touch view exists another tag.");
            }
            view.setTag(R.id.content, "TouchView");
            view2.setTag(Integer.valueOf(i));
            if (hVar != null) {
                this.q.put(view2, hVar);
            }
            a(cVar, view, view2, hVar, this.f12922a);
        }
    }

    public class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        boolean f12926a = false;

        public b() {
        }

        private void b(Runnable runnable) {
            p.b(p.this);
            sg.bigo.ads.common.n.d.a(2, runnable);
        }

        public final boolean a() {
            if (p.this.i && !this.f12926a) {
                this.f12926a = true;
                Runnable runnable = p.this.w;
                if (runnable != null) {
                    sg.bigo.ads.common.t.a.a(0, 3, "InterstitialMidPageRenderer", "Show mid page due to close button pressed in main page.");
                    b(runnable);
                    return true;
                }
            }
            return false;
        }

        public final boolean a(Runnable runnable) {
            if (p.this.i && !this.f12926a) {
                this.f12926a = true;
                Runnable runnable2 = p.this.w;
                if (runnable2 == null && p.this.v != null) {
                    sg.bigo.ads.common.n.d.a(p.this.v);
                    runnable2 = p.this.v;
                    p.this.w = runnable2;
                }
                if (runnable2 != null) {
                    sg.bigo.ads.common.t.a.a(0, 3, "InterstitialMidPageRenderer", "Show mid page due to video completion.");
                    p.this.x = runnable;
                    b(runnable2);
                    return true;
                }
            }
            return false;
        }
    }

    public interface c {
        boolean a(Runnable runnable);
    }

    static class d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f12927a;
        int b;
        int c;

        private d() {
        }

        /* synthetic */ d(byte b) {
            this();
        }
    }

    static class e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        long f12928a;
        boolean b;
        private boolean c;
        private final Map<Integer, Long> d;

        private e() {
            this.d = new HashMap();
        }

        /* synthetic */ e(byte b) {
            this();
        }

        public static int a(int i, boolean z) {
            if (i == 1) {
                return z ? 2 : 1;
            }
            if (i == 2) {
                return 4;
            }
            if (i == 3) {
                return 3;
            }
            if (i == 4) {
                return 5;
            }
            return i == 5 ? 6 : 0;
        }

        private static int a(String str, int i) {
            return (str + i).hashCode();
        }

        public final void a(sg.bigo.ads.api.core.c cVar, int i, String str, int i2) {
            if (TextUtils.isEmpty(str)) {
                return;
            }
            int iA = a(str, i2);
            if (this.d.get(Integer.valueOf(iA)) == null) {
                this.d.put(Integer.valueOf(iA), Long.valueOf(SystemClock.elapsedRealtime()));
                sg.bigo.ads.core.d.b.a(cVar, a(i, false), 1, String.valueOf(iA), 0L, false, 0, (String) null);
            }
        }

        public final void a(sg.bigo.ads.api.core.c cVar, int i, String str, int i2, int i3, String str2) {
            if (TextUtils.isEmpty(str)) {
                return;
            }
            int iA = a(str, i2);
            Long l = this.d.get(Integer.valueOf(iA));
            if (l == null) {
                return;
            }
            sg.bigo.ads.core.d.b.a(cVar, a(i, false), 6, String.valueOf(iA), SystemClock.elapsedRealtime() - l.longValue(), true, i3, str2);
        }

        public final void a(sg.bigo.ads.api.core.c cVar, boolean z, int i, String str) {
            if (this.c || this.f12928a <= 0) {
                return;
            }
            this.c = true;
            sg.bigo.ads.core.d.b.a(cVar, a(1, z), 4, (String) null, SystemClock.elapsedRealtime() - this.f12928a, true, i, str);
        }

        public final void b(sg.bigo.ads.api.core.c cVar, int i, String str, int i2) {
            if (TextUtils.isEmpty(str)) {
                return;
            }
            int iA = a(str, i2);
            Long l = this.d.get(Integer.valueOf(iA));
            if (l == null) {
                return;
            }
            sg.bigo.ads.core.d.b.a(cVar, a(i, false), 5, String.valueOf(iA), SystemClock.elapsedRealtime() - l.longValue(), false, 0, (String) null);
        }
    }

    public p(Context context, sg.bigo.ads.ad.b.c cVar, sg.bigo.ads.api.core.c cVar2, sg.bigo.ads.api.a.m mVar, boolean z, f fVar, Runnable runnable, Runnable runnable2, Runnable runnable3) {
        byte b2 = 0;
        this.o = false;
        this.z = new a(b2);
        this.A = new d(b2);
        this.B = new e(b2);
        this.f12896a = context;
        this.b = cVar;
        this.c = cVar2;
        this.F = fVar;
        this.d = mVar;
        this.o = z;
        this.e = runnable;
        this.G = runnable2;
        this.H = runnable3;
    }

    /* JADX WARN: Code duplicated, block: B:160:0x0418  */
    private View a(Context context, sg.bigo.ads.ad.b.c cVar, final sg.bigo.ads.api.core.c cVar2, boolean z) {
        String strC;
        String strA;
        String strA2;
        String str;
        String[] strArr;
        String[] strArrD;
        int i;
        TextView textView;
        TextView textView2;
        int i2;
        final String str2;
        View viewFindViewById;
        sg.bigo.ads.api.core.o.a aVarAu;
        String strN = cVar2.n();
        if (TextUtils.isEmpty(strN)) {
            return null;
        }
        sg.bigo.ads.api.core.c.d dVarQ = cVar2.q();
        if (dVarQ != null) {
            strC = dVarQ.a();
            strA = dVarQ.b();
            strA2 = dVarQ.c();
            String strF = dVarQ.f();
            String[] strArrE = dVarQ.e();
            strArrD = dVarQ.d();
            strArr = strArrE;
            str = strF;
        } else {
            strC = null;
            strA = null;
            strA2 = null;
            str = null;
            strArr = null;
            strArrD = null;
        }
        boolean z2 = cVar2 instanceof sg.bigo.ads.core.a.a;
        if (z2) {
            sg.bigo.ads.core.a.a aVar = (sg.bigo.ads.core.a.a) cVar2;
            if ((TextUtils.isEmpty(strC) || !URLUtil.isNetworkUrl(strC)) && (aVarAu = aVar.au()) != null) {
                strC = aVarAu.c();
            }
            if (TextUtils.isEmpty(strA)) {
                strA = aVar.s();
            }
            if (TextUtils.isEmpty(strA2)) {
                strA2 = aVar.t();
            }
            if (TextUtils.isEmpty(strC) || !URLUtil.isNetworkUrl(strC)) {
                if (aVar.aQ()) {
                    strC = sg.bigo.ads.common.o.b(context, aVar.aM());
                } else {
                    String strAS = aVar.aS();
                    if (!TextUtils.isEmpty(strAS) && URLUtil.isNetworkUrl(strAS)) {
                        strC = strAS;
                    }
                }
            }
        }
        if (TextUtils.isEmpty(strA)) {
            strA = sg.bigo.ads.common.utils.a.a(context, R.string.bigo_ad_title_default, new Object[0]);
        }
        String str3 = strA;
        if (TextUtils.isEmpty(strA2)) {
            strA2 = sg.bigo.ads.common.utils.a.a(context, R.string.bigo_ad_description_default, new Object[0]);
        }
        String str4 = strA2;
        String strC2 = (TextUtils.isEmpty(null) || sg.bigo.ads.common.utils.q.a() < 4.0f) ? sg.bigo.ads.ad.b.f.c(strN) : null;
        String strB = TextUtils.isEmpty(null) ? sg.bigo.ads.ad.b.f.b(strN) : null;
        String strA3 = TextUtils.isEmpty(null) ? sg.bigo.ads.ad.b.f.a(strN) : null;
        try {
            if (!this.o) {
                i = R.layout.bigo_ad_layout_interstitial_mid_page_native_view;
            } else if (z) {
                i = R.layout.bigo_ad_layout_interstitial_mid_page_native_view_landscape;
            } else {
                f fVar = this.F;
                i = (fVar == null || !fVar.d) ? R.layout.bigo_ad_layout_interstitial_mid_page_native_fallback_view_landscape : R.layout.bigo_ad_layout_interstitial_mid_page_native_fallback_view_download_info_landscape;
            }
            View viewA = sg.bigo.ads.common.utils.a.a(context, i, null, false);
            View viewFindViewById2 = viewA == null ? null : viewA.findViewById(R.id.inter_mid_native_view);
            if (viewFindViewById2 == null) {
                return viewA;
            }
            final AdImageView adImageView = (AdImageView) viewFindViewById2.findViewById(R.id.inter_iv_icon);
            TextView textView3 = (TextView) viewFindViewById2.findViewById(R.id.inter_tv_title);
            TextView textView4 = (TextView) viewFindViewById2.findViewById(R.id.inter_tv_desc);
            TextView textView5 = (TextView) viewFindViewById2.findViewById(R.id.inter_tv_desc_below);
            TextView textView6 = (TextView) viewFindViewById2.findViewById(R.id.inter_tv_company_name);
            View viewFindViewById3 = viewFindViewById2.findViewById(R.id.inter_ll_start_rate);
            TextView textView7 = (TextView) viewFindViewById2.findViewById(R.id.inter_tv_start_rate);
            TextView textView8 = (TextView) viewFindViewById2.findViewById(R.id.inter_tv_comment);
            TextView textView9 = (TextView) viewFindViewById2.findViewById(R.id.inter_tv_download_num);
            View viewFindViewById4 = viewFindViewById2.findViewById(R.id.inter_tv_download_num_desc);
            TextView textView10 = (TextView) viewFindViewById2.findViewById(R.id.inter_tv_age);
            View viewFindViewById5 = viewFindViewById2.findViewById(R.id.inter_iv_age);
            View viewFindViewById6 = viewFindViewById2.findViewById(R.id.bigo_ad_btn_cta);
            View viewFindViewById7 = viewFindViewById2.findViewById(R.id.bigo_ad_btn_cta_inner);
            View viewFindViewById8 = viewFindViewById2.findViewById(R.id.inter_tv_gp_info_extra_about);
            View viewFindViewById9 = viewFindViewById2.findViewById(R.id.inter_iv_gp_info_extra_arrow);
            ViewGroup viewGroup = (ViewGroup) viewFindViewById2.findViewById(R.id.inter_ll_media);
            AutoNextLineLinearLayout autoNextLineLinearLayout = (AutoNextLineLinearLayout) viewFindViewById2.findViewById(R.id.inter_fbl_genre);
            RoundedFrameLayout roundedFrameLayout = (RoundedFrameLayout) viewFindViewById2.findViewById(R.id.inter_fl_icon);
            String str5 = strB;
            String str6 = strA3;
            if (roundedFrameLayout != null) {
                roundedFrameLayout.setStrokeWidth(sg.bigo.ads.common.utils.e.a(context, 1));
                roundedFrameLayout.setStrokeColor(sg.bigo.ads.common.utils.q.b("#05000000", -7829368));
            }
            int iA = r.a(cVar, this.A.c, null);
            if (z && (viewFindViewById = viewFindViewById2.findViewById(R.id.inter_ll_native_extra)) != null) {
                viewFindViewById.setVisibility(0);
            }
            if (TextUtils.isEmpty(strC) || adImageView == null) {
                textView = textView4;
                textView2 = textView3;
            } else {
                adImageView.setIconTag(true);
                adImageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
                adImageView.setBackgroundColor(sg.bigo.ads.common.utils.q.b("#FFE1E1E6", -7829368));
                adImageView.setImageDrawable(sg.bigo.ads.common.utils.a.a(context, R.drawable.bigo_ad_icon_default_only_icon));
                final ArrayList arrayList = new ArrayList();
                sg.bigo.ads.common.p.g gVar = new sg.bigo.ads.common.p.g() { // from class: sg.bigo.ads.ad.interstitial.p.4
                    @Override // sg.bigo.ads.common.p.g
                    public final void a(int i3, String str7, String str8) {
                    }

                    @Override // sg.bigo.ads.common.p.g
                    public final void a(Bitmap bitmap, sg.bigo.ads.common.p.f fVar2) {
                        adImageView.setBackground(null);
                    }
                };
                adImageView.a(gVar);
                arrayList.add(gVar);
                a(new Runnable() { // from class: sg.bigo.ads.ad.interstitial.p.5
                    @Override // java.lang.Runnable
                    public final void run() {
                        arrayList.clear();
                        adImageView.a();
                    }
                });
                adImageView.a(strC, cVar2.al());
                textView = textView4;
                textView2 = textView3;
                a(viewFindViewById2, adImageView, 1, cVar, cVar);
            }
            if (!TextUtils.isEmpty(str3) && textView2 != null) {
                textView2.setText(str3);
                a(viewFindViewById2, textView2, 2, cVar, cVar);
            }
            if (!TextUtils.isEmpty(str4)) {
                TextView textView11 = textView;
                if (textView11 != null) {
                    textView11.setText(str4);
                    a(viewFindViewById2, textView11, 6, cVar, cVar);
                }
                if (z && textView5 != null) {
                    textView5.setText(str4);
                    a(viewFindViewById2, textView5, 6, cVar, cVar);
                }
            }
            if (TextUtils.isEmpty(str) || textView6 == null) {
                i2 = iA;
            } else {
                textView6.setVisibility(0);
                textView6.setText(str);
                i2 = iA;
                textView6.setTextColor(i2);
                a(viewFindViewById2, textView6, 26, cVar, cVar);
            }
            if (!TextUtils.isEmpty(strC2) && textView7 != null) {
                textView7.setText(strC2);
                a(viewFindViewById2, textView7, 26, cVar, cVar);
            }
            if (viewFindViewById3 != null) {
                a(viewFindViewById2, viewFindViewById3, 26, cVar, cVar);
            }
            if (!TextUtils.isEmpty(str5) && str5 != 0) {
                textView8.setText(str5 + " " + sg.bigo.ads.common.utils.a.a(context, R.string.bigo_ad_comment_num_text, new Object[0]));
                a(viewFindViewById2, textView8, 26, cVar, cVar);
            }
            if (!TextUtils.isEmpty(str6) && textView9 != null) {
                textView9.setText(str6);
                a(viewFindViewById2, textView9, 26, cVar, cVar);
            }
            if (viewFindViewById4 != null) {
                a(viewFindViewById2, viewFindViewById4, 26, cVar, cVar);
            }
            if (!TextUtils.isEmpty("Everyone") && textView10 != null) {
                textView10.setText("Everyone");
                a(viewFindViewById2, textView10, 26, cVar, cVar);
            }
            if (viewFindViewById5 != null) {
                a(viewFindViewById2, viewFindViewById5, 26, cVar, cVar);
            }
            if (viewFindViewById6 != null) {
                if (viewFindViewById7 != null) {
                    viewFindViewById7.setBackgroundColor(i2);
                }
                a(viewFindViewById2, viewFindViewById6, 7, cVar, cVar);
            }
            if (z && strArr != null && strArr.length > 0 && viewGroup != null) {
                a(context, viewGroup, cVar, cVar2, strArr);
            }
            if (!z && z2) {
                RoundedFrameLayout roundedFrameLayout2 = (RoundedFrameLayout) viewFindViewById2.findViewById(R.id.inter_ll_fallback_media);
                boolean z3 = false;
                if (roundedFrameLayout2 != null) {
                    roundedFrameLayout2.setVisibility(0);
                }
                final AdImageView adImageView2 = (AdImageView) viewFindViewById2.findViewById(R.id.inter_iv_fallback_media);
                if (adImageView2 != null) {
                    sg.bigo.ads.core.a.a aVar2 = (sg.bigo.ads.core.a.a) cVar2;
                    String strAS2 = aVar2.aS();
                    if (!TextUtils.isEmpty(strAS2) && URLUtil.isNetworkUrl(strAS2)) {
                        str2 = strAS2;
                    } else if (aVar2.aQ()) {
                        String strB2 = sg.bigo.ads.common.o.b(context, aVar2.aM());
                        if (TextUtils.isEmpty(strB2)) {
                            str2 = null;
                        } else {
                            str2 = strB2;
                            z3 = true;
                        }
                    } else {
                        str2 = null;
                    }
                    if (!TextUtils.isEmpty(str2)) {
                        final ArrayList arrayList2 = new ArrayList();
                        if (!z3) {
                            this.B.a(cVar2, 4, str2, -1);
                        }
                        sg.bigo.ads.common.p.g gVar2 = new sg.bigo.ads.common.p.g() { // from class: sg.bigo.ads.ad.interstitial.p.6
                            @Override // sg.bigo.ads.common.p.g
                            public final void a(int i3, String str7, String str8) {
                                p.this.B.a(cVar2, 4, str2, -1, i3, str7);
                            }

                            @Override // sg.bigo.ads.common.p.g
                            public final void a(Bitmap bitmap, sg.bigo.ads.common.p.f fVar2) {
                                p.this.B.b(cVar2, 4, str2, -1);
                            }
                        };
                        adImageView2.a(gVar2);
                        arrayList2.add(gVar2);
                        a(new Runnable() { // from class: sg.bigo.ads.ad.interstitial.p.7
                            @Override // java.lang.Runnable
                            public final void run() {
                                arrayList2.clear();
                                adImageView2.a();
                            }
                        });
                        roundedFrameLayout2.setStrokeWidth(sg.bigo.ads.common.utils.e.a(context, 1));
                        roundedFrameLayout2.setStrokeColor(sg.bigo.ads.common.utils.q.b("#08000000", -7829368));
                        adImageView2.a(str2, cVar2.al());
                        a(viewFindViewById2, adImageView2, 5, cVar, this.z.c ? cVar : this.z.r);
                    }
                }
            }
            if (strArrD != 0) {
                String[] strArr2 = strArrD;
                if (strArr2.length > 0 && autoNextLineLinearLayout != null) {
                    a(context, viewFindViewById2, cVar, autoNextLineLinearLayout, strArr2);
                }
            }
            if (viewFindViewById8 != null) {
                a(viewFindViewById2, viewFindViewById8, 27, cVar, this.z.b ? cVar : this.z.r);
            }
            if (viewFindViewById9 != null) {
                a(viewFindViewById2, viewFindViewById9, 27, cVar, this.z.b ? cVar : this.z.r);
            }
            a(viewFindViewById2, viewFindViewById2, 18, cVar, this.z.b ? cVar : this.z.r);
            return viewA;
        } catch (Throwable unused) {
            return null;
        }
    }

    private FrameLayout a(Context context, View view, boolean z) {
        int i;
        FrameLayout frameLayout = new FrameLayout(context);
        int i2 = this.A.b;
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, z ? -1 : -2);
        if (i2 == 1) {
            int iA = sg.bigo.ads.common.utils.e.a(context, 10);
            layoutParams.topMargin = iA;
            layoutParams.bottomMargin = iA;
            layoutParams.leftMargin = iA;
            layoutParams.rightMargin = iA;
            i = 17;
        } else {
            layoutParams.topMargin = sg.bigo.ads.common.utils.e.a(context, 40);
            i = 80;
        }
        layoutParams.gravity = i;
        frameLayout.addView(view, layoutParams);
        return frameLayout;
    }

    private static LinearLayout a(Context context, View view, int i) {
        LinearLayout linearLayout = new LinearLayout(context);
        linearLayout.setOrientation(1);
        FrameLayout frameLayout = new FrameLayout(context);
        frameLayout.setBackgroundColor(sg.bigo.ads.common.utils.q.b("#F0F3F4", -7829368));
        ImageView imageView = new ImageView(context);
        imageView.setId(R.id.bigo_ad_btn_close);
        imageView.setImageDrawable(sg.bigo.ads.common.utils.a.a(context, R.drawable.bigo_ad_ic_close_gray_light));
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(sg.bigo.ads.common.utils.e.a(context, 24), sg.bigo.ads.common.utils.e.a(context, 24), 21);
        layoutParams.rightMargin = sg.bigo.ads.common.utils.e.a(context, 20);
        frameLayout.addView(imageView, layoutParams);
        linearLayout.addView(frameLayout, new LinearLayout.LayoutParams(-1, sg.bigo.ads.common.utils.e.a(context, 48)));
        linearLayout.addView(view, new LinearLayout.LayoutParams(-1, i));
        return linearLayout;
    }

    private void a(Context context, View view, sg.bigo.ads.ad.b.c cVar, AutoNextLineLinearLayout autoNextLineLinearLayout, String[] strArr) {
        for (String str : strArr) {
            try {
                if (!TextUtils.isEmpty(str)) {
                    TextView textView = new TextView(context);
                    textView.setText(str);
                    textView.setTextColor(sg.bigo.ads.common.utils.q.b("#5F6367", -7829368));
                    textView.setTextSize(13.0f);
                    textView.setPadding(sg.bigo.ads.common.utils.e.a(context, 12), sg.bigo.ads.common.utils.e.a(context, 5), sg.bigo.ads.common.utils.e.a(context, 12), sg.bigo.ads.common.utils.e.a(context, 5));
                    textView.setGravity(17);
                    GradientDrawable gradientDrawable = new GradientDrawable();
                    gradientDrawable.setShape(0);
                    gradientDrawable.setColor(-1);
                    gradientDrawable.setStroke(sg.bigo.ads.common.utils.e.a(context, 1), sg.bigo.ads.common.utils.q.b("#DBDDE0", -7829368));
                    gradientDrawable.setCornerRadius(sg.bigo.ads.common.utils.e.a(context, 14));
                    textView.setBackground(gradientDrawable);
                    LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, sg.bigo.ads.common.utils.e.a(context, 28));
                    layoutParams.topMargin = sg.bigo.ads.common.utils.e.a(context, 12);
                    layoutParams.rightMargin = sg.bigo.ads.common.utils.e.a(context, 12);
                    a(view, textView, 27, cVar, cVar);
                    autoNextLineLinearLayout.addView(textView, layoutParams);
                }
            } catch (Exception unused) {
                return;
            }
        }
    }

    private void a(Context context, ViewGroup viewGroup, sg.bigo.ads.ad.b.c cVar, final sg.bigo.ads.api.core.c cVar2, String[] strArr) {
        String[] strArr2;
        LinearLayout linearLayout;
        String[] strArr3 = strArr;
        LinearLayout linearLayout2 = new LinearLayout(context);
        linearLayout2.setOrientation(0);
        final ArrayList arrayList = new ArrayList();
        int i = 0;
        while (i < strArr3.length) {
            final String str = strArr3[i];
            if (TextUtils.isEmpty(str) || !URLUtil.isNetworkUrl(str)) {
                strArr2 = strArr3;
                linearLayout = linearLayout2;
            } else {
                final int iA = sg.bigo.ads.common.utils.e.a(context, 200);
                final RoundedFrameLayout roundedFrameLayout = new RoundedFrameLayout(context);
                roundedFrameLayout.setCornerRadius(sg.bigo.ads.common.utils.e.a(context, 4));
                roundedFrameLayout.setStrokeWidth(sg.bigo.ads.common.utils.e.a(context, 1));
                roundedFrameLayout.setStrokeColor(sg.bigo.ads.common.utils.q.b("#08000000", -7829368));
                final AdImageView adImageView = new AdImageView(context);
                adImageView.setBackgroundColor(sg.bigo.ads.common.utils.q.b("#FFE1E1E6", -7829368));
                adImageView.setImageDrawable(sg.bigo.ads.common.utils.a.a(context, R.drawable.bigo_ad_icon_default_only_icon));
                this.B.a(cVar2, 2, str, i);
                LinearLayout linearLayout3 = linearLayout2;
                final int i2 = i;
                sg.bigo.ads.common.p.g gVar = new sg.bigo.ads.common.p.g() { // from class: sg.bigo.ads.ad.interstitial.p.8
                    @Override // sg.bigo.ads.common.p.g
                    public final void a(int i3, String str2, String str3) {
                        p.this.B.a(cVar2, 2, str, i2, i3, str2);
                    }

                    @Override // sg.bigo.ads.common.p.g
                    public final void a(Bitmap bitmap, sg.bigo.ads.common.p.f fVar) {
                        ViewGroup.LayoutParams layoutParams;
                        adImageView.setBackground(null);
                        int width = bitmap.getWidth();
                        int height = bitmap.getHeight();
                        if (width > 0 && height > 0 && (layoutParams = roundedFrameLayout.getLayoutParams()) != null) {
                            layoutParams.width = (width * iA) / height;
                        }
                        adImageView.setScaleType(ImageView.ScaleType.FIT_XY);
                        p.this.B.b(cVar2, 2, str, i2);
                    }
                };
                adImageView.a(gVar);
                arrayList.add(gVar);
                a(new Runnable() { // from class: sg.bigo.ads.ad.interstitial.p.9
                    @Override // java.lang.Runnable
                    public final void run() {
                        adImageView.a();
                    }
                });
                adImageView.a(str, cVar2.al());
                roundedFrameLayout.addView(adImageView, new FrameLayout.LayoutParams(-1, -1));
                a(viewGroup, roundedFrameLayout, 5, cVar, this.z.c ? cVar : this.z.r);
                LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(sg.bigo.ads.common.utils.e.a(context, 100), iA);
                layoutParams.leftMargin = i == 0 ? sg.bigo.ads.common.utils.e.a(context, 20) : sg.bigo.ads.common.utils.e.a(context, 12);
                strArr2 = strArr;
                if (i + 1 == strArr2.length) {
                    layoutParams.rightMargin = sg.bigo.ads.common.utils.e.a(context, 20);
                }
                linearLayout = linearLayout3;
                linearLayout.addView(roundedFrameLayout, layoutParams);
            }
            a(new Runnable() { // from class: sg.bigo.ads.ad.interstitial.p.10
                @Override // java.lang.Runnable
                public final void run() {
                    arrayList.clear();
                }
            });
            i++;
            strArr3 = strArr2;
            linearLayout2 = linearLayout;
        }
        View view = linearLayout2;
        a(viewGroup, viewGroup, 18, cVar, this.z.d ? cVar : this.z.r);
        viewGroup.addView(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(View view, View view2, int i, sg.bigo.ads.ad.b.c cVar, sg.bigo.ads.core.adview.h hVar) {
        a aVar = this.z;
        aVar.a(cVar, view, view2, i, aVar.a(cVar, hVar));
    }

    private void a(Runnable runnable) {
        this.Q.add(runnable);
    }

    /* JADX WARN: Code duplicated, block: B:29:0x0074  */
    /* JADX WARN: Multi-variable type inference failed */
    static /* synthetic */ void a(p pVar, final Context context, final sg.bigo.ads.ad.b.c cVar, final sg.bigo.ads.api.core.c cVar2) {
        p pVar2;
        p pVar3;
        String[] strArrE;
        String strConcat;
        boolean z;
        sg.bigo.ads.core.h.e eVarA;
        p pVar4 = pVar;
        int i = 0;
        int i2 = 0;
        while (!pVar4.J) {
            if (i2 > 10) {
                pVar4.a(cVar2);
                return;
            }
            int i3 = pVar4.M;
            List<Integer> list = pVar4.t;
            if (list == null || i3 >= list.size()) {
                sg.bigo.ads.common.t.a.a(0, 3, "InterstitialMidPageRenderer", "Failed to retrieve render way for index: " + i3 + ".");
                pVar4.a(cVar2);
                return;
            }
            Integer num = list.get(i3);
            pVar4.M++;
            int iIntValue = num.intValue();
            View viewA = null;
            if (iIntValue == 1) {
                sg.bigo.ads.common.t.a.a(i, 3, "InterstitialMidPageRenderer", "Start to render web view for mid page.");
                String strO = cVar2.o();
                if (TextUtils.isEmpty(strO) || !URLUtil.isNetworkUrl(strO)) {
                    strO = null;
                }
                if (TextUtils.isEmpty(strO)) {
                    String strN = cVar2.n();
                    if (TextUtils.isEmpty(strN)) {
                        strConcat = strO;
                        z = i;
                    } else {
                        strConcat = "https://play.google.com/store/apps/details?id=".concat(String.valueOf(strN));
                        z = 1;
                    }
                } else {
                    strConcat = strO;
                    z = i;
                }
                if (TextUtils.isEmpty(strConcat) || (eVarA = sg.bigo.ads.core.h.e.a(context)) == null) {
                    pVar2 = pVar4;
                    i2 = i2;
                } else {
                    pVar.a(eVarA, eVarA, 28, cVar, cVar);
                    final boolean z2 = z;
                    eVarA.setWebViewClient(new sg.bigo.ads.core.h.d() { // from class: sg.bigo.ads.ad.interstitial.p.13

                        /* JADX INFO: renamed from: a, reason: collision with root package name */
                        boolean f12902a = false;

                        @Override // sg.bigo.ads.core.h.d
                        public final void a(RenderProcessGoneDetail renderProcessGoneDetail) {
                            sg.bigo.ads.core.d.b.a(3002, 10105, "[MidPage] The render process was gone.");
                            if (this.f12902a) {
                                return;
                            }
                            this.f12902a = true;
                            p.a(p.this, context, cVar, cVar2, 1);
                            p.this.B.a(cVar2, z2, -1, "onRenderProcessGone");
                        }

                        @Override // sg.bigo.ads.core.h.d, android.webkit.WebViewClient
                        public final void onPageFinished(WebView webView, String str) {
                            super.onPageFinished(webView, str);
                            sg.bigo.ads.common.t.a.a(0, 3, "InterstitialMidPageRenderer", "onPageFinished  ".concat(String.valueOf(str)));
                            if (this.f12902a) {
                                return;
                            }
                            this.f12902a = true;
                            p.this.a(1, z2);
                            e eVar = p.this.B;
                            sg.bigo.ads.api.core.c cVar3 = cVar2;
                            boolean z3 = z2;
                            if (eVar.b || eVar.f12928a <= 0) {
                                return;
                            }
                            eVar.b = true;
                            sg.bigo.ads.core.d.b.a(cVar3, e.a(1, z3), 3, (String) null, SystemClock.elapsedRealtime() - eVar.f12928a, false, 0, (String) null);
                        }

                        @Override // android.webkit.WebViewClient
                        public final void onPageStarted(WebView webView, String str, Bitmap bitmap) {
                            super.onPageStarted(webView, str, bitmap);
                            sg.bigo.ads.common.t.a.a(0, 3, "InterstitialMidPageRenderer", "onPageStarted ".concat(String.valueOf(str)));
                        }

                        @Override // sg.bigo.ads.core.h.d, android.webkit.WebViewClient
                        public final void onReceivedError(WebView webView, WebResourceRequest webResourceRequest, WebResourceError webResourceError) {
                            e eVar;
                            sg.bigo.ads.api.core.c cVar3;
                            int i4;
                            boolean z3;
                            super.onReceivedError(webView, webResourceRequest, webResourceError);
                            String string = "onReceivedError";
                            sg.bigo.ads.common.t.a.a(0, 3, "InterstitialMidPageRenderer", "onReceivedError");
                            if (this.f12902a) {
                                return;
                            }
                            this.f12902a = true;
                            p.a(p.this, context, cVar, cVar2, 1);
                            if (webResourceError == null) {
                                eVar = p.this.B;
                                cVar3 = cVar2;
                                z3 = z2;
                                i4 = -1;
                            } else {
                                CharSequence description = webResourceError.getDescription();
                                e eVar2 = p.this.B;
                                sg.bigo.ads.api.core.c cVar4 = cVar2;
                                boolean z4 = z2;
                                int errorCode = webResourceError.getErrorCode();
                                string = description == null ? "null" : description.toString();
                                eVar = eVar2;
                                cVar3 = cVar4;
                                i4 = errorCode;
                                z3 = z4;
                            }
                            eVar.a(cVar3, z3, i4, string);
                        }

                        @Override // android.webkit.WebViewClient
                        public final boolean shouldOverrideUrlLoading(WebView webView, String str) {
                            return true;
                        }
                    });
                    e eVar = pVar4.B;
                    if (eVar.f12928a <= 0) {
                        eVar.f12928a = SystemClock.elapsedRealtime();
                        sg.bigo.ads.core.d.b.a(cVar2, e.a(1, z), 1, (String) null, 0L, false, 0, (String) null);
                    }
                    eVarA.loadUrl(strConcat);
                    viewA = a(context, eVarA, -2);
                    pVar2 = pVar4;
                }
            } else {
                i2 = i2;
                if (iIntValue == 2) {
                    sg.bigo.ads.common.t.a.a(0, 3, "InterstitialMidPageRenderer", "Start to render native view for mid page.");
                    sg.bigo.ads.api.core.c.d dVarQ = cVar2.q();
                    if (dVarQ != null && (strArrE = dVarQ.e()) != null && strArrE.length > 0 && (viewA = pVar4.a(context, cVar, cVar2, true)) != null) {
                        pVar4.a(2, false);
                    }
                    pVar2 = pVar4;
                } else if (iIntValue == 3) {
                    sg.bigo.ads.common.t.a.a(0, 3, "InterstitialMidPageRenderer", "Start to render image view for mid page.");
                    final String strP = cVar2.p();
                    if (TextUtils.isEmpty(strP) || !URLUtil.isNetworkUrl(strP)) {
                        pVar2 = pVar;
                    } else {
                        final ImageView imageView = new ImageView(context);
                        FrameLayout frameLayout = new FrameLayout(context);
                        frameLayout.setBackgroundColor(-1);
                        frameLayout.addView(imageView, new FrameLayout.LayoutParams(-1, -1, 17));
                        RoundedFrameLayout roundedFrameLayout = new RoundedFrameLayout(context);
                        roundedFrameLayout.setId(R.id.bigo_ad_btn_close);
                        roundedFrameLayout.setCornerRadius(sg.bigo.ads.common.utils.e.a(context, 12));
                        View view = new View(context);
                        view.setBackgroundColor(sg.bigo.ads.common.utils.q.b("#33000000", -7829368));
                        roundedFrameLayout.addView(view, new FrameLayout.LayoutParams(sg.bigo.ads.common.utils.e.a(context, 24), sg.bigo.ads.common.utils.e.a(context, 24), 17));
                        ImageView imageView2 = new ImageView(context);
                        imageView2.setBackground(sg.bigo.ads.common.utils.a.a(context, R.drawable.bigo_ad_ic_close));
                        roundedFrameLayout.addView(imageView2, new FrameLayout.LayoutParams(sg.bigo.ads.common.utils.e.a(context, 12), sg.bigo.ads.common.utils.e.a(context, 12), 17));
                        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(sg.bigo.ads.common.utils.e.a(context, 24), sg.bigo.ads.common.utils.e.a(context, 24), 53);
                        layoutParams.topMargin = sg.bigo.ads.common.utils.e.a(context, 18);
                        layoutParams.rightMargin = sg.bigo.ads.common.utils.e.a(context, 22);
                        frameLayout.addView(roundedFrameLayout, layoutParams);
                        final FrameLayout frameLayoutB = pVar4.b(context, frameLayout, true);
                        final FrameLayout frameLayout2 = new FrameLayout(context);
                        frameLayout2.addView(frameLayoutB, new FrameLayout.LayoutParams(-1, -2, pVar4.A.b != 1 ? 80 : 17));
                        pVar4.B.a(cVar2, 3, strP, 100);
                        sg.bigo.ads.common.p.e.a(cVar.b.e, strP, cVar2.al(), new sg.bigo.ads.common.p.g() { // from class: sg.bigo.ads.ad.interstitial.p.11
                            @Override // sg.bigo.ads.common.p.g
                            public final void a(int i4, String str, String str2) {
                                p.a(p.this, context, cVar, cVar2, 2);
                                p.this.B.a(cVar2, 3, strP, 100, i4, str);
                            }

                            @Override // sg.bigo.ads.common.p.g
                            public final void a(Bitmap bitmap, sg.bigo.ads.common.p.f fVar) {
                                final int width = bitmap.getWidth();
                                final int height = bitmap.getHeight();
                                frameLayout2.post(new Runnable() { // from class: sg.bigo.ads.ad.interstitial.p.11.1
                                    @Override // java.lang.Runnable
                                    public final void run() {
                                        int i4;
                                        int i5;
                                        int width2 = frameLayout2.getWidth();
                                        int height2 = frameLayout2.getHeight();
                                        ViewGroup.LayoutParams layoutParams2 = imageView.getLayoutParams();
                                        if (width2 <= 0 || height2 <= 0 || (i4 = width) <= 0 || (i5 = height) <= 0) {
                                            layoutParams2.width = -1;
                                            layoutParams2.height = -1;
                                            return;
                                        }
                                        if ((i4 * 1.0f) / i5 > (width2 * 1.0f) / height2) {
                                            layoutParams2.width = width2;
                                            layoutParams2.height = (width2 * height) / width;
                                        } else {
                                            layoutParams2.width = (i4 * height2) / i5;
                                            layoutParams2.height = height2;
                                        }
                                        imageView.requestLayout();
                                    }
                                });
                                imageView.setImageBitmap(bitmap);
                                p pVar5 = p.this;
                                pVar5.a(frameLayoutB, imageView, 5, cVar, pVar5.z.c ? cVar : p.this.z.r);
                                p pVar6 = p.this;
                                FrameLayout frameLayout3 = frameLayoutB;
                                pVar6.a(frameLayout3, frameLayout3, 18, cVar, pVar6.z.d ? cVar : p.this.z.r);
                                p.this.a(3, false);
                                p.this.B.b(cVar2, 3, strP, 100);
                            }
                        });
                        pVar2 = pVar;
                        viewA = frameLayout2;
                    }
                } else if (iIntValue == 4) {
                    sg.bigo.ads.common.t.a.a(0, 3, "InterstitialMidPageRenderer", "Start to render fallback view for mid page.");
                    pVar3 = pVar;
                    viewA = pVar3.a(context, cVar, cVar2, false);
                    if (viewA != null) {
                        pVar2 = pVar3;
                        pVar3.a(4, false);
                        pVar2 = pVar3;
                    }
                } else {
                    pVar2 = pVar;
                    sg.bigo.ads.common.t.a.a(0, 3, "InterstitialMidPageRenderer", "Error content view id.");
                }
            }
            if (viewA != null) {
                pVar2.I = viewA;
                return;
            } else {
                i2++;
                pVar4 = pVar2;
                i = 0;
            }
        }
        sg.bigo.ads.common.t.a.a(i, 3, "InterstitialMidPageRenderer", "Failed to retrieve render way for already.");
    }

    static /* synthetic */ void a(p pVar, final Context context, final sg.bigo.ads.ad.b.c cVar, final sg.bigo.ads.api.core.c cVar2, int i) {
        sg.bigo.ads.common.t.a.a(0, 3, "InterstitialMidPageRenderer", "Notify mid page content view render failed, try next render way.");
        pVar.r = i;
        sg.bigo.ads.common.n.d.b(new Runnable() { // from class: sg.bigo.ads.ad.interstitial.p.15
            @Override // java.lang.Runnable
            public final void run() {
                p.a(p.this, context, cVar, cVar2);
            }
        });
    }

    private void a(sg.bigo.ads.api.core.c cVar) {
        sg.bigo.ads.common.t.a.a(0, 3, "InterstitialMidPageRenderer", "All render way failed.");
        this.j = true;
        sg.bigo.ads.core.d.b.a(cVar, "0", e.a(this.q, this.p), this.r);
        e();
    }

    static /* synthetic */ boolean a(p pVar) {
        String str;
        String str2;
        final Context context = pVar.f12896a;
        final sg.bigo.ads.ad.b.c cVar = pVar.b;
        final sg.bigo.ads.api.core.c cVar2 = pVar.c;
        if (pVar.a(context, cVar, cVar2, pVar.d)) {
            final int i = pVar.q;
            final boolean z = pVar.p;
            sg.bigo.ads.common.t.a.a(0, 3, "InterstitialMidPageRenderer", "Try show mid page.");
            View view = pVar.I;
            boolean z2 = pVar.J;
            boolean z3 = pVar.j;
            if (z2 && view != null) {
                StringBuilder sb = new StringBuilder("Show mid page content, render way: ");
                if (i == 1) {
                    str2 = "WEB_VIEW";
                } else if (i == 2) {
                    str2 = "NATIVE";
                } else if (i == 3) {
                    str2 = ShareConstants.IMAGE_URL;
                } else if (i != 4) {
                    str2 = i != 5 ? "UNKNOWN" : "LOADING";
                } else {
                    str2 = "FALLBACK";
                }
                sg.bigo.ads.common.t.a.a(0, 3, "InterstitialMidPageRenderer", sb.append(str2).append(".").toString());
                if (pVar.j()) {
                    boolean z4 = pVar.q == 3;
                    final FrameLayout frameLayoutA = pVar.a(context, pVar.b(context, view, z4), z4);
                    pVar.K = true;
                    if (cVar2 instanceof sg.bigo.ads.core.a.a) {
                        ((sg.bigo.ads.core.a.a) cVar2).g(e.a(i, z));
                    }
                    sg.bigo.ads.common.n.d.b(new Runnable() { // from class: sg.bigo.ads.ad.interstitial.p.18
                        @Override // java.lang.Runnable
                        public final void run() {
                            p pVar2 = p.this;
                            Context context2 = context;
                            sg.bigo.ads.ad.b.c cVar3 = cVar;
                            sg.bigo.ads.api.core.c cVar4 = cVar2;
                            FrameLayout frameLayout = frameLayoutA;
                            if (!pVar2.l) {
                                pVar2.a(context2, cVar3, cVar4, frameLayout);
                                pVar2.f = frameLayout;
                                return;
                            }
                            FrameLayout frameLayout2 = pVar2.g;
                            if (frameLayout2 != null) {
                                frameLayout2.removeAllViews();
                                pVar2.a(frameLayout);
                                frameLayout2.addView(frameLayout, new FrameLayout.LayoutParams(-1, -1));
                            }
                            pVar2.f = frameLayout2;
                            pVar2.l = false;
                            if ((cVar4 instanceof sg.bigo.ads.core.a.a) && pVar2.s == 0) {
                                pVar2.s = SystemClock.elapsedRealtime();
                                ((sg.bigo.ads.core.a.a) cVar4).b(pVar2.s);
                            }
                            sg.bigo.ads.core.d.b.a(cVar4, "1", e.a(pVar2.q, pVar2.p), pVar2.r);
                        }
                    });
                }
                return true;
            }
            if (z3) {
                str = "Failed to show mid page due to unavailable.";
            } else {
                if (!z2 && view != null) {
                    sg.bigo.ads.common.t.a.a(0, 3, "InterstitialMidPageRenderer", "Show mid page loading.");
                    if (pVar.j()) {
                        final FrameLayout frameLayout = new FrameLayout(context);
                        View viewA = sg.bigo.ads.common.utils.a.a(context, pVar.o ? R.layout.bigo_ad_layout_interstitial_mid_page_loading_view_landscape : R.layout.bigo_ad_layout_interstitial_mid_page_loading_view, null, false);
                        if (viewA != null) {
                            pVar.l = true;
                            FrameLayout frameLayoutA2 = pVar.a(context, (View) pVar.b(context, a(context, viewA, -1), true), true);
                            frameLayout.addView(frameLayoutA2, new FrameLayout.LayoutParams(-1, -1));
                            pVar.a(viewA, viewA, 18, cVar, pVar.z.b ? cVar : pVar.z.r);
                            pVar.a(frameLayoutA2, frameLayoutA2, 18, cVar, pVar.z.b ? cVar : pVar.z.r);
                            pVar.g = frameLayout;
                            if (cVar2 instanceof sg.bigo.ads.core.a.a) {
                                ((sg.bigo.ads.core.a.a) cVar2).g(6);
                            }
                            pVar.q = 5;
                            sg.bigo.ads.common.n.d.b(new Runnable() { // from class: sg.bigo.ads.ad.interstitial.p.21
                                @Override // java.lang.Runnable
                                public final void run() {
                                    p.this.a(context, cVar, cVar2, frameLayout);
                                }
                            });
                        }
                    }
                    return true;
                }
                str = "Failed to show mid page due to unknown reason.";
            }
            sg.bigo.ads.common.t.a.a(0, "InterstitialMidPageRenderer", str);
        }
        return false;
    }

    private FrameLayout b(Context context, View view, boolean z) {
        int i = this.A.b;
        RoundedFrameLayout roundedFrameLayout = new RoundedFrameLayout(context);
        if (i == 1) {
            roundedFrameLayout.setCornerRadius(sg.bigo.ads.common.utils.e.a(context, 12));
        } else {
            roundedFrameLayout.a(sg.bigo.ads.common.utils.e.a(context, 12), sg.bigo.ads.common.utils.e.a(context, 12), sg.bigo.ads.common.utils.e.a(context, 0), sg.bigo.ads.common.utils.e.a(context, 0));
        }
        roundedFrameLayout.addView(view, new FrameLayout.LayoutParams(-1, z ? -1 : -2));
        return roundedFrameLayout;
    }

    static /* synthetic */ void b(p pVar) {
        pVar.v = null;
        pVar.w = null;
    }

    private void i() {
        Runnable runnable;
        if (this.y.f12926a) {
            if ((this.K || this.l) && this.n && (runnable = this.H) != null) {
                runnable.run();
                this.H = null;
            }
        }
    }

    private boolean j() {
        return (!this.i || this.K || this.k) ? false : true;
    }

    final void a() {
        if (this.P != null || this.L <= 0) {
            return;
        }
        Runnable runnable = new Runnable() { // from class: sg.bigo.ads.ad.interstitial.p.12
            @Override // java.lang.Runnable
            public final void run() {
                p pVar = p.this;
                pVar.j = true;
                pVar.h();
            }
        };
        this.P = runnable;
        sg.bigo.ads.common.n.d.a(2, runnable, this.L);
    }

    final void a(int i, boolean z) {
        sg.bigo.ads.common.t.a.a(0, 3, "InterstitialMidPageRenderer", "Notify mid page content view rendered.");
        this.J = true;
        this.q = i;
        this.p = z;
        if (this.l) {
            sg.bigo.ads.common.t.a.a(0, 3, "InterstitialMidPageRenderer", "Loading page is showing, turn to show mid page.");
            sg.bigo.ads.common.n.d.a(2, new Runnable() { // from class: sg.bigo.ads.ad.interstitial.p.14
                @Override // java.lang.Runnable
                public final void run() {
                    p.a(p.this);
                }
            });
        }
    }

    final void a(long j) {
        Runnable runnable = this.v;
        this.N = SystemClock.elapsedRealtime();
        sg.bigo.ads.common.n.d.a(runnable);
        sg.bigo.ads.common.n.d.a(2, runnable, j);
    }

    final void a(final Context context, final sg.bigo.ads.ad.b.c cVar, final sg.bigo.ads.api.core.c cVar2, final FrameLayout frameLayout) {
        Runnable runnable = new Runnable() { // from class: sg.bigo.ads.ad.interstitial.p.22
            @Override // java.lang.Runnable
            public final void run() {
                p.this.D = false;
                boolean zA = p.this.a(frameLayout);
                if ((cVar2 instanceof sg.bigo.ads.core.a.a) && p.this.s == 0) {
                    p.this.s = SystemClock.elapsedRealtime();
                    ((sg.bigo.ads.core.a.a) cVar2).b(p.this.s);
                }
                sg.bigo.ads.core.d.b.a(cVar2, "1", e.a(p.this.q, p.this.p), p.this.r);
                Context context2 = context;
                if (context2 instanceof Activity) {
                    Activity activity = (Activity) context2;
                    if (activity.isFinishing() || activity.isDestroyed()) {
                        return;
                    }
                }
                AlertDialog alertDialogCreate = new AlertDialog.Builder(context).setCancelable(!zA).setOnCancelListener(new DialogInterface.OnCancelListener() { // from class: sg.bigo.ads.ad.interstitial.p.22.1
                    @Override // android.content.DialogInterface.OnCancelListener
                    public final void onCancel(DialogInterface dialogInterface) {
                        p.this.k = true;
                        p.this.l = false;
                    }
                }).create();
                alertDialogCreate.requestWindowFeature(1);
                alertDialogCreate.show();
                Window window = alertDialogCreate.getWindow();
                window.getDecorView().setPadding(0, 0, 0, 0);
                window.setGravity(17);
                window.setContentView(frameLayout);
                WindowManager.LayoutParams attributes = window.getAttributes();
                attributes.width = -1;
                attributes.height = -1;
                window.setAttributes(attributes);
                p.this.h = alertDialogCreate;
                frameLayout.setVisibility(4);
                frameLayout.post(new Runnable() { // from class: sg.bigo.ads.ad.interstitial.p.22.2
                    @Override // java.lang.Runnable
                    public final void run() {
                        int i = p.this.A.b;
                        frameLayout.setVisibility(0);
                        if (i == 1) {
                            sg.bigo.ads.ad.interstitial.c.d(frameLayout);
                        } else {
                            sg.bigo.ads.ad.interstitial.c.a(frameLayout, 400L, new sg.bigo.ads.common.utils.b.c());
                        }
                    }
                });
                p pVar = p.this;
                if (pVar.e != null) {
                    pVar.e.run();
                    pVar.e = null;
                    pVar.n = true;
                }
            }
        };
        c cVar3 = this.C;
        if (cVar3 != null) {
            this.D = cVar3.a(runnable);
        } else {
            runnable.run();
        }
    }

    final boolean a(Context context, sg.bigo.ads.ad.b.c cVar, sg.bigo.ads.api.core.c cVar2, sg.bigo.ads.api.a.m mVar) {
        String str;
        if (context == null) {
            str = "Invalid context.";
        } else if (cVar == null) {
            str = "Invalid native ad.";
        } else if (cVar2 == null) {
            str = "Invalid adData.";
        } else if (mVar == null) {
            str = "Invalid style config.";
        } else {
            if (!this.K) {
                return true;
            }
            str = "Mid page has been shown.";
        }
        sg.bigo.ads.common.t.a.a(0, 3, "InterstitialMidPageRenderer", str);
        return false;
    }

    final boolean a(FrameLayout frameLayout) {
        int iA;
        final View viewFindViewById = frameLayout.findViewById(R.id.bigo_ad_btn_cta);
        if (viewFindViewById != null && this.z.e) {
            sg.bigo.ads.ad.interstitial.c.e(viewFindViewById);
            a(new Runnable() { // from class: sg.bigo.ads.ad.interstitial.p.2
                @Override // java.lang.Runnable
                public final void run() {
                    viewFindViewById.clearAnimation();
                }
            });
        }
        final View viewFindViewById2 = frameLayout.findViewById(R.id.bigo_ad_btn_close);
        if (viewFindViewById2 == null) {
            return false;
        }
        viewFindViewById2.setOnClickListener(new View.OnClickListener() { // from class: sg.bigo.ads.ad.interstitial.p.19
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                p.this.e();
            }
        });
        sg.bigo.ads.api.a.m mVar = this.d;
        if (mVar != null) {
            iA = mVar.a("mid_page.force_staying_time");
            if (iA < 0 || iA > 5) {
                iA = 3;
            }
        } else {
            iA = 0;
        }
        if (iA == 0) {
            viewFindViewById2.setVisibility(0);
            return true;
        }
        viewFindViewById2.setVisibility(4);
        sg.bigo.ads.common.n.d.a(2, new Runnable() { // from class: sg.bigo.ads.ad.interstitial.p.20
            @Override // java.lang.Runnable
            public final void run() {
                viewFindViewById2.setVisibility(0);
            }
        }, iA * 1000);
        return true;
    }

    public final void b() {
        sg.bigo.ads.common.t.a.a(0, 3, "InterstitialMidPageRenderer", "Disable mid page.");
        this.i = false;
    }

    /* JADX WARN: Code duplicated, block: B:11:0x0026  */
    public final void c() {
        boolean z;
        sg.bigo.ads.common.t.a.a(0, 3, "InterstitialMidPageRenderer", "Mid page resume.");
        sg.bigo.ads.api.a.m mVar = this.d;
        if (mVar != null) {
            z = mVar.a("endpage.is_endpage", 1) == 0 && !this.d.c("layer.is_show_layer") && -1 == this.E;
        }
        if (this.m && !z) {
            sg.bigo.ads.common.t.a.a(0, 3, "InterstitialMidPageRenderer", "Dismiss page after click.");
            sg.bigo.ads.common.n.d.a(2, new Runnable() { // from class: sg.bigo.ads.ad.interstitial.p.16
                @Override // java.lang.Runnable
                public final void run() {
                    p.this.f();
                }
            });
        } else {
            if (!this.O || this.u <= 0 || this.v == null) {
                return;
            }
            this.O = false;
            sg.bigo.ads.common.t.a.a(0, 3, "InterstitialMidPageRenderer", "Resume show task for " + this.u + " ms.");
            a(this.u);
        }
    }

    public final void d() {
        sg.bigo.ads.common.t.a.a(0, 3, "InterstitialMidPageRenderer", "Mid page pause.");
        Runnable runnable = this.v;
        if (this.O || this.u <= 0 || runnable == null) {
            return;
        }
        this.O = true;
        sg.bigo.ads.common.t.a.a(0, 3, "InterstitialMidPageRenderer", "Pause show task.");
        sg.bigo.ads.common.n.d.a(runnable);
        this.u -= SystemClock.elapsedRealtime() - this.N;
    }

    public final void e() {
        int i = this.A.b;
        final FrameLayout frameLayout = this.l ? this.g : this.f;
        if (frameLayout == null) {
            f();
            return;
        }
        sg.bigo.ads.common.utils.b.c cVar = new sg.bigo.ads.common.utils.b.c() { // from class: sg.bigo.ads.ad.interstitial.p.17
            @Override // sg.bigo.ads.common.utils.b.c, android.view.animation.Animation.AnimationListener
            public final void onAnimationEnd(Animation animation) {
                frameLayout.clearAnimation();
                frameLayout.setVisibility(8);
                p.this.f();
            }
        };
        if (i == 1) {
            sg.bigo.ads.ad.interstitial.c.c(frameLayout, cVar);
        } else {
            sg.bigo.ads.ad.interstitial.c.b(frameLayout, cVar);
        }
    }

    final void f() {
        if (this.h != null) {
            sg.bigo.ads.common.t.a.a(0, 3, "InterstitialMidPageRenderer", "Dismiss mid page.");
            this.h.dismiss();
            this.h = null;
            g();
            i();
        }
        h();
    }

    final void g() {
        Runnable runnable;
        if (!this.n || (runnable = this.G) == null) {
            return;
        }
        runnable.run();
        this.e = null;
    }

    final void h() {
        sg.bigo.ads.common.t.a.a(0, 3, "InterstitialMidPageRenderer", "Mid page clean unused resource.");
        Iterator<Runnable> it = this.Q.iterator();
        while (it.hasNext()) {
            it.next().run();
        }
        this.Q.clear();
        Runnable runnable = this.v;
        if (runnable != null) {
            sg.bigo.ads.common.n.d.a(runnable);
        }
        Runnable runnable2 = this.P;
        if (runnable2 != null) {
            sg.bigo.ads.common.n.d.a(runnable2);
        }
        this.v = null;
        this.w = null;
        this.k = true;
        this.f = null;
    }
}
