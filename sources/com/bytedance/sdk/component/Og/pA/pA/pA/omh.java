package com.bytedance.sdk.component.Og.pA.pA.pA;

import com.bytedance.sdk.component.Og.pA.oX;
import com.safedk.android.internal.partials.PangleNetworkBridge;
import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;

/* JADX INFO: loaded from: classes14.dex */
public class omh extends oX {
    InputStream Og;
    HttpURLConnection pA;

    omh(HttpURLConnection httpURLConnection) throws IOException {
        this.pA = httpURLConnection;
        this.Og = new JG(PangleNetworkBridge.urlConnectionGetInputStream(httpURLConnection), httpURLConnection);
    }

    omh(HttpURLConnection httpURLConnection, InputStream inputStream) {
        this.pA = httpURLConnection;
        this.Og = new JG(inputStream, httpURLConnection);
    }

    @Override // com.bytedance.sdk.component.Og.pA.oX
    public long pA() {
        try {
            return this.pA.getContentLength();
        } catch (Exception unused) {
            return 0L;
        }
    }

    @Override // com.bytedance.sdk.component.Og.pA.oX
    public String Og() {
        try {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(this.Og));
            StringBuffer stringBuffer = new StringBuffer();
            while (true) {
                String line = bufferedReader.readLine();
                if (line != null) {
                    stringBuffer.append(line + "\n");
                } else {
                    String string = stringBuffer.toString();
                    close();
                    return string;
                }
            }
        } catch (Exception unused) {
            return "";
        }
    }

    @Override // com.bytedance.sdk.component.Og.pA.oX, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        try {
            this.Og.close();
            PangleNetworkBridge.httpUrlConnectionDisconnect(this.pA);
        } catch (Exception unused) {
        }
    }

    @Override // com.bytedance.sdk.component.Og.pA.oX
    public InputStream KZx() {
        return this.Og;
    }

    @Override // com.bytedance.sdk.component.Og.pA.oX
    public byte[] ZZv() {
        try {
            byte[] bArr = new byte[1024];
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            while (true) {
                int i = this.Og.read(bArr);
                if (i != -1) {
                    byteArrayOutputStream.write(bArr, 0, i);
                } else {
                    return byteArrayOutputStream.toByteArray();
                }
            }
        } catch (Exception unused) {
            return new byte[0];
        }
    }

    @Override // com.bytedance.sdk.component.Og.pA.oX
    public com.bytedance.sdk.component.Og.pA.Bzk ML() {
        if (this.pA.getContentType() != null) {
            return com.bytedance.sdk.component.Og.pA.Bzk.pA(this.pA.getContentType());
        }
        return null;
    }
}
