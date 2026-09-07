package com.json;

import android.text.TextUtils;
import com.json.mediationsdk.logger.IronLog;
import java.util.Random;
import org.json.JSONException;

/* JADX INFO: loaded from: classes10.dex */
public class mb {
    public static final int d = 1;
    public static final int e = 2;
    public static final String f = "C38FB23A402222A0C17D34A92F971D1F";
    public static final String g = "MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQDaUZaiASqhU4+s3JiQaIzVYtC+rZiPX2K+ZRg4C21kBZDNQM5+SEkp5GT5a9W/IR2oz6Q/ucifXcc7QEo5Xl5GX1BAhFI+8KaxPmn5Km5zFdH0aCvrrpDYQpH239Q+2uuUC79G5MpfSIw0zixU4VkF0WbVdHDpgQDds39cPl6cTwIDAQAB";
    public static final String h = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789!#$%&'()*+,-./:;<=>?@[\\]^_`{|}~";
    public static final int i = 32;
    private static final mb j = new mb();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private String f3919a = "";
    private String b = "";
    private String c = "";

    private String a(String str, int i2) {
        StringBuilder sb = new StringBuilder();
        Random random = new Random();
        for (int i3 = 0; i3 < i2; i3++) {
            sb.append(str.charAt(random.nextInt(str.length())));
        }
        return sb.toString();
    }

    public static mb b() {
        return j;
    }

    public String a() throws JSONException {
        if (TextUtils.isEmpty(this.c)) {
            try {
                this.c = gk.a(d(), g);
            } catch (Exception e2) {
                o9.d().a(e2);
                String str = "Session key encryption exception: " + e2.getLocalizedMessage();
                IronLog.INTERNAL.error(str);
                throw new JSONException(str);
            }
        }
        return this.c;
    }

    public String c() {
        if (TextUtils.isEmpty(this.f3919a)) {
            this.f3919a = f;
        }
        return this.f3919a;
    }

    public synchronized String d() {
        if (TextUtils.isEmpty(this.b)) {
            this.b = a(h, 32);
        }
        return this.b;
    }
}
