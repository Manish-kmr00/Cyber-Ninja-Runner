package com.facebook.ads.redexgen.core;

import android.app.Activity;
import android.net.Uri;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import com.google.common.base.Ascii;
import com.google.common.primitives.SignedBytes;
import java.lang.ref.WeakReference;
import java.util.Arrays;
import kotlin.io.encoding.Base64;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.Dn, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public final class C1536Dn extends FrameLayout {
    public static byte[] A0C;
    public static String[] A0D = {"EYRP1PEEhxzmFZofVXiCCrEXWQs6qPAa", "IPRTBS", "NsAYUXCCkxBbK0XyUhCt1xHChz5fZfMK", "fEJJ0", "6651Qynk9CVpAvzNTMvYSQKVDYa6iazW", "nD7S5n7VHEDKGeK1PzI1a27Vk58dSaaa", "vFV0GS7SjmRPmH7mLZ5yrXn6gSrRknN8", "LPfldR2r"};
    public static final int A0E;
    public boolean A00;
    public final C2860mi A01;
    public final C2699k1 A02;
    public final A7 A03;
    public final AF A04;
    public final C1518Cv A05;
    public final C2560hg A06;
    public final AbstractC1530Dh A07;
    public final JK A08;
    public final JL A09;
    public final String A0A;
    public final WeakReference<InterfaceC1535Dm> A0B;

    /* JADX WARN: Failed to parse debug info
    java.lang.ArrayIndexOutOfBoundsException
     */
    public C1536Dn(C2699k1 c2699k1, A7 a7, C14067t c14067t, WeakReference<InterfaceC1535Dm> weakReference, int i, int i2, int i3, int i4, C2860mi c2860mi, String str) {
        super(c2699k1);
        this.A05 = new C1518Cv();
        this.A02 = c2699k1;
        this.A03 = a7;
        this.A01 = c2860mi;
        this.A0B = weakReference;
        this.A0A = str;
        AbstractC2855md abstractC2855mdA0C = this.A01.A0C();
        if (abstractC2855mdA0C == null) {
            throw new IllegalStateException(A09(0, 32, 86));
        }
        D3.A0K(this, -1);
        this.A04 = new AF(this.A01.A7E(), this.A03);
        this.A08 = A06();
        this.A09 = A07(i, i4, i2, i3);
        LinearLayout linearLayout = new LinearLayout(c2699k1);
        linearLayout.setOrientation(1);
        addView(linearLayout, new FrameLayout.LayoutParams(-1, -1));
        this.A07 = A04(c14067t);
        if (this.A07 != null) {
            linearLayout.addView(this.A07, new LinearLayout.LayoutParams(-1, 0, 1.0f));
        }
        this.A06 = A02(abstractC2855mdA0C);
        linearLayout.addView(this.A06, new LinearLayout.LayoutParams(-1, -2));
    }

    public static String A09(int i, int i2, int i3) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A0C, i, i + i2);
        for (int i4 = 0; i4 < bArrCopyOfRange.length; i4++) {
            byte b = (byte) ((bArrCopyOfRange[i4] - i3) - 99);
            if (A0D[6].charAt(17) == 'I') {
                throw new RuntimeException();
            }
            A0D[6] = "HyV3wef6DGt1nbLL1fRSvAmBe6VeBas4";
            bArrCopyOfRange[i4] = b;
        }
        return new String(bArrCopyOfRange);
    }

    public static void A0F() {
        A0C = new byte[]{-6, Ascii.GS, -39, Ascii.GS, Ascii.SUB, 45, Ascii.SUB, -39, Ascii.ESC, 46, 39, Ascii.GS, 37, Ascii.RS, -39, 34, 44, -39, Ascii.FS, Ascii.SUB, 39, 39, 40, 45, -39, Ascii.ESC, Ascii.RS, -39, 39, 46, 37, 37, 52, SignedBytes.MAX_POWER_OF_TWO, 62, -1, 55, 50, 52, 54, 51, SignedBytes.MAX_POWER_OF_TWO, SignedBytes.MAX_POWER_OF_TWO, 60, -1, 50, 53, 68, -1, 51, 50, 63, 63, 54, 67, -1, 52, Base64.padSymbol, 58, 52, 60, 54, 53};
    }

    static {
        A0F();
        A0E = (int) (CP.A02 * 40.0f);
    }

    private C2560hg A02(AbstractC2855md abstractC2855md) {
        C12622c c12622cA00;
        C2T c2tA1b = abstractC2855md.A1b();
        C1742Lm c1742Lm = new C1742Lm(this);
        if (getOrientation() == 1) {
            c12622cA00 = abstractC2855md.A1a().A01();
        } else {
            C2P c2pA1a = abstractC2855md.A1a();
            String[] strArr = A0D;
            if (strArr[1].length() == strArr[3].length()) {
                throw new RuntimeException();
            }
            A0D[7] = "bY8FFe1Y";
            c12622cA00 = c2pA1a.A00();
        }
        C2560hg c2560hg = new C2560hg(this.A02, A0E, c12622cA00, c2tA1b.A0H().A06(), A09(32, 31, 110), this.A03, c1742Lm, this.A09, this.A05, abstractC2855md.A1c());
        c2560hg.setInfo(c2tA1b.A0G(), c2tA1b.A0H(), this.A01.A7E(), abstractC2855md.A1e().A01(), null, null);
        if (C14499m.A1K(this.A02)) {
            c2560hg.A0N();
        }
        return c2560hg;
    }

    private AbstractC1530Dh A04(C14067t c14067t) {
        ViewOnClickListenerC1533Dk viewOnClickListenerC1533Dk = new ViewOnClickListenerC1533Dk(this);
        String strA0b = this.A01.A0b();
        if (A0H(c14067t, this.A01) && strA0b != null) {
            C2550hW c2550hW = new C2550hW(this.A02, this.A03, c14067t, this.A04, viewOnClickListenerC1533Dk);
            String strA7E = this.A01.A7E();
            String videoUrl = this.A01.A0E() != null ? this.A01.A0E().getUrl() : null;
            C2550hW videoView = c2550hW.A0F(strA7E, strA0b, videoUrl, this.A01.A0O(), this.A01.A0N());
            if (C14499m.A1O(this.A02)) {
                setViewAsCTA(videoView);
            }
            return videoView;
        }
        AU auA0E = this.A01.A0E();
        if (auA0E == null) {
            return null;
        }
        C2558he c2558heA0F = new C2558he(this.A02, viewOnClickListenerC1533Dk).A0F(auA0E.getUrl());
        if (C14499m.A1M(this.A02)) {
            setViewAsCTA(c2558heA0F);
        }
        return c2558heA0F;
    }

    private C2549hV A06() {
        return new C2549hV(this);
    }

    private JL A07(int i, int i2, int i3, int i4) {
        JL jl = new JL(this, i, i2, true, new WeakReference(this.A08), this.A02);
        jl.A0W(i3);
        jl.A0X(i4);
        return jl;
    }

    private void A0C() {
        String strA0J = this.A01.A0J();
        if (!TextUtils.isEmpty(strA0J)) {
            C2 c2 = new C2();
            C2699k1 c2699k1 = this.A02;
            Uri uriA00 = C5.A00(strA0J);
            String adChoicesLinkUrl = this.A01.A7E();
            C2.A0M(c2, c2699k1, uriA00, adChoicesLinkUrl);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void A0D() {
        this.A04.A04(AE.A0A, null);
        if (!AbstractC12933h.A00(this.A02.A02()).A0O(this.A02, false)) {
            A0C();
            return;
        }
        EH ehA01 = EI.A01(this.A02, this.A03, this.A01.A7E(), this);
        if (ehA01 == null) {
            A0C();
            return;
        }
        D3.A0R(this);
        addView(ehA01, new FrameLayout.LayoutParams(-1, -1));
        ehA01.A0K();
    }

    private void A0E() {
        if (getVisibility() == 0 && this.A00 && hasWindowFocus()) {
            this.A09.A0U();
        } else {
            this.A09.A0V();
        }
    }

    public static boolean A0H(C14067t c14067t, C2860mi c2860mi) {
        String strA0b = c2860mi.A0b();
        if (TextUtils.isEmpty(strA0b)) {
            return false;
        }
        String videoUrl = c14067t.A0S(strA0b);
        return !TextUtils.isEmpty(videoUrl);
    }

    public final void A0I() {
        if (this.A07 != null) {
            this.A07.A0A();
        }
        if (this.A09 != null) {
            this.A09.A0V();
        }
        D3.A0H(this);
    }

    public final void A0J() {
        if (this.A07 != null) {
            AbstractC1530Dh abstractC1530Dh = this.A07;
            if (A0D[2].charAt(13) == 'c') {
                throw new RuntimeException();
            }
            String[] strArr = A0D;
            strArr[0] = "hgkEcT5pEsAUKYMkvVnojxGMD5WCOUSh";
            strArr[5] = "qBRuzdoZQfMYUt1SZmDdshQz8Ndd8EXP";
            abstractC1530Dh.A0B();
        }
    }

    private int getOrientation() {
        Activity activity = this.A02.A0E();
        if (activity != null) {
            return activity.getResources().getConfiguration().orientation;
        }
        return 1;
    }

    public JL getViewabilityChecker() {
        return this.A09;
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.A00 = true;
        A0E();
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.A00 = false;
        A0E();
    }

    @Override // android.view.ViewGroup
    public final boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        this.A05.A06(this.A02, motionEvent, this, this);
        return super.onInterceptTouchEvent(motionEvent);
    }

    @Override // android.view.View
    public final void onVisibilityChanged(View view, int i) {
        super.onVisibilityChanged(view, i);
        A0E();
    }

    @Override // android.view.View
    public final void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        A0E();
    }

    private void setViewAsCTA(View view) {
        view.setOnClickListener(new ViewOnClickListenerC1534Dl(this));
    }
}
