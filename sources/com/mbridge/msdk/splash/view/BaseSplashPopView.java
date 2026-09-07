package com.mbridge.msdk.splash.view;

import android.content.Context;
import android.graphics.Bitmap;
import android.os.Handler;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.core.view.ViewCompat;
import com.mbridge.msdk.click.j;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.foundation.tools.n0;
import com.mbridge.msdk.foundation.tools.o0;
import com.mbridge.msdk.foundation.tools.s0;
import com.mbridge.msdk.foundation.tools.t0;
import com.mbridge.msdk.foundation.tools.y;
import com.mbridge.msdk.out.Campaign;
import com.mbridge.msdk.out.MBridgeIds;
import com.safedk.android.analytics.brandsafety.DetectTouchUtils;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: loaded from: classes4.dex */
public class BaseSplashPopView extends RelativeLayout {
    public static final int TYPE_POP_DEFAULT = 1;
    public static final int TYPE_POP_LARGE = 4;
    public static final int TYPE_POP_MEDIUM = 3;
    public static final int TYPE_POP_SMALL = 2;
    private static final AtomicInteger v = new AtomicInteger(1);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    protected String f5471a;
    protected String b;
    private int c;
    private CampaignEx d;
    protected com.mbridge.msdk.splash.middle.d e;
    private ImageView f;
    private ImageView g;
    private ImageView h;
    private ImageView i;
    private TextView j;
    private TextView k;
    private TextView l;
    private int m;
    protected Handler n;
    private boolean o;
    protected com.mbridge.msdk.click.a p;
    private j q;
    private Runnable r;
    private Runnable s;
    View.OnClickListener t;
    View.OnClickListener u;

    class a implements j {
        a() {
        }

        @Override // com.mbridge.msdk.out.BaseTrackingListener
        public void onFinishRedirection(Campaign campaign, String str) {
            if (campaign == null) {
                return;
            }
            s0.a(campaign, BaseSplashPopView.this);
        }

        @Override // com.mbridge.msdk.out.BaseTrackingListener
        public void onRedirectionFailed(Campaign campaign, String str) {
            if (campaign == null) {
                return;
            }
            s0.a(campaign, BaseSplashPopView.this);
        }

        @Override // com.mbridge.msdk.out.BaseTrackingListener
        public void onStartRedirection(Campaign campaign, String str) {
            int iA;
            int iA2;
            if (BaseSplashPopView.this.c == 1) {
                int iMin = Math.min(BaseSplashPopView.this.getWidth(), BaseSplashPopView.this.getHeight());
                int iA3 = (t0.a(BaseSplashPopView.this.getContext(), 60.0f) - Math.min(Math.max(iMin / 4, 70), iMin)) / 2;
                iA = t0.a(BaseSplashPopView.this.getContext(), 23.0f) + iA3;
                iA2 = t0.a(BaseSplashPopView.this.getContext(), 10.0f) + iA3;
            } else {
                iA = 0;
                iA2 = 0;
            }
            s0.a(campaign, BaseSplashPopView.this, iA, iA2);
        }
    }

    class b implements com.mbridge.msdk.foundation.same.image.c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ boolean f5473a;

        b(boolean z) {
            this.f5473a = z;
        }

        @Override // com.mbridge.msdk.foundation.same.image.c
        public void onFailedLoad(String str, String str2) {
            o0.b("MBSplashPopView", str);
        }

