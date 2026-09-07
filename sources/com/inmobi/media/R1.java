package com.inmobi.media;

import android.content.Context;
import android.location.LocationManager;
import android.os.Build;
import android.telephony.CellInfo;
import android.telephony.CellLocation;
import android.telephony.TelephonyManager;
import android.telephony.cdma.CdmaCellLocation;
import android.telephony.gsm.GsmCellLocation;
import io.bidmachine.iab.vast.tags.VastTagName;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONArray;

/* JADX INFO: loaded from: classes7.dex */
public abstract class R1 {
    public static HashMap a() {
        String lowerCase;
        int i;
        int i2;
        int i3;
        int i4;
        HashMap map = new HashMap();
        Context contextD = C3517pb.d();
        if (contextD == null) {
            return map;
        }
        int cellOperatorFlag = C3601vb.a(C3517pb.b()).getCellOperatorFlag();
        boolean z = (cellOperatorFlag & 2) == 2;
        boolean z2 = (cellOperatorFlag & 1) == 1;
        Object systemService = contextD.getSystemService("phone");
        Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.telephony.TelephonyManager");
        TelephonyManager telephonyManager = (TelephonyManager) systemService;
        if (z) {
            lowerCase = null;
            i = -1;
            i2 = -1;
        } else {
            int[] iArrA = a(telephonyManager.getNetworkOperator());
            i2 = iArrA[0];
            i = iArrA[1];
            String networkCountryIso = telephonyManager.getNetworkCountryIso();
            if (networkCountryIso != null) {
                Locale ENGLISH = Locale.ENGLISH;
                Intrinsics.checkNotNullExpressionValue(ENGLISH, "ENGLISH");
                lowerCase = networkCountryIso.toLowerCase(ENGLISH);
                Intrinsics.checkNotNullExpressionValue(lowerCase, "this as java.lang.String).toLowerCase(locale)");
            } else {
                lowerCase = null;
            }
        }
        if (z2) {
            i3 = -1;
            i4 = -1;
        } else {
            int[] iArrA2 = a(telephonyManager.getSimOperator());
            i4 = iArrA2[0];
            i3 = iArrA2[1];
        }
        String string = (i4 == -1 && i3 == -1) ? null : new StringBuilder().append(i4).append('_').append(i3).toString();
        if (string != null) {
            map.put("s-ho", string);
        }
        String string2 = (i2 == -1 && i == -1) ? null : new StringBuilder().append(i2).append('_').append(i).toString();
        if (string2 != null) {
            map.put("s-co", string2);
        }
        if (lowerCase != null) {
            map.put("s-iso", lowerCase);
        }
        map.put("s-cn", C3435k3.f3355a.a(contextD));
        return map;
    }

