package com.google.android.gms.internal.ads;

import java.io.IOException;
import java.util.List;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads-api@@24.2.0 */
/* JADX INFO: loaded from: classes11.dex */
final class zzgwu implements zzgzt {
    private final zzgwt zza;
    private int zzb;
    private int zzc;
    private int zzd = 0;

    private zzgwu(zzgwt zzgwtVar) {
        zzgyi.zzc(zzgwtVar, "input");
        this.zza = zzgwtVar;
        zzgwtVar.zzd = this;
    }

    private final void zzO(Object obj, zzgzz zzgzzVar, zzgxf zzgxfVar) throws IOException {
        int i = this.zzc;
        this.zzc = ((this.zzb >>> 3) << 3) | 4;
        try {
            zzgzzVar.zzh(obj, this, zzgxfVar);
            if (this.zzb != this.zzc) {
                throw new zzgyk("Failed to parse the message.");
            }
            this.zzc = i;
        } catch (Throwable th) {
            this.zzc = i;
            throw th;
        }
    }

    private final void zzP(Object obj, zzgzz zzgzzVar, zzgxf zzgxfVar) throws IOException {
        zzgwt zzgwtVar = this.zza;
        int iZzm = zzgwtVar.zzm();
        if (zzgwtVar.zzb >= zzgwtVar.zzc) {
            throw new zzgyk("Protocol message had too many levels of nesting.  May be malicious.  Use setRecursionLimit() to increase the recursion depth limit.");
        }
        int iZzd = zzgwtVar.zzd(iZzm);
        zzgwtVar.zzb++;
        zzgzzVar.zzh(obj, this, zzgxfVar);
        zzgwtVar.zzy(0);
        zzgwtVar.zzb--;
        zzgwtVar.zzz(iZzd);
    }

    private final void zzQ(int i) throws IOException {
        if (this.zza.zzc() != i) {
            throw new zzgyk("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either that the input has been truncated or that an embedded message misreported its own length.");
        }
    }

    private final void zzR(int i) throws IOException {
        if ((this.zzb & 7) != i) {
            throw new zzgyj("Protocol message tag had invalid wire type.");
        }
    }

    private static final void zzS(int i) throws IOException {
        if ((i & 3) != 0) {
            throw new zzgyk("Failed to parse the message.");
        }
    }

    private static final void zzT(int i) throws IOException {
        if ((i & 7) != 0) {
            throw new zzgyk("Failed to parse the message.");
        }
    }

    public static zzgwu zzq(zzgwt zzgwtVar) {
        zzgwu zzgwuVar = zzgwtVar.zzd;
        return zzgwuVar != null ? zzgwuVar : new zzgwu(zzgwtVar);
    }

    @Override // com.google.android.gms.internal.ads.zzgzt
    public final void zzA(List list) throws IOException {
        int iZzl;
        int iZzl2;
        if (list instanceof zzgyv) {
            zzgyv zzgyvVar = (zzgyv) list;
            int i = this.zzb & 7;
            if (i != 1) {
                if (i != 2) {
                    throw new zzgyj("Protocol message tag had invalid wire type.");
                }
                zzgwt zzgwtVar = this.zza;
                int iZzm = zzgwtVar.zzm();
                zzT(iZzm);
                int iZzc = zzgwtVar.zzc() + iZzm;
                do {
                    zzgyvVar.zzg(zzgwtVar.zzn());
                } while (zzgwtVar.zzc() < iZzc);
                return;
            }
            do {
                zzgwt zzgwtVar2 = this.zza;
                zzgyvVar.zzg(zzgwtVar2.zzn());
                if (zzgwtVar2.zzA()) {
                    return;
                } else {
                    iZzl2 = zzgwtVar2.zzl();
                }
            } while (iZzl2 == this.zzb);
        } else {
            int i2 = this.zzb & 7;
            if (i2 != 1) {
                if (i2 != 2) {
                    throw new zzgyj("Protocol message tag had invalid wire type.");
                }
                zzgwt zzgwtVar3 = this.zza;
                int iZzm2 = zzgwtVar3.zzm();
                zzT(iZzm2);
                int iZzc2 = zzgwtVar3.zzc() + iZzm2;
                do {
                    list.add(Long.valueOf(zzgwtVar3.zzn()));
                } while (zzgwtVar3.zzc() < iZzc2);
                return;
            }
            do {
                zzgwt zzgwtVar4 = this.zza;
                list.add(Long.valueOf(zzgwtVar4.zzn()));
                if (zzgwtVar4.zzA()) {
                    return;
                } else {
                    iZzl = zzgwtVar4.zzl();
                }
            } while (iZzl == this.zzb);
            iZzl2 = iZzl;
        }
        this.zzd = iZzl2;
    }

