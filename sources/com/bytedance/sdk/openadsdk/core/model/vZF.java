package com.bytedance.sdk.openadsdk.core.model;

import com.bytedance.sdk.openadsdk.AdSlot;
import com.bytedance.sdk.openadsdk.FilterWord;
import com.bytedance.sdk.openadsdk.utils.qmB;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes6.dex */
public class vZF extends yFO {
    private yFO BSW;
    private final pA SGo;
    private boolean WV;

    @Override // com.bytedance.sdk.openadsdk.core.model.yFO
    public void Bzk(boolean z) {
    }

    public vZF(pA pAVar) {
        this.SGo = pAVar;
        this.BSW = pAVar.JG();
    }

    @Override // com.bytedance.sdk.openadsdk.core.model.yFO
    public String JG() {
        return this.BSW.JG();
    }

    @Override // com.bytedance.sdk.openadsdk.core.model.yFO
    public void ML(String str) {
        this.BSW.ML(str);
    }

    @Override // com.bytedance.sdk.openadsdk.core.model.yFO
    public String SD() {
        return this.BSW.SD();
    }

    @Override // com.bytedance.sdk.openadsdk.core.model.yFO
    public void JG(String str) {
        this.BSW.JG(str);
    }

    @Override // com.bytedance.sdk.openadsdk.core.model.yFO
    public boolean omh() {
        return this.BSW.omh();
    }

    public pA xoO() {
        return this.SGo;
    }

    public boolean PF() {
        return this.SGo.SD();
    }

    public pA.C0245pA pUz() {
        return this.SGo.Bzk();
    }

    public List<yFO> tfE() {
        List<yFO> listZZv = this.SGo.ZZv();
        return listZZv != null ? listZZv : new ArrayList();
    }

    @Override // com.bytedance.sdk.openadsdk.core.model.yFO
    public XT Bzk() {
        return this.BSW.Bzk();
    }

    @Override // com.bytedance.sdk.openadsdk.core.model.yFO
    public void pA(ML ml) {
        this.BSW.pA(ml);
    }

    @Override // com.bytedance.sdk.openadsdk.core.model.yFO
    public ML BSW() {
        return this.BSW.BSW();
    }

    @Override // com.bytedance.sdk.openadsdk.core.model.yFO
    public void pA(XT xt) {
        this.BSW.pA(xt);
    }

    @Override // com.bytedance.sdk.openadsdk.core.model.yFO
    public void pA(oX oXVar) {
        this.BSW.pA(oXVar);
    }

    @Override // com.bytedance.sdk.openadsdk.core.model.yFO
    public oX SGo() {
        return this.BSW.SGo();
    }

    @Override // com.bytedance.sdk.openadsdk.core.model.yFO
    public ZZv WV() {
        return this.BSW.WV();
    }

    @Override // com.bytedance.sdk.openadsdk.core.model.yFO
    public void pA(ZZv zZv) {
        this.BSW.pA(zZv);
    }

    @Override // com.bytedance.sdk.openadsdk.core.model.yFO
    public int Wx() {
        return this.BSW.Wx();
    }

    @Override // com.bytedance.sdk.openadsdk.core.model.yFO
    public int Sn() {
        return this.BSW.Sn();
    }

    @Override // com.bytedance.sdk.openadsdk.core.model.yFO
    public long DX() {
        return this.BSW.DX();
    }

    @Override // com.bytedance.sdk.openadsdk.core.model.yFO
    public WQf oX() {
        return this.BSW.oX();
    }

    @Override // com.bytedance.sdk.openadsdk.core.model.yFO
    public void pA(WQf wQf) {
        this.BSW.pA(wQf);
    }

    @Override // com.bytedance.sdk.openadsdk.core.model.yFO
    public int aBv() {
        return this.BSW.aBv();
    }

    @Override // com.bytedance.sdk.openadsdk.core.model.yFO
    public void pA(int i) {
        this.BSW.pA(i);
    }

    @Override // com.bytedance.sdk.openadsdk.core.model.yFO
    public int XT() {
        return this.BSW.XT();
    }

    @Override // com.bytedance.sdk.openadsdk.core.model.yFO
    public void Og(int i) {
        this.BSW.Og(i);
    }

    @Override // com.bytedance.sdk.openadsdk.core.model.yFO
    public void pA(int i, int i2) {
        this.BSW.pA(i, i2);
    }

    @Override // com.bytedance.sdk.openadsdk.core.model.yFO
    public int yFO() {
        return this.BSW.yFO();
    }

    @Override // com.bytedance.sdk.openadsdk.core.model.yFO
    public void pA(double d) {
        this.BSW.pA(d);
    }

    @Override // com.bytedance.sdk.openadsdk.core.model.yFO
    public int vZF() {
        return this.BSW.vZF();
    }

    @Override // com.bytedance.sdk.openadsdk.core.model.yFO
    public void Og(double d) {
        this.BSW.Og(d);
    }

    @Override // com.bytedance.sdk.openadsdk.core.model.yFO
    public String Sd() {
        return this.BSW.Sd();
    }

