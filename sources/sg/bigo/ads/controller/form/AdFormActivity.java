package sg.bigo.ads.controller.form;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.Window;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.FrameLayout;
import com.google.common.base.Ascii;
import com.mbridge.msdk.foundation.download.core.DownloadCommon;
import java.util.Locale;
import java.util.Map;
import sg.bigo.ads.R;
import sg.bigo.ads.ad.c;
import sg.bigo.ads.api.a.e;
import sg.bigo.ads.common.form.a;
import sg.bigo.ads.common.form.render.b;
import sg.bigo.ads.common.utils.q;
import sg.bigo.ads.common.utils.s;
import sg.bigo.ads.common.utils.u;
import sg.bigo.ads.controller.landing.d;

/* JADX INFO: loaded from: classes4.dex */
public class AdFormActivity extends Activity implements b.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private c<?, ?> f13465a;
    private int b;
    private int c;
    private boolean d;
    private int e;
    private Map<String, Object> f;
    private sg.bigo.ads.common.form.c g;

    public static Intent a(Context context) {
        Intent intent = new Intent(context, (Class<?>) AdFormActivity.class);
        if (!(context instanceof Activity)) {
            intent.addFlags(268435456);
        }
        return intent;
    }

    @Override // sg.bigo.ads.common.form.render.b.a
    public final void a() {
        this.d = true;
        c<?, ?> cVar = this.f13465a;
        if (cVar != null) {
            cVar.i = true;
        }
    }

    @Override // sg.bigo.ads.common.form.render.b.a
    public final void a(String str) {
        if (q.a((CharSequence) str)) {
            return;
        }
        d.a(this, str, this.f13465a);
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        if (motionEvent.getAction() == 0) {
            View currentFocus = getCurrentFocus();
            if ((currentFocus instanceof EditText) && !u.a(currentFocus, (int) motionEvent.getX(), (int) motionEvent.getY())) {
                currentFocus.clearFocus();
                try {
                    ((InputMethodManager) getSystemService("input_method")).hideSoftInputFromWindow(getWindow().getDecorView().getWindowToken(), 0);
                } catch (Throwable unused) {
                }
            }
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    @Override // android.app.Activity
    public void onBackPressed() {
        if (this.d) {
            super.onBackPressed();
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code duplicated, block: B:72:0x0141  */
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    @Override // android.app.Activity
    protected final void onCreate(Bundle bundle) {
        sg.bigo.ads.api.core.c cVar;
        c<?, ?> cVar2;
        byte b;
        Locale locale;
        super.onCreate(bundle);
        try {
            this.b = getIntent().getIntExtra("ad_identifier", -1);
            this.e = getIntent().getIntExtra("open_form_time", 0);
            c<?, ?> cVarB = d.b(this.b);
            this.f13465a = cVarB;
            if (cVarB == null) {
                finish();
                return;
            }
            int iHashCode = cVarB.f().hashCode();
            this.c = iHashCode;
            this.f = a.a(iHashCode);
            setContentView(R.layout.bigo_ad_activity_form);
            Window window = getWindow();
            if (window != null) {
                s.a(window);
            }
            View viewFindViewById = findViewById(R.id.bigo_ad_btn_close);
            if (viewFindViewById != null) {
                viewFindViewById.setOnClickListener(new View.OnClickListener() { // from class: sg.bigo.ads.controller.form.AdFormActivity.1
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        AdFormActivity.this.finish();
                    }
                });
            }
            FrameLayout frameLayout = (FrameLayout) findViewById(R.id.inter_main);
            if (frameLayout == null || (cVar2 = this.f13465a) == null) {
                return;
            }
            e eVarF = cVar2.f().f();
            String strE = eVarF.e();
            a.f13155a = strE;
            switch (strE.hashCode()) {
                case 3121:
                    if (!strE.equals("ar")) {
                        b = -1;
                    } else {
                        b = 0;
                    }
                    break;
                case 3201:
                    if (!strE.equals(DownloadCommon.DOWNLOAD_REPORT_DOWNLOAD_ERROR)) {
                        b = -1;
                    } else {
                        b = Ascii.CR;
                    }
                    break;
                case 3246:
                    if (!strE.equals("es")) {
                        b = -1;
                    } else {
                        b = 1;
                    }
                    break;
                case 3259:
                    if (!strE.equals("fa")) {
                        b = -1;
                    } else {
                        b = 2;
                    }
                    break;
                case 3276:
                    if (!strE.equals("fr")) {
                        b = -1;
                    } else {
                        b = Ascii.DLE;
                    }
                    break;
                case 3325:
                    if (!strE.equals("he")) {
                        b = -1;
                    } else {
                        b = 3;
                    }
                    break;
                case 3329:
                    if (!strE.equals("hi")) {
                        b = -1;
                    } else {
                        b = 4;
                    }
                    break;
                case 3355:
                    if (!strE.equals("id")) {
                        b = -1;
                    } else {
                        b = 5;
                    }
                    break;
                case 3383:
                    if (!strE.equals("ja")) {
                        b = -1;
                    } else {
                        b = Ascii.SO;
                    }
                    break;
                case 3428:
                    if (!strE.equals("ko")) {
                        b = -1;
                    } else {
                        b = Ascii.SI;
                    }
                    break;
                case 3494:
                    if (!strE.equals("ms")) {
                        b = -1;
                    } else {
                        b = 6;
                    }
                    break;
                case 3588:
                    if (!strE.equals("pt")) {
                        b = -1;
                    } else {
                        b = 7;
                    }
                    break;
                case 3651:
                    if (!strE.equals("ru")) {
                        b = -1;
                    } else {
                        b = 8;
                    }
                    break;
                case 3700:
                    if (!strE.equals("th")) {
                        b = -1;
                    } else {
                        b = 10;
                    }
                    break;
                case 3710:
                    if (!strE.equals("tr")) {
                        b = -1;
                    } else {
                        b = 9;
                    }
                    break;
                case 3749:
                    if (!strE.equals("uz")) {
                        b = -1;
                    } else {
                        b = Ascii.VT;
                    }
                    break;
                case 3763:
                    if (!strE.equals("vi")) {
                        b = -1;
                    } else {
                        b = Ascii.FF;
                    }
                    break;
                default:
                    b = -1;
                    break;
            }
            switch (b) {
                case 0:
                    locale = new Locale("ar", "");
                    break;
                case 1:
                    locale = new Locale("es", "");
                    break;
                case 2:
                    locale = new Locale("fa", "");
                    break;
                case 3:
                    locale = new Locale("he", "");
                    break;
                case 4:
                    locale = new Locale("hi", "");
                    break;
                case 5:
                    locale = new Locale("id", "");
                    break;
                case 6:
                    locale = new Locale("ms", "");
                    break;
                case 7:
                    locale = new Locale("pt", "");
                    break;
                case 8:
                    locale = new Locale("ru", "");
                    break;
                case 9:
                    locale = new Locale("tr", "");
                    break;
                case 10:
                    locale = new Locale("th", "");
                    break;
                case 11:
                    locale = new Locale("uz", "");
                    break;
                case 12:
                    locale = new Locale("vi", "");
                    break;
                case 13:
                    locale = Locale.GERMAN;
                    break;
                case 14:
                    locale = Locale.JAPANESE;
                    break;
                case 15:
                    locale = Locale.KOREAN;
                    break;
                case 16:
                    locale = Locale.FRENCH;
                    break;
                default:
                    locale = Locale.ENGLISH;
                    break;
            }
            a.b = locale;
            boolean z = this.f13465a.i;
            this.d = z;
            sg.bigo.ads.common.form.c cVarA = sg.bigo.ads.common.form.c.a(this, eVarF, this.f, z, this.e, this.c, this);
            this.g = cVarA;
            cVar = null;
            try {
                u.a(cVarA.b, frameLayout, null, -1);
                this.g.c.c();
            } catch (Throwable th) {
                th = th;
                c<?, ?> cVar3 = this.f13465a;
                sg.bigo.ads.core.d.b.a(cVar3 != null ? cVar3.f() : cVar, 3000, 10221, Log.getStackTraceString(th));
                finish();
            }
        } catch (Throwable th2) {
            th = th2;
            cVar = null;
        }
    }

    @Override // android.app.Activity
    public void onDestroy() {
        sg.bigo.ads.common.form.c cVar;
        super.onDestroy();
        try {
            if (this.f13465a != null && (cVar = this.g) != null && cVar.f13159a != null) {
                b bVar = this.g.f13159a;
                Map<String, Object> mapA = a.a(bVar.b, bVar.c.b(), bVar.c.a());
                boolean z = this.d;
                if (!z) {
                    a.a(this.c, mapA);
                } else if (z) {
                    a.a(this.c, 3);
                }
            }
        } catch (Throwable unused) {
        }
    }
}
