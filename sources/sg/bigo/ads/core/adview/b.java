package sg.bigo.ads.core.adview;

import android.app.Activity;
import android.text.TextUtils;
import android.view.View;
import android.widget.FrameLayout;
import sg.bigo.ads.common.utils.q;
import sg.bigo.ads.common.view.AdImageView;
import sg.bigo.ads.core.adview.e.b;

/* JADX INFO: loaded from: classes7.dex */
public final class b extends c {
    public b(sg.bigo.ads.api.a<?> aVar) {
        super(aVar);
    }

    public final void a(sg.bigo.ads.api.core.c cVar, final String str) {
        if (cVar == null) {
            return;
        }
        this.f13501a.removeAllViews();
        sg.bigo.ads.api.core.c.e eVarB = cVar.B();
        AdImageView adImageView = new AdImageView(this.f13501a.getContext());
        adImageView.setIconTag(true);
        String strA = eVarB != null ? eVarB.a() : "";
        final String strB = eVarB != null ? eVarB.b() : "";
        final String strD = eVarB != null ? eVarB.d() : "";
        final String strE = eVarB != null ? eVarB.e() : "";
        final String strG = eVarB != null ? eVarB.g() : "";
        final String strH = eVarB != null ? eVarB.h() : "";
        adImageView.setOnClickListener(new View.OnClickListener() { // from class: sg.bigo.ads.core.adview.b.1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                String str2;
                sg.bigo.ads.api.a<?> aVar = b.this.f13501a;
                String str3 = strB;
                String str4 = str;
                String str5 = strD;
                String str6 = strE;
                String str7 = strG;
                String str8 = strH;
                if (TextUtils.isEmpty(str3) && TextUtils.isEmpty(str5) && TextUtils.isEmpty(str6) && TextUtils.isEmpty(str4) && TextUtils.isEmpty(str7) && TextUtils.isEmpty(str8)) {
                    return;
                }
                e.a aVar2 = new e.a(aVar);
                aVar2.b = str3;
                aVar2.c = str4;
                aVar2.d = str5;
                aVar2.e = str6;
                aVar2.f = str7;
                aVar2.g = str8;
                e eVar = new e(aVar2, (byte) 0);
                Activity activityA = sg.bigo.ads.common.utils.c.a(eVar.f13502a.f13503a);
                if (activityA == null) {
                    str2 = "Cannot find Activity from container view";
                } else {
                    if (!e.b) {
                        e.b bVar = eVar.new b(activityA);
                        if (q.a((CharSequence) eVar.f13502a.b) && q.a((CharSequence) eVar.f13502a.c) && q.a((CharSequence) eVar.f13502a.d) && q.a((CharSequence) eVar.f13502a.e) && q.a((CharSequence) eVar.f13502a.f) && q.a((CharSequence) eVar.f13502a.g)) {
                            return;
                        }
                        bVar.show();
                        e.b = true;
                        return;
                    }
                    str2 = "Feedback dialog is showing. Cannot show again.";
                }
                sg.bigo.ads.common.t.a.b("Feedback", str2);
            }
        });
        if (TextUtils.isEmpty(strA)) {
            this.f13501a.setVisibility(8);
            return;
        }
        adImageView.a(strA, cVar.al());
        adImageView.setLayoutParams(new FrameLayout.LayoutParams(sg.bigo.ads.common.utils.e.a(this.f13501a.getContext(), 16), sg.bigo.ads.common.utils.e.a(this.f13501a.getContext(), 16), 17));
        adImageView.setTag("ad_options_real_view");
        a(adImageView);
    }
}
