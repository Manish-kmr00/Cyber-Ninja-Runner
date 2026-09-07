package io.bidmachine.analytics.internal;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.security.InvalidKeyException;
import java.security.Key;
import java.security.KeyFactory;
import java.security.KeyPair;
import java.security.NoSuchAlgorithmException;
import java.security.PublicKey;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.X509EncodedKeySpec;
import java.util.List;
import javax.crypto.KeyAgreement;
import javax.crypto.spec.SecretKeySpec;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: classes13.dex */
public final class C {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final byte[] f12042a;
    private final String b;
    private final byte[] c;
    private final boolean d;
    private final byte[] e;
    private final Key f;
    private final B g;

    public C(byte[] bArr, String str, byte[] bArr2, boolean z) {
        this.f12042a = bArr;
        this.b = str;
        this.c = bArr2;
        this.d = z;
        KeyPair keyPairB = new r().b();
        this.e = keyPairB.getPublic().getEncoded();
        this.f = keyPairB.getPrivate();
        this.g = new C4646w();
    }

    public final Key a() {
        return a(this.f, this.e, this.f12042a);
    }

    public final byte[] b() {
        return this.e;
    }

    public /* synthetic */ C(byte[] bArr, String str, byte[] bArr2, boolean z, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(bArr, str, (i & 4) != 0 ? null : bArr2, (i & 8) != 0 ? false : z);
    }

    public final Key a(Key key, byte[] bArr, byte[] bArr2) {
        return new SecretKeySpec(this.g.a(a(key, bArr2), this.d ? a(bArr, bArr2) : null, this.c), this.b);
    }

    private final byte[] a(byte[] bArr, byte[] bArr2) throws IOException {
        List listMutableListOf = CollectionsKt.mutableListOf(ByteBuffer.wrap(bArr), ByteBuffer.wrap(bArr2));
        CollectionsKt.sort(listMutableListOf);
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        byteArrayOutputStream.write(((ByteBuffer) listMutableListOf.get(0)).array());
        byteArrayOutputStream.write(((ByteBuffer) listMutableListOf.get(1)).array());
        return byteArrayOutputStream.toByteArray();
    }

    private final byte[] a(Key key, byte[] bArr) throws InvalidKeySpecException, NoSuchAlgorithmException, InvalidKeyException {
        PublicKey publicKeyGeneratePublic = KeyFactory.getInstance("EC").generatePublic(new X509EncodedKeySpec(bArr));
        KeyAgreement keyAgreement = KeyAgreement.getInstance("ECDH");
        keyAgreement.init(key);
        keyAgreement.doPhase(publicKeyGeneratePublic, true);
        return keyAgreement.generateSecret();
    }
}
