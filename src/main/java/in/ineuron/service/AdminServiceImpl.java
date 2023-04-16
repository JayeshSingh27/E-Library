package in.ineuron.service;

import in.ineuron.dao.IAdminDao;
import in.ineuron.daofactory.AdminDaoFactory;
import in.ineuron.dto.AdminDto;

public class AdminServiceImpl implements IAdminService {

	private IAdminDao admindao;
	@Override
	public String registeradmin(AdminDto admin) {
		// TODO Auto-generated method stub
		admindao = AdminDaoFactory.getadmindao();
		return admindao.registeradmin(admin);
	}
	
	
}
