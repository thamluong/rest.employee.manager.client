package staffclient.model;

import staffclient.model.Company;

public class Staff {
	private int company;
	private int id;
	private String name;
	private String info;
	private String avatar;	
	private Company comp;
	
	public Staff() {
		// TODO Auto-generated constructor stub
	}

	public Staff(int company, int id, String name, String info, String avatar) {
		super();
		this.company = company;
		this.id = id;
		this.name = name;
		this.info = info;
		this.avatar = avatar;
	}

	public int getCompany() {
		return company;
	}

	public void setCompany(int company) {
		this.company = company;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getInfo() {
		return info;
	}

	public void setInfo(String info) {
		this.info = info;
	}

	public String getAvatar() {
		return avatar;
	}

	public void setAvatar(String avatar) {
		this.avatar = avatar;
	}

	public Company getComp() {
		return comp;
	}

	public void setComp(Company comp) {
		this.comp = comp;
	}

}