    @Override // com.google.android.gms.internal.ads.zzgzt
    public final void zzB(List list) throws IOException {
        int iZzl;
        int iZzl2;
        if (list instanceof zzgxm) {
            zzgxm zzgxmVar = (zzgxm) list;
            int i = this.zzb & 7;
            if (i == 2) {
                zzgwt zzgwtVar = this.zza;
                int iZzm = zzgwtVar.zzm();
                zzS(iZzm);
                int iZzc = zzgwtVar.zzc() + iZzm;
                do {
                    zzgxmVar.zzh(zzgwtVar.zzb());
                } while (zzgwtVar.zzc() < iZzc);
                return;
            }
            if (i != 5) {
                throw new zzgyj("Protocol message tag had invalid wire type.");
            }
            do {
                zzgwt zzgwtVar2 = this.zza;
                zzgxmVar.zzh(zzgwtVar2.zzb());
                if (zzgwtVar2.zzA()) {
                    return;
                } else {
                    iZzl2 = zzgwtVar2.zzl();
                }
            } while (iZzl2 == this.zzb);
        } else {
            int i2 = this.zzb & 7;
            if (i2 == 2) {
                zzgwt zzgwtVar3 = this.zza;
                int iZzm2 = zzgwtVar3.zzm();
                zzS(iZzm2);
                int iZzc2 = zzgwtVar3.zzc() + iZzm2;
                do {
                    list.add(Float.valueOf(zzgwtVar3.zzb()));
                } while (zzgwtVar3.zzc() < iZzc2);
                return;
            }
            if (i2 != 5) {
                throw new zzgyj("Protocol message tag had invalid wire type.");
            }
            do {
                zzgwt zzgwtVar4 = this.zza;
                list.add(Float.valueOf(zzgwtVar4.zzb()));
                if (zzgwtVar4.zzA()) {
                    return;
                } else {
                    iZzl = zzgwtVar4.zzl();
                }
            } while (iZzl == this.zzb);
            iZzl2 = iZzl;
        }
        this.zzd = iZzl2;
    }

    @Override // com.google.android.gms.internal.ads.zzgzt
    @Deprecated
    public final void zzC(List list, zzgzz zzgzzVar, zzgxf zzgxfVar) throws IOException {
        int iZzl;
        int i = this.zzb;
        if ((i & 7) != 3) {
            throw new zzgyj("Protocol message tag had invalid wire type.");
        }
        do {
            Object objZze = zzgzzVar.zze();
            zzO(objZze, zzgzzVar, zzgxfVar);
            zzgzzVar.zzf(objZze);
            list.add(objZze);
            zzgwt zzgwtVar = this.zza;
            if (zzgwtVar.zzA() || this.zzd != 0) {
                return;
            } else {
                iZzl = zzgwtVar.zzl();
            }
        } while (iZzl == i);
        this.zzd = iZzl;
    }

    @Override // com.google.android.gms.internal.ads.zzgzt
    public final void zzD(List list) throws IOException {
        int iZzl;
        int iZzl2;
        if (list instanceof zzgxw) {
            zzgxw zzgxwVar = (zzgxw) list;
            int i = this.zzb & 7;
            if (i != 0) {
                if (i != 2) {
                    throw new zzgyj("Protocol message tag had invalid wire type.");
                }
                zzgwt zzgwtVar = this.zza;
                int iZzc = zzgwtVar.zzc() + zzgwtVar.zzm();
                do {
                    zzgxwVar.zzi(zzgwtVar.zzg());
                } while (zzgwtVar.zzc() < iZzc);
                zzQ(iZzc);
                return;
            }
            do {
                zzgwt zzgwtVar2 = this.zza;
                zzgxwVar.zzi(zzgwtVar2.zzg());
                if (zzgwtVar2.zzA()) {
                    return;
                } else {
                    iZzl2 = zzgwtVar2.zzl();
                }
            } while (iZzl2 == this.zzb);
        } else {
            int i2 = this.zzb & 7;
            if (i2 != 0) {
                if (i2 != 2) {
                    throw new zzgyj("Protocol message tag had invalid wire type.");
                }
                zzgwt zzgwtVar3 = this.zza;
                int iZzc2 = zzgwtVar3.zzc() + zzgwtVar3.zzm();
                do {
                    list.add(Integer.valueOf(zzgwtVar3.zzg()));
                } while (zzgwtVar3.zzc() < iZzc2);
                zzQ(iZzc2);
                return;
            }
            do {
                zzgwt zzgwtVar4 = this.zza;
                list.add(Integer.valueOf(zzgwtVar4.zzg()));
                if (zzgwtVar4.zzA()) {
                    return;
                } else {
                    iZzl = zzgwtVar4.zzl();
                }
            } while (iZzl == this.zzb);
            iZzl2 = iZzl;
        }
        this.zzd = iZzl2;
    }

