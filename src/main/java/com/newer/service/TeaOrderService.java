package com.newer.service;


import com.newer.domain.TeaOrder;
import com.newer.util.SqlSessionUtil;
import mapper.TeaOrderMapper;
import org.apache.ibatis.session.SqlSession;

public class TeaOrderService {
    private TeaOrderMapper  teaOrderMapper;
    private SqlSession sqlSession;

    public TeaOrderService() {
        sqlSession = SqlSessionUtil.getSqlSession();
        teaOrderMapper =sqlSession.getMapper(TeaOrderMapper.class);
    }
    public int addOrder(TeaOrder teaOrder) {
        int rows=teaOrderMapper.addOrder(teaOrder);
        sqlSession.commit();
        return  rows;
    }
    public void  close(){
        if (sqlSession!=null){
            SqlSessionUtil.closeSqlSession(sqlSession);
        }
    }
}
