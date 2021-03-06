import java.io.File;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

interface AbstractTransformer {
	public void display();
}
interface  AbstractSource {
	public void display();
}

public class MainClass {
	static Object getBeans(String className) {
		try{
			//创建一个工厂类
			DocumentBuilderFactory df = DocumentBuilderFactory.newInstance();
			//通过工程类new一个DocumentBuilder对象
			DocumentBuilder db = df.newDocumentBuilder();
			//将XML文件作为file对象读取到代码中
			File file = new File("src/config.xml");
			//创建Document对象，并通过DocumentBuilder中的parse方法将XML文件数据流传送到新建的Document对象中
			Document doc;
			doc = db.parse(file);
			
			//获取XML文件中储存的信息
			//创建NodeList类 并通过XML文件中的标签名字读取到内容存放到nList中
			NodeList nList = doc.getElementsByTagName(className);
			//获取值
			Node node = nList.item(0).getFirstChild();
			//值转换为字符串
			String sourceName = node.getNodeValue();
			
			//java反射机制
			//创建对象类
			Class c = Class.forName(sourceName);
			//生成新对象
			Object obj = c.newInstance();
			//返回类
			return obj;
		}
			//没找到类时的抛出异常
		catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	public static void main(String[] args) {
		//创建对象
		AbstractSource source = (AbstractSource)MainClass.getBeans("sourceName");
		XMLTransformer transformer= (XMLTransformer)MainClass.getBeans("transformerName");
		//调用方法
		source.display();
		transformer.display();
		
	}
}