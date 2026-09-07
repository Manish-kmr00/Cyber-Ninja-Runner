package com.chartboost.sdk.impl;

import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.mbridge.msdk.foundation.download.core.DownloadCommon;
import java.io.File;
import java.io.RandomAccessFile;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a+\u0010\u0007\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0002¢\u0006\u0004\b\u0007\u0010\b*\u009e\u0001\b\u0002\u0010\f\"K\u0012\u0013\u0012\u00110\u0000¢\u0006\f\b\n\u0012\b\b\u000b\u0012\u0004\b\b(\u0001\u0012\u0013\u0012\u00110\u0002¢\u0006\f\b\n\u0012\b\b\u000b\u0012\u0004\b\b(\u0003\u0012\u0015\u0012\u0013\u0018\u00010\u0004¢\u0006\f\b\n\u0012\b\b\u000b\u0012\u0004\b\b(\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u00060\t2K\u0012\u0013\u0012\u00110\u0000¢\u0006\f\b\n\u0012\b\b\u000b\u0012\u0004\b\b(\u0001\u0012\u0013\u0012\u00110\u0002¢\u0006\f\b\n\u0012\b\b\u000b\u0012\u0004\b\b(\u0003\u0012\u0015\u0012\u0013\u0018\u00010\u0004¢\u0006\f\b\n\u0012\b\b\u000b\u0012\u0004\b\b(\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u00060\t*Ä\u0001\b\u0000\u0010\u0013\"^\u0012\u0013\u0012\u00110\u0000¢\u0006\f\b\n\u0012\b\b\u000b\u0012\u0004\b\b(\u0001\u0012\u0013\u0012\u00110\u000e¢\u0006\f\b\n\u0012\b\b\u000b\u0012\u0004\b\b(\u000f\u0012\u0013\u0012\u00110\u0010¢\u0006\f\b\n\u0012\b\b\u000b\u0012\u0004\b\b(\u0011\u0012\u0015\u0012\u0013\u0018\u00010\u0004¢\u0006\f\b\n\u0012\b\b\u000b\u0012\u0004\b\b(\u0005\u0012\u0004\u0012\u00020\u00120\r2^\u0012\u0013\u0012\u00110\u0000¢\u0006\f\b\n\u0012\b\b\u000b\u0012\u0004\b\b(\u0001\u0012\u0013\u0012\u00110\u000e¢\u0006\f\b\n\u0012\b\b\u000b\u0012\u0004\b\b(\u000f\u0012\u0013\u0012\u00110\u0010¢\u0006\f\b\n\u0012\b\b\u000b\u0012\u0004\b\b(\u0011\u0012\u0015\u0012\u0013\u0018\u00010\u0004¢\u0006\f\b\n\u0012\b\b\u000b\u0012\u0004\b\b(\u0005\u0012\u0004\u0012\u00020\u00120\r¨\u0006\u0014"}, d2 = {"Lcom/chartboost/sdk/impl/gb;", "videoAsset", "Lcom/chartboost/sdk/impl/z9;", "tempHelper", "Lcom/chartboost/sdk/impl/f5;", "fileCache", "Lcom/chartboost/sdk/impl/u8;", DownloadCommon.DOWNLOAD_REPORT_FIND_FILE_RESULT_VALUE_B, "(Lcom/chartboost/sdk/impl/gb;Lcom/chartboost/sdk/impl/z9;Lcom/chartboost/sdk/impl/f5;)Lcom/chartboost/sdk/impl/u8;", "Lkotlin/Function3;", "Lkotlin/ParameterName;", "name", "RandomAccessFileFactory", "Lkotlin/Function4;", "Lcom/chartboost/sdk/impl/ib$b;", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "Lkotlinx/coroutines/CoroutineDispatcher;", "coroutineDispatcher", "Lcom/chartboost/sdk/impl/ib;", "VideoBufferFactory", "ChartboostMonetization-9.8.3_productionRelease"}, k = 2, mv = {1, 8, 0})
public final class jb {
    public static final u8 b(gb gbVar, z9 z9Var, f5 f5Var) {
        File fileA;
        RandomAccessFile randomAccessFileA;
        if (f5Var != null) {
            try {
                fileA = f5Var.a(f5Var.b(), gbVar.getFilename());
            } catch (Exception e) {
                b7.b(e.toString(), null, 2, null);
            }
        } else {
            fileA = null;
        }
        if (fileA != null && fileA.exists()) {
            randomAccessFileA = z9Var.a(fileA);
        } else {
            File fileA2 = z9Var.a(gbVar.getDirectory(), gbVar.getFilename());
            randomAccessFileA = fileA2 != null ? z9Var.a(fileA2) : null;
        }
        if (randomAccessFileA != null) {
            return new u8(randomAccessFileA);
        }
        return null;
    }
}
