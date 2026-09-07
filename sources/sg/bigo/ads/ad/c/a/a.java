package sg.bigo.ads.ad.c.a;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.drawable.BitmapDrawable;
import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.ScaleAnimation;
import android.webkit.ValueCallback;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import java.util.ArrayList;
import sg.bigo.ads.R;
import sg.bigo.ads.api.AdOptionsView;
import sg.bigo.ads.api.MediaView;
import sg.bigo.ads.api.core.i;
import sg.bigo.ads.common.n.d;
import sg.bigo.ads.common.o;
import sg.bigo.ads.common.p;
import sg.bigo.ads.common.p.e;
import sg.bigo.ads.common.p.f;
import sg.bigo.ads.common.p.g;
import sg.bigo.ads.common.utils.q;
import sg.bigo.ads.common.utils.u;

/* JADX INFO: loaded from: classes2.dex */
public abstract class a {
    public static final p f = new p(320, 50);
    public static final p g = new p(300, 250);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    protected final sg.bigo.ads.ad.b.c f12563a;
    protected FrameLayout b;
    protected Context c;
    protected MediaView d;
    protected Bitmap e;
    private C0819a h;
    private Bitmap i;

    /* JADX INFO: renamed from: sg.bigo.ads.ad.c.a.a$2, reason: invalid class name */
    public class AnonymousClass2 implements ValueCallback<Bitmap> {
        public AnonymousClass2() {
        }

        @Override // android.webkit.ValueCallback
        public final /* synthetic */ void onReceiveValue(Bitmap bitmap) {
            final Bitmap bitmap2 = bitmap;
            d.b(new Runnable() { // from class: sg.bigo.ads.ad.c.a.a.2.1
                @Override // java.lang.Runnable
                public final void run() {
                    if (a.this.c == null) {
                        return;
                    }
                    View viewFindViewWithTag = a.this.d != null ? a.this.d.findViewWithTag("blur_image_view") : null;
                    if (viewFindViewWithTag instanceof C0819a) {
                        a.this.h = (C0819a) viewFindViewWithTag;
                    } else {
                        a.this.h = a.this.new C0819a(a.this.c);
                        a.this.h.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
                        u.a(a.this.h, a.this.d, null, 0);
                        a.this.h.setTag("blur_image_view");
                    }
                    if (a.this.h != null) {
                        a.this.h.setScaleType(ImageView.ScaleType.CENTER_CROP);
                        Bitmap bitmap3 = bitmap2;
                        sg.bigo.ads.common.utils.d.b(a.this.h.getContext(), (bitmap3 == null || bitmap3.getWidth() <= 0 || bitmap2.getHeight() <= 0) ? a.this.g() : bitmap2, new ValueCallback<Bitmap>() { // from class: sg.bigo.ads.ad.c.a.a.2.1.1
                            @Override // android.webkit.ValueCallback
                            public final /* synthetic */ void onReceiveValue(Bitmap bitmap4) {
                                Bitmap bitmap5 = bitmap4;
                                if (a.this.h != null) {
                                    a.this.h.setImageBitmap(bitmap5);
                                }
                            }
                        });
                    }
                }
            });
        }
    }

    /* JADX INFO: renamed from: sg.bigo.ads.ad.c.a.a$a, reason: collision with other inner class name */
    class C0819a extends ImageView {
        public C0819a(Context context) {
            super(context);
        }

        @Override // android.widget.ImageView, android.view.View
        protected final void onMeasure(int i, int i2) {
            setMeasuredDimension(View.MeasureSpec.getSize(i), View.MeasureSpec.getSize(i2));
        }
    }

    protected a(sg.bigo.ads.ad.b.c cVar, Context context) {
        this.f12563a = cVar;
        this.c = context;
        d();
    }

    public static a a(sg.bigo.ads.ad.b.c cVar, Context context, i.b bVar) {
        return g.equals(new p(bVar != null ? bVar.a() : 0, bVar != null ? bVar.b() : 0)) ? new b(cVar, context) : new c(cVar, context);
    }

    protected static void a(TextView textView, String str, String str2) {
        if (textView == null) {
            return;
        }
        if (!TextUtils.isEmpty(str)) {
            textView.setText(str);
        } else {
            if (TextUtils.isEmpty(str2)) {
                return;
            }
            textView.setText(str2);
        }
    }

