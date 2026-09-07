package sg.bigo.ads.ad.splash.a;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorManager;
import android.os.SystemClock;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import java.util.Arrays;
import java.util.Iterator;
import sg.bigo.ads.R;
import sg.bigo.ads.api.SplashAd;
import sg.bigo.ads.api.a.m;

/* JADX INFO: loaded from: classes10.dex */
public final class d extends b {
    public static float l = 20.0f;
    private sg.bigo.ads.common.q.b m;
    private boolean n;
    private float o;
    private float p;
    private final float q;
    private final float[] r;
    private long s;
    private boolean t;
    private View.OnTouchListener u;

    public d(sg.bigo.ads.api.core.g gVar, m mVar, m mVar2, sg.bigo.ads.ad.splash.b bVar) {
        super(gVar, mVar, mVar2, bVar);
        this.n = true;
        this.o = 0.0f;
        this.p = 0.0f;
        this.q = -1.0f;
        this.r = new float[]{-1.0f, -1.0f, -1.0f};
        this.s = 0L;
        this.u = new View.OnTouchListener() { // from class: sg.bigo.ads.ad.splash.a.d.1
            @Override // android.view.View.OnTouchListener
            public final boolean onTouch(View view, MotionEvent motionEvent) {
                int action = motionEvent.getAction();
                if (action == 0) {
                    sg.bigo.ads.common.t.a.a(0, 3, "splashSlide", "down...");
                    d.this.o = motionEvent.getX();
                    d.this.p = motionEvent.getY();
                    return true;
                }
                if (action == 1) {
                    int iA = d.a(Math.round(d.this.o), Math.round(d.this.p), Math.round(motionEvent.getX()), Math.round(motionEvent.getY()));
                    sg.bigo.ads.common.t.a.a(0, 3, "splashSlide", "up...".concat(String.valueOf(iA)));
                    if (iA > 30) {
                        d.c(d.this);
                        return true;
                    }
                }
                return false;
            }
        };
    }

    static /* synthetic */ float a(int i) {
        if (i != 4) {
            return (i == 9 || i == 1) ? 4.0f : 20.0f;
        }
        return 20.0f;
    }

    static /* synthetic */ int a(int i, int i2, int i3, int i4) {
        return Math.max(Math.abs(i - i3), Math.abs(i2 - i4));
    }

    static /* synthetic */ void c(d dVar) {
        long jElapsedRealtime = SystemClock.elapsedRealtime();
        long j = jElapsedRealtime - dVar.s;
        if (!dVar.n || j <= 2000) {
            return;
        }
        dVar.s = jElapsedRealtime;
        dVar.h.v.a(8, 22);
    }

