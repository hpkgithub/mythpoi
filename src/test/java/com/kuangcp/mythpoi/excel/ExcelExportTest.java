package com.kuangcp.mythpoi.excel;

import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.Assert.assertThat;

import com.kuangcp.mythpoi.utils.Employee;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by https://github.com/kuangcp on 18-2-21  下午10:10
 *
 * @author kuangcp
 */
public class ExcelExportTest {

  private List<Employee> originList = new ArrayList<>();

  @Before
  public void init() {
    Employee e1 = new Employee();
    e1.setQQ("QQ1");
    e1.setNames("Name1");
    e1.setPhone("Phone1");
    e1.setSex("sex1");
    e1.setEmail("email");
    e1.setBirth(new Date());
    e1.setDeath(true);
    e1.setAge(1212);
    e1.setScore(12.1);
    e1.setDeath(false);

    Employee e2 = new Employee();
//        e2.setNames("name2");
    e2.setPhone("phone2");
    e2.setSex("sex2");
    e2.setQQ("QQ2");
    e2.setDeath(false);
    e2.setBirth(new Date());

    Employee e3 = new Employee();
    e3.setNames("name2");
    e3.setPhone("phone2");
    e3.setSex("sex2");
    e3.setQQ("QQ2");
    e3.setBirth(new Date());
    e3.setDeath(false);

    e1.setEmail(
        "[{\"names\":\"Name1\",\"sex\":\"sex1\",\"age\":1212,\"birth\":1532793600000,\"death\":false,\"score\":12.1,\"phone\":\"Phone1\",\"email\":\"\",\"qq\":\"QQ1\"}]");
    e2.setEmail(
        "[{\"names\":\"Name1\",\"sex\":\"sex1\",\"age\":1212,\"birth\":1532793600000,\"death\":false,\"score\":12.1,\"phone\":\"Phone1\",\"email\":\"\",\"qq\":\"QQ1\"}]");
    e3.setEmail(
        "[{\"names\":\"Name1\",\"sex\":\"sex1\",\"age\":1212,\"birth\":1532793600000,\"death\":false,\"score\":12.1,\"phone\":\"Phone1\",\"email\":\"\",\"qq\":\"QQ1\"}]");
    originList.add(e1);
    originList.add(e2);
    originList.add(e3);
  }

  @Test
  public void testExports() {
    boolean results = ExcelExport.exportExcel("/home/kcp/test/employee.xls", originList);
    assertThat(results, equalTo(true));
  }

  @Test
  public void testOut() {
    File f = new File("/home/kcp/test/employee.xls");
    OutputStream out = null;
    try {
      out = new FileOutputStream(f);
    } catch (FileNotFoundException e11) {
      e11.printStackTrace();
    }
    boolean results = ExcelExport.exportExcel(out, originList);
    assertThat(results, equalTo(true));
  }

}