package com.bytedance.sdk.component.ML.KZx;

import android.graphics.Bitmap;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.util.Log;
import android.widget.ImageView;
import com.bytedance.sdk.component.ML.BSW;
import com.bytedance.sdk.component.ML.Bzk;
import com.bytedance.sdk.component.ML.SGo;
import com.bytedance.sdk.component.ML.Sn;
import com.bytedance.sdk.component.ML.oX;
import com.bytedance.sdk.component.ML.vZF;
import java.io.File;
import java.lang.ref.WeakReference;
import java.util.Queue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import java.util.concurrent.LinkedBlockingQueue;

/* JADX INFO: loaded from: classes7.dex */
public class KZx implements Bzk {
    private JG BF;
    private int BSW;
    private int Bzk;
    private boolean DX;
    private boolean IG;
    private ImageView.ScaleType JG;
    private String KZx;
    private oX ML;
    private ExecutorService Mc;
    private String Og;
    private Bitmap.Config SD;
    private com.bytedance.sdk.component.ML.omh SGo;
    private com.bytedance.sdk.component.ML.SD Sd;
    private boolean Sn;
    private com.bytedance.sdk.component.ML.Og TV;
    private int TX;
    private com.bytedance.sdk.component.ML.KZx.pA WQf;
    private WeakReference<ImageView> WV;
    private volatile boolean Wx;
    private Queue<com.bytedance.sdk.component.ML.ZZv.Bzk> XT;
    private String ZZv;
    private int aBv;
    private int du;
    private int eG;
    private Sn lT;
    private vZF oX;
    private int omh;
    Future<?> pA;
    private boolean roi;
    private boolean vZF;
    private final Handler yFO;

    private KZx(Og og) {
        this.XT = new LinkedBlockingQueue();
        this.yFO = new Handler(Looper.getMainLooper());
        this.vZF = true;
        this.Og = og.ZZv;
        this.ML = new pA(og.pA);
        this.WV = new WeakReference<>(og.Og);
        this.JG = og.ML;
        this.SD = og.JG;
        this.omh = og.SD;
        this.Bzk = og.omh;
        this.BSW = og.Bzk;
        this.aBv = og.SGo;
        this.oX = og.BSW;
        this.TV = pA(og);
        if (!TextUtils.isEmpty(og.KZx)) {
            Og(og.KZx);
            pA(og.KZx);
        }
        this.Sn = og.WV;
        this.DX = og.Wx;
        this.BF = og.oX;
        this.SGo = og.aBv;
        this.eG = og.yFO;
        this.du = og.XT;
        this.Mc = og.Sd;
        this.roi = og.vZF;
        this.IG = og.TX;
        this.lT = og.BF;
        this.XT.add(new com.bytedance.sdk.component.ML.ZZv.KZx());
    }

    private com.bytedance.sdk.component.ML.Og pA(Og og) {
        if (og.DX != null) {
            return og.DX;
        }
        if (!TextUtils.isEmpty(og.Sn)) {
            return com.bytedance.sdk.component.ML.KZx.pA.pA.pA(new File(og.Sn));
        }
        return com.bytedance.sdk.component.ML.KZx.pA.pA.SD();
    }

    public int SD() {
        return this.du;
    }

    public int omh() {
        return this.eG;
    }

    @Override // com.bytedance.sdk.component.ML.Bzk
    public String pA() {
        return this.Og;
    }

    public oX Bzk() {
        return this.ML;
    }

    public String SGo() {
        return this.ZZv;
    }

    public void pA(String str) {
        this.ZZv = str;
    }

    @Override // com.bytedance.sdk.component.ML.Bzk
    public String ML() {
        return this.KZx;
    }

    @Override // com.bytedance.sdk.component.ML.Bzk
    public Bitmap.Config JG() {
        return this.SD;
    }

    public void Og(String str) {
        WeakReference<ImageView> weakReference = this.WV;
        if (weakReference != null && weakReference.get() != null) {
            this.WV.get().setTag(1094453505, str);
        }
        this.KZx = str;
    }

    @Override // com.bytedance.sdk.component.ML.Bzk
    public ImageView.ScaleType ZZv() {
        return this.JG;
    }

    public Bitmap.Config BSW() {
        return this.SD;
    }

    @Override // com.bytedance.sdk.component.ML.Bzk
    public int Og() {
        return this.omh;
    }

    @Override // com.bytedance.sdk.component.ML.Bzk
    public int KZx() {
        return this.Bzk;
    }

    public int WV() {
        return this.BSW;
    }

