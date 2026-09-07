package com.bytedance.sdk.component.JG.pA.pA.pA;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

/* JADX INFO: loaded from: classes11.dex */
public class ML implements com.bytedance.sdk.component.JG.pA.pA.ML {
    public static final ML pA = new ML();
    private volatile SQLiteDatabase Og;

    @Override // com.bytedance.sdk.component.JG.pA.pA.ML
    public String JG() {
        return null;
    }

    @Override // com.bytedance.sdk.component.JG.pA.pA.ML
    public String KZx() {
        return null;
    }

    @Override // com.bytedance.sdk.component.JG.pA.pA.ML
    public SQLiteDatabase pA(Context context) {
        if (this.Og == null) {
            synchronized (this) {
                if (this.Og == null) {
                    this.Og = new ZZv(context).getWritableDatabase();
                }
            }
        }
        return this.Og;
    }

    @Override // com.bytedance.sdk.component.JG.pA.pA.ML
    public String pA() {
        return "loghighpriority";
    }

    @Override // com.bytedance.sdk.component.JG.pA.pA.ML
    public String Og() {
        return "adevent";
    }

    @Override // com.bytedance.sdk.component.JG.pA.pA.ML
    public String ZZv() {
        return "logstats";
    }

    @Override // com.bytedance.sdk.component.JG.pA.pA.ML
    public String ML() {
        return "logstatsbatch";
    }
}
