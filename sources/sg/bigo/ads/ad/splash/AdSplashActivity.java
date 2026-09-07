package sg.bigo.ads.ad.splash;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.FrameLayout;
import com.json.nu;
import com.safedk.android.utils.Logger;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import sg.bigo.ads.api.AdError;
import sg.bigo.ads.api.SplashAd;
import sg.bigo.ads.api.SplashAdInteractionListener;

/* JADX INFO: loaded from: classes10.dex */
public class AdSplashActivity extends Activity {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final Map<Integer, b> f13000a = new HashMap();
    private b b;
    private final AtomicBoolean c = new AtomicBoolean(false);

    public static void a(Context context, b bVar) {
        Intent intent = new Intent(context, (Class<?>) (bVar.getStyle() == SplashAd.Style.HORIZONTAL ? LandscapeAdSplashActivity.class : AdSplashActivity.class));
        if (!(context instanceof Activity)) {
            intent.setFlags(268435456);
        }
        int iHashCode = bVar.hashCode();
        intent.putExtra("splash_hash", iHashCode);
        f13000a.put(Integer.valueOf(iHashCode), bVar);
        safedk_Context_startActivity_97cb3195734cf5c9cc3418feeafa6dd6(context, intent);
    }

    public static void safedk_Context_startActivity_97cb3195734cf5c9cc3418feeafa6dd6(Context p0, Intent p1) {
        Logger.d("SafeDK-Special|SafeDK: Call> Landroid/content/Context;->startActivity(Landroid/content/Intent;)V");
        if (p1 == null) {
            return;
        }
        p0.startActivity(p1);
    }

    @Override // android.app.Activity
    public void finish() {
        super.finish();
        try {
            if (this.b == null || !this.c.compareAndSet(false, true)) {
                return;
            }
            this.b.x.onAdClosed();
        } catch (Throwable unused) {
        }
    }

    @Override // android.app.Activity
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        try {
            requestWindowFeature(1);
            Window window = getWindow();
            if (window != null) {
                window.setFlags(1024, 1024);
                if (Build.VERSION.SDK_INT >= 28) {
                    WindowManager.LayoutParams attributes = window.getAttributes();
                    attributes.layoutInDisplayCutoutMode = 1;
                    attributes.flags |= 67108864;
                    window.setAttributes(attributes);
                }
            }
            Intent intent = getIntent();
            if (intent == null) {
                finish();
                return;
            }
            int intExtra = intent.getIntExtra("splash_hash", -1);
            Map<Integer, b> map = f13000a;
            b bVar = map.get(Integer.valueOf(intExtra));
            if (bVar == null) {
                finish();
                return;
            }
            map.remove(Integer.valueOf(intExtra));
            FrameLayout frameLayout = new FrameLayout(this);
            frameLayout.setBackgroundColor(-1);
            setContentView(frameLayout);
            this.b = bVar;
            bVar.x.c = new SplashAdInteractionListener() { // from class: sg.bigo.ads.ad.splash.AdSplashActivity.1
                @Override // sg.bigo.ads.api.AdInteractionListener
                public final void onAdClicked() {
                    sg.bigo.ads.common.t.a.a(0, 3, "AdSplashActivity", nu.f);
                }

                @Override // sg.bigo.ads.api.AdInteractionListener
                public final void onAdClosed() {
                    sg.bigo.ads.common.t.a.a(0, 3, "AdSplashActivity", nu.g);
                }

                @Override // sg.bigo.ads.api.AdInteractionListener
                public final void onAdError(AdError adError) {
                    if (adError == null) {
                        return;
                    }
                    sg.bigo.ads.common.t.a.a(0, 3, "AdSplashActivity", "onAdError: " + adError.getCode() + " " + adError.getMessage());
                }

                @Override // sg.bigo.ads.api.SplashAdInteractionListener
                public final void onAdFinished() {
                    sg.bigo.ads.common.t.a.a(0, 3, "AdSplashActivity", "onAdFinished");
                }

                @Override // sg.bigo.ads.api.AdInteractionListener
                public final void onAdImpression() {
                    sg.bigo.ads.common.t.a.a(0, 3, "AdSplashActivity", "onAdImpression");
                }

                @Override // sg.bigo.ads.api.AdInteractionListener
                public final void onAdOpened() {
                    sg.bigo.ads.common.t.a.a(0, 3, "AdSplashActivity", nu.c);
                }

                @Override // sg.bigo.ads.api.SplashAdInteractionListener
                public final void onAdSkipped() {
                    sg.bigo.ads.common.t.a.a(0, 3, "AdSplashActivity", "onAdSkipped");
                    AdSplashActivity.this.finish();
                }
            };
            bVar.a(frameLayout);
            b bVar2 = this.b;
            if (bVar2 != null) {
                bVar2.x.onAdOpened();
            }
        } catch (Throwable unused) {
            finish();
        }
    }

    @Override // android.app.Activity
    protected void onDestroy() {
        super.onDestroy();
        try {
            if (this.b != null && this.c.compareAndSet(false, true)) {
                this.b.x.onAdClosed();
            }
            b bVar = this.b;
            if (bVar != null) {
                bVar.destroy();
                this.b = null;
            }
        } catch (Throwable unused) {
        }
    }

    @Override // android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i != 4) {
            return super.onKeyDown(i, keyEvent);
        }
        b bVar = this.b;
        if (bVar == null || !bVar.isSkippable()) {
            return true;
        }
        this.b.d(8);
        return true;
    }

    @Override // android.app.Activity
    protected void onResume() {
        View decorView;
        super.onResume();
        try {
            Window window = getWindow();
            if (window == null || (decorView = window.getDecorView()) == null) {
                return;
            }
            decorView.setSystemUiVisibility(4098);
        } catch (Throwable unused) {
            finish();
        }
    }
}
