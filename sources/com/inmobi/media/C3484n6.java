package com.inmobi.media;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: renamed from: com.inmobi.media.n6, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes10.dex */
public final class C3484n6 extends S8 {
    public final C3368f6 y;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C3484n6(String url, C3368f6 data) {
        super("POST", url, (C3545rc) null, true, (L4) null, "application/json", 64);
        Intrinsics.checkNotNullParameter(url, "url");
        Intrinsics.checkNotNullParameter(data, "data");
        this.y = data;
    }

    public static String a(String str) {
        File file = new File(str);
        StringBuilder sb = new StringBuilder();
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
            while (true) {
                String line = bufferedReader.readLine();
                if (line == null) {
                    break;
                }
                sb.append(line).append('\n');
            }
            bufferedReader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        String string = sb.toString();
        Intrinsics.checkNotNullExpressionValue(string, "toString(...)");
        return string;
    }

    @Override // com.inmobi.media.S8
    public final void f() {
        super.f();
        this.t = false;
        this.u = false;
        this.x = false;
        try {
            this.l = new JSONObject(a(this.y.f3312a));
        } catch (FileNotFoundException unused) {
            String str = "File - " + this.y.f3312a + " not found";
            T8 response = new T8();
            response.c = new P8(I3.s, str);
            Intrinsics.checkNotNullParameter(response, "response");
            this.n = response;
        } catch (IOException unused2) {
            String str2 = "IOException while reading file - " + this.y.f3312a;
            T8 response2 = new T8();
            response2.c = new P8(I3.s, str2);
            Intrinsics.checkNotNullParameter(response2, "response");
            this.n = response2;
        } catch (JSONException unused3) {
            String str3 = "JSON exception while parsing file - " + this.y.f3312a;
            T8 response3 = new T8();
            response3.c = new P8(I3.s, str3);
            Intrinsics.checkNotNullParameter(response3, "response");
            this.n = response3;
        }
    }
}
