package cn.edu.njnu.domain.ext;

import cn.edu.njnu.domain.Extractable;
import cn.edu.njnu.tools.Pair;

import java.io.*;

/**
 * Created by zhangzhi on 15-12-29.
 * 抽取数据单元之项目类
 */
public class Project extends Extractable {

    @Override
    public void persistData(String location) throws IOException {
        File file = new File("./doc/result/projects/" + location);
        if (!file.exists())
            file.createNewFile();
        try (BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(
                new FileOutputStream(file, true), "UTF-8"))) {

            for (Pair pair : data) {
                bw.write(pair.key + ":" + pair.value);
                bw.newLine();
            }
            System.out.println("抽取了一条项目信息:  " + location);
        }
    }

}
