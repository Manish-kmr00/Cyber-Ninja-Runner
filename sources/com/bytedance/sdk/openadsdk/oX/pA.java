package com.bytedance.sdk.openadsdk.oX;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;
import com.bytedance.sdk.openadsdk.BusMonitorDependWrapper;
import io.appmetrica.analytics.coreutils.internal.StringUtils;
import java.util.ArrayList;
import java.util.List;
import net.pubnative.lite.sdk.db.DatabaseHelper;

/* JADX INFO: loaded from: classes12.dex */
public class pA {
    private static final long ML = System.currentTimeMillis();
    private static Context ZZv;
    private Boolean KZx;
    private com.bytedance.sdk.openadsdk.oX.KZx.pA Og;
    private Og pA;
    private int JG = 0;
    private final ArrayList<ZZv> SD = new ArrayList<>();
    private Runnable omh = new Runnable() { // from class: com.bytedance.sdk.openadsdk.oX.pA.2
        @Override // java.lang.Runnable
        public void run() {
            pA pAVar = pA.this;
            pAVar.KZx = Boolean.valueOf(pAVar.pA.isMonitorOpen());
            if (pA.this.KZx.booleanValue()) {
                pA pAVar2 = pA.this;
                pAVar2.pA(pAVar2.SD);
                pA.this.SD.clear();
            }
        }
    };
    private Runnable Bzk = new Runnable() { // from class: com.bytedance.sdk.openadsdk.oX.pA.4
        @Override // java.lang.Runnable
        public void run() {
            String str;
            AnonymousClass4 anonymousClass4 = this;
            String str2 = DatabaseHelper._ID;
            try {
                SQLiteDatabase sQLiteDatabaseOg = com.bytedance.sdk.openadsdk.oX.pA.pA.Og();
                if (sQLiteDatabaseOg != null) {
                    String[] strArr = new String[13];
                    try {
                        strArr[0] = DatabaseHelper._ID;
                        strArr[1] = "sdk_version";
                        strArr[2] = "scene";
                        strArr[3] = "start_count";
                        strArr[4] = "success_count";
                        strArr[5] = "fail_count";
                        strArr[6] = "rit";
                        strArr[7] = "tag";
                        strArr[8] = "label";
                        strArr[9] = "timestamp";
                        strArr[10] = "mediation";
                        strArr[11] = "is_init";
                        strArr[12] = "extra";
                        String str3 = "extra";
                        String[] strArr2 = {String.valueOf(pA.ML)};
                        int iMax = Math.max(10, pA.this.pA.getOnceLogCount());
                        if (iMax > 100) {
                            iMax = 10;
                        }
                        Cursor cursorQuery = sQLiteDatabaseOg.query("monitor_table", strArr, "timestamp <= ?", strArr2, null, null, null, String.valueOf(iMax));
                        if (cursorQuery != null) {
                            ArrayList arrayList = new ArrayList();
                            ArrayList arrayList2 = new ArrayList();
                            while (cursorQuery.moveToNext()) {
                                int i = iMax;
                                try {
                                    com.bytedance.sdk.openadsdk.oX.Og.pA pAVar = new com.bytedance.sdk.openadsdk.oX.Og.pA();
                                    if (cursorQuery.getColumnIndex(str2) >= 0) {
                                        long j = cursorQuery.getLong(cursorQuery.getColumnIndex(str2));
                                        pAVar.pA(j);
                                        arrayList2.add(String.valueOf(j));
                                    }
                                    if (cursorQuery.getColumnIndex("sdk_version") >= 0) {
                                        pAVar.pA(cursorQuery.getString(cursorQuery.getColumnIndex("sdk_version")));
                                    }
                                    if (cursorQuery.getColumnIndex("scene") >= 0) {
                                        pAVar.Og(cursorQuery.getString(cursorQuery.getColumnIndex("scene")));
                                    }
                                    if (cursorQuery.getColumnIndex("start_count") >= 0) {
                                        pAVar.pA(cursorQuery.getInt(cursorQuery.getColumnIndex("start_count")));
                                    }
                                    if (cursorQuery.getColumnIndex("success_count") >= 0) {
                                        pAVar.Og(cursorQuery.getInt(cursorQuery.getColumnIndex("success_count")));
                                    }
                                    if (cursorQuery.getColumnIndex("fail_count") >= 0) {
                                        pAVar.KZx(cursorQuery.getInt(cursorQuery.getColumnIndex("fail_count")));
                                    }
                                    if (cursorQuery.getColumnIndex("rit") >= 0) {
                                        pAVar.KZx(cursorQuery.getString(cursorQuery.getColumnIndex("rit")));
                                    }
                                    if (cursorQuery.getColumnIndex("tag") >= 0) {
                                        pAVar.ZZv(cursorQuery.getString(cursorQuery.getColumnIndex("tag")));
                                    }
                                    if (cursorQuery.getColumnIndex("label") >= 0) {
                                        pAVar.ML(cursorQuery.getString(cursorQuery.getColumnIndex("label")));
                                    }
                                    if (cursorQuery.getColumnIndex("mediation") >= 0) {
                                        pAVar.JG(cursorQuery.getString(cursorQuery.getColumnIndex("mediation")));
                                    }
                                    if (cursorQuery.getColumnIndex("is_init") >= 0) {
                                        pAVar.ZZv(cursorQuery.getInt(cursorQuery.getColumnIndex("is_init")));
                                    }
                                    String str4 = str3;
                                    if (cursorQuery.getColumnIndex(str4) >= 0) {
                                        pAVar.SD(cursorQuery.getString(cursorQuery.getColumnIndex(str4)));
                                    }
                                    ArrayList arrayList3 = arrayList;
                                    arrayList3.add(pAVar);
                                    str3 = str4;
                                    arrayList = arrayList3;
                                    iMax = i;
                                    str2 = str2;
                                    anonymousClass4 = this;
                                } catch (Throwable th) {
                                    th = th;
                                    str = "BusMonitorCenter";
                                    Log.e(str, th.getMessage());
                                }
                            }
                            int i2 = iMax;
                            ArrayList arrayList4 = arrayList;
                            cursorQuery.close();
                            str = "BusMonitorCenter";
                            try {
                                Log.i(str, "exec upload ...");
                                if (arrayList4.isEmpty()) {
                                    return;
                                }
                                try {
                                    pA.this.pA.onMonitorUpload(arrayList4);
                                    SQLiteDatabase sQLiteDatabasePA = com.bytedance.sdk.openadsdk.oX.pA.pA.pA();
                                    if (sQLiteDatabasePA != null && sQLiteDatabasePA.isOpen()) {
                                        StringBuilder sb = new StringBuilder();
                                        sb.append("_id IN (");
                                        for (int i3 = 0; i3 < arrayList2.size(); i3++) {
                                            sb.append("?");
                                            if (i3 < arrayList2.size() - 1) {
                                                sb.append(StringUtils.COMMA);
                                            }
                                        }
                                        sb.append(")");
                                        sQLiteDatabasePA.delete("monitor_table", sb.toString(), (String[]) arrayList2.toArray(new String[0]));
                                        if (pA.this.Og != null) {
                                            pA.this.Og.pA(pA.ML);
                                        }
                                    }
                                    if (arrayList4.size() < i2 || pA.this.JG > 1000) {
                                        return;
                                    }
                                    pA.this.pA(false);
                                } catch (Throwable th2) {
                                    th = th2;
                                    Log.e(str, th.getMessage());
                                }
                            } catch (Throwable th3) {
                                th = th3;
                            }
                        }
                    } catch (Throwable th4) {
                        th = th4;
                    }
                }
            } catch (Throwable th5) {
                th = th5;
                str = "BusMonitorCenter";
            }
        }
    };

