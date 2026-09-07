package com.bytedance.sdk.openadsdk.core.Og;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import com.bytedance.sdk.component.utils.DX;
import com.bytedance.sdk.openadsdk.core.aBv;
import com.bytedance.sdk.openadsdk.core.model.SGo;
import com.bytedance.sdk.openadsdk.core.model.WQf;
import com.bytedance.sdk.openadsdk.core.model.yFO;
import com.bytedance.sdk.openadsdk.core.omh.omh;
import com.bytedance.sdk.openadsdk.core.rB;
import com.bytedance.sdk.openadsdk.utils.Sn;
import com.bytedance.sdk.openadsdk.utils.Vgu;
import com.bytedance.sdk.openadsdk.utils.gbA;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes7.dex */
public class pA extends Og {
    private boolean KZx;
    private boolean Og;
    private int Vgu;
    private boolean gbA;
    private boolean pA;
    private WeakReference<InterfaceC0231pA> qmB;

    /* JADX INFO: renamed from: com.bytedance.sdk.openadsdk.core.Og.pA$pA, reason: collision with other inner class name */
    public interface InterfaceC0231pA {
        long getVideoProgress();
    }

    public boolean KZx() {
        return false;
    }

    public boolean Og() {
        return false;
    }

    public pA(Context context, yFO yfo, String str, int i) {
        super(context, yfo, str, i);
        this.pA = true;
        this.Og = false;
        this.KZx = false;
        this.gbA = false;
    }

    public void pA(boolean z) {
        this.pA = z;
    }

    public void Og(boolean z) {
        this.Og = z;
    }

