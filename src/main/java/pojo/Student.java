package pojo;


import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.extension.activerecord.Model;

public class Student extends Model {
  //主键
  @TableId(value = "stuno")
  private int stuNo;
  @TableField(value = "stuname")
  private String stuName;
  @TableField(value = "stuage" )
  private int  stuAge;

  public Student() {

  }

  public Student(String stuName, int stuAge) {
    this.stuName = stuName;
    this.stuAge = stuAge;
  }

  public Student(int stuNo, String stuName, int stuAge) {
    this.stuNo = stuNo;
    this.stuName = stuName;
    this.stuAge = stuAge;
  }




  public int getStuNo() {
    return stuNo;
  }

  public void setStuNo(int stuNo) {
    this.stuNo = stuNo;
  }

  public String getStuName() {
    return stuName;
  }

  public void setStuName(String stuName) {
    this.stuName = stuName;
  }

  public int getStuAge() {
    return stuAge;
  }

  public void setStuAge(int stuAge) {
    this.stuAge = stuAge;
  }
}
