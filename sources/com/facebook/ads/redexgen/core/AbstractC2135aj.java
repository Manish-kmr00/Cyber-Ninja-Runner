package com.facebook.ads.redexgen.core;

import android.util.Log;
import com.vungle.ads.internal.protos.Sdk;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.Proxy;
import java.net.URL;
import java.util.Arrays;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.aj, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public abstract class AbstractC2135aj implements InterfaceC1685Jg {
    public static byte[] A01;
    public final InterfaceC1686Jh A00;

    static {
        A01();
    }

    public static String A00(int i, int i2, int i3) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A01, i, i + i2);
        for (int i4 = 0; i4 < bArrCopyOfRange.length; i4++) {
            bArrCopyOfRange[i4] = (byte) ((bArrCopyOfRange[i4] - i3) - 25);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A01() {
        A01 = new byte[]{108, -114, -114, -112, -101, -97, 88, 110, -109, -116, -99, -98, -112, -97, -42, -11, 7, -3, -9, -26, -7, 5, 9, -7, 7, 8, -36, -11, 2, -8, 0, -7, 6, -62, 3, 2, -39, 6, 6, 3, 6, -126, -82, -83, -77, -92, -83, -77, 108, -109, -72, -81, -92, -126, -127, 115, 90, 101};
    }

    public AbstractC2135aj(InterfaceC1686Jh interfaceC1686Jh) {
        this.A00 = interfaceC1686Jh;
    }

    @Override // com.facebook.ads.redexgen.core.InterfaceC1685Jg
    public final boolean AD7(C1683Je c1683Je) {
        JQ jqA00 = c1683Je.A00();
        if (this.A00.AAO()) {
            Log.e(AbstractC2135aj.class.getSimpleName(), A00(14, 27, Sdk.SDKError.Reason.INVALID_RI_ENDPOINT_VALUE), c1683Je);
        }
        if (jqA00 != null && jqA00.A92() > 0) {
            return true;
        }
        return false;
    }

    @Override // com.facebook.ads.redexgen.core.InterfaceC1685Jg
    public final HttpURLConnection AFt(String str, Proxy proxy) throws IOException {
        URL url = new URL(str);
        if (proxy == null) {
            return (HttpURLConnection) url.openConnection();
        }
        return (HttpURLConnection) url.openConnection(proxy);
    }

    @Override // com.facebook.ads.redexgen.core.InterfaceC1685Jg
    public final InputStream AFu(HttpURLConnection httpURLConnection) throws IOException {
        return httpURLConnection.getInputStream();
    }

    @Override // com.facebook.ads.redexgen.core.InterfaceC1685Jg
    public final OutputStream AFv(HttpURLConnection httpURLConnection) throws IOException {
        return httpURLConnection.getOutputStream();
    }

    @Override // com.facebook.ads.redexgen.core.InterfaceC1685Jg
    public final void AGE(HttpURLConnection httpURLConnection, EnumC1681Jc enumC1681Jc, String str) throws IOException {
        httpURLConnection.setRequestMethod(enumC1681Jc.A03());
        httpURLConnection.setDoOutput(enumC1681Jc.A05());
        httpURLConnection.setDoInput(enumC1681Jc.A04());
        if (str != null) {
            httpURLConnection.setRequestProperty(A00(41, 12, 38), str);
        }
        httpURLConnection.setRequestProperty(A00(0, 14, 18), A00(53, 5, 20));
    }

    @Override // com.facebook.ads.redexgen.core.InterfaceC1685Jg
    public final byte[] AGb(InputStream inputStream) throws IOException {
        byte[] bArr = new byte[16384];
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        while (true) {
            int i = inputStream.read(bArr);
            if (i != -1) {
                byteArrayOutputStream.write(bArr, 0, i);
            } else {
                byteArrayOutputStream.flush();
                byte[] data = byteArrayOutputStream.toByteArray();
                return data;
            }
        }
    }

    @Override // com.facebook.ads.redexgen.core.InterfaceC1685Jg
    public final void AKD(OutputStream outputStream, byte[] bArr) throws IOException {
        outputStream.write(bArr);
    }
}
