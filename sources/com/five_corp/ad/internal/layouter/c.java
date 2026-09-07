package com.five_corp.ad.internal.layouter;

import android.widget.FrameLayout;
import android.widget.ImageView;
import com.five_corp.ad.internal.ad.s;
import com.five_corp.ad.internal.o;
import com.five_corp.ad.internal.p;
import com.five_corp.ad.internal.view.J;

/* JADX INFO: loaded from: classes10.dex */
public final class c implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ImageView[] f1415a;
    public int b = 0;
    public final /* synthetic */ com.five_corp.ad.internal.ad.custom_layout.f c;
    public final /* synthetic */ FrameLayout d;
    public final /* synthetic */ e e;

    public c(e eVar, com.five_corp.ad.internal.ad.custom_layout.f fVar, FrameLayout frameLayout) {
        this.e = eVar;
        this.c = fVar;
        this.d = frameLayout;
        this.f1415a = new ImageView[fVar.b.size()];
    }

    @Override // java.lang.Runnable
    public final void run() {
        try {
            ImageView imageView = this.f1415a[this.b];
            if (imageView == null) {
                int size = this.c.b.size();
                int i = this.b;
                if (size > i) {
                    s sVar = (s) this.c.b.get(i);
                    ImageView[] imageViewArr = this.f1415a;
                    int i2 = this.b;
                    e eVar = this.e;
                    imageViewArr[i2] = eVar.k.h.a(eVar.b, sVar);
                }
            }
            for (int i3 = 0; i3 < this.d.getChildCount(); i3++) {
                J.a(this.d.getChildAt(i3));
            }
            this.d.addView(imageView, new FrameLayout.LayoutParams(-1, -1));
            int i4 = this.b + 1;
            this.b = i4;
            if (i4 >= this.c.b.size() && this.c.f1279a) {
                this.b = 0;
            }
            if (this.b < this.c.b.size()) {
                this.e.c.postDelayed(this, this.c.c);
            }
        } catch (Exception e) {
            this.e.h.a(new o(p.Q6, null, e, null));
        }
    }
}
