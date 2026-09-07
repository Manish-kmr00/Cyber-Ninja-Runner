package com.safedk.android.analytics.brandsafety;

/* JADX INFO: loaded from: classes6.dex */
public class j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    String f8109a = null;
    String b = null;
    long c = 0;
    int d = 0;
    int e = 0;
    BrandSafetyUtils.ScreenShotOrientation f = null;
    boolean g = false;

    public j(String str, String str2, long j, int i, int i2, BrandSafetyUtils.ScreenShotOrientation screenShotOrientation, boolean z) {
        a(str, str2, j, i, i2, screenShotOrientation, z);
    }

    public j(String str, String str2, BrandSafetyUtils.ScreenShotOrientation screenShotOrientation) {
        a(str, str2, 0L, 0, 0, screenShotOrientation, false);
    }

    private void a(String str, String str2, long j, int i, int i2, BrandSafetyUtils.ScreenShotOrientation screenShotOrientation, boolean z) {
        this.f8109a = str;
        this.b = str2;
        this.c = j;
        this.d = i;
        this.e = i2;
        this.f = screenShotOrientation;
        this.g = z;
    }

    public float a(int i) {
        return (this.d * 100) / i;
    }

    public String toString() {
        return "fileName=" + this.b + ", hashValue=" + this.f8109a;
    }
}
