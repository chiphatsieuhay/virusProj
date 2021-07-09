package Scene;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import Model.VirusWModel;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;

public class VirusWTableSceneController extends VirusTableSceneController implements Initializable{
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
						false, "https://www.youtube.com/watch?v=ng22Ucr33aw", "can only delay, cannot cure", "lead to AIDS", 7, 3,Data.HIV),
				new VirusWModel("Covid19",
						"RNA at core bound with nuclearprotein, viral envelope, envelope proteins and spike protein", 
						true, "https://www.youtube.com/watch?v=j4Xiow30bGo", "no real treatment yet", "weakened your immune system", 5, 4,Data.Covid19),
				new VirusWModel("Influenza",
						"lipid envelope: HA and NA"
						, true, "https://www.youtube.com/watch?v=tB5FQZi4HKY", 
						"supportive and includes anti-fever medications", "may lead to die", 5, 2,Data.Flu),
				new VirusWModel("Japanese encephalitis",
						"RNA genome, viral envelope, capsid protein, envelope protein", 
						true, "https://www.youtube.com/watch?v=m2U1ERuhqWM", "no specific treatment", "fatal, can die", 5, 2,Data.Japan),
				new VirusWModel("Hepatitis Virus",
						"an outer lipid envelope and an icosahedral nucleocapsid core composed of protein", 
						true, "https://www.youtube.com/watch?v=0jrHRv2pJXQ", "varies according to the type", "can lead to cancer", 4, 1,Data.Hepa)
				
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
			try {
				displaySelected(e);
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		});
	}
	@FXML
	public void switchStart(ActionEvent e) throws IOException {
		switchToStart(e);
	}
	@FXML
    void displaySelected(MouseEvent e) throws IOException {
    	VirusWModel virus = table.getSelectionModel().getSelectedItem();
    	display(e,virus);
		int LL = virus.getNumber_lipid_layer();
		lipid.setText(String.valueOf(LL));
	}
	@FXML
    void browse(ActionEvent event) {
    	String IP = table.getSelectionModel().getSelectedItem().getInfectionProcess();
    	browse(event,IP);
    }
    @FXML
    void displayProcess(ActionEvent event) {
    }
}