    static /* synthetic */ void a(a aVar, ViewGroup viewGroup, View view, MediaView mediaView, ImageView imageView, int i) {
        ArrayList arrayList = new ArrayList();
        TextView textView = (TextView) view.findViewById(R.id.inter_title);
        if (textView != null) {
            textView.setTag(2);
            a(textView, aVar.f12563a.getTitle(), "");
            arrayList.add(textView);
        }
        TextView textView2 = (TextView) view.findViewById(R.id.inter_description);
        if (textView2 != null) {
            textView2.setTag(6);
            a(textView2, aVar.f12563a.getDescription(), "");
            arrayList.add(textView2);
        }
        TextView textView3 = (TextView) view.findViewById(R.id.inter_btn_cta);
        if (textView3 != null) {
            textView3.setTag(7);
            a(textView3, aVar.f12563a.getCallToAction(), "");
            arrayList.add(textView3);
        }
        TextView textView4 = (TextView) view.findViewById(R.id.inter_advertiser);
        if (textView4 != null) {
            String advertiser = aVar.f12563a.getAdvertiser();
            if (q.a((CharSequence) advertiser)) {
                textView4.setVisibility(8);
            } else {
                textView4.setText(advertiser);
            }
        }
        if (imageView != null) {
            try {
                ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) imageView.getLayoutParams();
                if (marginLayoutParams != null) {
                    marginLayoutParams.rightMargin = aVar.b();
                }
                imageView.setLayoutParams(marginLayoutParams);
            } catch (Exception unused) {
            }
            u.a(imageView, (ViewGroup) view.findViewById(R.id.inter_rounded_icon_layout), null, -1);
        }
        AdOptionsView adOptionsView = (AdOptionsView) view.findViewById(R.id.inter_options);
        if (mediaView != null) {
            u.a(mediaView, (ViewGroup) view.findViewById(R.id.inter_media_layout), null, -1);
        }
        aVar.f12563a.G = i;
        aVar.f12563a.registerViewForInteraction(viewGroup, mediaView, imageView, adOptionsView, arrayList);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void a(sg.bigo.ads.core.a.a aVar, final ValueCallback<Bitmap> valueCallback) {
        String strAS = aVar.aS();
        if (q.a((CharSequence) strAS)) {
            valueCallback.onReceiveValue(null);
        } else {
            e.a(this.f12563a.b.e, strAS, aVar.al(), new g() { // from class: sg.bigo.ads.ad.c.a.a.4
                @Override // sg.bigo.ads.common.p.g
                public final void a(int i, String str, String str2) {
                    valueCallback.onReceiveValue(null);
                }

                @Override // sg.bigo.ads.common.p.g
                public final void a(Bitmap bitmap, f fVar) {
                    a.this.i = bitmap;
                    valueCallback.onReceiveValue(bitmap);
                }
            });
        }
    }

    public abstract int a();

    public final void a(int i) {
        b(i);
    }

    public final void a(View view, boolean z) {
        FrameLayout frameLayout = this.b;
        if (frameLayout == null || view == null) {
            return;
        }
        sg.bigo.ads.ad.c.a.a(frameLayout, view, z);
    }

    public final synchronized void a(final ValueCallback<Bitmap> valueCallback, boolean z) {
        if (z) {
            Bitmap bitmap = this.i;
            if (bitmap != null) {
                valueCallback.onReceiveValue(bitmap);
                return;
            }
        }
        final sg.bigo.ads.core.a.a aVar = (sg.bigo.ads.core.a.a) this.f12563a.f();
        if (z) {
            a(aVar, valueCallback);
            return;
        }
        String strB = o.b(this.f12563a.b.e, aVar.aM());
        if (q.a((CharSequence) strB)) {
            a(aVar, valueCallback);
        } else {
            final String path = Uri.parse(strB).getPath();
            d.a(3, new Runnable() { // from class: sg.bigo.ads.ad.c.a.a.3
                @Override // java.lang.Runnable
                public final void run() {
                    Bitmap bitmapA = sg.bigo.ads.common.utils.d.a(Uri.parse(path).getPath(), a.this.f12563a.b.e);
                    if (bitmapA == null) {
                        a.this.a(aVar, (ValueCallback<Bitmap>) valueCallback);
                    } else {
                        a.this.i = bitmapA;
                        valueCallback.onReceiveValue(bitmapA);
                    }
                }
            });
        }
    }

