package cn.com.zhirun.ssm0514.service;

import cn.com.zhirun.ssm0514.dao.CMemberModelMapper;
import cn.com.zhirun.ssm0514.dao.MemberModelMapper;
import cn.com.zhirun.ssm0514.model.MemberModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

public interface IMemberService {


    public MemberModel selectByPrimaryKey(Integer id);

    public List<MemberModel> selectMembers(MemberModel member);

    public List<MemberModel> selectByIds(String[] ids);
}