    @Override // com.google.android.gms.internal.ads.zzgzt
    public final void zzE(List list) throws IOException {
        int iZzl;
        int iZzl2;
        if (list instanceof zzgyv) {
            zzgyv zzgyvVar = (zzgyv) list;
            int i = this.zzb & 7;
            if (i != 0) {
                if (i != 2) {
                    throw new zzgyj("Protocol message tag had invalid wire type.");
                }
                zzgwt zzgwtVar = this.zza;
                int iZzc = zzgwtVar.zzc() + zzgwtVar.zzm();
                do {
                    zzgyvVar.zzg(zzgwtVar.zzo());
                } while (zzgwtVar.zzc() < iZzc);
                zzQ(iZzc);
                return;
            }
            do {
                zzgwt zzgwtVar2 = this.zza;
                zzgyvVar.zzg(zzgwtVar2.zzo());
                if (zzgwtVar2.zzA()) {
                    return;
                } else {
                    iZzl2 = zzgwtVar2.zzl();
                }
            } while (iZzl2 == this.zzb);
        } else {
            int i2 = this.zzb & 7;
            if (i2 != 0) {
                if (i2 != 2) {
                    throw new zzgyj("Protocol message tag had invalid wire type.");
                }
                zzgwt zzgwtVar3 = this.zza;
                int iZzc2 = zzgwtVar3.zzc() + zzgwtVar3.zzm();
                do {
                    list.add(Long.valueOf(zzgwtVar3.zzo()));
                } while (zzgwtVar3.zzc() < iZzc2);
                zzQ(iZzc2);
                return;
            }
            do {
                zzgwt zzgwtVar4 = this.zza;
                list.add(Long.valueOf(zzgwtVar4.zzo()));
                if (zzgwtVar4.zzA()) {
                    return;
                } else {
                    iZzl = zzgwtVar4.zzl();
                }
            } while (iZzl == this.zzb);
            iZzl2 = iZzl;
        }
        this.zzd = iZzl2;
    }

    @Override // com.google.android.gms.internal.ads.zzgzt
    public final void zzF(List list, zzgzz zzgzzVar, zzgxf zzgxfVar) throws IOException {
        int iZzl;
        int i = this.zzb;
        if ((i & 7) != 2) {
            throw new zzgyj("Protocol message tag had invalid wire type.");
        }
        do {
            Object objZze = zzgzzVar.zze();
            zzP(objZze, zzgzzVar, zzgxfVar);
            zzgzzVar.zzf(objZze);
            list.add(objZze);
            zzgwt zzgwtVar = this.zza;
            if (zzgwtVar.zzA() || this.zzd != 0) {
                return;
            } else {
                iZzl = zzgwtVar.zzl();
            }
        } while (iZzl == i);
        this.zzd = iZzl;
    }

    @Override // com.google.android.gms.internal.ads.zzgzt
    public final void zzG(List list) throws IOException {
        int iZzl;
        int iZzl2;
        if (list instanceof zzgxw) {
            zzgxw zzgxwVar = (zzgxw) list;
            int i = this.zzb & 7;
            if (i == 2) {
                zzgwt zzgwtVar = this.zza;
                int iZzm = zzgwtVar.zzm();
                zzS(iZzm);
                int iZzc = zzgwtVar.zzc() + iZzm;
                do {
                    zzgxwVar.zzi(zzgwtVar.zzj());
                } while (zzgwtVar.zzc() < iZzc);
                return;
            }
            if (i != 5) {
                throw new zzgyj("Protocol message tag had invalid wire type.");
            }
            do {
                zzgwt zzgwtVar2 = this.zza;
                zzgxwVar.zzi(zzgwtVar2.zzj());
                if (zzgwtVar2.zzA()) {
                    return;
                } else {
                    iZzl2 = zzgwtVar2.zzl();
                }
            } while (iZzl2 == this.zzb);
        } else {
            int i2 = this.zzb & 7;
            if (i2 == 2) {
                zzgwt zzgwtVar3 = this.zza;
                int iZzm2 = zzgwtVar3.zzm();
                zzS(iZzm2);
                int iZzc2 = zzgwtVar3.zzc() + iZzm2;
                do {
                    list.add(Integer.valueOf(zzgwtVar3.zzj()));
                } while (zzgwtVar3.zzc() < iZzc2);
                return;
            }
            if (i2 != 5) {
                throw new zzgyj("Protocol message tag had invalid wire type.");
            }
            do {
                zzgwt zzgwtVar4 = this.zza;
                list.add(Integer.valueOf(zzgwtVar4.zzj()));
                if (zzgwtVar4.zzA()) {
                    return;
                } else {
                    iZzl = zzgwtVar4.zzl();
                }
            } while (iZzl == this.zzb);
            iZzl2 = iZzl;
        }
        this.zzd = iZzl2;
    }

