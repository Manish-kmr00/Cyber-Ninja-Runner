package io.bidmachine.analytics.internal;

import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.Key;
import java.security.NoSuchAlgorithmException;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.GCMParameterSpec;
import kotlin.collections.ArraysKt;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: renamed from: io.bidmachine.analytics.internal.a, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes9.dex */
public final class C4625a implements InterfaceC4626b {
    public static final C0774a b = new C0774a(null);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f12078a = "AES";

    /* JADX INFO: renamed from: io.bidmachine.analytics.internal.a$a, reason: collision with other inner class name */
    public static final class C0774a {
        private C0774a() {
        }

        public /* synthetic */ C0774a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    @Override // io.bidmachine.analytics.internal.InterfaceC4626b
    public byte[] a(Key key, byte[] bArr) throws BadPaddingException, IllegalBlockSizeException {
        byte[] bArrA = f0.f12086a.a(12);
        byte[] bArrDoFinal = a(1, key, bArrA).doFinal(bArr);
        byte[] bArr2 = new byte[bArrDoFinal.length + 12];
        ArraysKt.copyInto(bArrA, bArr2, 0, 0, 12);
        ArraysKt.copyInto(bArrDoFinal, bArr2, 12, 0, bArrDoFinal.length);
        return bArr2;
    }

    @Override // io.bidmachine.analytics.internal.InterfaceC4626b
    public String getName() {
        return this.f12078a;
    }

    private final Cipher a(int i, Key key, byte[] bArr) throws NoSuchPaddingException, NoSuchAlgorithmException, InvalidKeyException, InvalidAlgorithmParameterException {
        GCMParameterSpec gCMParameterSpec = new GCMParameterSpec(128, bArr);
        Cipher cipher = Cipher.getInstance("AES/GCM/NoPadding");
        cipher.init(i, key, gCMParameterSpec);
        return cipher;
    }
}