    /* JADX WARN: Code duplicated, block: B:28:0x0082  */
    /* JADX WARN: Code duplicated, block: B:35:0x009b  */
    /* JADX WARN: Code duplicated, block: B:37:0x00a1  */
    /* JADX WARN: Code duplicated, block: B:38:0x00a6  */
    /* JADX WARN: Code duplicated, block: B:40:0x00e9  */
    /* JADX WARN: Code duplicated, block: B:42:0x00f1  */
    /* JADX WARN: Code duplicated, block: B:43:0x00f6  */
    public static HashMap b() {
        Context contextD;
        CellLocation cellLocation;
        int networkType;
        int networkType2;
        String strH = C3517pb.f3400a.h();
        Q1 q1 = null;
        if ((strH == null || C3601vb.a(strH).isConnectedCellTowerEnabled()) && d() && e() && (contextD = C3517pb.d()) != null) {
            Object systemService = contextD.getSystemService("phone");
            Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.telephony.TelephonyManager");
            TelephonyManager telephonyManager = (TelephonyManager) systemService;
            int[] iArrA = a(telephonyManager.getNetworkOperator());
            String mcc = String.valueOf(iArrA[0]);
            String strValueOf = String.valueOf(iArrA[1]);
            List<CellInfo> allCellInfo = telephonyManager.getAllCellInfo();
            if (allCellInfo != null) {
                int size = allCellInfo.size();
                CellInfo cellInfo = null;
                for (int i = 0; i < size; i++) {
                    cellInfo = allCellInfo.get(i);
                    if (cellInfo.isRegistered()) {
                        break;
                    }
                }
                if (cellInfo != null) {
                    q1 = new Q1(cellInfo, mcc, strValueOf, Build.VERSION.SDK_INT >= 30 ? telephonyManager.getDataNetworkType() : telephonyManager.getNetworkType());
                } else {
                    cellLocation = telephonyManager.getCellLocation();
                    if (cellLocation != null && iArrA[0] != -1) {
                        q1 = new Q1();
                        if (cellLocation instanceof CdmaCellLocation) {
                            q1.b = Integer.MAX_VALUE;
                            if (Build.VERSION.SDK_INT >= 30) {
                                networkType2 = telephonyManager.getDataNetworkType();
                            } else {
                                networkType2 = telephonyManager.getNetworkType();
                            }
                            q1.c = networkType2;
                            CdmaCellLocation cdmaCellLocation = (CdmaCellLocation) cellLocation;
                            int systemId = cdmaCellLocation.getSystemId();
                            int networkId = cdmaCellLocation.getNetworkId();
                            int baseStationId = cdmaCellLocation.getBaseStationId();
                            Intrinsics.checkNotNullParameter(mcc, "mcc");
                            q1.f3172a = mcc + '#' + systemId + '#' + networkId + '#' + baseStationId;
                        } else {
                            GsmCellLocation gsmCellLocation = (GsmCellLocation) cellLocation;
                            q1.b = Integer.MAX_VALUE;
                            if (Build.VERSION.SDK_INT >= 30) {
                                networkType = telephonyManager.getDataNetworkType();
                            } else {
                                networkType = telephonyManager.getNetworkType();
                            }
                            q1.c = networkType;
                            q1.f3172a = Q1.a(mcc, strValueOf, gsmCellLocation.getLac(), gsmCellLocation.getCid(), gsmCellLocation.getPsc(), Integer.MAX_VALUE);
                        }
                    }
                }
            } else {
                cellLocation = telephonyManager.getCellLocation();
                if (cellLocation != null) {
                    q1 = new Q1();
                    if (cellLocation instanceof CdmaCellLocation) {
                        q1.b = Integer.MAX_VALUE;
                        if (Build.VERSION.SDK_INT >= 30) {
                            networkType2 = telephonyManager.getDataNetworkType();
                        } else {
                            networkType2 = telephonyManager.getNetworkType();
                        }
                        q1.c = networkType2;
                        CdmaCellLocation cdmaCellLocation2 = (CdmaCellLocation) cellLocation;
                        int systemId2 = cdmaCellLocation2.getSystemId();
                        int networkId2 = cdmaCellLocation2.getNetworkId();
                        int baseStationId2 = cdmaCellLocation2.getBaseStationId();
                        Intrinsics.checkNotNullParameter(mcc, "mcc");
                        q1.f3172a = mcc + '#' + systemId2 + '#' + networkId2 + '#' + baseStationId2;
                    } else {
                        GsmCellLocation gsmCellLocation2 = (GsmCellLocation) cellLocation;
                        q1.b = Integer.MAX_VALUE;
                        if (Build.VERSION.SDK_INT >= 30) {
                            networkType = telephonyManager.getDataNetworkType();
                        } else {
                            networkType = telephonyManager.getNetworkType();
                        }
                        q1.c = networkType;
                        q1.f3172a = Q1.a(mcc, strValueOf, gsmCellLocation2.getLac(), gsmCellLocation2.getCid(), gsmCellLocation2.getPsc(), Integer.MAX_VALUE);
                    }
                }
            }
        }
        HashMap map = new HashMap();
        if (q1 != null) {
            String string = q1.a().toString();
            Intrinsics.checkNotNullExpressionValue(string, "toString(...)");
            map.put("c-sc", string);
        }
        return map;
    }

