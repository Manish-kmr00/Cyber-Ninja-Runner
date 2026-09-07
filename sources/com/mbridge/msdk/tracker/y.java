package com.mbridge.msdk.tracker;

import android.database.Cursor;
import android.text.TextUtils;
import android.util.Log;
import com.safedk.android.internal.partials.MintegralNetworkBridge;
import com.unity3d.ads.core.domain.HandleInvocationsFromAdViewer;
import com.unity3d.services.UnityAdsConstants;
import io.appmetrica.analytics.networktasks.internal.CommonUrlParts;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONException;

/* JADX INFO: compiled from: Utils.java */
/* JADX INFO: loaded from: classes7.dex */
class y {
    public static long a(int i, long j, long j2) {
        if (i <= 0 || j == 0 || i <= 10) {
            return j2;
        }
        if (i <= 20) {
            return 60000L;
        }
        if (i <= 30) {
            return UnityAdsConstants.Timeout.INIT_TIMEOUT_MS;
        }
        if (i <= 40) {
            return 180000L;
        }
        return i <= 50 ? 240000L : 300000L;
    }

    static boolean a(Object obj) {
        return obj != null;
    }

    static boolean a(List<i> list) {
        if (b((List<?>) list)) {
            return false;
        }
        for (i iVar : list) {
            if (!b(iVar)) {
                e eVarA = iVar.a();
                if (!b(eVarA) && eVarA.c() == 1) {
                    return true;
                }
            }
        }
        return false;
    }

    static boolean b(Object obj) {
        return obj == null;
    }

    static boolean b(List<?> list) {
        return list == null || list.isEmpty();
    }

    /* JADX WARN: Code duplicated, block: B:41:0x00f7  */
    static List<i> b(Cursor cursor) {
        int i;
        int i2;
        int i3;
        Cursor cursor2 = cursor;
        ArrayList arrayList = new ArrayList();
        try {
            int columnIndex = cursor2.getColumnIndex("name");
            int columnIndex2 = cursor2.getColumnIndex("type");
            int columnIndex3 = cursor2.getColumnIndex("time_stamp");
            int columnIndex4 = cursor2.getColumnIndex("properties");
            int columnIndex5 = cursor2.getColumnIndex(HandleInvocationsFromAdViewer.KEY_DOWNLOAD_PRIORITY);
            int columnIndex6 = cursor2.getColumnIndex(CommonUrlParts.UUID);
            int columnIndex7 = cursor2.getColumnIndex("duration");
            int columnIndex8 = cursor2.getColumnIndex("state");
            int columnIndex9 = cursor2.getColumnIndex("report_count");
            int columnIndex10 = cursor2.getColumnIndex("ignore_max_timeout");
            int columnIndex11 = cursor2.getColumnIndex("ignore_max_retry_times");
            int columnIndex12 = cursor2.getColumnIndex("invalid_time");
            int columnIndex13 = cursor2.getColumnIndex("report_error_message");
            while (cursor.moveToNext()) {
                try {
                    i = columnIndex;
                    try {
                        e eVar = new e(cursor2.getString(columnIndex));
                        eVar.b(cursor2.getInt(columnIndex2));
                        int i4 = columnIndex12;
                        int i5 = columnIndex13;
                        try {
                            eVar.c(cursor2.getLong(columnIndex3));
                            eVar.a(MintegralNetworkBridge.jsonObjectInit(cursor2.getString(columnIndex4)));
                            eVar.a(cursor2.getInt(columnIndex5));
                            eVar.a(cursor2.getString(columnIndex6));
                            eVar.a(cursor2.getLong(columnIndex7));
                            i iVar = new i(eVar);
                            iVar.b(cursor2.getInt(columnIndex8));
                            iVar.a(cursor2.getInt(columnIndex9));
                            boolean z = true;
                            iVar.b(cursor2.getInt(columnIndex10) == 0);
                            if (cursor2.getInt(columnIndex11) != 0) {
                                z = false;
                            }
                            iVar.a(z);
                            i2 = i4;
                            try {
                                iVar.a(cursor2.getLong(i2));
                                i3 = i5;
                                try {
                                    String string = cursor2.getString(i3);
                                    if (TextUtils.isEmpty(string)) {
                                        string = "";
                                    }
                                    iVar.a(string);
                                    arrayList.add(iVar);
                                } catch (JSONException e) {
                                    e = e;
                                    if (a.f5612a) {
                                        Log.e("TrackManager", "create: ", e);
                                    }
                                    cursor2 = cursor;
                                }
                            } catch (JSONException e2) {
                                e = e2;
                                i3 = i5;
                                if (a.f5612a) {
                                    Log.e("TrackManager", "create: ", e);
                                }
                                cursor2 = cursor;
                                columnIndex13 = i3;
                                columnIndex12 = i2;
                                columnIndex = i;
                            }
                        } catch (JSONException e3) {
                            e = e3;
                            i2 = i4;
                        }
                    } catch (JSONException e4) {
                        e = e4;
                        i2 = columnIndex12;
                        i3 = columnIndex13;
                        if (a.f5612a) {
                            Log.e("TrackManager", "create: ", e);
                        }
                        cursor2 = cursor;
                        columnIndex13 = i3;
                        columnIndex12 = i2;
                        columnIndex = i;
                    }
                } catch (JSONException e5) {
                    e = e5;
                    i = columnIndex;
                }
                columnIndex13 = i3;
                columnIndex12 = i2;
                columnIndex = i;
            }
        } catch (Exception unused) {
        }
        return arrayList;
    }

    static boolean a(e eVar) {
        return a((Object) eVar) && eVar.c() == 1;
    }

    static void a(Cursor cursor) {
        try {
            if (!a((Object) cursor) || cursor.isClosed()) {
                return;
            }
            cursor.close();
        } catch (Exception unused) {
        }
    }
}
