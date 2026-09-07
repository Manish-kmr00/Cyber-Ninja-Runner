package sg.bigo.ads.core.player.b;

import android.content.Context;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import sg.bigo.ads.R;
import sg.bigo.ads.common.utils.u;

/* JADX INFO: loaded from: classes9.dex */
public abstract class f extends FrameLayout implements sg.bigo.ads.api.c.a, a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private ImageView f13710a;
    protected sg.bigo.ads.core.g.c b;
    protected Context c;
    protected final sg.bigo.ads.api.c.b d;
    protected final sg.bigo.ads.core.a.a e;
    boolean f;
    private ImageView g;
    private final View.OnClickListener h;
    private final Runnable i;
    private boolean j;

    public f(Context context, sg.bigo.ads.api.c.b bVar, sg.bigo.ads.core.a.a aVar) {
        super(context);
        View.OnClickListener onClickListener = new View.OnClickListener() { // from class: sg.bigo.ads.core.player.b.f.1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                if (view == f.this.f13710a) {
                    f.this.o();
                    return;
                }
                f fVar = f.this;
                if (view == fVar) {
                    fVar.p();
                }
            }
        };
        this.h = onClickListener;
        this.i = new Runnable() { // from class: sg.bigo.ads.core.player.b.f.2
            @Override // java.lang.Runnable
            public final void run() {
                f.this.setPlayOrPauseViewHidden(true);
            }
        };
        this.f = false;
        this.j = true;
        this.c = context;
        this.d = bVar;
        this.e = aVar;
        if (!bVar.c) {
            int iB = sg.bigo.ads.common.utils.a.b(this.c, R.dimen.bigo_ad_volume_padding);
            ImageView imageView = new ImageView(this.c);
            this.f13710a = imageView;
            imageView.setOnClickListener(onClickListener);
            this.f13710a.setPadding(iB, iB, iB, iB);
            int iB2 = sg.bigo.ads.common.utils.a.b(this.c, R.dimen.bigo_ad_volume_size) + (iB * 2);
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(iB2, iB2, 85);
            layoutParams.rightMargin = iB;
            layoutParams.bottomMargin = iB;
            this.f13710a.setVisibility(0);
            u.a(this.f13710a, this, layoutParams, -1);
        }
        int iB3 = sg.bigo.ads.common.utils.a.b(this.c, R.dimen.bigo_ad_replay_size);
        if (aVar != null && aVar.x() == 2 && sg.bigo.ads.api.c.b.b() > 0) {
            iB3 = sg.bigo.ads.common.utils.e.a(this.c, sg.bigo.ads.api.c.b.b());
        }
        ImageView imageView2 = new ImageView(this.c);
        this.g = imageView2;
        imageView2.setImageDrawable(sg.bigo.ads.common.utils.a.a(this.c, R.drawable.bigo_ad_ic_media_play));
        u.a(this.g, this, new FrameLayout.LayoutParams(iB3, iB3, 17), -1);
        setOnClickListener(onClickListener);
    }

    public final void a(String str, Object obj, int[] iArr) {
        sg.bigo.ads.core.g.c cVar = this.b;
        if (cVar != null) {
            cVar.a(str, obj, iArr);
        }
    }

    public final void a(String str, int[] iArr) {
        sg.bigo.ads.core.g.c cVar = this.b;
        if (cVar != null) {
            cVar.a(str, iArr);
        }
    }

    protected void a(boolean z) {
        this.f = false;
    }

    protected final void b(int i) {
        sg.bigo.ads.core.a.a aVar = this.e;
        if (aVar != null) {
            sg.bigo.ads.core.d.b.a(aVar, i, aVar.aJ(), this.e.aL());
        }
    }

    protected final void b(boolean z) {
        ImageView imageView = this.f13710a;
        if (imageView != null) {
            imageView.setImageDrawable(sg.bigo.ads.common.utils.a.a(this.c, z ? R.drawable.bigo_ad_ic_media_mute : R.drawable.bigo_ad_ic_media_unmute));
        }
    }

    protected final void c(boolean z) {
        ImageView imageView = this.g;
        if (imageView != null) {
            imageView.setImageDrawable(sg.bigo.ads.common.utils.a.a(this.c, z ? R.drawable.bigo_ad_ic_media_play : R.drawable.bigo_ad_ic_media_pause));
        }
    }

    protected final void d(boolean z) {
        if (z) {
            sg.bigo.ads.core.player.d.a.f13717a.a(this);
        } else {
            sg.bigo.ads.core.player.d.a.f13717a.b(this);
        }
    }

    public final void e(boolean z) {
        if (this.f) {
            b(9);
        }
        a(z);
    }

    protected boolean e() {
        return false;
    }

    protected boolean n() {
        return this.j;
    }

    protected final void o() {
        setMute(!c());
    }

    protected final void p() {
        t();
    }

    public final void q() {
        if (r()) {
            a();
        }
    }

    public final boolean r() {
        return getPlayStatus() == 2;
    }

    public final void s() {
        this.f = true;
        a();
        b(8);
    }

    public void setOnEventListener(sg.bigo.ads.core.g.c cVar) {
        this.b = cVar;
    }

    protected void setPlayOrPauseViewHidden(boolean z) {
        ImageView imageView = this.g;
        if (imageView != null) {
            imageView.setVisibility(z ? 8 : 0);
        }
    }

    protected void setStatPrepareEventOnce(boolean z) {
        this.j = z;
    }

    protected void setVolumeViewHidden(boolean z) {
        ImageView imageView = this.f13710a;
        if (imageView != null) {
            imageView.setVisibility(z ? 4 : 0);
        }
    }

    public final void t() {
        if (e()) {
            if (r()) {
                removeCallbacks(this.i);
                s();
                setPlayOrPauseViewHidden(false);
                c(true);
                return;
            }
            removeCallbacks(this.i);
            e(false);
            this.g.setVisibility(0);
            setPlayOrPauseViewHidden(false);
            c(false);
            postDelayed(this.i, 1500L);
        }
    }
}
