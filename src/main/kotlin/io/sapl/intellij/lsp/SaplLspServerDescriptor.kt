package io.sapl.intellij.lsp

import io.sapl.intellij.SaplFileType
import com.intellij.execution.configurations.GeneralCommandLine
import com.intellij.ide.plugins.PluginManagerCore
import com.intellij.openapi.extensions.PluginId
import com.intellij.openapi.project.Project
import com.intellij.openapi.vfs.VirtualFile
import com.intellij.platform.lsp.api.ProjectWideLspServerDescriptor
import kotlin.io.path.pathString

class SaplLspServerDescriptor(project: Project): ProjectWideLspServerDescriptor(project, "SAPL") {
    override fun createCommandLine(): GeneralCommandLine {
        val path = PluginManagerCore.getPlugin(PluginId.getId("io.sapl.saplintellijplugin"))!!
                .pluginPath.resolve("lib/sapl-language-server-3.0.0-SNAPSHOT.jar").pathString
        return GeneralCommandLine("java", "-jar", path)
    }

    override fun isSupportedFile(file: VirtualFile) = file.fileType == SaplFileType
}
