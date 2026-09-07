package com.facebook.ads.redexgen.core;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.ColorDrawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.facebook.ads.DefaultMediaViewVideoRenderer;
import com.facebook.ads.MediaView;
import com.facebook.ads.MediaViewListener;
import com.facebook.ads.MediaViewVideoRenderer;
import com.facebook.ads.NativeAd;
import com.facebook.ads.internal.api.AdComponentView;
import com.facebook.ads.internal.api.AdComponentViewApi;
import com.facebook.ads.internal.api.AdComponentViewParentApi;
import com.facebook.ads.internal.api.AdViewConstructorParams;
import com.facebook.ads.internal.api.BuildConfigApi;
import com.facebook.ads.internal.api.MediaViewApi;
import com.facebook.ads.internal.api.NativeAdBaseApi;
import com.facebook.ads.internal.context.Repairable;
import com.facebook.ads.internal.protocol.AdErrorType;
import com.google.common.base.Ascii;
import com.vungle.ads.internal.protos.Sdk;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.kV, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public final class C2729kV extends C13736m implements MediaViewApi, Repairable, AnonymousClass80 {
    public static byte[] A0E;
    public static String[] A0F = {"opPNeHLRCwNMjghH70VvpS5N8kNNBiJu", "eEOY2RUjN4bpbDsCyz0GPhNNbfKnjNLD", "VFQc0pqb8IELGhnpfLoj2hUSBo2VhTCu", "GBUHck22", "gxS7cL5mKFosIlCCzwl1gr8LaZQoy", "JvRhV7isjcFk5", "Q8NK4BrUIZ6kI5bk", "yT7QEu4e"};
    public static final String A0G;
    public View A00;
    public View A01;
    public ImageView A02;
    public MediaView A03;
    public MediaViewListener A04;
    public MediaViewVideoRenderer A05;
    public AdComponentViewParentApi A06;
    public C2699k1 A07;
    public C0X A08;
    public F8 A09;
    public LI A0A;
    public C1638Hl A0B;
    public boolean A0C;
    public boolean A0D;

    public static String A04(int i, int i2, int i3) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A0E, i, i + i2);
        int i4 = 0;
        while (true) {
            int length = bArrCopyOfRange.length;
            String[] strArr = A0F;
            if (strArr[6].length() == strArr[4].length()) {
                throw new RuntimeException();
            }
            String[] strArr2 = A0F;
            strArr2[6] = "ck5ggAbj2vioxfDq";
            strArr2[4] = "NneLGMvrJ83sFMBsADIKrHrKRcoTv";
            if (i4 >= length) {
                return new String(bArrCopyOfRange);
            }
            bArrCopyOfRange[i4] = (byte) ((bArrCopyOfRange[i4] - i3) - 74);
            i4++;
        }
    }

    public static void A08() {
        A0E = new byte[]{-61, -31, -14, -17, -11, -13, -27, -20, -96, -14, -27, -18, -28, -27, -14, -27, -14, -96, -19, -11, -13, -12, -96, -30, -27, -96, -13, -27, -12, -96, -30, -27, -26, -17, -14, -27, -96, -18, -31, -12, -23, -10, -27, -63, -28, -82, 9, 5, 4, 56, 39, 44, 40, 49, 38, 40, 17, 40, 55, 58, 50, 53, 46, -52, -16, -28, -22, -24, -93, -11, -24, -15, -25, -24, -11, -24, -11, -93, -16, -8, -10, -9, -93, -27, -24, -93, -10, -24, -9, -93, -27, -24, -23, -14, -11, -24, -93, -15, -28, -9, -20, -7, -24, -60, -25, -79, -7, Ascii.GS, 17, Ascii.ETB, Ascii.NAK, -48, 34, Ascii.NAK, Ascii.RS, Ascii.DC4, Ascii.NAK, 34, Ascii.NAK, 34, -48, Ascii.GS, 37, 35, 36, -48, Ascii.DC2, Ascii.NAK, -48, 35, Ascii.NAK, 36, -48, Ascii.DC2, Ascii.NAK, Ascii.SYN, Ascii.US, 34, Ascii.NAK, -48, Ascii.RS, 17, 36, Ascii.EM, 38, Ascii.NAK, -14, 17, Ascii.RS, Ascii.RS, Ascii.NAK, 34, -15, Ascii.DC4, -34, -83, -46, -38, -59, -48, -51, -56, -124, -70, -51, -55, -37, -124, -57, -45, -46, -41, -40, -42, -39, -57, -40, -45, -42, -124, -44, -59, -42, -59, -47, -41, -124, -40, -35, -44, -55, -110, -62, -43, -24, -35, -22, -39, -108, -75, -40, -108, -67, -41, -29, -30, -108, -35, -25, -108, -30, -23, -32, -32, -94, -26, -7, -12, -11, -1, -80, 2, -11, -2, -12, -11, 2, -11, 2, -80, -3, 5, 3, 4, -80, -14, -11, -80, 3, -11, 4, -80, -14, -11, -10, -1, 2, -11, -80, -2, -15, 4, -7, 6, -11, -47, -12, -66, -41, -26, -33, -70, -58, -60, -123, -67, -72, -70, -68, -71, -58, -58, -62, -123, -72, -69, -54, -123, -59, -72, -53, -64, -51, -68, -123, -70, -61, -64, -70, -62, -68, -69, -15, -28, -33, -32, -22, -48, -19, -25, -72};
    }

    static {
        A08();
        A0G = MediaView.class.getSimpleName();
    }

    private void A05() {
        if (this.A0A != null) {
            this.A0A.setVisibility(8);
            C4h.A0A(this.A0A.getDynamicWebViewController().A0O(), new ColorDrawable(0));
            this.A03.removeView(this.A0A);
            this.A0A = null;
        }
    }

    private void A06() {
        if (!this.A0D) {
            if (this.A01 != null) {
                D3.A0H(this.A08);
            }
            float f = CP.A02;
            float density = 4.0f * f;
            int hPadding = Math.round(density);
            float density2 = 12.0f * f;
            int vPadding = Math.round(density2);
            this.A08.setChildSpacing(hPadding);
            this.A08.setPadding(0, vPadding, 0, vPadding);
            this.A08.setVisibility(8);
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
            layoutParams.addRule(13);
            this.A01 = this.A08;
            this.A03.addView(this.A01, layoutParams);
            return;
        }
        throw new IllegalStateException(A04(0, 46, 54));
    }

    private void A07() {
        CU.A04(this.A03, CU.A0B);
        CU.A04(this.A09, CU.A0B);
        CU.A04(this.A05, CU.A0B);
        CU.A04(this.A01, CU.A0B);
    }

    private final void A09(View view, ViewGroup.LayoutParams layoutParams) {
        A01(false);
        this.A03.addView(view, layoutParams);
        A01(true);
    }

    private void A0A(View view, C2615ie c2615ie) {
        if (this.A0B != null) {
            this.A03.removeView(this.A0B);
        }
        if (!c2615ie.A1g()) {
            return;
        }
        String strA1D = c2615ie.A1D();
        if (this.A03.getContext() == null) {
            return;
        }
        this.A0B = AbstractC1637Hk.A01(this.A07, strA1D);
        if (this.A0B != null) {
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
            layoutParams.addRule(5, view.getId());
            layoutParams.addRule(7, view.getId());
            layoutParams.addRule(6, view.getId());
            layoutParams.addRule(8, view.getId());
            layoutParams.addRule(16, view.getId());
            layoutParams.addRule(17, view.getId());
            A09(this.A0B, layoutParams);
            this.A06.bringChildToFront(this.A0B);
        }
    }

    private void A0B(ImageView imageView) {
        if (!this.A0D) {
            ImageView imageView2 = this.A02;
            if (A0F[5].length() != 13) {
                throw new RuntimeException();
            }
            A0F[1] = "0pGJtKTiEG7M1QZmgSqLESVqtH6XSoGw";
            if (imageView2 != null) {
                D3.A0H(this.A02);
            }
            imageView.setVisibility(8);
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
            layoutParams.addRule(13);
            this.A03.addView(imageView, layoutParams);
            imageView.setId(D3.A00());
            this.A02 = imageView;
            return;
        }
        throw new IllegalStateException(A04(106, 49, 102));
    }

    private final void A0C(C2699k1 c2699k1, AttributeSet attributeSet, int i, int i2, MediaView mediaView) {
        this.A03 = mediaView;
        A0B(new ImageView(c2699k1, attributeSet, i, i2));
        A0H(new F8(c2699k1, attributeSet, i, i2));
        this.A08 = new C0X(c2699k1, attributeSet, i);
        A06();
        setVideoRenderer(new DefaultMediaViewVideoRenderer(c2699k1, attributeSet, i, i2));
        A07();
    }

    private final void A0D(C2699k1 c2699k1, AttributeSet attributeSet, int i, MediaView mediaView) {
        this.A03 = mediaView;
        A0B(new ImageView(c2699k1, attributeSet, i));
        A0H(new F8(c2699k1, attributeSet, i));
        this.A08 = new C0X(c2699k1, attributeSet, i);
        A06();
        setVideoRenderer(new DefaultMediaViewVideoRenderer(c2699k1, attributeSet, i));
        A07();
    }

    private final void A0E(C2699k1 c2699k1, AttributeSet attributeSet, MediaView mediaView) {
        this.A03 = mediaView;
        A0B(new ImageView(c2699k1, attributeSet));
        A0H(new F8(c2699k1, attributeSet));
        this.A08 = new C0X(c2699k1, attributeSet);
        A06();
        setVideoRenderer(new DefaultMediaViewVideoRenderer(c2699k1, attributeSet));
        A07();
    }

    private final void A0F(C2699k1 c2699k1, MediaView mediaView) {
        this.A03 = mediaView;
        A0B(new ImageView(c2699k1));
        A0H(new F8(c2699k1));
        this.A08 = new C0X(c2699k1);
        A06();
        setVideoRenderer(new DefaultMediaViewVideoRenderer(c2699k1));
        A07();
    }

    private void A0G(C2615ie c2615ie, boolean z, AU au) {
        AsyncTaskC2494gc asyncTaskC2494gcA04 = new AsyncTaskC2494gc(this.A02, this.A07).A04();
        if (z) {
            asyncTaskC2494gcA04.A06(new C2736kc(this, c2615ie));
        }
        asyncTaskC2494gcA04.A07(au.getUrl());
    }

    private void A0H(F8 f8) {
        if (!this.A0D) {
            if (this.A09 != null) {
                this.A03.removeView(this.A09);
            }
            f8.setVisibility(8);
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
            layoutParams.addRule(13);
            this.A03.addView(f8, layoutParams);
            this.A09 = f8;
            return;
        }
        throw new IllegalStateException(A04(63, 43, 57));
    }

    private boolean A0I(NativeAd nativeAd) {
        List<NativeAd> carousel = ((C13856y) nativeAd.getNativeAdApi()).A03();
        if (carousel == null) {
            return false;
        }
        Iterator<NativeAd> it = carousel.iterator();
        while (it.hasNext()) {
            if (it.next().getAdCoverImage() == null) {
                return false;
            }
        }
        if (A0F[5].length() != 13) {
            throw new RuntimeException();
        }
        String[] strArr = A0F;
        strArr[6] = "NNKiamhSotpSBh0S";
        strArr[4] = "WQowSckFUFZtjqKDGN1yGWQ8HKryj";
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean A0J(NativeAd nativeAd) {
        return !TextUtils.isEmpty(((C13856y) nativeAd.getNativeAdApi()).A02());
    }

    /* JADX WARN: Code duplicated, block: B:67:0x02f3  */
    public final void A0L(NativeAd nativeAd) {
        AbstractC2856me my;
        ViewParent parent;
        C2699k1 adObjectContext = ((C2615ie) nativeAd.getInternalNativeAd()).A12();
        adObjectContext.A0O(this);
        this.A07.A0L(adObjectContext);
        this.A07.A0K(adObjectContext.A0F());
        this.A0D = true;
        C2615ie c2615ieA0L = C2615ie.A0L(nativeAd.getInternalNativeAd());
        c2615ieA0L.A1T(this.A03);
        this.A02.setVisibility(8);
        this.A02.setImageDrawable(null);
        if (c2615ieA0L.A10() != null && c2615ieA0L.A10().A1F()) {
            if (!TextUtils.isEmpty(c2615ieA0L.A10().A1b().A0F().A09())) {
                c2615ieA0L.A12().A0F().AIz(EnumC12511r.A0A);
            } else {
                c2615ieA0L.A12().A0F().AIz(EnumC12511r.A09);
            }
            A05();
            this.A09.setVisibility(8);
            this.A09.setImage(null, null);
            this.A05.setVisibility(8);
            this.A05.unsetNativeAd();
            ((C13826v) this.A05.getMediaViewVideoRendererApi()).A03();
            if (this.A01 != null) {
                this.A01.setVisibility(8);
                if (this.A01 instanceof C1574Ez) {
                    ((C1574Ez) this.A01).A04();
                } else {
                    ((MG) this.A01).setAdapter(null);
                }
            }
            A01(false);
            this.A0A = new LI(this.A07, this.A07.A0A(), new C2734ka(this, c2615ieA0L, nativeAd), c2615ieA0L.A10(), A04(261, 31, 13), 4, c2615ieA0L.A1A());
            CU.A04(this.A0A, CU.A0B);
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
            layoutParams.addRule(13);
            this.A03.addView(this.A0A, layoutParams);
            this.A00 = this.A0A;
            bringChildToFront(this.A0A);
            this.A0A.setVisibility(0);
            A0A(this.A0A, c2615ieA0L);
            A01(true);
            return;
        }
        if (A0I(nativeAd)) {
            c2615ieA0L.A12().A0F().AIz(EnumC12511r.A04);
            boolean z = c2615ieA0L.A18() == AX.A0B;
            if (!C14499m.A2l(this.A07) || z) {
                this.A01 = this.A08;
                ((C0X) this.A01).setCurrentPosition(0);
                ((C0X) this.A01).setShowTextInCarousel(z);
                if (!z) {
                    my = new My((C0X) this.A01, c2615ieA0L.A1I(), this.A07);
                } else {
                    my = new C1773Mz(this.A07, (C0X) this.A01, c2615ieA0L.A1I(), c2615ieA0L.A17());
                }
                my.A0H(new C2733kZ(this, c2615ieA0L));
                ((MG) this.A01).setAdapter(my);
            } else {
                A01(false);
                int width = this.A03.getWidth();
                if (width == 0) {
                    if (this.A03.getParent() instanceof ViewGroup) {
                        parent = this.A03.getParent();
                    } else {
                        parent = null;
                    }
                    ViewGroup viewGroup = (ViewGroup) parent;
                    while (width == 0 && viewGroup != null) {
                        width = viewGroup.getWidth();
                        boolean z2 = viewGroup.getParent() instanceof ViewGroup;
                        String[] strArr = A0F;
                        if (strArr[2].charAt(31) != strArr[0].charAt(31)) {
                            throw new RuntimeException();
                        }
                        String[] strArr2 = A0F;
                        strArr2[6] = "X2xGJjQ8zu6cU8Eo";
                        strArr2[4] = "AZj2zr3QMe0wQwV9kynIxRcnRDB4X";
                        viewGroup = (ViewGroup) (z2 ? viewGroup.getParent() : null);
                    }
                }
                D3.A0H(this.A01);
                RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-1, -1);
                layoutParams2.addRule(13);
                this.A01 = new C1574Ez(this.A07);
                this.A03.addView(this.A01, layoutParams2);
                ((C1574Ez) this.A01).A05(c2615ieA0L, width);
                D3.A0I(this.A01);
                A01(true);
            }
            this.A00 = this.A01;
            A05();
            this.A09.setVisibility(8);
            this.A09.setImage(null, null);
            this.A05.setVisibility(8);
            this.A05.unsetNativeAd();
            ((C13826v) this.A05.getMediaViewVideoRendererApi()).A03();
            bringChildToFront(this.A01);
            this.A01.setVisibility(0);
            A0A(this.A01, c2615ieA0L);
            return;
        }
        boolean zA0J = A0J(nativeAd);
        String[] strArr3 = A0F;
        if (strArr3[3].length() != strArr3[7].length()) {
            throw new RuntimeException();
        }
        A0F[5] = "QrlGDx1qLp0kN";
        if (zA0J) {
            c2615ieA0L.A12().A0F().AIz(EnumC12511r.A0D);
            c2615ieA0L.A1e(this.A0C);
            this.A00 = this.A05.getMediaViewVideoRendererApi().getVideoView();
            A05();
            this.A09.setVisibility(8);
            this.A09.setImage(null, null);
            if (this.A01 != null) {
                this.A01.setVisibility(8);
                if (this.A01 instanceof C1574Ez) {
                    ((C1574Ez) this.A01).A04();
                } else {
                    ((MG) this.A01).setAdapter(null);
                }
            }
            bringChildToFront(this.A05);
            MediaViewVideoRenderer mediaViewVideoRenderer = this.A05;
            String[] strArr4 = A0F;
            if (strArr4[2].charAt(31) != strArr4[0].charAt(31)) {
                String[] strArr5 = A0F;
                strArr5[2] = "KRt7yuKunmEFowe58PEdTHnfFAzQvUNu";
                strArr5[0] = "FpiuEPXAVB8biFGx18DJjcPDa6TrT1Ju";
                mediaViewVideoRenderer.setNativeAd(nativeAd);
                ((C13826v) this.A05.getMediaViewVideoRendererApi()).A04(nativeAd);
                this.A05.setVisibility(0);
                if (c2615ieA0L.getAdCoverImage() != null) {
                    new AsyncTaskC2494gc(this.A03, this.A07).A05(this.A03.getHeight(), this.A03.getWidth()).A06(new C2732kY(this, c2615ieA0L)).A07(c2615ieA0L.getAdCoverImage().getUrl());
                }
            } else {
                String[] strArr6 = A0F;
                strArr6[6] = "rknJE6EzKshvoL3E";
                strArr6[4] = "1VlRGSe6v9ZgAEzaXTE4MJVCDSD8V";
                mediaViewVideoRenderer.setNativeAd(nativeAd);
                ((C13826v) this.A05.getMediaViewVideoRendererApi()).A04(nativeAd);
                this.A05.setVisibility(0);
                if (c2615ieA0L.getAdCoverImage() != null) {
                    new AsyncTaskC2494gc(this.A03, this.A07).A05(this.A03.getHeight(), this.A03.getWidth()).A06(new C2732kY(this, c2615ieA0L)).A07(c2615ieA0L.getAdCoverImage().getUrl());
                }
            }
            if (BuildConfigApi.isDebug()) {
                Log.i(A0G, A04(292, 9, 49) + ((C13856y) nativeAd.getNativeAdApi()).A02());
            }
            A0A(this.A05, c2615ieA0L);
            return;
        }
        if (nativeAd.getAdCoverImage() == null) {
            return;
        }
        c2615ieA0L.A12().A0F().AIz(EnumC12511r.A0B);
        this.A00 = this.A09.getBodyImageView();
        A05();
        this.A05.setVisibility(8);
        this.A05.unsetNativeAd();
        ((C13826v) this.A05.getMediaViewVideoRendererApi()).A03();
        if (this.A01 != null) {
            this.A01.setVisibility(8);
            if (this.A01 instanceof C1574Ez) {
                ((C1574Ez) this.A01).A04();
            } else {
                ((MG) this.A01).setAdapter(null);
            }
        }
        bringChildToFront(this.A09);
        this.A09.setVisibility(0);
        new AsyncTaskC2494gc(this.A09, this.A07).A05(this.A03.getHeight(), this.A03.getWidth()).A06(new C2731kX(this, c2615ieA0L)).A07(c2615ieA0L.getAdCoverImage().getUrl());
        A0A(this.A09, c2615ieA0L);
    }

    public final void A0M(NativeAdBaseApi nativeAdBaseApi, boolean z) {
        C2699k1 c2699k1A12 = ((C2615ie) nativeAdBaseApi).A12();
        C2699k1 adObjectContext = this.A07;
        adObjectContext.A0L(c2699k1A12);
        c2699k1A12.A0O(this);
        this.A0D = true;
        C2615ie c2615ieA0L = C2615ie.A0L(nativeAdBaseApi);
        c2615ieA0L.A1S(this.A03);
        this.A09.setVisibility(8);
        this.A09.setImage(null, null);
        this.A05.setVisibility(8);
        this.A05.unsetNativeAd();
        ((C13826v) this.A05.getMediaViewVideoRendererApi()).A03();
        if (this.A01 != null) {
            this.A01.setVisibility(8);
            if (this.A01 instanceof C1574Ez) {
                ((C1574Ez) this.A01).A04();
            } else {
                ((MG) this.A01).setAdapter(null);
            }
        }
        this.A02.setVisibility(0);
        bringChildToFront(this.A02);
        this.A00 = this.A02;
        AU adIcon = c2615ieA0L.getAdIcon();
        if (adIcon != null) {
            C14067t c14067tA11 = c2615ieA0L.A11();
            if (A0F[1].charAt(7) == 'A') {
                throw new RuntimeException();
            }
            String[] strArr = A0F;
            strArr[3] = "8vonm0Gh";
            strArr[7] = "EfYx5Mmt";
            Bitmap bitmapA0M = c14067tA11.A0M(adIcon.getUrl());
            if (bitmapA0M != null) {
                this.A02.setImageBitmap(bitmapA0M);
                if (z) {
                    this.A03.post(new C2737kd(this, c2615ieA0L));
                }
            } else {
                A0G(c2615ieA0L, z, adIcon);
            }
        } else {
            InterfaceC2614id interfaceC2614idA16 = c2615ieA0L.A16();
            AdErrorType adErrorType = AdErrorType.NATIVE_AD_IS_NOT_LOADED;
            c2699k1A12.A0F().A3D(c2615ieA0L.A0y(), adErrorType.getErrorCode(), adErrorType.getDefaultErrorMessage());
            if (interfaceC2614idA16 != null) {
                interfaceC2614idA16.AD4(C1468Ag.A00(adErrorType));
            }
            Log.e(A04(46, 17, Sdk.SDKError.Reason.TPAT_ERROR_VALUE), adErrorType.getDefaultErrorMessage());
            if (nativeAdBaseApi.isAdLoaded()) {
                C2699k1 adObjectContext2 = this.A07;
                adObjectContext2.A08().AAu(A04(258, 3, 44), AbstractC14128a.A0W, new C14138b(A04(192, 23, 42)));
            }
        }
        A0A(this.A02, c2615ieA0L);
    }

    public final boolean A0N() {
        if (this.A01 != null) {
            View view = this.A01;
            if (A0F[5].length() != 13) {
                throw new RuntimeException();
            }
            String[] strArr = A0F;
            strArr[3] = "f43XNCk8";
            strArr[7] = "DdRxJSTL";
            if (view.getVisibility() == 0) {
                return true;
            }
        }
        return false;
    }

    @Override // com.facebook.ads.redexgen.core.AnonymousClass80
    public final C2699k1 A6c() {
        return this.A07;
    }

    @Override // com.facebook.ads.redexgen.core.C13736m, com.facebook.ads.internal.api.AdComponentViewParentApi
    public final void bringChildToFront(View view) {
        if (view != this.A01 && view != this.A05 && view != this.A09) {
            ImageView imageView = this.A02;
            if (A0F[5].length() != 13) {
                throw new RuntimeException();
            }
            A0F[1] = "R8dYcckG0onv7yQggjKFRkmHXZbq9UJh";
            if (view != imageView) {
                return;
            }
        }
        this.A06.bringChildToFront(view);
        if (this.A0B != null) {
            this.A06.bringChildToFront(this.A0B);
        }
    }

    @Override // com.facebook.ads.internal.api.MediaViewApi
    public final void destroy() {
        this.A05.pause(false);
        this.A05.getMediaViewVideoRendererApi().destroy();
    }

    @Override // com.facebook.ads.internal.api.AdComponentViewApiProvider
    public final AdComponentViewApi getAdComponentViewApi() {
        return this;
    }

    @Override // com.facebook.ads.internal.api.MediaViewApi
    public final View getAdContentsView() {
        return this.A00;
    }

    @Override // com.facebook.ads.internal.api.MediaViewApi
    public final int getMediaHeight() {
        if (this.A09.getVisibility() == 0) {
            return this.A09.getImageHeight();
        }
        if (this.A05.getVisibility() == 0) {
            return this.A05.getMediaViewVideoRendererApi().getVideoView().getHeight();
        }
        if (this.A03.getVisibility() == 0) {
            return this.A03.getHeight();
        }
        return 0;
    }

    /* JADX WARN: Code restructure failed: missing block: B:13:0x0055, code lost:
    
        if (r3.getVisibility() == 0) goto L14;
     */
    /* JADX WARN: Code restructure failed: missing block: B:15:0x0065, code lost:
    
        return r4.A05.getMediaViewVideoRendererApi().getVideoView().getWidth();
     */
    /* JADX WARN: Code restructure failed: missing block: B:17:0x006a, code lost:
    
        if (r3.getVisibility() == 0) goto L14;
     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x0073, code lost:
    
        if (r4.A03.getVisibility() != 0) goto L23;
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x007b, code lost:
    
        return r4.A03.getWidth();
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x007c, code lost:
    
        return 0;
     */
    @Override // com.facebook.ads.internal.api.MediaViewApi
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final int getMediaWidth() {
        /*
            r4 = this;
            com.facebook.ads.redexgen.X.F8 r0 = r4.A09
            int r0 = r0.getVisibility()
            if (r0 != 0) goto L35
            com.facebook.ads.redexgen.X.F8 r0 = r4.A09
            int r3 = r0.getImageWidth()
            java.lang.String[] r2 = com.facebook.ads.redexgen.core.C2729kV.A0F
            r0 = 2
            r1 = r2[r0]
            r0 = 0
            r2 = r2[r0]
            r0 = 31
            char r1 = r1.charAt(r0)
            char r0 = r2.charAt(r0)
            if (r1 == r0) goto L28
            java.lang.RuntimeException r0 = new java.lang.RuntimeException
            r0.<init>()
            throw r0
        L28:
            java.lang.String[] r2 = com.facebook.ads.redexgen.core.C2729kV.A0F
            java.lang.String r1 = "us0p5hBNoGIfish2"
            r0 = 6
            r2[r0] = r1
            java.lang.String r1 = "DFvDCw92fILzmemlu9XfPwpsPQRiq"
            r0 = 4
            r2[r0] = r1
            return r3
        L35:
            com.facebook.ads.MediaViewVideoRenderer r3 = r4.A05
            java.lang.String[] r1 = com.facebook.ads.redexgen.core.C2729kV.A0F
            r0 = 1
            r1 = r1[r0]
            r0 = 7
            char r1 = r1.charAt(r0)
            r0 = 65
            if (r1 == r0) goto L66
            java.lang.String[] r2 = com.facebook.ads.redexgen.core.C2729kV.A0F
            java.lang.String r1 = "7zc9sXuG"
            r0 = 3
            r2[r0] = r1
            java.lang.String r1 = "ncWuDUJK"
            r0 = 7
            r2[r0] = r1
            int r0 = r3.getVisibility()
            if (r0 != 0) goto L6d
        L57:
            com.facebook.ads.MediaViewVideoRenderer r0 = r4.A05
            com.facebook.ads.internal.api.MediaViewVideoRendererApi r0 = r0.getMediaViewVideoRendererApi()
            android.view.View r0 = r0.getVideoView()
            int r0 = r0.getWidth()
            return r0
        L66:
            int r0 = r3.getVisibility()
            if (r0 != 0) goto L6d
            goto L57
        L6d:
            com.facebook.ads.MediaView r0 = r4.A03
            int r0 = r0.getVisibility()
            if (r0 != 0) goto L7c
            com.facebook.ads.MediaView r0 = r4.A03
            int r0 = r0.getWidth()
            return r0
        L7c:
            r0 = 0
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.core.C2729kV.getMediaWidth():int");
    }

    @Override // com.facebook.ads.internal.api.MediaViewApi
    public final void initialize(AdViewConstructorParams adViewConstructorParams, MediaView mediaView) {
        Context context = adViewConstructorParams.getContext();
        if (context instanceof C2699k1) {
            this.A07 = (C2699k1) context;
        } else {
            this.A07 = C13766p.A03(context);
        }
        this.A07.A0O(this);
        switch (adViewConstructorParams.getInitializationType()) {
            case 0:
                A0F(this.A07, mediaView);
                break;
            case 1:
                A0E(this.A07, adViewConstructorParams.getAttributeSet(), mediaView);
                break;
            case 2:
                C2699k1 c2699k1 = this.A07;
                AttributeSet attributeSet = adViewConstructorParams.getAttributeSet();
                if (A0F[1].charAt(7) == 'A') {
                    throw new RuntimeException();
                }
                A0F[1] = "4tObUcmoIw93Quo4uXvWt9YCbUPkknut";
                A0D(c2699k1, attributeSet, adViewConstructorParams.getDefStyleAttr(), mediaView);
                break;
                break;
            case 3:
                A0C(this.A07, adViewConstructorParams.getAttributeSet(), adViewConstructorParams.getDefStyleAttr(), adViewConstructorParams.getDefStyleRes(), mediaView);
                break;
            default:
                throw new IllegalArgumentException(A04(155, 37, 26));
        }
        A01(true);
    }

    @Override // com.facebook.ads.redexgen.core.C13736m, com.facebook.ads.internal.api.AdComponentViewApi
    public final void onAttachedToView(AdComponentView adComponentView, AdComponentViewParentApi adComponentViewParentApi) {
        super.onAttachedToView(adComponentView, adComponentViewParentApi);
        this.A06 = adComponentViewParentApi;
    }

    @Override // com.facebook.ads.internal.context.Repairable
    public final void repair(Throwable th) {
        int width = this.A03.getWidth();
        int currentHeight = this.A03.getHeight();
        if (width > 0 && currentHeight > 0) {
            this.A03.repair(th);
            this.A03.getLayoutParams().width = width;
            this.A03.getLayoutParams().height = currentHeight;
            this.A03.setBackgroundColor(-3355444);
            return;
        }
        this.A03.repair(th);
    }

    @Override // com.facebook.ads.internal.api.MediaViewApi
    public final void setListener(MediaViewListener mediaViewListener) {
        this.A04 = mediaViewListener;
        if (mediaViewListener == null) {
            ((C13826v) this.A05.getMediaViewVideoRendererApi()).A07(null);
        } else {
            ((C13826v) this.A05.getMediaViewVideoRendererApi()).A07(new C2730kW(this, mediaViewListener));
        }
    }

    @Override // com.facebook.ads.internal.api.MediaViewApi
    public final void setVideoRenderer(MediaViewVideoRenderer mediaViewVideoRenderer) {
        if (!this.A0D) {
            if (this.A05 != null) {
                this.A03.removeView(this.A05);
                this.A05.getMediaViewVideoRendererApi().destroy();
            }
            ((C13826v) mediaViewVideoRenderer.getMediaViewVideoRendererApi()).A05(this.A07.A0A());
            mediaViewVideoRenderer.setVisibility(8);
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
            layoutParams.addRule(13);
            ((C2729kV) this.A03.getMediaViewApi()).A09(mediaViewVideoRenderer, layoutParams);
            this.A05 = mediaViewVideoRenderer;
            this.A0C = !(this.A05 instanceof DefaultMediaViewVideoRenderer);
            mediaViewVideoRenderer.setId(D3.A00());
            return;
        }
        throw new IllegalStateException(A04(Sdk.SDKError.Reason.AD_RESPONSE_EMPTY_VALUE, 43, 70));
    }
}
