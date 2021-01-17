package com.ujiuye.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.ujiuye.pojo.Teacher;
import com.ujiuye.pojo.TeacherQuery;
import com.ujiuye.pojo.result.Result;
import com.ujiuye.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/teacher")
public class TeacherController {

    @Autowired
    private TeacherService teacherService;


    //添加讲师
    @PostMapping
    public Result saveTeacher(@RequestBody Teacher teacher){

        boolean b = teacherService.save(teacher);
        if (b){
            return Result.ok();
        }else {
        return Result.error();
        }
    }

    //查询所有的讲师
    @GetMapping
    public Result selectAll(){
        List<Teacher> teachers = teacherService.list(null);
        return Result.ok().data("items",teachers);
    }

    //修改讲师
    @PutMapping("{id}")
    public Result updateById(@PathVariable String id,@RequestBody Teacher teacher){
        teacher.setId(id);
        boolean b = teacherService.updateById(teacher);
        if (b){
            return  Result.ok();
        }else {
            return Result.error();
        }
    }

    //删除讲师
    @DeleteMapping("{id}")
    public  Result deleteById(@PathVariable String id){
        boolean b = teacherService.removeById(id);
        if (b){
            return  Result.ok();
        }else {
            return Result.error();
        }
    }

    //分页查询
    @GetMapping("{pageNum}/{pageSize}")
    public  Result pageList(@PathVariable long pageNum,@PathVariable long pageSize){
        Page<Teacher> page = new Page<>(pageNum,pageSize);
        teacherService.page(page, null);
        //查询某一页的数据
        List<Teacher> list = page.getRecords();
        //查询总记录数
        long total = page.getTotal();
        return Result.ok().data("total",total).data("rows",list);


    }

    //分页条件查询
    @PostMapping("{pageNum}/{pageSize}")
    public  Result pageListQuery(@PathVariable long pageNum, @PathVariable long pageSize, @RequestBody TeacherQuery query){
        Page<Teacher> page = new Page<>(pageNum,pageSize);
        teacherService.pageListQuery(page, query);
        //查询某一页的数据
        List<Teacher> list = page.getRecords();
        //查询总记录数
        long total = page.getTotal();
        return Result.ok().data("total",total).data("rows",list);


    }
}
