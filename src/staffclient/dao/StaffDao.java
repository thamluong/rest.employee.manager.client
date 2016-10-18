package staffclient.dao;

import java.util.List;
import staffclient.model.Company;
import staffclient.model.Staff;
import staffclient.model.StaffClient;

public interface StaffDao {
	
	public void check();
	public List<Company> findAllCompanies();
	public List<Staff> findAll();
	public Staff findDetail(int id);
	public void delete(String id);
	public List<Staff> findStaffsByCompany(int id);
	
	public void insertOrUpdateToDb(List<StaffClient> staffs);
	public int isExisted(String name, String info);
}
