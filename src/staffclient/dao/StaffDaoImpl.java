package staffclient.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import staffclient.model.Company;
import staffclient.model.Staff;
import staffclient.model.StaffClient;

@Repository
@SuppressWarnings("unchecked")
public class StaffDaoImpl implements StaffDao{
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public void check(){
		List<Staff> list = sessionFactory.getCurrentSession().createQuery("from Staff").list();
		System.out.println("size = "+list.size());
		for(Staff s : list)
			System.out.println("comp = "+s.getComp().getName());
	}

	@Override
	public List<Company> findAllCompanies(){

		return sessionFactory.getCurrentSession().createQuery("from Company").list();
	}

	@Override
	public List<Staff> findAll(){

		return sessionFactory.getCurrentSession().createQuery("from Staff").list();
	}

	@Override
	public Staff findDetail(int id){

		List<Staff> list = sessionFactory.getCurrentSession().createQuery("from Staff s where s.id = "+id).list();

		if(list.size() >= 1)
			return list.get(0);
		return null;
	}

	@Override
	public List<Staff> findStaffsByCompany(int id){

		return sessionFactory.getCurrentSession().createQuery("from Staff s where s.company = "+id).list();
	}

	@Override
	public void insertOrUpdateToDb(List<StaffClient> staffs){

		System.out.println("Loading to add staffs into DB ... ");
		for(StaffClient sc : staffs){

			if(isExisted(sc.getName(), sc.getInfo()) == 1) 
				sessionFactory.getCurrentSession().createQuery("UPDATE Staff s set s.avatar = '"+sc.getAvatar()
				+ "' WHERE s.name like '%"+sc.getName()+"%' and s.info like '%"+sc.getInfo()+"%'")
				.executeUpdate();

			else {
				sessionFactory.getCurrentSession().createSQLQuery("INSERT INTO list_staffs.staff(name, company, info, avatar) "
						+ "VALUES ('"+sc.getName()+"', 1, '"+sc.getInfo()+"', '"+sc.getAvatar()+"')")
				.executeUpdate();
			}
		}
	}
	@Override
	public int isExisted(String name, String info){
		List<Staff> list = sessionFactory.getCurrentSession().createQuery("from Staff s where s.name like '%"+name+"%' and s.info like '%"+info+"%'").list();

		if (list.size() > 0){
			System.out.println("Staff "+name+" is existed");
			return 1;
		}
		return 0;
	}

	@Override
	public void delete(String id){
		try{
			sessionFactory.getCurrentSession().createQuery("DELETE from Staff s where s.id = "+id).executeUpdate();
		}catch(Exception ex){
			System.out.println(ex.getMessage());
		}
	}

}
