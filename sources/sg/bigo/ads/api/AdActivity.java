package sg.bigo.ads.api;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import java.lang.reflect.Constructor;
import sg.bigo.ads.api.core.BaseAdActivityImpl;

/* JADX INFO: loaded from: classes12.dex */
public class AdActivity extends Activity {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private BaseAdActivityImpl f13082a;

    public static Intent a(Context context, Class<? extends BaseAdActivityImpl> cls) {
        Intent intent = new Intent(context, (Class<?>) AdActivity.class);
        if (!(context instanceof Activity)) {
            intent.addFlags(268435456);
        }
        intent.putExtra("impl_clazz", cls.getName());
        return intent;
    }

    public static Intent b(Context context, Class<? extends BaseAdActivityImpl> cls) {
        Intent intent = new Intent(context, (Class<?>) PopupAdActivity.class);
        if (!(context instanceof Activity)) {
            intent.addFlags(268435456);
        }
        intent.putExtra("impl_clazz", cls.getName());
        return intent;
    }

    public static Intent c(Context context, Class<? extends BaseAdActivityImpl> cls) {
        Intent intent = new Intent(context, (Class<?>) LandscapeAdActivity.class);
        if (!(context instanceof Activity)) {
            intent.addFlags(268435456);
        }
        intent.putExtra("impl_clazz", cls.getName());
        return intent;
    }

    public static Intent d(Context context, Class<? extends BaseAdActivityImpl> cls) {
        Intent intent = new Intent(context, (Class<?>) CompanionAdActivity.class);
        if (!(context instanceof Activity)) {
            intent.addFlags(268435456);
        }
        intent.putExtra("impl_clazz", cls.getName());
        return intent;
    }

    public static Intent e(Context context, Class<? extends BaseAdActivityImpl> cls) {
        Intent intent = new Intent(context, (Class<?>) LandscapeCompanionAdActivity.class);
        if (!(context instanceof Activity)) {
            intent.addFlags(268435456);
        }
        intent.putExtra("impl_clazz", cls.getName());
        return intent;
    }

    public static Intent f(Context context, Class<? extends BaseAdActivityImpl> cls) {
        Intent intent = new Intent(context, (Class<?>) LandingStyleableActivity.class);
        if (!(context instanceof Activity)) {
            intent.addFlags(268435456);
        }
        intent.putExtra("impl_clazz", cls.getName());
        return intent;
    }

    protected void a() {
    }

    public int b() {
        return 0;
    }

    @Override // android.app.Activity
    public void finish() {
        super.finish();
        try {
            BaseAdActivityImpl baseAdActivityImpl = this.f13082a;
            if (baseAdActivityImpl != null) {
                baseAdActivityImpl.X();
            }
        } catch (Throwable unused) {
        }
    }

    @Override // android.app.Activity
    protected void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        try {
            BaseAdActivityImpl baseAdActivityImpl = this.f13082a;
            if (baseAdActivityImpl != null) {
                baseAdActivityImpl.a(i, i2, intent);
            }
        } catch (Throwable unused) {
        }
    }

    @Override // android.app.Activity
    public void onBackPressed() {
        try {
            BaseAdActivityImpl baseAdActivityImpl = this.f13082a;
            if (baseAdActivityImpl != null) {
                baseAdActivityImpl.W();
            }
        } catch (Throwable unused) {
        }
    }

    @Override // android.app.Activity
    protected void onCreate(Bundle bundle) {
        boolean z;
        Throwable th;
        try {
            Constructor<?> declaredConstructor = Class.forName(getIntent().getStringExtra("impl_clazz")).getDeclaredConstructor(Activity.class);
            declaredConstructor.setAccessible(true);
            this.f13082a = (BaseAdActivityImpl) declaredConstructor.newInstance(this);
            a();
            super.onCreate(bundle);
            try {
                this.f13082a.J = b();
                this.f13082a.N();
            } catch (Throwable th2) {
                th = th2;
                z = true;
                getIntent().putExtra("create_error_flag", true);
                getIntent().putExtra("create_error_msg", Log.getStackTraceString(th));
                if (!z) {
                    super.onCreate(bundle);
                }
                finish();
            }
        } catch (Throwable th3) {
            z = false;
            th = th3;
        }
    }

    @Override // android.app.Activity
    protected void onDestroy() {
        super.onDestroy();
        try {
            BaseAdActivityImpl baseAdActivityImpl = this.f13082a;
            if (baseAdActivityImpl != null) {
                baseAdActivityImpl.D();
                this.f13082a = null;
            }
        } catch (Throwable unused) {
        }
    }

    @Override // android.app.Activity
    protected void onPause() {
        super.onPause();
        try {
            BaseAdActivityImpl baseAdActivityImpl = this.f13082a;
            if (baseAdActivityImpl != null) {
                baseAdActivityImpl.V();
            }
        } catch (Throwable unused) {
        }
    }

    @Override // android.app.Activity
    protected void onResume() {
        super.onResume();
        try {
            BaseAdActivityImpl baseAdActivityImpl = this.f13082a;
            if (baseAdActivityImpl != null) {
                baseAdActivityImpl.U();
            }
        } catch (Throwable unused) {
            finish();
        }
    }

    @Override // android.app.Activity
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (super.onTouchEvent(motionEvent)) {
            return true;
        }
        BaseAdActivityImpl baseAdActivityImpl = this.f13082a;
        return baseAdActivityImpl != null && baseAdActivityImpl.b(motionEvent);
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        try {
            BaseAdActivityImpl baseAdActivityImpl = this.f13082a;
            if (baseAdActivityImpl != null) {
                baseAdActivityImpl.g(z);
            }
        } catch (Throwable unused) {
        }
    }
}
