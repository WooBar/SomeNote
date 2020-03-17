package com.duanxp.module.dfa;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/**
 * @Description: 初始化敏感词库，将敏感词加入到HashMap中，构建DFA算法模型
 * @Project：test
 * @Author : chenming
 * @Date ： 2014年4月20日 下午2:27:06
 * @version 1.0
 */
public class SensitiveWordInit {

	private String ENCODING = "GBK";

	/**
	 * 全局敏感词
	 */
	public HashMap sensitiveWordMap;
	
	public SensitiveWordInit(){
		super();
	}


	/**
	 * 初始化操作
	 * @return
	 */
	public Map initKeyWord(){
		try {

			//读取敏感词库  构建敏感词set
			Set<String> keyWordSet = readSensitiveWordFile();

			//将敏感词库加入到HashMap中  构建算法集合
			addSensitiveWordToHashMap(keyWordSet);

			//spring获取application，然后application.setAttribute("sensitiveWordMap",sensitiveWordMap);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return sensitiveWordMap;
	}

	/**
	 * 03
	 *
	 *
	 * 读取敏感词库，将敏感词放入HashSet中，构建一个DFA算法模型：<br>
	 * 中 = {
	 *      isEnd = 0
	 *      国 = {<br>
	 *      	 isEnd = 1
	 *           人 = {isEnd = 0
	 *                民 = {isEnd = 1}
	 *                }
	 *           男  = {
	 *           	   isEnd = 0
	 *           		人 = {
	 *           			 isEnd = 1
	 *           			}
	 *           	}
	 *           }
	 *      }
	 *  五 = {
	 *      isEnd = 0
	 *      星 = {
	 *      	isEnd = 0
	 *      	红 = {
	 *              isEnd = 0
	 *              旗 = {
	 *                   isEnd = 1
	 *                  }
	 *              }
	 *      	}
	 *      }
	 * @author chenming
	 * @date 2014年4月20日 下午3:04:20
	 * @param keyWordSet  构建敏感词库
	 * @version 1.0
	 */
	private void addSensitiveWordToHashMap(Set<String> keyWordSet) {

		//初始化敏感词容器，减少扩容操作
		sensitiveWordMap = new HashMap(keyWordSet.size());

		String key = null;  
		Map nowMap = null;
		Map<String, String> newWorMap = null;

		//迭代keyWordSet  set还是一个一个字符串的set集合
		Iterator<String> iterator = keyWordSet.iterator();
		while(iterator.hasNext()){

			//关键词
			key = iterator.next();

			//全局敏感词map
			nowMap = sensitiveWordMap;

			//遍历 关键词长度 次
			for(int i = 0 ; i < key.length() ; i++){
				//转换成char型
				char keyChar = key.charAt(i);
				//获取  charAt 之后的关键词作为key
				Object wordMap = nowMap.get(keyChar);

				//如果存在该key，直接赋值
				if(wordMap != null){
					nowMap = (Map) wordMap;
				}else{

				//不存在则，则构建一个map，同时将isEnd设置为0，因为他不是最后一个
					newWorMap = new HashMap<String,String>();
					newWorMap.put("isEnd", "0");
					//不是最后一个 放的是charAt之后的关键词
					nowMap.put(keyChar, newWorMap);
					nowMap = newWorMap;
				}
				
				if(i == key.length() - 1){
					//最后一个
					nowMap.put("isEnd", "1");
				}
			}
		}
	}

	/**
	 * 02
	 *
	 *
	 * 读取敏感词库（敏感词库可以为文件形式 也可以添加为source文件）中的内容，将内容添加到set集合中（set 唯一 无序）
	 * @author chenming
	 * @date 2014年4月20日 下午2:31:18
	 * @return
	 * @version 1.0
	 * @throws Exception
	 */
	private Set<String> readSensitiveWordFile() throws Exception{
		Set<String> set = null;

		//读取文件  或者直接定义文件，或者查询词库
//		File file = new File("/tomcat/demo/SensitiveWord.txt");
		File file = new File("D://SensitiveWord.txt");
		InputStreamReader read = new InputStreamReader(new FileInputStream(file),ENCODING);
		try {
			//文件流是否存在
			if(file.isFile() && file.exists()){

				set = new HashSet<String>();
				BufferedReader bufferedReader = new BufferedReader(read);
				String txt = null;
				//读取文件，将文件内容放入到set中
				while((txt = bufferedReader.readLine()) != null){
					set.add(txt);
			    }
			}
			else{
				//不存在抛出异常信息
				throw new Exception("敏感词库文件不存在");
			}
		} catch (Exception e) {
			throw e;
		}finally{
			read.close();
		}
		return set;
	}
}
