package sg.bigo.ads.core.e.a;

import android.content.Context;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.atomic.AtomicBoolean;
import sg.bigo.ads.api.core.r;
import sg.bigo.ads.common.k;
import sg.bigo.ads.common.utils.p;

/* JADX INFO: loaded from: classes7.dex */
public final class c {
    private static boolean f;
    private static final c g = new c();
    public r c;
    public k d;
    public Context e;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Set<e> f13565a = p.a(50);
    public final AtomicBoolean b = new AtomicBoolean(false);
    private final Runnable h = new Runnable() { // from class: sg.bigo.ads.core.e.a.c.2
        /* JADX WARN: Code duplicated, block: B:104:0x02b3 A[SYNTHETIC] */
        /* JADX WARN: Code duplicated, block: B:106:0x02a9 A[SYNTHETIC] */
        /* JADX WARN: Code duplicated, block: B:22:0x00b8  */
        /* JADX WARN: Code duplicated, block: B:24:0x00bd  */
        /* JADX WARN: Code duplicated, block: B:25:0x00c0  */
        /* JADX WARN: Code duplicated, block: B:27:0x00c8  */
        /* JADX WARN: Code duplicated, block: B:28:0x00da  */
        /* JADX WARN: Code duplicated, block: B:31:0x00f0  */
        /* JADX WARN: Code duplicated, block: B:33:0x00fe  */
        /* JADX WARN: Code duplicated, block: B:34:0x0101  */
        /* JADX WARN: Code duplicated, block: B:42:0x0140  */
        /* JADX WARN: Code duplicated, block: B:44:0x0145  */
        /* JADX WARN: Code duplicated, block: B:45:0x014a  */
        /* JADX WARN: Code duplicated, block: B:47:0x0152  */
        /* JADX WARN: Code duplicated, block: B:48:0x0164  */
        /* JADX WARN: Code duplicated, block: B:51:0x017a  */
        /* JADX WARN: Code duplicated, block: B:53:0x018a  */
        /* JADX WARN: Code duplicated, block: B:54:0x0191  */
        /* JADX WARN: Code duplicated, block: B:56:0x01a3  */
        /* JADX WARN: Code duplicated, block: B:62:0x01d1  */
        /* JADX WARN: Code duplicated, block: B:64:0x01d8  */
        /* JADX WARN: Code duplicated, block: B:66:0x01e0  */
        /* JADX WARN: Code duplicated, block: B:67:0x01f2  */
        /* JADX WARN: Code duplicated, block: B:70:0x0208  */
        /* JADX WARN: Code duplicated, block: B:72:0x0216  */
        /* JADX WARN: Code duplicated, block: B:73:0x021f  */
        /* JADX WARN: Code duplicated, block: B:75:0x0231  */
        /* JADX WARN: Code duplicated, block: B:81:0x026b  */
        /* JADX WARN: Code duplicated, block: B:89:0x02ae  */
        @Override // java.lang.Runnable
        public final void run() {
            int i;
            int i2;
            int i3;
            int i4;
            int size;
            String str;
            int size2;
            int iB;
            String str2;
            int size3;
            int i5;
            int iC;
            String str3;
            int size4;
            String str4;
            int i6;
            int iD = 0;
            int i7 = 3;
            sg.bigo.ads.common.t.a.a(0, 3, "RetryTrackerManager", "mRetryTrackerRunnable. maybe trackInfoNum=" + c.this.f13565a.size());
            Iterator it = c.this.f13565a.iterator();
            int i8 = 0;
            int i9 = 0;
            while (true) {
                if (!it.hasNext()) {
                    i = i7;
                    i2 = iD;
                    break;
                }
                e eVar = (e) it.next();
                Context context = c.this.e;
                if (eVar.s == null) {
                    sg.bigo.ads.common.t.a.b("TrackerInfo", "retryThirdTrackImpl mThirdImpressionTrack is error.");
                } else {
                    if (eVar.a(eVar.i)) {
                        size = eVar.s.size();
                        sg.bigo.ads.common.t.a.a(iD, i7, "TrackerInfo", "retryThirdTrackImpl implTrackNum = ".concat(String.valueOf(size)));
                        if (size != 0) {
                            if (eVar.q.a(eVar.j, System.currentTimeMillis())) {
                                eVar.j = System.currentTimeMillis();
                                eVar.i++;
                                sg.bigo.ads.common.t.a.a(iD, i7, "TrackerInfo", "retryThirdTrackImpl mTrytimes = " + eVar.i);
                                eVar.a(context);
                            } else {
                                str = "retryThirdTrackImpl interval limit";
                            }
                        }
                        if (eVar.t == null) {
                            str2 = "retryThirdTrackClick not perform trackThirdClick";
                        } else if (eVar.a(eVar.k)) {
                            size2 = eVar.t.size();
                            sg.bigo.ads.common.t.a.a(iD, i7, "TrackerInfo", "retryThirdTrackClick clickTrackNum = ".concat(String.valueOf(size2)));
                            if (size2 != 0) {
                                iB = iD;
                            } else if (eVar.q.a(eVar.l, System.currentTimeMillis())) {
                                eVar.l = System.currentTimeMillis();
                                eVar.k++;
                                iB = eVar.b(context);
                                if (iB == 0 && eVar.k > 0) {
                                    eVar.k--;
                                }
                                sg.bigo.ads.common.t.a.a(iD, i7, "TrackerInfo", "retryThirdTrackClick Real clickTrackNum = ".concat(String.valueOf(iB)));
                                sg.bigo.ads.common.t.a.a(iD, i7, "TrackerInfo", "retryThirdTrackClick mTrytimes = " + eVar.k);
                            } else {
                                str2 = "retryThirdTrackClick interval limit";
                            }
                            if (eVar.u == null) {
                                str3 = "retryBiddingNUrl not perform.";
                            } else {
                                if (eVar.a(eVar.m)) {
                                    size3 = eVar.u.size();
                                    sg.bigo.ads.common.t.a.a(iD, i7, "TrackerInfo", "retryBiddingNUrl trackNum = ".concat(String.valueOf(size3)));
                                    if (size3 == 0) {
                                        iC = iD;
                                        i5 = size;
                                    } else {
                                        i5 = size;
                                        if (eVar.q.a(eVar.n, System.currentTimeMillis())) {
                                            eVar.n = System.currentTimeMillis();
                                            eVar.m++;
                                            iC = eVar.c(context);
                                            if (iC == 0 && eVar.m > 0) {
                                                eVar.m--;
                                            }
                                            sg.bigo.ads.common.t.a.a(iD, i7, "TrackerInfo", "retryBiddingNUrl Real trackNum = ".concat(String.valueOf(iC)));
                                            sg.bigo.ads.common.t.a.a(iD, i7, "TrackerInfo", "retryBiddingNUrl mTrytimes = " + eVar.m);
                                        } else {
                                            sg.bigo.ads.common.t.a.a(iD, i7, "TrackerInfo", "retryBiddingNUrl interval limit");
                                            iC = iD;
                                        }
                                    }
                                } else {
                                    str3 = "retryBiddingNUrl times limit. mTrytimes = " + eVar.m;
                                }
                                if (eVar.v == null) {
                                    str4 = "retryBiddingLUrl not perform.";
                                } else {
                                    if (eVar.a(eVar.o)) {
                                        size4 = eVar.v.size();
                                        sg.bigo.ads.common.t.a.a(iD, i7, "TrackerInfo", "retryBiddingLUrl trackNum = ".concat(String.valueOf(size4)));
                                        if (size4 != 0) {
                                            if (eVar.q.a(eVar.p, System.currentTimeMillis())) {
                                                eVar.p = System.currentTimeMillis();
                                                eVar.o++;
                                                iD = eVar.d(context);
                                                if (iD == 0 && eVar.o > 0) {
                                                    eVar.o--;
                                                }
                                                sg.bigo.ads.common.t.a.a(0, 3, "TrackerInfo", "retryBiddingLUrl Real trackNum = ".concat(String.valueOf(iD)));
                                                sg.bigo.ads.common.t.a.a(0, 3, "TrackerInfo", "retryBiddingLUrl mTrytimes = " + eVar.o);
                                            } else {
                                                sg.bigo.ads.common.t.a.a(0, 3, "TrackerInfo", "retryBiddingLUrl interval limit");
                                                iD = 0;
                                            }
                                        }
                                    } else {
                                        str4 = "retryBiddingLUrl times limit. mTrytimes = " + eVar.o;
                                    }
                                    i6 = iD + i5 + iB + iC;
                                    if (!eVar.a(eVar.s, eVar.i) && eVar.a(eVar.t, eVar.k) && eVar.a(eVar.u, eVar.m) && eVar.a(eVar.v, eVar.o)) {
                                        sg.bigo.ads.common.t.a.a(0, 3, "RetryTrackerManager", "allThirdTrackDone trackInfo=" + eVar.toString());
                                        f fVar = f.a.f13571a;
                                        f.b(eVar);
                                        it.remove();
                                    } else {
                                        i9 += i6;
                                        if (i9 > 20) {
                                            i2 = 0;
                                            i = 3;
                                            sg.bigo.ads.common.t.a.a(0, 3, "RetryTrackerManager", "track num exceeded the limit. trackNum=".concat(String.valueOf(i9)));
                                            i8 = i6;
                                            break;
                                        }
                                    }
                                    i8 = i6;
                                    iD = 0;
                                    i7 = 3;
                                }
                                sg.bigo.ads.common.t.a.a(iD, i7, "TrackerInfo", str4);
                                i6 = iD + i5 + iB + iC;
                                if (!eVar.a(eVar.s, eVar.i)) {
                                    i9 += i6;
                                    if (i9 > 20) {
                                        i2 = 0;
                                        i = 3;
                                        sg.bigo.ads.common.t.a.a(0, 3, "RetryTrackerManager", "track num exceeded the limit. trackNum=".concat(String.valueOf(i9)));
                                        i8 = i6;
                                        break;
                                    }
                                } else {
                                    i9 += i6;
                                    if (i9 > 20) {
                                        i2 = 0;
                                        i = 3;
                                        sg.bigo.ads.common.t.a.a(0, 3, "RetryTrackerManager", "track num exceeded the limit. trackNum=".concat(String.valueOf(i9)));
                                        i8 = i6;
                                        break;
                                    }
                                }
                                i8 = i6;
                                iD = 0;
                                i7 = 3;
                            }
                            sg.bigo.ads.common.t.a.a(iD, i7, "TrackerInfo", str3);
                            iC = iD;
                            i5 = size;
                            if (eVar.v == null) {
                                str4 = "retryBiddingLUrl not perform.";
                            } else {
                                if (eVar.a(eVar.o)) {
                                    str4 = "retryBiddingLUrl times limit. mTrytimes = " + eVar.o;
                                } else {
                                    size4 = eVar.v.size();
                                    sg.bigo.ads.common.t.a.a(iD, i7, "TrackerInfo", "retryBiddingLUrl trackNum = ".concat(String.valueOf(size4)));
                                    if (size4 != 0) {
                                        if (eVar.q.a(eVar.p, System.currentTimeMillis())) {
                                            sg.bigo.ads.common.t.a.a(0, 3, "TrackerInfo", "retryBiddingLUrl interval limit");
                                            iD = 0;
                                        } else {
                                            eVar.p = System.currentTimeMillis();
                                            eVar.o++;
                                            iD = eVar.d(context);
                                            if (iD == 0) {
                                                eVar.o--;
                                            }
                                            sg.bigo.ads.common.t.a.a(0, 3, "TrackerInfo", "retryBiddingLUrl Real trackNum = ".concat(String.valueOf(iD)));
                                            sg.bigo.ads.common.t.a.a(0, 3, "TrackerInfo", "retryBiddingLUrl mTrytimes = " + eVar.o);
                                        }
                                    }
                                }
                                i6 = iD + i5 + iB + iC;
                                if (!eVar.a(eVar.s, eVar.i)) {
                                    i9 += i6;
                                    if (i9 > 20) {
                                        i2 = 0;
                                        i = 3;
                                        sg.bigo.ads.common.t.a.a(0, 3, "RetryTrackerManager", "track num exceeded the limit. trackNum=".concat(String.valueOf(i9)));
                                        i8 = i6;
                                        break;
                                    }
                                } else {
                                    i9 += i6;
                                    if (i9 > 20) {
                                        i2 = 0;
                                        i = 3;
                                        sg.bigo.ads.common.t.a.a(0, 3, "RetryTrackerManager", "track num exceeded the limit. trackNum=".concat(String.valueOf(i9)));
                                        i8 = i6;
                                        break;
                                    }
                                }
                                i8 = i6;
                                iD = 0;
                                i7 = 3;
                            }
                            sg.bigo.ads.common.t.a.a(iD, i7, "TrackerInfo", str4);
                            i6 = iD + i5 + iB + iC;
                            if (!eVar.a(eVar.s, eVar.i)) {
                                i9 += i6;
                                if (i9 > 20) {
                                    i2 = 0;
                                    i = 3;
                                    sg.bigo.ads.common.t.a.a(0, 3, "RetryTrackerManager", "track num exceeded the limit. trackNum=".concat(String.valueOf(i9)));
                                    i8 = i6;
                                    break;
                                }
                            } else {
                                i9 += i6;
                                if (i9 > 20) {
                                    i2 = 0;
                                    i = 3;
                                    sg.bigo.ads.common.t.a.a(0, 3, "RetryTrackerManager", "track num exceeded the limit. trackNum=".concat(String.valueOf(i9)));
                                    i8 = i6;
                                    break;
                                }
                            }
                            i8 = i6;
                            iD = 0;
                            i7 = 3;
                        } else {
                            str2 = "retryThirdTrackClick times limit. mTrytimes = " + eVar.k;
                        }
                        sg.bigo.ads.common.t.a.a(iD, i7, "TrackerInfo", str2);
                        iB = iD;
                        if (eVar.u == null) {
                            str3 = "retryBiddingNUrl not perform.";
                        } else {
                            if (eVar.a(eVar.m)) {
                                str3 = "retryBiddingNUrl times limit. mTrytimes = " + eVar.m;
                            } else {
                                size3 = eVar.u.size();
                                sg.bigo.ads.common.t.a.a(iD, i7, "TrackerInfo", "retryBiddingNUrl trackNum = ".concat(String.valueOf(size3)));
                                if (size3 == 0) {
                                    iC = iD;
                                    i5 = size;
                                } else {
                                    i5 = size;
                                    if (eVar.q.a(eVar.n, System.currentTimeMillis())) {
                                        sg.bigo.ads.common.t.a.a(iD, i7, "TrackerInfo", "retryBiddingNUrl interval limit");
                                        iC = iD;
                                    } else {
                                        eVar.n = System.currentTimeMillis();
                                        eVar.m++;
                                        iC = eVar.c(context);
                                        if (iC == 0) {
                                            eVar.m--;
                                        }
                                        sg.bigo.ads.common.t.a.a(iD, i7, "TrackerInfo", "retryBiddingNUrl Real trackNum = ".concat(String.valueOf(iC)));
                                        sg.bigo.ads.common.t.a.a(iD, i7, "TrackerInfo", "retryBiddingNUrl mTrytimes = " + eVar.m);
                                    }
                                }
                            }
                            if (eVar.v == null) {
                                str4 = "retryBiddingLUrl not perform.";
                            } else {
                                if (eVar.a(eVar.o)) {
                                    str4 = "retryBiddingLUrl times limit. mTrytimes = " + eVar.o;
                                } else {
                                    size4 = eVar.v.size();
                                    sg.bigo.ads.common.t.a.a(iD, i7, "TrackerInfo", "retryBiddingLUrl trackNum = ".concat(String.valueOf(size4)));
                                    if (size4 != 0) {
                                        if (eVar.q.a(eVar.p, System.currentTimeMillis())) {
                                            sg.bigo.ads.common.t.a.a(0, 3, "TrackerInfo", "retryBiddingLUrl interval limit");
                                            iD = 0;
                                        } else {
                                            eVar.p = System.currentTimeMillis();
                                            eVar.o++;
                                            iD = eVar.d(context);
                                            if (iD == 0) {
                                                eVar.o--;
                                            }
                                            sg.bigo.ads.common.t.a.a(0, 3, "TrackerInfo", "retryBiddingLUrl Real trackNum = ".concat(String.valueOf(iD)));
                                            sg.bigo.ads.common.t.a.a(0, 3, "TrackerInfo", "retryBiddingLUrl mTrytimes = " + eVar.o);
                                        }
                                    }
                                }
                                i6 = iD + i5 + iB + iC;
                                if (!eVar.a(eVar.s, eVar.i)) {
                                    i9 += i6;
                                    if (i9 > 20) {
                                        i2 = 0;
                                        i = 3;
                                        sg.bigo.ads.common.t.a.a(0, 3, "RetryTrackerManager", "track num exceeded the limit. trackNum=".concat(String.valueOf(i9)));
                                        i8 = i6;
                                        break;
                                    }
                                } else {
                                    i9 += i6;
                                    if (i9 > 20) {
                                        i2 = 0;
                                        i = 3;
                                        sg.bigo.ads.common.t.a.a(0, 3, "RetryTrackerManager", "track num exceeded the limit. trackNum=".concat(String.valueOf(i9)));
                                        i8 = i6;
                                        break;
                                    }
                                }
                                i8 = i6;
                                iD = 0;
                                i7 = 3;
                            }
                            sg.bigo.ads.common.t.a.a(iD, i7, "TrackerInfo", str4);
                            i6 = iD + i5 + iB + iC;
                            if (!eVar.a(eVar.s, eVar.i)) {
                                i9 += i6;
                                if (i9 > 20) {
                                    i2 = 0;
                                    i = 3;
                                    sg.bigo.ads.common.t.a.a(0, 3, "RetryTrackerManager", "track num exceeded the limit. trackNum=".concat(String.valueOf(i9)));
                                    i8 = i6;
                                    break;
                                }
                            } else {
                                i9 += i6;
                                if (i9 > 20) {
                                    i2 = 0;
                                    i = 3;
                                    sg.bigo.ads.common.t.a.a(0, 3, "RetryTrackerManager", "track num exceeded the limit. trackNum=".concat(String.valueOf(i9)));
                                    i8 = i6;
                                    break;
                                }
                            }
                            i8 = i6;
                            iD = 0;
                            i7 = 3;
                        }
                        sg.bigo.ads.common.t.a.a(iD, i7, "TrackerInfo", str3);
                        iC = iD;
                        i5 = size;
                        if (eVar.v == null) {
                            str4 = "retryBiddingLUrl not perform.";
                        } else {
                            if (eVar.a(eVar.o)) {
                                str4 = "retryBiddingLUrl times limit. mTrytimes = " + eVar.o;
                            } else {
                                size4 = eVar.v.size();
                                sg.bigo.ads.common.t.a.a(iD, i7, "TrackerInfo", "retryBiddingLUrl trackNum = ".concat(String.valueOf(size4)));
                                if (size4 != 0) {
                                    if (eVar.q.a(eVar.p, System.currentTimeMillis())) {
                                        sg.bigo.ads.common.t.a.a(0, 3, "TrackerInfo", "retryBiddingLUrl interval limit");
                                        iD = 0;
                                    } else {
                                        eVar.p = System.currentTimeMillis();
                                        eVar.o++;
                                        iD = eVar.d(context);
                                        if (iD == 0) {
                                            eVar.o--;
                                        }
                                        sg.bigo.ads.common.t.a.a(0, 3, "TrackerInfo", "retryBiddingLUrl Real trackNum = ".concat(String.valueOf(iD)));
                                        sg.bigo.ads.common.t.a.a(0, 3, "TrackerInfo", "retryBiddingLUrl mTrytimes = " + eVar.o);
                                    }
                                }
                            }
                            i6 = iD + i5 + iB + iC;
                            if (!eVar.a(eVar.s, eVar.i)) {
                                i9 += i6;
                                if (i9 > 20) {
                                    i2 = 0;
                                    i = 3;
                                    sg.bigo.ads.common.t.a.a(0, 3, "RetryTrackerManager", "track num exceeded the limit. trackNum=".concat(String.valueOf(i9)));
                                    i8 = i6;
                                    break;
                                }
                            } else {
                                i9 += i6;
                                if (i9 > 20) {
                                    i2 = 0;
                                    i = 3;
                                    sg.bigo.ads.common.t.a.a(0, 3, "RetryTrackerManager", "track num exceeded the limit. trackNum=".concat(String.valueOf(i9)));
                                    i8 = i6;
                                    break;
                                }
                            }
                            i8 = i6;
                            iD = 0;
                            i7 = 3;
                        }
                        sg.bigo.ads.common.t.a.a(iD, i7, "TrackerInfo", str4);
                        i6 = iD + i5 + iB + iC;
                        if (!eVar.a(eVar.s, eVar.i)) {
                            i9 += i6;
                            if (i9 > 20) {
                                i2 = 0;
                                i = 3;
                                sg.bigo.ads.common.t.a.a(0, 3, "RetryTrackerManager", "track num exceeded the limit. trackNum=".concat(String.valueOf(i9)));
                                i8 = i6;
                                break;
                            }
                        } else {
                            i9 += i6;
                            if (i9 > 20) {
                                i2 = 0;
                                i = 3;
                                sg.bigo.ads.common.t.a.a(0, 3, "RetryTrackerManager", "track num exceeded the limit. trackNum=".concat(String.valueOf(i9)));
                                i8 = i6;
                                break;
                            }
                        }
                        i8 = i6;
                        iD = 0;
                        i7 = 3;
                    } else {
                        str = "retryThirdTrackImpl times limit. mTrytimes = " + eVar.i;
                    }
                    sg.bigo.ads.common.t.a.a(iD, i7, "TrackerInfo", str);
                }
                size = iD;
                if (eVar.t == null) {
                    str2 = "retryThirdTrackClick not perform trackThirdClick";
                } else if (eVar.a(eVar.k)) {
                    str2 = "retryThirdTrackClick times limit. mTrytimes = " + eVar.k;
                } else {
                    size2 = eVar.t.size();
                    sg.bigo.ads.common.t.a.a(iD, i7, "TrackerInfo", "retryThirdTrackClick clickTrackNum = ".concat(String.valueOf(size2)));
                    if (size2 != 0) {
                        iB = iD;
                    } else if (eVar.q.a(eVar.l, System.currentTimeMillis())) {
                        str2 = "retryThirdTrackClick interval limit";
                    } else {
                        eVar.l = System.currentTimeMillis();
                        eVar.k++;
                        iB = eVar.b(context);
                        if (iB == 0) {
                            eVar.k--;
                        }
                        sg.bigo.ads.common.t.a.a(iD, i7, "TrackerInfo", "retryThirdTrackClick Real clickTrackNum = ".concat(String.valueOf(iB)));
                        sg.bigo.ads.common.t.a.a(iD, i7, "TrackerInfo", "retryThirdTrackClick mTrytimes = " + eVar.k);
                    }
                    if (eVar.u == null) {
                        str3 = "retryBiddingNUrl not perform.";
                    } else {
                        if (eVar.a(eVar.m)) {
                            str3 = "retryBiddingNUrl times limit. mTrytimes = " + eVar.m;
                        } else {
                            size3 = eVar.u.size();
                            sg.bigo.ads.common.t.a.a(iD, i7, "TrackerInfo", "retryBiddingNUrl trackNum = ".concat(String.valueOf(size3)));
                            if (size3 == 0) {
                                iC = iD;
                                i5 = size;
                            } else {
                                i5 = size;
                                if (eVar.q.a(eVar.n, System.currentTimeMillis())) {
                                    sg.bigo.ads.common.t.a.a(iD, i7, "TrackerInfo", "retryBiddingNUrl interval limit");
                                    iC = iD;
                                } else {
                                    eVar.n = System.currentTimeMillis();
                                    eVar.m++;
                                    iC = eVar.c(context);
                                    if (iC == 0) {
                                        eVar.m--;
                                    }
                                    sg.bigo.ads.common.t.a.a(iD, i7, "TrackerInfo", "retryBiddingNUrl Real trackNum = ".concat(String.valueOf(iC)));
                                    sg.bigo.ads.common.t.a.a(iD, i7, "TrackerInfo", "retryBiddingNUrl mTrytimes = " + eVar.m);
                                }
                            }
                        }
                        if (eVar.v == null) {
                            str4 = "retryBiddingLUrl not perform.";
                        } else {
                            if (eVar.a(eVar.o)) {
                                str4 = "retryBiddingLUrl times limit. mTrytimes = " + eVar.o;
                            } else {
                                size4 = eVar.v.size();
                                sg.bigo.ads.common.t.a.a(iD, i7, "TrackerInfo", "retryBiddingLUrl trackNum = ".concat(String.valueOf(size4)));
                                if (size4 != 0) {
                                    if (eVar.q.a(eVar.p, System.currentTimeMillis())) {
                                        sg.bigo.ads.common.t.a.a(0, 3, "TrackerInfo", "retryBiddingLUrl interval limit");
                                        iD = 0;
                                    } else {
                                        eVar.p = System.currentTimeMillis();
                                        eVar.o++;
                                        iD = eVar.d(context);
                                        if (iD == 0) {
                                            eVar.o--;
                                        }
                                        sg.bigo.ads.common.t.a.a(0, 3, "TrackerInfo", "retryBiddingLUrl Real trackNum = ".concat(String.valueOf(iD)));
                                        sg.bigo.ads.common.t.a.a(0, 3, "TrackerInfo", "retryBiddingLUrl mTrytimes = " + eVar.o);
                                    }
                                }
                            }
                            i6 = iD + i5 + iB + iC;
                            if (!eVar.a(eVar.s, eVar.i)) {
                                i9 += i6;
                                if (i9 > 20) {
                                    i2 = 0;
                                    i = 3;
                                    sg.bigo.ads.common.t.a.a(0, 3, "RetryTrackerManager", "track num exceeded the limit. trackNum=".concat(String.valueOf(i9)));
                                    i8 = i6;
                                    break;
                                }
                            } else {
                                i9 += i6;
                                if (i9 > 20) {
                                    i2 = 0;
                                    i = 3;
                                    sg.bigo.ads.common.t.a.a(0, 3, "RetryTrackerManager", "track num exceeded the limit. trackNum=".concat(String.valueOf(i9)));
                                    i8 = i6;
                                    break;
                                }
                            }
                            i8 = i6;
                            iD = 0;
                            i7 = 3;
                        }
                        sg.bigo.ads.common.t.a.a(iD, i7, "TrackerInfo", str4);
                        i6 = iD + i5 + iB + iC;
                        if (!eVar.a(eVar.s, eVar.i)) {
                            i9 += i6;
                            if (i9 > 20) {
                                i2 = 0;
                                i = 3;
                                sg.bigo.ads.common.t.a.a(0, 3, "RetryTrackerManager", "track num exceeded the limit. trackNum=".concat(String.valueOf(i9)));
                                i8 = i6;
                                break;
                            }
                        } else {
                            i9 += i6;
                            if (i9 > 20) {
                                i2 = 0;
                                i = 3;
                                sg.bigo.ads.common.t.a.a(0, 3, "RetryTrackerManager", "track num exceeded the limit. trackNum=".concat(String.valueOf(i9)));
                                i8 = i6;
                                break;
                            }
                        }
                        i8 = i6;
                        iD = 0;
                        i7 = 3;
                    }
                    sg.bigo.ads.common.t.a.a(iD, i7, "TrackerInfo", str3);
                    iC = iD;
                    i5 = size;
                    if (eVar.v == null) {
                        str4 = "retryBiddingLUrl not perform.";
                    } else {
                        if (eVar.a(eVar.o)) {
                            str4 = "retryBiddingLUrl times limit. mTrytimes = " + eVar.o;
                        } else {
                            size4 = eVar.v.size();
                            sg.bigo.ads.common.t.a.a(iD, i7, "TrackerInfo", "retryBiddingLUrl trackNum = ".concat(String.valueOf(size4)));
                            if (size4 != 0) {
                                if (eVar.q.a(eVar.p, System.currentTimeMillis())) {
                                    sg.bigo.ads.common.t.a.a(0, 3, "TrackerInfo", "retryBiddingLUrl interval limit");
                                    iD = 0;
                                } else {
                                    eVar.p = System.currentTimeMillis();
                                    eVar.o++;
                                    iD = eVar.d(context);
                                    if (iD == 0) {
                                        eVar.o--;
                                    }
                                    sg.bigo.ads.common.t.a.a(0, 3, "TrackerInfo", "retryBiddingLUrl Real trackNum = ".concat(String.valueOf(iD)));
                                    sg.bigo.ads.common.t.a.a(0, 3, "TrackerInfo", "retryBiddingLUrl mTrytimes = " + eVar.o);
                                }
                            }
                        }
                        i6 = iD + i5 + iB + iC;
                        if (!eVar.a(eVar.s, eVar.i)) {
                            i9 += i6;
                            if (i9 > 20) {
                                i2 = 0;
                                i = 3;
                                sg.bigo.ads.common.t.a.a(0, 3, "RetryTrackerManager", "track num exceeded the limit. trackNum=".concat(String.valueOf(i9)));
                                i8 = i6;
                                break;
                            }
                        } else {
                            i9 += i6;
                            if (i9 > 20) {
                                i2 = 0;
                                i = 3;
                                sg.bigo.ads.common.t.a.a(0, 3, "RetryTrackerManager", "track num exceeded the limit. trackNum=".concat(String.valueOf(i9)));
                                i8 = i6;
                                break;
                            }
                        }
                        i8 = i6;
                        iD = 0;
                        i7 = 3;
                    }
                    sg.bigo.ads.common.t.a.a(iD, i7, "TrackerInfo", str4);
                    i6 = iD + i5 + iB + iC;
                    if (!eVar.a(eVar.s, eVar.i)) {
                        i9 += i6;
                        if (i9 > 20) {
                            i2 = 0;
                            i = 3;
                            sg.bigo.ads.common.t.a.a(0, 3, "RetryTrackerManager", "track num exceeded the limit. trackNum=".concat(String.valueOf(i9)));
                            i8 = i6;
                            break;
                        }
                    } else {
                        i9 += i6;
                        if (i9 > 20) {
                            i2 = 0;
                            i = 3;
                            sg.bigo.ads.common.t.a.a(0, 3, "RetryTrackerManager", "track num exceeded the limit. trackNum=".concat(String.valueOf(i9)));
                            i8 = i6;
                            break;
                        }
                    }
                    i8 = i6;
                    iD = 0;
                    i7 = 3;
                }
                sg.bigo.ads.common.t.a.a(iD, i7, "TrackerInfo", str2);
                iB = iD;
                if (eVar.u == null) {
                    str3 = "retryBiddingNUrl not perform.";
                } else {
                    if (eVar.a(eVar.m)) {
                        str3 = "retryBiddingNUrl times limit. mTrytimes = " + eVar.m;
                    } else {
                        size3 = eVar.u.size();
                        sg.bigo.ads.common.t.a.a(iD, i7, "TrackerInfo", "retryBiddingNUrl trackNum = ".concat(String.valueOf(size3)));
                        if (size3 == 0) {
                            iC = iD;
                            i5 = size;
                        } else {
                            i5 = size;
                            if (eVar.q.a(eVar.n, System.currentTimeMillis())) {
                                sg.bigo.ads.common.t.a.a(iD, i7, "TrackerInfo", "retryBiddingNUrl interval limit");
                                iC = iD;
                            } else {
                                eVar.n = System.currentTimeMillis();
                                eVar.m++;
                                iC = eVar.c(context);
                                if (iC == 0) {
                                    eVar.m--;
                                }
                                sg.bigo.ads.common.t.a.a(iD, i7, "TrackerInfo", "retryBiddingNUrl Real trackNum = ".concat(String.valueOf(iC)));
                                sg.bigo.ads.common.t.a.a(iD, i7, "TrackerInfo", "retryBiddingNUrl mTrytimes = " + eVar.m);
                            }
                        }
                    }
                    if (eVar.v == null) {
                        str4 = "retryBiddingLUrl not perform.";
                    } else {
                        if (eVar.a(eVar.o)) {
                            str4 = "retryBiddingLUrl times limit. mTrytimes = " + eVar.o;
                        } else {
                            size4 = eVar.v.size();
                            sg.bigo.ads.common.t.a.a(iD, i7, "TrackerInfo", "retryBiddingLUrl trackNum = ".concat(String.valueOf(size4)));
                            if (size4 != 0) {
                                if (eVar.q.a(eVar.p, System.currentTimeMillis())) {
                                    sg.bigo.ads.common.t.a.a(0, 3, "TrackerInfo", "retryBiddingLUrl interval limit");
                                    iD = 0;
                                } else {
                                    eVar.p = System.currentTimeMillis();
                                    eVar.o++;
                                    iD = eVar.d(context);
                                    if (iD == 0) {
                                        eVar.o--;
                                    }
                                    sg.bigo.ads.common.t.a.a(0, 3, "TrackerInfo", "retryBiddingLUrl Real trackNum = ".concat(String.valueOf(iD)));
                                    sg.bigo.ads.common.t.a.a(0, 3, "TrackerInfo", "retryBiddingLUrl mTrytimes = " + eVar.o);
                                }
                            }
                        }
                        i6 = iD + i5 + iB + iC;
                        if (!eVar.a(eVar.s, eVar.i)) {
                            i9 += i6;
                            if (i9 > 20) {
                                i2 = 0;
                                i = 3;
                                sg.bigo.ads.common.t.a.a(0, 3, "RetryTrackerManager", "track num exceeded the limit. trackNum=".concat(String.valueOf(i9)));
                                i8 = i6;
                                break;
                            }
                        } else {
                            i9 += i6;
                            if (i9 > 20) {
                                i2 = 0;
                                i = 3;
                                sg.bigo.ads.common.t.a.a(0, 3, "RetryTrackerManager", "track num exceeded the limit. trackNum=".concat(String.valueOf(i9)));
                                i8 = i6;
                                break;
                            }
                        }
                        i8 = i6;
                        iD = 0;
                        i7 = 3;
                    }
                    sg.bigo.ads.common.t.a.a(iD, i7, "TrackerInfo", str4);
                    i6 = iD + i5 + iB + iC;
                    if (!eVar.a(eVar.s, eVar.i)) {
                        i9 += i6;
                        if (i9 > 20) {
                            i2 = 0;
                            i = 3;
                            sg.bigo.ads.common.t.a.a(0, 3, "RetryTrackerManager", "track num exceeded the limit. trackNum=".concat(String.valueOf(i9)));
                            i8 = i6;
                            break;
                        }
                    } else {
                        i9 += i6;
                        if (i9 > 20) {
                            i2 = 0;
                            i = 3;
                            sg.bigo.ads.common.t.a.a(0, 3, "RetryTrackerManager", "track num exceeded the limit. trackNum=".concat(String.valueOf(i9)));
                            i8 = i6;
                            break;
                        }
                    }
                    i8 = i6;
                    iD = 0;
                    i7 = 3;
                }
                sg.bigo.ads.common.t.a.a(iD, i7, "TrackerInfo", str3);
                iC = iD;
                i5 = size;
                if (eVar.v == null) {
                    str4 = "retryBiddingLUrl not perform.";
                } else {
                    if (eVar.a(eVar.o)) {
                        str4 = "retryBiddingLUrl times limit. mTrytimes = " + eVar.o;
                    } else {
                        size4 = eVar.v.size();
                        sg.bigo.ads.common.t.a.a(iD, i7, "TrackerInfo", "retryBiddingLUrl trackNum = ".concat(String.valueOf(size4)));
                        if (size4 != 0) {
                            if (eVar.q.a(eVar.p, System.currentTimeMillis())) {
                                sg.bigo.ads.common.t.a.a(0, 3, "TrackerInfo", "retryBiddingLUrl interval limit");
                                iD = 0;
                            } else {
                                eVar.p = System.currentTimeMillis();
                                eVar.o++;
                                iD = eVar.d(context);
                                if (iD == 0) {
                                    eVar.o--;
                                }
                                sg.bigo.ads.common.t.a.a(0, 3, "TrackerInfo", "retryBiddingLUrl Real trackNum = ".concat(String.valueOf(iD)));
                                sg.bigo.ads.common.t.a.a(0, 3, "TrackerInfo", "retryBiddingLUrl mTrytimes = " + eVar.o);
                            }
                        }
                    }
                    i6 = iD + i5 + iB + iC;
                    if (!eVar.a(eVar.s, eVar.i)) {
                        i9 += i6;
                        if (i9 > 20) {
                            i2 = 0;
                            i = 3;
                            sg.bigo.ads.common.t.a.a(0, 3, "RetryTrackerManager", "track num exceeded the limit. trackNum=".concat(String.valueOf(i9)));
                            i8 = i6;
                            break;
                        }
                    } else {
                        i9 += i6;
                        if (i9 > 20) {
                            i2 = 0;
                            i = 3;
                            sg.bigo.ads.common.t.a.a(0, 3, "RetryTrackerManager", "track num exceeded the limit. trackNum=".concat(String.valueOf(i9)));
                            i8 = i6;
                            break;
                        }
                    }
                    i8 = i6;
                    iD = 0;
                    i7 = 3;
                }
                sg.bigo.ads.common.t.a.a(iD, i7, "TrackerInfo", str4);
                i6 = iD + i5 + iB + iC;
                if (!eVar.a(eVar.s, eVar.i)) {
                    i9 += i6;
                    if (i9 > 20) {
                        i2 = 0;
                        i = 3;
                        sg.bigo.ads.common.t.a.a(0, 3, "RetryTrackerManager", "track num exceeded the limit. trackNum=".concat(String.valueOf(i9)));
                        i8 = i6;
                        break;
                    }
                } else {
                    i9 += i6;
                    if (i9 > 20) {
                        i2 = 0;
                        i = 3;
                        sg.bigo.ads.common.t.a.a(0, 3, "RetryTrackerManager", "track num exceeded the limit. trackNum=".concat(String.valueOf(i9)));
                        i8 = i6;
                        break;
                    }
                }
                i8 = i6;
                iD = 0;
                i7 = 3;
            }
            sg.bigo.ads.common.t.a.a(i2, i, "RetryTrackerManager", "mRetryTrackerRunnable. actually trackNum=".concat(String.valueOf(i8)));
            if (c.this.f13565a.size() == 0) {
                Set set = c.this.f13565a;
                f fVar2 = f.a.f13571a;
                set.addAll(f.a(1800000L, c.this.c));
                i3 = 0;
                i4 = 3;
                sg.bigo.ads.common.t.a.a(0, 3, "RetryTrackerManager", "mRetryTrackerRunnable. append, trackers=" + c.this.f13565a.size());
            } else {
                i3 = 0;
                i4 = 3;
            }
            sg.bigo.ads.common.t.a.a(i3, i4, "RetryTrackerManager", "mRetryTrackerRunnable.trackers=" + c.this.f13565a.size());
            if (c.this.f13565a.size() > 0) {
                sg.bigo.ads.common.n.d.a(1, c.this.h, 20000L);
            } else {
                sg.bigo.ads.common.t.a.a(i3, i4, "RetryTrackerManager", "mRetryTrackerRunnable. stop looping");
                c.c();
            }
        }
    };

    public static c a() {
        return g;
    }

    static /* synthetic */ boolean c() {
        f = false;
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d() {
        f = true;
        b();
        sg.bigo.ads.common.t.a.a(0, 3, "RetryTrackerManager", "startCheckRetryTrack");
        sg.bigo.ads.common.n.d.a(1, this.h, 20000L);
    }

    public final void a(e eVar) {
        if (!f) {
            d();
        }
        this.f13565a.add(eVar);
        f fVar = f.a.f13571a;
        f.a(eVar);
    }

    public final void b() {
        sg.bigo.ads.common.t.a.a(0, 3, "RetryTrackerManager", "stopCheckRetryTrack");
        sg.bigo.ads.common.n.d.a(this.h);
    }

    public final void b(final e eVar) {
        sg.bigo.ads.common.n.d.a(1, new Runnable() { // from class: sg.bigo.ads.core.e.a.c.1
            @Override // java.lang.Runnable
            public final void run() {
                f fVar = f.a.f13571a;
                f.b(eVar);
            }
        });
    }
}
