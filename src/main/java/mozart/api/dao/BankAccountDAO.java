package mozart.api.dao;

import mozart.api.model.BankAccount;
import mozart.core.db.AbstractDAO;

import org.springframework.stereotype.Component;

@Component
public class BankAccountDAO extends AbstractDAO<BankAccount> {

	@Override
	protected Class<BankAccount> getModel() {
		return BankAccount.class;
	}
}
