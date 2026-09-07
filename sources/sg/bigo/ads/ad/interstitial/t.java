package sg.bigo.ads.ad.interstitial;

import android.content.Context;
import android.graphics.Bitmap;
import android.net.Uri;
import android.text.TextUtils;
import android.util.Pair;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.URLUtil;
import android.webkit.ValueCallback;
import android.widget.ImageView;
import android.widget.TextView;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import sg.bigo.ads.R;
import sg.bigo.ads.api.AdOptionsView;
import sg.bigo.ads.api.MediaView;

/* JADX INFO: loaded from: classes6.dex */
public class t extends e {
    public final sg.bigo.ads.ad.b.c c;
    ImageView e;
    ImageView f;
    public Bitmap g;
    protected Bitmap h;
    private int k = 0;
    private final List<v> l = new ArrayList();
    private boolean m = false;
    private boolean n = false;
    public int i = 0;
    final AtomicBoolean j = new AtomicBoolean(false);
    final d d = new d();

    public interface a {
        Pair<String, String> a(TextView textView, String str, String str2);
    }

    public t(sg.bigo.ads.ad.b.c cVar) {
        this.c = cVar;
    }

    public static void a(View view) {
        AdOptionsView adOptionsView;
        if (view == null || (adOptionsView = (AdOptionsView) view.findViewById(R.id.inter_options)) == null) {
            return;
        }
        adOptionsView.setVisibility(adOptionsView.findViewWithTag("ad_options_real_view") == null ? 8 : 0);
    }

