package cn.com.zhirun.ssm0514.dao;

import cn.com.zhirun.ssm0514.model.MemberModel;

import java.util.List;

public interface CMemberModelMapper extends MemberModelMapper{

    public List<MemberModel> selectMembers(MemberModel member);
    public List<MemberModel> selectByIds(String[] ids);

}