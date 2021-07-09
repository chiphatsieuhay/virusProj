package Scene;

import java.awt.Desktop;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

import Model.VirusModel;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;

public class VirusTableSceneController extends SceneController{	
    @FXML
    protected TextField searchField;
    @FXML
    protected TextArea basicElements;
    @FXML
    protected TextArea treatment;
    @FXML
    protected TextArea sequelae;
    @FXML
    protected TextField infectionProcess;
    @FXML
    protected TextArea ImageInfo;
    @FXML
    protected ImageView image;
    @FXML
    protected TextField lipid;
	protected void display(MouseEvent event,VirusModel virus) throws IOException {
    	String BE = virus.getBasicElements();
    	if(BE == null || BE.isEmpty()) {
    		basicElements.setText("Nothing selected!");
    	}else {
    		basicElements.setText(BE);
    	}
    	String IP = virus.getInfectionProcess();
    	if(IP == null || ((CharSequence) IP).isEmpty()) {
    		infectionProcess.setText("Nothing selected!");
    	}else {
    		infectionProcess.setText(IP.toString());
    	}
    	String T = virus.getTreatment();
    	if(T == null || T.isEmpty()) {
    		treatment.setText("Nothing selected!");
    	}else {
    		treatment.setText(T);
    	}
    	String S = virus.getSequelae();
    	if(S == null || S.isEmpty()) {
    		sequelae.setText("Nothing selected!");
    	}else {
    		sequelae.setText(S);
    	}
	}
    protected void browse(ActionEvent event,String IP) {
    	Desktop d = Desktop.getDesktop();
    	try {
			d.browse(new URI(IP));
		} catch (IOException e1) {
			e1.printStackTrace();
		} catch (URISyntaxException e1) {
			e1.printStackTrace();
		}
    }
}
