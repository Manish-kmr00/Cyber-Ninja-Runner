package com.bytedance.sdk.component.SD;

import com.bytedance.sdk.component.Og.pA.SGo;
import java.io.File;
import java.util.Map;

/* JADX INFO: loaded from: classes5.dex */
public class Og {
    private final boolean Bzk;
    final long JG;
    final Map<String, String> KZx;
    final long ML;
    final String Og;
    SGo SD;
    final String ZZv;
    final int pA;
    private File omh = null;
    private byte[] SGo = null;

    public Og(boolean z, int i, String str, Map<String, String> map, String str2, long j, long j2) {
        this.Bzk = z;
        this.pA = i;
        this.Og = str;
        this.KZx = map;
        this.ZZv = str2;
        this.ML = j;
        this.JG = j2;
    }

    public int pA() {
        return this.pA;
    }

    public String Og() {
        return this.Og;
    }

    public Map<String, String> KZx() {
        return this.KZx;
    }

    public String ZZv() {
        return this.ZZv;
    }

    public File ML() {
        return this.omh;
    }

    public void pA(File file) {
        this.omh = file;
    }

    public boolean JG() {
        return this.Bzk;
    }

    public void pA(byte[] bArr) {
        this.SGo = bArr;
    }

    public SGo SD() {
        return this.SD;
    }

    public void pA(SGo sGo) {
        this.SD = sGo;
    }
}
