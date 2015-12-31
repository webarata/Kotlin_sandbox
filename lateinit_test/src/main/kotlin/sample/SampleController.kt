package sample

import javafx.fxml.FXML
import javafx.fxml.Initializable
import javafx.scene.control.Button
import javafx.scene.control.Label
import java.net.URL
import java.util.*

class SampleController : Initializable {
    @FXML
    lateinit var button: Button

    @FXML
    lateinit var label: Label

    @FXML
    fun onActionButton() {
        label.text = "テスト"
    }

    public override fun initialize(location: URL?, resources: ResourceBundle?) {
    }
}
