package io.sapl.intellij.lsp

import io.sapl.intellij.SaplFileType
import com.intellij.execution.configurations.GeneralCommandLine
import com.intellij.openapi.project.Project
import com.intellij.openapi.vfs.VirtualFile
import com.intellij.platform.lsp.api.ProjectWideLspServerDescriptor

class SaplLspServerDescriptor(project: Project): ProjectWideLspServerDescriptor(project, "SAPL") {
    override fun createCommandLine() = GeneralCommandLine("java", "-jar", "/home/oludwig/sapl-language-server-3.0.0-SNAPSHOT.jar")

    override fun isSupportedFile(file: VirtualFile) = file.fileType == SaplFileType
}
