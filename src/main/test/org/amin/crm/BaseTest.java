package org.amin.crm;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @author Amin
 * @Create 2018-11-29 17:23
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class BaseTest {
    @Test
    public void test(){
        Integer i =new Integer(1);
        System.out.println(i==1);
    }
}