    public boolean Wx() {
        return this.Sn;
    }

    public boolean Sn() {
        return this.DX;
    }

    public void pA(boolean z) {
        this.vZF = z;
    }

    public boolean DX() {
        return this.vZF;
    }

    public com.bytedance.sdk.component.ML.SD oX() {
        return this.Sd;
    }

    public void pA(com.bytedance.sdk.component.ML.SD sd) {
        this.Sd = sd;
    }

    public int aBv() {
        return this.TX;
    }

    public void pA(int i) {
        this.TX = i;
    }

    public com.bytedance.sdk.component.ML.KZx.pA XT() {
        return this.WQf;
    }

    public void pA(com.bytedance.sdk.component.ML.KZx.pA pAVar) {
        this.WQf = pAVar;
    }

    public JG yFO() {
        return this.BF;
    }

    public com.bytedance.sdk.component.ML.Og vZF() {
        return this.TV;
    }

    public boolean pA(com.bytedance.sdk.component.ML.ZZv.Bzk bzk) {
        if (this.Wx) {
            return false;
        }
        return this.XT.add(bzk);
    }

    public boolean Sd() {
        return this.roi;
    }

    public Sn TX() {
        return this.lT;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Bzk WQf() {
        try {
            JG jg = this.BF;
            if (jg == null) {
                oX oXVar = this.ML;
                if (oXVar != null) {
                    oXVar.pA(1005, "not init !", null);
                }
                return this;
            }
            ExecutorService executorServiceJG = this.Mc == null ? jg.JG() : null;
            Runnable runnable = new Runnable() { // from class: com.bytedance.sdk.component.ML.KZx.KZx.1
                @Override // java.lang.Runnable
                public void run() {
                    com.bytedance.sdk.component.ML.ZZv.Bzk bzk;
                    while (!KZx.this.Wx && (bzk = (com.bytedance.sdk.component.ML.ZZv.Bzk) KZx.this.XT.poll()) != null) {
                        try {
                            if (KZx.this.oX != null) {
                                KZx.this.oX.pA(bzk.pA(), KZx.this);
                            }
                            bzk.pA(KZx.this);
                            if (KZx.this.oX != null) {
                                KZx.this.oX.Og(bzk.pA(), KZx.this);
                            }
                        } catch (Throwable th) {
                            KZx.this.pA(2000, th.getMessage(), th);
                            if (KZx.this.oX != null) {
                                KZx.this.oX.Og("exception", KZx.this);
                                return;
                            }
                            return;
                        }
                    }
                    if (KZx.this.Wx) {
                        KZx.this.pA(1003, "canceled", null);
                    }
                }
            };
            if (this.IG) {
                runnable.run();
            } else {
                ExecutorService executorService = this.Mc;
                if (executorService != null) {
                    this.pA = executorService.submit(runnable);
                } else if (executorServiceJG != null) {
                    this.pA = executorServiceJG.submit(runnable);
                }
            }
            return this;
        } catch (Exception e) {
            Log.e("ImageRequest", e.getMessage());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void pA(int i, String str, Throwable th) {
        new com.bytedance.sdk.component.ML.ZZv.omh(i, str, th).pA(this);
        this.XT.clear();
    }

    public String BF() {
        return ML() + WV();
    }

    public static class Og implements SGo {
        private Sn BF;
        private vZF BSW;
        private com.bytedance.sdk.component.ML.Og DX;
        private Bitmap.Config JG;
        private String KZx;
        private ImageView.ScaleType ML;
        private ImageView Og;
        private int SD;
        private ExecutorService Sd;
        private String Sn;
        private boolean TX;
        private boolean WV;
        private boolean Wx;
        private int XT;
        private String ZZv;
        private com.bytedance.sdk.component.ML.omh aBv;
        private JG oX;
        private int omh;
        private oX pA;
        private boolean vZF;
        private int yFO;
        private int Bzk = 1;
        private int SGo = 5;

        public Og(JG jg) {
            this.oX = jg;
        }

        public SGo KZx(String str) {
            this.ZZv = str;
            return this;
        }

        @Override // com.bytedance.sdk.component.ML.SGo
        public SGo pA(String str) {
            this.KZx = str;
            return this;
        }

        @Override // com.bytedance.sdk.component.ML.SGo
        public SGo pA(ImageView.ScaleType scaleType) {
            this.ML = scaleType;
            return this;
        }

        @Override // com.bytedance.sdk.component.ML.SGo
        public SGo pA(Bitmap.Config config) {
            this.JG = config;
            return this;
        }

        @Override // com.bytedance.sdk.component.ML.SGo
        public SGo pA(int i) {
            this.SD = i;
            return this;
        }

        @Override // com.bytedance.sdk.component.ML.SGo
        public SGo Og(int i) {
            this.omh = i;
            return this;
        }

        @Override // com.bytedance.sdk.component.ML.SGo
        public SGo KZx(int i) {
            this.Bzk = i;
            return this;
        }

        @Override // com.bytedance.sdk.component.ML.SGo
        public SGo pA(vZF vzf) {
            this.BSW = vzf;
            return this;
        }

        @Override // com.bytedance.sdk.component.ML.SGo
        public SGo pA(boolean z) {
            this.Wx = z;
            return this;
        }

        @Override // com.bytedance.sdk.component.ML.SGo
        public SGo Og(String str) {
            this.Sn = str;
            return this;
        }

        @Override // com.bytedance.sdk.component.ML.SGo
        public Bzk pA(oX oXVar, int i) {
            this.SGo = i;
            return pA(oXVar);
        }

        @Override // com.bytedance.sdk.component.ML.SGo
        public Bzk pA(oX oXVar) {
            this.pA = oXVar;
            return new KZx(this).WQf();
        }

        @Override // com.bytedance.sdk.component.ML.SGo
        public Bzk pA(ImageView imageView) {
            this.Og = imageView;
            return new KZx(this).WQf();
        }

        @Override // com.bytedance.sdk.component.ML.SGo
        public SGo pA(com.bytedance.sdk.component.ML.omh omhVar) {
            this.aBv = omhVar;
            return this;
        }

        @Override // com.bytedance.sdk.component.ML.SGo
        public SGo ZZv(int i) {
            this.XT = i;
            return this;
        }

        @Override // com.bytedance.sdk.component.ML.SGo
        public SGo ML(int i) {
            this.yFO = i;
            return this;
        }
    }

    private class pA implements oX {
        private oX Og;

        public pA(oX oXVar) {
            this.Og = oXVar;
        }

        @Override // com.bytedance.sdk.component.ML.oX
        public void pA(final BSW bsw) {
            final ImageView imageView = (ImageView) KZx.this.WV.get();
            if (imageView != null && KZx.this.BSW != 3 && pA(imageView) && (bsw.Og() instanceof Bitmap)) {
                final Bitmap bitmap = (Bitmap) bsw.Og();
                KZx.this.yFO.post(new Runnable() { // from class: com.bytedance.sdk.component.ML.KZx.KZx.pA.1
                    @Override // java.lang.Runnable
                    public void run() {
                        imageView.setImageBitmap(bitmap);
                    }
                });
            }
            try {
                if (KZx.this.SGo != null && (bsw.Og() instanceof Bitmap)) {
                    com.bytedance.sdk.component.ML.omh omhVar = KZx.this.SGo;
                    Bitmap bitmap2 = (Bitmap) bsw.Og();
                    Bitmap bitmapPA = omhVar.pA(bitmap2);
                    if (bitmapPA != null) {
                        bsw.pA(bitmapPA);
                    }
                }
            } catch (Throwable unused) {
            }
            if (KZx.this.aBv == 5) {
                KZx.this.yFO.postAtFrontOfQueue(new Runnable() { // from class: com.bytedance.sdk.component.ML.KZx.KZx.pA.2
                    @Override // java.lang.Runnable
                    public void run() {
                        if (pA.this.Og != null) {
                            pA.this.Og.pA(bsw);
                        }
                    }
                });
                return;
            }
            oX oXVar = this.Og;
            if (oXVar != null) {
                oXVar.pA(bsw);
            }
        }

        private boolean pA(ImageView imageView) {
            Object tag;
            return (imageView == null || (tag = imageView.getTag(1094453505)) == null || !tag.equals(KZx.this.KZx)) ? false : true;
        }

        @Override // com.bytedance.sdk.component.ML.oX
        public void pA(final int i, final String str, final Throwable th) {
            if (KZx.this.aBv == 5) {
                KZx.this.yFO.post(new Runnable() { // from class: com.bytedance.sdk.component.ML.KZx.KZx.pA.3
                    @Override // java.lang.Runnable
                    public void run() {
                        if (pA.this.Og != null) {
                            pA.this.Og.pA(i, str, th);
                        }
                    }
                });
                return;
            }
            oX oXVar = this.Og;
            if (oXVar != null) {
                oXVar.pA(i, str, th);
            }
        }
    }
}
