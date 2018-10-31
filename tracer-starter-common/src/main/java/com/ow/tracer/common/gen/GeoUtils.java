
package com.ow.tracer.common.gen;



import cn.hutool.core.io.FileUtil;
import com.ow.tracer.common.config.GeneratorConfigUtils;
import com.ow.tracer.common.file.FileGeneration;
import com.ow.tracer.common.gencode.config.DatabaseConfig;
import com.ow.tracer.common.gencode.config.GeneratorConfig;

import java.io.File;
import java.util.regex.Pattern;

/**
 * @author easy
 */
public class GeoUtils {
    //数据库表名前缀
    private static String project="Tracer";
    //数据库表名前缀
    private static String dbTableName="admin";
    //数据库表名前缀
    private static String  functionName="shop";
    //项目模块名
    private static String moudelName="tracer"+"-"+dbTableName+"-"+functionName;
    public static void main(String[] args) {
    FileGeneration.CreateFIle();;

        //第二种 例:
        String[] test2 = {"mapper","dto","rest","service"};
        String path= GeoUtils.getPath("^(?!.*(admin)).*$");

        for(int i=0;i<test2.length;i++){
            GeneratorConfig generatorConfig = new GeneratorConfig();
            generatorConfig.setAuthor("江雪立");
            generatorConfig.setPackageName(moudelName);
            generatorConfig.setFunctionName(functionName);
            generatorConfig.setProjectName(project);
            generatorConfig.setTemplateRoot(FileUtil.getParent(FileUtil.getAbsolutePath(""), 2) + "/src/main/resources/generator/defaultTemplate/SSM" );//使用~代表从classpath读取模板
            generatorConfig.setTemplateId("/${packageName}/"+test2[i]);
            generatorConfig.setOutputPath(path+"/"+moudelName+"-"+test2[i]+"/src/main/java/com/ow/tracer/"+dbTableName+"/"+functionName+"/"+test2[i]);
            DatabaseConfig databaseConfig = new DatabaseConfig();
            String dbName = "tracer";//数据库名
            databaseConfig.setTablePrefix(dbTableName+"_%");
            databaseConfig.setDbUrl("jdbc:mysql://60.208.57.115:10506/tracer?useUnicode=true&characterEncoding=UTF-8&allowMultiQueries=true&&useSSL=false");
            databaseConfig.setDbName("tracer");//设置数据库名
            databaseConfig.setUsername("ruitu");
            databaseConfig.setPassword("ruI115tU");
            GeneratorConfigUtils.batchgencode(generatorConfig,databaseConfig);

        }


    }

    public static  String getPath(String url){

        String path = "";
        String relativelyPath=System.getProperty("user.dir");

        File file=new File(relativelyPath);
        File[] tempList = file.listFiles();


        for (int i = 0; i < tempList.length; i++) {
            if (tempList[i].isFile()) { }
            if (tempList[i].isDirectory()) {
                if(StringMatchRule(tempList[i].getName(),url)==false){
                    path=tempList[i].getPath()+"/"+moudelName;
                    break;
                }
            }
        }

        return path;
    }
    public static  String getProjectPath(String url){

        String path = "";
        String relativelyPath=System.getProperty("user.dir");

        File file=new File(relativelyPath);
        File[] tempList = file.listFiles();


        for (int i = 0; i < tempList.length; i++) {
            if (tempList[i].isFile()) { }
            if (tempList[i].isDirectory()) {
                if(StringMatchRule(tempList[i].getName(),url)==false){
                    path=tempList[i].getPath();
                    break;
                }
            }
        }
        return path;
    }
    public static boolean StringMatchRule(String souce, String regex) {
        boolean result = false;
        if (regex != null && souce != null) {
            result = Pattern.matches(regex, souce);
        }
        return result;
    }

}
