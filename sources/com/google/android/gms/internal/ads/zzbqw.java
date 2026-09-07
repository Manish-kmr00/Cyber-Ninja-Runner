package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads-api@@24.2.0 */
/* JADX INFO: loaded from: classes9.dex */
public abstract class zzbqw extends zzaxy implements zzbqx {
    public zzbqw() {
        super("com.google.android.gms.ads.internal.mediation.client.rtb.IRtbAdapter");
    }

    public static zzbqx zzb(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.ads.internal.mediation.client.rtb.IRtbAdapter");
        return iInterfaceQueryLocalInterface instanceof zzbqx ? (zzbqx) iInterfaceQueryLocalInterface : new zzbqv(iBinder);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r11v1, types: [com.google.android.gms.internal.ads.zzbra] */
    /* JADX WARN: Type inference failed for: r11v4, types: [com.google.android.gms.internal.ads.zzbqu] */
    /* JADX WARN: Type inference failed for: r11v5, types: [com.google.android.gms.internal.ads.zzbqr] */
    /* JADX WARN: Type inference failed for: r11v6, types: [com.google.android.gms.internal.ads.zzbqu] */
    /* JADX WARN: Type inference failed for: r11v8, types: [com.google.android.gms.internal.ads.zzbqr] */
    /* JADX WARN: Type inference failed for: r14v0, types: [com.google.android.gms.internal.ads.zzbqw] */
    /* JADX WARN: Type inference failed for: r5v16, types: [com.google.android.gms.internal.ads.zzbql] */
    /* JADX WARN: Type inference failed for: r5v5, types: [com.google.android.gms.internal.ads.zzbql] */
    /* JADX WARN: Type inference failed for: r7v14, types: [com.google.android.gms.internal.ads.zzbqi] */
    /* JADX WARN: Type inference failed for: r7v5, types: [com.google.android.gms.internal.ads.zzbqo] */
    @Override // com.google.android.gms.internal.ads.zzaxy
    protected final boolean zzdD(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
        IInterface zzbqgVar = null;
        if (i == 1) {
            IObjectWrapper iObjectWrapperAsInterface = IObjectWrapper.Stub.asInterface(parcel.readStrongBinder());
            String string = parcel.readString();
            Bundle bundle = (Bundle) zzaxz.zza(parcel, Bundle.CREATOR);
            Bundle bundle2 = (Bundle) zzaxz.zza(parcel, Bundle.CREATOR);
            com.google.android.gms.ads.internal.client.zzr zzrVar = (com.google.android.gms.ads.internal.client.zzr) zzaxz.zza(parcel, com.google.android.gms.ads.internal.client.zzr.CREATOR);
            IBinder strongBinder = parcel.readStrongBinder();
            if (strongBinder != null) {
                IInterface iInterfaceQueryLocalInterface = strongBinder.queryLocalInterface("com.google.android.gms.ads.internal.mediation.client.rtb.ISignalsCallback");
                zzbqgVar = iInterfaceQueryLocalInterface instanceof zzbra ? (zzbra) iInterfaceQueryLocalInterface : new zzbqy(strongBinder);
            }
            ?? r11 = zzbqgVar;
            zzaxz.zzc(parcel);
            zzh(iObjectWrapperAsInterface, string, bundle, bundle2, zzrVar, r11);
            parcel2.writeNoException();
        } else if (i == 2) {
            zzbrm zzbrmVarZzf = zzf();
            parcel2.writeNoException();
            zzaxz.zze(parcel2, zzbrmVarZzf);
        } else if (i == 3) {
            zzbrm zzbrmVarZzg = zzg();
            parcel2.writeNoException();
            zzaxz.zze(parcel2, zzbrmVarZzg);
        } else if (i == 5) {
            com.google.android.gms.ads.internal.client.zzea zzeaVarZze = zze();
            parcel2.writeNoException();
            zzaxz.zzf(parcel2, zzeaVarZze);
        } else if (i == 10) {
            IObjectWrapper.Stub.asInterface(parcel.readStrongBinder());
            zzaxz.zzc(parcel);
            parcel2.writeNoException();
        } else if (i != 11) {
            switch (i) {
                case 13:
                    String string2 = parcel.readString();
                    String string3 = parcel.readString();
                    com.google.android.gms.ads.internal.client.zzm zzmVar = (com.google.android.gms.ads.internal.client.zzm) zzaxz.zza(parcel, com.google.android.gms.ads.internal.client.zzm.CREATOR);
                    IObjectWrapper iObjectWrapperAsInterface2 = IObjectWrapper.Stub.asInterface(parcel.readStrongBinder());
                    IBinder strongBinder2 = parcel.readStrongBinder();
                    if (strongBinder2 != null) {
                        IInterface iInterfaceQueryLocalInterface2 = strongBinder2.queryLocalInterface("com.google.android.gms.ads.internal.mediation.client.rtb.IBannerCallback");
                        zzbqgVar = iInterfaceQueryLocalInterface2 instanceof zzbql ? (zzbql) iInterfaceQueryLocalInterface2 : new zzbqj(strongBinder2);
                    }
                    ?? r5 = zzbqgVar;
                    zzbpe zzbpeVarZzb = zzbpd.zzb(parcel.readStrongBinder());
                    com.google.android.gms.ads.internal.client.zzr zzrVar2 = (com.google.android.gms.ads.internal.client.zzr) zzaxz.zza(parcel, com.google.android.gms.ads.internal.client.zzr.CREATOR);
                    zzaxz.zzc(parcel);
                    zzj(string2, string3, zzmVar, iObjectWrapperAsInterface2, r5, zzbpeVarZzb, zzrVar2);
                    parcel2.writeNoException();
                    break;
                case 14:
                    String string4 = parcel.readString();
                    String string5 = parcel.readString();
                    com.google.android.gms.ads.internal.client.zzm zzmVar2 = (com.google.android.gms.ads.internal.client.zzm) zzaxz.zza(parcel, com.google.android.gms.ads.internal.client.zzm.CREATOR);
                    IObjectWrapper iObjectWrapperAsInterface3 = IObjectWrapper.Stub.asInterface(parcel.readStrongBinder());
                    IBinder strongBinder3 = parcel.readStrongBinder();
                    if (strongBinder3 != null) {
                        IInterface iInterfaceQueryLocalInterface3 = strongBinder3.queryLocalInterface("com.google.android.gms.ads.internal.mediation.client.rtb.IInterstitialCallback");
                        zzbqgVar = iInterfaceQueryLocalInterface3 instanceof zzbqo ? (zzbqo) iInterfaceQueryLocalInterface3 : new zzbqm(strongBinder3);
                    }
                    ?? r7 = zzbqgVar;
                    zzbpe zzbpeVarZzb2 = zzbpd.zzb(parcel.readStrongBinder());
                    zzaxz.zzc(parcel);
                    zzl(string4, string5, zzmVar2, iObjectWrapperAsInterface3, r7, zzbpeVarZzb2);
                    parcel2.writeNoException();
                    break;
                case 15:
                    IObjectWrapper iObjectWrapperAsInterface4 = IObjectWrapper.Stub.asInterface(parcel.readStrongBinder());
                    zzaxz.zzc(parcel);
                    boolean zZzs = zzs(iObjectWrapperAsInterface4);
                    parcel2.writeNoException();
                    parcel2.writeInt(zZzs ? 1 : 0);
                    break;
                case 16:
                    String string6 = parcel.readString();
                    String string7 = parcel.readString();
                    com.google.android.gms.ads.internal.client.zzm zzmVar3 = (com.google.android.gms.ads.internal.client.zzm) zzaxz.zza(parcel, com.google.android.gms.ads.internal.client.zzm.CREATOR);
                    IObjectWrapper iObjectWrapperAsInterface5 = IObjectWrapper.Stub.asInterface(parcel.readStrongBinder());
                    IBinder strongBinder4 = parcel.readStrongBinder();
                    if (strongBinder4 != null) {
                        IInterface iInterfaceQueryLocalInterface4 = strongBinder4.queryLocalInterface("com.google.android.gms.ads.internal.mediation.client.rtb.IRewardedCallback");
                        zzbqgVar = iInterfaceQueryLocalInterface4 instanceof zzbqu ? (zzbqu) iInterfaceQueryLocalInterface4 : new zzbqs(strongBinder4);
                    }
                    ?? r12 = zzbqgVar;
                    zzbpe zzbpeVarZzb3 = zzbpd.zzb(parcel.readStrongBinder());
                    zzaxz.zzc(parcel);
                    zzp(string6, string7, zzmVar3, iObjectWrapperAsInterface5, r12, zzbpeVarZzb3);
                    parcel2.writeNoException();
                    break;
                case 17:
                    IObjectWrapper iObjectWrapperAsInterface6 = IObjectWrapper.Stub.asInterface(parcel.readStrongBinder());
                    zzaxz.zzc(parcel);
                    boolean zZzt = zzt(iObjectWrapperAsInterface6);
                    parcel2.writeNoException();
                    parcel2.writeInt(zZzt ? 1 : 0);
                    break;
                case 18:
                    String string8 = parcel.readString();
                    String string9 = parcel.readString();
                    com.google.android.gms.ads.internal.client.zzm zzmVar4 = (com.google.android.gms.ads.internal.client.zzm) zzaxz.zza(parcel, com.google.android.gms.ads.internal.client.zzm.CREATOR);
                    IObjectWrapper iObjectWrapperAsInterface7 = IObjectWrapper.Stub.asInterface(parcel.readStrongBinder());
                    IBinder strongBinder5 = parcel.readStrongBinder();
                    if (strongBinder5 != null) {
                        IInterface iInterfaceQueryLocalInterface5 = strongBinder5.queryLocalInterface("com.google.android.gms.ads.internal.mediation.client.rtb.INativeCallback");
                        zzbqgVar = iInterfaceQueryLocalInterface5 instanceof zzbqr ? (zzbqr) iInterfaceQueryLocalInterface5 : new zzbqp(strongBinder5);
                    }
                    ?? r13 = zzbqgVar;
                    zzbpe zzbpeVarZzb4 = zzbpd.zzb(parcel.readStrongBinder());
                    zzaxz.zzc(parcel);
                    zzm(string8, string9, zzmVar4, iObjectWrapperAsInterface7, r13, zzbpeVarZzb4);
                    parcel2.writeNoException();
                    break;
                case 19:
                    String string10 = parcel.readString();
                    zzaxz.zzc(parcel);
                    zzq(string10);
                    parcel2.writeNoException();
                    break;
                case 20:
                    String string11 = parcel.readString();
                    String string12 = parcel.readString();
                    com.google.android.gms.ads.internal.client.zzm zzmVar5 = (com.google.android.gms.ads.internal.client.zzm) zzaxz.zza(parcel, com.google.android.gms.ads.internal.client.zzm.CREATOR);
                    IObjectWrapper iObjectWrapperAsInterface8 = IObjectWrapper.Stub.asInterface(parcel.readStrongBinder());
                    IBinder strongBinder6 = parcel.readStrongBinder();
                    if (strongBinder6 != null) {
                        IInterface iInterfaceQueryLocalInterface6 = strongBinder6.queryLocalInterface("com.google.android.gms.ads.internal.mediation.client.rtb.IRewardedCallback");
                        zzbqgVar = iInterfaceQueryLocalInterface6 instanceof zzbqu ? (zzbqu) iInterfaceQueryLocalInterface6 : new zzbqs(strongBinder6);
                    }
                    ?? r14 = zzbqgVar;
                    zzbpe zzbpeVarZzb5 = zzbpd.zzb(parcel.readStrongBinder());
                    zzaxz.zzc(parcel);
                    zzo(string11, string12, zzmVar5, iObjectWrapperAsInterface8, r14, zzbpeVarZzb5);
                    parcel2.writeNoException();
                    break;
                case 21:
                    String string13 = parcel.readString();
                    String string14 = parcel.readString();
                    com.google.android.gms.ads.internal.client.zzm zzmVar6 = (com.google.android.gms.ads.internal.client.zzm) zzaxz.zza(parcel, com.google.android.gms.ads.internal.client.zzm.CREATOR);
                    IObjectWrapper iObjectWrapperAsInterface9 = IObjectWrapper.Stub.asInterface(parcel.readStrongBinder());
                    IBinder strongBinder7 = parcel.readStrongBinder();
                    if (strongBinder7 != null) {
                        IInterface iInterfaceQueryLocalInterface7 = strongBinder7.queryLocalInterface("com.google.android.gms.ads.internal.mediation.client.rtb.IBannerCallback");
                        zzbqgVar = iInterfaceQueryLocalInterface7 instanceof zzbql ? (zzbql) iInterfaceQueryLocalInterface7 : new zzbqj(strongBinder7);
                    }
                    ?? r6 = zzbqgVar;
                    zzbpe zzbpeVarZzb6 = zzbpd.zzb(parcel.readStrongBinder());
                    com.google.android.gms.ads.internal.client.zzr zzrVar3 = (com.google.android.gms.ads.internal.client.zzr) zzaxz.zza(parcel, com.google.android.gms.ads.internal.client.zzr.CREATOR);
                    zzaxz.zzc(parcel);
                    zzk(string13, string14, zzmVar6, iObjectWrapperAsInterface9, r6, zzbpeVarZzb6, zzrVar3);
                    parcel2.writeNoException();
                    break;
                case 22:
                    String string15 = parcel.readString();
                    String string16 = parcel.readString();
                    com.google.android.gms.ads.internal.client.zzm zzmVar7 = (com.google.android.gms.ads.internal.client.zzm) zzaxz.zza(parcel, com.google.android.gms.ads.internal.client.zzm.CREATOR);
                    IObjectWrapper iObjectWrapperAsInterface10 = IObjectWrapper.Stub.asInterface(parcel.readStrongBinder());
                    IBinder strongBinder8 = parcel.readStrongBinder();
                    if (strongBinder8 != null) {
                        IInterface iInterfaceQueryLocalInterface8 = strongBinder8.queryLocalInterface("com.google.android.gms.ads.internal.mediation.client.rtb.INativeCallback");
                        zzbqgVar = iInterfaceQueryLocalInterface8 instanceof zzbqr ? (zzbqr) iInterfaceQueryLocalInterface8 : new zzbqp(strongBinder8);
                    }
                    ?? r15 = zzbqgVar;
                    zzbpe zzbpeVarZzb7 = zzbpd.zzb(parcel.readStrongBinder());
                    zzbfi zzbfiVar = (zzbfi) zzaxz.zza(parcel, zzbfi.CREATOR);
                    zzaxz.zzc(parcel);
                    zzn(string15, string16, zzmVar7, iObjectWrapperAsInterface10, r15, zzbpeVarZzb7, zzbfiVar);
                    parcel2.writeNoException();
                    break;
                case 23:
                    String string17 = parcel.readString();
                    String string18 = parcel.readString();
                    com.google.android.gms.ads.internal.client.zzm zzmVar8 = (com.google.android.gms.ads.internal.client.zzm) zzaxz.zza(parcel, com.google.android.gms.ads.internal.client.zzm.CREATOR);
                    IObjectWrapper iObjectWrapperAsInterface11 = IObjectWrapper.Stub.asInterface(parcel.readStrongBinder());
                    IBinder strongBinder9 = parcel.readStrongBinder();
                    if (strongBinder9 != null) {
                        IInterface iInterfaceQueryLocalInterface9 = strongBinder9.queryLocalInterface("com.google.android.gms.ads.internal.mediation.client.rtb.IAppOpenCallback");
                        zzbqgVar = iInterfaceQueryLocalInterface9 instanceof zzbqi ? (zzbqi) iInterfaceQueryLocalInterface9 : new zzbqg(strongBinder9);
                    }
                    ?? r8 = zzbqgVar;
                    zzbpe zzbpeVarZzb8 = zzbpd.zzb(parcel.readStrongBinder());
                    zzaxz.zzc(parcel);
                    zzi(string17, string18, zzmVar8, iObjectWrapperAsInterface11, r8, zzbpeVarZzb8);
                    parcel2.writeNoException();
                    break;
                case 24:
                    IObjectWrapper iObjectWrapperAsInterface12 = IObjectWrapper.Stub.asInterface(parcel.readStrongBinder());
                    zzaxz.zzc(parcel);
                    boolean zZzr = zzr(iObjectWrapperAsInterface12);
                    parcel2.writeNoException();
                    parcel2.writeInt(zZzr ? 1 : 0);
                    break;
                default:
                    return false;
            }
        } else {
            parcel.createStringArray();
            zzaxz.zzc(parcel);
            parcel2.writeNoException();
        }
        return true;
    }
}