    @Override // com.google.android.gms.internal.ads.zzgzt
    public final void zzH(List list) throws IOException {
        int iZzl;
        int iZzl2;
        if (list instanceof zzgyv) {
            zzgyv zzgyvVar = (zzgyv) list;
            int i = this.zzb & 7;
            if (i != 1) {
                if (i != 2) {
                    throw new zzgyj("Protocol message tag had invalid wire type.");
                }
                zzgwt zzgwtVar = this.zza;
                int iZzm = zzgwtVar.zzm();
                zzT(iZzm);
                int iZzc = zzgwtVar.zzc() + iZzm;
                do {
                    zzgyvVar.zzg(zzgwtVar.zzs());
                } while (zzgwtVar.zzc() < iZzc);
                return;
            }
            do {
                zzgwt zzgwtVar2 = this.zza;
                zzgyvVar.zzg(zzgwtVar2.zzs());
                if (zzgwtVar2.zzA()) {
                    return;
                } else {
                    iZzl2 = zzgwtVar2.zzl();
                }
            } while (iZzl2 == this.zzb);
        } else {
            int i2 = this.zzb & 7;
            if (i2 != 1) {
                if (i2 != 2) {
                    throw new zzgyj("Protocol message tag had invalid wire type.");
                }
                zzgwt zzgwtVar3 = this.zza;
                int iZzm2 = zzgwtVar3.zzm();
                zzT(iZzm2);
                int iZzc2 = zzgwtVar3.zzc() + iZzm2;
                do {
                    list.add(Long.valueOf(zzgwtVar3.zzs()));
                } while (zzgwtVar3.zzc() < iZzc2);
                return;
            }
            do {
                zzgwt zzgwtVar4 = this.zza;
                list.add(Long.valueOf(zzgwtVar4.zzs()));
                if (zzgwtVar4.zzA()) {
                    return;
                } else {
                    iZzl = zzgwtVar4.zzl();
                }
            } while (iZzl == this.zzb);
            iZzl2 = iZzl;
        }
        this.zzd = iZzl2;
    }

    @Override // com.google.android.gms.internal.ads.zzgzt
    public final void zzI(List list) throws IOException {
        int iZzl;
        int iZzl2;
        if (list instanceof zzgxw) {
            zzgxw zzgxwVar = (zzgxw) list;
            int i = this.zzb & 7;
            if (i != 0) {
                if (i != 2) {
                    throw new zzgyj("Protocol message tag had invalid wire type.");
                }
                zzgwt zzgwtVar = this.zza;
                int iZzc = zzgwtVar.zzc() + zzgwtVar.zzm();
                do {
                    zzgxwVar.zzi(zzgwtVar.zzk());
                } while (zzgwtVar.zzc() < iZzc);
                zzQ(iZzc);
                return;
            }
            do {
                zzgwt zzgwtVar2 = this.zza;
                zzgxwVar.zzi(zzgwtVar2.zzk());
                if (zzgwtVar2.zzA()) {
                    return;
                } else {
                    iZzl2 = zzgwtVar2.zzl();
                }
            } while (iZzl2 == this.zzb);
        } else {
            int i2 = this.zzb & 7;
            if (i2 != 0) {
                if (i2 != 2) {
                    throw new zzgyj("Protocol message tag had invalid wire type.");
                }
                zzgwt zzgwtVar3 = this.zza;
                int iZzc2 = zzgwtVar3.zzc() + zzgwtVar3.zzm();
                do {
                    list.add(Integer.valueOf(zzgwtVar3.zzk()));
                } while (zzgwtVar3.zzc() < iZzc2);
                zzQ(iZzc2);
                return;
            }
            do {
                zzgwt zzgwtVar4 = this.zza;
                list.add(Integer.valueOf(zzgwtVar4.zzk()));
                if (zzgwtVar4.zzA()) {
                    return;
                } else {
                    iZzl = zzgwtVar4.zzl();
                }
            } while (iZzl == this.zzb);
            iZzl2 = iZzl;
        }
        this.zzd = iZzl2;
    }

