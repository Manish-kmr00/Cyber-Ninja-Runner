package com.google.android.gms.internal.ads;

import com.json.cc;
import java.io.IOException;
import java.math.RoundingMode;
import java.util.Objects;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.2.0 */
/* JADX INFO: loaded from: classes8.dex */
class zzfzi extends zzfzj {
    private volatile zzfzj zza;
    final zzfze zzb;
    final Character zzc;

    zzfzi(zzfze zzfzeVar, Character ch) {
        this.zzb = zzfzeVar;
        boolean z = true;
        if (ch != null) {
            ch.charValue();
            if (zzfzeVar.zze(cc.T)) {
                z = false;
            }
        }
        zzftw.zzi(z, "Padding character %s was already in alphabet", ch);
        this.zzc = ch;
    }

    public final boolean equals(Object obj) {
        if (obj instanceof zzfzi) {
            zzfzi zzfziVar = (zzfzi) obj;
            if (this.zzb.equals(zzfziVar.zzb) && Objects.equals(this.zzc, zzfziVar.zzc)) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        Character ch = this.zzc;
        return Objects.hashCode(ch) ^ this.zzb.hashCode();
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("BaseEncoding.");
        zzfze zzfzeVar = this.zzb;
        sb.append(zzfzeVar);
        if (8 % zzfzeVar.zzb != 0) {
            Character ch = this.zzc;
            if (ch == null) {
                sb.append(".omitPadding()");
            } else {
                sb.append(".withPadChar('");
                sb.append(ch);
                sb.append("')");
            }
        }
        return sb.toString();
    }

    @Override // com.google.android.gms.internal.ads.zzfzj
    int zza(byte[] bArr, CharSequence charSequence) throws zzfzh {
        int i;
        CharSequence charSequenceZzg = zzg(charSequence);
        int length = charSequenceZzg.length();
        zzfze zzfzeVar = this.zzb;
        if (!zzfzeVar.zzd(length)) {
            throw new zzfzh("Invalid input length " + charSequenceZzg.length());
        }
        int i2 = 0;
        int i3 = 0;
        while (i2 < charSequenceZzg.length()) {
            long jZzb = 0;
            int i4 = 0;
            int i5 = 0;
            while (true) {
                i = zzfzeVar.zzc;
                if (i4 >= i) {
                    break;
                }
                jZzb <<= zzfzeVar.zzb;
                if (i2 + i4 < charSequenceZzg.length()) {
                    jZzb |= (long) zzfzeVar.zzb(charSequenceZzg.charAt(i5 + i2));
                    i5++;
                }
                i4++;
            }
            int i6 = zzfzeVar.zzd;
            int i7 = i5 * zzfzeVar.zzb;
            int i8 = (i6 - 1) * 8;
            while (i8 >= (i6 * 8) - i7) {
                bArr[i3] = (byte) ((jZzb >>> i8) & 255);
                i8 -= 8;
                i3++;
            }
            i2 += i;
        }
        return i3;
    }

    zzfzj zzb(zzfze zzfzeVar, Character ch) {
        return new zzfzi(zzfzeVar, ch);
    }

    @Override // com.google.android.gms.internal.ads.zzfzj
    void zzc(Appendable appendable, byte[] bArr, int i, int i2) throws IOException {
        int i3 = 0;
        zzftw.zzk(0, i2, bArr.length);
        while (i3 < i2) {
            int i4 = this.zzb.zzd;
            zzh(appendable, bArr, i3, Math.min(i4, i2 - i3));
            i3 += i4;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzfzj
    final int zzd(int i) {
        return (int) (((((long) this.zzb.zzb) * ((long) i)) + 7) / 8);
    }

    @Override // com.google.android.gms.internal.ads.zzfzj
    final int zze(int i) {
        zzfze zzfzeVar = this.zzb;
        return zzfzeVar.zzc * zzfzs.zzb(i, zzfzeVar.zzd, RoundingMode.CEILING);
    }

    @Override // com.google.android.gms.internal.ads.zzfzj
    public final zzfzj zzf() {
        zzfzj zzfzjVarZzb = this.zza;
        if (zzfzjVarZzb == null) {
            zzfze zzfzeVar = this.zzb;
            zzfze zzfzeVarZzc = zzfzeVar.zzc();
            zzfzjVarZzb = zzfzeVarZzc == zzfzeVar ? this : zzb(zzfzeVarZzc, this.zzc);
            this.zza = zzfzjVarZzb;
        }
        return zzfzjVarZzb;
    }

    final void zzh(Appendable appendable, byte[] bArr, int i, int i2) throws IOException {
        zzftw.zzk(i, i + i2, bArr.length);
        zzfze zzfzeVar = this.zzb;
        int i3 = zzfzeVar.zzd;
        int i4 = 0;
        zzftw.zze(i2 <= i3);
        long j = 0;
        for (int i5 = 0; i5 < i2; i5++) {
            j = (j | ((long) (bArr[i + i5] & 255))) << 8;
        }
        int i6 = (i2 + 1) * 8;
        int i7 = zzfzeVar.zzb;
        while (i4 < i2 * 8) {
            appendable.append(zzfzeVar.zza(zzfzeVar.zza & ((int) (j >>> ((i6 - i7) - i4)))));
            i4 += i7;
        }
        Character ch = this.zzc;
        if (ch != null) {
            while (i4 < i3 * 8) {
                ch.charValue();
                appendable.append(cc.T);
                i4 += i7;
            }
        }
    }

    zzfzi(String str, String str2, Character ch) {
        this(new zzfze(str, str2.toCharArray()), ch);
    }

    @Override // com.google.android.gms.internal.ads.zzfzj
    final CharSequence zzg(CharSequence charSequence) {
        charSequence.getClass();
        Character ch = this.zzc;
        if (ch == null) {
            return charSequence;
        }
        ch.charValue();
        int length = charSequence.length();
        do {
            length--;
            if (length < 0) {
                break;
            }
        } while (charSequence.charAt(length) == '=');
        return charSequence.subSequence(0, length + 1);
    }
}
