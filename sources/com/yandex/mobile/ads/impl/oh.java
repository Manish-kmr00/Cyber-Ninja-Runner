package com.yandex.mobile.ads.impl;

import android.media.AudioAttributes;
import android.os.Bundle;
import com.json.mediationsdk.logger.IronSourceError;

/* JADX INFO: loaded from: classes5.dex */
public final class oh implements jm {
    public static final oh h = new oh(0, 0, 1, 1, 0);
    public final int b;
    public final int c;
    public final int d;
    public final int e;
    public final int f;
    private c g;

    static {
        new jm.a() { // from class: com.yandex.mobile.ads.impl.oh$$ExternalSyntheticLambda0
            @Override // com.yandex.mobile.ads.impl.jm.a
            public final jm fromBundle(Bundle bundle) {
                return oh.a(bundle);
            }
        };
    }

    public static final class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final AudioAttributes f9816a;

        private c(oh ohVar) {
            AudioAttributes.Builder usage = new AudioAttributes.Builder().setContentType(ohVar.b).setFlags(ohVar.c).setUsage(ohVar.d);
            int i = x82.f10629a;
            if (i >= 29) {
                a.a(usage, ohVar.e);
            }
            if (i >= 32) {
                b.a(usage, ohVar.f);
            }
            this.f9816a = usage.build();
        }
    }

    private oh(int i, int i2, int i3, int i4, int i5) {
        this.b = i;
        this.c = i2;
        this.d = i3;
        this.e = i4;
        this.f = i5;
    }

    public final c a() {
        if (this.g == null) {
            this.g = new c();
        }
        return this.g;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static oh a(Bundle bundle) {
        return new oh(bundle.containsKey(Integer.toString(0, 36)) ? bundle.getInt(Integer.toString(0, 36)) : 0, bundle.containsKey(Integer.toString(1, 36)) ? bundle.getInt(Integer.toString(1, 36)) : 0, bundle.containsKey(Integer.toString(2, 36)) ? bundle.getInt(Integer.toString(2, 36)) : 1, bundle.containsKey(Integer.toString(3, 36)) ? bundle.getInt(Integer.toString(3, 36)) : 1, bundle.containsKey(Integer.toString(4, 36)) ? bundle.getInt(Integer.toString(4, 36)) : 0);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || oh.class != obj.getClass()) {
            return false;
        }
        oh ohVar = (oh) obj;
        return this.b == ohVar.b && this.c == ohVar.c && this.d == ohVar.d && this.e == ohVar.e && this.f == ohVar.f;
    }

    public final int hashCode() {
        return ((((((((this.b + IronSourceError.ERROR_NON_EXISTENT_INSTANCE) * 31) + this.c) * 31) + this.d) * 31) + this.e) * 31) + this.f;
    }

    private static final class a {
        public static void a(AudioAttributes.Builder builder, int i) {
            builder.setAllowedCapturePolicy(i);
        }
    }

    private static final class b {
        public static void a(AudioAttributes.Builder builder, int i) {
            builder.setSpatializationBehavior(i);
        }
    }
}
