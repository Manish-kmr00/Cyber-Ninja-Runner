package com.fyber.inneractive.sdk.web;

import android.app.Activity;
import android.content.Context;
import android.graphics.Rect;
import android.os.Build;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.webkit.URLUtil;
import android.webkit.WebView;
import android.widget.FrameLayout;
import com.fyber.inneractive.sdk.R;
import com.fyber.inneractive.sdk.config.IAConfigManager;
import com.fyber.inneractive.sdk.config.enums.Orientation;
import com.fyber.inneractive.sdk.external.InneractiveAdRequest;
import com.fyber.inneractive.sdk.network.C3146w;
import com.fyber.inneractive.sdk.network.EnumC3144u;
import com.fyber.inneractive.sdk.ui.IAcloseButton;
import com.fyber.inneractive.sdk.util.AbstractC3251o;
import com.fyber.inneractive.sdk.util.AbstractC3256u;
import com.fyber.inneractive.sdk.util.IAlog;
import com.iab.omid.library.fyber.adsession.AdSession;
import com.iab.omid.library.fyber.adsession.FriendlyObstructionPurpose;
import com.iab.omid.library.fyber.adsession.Partner;
import com.json.b9;
import com.safedk.android.internal.partials.DTExchangeNetworkBridge;
import io.appmetrica.analytics.coreutils.internal.StringUtils;
import java.net.URI;
import java.net.URLDecoder;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Locale;
import java.util.Map;
import net.pubnative.lite.sdk.mraid.nativefeature.MRAIDNativeFeatureProvider;
import org.json.JSONArray;

/* JADX INFO: loaded from: classes13.dex */
public abstract class I extends j0 {
    public static final String[] o0 = {"yyyy-MM-dd'T'HH:mm:ssZZZZZ", "yyyy-MM-dd'T'HH:mmZZZZZ"};
    public com.fyber.inneractive.sdk.mraid.F N;
    public final EnumC3286z O;
    public final D P;
    public final C Q;
    public ViewGroup R;
    public C3274m S;
    public boolean T;
    public int U;
    public E V;
    public IAcloseButton W;
    public boolean X;
    public float Y;
    public int Z;
    public int a0;
    public int b0;
    public int c0;
    public int d0;
    public int e0;
    public Orientation f0;
    public int g0;
    public FrameLayout h0;
    public FrameLayout i0;
    public FrameLayout j0;
    public int k0;
    public int l0;
    public C3280t m0;
    public final ViewTreeObserverOnPreDrawListenerC3277p n0;

    public I(boolean z, C c, EnumC3286z enumC3286z, D d, com.fyber.inneractive.sdk.measurement.e eVar, com.fyber.inneractive.sdk.config.global.r rVar) {
        super(z, c, rVar);
        this.N = com.fyber.inneractive.sdk.mraid.F.HIDDEN;
        this.T = false;
        this.Z = -1;
        this.a0 = -1;
        this.b0 = -1;
        this.c0 = -1;
        this.d0 = -1;
        this.e0 = -1;
        this.f0 = Orientation.NONE;
        this.H = eVar;
        this.Q = c;
        this.O = enumC3286z;
        this.P = d;
        this.n0 = new ViewTreeObserverOnPreDrawListenerC3277p(this);
    }

    @Override // com.fyber.inneractive.sdk.web.AbstractC3270i, com.fyber.inneractive.sdk.web.InterfaceC3273l
    public void a(boolean z) {
        a(new com.fyber.inneractive.sdk.mraid.G(z));
        super.a(z);
    }

    @Override // com.fyber.inneractive.sdk.web.InterfaceC3273l
    public final void b() {
        com.fyber.inneractive.sdk.util.r.b.post(new r(this));
    }

    @Override // com.fyber.inneractive.sdk.web.InterfaceC3273l
    public final void c() {
        C3274m c3274m = this.b;
        if (c3274m != null && c3274m.getViewTreeObserver() != null) {
            this.b.getViewTreeObserver().removeOnPreDrawListener(this.n0);
        }
        com.fyber.inneractive.sdk.util.r.b.post(new RunnableC3279s(this));
    }

    public final void d(boolean z) {
        try {
            Activity activity = (Activity) AbstractC3251o.a(this.b);
            if (activity != null) {
                if (!z || activity.getResources() == null || activity.getResources().getConfiguration() == null) {
                    activity.setRequestedOrientation(this.U);
                } else {
                    activity.setRequestedOrientation(activity.getResources().getConfiguration().orientation);
                }
            }
        } catch (Exception unused) {
            IAlog.a("Failed to modify the device orientation.", new Object[0]);
        }
    }

