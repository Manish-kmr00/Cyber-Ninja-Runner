package com.bykv.vk.openvk.preload.geckox.d;

import com.bykv.vk.openvk.preload.geckox.model.UpdatePackage;

/* JADX INFO: compiled from: FileTypeBranchInterceptor.java */
/* JADX INFO: loaded from: classes8.dex */
public class a extends com.bykv.vk.openvk.preload.b.a<UpdatePackage, UpdatePackage> {
    @Override // com.bykv.vk.openvk.preload.b.a
    protected final /* synthetic */ String a(UpdatePackage updatePackage) {
        int packageType = updatePackage.getPackageType();
        if (packageType == 0) {
            return "branch_zip";
        }
        if (packageType == 1) {
            return "branch_single_file";
        }
        throw new RuntimeException("unknow file type: ".concat(String.valueOf(packageType)));
    }
}
