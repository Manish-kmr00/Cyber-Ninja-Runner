package sg.bigo.ads.common.form.render.a;

import android.content.Context;
import android.graphics.drawable.GradientDrawable;
import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;
import java.util.Map;
import sg.bigo.ads.R;
import sg.bigo.ads.api.a.e;
import sg.bigo.ads.common.utils.q;

/* JADX INFO: loaded from: classes5.dex */
public abstract class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    protected e.c f13162a;
    protected Map<String, Object> b;
    protected String c;
    protected String d;
    protected String e;
    protected int f;
    protected String[] g;
    protected Context h;
    protected View i;
    protected InterfaceC0864a j;

    /* JADX INFO: renamed from: sg.bigo.ads.common.form.render.a.a$a, reason: collision with other inner class name */
    public interface InterfaceC0864a {
        void a(String str, String str2);
    }

    protected a(e.c cVar, Map<String, Object> map, Context context, InterfaceC0864a interfaceC0864a) {
        this.h = context;
        this.f13162a = cVar;
        this.b = map;
        this.d = cVar.f13092a;
        this.e = this.f13162a.d;
        this.f = this.f13162a.b;
        this.g = this.f13162a.c;
        this.j = interfaceC0864a;
    }

    protected static void a(TextView textView, String str) {
        if (TextUtils.isEmpty(str) || textView == null) {
            return;
        }
        textView.setText(str);
    }

    public void a(int i) {
        int iA = sg.bigo.ads.common.form.render.a.a();
        int iB = sg.bigo.ads.common.form.render.a.b();
        boolean z = false;
        if (i != 2) {
            if (i == 3) {
                iA = -45718;
                z = true;
            }
            a(iA, iB, z);
        }
        iA = -16736769;
        iB = iA;
        a(iA, iB, z);
    }

    protected final void a(int i, int i2, boolean z) {
        View view = this.i;
        if (view == null) {
            return;
        }
        View viewFindViewById = view.findViewById(R.id.inter_form_edit_content);
        if (viewFindViewById != null) {
            GradientDrawable gradientDrawable = new GradientDrawable();
            gradientDrawable.setShape(0);
            gradientDrawable.setStroke(sg.bigo.ads.common.utils.e.a(this.h, 1), i);
            gradientDrawable.setCornerRadius(sg.bigo.ads.common.utils.e.a(this.h, 8));
            viewFindViewById.setBackground(gradientDrawable);
        }
        TextView textView = (TextView) this.i.findViewById(R.id.inter_form_edit_warning);
        if (textView != null) {
            textView.setText(sg.bigo.ads.common.form.a.a(this.h, R.string.bigo_ad_form_warning));
            textView.setVisibility(z ? 0 : 8);
        }
        TextView textView2 = (TextView) this.i.findViewById(R.id.inter_form_edit_title);
        if (textView2 != null) {
            textView2.setTextColor(i2);
        }
    }

    public final boolean a() {
        boolean zA = q.a((CharSequence) this.c);
        if (this.f13162a.b == 3) {
            zA = !q.g(this.c);
        }
        a(zA ? 3 : 1);
        return zA;
    }

    public abstract View b();

    public final View c() {
        return this.i;
    }
}
