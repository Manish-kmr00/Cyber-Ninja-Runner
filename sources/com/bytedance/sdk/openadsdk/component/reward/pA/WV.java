package com.bytedance.sdk.openadsdk.component.reward.pA;

import android.R;
import android.app.Activity;
import android.os.Build;
import android.util.Log;
import android.view.View;
import androidx.core.view.ViewCompat;
import com.bytedance.sdk.component.utils.TV;
import com.bytedance.sdk.openadsdk.utils.Vgu;

/* JADX INFO: loaded from: classes7.dex */
public class WV {
    private boolean KZx = true;
    private final com.bytedance.sdk.openadsdk.component.reward.pA.pA Og;
    private pA ZZv;
    protected int pA;

    public WV(com.bytedance.sdk.openadsdk.component.reward.pA.pA pAVar) {
        this.pA = 0;
        this.Og = pAVar;
        KZx();
        if (pAVar.pA == 2) {
            return;
        }
        try {
            this.pA = Vgu.ZZv(pAVar.SzT, Vgu.pA());
            if (!pAVar.SzT.getWindow().hasFeature(1)) {
                pAVar.SzT.requestWindowFeature(1);
            }
            pAVar.SzT.getWindow().addFlags(16777344);
            if (pAVar.YkC == 2 || !Vgu.KZx(pAVar.SzT)) {
                pAVar.SzT.getWindow().addFlags(1024);
            }
        } catch (Throwable th) {
            Log.e("TTAD.RFSM", "init: ", th);
        }
    }

    public void pA(TV tv) {
        if (tv == null) {
            return;
        }
        tv.postDelayed(new Runnable() { // from class: com.bytedance.sdk.openadsdk.component.reward.pA.WV.1
            @Override // java.lang.Runnable
            public void run() {
                View viewFindViewById;
                try {
                    View decorView = WV.this.Og.SzT.getWindow().getDecorView();
                    if (decorView == null || (viewFindViewById = decorView.findViewById(R.id.statusBarBackground)) == null) {
                        return;
                    }
                    viewFindViewById.setVisibility(8);
                } catch (Exception unused) {
                }
            }
        }, 300L);
    }

    private void KZx() {
        com.bytedance.sdk.openadsdk.component.reward.pA.pA pAVar = this.Og;
        pAVar.dC = pAVar.Og.slz();
        if (26 == Build.VERSION.SDK_INT) {
            if (this.Og.SzT.getResources().getConfiguration().orientation == 1) {
                this.Og.YkC = 1;
                return;
            } else {
                this.Og.YkC = 2;
                return;
            }
        }
        com.bytedance.sdk.openadsdk.component.reward.pA.pA pAVar2 = this.Og;
        pAVar2.YkC = pAVar2.Og.rtW();
    }

    /* JADX WARN: Code duplicated, block: B:36:0x00ba  */
    public void pA(boolean z) {
        float fMin;
        float fMax;
        int iMax;
        int iMax2;
        int i;
        if (Build.VERSION.SDK_INT != 26) {
            if (Build.VERSION.SDK_INT == 27) {
                try {
                    ZZv();
                } catch (Throwable unused) {
                }
            } else {
                ZZv();
            }
        }
        float fML = ML();
        float fJG = JG();
        if (this.Og.YkC == 2) {
            fMin = Math.max(fML, fJG);
            fMax = Math.min(fML, fJG);
        } else {
            fMin = Math.min(fML, fJG);
            fMax = Math.max(fML, fJG);
        }
        Activity activity = this.Og.SzT;
        int iZZv = Vgu.ZZv(activity, Vgu.pA());
        if (this.Og.YkC != 2) {
            if (Vgu.KZx(activity)) {
                fMax -= iZZv;
            }
        } else if (Vgu.KZx(activity)) {
            fMin -= iZZv;
        }
        if (z) {
            this.Og.IIF = (int) fMin;
            this.Og.vA = (int) fMax;
            return;
        }
        int i2 = 20;
        if (this.Og.YkC != 2) {
            if (this.Og.dC == 0.0f || this.Og.dC == 100.0f) {
                i2 = 0;
                iMax = 0;
                iMax2 = 0;
                i = 0;
            } else {
                iMax2 = (int) Math.max((fMax - (((fMin - 20.0f) - 20.0f) / this.Og.dC)) / 2.0f, 0.0f);
                i = iMax2;
                iMax = 20;
            }
        } else if (this.Og.dC == 0.0f || this.Og.dC == 100.0f) {
            i2 = 0;
            iMax = 0;
            iMax2 = 0;
            i = 0;
        } else {
            iMax = (int) Math.max((fMin - (((fMax - 20.0f) - 20.0f) * this.Og.dC)) / 2.0f, 0.0f);
            iMax2 = 20;
            i = 20;
            i2 = iMax;
        }
        float f = i2;
        float f2 = iMax;
        this.Og.IIF = (int) ((fMin - f) - f2);
        float f3 = iMax2;
        float f4 = i;
        this.Og.vA = (int) ((fMax - f3) - f4);
        if (this.Og.RS == null || this.Og.RS.Bzk <= 0) {
            activity.getWindow().getDecorView().setPadding(Vgu.KZx(activity, f), Vgu.KZx(activity, f3), Vgu.KZx(activity, f2), Vgu.KZx(activity, f4));
        }
    }

