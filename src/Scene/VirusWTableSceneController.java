package Scene;

import java.awt.Desktop;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.ResourceBundle;

import Model.VirusWModel;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

public class VirusWTableSceneController implements Initializable,switchTo,browsing{
	@FXML
	private TableView<VirusWModel> table;
	@FXML
	private TableColumn<VirusWModel,String> nameColumn;
	@FXML
	private TableColumn<VirusWModel,Integer> levelColumn;
	@FXML
	private TableColumn<VirusWModel,Boolean> vaccineColumn;
	
	private ObservableList<VirusWModel> WList;

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		WList = FXCollections.observableArrayList(
				new VirusWModel("HIV", 
						"a core of ribonucleic acid (RNA), called the genome, and a protein component that surrounds the genome, called a capsid.", 
						false, "https://www.youtube.com/watch?v=ng22Ucr33aw", "can only delay, cannot cure", "lead to AIDS", 7, 3),
				new VirusWModel("Covid19",
						"RNA at core bound with nuclearprotein, viral envelope, envelope proteins and spike protein", 
						true, "https://www.youtube.com/watch?v=j4Xiow30bGo", "no real treatment yet", "weakened your immune system", 5, 4),
				new VirusWModel("Influenza",
						"lipid envelope: HA and NA"
						, true, "https://www.youtube.com/watch?v=tB5FQZi4HKY", 
						"supportive and includes anti-fever medications", "may lead to die", 5, 2),
				new VirusWModel("Mump",
						"genome, capsid, viral envelope",
						true, "https://www.youtube.com/watch?v=Fq46xLX5ZW4", 
						"supportive in nature, and infection is preventable via vaccination", 
						"not life-threatening and typically resolves within a few weeks after the onset of symptoms, "
						+ "but long-term complications such as paralysis, seizures, hydrocephalus, and deafness can occur", 4, 1),
				new VirusWModel("Rubella", 
						"The spherical virus particles (virions) of Matonaviridae "
						+ ", covered by a lipid membrane (viral envelope),"
						+ " derived from the host cell membrane. "
						+ "There are prominent \"spikes\" (projections) of 6 nm composed of the viral envelope proteins E1 and E2 embedded in the membrane."
						, true, "https://www.youtube.com/watch?v=nzRHqxwVkrE", "no specific treatment", "not life threaten, but dangerous if pregnant", 4, 1),
				new VirusWModel("Japanese encephalitis",
						"RNA genome, viral envelope, capsid protein, envelope protein", 
						true, "https://www.youtube.com/watch?v=m2U1ERuhqWM", "no specific treatment", "fatal, can die", 5, 2),
				new VirusWModel("Hepatitis Virus",
						"an outer lipid envelope and an icosahedral nucleocapsid core composed of protein", 
						true, "https://www.youtube.com/watch?v=0jrHRv2pJXQ", "varies according to the type", "can lead to cancer", 4, 1),
				new VirusWModel("Polio Virus", 
						"an RNA genome and a protein capsid", true, "https://www.youtube.com/watch?v=K9eZTm4TL2c", 
						"The focus of modern treatment has been on providing relief of symptoms, speeding recovery and preventing complications"
						, "can be fatal with children and senior citizen", 4, 1)
				
				);
		nameColumn.setCellValueFactory(new PropertyValueFactory<VirusWModel,String>("name"));
		levelColumn.setCellValueFactory(new PropertyValueFactory<VirusWModel,Integer>("dangerLevel"));
		vaccineColumn.setCellValueFactory(new PropertyValueFactory<VirusWModel,Boolean>("vaccine"));
		
		FilteredList<VirusWModel> filteredData = new FilteredList<VirusWModel>(WList,b->true);
		searchField.textProperty().addListener((observable,oldValue,newValue)->{
			filteredData.setPredicate(virus -> {
				if(newValue == null || newValue.isEmpty()) {
					return true;
				}
				String lowerCaseFilter = newValue.toLowerCase();
				if(virus.getName().toLowerCase().indexOf(lowerCaseFilter)!=-1) {
					return true;
				}else if(String.valueOf(virus.getDangerLevel()).indexOf(lowerCaseFilter)!=-1) {
					return true;
				}else if(String.valueOf(virus.isVaccine()).indexOf(lowerCaseFilter)!=-1) {
					return true;
				}else return false;
			});
		});
		SortedList<VirusWModel> sortedData = new SortedList<VirusWModel>(filteredData);
		sortedData.comparatorProperty().bind(table.comparatorProperty());
		table.setItems(sortedData);
		
		table.setOnMouseClicked(e->{
			displaySelected(e);
		});
	}
    @FXML
    private TextField searchField;
    private Stage stage;
	private Scene scene;
	private Parent root;
    public void switchToStart(ActionEvent event) throws IOException {
		 switchToScene(event,"StartScene.fxml");
	}
    @FXML
    private TextArea basicElements;
    @FXML
    private TextArea treatment;
    @FXML
    private TextArea sequelae;
    @FXML
    private TextField lipid;
    @FXML
    private TextField infectionProcess;
    
    @FXML
    void displaySelected(MouseEvent e) {
    	VirusWModel virus = table.getSelectionModel().getSelectedItem();
    	String BE = virus.getBasicElements();
    	if(BE == null || BE.isEmpty()) {
    		basicElements.setText("Nothing selected!");
    	}else {
    		basicElements.setText(BE);
    	}
    	String IP = virus.getInfectionProcess();
    	if(IP == null || IP.isEmpty()) {
    		infectionProcess.setText("Nothing selected!");
    	}else {
    		infectionProcess.setText(IP);
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
    	float LL = virus.getnumber_lipid_layer();
    	if(String.valueOf(LL) == null || String.valueOf(LL).isEmpty()) {
    		lipid.setText("Nothing selected!");
    	}else {
    		lipid.setText(String.valueOf(LL));
    	}
    	
    }

    @FXML
    void browse(ActionEvent event) {
    	String IP = table.getSelectionModel().getSelectedItem().getInfectionProcess();
    	browse(event,IP);
    }
    @Override
    public void browse(ActionEvent event,String IP) {
    	Desktop d = Desktop.getDesktop();
    	try {
			d.browse(new URI(IP));
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (URISyntaxException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
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
