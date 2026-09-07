package sg.bigo.ads.common.form.render.a;

import android.content.Context;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import java.util.Map;
import sg.bigo.ads.R;
import sg.bigo.ads.api.a.e;
import sg.bigo.ads.common.utils.q;

/* JADX INFO: loaded from: classes5.dex */
public final class b extends a {
    public b(e.c cVar, Map<String, Object> map, Context context, a.InterfaceC0864a interfaceC0864a) {
        super(cVar, map, context, interfaceC0864a);
    }

    @Override // sg.bigo.ads.common.form.render.a.a
    public final View b() {
        this.i = sg.bigo.ads.common.utils.a.a(this.h, sg.bigo.ads.common.form.render.a.a(2), null, false);
        if (this.i == null) {
            return null;
        }
        a((TextView) this.i.findViewById(R.id.inter_form_edit_title), this.d);
        a(1);
        final EditText editText = (EditText) this.i.findViewById(R.id.inter_form_edit_content);
        String strA = sg.bigo.ads.common.form.a.a(this.e, this.b);
        if (editText != null) {
            editText.setTextColor(sg.bigo.ads.common.form.render.a.b());
            editText.setHint(sg.bigo.ads.common.form.a.a(this.h, R.string.bigo_ad_form_question_hint));
            if (!q.a((CharSequence) strA)) {
                if (this.j != null) {
                    this.j.a(this.f13162a.d, strA);
                }
                this.c = strA;
                editText.setText(strA);
            }
            editText.addTextChangedListener(new TextWatcher() { // from class: sg.bigo.ads.common.form.render.a.b.1
                @Override // android.text.TextWatcher
                public final void afterTextChanged(Editable editable) {
                    b.this.c = editText.getText().toString();
                    if (b.this.j != null) {
                        b.this.j.a(b.this.f13162a.d, b.this.c);
                    }
                }

                @Override // android.text.TextWatcher
                public final void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                }

                @Override // android.text.TextWatcher
                public final void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                }
            });
            editText.setOnFocusChangeListener(new View.OnFocusChangeListener() { // from class: sg.bigo.ads.common.form.render.a.b.2
                @Override // android.view.View.OnFocusChangeListener
                public final void onFocusChange(View view, boolean z) {
                    b bVar = b.this;
                    if (z) {
                        bVar.a(2);
                    } else {
                        bVar.a();
                    }
                }
            });
        }
        return this.i;
    }
}