    @Override // com.google.android.gms.internal.ads.zzgzt
    public final void zzJ(List list) throws IOException {
        int iZzl;
        int iZzl2;
        if (list instanceof zzgyv) {
            zzgyv zzgyvVar = (zzgyv) list;
            int i = this.zzb & 7;
            if (i != 0) {
                if (i != 2) {
                    throw new zzgyj("Protocol message tag had invalid wire type.");
                }
                zzgwt zzgwtVar = this.zza;
                int iZzc = zzgwtVar.zzc() + zzgwtVar.zzm();
                do {
                    zzgyvVar.zzg(zzgwtVar.zzt());
                } while (zzgwtVar.zzc() < iZzc);
                zzQ(iZzc);
                return;
            }
            do {
                zzgwt zzgwtVar2 = this.zza;
                zzgyvVar.zzg(zzgwtVar2.zzt());
                if (zzgwtVar2.zzA()) {
                    return;
                } else {
                    iZzl2 = zzgwtVar2.zzl();
                }
            } while (iZzl2 == this.zzb);
        } else {
            int i2 = this.zzb & 7;
            if (i2 != 0) {
                if (i2 != 2) {
                    throw new zzgyj("Protocol message tag had invalid wire type.");
                }
                zzgwt zzgwtVar3 = this.zza;
                int iZzc2 = zzgwtVar3.zzc() + zzgwtVar3.zzm();
                do {
                    list.add(Long.valueOf(zzgwtVar3.zzt()));
                } while (zzgwtVar3.zzc() < iZzc2);
                zzQ(iZzc2);
                return;
            }
            do {
                zzgwt zzgwtVar4 = this.zza;
                list.add(Long.valueOf(zzgwtVar4.zzt()));
                if (zzgwtVar4.zzA()) {
                    return;
                } else {
                    iZzl = zzgwtVar4.zzl();
                }
            } while (iZzl == this.zzb);
            iZzl2 = iZzl;
        }
        this.zzd = iZzl2;
    }

    public final void zzK(List list, boolean z) throws IOException {
        int iZzl;
        int iZzl2;
        if ((this.zzb & 7) != 2) {
            throw new zzgyj("Protocol message tag had invalid wire type.");
        }
        if ((list instanceof zzgys) && !z) {
            zzgys zzgysVar = (zzgys) list;
            do {
                zzp();
                zzgysVar.zzb();
                zzgwt zzgwtVar = this.zza;
                if (zzgwtVar.zzA()) {
                    return;
                } else {
                    iZzl2 = zzgwtVar.zzl();
                }
            } while (iZzl2 == this.zzb);
        } else {
            do {
                list.add(z ? zzs() : zzr());
                zzgwt zzgwtVar2 = this.zza;
                if (zzgwtVar2.zzA()) {
                    return;
                } else {
                    iZzl = zzgwtVar2.zzl();
                }
            } while (iZzl == this.zzb);
            iZzl2 = iZzl;
        }
        this.zzd = iZzl2;
    }

    @Override // com.google.android.gms.internal.ads.zzgzt
    public final void zzL(List list) throws IOException {
        int iZzl;
        int iZzl2;
        if (list instanceof zzgxw) {
            zzgxw zzgxwVar = (zzgxw) list;
            int i = this.zzb & 7;
            if (i != 0) {
                if (i != 2) {
                    throw new zzgyj("Protocol message tag had invalid wire type.");
                }
                zzgwt zzgwtVar = this.zza;
                int iZzc = zzgwtVar.zzc() + zzgwtVar.zzm();
                do {
                    zzgxwVar.zzi(zzgwtVar.zzm());
                } while (zzgwtVar.zzc() < iZzc);
                zzQ(iZzc);
                return;
            }
            do {
                zzgwt zzgwtVar2 = this.zza;
                zzgxwVar.zzi(zzgwtVar2.zzm());
                if (zzgwtVar2.zzA()) {
                    return;
                } else {
                    iZzl2 = zzgwtVar2.zzl();
                }
            } while (iZzl2 == this.zzb);
        } else {
            int i2 = this.zzb & 7;
            if (i2 != 0) {
                if (i2 != 2) {
                    throw new zzgyj("Protocol message tag had invalid wire type.");
                }
                zzgwt zzgwtVar3 = this.zza;
                int iZzc2 = zzgwtVar3.zzc() + zzgwtVar3.zzm();
                do {
                    list.add(Integer.valueOf(zzgwtVar3.zzm()));
                } while (zzgwtVar3.zzc() < iZzc2);
                zzQ(iZzc2);
                return;
            }
            do {
                zzgwt zzgwtVar4 = this.zza;
                list.add(Integer.valueOf(zzgwtVar4.zzm()));
                if (zzgwtVar4.zzA()) {
                    return;
                } else {
                    iZzl = zzgwtVar4.zzl();
                }
            } while (iZzl == this.zzb);
            iZzl2 = iZzl;
        }
        this.zzd = iZzl2;
    }