    @Override // com.bytedance.sdk.openadsdk.core.model.yFO
    public void SD(String str) {
        this.BSW.SD(str);
    }

    @Override // com.bytedance.sdk.openadsdk.core.model.yFO
    public int TX() {
        return this.BSW.TX();
    }

    @Override // com.bytedance.sdk.openadsdk.core.model.yFO
    public void KZx(int i) {
        this.BSW.KZx(i);
    }

    @Override // com.bytedance.sdk.openadsdk.core.model.yFO
    public int BF() {
        return this.BSW.BF();
    }

    @Override // com.bytedance.sdk.openadsdk.core.model.yFO
    public void ZZv(int i) {
        this.BSW.ZZv(i);
    }

    @Override // com.bytedance.sdk.openadsdk.core.model.yFO
    public void ML(int i) {
        this.BSW.ML(i);
    }

    @Override // com.bytedance.sdk.openadsdk.core.model.yFO
    public void omh(String str) {
        this.BSW.omh(str);
    }

    @Override // com.bytedance.sdk.openadsdk.core.model.yFO
    public boolean WQf() {
        return this.BSW.WQf();
    }

    @Override // com.bytedance.sdk.openadsdk.core.model.yFO
    public int TV() {
        return this.BSW.TV();
    }

    @Override // com.bytedance.sdk.openadsdk.core.model.yFO
    public void JG(int i) {
        this.BSW.JG(i);
    }

    @Override // com.bytedance.sdk.openadsdk.core.model.yFO
    public int du() {
        return this.BSW.du();
    }

    @Override // com.bytedance.sdk.openadsdk.core.model.yFO
    public void SD(int i) {
        this.BSW.SD(i);
    }

    @Override // com.bytedance.sdk.openadsdk.core.model.yFO
    public int eG() {
        return this.BSW.eG();
    }

    @Override // com.bytedance.sdk.openadsdk.core.model.yFO
    public void omh(int i) {
        this.BSW.omh(i);
    }

    @Override // com.bytedance.sdk.openadsdk.core.model.yFO
    public String roi() {
        return this.BSW.roi();
    }

    @Override // com.bytedance.sdk.openadsdk.core.model.yFO
    public void Bzk(String str) {
        this.BSW.Bzk(str);
    }

    @Override // com.bytedance.sdk.openadsdk.core.model.yFO
    public int Mc() {
        return this.BSW.Mc();
    }

    @Override // com.bytedance.sdk.openadsdk.core.model.yFO
    public void Bzk(int i) {
        this.BSW.Bzk(i);
    }

    @Override // com.bytedance.sdk.openadsdk.core.model.yFO
    public void SGo(int i) {
        this.BSW.SGo(i);
    }

    @Override // com.bytedance.sdk.openadsdk.core.model.yFO
    public int IG() {
        return this.BSW.IG();
    }

    @Override // com.bytedance.sdk.openadsdk.core.model.yFO
    public void BSW(int i) {
        this.BSW.BSW(i);
    }

    @Override // com.bytedance.sdk.openadsdk.core.model.yFO
    public Bzk lT() {
        return this.BSW.lT();
    }

    @Override // com.bytedance.sdk.openadsdk.core.model.yFO
    public void pA(Bzk bzk) {
        this.BSW.pA(bzk);
    }

    @Override // com.bytedance.sdk.openadsdk.core.model.yFO
    public AdSlot rB() {
        return this.BSW.rB();
    }

    @Override // com.bytedance.sdk.openadsdk.core.model.yFO
    public void pA(AdSlot adSlot) {
        this.BSW.pA(adSlot);
    }

    @Override // com.bytedance.sdk.openadsdk.core.model.yFO
    public void WV(int i) {
        this.BSW.WV(i);
    }

    @Override // com.bytedance.sdk.openadsdk.core.model.yFO
    public int xy() {
        return this.BSW.xy();
    }

    @Override // com.bytedance.sdk.openadsdk.core.model.yFO
    public void Wx(int i) {
        this.BSW.Wx(i);
    }

    @Override // com.bytedance.sdk.openadsdk.core.model.yFO
    public void Sn(int i) {
        this.BSW.Sn(i);
    }

    @Override // com.bytedance.sdk.openadsdk.core.model.yFO
    public void DX(int i) {
        this.BSW.DX(i);
    }

    @Override // com.bytedance.sdk.openadsdk.core.model.yFO
    public void oX(int i) {
        this.BSW.oX(i);
    }

    @Override // com.bytedance.sdk.openadsdk.core.model.yFO
    public String qmB() {
        return this.BSW.qmB();
    }

    @Override // com.bytedance.sdk.openadsdk.core.model.yFO
    public void SGo(String str) {
        this.BSW.SGo(str);
    }

    @Override // com.bytedance.sdk.openadsdk.core.model.yFO
    public boolean gbA() {
        return this.BSW.gbA();
    }

    @Override // com.bytedance.sdk.openadsdk.core.model.yFO
    public int Vgu() {
        return this.BSW.Vgu();
    }

    @Override // com.bytedance.sdk.openadsdk.core.model.yFO
    public void aBv(int i) {
        this.BSW.aBv(i);
    }

