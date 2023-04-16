package in.ineuron.servicefactory;

import in.ineuron.service.AdminServiceImpl;
import in.ineuron.service.IAdminService;

public class AdminServiceFactory {
	private AdminServiceFactory() {}
	private static IAdminService adminservice=null;
	public static IAdminService getadminservice() {
		if(adminservice == null) {
			adminservice = new AdminServiceImpl();
		}
		return adminservice;
	}
}
