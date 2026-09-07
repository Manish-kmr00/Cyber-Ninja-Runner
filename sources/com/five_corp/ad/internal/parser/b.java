package com.five_corp.ad.internal.parser;

import com.amazon.aps.shared.metrics.model.ApsMetricsDataMap;
import com.five_corp.ad.internal.ad.fullscreen.k;
import com.five_corp.ad.internal.ad.fullscreen.o;
import com.five_corp.ad.internal.ad.fullscreen.p;
import com.five_corp.ad.internal.ad.j;
import com.five_corp.ad.internal.ad.m;
import com.five_corp.ad.internal.ad.q;
import com.five_corp.ad.internal.ad.r;
import com.five_corp.ad.internal.ad.s;
import com.five_corp.ad.internal.ad.t;
import com.json.fe;
import com.mbridge.msdk.foundation.download.core.DownloadCommon;
import com.pubmatic.sdk.openwrap.core.POBConstants;
import com.safedk.android.analytics.brandsafety.l;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes12.dex */
public abstract class b {
    public static com.five_corp.ad.internal.ad.a a(JSONObject jSONObject) throws JSONException, com.five_corp.ad.internal.exception.b {
        int i;
        int i2;
        q qVar;
        m mVar;
        String str;
        int i3;
        s sVar;
        int i4;
        int i5;
        long j;
        s sVar2;
        s sVar3;
        j jVar;
        List list;
        ArrayList arrayList;
        com.five_corp.ad.internal.ad.d dVar;
        ArrayList arrayList2;
        s sVar4;
        s sVar5;
        s sVar6;
        s sVar7;
        s sVar8;
        s sVar9;
        int i6;
        com.five_corp.ad.internal.ad.fullscreen.j jVar2;
        int i7;
        int i8;
        com.five_corp.ad.internal.ad.fullscreen.f fVar;
        o oVar;
        p pVar;
        s sVar10;
        int i9;
        String str2;
        com.five_corp.ad.internal.ad.fullscreen.f fVar2;
        o oVar2;
        com.five_corp.ad.internal.ad.beacon.e eVar;
        int i10;
        ArrayList arrayList3;
        int i11;
        int i12;
        int i13;
        String string;
        com.five_corp.ad.internal.ad.e eVar2;
        int i14;
        int i15;
        jSONObject.toString();
        String string2 = jSONObject.getString("ots");
        long j2 = jSONObject.getLong("ts");
        com.five_corp.ad.internal.ad.c cVar = new com.five_corp.ad.internal.ad.c(jSONObject.getInt("cm"), jSONObject.getInt("cmv"), jSONObject.getInt("cr"));
        long j3 = jSONObject.getLong("cmt");
        s sVar11 = new s(jSONObject.getString("m"), null, 0, 0);
        int i16 = jSONObject.getInt("mms");
        int i17 = 1;
        if (jSONObject.has("mpt")) {
            int i18 = jSONObject.getInt("mpt");
            int[] iArrB = com.five_corp.ad.e.b(3);
            int length = iArrB.length;
            int i19 = 0;
            while (true) {
                if (i19 >= length) {
                    throw new com.five_corp.ad.internal.exception.a(com.five_corp.ad.internal.p.c1, i18);
                }
                int i20 = iArrB[i19];
                if (i20 == i17) {
                    i15 = 1;
                } else if (i20 == 2) {
                    i15 = 2;
                } else {
                    if (i20 != 3) {
                        throw null;
                    }
                    i15 = 3;
                }
                if (i15 == i18) {
                    i = i20;
                    break;
                }
                i19++;
                i17 = 1;
            }
        } else {
            i = 1;
        }
        if (jSONObject.has("mpv")) {
            int i21 = jSONObject.getInt("mpv");
            int[] iArrB2 = com.five_corp.ad.e.b(2);
            int length2 = iArrB2.length;
            int i22 = 0;
            while (true) {
                if (i22 >= length2) {
                    throw new com.five_corp.ad.internal.exception.a(com.five_corp.ad.internal.p.A1, i21);
                }
                int i23 = iArrB2[i22];
                int[] iArr = iArrB2;
                if (i23 == 1) {
                    i14 = 1;
                } else {
                    if (i23 != 2) {
                        throw null;
                    }
                    i14 = 2;
                }
                if (i14 == i21) {
                    i2 = i23;
                    break;
                }
                i22++;
                iArrB2 = iArr;
            }
        } else {
            i2 = 1;
        }
        if (jSONObject.has("ppc")) {
            JSONObject jSONObject2 = jSONObject.getJSONObject("ppc");
            qVar = new q(jSONObject2.getLong("stm"), jSONObject2.getLong(l.f8111a));
        } else {
            qVar = null;
        }
        if (jSONObject.has("mpc")) {
            JSONObject jSONObject3 = jSONObject.getJSONObject("mpc");
            Long lValueOf = jSONObject3.has("sto") ? Long.valueOf(jSONObject3.getLong("sto")) : null;
            if (jSONObject3.has("fpc")) {
                JSONObject jSONObject4 = jSONObject3.getJSONObject("fpc");
                eVar2 = new com.five_corp.ad.internal.ad.e(jSONObject4.has("dtms") ? jSONObject4.getLong("dtms") : 10000L);
            } else {
                eVar2 = null;
            }
            mVar = new m(lValueOf, eVar2);
        } else {
            mVar = null;
        }
        Long lValueOf2 = jSONObject.has("maltms") ? Long.valueOf(jSONObject.getLong("maltms")) : null;
        if (jSONObject.has("pi")) {
            str = null;
            i3 = 0;
            sVar = new s(jSONObject.getString("pi"), null, 0, 0);
        } else {
            str = null;
            i3 = 0;
            sVar = null;
        }
        String str3 = "i";
        s sVar12 = jSONObject.has("i") ? new s(jSONObject.getString("i"), str, i3, i3) : null;
        s sVarA = jSONObject.has("ic") ? i.a(jSONObject.getJSONObject("ic")) : null;
        s sVarA2 = jSONObject.has("iic") ? i.a(jSONObject.getJSONObject("iic")) : null;
        if (jSONObject.has("rt")) {
            int i24 = jSONObject.getInt("rt");
            int[] iArrB3 = com.five_corp.ad.e.b(5);
            int length3 = iArrB3.length;
            int i25 = 0;
            while (true) {
                if (i25 >= length3) {
                    throw new com.five_corp.ad.internal.exception.a(com.five_corp.ad.internal.p.D0, i24);
                }
                int i26 = iArrB3[i25];
                int i27 = length3;
                if (com.five_corp.ad.e.a(i26) == i24) {
                    i4 = i26;
                    break;
                }
                i25++;
                length3 = i27;
            }
        } else {
            i4 = 1;
        }
        r rVar = new r(i4, jSONObject.optString("ru", null), jSONObject.optString("fbu", null), jSONObject.has("au") ? jSONObject.getString("au") : null);
        if (jSONObject.has("ort")) {
            int i28 = jSONObject.getInt("ort");
            int[] iArrB4 = com.five_corp.ad.e.b(2);
            int length4 = iArrB4.length;
            int i29 = 0;
            while (true) {
                if (i29 >= length4) {
                    throw new com.five_corp.ad.internal.exception.a(com.five_corp.ad.internal.p.t1, i28);
                }
                int i30 = length4;
                if (com.five_corp.ad.e.a(iArrB4[i29]) == i28) {
                    break;
                }
                i29++;
                length4 = i30;
            }
        }
        String string3 = jSONObject.has("iu") ? jSONObject.getString("iu") : null;
        if (jSONObject.has("info_icon")) {
            JSONObject jSONObject5 = jSONObject.getJSONObject("info_icon");
            JSONObject jSONObject6 = jSONObject5.getJSONObject(DownloadCommon.DOWNLOAD_REPORT_CANCEL);
            int i31 = jSONObject6.getInt(POBConstants.KEY_AT);
            int i32 = 2;
            int[] iArrB5 = com.five_corp.ad.e.b(2);
            int length5 = iArrB5.length;
            int i33 = 0;
            while (true) {
                if (i33 >= length5) {
                    throw new com.five_corp.ad.internal.exception.a(com.five_corp.ad.internal.p.F1, i31);
                }
                int i34 = length5;
                int i35 = iArrB5[i33];
                int[] iArr2 = iArrB5;
                if (i35 != 1) {
                    i10 = i32;
                    if (i35 != i10) {
                        throw null;
                    }
                } else {
                    i10 = 1;
                }
                if (i10 == i31) {
                    JSONArray jSONArrayOptJSONArray = jSONObject6.optJSONArray("chs");
                    if (2 == i35 && (jSONArrayOptJSONArray == null || jSONArrayOptJSONArray.length() == 0)) {
                        throw new JSONException("chs is required when informationIconClickActionType is SHOW_CHOICES");
                    }
                    if (jSONArrayOptJSONArray != null) {
                        arrayList3 = new ArrayList();
                        int i36 = 0;
                        while (i36 < jSONArrayOptJSONArray.length()) {
                            JSONObject jSONObject7 = jSONArrayOptJSONArray.getJSONObject(i36);
                            JSONArray jSONArray = jSONArrayOptJSONArray;
                            String string4 = jSONObject7.getString(ApsMetricsDataMap.APSMETRICS_FIELD_TIMESTAMP);
                            s sVar13 = sVar;
                            int i37 = jSONObject7.getInt("cht");
                            s sVar14 = sVar11;
                            int i38 = 3;
                            int[] iArrB6 = com.five_corp.ad.e.b(3);
                            int i39 = i16;
                            int length6 = iArrB6.length;
                            long j4 = j3;
                            int i40 = 0;
                            while (true) {
                                if (i40 >= length6) {
                                    throw new com.five_corp.ad.internal.exception.a(com.five_corp.ad.internal.p.G1, i37);
                                }
                                i11 = iArrB6[i40];
                                int i41 = length6;
                                if (i11 == 1) {
                                    i12 = i38;
                                    i13 = 1;
                                } else if (i11 != 2) {
                                    i12 = i38;
                                    if (i11 != i12) {
                                        throw null;
                                    }
                                    i13 = i12;
                                } else {
                                    i12 = i38;
                                    i13 = 2;
                                }
                                if (i13 == i37) {
                                    break;
                                }
                                i40++;
                                i38 = i12;
                                length6 = i41;
                                iArrB6 = iArrB6;
                            }
                            if (i12 != i11) {
                                string = null;
                            } else {
                                if (jSONObject7.isNull("url")) {
                                    throw new JSONException("url is required when informationIconClickChoiceType is OPEN_URL_OF_SPECIFIED");
                                }
                                string = jSONObject7.getString("url");
                            }
                            arrayList3.add(new com.five_corp.ad.internal.ad.h(string4, i11, string));
                            i36++;
                            sVar11 = sVar14;
                            jSONArrayOptJSONArray = jSONArray;
                            sVar = sVar13;
                            i16 = i39;
                            j3 = j4;
                        }
                        i5 = i16;
                        j = j3;
                        sVar2 = sVar;
                        sVar3 = sVar11;
                    } else {
                        i5 = i16;
                        j = j3;
                        sVar2 = sVar;
                        sVar3 = sVar11;
                        arrayList3 = null;
                    }
                    com.five_corp.ad.internal.ad.f fVar3 = new com.five_corp.ad.internal.ad.f(i35, arrayList3);
                    JSONObject jSONObject8 = jSONObject5.getJSONObject(ApsMetricsDataMap.APSMETRICS_FIELD_REFRESHFLAG);
                    j jVar3 = new j(fVar3, new com.five_corp.ad.internal.ad.l(!jSONObject8.isNull("mes") ? jSONObject8.getString("mes") : null));
                    if (1 != i35 || string3 != null) {
                        if (arrayList3 != null) {
                            Iterator it = arrayList3.iterator();
                            while (it.hasNext()) {
                                if (1 == ((com.five_corp.ad.internal.ad.h) it.next()).b && string3 == null) {
                                    throw new JSONException("iu is required when informationIconClickChoiceType is OPEN_URL_OF_INFORMATION");
                                }
                            }
                        }
                        jVar = jVar3;
                        break;
                    }
                    throw new JSONException("iu is required when informationIconClickActionType is OPEN_URL_OF_INFORMATION");
                }
                i33++;
                length5 = i34;
                iArrB5 = iArr2;
                i16 = i16;
                i32 = 2;
            }
        } else {
            i5 = i16;
            j = j3;
            sVar2 = sVar;
            sVar3 = sVar11;
            jVar = null;
        }
        String string5 = jSONObject.has("an") ? jSONObject.getString("an") : null;
        String string6 = jSONObject.has("ti") ? jSONObject.getString("ti") : null;
        String string7 = jSONObject.has("bt") ? jSONObject.getString("bt") : null;
        String string8 = jSONObject.has("dt") ? jSONObject.getString("dt") : null;
        String string9 = jSONObject.has("ldt") ? jSONObject.getString("ldt") : null;
        List listEmptyList = Collections.emptyList();
        if (jSONObject.has("tr")) {
            JSONArray jSONArray2 = jSONObject.getJSONArray("tr");
            ArrayList arrayList4 = new ArrayList();
            for (int i42 = 0; i42 < jSONArray2.length(); i42++) {
                JSONObject jSONObject9 = jSONArray2.getJSONObject(i42);
                int i43 = jSONObject9.getInt("ev");
                com.five_corp.ad.internal.ad.beacon.e[] eVarArrValues = com.five_corp.ad.internal.ad.beacon.e.values();
                int length7 = eVarArrValues.length;
                int i44 = 0;
                while (true) {
                    if (i44 >= length7) {
                        throw new com.five_corp.ad.internal.exception.a(com.five_corp.ad.internal.p.W0, i43);
                    }
                    eVar = eVarArrValues[i44];
                    if (eVar.f1270a == i43) {
                        break;
                    }
                    i44++;
                }
                arrayList4.add(new com.five_corp.ad.internal.ad.beacon.d(eVar, jSONObject9.getString(ApsMetricsDataMap.APSMETRICS_FIELD_URL), jSONObject9.has(ApsMetricsDataMap.APSMETRICS_FIELD_CUSTOM) ? d.a(jSONObject9.getJSONObject(ApsMetricsDataMap.APSMETRICS_FIELD_CUSTOM)) : null));
            }
            list = arrayList4;
        } else {
            list = listEmptyList;
        }
        JSONArray jSONArray3 = jSONObject.getJSONArray("scfg");
        ArrayList arrayList5 = new ArrayList();
        for (int i45 = 0; i45 < jSONArray3.length(); i45++) {
            JSONObject jSONObject10 = jSONArray3.getJSONObject(i45);
            arrayList5.add(new t(jSONObject10.getString("s"), jSONObject10.getInt(ApsMetricsDataMap.APSMETRICS_FIELD_CUSTOM)));
        }
        JSONArray jSONArray4 = jSONObject.getJSONArray("cfgs");
        ArrayList arrayList6 = new ArrayList();
        int i46 = 0;
        while (i46 < jSONArray4.length()) {
            JSONObject jSONObject11 = jSONArray4.getJSONObject(i46);
            int i47 = jSONObject11.getInt("id");
            com.five_corp.ad.internal.ad.custom_layout.d dVarB = jSONObject11.has("lo") ? f.b(jSONObject11.getJSONObject("lo")) : null;
            if (jSONObject11.has(fe.P0)) {
                JSONObject jSONObject12 = jSONObject11.getJSONObject(fe.P0);
                int iA = jSONObject12.has("ori") ? k.a(jSONObject12.getInt("ori")) : 0;
                JSONObject jSONObject13 = jSONObject12.getJSONObject("fmid");
                int i48 = jSONObject13.getInt(ApsMetricsDataMap.APSMETRICS_FIELD_TIMESTAMP);
                if (1 == i48) {
                    throw new com.five_corp.ad.internal.exception.b(com.five_corp.ad.internal.p.O0, "");
                }
                int[] iArrB7 = com.five_corp.ad.e.b(2);
                int length8 = iArrB7.length;
                int i49 = 0;
                while (true) {
                    if (i49 >= length8) {
                        throw new com.five_corp.ad.internal.exception.a(com.five_corp.ad.internal.p.O0, i48);
                    }
                    int i50 = length8;
                    int i51 = iArrB7[i49];
                    int[] iArr3 = iArrB7;
                    if (i51 == 1) {
                        i8 = 1;
                    } else {
                        if (i51 != 2) {
                            throw null;
                        }
                        i8 = 2;
                    }
                    if (i8 == i48) {
                        JSONObject jSONObject14 = jSONObject13.getJSONObject("cf");
                        int iA2 = k.a(jSONObject14.getInt("o"));
                        boolean z = jSONObject14.has(ApsMetricsDataMap.APSMETRICS_FIELD_CUSTOM) ? jSONObject14.getBoolean(ApsMetricsDataMap.APSMETRICS_FIELD_CUSTOM) : false;
                        if (jSONObject14.has("ex")) {
                            JSONObject jSONObject15 = jSONObject14.getJSONObject("ex");
                            int iA3 = com.five_corp.ad.internal.ad.fullscreen.c.a(jSONObject15.getInt("p"));
                            JSONObject jSONObject16 = jSONObject15.getJSONObject("s");
                            fVar = new com.five_corp.ad.internal.ad.fullscreen.f(iA3, new com.five_corp.ad.internal.ad.fullscreen.d(jSONObject16.getDouble("pw"), jSONObject16.getDouble("pr"), jSONObject16.getDouble("lw"), jSONObject16.getDouble("lr")), g.a(jSONObject15.getJSONObject("o")));
                        } else {
                            fVar = null;
                        }
                        if (jSONObject14.has("rd")) {
                            JSONObject jSONObject17 = jSONObject14.getJSONObject("rd");
                            int iA4 = com.five_corp.ad.internal.ad.fullscreen.c.a(jSONObject17.getInt("p"));
                            JSONObject jSONObject18 = jSONObject17.getJSONObject("s");
                            oVar = new o(iA4, new com.five_corp.ad.internal.ad.fullscreen.d(jSONObject18.getDouble("pw"), jSONObject18.getDouble("pr"), jSONObject18.getDouble("lw"), jSONObject18.getDouble("lr")), g.a(jSONObject17.getJSONObject("o")));
                        } else {
                            oVar = null;
                        }
                        if (jSONObject14.has("sn")) {
                            JSONObject jSONObject19 = jSONObject14.getJSONObject("sn");
                            int iA5 = com.five_corp.ad.internal.ad.fullscreen.c.a(jSONObject19.getInt("p"));
                            JSONObject jSONObject20 = jSONObject19.getJSONObject("s");
                            pVar = new p(iA5, new com.five_corp.ad.internal.ad.fullscreen.d(jSONObject20.getDouble("pw"), jSONObject20.getDouble("pr"), jSONObject20.getDouble("lw"), jSONObject20.getDouble("lr")), g.a(jSONObject19.getJSONObject("eo")), g.a(jSONObject19.getJSONObject("do")));
                        } else {
                            pVar = null;
                        }
                        com.five_corp.ad.internal.ad.fullscreen.g gVar = new com.five_corp.ad.internal.ad.fullscreen.g(new com.five_corp.ad.internal.ad.fullscreen.h(iA2, z, fVar, oVar, pVar, jSONObject14.has("bg") ? i.a(jSONObject14.getJSONObject("bg")) : null, f.b(jSONObject14.getJSONObject("lo")), jSONObject14.has("lbg") ? i.a(jSONObject14.getJSONObject("lbg")) : null, jSONObject14.has("llo") ? f.b(jSONObject14.getJSONObject("llo")) : null));
                        JSONObject jSONObject21 = jSONObject12.getJSONObject("fpost");
                        int i52 = jSONObject21.getInt("tp");
                        if (1 == i52) {
                            throw new com.five_corp.ad.internal.exception.b(com.five_corp.ad.internal.p.C1, "");
                        }
                        int i53 = 2;
                        int[] iArrB8 = com.five_corp.ad.e.b(2);
                        int length9 = iArrB8.length;
                        int i54 = 0;
                        while (true) {
                            if (i54 >= length9) {
                                throw new com.five_corp.ad.internal.exception.a(com.five_corp.ad.internal.p.V0, i52);
                            }
                            int i55 = length9;
                            int i56 = iArrB8[i54];
                            int[] iArr4 = iArrB8;
                            if (i56 == 1) {
                                sVar10 = null;
                                i9 = 1;
                            } else {
                                if (i56 != i53) {
                                    throw null;
                                }
                                i9 = 5;
                                sVar10 = null;
                            }
                            if (i9 == i52) {
                                JSONObject jSONObject22 = jSONObject21.getJSONObject("cf");
                                k.a(jSONObject22.getInt("o"));
                                boolean z2 = jSONObject22.has(ApsMetricsDataMap.APSMETRICS_FIELD_CUSTOM) ? jSONObject22.getBoolean(ApsMetricsDataMap.APSMETRICS_FIELD_CUSTOM) : false;
                                s sVarA3 = jSONObject22.has(str3) ? i.a(jSONObject22.getJSONObject(str3)) : sVar10;
                                if (jSONObject22.has("ex")) {
                                    JSONObject jSONObject23 = jSONObject22.getJSONObject("ex");
                                    int iA6 = com.five_corp.ad.internal.ad.fullscreen.c.a(jSONObject23.getInt("p"));
                                    JSONObject jSONObject24 = jSONObject23.getJSONObject("s");
                                    str2 = r15;
                                    fVar2 = new com.five_corp.ad.internal.ad.fullscreen.f(iA6, new com.five_corp.ad.internal.ad.fullscreen.d(jSONObject24.getDouble("pw"), jSONObject24.getDouble("pr"), jSONObject24.getDouble("lw"), jSONObject24.getDouble(str2)), g.a(jSONObject23.getJSONObject("o")));
                                } else {
                                    str2 = r15;
                                    fVar2 = null;
                                }
                                if (jSONObject22.has(r2)) {
                                    JSONObject jSONObject25 = jSONObject22.getJSONObject("rd");
                                    int iA7 = com.five_corp.ad.internal.ad.fullscreen.c.a(jSONObject25.getInt("p"));
                                    JSONObject jSONObject26 = jSONObject25.getJSONObject("s");
                                    oVar2 = new o(iA7, new com.five_corp.ad.internal.ad.fullscreen.d(jSONObject26.getDouble("pw"), jSONObject26.getDouble("pr"), jSONObject26.getDouble("lw"), jSONObject26.getDouble(str2)), g.a(jSONObject25.getJSONObject("o")));
                                } else {
                                    oVar2 = null;
                                }
                                jVar2 = new com.five_corp.ad.internal.ad.fullscreen.j(iA, gVar, new com.five_corp.ad.internal.ad.fullscreen.l(new com.five_corp.ad.internal.ad.fullscreen.m(z2, sVarA3, fVar2, oVar2, jSONObject22.has("bg") ? i.a(jSONObject22.getJSONObject("bg")) : null, f.b(jSONObject22.getJSONObject("lo")), jSONObject22.has("lbg") ? i.a(jSONObject22.getJSONObject("lbg")) : null, jSONObject22.has(
                                /*  JADX ERROR: Method code generation error
                                    jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x07f5: CONSTRUCTOR (r14v28 'jVar2' com.five_corp.ad.internal.ad.fullscreen.j) = 
                                      (r3v34 'iA' int)
                                      (r14v19 'gVar' com.five_corp.ad.internal.ad.fullscreen.g)
                                      (wrap com.five_corp.ad.internal.ad.fullscreen.l:0x07dd: CONSTRUCTOR 
                                      (wrap com.five_corp.ad.internal.ad.fullscreen.m:0x07d8: CONSTRUCTOR 
                                      (r68v1 'z2' boolean)
                                      (r69v1 'sVarA3' com.five_corp.ad.internal.ad.s)
                                      (r70v1 'fVar2' com.five_corp.ad.internal.ad.fullscreen.f)
                                      (r71v1 'oVar2' com.five_corp.ad.internal.ad.fullscreen.o)
                                      (wrap com.five_corp.ad.internal.ad.s:?: TERNARY null = ((wrap boolean:0x078f: INVOKE (r0v28 'jSONObject22' org.json.JSONObject), ("bg") VIRTUAL call: org.json.JSONObject.has(java.lang.String):boolean A[MD:(java.lang.String):boolean (c), WRAPPED] (LINE:87)) != false) ? (wrap ??:0x079d: INVOKE 
                                      (wrap org.json.JSONObject:0x0795: INVOKE (r0v28 'jSONObject22' org.json.JSONObject), ("bg") VIRTUAL call: org.json.JSONObject.getJSONObject(java.lang.String):org.json.JSONObject A[MD:(java.lang.String):org.json.JSONObject throws org.json.JSONException (c), WRAPPED] (LINE:72))
                                     STATIC call: com.five_corp.ad.internal.parser.i.a(org.json.JSONObject):com.five_corp.ad.internal.ad.s A[MD:(org.json.JSONObject):com.five_corp.ad.internal.ad.s (m), WRAPPED] (LINE:72)) : (null com.five_corp.ad.internal.ad.s))
                                      (wrap com.five_corp.ad.internal.ad.custom_layout.d:0x07a6: INVOKE 
                                      (wrap org.json.JSONObject:0x07a2: INVOKE (r0v28 'jSONObject22' org.json.JSONObject), ("lo") VIRTUAL call: org.json.JSONObject.getJSONObject(java.lang.String):org.json.JSONObject A[MD:(java.lang.String):org.json.JSONObject throws org.json.JSONException (c), WRAPPED])
                                     STATIC call: com.five_corp.ad.internal.parser.f.b(org.json.JSONObject):com.five_corp.ad.internal.ad.custom_layout.d A[MD:(org.json.JSONObject):com.five_corp.ad.internal.ad.custom_layout.d throws org.json.JSONException, com.five_corp.ad.internal.exception.b (m), WRAPPED])
                                      (wrap com.five_corp.ad.internal.ad.s:?: TERNARY null = ((wrap boolean:0x07aa: INVOKE (r0v28 'jSONObject22' org.json.JSONObject), ("lbg") VIRTUAL call: org.json.JSONObject.has(java.lang.String):boolean A[MD:(java.lang.String):boolean (c), WRAPPED]) != false) ? (wrap ??:0x07b8: INVOKE 
                                      (wrap org.json.JSONObject:0x07b0: INVOKE (r0v28 'jSONObject22' org.json.JSONObject), ("lbg") VIRTUAL call: org.json.JSONObject.getJSONObject(java.lang.String):org.json.JSONObject A[MD:(java.lang.String):org.json.JSONObject throws org.json.JSONException (c), WRAPPED])
                                     STATIC call: com.five_corp.ad.internal.parser.i.a(org.json.JSONObject):com.five_corp.ad.internal.ad.s A[MD:(org.json.JSONObject):com.five_corp.ad.internal.ad.s (m), WRAPPED]) : (null com.five_corp.ad.internal.ad.s))
                                      (wrap com.five_corp.ad.internal.ad.custom_layout.d:?: TERNARY null = ((wrap boolean:0x07c1: INVOKE (r0v28 'jSONObject22' org.json.JSONObject), (r49v5 java.lang.String) VIRTUAL call: org.json.JSONObject.has(java.lang.String):boolean A[MD:(java.lang.String):boolean (c), WRAPPED]) != false) ? (wrap ??:0x07cf: INVOKE 
                                      (wrap org.json.JSONObject:0x07c7: INVOKE (r0v28 'jSONObject22' org.json.JSONObject), ("llo") VIRTUAL call: org.json.JSONObject.getJSONObject(java.lang.String):org.json.JSONObject A[MD:(java.lang.String):org.json.JSONObject throws org.json.JSONException (c), WRAPPED])
                                     STATIC call: com.five_corp.ad.internal.parser.f.b(org.json.JSONObject):com.five_corp.ad.internal.ad.custom_layout.d A[MD:(org.json.JSONObject):com.five_corp.ad.internal.ad.custom_layout.d throws org.json.JSONException, com.five_corp.ad.internal.exception.b (m), WRAPPED]) : (null com.five_corp.ad.internal.ad.custom_layout.d))
                                     A[MD:(boolean, com.five_corp.ad.internal.ad.s, com.five_corp.ad.internal.ad.fullscreen.f, com.five_corp.ad.internal.ad.fullscreen.o, com.five_corp.ad.internal.ad.s, com.five_corp.ad.internal.ad.custom_layout.d, com.five_corp.ad.internal.ad.s, com.five_corp.ad.internal.ad.custom_layout.d):void (m), WRAPPED] (LINE:87) call: com.five_corp.ad.internal.ad.fullscreen.m.<init>(boolean, com.five_corp.ad.internal.ad.s, com.five_corp.ad.internal.ad.fullscreen.f, com.five_corp.ad.internal.ad.fullscreen.o, com.five_corp.ad.internal.ad.s, com.five_corp.ad.internal.ad.custom_layout.d, com.five_corp.ad.internal.ad.s, com.five_corp.ad.internal.ad.custom_layout.d):void type: CONSTRUCTOR)
                                     A[MD:(com.five_corp.ad.internal.ad.fullscreen.m):void (m), WRAPPED] (LINE:88) call: com.five_corp.ad.internal.ad.fullscreen.l.<init>(com.five_corp.ad.internal.ad.fullscreen.m):void type: CONSTRUCTOR)
                                      (wrap java.lang.String:?: TERNARY null = ((wrap boolean:0x07e2: INVOKE (r12v12 'jSONObject12' org.json.JSONObject), ("bg") VIRTUAL call: org.json.JSONObject.has(java.lang.String):boolean A[MD:(java.lang.String):boolean (c), WRAPPED] (LINE:89)) != false) ? (wrap ??:0x07e8: INVOKE (r12v12 'jSONObject12' org.json.JSONObject), ("bg") VIRTUAL call: org.json.JSONObject.getString(java.lang.String):java.lang.String A[MD:(java.lang.String):java.lang.String throws org.json.JSONException (c), WRAPPED] (LINE:72)) : ("FF000000"))
                                     A[MD:(int, com.five_corp.ad.internal.ad.fullscreen.g, com.five_corp.ad.internal.ad.fullscreen.l, java.lang.String):void (m)] (LINE:89) call: com.five_corp.ad.internal.ad.fullscreen.j.<init>(int, com.five_corp.ad.internal.ad.fullscreen.g, com.five_corp.ad.internal.ad.fullscreen.l, java.lang.String):void type: CONSTRUCTOR in method: com.five_corp.ad.internal.parser.b.a(org.json.JSONObject):com.five_corp.ad.internal.ad.a, file: classes12.dex
                                    	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:310)
                                    	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:273)
                                    	at jadx.core.codegen.RegionGen.makeSimpleBlock(RegionGen.java:94)
                                    	at jadx.core.dex.nodes.IBlock.generate(IBlock.java:15)
                                    	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:66)
                                    	at jadx.core.dex.regions.Region.generate(Region.java:35)
                                    	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:66)
                                    	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:83)
                                    	at jadx.core.codegen.RegionGen.makeIf(RegionGen.java:126)
                                    	at jadx.core.dex.regions.conditions.IfRegion.generate(IfRegion.java:90)
                                    	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:66)
                                    	at jadx.core.dex.regions.Region.generate(Region.java:35)
                                    	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:66)
                                    	at jadx.core.dex.regions.Region.generate(Region.java:35)
                                    	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:66)
                                    	at jadx.core.dex.regions.Region.generate(Region.java:35)
                                    	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:66)
                                    	at jadx.core.dex.regions.Region.generate(Region.java:35)
                                    	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:66)
                                    	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:83)
                                    	at jadx.core.codegen.RegionGen.makeLoop(RegionGen.java:175)
                                    	at jadx.core.dex.regions.loops.LoopRegion.generate(LoopRegion.java:173)
                                    	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:66)
                                    	at jadx.core.dex.regions.Region.generate(Region.java:35)
                                    	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:66)
                                    	at jadx.core.dex.regions.Region.generate(Region.java:35)
                                    	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:66)
                                    	at jadx.core.dex.regions.Region.generate(Region.java:35)
                                    	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:66)
                                    	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:83)
                                    	at jadx.core.codegen.RegionGen.makeIf(RegionGen.java:126)
                                    	at jadx.core.dex.regions.conditions.IfRegion.generate(IfRegion.java:90)
                                    	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:66)
                                    	at jadx.core.dex.regions.Region.generate(Region.java:35)
                                    	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:66)
                                    	at jadx.core.dex.regions.Region.generate(Region.java:35)
                                    	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:66)
                                    	at jadx.core.dex.regions.Region.generate(Region.java:35)
                                    	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:66)
                                    	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:83)
                                    	at jadx.core.codegen.RegionGen.makeLoop(RegionGen.java:175)
                                    	at jadx.core.dex.regions.loops.LoopRegion.generate(LoopRegion.java:173)
                                    	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:66)
                                    	at jadx.core.dex.regions.Region.generate(Region.java:35)
                                    	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:66)
                                    	at jadx.core.dex.regions.Region.generate(Region.java:35)
                                    	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:66)
                                    	at jadx.core.dex.regions.Region.generate(Region.java:35)
                                    	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:66)
                                    	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:83)
                                    	at jadx.core.codegen.RegionGen.makeIf(RegionGen.java:126)
                                    	at jadx.core.dex.regions.conditions.IfRegion.generate(IfRegion.java:90)
                                    	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:66)
                                    	at jadx.core.dex.regions.Region.generate(Region.java:35)
                                    	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:66)
                                    	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:83)
                                    	at jadx.core.codegen.RegionGen.makeLoop(RegionGen.java:226)
                                    	at jadx.core.dex.regions.loops.LoopRegion.generate(LoopRegion.java:173)
                                    	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:66)
                                    	at jadx.core.dex.regions.Region.generate(Region.java:35)
                                    	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:66)
                                    	at jadx.core.codegen.MethodGen.addRegionInsns(MethodGen.java:291)
                                    	at jadx.core.codegen.MethodGen.addInstructions(MethodGen.java:270)
                                    	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:420)
                                    	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:345)
                                    	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$2(ClassGen.java:299)
                                    	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.accept(Unknown Source)
                                    	at java.base/java.util.ArrayList.forEach(Unknown Source)
                                    	at java.base/java.util.stream.SortedOps$RefSortingSink.end(Unknown Source)
                                    	at java.base/java.util.stream.Sink$ChainedReference.end(Unknown Source)
                                    	at java.base/java.util.stream.ReferencePipeline$7$1FlatMap.end(Unknown Source)
                                    	at java.base/java.util.stream.AbstractPipeline.copyInto(Unknown Source)
                                    	at java.base/java.util.stream.AbstractPipeline.wrapAndCopyInto(Unknown Source)
                                    	at java.base/java.util.stream.ForEachOps$ForEachOp.evaluateSequential(Unknown Source)
                                    	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.evaluateSequential(Unknown Source)
                                    	at java.base/java.util.stream.AbstractPipeline.evaluate(Unknown Source)
                                    	at java.base/java.util.stream.ReferencePipeline.forEach(Unknown Source)
                                    	at jadx.core.codegen.ClassGen.addInnerClsAndMethods(ClassGen.java:295)
                                    	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:284)
                                    	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:268)
                                    	at jadx.core.codegen.ClassGen.addClassCode(ClassGen.java:160)
                                    	at jadx.core.codegen.ClassGen.makeClass(ClassGen.java:104)
                                    	at jadx.core.codegen.CodeGen.wrapCodeGen(CodeGen.java:45)
                                    	at jadx.core.codegen.CodeGen.generateJavaCode(CodeGen.java:34)
                                    	at jadx.core.codegen.CodeGen.generate(CodeGen.java:22)
                                    	at jadx.core.ProcessClass.process(ProcessClass.java:89)
                                    	at jadx.core.ProcessClass.generateCode(ProcessClass.java:127)
                                    	at jadx.core.dex.nodes.ClassNode.generateClassCode(ClassNode.java:405)
                                    	at jadx.core.dex.nodes.ClassNode.decompile(ClassNode.java:393)
                                    	at jadx.core.dex.nodes.ClassNode.decompile(ClassNode.java:311)
                                    Caused by: jadx.core.utils.exceptions.JadxRuntimeException: Code variable not set in r49v5 java.lang.String
                                    	at jadx.core.dex.instructions.args.SSAVar.getCodeVar(SSAVar.java:236)
                                    */
                                /*
                                    Method dump skipped, instruction units count: 2943
                                    To view this dump change 'Code comments level' option to 'DEBUG'
                                */
                                throw new UnsupportedOperationException("Method not decompiled: com.five_corp.ad.internal.parser.b.a(org.json.JSONObject):com.five_corp.ad.internal.ad.a");
                            }
                        }
