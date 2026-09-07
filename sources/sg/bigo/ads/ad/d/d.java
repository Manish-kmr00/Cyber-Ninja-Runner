package sg.bigo.ads.ad.d;

import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import sg.bigo.ads.R;
import sg.bigo.ads.common.utils.n;
import sg.bigo.ads.common.utils.q;

/* JADX INFO: loaded from: classes5.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public TextView f12587a;
    public TextView b;
    public ViewGroup c;
    public f.a d;
    public n e;
    boolean f;

    public final void a() {
        n nVar = this.e;
        if (nVar != null) {
            nVar.b();
            this.f = false;
        }
    }

    public final void a(ViewGroup viewGroup, int i, f.a aVar) {
        if (viewGroup == null) {
            return;
        }
        this.f = false;
        this.d = aVar;
        this.c = (ViewGroup) viewGroup.findViewById(R.id.inter_popup_close_btn);
        this.f12587a = (TextView) viewGroup.findViewById(R.id.close_text);
        TextView textView = (TextView) viewGroup.findViewById(R.id.second_text);
        this.b = textView;
        ViewGroup viewGroup2 = this.c;
        if (viewGroup2 == null || this.f12587a == null || textView == null) {
            f.a aVar2 = this.d;
            if (aVar2 != null) {
                aVar2.d_();
                return;
            }
            return;
        }
        viewGroup2.setOnClickListener(new View.OnClickListener() { // from class: sg.bigo.ads.ad.d.d.1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                if (d.this.d != null) {
                    d.this.d.d_();
                }
            }
        });
        this.c.setClickable(false);
        this.f12587a.setTextColor(1728053247);
        this.b.setVisibility(0);
        n nVar = new n(((long) i) * 1000) { // from class: sg.bigo.ads.ad.d.d.2
            @Override // sg.bigo.ads.common.utils.n
            public final void a() {
                d.this.f = true;
                d.this.c.setAlpha(1.0f);
                d.this.c.setClickable(true);
                d.this.b.setVisibility(8);
                d.this.f12587a.setTextColor(-1);
            }

            @Override // sg.bigo.ads.common.utils.n
            public final void a(long j) {
                d.this.b.setText(q.a("%ds", Integer.valueOf(Math.round(j / 1000.0f))));
            }
        };
        this.e = nVar;
        nVar.c();
    }
}
