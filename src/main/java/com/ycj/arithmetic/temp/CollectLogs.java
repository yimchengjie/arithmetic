package com.ycj.arithmetic.temp;

import cn.hutool.core.io.FileUtil;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import java.io.File;
import java.nio.charset.StandardCharsets;

/**
 * CollectLogs
 *
 * @author yanchengjie
 * @version CollectLogs.java, 2022/11/17 10:52 yanchengjie
 */
public class CollectLogs {

	private final static String path = "C:\\Users\\yanchengjie\\Desktop\\var\\lib\\docker\\containers";


	private static void getChildPath(String path) {
		File pathFile = new File(path);
		File[] files = pathFile.listFiles();
		assert files != null;
		for (File file : files) {
			String absolutePath = file.getAbsolutePath();
			String[] list = file.list();
			String logFile = null;
			for (String s : list) {
				if (s.contains(file.getName())){
					logFile = s;
				}
			}
			String configV2Path = String.format("%s/config.v2.json",absolutePath);
			if (!FileUtil.exist(configV2Path)) {
				continue;
			}
			String json = FileUtil.readString(configV2Path, StandardCharsets.UTF_8);
			JSONObject jsonObject = JSON.parseObject(json);
			JSONObject config = jsonObject.getJSONObject("Config");
			JSONObject labels = config.getJSONObject("Labels");
			String podNameStr = labels.getString("io.kubernetes.pod.name");
			String format = String.format("%s/%s/%s/", path, podNameStr,file.getName());
			if (logFile!=null) {
				//FileUtil.copy(file,new File(format), true);
				FileUtil.copy(new File(configV2Path),new File(format+"config.v2.json"), true);
				FileUtil.copy(new File(String.format("%s/%s",absolutePath, logFile)),new File(format+logFile), true);
			}
		}

	}

	public static void main(String[] args) {
		getChildPath(path);
	}
}