    @Override // com.google.android.gms.internal.ads.zzgzt
    public final void zzM(List list) throws IOException {
        int iZzl;
        int iZzl2;
        if (list instanceof zzgyv) {
            zzgyv zzgyvVar = (zzgyv) list;
            int i = this.zzb & 7;
            if (i != 0) {
                if (i != 2) {
                    throw new zzgyj("Protocol message tag had invalid wire type.");
                }
                zzgwt zzgwtVar = this.zza;
                int iZzc = zzgwtVar.zzc() + zzgwtVar.zzm();
                do {
                    zzgyvVar.zzg(zzgwtVar.zzu());
                } while (zzgwtVar.zzc() < iZzc);
                zzQ(iZzc);
                return;
            }
            do {
                zzgwt zzgwtVar2 = this.zza;
                zzgyvVar.zzg(zzgwtVar2.zzu());
                if (zzgwtVar2.zzA()) {
                    return;
                } else {
                    iZzl2 = zzgwtVar2.zzl();
                }
            } while (iZzl2 == this.zzb);
        } else {
            int i2 = this.zzb & 7;
            if (i2 != 0) {
                if (i2 != 2) {
                    throw new zzgyj("Protocol message tag had invalid wire type.");
                }
                zzgwt zzgwtVar3 = this.zza;
                int iZzc2 = zzgwtVar3.zzc() + zzgwtVar3.zzm();
                do {
                    list.add(Long.valueOf(zzgwtVar3.zzu()));
                } while (zzgwtVar3.zzc() < iZzc2);
                zzQ(iZzc2);
                return;
            }
            do {
                zzgwt zzgwtVar4 = this.zza;
                list.add(Long.valueOf(zzgwtVar4.zzu()));
                if (zzgwtVar4.zzA()) {
                    return;
                } else {
                    iZzl = zzgwtVar4.zzl();
                }
            } while (iZzl == this.zzb);
            iZzl2 = iZzl;
        }
        this.zzd = iZzl2;
    }

    @Override // com.google.android.gms.internal.ads.zzgzt
    public final boolean zzN() throws IOException {
        zzR(0);
        return this.zza.zzB();
    }

    @Override // com.google.android.gms.internal.ads.zzgzt
    public final double zza() throws IOException {
        zzR(1);
        return this.zza.zza();
    }

    @Override // com.google.android.gms.internal.ads.zzgzt
    public final float zzb() throws IOException {
        zzR(5);
        return this.zza.zzb();
    }

    @Override // com.google.android.gms.internal.ads.zzgzt
    public final int zzc() throws IOException {
        int iZzl = this.zzd;
        if (iZzl != 0) {
            this.zzb = iZzl;
            this.zzd = 0;
        } else {
            iZzl = this.zza.zzl();
            this.zzb = iZzl;
        }
        if (iZzl == 0 || iZzl == this.zzc) {
            return Integer.MAX_VALUE;
        }
        return iZzl >>> 3;
    }

    @Override // com.google.android.gms.internal.ads.zzgzt
    public final int zzd() {
        return this.zzb;
    }

    @Override // com.google.android.gms.internal.ads.zzgzt
    public final int zze() throws IOException {
        zzR(0);
        return this.zza.zze();
    }

    @Override // com.google.android.gms.internal.ads.zzgzt
    public final int zzf() throws IOException {
        zzR(5);
        return this.zza.zzf();
    }

    @Override // com.google.android.gms.internal.ads.zzgzt
    public final int zzg() throws IOException {
        zzR(0);
        return this.zza.zzg();
    }

    @Override // com.google.android.gms.internal.ads.zzgzt
    public final int zzh() throws IOException {
        zzR(5);
        return this.zza.zzj();
    }

    @Override // com.google.android.gms.internal.ads.zzgzt
    public final int zzi() throws IOException {
        zzR(0);
        return this.zza.zzk();
    }

    @Override // com.google.android.gms.internal.ads.zzgzt
    public final int zzj() throws IOException {
        zzR(0);
        return this.zza.zzm();
    }

    @Override // com.google.android.gms.internal.ads.zzgzt
    public final long zzk() throws IOException {
        zzR(1);
        return this.zza.zzn();
    }

    @Override // com.google.android.gms.internal.ads.zzgzt
    public final long zzl() throws IOException {
        zzR(0);
        return this.zza.zzo();
    }

    @Override // com.google.android.gms.internal.ads.zzgzt
    public final long zzm() throws IOException {
        zzR(1);
        return this.zza.zzs();
    }

    @Override // com.google.android.gms.internal.ads.zzgzt
    public final long zzn() throws IOException {
        zzR(0);
        return this.zza.zzt();
    }

    @Override // com.google.android.gms.internal.ads.zzgzt
    public final long zzo() throws IOException {
        zzR(0);
        return this.zza.zzu();
    }

    @Override // com.google.android.gms.internal.ads.zzgzt
    public final zzgwn zzp() throws IOException {
        zzR(2);
        return this.zza.zzv();
    }