    @Override // com.fyber.inneractive.sdk.web.AbstractC3270i
    public final com.fyber.inneractive.sdk.util.h0 g() {
        C3274m c3274m;
        return (this.N != com.fyber.inneractive.sdk.mraid.F.EXPANDED || (c3274m = this.S) == null) ? super.g() : c3274m.getLastClickedLocation();
    }

    @Override // com.fyber.inneractive.sdk.web.AbstractC3270i
    public final void h() {
        super.h();
        this.N = com.fyber.inneractive.sdk.mraid.F.LOADING;
        Context contextA = AbstractC3251o.a(this.b);
        this.U = contextA instanceof Activity ? ((Activity) contextA).getRequestedOrientation() : -1;
        this.i0 = new FrameLayout(contextA);
        this.j0 = new FrameLayout(contextA);
        FrameLayout frameLayout = new FrameLayout(contextA);
        frameLayout.setBackgroundColor(-858993460);
        this.h0 = frameLayout;
        a(contextA, false);
        this.b.setOnKeyListener(new ViewOnKeyListenerC3278q(this));
    }

    @Override // com.fyber.inneractive.sdk.web.j0
    public final void j() {
        C3274m c3274m = this.b;
        if (c3274m != null) {
            c3274m.a("window.mraidbridge.fireReadyEvent();");
        }
    }

    @Override // com.fyber.inneractive.sdk.web.j0
    public void k() {
        ArrayList arrayList = new ArrayList();
        C3274m c3274m = this.b;
        if (c3274m == null || c3274m.getScaleX() == 1.0f || this.b.getScaleY() == 1.0f) {
            arrayList.add(new com.fyber.inneractive.sdk.mraid.C(this.Z, this.a0));
            arrayList.add(new com.fyber.inneractive.sdk.mraid.A(this.b0, this.c0));
        } else {
            arrayList.add(new com.fyber.inneractive.sdk.mraid.C(this.b.getWidthDp(), this.b.getHeightDp()));
            arrayList.add(new com.fyber.inneractive.sdk.mraid.A(this.b.getWidthDp(), this.b.getHeightDp()));
        }
        C3274m c3274m2 = this.b;
        int iB = AbstractC3251o.b(c3274m2 != null ? c3274m2.getWidth() : this.b0);
        C3274m c3274m3 = this.b;
        arrayList.add(new com.fyber.inneractive.sdk.mraid.z(iB, AbstractC3251o.b(c3274m3 != null ? c3274m3.getHeight() : this.c0)));
        a(arrayList);
        com.fyber.inneractive.sdk.mraid.F f = com.fyber.inneractive.sdk.mraid.F.DEFAULT;
        this.N = f;
        a(new com.fyber.inneractive.sdk.mraid.D(f));
    }

    @Override // com.fyber.inneractive.sdk.web.j0
    public final boolean m() {
        C c = this.Q;
        return c != null && c.equals(C.INTERSTITIAL);
    }

