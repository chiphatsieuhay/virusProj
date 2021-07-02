package Model;

public abstract class VirusModel {
	protected String name;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getBasicElements() {
		return basicElements;
	}
	public void setBasicElements(String basicElements) {
		this.basicElements = basicElements;
	}
	public boolean isVaccine() {
		return vaccine;
	}
	public void setVaccine(boolean vaccine) {
		this.vaccine = vaccine;
	}
	public String getInfectionProcess() {
		return infectionProcess;
	}
	public void setInfectionProcess(String infectionProcess) {
		this.infectionProcess = infectionProcess;
	}
	public String getTreatment() {
		return treatment;
	}
	public void setTreatment(String treatment) {
		this.treatment = treatment;
	}
	public String getSequelae() {
		return sequelae;
	}
	public void setSequelae(String sequelae) {
		this.sequelae = sequelae;
	}
	public int getDangerLevel() {
		return dangerLevel;
	}
	public void setDangerLevel(int dangerLevel) {
		this.dangerLevel = dangerLevel;
	}
	protected String category;
	protected String basicElements;
	protected boolean vaccine;
	protected String infectionProcess;
	protected String treatment;
	protected String sequelae;
	protected int dangerLevel;
	public VirusModel(String name,String basicElements,boolean vaccine,String infectionProcess,String treatment,String sequelae,int dangerLevel) {
		this.name = name;
		this.basicElements = basicElements;
		this.vaccine = vaccine;
		this.infectionProcess = infectionProcess;
		this.treatment = treatment;
		this.sequelae = sequelae;
		this.dangerLevel = dangerLevel;
	}
	public VirusModel() {};
}
