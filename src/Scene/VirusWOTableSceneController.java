package Scene;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import Model.VirusWOModel;
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

public class VirusWOTableSceneController extends VirusTableSceneController implements Initializable{
	@FXML
	private TableView<VirusWOModel> table;
	@FXML
	private TableColumn<VirusWOModel,String> nameColumn;
	@FXML
	private TableColumn<VirusWOModel,Integer> levelColumn;
	@FXML
	private TableColumn<VirusWOModel,Boolean> vaccineColumn;
	
	private ObservableList<VirusWOModel> WOList;

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		WOList = FXCollections.observableArrayList(
				new VirusWOModel("Marburg", "negative polarity RNA, 7 structural proteins",
						false, "https://www.youtube.com/watch?v=TBtWrxZdraw", "no", "viral hemorrhagic fever,die", 7),
				new VirusWOModel("Crimean–Congo hemorrhagic fever","circular, negative-sense single stranded RNA",
						false,"https://en.wikipedia.org/wiki/Crimean%e2%80%93Congo_hemorrhagic_fever",
						"Treatment is mostly supportive","weak,die",4),
				new VirusWOModel("Ebola",
						"U-shaped, cylindrical/tubular, and contain viral envelope, matrix, and nucleocapsid components.",
						false, "https://www.youtube.com/watch?v=NIhP3YGW6HY", "No antiviral medications have proved effective ", "die", 6),
				new VirusWOModel("Lassa", " enveloped, single-stranded, bisegmented, ambisense RNA viruses", true, "water",
						"The antiviral drug ribavirin seems to be an effective treatment for Lassa fever if given early on in the course of clinical illness.", "feaver", 3),
				new VirusWOModel("Nipah", 
						"Single stranded negative sense RNA, six structural proteins",
						false, "water,air", "no", "neurological disease", 5),
				new VirusWOModel("Chikungunya", 
						"a single strand of RNA is contained within a protein shell, or capsid, which in turn is covered by a phospholipid layer, or envelope.",
						false, "Aedes aegypti mosquito", 
						"Currently, no specific treatment for chikungunya is available.", "pain,hurt body", 2),
				new VirusWOModel("Zika", "RNA core, a shell", true, "Aedes aegypti and Asia mosquito", "no specific treatment", 
						" Zika virus infection during pregnancy is a cause of microcephaly.", 2));
		nameColumn.setCellValueFactory(new PropertyValueFactory<VirusWOModel,String>("name"));
		levelColumn.setCellValueFactory(new PropertyValueFactory<VirusWOModel,Integer>("dangerLevel"));
		vaccineColumn.setCellValueFactory(new PropertyValueFactory<VirusWOModel,Boolean>("vaccine"));
		
		FilteredList<VirusWOModel> filteredData = new FilteredList<VirusWOModel>(WOList,b->true);
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
		SortedList<VirusWOModel> sortedData = new SortedList<VirusWOModel>(filteredData);
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
    public void switchStart(ActionEvent event) throws IOException {
		 switchToStart(event);
	}
    @FXML
    void displaySelected(MouseEvent e) throws IOException {
    	VirusWOModel virus = table.getSelectionModel().getSelectedItem();
    	display(e,virus);
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
