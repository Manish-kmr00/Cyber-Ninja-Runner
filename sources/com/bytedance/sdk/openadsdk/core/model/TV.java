package com.bytedance.sdk.openadsdk.core.model;

import android.content.Context;
import android.net.Uri;
import android.text.TextUtils;
import com.applovin.sdk.AppLovinErrorCodes;
import com.bytedance.sdk.openadsdk.AdSlot;
import com.bytedance.sdk.openadsdk.FilterWord;
import com.bytedance.sdk.openadsdk.TTAdConstant;
import com.bytedance.sdk.openadsdk.utils.qmB;
import com.facebook.gamingservices.cloudgaming.internal.SDKConstants;
import com.facebook.internal.NativeProtocol;
import com.facebook.share.internal.ShareConstants;
import com.json.mediationsdk.metadata.a;
import com.mbridge.msdk.foundation.download.database.DownloadModel;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.safedk.android.analytics.brandsafety.creatives.infos.CreativeInfo;
import com.safedk.android.internal.partials.PangleNetworkBridge;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Set;
import net.pubnative.lite.sdk.analytics.Reporting;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes7.dex */
public class TV extends yFO {
    public long BSW;
    private String Bpk;
    private String CIG;
    private String Dc;
    private String EC;
    private WV FGT;
    private String FHA;
    private boolean Fb;
    private JSONObject GbR;
    private String HMH;
    private long HSv;
    private int IG;
    private boolean IIF;
    private int Io;
    private int JBA;
    private boolean Lf;
    private boolean LhC;
    private String Mc;
    private boolean PKZ;
    private int PU;
    private boolean PV;
    private int QI;
    private int Qd;
    private String Qj;
    private AdSlot RS;
    private yFO.pA SXO;
    private String Sd;
    private String TV;
    private String TX;
    private int Tsy;
    private int Uz;
    private String Vgu;
    private com.bytedance.sdk.openadsdk.core.BSW.JG.pA Wf;
    private int XT;
    private boolean YkC;
    private String ZF;
    private ML ZL;
    private boolean Zc;
    private int aBv;
    private int agB;
    private int aj;
    private com.bytedance.sdk.openadsdk.core.WV.pA bA;
    private int cFQ;
    private boolean dC;
    private int dGZ;
    private com.bykv.vk.openvk.pA.pA.pA.KZx.Og dmv;
    private String du;
    private String eG;
    private int eUc;
    private com.bykv.vk.openvk.pA.pA.pA.KZx.Og fJy;
    private com.bykv.vk.openvk.pA.pA.pA.KZx.Og fN;
    private ZZv fg;
    private String fw;
    private String gbA;
    private int ged;
    private int gl;
    private int guZ;
    private JSONObject gy;
    private JSONObject jK;
    private String jO;
    private com.bytedance.sdk.openadsdk.core.BSW.JG.pA juv;
    private String kK;
    private XT ka;
    private boolean le;
    private String lgT;
    private Map<String, Object> lx;
    private String mK;
    private eG mM;
    private String mY;
    private int npn;
    private int oX;
    private int qmB;
    private KZx rB;
    private int rX;
    private int rjD;
    private String roi;
    private JSONObject rtW;
    private volatile boolean sPI;
    private oX tpV;
    private String uQ;
    private WQf uhO;
    private int vA;
    private DX vZF;
    private Wx xt;
    private BSW xy;
    private DX yFO;
    private BF zi;
    private final List<DX> WV = new ArrayList();
    private final List<String> Wx = new ArrayList();
    private final List<FilterWord> Sn = new ArrayList();
    private final qmB DX = qmB.KZx();
    public boolean SGo = false;
    private List<String> BF = new ArrayList();
    private List<String> WQf = new ArrayList();
    private String lT = "0";
    private String SzT = "";
    private int FQ = 0;
    private int Gx = 2;
    private int Bf = 0;
    private int nCO = 0;
    private int bU = 1;
    private Bzk Wo = new Bzk();
    private int Itl = AppLovinErrorCodes.UNABLE_TO_PRECACHE_RESOURCES;
    private int tM = 0;
    private int Gag = 1;
    private int sk = 0;
    private int tZW = 0;
    private int Ld = 0;
    private int slz = 1;
    private int Lm = 1;
    private float xkn = 100.0f;
    private int qQU = 2;
    private int Xj = 1;
    private int vkV = 0;
    private int BDQ = -1;
    private long FK = -1;
    private int Kj = 0;
    private boolean Ij = false;
    private int qH = 0;
    private int iC = 50;
    private int Ky = -1;
    private com.bytedance.sdk.openadsdk.BF.pA.Og GL = null;

    public static boolean SD(yFO yfo) {
        if (yfo == null) {
            return false;
        }
        int iRS = yfo.RS();
        return yfo.rjD() || iRS == 5 || iRS == 15 || iRS == 50;
    }

