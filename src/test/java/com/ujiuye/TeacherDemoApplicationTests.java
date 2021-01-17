package com.ujiuye;

import com.ujiuye.mapper.TeacherMapper;
import com.ujiuye.pojo.Teacher;
import org.junit.jupiter.api.Test;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@MapperScan("com.ujiuye.mapper")
class TeacherDemoApplicationTests {

    @Autowired
    private TeacherMapper teacherMapper;

    @Test
    public void testAdd() {
        Teacher teacher=new Teacher();
//        teacher.setId("1");
        teacher.setName("蛋白");
        teacher.setIntro("高级讲师");
        teacherMapper.insert(teacher);

    }

    @Test
    public void testUpdate(){
        Teacher teacher = teacherMapper.selectById("1350617142029991938");
        teacher.setName("大黑");
        teacherMapper.updateById(teacher);
    }

}
