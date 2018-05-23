package cn.com.zhirun.ssm0514.service.impl;

import cn.com.zhirun.ssm0514.dao.CMemberModelMapper;
import cn.com.zhirun.ssm0514.dao.MemberModelMapper;
import cn.com.zhirun.ssm0514.model.MemberModel;
import cn.com.zhirun.ssm0514.service.IMemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MemberServiceImpl implements IMemberService {

    @Autowired
    MemberModelMapper memberModelMapper;

    @Autowired
    CMemberModelMapper cmemberModelMapper;

    @Override
    public MemberModel selectByPrimaryKey(Integer id){

        return memberModelMapper.selectByPrimaryKey(id);
    }

    @Override
    public List<MemberModel> selectMembers(MemberModel member){

        return cmemberModelMapper.selectMembers(member);
    }

    @Override
    public List<MemberModel> selectByIds(String[] ids){

        return cmemberModelMapper.selectByIds(ids);
    }
}