        @Override // com.mbridge.msdk.foundation.same.image.c
        public void onSuccessLoad(Bitmap bitmap, String str) {
            try {
                if (bitmap.isRecycled()) {
                    return;
                }
                Bitmap bitmapB = this.f5473a ? n0.b(bitmap) : n0.a(bitmap, 1, 16);
                ImageView imageView = BaseSplashPopView.this.f;
                if (bitmapB != null) {
                    bitmap = bitmapB;
                }
                imageView.setImageBitmap(bitmap);
            } catch (Throwable th) {
                o0.b("MBSplashPopView", th.getMessage());
            }
        }
    }

    class c implements com.mbridge.msdk.foundation.same.image.c {
        c() {
        }

        @Override // com.mbridge.msdk.foundation.same.image.c
        public void onFailedLoad(String str, String str2) {
            o0.b("MBSplashPopView", str);
        }

        @Override // com.mbridge.msdk.foundation.same.image.c
        public void onSuccessLoad(Bitmap bitmap, String str) {
            try {
                if (bitmap.isRecycled()) {
                    return;
                }
                BaseSplashPopView.this.h.setImageBitmap(y.a(bitmap, 10));
            } catch (Throwable th) {
                o0.b("MBSplashPopView", th.getMessage());
            }
        }
    }

    class d implements com.mbridge.msdk.foundation.same.image.c {
        d() {
        }

        @Override // com.mbridge.msdk.foundation.same.image.c
        public void onFailedLoad(String str, String str2) {
            o0.b("MBSplashPopView", str);
        }

        @Override // com.mbridge.msdk.foundation.same.image.c
        public void onSuccessLoad(Bitmap bitmap, String str) {
            try {
                if (bitmap.isRecycled()) {
                    return;
                }
                BaseSplashPopView.this.g.setImageBitmap(n0.a(bitmap, 1, 16));
            } catch (Throwable th) {
                o0.b("MBSplashPopView", th.getMessage());
            }
        }
    }

    class e implements Runnable {
        e() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (BaseSplashPopView.this.l != null) {
                if (BaseSplashPopView.this.m != 0) {
                    BaseSplashPopView.g(BaseSplashPopView.this);
                    BaseSplashPopView.this.l.setText(String.valueOf(BaseSplashPopView.this.m));
                    BaseSplashPopView baseSplashPopView = BaseSplashPopView.this;
                    baseSplashPopView.n.postDelayed(baseSplashPopView.r, 1000L);
                    return;
                }
                BaseSplashPopView.this.m = -1;
                BaseSplashPopView.this.g();
                BaseSplashPopView baseSplashPopView2 = BaseSplashPopView.this;
                baseSplashPopView2.n.removeCallbacks(baseSplashPopView2.r);
                BaseSplashPopView baseSplashPopView3 = BaseSplashPopView.this;
                com.mbridge.msdk.splash.middle.d dVar = baseSplashPopView3.e;
                if (dVar != null) {
                    dVar.a(new MBridgeIds(baseSplashPopView3.f5471a, baseSplashPopView3.b), 5);
                }
            }
        }
    }

    class f implements Runnable {
        f() {
        }

        @Override // java.lang.Runnable
        public void run() {
            BaseSplashPopView baseSplashPopView = BaseSplashPopView.this;
            com.mbridge.msdk.splash.middle.d dVar = baseSplashPopView.e;
            if (dVar != null) {
                dVar.a(new MBridgeIds(baseSplashPopView.f5471a, baseSplashPopView.b), BaseSplashPopView.this.getWidth(), BaseSplashPopView.this.getHeight(), BaseSplashPopView.this.c);
            }
        }
    }

    class g implements View.OnClickListener {
        g() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            BaseSplashPopView baseSplashPopView = BaseSplashPopView.this;
            if (baseSplashPopView.e != null) {
                baseSplashPopView.b(baseSplashPopView.d);
            }
        }
    }

    class h implements View.OnClickListener {
        h() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            BaseSplashPopView baseSplashPopView;
            com.mbridge.msdk.splash.middle.d dVar;
            if (BaseSplashPopView.this.m <= 0 && (dVar = (baseSplashPopView = BaseSplashPopView.this).e) != null) {
                dVar.a(new MBridgeIds(baseSplashPopView.f5471a, baseSplashPopView.b), 4);
            }
        }
    }

    public static class i {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private String f5480a;
        private String b;
        private int c;
        private CampaignEx d;

        public i(String str, String str2, int i, CampaignEx campaignEx) {
            this.f5480a = str;
            this.b = str2;
            this.c = i;
            this.d = campaignEx;
        }

        public CampaignEx a() {
            return this.d;
        }

        public String b() {
            return this.f5480a;
        }

        public String c() {
            return this.b;
        }

        public int d() {
            return this.c;
        }
    }

    public BaseSplashPopView(Context context, i iVar, com.mbridge.msdk.splash.middle.d dVar) {
        super(context);
        this.c = 1;
        this.m = -1;
        this.n = new Handler();
        this.o = false;
        this.q = new a();
        this.r = new e();
        this.s = new f();
        this.t = new g();
        this.u = new h();
        if (iVar == null) {
            throw new IllegalArgumentException("Parameters is NULL, can't gen view.");
        }
        this.b = iVar.c();
        this.f5471a = iVar.b();
        this.c = iVar.d();
        this.d = iVar.a();
        this.e = dVar;
        a();
    }

    static /* synthetic */ int g(BaseSplashPopView baseSplashPopView) {
        int i2 = baseSplashPopView.m;
        baseSplashPopView.m = i2 - 1;
        return i2;
    }

    public static int generateViewId() {
        AtomicInteger atomicInteger;
        int i2;
        int i3;
        do {
            atomicInteger = v;
            i2 = atomicInteger.get();
            i3 = i2 + 1;
            if (i3 > 16777215) {
                i3 = 1;
            }
        } while (!atomicInteger.compareAndSet(i2, i3));
        return i2;
    }

    private void setBackgroundImage(String str) {
        com.mbridge.msdk.foundation.same.image.b.a(com.mbridge.msdk.foundation.controller.c.m().d()).a(str, new c());
    }

    private void setForegroundImage(String str) {
        com.mbridge.msdk.foundation.same.image.b.a(com.mbridge.msdk.foundation.controller.c.m().d()).a(str, new d());
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent me) {
        DetectTouchUtils.viewOnTouch(com.safedk.android.utils.h.o, this, me);
        return super.dispatchTouchEvent(me);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (this.e != null) {
            postDelayed(this.s, 500L);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        release();
    }

    @Override // android.widget.RelativeLayout, android.view.View
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        if (1 == 0) {
            setMeasuredDimension(0, 0);
        } else {
            super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        }
    }

    public void pauseCountDown() {
        this.o = true;
        if (this.l != null) {
            this.n.removeCallbacks(this.r);
        }
    }

    public void reStartCountDown() {
        if (this.o) {
            this.o = false;
            int i2 = this.m;
            if (i2 == -1 || i2 == 0) {
                g();
                return;
            }
            TextView textView = this.l;
            if (textView != null) {
                textView.setText(String.valueOf(i2));
                this.n.postDelayed(this.r, 1000L);
            }
        }
    }

    public void release() {
        try {
            this.n.removeCallbacks(this.s);
            this.n.removeCallbacks(this.r);
            this.r = null;
            detachAllViewsFromParent();
            this.d = null;
            this.e = null;
        } catch (Exception e2) {
            o0.b("MBSplashPopView", e2.getMessage());
        }
    }

    public void setPopViewType(i iVar, com.mbridge.msdk.splash.middle.d dVar) {
        if (iVar == null) {
            throw new IllegalArgumentException("Parameters is NULL, can't gen view.");
        }
        this.b = iVar.c();
        this.f5471a = iVar.b();
        this.c = iVar.d();
        this.d = iVar.a();
        this.e = dVar;
        a();
    }

    public void startCountDown() {
        this.n.removeCallbacks(this.r);
        CampaignEx campaignEx = this.d;
        if (campaignEx == null || this.c != 1) {
            return;
        }
        int flbSkipTime = campaignEx.getFlbSkipTime();
        if (flbSkipTime <= 0) {
            g();
            return;
        }
        this.m = flbSkipTime;
        TextView textView = this.l;
        if (textView != null) {
            textView.setText(String.valueOf(flbSkipTime));
            this.n.postDelayed(this.r, 1000L);
        }
    }

    private void b() {
        String language;
        this.i = new ImageView(getContext());
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(t0.a(getContext(), 32.0f), t0.a(getContext(), 13.0f));
        layoutParams.addRule(11);
        layoutParams.addRule(8, this.f.getId());
        this.i.setLayoutParams(layoutParams);
        try {
            language = getResources().getConfiguration().locale.getLanguage();
        } catch (Throwable th) {
            o0.b("MBSplashPopView", th.getMessage());
            language = "ZH";
        }
        this.i.setBackgroundResource((language.toUpperCase().equals("CN") || language.toUpperCase().equals("ZH")) ? getResources().getIdentifier("mbridge_splash_pop_ad", "drawable", com.mbridge.msdk.foundation.controller.c.m().h()) : getResources().getIdentifier("mbridge_splash_pop_ad_en", "drawable", com.mbridge.msdk.foundation.controller.c.m().h()));
        addView(this.i);
    }

    private void c() {
        View imageView = new ImageView(getContext());
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(t0.a(getContext(), 80.0f), t0.a(getContext(), 80.0f));
        layoutParams.addRule(9);
        layoutParams.topMargin = t0.a(getContext(), 16.0f);
        imageView.setId(generateViewId());
        imageView.setLayoutParams(layoutParams);
        imageView.setBackgroundResource(getResources().getIdentifier("mbridge_splash_popview_default", "drawable", com.mbridge.msdk.foundation.controller.c.m().h()));
        this.f = new ImageView(getContext());
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(t0.a(getContext(), 60.0f), t0.a(getContext(), 60.0f));
        layoutParams2.addRule(6, imageView.getId());
        layoutParams2.topMargin = t0.a(getContext(), 7.0f);
        layoutParams2.leftMargin = t0.a(getContext(), 10.0f);
        this.f.setId(generateViewId());
        this.f.setLayoutParams(layoutParams2);
        this.f.setScaleType(ImageView.ScaleType.FIT_CENTER);
        CampaignEx campaignEx = this.d;
        if (campaignEx != null && !TextUtils.isEmpty(campaignEx.getIconUrl())) {
            a(this.d.getIconUrl(), true);
        }
        this.l = new TextView(getContext());
        RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams3.addRule(5, imageView.getId());
        layoutParams3.addRule(8, imageView.getId());
        layoutParams3.leftMargin = t0.a(getContext(), 62.0f);
        layoutParams3.bottomMargin = t0.a(getContext(), 70.0f);
        this.l.setId(generateViewId());
        this.l.setTextSize(10.0f);
        this.l.setTextColor(-1);
        this.l.setGravity(17);
        this.l.setMinWidth(t0.a(getContext(), 16.0f));
        this.l.setMaxHeight(t0.a(getContext(), 16.0f));
        this.l.setLayoutParams(layoutParams3);
        this.l.setBackgroundResource(getResources().getIdentifier("mbridge_cm_circle_50black", "drawable", com.mbridge.msdk.foundation.controller.c.m().h()));
        addView(imageView);
        addView(this.l);
        addView(this.f);
        CampaignEx campaignEx2 = this.d;
        if (campaignEx2 != null && campaignEx2.getFlbSkipTime() <= 0) {
            g();
        }
        setOnClickListener(this.t);
        this.l.setOnClickListener(this.u);
    }

    private void d() {
        this.h = new ImageView(getContext());
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, t0.a(getContext(), 131.0f));
        layoutParams.addRule(10);
        layoutParams.addRule(14);
        this.h.setScaleType(ImageView.ScaleType.FIT_XY);
        this.h.setId(generateViewId());
        this.h.setLayoutParams(layoutParams);
        setBackgroundImage(this.d.getImageUrl());
        this.g = new ImageView(getContext());
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-2, t0.a(getContext(), 131.0f));
        layoutParams2.addRule(10);
        layoutParams2.addRule(14);
        this.g.setScaleType(ImageView.ScaleType.FIT_CENTER);
        this.g.setId(generateViewId());
        this.g.setLayoutParams(layoutParams2);
        setForegroundImage(this.d.getImageUrl());
        this.f = new ImageView(getContext());
        RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(t0.a(getContext(), 50.0f), t0.a(getContext(), 50.0f));
        layoutParams3.addRule(9);
        layoutParams3.addRule(3, this.h.getId());
        layoutParams3.topMargin = 20;
        this.f.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
        this.f.setId(generateViewId());
        this.f.setLayoutParams(layoutParams3);
        a(this.d.getIconUrl(), false);
        RelativeLayout relativeLayout = new RelativeLayout(getContext());
        RelativeLayout.LayoutParams layoutParams4 = new RelativeLayout.LayoutParams(-1, -2);
        layoutParams4.addRule(1, this.f.getId());
        layoutParams4.addRule(6, this.f.getId());
        layoutParams4.addRule(8, this.f.getId());
        layoutParams4.leftMargin = t0.a(getContext(), 8.0f);
        layoutParams4.rightMargin = t0.a(getContext(), 8.0f);
        relativeLayout.setLayoutParams(layoutParams4);
        relativeLayout.setGravity(16);
        TextView textView = new TextView(getContext());
        this.j = textView;
        textView.setId(generateViewId());
        this.j.setGravity(16);
        this.j.setLayoutParams(new RelativeLayout.LayoutParams(-2, -2));
        this.j.setTextSize(12.0f);
        this.j.setTextColor(ViewCompat.MEASURED_STATE_MASK);
        this.j.setEllipsize(TextUtils.TruncateAt.MARQUEE);
        this.j.setMarqueeRepeatLimit(-1);
        this.j.setSelected(true);
        this.j.setSingleLine(true);
        this.j.setText(this.d.getAppName());
        TextView textView2 = new TextView(getContext());
        this.k = textView2;
        textView2.setId(generateViewId());
        RelativeLayout.LayoutParams layoutParams5 = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams5.addRule(5, this.j.getId());
        layoutParams5.addRule(3, this.j.getId());
        layoutParams5.topMargin = t0.a(getContext(), 4.0f);
        layoutParams5.rightMargin = t0.a(getContext(), 36.0f);
        this.k.setGravity(16);
        this.k.setLayoutParams(layoutParams5);
        this.k.setTextSize(8.0f);
        this.k.setTextColor(-10066330);
        this.k.setEllipsize(TextUtils.TruncateAt.MARQUEE);
        this.k.setMarqueeRepeatLimit(-1);
        this.k.setSelected(true);
        this.k.setSingleLine(true);
        this.k.setText(this.d.getAppDesc());
        relativeLayout.addView(this.j);
        relativeLayout.addView(this.k);
        addView(this.h);
        addView(this.g);
        addView(this.f);
        addView(relativeLayout);
        b();
        setOnClickListener(this.t);
    }

    private void e() {
        int iA = t0.a(getContext(), 4.0f);
        this.f = new ImageView(getContext());
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(t0.a(getContext(), 50.0f), t0.a(getContext(), 50.0f));
        layoutParams.addRule(9);
        this.f.setId(generateViewId());
        this.f.setLayoutParams(layoutParams);
        this.f.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
        this.f.setPadding(iA, iA, iA, iA);
        a(this.d.getIconUrl(), false);
        RelativeLayout relativeLayout = new RelativeLayout(getContext());
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-1, -2);
        layoutParams2.addRule(1, this.f.getId());
        layoutParams2.addRule(6, this.f.getId());
        layoutParams2.addRule(8, this.f.getId());
        layoutParams2.leftMargin = t0.a(getContext(), 8.0f);
        layoutParams2.rightMargin = t0.a(getContext(), 8.0f);
        relativeLayout.setLayoutParams(layoutParams2);
        relativeLayout.setGravity(16);
        TextView textView = new TextView(getContext());
        this.j = textView;
        textView.setId(generateViewId());
        this.j.setLayoutParams(new RelativeLayout.LayoutParams(-2, -2));
        this.j.setGravity(16);
        this.j.setTextSize(12.0f);
        this.j.setSelected(true);
        this.j.setEllipsize(TextUtils.TruncateAt.MARQUEE);
        this.j.setMarqueeRepeatLimit(-1);
        this.j.setSingleLine(true);
        this.j.setTextColor(ViewCompat.MEASURED_STATE_MASK);
        this.j.setText(this.d.getAppName());
        TextView textView2 = new TextView(getContext());
        this.k = textView2;
        textView2.setId(generateViewId());
        RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams3.addRule(5, this.j.getId());
        layoutParams3.addRule(3, this.j.getId());
        layoutParams3.topMargin = t0.a(getContext(), 4.0f);
        layoutParams3.rightMargin = t0.a(getContext(), 36.0f);
        this.k.setGravity(16);
        this.k.setLayoutParams(layoutParams3);
        this.k.setTextSize(8.0f);
        this.k.setTextColor(-10066330);
        this.k.setEllipsize(TextUtils.TruncateAt.MARQUEE);
        this.k.setMarqueeRepeatLimit(-1);
        this.k.setSelected(true);
        this.k.setSingleLine(true);
        this.k.setText(this.d.getAppDesc());
        relativeLayout.addView(this.j);
        relativeLayout.addView(this.k);
        setBackgroundResource(getResources().getIdentifier("mbridge_shape_corners_bg", "drawable", com.mbridge.msdk.foundation.controller.c.m().h()));
        addView(this.f);
        addView(relativeLayout);
        b();
        setOnClickListener(this.t);
    }

    private void f() {
        int iA = t0.a(getContext(), 4.0f);
        this.f = new ImageView(getContext());
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(t0.a(getContext(), 28.0f), t0.a(getContext(), 28.0f));
        layoutParams.addRule(9);
        this.f.setId(generateViewId());
        this.f.setLayoutParams(layoutParams);
        this.f.setPadding(iA, iA, iA, iA);
        this.f.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
        a(this.d.getIconUrl(), false);
        TextView textView = new TextView(getContext());
        this.j = textView;
        textView.setId(generateViewId());
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams2.addRule(1, this.f.getId());
        layoutParams2.addRule(6, this.f.getId());
        layoutParams2.addRule(8, this.f.getId());
        layoutParams2.leftMargin = t0.a(getContext(), 4.0f);
        layoutParams2.rightMargin = t0.a(getContext(), 40.0f);
        this.j.setLayoutParams(layoutParams2);
        this.j.setGravity(16);
        this.j.setTextSize(10.0f);
        this.j.setSelected(true);
        this.j.setEllipsize(TextUtils.TruncateAt.MARQUEE);
        this.j.setMarqueeRepeatLimit(-1);
        this.j.setSingleLine(true);
        this.j.setTextColor(ViewCompat.MEASURED_STATE_MASK);
        this.j.setText(this.d.getAppName());
        setBackgroundResource(getResources().getIdentifier("mbridge_shape_corners_bg", "drawable", com.mbridge.msdk.foundation.controller.c.m().h()));
        addView(this.f);
        addView(this.j);
        b();
        setOnClickListener(this.t);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g() {
        TextView textView = this.l;
        if (textView != null) {
            ViewGroup.LayoutParams layoutParams = textView.getLayoutParams();
            layoutParams.width = t0.a(getContext(), 16.0f);
            layoutParams.height = t0.a(getContext(), 16.0f);
            this.l.setLayoutParams(layoutParams);
            this.l.setText("");
            this.l.setSelected(true);
            this.l.setBackgroundResource(getResources().getIdentifier("mbridge_splash_popview_close", "drawable", com.mbridge.msdk.foundation.controller.c.m().h()));
        }
    }

    private void a() {
        if (this.d == null) {
            return;
        }
        setLayoutParams(new RelativeLayout.LayoutParams(-1, -2));
        int i2 = this.c;
        if (i2 == 1) {
            c();
            return;
        }
        if (i2 == 2) {
            f();
        } else if (i2 == 3) {
            e();
        } else {
            if (i2 != 4) {
                return;
            }
            d();
        }
    }

    private void a(String str, boolean z) {
        com.mbridge.msdk.foundation.same.image.b.a(com.mbridge.msdk.foundation.controller.c.m().d()).a(str, new b(z));
    }

    protected void a(CampaignEx campaignEx) {
        if (this.p == null) {
            com.mbridge.msdk.click.a aVar = new com.mbridge.msdk.click.a(com.mbridge.msdk.foundation.controller.c.m().d(), this.b);
            this.p = aVar;
            aVar.a(this.q);
        }
        campaignEx.setCampaignUnitId(this.b);
        this.p.a(campaignEx);
        if (!campaignEx.isReportClick()) {
            campaignEx.setReportClick(true);
            com.mbridge.msdk.splash.report.a.a(com.mbridge.msdk.foundation.controller.c.m().d(), campaignEx);
        }
        com.mbridge.msdk.splash.middle.d dVar = this.e;
        if (dVar != null) {
            dVar.a(new MBridgeIds(this.f5471a, this.b));
            this.e.a(new MBridgeIds(this.f5471a, this.b), 6);
        }
    }

    protected void b(CampaignEx campaignEx) {
        com.mbridge.msdk.splash.report.a.a(campaignEx, this.b);
    }

    public BaseSplashPopView(Context context) {
        super(context);
        this.c = 1;
        this.m = -1;
        this.n = new Handler();
        this.o = false;
        this.q = new a();
        this.r = new e();
        this.s = new f();
        this.t = new g();
        this.u = new h();
        this.c = 1;
        o0.c("MBSplashPopView", "Please call setPopViewType() to init.");
    }

    public BaseSplashPopView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.c = 1;
        this.m = -1;
        this.n = new Handler();
        this.o = false;
        this.q = new a();
        this.r = new e();
        this.s = new f();
        this.t = new g();
        this.u = new h();
        this.c = 1;
        o0.c("MBSplashPopView", "Please call setPopViewType() to init.");
    }

    public BaseSplashPopView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.c = 1;
        this.m = -1;
        this.n = new Handler();
        this.o = false;
        this.q = new a();
        this.r = new e();
        this.s = new f();
        this.t = new g();
        this.u = new h();
        this.c = 1;
        o0.c("MBSplashPopView", "Please call setPopViewType() to init.");
    }

    public BaseSplashPopView(Context context, AttributeSet attributeSet, int i2, int i3) {
        super(context, attributeSet, i2, i3);
        this.c = 1;
        this.m = -1;
        this.n = new Handler();
        this.o = false;
        this.q = new a();
        this.r = new e();
        this.s = new f();
        this.t = new g();
        this.u = new h();
        this.c = 1;
        o0.c("MBSplashPopView", "Please call setPopViewType() to init.");
    }
}
