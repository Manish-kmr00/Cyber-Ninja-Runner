package com.yandex.mobile.ads.impl;

import android.net.Uri;
import com.google.common.base.Ascii;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes7.dex */
public final class uz implements a80 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final int[] f10435a = {5, 4, 12, 8, 3, 10, 9, 11, 6, 2, 0, 1, 7, 16, 15, 14};
    private static final a b = new a(new a.InterfaceC0757a() { // from class: com.yandex.mobile.ads.impl.uz$$ExternalSyntheticLambda0
        @Override // com.yandex.mobile.ads.impl.uz.a.InterfaceC0757a
        public final Constructor a() {
            return uz.b();
        }
    });
    private static final a c = new a(new a.InterfaceC0757a() { // from class: com.yandex.mobile.ads.impl.uz$$ExternalSyntheticLambda1
        @Override // com.yandex.mobile.ads.impl.uz.a.InterfaceC0757a
        public final Constructor a() {
            return uz.c();
        }
    });

    /* JADX INFO: Access modifiers changed from: private */
    static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final InterfaceC0757a f10436a;
        private final AtomicBoolean b = new AtomicBoolean(false);

        /* JADX INFO: renamed from: com.yandex.mobile.ads.impl.uz$a$a, reason: collision with other inner class name */
        public interface InterfaceC0757a {
            Constructor<? extends w70> a() throws IllegalAccessException, NoSuchMethodException, ClassNotFoundException, InvocationTargetException;
        }

        public final w70 a(Object... objArr) {
            Constructor<? extends w70> constructorA;
            synchronized (this.b) {
                try {
                    if (!this.b.get()) {
                        try {
                            constructorA = this.f10436a.a();
                        } catch (ClassNotFoundException unused) {
                            this.b.set(true);
                            constructorA = null;
                        } catch (Exception e) {
                            throw new RuntimeException("Error instantiating extension", e);
                        }
                    }
                    constructorA = null;
                } catch (Throwable th) {
                    throw th;
                }
            }
            if (constructorA == null) {
                return null;
            }
            try {
                return constructorA.newInstance(objArr);
            } catch (Exception e2) {
                throw new IllegalStateException("Unexpected error creating extractor", e2);
            }
        }

        public a(InterfaceC0757a interfaceC0757a) {
            this.f10436a = interfaceC0757a;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static Constructor<? extends w70> b() throws IllegalAccessException, NoSuchMethodException, ClassNotFoundException, InvocationTargetException {
        if (Boolean.TRUE.equals(Class.forName("com.monetization.ads.exo.ext.flac.FlacLibrary").getMethod("isAvailable", new Class[0]).invoke(null, new Object[0]))) {
            return Class.forName("com.monetization.ads.exo.ext.flac.FlacExtractor").asSubclass(w70.class).getConstructor(Integer.TYPE);
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static Constructor<? extends w70> c() throws NoSuchMethodException, ClassNotFoundException {
        return Class.forName("com.monetization.ads.exo.decoder.midi.MidiExtractor").asSubclass(w70.class).getConstructor(new Class[0]);
    }

    private static void a(int i, ArrayList arrayList) {
        switch (i) {
            case 0:
                arrayList.add(new r());
                break;
            case 1:
                arrayList.add(new u());
                break;
            case 2:
                arrayList.add(new hb());
                break;
            case 3:
                arrayList.add(new dd());
                break;
            case 4:
                w70 w70VarA = b.a(0);
                if (w70VarA == null) {
                    arrayList.add(new sb0());
                } else {
                    arrayList.add(w70VarA);
                }
                break;
            case 5:
                arrayList.add(new ac0());
                break;
            case 6:
                arrayList.add(new hu0());
                break;
            case 7:
                arrayList.add(new w11((Object) null));
                break;
            case 8:
                arrayList.add(new mc0(Collections.emptyList()));
                arrayList.add(new x11(0));
                break;
            case 9:
                arrayList.add(new wd1());
                break;
            case 10:
                arrayList.add(new um1(new i52(0L)));
                break;
            case 11:
                arrayList.add(new h72(0));
                break;
            case 12:
                arrayList.add(new dj2());
                break;
            case 14:
                arrayList.add(new oq0());
                break;
            case 15:
                w70 w70VarA2 = c.a(new Object[0]);
                if (w70VarA2 != null) {
                    arrayList.add(w70VarA2);
                }
                break;
            case 16:
                arrayList.add(new oi());
                break;
        }
    }

    @Override // com.yandex.mobile.ads.impl.a80
    public final synchronized w70[] a() {
        return a(Uri.EMPTY, new HashMap());
    }

    /* JADX WARN: Code duplicated, block: B:167:0x020b A[Catch: all -> 0x03a4, TryCatch #0 {, blocks: (B:3:0x0001, B:5:0x0017, B:8:0x001e, B:167:0x020b, B:168:0x020e, B:268:0x0384, B:271:0x038a, B:274:0x0390, B:275:0x0393, B:276:0x0396, B:171:0x0216, B:173:0x021e, B:176:0x0228, B:179:0x0232, B:181:0x023a, B:184:0x0244, B:187:0x024f, B:190:0x025b, B:193:0x0267, B:195:0x026f, B:197:0x0277, B:200:0x0281, B:202:0x028f, B:205:0x0299, B:208:0x02a4, B:210:0x02ac, B:212:0x02ba, B:214:0x02c8, B:217:0x02d8, B:219:0x02e6, B:222:0x02f0, B:224:0x02f8, B:226:0x0300, B:228:0x0308, B:231:0x0312, B:233:0x031a, B:236:0x0329, B:238:0x0331, B:241:0x033a, B:243:0x0342, B:246:0x034b, B:248:0x0353, B:251:0x035c, B:13:0x003d, B:39:0x0083, B:40:0x0087, B:147:0x01df, B:42:0x008c, B:46:0x009a, B:50:0x00a8, B:54:0x00b6, B:58:0x00c4, B:62:0x00d2, B:66:0x00e0, B:70:0x00ee, B:74:0x00fc, B:78:0x010a, B:82:0x0117, B:86:0x0125, B:90:0x0132, B:94:0x013f, B:98:0x014d, B:102:0x015a, B:106:0x0167, B:110:0x0175, B:114:0x0182, B:118:0x018f, B:122:0x019a, B:126:0x01a6, B:130:0x01b2, B:134:0x01bd, B:138:0x01c8, B:142:0x01d3, B:20:0x0053, B:24:0x005e, B:28:0x0069), top: B:282:0x0001 }] */
    /* JADX WARN: Code duplicated, block: B:170:0x0214  */
    /* JADX WARN: Code duplicated, block: B:171:0x0216 A[Catch: all -> 0x03a4, TryCatch #0 {, blocks: (B:3:0x0001, B:5:0x0017, B:8:0x001e, B:167:0x020b, B:168:0x020e, B:268:0x0384, B:271:0x038a, B:274:0x0390, B:275:0x0393, B:276:0x0396, B:171:0x0216, B:173:0x021e, B:176:0x0228, B:179:0x0232, B:181:0x023a, B:184:0x0244, B:187:0x024f, B:190:0x025b, B:193:0x0267, B:195:0x026f, B:197:0x0277, B:200:0x0281, B:202:0x028f, B:205:0x0299, B:208:0x02a4, B:210:0x02ac, B:212:0x02ba, B:214:0x02c8, B:217:0x02d8, B:219:0x02e6, B:222:0x02f0, B:224:0x02f8, B:226:0x0300, B:228:0x0308, B:231:0x0312, B:233:0x031a, B:236:0x0329, B:238:0x0331, B:241:0x033a, B:243:0x0342, B:246:0x034b, B:248:0x0353, B:251:0x035c, B:13:0x003d, B:39:0x0083, B:40:0x0087, B:147:0x01df, B:42:0x008c, B:46:0x009a, B:50:0x00a8, B:54:0x00b6, B:58:0x00c4, B:62:0x00d2, B:66:0x00e0, B:70:0x00ee, B:74:0x00fc, B:78:0x010a, B:82:0x0117, B:86:0x0125, B:90:0x0132, B:94:0x013f, B:98:0x014d, B:102:0x015a, B:106:0x0167, B:110:0x0175, B:114:0x0182, B:118:0x018f, B:122:0x019a, B:126:0x01a6, B:130:0x01b2, B:134:0x01bd, B:138:0x01c8, B:142:0x01d3, B:20:0x0053, B:24:0x005e, B:28:0x0069), top: B:282:0x0001 }] */
    /* JADX WARN: Code duplicated, block: B:265:0x037f  */
    /* JADX WARN: Code duplicated, block: B:267:0x0382 A[ADDED_TO_REGION] */
    /* JADX WARN: Code duplicated, block: B:271:0x038a A[Catch: all -> 0x03a4, TryCatch #0 {, blocks: (B:3:0x0001, B:5:0x0017, B:8:0x001e, B:167:0x020b, B:168:0x020e, B:268:0x0384, B:271:0x038a, B:274:0x0390, B:275:0x0393, B:276:0x0396, B:171:0x0216, B:173:0x021e, B:176:0x0228, B:179:0x0232, B:181:0x023a, B:184:0x0244, B:187:0x024f, B:190:0x025b, B:193:0x0267, B:195:0x026f, B:197:0x0277, B:200:0x0281, B:202:0x028f, B:205:0x0299, B:208:0x02a4, B:210:0x02ac, B:212:0x02ba, B:214:0x02c8, B:217:0x02d8, B:219:0x02e6, B:222:0x02f0, B:224:0x02f8, B:226:0x0300, B:228:0x0308, B:231:0x0312, B:233:0x031a, B:236:0x0329, B:238:0x0331, B:241:0x033a, B:243:0x0342, B:246:0x034b, B:248:0x0353, B:251:0x035c, B:13:0x003d, B:39:0x0083, B:40:0x0087, B:147:0x01df, B:42:0x008c, B:46:0x009a, B:50:0x00a8, B:54:0x00b6, B:58:0x00c4, B:62:0x00d2, B:66:0x00e0, B:70:0x00ee, B:74:0x00fc, B:78:0x010a, B:82:0x0117, B:86:0x0125, B:90:0x0132, B:94:0x013f, B:98:0x014d, B:102:0x015a, B:106:0x0167, B:110:0x0175, B:114:0x0182, B:118:0x018f, B:122:0x019a, B:126:0x01a6, B:130:0x01b2, B:134:0x01bd, B:138:0x01c8, B:142:0x01d3, B:20:0x0053, B:24:0x005e, B:28:0x0069), top: B:282:0x0001 }] */
    /* JADX WARN: Code duplicated, block: B:273:0x038e A[ADDED_TO_REGION] */
    /* JADX WARN: Code duplicated, block: B:286:0x0393 A[ADDED_TO_REGION, REMOVE, SYNTHETIC] */
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    @Override // com.yandex.mobile.ads.impl.a80
    public final synchronized w70[] a(Uri uri, Map<String, List<String>> map) {
        ArrayList arrayList;
        byte b2;
        byte b3;
        int i;
        String lastPathSegment;
        int i2;
        int i3;
        int[] iArr = f10435a;
        arrayList = new ArrayList(16);
        List<String> list = map.get("Content-Type");
        String str = (list == null || list.isEmpty()) ? null : list.get(0);
        int i4 = 1;
        if (str != null) {
            int i5 = s01.c;
            int iHashCode = str.hashCode();
            if (iHashCode != -1007807498) {
                if (iHashCode != -586683234) {
                    b2 = (iHashCode == 187090231 && str.equals("audio/mp3")) ? (byte) 2 : (byte) -1;
                } else if (str.equals("audio/x-wav")) {
                    b2 = 1;
                }
            } else if (str.equals("audio/x-flac")) {
                b2 = 0;
            }
            if (b2 == 0) {
                str = "audio/flac";
            } else if (b2 == 1) {
                str = "audio/wav";
            } else if (b2 == 2) {
                str = "audio/mpeg";
            }
            switch (str.hashCode()) {
                case -2123537834:
                    b3 = str.equals("audio/eac3-joc") ? (byte) 0 : (byte) -1;
                    break;
                case -1662384011:
                    if (str.equals("video/mp2p")) {
                        b3 = 1;
                    }
                    break;
                case -1662384007:
                    if (str.equals("video/mp2t")) {
                        b3 = 2;
                    }
                    break;
                case -1662095187:
                    if (str.equals("video/webm")) {
                        b3 = 3;
                    }
                    break;
                case -1606874997:
                    if (str.equals("audio/amr-wb")) {
                        b3 = 4;
                    }
                    break;
                case -1487394660:
                    if (str.equals("image/jpeg")) {
                        b3 = 5;
                    }
                    break;
                case -1248337486:
                    if (str.equals("application/mp4")) {
                        b3 = 6;
                    }
                    break;
                case -1079884372:
                    if (str.equals("video/x-msvideo")) {
                        b3 = 7;
                    }
                    break;
                case -1004728940:
                    if (str.equals("text/vtt")) {
                        b3 = 8;
                    }
                    break;
                case -387023398:
                    if (str.equals("audio/x-matroska")) {
                        b3 = 9;
                    }
                    break;
                case -43467528:
                    if (str.equals("application/webm")) {
                        b3 = 10;
                    }
                    break;
                case 13915911:
                    if (str.equals("video/x-flv")) {
                        b3 = 11;
                    }
                    break;
                case 187078296:
                    if (str.equals("audio/ac3")) {
                        b3 = Ascii.FF;
                    }
                    break;
                case 187078297:
                    if (str.equals("audio/ac4")) {
                        b3 = 13;
                    }
                    break;
                case 187078669:
                    if (str.equals("audio/amr")) {
                        b3 = 14;
                    }
                    break;
                case 187090232:
                    if (str.equals("audio/mp4")) {
                        b3 = Ascii.SI;
                    }
                    break;
                case 187091926:
                    if (str.equals("audio/ogg")) {
                        b3 = 16;
                    }
                    break;
                case 187099443:
                    if (str.equals("audio/wav")) {
                        b3 = 17;
                    }
                    break;
                case 1331848029:
                    if (str.equals("video/mp4")) {
                        b3 = Ascii.DC2;
                    }
                    break;
                case 1503095341:
                    if (str.equals("audio/3gpp")) {
                        b3 = 19;
                    }
                    break;
                case 1504578661:
                    if (str.equals("audio/eac3")) {
                        b3 = Ascii.DC4;
                    }
                    break;
                case 1504619009:
                    if (str.equals("audio/flac")) {
                        b3 = Ascii.NAK;
                    }
                    break;
                case 1504824762:
                    if (str.equals("audio/midi")) {
                        b3 = Ascii.SYN;
                    }
                    break;
                case 1504831518:
                    if (str.equals("audio/mpeg")) {
                        b3 = Ascii.ETB;
                    }
                    break;
                case 1505118770:
                    if (str.equals("audio/webm")) {
                        b3 = Ascii.CAN;
                    }
                    break;
                case 2039520277:
                    if (str.equals("video/x-matroska")) {
                        b3 = Ascii.EM;
                    }
                    break;
                default:
                    break;
            }
            switch (b3) {
                case 0:
                case 12:
                case 20:
                    i = 0;
                    break;
                case 1:
                    i = 10;
                    break;
                case 2:
                    i = 11;
                    break;
                case 3:
                case 9:
                case 10:
                case 24:
                case 25:
                    i = 6;
                    break;
                case 4:
                case 14:
                case 19:
                    i = 3;
                    break;
                case 5:
                    i = 14;
                    break;
                case 6:
                case 15:
                case 18:
                    i = 8;
                    break;
                case 7:
                    i = 16;
                    break;
                case 8:
                    i = 13;
                    break;
                case 11:
                    i = 5;
                    break;
                case 13:
                    i = 1;
                    break;
                case 16:
                    i = 9;
                    break;
                case 17:
                    i = 12;
                    break;
                case 21:
                    i = 4;
                    break;
                case 22:
                    i = 15;
                    break;
                case 23:
                    i = 7;
                    break;
                default:
                    break;
            }
            if (i != -1) {
                a(i, arrayList);
            }
            lastPathSegment = uri.getLastPathSegment();
            if (lastPathSegment != null) {
                if (!lastPathSegment.endsWith(".ac3") || lastPathSegment.endsWith(".ec3")) {
                    i4 = 0;
                } else if (!lastPathSegment.endsWith(".ac4")) {
                    if (lastPathSegment.endsWith(".adts") || lastPathSegment.endsWith(".aac")) {
                        i4 = 2;
                    } else if (lastPathSegment.endsWith(".amr")) {
                        i4 = 3;
                    } else if (lastPathSegment.endsWith(".flac")) {
                        i4 = 4;
                    } else if (lastPathSegment.endsWith(".flv")) {
                        i4 = 5;
                    } else if (lastPathSegment.endsWith(".mid") || lastPathSegment.endsWith(".midi") || lastPathSegment.endsWith(".smf")) {
                        i4 = 15;
                    } else if (lastPathSegment.startsWith(".mk", lastPathSegment.length() - 4) || lastPathSegment.endsWith(".webm")) {
                        i4 = 6;
                    } else if (lastPathSegment.endsWith(".mp3")) {
                        i4 = 7;
                    } else if (lastPathSegment.endsWith(".mp4") || lastPathSegment.startsWith(".m4", lastPathSegment.length() - 4) || lastPathSegment.startsWith(".mp4", lastPathSegment.length() - 5) || lastPathSegment.startsWith(".cmf", lastPathSegment.length() - 5)) {
                        i4 = 8;
                    } else if (lastPathSegment.startsWith(".og", lastPathSegment.length() - 4) || lastPathSegment.endsWith(".opus")) {
                        i4 = 9;
                    } else if (lastPathSegment.endsWith(".ps") || lastPathSegment.endsWith(".mpeg") || lastPathSegment.endsWith(".mpg") || lastPathSegment.endsWith(".m2p")) {
                        i4 = 10;
                    } else if (lastPathSegment.endsWith(".ts") || lastPathSegment.startsWith(".ts", lastPathSegment.length() - 4)) {
                        i4 = 11;
                    } else if (lastPathSegment.endsWith(".wav") || lastPathSegment.endsWith(".wave")) {
                        i4 = 12;
                    } else if (lastPathSegment.endsWith(".vtt") || lastPathSegment.endsWith(".webvtt")) {
                        i4 = 13;
                    } else if (lastPathSegment.endsWith(".jpg") || lastPathSegment.endsWith(".jpeg")) {
                        i4 = 14;
                    } else if (lastPathSegment.endsWith(".avi")) {
                        i4 = 16;
                    }
                }
                if (i4 != -1 && i4 != i) {
                    a(i4, arrayList);
                }
                for (i2 = 0; i2 < 16; i2++) {
                    i3 = iArr[i2];
                    if (i3 == i && i3 != i4) {
                        a(i3, arrayList);
                    }
                }
            }
            i4 = -1;
            if (i4 != -1) {
                a(i4, arrayList);
            }
            while (i2 < 16) {
                i3 = iArr[i2];
                if (i3 == i) {
                }
            }
        }
        i = -1;
        if (i != -1) {
            a(i, arrayList);
        }
        lastPathSegment = uri.getLastPathSegment();
        if (lastPathSegment != null) {
            if (lastPathSegment.endsWith(".ac3")) {
                i4 = 0;
            } else {
                i4 = 0;
            }
            if (i4 != -1) {
                a(i4, arrayList);
            }
            while (i2 < 16) {
                i3 = iArr[i2];
                if (i3 == i) {
                }
            }
        }
        i4 = -1;
        if (i4 != -1) {
            a(i4, arrayList);
        }
        while (i2 < 16) {
            i3 = iArr[i2];
            if (i3 == i) {
            }
        }
        return (w70[]) arrayList.toArray(new w70[arrayList.size()]);
    }
}