    /* JADX WARN: Code duplicated, block: B:8:0x0013  */
    public final void o() {
        ViewGroup viewGroup;
        C3274m c3274m;
        com.fyber.inneractive.sdk.mraid.F f;
        ViewGroup viewGroup2 = this.R;
        ViewGroup viewGroup3 = null;
        if (viewGroup2 == null) {
            viewGroup = null;
        } else {
            View viewFindViewById = viewGroup2.findViewById(R.id.ia_identifier_overlay);
            if (viewFindViewById instanceof ViewGroup) {
                viewGroup = (ViewGroup) viewFindViewById;
            } else {
                viewGroup = null;
            }
        }
        if (viewGroup == null) {
            C3274m c3274m2 = this.b;
            if (c3274m2 != null) {
                View viewFindViewById2 = c3274m2.findViewById(R.id.ia_identifier_overlay);
                if (viewFindViewById2 instanceof ViewGroup) {
                    viewGroup3 = (ViewGroup) viewFindViewById2;
                }
            }
        } else {
            viewGroup3 = viewGroup;
        }
        this.T = false;
        if (p() || (f = this.N) == com.fyber.inneractive.sdk.mraid.F.RESIZED) {
            c(false);
            C3274m c3274m3 = this.b;
            if (c3274m3 != null) {
                com.fyber.inneractive.sdk.mraid.F f2 = this.N;
                if (f2 == com.fyber.inneractive.sdk.mraid.F.EXPANDED) {
                    FrameLayout frameLayout = this.i0;
                    if (frameLayout != null && this.j0 != null) {
                        frameLayout.removeAllViewsInLayout();
                        this.j0.removeAllViewsInLayout();
                        ViewGroup viewGroup4 = this.R;
                        if (viewGroup4 != null) {
                            viewGroup4.removeView(this.j0);
                        }
                    }
                    ViewGroup viewGroup5 = (ViewGroup) this.h0.getParent();
                    if (viewGroup5 != null) {
                        viewGroup5.addView(this.b, this.g0);
                        C3274m c3274m4 = this.b;
                        int i = this.k0;
                        int i2 = this.l0;
                        ViewGroup.LayoutParams layoutParams = c3274m4.getLayoutParams();
                        layoutParams.width = i;
                        layoutParams.height = i2;
                        c3274m4.setLayoutParams(layoutParams);
                        AbstractC3251o.a(this.b, 17);
                        viewGroup5.removeView(this.h0);
                        viewGroup5.invalidate();
                        this.b.requestLayout();
                    }
                    this.d0 = this.k0;
                    this.e0 = this.l0;
                } else if (f2 == com.fyber.inneractive.sdk.mraid.F.RESIZED) {
                    int i3 = this.k0;
                    this.d0 = i3;
                    int i4 = this.l0;
                    this.e0 = i4;
                    ViewGroup.LayoutParams layoutParams2 = c3274m3.getLayoutParams();
                    layoutParams2.width = i3;
                    layoutParams2.height = i4;
                    c3274m3.setLayoutParams(layoutParams2);
                    AbstractC3251o.a(this.b, 17);
                }
            }
            if (viewGroup3 != null && (c3274m = this.b) != null) {
                viewGroup3.setLayoutParams(c3274m.getLayoutParams());
                if (p()) {
                    AbstractC3256u.a(viewGroup3);
                    this.b.addView(viewGroup3);
                }
            }
            this.N = com.fyber.inneractive.sdk.mraid.F.DEFAULT;
            d(false);
            a(new com.fyber.inneractive.sdk.mraid.D(this.N));
        } else if (f == com.fyber.inneractive.sdk.mraid.F.DEFAULT) {
            C3274m c3274m5 = this.b;
            if (c3274m5 != null) {
                c3274m5.setVisibility(4);
            }
            com.fyber.inneractive.sdk.mraid.F f3 = com.fyber.inneractive.sdk.mraid.F.HIDDEN;
            this.N = f3;
            a(new com.fyber.inneractive.sdk.mraid.D(f3));
        }
        if (viewGroup3 != null) {
            viewGroup3.setPadding(0, 0, 0, 0);
        }
        k0 k0Var = this.g;
        if (k0Var != null) {
            ((B) k0Var).onClose();
        }
        if (Build.VERSION.SDK_INT >= 33) {
            r();
        }
    }

    public final boolean p() {
        return this.N == com.fyber.inneractive.sdk.mraid.F.EXPANDED;
    }

    public final void q() {
        com.fyber.inneractive.sdk.measurement.tracker.f bVar;
        com.fyber.inneractive.sdk.measurement.e eVar = this.H;
        if (eVar != null) {
            C3274m c3274m = this.b;
            com.fyber.inneractive.sdk.flow.x xVar = this.s;
            boolean z = false;
            IAlog.a("omsdk initMraidSession", new Object[0]);
            if (eVar.e == null) {
                IAlog.a("omsdk partner is null", new Object[0]);
                bVar = null;
            } else {
                if (xVar != null && xVar.c() != null && xVar.c().J) {
                    z = true;
                }
                com.fyber.inneractive.sdk.measurement.tracker.g gVar = eVar.f;
                Partner partner = eVar.e;
                gVar.getClass();
                bVar = z ? new com.fyber.inneractive.sdk.measurement.tracker.b(partner, c3274m, xVar) : new com.fyber.inneractive.sdk.measurement.tracker.a(partner, c3274m, xVar);
                bVar.a(c3274m);
            }
            this.I = bVar;
        }
        InterfaceC3268g interfaceC3268g = this.f;
        if (interfaceC3268g != null) {
            interfaceC3268g.a(this);
        }
    }

    public final void r() {
        try {
            if (!(AbstractC3251o.a(this.b) instanceof Activity) || this.m0 == null) {
                return;
            }
            ((Activity) AbstractC3251o.a(this.b)).getOnBackInvokedDispatcher().unregisterOnBackInvokedCallback(this.m0);
            this.m0 = null;
        } catch (Exception e) {
            IAlog.f("failed to unregisterOnBackInvokedCallback with error: %s", e.getMessage());
        }
    }

    @Override // com.fyber.inneractive.sdk.web.j0
    public void setAdDefaultSize(int i, int i2) {
        this.k0 = i;
        this.l0 = i2;
        this.d0 = i;
        this.e0 = i2;
    }

