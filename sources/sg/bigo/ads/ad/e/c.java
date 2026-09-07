package sg.bigo.ads.ad.e;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import sg.bigo.ads.R;

/* JADX INFO: loaded from: classes8.dex */
final class c extends Dialog {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private a f12599a;

    interface a {
        void a();

        void b();

        void c();

        void d();
    }

    public c(Context context) {
        super(context, R.style.BigoAd_Dialog_Fullscreen);
        setCanceledOnTouchOutside(true);
    }

    public final void a(a aVar) {
        this.f12599a = aVar;
        getWindow().setFlags(8, 8);
        super.show();
        getWindow().getDecorView().setSystemUiVisibility(5894);
        getWindow().clearFlags(8);
    }

    @Override // android.app.Dialog
    protected final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        View viewA = sg.bigo.ads.common.utils.a.a(getContext(), R.layout.bigo_ad_dialog_reward_retain, null, false);
        setContentView(viewA);
        viewA.setOnClickListener(new View.OnClickListener() { // from class: sg.bigo.ads.ad.e.c.1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                c.this.dismiss();
            }
        });
        viewA.findViewById(R.id.bigo_ad_btn_resume).setOnClickListener(new View.OnClickListener() { // from class: sg.bigo.ads.ad.e.c.2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                if (c.this.f12599a != null) {
                    c.this.f12599a.d();
                }
                c.this.dismiss();
            }
        });
        viewA.findViewById(R.id.bigo_ad_btn_skip).setOnClickListener(new View.OnClickListener() { // from class: sg.bigo.ads.ad.e.c.3
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                if (c.this.f12599a != null) {
                    c.this.f12599a.c();
                }
                c.this.dismiss();
            }
        });
    }

    @Override // android.app.Dialog
    protected final void onStart() {
        super.onStart();
        a aVar = this.f12599a;
        if (aVar != null) {
            aVar.a();
        }
    }

    @Override // android.app.Dialog
    protected final void onStop() {
        super.onStop();
        a aVar = this.f12599a;
        if (aVar != null) {
            aVar.b();
            this.f12599a = null;
        }
    }
}
