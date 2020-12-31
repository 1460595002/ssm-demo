package cn.jinronga.service.impl;

import cn.jinronga.dao.AccountDao;
import cn.jinronga.domain.Account;
import cn.jinronga.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("accountService")
public class AccountServiceImpl implements AccountService{

    @Autowired
    private AccountDao accountDao;

    public List<Account> findAll() {
        System.out.println("业务层：查询所有账户...");
        List<Account> all = accountDao.findAll();
        System.out.println(all);
        return accountDao.findAll();
    }

    public void saveAccount(Account account) {
        System.out.println("业务层：保存帐户...");
      accountDao.saveAccount(account);

    }
}