    public void setOrientationProperties(boolean z, String str) {
        if ("portrait".equals(str)) {
            this.f0 = Orientation.PORTRAIT;
        } else if ("landscape".equals(str)) {
            this.f0 = Orientation.LANDSCAPE;
        } else {
            this.f0 = Orientation.NONE;
        }
        k0 k0Var = this.g;
        if (k0Var != null) {
            ((B) k0Var).a(z, this.f0);
        }
    }

    public void setResizeProperties() {
    }

    @Override // com.fyber.inneractive.sdk.web.AbstractC3270i
    public final void b(boolean z) {
        C3274m c3274m = this.b;
        if (c3274m != null && c3274m.getViewTreeObserver() != null) {
            this.b.getViewTreeObserver().removeOnPreDrawListener(this.n0);
        }
        com.fyber.inneractive.sdk.util.r.b.post(new RunnableC3279s(this));
        C3274m c3274m2 = this.S;
        if (c3274m2 != null && c3274m2.getParent() != null && (this.S.getParent() instanceof ViewGroup)) {
            ((ViewGroup) this.S.getParent()).removeView(this.S);
            this.S = null;
        }
        FrameLayout frameLayout = this.i0;
        if (frameLayout != null && this.j0 != null) {
            frameLayout.removeAllViewsInLayout();
            this.j0.removeAllViewsInLayout();
            ViewGroup viewGroup = this.R;
            if (viewGroup != null) {
                viewGroup.removeView(this.j0);
            }
        }
        this.f2412a = false;
        if (Build.VERSION.SDK_INT >= 33) {
            r();
        }
        super.b(z);
    }

    @Override // com.fyber.inneractive.sdk.web.AbstractC3270i, com.fyber.inneractive.sdk.web.InterfaceC3271j
    public boolean a(WebView webView, String str) {
        IAlog.a("%shandle url for: %s webView = %s", IAlog.a(this), str, webView);
        if (this.N == com.fyber.inneractive.sdk.mraid.F.EXPANDED && !TextUtils.isEmpty(str) && webView.equals(this.S) && !this.T) {
            this.T = true;
            return false;
        }
        return super.a(webView, str);
    }

    public final void c(boolean z) {
        if (this.R == null) {
            return;
        }
        if (z) {
            int iA = AbstractC3251o.a(35);
            if (this.W == null) {
                IAcloseButton iAcloseButton = new IAcloseButton(AbstractC3251o.a(this.b), iA);
                this.W = iAcloseButton;
                iAcloseButton.setOnClickListener(new ViewOnClickListenerC3276o(this));
            }
            AbstractC3256u.a(this.W);
            this.j0.addView(this.W);
            IAcloseButton iAcloseButton2 = this.W;
            ViewGroup.LayoutParams layoutParams = iAcloseButton2.getLayoutParams();
            layoutParams.width = iA;
            layoutParams.height = iA;
            iAcloseButton2.setLayoutParams(layoutParams);
            AbstractC3251o.a(this.W, 53);
            IAcloseButton iAcloseButton3 = this.W;
            int iA2 = AbstractC3251o.a(10);
            int iA3 = AbstractC3251o.a(10);
            ViewGroup.LayoutParams layoutParams2 = iAcloseButton3.getLayoutParams();
            if (layoutParams2 instanceof ViewGroup.MarginLayoutParams) {
                ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams2;
                marginLayoutParams.leftMargin = 0;
                marginLayoutParams.topMargin = iA2;
                marginLayoutParams.rightMargin = iA3;
                marginLayoutParams.bottomMargin = 0;
                iAcloseButton3.setLayoutParams(marginLayoutParams);
            }
        } else {
            this.j0.removeView(this.W);
        }
        k0 k0Var = this.g;
        if (k0Var != null) {
            ((B) k0Var).b(z);
        }
        this.X = !z;
    }

