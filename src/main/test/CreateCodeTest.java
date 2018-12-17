import org.amin.crm.utils.EasyuiColumn;
import org.amin.crm.utils.FieldInfo;
import org.apache.velocity.Template;
import org.apache.velocity.VelocityContext;
import org.apache.velocity.app.Velocity;
import org.junit.Test;


import java.io.File;
import java.io.FileWriter;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Amin
 * @Create 2018-12-01 9:39
 */
public class CreateCodeTest {

    //准备公共路径
    public static final String SRC = "src/main/java/";//准备公共的源码路径
    public static final String WEBAPP = "src/main/webapp/";//准备公共的web路劲
    public static final String PACKAGE = "org/amin/crm/";//准备公共的包
    //准备模板
    public static final String[] templates = {"domain.js","DomainController.java","DomainQuery.java",
            "DomainServiceImpl.java","IDomainService.java","page.jsp"};

    //手动拼接路径
    public static final String[] paths = {WEBAPP+"static/js/model/",SRC+PACKAGE+"web/controller/",SRC+PACKAGE+"query/",
            SRC+PACKAGE+"service/impl/",SRC+PACKAGE+"service/",WEBAPP+"WEB-INF/views/domain/"};

    //准备你要生成的模型
    public static final String[] domains = {"SystemLog"};

    private boolean  flag = true;//代表是代码生成器的总开关，如果为false，代表是关闭状态，虽然文件不存在，也不能创建，
    // 如果为true，文件不存在则创建，文件存在在不创建





    //准备生成文件的最终路径

    @Test
    public void testCreateCorder() throws Exception {
        //创建核心对象
        VelocityContext velocityContext = new VelocityContext();
        //循环遍历要生成的模型
        for (int i = 0; i < domains.length; i++) {
            //小写的模型名字(首字母小写)  Dept
            String domain = domains[i].substring(0, 1).toLowerCase() + domains[i].substring(1);
            //大写的模型名字
            String Domain = domains[i];
            //准备数据
            velocityContext.put("domain", domain);
            velocityContext.put("Domain", Domain);
            //放入字段属性
            String className = PACKAGE.replaceAll("/", "\\.")+"domain."+Domain;
            System.out.println(className);
            velocityContext.put("vos", parseClassFiled(className));

            //大写的模型名字(首字母大写)
            for (int j = 0; j < paths.length; j++) {
                //动态获取最终生成文件的路径
                String path = paths[j] + templates[j];
                path = path.replaceFirst("domain", domain).replaceFirst("Domain",Domain );
                File file = new File(path);
                //如果文件存在，则直接跳过本次循环
                if(file.exists() || !flag){
                    continue;
                }
                //获取到需要被合并的模板
                Template template = Velocity.getTemplate("templete/" + templates[j], "UTF-8");

                //如果当前文件对应的父文件夹不存在，则创建它
                if(!file.getParentFile().exists()){
                    file.getParentFile().mkdirs();
                }
                FileWriter fileWriter = new FileWriter(file);
                //开始合并
                template.merge(velocityContext, fileWriter);
                //关闭流
                fileWriter.close();
            }
        }

    }

    /**
     * 解析类中的字段封装成FieldInfo对象
     * @param className
     * @return
     * @throws Exception
     */
    private List<FieldInfo> parseClassFiled(String className) throws Exception{

        List<FieldInfo> list = new ArrayList<>();

        Class c = Class.forName(className);
        //获取所有的field
        Field[] fields = c.getDeclaredFields();
        //遍历所有的field,扫描上面的注解
        for (Field field : fields) {
            //判断是否有注解
            if(field.isAnnotationPresent(EasyuiColumn.class)){
                //获取到注解的title属性值
                EasyuiColumn easyuiColumn = field.getAnnotation(EasyuiColumn.class);
                String title = easyuiColumn.title();
                //获取到字段的名称
                String name = field.getName();
                //封装到一个FiledInfo对象中
                FieldInfo fi = new FieldInfo(name,title);
                //添加到List集合中
                list.add(fi);
            }
        }
        return list;
    }

}
