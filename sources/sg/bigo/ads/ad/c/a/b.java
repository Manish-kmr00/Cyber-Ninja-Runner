package sg.bigo.ads.ad.c.a;

import android.content.Context;
import android.graphics.drawable.BitmapDrawable;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;
import sg.bigo.ads.R;
import sg.bigo.ads.api.MediaView;
import sg.bigo.ads.common.utils.e;
import sg.bigo.ads.common.utils.u;

/* JADX INFO: loaded from: classes2.dex */
public final class b extends a {
    private View h;

    public b(sg.bigo.ads.ad.b.c cVar, Context context) {
        super(cVar, context);
        sg.bigo.ads.api.c.b.a(0);
    }

    @Override // sg.bigo.ads.ad.c.a.a
    public final int a() {
        return R.layout.bigo_ad_native_banner_medium;
    }

    @Override // sg.bigo.ads.ad.c.a.a
    public final int b() {
        return e.a(this.c, 8);
    }

    @Override // sg.bigo.ads.ad.c.a.a
    public final void b(int i) {
        if (this.h != null) {
            this.h.setBackground(new BitmapDrawable(this.c.getResources(), g()));
        }
        super.b(i);
    }

    @Override // sg.bigo.ads.ad.c.a.a
    public final int[] c() {
        return new int[]{e.a(this.c, -57), e.a(this.c, 153)};
    }

    @Override // sg.bigo.ads.ad.c.a.a
    public final void d() {
        this.b = new FrameLayout(this.c);
        int iA = e.a(this.c, 276);
        int iA2 = e.a(this.c, 174);
        this.d = new MediaView(this.c);
        this.d.setImageBlurBorder(false);
        this.d.setLayoutParams(new ViewGroup.LayoutParams(iA, iA2));
        View viewA = sg.bigo.ads.common.utils.a.a(this.c, R.layout.bigo_ad_banner_placeholder_img, null, false);
        this.h = viewA;
        if (viewA != null) {
            u.a(viewA, this.d, null, -1);
            View view = this.h;
            a((TextView) view.findViewById(R.id.bigo_ad_banner_background_text), this.f12563a.getTitle(), "");
            a((TextView) view.findViewById(R.id.bigo_ad_image_title), this.f12563a.getTitle(), "");
            a((TextView) view.findViewById(R.id.bigo_ad_banner_image_description), this.f12563a.getDescription(), "");
            TextView textView = (TextView) view.findViewById(R.id.bigo_ad_banner_image_domain);
            String advertiser = this.f12563a.getAdvertiser();
            if (textView != null) {
                if (TextUtils.isEmpty(advertiser)) {
                    textView.setVisibility(8);
                } else {
                    textView.setText(advertiser);
                }
            }
        }
    }

    @Override // sg.bigo.ads.ad.c.a.a
    public final int i() {
        return 300;
    }

    @Override // sg.bigo.ads.ad.c.a.a
    public final int j() {
        return 250;
    }
}
