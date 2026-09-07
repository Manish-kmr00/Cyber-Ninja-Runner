package sg.bigo.ads.api.core;

import android.app.Activity;
import android.content.Intent;
import android.view.MotionEvent;
import android.view.View;
import android.view.Window;

/* JADX INFO: loaded from: classes10.dex */
public abstract class BaseAdActivityImpl {
    public final Activity I;
    public int J = 0;

    protected BaseAdActivityImpl(Activity activity) {
        this.I = activity;
    }

    public abstract void D();

    public abstract void N();

    protected boolean P() {
        return false;
    }

    public abstract void U();

    public abstract void V();

    public abstract void W();

    public abstract void X();

    public abstract void a(int i, int i2, Intent intent);

    protected void a_(int i) {
        this.I.setContentView(sg.bigo.ads.common.utils.a.a(this.I, i, null, false));
    }

    public final void ao() {
        Window window;
        if (P() || (window = this.I.getWindow()) == null) {
            return;
        }
        sg.bigo.ads.common.utils.s.a(window);
    }

    public void ap() {
        this.I.finish();
    }

    public final boolean aq() {
        return this.J == 1;
    }

    public boolean b(MotionEvent motionEvent) {
        return false;
    }

    public abstract void g(boolean z);

    public final <T extends View> T l(int i) {
        return (T) this.I.findViewById(i);
    }
}
