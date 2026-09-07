package sg.bigo.ads.ad.interstitial;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.google.android.material.timepicker.TimeModel;
import sg.bigo.ads.R;

/* JADX INFO: loaded from: classes6.dex */
public class AdCountDownButton extends FrameLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    protected final Context f12606a;
    sg.bigo.ads.common.utils.n b;
    public boolean c;
    boolean d;
    public boolean e;
    public View f;
    public View g;
    public TextView h;
    private boolean i;
    private boolean j;

    public interface a {
        void a();
    }

    public interface b {
        void a();
    }

    public AdCountDownButton(Context context) {
        this(context, null);
    }

    public AdCountDownButton(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public AdCountDownButton(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.c = true;
        this.i = false;
        this.j = false;
        this.e = false;
        this.f12606a = context;
        setClickable(true);
        TypedArray typedArrayObtainStyledAttributes = null;
        try {
            typedArrayObtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, R.styleable.AdCountDownButton);
            int resourceId = typedArrayObtainStyledAttributes.getResourceId(R.styleable.AdCountDownButton_bigo_ad_customLayout, 0);
            if (typedArrayObtainStyledAttributes != null) {
                typedArrayObtainStyledAttributes.recycle();
            }
            sg.bigo.ads.common.utils.a.a(context, resourceId, this, true);
            this.f = findViewById(R.id.bigo_ad_btn_close);
            this.g = findViewById(R.id.inter_view_stroke);
            this.h = (TextView) findViewById(R.id.inter_text_countdown);
        } catch (Throwable th) {
            if (typedArrayObtainStyledAttributes != null) {
                typedArrayObtainStyledAttributes.recycle();
            }
            throw th;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(long j) {
        if (this.e) {
            this.h.setText(sg.bigo.ads.common.utils.q.a(sg.bigo.ads.common.utils.a.a(this.f12606a, R.string.bigo_ad_splash_skip_after, new Object[0]) + " %d" + (this.j ? "s" : ""), Integer.valueOf(Math.round(j / 1000.0f))));
        } else {
            this.h.setText(sg.bigo.ads.common.utils.q.a(TimeModel.NUMBER_FORMAT.concat(this.j ? "s" : ""), Integer.valueOf(Math.round(j / 1000.0f))));
        }
    }

    static /* synthetic */ boolean b(AdCountDownButton adCountDownButton) {
        adCountDownButton.c = true;
        return true;
    }

    private void f() {
        this.f.setVisibility(0);
        this.f.setClickable(true);
        this.f.setAlpha(1.0f);
    }

    public final void a(int i) {
        removeAllViews();
        sg.bigo.ads.common.utils.a.a(this.f12606a, i, this, true);
        this.f = findViewById(R.id.bigo_ad_btn_close);
        this.g = findViewById(R.id.inter_view_stroke);
        this.h = (TextView) findViewById(R.id.inter_text_countdown);
    }

    public final void a(int i, final b bVar) {
        this.h.setVisibility(0);
        this.g.setVisibility(8);
        this.f.setVisibility(8);
        if (this.i) {
            this.g.setVisibility(0);
            e();
        }
        if (i == 0) {
            a(this.d);
            if (bVar != null) {
                bVar.a();
                return;
            }
            return;
        }
        this.c = false;
        if (i < 0) {
            return;
        }
        sg.bigo.ads.common.utils.n nVar = new sg.bigo.ads.common.utils.n(((long) i) * 1000) { // from class: sg.bigo.ads.ad.interstitial.AdCountDownButton.2
            @Override // sg.bigo.ads.common.utils.n
            public final void a() {
                AdCountDownButton adCountDownButton = AdCountDownButton.this;
                adCountDownButton.a(adCountDownButton.d);
                b bVar2 = bVar;
                if (bVar2 != null) {
                    bVar2.a();
                }
                AdCountDownButton.b(AdCountDownButton.this);
            }

            @Override // sg.bigo.ads.common.utils.n
            public final void a(long j) {
                if (AdCountDownButton.this.d) {
                    return;
                }
                AdCountDownButton.this.b(j);
            }
        };
        this.b = nVar;
        nVar.c();
    }

    public final void a(long j) {
        if (this.d) {
            b(j);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void a(boolean z) {
        View view;
        View view2;
        f();
        int i = 8;
        if (!this.e) {
            this.h.setVisibility(z ? 0 : 8);
            view = this.g;
            if (z) {
                i = 0;
            } else {
                view2 = view;
            }
            view.setVisibility(i);
        }
        this.h.setVisibility(8);
        view2 = this.g;
        view = view2;
        view.setVisibility(i);
    }

    public final boolean a() {
        View view = this.f;
        return view != null && view.performClick();
    }

    public final void b() {
        sg.bigo.ads.common.utils.n nVar = this.b;
        if (nVar != null) {
            nVar.d();
        }
    }

    public final void c() {
        sg.bigo.ads.common.utils.n nVar = this.b;
        if (nVar == null || !nVar.e()) {
            return;
        }
        this.b.c();
    }

    public final void d() {
        sg.bigo.ads.common.utils.n nVar = this.b;
        if (nVar != null) {
            nVar.b();
        }
        this.c = true;
        a(false);
    }

    public final void e() {
        this.f.setVisibility(0);
        this.f.setAlpha(0.2f);
        this.f.setClickable(false);
    }

    public void setCloseImageResource(int i) {
        View view = this.f;
        if (view instanceof ImageView) {
            ((ImageView) view).setImageResource(i);
        }
    }

    public void setOnCloseListener(final a aVar) {
        View view = this.f;
        if (view == null) {
            return;
        }
        if (aVar == null) {
            view.setOnClickListener(null);
        } else {
            view.setOnClickListener(new View.OnClickListener() { // from class: sg.bigo.ads.ad.interstitial.AdCountDownButton.1
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    aVar.a();
                }
            });
        }
    }

    public void setShowCloseButtonInCountdown(boolean z) {
        this.i = z;
        TextView textView = this.h;
        if (textView == null) {
            return;
        }
        if (z) {
            textView.setPadding(sg.bigo.ads.common.utils.e.a(getContext(), 2), 0, 0, 0);
        } else {
            textView.setPadding(0, 0, 0, 0);
        }
    }

    public void setTakeoverTickEvent(boolean z) {
        this.d = z;
    }

    public void setWithUnit(boolean z) {
        this.j = z;
    }
}
