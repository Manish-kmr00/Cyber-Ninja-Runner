package com.yandex.mobile.ads.impl;

import android.media.DeniedByServerException;
import android.media.MediaCrypto;
import android.media.MediaCryptoException;
import android.media.MediaDrm;
import android.media.MediaDrmException;
import android.media.NotProvisionedException;
import android.media.UnsupportedSchemeException;
import android.media.metrics.LogSessionId;
import android.text.TextUtils;
import android.util.Base64;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.charset.Charset;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;

/* JADX INFO: loaded from: classes7.dex */
public final class pc0 implements i60 {
    private static final qc0 d = jm1.b();
    public static final i60.c e = new i60.c() { // from class: com.yandex.mobile.ads.impl.pc0$$ExternalSyntheticLambda0
        @Override // com.yandex.mobile.ads.impl.i60.c
        public final i60 a(UUID uuid) {
            return pc0.b(uuid);
        }
    };

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final UUID f9914a;
    private final MediaDrm b;
    private int c;

    @Override // com.yandex.mobile.ads.impl.i60
    public final int b() {
        return 2;
    }

    @Override // com.yandex.mobile.ads.impl.i60
    public final cv d(byte[] bArr) throws MediaCryptoException {
        return new oc0(a(this.f9914a), bArr, x82.f10629a < 21 && qm.d.equals(this.f9914a) && "L3".equals(this.b.getPropertyString("securityLevel")));
    }

    private static boolean d() {
        return d.a().equals(x82.d);
    }

    private pc0(UUID uuid) throws UnsupportedSchemeException {
        hg.a(uuid);
        hg.a("Use C.CLEARKEY_UUID instead", !qm.b.equals(uuid));
        this.f9914a = uuid;
        MediaDrm mediaDrm = new MediaDrm(a(uuid));
        this.b = mediaDrm;
        this.c = 1;
        if (qm.d.equals(uuid) && d()) {
            a(mediaDrm);
        }
    }

    @Override // com.yandex.mobile.ads.impl.i60
    public final byte[] c() throws MediaDrmException {
        return this.b.openSession();
    }