    @Override // com.fyber.inneractive.sdk.web.j0
    public final void a(Context context, boolean z) {
        Window window;
        Window window2;
        DisplayMetrics displayMetrics = new DisplayMetrics();
        ((WindowManager) IAConfigManager.O.v.a().getSystemService("window")).getDefaultDisplay().getRealMetrics(displayMetrics);
        this.Y = displayMetrics.density;
        Rect rect = new Rect();
        boolean z2 = context instanceof Activity;
        if (z2 && (window2 = ((Activity) context).getWindow()) != null) {
            window2.getDecorView().getWindowVisibleDisplayFrame(rect);
        }
        int i = rect.top;
        View viewFindViewById = (!z2 || (window = ((Activity) context).getWindow()) == null) ? null : window.findViewById(android.R.id.content);
        int top = viewFindViewById != null ? viewFindViewById.getTop() - i : 0;
        int i2 = displayMetrics.widthPixels;
        int i3 = displayMetrics.heightPixels;
        double d = i2;
        double d2 = 160.0d / ((double) displayMetrics.densityDpi);
        int widthDp = (int) (d2 * d);
        int heightDp = (int) (d2 * ((double) i3));
        int i4 = (i3 - i) - top;
        C3274m c3274m = this.b;
        if (c3274m != null && c3274m.getScaleX() != 1.0f && this.b.getScaleY() != 1.0f) {
            widthDp = this.b.getWidthDp();
            heightDp = this.b.getHeightDp();
            int iA = (AbstractC3251o.a(this.b.getHeightDp()) - i) - top;
            this.b0 = this.Z;
            this.c0 = (int) ((160.0d / ((double) displayMetrics.densityDpi)) * ((double) iA));
        } else {
            double d3 = 160.0d / ((double) displayMetrics.densityDpi);
            this.b0 = (int) (d * d3);
            this.c0 = (int) (d3 * ((double) i4));
        }
        if (this.Z == widthDp && this.a0 == heightDp) {
            return;
        }
        this.Z = widthDp;
        this.a0 = heightDp;
        if (z) {
            a(new com.fyber.inneractive.sdk.mraid.C(widthDp, heightDp));
            a(new com.fyber.inneractive.sdk.mraid.A(this.b0, this.c0));
            a(new com.fyber.inneractive.sdk.mraid.z(this.b0, this.c0));
            int i5 = this.d0;
            if (i5 > 0 && this.e0 > 0) {
                a(new com.fyber.inneractive.sdk.mraid.x(AbstractC3251o.b(i5), AbstractC3251o.b(this.e0)));
                return;
            }
            C3274m c3274m2 = this.b;
            if (c3274m2 == null || c3274m2.getWidth() <= 0 || this.b.getHeight() <= 0) {
                return;
            }
            a(new com.fyber.inneractive.sdk.mraid.x(AbstractC3251o.b(this.b.getWidth()), AbstractC3251o.b(this.b.getHeight())));
        }
    }

