package sg.bigo.ads.common.form.render.a;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.StateListDrawable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import java.util.Map;
import sg.bigo.ads.R;
import sg.bigo.ads.api.a.e;
import sg.bigo.ads.common.utils.q;
import sg.bigo.ads.common.utils.u;

/* JADX INFO: loaded from: classes4.dex */
public final class d extends a {
    public d(e.c cVar, Map<String, Object> map, Context context, a.InterfaceC0864a interfaceC0864a) {
        super(cVar, map, context, interfaceC0864a);
    }

    @Override // sg.bigo.ads.common.form.render.a.a
    public final void a(int i) {
        int iA = sg.bigo.ads.common.form.render.a.a();
        int iB = sg.bigo.ads.common.form.render.a.b();
        boolean z = false;
        if (i != 2 && i == 3) {
            iA = -45718;
            z = true;
            iB = -45718;
        }
        a(iA, iB, z);
    }

    @Override // sg.bigo.ads.common.form.render.a.a
    public final View b() {
        this.i = sg.bigo.ads.common.utils.a.a(this.h, sg.bigo.ads.common.form.render.a.a(6), null, false);
        if (this.i == null) {
            return null;
        }
        a((TextView) this.i.findViewById(R.id.inter_form_edit_title), this.d);
        a(1);
        final RadioGroup radioGroup = (RadioGroup) this.i.findViewById(R.id.inter_form_edit_content);
        if (radioGroup != null) {
            radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() { // from class: sg.bigo.ads.common.form.render.a.d.1
                @Override // android.widget.RadioGroup.OnCheckedChangeListener
                public final void onCheckedChanged(RadioGroup radioGroup2, int i) {
                    radioGroup.requestFocus();
                    RadioButton radioButton = (RadioButton) radioGroup2.findViewById(i);
                    d.this.a(2);
                    if (radioButton != null) {
                        radioButton.setTextColor(-16736769);
                        d.this.c = radioButton.getText().toString();
                        if (d.this.j != null) {
                            d.this.j.a(d.this.e, d.this.c);
                        }
                    }
                }
            });
            if (radioGroup != null && this.g.length != 0) {
                String strA = sg.bigo.ads.common.form.a.a(this.e, this.b);
                RadioButton radioButton = null;
                int i = 0;
                while (i < this.g.length) {
                    String str = this.g[i];
                    boolean z = i == 0;
                    RadioButton bVar = new sg.bigo.ads.common.view.b(this.h);
                    ViewGroup.MarginLayoutParams marginLayoutParams = new ViewGroup.MarginLayoutParams(-1, -2);
                    if (!z) {
                        marginLayoutParams.topMargin = sg.bigo.ads.common.utils.e.a(this.h, 8);
                    }
                    bVar.setLayoutParams(marginLayoutParams);
                    bVar.setPadding(sg.bigo.ads.common.utils.e.a(this.h, 12), sg.bigo.ads.common.utils.e.a(this.h, 10), sg.bigo.ads.common.utils.e.a(this.h, 12), sg.bigo.ads.common.utils.e.a(this.h, 11));
                    bVar.setTextSize(13.0f);
                    a(bVar, str);
                    bVar.setButtonDrawable((Drawable) null);
                    Context context = this.h;
                    StateListDrawable stateListDrawable = new StateListDrawable();
                    int i2 = sg.bigo.ads.common.form.render.a.f13161a ? -15524570 : -657158;
                    GradientDrawable gradientDrawable = new GradientDrawable();
                    gradientDrawable.setShape(0);
                    gradientDrawable.setColor(i2);
                    gradientDrawable.setCornerRadius(sg.bigo.ads.common.utils.e.a(context, 4));
                    GradientDrawable gradientDrawable2 = new GradientDrawable();
                    gradientDrawable2.setShape(0);
                    gradientDrawable2.setColor(i2);
                    gradientDrawable2.setCornerRadius(sg.bigo.ads.common.utils.e.a(context, 4));
                    gradientDrawable2.setStroke(1, -16736769);
                    stateListDrawable.addState(new int[]{-16842912}, gradientDrawable);
                    stateListDrawable.addState(new int[]{android.R.attr.state_checked}, gradientDrawable2);
                    bVar.setBackground(stateListDrawable);
                    bVar.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: sg.bigo.ads.common.form.render.a.d.2
                        @Override // android.widget.CompoundButton.OnCheckedChangeListener
                        public final void onCheckedChanged(CompoundButton compoundButton, boolean z2) {
                            compoundButton.setTextColor(z2 ? -16736769 : sg.bigo.ads.common.form.render.a.b());
                        }
                    });
                    bVar.setTextColor(sg.bigo.ads.common.form.render.a.b());
                    if (!q.a((CharSequence) strA) && strA.equalsIgnoreCase(this.g[i])) {
                        if (this.j != null) {
                            this.j.a(this.f13162a.d, strA);
                        }
                        this.c = strA;
                        radioButton = bVar;
                    }
                    u.a(bVar, radioGroup, null, -1);
                    i++;
                }
                if (radioButton != null) {
                    radioButton.setChecked(true);
                }
            }
        }
        return this.i;
    }
}
