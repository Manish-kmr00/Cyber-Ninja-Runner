package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzgvv;
import com.google.android.gms.internal.ads.zzgvw;
import java.io.IOException;
import java.io.OutputStream;
import java.util.List;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads-api@@24.2.0 */
/* JADX INFO: loaded from: classes11.dex */
public abstract class zzgvw<MessageType extends zzgvw<MessageType, BuilderType>, BuilderType extends zzgvv<MessageType, BuilderType>> implements zzgzg {
    protected int zzq = 0;

    protected static <T> void zzaQ(Iterable<T> iterable, List<? super T> list) {
        zzgvv.zzbd(iterable, list);
    }

    protected static void zzaR(zzgwn zzgwnVar) throws IllegalArgumentException {
        if (!zzgwnVar.zzp()) {
            throw new IllegalArgumentException("Byte string is not UTF-8.");
        }
    }

    private String zzdF(String str) {
        return "Serializing " + getClass().getName() + " to a " + str + " threw an IOException (should never happen).";
    }

    int zzaL() {
        throw new UnsupportedOperationException();
    }

    int zzaM(zzgzz zzgzzVar) {
        return zzaL();
    }

    @Override // com.google.android.gms.internal.ads.zzgzg
    public zzgwn zzaN() {
        try {
            int iZzaY = zzaY();
            zzgwn zzgwnVar = zzgwn.zzb;
            byte[] bArr = new byte[iZzaY];
            int i = zzgxa.zzf;
            zzgww zzgwwVar = new zzgww(bArr, 0, iZzaY);
            zzcY(zzgwwVar);
            zzgwwVar.zzF();
            return new zzgwk(bArr);
        } catch (IOException e) {
            throw new RuntimeException(zzdF("ByteString"), e);
        }
    }

    public zzgzl zzaO() {
        throw new UnsupportedOperationException("mutableCopy() is not implemented.");
    }

    zzhak zzaP() {
        return new zzhak(this);
    }

    void zzaS(int i) {
        throw new UnsupportedOperationException();
    }

    public void zzaT(OutputStream outputStream) throws IOException {
        int iZzaY = zzaY();
        zzgwy zzgwyVar = new zzgwy(outputStream, zzgxa.zzB(zzgxa.zzD(iZzaY) + iZzaY));
        zzgwyVar.zzu(iZzaY);
        zzcY(zzgwyVar);
        zzgwyVar.zzK();
    }

    public void zzaU(OutputStream outputStream) throws IOException {
        zzgwy zzgwyVar = new zzgwy(outputStream, zzgxa.zzB(zzaY()));
        zzcY(zzgwyVar);
        zzgwyVar.zzK();
    }

    public byte[] zzaV() {
        try {
            int iZzaY = zzaY();
            byte[] bArr = new byte[iZzaY];
            int i = zzgxa.zzf;
            zzgww zzgwwVar = new zzgww(bArr, 0, iZzaY);
            zzcY(zzgwwVar);
            zzgwwVar.zzF();
            return bArr;
        } catch (IOException e) {
            throw new RuntimeException(zzdF("byte array"), e);
        }
    }
}