    /* JADX WARN: Code duplicated, block: B:41:0x00a8  */
    public final void a(String str, int i, int i2, boolean z, boolean z2) {
        ViewGroup viewGroup;
        if (this.b == null || this.O == EnumC3286z.DISABLED || this.N != com.fyber.inneractive.sdk.mraid.F.DEFAULT) {
            return;
        }
        if (str != null && !URLUtil.isValidUrl(str)) {
            a(com.fyber.inneractive.sdk.mraid.k.EXPAND, "URL passed to expand() was invalid.");
            return;
        }
        try {
            ViewGroup viewGroup2 = (ViewGroup) this.b.getRootView().findViewById(android.R.id.content);
            this.R = viewGroup2;
            if (viewGroup2 == null) {
                IAlog.f("Couldn't find content in the view tree", new Object[0]);
                a(com.fyber.inneractive.sdk.mraid.k.RESIZE, "Ad can be resized only if it's state is default or resized.");
                return;
            }
            if (Build.VERSION.SDK_INT >= 33) {
                this.m0 = new C3280t(this);
                if (AbstractC3251o.a(this.b) instanceof Activity) {
                    ((Activity) AbstractC3251o.a(this.b)).getOnBackInvokedDispatcher().registerOnBackInvokedCallback(0, this.m0);
                }
            }
            this.X = z;
            k0 k0Var = this.g;
            if (k0Var != null) {
                ((B) k0Var).b(z);
            }
            d(z2);
            if (this.e0 >= 0) {
                this.e0 = AbstractC3251o.a(i2);
            }
            if (this.d0 >= 0) {
                this.d0 = AbstractC3251o.a(i);
            }
            C3274m c3274m = this.b;
            ViewGroup viewGroup3 = (ViewGroup) c3274m.getParent();
            if (viewGroup3 == null) {
                viewGroup = null;
            } else {
                View viewFindViewById = viewGroup3.findViewById(R.id.ia_identifier_overlay);
                if (viewFindViewById instanceof ViewGroup) {
                    viewGroup = (ViewGroup) viewFindViewById;
                } else {
                    viewGroup = null;
                }
            }
            if (str != null) {
                C3274m c3274m2 = new C3274m();
                this.S = c3274m2;
                c3274m2.setId(R.id.ia_inneractive_webview_mraid);
                DTExchangeNetworkBridge.webviewLoadUrl(this.S, str);
                this.S.setWebChromeClient(this.c);
                this.S.setWebViewClient(this.d);
                c3274m = this.S;
                c3274m.setOnKeyListener(new ViewOnKeyListenerC3281u(this));
            } else {
                ViewGroup viewGroup4 = (ViewGroup) this.b.getParent();
                if (viewGroup4 != null) {
                    int childCount = viewGroup4.getChildCount();
                    int i3 = 0;
                    while (i3 < childCount && viewGroup4.getChildAt(i3) != this.b) {
                        i3++;
                    }
                    ViewGroup viewGroup5 = (ViewGroup) viewGroup4.findViewById(R.id.ia_identifier_overlay);
                    this.g0 = i3;
                    AbstractC3256u.a(viewGroup5);
                    AbstractC3256u.a(this.h0);
                    viewGroup4.addView(this.h0, i3);
                    FrameLayout frameLayout = this.h0;
                    int width = this.b.getWidth();
                    int height = this.b.getHeight();
                    ViewGroup.LayoutParams layoutParams = frameLayout.getLayoutParams();
                    layoutParams.width = width;
                    layoutParams.height = height;
                    frameLayout.setLayoutParams(layoutParams);
                    AbstractC3251o.a(this.h0, 17);
                    viewGroup4.removeView(this.b);
                }
            }
            float f = this.Y;
            int i4 = (int) ((50.0f * f) + 0.5f);
            if (i2 >= 0 && i >= 0) {
                i = (int) (i * f);
                i2 = (int) (i2 * f);
                if (i < i4) {
                    i = i4;
                }
                if (i2 < i4) {
                    i2 = i4;
                }
            }
            View view = new View(AbstractC3251o.a(this.b));
            view.setBackgroundColor(AbstractC3251o.a(this.b).getResources().getColor(R.color.ia_mraid_expanded_dimmed_bk));
            view.setOnTouchListener(new ViewOnTouchListenerC3275n());
            this.j0.addView(view);
            ViewGroup.LayoutParams layoutParams2 = view.getLayoutParams();
            layoutParams2.width = -1;
            layoutParams2.height = -1;
            view.setLayoutParams(layoutParams2);
            AbstractC3256u.a(c3274m);
            this.i0.addView(c3274m);
            ViewGroup.LayoutParams layoutParams3 = c3274m.getLayoutParams();
            layoutParams3.width = -1;
            layoutParams3.height = -1;
            c3274m.setLayoutParams(layoutParams3);
            AbstractC3256u.a(this.i0);
            this.j0.addView(this.i0);
            FrameLayout frameLayout2 = this.i0;
            ViewGroup.LayoutParams layoutParams4 = frameLayout2.getLayoutParams();
            layoutParams4.width = i;
            layoutParams4.height = i2;
            frameLayout2.setLayoutParams(layoutParams4);
            AbstractC3251o.a(this.i0, 17);
            AbstractC3256u.a(this.j0);
            this.R.addView(this.j0);
            FrameLayout frameLayout3 = this.j0;
            ViewGroup.LayoutParams layoutParams5 = frameLayout3.getLayoutParams();
            layoutParams5.width = -1;
            layoutParams5.height = -1;
            frameLayout3.setLayoutParams(layoutParams5);
            if (!c3274m.hasFocus()) {
                c3274m.requestFocus();
            }
            D d = this.P;
            if (d == D.ALWAYS_VISIBLE || (!this.X && d != D.ALWAYS_HIDDEN)) {
                c(true);
            }
            com.fyber.inneractive.sdk.mraid.F f2 = com.fyber.inneractive.sdk.mraid.F.EXPANDED;
            this.N = f2;
            a(new com.fyber.inneractive.sdk.mraid.D(f2));
            int i5 = this.d0;
            if (i5 != -1 && this.e0 != -1) {
                a(new com.fyber.inneractive.sdk.mraid.x(AbstractC3251o.b(i5), AbstractC3251o.b(this.e0)));
            }
            a(com.fyber.inneractive.sdk.mraid.k.EXPAND);
            if (viewGroup != null) {
                int dimension = (int) viewGroup.getContext().getResources().getDimension(R.dimen.ia_identifier_padding);
                viewGroup.setPadding(dimension, 0, 0, dimension);
                viewGroup.setLayoutParams(this.R.getLayoutParams());
                this.R.addView(viewGroup);
            }
            k0 k0Var2 = this.g;
            if (k0Var2 != null) {
                ((B) k0Var2).c();
            }
        } catch (Exception unused) {
            IAlog.f("Couldn't find content in the view tree", new Object[0]);
            a(com.fyber.inneractive.sdk.mraid.k.RESIZE, "Ad can be resized only if it's state is default or resized.");
        }
    }