    @Override // com.bytedance.sdk.openadsdk.core.model.yFO
    public yFO.pA CIG() {
        return this.BSW.CIG();
    }

    @Override // com.bytedance.sdk.openadsdk.core.model.yFO
    public void pA(yFO.pA pAVar) {
        this.BSW.pA(pAVar);
    }

    @Override // com.bytedance.sdk.openadsdk.core.model.yFO
    public void pA(eG eGVar) {
        this.BSW.pA(eGVar);
    }

    @Override // com.bytedance.sdk.openadsdk.core.model.yFO
    public boolean SzT() {
        return this.BSW.SzT();
    }

    @Override // com.bytedance.sdk.openadsdk.core.model.yFO
    public void Og(JSONObject jSONObject) {
        this.BSW.Og(jSONObject);
    }

    @Override // com.bytedance.sdk.openadsdk.core.model.yFO
    public eG FQ() {
        return this.BSW.FQ();
    }

    @Override // com.bytedance.sdk.openadsdk.core.model.yFO
    public int Gx() {
        return this.BSW.Gx();
    }

    @Override // com.bytedance.sdk.openadsdk.core.model.yFO
    public com.bykv.vk.openvk.pA.pA.pA.KZx.Og Bf() {
        return this.BSW.Bf();
    }

    @Override // com.bytedance.sdk.openadsdk.core.model.yFO
    public void pA(com.bykv.vk.openvk.pA.pA.pA.KZx.Og og) {
        this.BSW.pA(og);
    }

    @Override // com.bytedance.sdk.openadsdk.core.model.yFO
    public void pA(WV wv) {
        this.BSW.pA(wv);
    }

    @Override // com.bytedance.sdk.openadsdk.core.model.yFO
    public String HSv() {
        return this.BSW.HSv();
    }

    @Override // com.bytedance.sdk.openadsdk.core.model.yFO
    public void BSW(String str) {
        this.BSW.BSW(str);
    }

    @Override // com.bytedance.sdk.openadsdk.core.model.yFO
    public void WV(String str) {
        this.BSW.WV(str);
    }

    @Override // com.bytedance.sdk.openadsdk.core.model.yFO
    public int JBA() {
        return this.BSW.JBA();
    }

    @Override // com.bytedance.sdk.openadsdk.core.model.yFO
    public boolean agB() {
        return this.BSW.agB();
    }

    @Override // com.bytedance.sdk.openadsdk.core.model.yFO
    public void XT(int i) {
        this.BSW.XT(i);
    }

    @Override // com.bytedance.sdk.openadsdk.core.model.yFO
    public void yFO(int i) {
        this.BSW.yFO(i);
    }

    @Override // com.bytedance.sdk.openadsdk.core.model.yFO
    public boolean fN() {
        return this.BSW.fN();
    }

    @Override // com.bytedance.sdk.openadsdk.core.model.yFO
    public void vZF(int i) {
        this.BSW.vZF(i);
    }

    @Override // com.bytedance.sdk.openadsdk.core.model.yFO
    public void Sd(int i) {
        this.BSW.Sd(i);
    }

    @Override // com.bytedance.sdk.openadsdk.core.model.yFO
    public int dmv() {
        return this.BSW.dmv();
    }

    @Override // com.bytedance.sdk.openadsdk.core.model.yFO
    public DX fJy() {
        return this.BSW.fJy();
    }

    @Override // com.bytedance.sdk.openadsdk.core.model.yFO
    public void pA(DX dx) {
        this.BSW.pA(dx);
    }

    @Override // com.bytedance.sdk.openadsdk.core.model.yFO
    public DX YkC() {
        return this.BSW.YkC();
    }

    @Override // com.bytedance.sdk.openadsdk.core.model.yFO
    public void Og(DX dx) {
        this.BSW.Og(dx);
    }

    @Override // com.bytedance.sdk.openadsdk.core.model.yFO
    public String dC() {
        return this.BSW.dC();
    }

    @Override // com.bytedance.sdk.openadsdk.core.model.yFO
    public void Wx(String str) {
        this.BSW.Wx(str);
    }

    @Override // com.bytedance.sdk.openadsdk.core.model.yFO
    public List<DX> IIF() {
        return this.BSW.IIF();
    }

    @Override // com.bytedance.sdk.openadsdk.core.model.yFO
    public void KZx(DX dx) {
        this.BSW.KZx(dx);
    }

    @Override // com.bytedance.sdk.openadsdk.core.model.yFO
    public String vA() {
        return this.BSW.vA();
    }

    @Override // com.bytedance.sdk.openadsdk.core.model.yFO
    public void Sn(String str) {
        this.BSW.Sn(str);
    }

    @Override // com.bytedance.sdk.openadsdk.core.model.yFO
    public long Kj() {
        return this.BSW.Kj();
    }

    @Override // com.bytedance.sdk.openadsdk.core.model.yFO
    public List<String> PV() {
        return this.BSW.PV();
    }

