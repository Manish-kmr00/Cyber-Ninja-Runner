package com.smaato.sdk.core.kpi;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.preference.PreferenceManager;
import com.json.b9;
import com.smaato.sdk.core.gdpr.IabCmpV2DataStorage;
import com.smaato.sdk.core.log.LogDomain;
import com.smaato.sdk.core.log.Logger;
import java.util.HashMap;

/* JADX INFO: loaded from: classes7.dex */
public class KpiDBHelper extends SQLiteOpenHelper {
    static final String DATABASE_NAME = "KPI_DATABASE.db";
    private final SQLiteDatabase db;
    private final IabCmpV2DataStorage iabCmpV2DataStorage;
    private final Logger logger;
    private final boolean sessionTrackingDisabled;
    HashMap<String, Integer> session_depth_map;

    public KpiDBHelper(Logger logger, Context context, boolean z) {
        super(context, DATABASE_NAME, (SQLiteDatabase.CursorFactory) null, 1);
        this.session_depth_map = new HashMap<>();
        this.logger = logger;
        this.sessionTrackingDisabled = z;
        this.iabCmpV2DataStorage = new IabCmpV2DataStorage(PreferenceManager.getDefaultSharedPreferences(context));
        this.db = getWritableDatabase();
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onCreate(SQLiteDatabase sQLiteDatabase) {
        sQLiteDatabase.execSQL("CREATE TABLE Kpidata(adspaceid TEXT PRIMARY KEY NOT NULL,total INTEGER,fillrate INTEGER,fills TEXT)");
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
        sQLiteDatabase.execSQL("DROP TABLE IF EXISTS Kpidata");
    }

    public synchronized void incrementAdRequestCount(String str) {
        if (this.sessionTrackingDisabled || str == null) {
            return;
        }
        try {
            ContentValues contentValues = new ContentValues();
            KpiDataModel kpiDataModelFetchAdSpaceDetail = fetchAdSpaceDetail(str);
            if (kpiDataModelFetchAdSpaceDetail != null) {
                contentValues.put(b9.h.l, Long.valueOf(kpiDataModelFetchAdSpaceDetail.getTotalRequests() + 1));
                this.db.update("Kpidata", contentValues, "adspaceid=?", new String[]{str});
            } else {
                contentValues.put("adspaceid", str);
                contentValues.put(b9.h.l, (Integer) 1);
                contentValues.put("fillrate", (Integer) 0);
                this.db.insert("Kpidata", null, contentValues);
            }
            Integer num = this.session_depth_map.get(str);
            this.session_depth_map.put(str, Integer.valueOf(num == null ? 2 : num.intValue() + 1));
        } catch (Exception e) {
            this.logger.error(LogDomain.CORE, KpiDataModel.class.getName() + e.getMessage(), new Object[0]);
        }
    }

    public synchronized void updateFillAndFillRate(String str, boolean z) {
        if (this.sessionTrackingDisabled || str == null) {
            return;
        }
        try {
            KpiDataModel kpiDataModelFetchAdSpaceDetail = fetchAdSpaceDetail(str);
            if (kpiDataModelFetchAdSpaceDetail != null) {
                ContentValues contentValues = new ContentValues();
                String fills = getFills(kpiDataModelFetchAdSpaceDetail.getFills(), z);
                contentValues.put("fills", fills);
                contentValues.put("fillrate", Integer.valueOf(getFillRate(fills)));
                this.db.update("Kpidata", contentValues, "adspaceid=?", new String[]{str});
            }
        } catch (Exception e) {
            this.logger.error(LogDomain.CORE, KpiDataModel.class.getName() + e.getMessage(), new Object[0]);
        }
    }

    public synchronized KpiData getKpiValuesForAdSpace(String str) {
        if (!this.sessionTrackingDisabled && str != null) {
            KpiDataModel kpiDataModelFetchAdSpaceDetail = fetchAdSpaceDetail(str);
            return KpiData.builder().setRollingFillRatePerAdSpace(kpiDataModelFetchAdSpaceDetail != null ? String.valueOf(kpiDataModelFetchAdSpaceDetail.getFillRate()) : "0").setSessionDepthPerAdSpace(String.valueOf(getSessionDepth(str))).setTotalAdRequests(kpiDataModelFetchAdSpaceDetail != null ? String.valueOf(kpiDataModelFetchAdSpaceDetail.getTotalRequests()) : "0").setTotalFillRate(String.valueOf(getTotalFillRate())).build();
        }
        return null;
    }

    KpiDataModel fetchAdSpaceDetail(String str) {
        KpiDataModel kpiDataModel;
        if (str == null) {
            return null;
        }
        try {
            Cursor cursorRawQuery = this.db.rawQuery("SELECT * FROM Kpidata WHERE adspaceid=?", new String[]{str});
            try {
                int columnIndex = cursorRawQuery.getColumnIndex(b9.h.l);
                int columnIndex2 = cursorRawQuery.getColumnIndex("fillrate");
                int columnIndex3 = cursorRawQuery.getColumnIndex("fills");
                if (cursorRawQuery.getCount() == 1) {
                    cursorRawQuery.moveToFirst();
                    kpiDataModel = new KpiDataModel();
                    kpiDataModel.setAdSpace(str);
                    kpiDataModel.setFills(cursorRawQuery.getString(columnIndex3));
                    kpiDataModel.setTotalRequests(cursorRawQuery.getInt(columnIndex));
                    kpiDataModel.setFillRate(cursorRawQuery.getInt(columnIndex2));
                } else {
                    kpiDataModel = null;
                }
                cursorRawQuery.close();
                return kpiDataModel;
            } catch (Throwable th) {
                if (cursorRawQuery != null) {
                    try {
                        cursorRawQuery.close();
                    } catch (Throwable th2) {
                        th.addSuppressed(th2);
                    }
                }
                throw th;
            }
        } catch (Exception e) {
            this.logger.error(LogDomain.CORE, KpiDataModel.class.getName() + e.getMessage(), new Object[0]);
            return null;
        }
    }

    String getFills(String str, boolean z) {
        String str2 = z ? "1" : "0";
        if (str == null || str.isEmpty()) {
            return str2;
        }
        if (str.length() < 50) {
            return str + str2;
        }
        return str.substring(1, 50) + str2;
    }

    int getFillRate(String str) {
        return (int) ((((double) str.replaceAll("0", "").length()) * 1000.0d) / ((double) str.length()));
    }

    int getTotalFillRate() {
        int fillRate;
        try {
            Cursor cursorRawQuery = this.db.rawQuery("SELECT * FROM Kpidata", null);
            try {
                int columnIndex = cursorRawQuery.getColumnIndex("fills");
                if (cursorRawQuery.getCount() > 0) {
                    StringBuilder sb = new StringBuilder();
                    cursorRawQuery.moveToFirst();
                    do {
                        sb.append(cursorRawQuery.getString(columnIndex));
                    } while (cursorRawQuery.moveToNext());
                    fillRate = getFillRate(sb.toString());
                } else {
                    fillRate = 0;
                }
                cursorRawQuery.close();
                return fillRate;
            } catch (Throwable th) {
                if (cursorRawQuery != null) {
                    try {
                        cursorRawQuery.close();
                    } catch (Throwable th2) {
                        th.addSuppressed(th2);
                    }
                }
                throw th;
            }
        } catch (Exception e) {
            this.logger.error(LogDomain.CORE, KpiDataModel.class.getName() + e.getMessage(), new Object[0]);
            return 0;
        }
    }

    int getSessionDepth(String str) {
        Integer num = this.session_depth_map.get(str);
        if (num == null) {
            return 1;
        }
        return num.intValue();
    }

    static class KpiDataModel {
        private String adSpace;
        private int fillRate;
        private String fills;
        private long totalRequests;

        KpiDataModel() {
        }

        public String getAdSpace() {
            return this.adSpace;
        }

        public void setAdSpace(String str) {
            this.adSpace = str;
        }

        public String getFills() {
            return this.fills;
        }

        public void setFills(String str) {
            this.fills = str;
        }

        public int getFillRate() {
            return this.fillRate;
        }

        public void setFillRate(int i) {
            this.fillRate = i;
        }

        public long getTotalRequests() {
            return this.totalRequests;
        }

        public void setTotalRequests(long j) {
            this.totalRequests = j;
        }
    }
}