    private static void a(a aVar, TextView textView, String str, String str2) {
        Pair<String, String> pairA;
        if (aVar != null && (pairA = aVar.a(textView, str, str2)) != null) {
            str = (String) pairA.first;
            str2 = (String) pairA.second;
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

    private synchronized void a(v vVar) {
        if (this.g != null) {
            vVar.a();
            return;
        }
        this.l.add(vVar);
        if (this.k == 1) {
            return;
        }
        this.k = 1;
        b(new ValueCallback<Bitmap>() { // from class: sg.bigo.ads.ad.interstitial.t.11
            @Override // android.webkit.ValueCallback
            public final /* synthetic */ void onReceiveValue(Bitmap bitmap) {
                t.this.a(bitmap);
            }
        });
    }

    private synchronized void b(final ValueCallback<Bitmap> valueCallback) {
        sg.bigo.ads.core.a.a aVar = (sg.bigo.ads.core.a.a) this.c.f();
        if (!aVar.aQ()) {
            String strAS = aVar.aS();
            if (sg.bigo.ads.common.utils.q.a((CharSequence) strAS)) {
                valueCallback.onReceiveValue(null);
                return;
            } else {
                sg.bigo.ads.common.p.e.a(this.c.b.e, strAS, aVar.al(), new sg.bigo.ads.common.p.g() { // from class: sg.bigo.ads.ad.interstitial.t.14
                    @Override // sg.bigo.ads.common.p.g
                    public final void a(int i, String str, String str2) {
                        valueCallback.onReceiveValue(null);
                    }

                    @Override // sg.bigo.ads.common.p.g
                    public final void a(Bitmap bitmap, sg.bigo.ads.common.p.f fVar) {
                        valueCallback.onReceiveValue(bitmap);
                    }
                });
                return;
            }
        }
        String strB = sg.bigo.ads.common.o.b(this.c.b.e, aVar.aM());
        if (sg.bigo.ads.common.utils.q.a((CharSequence) strB)) {
            valueCallback.onReceiveValue(null);
        } else {
            final String path = Uri.parse(strB).getPath();
            sg.bigo.ads.common.n.d.a(3, new Runnable() { // from class: sg.bigo.ads.ad.interstitial.t.13
                @Override // java.lang.Runnable
                public final void run() {
                    valueCallback.onReceiveValue(sg.bigo.ads.common.utils.d.a(Uri.parse(path).getPath(), t.this.c.b.e));
                }
            });
        }
    }

    final synchronized void a(Bitmap bitmap) {
        this.g = bitmap;
        Iterator<v> it = this.l.iterator();
        while (it.hasNext()) {
            it.next().a();
            it.remove();
        }
        this.k = 2;
    }

    public void a(final ViewGroup viewGroup) {
        this.n = true;
        a(new v() { // from class: sg.bigo.ads.ad.interstitial.t.3
            @Override // sg.bigo.ads.ad.interstitial.v
            public final void a() {
                Integer numA = sg.bigo.ads.common.w.b.a(t.this.g);
                if (numA != null) {
                    t.this.d.a(numA.intValue());
                }
                t.this.b(viewGroup);
            }
        });
    }

    public final void a(final ViewGroup viewGroup, final int i) {
        sg.bigo.ads.common.n.d.b(new Runnable() { // from class: sg.bigo.ads.ad.interstitial.t.5
            @Override // java.lang.Runnable
            public final void run() {
                View viewFindViewWithTag = viewGroup.findViewWithTag("adview_background_main_tag");
                if (viewFindViewWithTag instanceof ImageView) {
                    t.this.f = (ImageView) viewFindViewWithTag;
                } else {
                    Context context = viewGroup.getContext();
                    if (context != null) {
                        t.this.f = new ImageView(context);
                        t.this.f.setTag("adview_background_main_tag");
                        t.this.f.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
                        sg.bigo.ads.common.utils.u.a(t.this.f, viewGroup, null, 0);
                    }
                }
                if (t.this.f != null) {
                    t.this.f.setBackgroundColor(i);
                }
            }
        });
    }

    public void a(ViewGroup viewGroup, View view, int i, int i2, int i3, View... viewArr) {
        a(viewGroup, view, null, i, i2, i3, viewArr);
    }

    /* JADX WARN: Type inference failed for: r1v27, types: [sg.bigo.ads.api.core.c] */
    public void a(ViewGroup viewGroup, View view, a aVar, int i, int i2, int i3, View... viewArr) {
        ArrayList arrayList = new ArrayList();
        sg.bigo.ads.api.core.c.d popPage = this.c.getPopPage();
        TextView textView = (TextView) view.findViewById(R.id.inter_title);
        if (textView != null) {
            textView.setTag(2);
            a(aVar, textView, this.c.getTitle(), popPage == null ? "" : popPage.b());
            arrayList.add(textView);
        }
        TextView textView2 = (TextView) view.findViewById(R.id.inter_description);
        if (textView2 != null) {
            textView2.setTag(6);
            a(aVar, textView2, this.c.getDescription(), popPage == null ? "" : popPage.c());
            arrayList.add(textView2);
        }
        TextView textView3 = (TextView) view.findViewById(R.id.inter_warning);
        if (textView3 != null) {
            textView3.setTag(8);
            String warning = this.c.getWarning();
            if (TextUtils.isEmpty(warning)) {
                textView3.setVisibility(8);
            } else {
                textView3.setText(warning);
            }
            arrayList.add(textView3);
        }
        TextView textView4 = (TextView) view.findViewById(R.id.inter_btn_cta);
        if (textView4 != null) {
            textView4.setTag(7);
            a(aVar, textView4, this.c.getCallToAction(), "");
            arrayList.add(textView4);
        }
        TextView textView5 = (TextView) view.findViewById(R.id.inter_btn_cta_main);
        if (textView5 != null) {
            textView5.setTag(7);
            a(aVar, textView5, sg.bigo.ads.common.utils.a.a(textView5.getContext(), R.string.bigo_ad_cta_default, new Object[0]), "");
            arrayList.add(textView5);
        }
        final ImageView imageView = (ImageView) view.findViewById(R.id.inter_end_page_image);
        if (imageView != null) {
            imageView.setTag(5);
            final ValueCallback<Bitmap> valueCallback = new ValueCallback<Bitmap>() { // from class: sg.bigo.ads.ad.interstitial.t.1
                @Override // android.webkit.ValueCallback
                public final /* synthetic */ void onReceiveValue(Bitmap bitmap) {
                    final Bitmap bitmap2 = bitmap;
                    imageView.post(new Runnable() { // from class: sg.bigo.ads.ad.interstitial.t.1.1
                        @Override // java.lang.Runnable
                        public final void run() {
                            imageView.setImageBitmap(bitmap2);
                        }
                    });
                }
            };
            Bitmap bitmap = this.h;
            if (bitmap != null) {
                valueCallback.onReceiveValue(bitmap);
            } else {
                a(new v() { // from class: sg.bigo.ads.ad.interstitial.t.7
                    @Override // sg.bigo.ads.ad.interstitial.v
                    public final void a() {
                        valueCallback.onReceiveValue(t.this.g);
                    }
                });
            }
        }
        TextView textView6 = (TextView) view.findViewById(R.id.inter_company);
        if (textView6 != null) {
            textView6.setTag(26);
            if (popPage == null || sg.bigo.ads.common.utils.q.a((CharSequence) popPage.f())) {
                textView6.setVisibility(8);
            } else {
                a(aVar, textView6, popPage.f(), "");
            }
            arrayList.add(textView6);
        }
        TextView textView7 = (TextView) view.findViewById(R.id.inter_star_num);
        View viewFindViewById = view.findViewById(R.id.inter_star_layout);
        if (textView7 != null && viewFindViewById != null) {
            viewFindViewById.setTag(26);
            textView7.setText(sg.bigo.ads.ad.b.f.c(((sg.bigo.ads.core.a.a) this.c.f()).n()));
            arrayList.add(viewFindViewById);
        }
        TextView textView8 = (TextView) view.findViewById(R.id.inter_commit_num);
        if (textView8 != null) {
            textView8.setTag(26);
            textView8.setText(sg.bigo.ads.ad.b.f.b(((sg.bigo.ads.core.a.a) this.c.f()).n()) + " " + sg.bigo.ads.common.utils.a.a(viewGroup.getContext(), R.string.bigo_ad_comment_num_text, new Object[0]));
            arrayList.add(textView8);
        }
        TextView textView9 = (TextView) view.findViewById(R.id.inter_download_num);
        View viewFindViewById2 = view.findViewById(R.id.inter_download_num_layout);
        if (textView9 != null && viewFindViewById2 != null) {
            viewFindViewById2.setTag(26);
            textView9.setText(sg.bigo.ads.ad.b.f.a(((sg.bigo.ads.core.a.a) this.c.f()).n()));
            arrayList.add(viewFindViewById2);
        }
        View viewFindViewById3 = view.findViewById(R.id.inter_everyone_layout);
        if (viewFindViewById3 != null) {
            viewFindViewById3.setTag(26);
            arrayList.add(viewFindViewById3);
        }
        this.e = (ImageView) view.findViewById(R.id.inter_icon);
        AdOptionsView adOptionsView = (AdOptionsView) view.findViewById(R.id.inter_options);
        MediaView mediaView = (MediaView) view.findViewById(R.id.inter_media);
        this.c.G = i3;
        this.c.a(viewGroup, mediaView, this.e, adOptionsView, (List<View>) arrayList, i2, viewArr);
        if (this.e == null || this.c.hasIcon()) {
            return;
        }
        String strA = popPage != null ? popPage.a() : "";
        if (sg.bigo.ads.common.utils.q.a((CharSequence) strA) || !URLUtil.isNetworkUrl(strA)) {
            if (i == 2) {
                this.e.setImageDrawable(sg.bigo.ads.common.utils.a.a(this.e.getContext(), R.drawable.bigo_ad_icon_default));
                return;
            } else if (i == 1) {
                a(this.e);
                return;
            } else {
                if (i == 3) {
                    this.e.setImageDrawable(sg.bigo.ads.common.utils.a.a(this.e.getContext(), R.drawable.bigo_ad_icon_novideo_default));
                    return;
                }
                return;
            }
        }
        if (!sg.bigo.ads.api.a.i.f13093a.n().a(9) || !URLUtil.isHttpUrl(strA)) {
            sg.bigo.ads.common.p.e.b(this.c.b.e, null, strA, ((sg.bigo.ads.core.a.a) this.c.f()).al(), new sg.bigo.ads.common.p.g() { // from class: sg.bigo.ads.ad.interstitial.t.8
                @Override // sg.bigo.ads.common.p.g
                public final void a(int i4, String str, String str2) {
                }

                @Override // sg.bigo.ads.common.p.g
                public final void a(Bitmap bitmap2, sg.bigo.ads.common.p.f fVar) {
                    if (t.this.e != null) {
                        t.this.e.setImageBitmap(bitmap2);
                    }
                }
            });
            return;
        }
        sg.bigo.ads.ad.b.c cVar = this.c;
        if (cVar == null || cVar.f() == 0) {
            return;
        }
        sg.bigo.ads.core.d.b.a((sg.bigo.ads.api.core.c) this.c.f(), 3000, 10220, "Invalid http url: ".concat(String.valueOf(strA)));
    }

    public final synchronized void a(final ValueCallback<Bitmap> valueCallback) {
        if (valueCallback == null) {
            return;
        }
        a(new v() { // from class: sg.bigo.ads.ad.interstitial.t.12
            @Override // sg.bigo.ads.ad.interstitial.v
            public final void a() {
                valueCallback.onReceiveValue(t.this.g);
            }
        });
    }

    final void a(final ImageView imageView) {
        this.m = true;
        a(new v() { // from class: sg.bigo.ads.ad.interstitial.t.2
            @Override // sg.bigo.ads.ad.interstitial.v
            public final void a() {
                sg.bigo.ads.common.n.d.b(new Runnable() { // from class: sg.bigo.ads.ad.interstitial.t.2.1
                    @Override // java.lang.Runnable
                    public final void run() {
                        imageView.setImageBitmap(t.this.g);
                        imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
                    }
                });
            }
        });
    }

    protected void b(final ViewGroup viewGroup) {
        sg.bigo.ads.common.utils.d.a(viewGroup.getContext(), this.g, new ValueCallback<Bitmap>() { // from class: sg.bigo.ads.ad.interstitial.t.4
            @Override // android.webkit.ValueCallback
            public final /* synthetic */ void onReceiveValue(Bitmap bitmap) {
                Bitmap bitmap2 = bitmap;
                View viewFindViewWithTag = viewGroup.findViewWithTag("adview_background_main_tag");
                if (viewFindViewWithTag instanceof ImageView) {
                    t.this.f = (ImageView) viewFindViewWithTag;
                } else {
                    Context context = viewGroup.getContext();
                    if (context != null) {
                        t.this.f = new ImageView(context);
                        t.this.f.setTag("adview_background_main_tag");
                        t.this.f.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
                        sg.bigo.ads.common.utils.u.a(t.this.f, viewGroup, null, 0);
                    }
                }
                if (t.this.f == null || bitmap2 == null) {
                    return;
                }
                t.this.f.setScaleType(ImageView.ScaleType.CENTER_CROP);
                t.this.f.setImageBitmap(bitmap2);
            }
        });
    }

    public final void d() {
        if (this.g == null) {
            ImageView imageView = this.e;
            if (imageView != null && this.m) {
                a(imageView);
            }
            if (this.f == null || !this.n) {
                return;
            }
            a(new v() { // from class: sg.bigo.ads.ad.interstitial.t.9
                @Override // sg.bigo.ads.ad.interstitial.v
                public final void a() {
                    final Bitmap bitmapB = sg.bigo.ads.common.utils.d.b(t.this.f.getContext(), t.this.g);
                    t.this.f.post(new Runnable() { // from class: sg.bigo.ads.ad.interstitial.t.9.1
                        @Override // java.lang.Runnable
                        public final void run() {
                            t.this.f.setScaleType(ImageView.ScaleType.CENTER_CROP);
                            sg.bigo.ads.common.utils.d.a(t.this.f, bitmapB);
                        }
                    });
                }
            });
        }
    }

    public d e() {
        return this.d;
    }

    public void f() {
    }

    public final synchronized Bitmap g() {
        Bitmap bitmap = this.h;
        if (bitmap == null || bitmap.isRecycled()) {
            return null;
        }
        return this.h;
    }

    public final synchronized sg.bigo.ads.common.p h() {
        if (this.h != null) {
            return new sg.bigo.ads.common.p(this.h.getWidth(), this.h.getHeight());
        }
        return new sg.bigo.ads.common.p(-1, -1);
    }

    public final synchronized void i() {
        sg.bigo.ads.core.a.a aVar = (sg.bigo.ads.core.a.a) this.c.f();
        if (aVar.aQ()) {
            Bitmap bitmap = this.h;
            if (bitmap == null || bitmap.isRecycled()) {
                if (this.j.compareAndSet(false, true)) {
                    String strAS = aVar.aS();
                    if (sg.bigo.ads.common.utils.q.a((CharSequence) strAS)) {
                        return;
                    }
                    sg.bigo.ads.common.p.e.a(this.c.b.e, strAS, aVar.al(), new sg.bigo.ads.common.p.g() { // from class: sg.bigo.ads.ad.interstitial.t.6
                        @Override // sg.bigo.ads.common.p.g
                        public final void a(int i, String str, String str2) {
                            t.this.j.set(false);
                        }

                        @Override // sg.bigo.ads.common.p.g
                        public final void a(Bitmap bitmap2, sg.bigo.ads.common.p.f fVar) {
                            t.this.h = bitmap2;
                            t tVar = t.this;
                            tVar.i = sg.bigo.ads.common.w.b.a(tVar.h, 0);
                            t.this.j.set(false);
                        }
                    });
                }
            }
        }
    }
}
