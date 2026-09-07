package com.ogury.ad.interstitial.ui;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import androidx.core.graphics.Insets;
import androidx.core.view.OnApplyWindowInsetsListener;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import com.json.b9;
import com.ogury.ad.internal.a3;
import com.ogury.ad.internal.aa;
import com.ogury.ad.internal.d5;
import com.ogury.ad.internal.h;
import com.ogury.ad.internal.i5;
import com.ogury.ad.internal.j4;
import com.ogury.ad.internal.q;
import com.ogury.ad.internal.s5;
import com.ogury.ad.internal.t4;
import com.ogury.ad.internal.v4;
import com.ogury.ad.internal.w5;
import com.ogury.core.internal.IntegrationLogger;
import com.safedk.android.analytics.brandsafety.BrandSafetyUtils;
import com.safedk.android.analytics.brandsafety.DetectTouchUtils;
import com.safedk.android.utils.Logger;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.TypeIntrinsics;
import net.pubnative.lite.sdk.analytics.Reporting;

/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0016\u0018\u00002\u00020\u00012\u00020\u0002:\u0001\u0005B\u0007¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0006"}, d2 = {"Lcom/ogury/ad/interstitial/ui/InterstitialActivity;", "Lcom/ogury/ad/internal/s5;", "Landroid/app/Activity;", "<init>", "()V", "a", "sdk-ads_prodRelease"}, k = 1, mv = {2, 0, 0})
public class InterstitialActivity extends Activity implements s5 {
    public static final a d = new a();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public j4 f7477a;
    public boolean b;
    public boolean c = true;

    public void a(com.ogury.ad.internal.c cVar) {
        if (Intrinsics.areEqual(cVar != null ? cVar.d : null, "landscape")) {
            setRequestedOrientation(0);
            return;
        }
        if (Intrinsics.areEqual(cVar != null ? cVar.d : null, "portrait")) {
            setRequestedOrientation(1);
        }
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public boolean dispatchTouchEvent(MotionEvent me) {
        DetectTouchUtils.activityOnTouch("io.presage", me);
        return super.dispatchTouchEvent(me);
    }

    /* JADX WARN: Code duplicated, block: B:15:0x002e  */
    @Override // android.app.Activity
    @Deprecated(message = "Deprecated in Java")
    public final void onBackPressed() {
        boolean z;
        j4 j4Var = this.f7477a;
        if (j4Var == null) {
            z = false;
        } else {
            i5 i5Var = j4Var.u;
            if (i5Var != null) {
                for (d5 d5Var : i5Var.b.values()) {
                    if (d5Var.canGoBack()) {
                        d5Var.goBack();
                    }
                }
            }
            if (j4Var.s) {
                z = false;
            } else {
                z = true;
            }
        }
        if (z) {
            return;
        }
        super.onBackPressed();
    }

    @Override // android.app.Activity
    public final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (bundle != null) {
            finish();
            return;
        }
        getWindow().setFlags(16777216, 16777216);
        try {
            Serializable serializableExtra = getIntent().getSerializableExtra("not_displayed_ads");
            Intrinsics.checkNotNull(serializableExtra, "null cannot be cast to non-null type kotlin.collections.MutableList<com.ogury.ad.common.network.models.Ad>");
            List listAsMutableList = TypeIntrinsics.asMutableList(serializableExtra);
            Serializable serializableExtra2 = getIntent().getSerializableExtra(Reporting.Key.CLICK_SOURCE_TYPE_AD);
            com.ogury.ad.internal.c cVar = serializableExtra2 instanceof com.ogury.ad.internal.c ? (com.ogury.ad.internal.c) serializableExtra2 : null;
            if (cVar == null) {
                throw new IllegalStateException("Ad not sent to interstitial activity".toString());
            }
            this.b = q.a(cVar);
            Intent intent = getIntent();
            Intrinsics.checkNotNullExpressionValue(intent, "getIntent(...)");
            com.ogury.ad.interstitial.ui.a aVar = new com.ogury.ad.interstitial.ui.a(this, intent, cVar, listAsMutableList);
            h hVarB = aVar.b();
            hVarB.setDisplayedInFullScreen(true);
            this.f7477a = aVar.a();
            ViewCompat.setOnApplyWindowInsetsListener(hVarB, new OnApplyWindowInsetsListener() { // from class: com.ogury.ad.interstitial.ui.InterstitialActivity$$ExternalSyntheticLambda0
                @Override // androidx.core.view.OnApplyWindowInsetsListener
                public final WindowInsetsCompat onApplyWindowInsets(View view, WindowInsetsCompat windowInsetsCompat) {
                    return InterstitialActivity.a(view, windowInsetsCompat);
                }
            });
            setContentView(hVarB);
        } catch (Throwable th) {
            IntegrationLogger.e("[Ads][Activity] onCreate() failed (" + th.getMessage());
            this.c = false;
            finish();
        }
    }

    @Override // android.app.Activity
    public final void onDestroy() {
        super.onDestroy();
        if (this.c) {
            j4 j4Var = this.f7477a;
            if (j4Var != null && (j4Var.F || (j4Var.k && j4Var.A != 2))) {
                j4Var.g();
            }
        } else {
            Serializable serializableExtra = getIntent().getSerializableExtra(Reporting.Key.CLICK_SOURCE_TYPE_AD);
            com.ogury.ad.internal.c cVar = serializableExtra instanceof com.ogury.ad.internal.c ? (com.ogury.ad.internal.c) serializableExtra : null;
            if (cVar != null) {
                v4 v4Var = v4.f7421a;
                v4.a(new t4(cVar.b));
                String adId = cVar.b;
                Intrinsics.checkNotNullParameter(adId, "adId");
                v4.b.remove(adId);
            }
        }
        this.f7477a = null;
    }

