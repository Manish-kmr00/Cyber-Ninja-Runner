package com.google.android.gms.ads.internal.client;

import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.internal.ads.zzaxy;
import com.google.android.gms.internal.ads.zzaxz;
import com.google.android.gms.internal.ads.zzbfx;
import com.google.android.gms.internal.ads.zzbgd;
import com.google.android.gms.internal.ads.zzbkh;
import com.google.android.gms.internal.ads.zzbki;
import com.google.android.gms.internal.ads.zzbkl;
import com.google.android.gms.internal.ads.zzbox;
import com.google.android.gms.internal.ads.zzboy;
import com.google.android.gms.internal.ads.zzbsr;
import com.google.android.gms.internal.ads.zzbsy;
import com.google.android.gms.internal.ads.zzbvn;
import com.google.android.gms.internal.ads.zzbwd;
import com.google.android.gms.internal.ads.zzbyi;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads-api@@24.2.0 */
/* JADX INFO: loaded from: classes3.dex */
public abstract class zzcn extends zzaxy implements zzco {
    public zzcn() {
        super("com.google.android.gms.ads.internal.client.IClientApi");
    }

    @Override // com.google.android.gms.internal.ads.zzaxy
    protected final boolean zzdD(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
        switch (i) {
            case 1:
                IObjectWrapper iObjectWrapperAsInterface = IObjectWrapper.Stub.asInterface(parcel.readStrongBinder());
                zzr zzrVar = (zzr) zzaxz.zza(parcel, zzr.CREATOR);
                String string = parcel.readString();
                zzboy zzboyVarZzf = zzbox.zzf(parcel.readStrongBinder());
                int i3 = parcel.readInt();
                zzaxz.zzc(parcel);
                zzbx zzbxVarZzd = zzd(iObjectWrapperAsInterface, zzrVar, string, zzboyVarZzf, i3);
                parcel2.writeNoException();
                zzaxz.zzf(parcel2, zzbxVarZzd);
                return true;
            case 2:
                IObjectWrapper iObjectWrapperAsInterface2 = IObjectWrapper.Stub.asInterface(parcel.readStrongBinder());
                zzr zzrVar2 = (zzr) zzaxz.zza(parcel, zzr.CREATOR);
                String string2 = parcel.readString();
                zzboy zzboyVarZzf2 = zzbox.zzf(parcel.readStrongBinder());
                int i4 = parcel.readInt();
                zzaxz.zzc(parcel);
                zzbx zzbxVarZze = zze(iObjectWrapperAsInterface2, zzrVar2, string2, zzboyVarZzf2, i4);
                parcel2.writeNoException();
                zzaxz.zzf(parcel2, zzbxVarZze);
                return true;
            case 3:
                IObjectWrapper iObjectWrapperAsInterface3 = IObjectWrapper.Stub.asInterface(parcel.readStrongBinder());
                String string3 = parcel.readString();
                zzboy zzboyVarZzf3 = zzbox.zzf(parcel.readStrongBinder());
                int i5 = parcel.readInt();
                zzaxz.zzc(parcel);
                zzbt zzbtVarZzb = zzb(iObjectWrapperAsInterface3, string3, zzboyVarZzf3, i5);
                parcel2.writeNoException();
                zzaxz.zzf(parcel2, zzbtVarZzb);
                return true;
            case 4:
                IObjectWrapper.Stub.asInterface(parcel.readStrongBinder());
                zzaxz.zzc(parcel);
                parcel2.writeNoException();
                zzaxz.zzf(parcel2, null);
                return true;
            case 5:
                IObjectWrapper iObjectWrapperAsInterface4 = IObjectWrapper.Stub.asInterface(parcel.readStrongBinder());
                IObjectWrapper iObjectWrapperAsInterface5 = IObjectWrapper.Stub.asInterface(parcel.readStrongBinder());
                zzaxz.zzc(parcel);
                zzbfx zzbfxVarZzj = zzj(iObjectWrapperAsInterface4, iObjectWrapperAsInterface5);
                parcel2.writeNoException();
                zzaxz.zzf(parcel2, zzbfxVarZzj);
                return true;
            case 6:
                IObjectWrapper iObjectWrapperAsInterface6 = IObjectWrapper.Stub.asInterface(parcel.readStrongBinder());
                zzboy zzboyVarZzf4 = zzbox.zzf(parcel.readStrongBinder());
                int i6 = parcel.readInt();
                zzaxz.zzc(parcel);
                zzbvn zzbvnVarZzo = zzo(iObjectWrapperAsInterface6, zzboyVarZzf4, i6);
                parcel2.writeNoException();
                zzaxz.zzf(parcel2, zzbvnVarZzo);
                return true;
            case 7:
                IObjectWrapper.Stub.asInterface(parcel.readStrongBinder());
                zzaxz.zzc(parcel);
                parcel2.writeNoException();
                zzaxz.zzf(parcel2, null);
                return true;
            case 8:
                IObjectWrapper iObjectWrapperAsInterface7 = IObjectWrapper.Stub.asInterface(parcel.readStrongBinder());
                zzaxz.zzc(parcel);
                zzbsy zzbsyVarZzn = zzn(iObjectWrapperAsInterface7);
                parcel2.writeNoException();
                zzaxz.zzf(parcel2, zzbsyVarZzn);
                return true;
            case 9:
                IObjectWrapper iObjectWrapperAsInterface8 = IObjectWrapper.Stub.asInterface(parcel.readStrongBinder());
                int i7 = parcel.readInt();
                zzaxz.zzc(parcel);
                zzcy zzcyVarZzh = zzh(iObjectWrapperAsInterface8, i7);
                parcel2.writeNoException();
                zzaxz.zzf(parcel2, zzcyVarZzh);
                return true;
            case 10:
                IObjectWrapper iObjectWrapperAsInterface9 = IObjectWrapper.Stub.asInterface(parcel.readStrongBinder());
                zzr zzrVar3 = (zzr) zzaxz.zza(parcel, zzr.CREATOR);
                String string4 = parcel.readString();
                int i8 = parcel.readInt();
                zzaxz.zzc(parcel);
                zzbx zzbxVarZzf = zzf(iObjectWrapperAsInterface9, zzrVar3, string4, i8);
                parcel2.writeNoException();
                zzaxz.zzf(parcel2, zzbxVarZzf);
                return true;
            case 11:
                IObjectWrapper iObjectWrapperAsInterface10 = IObjectWrapper.Stub.asInterface(parcel.readStrongBinder());
                IObjectWrapper iObjectWrapperAsInterface11 = IObjectWrapper.Stub.asInterface(parcel.readStrongBinder());
                IObjectWrapper iObjectWrapperAsInterface12 = IObjectWrapper.Stub.asInterface(parcel.readStrongBinder());
                zzaxz.zzc(parcel);
                zzbgd zzbgdVarZzk = zzk(iObjectWrapperAsInterface10, iObjectWrapperAsInterface11, iObjectWrapperAsInterface12);
                parcel2.writeNoException();
                zzaxz.zzf(parcel2, zzbgdVarZzk);
                return true;
            case 12:
                IObjectWrapper iObjectWrapperAsInterface13 = IObjectWrapper.Stub.asInterface(parcel.readStrongBinder());
                String string5 = parcel.readString();
                zzboy zzboyVarZzf5 = zzbox.zzf(parcel.readStrongBinder());
                int i9 = parcel.readInt();
                zzaxz.zzc(parcel);
                zzbwd zzbwdVarZzp = zzp(iObjectWrapperAsInterface13, string5, zzboyVarZzf5, i9);
                parcel2.writeNoException();
                zzaxz.zzf(parcel2, zzbwdVarZzp);
                return true;
            case 13:
                IObjectWrapper iObjectWrapperAsInterface14 = IObjectWrapper.Stub.asInterface(parcel.readStrongBinder());
                zzr zzrVar4 = (zzr) zzaxz.zza(parcel, zzr.CREATOR);
                String string6 = parcel.readString();
                zzboy zzboyVarZzf6 = zzbox.zzf(parcel.readStrongBinder());
                int i10 = parcel.readInt();
                zzaxz.zzc(parcel);
                zzbx zzbxVarZzc = zzc(iObjectWrapperAsInterface14, zzrVar4, string6, zzboyVarZzf6, i10);
                parcel2.writeNoException();
                zzaxz.zzf(parcel2, zzbxVarZzc);
                return true;
            case 14:
                IObjectWrapper iObjectWrapperAsInterface15 = IObjectWrapper.Stub.asInterface(parcel.readStrongBinder());
                zzboy zzboyVarZzf7 = zzbox.zzf(parcel.readStrongBinder());
                int i11 = parcel.readInt();
                zzaxz.zzc(parcel);
                zzbyi zzbyiVarZzq = zzq(iObjectWrapperAsInterface15, zzboyVarZzf7, i11);
                parcel2.writeNoException();
                zzaxz.zzf(parcel2, zzbyiVarZzq);
                return true;
            case 15:
                IObjectWrapper iObjectWrapperAsInterface16 = IObjectWrapper.Stub.asInterface(parcel.readStrongBinder());
                zzboy zzboyVarZzf8 = zzbox.zzf(parcel.readStrongBinder());
                int i12 = parcel.readInt();
                zzaxz.zzc(parcel);
                zzbsr zzbsrVarZzm = zzm(iObjectWrapperAsInterface16, zzboyVarZzf8, i12);
                parcel2.writeNoException();
                zzaxz.zzf(parcel2, zzbsrVarZzm);
                return true;
            case 16:
                IObjectWrapper iObjectWrapperAsInterface17 = IObjectWrapper.Stub.asInterface(parcel.readStrongBinder());
                zzboy zzboyVarZzf9 = zzbox.zzf(parcel.readStrongBinder());
                int i13 = parcel.readInt();
                zzbki zzbkiVarZzc = zzbkh.zzc(parcel.readStrongBinder());
                zzaxz.zzc(parcel);
                zzbkl zzbklVarZzl = zzl(iObjectWrapperAsInterface17, zzboyVarZzf9, i13, zzbkiVarZzc);
                parcel2.writeNoException();
                zzaxz.zzf(parcel2, zzbklVarZzl);
                return true;
            case 17:
                IObjectWrapper iObjectWrapperAsInterface18 = IObjectWrapper.Stub.asInterface(parcel.readStrongBinder());
                zzboy zzboyVarZzf10 = zzbox.zzf(parcel.readStrongBinder());
                int i14 = parcel.readInt();
                zzaxz.zzc(parcel);
                zzdt zzdtVarZzi = zzi(iObjectWrapperAsInterface18, zzboyVarZzf10, i14);
                parcel2.writeNoException();
                zzaxz.zzf(parcel2, zzdtVarZzi);
                return true;
            case 18:
                IObjectWrapper iObjectWrapperAsInterface19 = IObjectWrapper.Stub.asInterface(parcel.readStrongBinder());
                zzboy zzboyVarZzf11 = zzbox.zzf(parcel.readStrongBinder());
                int i15 = parcel.readInt();
                zzaxz.zzc(parcel);
                zzch zzchVarZzg = zzg(iObjectWrapperAsInterface19, zzboyVarZzf11, i15);
                parcel2.writeNoException();
                zzaxz.zzf(parcel2, zzchVarZzg);
                return true;
            default:
                return false;
        }
    }
}