    @Override // com.bytedance.sdk.openadsdk.core.model.yFO
    public List<String> cFQ() {
        return this.BSW.cFQ();
    }

    @Override // com.bytedance.sdk.openadsdk.core.model.yFO
    public List<String> lx() {
        return this.BSW.lx();
    }

    @Override // com.bytedance.sdk.openadsdk.core.model.yFO
    public String SXO() {
        return this.BSW.SXO();
    }

    @Override // com.bytedance.sdk.openadsdk.core.model.yFO
    public void DX(String str) {
        this.BSW.DX(str);
    }

    @Override // com.bytedance.sdk.openadsdk.core.model.yFO
    public String fw() {
        return this.BSW.fw();
    }

    @Override // com.bytedance.sdk.openadsdk.core.model.yFO
    public void oX(String str) {
        this.BSW.oX(str);
    }

    @Override // com.bytedance.sdk.openadsdk.core.model.yFO
    public String gy() {
        return this.BSW.gy();
    }

    @Override // com.bytedance.sdk.openadsdk.core.model.yFO
    public void aBv(String str) {
        this.BSW.aBv(str);
    }

    @Override // com.bytedance.sdk.openadsdk.core.model.yFO
    public String nCO() {
        return this.BSW.nCO();
    }

    @Override // com.bytedance.sdk.openadsdk.core.model.yFO
    public void XT(String str) {
        this.BSW.XT(str);
    }

    @Override // com.bytedance.sdk.openadsdk.core.model.yFO
    public String bU() {
        return this.BSW.bU();
    }

    @Override // com.bytedance.sdk.openadsdk.core.model.yFO
    public void yFO(String str) {
        this.BSW.yFO(str);
    }

    @Override // com.bytedance.sdk.openadsdk.core.model.yFO
    public KZx Wo() {
        return this.BSW.Wo();
    }

    @Override // com.bytedance.sdk.openadsdk.core.model.yFO
    public void pA(KZx kZx) {
        this.BSW.pA(kZx);
    }

    @Override // com.bytedance.sdk.openadsdk.core.model.yFO
    public BSW Itl() {
        return this.BSW.Itl();
    }

    @Override // com.bytedance.sdk.openadsdk.core.model.yFO
    public void pA(BSW bsw) {
        this.BSW.pA(bsw);
    }

    @Override // com.bytedance.sdk.openadsdk.core.model.yFO
    public String tM() {
        return this.BSW.tM();
    }

    @Override // com.bytedance.sdk.openadsdk.core.model.yFO
    public void vZF(String str) {
        this.BSW.vZF(str);
    }

    @Override // com.bytedance.sdk.openadsdk.core.model.yFO
    public int RS() {
        return this.BSW.RS();
    }

    @Override // com.bytedance.sdk.openadsdk.core.model.yFO
    public void TX(int i) {
        this.BSW.TX(i);
    }

    @Override // com.bytedance.sdk.openadsdk.core.model.yFO
    public List<FilterWord> QI() {
        return this.BSW.QI();
    }

    @Override // com.bytedance.sdk.openadsdk.core.model.yFO
    public void pA(FilterWord filterWord) {
        this.BSW.pA(filterWord);
    }

    @Override // com.bytedance.sdk.openadsdk.core.model.yFO
    public String Gag() {
        return this.BSW.Gag();
    }

    @Override // com.bytedance.sdk.openadsdk.core.model.yFO
    public void Sd(String str) {
        this.BSW.Sd(str);
    }

    @Override // com.bytedance.sdk.openadsdk.core.model.yFO
    public long Qj() {
        return this.BSW.Qj();
    }

    @Override // com.bytedance.sdk.openadsdk.core.model.yFO
    public void Og(long j) {
        this.BSW.Og(j);
    }

    @Override // com.bytedance.sdk.openadsdk.core.model.yFO
    public void BF(int i) {
        this.BSW.BF(i);
    }

    @Override // com.bytedance.sdk.openadsdk.core.model.yFO
    public boolean sk() {
        return this.BSW.sk();
    }

    @Override // com.bytedance.sdk.openadsdk.core.model.yFO
    public void ZZv(boolean z) {
        this.BSW.ZZv(z);
    }

    @Override // com.bytedance.sdk.openadsdk.core.model.yFO
    public Map<String, Object> tZW() {
        return this.BSW.tZW();
    }

    @Override // com.bytedance.sdk.openadsdk.core.model.yFO
    public void pA(Map<String, Object> map) {
        this.BSW.pA(map);
    }

    @Override // com.bytedance.sdk.openadsdk.core.model.yFO
    public JSONObject Ld() {
        return this.BSW.Ld();
    }

    @Override // com.bytedance.sdk.openadsdk.core.model.yFO
    public void KZx(JSONObject jSONObject) {
        this.BSW.KZx(jSONObject);
    }

    @Override // com.bytedance.sdk.openadsdk.core.model.yFO
    public void TX(String str) {
        this.BSW.TX(str);
    }

    @Override // com.bytedance.sdk.openadsdk.core.model.yFO
    public int rtW() {
        return this.BSW.rtW();
    }

