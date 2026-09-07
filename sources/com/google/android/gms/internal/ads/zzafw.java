package com.google.android.gms.internal.ads;

import java.io.IOException;
import java.io.StringReader;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlPullParserFactory;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.2.0 */
/* JADX INFO: loaded from: classes.dex */
final class zzafw {
    private static final String[] zza = {"Camera:MotionPhoto", "GCamera:MotionPhoto", "Camera:MicroVideo", "GCamera:MicroVideo"};
    private static final String[] zzb = {"Camera:MotionPhotoPresentationTimestampUs", "GCamera:MotionPhotoPresentationTimestampUs", "Camera:MicroVideoPresentationTimestampUs", "GCamera:MicroVideoPresentationTimestampUs"};
    private static final String[] zzc = {"Camera:MicroVideoOffset", "GCamera:MicroVideoOffset"};

    public static zzafs zza(String str) throws IOException {
        long j;
        try {
            XmlPullParser xmlPullParserNewPullParser = XmlPullParserFactory.newInstance().newPullParser();
            xmlPullParserNewPullParser.setInput(new StringReader(str));
            xmlPullParserNewPullParser.next();
            if (!zzev.zzc(xmlPullParserNewPullParser, "x:xmpmeta")) {
                throw zzaz.zza("Couldn't find xmp metadata", null);
            }
            zzfww zzfwwVarZzn = zzfww.zzn();
            long j2 = -9223372036854775807L;
            do {
                xmlPullParserNewPullParser.next();
                if (zzev.zzc(xmlPullParserNewPullParser, "rdf:Description")) {
                    String[] strArr = zza;
                    int i = 0;
                    for (int i2 = 0; i2 < 4; i2++) {
                        String strZza = zzev.zza(xmlPullParserNewPullParser, strArr[i2]);
                        if (strZza != null) {
                            if (Integer.parseInt(strZza) != 1) {
                                return null;
                            }
                            String[] strArr2 = zzb;
                            int i3 = 0;
                            while (true) {
                                if (i3 < 4) {
                                    String strZza2 = zzev.zza(xmlPullParserNewPullParser, strArr2[i3]);
                                    if (strZza2 != null) {
                                        j = Long.parseLong(strZza2);
                                        if (j != -1) {
                                            break;
                                        }
                                    } else {
                                        i3++;
                                    }
                                }
                                j = -9223372036854775807L;
                                break;
                            }
                            String[] strArr3 = zzc;
                            while (true) {
                                if (i >= 2) {
                                    zzfwwVarZzn = zzfww.zzn();
                                    break;
                                }
                                String strZza3 = zzev.zza(xmlPullParserNewPullParser, strArr3[i]);
                                if (strZza3 != null) {
                                    zzfwwVarZzn = zzfww.zzp(new zzafr("image/jpeg", "Primary", 0L, 0L), new zzafr("video/mp4", "MotionPhoto", Long.parseLong(strZza3), 0L));
                                    break;
                                }
                                i++;
                            }
                            j2 = j;
                        }
                    }
                    return null;
                }
                if (zzev.zzc(xmlPullParserNewPullParser, "Container:Directory")) {
                    zzfwwVarZzn = zzb(xmlPullParserNewPullParser, "Container", "Item");
                } else if (zzev.zzc(xmlPullParserNewPullParser, "GContainer:Directory")) {
                    zzfwwVarZzn = zzb(xmlPullParserNewPullParser, "GContainer", "GContainerItem");
                }
            } while (!zzev.zzb(xmlPullParserNewPullParser, "x:xmpmeta"));
            if (zzfwwVarZzn.isEmpty()) {
                return null;
            }
            return new zzafs(j2, zzfwwVarZzn);
        } catch (zzaz | NumberFormatException | XmlPullParserException unused) {
            zzdx.zzf("MotionPhotoXmpParser", "Ignoring unexpected XMP metadata");
            return null;
        }
    }

    private static zzfww zzb(XmlPullParser xmlPullParser, String str, String str2) throws XmlPullParserException, IOException {
        int i = zzfww.zzd;
        zzfwt zzfwtVar = new zzfwt();
        do {
            String strConcat = str.concat(":Item");
            xmlPullParser.next();
            if (zzev.zzc(xmlPullParser, strConcat)) {
                String strConcat2 = str2.concat(":Mime");
                String strConcat3 = str2.concat(":Semantic");
                String strConcat4 = str2.concat(":Length");
                String strConcat5 = str2.concat(":Padding");
                String strZza = zzev.zza(xmlPullParser, strConcat2);
                String strZza2 = zzev.zza(xmlPullParser, strConcat3);
                String strZza3 = zzev.zza(xmlPullParser, strConcat4);
                String strZza4 = zzev.zza(xmlPullParser, strConcat5);
                if (strZza == null || strZza2 == null) {
                    return zzfww.zzn();
                }
                zzfwtVar.zzf(new zzafr(strZza, strZza2, strZza3 != null ? Long.parseLong(strZza3) : 0L, strZza4 != null ? Long.parseLong(strZza4) : 0L));
            }
        } while (!zzev.zzb(xmlPullParser, str.concat(":Directory")));
        return zzfwtVar.zzi();
    }
}
