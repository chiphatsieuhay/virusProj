package Model;


public class VirusWModel extends VirusModel{
	public int number_lipid_layer;
	public int getnumber_lipid_layer() {
		return number_lipid_layer;
	}
	public void setnumber_lipid_layer(int number_lipid_layer) {
		this.number_lipid_layer = number_lipid_layer;
	}
	public VirusWModel(String name,String basicElements,boolean vaccine,String infectionProcess,String treatment,String sequelae,int dangerLevel
			,int number_lipid_layer) {
		// TODO Auto-generated constructor stub
		super(name, basicElements, vaccine, infectionProcess, treatment, sequelae, dangerLevel);
		this.number_lipid_layer = number_lipid_layer;
	}
	public VirusWModel() {};
}
