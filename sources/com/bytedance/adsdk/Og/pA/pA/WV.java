package com.bytedance.adsdk.Og.pA.pA;

import android.graphics.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

/* JADX INFO: loaded from: classes9.dex */
public class WV implements SGo, Wx {
    private final com.bytedance.adsdk.Og.KZx.Og.Bzk JG;
    private final String ZZv;
    private final Path pA = new Path();
    private final Path Og = new Path();
    private final Path KZx = new Path();
    private final List<Wx> ML = new ArrayList();

    public WV(com.bytedance.adsdk.Og.KZx.Og.Bzk bzk) {
        this.ZZv = bzk.pA();
        this.JG = bzk;
    }

    @Override // com.bytedance.adsdk.Og.pA.pA.SGo
    public void pA(ListIterator<KZx> listIterator) {
        while (listIterator.hasPrevious() && listIterator.previous() != this) {
        }
        while (listIterator.hasPrevious()) {
            KZx kZxPrevious = listIterator.previous();
            if (kZxPrevious instanceof Wx) {
                this.ML.add((Wx) kZxPrevious);
                listIterator.remove();
            }
        }
    }

    @Override // com.bytedance.adsdk.Og.pA.pA.KZx
    public void pA(List<KZx> list, List<KZx> list2) {
        for (int i = 0; i < this.ML.size(); i++) {
            this.ML.get(i).pA(list, list2);
        }
    }

    @Override // com.bytedance.adsdk.Og.pA.pA.Wx
    public Path ZZv() {
        this.KZx.reset();
        if (this.JG.KZx()) {
            return this.KZx;
        }
        int i = AnonymousClass1.pA[this.JG.Og().ordinal()];
        if (i == 1) {
            pA();
        } else if (i == 2) {
            pA(Path.Op.UNION);
        } else if (i == 3) {
            pA(Path.Op.REVERSE_DIFFERENCE);
        } else if (i == 4) {
            pA(Path.Op.INTERSECT);
        } else if (i == 5) {
            pA(Path.Op.XOR);
        }
        return this.KZx;
    }

    /* JADX INFO: renamed from: com.bytedance.adsdk.Og.pA.pA.WV$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] pA;

        static {
            int[] iArr = new int[com.bytedance.adsdk.Og.KZx.Og.Bzk.pA.values().length];
            pA = iArr;
            try {
                iArr[com.bytedance.adsdk.Og.KZx.Og.Bzk.pA.MERGE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                pA[com.bytedance.adsdk.Og.KZx.Og.Bzk.pA.ADD.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                pA[com.bytedance.adsdk.Og.KZx.Og.Bzk.pA.SUBTRACT.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                pA[com.bytedance.adsdk.Og.KZx.Og.Bzk.pA.INTERSECT.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                pA[com.bytedance.adsdk.Og.KZx.Og.Bzk.pA.EXCLUDE_INTERSECTIONS.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
        }
    }

    private void pA() {
        for (int i = 0; i < this.ML.size(); i++) {
            this.KZx.addPath(this.ML.get(i).ZZv());
        }
    }

    private void pA(Path.Op op) {
        this.Og.reset();
        this.pA.reset();
        for (int size = this.ML.size() - 1; size > 0; size--) {
            Wx wx = this.ML.get(size);
            if (wx instanceof ZZv) {
                ZZv zZv = (ZZv) wx;
                List<Wx> listOg = zZv.Og();
                for (int size2 = listOg.size() - 1; size2 >= 0; size2--) {
                    Path pathZZv = listOg.get(size2).ZZv();
                    pathZZv.transform(zZv.KZx());
                    this.Og.addPath(pathZZv);
                }
            } else {
                this.Og.addPath(wx.ZZv());
            }
        }
        Wx wx2 = this.ML.get(0);
        if (wx2 instanceof ZZv) {
            ZZv zZv2 = (ZZv) wx2;
            List<Wx> listOg2 = zZv2.Og();
            for (int i = 0; i < listOg2.size(); i++) {
                Path pathZZv2 = listOg2.get(i).ZZv();
                pathZZv2.transform(zZv2.KZx());
                this.pA.addPath(pathZZv2);
            }
        } else {
            this.pA.set(wx2.ZZv());
        }
        this.KZx.op(this.pA, this.Og, op);
    }
}