    @Override // com.google.android.gms.internal.ads.zzgzt
    public final String zzr() throws IOException {
        zzR(2);
        return this.zza.zzw();
    }

    @Override // com.google.android.gms.internal.ads.zzgzt
    public final String zzs() throws IOException {
        zzR(2);
        return this.zza.zzx();
    }

    @Override // com.google.android.gms.internal.ads.zzgzt
    public final void zzt(Object obj, zzgzz zzgzzVar, zzgxf zzgxfVar) throws IOException {
        zzR(3);
        zzO(obj, zzgzzVar, zzgxfVar);
    }

    @Override // com.google.android.gms.internal.ads.zzgzt
    public final void zzu(Object obj, zzgzz zzgzzVar, zzgxf zzgxfVar) throws IOException {
        zzR(2);
        zzP(obj, zzgzzVar, zzgxfVar);
    }

    @Override // com.google.android.gms.internal.ads.zzgzt
    public final void zzv(List list) throws IOException {
        int iZzl;
        int iZzl2;
        if (list instanceof zzgwd) {
            zzgwd zzgwdVar = (zzgwd) list;
            int i = this.zzb & 7;
            if (i != 0) {
                if (i != 2) {
                    throw new zzgyj("Protocol message tag had invalid wire type.");
                }
                zzgwt zzgwtVar = this.zza;
                int iZzc = zzgwtVar.zzc() + zzgwtVar.zzm();
                do {
                    zzgwdVar.zzg(zzgwtVar.zzB());
                } while (zzgwtVar.zzc() < iZzc);
                zzQ(iZzc);
                return;
            }
            do {
                zzgwt zzgwtVar2 = this.zza;
                zzgwdVar.zzg(zzgwtVar2.zzB());
                if (zzgwtVar2.zzA()) {
                    return;
                } else {
                    iZzl2 = zzgwtVar2.zzl();
                }
            } while (iZzl2 == this.zzb);
        } else {
            int i2 = this.zzb & 7;
            if (i2 != 0) {
                if (i2 != 2) {
                    throw new zzgyj("Protocol message tag had invalid wire type.");
                }
                zzgwt zzgwtVar3 = this.zza;
                int iZzc2 = zzgwtVar3.zzc() + zzgwtVar3.zzm();
                do {
                    list.add(Boolean.valueOf(zzgwtVar3.zzB()));
                } while (zzgwtVar3.zzc() < iZzc2);
                zzQ(iZzc2);
                return;
            }
            do {
                zzgwt zzgwtVar4 = this.zza;
                list.add(Boolean.valueOf(zzgwtVar4.zzB()));
                if (zzgwtVar4.zzA()) {
                    return;
                } else {
                    iZzl = zzgwtVar4.zzl();
                }
            } while (iZzl == this.zzb);
            iZzl2 = iZzl;
        }
        this.zzd = iZzl2;
    }

    @Override // com.google.android.gms.internal.ads.zzgzt
    public final void zzw(List list) throws IOException {
        int iZzl;
        if ((this.zzb & 7) != 2) {
            throw new zzgyj("Protocol message tag had invalid wire type.");
        }
        do {
            list.add(zzp());
            zzgwt zzgwtVar = this.zza;
            if (zzgwtVar.zzA()) {
                return;
            } else {
                iZzl = zzgwtVar.zzl();
            }
        } while (iZzl == this.zzb);
        this.zzd = iZzl;
    }

    @Override // com.google.android.gms.internal.ads.zzgzt
    public final void zzx(List list) throws IOException {
        int iZzl;
        int iZzl2;
        if (list instanceof zzgxc) {
            zzgxc zzgxcVar = (zzgxc) list;
            int i = this.zzb & 7;
            if (i != 1) {
                if (i != 2) {
                    throw new zzgyj("Protocol message tag had invalid wire type.");
                }
                zzgwt zzgwtVar = this.zza;
                int iZzm = zzgwtVar.zzm();
                zzT(iZzm);
                int iZzc = zzgwtVar.zzc() + iZzm;
                do {
                    zzgxcVar.zzh(zzgwtVar.zza());
                } while (zzgwtVar.zzc() < iZzc);
                return;
            }
            do {
                zzgwt zzgwtVar2 = this.zza;
                zzgxcVar.zzh(zzgwtVar2.zza());
                if (zzgwtVar2.zzA()) {
                    return;
                } else {
                    iZzl2 = zzgwtVar2.zzl();
                }
            } while (iZzl2 == this.zzb);
        } else {
            int i2 = this.zzb & 7;
            if (i2 != 1) {
                if (i2 != 2) {
                    throw new zzgyj("Protocol message tag had invalid wire type.");
                }
                zzgwt zzgwtVar3 = this.zza;
                int iZzm2 = zzgwtVar3.zzm();
                zzT(iZzm2);
                int iZzc2 = zzgwtVar3.zzc() + iZzm2;
                do {
                    list.add(Double.valueOf(zzgwtVar3.zza()));
                } while (zzgwtVar3.zzc() < iZzc2);
                return;
            }
            do {
                zzgwt zzgwtVar4 = this.zza;
                list.add(Double.valueOf(zzgwtVar4.zza()));
                if (zzgwtVar4.zzA()) {
                    return;
                } else {
                    iZzl = zzgwtVar4.zzl();
                }
            } while (iZzl == this.zzb);
            iZzl2 = iZzl;
        }
        this.zzd = iZzl2;
    }

