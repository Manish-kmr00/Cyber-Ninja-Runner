package com.five_corp.ad.internal.parser;

import com.amazon.aps.shared.metrics.model.ApsMetricsDataMap;
import com.five_corp.ad.internal.ad.custom_layout.j;
import com.five_corp.ad.internal.ad.custom_layout.k;
import com.five_corp.ad.internal.ad.custom_layout.n;
import com.five_corp.ad.internal.p;
import com.fyber.inneractive.sdk.external.InneractiveMediationDefs;
import com.mbridge.msdk.foundation.download.core.DownloadCommon;
import io.bidmachine.iab.vast.tags.VastAttributes;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes12.dex */
public abstract class f {
    public static com.five_corp.ad.internal.ad.custom_layout.c a(JSONObject jSONObject) throws JSONException, com.five_corp.ad.internal.exception.a {
        int i;
        int i2;
        int i3 = 1;
        n nVar = new n(1, null, null);
        if (jSONObject.has("tr")) {
            JSONObject jSONObject2 = jSONObject.getJSONObject("tr");
            int i4 = jSONObject2.getInt(ApsMetricsDataMap.APSMETRICS_FIELD_TIMESTAMP);
            int[] iArrB = com.five_corp.ad.e.b(5);
            int length = iArrB.length;
            int i5 = 0;
            while (true) {
                if (i5 >= length) {
                    throw new com.five_corp.ad.internal.exception.a(p.i1, i4);
                }
                int i6 = iArrB[i5];
                if (i6 != 1) {
                    i2 = 2;
                    if (i6 != 2) {
                        if (i6 != 3) {
                            i2 = 4;
                            if (i6 != 4) {
                                if (i6 != 5) {
                                    throw null;
                                }
                                i2 = 5;
                            }
                        } else {
                            i2 = 3;
                        }
                    }
                } else {
                    i2 = 1;
                }
                if (i2 == i4) {
                    nVar = new n(i6, jSONObject2.has("s") ? Integer.valueOf(jSONObject2.getInt("s")) : null, jSONObject2.has("e") ? Integer.valueOf(jSONObject2.getInt("e")) : null);
                    break;
                }
                i5++;
            }
        }
        if (jSONObject.has("sn")) {
            int i7 = jSONObject.getInt("sn");
            int[] iArrB2 = com.five_corp.ad.e.b(3);
            int length2 = iArrB2.length;
            int i8 = 0;
            while (true) {
                if (i8 >= length2) {
                    throw new com.five_corp.ad.internal.exception.a(p.f1, i7);
                }
                i = iArrB2[i8];
                if (com.five_corp.ad.e.a(i) == i7) {
                    break;
                }
                i8++;
            }
        } else {
            i = 1;
        }
        if (jSONObject.has("ps")) {
            int i9 = jSONObject.getInt("ps");
            for (int i10 : com.five_corp.ad.e.b(3)) {
                if (com.five_corp.ad.e.a(i10) == i9) {
                    i3 = i10;
                }
            }
            throw new com.five_corp.ad.internal.exception.a(p.g1, i9);
        }
        return new com.five_corp.ad.internal.ad.custom_layout.c(nVar, i, i3);
    }