    /* JADX WARN: Code duplicated, block: B:111:0x0269  */
    /* JADX WARN: Code duplicated, block: B:158:0x034b  */
    /* JADX WARN: Code duplicated, block: B:171:0x0390  */
    /* JADX WARN: Code duplicated, block: B:173:0x0394  */
    /* JADX WARN: Code duplicated, block: B:175:0x0398  */
    /* JADX WARN: Code duplicated, block: B:177:0x03a2  */
    /* JADX WARN: Code duplicated, block: B:178:0x03a5  */
    /* JADX WARN: Code duplicated, block: B:183:0x03b7 A[Catch: Exception -> 0x03d0, TryCatch #0 {Exception -> 0x03d0, blocks: (B:181:0x03ae, B:183:0x03b7, B:187:0x03cd, B:185:0x03bb), top: B:211:0x03ae }] */
    /* JADX WARN: Code duplicated, block: B:185:0x03bb A[Catch: Exception -> 0x03d0, TryCatch #0 {Exception -> 0x03d0, blocks: (B:181:0x03ae, B:183:0x03b7, B:187:0x03cd, B:185:0x03bb), top: B:211:0x03ae }] */
    /* JADX WARN: Code duplicated, block: B:187:0x03cd A[Catch: Exception -> 0x03d0, TRY_LEAVE, TryCatch #0 {Exception -> 0x03d0, blocks: (B:181:0x03ae, B:183:0x03b7, B:187:0x03cd, B:185:0x03bb), top: B:211:0x03ae }] */
    /* JADX WARN: Code duplicated, block: B:189:0x03d2  */
    /* JADX WARN: Code duplicated, block: B:191:0x03d8  */
    /* JADX WARN: Code duplicated, block: B:192:0x03dc  */
    /* JADX WARN: Code duplicated, block: B:195:0x03e6  */
    /* JADX WARN: Code duplicated, block: B:198:0x03ec  */
    /* JADX WARN: Code duplicated, block: B:201:0x0408  */
    /* JADX WARN: Code duplicated, block: B:203:0x0412  */
    /* JADX WARN: Code duplicated, block: B:204:0x0415  */
    /* JADX WARN: Code duplicated, block: B:211:0x03ae A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:45:0x00ef  */
    @Override // com.bytedance.sdk.openadsdk.core.Og.Og, com.bytedance.sdk.openadsdk.core.Og.KZx
    public void pA(View view, float f, float f2, float f3, float f4, SparseArray<KZx.pA> sparseArray, boolean z) {
        JSONObject jSONObject;
        boolean z2;
        int i;
        JSONObject jSONObject2;
        View view2;
        int i2;
        Activity activityPA;
        Context context;
        boolean z3;
        int i3;
        Boolean bool;
        String strDC;
        String str;
        if (pA(view, 2, f, f2, f3, f4, sparseArray, z)) {
            return;
        }
        this.JG.ML(true);
        this.JG.Ky();
        if (!this.JG.ML()) {
            this.JG.pA(true);
        }
        if (yFO.ML(this.JG)) {
            com.bytedance.sdk.openadsdk.ZZv.KZx.Og(this.JG, this.SD, this.JG.Io());
        }
        if (this.Sn != null) {
            if (this.aBv == null) {
                this.aBv = new HashMap();
            }
            this.aBv.put("duration", Long.valueOf(this.Sn.ML()));
        }
        int iSPI = this.JG.sPI();
        this.JG.xy(0);
        if (this.oX != null) {
            this.oX.pA(iSPI > 0 ? iSPI : 0);
        }
        if (this.aBv != null) {
            this.aBv.remove("dsp_click_type");
            this.aBv.remove("click_probability_jump");
            this.aBv.remove("auto_click");
        }
        if (iSPI > 0) {
            if (this.aBv == null) {
                this.aBv = new HashMap();
            }
            if (this.JG.rjD() && iSPI < 11) {
                this.aBv.put("dsp_click_type", Integer.valueOf(iSPI));
            }
            if (iSPI >= 11 && this.JG.Lf() == 0) {
                this.aBv.put("click_probability_jump", Integer.valueOf(com.bytedance.sdk.openadsdk.core.model.JG.pA(iSPI)));
            }
        }
        if (this.JG.rjD()) {
            if (view != null) {
                Object tag = view.getTag(570425345);
                if (tag instanceof String) {
                    str = (String) tag;
                } else {
                    str = "VAST_ACTION_BUTTON";
                }
            } else {
                str = "VAST_ACTION_BUTTON";
            }
            this.JG.dGZ().ML(str);
            if (!TextUtils.isEmpty(str)) {
                pA(str);
            }
            WeakReference<InterfaceC0231pA> weakReference = this.qmB;
            long videoProgress = (weakReference == null || weakReference.get() == null) ? 0L : this.qmB.get().getVideoProgress();
            if ("VAST_ICON".equals(str)) {
                if (this.JG.dGZ().Og() != null) {
                    this.JG.dGZ().Og().pA(videoProgress);
                }
            } else if ("VAST_END_CARD".equals(str)) {
                if (this.JG.dGZ().KZx() != null) {
                    this.JG.dGZ().KZx().pA(videoProgress);
                }
            } else {
                this.JG.dGZ().pA().SD(videoProgress);
            }
        }
        if (SGo() && ZZv(view) && !this.KZx) {
            super.pA(view, f, f2, f3, f4, sparseArray, z);
            return;
        }
        if (this.ZZv == null) {
            this.ZZv = aBv.pA();
        }
        if (this.ZZv != null && pA(view, z)) {
            JSONObject jSONObjectPA = com.bytedance.sdk.openadsdk.core.omh.yFO.pA(view);
            if (this.ML != null) {
                i = this.ML.WV;
                jSONObject = this.ML.Wx;
                jSONObject2 = this.ML.aBv;
                z2 = this.ML.XT;
            } else {
                jSONObject = jSONObjectPA;
                z2 = false;
                i = -1;
                jSONObject2 = null;
            }
            this.BSW = pA(f, f2, f3, f4, sparseArray, this.TV, this.du, this.Bzk == null ? ZZv() : this.Bzk.get(), this.SGo == null ? ML() : this.SGo.get(), JG(), Vgu.ML(this.ZZv), Vgu.SD(this.ZZv), Vgu.JG(this.ZZv), i, jSONObject, jSONObject2);
            if (z2) {
                com.bytedance.sdk.openadsdk.ZZv.KZx.pA("click", this.JG, this.BSW, this.SD, true, this.aBv, z ? 1 : 2);
                return;
            }
            int iJBA = this.JG.JBA();
            if (iJBA == 2 || iJBA == 3) {
                view2 = view;
                if (iJBA == 3) {
                    strDC = this.JG.dC();
                    if (TextUtils.isEmpty(strDC) && strDC.contains("play.google.com/store")) {
                        if (com.bytedance.sdk.openadsdk.XT.pA.pA.ZZv.pA(this.ZZv, strDC, strDC.substring(strDC.indexOf("?id=") + 4), this.SD, this.JG)) {
                            if (this.pA) {
                                com.bytedance.sdk.openadsdk.ZZv.KZx.pA("click", this.JG, this.BSW, this.SD, true, this.aBv, z ? 1 : 2);
                            }
                        } else {
                            if (this.Wx == null) {
                                yFO yfo = this.JG;
                                SGo sGo = this.BSW;
                                String str2 = this.SD;
                                Map<String, Object> map = this.aBv;
                                if (z) {
                                    i2 = 1;
                                } else {
                                    i2 = 2;
                                }
                                com.bytedance.sdk.openadsdk.ZZv.KZx.pA("click_button", yfo, sGo, str2, true, map, i2);
                            } else {
                                yFO yfo2 = this.JG;
                                SGo sGo2 = this.BSW;
                                String str3 = this.SD;
                                Map<String, Object> map2 = this.aBv;
                                if (z) {
                                    i2 = 1;
                                } else {
                                    i2 = 2;
                                }
                                com.bytedance.sdk.openadsdk.ZZv.KZx.pA("click_button", yfo2, sGo2, str3, true, map2, i2);
                            }
                            if (view2 != null) {
                                if (view.getId() == 520093726) {
                                }
                                rB.pA(true);
                            } else {
                                bool = (Boolean) view2.getTag(520093762);
                                if (bool.booleanValue()) {
                                    rB.pA(true);
                                }
                            }
                            if (view2 != null) {
                            }
                            if (activityPA == null) {
                                context = this.ZZv;
                            } else {
                                context = activityPA;
                            }
                            if (com.bytedance.sdk.openadsdk.core.model.aBv.KZx(this.JG)) {
                                boolean zPA = rB.pA(context, this.JG, this.omh, this.Wx, this.XT, this.SD, this.oX, true, iSPI);
                                rB.pA(false);
                                z3 = zPA;
                            } else {
                                boolean zPA2 = rB.pA(context, this.JG, this.omh, this.Wx, this.XT, this.SD, this.oX, true, iSPI);
                                rB.pA(false);
                                z3 = zPA2;
                            }
                            if (this.pA) {
                                yFO yfo3 = this.JG;
                                SGo sGo3 = this.BSW;
                                String str4 = this.SD;
                                Map<String, Object> map3 = this.aBv;
                                if (z) {
                                    i3 = 1;
                                } else {
                                    i3 = 2;
                                }
                                com.bytedance.sdk.openadsdk.ZZv.KZx.pA("click", yfo3, sGo3, str4, z3, map3, i3);
                            }
                        }
                    } else {
                        if (this.Wx == null || this.Og) {
                            yFO yfo4 = this.JG;
                            SGo sGo4 = this.BSW;
                            String str5 = this.SD;
                            Map<String, Object> map4 = this.aBv;
                            if (z) {
                                i2 = 1;
                            } else {
                                i2 = 2;
                            }
                            com.bytedance.sdk.openadsdk.ZZv.KZx.pA("click_button", yfo4, sGo4, str5, true, map4, i2);
                        }
                        if (view2 != null) {
                            try {
                                if (view.getId() == 520093726 && !(view2 instanceof com.bytedance.sdk.openadsdk.core.Wx.Og.JG)) {
                                    bool = (Boolean) view2.getTag(520093762);
                                    if (bool.booleanValue()) {
                                        rB.pA(true);
                                    }
                                } else {
                                    rB.pA(true);
                                }
                            } catch (Exception unused) {
                            }
                        } else {
                            bool = (Boolean) view2.getTag(520093762);
                            if (bool.booleanValue()) {
                                rB.pA(true);
                            }
                        }
                        activityPA = view2 != null ? com.bytedance.sdk.component.utils.Og.pA(view) : null;
                        if (activityPA == null) {
                            context = this.ZZv;
                        } else {
                            context = activityPA;
                        }
                        if (com.bytedance.sdk.openadsdk.core.model.aBv.KZx(this.JG) || !this.gbA) {
                            boolean zPA3 = rB.pA(context, this.JG, this.omh, this.Wx, this.XT, this.SD, this.oX, true, iSPI);
                            rB.pA(false);
                            z3 = zPA3;
                        } else {
                            z3 = false;
                        }
                        if (this.pA) {
                            yFO yfo5 = this.JG;
                            SGo sGo5 = this.BSW;
                            String str6 = this.SD;
                            Map<String, Object> map5 = this.aBv;
                            if (z) {
                                i3 = 1;
                            } else {
                                i3 = 2;
                            }
                            com.bytedance.sdk.openadsdk.ZZv.KZx.pA("click", yfo5, sGo5, str6, z3, map5, i3);
                        }
                    }
                } else {
                    if (this.Wx == null) {
                        yFO yfo6 = this.JG;
                        SGo sGo6 = this.BSW;
                        String str7 = this.SD;
                        Map<String, Object> map6 = this.aBv;
                        if (z) {
                            i2 = 1;
                        } else {
                            i2 = 2;
                        }
                        com.bytedance.sdk.openadsdk.ZZv.KZx.pA("click_button", yfo6, sGo6, str7, true, map6, i2);
                    } else {
                        yFO yfo7 = this.JG;
                        SGo sGo7 = this.BSW;
                        String str8 = this.SD;
                        Map<String, Object> map7 = this.aBv;
                        if (z) {
                            i2 = 1;
                        } else {
                            i2 = 2;
                        }
                        com.bytedance.sdk.openadsdk.ZZv.KZx.pA("click_button", yfo7, sGo7, str8, true, map7, i2);
                    }
                    if (view2 != null) {
                        if (view.getId() == 520093726) {
                        }
                        rB.pA(true);
                    } else {
                        bool = (Boolean) view2.getTag(520093762);
                        if (bool.booleanValue()) {
                            rB.pA(true);
                        }
                    }
                    if (view2 != null) {
                    }
                    if (activityPA == null) {
                        context = this.ZZv;
                    } else {
                        context = activityPA;
                    }
                    if (com.bytedance.sdk.openadsdk.core.model.aBv.KZx(this.JG)) {
                        boolean zPA4 = rB.pA(context, this.JG, this.omh, this.Wx, this.XT, this.SD, this.oX, true, iSPI);
                        rB.pA(false);
                        z3 = zPA4;
                    } else {
                        boolean zPA5 = rB.pA(context, this.JG, this.omh, this.Wx, this.XT, this.SD, this.oX, true, iSPI);
                        rB.pA(false);
                        z3 = zPA5;
                    }
                    if (this.pA) {
                        yFO yfo8 = this.JG;
                        SGo sGo8 = this.BSW;
                        String str9 = this.SD;
                        Map<String, Object> map8 = this.aBv;
                        if (z) {
                            i3 = 1;
                        } else {
                            i3 = 2;
                        }
                        com.bytedance.sdk.openadsdk.ZZv.KZx.pA("click", yfo8, sGo8, str9, z3, map8, i3);
                    }
                }
            } else if (iJBA != 4) {
                if (iJBA == 5) {
                    String strOg = Og(this.SD);
                    if (!TextUtils.isEmpty(strOg)) {
                        com.bytedance.sdk.openadsdk.ZZv.KZx.pA("click_call", this.JG, this.BSW, strOg, true, this.aBv, z ? 1 : 2);
                    }
                    com.bytedance.sdk.openadsdk.ZZv.KZx.pA("click", this.JG, this.BSW, this.SD, gbA.KZx(view.getContext(), this.JG.vA()), this.aBv, z ? 1 : 2);
                    view2 = view;
                } else if (iJBA != 8) {
                    view2 = view;
                    iJBA = -1;
                } else {
                    view2 = view;
                    if (iJBA == 3) {
                        strDC = this.JG.dC();
                        if (TextUtils.isEmpty(strDC)) {
                            if (this.Wx == null) {
                                yFO yfo9 = this.JG;
                                SGo sGo9 = this.BSW;
                                String str10 = this.SD;
                                Map<String, Object> map9 = this.aBv;
                                if (z) {
                                    i2 = 1;
                                } else {
                                    i2 = 2;
                                }
                                com.bytedance.sdk.openadsdk.ZZv.KZx.pA("click_button", yfo9, sGo9, str10, true, map9, i2);
                            } else {
                                yFO yfo10 = this.JG;
                                SGo sGo10 = this.BSW;
                                String str11 = this.SD;
                                Map<String, Object> map10 = this.aBv;
                                if (z) {
                                    i2 = 1;
                                } else {
                                    i2 = 2;
                                }
                                com.bytedance.sdk.openadsdk.ZZv.KZx.pA("click_button", yfo10, sGo10, str11, true, map10, i2);
                            }
                            if (view2 != null) {
                                if (view.getId() == 520093726) {
                                }
                                rB.pA(true);
                            } else {
                                bool = (Boolean) view2.getTag(520093762);
                                if (bool.booleanValue()) {
                                    rB.pA(true);
                                }
                            }
                            if (view2 != null) {
                            }
                            if (activityPA == null) {
                                context = this.ZZv;
                            } else {
                                context = activityPA;
                            }
                            if (com.bytedance.sdk.openadsdk.core.model.aBv.KZx(this.JG)) {
                                boolean zPA6 = rB.pA(context, this.JG, this.omh, this.Wx, this.XT, this.SD, this.oX, true, iSPI);
                                rB.pA(false);
                                z3 = zPA6;
                            } else {
                                boolean zPA7 = rB.pA(context, this.JG, this.omh, this.Wx, this.XT, this.SD, this.oX, true, iSPI);
                                rB.pA(false);
                                z3 = zPA7;
                            }
                            if (this.pA) {
                                yFO yfo11 = this.JG;
                                SGo sGo11 = this.BSW;
                                String str12 = this.SD;
                                Map<String, Object> map11 = this.aBv;
                                if (z) {
                                    i3 = 1;
                                } else {
                                    i3 = 2;
                                }
                                com.bytedance.sdk.openadsdk.ZZv.KZx.pA("click", yfo11, sGo11, str12, z3, map11, i3);
                            }
                        } else {
                            if (this.Wx == null) {
                                yFO yfo12 = this.JG;
                                SGo sGo12 = this.BSW;
                                String str13 = this.SD;
                                Map<String, Object> map12 = this.aBv;
                                if (z) {
                                    i2 = 1;
                                } else {
                                    i2 = 2;
                                }
                                com.bytedance.sdk.openadsdk.ZZv.KZx.pA("click_button", yfo12, sGo12, str13, true, map12, i2);
                            } else {
                                yFO yfo13 = this.JG;
                                SGo sGo13 = this.BSW;
                                String str14 = this.SD;
                                Map<String, Object> map13 = this.aBv;
                                if (z) {
                                    i2 = 1;
                                } else {
                                    i2 = 2;
                                }
                                com.bytedance.sdk.openadsdk.ZZv.KZx.pA("click_button", yfo13, sGo13, str14, true, map13, i2);
                            }
                            if (view2 != null) {
                                if (view.getId() == 520093726) {
                                }
                                rB.pA(true);
                            } else {
                                bool = (Boolean) view2.getTag(520093762);
                                if (bool.booleanValue()) {
                                    rB.pA(true);
                                }
                            }
                            if (view2 != null) {
                            }
                            if (activityPA == null) {
                                context = this.ZZv;
                            } else {
                                context = activityPA;
                            }
                            if (com.bytedance.sdk.openadsdk.core.model.aBv.KZx(this.JG)) {
                                boolean zPA8 = rB.pA(context, this.JG, this.omh, this.Wx, this.XT, this.SD, this.oX, true, iSPI);
                                rB.pA(false);
                                z3 = zPA8;
                            } else {
                                boolean zPA9 = rB.pA(context, this.JG, this.omh, this.Wx, this.XT, this.SD, this.oX, true, iSPI);
                                rB.pA(false);
                                z3 = zPA9;
                            }
                            if (this.pA) {
                                yFO yfo14 = this.JG;
                                SGo sGo14 = this.BSW;
                                String str15 = this.SD;
                                Map<String, Object> map14 = this.aBv;
                                if (z) {
                                    i3 = 1;
                                } else {
                                    i3 = 2;
                                }
                                com.bytedance.sdk.openadsdk.ZZv.KZx.pA("click", yfo14, sGo14, str15, z3, map14, i3);
                            }
                        }
                    } else {
                        if (this.Wx == null) {
                            yFO yfo15 = this.JG;
                            SGo sGo15 = this.BSW;
                            String str16 = this.SD;
                            Map<String, Object> map15 = this.aBv;
                            if (z) {
                                i2 = 1;
                            } else {
                                i2 = 2;
                            }
                            com.bytedance.sdk.openadsdk.ZZv.KZx.pA("click_button", yfo15, sGo15, str16, true, map15, i2);
                        } else {
                            yFO yfo16 = this.JG;
                            SGo sGo16 = this.BSW;
                            String str17 = this.SD;
                            Map<String, Object> map16 = this.aBv;
                            if (z) {
                                i2 = 1;
                            } else {
                                i2 = 2;
                            }
                            com.bytedance.sdk.openadsdk.ZZv.KZx.pA("click_button", yfo16, sGo16, str17, true, map16, i2);
                        }
                        if (view2 != null) {
                            if (view.getId() == 520093726) {
                            }
                            rB.pA(true);
                        } else {
                            bool = (Boolean) view2.getTag(520093762);
                            if (bool.booleanValue()) {
                                rB.pA(true);
                            }
                        }
                        if (view2 != null) {
                        }
                        if (activityPA == null) {
                            context = this.ZZv;
                        } else {
                            context = activityPA;
                        }
                        if (com.bytedance.sdk.openadsdk.core.model.aBv.KZx(this.JG)) {
                            boolean zPA10 = rB.pA(context, this.JG, this.omh, this.Wx, this.XT, this.SD, this.oX, true, iSPI);
                            rB.pA(false);
                            z3 = zPA10;
                        } else {
                            boolean zPA11 = rB.pA(context, this.JG, this.omh, this.Wx, this.XT, this.SD, this.oX, true, iSPI);
                            rB.pA(false);
                            z3 = zPA11;
                        }
                        if (this.pA) {
                            yFO yfo17 = this.JG;
                            SGo sGo17 = this.BSW;
                            String str18 = this.SD;
                            Map<String, Object> map17 = this.aBv;
                            if (z) {
                                i3 = 1;
                            } else {
                                i3 = 2;
                            }
                            com.bytedance.sdk.openadsdk.ZZv.KZx.pA("click", yfo17, sGo17, str18, z3, map17, i3);
                        }
                    }
                }
            } else if (WQf.Og(this.JG) && (this.Wx != null || this.XT != null)) {
                view2 = view;
                activityPA = view2 != null ? com.bytedance.sdk.component.utils.Og.pA(view) : null;
                boolean zPA12 = rB.pA(activityPA == null ? this.ZZv : activityPA, this.JG, this.omh, this.Wx, this.XT, this.SD, this.oX, true, iSPI);
                if (this.pA) {
                    com.bytedance.sdk.openadsdk.ZZv.KZx.pA("click", this.JG, this.BSW, this.SD, zPA12, this.aBv, z ? 1 : 2);
                }
            } else {
                view2 = view;
                if (this.oX != null) {
                    this.oX.ZZv();
                    Map<String, Object> map18 = this.aBv;
                    if (this.JG.ML() && !this.JG.ZZv()) {
                        map18.put("auto_click", Boolean.TRUE);
                        this.JG.Og(false);
                    }
                    if (this.pA) {
                        com.bytedance.sdk.openadsdk.ZZv.KZx.pA("click", this.JG, this.BSW, this.SD, true, map18, z ? 1 : 2);
                    }
                }
            }
            if (this.WV != null) {
                this.WV.pA(view2, iJBA);
            }
        }
    }

