package wen.cmote.cSBM.springboot.server;

import wen.cmote.cSBM.springboot.model.User;

public interface UserServer {
	/**
     * 添加一个用户
     * @param user 用户对象
     * @since 2016年9月21日20:58:17
     * @return 是否添加成功
     */
    public boolean add(User user);
}