    /* JADX WARN: Code duplicated, block: B:112:0x0377 A[LOOP:1: B:6:0x0048->B:112:0x0377, LOOP_END] */
    public static com.five_corp.ad.internal.ad.custom_layout.d b(JSONObject jSONObject) throws JSONException, com.five_corp.ad.internal.exception.b {
        int i;
        JSONArray jSONArray;
        int i2;
        int i3;
        int i4;
        int i5;
        com.five_corp.ad.internal.ad.custom_layout.e eVar;
        int i6;
        ArrayList arrayList;
        ArrayList arrayList2;
        int i7;
        JSONObject jSONObject2 = jSONObject;
        int i8 = jSONObject2.getInt("w");
        int i9 = jSONObject2.getInt("h");
        JSONArray jSONArray2 = jSONObject2.getJSONArray("ls");
        ArrayList arrayList3 = new ArrayList();
        int i10 = 0;
        while (i10 < jSONArray2.length()) {
            JSONObject jSONObject3 = jSONArray2.getJSONObject(i10);
            JSONArray jSONArray3 = jSONArray2;
            JSONObject jSONObject4 = jSONObject3.getJSONObject("o");
            int i11 = jSONObject4.getInt("o");
            int i12 = i8;
            int[] iArrB = com.five_corp.ad.e.b(9);
            int i13 = i9;
            int length = iArrB.length;
            int i14 = 0;
            while (true) {
                if (i14 >= length) {
                    throw new com.five_corp.ad.internal.exception.a(p.e1, i11);
                }
                i2 = iArrB[i14];
                int[] iArr = iArrB;
                switch (i2) {
                    case 1:
                        i3 = 1;
                        if (i3 != i11) {
                            i14++;
                            arrayList3 = arrayList3;
                            iArrB = iArr;
                            break;
                        }
                        break;
                    case 2:
                        i3 = 2;
                        if (i3 != i11) {
                            i14++;
                            arrayList3 = arrayList3;
                            iArrB = iArr;
                            break;
                        }
                        break;
                    case 3:
                        i3 = 3;
                        if (i3 != i11) {
                            i14++;
                            arrayList3 = arrayList3;
                            iArrB = iArr;
                            break;
                        }
                        break;
                    case 4:
                        i3 = 4;
                        if (i3 != i11) {
                            i14++;
                            arrayList3 = arrayList3;
                            iArrB = iArr;
                            break;
                        }
                        break;
                    case 5:
                        i4 = 5;
                        i3 = i4;
                        if (i3 != i11) {
                            i14++;
                            arrayList3 = arrayList3;
                            iArrB = iArr;
                            break;
                        }
                        break;
                    case 6:
                        i4 = 6;
                        i3 = i4;
                        if (i3 != i11) {
                            i14++;
                            arrayList3 = arrayList3;
                            iArrB = iArr;
                            break;
                        }
                        break;
                    case 7:
                        i4 = 7;
                        i3 = i4;
                        if (i3 != i11) {
                            i14++;
                            arrayList3 = arrayList3;
                            iArrB = iArr;
                            break;
                        }
                        break;
                    case 8:
                        i4 = 8;
                        i3 = i4;
                        if (i3 != i11) {
                            i14++;
                            arrayList3 = arrayList3;
                            iArrB = iArr;
                            break;
                        }
                        break;
                    case 9:
                        i3 = 9;
                        if (i3 != i11) {
                            i14++;
                            arrayList3 = arrayList3;
                            iArrB = iArr;
                            break;
                        }
                        break;
                    default:
                        throw null;
                }
            }
            int iA = com.five_corp.ad.e.a(i2);
            int i15 = i10;
            ArrayList arrayList4 = arrayList3;
            switch (iA) {
                case 0:
                    JSONObject jSONObject5 = jSONObject4.getJSONObject(ApsMetricsDataMap.APSMETRICS_FIELD_TIMESTAMP);
                    String string = jSONObject5.getString(ApsMetricsDataMap.APSMETRICS_FIELD_TIMESTAMP);
                    String string2 = jSONObject5.getString(ApsMetricsDataMap.APSMETRICS_FIELD_CUSTOM);
                    String string3 = jSONObject5.getString("bg");
                    if (jSONObject5.has("g")) {
                        int i16 = jSONObject5.getInt("g");
                        int[] iArrB2 = com.five_corp.ad.e.b(3);
                        int length2 = iArrB2.length;
                        int i17 = 0;
                        while (true) {
                            if (i17 >= length2) {
                                throw new com.five_corp.ad.internal.exception.a(p.h1, i16);
                            }
                            int i18 = iArrB2[i17];
                            if (i18 == 1) {
                                i6 = 1;
                            } else if (i18 != 2) {
                                i6 = 3;
                                if (i18 != 3) {
                                    throw null;
                                }
                            } else {
                                i6 = 2;
                            }
                            if (i6 == i16) {
                                i5 = i18;
                            } else {
                                i17++;
                            }
                        }
                    } else {
                        i5 = 0;
                    }
                    eVar = new com.five_corp.ad.internal.ad.custom_layout.e(1, new k(string, string2, string3, i5, jSONObject5.has(InneractiveMediationDefs.GENDER_FEMALE) ? Boolean.valueOf(jSONObject5.getBoolean(InneractiveMediationDefs.GENDER_FEMALE)) : null, jSONObject5.has("bf") ? Boolean.valueOf(jSONObject5.getBoolean("bf")) : null, jSONObject5.has("s") ? Integer.valueOf(jSONObject5.getInt("s")) : null, jSONObject5.has("tvshackhs") ? Integer.valueOf(jSONObject5.getInt("tvshackhs")) : null), null, null, null, null, null, null);
                    break;
                case 1:
                    eVar = new com.five_corp.ad.internal.ad.custom_layout.e(2, null, i.a(jSONObject4.getJSONObject("i")), null, null, null, null, null);
                    break;
                case 2:
                    jSONObject4.getJSONObject("m");
                    eVar = new com.five_corp.ad.internal.ad.custom_layout.e(3, null, null, null, null, null, null, null);
                    break;
                case 3:
                    JSONObject jSONObject6 = jSONObject4.getJSONObject("h");
                    int i19 = jSONObject6.getInt("w");
                    jSONObject6.getInt("h");
                    if (jSONObject6.has("r")) {
                        JSONArray jSONArray4 = jSONObject6.getJSONArray("r");
                        arrayList = new ArrayList();
                        for (int i20 = 0; i20 < jSONArray4.length(); i20++) {
                            arrayList.add(i.a(jSONArray4.getJSONObject(i20)));
                        }
                    } else {
                        arrayList = null;
                    }
                    eVar = new com.five_corp.ad.internal.ad.custom_layout.e(4, null, null, new com.five_corp.ad.internal.ad.format_config.b(i19, arrayList, jSONObject6.getString("s")), null, null, null, null);
                    break;
                case 4:
                    JSONObject jSONObject7 = jSONObject4.getJSONObject("a");
                    boolean z = jSONObject7.getBoolean("r");
                    JSONArray jSONArray5 = jSONObject7.getJSONArray("is");
                    ArrayList arrayList5 = new ArrayList();
                    for (int i21 = 0; i21 < jSONArray5.length(); i21++) {
                        arrayList5.add(i.a(jSONArray5.getJSONObject(i21)));
                    }
                    eVar = new com.five_corp.ad.internal.ad.custom_layout.e(5, null, null, null, new com.five_corp.ad.internal.ad.custom_layout.f(z, arrayList5, jSONObject7.getInt("ms")), null, null, null);
                    break;
                case 5:
                    JSONObject jSONObject8 = jSONObject4.getJSONObject("p");
                    eVar = new com.five_corp.ad.internal.ad.custom_layout.e(6, null, null, null, null, new j(i.a(jSONObject8.getJSONObject(InneractiveMediationDefs.GENDER_FEMALE)), i.a(jSONObject8.getJSONObject(DownloadCommon.DOWNLOAD_REPORT_FIND_FILE_RESULT_VALUE_B))), null, null);
                    break;
                case 6:
                    JSONObject jSONObject9 = jSONObject4.getJSONObject(ApsMetricsDataMap.APSMETRICS_FIELD_CUSTOM);
                    eVar = new com.five_corp.ad.internal.ad.custom_layout.e(7, null, null, null, null, null, new com.five_corp.ad.internal.ad.custom_layout.i(jSONObject9.getString("cc"), jSONObject9.getString("bc"), jSONObject9.getString(ApsMetricsDataMap.APSMETRICS_FIELD_PLATFORMCATEGORY), jSONObject9.getString("fc")), null);
                    break;
                case 7:
                    JSONObject jSONObject10 = jSONObject4.getJSONObject("cs");
                    JSONArray jSONArray6 = jSONObject10.getJSONArray("is");
                    if (jSONArray6 == null) {
                        arrayList2 = new ArrayList();
                    } else {
                        ArrayList arrayList6 = new ArrayList();
                        for (int i22 = 0; i22 < jSONArray6.length(); i22++) {
                            arrayList6.add(i.a(jSONArray6.getJSONObject(i22)));
                        }
                        arrayList2 = arrayList6;
                    }
                    eVar = new com.five_corp.ad.internal.ad.custom_layout.e(8, null, null, null, null, null, null, new com.five_corp.ad.internal.ad.custom_layout.g(arrayList2, jSONObject10.has("bg") ? jSONObject10.getString("bg") : null));
                    break;
                case 8:
                    eVar = new com.five_corp.ad.internal.ad.custom_layout.e(9, null, null, null, null, null, null, null);
                    break;
                default:
                    throw new com.five_corp.ad.internal.exception.b(p.A3, null);
            }
            com.five_corp.ad.internal.ad.custom_layout.e eVar2 = eVar;
            int i23 = jSONObject3.getInt(VastAttributes.HORIZONTAL_POSITION);
            int i24 = jSONObject3.getInt(VastAttributes.VERTICAL_POSITION);
            int i25 = jSONObject3.getInt("z");
            int i26 = jSONObject3.getInt("w");
            int i27 = jSONObject3.getInt("h");
            com.five_corp.ad.internal.ad.custom_layout.c cVarA = jSONObject3.has("cn") ? a(jSONObject3.getJSONObject("cn")) : null;
            if (jSONObject3.has("ob")) {
                int i28 = jSONObject3.getInt("ob");
                int[] iArrB3 = com.five_corp.ad.e.b(4);
                int length3 = iArrB3.length;
                int i29 = 0;
                while (true) {
                    if (i29 >= length3) {
                        throw new com.five_corp.ad.internal.exception.a(p.y1, i28);
                    }
                    int i30 = iArrB3[i29];
                    if (com.five_corp.ad.e.a(i30) == i28) {
                        i7 = i30;
                        break;
                    }
                    i29++;
                }
            } else {
                i7 = 0;
            }
            arrayList4.add(new com.five_corp.ad.internal.ad.custom_layout.h(eVar2, i23, i24, i25, i26, i27, cVarA, i7));
            i10 = i15 + 1;
            jSONObject2 = jSONObject;
            arrayList3 = arrayList4;
            jSONArray2 = jSONArray3;
            i8 = i12;
            i9 = i13;
        }
        int i31 = i8;
        int i32 = i9;
        ArrayList arrayList7 = arrayList3;
        JSONArray jSONArray7 = jSONObject2.getJSONArray("cs");
        ArrayList arrayList8 = new ArrayList();
        int i33 = 0;
        while (i33 < jSONArray7.length()) {
            JSONObject jSONObject11 = jSONArray7.getJSONObject(i33);
            int i34 = jSONObject11.getInt(ApsMetricsDataMap.APSMETRICS_FIELD_TIMESTAMP);
            int[] iArrB4 = com.five_corp.ad.e.b(9);
            int length4 = iArrB4.length;
            int i35 = 0;
            while (true) {
                if (i35 >= length4) {
                    throw new com.five_corp.ad.internal.exception.a(p.d1, i34);
                }
                i = iArrB4[i35];
                jSONArray = jSONArray7;
                if (com.five_corp.ad.e.a(i) != i34) {
                    i35++;
                    jSONArray7 = jSONArray;
                }
            }
            arrayList8.add(new com.five_corp.ad.internal.ad.custom_layout.a(i, jSONObject11.getInt(VastAttributes.HORIZONTAL_POSITION), jSONObject11.getInt(VastAttributes.VERTICAL_POSITION), jSONObject11.getInt("z"), jSONObject11.getInt("w"), jSONObject11.getInt("h"), jSONObject11.has("cn") ? a(jSONObject11.getJSONObject("cn")) : null, jSONObject11.has("url") ? jSONObject11.getString("url") : null));
            i33++;
            jSONArray7 = jSONArray;
        }
        return new com.five_corp.ad.internal.ad.custom_layout.d(i31, i32, arrayList7, arrayList8);
    }
}
