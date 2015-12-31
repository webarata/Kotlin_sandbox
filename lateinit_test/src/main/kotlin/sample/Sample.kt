package sample

import javafx.application.Application
import javafx.fxml.FXMLLoader
import javafx.scene.Parent
import javafx.scene.Scene
import javafx.stage.Stage

class Sample : Application() {
    companion object {
        @JvmStatic
        public fun main(args: Array<String>) {
            Application.launch(Sample::class.java, *args)
        }
    }

    public override fun start(stage: Stage) {
        val fxmlLoader: FXMLLoader = FXMLLoader(Sample::class.java.getResource("Sample.fxml"))
        val root: Parent = fxmlLoader.load()
        val scene: Scene = Scene(root)

        stage.title = "サンプル"
        stage.scene = scene
        stage.show()
    }
}
