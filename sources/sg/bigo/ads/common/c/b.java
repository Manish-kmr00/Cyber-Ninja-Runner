package sg.bigo.ads.common.c;

import android.content.Context;
import android.graphics.Bitmap;
import android.renderscript.Allocation;
import android.renderscript.Element;
import android.renderscript.RenderScript;
import android.renderscript.ScriptIntrinsicBlur;

/* JADX INFO: loaded from: classes12.dex */
public final class b implements a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Context f13133a;
    private RenderScript b;
    private ScriptIntrinsicBlur c;
    private Allocation d;
    private Allocation e;

    public b(Context context) {
        this.f13133a = context;
    }

    private boolean b() {
        return (this.b == null || this.c == null) ? false : true;
    }

    @Override // sg.bigo.ads.common.c.a
    public final void a() {
        ScriptIntrinsicBlur scriptIntrinsicBlur = this.c;
        if (scriptIntrinsicBlur != null) {
            scriptIntrinsicBlur.destroy();
            this.c = null;
        }
        RenderScript renderScript = this.b;
        if (renderScript != null) {
            renderScript.destroy();
            this.b = null;
        }
        Allocation allocation = this.d;
        if (allocation != null) {
            allocation.destroy();
            this.d = null;
        }
        Allocation allocation2 = this.e;
        if (allocation2 != null) {
            allocation2.destroy();
            this.e = null;
        }
    }

    @Override // sg.bigo.ads.common.c.a
    public final void a(Bitmap bitmap, Bitmap bitmap2) {
        if (b()) {
            if (this.d == null) {
                this.d = Allocation.createFromBitmap(this.b, bitmap);
            }
            if (this.e == null) {
                this.e = Allocation.createFromBitmap(this.b, bitmap2);
            }
            this.d.copyFrom(bitmap);
            this.c.setInput(this.d);
            this.c.forEach(this.e);
            this.e.copyTo(bitmap2);
        }
    }

    public final boolean a(float f) {
        if (!b()) {
            try {
                RenderScript renderScriptCreate = RenderScript.create(this.f13133a);
                this.b = renderScriptCreate;
                this.c = ScriptIntrinsicBlur.create(renderScriptCreate, Element.U8_4(renderScriptCreate));
            } catch (Exception unused) {
                a();
                return false;
            }
        }
        this.c.setRadius(f);
        return true;
    }

    @Override // sg.bigo.ads.common.c.a
    public final boolean a(Bitmap bitmap, float f) {
        if (!a(f)) {
            return false;
        }
        Allocation allocationCreateFromBitmap = Allocation.createFromBitmap(this.b, bitmap, Allocation.MipmapControl.MIPMAP_NONE, 1);
        this.d = allocationCreateFromBitmap;
        this.e = Allocation.createTyped(this.b, allocationCreateFromBitmap.getType());
        return true;
    }
}
