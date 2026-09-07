package sg.bigo.ads.ad.interstitial;

import android.animation.ArgbEvaluator;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.GradientDrawable;
import android.os.SystemClock;
import android.text.TextUtils;
import android.view.View;
import android.view.animation.Animation;
import android.webkit.URLUtil;
import android.webkit.ValueCallback;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.core.view.ViewCompat;
import java.util.ArrayList;
import java.util.List;
import sg.bigo.ads.R;
import sg.bigo.ads.ad.interstitial.k;
import sg.bigo.ads.common.view.AdImageView;
import sg.bigo.ads.common.view.RoundedFrameLayout;

/* JADX INFO: loaded from: classes8.dex */
public final class o<T extends k<?>> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final o<T>.c f12874a;
    final i<T> b;
    final sg.bigo.ads.ad.b.b c;
    final sg.bigo.ads.api.a.m d;
    final b e;
    FrameLayout f;
    TextView g;
    RoundedFrameLayout h;
    RoundedFrameLayout i;
    o<T>.e j;
    d k;
    final a m;
    final a n;
    l p;
    View q;
    boolean l = false;
    final List<Object> o = new ArrayList();
    private boolean r = false;

    static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f12890a;
        int b;
        long c;
        long[] d;
        boolean e;

        private a() {
            this.f12890a = 0;
            this.b = 3;
            this.c = -1L;
            this.d = new long[5];
            this.e = false;
        }

        /* synthetic */ a(byte b) {
            this();
        }

        final void a(int i, int i2, boolean z) {
            if (i >= 0) {
                long[] jArr = this.d;
                if (i >= jArr.length) {
                    return;
                }
                boolean z2 = this.e;
                if (!z2) {
                    this.f12890a = i;
                    this.b = i2;
                }
                if (i2 == 1) {
                    jArr[i] = SystemClock.elapsedRealtime();
                    return;
                }
                if (!z2) {
                    long jElapsedRealtime = SystemClock.elapsedRealtime();
                    long[] jArr2 = this.d;
                    long j = jElapsedRealtime - jArr2[i];
                    this.c = j;
                    jArr2[i] = j;
                } else if (this.c == -1 || (z && i2 == 2)) {
                    this.f12890a = i;
                    this.b = i2;
                    long jElapsedRealtime2 = SystemClock.elapsedRealtime();
                    long[] jArr3 = this.d;
                    long j2 = jElapsedRealtime2 - jArr3[i];
                    this.c = j2;
                    jArr3[i] = j2;
                }
                this.e = i2 == 2;
            }
        }
    }

    public interface b {
        void a(sg.bigo.ads.ad.b.d dVar);
    }

    class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        long f12891a;
        long b;
        long c;

        private c() {
        }

        /* synthetic */ c(o oVar, byte b) {
            this();
        }

        static void a(String str) {
            sg.bigo.ads.core.d.b.a(1006, 10205, str);
        }

        static void a(sg.bigo.ads.ad.b.d dVar, int i) {
            sg.bigo.ads.core.d.b.a(dVar == null ? null : (sg.bigo.ads.core.a.a) dVar.f(), false, 0, i, false, -1L, -1, -1, -1L, -1, -1, -1L);
        }

        final void a(sg.bigo.ads.ad.b.d dVar, int i, boolean z) {
            sg.bigo.ads.core.d.b.a(dVar == null ? null : (sg.bigo.ads.core.a.a) dVar.f(), false, 2, i, z, (SystemClock.elapsedRealtime() - this.f12891a) - this.c, o.this.m.f12890a, o.this.m.b, o.this.m.c, o.this.n.f12890a, o.this.n.b, o.this.n.c);
        }
    }

    static class d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        ArgbEvaluator f12892a;
        GradientDrawable b;
        Integer c;
        Integer d;

        private d() {
            this.f12892a = new ArgbEvaluator();
        }

        /* synthetic */ d(byte b) {
            this();
        }
    }

    class e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final sg.bigo.ads.common.utils.n f12893a;

        e(int i) {
            final long j = ((long) i) * 1000;
            this.f12893a = new sg.bigo.ads.common.utils.n(j) { // from class: sg.bigo.ads.ad.interstitial.o.e.1
                @Override // sg.bigo.ads.common.utils.n
                public final void a() {
                    sg.bigo.ads.ad.b.b bVar = o.this.c;
                    List<sg.bigo.ads.ad.b.d> listX = bVar.x();
                    sg.bigo.ads.ad.b.d dVar = (listX == null || !listX.contains(bVar.v)) ? null : bVar.v;
                    if (dVar != null) {
                        o.this.a(true, o.this.h, dVar, 1, false, false);
                        return;
                    }
                    sg.bigo.ads.ad.b.b bVar2 = o.this.c;
                    List<sg.bigo.ads.ad.b.d> listX2 = bVar2.x();
                    sg.bigo.ads.ad.b.d dVar2 = (listX2 == null || !listX2.contains(bVar2.w)) ? null : bVar2.w;
                    if (dVar2 != null) {
                        o.this.a(true, o.this.i, dVar2, 2, false, false);
                    } else {
                        o.this.e.a(null);
                        c.a("Error finish");
                    }
                }

                @Override // sg.bigo.ads.common.utils.n
                public final void a(final long j2) {
                    sg.bigo.ads.common.n.d.b(new Runnable() { // from class: sg.bigo.ads.ad.interstitial.o.e.1.1
                        @Override // java.lang.Runnable
                        public final void run() {
                            TextView textView = o.this.g;
                            if (textView != null) {
                                textView.setText(textView.getContext().getString(R.string.bigo_ad_double_video_count_down, Long.valueOf((j2 + 900) / 1000)));
                            }
                            d dVar = o.this.k;
                            if (dVar == null || dVar.b == null) {
                                return;
                            }
                            float f = (j2 * 1.0f) / j;
                            dVar.b.setColors(new int[]{((Integer) dVar.f12892a.evaluate(f, dVar.c, dVar.d)).intValue(), ((Integer) dVar.f12892a.evaluate(f, dVar.d, dVar.c)).intValue()});
                        }
                    });
                }
            };
        }
    }

    public o(sg.bigo.ads.ad.b.b bVar, i<T> iVar, b bVar2) {
        byte b2 = 0;
        this.f12874a = new c(this, b2);
        this.m = new a(b2);
        this.n = new a(b2);
        this.b = iVar;
        this.c = bVar;
        this.e = bVar2;
        sg.bigo.ads.ad.b.d dVar = bVar.v;
        this.d = dVar == null ? null : ((sg.bigo.ads.core.a.a) dVar.f()).e();
    }

    private void a(View view, final sg.bigo.ads.ad.b.d dVar) {
        if (view == null) {
            a(dVar, true);
            return;
        }
        sg.bigo.ads.ad.interstitial.c.d(view, new sg.bigo.ads.common.utils.b.c() { // from class: sg.bigo.ads.ad.interstitial.o.3
            @Override // sg.bigo.ads.common.utils.b.c, android.view.animation.Animation.AnimationListener
            public final void onAnimationEnd(Animation animation) {
                o.this.a(dVar, false);
                FrameLayout frameLayout = o.this.f;
                if (frameLayout != null) {
                    sg.bigo.ads.ad.interstitial.c.a(frameLayout, 1.0f, 0.0f, new sg.bigo.ads.common.utils.b.c() { // from class: sg.bigo.ads.ad.interstitial.o.3.1
                        @Override // sg.bigo.ads.common.utils.b.c, android.view.animation.Animation.AnimationListener
                        public final void onAnimationEnd(Animation animation2) {
                            o.this.a();
                        }
                    });
                }
            }
        });
        RoundedFrameLayout roundedFrameLayout = this.h;
        if (view == roundedFrameLayout) {
            roundedFrameLayout = this.i;
        }
        if (roundedFrameLayout != null) {
            sg.bigo.ads.ad.interstitial.c.a(roundedFrameLayout, 1.0f, 0.0f, null);
        }
    }

    static /* synthetic */ void a(o oVar, Context context, final AdImageView adImageView, final ImageView imageView, final Bitmap bitmap) {
        sg.bigo.ads.common.utils.d.a(context, bitmap, new ValueCallback<Bitmap>() { // from class: sg.bigo.ads.ad.interstitial.o.2
            @Override // android.webkit.ValueCallback
            public final /* synthetic */ void onReceiveValue(Bitmap bitmap2) {
                Bitmap bitmap3 = bitmap2;
                if (bitmap3 != null) {
                    imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
                    imageView.setImageBitmap(bitmap3);
                }
                adImageView.setScaleType(ImageView.ScaleType.FIT_CENTER);
                adImageView.setBackground(null);
                adImageView.setImageBitmap(bitmap);
            }
        });
    }

    private void b() {
        this.l = true;
        this.o.clear();
    }

    final void a() {
        sg.bigo.ads.common.utils.u.b(this.f);
        b();
    }

    final void a(final Context context, final RoundedFrameLayout roundedFrameLayout, final sg.bigo.ads.ad.b.d dVar, String str, final a aVar) {
        boolean z;
        boolean z2;
        int i;
        final sg.bigo.ads.core.a.a aVar2 = (sg.bigo.ads.core.a.a) dVar.f();
        sg.bigo.ads.api.core.o.a aVarAu = aVar2.au();
        final String strC = aVarAu == null ? null : aVarAu.c();
        FrameLayout frameLayout = new FrameLayout(context);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
        layoutParams.bottomMargin = sg.bigo.ads.common.utils.e.a(context, 32);
        roundedFrameLayout.addView(frameLayout, layoutParams);
        final ImageView imageView = new ImageView(context);
        frameLayout.addView(imageView, new FrameLayout.LayoutParams(-1, -1));
        final AdImageView adImageView = new AdImageView(context);
        frameLayout.addView(adImageView, new FrameLayout.LayoutParams(-1, -1));
        adImageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
        adImageView.setBackgroundColor(sg.bigo.ads.common.utils.q.b("#FFE1E1E6", -7829368));
        adImageView.setImageDrawable(sg.bigo.ads.common.utils.a.a(context, R.drawable.bigo_ad_icon_default_only_icon));
        if (TextUtils.isEmpty(str) || !URLUtil.isNetworkUrl(str)) {
            final boolean[] zArr = {false};
            String strAS = aVar2.aS();
            final String strAy = aVar2.ay();
            sg.bigo.ads.common.p.g gVar = new sg.bigo.ads.common.p.g() { // from class: sg.bigo.ads.ad.interstitial.o.7
                @Override // sg.bigo.ads.common.p.g
                public final void a(int i2, String str2, String str3) {
                    aVar.a(1, 0, true);
                    if (TextUtils.isEmpty(strAy) || !URLUtil.isNetworkUrl(strAy)) {
                        return;
                    }
                    sg.bigo.ads.common.p.g gVar2 = new sg.bigo.ads.common.p.g() { // from class: sg.bigo.ads.ad.interstitial.o.7.1
                        @Override // sg.bigo.ads.common.p.g
                        public final void a(int i3, String str4, String str5) {
                            aVar.a(3, 0, true);
                        }

                        @Override // sg.bigo.ads.common.p.g
                        public final void a(Bitmap bitmap, sg.bigo.ads.common.p.f fVar) {
                            aVar.a(3, 2, true);
                            zArr[0] = true;
                            o.a(o.this, context, adImageView, imageView, bitmap);
                        }
                    };
                    o.this.o.add(gVar2);
                    aVar.a(3, 1, true);
                    sg.bigo.ads.common.p.e.a(context, strAy, aVar2.al(), gVar2);
                }

                @Override // sg.bigo.ads.common.p.g
                public final void a(Bitmap bitmap, sg.bigo.ads.common.p.f fVar) {
                    aVar.a(1, 2, true);
                    zArr[0] = true;
                    o.a(o.this, context, adImageView, imageView, bitmap);
                }
            };
            aVar.a(1, 1, true);
            if (TextUtils.isEmpty(strAS) || !URLUtil.isNetworkUrl(strAS)) {
                z = false;
                gVar.a(0, "", "");
            } else {
                this.o.add(gVar);
                sg.bigo.ads.common.p.e.a(context, strAS, aVar2.al(), gVar);
                z = false;
            }
            String strB = (TextUtils.isEmpty(strC) || !URLUtil.isNetworkUrl(strC)) ? sg.bigo.ads.common.o.b(context, aVar2.aM()) : strC;
            final String str2 = strB;
            String str3 = strB;
            z2 = z;
            sg.bigo.ads.common.p.g gVar2 = new sg.bigo.ads.common.p.g() { // from class: sg.bigo.ads.ad.interstitial.o.8
                @Override // sg.bigo.ads.common.p.g
                public final void a(int i2, String str4, String str5) {
                    aVar.a(TextUtils.equals(str2, strC) ? 2 : 4, 0, false);
                }

                @Override // sg.bigo.ads.common.p.g
                public final void a(Bitmap bitmap, sg.bigo.ads.common.p.f fVar) {
                    aVar.a(TextUtils.equals(str2, strC) ? 2 : 4, 2, false);
                    if (zArr[0]) {
                        return;
                    }
                    o.a(o.this, context, adImageView, imageView, bitmap);
                }
            };
            if (!TextUtils.isEmpty(str3) && URLUtil.isNetworkUrl(str3)) {
                aVar.a(TextUtils.equals(str3, strC) ? 2 : 4, 1, z2);
                this.o.add(gVar2);
                sg.bigo.ads.common.p.e.a(context, str3, aVar2.al(), gVar2);
            }
        } else {
            if (TextUtils.equals(str, aVar2.aS())) {
                i = 1;
            } else {
                i = TextUtils.equals(str, aVar2.ay()) ? 3 : 0;
            }
            aVar.a(i, 1, true);
            final int i2 = i;
            sg.bigo.ads.common.p.g gVar3 = new sg.bigo.ads.common.p.g() { // from class: sg.bigo.ads.ad.interstitial.o.6
                @Override // sg.bigo.ads.common.p.g
                public final void a(int i3, String str4, String str5) {
                    aVar.a(i2, 0, true);
                }

                @Override // sg.bigo.ads.common.p.g
                public final void a(Bitmap bitmap, sg.bigo.ads.common.p.f fVar) {
                    o.a(o.this, context, adImageView, imageView, bitmap);
                    aVar.a(i2, 2, true);
                }
            };
            this.o.add(gVar3);
            sg.bigo.ads.common.p.e.a(context, str, aVar2.al(), gVar3);
            z2 = false;
        }
        RoundedFrameLayout roundedFrameLayout2 = new RoundedFrameLayout(context);
        roundedFrameLayout2.setCornerRadius(sg.bigo.ads.common.utils.e.a(context, 6));
        boolean z3 = z2;
        roundedFrameLayout.addView(roundedFrameLayout2, new FrameLayout.LayoutParams(-1, sg.bigo.ads.common.utils.e.a(context, 44), 80));
        View view = new View(context);
        view.setBackgroundColor(-1);
        roundedFrameLayout2.addView(view, new FrameLayout.LayoutParams(-1, -1));
        final ArrayList arrayList = new ArrayList();
        if (!TextUtils.isEmpty(strC) && URLUtil.isNetworkUrl(strC)) {
            arrayList.add(strC);
        }
        String strAS2 = aVar2.aS();
        if (!TextUtils.isEmpty(strAS2) && URLUtil.isNetworkUrl(strAS2)) {
            arrayList.add(strAS2);
        }
        String strAy2 = aVar2.ay();
        if (!TextUtils.isEmpty(strAy2) && URLUtil.isNetworkUrl(strAy2)) {
            arrayList.add(strAy2);
        }
        String strB2 = sg.bigo.ads.common.o.b(context, aVar2.aM());
        if (!TextUtils.isEmpty(strB2)) {
            arrayList.add(strB2);
        }
        if (arrayList.size() > 0) {
            String str4 = (String) arrayList.remove(z3 ? 1 : 0);
            final RoundedFrameLayout roundedFrameLayout3 = new RoundedFrameLayout(context);
            roundedFrameLayout3.setCornerRadius(sg.bigo.ads.common.utils.e.a(context, 4));
            FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(sg.bigo.ads.common.utils.e.a(context, 44), sg.bigo.ads.common.utils.e.a(context, 44), 83);
            layoutParams2.leftMargin = sg.bigo.ads.common.utils.e.a(context, 12);
            layoutParams2.bottomMargin = sg.bigo.ads.common.utils.e.a(context, 10);
            roundedFrameLayout.addView(roundedFrameLayout3, layoutParams2);
            final AdImageView adImageView2 = new AdImageView(context);
            adImageView2.setIconTag(true);
            roundedFrameLayout3.addView(adImageView2, new FrameLayout.LayoutParams(sg.bigo.ads.common.utils.e.a(context, 44), sg.bigo.ads.common.utils.e.a(context, 44), 17));
            sg.bigo.ads.common.p.g gVar4 = new sg.bigo.ads.common.p.g() { // from class: sg.bigo.ads.ad.interstitial.o.9
                @Override // sg.bigo.ads.common.p.g
                public final void a(int i3, String str5, String str6) {
                    if (o.this.l) {
                        return;
                    }
                    sg.bigo.ads.common.n.d.b(new Runnable() { // from class: sg.bigo.ads.ad.interstitial.o.9.1
                        @Override // java.lang.Runnable
                        public final void run() {
                            if (o.this.l || arrayList.size() <= 0) {
                                return;
                            }
                            adImageView2.a((String) arrayList.remove(0), aVar2.al());
                        }
                    });
                }

                @Override // sg.bigo.ads.common.p.g
                public final void a(Bitmap bitmap, sg.bigo.ads.common.p.f fVar) {
                    if (o.this.l) {
                        return;
                    }
                    roundedFrameLayout3.setShadowColor(sg.bigo.ads.common.utils.q.b("#50000000", -1));
                    roundedFrameLayout3.setShadowRadius(sg.bigo.ads.common.utils.e.a(context, 4));
                }
            };
            this.o.add(gVar4);
            adImageView2.a(gVar4);
            adImageView2.a(str4, aVar2.al());
        }
        TextView textView = new TextView(context);
        textView.setTextColor(sg.bigo.ads.common.utils.q.b("#333333", ViewCompat.MEASURED_STATE_MASK));
        textView.setTextSize(16.0f);
        textView.setSingleLine(true);
        textView.setGravity(16);
        textView.setEllipsize(TextUtils.TruncateAt.END);
        FrameLayout.LayoutParams layoutParams3 = new FrameLayout.LayoutParams(-2, sg.bigo.ads.common.utils.e.a(context, 44), 83);
        layoutParams3.leftMargin = sg.bigo.ads.common.utils.e.a(context, 65);
        layoutParams3.rightMargin = sg.bigo.ads.common.utils.e.a(context, 52);
        roundedFrameLayout.addView(textView, layoutParams3);
        String title = dVar.getTitle();
        if (TextUtils.isEmpty(title)) {
            title = dVar.getDescription();
        }
        textView.setText(title);
        RoundedFrameLayout roundedFrameLayout4 = new RoundedFrameLayout(context);
        roundedFrameLayout4.setCornerRadius(sg.bigo.ads.common.utils.e.a(context, 14));
        FrameLayout.LayoutParams layoutParams4 = new FrameLayout.LayoutParams(sg.bigo.ads.common.utils.e.a(context, 28), sg.bigo.ads.common.utils.e.a(context, 28), 85);
        layoutParams4.rightMargin = sg.bigo.ads.common.utils.e.a(context, 12);
        layoutParams4.bottomMargin = sg.bigo.ads.common.utils.e.a(context, 8);
        roundedFrameLayout.addView(roundedFrameLayout4, layoutParams4);
        View view2 = new View(context);
        roundedFrameLayout4.addView(view2, new FrameLayout.LayoutParams(-1, -1));
        Integer numF = dVar.F();
        if (numF == null) {
            numF = Integer.valueOf(sg.bigo.ads.common.utils.q.b("#01B5FF", -16776961));
        }
        view2.setBackgroundColor(numF.intValue());
        ImageView imageView2 = new ImageView(context);
        roundedFrameLayout4.addView(imageView2, new FrameLayout.LayoutParams(-1, -1));
        imageView2.setImageDrawable(sg.bigo.ads.common.utils.a.a(context, R.drawable.bigo_ad_double_video_small_play));
        FrameLayout frameLayout2 = this.f;
        sg.bigo.ads.api.a.m mVar = this.d;
        if (frameLayout2 != null) {
            sg.bigo.ads.ad.b.a.a(frameLayout2, roundedFrameLayout, 8, new sg.bigo.ads.core.adview.h() { // from class: sg.bigo.ads.ad.interstitial.o.10
                @Override // sg.bigo.ads.core.adview.h
                public final void a(int i3, int i4, int i5, int i6, int i7, int i8) {
                    int i9;
                    if (dVar == o.this.c.v) {
                        i9 = 1;
                    } else {
                        i9 = dVar == o.this.c.w ? 2 : 0;
                    }
                    o.this.a(true, roundedFrameLayout, dVar, i9, true, false);
                }
            }, mVar == null ? 0 : mVar.a("multi_ads.click_type"));
        }
        ImageView imageView3 = new ImageView(context);
        frameLayout.addView(imageView3, new FrameLayout.LayoutParams(sg.bigo.ads.common.utils.e.a(context, 60), sg.bigo.ads.common.utils.e.a(context, 60), 17));
        imageView3.setImageDrawable(sg.bigo.ads.common.utils.a.a(context, R.drawable.bigo_ad_double_video_play));
        FrameLayout frameLayout3 = new FrameLayout(context);
        frameLayout.addView(frameLayout3, new FrameLayout.LayoutParams(sg.bigo.ads.common.utils.e.a(context, 160), sg.bigo.ads.common.utils.e.a(context, 160), 17));
        final ImageView imageView4 = new ImageView(context);
        frameLayout3.addView(imageView4, new FrameLayout.LayoutParams(sg.bigo.ads.common.utils.e.a(context, 100), sg.bigo.ads.common.utils.e.a(context, 100), 85));
        imageView4.setImageDrawable(sg.bigo.ads.common.utils.a.a(context, R.drawable.bigo_ad_click_guide));
        final ImageView imageView5 = new ImageView(context);
        FrameLayout.LayoutParams layoutParams5 = new FrameLayout.LayoutParams(sg.bigo.ads.common.utils.e.a(context, 10), sg.bigo.ads.common.utils.e.a(context, 10), 85);
        layoutParams5.rightMargin = sg.bigo.ads.common.utils.e.a(context, 64);
        layoutParams5.bottomMargin = sg.bigo.ads.common.utils.e.a(context, 64);
        frameLayout3.addView(imageView5, layoutParams5);
        imageView5.setImageDrawable(sg.bigo.ads.common.utils.a.a(context, R.drawable.bigo_ad_click_ripple));
        int iA = mVar.a("multi_ads.guided_click_gesture_show_time");
        int i3 = (iA == 2 || iA == 3) ? ((iA * 2) - 1) * 1000 : 0;
        imageView4.setVisibility(8);
        imageView5.setVisibility(8);
        frameLayout3.postDelayed(new Runnable() { // from class: sg.bigo.ads.ad.interstitial.o.11
            @Override // java.lang.Runnable
            public final void run() {
                if (o.this.l) {
                    return;
                }
                imageView4.setVisibility(0);
                imageView5.setVisibility(0);
                sg.bigo.ads.ad.interstitial.c.a(imageView4, 0.0f, 1.0f, new sg.bigo.ads.common.utils.b.c() { // from class: sg.bigo.ads.ad.interstitial.o.11.1
                    @Override // sg.bigo.ads.common.utils.b.c, android.view.animation.Animation.AnimationListener
                    public final void onAnimationEnd(Animation animation) {
                        sg.bigo.ads.ad.interstitial.c.a(imageView4, imageView5, 0);
                    }
                });
            }
        }, i3);
    }

    final void a(sg.bigo.ads.ad.b.d dVar, boolean z) {
        if (z) {
            a();
        }
        this.e.a(dVar);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void a(boolean z, View view, sg.bigo.ads.ad.b.d dVar, int i, boolean z2, boolean z3) {
        if (this.r) {
            return;
        }
        this.r = true;
        if (z3) {
            c.a(dVar, i);
        } else {
            this.f12874a.a(dVar, i, z2);
        }
        if (z) {
            a(view, dVar);
        } else {
            a(dVar, true);
        }
    }
}
