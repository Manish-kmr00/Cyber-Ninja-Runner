package sg.bigo.ads.common.form.render;

import android.content.Context;
import android.graphics.Rect;
import android.text.TextUtils;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;
import java.lang.ref.WeakReference;
import java.util.Map;
import sg.bigo.ads.R;
import sg.bigo.ads.api.a.e;
import sg.bigo.ads.common.n.d;

/* JADX INFO: loaded from: classes7.dex */
public final class b implements sg.bigo.ads.common.form.b.a, c.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f13168a;
    public final e b;
    public final sg.bigo.ads.common.form.render.a.c c;
    public Button d;
    public RelativeLayout e;
    long f;
    int g;
    private final WeakReference<a> j;
    private int k;
    private boolean i = false;
    private boolean[] l = new boolean[13];
    final Runnable h = new Runnable() { // from class: sg.bigo.ads.common.form.render.b.1
        @Override // java.lang.Runnable
        public final void run() {
            if (b.this.e == null || b.this.f > 0) {
                d.a(b.this.h);
                return;
            }
            if (!sg.bigo.ads.common.ab.a.a(b.this.e, new Rect())) {
                d.a(2, b.this.h, 500L);
                return;
            }
            d.a(b.this.h);
            b.this.f = System.currentTimeMillis();
            b bVar = b.this;
            bVar.a(1, bVar.g, 0L);
        }
    };

    public interface a {
        void a();

        void a(String str);
    }

    public b(Context context, e eVar, Map<String, Object> map, int i, int i2, a aVar) {
        this.f13168a = context;
        this.b = eVar;
        sg.bigo.ads.common.form.render.a.f13161a = eVar.d() == 1;
        this.c = new sg.bigo.ads.common.form.render.a.c(eVar, map, context, this);
        this.j = new WeakReference<>(aVar);
        this.g = i;
        this.k = i2;
    }

    public static void a(TextView textView, String str) {
        if (textView == null) {
            return;
        }
        if (TextUtils.isEmpty(str)) {
            textView.setVisibility(8);
        } else {
            textView.setText(str);
        }
    }

    private void d(String str) {
        if (this.j.get() != null) {
            this.j.get().a(str);
        }
    }

    @Override // sg.bigo.ads.common.form.render.c.a
    public final void a() {
        Button button = this.d;
        if (button == null || this.i) {
            return;
        }
        button.setEnabled(true);
        this.d.setBackgroundResource(R.drawable.bigo_ad_btn_background);
        this.d.setTextColor(-1);
        this.i = true;
        a(2, this.g, System.currentTimeMillis() - this.f);
    }

    @Override // sg.bigo.ads.common.form.b.a
    public final void a(int i) {
        int i2;
        long jCurrentTimeMillis;
        int i3;
        if (i != 1) {
            if (i == 2) {
                i2 = this.g;
                jCurrentTimeMillis = System.currentTimeMillis() - this.f;
                i3 = 8;
            }
            sg.bigo.ads.common.form.a.b(this.k);
        }
        i2 = this.g;
        jCurrentTimeMillis = System.currentTimeMillis() - this.f;
        i3 = 7;
        a(i3, i2, jCurrentTimeMillis);
        sg.bigo.ads.common.form.a.b(this.k);
    }

    final void a(int i, int i2, long j) {
        boolean[] zArr = this.l;
        if (i >= zArr.length || zArr[i]) {
            return;
        }
        sg.bigo.ads.core.d.b.a(i, i2, j);
        this.l[i] = true;
    }

    @Override // sg.bigo.ads.common.form.render.c.a
    public final void a(String str) {
        a(11, this.g, System.currentTimeMillis() - this.f);
        d(str);
    }

    @Override // sg.bigo.ads.common.form.b.a
    public final void a(Map<String, Object> map) {
        sg.bigo.ads.common.form.a.a(this.k, map);
    }

    @Override // sg.bigo.ads.common.form.render.c.a
    public final void b() {
        a(5, this.g, System.currentTimeMillis() - this.f);
    }

    @Override // sg.bigo.ads.common.form.render.c.a
    public final void b(int i) {
        if (this.j.get() != null) {
            this.j.get().a();
        }
        sg.bigo.ads.common.form.b.a().a(sg.bigo.ads.common.form.a.a(this.b, this.c.b(), this.c.a()), this, i);
    }

    @Override // sg.bigo.ads.common.form.render.c.a
    public final void b(String str) {
        a(10, this.g, System.currentTimeMillis() - this.f);
        d(str);
    }

    @Override // sg.bigo.ads.common.form.render.c.a
    public final void c() {
        a(6, this.g, System.currentTimeMillis() - this.f);
    }

    @Override // sg.bigo.ads.common.form.render.c.a
    public final void c(String str) {
        a(9, this.g, System.currentTimeMillis() - this.f);
        d(str);
    }
}