    @Override // com.yandex.mobile.ads.impl.i60
    public final void b(byte[] bArr) {
        this.b.closeSession(bArr);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ i60 b(UUID uuid) {
        try {
            return c(uuid);
        } catch (e82 unused) {
            at0.b("FrameworkMediaDrm", "Failed to instantiate a FrameworkMediaDrm for uuid: " + uuid + ".");
            return new m40();
        }
    }

    @Override // com.yandex.mobile.ads.impl.i60
    public final byte[] b(byte[] bArr, byte[] bArr2) throws DeniedByServerException, NotProvisionedException {
        if (qm.c.equals(this.f9914a)) {
            bArr2 = po.a(bArr2);
        }
        return this.b.provideKeyResponse(bArr, bArr2);
    }

    @Override // com.yandex.mobile.ads.impl.i60
    public final synchronized void release() {
        int i = this.c - 1;
        this.c = i;
        if (i == 0) {
            this.b.release();
        }
    }

    @Override // com.yandex.mobile.ads.impl.i60
    public final void c(byte[] bArr) throws DeniedByServerException {
        this.b.provideProvisionResponse(bArr);
    }

    public static pc0 c(UUID uuid) throws e82 {
        try {
            return new pc0(uuid);
        } catch (UnsupportedSchemeException e2) {
            throw new e82(e2);
        } catch (Exception e3) {
            throw new e82(e3);
        }
    }

    private static void a(MediaDrm mediaDrm) {
        mediaDrm.setPropertyString("securityLevel", "L3");
    }

    private static class a {
        public static boolean a(MediaDrm mediaDrm, String str) {
            return mediaDrm.requiresSecureDecoder(str);
        }

        public static void a(MediaDrm mediaDrm, byte[] bArr, ii1 ii1Var) {
            LogSessionId logSessionIdA = ii1Var.a();
            if (logSessionIdA.equals(LogSessionId.LOG_SESSION_ID_NONE)) {
                return;
            }
            MediaDrm.PlaybackComponent playbackComponent = mediaDrm.getPlaybackComponent(bArr);
            playbackComponent.getClass();
            playbackComponent.setLogSessionId(logSessionIdA);
        }
    }

    /* JADX WARN: Code duplicated, block: B:121:0x00ae A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:29:0x008f  */
    /* JADX WARN: Code duplicated, block: B:81:0x020c  */
    /* JADX WARN: Code duplicated, block: B:83:0x0212  */
    @Override // com.yandex.mobile.ads.impl.i60
    public final i60.a a(byte[] bArr, List<c40.b> list, int i, HashMap<String, String> map) throws NotProvisionedException {
        c40.b bVar;
        byte[] bArr2;
        String str;
        int i2;
        int i3;
        byte[] bArrA;
        if (list != null) {
            if (!qm.d.equals(this.f9914a)) {
                bVar = list.get(0);
            } else if (x82.f10629a < 28 || list.size() <= 1) {
                i2 = 0;
                while (true) {
                    if (i2 < list.size()) {
                        c40.b bVar2 = list.get(i2);
                        byte[] bArr3 = bVar2.f;
                        bArr3.getClass();
                        int iD = vm1.d(bArr3);
                        i3 = x82.f10629a;
                        if ((i3 >= 23 && iD == 0) || (i3 >= 23 && iD == 1)) {
                            bVar = bVar2;
                            break;
                        }
                    } else {
                        bVar = list.get(0);
                        break;
                    }
                }
            } else {
                c40.b bVar3 = list.get(0);
                int i4 = 0;
                int length = 0;
                while (true) {
                    if (i4 < list.size()) {
                        c40.b bVar4 = list.get(i4);
                        byte[] bArr4 = bVar4.f;
                        bArr4.getClass();
                        if (!x82.a(bVar4.e, bVar3.e) || !x82.a(bVar4.d, bVar3.d) || !vm1.a(bArr4)) {
                            i2 = 0;
                            while (true) {
                                if (i2 < list.size()) {
                                    c40.b bVar5 = list.get(i2);
                                    byte[] bArr5 = bVar5.f;
                                    bArr5.getClass();
                                    int iD2 = vm1.d(bArr5);
                                    i3 = x82.f10629a;
                                    i2 = i3 >= 23 ? i2 + 1 : i2 + 1;
                                    bVar = bVar5;
                                    break;
                                }
                                bVar = list.get(0);
                                break;
                            }
                        }
                        length += bArr4.length;
                        i4++;
                    } else {
                        byte[] bArr6 = new byte[length];
                        int i5 = 0;
                        for (int i6 = 0; i6 < list.size(); i6++) {
                            byte[] bArr7 = list.get(i6).f;
                            bArr7.getClass();
                            int length2 = bArr7.length;
                            System.arraycopy(bArr7, 0, bArr6, i5, length2);
                            i5 += length2;
                        }
                        bVar = new c40.b(bVar3.c, bVar3.d, bVar3.e, bArr6);
                    }
                }
            }
            UUID uuid = this.f9914a;
            byte[] bArrArray = bVar.f;
            bArrArray.getClass();
            UUID uuid2 = qm.e;
            if (uuid2.equals(uuid)) {
                byte[] bArrA2 = vm1.a(uuid, bArrArray);
                if (bArrA2 != null) {
                    bArrArray = bArrA2;
                }
                wf1 wf1Var = new wf1(bArrArray);
                int iK = wf1Var.k();
                short sM = wf1Var.m();
                short sM2 = wf1Var.m();
                if (sM == 1 && sM2 == 1) {
                    short sM3 = wf1Var.m();
                    Charset charset = ko.d;
                    String strA = wf1Var.a(sM3, charset);
                    if (!strA.contains("<LA_URL>")) {
                        int iIndexOf = strA.indexOf("</DATA>");
                        if (iIndexOf == -1) {
                            at0.d("FrameworkMediaDrm", "Could not find the </DATA> tag. Skipping LA_URL workaround.");
                        }
                        String str2 = strA.substring(0, iIndexOf) + "<LA_URL>https://x</LA_URL>" + strA.substring(iIndexOf);
                        int i7 = iK + 52;
                        ByteBuffer byteBufferAllocate = ByteBuffer.allocate(i7);
                        byteBufferAllocate.order(ByteOrder.LITTLE_ENDIAN);
                        byteBufferAllocate.putInt(i7);
                        byteBufferAllocate.putShort(sM);
                        byteBufferAllocate.putShort(sM2);
                        byteBufferAllocate.putShort((short) (str2.length() * 2));
                        byteBufferAllocate.put(str2.getBytes(charset));
                        bArrArray = byteBufferAllocate.array();
                    }
                } else {
                    at0.c("FrameworkMediaDrm", "Unexpected record count or type. Skipping LA_URL workaround.");
                }
                int length3 = (bArrArray != null ? bArrArray.length : 0) + 32;
                ByteBuffer byteBufferAllocate2 = ByteBuffer.allocate(length3);
                byteBufferAllocate2.putInt(length3);
                byteBufferAllocate2.putInt(1886614376);
                byteBufferAllocate2.putInt(0);
                byteBufferAllocate2.putLong(uuid2.getMostSignificantBits());
                byteBufferAllocate2.putLong(uuid2.getLeastSignificantBits());
                if (bArrArray != null && bArrArray.length != 0) {
                    byteBufferAllocate2.putInt(bArrArray.length);
                    byteBufferAllocate2.put(bArrArray);
                }
                bArrArray = byteBufferAllocate2.array();
            }
            int i8 = x82.f10629a;
            if (i8 >= 23 || !qm.d.equals(uuid)) {
                if (uuid2.equals(uuid)) {
                    d.getClass();
                    byte[] bArrDecode = Base64.decode("QW1hem9u", 0);
                    Intrinsics.checkNotNullExpressionValue(bArrDecode, "decode(...)");
                    Charset charset2 = Charsets.UTF_8;
                    if (new String(bArrDecode, charset2).equals(x82.c)) {
                        byte[] bArrDecode2 = Base64.decode("QUZUQg==", 0);
                        Intrinsics.checkNotNullExpressionValue(bArrDecode2, "decode(...)");
                        String str3 = new String(bArrDecode2, charset2);
                        String str4 = x82.d;
                        if (!str3.equals(str4)) {
                            byte[] bArrDecode3 = Base64.decode("QUZUUw==", 0);
                            Intrinsics.checkNotNullExpressionValue(bArrDecode3, "decode(...)");
                            if (!new String(bArrDecode3, charset2).equals(str4)) {
                                byte[] bArrDecode4 = Base64.decode("QUZUTQ==", 0);
                                Intrinsics.checkNotNullExpressionValue(bArrDecode4, "decode(...)");
                                if (!new String(bArrDecode4, charset2).equals(str4)) {
                                    byte[] bArrDecode5 = Base64.decode("QUZUVA==", 0);
                                    Intrinsics.checkNotNullExpressionValue(bArrDecode5, "decode(...)");
                                    if (new String(bArrDecode5, charset2).equals(str4)) {
                                        bArrA = vm1.a(uuid, bArrArray);
                                        if (bArrA != null) {
                                            bArrArray = bArrA;
                                        }
                                    }
                                } else {
                                    bArrA = vm1.a(uuid, bArrArray);
                                    if (bArrA != null) {
                                        bArrArray = bArrA;
                                    }
                                }
                            } else {
                                bArrA = vm1.a(uuid, bArrArray);
                                if (bArrA != null) {
                                    bArrArray = bArrA;
                                }
                            }
                        } else {
                            bArrA = vm1.a(uuid, bArrArray);
                            if (bArrA != null) {
                                bArrArray = bArrA;
                            }
                        }
                    }
                }
            } else {
                bArrA = vm1.a(uuid, bArrArray);
                if (bArrA != null) {
                    bArrArray = bArrA;
                }
            }
            UUID uuid3 = this.f9914a;
            String str5 = bVar.e;
            if (i8 < 26 && qm.c.equals(uuid3) && ("video/mp4".equals(str5) || "audio/mp4".equals(str5))) {
                str5 = "cenc";
            }
            byte[] bArr8 = bArrArray;
            str = str5;
            bArr2 = bArr8;
        } else {
            bVar = null;
            bArr2 = null;
            str = null;
        }
        MediaDrm.KeyRequest keyRequest = this.b.getKeyRequest(bArr, bArr2, str, i, map);
        UUID uuid4 = this.f9914a;
        byte[] data = keyRequest.getData();
        if (qm.c.equals(uuid4) && x82.f10629a < 27) {
            Charset charset3 = ko.c;
            data = new String(data, charset3).replace('+', '-').replace('/', '_').getBytes(charset3);
        }
        String defaultUrl = keyRequest.getDefaultUrl();
        if ("https://x".equals(defaultUrl)) {
            defaultUrl = "";
        }
        if (TextUtils.isEmpty(defaultUrl) && bVar != null && !TextUtils.isEmpty(bVar.d)) {
            defaultUrl = bVar.d;
        }
        if (x82.f10629a >= 23) {
            keyRequest.getRequestType();
        }
        return new i60.a(defaultUrl, data);
    }

    @Override // com.yandex.mobile.ads.impl.i60
    public final i60.d a() {
        MediaDrm.ProvisionRequest provisionRequest = this.b.getProvisionRequest();
        return new i60.d(provisionRequest.getDefaultUrl(), provisionRequest.getData());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(i60.b bVar, MediaDrm mediaDrm, byte[] bArr, int i, int i2, byte[] bArr2) {
        pz.c cVar = pz.this.y;
        cVar.getClass();
        cVar.obtainMessage(i, bArr).sendToTarget();
    }

    @Override // com.yandex.mobile.ads.impl.i60
    public final Map<String, String> a(byte[] bArr) {
        return this.b.queryKeyStatus(bArr);
    }

    @Override // com.yandex.mobile.ads.impl.i60
    public final void a(byte[] bArr, byte[] bArr2) {
        this.b.restoreKeys(bArr, bArr2);
    }

    @Override // com.yandex.mobile.ads.impl.i60
    public final void a(final i60.b bVar) {
        this.b.setOnEventListener(new MediaDrm.OnEventListener() { // from class: com.yandex.mobile.ads.impl.pc0$$ExternalSyntheticLambda1
            @Override // android.media.MediaDrm.OnEventListener
            public final void onEvent(MediaDrm mediaDrm, byte[] bArr, int i, int i2, byte[] bArr2) {
                this.f$0.a(bVar, mediaDrm, bArr, i, i2, bArr2);
            }
        });
    }

    @Override // com.yandex.mobile.ads.impl.i60
    public final void a(byte[] bArr, ii1 ii1Var) {
        if (x82.f10629a >= 31) {
            try {
                a.a(this.b, bArr, ii1Var);
            } catch (UnsupportedOperationException unused) {
                at0.d("FrameworkMediaDrm", "setLogSessionId failed.");
            }
        }
    }

    @Override // com.yandex.mobile.ads.impl.i60
    public final boolean a(String str, byte[] bArr) {
        if (x82.f10629a >= 31) {
            return a.a(this.b, str);
        }
        try {
            MediaCrypto mediaCrypto = new MediaCrypto(this.f9914a, bArr);
            try {
                return mediaCrypto.requiresSecureDecoderComponent(str);
            } finally {
                mediaCrypto.release();
            }
        } catch (MediaCryptoException unused) {
            return true;
        }
    }

    private static UUID a(UUID uuid) {
        return (x82.f10629a >= 27 || !qm.c.equals(uuid)) ? uuid : qm.b;
    }
}
