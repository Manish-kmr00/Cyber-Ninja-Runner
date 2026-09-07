package com.google.android.gms.internal.ads;

import java.util.Objects;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.2.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzajt implements zzajy {
    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code duplicated, block: B:34:0x0069  */
    @Override // com.google.android.gms.internal.ads.zzajy
    public final int zza(zzz zzzVar) {
        String str = zzzVar.zzo;
        if (str != null) {
            switch (str) {
                case "text/x-ssa":
                case "text/vtt":
                    return 1;
                case "application/x-mp4-vtt":
                    return 2;
                case "application/x-subrip":
                    return 1;
                case "application/x-quicktime-tx3g":
                case "application/pgs":
                case "application/vobsub":
                case "application/dvbsubs":
                    return 2;
                case "application/ttml+xml":
                    return 1;
            }
        }
        throw new IllegalArgumentException("Unsupported MIME type: ".concat(String.valueOf(str)));
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code duplicated, block: B:34:0x0067  */
    @Override // com.google.android.gms.internal.ads.zzajy
    public final zzaka zzb(zzz zzzVar) {
        String str = zzzVar.zzo;
        if (str != null) {
            switch (str) {
                case "text/x-ssa":
                    return new zzakq(zzzVar.zzr);
                case "text/vtt":
                    return new zzalt();
                case "application/x-mp4-vtt":
                    return new zzali();
                case "application/x-subrip":
                    return new zzaku();
                case "application/x-quicktime-tx3g":
                    return new zzalf(zzzVar.zzr);
                case "application/pgs":
                    return new zzako();
                case "application/vobsub":
                    return new zzalh(zzzVar.zzr);
                case "application/dvbsubs":
                    return new zzakm(zzzVar.zzr);
                case "application/ttml+xml":
                    return new zzala();
            }
        }
        throw new IllegalArgumentException("Unsupported MIME type: ".concat(String.valueOf(str)));
    }

    @Override // com.google.android.gms.internal.ads.zzajy
    public final boolean zzc(zzz zzzVar) {
        String str = zzzVar.zzo;
        return Objects.equals(str, "text/x-ssa") || Objects.equals(str, "text/vtt") || Objects.equals(str, "application/x-mp4-vtt") || Objects.equals(str, "application/x-subrip") || Objects.equals(str, "application/x-quicktime-tx3g") || Objects.equals(str, "application/pgs") || Objects.equals(str, "application/vobsub") || Objects.equals(str, "application/dvbsubs") || Objects.equals(str, "application/ttml+xml");
    }
}
