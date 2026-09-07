package sg.bigo.ads.common.ac;

import android.content.Context;
import android.view.GestureDetector;
import android.view.MotionEvent;

/* JADX INFO: loaded from: classes9.dex */
public final class a extends GestureDetector {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public C0859a f13128a;
    private long b;

    /* JADX INFO: renamed from: sg.bigo.ads.common.ac.a$a, reason: collision with other inner class name */
    public static class C0859a extends GestureDetector.SimpleOnGestureListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public boolean f13129a = false;

        C0859a() {
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public final boolean onSingleTapUp(MotionEvent motionEvent) {
            this.f13129a = true;
            return super.onSingleTapUp(motionEvent);
        }
    }

    public a(Context context) {
        this(context, new C0859a());
    }

    private a(Context context, C0859a c0859a) {
        super(context, c0859a);
        this.b = -1L;
        this.f13128a = c0859a;
        setIsLongpressEnabled(false);
    }

    public final boolean a() {
        return System.currentTimeMillis() - this.b <= 3000;
    }

    @Override // android.view.GestureDetector
    public final boolean onTouchEvent(MotionEvent motionEvent) {
        if (motionEvent.getActionMasked() == 0) {
            this.f13128a.f13129a = false;
            this.b = System.currentTimeMillis();
        }
        return super.onTouchEvent(motionEvent);
    }
}