    @Override // com.bytedance.sdk.openadsdk.core.model.yFO
    public void WQf(int i) {
        this.BSW.WQf(i);
    }

    @Override // com.bytedance.sdk.openadsdk.core.model.yFO
    public float slz() {
        return this.BSW.slz();
    }

    @Override // com.bytedance.sdk.openadsdk.core.model.yFO
    public void pA(float f) {
        this.BSW.pA(f);
    }

    public boolean equals(Object obj) {
        return this.BSW.equals(obj);
    }

    public int hashCode() {
        return this.BSW.hashCode();
    }

    @Override // com.bytedance.sdk.openadsdk.core.model.yFO
    public boolean Uz() {
        return this.BSW.Uz();
    }

    @Override // com.bytedance.sdk.openadsdk.core.model.yFO
    public boolean uQ() {
        return this.BSW.uQ();
    }

    @Override // com.bytedance.sdk.openadsdk.core.model.yFO
    public void TV(int i) {
        this.BSW.TV(i);
    }

    @Override // com.bytedance.sdk.openadsdk.core.model.yFO
    public void ZZv(JSONObject jSONObject) {
        this.BSW.ZZv(jSONObject);
    }

    @Override // com.bytedance.sdk.openadsdk.core.model.yFO
    public JSONObject jO() {
        return this.BSW.jO();
    }

    @Override // com.bytedance.sdk.openadsdk.core.model.yFO
    public JSONObject FGT() {
        return this.BSW.FGT();
    }

    @Override // com.bytedance.sdk.openadsdk.core.model.yFO
    public int Lm() {
        return this.BSW.Lm();
    }

    @Override // com.bytedance.sdk.openadsdk.core.model.yFO
    public void du(int i) {
        this.BSW.du(i);
    }

    @Override // com.bytedance.sdk.openadsdk.core.model.yFO
    public int mK() {
        return this.BSW.mK();
    }

    @Override // com.bytedance.sdk.openadsdk.core.model.yFO
    public void eG(int i) {
        this.BSW.eG(i);
    }

    @Override // com.bytedance.sdk.openadsdk.core.model.yFO
    public int guZ() {
        return this.BSW.guZ();
    }

    @Override // com.bytedance.sdk.openadsdk.core.model.yFO
    public void roi(int i) {
        this.BSW.roi(i);
    }

    @Override // com.bytedance.sdk.openadsdk.core.model.yFO
    public int npn() {
        return this.BSW.npn();
    }

    @Override // com.bytedance.sdk.openadsdk.core.model.yFO
    public void Mc(int i) {
        this.BSW.Mc(i);
    }

    @Override // com.bytedance.sdk.openadsdk.core.model.yFO
    public boolean rjD() {
        return this.BSW.rjD();
    }

    @Override // com.bytedance.sdk.openadsdk.core.model.yFO
    public com.bytedance.sdk.openadsdk.core.WV.pA dGZ() {
        return this.BSW.dGZ();
    }

    @Override // com.bytedance.sdk.openadsdk.core.model.yFO
    public void pA(com.bytedance.sdk.openadsdk.core.WV.pA pAVar) {
        this.BSW.pA(pAVar);
    }

    @Override // com.bytedance.sdk.openadsdk.core.model.yFO
    public boolean qQU() {
        return this.BSW.qQU();
    }

    @Override // com.bytedance.sdk.openadsdk.core.model.yFO
    public String Xj() {
        return this.BSW.Xj();
    }

    @Override // com.bytedance.sdk.openadsdk.core.model.yFO
    public void BF(String str) {
        this.BSW.BF(str);
    }

    @Override // com.bytedance.sdk.openadsdk.core.model.yFO
    public int vkV() {
        return this.BSW.vkV();
    }

    @Override // com.bytedance.sdk.openadsdk.core.model.yFO
    public JSONObject PU() {
        return this.BSW.PU();
    }

    @Override // com.bytedance.sdk.openadsdk.core.model.yFO
    public void ML(JSONObject jSONObject) {
        this.BSW.ML(jSONObject);
    }

    @Override // com.bytedance.sdk.openadsdk.core.model.yFO
    public boolean ka() {
        return this.BSW.ka();
    }

    @Override // com.bytedance.sdk.openadsdk.core.model.yFO
    public void IG(int i) {
        this.BSW.IG(i);
    }

    @Override // com.bytedance.sdk.openadsdk.core.model.yFO
    public void uhO() {
        this.BSW.uhO();
    }

    @Override // com.bytedance.sdk.openadsdk.core.model.yFO
    public boolean bA() {
        return this.BSW.bA();
    }

    @Override // com.bytedance.sdk.openadsdk.core.model.yFO
    public int lgT() {
        return this.BSW.lgT();
    }

    @Override // com.bytedance.sdk.openadsdk.core.model.yFO
    public void lT(int i) {
        this.BSW.lT(i);
    }

    @Override // com.bytedance.sdk.openadsdk.core.model.yFO
    public int GbR() {
        return this.BSW.GbR();
    }

    @Override // com.bytedance.sdk.openadsdk.core.model.yFO
    public void rB(int i) {
        this.BSW.rB(i);
    }

