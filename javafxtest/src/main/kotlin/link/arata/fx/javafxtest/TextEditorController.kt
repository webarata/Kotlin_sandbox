package link.arata.fx.javafxtest

import javafx.application.Platform
import javafx.fxml.FXML
import javafx.fxml.FXMLLoader
import javafx.fxml.Initializable
import javafx.scene.Parent
import javafx.scene.Scene
import javafx.scene.control.Alert
import javafx.scene.control.MenuItem
import javafx.scene.control.TextArea
import javafx.stage.FileChooser
import javafx.stage.Modality
import javafx.stage.Stage
import javafx.stage.StageStyle
import java.io.File
import java.net.URL
import java.util.ResourceBundle

class TextEditorController : Initializable {
    lateinit var stage: Stage

    @FXML
    lateinit var saveMenu: MenuItem

    @FXML
    lateinit var textArea: TextArea

    var currentFile: File? = null

    public override fun initialize(location: URL?, resources: ResourceBundle?) {
    }

    @FXML
    fun handleOpen() {
        val fc = FileChooser()
        fc.title = "ファイルを開く"
        val file = fc.showOpenDialog(stage) ?: return
        textArea.clear()
        file.forEachLine(Charsets.UTF_8, {
            textArea.appendText("$it\n")
        })
        currentFile = file
        saveMenu.setDisable(false)
    }

    @FXML
    fun handleSave() {
        // 開いているファイルがない場合。ほぼ考えられない
        if (currentFile == null) return
        writeFile()
    }

    @FXML
    fun handleSaveAs() {
        val fc = FileChooser()
        fc.title = "名前を付けて保存"
        val file = fc.showSaveDialog(stage) ?: return
        currentFile = file
        writeFile()
    }

    @FXML
    fun handleExit() {
        val alert = Alert(Alert.AlertType.CONFIRMATION)
        alert.title = "終了しますか"
        alert.dialogPane.headerText = "終了しますか"
        alert.dialogPane.contentText = ""
        alert.showAndWait()

        Platform.exit()
    }

    @FXML
    fun handleConfig() {
        val fxmlLoader: FXMLLoader = FXMLLoader(javaClass<TextEditor>().getResource("ConfigDialog.fxml"))
        val root: Parent = fxmlLoader.load()

        val scene = Scene(root)
        val configDialog = Stage(StageStyle.UTILITY)
        configDialog.scene = scene;
        configDialog.initOwner(stage)
        configDialog.initModality(Modality.WINDOW_MODAL)
        configDialog.setResizable(false);
        configDialog.title = "設定"
        configDialog.showAndWait()
    }

    private fun writeFile() {
        currentFile!!.writeText(textArea.getText(), Charsets.UTF_8)
    }
}
