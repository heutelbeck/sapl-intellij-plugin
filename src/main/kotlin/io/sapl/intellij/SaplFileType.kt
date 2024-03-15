package io.sapl.intellij

import com.intellij.openapi.fileTypes.LanguageFileType
import javax.swing.Icon

object SaplFileType : LanguageFileType(SaplLanguage) {
    override fun getName(): String = "SAPL"

    override fun getDescription(): String = "SAPL policy file"

    override fun getDefaultExtension(): String = "sapl"

    override fun getIcon(): Icon = SaplIcons.SAPL
}