    @Override // com.bytedance.sdk.openadsdk.core.model.yFO
    public void pA(Wx wx) {
        this.BSW.pA(wx);
    }

    @Override // com.bytedance.sdk.openadsdk.core.model.yFO
    public Wx aj() {
        return this.BSW.aj();
    }

    @Override // com.bytedance.sdk.openadsdk.core.model.yFO
    public com.bytedance.sdk.component.Bzk.Og.pA BDQ() {
        return this.BSW.BDQ();
    }

    @Override // com.bytedance.sdk.openadsdk.core.model.yFO
    public int FK() {
        return this.BSW.FK();
    }

    @Override // com.bytedance.sdk.openadsdk.core.model.yFO
    public void qmB(int i) {
        this.BSW.qmB(i);
    }

    @Override // com.bytedance.sdk.openadsdk.core.model.yFO
    public int mY() {
        return this.BSW.mY();
    }

    @Override // com.bytedance.sdk.openadsdk.core.model.yFO
    public void gbA(int i) {
        this.BSW.gbA(i);
    }

    @Override // com.bytedance.sdk.openadsdk.core.model.yFO
    public com.bykv.vk.openvk.pA.pA.pA.KZx.Og Tsy() {
        return this.BSW.Tsy();
    }

    @Override // com.bytedance.sdk.openadsdk.core.model.yFO
    public void Og(com.bykv.vk.openvk.pA.pA.pA.KZx.Og og) {
        this.BSW.Og(og);
    }

    @Override // com.bytedance.sdk.openadsdk.core.model.yFO
    public com.bykv.vk.openvk.pA.pA.pA.KZx.Og Qd() {
        return this.BSW.Qd();
    }

    @Override // com.bytedance.sdk.openadsdk.core.model.yFO
    public void KZx(com.bykv.vk.openvk.pA.pA.pA.KZx.Og og) {
        this.BSW.KZx(og);
    }

    @Override // com.bytedance.sdk.openadsdk.core.model.yFO
    public String xt() {
        return this.BSW.xt();
    }

    @Override // com.bytedance.sdk.openadsdk.core.model.yFO
    public void WQf(String str) {
        this.BSW.WQf(str);
    }

    @Override // com.bytedance.sdk.openadsdk.core.model.yFO
    public int HMH() {
        return this.BSW.HMH();
    }

    @Override // com.bytedance.sdk.openadsdk.core.model.yFO
    public void Vgu(int i) {
        this.BSW.Vgu(i);
    }

    @Override // com.bytedance.sdk.openadsdk.core.model.yFO
    public boolean Bpk() {
        return this.BSW.Bpk();
    }

    @Override // com.bytedance.sdk.openadsdk.core.model.yFO
    public JSONObject fg() {
        return this.BSW.fg();
    }

    @Override // com.bytedance.sdk.openadsdk.core.model.yFO
    public int PKZ() {
        return this.BSW.PKZ();
    }

    @Override // com.bytedance.sdk.openadsdk.core.model.yFO
    public int FHA() {
        return this.BSW.FHA();
    }

    @Override // com.bytedance.sdk.openadsdk.core.model.yFO
    public boolean rX() {
        return this.BSW.rX();
    }

    @Override // com.bytedance.sdk.openadsdk.core.model.yFO
    public boolean kK() {
        return this.BSW.kK();
    }

    @Override // com.bytedance.sdk.openadsdk.core.model.yFO
    public boolean EC() {
        return this.BSW.EC();
    }

    @Override // com.bytedance.sdk.openadsdk.core.model.yFO
    public boolean LhC() {
        return this.BSW.LhC();
    }

    @Override // com.bytedance.sdk.openadsdk.core.model.yFO
    public boolean juv() {
        return this.BSW.juv();
    }

    @Override // com.bytedance.sdk.openadsdk.core.model.yFO
    public int Wf() {
        return this.BSW.Wf();
    }

    @Override // com.bytedance.sdk.openadsdk.core.model.yFO
    public double mM() {
        return this.BSW.mM();
    }

    @Override // com.bytedance.sdk.openadsdk.core.model.yFO
    public String TV(String str) {
        return this.BSW.TV(str);
    }

    @Override // com.bytedance.sdk.openadsdk.core.model.yFO
    public String jK() {
        return this.BSW.jK();
    }

    @Override // com.bytedance.sdk.openadsdk.core.model.yFO
    public String Ij() {
        return this.BSW.Ij();
    }

    @Override // com.bytedance.sdk.openadsdk.core.model.yFO
    public boolean qH() {
        return this.BSW.qH();
    }

    @Override // com.bytedance.sdk.openadsdk.core.model.yFO
    public int Lf() {
        return this.BSW.Lf();
    }

    @Override // com.bytedance.sdk.openadsdk.core.model.yFO
    public void CIG(int i) {
        this.BSW.CIG(i);
    }

    @Override // com.bytedance.sdk.openadsdk.core.model.yFO
    public boolean le() {
        return this.BSW.le();
    }

