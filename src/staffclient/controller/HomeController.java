package staffclient.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestTemplate;

import staffclient.common.RequestMappingDefine;
import staffclient.model.StaffClient;
import staffclient.service.StaffService;

@Controller
public class HomeController {
	@Autowired
	private StaffService staffService;
	
	List<StaffClient> staffClients = new ArrayList<StaffClient>();
	List<String> sc_departments = new ArrayList<String>(), 
			sc_positions = new ArrayList<String>();

	@RequestMapping(RequestMappingDefine.HOME)
	public String home(ModelMap mm) {

		mm.put("staffs", staffService.getAll());
		mm.put("companies", staffService.getAllCompanies());
		
		return "index";
	}

	/*@RequestMapping(RequestMappingDefine.DETAIL)
	public String detail(@RequestParam int id,ModelMap mm){
		Staff newct = staffService.getDetail(id);
		mm.put("staff", newct);
		return "detail";
	}*/
	
	@RequestMapping(RequestMappingDefine.STAFF_A_COMPANY)
	public String staffsByCompany(@RequestParam("id") int id, ModelMap mm){

		if (id == 0)
			mm.put("staffs", staffService.getAll());
		else 
			mm.put("staffs", staffService.getStaffsByCompany(id));
		
		return "index";
	}


	@RequestMapping(RequestMappingDefine.SEARCH_SERVICE)
	public String searchService(ModelMap mm){

		StaffClient staff = new StaffClient();
		RestTemplate restTemplate = new RestTemplate();
		String uri = "http://localhost:8080/rest.employee.manager.server/service";
		
		staffClients = new ArrayList<StaffClient>();

		String ids = restTemplate.getForObject(uri+"/search/staff-ids", String.class);
		String[] idsArray = ids.split(",");

		for(int i = 0; i < idsArray.length; i++) {

			staff =restTemplate.getForObject(uri+"/search/{id} ", StaffClient.class, idsArray[i]);
			staffClients.add(staff);
		}

		String depts = "", posts="";

		for(StaffClient s : staffClients){
			if(posts.contains(s.getPosition()) == false){
				posts += s.getPosition() + ",";
				sc_positions.add(s.getPosition());
			}
			
			if(depts.contains(s.getDepartment()) == false){
				depts += s.getDepartment() + ",";
				sc_departments.add(s.getDepartment());
			}
		}

		mm.put("staffs", staffClients);
		mm.put("departments", sc_departments);
		mm.put("positions", sc_positions);

		return "search-service";
	}

	@RequestMapping(RequestMappingDefine.SEARCH_SERVICE_SEARCH)
	public String searchServiceSearch(
			@RequestParam("department") String department, 
			@RequestParam("position") String position, ModelMap mm){
		
		List<StaffClient> temp = new ArrayList<StaffClient>();
		//System.out.println("dept = "+department +", post = "+position);

		if(department.equals("All")) 
			department = "";
		if(position.equals("All"))
			position = "";
		
		for(StaffClient s: staffClients){
			if(s.getDepartment().contains(department) && s.getPosition().contains(position))
				temp.add(s);
		}

		/*for(StaffClient s : temp)
			System.out.println("name =" +s.getName());*/
		
		mm.put("staffs", temp);
		mm.put("departments", sc_departments);
		mm.put("positions", sc_positions);
		return "search-service";
	}

	@RequestMapping(RequestMappingDefine.ADD_SERVICE)
	public String addService(@RequestParam("checks") String checks, ModelMap mm){

		List<StaffClient> temp = new ArrayList<StaffClient>();
		String[] checksArray = checks.split(",");

		for(String s : checksArray)
			for(StaffClient sc : staffClients)
				if(s.equals(sc.getId()+"")) {
					temp.add(sc);
					break;
				}

		mm.put("staffs", temp);
		return "add-service";
	}

	@RequestMapping(RequestMappingDefine.INSERT_TO_DB_SERVICE)
	public String insertToDbService(@RequestParam("checks") String checks, ModelMap mm){

		List<StaffClient> temp = new ArrayList<StaffClient>();
		String[] checksArray = checks.split(",");
		int i, n = staffClients.size();
		
		if(checks.equals("")) return "error";

		for(String s : checksArray)
			for(StaffClient sc : staffClients)
				if(s.equals(sc.getId()+"")) {
					temp.add(sc);
					break;
				}

		staffService.insertOrUpdateToDb(temp);
		
		mm.put("staffs", staffService.getAll());
		mm.put("companies", staffService.getAllCompanies());

		return "index";
	}

	@RequestMapping("/delete")
	public String deleteStaff(@RequestParam("id") String id){
		staffService.delete(id.trim());
		return "index";
	}
	 
}