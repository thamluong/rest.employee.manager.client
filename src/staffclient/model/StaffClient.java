package staffclient.model;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "staffClient")
public class StaffClient {

	private int id ;	
	private String name;
	private String info;
	private String avatar;
	private String department;
	private String position;

	public StaffClient() {}

	public StaffClient(int id, String name, String info, String avatar, String department, String position) {
		super();
		this.department = department;
		this.id = id;
		this.name = name;
		this.info = info;
		this.avatar = avatar;
		this.position = position;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
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

	public String getPosition() {
		return position;
	}

	public void setPosition(String position) {
		this.position = position;
	}

}

