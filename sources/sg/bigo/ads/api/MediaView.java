package sg.bigo.ads.api;

import android.content.Context;
import android.graphics.Bitmap;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import sg.bigo.ads.api.core.o;
import sg.bigo.ads.common.p.g;
import sg.bigo.ads.common.utils.e;
import sg.bigo.ads.common.utils.u;
import sg.bigo.ads.common.view.AdImageView;
import sg.bigo.ads.common.view.RoundedFrameLayout;
import sg.bigo.ads.core.adview.f;
import sg.bigo.ads.core.f.a.p;

/* JADX INFO: loaded from: classes4.dex */
public class MediaView extends sg.bigo.ads.api.a<f> {

    public interface a {
        void a(sg.bigo.ads.core.player.b.b bVar);

        void a(boolean z);

        boolean a();

        void b();
    }

    public MediaView(Context context) {
        super(context);
    }

    public MediaView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public MediaView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    @Override // sg.bigo.ads.api.a
    protected final /* synthetic */ sg.bigo.ads.core.adview.c a() {
        return new f(this);
    }

    public final void a(Bitmap bitmap) {
        getViewImpl().g = false;
        f viewImpl = getViewImpl();
        if (bitmap != null) {
            int iA = e.a(viewImpl.f13501a.getContext(), 10);
            int iA2 = e.a(viewImpl.f13501a.getContext(), 4);
            RoundedFrameLayout roundedFrameLayout = new RoundedFrameLayout(viewImpl.f13501a.getContext());
            roundedFrameLayout.setCornerRadius(iA2);
            int width = bitmap.getWidth();
            int height = bitmap.getHeight();
            boolean z = (width == height && viewImpl.f13501a.getWidth() <= viewImpl.f13501a.getHeight()) || width > height;
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(z ? -1 : -2, z ? -2 : -1, 17);
            layoutParams.setMargins(iA, iA, iA, iA);
            roundedFrameLayout.setLayoutParams(layoutParams);
            AdImageView adImageView = new AdImageView(viewImpl.f13501a.getContext());
            adImageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
            u.a(adImageView, roundedFrameLayout, null, -1);
            u.a(roundedFrameLayout, viewImpl.f13501a, null, -1);
            adImageView.setBlurBorder(viewImpl.g);
            adImageView.setImageBitmap(bitmap);
        }
    }

    public final void a(String str) {
        getViewImpl().a(str);
    }

    public final void a(o oVar, g gVar) {
        getViewImpl().a(oVar, gVar);
    }

    public final void a(sg.bigo.ads.core.a.a aVar, p pVar, sg.bigo.ads.core.g.c cVar) {
        getViewImpl().a(aVar, pVar, cVar);
    }

    public final void a(sg.bigo.ads.core.player.b.d dVar) {
        getViewImpl().a(dVar);
    }

    public final float b(int i, int i2) {
        f viewImpl = getViewImpl();
        if (viewImpl.c == null) {
            return 0.0f;
        }
        return viewImpl.c() > viewImpl.d() ? (((i2 * viewImpl.c()) / viewImpl.d()) * 1.0f) / i : (((i * viewImpl.d()) / viewImpl.c()) * 1.0f) / i2;
    }

    public final a b() {
        return getViewImpl();
    }

    public final void c() {
        f viewImpl = getViewImpl();
        if (viewImpl.c != null) {
            viewImpl.c.setImageBitmap(null);
            viewImpl.c.a();
            viewImpl.c = null;
        }
        if (viewImpl.b != null) {
            viewImpl.b.d();
            viewImpl.b = null;
        }
    }

    public View getImage() {
        return getViewImpl().c;
    }

    public VideoController getVideoController() {
        return getViewImpl().f;
    }

    public void setImageBlurBorder(boolean z) {
        getViewImpl().g = z;
    }

    public void setMediaAreaClickable(boolean z) {
        getViewImpl().e = Boolean.valueOf(z);
    }

    public void setOtherClickAreaClick(boolean z) {
        getViewImpl().d = Boolean.valueOf(z);
    }
}