    private static double JG(JSONObject jSONObject) {
        if (jSONObject != null) {
            return jSONObject.optDouble("pack_time", 0.0d);
        }
        return 0.0d;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && getClass() == obj.getClass()) {
            yFO yfo = (yFO) obj;
            if (this.lT.equals(yfo.nCO()) && this.CIG.equals(yfo.tM())) {
                return true;
            }
        }
        return false;
    }

    @Override // com.bytedance.sdk.openadsdk.core.model.yFO
    public boolean ZZv() {
        return this.YkC;
    }

    @Override // com.bytedance.sdk.openadsdk.core.model.yFO
    public void pA(boolean z) {
        this.YkC = z;
    }

    @Override // com.bytedance.sdk.openadsdk.core.model.yFO
    public boolean ML() {
        return this.dC;
    }

    @Override // com.bytedance.sdk.openadsdk.core.model.yFO
    public void Og(boolean z) {
        this.dC = z;
    }

    @Override // com.bytedance.sdk.openadsdk.core.model.yFO
    public void KZx(boolean z) {
        this.IIF = z;
    }

    @Override // com.bytedance.sdk.openadsdk.core.model.yFO
    public String JG() {
        return this.HMH;
    }

    @Override // com.bytedance.sdk.openadsdk.core.model.yFO
    public void ML(String str) {
        this.HMH = str;
    }

    @Override // com.bytedance.sdk.openadsdk.core.model.yFO
    public String SD() {
        return this.Bpk;
    }

    @Override // com.bytedance.sdk.openadsdk.core.model.yFO
    public void JG(String str) {
        this.Bpk = str;
    }

    @Override // com.bytedance.sdk.openadsdk.core.model.yFO
    public boolean omh() {
        return (TextUtils.isEmpty(JG()) || TextUtils.isEmpty(SD())) ? false : true;
    }

    @Override // com.bytedance.sdk.openadsdk.core.model.yFO
    public XT Bzk() {
        return this.ka;
    }

    @Override // com.bytedance.sdk.openadsdk.core.model.yFO
    public void pA(ML ml) {
        this.ZL = ml;
    }

    @Override // com.bytedance.sdk.openadsdk.core.model.yFO
    public ML BSW() {
        return this.ZL;
    }

    @Override // com.bytedance.sdk.openadsdk.core.model.yFO
    public void pA(XT xt) {
        this.ka = xt;
    }

    @Override // com.bytedance.sdk.openadsdk.core.model.yFO
    public void pA(oX oXVar) {
        this.tpV = oXVar;
    }

    @Override // com.bytedance.sdk.openadsdk.core.model.yFO
    public oX SGo() {
        return this.tpV;
    }

    @Override // com.bytedance.sdk.openadsdk.core.model.yFO
    public boolean eUc() {
        return this.PKZ;
    }

    @Override // com.bytedance.sdk.openadsdk.core.model.yFO
    public void SD(boolean z) {
        this.PKZ = z;
    }

    @Override // com.bytedance.sdk.openadsdk.core.model.yFO
    public void du(String str) {
        this.FHA = str;
    }

    @Override // com.bytedance.sdk.openadsdk.core.model.yFO
    public String ged() {
        return this.FHA;
    }

    @Override // com.bytedance.sdk.openadsdk.core.model.yFO
    public void SzT(int i) {
        this.rX = i;
    }

    @Override // com.bytedance.sdk.openadsdk.core.model.yFO
    public void eG(String str) {
        this.kK = str;
    }

    @Override // com.bytedance.sdk.openadsdk.core.model.yFO
    public String ZL() {
        return this.kK;
    }

    @Override // com.bytedance.sdk.openadsdk.core.model.yFO
    public boolean zi() {
        List<Integer> listKZx;
        return (CIG() == null || (listKZx = CIG().KZx()) == null || !listKZx.contains(57)) ? false : true;
    }

    @Override // com.bytedance.sdk.openadsdk.core.model.yFO
    public String tpV() {
        return this.EC;
    }

    @Override // com.bytedance.sdk.openadsdk.core.model.yFO
    public boolean eD() {
        return this.LhC;
    }

    @Override // com.bytedance.sdk.openadsdk.core.model.yFO
    public com.bytedance.sdk.openadsdk.core.BSW.JG.pA Mx() {
        return this.juv;
    }

    @Override // com.bytedance.sdk.openadsdk.core.model.yFO
    public void pA(com.bytedance.sdk.openadsdk.core.BSW.JG.pA pAVar) {
        this.juv = pAVar;
        com.bytedance.sdk.openadsdk.core.BSW.pA.Og.pA().pA(pAVar, CampaignEx.JSON_NATIVE_VIDEO_ENDCARD);
    }

    @Override // com.bytedance.sdk.openadsdk.core.model.yFO
    public void Og(com.bytedance.sdk.openadsdk.core.BSW.JG.pA pAVar) {
        this.Wf = pAVar;
        com.bytedance.sdk.openadsdk.core.BSW.pA.Og.pA().pA(pAVar, CampaignEx.JSON_NATIVE_VIDEO_ENDCARD);
    }

    @Override // com.bytedance.sdk.openadsdk.core.model.yFO
    public com.bytedance.sdk.openadsdk.core.BSW.JG.pA ZDE() {
        return this.Wf;
    }

    @Override // com.bytedance.sdk.openadsdk.core.model.yFO
    public void FQ(int i) {
        this.qH = i;
    }

    @Override // com.bytedance.sdk.openadsdk.core.model.yFO
    public int Bi() {
        return this.qH;
    }

    @Override // com.bytedance.sdk.openadsdk.core.model.yFO
    public void Xe() {
        this.Lf = true;
    }

    @Override // com.bytedance.sdk.openadsdk.core.model.yFO
    public boolean Evs() {
        return this.Lf;
    }

    @Override // com.bytedance.sdk.openadsdk.core.model.yFO
    public void hP() {
        this.le = true;
    }

    @Override // com.bytedance.sdk.openadsdk.core.model.yFO
    public boolean DDZ() {
        return this.le;
    }

    @Override // com.bytedance.sdk.openadsdk.core.model.yFO
    public int LAE() {
        try {
            JSONObject jSONObjectFg = fg();
            if (jSONObjectFg != null) {
                return jSONObjectFg.optInt("rec_clk", 0);
            }
            return 0;
        } catch (Exception unused) {
            return 0;
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.model.yFO
    public boolean boc() {
        return this.Zc;
    }

    @Override // com.bytedance.sdk.openadsdk.core.model.yFO
    public void omh(boolean z) {
        this.Zc = z;
    }

    @Override // com.bytedance.sdk.openadsdk.core.model.yFO
    public boolean fS() {
        return this.Fb;
    }

    @Override // com.bytedance.sdk.openadsdk.core.model.yFO
    public void Bzk(boolean z) {
        this.Fb = z;
    }

    @Override // com.bytedance.sdk.openadsdk.core.model.yFO
    public void Gx(int i) {
        this.iC = i;
    }

    @Override // com.bytedance.sdk.openadsdk.core.model.yFO
    public int vON() {
        return this.iC;
    }

    @Override // com.bytedance.sdk.openadsdk.core.model.yFO
    public String ZQ() {
        JSONObject jSONObjectFg;
        if (this.Dc == null && (jSONObjectFg = fg()) != null) {
            this.Dc = jSONObjectFg.optString("cid", "");
        }
        return this.Dc;
    }

    @Override // com.bytedance.sdk.openadsdk.core.model.yFO
    public void roi(String str) {
        this.ZF = str;
    }

    @Override // com.bytedance.sdk.openadsdk.core.model.yFO
    public String ewI() {
        return this.ZF;
    }

    @Override // com.bytedance.sdk.openadsdk.core.model.yFO
    public int dz() {
        if (this.Ky < 0) {
            try {
                JSONObject jSONObjectFg = fg();
                if (jSONObjectFg != null) {
                    this.Ky = jSONObjectFg.optInt("is_drop_to_retargeting_sample", 0);
                } else {
                    this.Ky = 0;
                }
            } catch (Throwable unused) {
                this.Ky = 0;
            }
        }
        return this.Ky;
    }

    @Override // com.bytedance.sdk.openadsdk.core.model.yFO
    public void Bf(int i) {
        this.Io = i;
    }

    @Override // com.bytedance.sdk.openadsdk.core.model.yFO
    public boolean xkc() {
        if (this.BDQ <= 0) {
            this.BDQ = PKZ();
        }
        int i = this.BDQ;
        return (i == 7 || i == 8) && !SD(this) && XT() != 21 && this.Io == 1;
    }

    @Override // com.bytedance.sdk.openadsdk.core.model.yFO
    public void GL() {
        com.bykv.vk.openvk.pA.pA.pA.KZx.Og og = this.fN;
        if (og == null || TextUtils.isEmpty(og.WV())) {
            return;
        }
        try {
            if (this.fN.WV().contains("style_id")) {
                this.LhC = true;
                this.EC = Uri.parse(this.fN.WV()).getQueryParameters("style_id").get(0);
            } else {
                this.LhC = false;
            }
        } catch (Throwable th) {
            com.bytedance.sdk.component.utils.WV.Og(th.getMessage());
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.model.yFO
    public ZZv WV() {
        return this.fg;
    }

    @Override // com.bytedance.sdk.openadsdk.core.model.yFO
    public void pA(ZZv zZv) {
        this.fg = zZv;
    }

    @Override // com.bytedance.sdk.openadsdk.core.model.yFO
    public int Wx() {
        ZZv zZv = this.fg;
        if (zZv == null) {
            return 2;
        }
        return zZv.pA();
    }

    @Override // com.bytedance.sdk.openadsdk.core.model.yFO
    public int Sn() {
        if (zi()) {
            return 5;
        }
        if (qQU()) {
            return 4;
        }
        ZZv zZv = this.fg;
        if (zZv == null) {
            return 1;
        }
        return zZv.Og();
    }

    @Override // com.bytedance.sdk.openadsdk.core.model.yFO
    public long DX() {
        ZZv zZv = this.fg;
        if (zZv == null) {
            return 0L;
        }
        return zZv.KZx();
    }

    @Override // com.bytedance.sdk.openadsdk.core.model.yFO
    public WQf oX() {
        return this.uhO;
    }

    @Override // com.bytedance.sdk.openadsdk.core.model.yFO
    public void pA(WQf wQf) {
        this.uhO = wQf;
    }

    @Override // com.bytedance.sdk.openadsdk.core.model.yFO
    public int aBv() {
        return this.aBv;
    }

    @Override // com.bytedance.sdk.openadsdk.core.model.yFO
    public void pA(int i) {
        pA(i, -1);
    }

    @Override // com.bytedance.sdk.openadsdk.core.model.yFO
    public int XT() {
        return this.XT;
    }

    @Override // com.bytedance.sdk.openadsdk.core.model.yFO
    public void Og(int i) {
        this.aBv = i;
    }

    @Override // com.bytedance.sdk.openadsdk.core.model.yFO
    public void pA(int i, int i2) {
        this.XT = i;
        this.aBv = i;
        if (this.RS == null) {
            this.aBv = 0;
            return;
        }
        if (i2 <= 0) {
            i2 = PKZ();
        }
        if (this.RS.getNativeAdType() == 3 || this.RS.getDurationSlotType() == 3 || i2 == 3) {
            this.aBv = 14;
            return;
        }
        if (this.RS.getNativeAdType() == 7 || this.RS.getNativeAdType() == 8 || this.RS.getDurationSlotType() == 7 || this.RS.getDurationSlotType() == 8 || i2 == 7 || i2 == 8) {
            if (WQf.KZx(this)) {
                this.aBv = 12;
                return;
            }
            if (WQf.Og(this)) {
                this.aBv = 9;
                return;
            }
            if (this.XT == 5 && !aBv.ZZv(this)) {
                this.aBv = 7;
            }
            if (this.XT == 6 && !aBv.Og(this)) {
                this.aBv = 7;
            }
            if (this.XT == 8 && PJB() != 100) {
                this.aBv = 7;
            }
            if (this.XT == 19 && TextUtils.isEmpty(this.Sd)) {
                this.aBv = 7;
            }
            if (this.XT == 20 && TextUtils.isEmpty(this.Sd)) {
                this.aBv = 7;
            }
            if (this.XT == 38 && !aBv.KZx(this)) {
                this.aBv = 7;
            }
            if (i < 5) {
                this.aBv = 7;
                return;
            }
            return;
        }
        if (WQf.Og(this)) {
            this.aBv = 4;
            return;
        }
        if (this.XT == 4 && !WQf.Og(this)) {
            this.aBv = 0;
        }
        if (i >= 5) {
            this.aBv = 0;
            return;
        }
        if (this.XT == 2 && JBA() != 3) {
            this.aBv = 0;
        } else if (i == 0 || (i == 1 && JBA() != 3)) {
            this.aBv = 0;
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.model.yFO
    public int yFO() {
        return this.Xj;
    }

    @Override // com.bytedance.sdk.openadsdk.core.model.yFO
    public void pA(double d) {
        if (d != 2.0d && d != 1.0d) {
            this.Xj = 1;
        } else {
            this.Xj = (int) d;
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.model.yFO
    public int vZF() {
        return this.qQU;
    }

    @Override // com.bytedance.sdk.openadsdk.core.model.yFO
    public void Og(double d) {
        if (d != 2.0d && d != 1.0d) {
            this.qQU = 2;
        } else {
            this.qQU = (int) d;
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.model.yFO
    public String Sd() {
        return this.SzT;
    }

    @Override // com.bytedance.sdk.openadsdk.core.model.yFO
    public void SD(String str) {
        this.SzT = str;
    }

    @Override // com.bytedance.sdk.openadsdk.core.model.yFO
    public int TX() {
        return this.FQ;
    }

    @Override // com.bytedance.sdk.openadsdk.core.model.yFO
    public void KZx(int i) {
        this.FQ = i;
    }

    @Override // com.bytedance.sdk.openadsdk.core.model.yFO
    public int BF() {
        int i = this.aBv;
        if (i == 5 || i == 6 || i == 33) {
            return 1;
        }
        if (qH()) {
            return 2;
        }
        return this.Gx;
    }

    @Override // com.bytedance.sdk.openadsdk.core.model.yFO
    public void ZZv(int i) {
        this.Gx = i;
    }

    public int xoO() {
        return this.sk;
    }

    @Override // com.bytedance.sdk.openadsdk.core.model.yFO
    public void ML(int i) {
        this.sk = i;
    }

    public String PF() {
        return this.mK;
    }

    @Override // com.bytedance.sdk.openadsdk.core.model.yFO
    public void omh(String str) {
        this.mK = str;
    }

    @Override // com.bytedance.sdk.openadsdk.core.model.yFO
    public boolean WQf() {
        return this.sk == 1;
    }

    @Override // com.bytedance.sdk.openadsdk.core.model.yFO
    public int TV() {
        return this.Ld;
    }

    @Override // com.bytedance.sdk.openadsdk.core.model.yFO
    public void JG(int i) {
        this.Ld = i;
    }

    @Override // com.bytedance.sdk.openadsdk.core.model.yFO
    public int du() {
        return this.nCO;
    }

    @Override // com.bytedance.sdk.openadsdk.core.model.yFO
    public void SD(int i) {
        this.nCO = i;
    }

    @Override // com.bytedance.sdk.openadsdk.core.model.yFO
    public int eG() {
        return this.bU;
    }

    @Override // com.bytedance.sdk.openadsdk.core.model.yFO
    public void omh(int i) {
        this.bU = i;
    }

    @Override // com.bytedance.sdk.openadsdk.core.model.yFO
    public String roi() {
        return this.uQ;
    }

    @Override // com.bytedance.sdk.openadsdk.core.model.yFO
    public void Bzk(String str) {
        this.uQ = str;
    }

    @Override // com.bytedance.sdk.openadsdk.core.model.yFO
    public int Mc() {
        return this.tZW;
    }

    @Override // com.bytedance.sdk.openadsdk.core.model.yFO
    public void Bzk(int i) {
        this.tZW = i;
    }

    public int pUz() {
        return this.Gag;
    }

    @Override // com.bytedance.sdk.openadsdk.core.model.yFO
    public void SGo(int i) {
        this.Gag = i;
    }

    @Override // com.bytedance.sdk.openadsdk.core.model.yFO
    public int IG() {
        if (rjD()) {
            return 5;
        }
        if (slz() != 100.0f || BF() == 2) {
            return 0;
        }
        return this.tM;
    }

    @Override // com.bytedance.sdk.openadsdk.core.model.yFO
    public void BSW(int i) {
        this.tM = i;
    }

    @Override // com.bytedance.sdk.openadsdk.core.model.yFO
    public Bzk lT() {
        return this.Wo;
    }

    @Override // com.bytedance.sdk.openadsdk.core.model.yFO
    public void pA(Bzk bzk) {
        this.Wo = bzk;
    }

    @Override // com.bytedance.sdk.openadsdk.core.model.yFO
    public AdSlot rB() {
        return this.RS;
    }

    @Override // com.bytedance.sdk.openadsdk.core.model.yFO
    public void pA(AdSlot adSlot) {
        this.RS = adSlot;
    }

    public int tfE() {
        return this.QI;
    }

    @Override // com.bytedance.sdk.openadsdk.core.model.yFO
    public void WV(int i) {
        this.QI = i;
    }

    @Override // com.bytedance.sdk.openadsdk.core.model.yFO
    public int xy() {
        return this.Itl;
    }

    @Override // com.bytedance.sdk.openadsdk.core.model.yFO
    public void Wx(int i) {
        this.Itl = i;
    }

    public int cmu() {
        return this.slz;
    }

    @Override // com.bytedance.sdk.openadsdk.core.model.yFO
    public void Sn(int i) {
        this.slz = i;
    }

    public int JRV() {
        return this.Uz;
    }

    @Override // com.bytedance.sdk.openadsdk.core.model.yFO
    public void DX(int i) {
        this.Uz = i;
    }

    public int PJB() {
        return this.agB;
    }

    @Override // com.bytedance.sdk.openadsdk.core.model.yFO
    public void oX(int i) {
        this.agB = i;
    }

    @Override // com.bytedance.sdk.openadsdk.core.model.yFO
    public String qmB() {
        return this.fw;
    }

    @Override // com.bytedance.sdk.openadsdk.core.model.yFO
    public void SGo(String str) {
        this.fw = str;
    }

    @Override // com.bytedance.sdk.openadsdk.core.model.yFO
    public boolean gbA() {
        return PJB() == 100 || this.aBv == 20;
    }

    @Override // com.bytedance.sdk.openadsdk.core.model.yFO
    public int Vgu() {
        return this.cFQ;
    }

    @Override // com.bytedance.sdk.openadsdk.core.model.yFO
    public void aBv(int i) {
        this.cFQ = i;
    }

    @Override // com.bytedance.sdk.openadsdk.core.model.yFO
    public yFO.pA CIG() {
        return this.SXO;
    }

    @Override // com.bytedance.sdk.openadsdk.core.model.yFO
    public void pA(yFO.pA pAVar) {
        this.SXO = pAVar;
        com.bytedance.sdk.component.adexpress.pA.KZx.ZZv zZvOL = OL();
        if (zZvOL != null && !SzT()) {
            com.bytedance.sdk.component.adexpress.pA.Og.Og.pA(zZvOL);
        }
        if (pAVar == null || TextUtils.isEmpty(pAVar.DX())) {
            return;
        }
        com.bytedance.sdk.openadsdk.core.BSW.pA.Og.pA().pA(hl(), Reporting.Key.CLICK_SOURCE_TYPE_AD);
    }

    @Override // com.bytedance.sdk.openadsdk.core.model.yFO
    public void pA(eG eGVar) {
        this.mM = eGVar;
        if (eGVar == null || TextUtils.isEmpty(eGVar.KZx())) {
            return;
        }
        com.bytedance.sdk.openadsdk.core.BSW.pA.Og.pA().pA(JIC(), "adv3");
    }

    @Override // com.bytedance.sdk.openadsdk.core.model.yFO
    public boolean SzT() {
        yFO.pA pAVar = this.SXO;
        if (pAVar != null) {
            return !TextUtils.isEmpty(pAVar.Wx());
        }
        int i = this.nCO;
        return i == 9 || i == 10;
    }

    @Override // com.bytedance.sdk.openadsdk.core.model.yFO
    public void Og(JSONObject jSONObject) {
        this.jK = jSONObject;
    }

    public JSONObject iZ() {
        return this.jK;
    }

    @Override // com.bytedance.sdk.openadsdk.core.model.yFO
    public eG FQ() {
        return this.mM;
    }

    private com.bytedance.sdk.openadsdk.core.BSW.JG.pA hl() {
        yFO.pA pAVarCIG = CIG();
        if (pAVarCIG == null) {
            return null;
        }
        return yFO.pA.Og(pAVarCIG, String.valueOf(Wf()));
    }

    private com.bytedance.sdk.openadsdk.core.BSW.JG.pA JIC() {
        eG eGVarFQ = FQ();
        if (eGVarFQ == null) {
            return null;
        }
        return new com.bytedance.sdk.openadsdk.core.BSW.JG.pA().pA(eGVarFQ.pA()).Og(eGVarFQ.Og()).KZx(eGVarFQ.KZx()).ZZv(eGVarFQ.ZZv()).ML(Wf() + "_v3");
    }

    public com.bytedance.sdk.component.adexpress.pA.KZx.ZZv OL() {
        yFO.pA pAVarCIG = CIG();
        if (pAVarCIG == null) {
            return null;
        }
        return yFO.pA.pA(pAVarCIG, String.valueOf(Wf()));
    }

    @Override // com.bytedance.sdk.openadsdk.core.model.yFO
    public int Gx() {
        WV wv = this.FGT;
        if (wv == null) {
            return 0;
        }
        return wv.pA();
    }

    @Override // com.bytedance.sdk.openadsdk.core.model.yFO
    public com.bykv.vk.openvk.pA.pA.pA.KZx.Og Bf() {
        return this.fN;
    }

    @Override // com.bytedance.sdk.openadsdk.core.model.yFO
    public void pA(com.bykv.vk.openvk.pA.pA.pA.KZx.Og og) {
        this.fN = og;
    }

    @Override // com.bytedance.sdk.openadsdk.core.model.yFO
    public void pA(WV wv) {
        this.FGT = wv;
    }

    @Override // com.bytedance.sdk.openadsdk.core.model.yFO
    public String HSv() {
        return this.gbA;
    }

    @Override // com.bytedance.sdk.openadsdk.core.model.yFO
    public void BSW(String str) {
        this.gbA = str;
    }

    @Override // com.bytedance.sdk.openadsdk.core.model.yFO
    public void WV(String str) {
        this.Mc = str;
    }

    public String Wpq() {
        return this.Mc;
    }

    @Override // com.bytedance.sdk.openadsdk.core.model.yFO
    public int JBA() {
        return this.oX;
    }

    @Override // com.bytedance.sdk.openadsdk.core.model.yFO
    public boolean agB() {
        return this.gl == 1;
    }

    @Override // com.bytedance.sdk.openadsdk.core.model.yFO
    public void XT(int i) {
        this.gl = i;
    }

    public int RA() {
        return this.gl;
    }

    @Override // com.bytedance.sdk.openadsdk.core.model.yFO
    public void yFO(int i) {
        this.oX = i;
    }

    @Override // com.bytedance.sdk.openadsdk.core.model.yFO
    public boolean fN() {
        return this.eUc == 1;
    }

    @Override // com.bytedance.sdk.openadsdk.core.model.yFO
    public void vZF(int i) {
        this.eUc = i;
    }

    public int oM() {
        return this.eUc;
    }

    @Override // com.bytedance.sdk.openadsdk.core.model.yFO
    public void Sd(int i) {
        this.ged = i;
    }

    @Override // com.bytedance.sdk.openadsdk.core.model.yFO
    public int dmv() {
        return this.ged;
    }

    @Override // com.bytedance.sdk.openadsdk.core.model.yFO
    public DX fJy() {
        return this.yFO;
    }

    @Override // com.bytedance.sdk.openadsdk.core.model.yFO
    public void pA(DX dx) {
        pA(dx, yFO.Bzk);
        String strLT = lT(dx.pA());
        if (!TextUtils.isEmpty(strLT)) {
            dx.Og(strLT);
        }
        this.yFO = dx;
    }

    private String lT(String str) {
        try {
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            return com.bytedance.sdk.component.ML.KZx.KZx.KZx.pA(str);
        } catch (Throwable th) {
            com.bytedance.sdk.component.utils.WV.pA("MaterialMeta", "generate icon key error", th.getMessage());
            return null;
        }
    }

    private void pA(DX dx, int i) {
        if (dx != null) {
            try {
                if (TextUtils.isEmpty(dx.pA())) {
                    return;
                }
                if (dx.Og() == 0 && dx.KZx() == 0) {
                    dx.pA(i);
                    dx.Og(i);
                    return;
                }
                if (dx.Og() == 0) {
                    if (dx.KZx() > i) {
                        dx.Og(i);
                        dx.pA(i);
                        return;
                    } else {
                        dx.pA(dx.KZx());
                        return;
                    }
                }
                if (dx.KZx() == 0) {
                    if (dx.Og() > i) {
                        dx.Og(i);
                        dx.pA(i);
                        return;
                    } else {
                        dx.Og(dx.Og());
                        return;
                    }
                }
                if (dx.Og() > dx.KZx()) {
                    if (dx.Og() > i) {
                        dx.Og((int) (i / (dx.Og() / dx.KZx())));
                        dx.pA(i);
                        return;
                    }
                    return;
                }
                if (dx.KZx() > i) {
                    dx.pA((int) (i * (dx.Og() / dx.KZx())));
                    dx.Og(i);
                }
            } catch (Throwable unused) {
            }
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.model.yFO
    public DX YkC() {
        return this.vZF;
    }

    @Override // com.bytedance.sdk.openadsdk.core.model.yFO
    public void Og(DX dx) {
        this.vZF = dx;
    }

    @Override // com.bytedance.sdk.openadsdk.core.model.yFO
    public String dC() {
        return this.Sd;
    }

    @Override // com.bytedance.sdk.openadsdk.core.model.yFO
    public void Wx(String str) {
        this.Sd = str;
    }

    @Override // com.bytedance.sdk.openadsdk.core.model.yFO
    public List<DX> IIF() {
        return this.WV;
    }

    @Override // com.bytedance.sdk.openadsdk.core.model.yFO
    public void KZx(DX dx) {
        this.WV.add(dx);
    }

    @Override // com.bytedance.sdk.openadsdk.core.model.yFO
    public String vA() {
        return this.TX;
    }

    @Override // com.bytedance.sdk.openadsdk.core.model.yFO
    public void Sn(String str) {
        this.TX = str;
    }

    @Override // com.bytedance.sdk.openadsdk.core.model.yFO
    public List<String> PV() {
        return this.BF;
    }

    @Override // com.bytedance.sdk.openadsdk.core.model.yFO
    public List<String> cFQ() {
        return this.WQf;
    }

    @Override // com.bytedance.sdk.openadsdk.core.model.yFO
    public List<String> lx() {
        return this.Wx;
    }

    @Override // com.bytedance.sdk.openadsdk.core.model.yFO
    public String SXO() {
        return this.TV;
    }

    @Override // com.bytedance.sdk.openadsdk.core.model.yFO
    public void DX(String str) {
        this.TV = str;
    }

    @Override // com.bytedance.sdk.openadsdk.core.model.yFO
    public String fw() {
        return this.du;
    }

    @Override // com.bytedance.sdk.openadsdk.core.model.yFO
    public void oX(String str) {
        this.du = str;
    }

    @Override // com.bytedance.sdk.openadsdk.core.model.yFO
    public String gy() {
        if (!TextUtils.isEmpty(this.eG)) {
            return this.eG;
        }
        Context contextPA = com.bytedance.sdk.openadsdk.core.aBv.pA();
        int iJBA = JBA();
        if (iJBA != 2 && iJBA != 3) {
            if (iJBA == 4) {
                if (contextPA != null) {
                    return com.bytedance.sdk.component.utils.yFO.pA(contextPA, "tt_video_download_apk");
                }
                return this.eG;
            }
            if (iJBA != 8) {
                return this.eG;
            }
        }
        if (contextPA != null) {
            return com.bytedance.sdk.component.utils.yFO.pA(contextPA, "tt_video_mobile_go_detail");
        }
        return this.eG;
    }

    @Override // com.bytedance.sdk.openadsdk.core.model.yFO
    public void aBv(String str) {
        this.eG = str;
    }

    @Override // com.bytedance.sdk.openadsdk.core.model.yFO
    public String nCO() {
        return this.lT;
    }

    @Override // com.bytedance.sdk.openadsdk.core.model.yFO
    public void XT(String str) {
        this.lT = str;
    }

    @Override // com.bytedance.sdk.openadsdk.core.model.yFO
    public String bU() {
        return this.Vgu;
    }

    @Override // com.bytedance.sdk.openadsdk.core.model.yFO
    public void yFO(String str) {
        this.Vgu = str;
    }

    @Override // com.bytedance.sdk.openadsdk.core.model.yFO
    public KZx Wo() {
        return this.rB;
    }

    @Override // com.bytedance.sdk.openadsdk.core.model.yFO
    public void pA(KZx kZx) {
        this.rB = kZx;
    }

    @Override // com.bytedance.sdk.openadsdk.core.model.yFO
    public BSW Itl() {
        return this.xy;
    }

    @Override // com.bytedance.sdk.openadsdk.core.model.yFO
    public void pA(BSW bsw) {
        this.xy = bsw;
    }

    @Override // com.bytedance.sdk.openadsdk.core.model.yFO
    public String tM() {
        return this.CIG;
    }

    @Override // com.bytedance.sdk.openadsdk.core.model.yFO
    public void vZF(String str) {
        this.CIG = str;
    }

    @Override // com.bytedance.sdk.openadsdk.core.model.yFO
    public int RS() {
        return this.qmB;
    }

    @Override // com.bytedance.sdk.openadsdk.core.model.yFO
    public void TX(int i) {
        this.qmB = i;
    }

    @Override // com.bytedance.sdk.openadsdk.core.model.yFO
    public List<FilterWord> QI() {
        return this.Sn;
    }

    @Override // com.bytedance.sdk.openadsdk.core.model.yFO
    public void pA(FilterWord filterWord) {
        this.Sn.add(filterWord);
    }

    @Override // com.bytedance.sdk.openadsdk.core.model.yFO
    public String Gag() {
        return this.jO;
    }

    @Override // com.bytedance.sdk.openadsdk.core.model.yFO
    public void Sd(String str) {
        this.jO = str;
    }

    @Override // com.bytedance.sdk.openadsdk.core.model.yFO
    public long Qj() {
        return this.HSv;
    }

    @Override // com.bytedance.sdk.openadsdk.core.model.yFO
    public void Og(long j) {
        this.HSv = j;
    }

    public int gg() {
        return this.JBA;
    }

    @Override // com.bytedance.sdk.openadsdk.core.model.yFO
    public void BF(int i) {
        this.JBA = i;
    }

    @Override // com.bytedance.sdk.openadsdk.core.model.yFO
    public boolean sk() {
        return this.PV;
    }

    @Override // com.bytedance.sdk.openadsdk.core.model.yFO
    public void ZZv(boolean z) {
        this.PV = z;
    }

    @Override // com.bytedance.sdk.openadsdk.core.model.yFO
    public Map<String, Object> tZW() {
        return this.lx;
    }

    @Override // com.bytedance.sdk.openadsdk.core.model.yFO
    public void pA(Map<String, Object> map) {
        this.lx = map;
    }

    @Override // com.bytedance.sdk.openadsdk.core.model.yFO
    public JSONObject Ld() {
        return this.rtW;
    }

    @Override // com.bytedance.sdk.openadsdk.core.model.yFO
    public void KZx(JSONObject jSONObject) {
        this.rtW = jSONObject;
    }

    public String IF() {
        return this.Qj;
    }

    @Override // com.bytedance.sdk.openadsdk.core.model.yFO
    public void TX(String str) {
        this.Qj = str;
    }

    @Override // com.bytedance.sdk.openadsdk.core.model.yFO
    public int rtW() {
        if (this.Lm != 2) {
            this.Lm = 1;
        }
        return this.Lm;
    }

    @Override // com.bytedance.sdk.openadsdk.core.model.yFO
    public void WQf(int i) {
        this.Lm = i;
    }

    @Override // com.bytedance.sdk.openadsdk.core.model.yFO
    public float slz() {
        if (this.xkn <= 0.0f) {
            this.xkn = 100.0f;
        }
        return (this.xkn * 1000.0f) / 1000.0f;
    }

    @Override // com.bytedance.sdk.openadsdk.core.model.yFO
    public void pA(float f) {
        this.xkn = f;
    }

    @Override // com.bytedance.sdk.openadsdk.core.model.yFO
    public boolean Uz() {
        if (this.WV.isEmpty()) {
            return false;
        }
        if (this.qmB == 4 && this.WV.size() < 3) {
            return false;
        }
        Iterator<DX> it = this.WV.iterator();
        while (it.hasNext()) {
            if (!it.next().ML()) {
                return false;
            }
        }
        return true;
    }

    @Override // com.bytedance.sdk.openadsdk.core.model.yFO
    public boolean uQ() {
        return !rjD() && Aj() == 1;
    }

    public int Aj() {
        return this.Bf;
    }

    @Override // com.bytedance.sdk.openadsdk.core.model.yFO
    public void TV(int i) {
        this.Bf = i;
    }

    @Override // com.bytedance.sdk.openadsdk.core.model.yFO
    public void ZZv(JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        this.oX = 4;
        this.lT = jSONObject.optString("id");
        this.gbA = jSONObject.optString("source");
        KZx kZx = new KZx();
        this.rB = kZx;
        kZx.KZx(jSONObject.optString("pkg_name"));
        this.rB.Og(jSONObject.optString("name"));
        this.rB.pA(jSONObject.optString(DownloadModel.DOWNLOAD_URL));
    }

    @Override // com.bytedance.sdk.openadsdk.core.model.yFO
    public JSONObject jO() {
        Object objKZx;
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("interaction_type", JBA());
            jSONObject.put(ZZv, RA());
            jSONObject.put("interaction_method", XT());
            jSONObject.put(KZx, oM());
            jSONObject.put(ML, dmv());
            jSONObject.put("target_url", dC());
            jSONObject.put("app_log_url", bU());
            jSONObject.put("gecko_id", Gag());
            jSONObject.put(ShareConstants.MEDIA_EXTENSION, PU());
            jSONObject.put(CreativeInfo.c, nCO());
            jSONObject.put("source", HSv());
            jSONObject.put(NativeProtocol.BRIDGE_ARG_APP_NAME_STRING, Wpq());
            jSONObject.put("screenshot", sk());
            jSONObject.put("dislike_control", Aj());
            jSONObject.put("play_bar_show_time", xy());
            jSONObject.put("play_bar_style", IG());
            jSONObject.put("if_block_lp", xoO());
            jSONObject.put("cache_sort", cmu());
            jSONObject.put("if_sp_cache", JRV());
            jSONObject.put("render_control", BF());
            jSONObject.put("mrc_report", this.aj);
            jSONObject.put("isMrcReportFinish", this.sPI);
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("cta", vZF());
            jSONObject2.put("other", yFO());
            jSONObject.put("set_click_type", jSONObject2);
            JSONObject jSONObject3 = new JSONObject();
            jSONObject3.put(CampaignEx.JSON_KEY_REWARD_NAME, Sd());
            jSONObject3.put(CampaignEx.JSON_KEY_REWARD_AMOUNT, TX());
            jSONObject.put("reward_data", jSONObject3);
            if (!TextUtils.isEmpty(JG()) && !TextUtils.isEmpty(SD())) {
                JSONObject jSONObject4 = new JSONObject();
                jSONObject4.put("adchoices_icon", JG());
                jSONObject4.put("adchoices_url", SD());
                jSONObject.put("dsp_adchoices", jSONObject4);
            }
            DX dxFJy = fJy();
            if (dxFJy != null && !TextUtils.isEmpty(dxFJy.pA())) {
                JSONObject jSONObject5 = new JSONObject();
                jSONObject5.put("url", dxFJy.pA());
                jSONObject5.put("height", dxFJy.KZx());
                jSONObject5.put("width", dxFJy.Og());
                jSONObject.put("icon", jSONObject5);
            }
            DX dxYkC = YkC();
            if (dxYkC != null && !TextUtils.isEmpty(dxYkC.pA())) {
                JSONObject jSONObject6 = new JSONObject();
                jSONObject6.put("url", dxYkC.pA());
                jSONObject6.put("height", dxYkC.KZx());
                jSONObject6.put("width", dxYkC.Og());
                jSONObject.put("cover_image", jSONObject6);
            }
            Object objLd = Ld();
            if (objLd != null) {
                jSONObject.put("session_params", objLd);
            }
            Bzk bzkLT = lT();
            if (bzkLT != null) {
                JSONObject jSONObject7 = new JSONObject();
                jSONObject7.put("click_upper_content_area", bzkLT.pA);
                jSONObject7.put("click_upper_non_content_area", bzkLT.Og);
                jSONObject7.put("click_lower_content_area", bzkLT.KZx);
                jSONObject7.put("click_lower_non_content_area", bzkLT.ZZv);
                jSONObject7.put("click_button_area", bzkLT.ML);
                jSONObject7.put("click_video_area", bzkLT.JG);
                jSONObject.put("click_area", jSONObject7);
            }
            ML mlBSW = BSW();
            if (mlBSW != null) {
                jSONObject.put("arbitrage_interceptor_params", mlBSW.omh());
            }
            AdSlot adSlotRB = rB();
            if (adSlotRB != null) {
                jSONObject.put("adslot", adSlotRB.toJsonObj());
            }
            List<DX> listIIF = IIF();
            if (listIIF != null) {
                JSONArray jSONArray = new JSONArray();
                for (DX dx : listIIF) {
                    JSONObject jSONObject8 = new JSONObject();
                    jSONObject8.put("url", dx.pA());
                    jSONObject8.put("height", dx.KZx());
                    jSONObject8.put("width", dx.Og());
                    jSONObject8.put("image_preview", dx.JG());
                    jSONObject8.put("image_key", dx.SD());
                    jSONArray.put(jSONObject8);
                }
                jSONObject.put("image", jSONArray);
            }
            List<String> listPV = PV();
            if (listPV != null) {
                JSONArray jSONArray2 = new JSONArray();
                Iterator<String> it = listPV.iterator();
                while (it.hasNext()) {
                    jSONArray2.put(it.next());
                }
                jSONObject.put("show_url", jSONArray2);
            }
            List<String> listCFQ = cFQ();
            if (listCFQ != null) {
                JSONArray jSONArray3 = new JSONArray();
                Iterator<String> it2 = listCFQ.iterator();
                while (it2.hasNext()) {
                    jSONArray3.put(it2.next());
                }
                jSONObject.put("click_url", jSONArray3);
            }
            List<String> listLx = lx();
            if (listLx != null) {
                JSONArray jSONArray4 = new JSONArray();
                Iterator<String> it3 = listLx.iterator();
                while (it3.hasNext()) {
                    jSONArray4.put(it3.next());
                }
                jSONObject.put("play_start", jSONArray4);
            }
            jSONObject.put("phone_num", vA());
            jSONObject.put("title", SXO());
            jSONObject.put("description", fw());
            jSONObject.put("ext", tM());
            jSONObject.put("image_mode", RS());
            jSONObject.put("cover_click_area", PJB());
            jSONObject.put("intercept_flag", tfE());
            jSONObject.put("button_text", gy());
            jSONObject.put("ad_logo", pUz());
            jSONObject.put("video_adaptation", Mc());
            jSONObject.put("feed_video_opentype", TV());
            jSONObject.put("orientation", rtW());
            jSONObject.put("aspect_ratio", slz());
            KZx kZxWo = Wo();
            if (kZxWo != null) {
                JSONObject jSONObject9 = new JSONObject();
                jSONObject9.put(NativeProtocol.BRIDGE_ARG_APP_NAME_STRING, kZxWo.Og());
                jSONObject9.put("package_name", kZxWo.KZx());
                jSONObject9.put(DownloadModel.DOWNLOAD_URL, kZxWo.pA());
                jSONObject9.put("score", kZxWo.ZZv());
                jSONObject9.put("comment_num", kZxWo.ML());
                jSONObject9.put(CampaignEx.JSON_KEY_APP_SIZE, kZxWo.JG());
                jSONObject9.put("app_category", kZxWo.SD());
                jSONObject.put("app", jSONObject9);
            }
            BSW bswItl = Itl();
            if (bswItl != null) {
                JSONObject jSONObject10 = new JSONObject();
                jSONObject10.put("deeplink_url", bswItl.pA());
                jSONObject10.put("fallback_url", bswItl.Og());
                jSONObject10.put("fallback_type", bswItl.KZx());
                jSONObject.put(CampaignEx.JSON_KEY_DEEP_LINK_URL, jSONObject10);
            }
            BF bfDL = dL();
            if (bfDL != null && (objKZx = bfDL.KZx()) != null) {
                jSONObject.put("oem", objKZx);
            }
            List<FilterWord> listQI = QI();
            if (listQI != null) {
                JSONArray jSONArray5 = new JSONArray();
                Iterator<FilterWord> it4 = listQI.iterator();
                while (it4.hasNext()) {
                    JSONObject jSONObjectOg = Og(it4.next());
                    if (jSONObjectOg != null) {
                        jSONArray5.put(jSONObjectOg);
                    }
                }
                jSONObject.put("filter_words", jSONArray5);
            }
            oX().pA(jSONObject);
            jSONObject.put("count_down", gg());
            jSONObject.put("expiration_time", Qj());
            com.bykv.vk.openvk.pA.pA.pA.KZx.Og ogTsy = Tsy();
            if (ogTsy != null) {
                jSONObject.put("video", ogTsy.XT());
            }
            com.bykv.vk.openvk.pA.pA.pA.KZx.Og ogQd = Qd();
            if (ogQd != null) {
                jSONObject.put("h265_video", ogQd.XT());
            }
            jSONObject.put("video_encode_type", mY());
            JSONObject jSONObject11 = new JSONObject();
            jSONObject11.put("if_send_click", Gx());
            jSONObject.put("download_conf", jSONObject11);
            if (tZW() != null) {
                JSONObject jSONObject12 = new JSONObject();
                Set<Map.Entry<String, Object>> setEntrySet = tZW().entrySet();
                if (!setEntrySet.isEmpty()) {
                    for (Map.Entry<String, Object> entry : setEntrySet) {
                        jSONObject12.put(entry.getKey(), entry.getValue());
                    }
                }
                jSONObject.put("media_ext", jSONObject12);
            }
            yFO.pA pAVarCIG = CIG();
            if (pAVarCIG != null) {
                JSONObject jSONObject13 = new JSONObject();
                jSONObject13.put("id", pAVarCIG.JG());
                jSONObject13.put("md5", pAVarCIG.SD());
                jSONObject13.put("url", pAVarCIG.omh());
                jSONObject13.put("data", pAVarCIG.Bzk());
                jSONObject13.put("diff_data", pAVarCIG.SGo());
                jSONObject13.put("version", pAVarCIG.ML());
                jSONObject13.put("dynamic_creative", pAVarCIG.BSW());
                jSONObject13.put("engine_version", pAVarCIG.Wx());
                jSONObject13.put("ugen_data", pAVarCIG.aBv());
                jSONObject13.put("ugen_md5", pAVarCIG.oX());
                jSONObject13.put("ugen_url", pAVarCIG.DX());
                jSONObject.put("tpl_info", jSONObject13);
            }
            eG eGVar = this.mM;
            if (eGVar != null) {
                jSONObject.put("tpl_info_v3", eGVar.JG());
            }
            jSONObject.put("dynamic_creative", iZ());
            jSONObject.put("creative_extra", qmB());
            jSONObject.put("market_url", IF());
            jSONObject.put("auction_price", roi());
            jSONObject.put("ad_info", PF());
            jSONObject.put("is_package_open", Lm());
            jSONObject.put("playable_duration_time", mK());
            jSONObject.put("playable_endcard_close_time", guZ());
            jSONObject.put("endcard_close_time", npn());
            JSONObject jSONObject14 = new JSONObject();
            jSONObject14.put("render_sequence", du());
            jSONObject14.put("backup_render_control", eG());
            jSONObject14.put("reserve_time", lgT());
            jSONObject14.put("render_thread", GbR());
            jSONObject.put(Reporting.EventType.RENDER, jSONObject14);
            if (this.ka == null) {
                XT xt = new XT();
                this.ka = xt;
                xt.pA("");
                this.ka.pA(10L);
                this.ka.Og(20L);
                this.ka.KZx(10L);
                this.ka.ZZv(20L);
            }
            JSONObject jSONObject15 = new JSONObject();
            jSONObject15.put("onlylp_loading_maxtime", this.ka.pA());
            jSONObject15.put("straight_lp_showtime", this.ka.Og());
            jSONObject15.put("onlyagg_loading_maxtime", this.ka.KZx());
            jSONObject15.put("straight_agg_showtime", this.ka.ZZv());
            jSONObject15.put("loading_text", this.ka.ML());
            oX oXVar = this.tpV;
            if (oXVar != null) {
                jSONObject15 = oXVar.pA(jSONObject15);
            }
            new Object[]{"interaction_method_params is:", jSONObject15};
            jSONObject.put("interaction_method_params", jSONObject15);
            JSONObject jSONObject16 = new JSONObject();
            jSONObject16.put("splash_clickarea", Wx());
            jSONObject16.put("splash_layout_id", Sn());
            jSONObject16.put("load_wait_time", DX());
            jSONObject.put("splash_control", jSONObject16);
            if (qQU()) {
                jSONObject.put("dsp_html", this.lgT);
            }
            if (rjD()) {
                jSONObject.put("vast_json", this.bA.SGo());
            }
            jSONObject.put("dsp_material_type", Lf());
            jSONObject.put("deep_link_appname", this.roi);
            jSONObject.put("landing_page_download_clicktype", this.IG);
            Wx wx = this.xt;
            if (wx != null) {
                jSONObject.put("dsp_style", wx.ML());
            }
            jSONObject.put("jump_probability", this.rX);
            jSONObject.put("identificationOverlayContent", this.kK);
            if (this.juv != null) {
                JSONObject jSONObject17 = new JSONObject();
                jSONObject17.put(CampaignEx.JSON_NATIVE_VIDEO_ENDCARD, this.juv.pA(this.Wf));
                jSONObject.put("ugen", jSONObject17);
            }
            jSONObject.put("preload_h5_type", Bi());
            jSONObject.put("hasReportShow", this.Zc);
            jSONObject.put("endcard_creative", this.ZF);
            jSONObject.put("image_stay", this.Io);
            JSONObject jSONObject18 = new JSONObject();
            jSONObject18.put(a.j, this.JG);
            jSONObject18.put("wait_time", this.SD);
            jSONObject18.put("label", this.omh);
            jSONObject.put("ev", jSONObject18);
        } catch (Exception unused) {
        }
        return jSONObject;
    }

    @Override // com.bytedance.sdk.openadsdk.core.model.yFO
    public JSONObject FGT() {
        JSONObject jSONObjectJO = jO();
        JSONObject jSONObjectXT = com.bytedance.sdk.openadsdk.core.settings.oX.vkV().XT(String.valueOf(Wf()));
        JSONObject jSONObject = new JSONObject();
        try {
            JSONArray jSONArray = new JSONArray();
            jSONArray.put(jSONObjectJO);
            jSONObject.put("creatives", jSONArray);
            jSONObject.put("did", 1);
            jSONObject.put("processing_time_ms", 100);
            jSONObject.put("request_id", "aaaaaaaa-aaaa-aaaa-aaaa-aaaaaaaaaaaa");
            jSONObject.put("s_receive_ts", 1);
            jSONObject.put("s_send_ts", 1);
            jSONObject.put("status_code", 20000);
            jSONObject.put("core_settings", jSONObjectXT);
        } catch (JSONException e) {
            com.bytedance.sdk.component.utils.WV.pA("MaterialMeta", "toJsonObjPlus", e.getMessage());
        }
        return jSONObject;
    }

    private JSONObject Og(FilterWord filterWord) {
        if (filterWord == null) {
            return null;
        }
        try {
            if (filterWord.isValid()) {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("id", filterWord.getId());
                jSONObject.put("name", filterWord.getName());
                jSONObject.put("is_selected", filterWord.getIsSelected());
                if (filterWord.hasSecondOptions()) {
                    JSONArray jSONArray = new JSONArray();
                    Iterator<FilterWord> it = filterWord.getOptions().iterator();
                    while (it.hasNext()) {
                        jSONArray.put(Og(it.next()));
                    }
                    if (jSONArray.length() > 0) {
                        jSONObject.put(SDKConstants.PARAM_GAME_REQUESTS_OPTIONS, jSONArray);
                    }
                }
                return jSONObject;
            }
        } catch (Throwable unused) {
        }
        return null;
    }

    @Override // com.bytedance.sdk.openadsdk.core.model.yFO
    public int Lm() {
        return this.guZ;
    }

    @Override // com.bytedance.sdk.openadsdk.core.model.yFO
    public void du(int i) {
        this.guZ = i;
    }

    @Override // com.bytedance.sdk.openadsdk.core.model.yFO
    public int mK() {
        int i = this.npn;
        if (i > 0) {
            return i;
        }
        return 20;
    }

    @Override // com.bytedance.sdk.openadsdk.core.model.yFO
    public void eG(int i) {
        this.npn = i;
    }

    @Override // com.bytedance.sdk.openadsdk.core.model.yFO
    public int guZ() {
        return this.rjD;
    }

    @Override // com.bytedance.sdk.openadsdk.core.model.yFO
    public void roi(int i) {
        this.rjD = i;
    }

    @Override // com.bytedance.sdk.openadsdk.core.model.yFO
    public int npn() {
        return this.dGZ;
    }

    @Override // com.bytedance.sdk.openadsdk.core.model.yFO
    public void Mc(int i) {
        this.dGZ = i;
    }

    @Override // com.bytedance.sdk.openadsdk.core.model.yFO
    public boolean rjD() {
        int i = this.Kj;
        return (i == 1 || i == 3) && dGZ() != null;
    }

    @Override // com.bytedance.sdk.openadsdk.core.model.yFO
    public com.bytedance.sdk.openadsdk.core.WV.pA dGZ() {
        return this.bA;
    }

    @Override // com.bytedance.sdk.openadsdk.core.model.yFO
    public void pA(com.bytedance.sdk.openadsdk.core.WV.pA pAVar) {
        this.bA = pAVar;
    }

    @Override // com.bytedance.sdk.openadsdk.core.model.yFO
    public boolean qQU() {
        return this.Kj == 2;
    }

    @Override // com.bytedance.sdk.openadsdk.core.model.yFO
    public String Xj() {
        return this.lgT;
    }

    @Override // com.bytedance.sdk.openadsdk.core.model.yFO
    public void BF(String str) {
        this.lgT = str;
    }

    @Override // com.bytedance.sdk.openadsdk.core.model.yFO
    public int vkV() {
        JSONObject jSONObject = this.GbR;
        if (jSONObject != null) {
            return jSONObject.optInt("easy_playable_skip_duration", 0);
        }
        return 0;
    }

    @Override // com.bytedance.sdk.openadsdk.core.model.yFO
    public JSONObject PU() {
        return this.GbR;
    }

    @Override // com.bytedance.sdk.openadsdk.core.model.yFO
    public void ML(JSONObject jSONObject) {
        this.GbR = jSONObject;
    }

    @Override // com.bytedance.sdk.openadsdk.core.model.yFO
    public boolean ka() {
        return this.aj == 1;
    }

    @Override // com.bytedance.sdk.openadsdk.core.model.yFO
    public void IG(int i) {
        this.aj = i;
    }

    @Override // com.bytedance.sdk.openadsdk.core.model.yFO
    public void uhO() {
        this.sPI = true;
    }

    @Override // com.bytedance.sdk.openadsdk.core.model.yFO
    public boolean bA() {
        return this.sPI;
    }

    @Override // com.bytedance.sdk.openadsdk.core.model.yFO
    public int lgT() {
        return this.Tsy;
    }

    @Override // com.bytedance.sdk.openadsdk.core.model.yFO
    public void lT(int i) {
        this.Tsy = Math.max(0, i);
    }

    @Override // com.bytedance.sdk.openadsdk.core.model.yFO
    public int GbR() {
        return this.Qd;
    }

    @Override // com.bytedance.sdk.openadsdk.core.model.yFO
    public void rB(int i) {
        this.Qd = i;
    }

    @Override // com.bytedance.sdk.openadsdk.core.model.yFO
    public void pA(Wx wx) {
        this.xt = wx;
    }

    @Override // com.bytedance.sdk.openadsdk.core.model.yFO
    public Wx aj() {
        return this.xt;
    }

    @Override // com.bytedance.sdk.openadsdk.core.model.yFO
    public void xy(int i) {
        this.vA = i;
    }

    @Override // com.bytedance.sdk.openadsdk.core.model.yFO
    public int sPI() {
        return this.vA;
    }

    @Override // com.bytedance.sdk.openadsdk.core.model.yFO
    public com.bytedance.sdk.component.Bzk.Og.pA BDQ() {
        com.bytedance.sdk.component.Bzk.Og.pA pAVar = new com.bytedance.sdk.component.Bzk.Og.pA();
        pAVar.pA(this.cFQ);
        pAVar.Og(this.lT);
        pAVar.pA(tM());
        return pAVar;
    }

    @Override // com.bytedance.sdk.openadsdk.core.model.yFO
    public int FK() {
        return this.vkV;
    }

    @Override // com.bytedance.sdk.openadsdk.core.model.yFO
    public void qmB(int i) {
        this.vkV = i;
    }

    @Override // com.bytedance.sdk.openadsdk.core.model.yFO
    public int mY() {
        return this.PU;
    }

    @Override // com.bytedance.sdk.openadsdk.core.model.yFO
    public void gbA(int i) {
        this.PU = i;
    }

    @Override // com.bytedance.sdk.openadsdk.core.model.yFO
    public com.bykv.vk.openvk.pA.pA.pA.KZx.Og Tsy() {
        return this.fJy;
    }

    @Override // com.bytedance.sdk.openadsdk.core.model.yFO
    public void Og(com.bykv.vk.openvk.pA.pA.pA.KZx.Og og) {
        this.fJy = og;
    }

    @Override // com.bytedance.sdk.openadsdk.core.model.yFO
    public com.bykv.vk.openvk.pA.pA.pA.KZx.Og Qd() {
        return this.dmv;
    }

    @Override // com.bytedance.sdk.openadsdk.core.model.yFO
    public void KZx(com.bykv.vk.openvk.pA.pA.pA.KZx.Og og) {
        this.dmv = og;
    }

    @Override // com.bytedance.sdk.openadsdk.core.model.yFO
    public String xt() {
        return this.roi;
    }

    @Override // com.bytedance.sdk.openadsdk.core.model.yFO
    public void WQf(String str) {
        this.roi = str;
    }

    @Override // com.bytedance.sdk.openadsdk.core.model.yFO
    public int HMH() {
        return this.IG;
    }

    @Override // com.bytedance.sdk.openadsdk.core.model.yFO
    public void Vgu(int i) {
        this.IG = i;
    }

    @Override // com.bytedance.sdk.openadsdk.core.model.yFO
    public boolean Bpk() {
        com.bykv.vk.openvk.pA.pA.pA.KZx.Og og = this.fN;
        return og == null || og.yFO() != 1;
    }

    @Override // com.bytedance.sdk.openadsdk.core.model.yFO
    public JSONObject fg() {
        if (this.gy == null) {
            try {
                if (!TextUtils.isEmpty(this.CIG)) {
                    this.gy = PangleNetworkBridge.jsonObjectInit(this.CIG);
                }
            } catch (JSONException e) {
                com.bytedance.sdk.component.utils.WV.pA("MaterialMeta", e.getMessage());
            }
        }
        return this.gy;
    }

    @Override // com.bytedance.sdk.openadsdk.core.model.yFO
    public int PKZ() {
        if (this.BDQ < 0) {
            JSONObject jSONObjectFg = fg();
            if (jSONObjectFg != null) {
                this.BDQ = jSONObjectFg.optInt("ad_slot_type", 0);
            } else {
                this.BDQ = 0;
            }
        }
        return this.BDQ;
    }

    @Override // com.bytedance.sdk.openadsdk.core.model.yFO
    public int FHA() {
        return this.BDQ;
    }

    @Override // com.bytedance.sdk.openadsdk.core.model.yFO
    public long Kj() {
        if (this.FK < 0) {
            JSONObject jSONObjectFg = fg();
            if (jSONObjectFg != null) {
                this.FK = jSONObjectFg.optLong(CreativeInfo.c, 0L);
            } else {
                this.FK = 0L;
            }
        }
        return this.FK;
    }

    @Override // com.bytedance.sdk.openadsdk.core.model.yFO
    public boolean rX() {
        return PKZ() == 3 || PKZ() == 4;
    }

    @Override // com.bytedance.sdk.openadsdk.core.model.yFO
    public boolean kK() {
        return PKZ() == 7;
    }

    @Override // com.bytedance.sdk.openadsdk.core.model.yFO
    public boolean EC() {
        return PKZ() == 8;
    }

    @Override // com.bytedance.sdk.openadsdk.core.model.yFO
    public boolean LhC() {
        return PKZ() == 1;
    }

    @Override // com.bytedance.sdk.openadsdk.core.model.yFO
    public boolean juv() {
        return PKZ() == 5;
    }

    @Override // com.bytedance.sdk.openadsdk.core.model.yFO
    public int Wf() {
        JSONObject jSONObjectFg = fg();
        if (jSONObjectFg != null) {
            return jSONObjectFg.optInt("rit", 0);
        }
        return 0;
    }

    @Override // com.bytedance.sdk.openadsdk.core.model.yFO
    public double mM() {
        return JG(fg());
    }

    @Override // com.bytedance.sdk.openadsdk.core.model.yFO
    public String TV(String str) {
        JSONObject jSONObjectFg = fg();
        return jSONObjectFg != null ? jSONObjectFg.optString("rit", str) : str;
    }

    @Override // com.bytedance.sdk.openadsdk.core.model.yFO
    public String jK() {
        KZx kZxWo = Wo();
        if (kZxWo == null || TextUtils.isEmpty(kZxWo.pA())) {
            return null;
        }
        return kZxWo.pA();
    }

    @Override // com.bytedance.sdk.openadsdk.core.model.yFO
    public String Ij() {
        JSONObject jSONObjectFg;
        String strOptString = this.mY;
        if (TextUtils.isEmpty(strOptString) && (jSONObjectFg = fg()) != null) {
            strOptString = jSONObjectFg.optString("req_id", "");
            IG(strOptString);
        }
        return strOptString == null ? "" : strOptString;
    }

    public void IG(String str) {
        this.mY = str;
    }

    @Override // com.bytedance.sdk.openadsdk.core.model.yFO
    public boolean qH() {
        return rB() != null && rB().getDurationSlotType() == 8 && qQU();
    }

    @Override // com.bytedance.sdk.openadsdk.core.model.yFO
    public int Lf() {
        return this.Kj;
    }

    @Override // com.bytedance.sdk.openadsdk.core.model.yFO
    public void CIG(int i) {
        this.Kj = i;
    }

    @Override // com.bytedance.sdk.openadsdk.core.model.yFO
    public boolean le() {
        int i = this.aBv;
        return (i == 2 || i == 1) && 3 == this.oX;
    }

    @Override // com.bytedance.sdk.openadsdk.core.model.yFO
    public boolean Zc() {
        Wx wx;
        return rjD() && !Dc() && (wx = this.xt) != null && wx.pA() == 1;
    }

    /* JADX WARN: Code duplicated, block: B:12:0x002a  */
    @Override // com.bytedance.sdk.openadsdk.core.model.yFO
    public boolean Fb() {
        int iOg;
        if (!Dc()) {
            int iNextInt = new Random().nextInt(100);
            if (rjD()) {
                Wx wx = this.xt;
                if (wx != null) {
                    iOg = wx.Og();
                } else {
                    iOg = 0;
                }
            } else if (WQf.Og(this)) {
                iOg = 0;
            } else {
                iOg = this.rX;
            }
            if (iNextInt < iOg) {
                return true;
            }
        }
        return false;
    }

    @Override // com.bytedance.sdk.openadsdk.core.model.yFO
    public boolean iC() {
        if (rjD() && !Dc()) {
            int iNextInt = new Random().nextInt(100);
            Wx wx = this.xt;
            if (wx != null && iNextInt < wx.KZx()) {
                return true;
            }
        }
        return false;
    }

    @Override // com.bytedance.sdk.openadsdk.core.model.yFO
    public boolean Dc() {
        return this.DX.pA > 0;
    }

    @Override // com.bytedance.sdk.openadsdk.core.model.yFO
    public qmB ZF() {
        return this.DX;
    }

    @Override // com.bytedance.sdk.openadsdk.core.model.yFO
    public void Ky() {
        this.DX.ML();
        SD(false);
    }

    @Override // com.bytedance.sdk.openadsdk.core.model.yFO
    public long Io() {
        return this.BSW;
    }

    @Override // com.bytedance.sdk.openadsdk.core.model.yFO
    public void KZx(long j) {
        this.BSW = j;
    }

    @Override // com.bytedance.sdk.openadsdk.core.model.yFO
    public boolean gl() {
        return this.SGo;
    }

    @Override // com.bytedance.sdk.openadsdk.core.model.yFO
    public void JG(boolean z) {
        this.SGo = z;
    }

    @Override // com.bytedance.sdk.openadsdk.core.model.yFO
    public void ML(boolean z) {
        this.Ij = z;
    }

    @Override // com.bytedance.sdk.openadsdk.core.model.yFO
    public boolean xkn() {
        return this.Ij;
    }

    @Override // com.bytedance.sdk.openadsdk.core.model.yFO
    public void pA(BF bf) {
        this.zi = bf;
    }

    @Override // com.bytedance.sdk.openadsdk.core.model.yFO
    public BF dL() {
        return this.zi;
    }

    @Override // com.bytedance.sdk.openadsdk.core.model.yFO
    public boolean SRe() {
        return this.pA;
    }

    @Override // com.bytedance.sdk.openadsdk.core.model.yFO
    public boolean ISu() {
        return this.Og;
    }

    @Override // com.bytedance.sdk.openadsdk.core.model.yFO
    public void SGo(boolean z) {
        this.Og = z;
    }

    @Override // com.bytedance.sdk.openadsdk.core.model.yFO
    public int JEI() {
        Map<String, Object> map = this.lx;
        if (map == null) {
            return 0;
        }
        try {
            Object obj = map.get(TTAdConstant.SDK_BIDDING_TYPE);
            if (obj != null) {
                return Integer.parseInt(obj.toString());
            }
            return 0;
        } catch (Throwable unused) {
            return 0;
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.model.yFO
    public void BSW(boolean z) {
        this.JG = z;
    }

    @Override // com.bytedance.sdk.openadsdk.core.model.yFO
    public boolean qK() {
        return this.JG;
    }

    @Override // com.bytedance.sdk.openadsdk.core.model.yFO
    public void HSv(int i) {
        if (i < 0 || i > 30) {
            i = 6;
        }
        this.SD = i;
    }

    @Override // com.bytedance.sdk.openadsdk.core.model.yFO
    public int fhy() {
        return this.SD;
    }

    @Override // com.bytedance.sdk.openadsdk.core.model.yFO
    public void Mc(String str) {
        if (TextUtils.isEmpty(str)) {
            this.omh = com.bytedance.sdk.openadsdk.BF.pA.KZx.KZx;
        } else {
            this.omh = str;
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.model.yFO
    public String aOS() {
        return this.omh;
    }

    @Override // com.bytedance.sdk.openadsdk.core.model.yFO
    public com.bytedance.sdk.openadsdk.BF.pA.Og Yg() {
        return this.GL;
    }

    @Override // com.bytedance.sdk.openadsdk.core.model.yFO
    public void pA(com.bytedance.sdk.openadsdk.BF.pA.Og og) {
        this.GL = og;
    }
}