    public final void a(final ImageView imageView, final int i) {
        if (this.b == null) {
            return;
        }
        final View viewA = sg.bigo.ads.common.utils.a.a(this.c, a(), this.b, true);
        d.b(new Runnable() { // from class: sg.bigo.ads.ad.c.a.a.1
            @Override // java.lang.Runnable
            public final void run() {
                if (viewA != null) {
                    a aVar = a.this;
                    a.a(aVar, aVar.b, viewA, a.this.d, imageView, i);
                }
            }
        });
    }

    public final void a(boolean z) {
        a(this.d, z);
    }

    public abstract int b();

    protected void b(int i) {
        Button button;
        FrameLayout frameLayout = this.b;
        if (frameLayout != null && (button = (Button) frameLayout.findViewById(R.id.inter_btn_cta)) != null) {
            new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: sg.bigo.ads.ad.c.a.1

                /* JADX INFO: renamed from: a */
                final /* synthetic */ Button f12556a;

                public AnonymousClass1() {
                    button = button;
                }

                @Override // java.lang.Runnable
                public final void run() {
                    ScaleAnimation scaleAnimation = new ScaleAnimation(1.0f, 0.9f, 1.0f, 0.9f, 1, 0.5f, 1, 0.5f);
                    scaleAnimation.setDuration(200L);
                    scaleAnimation.setInterpolator(sg.bigo.ads.common.utils.b.a(1));
                    scaleAnimation.setRepeatCount(-1);
                    scaleAnimation.setRepeatMode(2);
                    button.startAnimation(scaleAnimation);
                }
            });
        }
        if (i == 1) {
            sg.bigo.ads.ad.c.a.a(this.b, 2000L, 6);
        } else {
            if (i != 2) {
                return;
            }
            sg.bigo.ads.ad.c.a.a(this.b, 2000L, 3, c());
        }
    }

    public abstract int[] c();

    public abstract void d();

    public final View e() {
        return this.b;
    }

    public final void f() {
        View viewFindViewById;
        FrameLayout frameLayout = this.b;
        if (frameLayout == null || (viewFindViewById = frameLayout.findViewById(R.id.inter_banner_click_guide_contain)) == null) {
            return;
        }
        viewFindViewById.clearAnimation();
        u.b(viewFindViewById);
    }

    protected final Bitmap g() {
        Bitmap bitmap;
        int width;
        int height;
        Bitmap bitmapA;
        Bitmap bitmap2 = this.e;
        if (bitmap2 != null) {
            return bitmap2;
        }
        BitmapDrawable bitmapDrawable = (BitmapDrawable) sg.bigo.ads.common.utils.a.a(this.c, R.drawable.bigo_ad_default_base_image);
        if (bitmapDrawable == null || (bitmap = bitmapDrawable.getBitmap()) == null || bitmap.getHeight() <= 0 || bitmap.getWidth() <= 0 || (bitmapA = sg.bigo.ads.common.utils.d.a((width = bitmap.getWidth()), (height = bitmap.getHeight()), bitmap.getConfig())) == null) {
            return null;
        }
        Canvas canvas = new Canvas(bitmapA);
        canvas.drawBitmap(bitmap, 0.0f, 0.0f, (Paint) null);
        Paint paint = new Paint();
        float[] fArr = new float[3];
        sg.bigo.ads.ad.b.c cVar = this.f12563a;
        Integer numValueOf = cVar.G() ? null : cVar.L;
        if (numValueOf == null) {
            numValueOf = Integer.valueOf(q.b("#009dff", -16776961));
        }
        Color.colorToHSV(Color.argb(255, Color.red(numValueOf.intValue()), Color.green(numValueOf.intValue()), Color.blue(numValueOf.intValue())), fArr);
        fArr[1] = 100.0f;
        fArr[2] = 100.0f;
        paint.setColor(Color.HSVToColor(fArr));
        paint.setStyle(Paint.Style.FILL);
        paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.MULTIPLY));
        canvas.drawRect(0.0f, 0.0f, width, height, paint);
        this.e = bitmapA;
        return bitmapA;
    }

    public final void h() {
        FrameLayout frameLayout = this.b;
        if (frameLayout != null) {
            u.b(frameLayout);
            this.b = null;
        }
        MediaView mediaView = this.d;
        if (mediaView != null) {
            u.b(mediaView);
            this.d.c();
            this.d = null;
        }
        this.c = null;
    }

    public abstract int i();

    public abstract int j();
}
