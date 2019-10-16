package util;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;


public class MyBatisUtils {
    private static SqlSessionFactory build=null;
    private static ThreadLocal<SqlSession> tl = new ThreadLocal<>();
    static{
        try {
            InputStream in = Resources.getResourceAsStream("mybatis-config.xml");
            build = new SqlSessionFactoryBuilder().build(in);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    public static SqlSession openSession(){
        SqlSession ss = tl.get();
        if(ss==null){
            ss=build.openSession();
            tl.set(ss);
        }
        return ss;
    }
    public static void close(SqlSession sqlSession){
        tl.remove();
        sqlSession.close();
    }
}