    public void Og(TV tv) {
        try {
            if (this.Og.RS == null || this.Og.RS.Bzk <= 0) {
                final boolean z = true;
                final boolean z2 = this.KZx && com.bytedance.sdk.openadsdk.core.aBv.ZZv().gbA() == 1;
                if (!this.KZx || !Vgu.KZx(this.Og.SzT)) {
                    z = false;
                }
                if (z || z2) {
                    if (this.ZZv == null) {
                        this.ZZv = new pA() { // from class: com.bytedance.sdk.openadsdk.component.reward.pA.WV.2
                            boolean pA;

                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super();
                            }

                            /* JADX WARN: Code duplicated, block: B:28:0x00e9 A[Catch: all -> 0x010c, TryCatch #0 {all -> 0x010c, blocks: (B:2:0x0000, B:4:0x000b, B:6:0x001f, B:8:0x006a, B:10:0x0088, B:12:0x0097, B:14:0x00ab, B:15:0x00af, B:26:0x00e3, B:28:0x00e9, B:29:0x00ee, B:31:0x00fc, B:16:0x00b2, B:18:0x00bc, B:20:0x00d0, B:22:0x00d4, B:23:0x00da, B:25:0x00de, B:33:0x0102, B:35:0x0106, B:7:0x0045), top: B:38:0x0000 }] */
                            /* JADX WARN: Code duplicated, block: B:31:0x00fc A[Catch: all -> 0x010c, TryCatch #0 {all -> 0x010c, blocks: (B:2:0x0000, B:4:0x000b, B:6:0x001f, B:8:0x006a, B:10:0x0088, B:12:0x0097, B:14:0x00ab, B:15:0x00af, B:26:0x00e3, B:28:0x00e9, B:29:0x00ee, B:31:0x00fc, B:16:0x00b2, B:18:0x00bc, B:20:0x00d0, B:22:0x00d4, B:23:0x00da, B:25:0x00de, B:33:0x0102, B:35:0x0106, B:7:0x0045), top: B:38:0x0000 }] */
                            /* JADX WARN: Code duplicated, block: B:39:? A[RETURN, SYNTHETIC] */
                            @Override // com.bytedance.sdk.openadsdk.component.reward.pA.WV.pA
                            void pA(int i, int i2) {
                                int iAbs;
                                float fPA;
                                try {
                                    if (WV.this.Og.YkC != 2 || WV.this.Og.SzT.getResources().getConfiguration().orientation != 2) {
                                        iAbs = Math.abs(Vgu.Bzk(WV.this.Og.SzT) - WV.this.Og.SzT.getWindow().getDecorView().getHeight());
                                    } else {
                                        iAbs = Math.abs(Vgu.SGo(WV.this.Og.SzT) - WV.this.Og.SzT.getWindow().getDecorView().getWidth());
                                    }
                                    View decorView = WV.this.Og.SzT.getWindow().getDecorView();
                                    int paddingLeft = decorView.getPaddingLeft();
                                    int paddingRight = decorView.getPaddingRight();
                                    int paddingBottom = decorView.getPaddingBottom();
                                    if (iAbs == 0) {
                                        int paddingTop = decorView.getPaddingTop();
                                        if (WV.this.Og.YkC != 1 || WV.this.Og.SzT.getResources().getConfiguration().orientation != 1) {
                                            if (WV.this.Og.YkC == 2 && WV.this.Og.SzT.getResources().getConfiguration().orientation == 2) {
                                                if (z) {
                                                    paddingLeft += (int) Vgu.pA();
                                                }
                                                if (z2) {
                                                    fPA = Vgu.pA();
                                                }
                                            }
                                            if (decorView.isAttachedToWindow()) {
                                                decorView.setPadding(paddingLeft, paddingTop, paddingRight, paddingBottom);
                                                this.pA = true;
                                            }
                                            if (WV.this.Og.dC == 100.0f) {
                                                decorView.setBackgroundColor(ViewCompat.MEASURED_STATE_MASK);
                                                return;
                                            }
                                            return;
                                        }
                                        fPA = Vgu.pA();
                                        paddingTop += (int) fPA;
                                        if (decorView.isAttachedToWindow()) {
                                            decorView.setPadding(paddingLeft, paddingTop, paddingRight, paddingBottom);
                                            this.pA = true;
                                        }
                                        if (WV.this.Og.dC == 100.0f) {
                                            decorView.setBackgroundColor(ViewCompat.MEASURED_STATE_MASK);
                                            return;
                                        }
                                        return;
                                    }
                                    if (this.pA) {
                                        decorView.setPadding(paddingLeft, 0, paddingRight, paddingBottom);
                                        this.pA = false;
                                    }
                                } catch (Throwable unused) {
                                }
                            }
                        };
                    }
                    this.Og.SzT.getWindow().getDecorView().addOnLayoutChangeListener(this.ZZv);
                }
                this.KZx = false;
            }
        } catch (Exception unused) {
        }
    }

    public float[] pA(int i) {
        float[] fArrOg = new float[2];
        Activity activity = this.Og.SzT;
        View decorView = activity.getWindow().getDecorView();
        if (Build.VERSION.SDK_INT >= 35 && this.Og.Og.slz() == 100.0f) {
            fArrOg[0] = decorView.getWidth() - decorView.getPaddingLeft();
            fArrOg[1] = decorView.getHeight() - decorView.getPaddingTop();
        } else {
            fArrOg[0] = decorView.getWidth() - (decorView.getPaddingLeft() * 2);
            fArrOg[1] = decorView.getHeight() - (decorView.getPaddingTop() * 2);
        }
        fArrOg[0] = Vgu.ZZv(activity, fArrOg[0]);
        float fZZv = Vgu.ZZv(activity, fArrOg[1]);
        fArrOg[1] = fZZv;
        if (fArrOg[0] < 10.0f || fZZv < 10.0f) {
            fArrOg = Og(this.pA);
        }
        if (Build.VERSION.SDK_INT != 26 && Build.VERSION.SDK_INT != 27 && activity.getResources() != null && activity.getResources().getConfiguration() != null) {
            if ((activity.getResources().getConfiguration().orientation == 2 ? 2 : 1) != i) {
                if (i == 2) {
                    float f = fArrOg[0];
                    float f2 = fArrOg[1];
                    if (f < f2) {
                        fArrOg[1] = f;
                        fArrOg[0] = f2;
                    }
                } else {
                    float f3 = fArrOg[0];
                    float f4 = fArrOg[1];
                    if (f3 > f4) {
                        fArrOg[1] = f3;
                        fArrOg[0] = f4;
                    }
                }
            }
        }
        return fArrOg;
    }

    public void pA() {
        Vgu.pA(this.Og.SzT);
        this.Og.SzT.getWindow().getDecorView().setOnSystemUiVisibilityChangeListener(new View.OnSystemUiVisibilityChangeListener() { // from class: com.bytedance.sdk.openadsdk.component.reward.pA.WV.3
            @Override // android.view.View.OnSystemUiVisibilityChangeListener
            public void onSystemUiVisibilityChange(int i) {
                if (i == 0) {
                    try {
                        if (WV.this.Og.SzT.isFinishing()) {
                            return;
                        }
                        WV.this.Og.SzT.getWindow().getDecorView().postDelayed(new Runnable() { // from class: com.bytedance.sdk.openadsdk.component.reward.pA.WV.3.1
                            @Override // java.lang.Runnable
                            public void run() {
                                Vgu.pA(WV.this.Og.SzT);
                            }
                        }, 2500L);
                    } catch (Exception e) {
                        com.bytedance.sdk.component.utils.WV.pA("TTAD.RFSM", e.getMessage());
                    }
                }
            }
        });
    }

    private float[] Og(int i) {
        float fJG = JG();
        float fML = ML();
        if ((this.Og.YkC == 1) != (fJG > fML)) {
            float f = fJG + fML;
            fML = f - fML;
            fJG = f - fML;
        }
        if (this.Og.YkC == 1) {
            fJG -= i;
        } else {
            fML -= i;
        }
        return new float[]{fML, fJG};
    }

    private void ZZv() {
        if (this.Og.YkC == 2) {
            if (this.Og.PV) {
                pA(this.Og.SzT, 8);
                return;
            } else {
                pA(this.Og.SzT, 0);
                return;
            }
        }
        pA(this.Og.SzT, 1);
    }

    private static void pA(Activity activity, int i) {
        if (activity.getRequestedOrientation() == i) {
            return;
        }
        activity.setRequestedOrientation(i);
    }

    private float ML() {
        return Vgu.ZZv(this.Og.SzT, Vgu.SGo(this.Og.SzT));
    }

    private float JG() {
        return Vgu.ZZv(this.Og.SzT, Vgu.Bzk(this.Og.SzT));
    }

    public void Og() {
        if (this.ZZv != null) {
            this.Og.SzT.getWindow().getDecorView().removeOnLayoutChangeListener(this.ZZv);
            this.ZZv = null;
        }
    }

    private static abstract class pA implements View.OnLayoutChangeListener {
        private int Og;
        private int pA;

        abstract void pA(int i, int i2);

        private pA() {
        }

        @Override // android.view.View.OnLayoutChangeListener
        public void onLayoutChange(View view, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
            int i9 = i3 - i;
            int i10 = i4 - i2;
            if (i9 == this.pA && i10 == this.Og) {
                return;
            }
            this.pA = i9;
            this.Og = i10;
            pA(i9, i10);
        }
    }
}