    @Override // com.google.android.gms.internal.ads.zzgzt
    public final void zzy(List list) throws IOException {
        int iZzl;
        int iZzl2;
        if (list instanceof zzgxw) {
            zzgxw zzgxwVar = (zzgxw) list;
            int i = this.zzb & 7;
            if (i != 0) {
                if (i != 2) {
                    throw new zzgyj("Protocol message tag had invalid wire type.");
                }
                zzgwt zzgwtVar = this.zza;
                int iZzc = zzgwtVar.zzc() + zzgwtVar.zzm();
                do {
                    zzgxwVar.zzi(zzgwtVar.zze());
                } while (zzgwtVar.zzc() < iZzc);
                zzQ(iZzc);
                return;
            }
            do {
                zzgwt zzgwtVar2 = this.zza;
                zzgxwVar.zzi(zzgwtVar2.zze());
                if (zzgwtVar2.zzA()) {
                    return;
                } else {
                    iZzl2 = zzgwtVar2.zzl();
                }
            } while (iZzl2 == this.zzb);
        } else {
            int i2 = this.zzb & 7;
            if (i2 != 0) {
                if (i2 != 2) {
                    throw new zzgyj("Protocol message tag had invalid wire type.");
                }
                zzgwt zzgwtVar3 = this.zza;
                int iZzc2 = zzgwtVar3.zzc() + zzgwtVar3.zzm();
                do {
                    list.add(Integer.valueOf(zzgwtVar3.zze()));
                } while (zzgwtVar3.zzc() < iZzc2);
                zzQ(iZzc2);
                return;
            }
            do {
                zzgwt zzgwtVar4 = this.zza;
                list.add(Integer.valueOf(zzgwtVar4.zze()));
                if (zzgwtVar4.zzA()) {
                    return;
                } else {
                    iZzl = zzgwtVar4.zzl();
                }
            } while (iZzl == this.zzb);
            iZzl2 = iZzl;
        }
        this.zzd = iZzl2;
    }

    @Override // com.google.android.gms.internal.ads.zzgzt
    public final void zzz(List list) throws IOException {
        int iZzl;
        int iZzl2;
        if (list instanceof zzgxw) {
            zzgxw zzgxwVar = (zzgxw) list;
            int i = this.zzb & 7;
            if (i == 2) {
                zzgwt zzgwtVar = this.zza;
                int iZzm = zzgwtVar.zzm();
                zzS(iZzm);
                int iZzc = zzgwtVar.zzc() + iZzm;
                do {
                    zzgxwVar.zzi(zzgwtVar.zzf());
                } while (zzgwtVar.zzc() < iZzc);
                return;
            }
            if (i != 5) {
                throw new zzgyj("Protocol message tag had invalid wire type.");
            }
            do {
                zzgwt zzgwtVar2 = this.zza;
                zzgxwVar.zzi(zzgwtVar2.zzf());
                if (zzgwtVar2.zzA()) {
                    return;
                } else {
                    iZzl2 = zzgwtVar2.zzl();
                }
            } while (iZzl2 == this.zzb);
        } else {
            int i2 = this.zzb & 7;
            if (i2 == 2) {
                zzgwt zzgwtVar3 = this.zza;
                int iZzm2 = zzgwtVar3.zzm();
                zzS(iZzm2);
                int iZzc2 = zzgwtVar3.zzc() + iZzm2;
                do {
                    list.add(Integer.valueOf(zzgwtVar3.zzf()));
                } while (zzgwtVar3.zzc() < iZzc2);
                return;
            }
            if (i2 != 5) {
                throw new zzgyj("Protocol message tag had invalid wire type.");
            }
            do {
                zzgwt zzgwtVar4 = this.zza;
                list.add(Integer.valueOf(zzgwtVar4.zzf()));
                if (zzgwtVar4.zzA()) {
                    return;
                } else {
                    iZzl = zzgwtVar4.zzl();
                }
            } while (iZzl == this.zzb);
            iZzl2 = iZzl;
        }
        this.zzd = iZzl2;
    }
}
