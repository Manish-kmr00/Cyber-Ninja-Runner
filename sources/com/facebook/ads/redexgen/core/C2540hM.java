package com.facebook.ads.redexgen.core;

import android.content.Intent;
import android.content.res.Configuration;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Pair;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import com.facebook.ads.internal.view.FullScreenAdToolbar;
import com.fyber.inneractive.sdk.external.InneractiveMediationDefs;
import com.google.common.base.Ascii;
import java.text.NumberFormat;
import java.util.Arrays;
import java.util.HashMap;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.io.encoding.Base64;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.hM, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public final class C2540hM extends RelativeLayout implements DS {
    public static byte[] A0b;
    public static String[] A0c = {"HOR7o31Iej4cYWuhQXExnEuENMywT0cc", "lMe4cl58LNQGNUAHyasApQ9JUE0svDiV", "D3sd2x1kxAGmbwUwbgSwAdGIbJmc5gOO", "0qcoppWNPh", "IKOWodR4Z8ze5gnDmb", "KTSiIx6w", "wnW3I4EzpNnUTo4gipPMifUFglZZiY67", "f8O"};
    public static final int A0d;
    public static final int A0e;
    public static final int A0f;
    public static final int A0g;
    public static final int A0h;
    public static final int A0i;
    public static final int A0j;
    public static final int A0k;
    public static final int A0l;
    public static final int A0m;
    public static final int A0n;
    public static final int A0o;
    public static final int A0p;
    public static final RelativeLayout.LayoutParams A0q;
    public View A00;
    public RelativeLayout A01;
    public RelativeLayout A02;
    public Toast A03;
    public C13656e A04;
    public CH A05;
    public ViewOnClickListenerC2488gW A06;
    public C1641Ho A07;
    public I7 A08;
    public String A09;
    public String A0A;
    public boolean A0B;
    public boolean A0C;
    public boolean A0D;
    public boolean A0E;
    public boolean A0F;
    public boolean A0G;
    public boolean A0H;
    public final AbstractC2855md A0I;
    public final C12752p A0J;
    public final InterfaceC13716k A0K;
    public final C2699k1 A0L;
    public final A7 A0M;
    public final AF A0N;
    public final CH A0O;
    public final ViewOnSystemUiVisibilityChangeListenerC1513Cq A0P;
    public final DR A0Q;
    public final EC A0R;
    public final InterfaceC1577Fc A0S;
    public final C1578Fd A0T;
    public final C1646Ht A0U;
    public final AtomicBoolean A0V;
    public final AtomicBoolean A0W;
    public final boolean A0X;
    public final boolean A0Y;
    public final boolean A0Z;
    public final DQ A0a;

    public static String A0D(int i, int i2, int i3) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A0b, i, i + i2);
        for (int i4 = 0; i4 < bArrCopyOfRange.length; i4++) {
            bArrCopyOfRange[i4] = (byte) ((bArrCopyOfRange[i4] ^ i3) ^ 107);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A0N() {
        A0b = new byte[]{124, 85, 123, 83, 69, 67, 83, 125, 49, 62, 59, 49, 57, Ascii.CR, Base64.padSymbol, 32, 59, 53, 59, 60, Ascii.SI, 0, 5, Ascii.SI, 7, 51, Ascii.US, 3, Ascii.EM, Ascii.RS, Ascii.SI, 9, 62, 57, 35, 50, 37, 36, 35, 62, 35, 62, 54, 59, 87, 88, 77, 80, 79, 92, 102, 90, 85, 80, 90, 82, 65, 93, 80, 82, 84, 92, 84, 95, 69, 104, 127, 109, 123, 104, 126, 127, 126, 69, 108, 115, 126, 127, 117, Ascii.RS, Ascii.FF, Ascii.VT, Ascii.US, 0, Ascii.FF, Ascii.RS, 54, 10, 5, 0, 10, 2};
    }

    static {
        A0N();
        A0o = (int) (CP.A02 * 64.0f);
        A0g = (int) (CP.A02 * 16.0f);
        A0p = (int) (CP.A02 * 12.0f);
        A0e = (int) (CP.A02 * 10.0f);
        A0q = new RelativeLayout.LayoutParams(-1, -1);
        A0h = (int) (CP.A02 * 48.0f);
        A0i = (int) (CP.A02 * 16.0f);
        A0n = (int) (CP.A02 * 14.0f);
        A0l = (int) (CP.A02 * 12.0f);
        A0m = AnonymousClass43.A02(-1, 77);
        A0d = (int) (CP.A02 * 8.0f);
        A0j = (int) (CP.A02 * 20.0f);
        A0k = (int) (CP.A02 * 13.0f);
        A0f = (int) (CP.A02 * 8.0f);
    }

    public C2540hM(C2699k1 c2699k1, A7 a7, DR dr, AbstractC2855md abstractC2855md, String str, EC ec, C1641Ho c1641Ho) {
        this(c2699k1, a7, dr, abstractC2855md, str, ec, false, c1641Ho);
    }

    public C2540hM(C2699k1 c2699k1, A7 a7, DR dr, AbstractC2855md abstractC2855md, String str, EC ec, boolean z, C1641Ho c1641Ho) {
        int iA08;
        super(c2699k1);
        String strA0D = A0D(0, 0, 113);
        this.A0A = strA0D;
        this.A09 = strA0D;
        this.A0K = new C2548hU(this);
        this.A0W = new AtomicBoolean(false);
        this.A0V = new AtomicBoolean(false);
        this.A0F = false;
        this.A0H = true;
        this.A0C = false;
        this.A0B = false;
        this.A0Z = z;
        this.A0L = c2699k1;
        this.A0Q = dr;
        this.A0M = a7;
        this.A0I = abstractC2855md;
        this.A0J = abstractC2855md.A1b().A0F().A07();
        this.A0N = new AF(this.A0I.A1g(), this.A0M);
        this.A0R = ec;
        this.A08 = new I7(c2699k1, this.A0R, str, this.A0Q);
        if (abstractC2855md.A1b().A0F().A07() != null) {
            this.A0D = abstractC2855md.A1b().A0F().A07().A0N();
            this.A0A = abstractC2855md.A1b().A0F().A07().A0H();
            this.A09 = abstractC2855md.A1b().A0F().A07().A0G();
        }
        this.A0E = this.A0I.A1b().A0P() && this.A0I.A1b().A0F().A03() > 0;
        this.A0Y = this.A0I.A1b().A0F().A0B();
        if (this.A0J == null) {
            this.A0Q.A4Z(this.A0R.A7r());
            this.A0Q.A4Z(this.A0R.A7m());
        }
        if (this.A0J != null) {
            if (!this.A0J.A0P()) {
                if (this.A0E && this.A0Y) {
                    iA08 = this.A0I.A1b().A0F().A03();
                } else {
                    iA08 = this.A0J.A07();
                }
            } else {
                iA08 = this.A0J.A08();
            }
        } else {
            iA08 = 0;
        }
        this.A0W.set(!this.A0J.A0L());
        C2548hU c2548hU = null;
        this.A0O = new CH(iA08, new C2542hO(this, c2548hU));
        this.A0X = C14499m.A0n(this.A0L);
        this.A0a = A07();
        if (this.A0J.A0P()) {
            this.A0a.A06();
        }
        this.A0U = new C1646Ht(this.A0L, this.A0M, this.A0I);
        AbstractC1587Fm.A00(c2699k1, this, abstractC2855md.A1b().A0F().A08());
        this.A0P = new ViewOnSystemUiVisibilityChangeListenerC1513Cq(this);
        this.A0P.A05(EnumC1512Cp.A02);
        if (C14499m.A2B(this.A0L)) {
            this.A0a.setProgressSpinnerInvisible(true);
        }
        C2541hN c2541hN = new C2541hN(this, c2548hU);
        if (c1641Ho == null) {
            HashMap map = new HashMap();
            map.put(A0D(56, 9, 90), this.A0R.A8b());
            this.A07 = new C1641Ho(this.A0L, this.A0I, this.A0J, this.A0M, c2541hN, map);
        } else {
            this.A07 = c1641Ho;
            this.A07.setPlayableAdsViewListener(c2541hN);
        }
        A0K();
        this.A0Q.A3v(this, new RelativeLayout.LayoutParams(-1, -1));
        A0H();
        this.A0S = new C2547hT(this);
        this.A0T = new C1578Fd(this.A0L, this.A0a, this.A0I, (C2232cL) null, this.A0Q, this.A0S, this.A06, this.A01, this.A07);
        if (Build.VERSION.SDK_INT >= 35) {
            setFitsSystemWindows(true);
        }
        if (this.A0J.A0P()) {
            this.A0L.A0F().ADj();
        }
    }

    private FullScreenAdToolbar A07() {
        FullScreenAdToolbar fullScreenAdToolbar = new FullScreenAdToolbar(this.A0L, this.A0Q, this.A0N, 0, this.A0I.A1V(), this.A0D);
        fullScreenAdToolbar.setFullscreen(true);
        fullScreenAdToolbar.A0A(this.A0I.A1a().A01(), ViewOnClickListenerC2488gW.A09(this.A0I));
        fullScreenAdToolbar.setPageDetailsVisible(false);
        fullScreenAdToolbar.setPageDetails(this.A0I.A1e(), this.A0I.A1g(), this.A0J.A07(), this.A0I.A1f());
        fullScreenAdToolbar.setToolbarListener(new C2544hQ(this));
        return fullScreenAdToolbar;
    }

    private ViewOnClickListenerC2488gW A09() {
        if (this.A07 == null || this.A07.getViewabilityChecker() == null || this.A07.getTouchDataRecorder() == null) {
            return null;
        }
        ViewOnClickListenerC2488gW viewOnClickListenerC2488gW = new ViewOnClickListenerC2488gW(this.A0L, this.A0R.A7C(), this.A0I.A1a().A01(), this.A0M, this.A0Q, this.A07.getViewabilityChecker(), this.A07.getTouchDataRecorder(), this.A0I.A1c());
        D3.A0I(viewOnClickListenerC2488gW);
        viewOnClickListenerC2488gW.setText(this.A0I.A1b().A0H().A04());
        viewOnClickListenerC2488gW.setTextSize(14.0f);
        viewOnClickListenerC2488gW.setPadding(A0e, A0e, A0e, A0e);
        viewOnClickListenerC2488gW.setOnClickListener(new ViewOnClickListenerC1540Dr(this));
        return viewOnClickListenerC2488gW;
    }

    private C1586Fl A0B() {
        C2699k1 c2699k1 = this.A0L;
        C12622c c12622cA01 = this.A0I.A1a().A01();
        int i = !this.A0E ? 16 : 17;
        boolean z = this.A0E;
        String[] strArr = A0c;
        if (strArr[6].charAt(22) == strArr[1].charAt(22)) {
            throw new RuntimeException();
        }
        String[] strArr2 = A0c;
        strArr2[7] = "YLS";
        strArr2[4] = "sNsC3VBoYaF6TxGjee";
        C1586Fl c1586Fl = new C1586Fl(c2699k1, c12622cA01, true, i, !z ? 14 : 13, 0);
        c1586Fl.A04(this.A0I.A1b().A0G().A0F(), this.A0I.A1b().A0G().A0E(), null, false, true);
        TextView descriptionTv = c1586Fl.getDescriptionTextView();
        descriptionTv.setAlpha(0.8f);
        descriptionTv.setMaxLines(1);
        descriptionTv.setEllipsize(TextUtils.TruncateAt.END);
        TextView descriptionTv2 = c1586Fl.getTitleTextView();
        descriptionTv2.setMaxLines(1);
        descriptionTv2.setEllipsize(TextUtils.TruncateAt.END);
        return c1586Fl;
    }

    private void A0G() {
        String strA01;
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(A0h, A0h);
        layoutParams.addRule(15);
        layoutParams.addRule(9);
        C1580Ff c1580Ff = new C1580Ff(this.A0L);
        D3.A0K(c1580Ff, 0);
        D3.A0I(c1580Ff);
        new AsyncTaskC2494gc(c1580Ff, this.A0L).A05(A0h, A0h).A07(this.A0I.A1e().A01());
        TextView textView = new TextView(this.A0L);
        D3.A0I(textView);
        textView.setLayoutParams(new LinearLayout.LayoutParams(-2, -2));
        textView.setTextColor(this.A0I.A1a().A01().A07(true));
        textView.setText(this.A0I.A1b().A0G().A0F());
        textView.setTextSize(!this.A0D ? 16.0f : 17.0f);
        textView.setMaxLines(1);
        textView.setEllipsize(TextUtils.TruncateAt.END);
        C1582Fh c1582Fh = new C1582Fh(this.A0L, !this.A0D ? A0n : A0l, 5, A0m, -1);
        c1582Fh.setGravity(16);
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -1);
        TextView textView2 = new TextView(this.A0L);
        textView2.setTextColor(this.A0I.A1a().A01().A07(true));
        textView2.setGravity(16);
        textView2.setIncludeFontPadding(false);
        if (!this.A0D) {
            textView2.setTextSize(13.0f);
        }
        LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(-2, -1);
        layoutParams3.leftMargin = A0f;
        LinearLayout linearLayout = new LinearLayout(this.A0L);
        linearLayout.setOrientation(0);
        linearLayout.setGravity(16);
        RelativeLayout.LayoutParams layoutParams4 = new RelativeLayout.LayoutParams(-2, A0i);
        layoutParams4.topMargin = A0f / 2;
        layoutParams4.addRule(3, textView.getId());
        linearLayout.addView(c1582Fh, layoutParams2);
        linearLayout.addView(textView2, layoutParams3);
        RelativeLayout.LayoutParams ratingInfoContainerParams = new RelativeLayout.LayoutParams(-2, -2);
        ratingInfoContainerParams.leftMargin = A0f;
        ratingInfoContainerParams.addRule(1, c1580Ff.getId());
        ratingInfoContainerParams.addRule(15);
        RelativeLayout relativeLayout = new RelativeLayout(getContext());
        relativeLayout.addView(linearLayout, layoutParams4);
        relativeLayout.addView(textView);
        if (this.A02 != null) {
            this.A02.removeAllViews();
            this.A02.addView(relativeLayout, ratingInfoContainerParams);
            this.A02.addView(c1580Ff, layoutParams);
        }
        if (TextUtils.isEmpty(this.A0I.A1b().A0G().A0B())) {
            linearLayout.setVisibility(8);
            return;
        }
        linearLayout.setVisibility(0);
        c1582Fh.setRating(Float.parseFloat(this.A0I.A1b().A0G().A0B()));
        if (this.A0I.A1b().A0G().A08() == null) {
            return;
        }
        StringBuilder sb = new StringBuilder();
        sb.append(A0D(0, 1, 63));
        if (!this.A0D) {
            strA01 = NumberFormat.getNumberInstance().format(Integer.parseInt(this.A0I.A1b().A0G().A08()));
        } else {
            strA01 = CY.A01(Integer.parseInt(this.A0I.A1b().A0G().A08()));
        }
        sb.append(strA01);
        sb.append(A0D(1, 1, 23));
        textView2.setText(sb.toString());
    }

    private void A0H() {
        if (this.A0J.A0L()) {
            A0J();
        } else {
            A0M();
        }
        this.A0P.A05(EnumC1512Cp.A03);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void A0I() {
        this.A0G = true;
        if (this.A0I.A1b().A0P()) {
            this.A08.A05();
            this.A0Q.A4a(this.A0R.A6b(), new C1705Ka(0, 0));
        }
    }

    private void A0J() {
        HM hmA0F = new HK(this.A0L, this.A0I.A1b().A0G(), this.A0I.A1e()).A0A(this.A0I.A1a().A01()).A0D(this.A0J.A0J()).A0C(this.A0J.A0E()).A09(2000).A0E(this.A0D).A0B(this.A0A).A0F();
        AH.A04(hmA0F, this.A0N, AE.A0U);
        addView(hmA0F, A0q);
        hmA0F.A04(new C2546hS(this));
    }

    private void A0K() {
        RelativeLayout.LayoutParams layoutParams;
        this.A06 = A09();
        this.A01 = new RelativeLayout(getContext());
        D3.A0I(this.A01);
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams2.setMargins(A0g, A0p, A0g, A0p);
        layoutParams2.addRule(12);
        this.A02 = new RelativeLayout(getContext());
        D3.A0I(this.A02);
        if (this.A0X) {
            A0G();
        } else {
            RelativeLayout relativeLayout = this.A02;
            C1586Fl c1586FlA0B = A0B();
            RelativeLayout.LayoutParams appMetadataLayoutParams = new RelativeLayout.LayoutParams(-2, -2);
            relativeLayout.addView(c1586FlA0B, appMetadataLayoutParams);
        }
        RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(-1, -2);
        layoutParams3.setMargins(0, 0, A0g, 0);
        this.A01.addView(this.A02, layoutParams3);
        if (this.A06 != null) {
            ViewOnClickListenerC2488gW viewOnClickListenerC2488gW = this.A06;
            String[] strArr = A0c;
            if (strArr[6].charAt(22) == strArr[1].charAt(22)) {
                throw new RuntimeException();
            }
            A0c[3] = InneractiveMediationDefs.GENDER_FEMALE;
            layoutParams3.addRule(0, viewOnClickListenerC2488gW.getId());
            if (!this.A0D) {
                layoutParams = new RelativeLayout.LayoutParams(-2, -2);
                layoutParams.addRule(6, this.A02.getId());
                layoutParams.addRule(8, this.A02.getId());
            } else {
                layoutParams = new RelativeLayout.LayoutParams(-2, -2);
                D3.A0Q(this.A06, D3.A06(-16738826, A0d));
                this.A06.setStateListAnimator(null);
                this.A06.setPadding(A0j, A0k, A0j, A0k);
                D3.A0V(this.A06);
            }
            layoutParams.addRule(11);
            this.A01.addView(this.A06, layoutParams);
        }
        D3.A0I(this.A0a);
        RelativeLayout.LayoutParams adWebViewParams = new RelativeLayout.LayoutParams(-1, -2);
        adWebViewParams.addRule(10);
        RelativeLayout.LayoutParams iconAndMetaDataContainerParams = new RelativeLayout.LayoutParams(-1, -1);
        iconAndMetaDataContainerParams.setMargins(A0g, 0, A0g, 0);
        iconAndMetaDataContainerParams.addRule(3, this.A0a.getId());
        iconAndMetaDataContainerParams.addRule(2, this.A01.getId());
        this.A0a.setVisibility(4);
        this.A07.setVisibility(4);
        this.A01.setVisibility(4);
        addView(this.A0a, adWebViewParams);
        addView(this.A07, iconAndMetaDataContainerParams);
        addView(this.A01, layoutParams2);
        if (!this.A0J.A0M() && this.A0J.A0O()) {
            this.A07.A0B();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void A0L() {
        new AF(this.A0I.A1g(), this.A0M).A04(AE.A0z, null);
        this.A0V.set(true);
        D3.A0R(this);
        D3.A0F(this.A07);
        D3.A0Z(this.A0T, this.A00, this.A07);
        if (this.A0D) {
            if (this.A0X) {
                D3.A0F(this.A0a);
            }
        } else {
            D3.A0J(this.A0a);
        }
        D3.A0J(this.A06);
        Pair<EnumC1645Hs, View> pairA03 = this.A0U.A03(this.A06);
        this.A00 = (View) pairA03.second;
        switch (C1541Ds.A00[((EnumC1645Hs) pairA03.first).ordinal()]) {
            case 1:
                RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
                layoutParams.setMargins(0, this.A0a.getToolbarHeight(), 0, 0);
                if (!this.A0D) {
                    D3.A0J(this.A01);
                    if (this.A01 != null) {
                        layoutParams.addRule(2, this.A01.getId());
                    }
                    addView(this.A00, layoutParams);
                } else {
                    addView(new HF(this.A0L, this.A0I.A1e(), this.A0I.A1b().A0G(), A09(), this.A09, new ViewOnClickListenerC1539Dq(this)), new RelativeLayout.LayoutParams(-1, -1));
                    removeView(this.A0a);
                }
                break;
            case 2:
                if (this.A01 != null) {
                    View[] viewArr = new View[1];
                    RelativeLayout relativeLayout = this.A01;
                    String[] strArr = A0c;
                    if (strArr[7].length() == strArr[4].length()) {
                        throw new RuntimeException();
                    }
                    String[] strArr2 = A0c;
                    strArr2[6] = "qNCG6dDJsAPFbWTySRxInyS8ppXyMF33";
                    strArr2[1] = "jWdNFAVobp8QAHjjZXwWCxlFqJ2u0nxR";
                    viewArr[0] = relativeLayout;
                    D3.A0Z(viewArr);
                }
                addView(this.A00, new RelativeLayout.LayoutParams(-1, -1));
                break;
        }
        if (this.A0J.A0P()) {
            this.A0L.A0F().ADe();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void A0M() {
        D3.A0R(this);
        if (!this.A0J.A0M() && !this.A0J.A0O()) {
            this.A07.A0B();
        }
        DQ dq = this.A0a;
        if (A0c[3].length() == 2) {
            throw new RuntimeException();
        }
        String[] strArr = A0c;
        strArr[6] = "O2ZpTY6Mgvz2uHPZTA3aMJEeHq37vzsd";
        strArr[1] = "1283TMQOTifPKRDoGDlRbVjXtyZxpzop";
        dq.setVisibility(0);
        this.A07.setVisibility(0);
        if (this.A01 != null) {
            this.A01.setVisibility(0);
        }
        if (this.A06 != null && this.A0I.A1Y() > 0 && this.A05 == null) {
            this.A05 = new CH(this.A0I.A1Y(), new C2545hR(this));
            this.A05.A07();
        }
        this.A0O.A07();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void A0O(int i) {
        String strValueOf = String.valueOf(i);
        Toast toast = this.A03;
        String strA0D = this.A0J.A0D();
        String progress = A0D(2, 6, 75);
        D3.A0X(toast, strA0D.replace(progress, strValueOf), 49, 0, A0o);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void A0U(boolean z, String str) {
        this.A0C = true;
        HashMap map = new HashMap();
        map.put(A0D(8, 12, 57), z ? A0D(79, 13, 2) : A0D(44, 12, 82));
        map.put(A0D(20, 12, 7), str);
        new FQ(this.A0L, this.A0R.A7C(), this.A07.getViewabilityChecker(), this.A07.getTouchDataRecorder(), this.A0M, this.A0I.A1c(), this.A0Q).A08(this.A0I.A1g(), this.A0I.A1b().A0H().A05(), map);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean A0V() {
        return this.A0I.A0i().equals(A0D(65, 14, 113)) || (this.A0I.A0i().equals(A0D(32, 12, 60)) && this.A0I.A1b().A0R());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean A0W() {
        return this.A0Y && !this.A0F && !this.A0H && this.A0J.A07() < this.A0I.A1b().A0F().A03();
    }

    @Override // com.facebook.ads.redexgen.core.DS
    public final void AAj(Intent intent, Bundle bundle, C13656e c13656e) {
        this.A04 = c13656e;
        this.A04.A0A(this.A0K);
    }

    @Override // com.facebook.ads.redexgen.core.DS
    public final void AEP(boolean z) {
        this.A0O.A06();
        this.A0B = true;
    }

    @Override // com.facebook.ads.redexgen.core.DS
    public final void AEs(boolean z) {
        if ((!this.A0Y || !this.A0H) && !this.A0F) {
            boolean z2 = this.A0W.get();
            String[] strArr = A0c;
            if (strArr[6].charAt(22) == strArr[1].charAt(22)) {
                throw new RuntimeException();
            }
            String[] strArr2 = A0c;
            strArr2[0] = "5YF9hd1VnayjDYXn8X9NIXHiJcVpNWhU";
            strArr2[2] = "6mHNY01g6eF3bUPoEn1oonlPgYyDS663";
            if (z2) {
                CH ch = this.A0O;
                String[] strArr3 = A0c;
                if (strArr3[6].charAt(22) != strArr3[1].charAt(22)) {
                    String[] strArr4 = A0c;
                    strArr4[7] = "SY9";
                    strArr4[4] = "T1jNCZgiG5fRSAcWDF";
                    if (ch.A05()) {
                        return;
                    }
                } else {
                    String[] strArr5 = A0c;
                    strArr5[7] = "0UX";
                    strArr5[4] = "cSjXeSxWsZqlnq3791";
                    if (ch.A05()) {
                        return;
                    }
                }
                this.A0O.A07();
            }
        }
    }

    @Override // com.facebook.ads.redexgen.core.DS
    public final void AI1(Bundle bundle) {
    }

    @Override // com.facebook.ads.redexgen.core.DS
    public String getCurrentClientToken() {
        return this.A0I.A1g();
    }

    @Override // com.facebook.ads.redexgen.core.DS
    public final boolean onActivityResult(int i, int i2, Intent intent) {
        return false;
    }

    @Override // android.view.View
    public final void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        if (Build.VERSION.SDK_INT >= 35) {
            setFitsSystemWindows(true);
        }
    }

    @Override // com.facebook.ads.redexgen.core.DS
    public final void onDestroy() {
        this.A0P.A03();
        if (this.A04 != null) {
            this.A04.A0B(this.A0K);
        }
        if (this.A07 != null) {
            if (!TextUtils.isEmpty(this.A0I.A1g())) {
                this.A0M.AAr(this.A0I.A1g(), new FB().A03(this.A07.getViewabilityChecker()).A02(this.A07.getTouchDataRecorder()).A05());
            }
            this.A07.A0C();
        }
        this.A0O.A06();
        this.A0a.setToolbarListener(null);
        this.A03 = null;
        this.A04 = null;
    }

    @Override // android.view.View
    public final void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        if (z) {
            AEs(false);
        } else {
            AEP(false);
        }
    }

    public void setListener(DR dr) {
    }

    public void setServerSideRewardHandler(I7 i7) {
        this.A08 = i7;
    }
}
