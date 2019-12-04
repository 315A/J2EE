package j2ee_project;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.springboot.mapper.MyUserMapper;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = com.springboot.build.Application.class)
public class mappertest {

		@Autowired
	    private MyUserMapper myUserMapper;
		@Test
	    public void DDtestInsert() throws Exception {
	        myUserMapper.getAll();
	        System.out.println("cc"); 
	        System.out.println(myUserMapper.getAll());
	        Assert.assertTrue(myUserMapper.getAll().size()==1);
	    
}
}
