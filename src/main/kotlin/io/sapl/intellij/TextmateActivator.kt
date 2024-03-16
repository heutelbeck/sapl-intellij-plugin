package io.sapl.intellij

import com.intellij.ide.plugins.PluginManagerCore
import com.intellij.openapi.extensions.PluginId
import com.intellij.openapi.project.Project
import com.intellij.openapi.startup.ProjectActivity
import org.jetbrains.plugins.textmate.TextMateService
import org.jetbrains.plugins.textmate.actions.Plugin
import org.jetbrains.plugins.textmate.configuration.TextMateUserBundlesSettings
import java.nio.file.Path
import kotlin.io.path.pathString

class TextmateActivator : ProjectActivity {
    override suspend fun execute(project: Project) {
        val extensionDir = PluginManagerCore.getPlugin(PluginId.getId("io.sapl.saplintellijplugin"))!!
                .pluginPath.resolve("lib/textmate")
        val settings = TextMateUserBundlesSettings.instance ?: return

        if (!settings.bundles.any { it.key == extensionDir.pathString }) {
            val plugin = Plugin("sapl", "sapl", "")
            TextMateUserBundlesSettings.instance!!.addBundle(extensionDir.pathString, plugin.toString())
            TextMateService.getInstance().reloadEnabledBundles()
        }
    }
}