    public static HashMap a(Map map) {
        String str;
        HashMap map2 = new HashMap();
        if (map.containsKey("description") && map.containsKey("start")) {
            map2.put("title", map.get("description"));
            if (map.containsKey("start") && map.get("start") != null) {
                Date dateA = a((String) map.get("start"));
                if (dateA != null) {
                    map2.put(MRAIDNativeFeatureProvider.EXTRA_EVENT_BEGIN_TIME, Long.valueOf(dateA.getTime()));
                    if (map.containsKey("end") && map.get("end") != null) {
                        Date dateA2 = a((String) map.get("end"));
                        if (dateA2 != null) {
                            map2.put("endTime", Long.valueOf(dateA2.getTime()));
                        } else {
                            throw new IllegalArgumentException("Invalid calendar event: end time is malformed. Date format expecting (yyyy-MM-DDTHH:MM:SS-xx:xx) or (yyyy-MM-DDTHH:MM-xx:xx) i.e. 2013-08-14T09:00:01-08:00");
                        }
                    }
                    if (map.containsKey("location")) {
                        map2.put(MRAIDNativeFeatureProvider.EVENT_LOCATION, map.get("location"));
                    }
                    if (map.containsKey("summary")) {
                        map2.put("description", map.get("summary"));
                    }
                    if (map.containsKey("transparency")) {
                        map2.put("availability", Integer.valueOf(b9.h.T.equals(map.get("transparency")) ? 1 : 0));
                    }
                    StringBuilder sb = new StringBuilder();
                    if (map.containsKey("frequency")) {
                        String str2 = (String) map.get("frequency");
                        int i = map.containsKey("interval") ? Integer.parseInt((String) map.get("interval")) : -1;
                        if ("daily".equals(str2)) {
                            sb.append("FREQ=DAILY;");
                            if (i != -1) {
                                sb.append("INTERVAL=" + i + ";");
                            }
                        } else {
                            if ("weekly".equals(str2)) {
                                sb.append("FREQ=WEEKLY;");
                                if (i != -1) {
                                    sb.append("INTERVAL=" + i + ";");
                                }
                                if (map.containsKey("daysInWeek")) {
                                    String str3 = (String) map.get("daysInWeek");
                                    StringBuilder sb2 = new StringBuilder();
                                    boolean[] zArr = new boolean[7];
                                    String[] strArrSplit = str3.split(StringUtils.COMMA);
                                    for (String str4 : strArrSplit) {
                                        int i2 = Integer.parseInt(str4);
                                        if (i2 == 7) {
                                            i2 = 0;
                                        }
                                        if (!zArr[i2]) {
                                            StringBuilder sb3 = new StringBuilder();
                                            switch (i2) {
                                                case 0:
                                                    str = "SU";
                                                    break;
                                                case 1:
                                                    str = "MO";
                                                    break;
                                                case 2:
                                                    str = "TU";
                                                    break;
                                                case 3:
                                                    str = "WE";
                                                    break;
                                                case 4:
                                                    str = "TH";
                                                    break;
                                                case 5:
                                                    str = "FR";
                                                    break;
                                                case 6:
                                                    str = "SA";
                                                    break;
                                                default:
                                                    throw new IllegalArgumentException(com.fyber.inneractive.sdk.player.exoplayer2.m.a("invalid day of week ", i2));
                                            }
                                            sb2.append(sb3.append(str).append(StringUtils.COMMA).toString());
                                            zArr[i2] = true;
                                        }
                                    }
                                    if (strArrSplit.length != 0) {
                                        sb2.deleteCharAt(sb2.length() - 1);
                                        String string = sb2.toString();
                                        if (string != null) {
                                            sb.append("BYDAY=" + string + ";");
                                        } else {
                                            throw new IllegalArgumentException("invalid ");
                                        }
                                    } else {
                                        throw new IllegalArgumentException("must have at least 1 day of the week if specifying repeating weekly");
                                    }
                                }
                            } else if ("monthly".equals(str2)) {
                                sb.append("FREQ=MONTHLY;");
                                if (i != -1) {
                                    sb.append("INTERVAL=" + i + ";");
                                }
                                if (map.containsKey("daysInMonth")) {
                                    String str5 = (String) map.get("daysInMonth");
                                    StringBuilder sb4 = new StringBuilder();
                                    boolean[] zArr2 = new boolean[63];
                                    String[] strArrSplit2 = str5.split(StringUtils.COMMA);
                                    for (String str6 : strArrSplit2) {
                                        int i3 = Integer.parseInt(str6);
                                        int i4 = i3 + 31;
                                        if (!zArr2[i4]) {
                                            StringBuilder sb5 = new StringBuilder();
                                            if (i3 != 0 && i3 >= -31 && i3 <= 31) {
                                                sb4.append(sb5.append("" + i3).append(StringUtils.COMMA).toString());
                                                zArr2[i4] = true;
                                            } else {
                                                throw new IllegalArgumentException(com.fyber.inneractive.sdk.player.exoplayer2.m.a("invalid day of month ", i3));
                                            }
                                        }
                                    }
                                    if (strArrSplit2.length != 0) {
                                        sb4.deleteCharAt(sb4.length() - 1);
                                        String string2 = sb4.toString();
                                        if (string2 != null) {
                                            sb.append("BYMONTHDAY=" + string2 + ";");
                                        } else {
                                            throw new IllegalArgumentException();
                                        }
                                    } else {
                                        throw new IllegalArgumentException("must have at least 1 day of the month if specifying repeating weekly");
                                    }
                                }
                            } else {
                                throw new IllegalArgumentException("frequency is only supported for daily, weekly, and monthly.");
                            }
                        }
                    }
                    String string3 = sb.toString();
                    if (!TextUtils.isEmpty(string3)) {
                        map2.put("rrule", string3);
                    }
                    return map2;
                }
                throw new IllegalArgumentException("Invalid calendar event: start time is malformed. Date format expecting (yyyy-MM-DDTHH:MM:SS-xx:xx) or (yyyy-MM-DDTHH:MM-xx:xx) i.e. 2013-08-14T09:00:01-08:00");
            }
            throw new IllegalArgumentException("Invalid calendar event: start is null.");
        }
        throw new IllegalArgumentException("Missing start and description fields");
    }

