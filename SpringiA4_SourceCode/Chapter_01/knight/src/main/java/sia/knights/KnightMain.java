package sia.knights;

import org.apache.log4j.PropertyConfigurator;
import org.springframework.context.support.
                   ClassPathXmlApplicationContext;

public class KnightMain {

  public static void main(String[] args) throws Exception {
    PropertyConfigurator.configure("D:/Users/HN__T/IdeaProjects/SpringiA4_SourceCode/Chapter_01/knight/log4j.properties");
    ClassPathXmlApplicationContext context =
        new ClassPathXmlApplicationContext(
            "META-INF/spring/minstrel.xml");
    Knight knight = context.getBean(Knight.class);
    knight.embarkOnQuest();
    context.close();
  }

}
