package com.inmobi.media;

import android.view.OrientationEventListener;
import com.inmobi.ads.rendering.InMobiAdActivity;
import java.util.HashSet;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.MutablePropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.properties.Delegates;
import kotlin.reflect.KProperty;

/* JADX INFO: renamed from: com.inmobi.media.x4, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes10.dex */
public final class C3622x4 extends OrientationEventListener {
    public static final /* synthetic */ KProperty[] d = {Reflection.mutableProperty1(new MutablePropertyReference1Impl(C3622x4.class, "currentOrientation", "getCurrentOrientation()Lcom/inmobi/ads/rendering/orientation/Orientation;", 0))};

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final InMobiAdActivity f3473a;
    public final HashSet b;
    public final C3608w4 c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C3622x4(InMobiAdActivity activity) {
        super(activity);
        Intrinsics.checkNotNullParameter(activity, "activity");
        this.f3473a = activity;
        this.b = new HashSet();
        Delegates delegates = Delegates.INSTANCE;
        this.c = new C3608w4(AbstractC3515p9.a(AbstractC3565t3.g()), this);
    }

    public final void a(C3529q9 orientationProperties) {
        Intrinsics.checkNotNullParameter(orientationProperties, "orientationProperties");
        try {
            if (orientationProperties.f3409a) {
                this.f3473a.setRequestedOrientation(13);
            } else {
                String str = orientationProperties.b;
                if (Intrinsics.areEqual(str, "landscape")) {
                    this.f3473a.setRequestedOrientation(6);
                } else if (Intrinsics.areEqual(str, "portrait")) {
                    this.f3473a.setRequestedOrientation(7);
                } else {
                    this.f3473a.setRequestedOrientation(13);
                }
            }
        } catch (IllegalStateException unused) {
        }
    }

    public final void b() {
        int i = this.f3473a.getResources().getConfiguration().orientation;
        byte bG = AbstractC3565t3.g();
        int i2 = 1;
        if (bG != 1 && bG != 2 && (bG == 3 || bG == 4)) {
            i2 = 2;
        }
        if (i == i2) {
            this.c.setValue(this, d[0], AbstractC3515p9.a(AbstractC3565t3.g()));
        }
    }

    @Override // android.view.OrientationEventListener
    public final void onOrientationChanged(int i) {
        b();
    }

    public final void a() {
        if (this.b.isEmpty()) {
            disable();
        } else {
            enable();
        }
    }
}
