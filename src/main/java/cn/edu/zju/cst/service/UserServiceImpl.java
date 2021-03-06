package cn.edu.zju.cst.service;
import cn.edu.zju.cst.dao.IUserAccountDao;
import cn.edu.zju.cst.dao.IUserDao;
import cn.edu.zju.cst.domain.User;
import cn.edu.zju.cst.domain.UserAccount;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
/**
 * Created by DEAN on 2017/10/26.
 */
@Service("userService")
public class UserServiceImpl implements IUserService{
    @Autowired
    private IUserDao userDao;
    @Autowired
    private IUserAccountDao userAccountDao;
    @Override
    public User getUserById(int id) {
        return userDao.selectUserById(id);
    }
    @Override
    public User getUserByAccountAndPassword(String userAccount, String userPassword) {
        return userDao.selectUserByAccountAndPassword(userAccount,userPassword);
    }
    @Override
    public User getUserByAccount(String userAccount) {
        return userDao.selectUserByAccount(userAccount);
    }
    @Override
    public int setUser(User user) {
        int result1 = userDao.insertUser(user);
        //用户账户信息暂时为默认创建，暂时没有支付接口
        UserAccount userAccount = new UserAccount();
        userAccount.setAccountBalance(50000);
        userAccount.setAccruedInterest(0);
        userAccount.setBankCard("6217003511152584562 农行");
        userAccount.setUserId(userDao.selectUserByAccount(user.getUserAccount()).getId());
        int result2 = userAccountDao.insertUserAccount(userAccount);
        if(result1==1&&result2==1){
            return 0;
        }else{
            return 1;
        }
    }
}