    private int l() {
        return sg.bigo.ads.ad.splash.a.b(this.b) ? R.layout.bigo_ad_splash_style_halfscreen_interaction : R.layout.bigo_ad_splash_style_fullscreen_interaction;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int m() {
        if (this.c == null) {
            return 0;
        }
        return this.c.a("video_play_page.interactive_method", 0);
    }

    @Override // sg.bigo.ads.ad.splash.a.b, sg.bigo.ads.ad.splash.a.c
    public final void a(boolean z) {
        super.a(z);
        this.n = z;
    }

    @Override // sg.bigo.ads.ad.splash.a.b, sg.bigo.ads.ad.splash.a.c
    public final void a(boolean z, ViewGroup viewGroup, int i) {
        super.a(z, viewGroup, i);
        if (!z || this.t) {
            return;
        }
        sg.bigo.ads.ad.splash.a.f13002a = true;
        this.t = true;
        ViewGroup viewGroup2 = (ViewGroup) viewGroup.findViewById(R.id.inter_fl_interaction_container);
        int i2 = R.layout.bigo_ad_item_interaction_vertical;
        if (this.h.getStyle() == SplashAd.Style.HORIZONTAL) {
            i2 = R.layout.bigo_ad_item_interaction_horizontal;
        }
        if (viewGroup2 != null) {
            View viewA = sg.bigo.ads.common.utils.a.a(viewGroup2.getContext(), i2, viewGroup2, false);
            viewGroup2.removeAllViews();
            viewGroup2.addView(viewA);
            ImageView imageView = (ImageView) viewA.findViewById(R.id.inter_iv_interaction_arrow);
            ImageView imageView2 = (ImageView) viewA.findViewById(R.id.inter_iv_interaction_phone);
            TextView textView = (TextView) viewA.findViewById(R.id.inter_tv_interaction_type);
            if (imageView != null && imageView2 != null && textView != null) {
                int iM = m();
                int i3 = R.drawable.bigo_ad_interaction_shake_arrow;
                int i4 = R.drawable.bigo_ad_interaction_shake_phone;
                String string = viewA.getContext().getString(R.string.bigo_ad_interaction_shake);
                if (iM != 1) {
                    if (iM == 2) {
                        i4 = R.drawable.bigo_ad_interaction_slide_hand;
                        i3 = R.drawable.bigo_ad_interaction_slide_line;
                        string = viewA.getContext().getString(R.string.bigo_ad_interaction_slide);
                    } else if (iM == 3) {
                        i3 = R.drawable.bigo_ad_interaction_twist_arrow;
                        string = viewA.getContext().getString(R.string.bigo_ad_interaction_twist);
                        i4 = sg.bigo.ads.ad.splash.a.b() ? R.drawable.bigo_ad_interaction_twist_landscape_phone : R.drawable.bigo_ad_interaction_twist_phone;
                    }
                } else if (sg.bigo.ads.ad.splash.a.b()) {
                    i4 = R.drawable.bigo_ad_interaction_shake_landscape_phone;
                }
                imageView.setImageResource(i3);
                imageView2.setImageResource(i4);
                textView.setText(string);
                if (iM == 1) {
                    sg.bigo.ads.ad.splash.a.b(imageView2);
                } else if (iM == 2) {
                    imageView2.setTranslationY(sg.bigo.ads.common.utils.e.a(imageView2.getContext(), 60));
                    sg.bigo.ads.ad.splash.a.a(imageView2, imageView2.getTranslationY());
                } else if (iM == 3) {
                    sg.bigo.ads.ad.splash.a.a(imageView2);
                }
            }
        }
        View viewFindViewById = viewGroup.findViewById(R.id.bigo_ad_splash_media);
        if (2 == m()) {
            if (viewFindViewById != null) {
                viewFindViewById.setOnTouchListener(this.u);
            }
            if (viewGroup2 != null) {
                viewGroup2.setOnTouchListener(this.u);
            }
        }
        Context context = viewGroup.getContext();
        int iM2 = m();
        int iIntValue = 4;
        if (this.m == null && context != null && (1 == iM2 || 3 == iM2)) {
            this.m = new sg.bigo.ads.common.q.b(context, Arrays.asList(4, 9, 1), new sg.bigo.ads.common.q.a() { // from class: sg.bigo.ads.ad.splash.a.d.2
                @Override // sg.bigo.ads.common.q.a
                public final void a(int i5, float[] fArr, float[] fArr2) {
                    char c;
                    if (i5 == 4) {
                        c = 2;
                        fArr = fArr2;
                    } else {
                        c = 0;
                    }
                    if (fArr.length == 3) {
                        int iM3 = d.this.m();
                        if (iM3 != 1) {
                            if (iM3 != 3) {
                                return;
                            }
                            float f = fArr[c];
                            if (-1.0f == d.this.r[c]) {
                                d.this.r[c] = f;
                            }
                            if (Math.abs(f - d.this.r[c]) > d.a(i5)) {
                                d.this.r[c] = f;
                                d.c(d.this);
                                return;
                            }
                            return;
                        }
                        for (int i6 = 0; i6 < fArr.length; i6++) {
                            float f2 = fArr[i6];
                            if (-1.0f == d.this.r[i6]) {
                                d.this.r[i6] = f2;
                            }
                            if (Math.abs(f2 - d.this.r[i6]) > d.a(i5)) {
                                d.this.r[i6] = f2;
                                d.c(d.this);
                                return;
                            }
                        }
                    }
                }
            });
        }
        sg.bigo.ads.common.q.b bVar = this.m;
        if (bVar != null) {
            try {
                bVar.c = (SensorManager) bVar.f13259a.get().getApplicationContext().getSystemService("sensor");
                Iterator<Integer> it = bVar.f.iterator();
                Sensor defaultSensor = null;
                while (it.hasNext() && (defaultSensor = bVar.c.getDefaultSensor((iIntValue = it.next().intValue()))) == null) {
                }
                bVar.c.registerListener(bVar.g, defaultSensor, iIntValue);
            } catch (Throwable unused) {
            }
        }
    }

    @Override // sg.bigo.ads.ad.splash.a.b, sg.bigo.ads.ad.splash.a.c
    public final void c() {
        super.c();
        sg.bigo.ads.common.q.b bVar = this.m;
        if (bVar != null) {
            if (bVar.c != null) {
                bVar.c.unregisterListener(bVar.g);
                bVar.g = null;
                bVar.c = null;
            }
            bVar.b = null;
            this.m = null;
        }
        this.u = null;
    }

    @Override // sg.bigo.ads.ad.splash.a.b
    protected final int e() {
        if (this.c != null && f()) {
            return sg.bigo.ads.ad.splash.a.b(this.b) ? R.layout.bigo_ad_splash_style_halfscreen_interaction : R.layout.bigo_ad_splash_style_fullscreen_interaction_immersive;
        }
        return l();
    }

    @Override // sg.bigo.ads.ad.splash.a.b
    protected final boolean g() {
        return false;
    }
}
