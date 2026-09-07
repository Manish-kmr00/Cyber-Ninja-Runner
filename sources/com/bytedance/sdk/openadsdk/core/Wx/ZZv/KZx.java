package com.bytedance.sdk.openadsdk.core.Wx.ZZv;

import com.bykv.vk.openvk.pA.pA.Og.ZZv.ZZv;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes4.dex */
public class KZx extends ZZv {
    private final pA ZZv;
    private final List<Og> pA = Collections.synchronizedList(new ArrayList());
    private int Og = 1;
    private int KZx = 1;

    public interface Og extends com.bykv.vk.openvk.pA.pA.pA.pA.InterfaceC0161pA {
        void pA(int i, int i2);
    }

    static /* synthetic */ int pA(KZx kZx) {
        int i = kZx.KZx;
        kZx.KZx = i + 1;
        return i;
    }

    public KZx() {
        pA pAVar = new pA();
        this.ZZv = pAVar;
        super.pA(pAVar);
        pA(500);
    }

    @Override // com.bykv.vk.openvk.pA.pA.Og.ZZv.ZZv
    public long oX() {
        return super.oX() * ((long) this.Og);
    }

    @Override // com.bykv.vk.openvk.pA.pA.Og.ZZv.ZZv
    public long aBv() {
        return super.aBv() + (((long) (this.KZx - 1)) * super.oX());
    }

    public void KZx(int i) {
        this.Og = Math.max(1, i);
    }

    @Override // com.bykv.vk.openvk.pA.pA.Og.ZZv.ZZv
    public void pA(com.bykv.vk.openvk.pA.pA.pA.pA.InterfaceC0161pA interfaceC0161pA) {
        if (interfaceC0161pA instanceof Og) {
            if (this.pA.contains(interfaceC0161pA)) {
                return;
            }
            this.pA.add((Og) interfaceC0161pA);
            return;
        }
        super.pA(interfaceC0161pA);
    }

    public int vZF() {
        return this.KZx;
    }

    private class pA implements com.bykv.vk.openvk.pA.pA.pA.pA.InterfaceC0161pA {
        private pA() {
        }

        @Override // com.bykv.vk.openvk.pA.pA.pA.pA.InterfaceC0161pA
        public void pA(com.bykv.vk.openvk.pA.pA.pA.pA pAVar) {
            KZx.pA(KZx.this);
            if (KZx.this.KZx <= KZx.this.Og) {
                Iterator it = KZx.this.pA.iterator();
                while (it.hasNext()) {
                    ((Og) it.next()).pA(KZx.this.KZx, KZx.this.Og);
                }
                KZx.this.Bzk();
                return;
            }
            Iterator it2 = KZx.this.pA.iterator();
            while (it2.hasNext()) {
                ((Og) it2.next()).pA(pAVar);
            }
        }

        @Override // com.bykv.vk.openvk.pA.pA.pA.pA.InterfaceC0161pA
        public void pA(com.bykv.vk.openvk.pA.pA.pA.pA pAVar, long j) {
            Iterator it = KZx.this.pA.iterator();
            while (it.hasNext()) {
                ((Og) it.next()).pA(pAVar, j);
            }
        }

        @Override // com.bykv.vk.openvk.pA.pA.pA.pA.InterfaceC0161pA
        public void Og(com.bykv.vk.openvk.pA.pA.pA.pA pAVar) {
            Iterator it = KZx.this.pA.iterator();
            while (it.hasNext()) {
                ((Og) it.next()).Og(pAVar);
            }
        }

        @Override // com.bykv.vk.openvk.pA.pA.pA.pA.InterfaceC0161pA
        public void pA(com.bykv.vk.openvk.pA.pA.pA.pA pAVar, com.bykv.vk.openvk.pA.pA.pA.KZx.pA pAVar2) {
            Iterator it = KZx.this.pA.iterator();
            while (it.hasNext()) {
                ((Og) it.next()).pA(pAVar, pAVar2);
            }
        }

        @Override // com.bykv.vk.openvk.pA.pA.pA.pA.InterfaceC0161pA
        public void pA(com.bykv.vk.openvk.pA.pA.pA.pA pAVar, boolean z) {
            Iterator it = KZx.this.pA.iterator();
            while (it.hasNext()) {
                ((Og) it.next()).pA(pAVar, z);
            }
        }

        @Override // com.bykv.vk.openvk.pA.pA.pA.pA.InterfaceC0161pA
        public void KZx(com.bykv.vk.openvk.pA.pA.pA.pA pAVar) {
            Iterator it = KZx.this.pA.iterator();
            while (it.hasNext()) {
                ((Og) it.next()).KZx(pAVar);
            }
        }

        @Override // com.bykv.vk.openvk.pA.pA.pA.pA.InterfaceC0161pA
        public void pA(com.bykv.vk.openvk.pA.pA.pA.pA pAVar, int i, int i2) {
            Iterator it = KZx.this.pA.iterator();
            while (it.hasNext()) {
                ((Og) it.next()).pA(pAVar, i, i2);
            }
        }

        @Override // com.bykv.vk.openvk.pA.pA.pA.pA.InterfaceC0161pA
        public void pA(com.bykv.vk.openvk.pA.pA.pA.pA pAVar, int i, int i2, int i3) {
            Iterator it = KZx.this.pA.iterator();
            while (it.hasNext()) {
                ((Og) it.next()).pA(pAVar, i, i2, i3);
            }
        }

        @Override // com.bykv.vk.openvk.pA.pA.pA.pA.InterfaceC0161pA
        public void pA(com.bykv.vk.openvk.pA.pA.pA.pA pAVar, int i) {
            Iterator it = KZx.this.pA.iterator();
            while (it.hasNext()) {
                ((Og) it.next()).pA(pAVar, i);
            }
        }

        @Override // com.bykv.vk.openvk.pA.pA.pA.pA.InterfaceC0161pA
        public void Og(com.bykv.vk.openvk.pA.pA.pA.pA pAVar, int i) {
            Iterator it = KZx.this.pA.iterator();
            while (it.hasNext()) {
                ((Og) it.next()).Og(pAVar, i);
            }
        }

        @Override // com.bykv.vk.openvk.pA.pA.pA.pA.InterfaceC0161pA
        public void pA(com.bykv.vk.openvk.pA.pA.pA.pA pAVar, long j, long j2) {
            Iterator it = KZx.this.pA.iterator();
            while (it.hasNext()) {
                ((Og) it.next()).pA(pAVar, j, j2);
            }
        }

        @Override // com.bykv.vk.openvk.pA.pA.pA.pA.InterfaceC0161pA
        public void ZZv(com.bykv.vk.openvk.pA.pA.pA.pA pAVar) {
            Iterator it = KZx.this.pA.iterator();
            while (it.hasNext()) {
                ((Og) it.next()).ZZv(pAVar);
            }
        }

        @Override // com.bykv.vk.openvk.pA.pA.pA.pA.InterfaceC0161pA
        public void ML(com.bykv.vk.openvk.pA.pA.pA.pA pAVar) {
            Iterator it = KZx.this.pA.iterator();
            while (it.hasNext()) {
                ((Og) it.next()).ML(pAVar);
            }
        }
    }
}
