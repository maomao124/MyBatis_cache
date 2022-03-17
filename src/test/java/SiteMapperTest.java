import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Project name(项目名称)：MyBatis缓存
 * Package(包名): PACKAGE_NAME
 * Class(测试类名): SiteMapperTest
 * Author(作者）: mao
 * Author QQ：1296193245
 * GitHub：https://github.com/maomao124/
 * Date(创建日期)： 2022/3/17
 * Time(创建时间)： 16:35
 * Version(版本): 1.0
 * Description(描述)： 测试类
 */

class SiteMapperTest
{

    @Test
    void selectAll() throws IOException
    {
        //读取配置文件mybatis-config.xml
        InputStream config = Resources.getResourceAsStream("mybatis-config.xml");
        //根据配置文件构建SqlSessionFactory
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(config);
        //通过SqlSessionFactory创建SqlSession
        SqlSession sqlSession = sqlSessionFactory.openSession();

        SiteMapper siteMapper = sqlSession.getMapper(SiteMapper.class);
        List<Site> list = siteMapper.selectAll();

        for (Site site : list)
        {
            System.out.println(site);
            System.out.println();
        }

        sqlSession.commit();
        sqlSession.close();
    }
}