    public void JBA(int i) {
        List<yFO> listZZv = this.SGo.ZZv();
        listZZv.size();
        if (i >= listZZv.size()) {
            i = 0;
        } else if (i < 0) {
            return;
        }
        this.BSW = listZZv.get(i);
        this.WV = true;
    }

    public boolean cmu() {
        return this.WV;
    }

    @Override // com.bytedance.sdk.openadsdk.core.model.yFO
    public boolean ZZv() {
        return this.BSW.ZZv();
    }

    @Override // com.bytedance.sdk.openadsdk.core.model.yFO
    public void pA(boolean z) {
        this.BSW.pA(z);
    }

    @Override // com.bytedance.sdk.openadsdk.core.model.yFO
    public boolean ML() {
        return this.BSW.ML();
    }

    @Override // com.bytedance.sdk.openadsdk.core.model.yFO
    public void Og(boolean z) {
        this.BSW.Og(z);
    }

    @Override // com.bytedance.sdk.openadsdk.core.model.yFO
    public void KZx(boolean z) {
        this.BSW.KZx(z);
    }

    @Override // com.bytedance.sdk.openadsdk.core.model.yFO
    public boolean Zc() {
        return this.BSW.Zc();
    }

    @Override // com.bytedance.sdk.openadsdk.core.model.yFO
    public boolean Fb() {
        return this.BSW.Fb();
    }

    @Override // com.bytedance.sdk.openadsdk.core.model.yFO
    public boolean iC() {
        return this.BSW.iC();
    }

    @Override // com.bytedance.sdk.openadsdk.core.model.yFO
    public void xy(int i) {
        this.BSW.xy(i);
    }

    @Override // com.bytedance.sdk.openadsdk.core.model.yFO
    public int sPI() {
        return this.BSW.sPI();
    }

    @Override // com.bytedance.sdk.openadsdk.core.model.yFO
    public boolean Dc() {
        return this.BSW.Dc();
    }

    @Override // com.bytedance.sdk.openadsdk.core.model.yFO
    public qmB ZF() {
        return this.BSW.ZF();
    }

    @Override // com.bytedance.sdk.openadsdk.core.model.yFO
    public long Io() {
        return this.BSW.Io();
    }

    @Override // com.bytedance.sdk.openadsdk.core.model.yFO
    public void KZx(long j) {
        this.BSW.KZx(j);
    }

    @Override // com.bytedance.sdk.openadsdk.core.model.yFO
    public boolean gl() {
        return this.BSW.gl();
    }

    @Override // com.bytedance.sdk.openadsdk.core.model.yFO
    public void JG(boolean z) {
        this.BSW.JG(z);
    }

    @Override // com.bytedance.sdk.openadsdk.core.model.yFO
    public boolean eUc() {
        return this.BSW.eUc();
    }

    @Override // com.bytedance.sdk.openadsdk.core.model.yFO
    public void SD(boolean z) {
        this.BSW.SD(z);
    }

    @Override // com.bytedance.sdk.openadsdk.core.model.yFO
    public void du(String str) {
        this.BSW.du(str);
    }

    @Override // com.bytedance.sdk.openadsdk.core.model.yFO
    public String ged() {
        return this.BSW.ged();
    }

    @Override // com.bytedance.sdk.openadsdk.core.model.yFO
    public void SzT(int i) {
        this.BSW.SzT(i);
    }

    @Override // com.bytedance.sdk.openadsdk.core.model.yFO
    public void eG(String str) {
        this.BSW.eG(str);
    }

    @Override // com.bytedance.sdk.openadsdk.core.model.yFO
    public String ZL() {
        return this.BSW.ZL();
    }

    @Override // com.bytedance.sdk.openadsdk.core.model.yFO
    public String tpV() {
        return this.BSW.tpV();
    }

    @Override // com.bytedance.sdk.openadsdk.core.model.yFO
    public void GL() {
        this.BSW.GL();
    }

    @Override // com.bytedance.sdk.openadsdk.core.model.yFO
    public boolean eD() {
        return this.BSW.eD();
    }

    @Override // com.bytedance.sdk.openadsdk.core.model.yFO
    public com.bytedance.sdk.openadsdk.core.BSW.JG.pA Mx() {
        return this.BSW.Mx();
    }

    @Override // com.bytedance.sdk.openadsdk.core.model.yFO
    public void pA(com.bytedance.sdk.openadsdk.core.BSW.JG.pA pAVar) {
        this.BSW.pA(pAVar);
    }

    @Override // com.bytedance.sdk.openadsdk.core.model.yFO
    public void Og(com.bytedance.sdk.openadsdk.core.BSW.JG.pA pAVar) {
        this.BSW.Og(pAVar);
    }

    @Override // com.bytedance.sdk.openadsdk.core.model.yFO
    public com.bytedance.sdk.openadsdk.core.BSW.JG.pA ZDE() {
        return this.BSW.ZDE();
    }

    @Override // com.bytedance.sdk.openadsdk.core.model.yFO
    public void FQ(int i) {
        this.BSW.FQ(i);
    }

