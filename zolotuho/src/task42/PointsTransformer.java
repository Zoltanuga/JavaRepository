package task42;

import javax.xml.transform.*;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
//напишите программу, преобразующую созданный в предыдущих заданиях файл XML в файл HTML, аналогично данному примеру
//в каждой ячейке дополнительно к коордонате должны выводиться единицы измерения. результат в файл на дискею
public class PointsTransformer {
    public void transform(File pathXML, File pathXSL, File pathHTML) throws TransformerException, FileNotFoundException {
        TransformerFactory transformerFactory = TransformerFactory.newInstance();
        StreamSource streamSource = new StreamSource(pathXSL);
        Templates templates = transformerFactory.newTemplates(streamSource);
        Transformer transformer = templates.newTransformer();
        transformer.transform(new StreamSource(pathXML), new StreamResult(new FileOutputStream(pathHTML)));
    }

    public static void main(String[] args) throws FileNotFoundException {
        File pathXSL = new File("src/task42/task42.xsl");
        File pathXML = new File("src/task42/task42.xml");
        File pathHTML = new File("src/task42/task42.html");
        try {
            PointsTransformer transformer = new PointsTransformer();
            transformer.transform(pathXML, pathXSL, pathHTML);
        } catch (TransformerConfigurationException e) {
            e.printStackTrace();
        } catch (TransformerFactoryConfigurationError e) {
            e.printStackTrace();
        } catch (TransformerException e) {
            e.printStackTrace();
        }
    }
}
