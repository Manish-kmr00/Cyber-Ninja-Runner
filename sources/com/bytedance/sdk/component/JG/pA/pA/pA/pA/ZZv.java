package com.bytedance.sdk.component.JG.pA.pA.pA.pA;

import android.content.Context;
import com.bytedance.sdk.component.JG.pA.omh;

/* JADX INFO: loaded from: classes12.dex */
public class ZZv extends pA {
    @Override // com.bytedance.sdk.component.JG.pA.pA.pA.pA.pA
    public byte KZx() {
        return (byte) 1;
    }

    @Override // com.bytedance.sdk.component.JG.pA.pA.pA.pA.pA
    public byte ZZv() {
        return (byte) 0;
    }

    public ZZv(Context context, com.bytedance.sdk.component.JG.pA.ZZv.Og.pA pAVar) {
        super(context, pAVar);
    }

    @Override // com.bytedance.sdk.component.JG.pA.pA.pA.pA.pA, com.bytedance.sdk.component.JG.pA.pA.pA.pA.KZx
    public String Og() {
        com.bytedance.sdk.component.JG.pA.pA.ML mlZZv = omh.SD().ZZv();
        if (mlZZv != null) {
            return mlZZv.pA();
        }
        return null;
    }

    public static String KZx(String str) {
        return "CREATE TABLE IF NOT EXISTS " + str + " (_id INTEGER PRIMARY KEY AUTOINCREMENT,id TEXT UNIQUE,value TEXT ,gen_time TEXT , retry INTEGER default 0 , encrypt INTEGER default 0)";
    }
}
