package sg.bigo.ads.core.mraid.a;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.view.Gravity;
import android.view.MotionEvent;
import android.view.ViewConfiguration;
import android.widget.FrameLayout;
import sg.bigo.ads.R;
import sg.bigo.ads.common.utils.e;

/* JADX INFO: loaded from: classes8.dex */
public final class a extends FrameLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Drawable f13629a;
    private final int b;
    private b c;
    private EnumC0898a d;
    private final int e;
    private final int f;
    private final int g;
    private boolean h;
    private final Rect i;
    private final Rect j;
    private final Rect k;
    private final Rect l;
    private boolean m;
    private c n;

    /* JADX INFO: renamed from: sg.bigo.ads.core.mraid.a.a$a, reason: collision with other inner class name */
    public enum EnumC0898a {
        TOP_LEFT(51),
        TOP_CENTER(49),
        TOP_RIGHT(53),
        CENTER(17),
        BOTTOM_LEFT(83),
        BOTTOM_CENTER(81),
        BOTTOM_RIGHT(85);

        final int h;

        EnumC0898a(int i2) {
            this.h = i2;
        }
    }

    public interface b {
        void a();
    }

    final class c implements Runnable {
        private c() {
        }

        /* synthetic */ c(a aVar, byte b) {
            this();
        }

        @Override // java.lang.Runnable
        public final void run() {
            a.this.setClosePressed(false);
        }
    }

    public a(Context context) {
        this(context, (byte) 0);
    }

    private a(Context context, byte b2) {
        super(context, null, 0);
        this.i = new Rect();
        this.j = new Rect();
        this.k = new Rect();
        this.l = new Rect();
        Drawable drawableA = sg.bigo.ads.common.utils.a.a(context, R.drawable.bigo_ad_ic_close);
        this.f13629a = drawableA;
        this.d = EnumC0898a.TOP_RIGHT;
        drawableA.setState(EMPTY_STATE_SET);
        drawableA.setCallback(this);
        this.b = ViewConfiguration.get(context).getScaledTouchSlop();
        this.e = e.a(context, 50);
        this.f = e.a(context, 30);
        this.g = e.a(context, 8);
        setWillNotDraw(false);
        this.m = true;
    }

    private static void a(EnumC0898a enumC0898a, int i, Rect rect, Rect rect2) {
        Gravity.apply(enumC0898a.h, i, i, rect, rect2);
    }

    private boolean a() {
        return this.f13629a.getState() == SELECTED_STATE_SET;
    }

    private boolean a(int i, int i2, int i3) {
        return i >= this.j.left - i3 && i2 >= this.j.top - i3 && i < this.j.right + i3 && i2 < this.j.bottom + i3;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setClosePressed(boolean z) {
        if (z == a()) {
            return;
        }
        this.f13629a.setState(z ? SELECTED_STATE_SET : EMPTY_STATE_SET);
        invalidate(this.j);
    }

    public final void a(EnumC0898a enumC0898a, Rect rect, Rect rect2) {
        a(enumC0898a, this.e, rect, rect2);
    }

    @Override // android.view.View
    public final void draw(Canvas canvas) {
        super.draw(canvas);
        if (this.h) {
            this.h = false;
            this.i.set(0, 0, getWidth(), getHeight());
            a(this.d, this.i, this.j);
            this.l.set(this.j);
            Rect rect = this.l;
            int i = this.g;
            rect.inset(i, i);
            a(this.d, this.f, this.l, this.k);
            this.f13629a.setBounds(this.k);
        }
        if (this.f13629a.isVisible()) {
            this.f13629a.draw(canvas);
        }
    }

    final Rect getCloseBounds() {
        return this.j;
    }

    @Override // android.view.ViewGroup
    public final boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        if (motionEvent.getAction() != 0) {
            return false;
        }
        return a((int) motionEvent.getX(), (int) motionEvent.getY(), 0);
    }

    @Override // android.view.View
    protected final void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        this.h = true;
    }

    @Override // android.view.View
    public final boolean onTouchEvent(MotionEvent motionEvent) {
        byte b2 = 0;
        if (!a((int) motionEvent.getX(), (int) motionEvent.getY(), this.b) || (!this.m && !this.f13629a.isVisible())) {
            setClosePressed(false);
            super.onTouchEvent(motionEvent);
            return false;
        }
        int action = motionEvent.getAction();
        if (action == 0) {
            setClosePressed(true);
        } else if (action != 1) {
            if (action == 3) {
                setClosePressed(false);
            }
        } else if (a()) {
            if (this.n == null) {
                this.n = new c(this, b2);
            }
            postDelayed(this.n, ViewConfiguration.getPressedStateDuration());
            playSoundEffect(0);
            b bVar = this.c;
            if (bVar != null) {
                bVar.a();
            }
        }
        return true;
    }

    public final void setCloseAlwaysInteractable(boolean z) {
        this.m = z;
    }

    final void setCloseBoundChanged(boolean z) {
        this.h = z;
    }

    final void setCloseBounds(Rect rect) {
        this.j.set(rect);
    }

    public final void setClosePosition(EnumC0898a enumC0898a) {
        this.d = enumC0898a;
        this.h = true;
        invalidate();
    }

    public final void setCloseVisible(boolean z) {
        if (this.f13629a.setVisible(z, false)) {
            invalidate(this.j);
        }
    }

    public final void setOnCloseListener(b bVar) {
        this.c = bVar;
    }
}