    public static HashMap c() {
        ArrayList arrayList;
        String strH;
        Context contextD;
        if (C3517pb.q() && d() && e() && (((strH = C3517pb.f3400a.h()) == null || C3601vb.a(strH).isVisibleCellTowerEnabled()) && (contextD = C3517pb.d()) != null)) {
            Object systemService = contextD.getSystemService("phone");
            Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.telephony.TelephonyManager");
            TelephonyManager telephonyManager = (TelephonyManager) systemService;
            ArrayList arrayList2 = new ArrayList();
            int[] iArrA = a(telephonyManager.getNetworkOperator());
            String strValueOf = String.valueOf(iArrA[0]);
            String strValueOf2 = String.valueOf(iArrA[1]);
            List<CellInfo> allCellInfo = telephonyManager.getAllCellInfo();
            if (allCellInfo != null) {
                for (CellInfo cellInfo : allCellInfo) {
                    if (!cellInfo.isRegistered()) {
                        arrayList2.add(new Q1(cellInfo, strValueOf, strValueOf2, Build.VERSION.SDK_INT >= 30 ? telephonyManager.getDataNetworkType() : telephonyManager.getNetworkType()));
                    }
                }
            }
            arrayList = arrayList2;
        } else {
            arrayList = new ArrayList();
        }
        HashMap map = new HashMap();
        if (!arrayList.isEmpty()) {
            JSONArray jSONArray = new JSONArray();
            jSONArray.put(((Q1) arrayList.get(arrayList.size() - 1)).a());
            String string = jSONArray.toString();
            Intrinsics.checkNotNullExpressionValue(string, "toString(...)");
            map.put("v-sc", string);
        }
        return map;
    }

    public static boolean d() {
        if (!C3517pb.q()) {
            return false;
        }
        boolean zA = AbstractC3599v9.a(C3517pb.d(), "android.permission.READ_PHONE_STATE");
        boolean zA2 = AbstractC3599v9.a(C3517pb.d(), "android.permission.ACCESS_FINE_LOCATION");
        int i = Build.VERSION.SDK_INT;
        if (i == 29) {
            if (!zA2) {
                Intrinsics.checkNotNullExpressionValue(VastTagName.R1, "TAG");
            }
            return zA2;
        }
        if (i >= 30) {
            if (!zA2 || !zA) {
                Intrinsics.checkNotNullExpressionValue(VastTagName.R1, "TAG");
            }
            return zA2 && zA;
        }
        boolean zA3 = AbstractC3599v9.a(C3517pb.d(), "android.permission.ACCESS_COARSE_LOCATION");
        if (!zA3 && !zA2) {
            Intrinsics.checkNotNullExpressionValue(VastTagName.R1, "TAG");
        }
        return zA3 || zA2;
    }

    public static boolean e() {
        if (Build.VERSION.SDK_INT < 28) {
            return true;
        }
        Context contextD = C3517pb.d();
        Object systemService = contextD != null ? contextD.getSystemService("location") : null;
        LocationManager locationManager = systemService instanceof LocationManager ? (LocationManager) systemService : null;
        return locationManager != null && locationManager.isLocationEnabled();
    }

    public static int[] a(String str) {
        int[] iArr = {-1, -1};
        if (str != null && !Intrinsics.areEqual("", str)) {
            try {
                String strSubstring = str.substring(0, 3);
                Intrinsics.checkNotNullExpressionValue(strSubstring, "this as java.lang.String…ing(startIndex, endIndex)");
                int i = Integer.parseInt(strSubstring);
                String strSubstring2 = str.substring(3);
                Intrinsics.checkNotNullExpressionValue(strSubstring2, "this as java.lang.String).substring(startIndex)");
                int i2 = Integer.parseInt(strSubstring2);
                iArr[0] = i;
                iArr[1] = i2;
            } catch (IndexOutOfBoundsException | NumberFormatException unused) {
            }
        }
        return iArr;
    }
}
