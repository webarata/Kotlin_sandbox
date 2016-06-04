package link.arata.fx.javafxtest

import javafx.application.Application
import javafx.fxml.FXMLLoader
import javafx.scene.Parent
import javafx.scene.Scene
import javafx.stage.Stage

class TextEditor() : Application() {
    lateinit var textEditorController: TextEditorController

    companion object {
        @JvmStatic
        public fun main(args: Array<String>) {
            Application.launch(TextEditor::class.java, *args)
        }
    }

    public override fun start(stage: Stage) {
        val fxmlLoader: FXMLLoader = FXMLLoader(TextEditor::class.java.getResource("TextEditor.fxml"))
        val root: Parent = fxmlLoader.load()
        textEditorController = fxmlLoader.getController()
        textEditorController.stage = stage

        val scene: Scene = Scene(root)

        stage.title = "テキストエディタ"
        stage.scene = scene
        stage.show()
    }
}
