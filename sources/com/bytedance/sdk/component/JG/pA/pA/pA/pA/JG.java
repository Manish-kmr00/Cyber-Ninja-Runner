package com.bytedance.sdk.component.JG.pA.pA.pA.pA;

import android.content.Context;
import com.bytedance.sdk.component.JG.pA.omh;

/* JADX INFO: loaded from: classes9.dex */
public class JG extends SD {
    @Override // com.bytedance.sdk.component.JG.pA.pA.pA.pA.SD
    public byte KZx() {
        return (byte) 3;
    }

    @Override // com.bytedance.sdk.component.JG.pA.pA.pA.pA.SD
    public byte pA() {
        return (byte) 1;
    }

    public JG(Context context, com.bytedance.sdk.component.JG.pA.ZZv.Og.pA pAVar) {
        super(context, pAVar);
    }

    @Override // com.bytedance.sdk.component.JG.pA.pA.pA.pA.SD, com.bytedance.sdk.component.JG.pA.pA.pA.pA.KZx
    public String Og() {
        return omh.SD().ZZv().ML();
    }

    public static String pA(String str) {
        return "CREATE TABLE IF NOT EXISTS " + str + " (_id INTEGER PRIMARY KEY AUTOINCREMENT,id TEXT UNIQUE,value TEXT ,gen_time TEXT , retry INTEGER default 0 , encrypt INTEGER default 0)";
    }
}