    @Override // com.bytedance.sdk.openadsdk.core.model.yFO
    public int Bi() {
        return this.BSW.Bi();
    }

    @Override // com.bytedance.sdk.openadsdk.core.model.yFO
    public int LAE() {
        return this.BSW.LAE();
    }

    @Override // com.bytedance.sdk.openadsdk.core.model.yFO
    public void Xe() {
        this.BSW.Xe();
    }

    @Override // com.bytedance.sdk.openadsdk.core.model.yFO
    public boolean Evs() {
        return this.BSW.Evs();
    }

    @Override // com.bytedance.sdk.openadsdk.core.model.yFO
    public void hP() {
        this.BSW.hP();
    }

    @Override // com.bytedance.sdk.openadsdk.core.model.yFO
    public boolean DDZ() {
        return this.BSW.DDZ();
    }

    @Override // com.bytedance.sdk.openadsdk.core.model.yFO
    public boolean boc() {
        return this.BSW.boc();
    }

    @Override // com.bytedance.sdk.openadsdk.core.model.yFO
    public void omh(boolean z) {
        this.BSW.omh(z);
    }

    @Override // com.bytedance.sdk.openadsdk.core.model.yFO
    public boolean fS() {
        pA pAVar = this.SGo;
        return pAVar != null && pAVar.WV();
    }

    @Override // com.bytedance.sdk.openadsdk.core.model.yFO
    public void Gx(int i) {
        this.BSW.Gx(i);
    }

    @Override // com.bytedance.sdk.openadsdk.core.model.yFO
    public int vON() {
        return this.BSW.vON();
    }

    @Override // com.bytedance.sdk.openadsdk.core.model.yFO
    public String ZQ() {
        return this.BSW.ZQ();
    }

    @Override // com.bytedance.sdk.openadsdk.core.model.yFO
    public void roi(String str) {
        this.BSW.roi(str);
    }

    @Override // com.bytedance.sdk.openadsdk.core.model.yFO
    public String ewI() {
        return this.BSW.ewI();
    }

    @Override // com.bytedance.sdk.openadsdk.core.model.yFO
    public int dz() {
        return this.BSW.dz();
    }

    @Override // com.bytedance.sdk.openadsdk.core.model.yFO
    public void Bf(int i) {
        this.BSW.Bf(i);
    }

    @Override // com.bytedance.sdk.openadsdk.core.model.yFO
    public boolean xkc() {
        return this.BSW.xkc();
    }

    @Override // com.bytedance.sdk.openadsdk.core.model.yFO
    public boolean zi() {
        return this.BSW.zi();
    }

    @Override // com.bytedance.sdk.openadsdk.core.model.yFO
    public void Ky() {
        this.BSW.Ky();
    }

    @Override // com.bytedance.sdk.openadsdk.core.model.yFO
    public void ML(boolean z) {
        this.BSW.ML(z);
    }

    @Override // com.bytedance.sdk.openadsdk.core.model.yFO
    public boolean xkn() {
        return this.BSW.xkn();
    }

    @Override // com.bytedance.sdk.openadsdk.core.model.yFO
    public void pA(BF bf) {
        this.BSW.pA(bf);
    }

    @Override // com.bytedance.sdk.openadsdk.core.model.yFO
    public BF dL() {
        return this.BSW.dL();
    }

    @Override // com.bytedance.sdk.openadsdk.core.model.yFO
    public boolean SRe() {
        return this.BSW.pA;
    }

    @Override // com.bytedance.sdk.openadsdk.core.model.yFO
    public boolean ISu() {
        return this.BSW.Og;
    }

    @Override // com.bytedance.sdk.openadsdk.core.model.yFO
    public void SGo(boolean z) {
        this.BSW.SGo(z);
    }

    @Override // com.bytedance.sdk.openadsdk.core.model.yFO
    public int JEI() {
        return this.BSW.JEI();
    }

    @Override // com.bytedance.sdk.openadsdk.core.model.yFO
    public void BSW(boolean z) {
        this.BSW.BSW(z);
    }

    @Override // com.bytedance.sdk.openadsdk.core.model.yFO
    public boolean qK() {
        return this.BSW.qK();
    }

    @Override // com.bytedance.sdk.openadsdk.core.model.yFO
    public void HSv(int i) {
        this.BSW.HSv(i);
    }

    @Override // com.bytedance.sdk.openadsdk.core.model.yFO
    public int fhy() {
        return this.BSW.fhy();
    }

    @Override // com.bytedance.sdk.openadsdk.core.model.yFO
    public void Mc(String str) {
        this.BSW.Mc(str);
    }

    @Override // com.bytedance.sdk.openadsdk.core.model.yFO
    public String aOS() {
        return this.BSW.aOS();
    }

    @Override // com.bytedance.sdk.openadsdk.core.model.yFO
    public com.bytedance.sdk.openadsdk.BF.pA.Og Yg() {
        return this.BSW.Yg();
    }

    @Override // com.bytedance.sdk.openadsdk.core.model.yFO
    public void pA(com.bytedance.sdk.openadsdk.BF.pA.Og og) {
        this.BSW.pA(og);
    }
}
