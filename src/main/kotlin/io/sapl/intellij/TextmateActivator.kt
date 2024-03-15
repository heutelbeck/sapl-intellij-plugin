package io.sapl.intellij

import com.intellij.openapi.project.Project
import com.intellij.openapi.startup.ProjectActivity
import org.jetbrains.plugins.textmate.TextMateService
import org.jetbrains.plugins.textmate.actions.Plugin
import org.jetbrains.plugins.textmate.configuration.TextMateUserBundlesSettings
import java.nio.file.Path
import kotlin.io.path.pathString

class TextmateActivator : ProjectActivity {
    override suspend fun execute(project: Project) {
        val extensionDir = Path.of("/home/oludwig/dev/uni/2022-david-bauer-thesis/sapl-vscode-extension/")
        val settings = TextMateUserBundlesSettings.instance ?: return

        if (!settings.bundles.any { it.key == extensionDir.pathString }) {
            val plugin = Plugin("sapl", "sapl-publisher-todo", "")
            TextMateUserBundlesSettings.instance!!.addBundle(extensionDir.pathString, plugin.toString())
            TextMateService.getInstance().reloadEnabledBundles()
        }
    }
}
