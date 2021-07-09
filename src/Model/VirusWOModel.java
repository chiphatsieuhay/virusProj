package Model;

import java.util.Map;

public class VirusWOModel extends VirusModel{

	public VirusWOModel(String name,String basicElements,boolean vaccine,String infectionProcess,String treatment,String sequelae,int dangerLevel,Map<String,String> Process) {
		// TODO Auto-generated constructor stub
		super(name, basicElements, vaccine, infectionProcess, treatment, sequelae, dangerLevel,Process);
	}
	public VirusWOModel() {};
}
