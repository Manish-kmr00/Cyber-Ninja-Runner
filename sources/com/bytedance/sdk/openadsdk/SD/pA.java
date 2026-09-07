package com.bytedance.sdk.openadsdk.SD;

import android.util.Pair;
import com.bykv.vk.openvk.preload.geckox.buffer.stream.BufferOutputStream;
import com.bykv.vk.openvk.preload.geckox.net.INetWork;
import com.bykv.vk.openvk.preload.geckox.net.Response;
import com.bykv.vk.openvk.preload.geckox.utils.CloseableUtils;
import com.bytedance.sdk.component.Og.pA.BSW;
import com.bytedance.sdk.component.Og.pA.Bzk;
import com.bytedance.sdk.component.Og.pA.DX;
import com.bytedance.sdk.component.Og.pA.JG;
import com.bytedance.sdk.component.Og.pA.KZx;
import com.bytedance.sdk.component.Og.pA.ML;
import com.bytedance.sdk.component.Og.pA.Sn;
import com.bytedance.sdk.component.Og.pA.Wx;
import java.io.BufferedInputStream;
import java.io.Closeable;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes12.dex */
public class pA implements INetWork {
    protected BSW pA = new BSW.pA().pA(10, TimeUnit.SECONDS).Og(10, TimeUnit.SECONDS).KZx(10, TimeUnit.SECONDS).pA();
    protected BSW Og = new BSW.pA().pA(10, TimeUnit.SECONDS).Og(30, TimeUnit.SECONDS).KZx(30, TimeUnit.SECONDS).pA();

    @Override // com.bykv.vk.openvk.preload.geckox.net.INetWork
    public void syncDoGet(final String str) {
        this.pA.pA(new Wx.pA().pA().Og(str).Og()).pA(new KZx() { // from class: com.bytedance.sdk.openadsdk.SD.pA.1
            @Override // com.bytedance.sdk.component.Og.pA.KZx
            public void pA(com.bytedance.sdk.component.Og.pA.Og og, DX dx) throws IOException {
            }

            @Override // com.bytedance.sdk.component.Og.pA.KZx
            public void pA(com.bytedance.sdk.component.Og.pA.Og og, IOException iOException) {
            }
        });
    }

    @Override // com.bykv.vk.openvk.preload.geckox.net.INetWork
    public Response doGet(String str) throws Exception {
        DX dxOg = this.pA.pA(new Wx.pA().pA().Og(str).Og()).Og();
        return new Response(pA(dxOg.SD()), dxOg.KZx() == 200 ? dxOg.JG().Og() : null, dxOg.KZx(), dxOg.ML());
    }

    @Override // com.bykv.vk.openvk.preload.geckox.net.INetWork
    public Response doPost(String str, List<Pair<String, String>> list) throws Exception {
        ML.pA pAVar = new ML.pA();
        if (list != null) {
            for (Pair<String, String> pair : list) {
                pAVar.pA((String) pair.first, (String) pair.second);
            }
        }
        DX dxOg = this.pA.pA(new Wx.pA().Og(str).pA((Sn) pAVar.pA()).Og()).Og();
        return new Response(pA(dxOg.SD()), dxOg.KZx() == 200 ? dxOg.JG().Og() : null, dxOg.KZx(), dxOg.ML());
    }

    @Override // com.bykv.vk.openvk.preload.geckox.net.INetWork
    public Response doPost(String str, String str2) throws Exception {
        DX dxOg = this.pA.pA(new Wx.pA().Og(str).pA(Sn.pA(Bzk.pA("application/json; charset=utf-8"), str2)).Og()).Og();
        return new Response(pA(dxOg.SD()), dxOg.KZx() == 200 ? dxOg.JG().Og() : null, dxOg.KZx(), dxOg.ML());
    }

    /* JADX WARN: Not initialized variable reg: 2, insn: 0x007b: MOVE (r7 I:??[OBJECT, ARRAY]) = (r2 I:??[OBJECT, ARRAY]), block:B:25:0x007b */
    @Override // com.bykv.vk.openvk.preload.geckox.net.INetWork
    public void downloadFile(String str, long j, BufferOutputStream bufferOutputStream) throws Exception {
        Closeable closeable;
        Exception e;
        Closeable closeable2 = null;
        int i = 0;
        try {
            try {
                try {
                    DX dxOg = this.Og.pA(new Wx.pA().pA().Og(str).Og()).Og();
                    int iKZx = dxOg.KZx();
                    try {
                        BufferedInputStream bufferedInputStream = new BufferedInputStream(dxOg.JG().KZx());
                        try {
                            byte[] bArr = new byte[2048];
                            while (true) {
                                int i2 = bufferedInputStream.read(bArr, 0, 2048);
                                if (i2 != -1) {
                                    bufferOutputStream.write(bArr, 0, i2);
                                } else {
                                    CloseableUtils.close(bufferedInputStream);
                                    return;
                                }
                            }
                        } catch (Exception e2) {
                            e = e2;
                            i = iKZx;
                            throw new RuntimeException("downloadFile failed, code: " + i + ", url:" + str + ", caused by:" + e.getMessage(), e);
                        }
                    } catch (Exception e3) {
                        e = e3;
                    }
                } catch (Throwable th) {
                    th = th;
                    CloseableUtils.close(closeable2);
                    throw th;
                }
            } catch (Exception e4) {
                e = e4;
            }
        } catch (Throwable th2) {
            th = th2;
            closeable2 = closeable;
        }
    }

    private Map<String, String> pA(JG jg) {
        if (jg == null) {
            return null;
        }
        HashMap map = new HashMap();
        for (int i = 0; i < jg.pA(); i++) {
            map.put(jg.pA(i), jg.Og(i));
        }
        return map;
    }
}