    static /* synthetic */ int ZZv(pA pAVar) {
        int i = pAVar.JG;
        pAVar.JG = i + 1;
        return i;
    }

    private pA(Og og) {
        try {
            this.pA = new BusMonitorDependWrapper(og);
            this.Og = new com.bytedance.sdk.openadsdk.oX.KZx.pA(og.getContext());
            ZZv = og.getContext();
        } catch (Throwable th) {
            Log.e("BusMonitorCenter", th.getMessage());
        }
    }

    public static pA pA(Og og) {
        return new pA(og);
    }

    public static Context pA() {
        Context context = ZZv;
        return context != null ? context : BusMonitorDependWrapper.getReflectContext();
    }

    public void pA(final ZZv zZv) {
        if (zZv == null || !KZx()) {
            return;
        }
        this.pA.getHandler().post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.oX.pA.1
            @Override // java.lang.Runnable
            public void run() {
                pA pAVar = pA.this;
                pAVar.KZx = Boolean.valueOf(pAVar.pA.isMonitorOpen());
                if (pA.this.KZx.booleanValue()) {
                    pA.this.SD.add(zZv);
                    if (pA.this.SD.size() >= 10) {
                        pA pAVar2 = pA.this;
                        pAVar2.pA(pAVar2.SD);
                        pA.this.SD.clear();
                    }
                }
            }
        });
        this.pA.getHandler().removeCallbacks(this.omh);
        this.pA.getHandler().postDelayed(this.omh, 5000L);
    }

    private boolean KZx() {
        if (this.KZx == null) {
            Og og = this.pA;
            if (og != null && og.getContext() != null && this.pA.getHandler() != null) {
                return true;
            }
        } else {
            Og og2 = this.pA;
            if (og2 != null && og2.getContext() != null && this.pA.isMonitorOpen() && this.pA.getHandler() != null) {
                return true;
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:119:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:38:0x0156  */
    /* JADX WARN: Code duplicated, block: B:82:0x025e A[Catch: all -> 0x0247, TRY_ENTER, TRY_LEAVE, TryCatch #4 {all -> 0x0247, blocks: (B:82:0x025e, B:73:0x0243), top: B:101:0x0020 }] */
    public void pA(List<ZZv> list) {
        String str;
        SQLiteDatabase sQLiteDatabase;
        String str2;
        int i;
        com.bytedance.sdk.openadsdk.oX.Og.pA pAVarGeneratorModel;
        List<ZZv> list2 = list;
        String str3 = "mediation";
        String str4 = "label";
        String str5 = "BusMonitorCenter";
        if (list2 == null) {
            return;
        }
        try {
            if (list.isEmpty()) {
                return;
            }
            try {
                SQLiteDatabase sQLiteDatabasePA = com.bytedance.sdk.openadsdk.oX.pA.pA.pA();
                if (sQLiteDatabasePA != null) {
                    try {
                        sQLiteDatabasePA.beginTransaction();
                        int i2 = 0;
                        while (i2 < list.size()) {
                            try {
                                ZZv zZv = list2.get(i2);
                                if (zZv == null || (pAVarGeneratorModel = zZv.generatorModel()) == null) {
                                    str2 = str5;
                                    i = i2;
                                    sQLiteDatabase = sQLiteDatabasePA;
                                    str3 = str3;
                                } else {
                                    String[] strArr = new String[13];
                                    strArr[0] = DatabaseHelper._ID;
                                    strArr[1] = "sdk_version";
                                    strArr[2] = "scene";
                                    strArr[3] = "start_count";
                                    strArr[4] = "success_count";
                                    str2 = str5;
                                    try {
                                        strArr[5] = "fail_count";
                                        strArr[6] = "rit";
                                        strArr[7] = "tag";
                                        strArr[8] = str4;
                                        strArr[9] = "timestamp";
                                        strArr[10] = str3;
                                        strArr[11] = "is_init";
                                        strArr[12] = "extra";
                                        i = i2;
                                        SQLiteDatabase sQLiteDatabase2 = sQLiteDatabasePA;
                                        try {
                                            Cursor cursorQuery = sQLiteDatabasePA.query("monitor_table", strArr, new StringBuilder("sdk_version = ? AND scene = ? AND rit = ? AND tag = ? AND label = ? AND mediation = ? AND is_init = ? AND extra = ?").toString(), new String[]{pAVarGeneratorModel.Og(), pAVarGeneratorModel.KZx(), pAVarGeneratorModel.SD(), pAVarGeneratorModel.omh(), pAVarGeneratorModel.Bzk(), pAVarGeneratorModel.BSW(), String.valueOf(pAVarGeneratorModel.WV()), pAVarGeneratorModel.Wx()}, null, null, null);
                                            if (cursorQuery != null) {
                                                try {
                                                    if (cursorQuery.moveToNext()) {
                                                        if (cursorQuery.getColumnIndex(DatabaseHelper._ID) >= 0) {
                                                            pAVarGeneratorModel.pA(cursorQuery.getLong(cursorQuery.getColumnIndex(DatabaseHelper._ID)));
                                                        }
                                                        if (cursorQuery.getColumnIndex("start_count") >= 0) {
                                                            pAVarGeneratorModel.pA(cursorQuery.getInt(cursorQuery.getColumnIndex("start_count")) + pAVarGeneratorModel.ZZv());
                                                        }
                                                        if (cursorQuery.getColumnIndex("success_count") >= 0) {
                                                            pAVarGeneratorModel.Og(cursorQuery.getInt(cursorQuery.getColumnIndex("success_count")) + pAVarGeneratorModel.ML());
                                                        }
                                                        if (cursorQuery.getColumnIndex("fail_count") >= 0) {
                                                            pAVarGeneratorModel.KZx(cursorQuery.getInt(cursorQuery.getColumnIndex("fail_count")) + pAVarGeneratorModel.JG());
                                                        }
                                                        if (cursorQuery.getColumnIndex("timestamp") >= 0) {
                                                            pAVarGeneratorModel.Og(Math.min(cursorQuery.getLong(cursorQuery.getColumnIndex("timestamp")), pAVarGeneratorModel.SGo()));
                                                        }
                                                    }
                                                    cursorQuery.close();
                                                } catch (Throwable th) {
                                                    th = th;
                                                    str = str2;
                                                    sQLiteDatabase = sQLiteDatabase2;
                                                    try {
                                                        Log.e(str, th.getMessage());
                                                        if (sQLiteDatabase != null) {
                                                            sQLiteDatabase.endTransaction();
                                                            return;
                                                        }
                                                        return;
                                                    } catch (Throwable th2) {
                                                        if (sQLiteDatabase != null) {
                                                            try {
                                                                sQLiteDatabase.endTransaction();
                                                                throw th2;
                                                            } catch (Throwable th3) {
                                                                Log.e(str, th3.getMessage());
                                                                throw th2;
                                                            }
                                                        }
                                                        throw th2;
                                                    }
                                                }
                                            } else {
                                                str3 = str3;
                                                str4 = str4;
                                            }
                                            ContentValues contentValues = new ContentValues();
                                            if (pAVarGeneratorModel.pA() > 0) {
                                                contentValues.put(DatabaseHelper._ID, Long.valueOf(pAVarGeneratorModel.pA()));
                                            }
                                            contentValues.put("sdk_version", pAVarGeneratorModel.Og());
                                            contentValues.put("scene", pAVarGeneratorModel.KZx());
                                            contentValues.put("start_count", Integer.valueOf(pAVarGeneratorModel.ZZv()));
                                            contentValues.put("success_count", Integer.valueOf(pAVarGeneratorModel.ML()));
                                            contentValues.put("fail_count", Integer.valueOf(pAVarGeneratorModel.JG()));
                                            contentValues.put("rit", pAVarGeneratorModel.SD());
                                            contentValues.put("tag", pAVarGeneratorModel.omh());
                                            str4 = str4;
                                            contentValues.put(str4, pAVarGeneratorModel.Bzk());
                                            contentValues.put("timestamp", Long.valueOf(pAVarGeneratorModel.SGo()));
                                            contentValues.put(str3, pAVarGeneratorModel.BSW());
                                            contentValues.put("is_init", Integer.valueOf(pAVarGeneratorModel.WV()));
                                            contentValues.put("extra", pAVarGeneratorModel.Wx());
                                            sQLiteDatabase = sQLiteDatabase2;
                                            try {
                                                sQLiteDatabase.insertWithOnConflict("monitor_table", null, contentValues, 5);
                                            } catch (Throwable th4) {
                                                th = th4;
                                                str = str2;
                                                Log.e(str, th.getMessage());
                                                if (sQLiteDatabase != null) {
                                                    sQLiteDatabase.endTransaction();
                                                    return;
                                                }
                                                return;
                                            }
                                        } catch (Throwable th5) {
                                            th = th5;
                                            sQLiteDatabase = sQLiteDatabase2;
                                            str = str2;
                                            Log.e(str, th.getMessage());
                                            if (sQLiteDatabase != null) {
                                                sQLiteDatabase.endTransaction();
                                                return;
                                            }
                                            return;
                                        }
                                    } catch (Throwable th6) {
                                        th = th6;
                                        sQLiteDatabase = sQLiteDatabasePA;
                                        str = str2;
                                        Log.e(str, th.getMessage());
                                        if (sQLiteDatabase != null) {
                                            sQLiteDatabase.endTransaction();
                                            return;
                                        }
                                        return;
                                    }
                                }
                                i2 = i + 1;
                                str3 = str3;
                                sQLiteDatabasePA = sQLiteDatabase;
                                str5 = str2;
                                list2 = list;
                            } catch (Throwable th7) {
                                th = th7;
                                str2 = str5;
                            }
                        }
                        str2 = str5;
                        sQLiteDatabase = sQLiteDatabasePA;
                        str = str2;
                        try {
                            Log.i(str, "exec save size = " + list.size());
                            sQLiteDatabase.setTransactionSuccessful();
                        } catch (Throwable th8) {
                            th = th8;
                            Log.e(str, th.getMessage());
                            if (sQLiteDatabase != null) {
                                sQLiteDatabase.endTransaction();
                                return;
                            }
                            return;
                        }
                    } catch (Throwable th9) {
                        th = th9;
                        str = str5;
                        sQLiteDatabase = sQLiteDatabasePA;
                    }
                } else {
                    sQLiteDatabase = sQLiteDatabasePA;
                }
                if (sQLiteDatabase != null) {
                    sQLiteDatabase.endTransaction();
                }
            } catch (Throwable th10) {
                th = th10;
                str = "BusMonitorCenter";
                sQLiteDatabase = null;
            }
        } catch (Throwable th11) {
            Log.e("mediation", th11.getMessage());
        }
    }

    public void pA(final boolean z) {
        Og og = this.pA;
        if (og == null || og.getHandler() == null || this.pA.getContext() == null || this.Og == null || !this.pA.isMonitorOpen()) {
            return;
        }
        this.pA.getHandler().postDelayed(new Runnable() { // from class: com.bytedance.sdk.openadsdk.oX.pA.3
            @Override // java.lang.Runnable
            public void run() {
                try {
                    pA.ZZv(pA.this);
                    if (z) {
                        long jPA = pA.this.Og.pA();
                        if (jPA == 0) {
                            pA.this.Og.pA(System.currentTimeMillis());
                            return;
                        } else if (pA.ML - jPA < pA.this.pA.getUploadIntervalTime()) {
                            return;
                        }
                    }
                    if (pA.this.pA.getHandler() != null) {
                        pA.this.pA.getHandler().post(pA.this.Bzk);
                    }
                } catch (Throwable th) {
                    Log.e("BusMonitorCenter", th.getMessage());
                }
            }
        }, Math.max(this.pA.getOnceLogInterval(), 10000));
    }
}
