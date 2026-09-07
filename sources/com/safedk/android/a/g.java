package com.safedk.android.a;

import com.safedk.android.utils.Logger;
import java.io.IOException;

/* JADX INFO: loaded from: classes7.dex */
public abstract class g {
    public static final String e = "POST";
    public static final String f = "PUT";
    public static final int g = 2;
    public static final int[] h = {1000, 2000};
    protected String d = "ServerUploadFile";
    protected int i;
    protected String j;
    protected String k;

    public abstract a a() throws IOException;

    public g(String str, String str2, int i) {
        this.i = i;
        this.j = str;
        this.k = str2;
        Logger.d(this.d, "object created, File path=" + str + ", hash=" + str2);
    }

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final String f7951a;
        private final int b;
        private final String c;

        a(String str, int i, String str2) {
            Logger.d("ServerResponseData", "object created, URL=" + str + ", response=" + i + ", file hash=" + str2);
            this.f7951a = str;
            this.b = i;
            this.c = str2;
        }

        public String a() {
            return this.f7951a;
        }

        public int b() {
            return this.b;
        }

        public String c() {
            return this.c;
        }
    }
}
