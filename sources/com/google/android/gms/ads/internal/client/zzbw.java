package com.google.android.gms.ads.internal.client;

import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.internal.ads.zzaxy;
import com.google.android.gms.internal.ads.zzaxz;
import com.google.android.gms.internal.ads.zzbac;
import com.google.android.gms.internal.ads.zzbad;
import com.google.android.gms.internal.ads.zzbdc;
import com.google.android.gms.internal.ads.zzbdd;
import com.google.android.gms.internal.ads.zzbtg;
import com.google.android.gms.internal.ads.zzbth;
import com.google.android.gms.internal.ads.zzbtj;
import com.google.android.gms.internal.ads.zzbtk;
import com.google.android.gms.internal.ads.zzbvp;
import com.google.android.gms.internal.ads.zzbvq;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads-api@@24.2.0 */
/* JADX INFO: loaded from: classes3.dex */
public abstract class zzbw extends zzaxy implements zzbx {
    public zzbw() {
        super("com.google.android.gms.ads.internal.client.IAdManager");
    }

    public static zzbx zzad(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.ads.internal.client.IAdManager");
        return iInterfaceQueryLocalInterface instanceof zzbx ? (zzbx) iInterfaceQueryLocalInterface : new zzbv(iBinder);
    }

    @Override // com.google.android.gms.internal.ads.zzaxy
    protected final boolean zzdD(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
        zzbk zzbiVar = null;
        zzcs zzcqVar = null;
        zzbn zzblVar = null;
        zzdq zzdoVar = null;
        zzcb zzbzVar = null;
        zzcp zzcpVar = null;
        zzbh zzbfVar = null;
        zzcl zzcjVar = null;
        switch (i) {
            case 1:
                IObjectWrapper iObjectWrapperZzn = zzn();
                parcel2.writeNoException();
                zzaxz.zzf(parcel2, iObjectWrapperZzn);
                return true;
            case 2:
                zzx();
                parcel2.writeNoException();
                return true;
            case 3:
                boolean zZzaa = zzaa();
                parcel2.writeNoException();
                int i3 = zzaxz.zza;
                parcel2.writeInt(zZzaa ? 1 : 0);
                return true;
            case 4:
                zzm zzmVar = (zzm) zzaxz.zza(parcel, zzm.CREATOR);
                zzaxz.zzc(parcel);
                boolean zZzab = zzab(zzmVar);
                parcel2.writeNoException();
                parcel2.writeInt(zZzab ? 1 : 0);
                return true;
            case 5:
                zzz();
                parcel2.writeNoException();
                return true;
            case 6:
                zzB();
                parcel2.writeNoException();
                return true;
            case 7:
                IBinder strongBinder = parcel.readStrongBinder();
                if (strongBinder != null) {
                    IInterface iInterfaceQueryLocalInterface = strongBinder.queryLocalInterface("com.google.android.gms.ads.internal.client.IAdListener");
                    zzbiVar = iInterfaceQueryLocalInterface instanceof zzbk ? (zzbk) iInterfaceQueryLocalInterface : new zzbi(strongBinder);
                }
                zzaxz.zzc(parcel);
                zzD(zzbiVar);
                parcel2.writeNoException();
                return true;
            case 8:
                IBinder strongBinder2 = parcel.readStrongBinder();
                if (strongBinder2 != null) {
                    IInterface iInterfaceQueryLocalInterface2 = strongBinder2.queryLocalInterface("com.google.android.gms.ads.internal.client.IAppEventListener");
                    zzcjVar = iInterfaceQueryLocalInterface2 instanceof zzcl ? (zzcl) iInterfaceQueryLocalInterface2 : new zzcj(strongBinder2);
                }
                zzaxz.zzc(parcel);
                zzG(zzcjVar);
                parcel2.writeNoException();
                return true;
            case 9:
                zzX();
                parcel2.writeNoException();
                return true;
            case 10:
                parcel2.writeNoException();
                return true;
            case 11:
                zzA();
                parcel2.writeNoException();
                return true;
            case 12:
                zzr zzrVarZzg = zzg();
                parcel2.writeNoException();
                zzaxz.zze(parcel2, zzrVarZzg);
                return true;
            case 13:
                zzr zzrVar = (zzr) zzaxz.zza(parcel, zzr.CREATOR);
                zzaxz.zzc(parcel);
                zzF(zzrVar);
                parcel2.writeNoException();
                return true;
            case 14:
                zzbth zzbthVarZzb = zzbtg.zzb(parcel.readStrongBinder());
                zzaxz.zzc(parcel);
                zzM(zzbthVarZzb);
                parcel2.writeNoException();
                return true;
            case 15:
                zzbtk zzbtkVarZzb = zzbtj.zzb(parcel.readStrongBinder());
                String string = parcel.readString();
                zzaxz.zzc(parcel);
                zzQ(zzbtkVarZzb, string);
                parcel2.writeNoException();
                return true;
            case 16:
            case 17:
            case 27:
            case 28:
            default:
                return false;
            case 18:
                String strZzs = zzs();
                parcel2.writeNoException();
                parcel2.writeString(strZzs);
                return true;
            case 19:
                zzbdd zzbddVarZzb = zzbdc.zzb(parcel.readStrongBinder());
                zzaxz.zzc(parcel);
                zzO(zzbddVarZzb);
                parcel2.writeNoException();
                return true;
            case 20:
                IBinder strongBinder3 = parcel.readStrongBinder();
                if (strongBinder3 != null) {
                    IInterface iInterfaceQueryLocalInterface3 = strongBinder3.queryLocalInterface("com.google.android.gms.ads.internal.client.IAdClickListener");
                    zzbfVar = iInterfaceQueryLocalInterface3 instanceof zzbh ? (zzbh) iInterfaceQueryLocalInterface3 : new zzbf(strongBinder3);
                }
                zzaxz.zzc(parcel);
                zzC(zzbfVar);
                parcel2.writeNoException();
                return true;
            case 21:
                IBinder strongBinder4 = parcel.readStrongBinder();
                if (strongBinder4 != null) {
                    IInterface iInterfaceQueryLocalInterface4 = strongBinder4.queryLocalInterface("com.google.android.gms.ads.internal.client.ICorrelationIdProvider");
                    zzcpVar = iInterfaceQueryLocalInterface4 instanceof zzcp ? (zzcp) iInterfaceQueryLocalInterface4 : new zzcp(strongBinder4);
                }
                zzaxz.zzc(parcel);
                zzac(zzcpVar);
                parcel2.writeNoException();
                return true;
            case 22:
                boolean zZzg = zzaxz.zzg(parcel);
                zzaxz.zzc(parcel);
                zzN(zZzg);
                parcel2.writeNoException();
                return true;
            case 23:
                boolean zZzZ = zzZ();
                parcel2.writeNoException();
                int i4 = zzaxz.zza;
                parcel2.writeInt(zZzZ ? 1 : 0);
                return true;
            case 24:
                zzbvq zzbvqVarZzb = zzbvp.zzb(parcel.readStrongBinder());
                zzaxz.zzc(parcel);
                zzS(zzbvqVarZzb);
                parcel2.writeNoException();
                return true;
            case 25:
                String string2 = parcel.readString();
                zzaxz.zzc(parcel);
                zzT(string2);
                parcel2.writeNoException();
                return true;
            case 26:
                zzea zzeaVarZzl = zzl();
                parcel2.writeNoException();
                zzaxz.zzf(parcel2, zzeaVarZzl);
                return true;
            case 29:
                zzfw zzfwVar = (zzfw) zzaxz.zza(parcel, zzfw.CREATOR);
                zzaxz.zzc(parcel);
                zzU(zzfwVar);
                parcel2.writeNoException();
                return true;
            case 30:
                zzee zzeeVar = (zzee) zzaxz.zza(parcel, zzee.CREATOR);
                zzaxz.zzc(parcel);
                zzK(zzeeVar);
                parcel2.writeNoException();
                return true;
            case 31:
                String strZzr = zzr();
                parcel2.writeNoException();
                parcel2.writeString(strZzr);
                return true;
            case 32:
                zzcl zzclVarZzj = zzj();
                parcel2.writeNoException();
                zzaxz.zzf(parcel2, zzclVarZzj);
                return true;
            case 33:
                zzbk zzbkVarZzi = zzi();
                parcel2.writeNoException();
                zzaxz.zzf(parcel2, zzbkVarZzi);
                return true;
            case 34:
                boolean zZzg2 = zzaxz.zzg(parcel);
                zzaxz.zzc(parcel);
                zzL(zZzg2);
                parcel2.writeNoException();
                return true;
            case 35:
                String strZzt = zzt();
                parcel2.writeNoException();
                parcel2.writeString(strZzt);
                return true;
            case 36:
                IBinder strongBinder5 = parcel.readStrongBinder();
                if (strongBinder5 != null) {
                    IInterface iInterfaceQueryLocalInterface5 = strongBinder5.queryLocalInterface("com.google.android.gms.ads.internal.client.IAdMetadataListener");
                    zzbzVar = iInterfaceQueryLocalInterface5 instanceof zzcb ? (zzcb) iInterfaceQueryLocalInterface5 : new zzbz(strongBinder5);
                }
                zzaxz.zzc(parcel);
                zzE(zzbzVar);
                parcel2.writeNoException();
                return true;
            case 37:
                Bundle bundleZzd = zzd();
                parcel2.writeNoException();
                zzaxz.zze(parcel2, bundleZzd);
                return true;
            case 38:
                String string3 = parcel.readString();
                zzaxz.zzc(parcel);
                zzR(string3);
                parcel2.writeNoException();
                return true;
            case 39:
                zzx zzxVar = (zzx) zzaxz.zza(parcel, zzx.CREATOR);
                zzaxz.zzc(parcel);
                zzI(zzxVar);
                parcel2.writeNoException();
                return true;
            case 40:
                zzbad zzbadVarZze = zzbac.zze(parcel.readStrongBinder());
                zzaxz.zzc(parcel);
                zzH(zzbadVarZze);
                parcel2.writeNoException();
                return true;
            case 41:
                zzdx zzdxVarZzk = zzk();
                parcel2.writeNoException();
                zzaxz.zzf(parcel2, zzdxVarZzk);
                return true;
            case 42:
                IBinder strongBinder6 = parcel.readStrongBinder();
                if (strongBinder6 != null) {
                    IInterface iInterfaceQueryLocalInterface6 = strongBinder6.queryLocalInterface("com.google.android.gms.ads.internal.client.IOnPaidEventListener");
                    zzdoVar = iInterfaceQueryLocalInterface6 instanceof zzdq ? (zzdq) iInterfaceQueryLocalInterface6 : new zzdo(strongBinder6);
                }
                zzaxz.zzc(parcel);
                zzP(zzdoVar);
                parcel2.writeNoException();
                return true;
            case 43:
                zzm zzmVar2 = (zzm) zzaxz.zza(parcel, zzm.CREATOR);
                IBinder strongBinder7 = parcel.readStrongBinder();
                if (strongBinder7 != null) {
                    IInterface iInterfaceQueryLocalInterface7 = strongBinder7.queryLocalInterface("com.google.android.gms.ads.internal.client.IAdLoadCallback");
                    zzblVar = iInterfaceQueryLocalInterface7 instanceof zzbn ? (zzbn) iInterfaceQueryLocalInterface7 : new zzbl(strongBinder7);
                }
                zzaxz.zzc(parcel);
                zzy(zzmVar2, zzblVar);
                parcel2.writeNoException();
                return true;
            case 44:
                IObjectWrapper iObjectWrapperAsInterface = IObjectWrapper.Stub.asInterface(parcel.readStrongBinder());
                zzaxz.zzc(parcel);
                zzW(iObjectWrapperAsInterface);
                parcel2.writeNoException();
                return true;
            case 45:
                IBinder strongBinder8 = parcel.readStrongBinder();
                if (strongBinder8 != null) {
                    IInterface iInterfaceQueryLocalInterface8 = strongBinder8.queryLocalInterface("com.google.android.gms.ads.internal.client.IFullScreenContentCallback");
                    zzcqVar = iInterfaceQueryLocalInterface8 instanceof zzcs ? (zzcs) iInterfaceQueryLocalInterface8 : new zzcq(strongBinder8);
                }
                zzaxz.zzc(parcel);
                zzJ(zzcqVar);
                parcel2.writeNoException();
                return true;
            case 46:
                boolean zZzY = zzY();
                parcel2.writeNoException();
                int i5 = zzaxz.zza;
                parcel2.writeInt(zZzY ? 1 : 0);
                return true;
        }
    }
}