    public static Date a(String str) {
        Date date = null;
        int i = 0;
        while (true) {
            String[] strArr = o0;
            if (i >= 2) {
                break;
            }
            try {
                date = new SimpleDateFormat(strArr[i], Locale.getDefault()).parse(str);
                if (date != null) {
                    break;
                }
                i++;
            } catch (ParseException unused) {
            }
        }
        return date;
    }

    public final void a(com.fyber.inneractive.sdk.mraid.k kVar, String str) {
        String strA = kVar.a();
        C3274m c3274m = this.b;
        if (c3274m != null) {
            c3274m.a("window.mraidbridge.fireErrorEvent('" + strA + "', '" + str + "');");
        }
    }

    public static LinkedHashMap a(URI uri) {
        int i;
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        String rawQuery = uri.getRawQuery();
        if (rawQuery != null && rawQuery.length() > 0) {
            for (String str : rawQuery.split(b9.i.c)) {
                int iIndexOf = str.indexOf("=");
                linkedHashMap.put(iIndexOf > 0 ? URLDecoder.decode(str.substring(0, iIndexOf), "UTF-8") : str, (iIndexOf <= 0 || str.length() <= (i = iIndexOf + 1)) ? null : URLDecoder.decode(str.substring(i), "UTF-8"));
            }
        }
        return linkedHashMap;
    }

    public final void a(View view, com.fyber.inneractive.sdk.measurement.tracker.e eVar) {
        com.fyber.inneractive.sdk.measurement.tracker.f fVar;
        if (view == null || (fVar = this.I) == null) {
            return;
        }
        fVar.getClass();
        try {
            AdSession adSession = fVar.f1866a;
            if (adSession != null) {
                if (eVar == com.fyber.inneractive.sdk.measurement.tracker.e.CloseButton) {
                    adSession.addFriendlyObstruction(view, FriendlyObstructionPurpose.CLOSE_AD, eVar.name());
                } else {
                    adSession.addFriendlyObstruction(view, FriendlyObstructionPurpose.OTHER, eVar.name());
                }
            }
        } catch (Throwable th) {
            fVar.a(th);
        }
    }

    public final void a(com.fyber.inneractive.sdk.mraid.k kVar) {
        com.fyber.inneractive.sdk.config.global.r rVar;
        EnumC3144u enumC3144u = EnumC3144u.BANNER_RESIZE_EXPAND;
        InneractiveAdRequest inneractiveAdRequest = this.r;
        com.fyber.inneractive.sdk.flow.x xVar = this.s;
        com.fyber.inneractive.sdk.response.e eVarC = xVar != null ? xVar.c() : null;
        com.fyber.inneractive.sdk.flow.x xVar2 = this.s;
        JSONArray jSONArrayB = (xVar2 == null || (rVar = xVar2.c) == null) ? null : rVar.b();
        C3146w c3146w = new C3146w(eVarC);
        c3146w.c = enumC3144u;
        c3146w.f1934a = inneractiveAdRequest;
        c3146w.d = jSONArrayB;
        c3146w.a("action", kVar.a()).a((String) null);
    }
}