    protected boolean pA() {
        if (this.JG == null) {
            return true;
        }
        int iOg = aBv.ZZv().Og(this.JG.Wf());
        int iKZx = DX.KZx(aBv.pA());
        if (iOg == 1) {
            return gbA.ZZv(iKZx);
        }
        if (iOg == 2) {
            return gbA.ML(iKZx) || gbA.ZZv(iKZx) || gbA.JG(iKZx);
        }
        if (iOg != 3) {
            return iOg != 5 || gbA.ZZv(iKZx) || gbA.JG(iKZx);
        }
        return false;
    }

    private boolean omh() {
        return yFO.ML(this.JG) && this.JG.TV() == 1;
    }

    private boolean ZZv(View view) {
        if (view == null) {
            return false;
        }
        if ((view instanceof com.bytedance.sdk.openadsdk.core.Wx.Og.JG) || view.getId() == Sn.vkV || view.getId() == Sn.FQ || view.getId() == Sn.Gx || view.getId() == Sn.Bf || view.getId() == Sn.HSv || view.getId() == 520093726 || view.getId() == Sn.lgT) {
            return true;
        }
        if (!(view instanceof ViewGroup)) {
            return false;
        }
        int i = 0;
        while (true) {
            ViewGroup viewGroup = (ViewGroup) view;
            if (i >= viewGroup.getChildCount()) {
                return false;
            }
            if (ZZv(viewGroup.getChildAt(i))) {
                return true;
            }
            i++;
        }
    }

    private boolean Bzk() {
        return this instanceof omh;
    }

    private boolean SGo() {
        if (this.JG == null || Bzk()) {
            return false;
        }
        if (this.JG.RS() != 5 && this.JG.RS() != 15) {
            return false;
        }
        if (this.Vgu == 0) {
            this.Vgu = this.JG.PKZ();
        }
        Og();
        pA();
        KZx();
        if (this.Vgu == 5 && omh() && pA() && !Og() && !KZx()) {
            return false;
        }
        int i = this.Vgu;
        return i == 1 || i == 2 || i == 5;
    }

    private String Og(String str) {
        str.hashCode();
        switch (str) {
            case "banner_ad":
                return "banner_call";
            case "open_ad":
                return "open_ad";
            case "embeded_ad":
                return "feed_call";
            case "interaction":
                return "interaction_call";
            case "slide_banner_ad":
                return "banner_call";
            default:
                return "";
        }
    }

    public void KZx(boolean z) {
        this.KZx = z;
    }

    public void pA(InterfaceC0231pA interfaceC0231pA) {
        this.qmB = new WeakReference<>(interfaceC0231pA);
    }

    public void ZZv(boolean z) {
        this.gbA = z;
    }
}
