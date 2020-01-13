package test;
import	java.awt.print.Pageable;
import	java.lang.annotation.Target;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.mchange.v2.c3p0.ComboPooledDataSource;
import mapper.StudentMapper;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import pojo.Student;

public class Test {
    @org.junit.Test
    public static void testInsert(){
        ApplicationContext ctx=new ClassPathXmlApplicationContext("applicationContext.xml");
        //从ioc中获取xxxMapper对象
        StudentMapper studentMapper=ctx.getBean("studentMapper",StudentMapper.class);
        Student student = new Student(2016512983,"xx",25);
        studentMapper.insert(student);
    }

    public static void testAR(){
        // 必须在ioc容器操作
        ApplicationContext ctx=new ClassPathXmlApplicationContext("applicationContext.xml");
        //增加
//        Student student = new Student(2016512981,"李明宇",25);
//         student.insert();
        //根据主键删除
//        Student student = new Student();
//        student.setStuNo(2016512981);
//        student.deleteById();
        //根据主键更新元素
//        Student student=new Student(2016512981,"李明",24);
//        student.updateById();
    }

    public static void testPage(){
        ApplicationContext ctx=new ClassPathXmlApplicationContext("applicationContext.xml");
        //从ioc中获取xxxMapper对象
        StudentMapper studentMapper=ctx.getBean("studentMapper",StudentMapper.class);
        //如果需要where则需要Wrapper对象
        IPage<Student> page =studentMapper.selectPage(new Page<Student>(2,1),null);
        System.out.println("当前页的数据"+page.getRecords());
        System.out.println("当前页页码"+page.getCurrent());
        System.out.println("总数据量"+page.getTotal());
        System.out.println("每页数据量"+page.getSize());
    }

    public static void testDeleteMap(){
        ApplicationContext ctx=new ClassPathXmlApplicationContext("applicationContext.xml");
        //从ioc中获取xxxMapper对象
        StudentMapper studentMapper=ctx.getBean("studentMapper",StudentMapper.class);
        Map<String,Object> map=new HashMap<String, Object>();
        map.put("stuno","2016512982");
        studentMapper.deleteByMap(map);
    }

     public static void testUpdate(){
        ApplicationContext ctx=new ClassPathXmlApplicationContext("applicationContext.xml");
        //从ioc中获取xxxMapper对象
        StudentMapper studentMapper=ctx.getBean("studentMapper",StudentMapper.class);
        Student student = new Student(2016512983,"vv",44);
        studentMapper.updateById(student);
    }


    public static void testDelete(){
        ApplicationContext ctx=new ClassPathXmlApplicationContext("applicationContext.xml");
        //从ioc中获取xxxMapper对象
        StudentMapper studentMapper=ctx.getBean("studentMapper",StudentMapper.class);
        studentMapper.deleteById("2016512981");
    }
    public static void main(String[] args) throws SQLException {
          //testDelete();
//        testInsert();
        //testDeleteMap();
       // testUpdate();
      //  testAR();
        testPage();
    }
}