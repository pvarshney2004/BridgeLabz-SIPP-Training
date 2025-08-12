package EmailValidator;

import java.util.*;

public class EmployeeManager {
	List<Employee> employees = new ArrayList<>();
	public void addEmployee(String name, String email) throws Exception {
		Email e = new Email(email);
		e.setEmailAddress(email);
		if(e.isValid()) {
			Employee emp = new Employee();
			emp.setName(name);
			emp.setEmail(e);
			employees.add(emp);
		}
	}
	public void searchByDomain(String domain) throws Exception {
		boolean flag=false;
		for(Employee e : employees) {
			Email dm = e.getEmail();
			String a = getEmailDomain(dm.getEmailAddress());
			if(a.equals(domain)) {
				System.out.println(e);
				flag=true;
			}
		}
		if(!flag) {
			throw new Exception("No employee found");
		}
	}
	public String getEmailDomain(String str){
        return str.substring(str.indexOf("@") + 1);
    }
	
	public static void main(String[] args) throws Exception {
		EmployeeManager obj = new EmployeeManager();
		
		Employee e1 = new Employee();
		e1.setName("Prashant");
		Email e = new Email("prashant@company.com");
		e1.setEmail(e);
		obj.addEmployee(e1.getName(), e.getEmailAddress());
		
		Employee e2 = new Employee();
		e2.setName("PV");
		Email ee = new Email("pv@company.com");
		e2.setEmail(ee);
		obj.addEmployee(e2.getName(), ee.getEmailAddress());
		
		obj.searchByDomain("company.com");
		
	}
}
