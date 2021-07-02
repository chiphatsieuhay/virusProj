package Scene;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class SceneController implements switchTo{
	private Stage stage;
	private Scene scene;
	private Parent root;
	
	public void switchToHome(ActionEvent event) throws IOException {
		 switchToScene(event, "HomeScene.fxml");
	}
	public void switchToHelp(ActionEvent event) throws IOException {
		switchToScene(event, "HelpScene.fxml");
	}
	public void switchToStart(ActionEvent event) throws IOException {
		switchToScene(event, "StartScene.fxml");
	}
	public void switchToVirusW(ActionEvent event) throws IOException {
		switchToScene(event, "VirusWScene.fxml");
	}
	public void switchToVirusWO(ActionEvent event) throws IOException {
		switchToScene(event, "VirusWOScene.fxml");
	}
	public void exit(ActionEvent event) {
		System.exit(0);
	}
	public void switchToUsageScene(ActionEvent event) throws IOException {
		switchToScene(event, "UsageScene.fxml");
	}
	public void switchToPurposeScene(ActionEvent event) throws IOException {
		switchToScene(event, "PurposeScene.fxml");
	}
	@Override
	public void switchToScene(ActionEvent event, String sceneRoot) throws IOException {
		 root = FXMLLoader.load(getClass().getResource(sceneRoot));
		 stage = (Stage)((Node)event.getSource()).getScene().getWindow();
		 scene = new Scene(root);
		 stage.setScene(scene);
		 stage.show();
	}
}
