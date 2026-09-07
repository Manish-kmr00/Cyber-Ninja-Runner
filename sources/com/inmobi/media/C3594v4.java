package com.inmobi.media;

import android.R;
import android.app.Activity;
import android.content.Intent;
import android.util.SparseArray;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.Window;
import android.view.WindowManager;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import androidx.core.view.WindowCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.core.view.WindowInsetsControllerCompat;
import com.inmobi.ads.rendering.InMobiAdActivity;
import java.lang.ref.WeakReference;
import java.util.Objects;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;

/* JADX INFO: renamed from: com.inmobi.media.v4, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes11.dex */
public final class C3594v4 implements InterfaceC3542r9 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final WeakReference f3454a;
    public r b;
    public B c;
    public RelativeLayout d;
    public C3607w3 e;
    public EnumC3501o9 f;
    public float g;
    public L4 h;
    public final C3580u4 i;
    public final C3566t4 j;

    public C3594v4(InMobiAdActivity activity) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        this.f3454a = new WeakReference(activity);
        this.f = AbstractC3515p9.a(AbstractC3565t3.g());
        this.g = 1.0f;
        this.i = new C3580u4(this);
        this.j = new C3566t4(this);
    }

    public final void a(Intent intent, SparseArray adContainers) {
        C3607w3 c3607w3;
        Window window;
        Intrinsics.checkNotNullParameter(intent, "intent");
        Intrinsics.checkNotNullParameter(adContainers, "adContainers");
        if (!intent.hasExtra("com.inmobi.ads.rendering.InMobiAdActivity.EXTRA_AD_CONTAINER_INDEX")) {
            b();
            return;
        }
        r rVar = (r) adContainers.get(intent.getIntExtra("com.inmobi.ads.rendering.InMobiAdActivity.EXTRA_AD_CONTAINER_INDEX", -1));
        if (rVar == null) {
            b();
            return;
        }
        int intExtra = intent.getIntExtra("com.inmobi.ads.rendering.InMobiAdActivity.EXTRA_AD_CONTAINER_TYPE", 0);
        if (intExtra == 0) {
            InterfaceC3519q fullScreenEventsListener = rVar.getFullScreenEventsListener();
            if (fullScreenEventsListener != null) {
                fullScreenEventsListener.a();
            }
            b();
            return;
        }
        if (intent.getBooleanExtra("com.inmobi.ads.rendering.InMobiAdActivity.EXTRA_AD_ACTIVITY_IS_FULL_SCREEN", false) && (this.f3454a.get() instanceof InMobiAdActivity)) {
            Object obj = this.f3454a.get();
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type com.inmobi.ads.rendering.InMobiAdActivity");
            if (!((InMobiAdActivity) obj).g) {
                Object obj2 = this.f3454a.get();
                Intrinsics.checkNotNull(obj2, "null cannot be cast to non-null type com.inmobi.ads.rendering.InMobiAdActivity");
                ((InMobiAdActivity) obj2).g = true;
                if (!(rVar instanceof Ba) ? false : ((Ba) rVar).G0) {
                    L4 l4 = this.h;
                    if (l4 != null) {
                        ((M4) l4).a("InMobiActivityViewHandler", "showInImmersiveMode");
                    }
                    Object obj3 = this.f3454a.get();
                    InMobiAdActivity inMobiAdActivity = obj3 instanceof InMobiAdActivity ? (InMobiAdActivity) obj3 : null;
                    if (inMobiAdActivity != null && (window = inMobiAdActivity.getWindow()) != null) {
                        C3435k3 c3435k3 = C3435k3.f3355a;
                        if (c3435k3.z()) {
                            WindowManager.LayoutParams attributes = window.getAttributes();
                            attributes.layoutInDisplayCutoutMode = 3;
                            window.setAttributes(attributes);
                            WindowCompat.setDecorFitsSystemWindows(window, false);
                        } else if (c3435k3.x()) {
                            WindowManager.LayoutParams attributes2 = window.getAttributes();
                            attributes2.layoutInDisplayCutoutMode = 1;
                            window.setAttributes(attributes2);
                            WindowCompat.setDecorFitsSystemWindows(window, false);
                        }
                        if (c3435k3.z()) {
                            WindowInsetsControllerCompat insetsController = WindowCompat.getInsetsController(window, window.getDecorView());
                            if (insetsController != null) {
                                insetsController.setSystemBarsBehavior(2);
                            }
                            if (insetsController != null) {
                                insetsController.hide(WindowInsetsCompat.Type.systemBars());
                            }
                            if (insetsController != null) {
                                insetsController.hide(WindowInsetsCompat.Type.displayCutout());
                            }
                        } else if (c3435k3.F()) {
                            window.getDecorView().setSystemUiVisibility(5638);
                        }
                    }
                } else {
                    Activity activity = (Activity) this.f3454a.get();
                    if (activity != null) {
                        Intrinsics.checkNotNullParameter(activity, "<this>");
                        try {
                            activity.requestWindowFeature(1);
                            activity.getWindow().setFlags(1024, 1024);
                        } catch (Exception unused) {
                        }
                    }
                }
            }
        }
        if ((200 == intExtra && !Intrinsics.areEqual("html", rVar.getMarkupType())) || ((202 == intExtra && !Intrinsics.areEqual("htmlUrl", rVar.getMarkupType())) || (201 == intExtra && !Intrinsics.areEqual("inmobiJson", rVar.getMarkupType())))) {
            InterfaceC3519q fullScreenEventsListener2 = rVar.getFullScreenEventsListener();
            if (fullScreenEventsListener2 != null) {
                fullScreenEventsListener2.a();
            }
            b();
            return;
        }
        try {
            this.b = rVar;
            rVar.setFullScreenActivityContext((Activity) this.f3454a.get());
            a();
            Activity activity2 = (Activity) this.f3454a.get();
            if (activity2 != null) {
                RelativeLayout relativeLayout = new RelativeLayout(activity2);
                relativeLayout.setId(65534);
                this.d = relativeLayout;
            }
            a(rVar);
            B b = this.c;
            if (b != null) {
                b.f();
            }
            Activity activity3 = (Activity) this.f3454a.get();
            if (activity3 != null) {
                FrameLayout frameLayout = (FrameLayout) activity3.findViewById(R.id.content);
                RelativeLayout relativeLayout2 = frameLayout != null ? (RelativeLayout) frameLayout.findViewById(65519) : null;
                RelativeLayout relativeLayout3 = this.d;
                if (relativeLayout3 != null && relativeLayout2 != null) {
                    RelativeLayout relativeLayout4 = (RelativeLayout) relativeLayout2.findViewById(65534);
                    if (relativeLayout4 != null) {
                        relativeLayout2.removeView(relativeLayout4);
                    }
                    relativeLayout2.addView(relativeLayout3);
                    B b2 = this.c;
                    if (b2 != null) {
                        b2.e();
                    }
                }
            }
            if (rVar instanceof Ba) {
                ((Ba) rVar).setEmbeddedBrowserJSCallbacks(this.j);
            }
            if ((rVar instanceof Ba) && (c3607w3 = this.e) != null) {
                c3607w3.setUserLeftApplicationListener(((Ba) rVar).getListener());
            }
        } catch (Exception e) {
            rVar.setFullScreenActivityContext(null);
            InterfaceC3519q fullScreenEventsListener3 = rVar.getFullScreenEventsListener();
            if (fullScreenEventsListener3 != null) {
                fullScreenEventsListener3.a();
            }
            b();
            C3339d5 c3339d5 = C3339d5.f3292a;
            C3339d5.c.a(I4.a(e, "event"));
        }
    }

    public final void b() {
        Activity activity = (Activity) this.f3454a.get();
        if (activity instanceof InMobiAdActivity) {
            ((InMobiAdActivity) activity).finish();
        }
    }

    public final void c() {
        C3579u3 c3579u3D;
        if (this.e == null) {
            return;
        }
        r rVar = this.b;
        if (rVar == null) {
            c3579u3D = AbstractC3565t3.d();
        } else {
            if (!(!(rVar instanceof Ba) ? false : ((Ba) rVar).G0)) {
                Activity activity = (Activity) this.f3454a.get();
                if (activity != null) {
                    Intrinsics.checkNotNull(activity);
                    if (AbstractC3420j2.a(activity)) {
                    }
                }
                c3579u3D = AbstractC3565t3.d();
            }
            c3579u3D = AbstractC3565t3.h();
        }
        float f = c3579u3D.f3441a;
        float f2 = c3579u3D.c;
        float f3 = f * f2;
        float f4 = c3579u3D.b * f2;
        if (AbstractC3515p9.b(this.f)) {
            a(MathKt.roundToInt((1 - this.g) * f3), -1);
        } else {
            a(-1, MathKt.roundToInt((1 - this.g) * f4));
        }
    }

    public final void d() {
        try {
            final C3607w3 c3607w3 = this.e;
            if (c3607w3 != null) {
                ViewParent parent = c3607w3.getParent();
                ViewGroup viewGroup = parent instanceof ViewGroup ? (ViewGroup) parent : null;
                if (viewGroup != null) {
                    viewGroup.removeView(c3607w3);
                }
                ViewParent parent2 = c3607w3.getParent();
                Intrinsics.checkNotNull(parent2, "null cannot be cast to non-null type android.view.ViewGroup");
                ((ViewGroup) parent2).post(new Runnable() { // from class: com.inmobi.media.v4$$ExternalSyntheticLambda0
                    @Override // java.lang.Runnable
                    public final void run() {
                        C3594v4.a(c3607w3);
                    }
                });
            }
            C3607w3 c3607w4 = this.e;
            if (c3607w4 != null) {
                E3 e3 = c3607w4.c;
                if (e3 != null) {
                    e3.destroy();
                }
                c3607w4.c = null;
                c3607w4.d = null;
                c3607w4.e = null;
                Ad ad = c3607w4.g;
                if (ad != null) {
                    ad.a();
                }
                c3607w4.removeAllViews();
            }
            this.e = null;
        } catch (Exception unused) {
        }
    }

    public final void a() {
        Activity activity = (Activity) this.f3454a.get();
        if (activity == null) {
            return;
        }
        FrameLayout frameLayout = (FrameLayout) activity.findViewById(R.id.content);
        if ((frameLayout != null ? (RelativeLayout) frameLayout.findViewById(65519) : null) != null) {
            return;
        }
        RelativeLayout relativeLayout = new RelativeLayout(activity);
        relativeLayout.setId(65519);
        relativeLayout.setBackgroundColor(0);
        frameLayout.removeAllViews();
        frameLayout.addView(relativeLayout, new RelativeLayout.LayoutParams(-1, -1));
    }

    /* JADX WARN: Code duplicated, block: B:25:0x005e  */
    /* JADX WARN: Code duplicated, block: B:26:0x0060  */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x0038, code lost:
    
        r1 = new com.inmobi.media.C3394h4(r4.f3454a, r5, r0);
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void a(com.inmobi.media.r r5) {
        /*
            r4 = this;
            java.lang.ref.WeakReference r0 = r4.f3454a
            java.lang.Object r0 = r0.get()
            android.app.Activity r0 = (android.app.Activity) r0
            if (r0 != 0) goto Lb
            return
        Lb:
            android.widget.RelativeLayout r0 = r4.d
            if (r0 != 0) goto L10
            return
        L10:
            java.lang.String r1 = r5.getMarkupType()
            int r2 = r1.hashCode()
            r3 = -1084172778(0xffffffffbf60d616, float:-0.8782667)
            if (r2 == r3) goto L40
            r3 = 3213227(0x3107ab, float:4.50269E-39)
            if (r2 == r3) goto L30
            r3 = 1236050372(0x49aca1c4, float:1414200.5)
            if (r2 != r3) goto L67
            java.lang.String r2 = "htmlUrl"
            boolean r1 = r1.equals(r2)
            if (r1 == 0) goto L67
            goto L38
        L30:
            java.lang.String r2 = "html"
            boolean r1 = r1.equals(r2)
            if (r1 == 0) goto L67
        L38:
            com.inmobi.media.h4 r1 = new com.inmobi.media.h4
            java.lang.ref.WeakReference r2 = r4.f3454a
            r1.<init>(r2, r5, r0)
            goto L4f
        L40:
            java.lang.String r2 = "inmobiJson"
            boolean r1 = r1.equals(r2)
            if (r1 == 0) goto L67
            com.inmobi.media.H5 r1 = new com.inmobi.media.H5
            java.lang.ref.WeakReference r2 = r4.f3454a
            r1.<init>(r2, r5, r0)
        L4f:
            r4.c = r1
            com.inmobi.media.o9 r0 = r4.f
            r1.a(r0)
            float r0 = r4.g
            r1.c = r0
            boolean r0 = r5 instanceof com.inmobi.media.Ba
            if (r0 != 0) goto L60
            r5 = 0
            goto L64
        L60:
            com.inmobi.media.Ba r5 = (com.inmobi.media.Ba) r5
            boolean r5 = r5.G0
        L64:
            r1.d = r5
            return
        L67:
            java.lang.IllegalArgumentException r5 = new java.lang.IllegalArgumentException
            java.lang.String r0 = "InMobiActivityViewHandler: Unknown Markup type"
            r5.<init>(r0)
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.inmobi.media.C3594v4.a(com.inmobi.media.r):void");
    }

    @Override // com.inmobi.media.InterfaceC3542r9
    public final void a(EnumC3501o9 orientation) {
        Intrinsics.checkNotNullParameter(orientation, "orientation");
        if (((Activity) this.f3454a.get()) == null) {
            return;
        }
        B b = this.c;
        if (b != null) {
            b.a(orientation);
        }
        EnumC3501o9 enumC3501o9 = this.f;
        if (enumC3501o9 != orientation && AbstractC3515p9.b(enumC3501o9) != AbstractC3515p9.b(orientation)) {
            Objects.toString(orientation);
            this.f = orientation;
            B b2 = this.c;
            if (b2 != null) {
                b2.e();
            }
            c();
            return;
        }
        Objects.toString(orientation);
        this.f = orientation;
    }

    public static final void a(C3594v4 c3594v4) {
        c3594v4.g = 1.0f;
        B b = c3594v4.c;
        if (b != null) {
            b.c = 1.0f;
            b.e();
        }
        C3607w3 c3607w3 = c3594v4.e;
        if (c3607w3 != null) {
            c3607w3.setLayoutParams(new RelativeLayout.LayoutParams(0, 0));
        }
        c3594v4.d();
    }

    public static final void a(C3607w3 this_run) {
        Intrinsics.checkNotNullParameter(this_run, "$this_run");
        this_run.getParent().requestLayout();
    }

    public final void a(int i, int i2) {
        RelativeLayout.LayoutParams layoutParams;
        Activity activity = (Activity) this.f3454a.get();
        if (activity == null) {
            return;
        }
        AbstractC3515p9.b(this.f);
        if (AbstractC3515p9.b(this.f)) {
            layoutParams = new RelativeLayout.LayoutParams(i, i2);
            layoutParams.addRule(11);
        } else {
            layoutParams = new RelativeLayout.LayoutParams(i, i2);
            layoutParams.addRule(12);
        }
        RelativeLayout relativeLayout = (RelativeLayout) ((FrameLayout) activity.findViewById(R.id.content)).findViewById(65519);
        Intrinsics.checkNotNull(relativeLayout);
        if (((RelativeLayout) relativeLayout.findViewById(65518)) != null) {
            C3607w3 c3607w3 = this.e;
            if (c3607w3 == null) {
                return;
            }
            c3607w3.setLayoutParams(layoutParams);
            return;
        }
        C3607w3 c3607w4 = this.e;
        if (c3607w4 != null) {
            relativeLayout.addView(c3607w4, layoutParams);
        }
    }
}
