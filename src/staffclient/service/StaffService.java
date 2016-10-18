package staffclient.service;

import java.util.List;

import staffclient.model.StaffClient;
import staffclient.model.Company;
import staffclient.model.Staff;

public interface StaffService {
	
	public void check();
	public List<Company> getAllCompanies();
	public List<Staff> getAll();
	public Staff getDetail(int id);
	public void delete(String id);
	public List<Staff> getStaffsByCompany(int id);

	public void insertOrUpdateToDb(List<StaffClient> staffs);
	public int isExisted(String name, String info);
}