    @Override // android.app.Activity
    public final void onPause() {
        super.onPause();
        if (this.b) {
            w5.c = false;
        }
        overridePendingTransition(0, 0);
    }

    @Override // android.app.Activity
    public final void onResume() {
        super.onResume();
        if (this.b) {
            w5.c = true;
        }
    }

    /* JADX WARN: Code duplicated, block: B:21:0x0041 A[EDGE_INSN: B:21:0x0041->B:22:0x0042 BREAK  A[LOOP:0: B:16:0x002f->B:31:?]] */
    @Override // android.app.Activity
    public final void onStop() {
        boolean z;
        super.onStop();
        j4 j4Var = this.f7477a;
        if (j4Var != null) {
            boolean zIsFinishing = isFinishing();
            if (!j4Var.k || j4Var.A == 2) {
                return;
            }
            i5 i5Var = j4Var.u;
            if (i5Var == null) {
                z = false;
                break;
            }
            Collection<aa> collectionValues = i5Var.e.b.values();
            if (!(collectionValues instanceof Collection) || !collectionValues.isEmpty()) {
                Iterator<T> it = collectionValues.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        z = false;
                        break;
                    } else if (((aa) it.next()).b) {
                        z = true;
                        break;
                    }
                }
            } else {
                z = false;
                break;
            }
            if (z || !j4Var.t) {
                return;
            }
            j4Var.g();
            j4Var.D.a(j4Var, j4Var.h);
            if (zIsFinishing) {
                return;
            }
            j4Var.j();
        }
    }

    public static final WindowInsetsCompat a(View v, WindowInsetsCompat windowInsets) {
        Intrinsics.checkNotNullParameter(v, "v");
        Intrinsics.checkNotNullParameter(windowInsets, "windowInsets");
        Insets insets = windowInsets.getInsets(WindowInsetsCompat.Type.systemBars());
        Intrinsics.checkNotNullExpressionValue(insets, "getInsets(...)");
        ViewGroup.LayoutParams layoutParams = v.getLayoutParams();
        if (layoutParams != null) {
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
            marginLayoutParams.leftMargin = insets.left;
            marginLayoutParams.bottomMargin = insets.bottom;
            marginLayoutParams.rightMargin = insets.right;
            marginLayoutParams.topMargin = insets.top;
            v.setLayoutParams(marginLayoutParams);
            return WindowInsetsCompat.CONSUMED;
        }
        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
    }

    public static final class a implements a3 {
        public static void safedk_Context_startActivity_97cb3195734cf5c9cc3418feeafa6dd6(Context p0, Intent p1) {
            Logger.d("SafeDK-Special|SafeDK: Call> Landroid/content/Context;->startActivity(Landroid/content/Intent;)V");
            if (p1 == null) {
                return;
            }
            BrandSafetyUtils.detectAdClick(p1, "io.presage");
            p0.startActivity(p1);
        }

        @Override // com.ogury.ad.internal.a3
        public final void a(Context context, com.ogury.ad.internal.c ad, List<com.ogury.ad.internal.c> notDisplayedAds) {
            Class cls;
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(ad, "ad");
            Intrinsics.checkNotNullParameter(notDisplayedAds, "notDisplayedAds");
            IntegrationLogger.d("[Ads][Activity] Prepare and start Activity");
            if (Build.VERSION.SDK_INT != 26) {
                cls = InterstitialActivity.class;
            } else {
                cls = ad.o ? InterstitialAndroid8TransparentActivity.class : InterstitialAndroid8RotableActivity.class;
            }
            Intent intent = new Intent(context, (Class<?>) cls);
            intent.putExtra(Reporting.Key.CLICK_SOURCE_TYPE_AD, ad);
            intent.putExtra("not_displayed_ads", new ArrayList(notDisplayedAds));
            intent.addFlags(268435456);
            safedk_Context_startActivity_97cb3195734cf5c9cc3418feeafa6dd6(context, intent);
        }

        @Override // com.ogury.ad.internal.a3
        public final void a(Context context, String expandCacheItemId, com.ogury.ad.internal.c ad, List<com.ogury.ad.internal.c> notDisplayedAds) {
            Class cls;
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(expandCacheItemId, "expandCacheItemId");
            Intrinsics.checkNotNullParameter(ad, "ad");
            Intrinsics.checkNotNullParameter(notDisplayedAds, "notDisplayedAds");
            if (Build.VERSION.SDK_INT != 26) {
                cls = InterstitialActivity.class;
            } else if (ad.o) {
                cls = InterstitialAndroid8TransparentActivity.class;
            } else {
                cls = InterstitialAndroid8RotableActivity.class;
            }
            Intent intent = new Intent(context, (Class<?>) cls);
            intent.putExtra(Reporting.Key.CLICK_SOURCE_TYPE_AD, ad);
            intent.putExtra("not_displayed_ads", new ArrayList(notDisplayedAds));
            intent.addFlags(268435456);
            intent.putExtra(b9.a.t, 1);
            intent.putExtra("expand_cache_item_id", expandCacheItemId);
            safedk_Context_startActivity_97cb3195734cf5c9cc3418feeafa6dd6(context, intent);
        }
    }
}
