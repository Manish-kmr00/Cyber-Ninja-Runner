package com.yandex.mobile.ads.impl;

import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.IOException;

/* JADX INFO: loaded from: classes10.dex */
public final class x50 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final ByteArrayOutputStream f10623a;
    private final DataOutputStream b;

    public x50() {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(512);
        this.f10623a = byteArrayOutputStream;
        this.b = new DataOutputStream(byteArrayOutputStream);
    }

    public final byte[] a(v50 v50Var) {
        this.f10623a.reset();
        try {
            DataOutputStream dataOutputStream = this.b;
            dataOutputStream.writeBytes(v50Var.b);
            dataOutputStream.writeByte(0);
            String str = v50Var.c;
            if (str == null) {
                str = "";
            }
            DataOutputStream dataOutputStream2 = this.b;
            dataOutputStream2.writeBytes(str);
            dataOutputStream2.writeByte(0);
            this.b.writeLong(v50Var.d);
            this.b.writeLong(v50Var.e);
            this.b.write(v50Var.f);
            this.b.flush();
            return this.f10623a.toByteArray();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
