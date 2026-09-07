package sg.bigo.ads.common.w;

/* JADX INFO: loaded from: classes4.dex */
final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    static final d f13359a;
    final float[] b;
    final float[] c;
    final float[] d = {0.24f, 0.52f, 0.24f};
    boolean e = true;

    static {
        d dVar = new d();
        f13359a = dVar;
        float[] fArr = dVar.c;
        fArr[0] = 0.3f;
        fArr[1] = 0.5f;
        fArr[2] = 0.7f;
        float[] fArr2 = dVar.b;
        fArr2[0] = 0.35f;
        fArr2[1] = 1.0f;
    }

    d() {
        float[] fArr = new float[3];
        this.b = fArr;
        float[] fArr2 = new float[3];
        this.c = fArr2;
        a(fArr);
        a(fArr2);
    }

    private static void a(float[] fArr) {
        fArr[0] = 0.0f;
        fArr[1] = 0.5f;
        fArr[2] = 1.0f;
    }
}
