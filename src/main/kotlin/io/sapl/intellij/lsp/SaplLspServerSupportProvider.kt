package io.sapl.intellij.lsp

import io.sapl.intellij.SaplFileType
import com.intellij.openapi.project.Project
import com.intellij.openapi.vfs.VirtualFile
import com.intellij.platform.lsp.api.LspServerSupportProvider

class SaplLspServerSupportProvider : LspServerSupportProvider {
    override fun fileOpened(project: Project, file: VirtualFile, serverStarter: LspServerSupportProvider.LspServerStarter) {
        if (file.fileType == SaplFileType) {
            serverStarter.ensureServerStarted(SaplLspServerDescriptor(project))
        }
    }
}
