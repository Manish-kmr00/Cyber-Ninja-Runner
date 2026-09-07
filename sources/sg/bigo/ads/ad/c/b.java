package sg.bigo.ads.ad.c;

import android.content.Context;
import android.view.ViewGroup;
import android.widget.ImageView;
import sg.bigo.ads.common.utils.e;
import sg.bigo.ads.common.utils.u;

/* JADX INFO: loaded from: classes7.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    ImageView f12571a;
    sg.bigo.ads.ad.b.c b;

    public b(sg.bigo.ads.ad.b.c cVar) {
        ImageView imageView;
        this.b = cVar;
        if (cVar == null || cVar.b.f == null) {
            imageView = null;
        } else {
            Context context = this.b.b.f;
            imageView = new ImageView(context);
            int iA = e.a(context, 38);
            imageView.setLayoutParams(new ViewGroup.MarginLayoutParams(iA, iA));
            imageView.setVisibility(8);
        }
        this.f12571a = imageView;
    }

    public final void a() {
        ImageView imageView = this.f12571a;
        if (imageView != null) {
            u.b(imageView);
            this.f12571a = null;
        }
        sg.bigo.ads.ad.b.c cVar = this.b;
        if (cVar != null) {
            cVar.destroy();
            this.b = null;
        }
    }
}
