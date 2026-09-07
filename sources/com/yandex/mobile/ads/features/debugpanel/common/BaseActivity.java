package com.yandex.mobile.ads.features.debugpanel.common;

import android.app.Activity;
import android.os.Bundle;
import android.view.MotionEvent;
import com.safedk.android.analytics.brandsafety.DetectTouchUtils;
import com.safedk.android.utils.h;
import com.yandex.mobile.ads.impl.ah2;
import com.yandex.mobile.ads.impl.bh2;
import com.yandex.mobile.ads.impl.ou;
import kotlin.Metadata;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;

/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b \u0018\u0000*\b\b\u0000\u0010\u0002*\u00020\u00012\u00020\u0003:\u0001\u0006B\u0007¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0007"}, d2 = {"Lcom/yandex/mobile/ads/features/debugpanel/common/BaseActivity;", "Lcom/yandex/mobile/ads/impl/ah2;", "T", "Landroid/app/Activity;", "<init>", "()V", "a", "mobileads_externalRelease"}, k = 1, mv = {1, 9, 0})
public abstract class BaseActivity<T extends ah2> extends Activity {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final CoroutineScope f8335a = ou.a();
    private final Object b;
    private T c;

    public BaseActivity() {
        Object lastNonConfigurationInstance = getLastNonConfigurationInstance();
        a aVar = lastNonConfigurationInstance instanceof a ? (a) lastNonConfigurationInstance : null;
        this.b = aVar != null ? aVar.a() : null;
    }

    /* JADX INFO: renamed from: a, reason: from getter */
    protected final CoroutineScope getF8335a() {
        return this.f8335a;
    }

    public abstract bh2<T> c();

    @Override // android.app.Activity, android.view.Window.Callback
    public boolean dispatchTouchEvent(MotionEvent me) {
        DetectTouchUtils.activityOnTouch(h.y, me);
        return super.dispatchTouchEvent(me);
    }

    @Override // android.app.Activity
    protected void onCreate(Bundle bundle) {
        Object lastNonConfigurationInstance = getLastNonConfigurationInstance();
        T t = null;
        a aVar = lastNonConfigurationInstance instanceof a ? (a) lastNonConfigurationInstance : null;
        if (aVar != null) {
            ah2 ah2VarB = aVar.b();
            if (ah2VarB instanceof ah2) {
                t = (T) ah2VarB;
            }
            this.c = t;
        }
        super.onCreate(bundle);
    }

    @Override // android.app.Activity
    protected void onDestroy() {
        T t;
        super.onDestroy();
        CoroutineScopeKt.cancel$default(this.f8335a, null, 1, null);
        if (isChangingConfigurations() || (t = this.c) == null) {
            return;
        }
        t.a();
    }

    @Override // android.app.Activity
    public final Object onRetainNonConfigurationInstance() {
        return new a(null, b());
    }

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final Object f8336a;
        private final ah2 b;

        public a() {
            this(0);
        }

        public final Object a() {
            return this.f8336a;
        }

        public a(Object obj, ah2 ah2Var) {
            this.f8336a = obj;
            this.b = ah2Var;
        }

        public final ah2 b() {
            return this.b;
        }

        public /* synthetic */ a(int i) {
            this(null, null);
        }
    }

    protected final T b() {
        T t = this.c;
        if (t != null) {
            return t;
        }
        T t2 = (T) c().a();
        this.c = t2;
        return t2;
    }
}
