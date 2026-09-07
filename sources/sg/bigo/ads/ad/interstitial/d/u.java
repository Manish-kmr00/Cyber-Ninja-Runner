package sg.bigo.ads.ad.interstitial.d;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.GradientDrawable;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.URLUtil;
import android.webkit.ValueCallback;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.HorizontalScrollView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import androidx.core.view.ViewCompat;
import sg.bigo.ads.R;
import sg.bigo.ads.ad.interstitial.multi_img.view.IconListView;
import sg.bigo.ads.api.MediaView;
import sg.bigo.ads.common.view.AdImageView;
import sg.bigo.ads.common.view.AutoNextLineLinearLayout;
import sg.bigo.ads.common.view.RoundedFrameLayout;
import sg.bigo.ads.common.view.RoundedImageView;

/* JADX INFO: loaded from: classes6.dex */
public class u extends a {
    private Bitmap A;
    private float x;
    protected MediaView y;
    private float z;

    public u(sg.bigo.ads.ad.b.c cVar) {
        super(cVar);
    }

    private RoundedFrameLayout a(final ViewGroup viewGroup, Context context, String str, Bitmap bitmap, int i, final boolean z, boolean z2) {
        final RoundedFrameLayout roundedFrameLayout = new RoundedFrameLayout(context);
        roundedFrameLayout.setCornerRadius(sg.bigo.ads.common.utils.e.a(context, 4));
        roundedFrameLayout.setStrokeWidth(sg.bigo.ads.common.utils.e.a(context, 1));
        roundedFrameLayout.setStrokeColor(sg.bigo.ads.common.utils.q.b("#08000000", -7829368));
        final AdImageView adImageView = new AdImageView(context);
        final int iA = sg.bigo.ads.common.utils.e.a(context, 200);
        adImageView.setBlurBorder(false);
        if (bitmap == null) {
            adImageView.setBackgroundColor(sg.bigo.ads.common.utils.q.b("#FFE1E1E6", -7829368));
            adImageView.setImageDrawable(sg.bigo.ads.common.utils.a.a(context, R.drawable.bigo_ad_icon_default_only_icon));
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, iA);
            layoutParams.width = iA;
            layoutParams.height = iA;
            roundedFrameLayout.setLayoutParams(layoutParams);
            adImageView.setLayoutParams(new FrameLayout.LayoutParams(-2, iA));
            adImageView.a(new sg.bigo.ads.common.p.g() { // from class: sg.bigo.ads.ad.interstitial.d.u.5
                @Override // sg.bigo.ads.common.p.g
                public final void a(int i2, String str2, String str3) {
                }

                @Override // sg.bigo.ads.common.p.g
                public final void a(Bitmap bitmap2, sg.bigo.ads.common.p.f fVar) {
                    if (u.this.c.g) {
                        return;
                    }
                    adImageView.setBackground(null);
                    sg.bigo.ads.common.p pVarB = u.b(bitmap2, viewGroup, iA, z);
                    ViewGroup.LayoutParams layoutParams2 = roundedFrameLayout.getLayoutParams();
                    layoutParams2.width = pVarB.getWidth();
                    layoutParams2.height = pVarB.getHeight();
                    roundedFrameLayout.setLayoutParams(layoutParams2);
                    ViewGroup.LayoutParams layoutParams3 = adImageView.getLayoutParams();
                    layoutParams3.width = pVarB.getWidth();
                    layoutParams3.height = pVarB.getHeight();
                    adImageView.setLayoutParams(layoutParams3);
                    if (z) {
                        u.this.a(viewGroup, bitmap2, pVarB, iA);
                    }
                }
            });
            adImageView.a(str, ((sg.bigo.ads.core.a.a) this.c.f()).al());
        } else {
            sg.bigo.ads.common.p pVarB = b(bitmap, viewGroup, iA, z);
            roundedFrameLayout.setLayoutParams(new FrameLayout.LayoutParams(pVarB.getWidth(), pVarB.getHeight()));
            adImageView.setImageBitmap(bitmap);
            if (z) {
                a(viewGroup, bitmap, pVarB, iA);
            }
        }
        adImageView.setScaleType(ImageView.ScaleType.FIT_XY);
        roundedFrameLayout.addView(adImageView);
        if (i != 1 && i != 2) {
            sg.bigo.ads.ad.b.a.a(viewGroup, roundedFrameLayout, 8, this.c, i);
        }
        if (z2 && !z) {
            sg.bigo.ads.common.e.a.a((View) roundedFrameLayout, 10);
            roundedFrameLayout.setBackgroundColor(-1);
        }
        return roundedFrameLayout;
    }

    private void a(final View view, final int i, final int i2) {
        view.setOnTouchListener(new View.OnTouchListener() { // from class: sg.bigo.ads.ad.interstitial.d.u.6
            @Override // android.view.View.OnTouchListener
            public final boolean onTouch(View view2, MotionEvent motionEvent) {
                sg.bigo.ads.ad.b.c cVar;
                int actionMasked = motionEvent.getActionMasked();
                if (actionMasked == 0) {
                    u.this.x = motionEvent.getX();
                    u.this.z = motionEvent.getY();
                    return !view.isScrollContainer();
                }
                if (actionMasked != 1) {
                    return false;
                }
                float x = motionEvent.getX();
                float y = motionEvent.getY();
                boolean zA = sg.bigo.ads.common.utils.u.a(view, Math.round(u.this.x), Math.round(u.this.z));
                boolean zA2 = sg.bigo.ads.common.utils.u.a(view, Math.round(x), Math.round(y));
                Object tag = view.getTag();
                int iIntValue = i;
                if (tag instanceof Integer) {
                    iIntValue = ((Integer) tag).intValue();
                }
                int i3 = iIntValue;
                int i4 = i2;
                if (2 == i4) {
                    if (zA && zA2) {
                        cVar = u.this.c;
                    }
                    return false;
                }
                if (3 == i4 || 1 != i4 || !zA) {
                    return false;
                }
                cVar = u.this.c;
                cVar.a(Math.round(x), Math.round(y), Math.round(u.this.x), Math.round(u.this.z), 8, i3);
                return false;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(final ViewGroup viewGroup, final Bitmap bitmap, sg.bigo.ads.common.p pVar, final int i) {
        FrameLayout frameLayout = (FrameLayout) viewGroup.findViewById(R.id.fl_multi_container);
        if (frameLayout != null) {
            int i2 = viewGroup.getContext().getResources().getDisplayMetrics().widthPixels;
            int iA = sg.bigo.ads.common.utils.e.a(viewGroup.getContext(), 20);
            final int i3 = i2 - (iA * 2);
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) frameLayout.getLayoutParams();
            marginLayoutParams.leftMargin = iA;
            marginLayoutParams.rightMargin = iA;
            frameLayout.setLayoutParams(marginLayoutParams);
            if (pVar.getWidth() < i3) {
                final ImageView imageView = (ImageView) viewGroup.findViewById(R.id.iv_blur_bg);
                final View viewFindViewById = viewGroup.findViewById(R.id.iv_blur_bg_mask);
                if (imageView == null || bitmap == null) {
                    return;
                }
                sg.bigo.ads.common.n.d.a(1, new Runnable() { // from class: sg.bigo.ads.ad.interstitial.d.u.4
                    @Override // java.lang.Runnable
                    public final void run() {
                        final Bitmap bitmapB = sg.bigo.ads.common.utils.d.b(viewGroup.getContext(), bitmap);
                        if (bitmapB == null || u.this.c.g) {
                            return;
                        }
                        imageView.post(new Runnable() { // from class: sg.bigo.ads.ad.interstitial.d.u.4.1
                            @Override // java.lang.Runnable
                            public final void run() {
                                imageView.setImageBitmap(bitmapB);
                                ViewGroup.LayoutParams layoutParams = imageView.getLayoutParams();
                                layoutParams.width = i3;
                                layoutParams.height = i;
                                imageView.setLayoutParams(layoutParams);
                                if (viewFindViewById != null) {
                                    ViewGroup.LayoutParams layoutParams2 = viewFindViewById.getLayoutParams();
                                    layoutParams2.width = i3;
                                    layoutParams2.height = i;
                                    viewFindViewById.setLayoutParams(layoutParams2);
                                }
                            }
                        });
                    }
                });
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(ViewGroup viewGroup, String[] strArr, boolean z) {
        int i;
        int i2;
        int i3;
        int i4;
        int i5;
        Context context;
        int i6;
        FrameLayout.LayoutParams layoutParams;
        int iA = this.t == null ? 0 : this.t.a("video_play_page.click_type");
        View view = (ScrollView) viewGroup.findViewById(R.id.native_view);
        HorizontalScrollView horizontalScrollView = (HorizontalScrollView) viewGroup.findViewById(R.id.bigo_ad_scroll_images);
        LinearLayout linearLayout = new LinearLayout(viewGroup.getContext());
        linearLayout.setOrientation(0);
        Context context2 = viewGroup.getContext();
        boolean z2 = strArr == null || strArr.length == 0 || strArr.length == 1;
        int i7 = 8;
        int i8 = -2;
        if (z2) {
            linearLayout.addView(a(viewGroup, context2, (strArr == null || 1 != strArr.length) ? "" : strArr[0], this.g, iA, true, z));
            i = -2;
            i2 = 8;
        } else {
            int iA2 = sg.bigo.ads.common.utils.e.a(context2, 20);
            int iA3 = sg.bigo.ads.common.utils.e.a(context2, 12);
            int i9 = 0;
            while (i9 < strArr.length) {
                String str = strArr[i9];
                if (TextUtils.isEmpty(str) || !URLUtil.isNetworkUrl(str)) {
                    i3 = i9;
                    i4 = iA2;
                    i5 = i8;
                    context = context2;
                    i6 = i7;
                } else {
                    i3 = i9;
                    int i10 = iA2;
                    context = context2;
                    i6 = i7;
                    RoundedFrameLayout roundedFrameLayoutA = a(viewGroup, context2, str, (Bitmap) null, iA, false, z);
                    i5 = -2;
                    LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
                    layoutParams2.leftMargin = i3 == 0 ? i10 : iA3;
                    if (i3 + 1 == strArr.length) {
                        i4 = i10;
                        layoutParams2.rightMargin = i4;
                    } else {
                        i4 = i10;
                    }
                    linearLayout.addView(roundedFrameLayoutA, layoutParams2);
                    if (iA == 2) {
                        sg.bigo.ads.ad.b.a.a(viewGroup, roundedFrameLayoutA, i6, this.c, iA);
                    }
                }
                i9 = i3 + 1;
                i8 = i5;
                iA2 = i4;
                i7 = i6;
                context2 = context;
            }
            i = i8;
            i2 = i7;
        }
        if (z2) {
            layoutParams = new FrameLayout.LayoutParams(i, i);
            layoutParams.gravity = 17;
        } else {
            layoutParams = new FrameLayout.LayoutParams(i, sg.bigo.ads.common.utils.e.a(viewGroup.getContext(), 202));
        }
        horizontalScrollView.addView(linearLayout, layoutParams);
        if (iA == 3) {
            if (z2 && this.s != null && this.s.f) {
                horizontalScrollView.setTag(9);
                sg.bigo.ads.ad.b.a.a(viewGroup, horizontalScrollView, i2, this.c, iA);
                return;
            }
            return;
        }
        if (z2 && this.s != null && this.s.f) {
            horizontalScrollView.setTag(9);
            sg.bigo.ads.ad.b.a.a(viewGroup, horizontalScrollView, i2, this.c, iA);
        } else {
            a(horizontalScrollView, 5, iA);
        }
        if (view != null) {
            a(view, 10, iA);
        }
    }

    static /* synthetic */ void a(u uVar, final ViewGroup viewGroup) {
        final ImageView imageView = (ImageView) viewGroup.findViewById(R.id.iv_media_blur_bg);
        final View viewFindViewById = viewGroup.findViewById(R.id.iv_media_blur_bg_mask);
        if (uVar.y == null || imageView == null || uVar.A == null) {
            return;
        }
        sg.bigo.ads.common.n.d.a(1, new Runnable() { // from class: sg.bigo.ads.ad.interstitial.d.u.2
            @Override // java.lang.Runnable
            public final void run() {
                final Bitmap bitmapB = sg.bigo.ads.common.utils.d.b(viewGroup.getContext(), u.this.A);
                if (bitmapB == null || u.this.c.g) {
                    return;
                }
                imageView.post(new Runnable() { // from class: sg.bigo.ads.ad.interstitial.d.u.2.1
                    @Override // java.lang.Runnable
                    public final void run() {
                        imageView.setImageBitmap(bitmapB);
                        ViewGroup.LayoutParams layoutParams = imageView.getLayoutParams();
                        int height = u.this.y.getHeight();
                        layoutParams.height = height;
                        layoutParams.width = u.this.A();
                        imageView.setLayoutParams(layoutParams);
                        if (viewFindViewById != null) {
                            ViewGroup.LayoutParams layoutParams2 = viewFindViewById.getLayoutParams();
                            layoutParams2.height = height;
                            layoutParams2.width = u.this.A();
                            viewFindViewById.setLayoutParams(layoutParams2);
                        }
                    }
                });
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static sg.bigo.ads.common.p b(Bitmap bitmap, ViewGroup viewGroup, int i, boolean z) {
        int iA = sg.bigo.ads.common.utils.e.a(viewGroup.getContext(), 20);
        sg.bigo.ads.common.p pVarA = sg.bigo.ads.common.p.a(bitmap.getWidth(), bitmap.getHeight(), i);
        if (!z) {
            return pVarA;
        }
        if (pVarA.getWidth() >= viewGroup.getContext().getResources().getDisplayMetrics().widthPixels - iA) {
            return pVarA;
        }
        return sg.bigo.ads.common.p.a(bitmap.getWidth(), bitmap.getHeight(), i - iA);
    }

    protected int A() {
        return -1;
    }

    @Override // sg.bigo.ads.ad.interstitial.d.a
    protected final void a(double d) {
    }

    @Override // sg.bigo.ads.ad.interstitial.d.a
    protected final void a(int i) {
        if (this.q != null) {
            this.q.setBackgroundColor(i);
        }
    }

    @Override // sg.bigo.ads.ad.interstitial.t
    public final void a(ViewGroup viewGroup, View view, int i, int i2, int i3, View... viewArr) {
        super.a(viewGroup, view, i, i2, i3, viewArr);
        MediaView mediaView = this.y;
        if (mediaView != null) {
            mediaView.b().a(new sg.bigo.ads.core.player.b.b() { // from class: sg.bigo.ads.ad.interstitial.d.u.1
                @Override // sg.bigo.ads.core.player.b.b
                public final void a(Bitmap bitmap) {
                    if (u.this.c.g || bitmap == null || u.this.q == null) {
                        return;
                    }
                    u.this.A = bitmap;
                    u.this.q.post(new Runnable() { // from class: sg.bigo.ads.ad.interstitial.d.u.1.1
                        @Override // java.lang.Runnable
                        public final void run() {
                            u.a(u.this, u.this.q);
                        }
                    });
                }
            });
        }
        boolean z = false;
        int i4 = this.s != null ? this.s.i : 0;
        View viewFindViewById = viewGroup.findViewById(R.id.inter_media_container);
        sg.bigo.ads.ad.b.a.a(viewFindViewById, 9);
        if (this.s == null || !this.s.g) {
            MediaView mediaView2 = this.y;
            if (mediaView2 != null) {
                mediaView2.setOtherClickAreaClick(false);
            }
            if (viewFindViewById != null) {
                sg.bigo.ads.ad.b.a.a(viewGroup, viewFindViewById, 8, sg.bigo.ads.ad.interstitial.a.F, 0);
            }
        } else {
            MediaView mediaView3 = this.y;
            if (mediaView3 != null) {
                mediaView3.setOtherClickAreaClick(true);
            }
            if (viewFindViewById != null) {
                sg.bigo.ads.ad.b.a.a(viewGroup, viewFindViewById, 8, this.c, i4);
            }
        }
        if (this.s != null && this.s.f) {
            z = true;
        }
        MediaView mediaView4 = this.y;
        if (mediaView4 != null) {
            sg.bigo.ads.ad.b.a.a(viewGroup, mediaView4, 8, this.c, i4);
            this.y.setMediaAreaClickable(z);
            this.y.b().a(!z);
        }
    }

    protected void a(ViewGroup viewGroup, sg.bigo.ads.common.p pVar) {
        View viewFindViewById = viewGroup.findViewById(R.id.bigo_ad_mask_vertical);
        ViewGroup.LayoutParams layoutParams = viewFindViewById.getLayoutParams();
        layoutParams.height = pVar.getHeight();
        viewFindViewById.setLayoutParams(layoutParams);
    }

    protected void c(ViewGroup viewGroup) {
        sg.bigo.ads.common.p pVarA = sg.bigo.ads.ad.interstitial.r.a(((sg.bigo.ads.ad.interstitial.t) this).c);
        sg.bigo.ads.common.p pVarB = sg.bigo.ads.common.p.b(pVarA.getWidth(), pVarA.getHeight(), viewGroup.getContext().getResources().getDisplayMetrics().widthPixels);
        LinearLayout linearLayout = (LinearLayout) viewGroup.findViewById(R.id.bigo_ad_material_container);
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) linearLayout.getLayoutParams();
        layoutParams.topMargin = pVarB.getHeight() - sg.bigo.ads.common.utils.e.a(viewGroup.getContext(), 25);
        linearLayout.setLayoutParams(layoutParams);
        ViewGroup.LayoutParams layoutParams2 = this.y.getLayoutParams();
        layoutParams2.height = pVarB.getHeight();
        this.y.setLayoutParams(layoutParams2);
        a(viewGroup, pVarB);
    }

    @Override // sg.bigo.ads.ad.interstitial.d.a
    public final ViewGroup k() {
        return this.y;
    }

    @Override // sg.bigo.ads.ad.interstitial.d.a
    public final MediaView l() {
        return this.y;
    }

    @Override // sg.bigo.ads.ad.interstitial.d.a
    public final Button m() {
        return null;
    }

    @Override // sg.bigo.ads.ad.interstitial.d.a
    protected final void o() {
        String[] strArrE;
        int i;
        u uVar = this;
        int iX = x();
        if (iX == 1) {
            uVar.a(-1);
        } else {
            uVar.a(ViewCompat.MEASURED_STATE_MASK);
        }
        int i2 = 0;
        final boolean z = iX == 1;
        if (uVar.q != null) {
            final ViewGroup viewGroup = uVar.q;
            sg.bigo.ads.api.core.c.d popPage = uVar.c.getPopPage();
            if (popPage != null && popPage.e() != null && popPage.e().length > 0) {
                strArrE = popPage.e();
            } else if (((sg.bigo.ads.core.a.a) uVar.c.f()).aw() != null) {
                sg.bigo.ads.api.core.o.a[] aVarArrAw = ((sg.bigo.ads.core.a.a) uVar.c.f()).aw();
                String[] strArr = new String[aVarArrAw.length];
                for (int i3 = 0; i3 < aVarArrAw.length; i3++) {
                    strArr[i3] = aVarArrAw[i3].c();
                }
                strArrE = strArr;
            } else {
                strArrE = null;
            }
            boolean zIsEmpty = strArrE == null || strArrE.length == 0;
            if (strArrE != null && 1 == strArrE.length) {
                zIsEmpty = TextUtils.isEmpty(strArrE[0]);
            }
            if (zIsEmpty) {
                uVar.a(new ValueCallback<Bitmap>() { // from class: sg.bigo.ads.ad.interstitial.d.u.3
                    @Override // android.webkit.ValueCallback
                    public final /* synthetic */ void onReceiveValue(Bitmap bitmap) {
                        u.this.a(viewGroup, (String[]) null, z);
                    }
                });
            } else {
                uVar.a(viewGroup, strArrE, z);
            }
            ViewGroup viewGroup2 = uVar.q;
            IconListView iconListView = (IconListView) viewGroup2.findViewById(R.id.download_msg_list);
            if (iconListView != null && uVar.u != null) {
                iconListView.setThemeWhite(!z);
                iconListView.a(uVar.u);
                sg.bigo.ads.ad.b.a.a(viewGroup2, iconListView, 8, uVar.c, 0);
            }
            ViewGroup viewGroup3 = uVar.q;
            int i4 = z ? -16777216 : -1;
            int iB = z ? sg.bigo.ads.common.utils.q.b("#B3000000", ViewCompat.MEASURED_STATE_MASK) : sg.bigo.ads.common.utils.q.b("#B3FFFFFF", -1);
            ((TextView) viewGroup3.findViewById(R.id.inter_title)).setTextColor(i4);
            ((TextView) viewGroup3.findViewById(R.id.tv_gp_info_extra_about)).setTextColor(i4);
            ((TextView) viewGroup3.findViewById(R.id.inter_description)).setTextColor(iB);
            ((TextView) viewGroup3.findViewById(R.id.tv_desc_below)).setTextColor(iB);
            View viewFindViewById = uVar.q.findViewById(R.id.bigo_ad_mask_vertical);
            GradientDrawable gradientDrawable = (GradientDrawable) viewFindViewById.getBackground();
            int[] iArr = new int[2];
            if (z) {
                iArr[0] = 16777215;
                iArr[1] = -1;
            } else {
                iArr[0] = 2105636;
                iArr[1] = -16777216;
            }
            gradientDrawable.setColors(iArr);
            viewFindViewById.setBackground(gradientDrawable);
            ViewGroup viewGroup4 = uVar.q;
            RoundedImageView roundedImageView = (RoundedImageView) viewGroup4.findViewById(R.id.inter_icon);
            if (roundedImageView != null) {
                roundedImageView.setCornerRadius(sg.bigo.ads.common.utils.e.a(viewGroup4.getContext(), 6));
            }
            if (uVar.v != null) {
                int iF = ((sg.bigo.ads.core.a.a) uVar.c.f()).B() == null ? 0 : ((sg.bigo.ads.core.a.a) uVar.c.f()).B().f();
                if (iF > 0) {
                    float f = iF * 0.01f;
                    if (f > 0.15f) {
                        f = 0.15f;
                    }
                    int iRound = Math.round(sg.bigo.ads.common.utils.e.c(uVar.v.getContext()) * f);
                    ViewGroup.LayoutParams layoutParams = uVar.v.getLayoutParams();
                    layoutParams.height = iRound;
                    uVar.v.setLayoutParams(layoutParams);
                } else {
                    uVar.v.setVisibility(8);
                }
                uVar.v.setTextColor(z ? sg.bigo.ads.common.utils.q.b("#4D202124", ViewCompat.MEASURED_STATE_MASK) : sg.bigo.ads.common.utils.q.b("#4DFFFFFF", -1));
            }
            Button button = (Button) uVar.q.findViewById(R.id.inter_btn_cta);
            ViewGroup viewGroup5 = (ViewGroup) uVar.q.findViewById(R.id.inter_btn_cta_layout);
            if (button != null && viewGroup5 != null) {
                ViewGroup viewGroup6 = uVar.q;
                a.C0838a c0838aU = u();
                sg.bigo.ads.ad.interstitial.d.b(button, c0838aU.f12723a);
                if (v()) {
                    sg.bigo.ads.ad.interstitial.c.e(viewGroup5);
                }
                TextView textView = (TextView) viewGroup6.findViewById(R.id.inter_company);
                if (textView != null) {
                    textView.setTextColor(c0838aU.f12723a);
                }
            }
            sg.bigo.ads.api.core.c.d popPage2 = uVar.c.getPopPage();
            if (popPage2 == null || popPage2.d() == null) {
                return;
            }
            ViewGroup viewGroup7 = uVar.q;
            AutoNextLineLinearLayout autoNextLineLinearLayout = (AutoNextLineLinearLayout) uVar.q.findViewById(R.id.fbl_genre);
            String[] strArrD = popPage2.d();
            try {
                Context context = viewGroup7.getContext();
                int iA = sg.bigo.ads.common.utils.e.a(context, 1);
                int iA2 = sg.bigo.ads.common.utils.e.a(context, 5);
                int iA3 = sg.bigo.ads.common.utils.e.a(context, 12);
                int iA4 = sg.bigo.ads.common.utils.e.a(context, 14);
                int iA5 = sg.bigo.ads.common.utils.e.a(context, 28);
                int iB2 = z ? sg.bigo.ads.common.utils.q.b("#B3000000", ViewCompat.MEASURED_STATE_MASK) : sg.bigo.ads.common.utils.q.b("#B3FFFFFF", -1);
                int iB3 = z ? sg.bigo.ads.common.utils.q.b("#26202124", ViewCompat.MEASURED_STATE_MASK) : sg.bigo.ads.common.utils.q.b("#26FFFFFF", -1);
                int i5 = 0;
                while (i5 < strArrD.length) {
                    String str = strArrD[i5];
                    if (TextUtils.isEmpty(str)) {
                        i = i2;
                    } else {
                        TextView textView2 = new TextView(context);
                        textView2.setText(str);
                        textView2.setTextColor(iB2);
                        textView2.setTextSize(13.0f);
                        textView2.setPadding(iA3, iA2, iA3, iA2);
                        textView2.setGravity(17);
                        GradientDrawable gradientDrawable2 = new GradientDrawable();
                        gradientDrawable2.setShape(i2);
                        gradientDrawable2.setStroke(iA, iB3);
                        gradientDrawable2.setCornerRadius(iA4);
                        textView2.setBackground(gradientDrawable2);
                        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, iA5);
                        layoutParams2.topMargin = iA3;
                        layoutParams2.rightMargin = iA3;
                        textView2.setTag(27);
                        i = 0;
                        sg.bigo.ads.ad.b.a.a(viewGroup7, textView2, 8, uVar.c, 0);
                        autoNextLineLinearLayout.addView(textView2, layoutParams2);
                    }
                    i5++;
                    uVar = this;
                    i2 = i;
                    iB3 = iB3;
                }
            } catch (Exception unused) {
            }
        }
    }

    @Override // sg.bigo.ads.ad.interstitial.d.a
    protected final void t() {
        super.t();
        if (this.q != null) {
            MediaView mediaView = (MediaView) this.q.findViewById(R.id.inter_media);
            this.y = mediaView;
            mediaView.setImageBlurBorder(false);
            c(this.q);
            TextView textView = (TextView) this.q.findViewById(R.id.tv_desc_below);
            if (textView != null) {
                sg.bigo.ads.api.core.c.d popPage = this.c.getPopPage();
                String strC = popPage != null ? popPage.c() : "";
                if (TextUtils.isEmpty(strC)) {
                    strC = this.c.getDescription();
                }
                if (TextUtils.isEmpty(strC)) {
                    strC = sg.bigo.ads.common.utils.a.a(j(), R.string.bigo_ad_description_default, new Object[0]);
                }
                textView.setText(strC);
                textView.setTag(6);
                sg.bigo.ads.ad.b.a.a(this.q, textView, 8, this.c, 0);
            }
            TextView textView2 = (TextView) this.q.findViewById(R.id.tv_gp_info_extra_about);
            if (textView2 != null) {
                textView2.setTag(27);
                sg.bigo.ads.ad.b.a.a(this.q, textView2, 8, this.c, 0);
            }
            ImageView imageView = (ImageView) this.q.findViewById(R.id.iv_gp_info_extra_arrow);
            if (imageView != null) {
                imageView.setTag(27);
                sg.bigo.ads.ad.b.a.a(this.q, imageView, 8, this.c, 0);
            }
        }
    }
}
