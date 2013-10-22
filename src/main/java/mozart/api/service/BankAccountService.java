package mozart.api.service;

import mozart.api.dao.BankAccountDAO;
import mozart.api.model.BankAccount;
import mozart.core.api.Service;
import mozart.core.db.AbstractDAO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class BankAccountService extends Service<BankAccount> {

	@Autowired
	private BankAccountDAO dao;

	@Override
	protected AbstractDAO<BankAccount> getDao() {
		return dao;
	}

	@Override
	protected Class<BankAccount> getModel() {
		return BankAccount.class;
	}

}
